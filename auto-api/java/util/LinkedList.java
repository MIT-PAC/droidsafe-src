package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;

public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Queue<E>, Cloneable, Serializable {
    transient int size = 0;
    transient Link<E> voidLink;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.783 -0400", hash_original_method = "4832DB7F32D79BC3832C9989ACB7B916", hash_generated_method = "8DFD03108CDD2A33CB7D765F5A450A4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkedList() {
        voidLink = new Link<E>(null, null, null);
        voidLink.previous = voidLink;
        voidLink.next = voidLink;
        // ---------- Original Method ----------
        //voidLink = new Link<E>(null, null, null);
        //voidLink.previous = voidLink;
        //voidLink.next = voidLink;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.783 -0400", hash_original_method = "0B559D29C113071CE6BE3D63B71465EB", hash_generated_method = "1B54D3AE89696E63815866C43705D5FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkedList(Collection<? extends E> collection) {
        this();
        dsTaint.addTaint(collection.dsTaint);
        addAll(collection);
        // ---------- Original Method ----------
        //addAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.783 -0400", hash_original_method = "9920EB632989F8B562686C0A781A0AB0", hash_generated_method = "B023DA3A927FFBDB077C2EA2333C6B08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.783 -0400", hash_original_method = "2BE8A2B5B965FC484F0C7216D8E6E369", hash_generated_method = "374B8CA5BBA7AF17571DC82EFCAD6B3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean add(E object) {
        dsTaint.addTaint(object.dsTaint);
        boolean var471407E29FACACFF33C18CE3EA47D39B_1891074641 = (addLastImpl(object));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return addLastImpl(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.783 -0400", hash_original_method = "0CAFD9F2E83DD82BF6364CDBDC4D7D1A", hash_generated_method = "0CA556915A516B3210ADDD71DAE20E85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean addLastImpl(E object) {
        dsTaint.addTaint(object.dsTaint);
        Link<E> oldLast;
        oldLast = voidLink.previous;
        Link<E> newLink;
        newLink = new Link<E>(object, oldLast, voidLink);
        voidLink.previous = newLink;
        oldLast.next = newLink;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.821 -0400", hash_original_method = "EA599DD8388630A135A57F30093AE237", hash_generated_method = "4FF9434C39A1E42B4052EBC09EF68BE4")
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
        boolean var92E505E88442E11C36215AFDE9C5C198_1415727215 = ((collection == this));
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
            Iterator<E> var561DB81069E26BF25CD542D342D4C6DE_409517396 = (elements).iterator();
            var561DB81069E26BF25CD542D342D4C6DE_409517396.hasNext();
            E e = var561DB81069E26BF25CD542D342D4C6DE_409517396.next();
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.855 -0400", hash_original_method = "B5A413C7ECEF6975CDBDA09F397FBA87", hash_generated_method = "7FD997375567F1E77A7CA40FE915B6B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean addAll(Collection<? extends E> collection) {
        dsTaint.addTaint(collection.dsTaint);
        int adding;
        adding = collection.size();
        Collection<? extends E> elements;
        boolean var92E505E88442E11C36215AFDE9C5C198_769600102 = ((collection == this));
        elements = new ArrayList<E>(collection);
        elements = collection;
        Link<E> previous;
        previous = voidLink.previous;
        {
            Iterator<E> var561DB81069E26BF25CD542D342D4C6DE_1368748803 = (elements).iterator();
            var561DB81069E26BF25CD542D342D4C6DE_1368748803.hasNext();
            E e = var561DB81069E26BF25CD542D342D4C6DE_1368748803.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.858 -0400", hash_original_method = "CA8A1B06476946B0324CCA25F612E720", hash_generated_method = "F4A678A85FE9114BE38EDE428286F04B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addFirst(E object) {
        dsTaint.addTaint(object.dsTaint);
        addFirstImpl(object);
        // ---------- Original Method ----------
        //addFirstImpl(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.860 -0400", hash_original_method = "954FD4442748B652A7955CF114F2239E", hash_generated_method = "6022C03CF4916B948CC8EC88386184E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean addFirstImpl(E object) {
        dsTaint.addTaint(object.dsTaint);
        Link<E> oldFirst;
        oldFirst = voidLink.next;
        Link<E> newLink;
        newLink = new Link<E>(object, voidLink, oldFirst);
        voidLink.next = newLink;
        oldFirst.previous = newLink;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.860 -0400", hash_original_method = "13A36680ECD01352EC1F894705FA522D", hash_generated_method = "8EAF8D0CA2603ACA2B323205101753A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addLast(E object) {
        dsTaint.addTaint(object.dsTaint);
        addLastImpl(object);
        // ---------- Original Method ----------
        //addLastImpl(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.860 -0400", hash_original_method = "F4AB109BD4924C3D8662019AA7349AF5", hash_generated_method = "D053313FADC6AFD02128C0FBBDD81B2D")
    @DSModeled(DSC.SAFE)
    @Override
    public void clear() {
        {
            size = 0;
            voidLink.next = voidLink;
            voidLink.previous = voidLink;
        } //End block
        // ---------- Original Method ----------
        //if (size > 0) {
            //size = 0;
            //voidLink.next = voidLink;
            //voidLink.previous = voidLink;
            //modCount++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.861 -0400", hash_original_method = "1B9E5D872B5FE69DD2C5F33B9044F30B", hash_generated_method = "FF470448E8FC5ABD0D39E9CE61B03894")
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
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.862 -0400", hash_original_method = "56D0217BC0A5D945F9BCFA2A5AF2C1AD", hash_generated_method = "D0BD8C057284289CFE7D7D893CC35A60")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean contains(Object object) {
        dsTaint.addTaint(object.dsTaint);
        Link<E> link;
        link = voidLink.next;
        {
            {
                {
                    boolean var68AE80027D20B2F4904BFC3ADBBA50B7_1502156919 = (object.equals(link.data));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.863 -0400", hash_original_method = "699CDCD94CA0F8A673D2432C1A4A1CA6", hash_generated_method = "FD41768E9BB022C4EDF868691208BEED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.863 -0400", hash_original_method = "0073A2AD94DC363435B793B69AD53800", hash_generated_method = "5ABA48BB835857A8CEB1D0B41B2508E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E getFirst() {
        E var59B306F2C55D6D5B91AE1906FC84C434_290045761 = (getFirstImpl());
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getFirstImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.864 -0400", hash_original_method = "F326A7609FEC22B872586B521BF21968", hash_generated_method = "2CA3352BA370A301E75066ECC69CA429")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.865 -0400", hash_original_method = "D36A1824B4AA11A93F9167DC96C3E776", hash_generated_method = "998499B3972121547366AC0DBA4B5F60")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.865 -0400", hash_original_method = "223AFBB612F259C1ECF52502B2C38D06", hash_generated_method = "8F7188FA11B19FCA22BBB0E61310ED68")
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
                    boolean var68AE80027D20B2F4904BFC3ADBBA50B7_1483807991 = (object.equals(link.data));
                } //End collapsed parenthetic
                link = link.next;
            } //End block
        } //End block
        {
            {
                link = link.next;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.865 -0400", hash_original_method = "C5BD92F697D9C0CCDCACCA1E644478EA", hash_generated_method = "468E4BE81CD1CA26208336E99371FF93")
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
                {
                    boolean var68AE80027D20B2F4904BFC3ADBBA50B7_939202376 = (object.equals(link.data));
                } //End collapsed parenthetic
                link = link.previous;
            } //End block
        } //End block
        {
            {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.865 -0400", hash_original_method = "3507AEFB380BBD7C7A81BC76F9B74E53", hash_generated_method = "7749E047DCF5134E8E335FB4D6D54065")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ListIterator<E> listIterator(int location) {
        dsTaint.addTaint(location);
        ListIterator<E> var139C84612F110F2764A0E7795391D250_268871918 = (new LinkIterator<E>(this, location));
        return (ListIterator<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new LinkIterator<E>(this, location);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.866 -0400", hash_original_method = "9DEB2DAC83546A51EF3DAC82C2B24429", hash_generated_method = "55473B580C792631DE9054B961059069")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.866 -0400", hash_original_method = "E895D44AE5728A8CB5D4093F924DE858", hash_generated_method = "EA8B5D228B0B20FF3A4D0480EF7EF16B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean remove(Object object) {
        dsTaint.addTaint(object.dsTaint);
        boolean varD9AA6A5988D1CD4CF0EC501538EC1CB9_661652135 = (removeFirstOccurrenceImpl(object));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return removeFirstOccurrenceImpl(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.866 -0400", hash_original_method = "DEF022B3B9EBAD20A11E8D94E53A2C41", hash_generated_method = "29ED7F812D37233F73EDBC47235441DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E removeFirst() {
        E var0ECEFB3EE143FE144D010B600286C5D2_1445802729 = (removeFirstImpl());
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return removeFirstImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.866 -0400", hash_original_method = "427E50F3C77738614041495F63E4380E", hash_generated_method = "0C4B80BD95339D7EAAD9952616281D09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private E removeFirstImpl() {
        Link<E> first;
        first = voidLink.next;
        {
            Link<E> next;
            next = first.next;
            voidLink.next = next;
            next.previous = voidLink;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.866 -0400", hash_original_method = "78A299256A25A92F54699488F92E9106", hash_generated_method = "EF2BE6A6F710BDF032D7F13A07B49C13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E removeLast() {
        E var49CF835FEE0E90D023B94877E5FC4762_1640738185 = (removeLastImpl());
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return removeLastImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.867 -0400", hash_original_method = "4FEFCE90045B22FA30A5F2F8A3DA8ABA", hash_generated_method = "2C404E7B087CD2891064065A1468B2A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private E removeLastImpl() {
        Link<E> last;
        last = voidLink.previous;
        {
            Link<E> previous;
            previous = last.previous;
            voidLink.previous = previous;
            previous.next = voidLink;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.867 -0400", hash_original_method = "B739DCE0B4C0EF3D97CD82250338592B", hash_generated_method = "D566031701ED36800656B5D60C299D83")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Iterator<E> descendingIterator() {
        Iterator<E> varD969690BE16F5C59CBCB2F630BA16D62_771931286 = (new ReverseLinkIterator<E>(this));
        return (Iterator<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ReverseLinkIterator<E>(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.867 -0400", hash_original_method = "EDFB7FC0634DB7C00BD3AB035EBD094A", hash_generated_method = "62E4BA5580C557F6AAEC63432E2F6E97")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean offerFirst(E e) {
        dsTaint.addTaint(e.dsTaint);
        boolean var76B72DE79F3E513315008517C001461F_2082546492 = (addFirstImpl(e));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return addFirstImpl(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.867 -0400", hash_original_method = "89DCF7809C68E43568923DE3D2E1D02D", hash_generated_method = "86691D57C8C2DB96D48AD4526EE89C34")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean offerLast(E e) {
        dsTaint.addTaint(e.dsTaint);
        boolean var5D8D8C0594128842346FC018CF7B2C46_459693016 = (addLastImpl(e));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return addLastImpl(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.867 -0400", hash_original_method = "969AA46310549C7B2FEE1AAA28767998", hash_generated_method = "79D0C1B1E0A493958946CFCEB8664632")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E peekFirst() {
        E var94B217481714E58219EA1CF01B75737A_1007913405 = (peekFirstImpl());
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return peekFirstImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.867 -0400", hash_original_method = "E1ADBCAD0BAE3B6D44E0B3EBBD31EB6D", hash_generated_method = "4FE3B4074CC6A499277E9996339360CB")
    @DSModeled(DSC.SAFE)
    public E peekLast() {
        Link<E> last;
        last = voidLink.previous;
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Link<E> last = voidLink.previous;
        //return (last == voidLink) ? null : last.data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.868 -0400", hash_original_method = "E15F23512F244F97C3914B4E0B9502A4", hash_generated_method = "EBF075A1F3A01EC10BDC28A9D476E12E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E pollFirst() {
        {
            Object var2655CBB794FED5362E43271F63BC732C_1357918919 = (removeFirstImpl());
        } //End flattened ternary
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (size == 0) ? null : removeFirstImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.868 -0400", hash_original_method = "70D8873C9DDF66392CA17B903A435D10", hash_generated_method = "5430F24F00F179F383AF14F9A2497CED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E pollLast() {
        {
            Object var84285287CAE567538BC003CE647D63EA_984536836 = (removeLastImpl());
        } //End flattened ternary
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (size == 0) ? null : removeLastImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.868 -0400", hash_original_method = "A1E9A1EB062A81F6CBAFDDDD06F9F273", hash_generated_method = "6883E48049256592E13EDEE7E883D01B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E pop() {
        E var0ECEFB3EE143FE144D010B600286C5D2_1718014139 = (removeFirstImpl());
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return removeFirstImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.868 -0400", hash_original_method = "9D0F4BD741629A4E20781C5DA21CB652", hash_generated_method = "ECAAEEE1A5218E2529E6C8380AC1C0DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void push(E e) {
        dsTaint.addTaint(e.dsTaint);
        addFirstImpl(e);
        // ---------- Original Method ----------
        //addFirstImpl(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.868 -0400", hash_original_method = "87160631C9EB1EFA1DB767740655C072", hash_generated_method = "BDDBF7180FBF07810888F2A92C7EA49F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean removeFirstOccurrence(Object o) {
        dsTaint.addTaint(o.dsTaint);
        boolean var3B40CEECB1B8A1766358BB718B996E93_1604754812 = (removeFirstOccurrenceImpl(o));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return removeFirstOccurrenceImpl(o);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.869 -0400", hash_original_method = "1733EDDF12DE29E16D5005CF30B5972D", hash_generated_method = "8F1269EC22FFA72248C1D55FEABC3837")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean removeLastOccurrence(Object o) {
        dsTaint.addTaint(o.dsTaint);
        Iterator<E> iter;
        iter = new ReverseLinkIterator<E>(this);
        boolean var818715EE81985F60936C283DBC275E04_1837842301 = (removeOneOccurrence(o, iter));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Iterator<E> iter = new ReverseLinkIterator<E>(this);
        //return removeOneOccurrence(o, iter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.869 -0400", hash_original_method = "BE1ED77C9E5B42F2AAE1F87EC7415C20", hash_generated_method = "04C406ABF33C2F2D43ADC0D75E8B58E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean removeFirstOccurrenceImpl(Object o) {
        dsTaint.addTaint(o.dsTaint);
        Iterator<E> iter;
        iter = new LinkIterator<E>(this, 0);
        boolean var818715EE81985F60936C283DBC275E04_309402531 = (removeOneOccurrence(o, iter));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Iterator<E> iter = new LinkIterator<E>(this, 0);
        //return removeOneOccurrence(o, iter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.869 -0400", hash_original_method = "0DC759074C3911B534EFB2ED69CB80D3", hash_generated_method = "A4816661DF4422CA72BE0DEA849D5EC9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean removeOneOccurrence(Object o, Iterator<E> iter) {
        dsTaint.addTaint(o.dsTaint);
        dsTaint.addTaint(iter.dsTaint);
        {
            boolean varADABAFEBBAB7E585DD903333BD7F20A8_1073225625 = (iter.hasNext());
            {
                E element;
                element = iter.next();
                {
                    {
                        boolean varF1A27543F856253D406E948E1C7D5139_729036442 = (o.equals(element));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.870 -0400", hash_original_method = "B473D145452E376F792E71796F81B4CE", hash_generated_method = "A85C121C81015B2A21E54A66AC0761D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.870 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "2127DA49D089D6CBC77B455A0DBDC124")
    @DSModeled(DSC.SAFE)
    @Override
    public int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.870 -0400", hash_original_method = "E7666F96333DE978F541663657705932", hash_generated_method = "11D1FC664100244E77AEAAED3B356210")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean offer(E o) {
        dsTaint.addTaint(o.dsTaint);
        boolean var0DC980F474C0D58B2EC0CD83E9314E01_1476303933 = (addLastImpl(o));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return addLastImpl(o);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.870 -0400", hash_original_method = "55052725C8F8219BC4435ABBF88EDF4F", hash_generated_method = "76CA6EEEFFFD8A3D9183D15B69F959E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E poll() {
        {
            Object var4FF36A09B8C43B40AB4A2B1114158ABA_1890940778 = (removeFirst());
        } //End flattened ternary
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return size == 0 ? null : removeFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.870 -0400", hash_original_method = "E6C80B22C4B6B543BB93E41D88CAD5EF", hash_generated_method = "014407916131F167A347FEBD358B5C8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E remove() {
        E var0ECEFB3EE143FE144D010B600286C5D2_450452772 = (removeFirstImpl());
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return removeFirstImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.870 -0400", hash_original_method = "4AAADA00C0F9172450031345A8B9DEF3", hash_generated_method = "8F28E3B120255964A9A1C7DF94401ED9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E peek() {
        E var94B217481714E58219EA1CF01B75737A_1985158506 = (peekFirstImpl());
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return peekFirstImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.871 -0400", hash_original_method = "C3985024BAE3B14A3C96F9F04D080FD8", hash_generated_method = "6FB8DDFB3A202E6D795AD88096E19E99")
    @DSModeled(DSC.SAFE)
    private E peekFirstImpl() {
        Link<E> first;
        first = voidLink.next;
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Link<E> first = voidLink.next;
        //return first == voidLink ? null : first.data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.871 -0400", hash_original_method = "AFC93F64F463BC2AB0989756248E17C1", hash_generated_method = "A0A6665A62B52E04B729660EA0F6B60C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E element() {
        E var59B306F2C55D6D5B91AE1906FC84C434_1416670343 = (getFirstImpl());
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getFirstImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.871 -0400", hash_original_method = "4C8EA5672445A0C074E2691E7533B645", hash_generated_method = "870B39AEAA56316A89F19D6E9EA3E8CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.871 -0400", hash_original_method = "C06C36ADE827F4BEDBCDBBA1F17737D9", hash_generated_method = "633AD1A685AB1BF64377D85631F8404B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.871 -0400", hash_original_method = "6BB9A441F12D3E8CACB448F2BFF70164", hash_generated_method = "39E6B957DF87D964E573BA238F2C4919")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(ObjectOutputStream stream) throws IOException {
        dsTaint.addTaint(stream.dsTaint);
        stream.defaultWriteObject();
        stream.writeInt(size);
        Iterator<E> it;
        it = iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_151876437 = (it.hasNext());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.872 -0400", hash_original_method = "7A7BB5A4D858D82384B74EA358B45BD7", hash_generated_method = "AA51E97134380377884B15AE1DC9561F")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.872 -0400", hash_original_method = "92868F30800B380F1BA136D9DCEB0C81", hash_generated_method = "016AF29C48EF21669B351E3DBDEC53B1")
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
        LinkedList<ET> list;
        Link<ET> link, lastLink;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.872 -0400", hash_original_method = "53053DBD9EBACCD4110D93002A695266", hash_generated_method = "7D15C5C0FF65CA3A4A13D597FD4229B0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         LinkIterator(LinkedList<ET> object, int location) {
            dsTaint.addTaint(location);
            dsTaint.addTaint(object.dsTaint);
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
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.873 -0400", hash_original_method = "A220301E4EE3196C2657CD6F6C345E76", hash_generated_method = "C0625A25AAA37CF1948A4A9C3845977B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.873 -0400", hash_original_method = "D12271F7604D5FEC65FB34942C4AE52F", hash_generated_method = "396C88B8B5CBCB4BC238C15136B0C482")
        @DSModeled(DSC.SAFE)
        public boolean hasNext() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return link.next != list.voidLink;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.873 -0400", hash_original_method = "D62F69678251E4F27FB63666837CF4D1", hash_generated_method = "308EDBAD2360E340405A884B48672DFB")
        @DSModeled(DSC.SAFE)
        public boolean hasPrevious() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return link != list.voidLink;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.873 -0400", hash_original_method = "DAF205186410308F2C7B687C3EB1A5B6", hash_generated_method = "81CE786005A6E9A8BC4BC78CB120138B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ET next() {
            {
                LinkedList.Link<ET> next;
                next = link.next;
                {
                    lastLink = link = next;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.873 -0400", hash_original_method = "1B59C01DCB2067B0BBD0025D75B60071", hash_generated_method = "EE5335FE12DA387F6B68164A1306405E")
        @DSModeled(DSC.SAFE)
        public int nextIndex() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return pos + 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.873 -0400", hash_original_method = "C56DBD8071305313D7DDB1E67B6D94B0", hash_generated_method = "E6220CCF64E155E5638D2F81339E6DD9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ET previous() {
            {
                {
                    lastLink = link;
                    link = link.previous;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.874 -0400", hash_original_method = "DC75AA0325D63F3F64774210ED43B204", hash_generated_method = "8E046BDC40C4B1362A87026B83413D5E")
        @DSModeled(DSC.SAFE)
        public int previousIndex() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return pos;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.874 -0400", hash_original_method = "454EC742FAC97A85450236EC802A7816", hash_generated_method = "D825FA27847C1F4F9C771E090D94074F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void remove() {
            {
                {
                    Link<ET> next;
                    next = lastLink.next;
                    Link<ET> previous;
                    previous = lastLink.previous;
                    next.previous = previous;
                    previous.next = next;
                    link = previous;
                    lastLink = null;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.874 -0400", hash_original_method = "8A5D5DD2AB039971BB00FDD7ADDD55B1", hash_generated_method = "37D90CB3C05A0D74A9800CD8D364B90D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
        private LinkedList<ET> list;
        private Link<ET> link;
        private boolean canRemove;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.874 -0400", hash_original_method = "2C54C06EA8F2B61501161B2BC13D7FF2", hash_generated_method = "0F0A5CF1BDF1E332C93FFE2D568A7CFD")
        @DSModeled(DSC.SAFE)
         ReverseLinkIterator(LinkedList<ET> linkedList) {
            dsTaint.addTaint(linkedList.dsTaint);
            expectedModCount = list.modCount;
            link = list.voidLink;
            canRemove = false;
            // ---------- Original Method ----------
            //list = linkedList;
            //expectedModCount = list.modCount;
            //link = list.voidLink;
            //canRemove = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.875 -0400", hash_original_method = "683C5349A490B93F6F23CFDE8DA49A7E", hash_generated_method = "2D81EFC699D940DEEC1F42C8F21B9157")
        @DSModeled(DSC.SAFE)
        public boolean hasNext() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return link.previous != list.voidLink;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.875 -0400", hash_original_method = "B57C4B4DEBE6A9EB91858512EE525B72", hash_generated_method = "E4A56C1C2FA5ADA5D117A8779DA859E3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ET next() {
            {
                {
                    boolean var384B0C75E2EB52B4939B27A6F15C2DC1_273962441 = (hasNext());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.875 -0400", hash_original_method = "07412F520F702F11B7EB1920D3A5A17D", hash_generated_method = "0418FFF55C95EB8133C6225BC4641971")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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


    
    private static final long serialVersionUID = 876323262645176354L;
}

