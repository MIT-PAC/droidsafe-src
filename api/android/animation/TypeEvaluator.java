package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface TypeEvaluator<T> {

    
    public T evaluate(float fraction, T startValue, T endValue);

}
