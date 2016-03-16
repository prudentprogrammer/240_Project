// Descriptive Comment 1
// Descriptive Comment 2
public void start(long postion) {
        if (h==null) {
            prepare();
        }else{
            h.removeCallbacksAndMessages(null);
        }
        h.obtainMessage(Drawh.START, postion).sendToTarget();
    }