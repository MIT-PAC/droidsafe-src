package libcore.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class BasicLruCache<K, V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.256 -0400", hash_original_field = "1D78DC8ED51214E518B5114FE24490AE", hash_generated_field = "008FED306747468EE2384D75A989933A")

    private LinkedHashMap<K, V> map;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.256 -0400", hash_original_field = "B78E1120B12ABD7215D67324FE9476FF", hash_generated_field = "1486672EB97014EA466DAAF4AA4FAF69")

    private int maxSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.257 -0400", hash_original_method = "CC3CF8B3D98F4B51DBF91665642387E1", hash_generated_method = "20E108787859688129678496E6C9BA4C")
    public  BasicLruCache(int maxSize) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("maxSize <= 0");
        } //End block
        this.maxSize = maxSize;
        this.map = new LinkedHashMap<K, V>(0, 0.75f, true);
        // ---------- Original Method ----------
        //if (maxSize <= 0) {
            //throw new IllegalArgumentException("maxSize <= 0");
        //}
        //this.maxSize = maxSize;
        //this.map = new LinkedHashMap<K, V>(0, 0.75f, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.258 -0400", hash_original_method = "FDCF7F376F479E894B67671F9DF4B51A", hash_generated_method = "2F5DCBB2FF5323162BD2DC08C3EC6D21")
    public synchronized final V get(K key) {
        V varB4EAC82CA7396A68D541C85D26508E83_2018443245 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_569693327 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        V result;
        result = map.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_2018443245 = result;
        } //End block
        result = create(key);
        {
            map.put(key, result);
            trimToSize(maxSize);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_569693327 = result;
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_81251900; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_81251900 = varB4EAC82CA7396A68D541C85D26508E83_2018443245;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_81251900 = varB4EAC82CA7396A68D541C85D26508E83_569693327;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_81251900.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_81251900;
        // ---------- Original Method ----------
        //if (key == null) {
            //throw new NullPointerException();
        //}
        //V result = map.get(key);
        //if (result != null) {
            //return result;
        //}
        //result = create(key);
        //if (result != null) {
            //map.put(key, result);
            //trimToSize(maxSize);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.271 -0400", hash_original_method = "B215038407F38B18B2F223450263C0DA", hash_generated_method = "976539404944CA504EDC9C99F653B21A")
    public synchronized final V put(K key, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_946318586 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        V previous;
        previous = map.put(key, value);
        trimToSize(maxSize);
        varB4EAC82CA7396A68D541C85D26508E83_946318586 = previous;
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_946318586.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_946318586;
        // ---------- Original Method ----------
        //if (key == null || value == null) {
            //throw new NullPointerException();
        //}
        //V previous = map.put(key, value);
        //trimToSize(maxSize);
        //return previous;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.271 -0400", hash_original_method = "C2014D558C9CB4AC36D82EB01EFD84A6", hash_generated_method = "CA49B40D260A63BCEB8C8C2A2D9818EF")
    private void trimToSize(int maxSize) {
        {
            boolean var3BFE4AB1CCFC4CFAE6E3CC8404C94C02_215474184 = (map.size() > maxSize);
            {
                Map.Entry<K, V> toEvict;
                toEvict = map.eldest();
                K key;
                key = toEvict.getKey();
                V value;
                value = toEvict.getValue();
                map.remove(key);
                entryEvicted(key, value);
            } //End block
        } //End collapsed parenthetic
        addTaint(maxSize);
        // ---------- Original Method ----------
        //while (map.size() > maxSize) {
            //Map.Entry<K, V> toEvict = map.eldest();
            //K key = toEvict.getKey();
            //V value = toEvict.getValue();
            //map.remove(key);
            //entryEvicted(key, value);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.274 -0400", hash_original_method = "4BE44702079F6982C8F2A1526F7D2A98", hash_generated_method = "38D7723A24AC4FEFAEF7BE8D804987AD")
    protected void entryEvicted(K key, V value) {
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.276 -0400", hash_original_method = "56F7B4D0824C7980B3CF91C05C1DA172", hash_generated_method = "C8B153A8BB495FF55F833AA3008B9730")
    protected V create(K key) {
        V varB4EAC82CA7396A68D541C85D26508E83_2116967874 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2116967874 = null;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2116967874.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2116967874;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.276 -0400", hash_original_method = "8A5EBF82F92FAE3DB13A729C4B6DDBA4", hash_generated_method = "770EEDC706E2AA4F3EB69F9E6BA6082A")
    public synchronized final Map<K, V> snapshot() {
        Map<K, V> varB4EAC82CA7396A68D541C85D26508E83_309648141 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_309648141 = new LinkedHashMap<K, V>(map);
        varB4EAC82CA7396A68D541C85D26508E83_309648141.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_309648141;
        // ---------- Original Method ----------
        //return new LinkedHashMap<K, V>(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.277 -0400", hash_original_method = "4FACC3280D713DC7A18D1388CFCADEC7", hash_generated_method = "C3AF49710F011F61B8CC4C3328E6E65F")
    public synchronized final void evictAll() {
        trimToSize(0);
        // ---------- Original Method ----------
        //trimToSize(0);
    }

    
}

