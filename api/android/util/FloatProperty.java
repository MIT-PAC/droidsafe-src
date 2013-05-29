package android.util;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public abstract class FloatProperty<T> extends Property<T, Float> {
    
    @DSModeled(DSC.SAFE)
    public FloatProperty(Class clz, String name) {
        //dsTaint.addTaint(name);
        super(Float.class, name);
        dsTaint.addTaint(name);
    }
    
	@DSModeled(DSC.SAFE)
    public FloatProperty(String name) {
        super(Float.class, name);
    }
	
	@DSModeled(DSC.SAFE)
    public void setValue(T object, float value) {
        dsTaint.addTaint(value);
    }
    
	@DSModeled(DSC.SAFE)
    @Override
    final public void set(T object, Float value) {
        //setValue(object, value);
        dsTaint.addTaint(value);
    }
}