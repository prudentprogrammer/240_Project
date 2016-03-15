protected void loop() {

    // store the current time
    long t = System.currentTimeMillis();
    boolean a = ping();
    t = System.currentTimeMillis() - time;
    if (a) {
        System.out.println("Reply from Arduino: time=" + time + "ms");
    } else {
        System.out.println("Request timed out (after " + time + "ms)");
    }
    delay(1000); // wait for a second
}