package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

final class SerializationHandleMap {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.990 -0400", hash_original_field = "14F802E1FBA977727845E8872C1743A7", hash_generated_field = "3812BADF0A98B0817D55431A2E260B33")

    private Object[] keys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.990 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "C452AC6E135820F60F49205B6624FDFE")

    private int[] values;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.990 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.991 -0400", hash_original_field = "F0598264A691A8F62272ACA0E79AF374", hash_generated_field = "831F8FC1A32CF07BE696149BB6AEA9AA")

    private int threshold;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.992 -0400", hash_original_method = "A15E80CA3FF7B3935AD371814D8F0A08", hash_generated_method = "64C0BD6F1288C840DCFEF54577B8DC08")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.994 -0400", hash_original_method = "E316A93A87558F399ED4EA2FE7F26EE8", hash_generated_method = "601118B60C66E941835E8C4A11B3ED5C")
    private void resizeArrays(int newSize) {
        Object[] oldKeys = keys;
        int[] oldValues = values;
        this.keys = new Object[newSize];
        this.values = new int[newSize];
    if(oldKeys != null)        
        {
for(int i = 0;i < oldKeys.length;++i)
            {
                Object key = oldKeys[i];
                int value = oldValues[i];
                int index = findIndex(key, keys);
                keys[index] = key;
                values[index] = value;
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.995 -0400", hash_original_method = "72EE0757674E1412A0DE2CCEADDB9C34", hash_generated_method = "FE029AF758BDFE928953F6097C352478")
    public int get(Object key) {
        addTaint(key.getTaint());
        int index = findIndex(key, keys);
    if(keys[index] == key)        
        {
            int var5E48D24D770C72D5B61547675B2B85AD_1030306681 = (values[index]);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_690560953 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_690560953;
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_2058453868 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1226414976 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1226414976;
        // ---------- Original Method ----------
        //int index = findIndex(key, keys);
        //if (keys[index] == key) {
            //return values[index];
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.997 -0400", hash_original_method = "188F67866E8CBA269C0CFF587B29CD3B", hash_generated_method = "DB7988CB0103AAC2673CDFB47395BD45")
    private int findIndex(Object key, Object[] array) {
        addTaint(array[0].getTaint());
        addTaint(key.getTaint());
        int length = array.length;
        int index = getModuloHash(key, length);
        int last = (index + length - 1) % length;
        while
(index != last)        
        {
    if(array[index] == key || array[index] == null)            
            {
                break;
            } //End block
            index = (index + 1) % length;
        } //End block
        int var6A992D5529F459A44FEE58C733255E86_1548129968 = (index);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_901459972 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_901459972;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.998 -0400", hash_original_method = "CEF876F6D496A0BEC63D43E9A8B9FA0E", hash_generated_method = "F02601931A45CA378A1EF030A55B9B7C")
    private int getModuloHash(Object key, int length) {
        addTaint(length);
        addTaint(key.getTaint());
        int varAAF7301A1EB092673EB32DAA57E8540E_1759236343 = ((System.identityHashCode(key) & 0x7FFFFFFF) % length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1660454582 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1660454582;
        // ---------- Original Method ----------
        //return (System.identityHashCode(key) & 0x7FFFFFFF) % length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.000 -0400", hash_original_method = "F8012E326D1DCEC3988D8313DECC50DD", hash_generated_method = "5B2761D4B98F6A92A8F24855D70BA0FF")
    public int put(Object key, int value) {
        addTaint(value);
        addTaint(key.getTaint());
        Object _key = key;
        int _value = value;
        int index = findIndex(_key, keys);
    if(keys[index] != _key)        
        {
    if(++size > threshold)            
            {
                rehash();
                index = findIndex(_key, keys);
            } //End block
            keys[index] = _key;
            values[index] = -1;
        } //End block
        int result = values[index];
        values[index] = _value;
        int varB4A88417B3D0170D754C647C30B7216A_892352666 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2015572925 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2015572925;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.002 -0400", hash_original_method = "B0944A4627DD585C58C4A846FDB51A94", hash_generated_method = "F569FDAC8A3EA0813CC85B292BA24007")
    private void rehash() {
        int newSize = keys.length * 2;
        resizeArrays(newSize);
        threshold = (int) ((long) (keys.length) * LOAD_FACTOR / 10000);
        // ---------- Original Method ----------
        //int newSize = keys.length * 2;
        //resizeArrays(newSize);
        //threshold = (int) ((long) (keys.length) * LOAD_FACTOR / 10000);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.006 -0400", hash_original_method = "A55090ECB6D90893D6737F77075A1229", hash_generated_method = "0BF0037FE145DAA3371262A693082813")
    public int remove(Object key) {
        addTaint(key.getTaint());
        boolean hashedOk;
        int index;
        int next;
        int hash;
        int result;
        Object object;
        index = next = findIndex(key, keys);
    if(keys[index] != key)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1940018119 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_223096676 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_223096676;
        } //End block
        result = values[index];
        int length = keys.length;
        while
(true)        
        {
            next = (next + 2) % length;
            object = keys[next];
    if(object == null)            
            {
                break;
            } //End block
            hash = getModuloHash(object, length);
            hashedOk = hash > index;
    if(next < index)            
            {
                hashedOk = hashedOk || (hash <= next);
            } //End block
            else
            {
                hashedOk = hashedOk && (hash <= next);
            } //End block
    if(!hashedOk)            
            {
                keys[index] = object;
                values[index] = values[next];
                index = next;
            } //End block
        } //End block
        size--;
        keys[index] = null;
        values[index] = -1;
        int varB4A88417B3D0170D754C647C30B7216A_2009098484 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_840903621 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_840903621;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.007 -0400", hash_original_method = "186376BCBF1440029A4A8EF9D3327AB7", hash_generated_method = "E328021BEDC685ECF61C34FF4CFFF9D5")
    public boolean isEmpty() {
        boolean var9FB8BC7F775DDD98EEAB5582D340229E_238124799 = (size == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_949316333 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_949316333;
        // ---------- Original Method ----------
        //return size == 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.008 -0400", hash_original_field = "F25EAB9F3CA9F63E2E68F9508E0B1FB6", hash_generated_field = "EC54E60FA2CF8632B6202FE74DE20CF3")

    private static final int LOAD_FACTOR = 7500;
}

