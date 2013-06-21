package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

class MapEntry<K, V> implements Map.Entry<K, V>, Cloneable {
    K key;
    V value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.908 -0400", hash_original_method = "1776FA5E19E8D82B200F9151CF90A74A", hash_generated_method = "8156EFD8597848C18A5A30F97D4C252F")
    @DSModeled(DSC.SAFE)
     MapEntry(K theKey) {
        dsTaint.addTaint(theKey.dsTaint);
        // ---------- Original Method ----------
        //key = theKey;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.908 -0400", hash_original_method = "D494BFA0BCF5AB6B3E53FE04C11D2F42", hash_generated_method = "7ABFE299B2E45D0F15DC000B4E7EA24B")
    @DSModeled(DSC.SAFE)
     MapEntry(K theKey, V theValue) {
        dsTaint.addTaint(theKey.dsTaint);
        dsTaint.addTaint(theValue.dsTaint);
        // ---------- Original Method ----------
        //key = theKey;
        //value = theValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.908 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "4DE6BDC3CD2A556209C36988D99D74F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        try 
        {
            Object varDEB570B566DA7549E2F197D0AFA5A2B6_740261308 = (super.clone());
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.908 -0400", hash_original_method = "5E665954E6171F76B6FD9130152FC1D9", hash_generated_method = "F3A07E70E648F3B950B6C4A70B2FF550")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        {
            Map.Entry<?, ?> entry;
            entry = (Map.Entry<?, ?>) object;
            boolean varA968BD7EB7991BA4A759E0255BB341DA_132756953 = ((key == null ? entry.getKey() == null : key.equals(entry
                    .getKey()))
                    && (value == null ? entry.getValue() == null : value
                            .equals(entry.getValue()))); //DSFIXME:  CODE0008: Nested ternary operator in expression
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (this == object) {
            //return true;
        //}
        //if (object instanceof Map.Entry) {
            //Map.Entry<?, ?> entry = (Map.Entry<?, ?>) object;
            //return (key == null ? entry.getKey() == null : key.equals(entry
                    //.getKey()))
                    //&& (value == null ? entry.getValue() == null : value
                            //.equals(entry.getValue()));
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.909 -0400", hash_original_method = "5E645FD309BBB0570D297FB3EAF41FB1", hash_generated_method = "72E8E211F4CBB9A3E7EA7C601BF9517D")
    @DSModeled(DSC.SAFE)
    public K getKey() {
        return (K)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return key;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.909 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "1716B03F3EEDEC9A8CDFDC8FCC55E236")
    @DSModeled(DSC.SAFE)
    public V getValue() {
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.909 -0400", hash_original_method = "6416487D313DFCFD3052C01ADB883217", hash_generated_method = "671E95AFC44670C253A299A795BD93D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var405BA182403049FF248011FD048FE4C0_1748511633 = ((key == null ? 0 : key.hashCode())
                ^ (value == null ? 0 : value.hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (key == null ? 0 : key.hashCode())
                //^ (value == null ? 0 : value.hashCode());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.909 -0400", hash_original_method = "123DAF07FFBE76C8EE5BD5879EB92827", hash_generated_method = "6C04AFB63E89CDE7EFCF5132A9B136AE")
    @DSModeled(DSC.SAFE)
    public V setValue(V object) {
        dsTaint.addTaint(object.dsTaint);
        V result;
        result = value;
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        //V result = value;
        //value = object;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.909 -0400", hash_original_method = "D7D954865532EB22F9DFE06F79F78E27", hash_generated_method = "4002110D0218F85825FBB09C78ED072B")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return key + "=" + value;
    }

    
    interface Type<RT, KT, VT> {
        RT get(MapEntry<KT, VT> entry);
    }
    
}

