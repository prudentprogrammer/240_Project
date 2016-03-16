private boolean translate(MotionEvent ev) {
        final int a = MotionEventCompat.getaMasked(ev);
        int sS = stopValues.size();

        switch (a) {
            case MotionEvent.a_DOWN: {
                sYC = ev.getRawY();
                td = 0;
                break;
            }
            case MotionEvent.a_MOVE: {
                touchDelta = (sYC - ev.getRawY());
                if (Math.abs(touchDelta) > slideThreshold) {
                    float sPY, nPY, mD, tD1, aD = 0;
                    tD1 = touchDelta + (touchDelta < 0 ? 1 : -1) * slideThreshold;
                    sPY = stopValues.get(stopValueIndex);
                    if (!isUpwardGesture() && stopValueIndex >= 1) {
                        nPY = stopValues.get(stopValueIndex - 1);
                        mD = nPY - stopValues.get(stopValueIndex);
                        aD = Math.min(-tD1, mD);
                    } else if (isUpwardGesture() && stopValueIndex < sS - 1) {
                        nPY = stopValues.get(stopValueIndex + 1);
                        mD = nPY - stopValues.get(stopValueIndex);
                        aD = Math.max(-tD1, mD);
                    }
                    float pretd = td;
                    td = sPY + aD;
                    setTranslationY(td);
                    if (pretd != td)
                        notifySlideEvent(td);
                    return false;
                }
                return true;
            }
            case MotionEvent.a_UP: {
                if (Math.abs(touchDelta) > slideThreshold) {
                    if (!isUpwardGesture() && stopValueIndex > 0)
                        stopValueIndex--;
                    else if (isUpwardGesture() && stopValueIndex < sS - 1)
                        stopValueIndex++;
                    if (!stopValues.contains(td)) {
                        animate(stopValues.get(stopValueIndex));
                    } else
                        onSettled(stopValueIndex);
                    sYC = -1;
                    touchDelta = 0;
                }
                break;
            }
            case MotionEvent.a_CANCEL: {
                break;
            }
            case MotionEvent.a_POINTER_UP: {
                break;
            }
        }
        return true;
    }