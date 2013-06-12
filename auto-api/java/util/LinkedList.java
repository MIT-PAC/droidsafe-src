package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;

public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Queue<E>, Cloneable, Serializable {
    private static final long serialVersionUID = 876323262645176354L;
    transient int size = 0;
    transient Link<E> voidLink;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.704 -0400", hash_original_method = "4832DB7F32D79BC3832C9989ACB7B916", hash_generated_method = "828AFBEC3C17745E3F2536026A1E6FAF")
    @DSModeled(DSC.SAFE)
    public LinkedList() {
        voidLink = new Link<E>(null, null, null);
        voidLink.previous = voidLink;
        voidLink.next = voidLink;
        // ---------- Original Method ----------
        //voidLink = new Link<E>(null, null, null);
        //voidLink.previous = voidLink;
        //voidLink.next = voidLink;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.704 -0400", hash_original_method = "0B559D29C113071CE6BE3D63B71465EB", hash_generated_method = "FA4F9ACA3D15663DFB25A7450B8711EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkedList(Collection<? extends E> collection) {
        this();
        dsTaint.addTaint(collection.dsTaint);
        addAll(collection);
        // ---------- Original Method ----------
        //addAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.704 -0400", hash_original_method = "9920EB632989F8B562686C0A781A0AB0", hash_generated_method = "2EBCB7B806F9AE7801FC9948B7E25955")
    @DSModeled(DSC.SAFE)
    @Override
    public void add(int location, E object) {
        dsTaint.addTaint(location);
        dsTaint.addTaint(object.dsTaint);
        {
            Link<E> link;
            link = voidLink;
            {
                {
                    int i;
                    i = 0;
                    {
                        link = link.next;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    int i;
                    i = size;
                    {
                        link = link.previous;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            Link<E> previous;
            previous = link.previous;
            Link<E> newLink;
            newLink = new Link<E>(object, previous, link);
            previous.next = newLink;
            link.previous = newLink;
            size++;
            modCount++;
        } //End block
        {
            throw new IndexOutOfBoundsException();
        } //End block
        // ---------- Original Method ----------
        //if (location >= 0 && location <= size) {
            //Link<E> link = voidLink;
            //if (location < (size / 2)) {
                //for (int i = 0; i <= location; i++) {
                    //link = link.next;
                //}
            //} else {
                //for (int i = size; i > location; i--) {
                    //link = link.previous;
                //}
            //}
            //Link<E> previous = link.previous;
            //Link<E> newLink = new Link<E>(object, previous, link);
            //previous.next = newLink;
            //link.previous = newLink;
            //size++;
            //modCount++;
        //} else {
            //throw new IndexOutOfBoundsException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.704 -0400", hash_original_method = "2BE8A2B5B965FC484F0C7216D8E6E369", hash_generated_method = "805C16FE6491CF0B7DC2E482FF24582F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean add(E object) {
        dsTaint.addTaint(object.dsTaint);
        boolean var471407E29FACACFF33C18CE3EA47D39B_611991036 = (addLastImpl(object));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return addLastImpl(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.704 -0400", hash_original_method = "0CAFD9F2E83DD82BF6364CDBDC4D7D1A", hash_generated_method = "5F845E29A74CCAA034A3B2FB78B786B7")
    @DSModeled(DSC.SAFE)
    private boolean addLastImpl(E object) {
        dsTaint.addTaint(object.dsTaint);
        Link<E> oldLast;
        oldLast = voidLink.previous;
        Link<E> newLink;
        newLink = new Link<E>(object, oldLast, voidLink);
        voidLink.previous = newLink;
        oldLast.next = newLink;
        size++;
        modCount++;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Link<E> oldLast = voidLink.previous;
        //Link<E> newLink = new Link<E>(object, oldLast, voidLink);
        //voidLink.previous = newLink;
        //oldLast.next = newLink;
        //size++;
        //modCount++;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.705 -0400", hash_original_method = "EA599DD8388630A135A57F30093AE237", hash_generated_method = "8929A62998619168AC90A9DB9902CC0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean addAll(int location, Collection<? extends E> collection) {
        dsTaint.addTaint(location);
        dsTaint.addTaint(collection.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        int adding;
        adding = collection.size();
        Collection<? extends E> elements;
        elements = new ArrayList<E>(collection);
        elements = collection;
        Link<E> previous;
        previous = voidLink;
        {
            {
                int i;
                i = 0;
                {
                    previous = previous.next;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                int i;
                i = size;
                {
                    previous = previous.previous;
                } //End block
            } //End collapsed parenthetic
        } //End block
        Link<E> next;
        next = previous.next;
        {
            Iterator<? extends E> seatecAstronomy42 = elements.iterator();
            seatecAstronomy42.hasNext();
            E e = seatecAstronomy42.next();
            {
                Link<E> newLink;
                newLink = new Link<E>(e, previous, null);
                previous.next = newLink;
                previous = newLink;
            } //End block
        } //End collapsed parenthetic
        previous.next = next;
        next.previous = previous;
        size += adding;
        modCount++;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.705 -0400", hash_original_method = "B5A413C7ECEF6975CDBDA09F397FBA87", hash_generated_method = "B2061EDB8ABD26CDD634C32E8F0E094D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean addAll(Collection<? extends E> collection) {
        dsTaint.addTaint(collection.dsTaint);
        int adding;
        adding = collection.size();
        Collection<? extends E> elements;
        elements = new ArrayList<E>(collection);
        elements = collection;
        Link<E> previous;
        previous = voidLink.previous;
        {
            Iterator<? extends E> seatecAstronomy42 = elements.iterator();
            seatecAstronomy42.hasNext();
            E e = seatecAstronomy42.next();
            {
                Link<E> newLink;
                newLink = new Link<E>(e, previous, null);
                previous.next = newLink;
                previous = newLink;
            } //End block
        } //End collapsed parenthetic
        previous.next = voidLink;
        voidLink.previous = previous;
        size += adding;
        modCount++;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int adding = collection.size();
        //if (adding == 0) {
            //return false;
        //}
        //Collection<? extends E> elements = (collection == this) ?
                //new ArrayList<E>(collection) : collection;
        //Link<E> previous = voidLink.previous;
        //for (E e : elements) {
            //Link<E> newLink = new Link<E>(e, previous, null);
            //previous.next = newLink;
            //previous = newLink;
        //}
        //previous.next = voidLink;
        //voidLink.previous = previous;
        //size += adding;
        //modCount++;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.705 -0400", hash_original_method = "CA8A1B06476946B0324CCA25F612E720", hash_generated_method = "2F0FFA0C8A46B4AC6E4E934EF7BBEADD")
    @DSModeled(DSC.SAFE)
    public void addFirst(E object) {
        dsTaint.addTaint(object.dsTaint);
        addFirstImpl(object);
        // ---------- Original Method ----------
        //addFirstImpl(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.705 -0400", hash_original_method = "954FD4442748B652A7955CF114F2239E", hash_generated_method = "7C8D491EC5DDACE924F8A98EB92E08E2")
    @DSModeled(DSC.SAFE)
    private boolean addFirstImpl(E object) {
        dsTaint.addTaint(object.dsTaint);
        Link<E> oldFirst;
        oldFirst = voidLink.next;
        Link<E> newLink;
        newLink = new Link<E>(object, voidLink, oldFirst);
        voidLink.next = newLink;
        oldFirst.previous = newLink;
        size++;
        modCount++;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Link<E> oldFirst = voidLink.next;
        //Link<E> newLink = new Link<E>(object, voidLink, oldFirst);
        //voidLink.next = newLink;
        //oldFirst.previous = newLink;
        //size++;
        //modCount++;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.705 -0400", hash_original_method = "13A36680ECD01352EC1F894705FA522D", hash_generated_method = "5C027B1756FA3197CD54A3C61DED0005")
    @DSModeled(DSC.SAFE)
    public void addLast(E object) {
        dsTaint.addTaint(object.dsTaint);
        addLastImpl(object);
        // ---------- Original Method ----------
        //addLastImpl(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.705 -0400", hash_original_method = "F4AB109BD4924C3D8662019AA7349AF5", hash_generated_method = "23A0CDDC1C876D4996B33174048202CF")
    @DSModeled(DSC.SAFE)
    @Override
    public void clear() {
        {
            size = 0;
            voidLink.next = voidLink;
            voidLink.previous = voidLink;
            modCount++;
        } //End block
        // ---------- Original Method ----------
        //if (size > 0) {
            //size = 0;
            //voidLink.next = voidLink;
            //voidLink.previous = voidLink;
            //modCount++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.705 -0400", hash_original_method = "1B9E5D872B5FE69DD2C5F33B9044F30B", hash_generated_method = "4750B4E6C09F83C5151F9CD7511DA233")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    @Override
    public Object clone() {
        try 
        {
            LinkedList<E> l;
            l = (LinkedList<E>) super.clone();
            l.size = 0;
            l.voidLink = new Link<E>(null, null, null);
            l.voidLink.previous = l.voidLink;
            l.voidLink.next = l.voidLink;
            l.addAll(this);
        } //End block
        catch (CloneNotSupportedException e)
        {
            throw new AssertionError(e);
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //LinkedList<E> l = (LinkedList<E>) super.clone();
            //l.size = 0;
            //l.voidLink = new Link<E>(null, null, null);
            //l.voidLink.previous = l.voidLink;
            //l.voidLink.next = l.voidLink;
            //l.addAll(this);
            //return l;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.705 -0400", hash_original_method = "56D0217BC0A5D945F9BCFA2A5AF2C1AD", hash_generated_method = "94E88D79E039445E7B17B3B9CBB3D5A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean contains(Object object) {
        dsTaint.addTaint(object.dsTaint);
        Link<E> link;
        link = voidLink.next;
        {
            {
                {
                    boolean var68AE80027D20B2F4904BFC3ADBBA50B7_1216200869 = (object.equals(link.data));
                } //End collapsed parenthetic
                link = link.next;
            } //End block
        } //End block
        {
            {
                link = link.next;
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Link<E> link = voidLink.next;
        //if (object != null) {
            //while (link != voidLink) {
                //if (object.equals(link.data)) {
                    //return true;
                //}
                //link = link.next;
            //}
        //} else {
            //while (link != voidLink) {
                //if (link.data == null) {
                    //return true;
                //}
                //link = link.next;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.705 -0400", hash_original_method = "699CDCD94CA0F8A673D2432C1A4A1CA6", hash_generated_method = "D2C1725AC3F4D0C00A36FCCA0FA43BCC")
    @DSModeled(DSC.SAFE)
    @Override
    public E get(int location) {
        dsTaint.addTaint(location);
        {
            Link<E> link;
            link = voidLink;
            {
                {
                    int i;
                    i = 0;
                    {
                        link = link.next;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    int i;
                    i = size;
                    {
                        link = link.previous;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (location >= 0 && location < size) {
            //Link<E> link = voidLink;
            //if (location < (size / 2)) {
                //for (int i = 0; i <= location; i++) {
                    //link = link.next;
                //}
            //} else {
                //for (int i = size; i > location; i--) {
                    //link = link.previous;
                //}
            //}
            //return link.data;
        //}
        //throw new IndexOutOfBoundsException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.705 -0400", hash_original_method = "0073A2AD94DC363435B793B69AD53800", hash_generated_method = "EF481E42C3E75910C83A602D54D0F782")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E getFirst() {
        E var59B306F2C55D6D5B91AE1906FC84C434_810270396 = (getFirstImpl());
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getFirstImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.706 -0400", hash_original_method = "F326A7609FEC22B872586B521BF21968", hash_generated_method = "F9F87C4EB2A35906B9AA7699492F3FD4")
    @DSModeled(DSC.SAFE)
    private E getFirstImpl() {
        Link<E> first;
        first = voidLink.next;
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Link<E> first = voidLink.next;
        //if (first != voidLink) {
            //return first.data;
        //}
        //throw new NoSuchElementException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.706 -0400", hash_original_method = "D36A1824B4AA11A93F9167DC96C3E776", hash_generated_method = "70172B7A02ACD66DBBE2A4BAEC590B12")
    @DSModeled(DSC.SAFE)
    public E getLast() {
        Link<E> last;
        last = voidLink.previous;
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Link<E> last = voidLink.previous;
        //if (last != voidLink) {
            //return last.data;
        //}
        //throw new NoSuchElementException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.706 -0400", hash_original_method = "223AFBB612F259C1ECF52502B2C38D06", hash_generated_method = "2CB6120A90EFB7439397333BB9205634")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int indexOf(Object object) {
        dsTaint.addTaint(object.dsTaint);
        int pos;
        pos = 0;
        Link<E> link;
        link = voidLink.next;
        {
            {
                {
                    boolean var68AE80027D20B2F4904BFC3ADBBA50B7_2028871597 = (object.equals(link.data));
                } //End collapsed parenthetic
                link = link.next;
                pos++;
            } //End block
        } //End block
        {
            {
                link = link.next;
                pos++;
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int pos = 0;
        //Link<E> link = voidLink.next;
        //if (object != null) {
            //while (link != voidLink) {
                //if (object.equals(link.data)) {
                    //return pos;
                //}
                //link = link.next;
                //pos++;
            //}
        //} else {
            //while (link != voidLink) {
                //if (link.data == null) {
                    //return pos;
                //}
                //link = link.next;
                //pos++;
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.706 -0400", hash_original_method = "C5BD92F697D9C0CCDCACCA1E644478EA", hash_generated_method = "3391F1F9AC02BE05AF4D18F3DA88CD4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int lastIndexOf(Object object) {
        dsTaint.addTaint(object.dsTaint);
        int pos;
        pos = size;
        Link<E> link;
        link = voidLink.previous;
        {
            {
                pos--;
                {
                    boolean var68AE80027D20B2F4904BFC3ADBBA50B7_1371458932 = (object.equals(link.data));
                } //End collapsed parenthetic
                link = link.previous;
            } //End block
        } //End block
        {
            {
                pos--;
                link = link.previous;
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int pos = size;
        //Link<E> link = voidLink.previous;
        //if (object != null) {
            //while (link != voidLink) {
                //pos--;
                //if (object.equals(link.data)) {
                    //return pos;
                //}
                //link = link.previous;
            //}
        //} else {
            //while (link != voidLink) {
                //pos--;
                //if (link.data == null) {
                    //return pos;
                //}
                //link = link.previous;
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.706 -0400", hash_original_method = "3507AEFB380BBD7C7A81BC76F9B74E53", hash_generated_method = "AA7FD508722B07E3BB5BEE4CDA91A453")
    @DSModeled(DSC.SAFE)
    @Override
    public ListIterator<E> listIterator(int location) {
        dsTaint.addTaint(location);
        return (ListIterator<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new LinkIterator<E>(this, location);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.706 -0400", hash_original_method = "9DEB2DAC83546A51EF3DAC82C2B24429", hash_generated_method = "A3216B10C1F812EC7955A7458AEC386E")
    @DSModeled(DSC.SAFE)
    @Override
    public E remove(int location) {
        dsTaint.addTaint(location);
        {
            Link<E> link;
            link = voidLink;
            {
                {
                    int i;
                    i = 0;
                    {
                        link = link.next;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    int i;
                    i = size;
                    {
                        link = link.previous;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            Link<E> previous;
            previous = link.previous;
            Link<E> next;
            next = link.next;
            previous.next = next;
            next.previous = previous;
            size--;
            modCount++;
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (location >= 0 && location < size) {
            //Link<E> link = voidLink;
            //if (location < (size / 2)) {
                //for (int i = 0; i <= location; i++) {
                    //link = link.next;
                //}
            //} else {
                //for (int i = size; i > location; i--) {
                    //link = link.previous;
                //}
            //}
            //Link<E> previous = link.previous;
            //Link<E> next = link.next;
            //previous.next = next;
            //next.previous = previous;
            //size--;
            //modCount++;
            //return link.data;
        //}
        //throw new IndexOutOfBoundsException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.706 -0400", hash_original_method = "E895D44AE5728A8CB5D4093F924DE858", hash_generated_method = "0CD3780BFEF3EE892902C1CCE1CD5C79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean remove(Object object) {
        dsTaint.addTaint(object.dsTaint);
        boolean varD9AA6A5988D1CD4CF0EC501538EC1CB9_1914100447 = (removeFirstOccurrenceImpl(object));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return removeFirstOccurrenceImpl(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.706 -0400", hash_original_method = "DEF022B3B9EBAD20A11E8D94E53A2C41", hash_generated_method = "14CC8811AE1625FFAE29B49E6D7FD260")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E removeFirst() {
        E var0ECEFB3EE143FE144D010B600286C5D2_1108869631 = (removeFirstImpl());
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return removeFirstImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.706 -0400", hash_original_method = "427E50F3C77738614041495F63E4380E", hash_generated_method = "1857BAA25A9167302CD2DE1E1366D332")
    @DSModeled(DSC.SAFE)
    private E removeFirstImpl() {
        Link<E> first;
        first = voidLink.next;
        {
            Link<E> next;
            next = first.next;
            voidLink.next = next;
            next.previous = voidLink;
            size--;
            modCount++;
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Link<E> first = voidLink.next;
        //if (first != voidLink) {
            //Link<E> next = first.next;
            //voidLink.next = next;
            //next.previous = voidLink;
            //size--;
            //modCount++;
            //return first.data;
        //}
        //throw new NoSuchElementException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.706 -0400", hash_original_method = "78A299256A25A92F54699488F92E9106", hash_generated_method = "4D6365DA42697235C066FB23AF67A156")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E removeLast() {
        E var49CF835FEE0E90D023B94877E5FC4762_1509086438 = (removeLastImpl());
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return removeLastImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.706 -0400", hash_original_method = "4FEFCE90045B22FA30A5F2F8A3DA8ABA", hash_generated_method = "9742B05592FCC6F0100B5FF9C3FDCDAE")
    @DSModeled(DSC.SAFE)
    private E removeLastImpl() {
        Link<E> last;
        last = voidLink.previous;
        {
            Link<E> previous;
            previous = last.previous;
            voidLink.previous = previous;
            previous.next = voidLink;
            size--;
            modCount++;
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Link<E> last = voidLink.previous;
        //if (last != voidLink) {
            //Link<E> previous = last.previous;
            //voidLink.previous = previous;
            //previous.next = voidLink;
            //size--;
            //modCount++;
            //return last.data;
        //}
        //throw new NoSuchElementException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.706 -0400", hash_original_method = "B739DCE0B4C0EF3D97CD82250338592B", hash_generated_method = "A22391503E709E15BBC0F12C02AFFAE2")
    @DSModeled(DSC.SAFE)
    public Iterator<E> descendingIterator() {
        return (Iterator<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ReverseLinkIterator<E>(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.707 -0400", hash_original_method = "EDFB7FC0634DB7C00BD3AB035EBD094A", hash_generated_method = "F2DC1DF50EFFC29A751BC3343F72B7A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean offerFirst(E e) {
        dsTaint.addTaint(e.dsTaint);
        boolean var76B72DE79F3E513315008517C001461F_175462133 = (addFirstImpl(e));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return addFirstImpl(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.707 -0400", hash_original_method = "89DCF7809C68E43568923DE3D2E1D02D", hash_generated_method = "239BB3644068FDE79A3E6E9D3E490D8E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean offerLast(E e) {
        dsTaint.addTaint(e.dsTaint);
        boolean var5D8D8C0594128842346FC018CF7B2C46_207102209 = (addLastImpl(e));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return addLastImpl(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.707 -0400", hash_original_method = "969AA46310549C7B2FEE1AAA28767998", hash_generated_method = "D19EBCDFBFFB2AA8B0A3C9EF7070CC7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E peekFirst() {
        E var94B217481714E58219EA1CF01B75737A_1898329743 = (peekFirstImpl());
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return peekFirstImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.707 -0400", hash_original_method = "E1ADBCAD0BAE3B6D44E0B3EBBD31EB6D", hash_generated_method = "A6DB8CB4D00B6BBCC51100A8F19BEEB5")
    @DSModeled(DSC.SAFE)
    public E peekLast() {
        Link<E> last;
        last = voidLink.previous;
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Link<E> last = voidLink.previous;
        //return (last == voidLink) ? null : last.data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.707 -0400", hash_original_method = "E15F23512F244F97C3914B4E0B9502A4", hash_generated_method = "43820B382DC8977FF1B8DAFCA562F049")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E pollFirst() {
        {
            Object var2655CBB794FED5362E43271F63BC732C_52390961 = (removeFirstImpl());
        } //End flattened ternary
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (size == 0) ? null : removeFirstImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.707 -0400", hash_original_method = "70D8873C9DDF66392CA17B903A435D10", hash_generated_method = "5DF4A5C1AF3CBFA480C5AC7987C831DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E pollLast() {
        {
            Object var84285287CAE567538BC003CE647D63EA_294435140 = (removeLastImpl());
        } //End flattened ternary
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (size == 0) ? null : removeLastImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.707 -0400", hash_original_method = "A1E9A1EB062A81F6CBAFDDDD06F9F273", hash_generated_method = "0277D5B7CA439E2C57584795A6839046")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E pop() {
        E var0ECEFB3EE143FE144D010B600286C5D2_1902712893 = (removeFirstImpl());
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return removeFirstImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.707 -0400", hash_original_method = "9D0F4BD741629A4E20781C5DA21CB652", hash_generated_method = "E80757562EB12D7CE718710689E6F8FD")
    @DSModeled(DSC.SAFE)
    public void push(E e) {
        dsTaint.addTaint(e.dsTaint);
        addFirstImpl(e);
        // ---------- Original Method ----------
        //addFirstImpl(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.707 -0400", hash_original_method = "87160631C9EB1EFA1DB767740655C072", hash_generated_method = "D7C217337237E7317A7B52B82674B4B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean removeFirstOccurrence(Object o) {
        dsTaint.addTaint(o.dsTaint);
        boolean var3B40CEECB1B8A1766358BB718B996E93_2108144146 = (removeFirstOccurrenceImpl(o));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return removeFirstOccurrenceImpl(o);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.707 -0400", hash_original_method = "1733EDDF12DE29E16D5005CF30B5972D", hash_generated_method = "E1DC218EEB8ED77A72E3EBA032CE367A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean removeLastOccurrence(Object o) {
        dsTaint.addTaint(o.dsTaint);
        Iterator<E> iter;
        iter = new ReverseLinkIterator<E>(this);
        boolean var818715EE81985F60936C283DBC275E04_1386660576 = (removeOneOccurrence(o, iter));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Iterator<E> iter = new ReverseLinkIterator<E>(this);
        //return removeOneOccurrence(o, iter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.707 -0400", hash_original_method = "BE1ED77C9E5B42F2AAE1F87EC7415C20", hash_generated_method = "E4E09427F0221A67919D5864CC58E84B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean removeFirstOccurrenceImpl(Object o) {
        dsTaint.addTaint(o.dsTaint);
        Iterator<E> iter;
        iter = new LinkIterator<E>(this, 0);
        boolean var818715EE81985F60936C283DBC275E04_1571831714 = (removeOneOccurrence(o, iter));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Iterator<E> iter = new LinkIterator<E>(this, 0);
        //return removeOneOccurrence(o, iter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.707 -0400", hash_original_method = "0DC759074C3911B534EFB2ED69CB80D3", hash_generated_method = "C802566E846CBBBC77783E0EBCBC9996")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean removeOneOccurrence(Object o, Iterator<E> iter) {
        dsTaint.addTaint(o.dsTaint);
        dsTaint.addTaint(iter.dsTaint);
        {
            boolean varADABAFEBBAB7E585DD903333BD7F20A8_566214867 = (iter.hasNext());
            {
                E element;
                element = iter.next();
                {
                    {
                        boolean varF1A27543F856253D406E948E1C7D5139_1564388626 = (o.equals(element));
                    } //End flattened ternary
                    {
                        iter.remove();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //while (iter.hasNext()) {
            //E element = iter.next();
            //if (o == null ? element == null : o.equals(element)) {
                //iter.remove();
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.707 -0400", hash_original_method = "B473D145452E376F792E71796F81B4CE", hash_generated_method = "49164AB5886A71B16DBAB9A0C09436D7")
    @DSModeled(DSC.SAFE)
    @Override
    public E set(int location, E object) {
        dsTaint.addTaint(location);
        dsTaint.addTaint(object.dsTaint);
        {
            Link<E> link;
            link = voidLink;
            {
                {
                    int i;
                    i = 0;
                    {
                        link = link.next;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    int i;
                    i = size;
                    {
                        link = link.previous;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            E result;
            result = link.data;
            link.data = object;
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (location >= 0 && location < size) {
            //Link<E> link = voidLink;
            //if (location < (size / 2)) {
                //for (int i = 0; i <= location; i++) {
                    //link = link.next;
                //}
            //} else {
                //for (int i = size; i > location; i--) {
                    //link = link.previous;
                //}
            //}
            //E result = link.data;
            //link.data = object;
            //return result;
        //}
        //throw new IndexOutOfBoundsException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.707 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "D93308C9204B4F7B72696D16CFAD067E")
    @DSModeled(DSC.SAFE)
    @Override
    public int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.707 -0400", hash_original_method = "E7666F96333DE978F541663657705932", hash_generated_method = "5B05D6D794D117254C86BA52023B801F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean offer(E o) {
        dsTaint.addTaint(o.dsTaint);
        boolean var0DC980F474C0D58B2EC0CD83E9314E01_1542051933 = (addLastImpl(o));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return addLastImpl(o);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.708 -0400", hash_original_method = "55052725C8F8219BC4435ABBF88EDF4F", hash_generated_method = "D48C9242AB4C6213A3C257DCF0C747A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E poll() {
        {
            Object var4FF36A09B8C43B40AB4A2B1114158ABA_1784720340 = (removeFirst());
        } //End flattened ternary
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return size == 0 ? null : removeFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.708 -0400", hash_original_method = "E6C80B22C4B6B543BB93E41D88CAD5EF", hash_generated_method = "EF6F32692A5A5C5EC5F203147D3106B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E remove() {
        E var0ECEFB3EE143FE144D010B600286C5D2_722172393 = (removeFirstImpl());
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return removeFirstImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.708 -0400", hash_original_method = "4AAADA00C0F9172450031345A8B9DEF3", hash_generated_method = "38553F39BD97064EFDA1F88F3F4C5C56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E peek() {
        E var94B217481714E58219EA1CF01B75737A_67580398 = (peekFirstImpl());
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return peekFirstImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.708 -0400", hash_original_method = "C3985024BAE3B14A3C96F9F04D080FD8", hash_generated_method = "3A90BF2813008F335755B08C2EAD9E5A")
    @DSModeled(DSC.SAFE)
    private E peekFirstImpl() {
        Link<E> first;
        first = voidLink.next;
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Link<E> first = voidLink.next;
        //return first == voidLink ? null : first.data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.708 -0400", hash_original_method = "AFC93F64F463BC2AB0989756248E17C1", hash_generated_method = "6F28E90A3F67BD3F91CB0496D4C5AD67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E element() {
        E var59B306F2C55D6D5B91AE1906FC84C434_59688409 = (getFirstImpl());
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getFirstImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.708 -0400", hash_original_method = "4C8EA5672445A0C074E2691E7533B645", hash_generated_method = "F9FE6C507205122925DA6CFF1DE2CDEA")
    @DSModeled(DSC.SAFE)
    @Override
    public Object[] toArray() {
        int index;
        index = 0;
        Object[] contents;
        contents = new Object[size];
        Link<E> link;
        link = voidLink.next;
        {
            contents[index++] = link.data;
            link = link.next;
        } //End block
        return (Object[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //int index = 0;
        //Object[] contents = new Object[size];
        //Link<E> link = voidLink.next;
        //while (link != voidLink) {
            //contents[index++] = link.data;
            //link = link.next;
        //}
        //return contents;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.708 -0400", hash_original_method = "C06C36ADE827F4BEDBCDBBA1F17737D9", hash_generated_method = "71375EB141077175859E11EAB4D4D9B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] contents) {
        dsTaint.addTaint(contents[0].dsTaint);
        int index;
        index = 0;
        {
            Class<?> ct;
            ct = contents.getClass().getComponentType();
            contents = (T[]) Array.newInstance(ct, size);
        } //End block
        Link<E> link;
        link = voidLink.next;
        {
            contents[index++] = (T) link.data;
            link = link.next;
        } //End block
        {
            contents[index] = null;
        } //End block
        return (T[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //int index = 0;
        //if (size > contents.length) {
            //Class<?> ct = contents.getClass().getComponentType();
            //contents = (T[]) Array.newInstance(ct, size);
        //}
        //Link<E> link = voidLink.next;
        //while (link != voidLink) {
            //contents[index++] = (T) link.data;
            //link = link.next;
        //}
        //if (index < contents.length) {
            //contents[index] = null;
        //}
        //return contents;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.708 -0400", hash_original_method = "6BB9A441F12D3E8CACB448F2BFF70164", hash_generated_method = "43B5D2429FAAE159D43734379F2F427F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(ObjectOutputStream stream) throws IOException {
        dsTaint.addTaint(stream.dsTaint);
        stream.defaultWriteObject();
        stream.writeInt(size);
        Iterator<E> it;
        it = iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_725661689 = (it.hasNext());
            {
                stream.writeObject(it.next());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //stream.defaultWriteObject();
        //stream.writeInt(size);
        //Iterator<E> it = iterator();
        //while (it.hasNext()) {
            //stream.writeObject(it.next());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.708 -0400", hash_original_method = "7A7BB5A4D858D82384B74EA358B45BD7", hash_generated_method = "CD55C0A8904847C6462DAF16D681DFF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        dsTaint.addTaint(stream.dsTaint);
        stream.defaultReadObject();
        size = stream.readInt();
        voidLink = new Link<E>(null, null, null);
        Link<E> link;
        link = voidLink;
        {
            int i;
            i = size;
            {
                Link<E> nextLink;
                nextLink = new Link<E>((E) stream.readObject(), link, null);
                link.next = nextLink;
                link = nextLink;
            } //End block
        } //End collapsed parenthetic
        link.next = voidLink;
        voidLink.previous = link;
        // ---------- Original Method ----------
        //stream.defaultReadObject();
        //size = stream.readInt();
        //voidLink = new Link<E>(null, null, null);
        //Link<E> link = voidLink;
        //for (int i = size; --i >= 0;) {
            //Link<E> nextLink = new Link<E>((E) stream.readObject(), link, null);
            //link.next = nextLink;
            //link = nextLink;
        //}
        //link.next = voidLink;
        //voidLink.previous = link;
    }

    
    private static final class Link<ET> {
        ET data;
        Link<ET> previous, next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.708 -0400", hash_original_method = "92868F30800B380F1BA136D9DCEB0C81", hash_generated_method = "65659CA85256976F95BD44E3C110381E")
        @DSModeled(DSC.SAFE)
         Link(ET o, Link<ET> p, Link<ET> n) {
            dsTaint.addTaint(p.dsTaint);
            dsTaint.addTaint(n.dsTaint);
            dsTaint.addTaint(o.dsTaint);
            // ---------- Original Method ----------
            //data = o;
            //previous = p;
            //next = n;
        }

        
    }


    
    private static final class LinkIterator<ET> implements ListIterator<ET> {
        int pos, expectedModCount;
        final LinkedList<ET> list;
        Link<ET> link, lastLink;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.708 -0400", hash_original_method = "53053DBD9EBACCD4110D93002A695266", hash_generated_method = "5052D072786117B21AEF32F23C5C54E5")
        @DSModeled(DSC.SAFE)
         LinkIterator(LinkedList<ET> object, int location) {
            dsTaint.addTaint(location);
            dsTaint.addTaint(object.dsTaint);
            list = object;
            expectedModCount = list.modCount;
            {
                link = list.voidLink;
                {
                    {
                        pos = -1;
                        {
                            link = link.next;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        pos = list.size;
                        {
                            link = link.previous;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            {
                throw new IndexOutOfBoundsException();
            } //End block
            // ---------- Original Method ----------
            //list = object;
            //expectedModCount = list.modCount;
            //if (location >= 0 && location <= list.size) {
                //link = list.voidLink;
                //if (location < list.size / 2) {
                    //for (pos = -1; pos + 1 < location; pos++) {
                        //link = link.next;
                    //}
                //} else {
                    //for (pos = list.size; pos >= location; pos--) {
                        //link = link.previous;
                    //}
                //}
            //} else {
                //throw new IndexOutOfBoundsException();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.709 -0400", hash_original_method = "A220301E4EE3196C2657CD6F6C345E76", hash_generated_method = "CCAC9C62A6A7E45FCBD12AEE8CC3F78D")
        @DSModeled(DSC.SAFE)
        public void add(ET object) {
            dsTaint.addTaint(object.dsTaint);
            {
                Link<ET> next;
                next = link.next;
                Link<ET> newLink;
                newLink = new Link<ET>(object, link, next);
                link.next = newLink;
                next.previous = newLink;
                link = newLink;
                lastLink = null;
                pos++;
                expectedModCount++;
                list.size++;
                list.modCount++;
            } //End block
            {
                throw new ConcurrentModificationException();
            } //End block
            // ---------- Original Method ----------
            //if (expectedModCount == list.modCount) {
                //Link<ET> next = link.next;
                //Link<ET> newLink = new Link<ET>(object, link, next);
                //link.next = newLink;
                //next.previous = newLink;
                //link = newLink;
                //lastLink = null;
                //pos++;
                //expectedModCount++;
                //list.size++;
                //list.modCount++;
            //} else {
                //throw new ConcurrentModificationException();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.709 -0400", hash_original_method = "D12271F7604D5FEC65FB34942C4AE52F", hash_generated_method = "6BD5B3A9B2E3E11A4BADF565601AEEF0")
        @DSModeled(DSC.SAFE)
        public boolean hasNext() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return link.next != list.voidLink;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.709 -0400", hash_original_method = "D62F69678251E4F27FB63666837CF4D1", hash_generated_method = "139A734333B66517BCAD6E8FBA4B9D06")
        @DSModeled(DSC.SAFE)
        public boolean hasPrevious() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return link != list.voidLink;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.709 -0400", hash_original_method = "DAF205186410308F2C7B687C3EB1A5B6", hash_generated_method = "2BDD408FC158C7121A30732A7AA7928D")
        @DSModeled(DSC.SAFE)
        public ET next() {
            {
                LinkedList.Link<ET> next;
                next = link.next;
                {
                    lastLink = link = next;
                    pos++;
                } //End block
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            return (ET)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (expectedModCount == list.modCount) {
                //LinkedList.Link<ET> next = link.next;
                //if (next != list.voidLink) {
                    //lastLink = link = next;
                    //pos++;
                    //return link.data;
                //}
                //throw new NoSuchElementException();
            //}
            //throw new ConcurrentModificationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.709 -0400", hash_original_method = "1B59C01DCB2067B0BBD0025D75B60071", hash_generated_method = "E9733AFB31A417A7ACC5E6A00248FD58")
        @DSModeled(DSC.SAFE)
        public int nextIndex() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return pos + 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.709 -0400", hash_original_method = "C56DBD8071305313D7DDB1E67B6D94B0", hash_generated_method = "490FB60CB6B2A8F88CAC8F01C569FF48")
        @DSModeled(DSC.SAFE)
        public ET previous() {
            {
                {
                    lastLink = link;
                    link = link.previous;
                    pos--;
                } //End block
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            return (ET)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (expectedModCount == list.modCount) {
                //if (link != list.voidLink) {
                    //lastLink = link;
                    //link = link.previous;
                    //pos--;
                    //return lastLink.data;
                //}
                //throw new NoSuchElementException();
            //}
            //throw new ConcurrentModificationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.709 -0400", hash_original_method = "DC75AA0325D63F3F64774210ED43B204", hash_generated_method = "0ECB53186A73CE587E8390AAEA0E67B4")
        @DSModeled(DSC.SAFE)
        public int previousIndex() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return pos;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.709 -0400", hash_original_method = "454EC742FAC97A85450236EC802A7816", hash_generated_method = "D5244EB6CBAA2D1B9DD9231173792CDF")
        @DSModeled(DSC.SAFE)
        public void remove() {
            {
                {
                    Link<ET> next;
                    next = lastLink.next;
                    Link<ET> previous;
                    previous = lastLink.previous;
                    next.previous = previous;
                    previous.next = next;
                    {
                        pos--;
                    } //End block
                    link = previous;
                    lastLink = null;
                    expectedModCount++;
                    list.size--;
                    list.modCount++;
                } //End block
                {
                	if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
                } //End block
            } //End block
            {
            	if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            } //End block
            // ---------- Original Method ----------
            //if (expectedModCount == list.modCount) {
                //if (lastLink != null) {
                    //Link<ET> next = lastLink.next;
                    //Link<ET> previous = lastLink.previous;
                    //next.previous = previous;
                    //previous.next = next;
                    //if (lastLink == link) {
                        //pos--;
                    //}
                    //link = previous;
                    //lastLink = null;
                    //expectedModCount++;
                    //list.size--;
                    //list.modCount++;
                //} else {
                    //throw new IllegalStateException();
                //}
            //} else {
                //throw new ConcurrentModificationException();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.709 -0400", hash_original_method = "8A5D5DD2AB039971BB00FDD7ADDD55B1", hash_generated_method = "A9CD4E9753B96663AA0892B46F9D4CD8")
        @DSModeled(DSC.SAFE)
        public void set(ET object) {
            dsTaint.addTaint(object.dsTaint);
            {
                {
                    lastLink.data = object;
                } //End block
                {
                	if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
                } //End block
            } //End block
            {
            	if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            } //End block
            // ---------- Original Method ----------
            //if (expectedModCount == list.modCount) {
                //if (lastLink != null) {
                    //lastLink.data = object;
                //} else {
                    //throw new IllegalStateException();
                //}
            //} else {
                //throw new ConcurrentModificationException();
            //}
        }

        
    }


    
    private class ReverseLinkIterator<ET> implements Iterator<ET> {
        private int expectedModCount;
        private final LinkedList<ET> list;
        private Link<ET> link;
        private boolean canRemove;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.709 -0400", hash_original_method = "2C54C06EA8F2B61501161B2BC13D7FF2", hash_generated_method = "E4A38D11A07FC5051FCC566AADFD8791")
        @DSModeled(DSC.SAFE)
         ReverseLinkIterator(LinkedList<ET> linkedList) {
            dsTaint.addTaint(linkedList.dsTaint);
            list = linkedList;
            expectedModCount = list.modCount;
            link = list.voidLink;
            canRemove = false;
            // ---------- Original Method ----------
            //list = linkedList;
            //expectedModCount = list.modCount;
            //link = list.voidLink;
            //canRemove = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.709 -0400", hash_original_method = "683C5349A490B93F6F23CFDE8DA49A7E", hash_generated_method = "09B924B88E7ED44D038305BF06A20E4F")
        @DSModeled(DSC.SAFE)
        public boolean hasNext() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return link.previous != list.voidLink;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.710 -0400", hash_original_method = "B57C4B4DEBE6A9EB91858512EE525B72", hash_generated_method = "683153EC4FD7FFDCB0332D1FF5996982")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ET next() {
            {
                {
                    boolean var384B0C75E2EB52B4939B27A6F15C2DC1_174256768 = (hasNext());
                    {
                        link = link.previous;
                        canRemove = true;
                    } //End block
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            return (ET)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (expectedModCount == list.modCount) {
                //if (hasNext()) {
                    //link = link.previous;
                    //canRemove = true;
                    //return link.data;
                //}
                //throw new NoSuchElementException();
            //}
            //throw new ConcurrentModificationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.710 -0400", hash_original_method = "07412F520F702F11B7EB1920D3A5A17D", hash_generated_method = "14989B33947C9C8E5BAF3654963E7D93")
        @DSModeled(DSC.SAFE)
        public void remove() {
            {
                {
                    Link<ET> next;
                    next = link.previous;
                    Link<ET> previous;
                    previous = link.next;
                    next.next = previous;
                    previous.previous = next;
                    link = previous;
                    list.size--;
                    list.modCount++;
                    expectedModCount++;
                    canRemove = false;
                } //End block
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            // ---------- Original Method ----------
            //if (expectedModCount == list.modCount) {
                //if (canRemove) {
                    //Link<ET> next = link.previous;
                    //Link<ET> previous = link.next;
                    //next.next = previous;
                    //previous.previous = next;
                    //link = previous;
                    //list.size--;
                    //list.modCount++;
                    //expectedModCount++;
                    //canRemove = false;
                    //return;
                //}
                //throw new IllegalStateException();
            //}
            //throw new ConcurrentModificationException();
        }

        
    }


    
}


