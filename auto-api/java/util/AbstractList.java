package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.953 -0400", hash_original_field = "675B3022548A1029F9CE7A2C25B23BBF", hash_generated_field = "D904B48F1A1A3F19ECDEE2D75BF7C70B")

    protected transient int modCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.953 -0400", hash_original_method = "AFDDADD59FA06C48A3131F90ADCD1B27", hash_generated_method = "C2512795C4B4D09B5344EF8EABF2A19D")
    protected  AbstractList() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.953 -0400", hash_original_method = "CE54A57EF9628E9FD413F964E9F93054", hash_generated_method = "9596757B6E84B2AA8BF70433E534F821")
    public void add(int location, E object) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(location);
        addTaint(object.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.959 -0400", hash_original_method = "A9C598D3B94D3691F1716D511A033C5A", hash_generated_method = "D897D0D943C296C119FEF919F4045D18")
    @Override
    public boolean add(E object) {
        add(size(), object);
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1498804937 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1498804937;
        // ---------- Original Method ----------
        //add(size(), object);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.960 -0400", hash_original_method = "35A5EA4215B8229218ACFA970E186418", hash_generated_method = "3B94BFEB39ACFF20EB3128B3691C51BD")
    public boolean addAll(int location, Collection<? extends E> collection) {
        Iterator<? extends E> it;
        it = collection.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_2107042608 = (it.hasNext());
            {
                add(location++, it.next());
            } //End block
        } //End collapsed parenthetic
        boolean varC9B9340AFA14E32A65F062ED6654285F_574331751 = (!collection.isEmpty());
        addTaint(location);
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1840242562 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1840242562;
        // ---------- Original Method ----------
        //Iterator<? extends E> it = collection.iterator();
        //while (it.hasNext()) {
            //add(location++, it.next());
        //}
        //return !collection.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.964 -0400", hash_original_method = "5B9E7BA75E1ADB49B9D7BF05321EEAAC", hash_generated_method = "C69094AE531324E916D6ECED92924926")
    @Override
    public void clear() {
        removeRange(0, size());
        // ---------- Original Method ----------
        //removeRange(0, size());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.965 -0400", hash_original_method = "FBFDCAC8150A508191130E5D508BCC64", hash_generated_method = "0B7BC5E75995AE28E25B0600CD8E2ADE")
    @Override
    public boolean equals(Object object) {
        {
            List<?> list;
            list = (List<?>) object;
            {
                boolean varA9150772F4537FBC840B06B3C897B779_163672860 = (list.size() != size());
            } //End collapsed parenthetic
            Iterator<?> it1, it2;
            it1 = iterator();
            it2 = list.iterator();
            {
                boolean varC97010C6090A22C1711E67CA85FED63A_1145287980 = (it1.hasNext());
                {
                    Object e1, e2;
                    e1 = it1.next();
                    e2 = it2.next();
                    {
                        boolean var340C63FF299BF53687C9CFA16F96F134_291269941 = (!(e1 == null ? e2 == null : e1.equals(e2))); //DSFIXME:  CODE0008: Nested ternary operator in expression
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_612790743 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_612790743;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.984 -0400", hash_original_method = "4C126AEA105405AEB8FC6F1BC74D780D", hash_generated_method = "E5A5437965C8174E1CF3A06ED768C6D3")
    @Override
    public int hashCode() {
        int result;
        result = 1;
        Iterator<?> it;
        it = iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_780621510 = (it.hasNext());
            {
                Object object;
                object = it.next();
                result = (31 * result) + (object == null ? 0 : object.hashCode());
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1152712383 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1152712383;
        // ---------- Original Method ----------
        //int result = 1;
        //Iterator<?> it = iterator();
        //while (it.hasNext()) {
            //Object object = it.next();
            //result = (31 * result) + (object == null ? 0 : object.hashCode());
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.984 -0400", hash_original_method = "33CCCA11E9065665C3CB5AA775E1CF23", hash_generated_method = "A0E33769145E0410E3F9638F7B6FACC3")
    public int indexOf(Object object) {
        ListIterator<?> it;
        it = listIterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1572799893 = (it.hasNext());
                {
                    {
                        boolean var4D12F9DEE5A39D7BC693B301D62540B3_424299208 = (object.equals(it.next()));
                        {
                            int var2605601C0E634FE1A7392F98BEA34857_1122850873 = (it.previousIndex());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_680946121 = (it.hasNext());
                {
                    {
                        boolean varC926108249FA4A04B2CDE2B4A6BD66E6_1100389991 = (it.next() == null);
                        {
                            int var2605601C0E634FE1A7392F98BEA34857_1340675143 = (it.previousIndex());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(object.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1556665217 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1556665217;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.985 -0400", hash_original_method = "20CA001488534933B2DD59F566742F0C", hash_generated_method = "986A409A270BE9B93A8C974428729A4A")
    @Override
    public Iterator<E> iterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_1367703840 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1367703840 = new SimpleListIterator();
        varB4EAC82CA7396A68D541C85D26508E83_1367703840.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1367703840;
        // ---------- Original Method ----------
        //return new SimpleListIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.986 -0400", hash_original_method = "D9C6E95DB4589560C406CE5442E4EDF7", hash_generated_method = "B49D828736FEE916E91CB188D6B54545")
    public int lastIndexOf(Object object) {
        ListIterator<?> it;
        it = listIterator(size());
        {
            {
                boolean varFF94A24275993577BF8E66186EAD8E8C_1259402161 = (it.hasPrevious());
                {
                    {
                        boolean var2837466E71974D1300B10B19B0E72514_386951299 = (object.equals(it.previous()));
                        {
                            int varA68ED094252D1BFBB364E610EB170DB0_1801348386 = (it.nextIndex());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varFF94A24275993577BF8E66186EAD8E8C_428590588 = (it.hasPrevious());
                {
                    {
                        boolean var095079A4F80989469E99A811E1127B12_1826291811 = (it.previous() == null);
                        {
                            int varA68ED094252D1BFBB364E610EB170DB0_428293714 = (it.nextIndex());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(object.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1625229854 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1625229854;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.986 -0400", hash_original_method = "DF7BE0B13ABC5A9B1C74313BD06FB64C", hash_generated_method = "CFAD10CB6E742F1047B12EA9A110A404")
    public ListIterator<E> listIterator() {
        ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_1838255577 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1838255577 = listIterator(0);
        varB4EAC82CA7396A68D541C85D26508E83_1838255577.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1838255577;
        // ---------- Original Method ----------
        //return listIterator(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.003 -0400", hash_original_method = "E1D07920E5A846C0C2E714EA3D018977", hash_generated_method = "314DB6DD611FA88C40C4560D393F0ECF")
    public ListIterator<E> listIterator(int location) {
        ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_784891337 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_784891337 = new FullListIterator(location);
        addTaint(location);
        varB4EAC82CA7396A68D541C85D26508E83_784891337.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_784891337;
        // ---------- Original Method ----------
        //return new FullListIterator(location);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.003 -0400", hash_original_method = "5388D372D048D053ADD084F02A9C1484", hash_generated_method = "467405881433197CE5DD774457F69E99")
    public E remove(int location) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(location);
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.004 -0400", hash_original_method = "D592F953402A10CA44AACBE4A2DEE99F", hash_generated_method = "42D07AD4A8AEC515D798005C7F65848F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.004 -0400", hash_original_method = "8830E2F07CC294339D5D496574BCFA5E", hash_generated_method = "282B9E14ACD7627F1D52891BD8544587")
    public E set(int location, E object) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(location);
        addTaint(object.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.005 -0400", hash_original_method = "016990D4D05A63F7A0209311563DE785", hash_generated_method = "16AA9B68E5C5233E8C65C3E2DC373BB1")
    public List<E> subList(int start, int end) {
        List<E> varB4EAC82CA7396A68D541C85D26508E83_1606658797 = null; //Variable for return #1
        List<E> varB4EAC82CA7396A68D541C85D26508E83_507371241 = null; //Variable for return #2
        {
            boolean var1D108122A342E69D53881F812D085FC0_1033321744 = (start >= 0 && end <= size());
            {
                {
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1606658797 = new SubAbstractListRandomAccess<E>(this, start, end);
                    } //End block
                    varB4EAC82CA7396A68D541C85D26508E83_507371241 = new SubAbstractList<E>(this, start, end);
                } //End block
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        addTaint(start);
        addTaint(end);
        List<E> varA7E53CE21691AB073D9660D615818899_2146107244; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2146107244 = varB4EAC82CA7396A68D541C85D26508E83_1606658797;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2146107244 = varB4EAC82CA7396A68D541C85D26508E83_507371241;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2146107244.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2146107244;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.009 -0400", hash_original_field = "01BCDD4702E06493BD386DC95FBAF612", hash_generated_field = "9DBA99389B1E561A787ED19695A15CE3")

        int pos = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.009 -0400", hash_original_field = "295CC8887E8B8B43596FF881B307867C", hash_generated_field = "92DA548A98D3BA977C330B914F0C29E7")

        int expectedModCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.009 -0400", hash_original_field = "8F224EBDBA035312E97D20DDD1BA3431", hash_generated_field = "576334B50B797BC1B6FEA5BF5FD6A2E8")

        int lastPosition = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.010 -0400", hash_original_method = "490F53403E14C3D703A2316B7D58EECE", hash_generated_method = "521DE0FD8E86B0B1E4563974AFB0BE5F")
          SimpleListIterator() {
            expectedModCount = modCount;
            // ---------- Original Method ----------
            //expectedModCount = modCount;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.010 -0400", hash_original_method = "884628BFB3767B804229DABA0C944FF7", hash_generated_method = "213DCD8117A51C0776E3F07164E02903")
        public boolean hasNext() {
            boolean varB3E408D4CE19B3068D9F36ECFB1C648D_1022359726 = (pos + 1 < size());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_986817843 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_986817843;
            // ---------- Original Method ----------
            //return pos + 1 < size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.013 -0400", hash_original_method = "05224B49943B66CA1D46B42266E2E6E5", hash_generated_method = "98412D6B83A7FFED51B80F17B007D21D")
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_315004357 = null; //Variable for return #1
            {
                try 
                {
                    E result;
                    result = get(pos + 1);
                    lastPosition = ++pos;
                    varB4EAC82CA7396A68D541C85D26508E83_315004357 = result;
                } //End block
                catch (IndexOutOfBoundsException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                } //End block
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            varB4EAC82CA7396A68D541C85D26508E83_315004357.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_315004357;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.014 -0400", hash_original_method = "57E31EFA6644BA2FF8EF861D3E66557D", hash_generated_method = "1DA33DECD9625AA027A3AC07800C30A1")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.015 -0400", hash_original_method = "8412DB3046BBE3C95103744B97C55755", hash_generated_method = "5831B8EA7B388AACE4598208AA37332E")
          FullListIterator(int start) {
            {
                boolean var485A275AD00CF84ED9ED7CECCCBD5284_248840906 = (start >= 0 && start <= size());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.015 -0400", hash_original_method = "603C65EE4595557F6EBDC0AA77E84F9A", hash_generated_method = "F4FE5D538CE7C63D8FA0BD21202C0123")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.015 -0400", hash_original_method = "9E39925604BB7D82864E9E0B4A9B04C9", hash_generated_method = "2CE5CCB2B3D2518C8733BBF0465AF85B")
        public boolean hasPrevious() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1036700093 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1036700093;
            // ---------- Original Method ----------
            //return pos >= 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.030 -0400", hash_original_method = "1B59C01DCB2067B0BBD0025D75B60071", hash_generated_method = "E811DD8CC9586AA15F84FECAB006DD5C")
        public int nextIndex() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1390428577 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1390428577;
            // ---------- Original Method ----------
            //return pos + 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.031 -0400", hash_original_method = "BA720A4E815309A9A2EA4C02DBD66B54", hash_generated_method = "AF9F58083ADAC73BF18D64A99D0E7C4C")
        public E previous() {
            E varB4EAC82CA7396A68D541C85D26508E83_1347247087 = null; //Variable for return #1
            {
                try 
                {
                    E result;
                    result = get(pos);
                    lastPosition = pos;
                    varB4EAC82CA7396A68D541C85D26508E83_1347247087 = result;
                } //End block
                catch (IndexOutOfBoundsException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                } //End block
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            varB4EAC82CA7396A68D541C85D26508E83_1347247087.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1347247087;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.031 -0400", hash_original_method = "DC75AA0325D63F3F64774210ED43B204", hash_generated_method = "426470415E9652897B269E2B25CD8E15")
        public int previousIndex() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_538582826 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_538582826;
            // ---------- Original Method ----------
            //return pos;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.031 -0400", hash_original_method = "5524F756B39DB0F01B5AC1D051D85348", hash_generated_method = "AF077B8B7D2C918221EB26D37CD937A9")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.032 -0400", hash_original_method = "DDA87CACC9A09C50E7E63C031564E416", hash_generated_method = "398D0F737A64374305CF41E7686C780B")
          SubAbstractListRandomAccess(AbstractList<E> list, int start, int end) {
            super(list, start, end);
            addTaint(list.getTaint());
            addTaint(start);
            addTaint(end);
            // ---------- Original Method ----------
        }

        
    }


    
    private static class SubAbstractList<E> extends AbstractList<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.032 -0400", hash_original_field = "8905032EB1CDF77831923571A781EEC0", hash_generated_field = "C1379C832D8AED55354E52703E5CFF3D")

        private AbstractList<E> fullList;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.032 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "EA4C80BAC452228E60AC0DA2D3E0C953")

        private int offset;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.032 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

        private int size;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.033 -0400", hash_original_method = "9C3A542F3B8DAB5106AD210DFA1C1074", hash_generated_method = "1AB05E7BE46F8223923A52968D13AFBB")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.042 -0400", hash_original_method = "3BFE7688B3C07BDB6D4E8E6B32779ADD", hash_generated_method = "153A899E1BEF99382F1B85995CE4BF1C")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.042 -0400", hash_original_method = "D608BD753C390180CB19FA078294D673", hash_generated_method = "5E835ADC805162089A2C7D3058F47A27")
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
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_830710997 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_830710997;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.043 -0400", hash_original_method = "0325AEC55335C504C5D11E6C91DFCB89", hash_generated_method = "190170AEB41F5FB93931E1DD179DFACE")
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
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_551777513 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_551777513;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.044 -0400", hash_original_method = "32AE3B8BB78AF9AEF9BAAD036EC6C985", hash_generated_method = "3125D5E4EE1C9523566B73F96E8D70AE")
        @Override
        public E get(int location) {
            E varB4EAC82CA7396A68D541C85D26508E83_703010398 = null; //Variable for return #1
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_703010398 = fullList.get(location + offset);
                } //End block
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            addTaint(location);
            varB4EAC82CA7396A68D541C85D26508E83_703010398.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_703010398;
            // ---------- Original Method ----------
            //if (modCount == fullList.modCount) {
                //if (location >= 0 && location < size) {
                    //return fullList.get(location + offset);
                //}
                //throw new IndexOutOfBoundsException();
            //}
            //throw new ConcurrentModificationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.057 -0400", hash_original_method = "1D00ECD22B3575A885077212162F97B2", hash_generated_method = "52AB49783146EAC9B6584585BFDE25A6")
        @Override
        public Iterator<E> iterator() {
            Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_708083550 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_708083550 = listIterator(0);
            varB4EAC82CA7396A68D541C85D26508E83_708083550.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_708083550;
            // ---------- Original Method ----------
            //return listIterator(0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.057 -0400", hash_original_method = "37BF1A446E854722F0A00A1DF2492F76", hash_generated_method = "CEFF885C2C0297C0DAC1BE3429FA7757")
        @Override
        public ListIterator<E> listIterator(int location) {
            ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_373726288 = null; //Variable for return #1
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_373726288 = new SubAbstractListIterator<E>(fullList
                            .listIterator(location + offset), this, offset,
                            size);
                } //End block
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            addTaint(location);
            varB4EAC82CA7396A68D541C85D26508E83_373726288.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_373726288;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.058 -0400", hash_original_method = "FC1AD0A9D77FB0F936E412F3DF20C18C", hash_generated_method = "7A8C938429FEFE345D735ED53017631E")
        @Override
        public E remove(int location) {
            E varB4EAC82CA7396A68D541C85D26508E83_30907394 = null; //Variable for return #1
            {
                {
                    E result;
                    result = fullList.remove(location + offset);
                    modCount = fullList.modCount;
                    varB4EAC82CA7396A68D541C85D26508E83_30907394 = result;
                } //End block
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            addTaint(location);
            varB4EAC82CA7396A68D541C85D26508E83_30907394.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_30907394;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.059 -0400", hash_original_method = "39D9616692891C5DCB629F5E4BB97423", hash_generated_method = "E5A91DE19971290CF8931330DC24EAAA")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.078 -0400", hash_original_method = "368A00DA29F9470495AC7ECF8C03D998", hash_generated_method = "9BE8CD3EA00BCB893221B9FD3F6A315A")
        @Override
        public E set(int location, E object) {
            E varB4EAC82CA7396A68D541C85D26508E83_1581977020 = null; //Variable for return #1
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1581977020 = fullList.set(location + offset, object);
                } //End block
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            addTaint(location);
            addTaint(object.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1581977020.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1581977020;
            // ---------- Original Method ----------
            //if (modCount == fullList.modCount) {
                //if (location >= 0 && location < size) {
                    //return fullList.set(location + offset, object);
                //}
                //throw new IndexOutOfBoundsException();
            //}
            //throw new ConcurrentModificationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.078 -0400", hash_original_method = "875ACDDD8041C817365F748E1A382B78", hash_generated_method = "FDFA7B4A0D85D885C710E2481673DC62")
        @Override
        public int size() {
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1208773877 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1208773877;
            // ---------- Original Method ----------
            //if (modCount == fullList.modCount) {
                //return size;
            //}
            //throw new ConcurrentModificationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.078 -0400", hash_original_method = "E4C79C12269E967D1174070754018639", hash_generated_method = "E01C1D20435589457BE336D142F64CDA")
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
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.079 -0400", hash_original_field = "A8F4783570FDF0AC561E9E4720394F13", hash_generated_field = "96B7492BED9C5CEFD9531AA61E07E6FD")

            private SubAbstractList<E> subList;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.079 -0400", hash_original_field = "420CEC00303CF5FF3EE30BF824FC1427", hash_generated_field = "962F6323627A99A953BE0EC69102D478")

            private ListIterator<E> iterator;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.079 -0400", hash_original_field = "EA2B2676C28C0DB26D39331A336C6B92", hash_generated_field = "B252D65F8AC1E6F23CF7A89AB309103A")

            private int start;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.079 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "BDD622074D0B9CD7867B17F38BB0017C")

            private int end;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.079 -0400", hash_original_method = "FC64F3A282F43584F95AE369CD21ABEB", hash_generated_method = "886B422BF688C0301EEB349912A714E7")
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.079 -0400", hash_original_method = "15B57AADA02F3108FB816F7243CEFC14", hash_generated_method = "68D1B83846AF3B2B4F7E503F2280C3D9")
            public void add(E object) {
                iterator.add(object);
                subList.sizeChanged(true);
                addTaint(object.getTaint());
                // ---------- Original Method ----------
                //iterator.add(object);
                //subList.sizeChanged(true);
                //end++;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.082 -0400", hash_original_method = "81A2FD75FF59C207B385237D73BAB575", hash_generated_method = "E2BA520A13B9E7EA962A54A508FD237F")
            public boolean hasNext() {
                boolean var8CFDC3EFD8E6758D10B10EB2867E9235_1928616748 = (iterator.nextIndex() < end);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_677830133 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_677830133;
                // ---------- Original Method ----------
                //return iterator.nextIndex() < end;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.082 -0400", hash_original_method = "4BF0442788AAA4905F570809D9662381", hash_generated_method = "C8F4C0166BB4B6D5E38F78937F28D5E3")
            public boolean hasPrevious() {
                boolean var41189B52699E3C624A6EED23862B2357_928237708 = (iterator.previousIndex() >= start);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_178319555 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_178319555;
                // ---------- Original Method ----------
                //return iterator.previousIndex() >= start;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.084 -0400", hash_original_method = "16E811205552F04961D1B4C1343F9BC5", hash_generated_method = "EA98DD11B792EA810B3C76D2CBE22657")
            public E next() {
                E varB4EAC82CA7396A68D541C85D26508E83_1419657685 = null; //Variable for return #1
                {
                    boolean varE9DB76DBD124662978943F51290A5254_1799850801 = (iterator.nextIndex() < end);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1419657685 = iterator.next();
                    } //End block
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                varB4EAC82CA7396A68D541C85D26508E83_1419657685.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1419657685;
                // ---------- Original Method ----------
                //if (iterator.nextIndex() < end) {
                    //return iterator.next();
                //}
                //throw new NoSuchElementException();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.087 -0400", hash_original_method = "180C2937297467CF5CF6EECA891C799A", hash_generated_method = "300132D05E32E01AE228BFBFD5338959")
            public int nextIndex() {
                int varBB0936F744CBD27A452CED43C8800D18_1250324628 = (iterator.nextIndex() - start);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1194581205 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1194581205;
                // ---------- Original Method ----------
                //return iterator.nextIndex() - start;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.087 -0400", hash_original_method = "B5009CEAE44112C8BE9AFDC4A47AF7BC", hash_generated_method = "66411E3E23754E8B32AE8B9A649C3635")
            public E previous() {
                E varB4EAC82CA7396A68D541C85D26508E83_1867934837 = null; //Variable for return #1
                {
                    boolean varF7DB451AA953180CB9F5571075FBCF32_127250725 = (iterator.previousIndex() >= start);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1867934837 = iterator.previous();
                    } //End block
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                varB4EAC82CA7396A68D541C85D26508E83_1867934837.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1867934837;
                // ---------- Original Method ----------
                //if (iterator.previousIndex() >= start) {
                    //return iterator.previous();
                //}
                //throw new NoSuchElementException();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.101 -0400", hash_original_method = "9317CDC73983DAAAA7AC9B7E22AB8F33", hash_generated_method = "E30569B9FF7DD5ABFEBE9C3D921C3804")
            public int previousIndex() {
                int previous;
                previous = iterator.previousIndex();
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_824956395 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_824956395;
                // ---------- Original Method ----------
                //int previous = iterator.previousIndex();
                //if (previous >= start) {
                    //return previous - start;
                //}
                //return -1;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.106 -0400", hash_original_method = "DFD96C46FA8CF19373B42D3B9836B5F6", hash_generated_method = "89DDCD7650800F64CAC57A5A3A444621")
            public void remove() {
                iterator.remove();
                subList.sizeChanged(false);
                // ---------- Original Method ----------
                //iterator.remove();
                //subList.sizeChanged(false);
                //end--;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.106 -0400", hash_original_method = "D9203EA9FF4899E2006B380DA4606FBD", hash_generated_method = "CC0A16144EC17CC5BFAA7666045C10E0")
            public void set(E object) {
                iterator.set(object);
                addTaint(object.getTaint());
                // ---------- Original Method ----------
                //iterator.set(object);
            }

            
        }


        
    }


    
}

