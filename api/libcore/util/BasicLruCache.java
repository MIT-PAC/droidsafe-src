package libcore.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class BasicLruCache<K, V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.092 -0400", hash_original_field = "1D78DC8ED51214E518B5114FE24490AE", hash_generated_field = "008FED306747468EE2384D75A989933A")

    private LinkedHashMap<K, V> map;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.092 -0400", hash_original_field = "B78E1120B12ABD7215D67324FE9476FF", hash_generated_field = "1486672EB97014EA466DAAF4AA4FAF69")

    private int maxSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.092 -0400", hash_original_method = "CC3CF8B3D98F4B51DBF91665642387E1", hash_generated_method = "09C5CBCB026DD4DDA4DD715A7BFDF6E4")
    public  BasicLruCache(int maxSize) {
    if(maxSize <= 0)        
        {
            IllegalArgumentException var4544452255288BB771A9A259F8205DC3_1769490353 = new IllegalArgumentException("maxSize <= 0");
            var4544452255288BB771A9A259F8205DC3_1769490353.addTaint(taint);
            throw var4544452255288BB771A9A259F8205DC3_1769490353;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.093 -0400", hash_original_method = "FDCF7F376F479E894B67671F9DF4B51A", hash_generated_method = "EBF5A19E3104AB3241CAC797573CF216")
    public synchronized final V get(K key) {
        addTaint(key.getTaint());
    if(key == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1891785594 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1891785594.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1891785594;
        } //End block
        V result = map.get(key);
    if(result != null)        
        {
V varDC838461EE2FA0CA4C9BBB70A15456B0_1925920472 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1925920472.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1925920472;
        } //End block
        result = create(key);
    if(result != null)        
        {
            map.put(key, result);
            trimToSize(maxSize);
        } //End block
V varDC838461EE2FA0CA4C9BBB70A15456B0_160112878 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_160112878.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_160112878;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.094 -0400", hash_original_method = "B215038407F38B18B2F223450263C0DA", hash_generated_method = "0C9A1487D6A04B387D044A5F9C9A7A3F")
    public synchronized final V put(K key, V value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
    if(key == null || value == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_908572179 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_908572179.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_908572179;
        } //End block
        V previous = map.put(key, value);
        trimToSize(maxSize);
V varAE805301EF6917CE0CF0EF15720ADBE0_1046963573 =         previous;
        varAE805301EF6917CE0CF0EF15720ADBE0_1046963573.addTaint(taint);
        return varAE805301EF6917CE0CF0EF15720ADBE0_1046963573;
        // ---------- Original Method ----------
        //if (key == null || value == null) {
            //throw new NullPointerException();
        //}
        //V previous = map.put(key, value);
        //trimToSize(maxSize);
        //return previous;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.094 -0400", hash_original_method = "C2014D558C9CB4AC36D82EB01EFD84A6", hash_generated_method = "F23DD3CA6877980108331FA4F00C7BD9")
    private void trimToSize(int maxSize) {
        addTaint(maxSize);
        while
(map.size() > maxSize)        
        {
            Map.Entry<K, V> toEvict = map.eldest();
            K key = toEvict.getKey();
            V value = toEvict.getValue();
            map.remove(key);
            entryEvicted(key, value);
        } //End block
        // ---------- Original Method ----------
        //while (map.size() > maxSize) {
            //Map.Entry<K, V> toEvict = map.eldest();
            //K key = toEvict.getKey();
            //V value = toEvict.getValue();
            //map.remove(key);
            //entryEvicted(key, value);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.094 -0400", hash_original_method = "4BE44702079F6982C8F2A1526F7D2A98", hash_generated_method = "3194A205726813F2B09B8A46596E6339")
    protected void entryEvicted(K key, V value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.095 -0400", hash_original_method = "56F7B4D0824C7980B3CF91C05C1DA172", hash_generated_method = "BE8B05FE22FA2EA3331A34CE3D09D1D5")
    protected V create(K key) {
        addTaint(key.getTaint());
V var540C13E9E156B687226421B24F2DF178_775455506 =         null;
        var540C13E9E156B687226421B24F2DF178_775455506.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_775455506;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.095 -0400", hash_original_method = "8A5EBF82F92FAE3DB13A729C4B6DDBA4", hash_generated_method = "AE1751F34729D087A54BDF2D5DFB9178")
    public synchronized final Map<K, V> snapshot() {
Map<K, V> var7CBA52F3D0FF67B0A6C8182187BA636E_328893332 =         new LinkedHashMap<K, V>(map);
        var7CBA52F3D0FF67B0A6C8182187BA636E_328893332.addTaint(taint);
        return var7CBA52F3D0FF67B0A6C8182187BA636E_328893332;
        // ---------- Original Method ----------
        //return new LinkedHashMap<K, V>(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.095 -0400", hash_original_method = "4FACC3280D713DC7A18D1388CFCADEC7", hash_generated_method = "C3AF49710F011F61B8CC4C3328E6E65F")
    public synchronized final void evictAll() {
        trimToSize(0);
        // ---------- Original Method ----------
        //trimToSize(0);
    }

    
}

