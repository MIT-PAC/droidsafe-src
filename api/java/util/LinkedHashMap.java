package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class LinkedHashMap<K, V> extends HashMap<K, V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.715 -0400", hash_original_field = "099FB995346F31C749F6E40DB0F395E3", hash_generated_field = "D6704B8F26715061947446A5240B101A")

    transient LinkedEntry<K, V> header;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.716 -0400", hash_original_field = "B1B8F9258C25833E563A747875ABA3F3", hash_generated_field = "3F26D7AF65C932D73D31BA6C85FF3982")

    private boolean accessOrder;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.716 -0400", hash_original_method = "BC14FA557BD7B0B9C577C3EA20F65BB1", hash_generated_method = "841BDE13C0D724F59D7372319DB3BC68")
    public  LinkedHashMap() {
        init();
        accessOrder = false;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.716 -0400", hash_original_method = "D0F194CEDBAC4E60D053508661AB90EF", hash_generated_method = "AF81C3A6342901CDC78A39BBC8257F31")
    public  LinkedHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
        addTaint(initialCapacity);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.716 -0400", hash_original_method = "51A3F20C6E131F4E066F002E9C38CBA5", hash_generated_method = "8C33FB4098CB0085A58600BBAEDCDDAF")
    public  LinkedHashMap(int initialCapacity, float loadFactor) {
        this(initialCapacity, loadFactor, false);
        addTaint(initialCapacity);
        addTaint(loadFactor);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.716 -0400", hash_original_method = "40A72D68B61D12122A849997E9E4FA74", hash_generated_method = "A66F0384E5FBFCAD0DE92A880D614A3F")
    public  LinkedHashMap(
            int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor);
        init();
        this.accessOrder = accessOrder;
        addTaint(initialCapacity);
        addTaint(loadFactor);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.717 -0400", hash_original_method = "D1B0A8129B2843C851AD81FABBEE8B92", hash_generated_method = "E44D30C7CF7DF64BB60F3791FD8CA442")
    public  LinkedHashMap(Map<? extends K, ? extends V> map) {
        this(capacityForInitSize(map.size()));
        constructorPutAll(map);
        addTaint(map.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.717 -0400", hash_original_method = "C3E8210D7C5926509287D8B7A9054888", hash_generated_method = "B6C5484F9803F011BF936D3E7CA26200")
    @Override
     void init() {
        header = new LinkedEntry<K, V>();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.717 -0400", hash_original_method = "EB729947D8C5A87C341C9E9026AB1206", hash_generated_method = "E29E2F84BB3FB143AC41BC9AE71E4190")
    public Entry<K, V> eldest() {
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_725265908 = null; 
        LinkedEntry<K, V> eldest = header.nxt;
        varB4EAC82CA7396A68D541C85D26508E83_725265908 = eldest != header ? eldest : null;
        varB4EAC82CA7396A68D541C85D26508E83_725265908.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_725265908;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.718 -0400", hash_original_method = "17248B030D95A40DE3DEF1923640BDC2", hash_generated_method = "4A9BBD149EA713E2407779ED49ECDD69")
    @Override
     void addNewEntry(K key, V value, int hash, int index) {
        LinkedEntry<K, V> header = this.header;
        LinkedEntry<K, V> eldest = header.nxt;
        {
            boolean var98F762CD6E5967A3F8DD94F64E8DE958_823857173 = (eldest != header && removeEldestEntry(eldest));
            {
                remove(eldest.key);
            } 
        } 
        LinkedEntry<K, V> oldTail = header.prv;
        LinkedEntry<K, V> newTail = new LinkedEntry<K,V>(
                key, value, hash, table[index], header, oldTail);
        table[index] = oldTail.nxt = header.prv = newTail;
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        addTaint(hash);
        addTaint(index);
        
        
        
        
            
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.718 -0400", hash_original_method = "53E46D1C7C140F5769FD83EFA867F0EB", hash_generated_method = "8B957F3F13946A3A5456A52905EE139E")
    @Override
     void addNewEntryForNullKey(V value) {
        LinkedEntry<K, V> header = this.header;
        LinkedEntry<K, V> eldest = header.nxt;
        {
            boolean var98F762CD6E5967A3F8DD94F64E8DE958_1109384913 = (eldest != header && removeEldestEntry(eldest));
            {
                remove(eldest.key);
            } 
        } 
        LinkedEntry<K, V> oldTail = header.prv;
        LinkedEntry<K, V> newTail = new LinkedEntry<K,V>(
                null, value, 0, null, header, oldTail);
        entryForNullKey = oldTail.nxt = header.prv = newTail;
        addTaint(value.getTaint());
        
        
        
        
            
        
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.720 -0400", hash_original_method = "DD7E1FD3A0E6B4968C119F3BE0C92615", hash_generated_method = "33D905AF72B38C712126B4E7204AC9F5")
    @Override
     HashMapEntry<K, V> constructorNewEntry(
            K key, V value, int hash, HashMapEntry<K, V> next) {
        HashMapEntry<K, V> varB4EAC82CA7396A68D541C85D26508E83_185243641 = null; 
        LinkedEntry<K, V> header = this.header;
        LinkedEntry<K, V> oldTail = header.prv;
        LinkedEntry<K, V> newTail = new LinkedEntry<K,V>(key, value, hash, next, header, oldTail);
        varB4EAC82CA7396A68D541C85D26508E83_185243641 = oldTail.nxt = header.prv = newTail;
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        addTaint(hash);
        addTaint(next.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_185243641.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_185243641;
        
        
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.722 -0400", hash_original_method = "5C4F6BF9C2C1A7BF64D67EB60F9C3D15", hash_generated_method = "B4F2F3C5309F6AA98013D682AEE89185")
    @Override
    public V get(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_263551801 = null; 
        V varB4EAC82CA7396A68D541C85D26508E83_561347499 = null; 
        V varB4EAC82CA7396A68D541C85D26508E83_584689355 = null; 
        V varB4EAC82CA7396A68D541C85D26508E83_1990540314 = null; 
        {
            HashMapEntry<K, V> e = entryForNullKey;
            varB4EAC82CA7396A68D541C85D26508E83_263551801 = null;
            makeTail((LinkedEntry<K, V>) e);
            varB4EAC82CA7396A68D541C85D26508E83_561347499 = e.value;
        } 
        int hash = key.hashCode();
        hash ^= (hash >>> 20) ^ (hash >>> 12);
        hash ^= (hash >>> 7) ^ (hash >>> 4);
        HashMapEntry<K, V>[] tab = table;
        {
            HashMapEntry<K, V> e = tab[hash & (tab.length - 1)];
            e = e.next;
            {
                K eKey = e.key;
                {
                    boolean var9E8F21F6B5DB5FEDBA4125840A8612D4_180449410 = (eKey == key || (e.hash == hash && key.equals(eKey)));
                    {
                        makeTail((LinkedEntry<K, V>) e);
                        varB4EAC82CA7396A68D541C85D26508E83_584689355 = e.value;
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1990540314 = null;
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_1044400965; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1044400965 = varB4EAC82CA7396A68D541C85D26508E83_263551801;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1044400965 = varB4EAC82CA7396A68D541C85D26508E83_561347499;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1044400965 = varB4EAC82CA7396A68D541C85D26508E83_584689355;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1044400965 = varB4EAC82CA7396A68D541C85D26508E83_1990540314;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1044400965.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1044400965;
        
        
            
            
                
            
                
            
        
        
        
        
        
        
                
            
            
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.723 -0400", hash_original_method = "D37211F13FFE982B5329A6F04D365268", hash_generated_method = "3D3BBFEC671D8C6FFA979D2E2C3E8F10")
    private void makeTail(LinkedEntry<K, V> e) {
        e.prv.nxt = e.nxt;
        e.nxt.prv = e.prv;
        LinkedEntry<K, V> header = this.header;
        LinkedEntry<K, V> oldTail = header.prv;
        e.nxt = header;
        e.prv = oldTail;
        oldTail.nxt = header.prv = e;
        addTaint(e.getTaint());
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.723 -0400", hash_original_method = "1F9A2707DB97E3137F0AF608EC157C5F", hash_generated_method = "DDA50A06F65864922709022276489742")
    @Override
     void preModify(HashMapEntry<K, V> e) {
        {
            makeTail((LinkedEntry<K, V>) e);
        } 
        addTaint(e.getTaint());
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.724 -0400", hash_original_method = "7796AD94E39D6453B5D3B10446A6CDCE", hash_generated_method = "71738C9F270DD77DDC7599698BBE876B")
    @Override
     void postRemove(HashMapEntry<K, V> e) {
        LinkedEntry<K, V> le = (LinkedEntry<K, V>) e;
        le.prv.nxt = le.nxt;
        le.nxt.prv = le.prv;
        le.nxt = le.prv = null;
        addTaint(e.getTaint());
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.724 -0400", hash_original_method = "B1ADF7F2DAB1D611A8BB20D2E6FE8BE5", hash_generated_method = "11B0125E3483306067BB2756AA107CB6")
    @Override
    public boolean containsValue(Object value) {
        {
            {
                LinkedEntry<K, V> header = this.header;
                LinkedEntry<K, V> e = header.nxt;
                e = e.nxt;
            } 
        } 
        {
            LinkedEntry<K, V> header = this.header;
            LinkedEntry<K, V> e = header.nxt;
            e = e.nxt;
            {
                {
                    boolean var88D4FD98A5D9191EF70D3714E40B4A58_1744956072 = (value.equals(e.value));
                } 
            } 
        } 
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_608272479 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_608272479;
        
        
            
                    
                
                    
                
            
            
        
        
                
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.724 -0400", hash_original_method = "F9D4D1514A1438141913ED2857BCCF60", hash_generated_method = "FF8F2046642E360F5E3EAF58FEFCC95E")
    public void clear() {
        super.clear();
        LinkedEntry<K, V> header = this.header;
        {
            LinkedEntry<K, V> e = header.nxt;
            {
                LinkedEntry<K, V> nxt = e.nxt;
                e.nxt = e.prv = null;
                e = nxt;
            } 
        } 
        header.nxt = header.prv = header;
        
        
        
        
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.725 -0400", hash_original_method = "E5C2B853B7FE0DFF8A1198070D9AED67", hash_generated_method = "7166D1698F97486746ADCAE860273677")
    @Override
     Iterator<K> newKeyIterator() {
        Iterator<K> varB4EAC82CA7396A68D541C85D26508E83_86579227 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_86579227 = new KeyIterator();
        varB4EAC82CA7396A68D541C85D26508E83_86579227.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_86579227;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.725 -0400", hash_original_method = "58BEE1C21CE9010029EB8FF9FDCDF9B3", hash_generated_method = "B25455F3191AEFEDB94855E42B875526")
    @Override
     Iterator<V> newValueIterator() {
        Iterator<V> varB4EAC82CA7396A68D541C85D26508E83_455945586 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_455945586 = new ValueIterator();
        varB4EAC82CA7396A68D541C85D26508E83_455945586.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_455945586;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.726 -0400", hash_original_method = "7416C435C60270F3DC14B8CDBC0FF1EF", hash_generated_method = "8983A40248C7513EB990EE9F119F0857")
    @Override
     Iterator<Map.Entry<K, V>> newEntryIterator() {
        Iterator<Map.Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_1339795486 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1339795486 = new EntryIterator();
        varB4EAC82CA7396A68D541C85D26508E83_1339795486.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1339795486;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.726 -0400", hash_original_method = "F4EE8618F7DE6E7966D8D47C993C665B", hash_generated_method = "6467A1C92D841800D8286EE1AF03BA7A")
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        addTaint(eldest.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1632296636 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1632296636;
        
        
    }

    
    static class LinkedEntry<K, V> extends HashMapEntry<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.726 -0400", hash_original_field = "07635D95F92116ADCF0E12FD96FFBA82", hash_generated_field = "56A011BACEDF16E82830248B7AE61872")

        LinkedEntry<K, V> nxt;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.726 -0400", hash_original_field = "6F683603084DF0A15496D735362929DF", hash_generated_field = "F6D1F77EF7AEF93247967CEE52D0DED3")

        LinkedEntry<K, V> prv;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.726 -0400", hash_original_method = "2D3DD312F29888BE4F3ED431CA771887", hash_generated_method = "43ABFEF2EAF691DAC71324A38269F779")
          LinkedEntry() {
            super(null, null, 0, null);
            nxt = prv = this;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.727 -0400", hash_original_method = "015489E05E7D25D852035EC4BCD1F37F", hash_generated_method = "36EB435C4A23FE0648CA396CB7D82C02")
          LinkedEntry(K key, V value, int hash, HashMapEntry<K, V> next,
                    LinkedEntry<K, V> nxt, LinkedEntry<K, V> prv) {
            super(key, value, hash, next);
            this.nxt = nxt;
            this.prv = prv;
            addTaint(key.getTaint());
            addTaint(value.getTaint());
            addTaint(hash);
            addTaint(next.getTaint());
            
            
            
        }

        
    }


    
    private abstract class LinkedHashIterator<T> implements Iterator<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.727 -0400", hash_original_field = "CB175E069FB5676DC1D73D2BBD4E839B", hash_generated_field = "EEDF831891E86FCB41BF7C113241C027")

        LinkedEntry<K, V> next = header.nxt;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.727 -0400", hash_original_field = "761F9A2134138B442C42042E19B292E5", hash_generated_field = "6763EC0E1DCA819FA35D2C7D853926FB")

        LinkedEntry<K, V> lastReturned = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.727 -0400", hash_original_field = "587E194BCD330DA9D6CB9DB53EA8709A", hash_generated_field = "17128C49BCF19B4186F02F384F2DEA86")

        int expectedModCount = modCount;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.727 -0400", hash_original_method = "FBBC727CB357F07230390F692D9E6F38", hash_generated_method = "FBBC727CB357F07230390F692D9E6F38")
        public LinkedHashIterator ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.727 -0400", hash_original_method = "C7E1ED06208DECD5C814809FB00992D2", hash_generated_method = "5FA3540E6D653E4520D8FEEF84DF6777")
        public final boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2057698510 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2057698510;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.728 -0400", hash_original_method = "6E1581FE9AE48441E5CB627F97604374", hash_generated_method = "AC3A1E43C53FE0602DC9D89542C3F5E6")
        final LinkedEntry<K, V> nextEntry() {
            LinkedEntry<K, V> varB4EAC82CA7396A68D541C85D26508E83_764655926 = null; 
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            LinkedEntry<K, V> e = next;
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            next = e.nxt;
            varB4EAC82CA7396A68D541C85D26508E83_764655926 = lastReturned = e;
            varB4EAC82CA7396A68D541C85D26508E83_764655926.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_764655926;
            
            
                
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.728 -0400", hash_original_method = "9A49FB7CCFBAA785998B91529061BD5F", hash_generated_method = "36521BB0FB0EA5530FEC401A9506FE46")
        public final void remove() {
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            LinkedHashMap.this.remove(lastReturned.key);
            lastReturned = null;
            expectedModCount = modCount;
            
            
                
            
                
            
            
            
        }

        
    }


    
    private final class KeyIterator extends LinkedHashIterator<K> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.728 -0400", hash_original_method = "F1A12FA7FDFCBC1B54210EBDFEB312D4", hash_generated_method = "F1A12FA7FDFCBC1B54210EBDFEB312D4")
        public KeyIterator ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.729 -0400", hash_original_method = "EA50D6F1622FBE805CA447972176B648", hash_generated_method = "A1E6DEA9DDCCFB36C16EFE55720CB41F")
        public final K next() {
            K varB4EAC82CA7396A68D541C85D26508E83_178566725 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_178566725 = nextEntry().key;
            varB4EAC82CA7396A68D541C85D26508E83_178566725.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_178566725;
            
            
        }

        
    }


    
    private final class ValueIterator extends LinkedHashIterator<V> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.729 -0400", hash_original_method = "F211FE83547E030E3E0992549D0B21BC", hash_generated_method = "F211FE83547E030E3E0992549D0B21BC")
        public ValueIterator ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.731 -0400", hash_original_method = "53BB4827D74FCF37FAF510D076C14D5E", hash_generated_method = "ECF0F22A1B162D4AF9D86596F09A15E5")
        public final V next() {
            V varB4EAC82CA7396A68D541C85D26508E83_1140903906 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1140903906 = nextEntry().value;
            varB4EAC82CA7396A68D541C85D26508E83_1140903906.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1140903906;
            
            
        }

        
    }


    
    private final class EntryIterator extends LinkedHashIterator<Map.Entry<K, V>> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.731 -0400", hash_original_method = "B80B70BCEBFE7A41A1C46DBA21C09DAD", hash_generated_method = "B80B70BCEBFE7A41A1C46DBA21C09DAD")
        public EntryIterator ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.732 -0400", hash_original_method = "433D7E99AB55A4B03D9D3E9DC3E9704E", hash_generated_method = "A5A24F57191057750ECD854CE44CB885")
        public final Map.Entry<K, V> next() {
            Map.Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_790016610 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_790016610 = nextEntry();
            varB4EAC82CA7396A68D541C85D26508E83_790016610.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_790016610;
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.732 -0400", hash_original_field = "F2C3C5ED4469A7ACAFC202E4DC767981", hash_generated_field = "58143BDD5D2BB4E9A1A5E401127BE552")

    private static final long serialVersionUID = 3801124242820219131L;
}

