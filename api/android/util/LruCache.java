package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<K, V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.038 -0400", hash_original_field = "1D78DC8ED51214E518B5114FE24490AE", hash_generated_field = "008FED306747468EE2384D75A989933A")

    private LinkedHashMap<K, V> map;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.038 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.038 -0400", hash_original_field = "B78E1120B12ABD7215D67324FE9476FF", hash_generated_field = "1486672EB97014EA466DAAF4AA4FAF69")

    private int maxSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.038 -0400", hash_original_field = "B5E773FF0DAA7AF2D35B09A2ACE97C38", hash_generated_field = "19F4FFEE16EDFF5AE45C5FE9A1BFB8DE")

    private int putCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.038 -0400", hash_original_field = "1EFE30A68A1999763186AA8A0FF431E2", hash_generated_field = "E17BC39B90B7FC1868ABCF5E868DC1F0")

    private int createCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.038 -0400", hash_original_field = "3E1471C5E3C695ABC459C18E113BDF6F", hash_generated_field = "5818FEEB77D22B7930FC3E6082C766A2")

    private int evictionCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.038 -0400", hash_original_field = "5BBBCEBEEA805F9664B2979FBACE5699", hash_generated_field = "32AD557D5385B14E2A17100B12982F49")

    private int hitCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.038 -0400", hash_original_field = "698B6BDB01E0C702797DD865E1B3FBBB", hash_generated_field = "F9F39FB5A1CA690A1C15055CB8F2E309")

    private int missCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.039 -0400", hash_original_method = "4EF140C80EBAC1C26C5562E76AB6C34D", hash_generated_method = "2E93611B80BE8576A7BB91167CB10CA5")
    public  LruCache(int maxSize) {
    if(maxSize <= 0)        
        {
            IllegalArgumentException var4544452255288BB771A9A259F8205DC3_710587320 = new IllegalArgumentException("maxSize <= 0");
            var4544452255288BB771A9A259F8205DC3_710587320.addTaint(taint);
            throw var4544452255288BB771A9A259F8205DC3_710587320;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.040 -0400", hash_original_method = "E5DC52D3C4EAEBC9C86A603CE5606C4A", hash_generated_method = "6F38D1D96CC777E220638E114373A250")
    public final V get(K key) {
    if(key == null)        
        {
            NullPointerException var3408376C603A4BD36F703BF88588B8F4_603351582 = new NullPointerException("key == null");
            var3408376C603A4BD36F703BF88588B8F4_603351582.addTaint(taint);
            throw var3408376C603A4BD36F703BF88588B8F4_603351582;
        } //End block
        V mapValue;
        synchronized
(this)        {
            mapValue = map.get(key);
    if(mapValue != null)            
            {
                hitCount++;
V varF8515BBCD094CE53DC4052C62BA3144D_897827886 =                 mapValue;
                varF8515BBCD094CE53DC4052C62BA3144D_897827886.addTaint(taint);
                return varF8515BBCD094CE53DC4052C62BA3144D_897827886;
            } //End block
            missCount++;
        } //End block
        V createdValue = create(key);
    if(createdValue == null)        
        {
V var540C13E9E156B687226421B24F2DF178_1237457365 =             null;
            var540C13E9E156B687226421B24F2DF178_1237457365.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1237457365;
        } //End block
        synchronized
(this)        {
            createCount++;
            mapValue = map.put(key, createdValue);
    if(mapValue != null)            
            {
                map.put(key, mapValue);
            } //End block
            else
            {
                size += safeSizeOf(key, createdValue);
            } //End block
        } //End block
    if(mapValue != null)        
        {
            entryRemoved(false, key, createdValue, mapValue);
V varF8515BBCD094CE53DC4052C62BA3144D_56664333 =             mapValue;
            varF8515BBCD094CE53DC4052C62BA3144D_56664333.addTaint(taint);
            return varF8515BBCD094CE53DC4052C62BA3144D_56664333;
        } //End block
        else
        {
            trimToSize(maxSize);
V var887CC428FAE3E4113D67DDB6E0274549_759264550 =             createdValue;
            var887CC428FAE3E4113D67DDB6E0274549_759264550.addTaint(taint);
            return var887CC428FAE3E4113D67DDB6E0274549_759264550;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.041 -0400", hash_original_method = "79B383546C2B260561E7B3FD1850F381", hash_generated_method = "6136E5607F647BF37FAA52CE9E5E470F")
    public final V put(K key, V value) {
    if(key == null || value == null)        
        {
            NullPointerException var1CDCE0A2CFC6A318D6FC14D56E7A9AFD_549541966 = new NullPointerException("key == null || value == null");
            var1CDCE0A2CFC6A318D6FC14D56E7A9AFD_549541966.addTaint(taint);
            throw var1CDCE0A2CFC6A318D6FC14D56E7A9AFD_549541966;
        } //End block
        V previous;
        synchronized
(this)        {
            putCount++;
            size += safeSizeOf(key, value);
            previous = map.put(key, value);
    if(previous != null)            
            {
                size -= safeSizeOf(key, previous);
            } //End block
        } //End block
    if(previous != null)        
        {
            entryRemoved(false, key, previous, value);
        } //End block
        trimToSize(maxSize);
V varAE805301EF6917CE0CF0EF15720ADBE0_635316358 =         previous;
        varAE805301EF6917CE0CF0EF15720ADBE0_635316358.addTaint(taint);
        return varAE805301EF6917CE0CF0EF15720ADBE0_635316358;
        // ---------- Original Method ----------
        //if (key == null || value == null) {
            //throw new NullPointerException("key == null || value == null");
        //}
        //V previous;
        //synchronized (this) {
            //putCount++;
            //size += safeSizeOf(key, value);
            //previous = map.put(key, value);
            //if (previous != null) {
                //size -= safeSizeOf(key, previous);
            //}
        //}
        //if (previous != null) {
            //entryRemoved(false, key, previous, value);
        //}
        //trimToSize(maxSize);
        //return previous;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.043 -0400", hash_original_method = "5A85F1994DB09F90DA92A4710FB4C22D", hash_generated_method = "29C4485A63951D99E7D642E3E1F3833A")
    private void trimToSize(int maxSize) {
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
                    IllegalStateException varEFA1EB63E20171257D59ACAB759ACF03_1407143480 = new IllegalStateException(getClass().getName()
                            + ".sizeOf() is reporting inconsistent results!");
                    varEFA1EB63E20171257D59ACAB759ACF03_1407143480.addTaint(taint);
                    throw varEFA1EB63E20171257D59ACAB759ACF03_1407143480;
                } //End block
    if(size <= maxSize)                
                {
                    break;
                } //End block
                Map.Entry<K, V> toEvict = map.eldest();
    if(toEvict == null)                
                {
                    break;
                } //End block
                key = toEvict.getKey();
                value = toEvict.getValue();
                map.remove(key);
                size -= safeSizeOf(key, value);
                evictionCount++;
            } //End block
            entryRemoved(true, key, value, null);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.043 -0400", hash_original_method = "5ECD46803ACE6D1B641401078C3B9D9C", hash_generated_method = "610EBE7C63971C796E0E1F3DE9BE3C2E")
    public final V remove(K key) {
    if(key == null)        
        {
            NullPointerException var3408376C603A4BD36F703BF88588B8F4_353394399 = new NullPointerException("key == null");
            var3408376C603A4BD36F703BF88588B8F4_353394399.addTaint(taint);
            throw var3408376C603A4BD36F703BF88588B8F4_353394399;
        } //End block
        V previous;
        synchronized
(this)        {
            previous = map.remove(key);
    if(previous != null)            
            {
                size -= safeSizeOf(key, previous);
            } //End block
        } //End block
    if(previous != null)        
        {
            entryRemoved(false, key, previous, null);
        } //End block
V varAE805301EF6917CE0CF0EF15720ADBE0_1031920708 =         previous;
        varAE805301EF6917CE0CF0EF15720ADBE0_1031920708.addTaint(taint);
        return varAE805301EF6917CE0CF0EF15720ADBE0_1031920708;
        // ---------- Original Method ----------
        //if (key == null) {
            //throw new NullPointerException("key == null");
        //}
        //V previous;
        //synchronized (this) {
            //previous = map.remove(key);
            //if (previous != null) {
                //size -= safeSizeOf(key, previous);
            //}
        //}
        //if (previous != null) {
            //entryRemoved(false, key, previous, null);
        //}
        //return previous;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.044 -0400", hash_original_method = "9AD1617B914C1EE986412183164D996B", hash_generated_method = "D85B76C70BAD813556EC7465A7D0C22C")
    protected void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {
        addTaint(newValue.getTaint());
        addTaint(oldValue.getTaint());
        addTaint(key.getTaint());
        addTaint(evicted);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.045 -0400", hash_original_method = "56F7B4D0824C7980B3CF91C05C1DA172", hash_generated_method = "CC20CF9EE906130830681A41300E09C4")
    protected V create(K key) {
        addTaint(key.getTaint());
V var540C13E9E156B687226421B24F2DF178_596008758 =         null;
        var540C13E9E156B687226421B24F2DF178_596008758.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_596008758;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.045 -0400", hash_original_method = "971860883D94FE365FE71BDE260829D3", hash_generated_method = "A655E6ABF2E2366A1B3F994A03CE3488")
    private int safeSizeOf(K key, V value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        int result = sizeOf(key, value);
    if(result < 0)        
        {
            IllegalStateException var5797A9243A08E8E95BAA5059E55485D6_302800489 = new IllegalStateException("Negative size: " + key + "=" + value);
            var5797A9243A08E8E95BAA5059E55485D6_302800489.addTaint(taint);
            throw var5797A9243A08E8E95BAA5059E55485D6_302800489;
        } //End block
        int varB4A88417B3D0170D754C647C30B7216A_1699981396 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_586474202 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_586474202;
        // ---------- Original Method ----------
        //int result = sizeOf(key, value);
        //if (result < 0) {
            //throw new IllegalStateException("Negative size: " + key + "=" + value);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.046 -0400", hash_original_method = "6F73EAFB28729CDC0BB32AECE7CD1246", hash_generated_method = "44A87F6658B1CE58D6C71726255CF1E2")
    protected int sizeOf(K key, V value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        int varC4CA4238A0B923820DCC509A6F75849B_477216717 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1608487326 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1608487326;
        // ---------- Original Method ----------
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.047 -0400", hash_original_method = "D3EB145ED9D558FDF887F10175D8EBDF", hash_generated_method = "6852E1E415BA1B80059D4CFD58DC38F6")
    public final void evictAll() {
        trimToSize(-1);
        // ---------- Original Method ----------
        //trimToSize(-1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.047 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "4DF113001B0FDD934C931183595FB04C")
    public synchronized final int size() {
        int varF7BD60B75B29D79B660A2859395C1A24_1194172121 = (size);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_138071787 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_138071787;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.047 -0400", hash_original_method = "3468DBA84D0C4B093D85888533351ACC", hash_generated_method = "207B3ACC38AAE051749DDF0BC22D4B7E")
    public synchronized final int maxSize() {
        int varB78E1120B12ABD7215D67324FE9476FF_807097426 = (maxSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1085453067 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1085453067;
        // ---------- Original Method ----------
        //return maxSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.048 -0400", hash_original_method = "58C54B9E60920B23E133E0E61BF2A4F4", hash_generated_method = "1A0F4F7B5CE0A49475F659D6A13851F0")
    public synchronized final int hitCount() {
        int var5BBBCEBEEA805F9664B2979FBACE5699_468699841 = (hitCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1225472163 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1225472163;
        // ---------- Original Method ----------
        //return hitCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.048 -0400", hash_original_method = "CD33CA8BAAD7A20717BABBDF22DCC17E", hash_generated_method = "2331CC535E4C3BABADEF686A5B20EC0C")
    public synchronized final int missCount() {
        int var698B6BDB01E0C702797DD865E1B3FBBB_226052795 = (missCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_69461427 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_69461427;
        // ---------- Original Method ----------
        //return missCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.048 -0400", hash_original_method = "03691337F25E7C4DFAAA3B9F69FCDA1E", hash_generated_method = "2130D0B9088E215541B8F89256CE7634")
    public synchronized final int createCount() {
        int var1EFE30A68A1999763186AA8A0FF431E2_1371575437 = (createCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_910072029 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_910072029;
        // ---------- Original Method ----------
        //return createCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.049 -0400", hash_original_method = "291437E08BF34B71B9E36D69031C2701", hash_generated_method = "515F3A69E10B4EDBC2E17890E77224E8")
    public synchronized final int putCount() {
        int varB5E773FF0DAA7AF2D35B09A2ACE97C38_176384242 = (putCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1723388356 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1723388356;
        // ---------- Original Method ----------
        //return putCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.049 -0400", hash_original_method = "21AA3C6AE5648A36F9E47AF2806112A8", hash_generated_method = "4ACE0D703A686B1B0B471AC6737FD2FC")
    public synchronized final int evictionCount() {
        int var3E1471C5E3C695ABC459C18E113BDF6F_473334767 = (evictionCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1029295677 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1029295677;
        // ---------- Original Method ----------
        //return evictionCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.049 -0400", hash_original_method = "8A5EBF82F92FAE3DB13A729C4B6DDBA4", hash_generated_method = "34F4273C3DDCA0BF7AD9AA55DA1854BD")
    public synchronized final Map<K, V> snapshot() {
Map<K, V> var7CBA52F3D0FF67B0A6C8182187BA636E_89212500 =         new LinkedHashMap<K, V>(map);
        var7CBA52F3D0FF67B0A6C8182187BA636E_89212500.addTaint(taint);
        return var7CBA52F3D0FF67B0A6C8182187BA636E_89212500;
        // ---------- Original Method ----------
        //return new LinkedHashMap<K, V>(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:48.050 -0400", hash_original_method = "D511C7B644032E2A9485769132851C89", hash_generated_method = "21B35FCB5C7952139ADF7679CD4BC276")
    @Override
    public synchronized final String toString() {
        int accesses = hitCount + missCount;
        int hitPercent = accesses != 0 ? (100 * hitCount / accesses) : 0;
String var3613CB17148F5894DE67CC8125058E08_1685605264 =         String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]",
                maxSize, hitCount, missCount, hitPercent);
        var3613CB17148F5894DE67CC8125058E08_1685605264.addTaint(taint);
        return var3613CB17148F5894DE67CC8125058E08_1685605264;
        // ---------- Original Method ----------
        //int accesses = hitCount + missCount;
        //int hitPercent = accesses != 0 ? (100 * hitCount / accesses) : 0;
        //return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]",
                //maxSize, hitCount, missCount, hitPercent);
    }

    
}

