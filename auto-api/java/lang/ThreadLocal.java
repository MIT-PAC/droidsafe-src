package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocal<T> {
    private Reference<ThreadLocal<T>> reference
            = new WeakReference<ThreadLocal<T>>(this);
    private int hash = hashCounter.getAndAdd(0x61c88647 * 2);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.499 -0400", hash_original_method = "CCBA978684365F19FBD68BD48C79C23F", hash_generated_method = "A892989B2AACDC92217F9E3C26407114")
    @DSModeled(DSC.SAFE)
    public ThreadLocal() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.499 -0400", hash_original_method = "17AB1D63AD8B7EADE4880D6FD1744965", hash_generated_method = "40AE4ABAB16300A9AF8A727D7AD7F312")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public T get() {
        Thread currentThread;
        currentThread = Thread.currentThread();
        Values values;
        values = values(currentThread);
        {
            Object[] table;
            table = values.table;
            int index;
            index = hash & values.mask;
        } //End block
        {
            values = initializeValues(currentThread);
        } //End block
        T varABD53C04055F2D6192FFF4F184B68AC2_1207321511 = ((T) values.getAfterMiss(this));
        return (T)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.499 -0400", hash_original_method = "65001977AEEFEE3DB28BF88E33FB8DD1", hash_generated_method = "2D40A47D2DE841D95904E50F2CEAD9D9")
    @DSModeled(DSC.SAFE)
    protected T initialValue() {
        return (T)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.500 -0400", hash_original_method = "93D51722B7CB3C8EF0C38EE234F866B9", hash_generated_method = "E1FA37083078C0C2EFD6352E4ADAF8B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void set(T value) {
        dsTaint.addTaint(value.dsTaint);
        Thread currentThread;
        currentThread = Thread.currentThread();
        Values values;
        values = values(currentThread);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.500 -0400", hash_original_method = "E12F04AD7D9687B33AD1C273DE0809EB", hash_generated_method = "50DDBD2D144DB8649B8B5B9641348108")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void remove() {
        Thread currentThread;
        currentThread = Thread.currentThread();
        Values values;
        values = values(currentThread);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.509 -0400", hash_original_method = "F6756F2BA503B7A43E41A22536745AD1", hash_generated_method = "2E56ABC18C13EBA76094798D4FCC366F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Values initializeValues(Thread current) {
        dsTaint.addTaint(current.dsTaint);
        Values varC56BCAFCB27C4A8A67863A06E2F47B50_1630198566 = (current.localValues = new Values());
        return (Values)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return current.localValues = new Values();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.509 -0400", hash_original_method = "303C743BABF91BBE1D2B949725040AC0", hash_generated_method = "E15047F8742FCDC8D5DEF6217A43EE7B")
    @DSModeled(DSC.SAFE)
     Values values(Thread current) {
        dsTaint.addTaint(current.dsTaint);
        return (Values)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return current.localValues;
    }

    
    static class Values {
        private Object[] table;
        private int mask;
        private int size;
        private int tombstones;
        private int maximumLoad;
        private int clean;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.509 -0400", hash_original_method = "8603CA8C8DA2F2A8742D0D3D57F85A73", hash_generated_method = "0F4D9E6506A7695CFEA2C062F4777A67")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Values() {
            initializeTable(INITIAL_SIZE);
            this.size = 0;
            this.tombstones = 0;
            // ---------- Original Method ----------
            //initializeTable(INITIAL_SIZE);
            //this.size = 0;
            //this.tombstones = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.518 -0400", hash_original_method = "1543F2E70FF0D503FC0C174797134204", hash_generated_method = "8B9D9531933C3D00804224F09C298ECF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Values(Values fromParent) {
            dsTaint.addTaint(fromParent.dsTaint);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.519 -0400", hash_original_method = "9BD4203D3E5EBD7464FA7B2A4E6BD9E0", hash_generated_method = "64A6A261C0D8F964C373677AB56CE242")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings({"unchecked"})
        private void inheritValues(Values fromParent) {
            dsTaint.addTaint(fromParent.dsTaint);
            Object[] table;
            table = this.table;
            {
                int i;
                i = table.length - 2;
                i -= 2;
                {
                    Object k;
                    k = table[i];
                    Reference<InheritableThreadLocal<?>> reference;
                    reference = (Reference<InheritableThreadLocal<?>>) k;
                    InheritableThreadLocal key;
                    key = reference.get();
                    {
                        table[i + 1] = key.childValue(fromParent.table[i + 1]);
                    } //End block
                    {
                        table[i] = TOMBSTONE;
                        table[i + 1] = null;
                        fromParent.table[i] = TOMBSTONE;
                        fromParent.table[i + 1] = null;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.519 -0400", hash_original_method = "8D46CF6663407215221C449D596ED15A", hash_generated_method = "923CA19D468F2E8ED41C77EB8DD6756A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void initializeTable(int capacity) {
            dsTaint.addTaint(capacity);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.521 -0400", hash_original_method = "9C8BB7874FA14669E3E1A4855CFECE2B", hash_generated_method = "6F53CABBD41629C90AD7BCABE1B8BAC2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void cleanUp() {
            {
                boolean var11013A33888A8BC57FF439A64A6EF186_570539370 = (rehash());
            } //End collapsed parenthetic
            int index;
            index = clean;
            Object[] table;
            table = this.table;
            {
                int counter;
                counter = table.length;
                counter >>= 1;
                index = next(index);
                {
                    Object k;
                    k = table[index];
                    @SuppressWarnings("unchecked") Reference<ThreadLocal<?>> reference;
                    reference = (Reference<ThreadLocal<?>>) k;
                    {
                        boolean var5DDBB567418B6E5B7055803AF7D32404_192058148 = (reference.get() == null);
                        {
                            table[index] = TOMBSTONE;
                            table[index + 1] = null;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            clean = index;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.522 -0400", hash_original_method = "D5329B07F2A83D8B781C7C8F5FD2D30A", hash_generated_method = "8BAF4B7773876A50FDA2F4499B2F13E8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private boolean rehash() {
            int capacity;
            capacity = table.length >> 1;
            int newCapacity;
            newCapacity = capacity;
            {
                newCapacity = capacity * 2;
            } //End block
            Object[] oldTable;
            oldTable = this.table;
            initializeTable(newCapacity);
            this.tombstones = 0;
            {
                int i;
                i = oldTable.length - 2;
                i -= 2;
                {
                    Object k;
                    k = oldTable[i];
                    @SuppressWarnings("unchecked") Reference<ThreadLocal<?>> reference;
                    reference = (Reference<ThreadLocal<?>>) k;
                    ThreadLocal<?> key;
                    key = reference.get();
                    {
                        add(key, oldTable[i + 1]);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.522 -0400", hash_original_method = "8FD2790587F2719E68EBC052DE90327C", hash_generated_method = "AC7B85C77A1B2A9915073C8582762272")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void add(ThreadLocal<?> key, Object value) {
            dsTaint.addTaint(value.dsTaint);
            dsTaint.addTaint(key.dsTaint);
            {
                int index;
                index = key.hash & mask;
                index = next(index);
                {
                    Object k;
                    k = table[index];
                    {
                        table[index] = key.reference;
                        table[index + 1] = value;
                    } //End block
                } //End block
            } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.523 -0400", hash_original_method = "F7F8B7C8923C08ADEC94E7E7276E0E2F", hash_generated_method = "44FC60AFF297B011FCB566173C1924B5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void put(ThreadLocal<?> key, Object value) {
            dsTaint.addTaint(value.dsTaint);
            dsTaint.addTaint(key.dsTaint);
            cleanUp();
            int firstTombstone;
            firstTombstone = -1;
            {
                int index;
                index = key.hash & mask;
                index = next(index);
                {
                    Object k;
                    k = table[index];
                    {
                        table[index + 1] = value;
                    } //End block
                    {
                        {
                            table[index] = key.reference;
                            table[index + 1] = value;
                        } //End block
                        table[firstTombstone] = key.reference;
                        table[firstTombstone + 1] = value;
                    } //End block
                    {
                        firstTombstone = index;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.523 -0400", hash_original_method = "27C70593962E283B71D24D73AE4C9368", hash_generated_method = "10564AAF8E8B15D23C8512F4CA29909C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Object getAfterMiss(ThreadLocal<?> key) {
            dsTaint.addTaint(key.dsTaint);
            Object[] table;
            table = this.table;
            int index;
            index = key.hash & mask;
            {
                Object value;
                value = key.initialValue();
                {
                    table[index] = key.reference;
                    table[index + 1] = value;
                    cleanUp();
                } //End block
                put(key, value);
            } //End block
            int firstTombstone;
            firstTombstone = -1;
            {
                index = next(index);
                index = next(index);
                {
                    Object reference;
                    reference = table[index];
                    {
                        Object value;
                        value = key.initialValue();
                        {
                            {
                                table[firstTombstone] = key.reference;
                                table[firstTombstone + 1] = value;
                            } //End block
                            {
                                table[index] = key.reference;
                                table[index + 1] = value;
                                cleanUp();
                            } //End block
                        } //End block
                        put(key, value);
                    } //End block
                    {
                        firstTombstone = index;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.524 -0400", hash_original_method = "0360B175C51ABE1598A686E1C95592B6", hash_generated_method = "63520401570F38DECF84200BD15ECC46")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void remove(ThreadLocal<?> key) {
            dsTaint.addTaint(key.dsTaint);
            cleanUp();
            {
                int index;
                index = key.hash & mask;
                index = next(index);
                {
                    Object reference;
                    reference = table[index];
                    {
                        table[index] = TOMBSTONE;
                        table[index + 1] = null;
                    } //End block
                } //End block
            } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.524 -0400", hash_original_method = "A1B9AE6202C436A7C194238B45D86066", hash_generated_method = "4D93D51A57C5B2485DAF751921CBE1C3")
        @DSModeled(DSC.SAFE)
        private int next(int index) {
            dsTaint.addTaint(index);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return (index + 2) & mask;
        }

        
        private static final int INITIAL_SIZE = 16;
        private static final Object TOMBSTONE = new Object();
    }


    
    private static AtomicInteger hashCounter = new AtomicInteger(0);
}

