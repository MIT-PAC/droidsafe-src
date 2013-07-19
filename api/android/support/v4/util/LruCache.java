package android.support.v4.util;

// Droidsafe Imports
import java.util.LinkedHashMap;
import java.util.Map;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class LruCache<K, V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.072 -0400", hash_original_field = "1D78DC8ED51214E518B5114FE24490AE", hash_generated_field = "008FED306747468EE2384D75A989933A")

    private LinkedHashMap<K, V> map;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.072 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.072 -0400", hash_original_field = "B78E1120B12ABD7215D67324FE9476FF", hash_generated_field = "1486672EB97014EA466DAAF4AA4FAF69")

    private int maxSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.072 -0400", hash_original_field = "B5E773FF0DAA7AF2D35B09A2ACE97C38", hash_generated_field = "19F4FFEE16EDFF5AE45C5FE9A1BFB8DE")

    private int putCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.073 -0400", hash_original_field = "1EFE30A68A1999763186AA8A0FF431E2", hash_generated_field = "E17BC39B90B7FC1868ABCF5E868DC1F0")

    private int createCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.073 -0400", hash_original_field = "3E1471C5E3C695ABC459C18E113BDF6F", hash_generated_field = "5818FEEB77D22B7930FC3E6082C766A2")

    private int evictionCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.073 -0400", hash_original_field = "5BBBCEBEEA805F9664B2979FBACE5699", hash_generated_field = "32AD557D5385B14E2A17100B12982F49")

    private int hitCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.073 -0400", hash_original_field = "698B6BDB01E0C702797DD865E1B3FBBB", hash_generated_field = "F9F39FB5A1CA690A1C15055CB8F2E309")

    private int missCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.073 -0400", hash_original_method = "4EF140C80EBAC1C26C5562E76AB6C34D", hash_generated_method = "2C6C9A735F0BE3BC2C3CE54D29C89C0B")
    public  LruCache(int maxSize) {
        if(maxSize <= 0)        
        {
            IllegalArgumentException var4544452255288BB771A9A259F8205DC3_491108229 = new IllegalArgumentException("maxSize <= 0");
            var4544452255288BB771A9A259F8205DC3_491108229.addTaint(taint);
            throw var4544452255288BB771A9A259F8205DC3_491108229;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.075 -0400", hash_original_method = "E5DC52D3C4EAEBC9C86A603CE5606C4A", hash_generated_method = "1F70685DE934B91A2E44B77B6EA101F3")
    public final V get(K key) {
        if(key == null)        
        {
            NullPointerException var3408376C603A4BD36F703BF88588B8F4_832038649 = new NullPointerException("key == null");
            var3408376C603A4BD36F703BF88588B8F4_832038649.addTaint(taint);
            throw var3408376C603A4BD36F703BF88588B8F4_832038649;
        } //End block
        V mapValue;
        synchronized
(this)        {
            mapValue = map.get(key);
            if(mapValue != null)            
            {
                hitCount++;
V varF8515BBCD094CE53DC4052C62BA3144D_1385032919 =                 mapValue;
                varF8515BBCD094CE53DC4052C62BA3144D_1385032919.addTaint(taint);
                return varF8515BBCD094CE53DC4052C62BA3144D_1385032919;
            } //End block
            missCount++;
        } //End block
        V createdValue = create(key);
        if(createdValue == null)        
        {
V var540C13E9E156B687226421B24F2DF178_169419420 =             null;
            var540C13E9E156B687226421B24F2DF178_169419420.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_169419420;
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
V varF8515BBCD094CE53DC4052C62BA3144D_1707280743 =             mapValue;
            varF8515BBCD094CE53DC4052C62BA3144D_1707280743.addTaint(taint);
            return varF8515BBCD094CE53DC4052C62BA3144D_1707280743;
        } //End block
        else
        {
            trimToSize(maxSize);
V var887CC428FAE3E4113D67DDB6E0274549_586250023 =             createdValue;
            var887CC428FAE3E4113D67DDB6E0274549_586250023.addTaint(taint);
            return var887CC428FAE3E4113D67DDB6E0274549_586250023;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.076 -0400", hash_original_method = "79B383546C2B260561E7B3FD1850F381", hash_generated_method = "603CBBE71E690668AAC0D334773F3E6B")
    public final V put(K key, V value) {
        if(key == null || value == null)        
        {
            NullPointerException var1CDCE0A2CFC6A318D6FC14D56E7A9AFD_1360184315 = new NullPointerException("key == null || value == null");
            var1CDCE0A2CFC6A318D6FC14D56E7A9AFD_1360184315.addTaint(taint);
            throw var1CDCE0A2CFC6A318D6FC14D56E7A9AFD_1360184315;
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
V varAE805301EF6917CE0CF0EF15720ADBE0_1618001416 =         previous;
        varAE805301EF6917CE0CF0EF15720ADBE0_1618001416.addTaint(taint);
        return varAE805301EF6917CE0CF0EF15720ADBE0_1618001416;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.077 -0400", hash_original_method = "82D005458BB4BC837252CC0C6863637E", hash_generated_method = "F6735E7BBED8DD19677C397CEC94215D")
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
                    IllegalStateException varEFA1EB63E20171257D59ACAB759ACF03_579336463 = new IllegalStateException(getClass().getName()
                            + ".sizeOf() is reporting inconsistent results!");
                    varEFA1EB63E20171257D59ACAB759ACF03_579336463.addTaint(taint);
                    throw varEFA1EB63E20171257D59ACAB759ACF03_579336463;
                } //End block
                if(size <= maxSize || map.isEmpty())                
                {
                    break;
                } //End block
                Map.Entry<K, V> toEvict = map.entrySet().iterator().next();
                key = toEvict.getKey();
                value = toEvict.getValue();
                map.remove(key);
                size -= safeSizeOf(key, value);
                evictionCount++;
            } //End block
            entryRemoved(true, key, value, null);
        } //End block
        // ---------- Original Method ----------
        //while (true) {
            //K key;
            //V value;
            //synchronized (this) {
                //if (size < 0 || (map.isEmpty() && size != 0)) {
                    //throw new IllegalStateException(getClass().getName()
                            //+ ".sizeOf() is reporting inconsistent results!");
                //}
                //if (size <= maxSize || map.isEmpty()) {
                    //break;
                //}
                //Map.Entry<K, V> toEvict = map.entrySet().iterator().next();
                //key = toEvict.getKey();
                //value = toEvict.getValue();
                //map.remove(key);
                //size -= safeSizeOf(key, value);
                //evictionCount++;
            //}
            //entryRemoved(true, key, value, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.078 -0400", hash_original_method = "5ECD46803ACE6D1B641401078C3B9D9C", hash_generated_method = "46BAC879A1F48F83AC8A798E6F8C38C3")
    public final V remove(K key) {
        if(key == null)        
        {
            NullPointerException var3408376C603A4BD36F703BF88588B8F4_1319884653 = new NullPointerException("key == null");
            var3408376C603A4BD36F703BF88588B8F4_1319884653.addTaint(taint);
            throw var3408376C603A4BD36F703BF88588B8F4_1319884653;
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
V varAE805301EF6917CE0CF0EF15720ADBE0_2015789417 =         previous;
        varAE805301EF6917CE0CF0EF15720ADBE0_2015789417.addTaint(taint);
        return varAE805301EF6917CE0CF0EF15720ADBE0_2015789417;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.079 -0400", hash_original_method = "9AD1617B914C1EE986412183164D996B", hash_generated_method = "D85B76C70BAD813556EC7465A7D0C22C")
    protected void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {
        addTaint(newValue.getTaint());
        addTaint(oldValue.getTaint());
        addTaint(key.getTaint());
        addTaint(evicted);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.080 -0400", hash_original_method = "56F7B4D0824C7980B3CF91C05C1DA172", hash_generated_method = "F29008A839046E53F62E881358828803")
    protected V create(K key) {
        addTaint(key.getTaint());
V var540C13E9E156B687226421B24F2DF178_273881131 =         null;
        var540C13E9E156B687226421B24F2DF178_273881131.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_273881131;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.080 -0400", hash_original_method = "971860883D94FE365FE71BDE260829D3", hash_generated_method = "821BEDF91E51EDB0E28C7673DAE2CF07")
    private int safeSizeOf(K key, V value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        int result = sizeOf(key, value);
        if(result < 0)        
        {
            IllegalStateException var5797A9243A08E8E95BAA5059E55485D6_1323865714 = new IllegalStateException("Negative size: " + key + "=" + value);
            var5797A9243A08E8E95BAA5059E55485D6_1323865714.addTaint(taint);
            throw var5797A9243A08E8E95BAA5059E55485D6_1323865714;
        } //End block
        int varB4A88417B3D0170D754C647C30B7216A_1774265076 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1327144953 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1327144953;
        // ---------- Original Method ----------
        //int result = sizeOf(key, value);
        //if (result < 0) {
            //throw new IllegalStateException("Negative size: " + key + "=" + value);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.081 -0400", hash_original_method = "6F73EAFB28729CDC0BB32AECE7CD1246", hash_generated_method = "0A7FC33EE446940A1EEA9962D21F2134")
    protected int sizeOf(K key, V value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        int varC4CA4238A0B923820DCC509A6F75849B_1496822061 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_381041835 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_381041835;
        // ---------- Original Method ----------
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.081 -0400", hash_original_method = "D3EB145ED9D558FDF887F10175D8EBDF", hash_generated_method = "6852E1E415BA1B80059D4CFD58DC38F6")
    public final void evictAll() {
        trimToSize(-1);
        // ---------- Original Method ----------
        //trimToSize(-1);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.081 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "9F77FDA134A66DAFB2BDC3CA334B6F1C")
    public synchronized final int size() {
        int varF7BD60B75B29D79B660A2859395C1A24_1881189393 = (size);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1161153057 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1161153057;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.081 -0400", hash_original_method = "3468DBA84D0C4B093D85888533351ACC", hash_generated_method = "A959C7F0301E2D571A3833550D2AA33A")
    public synchronized final int maxSize() {
        int varB78E1120B12ABD7215D67324FE9476FF_23163743 = (maxSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_557940477 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_557940477;
        // ---------- Original Method ----------
        //return maxSize;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.081 -0400", hash_original_method = "58C54B9E60920B23E133E0E61BF2A4F4", hash_generated_method = "6311742D4FFD407D29A468AC9D088F12")
    public synchronized final int hitCount() {
        int var5BBBCEBEEA805F9664B2979FBACE5699_1658551522 = (hitCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_629295658 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_629295658;
        // ---------- Original Method ----------
        //return hitCount;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.082 -0400", hash_original_method = "CD33CA8BAAD7A20717BABBDF22DCC17E", hash_generated_method = "CB6099FE8027974F83066519606701B6")
    public synchronized final int missCount() {
        int var698B6BDB01E0C702797DD865E1B3FBBB_734243283 = (missCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_658019745 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_658019745;
        // ---------- Original Method ----------
        //return missCount;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.082 -0400", hash_original_method = "03691337F25E7C4DFAAA3B9F69FCDA1E", hash_generated_method = "E83607A8FD5A32D43BE7F49ACA497672")
    public synchronized final int createCount() {
        int var1EFE30A68A1999763186AA8A0FF431E2_987747017 = (createCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_346346580 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_346346580;
        // ---------- Original Method ----------
        //return createCount;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.082 -0400", hash_original_method = "291437E08BF34B71B9E36D69031C2701", hash_generated_method = "EA755D85D03A2279AE7D2BB29E233259")
    public synchronized final int putCount() {
        int varB5E773FF0DAA7AF2D35B09A2ACE97C38_547626248 = (putCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1996710895 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1996710895;
        // ---------- Original Method ----------
        //return putCount;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.082 -0400", hash_original_method = "21AA3C6AE5648A36F9E47AF2806112A8", hash_generated_method = "CFD56904DFBB3386C387FF0AD1470B37")
    public synchronized final int evictionCount() {
        int var3E1471C5E3C695ABC459C18E113BDF6F_465614850 = (evictionCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1240674708 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1240674708;
        // ---------- Original Method ----------
        //return evictionCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.083 -0400", hash_original_method = "8A5EBF82F92FAE3DB13A729C4B6DDBA4", hash_generated_method = "34F99024A94A64CB74B08C14A49C9351")
    public synchronized final Map<K, V> snapshot() {
Map<K, V> var7CBA52F3D0FF67B0A6C8182187BA636E_520054507 =         new LinkedHashMap<K, V>(map);
        var7CBA52F3D0FF67B0A6C8182187BA636E_520054507.addTaint(taint);
        return var7CBA52F3D0FF67B0A6C8182187BA636E_520054507;
        // ---------- Original Method ----------
        //return new LinkedHashMap<K, V>(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.083 -0400", hash_original_method = "D511C7B644032E2A9485769132851C89", hash_generated_method = "2A51C4FB1A3CCF9A9FA06A069E0D90B9")
    @Override
    public synchronized final String toString() {
        int accesses = hitCount + missCount;
        int hitPercent = accesses != 0 ? (100 * hitCount / accesses) : 0;
String var3613CB17148F5894DE67CC8125058E08_551804042 =         String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]",
                maxSize, hitCount, missCount, hitPercent);
        var3613CB17148F5894DE67CC8125058E08_551804042.addTaint(taint);
        return var3613CB17148F5894DE67CC8125058E08_551804042;
        // ---------- Original Method ----------
        //int accesses = hitCount + missCount;
        //int hitPercent = accesses != 0 ? (100 * hitCount / accesses) : 0;
        //return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]",
                //maxSize, hitCount, missCount, hitPercent);
    }

    
}

