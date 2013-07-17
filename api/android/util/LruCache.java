package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<K, V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.874 -0400", hash_original_field = "1D78DC8ED51214E518B5114FE24490AE", hash_generated_field = "008FED306747468EE2384D75A989933A")

    private LinkedHashMap<K, V> map;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.874 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.874 -0400", hash_original_field = "B78E1120B12ABD7215D67324FE9476FF", hash_generated_field = "1486672EB97014EA466DAAF4AA4FAF69")

    private int maxSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.874 -0400", hash_original_field = "B5E773FF0DAA7AF2D35B09A2ACE97C38", hash_generated_field = "19F4FFEE16EDFF5AE45C5FE9A1BFB8DE")

    private int putCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.874 -0400", hash_original_field = "1EFE30A68A1999763186AA8A0FF431E2", hash_generated_field = "E17BC39B90B7FC1868ABCF5E868DC1F0")

    private int createCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.874 -0400", hash_original_field = "3E1471C5E3C695ABC459C18E113BDF6F", hash_generated_field = "5818FEEB77D22B7930FC3E6082C766A2")

    private int evictionCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.874 -0400", hash_original_field = "5BBBCEBEEA805F9664B2979FBACE5699", hash_generated_field = "32AD557D5385B14E2A17100B12982F49")

    private int hitCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.874 -0400", hash_original_field = "698B6BDB01E0C702797DD865E1B3FBBB", hash_generated_field = "F9F39FB5A1CA690A1C15055CB8F2E309")

    private int missCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.875 -0400", hash_original_method = "4EF140C80EBAC1C26C5562E76AB6C34D", hash_generated_method = "B661016043A59CCB0A803A0E76385341")
    public  LruCache(int maxSize) {
        if(maxSize <= 0)        
        {
            IllegalArgumentException var4544452255288BB771A9A259F8205DC3_2040968467 = new IllegalArgumentException("maxSize <= 0");
            var4544452255288BB771A9A259F8205DC3_2040968467.addTaint(taint);
            throw var4544452255288BB771A9A259F8205DC3_2040968467;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.876 -0400", hash_original_method = "E5DC52D3C4EAEBC9C86A603CE5606C4A", hash_generated_method = "B528B548D71694E5C287ED3475470DED")
    public final V get(K key) {
        if(key == null)        
        {
            NullPointerException var3408376C603A4BD36F703BF88588B8F4_282186177 = new NullPointerException("key == null");
            var3408376C603A4BD36F703BF88588B8F4_282186177.addTaint(taint);
            throw var3408376C603A4BD36F703BF88588B8F4_282186177;
        } //End block
        V mapValue;
        synchronized
(this)        {
            mapValue = map.get(key);
            if(mapValue != null)            
            {
                hitCount++;
V varF8515BBCD094CE53DC4052C62BA3144D_720053608 =                 mapValue;
                varF8515BBCD094CE53DC4052C62BA3144D_720053608.addTaint(taint);
                return varF8515BBCD094CE53DC4052C62BA3144D_720053608;
            } //End block
            missCount++;
        } //End block
        V createdValue = create(key);
        if(createdValue == null)        
        {
V var540C13E9E156B687226421B24F2DF178_2085535704 =             null;
            var540C13E9E156B687226421B24F2DF178_2085535704.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2085535704;
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
V varF8515BBCD094CE53DC4052C62BA3144D_574098534 =             mapValue;
            varF8515BBCD094CE53DC4052C62BA3144D_574098534.addTaint(taint);
            return varF8515BBCD094CE53DC4052C62BA3144D_574098534;
        } //End block
        else
        {
            trimToSize(maxSize);
V var887CC428FAE3E4113D67DDB6E0274549_1090023109 =             createdValue;
            var887CC428FAE3E4113D67DDB6E0274549_1090023109.addTaint(taint);
            return var887CC428FAE3E4113D67DDB6E0274549_1090023109;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.877 -0400", hash_original_method = "79B383546C2B260561E7B3FD1850F381", hash_generated_method = "C34C2AF022AD0751EB41EFA8D7C1649B")
    public final V put(K key, V value) {
        if(key == null || value == null)        
        {
            NullPointerException var1CDCE0A2CFC6A318D6FC14D56E7A9AFD_904265728 = new NullPointerException("key == null || value == null");
            var1CDCE0A2CFC6A318D6FC14D56E7A9AFD_904265728.addTaint(taint);
            throw var1CDCE0A2CFC6A318D6FC14D56E7A9AFD_904265728;
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
V varAE805301EF6917CE0CF0EF15720ADBE0_1904774997 =         previous;
        varAE805301EF6917CE0CF0EF15720ADBE0_1904774997.addTaint(taint);
        return varAE805301EF6917CE0CF0EF15720ADBE0_1904774997;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.878 -0400", hash_original_method = "5A85F1994DB09F90DA92A4710FB4C22D", hash_generated_method = "62DD735914E47109C0E01C4B544C0766")
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
                    IllegalStateException varEFA1EB63E20171257D59ACAB759ACF03_680258980 = new IllegalStateException(getClass().getName()
                            + ".sizeOf() is reporting inconsistent results!");
                    varEFA1EB63E20171257D59ACAB759ACF03_680258980.addTaint(taint);
                    throw varEFA1EB63E20171257D59ACAB759ACF03_680258980;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.879 -0400", hash_original_method = "5ECD46803ACE6D1B641401078C3B9D9C", hash_generated_method = "91C8DF039575696EFEBB54049A3294DE")
    public final V remove(K key) {
        if(key == null)        
        {
            NullPointerException var3408376C603A4BD36F703BF88588B8F4_777591896 = new NullPointerException("key == null");
            var3408376C603A4BD36F703BF88588B8F4_777591896.addTaint(taint);
            throw var3408376C603A4BD36F703BF88588B8F4_777591896;
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
V varAE805301EF6917CE0CF0EF15720ADBE0_397232293 =         previous;
        varAE805301EF6917CE0CF0EF15720ADBE0_397232293.addTaint(taint);
        return varAE805301EF6917CE0CF0EF15720ADBE0_397232293;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.880 -0400", hash_original_method = "9AD1617B914C1EE986412183164D996B", hash_generated_method = "D85B76C70BAD813556EC7465A7D0C22C")
    protected void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {
        addTaint(newValue.getTaint());
        addTaint(oldValue.getTaint());
        addTaint(key.getTaint());
        addTaint(evicted);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.880 -0400", hash_original_method = "56F7B4D0824C7980B3CF91C05C1DA172", hash_generated_method = "9AE5D1E1A9194483A9A164F6F8155FF1")
    protected V create(K key) {
        addTaint(key.getTaint());
V var540C13E9E156B687226421B24F2DF178_355529424 =         null;
        var540C13E9E156B687226421B24F2DF178_355529424.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_355529424;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.880 -0400", hash_original_method = "971860883D94FE365FE71BDE260829D3", hash_generated_method = "77B6CA7B07C23D7E7823B04918523398")
    private int safeSizeOf(K key, V value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        int result = sizeOf(key, value);
        if(result < 0)        
        {
            IllegalStateException var5797A9243A08E8E95BAA5059E55485D6_1383635212 = new IllegalStateException("Negative size: " + key + "=" + value);
            var5797A9243A08E8E95BAA5059E55485D6_1383635212.addTaint(taint);
            throw var5797A9243A08E8E95BAA5059E55485D6_1383635212;
        } //End block
        int varB4A88417B3D0170D754C647C30B7216A_953818558 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1902546146 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1902546146;
        // ---------- Original Method ----------
        //int result = sizeOf(key, value);
        //if (result < 0) {
            //throw new IllegalStateException("Negative size: " + key + "=" + value);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.881 -0400", hash_original_method = "6F73EAFB28729CDC0BB32AECE7CD1246", hash_generated_method = "FA25461615F4C308E1545F413FA6EE09")
    protected int sizeOf(K key, V value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        int varC4CA4238A0B923820DCC509A6F75849B_1076425407 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_162709505 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_162709505;
        // ---------- Original Method ----------
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.881 -0400", hash_original_method = "D3EB145ED9D558FDF887F10175D8EBDF", hash_generated_method = "6852E1E415BA1B80059D4CFD58DC38F6")
    public final void evictAll() {
        trimToSize(-1);
        // ---------- Original Method ----------
        //trimToSize(-1);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.881 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "C00412907BABDBAB67786F48125AB39F")
    public synchronized final int size() {
        int varF7BD60B75B29D79B660A2859395C1A24_1072567860 = (size);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_625994403 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_625994403;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.881 -0400", hash_original_method = "3468DBA84D0C4B093D85888533351ACC", hash_generated_method = "B1A8A6024E59BFD2F5F78E6D05DFE071")
    public synchronized final int maxSize() {
        int varB78E1120B12ABD7215D67324FE9476FF_1297224312 = (maxSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2009456218 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2009456218;
        // ---------- Original Method ----------
        //return maxSize;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.882 -0400", hash_original_method = "58C54B9E60920B23E133E0E61BF2A4F4", hash_generated_method = "EEEACCC7DC56022FAD412CC01CBB693C")
    public synchronized final int hitCount() {
        int var5BBBCEBEEA805F9664B2979FBACE5699_1217377492 = (hitCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1847602536 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1847602536;
        // ---------- Original Method ----------
        //return hitCount;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.882 -0400", hash_original_method = "CD33CA8BAAD7A20717BABBDF22DCC17E", hash_generated_method = "2305AC12CA1A7C5441DDC5FBBEE489F3")
    public synchronized final int missCount() {
        int var698B6BDB01E0C702797DD865E1B3FBBB_761865124 = (missCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_163945193 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_163945193;
        // ---------- Original Method ----------
        //return missCount;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.882 -0400", hash_original_method = "03691337F25E7C4DFAAA3B9F69FCDA1E", hash_generated_method = "0EBF79BE45875AE75EA805CD1F771EF1")
    public synchronized final int createCount() {
        int var1EFE30A68A1999763186AA8A0FF431E2_1839693477 = (createCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_930543530 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_930543530;
        // ---------- Original Method ----------
        //return createCount;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.882 -0400", hash_original_method = "291437E08BF34B71B9E36D69031C2701", hash_generated_method = "F14E4B008EF67651F0EF1E4E535C0818")
    public synchronized final int putCount() {
        int varB5E773FF0DAA7AF2D35B09A2ACE97C38_2006148194 = (putCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1672890195 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1672890195;
        // ---------- Original Method ----------
        //return putCount;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.883 -0400", hash_original_method = "21AA3C6AE5648A36F9E47AF2806112A8", hash_generated_method = "46B9A805F19058D94B4FDEE0518F280F")
    public synchronized final int evictionCount() {
        int var3E1471C5E3C695ABC459C18E113BDF6F_190318607 = (evictionCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_888772354 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_888772354;
        // ---------- Original Method ----------
        //return evictionCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.883 -0400", hash_original_method = "8A5EBF82F92FAE3DB13A729C4B6DDBA4", hash_generated_method = "39B6F359B41D315B3C598CC567A45A61")
    public synchronized final Map<K, V> snapshot() {
Map<K, V> var7CBA52F3D0FF67B0A6C8182187BA636E_2071997382 =         new LinkedHashMap<K, V>(map);
        var7CBA52F3D0FF67B0A6C8182187BA636E_2071997382.addTaint(taint);
        return var7CBA52F3D0FF67B0A6C8182187BA636E_2071997382;
        // ---------- Original Method ----------
        //return new LinkedHashMap<K, V>(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.883 -0400", hash_original_method = "D511C7B644032E2A9485769132851C89", hash_generated_method = "51CB3FC623A32C42F5667026F0BA84C4")
    @Override
    public synchronized final String toString() {
        int accesses = hitCount + missCount;
        int hitPercent = accesses != 0 ? (100 * hitCount / accesses) : 0;
String var3613CB17148F5894DE67CC8125058E08_1918607745 =         String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]",
                maxSize, hitCount, missCount, hitPercent);
        var3613CB17148F5894DE67CC8125058E08_1918607745.addTaint(taint);
        return var3613CB17148F5894DE67CC8125058E08_1918607745;
        // ---------- Original Method ----------
        //int accesses = hitCount + missCount;
        //int hitPercent = accesses != 0 ? (100 * hitCount / accesses) : 0;
        //return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]",
                //maxSize, hitCount, missCount, hitPercent);
    }

    
}

