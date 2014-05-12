package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

final class HugeEnumSet<E extends Enum<E>> extends EnumSet<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.242 -0500", hash_original_field = "939EDB9E30D43F1F1DD302FB5EB0CF6E", hash_generated_field = "4752A7C1FB2BE83B3E8CBE7929135C61")

    private static final int BIT_IN_LONG = 64;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.245 -0500", hash_original_field = "A1A4E3CC89D133F174FAE04978DF63B3", hash_generated_field = "783D81D695A8378E8654E8D6DD3B9BE2")

     private E[] enums;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.247 -0500", hash_original_field = "92F775DED5CE5142CEEF7075890CCFCE", hash_generated_field = "487233F7143B18DBA481DB90C8ACD8D3")

    private long[] bits;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.249 -0500", hash_original_field = "673BDAEBF4FBC900963E210E042549D6", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;

    /**
     * Constructs an instance.
     *
     * @param elementType non-null; type of the elements
     * @param enums non-null; pre-populated array of constants in ordinal
     * order
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.252 -0500", hash_original_method = "EEA55C49C96425F7EA6FAB4AE055FF38", hash_generated_method = "EEA55C49C96425F7EA6FAB4AE055FF38")
    
HugeEnumSet(Class<E> elementType, E[] enums) {
        super(elementType);
        this.enums = enums;
        bits = new long[(enums.length + BIT_IN_LONG - 1) / BIT_IN_LONG];
    }

    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.280 -0500", hash_original_method = "AA8C9EBB2E9808034C94DE14598C355D", hash_generated_method = "29356F7A17B0291D52D8ACAC8DB55AEC")
    
@Override
    public boolean add(E element) {
        elementClass.cast(element); // Called to throw ClassCastException.
        int ordinal = element.ordinal();
        int index = ordinal / BIT_IN_LONG;
        int inBits = ordinal % BIT_IN_LONG;
        long oldBits = bits[index];
        long newBits = oldBits | (1L << inBits);
        if (oldBits != newBits) {
            bits[index] = newBits;
            size++;
            return true;
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.284 -0500", hash_original_method = "E12827AAC6F89269FBC667C494374EA1", hash_generated_method = "839EAD08A26A2390D762938F924C986D")
    
@Override
    public boolean addAll(Collection<? extends E> collection) {
        if (collection.isEmpty() || collection == this) {
            return false;
        }

        if (collection instanceof EnumSet) {
            EnumSet<?> set = (EnumSet) collection; // raw type due to javac bug 6548436
            set.elementClass.asSubclass(elementClass); // Called to throw ClassCastException.

            HugeEnumSet<E> hugeSet = (HugeEnumSet<E>) set;
            boolean changed = false;
            for (int i = 0; i < bits.length; i++) {
                long oldBits = bits[i];
                long newBits = oldBits | hugeSet.bits[i];
                if (oldBits != newBits) {
                    bits[i] = newBits;
                    size += Long.bitCount(newBits) - Long.bitCount(oldBits);
                    changed = true;
                }
            }
            return changed;
        }
        return super.addAll(collection);
    }

    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.286 -0500", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "1B1551AD543164CCE8ABE887F4733D99")
    
@Override
    public int size() {
        return size;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.289 -0500", hash_original_method = "DCEAB8467BE76F2C68D656B465986296", hash_generated_method = "FE40F512E63B7837A52434DFCF20FA58")
    
@Override
    public void clear() {
        Arrays.fill(bits, 0);
        size = 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.291 -0500", hash_original_method = "A9576B1054BBEFBD598CED30CCA4181D", hash_generated_method = "C56B6FF3A9F2DB666A31CC47DA25E47D")
    
@Override
    protected void complement() {
        size = 0;
        for (int i = 0, length = bits.length; i < length; i++) {
            long b = ~bits[i];

            // zero out unused bits on the last element
            if (i == length - 1) {
                b &= -1L >>> (BIT_IN_LONG - (enums.length % BIT_IN_LONG));
            }

            size += Long.bitCount(b);
            bits[i] = b;
        }
    }

    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.294 -0500", hash_original_method = "B006F695BBA9ACB2815E6A6799929FF8", hash_generated_method = "A13B892B2BD13B7E45A91C67BD40DAF8")
    
@Override
    public boolean contains(Object object) {
        if (object == null || !isValidType(object.getClass())) {
            return false;
        }

        @SuppressWarnings("unchecked") // guarded by isValidType()
        int ordinal = ((E) object).ordinal();
        int index = ordinal / BIT_IN_LONG;
        int inBits = ordinal % BIT_IN_LONG;
        return (bits[index] & (1L << inBits)) != 0;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.297 -0500", hash_original_method = "826B98DAC190E2D4BDC8BAF1B8E9FA22", hash_generated_method = "0173013A05F97784927B8DD4B097A4DC")
    
@Override
    public HugeEnumSet<E> clone() {
        HugeEnumSet<E> set = (HugeEnumSet<E>) super.clone();
        set.bits = bits.clone();
        return set;
    }

    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.300 -0500", hash_original_method = "339CE6C6AEA3B599DB9A44E737F0BFCB", hash_generated_method = "D6E050984BE57D4C4AEEA1297CE874D9")
    
@Override
    public boolean containsAll(Collection<?> collection) {
        if (collection.isEmpty()) {
            return true;
        }
        if (collection instanceof HugeEnumSet) {
            HugeEnumSet<?> set = (HugeEnumSet<?>) collection;
            if (isValidType(set.elementClass)) {
                for (int i = 0; i < bits.length; i++) {
                    long setBits = set.bits[i];
                    if ((bits[i] & setBits) != setBits) {
                        return false;
                    }
                }
                return true;
            }
        }
        return !(collection instanceof EnumSet) && super.containsAll(collection);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.302 -0500", hash_original_method = "29B1F731631A653DA7254FAD146C3D30", hash_generated_method = "52C88AB94D31DCA20C47764328B5D0EE")
    
@Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!isValidType(object.getClass())) {
            return super.equals(object);
        }
        return Arrays.equals(bits, ((HugeEnumSet<?>) object).bits);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.305 -0500", hash_original_method = "B316E1958D9D53581FC97DA7E1235F34", hash_generated_method = "61ED6DE6DBF5B1671BB07D406ABF7CD7")
    
@Override
    public Iterator<E> iterator() {
        return new HugeEnumSetIterator();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.307 -0500", hash_original_method = "0CEE396056E1D776D537706DDC043702", hash_generated_method = "E327D43EA8F8984E2DB4DAD700B2E21F")
    
@Override
    public boolean remove(Object object) {
        if (object == null || !isValidType(object.getClass())) {
            return false;
        }

        @SuppressWarnings("unchecked") // guarded by isValidType()
        int ordinal = ((E) object).ordinal();
        int index = ordinal / BIT_IN_LONG;
        int inBits = ordinal % BIT_IN_LONG;
        long oldBits = bits[index];
        long newBits = oldBits & ~(1L << inBits);
        if (oldBits != newBits) {
            bits[index] = newBits;
            size--;
            return true;
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.310 -0500", hash_original_method = "3A1F4E4B375F17905B34B03F15B39BEF", hash_generated_method = "D9014480812A9CD91D222805570E3A6C")
    
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

            HugeEnumSet<E> hugeSet = (HugeEnumSet<E>) set;
            boolean changed = false;
            for (int i = 0; i < bits.length; i++) {
                long oldBits = bits[i];
                long newBits = oldBits & ~hugeSet.bits[i];
                if (oldBits != newBits) {
                    bits[i] = newBits;
                    size += Long.bitCount(newBits) - Long.bitCount(oldBits);
                    changed = true;
                }
            }
            return changed;
        }
        return super.removeAll(collection);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.313 -0500", hash_original_method = "60F21531B5154FAF39DCC5FD8D5C4219", hash_generated_method = "91263B20693886F9E54ECF96893AFC29")
    
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

            HugeEnumSet<E> hugeSet = (HugeEnumSet<E>) set;
            boolean changed = false;
            for (int i = 0; i < bits.length; i++) {
                long oldBits = bits[i];
                long newBits = oldBits & hugeSet.bits[i];
                if (oldBits != newBits) {
                    bits[i] = newBits;
                    size += Long.bitCount(newBits) - Long.bitCount(oldBits);
                    changed = true;
                }
            }
            return changed;
        }
        return super.retainAll(collection);
    }
    
    private class HugeEnumSetIterator implements Iterator<E> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.255 -0500", hash_original_field = "2F5470A6BE337FF6083E8F778EE88657", hash_generated_field = "C1B6116DE9FEB291CD26A801EC34041A")

        private long currentBits = bits[0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.257 -0500", hash_original_field = "8BD524D6245D998B3BBC44EB9313082E", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")

        private int index;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.260 -0500", hash_original_field = "A3F1E6D9C78BA652CA7E6A1E6CC68274", hash_generated_field = "EAE061265E9AAFE24A096DF314F2EEC2")

        private long mask;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.262 -0500", hash_original_field = "EE0E70F34F989CA023F449644CD2B8C0", hash_generated_field = "D8F234509BE4DCE084A89E169B9321DD")

        private E last;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.265 -0500", hash_original_method = "FF84D40F2248B9BB6D017CB27211B237", hash_generated_method = "F0F60783B136124516F974A259BEA74A")
        
private HugeEnumSetIterator() {
            computeNextElement();
        }

        /**
         * Assigns mask and index to the next available value, cycling currentBits as necessary.
         */
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.267 -0500", hash_original_method = "2CE5F24A4C571BEECB25C40400E44908", hash_generated_method = "A3579B97578194B5EA0183D0F747142C")
        
