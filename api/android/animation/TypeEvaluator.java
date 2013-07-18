package android.animation;

// Droidsafe Imports

public interface TypeEvaluator<T> {

    
    public T evaluate(float fraction, T startValue, T endValue);

}
