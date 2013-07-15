package android.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.util.Property;

public abstract class FloatProperty<T> extends Property<T, Float> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.314 -0400", hash_original_method = "C611F784FC0AB047E469B9C497756B38", hash_generated_method = "4B599EE0663C83251DD6D1A7078B7C0F")
    public  FloatProperty(String name) {
        super(Float.class, name);
        addTaint(name.getTaint());
        
    }

    
    public abstract void setValue(T object, float value);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.314 -0400", hash_original_method = "FF9F791AC18CF6EF2052CF8FB1EB0CCC", hash_generated_method = "BFBD9620F1F3936B379BF806019937C1")
    @Override
    final public void set(T object, Float value) {
        setValue(object, value);
        addTaint(object.getTaint());
        addTaint(value.getTaint());
        
        
    }

    
}

