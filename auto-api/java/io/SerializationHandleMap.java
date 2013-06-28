package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class SerializationHandleMap {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.044 -0400", hash_original_field = "14F802E1FBA977727845E8872C1743A7", hash_generated_field = "3812BADF0A98B0817D55431A2E260B33")

    private Object[] keys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.044 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "C452AC6E135820F60F49205B6624FDFE")

    private int[] values;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.044 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.044 -0400", hash_original_field = "F0598264A691A8F62272ACA0E79AF374", hash_generated_field = "831F8FC1A32CF07BE696149BB6AEA9AA")

    private int threshold;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.044 -0400", hash_original_method = "A15E80CA3FF7B3935AD371814D8F0A08", hash_generated_method = "64C0BD6F1288C840DCFEF54577B8DC08")
    public  SerializationHandleMap() {
        this.size = 0;
        this.threshold = 21;
        int arraySize = (int) (((long) threshold * 10000) / LOAD_FACTOR);
        resizeArrays(arraySize);
        // ---------- Original Method ----------
        //this.size = 0;
        //this.threshold = 21;
        //int arraySize = (int) (((long) threshold * 10000) / LOAD_FACTOR);
        //resizeArrays(arraySize);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.045 -0400", hash_original_method = "E316A93A87558F399ED4EA2FE7F26EE8", hash_generated_method = "D71DFD6153E5DD6273AF20DA64D8F8FA")
    private void resizeArrays(int newSize) {
        Object[] oldKeys = keys;
        int[] oldValues = values;
        this.keys = new Object[newSize];
        this.values = new int[newSize];
        {
            {
                int i = 0;
                {
                    Object key = oldKeys[i];
                    int value = oldValues[i];
                    int index = findIndex(key, keys);
                    keys[index] = key;
                    values[index] = value;
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //Object[] oldKeys = keys;
        //int[] oldValues = values;
        //this.keys = new Object[newSize];
        //this.values = new int[newSize];
        //if (oldKeys != null) {
            //for (int i = 0; i < oldKeys.length; ++i) {
                //Object key = oldKeys[i];
                //int value = oldValues[i];
                //int index = findIndex(key, keys);
                //keys[index] = key;
                //values[index] = value;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.045 -0400", hash_original_method = "72EE0757674E1412A0DE2CCEADDB9C34", hash_generated_method = "8CDB823E6E7BC60FD8DC1C6E4E674594")
    public int get(Object key) {
        int index = findIndex(key, keys);
        addTaint(key.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_484733666 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_484733666;
        // ---------- Original Method ----------
        //int index = findIndex(key, keys);
        //if (keys[index] == key) {
            //return values[index];
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.046 -0400", hash_original_method = "188F67866E8CBA269C0CFF587B29CD3B", hash_generated_method = "F920A36C61CA49249CF0BD7F75CA6A30")
    private int findIndex(Object key, Object[] array) {
        int length = array.length;
        int index = getModuloHash(key, length);
        int last = (index + length - 1) % length;
        {
            index = (index + 1) % length;
        } //End block
        addTaint(key.getTaint());
        addTaint(array[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1026858784 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1026858784;
        // ---------- Original Method ----------
        //int length = array.length;
        //int index = getModuloHash(key, length);
        //int last = (index + length - 1) % length;
        //while (index != last) {
            //if (array[index] == key || array[index] == null) {
                //break;
            //}
            //index = (index + 1) % length;
        //}
        //return index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.046 -0400", hash_original_method = "CEF876F6D496A0BEC63D43E9A8B9FA0E", hash_generated_method = "DF47F1C9B409F8322607E2A023A892DC")
    private int getModuloHash(Object key, int length) {
        int varB7FF8F86D856E985C7144D095E72AFAB_1170660312 = ((System.identityHashCode(key) & 0x7FFFFFFF) % length);
        addTaint(key.getTaint());
        addTaint(length);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_857945339 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_857945339;
        // ---------- Original Method ----------
        //return (System.identityHashCode(key) & 0x7FFFFFFF) % length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.047 -0400", hash_original_method = "F8012E326D1DCEC3988D8313DECC50DD", hash_generated_method = "7EE310D483BC10B2BF3B4F94959FD42A")
    public int put(Object key, int value) {
        Object _key = key;
        int _value = value;
        int index = findIndex(_key, keys);
        {
            {
                rehash();
                index = findIndex(_key, keys);
            } //End block
            keys[index] = _key;
            values[index] = -1;
        } //End block
        int result = values[index];
        values[index] = _value;
        addTaint(key.getTaint());
        addTaint(value);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1288881546 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1288881546;
        // ---------- Original Method ----------
        //Object _key = key;
        //int _value = value;
        //int index = findIndex(_key, keys);
        //if (keys[index] != _key) {
            //if (++size > threshold) {
                //rehash();
                //index = findIndex(_key, keys);
            //}
            //keys[index] = _key;
            //values[index] = -1;
        //}
        //int result = values[index];
        //values[index] = _value;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.048 -0400", hash_original_method = "B0944A4627DD585C58C4A846FDB51A94", hash_generated_method = "F569FDAC8A3EA0813CC85B292BA24007")
    private void rehash() {
        int newSize = keys.length * 2;
        resizeArrays(newSize);
        threshold = (int) ((long) (keys.length) * LOAD_FACTOR / 10000);
        // ---------- Original Method ----------
        //int newSize = keys.length * 2;
        //resizeArrays(newSize);
        //threshold = (int) ((long) (keys.length) * LOAD_FACTOR / 10000);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.048 -0400", hash_original_method = "A55090ECB6D90893D6737F77075A1229", hash_generated_method = "9A2834C22DBF8C19C5D648A8834A6685")
    public int remove(Object key) {
        boolean hashedOk;
        int index;
        int next;
        int hash;
        int result;
        Object object;
        index = next = findIndex(key, keys);
        result = values[index];
        int length = keys.length;
        {
            next = (next + 2) % length;
            object = keys[next];
            hash = getModuloHash(object, length);
            hashedOk = hash > index;
            {
                hashedOk = hashedOk || (hash <= next);
            } //End block
            {
                hashedOk = hashedOk && (hash <= next);
            } //End block
            {
                keys[index] = object;
                values[index] = values[next];
                index = next;
            } //End block
        } //End block
        keys[index] = null;
        values[index] = -1;
        addTaint(key.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_110331033 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_110331033;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.049 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "4491D99998BDB0A64143E5C098ABA06F")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_920411308 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_920411308;
        // ---------- Original Method ----------
        //return size == 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.049 -0400", hash_original_field = "F25EAB9F3CA9F63E2E68F9508E0B1FB6", hash_generated_field = "EC54E60FA2CF8632B6202FE74DE20CF3")

    private static final int LOAD_FACTOR = 7500;
}

