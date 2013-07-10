package android.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.util.Property;

public abstract class IntProperty<T> extends Property<T, Integer> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.318 -0400", hash_original_method = "9F5760D528759E010FD49A9F1F442123", hash_generated_method = "3AEA495E60EA787354118395992EE580")
    public  IntProperty(String name) {
        super(Integer.class, name);
        addTaint(name.getTaint());
        
    }

    
    public abstract void setValue(T object, int value);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.319 -0400", hash_original_method = "5527FE1AD5362F0D3A9E99F21EF5A850", hash_generated_method = "95C586984797D8D71BD00B69EEFECCAF")
    @Override
    final public void set(T object, Integer value) {
        set(object, value.intValue());
        addTaint(object.getTaint());
        addTaint(value.getTaint());
        
        
    }

    
}

