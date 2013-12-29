package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public abstract class FloatProperty<T> extends Property<T, Float> {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:34.841 -0500", hash_original_method = "C611F784FC0AB047E469B9C497756B38", hash_generated_method = "F5D54401A2379DC56F8517CAB7176EA7")
    public FloatProperty(String name) {
        super(Float.class, name);
    }

    
    // orphaned legacy method
    @DSModeled(DSC.SAFE)
    public FloatProperty(Class clz, String name) {
        //addTaint(name.getTaint());
        super(Float.class, name);
        addTaint(name.getTaint());
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
    
}

