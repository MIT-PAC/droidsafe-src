package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E> {
    protected transient int modCount;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.714 -0400", hash_original_method = "AFDDADD59FA06C48A3131F90ADCD1B27", hash_generated_method = "C2512795C4B4D09B5344EF8EABF2A19D")
    @DSModeled(DSC.SAFE)
    protected AbstractList() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.714 -0400", hash_original_method = "CE54A57EF9628E9FD413F964E9F93054", hash_generated_method = "BC8E442AC7CEBA51ED32DEBCEBDC7D9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void add(int location, E object) {
        dsTaint.addTaint(location);
        dsTaint.addTaint(object.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.714 -0400", hash_original_method = "A9C598D3B94D3691F1716D511A033C5A", hash_generated_method = "7E4971D3B089DA4D53505F335B950068")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.714 -0400", hash_original_method = "35A5EA4215B8229218ACFA970E186418", hash_generated_method = "8C681BD863B9D9B75751396C66AFBFFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean addAll(int location, Collection<? extends E> collection) {
        dsTaint.addTaint(location);
        dsTaint.addTaint(collection.dsTaint);
        Iterator<? extends E> it;
        it = collection.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1065244269 = (it.hasNext());
            {
                add(location++, it.next());
            } //End block
        } //End collapsed parenthetic
        boolean varC9B9340AFA14E32A65F062ED6654285F_670317295 = (!collection.isEmpty());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Iterator<? extends E> it = collection.iterator();
        //while (it.hasNext()) {
            //add(location++, it.next());
        //}
        //return !collection.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.714 -0400", hash_original_method = "5B9E7BA75E1ADB49B9D7BF05321EEAAC", hash_generated_method = "C69094AE531324E916D6ECED92924926")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void clear() {
        removeRange(0, size());
        // ---------- Original Method ----------
        //removeRange(0, size());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.715 -0400", hash_original_method = "FBFDCAC8150A508191130E5D508BCC64", hash_generated_method = "66AEF7EE1DD6FDD508ADFBD8BBF7919D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        {
            List<?> list;
            list = (List<?>) object;
            {
                boolean varA9150772F4537FBC840B06B3C897B779_573127782 = (list.size() != size());
            } //End collapsed parenthetic
            Iterator<?> it1, it2;
            it1 = iterator();
            it2 = list.iterator();
            {
                boolean varC97010C6090A22C1711E67CA85FED63A_1763706100 = (it1.hasNext());
                {
                    Object e1, e2;
                    e1 = it1.next();
                    e2 = it2.next();
                    {
                        boolean var340C63FF299BF53687C9CFA16F96F134_109831497 = (!(e1 == null ? e2 == null : e1.equals(e2))); //DSFIXME:  CODE0008: Nested ternary operator in expression
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.715 -0400", hash_original_method = "4C126AEA105405AEB8FC6F1BC74D780D", hash_generated_method = "E1086D527DF18593A530CEB201F9E8C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int result;
        result = 1;
        Iterator<?> it;
        it = iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1032821411 = (it.hasNext());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.715 -0400", hash_original_method = "33CCCA11E9065665C3CB5AA775E1CF23", hash_generated_method = "14BD2C0D81EBE8E58B4B51E3798BDCBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int indexOf(Object object) {
        dsTaint.addTaint(object.dsTaint);
        ListIterator<?> it;
        it = listIterator();
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_2143030328 = (it.hasNext());
                {
                    {
                        boolean var4D12F9DEE5A39D7BC693B301D62540B3_397135298 = (object.equals(it.next()));
                        {
                            int var2605601C0E634FE1A7392F98BEA34857_310610507 = (it.previousIndex());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1874566764 = (it.hasNext());
                {
                    {
                        boolean varC926108249FA4A04B2CDE2B4A6BD66E6_770076079 = (it.next() == null);
                        {
                            int var2605601C0E634FE1A7392F98BEA34857_1045617562 = (it.previousIndex());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.716 -0400", hash_original_method = "20CA001488534933B2DD59F566742F0C", hash_generated_method = "4B60E4BC6B8F1F279E600C6D745A8237")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Iterator<E> iterator() {
        Iterator<E> var5F2FA2652FAABB07847278A40AB034A8_492132858 = (new SimpleListIterator());
        return (Iterator<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new SimpleListIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.717 -0400", hash_original_method = "D9C6E95DB4589560C406CE5442E4EDF7", hash_generated_method = "E071B3A4653BAF69F5DD3B63C6BDF759")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int lastIndexOf(Object object) {
        dsTaint.addTaint(object.dsTaint);
        ListIterator<?> it;
        it = listIterator(size());
        {
            {
                boolean varFF94A24275993577BF8E66186EAD8E8C_1394398148 = (it.hasPrevious());
                {
                    {
                        boolean var2837466E71974D1300B10B19B0E72514_1353289518 = (object.equals(it.previous()));
                        {
                            int varA68ED094252D1BFBB364E610EB170DB0_1717586767 = (it.nextIndex());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varFF94A24275993577BF8E66186EAD8E8C_655485099 = (it.hasPrevious());
                {
                    {
                        boolean var095079A4F80989469E99A811E1127B12_324020565 = (it.previous() == null);
                        {
                            int varA68ED094252D1BFBB364E610EB170DB0_1956327563 = (it.nextIndex());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.718 -0400", hash_original_method = "DF7BE0B13ABC5A9B1C74313BD06FB64C", hash_generated_method = "ADA1F9730CBC8974E774CBCFB940DFDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ListIterator<E> listIterator() {
        ListIterator<E> var7D4BA5CF674C03655AF029B888825291_1177189819 = (listIterator(0));
        return (ListIterator<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return listIterator(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.719 -0400", hash_original_method = "E1D07920E5A846C0C2E714EA3D018977", hash_generated_method = "EE66DC4CE2B55CF140A36295EBEA9391")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ListIterator<E> listIterator(int location) {
        dsTaint.addTaint(location);
        ListIterator<E> varED2296B9A18790A43FC7AD5675616DED_641481723 = (new FullListIterator(location));
        return (ListIterator<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new FullListIterator(location);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.721 -0400", hash_original_method = "5388D372D048D053ADD084F02A9C1484", hash_generated_method = "102A52F8C2517B1391977E3BC5A658C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E remove(int location) {
        dsTaint.addTaint(location);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.722 -0400", hash_original_method = "D592F953402A10CA44AACBE4A2DEE99F", hash_generated_method = "D1C37475785CA4360CC6EE47F992332E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.722 -0400", hash_original_method = "8830E2F07CC294339D5D496574BCFA5E", hash_generated_method = "B3A3A8B34A6ED74294E57809FC088A16")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E set(int location, E object) {
        dsTaint.addTaint(location);
        dsTaint.addTaint(object.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.723 -0400", hash_original_method = "016990D4D05A63F7A0209311563DE785", hash_generated_method = "79841DE1BF933E538EB15240A227912E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<E> subList(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        {
            boolean var1D108122A342E69D53881F812D085FC0_1134656250 = (start >= 0 && end <= size());
            {
                {
                    {
                        List<E> var5CE3B496935DF972AC3C6A43A13B5BB5_1637957407 = (new SubAbstractListRandomAccess<E>(this, start, end));
                    } //End block
                    List<E> varB091BD079CE808B8C9F752BEF7463BF8_592553631 = (new SubAbstractList<E>(this, start, end));
                } //End block
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.723 -0400", hash_original_method = "490F53403E14C3D703A2316B7D58EECE", hash_generated_method = "521DE0FD8E86B0B1E4563974AFB0BE5F")
        @DSModeled(DSC.SAFE)
         SimpleListIterator() {
            expectedModCount = modCount;
            // ---------- Original Method ----------
            //expectedModCount = modCount;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.723 -0400", hash_original_method = "884628BFB3767B804229DABA0C944FF7", hash_generated_method = "15DF510586855AA19BE883E9D34BDEAA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean hasNext() {
            boolean varB3E408D4CE19B3068D9F36ECFB1C648D_1262442078 = (pos + 1 < size());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return pos + 1 < size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.723 -0400", hash_original_method = "05224B49943B66CA1D46B42266E2E6E5", hash_generated_method = "2C69B9B9BD6FAD687D7BF3B6662EC4B4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.724 -0400", hash_original_method = "57E31EFA6644BA2FF8EF861D3E66557D", hash_generated_method = "1DA33DECD9625AA027A3AC07800C30A1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.742 -0400", hash_original_method = "8412DB3046BBE3C95103744B97C55755", hash_generated_method = "C0C429E4277B480BD5FF0D11AED5D47F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         FullListIterator(int start) {
            dsTaint.addTaint(start);
            {
                boolean var485A275AD00CF84ED9ED7CECCCBD5284_373071769 = (start >= 0 && start <= size());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.743 -0400", hash_original_method = "603C65EE4595557F6EBDC0AA77E84F9A", hash_generated_method = "8B617CC64A51179FB1E078D879FDD3A6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.743 -0400", hash_original_method = "9E39925604BB7D82864E9E0B4A9B04C9", hash_generated_method = "A2EA849950BF28E8B56CAA6B6AFEE4C5")
        @DSModeled(DSC.SAFE)
        public boolean hasPrevious() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return pos >= 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.743 -0400", hash_original_method = "1B59C01DCB2067B0BBD0025D75B60071", hash_generated_method = "EE5335FE12DA387F6B68164A1306405E")
        @DSModeled(DSC.SAFE)
        public int nextIndex() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return pos + 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.743 -0400", hash_original_method = "BA720A4E815309A9A2EA4C02DBD66B54", hash_generated_method = "3B69A380EB43D4817008741A8DAC8716")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public E previous() {
            {
                try 
                {
                    E result;
                    result = get(pos);
                    lastPosition = pos;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.744 -0400", hash_original_method = "DC75AA0325D63F3F64774210ED43B204", hash_generated_method = "8E046BDC40C4B1362A87026B83413D5E")
        @DSModeled(DSC.SAFE)
        public int previousIndex() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return pos;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.744 -0400", hash_original_method = "5524F756B39DB0F01B5AC1D051D85348", hash_generated_method = "9870AED45238789DD610E0F01C3D0715")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.744 -0400", hash_original_method = "DDA87CACC9A09C50E7E63C031564E416", hash_generated_method = "E1A4C5E6DFFF72E986F3717C5C91747A")
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
        private AbstractList<E> fullList;
        private int offset;
        private int size;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.745 -0400", hash_original_method = "9C3A542F3B8DAB5106AD210DFA1C1074", hash_generated_method = "5ABBBEE2F7913EAF4CD4CA3F6E96D205")
        @DSModeled(DSC.SAFE)
         SubAbstractList(AbstractList<E> list, int start, int end) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(list.dsTaint);
            dsTaint.addTaint(end);
            modCount = fullList.modCount;
            size = end - start;
            // ---------- Original Method ----------
            //fullList = list;
            //modCount = fullList.modCount;
            //offset = start;
            //size = end - start;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.746 -0400", hash_original_method = "3BFE7688B3C07BDB6D4E8E6B32779ADD", hash_generated_method = "CBCC3475CAE148494817CBE41983AD85")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void add(int location, E object) {
            dsTaint.addTaint(location);
            dsTaint.addTaint(object.dsTaint);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.746 -0400", hash_original_method = "D608BD753C390180CB19FA078294D673", hash_generated_method = "FE6CCE2CC226ECEB68462B09C11A4602")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.747 -0400", hash_original_method = "0325AEC55335C504C5D11E6C91DFCB89", hash_generated_method = "4D2B3EC33E35F1377C350941BDDF8344")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.748 -0400", hash_original_method = "32AE3B8BB78AF9AEF9BAAD036EC6C985", hash_generated_method = "6C6EF008ACD71894A7BA64A828105EA0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E get(int location) {
            dsTaint.addTaint(location);
            {
                {
                    E varB2754B79FE47C202479F2934FB3897E6_265157211 = (fullList.get(location + offset));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.748 -0400", hash_original_method = "1D00ECD22B3575A885077212162F97B2", hash_generated_method = "D59698C18D7C1C002178CEDDE64386B4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Iterator<E> iterator() {
            Iterator<E> var4B5B2DE28169C2BFBA180BAF54B9EB3E_151479033 = (listIterator(0));
            return (Iterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return listIterator(0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.748 -0400", hash_original_method = "37BF1A446E854722F0A00A1DF2492F76", hash_generated_method = "204E0D0758DA9F38239BE8D816D7D6B4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public ListIterator<E> listIterator(int location) {
            dsTaint.addTaint(location);
            {
                {
                    ListIterator<E> var6B4C8A2F2E3266CB45D25A1A8FE7211B_438871320 = (new SubAbstractListIterator<E>(fullList
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.749 -0400", hash_original_method = "FC1AD0A9D77FB0F936E412F3DF20C18C", hash_generated_method = "969B033970D7A386F841C238F9D414BF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E remove(int location) {
            dsTaint.addTaint(location);
            {
                {
                    E result;
                    result = fullList.remove(location + offset);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.749 -0400", hash_original_method = "39D9616692891C5DCB629F5E4BB97423", hash_generated_method = "62C9786BD41D9C798D5D89821EE11771")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.749 -0400", hash_original_method = "368A00DA29F9470495AC7ECF8C03D998", hash_generated_method = "D2C70DD66B24444EFA61FAF0E5288C5D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E set(int location, E object) {
            dsTaint.addTaint(location);
            dsTaint.addTaint(object.dsTaint);
            {
                {
                    E varD2364FD637BF502A660608ABA62D0442_351224978 = (fullList.set(location + offset, object));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.750 -0400", hash_original_method = "875ACDDD8041C817365F748E1A382B78", hash_generated_method = "6349CE437DE273DCE275B2D95BE9EFB8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.750 -0400", hash_original_method = "E4C79C12269E967D1174070754018639", hash_generated_method = "EC3460C14D10B1C65F6EC63ADA23174A")
        @DSModeled(DSC.SAFE)
         void sizeChanged(boolean increment) {
            dsTaint.addTaint(increment);
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
            private SubAbstractList<E> subList;
            private ListIterator<E> iterator;
            private int start;
            private int end;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.750 -0400", hash_original_method = "FC64F3A282F43584F95AE369CD21ABEB", hash_generated_method = "7FA0417F7059CA58B70CDE36170490D9")
            @DSModeled(DSC.SAFE)
             SubAbstractListIterator(ListIterator<E> it,
                    SubAbstractList<E> list, int offset, int length) {
                dsTaint.addTaint(it.dsTaint);
                dsTaint.addTaint(length);
                dsTaint.addTaint(list.dsTaint);
                dsTaint.addTaint(offset);
                end = start + length;
                // ---------- Original Method ----------
                //iterator = it;
                //subList = list;
                //start = offset;
                //end = start + length;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.750 -0400", hash_original_method = "15B57AADA02F3108FB816F7243CEFC14", hash_generated_method = "6FB2F96BB651EBE071024079251EBEE3")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void add(E object) {
                dsTaint.addTaint(object.dsTaint);
                iterator.add(object);
                subList.sizeChanged(true);
                // ---------- Original Method ----------
                //iterator.add(object);
                //subList.sizeChanged(true);
                //end++;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.751 -0400", hash_original_method = "81A2FD75FF59C207B385237D73BAB575", hash_generated_method = "BAC3DFB52AF97343FB68BCF1323BFC30")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public boolean hasNext() {
                boolean var8CFDC3EFD8E6758D10B10EB2867E9235_575365385 = (iterator.nextIndex() < end);
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return iterator.nextIndex() < end;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.752 -0400", hash_original_method = "4BF0442788AAA4905F570809D9662381", hash_generated_method = "A7EE7EA5F8AA2CFE200BB7EE9DAA429D")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public boolean hasPrevious() {
                boolean var41189B52699E3C624A6EED23862B2357_686105376 = (iterator.previousIndex() >= start);
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return iterator.previousIndex() >= start;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.753 -0400", hash_original_method = "16E811205552F04961D1B4C1343F9BC5", hash_generated_method = "E77298F0B7FFB596C3A0F25A67C8D89A")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public E next() {
                {
                    boolean varE9DB76DBD124662978943F51290A5254_355914967 = (iterator.nextIndex() < end);
                    {
                        E varCE8DBB5CF7BE8BC9ACE4C51E5CCEBD7E_308159385 = (iterator.next());
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.753 -0400", hash_original_method = "180C2937297467CF5CF6EECA891C799A", hash_generated_method = "107F8F787D1F5749E00D3EA2B3D72314")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public int nextIndex() {
                int varBB0936F744CBD27A452CED43C8800D18_1890778426 = (iterator.nextIndex() - start);
                return dsTaint.getTaintInt();
                // ---------- Original Method ----------
                //return iterator.nextIndex() - start;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.753 -0400", hash_original_method = "B5009CEAE44112C8BE9AFDC4A47AF7BC", hash_generated_method = "FCA83BF3DE4A0AE498FAC937C52C6D79")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public E previous() {
                {
                    boolean varF7DB451AA953180CB9F5571075FBCF32_1364325340 = (iterator.previousIndex() >= start);
                    {
                        E var1639115FB592FA9B3278E74087EAC5FD_1285137722 = (iterator.previous());
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.754 -0400", hash_original_method = "9317CDC73983DAAAA7AC9B7E22AB8F33", hash_generated_method = "D0C48F6EFD9DCCCA9852086E19EF2A35")
            //DSFIXME:  CODE0002: Requires DSC value to be set
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.754 -0400", hash_original_method = "DFD96C46FA8CF19373B42D3B9836B5F6", hash_generated_method = "89DDCD7650800F64CAC57A5A3A444621")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void remove() {
                iterator.remove();
                subList.sizeChanged(false);
                // ---------- Original Method ----------
                //iterator.remove();
                //subList.sizeChanged(false);
                //end--;
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.754 -0400", hash_original_method = "D9203EA9FF4899E2006B380DA4606FBD", hash_generated_method = "9C9C9D548CA547E79D4121D93C6F94BC")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void set(E object) {
                dsTaint.addTaint(object.dsTaint);
                iterator.set(object);
                // ---------- Original Method ----------
                //iterator.set(object);
            }

            
        }


        
    }


    
}

