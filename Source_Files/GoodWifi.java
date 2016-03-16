 public static boolean isWifi(Context context) {
    ConnectivityManager cm = (ConnectivityManager) context
            .getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo networkINfo = cm.getActiveNetworkInfo();
    if (networkINfo != null
            && networkINfo.getType() == ConnectivityManager.TYPE_WIFI) {
        return true;
    }
    return false;
}