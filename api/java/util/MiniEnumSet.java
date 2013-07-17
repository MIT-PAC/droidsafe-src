package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

final class MiniEnumSet<E extends Enum<E>> extends EnumSet<E> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.278 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.278 -0400", hash_original_field = "407482FEF87D1B9F3A34AF46A705ABA8", hash_generated_field = "783D81D695A8378E8654E8D6DD3B9BE2")

    private E[] enums;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.278 -0400", hash_original_field = "CC411E6C13670E52124629B8AC83F7D0", hash_generated_field = "25B025E9A5F96E0701DCBD2F252ADF7D")

    private long bits;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.279 -0400", hash_original_method = "13D7CE02E81D272A0503942FC3D4E826", hash_generated_method = "CF87E59531B42BDC32200667DC7F0458")
      MiniEnumSet(Class<E> elementType, E[] enums) {
        super(elementType);
        addTaint(elementType.getTaint());
        this.enums = enums;
        // ---------- Original Method ----------
        //this.enums = enums;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.279 -0400", hash_original_method = "B65740ADDB851C7AEA4DC0329B3A4F67", hash_generated_method = "118E89A8613119A1E8AAA1F36B63272B")
    @Override
    public Iterator<E> iterator() {
Iterator<E> var15F17A9EC28CD5C4699F216D04F7AF45_263335921 =         new MiniEnumSetIterator();
        var15F17A9EC28CD5C4699F216D04F7AF45_263335921.addTaint(taint);
        return var15F17A9EC28CD5C4699F216D04F7AF45_263335921;
        // ---------- Original Method ----------
        //return new MiniEnumSetIterator();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.279 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "F127C3788DCACDEB0820D8A5D54D9320")
    @Override
    public int size() {
        int varF7BD60B75B29D79B660A2859395C1A24_476383498 = (size);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1147771604 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1147771604;
        // ---------- Original Method ----------
        //return size;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.280 -0400", hash_original_method = "025226B2883D32895649213F93C1A199", hash_generated_method = "3713CFA0CB1A568F7EA76D80B212B858")
    @Override
    public void clear() {
        bits = 0;
        size = 0;
        // ---------- Original Method ----------
        //bits = 0;
        //size = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.280 -0400", hash_original_method = "0E09B1B284FABC8D1B6052C567B95409", hash_generated_method = "EFBA53C24225B7069E6DE3CEA9344C24")
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
            boolean varB326B5062B2F0E69046810717534CB09_1887300272 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2039808187 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2039808187;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1675401650 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1373231472 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1373231472;
        // ---------- Original Method ----------
        //elementClass.cast(element);
        //long oldBits = bits;
        //long newBits = oldBits | (1L << element.ordinal());
        //if (oldBits != newBits) {
            //bits = newBits;
            //size++;
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.281 -0400", hash_original_method = "CD3919E65A48A028AB158BD4B0E371DE", hash_generated_method = "4F6A725F62E789F245D870F4D88CBD0C")
    @Override
    public boolean addAll(Collection<? extends E> collection) {
        addTaint(collection.getTaint());
        if(collection.isEmpty())        
        {
            boolean var68934A3E9455FA72420237EB05902327_504667330 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1226055573 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1226055573;
        } //End block
        if(collection instanceof EnumSet)        
        {
            EnumSet<?> set = (EnumSet) collection;
            set.elementClass.asSubclass(elementClass);
            MiniEnumSet<?> miniSet = (MiniEnumSet<?>) set;
            long oldBits = bits;
            long newBits = oldBits | miniSet.bits;
            bits = newBits;
            size = Long.bitCount(newBits);
            boolean varFC70C6FFC636294FBF57C338EA4F7851_2002878686 = ((oldBits != newBits));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1999307384 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1999307384;
        } //End block
        boolean varB2042CE01B55200C7258CBFA6D7E5E4D_1527397202 = (super.addAll(collection));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_718741175 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_718741175;
        // ---------- Original Method ----------
        //if (collection.isEmpty()) {
            //return false;
        //}
        //if (collection instanceof EnumSet) {
            //EnumSet<?> set = (EnumSet) collection; 
            //set.elementClass.asSubclass(elementClass); 
            //MiniEnumSet<?> miniSet = (MiniEnumSet<?>) set;
            //long oldBits = bits;
            //long newBits = oldBits | miniSet.bits;
            //bits = newBits;
            //size = Long.bitCount(newBits);
            //return (oldBits != newBits);
        //}
        //return super.addAll(collection);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.282 -0400", hash_original_method = "574C67B26880FBDD7ECF2408ADA0BF3B", hash_generated_method = "F6964E23FF624EB45F80B7A4D99DBEE7")
    @Override
    public boolean contains(Object object) {
        addTaint(object.getTaint());
        if(object == null || !isValidType(object.getClass()))        
        {
            boolean var68934A3E9455FA72420237EB05902327_863904640 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_660020607 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_660020607;
        } //End block
        @SuppressWarnings("unchecked") Enum<E> element = (Enum<E>) object;
        int ordinal = element.ordinal();
        boolean varBB59F39C94E3C16864A1A047E9EF9EEC_1492899020 = ((bits & (1L << ordinal)) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1577372387 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1577372387;
        // ---------- Original Method ----------
        //if (object == null || !isValidType(object.getClass())) {
            //return false;
        //}
        //@SuppressWarnings("unchecked") 
        //Enum<E> element = (Enum<E>) object;
        //int ordinal = element.ordinal();
        //return (bits & (1L << ordinal)) != 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.283 -0400", hash_original_method = "F9B76DA5C8885A8F064E3CAE60CAF100", hash_generated_method = "DD30CB464377174A99365999FD3F53A5")
    @Override
    public boolean containsAll(Collection<?> collection) {
        addTaint(collection.getTaint());
        if(collection.isEmpty())        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1734542910 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_845772179 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_845772179;
        } //End block
        if(collection instanceof MiniEnumSet)        
        {
            MiniEnumSet<?> set = (MiniEnumSet<?>) collection;
            long setBits = set.bits;
            boolean var47E022E6C7E98A97129EC3E197729329_390608509 = (isValidType(set.elementClass) && ((bits & setBits) == setBits));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1316426736 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1316426736;
        } //End block
        boolean var0F80B7441EDA20A6384C819B6A7145F9_993202726 = (!(collection instanceof EnumSet) && super.containsAll(collection));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1670399608 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1670399608;
        // ---------- Original Method ----------
        //if (collection.isEmpty()) {
            //return true;
        //}
        //if (collection instanceof MiniEnumSet) {
            //MiniEnumSet<?> set = (MiniEnumSet<?>) collection;
            //long setBits = set.bits;
            //return isValidType(set.elementClass) && ((bits & setBits) == setBits);
        //}
        //return !(collection instanceof EnumSet) && super.containsAll(collection);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.285 -0400", hash_original_method = "0FAF468D35EFC7156A8E4C7EB1F47E75", hash_generated_method = "540AAAC8766DDB8285B65782C24FABC4")
    @Override
    public boolean removeAll(Collection<?> collection) {
        addTaint(collection.getTaint());
        if(collection.isEmpty())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1852934087 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_840716189 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_840716189;
        } //End block
        if(collection instanceof EnumSet)        
        {
            EnumSet<?> set = (EnumSet<?>) collection;
            if(!isValidType(set.elementClass))            
            {
                boolean var68934A3E9455FA72420237EB05902327_444277718 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_28469708 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_28469708;
            } //End block
            MiniEnumSet<E> miniSet = (MiniEnumSet<E>) set;
            long oldBits = bits;
            long newBits = oldBits & ~miniSet.bits;
            if(oldBits != newBits)            
            {
                bits = newBits;
                size = Long.bitCount(newBits);
                boolean varB326B5062B2F0E69046810717534CB09_1185936447 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1557688666 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1557688666;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_440267799 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1657811563 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1657811563;
        } //End block
        boolean varC59E950B034B0097B868C2C96544231D_1448950808 = (super.removeAll(collection));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_817579843 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_817579843;
        // ---------- Original Method ----------
        //if (collection.isEmpty()) {
            //return false;
        //}
        //if (collection instanceof EnumSet) {
            //EnumSet<?> set = (EnumSet<?>) collection;
            //if (!isValidType(set.elementClass)) {
                //return false;
            //}
            //MiniEnumSet<E> miniSet = (MiniEnumSet<E>) set;
            //long oldBits = bits;
            //long newBits = oldBits & ~miniSet.bits;
            //if (oldBits != newBits) {
                //bits = newBits;
                //size = Long.bitCount(newBits);
                //return true;
            //}
            //return false;
        //}
        //return super.removeAll(collection);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.287 -0400", hash_original_method = "017E11B07B37D92215BE552EFD39EA89", hash_generated_method = "2A58FF6D476E586AD6C91B63DF639524")
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
                    boolean varB326B5062B2F0E69046810717534CB09_607164671 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_670295532 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_670295532;
                } //End block
                else
                {
                    boolean var68934A3E9455FA72420237EB05902327_1935710639 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_473895863 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_473895863;
                } //End block
            } //End block
            MiniEnumSet<E> miniSet = (MiniEnumSet<E>) set;
            long oldBits = bits;
            long newBits = oldBits & miniSet.bits;
            if(oldBits != newBits)            
            {
                bits = newBits;
                size = Long.bitCount(newBits);
                boolean varB326B5062B2F0E69046810717534CB09_613448727 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1495390900 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1495390900;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1602614311 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_269458913 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_269458913;
        } //End block
        boolean var503FF497CC541185965B7F24CCB51DB8_355431079 = (super.retainAll(collection));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_826334846 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_826334846;
        // ---------- Original Method ----------
        //if (collection instanceof EnumSet) {
            //EnumSet<?> set = (EnumSet<?>) collection;
            //if (!isValidType(set.elementClass)) {
                //if (size > 0) {
                    //clear();
                    //return true;
                //} else {
                    //return false;
                //}
            //}
            //MiniEnumSet<E> miniSet = (MiniEnumSet<E>) set;
            //long oldBits = bits;
            //long newBits = oldBits & miniSet.bits;
            //if (oldBits != newBits) {
                //bits = newBits;
                //size = Long.bitCount(newBits);
                //return true;
            //}
            //return false;
        //}
        //return super.retainAll(collection);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.288 -0400", hash_original_method = "07B13756E56A1DF188CDC5BDB0B18ECF", hash_generated_method = "169FFF01946DA7482FEF8FF403C4D7E5")
    @Override
    public boolean remove(Object object) {
        addTaint(object.getTaint());
        if(object == null || !isValidType(object.getClass()))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1486597978 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_614511495 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_614511495;
        } //End block
        @SuppressWarnings("unchecked") Enum<E> element = (Enum<E>) object;
        int ordinal = element.ordinal();
        long oldBits = bits;
        long newBits = oldBits & ~(1L << ordinal);
        if(oldBits != newBits)        
        {
            bits = newBits;
            size--;
            boolean varB326B5062B2F0E69046810717534CB09_470715276 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_533143923 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_533143923;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1735041871 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_629381028 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_629381028;
        // ---------- Original Method ----------
        //if (object == null || !isValidType(object.getClass())) {
            //return false;
        //}
        //@SuppressWarnings("unchecked") 
        //Enum<E> element = (Enum<E>) object;
        //int ordinal = element.ordinal();
        //long oldBits = bits;
        //long newBits = oldBits & ~(1L << ordinal);
        //if (oldBits != newBits) {
            //bits = newBits;
            //size--;
            //return true;
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.289 -0400", hash_original_method = "0AE7A2B8046F11F65D5A1DDC2DB371C6", hash_generated_method = "3C4BBC1C94F5D4599F1B1F6C7CB6AE44")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        if(!(object instanceof EnumSet))        
        {
            boolean var75EAEC12DA10D524D5BB1C4333283B8A_1147822514 = (super.equals(object));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1754061775 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1754061775;
        } //End block
        EnumSet<?> set = (EnumSet<?>) object;
        if(!isValidType(set.elementClass))        
        {
            boolean var50FBEE4B6B0931F2E34777F14FD04D99_425176538 = (size == 0 && set.isEmpty());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_224985145 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_224985145;
        } //End block
        boolean var73FA85E2934753FD9B0FAEB53005796B_1348902703 = (bits == ((MiniEnumSet<?>) set).bits);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_431370212 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_431370212;
        // ---------- Original Method ----------
        //if (!(object instanceof EnumSet)) {
            //return super.equals(object);
        //}
        //EnumSet<?> set =(EnumSet<?>) object;
        //if (!isValidType(set.elementClass)) {
            //return size == 0 && set.isEmpty();
        //}
        //return bits == ((MiniEnumSet<?>) set).bits;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.290 -0400", hash_original_method = "34C2A46ACE6140E33D58771C1EEACFB4", hash_generated_method = "DAC34BCE88EAEE87FA2EBB9256194714")
    @Override
     void complement() {
        if(enums.length != 0)        
        {
            bits = ~bits;
            bits &= (-1L >>> (MAX_ELEMENTS - enums.length));
            size = enums.length - size;
        } //End block
        // ---------- Original Method ----------
        //if (enums.length != 0) {
            //bits = ~bits;
            //bits &= (-1L >>> (MAX_ELEMENTS - enums.length));
            //size = enums.length - size;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.291 -0400", hash_original_method = "9CD323C98F30FAEA7DF6B6CE47F14F1E", hash_generated_method = "C73C8BE214706D864CBE8D8F96708FC9")
    @Override
     void setRange(E start, E end) {
        addTaint(end.getTaint());
        addTaint(start.getTaint());
        int length = end.ordinal() - start.ordinal() + 1;
        long range = (-1L >>> (MAX_ELEMENTS - length)) << start.ordinal();
        bits |= range;
        size = Long.bitCount(bits);
        // ---------- Original Method ----------
        //int length = end.ordinal() - start.ordinal() + 1;
        //long range = (-1L >>> (MAX_ELEMENTS - length)) << start.ordinal();
        //bits |= range;
        //size = Long.bitCount(bits);
    }

    
    private class MiniEnumSetIterator implements Iterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.291 -0400", hash_original_field = "07BF236F74164AE8CA171EFE1D2E297D", hash_generated_field = "88FE5C56F0ABD833B5AB4E83CA57D904")

        private long currentBits = bits;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.292 -0400", hash_original_field = "CA2B69B6B749FE20F8724D8E3D59ECE6", hash_generated_field = "E17CA9C849A83DC4D391140F1D677EB2")

        private long mask = currentBits & -currentBits;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.292 -0400", hash_original_field = "98BD1C45684CF587AC2347A92DD7BB51", hash_generated_field = "D8F234509BE4DCE084A89E169B9321DD")

        private E last;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.292 -0400", hash_original_method = "C8509CBB611C286825BCD6AFB35ADC31", hash_generated_method = "C8509CBB611C286825BCD6AFB35ADC31")
        public MiniEnumSetIterator ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.292 -0400", hash_original_method = "04AD09EE87D1D0FB4F163A9180F152BA", hash_generated_method = "F472BE255A489C2A1179BC5E52C90CC3")
        public boolean hasNext() {
            boolean varD4C71BBF3A783D0D50DB7E2A5ECD4FBD_1201051092 = (mask != 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1178279139 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1178279139;
            // ---------- Original Method ----------
            //return mask != 0;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.293 -0400", hash_original_method = "B8BEA11D538861DDC29BFADEA29DB32E", hash_generated_method = "89F171DA0F9D04770BD4E746548D29EA")
        public E next() {
            if(mask == 0)            
            {
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_1453914612 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_1453914612.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_1453914612;
            } //End block
            int ordinal = Long.numberOfTrailingZeros(mask);
            last = enums[ordinal];
            currentBits &= ~mask;
            mask = currentBits & -currentBits;
E var3D331EA760A7BCD3BF7E380A6C79C638_1948341723 =             last;
            var3D331EA760A7BCD3BF7E380A6C79C638_1948341723.addTaint(taint);
            return var3D331EA760A7BCD3BF7E380A6C79C638_1948341723;
            // ---------- Original Method ----------
            //if (mask == 0) {
                //throw new NoSuchElementException();
            //}
            //int ordinal = Long.numberOfTrailingZeros(mask);
            //last = enums[ordinal];
            //currentBits &= ~mask;
            //mask = currentBits & -currentBits;
            //return last;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.294 -0400", hash_original_method = "38D2DDD498ED91B92C87DCAC1BCF5E89", hash_generated_method = "7A5E6AE6C23AB050DDD7F1862982456C")
        public void remove() {
            if(last == null)            
            {
                IllegalStateException varC311A989A119B96A6232C22ABFE87C25_2116676902 = new IllegalStateException();
                varC311A989A119B96A6232C22ABFE87C25_2116676902.addTaint(taint);
                throw varC311A989A119B96A6232C22ABFE87C25_2116676902;
            } //End block
            MiniEnumSet.this.remove(last);
            last = null;
            // ---------- Original Method ----------
            //if (last == null) {
                //throw new IllegalStateException();
            //}
            //MiniEnumSet.this.remove(last);
            //last = null;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.294 -0400", hash_original_field = "69BBA9FE40C15A40E372B512E4AE5552", hash_generated_field = "C20853631EBCD7966CC4FD1460DE8CB9")

    private static final int MAX_ELEMENTS = 64;
}