void computeNextElement() {
            while (true) {
                if (currentBits != 0) {
                    mask = currentBits & -currentBits; // the lowest 1 bit in currentBits
                    return;
                } else if (++index < bits.length) {
                    currentBits = bits[index];
                } else {
                    mask = 0;
                    return;
                }
            }
        }

        @DSSafe(DSCat.DATA_STRUCTURE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.270 -0500", hash_original_method = "04AD09EE87D1D0FB4F163A9180F152BA", hash_generated_method = "2289B7B444211E2D3E80C2AF73D47A18")
        
public boolean hasNext() {
            return mask != 0;
        }

        @DSSafe(DSCat.DATA_STRUCTURE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.273 -0500", hash_original_method = "B99B4F6D513EFDAF8AFCA1BFB6A725C7", hash_generated_method = "0C75D49CB7AE57E6698537A3C259442D")
        
public E next() {
            if (mask == 0) {
                throw new NoSuchElementException();
            }

            int ordinal = Long.numberOfTrailingZeros(mask) + index * BIT_IN_LONG;
            last = enums[ordinal];

            currentBits &= ~mask;
            computeNextElement();

            return last;
        }

        @DSSafe(DSCat.DATA_STRUCTURE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.275 -0500", hash_original_method = "56FBFE20B1E9D061DA542B4F3A5EEEAB", hash_generated_method = "0FE60E04F9D0A2D5A7ED2EC49283C2AE")
        
public void remove() {
            if (last == null) {
                throw new IllegalStateException();
            }

            HugeEnumSet.this.remove(last);
            last = null;
        }
        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:04.317 -0500", hash_original_method = "8A87EADAF5D536F1830CF4EB88261592", hash_generated_method = "2B647C326A2DFC6AA10F9EF793469492")
    
@Override
    void setRange(E start, E end) {
        int startOrdinal = start.ordinal();
        int startIndex = startOrdinal / BIT_IN_LONG;
        int startInBits = startOrdinal % BIT_IN_LONG;

        int endOrdinal = end.ordinal();
        int endIndex = endOrdinal / BIT_IN_LONG;
        int endInBits = endOrdinal % BIT_IN_LONG;

        if (startIndex == endIndex) {
            long range = (-1L >>> (BIT_IN_LONG -(endInBits - startInBits + 1))) << startInBits;
            size -= Long.bitCount(bits[startIndex]);
            bits[startIndex] |= range;
            size += Long.bitCount(bits[startIndex]);

        } else {
            long range = (-1L >>> startInBits) << startInBits;
            size -= Long.bitCount(bits[startIndex]);
            bits[startIndex] |= range;
            size += Long.bitCount(bits[startIndex]);

            // endInBits + 1 is the number of consecutive ones.
            // 63 - endInBits is the following zeros of the right most one.
            range = -1L >>> (BIT_IN_LONG - (endInBits + 1));
            size -= Long.bitCount(bits[endIndex]);
            bits[endIndex] |= range;
            size += Long.bitCount(bits[endIndex]);
            for (int i = (startIndex + 1); i <= (endIndex - 1); i++) {
                size -= Long.bitCount(bits[i]);
                bits[i] = -1L;
                size += Long.bitCount(bits[i]);
            }
        }
    }
}

