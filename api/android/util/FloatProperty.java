package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.Property;

public abstract class FloatProperty<T> extends Property<T, Float> {
    
    @DSModeled(DSC.SAFE)
    public FloatProperty(String name) {
        super(Float.class, name);
    }

    
    @DSModeled(DSC.SAFE)
    public void setValue(T object, float value) {
        addTaint(value);
    }

    
    @DSModeled(DSC.SAFE)
    @Override
    final public void set(T object, Float value) {
        //setValue(object, value);
        addTaint(value.getTaint());
    }

    
    // orphaned legacy method
    @DSModeled(DSC.SAFE)
    public FloatProperty(Class clz, String name) {
        //addTaint(name.getTaint());
        super(Float.class, name);
        addTaint(name.getTaint());
    }
    
}

