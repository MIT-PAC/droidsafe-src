package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class LinkedHashMap<K, V> extends HashMap<K, V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.457 -0400", hash_original_field = "099FB995346F31C749F6E40DB0F395E3", hash_generated_field = "D6704B8F26715061947446A5240B101A")

    transient LinkedEntry<K, V> header;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.457 -0400", hash_original_field = "B1B8F9258C25833E563A747875ABA3F3", hash_generated_field = "3F26D7AF65C932D73D31BA6C85FF3982")

    private boolean accessOrder;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.458 -0400", hash_original_method = "BC14FA557BD7B0B9C577C3EA20F65BB1", hash_generated_method = "841BDE13C0D724F59D7372319DB3BC68")
    public  LinkedHashMap() {
        init();
        accessOrder = false;
        // ---------- Original Method ----------
        //init();
        //accessOrder = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.458 -0400", hash_original_method = "D0F194CEDBAC4E60D053508661AB90EF", hash_generated_method = "AF81C3A6342901CDC78A39BBC8257F31")
    public  LinkedHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
        addTaint(initialCapacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.458 -0400", hash_original_method = "51A3F20C6E131F4E066F002E9C38CBA5", hash_generated_method = "8C33FB4098CB0085A58600BBAEDCDDAF")
    public  LinkedHashMap(int initialCapacity, float loadFactor) {
        this(initialCapacity, loadFactor, false);
        addTaint(initialCapacity);
        addTaint(loadFactor);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.459 -0400", hash_original_method = "40A72D68B61D12122A849997E9E4FA74", hash_generated_method = "A66F0384E5FBFCAD0DE92A880D614A3F")
    public  LinkedHashMap(
            int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor);
        init();
        this.accessOrder = accessOrder;
        addTaint(initialCapacity);
        addTaint(loadFactor);
        // ---------- Original Method ----------
        //init();
        //this.accessOrder = accessOrder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.459 -0400", hash_original_method = "D1B0A8129B2843C851AD81FABBEE8B92", hash_generated_method = "E44D30C7CF7DF64BB60F3791FD8CA442")
    public  LinkedHashMap(Map<? extends K, ? extends V> map) {
        this(capacityForInitSize(map.size()));
        constructorPutAll(map);
        addTaint(map.getTaint());
        // ---------- Original Method ----------
        //constructorPutAll(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.459 -0400", hash_original_method = "C3E8210D7C5926509287D8B7A9054888", hash_generated_method = "B6C5484F9803F011BF936D3E7CA26200")
    @Override
     void init() {
        header = new LinkedEntry<K, V>();
        // ---------- Original Method ----------
        //header = new LinkedEntry<K, V>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.461 -0400", hash_original_method = "EB729947D8C5A87C341C9E9026AB1206", hash_generated_method = "664A339D3DA803D1C8EFB219F2678C4C")
    public Entry<K, V> eldest() {
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1392650360 = null; //Variable for return #1
        LinkedEntry<K, V> eldest;
        eldest = header.nxt;
        varB4EAC82CA7396A68D541C85D26508E83_1392650360 = eldest != header ? eldest : null;
        varB4EAC82CA7396A68D541C85D26508E83_1392650360.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1392650360;
        // ---------- Original Method ----------
        //LinkedEntry<K, V> eldest = header.nxt;
        //return eldest != header ? eldest : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.462 -0400", hash_original_method = "17248B030D95A40DE3DEF1923640BDC2", hash_generated_method = "2C8305A6AB075FF3943409651120C98F")
    @Override
     void addNewEntry(K key, V value, int hash, int index) {
        LinkedEntry<K, V> header;
        header = this.header;
        LinkedEntry<K, V> eldest;
        eldest = header.nxt;
        {
            boolean var98F762CD6E5967A3F8DD94F64E8DE958_1500548369 = (eldest != header && removeEldestEntry(eldest));
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
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        addTaint(hash);
        addTaint(index);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.468 -0400", hash_original_method = "53E46D1C7C140F5769FD83EFA867F0EB", hash_generated_method = "0222E6E8D14DFBC5664F78156D64895B")
    @Override
     void addNewEntryForNullKey(V value) {
        LinkedEntry<K, V> header;
        header = this.header;
        LinkedEntry<K, V> eldest;
        eldest = header.nxt;
        {
            boolean var98F762CD6E5967A3F8DD94F64E8DE958_555316126 = (eldest != header && removeEldestEntry(eldest));
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
        addTaint(value.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.474 -0400", hash_original_method = "DD7E1FD3A0E6B4968C119F3BE0C92615", hash_generated_method = "0D2569A180A86761E9E02B10100C5D7A")
    @Override
     HashMapEntry<K, V> constructorNewEntry(
            K key, V value, int hash, HashMapEntry<K, V> next) {
        HashMapEntry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1347697787 = null; //Variable for return #1
        LinkedEntry<K, V> header;
        header = this.header;
        LinkedEntry<K, V> oldTail;
        oldTail = header.prv;
        LinkedEntry<K, V> newTail;
        newTail = new LinkedEntry<K,V>(key, value, hash, next, header, oldTail);
        varB4EAC82CA7396A68D541C85D26508E83_1347697787 = oldTail.nxt = header.prv = newTail;
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        addTaint(hash);
        addTaint(next.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1347697787.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1347697787;
        // ---------- Original Method ----------
        //LinkedEntry<K, V> header = this.header;
        //LinkedEntry<K, V> oldTail = header.prv;
        //LinkedEntry<K, V> newTail
                //= new LinkedEntry<K,V>(key, value, hash, next, header, oldTail);
        //return oldTail.nxt = header.prv = newTail;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.479 -0400", hash_original_method = "5C4F6BF9C2C1A7BF64D67EB60F9C3D15", hash_generated_method = "BCC961BBD5083620047B8B528F10FE25")
    @Override
    public V get(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_2078533768 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_1123125138 = null; //Variable for return #2
        V varB4EAC82CA7396A68D541C85D26508E83_397880984 = null; //Variable for return #3
        V varB4EAC82CA7396A68D541C85D26508E83_1123307792 = null; //Variable for return #4
        {
            HashMapEntry<K, V> e;
            e = entryForNullKey;
            varB4EAC82CA7396A68D541C85D26508E83_2078533768 = null;
            makeTail((LinkedEntry<K, V>) e);
            varB4EAC82CA7396A68D541C85D26508E83_1123125138 = e.value;
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
                    boolean var9E8F21F6B5DB5FEDBA4125840A8612D4_780896150 = (eKey == key || (e.hash == hash && key.equals(eKey)));
                    {
                        makeTail((LinkedEntry<K, V>) e);
                        varB4EAC82CA7396A68D541C85D26508E83_397880984 = e.value;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1123307792 = null;
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_1728419558; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1728419558 = varB4EAC82CA7396A68D541C85D26508E83_2078533768;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1728419558 = varB4EAC82CA7396A68D541C85D26508E83_1123125138;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1728419558 = varB4EAC82CA7396A68D541C85D26508E83_397880984;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1728419558 = varB4EAC82CA7396A68D541C85D26508E83_1123307792;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1728419558.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1728419558;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.488 -0400", hash_original_method = "D37211F13FFE982B5329A6F04D365268", hash_generated_method = "8E6E904D7554A1F22E34F59131DBCD91")
    private void makeTail(LinkedEntry<K, V> e) {
        e.prv.nxt = e.nxt;
        e.nxt.prv = e.prv;
        LinkedEntry<K, V> header;
        header = this.header;
        LinkedEntry<K, V> oldTail;
        oldTail = header.prv;
        e.nxt = header;
        e.prv = oldTail;
        oldTail.nxt = header.prv = e;
        addTaint(e.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.488 -0400", hash_original_method = "1F9A2707DB97E3137F0AF608EC157C5F", hash_generated_method = "DDA50A06F65864922709022276489742")
    @Override
     void preModify(HashMapEntry<K, V> e) {
        {
            makeTail((LinkedEntry<K, V>) e);
        } //End block
        addTaint(e.getTaint());
        // ---------- Original Method ----------
        //if (accessOrder) {
            //makeTail((LinkedEntry<K, V>) e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.490 -0400", hash_original_method = "7796AD94E39D6453B5D3B10446A6CDCE", hash_generated_method = "23FD9DCBDB92763B29C082B1A39B2AD4")
    @Override
     void postRemove(HashMapEntry<K, V> e) {
        LinkedEntry<K, V> le;
        le = (LinkedEntry<K, V>) e;
        le.prv.nxt = le.nxt;
        le.nxt.prv = le.prv;
        le.nxt = le.prv = null;
        addTaint(e.getTaint());
        // ---------- Original Method ----------
        //LinkedEntry<K, V> le = (LinkedEntry<K, V>) e;
        //le.prv.nxt = le.nxt;
        //le.nxt.prv = le.prv;
        //le.nxt = le.prv = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.499 -0400", hash_original_method = "B1ADF7F2DAB1D611A8BB20D2E6FE8BE5", hash_generated_method = "B2CE5E117511674269C002F1696E1EB1")
    @Override
    public boolean containsValue(Object value) {
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
                    boolean var88D4FD98A5D9191EF70D3714E40B4A58_1261337429 = (value.equals(e.value));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_102726274 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_102726274;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.500 -0400", hash_original_method = "F9D4D1514A1438141913ED2857BCCF60", hash_generated_method = "7EC8084D0971328A7C217B0E6E900CC6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.500 -0400", hash_original_method = "E5C2B853B7FE0DFF8A1198070D9AED67", hash_generated_method = "9598812B8FCEB926773514F05C640FC6")
    @Override
     Iterator<K> newKeyIterator() {
        Iterator<K> varB4EAC82CA7396A68D541C85D26508E83_666379315 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_666379315 = new KeyIterator();
        varB4EAC82CA7396A68D541C85D26508E83_666379315.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_666379315;
        // ---------- Original Method ----------
        //return new KeyIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.505 -0400", hash_original_method = "58BEE1C21CE9010029EB8FF9FDCDF9B3", hash_generated_method = "762048C30DED9489260C0E0D314EECC9")
    @Override
     Iterator<V> newValueIterator() {
        Iterator<V> varB4EAC82CA7396A68D541C85D26508E83_289166411 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_289166411 = new ValueIterator();
        varB4EAC82CA7396A68D541C85D26508E83_289166411.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_289166411;
        // ---------- Original Method ----------
        //return new ValueIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.509 -0400", hash_original_method = "7416C435C60270F3DC14B8CDBC0FF1EF", hash_generated_method = "B85D1A95EE1C655F043FC0E8B7BD12AF")
    @Override
     Iterator<Map.Entry<K, V>> newEntryIterator() {
        Iterator<Map.Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_910514163 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_910514163 = new EntryIterator();
        varB4EAC82CA7396A68D541C85D26508E83_910514163.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_910514163;
        // ---------- Original Method ----------
        //return new EntryIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.510 -0400", hash_original_method = "F4EE8618F7DE6E7966D8D47C993C665B", hash_generated_method = "D5A74F8C6046F37B303FECF14E68FE48")
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        addTaint(eldest.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1054280170 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1054280170;
        // ---------- Original Method ----------
        //return false;
    }

    
    static class LinkedEntry<K, V> extends HashMapEntry<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.510 -0400", hash_original_field = "07635D95F92116ADCF0E12FD96FFBA82", hash_generated_field = "56A011BACEDF16E82830248B7AE61872")

        LinkedEntry<K, V> nxt;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.510 -0400", hash_original_field = "6F683603084DF0A15496D735362929DF", hash_generated_field = "F6D1F77EF7AEF93247967CEE52D0DED3")

        LinkedEntry<K, V> prv;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.510 -0400", hash_original_method = "2D3DD312F29888BE4F3ED431CA771887", hash_generated_method = "43ABFEF2EAF691DAC71324A38269F779")
          LinkedEntry() {
            super(null, null, 0, null);
            nxt = prv = this;
            // ---------- Original Method ----------
            //nxt = prv = this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.511 -0400", hash_original_method = "015489E05E7D25D852035EC4BCD1F37F", hash_generated_method = "36EB435C4A23FE0648CA396CB7D82C02")
          LinkedEntry(K key, V value, int hash, HashMapEntry<K, V> next,
                    LinkedEntry<K, V> nxt, LinkedEntry<K, V> prv) {
            super(key, value, hash, next);
            this.nxt = nxt;
            this.prv = prv;
            addTaint(key.getTaint());
            addTaint(value.getTaint());
            addTaint(hash);
            addTaint(next.getTaint());
            // ---------- Original Method ----------
            //this.nxt = nxt;
            //this.prv = prv;
        }

        
    }


    
    private abstract class LinkedHashIterator<T> implements Iterator<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.511 -0400", hash_original_field = "CB175E069FB5676DC1D73D2BBD4E839B", hash_generated_field = "EEDF831891E86FCB41BF7C113241C027")

        LinkedEntry<K, V> next = header.nxt;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.511 -0400", hash_original_field = "761F9A2134138B442C42042E19B292E5", hash_generated_field = "6763EC0E1DCA819FA35D2C7D853926FB")

        LinkedEntry<K, V> lastReturned = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.511 -0400", hash_original_field = "587E194BCD330DA9D6CB9DB53EA8709A", hash_generated_field = "17128C49BCF19B4186F02F384F2DEA86")

        int expectedModCount = modCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.511 -0400", hash_original_method = "FBBC727CB357F07230390F692D9E6F38", hash_generated_method = "FBBC727CB357F07230390F692D9E6F38")
        public LinkedHashIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.512 -0400", hash_original_method = "C7E1ED06208DECD5C814809FB00992D2", hash_generated_method = "18CCB443A1A981CC0B935D2AB5B15E98")
        public final boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_204927002 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_204927002;
            // ---------- Original Method ----------
            //return next != header;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.522 -0400", hash_original_method = "6E1581FE9AE48441E5CB627F97604374", hash_generated_method = "92C23CFFEFF294BEE3B9957A22C32D54")
        final LinkedEntry<K, V> nextEntry() {
            LinkedEntry<K, V> varB4EAC82CA7396A68D541C85D26508E83_511691671 = null; //Variable for return #1
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            LinkedEntry<K, V> e;
            e = next;
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            next = e.nxt;
            varB4EAC82CA7396A68D541C85D26508E83_511691671 = lastReturned = e;
            varB4EAC82CA7396A68D541C85D26508E83_511691671.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_511691671;
            // ---------- Original Method ----------
            //if (modCount != expectedModCount)
                //throw new ConcurrentModificationException();
            //LinkedEntry<K, V> e = next;
            //if (e == header)
                //throw new NoSuchElementException();
            //next = e.nxt;
            //return lastReturned = e;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.522 -0400", hash_original_method = "9A49FB7CCFBAA785998B91529061BD5F", hash_generated_method = "36521BB0FB0EA5530FEC401A9506FE46")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.522 -0400", hash_original_method = "F1A12FA7FDFCBC1B54210EBDFEB312D4", hash_generated_method = "F1A12FA7FDFCBC1B54210EBDFEB312D4")
        public KeyIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.523 -0400", hash_original_method = "EA50D6F1622FBE805CA447972176B648", hash_generated_method = "146167DE0046CE48C0516DE8AA81985D")
        public final K next() {
            K varB4EAC82CA7396A68D541C85D26508E83_167457786 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_167457786 = nextEntry().key;
            varB4EAC82CA7396A68D541C85D26508E83_167457786.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_167457786;
            // ---------- Original Method ----------
            //return nextEntry().key;
        }

        
    }


    
    private final class ValueIterator extends LinkedHashIterator<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.523 -0400", hash_original_method = "F211FE83547E030E3E0992549D0B21BC", hash_generated_method = "F211FE83547E030E3E0992549D0B21BC")
        public ValueIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.523 -0400", hash_original_method = "53BB4827D74FCF37FAF510D076C14D5E", hash_generated_method = "516B9F93C50DB83D3348140C67009E10")
        public final V next() {
            V varB4EAC82CA7396A68D541C85D26508E83_1771117193 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1771117193 = nextEntry().value;
            varB4EAC82CA7396A68D541C85D26508E83_1771117193.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1771117193;
            // ---------- Original Method ----------
            //return nextEntry().value;
        }

        
    }


    
    private final class EntryIterator extends LinkedHashIterator<Map.Entry<K, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.523 -0400", hash_original_method = "B80B70BCEBFE7A41A1C46DBA21C09DAD", hash_generated_method = "B80B70BCEBFE7A41A1C46DBA21C09DAD")
        public EntryIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.529 -0400", hash_original_method = "433D7E99AB55A4B03D9D3E9DC3E9704E", hash_generated_method = "A5B4BD1E59DB58A20DFA6894CB4F7FA9")
        public final Map.Entry<K, V> next() {
            Map.Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_96836142 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_96836142 = nextEntry();
            varB4EAC82CA7396A68D541C85D26508E83_96836142.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_96836142;
            // ---------- Original Method ----------
            //return nextEntry();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.529 -0400", hash_original_field = "F2C3C5ED4469A7ACAFC202E4DC767981", hash_generated_field = "BD3C1E8B9201DD0FF1E3AC19ADC772E9")

    private static long serialVersionUID = 3801124242820219131L;
}

