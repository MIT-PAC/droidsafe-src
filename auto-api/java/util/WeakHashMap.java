package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class WeakHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.183 -0400", hash_original_field = "4B551E83AB7D0C8C6FE6D2A3C3F57121", hash_generated_field = "DA4F581341DFFC093DAB2ED377CF1682")

    private ReferenceQueue<K> referenceQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.183 -0400", hash_original_field = "BC8C6DCF12CE09E50A98BB57ADFCADD9", hash_generated_field = "BF84735BCD9327FC2D1CC927ED35945D")

    int elementCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.183 -0400", hash_original_field = "8D395F1876FF8AE01BE52A9C4C2ED552", hash_generated_field = "36C14C81A5F4E64B5630EF2ADDAD7469")

    Entry<K, V>[] elementData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.183 -0400", hash_original_field = "97C293EF8ABD832D29E88C21D8E562F5", hash_generated_field = "9875194AD635CA8D9949128549486276")

    private int loadFactor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.183 -0400", hash_original_field = "F0598264A691A8F62272ACA0E79AF374", hash_generated_field = "831F8FC1A32CF07BE696149BB6AEA9AA")

    private int threshold;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.183 -0400", hash_original_field = "675B3022548A1029F9CE7A2C25B23BBF", hash_generated_field = "7980638400FDA73EFCEF2F9901C03D43")

    volatile int modCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.195 -0400", hash_original_method = "B976885DE3CF2C49EC1331AC2786A4B5", hash_generated_method = "947788F1D50A3898B6C48AAEC3B777CB")
    public  WeakHashMap() {
        this(DEFAULT_SIZE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.195 -0400", hash_original_method = "76AE00E803F5BFDB4BDF43DC151D88D7", hash_generated_method = "1F46AD3FB0C8AC5CD200FF0E82EB40B0")
    public  WeakHashMap(int capacity) {
        {
            elementCount = 0;
            elementData = newEntryArray(capacity == 0 ? 1 : capacity);
            loadFactor = 7500;
            computeMaxSize();
            referenceQueue = new ReferenceQueue<K>();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        // ---------- Original Method ----------
        //if (capacity >= 0) {
            //elementCount = 0;
            //elementData = newEntryArray(capacity == 0 ? 1 : capacity);
            //loadFactor = 7500; 
            //computeMaxSize();
            //referenceQueue = new ReferenceQueue<K>();
        //} else {
            //throw new IllegalArgumentException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.196 -0400", hash_original_method = "342F9B7CF63C1134C14E3979782FA4FA", hash_generated_method = "1C3CBF911307A65894F38766BB286C28")
    public  WeakHashMap(int capacity, float loadFactor) {
        {
            elementCount = 0;
            elementData = newEntryArray(capacity == 0 ? 1 : capacity);
            this.loadFactor = (int) (loadFactor * 10000);
            computeMaxSize();
            referenceQueue = new ReferenceQueue<K>();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        // ---------- Original Method ----------
        //if (capacity >= 0 && loadFactor > 0) {
            //elementCount = 0;
            //elementData = newEntryArray(capacity == 0 ? 1 : capacity);
            //this.loadFactor = (int) (loadFactor * 10000);
            //computeMaxSize();
            //referenceQueue = new ReferenceQueue<K>();
        //} else {
            //throw new IllegalArgumentException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.196 -0400", hash_original_method = "4D7BC16BC60EE786903D624E86CA0AFB", hash_generated_method = "36288AB5B6E2AC0F27A53BFAB0B193EA")
    public  WeakHashMap(Map<? extends K, ? extends V> map) {
        this(map.size() < 6 ? 11 : map.size() * 2);
        putAllImpl(map);
        addTaint(map.getTaint());
        // ---------- Original Method ----------
        //putAllImpl(map);
    }

    
        @SuppressWarnings("unchecked")
    private static <K, V> Entry<K, V>[] newEntryArray(int size) {
        return new Entry[size];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.197 -0400", hash_original_method = "C690E441FDF499DD7829AA3D638ADE28", hash_generated_method = "6A38F10CD57B3FAECCE4A13A17B28F9D")
    @Override
    public void clear() {
        {
            elementCount = 0;
            Arrays.fill(elementData, null);
            {
                boolean varFA1D4F81EDB4C923F843813B6540E0FE_1856038909 = (referenceQueue.poll() != null);
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (elementCount > 0) {
            //elementCount = 0;
            //Arrays.fill(elementData, null);
            //modCount++;
            //while (referenceQueue.poll() != null) {
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.197 -0400", hash_original_method = "85D93BA99AF40F5CDC3F42570A89C9FC", hash_generated_method = "BE619D13CAF85822181B65989DC845A9")
    private void computeMaxSize() {
        threshold = (int) ((long) elementData.length * loadFactor / 10000);
        // ---------- Original Method ----------
        //threshold = (int) ((long) elementData.length * loadFactor / 10000);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.197 -0400", hash_original_method = "7C0BA359573790AC71E46CA35F3B3C5D", hash_generated_method = "A047081EB6BEA6A0DF2033BDE8BA8237")
    @Override
    public boolean containsKey(Object key) {
        boolean var80C6FDED6A61C62705DB13137566169D_484873421 = (getEntry(key) != null);
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1351926732 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1351926732;
        // ---------- Original Method ----------
        //return getEntry(key) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.210 -0400", hash_original_method = "115108C1B40A91216FE420487FA7990C", hash_generated_method = "56B2C11A27FD55740A052363A233DED9")
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_1702778876 = null; //Variable for return #1
        poll();
        varB4EAC82CA7396A68D541C85D26508E83_1702778876 = new AbstractSet<Map.Entry<K, V>>() {
            @Override
            public int size() {
                return WeakHashMap.this.size();
            }
            @Override
            public void clear() {
                WeakHashMap.this.clear();
            }
            @Override
            public boolean remove(Object object) {
                if (contains(object)) {
                    WeakHashMap.this
                            .remove(((Map.Entry<?, ?>) object).getKey());
                    return true;
                }
                return false;
            }
            @Override
            public boolean contains(Object object) {
                if (object instanceof Map.Entry) {
                    Entry<?, ?> entry = getEntry(((Map.Entry<?, ?>) object)
                            .getKey());
                    if (entry != null) {
                        Object key = entry.get();
                        if (key != null || entry.isNull) {
                            return object.equals(entry);
                        }
                    }
                }
                return false;
            }
            @Override
            public Iterator<Map.Entry<K, V>> iterator() {
                return new HashIterator<Map.Entry<K, V>>(
                        new Entry.Type<Map.Entry<K, V>, K, V>() {
                            public Map.Entry<K, V> get(Map.Entry<K, V> entry) {
                                return entry;
                            }
                        });
            }
        };
        varB4EAC82CA7396A68D541C85D26508E83_1702778876.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1702778876;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.361 -0400", hash_original_method = "058A25F673776D4338089073DA213D4E", hash_generated_method = "8E476F922FDA481630D88BB1FEC6885C")
    @Override
    public Set<K> keySet() {
        Set<K> varB4EAC82CA7396A68D541C85D26508E83_1015968004 = null; //Variable for return #1
        poll();
        {
            keySet = new AbstractSet<K>() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.219 -0400", hash_original_method = "D170B4D54B17306878DDF90A529C04ED", hash_generated_method = "41897938BDFB64CEC350937AE41A9008")
                @Override
                public boolean contains(Object object) {
                    boolean var5CF08BC5A8889C1E8B40FF0332AFAC24_571079455 = (containsKey(object));
                    addTaint(object.getTaint());
                    boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_961100975 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_961100975;
                    // ---------- Original Method ----------
                    //return containsKey(object);
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.220 -0400", hash_original_method = "997773928D6A4FA2A905BEE282A68997", hash_generated_method = "4FC306D4A63E4654257E2AFDF9030695")
                @Override
                public int size() {
                    int varEB466AC21988954CC038D6EAFB4E7FEA_1588372936 = (WeakHashMap.this.size());
                    int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_155966438 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_155966438;
                    // ---------- Original Method ----------
                    //return WeakHashMap.this.size();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.220 -0400", hash_original_method = "0820DD19F55EBD9E05BEDEF72AA76B85", hash_generated_method = "216199AA5B7C7589486AA111C1364167")
                @Override
                public void clear() {
                    WeakHashMap.this.clear();
                    // ---------- Original Method ----------
                    //WeakHashMap.this.clear();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.352 -0400", hash_original_method = "2EBC57A89CF751265ACE297F532371F8", hash_generated_method = "742BD38FF145FFA95AF3F93C76AE5071")
                @Override
                public boolean remove(Object key) {
                    {
                        boolean varD4D10245FFFD9692A4F42EDF884E815E_922744349 = (containsKey(key));
                        {
                            WeakHashMap.this.remove(key);
                        } //End block
                    } //End collapsed parenthetic
                    addTaint(key.getTaint());
                    boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1910456064 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1910456064;
                    // ---------- Original Method ----------
                    //if (containsKey(key)) {
                        //WeakHashMap.this.remove(key);
                        //return true;
                    //}
                    //return false;
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.353 -0400", hash_original_method = "AE3D91420CF50F34AE4E77081237432D", hash_generated_method = "11D6ED37461FBA8FD8C585FD808CEE0E")
                @Override
                public Iterator<K> iterator() {
                    Iterator<K> varB4EAC82CA7396A68D541C85D26508E83_766028073 = null; //Variable for return #1
                    varB4EAC82CA7396A68D541C85D26508E83_766028073 = new HashIterator<K>(new Entry.Type<K, K, V>() {
                        public K get(Map.Entry<K, V> entry) {
                            return entry.getKey();
                        }
                    });
                    varB4EAC82CA7396A68D541C85D26508E83_766028073.addTaint(getTaint()); //Add taint from parent
                    return varB4EAC82CA7396A68D541C85D26508E83_766028073;
                    // ---------- Original Method ----------
                    //return new HashIterator<K>(new Entry.Type<K, K, V>() {
                        //public K get(Map.Entry<K, V> entry) {
                            //return entry.getKey();
                        //}
                    //});
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.355 -0400", hash_original_method = "8D1ED5FEE11EEA3682A2E2ECF5DE32C3", hash_generated_method = "F8DFD1F86ED3AA82BB90D4709FE27102")
                @Override
                public Object[] toArray() {
                    Object[] varB4EAC82CA7396A68D541C85D26508E83_1615417591 = null; //Variable for return #1
                    Collection<K> coll;
                    coll = new ArrayList<K>(size());
                    {
                        Iterator<K> iter;
                        iter = iterator();
                        boolean var0719F6DF13666099B3F99B9DD393E1F6_792651837 = (iter.hasNext());
                        {
                            coll.add(iter.next());
                        } //End block
                    } //End collapsed parenthetic
                    varB4EAC82CA7396A68D541C85D26508E83_1615417591 = coll.toArray();
                    varB4EAC82CA7396A68D541C85D26508E83_1615417591.addTaint(getTaint()); //Add taint from parent
                    return varB4EAC82CA7396A68D541C85D26508E83_1615417591;
                    // ---------- Original Method ----------
                    //Collection<K> coll = new ArrayList<K>(size());
                    //for (Iterator<K> iter = iterator(); iter.hasNext();) {
                        //coll.add(iter.next());
                    //}
                    //return coll.toArray();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.360 -0400", hash_original_method = "50B72C5F86BB9252B582673D59AA848C", hash_generated_method = "9B45694DB7E0BCA17FE1F4F03BD8992F")
                @Override
                public <T> T[] toArray(T[] contents) {
                    T[] varB4EAC82CA7396A68D541C85D26508E83_1588252957 = null; //Variable for return #1
                    Collection<K> coll;
                    coll = new ArrayList<K>(size());
                    {
                        Iterator<K> iter;
                        iter = iterator();
                        boolean var0719F6DF13666099B3F99B9DD393E1F6_2023780143 = (iter.hasNext());
                        {
                            coll.add(iter.next());
                        } //End block
                    } //End collapsed parenthetic
                    varB4EAC82CA7396A68D541C85D26508E83_1588252957 = coll.toArray(contents);
                    addTaint(contents[0].getTaint());
                    varB4EAC82CA7396A68D541C85D26508E83_1588252957.addTaint(getTaint()); //Add taint from parent
                    return varB4EAC82CA7396A68D541C85D26508E83_1588252957;
                    // ---------- Original Method ----------
                    //Collection<K> coll = new ArrayList<K>(size());
                    //for (Iterator<K> iter = iterator(); iter.hasNext();) {
                        //coll.add(iter.next());
                    //}
                    //return coll.toArray(contents);
                }
};
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1015968004 = keySet;
        varB4EAC82CA7396A68D541C85D26508E83_1015968004.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1015968004;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.397 -0400", hash_original_method = "1BF87F9B8C3D58711D484B01D41C9F2F", hash_generated_method = "BC4D620BEC14167740A231804F7D5B5C")
    @Override
    public Collection<V> values() {
        Collection<V> varB4EAC82CA7396A68D541C85D26508E83_890779122 = null; //Variable for return #1
        poll();
        {
            valuesCollection = new AbstractCollection<V>() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.363 -0400", hash_original_method = "997773928D6A4FA2A905BEE282A68997", hash_generated_method = "40E5885201B717A567CACB5C698D762B")
                @Override
                public int size() {
                    int varEB466AC21988954CC038D6EAFB4E7FEA_1616146051 = (WeakHashMap.this.size());
                    int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1560282363 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1560282363;
                    // ---------- Original Method ----------
                    //return WeakHashMap.this.size();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.396 -0400", hash_original_method = "0820DD19F55EBD9E05BEDEF72AA76B85", hash_generated_method = "216199AA5B7C7589486AA111C1364167")
                @Override
                public void clear() {
                    WeakHashMap.this.clear();
                    // ---------- Original Method ----------
                    //WeakHashMap.this.clear();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.396 -0400", hash_original_method = "7679F4183F803D10EFCD1172E399C7C3", hash_generated_method = "3B5555AFF6BA746B0441E8537B735B0E")
                @Override
                public boolean contains(Object object) {
                    boolean varF0370008E8B5928F4FAF5BBF8632C1B3_115610407 = (containsValue(object));
                    addTaint(object.getTaint());
                    boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_381381629 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_381381629;
                    // ---------- Original Method ----------
                    //return containsValue(object);
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.397 -0400", hash_original_method = "D1021921C3018EF53317EBCD6C577AB9", hash_generated_method = "5D95AAD62091E7DA621797B64F025CCF")
                @Override
                public Iterator<V> iterator() {
                    Iterator<V> varB4EAC82CA7396A68D541C85D26508E83_1224372543 = null; //Variable for return #1
                    varB4EAC82CA7396A68D541C85D26508E83_1224372543 = new HashIterator<V>(new Entry.Type<V, K, V>() {
                        public V get(Map.Entry<K, V> entry) {
                            return entry.getValue();
                        }
                    });
                    varB4EAC82CA7396A68D541C85D26508E83_1224372543.addTaint(getTaint()); //Add taint from parent
                    return varB4EAC82CA7396A68D541C85D26508E83_1224372543;
                    // ---------- Original Method ----------
                    //return new HashIterator<V>(new Entry.Type<V, K, V>() {
                        //public V get(Map.Entry<K, V> entry) {
                            //return entry.getValue();
                        //}
                    //});
                }
};
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_890779122 = valuesCollection;
        varB4EAC82CA7396A68D541C85D26508E83_890779122.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_890779122;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.398 -0400", hash_original_method = "7498B4140ED8DA87371F31164D271C1D", hash_generated_method = "9580ACC955D7FB2EFD08C1E2237B161D")
    @Override
    public V get(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_392499324 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_1028964242 = null; //Variable for return #2
        V varB4EAC82CA7396A68D541C85D26508E83_1818863326 = null; //Variable for return #3
        V varB4EAC82CA7396A68D541C85D26508E83_1583356025 = null; //Variable for return #4
        poll();
        {
            int index;
            index = (key.hashCode() & 0x7FFFFFFF) % elementData.length;
            Entry<K, V> entry;
            entry = elementData[index];
            {
                {
                    boolean var34A40B722D871D6DB92AB2E02C0D49BB_1993498504 = (key.equals(entry.get()));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_392499324 = entry.value;
                    } //End block
                } //End collapsed parenthetic
                entry = entry.next;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1028964242 = null;
        } //End block
        Entry<K, V> entry;
        entry = elementData[0];
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1818863326 = entry.value;
            } //End block
            entry = entry.next;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1583356025 = null;
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_1111654487; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1111654487 = varB4EAC82CA7396A68D541C85D26508E83_392499324;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1111654487 = varB4EAC82CA7396A68D541C85D26508E83_1028964242;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1111654487 = varB4EAC82CA7396A68D541C85D26508E83_1818863326;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1111654487 = varB4EAC82CA7396A68D541C85D26508E83_1583356025;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1111654487.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1111654487;
        // ---------- Original Method ----------
        //poll();
        //if (key != null) {
            //int index = (key.hashCode() & 0x7FFFFFFF) % elementData.length;
            //Entry<K, V> entry = elementData[index];
            //while (entry != null) {
                //if (key.equals(entry.get())) {
                    //return entry.value;
                //}
                //entry = entry.next;
            //}
            //return null;
        //}
        //Entry<K, V> entry = elementData[0];
        //while (entry != null) {
            //if (entry.isNull) {
                //return entry.value;
            //}
            //entry = entry.next;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.414 -0400", hash_original_method = "545F7F0FB84E7EA33FCF99594092AF0D", hash_generated_method = "96C38141104CF682D4ED94D23515961A")
     Entry<K, V> getEntry(Object key) {
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1321282842 = null; //Variable for return #1
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_479845950 = null; //Variable for return #2
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_517735397 = null; //Variable for return #3
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_898281234 = null; //Variable for return #4
        poll();
        {
            int index;
            index = (key.hashCode() & 0x7FFFFFFF) % elementData.length;
            Entry<K, V> entry;
            entry = elementData[index];
            {
                {
                    boolean var34A40B722D871D6DB92AB2E02C0D49BB_1575627786 = (key.equals(entry.get()));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1321282842 = entry;
                    } //End block
                } //End collapsed parenthetic
                entry = entry.next;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_479845950 = null;
        } //End block
        Entry<K, V> entry;
        entry = elementData[0];
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_517735397 = entry;
            } //End block
            entry = entry.next;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_898281234 = null;
        addTaint(key.getTaint());
        Entry<K, V> varA7E53CE21691AB073D9660D615818899_64043674; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_64043674 = varB4EAC82CA7396A68D541C85D26508E83_1321282842;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_64043674 = varB4EAC82CA7396A68D541C85D26508E83_479845950;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_64043674 = varB4EAC82CA7396A68D541C85D26508E83_517735397;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_64043674 = varB4EAC82CA7396A68D541C85D26508E83_898281234;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_64043674.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_64043674;
        // ---------- Original Method ----------
        //poll();
        //if (key != null) {
            //int index = (key.hashCode() & 0x7FFFFFFF) % elementData.length;
            //Entry<K, V> entry = elementData[index];
            //while (entry != null) {
                //if (key.equals(entry.get())) {
                    //return entry;
                //}
                //entry = entry.next;
            //}
            //return null;
        //}
        //Entry<K, V> entry = elementData[0];
        //while (entry != null) {
            //if (entry.isNull) {
                //return entry;
            //}
            //entry = entry.next;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.415 -0400", hash_original_method = "EBDA4BA5DE93153797BA511A1B84894F", hash_generated_method = "ED0E4BD90BE545C8E79DEA326F3E86C3")
    @Override
    public boolean containsValue(Object value) {
        poll();
        {
            {
                int i;
                i = elementData.length;
                {
                    Entry<K, V> entry;
                    entry = elementData[i];
                    {
                        K key;
                        key = entry.get();
                        {
                            boolean var18A512D740DE406E77259979D1000436_1645728152 = ((key != null || entry.isNull)
                            && value.equals(entry.value));
                        } //End collapsed parenthetic
                        entry = entry.next;
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                int i;
                i = elementData.length;
                {
                    Entry<K, V> entry;
                    entry = elementData[i];
                    {
                        K key;
                        key = entry.get();
                        entry = entry.next;
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1062325487 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1062325487;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.416 -0400", hash_original_method = "296240B68F4A866C698190CF33710ED8", hash_generated_method = "A939B2140AED2BE626E1CA4897C12639")
    @Override
    public boolean isEmpty() {
        boolean var5E7C4FBBEC9A5754B20CB85881048CD5_96203674 = (size() == 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1496658185 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1496658185;
        // ---------- Original Method ----------
        //return size() == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.416 -0400", hash_original_method = "0A4BB2570FECEAC055174AF0C493CF3C", hash_generated_method = "3D8CCEFE5AF1F5FA47805FE4C22D4151")
    @SuppressWarnings("unchecked")
     void poll() {
        Entry<K, V> toRemove;
        {
            boolean varAF179C89B87910BBBA6E45758D4FD0E7_1257789850 = ((toRemove = (Entry<K, V>) referenceQueue.poll()) != null);
            {
                removeEntry(toRemove);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Entry<K, V> toRemove;
        //while ((toRemove = (Entry<K, V>) referenceQueue.poll()) != null) {
            //removeEntry(toRemove);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.417 -0400", hash_original_method = "950CA8B0FD25845E584DCFB2BE4D9F32", hash_generated_method = "3B745E43F6B3500A6A4960C2C0C2895B")
     void removeEntry(Entry<K, V> toRemove) {
        Entry<K, V> entry, last;
        last = null;
        int index;
        index = (toRemove.hash & 0x7FFFFFFF) % elementData.length;
        entry = elementData[index];
        {
            {
                {
                    elementData[index] = entry.next;
                } //End block
                {
                    last.next = entry.next;
                } //End block
            } //End block
            last = entry;
            entry = entry.next;
        } //End block
        addTaint(toRemove.getTaint());
        // ---------- Original Method ----------
        //Entry<K, V> entry, last = null;
        //int index = (toRemove.hash & 0x7FFFFFFF) % elementData.length;
        //entry = elementData[index];
        //while (entry != null) {
            //if (toRemove == entry) {
                //modCount++;
                //if (last == null) {
                    //elementData[index] = entry.next;
                //} else {
                    //last.next = entry.next;
                //}
                //elementCount--;
                //break;
            //}
            //last = entry;
            //entry = entry.next;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.434 -0400", hash_original_method = "E298E65486168CC370356B38BEF7AC1C", hash_generated_method = "97CA8D2BDD95806D3DD696527A94A676")
    @Override
    public V put(K key, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_626619686 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_1409402438 = null; //Variable for return #2
        poll();
        int index;
        index = 0;
        Entry<K, V> entry;
        {
            index = (key.hashCode() & 0x7FFFFFFF) % elementData.length;
            entry = elementData[index];
            {
                boolean var11C456750D82E660592E03F3DAA89A38_1436540964 = (entry != null && !key.equals(entry.get()));
                {
                    entry = entry.next;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            entry = elementData[0];
            {
                entry = entry.next;
            } //End block
        } //End block
        {
            {
                rehash();
                index = key == null ? 0 : (key.hashCode() & 0x7FFFFFFF)
                        % elementData.length;
            } //End block
            entry = new Entry<K, V>(key, value, referenceQueue);
            entry.next = elementData[index];
            elementData[index] = entry;
            varB4EAC82CA7396A68D541C85D26508E83_626619686 = null;
        } //End block
        V result;
        result = entry.value;
        entry.value = value;
        varB4EAC82CA7396A68D541C85D26508E83_1409402438 = result;
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        V varA7E53CE21691AB073D9660D615818899_1991920149; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1991920149 = varB4EAC82CA7396A68D541C85D26508E83_626619686;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1991920149 = varB4EAC82CA7396A68D541C85D26508E83_1409402438;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1991920149.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1991920149;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.435 -0400", hash_original_method = "2B64F6E6AE3910B09507F9013DEACFFD", hash_generated_method = "B8C09FECA25AEF91449F210547B15507")
    private void rehash() {
        int length;
        length = elementData.length * 2;
        {
            length = 1;
        } //End block
        Entry<K, V>[] newData;
        newData = newEntryArray(length);
        {
            int i;
            i = 0;
            {
                Entry<K, V> entry;
                entry = elementData[i];
                {
                    int index;
                    index = 0;
                    index = (entry.hash & 0x7FFFFFFF)
                        % length;
                    Entry<K, V> next;
                    next = entry.next;
                    entry.next = newData[index];
                    newData[index] = entry;
                    entry = next;
                } //End block
            } //End block
        } //End collapsed parenthetic
        elementData = newData;
        computeMaxSize();
        // ---------- Original Method ----------
        //int length = elementData.length * 2;
        //if (length == 0) {
            //length = 1;
        //}
        //Entry<K, V>[] newData = newEntryArray(length);
        //for (int i = 0; i < elementData.length; i++) {
            //Entry<K, V> entry = elementData[i];
            //while (entry != null) {
                //int index = entry.isNull ? 0 : (entry.hash & 0x7FFFFFFF)
                        //% length;
                //Entry<K, V> next = entry.next;
                //entry.next = newData[index];
                //newData[index] = entry;
                //entry = next;
            //}
        //}
        //elementData = newData;
        //computeMaxSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.436 -0400", hash_original_method = "57B3987EA7E50826E0AAD0198F968E42", hash_generated_method = "43FD7CC93F90FFCD58209DA7AC6028FD")
    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        putAllImpl(map);
        addTaint(map.getTaint());
        // ---------- Original Method ----------
        //putAllImpl(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.443 -0400", hash_original_method = "FE1A1739C961B2012661CB8735C428AE", hash_generated_method = "761FFE0A9D64675BB403ABC810CFA62D")
    @Override
    public V remove(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_1120874779 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_103785125 = null; //Variable for return #2
        poll();
        int index;
        index = 0;
        Entry<K, V> entry, last;
        last = null;
        {
            index = (key.hashCode() & 0x7FFFFFFF) % elementData.length;
            entry = elementData[index];
            {
                boolean var11C456750D82E660592E03F3DAA89A38_190705125 = (entry != null && !key.equals(entry.get()));
                {
                    last = entry;
                    entry = entry.next;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            entry = elementData[0];
            {
                last = entry;
                entry = entry.next;
            } //End block
        } //End block
        {
            {
                elementData[index] = entry.next;
            } //End block
            {
                last.next = entry.next;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1120874779 = entry.value;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_103785125 = null;
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_397119320; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_397119320 = varB4EAC82CA7396A68D541C85D26508E83_1120874779;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_397119320 = varB4EAC82CA7396A68D541C85D26508E83_103785125;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_397119320.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_397119320;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.443 -0400", hash_original_method = "B65BB7405B9BD112F0A817BA32556A99", hash_generated_method = "A5F47A05658AD9AB2594DE973A41D5CB")
    @Override
    public int size() {
        poll();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_341183656 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_341183656;
        // ---------- Original Method ----------
        //poll();
        //return elementCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.458 -0400", hash_original_method = "F23833AECC848C129604A1D671C10BB2", hash_generated_method = "1BD2646756156A927EE1F72B9E1C572B")
    private void putAllImpl(Map<? extends K, ? extends V> map) {
        {
            boolean var6889E31DD8EB0136BAB9D60DD7EEE838_891422550 = (map.entrySet() != null);
            {
                super.putAll(map);
            } //End block
        } //End collapsed parenthetic
        addTaint(map.getTaint());
        // ---------- Original Method ----------
        //if (map.entrySet() != null) {
            //super.putAll(map);
        //}
    }

    
    private static final class Entry<K, V> extends WeakReference<K> implements Map.Entry<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.458 -0400", hash_original_field = "0800FC577294C34E0B28AD2839435945", hash_generated_field = "5ED776CD81502BA181156D7F28EBC9C8")

        int hash;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.458 -0400", hash_original_field = "771318A7D90A3F8A1D88BE5DB9CE456C", hash_generated_field = "608BD3C529DBD92C1EC1FA5648B44B23")

        boolean isNull;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.458 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08")

        V value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.458 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "5EEEE64CD04E8528349A03DB7ACC9002")

        Entry<K, V> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.459 -0400", hash_original_method = "87D1D30974ED96CB990C400F03BCFAE4", hash_generated_method = "D63C86E98CD5C46B56097DD4AA50DF6B")
          Entry(K key, V object, ReferenceQueue<K> queue) {
            super(key, queue);
            isNull = key == null;
            hash = isNull ? 0 : key.hashCode();
            value = object;
            addTaint(queue.getTaint());
            // ---------- Original Method ----------
            //isNull = key == null;
            //hash = isNull ? 0 : key.hashCode();
            //value = object;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.460 -0400", hash_original_method = "1761F5110CA075C2A7975CB6F7D505A7", hash_generated_method = "1F7063ADF11A4C72F76166A4A048FD76")
        public K getKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_551556120 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_551556120 = super.get();
            varB4EAC82CA7396A68D541C85D26508E83_551556120.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_551556120;
            // ---------- Original Method ----------
            //return super.get();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.460 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "CFBABAE7321CCD7C259117694EE5E481")
        public V getValue() {
            V varB4EAC82CA7396A68D541C85D26508E83_974795986 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_974795986 = value;
            varB4EAC82CA7396A68D541C85D26508E83_974795986.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_974795986;
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.467 -0400", hash_original_method = "123DAF07FFBE76C8EE5BD5879EB92827", hash_generated_method = "739FFB069004EFE295A93BB934F86918")
        public V setValue(V object) {
            V varB4EAC82CA7396A68D541C85D26508E83_1666847413 = null; //Variable for return #1
            V result;
            result = value;
            value = object;
            varB4EAC82CA7396A68D541C85D26508E83_1666847413 = result;
            varB4EAC82CA7396A68D541C85D26508E83_1666847413.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1666847413;
            // ---------- Original Method ----------
            //V result = value;
            //value = object;
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.468 -0400", hash_original_method = "3B6A8BF252F73FDC95A7717672A6DE75", hash_generated_method = "0B3021ADA3C5DAF219C3346FB641E5FE")
        @Override
        public boolean equals(Object other) {
            Map.Entry<?, ?> entry;
            entry = (Map.Entry<?, ?>) other;
            Object key;
            key = super.get();
            boolean var715794E66FEAD2DA8E249FD5488C80A4_507158492 = ((key == null ? key == entry.getKey() : key.equals(entry
                    .getKey()))
                    && (value == null ? value == entry.getValue() : value
                            .equals(entry.getValue()))); //DSFIXME:  CODE0008: Nested ternary operator in expression
            addTaint(other.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1319166104 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1319166104;
            // ---------- Original Method ----------
            //if (!(other instanceof Map.Entry)) {
                //return false;
            //}
            //Map.Entry<?, ?> entry = (Map.Entry<?, ?>) other;
            //Object key = super.get();
            //return (key == null ? key == entry.getKey() : key.equals(entry
                    //.getKey()))
                    //&& (value == null ? value == entry.getValue() : value
                            //.equals(entry.getValue()));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.468 -0400", hash_original_method = "D08C41096A06FEDF3165E76D8A8BDE22", hash_generated_method = "761A6A66EE613B8F6E44B54366DBBF54")
        @Override
        public int hashCode() {
            int varBFAA27FDBD65002EF874070ACA9FDE01_1442651762 = (hash + (value == null ? 0 : value.hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_77539228 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_77539228;
            // ---------- Original Method ----------
            //return hash + (value == null ? 0 : value.hashCode());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.489 -0400", hash_original_method = "1EE8DCD6F434B8EBFF147EFC16429262", hash_generated_method = "5A5C46B5935BCDBD74252704425935FC")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_2139618004 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2139618004 = super.get() + "=" + value;
            varB4EAC82CA7396A68D541C85D26508E83_2139618004.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2139618004;
            // ---------- Original Method ----------
            //return super.get() + "=" + value;
        }

        
        interface Type<R, K, V> {
            R get(Map.Entry<K, V> entry);
        }
        
    }


    
    class HashIterator<R> implements Iterator<R> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.489 -0400", hash_original_field = "64F8FBF9ECD410CCCCA37B900774D128", hash_generated_field = "6E2A691F6D792F742C26DA32023216AB")

        private int position = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.489 -0400", hash_original_field = "295CC8887E8B8B43596FF881B307867C", hash_generated_field = "9C353E755EC3A4E9B0CFE1EA9EEC47A8")

        private int expectedModCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.490 -0400", hash_original_field = "99BA38A3E6B2466208E2D2433FB7C05C", hash_generated_field = "55DBD0360631F6C09DC3C9CAFB79E913")

        private Entry<K, V> currentEntry;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.490 -0400", hash_original_field = "A456AF15DBCB1B656F162F16303E5E25", hash_generated_field = "147D6C1E63E472440226370714C1D130")

        private Entry<K, V> nextEntry;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.490 -0400", hash_original_field = "7372E4F82D6BA16EB4CD39C71388B39D", hash_generated_field = "989887495A4D0A589ACCCD9CE9664248")

        private K nextKey;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.490 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "01CE55F7E5B83A126B2D2C311EAC0383")

        Entry.Type<R, K, V> type;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.490 -0400", hash_original_method = "257D5034B04AA7E9B1AFE5220E974305", hash_generated_method = "D8DF824834C45D429AB91D50D4AD1F75")
          HashIterator(Entry.Type<R, K, V> type) {
            this.type = type;
            expectedModCount = modCount;
            // ---------- Original Method ----------
            //this.type = type;
            //expectedModCount = modCount;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.504 -0400", hash_original_method = "E96FCD52B0E07477D827A4DEB82A49B2", hash_generated_method = "DD2A36700D16C04D64A52CE4785A656A")
        public boolean hasNext() {
            {
                {
                    {
                        {
                            boolean var153DD30E336FC14C6728E2427043F36D_778237091 = ((nextEntry = elementData[position++]) != null);
                        } //End collapsed parenthetic
                    } //End block
                } //End block
                nextKey = nextEntry.get();
                nextEntry = nextEntry.next;
            } //End block
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_352966897 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_352966897;
            // ---------- Original Method ----------
            //if (nextEntry != null && (nextKey != null || nextEntry.isNull)) {
                //return true;
            //}
            //while (true) {
                //if (nextEntry == null) {
                    //while (position < elementData.length) {
                        //if ((nextEntry = elementData[position++]) != null) {
                            //break;
                        //}
                    //}
                    //if (nextEntry == null) {
                        //return false;
                    //}
                //}
                //nextKey = nextEntry.get();
                //if (nextKey != null || nextEntry.isNull) {
                    //return true;
                //}
                //nextEntry = nextEntry.next;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.505 -0400", hash_original_method = "F6AE8405A941E9948A6F966D8D2D9924", hash_generated_method = "76B3D61FC7D940BB3DC8B947D6A4E053")
        public R next() {
            R varB4EAC82CA7396A68D541C85D26508E83_2067794728 = null; //Variable for return #1
            {
                {
                    boolean var384B0C75E2EB52B4939B27A6F15C2DC1_1157534648 = (hasNext());
                    {
                        currentEntry = nextEntry;
                        nextEntry = currentEntry.next;
                        R result;
                        result = type.get(currentEntry);
                        nextKey = null;
                        varB4EAC82CA7396A68D541C85D26508E83_2067794728 = result;
                    } //End block
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            varB4EAC82CA7396A68D541C85D26508E83_2067794728.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2067794728;
            // ---------- Original Method ----------
            //if (expectedModCount == modCount) {
                //if (hasNext()) {
                    //currentEntry = nextEntry;
                    //nextEntry = currentEntry.next;
                    //R result = type.get(currentEntry);
                    //nextKey = null;
                    //return result;
                //}
                //throw new NoSuchElementException();
            //}
            //throw new ConcurrentModificationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.505 -0400", hash_original_method = "9519576E1338F396C5D4D192735A75A5", hash_generated_method = "5066B19DB201DA1D54AA398F0E48104A")
        public void remove() {
            {
                {
                    removeEntry(currentEntry);
                    currentEntry = null;
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
                } //End block
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            } //End block
            // ---------- Original Method ----------
            //if (expectedModCount == modCount) {
                //if (currentEntry != null) {
                    //removeEntry(currentEntry);
                    //currentEntry = null;
                    //expectedModCount++;
                //} else {
                    //throw new IllegalStateException();
                //}
            //} else {
                //throw new ConcurrentModificationException();
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.505 -0400", hash_original_field = "FE4F786FCADAEA637D52490E93F954CD", hash_generated_field = "72846C7556CD7ED91501BB9913770F05")

    private static int DEFAULT_SIZE = 16;
}

