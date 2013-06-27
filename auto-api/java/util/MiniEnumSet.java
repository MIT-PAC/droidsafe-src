package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class MiniEnumSet<E extends Enum<E>> extends EnumSet<E> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.536 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.536 -0400", hash_original_field = "407482FEF87D1B9F3A34AF46A705ABA8", hash_generated_field = "783D81D695A8378E8654E8D6DD3B9BE2")

    private E[] enums;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.537 -0400", hash_original_field = "CC411E6C13670E52124629B8AC83F7D0", hash_generated_field = "25B025E9A5F96E0701DCBD2F252ADF7D")

    private long bits;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.537 -0400", hash_original_method = "13D7CE02E81D272A0503942FC3D4E826", hash_generated_method = "AD8AE212E8C28301F48859353584F813")
      MiniEnumSet(Class<E> elementType, E[] enums) {
        super(elementType);
        this.enums = enums;
        addTaint(elementType.getTaint());
        // ---------- Original Method ----------
        //this.enums = enums;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.537 -0400", hash_original_method = "B65740ADDB851C7AEA4DC0329B3A4F67", hash_generated_method = "277F8256059FF5089DF73D5951EFF083")
    @Override
    public Iterator<E> iterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_1540260183 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1540260183 = new MiniEnumSetIterator();
        varB4EAC82CA7396A68D541C85D26508E83_1540260183.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1540260183;
        // ---------- Original Method ----------
        //return new MiniEnumSetIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.548 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "8A7430BE73D059DCB39306564FE546B3")
    @Override
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_381683208 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_381683208;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.548 -0400", hash_original_method = "025226B2883D32895649213F93C1A199", hash_generated_method = "3713CFA0CB1A568F7EA76D80B212B858")
    @Override
    public void clear() {
        bits = 0;
        size = 0;
        // ---------- Original Method ----------
        //bits = 0;
        //size = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.549 -0400", hash_original_method = "0E09B1B284FABC8D1B6052C567B95409", hash_generated_method = "2023C0CF5CDDB29CBA3C2F21BA28D073")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_316678573 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_316678573;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.550 -0400", hash_original_method = "CD3919E65A48A028AB158BD4B0E371DE", hash_generated_method = "3B46603E9818BDAD0018EC91679D2991")
    @Override
    public boolean addAll(Collection<? extends E> collection) {
        {
            boolean var8E459D14D8063CC6C44012E6D0BE3338_70602653 = (collection.isEmpty());
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
        boolean varEB611C777D04833FE5AA6B71D18D3718_1401632392 = (super.addAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_776019461 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_776019461;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.551 -0400", hash_original_method = "574C67B26880FBDD7ECF2408ADA0BF3B", hash_generated_method = "2ECF58AB8B51E10CAE70A04753A3EE5D")
    @Override
    public boolean contains(Object object) {
        {
            boolean varE5952BCD6CF6F9557D7D5FDD0B6C62AB_1369601616 = (object == null || !isValidType(object.getClass()));
        } //End collapsed parenthetic
        @SuppressWarnings("unchecked") Enum<E> element;
        element = (Enum<E>) object;
        int ordinal;
        ordinal = element.ordinal();
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1924507235 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1924507235;
        // ---------- Original Method ----------
        //if (object == null || !isValidType(object.getClass())) {
            //return false;
        //}
        //@SuppressWarnings("unchecked") 
        //Enum<E> element = (Enum<E>) object;
        //int ordinal = element.ordinal();
        //return (bits & (1L << ordinal)) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.555 -0400", hash_original_method = "F9B76DA5C8885A8F064E3CAE60CAF100", hash_generated_method = "2D9B0FDA58793B4646DCD2CB55B9BE26")
    @Override
    public boolean containsAll(Collection<?> collection) {
        {
            boolean var8E459D14D8063CC6C44012E6D0BE3338_1858834284 = (collection.isEmpty());
        } //End collapsed parenthetic
        {
            MiniEnumSet<?> set;
            set = (MiniEnumSet<?>) collection;
            long setBits;
            setBits = set.bits;
            boolean var93B6B958A6AC0A8EBACDC756BD7806A7_265985174 = (isValidType(set.elementClass) && ((bits & setBits) == setBits));
        } //End block
        boolean varF7A7E8D103444376F893F3304E0C70F4_232880005 = (!(collection instanceof EnumSet) && super.containsAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1317107310 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1317107310;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.564 -0400", hash_original_method = "0FAF468D35EFC7156A8E4C7EB1F47E75", hash_generated_method = "ECBD07AAA6A16180BC2B169436946B04")
    @Override
    public boolean removeAll(Collection<?> collection) {
        {
            boolean var8E459D14D8063CC6C44012E6D0BE3338_1473180811 = (collection.isEmpty());
        } //End collapsed parenthetic
        {
            EnumSet<?> set;
            set = (EnumSet<?>) collection;
            {
                boolean varBA48F6D095241919836645401D6F116E_2082606993 = (!isValidType(set.elementClass));
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
        boolean var683870BA88109C83545AC694C96B458A_443795566 = (super.removeAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1706789761 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1706789761;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.565 -0400", hash_original_method = "017E11B07B37D92215BE552EFD39EA89", hash_generated_method = "EF86C76C383AC5D48FB43E09A0C21DF9")
    @Override
    public boolean retainAll(Collection<?> collection) {
        {
            EnumSet<?> set;
            set = (EnumSet<?>) collection;
            {
                boolean varBA48F6D095241919836645401D6F116E_1709751095 = (!isValidType(set.elementClass));
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
        boolean var2CAA4A68044DBB7B5CB3E7FF23679230_639098605 = (super.retainAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1621545311 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1621545311;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.567 -0400", hash_original_method = "07B13756E56A1DF188CDC5BDB0B18ECF", hash_generated_method = "A6A759DEE7F3A09CEBCA57824C87FBDC")
    @Override
    public boolean remove(Object object) {
        {
            boolean varE5952BCD6CF6F9557D7D5FDD0B6C62AB_1945803611 = (object == null || !isValidType(object.getClass()));
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1549722793 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1549722793;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.570 -0400", hash_original_method = "0AE7A2B8046F11F65D5A1DDC2DB371C6", hash_generated_method = "4587A8E42FCFB9F00B80B099868D16D8")
    @Override
    public boolean equals(Object object) {
        {
            boolean varA3157AA9BC21D9DE63321077403F3F07_732709132 = (super.equals(object));
        } //End block
        EnumSet<?> set;
        set = (EnumSet<?>) object;
        {
            boolean varE0C6366ACDFFC19A967EC6EBA42CF1D3_960208219 = (!isValidType(set.elementClass));
            {
                boolean var41497F9839595E472A090345E803B801_149261927 = (size == 0 && set.isEmpty());
            } //End block
        } //End collapsed parenthetic
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1127082306 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1127082306;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.579 -0400", hash_original_method = "34C2A46ACE6140E33D58771C1EEACFB4", hash_generated_method = "6F1899A8331862B6AAAFE7081C3AC22F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.580 -0400", hash_original_method = "9CD323C98F30FAEA7DF6B6CE47F14F1E", hash_generated_method = "823245D058B683C74C25E635460171B7")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.580 -0400", hash_original_field = "07BF236F74164AE8CA171EFE1D2E297D", hash_generated_field = "88FE5C56F0ABD833B5AB4E83CA57D904")

        private long currentBits = bits;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.580 -0400", hash_original_field = "CA2B69B6B749FE20F8724D8E3D59ECE6", hash_generated_field = "E17CA9C849A83DC4D391140F1D677EB2")

        private long mask = currentBits & -currentBits;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.580 -0400", hash_original_field = "98BD1C45684CF587AC2347A92DD7BB51", hash_generated_field = "D8F234509BE4DCE084A89E169B9321DD")

        private E last;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.580 -0400", hash_original_method = "C8509CBB611C286825BCD6AFB35ADC31", hash_generated_method = "C8509CBB611C286825BCD6AFB35ADC31")
        public MiniEnumSetIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.581 -0400", hash_original_method = "04AD09EE87D1D0FB4F163A9180F152BA", hash_generated_method = "2836E2831FE132659956562E13EC4006")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1144817303 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1144817303;
            // ---------- Original Method ----------
            //return mask != 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.584 -0400", hash_original_method = "B8BEA11D538861DDC29BFADEA29DB32E", hash_generated_method = "DF2842D938A5790EBE61573196742878")
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_1647199398 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            int ordinal;
            ordinal = Long.numberOfTrailingZeros(mask);
            last = enums[ordinal];
            currentBits &= ~mask;
            mask = currentBits & -currentBits;
            varB4EAC82CA7396A68D541C85D26508E83_1647199398 = last;
            varB4EAC82CA7396A68D541C85D26508E83_1647199398.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1647199398;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.591 -0400", hash_original_method = "38D2DDD498ED91B92C87DCAC1BCF5E89", hash_generated_method = "9F2589A46E153F3C77CD7B2E7DB6922D")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:52.591 -0400", hash_original_field = "69BBA9FE40C15A40E372B512E4AE5552", hash_generated_field = "4D8BB5842CEA17D77F18D427669FCFAA")

    private static int MAX_ELEMENTS = 64;
}

