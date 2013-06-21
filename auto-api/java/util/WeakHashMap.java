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
    private ReferenceQueue<K> referenceQueue;
    int elementCount;
    Entry<K, V>[] elementData;
    private int loadFactor;
    private int threshold;
    volatile int modCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.239 -0400", hash_original_method = "B976885DE3CF2C49EC1331AC2786A4B5", hash_generated_method = "947788F1D50A3898B6C48AAEC3B777CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WeakHashMap() {
        this(DEFAULT_SIZE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.240 -0400", hash_original_method = "76AE00E803F5BFDB4BDF43DC151D88D7", hash_generated_method = "E3EDDCDA0041BD02C5BADC8FA5D861EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WeakHashMap(int capacity) {
        dsTaint.addTaint(capacity);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.240 -0400", hash_original_method = "342F9B7CF63C1134C14E3979782FA4FA", hash_generated_method = "067F280EC2E196E968A3DA29434D2E93")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WeakHashMap(int capacity, float loadFactor) {
        dsTaint.addTaint(capacity);
        dsTaint.addTaint(loadFactor);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.240 -0400", hash_original_method = "4D7BC16BC60EE786903D624E86CA0AFB", hash_generated_method = "F967430E42DA303B01EBECBC96A4A6A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WeakHashMap(Map<? extends K, ? extends V> map) {
        this(map.size() < 6 ? 11 : map.size() * 2);
        dsTaint.addTaint(map.dsTaint);
        putAllImpl(map);
        // ---------- Original Method ----------
        //putAllImpl(map);
    }

    
        @SuppressWarnings("unchecked")
    private static <K, V> Entry<K, V>[] newEntryArray(int size) {
        return new Entry[size];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.241 -0400", hash_original_method = "C690E441FDF499DD7829AA3D638ADE28", hash_generated_method = "78D050F7BF8BD2FFA96B625A5D518199")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void clear() {
        {
            elementCount = 0;
            Arrays.fill(elementData, null);
            {
                boolean varFA1D4F81EDB4C923F843813B6540E0FE_36015428 = (referenceQueue.poll() != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.241 -0400", hash_original_method = "85D93BA99AF40F5CDC3F42570A89C9FC", hash_generated_method = "BE619D13CAF85822181B65989DC845A9")
    @DSModeled(DSC.SAFE)
    private void computeMaxSize() {
        threshold = (int) ((long) elementData.length * loadFactor / 10000);
        // ---------- Original Method ----------
        //threshold = (int) ((long) elementData.length * loadFactor / 10000);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.241 -0400", hash_original_method = "7C0BA359573790AC71E46CA35F3B3C5D", hash_generated_method = "99AB29D90855F37218C7F30D9832B124")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean containsKey(Object key) {
        dsTaint.addTaint(key.dsTaint);
        boolean var80C6FDED6A61C62705DB13137566169D_151009381 = (getEntry(key) != null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getEntry(key) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.243 -0400", hash_original_method = "115108C1B40A91216FE420487FA7990C", hash_generated_method = "D1B1DE065C39DAADAFA8E7A01E95F6E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        poll();
        Set<Map.Entry<K, V>> varAED2DAE788C49AAE35D81771D55B9D04_193203062 = (new AbstractSet<Map.Entry<K, V>>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.241 -0400", hash_original_method = "997773928D6A4FA2A905BEE282A68997", hash_generated_method = "5BA6B916FEC9D8A15F583C7443E2D4A6")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public int size() {
                int var5CFF7CB5E9BDFB9867CE012BDB26CB9A_1148425773 = (WeakHashMap.this.size());
                return dsTaint.getTaintInt();
                // ---------- Original Method ----------
                //return WeakHashMap.this.size();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.242 -0400", hash_original_method = "0820DD19F55EBD9E05BEDEF72AA76B85", hash_generated_method = "216199AA5B7C7589486AA111C1364167")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void clear() {
                WeakHashMap.this.clear();
                // ---------- Original Method ----------
                //WeakHashMap.this.clear();
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.242 -0400", hash_original_method = "1E7F94AC13E80E407E04FDAF276E4CCB", hash_generated_method = "B67B8BC1191B9BC1EBEBEEF6E58E0803")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean remove(Object object) {
                dsTaint.addTaint(object.dsTaint);
                {
                    boolean var7271881669A7DBC6C26047FB39DAEDC5_1234242074 = (contains(object));
                    {
                        WeakHashMap.this
                            .remove(((Map.Entry<?, ?>) object).getKey());
                    } //End block
                } //End collapsed parenthetic
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //if (contains(object)) {
                    //WeakHashMap.this
                            //.remove(((Map.Entry<?, ?>) object).getKey());
                    //return true;
                //}
                //return false;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.242 -0400", hash_original_method = "A69D5126071923809AD406525E677E9C", hash_generated_method = "27B4B6BCB8151B3C2370832FF0A54CA7")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public boolean contains(Object object) {
                dsTaint.addTaint(object.dsTaint);
                {
                    Entry<?, ?> entry;
                    entry = getEntry(((Map.Entry<?, ?>) object)
                            .getKey());
                    {
                        Object key;
                        key = entry.get();
                        {
                            boolean varDFCC21543693156BEA002A7DB5891817_509547831 = (object.equals(entry));
                        } //End block
                    } //End block
                } //End block
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //if (object instanceof Map.Entry) {
                    //Entry<?, ?> entry = getEntry(((Map.Entry<?, ?>) object)
                            //.getKey());
                    //if (entry != null) {
                        //Object key = entry.get();
                        //if (key != null || entry.isNull) {
                            //return object.equals(entry);
                        //}
                    //}
                //}
                //return false;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.242 -0400", hash_original_method = "6126AC883C019C19A724D0EDFC9A192D", hash_generated_method = "692FD47F61C92A629A53C0FAB4C6EA99")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public Iterator<Map.Entry<K, V>> iterator() {
                Iterator<Map.Entry<K, V>> var3148EEB9617485F8FAD0E118A9D112B0_1372432204 = (new HashIterator<Map.Entry<K, V>>(
                        new Entry.Type<Map.Entry<K, V>, K, V>() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.242 -0400", hash_original_method = "90738D101B25945A174A5A8A030091D2", hash_generated_method = "CCE011B3C70E232D7496A8D6E61A151C")
                    @DSModeled(DSC.SAFE)
                    public Map.Entry<K, V> get(Map.Entry<K, V> entry) {
                        dsTaint.addTaint(entry.dsTaint);
                        return (Map.Entry<K, V>)dsTaint.getTaint();
                        // ---------- Original Method ----------
                        //return entry;
                    }
}));
                return (Iterator<Map.Entry<K, V>>)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new HashIterator<Map.Entry<K, V>>(
                        //new Entry.Type<Map.Entry<K, V>, K, V>() {
                            //public Map.Entry<K, V> get(Map.Entry<K, V> entry) {
                                //return entry;
                            //}
                        //});
            }
});
        return (Set<Map.Entry<K, V>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.245 -0400", hash_original_method = "058A25F673776D4338089073DA213D4E", hash_generated_method = "9A8819FE136089B154C5C4970CD13326")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Set<K> keySet() {
        poll();
        {
            keySet = new AbstractSet<K>() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.244 -0400", hash_original_method = "D170B4D54B17306878DDF90A529C04ED", hash_generated_method = "13D975D33E5D0B187BC2F8ECAFD5FEBD")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public boolean contains(Object object) {
                    dsTaint.addTaint(object.dsTaint);
                    boolean var5CF08BC5A8889C1E8B40FF0332AFAC24_138295180 = (containsKey(object));
                    return dsTaint.getTaintBoolean();
                    // ---------- Original Method ----------
                    //return containsKey(object);
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.244 -0400", hash_original_method = "997773928D6A4FA2A905BEE282A68997", hash_generated_method = "6B6B1D1E97E9454CA0E7BBEF61F389F3")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public int size() {
                    int varEB466AC21988954CC038D6EAFB4E7FEA_215532551 = (WeakHashMap.this.size());
                    return dsTaint.getTaintInt();
                    // ---------- Original Method ----------
                    //return WeakHashMap.this.size();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.244 -0400", hash_original_method = "0820DD19F55EBD9E05BEDEF72AA76B85", hash_generated_method = "216199AA5B7C7589486AA111C1364167")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public void clear() {
                    WeakHashMap.this.clear();
                    // ---------- Original Method ----------
                    //WeakHashMap.this.clear();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.244 -0400", hash_original_method = "2EBC57A89CF751265ACE297F532371F8", hash_generated_method = "62420874073D0089BB77DCAB1FCB93C3")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public boolean remove(Object key) {
                    dsTaint.addTaint(key.dsTaint);
                    {
                        boolean varD4D10245FFFD9692A4F42EDF884E815E_1185754484 = (containsKey(key));
                        {
                            WeakHashMap.this.remove(key);
                        } //End block
                    } //End collapsed parenthetic
                    return dsTaint.getTaintBoolean();
                    // ---------- Original Method ----------
                    //if (containsKey(key)) {
                        //WeakHashMap.this.remove(key);
                        //return true;
                    //}
                    //return false;
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.245 -0400", hash_original_method = "AE3D91420CF50F34AE4E77081237432D", hash_generated_method = "EF45B229B82BE6A751CF7157C596A879")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public Iterator<K> iterator() {
                    Iterator<K> var81C2BDBD57DCAF967EA5ACC39B1A9543_1687443710 = (new HashIterator<K>(new Entry.Type<K, K, V>() {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.245 -0400", hash_original_method = "90FB27292ACE8EC15DDC465AD747D3FF", hash_generated_method = "D2BF0FF92B5457AC52706BC3A1B967F5")
                        //DSFIXME:  CODE0002: Requires DSC value to be set
                        public K get(Map.Entry<K, V> entry) {
                            dsTaint.addTaint(entry.dsTaint);
                            K var9CB9C37DCE6BB308B1BDBFD200B7F19C_628828420 = (entry.getKey());
                            return (K)dsTaint.getTaint();
                            // ---------- Original Method ----------
                            //return entry.getKey();
                        }
}));
                    return (Iterator<K>)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //return new HashIterator<K>(new Entry.Type<K, K, V>() {
                        //public K get(Map.Entry<K, V> entry) {
                            //return entry.getKey();
                        //}
                    //});
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.245 -0400", hash_original_method = "8D1ED5FEE11EEA3682A2E2ECF5DE32C3", hash_generated_method = "799387213E26B7B2C82659134FF659F4")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public Object[] toArray() {
                    Collection<K> coll;
                    coll = new ArrayList<K>(size());
                    {
                        Iterator<K> iter;
                        iter = iterator();
                        boolean var0719F6DF13666099B3F99B9DD393E1F6_1664311757 = (iter.hasNext());
                        {
                            coll.add(iter.next());
                        } //End block
                    } //End collapsed parenthetic
                    Object[] varD8B347BBDB280BC3BD40B0E5DC114FB7_2002841300 = (coll.toArray());
                    return (Object[])dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //Collection<K> coll = new ArrayList<K>(size());
                    //for (Iterator<K> iter = iterator(); iter.hasNext();) {
                        //coll.add(iter.next());
                    //}
                    //return coll.toArray();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.245 -0400", hash_original_method = "50B72C5F86BB9252B582673D59AA848C", hash_generated_method = "32872511F568F4979D02268AB464276E")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public <T> T[] toArray(T[] contents) {
                    dsTaint.addTaint(contents[0].dsTaint);
                    Collection<K> coll;
                    coll = new ArrayList<K>(size());
                    {
                        Iterator<K> iter;
                        iter = iterator();
                        boolean var0719F6DF13666099B3F99B9DD393E1F6_1520084938 = (iter.hasNext());
                        {
                            coll.add(iter.next());
                        } //End block
                    } //End collapsed parenthetic
                    T[] varFEEAEE83F6D200692EB4092988DE77FD_510636100 = (coll.toArray(contents));
                    return (T[])dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //Collection<K> coll = new ArrayList<K>(size());
                    //for (Iterator<K> iter = iterator(); iter.hasNext();) {
                        //coll.add(iter.next());
                    //}
                    //return coll.toArray(contents);
                }
};
        } //End block
        return (Set<K>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.247 -0400", hash_original_method = "1BF87F9B8C3D58711D484B01D41C9F2F", hash_generated_method = "4E68529343196C6F402C8E33C38BB5E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Collection<V> values() {
        poll();
        {
            valuesCollection = new AbstractCollection<V>() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.246 -0400", hash_original_method = "997773928D6A4FA2A905BEE282A68997", hash_generated_method = "7F1F003C1D5491B11EB3E3D998C30FF4")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public int size() {
                    int varEB466AC21988954CC038D6EAFB4E7FEA_1835248671 = (WeakHashMap.this.size());
                    return dsTaint.getTaintInt();
                    // ---------- Original Method ----------
                    //return WeakHashMap.this.size();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.246 -0400", hash_original_method = "0820DD19F55EBD9E05BEDEF72AA76B85", hash_generated_method = "216199AA5B7C7589486AA111C1364167")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public void clear() {
                    WeakHashMap.this.clear();
                    // ---------- Original Method ----------
                    //WeakHashMap.this.clear();
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.246 -0400", hash_original_method = "7679F4183F803D10EFCD1172E399C7C3", hash_generated_method = "8A3EEAE5255EAF981122AD2AE23965E3")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public boolean contains(Object object) {
                    dsTaint.addTaint(object.dsTaint);
                    boolean varF0370008E8B5928F4FAF5BBF8632C1B3_702204411 = (containsValue(object));
                    return dsTaint.getTaintBoolean();
                    // ---------- Original Method ----------
                    //return containsValue(object);
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.247 -0400", hash_original_method = "D1021921C3018EF53317EBCD6C577AB9", hash_generated_method = "BAA8F9976E514B51C97C5E95F1C095D2")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public Iterator<V> iterator() {
                    Iterator<V> var0F2A63122FBA8A2A2D1F2ACAF4F4B2F6_1295727078 = (new HashIterator<V>(new Entry.Type<V, K, V>() {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.247 -0400", hash_original_method = "FAEFA6E774F5C39BE828B4B8AA2C5E26", hash_generated_method = "654336C29CF78BBBA52D759890D9FF8F")
                        //DSFIXME:  CODE0002: Requires DSC value to be set
                        public V get(Map.Entry<K, V> entry) {
                            dsTaint.addTaint(entry.dsTaint);
                            V var4E1F40FF31F2D73819A604B313C40C8C_2063024690 = (entry.getValue());
                            return (V)dsTaint.getTaint();
                            // ---------- Original Method ----------
                            //return entry.getValue();
                        }
}));
                    return (Iterator<V>)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //return new HashIterator<V>(new Entry.Type<V, K, V>() {
                        //public V get(Map.Entry<K, V> entry) {
                            //return entry.getValue();
                        //}
                    //});
                }
};
        } //End block
        return (Collection<V>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.247 -0400", hash_original_method = "7498B4140ED8DA87371F31164D271C1D", hash_generated_method = "DC369A6EF0BC617A06029B75E028E5F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public V get(Object key) {
        dsTaint.addTaint(key.dsTaint);
        poll();
        {
            int index;
            index = (key.hashCode() & 0x7FFFFFFF) % elementData.length;
            Entry<K, V> entry;
            entry = elementData[index];
            {
                {
                    boolean var34A40B722D871D6DB92AB2E02C0D49BB_1911647973 = (key.equals(entry.get()));
                } //End collapsed parenthetic
                entry = entry.next;
            } //End block
        } //End block
        Entry<K, V> entry;
        entry = elementData[0];
        {
            entry = entry.next;
        } //End block
        return (V)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.248 -0400", hash_original_method = "545F7F0FB84E7EA33FCF99594092AF0D", hash_generated_method = "F36058DD820842C419FE10C624A13C85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Entry<K, V> getEntry(Object key) {
        dsTaint.addTaint(key.dsTaint);
        poll();
        {
            int index;
            index = (key.hashCode() & 0x7FFFFFFF) % elementData.length;
            Entry<K, V> entry;
            entry = elementData[index];
            {
                {
                    boolean var34A40B722D871D6DB92AB2E02C0D49BB_1881071120 = (key.equals(entry.get()));
                } //End collapsed parenthetic
                entry = entry.next;
            } //End block
        } //End block
        Entry<K, V> entry;
        entry = elementData[0];
        {
            entry = entry.next;
        } //End block
        return (Entry<K, V>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.248 -0400", hash_original_method = "EBDA4BA5DE93153797BA511A1B84894F", hash_generated_method = "3FEAF8770F52AC5D7062E64A7401B75D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean containsValue(Object value) {
        dsTaint.addTaint(value.dsTaint);
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
                            boolean var18A512D740DE406E77259979D1000436_1393874162 = ((key != null || entry.isNull)
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.248 -0400", hash_original_method = "296240B68F4A866C698190CF33710ED8", hash_generated_method = "15088A601C8C1B92C1B2F512F7ED7A74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isEmpty() {
        boolean var5E7C4FBBEC9A5754B20CB85881048CD5_711612419 = (size() == 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return size() == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.249 -0400", hash_original_method = "0A4BB2570FECEAC055174AF0C493CF3C", hash_generated_method = "E74C68705163F2E51E43CF06B2D233BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
     void poll() {
        Entry<K, V> toRemove;
        {
            boolean varAF179C89B87910BBBA6E45758D4FD0E7_626113878 = ((toRemove = (Entry<K, V>) referenceQueue.poll()) != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.249 -0400", hash_original_method = "950CA8B0FD25845E584DCFB2BE4D9F32", hash_generated_method = "744426D0DEC81F1E9246D2FC1600956E")
    @DSModeled(DSC.SAFE)
     void removeEntry(Entry<K, V> toRemove) {
        dsTaint.addTaint(toRemove.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.249 -0400", hash_original_method = "E298E65486168CC370356B38BEF7AC1C", hash_generated_method = "F12C204F99899F755802BB17ACA3ED41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public V put(K key, V value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        poll();
        int index;
        index = 0;
        Entry<K, V> entry;
        {
            index = (key.hashCode() & 0x7FFFFFFF) % elementData.length;
            entry = elementData[index];
            {
                boolean var11C456750D82E660592E03F3DAA89A38_1683681436 = (entry != null && !key.equals(entry.get()));
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
        } //End block
        V result;
        result = entry.value;
        entry.value = value;
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.250 -0400", hash_original_method = "2B64F6E6AE3910B09507F9013DEACFFD", hash_generated_method = "B8C09FECA25AEF91449F210547B15507")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.250 -0400", hash_original_method = "57B3987EA7E50826E0AAD0198F968E42", hash_generated_method = "1386B3754A270FB4A54AF4E428695BF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        dsTaint.addTaint(map.dsTaint);
        putAllImpl(map);
        // ---------- Original Method ----------
        //putAllImpl(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.251 -0400", hash_original_method = "FE1A1739C961B2012661CB8735C428AE", hash_generated_method = "4EC7B1E454053ED8E70B15E74512A811")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public V remove(Object key) {
        dsTaint.addTaint(key.dsTaint);
        poll();
        int index;
        index = 0;
        Entry<K, V> entry, last;
        last = null;
        {
            index = (key.hashCode() & 0x7FFFFFFF) % elementData.length;
            entry = elementData[index];
            {
                boolean var11C456750D82E660592E03F3DAA89A38_1913708946 = (entry != null && !key.equals(entry.get()));
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
        } //End block
        return (V)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.251 -0400", hash_original_method = "B65BB7405B9BD112F0A817BA32556A99", hash_generated_method = "A3669CEEE6033A32372CB647284FE703")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int size() {
        poll();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //poll();
        //return elementCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.251 -0400", hash_original_method = "F23833AECC848C129604A1D671C10BB2", hash_generated_method = "AA93A77B95006FDC89C8604BF04F5520")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void putAllImpl(Map<? extends K, ? extends V> map) {
        dsTaint.addTaint(map.dsTaint);
        {
            boolean var6889E31DD8EB0136BAB9D60DD7EEE838_1040707030 = (map.entrySet() != null);
            {
                super.putAll(map);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (map.entrySet() != null) {
            //super.putAll(map);
        //}
    }

    
    private static final class Entry<K, V> extends WeakReference<K> implements Map.Entry<K, V> {
        int hash;
        boolean isNull;
        V value;
        Entry<K, V> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.252 -0400", hash_original_method = "87D1D30974ED96CB990C400F03BCFAE4", hash_generated_method = "9407B2A623C0F11E88744545180A1F76")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Entry(K key, V object, ReferenceQueue<K> queue) {
            super(key, queue);
            dsTaint.addTaint(queue.dsTaint);
            dsTaint.addTaint(object.dsTaint);
            dsTaint.addTaint(key.dsTaint);
            isNull = key == null;
            hash = isNull ? 0 : key.hashCode();
            // ---------- Original Method ----------
            //isNull = key == null;
            //hash = isNull ? 0 : key.hashCode();
            //value = object;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.252 -0400", hash_original_method = "1761F5110CA075C2A7975CB6F7D505A7", hash_generated_method = "FB5941E32E8CFA6B2E09798F196591C0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public K getKey() {
            K varB65187F425649C82FC5DED1D0938E1AD_1292197853 = (super.get());
            return (K)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return super.get();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.252 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "1716B03F3EEDEC9A8CDFDC8FCC55E236")
        @DSModeled(DSC.SAFE)
        public V getValue() {
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.252 -0400", hash_original_method = "123DAF07FFBE76C8EE5BD5879EB92827", hash_generated_method = "6C04AFB63E89CDE7EFCF5132A9B136AE")
        @DSModeled(DSC.SAFE)
        public V setValue(V object) {
            dsTaint.addTaint(object.dsTaint);
            V result;
            result = value;
            return (V)dsTaint.getTaint();
            // ---------- Original Method ----------
            //V result = value;
            //value = object;
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.253 -0400", hash_original_method = "3B6A8BF252F73FDC95A7717672A6DE75", hash_generated_method = "B4B387272593F0CB78EA08732103D0C8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object other) {
            dsTaint.addTaint(other.dsTaint);
            Map.Entry<?, ?> entry;
            entry = (Map.Entry<?, ?>) other;
            Object key;
            key = super.get();
            boolean var715794E66FEAD2DA8E249FD5488C80A4_387740313 = ((key == null ? key == entry.getKey() : key.equals(entry
                    .getKey()))
                    && (value == null ? value == entry.getValue() : value
                            .equals(entry.getValue()))); //DSFIXME:  CODE0008: Nested ternary operator in expression
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.253 -0400", hash_original_method = "D08C41096A06FEDF3165E76D8A8BDE22", hash_generated_method = "8F1A9148A8B0A5C3EF74F84D72F195D0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int varBFAA27FDBD65002EF874070ACA9FDE01_1660132232 = (hash + (value == null ? 0 : value.hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return hash + (value == null ? 0 : value.hashCode());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.253 -0400", hash_original_method = "1EE8DCD6F434B8EBFF147EFC16429262", hash_generated_method = "50B3B2548A33ED04AD27C86641E0DB42")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            String var6C7F813D34BDE56169D1ED827A0A0228_1877343074 = (super.get() + "=" + value);
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return super.get() + "=" + value;
        }

        
        interface Type<R, K, V> {
            R get(Map.Entry<K, V> entry);
        }
        
    }


    
    class HashIterator<R> implements Iterator<R> {
        private int position = 0, expectedModCount;
        private Entry<K, V> currentEntry, nextEntry;
        private K nextKey;
        Entry.Type<R, K, V> type;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.253 -0400", hash_original_method = "257D5034B04AA7E9B1AFE5220E974305", hash_generated_method = "5CA01187C943C1B617DD35DC4834A379")
        @DSModeled(DSC.SAFE)
         HashIterator(Entry.Type<R, K, V> type) {
            dsTaint.addTaint(type.dsTaint);
            expectedModCount = modCount;
            // ---------- Original Method ----------
            //this.type = type;
            //expectedModCount = modCount;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.253 -0400", hash_original_method = "E96FCD52B0E07477D827A4DEB82A49B2", hash_generated_method = "FFB6E09BF99ACA2AC120799189860C59")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean hasNext() {
            {
                {
                    {
                        {
                            boolean var153DD30E336FC14C6728E2427043F36D_149158499 = ((nextEntry = elementData[position++]) != null);
                        } //End collapsed parenthetic
                    } //End block
                } //End block
                nextKey = nextEntry.get();
                nextEntry = nextEntry.next;
            } //End block
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.254 -0400", hash_original_method = "F6AE8405A941E9948A6F966D8D2D9924", hash_generated_method = "A6E81DF1BA21A6FB48978A7A26C4E72A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public R next() {
            {
                {
                    boolean var384B0C75E2EB52B4939B27A6F15C2DC1_1168909118 = (hasNext());
                    {
                        currentEntry = nextEntry;
                        nextEntry = currentEntry.next;
                        R result;
                        result = type.get(currentEntry);
                        nextKey = null;
                    } //End block
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            return (R)dsTaint.getTaint();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.254 -0400", hash_original_method = "9519576E1338F396C5D4D192735A75A5", hash_generated_method = "5066B19DB201DA1D54AA398F0E48104A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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


    
    private static final int DEFAULT_SIZE = 16;
}

