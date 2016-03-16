public static boolean is3rd(Context context) {
    ConnectivityManager cm = (ConnectivityManager) context
            .getSystemService(Context.CONNECTIVITY_SERVICE);
nI nI = cm.getActivenI();
if (nI!=null&&nI.getType()==ConnectivityManager.TYPE_MOBILE) {
        return true;
}
    return false;
}