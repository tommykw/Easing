package tokyo.tommykw.easing.core;

/**
 * Created by tommy on 2016/03/19.
 */
public interface EasingCore<T> {
    T evaluate(float fraction, T start, T end);
}
