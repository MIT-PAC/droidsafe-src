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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.058 -0400", hash_original_field = "4C519DE3531208469B40CCB51004CD2D", hash_generated_field = "073488151E86FC108C1C096E75333D8B")

    transient int size = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.059 -0400", hash_original_field = "6C73C6B87FF2058988CE8C8EDB3429F0", hash_generated_field = "42E74DE51E61A92C4317D76844761684")

    transient Link<E> voidLink;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.060 -0400", hash_original_method = "4832DB7F32D79BC3832C9989ACB7B916", hash_generated_method = "8DFD03108CDD2A33CB7D765F5A450A4F")
    public  LinkedList() {
        voidLink = new Link<E>(null, null, null);
        voidLink.previous = voidLink;
        voidLink.next = voidLink;
        // ---------- Original Method ----------
        //voidLink = new Link<E>(null, null, null);
        //voidLink.previous = voidLink;
        //voidLink.next = voidLink;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.060 -0400", hash_original_method = "0B559D29C113071CE6BE3D63B71465EB", hash_generated_method = "AC19F03332B19D11288983929D1CF7F0")
    public  LinkedList(Collection<? extends E> collection) {
        this();
        addAll(collection);
        addTaint(collection.getTaint());
        // ---------- Original Method ----------
        //addAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.060 -0400", hash_original_method = "9920EB632989F8B562686C0A781A0AB0", hash_generated_method = "18AC506C7F34C738C668E0E3A6D201EF")
    @Override
    public void add(int location, E object) {
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
        addTaint(location);
        addTaint(object.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.068 -0400", hash_original_method = "2BE8A2B5B965FC484F0C7216D8E6E369", hash_generated_method = "6EDFC62EB2539B850E8D325C01EA589B")
    @Override
    public boolean add(E object) {
        boolean var471407E29FACACFF33C18CE3EA47D39B_194740080 = (addLastImpl(object));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_452150204 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_452150204;
        // ---------- Original Method ----------
        //return addLastImpl(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.069 -0400", hash_original_method = "0CAFD9F2E83DD82BF6364CDBDC4D7D1A", hash_generated_method = "CEBABAE304215C7AE9DD5BA8046591CF")
    private boolean addLastImpl(E object) {
        Link<E> oldLast;
        oldLast = voidLink.previous;
        Link<E> newLink;
        newLink = new Link<E>(object, oldLast, voidLink);
        voidLink.previous = newLink;
        oldLast.next = newLink;
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1969307860 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1969307860;
        // ---------- Original Method ----------
        //Link<E> oldLast = voidLink.previous;
        //Link<E> newLink = new Link<E>(object, oldLast, voidLink);
        //voidLink.previous = newLink;
        //oldLast.next = newLink;
        //size++;
        //modCount++;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.216 -0400", hash_original_method = "EA599DD8388630A135A57F30093AE237", hash_generated_method = "4E79DA2110F5937F2BAC8EA2D72384B1")
    @Override
    public boolean addAll(int location, Collection<? extends E> collection) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        int adding;
        adding = collection.size();
        Collection<? extends E> elements;
        boolean var92E505E88442E11C36215AFDE9C5C198_127754617 = ((collection == this));
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
            Iterator<E> var561DB81069E26BF25CD542D342D4C6DE_1222117740 = (elements).iterator();
            var561DB81069E26BF25CD542D342D4C6DE_1222117740.hasNext();
            E e = var561DB81069E26BF25CD542D342D4C6DE_1222117740.next();
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
        addTaint(location);
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1665373395 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1665373395;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.342 -0400", hash_original_method = "B5A413C7ECEF6975CDBDA09F397FBA87", hash_generated_method = "51F67B14A448DB4D38CBB5EC5961007D")
    @Override
    public boolean addAll(Collection<? extends E> collection) {
        int adding;
        adding = collection.size();
        Collection<? extends E> elements;
        boolean var92E505E88442E11C36215AFDE9C5C198_1987762815 = ((collection == this));
        elements = new ArrayList<E>(collection);
        elements = collection;
        Link<E> previous;
        previous = voidLink.previous;
        {
            Iterator<E> var561DB81069E26BF25CD542D342D4C6DE_563767833 = (elements).iterator();
            var561DB81069E26BF25CD542D342D4C6DE_563767833.hasNext();
            E e = var561DB81069E26BF25CD542D342D4C6DE_563767833.next();
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
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1394209863 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1394209863;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.342 -0400", hash_original_method = "CA8A1B06476946B0324CCA25F612E720", hash_generated_method = "9DCD568A7260257AF3A07EEE903FBDCB")
    public void addFirst(E object) {
        addFirstImpl(object);
        addTaint(object.getTaint());
        // ---------- Original Method ----------
        //addFirstImpl(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.347 -0400", hash_original_method = "954FD4442748B652A7955CF114F2239E", hash_generated_method = "B4D24B3D2ABE73E2EA637B86945716BA")
    private boolean addFirstImpl(E object) {
        Link<E> oldFirst;
        oldFirst = voidLink.next;
        Link<E> newLink;
        newLink = new Link<E>(object, voidLink, oldFirst);
        voidLink.next = newLink;
        oldFirst.previous = newLink;
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1180100796 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1180100796;
        // ---------- Original Method ----------
        //Link<E> oldFirst = voidLink.next;
        //Link<E> newLink = new Link<E>(object, voidLink, oldFirst);
        //voidLink.next = newLink;
        //oldFirst.previous = newLink;
        //size++;
        //modCount++;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.347 -0400", hash_original_method = "13A36680ECD01352EC1F894705FA522D", hash_generated_method = "AC09CC797ECC1C6010850BBCF757682C")
    public void addLast(E object) {
        addLastImpl(object);
        addTaint(object.getTaint());
        // ---------- Original Method ----------
        //addLastImpl(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.348 -0400", hash_original_method = "F4AB109BD4924C3D8662019AA7349AF5", hash_generated_method = "D053313FADC6AFD02128C0FBBDD81B2D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.360 -0400", hash_original_method = "1B9E5D872B5FE69DD2C5F33B9044F30B", hash_generated_method = "48DDF761C85681F4B23DD77CA433C453")
    @SuppressWarnings("unchecked")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1200717379 = null; //Variable for return #1
        try 
        {
            LinkedList<E> l;
            l = (LinkedList<E>) super.clone();
            l.size = 0;
            l.voidLink = new Link<E>(null, null, null);
            l.voidLink.previous = l.voidLink;
            l.voidLink.next = l.voidLink;
            l.addAll(this);
            varB4EAC82CA7396A68D541C85D26508E83_1200717379 = l;
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1200717379.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1200717379;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.361 -0400", hash_original_method = "56D0217BC0A5D945F9BCFA2A5AF2C1AD", hash_generated_method = "551A6BE3C5DA353E5564B20822934ADC")
    @Override
    public boolean contains(Object object) {
        Link<E> link;
        link = voidLink.next;
        {
            {
                {
                    boolean var68AE80027D20B2F4904BFC3ADBBA50B7_1148599933 = (object.equals(link.data));
                } //End collapsed parenthetic
                link = link.next;
            } //End block
        } //End block
        {
            {
                link = link.next;
            } //End block
        } //End block
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1308382053 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1308382053;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.362 -0400", hash_original_method = "699CDCD94CA0F8A673D2432C1A4A1CA6", hash_generated_method = "04834FF99FAEA2E29CD7F2C46997A0AC")
    @Override
    public E get(int location) {
        E varB4EAC82CA7396A68D541C85D26508E83_468804647 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_468804647 = link.data;
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        addTaint(location);
        varB4EAC82CA7396A68D541C85D26508E83_468804647.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_468804647;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.374 -0400", hash_original_method = "0073A2AD94DC363435B793B69AD53800", hash_generated_method = "44A9893B08C191CF13856BFC9CDE07ED")
    public E getFirst() {
        E varB4EAC82CA7396A68D541C85D26508E83_1071722126 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1071722126 = getFirstImpl();
        varB4EAC82CA7396A68D541C85D26508E83_1071722126.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1071722126;
        // ---------- Original Method ----------
        //return getFirstImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.376 -0400", hash_original_method = "F326A7609FEC22B872586B521BF21968", hash_generated_method = "91DADA3E8B4D8105F06EB89B05929F4A")
    private E getFirstImpl() {
        E varB4EAC82CA7396A68D541C85D26508E83_1252548394 = null; //Variable for return #1
        Link<E> first;
        first = voidLink.next;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1252548394 = first.data;
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_1252548394.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1252548394;
        // ---------- Original Method ----------
        //Link<E> first = voidLink.next;
        //if (first != voidLink) {
            //return first.data;
        //}
        //throw new NoSuchElementException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.376 -0400", hash_original_method = "D36A1824B4AA11A93F9167DC96C3E776", hash_generated_method = "534E77A71917BD9062F1E780057954D2")
    public E getLast() {
        E varB4EAC82CA7396A68D541C85D26508E83_472926355 = null; //Variable for return #1
        Link<E> last;
        last = voidLink.previous;
        {
            varB4EAC82CA7396A68D541C85D26508E83_472926355 = last.data;
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_472926355.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_472926355;
        // ---------- Original Method ----------
        //Link<E> last = voidLink.previous;
        //if (last != voidLink) {
            //return last.data;
        //}
        //throw new NoSuchElementException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.377 -0400", hash_original_method = "223AFBB612F259C1ECF52502B2C38D06", hash_generated_method = "7A0D8A7064DE6C5B01A9192872490A6F")
    @Override
    public int indexOf(Object object) {
        int pos;
        pos = 0;
        Link<E> link;
        link = voidLink.next;
        {
            {
                {
                    boolean var68AE80027D20B2F4904BFC3ADBBA50B7_1619413347 = (object.equals(link.data));
                } //End collapsed parenthetic
                link = link.next;
            } //End block
        } //End block
        {
            {
                link = link.next;
            } //End block
        } //End block
        addTaint(object.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_670931057 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_670931057;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.378 -0400", hash_original_method = "C5BD92F697D9C0CCDCACCA1E644478EA", hash_generated_method = "52269D875769E978839795210821DD16")
    @Override
    public int lastIndexOf(Object object) {
        int pos;
        pos = size;
        Link<E> link;
        link = voidLink.previous;
        {
            {
                {
                    boolean var68AE80027D20B2F4904BFC3ADBBA50B7_1991150545 = (object.equals(link.data));
                } //End collapsed parenthetic
                link = link.previous;
            } //End block
        } //End block
        {
            {
                link = link.previous;
            } //End block
        } //End block
        addTaint(object.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_835939251 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_835939251;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.389 -0400", hash_original_method = "3507AEFB380BBD7C7A81BC76F9B74E53", hash_generated_method = "AF013DC077D814AB2FBF082D6ED8B197")
    @Override
    public ListIterator<E> listIterator(int location) {
        ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_1790822866 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1790822866 = new LinkIterator<E>(this, location);
        addTaint(location);
        varB4EAC82CA7396A68D541C85D26508E83_1790822866.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1790822866;
        // ---------- Original Method ----------
        //return new LinkIterator<E>(this, location);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.390 -0400", hash_original_method = "9DEB2DAC83546A51EF3DAC82C2B24429", hash_generated_method = "EFE4B6D51ECD1B8C9672A4ECFDB68B00")
    @Override
    public E remove(int location) {
        E varB4EAC82CA7396A68D541C85D26508E83_1086311127 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_1086311127 = link.data;
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        addTaint(location);
        varB4EAC82CA7396A68D541C85D26508E83_1086311127.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1086311127;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.397 -0400", hash_original_method = "E895D44AE5728A8CB5D4093F924DE858", hash_generated_method = "9D660AF9DD05B0E39680A886ADB942FE")
    @Override
    public boolean remove(Object object) {
        boolean varD9AA6A5988D1CD4CF0EC501538EC1CB9_614855411 = (removeFirstOccurrenceImpl(object));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_857956740 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_857956740;
        // ---------- Original Method ----------
        //return removeFirstOccurrenceImpl(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.398 -0400", hash_original_method = "DEF022B3B9EBAD20A11E8D94E53A2C41", hash_generated_method = "D0FB1733E28EB71ADDFF727669D95881")
    public E removeFirst() {
        E varB4EAC82CA7396A68D541C85D26508E83_789368667 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_789368667 = removeFirstImpl();
        varB4EAC82CA7396A68D541C85D26508E83_789368667.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_789368667;
        // ---------- Original Method ----------
        //return removeFirstImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.398 -0400", hash_original_method = "427E50F3C77738614041495F63E4380E", hash_generated_method = "1D6099952542F80EBB88A30A8A53CB98")
    private E removeFirstImpl() {
        E varB4EAC82CA7396A68D541C85D26508E83_289969700 = null; //Variable for return #1
        Link<E> first;
        first = voidLink.next;
        {
            Link<E> next;
            next = first.next;
            voidLink.next = next;
            next.previous = voidLink;
            varB4EAC82CA7396A68D541C85D26508E83_289969700 = first.data;
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_289969700.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_289969700;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.399 -0400", hash_original_method = "78A299256A25A92F54699488F92E9106", hash_generated_method = "F69708F60544AAD4A75F90FAAF9A9C67")
    public E removeLast() {
        E varB4EAC82CA7396A68D541C85D26508E83_2014200088 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2014200088 = removeLastImpl();
        varB4EAC82CA7396A68D541C85D26508E83_2014200088.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2014200088;
        // ---------- Original Method ----------
        //return removeLastImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.399 -0400", hash_original_method = "4FEFCE90045B22FA30A5F2F8A3DA8ABA", hash_generated_method = "BF14E2A21A6B43FBA73A59CF8BE1E8E1")
    private E removeLastImpl() {
        E varB4EAC82CA7396A68D541C85D26508E83_107166272 = null; //Variable for return #1
        Link<E> last;
        last = voidLink.previous;
        {
            Link<E> previous;
            previous = last.previous;
            voidLink.previous = previous;
            previous.next = voidLink;
            varB4EAC82CA7396A68D541C85D26508E83_107166272 = last.data;
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_107166272.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_107166272;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.418 -0400", hash_original_method = "B739DCE0B4C0EF3D97CD82250338592B", hash_generated_method = "F805663A19413253F159AB3D8FF19376")
    public Iterator<E> descendingIterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_1110029050 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1110029050 = new ReverseLinkIterator<E>(this);
        varB4EAC82CA7396A68D541C85D26508E83_1110029050.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1110029050;
        // ---------- Original Method ----------
        //return new ReverseLinkIterator<E>(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.418 -0400", hash_original_method = "EDFB7FC0634DB7C00BD3AB035EBD094A", hash_generated_method = "378EB10A077D29E04D65AEBA54670E25")
    public boolean offerFirst(E e) {
        boolean var76B72DE79F3E513315008517C001461F_2047415441 = (addFirstImpl(e));
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1379227892 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1379227892;
        // ---------- Original Method ----------
        //return addFirstImpl(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.418 -0400", hash_original_method = "89DCF7809C68E43568923DE3D2E1D02D", hash_generated_method = "4B5ACCE213EE39E5E600333F336D9CBD")
    public boolean offerLast(E e) {
        boolean var5D8D8C0594128842346FC018CF7B2C46_981662058 = (addLastImpl(e));
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_555963669 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_555963669;
        // ---------- Original Method ----------
        //return addLastImpl(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.419 -0400", hash_original_method = "969AA46310549C7B2FEE1AAA28767998", hash_generated_method = "877E53D21B78A9C4ADC4CE982349775A")
    public E peekFirst() {
        E varB4EAC82CA7396A68D541C85D26508E83_992484084 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_992484084 = peekFirstImpl();
        varB4EAC82CA7396A68D541C85D26508E83_992484084.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_992484084;
        // ---------- Original Method ----------
        //return peekFirstImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.419 -0400", hash_original_method = "E1ADBCAD0BAE3B6D44E0B3EBBD31EB6D", hash_generated_method = "492885CADE2B9CED8C44806D88445595")
    public E peekLast() {
        E varB4EAC82CA7396A68D541C85D26508E83_1850184760 = null; //Variable for return #1
        Link<E> last;
        last = voidLink.previous;
        varB4EAC82CA7396A68D541C85D26508E83_1850184760 = (last == voidLink) ? null : last.data;
        varB4EAC82CA7396A68D541C85D26508E83_1850184760.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1850184760;
        // ---------- Original Method ----------
        //Link<E> last = voidLink.previous;
        //return (last == voidLink) ? null : last.data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.420 -0400", hash_original_method = "E15F23512F244F97C3914B4E0B9502A4", hash_generated_method = "6E008F1250CD6E60038DB917384E2771")
    public E pollFirst() {
        E varB4EAC82CA7396A68D541C85D26508E83_1550123670 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1550123670 = (size == 0) ? null : removeFirstImpl();
        varB4EAC82CA7396A68D541C85D26508E83_1550123670.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1550123670;
        // ---------- Original Method ----------
        //return (size == 0) ? null : removeFirstImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.421 -0400", hash_original_method = "70D8873C9DDF66392CA17B903A435D10", hash_generated_method = "CDAF0643B68AFF8E9ED68BF964115637")
    public E pollLast() {
        E varB4EAC82CA7396A68D541C85D26508E83_1387063197 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1387063197 = (size == 0) ? null : removeLastImpl();
        varB4EAC82CA7396A68D541C85D26508E83_1387063197.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1387063197;
        // ---------- Original Method ----------
        //return (size == 0) ? null : removeLastImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.431 -0400", hash_original_method = "A1E9A1EB062A81F6CBAFDDDD06F9F273", hash_generated_method = "A9B89186312AD34E1E1762C36DB134C9")
    public E pop() {
        E varB4EAC82CA7396A68D541C85D26508E83_1119668873 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1119668873 = removeFirstImpl();
        varB4EAC82CA7396A68D541C85D26508E83_1119668873.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1119668873;
        // ---------- Original Method ----------
        //return removeFirstImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.431 -0400", hash_original_method = "9D0F4BD741629A4E20781C5DA21CB652", hash_generated_method = "85C4F27701BBA7205966B41B91B341D2")
    public void push(E e) {
        addFirstImpl(e);
        addTaint(e.getTaint());
        // ---------- Original Method ----------
        //addFirstImpl(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.431 -0400", hash_original_method = "87160631C9EB1EFA1DB767740655C072", hash_generated_method = "F9524BCDC610754F462D921A679730B2")
    public boolean removeFirstOccurrence(Object o) {
        boolean var3B40CEECB1B8A1766358BB718B996E93_41825437 = (removeFirstOccurrenceImpl(o));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1878825933 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1878825933;
        // ---------- Original Method ----------
        //return removeFirstOccurrenceImpl(o);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.432 -0400", hash_original_method = "1733EDDF12DE29E16D5005CF30B5972D", hash_generated_method = "42275BC8666066532AAAC404BF687232")
    public boolean removeLastOccurrence(Object o) {
        Iterator<E> iter;
        iter = new ReverseLinkIterator<E>(this);
        boolean var818715EE81985F60936C283DBC275E04_1792123171 = (removeOneOccurrence(o, iter));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1043077313 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1043077313;
        // ---------- Original Method ----------
        //Iterator<E> iter = new ReverseLinkIterator<E>(this);
        //return removeOneOccurrence(o, iter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.432 -0400", hash_original_method = "BE1ED77C9E5B42F2AAE1F87EC7415C20", hash_generated_method = "92C05CE6D66E525192DA966D8378C8A9")
    private boolean removeFirstOccurrenceImpl(Object o) {
        Iterator<E> iter;
        iter = new LinkIterator<E>(this, 0);
        boolean var818715EE81985F60936C283DBC275E04_825985176 = (removeOneOccurrence(o, iter));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2039158963 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2039158963;
        // ---------- Original Method ----------
        //Iterator<E> iter = new LinkIterator<E>(this, 0);
        //return removeOneOccurrence(o, iter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.432 -0400", hash_original_method = "0DC759074C3911B534EFB2ED69CB80D3", hash_generated_method = "CFC6BAA4CC6DCFB43B8220701145C383")
    private boolean removeOneOccurrence(Object o, Iterator<E> iter) {
        {
            boolean varADABAFEBBAB7E585DD903333BD7F20A8_1634512248 = (iter.hasNext());
            {
                E element;
                element = iter.next();
                {
                    {
                        boolean varF1A27543F856253D406E948E1C7D5139_587045638 = (o.equals(element));
                    } //End flattened ternary
                    {
                        iter.remove();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(o.getTaint());
        addTaint(iter.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_907435414 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_907435414;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.433 -0400", hash_original_method = "B473D145452E376F792E71796F81B4CE", hash_generated_method = "B1D582F76A59C26B37A43BB83D79209F")
    @Override
    public E set(int location, E object) {
        E varB4EAC82CA7396A68D541C85D26508E83_745566746 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_745566746 = result;
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        addTaint(location);
        addTaint(object.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_745566746.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_745566746;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.434 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "A2335A722A8BAB4FC02F5865D32909F5")
    @Override
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1155785834 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1155785834;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.434 -0400", hash_original_method = "E7666F96333DE978F541663657705932", hash_generated_method = "FAE7FCCCFB2E8DFEBF1824A322A1711A")
    public boolean offer(E o) {
        boolean var0DC980F474C0D58B2EC0CD83E9314E01_463218030 = (addLastImpl(o));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_264012781 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_264012781;
        // ---------- Original Method ----------
        //return addLastImpl(o);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.445 -0400", hash_original_method = "55052725C8F8219BC4435ABBF88EDF4F", hash_generated_method = "3A491D37575EE444358077BAD8B9D7D7")
    public E poll() {
        E varB4EAC82CA7396A68D541C85D26508E83_619086301 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_619086301 = size == 0 ? null : removeFirst();
        varB4EAC82CA7396A68D541C85D26508E83_619086301.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_619086301;
        // ---------- Original Method ----------
        //return size == 0 ? null : removeFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.446 -0400", hash_original_method = "E6C80B22C4B6B543BB93E41D88CAD5EF", hash_generated_method = "21DA00E5E7F11E171FF203026436497F")
    public E remove() {
        E varB4EAC82CA7396A68D541C85D26508E83_2047178410 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2047178410 = removeFirstImpl();
        varB4EAC82CA7396A68D541C85D26508E83_2047178410.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2047178410;
        // ---------- Original Method ----------
        //return removeFirstImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.446 -0400", hash_original_method = "4AAADA00C0F9172450031345A8B9DEF3", hash_generated_method = "9309394CC9B11674FF214599FA104A55")
    public E peek() {
        E varB4EAC82CA7396A68D541C85D26508E83_1389787820 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1389787820 = peekFirstImpl();
        varB4EAC82CA7396A68D541C85D26508E83_1389787820.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1389787820;
        // ---------- Original Method ----------
        //return peekFirstImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.447 -0400", hash_original_method = "C3985024BAE3B14A3C96F9F04D080FD8", hash_generated_method = "4695D1771F31386879E306E0441FD096")
    private E peekFirstImpl() {
        E varB4EAC82CA7396A68D541C85D26508E83_1804780970 = null; //Variable for return #1
        Link<E> first;
        first = voidLink.next;
        varB4EAC82CA7396A68D541C85D26508E83_1804780970 = first == voidLink ? null : first.data;
        varB4EAC82CA7396A68D541C85D26508E83_1804780970.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1804780970;
        // ---------- Original Method ----------
        //Link<E> first = voidLink.next;
        //return first == voidLink ? null : first.data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.447 -0400", hash_original_method = "AFC93F64F463BC2AB0989756248E17C1", hash_generated_method = "62DFE2C39AC88CB51E8CD405945748B7")
    public E element() {
        E varB4EAC82CA7396A68D541C85D26508E83_1253752650 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1253752650 = getFirstImpl();
        varB4EAC82CA7396A68D541C85D26508E83_1253752650.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1253752650;
        // ---------- Original Method ----------
        //return getFirstImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.448 -0400", hash_original_method = "4C8EA5672445A0C074E2691E7533B645", hash_generated_method = "7176E172661A8F0D1BF65B21455DA81B")
    @Override
    public Object[] toArray() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_1492949936 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1492949936 = contents;
        varB4EAC82CA7396A68D541C85D26508E83_1492949936.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1492949936;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.457 -0400", hash_original_method = "C06C36ADE827F4BEDBCDBBA1F17737D9", hash_generated_method = "859DDB21887D0304B37AD501F06228C2")
    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] contents) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_2068425557 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_2068425557 = contents;
        addTaint(contents[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2068425557.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2068425557;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.457 -0400", hash_original_method = "6BB9A441F12D3E8CACB448F2BFF70164", hash_generated_method = "83C695C5E9785E6C1B8F75BF8EA2770F")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(size);
        Iterator<E> it;
        it = iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_431132211 = (it.hasNext());
            {
                stream.writeObject(it.next());
            } //End block
        } //End collapsed parenthetic
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        //stream.defaultWriteObject();
        //stream.writeInt(size);
        //Iterator<E> it = iterator();
        //while (it.hasNext()) {
            //stream.writeObject(it.next());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.473 -0400", hash_original_method = "7A7BB5A4D858D82384B74EA358B45BD7", hash_generated_method = "5D3278A4EBC7BB6C72F7A7D2B83506BA")
    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.473 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "B3480F581DDA17D478907EC9EE768C50")

        ET data;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.473 -0400", hash_original_field = "2327346E833EFCD6B2E7B3F0A4DF8EBB", hash_generated_field = "45A046E5D1D7F8BD1511ED0837170D9B")

        Link<ET> previous;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.473 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "99500FE4EDB0AA48BDE52F63DB34B10F")

        Link<ET> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.474 -0400", hash_original_method = "92868F30800B380F1BA136D9DCEB0C81", hash_generated_method = "FF7F178B4230792375EA8BB041BC2BA6")
          Link(ET o, Link<ET> p, Link<ET> n) {
            data = o;
            previous = p;
            next = n;
            // ---------- Original Method ----------
            //data = o;
            //previous = p;
            //next = n;
        }

        
    }


    
    private static final class LinkIterator<ET> implements ListIterator<ET> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.474 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "5780BC7BCF265A6425A5A90F1AD9B24E")

        int pos;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.474 -0400", hash_original_field = "295CC8887E8B8B43596FF881B307867C", hash_generated_field = "92DA548A98D3BA977C330B914F0C29E7")

        int expectedModCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.474 -0400", hash_original_field = "10AE9FC7D453B0DD525D0EDF2EDE7961", hash_generated_field = "52794B45189EFF95B13E35D799B9BD43")

        LinkedList<ET> list;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.474 -0400", hash_original_field = "2A304A1348456CCD2234CD71A81BD338", hash_generated_field = "F851AA6845CD2B23EE54FB486DA1D214")

        Link<ET> link;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.474 -0400", hash_original_field = "1A533DA437F86DDD82B433DEC7C72599", hash_generated_field = "ACB4020CEB7749245E32063C8F282FD3")

        Link<ET> lastLink;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.474 -0400", hash_original_method = "53053DBD9EBACCD4110D93002A695266", hash_generated_method = "C41DC6DC40DF0B75D11AFBC0C90814C7")
          LinkIterator(LinkedList<ET> object, int location) {
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
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
            addTaint(location);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.475 -0400", hash_original_method = "A220301E4EE3196C2657CD6F6C345E76", hash_generated_method = "9105E8C414BE39A96D3737E7C51B61A5")
        public void add(ET object) {
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
            addTaint(object.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.475 -0400", hash_original_method = "D12271F7604D5FEC65FB34942C4AE52F", hash_generated_method = "813D591E9F3FDCDB0E9CB7B810A15BD6")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_470106851 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_470106851;
            // ---------- Original Method ----------
            //return link.next != list.voidLink;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.483 -0400", hash_original_method = "D62F69678251E4F27FB63666837CF4D1", hash_generated_method = "2242563AA33922C33A2F917E022A4A24")
        public boolean hasPrevious() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_555595341 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_555595341;
            // ---------- Original Method ----------
            //return link != list.voidLink;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.484 -0400", hash_original_method = "DAF205186410308F2C7B687C3EB1A5B6", hash_generated_method = "42C3860B656B7EC067F9457DCCD76041")
        public ET next() {
            ET varB4EAC82CA7396A68D541C85D26508E83_446669314 = null; //Variable for return #1
            {
                LinkedList.Link<ET> next;
                next = link.next;
                {
                    lastLink = link = next;
                    varB4EAC82CA7396A68D541C85D26508E83_446669314 = link.data;
                } //End block
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            varB4EAC82CA7396A68D541C85D26508E83_446669314.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_446669314;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.484 -0400", hash_original_method = "1B59C01DCB2067B0BBD0025D75B60071", hash_generated_method = "78C59BD638DEF4CB58BF0476A55F45D6")
        public int nextIndex() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1895526260 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1895526260;
            // ---------- Original Method ----------
            //return pos + 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.484 -0400", hash_original_method = "C56DBD8071305313D7DDB1E67B6D94B0", hash_generated_method = "A67AB27DD63896F546A2DD4D41E57D1E")
        public ET previous() {
            ET varB4EAC82CA7396A68D541C85D26508E83_616513415 = null; //Variable for return #1
            {
                {
                    lastLink = link;
                    link = link.previous;
                    varB4EAC82CA7396A68D541C85D26508E83_616513415 = lastLink.data;
                } //End block
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            varB4EAC82CA7396A68D541C85D26508E83_616513415.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_616513415;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.485 -0400", hash_original_method = "DC75AA0325D63F3F64774210ED43B204", hash_generated_method = "43C0F9BF8F075B17A0BA45890ABCBE86")
        public int previousIndex() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_691495784 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_691495784;
            // ---------- Original Method ----------
            //return pos;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.485 -0400", hash_original_method = "454EC742FAC97A85450236EC802A7816", hash_generated_method = "D825FA27847C1F4F9C771E090D94074F")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.486 -0400", hash_original_method = "8A5D5DD2AB039971BB00FDD7ADDD55B1", hash_generated_method = "B9649A1C9A6D6D4E3E8E9153286971D0")
        public void set(ET object) {
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.487 -0400", hash_original_field = "295CC8887E8B8B43596FF881B307867C", hash_generated_field = "9C353E755EC3A4E9B0CFE1EA9EEC47A8")

        private int expectedModCount;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.487 -0400", hash_original_field = "10AE9FC7D453B0DD525D0EDF2EDE7961", hash_generated_field = "D1EC04877DB93B65C0C16B144052AC71")

        private LinkedList<ET> list;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.487 -0400", hash_original_field = "2A304A1348456CCD2234CD71A81BD338", hash_generated_field = "C029ECB4203CCD8751E5C756F40C32AD")

        private Link<ET> link;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.487 -0400", hash_original_field = "7385E778E1358730CFB4F236AF9FF24A", hash_generated_field = "C01834E3EF87C859E7B00C0837E2E4D3")

        private boolean canRemove;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.487 -0400", hash_original_method = "2C54C06EA8F2B61501161B2BC13D7FF2", hash_generated_method = "98C036A6F3260A1B3893C647A1DF0F6C")
          ReverseLinkIterator(LinkedList<ET> linkedList) {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.487 -0400", hash_original_method = "683C5349A490B93F6F23CFDE8DA49A7E", hash_generated_method = "4F98C8CA9BEB8D901DCED6935B23A585")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_654199131 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_654199131;
            // ---------- Original Method ----------
            //return link.previous != list.voidLink;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.488 -0400", hash_original_method = "B57C4B4DEBE6A9EB91858512EE525B72", hash_generated_method = "E2B454627B301DCEFB100CF2D6007704")
        public ET next() {
            ET varB4EAC82CA7396A68D541C85D26508E83_1333447351 = null; //Variable for return #1
            {
                {
                    boolean var384B0C75E2EB52B4939B27A6F15C2DC1_1479617604 = (hasNext());
                    {
                        link = link.previous;
                        canRemove = true;
                        varB4EAC82CA7396A68D541C85D26508E83_1333447351 = link.data;
                    } //End block
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            varB4EAC82CA7396A68D541C85D26508E83_1333447351.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1333447351;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.513 -0400", hash_original_method = "07412F520F702F11B7EB1920D3A5A17D", hash_generated_method = "0418FFF55C95EB8133C6225BC4641971")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.514 -0400", hash_original_field = "A91BB42ABDC7657C70EC735A482E86B5", hash_generated_field = "0429AD1C5E84D950842944B527B7B29E")

    private static long serialVersionUID = 876323262645176354L;
}

