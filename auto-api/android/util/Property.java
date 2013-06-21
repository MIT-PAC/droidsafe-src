package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class Property<T, V> {
    private String mName;
    private Class<V> mType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.317 -0400", hash_original_method = "74C6113835E416F987A9EF157CFAA5F3", hash_generated_method = "A41F76336052A65F209937A950BCFD70")
    @DSModeled(DSC.SAFE)
    public Property(Class<V> type, String name) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(type.dsTaint);
        // ---------- Original Method ----------
        //mName = name;
        //mType = type;
    }

    
        public static <T, V> Property<T, V> of(Class<T> hostType, Class<V> valueType, String name) {
        return new ReflectiveProperty<T, V>(hostType, valueType, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.317 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "B39B54BF66CD868E7DFE476A22460D6C")
    @DSModeled(DSC.SAFE)
    public boolean isReadOnly() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.317 -0400", hash_original_method = "D4D656EA66F575192422159E9E949A42", hash_generated_method = "69A7BB3638721254DDE9A7C13F18C252")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void set(T object, V value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(object.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Property " + getName() +" is read-only");
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("Property " + getName() +" is read-only");
    }

    
    public abstract V get(T object);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.318 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "1698AF415E3250D582962C1A88D4A564")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.318 -0400", hash_original_method = "016782D9983A30CCA54FD921B5345587", hash_generated_method = "10A314F678A153689E23ACA394EDD4F7")
    @DSModeled(DSC.SAFE)
    public Class<V> getType() {
        return (Class<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mType;
    }

    
}

