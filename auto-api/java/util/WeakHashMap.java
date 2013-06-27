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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.155 -0400", hash_original_field = "4B551E83AB7D0C8C6FE6D2A3C3F57121", hash_generated_field = "DA4F581341DFFC093DAB2ED377CF1682")

    private ReferenceQueue<K> referenceQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.155 -0400", hash_original_field = "BC8C6DCF12CE09E50A98BB57ADFCADD9", hash_generated_field = "BF84735BCD9327FC2D1CC927ED35945D")

    int elementCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.155 -0400", hash_original_field = "8D395F1876FF8AE01BE52A9C4C2ED552", hash_generated_field = "36C14C81A5F4E64B5630EF2ADDAD7469")

    Entry<K, V>[] elementData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.155 -0400", hash_original_field = "97C293EF8ABD832D29E88C21D8E562F5", hash_generated_field = "9875194AD635CA8D9949128549486276")

    private int loadFactor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.155 -0400", hash_original_field = "F0598264A691A8F62272ACA0E79AF374", hash_generated_field = "831F8FC1A32CF07BE696149BB6AEA9AA")

    private int threshold;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.155 -0400", hash_original_field = "675B3022548A1029F9CE7A2C25B23BBF", hash_generated_field = "7980638400FDA73EFCEF2F9901C03D43")

    volatile int modCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.156 -0400", hash_original_method = "B976885DE3CF2C49EC1331AC2786A4B5", hash_generated_method = "947788F1D50A3898B6C48AAEC3B777CB")
    public  WeakHashMap() {
        this(DEFAULT_SIZE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.157 -0400", hash_original_method = "76AE00E803F5BFDB4BDF43DC151D88D7", hash_generated_method = "1F46AD3FB0C8AC5CD200FF0E82EB40B0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.161 -0400", hash_original_method = "342F9B7CF63C1134C14E3979782FA4FA", hash_generated_method = "1C3CBF911307A65894F38766BB286C28")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.161 -0400", hash_original_method = "4D7BC16BC60EE786903D624E86CA0AFB", hash_generated_method = "36288AB5B6E2AC0F27A53BFAB0B193EA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.161 -0400", hash_original_method = "C690E441FDF499DD7829AA3D638ADE28", hash_generated_method = "DD2D5651903E599EF511F5B34FFD97FB")
    @Override
    public void clear() {
        {
            elementCount = 0;
            Arrays.fill(elementData, null);
            {
                boolean varFA1D4F81EDB4C923F843813B6540E0FE_779652362 = (referenceQueue.poll() != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.169 -0400", hash_original_method = "85D93BA99AF40F5CDC3F42570A89C9FC", hash_generated_method = "BE619D13CAF85822181B65989DC845A9")
    private void computeMaxSize() {
        threshold = (int) ((long) elementData.length * loadFactor / 10000);
        // ---------- Original Method ----------
        //threshold = (int) ((long) elementData.length * loadFactor / 10000);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.169 -0400", hash_original_method = "7C0BA359573790AC71E46CA35F3B3C5D", hash_generated_method = "FF8F62274EE031F437E05C63B6793606")
    @Override
    public boolean containsKey(Object key) {
        boolean var80C6FDED6A61C62705DB13137566169D_1788816284 = (getEntry(key) != null);
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_808292083 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_808292083;
        // ---------- Original Method ----------
        //return getEntry(key) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.174 -0400", hash_original_method = "115108C1B40A91216FE420487FA7990C", hash_generated_method = "68DD411E3A67DF752BDC23B131AD7AF9")
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> varB4EAC82CA7396A68D541C85D26508E83_901146861 = null; //Variable for return #1
        poll();
        varB4EAC82CA7396A68D541C85D26508E83_901146861 = new AbstractSet<Map.Entry<K, V>>() {
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
        varB4EAC82CA7396A68D541C85D26508E83_901146861.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_901146861;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.214 -0400", hash_original_method = "058A25F673776D4338089073DA213D4E", hash_generated_method = "D1ED54156C611C90F025A0DFCB87B422")
    @Override
    public Set<K> keySet() {
        Set<K> varB4EAC82CA7396A68D541C85D26508E83_545979455 = null; //Variable for return #1
        poll();
        {
            keySet = new AbstractSet<K>() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.176 -0400", hash_original_method = "D170B4D54B17306878DDF90A529C04ED", hash_generated_method = "CCFE92F8C88737172C1DE4C0E98F2099")
                @Override
                public boolean contains(Object object) {
                    boolean var5CF08BC5A8889C1E8B40FF0332AFAC24_1348874131 = (containsKey(object));
                    addTaint(object.getTaint());
                    boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1993839529 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1993839529;
                    // ---------- Original Method ----------
                    //return containsKey(object);
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.188 -0400", hash_original_method = "997773928D6A4FA2A905BEE282A68997", hash_generated_method = "2EDA72F03F17666F4A244A7EBA5F0298")
                @Override
                public int size() {
                    int varEB466AC21988954CC038D6EAFB4E7FEA_234248620 = (WeakHashMap.this.size());
                    int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1682885160 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1682885160;
                    // ---------- Original Method ----------
                    //return WeakHashMap.this.size();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.188 -0400", hash_original_method = "0820DD19F55EBD9E05BEDEF72AA76B85", hash_generated_method = "216199AA5B7C7589486AA111C1364167")
                @Override
                public void clear() {
                    WeakHashMap.this.clear();
                    // ---------- Original Method ----------
                    //WeakHashMap.this.clear();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.189 -0400", hash_original_method = "2EBC57A89CF751265ACE297F532371F8", hash_generated_method = "759C5E1F5323B72127596B0EED677123")
                @Override
                public boolean remove(Object key) {
                    {
                        boolean varD4D10245FFFD9692A4F42EDF884E815E_484786402 = (containsKey(key));
                        {
                            WeakHashMap.this.remove(key);
                        } //End block
                    } //End collapsed parenthetic
                    addTaint(key.getTaint());
                    boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_261501225 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_261501225;
                    // ---------- Original Method ----------
                    //if (containsKey(key)) {
                        //WeakHashMap.this.remove(key);
                        //return true;
                    //}
                    //return false;
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.193 -0400", hash_original_method = "AE3D91420CF50F34AE4E77081237432D", hash_generated_method = "F88FB63A22E72D4D182867BEC01C6ADD")
                @Override
                public Iterator<K> iterator() {
                    Iterator<K> varB4EAC82CA7396A68D541C85D26508E83_688785113 = null; //Variable for return #1
                    varB4EAC82CA7396A68D541C85D26508E83_688785113 = new HashIterator<K>(new Entry.Type<K, K, V>() {
                        public K get(Map.Entry<K, V> entry) {
                            return entry.getKey();
                        }
                    });
                    varB4EAC82CA7396A68D541C85D26508E83_688785113.addTaint(getTaint()); //Add taint from parent
                    return varB4EAC82CA7396A68D541C85D26508E83_688785113;
                    // ---------- Original Method ----------
                    //return new HashIterator<K>(new Entry.Type<K, K, V>() {
                        //public K get(Map.Entry<K, V> entry) {
                            //return entry.getKey();
                        //}
                    //});
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.206 -0400", hash_original_method = "8D1ED5FEE11EEA3682A2E2ECF5DE32C3", hash_generated_method = "9C189FC4FC3817F708C598BA09558A5D")
                @Override
                public Object[] toArray() {
                    Object[] varB4EAC82CA7396A68D541C85D26508E83_863953834 = null; //Variable for return #1
                    Collection<K> coll;
                    coll = new ArrayList<K>(size());
                    {
                        Iterator<K> iter;
                        iter = iterator();
                        boolean var0719F6DF13666099B3F99B9DD393E1F6_282515542 = (iter.hasNext());
                        {
                            coll.add(iter.next());
                        } //End block
                    } //End collapsed parenthetic
                    varB4EAC82CA7396A68D541C85D26508E83_863953834 = coll.toArray();
                    varB4EAC82CA7396A68D541C85D26508E83_863953834.addTaint(getTaint()); //Add taint from parent
                    return varB4EAC82CA7396A68D541C85D26508E83_863953834;
                    // ---------- Original Method ----------
                    //Collection<K> coll = new ArrayList<K>(size());
                    //for (Iterator<K> iter = iterator(); iter.hasNext();) {
                        //coll.add(iter.next());
                    //}
                    //return coll.toArray();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.207 -0400", hash_original_method = "50B72C5F86BB9252B582673D59AA848C", hash_generated_method = "0EA9087BFCB4690014FC1DB47BE41EE3")
                @Override
                public <T> T[] toArray(T[] contents) {
                    T[] varB4EAC82CA7396A68D541C85D26508E83_1982735455 = null; //Variable for return #1
                    Collection<K> coll;
                    coll = new ArrayList<K>(size());
                    {
                        Iterator<K> iter;
                        iter = iterator();
                        boolean var0719F6DF13666099B3F99B9DD393E1F6_130916217 = (iter.hasNext());
                        {
                            coll.add(iter.next());
                        } //End block
                    } //End collapsed parenthetic
                    varB4EAC82CA7396A68D541C85D26508E83_1982735455 = coll.toArray(contents);
                    addTaint(contents[0].getTaint());
                    varB4EAC82CA7396A68D541C85D26508E83_1982735455.addTaint(getTaint()); //Add taint from parent
                    return varB4EAC82CA7396A68D541C85D26508E83_1982735455;
                    // ---------- Original Method ----------
                    //Collection<K> coll = new ArrayList<K>(size());
                    //for (Iterator<K> iter = iterator(); iter.hasNext();) {
                        //coll.add(iter.next());
                    //}
                    //return coll.toArray(contents);
                }
};
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_545979455 = keySet;
        varB4EAC82CA7396A68D541C85D26508E83_545979455.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_545979455;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.230 -0400", hash_original_method = "1BF87F9B8C3D58711D484B01D41C9F2F", hash_generated_method = "F22050455312278D0C61E700ADCA3ED1")
    @Override
    public Collection<V> values() {
        Collection<V> varB4EAC82CA7396A68D541C85D26508E83_2098862304 = null; //Variable for return #1
        poll();
        {
            valuesCollection = new AbstractCollection<V>() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.216 -0400", hash_original_method = "997773928D6A4FA2A905BEE282A68997", hash_generated_method = "02AC8C5E36CDBB34B536A30EB002391B")
                @Override
                public int size() {
                    int varEB466AC21988954CC038D6EAFB4E7FEA_1631765068 = (WeakHashMap.this.size());
                    int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_156797329 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_156797329;
                    // ---------- Original Method ----------
                    //return WeakHashMap.this.size();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.216 -0400", hash_original_method = "0820DD19F55EBD9E05BEDEF72AA76B85", hash_generated_method = "216199AA5B7C7589486AA111C1364167")
                @Override
                public void clear() {
                    WeakHashMap.this.clear();
                    // ---------- Original Method ----------
                    //WeakHashMap.this.clear();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.216 -0400", hash_original_method = "7679F4183F803D10EFCD1172E399C7C3", hash_generated_method = "A4A05511D64A473B21FB772CA8EAC531")
                @Override
                public boolean contains(Object object) {
                    boolean varF0370008E8B5928F4FAF5BBF8632C1B3_315569343 = (containsValue(object));
                    addTaint(object.getTaint());
                    boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1620141917 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1620141917;
                    // ---------- Original Method ----------
                    //return containsValue(object);
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.220 -0400", hash_original_method = "D1021921C3018EF53317EBCD6C577AB9", hash_generated_method = "BB272DE78CD99D640BB3C1A17AE214DD")
                @Override
                public Iterator<V> iterator() {
                    Iterator<V> varB4EAC82CA7396A68D541C85D26508E83_639518243 = null; //Variable for return #1
                    varB4EAC82CA7396A68D541C85D26508E83_639518243 = new HashIterator<V>(new Entry.Type<V, K, V>() {
                        public V get(Map.Entry<K, V> entry) {
                            return entry.getValue();
                        }
                    });
                    varB4EAC82CA7396A68D541C85D26508E83_639518243.addTaint(getTaint()); //Add taint from parent
                    return varB4EAC82CA7396A68D541C85D26508E83_639518243;
                    // ---------- Original Method ----------
                    //return new HashIterator<V>(new Entry.Type<V, K, V>() {
                        //public V get(Map.Entry<K, V> entry) {
                            //return entry.getValue();
                        //}
                    //});
                }
};
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2098862304 = valuesCollection;
        varB4EAC82CA7396A68D541C85D26508E83_2098862304.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2098862304;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.231 -0400", hash_original_method = "7498B4140ED8DA87371F31164D271C1D", hash_generated_method = "414D039B0CF6B5ACC32C71D6742DF372")
    @Override
    public V get(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_1336553435 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_100915142 = null; //Variable for return #2
        V varB4EAC82CA7396A68D541C85D26508E83_1568858815 = null; //Variable for return #3
        V varB4EAC82CA7396A68D541C85D26508E83_841572338 = null; //Variable for return #4
        poll();
        {
            int index;
            index = (key.hashCode() & 0x7FFFFFFF) % elementData.length;
            Entry<K, V> entry;
            entry = elementData[index];
            {
                {
                    boolean var34A40B722D871D6DB92AB2E02C0D49BB_570391222 = (key.equals(entry.get()));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1336553435 = entry.value;
                    } //End block
                } //End collapsed parenthetic
                entry = entry.next;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_100915142 = null;
        } //End block
        Entry<K, V> entry;
        entry = elementData[0];
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1568858815 = entry.value;
            } //End block
            entry = entry.next;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_841572338 = null;
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_976370307; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_976370307 = varB4EAC82CA7396A68D541C85D26508E83_1336553435;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_976370307 = varB4EAC82CA7396A68D541C85D26508E83_100915142;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_976370307 = varB4EAC82CA7396A68D541C85D26508E83_1568858815;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_976370307 = varB4EAC82CA7396A68D541C85D26508E83_841572338;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_976370307.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_976370307;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.232 -0400", hash_original_method = "545F7F0FB84E7EA33FCF99594092AF0D", hash_generated_method = "96DA9838A52DF0AEC96CE16E36E60595")
     Entry<K, V> getEntry(Object key) {
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_1052090622 = null; //Variable for return #1
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_201623217 = null; //Variable for return #2
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_379226858 = null; //Variable for return #3
        Entry<K, V> varB4EAC82CA7396A68D541C85D26508E83_692338388 = null; //Variable for return #4
        poll();
        {
            int index;
            index = (key.hashCode() & 0x7FFFFFFF) % elementData.length;
            Entry<K, V> entry;
            entry = elementData[index];
            {
                {
                    boolean var34A40B722D871D6DB92AB2E02C0D49BB_2033019368 = (key.equals(entry.get()));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1052090622 = entry;
                    } //End block
                } //End collapsed parenthetic
                entry = entry.next;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_201623217 = null;
        } //End block
        Entry<K, V> entry;
        entry = elementData[0];
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_379226858 = entry;
            } //End block
            entry = entry.next;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_692338388 = null;
        addTaint(key.getTaint());
        Entry<K, V> varA7E53CE21691AB073D9660D615818899_1565662327; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1565662327 = varB4EAC82CA7396A68D541C85D26508E83_1052090622;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1565662327 = varB4EAC82CA7396A68D541C85D26508E83_201623217;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1565662327 = varB4EAC82CA7396A68D541C85D26508E83_379226858;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1565662327 = varB4EAC82CA7396A68D541C85D26508E83_692338388;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1565662327.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1565662327;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.245 -0400", hash_original_method = "EBDA4BA5DE93153797BA511A1B84894F", hash_generated_method = "A53A50CAA4064C0D3C203898043D6932")
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
                            boolean var18A512D740DE406E77259979D1000436_1314452858 = ((key != null || entry.isNull)
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_123489797 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_123489797;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.246 -0400", hash_original_method = "296240B68F4A866C698190CF33710ED8", hash_generated_method = "98B3C3592B21392E1F57517323BCF984")
    @Override
    public boolean isEmpty() {
        boolean var5E7C4FBBEC9A5754B20CB85881048CD5_1414105730 = (size() == 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2120901932 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2120901932;
        // ---------- Original Method ----------
        //return size() == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.246 -0400", hash_original_method = "0A4BB2570FECEAC055174AF0C493CF3C", hash_generated_method = "9A6B6E5BF4353963461977D05928970E")
    @SuppressWarnings("unchecked")
     void poll() {
        Entry<K, V> toRemove;
        {
            boolean varAF179C89B87910BBBA6E45758D4FD0E7_1439711632 = ((toRemove = (Entry<K, V>) referenceQueue.poll()) != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.247 -0400", hash_original_method = "950CA8B0FD25845E584DCFB2BE4D9F32", hash_generated_method = "3B745E43F6B3500A6A4960C2C0C2895B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.248 -0400", hash_original_method = "E298E65486168CC370356B38BEF7AC1C", hash_generated_method = "1290325662941B987C0F75A6D42BEFA8")
    @Override
    public V put(K key, V value) {
        V varB4EAC82CA7396A68D541C85D26508E83_1359085092 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_1279900294 = null; //Variable for return #2
        poll();
        int index;
        index = 0;
        Entry<K, V> entry;
        {
            index = (key.hashCode() & 0x7FFFFFFF) % elementData.length;
            entry = elementData[index];
            {
                boolean var11C456750D82E660592E03F3DAA89A38_823192929 = (entry != null && !key.equals(entry.get()));
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
            varB4EAC82CA7396A68D541C85D26508E83_1359085092 = null;
        } //End block
        V result;
        result = entry.value;
        entry.value = value;
        varB4EAC82CA7396A68D541C85D26508E83_1279900294 = result;
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        V varA7E53CE21691AB073D9660D615818899_881352330; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_881352330 = varB4EAC82CA7396A68D541C85D26508E83_1359085092;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_881352330 = varB4EAC82CA7396A68D541C85D26508E83_1279900294;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_881352330.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_881352330;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.352 -0400", hash_original_method = "2B64F6E6AE3910B09507F9013DEACFFD", hash_generated_method = "B8C09FECA25AEF91449F210547B15507")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.353 -0400", hash_original_method = "57B3987EA7E50826E0AAD0198F968E42", hash_generated_method = "43FD7CC93F90FFCD58209DA7AC6028FD")
    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        putAllImpl(map);
        addTaint(map.getTaint());
        // ---------- Original Method ----------
        //putAllImpl(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.354 -0400", hash_original_method = "FE1A1739C961B2012661CB8735C428AE", hash_generated_method = "2C39DBBFAEB4E07CC9C7ABCBE1EB190B")
    @Override
    public V remove(Object key) {
        V varB4EAC82CA7396A68D541C85D26508E83_1535118206 = null; //Variable for return #1
        V varB4EAC82CA7396A68D541C85D26508E83_1148203674 = null; //Variable for return #2
        poll();
        int index;
        index = 0;
        Entry<K, V> entry, last;
        last = null;
        {
            index = (key.hashCode() & 0x7FFFFFFF) % elementData.length;
            entry = elementData[index];
            {
                boolean var11C456750D82E660592E03F3DAA89A38_1400040658 = (entry != null && !key.equals(entry.get()));
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
            varB4EAC82CA7396A68D541C85D26508E83_1535118206 = entry.value;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1148203674 = null;
        addTaint(key.getTaint());
        V varA7E53CE21691AB073D9660D615818899_1295293496; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1295293496 = varB4EAC82CA7396A68D541C85D26508E83_1535118206;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1295293496 = varB4EAC82CA7396A68D541C85D26508E83_1148203674;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1295293496.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1295293496;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.354 -0400", hash_original_method = "B65BB7405B9BD112F0A817BA32556A99", hash_generated_method = "2D261C77C03D460A0B543FBC1E3B304A")
    @Override
    public int size() {
        poll();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_62838082 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_62838082;
        // ---------- Original Method ----------
        //poll();
        //return elementCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.355 -0400", hash_original_method = "F23833AECC848C129604A1D671C10BB2", hash_generated_method = "385BDC2D2E31CFF44C56549521967276")
    private void putAllImpl(Map<? extends K, ? extends V> map) {
        {
            boolean var6889E31DD8EB0136BAB9D60DD7EEE838_29270060 = (map.entrySet() != null);
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.355 -0400", hash_original_field = "0800FC577294C34E0B28AD2839435945", hash_generated_field = "5ED776CD81502BA181156D7F28EBC9C8")

        int hash;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.355 -0400", hash_original_field = "771318A7D90A3F8A1D88BE5DB9CE456C", hash_generated_field = "608BD3C529DBD92C1EC1FA5648B44B23")

        boolean isNull;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.355 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08")

        V value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.355 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "5EEEE64CD04E8528349A03DB7ACC9002")

        Entry<K, V> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.355 -0400", hash_original_method = "87D1D30974ED96CB990C400F03BCFAE4", hash_generated_method = "D63C86E98CD5C46B56097DD4AA50DF6B")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.356 -0400", hash_original_method = "1761F5110CA075C2A7975CB6F7D505A7", hash_generated_method = "8BF99C6022F8F181EDA136B6263A13D6")
        public K getKey() {
            K varB4EAC82CA7396A68D541C85D26508E83_1340391629 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1340391629 = super.get();
            varB4EAC82CA7396A68D541C85D26508E83_1340391629.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1340391629;
            // ---------- Original Method ----------
            //return super.get();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.356 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "C6FB9E76C578CD33C59CCD65FE430F43")
        public V getValue() {
            V varB4EAC82CA7396A68D541C85D26508E83_1412253515 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1412253515 = value;
            varB4EAC82CA7396A68D541C85D26508E83_1412253515.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1412253515;
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.370 -0400", hash_original_method = "123DAF07FFBE76C8EE5BD5879EB92827", hash_generated_method = "FD64B0C1525D2BEF9B4DC462FD748609")
        public V setValue(V object) {
            V varB4EAC82CA7396A68D541C85D26508E83_1281871647 = null; //Variable for return #1
            V result;
            result = value;
            value = object;
            varB4EAC82CA7396A68D541C85D26508E83_1281871647 = result;
            varB4EAC82CA7396A68D541C85D26508E83_1281871647.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1281871647;
            // ---------- Original Method ----------
            //V result = value;
            //value = object;
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.371 -0400", hash_original_method = "3B6A8BF252F73FDC95A7717672A6DE75", hash_generated_method = "84356FC8DB3B44E56287CA000F8321F5")
        @Override
        public boolean equals(Object other) {
            Map.Entry<?, ?> entry;
            entry = (Map.Entry<?, ?>) other;
            Object key;
            key = super.get();
            boolean var715794E66FEAD2DA8E249FD5488C80A4_258974628 = ((key == null ? key == entry.getKey() : key.equals(entry
                    .getKey()))
                    && (value == null ? value == entry.getValue() : value
                            .equals(entry.getValue()))); //DSFIXME:  CODE0008: Nested ternary operator in expression
            addTaint(other.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_640502538 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_640502538;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.386 -0400", hash_original_method = "D08C41096A06FEDF3165E76D8A8BDE22", hash_generated_method = "887A9712AECF088FC5D1BAB329706F11")
        @Override
        public int hashCode() {
            int varBFAA27FDBD65002EF874070ACA9FDE01_494272217 = (hash + (value == null ? 0 : value.hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1460156733 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1460156733;
            // ---------- Original Method ----------
            //return hash + (value == null ? 0 : value.hashCode());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.386 -0400", hash_original_method = "1EE8DCD6F434B8EBFF147EFC16429262", hash_generated_method = "B2DAE5727C2E87E394951E5D442D5B09")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1194625798 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1194625798 = super.get() + "=" + value;
            varB4EAC82CA7396A68D541C85D26508E83_1194625798.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1194625798;
            // ---------- Original Method ----------
            //return super.get() + "=" + value;
        }

        
        interface Type<R, K, V> {
            R get(Map.Entry<K, V> entry);
        }
        
    }


    
    class HashIterator<R> implements Iterator<R> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.386 -0400", hash_original_field = "64F8FBF9ECD410CCCCA37B900774D128", hash_generated_field = "6E2A691F6D792F742C26DA32023216AB")

        private int position = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.386 -0400", hash_original_field = "295CC8887E8B8B43596FF881B307867C", hash_generated_field = "9C353E755EC3A4E9B0CFE1EA9EEC47A8")

        private int expectedModCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.386 -0400", hash_original_field = "99BA38A3E6B2466208E2D2433FB7C05C", hash_generated_field = "55DBD0360631F6C09DC3C9CAFB79E913")

        private Entry<K, V> currentEntry;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.386 -0400", hash_original_field = "A456AF15DBCB1B656F162F16303E5E25", hash_generated_field = "147D6C1E63E472440226370714C1D130")

        private Entry<K, V> nextEntry;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.386 -0400", hash_original_field = "7372E4F82D6BA16EB4CD39C71388B39D", hash_generated_field = "989887495A4D0A589ACCCD9CE9664248")

        private K nextKey;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.386 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "01CE55F7E5B83A126B2D2C311EAC0383")

        Entry.Type<R, K, V> type;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.387 -0400", hash_original_method = "257D5034B04AA7E9B1AFE5220E974305", hash_generated_method = "D8DF824834C45D429AB91D50D4AD1F75")
          HashIterator(Entry.Type<R, K, V> type) {
            this.type = type;
            expectedModCount = modCount;
            // ---------- Original Method ----------
            //this.type = type;
            //expectedModCount = modCount;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.387 -0400", hash_original_method = "E96FCD52B0E07477D827A4DEB82A49B2", hash_generated_method = "8398A188F9C9CD1F097CD33633F24831")
        public boolean hasNext() {
            {
                {
                    {
                        {
                            boolean var153DD30E336FC14C6728E2427043F36D_2139383172 = ((nextEntry = elementData[position++]) != null);
                        } //End collapsed parenthetic
                    } //End block
                } //End block
                nextKey = nextEntry.get();
                nextEntry = nextEntry.next;
            } //End block
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_240214159 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_240214159;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.406 -0400", hash_original_method = "F6AE8405A941E9948A6F966D8D2D9924", hash_generated_method = "A22236D4453473377E8C79A1C500C632")
        public R next() {
            R varB4EAC82CA7396A68D541C85D26508E83_1601669790 = null; //Variable for return #1
            {
                {
                    boolean var384B0C75E2EB52B4939B27A6F15C2DC1_1215864039 = (hasNext());
                    {
                        currentEntry = nextEntry;
                        nextEntry = currentEntry.next;
                        R result;
                        result = type.get(currentEntry);
                        nextKey = null;
                        varB4EAC82CA7396A68D541C85D26508E83_1601669790 = result;
                    } //End block
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            varB4EAC82CA7396A68D541C85D26508E83_1601669790.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1601669790;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.406 -0400", hash_original_method = "9519576E1338F396C5D4D192735A75A5", hash_generated_method = "5066B19DB201DA1D54AA398F0E48104A")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.407 -0400", hash_original_field = "FE4F786FCADAEA637D52490E93F954CD", hash_generated_field = "72846C7556CD7ED91501BB9913770F05")

    private static int DEFAULT_SIZE = 16;
}

