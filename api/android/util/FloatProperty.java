package android.util;
import droidsafe.annotations.*;
import droidsafe.helpers.*;
import android.util.Property;

public abstract class FloatProperty<T> extends Property<T, Float> {
    private DSTaintObject taint; 
    
    @DSModeled(DSC.SAFE)
    public FloatProperty(Class clz, String name) {
        //taint.addTaint(name);
        super(Float.class, name);
        taint = new DSTaintObject();
    }
    
	@DSModeled(DSC.SAFE)
    public FloatProperty(String name) {
        //taint.addTaint(name);
        super(Float.class, name);
        taint = new DSTaintObject();
    }
	
	@DSModeled(DSC.SAFE)
    public void setValue(T object, float value) {
        taint.addTaint(value);
    }
    
	@DSModeled(DSC.SAFE)
    @Override
    final public void set(T object, Float value) {
        //setValue(object, value);
        taint.addTaint(value);
    }
}