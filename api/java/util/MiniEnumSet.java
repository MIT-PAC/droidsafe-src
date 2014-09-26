package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

final class MiniEnumSet<E extends Enum<E>> extends EnumSet<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:47.785 -0500", hash_original_field = "A8D7839F4333A643EDD492E74C48DD85", hash_generated_field = "C20853631EBCD7966CC4FD1460DE8CB9")

    private static final int MAX_ELEMENTS = 64;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:47.787 -0500", hash_original_field = "673BDAEBF4FBC900963E210E042549D6", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:47.789 -0500", hash_original_field = "A1A4E3CC89D133F174FAE04978DF63B3", hash_generated_field = "783D81D695A8378E8654E8D6DD3B9BE2")

    private  E[] enums;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:47.792 -0500", hash_original_field = "9027729B517C3BBA76303A7389749115", hash_generated_field = "25B025E9A5F96E0701DCBD2F252ADF7D")

    private long bits;

    /**
     * Constructs an instance.
     *
     * @param elementType non-null; type of the elements
     * @param enums non-null; pre-populated array of constants in ordinal
     * order
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:47.794 -0500", hash_original_method = "13D7CE02E81D272A0503942FC3D4E826", hash_generated_method = "13D7CE02E81D272A0503942FC3D4E826")
    
MiniEnumSet(Class<E> elementType, E[] enums) {
        super(elementType);
        this.enums = enums;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:47.815 -0500", hash_original_method = "B65740ADDB851C7AEA4DC0329B3A4F67", hash_generated_method = "E4D753D7C4F6F457A93C8B6892540EAC")
    
@Override
    public Iterator<E> iterator() {
        return new MiniEnumSetIterator();
    }

    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:47.817 -0500", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "1B1551AD543164CCE8ABE887F4733D99")
    
@Override
    public int size() {
        return size;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:47.820 -0500", hash_original_method = "025226B2883D32895649213F93C1A199", hash_generated_method = "52CA1DB48C522C368B9CFFBA0FA5C009")
    
@Override
    public void clear() {
        bits = 0;
        size = 0;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:47.822 -0500", hash_original_method = "0E09B1B284FABC8D1B6052C567B95409", hash_generated_method = "CAEB023972844612C68C31115E5F86A2")
    
@Override
    public boolean add(E element) {
        elementClass.cast(element); // Called to throw ClassCastException.
        long oldBits = bits;
        long newBits = oldBits | (1L << element.ordinal());
        if (oldBits != newBits) {
            bits = newBits;
            size++;
            return true;
        }
        return false;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:47.825 -0500", hash_original_method = "CD3919E65A48A028AB158BD4B0E371DE", hash_generated_method = "85CEE80C9550A582F0D473844C41997C")
    
@Override
    public boolean addAll(Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        if (collection instanceof EnumSet) {
            EnumSet<?> set = (EnumSet) collection; // raw type due to javac bug 6548436
            set.elementClass.asSubclass(elementClass); // Called to throw ClassCastException.

            MiniEnumSet<?> miniSet = (MiniEnumSet<?>) set;
            long oldBits = bits;
            long newBits = oldBits | miniSet.bits;
            bits = newBits;
            size = Long.bitCount(newBits);
            return (oldBits != newBits);
        }
        return super.addAll(collection);
    }

    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:47.828 -0500", hash_original_method = "574C67B26880FBDD7ECF2408ADA0BF3B", hash_generated_method = "BEBBA099F8C6B50DD84E7F6FC0255271")
    
@Override
    public boolean contains(Object object) {
        if (object == null || !isValidType(object.getClass())) {
            return false;
        }

        @SuppressWarnings("unchecked") // guarded by isValidType()
        Enum<E> element = (Enum<E>) object;
        int ordinal = element.ordinal();
        return (bits & (1L << ordinal)) != 0;
    }

    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:47.830 -0500", hash_original_method = "F9B76DA5C8885A8F064E3CAE60CAF100", hash_generated_method = "C7FD6178D79A35CEBEA9EAE22C148962")
    
@Override
    public boolean containsAll(Collection<?> collection) {
        if (collection.isEmpty()) {
            return true;
        }
        if (collection instanceof MiniEnumSet) {
            MiniEnumSet<?> set = (MiniEnumSet<?>) collection;
            long setBits = set.bits;
            return isValidType(set.elementClass) && ((bits & setBits) == setBits);
        }
        return !(collection instanceof EnumSet) && super.containsAll(collection);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:47.833 -0500", hash_original_method = "0FAF468D35EFC7156A8E4C7EB1F47E75", hash_generated_method = "5B5CAF49A772BABDC75417528C5252D5")
    
@Override
    public boolean removeAll(Collection<?> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        if (collection instanceof EnumSet) {
            EnumSet<?> set = (EnumSet<?>) collection;
            if (!isValidType(set.elementClass)) {
                return false;
            }

            MiniEnumSet<E> miniSet = (MiniEnumSet<E>) set;
            long oldBits = bits;
            long newBits = oldBits & ~miniSet.bits;
            if (oldBits != newBits) {
                bits = newBits;
                size = Long.bitCount(newBits);
                return true;
            }
            return false;
        }
        return super.removeAll(collection);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:47.836 -0500", hash_original_method = "017E11B07B37D92215BE552EFD39EA89", hash_generated_method = "C645B83F44D29884C706B67F9EA76F32")
    
@Override
    public boolean retainAll(Collection<?> collection) {
        if (collection instanceof EnumSet) {
            EnumSet<?> set = (EnumSet<?>) collection;
            if (!isValidType(set.elementClass)) {
                if (size > 0) {
                    clear();
                    return true;
                } else {
                    return false;
                }
            }

            MiniEnumSet<E> miniSet = (MiniEnumSet<E>) set;
            long oldBits = bits;
            long newBits = oldBits & miniSet.bits;
            if (oldBits != newBits) {
                bits = newBits;
                size = Long.bitCount(newBits);
                return true;
            }
            return false;
        }
        return super.retainAll(collection);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:47.839 -0500", hash_original_method = "07B13756E56A1DF188CDC5BDB0B18ECF", hash_generated_method = "7BEE23F0951531A2896B3F64D506C3BB")
    
@Override
    public boolean remove(Object object) {
        if (object == null || !isValidType(object.getClass())) {
            return false;
        }

        @SuppressWarnings("unchecked") // guarded by isValidType()
        Enum<E> element = (Enum<E>) object;
        int ordinal = element.ordinal();
        long oldBits = bits;
        long newBits = oldBits & ~(1L << ordinal);
        if (oldBits != newBits) {
            bits = newBits;
            size--;
            return true;
        }
        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:47.841 -0500", hash_original_method = "0AE7A2B8046F11F65D5A1DDC2DB371C6", hash_generated_method = "4822167C5FB70074FAE5DCD9CBDC85C9")
    
@Override
    public boolean equals(Object object) {
        if (!(object instanceof EnumSet)) {
            return super.equals(object);
        }
        EnumSet<?> set =(EnumSet<?>) object;
        if (!isValidType(set.elementClass)) {
            return size == 0 && set.isEmpty();
        }
        return bits == ((MiniEnumSet<?>) set).bits;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:47.844 -0500", hash_original_method = "34C2A46ACE6140E33D58771C1EEACFB4", hash_generated_method = "8E813F97508C363DA18528165ED70354")
    
@Override
    void complement() {
        if (enums.length != 0) {
            bits = ~bits;
            bits &= (-1L >>> (MAX_ELEMENTS - enums.length));
            size = enums.length - size;
        }
    }
    
    private class MiniEnumSetIterator implements Iterator<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:47.797 -0500", hash_original_field = "280756CF70AC75CE51A25117D5C4813C", hash_generated_field = "88FE5C56F0ABD833B5AB4E83CA57D904")

        private long currentBits = bits;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:47.800 -0500", hash_original_field = "3A4F4F1C4B055C890F181AE96126D963", hash_generated_field = "E17CA9C849A83DC4D391140F1D677EB2")

        private long mask = currentBits & -currentBits;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:47.802 -0500", hash_original_field = "EE0E70F34F989CA023F449644CD2B8C0", hash_generated_field = "374CA24251E29484A78242144D89346E")

        /**
         * The candidate for removal. If null, no value may be removed.
         */
        private E last;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.292 -0400", hash_original_method = "C8509CBB611C286825BCD6AFB35ADC31", hash_generated_method = "C8509CBB611C286825BCD6AFB35ADC31")
        public MiniEnumSetIterator ()
        {
            //Synthesized constructor
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:47.804 -0500", hash_original_method = "04AD09EE87D1D0FB4F163A9180F152BA", hash_generated_method = "2289B7B444211E2D3E80C2AF73D47A18")
        
public boolean hasNext() {
            return mask != 0;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:47.807 -0500", hash_original_method = "B8BEA11D538861DDC29BFADEA29DB32E", hash_generated_method = "3E062BF6FBB64FBB4A38D7E384A1E97A")
        
public E next() {
            if (mask == 0) {
                throw new NoSuchElementException();
            }

            int ordinal = Long.numberOfTrailingZeros(mask);
            last = enums[ordinal];

            currentBits &= ~mask;
            mask = currentBits & -currentBits; // the lowest 1 bit in currentBits

            return last;
        }

        @DSSafe(DSCat.DATA_STRUCTURE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:47.809 -0500", hash_original_method = "38D2DDD498ED91B92C87DCAC1BCF5E89", hash_generated_method = "2EAF7B206E31ED45B2E8619BB5549F41")
        
public void remove() {
            if (last == null) {
                throw new IllegalStateException();
            }

            MiniEnumSet.this.remove(last);
            last = null;
        }
        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:47.846 -0500", hash_original_method = "9CD323C98F30FAEA7DF6B6CE47F14F1E", hash_generated_method = "E62B264E901C0AB2CAF42BE8D194C3B1")
    
@Override
    void setRange(E start, E end) {
        int length = end.ordinal() - start.ordinal() + 1;
        long range = (-1L >>> (MAX_ELEMENTS - length)) << start.ordinal();
        bits |= range;
        size = Long.bitCount(bits);
    }
}

