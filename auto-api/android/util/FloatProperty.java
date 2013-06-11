package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.util.Property;

public abstract class FloatProperty<T> extends Property<T, Float> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.608 -0400", hash_original_method = "C611F784FC0AB047E469B9C497756B38", hash_generated_method = "70DB3A20A8B49A7B5FC897BFDB3A07DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FloatProperty(String name) {
        super(Float.class, name);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
    }

    
    public abstract void setValue(T object, float value);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.608 -0400", hash_original_method = "FF9F791AC18CF6EF2052CF8FB1EB0CCC", hash_generated_method = "9CDBFAD1687F5FF56B4929AF42244DE6")
    @DSModeled(DSC.SAFE)
    @Override
    final public void set(T object, Float value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(object.dsTaint);
        setValue(object, value);
        // ---------- Original Method ----------
        //setValue(object, value);
    }

    
}


