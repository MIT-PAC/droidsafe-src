package java.lang;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocal<T> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.377 -0400", hash_original_field = "426DC84987C4B2179AAC3652CD9F0630", hash_generated_field = "E19C4AFB9937521DCDC693F15C42E2A7")

    private final Reference<ThreadLocal<T>> reference = new WeakReference<ThreadLocal<T>>(this);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.377 -0400", hash_original_field = "2D91048F537A2D73A5B9E4039D2A22B5", hash_generated_field = "B643A854DCD11F044BA6D1951F01CE6B")

    private final int hash = hashCounter.getAndAdd(0x61c88647 * 2);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.377 -0400", hash_original_method = "CCBA978684365F19FBD68BD48C79C23F", hash_generated_method = "A892989B2AACDC92217F9E3C26407114")
    public  ThreadLocal() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.378 -0400", hash_original_method = "17AB1D63AD8B7EADE4880D6FD1744965", hash_generated_method = "C9AF28DA5DAF289D4ACF0E1118F516FD")
    @SuppressWarnings("unchecked")
    public T get() {
        T varB4EAC82CA7396A68D541C85D26508E83_1109647217 = null; 
        T varB4EAC82CA7396A68D541C85D26508E83_117938135 = null; 
        Thread currentThread = Thread.currentThread();
        Values values = values(currentThread);
        {
            Object[] table = values.table;
            int index = hash & values.mask;
            {
                varB4EAC82CA7396A68D541C85D26508E83_1109647217 = (T) table[index + 1];
            } 
        } 
        {
            values = initializeValues(currentThread);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_117938135 = (T) values.getAfterMiss(this);
        T varA7E53CE21691AB073D9660D615818899_1317553300; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1317553300 = varB4EAC82CA7396A68D541C85D26508E83_1109647217;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1317553300 = varB4EAC82CA7396A68D541C85D26508E83_117938135;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1317553300.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1317553300;
        
        
        
        
            
            
            
                
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.378 -0400", hash_original_method = "65001977AEEFEE3DB28BF88E33FB8DD1", hash_generated_method = "3215CC40816123D344853A1894140964")
    protected T initialValue() {
        T varB4EAC82CA7396A68D541C85D26508E83_181460532 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_181460532 = null;
        varB4EAC82CA7396A68D541C85D26508E83_181460532.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_181460532;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.378 -0400", hash_original_method = "93D51722B7CB3C8EF0C38EE234F866B9", hash_generated_method = "C6285F78F249AE0D0B20CEF57E524CB2")
    public void set(T value) {
        Thread currentThread = Thread.currentThread();
        Values values = values(currentThread);
        {
            values = initializeValues(currentThread);
        } 
        values.put(this, value);
        addTaint(value.getTaint());
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.378 -0400", hash_original_method = "E12F04AD7D9687B33AD1C273DE0809EB", hash_generated_method = "96AE536EC9B24531901259632C7BB069")
    public void remove() {
        Thread currentThread = Thread.currentThread();
        Values values = values(currentThread);
        {
            values.remove(this);
        } 
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.379 -0400", hash_original_method = "F6756F2BA503B7A43E41A22536745AD1", hash_generated_method = "89ABD112F7785AF2B25579F48703EED9")
     Values initializeValues(Thread current) {
        Values varB4EAC82CA7396A68D541C85D26508E83_1167832317 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1167832317 = current.localValues = new Values();
        addTaint(current.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1167832317.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1167832317;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.379 -0400", hash_original_method = "303C743BABF91BBE1D2B949725040AC0", hash_generated_method = "1385597D92C37614AA6B4981A7074875")
     Values values(Thread current) {
        Values varB4EAC82CA7396A68D541C85D26508E83_1636084739 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1636084739 = current.localValues;
        addTaint(current.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1636084739.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1636084739;
        
        
    }

    
    static class Values {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.379 -0400", hash_original_field = "AAB9E1DE16F38176F86D7A92BA337A8D", hash_generated_field = "FD72DCEA1BA087F9DFD15C7A360AA526")

        private Object[] table;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.379 -0400", hash_original_field = "F2CE11EBF110993621BEDD8E747D7B1B", hash_generated_field = "CB9C3356548F555F843424D7B01932DE")

        private int mask;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.379 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

        private int size;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.379 -0400", hash_original_field = "F665DDFDFDD1E28A26618501F76D7106", hash_generated_field = "97BD139A14B9108FDB72C084E57FF305")

        private int tombstones;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.379 -0400", hash_original_field = "41A009FBDA3ED027F977216A29F00D00", hash_generated_field = "84B0D7BDAD4BEF6EA743B0D3D294E91E")

        private int maximumLoad;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.379 -0400", hash_original_field = "123402C04DCFB6625F688F771A5FC05D", hash_generated_field = "D443419CB814AFCD3668DE2EA3A4C6CB")

        private int clean;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.380 -0400", hash_original_method = "8603CA8C8DA2F2A8742D0D3D57F85A73", hash_generated_method = "0F4D9E6506A7695CFEA2C062F4777A67")
          Values() {
            initializeTable(INITIAL_SIZE);
            this.size = 0;
            this.tombstones = 0;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.381 -0400", hash_original_method = "1543F2E70FF0D503FC0C174797134204", hash_generated_method = "F7721AC4BA5FF82A1C46E64C289CD04E")
          Values(Values fromParent) {
            this.table = fromParent.table.clone();
            this.mask = fromParent.mask;
            this.size = fromParent.size;
            this.tombstones = fromParent.tombstones;
            this.maximumLoad = fromParent.maximumLoad;
            this.clean = fromParent.clean;
            inheritValues(fromParent);
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.383 -0400", hash_original_method = "9BD4203D3E5EBD7464FA7B2A4E6BD9E0", hash_generated_method = "3223D10FE071277AEEDB4AA51AEA7B9B")
        @SuppressWarnings({"unchecked"})
        private void inheritValues(Values fromParent) {
            Object[] table = this.table;
            {
                int i = table.length - 2;
                i -= 2;
                {
                    Object k = table[i];
                    Reference<InheritableThreadLocal<?>> reference = (Reference<InheritableThreadLocal<?>>) k;
                    InheritableThreadLocal key = reference.get();
                    {
                        table[i + 1] = key.childValue(fromParent.table[i + 1]);
                    } 
                    {
                        table[i] = TOMBSTONE;
                        table[i + 1] = null;
                        fromParent.table[i] = TOMBSTONE;
                        fromParent.table[i + 1] = null;
                    } 
                } 
            } 
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.384 -0400", hash_original_method = "8D46CF6663407215221C449D596ED15A", hash_generated_method = "C7EB45EBDA4EAA513131B1354BE102DF")
        private void initializeTable(int capacity) {
            this.table = new Object[capacity * 2];
            this.mask = table.length - 1;
            this.clean = 0;
            this.maximumLoad = capacity * 2 / 3;
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.386 -0400", hash_original_method = "9C8BB7874FA14669E3E1A4855CFECE2B", hash_generated_method = "F243C9E0CCA96CF40C57E41ACED3CE80")
        private void cleanUp() {
            {
                boolean var11013A33888A8BC57FF439A64A6EF186_1903976220 = (rehash());
            } 
            int index = clean;
            Object[] table = this.table;
            {
                int counter = table.length;
                counter >>= 1;
                index = next(index);
                {
                    Object k = table[index];
                    @SuppressWarnings("unchecked") Reference<ThreadLocal<?>> reference = (Reference<ThreadLocal<?>>) k;
                    {
                        boolean var5DDBB567418B6E5B7055803AF7D32404_1957382298 = (reference.get() == null);
                        {
                            table[index] = TOMBSTONE;
                            table[index + 1] = null;
                        } 
                    } 
                } 
            } 
            clean = index;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.387 -0400", hash_original_method = "D5329B07F2A83D8B781C7C8F5FD2D30A", hash_generated_method = "5F3E704EDAE9D0F682A3252D916605A7")
        private boolean rehash() {
            int capacity = table.length >> 1;
            int newCapacity = capacity;
            {
                newCapacity = capacity * 2;
            } 
            Object[] oldTable = this.table;
            initializeTable(newCapacity);
            this.tombstones = 0;
            {
                int i = oldTable.length - 2;
                i -= 2;
                {
                    Object k = oldTable[i];
                    @SuppressWarnings("unchecked") Reference<ThreadLocal<?>> reference = (Reference<ThreadLocal<?>>) k;
                    ThreadLocal<?> key = reference.get();
                    {
                        add(key, oldTable[i + 1]);
                    } 
                } 
            } 
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_645026373 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_645026373;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.388 -0400", hash_original_method = "8FD2790587F2719E68EBC052DE90327C", hash_generated_method = "3E8212DE95AA1F2FC4F8F3682EC860EB")
         void add(ThreadLocal<?> key, Object value) {
            {
                int index = key.hash & mask;
                index = next(index);
                {
                    Object k = table[index];
                    {
                        table[index] = key.reference;
                        table[index + 1] = value;
                    } 
                } 
            } 
            
            
                
                
                    
                    
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.388 -0400", hash_original_method = "F7F8B7C8923C08ADEC94E7E7276E0E2F", hash_generated_method = "B5CB4AA0F2EFE5E541604C6DC0461CBD")
         void put(ThreadLocal<?> key, Object value) {
            cleanUp();
            int firstTombstone = -1;
            {
                int index = key.hash & mask;
                index = next(index);
                {
                    Object k = table[index];
                    {
                        table[index + 1] = value;
                    } 
                    {
                        {
                            table[index] = key.reference;
                            table[index + 1] = value;
                        } 
                        table[firstTombstone] = key.reference;
                        table[firstTombstone + 1] = value;
                    } 
                    {
                        firstTombstone = index;
                    } 
                } 
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.390 -0400", hash_original_method = "27C70593962E283B71D24D73AE4C9368", hash_generated_method = "6CD8BCBD01E74AAAC7FA3AEC592F8389")
         Object getAfterMiss(ThreadLocal<?> key) {
            Object varB4EAC82CA7396A68D541C85D26508E83_1482922841 = null; 
            Object varB4EAC82CA7396A68D541C85D26508E83_1410609496 = null; 
            Object varB4EAC82CA7396A68D541C85D26508E83_1501884743 = null; 
            Object varB4EAC82CA7396A68D541C85D26508E83_2135851924 = null; 
            Object varB4EAC82CA7396A68D541C85D26508E83_1253707107 = null; 
            Object varB4EAC82CA7396A68D541C85D26508E83_2046137459 = null; 
            Object[] table = this.table;
            int index = key.hash & mask;
            {
                Object value = key.initialValue();
                {
                    table[index] = key.reference;
                    table[index + 1] = value;
                    cleanUp();
                    varB4EAC82CA7396A68D541C85D26508E83_1482922841 = value;
                } 
                put(key, value);
                varB4EAC82CA7396A68D541C85D26508E83_1410609496 = value;
            } 
            int firstTombstone = -1;
            {
                index = next(index);
                index = next(index);
                {
                    Object reference = table[index];
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1501884743 = table[index + 1];
                    } 
                    {
                        Object value = key.initialValue();
                        {
                            {
                                table[firstTombstone] = key.reference;
                                table[firstTombstone + 1] = value;
                                varB4EAC82CA7396A68D541C85D26508E83_2135851924 = value;
                            } 
                            {
                                table[index] = key.reference;
                                table[index + 1] = value;
                                cleanUp();
                                varB4EAC82CA7396A68D541C85D26508E83_1253707107 = value;
                            } 
                        } 
                        put(key, value);
                        varB4EAC82CA7396A68D541C85D26508E83_2046137459 = value;
                    } 
                    {
                        firstTombstone = index;
                    } 
                } 
            } 
            Object varA7E53CE21691AB073D9660D615818899_335068492; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_335068492 = varB4EAC82CA7396A68D541C85D26508E83_1482922841;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_335068492 = varB4EAC82CA7396A68D541C85D26508E83_1410609496;
                    break;
                case 3: 
                    varA7E53CE21691AB073D9660D615818899_335068492 = varB4EAC82CA7396A68D541C85D26508E83_1501884743;
                    break;
                case 4: 
                    varA7E53CE21691AB073D9660D615818899_335068492 = varB4EAC82CA7396A68D541C85D26508E83_2135851924;
                    break;
                case 5: 
                    varA7E53CE21691AB073D9660D615818899_335068492 = varB4EAC82CA7396A68D541C85D26508E83_1253707107;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_335068492 = varB4EAC82CA7396A68D541C85D26508E83_2046137459;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_335068492.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_335068492;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.391 -0400", hash_original_method = "0360B175C51ABE1598A686E1C95592B6", hash_generated_method = "1581EC5B0E9CD55A7899470DEDB1179C")
         void remove(ThreadLocal<?> key) {
            cleanUp();
            {
                int index = key.hash & mask;
                index = next(index);
                {
                    Object reference = table[index];
                    {
                        table[index] = TOMBSTONE;
                        table[index + 1] = null;
                    } 
                } 
            } 
            addTaint(key.getTaint());
            
            
            
                
                
                    
                    
                    
                    
                    
                
                
                    
                
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.392 -0400", hash_original_method = "A1B9AE6202C436A7C194238B45D86066", hash_generated_method = "28B065286D5BB9178BEBFA6FFB382A51")
        private int next(int index) {
            addTaint(index);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_238520779 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_238520779;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.392 -0400", hash_original_field = "DA9469906E1F2A2491D3A90AD3EDBF47", hash_generated_field = "FC71C8361E3E0D880F15510AF5EACDF8")

        private static final int INITIAL_SIZE = 16;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.392 -0400", hash_original_field = "7FF9D9BF98FB0E986E1BEB357C0948A3", hash_generated_field = "AB47CE0D72E31CB661DFF9FA386FCB35")

        private static final Object TOMBSTONE = new Object();
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.392 -0400", hash_original_field = "4E607393E03575F758B020F7E9FA37D7", hash_generated_field = "D0904C715877D79D507857C3DBB2EE5E")

    private static AtomicInteger hashCounter = new AtomicInteger(0);
}

