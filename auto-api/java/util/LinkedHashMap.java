package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class LinkedHashMap<K, V> extends HashMap<K, V> {
    transient LinkedEntry<K, V> header;
    private boolean accessOrder;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.541 -0400", hash_original_method = "BC14FA557BD7B0B9C577C3EA20F65BB1", hash_generated_method = "841BDE13C0D724F59D7372319DB3BC68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkedHashMap() {
        init();
        accessOrder = false;
        // ---------- Original Method ----------
        //init();
        //accessOrder = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.542 -0400", hash_original_method = "D0F194CEDBAC4E60D053508661AB90EF", hash_generated_method = "87DF29E9C2965B983D2DBC1F108BE1E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkedHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
        dsTaint.addTaint(initialCapacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.542 -0400", hash_original_method = "51A3F20C6E131F4E066F002E9C38CBA5", hash_generated_method = "5D5559A7071375C0BDE9EEEE101EE5C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkedHashMap(int initialCapacity, float loadFactor) {
        this(initialCapacity, loadFactor, false);
        dsTaint.addTaint(initialCapacity);
        dsTaint.addTaint(loadFactor);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.542 -0400", hash_original_method = "40A72D68B61D12122A849997E9E4FA74", hash_generated_method = "F01B7264577A9886EED406DD73775F7F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.542 -0400", hash_original_method = "D1B0A8129B2843C851AD81FABBEE8B92", hash_generated_method = "0E9472C7149DEAC2113BF6CBCEAA4583")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkedHashMap(Map<? extends K, ? extends V> map) {
        this(capacityForInitSize(map.size()));
        dsTaint.addTaint(map.dsTaint);
        constructorPutAll(map);
        // ---------- Original Method ----------
        //constructorPutAll(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.542 -0400", hash_original_method = "C3E8210D7C5926509287D8B7A9054888", hash_generated_method = "B6C5484F9803F011BF936D3E7CA26200")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     void init() {
        header = new LinkedEntry<K, V>();
        // ---------- Original Method ----------
        //header = new LinkedEntry<K, V>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.542 -0400", hash_original_method = "EB729947D8C5A87C341C9E9026AB1206", hash_generated_method = "8EFB3D6B2E4A4D5B2A6D4A498B3FC5FF")
    @DSModeled(DSC.SAFE)
    public Entry<K, V> eldest() {
        LinkedEntry<K, V> eldest;
        eldest = header.nxt;
        return (Entry<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //LinkedEntry<K, V> eldest = header.nxt;
        //return eldest != header ? eldest : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.543 -0400", hash_original_method = "17248B030D95A40DE3DEF1923640BDC2", hash_generated_method = "93E8DD9B80A7F607FD9D66761B6E3A71")
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
            boolean var98F762CD6E5967A3F8DD94F64E8DE958_689825551 = (eldest != header && removeEldestEntry(eldest));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.543 -0400", hash_original_method = "53E46D1C7C140F5769FD83EFA867F0EB", hash_generated_method = "DEB9462FFA5266D606597A5BEB4FB3BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     void addNewEntryForNullKey(V value) {
        dsTaint.addTaint(value.dsTaint);
        LinkedEntry<K, V> header;
        header = this.header;
        LinkedEntry<K, V> eldest;
        eldest = header.nxt;
        {
            boolean var98F762CD6E5967A3F8DD94F64E8DE958_1307952282 = (eldest != header && removeEldestEntry(eldest));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.543 -0400", hash_original_method = "DD7E1FD3A0E6B4968C119F3BE0C92615", hash_generated_method = "7FB93FC1429359CE08AB519A1F08AB96")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        HashMapEntry<K, V> varB6E1C0A93581E306D89703240ADC2DFB_1716687995 = (oldTail.nxt = header.prv = newTail);
        return (HashMapEntry<K, V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //LinkedEntry<K, V> header = this.header;
        //LinkedEntry<K, V> oldTail = header.prv;
        //LinkedEntry<K, V> newTail
                //= new LinkedEntry<K,V>(key, value, hash, next, header, oldTail);
        //return oldTail.nxt = header.prv = newTail;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.544 -0400", hash_original_method = "5C4F6BF9C2C1A7BF64D67EB60F9C3D15", hash_generated_method = "B37181E5C4A89977E7A264B4215A9754")
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
                    boolean var9E8F21F6B5DB5FEDBA4125840A8612D4_2072615894 = (eKey == key || (e.hash == hash && key.equals(eKey)));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.544 -0400", hash_original_method = "D37211F13FFE982B5329A6F04D365268", hash_generated_method = "FEC315F8F5F292578A03B8B47201F247")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.544 -0400", hash_original_method = "1F9A2707DB97E3137F0AF608EC157C5F", hash_generated_method = "D4796517819418359EC7C76BA55815F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.545 -0400", hash_original_method = "7796AD94E39D6453B5D3B10446A6CDCE", hash_generated_method = "A180A05EF8481733877B791916599360")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.545 -0400", hash_original_method = "B1ADF7F2DAB1D611A8BB20D2E6FE8BE5", hash_generated_method = "CAE617D0AE8BA983C1B7E9A455819DA1")
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
                    boolean var88D4FD98A5D9191EF70D3714E40B4A58_1445957561 = (value.equals(e.value));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.545 -0400", hash_original_method = "F9D4D1514A1438141913ED2857BCCF60", hash_generated_method = "7EC8084D0971328A7C217B0E6E900CC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.545 -0400", hash_original_method = "E5C2B853B7FE0DFF8A1198070D9AED67", hash_generated_method = "64C7A221E24637642FE7D02962A0C222")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     Iterator<K> newKeyIterator() {
        Iterator<K> var23DBCBF4E184D62482444F7AF7A8A6FB_1762260783 = (new KeyIterator());
        return (Iterator<K>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new KeyIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.545 -0400", hash_original_method = "58BEE1C21CE9010029EB8FF9FDCDF9B3", hash_generated_method = "0F372229B249DD68196605C811295ED4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     Iterator<V> newValueIterator() {
        Iterator<V> varD97090F3A13A0D960A637BC236C561C5_2111642563 = (new ValueIterator());
        return (Iterator<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ValueIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.546 -0400", hash_original_method = "7416C435C60270F3DC14B8CDBC0FF1EF", hash_generated_method = "7A7CCE0D459B96D8E3AD96BC232F1102")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     Iterator<Map.Entry<K, V>> newEntryIterator() {
        Iterator<Map.Entry<K, V>> var1ECA2617FE2310C4DFA319908865704D_1514618231 = (new EntryIterator());
        return (Iterator<Map.Entry<K, V>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new EntryIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.546 -0400", hash_original_method = "F4EE8618F7DE6E7966D8D47C993C665B", hash_generated_method = "53AE2607A685B5003952ED7DD92A8E65")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.546 -0400", hash_original_method = "2D3DD312F29888BE4F3ED431CA771887", hash_generated_method = "43ABFEF2EAF691DAC71324A38269F779")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         LinkedEntry() {
            super(null, null, 0, null);
            nxt = prv = this;
            // ---------- Original Method ----------
            //nxt = prv = this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.546 -0400", hash_original_method = "015489E05E7D25D852035EC4BCD1F37F", hash_generated_method = "D4F799E8BCFA65C0CB0065DDAFEF65C5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         LinkedEntry(K key, V value, int hash, HashMapEntry<K, V> next,
                    LinkedEntry<K, V> nxt, LinkedEntry<K, V> prv) {
            super(key, value, hash, next);
            dsTaint.addTaint(prv.dsTaint);
            dsTaint.addTaint(hash);
            dsTaint.addTaint(next.dsTaint);
            dsTaint.addTaint(nxt.dsTaint);
            dsTaint.addTaint(value.dsTaint);
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.546 -0400", hash_original_method = "2CF830D19D65408FF65041E5D38D3002", hash_generated_method = "2CF830D19D65408FF65041E5D38D3002")
                public LinkedHashIterator ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.546 -0400", hash_original_method = "C7E1ED06208DECD5C814809FB00992D2", hash_generated_method = "E793D92BAE682B70357ADE661DD2180D")
        @DSModeled(DSC.SAFE)
        public final boolean hasNext() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return next != header;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.547 -0400", hash_original_method = "6E1581FE9AE48441E5CB627F97604374", hash_generated_method = "ADFE91D8820E4C3961486D0F0B80B6CD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        final LinkedEntry<K, V> nextEntry() {
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            LinkedEntry<K, V> e;
            e = next;
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            next = e.nxt;
            LinkedEntry<K, V> varC2F0A5D29D373DC0C15F389179ABD547_730549699 = (lastReturned = e);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.547 -0400", hash_original_method = "9A49FB7CCFBAA785998B91529061BD5F", hash_generated_method = "36521BB0FB0EA5530FEC401A9506FE46")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void remove() {
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.547 -0400", hash_original_method = "5D388AF9F4BC08670D6FC8B0690B4586", hash_generated_method = "5D388AF9F4BC08670D6FC8B0690B4586")
                public KeyIterator ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.547 -0400", hash_original_method = "EA50D6F1622FBE805CA447972176B648", hash_generated_method = "32E952E565A8FE6F8E8BD0C680E5DE1E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final K next() {
            K var0826C92B2F2C6B3475D8BF572E4E70AE_1677703218 = (nextEntry().key);
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return nextEntry().key;
        }

        
    }


    
    private final class ValueIterator extends LinkedHashIterator<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.547 -0400", hash_original_method = "0633288CFFDB0D47FC844EDFD5BB157F", hash_generated_method = "0633288CFFDB0D47FC844EDFD5BB157F")
                public ValueIterator ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.547 -0400", hash_original_method = "53BB4827D74FCF37FAF510D076C14D5E", hash_generated_method = "CE124C770096A77732C4147C04AB88F5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final V next() {
            V var551184D8EC6DFD9474BC6F4F9A2CB7F7_123744074 = (nextEntry().value);
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return nextEntry().value;
        }

        
    }


    
    private final class EntryIterator extends LinkedHashIterator<Map.Entry<K, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.548 -0400", hash_original_method = "FCA6D1B18319AC57F041ABBA6E1FAA59", hash_generated_method = "FCA6D1B18319AC57F041ABBA6E1FAA59")
                public EntryIterator ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.548 -0400", hash_original_method = "433D7E99AB55A4B03D9D3E9DC3E9704E", hash_generated_method = "FAE27B9F2FB64EF094B9514BEA4B0B83")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final Map.Entry<K, V> next() {
            Map.Entry<K, V> varFDACBEE1E52798928B8D0EBEA13DBC12_1038169186 = (nextEntry());
            return (Map.Entry<K, V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return nextEntry();
        }

        
    }


    
    private static final long serialVersionUID = 3801124242820219131L;
}

