package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

final class MiniEnumSet<E extends Enum<E>> extends EnumSet<E> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.249 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.250 -0400", hash_original_field = "407482FEF87D1B9F3A34AF46A705ABA8", hash_generated_field = "783D81D695A8378E8654E8D6DD3B9BE2")

    private E[] enums;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.250 -0400", hash_original_field = "CC411E6C13670E52124629B8AC83F7D0", hash_generated_field = "25B025E9A5F96E0701DCBD2F252ADF7D")

    private long bits;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.250 -0400", hash_original_method = "13D7CE02E81D272A0503942FC3D4E826", hash_generated_method = "CF87E59531B42BDC32200667DC7F0458")
      MiniEnumSet(Class<E> elementType, E[] enums) {
        super(elementType);
        addTaint(elementType.getTaint());
        this.enums = enums;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.250 -0400", hash_original_method = "B65740ADDB851C7AEA4DC0329B3A4F67", hash_generated_method = "C595DF64A4B249807B3847443D4FE7C3")
    @Override
    public Iterator<E> iterator() {
Iterator<E> var15F17A9EC28CD5C4699F216D04F7AF45_1393563 =         new MiniEnumSetIterator();
        var15F17A9EC28CD5C4699F216D04F7AF45_1393563.addTaint(taint);
        return var15F17A9EC28CD5C4699F216D04F7AF45_1393563;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.251 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "ADF5DCE77F6413A59102223D8039026B")
    @Override
    public int size() {
        int varF7BD60B75B29D79B660A2859395C1A24_1002857357 = (size);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1184397037 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1184397037;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.252 -0400", hash_original_method = "025226B2883D32895649213F93C1A199", hash_generated_method = "3713CFA0CB1A568F7EA76D80B212B858")
    @Override
    public void clear() {
        bits = 0;
        size = 0;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.253 -0400", hash_original_method = "0E09B1B284FABC8D1B6052C567B95409", hash_generated_method = "E9D0CBF034FB261AFA753506395FFB30")
    @Override
    public boolean add(E element) {
        addTaint(element.getTaint());
        elementClass.cast(element);
        long oldBits = bits;
        long newBits = oldBits | (1L << element.ordinal());
    if(oldBits != newBits)        
        {
            bits = newBits;
            size++;
            boolean varB326B5062B2F0E69046810717534CB09_1720284806 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_719404184 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_719404184;
        } 
        boolean var68934A3E9455FA72420237EB05902327_397388788 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1891078269 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1891078269;
        
        
        
        
        
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.254 -0400", hash_original_method = "CD3919E65A48A028AB158BD4B0E371DE", hash_generated_method = "F5893DEAFD40120826E8D35CC959ED46")
    @Override
    public boolean addAll(Collection<? extends E> collection) {
        addTaint(collection.getTaint());
    if(collection.isEmpty())        
        {
            boolean var68934A3E9455FA72420237EB05902327_179087583 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_44600446 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_44600446;
        } 
    if(collection instanceof EnumSet)        
        {
            EnumSet<?> set = (EnumSet) collection;
            set.elementClass.asSubclass(elementClass);
            MiniEnumSet<?> miniSet = (MiniEnumSet<?>) set;
            long oldBits = bits;
            long newBits = oldBits | miniSet.bits;
            bits = newBits;
            size = Long.bitCount(newBits);
            boolean varFC70C6FFC636294FBF57C338EA4F7851_924413446 = ((oldBits != newBits));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_714256640 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_714256640;
        } 
        boolean varB2042CE01B55200C7258CBFA6D7E5E4D_1426332315 = (super.addAll(collection));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1120155137 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1120155137;
        
        
            
        
        
            
            
            
            
            
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.255 -0400", hash_original_method = "574C67B26880FBDD7ECF2408ADA0BF3B", hash_generated_method = "DD25502B6C26536D645D3F1903D0CBA3")
    @Override
    public boolean contains(Object object) {
        addTaint(object.getTaint());
    if(object == null || !isValidType(object.getClass()))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1679314693 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_69032124 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_69032124;
        } 
        @SuppressWarnings("unchecked") Enum<E> element = (Enum<E>) object;
        int ordinal = element.ordinal();
        boolean varBB59F39C94E3C16864A1A047E9EF9EEC_319618990 = ((bits & (1L << ordinal)) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1224959651 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1224959651;
        
        
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.257 -0400", hash_original_method = "F9B76DA5C8885A8F064E3CAE60CAF100", hash_generated_method = "CACCC54EFEF4364FE09E83EA2F1EBC88")
    @Override
    public boolean containsAll(Collection<?> collection) {
        addTaint(collection.getTaint());
    if(collection.isEmpty())        
        {
            boolean varB326B5062B2F0E69046810717534CB09_504879876 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_694681124 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_694681124;
        } 
    if(collection instanceof MiniEnumSet)        
        {
            MiniEnumSet<?> set = (MiniEnumSet<?>) collection;
            long setBits = set.bits;
            boolean var47E022E6C7E98A97129EC3E197729329_421668961 = (isValidType(set.elementClass) && ((bits & setBits) == setBits));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_63548690 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_63548690;
        } 
        boolean var0F80B7441EDA20A6384C819B6A7145F9_769455926 = (!(collection instanceof EnumSet) && super.containsAll(collection));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_708368114 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_708368114;
        
        
            
        
        
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.259 -0400", hash_original_method = "0FAF468D35EFC7156A8E4C7EB1F47E75", hash_generated_method = "B203EA23BB37FF192949B1C4C2254A51")
    @Override
    public boolean removeAll(Collection<?> collection) {
        addTaint(collection.getTaint());
    if(collection.isEmpty())        
        {
            boolean var68934A3E9455FA72420237EB05902327_216462141 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_336296354 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_336296354;
        } 
    if(collection instanceof EnumSet)        
        {
            EnumSet<?> set = (EnumSet<?>) collection;
    if(!isValidType(set.elementClass))            
            {
                boolean var68934A3E9455FA72420237EB05902327_256234716 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_522414838 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_522414838;
            } 
            MiniEnumSet<E> miniSet = (MiniEnumSet<E>) set;
            long oldBits = bits;
            long newBits = oldBits & ~miniSet.bits;
    if(oldBits != newBits)            
            {
                bits = newBits;
                size = Long.bitCount(newBits);
                boolean varB326B5062B2F0E69046810717534CB09_287053967 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_79204994 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_79204994;
            } 
            boolean var68934A3E9455FA72420237EB05902327_1926690332 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_964450034 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_964450034;
        } 
        boolean varC59E950B034B0097B868C2C96544231D_601210581 = (super.removeAll(collection));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1844348507 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1844348507;
        
        
            
        
        
            
            
                
            
            
            
            
            
                
                
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.260 -0400", hash_original_method = "017E11B07B37D92215BE552EFD39EA89", hash_generated_method = "7CD810459803717106597FD1D8172F98")
    @Override
    public boolean retainAll(Collection<?> collection) {
        addTaint(collection.getTaint());
    if(collection instanceof EnumSet)        
        {
            EnumSet<?> set = (EnumSet<?>) collection;
    if(!isValidType(set.elementClass))            
            {
    if(size > 0)                
                {
                    clear();
                    boolean varB326B5062B2F0E69046810717534CB09_1724476779 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2127893697 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2127893697;
                } 
                else
                {
                    boolean var68934A3E9455FA72420237EB05902327_50444399 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1930850489 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1930850489;
                } 
            } 
            MiniEnumSet<E> miniSet = (MiniEnumSet<E>) set;
            long oldBits = bits;
            long newBits = oldBits & miniSet.bits;
    if(oldBits != newBits)            
            {
                bits = newBits;
                size = Long.bitCount(newBits);
                boolean varB326B5062B2F0E69046810717534CB09_432579933 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2071034084 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2071034084;
            } 
            boolean var68934A3E9455FA72420237EB05902327_397107497 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_215181008 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_215181008;
        } 
        boolean var503FF497CC541185965B7F24CCB51DB8_361802954 = (super.retainAll(collection));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_479945166 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_479945166;
        
        
            
            
                
                    
                    
                
                    
                
            
            
            
            
            
                
                
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.260 -0400", hash_original_method = "07B13756E56A1DF188CDC5BDB0B18ECF", hash_generated_method = "CB4649358C9639CBE5601B5C54757CF6")
    @Override
    public boolean remove(Object object) {
        addTaint(object.getTaint());
    if(object == null || !isValidType(object.getClass()))        
        {
            boolean var68934A3E9455FA72420237EB05902327_904525956 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_611559059 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_611559059;
        } 
        @SuppressWarnings("unchecked") Enum<E> element = (Enum<E>) object;
        int ordinal = element.ordinal();
        long oldBits = bits;
        long newBits = oldBits & ~(1L << ordinal);
    if(oldBits != newBits)        
        {
            bits = newBits;
            size--;
            boolean varB326B5062B2F0E69046810717534CB09_638067075 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1579674308 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1579674308;
        } 
        boolean var68934A3E9455FA72420237EB05902327_969854084 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1960918406 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1960918406;
        
        
            
        
        
        
        
        
        
        
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.261 -0400", hash_original_method = "0AE7A2B8046F11F65D5A1DDC2DB371C6", hash_generated_method = "20A81B020383EA998A51AEF8D5D68DC0")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
    if(!(object instanceof EnumSet))        
        {
            boolean var75EAEC12DA10D524D5BB1C4333283B8A_1232320569 = (super.equals(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_698281564 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_698281564;
        } 
        EnumSet<?> set = (EnumSet<?>) object;
    if(!isValidType(set.elementClass))        
        {
            boolean var50FBEE4B6B0931F2E34777F14FD04D99_1855790414 = (size == 0 && set.isEmpty());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1042751739 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1042751739;
        } 
        boolean var73FA85E2934753FD9B0FAEB53005796B_817792555 = (bits == ((MiniEnumSet<?>) set).bits);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1646254390 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1646254390;
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.262 -0400", hash_original_method = "34C2A46ACE6140E33D58771C1EEACFB4", hash_generated_method = "DAC34BCE88EAEE87FA2EBB9256194714")
    @Override
     void complement() {
    if(enums.length != 0)        
        {
            bits = ~bits;
            bits &= (-1L >>> (MAX_ELEMENTS - enums.length));
            size = enums.length - size;
        } 
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.263 -0400", hash_original_method = "9CD323C98F30FAEA7DF6B6CE47F14F1E", hash_generated_method = "C73C8BE214706D864CBE8D8F96708FC9")
    @Override
     void setRange(E start, E end) {
        addTaint(end.getTaint());
        addTaint(start.getTaint());
        int length = end.ordinal() - start.ordinal() + 1;
        long range = (-1L >>> (MAX_ELEMENTS - length)) << start.ordinal();
        bits |= range;
        size = Long.bitCount(bits);
        
        
        
        
        
    }

    
    private class MiniEnumSetIterator implements Iterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.263 -0400", hash_original_field = "07BF236F74164AE8CA171EFE1D2E297D", hash_generated_field = "88FE5C56F0ABD833B5AB4E83CA57D904")

        private long currentBits = bits;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.263 -0400", hash_original_field = "CA2B69B6B749FE20F8724D8E3D59ECE6", hash_generated_field = "E17CA9C849A83DC4D391140F1D677EB2")

        private long mask = currentBits & -currentBits;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.263 -0400", hash_original_field = "98BD1C45684CF587AC2347A92DD7BB51", hash_generated_field = "D8F234509BE4DCE084A89E169B9321DD")

        private E last;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.263 -0400", hash_original_method = "C8509CBB611C286825BCD6AFB35ADC31", hash_generated_method = "C8509CBB611C286825BCD6AFB35ADC31")
        public MiniEnumSetIterator ()
        {
            
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.264 -0400", hash_original_method = "04AD09EE87D1D0FB4F163A9180F152BA", hash_generated_method = "C498174E6D8B885D1BBA094226391ED4")
        public boolean hasNext() {
            boolean varD4C71BBF3A783D0D50DB7E2A5ECD4FBD_182845570 = (mask != 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_139797946 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_139797946;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.264 -0400", hash_original_method = "B8BEA11D538861DDC29BFADEA29DB32E", hash_generated_method = "CF6BA9B7890A7F7D2EEAF0F68FD067B8")
        public E next() {
    if(mask == 0)            
            {
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_978125415 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_978125415.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_978125415;
            } 
            int ordinal = Long.numberOfTrailingZeros(mask);
            last = enums[ordinal];
            currentBits &= ~mask;
            mask = currentBits & -currentBits;
E var3D331EA760A7BCD3BF7E380A6C79C638_1058988489 =             last;
            var3D331EA760A7BCD3BF7E380A6C79C638_1058988489.addTaint(taint);
            return var3D331EA760A7BCD3BF7E380A6C79C638_1058988489;
            
            
                
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.265 -0400", hash_original_method = "38D2DDD498ED91B92C87DCAC1BCF5E89", hash_generated_method = "692EDF902899B76EE5A5677F87AF36AB")
        public void remove() {
    if(last == null)            
            {
                IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1041172918 = new IllegalStateException();
                varC311A989A119B96A6232C22ABFE87C25_1041172918.addTaint(taint);
                throw varC311A989A119B96A6232C22ABFE87C25_1041172918;
            } 
            MiniEnumSet.this.remove(last);
            last = null;
            
            
                
            
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:12.265 -0400", hash_original_field = "69BBA9FE40C15A40E372B512E4AE5552", hash_generated_field = "C20853631EBCD7966CC4FD1460DE8CB9")

    private static final int MAX_ELEMENTS = 64;
}

