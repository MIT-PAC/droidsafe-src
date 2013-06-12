package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E> {
    protected transient int modCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.045 -0400", hash_original_method = "AFDDADD59FA06C48A3131F90ADCD1B27", hash_generated_method = "F1FF05E0638CA5D33CA2A77B2A5C1EDD")
    @DSModeled(DSC.SAFE)
    protected AbstractList() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.049 -0400", hash_original_method = "CE54A57EF9628E9FD413F964E9F93054", hash_generated_method = "1C6F831C99F78C1A01A49682187A7EF3")
    @DSModeled(DSC.SAFE)
    public void add(int location, E object) {
        dsTaint.addTaint(location);
        dsTaint.addTaint(object.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.051 -0400", hash_original_method = "A9C598D3B94D3691F1716D511A033C5A", hash_generated_method = "973EDC7DDA80878F8E48330EEE393E59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean add(E object) {
        dsTaint.addTaint(object.dsTaint);
        add(size(), object);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //add(size(), object);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.062 -0400", hash_original_method = "35A5EA4215B8229218ACFA970E186418", hash_generated_method = "84727CAAB9484D6CEFE4AE40F1920B22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean addAll(int location, Collection<? extends E> collection) {
        dsTaint.addTaint(location);
        dsTaint.addTaint(collection.dsTaint);
        Iterator<? extends E> it;
        it = collection.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1834659250 = (it.hasNext());
            {
                add(location++, it.next());
            } //End block
        } //End collapsed parenthetic
        boolean varC9B9340AFA14E32A65F062ED6654285F_1486069760 = (!collection.isEmpty());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Iterator<? extends E> it = collection.iterator();
        //while (it.hasNext()) {
            //add(location++, it.next());
        //}
        //return !collection.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.068 -0400", hash_original_method = "5B9E7BA75E1ADB49B9D7BF05321EEAAC", hash_generated_method = "456410B25E59795B504527924E89D32A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void clear() {
        removeRange(0, size());
        // ---------- Original Method ----------
        //removeRange(0, size());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.084 -0400", hash_original_method = "FBFDCAC8150A508191130E5D508BCC64", hash_generated_method = "14A0CAD29E3CB5A9CE0946E97742548E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        {
            List<?> list;
            list = (List<?>) object;
            {
                boolean varA9150772F4537FBC840B06B3C897B779_1346883684 = (list.size() != size());
            } //End collapsed parenthetic
            Iterator<?> it1, it2;
            it1 = iterator();
            it2 = list.iterator();
            {
                boolean varC97010C6090A22C1711E67CA85FED63A_1719122744 = (it1.hasNext());
                {
                    Object e1, e2;
                    e1 = it1.next();
                    e2 = it2.next();
                    {
                        boolean var340C63FF299BF53687C9CFA16F96F134_129587204 = (!(e1 == null ? e2 == null : e1.equals(e2))); //DSFIXME:  CODE0008: Nested ternary operator in expression
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.097 -0400", hash_original_method = "4C126AEA105405AEB8FC6F1BC74D780D", hash_generated_method = "AD528AE142FB32D26CE09DD58E02D4F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int result;
        result = 1;
        Iterator<?> it;
        it = iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_842617521 = (it.hasNext());
            {
                Object object;
                object = it.next();
                result = (31 * result) + (object == null ? 0 : object.hashCode());
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int result = 1;
        //Iterator<?> it = iterator();
        //while (it.hasNext()) {
            //Object object = it.next();
            //result = (31 * result) + (object == null ? 0 : object.hashCode());
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.111 -0400", hash_original_method = "33CCCA11E9065665C3CB5AA775E1CF23", hash_generated_method = "FC574DC0103574676756CD029C32D244")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int indexOf(Object object) {
        dsTaint.addTaint(object.dsTaint);
        ListIterator<?> it;
        it = listIterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1649458603 = (it.hasNext());
                {
                    {
                        boolean var4D12F9DEE5A39D7BC693B301D62540B3_1088131625 = (object.equals(it.next()));
                        {
                            int var2605601C0E634FE1A7392F98BEA34857_2113910938 = (it.previousIndex());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1086710745 = (it.hasNext());
                {
                    {
                        boolean varC926108249FA4A04B2CDE2B4A6BD66E6_1874252817 = (it.next() == null);
                        {
                            int var2605601C0E634FE1A7392F98BEA34857_526603603 = (it.previousIndex());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.116 -0400", hash_original_method = "20CA001488534933B2DD59F566742F0C", hash_generated_method = "4A20C842524C1978231E0B3CD6B7A832")
    @DSModeled(DSC.SAFE)
    @Override
    public Iterator<E> iterator() {
        return (Iterator<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new SimpleListIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.130 -0400", hash_original_method = "D9C6E95DB4589560C406CE5442E4EDF7", hash_generated_method = "A39136518350F6190FB6E435F8DD0131")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int lastIndexOf(Object object) {
        dsTaint.addTaint(object.dsTaint);
        ListIterator<?> it;
        it = listIterator(size());
        {
            {
                boolean varFF94A24275993577BF8E66186EAD8E8C_679763824 = (it.hasPrevious());
                {
                    {
                        boolean var2837466E71974D1300B10B19B0E72514_1968161361 = (object.equals(it.previous()));
                        {
                            int varA68ED094252D1BFBB364E610EB170DB0_128113033 = (it.nextIndex());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varFF94A24275993577BF8E66186EAD8E8C_328305261 = (it.hasPrevious());
                {
                    {
                        boolean var095079A4F80989469E99A811E1127B12_1451422120 = (it.previous() == null);
                        {
                            int varA68ED094252D1BFBB364E610EB170DB0_1379851817 = (it.nextIndex());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.137 -0400", hash_original_method = "DF7BE0B13ABC5A9B1C74313BD06FB64C", hash_generated_method = "931B2BDAEA86C1F968BBC5B56ED488A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ListIterator<E> listIterator() {
        ListIterator<E> var7D4BA5CF674C03655AF029B888825291_533857100 = (listIterator(0));
        return (ListIterator<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return listIterator(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.140 -0400", hash_original_method = "E1D07920E5A846C0C2E714EA3D018977", hash_generated_method = "D0B2A5115FC8F0527F15FD80B77CCC24")
    @DSModeled(DSC.SAFE)
    public ListIterator<E> listIterator(int location) {
        dsTaint.addTaint(location);
        return (ListIterator<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new FullListIterator(location);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.152 -0400", hash_original_method = "5388D372D048D053ADD084F02A9C1484", hash_generated_method = "04FDC4D423D33E0ED9242ADB001725E8")
    @DSModeled(DSC.SAFE)
    public E remove(int location) {
        dsTaint.addTaint(location);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.157 -0400", hash_original_method = "D592F953402A10CA44AACBE4A2DEE99F", hash_generated_method = "07A08691CCE4D30BB312DB5598ADE6DC")
    @DSModeled(DSC.SAFE)
    protected void removeRange(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
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
        // ---------- Original Method ----------
        //Iterator<?> it = listIterator(start);
        //for (int i = start; i < end; i++) {
            //it.next();
            //it.remove();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.162 -0400", hash_original_method = "8830E2F07CC294339D5D496574BCFA5E", hash_generated_method = "90B4A4BFF1FB6231C1AC5CB57DBCE435")
    @DSModeled(DSC.SAFE)
    public E set(int location, E object) {
        dsTaint.addTaint(location);
        dsTaint.addTaint(object.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.169 -0400", hash_original_method = "016990D4D05A63F7A0209311563DE785", hash_generated_method = "40AF5DA8595CE44DB213877EC2EB3788")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<E> subList(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        {
            boolean var1D108122A342E69D53881F812D085FC0_1198701261 = (start >= 0 && end <= size());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        return (List<E>)dsTaint.getTaint();
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
        int pos = -1;
        int expectedModCount;
        int lastPosition = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.177 -0400", hash_original_method = "490F53403E14C3D703A2316B7D58EECE", hash_generated_method = "0D2F6CDF62955CAC9FE6D5DA909BD147")
        @DSModeled(DSC.SAFE)
         SimpleListIterator() {
            expectedModCount = modCount;
            // ---------- Original Method ----------
            //expectedModCount = modCount;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.185 -0400", hash_original_method = "884628BFB3767B804229DABA0C944FF7", hash_generated_method = "D6D5E12859D8E96446C7BE9BD5FFEBF9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean hasNext() {
            boolean varB3E408D4CE19B3068D9F36ECFB1C648D_1547893186 = (pos + 1 < size());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return pos + 1 < size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.191 -0400", hash_original_method = "05224B49943B66CA1D46B42266E2E6E5", hash_generated_method = "E91816EBE414CA121DC72FFBCB28F9CC")
        @DSModeled(DSC.SAFE)
        public E next() {
            {
                try 
                {
                    E result;
                    result = get(pos + 1);
                    lastPosition = ++pos;
                } //End block
                catch (IndexOutOfBoundsException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                } //End block
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            return (E)dsTaint.getTaint();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.200 -0400", hash_original_method = "57E31EFA6644BA2FF8EF861D3E66557D", hash_generated_method = "5EE7647B5E7597B58916CCADFAC75651")
        @DSModeled(DSC.SAFE)
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
            {
                pos--;
            } //End block
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.215 -0400", hash_original_method = "8412DB3046BBE3C95103744B97C55755", hash_generated_method = "FDEE9B30235D125A2AEED0A9AAFBA451")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         FullListIterator(int start) {
            dsTaint.addTaint(start);
            {
                boolean var485A275AD00CF84ED9ED7CECCCBD5284_1032064993 = (start >= 0 && start <= size());
                {
                    pos = start - 1;
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (start >= 0 && start <= size()) {
                //pos = start - 1;
            //} else {
                //throw new IndexOutOfBoundsException();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.221 -0400", hash_original_method = "603C65EE4595557F6EBDC0AA77E84F9A", hash_generated_method = "E3E7EE4AE2ACC7484399F345A3BAA984")
        @DSModeled(DSC.SAFE)
        public void add(E object) {
            dsTaint.addTaint(object.dsTaint);
            {
                try 
                {
                    AbstractList.this.add(pos + 1, object);
                } //End block
                catch (IndexOutOfBoundsException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                } //End block
                pos++;
                lastPosition = -1;
                {
                    expectedModCount = modCount;
                } //End block
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.232 -0400", hash_original_method = "9E39925604BB7D82864E9E0B4A9B04C9", hash_generated_method = "88AF3BA95D74D534BF80BD9D13FEE957")
        @DSModeled(DSC.SAFE)
        public boolean hasPrevious() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return pos >= 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.234 -0400", hash_original_method = "1B59C01DCB2067B0BBD0025D75B60071", hash_generated_method = "E9733AFB31A417A7ACC5E6A00248FD58")
        @DSModeled(DSC.SAFE)
        public int nextIndex() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return pos + 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.241 -0400", hash_original_method = "BA720A4E815309A9A2EA4C02DBD66B54", hash_generated_method = "A80234C771D3D02D829BE67DC113BBC9")
        @DSModeled(DSC.SAFE)
        public E previous() {
            {
                try 
                {
                    E result;
                    result = get(pos);
                    lastPosition = pos;
                    pos--;
                } //End block
                catch (IndexOutOfBoundsException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                } //End block
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            return (E)dsTaint.getTaint();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.253 -0400", hash_original_method = "DC75AA0325D63F3F64774210ED43B204", hash_generated_method = "0ECB53186A73CE587E8390AAEA0E67B4")
        @DSModeled(DSC.SAFE)
        public int previousIndex() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return pos;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.255 -0400", hash_original_method = "5524F756B39DB0F01B5AC1D051D85348", hash_generated_method = "42EB347B3A9582E277F5D9779D374162")
        @DSModeled(DSC.SAFE)
        public void set(E object) {
            dsTaint.addTaint(object.dsTaint);
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.260 -0400", hash_original_method = "DDA87CACC9A09C50E7E63C031564E416", hash_generated_method = "A82F5666B48D3AE52CDD98954F8B2812")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SubAbstractListRandomAccess(AbstractList<E> list, int start, int end) {
            super(list, start, end);
            dsTaint.addTaint(start);
            dsTaint.addTaint(list.dsTaint);
            dsTaint.addTaint(end);
            // ---------- Original Method ----------
        }

        
    }


    
    private static class SubAbstractList<E> extends AbstractList<E> {
        private final AbstractList<E> fullList;
        private int offset;
        private int size;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.265 -0400", hash_original_method = "9C3A542F3B8DAB5106AD210DFA1C1074", hash_generated_method = "03471B7C78CBAD51B09B5DC89C473472")
        @DSModeled(DSC.SAFE)
         SubAbstractList(AbstractList<E> list, int start, int end) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(list.dsTaint);
            dsTaint.addTaint(end);
            size = end - start;
            // ---------- Original Method ----------
            fullList = list;
            modCount = fullList.modCount;
            offset = start;
            size = end - start;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.281 -0400", hash_original_method = "3BFE7688B3C07BDB6D4E8E6B32779ADD", hash_generated_method = "86A52999EAD765814D624BB00F1A9D03")
        @DSModeled(DSC.SAFE)
        @Override
        public void add(int location, E object) {
            dsTaint.addTaint(location);
            dsTaint.addTaint(object.dsTaint);
            {
                {
                    fullList.add(location + offset, object);
                    size++;
                    modCount = fullList.modCount;
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
                } //End block
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.289 -0400", hash_original_method = "D608BD753C390180CB19FA078294D673", hash_generated_method = "49145796F6E0BE461767C1A92A9ECD86")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean addAll(int location, Collection<? extends E> collection) {
            dsTaint.addTaint(location);
            dsTaint.addTaint(collection.dsTaint);
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
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.297 -0400", hash_original_method = "0325AEC55335C504C5D11E6C91DFCB89", hash_generated_method = "D4177479F3C7A8438A2BDB7CC07CB8B3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean addAll(Collection<? extends E> collection) {
            dsTaint.addTaint(collection.dsTaint);
            {
                boolean result;
                result = fullList.addAll(offset + size, collection);
                {
                    size += collection.size();
                    modCount = fullList.modCount;
                } //End block
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.306 -0400", hash_original_method = "32AE3B8BB78AF9AEF9BAAD036EC6C985", hash_generated_method = "6F4DDC1989363AD88976A45225748D5C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E get(int location) {
            dsTaint.addTaint(location);
            {
                {
                    E varB2754B79FE47C202479F2934FB3897E6_761099083 = (fullList.get(location + offset));
                } //End block
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (modCount == fullList.modCount) {
                //if (location >= 0 && location < size) {
                    //return fullList.get(location + offset);
                //}
                //throw new IndexOutOfBoundsException();
            //}
            //throw new ConcurrentModificationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.312 -0400", hash_original_method = "1D00ECD22B3575A885077212162F97B2", hash_generated_method = "8E7F51664B0DD63984E86723191E7615")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Iterator<E> iterator() {
            Iterator<E> var4B5B2DE28169C2BFBA180BAF54B9EB3E_1551240506 = (listIterator(0));
            return (Iterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return listIterator(0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.318 -0400", hash_original_method = "37BF1A446E854722F0A00A1DF2492F76", hash_generated_method = "AE3DDEAE95730FA236A20C1B33577A79")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public ListIterator<E> listIterator(int location) {
            dsTaint.addTaint(location);
            {
                {
                    ListIterator<E> var6B4C8A2F2E3266CB45D25A1A8FE7211B_2082679792 = (new SubAbstractListIterator<E>(fullList
                            .listIterator(location + offset), this, offset,
                            size));
                } //End block
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            return (ListIterator<E>)dsTaint.getTaint();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.329 -0400", hash_original_method = "FC1AD0A9D77FB0F936E412F3DF20C18C", hash_generated_method = "D8DDC7006A1601D76D8906DB44AA8E93")
        @DSModeled(DSC.SAFE)
        @Override
        public E remove(int location) {
            dsTaint.addTaint(location);
            {
                {
                    E result;
                    result = fullList.remove(location + offset);
                    size--;
                    modCount = fullList.modCount;
                } //End block
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            return (E)dsTaint.getTaint();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.338 -0400", hash_original_method = "39D9616692891C5DCB629F5E4BB97423", hash_generated_method = "54EEE2B1C7AD10C6DA73C9C2DB7BAD72")
        @DSModeled(DSC.SAFE)
        @Override
        protected void removeRange(int start, int end) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(end);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.345 -0400", hash_original_method = "368A00DA29F9470495AC7ECF8C03D998", hash_generated_method = "C1F08437813B98F5888262035F21265D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E set(int location, E object) {
            dsTaint.addTaint(location);
            dsTaint.addTaint(object.dsTaint);
            {
                {
                    E varD2364FD637BF502A660608ABA62D0442_596951843 = (fullList.set(location + offset, object));
                } //End block
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (modCount == fullList.modCount) {
                //if (location >= 0 && location < size) {
                    //return fullList.set(location + offset, object);
                //}
                //throw new IndexOutOfBoundsException();
            //}
            //throw new ConcurrentModificationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.352 -0400", hash_original_method = "875ACDDD8041C817365F748E1A382B78", hash_generated_method = "16FF8B165193A92BB24CF85546BC4602")
        @DSModeled(DSC.SAFE)
        @Override
        public int size() {
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (modCount == fullList.modCount) {
                //return size;
            //}
            //throw new ConcurrentModificationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.365 -0400", hash_original_method = "E4C79C12269E967D1174070754018639", hash_generated_method = "20914B4F0835E358EFB50DFF7C34CBFC")
        @DSModeled(DSC.SAFE)
         void sizeChanged(boolean increment) {
            dsTaint.addTaint(increment);
            {
                size++;
            } //End block
            {
                size--;
            } //End block
            modCount = fullList.modCount;
            // ---------- Original Method ----------
            //if (increment) {
                //size++;
            //} else {
                //size--;
            //}
            //modCount = fullList.modCount;
        }

        
        private static final class SubAbstractListIterator<E> implements ListIterator<E> {
            private final SubAbstractList<E> subList;
            private final ListIterator<E> iterator;
            private int start;
            private int end;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.368 -0400", hash_original_method = "FC64F3A282F43584F95AE369CD21ABEB", hash_generated_method = "07049DEEF925087C3D9F7DFA11235D87")
            @DSModeled(DSC.SAFE)
             SubAbstractListIterator(ListIterator<E> it,
                    SubAbstractList<E> list, int offset, int length) {
                dsTaint.addTaint(it.dsTaint);
                dsTaint.addTaint(length);
                dsTaint.addTaint(list.dsTaint);
                dsTaint.addTaint(offset);
                end = start + length;
                // ---------- Original Method ----------
                iterator = it;
                subList = list;
                start = offset;
                end = start + length;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.369 -0400", hash_original_method = "15B57AADA02F3108FB816F7243CEFC14", hash_generated_method = "FDA2C7C3F071A3C5F3517DC172CB49D3")
            @DSModeled(DSC.SAFE)
            public void add(E object) {
                dsTaint.addTaint(object.dsTaint);
                iterator.add(object);
                subList.sizeChanged(true);
                end++;
                // ---------- Original Method ----------
                //iterator.add(object);
                //subList.sizeChanged(true);
                //end++;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.381 -0400", hash_original_method = "81A2FD75FF59C207B385237D73BAB575", hash_generated_method = "995F3526F09FF59A5478906855919A9B")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public boolean hasNext() {
                boolean var8CFDC3EFD8E6758D10B10EB2867E9235_1757083489 = (iterator.nextIndex() < end);
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return iterator.nextIndex() < end;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.383 -0400", hash_original_method = "4BF0442788AAA4905F570809D9662381", hash_generated_method = "09D5832F174619BBBDB74452392CD97A")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public boolean hasPrevious() {
                boolean var41189B52699E3C624A6EED23862B2357_866943617 = (iterator.previousIndex() >= start);
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return iterator.previousIndex() >= start;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.389 -0400", hash_original_method = "16E811205552F04961D1B4C1343F9BC5", hash_generated_method = "D0F317EEC8C9EC5C66CFD23889E88D49")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public E next() {
                {
                    boolean varE9DB76DBD124662978943F51290A5254_1981717769 = (iterator.nextIndex() < end);
                    {
                        E varCE8DBB5CF7BE8BC9ACE4C51E5CCEBD7E_1431752694 = (iterator.next());
                    } //End block
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                return (E)dsTaint.getTaint();
                // ---------- Original Method ----------
                //if (iterator.nextIndex() < end) {
                    //return iterator.next();
                //}
                //throw new NoSuchElementException();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.397 -0400", hash_original_method = "180C2937297467CF5CF6EECA891C799A", hash_generated_method = "2581150DA0A4CB798D5789E2DD460141")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public int nextIndex() {
                int varBB0936F744CBD27A452CED43C8800D18_65872450 = (iterator.nextIndex() - start);
                return dsTaint.getTaintInt();
                // ---------- Original Method ----------
                //return iterator.nextIndex() - start;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.401 -0400", hash_original_method = "B5009CEAE44112C8BE9AFDC4A47AF7BC", hash_generated_method = "614C1DD66D61BDBD535DAF85FE8A0570")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public E previous() {
                {
                    boolean varF7DB451AA953180CB9F5571075FBCF32_1281663816 = (iterator.previousIndex() >= start);
                    {
                        E var1639115FB592FA9B3278E74087EAC5FD_1252336817 = (iterator.previous());
                    } //End block
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                return (E)dsTaint.getTaint();
                // ---------- Original Method ----------
                //if (iterator.previousIndex() >= start) {
                    //return iterator.previous();
                //}
                //throw new NoSuchElementException();
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.414 -0400", hash_original_method = "9317CDC73983DAAAA7AC9B7E22AB8F33", hash_generated_method = "86065E14044188567F3F3E8D10531B6E")
            @DSModeled(DSC.SAFE)
            public int previousIndex() {
                int previous;
                previous = iterator.previousIndex();
                return dsTaint.getTaintInt();
                // ---------- Original Method ----------
                //int previous = iterator.previousIndex();
                //if (previous >= start) {
                    //return previous - start;
                //}
                //return -1;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.415 -0400", hash_original_method = "DFD96C46FA8CF19373B42D3B9836B5F6", hash_generated_method = "33271C9A9DE791516F08FF3CAFCC1C4C")
            @DSModeled(DSC.SAFE)
            public void remove() {
                iterator.remove();
                subList.sizeChanged(false);
                end--;
                // ---------- Original Method ----------
                //iterator.remove();
                //subList.sizeChanged(false);
                //end--;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:57:26.425 -0400", hash_original_method = "D9203EA9FF4899E2006B380DA4606FBD", hash_generated_method = "A08C857DB14FAD4E80D7D5EA14FCB82E")
            @DSModeled(DSC.SAFE)
            public void set(E object) {
                dsTaint.addTaint(object.dsTaint);
                iterator.set(object);
                // ---------- Original Method ----------
                //iterator.set(object);
            }

            
        }


        
    }


    
}


