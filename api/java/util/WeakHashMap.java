package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class WeakHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.112 -0400", hash_original_field = "4B551E83AB7D0C8C6FE6D2A3C3F57121", hash_generated_field = "DA4F581341DFFC093DAB2ED377CF1682")

    private ReferenceQueue<K> referenceQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.112 -0400", hash_original_field = "BC8C6DCF12CE09E50A98BB57ADFCADD9", hash_generated_field = "BF84735BCD9327FC2D1CC927ED35945D")

    int elementCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.112 -0400", hash_original_field = "8D395F1876FF8AE01BE52A9C4C2ED552", hash_generated_field = "36C14C81A5F4E64B5630EF2ADDAD7469")

    Entry<K, V>[] elementData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.112 -0400", hash_original_field = "97C293EF8ABD832D29E88C21D8E562F5", hash_generated_field = "9875194AD635CA8D9949128549486276")

    private int loadFactor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.112 -0400", hash_original_field = "F0598264A691A8F62272ACA0E79AF374", hash_generated_field = "831F8FC1A32CF07BE696149BB6AEA9AA")

    private int threshold;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.112 -0400", hash_original_field = "675B3022548A1029F9CE7A2C25B23BBF", hash_generated_field = "7980638400FDA73EFCEF2F9901C03D43")

    volatile int modCount;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.112 -0400", hash_original_method = "B976885DE3CF2C49EC1331AC2786A4B5", hash_generated_method = "947788F1D50A3898B6C48AAEC3B777CB")
    public  WeakHashMap() {
        this(DEFAULT_SIZE);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.112 -0400", hash_original_method = "76AE00E803F5BFDB4BDF43DC151D88D7", hash_generated_method = "DBF4021447A7F5384C27054A6107EA6C")
    public  WeakHashMap(int capacity) {
        if(capacity >= 0)        
        {
            elementCount = 0;
            elementData = newEntryArray(capacity == 0 ? 1 : capacity);
            loadFactor = 7500;
            computeMaxSize();
            referenceQueue = new ReferenceQueue<K>();
        } //End block
        else
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_351168327 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_351168327.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_351168327;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.113 -0400", hash_original_method = "342F9B7CF63C1134C14E3979782FA4FA", hash_generated_method = "38FC7AB671E87B722EA276AD4AF78B08")
    public  WeakHashMap(int capacity, float loadFactor) {
        if(capacity >= 0 && loadFactor > 0)        
        {
            elementCount = 0;
            elementData = newEntryArray(capacity == 0 ? 1 : capacity);
            this.loadFactor = (int) (loadFactor * 10000);
            computeMaxSize();
            referenceQueue = new ReferenceQueue<K>();
        } //End block
        else
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_950433622 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_950433622.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_950433622;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.113 -0400", hash_original_method = "4D7BC16BC60EE786903D624E86CA0AFB", hash_generated_method = "95DEFF5A9EADB9D6B603F7B78FB45AE1")
    public  WeakHashMap(Map<? extends K, ? extends V> map) {
        this(map.size() < 6 ? 11 : map.size() * 2);
        addTaint(map.getTaint());
        putAllImpl(map);
        // ---------- Original Method ----------
        //putAllImpl(map);
    }

    
    @SuppressWarnings("unchecked")
    private static <K, V> Entry<K, V>[] newEntryArray(int size) {
        return new Entry[size];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.113 -0400", hash_original_method = "C690E441FDF499DD7829AA3D638ADE28", hash_generated_method = "F3467E7C1779DDA17A7262C417055AFD")
    @Override
    public void clear() {
        if(elementCount > 0)        
        {
            elementCount = 0;
            Arrays.fill(elementData, null);
            modCount++;
            while
(referenceQueue.poll() != null)            
            {
            } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.113 -0400", hash_original_method = "85D93BA99AF40F5CDC3F42570A89C9FC", hash_generated_method = "BE619D13CAF85822181B65989DC845A9")
    private void computeMaxSize() {
        threshold = (int) ((long) elementData.length * loadFactor / 10000);
        // ---------- Original Method ----------
        //threshold = (int) ((long) elementData.length * loadFactor / 10000);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.113 -0400", hash_original_method = "7C0BA359573790AC71E46CA35F3B3C5D", hash_generated_method = "E0406CE4B53850A1FACE98D257DE9799")
    @Override
    public boolean containsKey(Object key) {
        addTaint(key.getTaint());
        boolean var8932A54AAACB53164E5FA2BABB4C4C06_1628183061 = (getEntry(key) != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2017645652 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2017645652;
        // ---------- Original Method ----------
        //return getEntry(key) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.246 -0400", hash_original_method = "115108C1B40A91216FE420487FA7990C", hash_generated_method = "54486BB87EC100E6525877EA5676ED14")
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        poll();
Set<Map.Entry<K, V>> var952772A53018FA152689B94755082E8D_915180893 =         new AbstractSet<Map.Entry<K, V>>() {        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.244 -0400", hash_original_method = "997773928D6A4FA2A905BEE282A68997", hash_generated_method = "612EA033FD29F8F1B1B8EF6FC5A61837")
        @Override
        public int size() {
            int varD3F415AC0DAFD84BD094635E9A38D203_251232469 = (WeakHashMap.this.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1332954278 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1332954278;
            // ---------- Original Method ----------
            //return WeakHashMap.this.size();
        }
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.244 -0400", hash_original_method = "0820DD19F55EBD9E05BEDEF72AA76B85", hash_generated_method = "216199AA5B7C7589486AA111C1364167")
        @Override
        public void clear() {
            WeakHashMap.this.clear();
            // ---------- Original Method ----------
            //WeakHashMap.this.clear();
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.245 -0400", hash_original_method = "1E7F94AC13E80E407E04FDAF276E4CCB", hash_generated_method = "80D4CA477C1A94672839765A4E14EF3A")
        @Override
        public boolean remove(Object object) {
            addTaint(object.getTaint());
    if(contains(object))            
            {
                WeakHashMap.this
                            .remove(((Map.Entry<?, ?>) object).getKey());
                boolean varB326B5062B2F0E69046810717534CB09_354261417 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1199118272 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1199118272;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_304459482 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1122330981 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1122330981;
            // ---------- Original Method ----------
            //if (contains(object)) {
                    //WeakHashMap.this
                            //.remove(((Map.Entry<?, ?>) object).getKey());
                    //return true;
                //}
            //return false;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.245 -0400", hash_original_method = "A69D5126071923809AD406525E677E9C", hash_generated_method = "98AC8BF9D363C4CECEDD84BEECB5ED4B")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
    if(object instanceof Map.Entry)            
            {
                Entry<?, ?> entry = getEntry(((Map.Entry<?, ?>) object)
                            .getKey());
    if(entry != null)                
                {
                    Object key = entry.get();
    if(key != null || entry.isNull)                    
                    {
                        boolean var9F67B4CD93AA547D336CDA928388F243_106815488 = (object.equals(entry));
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_921548558 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_921548558;
                    } //End block
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1379519332 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_854323099 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_854323099;
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.246 -0400", hash_original_method = "6126AC883C019C19A724D0EDFC9A192D", hash_generated_method = "C5540A31518834C464989BAA9FF0BE80")
        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
Iterator<Map.Entry<K, V>> varFD445BCDDF9C631EA7BE770450B83225_839819223 =             new HashIterator<Map.Entry<K, V>>(
                        new Entry.Type<Map.Entry<K, V>, K, V>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.246 -0400", hash_original_method = "90738D101B25945A174A5A8A030091D2", hash_generated_method = "176D5AEBFE4C5F09ADA55C1830BB5393")
            public Map.Entry<K, V> get(Map.Entry<K, V> entry) {
                addTaint(entry.getTaint());
Map.Entry<K, V> varF26DBE38545460D6F6AE1D948FF53869_1660048985 =                 entry;
                varF26DBE38545460D6F6AE1D948FF53869_1660048985.addTaint(taint);
                return varF26DBE38545460D6F6AE1D948FF53869_1660048985;
                // ---------- Original Method ----------
                //return entry;
            }
});
            varFD445BCDDF9C631EA7BE770450B83225_839819223.addTaint(taint);
            return varFD445BCDDF9C631EA7BE770450B83225_839819223;
            // ---------- Original Method ----------
            //return new HashIterator<Map.Entry<K, V>>(
                        //new Entry.Type<Map.Entry<K, V>, K, V>() {
                            //public Map.Entry<K, V> get(Map.Entry<K, V> entry) {
                                //return entry;
                            //}
                        //});
        }
};
        var952772A53018FA152689B94755082E8D_915180893.addTaint(taint);
        return var952772A53018FA152689B94755082E8D_915180893;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.251 -0400", hash_original_method = "058A25F673776D4338089073DA213D4E", hash_generated_method = "FF4B61F6AD260A5C10AA7555B0686E3F")
    @Override
    public Set<K> keySet() {
        poll();
    if(keySet == null)        
        {
            keySet = new AbstractSet<K>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.248 -0400", hash_original_method = "D170B4D54B17306878DDF90A529C04ED", hash_generated_method = "741C44F8B0DE2B07C2D1884889D6D900")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean varF42ECC5119C86E67C012437242277954_1855226587 = (containsKey(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_418505779 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_418505779;
            // ---------- Original Method ----------
            //return containsKey(object);
        }
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.248 -0400", hash_original_method = "997773928D6A4FA2A905BEE282A68997", hash_generated_method = "A0801843F38404635E8F87241D24EF30")
        @Override
        public int size() {
            int varD3F415AC0DAFD84BD094635E9A38D203_58596902 = (WeakHashMap.this.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_106980471 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_106980471;
            // ---------- Original Method ----------
            //return WeakHashMap.this.size();
        }
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.248 -0400", hash_original_method = "0820DD19F55EBD9E05BEDEF72AA76B85", hash_generated_method = "216199AA5B7C7589486AA111C1364167")
        @Override
        public void clear() {
            WeakHashMap.this.clear();
            // ---------- Original Method ----------
            //WeakHashMap.this.clear();
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.249 -0400", hash_original_method = "2EBC57A89CF751265ACE297F532371F8", hash_generated_method = "A1B79CE8E9FDFBD1E747A89DF03BC4CC")
        @Override
        public boolean remove(Object key) {
            addTaint(key.getTaint());
    if(containsKey(key))            
            {
                WeakHashMap.this.remove(key);
                boolean varB326B5062B2F0E69046810717534CB09_1827631850 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1937373969 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1937373969;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_2058616874 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1257297720 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1257297720;
            // ---------- Original Method ----------
            //if (containsKey(key)) {
                        //WeakHashMap.this.remove(key);
                        //return true;
                    //}
            //return false;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.249 -0400", hash_original_method = "AE3D91420CF50F34AE4E77081237432D", hash_generated_method = "FB0F0B04F6FF9685FC50FC247B34D2F9")
        @Override
        public Iterator<K> iterator() {
Iterator<K> varDCD478621156DFA0E4D712E6830BBFE3_1381818936 =             new HashIterator<K>(new Entry.Type<K, K, V>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.249 -0400", hash_original_method = "90FB27292ACE8EC15DDC465AD747D3FF", hash_generated_method = "2599C7F8DC6E381B8F32CF0BDAC80826")
            public K get(Map.Entry<K, V> entry) {
                addTaint(entry.getTaint());
K varE5CD6225CB16CF7AEFEC373E217B052C_1924166295 =                 entry.getKey();
                varE5CD6225CB16CF7AEFEC373E217B052C_1924166295.addTaint(taint);
                return varE5CD6225CB16CF7AEFEC373E217B052C_1924166295;
                // ---------- Original Method ----------
                //return entry.getKey();
            }
});
            varDCD478621156DFA0E4D712E6830BBFE3_1381818936.addTaint(taint);
            return varDCD478621156DFA0E4D712E6830BBFE3_1381818936;
            // ---------- Original Method ----------
            //return new HashIterator<K>(new Entry.Type<K, K, V>() {
                        //public K get(Map.Entry<K, V> entry) {
                            //return entry.getKey();
                        //}
                    //});
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.250 -0400", hash_original_method = "8D1ED5FEE11EEA3682A2E2ECF5DE32C3", hash_generated_method = "EA40CE59E2DCE7EE2A81E8AB54E29A3A")
        @Override
        public Object[] toArray() {
            Collection<K> coll = new ArrayList<K>(size());
for(Iterator<K> iter = iterator();iter.hasNext();)
            {
                coll.add(iter.next());
            } //End block
Object[] varC2A88C8443A0973DC0E59944F0A3C36C_437299285 =             coll.toArray();
            varC2A88C8443A0973DC0E59944F0A3C36C_437299285.addTaint(taint);
            return varC2A88C8443A0973DC0E59944F0A3C36C_437299285;
            // ---------- Original Method ----------
            //Collection<K> coll = new ArrayList<K>(size());
            //for (Iterator<K> iter = iterator(); iter.hasNext();) {
                        //coll.add(iter.next());
                    //}
            //return coll.toArray();
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.250 -0400", hash_original_method = "50B72C5F86BB9252B582673D59AA848C", hash_generated_method = "D84F498A467182F7202408A575BB0242")
        @Override
        public <T> T[] toArray(T[] contents) {
            addTaint(contents[0].getTaint());
            Collection<K> coll = new ArrayList<K>(size());
for(Iterator<K> iter = iterator();iter.hasNext();)
            {
                coll.add(iter.next());
            } //End block
T[] var385EDC79139136F1D4AF8B758DE90A49_311831670 =             coll.toArray(contents);
            var385EDC79139136F1D4AF8B758DE90A49_311831670.addTaint(taint);
            return var385EDC79139136F1D4AF8B758DE90A49_311831670;
            // ---------- Original Method ----------
            //Collection<K> coll = new ArrayList<K>(size());
            //for (Iterator<K> iter = iterator(); iter.hasNext();) {
                        //coll.add(iter.next());
                    //}
            //return coll.toArray(contents);
        }
};
        } //End block
Set<K> varCB23CF4AFB8B7AE1843E733C4B0CC600_2072530331 =         keySet;
        varCB23CF4AFB8B7AE1843E733C4B0CC600_2072530331.addTaint(taint);
        return varCB23CF4AFB8B7AE1843E733C4B0CC600_2072530331;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.253 -0400", hash_original_method = "1BF87F9B8C3D58711D484B01D41C9F2F", hash_generated_method = "22D944BAFA8F193C4DA7F6D90036826A")
    @Override
    public Collection<V> values() {
        poll();
    if(valuesCollection == null)        
        {
            valuesCollection = new AbstractCollection<V>() {        
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.252 -0400", hash_original_method = "997773928D6A4FA2A905BEE282A68997", hash_generated_method = "2685B57F37149102E429BBFAFFBA7327")
        @Override
        public int size() {
            int varD3F415AC0DAFD84BD094635E9A38D203_766029023 = (WeakHashMap.this.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1656792483 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1656792483;
            // ---------- Original Method ----------
            //return WeakHashMap.this.size();
        }
        @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.252 -0400", hash_original_method = "0820DD19F55EBD9E05BEDEF72AA76B85", hash_generated_method = "216199AA5B7C7589486AA111C1364167")
        @Override
        public void clear() {
            WeakHashMap.this.clear();
            // ---------- Original Method ----------
            //WeakHashMap.this.clear();
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.252 -0400", hash_original_method = "7679F4183F803D10EFCD1172E399C7C3", hash_generated_method = "AD9F36B261C6F773F7F9D29BEFA206F6")
        @Override
        public boolean contains(Object object) {
            addTaint(object.getTaint());
            boolean varB5B67EA4257497C0385399BB5E8BA25C_443926067 = (containsValue(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1159292141 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1159292141;
            // ---------- Original Method ----------
            //return containsValue(object);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.253 -0400", hash_original_method = "D1021921C3018EF53317EBCD6C577AB9", hash_generated_method = "8F55588F636ECC0C799166ED90AF117E")
        @Override
        public Iterator<V> iterator() {
Iterator<V> var07197EA3EAD8FB5AD311B18A1D908E82_1647781354 =             new HashIterator<V>(new Entry.Type<V, K, V>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.253 -0400", hash_original_method = "FAEFA6E774F5C39BE828B4B8AA2C5E26", hash_generated_method = "3449567377873C20E46494E2E420023A")
            public V get(Map.Entry<K, V> entry) {
                addTaint(entry.getTaint());
V var4A887D14956ECA386DDED2772C1F523B_575345795 =                 entry.getValue();
                var4A887D14956ECA386DDED2772C1F523B_575345795.addTaint(taint);
                return var4A887D14956ECA386DDED2772C1F523B_575345795;
                // ---------- Original Method ----------
                //return entry.getValue();
            }
});
            var07197EA3EAD8FB5AD311B18A1D908E82_1647781354.addTaint(taint);
            return var07197EA3EAD8FB5AD311B18A1D908E82_1647781354;
            // ---------- Original Method ----------
            //return new HashIterator<V>(new Entry.Type<V, K, V>() {
                        //public V get(Map.Entry<K, V> entry) {
                            //return entry.getValue();
                        //}
                    //});
        }
};
        } //End block
Collection<V> var60B0A8A6E555943126A18D312F8E04FB_1559692254 =         valuesCollection;
        var60B0A8A6E555943126A18D312F8E04FB_1559692254.addTaint(taint);
        return var60B0A8A6E555943126A18D312F8E04FB_1559692254;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.118 -0400", hash_original_method = "7498B4140ED8DA87371F31164D271C1D", hash_generated_method = "5AD5D87D0846A4390F90C4C142B7138C")
    @Override
    public V get(Object key) {
        addTaint(key.getTaint());
        poll();
        if(key != null)        
        {
            int index = (key.hashCode() & 0x7FFFFFFF) % elementData.length;
            Entry<K, V> entry = elementData[index];
            while
(entry != null)            
            {
                if(key.equals(entry.get()))                
                {
V varD2C0624DDD8A4F8F307477F36B405DFB_1316422700 =                     entry.value;
                    varD2C0624DDD8A4F8F307477F36B405DFB_1316422700.addTaint(taint);
                    return varD2C0624DDD8A4F8F307477F36B405DFB_1316422700;
                } //End block
                entry = entry.next;
            } //End block
V var540C13E9E156B687226421B24F2DF178_186687740 =             null;
            var540C13E9E156B687226421B24F2DF178_186687740.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_186687740;
        } //End block
        Entry<K, V> entry = elementData[0];
        while
(entry != null)        
        {
            if(entry.isNull)            
            {
V varD2C0624DDD8A4F8F307477F36B405DFB_507097408 =                 entry.value;
                varD2C0624DDD8A4F8F307477F36B405DFB_507097408.addTaint(taint);
                return varD2C0624DDD8A4F8F307477F36B405DFB_507097408;
            } //End block
            entry = entry.next;
        } //End block
V var540C13E9E156B687226421B24F2DF178_1915783830 =         null;
        var540C13E9E156B687226421B24F2DF178_1915783830.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1915783830;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.118 -0400", hash_original_method = "545F7F0FB84E7EA33FCF99594092AF0D", hash_generated_method = "B7AC0EA6E1B0E7CA341DCA528B75B8C3")
     Entry<K, V> getEntry(Object key) {
        addTaint(key.getTaint());
        poll();
        if(key != null)        
        {
            int index = (key.hashCode() & 0x7FFFFFFF) % elementData.length;
            Entry<K, V> entry = elementData[index];
            while
(entry != null)            
            {
                if(key.equals(entry.get()))                
                {
Entry<K, V> varF26DBE38545460D6F6AE1D948FF53869_573782410 =                     entry;
                    varF26DBE38545460D6F6AE1D948FF53869_573782410.addTaint(taint);
                    return varF26DBE38545460D6F6AE1D948FF53869_573782410;
                } //End block
                entry = entry.next;
            } //End block
Entry<K, V> var540C13E9E156B687226421B24F2DF178_1842415241 =             null;
            var540C13E9E156B687226421B24F2DF178_1842415241.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1842415241;
        } //End block
        Entry<K, V> entry = elementData[0];
        while
(entry != null)        
        {
            if(entry.isNull)            
            {
Entry<K, V> varF26DBE38545460D6F6AE1D948FF53869_1263043168 =                 entry;
                varF26DBE38545460D6F6AE1D948FF53869_1263043168.addTaint(taint);
                return varF26DBE38545460D6F6AE1D948FF53869_1263043168;
            } //End block
            entry = entry.next;
        } //End block
Entry<K, V> var540C13E9E156B687226421B24F2DF178_424754665 =         null;
        var540C13E9E156B687226421B24F2DF178_424754665.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_424754665;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.119 -0400", hash_original_method = "EBDA4BA5DE93153797BA511A1B84894F", hash_generated_method = "24FE1212727779518C83FC7B38BB4361")
    @Override
    public boolean containsValue(Object value) {
        addTaint(value.getTaint());
        poll();
        if(value != null)        
        {
for(int i = elementData.length;--i >= 0;)
            {
                Entry<K, V> entry = elementData[i];
                while
(entry != null)                
                {
                    K key = entry.get();
                    if((key != null || entry.isNull)
                            && value.equals(entry.value))                    
                    {
                        boolean varB326B5062B2F0E69046810717534CB09_492398822 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_689018918 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_689018918;
                    } //End block
                    entry = entry.next;
                } //End block
            } //End block
        } //End block
        else
        {
for(int i = elementData.length;--i >= 0;)
            {
                Entry<K, V> entry = elementData[i];
                while
(entry != null)                
                {
                    K key = entry.get();
                    if((key != null || entry.isNull) && entry.value == null)                    
                    {
                        boolean varB326B5062B2F0E69046810717534CB09_1568658736 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_864471738 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_864471738;
                    } //End block
                    entry = entry.next;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_2110312722 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1394854689 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1394854689;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.119 -0400", hash_original_method = "296240B68F4A866C698190CF33710ED8", hash_generated_method = "E0C9571EEEE0C9B77F607BFC124B1F4C")
    @Override
    public boolean isEmpty() {
        boolean var5BD3446419BAE72903C4742BF777F0E0_574048298 = (size() == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_134469624 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_134469624;
        // ---------- Original Method ----------
        //return size() == 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.119 -0400", hash_original_method = "0A4BB2570FECEAC055174AF0C493CF3C", hash_generated_method = "8A010F18FB328BAC58AD9113684DC5C8")
    @SuppressWarnings("unchecked")
     void poll() {
        Entry<K, V> toRemove;
        while
((toRemove = (Entry<K, V>) referenceQueue.poll()) != null)        
        {
            removeEntry(toRemove);
        } //End block
        // ---------- Original Method ----------
        //Entry<K, V> toRemove;
        //while ((toRemove = (Entry<K, V>) referenceQueue.poll()) != null) {
            //removeEntry(toRemove);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.119 -0400", hash_original_method = "950CA8B0FD25845E584DCFB2BE4D9F32", hash_generated_method = "049A2798808BB6EE8039B91ECB5E0462")
     void removeEntry(Entry<K, V> toRemove) {
        addTaint(toRemove.getTaint());
        Entry<K, V> entry;
        Entry<K, V> last = null;
        int index = (toRemove.hash & 0x7FFFFFFF) % elementData.length;
        entry = elementData[index];
        while
(entry != null)        
        {
            if(toRemove == entry)            
            {
                modCount++;
                if(last == null)                
                {
                    elementData[index] = entry.next;
                } //End block
                else
                {
                    last.next = entry.next;
                } //End block
                elementCount--;
                break;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.120 -0400", hash_original_method = "E298E65486168CC370356B38BEF7AC1C", hash_generated_method = "EBA98E0C43478CD8FDDF1C07E25AD71C")
    @Override
    public V put(K key, V value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
        poll();
        int index = 0;
        Entry<K, V> entry;
        if(key != null)        
        {
            index = (key.hashCode() & 0x7FFFFFFF) % elementData.length;
            entry = elementData[index];
            while
(entry != null && !key.equals(entry.get()))            
            {
                entry = entry.next;
            } //End block
        } //End block
        else
        {
            entry = elementData[0];
            while
(entry != null && !entry.isNull)            
            {
                entry = entry.next;
            } //End block
        } //End block
        if(entry == null)        
        {
            modCount++;
            if(++elementCount > threshold)            
            {
                rehash();
                index = key == null ? 0 : (key.hashCode() & 0x7FFFFFFF)
                        % elementData.length;
            } //End block
            entry = new Entry<K, V>(key, value, referenceQueue);
            entry.next = elementData[index];
            elementData[index] = entry;
V var540C13E9E156B687226421B24F2DF178_2045194149 =             null;
            var540C13E9E156B687226421B24F2DF178_2045194149.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2045194149;
        } //End block
        V result = entry.value;
        entry.value = value;
V varDC838461EE2FA0CA4C9BBB70A15456B0_1465915584 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1465915584.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1465915584;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.120 -0400", hash_original_method = "2B64F6E6AE3910B09507F9013DEACFFD", hash_generated_method = "43B89B9AE4AF91AB4CC60A9D77FCB8CD")
    private void rehash() {
        int length = elementData.length * 2;
        if(length == 0)        
        {
            length = 1;
        } //End block
        Entry<K, V>[] newData = newEntryArray(length);
for(int i = 0;i < elementData.length;i++)
        {
            Entry<K, V> entry = elementData[i];
            while
(entry != null)            
            {
                int index = entry.isNull ? 0 : (entry.hash & 0x7FFFFFFF)
                        % length;
                Entry<K, V> next = entry.next;
                entry.next = newData[index];
                newData[index] = entry;
                entry = next;
            } //End block
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.120 -0400", hash_original_method = "57B3987EA7E50826E0AAD0198F968E42", hash_generated_method = "70AD55C56E4025450542E2A5226752DF")
    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        addTaint(map.getTaint());
        putAllImpl(map);
        // ---------- Original Method ----------
        //putAllImpl(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.121 -0400", hash_original_method = "FE1A1739C961B2012661CB8735C428AE", hash_generated_method = "4D656D0A72CC9899B6B1A389A3FA1A76")
    @Override
    public V remove(Object key) {
        addTaint(key.getTaint());
        poll();
        int index = 0;
        Entry<K, V> entry;
        Entry<K, V> last = null;
        if(key != null)        
        {
            index = (key.hashCode() & 0x7FFFFFFF) % elementData.length;
            entry = elementData[index];
            while
(entry != null && !key.equals(entry.get()))            
            {
                last = entry;
                entry = entry.next;
            } //End block
        } //End block
        else
        {
            entry = elementData[0];
            while
(entry != null && !entry.isNull)            
            {
                last = entry;
                entry = entry.next;
            } //End block
        } //End block
        if(entry != null)        
        {
            modCount++;
            if(last == null)            
            {
                elementData[index] = entry.next;
            } //End block
            else
            {
                last.next = entry.next;
            } //End block
            elementCount--;
V varD2C0624DDD8A4F8F307477F36B405DFB_798862256 =             entry.value;
            varD2C0624DDD8A4F8F307477F36B405DFB_798862256.addTaint(taint);
            return varD2C0624DDD8A4F8F307477F36B405DFB_798862256;
        } //End block
V var540C13E9E156B687226421B24F2DF178_1886479484 =         null;
        var540C13E9E156B687226421B24F2DF178_1886479484.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1886479484;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.121 -0400", hash_original_method = "B65BB7405B9BD112F0A817BA32556A99", hash_generated_method = "ED4AEFEC347EE53B90A7B39E441C6F8D")
    @Override
    public int size() {
        poll();
        int varBC8C6DCF12CE09E50A98BB57ADFCADD9_676506561 = (elementCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1732199251 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1732199251;
        // ---------- Original Method ----------
        //poll();
        //return elementCount;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.121 -0400", hash_original_method = "F23833AECC848C129604A1D671C10BB2", hash_generated_method = "271754B42238C56180B1CCD533B129AC")
    private void putAllImpl(Map<? extends K, ? extends V> map) {
        addTaint(map.getTaint());
        if(map.entrySet() != null)        
        {
            super.putAll(map);
        } //End block
        // ---------- Original Method ----------
        //if (map.entrySet() != null) {
            //super.putAll(map);
        //}
    }

    
    private static final class Entry<K, V> extends WeakReference<K> implements Map.Entry<K, V> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.121 -0400", hash_original_field = "0800FC577294C34E0B28AD2839435945", hash_generated_field = "5ED776CD81502BA181156D7F28EBC9C8")

        int hash;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.121 -0400", hash_original_field = "771318A7D90A3F8A1D88BE5DB9CE456C", hash_generated_field = "608BD3C529DBD92C1EC1FA5648B44B23")

        boolean isNull;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.121 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "A7E8A049E4C72FD5713D3AFD6CBF7C08")

        V value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.121 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "5EEEE64CD04E8528349A03DB7ACC9002")

        Entry<K, V> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.122 -0400", hash_original_method = "87D1D30974ED96CB990C400F03BCFAE4", hash_generated_method = "071DFD2C4C031BB3EFC02AD2516A22F8")
          Entry(K key, V object, ReferenceQueue<K> queue) {
            super(key, queue);
            addTaint(queue.getTaint());
            isNull = key == null;
            hash = isNull ? 0 : key.hashCode();
            value = object;
            // ---------- Original Method ----------
            //isNull = key == null;
            //hash = isNull ? 0 : key.hashCode();
            //value = object;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.122 -0400", hash_original_method = "1761F5110CA075C2A7975CB6F7D505A7", hash_generated_method = "049E09C9EAE6BC1C8B0C48BC08E1C619")
        public K getKey() {
K varF46E0FEC371F89BDFA76383E23E6646E_1477930199 =             super.get();
            varF46E0FEC371F89BDFA76383E23E6646E_1477930199.addTaint(taint);
            return varF46E0FEC371F89BDFA76383E23E6646E_1477930199;
            // ---------- Original Method ----------
            //return super.get();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.122 -0400", hash_original_method = "A9984A6F88B588952649E3649EC43975", hash_generated_method = "750856B87B26366DE28AC0A002466815")
        public V getValue() {
V varAF280DA2BC37D8BE783D8499160168DE_871589787 =             value;
            varAF280DA2BC37D8BE783D8499160168DE_871589787.addTaint(taint);
            return varAF280DA2BC37D8BE783D8499160168DE_871589787;
            // ---------- Original Method ----------
            //return value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.122 -0400", hash_original_method = "123DAF07FFBE76C8EE5BD5879EB92827", hash_generated_method = "3A66BFD3D4865E8E7A3C3D9552B1F059")
        public V setValue(V object) {
            V result = value;
            value = object;
V varDC838461EE2FA0CA4C9BBB70A15456B0_1670626738 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1670626738.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1670626738;
            // ---------- Original Method ----------
            //V result = value;
            //value = object;
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.122 -0400", hash_original_method = "3B6A8BF252F73FDC95A7717672A6DE75", hash_generated_method = "0E431CF249BD90A155F24B862D743E17")
        @Override
        public boolean equals(Object other) {
            addTaint(other.getTaint());
            if(!(other instanceof Map.Entry))            
            {
                boolean var68934A3E9455FA72420237EB05902327_841640802 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1999377279 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1999377279;
            } //End block
            Map.Entry<?, ?> entry = (Map.Entry<?, ?>) other;
            Object key = super.get();
            boolean varC9CB589920583BFE71950CDF3298A1A4_2100798112 = ((key == null ? key == entry.getKey() : key.equals(entry
                    .getKey()))
                    && (value == null ? value == entry.getValue() : value
                            .equals(entry.getValue())));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_25416261 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_25416261;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.122 -0400", hash_original_method = "D08C41096A06FEDF3165E76D8A8BDE22", hash_generated_method = "F777CD8315D9406C64CD8B97AFE781B4")
        @Override
        public int hashCode() {
            int varF8D1F3F73B85EF59ABE7CBB7BE8BB7B9_1461641596 = (hash + (value == null ? 0 : value.hashCode()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_573247770 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_573247770;
            // ---------- Original Method ----------
            //return hash + (value == null ? 0 : value.hashCode());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.122 -0400", hash_original_method = "1EE8DCD6F434B8EBFF147EFC16429262", hash_generated_method = "E94F449D677831F166964270A4035F4B")
        @Override
        public String toString() {
String varFC892D331EE15D32E10B8CA14F620EF3_837132313 =             super.get() + "=" + value;
            varFC892D331EE15D32E10B8CA14F620EF3_837132313.addTaint(taint);
            return varFC892D331EE15D32E10B8CA14F620EF3_837132313;
            // ---------- Original Method ----------
            //return super.get() + "=" + value;
        }

        
        interface Type<R, K, V> {
            R get(Map.Entry<K, V> entry);
        }
        
    }


    
    class HashIterator<R> implements Iterator<R> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.122 -0400", hash_original_field = "64F8FBF9ECD410CCCCA37B900774D128", hash_generated_field = "6E2A691F6D792F742C26DA32023216AB")

        private int position = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.122 -0400", hash_original_field = "295CC8887E8B8B43596FF881B307867C", hash_generated_field = "9C353E755EC3A4E9B0CFE1EA9EEC47A8")

        private int expectedModCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.123 -0400", hash_original_field = "99BA38A3E6B2466208E2D2433FB7C05C", hash_generated_field = "55DBD0360631F6C09DC3C9CAFB79E913")

        private Entry<K, V> currentEntry;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.123 -0400", hash_original_field = "A456AF15DBCB1B656F162F16303E5E25", hash_generated_field = "147D6C1E63E472440226370714C1D130")

        private Entry<K, V> nextEntry;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.123 -0400", hash_original_field = "7372E4F82D6BA16EB4CD39C71388B39D", hash_generated_field = "989887495A4D0A589ACCCD9CE9664248")

        private K nextKey;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.123 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "01CE55F7E5B83A126B2D2C311EAC0383")

        Entry.Type<R, K, V> type;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.123 -0400", hash_original_method = "257D5034B04AA7E9B1AFE5220E974305", hash_generated_method = "D8DF824834C45D429AB91D50D4AD1F75")
          HashIterator(Entry.Type<R, K, V> type) {
            this.type = type;
            expectedModCount = modCount;
            // ---------- Original Method ----------
            //this.type = type;
            //expectedModCount = modCount;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.123 -0400", hash_original_method = "E96FCD52B0E07477D827A4DEB82A49B2", hash_generated_method = "E1CE0244DDF26D4DBC72D8579CCEBB58")
        public boolean hasNext() {
            if(nextEntry != null && (nextKey != null || nextEntry.isNull))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_500478334 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_146909569 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_146909569;
            } //End block
            while
(true)            
            {
                if(nextEntry == null)                
                {
                    while
(position < elementData.length)                    
                    {
                        if((nextEntry = elementData[position++]) != null)                        
                        {
                            break;
                        } //End block
                    } //End block
                    if(nextEntry == null)                    
                    {
                        boolean var68934A3E9455FA72420237EB05902327_1910447622 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1908748752 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1908748752;
                    } //End block
                } //End block
                nextKey = nextEntry.get();
                if(nextKey != null || nextEntry.isNull)                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_642151984 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1628211875 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1628211875;
                } //End block
                nextEntry = nextEntry.next;
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.123 -0400", hash_original_method = "F6AE8405A941E9948A6F966D8D2D9924", hash_generated_method = "AFA0057990778923FEFEC4CEAC4D42C1")
        public R next() {
            if(expectedModCount == modCount)            
            {
                if(hasNext())                
                {
                    currentEntry = nextEntry;
                    nextEntry = currentEntry.next;
                    R result = type.get(currentEntry);
                    nextKey = null;
R varDC838461EE2FA0CA4C9BBB70A15456B0_115509866 =                     result;
                    varDC838461EE2FA0CA4C9BBB70A15456B0_115509866.addTaint(taint);
                    return varDC838461EE2FA0CA4C9BBB70A15456B0_115509866;
                } //End block
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_1980790504 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_1980790504.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_1980790504;
            } //End block
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_1108082402 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_1108082402.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_1108082402;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.123 -0400", hash_original_method = "9519576E1338F396C5D4D192735A75A5", hash_generated_method = "30A60BA88C8B2F4B7E22D92A0A6CA140")
        public void remove() {
            if(expectedModCount == modCount)            
            {
                if(currentEntry != null)                
                {
                    removeEntry(currentEntry);
                    currentEntry = null;
                    expectedModCount++;
                } //End block
                else
                {
                    IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1681220962 = new IllegalStateException();
                    varC311A989A119B96A6232C22ABFE87C25_1681220962.addTaint(taint);
                    throw varC311A989A119B96A6232C22ABFE87C25_1681220962;
                } //End block
            } //End block
            else
            {
                ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_927031688 = new ConcurrentModificationException();
                var779BA6969BD29E5F2D0448781C543B65_927031688.addTaint(taint);
                throw var779BA6969BD29E5F2D0448781C543B65_927031688;
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.124 -0400", hash_original_field = "FE4F786FCADAEA637D52490E93F954CD", hash_generated_field = "7DB5CF06E1B6356201026C14CAD31DE8")

    private static final int DEFAULT_SIZE = 16;
}

