package android.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public abstract class Property<T, V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.523 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "886C24C67739C97CF77B8DD239E412F9")

    private String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.523 -0400", hash_original_field = "3462A1A18A0EE070E8953CCF1DD788C0", hash_generated_field = "044FCC1E758F4DBF4DDAD38EDF0B8FEE")

    private Class<V> mType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.524 -0400", hash_original_method = "74C6113835E416F987A9EF157CFAA5F3", hash_generated_method = "9BC8D81123C569546DBA273A46924C06")
    public  Property(Class<V> type, String name) {
        mName = name;
        mType = type;
        
        
        
    }

    
    public static <T, V> Property<T, V> of(Class<T> hostType, Class<V> valueType, String name) {
        return new ReflectiveProperty<T, V>(hostType, valueType, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.525 -0400", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "A6C6A5BC68591E6C973F50AC1EC70A50")
    public boolean isReadOnly() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1677059520 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1677059520;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.525 -0400", hash_original_method = "D4D656EA66F575192422159E9E949A42", hash_generated_method = "CF7AF90578EF14A26AC67B01CA9626CA")
    public void set(T object, V value) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Property " + getName() +" is read-only");
        addTaint(object.getTaint());
        addTaint(value.getTaint());
        
        
    }

    
    public abstract V get(T object);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.526 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "4707546506C70AEDA4A1CE601837A224")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_302999802 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_302999802 = mName;
        varB4EAC82CA7396A68D541C85D26508E83_302999802.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_302999802;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.527 -0400", hash_original_method = "016782D9983A30CCA54FD921B5345587", hash_generated_method = "D145CF7C674041C860508726A64A410F")
    public Class<V> getType() {
        Class<V> varB4EAC82CA7396A68D541C85D26508E83_618396903 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_618396903 = mType;
        varB4EAC82CA7396A68D541C85D26508E83_618396903.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_618396903;
        
        
    }

    
}

