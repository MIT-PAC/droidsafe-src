package java.util;

// Droidsafe Imports
import droidsafe.annotations.*;





public class LinkedHashMap<K, V> extends HashMap<K, V> {
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.728 -0400", hash_original_method = "BC14FA557BD7B0B9C577C3EA20F65BB1", hash_generated_method = "841BDE13C0D724F59D7372319DB3BC68")
    public  LinkedHashMap() {
        init();
        // ---------- Original Method ----------
        //init();
        //accessOrder = false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.728 -0400", hash_original_method = "D0F194CEDBAC4E60D053508661AB90EF", hash_generated_method = "AF81C3A6342901CDC78A39BBC8257F31")
    public  LinkedHashMap(int initialCapacity) {
        super(initialCapacity);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.728 -0400", hash_original_method = "51A3F20C6E131F4E066F002E9C38CBA5", hash_generated_method = "E801E70E5B9A8065A7FA1C2E98EF899F")
    public  LinkedHashMap(int initialCapacity, float loadFactor) {
        this(initialCapacity);
        addTaint(loadFactor);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.729 -0400", hash_original_method = "40A72D68B61D12122A849997E9E4FA74", hash_generated_method = "D77757EB06EAB7C9CBF5A87B44178E77")
    public  LinkedHashMap(
            int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor);
        addTaint(loadFactor);
        addTaint(initialCapacity);
        addTaint(accessOrder);
        // ---------- Original Method ----------
        //init();
        //this.accessOrder = accessOrder;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.729 -0400", hash_original_method = "D1B0A8129B2843C851AD81FABBEE8B92", hash_generated_method = "F3C1A40CECC0CD85D317FD2AB157DBCF")
    public  LinkedHashMap(Map<? extends K, ? extends V> map) {
        this(map.size());
        addTaint(map.getTaint());
        putAll(map);
        // ---------- Original Method ----------
        //constructorPutAll(map);
    }

    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.730 -0400", hash_original_method = "EB729947D8C5A87C341C9E9026AB1206", hash_generated_method = "71584A9A86768B59927AB36E65973CE0")
    public Entry<K, V> eldest() {
        HashSet<Entry<K,V>> set = (HashSet<Entry<K,V>>)super.getEntrySet();
        Entry<K,V> entry = set.getFirstElement();
        entry.addTaint(getTaint());
        return entry;
        // ---------- Original Method ----------
        //LinkedEntry<K, V> eldest = header.nxt;
        //return eldest != header ? eldest : null;
    }

    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.737 -0400", hash_original_method = "F4EE8618F7DE6E7966D8D47C993C665B", hash_generated_method = "1EEB337668D8491541D42D67AA524259")
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        addTaint(eldest.getTaint());
        getEntrySet().remove(eldest);
        return getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }
    
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:09.740 -0400", hash_original_field = "F2C3C5ED4469A7ACAFC202E4DC767981", hash_generated_field = "58143BDD5D2BB4E9A1A5E401127BE552")

    private static final long serialVersionUID = 3801124242820219131L;
}

