package tokyo.tommykw.easing.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tommy on 2016/03/19.
 */
public abstract class EasingCoreImpl implements EasingCore<Number> {
    protected float duration;
    private List<EasingListener> listeners = new ArrayList<>();

    public interface EasingListener {
        void onCall(float time, float value, float start, float end, float duration);
    }

    public EasingCoreImpl(float duration) {
        this.duration = duration;
    }

    @Override
    public Number evaluate(float fraction, Number start, Number end) {
        final float f = duration * fraction;
        final float b = start.floatValue();
        final float c = end.floatValue() - start.floatValue();
        final float d = duration;
        final float result = calculate(f, b, c, d);
        for (EasingListener listener : listeners) {
            listener.onCall(f, result, b, c, d);
        }
        return result;
    }

    public abstract Float calculate(float fraction, float start, float end, float duration);

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public void addEasingListener(EasingListener listener) {
        listeners.add(listener);
    }

    public void addEasingListener(List<EasingListener> listeners) {
        this.listeners.addAll(listeners);
    }

    public void addEasingListener(EasingListener... listeners) {
        this.listeners.addAll(Arrays.asList(listeners));
    }

    public void removeEasingListener(EasingListener listener) {
        listeners.remove(listener);
    }

    public void removeEasingListeners(List<EasingListener> listeners) {
        this.listeners.removeAll(listeners);
    }

    public void removeEasingListeners(EasingListener... listeners) {
        this.listeners.removeAll(Arrays.asList(listeners));
    }

    public void clearEasingListeners() {
        listeners.clear();
    }
}
