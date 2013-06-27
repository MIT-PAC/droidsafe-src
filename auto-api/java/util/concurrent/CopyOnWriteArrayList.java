package java.util.concurrent;

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
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import libcore.util.EmptyArray;
import libcore.util.Objects;

public class CopyOnWriteArrayList<E> implements List<E>, RandomAccess, Cloneable, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.927 -0400", hash_original_field = "6A7F245843454CF4F28AD7C5E2572AA2", hash_generated_field = "9773C6104DBFF8AC92488F3C4AD39164")

    private transient volatile Object[] elements;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.927 -0400", hash_original_method = "E357703A48348C8EEE9667190E563C6C", hash_generated_method = "B97966364BBED793B94DBEEDDFBF1B8C")
    public  CopyOnWriteArrayList() {
        elements = EmptyArray.OBJECT;
        // ---------- Original Method ----------
        //elements = EmptyArray.OBJECT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.927 -0400", hash_original_method = "84AACC1E4283EC6F676E4F2CD339FC5B", hash_generated_method = "EA0C15CE1422D9A7119B138FB9DFD0F8")
    @SuppressWarnings("unchecked")
    public  CopyOnWriteArrayList(Collection<? extends E> collection) {
        this((E[]) collection.toArray());
        addTaint(collection.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.928 -0400", hash_original_method = "51C6AA63C04D903DC2F19EE7270C9A87", hash_generated_method = "5F0DE0F3745CDDE56CD0A00206594245")
    public  CopyOnWriteArrayList(E[] array) {
        this.elements = Arrays.copyOf(array, array.length, Object[].class);
        // ---------- Original Method ----------
        //this.elements = Arrays.copyOf(array, array.length, Object[].class);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.928 -0400", hash_original_method = "FF2ED4DF1B70DABD1A45F755E1952592", hash_generated_method = "C637499F908F1E879FF77F11C87B9F02")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_449839569 = null; //Variable for return #1
        try 
        {
            CopyOnWriteArrayList result;
            result = (CopyOnWriteArrayList) super.clone();
            result.elements = result.elements.clone();
            varB4EAC82CA7396A68D541C85D26508E83_449839569 = result;
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_449839569.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_449839569;
        // ---------- Original Method ----------
        //try {
            //CopyOnWriteArrayList result = (CopyOnWriteArrayList) super.clone();
            //result.elements = result.elements.clone();
            //return result;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.044 -0400", hash_original_method = "68DC52534F60D1A5138253A79B12E67C", hash_generated_method = "F76E76AEA6FA024C6D634FE2E4C93FB7")
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1058952344 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1058952344;
        // ---------- Original Method ----------
        //return elements.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.045 -0400", hash_original_method = "07C72EA93D8BC7AB1EE5326762E05E69", hash_generated_method = "1D7B415297DE537BD3DD560D40220D18")
    @SuppressWarnings("unchecked")
    public E get(int index) {
        E varB4EAC82CA7396A68D541C85D26508E83_857801265 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_857801265 = (E) elements[index];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_857801265.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_857801265;
        // ---------- Original Method ----------
        //return (E) elements[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.045 -0400", hash_original_method = "1274BF0858E749C3D9852E86C4A99C22", hash_generated_method = "7FE1A0AD4016CAFB9B9B301FCB45B852")
    public boolean contains(Object o) {
        boolean var2580C065AD3F25FA806E0EC1F5491D61_1088447532 = (indexOf(o) != -1);
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1272754583 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1272754583;
        // ---------- Original Method ----------
        //return indexOf(o) != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.045 -0400", hash_original_method = "F181183DABCA5209C115C87B0BC63071", hash_generated_method = "02C1B18F4E72F4F05067AB443C80C0AA")
    public boolean containsAll(Collection<?> collection) {
        Object[] snapshot;
        snapshot = elements;
        boolean varB51CD127B94D30044743FDBEC427798E_1773068411 = (containsAll(collection, snapshot, 0, snapshot.length));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_250650215 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_250650215;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return containsAll(collection, snapshot, 0, snapshot.length);
    }

    
        static boolean containsAll(Collection<?> collection, Object[] snapshot, int from, int to) {
        for (Object o : collection) {
            if (indexOf(o, snapshot, from, to) == -1) {
                return false;
            }
        }
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.046 -0400", hash_original_method = "8F838DDE7B5E08714D6360ECE6328BF5", hash_generated_method = "0D54994DF35A30A24EED01F89CF10836")
    public int indexOf(E object, int from) {
        Object[] snapshot;
        snapshot = elements;
        int var3F4FFEA1DA0968D7F475C5A4D1C4F62D_2028051787 = (indexOf(object, snapshot, from, snapshot.length));
        addTaint(object.getTaint());
        addTaint(from);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1377255292 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1377255292;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return indexOf(object, snapshot, from, snapshot.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.046 -0400", hash_original_method = "3333011450759BE4404CA7231EDCF09F", hash_generated_method = "04D2F7DABC0A11C11E5C90859E82EDFD")
    public int indexOf(Object object) {
        Object[] snapshot;
        snapshot = elements;
        int varF95830349FA4633C99755E2E13FD61DA_2010964220 = (indexOf(object, snapshot, 0, snapshot.length));
        addTaint(object.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_480005969 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_480005969;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return indexOf(object, snapshot, 0, snapshot.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.046 -0400", hash_original_method = "19C8A04DC3A46E49A84DF6B57E1917A9", hash_generated_method = "28BFDF27321D62482C8E60CC975784E8")
    public int lastIndexOf(E object, int to) {
        Object[] snapshot;
        snapshot = elements;
        int var044750AB099D388AF4C1D65CC717289C_1407204117 = (lastIndexOf(object, snapshot, 0, to));
        addTaint(object.getTaint());
        addTaint(to);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_991743095 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_991743095;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return lastIndexOf(object, snapshot, 0, to);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.065 -0400", hash_original_method = "D45902A72D19AFDC170F4A4D129ABA97", hash_generated_method = "ADA1357BDD8258A00B8575E7B55026EA")
    public int lastIndexOf(Object object) {
        Object[] snapshot;
        snapshot = elements;
        int var363578769FBDCE20799A418E17F6DBCF_597500053 = (lastIndexOf(object, snapshot, 0, snapshot.length));
        addTaint(object.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_258860772 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_258860772;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return lastIndexOf(object, snapshot, 0, snapshot.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.065 -0400", hash_original_method = "E13DA7C33D486C9539B3B38ADEEDBA9D", hash_generated_method = "2863A6F26203CC064971B9A994B7825D")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1834264176 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1834264176;
        // ---------- Original Method ----------
        //return elements.length == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.066 -0400", hash_original_method = "8AC2A236339BBBFB218E3FC5088D17DA", hash_generated_method = "99E039D18CB825B1921F9FC911AB3932")
    public Iterator<E> iterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_161984718 = null; //Variable for return #1
        Object[] snapshot;
        snapshot = elements;
        varB4EAC82CA7396A68D541C85D26508E83_161984718 = new CowIterator<E>(snapshot, 0, snapshot.length);
        varB4EAC82CA7396A68D541C85D26508E83_161984718.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_161984718;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return new CowIterator<E>(snapshot, 0, snapshot.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.066 -0400", hash_original_method = "6CF42CA16C3188E71052A9A04B3E4D16", hash_generated_method = "D0F25DFA8319D7B36BC7774A81C8BF28")
    public ListIterator<E> listIterator(int index) {
        ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_1755961902 = null; //Variable for return #1
        Object[] snapshot;
        snapshot = elements;
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("index=" + index + ", length=" + snapshot.length);
        } //End block
        CowIterator<E> result;
        result = new CowIterator<E>(snapshot, 0, snapshot.length);
        result.index = index;
        varB4EAC82CA7396A68D541C85D26508E83_1755961902 = result;
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1755961902.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1755961902;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //if (index < 0 || index > snapshot.length) {
            //throw new IndexOutOfBoundsException("index=" + index + ", length=" + snapshot.length);
        //}
        //CowIterator<E> result = new CowIterator<E>(snapshot, 0, snapshot.length);
        //result.index = index;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.067 -0400", hash_original_method = "A4A3425D1D4C041DAFB5C093D1247DF1", hash_generated_method = "65E256FE45D1949CB11493B77E3D121B")
    public ListIterator<E> listIterator() {
        ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_1610744672 = null; //Variable for return #1
        Object[] snapshot;
        snapshot = elements;
        varB4EAC82CA7396A68D541C85D26508E83_1610744672 = new CowIterator<E>(snapshot, 0, snapshot.length);
        varB4EAC82CA7396A68D541C85D26508E83_1610744672.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1610744672;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return new CowIterator<E>(snapshot, 0, snapshot.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.089 -0400", hash_original_method = "594A2D8CB57DB4B1D13107F70D453706", hash_generated_method = "2911AECBCDE95F19E8D40F2D5116B159")
    public List<E> subList(int from, int to) {
        List<E> varB4EAC82CA7396A68D541C85D26508E83_1818387927 = null; //Variable for return #1
        Object[] snapshot;
        snapshot = elements;
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("from=" + from + ", to=" + to +
                    ", list size=" + snapshot.length);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1818387927 = new CowSubList(snapshot, from, to);
        addTaint(from);
        addTaint(to);
        varB4EAC82CA7396A68D541C85D26508E83_1818387927.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1818387927;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //if (from < 0 || from > to || to > snapshot.length) {
            //throw new IndexOutOfBoundsException("from=" + from + ", to=" + to +
                    //", list size=" + snapshot.length);
        //}
        //return new CowSubList(snapshot, from, to);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.090 -0400", hash_original_method = "49659221AAE3F1C0ECCE830D1E5CE8D1", hash_generated_method = "A12077F5AFEA027FADBE87A08AC55784")
    public Object[] toArray() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_1032160739 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1032160739 = elements.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1032160739.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1032160739;
        // ---------- Original Method ----------
        //return elements.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.090 -0400", hash_original_method = "C1E48E79962F836E76F520B2DEE3FDB8", hash_generated_method = "D28ABC9B32D84972820017C51D7E454C")
    @SuppressWarnings({"unchecked","SuspiciousSystemArraycopy"})
    public <T> T[] toArray(T[] contents) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_864618673 = null; //Variable for return #1
        T[] varB4EAC82CA7396A68D541C85D26508E83_367616417 = null; //Variable for return #2
        Object[] snapshot;
        snapshot = elements;
        {
            varB4EAC82CA7396A68D541C85D26508E83_864618673 = (T[]) Arrays.copyOf(snapshot, snapshot.length, contents.getClass());
        } //End block
        System.arraycopy(snapshot, 0, contents, 0, snapshot.length);
        {
            contents[snapshot.length] = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_367616417 = contents;
        addTaint(contents[0].getTaint());
        T[] varA7E53CE21691AB073D9660D615818899_1270467539; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1270467539 = varB4EAC82CA7396A68D541C85D26508E83_864618673;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1270467539 = varB4EAC82CA7396A68D541C85D26508E83_367616417;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1270467539.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1270467539;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //if (snapshot.length > contents.length) {
            //return (T[]) Arrays.copyOf(snapshot, snapshot.length, contents.getClass());
        //}
        //System.arraycopy(snapshot, 0, contents, 0, snapshot.length);
        //if (snapshot.length < contents.length) {
            //contents[snapshot.length] = null;
        //}
        //return contents;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.212 -0400", hash_original_method = "6010CBD888F6152118D77E36B5616E02", hash_generated_method = "DB19EEFFDABC8A7D2A90E7830145C0E8")
    @Override
    public boolean equals(Object other) {
        {
            boolean var8E510C77A3CC00EDD5D5105BB9594676_1526104654 = (this == other
                    || Arrays.equals(elements, ((CopyOnWriteArrayList<?>) other).elements));
        } //End block
        {
            Object[] snapshot;
            snapshot = elements;
            Iterator<?> i;
            i = ((List<?>) other).iterator();
            {
                Iterator<Object> var112728ACB95922B20839C47454ECB6A5_1752753190 = (snapshot).iterator();
                var112728ACB95922B20839C47454ECB6A5_1752753190.hasNext();
                Object o = var112728ACB95922B20839C47454ECB6A5_1752753190.next();
                {
                    {
                        boolean var6D2C6F2C90F31B26BD0BC8B4289F0FA4_1518125722 = (!i.hasNext() || !Objects.equal(o, i.next()));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            boolean varCC7204A921FEC5763B81E50426A88D00_18410699 = (!i.hasNext());
        } //End block
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_209217422 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_209217422;
        // ---------- Original Method ----------
        //if (other instanceof CopyOnWriteArrayList) {
            //return this == other
                    //|| Arrays.equals(elements, ((CopyOnWriteArrayList<?>) other).elements);
        //} else if (other instanceof List) {
            //Object[] snapshot = elements;
            //Iterator<?> i = ((List<?>) other).iterator();
            //for (Object o : snapshot) {
                //if (!i.hasNext() || !Objects.equal(o, i.next())) {
                    //return false;
                //}
            //}
            //return !i.hasNext();
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.213 -0400", hash_original_method = "5CBAD38024C40A34FCDA1A3FF083FDEC", hash_generated_method = "02327E7E895D60008F4EF13C19263918")
    @Override
    public int hashCode() {
        int varCAF3CD69EA8DECAF9471B49B185EF8B7_1123408756 = (Arrays.hashCode(elements));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1108849115 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1108849115;
        // ---------- Original Method ----------
        //return Arrays.hashCode(elements);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.214 -0400", hash_original_method = "D569C6F4ED8C88274D5F2CC2C9F6FBD2", hash_generated_method = "FF516DE7234CCA404178F326AD9FFB11")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1126203244 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1126203244 = Arrays.toString(elements);
        varB4EAC82CA7396A68D541C85D26508E83_1126203244.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1126203244;
        // ---------- Original Method ----------
        //return Arrays.toString(elements);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.215 -0400", hash_original_method = "4C47893BDB4E93647009AE85D0DD4F0A", hash_generated_method = "B872B418D8374D91CC98B11E00B511DB")
    public synchronized boolean add(E e) {
        Object[] newElements;
        newElements = new Object[elements.length + 1];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        newElements[elements.length] = e;
        elements = newElements;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1205238139 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1205238139;
        // ---------- Original Method ----------
        //Object[] newElements = new Object[elements.length + 1];
        //System.arraycopy(elements, 0, newElements, 0, elements.length);
        //newElements[elements.length] = e;
        //elements = newElements;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.215 -0400", hash_original_method = "9DD013FF12CCDC2B9301BB35B7E69B98", hash_generated_method = "851D85ECA0F05B52D852286F75AE7935")
    public synchronized void add(int index, E e) {
        Object[] newElements;
        newElements = new Object[elements.length + 1];
        System.arraycopy(elements, 0, newElements, 0, index);
        newElements[index] = e;
        System.arraycopy(elements, index, newElements, index + 1, elements.length - index);
        elements = newElements;
        addTaint(index);
        addTaint(e.getTaint());
        // ---------- Original Method ----------
        //Object[] newElements = new Object[elements.length + 1];
        //System.arraycopy(elements, 0, newElements, 0, index);
        //newElements[index] = e;
        //System.arraycopy(elements, index, newElements, index + 1, elements.length - index);
        //elements = newElements;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.235 -0400", hash_original_method = "76766E6A3193E0133903AC8237158932", hash_generated_method = "880B179F263B3491A059FB9FA5E42098")
    public synchronized boolean addAll(Collection<? extends E> collection) {
        boolean var0159BD59FAEB520B52C0A163D95FA273_1445502637 = (addAll(elements.length, collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_795010244 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_795010244;
        // ---------- Original Method ----------
        //return addAll(elements.length, collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.236 -0400", hash_original_method = "16622B391256B6F864845FABB18695E4", hash_generated_method = "1C3A14605332D2AC0F5A3E3173F127A0")
    public synchronized boolean addAll(int index, Collection<? extends E> collection) {
        Object[] toAdd;
        toAdd = collection.toArray();
        Object[] newElements;
        newElements = new Object[elements.length + toAdd.length];
        System.arraycopy(elements, 0, newElements, 0, index);
        System.arraycopy(toAdd, 0, newElements, index, toAdd.length);
        System.arraycopy(elements, index,
                newElements, index + toAdd.length, elements.length - index);
        elements = newElements;
        addTaint(index);
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_442345537 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_442345537;
        // ---------- Original Method ----------
        //Object[] toAdd = collection.toArray();
        //Object[] newElements = new Object[elements.length + toAdd.length];
        //System.arraycopy(elements, 0, newElements, 0, index);
        //System.arraycopy(toAdd, 0, newElements, index, toAdd.length);
        //System.arraycopy(elements, index,
                //newElements, index + toAdd.length, elements.length - index);
        //elements = newElements;
        //return toAdd.length > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.310 -0400", hash_original_method = "F6411BBDC5A81E1C464E9CEEEB8CCCF0", hash_generated_method = "9C0B692171D7663BE7B83A1CB5F3FC27")
    public synchronized int addAllAbsent(Collection<? extends E> collection) {
        Object[] toAdd;
        toAdd = collection.toArray();
        Object[] newElements;
        newElements = new Object[elements.length + toAdd.length];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        int addedCount;
        addedCount = 0;
        {
            Iterator<Object> varEBBC03880E205C3D948072471502DA24_719048706 = (toAdd).iterator();
            varEBBC03880E205C3D948072471502DA24_719048706.hasNext();
            Object o = varEBBC03880E205C3D948072471502DA24_719048706.next();
            {
                {
                    boolean var4BB4DD0650713F3AD6499B5BB3CF0F9C_729801627 = (indexOf(o, newElements, 0, elements.length + addedCount) == -1);
                    {
                        newElements[elements.length + addedCount++] = o;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            newElements = Arrays.copyOfRange(
                    newElements, 0, elements.length + addedCount);
        } //End block
        elements = newElements;
        addTaint(collection.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1960366531 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1960366531;
        // ---------- Original Method ----------
        //Object[] toAdd = collection.toArray();
        //Object[] newElements = new Object[elements.length + toAdd.length];
        //System.arraycopy(elements, 0, newElements, 0, elements.length);
        //int addedCount = 0;
        //for (Object o : toAdd) {
            //if (indexOf(o, newElements, 0, elements.length + addedCount) == -1) {
                //newElements[elements.length + addedCount++] = o;
            //}
        //}
        //if (addedCount < toAdd.length) {
            //newElements = Arrays.copyOfRange(
                    //newElements, 0, elements.length + addedCount); 
        //}
        //elements = newElements;
        //return addedCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.311 -0400", hash_original_method = "17D643777423FC6042E703F36B3EB43F", hash_generated_method = "AD2F7498F7B23A6AAA64BB85E3E66DE0")
    public synchronized boolean addIfAbsent(E object) {
        {
            boolean var9432A920D7B842B924EF8D1C9DF16F5D_1156052681 = (contains(object));
        } //End collapsed parenthetic
        add(object);
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1317123908 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1317123908;
        // ---------- Original Method ----------
        //if (contains(object)) {
            //return false;
        //}
        //add(object);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.311 -0400", hash_original_method = "343DE0C64B38A0F7CE33FC0930F8B1CE", hash_generated_method = "0DD0CCA634A11D0B8559FCC328E0AB07")
    @Override
    public synchronized void clear() {
        elements = EmptyArray.OBJECT;
        // ---------- Original Method ----------
        //elements = EmptyArray.OBJECT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.322 -0400", hash_original_method = "83ED6C7BC28A1565457859811EDD5A3A", hash_generated_method = "C5451B803A431DD2825061A25319C86A")
    public synchronized E remove(int index) {
        E varB4EAC82CA7396A68D541C85D26508E83_931708658 = null; //Variable for return #1
        @SuppressWarnings("unchecked") E removed;
        removed = (E) elements[index];
        removeRange(index, index + 1);
        varB4EAC82CA7396A68D541C85D26508E83_931708658 = removed;
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_931708658.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_931708658;
        // ---------- Original Method ----------
        //@SuppressWarnings("unchecked")
        //E removed = (E) elements[index];
        //removeRange(index, index + 1);
        //return removed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.326 -0400", hash_original_method = "4348B5D441F5A12C585788ED2765C3A4", hash_generated_method = "D716F7A80CB8616A41813B22A5FA52E0")
    public synchronized boolean remove(Object o) {
        int index;
        index = indexOf(o);
        remove(index);
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_814790121 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_814790121;
        // ---------- Original Method ----------
        //int index = indexOf(o);
        //if (index == -1) {
            //return false;
        //}
        //remove(index);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.327 -0400", hash_original_method = "1C7B7BE5468A5E30603ED6851F28BACD", hash_generated_method = "C76597E9CE88916279915E4987DFA297")
    public synchronized boolean removeAll(Collection<?> collection) {
        boolean varB4080136E4414D738D63F3764F6FBFEE_1189580812 = (removeOrRetain(collection, false, 0, elements.length) != 0);
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_395783179 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_395783179;
        // ---------- Original Method ----------
        //return removeOrRetain(collection, false, 0, elements.length) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.327 -0400", hash_original_method = "6F7BCA7B0FD040BA943A37C2A3FEA10F", hash_generated_method = "885A905B03C46B90040FFF9ED3509A84")
    public synchronized boolean retainAll(Collection<?> collection) {
        boolean var9149E6DF8FB33323D0296E3F070EADBC_117752314 = (removeOrRetain(collection, true, 0, elements.length) != 0);
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_864013849 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_864013849;
        // ---------- Original Method ----------
        //return removeOrRetain(collection, true, 0, elements.length) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.346 -0400", hash_original_method = "4C6E97480A096674EA078C65954A8FE2", hash_generated_method = "08D1947CAE8316A84576AF6508D858A0")
    private int removeOrRetain(Collection<?> collection, boolean retain, int from, int to) {
        {
            int i;
            i = from;
            {
                {
                    boolean varC6BA4CD1BE642A29C15190B0FCD2F50D_1643292783 = (collection.contains(elements[i]) == retain);
                } //End collapsed parenthetic
                Object[] newElements;
                newElements = new Object[elements.length - 1];
                System.arraycopy(elements, 0, newElements, 0, i);
                int newSize;
                newSize = i;
                {
                    int j;
                    j = i + 1;
                    {
                        {
                            boolean varEA71BBF34A922A67A0C66E1F44121158_381900219 = (collection.contains(elements[j]) == retain);
                            {
                                newElements[newSize++] = elements[j];
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                System.arraycopy(elements, to, newElements, newSize, elements.length - to);
                newSize += (elements.length - to);
                {
                    newElements = Arrays.copyOfRange(newElements, 0, newSize);
                } //End block
                int removed;
                removed = elements.length - newElements.length;
                elements = newElements;
            } //End block
        } //End collapsed parenthetic
        addTaint(collection.getTaint());
        addTaint(retain);
        addTaint(from);
        addTaint(to);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_443239486 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_443239486;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.348 -0400", hash_original_method = "DD4407442CC828B95DFD10F580DA2DDA", hash_generated_method = "5B4C4351B0D42B2C90021AB02D3D0704")
    public synchronized E set(int index, E e) {
        E varB4EAC82CA7396A68D541C85D26508E83_342832400 = null; //Variable for return #1
        Object[] newElements;
        newElements = elements.clone();
        @SuppressWarnings("unchecked") E result;
        result = (E) newElements[index];
        newElements[index] = e;
        elements = newElements;
        varB4EAC82CA7396A68D541C85D26508E83_342832400 = result;
        addTaint(index);
        addTaint(e.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_342832400.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_342832400;
        // ---------- Original Method ----------
        //Object[] newElements = elements.clone();
        //@SuppressWarnings("unchecked")
        //E result = (E) newElements[index];
        //newElements[index] = e;
        //elements = newElements;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.359 -0400", hash_original_method = "3E2723924788C644A99252EDEC8904D6", hash_generated_method = "ADA8CD6F8CF3D138B0105E90132E1C02")
    private void removeRange(int from, int to) {
        Object[] newElements;
        newElements = new Object[elements.length - (to - from)];
        System.arraycopy(elements, 0, newElements, 0, from);
        System.arraycopy(elements, to, newElements, from, elements.length - to);
        elements = newElements;
        addTaint(from);
        addTaint(to);
        // ---------- Original Method ----------
        //Object[] newElements = new Object[elements.length - (to - from)];
        //System.arraycopy(elements, 0, newElements, 0, from);
        //System.arraycopy(elements, to, newElements, from, elements.length - to);
        //elements = newElements;
    }

    
        static int lastIndexOf(Object o, Object[] data, int from, int to) {
        if (o == null) {
            for (int i = to - 1; i >= from; i--) {
                if (data[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = to - 1; i >= from; i--) {
                if (o.equals(data[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    
        static int indexOf(Object o, Object[] data, int from, int to) {
        if (o == null) {
            for (int i = from; i < to; i++) {
                if (data[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = from; i < to; i++) {
                if (o.equals(data[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.376 -0400", hash_original_method = "223CD20A6350F975434ED49A9EB8E646", hash_generated_method = "A4163B42B0D6C1E25328A5E991E484F4")
    final Object[] getArray() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_564015857 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_564015857 = elements;
        varB4EAC82CA7396A68D541C85D26508E83_564015857.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_564015857;
        // ---------- Original Method ----------
        //return elements;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.449 -0400", hash_original_method = "53FDF52EC3502469838FF7FC9C3722C1", hash_generated_method = "2DB9C4261DF427881AF090A0A18EE89E")
    private void writeObject(ObjectOutputStream out) throws IOException {
        Object[] snapshot;
        snapshot = elements;
        out.defaultWriteObject();
        out.writeInt(snapshot.length);
        {
            Object o = snapshot[0];
            {
                out.writeObject(o);
            } //End block
        } //End collapsed parenthetic
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //out.defaultWriteObject();
        //out.writeInt(snapshot.length);
        //for (Object o : snapshot) {
            //out.writeObject(o);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.464 -0400", hash_original_method = "5D8878D7111BA02D76F457F9A02251F1", hash_generated_method = "1620B925895B5FB7B7EB70AE54F066A3")
    private synchronized void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        Object[] snapshot;
        snapshot = new Object[in.readInt()];
        {
            int i;
            i = 0;
            {
                snapshot[i] = in.readObject();
            } //End block
        } //End collapsed parenthetic
        elements = snapshot;
        addTaint(in.getTaint());
        // ---------- Original Method ----------
        //in.defaultReadObject();
        //Object[] snapshot = new Object[in.readInt()];
        //for (int i = 0; i < snapshot.length; i++) {
            //snapshot[i] = in.readObject();
        //}
        //elements = snapshot;
    }

    
    class CowSubList extends AbstractList<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.465 -0400", hash_original_field = "6D52012DCA4FC77AA554F25430AEF501", hash_generated_field = "8800B1EC4033F6ED9C1D3C210D1DF359")

        private volatile Slice slice;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.465 -0400", hash_original_method = "19F9B6A2C098797122B64953C4557260", hash_generated_method = "5B199B3E4B2B392A5F281C0027899513")
        public  CowSubList(Object[] expectedElements, int from, int to) {
            this.slice = new Slice(expectedElements, from, to);
            // ---------- Original Method ----------
            //this.slice = new Slice(expectedElements, from, to);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.465 -0400", hash_original_method = "50828BB5D9839792ECEF31A7338C6C2F", hash_generated_method = "D7A98435E39FB0F445767F473738E168")
        @Override
        public int size() {
            Slice slice;
            slice = this.slice;
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_531486576 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_531486576;
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //return slice.to - slice.from;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.465 -0400", hash_original_method = "9FA55EF0B71DE676ACDFCDE8D001E08C", hash_generated_method = "E0FEAA5A7F4B7485D139E52C73B7006B")
        @Override
        public boolean isEmpty() {
            Slice slice;
            slice = this.slice;
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_797654138 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_797654138;
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //return slice.from == slice.to;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.466 -0400", hash_original_method = "E9398BCB1605EBC5A566CA332DEC078B", hash_generated_method = "35DC7A76C3695E0F510D26AD1B30EC06")
        @SuppressWarnings("unchecked")
        @Override
        public E get(int index) {
            E varB4EAC82CA7396A68D541C85D26508E83_2130049015 = null; //Variable for return #1
            Slice slice;
            slice = this.slice;
            Object[] snapshot;
            snapshot = elements;
            slice.checkElementIndex(index);
            slice.checkConcurrentModification(snapshot);
            varB4EAC82CA7396A68D541C85D26508E83_2130049015 = (E) snapshot[index + slice.from];
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_2130049015.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2130049015;
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //Object[] snapshot = elements;
            //slice.checkElementIndex(index);
            //slice.checkConcurrentModification(snapshot);
            //return (E) snapshot[index + slice.from];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.466 -0400", hash_original_method = "1D00ECD22B3575A885077212162F97B2", hash_generated_method = "2DA4E7BA6522AD403B4A9D67E99FE793")
        @Override
        public Iterator<E> iterator() {
            Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_1796761582 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1796761582 = listIterator(0);
            varB4EAC82CA7396A68D541C85D26508E83_1796761582.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1796761582;
            // ---------- Original Method ----------
            //return listIterator(0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.472 -0400", hash_original_method = "DF7BE0B13ABC5A9B1C74313BD06FB64C", hash_generated_method = "7659C9884A3EFA04BBDD1043C77B2108")
        @Override
        public ListIterator<E> listIterator() {
            ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_1397097976 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1397097976 = listIterator(0);
            varB4EAC82CA7396A68D541C85D26508E83_1397097976.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1397097976;
            // ---------- Original Method ----------
            //return listIterator(0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.473 -0400", hash_original_method = "2453E5226E92CA007A5F28D50241AFEC", hash_generated_method = "680F89DD31DED33E73F789FE8FCFB875")
        @Override
        public ListIterator<E> listIterator(int index) {
            ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_1933672140 = null; //Variable for return #1
            Slice slice;
            slice = this.slice;
            Object[] snapshot;
            snapshot = elements;
            slice.checkPositionIndex(index);
            slice.checkConcurrentModification(snapshot);
            CowIterator<E> result;
            result = new CowIterator<E>(snapshot, slice.from, slice.to);
            result.index = slice.from + index;
            varB4EAC82CA7396A68D541C85D26508E83_1933672140 = result;
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_1933672140.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1933672140;
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //Object[] snapshot = elements;
            //slice.checkPositionIndex(index);
            //slice.checkConcurrentModification(snapshot);
            //CowIterator<E> result = new CowIterator<E>(snapshot, slice.from, slice.to);
            //result.index = slice.from + index;
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.499 -0400", hash_original_method = "3CF9433C05AE07A5EB66F121888070F6", hash_generated_method = "54F90787E95710035556734948162C58")
        @Override
        public int indexOf(Object object) {
            Slice slice;
            slice = this.slice;
            Object[] snapshot;
            snapshot = elements;
            slice.checkConcurrentModification(snapshot);
            int result;
            result = CopyOnWriteArrayList.indexOf(object, snapshot, slice.from, slice.to);
            addTaint(object.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1942010491 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1942010491;
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //Object[] snapshot = elements;
            //slice.checkConcurrentModification(snapshot);
            //int result = CopyOnWriteArrayList.indexOf(object, snapshot, slice.from, slice.to);
            //return (result != -1) ? (result - slice.from) : -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.499 -0400", hash_original_method = "1CFCD041D8AD8CF1B36536A28BABB7D9", hash_generated_method = "22F69D76E8688B9D4CEA464719A7D13F")
        @Override
        public int lastIndexOf(Object object) {
            Slice slice;
            slice = this.slice;
            Object[] snapshot;
            snapshot = elements;
            slice.checkConcurrentModification(snapshot);
            int result;
            result = CopyOnWriteArrayList.lastIndexOf(object, snapshot, slice.from, slice.to);
            addTaint(object.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1445106759 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1445106759;
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //Object[] snapshot = elements;
            //slice.checkConcurrentModification(snapshot);
            //int result = CopyOnWriteArrayList.lastIndexOf(object, snapshot, slice.from, slice.to);
            //return (result != -1) ? (result - slice.from) : -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.499 -0400", hash_original_method = "3D9C8519C0BA49AAEEEEE7D259DD1898", hash_generated_method = "1C32EE16EF0AD9DA5B7FA7B657037813")
        @Override
        public boolean contains(Object object) {
            boolean var1CBE8A280A6EF98EBEBE6D4C530DF78D_2101466073 = (indexOf(object) != -1);
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_938837637 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_938837637;
            // ---------- Original Method ----------
            //return indexOf(object) != -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.500 -0400", hash_original_method = "1CE1F4665E7580AB233B83935273A194", hash_generated_method = "B26A7DAF2078921269B728659A60FD02")
        @Override
        public boolean containsAll(Collection<?> collection) {
            Slice slice;
            slice = this.slice;
            Object[] snapshot;
            snapshot = elements;
            slice.checkConcurrentModification(snapshot);
            boolean var34F8E2D032BDFD9A299807B37CDBBDC9_1261344665 = (CopyOnWriteArrayList.containsAll(collection, snapshot, slice.from, slice.to));
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_38941076 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_38941076;
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //Object[] snapshot = elements;
            //slice.checkConcurrentModification(snapshot);
            //return CopyOnWriteArrayList.containsAll(collection, snapshot, slice.from, slice.to);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.500 -0400", hash_original_method = "023D8E294D6742BA836A68C5ADAAB497", hash_generated_method = "16DADDCD47EE9F7745E1489AA312593B")
        @Override
        public List<E> subList(int from, int to) {
            List<E> varB4EAC82CA7396A68D541C85D26508E83_1195452446 = null; //Variable for return #1
            Slice slice;
            slice = this.slice;
            {
                boolean var8B44CCFE67682F7E890DAC0190AAF2EF_218104014 = (from < 0 || from > to || to > size());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("from=" + from + ", to=" + to +
                        ", list size=" + size());
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1195452446 = new CowSubList(slice.expectedElements, slice.from + from, slice.from + to);
            addTaint(from);
            addTaint(to);
            varB4EAC82CA7396A68D541C85D26508E83_1195452446.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1195452446;
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //if (from < 0 || from > to || to > size()) {
                //throw new IndexOutOfBoundsException("from=" + from + ", to=" + to +
                        //", list size=" + size());
            //}
            //return new CowSubList(slice.expectedElements, slice.from + from, slice.from + to);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.501 -0400", hash_original_method = "F47D7AB044AE200CBA9EE898533B8FEC", hash_generated_method = "0D0A0E578272085D6199ABEEDA18809B")
        @Override
        public E remove(int index) {
            E varB4EAC82CA7396A68D541C85D26508E83_772028778 = null; //Variable for return #1
            {
                Object var0414760F989879E00EA455A9A86D73CF_1730185665 = (CopyOnWriteArrayList.this);
                {
                    slice.checkElementIndex(index);
                    slice.checkConcurrentModification(elements);
                    E removed;
                    removed = CopyOnWriteArrayList.this.remove(slice.from + index);
                    slice = new Slice(elements, slice.from, slice.to - 1);
                    varB4EAC82CA7396A68D541C85D26508E83_772028778 = removed;
                } //End block
            } //End collapsed parenthetic
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_772028778.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_772028778;
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //slice.checkElementIndex(index);
                //slice.checkConcurrentModification(elements);
                //E removed = CopyOnWriteArrayList.this.remove(slice.from + index);
                //slice = new Slice(elements, slice.from, slice.to - 1);
                //return removed;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.502 -0400", hash_original_method = "E7748E0E6765940072A4C93526FE4787", hash_generated_method = "E0545022BD8EFFA72CC77C46FAB41866")
        @Override
        public void clear() {
            {
                Object var0414760F989879E00EA455A9A86D73CF_1723646344 = (CopyOnWriteArrayList.this);
                {
                    slice.checkConcurrentModification(elements);
                    CopyOnWriteArrayList.this.removeRange(slice.from, slice.to);
                    slice = new Slice(elements, slice.from, slice.from);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //slice.checkConcurrentModification(elements);
                //CopyOnWriteArrayList.this.removeRange(slice.from, slice.to);
                //slice = new Slice(elements, slice.from, slice.from);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.502 -0400", hash_original_method = "7558F5D9173C65FEAD4E275F1C1E5A80", hash_generated_method = "ED4F32B98AE7BDEAF0F80A2F021048C7")
        @Override
        public void add(int index, E object) {
            {
                Object var0414760F989879E00EA455A9A86D73CF_1398690460 = (CopyOnWriteArrayList.this);
                {
                    slice.checkPositionIndex(index);
                    slice.checkConcurrentModification(elements);
                    CopyOnWriteArrayList.this.add(index + slice.from, object);
                    slice = new Slice(elements, slice.from, slice.to + 1);
                } //End block
            } //End collapsed parenthetic
            addTaint(index);
            addTaint(object.getTaint());
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //slice.checkPositionIndex(index);
                //slice.checkConcurrentModification(elements);
                //CopyOnWriteArrayList.this.add(index + slice.from, object);
                //slice = new Slice(elements, slice.from, slice.to + 1);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.503 -0400", hash_original_method = "E905080D7BBE0BD2F3F279BF8EF6D6A8", hash_generated_method = "7704402EEEB243F601AE15D289A5C680")
        @Override
        public boolean add(E object) {
            {
                Object var0414760F989879E00EA455A9A86D73CF_571496288 = (CopyOnWriteArrayList.this);
                {
                    add(slice.to - slice.from, object);
                } //End block
            } //End collapsed parenthetic
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_879235526 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_879235526;
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //add(slice.to - slice.from, object);
                //return true;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.503 -0400", hash_original_method = "1293804DB9B63143F37D5D821EA6A87E", hash_generated_method = "B844A01CE62CF4C4FB19D19FDA88AD62")
        @Override
        public boolean addAll(int index, Collection<? extends E> collection) {
            {
                Object var0414760F989879E00EA455A9A86D73CF_1131349757 = (CopyOnWriteArrayList.this);
                {
                    slice.checkPositionIndex(index);
                    slice.checkConcurrentModification(elements);
                    int oldSize;
                    oldSize = elements.length;
                    boolean result;
                    result = CopyOnWriteArrayList.this.addAll(index + slice.from, collection);
                    slice = new Slice(elements, slice.from, slice.to + (elements.length - oldSize));
                } //End block
            } //End collapsed parenthetic
            addTaint(index);
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1765642460 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1765642460;
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //slice.checkPositionIndex(index);
                //slice.checkConcurrentModification(elements);
                //int oldSize = elements.length;
                //boolean result = CopyOnWriteArrayList.this.addAll(index + slice.from, collection);
                //slice = new Slice(elements, slice.from, slice.to + (elements.length - oldSize));
                //return result;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.521 -0400", hash_original_method = "2FF5E8554EDDACF9F2F627214E3BC10D", hash_generated_method = "448BCA3CF604B1CEADAB23123B33CE08")
        @Override
        public boolean addAll(Collection<? extends E> collection) {
            {
                Object var0414760F989879E00EA455A9A86D73CF_1225699508 = (CopyOnWriteArrayList.this);
                {
                    boolean var74E51E10D11DF48379CEFE0A325D5F6E_408159091 = (addAll(size(), collection));
                } //End block
            } //End collapsed parenthetic
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_696356165 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_696356165;
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //return addAll(size(), collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.521 -0400", hash_original_method = "E52798445FC11575DB685349896EB8F6", hash_generated_method = "996B44D22E8A2E42EFC8A3E33353A0E7")
        @Override
        public E set(int index, E object) {
            E varB4EAC82CA7396A68D541C85D26508E83_339023689 = null; //Variable for return #1
            {
                Object var0414760F989879E00EA455A9A86D73CF_222139698 = (CopyOnWriteArrayList.this);
                {
                    slice.checkElementIndex(index);
                    slice.checkConcurrentModification(elements);
                    E result;
                    result = CopyOnWriteArrayList.this.set(index + slice.from, object);
                    slice = new Slice(elements, slice.from, slice.to);
                    varB4EAC82CA7396A68D541C85D26508E83_339023689 = result;
                } //End block
            } //End collapsed parenthetic
            addTaint(index);
            addTaint(object.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_339023689.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_339023689;
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //slice.checkElementIndex(index);
                //slice.checkConcurrentModification(elements);
                //E result = CopyOnWriteArrayList.this.set(index + slice.from, object);
                //slice = new Slice(elements, slice.from, slice.to);
                //return result;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.522 -0400", hash_original_method = "924C9E5471F08F30B8E12AD962D48DF2", hash_generated_method = "2B274D41123A2E14EFD6AE15B2D4182F")
        @Override
        public boolean remove(Object object) {
            {
                Object var0414760F989879E00EA455A9A86D73CF_385679785 = (CopyOnWriteArrayList.this);
                {
                    int index;
                    index = indexOf(object);
                    remove(index);
                } //End block
            } //End collapsed parenthetic
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_294050869 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_294050869;
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //int index = indexOf(object);
                //if (index == -1) {
                    //return false;
                //}
                //remove(index);
                //return true;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.522 -0400", hash_original_method = "6ECA6BCBA1861C546E018F40208C7C7C", hash_generated_method = "55670DD7ECACE014B435802387A8086F")
        @Override
        public boolean removeAll(Collection<?> collection) {
            {
                Object var0414760F989879E00EA455A9A86D73CF_986914254 = (CopyOnWriteArrayList.this);
                {
                    slice.checkConcurrentModification(elements);
                    int removed;
                    removed = removeOrRetain(collection, false, slice.from, slice.to);
                    slice = new Slice(elements, slice.from, slice.to - removed);
                } //End block
            } //End collapsed parenthetic
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_391429815 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_391429815;
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //slice.checkConcurrentModification(elements);
                //int removed = removeOrRetain(collection, false, slice.from, slice.to);
                //slice = new Slice(elements, slice.from, slice.to - removed);
                //return removed != 0;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.523 -0400", hash_original_method = "055B3FCFE954B48BD2D5F95BFF90FFFE", hash_generated_method = "1E677BA8A12FF9E9C3F43C114A547ABA")
        @Override
        public boolean retainAll(Collection<?> collection) {
            {
                Object var0414760F989879E00EA455A9A86D73CF_1652140900 = (CopyOnWriteArrayList.this);
                {
                    slice.checkConcurrentModification(elements);
                    int removed;
                    removed = removeOrRetain(collection, true, slice.from, slice.to);
                    slice = new Slice(elements, slice.from, slice.to - removed);
                } //End block
            } //End collapsed parenthetic
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1697131381 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1697131381;
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //slice.checkConcurrentModification(elements);
                //int removed = removeOrRetain(collection, true, slice.from, slice.to);
                //slice = new Slice(elements, slice.from, slice.to - removed);
                //return removed != 0;
            //}
        }

        
    }


    
    static class Slice {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.523 -0400", hash_original_field = "5DBBBEFC516616C59322E114837C83FB", hash_generated_field = "578E1B95CBBB0F53A72648DE31016F3A")

        private Object[] expectedElements;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.523 -0400", hash_original_field = "D98A07F84921B24EE30F86FD8CD85C3C", hash_generated_field = "98A0E6E2AB8AB9E19CC3F35C494E6A79")

        private int from;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.523 -0400", hash_original_field = "01B6E20344B68835C5ED1DDEDF20D531", hash_generated_field = "BDB6664DDCCB6D4D52DFAB8483E3BBDE")

        private int to;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.536 -0400", hash_original_method = "83A1C0AAD9B8B03E61B8B75E1CD914D7", hash_generated_method = "6056AD1FF5F186156B93AC86A3F90BBC")
          Slice(Object[] expectedElements, int from, int to) {
            this.expectedElements = expectedElements;
            this.from = from;
            this.to = to;
            // ---------- Original Method ----------
            //this.expectedElements = expectedElements;
            //this.from = from;
            //this.to = to;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.537 -0400", hash_original_method = "C41DDBF64E4B04157ED5EDFC21AF561C", hash_generated_method = "CD2CA17E534A100BB92056382E13D4CA")
         void checkElementIndex(int index) {
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("index=" + index + ", size=" + (to - from));
            } //End block
            addTaint(index);
            // ---------- Original Method ----------
            //if (index < 0 || index >= to - from) {
                //throw new IndexOutOfBoundsException("index=" + index + ", size=" + (to - from));
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.537 -0400", hash_original_method = "D022C90E4388D47B06DB5C9D4119BF1C", hash_generated_method = "3064D546FBACD8749E7130231FBB73C7")
         void checkPositionIndex(int index) {
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("index=" + index + ", size=" + (to - from));
            } //End block
            addTaint(index);
            // ---------- Original Method ----------
            //if (index < 0 || index > to - from) {
                //throw new IndexOutOfBoundsException("index=" + index + ", size=" + (to - from));
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.537 -0400", hash_original_method = "7DF1E46EED7497F4680296245E77E1DC", hash_generated_method = "F9C340591E59B66F4BFBA6ED2CDFB0F3")
         void checkConcurrentModification(Object[] snapshot) {
            {
                if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            } //End block
            addTaint(snapshot[0].getTaint());
            // ---------- Original Method ----------
            //if (expectedElements != snapshot) {
                //throw new ConcurrentModificationException();
            //}
        }

        
    }


    
    static class CowIterator<E> implements ListIterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.537 -0400", hash_original_field = "C322D3DE29D2B0C5E2E011DAD5E77DF2", hash_generated_field = "FEC1DD40EAC9BB9175BC6E1CF39F3785")

        private Object[] snapshot;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.537 -0400", hash_original_field = "D98A07F84921B24EE30F86FD8CD85C3C", hash_generated_field = "98A0E6E2AB8AB9E19CC3F35C494E6A79")

        private int from;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.538 -0400", hash_original_field = "01B6E20344B68835C5ED1DDEDF20D531", hash_generated_field = "BDB6664DDCCB6D4D52DFAB8483E3BBDE")

        private int to;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.538 -0400", hash_original_field = "CB241078244A9AA790B0FC45841BA024", hash_generated_field = "AE5C9711C7D27D5EECF32B3638DBE7E5")

        private int index = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.538 -0400", hash_original_method = "E0987AFDD42E4364FE4BB0FD3F1A0501", hash_generated_method = "761C1CBB0EA0B2EE4578133FB46FB797")
          CowIterator(Object[] snapshot, int from, int to) {
            this.snapshot = snapshot;
            this.from = from;
            this.to = to;
            this.index = from;
            // ---------- Original Method ----------
            //this.snapshot = snapshot;
            //this.from = from;
            //this.to = to;
            //this.index = from;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.538 -0400", hash_original_method = "960DAE05B3D69FE5F79E9628DB5B33E6", hash_generated_method = "7078F39A7BE4B1A66C0E863B971864AD")
        public void add(E object) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(object.getTaint());
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.539 -0400", hash_original_method = "D639D4E7D9CD50DE4105991F3953FD80", hash_generated_method = "E77A471102A427FAE07D3FD0ED2F7E64")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1521761137 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1521761137;
            // ---------- Original Method ----------
            //return index < to;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.539 -0400", hash_original_method = "EC30B2CF9A7B23E69047D11D06EFA3CA", hash_generated_method = "D6447A58F9031C4C5235D2032FCFB015")
        public boolean hasPrevious() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_706726883 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_706726883;
            // ---------- Original Method ----------
            //return index > from;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.539 -0400", hash_original_method = "32D582641092A62093AF5BD2A9D350AD", hash_generated_method = "49EBAD91630C6D4881FF50D1C682825B")
        @SuppressWarnings("unchecked")
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_1764784189 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_1764784189 = (E) snapshot[index++];
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1764784189.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1764784189;
            // ---------- Original Method ----------
            //if (index < to) {
                //return (E) snapshot[index++];
            //} else {
                //throw new NoSuchElementException();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.561 -0400", hash_original_method = "B3E96A2468FAF72FDE35394237D3EDCC", hash_generated_method = "67AA75517E4DD4C5567F042BC7F4CF8D")
        public int nextIndex() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_378016995 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_378016995;
            // ---------- Original Method ----------
            //return index;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.561 -0400", hash_original_method = "7AA7D7DC0436E32BBB89C3C957160D69", hash_generated_method = "DB2B6204DB8F9B6E2965D17F5346CF13")
        @SuppressWarnings("unchecked")
        public E previous() {
            E varB4EAC82CA7396A68D541C85D26508E83_313353130 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_313353130 = (E) snapshot[--index];
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_313353130.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_313353130;
            // ---------- Original Method ----------
            //if (index > from) {
                //return (E) snapshot[--index];
            //} else {
                //throw new NoSuchElementException();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.561 -0400", hash_original_method = "30EF9C1C05880C206BCB89722B1108E9", hash_generated_method = "FF8F6F0F6739E8C75AE91C00C18C452E")
        public int previousIndex() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1724006031 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1724006031;
            // ---------- Original Method ----------
            //return index - 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.562 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "BD0416D7797F4CCA5C01710103DCE99D")
        public void remove() {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.562 -0400", hash_original_method = "1001E1C2B2FD09C7DE97126421AC0A91", hash_generated_method = "F7AE59885F055C425C0440CAC4D1CE97")
        public void set(E object) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(object.getTaint());
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.562 -0400", hash_original_field = "CB0A5E07D474346F2427954305CE9572", hash_generated_field = "7D8A16739AEFE5D33A952E311F270AA5")

    private static long serialVersionUID = 8673264195747942595L;
}

