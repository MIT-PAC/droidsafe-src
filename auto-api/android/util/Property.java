package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public abstract class Property<T, V> {
    private final String mName;
    private final Class<V> mType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.659 -0400", hash_original_method = "74C6113835E416F987A9EF157CFAA5F3", hash_generated_method = "B52BE3D809136DEAB9FA16EF54EE65D6")
    @DSModeled(DSC.SAFE)
    public Property(Class<V> type, String name) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(type.dsTaint);
        // ---------- Original Method ----------
        //mName = name;
        //mType = type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.659 -0400", hash_original_method = "0CA4226127E9536CCAF6270256C23524", hash_generated_method = "F2CD846E5F32F591E2832C14E1788542")
    public static <T, V> Property<T, V> of(Class<T> hostType, Class<V> valueType, String name) {
        return new ReflectiveProperty<T, V>(hostType, valueType, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.659 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "D23D2B4F73515B66CAEDED63B92079BD")
    @DSModeled(DSC.SAFE)
    public boolean isReadOnly() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.659 -0400", hash_original_method = "D4D656EA66F575192422159E9E949A42", hash_generated_method = "70B20FB703C24C4211D3C578D76C6EBD")
    @DSModeled(DSC.SAFE)
    public void set(T object, V value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(object.dsTaint);
        throw new UnsupportedOperationException("Property " + getName() +" is read-only");
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("Property " + getName() +" is read-only");
    }

    
    public abstract V get(T object);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.659 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "5B64F8F5AC7FE997D96CC003BA212E34")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.659 -0400", hash_original_method = "016782D9983A30CCA54FD921B5345587", hash_generated_method = "77220B019D2BA38FE27146D3541AFF33")
    @DSModeled(DSC.SAFE)
    public Class<V> getType() {
        return (Class<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mType;
    }

    
}


