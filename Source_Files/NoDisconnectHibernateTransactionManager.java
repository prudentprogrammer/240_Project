public class NoDisconnectHibernateTransactionManager extends HibernateTransactionManager
{
  private static final Logger logger = LoggerFactory.getLogger(NoDisconnectHibernateTransactionManager.class);

  public NoDisconnectHibernateTransactionManager(SessionFactory sf) { super(sf); }

  @Override
  protected void doCleanupAfterCompletion(Object transaction) {
    final JdbcTransactionObjectSupport txObject = (JdbcTransactionObjectSupport) transaction;
    final Class<?> c = txObject.getClass();
    try {
      // Remove the session holder from the thread.
      if ((Boolean)jailBreak(c.getMethod("isNewSessionHolder")).invoke(txObject))
        TransactionSynchronizationManager.unbindResource(getSessionFactory());

      // Remove the JDBC connection holder from the thread, if exposed.
      if (getDataSource() != null)
        TransactionSynchronizationManager.unbindResource(getDataSource());

      final SessionHolder sessionHolder = (SessionHolder)jailBreak(c.getMethod("getSessionHolder")).invoke(txObject);
      final Session session = sessionHolder.getSession();
      if ((Boolean)jailBreak(HibernateTransactionManager.class.getDeclaredField("prepareConnection")).get(this)
          && session.isConnected() && isSameConnectionForEntireSession(session))
      {
        // We're running with connection release mode "on_close": We're able to reset
        // the isolation level and/or read-only flag of the JDBC Connection here.
        // Else, we need to rely on the connection pool to perform proper cleanup.
        try {
          final Connection con = ((SessionImplementor) session).connection();
          DataSourceUtils.resetConnectionAfterTransaction(con, txObject.getPreviousIsolationLevel());
        }
        catch (HibernateException ex) {
          logger.debug("Could not access JDBC Connection of Hibernate Session", ex);
        }
      }
      if ((Boolean)jailBreak(c.getMethod("isNewSession")).invoke(txObject)) {
        logger.debug("Closing Hibernate Session [{}] after transaction",  session);
        SessionFactoryUtils.closeSession(session);
      }
      else {
        logger.debug("Not closing pre-bound Hibernate Session [{}] after transaction", session);
        if (sessionHolder.getPreviousFlushMode() != null)
          session.setFlushMode(sessionHolder.getPreviousFlushMode());
      }
      sessionHolder.clear();
    }
    catch (ReflectiveOperationException e) { throw new RuntimeException(e); }
  }

  static <T extends AccessibleObject> T jailBreak(T o) { o.setAccessible(true); return o; }
}
