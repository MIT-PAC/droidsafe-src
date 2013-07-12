package android.support.v4.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<K, V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.563 -0400", hash_original_field = "1D78DC8ED51214E518B5114FE24490AE", hash_generated_field = "008FED306747468EE2384D75A989933A")

    private LinkedHashMap<K, V> map;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.563 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.563 -0400", hash_original_field = "B78E1120B12ABD7215D67324FE9476FF", hash_generated_field = "1486672EB97014EA466DAAF4AA4FAF69")

    private int maxSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.564 -0400", hash_original_field = "B5E773FF0DAA7AF2D35B09A2ACE97C38", hash_generated_field = "19F4FFEE16EDFF5AE45C5FE9A1BFB8DE")

    private int putCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.564 -0400", hash_original_field = "1EFE30A68A1999763186AA8A0FF431E2", hash_generated_field = "E17BC39B90B7FC1868ABCF5E868DC1F0")

    private int createCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.564 -0400", hash_original_field = "3E1471C5E3C695ABC459C18E113BDF6F", hash_generated_field = "5818FEEB77D22B7930FC3E6082C766A2")

    private int evictionCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.564 -0400", hash_original_field = "5BBBCEBEEA805F9664B2979FBACE5699", hash_generated_field = "32AD557D5385B14E2A17100B12982F49")

    private int hitCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.564 -0400", hash_original_field = "698B6BDB01E0C702797DD865E1B3FBBB", hash_generated_field = "F9F39FB5A1CA690A1C15055CB8F2E309")

    private int missCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.564 -0400", hash_original_method = "4EF140C80EBAC1C26C5562E76AB6C34D", hash_generated_method = "5551987C54D893617E62D34AE3A5262A")
    public  LruCache(int maxSize) {
    if(maxSize <= 0)        
        {
            IllegalArgumentException var4544452255288BB771A9A259F8205DC3_1684862101 = new IllegalArgumentException("maxSize <= 0");
            var4544452255288BB771A9A259F8205DC3_1684862101.addTaint(taint);
            throw var4544452255288BB771A9A259F8205DC3_1684862101;
        } 
        this.maxSize = maxSize;
        this.map = new LinkedHashMap<K, V>(0, 0.75f, true);
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.566 -0400", hash_original_method = "E5DC52D3C4EAEBC9C86A603CE5606C4A", hash_generated_method = "BF480BADAB6B62F5326B97ECAB1EA6FE")
    public final V get(K key) {
    if(key == null)        
        {
            NullPointerException var3408376C603A4BD36F703BF88588B8F4_1178109146 = new NullPointerException("key == null");
            var3408376C603A4BD36F703BF88588B8F4_1178109146.addTaint(taint);
            throw var3408376C603A4BD36F703BF88588B8F4_1178109146;
        } 
        V mapValue;
        synchronized
(this)        {
            mapValue = map.get(key);
    if(mapValue != null)            
            {
                hitCount++;
V varF8515BBCD094CE53DC4052C62BA3144D_2070569655 =                 mapValue;
                varF8515BBCD094CE53DC4052C62BA3144D_2070569655.addTaint(taint);
                return varF8515BBCD094CE53DC4052C62BA3144D_2070569655;
            } 
            missCount++;
        } 
        V createdValue = create(key);
    if(createdValue == null)        
        {
V var540C13E9E156B687226421B24F2DF178_446846440 =             null;
            var540C13E9E156B687226421B24F2DF178_446846440.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_446846440;
        } 
        synchronized
(this)        {
            createCount++;
            mapValue = map.put(key, createdValue);
    if(mapValue != null)            
            {
                map.put(key, mapValue);
            } 
            else
            {
                size += safeSizeOf(key, createdValue);
            } 
        } 
    if(mapValue != null)        
        {
            entryRemoved(false, key, createdValue, mapValue);
V varF8515BBCD094CE53DC4052C62BA3144D_39595001 =             mapValue;
            varF8515BBCD094CE53DC4052C62BA3144D_39595001.addTaint(taint);
            return varF8515BBCD094CE53DC4052C62BA3144D_39595001;
        } 
        else
        {
            trimToSize(maxSize);
V var887CC428FAE3E4113D67DDB6E0274549_540808723 =             createdValue;
            var887CC428FAE3E4113D67DDB6E0274549_540808723.addTaint(taint);
            return var887CC428FAE3E4113D67DDB6E0274549_540808723;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.568 -0400", hash_original_method = "79B383546C2B260561E7B3FD1850F381", hash_generated_method = "8C6A1C5C345E0359A97246567B159B30")
    public final V put(K key, V value) {
    if(key == null || value == null)        
        {
            NullPointerException var1CDCE0A2CFC6A318D6FC14D56E7A9AFD_628285625 = new NullPointerException("key == null || value == null");
            var1CDCE0A2CFC6A318D6FC14D56E7A9AFD_628285625.addTaint(taint);
            throw var1CDCE0A2CFC6A318D6FC14D56E7A9AFD_628285625;
        } 
        V previous;
        synchronized
(this)        {
            putCount++;
            size += safeSizeOf(key, value);
            previous = map.put(key, value);
    if(previous != null)            
            {
                size -= safeSizeOf(key, previous);
            } 
        } 
    if(previous != null)        
        {
            entryRemoved(false, key, previous, value);
        } 
        trimToSize(maxSize);
V varAE805301EF6917CE0CF0EF15720ADBE0_567945986 =         previous;
        varAE805301EF6917CE0CF0EF15720ADBE0_567945986.addTaint(taint);
        return varAE805301EF6917CE0CF0EF15720ADBE0_567945986;
        
        
            
        
        
        
            
            
            
            
                
            
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.569 -0400", hash_original_method = "82D005458BB4BC837252CC0C6863637E", hash_generated_method = "FEC0ED0B7EC1C83B68C3F69FAEB274B1")
    public void trimToSize(int maxSize) {
        addTaint(maxSize);
        while
(true)        
        {
            K key;
            V value;
            synchronized
(this)            {
    if(size < 0 || (map.isEmpty() && size != 0))                
                {
                    IllegalStateException varEFA1EB63E20171257D59ACAB759ACF03_2070768311 = new IllegalStateException(getClass().getName()
                            + ".sizeOf() is reporting inconsistent results!");
                    varEFA1EB63E20171257D59ACAB759ACF03_2070768311.addTaint(taint);
                    throw varEFA1EB63E20171257D59ACAB759ACF03_2070768311;
                } 
    if(size <= maxSize || map.isEmpty())                
                {
                    break;
                } 
                Map.Entry<K, V> toEvict = map.entrySet().iterator().next();
                key = toEvict.getKey();
                value = toEvict.getValue();
                map.remove(key);
                size -= safeSizeOf(key, value);
                evictionCount++;
            } 
            entryRemoved(true, key, value, null);
        } 
        
        
            
            
            
                
                    
                            
                
                
                    
                
                
                
                
                
                
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.569 -0400", hash_original_method = "5ECD46803ACE6D1B641401078C3B9D9C", hash_generated_method = "50251CF1F03C36115C228F5B446B9102")
    public final V remove(K key) {
    if(key == null)        
        {
            NullPointerException var3408376C603A4BD36F703BF88588B8F4_127181490 = new NullPointerException("key == null");
            var3408376C603A4BD36F703BF88588B8F4_127181490.addTaint(taint);
            throw var3408376C603A4BD36F703BF88588B8F4_127181490;
        } 
        V previous;
        synchronized
(this)        {
            previous = map.remove(key);
    if(previous != null)            
            {
                size -= safeSizeOf(key, previous);
            } 
        } 
    if(previous != null)        
        {
            entryRemoved(false, key, previous, null);
        } 
V varAE805301EF6917CE0CF0EF15720ADBE0_1402119927 =         previous;
        varAE805301EF6917CE0CF0EF15720ADBE0_1402119927.addTaint(taint);
        return varAE805301EF6917CE0CF0EF15720ADBE0_1402119927;
        
        
            
        
        
        
            
            
                
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.570 -0400", hash_original_method = "9AD1617B914C1EE986412183164D996B", hash_generated_method = "D85B76C70BAD813556EC7465A7D0C22C")
    protected void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {
        addTaint(newValue.getTaint());
        addTaint(oldValue.getTaint());
        addTaint(key.getTaint());
        addTaint(evicted);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.570 -0400", hash_original_method = "56F7B4D0824C7980B3CF91C05C1DA172", hash_generated_method = "38076812C276B6E94AF55C18A5095300")
    protected V create(K key) {
        addTaint(key.getTaint());
V var540C13E9E156B687226421B24F2DF178_374121613 =         null;
        var540C13E9E156B687226421B24F2DF178_374121613.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_374121613;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.570 -0400", hash_original_method = "971860883D94FE365FE71BDE260829D3", hash_generated_method = "F3D49FE6A8A57F4684542F1BEFE0F01C")
    private int safeSizeOf(K key, V value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        int result = sizeOf(key, value);
    if(result < 0)        
        {
            IllegalStateException var5797A9243A08E8E95BAA5059E55485D6_454891496 = new IllegalStateException("Negative size: " + key + "=" + value);
            var5797A9243A08E8E95BAA5059E55485D6_454891496.addTaint(taint);
            throw var5797A9243A08E8E95BAA5059E55485D6_454891496;
        } 
        int varB4A88417B3D0170D754C647C30B7216A_330205660 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1628200156 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1628200156;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.571 -0400", hash_original_method = "6F73EAFB28729CDC0BB32AECE7CD1246", hash_generated_method = "0CEB33A110E177DBDEEB7CFE9B2B1013")
    protected int sizeOf(K key, V value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        int varC4CA4238A0B923820DCC509A6F75849B_1084952038 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1050492618 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1050492618;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.571 -0400", hash_original_method = "D3EB145ED9D558FDF887F10175D8EBDF", hash_generated_method = "6852E1E415BA1B80059D4CFD58DC38F6")
    public final void evictAll() {
        trimToSize(-1);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.571 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "31B23FD29F132F11A65DDA1B2300C0BF")
    public synchronized final int size() {
        int varF7BD60B75B29D79B660A2859395C1A24_1316318502 = (size);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1449936142 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1449936142;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.572 -0400", hash_original_method = "3468DBA84D0C4B093D85888533351ACC", hash_generated_method = "3F8DEBAD06378735DB1B60F313798412")
    public synchronized final int maxSize() {
        int varB78E1120B12ABD7215D67324FE9476FF_383912246 = (maxSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_303852655 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_303852655;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.572 -0400", hash_original_method = "58C54B9E60920B23E133E0E61BF2A4F4", hash_generated_method = "5120CA918FF2167C45E39C743222B9A1")
    public synchronized final int hitCount() {
        int var5BBBCEBEEA805F9664B2979FBACE5699_1854510689 = (hitCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1258872256 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1258872256;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.572 -0400", hash_original_method = "CD33CA8BAAD7A20717BABBDF22DCC17E", hash_generated_method = "0266F6B6F6DAED5FC7F21332240AD254")
    public synchronized final int missCount() {
        int var698B6BDB01E0C702797DD865E1B3FBBB_1253386643 = (missCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1052762089 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1052762089;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.572 -0400", hash_original_method = "03691337F25E7C4DFAAA3B9F69FCDA1E", hash_generated_method = "1E41F78AD9AF92DD310C009847FFB899")
    public synchronized final int createCount() {
        int var1EFE30A68A1999763186AA8A0FF431E2_1893068957 = (createCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_294794546 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_294794546;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.573 -0400", hash_original_method = "291437E08BF34B71B9E36D69031C2701", hash_generated_method = "D611D4329412EDBF63D5F16D9F0A7888")
    public synchronized final int putCount() {
        int varB5E773FF0DAA7AF2D35B09A2ACE97C38_808034806 = (putCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_517408102 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_517408102;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.573 -0400", hash_original_method = "21AA3C6AE5648A36F9E47AF2806112A8", hash_generated_method = "31C6DEF48E374AB36A7095B7FA2FBEA4")
    public synchronized final int evictionCount() {
        int var3E1471C5E3C695ABC459C18E113BDF6F_976844801 = (evictionCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2031962338 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2031962338;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.573 -0400", hash_original_method = "8A5EBF82F92FAE3DB13A729C4B6DDBA4", hash_generated_method = "0EEC075E0AC8FE238B85C7AEE50406C5")
    public synchronized final Map<K, V> snapshot() {
Map<K, V> var7CBA52F3D0FF67B0A6C8182187BA636E_628871176 =         new LinkedHashMap<K, V>(map);
        var7CBA52F3D0FF67B0A6C8182187BA636E_628871176.addTaint(taint);
        return var7CBA52F3D0FF67B0A6C8182187BA636E_628871176;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.574 -0400", hash_original_method = "D511C7B644032E2A9485769132851C89", hash_generated_method = "1D9B2B1C1A166EFEE33EA93578CBA833")
    @Override
    public synchronized final String toString() {
        int accesses = hitCount + missCount;
        int hitPercent = accesses != 0 ? (100 * hitCount / accesses) : 0;
String var3613CB17148F5894DE67CC8125058E08_563497507 =         String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]",
                maxSize, hitCount, missCount, hitPercent);
        var3613CB17148F5894DE67CC8125058E08_563497507.addTaint(taint);
        return var3613CB17148F5894DE67CC8125058E08_563497507;
        
        
        
        
                
    }

    
}

