package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class LinkedHashMap<K, V> extends HashMap<K, V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.810 -0400", hash_original_field = "099FB995346F31C749F6E40DB0F395E3", hash_generated_field = "D6704B8F26715061947446A5240B101A")

    transient LinkedEntry<K, V> header;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.810 -0400", hash_original_field = "B1B8F9258C25833E563A747875ABA3F3", hash_generated_field = "3F26D7AF65C932D73D31BA6C85FF3982")

    private boolean accessOrder;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.810 -0400", hash_original_method = "BC14FA557BD7B0B9C577C3EA20F65BB1", hash_generated_method = "841BDE13C0D724F59D7372319DB3BC68")
    public  LinkedHashMap() {
        init();
        accessOrder = false;
        // ---------- Original Method ----------
        //init();
        //accessOrder = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.810 -0400", hash_original_method = "D0F194CEDBAC4E60D053508661AB90EF", hash_generated_method = "AF81C3A6342901CDC78A39BBC8257F31")
    public  LinkedHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
        addTaint(initialCapacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.811 -0400", hash_original_method = "51A3F20C6E131F4E066F002E9C38CBA5", hash_generated_method = "E801E70E5B9A8065A7FA1C2E98EF899F")
    public  LinkedHashMap(int initialCapacity, float loadFactor) {
        this(initialCapacity, loadFactor, false);
        addTaint(loadFactor);
        addTaint(initialCapacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.811 -0400", hash_original_method = "40A72D68B61D12122A849997E9E4FA74", hash_generated_method = "D77757EB06EAB7C9CBF5A87B44178E77")
    public  LinkedHashMap(
            int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor);
        addTaint(loadFactor);
        addTaint(initialCapacity);
        init();
        this.accessOrder = accessOrder;
        // ---------- Original Method ----------
        //init();
        //this.accessOrder = accessOrder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.811 -0400", hash_original_method = "D1B0A8129B2843C851AD81FABBEE8B92", hash_generated_method = "F3C1A40CECC0CD85D317FD2AB157DBCF")
    public  LinkedHashMap(Map<? extends K, ? extends V> map) {
        this(capacityForInitSize(map.size()));
        addTaint(map.getTaint());
        constructorPutAll(map);
        // ---------- Original Method ----------
        //constructorPutAll(map);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.812 -0400", hash_original_method = "C3E8210D7C5926509287D8B7A9054888", hash_generated_method = "B6C5484F9803F011BF936D3E7CA26200")
    @Override
     void init() {
        header = new LinkedEntry<K, V>();
        // ---------- Original Method ----------
        //header = new LinkedEntry<K, V>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.812 -0400", hash_original_method = "EB729947D8C5A87C341C9E9026AB1206", hash_generated_method = "EA9C0E165636DC88C7AA2593C8559569")
    public Entry<K, V> eldest() {
        LinkedEntry<K, V> eldest = header.nxt;
Entry<K, V> varE0B314C45F4873EC0C98E000D41141FA_1098001952 =         eldest != header ? eldest : null;
        varE0B314C45F4873EC0C98E000D41141FA_1098001952.addTaint(taint);
        return varE0B314C45F4873EC0C98E000D41141FA_1098001952;
        // ---------- Original Method ----------
        //LinkedEntry<K, V> eldest = header.nxt;
        //return eldest != header ? eldest : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.813 -0400", hash_original_method = "17248B030D95A40DE3DEF1923640BDC2", hash_generated_method = "F13E911720E4D6BF28D1BA65D5E3CAD0")
    @Override
     void addNewEntry(K key, V value, int hash, int index) {
        addTaint(index);
        addTaint(hash);
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        LinkedEntry<K, V> header = this.header;
        LinkedEntry<K, V> eldest = header.nxt;
    if(eldest != header && removeEldestEntry(eldest))        
        {
            remove(eldest.key);
        } //End block
        LinkedEntry<K, V> oldTail = header.prv;
        LinkedEntry<K, V> newTail = new LinkedEntry<K,V>(
                key, value, hash, table[index], header, oldTail);
        table[index] = oldTail.nxt = header.prv = newTail;
        // ---------- Original Method ----------
        //LinkedEntry<K, V> header = this.header;
        //LinkedEntry<K, V> eldest = header.nxt;
        //if (eldest != header && removeEldestEntry(eldest)) {
            //remove(eldest.key);
        //}
        //LinkedEntry<K, V> oldTail = header.prv;
        //LinkedEntry<K, V> newTail = new LinkedEntry<K,V>(
                //key, value, hash, table[index], header, oldTail);
        //table[index] = oldTail.nxt = header.prv = newTail;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.813 -0400", hash_original_method = "53E46D1C7C140F5769FD83EFA867F0EB", hash_generated_method = "E31DCE9A89CD69F6A6F7ED11696CBD2A")
    @Override
     void addNewEntryForNullKey(V value) {
        addTaint(value.getTaint());
        LinkedEntry<K, V> header = this.header;
        LinkedEntry<K, V> eldest = header.nxt;
    if(eldest != header && removeEldestEntry(eldest))        
        {
            remove(eldest.key);
        } //End block
        LinkedEntry<K, V> oldTail = header.prv;
        LinkedEntry<K, V> newTail = new LinkedEntry<K,V>(
                null, value, 0, null, header, oldTail);
        entryForNullKey = oldTail.nxt = header.prv = newTail;
        // ---------- Original Method ----------
        //LinkedEntry<K, V> header = this.header;
        //LinkedEntry<K, V> eldest = header.nxt;
        //if (eldest != header && removeEldestEntry(eldest)) {
            //remove(eldest.key);
        //}
        //LinkedEntry<K, V> oldTail = header.prv;
        //LinkedEntry<K, V> newTail = new LinkedEntry<K,V>(
                //null, value, 0, null, header, oldTail);
        //entryForNullKey = oldTail.nxt = header.prv = newTail;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.814 -0400", hash_original_method = "DD7E1FD3A0E6B4968C119F3BE0C92615", hash_generated_method = "CCCF1669C6BD288742E593D6F7EA29F2")
    @Override
     HashMapEntry<K, V> constructorNewEntry(
            K key, V value, int hash, HashMapEntry<K, V> next) {
        addTaint(next.getTaint());
        addTaint(hash);
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        LinkedEntry<K, V> header = this.header;
        LinkedEntry<K, V> oldTail = header.prv;
        LinkedEntry<K, V> newTail = new LinkedEntry<K,V>(key, value, hash, next, header, oldTail);
HashMapEntry<K, V> var80578C1A2A213CB039565B6F7F57A514_107686525 =         oldTail.nxt = header.prv = newTail;
        var80578C1A2A213CB039565B6F7F57A514_107686525.addTaint(taint);
        return var80578C1A2A213CB039565B6F7F57A514_107686525;
        // ---------- Original Method ----------
        //LinkedEntry<K, V> header = this.header;
        //LinkedEntry<K, V> oldTail = header.prv;
        //LinkedEntry<K, V> newTail
                //= new LinkedEntry<K,V>(key, value, hash, next, header, oldTail);
        //return oldTail.nxt = header.prv = newTail;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.815 -0400", hash_original_method = "5C4F6BF9C2C1A7BF64D67EB60F9C3D15", hash_generated_method = "947E93969E99BC5EB3A0A547F3387828")
    @Override
    public V get(Object key) {
        addTaint(key.getTaint());
    if(key == null)        
        {
            HashMapEntry<K, V> e = entryForNullKey;
    if(e == null)            
            {
V var540C13E9E156B687226421B24F2DF178_108946119 =             null;
            var540C13E9E156B687226421B24F2DF178_108946119.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_108946119;
            }
    if(accessOrder)            
            makeTail((LinkedEntry<K, V>) e);
V var65D32B0ADAFF3F55986024909BAFC34B_936522436 =             e.value;
            var65D32B0ADAFF3F55986024909BAFC34B_936522436.addTaint(taint);
            return var65D32B0ADAFF3F55986024909BAFC34B_936522436;
        } //End block
        int hash = key.hashCode();
        hash ^= (hash >>> 20) ^ (hash >>> 12);
        hash ^= (hash >>> 7) ^ (hash >>> 4);
        HashMapEntry<K, V>[] tab = table;
for(HashMapEntry<K, V> e = tab[hash & (tab.length - 1)];e != null;e = e.next)
        {
            K eKey = e.key;
    if(eKey == key || (e.hash == hash && key.equals(eKey)))            
            {
    if(accessOrder)                
                makeTail((LinkedEntry<K, V>) e);
V var65D32B0ADAFF3F55986024909BAFC34B_1462126284 =                 e.value;
                var65D32B0ADAFF3F55986024909BAFC34B_1462126284.addTaint(taint);
                return var65D32B0ADAFF3F55986024909BAFC34B_1462126284;
            } //End block
        } //End block
V var540C13E9E156B687226421B24F2DF178_1931909130 =         null;
        var540C13E9E156B687226421B24F2DF178_1931909130.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1931909130;
        // ---------- Original Method ----------
        //if (key == null) {
            //HashMapEntry<K, V> e = entryForNullKey;
            //if (e == null)
                //return null;
            //if (accessOrder)
                //makeTail((LinkedEntry<K, V>) e);
            //return e.value;
        //}
        //int hash = key.hashCode();
        //hash ^= (hash >>> 20) ^ (hash >>> 12);
        //hash ^= (hash >>> 7) ^ (hash >>> 4);
        //HashMapEntry<K, V>[] tab = table;
        //for (HashMapEntry<K, V> e = tab[hash & (tab.length - 1)];
                //e != null; e = e.next) {
            //K eKey = e.key;
            //if (eKey == key || (e.hash == hash && key.equals(eKey))) {
                //if (accessOrder)
                    //makeTail((LinkedEntry<K, V>) e);
                //return e.value;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.816 -0400", hash_original_method = "D37211F13FFE982B5329A6F04D365268", hash_generated_method = "C6CD5BB404251D6B83F85F81B1319D29")
    private void makeTail(LinkedEntry<K, V> e) {
        addTaint(e.getTaint());
        e.prv.nxt = e.nxt;
        e.nxt.prv = e.prv;
        LinkedEntry<K, V> header = this.header;
        LinkedEntry<K, V> oldTail = header.prv;
        e.nxt = header;
        e.prv = oldTail;
        oldTail.nxt = header.prv = e;
        modCount++;
        // ---------- Original Method ----------
        //e.prv.nxt = e.nxt;
        //e.nxt.prv = e.prv;
        //LinkedEntry<K, V> header = this.header;
        //LinkedEntry<K, V> oldTail = header.prv;
        //e.nxt = header;
        //e.prv = oldTail;
        //oldTail.nxt = header.prv = e;
        //modCount++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.816 -0400", hash_original_method = "1F9A2707DB97E3137F0AF608EC157C5F", hash_generated_method = "AF6B2222E34BA821E796C165444C09A0")
    @Override
     void preModify(HashMapEntry<K, V> e) {
        addTaint(e.getTaint());
    if(accessOrder)        
        {
            makeTail((LinkedEntry<K, V>) e);
        } //End block
        // ---------- Original Method ----------
        //if (accessOrder) {
            //makeTail((LinkedEntry<K, V>) e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.817 -0400", hash_original_method = "7796AD94E39D6453B5D3B10446A6CDCE", hash_generated_method = "1A6B90696A29602D810905FCE3792E3A")
    @Override
     void postRemove(HashMapEntry<K, V> e) {
        addTaint(e.getTaint());
        LinkedEntry<K, V> le = (LinkedEntry<K, V>) e;
        le.prv.nxt = le.nxt;
        le.nxt.prv = le.prv;
        le.nxt = le.prv = null;
        // ---------- Original Method ----------
        //LinkedEntry<K, V> le = (LinkedEntry<K, V>) e;
        //le.prv.nxt = le.nxt;
        //le.nxt.prv = le.prv;
        //le.nxt = le.prv = null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.817 -0400", hash_original_method = "B1ADF7F2DAB1D611A8BB20D2E6FE8BE5", hash_generated_method = "236C33D1774C1D7CBB83343686FA6329")
    @Override
    public boolean containsValue(Object value) {
        addTaint(value.getTaint());
    if(value == null)        
        {
for(LinkedEntry<K, V> header = this.header, e = header.nxt;e != header;e = e.nxt)
            {
    if(e.value == null)                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1418236758 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_861094947 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_861094947;
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_2010903448 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1818054187 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1818054187;
        } //End block
for(LinkedEntry<K, V> header = this.header, e = header.nxt;e != header;e = e.nxt)
        {
    if(value.equals(e.value))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1378961991 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1034977798 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1034977798;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1223335047 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1560824081 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1560824081;
        // ---------- Original Method ----------
        //if (value == null) {
            //for (LinkedEntry<K, V> header = this.header, e = header.nxt;
                    //e != header; e = e.nxt) {
                //if (e.value == null) {
                    //return true;
                //}
            //}
            //return false;
        //}
        //for (LinkedEntry<K, V> header = this.header, e = header.nxt;
                //e != header; e = e.nxt) {
            //if (value.equals(e.value)) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.818 -0400", hash_original_method = "F9D4D1514A1438141913ED2857BCCF60", hash_generated_method = "42D44FE5A2B11F5F7559D39007BEC865")
    public void clear() {
        super.clear();
        LinkedEntry<K, V> header = this.header;
for(LinkedEntry<K, V> e = header.nxt;e != header;)
        {
            LinkedEntry<K, V> nxt = e.nxt;
            e.nxt = e.prv = null;
            e = nxt;
        } //End block
        header.nxt = header.prv = header;
        // ---------- Original Method ----------
        //super.clear();
        //LinkedEntry<K, V> header = this.header;
        //for (LinkedEntry<K, V> e = header.nxt; e != header; ) {
            //LinkedEntry<K, V> nxt = e.nxt;
            //e.nxt = e.prv = null;
            //e = nxt;
        //}
        //header.nxt = header.prv = header;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.819 -0400", hash_original_method = "E5C2B853B7FE0DFF8A1198070D9AED67", hash_generated_method = "1B9E0DF53FFC62165B28B552203550C5")
    @Override
     Iterator<K> newKeyIterator() {
Iterator<K> var3934136BB713579A43A8E8C1C3034CA0_1429189303 =         new KeyIterator();
        var3934136BB713579A43A8E8C1C3034CA0_1429189303.addTaint(taint);
        return var3934136BB713579A43A8E8C1C3034CA0_1429189303;
        // ---------- Original Method ----------
        //return new KeyIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.819 -0400", hash_original_method = "58BEE1C21CE9010029EB8FF9FDCDF9B3", hash_generated_method = "8EEBB11085B174845054967E8C7DE953")
    @Override
     Iterator<V> newValueIterator() {
Iterator<V> varA5D0B7DD47403A81B3461DEE499DEE74_798128277 =         new ValueIterator();
        varA5D0B7DD47403A81B3461DEE499DEE74_798128277.addTaint(taint);
        return varA5D0B7DD47403A81B3461DEE499DEE74_798128277;
        // ---------- Original Method ----------
        //return new ValueIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.819 -0400", hash_original_method = "7416C435C60270F3DC14B8CDBC0FF1EF", hash_generated_method = "07BD49D3FC687EACF78C187273C75F79")
    @Override
     Iterator<Map.Entry<K, V>> newEntryIterator() {
Iterator<Map.Entry<K, V>> varA27729B8E339A6F174B2D9A9BA7B896F_1396995811 =         new EntryIterator();
        varA27729B8E339A6F174B2D9A9BA7B896F_1396995811.addTaint(taint);
        return varA27729B8E339A6F174B2D9A9BA7B896F_1396995811;
        // ---------- Original Method ----------
        //return new EntryIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.820 -0400", hash_original_method = "F4EE8618F7DE6E7966D8D47C993C665B", hash_generated_method = "0E067BDD3385999E635A06A5C90F0878")
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        addTaint(eldest.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_944492440 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1506304467 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1506304467;
        // ---------- Original Method ----------
        //return false;
    }

    
    static class LinkedEntry<K, V> extends HashMapEntry<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.820 -0400", hash_original_field = "07635D95F92116ADCF0E12FD96FFBA82", hash_generated_field = "56A011BACEDF16E82830248B7AE61872")

        LinkedEntry<K, V> nxt;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.820 -0400", hash_original_field = "6F683603084DF0A15496D735362929DF", hash_generated_field = "F6D1F77EF7AEF93247967CEE52D0DED3")

        LinkedEntry<K, V> prv;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.820 -0400", hash_original_method = "2D3DD312F29888BE4F3ED431CA771887", hash_generated_method = "43ABFEF2EAF691DAC71324A38269F779")
          LinkedEntry() {
            super(null, null, 0, null);
            nxt = prv = this;
            // ---------- Original Method ----------
            //nxt = prv = this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.821 -0400", hash_original_method = "015489E05E7D25D852035EC4BCD1F37F", hash_generated_method = "5D9B57E805AB54986E3F5CDA095DAFBD")
          LinkedEntry(K key, V value, int hash, HashMapEntry<K, V> next,
                    LinkedEntry<K, V> nxt, LinkedEntry<K, V> prv) {
            super(key, value, hash, next);
            addTaint(next.getTaint());
            addTaint(hash);
            addTaint(value.getTaint());
            addTaint(key.getTaint());
            this.nxt = nxt;
            this.prv = prv;
            // ---------- Original Method ----------
            //this.nxt = nxt;
            //this.prv = prv;
        }

        
    }


    
    private abstract class LinkedHashIterator<T> implements Iterator<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.821 -0400", hash_original_field = "CB175E069FB5676DC1D73D2BBD4E839B", hash_generated_field = "EEDF831891E86FCB41BF7C113241C027")

        LinkedEntry<K, V> next = header.nxt;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.821 -0400", hash_original_field = "761F9A2134138B442C42042E19B292E5", hash_generated_field = "6763EC0E1DCA819FA35D2C7D853926FB")

        LinkedEntry<K, V> lastReturned = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.821 -0400", hash_original_field = "587E194BCD330DA9D6CB9DB53EA8709A", hash_generated_field = "17128C49BCF19B4186F02F384F2DEA86")

        int expectedModCount = modCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.822 -0400", hash_original_method = "FBBC727CB357F07230390F692D9E6F38", hash_generated_method = "FBBC727CB357F07230390F692D9E6F38")
        public LinkedHashIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.822 -0400", hash_original_method = "C7E1ED06208DECD5C814809FB00992D2", hash_generated_method = "0DDA3FBC8A5CD60BAD5E7E4B36CCE7EA")
        public final boolean hasNext() {
            boolean varE03FB5A952722C26FA4932F74C4F3FB2_189409558 = (next != header);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_300779763 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_300779763;
            // ---------- Original Method ----------
            //return next != header;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.822 -0400", hash_original_method = "6E1581FE9AE48441E5CB627F97604374", hash_generated_method = "64C3CD96C9D1A96878DEB3F13ACE0C06")
        final LinkedEntry<K, V> nextEntry() {
    if(modCount != expectedModCount)            
            {
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_1668039830 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_1668039830.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_1668039830;
            }
            LinkedEntry<K, V> e = next;
    if(e == header)            
            {
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_896813486 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_896813486.addTaint(taint);
            throw var28D00AB599969908D71F102AF992D49A_896813486;
            }
            next = e.nxt;
LinkedEntry<K, V> varF0778203547EA5559832E927D1228F06_1793657875 =             lastReturned = e;
            varF0778203547EA5559832E927D1228F06_1793657875.addTaint(taint);
            return varF0778203547EA5559832E927D1228F06_1793657875;
            // ---------- Original Method ----------
            //if (modCount != expectedModCount)
                //throw new ConcurrentModificationException();
            //LinkedEntry<K, V> e = next;
            //if (e == header)
                //throw new NoSuchElementException();
            //next = e.nxt;
            //return lastReturned = e;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.823 -0400", hash_original_method = "9A49FB7CCFBAA785998B91529061BD5F", hash_generated_method = "3F18EAACAF1D0DC567C8563652871CA2")
        public final void remove() {
    if(modCount != expectedModCount)            
            {
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_458311976 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_458311976.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_458311976;
            }
    if(lastReturned == null)            
            {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_630007534 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_630007534.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_630007534;
            }
            LinkedHashMap.this.remove(lastReturned.key);
            lastReturned = null;
            expectedModCount = modCount;
            // ---------- Original Method ----------
            //if (modCount != expectedModCount)
                //throw new ConcurrentModificationException();
            //if (lastReturned == null)
                //throw new IllegalStateException();
            //LinkedHashMap.this.remove(lastReturned.key);
            //lastReturned = null;
            //expectedModCount = modCount;
        }

        
    }


    
    private final class KeyIterator extends LinkedHashIterator<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.823 -0400", hash_original_method = "F1A12FA7FDFCBC1B54210EBDFEB312D4", hash_generated_method = "F1A12FA7FDFCBC1B54210EBDFEB312D4")
        public KeyIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.823 -0400", hash_original_method = "EA50D6F1622FBE805CA447972176B648", hash_generated_method = "B2817F009E69BCC1EB2D4F459173079B")
        public final K next() {
K varDFFFB017DDA62C15E8D1D49BA5F94802_1421115663 =             nextEntry().key;
            varDFFFB017DDA62C15E8D1D49BA5F94802_1421115663.addTaint(taint);
            return varDFFFB017DDA62C15E8D1D49BA5F94802_1421115663;
            // ---------- Original Method ----------
            //return nextEntry().key;
        }

        
    }


    
    private final class ValueIterator extends LinkedHashIterator<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.824 -0400", hash_original_method = "F211FE83547E030E3E0992549D0B21BC", hash_generated_method = "F211FE83547E030E3E0992549D0B21BC")
        public ValueIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.824 -0400", hash_original_method = "53BB4827D74FCF37FAF510D076C14D5E", hash_generated_method = "A860E750C951120ECBF46B9365BEB56B")
        public final V next() {
V var57B066C0B962D4E7D7CC8F9272046644_2073203251 =             nextEntry().value;
            var57B066C0B962D4E7D7CC8F9272046644_2073203251.addTaint(taint);
            return var57B066C0B962D4E7D7CC8F9272046644_2073203251;
            // ---------- Original Method ----------
            //return nextEntry().value;
        }

        
    }


    
    private final class EntryIterator extends LinkedHashIterator<Map.Entry<K, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.824 -0400", hash_original_method = "B80B70BCEBFE7A41A1C46DBA21C09DAD", hash_generated_method = "B80B70BCEBFE7A41A1C46DBA21C09DAD")
        public EntryIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.824 -0400", hash_original_method = "433D7E99AB55A4B03D9D3E9DC3E9704E", hash_generated_method = "2C1A56897B0B8A091AF5BD0D0EF3CFCF")
        public final Map.Entry<K, V> next() {
Map.Entry<K, V> varDC8D7EA83135934E991F02D91E02BF6E_1775450821 =             nextEntry();
            varDC8D7EA83135934E991F02D91E02BF6E_1775450821.addTaint(taint);
            return varDC8D7EA83135934E991F02D91E02BF6E_1775450821;
            // ---------- Original Method ----------
            //return nextEntry();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:04.824 -0400", hash_original_field = "F2C3C5ED4469A7ACAFC202E4DC767981", hash_generated_field = "58143BDD5D2BB4E9A1A5E401127BE552")

    private static final long serialVersionUID = 3801124242820219131L;
}

