package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Property;

public abstract class FloatProperty<T> extends Property<T, Float> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.209 -0400", hash_original_method = "C611F784FC0AB047E469B9C497756B38", hash_generated_method = "B299A01648D3B3FD2F82D1FBC441C137")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FloatProperty(String name) {
        super(Float.class, name);
        dsTaint.addTaint(name);
        // ---------- Original Method ----------
    }

    
    public abstract void setValue(T object, float value);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.209 -0400", hash_original_method = "FF9F791AC18CF6EF2052CF8FB1EB0CCC", hash_generated_method = "D2A2428A33F239EA3FFD1D8755ED3DAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    final public void set(T object, Float value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(object.dsTaint);
        setValue(object, value);
        // ---------- Original Method ----------
        //setValue(object, value);
    }

    
}

