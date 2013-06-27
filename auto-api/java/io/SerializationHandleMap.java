package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class SerializationHandleMap {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.893 -0400", hash_original_field = "14F802E1FBA977727845E8872C1743A7", hash_generated_field = "3812BADF0A98B0817D55431A2E260B33")

    private Object[] keys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.893 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "C452AC6E135820F60F49205B6624FDFE")

    private int[] values;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.893 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.893 -0400", hash_original_field = "F0598264A691A8F62272ACA0E79AF374", hash_generated_field = "831F8FC1A32CF07BE696149BB6AEA9AA")

    private int threshold;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.894 -0400", hash_original_method = "A15E80CA3FF7B3935AD371814D8F0A08", hash_generated_method = "9B59DFB6EF96E769AF329074401BA3AF")
    public  SerializationHandleMap() {
        this.size = 0;
        this.threshold = 21;
        int arraySize;
        arraySize = (int) (((long) threshold * 10000) / LOAD_FACTOR);
        resizeArrays(arraySize);
        // ---------- Original Method ----------
        //this.size = 0;
        //this.threshold = 21;
        //int arraySize = (int) (((long) threshold * 10000) / LOAD_FACTOR);
        //resizeArrays(arraySize);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.899 -0400", hash_original_method = "E316A93A87558F399ED4EA2FE7F26EE8", hash_generated_method = "B8FCF88007B6FE2DD328B7C3BE577A9D")
    private void resizeArrays(int newSize) {
        Object[] oldKeys;
        oldKeys = keys;
        int[] oldValues;
        oldValues = values;
        this.keys = new Object[newSize];
        this.values = new int[newSize];
        {
            {
                int i;
                i = 0;
                {
                    Object key;
                    key = oldKeys[i];
                    int value;
                    value = oldValues[i];
                    int index;
                    index = findIndex(key, keys);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.900 -0400", hash_original_method = "72EE0757674E1412A0DE2CCEADDB9C34", hash_generated_method = "B82561A3AA856C3A5427E2355CF0ABA7")
    public int get(Object key) {
        int index;
        index = findIndex(key, keys);
        addTaint(key.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1158753459 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1158753459;
        // ---------- Original Method ----------
        //int index = findIndex(key, keys);
        //if (keys[index] == key) {
            //return values[index];
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.901 -0400", hash_original_method = "188F67866E8CBA269C0CFF587B29CD3B", hash_generated_method = "A2427FD8BEB4CEDBBE1210A93648EFBB")
    private int findIndex(Object key, Object[] array) {
        int length;
        length = array.length;
        int index;
        index = getModuloHash(key, length);
        int last;
        last = (index + length - 1) % length;
        {
            index = (index + 1) % length;
        } //End block
        addTaint(key.getTaint());
        addTaint(array[0].getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1735699973 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1735699973;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.918 -0400", hash_original_method = "CEF876F6D496A0BEC63D43E9A8B9FA0E", hash_generated_method = "180137CB84130B86CAF3E10FC30D762F")
    private int getModuloHash(Object key, int length) {
        int varB7FF8F86D856E985C7144D095E72AFAB_928941916 = ((System.identityHashCode(key) & 0x7FFFFFFF) % length);
        addTaint(key.getTaint());
        addTaint(length);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_584540480 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_584540480;
        // ---------- Original Method ----------
        //return (System.identityHashCode(key) & 0x7FFFFFFF) % length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.919 -0400", hash_original_method = "F8012E326D1DCEC3988D8313DECC50DD", hash_generated_method = "C82E5FC263109B3F71FA7F3BD8E07D33")
    public int put(Object key, int value) {
        Object _key;
        _key = key;
        int _value;
        _value = value;
        int index;
        index = findIndex(_key, keys);
        {
            {
                rehash();
                index = findIndex(_key, keys);
            } //End block
            keys[index] = _key;
            values[index] = -1;
        } //End block
        int result;
        result = values[index];
        values[index] = _value;
        addTaint(key.getTaint());
        addTaint(value);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1485723046 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1485723046;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.919 -0400", hash_original_method = "B0944A4627DD585C58C4A846FDB51A94", hash_generated_method = "9CFDB2A6631FA28F7F31E6BB428FB9BB")
    private void rehash() {
        int newSize;
        newSize = keys.length * 2;
        resizeArrays(newSize);
        threshold = (int) ((long) (keys.length) * LOAD_FACTOR / 10000);
        // ---------- Original Method ----------
        //int newSize = keys.length * 2;
        //resizeArrays(newSize);
        //threshold = (int) ((long) (keys.length) * LOAD_FACTOR / 10000);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.935 -0400", hash_original_method = "A55090ECB6D90893D6737F77075A1229", hash_generated_method = "545C2AF3A95896A45EB2CD1A62D23A7B")
    public int remove(Object key) {
        boolean hashedOk;
        int index, next, hash;
        int result;
        Object object;
        index = next = findIndex(key, keys);
        result = values[index];
        int length;
        length = keys.length;
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1192949817 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1192949817;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.936 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "2A94CDD2077C2BBB597BB84FD537680F")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_116440491 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_116440491;
        // ---------- Original Method ----------
        //return size == 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.936 -0400", hash_original_field = "F25EAB9F3CA9F63E2E68F9508E0B1FB6", hash_generated_field = "6C011C4CF2EBF4A1BB14EEE6D62E0BF7")

    private static int LOAD_FACTOR = 7500;
}

