package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Property;

public abstract class IntProperty<T> extends Property<T, Integer> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.211 -0400", hash_original_method = "9F5760D528759E010FD49A9F1F442123", hash_generated_method = "E902C7C10C0733BDA3CDADEE707EF979")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IntProperty(String name) {
        super(Integer.class, name);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
    }

    
    public abstract void setValue(T object, int value);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.211 -0400", hash_original_method = "5527FE1AD5362F0D3A9E99F21EF5A850", hash_generated_method = "E44415C1BA34EB59F389D46EF70A5804")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    final public void set(T object, Integer value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(object.dsTaint);
        set(object, value.intValue());
        // ---------- Original Method ----------
        //set(object, value.intValue());
    }

    
}

