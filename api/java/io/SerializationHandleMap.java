package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

final class SerializationHandleMap {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.941 -0500", hash_original_field = "D057CC213EDA74E52E26EEA57C4D0F80", hash_generated_field = "EC54E60FA2CF8632B6202FE74DE20CF3")

    private static final int LOAD_FACTOR = 7500;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.943 -0500", hash_original_field = "522C2C30A353BD3DE7907DCE49B36EA0", hash_generated_field = "3812BADF0A98B0817D55431A2E260B33")

    private Object[] keys;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.946 -0500", hash_original_field = "05C5B6EA1B8DB599F8A7E342E6CC5721", hash_generated_field = "C452AC6E135820F60F49205B6624FDFE")

    private int[] values;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.948 -0500", hash_original_field = "673BDAEBF4FBC900963E210E042549D6", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.950 -0500", hash_original_field = "B212DD967AF5750AEF1DDA2E6D14352F", hash_generated_field = "831F8FC1A32CF07BE696149BB6AEA9AA")

    private int threshold;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.953 -0500", hash_original_method = "A15E80CA3FF7B3935AD371814D8F0A08", hash_generated_method = "3E02B7005E9729B7D5EA8B9F32A356E0")
    
public SerializationHandleMap() {
        this.size = 0;
        this.threshold = 21; // Copied from IdentityHashMap.
        int arraySize = (int) (((long) threshold * 10000) / LOAD_FACTOR);
        resizeArrays(arraySize);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.955 -0500", hash_original_method = "E316A93A87558F399ED4EA2FE7F26EE8", hash_generated_method = "E125FAA45E4C9C72F16E3E79BEA68516")
    
private void resizeArrays(int newSize) {
        Object[] oldKeys = keys;
        int[] oldValues = values;

        this.keys = new Object[newSize];
        this.values = new int[newSize];

        if (oldKeys != null) {
            for (int i = 0; i < oldKeys.length; ++i) {
                Object key = oldKeys[i];
                int value = oldValues[i];
                int index = findIndex(key, keys);
                keys[index] = key;
                values[index] = value;
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.958 -0500", hash_original_method = "72EE0757674E1412A0DE2CCEADDB9C34", hash_generated_method = "CCC772573FC6247E53C5AF7DAE0BB41E")
    
public int get(Object key) {
        int index = findIndex(key, keys);
        if (keys[index] == key) {
            return values[index];
        }
        return -1;
    }

    /**
     * Returns the index where the key is found at, or the index of the next
     * empty spot if the key is not found in this table.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.961 -0500", hash_original_method = "188F67866E8CBA269C0CFF587B29CD3B", hash_generated_method = "EF54C84655590718FBD4C6A141707AC5")
    
private int findIndex(Object key, Object[] array) {
        int length = array.length;
        int index = getModuloHash(key, length);
        int last = (index + length - 1) % length;
        while (index != last) {
            if (array[index] == key || array[index] == null) {
                /*
                 * Found the key, or the next empty spot (which means key is not
                 * in the table)
                 */
                break;
            }
            index = (index + 1) % length;
        }
        return index;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.963 -0500", hash_original_method = "CEF876F6D496A0BEC63D43E9A8B9FA0E", hash_generated_method = "E1467679452CC6FCFE96EDFDC50FA819")
    
private int getModuloHash(Object key, int length) {
        return (System.identityHashCode(key) & 0x7FFFFFFF) % length;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.966 -0500", hash_original_method = "F8012E326D1DCEC3988D8313DECC50DD", hash_generated_method = "2B5D7E3441454F595D4A70A037BF9B9C")
    
public int put(Object key, int value) {
        Object _key = key;
        int _value = value;

        int index = findIndex(_key, keys);

        // if the key doesn't exist in the table
        if (keys[index] != _key) {
            if (++size > threshold) {
                rehash();
                index = findIndex(_key, keys);
            }
            // insert the key and assign the value to -1 initially
            keys[index] = _key;
            values[index] = -1;
        }

        // insert value to where it needs to go, return the old value
        int result = values[index];
        values[index] = _value;
        return result;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.969 -0500", hash_original_method = "B0944A4627DD585C58C4A846FDB51A94", hash_generated_method = "D80073AB6EA1AFF862D7A7C35661DE52")
    
private void rehash() {
        int newSize = keys.length * 2;
        resizeArrays(newSize);
        threshold = (int) ((long) (keys.length) * LOAD_FACTOR / 10000);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.972 -0500", hash_original_method = "A55090ECB6D90893D6737F77075A1229", hash_generated_method = "A3424F0E4F91F041D48EA56C8DFB4356")
    
public int remove(Object key) {
        boolean hashedOk;
        int index, next, hash;
        int result;
        Object object;
        index = next = findIndex(key, keys);

        if (keys[index] != key) {
            return -1;
        }

        // store the value for this key
        result = values[index];

        // shift the following elements up if needed
        // until we reach an empty spot
        int length = keys.length;
        while (true) {
            next = (next + 2) % length;
            object = keys[next];
            if (object == null) {
                break;
            }

            hash = getModuloHash(object, length);
            hashedOk = hash > index;
            if (next < index) {
                hashedOk = hashedOk || (hash <= next);
            } else {
                hashedOk = hashedOk && (hash <= next);
            }
            if (!hashedOk) {
                keys[index] = object;
                values[index] = values[next];
                index = next;
            }
        }
        size--;

        // clear both the key and the value
        keys[index] = null;
        values[index] = -1;

        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.975 -0500", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "BCEA08F5849F536168BFB81023CBA1DB")
    
public boolean isEmpty() {
        return size == 0;
    }
}

