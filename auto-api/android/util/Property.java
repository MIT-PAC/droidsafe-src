package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class Property<T, V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.024 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.024 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "044FCC1E758F4DBF4DDAD38EDF0B8FEE")

    private Class<V> mType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.024 -0400", hash_original_method = "74C6113835E416F987A9EF157CFAA5F3", hash_generated_method = "9BC8D81123C569546DBA273A46924C06")
    public  Property(Class<V> type, String name) {
        mName = name;
        mType = type;
        // ---------- Original Method ----------
        //mName = name;
        //mType = type;
    }

    
        public static <T, V> Property<T, V> of(Class<T> hostType, Class<V> valueType, String name) {
        return new ReflectiveProperty<T, V>(hostType, valueType, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.025 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "6608C95FE4BB6F966FB80E4B22D22C9E")
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_932400586 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_932400586;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.025 -0400", hash_original_method = "D4D656EA66F575192422159E9E949A42", hash_generated_method = "CF7AF90578EF14A26AC67B01CA9626CA")
    public void set(T object, V value) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Property " + getName() +" is read-only");
        addTaint(object.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("Property " + getName() +" is read-only");
    }

    
    public abstract V get(T object);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.034 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "6569F5A9156E5B4DF08456F4DD967FB4")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1400316809 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1400316809 = mName;
        varB4EAC82CA7396A68D541C85D26508E83_1400316809.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1400316809;
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:47.038 -0400", hash_original_method = "016782D9983A30CCA54FD921B5345587", hash_generated_method = "E476308F1A12DB5335A6DBC17F1474B2")
    public Class<V> getType() {
        Class<V> varB4EAC82CA7396A68D541C85D26508E83_467962666 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_467962666 = mType;
        varB4EAC82CA7396A68D541C85D26508E83_467962666.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_467962666;
        // ---------- Original Method ----------
        //return mType;
    }

    
}

