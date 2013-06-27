package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class MiniEnumSet<E extends Enum<E>> extends EnumSet<E> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.413 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.413 -0400", hash_original_field = "407482FEF87D1B9F3A34AF46A705ABA8", hash_generated_field = "783D81D695A8378E8654E8D6DD3B9BE2")

    private E[] enums;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.413 -0400", hash_original_field = "CC411E6C13670E52124629B8AC83F7D0", hash_generated_field = "25B025E9A5F96E0701DCBD2F252ADF7D")

    private long bits;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.414 -0400", hash_original_method = "13D7CE02E81D272A0503942FC3D4E826", hash_generated_method = "AD8AE212E8C28301F48859353584F813")
      MiniEnumSet(Class<E> elementType, E[] enums) {
        super(elementType);
        this.enums = enums;
        addTaint(elementType.getTaint());
        // ---------- Original Method ----------
        //this.enums = enums;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.415 -0400", hash_original_method = "B65740ADDB851C7AEA4DC0329B3A4F67", hash_generated_method = "B17B3670CC603F3A5DBF32E9AE75748B")
    @Override
    public Iterator<E> iterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_583321485 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_583321485 = new MiniEnumSetIterator();
        varB4EAC82CA7396A68D541C85D26508E83_583321485.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_583321485;
        // ---------- Original Method ----------
        //return new MiniEnumSetIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.415 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "127D442A1FA7740E7F2020848E6E2D9B")
    @Override
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1995153204 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1995153204;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.415 -0400", hash_original_method = "025226B2883D32895649213F93C1A199", hash_generated_method = "3713CFA0CB1A568F7EA76D80B212B858")
    @Override
    public void clear() {
        bits = 0;
        size = 0;
        // ---------- Original Method ----------
        //bits = 0;
        //size = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.424 -0400", hash_original_method = "0E09B1B284FABC8D1B6052C567B95409", hash_generated_method = "B8CB31AABB68401541AF6A7CD7E33F5B")
    @Override
    public boolean add(E element) {
        elementClass.cast(element);
        long oldBits;
        oldBits = bits;
        long newBits;
        newBits = oldBits | (1L << element.ordinal());
        {
            bits = newBits;
        } //End block
        addTaint(element.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_678006769 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_678006769;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.425 -0400", hash_original_method = "CD3919E65A48A028AB158BD4B0E371DE", hash_generated_method = "83CF9A2C816872080DF249AE74ADF60A")
    @Override
    public boolean addAll(Collection<? extends E> collection) {
        {
            boolean var8E459D14D8063CC6C44012E6D0BE3338_1435864999 = (collection.isEmpty());
        } //End collapsed parenthetic
        {
            EnumSet<?> set;
            set = (EnumSet) collection;
            set.elementClass.asSubclass(elementClass);
            MiniEnumSet<?> miniSet;
            miniSet = (MiniEnumSet<?>) set;
            long oldBits;
            oldBits = bits;
            long newBits;
            newBits = oldBits | miniSet.bits;
            bits = newBits;
            size = Long.bitCount(newBits);
        } //End block
        boolean varEB611C777D04833FE5AA6B71D18D3718_517994786 = (super.addAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2068611655 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2068611655;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.426 -0400", hash_original_method = "574C67B26880FBDD7ECF2408ADA0BF3B", hash_generated_method = "9881B36F2375E97F3E349A788301F95C")
    @Override
    public boolean contains(Object object) {
        {
            boolean varE5952BCD6CF6F9557D7D5FDD0B6C62AB_627873560 = (object == null || !isValidType(object.getClass()));
        } //End collapsed parenthetic
        @SuppressWarnings("unchecked") Enum<E> element;
        element = (Enum<E>) object;
        int ordinal;
        ordinal = element.ordinal();
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2144401177 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2144401177;
        // ---------- Original Method ----------
        //if (object == null || !isValidType(object.getClass())) {
            //return false;
        //}
        //@SuppressWarnings("unchecked") 
        //Enum<E> element = (Enum<E>) object;
        //int ordinal = element.ordinal();
        //return (bits & (1L << ordinal)) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.427 -0400", hash_original_method = "F9B76DA5C8885A8F064E3CAE60CAF100", hash_generated_method = "883111A620944DE7C9AB207602C66459")
    @Override
    public boolean containsAll(Collection<?> collection) {
        {
            boolean var8E459D14D8063CC6C44012E6D0BE3338_788949293 = (collection.isEmpty());
        } //End collapsed parenthetic
        {
            MiniEnumSet<?> set;
            set = (MiniEnumSet<?>) collection;
            long setBits;
            setBits = set.bits;
            boolean var93B6B958A6AC0A8EBACDC756BD7806A7_1484808514 = (isValidType(set.elementClass) && ((bits & setBits) == setBits));
        } //End block
        boolean varF7A7E8D103444376F893F3304E0C70F4_1621074924 = (!(collection instanceof EnumSet) && super.containsAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_800844303 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_800844303;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.461 -0400", hash_original_method = "0FAF468D35EFC7156A8E4C7EB1F47E75", hash_generated_method = "80B3C97214999FDA76237B13FFBC70E8")
    @Override
    public boolean removeAll(Collection<?> collection) {
        {
            boolean var8E459D14D8063CC6C44012E6D0BE3338_2012553022 = (collection.isEmpty());
        } //End collapsed parenthetic
        {
            EnumSet<?> set;
            set = (EnumSet<?>) collection;
            {
                boolean varBA48F6D095241919836645401D6F116E_1990729821 = (!isValidType(set.elementClass));
            } //End collapsed parenthetic
            MiniEnumSet<E> miniSet;
            miniSet = (MiniEnumSet<E>) set;
            long oldBits;
            oldBits = bits;
            long newBits;
            newBits = oldBits & ~miniSet.bits;
            {
                bits = newBits;
                size = Long.bitCount(newBits);
            } //End block
        } //End block
        boolean var683870BA88109C83545AC694C96B458A_503783665 = (super.removeAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1342435393 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1342435393;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.464 -0400", hash_original_method = "017E11B07B37D92215BE552EFD39EA89", hash_generated_method = "A9D3BDB906437BFCE8B0572EDE2C37D8")
    @Override
    public boolean retainAll(Collection<?> collection) {
        {
            EnumSet<?> set;
            set = (EnumSet<?>) collection;
            {
                boolean varBA48F6D095241919836645401D6F116E_1142983626 = (!isValidType(set.elementClass));
                {
                    {
                        clear();
                    } //End block
                } //End block
            } //End collapsed parenthetic
            MiniEnumSet<E> miniSet;
            miniSet = (MiniEnumSet<E>) set;
            long oldBits;
            oldBits = bits;
            long newBits;
            newBits = oldBits & miniSet.bits;
            {
                bits = newBits;
                size = Long.bitCount(newBits);
            } //End block
        } //End block
        boolean var2CAA4A68044DBB7B5CB3E7FF23679230_546935023 = (super.retainAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1996357050 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1996357050;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.464 -0400", hash_original_method = "07B13756E56A1DF188CDC5BDB0B18ECF", hash_generated_method = "F3FF6A8627D87B790E6199AC18A84F88")
    @Override
    public boolean remove(Object object) {
        {
            boolean varE5952BCD6CF6F9557D7D5FDD0B6C62AB_1770669152 = (object == null || !isValidType(object.getClass()));
        } //End collapsed parenthetic
        @SuppressWarnings("unchecked") Enum<E> element;
        element = (Enum<E>) object;
        int ordinal;
        ordinal = element.ordinal();
        long oldBits;
        oldBits = bits;
        long newBits;
        newBits = oldBits & ~(1L << ordinal);
        {
            bits = newBits;
        } //End block
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_877002766 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_877002766;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.465 -0400", hash_original_method = "0AE7A2B8046F11F65D5A1DDC2DB371C6", hash_generated_method = "2EAFECF4E5763B4445CC32E81CB756A9")
    @Override
    public boolean equals(Object object) {
        {
            boolean varA3157AA9BC21D9DE63321077403F3F07_1537291099 = (super.equals(object));
        } //End block
        EnumSet<?> set;
        set = (EnumSet<?>) object;
        {
            boolean varE0C6366ACDFFC19A967EC6EBA42CF1D3_546421833 = (!isValidType(set.elementClass));
            {
                boolean var41497F9839595E472A090345E803B801_619988845 = (size == 0 && set.isEmpty());
            } //End block
        } //End collapsed parenthetic
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1729598798 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1729598798;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.465 -0400", hash_original_method = "34C2A46ACE6140E33D58771C1EEACFB4", hash_generated_method = "6F1899A8331862B6AAAFE7081C3AC22F")
    @Override
     void complement() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.466 -0400", hash_original_method = "9CD323C98F30FAEA7DF6B6CE47F14F1E", hash_generated_method = "823245D058B683C74C25E635460171B7")
    @Override
     void setRange(E start, E end) {
        int length;
        length = end.ordinal() - start.ordinal() + 1;
        long range;
        range = (-1L >>> (MAX_ELEMENTS - length)) << start.ordinal();
        bits |= range;
        size = Long.bitCount(bits);
        addTaint(start.getTaint());
        addTaint(end.getTaint());
        // ---------- Original Method ----------
        //int length = end.ordinal() - start.ordinal() + 1;
        //long range = (-1L >>> (MAX_ELEMENTS - length)) << start.ordinal();
        //bits |= range;
        //size = Long.bitCount(bits);
    }

    
    private class MiniEnumSetIterator implements Iterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.466 -0400", hash_original_field = "07BF236F74164AE8CA171EFE1D2E297D", hash_generated_field = "88FE5C56F0ABD833B5AB4E83CA57D904")

        private long currentBits = bits;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.466 -0400", hash_original_field = "CA2B69B6B749FE20F8724D8E3D59ECE6", hash_generated_field = "E17CA9C849A83DC4D391140F1D677EB2")

        private long mask = currentBits & -currentBits;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.466 -0400", hash_original_field = "98BD1C45684CF587AC2347A92DD7BB51", hash_generated_field = "D8F234509BE4DCE084A89E169B9321DD")

        private E last;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.466 -0400", hash_original_method = "C8509CBB611C286825BCD6AFB35ADC31", hash_generated_method = "C8509CBB611C286825BCD6AFB35ADC31")
        public MiniEnumSetIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.466 -0400", hash_original_method = "04AD09EE87D1D0FB4F163A9180F152BA", hash_generated_method = "EFBAE10367DD0DC1C6C7D1B8D723DB17")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_343589115 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_343589115;
            // ---------- Original Method ----------
            //return mask != 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.467 -0400", hash_original_method = "B8BEA11D538861DDC29BFADEA29DB32E", hash_generated_method = "3BF5515AA3F051DA5D63F8B1EAE45C33")
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_135233278 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            int ordinal;
            ordinal = Long.numberOfTrailingZeros(mask);
            last = enums[ordinal];
            currentBits &= ~mask;
            mask = currentBits & -currentBits;
            varB4EAC82CA7396A68D541C85D26508E83_135233278 = last;
            varB4EAC82CA7396A68D541C85D26508E83_135233278.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_135233278;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.467 -0400", hash_original_method = "38D2DDD498ED91B92C87DCAC1BCF5E89", hash_generated_method = "9F2589A46E153F3C77CD7B2E7DB6922D")
        public void remove() {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.467 -0400", hash_original_field = "69BBA9FE40C15A40E372B512E4AE5552", hash_generated_field = "4D8BB5842CEA17D77F18D427669FCFAA")

    private static int MAX_ELEMENTS = 64;
}

