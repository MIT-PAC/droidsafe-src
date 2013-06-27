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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.899 -0400", hash_original_field = "6A7F245843454CF4F28AD7C5E2572AA2", hash_generated_field = "9773C6104DBFF8AC92488F3C4AD39164")

    private transient volatile Object[] elements;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.900 -0400", hash_original_method = "E357703A48348C8EEE9667190E563C6C", hash_generated_method = "B97966364BBED793B94DBEEDDFBF1B8C")
    public  CopyOnWriteArrayList() {
        elements = EmptyArray.OBJECT;
        // ---------- Original Method ----------
        //elements = EmptyArray.OBJECT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.900 -0400", hash_original_method = "84AACC1E4283EC6F676E4F2CD339FC5B", hash_generated_method = "EA0C15CE1422D9A7119B138FB9DFD0F8")
    @SuppressWarnings("unchecked")
    public  CopyOnWriteArrayList(Collection<? extends E> collection) {
        this((E[]) collection.toArray());
        addTaint(collection.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.900 -0400", hash_original_method = "51C6AA63C04D903DC2F19EE7270C9A87", hash_generated_method = "5F0DE0F3745CDDE56CD0A00206594245")
    public  CopyOnWriteArrayList(E[] array) {
        this.elements = Arrays.copyOf(array, array.length, Object[].class);
        // ---------- Original Method ----------
        //this.elements = Arrays.copyOf(array, array.length, Object[].class);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.901 -0400", hash_original_method = "FF2ED4DF1B70DABD1A45F755E1952592", hash_generated_method = "E994B1DE006C44E787C803E97D66D4BF")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_666065639 = null; //Variable for return #1
        try 
        {
            CopyOnWriteArrayList result;
            result = (CopyOnWriteArrayList) super.clone();
            result.elements = result.elements.clone();
            varB4EAC82CA7396A68D541C85D26508E83_666065639 = result;
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_666065639.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_666065639;
        // ---------- Original Method ----------
        //try {
            //CopyOnWriteArrayList result = (CopyOnWriteArrayList) super.clone();
            //result.elements = result.elements.clone();
            //return result;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.901 -0400", hash_original_method = "68DC52534F60D1A5138253A79B12E67C", hash_generated_method = "203243F29D4DFBE9A28D22E482DF8FE1")
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_348164591 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_348164591;
        // ---------- Original Method ----------
        //return elements.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.901 -0400", hash_original_method = "07C72EA93D8BC7AB1EE5326762E05E69", hash_generated_method = "E632ACA53DADE1842C4F8D041E1DB324")
    @SuppressWarnings("unchecked")
    public E get(int index) {
        E varB4EAC82CA7396A68D541C85D26508E83_2108223601 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2108223601 = (E) elements[index];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_2108223601.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2108223601;
        // ---------- Original Method ----------
        //return (E) elements[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.902 -0400", hash_original_method = "1274BF0858E749C3D9852E86C4A99C22", hash_generated_method = "B1A9D8AC3B23985C4FB20427CDEDFA33")
    public boolean contains(Object o) {
        boolean var2580C065AD3F25FA806E0EC1F5491D61_800037952 = (indexOf(o) != -1);
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1412050726 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1412050726;
        // ---------- Original Method ----------
        //return indexOf(o) != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.902 -0400", hash_original_method = "F181183DABCA5209C115C87B0BC63071", hash_generated_method = "0646CEED5AC7FAA9A50F6490A8BCDB41")
    public boolean containsAll(Collection<?> collection) {
        Object[] snapshot;
        snapshot = elements;
        boolean varB51CD127B94D30044743FDBEC427798E_1902988707 = (containsAll(collection, snapshot, 0, snapshot.length));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1482112166 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1482112166;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.921 -0400", hash_original_method = "8F838DDE7B5E08714D6360ECE6328BF5", hash_generated_method = "9113F843D43E88188DA12E8AA480A2CB")
    public int indexOf(E object, int from) {
        Object[] snapshot;
        snapshot = elements;
        int var3F4FFEA1DA0968D7F475C5A4D1C4F62D_952783418 = (indexOf(object, snapshot, from, snapshot.length));
        addTaint(object.getTaint());
        addTaint(from);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_668560978 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_668560978;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return indexOf(object, snapshot, from, snapshot.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.922 -0400", hash_original_method = "3333011450759BE4404CA7231EDCF09F", hash_generated_method = "0D935E28D87510289B3B8ECD8DA78B4A")
    public int indexOf(Object object) {
        Object[] snapshot;
        snapshot = elements;
        int varF95830349FA4633C99755E2E13FD61DA_1747265894 = (indexOf(object, snapshot, 0, snapshot.length));
        addTaint(object.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_420903777 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_420903777;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return indexOf(object, snapshot, 0, snapshot.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.922 -0400", hash_original_method = "19C8A04DC3A46E49A84DF6B57E1917A9", hash_generated_method = "8DBF8A4121A27757704FF5B6D440C978")
    public int lastIndexOf(E object, int to) {
        Object[] snapshot;
        snapshot = elements;
        int var044750AB099D388AF4C1D65CC717289C_1762702440 = (lastIndexOf(object, snapshot, 0, to));
        addTaint(object.getTaint());
        addTaint(to);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1771931110 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1771931110;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return lastIndexOf(object, snapshot, 0, to);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.922 -0400", hash_original_method = "D45902A72D19AFDC170F4A4D129ABA97", hash_generated_method = "032B425A4F098F11F832AE99BF08690B")
    public int lastIndexOf(Object object) {
        Object[] snapshot;
        snapshot = elements;
        int var363578769FBDCE20799A418E17F6DBCF_1178164088 = (lastIndexOf(object, snapshot, 0, snapshot.length));
        addTaint(object.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1736869730 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1736869730;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return lastIndexOf(object, snapshot, 0, snapshot.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.923 -0400", hash_original_method = "E13DA7C33D486C9539B3B38ADEEDBA9D", hash_generated_method = "36C1DD338A87272B4D1C6D0F6A0308B7")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_299260668 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_299260668;
        // ---------- Original Method ----------
        //return elements.length == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.923 -0400", hash_original_method = "8AC2A236339BBBFB218E3FC5088D17DA", hash_generated_method = "9FADE9340CAF5FF4D254FD1082D3F846")
    public Iterator<E> iterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_1421618933 = null; //Variable for return #1
        Object[] snapshot;
        snapshot = elements;
        varB4EAC82CA7396A68D541C85D26508E83_1421618933 = new CowIterator<E>(snapshot, 0, snapshot.length);
        varB4EAC82CA7396A68D541C85D26508E83_1421618933.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1421618933;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return new CowIterator<E>(snapshot, 0, snapshot.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.937 -0400", hash_original_method = "6CF42CA16C3188E71052A9A04B3E4D16", hash_generated_method = "58D149B479718D1CB63E490967385F00")
    public ListIterator<E> listIterator(int index) {
        ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_67980385 = null; //Variable for return #1
        Object[] snapshot;
        snapshot = elements;
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("index=" + index + ", length=" + snapshot.length);
        } //End block
        CowIterator<E> result;
        result = new CowIterator<E>(snapshot, 0, snapshot.length);
        result.index = index;
        varB4EAC82CA7396A68D541C85D26508E83_67980385 = result;
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_67980385.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_67980385;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //if (index < 0 || index > snapshot.length) {
            //throw new IndexOutOfBoundsException("index=" + index + ", length=" + snapshot.length);
        //}
        //CowIterator<E> result = new CowIterator<E>(snapshot, 0, snapshot.length);
        //result.index = index;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.937 -0400", hash_original_method = "A4A3425D1D4C041DAFB5C093D1247DF1", hash_generated_method = "A7361F8E1F2E3916CABBC5537C2B2DE6")
    public ListIterator<E> listIterator() {
        ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_398196267 = null; //Variable for return #1
        Object[] snapshot;
        snapshot = elements;
        varB4EAC82CA7396A68D541C85D26508E83_398196267 = new CowIterator<E>(snapshot, 0, snapshot.length);
        varB4EAC82CA7396A68D541C85D26508E83_398196267.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_398196267;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return new CowIterator<E>(snapshot, 0, snapshot.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.938 -0400", hash_original_method = "594A2D8CB57DB4B1D13107F70D453706", hash_generated_method = "1B5D6DE2060E8C6034D057618D532D7A")
    public List<E> subList(int from, int to) {
        List<E> varB4EAC82CA7396A68D541C85D26508E83_107964112 = null; //Variable for return #1
        Object[] snapshot;
        snapshot = elements;
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("from=" + from + ", to=" + to +
                    ", list size=" + snapshot.length);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_107964112 = new CowSubList(snapshot, from, to);
        addTaint(from);
        addTaint(to);
        varB4EAC82CA7396A68D541C85D26508E83_107964112.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_107964112;
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //if (from < 0 || from > to || to > snapshot.length) {
            //throw new IndexOutOfBoundsException("from=" + from + ", to=" + to +
                    //", list size=" + snapshot.length);
        //}
        //return new CowSubList(snapshot, from, to);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.938 -0400", hash_original_method = "49659221AAE3F1C0ECCE830D1E5CE8D1", hash_generated_method = "54208B8AF3825521141DD9CF10808DB1")
    public Object[] toArray() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_239983594 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_239983594 = elements.clone();
        varB4EAC82CA7396A68D541C85D26508E83_239983594.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_239983594;
        // ---------- Original Method ----------
        //return elements.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.939 -0400", hash_original_method = "C1E48E79962F836E76F520B2DEE3FDB8", hash_generated_method = "F1AAC9190357E533499C2985D80D0ED8")
    @SuppressWarnings({"unchecked","SuspiciousSystemArraycopy"})
    public <T> T[] toArray(T[] contents) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_1310744121 = null; //Variable for return #1
        T[] varB4EAC82CA7396A68D541C85D26508E83_948436370 = null; //Variable for return #2
        Object[] snapshot;
        snapshot = elements;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1310744121 = (T[]) Arrays.copyOf(snapshot, snapshot.length, contents.getClass());
        } //End block
        System.arraycopy(snapshot, 0, contents, 0, snapshot.length);
        {
            contents[snapshot.length] = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_948436370 = contents;
        addTaint(contents[0].getTaint());
        T[] varA7E53CE21691AB073D9660D615818899_449055698; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_449055698 = varB4EAC82CA7396A68D541C85D26508E83_1310744121;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_449055698 = varB4EAC82CA7396A68D541C85D26508E83_948436370;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_449055698.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_449055698;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.130 -0400", hash_original_method = "6010CBD888F6152118D77E36B5616E02", hash_generated_method = "F5CFAEDDC8FF600C5414972964064A32")
    @Override
    public boolean equals(Object other) {
        {
            boolean var8E510C77A3CC00EDD5D5105BB9594676_1633974436 = (this == other
                    || Arrays.equals(elements, ((CopyOnWriteArrayList<?>) other).elements));
        } //End block
        {
            Object[] snapshot;
            snapshot = elements;
            Iterator<?> i;
            i = ((List<?>) other).iterator();
            {
                Iterator<Object> var112728ACB95922B20839C47454ECB6A5_913028840 = (snapshot).iterator();
                var112728ACB95922B20839C47454ECB6A5_913028840.hasNext();
                Object o = var112728ACB95922B20839C47454ECB6A5_913028840.next();
                {
                    {
                        boolean var6D2C6F2C90F31B26BD0BC8B4289F0FA4_803074505 = (!i.hasNext() || !Objects.equal(o, i.next()));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            boolean varCC7204A921FEC5763B81E50426A88D00_531280405 = (!i.hasNext());
        } //End block
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_213581995 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_213581995;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.131 -0400", hash_original_method = "5CBAD38024C40A34FCDA1A3FF083FDEC", hash_generated_method = "11BCE180300966C9931B4DA8AAF7FE70")
    @Override
    public int hashCode() {
        int varCAF3CD69EA8DECAF9471B49B185EF8B7_1753613329 = (Arrays.hashCode(elements));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_305320552 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_305320552;
        // ---------- Original Method ----------
        //return Arrays.hashCode(elements);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.132 -0400", hash_original_method = "D569C6F4ED8C88274D5F2CC2C9F6FBD2", hash_generated_method = "7CBCB46E6D7C4C2A4C0E752CB0CD500E")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_906425411 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_906425411 = Arrays.toString(elements);
        varB4EAC82CA7396A68D541C85D26508E83_906425411.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_906425411;
        // ---------- Original Method ----------
        //return Arrays.toString(elements);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.132 -0400", hash_original_method = "4C47893BDB4E93647009AE85D0DD4F0A", hash_generated_method = "7715C84CFE4F3B72D386FC1B10AC157D")
    public synchronized boolean add(E e) {
        Object[] newElements;
        newElements = new Object[elements.length + 1];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        newElements[elements.length] = e;
        elements = newElements;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1751641095 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1751641095;
        // ---------- Original Method ----------
        //Object[] newElements = new Object[elements.length + 1];
        //System.arraycopy(elements, 0, newElements, 0, elements.length);
        //newElements[elements.length] = e;
        //elements = newElements;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.133 -0400", hash_original_method = "9DD013FF12CCDC2B9301BB35B7E69B98", hash_generated_method = "851D85ECA0F05B52D852286F75AE7935")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.133 -0400", hash_original_method = "76766E6A3193E0133903AC8237158932", hash_generated_method = "769DF6CA584E641A15DD8B993DADCED5")
    public synchronized boolean addAll(Collection<? extends E> collection) {
        boolean var0159BD59FAEB520B52C0A163D95FA273_137253449 = (addAll(elements.length, collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1830951335 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1830951335;
        // ---------- Original Method ----------
        //return addAll(elements.length, collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.148 -0400", hash_original_method = "16622B391256B6F864845FABB18695E4", hash_generated_method = "D752F9CE9AE745F7FE0CE8D7BF0D8BAB")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_285110190 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_285110190;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.197 -0400", hash_original_method = "F6411BBDC5A81E1C464E9CEEEB8CCCF0", hash_generated_method = "F958CC39868D9618DDE3BBC01592B603")
    public synchronized int addAllAbsent(Collection<? extends E> collection) {
        Object[] toAdd;
        toAdd = collection.toArray();
        Object[] newElements;
        newElements = new Object[elements.length + toAdd.length];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        int addedCount;
        addedCount = 0;
        {
            Iterator<Object> varEBBC03880E205C3D948072471502DA24_236178579 = (toAdd).iterator();
            varEBBC03880E205C3D948072471502DA24_236178579.hasNext();
            Object o = varEBBC03880E205C3D948072471502DA24_236178579.next();
            {
                {
                    boolean var4BB4DD0650713F3AD6499B5BB3CF0F9C_2084405916 = (indexOf(o, newElements, 0, elements.length + addedCount) == -1);
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_977054806 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_977054806;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.197 -0400", hash_original_method = "17D643777423FC6042E703F36B3EB43F", hash_generated_method = "95AD40B9C36F62D89F77FB12E1E9B1A7")
    public synchronized boolean addIfAbsent(E object) {
        {
            boolean var9432A920D7B842B924EF8D1C9DF16F5D_686783259 = (contains(object));
        } //End collapsed parenthetic
        add(object);
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1296060386 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1296060386;
        // ---------- Original Method ----------
        //if (contains(object)) {
            //return false;
        //}
        //add(object);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.198 -0400", hash_original_method = "343DE0C64B38A0F7CE33FC0930F8B1CE", hash_generated_method = "0DD0CCA634A11D0B8559FCC328E0AB07")
    @Override
    public synchronized void clear() {
        elements = EmptyArray.OBJECT;
        // ---------- Original Method ----------
        //elements = EmptyArray.OBJECT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.198 -0400", hash_original_method = "83ED6C7BC28A1565457859811EDD5A3A", hash_generated_method = "56669EA34DA50BF5F67D4093A640E746")
    public synchronized E remove(int index) {
        E varB4EAC82CA7396A68D541C85D26508E83_112889021 = null; //Variable for return #1
        @SuppressWarnings("unchecked") E removed;
        removed = (E) elements[index];
        removeRange(index, index + 1);
        varB4EAC82CA7396A68D541C85D26508E83_112889021 = removed;
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_112889021.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_112889021;
        // ---------- Original Method ----------
        //@SuppressWarnings("unchecked")
        //E removed = (E) elements[index];
        //removeRange(index, index + 1);
        //return removed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.198 -0400", hash_original_method = "4348B5D441F5A12C585788ED2765C3A4", hash_generated_method = "2D931D49ED9D0D8AA7AB4464A55E752C")
    public synchronized boolean remove(Object o) {
        int index;
        index = indexOf(o);
        remove(index);
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_149559752 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_149559752;
        // ---------- Original Method ----------
        //int index = indexOf(o);
        //if (index == -1) {
            //return false;
        //}
        //remove(index);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.199 -0400", hash_original_method = "1C7B7BE5468A5E30603ED6851F28BACD", hash_generated_method = "18FED0DD78A74ABFCDB22E5D168B5182")
    public synchronized boolean removeAll(Collection<?> collection) {
        boolean varB4080136E4414D738D63F3764F6FBFEE_429617520 = (removeOrRetain(collection, false, 0, elements.length) != 0);
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_465733775 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_465733775;
        // ---------- Original Method ----------
        //return removeOrRetain(collection, false, 0, elements.length) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.199 -0400", hash_original_method = "6F7BCA7B0FD040BA943A37C2A3FEA10F", hash_generated_method = "56F569205D9856A1A4DDC706C753B813")
    public synchronized boolean retainAll(Collection<?> collection) {
        boolean var9149E6DF8FB33323D0296E3F070EADBC_1385248800 = (removeOrRetain(collection, true, 0, elements.length) != 0);
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1473414327 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1473414327;
        // ---------- Original Method ----------
        //return removeOrRetain(collection, true, 0, elements.length) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.200 -0400", hash_original_method = "4C6E97480A096674EA078C65954A8FE2", hash_generated_method = "1CFA4A1F6A85DDFB6A8D6C805033DC27")
    private int removeOrRetain(Collection<?> collection, boolean retain, int from, int to) {
        {
            int i;
            i = from;
            {
                {
                    boolean varC6BA4CD1BE642A29C15190B0FCD2F50D_444997836 = (collection.contains(elements[i]) == retain);
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
                            boolean varEA71BBF34A922A67A0C66E1F44121158_574308719 = (collection.contains(elements[j]) == retain);
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1290288959 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1290288959;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.206 -0400", hash_original_method = "DD4407442CC828B95DFD10F580DA2DDA", hash_generated_method = "EBE1B80F76A71DD31029D4A058AB10D0")
    public synchronized E set(int index, E e) {
        E varB4EAC82CA7396A68D541C85D26508E83_216991870 = null; //Variable for return #1
        Object[] newElements;
        newElements = elements.clone();
        @SuppressWarnings("unchecked") E result;
        result = (E) newElements[index];
        newElements[index] = e;
        elements = newElements;
        varB4EAC82CA7396A68D541C85D26508E83_216991870 = result;
        addTaint(index);
        addTaint(e.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_216991870.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_216991870;
        // ---------- Original Method ----------
        //Object[] newElements = elements.clone();
        //@SuppressWarnings("unchecked")
        //E result = (E) newElements[index];
        //newElements[index] = e;
        //elements = newElements;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.207 -0400", hash_original_method = "3E2723924788C644A99252EDEC8904D6", hash_generated_method = "ADA8CD6F8CF3D138B0105E90132E1C02")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.227 -0400", hash_original_method = "223CD20A6350F975434ED49A9EB8E646", hash_generated_method = "8DD1806B2DD9C738B5BFBE21FA29FCCD")
    final Object[] getArray() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_1649728209 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1649728209 = elements;
        varB4EAC82CA7396A68D541C85D26508E83_1649728209.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1649728209;
        // ---------- Original Method ----------
        //return elements;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.267 -0400", hash_original_method = "53FDF52EC3502469838FF7FC9C3722C1", hash_generated_method = "2DB9C4261DF427881AF090A0A18EE89E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.288 -0400", hash_original_method = "5D8878D7111BA02D76F457F9A02251F1", hash_generated_method = "1620B925895B5FB7B7EB70AE54F066A3")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.289 -0400", hash_original_field = "6D52012DCA4FC77AA554F25430AEF501", hash_generated_field = "8800B1EC4033F6ED9C1D3C210D1DF359")

        private volatile Slice slice;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.289 -0400", hash_original_method = "19F9B6A2C098797122B64953C4557260", hash_generated_method = "5B199B3E4B2B392A5F281C0027899513")
        public  CowSubList(Object[] expectedElements, int from, int to) {
            this.slice = new Slice(expectedElements, from, to);
            // ---------- Original Method ----------
            //this.slice = new Slice(expectedElements, from, to);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.289 -0400", hash_original_method = "50828BB5D9839792ECEF31A7338C6C2F", hash_generated_method = "1315692974ABBF009C95DCC6FAA8DB2B")
        @Override
        public int size() {
            Slice slice;
            slice = this.slice;
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1799530162 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1799530162;
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //return slice.to - slice.from;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.290 -0400", hash_original_method = "9FA55EF0B71DE676ACDFCDE8D001E08C", hash_generated_method = "27EDFA531F07899A2B3B69D249A1F600")
        @Override
        public boolean isEmpty() {
            Slice slice;
            slice = this.slice;
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1802298195 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1802298195;
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //return slice.from == slice.to;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.291 -0400", hash_original_method = "E9398BCB1605EBC5A566CA332DEC078B", hash_generated_method = "353C4B6432676A7615830D8BD57D291B")
        @SuppressWarnings("unchecked")
        @Override
        public E get(int index) {
            E varB4EAC82CA7396A68D541C85D26508E83_2054266920 = null; //Variable for return #1
            Slice slice;
            slice = this.slice;
            Object[] snapshot;
            snapshot = elements;
            slice.checkElementIndex(index);
            slice.checkConcurrentModification(snapshot);
            varB4EAC82CA7396A68D541C85D26508E83_2054266920 = (E) snapshot[index + slice.from];
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_2054266920.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2054266920;
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //Object[] snapshot = elements;
            //slice.checkElementIndex(index);
            //slice.checkConcurrentModification(snapshot);
            //return (E) snapshot[index + slice.from];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.292 -0400", hash_original_method = "1D00ECD22B3575A885077212162F97B2", hash_generated_method = "F0235824A604FABE796F1993758923BB")
        @Override
        public Iterator<E> iterator() {
            Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_364389323 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_364389323 = listIterator(0);
            varB4EAC82CA7396A68D541C85D26508E83_364389323.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_364389323;
            // ---------- Original Method ----------
            //return listIterator(0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.313 -0400", hash_original_method = "DF7BE0B13ABC5A9B1C74313BD06FB64C", hash_generated_method = "B0D355D239E82923F4767B7243276835")
        @Override
        public ListIterator<E> listIterator() {
            ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_1811116302 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1811116302 = listIterator(0);
            varB4EAC82CA7396A68D541C85D26508E83_1811116302.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1811116302;
            // ---------- Original Method ----------
            //return listIterator(0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.315 -0400", hash_original_method = "2453E5226E92CA007A5F28D50241AFEC", hash_generated_method = "71E4BF1EF605E2041BF81C5948905571")
        @Override
        public ListIterator<E> listIterator(int index) {
            ListIterator<E> varB4EAC82CA7396A68D541C85D26508E83_766889486 = null; //Variable for return #1
            Slice slice;
            slice = this.slice;
            Object[] snapshot;
            snapshot = elements;
            slice.checkPositionIndex(index);
            slice.checkConcurrentModification(snapshot);
            CowIterator<E> result;
            result = new CowIterator<E>(snapshot, slice.from, slice.to);
            result.index = slice.from + index;
            varB4EAC82CA7396A68D541C85D26508E83_766889486 = result;
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_766889486.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_766889486;
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //Object[] snapshot = elements;
            //slice.checkPositionIndex(index);
            //slice.checkConcurrentModification(snapshot);
            //CowIterator<E> result = new CowIterator<E>(snapshot, slice.from, slice.to);
            //result.index = slice.from + index;
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.315 -0400", hash_original_method = "3CF9433C05AE07A5EB66F121888070F6", hash_generated_method = "5EF2DD4565A5C5FC9DA15747D2976E95")
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
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1444195223 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1444195223;
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //Object[] snapshot = elements;
            //slice.checkConcurrentModification(snapshot);
            //int result = CopyOnWriteArrayList.indexOf(object, snapshot, slice.from, slice.to);
            //return (result != -1) ? (result - slice.from) : -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.318 -0400", hash_original_method = "1CFCD041D8AD8CF1B36536A28BABB7D9", hash_generated_method = "0B2B418274B5751C445F910727BC6EF8")
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
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_925843872 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_925843872;
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //Object[] snapshot = elements;
            //slice.checkConcurrentModification(snapshot);
            //int result = CopyOnWriteArrayList.lastIndexOf(object, snapshot, slice.from, slice.to);
            //return (result != -1) ? (result - slice.from) : -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.318 -0400", hash_original_method = "3D9C8519C0BA49AAEEEEE7D259DD1898", hash_generated_method = "52EE071AF39BA29D2B590033518960D2")
        @Override
        public boolean contains(Object object) {
            boolean var1CBE8A280A6EF98EBEBE6D4C530DF78D_402795660 = (indexOf(object) != -1);
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1284738567 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1284738567;
            // ---------- Original Method ----------
            //return indexOf(object) != -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.318 -0400", hash_original_method = "1CE1F4665E7580AB233B83935273A194", hash_generated_method = "CFE3BB50D155113FDFC2341E4FC4F8C4")
        @Override
        public boolean containsAll(Collection<?> collection) {
            Slice slice;
            slice = this.slice;
            Object[] snapshot;
            snapshot = elements;
            slice.checkConcurrentModification(snapshot);
            boolean var34F8E2D032BDFD9A299807B37CDBBDC9_541057672 = (CopyOnWriteArrayList.containsAll(collection, snapshot, slice.from, slice.to));
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1789352035 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1789352035;
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //Object[] snapshot = elements;
            //slice.checkConcurrentModification(snapshot);
            //return CopyOnWriteArrayList.containsAll(collection, snapshot, slice.from, slice.to);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.319 -0400", hash_original_method = "023D8E294D6742BA836A68C5ADAAB497", hash_generated_method = "D401CBBD5452CF37F544E2F633F212F0")
        @Override
        public List<E> subList(int from, int to) {
            List<E> varB4EAC82CA7396A68D541C85D26508E83_1274905030 = null; //Variable for return #1
            Slice slice;
            slice = this.slice;
            {
                boolean var8B44CCFE67682F7E890DAC0190AAF2EF_895001564 = (from < 0 || from > to || to > size());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("from=" + from + ", to=" + to +
                        ", list size=" + size());
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1274905030 = new CowSubList(slice.expectedElements, slice.from + from, slice.from + to);
            addTaint(from);
            addTaint(to);
            varB4EAC82CA7396A68D541C85D26508E83_1274905030.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1274905030;
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //if (from < 0 || from > to || to > size()) {
                //throw new IndexOutOfBoundsException("from=" + from + ", to=" + to +
                        //", list size=" + size());
            //}
            //return new CowSubList(slice.expectedElements, slice.from + from, slice.from + to);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.320 -0400", hash_original_method = "F47D7AB044AE200CBA9EE898533B8FEC", hash_generated_method = "EFCE3A0285723AD5CDE11827110DE1A3")
        @Override
        public E remove(int index) {
            E varB4EAC82CA7396A68D541C85D26508E83_1129738901 = null; //Variable for return #1
            {
                Object var0414760F989879E00EA455A9A86D73CF_1775115871 = (CopyOnWriteArrayList.this);
                {
                    slice.checkElementIndex(index);
                    slice.checkConcurrentModification(elements);
                    E removed;
                    removed = CopyOnWriteArrayList.this.remove(slice.from + index);
                    slice = new Slice(elements, slice.from, slice.to - 1);
                    varB4EAC82CA7396A68D541C85D26508E83_1129738901 = removed;
                } //End block
            } //End collapsed parenthetic
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_1129738901.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1129738901;
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //slice.checkElementIndex(index);
                //slice.checkConcurrentModification(elements);
                //E removed = CopyOnWriteArrayList.this.remove(slice.from + index);
                //slice = new Slice(elements, slice.from, slice.to - 1);
                //return removed;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.333 -0400", hash_original_method = "E7748E0E6765940072A4C93526FE4787", hash_generated_method = "BE9682510DC3033CA6442EFA77A6F239")
        @Override
        public void clear() {
            {
                Object var0414760F989879E00EA455A9A86D73CF_1001572794 = (CopyOnWriteArrayList.this);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.334 -0400", hash_original_method = "7558F5D9173C65FEAD4E275F1C1E5A80", hash_generated_method = "C19B74B1A37DC1C176DAD2A0925F5E2E")
        @Override
        public void add(int index, E object) {
            {
                Object var0414760F989879E00EA455A9A86D73CF_1343200198 = (CopyOnWriteArrayList.this);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.334 -0400", hash_original_method = "E905080D7BBE0BD2F3F279BF8EF6D6A8", hash_generated_method = "27B6AAF5D768B3C6D49F99528A04709C")
        @Override
        public boolean add(E object) {
            {
                Object var0414760F989879E00EA455A9A86D73CF_1271803018 = (CopyOnWriteArrayList.this);
                {
                    add(slice.to - slice.from, object);
                } //End block
            } //End collapsed parenthetic
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_644319076 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_644319076;
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //add(slice.to - slice.from, object);
                //return true;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.335 -0400", hash_original_method = "1293804DB9B63143F37D5D821EA6A87E", hash_generated_method = "F253EB5F8DBADCC162FE509D3F742945")
        @Override
        public boolean addAll(int index, Collection<? extends E> collection) {
            {
                Object var0414760F989879E00EA455A9A86D73CF_1007014437 = (CopyOnWriteArrayList.this);
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
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_327346371 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_327346371;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.354 -0400", hash_original_method = "2FF5E8554EDDACF9F2F627214E3BC10D", hash_generated_method = "C47263E03FE2941126E0E5B1B2179724")
        @Override
        public boolean addAll(Collection<? extends E> collection) {
            {
                Object var0414760F989879E00EA455A9A86D73CF_1963158611 = (CopyOnWriteArrayList.this);
                {
                    boolean var74E51E10D11DF48379CEFE0A325D5F6E_2109066810 = (addAll(size(), collection));
                } //End block
            } //End collapsed parenthetic
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_493675467 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_493675467;
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //return addAll(size(), collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.354 -0400", hash_original_method = "E52798445FC11575DB685349896EB8F6", hash_generated_method = "DED53FFAA09F61406F14BDECBEECF382")
        @Override
        public E set(int index, E object) {
            E varB4EAC82CA7396A68D541C85D26508E83_1468057681 = null; //Variable for return #1
            {
                Object var0414760F989879E00EA455A9A86D73CF_1576747505 = (CopyOnWriteArrayList.this);
                {
                    slice.checkElementIndex(index);
                    slice.checkConcurrentModification(elements);
                    E result;
                    result = CopyOnWriteArrayList.this.set(index + slice.from, object);
                    slice = new Slice(elements, slice.from, slice.to);
                    varB4EAC82CA7396A68D541C85D26508E83_1468057681 = result;
                } //End block
            } //End collapsed parenthetic
            addTaint(index);
            addTaint(object.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1468057681.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1468057681;
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //slice.checkElementIndex(index);
                //slice.checkConcurrentModification(elements);
                //E result = CopyOnWriteArrayList.this.set(index + slice.from, object);
                //slice = new Slice(elements, slice.from, slice.to);
                //return result;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.355 -0400", hash_original_method = "924C9E5471F08F30B8E12AD962D48DF2", hash_generated_method = "56CC33CDD1DB631C6B487F43BB21D8C0")
        @Override
        public boolean remove(Object object) {
            {
                Object var0414760F989879E00EA455A9A86D73CF_1027203820 = (CopyOnWriteArrayList.this);
                {
                    int index;
                    index = indexOf(object);
                    remove(index);
                } //End block
            } //End collapsed parenthetic
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_939410578 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_939410578;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.355 -0400", hash_original_method = "6ECA6BCBA1861C546E018F40208C7C7C", hash_generated_method = "18C667BA6B717130E61697B53DB08548")
        @Override
        public boolean removeAll(Collection<?> collection) {
            {
                Object var0414760F989879E00EA455A9A86D73CF_1992862847 = (CopyOnWriteArrayList.this);
                {
                    slice.checkConcurrentModification(elements);
                    int removed;
                    removed = removeOrRetain(collection, false, slice.from, slice.to);
                    slice = new Slice(elements, slice.from, slice.to - removed);
                } //End block
            } //End collapsed parenthetic
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_263232324 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_263232324;
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //slice.checkConcurrentModification(elements);
                //int removed = removeOrRetain(collection, false, slice.from, slice.to);
                //slice = new Slice(elements, slice.from, slice.to - removed);
                //return removed != 0;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.356 -0400", hash_original_method = "055B3FCFE954B48BD2D5F95BFF90FFFE", hash_generated_method = "8D1EAA7B9680A733CF0AC6BDCB9BA770")
        @Override
        public boolean retainAll(Collection<?> collection) {
            {
                Object var0414760F989879E00EA455A9A86D73CF_1976735880 = (CopyOnWriteArrayList.this);
                {
                    slice.checkConcurrentModification(elements);
                    int removed;
                    removed = removeOrRetain(collection, true, slice.from, slice.to);
                    slice = new Slice(elements, slice.from, slice.to - removed);
                } //End block
            } //End collapsed parenthetic
            addTaint(collection.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_41942656 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_41942656;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.364 -0400", hash_original_field = "5DBBBEFC516616C59322E114837C83FB", hash_generated_field = "578E1B95CBBB0F53A72648DE31016F3A")

        private Object[] expectedElements;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.364 -0400", hash_original_field = "D98A07F84921B24EE30F86FD8CD85C3C", hash_generated_field = "98A0E6E2AB8AB9E19CC3F35C494E6A79")

        private int from;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.364 -0400", hash_original_field = "01B6E20344B68835C5ED1DDEDF20D531", hash_generated_field = "BDB6664DDCCB6D4D52DFAB8483E3BBDE")

        private int to;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.365 -0400", hash_original_method = "83A1C0AAD9B8B03E61B8B75E1CD914D7", hash_generated_method = "6056AD1FF5F186156B93AC86A3F90BBC")
          Slice(Object[] expectedElements, int from, int to) {
            this.expectedElements = expectedElements;
            this.from = from;
            this.to = to;
            // ---------- Original Method ----------
            //this.expectedElements = expectedElements;
            //this.from = from;
            //this.to = to;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.365 -0400", hash_original_method = "C41DDBF64E4B04157ED5EDFC21AF561C", hash_generated_method = "CD2CA17E534A100BB92056382E13D4CA")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.366 -0400", hash_original_method = "D022C90E4388D47B06DB5C9D4119BF1C", hash_generated_method = "3064D546FBACD8749E7130231FBB73C7")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.366 -0400", hash_original_method = "7DF1E46EED7497F4680296245E77E1DC", hash_generated_method = "F9C340591E59B66F4BFBA6ED2CDFB0F3")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.366 -0400", hash_original_field = "C322D3DE29D2B0C5E2E011DAD5E77DF2", hash_generated_field = "FEC1DD40EAC9BB9175BC6E1CF39F3785")

        private Object[] snapshot;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.366 -0400", hash_original_field = "D98A07F84921B24EE30F86FD8CD85C3C", hash_generated_field = "98A0E6E2AB8AB9E19CC3F35C494E6A79")

        private int from;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.366 -0400", hash_original_field = "01B6E20344B68835C5ED1DDEDF20D531", hash_generated_field = "BDB6664DDCCB6D4D52DFAB8483E3BBDE")

        private int to;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.366 -0400", hash_original_field = "CB241078244A9AA790B0FC45841BA024", hash_generated_field = "AE5C9711C7D27D5EECF32B3638DBE7E5")

        private int index = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.381 -0400", hash_original_method = "E0987AFDD42E4364FE4BB0FD3F1A0501", hash_generated_method = "761C1CBB0EA0B2EE4578133FB46FB797")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.381 -0400", hash_original_method = "960DAE05B3D69FE5F79E9628DB5B33E6", hash_generated_method = "7078F39A7BE4B1A66C0E863B971864AD")
        public void add(E object) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(object.getTaint());
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.381 -0400", hash_original_method = "D639D4E7D9CD50DE4105991F3953FD80", hash_generated_method = "C1F7879EF42C54AF17F001CDB4EF71C9")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1996735663 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1996735663;
            // ---------- Original Method ----------
            //return index < to;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.382 -0400", hash_original_method = "EC30B2CF9A7B23E69047D11D06EFA3CA", hash_generated_method = "67926289AF46B038AD4DE6F7C869EDE4")
        public boolean hasPrevious() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1902106251 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1902106251;
            // ---------- Original Method ----------
            //return index > from;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.382 -0400", hash_original_method = "32D582641092A62093AF5BD2A9D350AD", hash_generated_method = "CF3656482EEB8D0CB30E263656BAAFF4")
        @SuppressWarnings("unchecked")
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_1788131874 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_1788131874 = (E) snapshot[index++];
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1788131874.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1788131874;
            // ---------- Original Method ----------
            //if (index < to) {
                //return (E) snapshot[index++];
            //} else {
                //throw new NoSuchElementException();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.388 -0400", hash_original_method = "B3E96A2468FAF72FDE35394237D3EDCC", hash_generated_method = "40DB851CA71112F6D0A8608A00BC8415")
        public int nextIndex() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1840696968 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1840696968;
            // ---------- Original Method ----------
            //return index;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.397 -0400", hash_original_method = "7AA7D7DC0436E32BBB89C3C957160D69", hash_generated_method = "BBEDEA2B012D0920BD3D09C364212248")
        @SuppressWarnings("unchecked")
        public E previous() {
            E varB4EAC82CA7396A68D541C85D26508E83_407515031 = null; //Variable for return #1
            {
                varB4EAC82CA7396A68D541C85D26508E83_407515031 = (E) snapshot[--index];
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_407515031.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_407515031;
            // ---------- Original Method ----------
            //if (index > from) {
                //return (E) snapshot[--index];
            //} else {
                //throw new NoSuchElementException();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.397 -0400", hash_original_method = "30EF9C1C05880C206BCB89722B1108E9", hash_generated_method = "D149D1A86C9D52D4F1E4DB21382B9038")
        public int previousIndex() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_823839137 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_823839137;
            // ---------- Original Method ----------
            //return index - 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.398 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "BD0416D7797F4CCA5C01710103DCE99D")
        public void remove() {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.398 -0400", hash_original_method = "1001E1C2B2FD09C7DE97126421AC0A91", hash_generated_method = "F7AE59885F055C425C0440CAC4D1CE97")
        public void set(E object) {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            addTaint(object.getTaint());
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:56.398 -0400", hash_original_field = "CB0A5E07D474346F2427954305CE9572", hash_generated_field = "7D8A16739AEFE5D33A952E311F270AA5")

    private static long serialVersionUID = 8673264195747942595L;
}

