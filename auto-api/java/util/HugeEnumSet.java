package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

final class HugeEnumSet<E extends Enum<E>> extends EnumSet<E> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.334 -0400", hash_original_field = "407482FEF87D1B9F3A34AF46A705ABA8", hash_generated_field = "783D81D695A8378E8654E8D6DD3B9BE2")

    private E[] enums;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.334 -0400", hash_original_field = "CC411E6C13670E52124629B8AC83F7D0", hash_generated_field = "487233F7143B18DBA481DB90C8ACD8D3")

    private long[] bits;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.334 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.335 -0400", hash_original_method = "EEA55C49C96425F7EA6FAB4AE055FF38", hash_generated_method = "A69E040A9B48E6B565F7177BCD72C055")
      HugeEnumSet(Class<E> elementType, E[] enums) {
        super(elementType);
        this.enums = enums;
        bits = new long[(enums.length + BIT_IN_LONG - 1) / BIT_IN_LONG];
        addTaint(elementType.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.335 -0400", hash_original_method = "AA8C9EBB2E9808034C94DE14598C355D", hash_generated_method = "D1B60FB6FD6CE25264B47C075BF1BB81")
    @Override
    public boolean add(E element) {
        elementClass.cast(element);
        int ordinal = element.ordinal();
        int index = ordinal / BIT_IN_LONG;
        int inBits = ordinal % BIT_IN_LONG;
        long oldBits = bits[index];
        long newBits = oldBits | (1L << inBits);
        {
            bits[index] = newBits;
        } 
        addTaint(element.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_496047475 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_496047475;
        
        
        
        
        
        
        
        
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.336 -0400", hash_original_method = "E12827AAC6F89269FBC667C494374EA1", hash_generated_method = "4418BCC89CA7459AFED66332124D1238")
    @Override
    public boolean addAll(Collection<? extends E> collection) {
        {
            boolean var3B2CA533278FD3BC25287536E014CB23_1656089600 = (collection.isEmpty() || collection == this);
        } 
        {
            EnumSet<?> set = (EnumSet) collection;
            set.elementClass.asSubclass(elementClass);
            HugeEnumSet<E> hugeSet = (HugeEnumSet<E>) set;
            boolean changed = false;
            {
                int i = 0;
                {
                    long oldBits = bits[i];
                    long newBits = oldBits | hugeSet.bits[i];
                    {
                        bits[i] = newBits;
                        size += Long.bitCount(newBits) - Long.bitCount(oldBits);
                        changed = true;
                    } 
                } 
            } 
        } 
        boolean varEB611C777D04833FE5AA6B71D18D3718_1737300586 = (super.addAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_369261975 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_369261975;
        
        
            
        
        
            
            
            
            
            
                
                
                
                    
                    
                    
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.336 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "2C51D9EC27E4550EAC9B785779344067")
    @Override
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1183579989 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1183579989;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.336 -0400", hash_original_method = "DCEAB8467BE76F2C68D656B465986296", hash_generated_method = "44B0C7C748288EE706DEDE8A6C28EFB5")
    @Override
    public void clear() {
        Arrays.fill(bits, 0);
        size = 0;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.337 -0400", hash_original_method = "A9576B1054BBEFBD598CED30CCA4181D", hash_generated_method = "201BC1E04F77879C8C136441EB1E0D08")
    @Override
    protected void complement() {
        size = 0;
        {
            int i = 0;
            int length = bits.length;
            {
                long b = ~bits[i];
                {
                    b &= -1L >>> (BIT_IN_LONG - (enums.length % BIT_IN_LONG));
                } 
                size += Long.bitCount(b);
                bits[i] = b;
            } 
        } 
        
        
        
            
            
                
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.338 -0400", hash_original_method = "B006F695BBA9ACB2815E6A6799929FF8", hash_generated_method = "68E89E460BD0A74815BA8D13B181AFAA")
    @Override
    public boolean contains(Object object) {
        {
            boolean varE5952BCD6CF6F9557D7D5FDD0B6C62AB_1346291342 = (object == null || !isValidType(object.getClass()));
        } 
        @SuppressWarnings("unchecked") int ordinal = ((E) object).ordinal();
        int index = ordinal / BIT_IN_LONG;
        int inBits = ordinal % BIT_IN_LONG;
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2100543752 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2100543752;
        
        
            
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.339 -0400", hash_original_method = "826B98DAC190E2D4BDC8BAF1B8E9FA22", hash_generated_method = "BAA52AEA2F0130ACD587061B13D5AEAE")
    @Override
    public HugeEnumSet<E> clone() {
        HugeEnumSet<E> varB4EAC82CA7396A68D541C85D26508E83_65564390 = null; 
        HugeEnumSet<E> set = (HugeEnumSet<E>) super.clone();
        set.bits = bits.clone();
        varB4EAC82CA7396A68D541C85D26508E83_65564390 = set;
        varB4EAC82CA7396A68D541C85D26508E83_65564390.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_65564390;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.339 -0400", hash_original_method = "339CE6C6AEA3B599DB9A44E737F0BFCB", hash_generated_method = "1EAB18AFC49D2A59F00D2A56F9F7D482")
    @Override
    public boolean containsAll(Collection<?> collection) {
        {
            boolean var8E459D14D8063CC6C44012E6D0BE3338_656328955 = (collection.isEmpty());
        } 
        {
            HugeEnumSet<?> set = (HugeEnumSet<?>) collection;
            {
                boolean varDE391B62B6D66788B807EF0C5A492585_1723305545 = (isValidType(set.elementClass));
                {
                    {
                        int i = 0;
                        {
                            long setBits = set.bits[i];
                        } 
                    } 
                } 
            } 
        } 
        boolean varF7A7E8D103444376F893F3304E0C70F4_1763364914 = (!(collection instanceof EnumSet) && super.containsAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1897427571 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1897427571;
        
        
            
        
        
            
            
                
                    
                    
                        
                    
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.340 -0400", hash_original_method = "29B1F731631A653DA7254FAD146C3D30", hash_generated_method = "5AC5F0D62FCDA9119A38956F9FF42F41")
    @Override
    public boolean equals(Object object) {
        {
            boolean var0BEE195FDC5A4C364075EE964A7A7328_1539217039 = (!isValidType(object.getClass()));
            {
                boolean var5F3224CFE728C1743180B4BAE5039FE5_1967605704 = (super.equals(object));
            } 
        } 
        boolean var06CA9D625FDB0DFEAEA936AF129E1B4E_2090438783 = (Arrays.equals(bits, ((HugeEnumSet<?>) object).bits));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_266951219 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_266951219;
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.340 -0400", hash_original_method = "B316E1958D9D53581FC97DA7E1235F34", hash_generated_method = "F7C229A2AF75477E545711D65F437C67")
    @Override
    public Iterator<E> iterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_1259451422 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1259451422 = new HugeEnumSetIterator();
        varB4EAC82CA7396A68D541C85D26508E83_1259451422.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1259451422;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.341 -0400", hash_original_method = "0CEE396056E1D776D537706DDC043702", hash_generated_method = "1EF8B90CF399B27AD87F6F8BE3AAE5A8")
    @Override
    public boolean remove(Object object) {
        {
            boolean varE5952BCD6CF6F9557D7D5FDD0B6C62AB_824151017 = (object == null || !isValidType(object.getClass()));
        } 
        @SuppressWarnings("unchecked") int ordinal = ((E) object).ordinal();
        int index = ordinal / BIT_IN_LONG;
        int inBits = ordinal % BIT_IN_LONG;
        long oldBits = bits[index];
        long newBits = oldBits & ~(1L << inBits);
        {
            bits[index] = newBits;
        } 
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1045185984 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1045185984;
        
        
            
        
        
        
        
        
        
        
        
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.341 -0400", hash_original_method = "3A1F4E4B375F17905B34B03F15B39BEF", hash_generated_method = "0405FC0749233210B228E6F1F0A2C679")
    @Override
    public boolean removeAll(Collection<?> collection) {
        {
            boolean var8E459D14D8063CC6C44012E6D0BE3338_784505790 = (collection.isEmpty());
        } 
        {
            EnumSet<?> set = (EnumSet<?>) collection;
            {
                boolean varBA48F6D095241919836645401D6F116E_1058450933 = (!isValidType(set.elementClass));
            } 
            HugeEnumSet<E> hugeSet = (HugeEnumSet<E>) set;
            boolean changed = false;
            {
                int i = 0;
                {
                    long oldBits = bits[i];
                    long newBits = oldBits & ~hugeSet.bits[i];
                    {
                        bits[i] = newBits;
                        size += Long.bitCount(newBits) - Long.bitCount(oldBits);
                        changed = true;
                    } 
                } 
            } 
        } 
        boolean var683870BA88109C83545AC694C96B458A_1055601402 = (super.removeAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_882976154 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_882976154;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.342 -0400", hash_original_method = "60F21531B5154FAF39DCC5FD8D5C4219", hash_generated_method = "02BAEA013D3ACC3C680098C6E4D8E338")
    @Override
    public boolean retainAll(Collection<?> collection) {
        {
            EnumSet<?> set = (EnumSet<?>) collection;
            {
                boolean varBA48F6D095241919836645401D6F116E_1670364948 = (!isValidType(set.elementClass));
                {
                    {
                        clear();
                    } 
                } 
            } 
            HugeEnumSet<E> hugeSet = (HugeEnumSet<E>) set;
            boolean changed = false;
            {
                int i = 0;
                {
                    long oldBits = bits[i];
                    long newBits = oldBits & hugeSet.bits[i];
                    {
                        bits[i] = newBits;
                        size += Long.bitCount(newBits) - Long.bitCount(oldBits);
                        changed = true;
                    } 
                } 
            } 
        } 
        boolean var2CAA4A68044DBB7B5CB3E7FF23679230_2030117059 = (super.retainAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1028023169 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1028023169;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.343 -0400", hash_original_method = "8A87EADAF5D536F1830CF4EB88261592", hash_generated_method = "6DF938D7D18F70C2F35DAB9D92BD455B")
    @Override
     void setRange(E start, E end) {
        int startOrdinal = start.ordinal();
        int startIndex = startOrdinal / BIT_IN_LONG;
        int startInBits = startOrdinal % BIT_IN_LONG;
        int endOrdinal = end.ordinal();
        int endIndex = endOrdinal / BIT_IN_LONG;
        int endInBits = endOrdinal % BIT_IN_LONG;
        {
            long range = (-1L >>> (BIT_IN_LONG -(endInBits - startInBits + 1))) << startInBits;
            size -= Long.bitCount(bits[startIndex]);
            bits[startIndex] |= range;
            size += Long.bitCount(bits[startIndex]);
        } 
        {
            long range = (-1L >>> startInBits) << startInBits;
            size -= Long.bitCount(bits[startIndex]);
            bits[startIndex] |= range;
            size += Long.bitCount(bits[startIndex]);
            range = -1L >>> (BIT_IN_LONG - (endInBits + 1));
            size -= Long.bitCount(bits[endIndex]);
            bits[endIndex] |= range;
            size += Long.bitCount(bits[endIndex]);
            {
                int i = (startIndex + 1);
                {
                    size -= Long.bitCount(bits[i]);
                    bits[i] = -1L;
                    size += Long.bitCount(bits[i]);
                } 
            } 
        } 
        addTaint(start.getTaint());
        addTaint(end.getTaint());
        
        
    }

    
    private class HugeEnumSetIterator implements Iterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.343 -0400", hash_original_field = "82C47125B2259EDDE10B83EF1976B39A", hash_generated_field = "C1B6116DE9FEB291CD26A801EC34041A")

        private long currentBits = bits[0];
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.343 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")

        private int index;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.343 -0400", hash_original_field = "F2CE11EBF110993621BEDD8E747D7B1B", hash_generated_field = "EAE061265E9AAFE24A096DF314F2EEC2")

        private long mask;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.343 -0400", hash_original_field = "98BD1C45684CF587AC2347A92DD7BB51", hash_generated_field = "D8F234509BE4DCE084A89E169B9321DD")

        private E last;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.343 -0400", hash_original_method = "FF84D40F2248B9BB6D017CB27211B237", hash_generated_method = "93D38B12F784CDCB9694A9331A12A737")
        private  HugeEnumSetIterator() {
            computeNextElement();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.344 -0400", hash_original_method = "2CE5F24A4C571BEECB25C40400E44908", hash_generated_method = "B01AC19B8CE850FE23343A0E33487176")
         void computeNextElement() {
            {
                {
                    mask = currentBits & -currentBits;
                } 
                {
                    currentBits = bits[index];
                } 
                {
                    mask = 0;
                } 
            } 
            
            
                
                    
                    
                
                    
                
                    
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.344 -0400", hash_original_method = "04AD09EE87D1D0FB4F163A9180F152BA", hash_generated_method = "388925885EA7D5BA5C3F53984A234082")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1298072413 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1298072413;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.344 -0400", hash_original_method = "B99B4F6D513EFDAF8AFCA1BFB6A725C7", hash_generated_method = "81E6533FEB70C7DB8A2D2DA8BDB9A15E")
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_1241355822 = null; 
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } 
            int ordinal = Long.numberOfTrailingZeros(mask) + index * BIT_IN_LONG;
            last = enums[ordinal];
            currentBits &= ~mask;
            computeNextElement();
            varB4EAC82CA7396A68D541C85D26508E83_1241355822 = last;
            varB4EAC82CA7396A68D541C85D26508E83_1241355822.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1241355822;
            
            
                
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.345 -0400", hash_original_method = "56FBFE20B1E9D061DA542B4F3A5EEEAB", hash_generated_method = "2BC8768FFE79230446A2B3EDEC7C23AA")
        public void remove() {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            } 
            HugeEnumSet.this.remove(last);
            last = null;
            
            
                
            
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:09.345 -0400", hash_original_field = "0292F67E7C59ADF794759ADEDFC60560", hash_generated_field = "4752A7C1FB2BE83B3E8CBE7929135C61")

    private static final int BIT_IN_LONG = 64;
}

