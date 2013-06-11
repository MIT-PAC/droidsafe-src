package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class LinkedHashMap<K, V> extends HashMap<K, V> {
    transient LinkedEntry<K, V> header;
    private final boolean accessOrder;
    private static final long serialVersionUID = 3801124242820219131L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.529 -0400", hash_original_method = "BC14FA557BD7B0B9C577C3EA20F65BB1", hash_generated_method = "404E7C5AF254DDCAAA8D06AC159AD443")
    @DSModeled(DSC.SAFE)
    public LinkedHashMap() {
        init();
        accessOrder = false;
        // ---------- Original Method ----------
        //init();
        //accessOrder = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.529 -0400", hash_original_method = "D0F194CEDBAC4E60D053508661AB90EF", hash_generated_method = "0AE5CD17EE479CE3C7D2DA996C968FE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkedHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
        dsTaint.addTaint(initialCapacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.529 -0400", hash_original_method = "51A3F20C6E131F4E066F002E9C38CBA5", hash_generated_method = "F737B3143588C6F27CEC08CC41E1272F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkedHashMap(int initialCapacity, float loadFactor) {
        this(initialCapacity, loadFactor, false);
        dsTaint.addTaint(initialCapacity);
        dsTaint.addTaint(loadFactor);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.530 -0400", hash_original_method = "40A72D68B61D12122A849997E9E4FA74", hash_generated_method = "D7B56014DC4D6F28837BDF5C7AE66EF7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkedHashMap(
            int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor);
        dsTaint.addTaint(accessOrder);
        dsTaint.addTaint(initialCapacity);
        dsTaint.addTaint(loadFactor);
        init();
        // ---------- Original Method ----------
        //init();
        //this.accessOrder = accessOrder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.530 -0400", hash_original_method = "D1B0A8129B2843C851AD81FABBEE8B92", hash_generated_method = "29230B154EFF1BFBEB3943AC781A8A2C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkedHashMap(Map<? extends K, ? extends V> map) {
        this(capacityForInitSize(map.size()));
        dsTaint.addTaint(map.dsTaint);
        constructorPutAll(map);
        // ---------- Original Method ----------
        //constructorPutAll(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.530 -0400", hash_original_method = "C3E8210D7C5926509287D8B7A9054888", hash_generated_method = "D9C70A81DDC8AF7849A4B9DBEB6A9662")
    @DSModeled(DSC.SAFE)
    @Override
     void init() {
        header = new LinkedEntry<K, V>();
        // ---------- Original Method ----------
        //header = new LinkedEntry<K, V>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.530 -0400", hash_original_method = "EB729947D8C5A87C341C9E9026AB1206", hash_generated_method = "D4DBFA282D2135E2EAACE134C86AFCF4")
    @DSModeled(DSC.SAFE)
    public Entry<K, V> eldest() {
        LinkedEntry<K, V> eldest;
        eldest = header.nxt;
        return (Entry<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //LinkedEntry<K, V> eldest = header.nxt;
        //return eldest != header ? eldest : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.530 -0400", hash_original_method = "17248B030D95A40DE3DEF1923640BDC2", hash_generated_method = "877BCFB1EE2F77CCDC335876B2377266")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     void addNewEntry(K key, V value, int hash, int index) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(hash);
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        LinkedEntry<K, V> header;
        header = this.header;
        LinkedEntry<K, V> eldest;
        eldest = header.nxt;
        {
            boolean var98F762CD6E5967A3F8DD94F64E8DE958_1359056444 = (eldest != header && removeEldestEntry(eldest));
            {
                remove(eldest.key);
            } //End block
        } //End collapsed parenthetic
        LinkedEntry<K, V> oldTail;
        oldTail = header.prv;
        LinkedEntry<K, V> newTail;
        newTail = new LinkedEntry<K,V>(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.530 -0400", hash_original_method = "53E46D1C7C140F5769FD83EFA867F0EB", hash_generated_method = "39C7FCBFB8C8F7ED5885AFBAB7494C6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     void addNewEntryForNullKey(V value) {
        dsTaint.addTaint(value.dsTaint);
        LinkedEntry<K, V> header;
        header = this.header;
        LinkedEntry<K, V> eldest;
        eldest = header.nxt;
        {
            boolean var98F762CD6E5967A3F8DD94F64E8DE958_807437567 = (eldest != header && removeEldestEntry(eldest));
            {
                remove(eldest.key);
            } //End block
        } //End collapsed parenthetic
        LinkedEntry<K, V> oldTail;
        oldTail = header.prv;
        LinkedEntry<K, V> newTail;
        newTail = new LinkedEntry<K,V>(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.530 -0400", hash_original_method = "DD7E1FD3A0E6B4968C119F3BE0C92615", hash_generated_method = "B19B371BBCDD4020374CAA14AD9E9485")
    @DSModeled(DSC.SAFE)
    @Override
     HashMapEntry<K, V> constructorNewEntry(
            K key, V value, int hash, HashMapEntry<K, V> next) {
        dsTaint.addTaint(hash);
        dsTaint.addTaint(next.dsTaint);
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        LinkedEntry<K, V> header;
        header = this.header;
        LinkedEntry<K, V> oldTail;
        oldTail = header.prv;
        LinkedEntry<K, V> newTail;
        newTail = new LinkedEntry<K,V>(key, value, hash, next, header, oldTail);
        HashMapEntry<K, V> varB6E1C0A93581E306D89703240ADC2DFB_465150176 = (oldTail.nxt = header.prv = newTail);
        return (HashMapEntry<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //LinkedEntry<K, V> header = this.header;
        //LinkedEntry<K, V> oldTail = header.prv;
        //LinkedEntry<K, V> newTail
                //= new LinkedEntry<K,V>(key, value, hash, next, header, oldTail);
        //return oldTail.nxt = header.prv = newTail;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.530 -0400", hash_original_method = "5C4F6BF9C2C1A7BF64D67EB60F9C3D15", hash_generated_method = "6B812C254844F255975394F66BD16CFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public V get(Object key) {
        dsTaint.addTaint(key.dsTaint);
        {
            HashMapEntry<K, V> e;
            e = entryForNullKey;
            makeTail((LinkedEntry<K, V>) e);
        } //End block
        int hash;
        hash = key.hashCode();
        hash ^= (hash >>> 20) ^ (hash >>> 12);
        hash ^= (hash >>> 7) ^ (hash >>> 4);
        HashMapEntry<K, V>[] tab;
        tab = table;
        {
            HashMapEntry<K, V> e;
            e = tab[hash & (tab.length - 1)];
            e = e.next;
            {
                K eKey;
                eKey = e.key;
                {
                    boolean var9E8F21F6B5DB5FEDBA4125840A8612D4_1246466953 = (eKey == key || (e.hash == hash && key.equals(eKey)));
                    {
                        makeTail((LinkedEntry<K, V>) e);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (V)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.530 -0400", hash_original_method = "D37211F13FFE982B5329A6F04D365268", hash_generated_method = "DA093C7A75E5E827DC3DBD8A7E4963E0")
    @DSModeled(DSC.SAFE)
    private void makeTail(LinkedEntry<K, V> e) {
        dsTaint.addTaint(e.dsTaint);
        e.prv.nxt = e.nxt;
        e.nxt.prv = e.prv;
        LinkedEntry<K, V> header;
        header = this.header;
        LinkedEntry<K, V> oldTail;
        oldTail = header.prv;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.531 -0400", hash_original_method = "1F9A2707DB97E3137F0AF608EC157C5F", hash_generated_method = "8A03CC600B65021A02DCD39E461DD3F7")
    @DSModeled(DSC.SAFE)
    @Override
     void preModify(HashMapEntry<K, V> e) {
        dsTaint.addTaint(e.dsTaint);
        {
            makeTail((LinkedEntry<K, V>) e);
        } //End block
        // ---------- Original Method ----------
        //if (accessOrder) {
            //makeTail((LinkedEntry<K, V>) e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.531 -0400", hash_original_method = "7796AD94E39D6453B5D3B10446A6CDCE", hash_generated_method = "EBB6B92FE0877077865284A4C2300AA9")
    @DSModeled(DSC.SAFE)
    @Override
     void postRemove(HashMapEntry<K, V> e) {
        dsTaint.addTaint(e.dsTaint);
        LinkedEntry<K, V> le;
        le = (LinkedEntry<K, V>) e;
        le.prv.nxt = le.nxt;
        le.nxt.prv = le.prv;
        le.nxt = le.prv = null;
        // ---------- Original Method ----------
        //LinkedEntry<K, V> le = (LinkedEntry<K, V>) e;
        //le.prv.nxt = le.nxt;
        //le.nxt.prv = le.prv;
        //le.nxt = le.prv = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.531 -0400", hash_original_method = "B1ADF7F2DAB1D611A8BB20D2E6FE8BE5", hash_generated_method = "6CB5D8089555BCF41F7DC6A1D7A3ACF3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean containsValue(Object value) {
        dsTaint.addTaint(value.dsTaint);
        {
            {
                LinkedEntry<K, V> header, e;
                header = this.header;
                e = header.nxt;
                e = e.nxt;
            } //End collapsed parenthetic
        } //End block
        {
            LinkedEntry<K, V> header, e;
            header = this.header;
            e = header.nxt;
            e = e.nxt;
            {
                {
                    boolean var88D4FD98A5D9191EF70D3714E40B4A58_228511415 = (value.equals(e.value));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.531 -0400", hash_original_method = "F9D4D1514A1438141913ED2857BCCF60", hash_generated_method = "D23969B9D9B181C877FF8714CACDFE77")
    @DSModeled(DSC.SAFE)
    public void clear() {
        super.clear();
        LinkedEntry<K, V> header;
        header = this.header;
        {
            LinkedEntry<K, V> e;
            e = header.nxt;
            {
                LinkedEntry<K, V> nxt;
                nxt = e.nxt;
                e.nxt = e.prv = null;
                e = nxt;
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.531 -0400", hash_original_method = "E5C2B853B7FE0DFF8A1198070D9AED67", hash_generated_method = "4E3D9D31B3E2B4018EDEDE905405C3A3")
    @DSModeled(DSC.SAFE)
    @Override
     Iterator<K> newKeyIterator() {
        return (Iterator<K>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new KeyIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.531 -0400", hash_original_method = "58BEE1C21CE9010029EB8FF9FDCDF9B3", hash_generated_method = "BD2B1D3776C9B0303A323C19DBD76074")
    @DSModeled(DSC.SAFE)
    @Override
     Iterator<V> newValueIterator() {
        return (Iterator<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ValueIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.531 -0400", hash_original_method = "7416C435C60270F3DC14B8CDBC0FF1EF", hash_generated_method = "5BD34E62FF5EBA3B9365C21793D95055")
    @DSModeled(DSC.SAFE)
    @Override
     Iterator<Map.Entry<K, V>> newEntryIterator() {
        return (Iterator<Map.Entry<K, V>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new EntryIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.531 -0400", hash_original_method = "F4EE8618F7DE6E7966D8D47C993C665B", hash_generated_method = "78CE1A93B428599E01D20D8ED19B0E72")
    @DSModeled(DSC.SAFE)
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        dsTaint.addTaint(eldest.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    static class LinkedEntry<K, V> extends HashMapEntry<K, V> {
        LinkedEntry<K, V> nxt;
        LinkedEntry<K, V> prv;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.531 -0400", hash_original_method = "2D3DD312F29888BE4F3ED431CA771887", hash_generated_method = "E2E5994CAEE5EAF729638C3B9E385339")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         LinkedEntry() {
            super(null, null, 0, null);
            nxt = prv = this;
            // ---------- Original Method ----------
            //nxt = prv = this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.531 -0400", hash_original_method = "015489E05E7D25D852035EC4BCD1F37F", hash_generated_method = "DC35F1642E97D66599D3D8B31A5CD29E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         LinkedEntry(K key, V value, int hash, HashMapEntry<K, V> next,
                    LinkedEntry<K, V> nxt, LinkedEntry<K, V> prv) {
            super(key, value, hash, next);
            dsTaint.addTaint(prv.dsTaint);
            dsTaint.addTaint(hash);
            dsTaint.addTaint(next.dsTaint);
            dsTaint.addTaint(value.dsTaint);
            dsTaint.addTaint(nxt.dsTaint);
            dsTaint.addTaint(key.dsTaint);
            // ---------- Original Method ----------
            //this.nxt = nxt;
            //this.prv = prv;
        }

        
    }


    
    private abstract class LinkedHashIterator<T> implements Iterator<T> {
        LinkedEntry<K, V> next = header.nxt;
        LinkedEntry<K, V> lastReturned = null;
        int expectedModCount = modCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.531 -0400", hash_original_method = "C7E1ED06208DECD5C814809FB00992D2", hash_generated_method = "2BD44A1EC9E7C0233364CB6CB0B29F63")
        @DSModeled(DSC.SAFE)
        public final boolean hasNext() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return next != header;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.531 -0400", hash_original_method = "6E1581FE9AE48441E5CB627F97604374", hash_generated_method = "EAEBB5FE4B22D72785560A512FFFDA31")
        @DSModeled(DSC.SAFE)
        final LinkedEntry<K, V> nextEntry() {
            throw new ConcurrentModificationException();
            LinkedEntry<K, V> e;
            e = next;
            throw new NoSuchElementException();
            next = e.nxt;
            LinkedEntry<K, V> varC2F0A5D29D373DC0C15F389179ABD547_1141934542 = (lastReturned = e);
            return (LinkedEntry<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (modCount != expectedModCount)
                //throw new ConcurrentModificationException();
            //LinkedEntry<K, V> e = next;
            //if (e == header)
                //throw new NoSuchElementException();
            //next = e.nxt;
            //return lastReturned = e;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.531 -0400", hash_original_method = "9A49FB7CCFBAA785998B91529061BD5F", hash_generated_method = "E1CDC9AE4A631AB9CC4AF87E6CC32408")
        @DSModeled(DSC.SAFE)
        public final void remove() {
            throw new ConcurrentModificationException();
            throw new IllegalStateException();
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.532 -0400", hash_original_method = "EA50D6F1622FBE805CA447972176B648", hash_generated_method = "6A7482E9CC28C0BD20FCD77233D063CB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final K next() {
            K var0826C92B2F2C6B3475D8BF572E4E70AE_596416328 = (nextEntry().key);
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return nextEntry().key;
        }

        
    }


    
    private final class ValueIterator extends LinkedHashIterator<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.532 -0400", hash_original_method = "53BB4827D74FCF37FAF510D076C14D5E", hash_generated_method = "94C0652B1751249318F8063FB5FC8104")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final V next() {
            V var551184D8EC6DFD9474BC6F4F9A2CB7F7_1960803449 = (nextEntry().value);
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return nextEntry().value;
        }

        
    }


    
    private final class EntryIterator extends LinkedHashIterator<Map.Entry<K, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.532 -0400", hash_original_method = "433D7E99AB55A4B03D9D3E9DC3E9704E", hash_generated_method = "E2E79D10367B8BEA8395874E933E03CC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final Map.Entry<K, V> next() {
            Map.Entry<K, V> varFDACBEE1E52798928B8D0EBEA13DBC12_139212347 = (nextEntry());
            return (Map.Entry<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return nextEntry();
        }

        
    }


    
}


