package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocal<T> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.344 -0500", hash_original_field = "65EF0C9DFC0E92D7EED5F56DE419D25E", hash_generated_field = "D0904C715877D79D507857C3DBB2EE5E")

    private static AtomicInteger hashCounter = new AtomicInteger(0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.341 -0500", hash_original_field = "C19D8ED4807D46DB1FCA44799C1FDD28", hash_generated_field = "E19C4AFB9937521DCDC693F15C42E2A7")

    private final Reference<ThreadLocal<T>> reference
            = new WeakReference<ThreadLocal<T>>(this);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.346 -0500", hash_original_field = "5323E62630847103A2D18086F1AC9418", hash_generated_field = "B643A854DCD11F044BA6D1951F01CE6B")

    private final int hash = hashCounter.getAndAdd(0x61c88647 * 2);

    /* Thanks to Josh Bloch and Doug Lea for code reviews and impl advice. */

    /**
     * Creates a new thread-local variable.
     */
    @DSComment("no security concern")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.324 -0500", hash_original_method = "CCBA978684365F19FBD68BD48C79C23F", hash_generated_method = "D0C2DD8281FBEC9648419EC2F2A6CF45")
    
public ThreadLocal() {}

    /**
     * Returns the value of this variable for the current thread. If an entry
     * doesn't yet exist for this variable on this thread, this method will
     * create an entry, populating the value with the result of
     * {@link #initialValue()}.
     *
     * @return the current value of the variable for the calling thread.
     */
    @DSComment("not sensitive/not an action")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.327 -0500", hash_original_method = "17AB1D63AD8B7EADE4880D6FD1744965", hash_generated_method = "487B38E97D772D8EDC85719FC3E88B3F")
    
@SuppressWarnings("unchecked")
    public T get() {
        // Optimized for the fast path.
        Thread currentThread = Thread.currentThread();
        Values values = values(currentThread);
        if (values != null) {
            Object[] table = values.table;
            int index = hash & values.mask;
            if (this.reference == table[index]) {
                return (T) table[index + 1];
            }
        } else {
            values = initializeValues(currentThread);
        }

        return (T) values.getAfterMiss(this);
    }

    /**
     * Provides the initial value of this variable for the current thread.
     * The default implementation returns {@code null}.
     *
     * @return the initial value of the variable.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.329 -0500", hash_original_method = "65001977AEEFEE3DB28BF88E33FB8DD1", hash_generated_method = "999537292646B413D625B8DA30E8F6C8")
    
protected T initialValue() {
        return null;
    }

    /**
     * Sets the value of this variable for the current thread. If set to
     * {@code null}, the value will be set to null and the underlying entry will
     * still be present.
     *
     * @param value the new value of the variable for the caller thread.
     */
    @DSComment("not sensitive/not an action")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.332 -0500", hash_original_method = "93D51722B7CB3C8EF0C38EE234F866B9", hash_generated_method = "F4573C2031B961898558E7070BE21319")
    
public void set(T value) {
        Thread currentThread = Thread.currentThread();
        Values values = values(currentThread);
        if (values == null) {
            values = initializeValues(currentThread);
        }
        values.put(this, value);
    }

    /**
     * Removes the entry for this variable in the current thread. If this call
     * is followed by a {@link #get()} before a {@link #set},
     * {@code #get()} will call {@link #initialValue()} and create a new
     * entry with the resulting value.
     *
     * @since 1.5
     */
    @DSComment("not sensitive/not an action")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.334 -0500", hash_original_method = "E12F04AD7D9687B33AD1C273DE0809EB", hash_generated_method = "ACDA24ADC78949A9692E989598D5396F")
    
public void remove() {
        Thread currentThread = Thread.currentThread();
        Values values = values(currentThread);
        if (values != null) {
            values.remove(this);
        }
    }

    /**
     * Creates Values instance for this thread and variable type.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.336 -0500", hash_original_method = "F6756F2BA503B7A43E41A22536745AD1", hash_generated_method = "F6756F2BA503B7A43E41A22536745AD1")
    
Values initializeValues(Thread current) {
        return current.localValues = new Values();
    }
    
    static class Values {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.349 -0500", hash_original_field = "5815EB4F0C5C8D237058EB34C5FEE776", hash_generated_field = "FC71C8361E3E0D880F15510AF5EACDF8")

        private static final int INITIAL_SIZE = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.352 -0500", hash_original_field = "9E0F247113117F4A5C23BCB7A2797F8A", hash_generated_field = "AB47CE0D72E31CB661DFF9FA386FCB35")

        private static final Object TOMBSTONE = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.354 -0500", hash_original_field = "36DF4CEC834ED362235F0669E6FA3F95", hash_generated_field = "FD72DCEA1BA087F9DFD15C7A360AA526")

        private Object[] table;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.357 -0500", hash_original_field = "DB965A11139AB665B00B4D2E2ABFFB32", hash_generated_field = "CB9C3356548F555F843424D7B01932DE")

        private int mask;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.360 -0500", hash_original_field = "673BDAEBF4FBC900963E210E042549D6", hash_generated_field = "F06612A05C836674433E69C513561353")

        private int size;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.363 -0500", hash_original_field = "6A2EF5F02E565CDE4F1ED655E81BCFA4", hash_generated_field = "97BD139A14B9108FDB72C084E57FF305")

        private int tombstones;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.365 -0500", hash_original_field = "CC184D2D90DB7295BCCC119BF2899AB8", hash_generated_field = "84B0D7BDAD4BEF6EA743B0D3D294E91E")

        private int maximumLoad;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.368 -0500", hash_original_field = "BB67A37237C25198C973F0AF97F1FEB9", hash_generated_field = "D443419CB814AFCD3668DE2EA3A4C6CB")

        private int clean;

        /**
         * Constructs a new, empty instance.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.371 -0500", hash_original_method = "8603CA8C8DA2F2A8742D0D3D57F85A73", hash_generated_method = "8603CA8C8DA2F2A8742D0D3D57F85A73")
        
Values() {
            initializeTable(INITIAL_SIZE);
            this.size = 0;
            this.tombstones = 0;
        }

        /**
         * Used for InheritableThreadLocals.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.373 -0500", hash_original_method = "1543F2E70FF0D503FC0C174797134204", hash_generated_method = "1543F2E70FF0D503FC0C174797134204")
        
Values(Values fromParent) {
            this.table = fromParent.table.clone();
            this.mask = fromParent.mask;
            this.size = fromParent.size;
            this.tombstones = fromParent.tombstones;
            this.maximumLoad = fromParent.maximumLoad;
            this.clean = fromParent.clean;
            inheritValues(fromParent);
        }

        /**
         * Inherits values from a parent thread.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.377 -0500", hash_original_method = "9BD4203D3E5EBD7464FA7B2A4E6BD9E0", hash_generated_method = "2901E5EF19F5713990C93D0D25796978")
        
@SuppressWarnings({"unchecked"})
        private void inheritValues(Values fromParent) {
            // Transfer values from parent to child thread.
            Object[] table = this.table;
            for (int i = table.length - 2; i >= 0; i -= 2) {
                Object k = table[i];

                if (k == null || k == TOMBSTONE) {
                    // Skip this entry.
                    continue;
                }

                // The table can only contain null, tombstones and references.
                Reference<InheritableThreadLocal<?>> reference
                        = (Reference<InheritableThreadLocal<?>>) k;
                // Raw type enables us to pass in an Object below.
                InheritableThreadLocal key = reference.get();
                if (key != null) {
                    // Replace value with filtered value.
                    // We should just let exceptions bubble out and tank
                    // the thread creation
                    table[i + 1] = key.childValue(fromParent.table[i + 1]);
                } else {
                    // The key was reclaimed.
                    table[i] = TOMBSTONE;
                    table[i + 1] = null;
                    fromParent.table[i] = TOMBSTONE;
                    fromParent.table[i + 1] = null;

                    tombstones++;
                    fromParent.tombstones++;

                    size--;
                    fromParent.size--;
                }
            }
        }

        /**
         * Creates a new, empty table with the given capacity.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.379 -0500", hash_original_method = "8D46CF6663407215221C449D596ED15A", hash_generated_method = "CBACA53A8D3C7D66DABA127668E3E13D")
        
private void initializeTable(int capacity) {
            this.table = new Object[capacity * 2];
            this.mask = table.length - 1;
            this.clean = 0;
            this.maximumLoad = capacity * 2 / 3; // 2/3
        }

        /**
         * Cleans up after garbage-collected thread locals.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.382 -0500", hash_original_method = "9C8BB7874FA14669E3E1A4855CFECE2B", hash_generated_method = "1E4AE75F15E21F869CCCFC0572EF8EC7")
        
private void cleanUp() {
            if (rehash()) {
                // If we rehashed, we needn't clean up (clean up happens as
                // a side effect).
                return;
            }

            if (size == 0) {
                // No live entries == nothing to clean.
                return;
            }

            // Clean log(table.length) entries picking up where we left off
            // last time.
            int index = clean;
            Object[] table = this.table;
            for (int counter = table.length; counter > 0; counter >>= 1,
                    index = next(index)) {
                Object k = table[index];

                if (k == TOMBSTONE || k == null) {
                    continue; // on to next entry
                }

                // The table can only contain null, tombstones and references.
                @SuppressWarnings("unchecked")
                Reference<ThreadLocal<?>> reference
                        = (Reference<ThreadLocal<?>>) k;
                if (reference.get() == null) {
                    // This thread local was reclaimed by the garbage collector.
                    table[index] = TOMBSTONE;
                    table[index + 1] = null;
                    tombstones++;
                    size--;
                }
            }

            // Point cursor to next index.
            clean = index;
        }

        /**
         * Rehashes the table, expanding or contracting it as necessary.
         * Gets rid of tombstones. Returns true if a rehash occurred.
         * We must rehash every time we fill a null slot; we depend on the
         * presence of null slots to end searches (otherwise, we'll infinitely
         * loop).
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.386 -0500", hash_original_method = "D5329B07F2A83D8B781C7C8F5FD2D30A", hash_generated_method = "99C56485AD9D5B0DEEDA3A46BA4195ED")
        
private boolean rehash() {
            if (tombstones + size < maximumLoad) {
                return false;
            }

            int capacity = table.length >> 1;

            // Default to the same capacity. This will create a table of the
            // same size and move over the live entries, analogous to a
            // garbage collection. This should only happen if you churn a
            // bunch of thread local garbage (removing and reinserting
            // the same thread locals over and over will overwrite tombstones
            // and not fill up the table).
            int newCapacity = capacity;

            if (size > (capacity >> 1)) {
                // More than 1/2 filled w/ live entries.
                // Double size.
                newCapacity = capacity * 2;
            }

            Object[] oldTable = this.table;

            // Allocate new table.
            initializeTable(newCapacity);

            // We won't have any tombstones after this.
            this.tombstones = 0;

            // If we have no live entries, we can quit here.
            if (size == 0) {
                return true;
            }

            // Move over entries.
            for (int i = oldTable.length - 2; i >= 0; i -= 2) {
                Object k = oldTable[i];
                if (k == null || k == TOMBSTONE) {
                    // Skip this entry.
                    continue;
                }

                // The table can only contain null, tombstones and references.
                @SuppressWarnings("unchecked")
                Reference<ThreadLocal<?>> reference
                        = (Reference<ThreadLocal<?>>) k;
                ThreadLocal<?> key = reference.get();
                if (key != null) {
                    // Entry is still live. Move it over.
                    add(key, oldTable[i + 1]);
                } else {
                    // The key was reclaimed.
                    size--;
                }
            }

            return true;
        }

        /**
         * Adds an entry during rehashing. Compared to put(), this method
         * doesn't have to clean up, check for existing entries, account for
         * tombstones, etc.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.388 -0500", hash_original_method = "8FD2790587F2719E68EBC052DE90327C", hash_generated_method = "8FD2790587F2719E68EBC052DE90327C")
        
void add(ThreadLocal<?> key, Object value) {
            for (int index = key.hash & mask;; index = next(index)) {
                Object k = table[index];
                if (k == null) {
                    table[index] = key.reference;
                    table[index + 1] = value;
                    return;
                }
            }
        }

        /**
         * Sets entry for given ThreadLocal to given value, creating an
         * entry if necessary.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.391 -0500", hash_original_method = "F7F8B7C8923C08ADEC94E7E7276E0E2F", hash_generated_method = "CA50C82AAEBCCFC857040B17FF4D0BBA")
        
void put(ThreadLocal<?> key, Object value) {
            cleanUp();

            // Keep track of first tombstone. That's where we want to go back
            // and add an entry if necessary.
            int firstTombstone = -1;

            for (int index = key.hash & mask;; index = next(index)) {
                Object k = table[index];

                if (k == key.reference) {
                    // Replace existing entry.
                    table[index + 1] = value;
                    return;
                }

                if (k == null) {
                    if (firstTombstone == -1) {
                        // Fill in null slot.
                        table[index] = key.reference;
                        table[index + 1] = value;
                        size++;
                        return;
                    }

                    // Go back and replace first tombstone.
                    table[firstTombstone] = key.reference;
                    table[firstTombstone + 1] = value;
                    tombstones--;
                    size++;
                    return;
                }

                // Remember first tombstone.
                if (firstTombstone == -1 && k == TOMBSTONE) {
                    firstTombstone = index;
                }
            }
        }

        /**
         * Gets value for given ThreadLocal after not finding it in the first
         * slot.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.395 -0500", hash_original_method = "27C70593962E283B71D24D73AE4C9368", hash_generated_method = "CB49CB1736028974189EF007283FC22C")
        
Object getAfterMiss(ThreadLocal<?> key) {
            Object[] table = this.table;
            int index = key.hash & mask;

            // If the first slot is empty, the search is over.
            if (table[index] == null) {
                Object value = key.initialValue();

                // If the table is still the same and the slot is still empty...
                if (this.table == table && table[index] == null) {
                    table[index] = key.reference;
                    table[index + 1] = value;
                    size++;

                    cleanUp();
                    return value;
                }

                // The table changed during initialValue().
                put(key, value);
                return value;
            }

            // Keep track of first tombstone. That's where we want to go back
            // and add an entry if necessary.
            int firstTombstone = -1;

            // Continue search.
            for (index = next(index);; index = next(index)) {
                Object reference = table[index];
                if (reference == key.reference) {
                    return table[index + 1];
                }

                // If no entry was found...
                if (reference == null) {
                    Object value = key.initialValue();

                    // If the table is still the same...
                    if (this.table == table) {
                        // If we passed a tombstone and that slot still
                        // contains a tombstone...
                        if (firstTombstone > -1
                                && table[firstTombstone] == TOMBSTONE) {
                            table[firstTombstone] = key.reference;
                            table[firstTombstone + 1] = value;
                            tombstones--;
                            size++;

                            // No need to clean up here. We aren't filling
                            // in a null slot.
                            return value;
                        }

                        // If this slot is still empty...
                        if (table[index] == null) {
                            table[index] = key.reference;
                            table[index + 1] = value;
                            size++;

                            cleanUp();
                            return value;
                        }
                    }

                    // The table changed during initialValue().
                    put(key, value);
                    return value;
                }

                if (firstTombstone == -1 && reference == TOMBSTONE) {
                    // Keep track of this tombstone so we can overwrite it.
                    firstTombstone = index;
                }
            }
        }

        /**
         * Removes entry for the given ThreadLocal.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.397 -0500", hash_original_method = "0360B175C51ABE1598A686E1C95592B6", hash_generated_method = "90506082E3D0459E2C81EA8FB00BD16F")
        
void remove(ThreadLocal<?> key) {
            cleanUp();

            for (int index = key.hash & mask;; index = next(index)) {
                Object reference = table[index];

                if (reference == key.reference) {
                    // Success!
                    table[index] = TOMBSTONE;
                    table[index + 1] = null;
                    tombstones++;
                    size--;
                    return;
                }

                if (reference == null) {
                    // No entry found.
                    return;
                }
            }
        }

        /**
         * Gets the next index. If we're at the end of the table, we wrap back
         * around to 0.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.400 -0500", hash_original_method = "A1B9AE6202C436A7C194238B45D86066", hash_generated_method = "2CC1E2DA13B47C46DCCB446A48AA4134")
        
private int next(int index) {
            return (index + 2) & mask;
        }
    }

    /**
     * Gets Values instance for this thread and variable type.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:25.338 -0500", hash_original_method = "303C743BABF91BBE1D2B949725040AC0", hash_generated_method = "303C743BABF91BBE1D2B949725040AC0")
    
Values values(Thread current) {
        return current.localValues;
    }
}

