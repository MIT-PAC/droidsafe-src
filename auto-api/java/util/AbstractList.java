package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.132 -0400", hash_original_field = "675B3022548A1029F9CE7A2C25B23BBF", hash_generated_field = "D904B48F1A1A3F19ECDEE2D75BF7C70B")

    protected transient int modCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.132 -0400", hash_original_method = "AFDDADD59FA06C48A3131F90ADCD1B27", hash_generated_method = "C2512795C4B4D09B5344EF8EABF2A19D")
    protected  AbstractList() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.132 -0400", hash_original_method = "CE54A57EF9628E9FD413F964E9F93054", hash_generated_method = "9596757B6E84B2AA8BF70433E534F821")
    public void add(int location, E object) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(location);
        addTaint(object.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.146 -0400", hash_original_method = "A9C598D3B94D3691F1716D511A033C5A", hash_generated_method = "7E5FF9E478A232B03E75EB11ECD00055")
    @Override
    public boolean add(E object) {
        add(size(), object);
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_894484023 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_894484023;
        // ---------- Original Method ----------
        //add(size(), object);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.146 -0400", hash_original_method = "35A5EA4215B8229218ACFA970E186418", hash_generated_method = "5E85498F9255C881FCFFD8254A6912C6")
    public boolean addAll(int location, Collection<? extends E> collection) {
        Iterator<? extends E> it;
        it = collection.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_222888621 = (it.hasNext());
            {
                add(location++, it.next());
            } //End block
        } //End collapsed parenthetic
        boolean varC9B9340AFA14E32A65F062ED6654285F_450181849 = (!collection.isEmpty());
        addTaint(location);
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_729912392 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_729912392;
        // ---------- Original Method ----------
        //Iterator<? extends E> it = collection.iterator();
        //while (it.hasNext()) {
            //add(location++, it.next());
        //}
        //return !collection.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.146 -0400", hash_original_method = "5B9E7BA75E1ADB49B9D7BF05321EEAAC", hash_generated_method = "C69094AE531324E916D6ECED92924926")
    @Override
    public void clear() {
        removeRange(0, size());
        // ---------- Original Method ----------
        //removeRange(0, size());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.147 -0400", hash_original_method = "FBFDCAC8150A508191130E5D508BCC64", hash_generated_method = "687B03BE19912BD4397C19595FEBEB7B")
    @Override
    public boolean equals(Object object) {
        {
            List<?> list;
            list = (List<?>) object;
            {
                boolean varA9150772F4537FBC840B06B3C897B779_1757130114 = (list.size() != size());
            } //End collapsed parenthetic
            Iterator<?> it1, it2;
            it1 = iterator();
            it2 = list.iterator();
            {
                boolean varC97010C6090A22C1711E67CA85FED63A_172595336 = (it1.hasNext());
                {
                    Object e1, e2;
                    e1 = it1.next();
                    e2 = it2.next();
                    {
                        boolean var340C63FF299BF53687C9CFA16F96F134_1935948498 = (!(e1 == null ? e2 == null : e1.equals(e2))); //DSFIXME:  CODE0008: Nested ternary operator in expression
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_801833629 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_801833629;
        // ---------- Original Method ----------
        //if (this == object) {
            //return true;
        //}
        //if (object instanceof List) {
            //List<?> list = (List<?>) object;
            //if (list.size() != size()) {
                //return false;
            //}
            //Iterator<?> it1 = iterator(), it2 = list.iterator();
            //while (it1.hasNext()) {
                //Object e1 = it1.next(), e2 = it2.next();
                //if (!(e1 == null ? e2 == null : e1.equals(e2))) {
                    //return false;
                //}
            //}
            //return true;
        //}
        //return false;
    }

    
    public abstract E get(int location);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.147 -0400", hash_original_method = "4C126AEA105405AEB8FC6F1BC74D780D", hash_generated_method = "51CAA5D17EC935ABD1D24AD75B9B68E8")
    @Override
    public int hashCode() {
        int result;
        result = 1;
        Iterator<?> it;
        it = iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1695522969 = (it.hasNext());
            {
                Object object;
                object = it.next();
                result = (31 * result) + (object == null ? 0 : object.hashCode());
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1469873679 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1469873679;
        // ---------- Original Method ----------
        //int result = 1;
        //Iterator<?> it = iterator();
        //while (it.hasNext()) {
            //Object object = it.next();
            //result = (31 * result) + (object == null ? 0 : object.hashCode());
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.149 -0400", hash_original_method = "33CCCA11E9065665C3CB5AA775E1CF23", hash_generated_method = "09356A4F014C09B65565CCAA67F9504A")
    public int indexOf(Object object) {
        ListIterator<?> it;
        it = listIterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1497952761 = (it.hasNext());
                {
                    {
                        boolean var4D12F9DEE5A39D7BC693B301D62540B3_1923236766 = (object.equals(it.next()));
                        {
                            int var2605601C0E634FE1A7392F98BEA34857_678441703 = (it.previousIndex());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_397471813 = (it.hasNext());
                {
                    {
                        boolean varC926108249FA4A04B2CDE2B4A6BD66E6_934661737 = (it.next() == null);
                        {
                            int var2605601C0E634FE1A7392F98BEA34857_992983900 = (it.previousIndex());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(object.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_537006961 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_537006961;
        // ---------- Original Method ----------
        //ListIterator<?> it = listIterator();
        //if (object != null) {
            //while (it.hasNext()) {
                //if (object.equals(it.next())) {
                    //return it.previousIndex();
                //}
            //}
        //} else {
            //while (it.hasNext()) {
                //if (it.next() == null) {
                    //return it.previousIndex();
                //}
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.149 -0400", hash_original_method = "20CA001488534933B2DD59F566742F0C", hash_generated_method = "608149D7959E2A986FD087BA2E09EB6D")
    @Override
    public Iterator<E> iterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_812367775 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_812367775 = new SimpleListIterator();
        varB4EAC82CA7396A68D541C85D26508E83_812367775.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_812367775;
        // ---------- Original Method ----------
        //return new SimpleListIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.167 -0400", hash_original_method = "D9C6E95DB4589560C406CE5442E4EDF7", hash_generated_method = "69162AEBFBD307DC32A98ED503457F3C")
    public int lastIndexOf(Object object) {
        ListIterator<?> it;
        it = listIterator(size());
        {
            {
                boolean varFF94A24275993577BF8E66186EAD8E8C_415286549 = (it.hasPrevious());
                {
                    {
                        boolean var2837466E71974D1300B10B19B0E72514_77610106 = (object.equals(it.previous()));
                        {
                            int varA68ED094252D1BFBB364E610EB170DB0_1490758024 = (it.nextIndex());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varFF94A24275993577BF8E66186EAD8E8C_620210451 = (it.hasPrevious());
                {
                    {
                        boolean var095079A4F80989469E99A811E1127B12_750388113 = (it.previous() == null);
                        {
                            int varA68ED094252D1BFBB364E610EB170DB0_745869027 = (it.nextIndex());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(object.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1659932254 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1659932254;
        // ---------- Original Method ----------
        //ListIterator<?> it = listIterator(size());
        //if (object != null) {
            //while (it.hasPrevious()) {
                //if (object.equals(it.previous())) {
                    //return it.nextIndex();
                //}
            //}
        //} else {
            //while (it.hasPrevious()) {
                //if (it.previous() == null) {
                    //return it.nextIndex();
                //}
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.167 -0400", hash_original_method = "DF7BE0B13ABC5A9B1C74313BD06FB64C", hash_generated_method = "EA9AEB89FC0615BBAD833E5DC1E11AC3")
    public ListIterator<E> listIterator() {
        ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_1970923806 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1970923806 = listIterator(0);
        varB4EAC82CA7396A68D541C85D26508E83_1970923806.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1970923806;
        // ---------- Original Method ----------
        //return listIterator(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.168 -0400", hash_original_method = "E1D07920E5A846C0C2E714EA3D018977", hash_generated_method = "A53EF22F66F89573DF44D2728F665D82")
    public ListIterator<E> listIterator(int location) {
        ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_630927099 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_630927099 = new FullListIterator(location);
        addTaint(location);
        varB4EAC82CA7396A68D541C85D26508E83_630927099.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_630927099;
        // ---------- Original Method ----------
        //return new FullListIterator(location);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.168 -0400", hash_original_method = "5388D372D048D053ADD084F02A9C1484", hash_generated_method = "467405881433197CE5DD774457F69E99")
    public E remove(int location) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(location);
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.168 -0400", hash_original_method = "D592F953402A10CA44AACBE4A2DEE99F", hash_generated_method = "42D07AD4A8AEC515D798005C7F65848F")
    protected void removeRange(int start, int end) {
        Iterator<?> it;
        it = listIterator(start);
        {
            int i;
            i = start;
            {
                it.next();
                it.remove();
            } //End block
        } //End collapsed parenthetic
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
        //Iterator<?> it = listIterator(start);
        //for (int i = start; i < end; i++) {
            //it.next();
            //it.remove();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.169 -0400", hash_original_method = "8830E2F07CC294339D5D496574BCFA5E", hash_generated_method = "282B9E14ACD7627F1D52891BD8544587")
    public E set(int location, E object) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(location);
        addTaint(object.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.169 -0400", hash_original_method = "016990D4D05A63F7A0209311563DE785", hash_generated_method = "9A1E71168A26E47340CC9324E10E2B4C")
    public List<E> subList(int start, int end) {
        List<E> varB4EAC82CA7396A68D541C85D26508E83_491643537 = null; //Variable for return #1
        List<E> varB4EAC82CA7396A68D541C85D26508E83_1040656113 = null; //Variable for return #2
        {
            boolean var1D108122A342E69D53881F812D085FC0_238743851 = (start >= 0 && end <= size());
            {
                {
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_491643537 = new SubAbstractListRandomAccess<E>(this, start, end);
                    } //End block
                    varB4EAC82CA7396A68D541C85D26508E83_1040656113 = new SubAbstractList<E>(this, start, end);
                } //End block
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        addTaint(start);
        addTaint(end);
        List<E> varA7E53CE21691AB073D9660D615818899_375377911; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_375377911 = varB4EAC82CA7396A68D541C85D26508E83_491643537;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_375377911 = varB4EAC82CA7396A68D541C85D26508E83_1040656113;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_375377911.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_375377911;
        // ---------- Original Method ----------
        //if (start >= 0 && end <= size()) {
            //if (start <= end) {
                //if (this instanceof RandomAccess) {
                    //return new SubAbstractListRandomAccess<E>(this, start, end);
                //}
                //return new SubAbstractList<E>(this, start, end);
            //}
            //throw new IllegalArgumentException();
        //}
        //throw new IndexOutOfBoundsException();
    }

    
    private class SimpleListIterator implements Iterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.170 -0400", hash_original_field = "01BCDD4702E06493BD386DC95FBAF612", hash_generated_field = "9DBA99389B1E561A787ED19695A15CE3")

        int pos = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.170 -0400", hash_original_field = "295CC8887E8B8B43596FF881B307867C", hash_generated_field = "92DA548A98D3BA977C330B914F0C29E7")

        int expectedModCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.178 -0400", hash_original_field = "8F224EBDBA035312E97D20DDD1BA3431", hash_generated_field = "576334B50B797BC1B6FEA5BF5FD6A2E8")

        int lastPosition = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.178 -0400", hash_original_method = "490F53403E14C3D703A2316B7D58EECE", hash_generated_method = "521DE0FD8E86B0B1E4563974AFB0BE5F")
          SimpleListIterator() {
            expectedModCount = modCount;
            // ---------- Original Method ----------
            //expectedModCount = modCount;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.178 -0400", hash_original_method = "884628BFB3767B804229DABA0C944FF7", hash_generated_method = "22330C68D89884701337C396C13C0892")
        public boolean hasNext() {
            boolean varB3E408D4CE19B3068D9F36ECFB1C648D_1615421921 = (pos + 1 < size());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1961020882 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1961020882;
            // ---------- Original Method ----------
            //return pos + 1 < size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.179 -0400", hash_original_method = "05224B49943B66CA1D46B42266E2E6E5", hash_generated_method = "6194E31523AF2A09CFDACBED6C5853FA")
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_91410308 = null; //Variable for return #1
            {
                try 
                {
                    E result;
                    result = get(pos + 1);
                    lastPosition = ++pos;
                    varB4EAC82CA7396A68D541C85D26508E83_91410308 = result;
                } //End block
                catch (IndexOutOfBoundsException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                } //End block
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            varB4EAC82CA7396A68D541C85D26508E83_91410308.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_91410308;
            // ---------- Original Method ----------
            //if (expectedModCount == modCount) {
                //try {
                    //E result = get(pos + 1);
                    //lastPosition = ++pos;
                    //return result;
                //} catch (IndexOutOfBoundsException e) {
                    //throw new NoSuchElementException();
                //}
            //}
            //throw new ConcurrentModificationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.180 -0400", hash_original_method = "57E31EFA6644BA2FF8EF861D3E66557D", hash_generated_method = "1DA33DECD9625AA027A3AC07800C30A1")
        public void remove() {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            } //End block
            try 
            {
                AbstractList.this.remove(lastPosition);
            } //End block
            catch (IndexOutOfBoundsException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            } //End block
            expectedModCount = modCount;
            lastPosition = -1;
            // ---------- Original Method ----------
            //if (this.lastPosition == -1) {
                //throw new IllegalStateException();
            //}
            //if (expectedModCount != modCount) {
                //throw new ConcurrentModificationException();
            //}
            //try {
                //AbstractList.this.remove(lastPosition);
            //} catch (IndexOutOfBoundsException e) {
                //throw new ConcurrentModificationException();
            //}
            //expectedModCount = modCount;
            //if (pos == lastPosition) {
                //pos--;
            //}
            //lastPosition = -1;
        }

        
    }


    
    private final class FullListIterator extends SimpleListIterator implements ListIterator<E> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.180 -0400", hash_original_method = "8412DB3046BBE3C95103744B97C55755", hash_generated_method = "4EC2E65FB260C43F5E94AA9C8E590275")
          FullListIterator(int start) {
            {
                boolean var485A275AD00CF84ED9ED7CECCCBD5284_482048773 = (start >= 0 && start <= size());
                {
                    pos = start - 1;
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
                } //End block
            } //End collapsed parenthetic
            addTaint(start);
            // ---------- Original Method ----------
            //if (start >= 0 && start <= size()) {
                //pos = start - 1;
            //} else {
                //throw new IndexOutOfBoundsException();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.200 -0400", hash_original_method = "603C65EE4595557F6EBDC0AA77E84F9A", hash_generated_method = "F4FE5D538CE7C63D8FA0BD21202C0123")
        public void add(E object) {
            {
                try 
                {
                    AbstractList.this.add(pos + 1, object);
                } //End block
                catch (IndexOutOfBoundsException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                } //End block
                lastPosition = -1;
                {
                    expectedModCount = modCount;
                } //End block
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            } //End block
            addTaint(object.getTaint());
            // ---------- Original Method ----------
            //if (expectedModCount == modCount) {
                //try {
                    //AbstractList.this.add(pos + 1, object);
                //} catch (IndexOutOfBoundsException e) {
                    //throw new NoSuchElementException();
                //}
                //pos++;
                //lastPosition = -1;
                //if (modCount != expectedModCount) {
                    //expectedModCount = modCount;
                //}
            //} else {
                //throw new ConcurrentModificationException();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.200 -0400", hash_original_method = "9E39925604BB7D82864E9E0B4A9B04C9", hash_generated_method = "E5BCE3F90D1B6C7190278B267EAA73F0")
        public boolean hasPrevious() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_569134377 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_569134377;
            // ---------- Original Method ----------
            //return pos >= 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.200 -0400", hash_original_method = "1B59C01DCB2067B0BBD0025D75B60071", hash_generated_method = "95631FCD439AA028A09F85796A096B59")
        public int nextIndex() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_356789855 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_356789855;
            // ---------- Original Method ----------
            //return pos + 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.201 -0400", hash_original_method = "BA720A4E815309A9A2EA4C02DBD66B54", hash_generated_method = "EFE41DB18D24E71801CCF473EDDC6D61")
        public E previous() {
            E varB4EAC82CA7396A68D541C85D26508E83_561750930 = null; //Variable for return #1
            {
                try 
                {
                    E result;
                    result = get(pos);
                    lastPosition = pos;
                    varB4EAC82CA7396A68D541C85D26508E83_561750930 = result;
                } //End block
                catch (IndexOutOfBoundsException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                } //End block
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            varB4EAC82CA7396A68D541C85D26508E83_561750930.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_561750930;
            // ---------- Original Method ----------
            //if (expectedModCount == modCount) {
                //try {
                    //E result = get(pos);
                    //lastPosition = pos;
                    //pos--;
                    //return result;
                //} catch (IndexOutOfBoundsException e) {
                    //throw new NoSuchElementException();
                //}
            //}
            //throw new ConcurrentModificationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.201 -0400", hash_original_method = "DC75AA0325D63F3F64774210ED43B204", hash_generated_method = "1D5EDF2FD3FA25F73EB42C666E5978E2")
        public int previousIndex() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1248237169 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1248237169;
            // ---------- Original Method ----------
            //return pos;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.205 -0400", hash_original_method = "5524F756B39DB0F01B5AC1D051D85348", hash_generated_method = "AF077B8B7D2C918221EB26D37CD937A9")
        public void set(E object) {
            {
                try 
                {
                    AbstractList.this.set(lastPosition, object);
                } //End block
                catch (IndexOutOfBoundsException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
                } //End block
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            } //End block
            addTaint(object.getTaint());
            // ---------- Original Method ----------
            //if (expectedModCount == modCount) {
                //try {
                    //AbstractList.this.set(lastPosition, object);
                //} catch (IndexOutOfBoundsException e) {
                    //throw new IllegalStateException();
                //}
            //} else {
                //throw new ConcurrentModificationException();
            //}
        }

        
    }


    
    private static final class SubAbstractListRandomAccess<E> extends SubAbstractList<E> implements RandomAccess {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.206 -0400", hash_original_method = "DDA87CACC9A09C50E7E63C031564E416", hash_generated_method = "398D0F737A64374305CF41E7686C780B")
          SubAbstractListRandomAccess(AbstractList<E> list, int start, int end) {
            super(list, start, end);
            addTaint(list.getTaint());
            addTaint(start);
            addTaint(end);
            // ---------- Original Method ----------
        }

        
    }


    
    private static class SubAbstractList<E> extends AbstractList<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.206 -0400", hash_original_field = "8905032EB1CDF77831923571A781EEC0", hash_generated_field = "C1379C832D8AED55354E52703E5CFF3D")

        private AbstractList<E> fullList;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.206 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "EA4C80BAC452228E60AC0DA2D3E0C953")

        private int offset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.206 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

        private int size;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.207 -0400", hash_original_method = "9C3A542F3B8DAB5106AD210DFA1C1074", hash_generated_method = "1AB05E7BE46F8223923A52968D13AFBB")
          SubAbstractList(AbstractList<E> list, int start, int end) {
            fullList = list;
            modCount = fullList.modCount;
            offset = start;
            size = end - start;
            // ---------- Original Method ----------
            //fullList = list;
            //modCount = fullList.modCount;
            //offset = start;
            //size = end - start;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.207 -0400", hash_original_method = "3BFE7688B3C07BDB6D4E8E6B32779ADD", hash_generated_method = "153A899E1BEF99382F1B85995CE4BF1C")
        @Override
        public void add(int location, E object) {
            {
                {
                    fullList.add(location + offset, object);
                    modCount = fullList.modCount;
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
                } //End block
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            } //End block
            addTaint(location);
            addTaint(object.getTaint());
            // ---------- Original Method ----------
            //if (modCount == fullList.modCount) {
                //if (location >= 0 && location <= size) {
                    //fullList.add(location + offset, object);
                    //size++;
                    //modCount = fullList.modCount;
                //} else {
                    //throw new IndexOutOfBoundsException();
                //}
            //} else {
                //throw new ConcurrentModificationException();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.223 -0400", hash_original_method = "D608BD753C390180CB19FA078294D673", hash_generated_method = "90ED243A8B8D497A3D70DF9BAB8CAABD")
        @Override
        public boolean addAll(int location, Collection<? extends E> collection) {
            {
                {
                    boolean result;
                    result = fullList.addAll(location + offset,
                            collection);
                    {
                        size += collection.size();
                        modCount = fullList.modCount;
                    } //End block
                } //End block
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            addTaint(location);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1746471745 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1746471745;
            // ---------- Original Method ----------
            //if (modCount == fullList.modCount) {
                //if (location >= 0 && location <= size) {
                    //boolean result = fullList.addAll(location + offset,
                            //collection);
                    //if (result) {
                        //size += collection.size();
                        //modCount = fullList.modCount;
                    //}
                    //return result;
                //}
                //throw new IndexOutOfBoundsException();
            //}
            //throw new ConcurrentModificationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.226 -0400", hash_original_method = "0325AEC55335C504C5D11E6C91DFCB89", hash_generated_method = "BA03F0ABD0A25C0F84574669591ED618")
        @Override
        public boolean addAll(Collection<? extends E> collection) {
            {
                boolean result;
                result = fullList.addAll(offset + size, collection);
                {
                    size += collection.size();
                    modCount = fullList.modCount;
                } //End block
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_470870271 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_470870271;
            // ---------- Original Method ----------
            //if (modCount == fullList.modCount) {
                //boolean result = fullList.addAll(offset + size, collection);
                //if (result) {
                    //size += collection.size();
                    //modCount = fullList.modCount;
                //}
                //return result;
            //}
            //throw new ConcurrentModificationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.226 -0400", hash_original_method = "32AE3B8BB78AF9AEF9BAAD036EC6C985", hash_generated_method = "7280D5A32879BD800B4D3D9E95FC84F6")
        @Override
        public E get(int location) {
            E varB4EAC82CA7396A68D541C85D26508E83_1494410597 = null; //Variable for return #1
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1494410597 = fullList.get(location + offset);
                } //End block
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            addTaint(location);
            varB4EAC82CA7396A68D541C85D26508E83_1494410597.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1494410597;
            // ---------- Original Method ----------
            //if (modCount == fullList.modCount) {
                //if (location >= 0 && location < size) {
                    //return fullList.get(location + offset);
                //}
                //throw new IndexOutOfBoundsException();
            //}
            //throw new ConcurrentModificationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.227 -0400", hash_original_method = "1D00ECD22B3575A885077212162F97B2", hash_generated_method = "912662CD40CD6FE2DD12D9AB04F2347B")
        @Override
        public Iterator<E> iterator() {
            Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_1845642261 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1845642261 = listIterator(0);
            varB4EAC82CA7396A68D541C85D26508E83_1845642261.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1845642261;
            // ---------- Original Method ----------
            //return listIterator(0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.234 -0400", hash_original_method = "37BF1A446E854722F0A00A1DF2492F76", hash_generated_method = "99F5C5063462B8259B71832C6E5BE60A")
        @Override
        public ListIterator<E> listIterator(int location) {
            ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_291877822 = null; //Variable for return #1
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_291877822 = new SubAbstractListIterator<E>(fullList
                            .listIterator(location + offset), this, offset,
                            size);
                } //End block
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            addTaint(location);
            varB4EAC82CA7396A68D541C85D26508E83_291877822.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_291877822;
            // ---------- Original Method ----------
            //if (modCount == fullList.modCount) {
                //if (location >= 0 && location <= size) {
                    //return new SubAbstractListIterator<E>(fullList
                            //.listIterator(location + offset), this, offset,
                            //size);
                //}
                //throw new IndexOutOfBoundsException();
            //}
            //throw new ConcurrentModificationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.234 -0400", hash_original_method = "FC1AD0A9D77FB0F936E412F3DF20C18C", hash_generated_method = "CD6290683B75B7DB20C178EF2E6E660A")
        @Override
        public E remove(int location) {
            E varB4EAC82CA7396A68D541C85D26508E83_1073034882 = null; //Variable for return #1
            {
                {
                    E result;
                    result = fullList.remove(location + offset);
                    modCount = fullList.modCount;
                    varB4EAC82CA7396A68D541C85D26508E83_1073034882 = result;
                } //End block
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            addTaint(location);
            varB4EAC82CA7396A68D541C85D26508E83_1073034882.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1073034882;
            // ---------- Original Method ----------
            //if (modCount == fullList.modCount) {
                //if (location >= 0 && location < size) {
                    //E result = fullList.remove(location + offset);
                    //size--;
                    //modCount = fullList.modCount;
                    //return result;
                //}
                //throw new IndexOutOfBoundsException();
            //}
            //throw new ConcurrentModificationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.237 -0400", hash_original_method = "39D9616692891C5DCB629F5E4BB97423", hash_generated_method = "E5A91DE19971290CF8931330DC24EAAA")
        @Override
        protected void removeRange(int start, int end) {
            {
                {
                    fullList.removeRange(start + offset, end + offset);
                    size -= end - start;
                    modCount = fullList.modCount;
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
                } //End block
            } //End block
            // ---------- Original Method ----------
            //if (start != end) {
                //if (modCount == fullList.modCount) {
                    //fullList.removeRange(start + offset, end + offset);
                    //size -= end - start;
                    //modCount = fullList.modCount;
                //} else {
                    //throw new ConcurrentModificationException();
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.237 -0400", hash_original_method = "368A00DA29F9470495AC7ECF8C03D998", hash_generated_method = "F6711BEAC67F0A73347EB859763E4C24")
        @Override
        public E set(int location, E object) {
            E varB4EAC82CA7396A68D541C85D26508E83_1617182746 = null; //Variable for return #1
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1617182746 = fullList.set(location + offset, object);
                } //End block
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            addTaint(location);
            addTaint(object.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1617182746.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1617182746;
            // ---------- Original Method ----------
            //if (modCount == fullList.modCount) {
                //if (location >= 0 && location < size) {
                    //return fullList.set(location + offset, object);
                //}
                //throw new IndexOutOfBoundsException();
            //}
            //throw new ConcurrentModificationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.238 -0400", hash_original_method = "875ACDDD8041C817365F748E1A382B78", hash_generated_method = "9954121090C99225087F4837B4B8AF84")
        @Override
        public int size() {
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1573235022 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1573235022;
            // ---------- Original Method ----------
            //if (modCount == fullList.modCount) {
                //return size;
            //}
            //throw new ConcurrentModificationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.238 -0400", hash_original_method = "E4C79C12269E967D1174070754018639", hash_generated_method = "E01C1D20435589457BE336D142F64CDA")
         void sizeChanged(boolean increment) {
            modCount = fullList.modCount;
            addTaint(increment);
            // ---------- Original Method ----------
            //if (increment) {
                //size++;
            //} else {
                //size--;
            //}
            //modCount = fullList.modCount;
        }

        
        private static final class SubAbstractListIterator<E> implements ListIterator<E> {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.238 -0400", hash_original_field = "A8F4783570FDF0AC561E9E4720394F13", hash_generated_field = "96B7492BED9C5CEFD9531AA61E07E6FD")

            private SubAbstractList<E> subList;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.238 -0400", hash_original_field = "420CEC00303CF5FF3EE30BF824FC1427", hash_generated_field = "962F6323627A99A953BE0EC69102D478")

            private ListIterator<E> iterator;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.238 -0400", hash_original_field = "EA2B2676C28C0DB26D39331A336C6B92", hash_generated_field = "B252D65F8AC1E6F23CF7A89AB309103A")

            private int start;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.238 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "BDD622074D0B9CD7867B17F38BB0017C")

            private int end;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.265 -0400", hash_original_method = "FC64F3A282F43584F95AE369CD21ABEB", hash_generated_method = "886B422BF688C0301EEB349912A714E7")
              SubAbstractListIterator(ListIterator<E> it,
                    SubAbstractList<E> list, int offset, int length) {
                iterator = it;
                subList = list;
                start = offset;
                end = start + length;
                // ---------- Original Method ----------
                //iterator = it;
                //subList = list;
                //start = offset;
                //end = start + length;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.265 -0400", hash_original_method = "15B57AADA02F3108FB816F7243CEFC14", hash_generated_method = "68D1B83846AF3B2B4F7E503F2280C3D9")
            public void add(E object) {
                iterator.add(object);
                subList.sizeChanged(true);
                addTaint(object.getTaint());
                // ---------- Original Method ----------
                //iterator.add(object);
                //subList.sizeChanged(true);
                //end++;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.265 -0400", hash_original_method = "81A2FD75FF59C207B385237D73BAB575", hash_generated_method = "A933805CDB990E3F9C8D2F0F459AAAC5")
            public boolean hasNext() {
                boolean var8CFDC3EFD8E6758D10B10EB2867E9235_670238259 = (iterator.nextIndex() < end);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_686678940 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_686678940;
                // ---------- Original Method ----------
                //return iterator.nextIndex() < end;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.266 -0400", hash_original_method = "4BF0442788AAA4905F570809D9662381", hash_generated_method = "9F6934C8CDBC0AA14063E2EE4AEAC1EF")
            public boolean hasPrevious() {
                boolean var41189B52699E3C624A6EED23862B2357_601855054 = (iterator.previousIndex() >= start);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_688344015 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_688344015;
                // ---------- Original Method ----------
                //return iterator.previousIndex() >= start;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.266 -0400", hash_original_method = "16E811205552F04961D1B4C1343F9BC5", hash_generated_method = "1829185DBBFBD4FC80ACE20355F44C46")
            public E next() {
                E varB4EAC82CA7396A68D541C85D26508E83_1992768709 = null; //Variable for return #1
                {
                    boolean varE9DB76DBD124662978943F51290A5254_1591300202 = (iterator.nextIndex() < end);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1992768709 = iterator.next();
                    } //End block
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                varB4EAC82CA7396A68D541C85D26508E83_1992768709.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1992768709;
                // ---------- Original Method ----------
                //if (iterator.nextIndex() < end) {
                    //return iterator.next();
                //}
                //throw new NoSuchElementException();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.267 -0400", hash_original_method = "180C2937297467CF5CF6EECA891C799A", hash_generated_method = "225B4E8A850462FDDCFE0FAEB547780D")
            public int nextIndex() {
                int varBB0936F744CBD27A452CED43C8800D18_227786275 = (iterator.nextIndex() - start);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1644569927 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1644569927;
                // ---------- Original Method ----------
                //return iterator.nextIndex() - start;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.267 -0400", hash_original_method = "B5009CEAE44112C8BE9AFDC4A47AF7BC", hash_generated_method = "6B0564CEC0C902FF62173D527A26B01F")
            public E previous() {
                E varB4EAC82CA7396A68D541C85D26508E83_612930531 = null; //Variable for return #1
                {
                    boolean varF7DB451AA953180CB9F5571075FBCF32_1099096319 = (iterator.previousIndex() >= start);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_612930531 = iterator.previous();
                    } //End block
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                varB4EAC82CA7396A68D541C85D26508E83_612930531.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_612930531;
                // ---------- Original Method ----------
                //if (iterator.previousIndex() >= start) {
                    //return iterator.previous();
                //}
                //throw new NoSuchElementException();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.267 -0400", hash_original_method = "9317CDC73983DAAAA7AC9B7E22AB8F33", hash_generated_method = "0B3BCAEE45D08DBD2971BAA934086CA7")
            public int previousIndex() {
                int previous;
                previous = iterator.previousIndex();
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_85711685 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_85711685;
                // ---------- Original Method ----------
                //int previous = iterator.previousIndex();
                //if (previous >= start) {
                    //return previous - start;
                //}
                //return -1;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.268 -0400", hash_original_method = "DFD96C46FA8CF19373B42D3B9836B5F6", hash_generated_method = "89DDCD7650800F64CAC57A5A3A444621")
            public void remove() {
                iterator.remove();
                subList.sizeChanged(false);
                // ---------- Original Method ----------
                //iterator.remove();
                //subList.sizeChanged(false);
                //end--;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.268 -0400", hash_original_method = "D9203EA9FF4899E2006B380DA4606FBD", hash_generated_method = "CC0A16144EC17CC5BFAA7666045C10E0")
            public void set(E object) {
                iterator.set(object);
                addTaint(object.getTaint());
                // ---------- Original Method ----------
                //iterator.set(object);
            }

            
        }


        
    }


    
}

