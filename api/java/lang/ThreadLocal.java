package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocal<T> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.570 -0400", hash_original_field = "426DC84987C4B2179AAC3652CD9F0630", hash_generated_field = "E19C4AFB9937521DCDC693F15C42E2A7")

    private final Reference<ThreadLocal<T>> reference = new WeakReference<ThreadLocal<T>>(this);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.570 -0400", hash_original_field = "2D91048F537A2D73A5B9E4039D2A22B5", hash_generated_field = "B643A854DCD11F044BA6D1951F01CE6B")

    private final int hash = hashCounter.getAndAdd(0x61c88647 * 2);
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.571 -0400", hash_original_method = "CCBA978684365F19FBD68BD48C79C23F", hash_generated_method = "A892989B2AACDC92217F9E3C26407114")
    public  ThreadLocal() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.571 -0400", hash_original_method = "17AB1D63AD8B7EADE4880D6FD1744965", hash_generated_method = "DB375446CD45C419BAE9E10F9ACFE7B7")
    @SuppressWarnings("unchecked")
    public T get() {
        Thread currentThread = Thread.currentThread();
        Values values = values(currentThread);
        if(values != null)        
        {
            Object[] table = values.table;
            int index = hash & values.mask;
            if(this.reference == table[index])            
            {
T var9970D4A3573A4344C3E661AA6C50079B_1605452362 =                 (T) table[index + 1];
                var9970D4A3573A4344C3E661AA6C50079B_1605452362.addTaint(taint);
                return var9970D4A3573A4344C3E661AA6C50079B_1605452362;
            } //End block
        } //End block
        else
        {
            values = initializeValues(currentThread);
        } //End block
T var118A24DDA3996835C16B7CD567861DDA_133760240 =         (T) values.getAfterMiss(this);
        var118A24DDA3996835C16B7CD567861DDA_133760240.addTaint(taint);
        return var118A24DDA3996835C16B7CD567861DDA_133760240;
        // ---------- Original Method ----------
        //Thread currentThread = Thread.currentThread();
        //Values values = values(currentThread);
        //if (values != null) {
            //Object[] table = values.table;
            //int index = hash & values.mask;
            //if (this.reference == table[index]) {
                //return (T) table[index + 1];
            //}
        //} else {
            //values = initializeValues(currentThread);
        //}
        //return (T) values.getAfterMiss(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.572 -0400", hash_original_method = "65001977AEEFEE3DB28BF88E33FB8DD1", hash_generated_method = "16AE615B2449DE60313CA0EA10BB30B3")
    protected T initialValue() {
T var540C13E9E156B687226421B24F2DF178_825544989 =         null;
        var540C13E9E156B687226421B24F2DF178_825544989.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_825544989;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.572 -0400", hash_original_method = "93D51722B7CB3C8EF0C38EE234F866B9", hash_generated_method = "B84BF9B7A80E78478B3BF914CB380E6C")
    public void set(T value) {
        addTaint(value.getTaint());
        Thread currentThread = Thread.currentThread();
        Values values = values(currentThread);
        if(values == null)        
        {
            values = initializeValues(currentThread);
        } //End block
        values.put(this, value);
        // ---------- Original Method ----------
        //Thread currentThread = Thread.currentThread();
        //Values values = values(currentThread);
        //if (values == null) {
            //values = initializeValues(currentThread);
        //}
        //values.put(this, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.573 -0400", hash_original_method = "E12F04AD7D9687B33AD1C273DE0809EB", hash_generated_method = "A14A226AF2819BF3400FDF5EDD63BABE")
    public void remove() {
        Thread currentThread = Thread.currentThread();
        Values values = values(currentThread);
        if(values != null)        
        {
            values.remove(this);
        } //End block
        // ---------- Original Method ----------
        //Thread currentThread = Thread.currentThread();
        //Values values = values(currentThread);
        //if (values != null) {
            //values.remove(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.573 -0400", hash_original_method = "F6756F2BA503B7A43E41A22536745AD1", hash_generated_method = "6C3F0940472BAD8A50C865E14B6FFEEE")
     Values initializeValues(Thread current) {
        addTaint(current.getTaint());
Values varDD5B551295F7C93CAA721FF5B869F41E_406192561 =         current.localValues = new Values();
        varDD5B551295F7C93CAA721FF5B869F41E_406192561.addTaint(taint);
        return varDD5B551295F7C93CAA721FF5B869F41E_406192561;
        // ---------- Original Method ----------
        //return current.localValues = new Values();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.573 -0400", hash_original_method = "303C743BABF91BBE1D2B949725040AC0", hash_generated_method = "2652D6D7D05B6BC7928228BDE3FB4900")
     Values values(Thread current) {
        addTaint(current.getTaint());
Values var1FEE96EDD34FFCA0D4CE1EAE7413BA9A_1338540838 =         current.localValues;
        var1FEE96EDD34FFCA0D4CE1EAE7413BA9A_1338540838.addTaint(taint);
        return var1FEE96EDD34FFCA0D4CE1EAE7413BA9A_1338540838;
        // ---------- Original Method ----------
        //return current.localValues;
    }

    
    static class Values {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.574 -0400", hash_original_field = "AAB9E1DE16F38176F86D7A92BA337A8D", hash_generated_field = "FD72DCEA1BA087F9DFD15C7A360AA526")

        private Object[] table;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.574 -0400", hash_original_field = "F2CE11EBF110993621BEDD8E747D7B1B", hash_generated_field = "CB9C3356548F555F843424D7B01932DE")

        private int mask;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.574 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

        private int size;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.574 -0400", hash_original_field = "F665DDFDFDD1E28A26618501F76D7106", hash_generated_field = "97BD139A14B9108FDB72C084E57FF305")

        private int tombstones;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.575 -0400", hash_original_field = "41A009FBDA3ED027F977216A29F00D00", hash_generated_field = "84B0D7BDAD4BEF6EA743B0D3D294E91E")

        private int maximumLoad;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.575 -0400", hash_original_field = "123402C04DCFB6625F688F771A5FC05D", hash_generated_field = "D443419CB814AFCD3668DE2EA3A4C6CB")

        private int clean;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.575 -0400", hash_original_method = "8603CA8C8DA2F2A8742D0D3D57F85A73", hash_generated_method = "0F4D9E6506A7695CFEA2C062F4777A67")
          Values() {
            initializeTable(INITIAL_SIZE);
            this.size = 0;
            this.tombstones = 0;
            // ---------- Original Method ----------
            //initializeTable(INITIAL_SIZE);
            //this.size = 0;
            //this.tombstones = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.577 -0400", hash_original_method = "1543F2E70FF0D503FC0C174797134204", hash_generated_method = "F7721AC4BA5FF82A1C46E64C289CD04E")
          Values(Values fromParent) {
            this.table = fromParent.table.clone();
            this.mask = fromParent.mask;
            this.size = fromParent.size;
            this.tombstones = fromParent.tombstones;
            this.maximumLoad = fromParent.maximumLoad;
            this.clean = fromParent.clean;
            inheritValues(fromParent);
            // ---------- Original Method ----------
            //this.table = fromParent.table.clone();
            //this.mask = fromParent.mask;
            //this.size = fromParent.size;
            //this.tombstones = fromParent.tombstones;
            //this.maximumLoad = fromParent.maximumLoad;
            //this.clean = fromParent.clean;
            //inheritValues(fromParent);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.579 -0400", hash_original_method = "9BD4203D3E5EBD7464FA7B2A4E6BD9E0", hash_generated_method = "379E049E21CBC2DE337CB3BE0A2DB8BC")
        @SuppressWarnings({"unchecked"})
        private void inheritValues(Values fromParent) {
            Object[] table = this.table;
for(int i = table.length - 2;i >= 0;i -= 2)
            {
                Object k = table[i];
                if(k == null || k == TOMBSTONE)                
                {
                    continue;
                } //End block
                Reference<InheritableThreadLocal<?>> reference = (Reference<InheritableThreadLocal<?>>) k;
                InheritableThreadLocal key = reference.get();
                if(key != null)                
                {
                    table[i + 1] = key.childValue(fromParent.table[i + 1]);
                } //End block
                else
                {
                    table[i] = TOMBSTONE;
                    table[i + 1] = null;
                    fromParent.table[i] = TOMBSTONE;
                    fromParent.table[i + 1] = null;
                    tombstones++;
                    fromParent.tombstones++;
                    size--;
                    fromParent.size--;
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.581 -0400", hash_original_method = "8D46CF6663407215221C449D596ED15A", hash_generated_method = "C7EB45EBDA4EAA513131B1354BE102DF")
        private void initializeTable(int capacity) {
            this.table = new Object[capacity * 2];
            this.mask = table.length - 1;
            this.clean = 0;
            this.maximumLoad = capacity * 2 / 3;
            // ---------- Original Method ----------
            //this.table = new Object[capacity * 2];
            //this.mask = table.length - 1;
            //this.clean = 0;
            //this.maximumLoad = capacity * 2 / 3;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.583 -0400", hash_original_method = "9C8BB7874FA14669E3E1A4855CFECE2B", hash_generated_method = "EA2CD0921D8A0BFC314FC53447F193A3")
        private void cleanUp() {
            if(rehash())            
            {
                return;
            } //End block
            if(size == 0)            
            {
                return;
            } //End block
            int index = clean;
            Object[] table = this.table;
for(int counter = table.length;counter > 0;counter >>= 1,index = next(index))
            {
                Object k = table[index];
                if(k == TOMBSTONE || k == null)                
                {
                    continue;
                } //End block
                @SuppressWarnings("unchecked") Reference<ThreadLocal<?>> reference = (Reference<ThreadLocal<?>>) k;
                if(reference.get() == null)                
                {
                    table[index] = TOMBSTONE;
                    table[index + 1] = null;
                    tombstones++;
                    size--;
                } //End block
            } //End block
            clean = index;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.585 -0400", hash_original_method = "D5329B07F2A83D8B781C7C8F5FD2D30A", hash_generated_method = "52D56192824852B32E18F20CB4F6E2BD")
        private boolean rehash() {
            if(tombstones + size < maximumLoad)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1699888602 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1980319989 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1980319989;
            } //End block
            int capacity = table.length >> 1;
            int newCapacity = capacity;
            if(size > (capacity >> 1))            
            {
                newCapacity = capacity * 2;
            } //End block
            Object[] oldTable = this.table;
            initializeTable(newCapacity);
            this.tombstones = 0;
            if(size == 0)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_516518402 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1163153529 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1163153529;
            } //End block
for(int i = oldTable.length - 2;i >= 0;i -= 2)
            {
                Object k = oldTable[i];
                if(k == null || k == TOMBSTONE)                
                {
                    continue;
                } //End block
                @SuppressWarnings("unchecked") Reference<ThreadLocal<?>> reference = (Reference<ThreadLocal<?>>) k;
                ThreadLocal<?> key = reference.get();
                if(key != null)                
                {
                    add(key, oldTable[i + 1]);
                } //End block
                else
                {
                    size--;
                } //End block
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1451288270 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2033944454 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2033944454;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.586 -0400", hash_original_method = "8FD2790587F2719E68EBC052DE90327C", hash_generated_method = "E62CC5EF7AA1C7DD16254B6AE78605A9")
         void add(ThreadLocal<?> key, Object value) {
for(int index = key.hash & mask;;index = next(index))
            {
                Object k = table[index];
                if(k == null)                
                {
                    table[index] = key.reference;
                    table[index + 1] = value;
                    return;
                } //End block
            } //End block
            // ---------- Original Method ----------
            //for (int index = key.hash & mask;; index = next(index)) {
                //Object k = table[index];
                //if (k == null) {
                    //table[index] = key.reference;
                    //table[index + 1] = value;
                    //return;
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.587 -0400", hash_original_method = "F7F8B7C8923C08ADEC94E7E7276E0E2F", hash_generated_method = "3D20AB52033DCF442222D2199DDFB962")
         void put(ThreadLocal<?> key, Object value) {
            cleanUp();
            int firstTombstone = -1;
for(int index = key.hash & mask;;index = next(index))
            {
                Object k = table[index];
                if(k == key.reference)                
                {
                    table[index + 1] = value;
                    return;
                } //End block
                if(k == null)                
                {
                    if(firstTombstone == -1)                    
                    {
                        table[index] = key.reference;
                        table[index + 1] = value;
                        size++;
                        return;
                    } //End block
                    table[firstTombstone] = key.reference;
                    table[firstTombstone + 1] = value;
                    tombstones--;
                    size++;
                    return;
                } //End block
                if(firstTombstone == -1 && k == TOMBSTONE)                
                {
                    firstTombstone = index;
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.588 -0400", hash_original_method = "27C70593962E283B71D24D73AE4C9368", hash_generated_method = "96E3FE28FCBAAB4D226B4FDE3130C05C")
         Object getAfterMiss(ThreadLocal<?> key) {
            Object[] table = this.table;
            int index = key.hash & mask;
            if(table[index] == null)            
            {
                Object value = key.initialValue();
                if(this.table == table && table[index] == null)                
                {
                    table[index] = key.reference;
                    table[index + 1] = value;
                    size++;
                    cleanUp();
Object varAF280DA2BC37D8BE783D8499160168DE_163827339 =                     value;
                    varAF280DA2BC37D8BE783D8499160168DE_163827339.addTaint(taint);
                    return varAF280DA2BC37D8BE783D8499160168DE_163827339;
                } //End block
                put(key, value);
Object varAF280DA2BC37D8BE783D8499160168DE_227067233 =                 value;
                varAF280DA2BC37D8BE783D8499160168DE_227067233.addTaint(taint);
                return varAF280DA2BC37D8BE783D8499160168DE_227067233;
            } //End block
            int firstTombstone = -1;
for(index = next(index);;index = next(index))
            {
                Object reference = table[index];
                if(reference == key.reference)                
                {
Object varD4194754A17F2690B3CAEDCBB197DB14_996159275 =                     table[index + 1];
                    varD4194754A17F2690B3CAEDCBB197DB14_996159275.addTaint(taint);
                    return varD4194754A17F2690B3CAEDCBB197DB14_996159275;
                } //End block
                if(reference == null)                
                {
                    Object value = key.initialValue();
                    if(this.table == table)                    
                    {
                        if(firstTombstone > -1
                                && table[firstTombstone] == TOMBSTONE)                        
                        {
                            table[firstTombstone] = key.reference;
                            table[firstTombstone + 1] = value;
                            tombstones--;
                            size++;
Object varAF280DA2BC37D8BE783D8499160168DE_598471577 =                             value;
                            varAF280DA2BC37D8BE783D8499160168DE_598471577.addTaint(taint);
                            return varAF280DA2BC37D8BE783D8499160168DE_598471577;
                        } //End block
                        if(table[index] == null)                        
                        {
                            table[index] = key.reference;
                            table[index + 1] = value;
                            size++;
                            cleanUp();
Object varAF280DA2BC37D8BE783D8499160168DE_1575597174 =                             value;
                            varAF280DA2BC37D8BE783D8499160168DE_1575597174.addTaint(taint);
                            return varAF280DA2BC37D8BE783D8499160168DE_1575597174;
                        } //End block
                    } //End block
                    put(key, value);
Object varAF280DA2BC37D8BE783D8499160168DE_491885437 =                     value;
                    varAF280DA2BC37D8BE783D8499160168DE_491885437.addTaint(taint);
                    return varAF280DA2BC37D8BE783D8499160168DE_491885437;
                } //End block
                if(firstTombstone == -1 && reference == TOMBSTONE)                
                {
                    firstTombstone = index;
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.590 -0400", hash_original_method = "0360B175C51ABE1598A686E1C95592B6", hash_generated_method = "978540942665A6ED3922A2985BB0FD65")
         void remove(ThreadLocal<?> key) {
            addTaint(key.getTaint());
            cleanUp();
for(int index = key.hash & mask;;index = next(index))
            {
                Object reference = table[index];
                if(reference == key.reference)                
                {
                    table[index] = TOMBSTONE;
                    table[index + 1] = null;
                    tombstones++;
                    size--;
                    return;
                } //End block
                if(reference == null)                
                {
                    return;
                } //End block
            } //End block
            // ---------- Original Method ----------
            //cleanUp();
            //for (int index = key.hash & mask;; index = next(index)) {
                //Object reference = table[index];
                //if (reference == key.reference) {
                    //table[index] = TOMBSTONE;
                    //table[index + 1] = null;
                    //tombstones++;
                    //size--;
                    //return;
                //}
                //if (reference == null) {
                    //return;
                //}
            //}
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.590 -0400", hash_original_method = "A1B9AE6202C436A7C194238B45D86066", hash_generated_method = "F58CC3BF68255592FF21F5E76AA23B62")
        private int next(int index) {
            addTaint(index);
            int var893A2141F64F7BF774008DBF6E57D059_766775793 = ((index + 2) & mask);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_845601852 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_845601852;
            // ---------- Original Method ----------
            //return (index + 2) & mask;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.590 -0400", hash_original_field = "DA9469906E1F2A2491D3A90AD3EDBF47", hash_generated_field = "FC71C8361E3E0D880F15510AF5EACDF8")

        private static final int INITIAL_SIZE = 16;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.590 -0400", hash_original_field = "7FF9D9BF98FB0E986E1BEB357C0948A3", hash_generated_field = "AB47CE0D72E31CB661DFF9FA386FCB35")

        private static final Object TOMBSTONE = new Object();
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.591 -0400", hash_original_field = "4E607393E03575F758B020F7E9FA37D7", hash_generated_field = "D0904C715877D79D507857C3DBB2EE5E")

    private static AtomicInteger hashCounter = new AtomicInteger(0);
}

