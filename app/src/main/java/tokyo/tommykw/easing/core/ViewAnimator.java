package tokyo.tommykw.easing.core;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.os.Handler;
import android.os.Message;

/**
 * Created by tommy on 2016/03/19.
 */
public class ViewAnimator extends Animator {
    private static final long DEFAULT_FRAME_DELAY = 10;
    private static final int ANIMATION_START = 1 << 1;
    private static final int ANIMATION_FRAME = 1 << 2;
    private static final int STOPPED = 1 << 3;
    private static final int RUNNING = 1 << 4;
    private static final int SEEKED = 1 << 5;

    private long startTime;
    private long seekTime = -1;

    @Override
    public long getStartDelay() {
        return 0;
    }

    @Override
    public void setStartDelay(long startDelay) {

    }

    @Override
    public Animator setDuration(long duration) {
        return null;
    }

    @Override
    public long getDuration() {
        return 0;
    }

    @Override
    public void setInterpolator(TimeInterpolator value) {

    }

    @Override
    public boolean isRunning() {
        return false;
    }

    private static class AnimationHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            boolean callAgain = true;
        }
    }
}
