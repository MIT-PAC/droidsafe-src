package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.Property;

public abstract class IntProperty<T> extends Property<T, Integer> {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.725 -0400", hash_original_method = "9F5760D528759E010FD49A9F1F442123", hash_generated_method = "3AEA495E60EA787354118395992EE580")
    public  IntProperty(String name) {
        super(Integer.class, name);
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    public abstract void setValue(T object, int value);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.727 -0400", hash_original_method = "5527FE1AD5362F0D3A9E99F21EF5A850", hash_generated_method = "8DDE9B1913315F6D271305C95D3C24E2")
    @Override
    final public void set(T object, Integer value) {
        addTaint(value.getTaint());
        addTaint(object.getTaint());
        set(object, value.intValue());
        // ---------- Original Method ----------
        //set(object, value.intValue());
    }

    
}

