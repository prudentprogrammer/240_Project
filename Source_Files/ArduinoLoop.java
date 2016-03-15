protected void loop() {

    // store the current time
    long time = System.currentTimeMillis();
    // send the ping message to the arduino and wait for the pong message
    boolean alive = ping();
    // compute the time interval
    time = System.currentTimeMillis() - time;
    if (alive) {
        System.out.println("Reply from Arduino: time=" + time + "ms");
    } else {
        System.out.println("Request timed out (after " + time + "ms)");
    }
    delay(1000); // wait for a second
}