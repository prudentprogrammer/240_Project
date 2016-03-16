private boolean translate(MotionEvent ev) {
        final int action = MotionEventCompat.getActionMasked(ev);
        int stepSize = stopValues.size();

        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                startYCoordinate = ev.getRawY();
                translated = 0;
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                touchDelta = (startYCoordinate - ev.getRawY());
                if (Math.abs(touchDelta) > slideThreshold) {
                    float startingPointY, nextPointY, maxDiff, tempDelta, auxDelta = 0;
                    tempDelta = touchDelta + (touchDelta < 0 ? 1 : -1) * slideThreshold;
                    startingPointY = stopValues.get(stopValueIndex);
                    if (!isUpwardGesture() && stopValueIndex >= 1) {
                        nextPointY = stopValues.get(stopValueIndex - 1);
                        maxDiff = nextPointY - stopValues.get(stopValueIndex);
                        auxDelta = Math.min(-tempDelta, maxDiff);
                    } else if (isUpwardGesture() && stopValueIndex < stepSize - 1) {
                        nextPointY = stopValues.get(stopValueIndex + 1);
                        maxDiff = nextPointY - stopValues.get(stopValueIndex);
                        auxDelta = Math.max(-tempDelta, maxDiff);
                    }
                    float preTranslated = translated;
                    translated = startingPointY + auxDelta;
                    setTranslationY(translated);
                    if (preTranslated != translated)
                        notifySlideEvent(translated);
                    return false;
                }
                return true;
            }
            case MotionEvent.ACTION_UP: {
                if (Math.abs(touchDelta) > slideThreshold) {
                    if (!isUpwardGesture() && stopValueIndex > 0)
                        stopValueIndex--;
                    else if (isUpwardGesture() && stopValueIndex < stepSize - 1)
                        stopValueIndex++;
                    if (!stopValues.contains(translated)) {
                        animate(stopValues.get(stopValueIndex));
                    } else
                        onSettled(stopValueIndex);
                    startYCoordinate = -1;
                    touchDelta = 0;
                }
                break;
            }
            case MotionEvent.ACTION_CANCEL: {
                break;
            }
            case MotionEvent.ACTION_POINTER_UP: {
                break;
            }
        }
        return true;
    }