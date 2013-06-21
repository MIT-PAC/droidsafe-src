package android.animation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface TypeEvaluator<T> {

    
    public T evaluate(float fraction, T startValue, T endValue);

}
