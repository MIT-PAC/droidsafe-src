package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class SerializationHandleMap {
    private Object[] keys;
    private int[] values;
    private int size;
    private int threshold;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.282 -0400", hash_original_method = "A15E80CA3FF7B3935AD371814D8F0A08", hash_generated_method = "9B59DFB6EF96E769AF329074401BA3AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SerializationHandleMap() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.282 -0400", hash_original_method = "E316A93A87558F399ED4EA2FE7F26EE8", hash_generated_method = "773D481B6B4D6FE5F0A0259194A292FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void resizeArrays(int newSize) {
        dsTaint.addTaint(newSize);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.282 -0400", hash_original_method = "72EE0757674E1412A0DE2CCEADDB9C34", hash_generated_method = "53FD6E375C7382EBF7D98E3321069029")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int get(Object key) {
        dsTaint.addTaint(key.dsTaint);
        int index;
        index = findIndex(key, keys);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int index = findIndex(key, keys);
        //if (keys[index] == key) {
            //return values[index];
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.282 -0400", hash_original_method = "188F67866E8CBA269C0CFF587B29CD3B", hash_generated_method = "9847F169B122C29F2A5E55083A5B74C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int findIndex(Object key, Object[] array) {
        dsTaint.addTaint(key.dsTaint);
        dsTaint.addTaint(array[0].dsTaint);
        int length;
        length = array.length;
        int index;
        index = getModuloHash(key, length);
        int last;
        last = (index + length - 1) % length;
        {
            index = (index + 1) % length;
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.283 -0400", hash_original_method = "CEF876F6D496A0BEC63D43E9A8B9FA0E", hash_generated_method = "A9AF3D416DD5E2AECE916EDB0E403B71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getModuloHash(Object key, int length) {
        dsTaint.addTaint(length);
        dsTaint.addTaint(key.dsTaint);
        int varB7FF8F86D856E985C7144D095E72AFAB_1025789688 = ((System.identityHashCode(key) & 0x7FFFFFFF) % length);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (System.identityHashCode(key) & 0x7FFFFFFF) % length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.283 -0400", hash_original_method = "F8012E326D1DCEC3988D8313DECC50DD", hash_generated_method = "CF8DF6D29121D55B8353D25B43D2EC4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int put(Object key, int value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key.dsTaint);
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.283 -0400", hash_original_method = "B0944A4627DD585C58C4A846FDB51A94", hash_generated_method = "9CFDB2A6631FA28F7F31E6BB428FB9BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.284 -0400", hash_original_method = "A55090ECB6D90893D6737F77075A1229", hash_generated_method = "5AFF43405E1386B44F86CD42D578ABDC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int remove(Object key) {
        dsTaint.addTaint(key.dsTaint);
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.284 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "B02D7658F0824D0869C92F4AD19DB19E")
    @DSModeled(DSC.SAFE)
    public boolean isEmpty() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return size == 0;
    }

    
    private static final int LOAD_FACTOR = 7500;
}

