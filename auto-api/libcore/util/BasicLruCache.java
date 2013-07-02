package libcore.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class BasicLruCache<K, V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.987 -0400", hash_original_field = "1D78DC8ED51214E518B5114FE24490AE", hash_generated_field = "008FED306747468EE2384D75A989933A")

    private LinkedHashMap<K, V> map;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.987 -0400", hash_original_field = "B78E1120B12ABD7215D67324FE9476FF", hash_generated_field = "1486672EB97014EA466DAAF4AA4FAF69")

    private int maxSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.987 -0400", hash_original_method = "CC3CF8B3D98F4B51DBF91665642387E1", hash_generated_method = "20E108787859688129678496E6C9BA4C")
    public  BasicLruCache(int maxSize) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("maxSize <= 0");
        } 
        this.maxSize = maxSize;
        this.map = new LinkedHashMap<K, V>(0, 0.75f, true);
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.988 -0400", hash_original_method = "FDCF7F376F479E894B67671F9DF4B51A", hash_generated_method = "3AB18E703499017619D21F2E0441D9CA")
    public synchronized final V get(K key) {
        V varB4EAC82CA7396A68D541C85D26508E83_1978429570 = null; 
        V varB4EAC82CA7396A68D541C85D26508E83_227206944 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        V result = map.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1978429570 = result;
        } 
        result = create(key);
        {
            map.put(key, result);
            trimToSize(maxSize);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_227206944 = result;
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_2146016631; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2146016631 = varB4EAC82CA7396A68D541C85D26508E83_1978429570;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2146016631 = varB4EAC82CA7396A68D541C85D26508E83_227206944;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2146016631.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2146016631;
        
        
            
        
        
        
            
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.988 -0400", hash_original_method = "B215038407F38B18B2F223450263C0DA", hash_generated_method = "9AFC6077A9D78F8DF3C0E4CF263E211E")
    public synchronized final V put(K key, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_773408463 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        V previous = map.put(key, value);
        trimToSize(maxSize);
        varB4EAC82CA7396A68D541C85D26508E83_773408463 = previous;
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_773408463.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_773408463;
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.988 -0400", hash_original_method = "C2014D558C9CB4AC36D82EB01EFD84A6", hash_generated_method = "CD12C96EE79434C7BC4C755181CCF11F")
    private void trimToSize(int maxSize) {
        {
            boolean var3BFE4AB1CCFC4CFAE6E3CC8404C94C02_1336519108 = (map.size() > maxSize);
            {
                Map.Entry<K, V> toEvict = map.eldest();
                K key = toEvict.getKey();
                V value = toEvict.getValue();
                map.remove(key);
                entryEvicted(key, value);
            } 
        } 
        addTaint(maxSize);
        
        
            
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.989 -0400", hash_original_method = "4BE44702079F6982C8F2A1526F7D2A98", hash_generated_method = "38D7723A24AC4FEFAEF7BE8D804987AD")
    protected void entryEvicted(K key, V value) {
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.989 -0400", hash_original_method = "56F7B4D0824C7980B3CF91C05C1DA172", hash_generated_method = "E75A617281E4B92F50B83971360B4223")
    protected V create(K key) {
        V varB4EAC82CA7396A68D541C85D26508E83_505819542 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_505819542 = null;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_505819542.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_505819542;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.989 -0400", hash_original_method = "8A5EBF82F92FAE3DB13A729C4B6DDBA4", hash_generated_method = "48908C583F2AC95CF6C0B414D581F916")
    public synchronized final Map<K, V> snapshot() {
        Map<K, V> varB4EAC82CA7396A68D541C85D26508E83_351977385 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_351977385 = new LinkedHashMap<K, V>(map);
        varB4EAC82CA7396A68D541C85D26508E83_351977385.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_351977385;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.990 -0400", hash_original_method = "4FACC3280D713DC7A18D1388CFCADEC7", hash_generated_method = "C3AF49710F011F61B8CC4C3328E6E65F")
    public synchronized final void evictAll() {
        trimToSize(0);
        
        
    }

    
}

