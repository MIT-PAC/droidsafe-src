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
    private transient volatile Object[] elements;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.475 -0400", hash_original_method = "E357703A48348C8EEE9667190E563C6C", hash_generated_method = "B97966364BBED793B94DBEEDDFBF1B8C")
    @DSModeled(DSC.SAFE)
    public CopyOnWriteArrayList() {
        elements = EmptyArray.OBJECT;
        // ---------- Original Method ----------
        //elements = EmptyArray.OBJECT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.475 -0400", hash_original_method = "84AACC1E4283EC6F676E4F2CD339FC5B", hash_generated_method = "9672FF5330EBE8D0BED3F59811949E52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public CopyOnWriteArrayList(Collection<? extends E> collection) {
        this((E[]) collection.toArray());
        dsTaint.addTaint(collection.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.475 -0400", hash_original_method = "51C6AA63C04D903DC2F19EE7270C9A87", hash_generated_method = "A6FF49CA056E775A2BE8AFE6D2B2925D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CopyOnWriteArrayList(E[] array) {
        dsTaint.addTaint(array[0].dsTaint);
        this.elements = Arrays.copyOf(array, array.length, Object[].class);
        // ---------- Original Method ----------
        //this.elements = Arrays.copyOf(array, array.length, Object[].class);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.475 -0400", hash_original_method = "FF2ED4DF1B70DABD1A45F755E1952592", hash_generated_method = "7D11B57ADF8090B12B924A1C32699FD7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        try 
        {
            CopyOnWriteArrayList result;
            result = (CopyOnWriteArrayList) super.clone();
            result.elements = result.elements.clone();
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //CopyOnWriteArrayList result = (CopyOnWriteArrayList) super.clone();
            //result.elements = result.elements.clone();
            //return result;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.476 -0400", hash_original_method = "68DC52534F60D1A5138253A79B12E67C", hash_generated_method = "17A6CB66CD4A11CC2BDCD44871F87B1E")
    @DSModeled(DSC.SAFE)
    public int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return elements.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.476 -0400", hash_original_method = "07C72EA93D8BC7AB1EE5326762E05E69", hash_generated_method = "D28349E1E14B22A7429BE6FDC3AFF6EC")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    public E get(int index) {
        dsTaint.addTaint(index);
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (E) elements[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.476 -0400", hash_original_method = "1274BF0858E749C3D9852E86C4A99C22", hash_generated_method = "8A62866968C816AEFF3842C3562BBFB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean contains(Object o) {
        dsTaint.addTaint(o.dsTaint);
        boolean var2580C065AD3F25FA806E0EC1F5491D61_1257389077 = (indexOf(o) != -1);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return indexOf(o) != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.476 -0400", hash_original_method = "F181183DABCA5209C115C87B0BC63071", hash_generated_method = "125B0F0F2CE304B232E7C70317831554")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsAll(Collection<?> collection) {
        dsTaint.addTaint(collection.dsTaint);
        Object[] snapshot;
        snapshot = elements;
        boolean varB51CD127B94D30044743FDBEC427798E_1035951908 = (containsAll(collection, snapshot, 0, snapshot.length));
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.476 -0400", hash_original_method = "8F838DDE7B5E08714D6360ECE6328BF5", hash_generated_method = "CC6DD82325FF081870E1CE93184EECCF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int indexOf(E object, int from) {
        dsTaint.addTaint(from);
        dsTaint.addTaint(object.dsTaint);
        Object[] snapshot;
        snapshot = elements;
        int var3F4FFEA1DA0968D7F475C5A4D1C4F62D_1743292393 = (indexOf(object, snapshot, from, snapshot.length));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return indexOf(object, snapshot, from, snapshot.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.477 -0400", hash_original_method = "3333011450759BE4404CA7231EDCF09F", hash_generated_method = "13A93648C5295A3A18561CBE1662FF62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int indexOf(Object object) {
        dsTaint.addTaint(object.dsTaint);
        Object[] snapshot;
        snapshot = elements;
        int varF95830349FA4633C99755E2E13FD61DA_1578207952 = (indexOf(object, snapshot, 0, snapshot.length));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return indexOf(object, snapshot, 0, snapshot.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.477 -0400", hash_original_method = "19C8A04DC3A46E49A84DF6B57E1917A9", hash_generated_method = "252E65C829DD8C642CA01761D3077AEF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int lastIndexOf(E object, int to) {
        dsTaint.addTaint(to);
        dsTaint.addTaint(object.dsTaint);
        Object[] snapshot;
        snapshot = elements;
        int var044750AB099D388AF4C1D65CC717289C_2022838443 = (lastIndexOf(object, snapshot, 0, to));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return lastIndexOf(object, snapshot, 0, to);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.477 -0400", hash_original_method = "D45902A72D19AFDC170F4A4D129ABA97", hash_generated_method = "375D4AE389DE5C6916DF69AEF7D9ADB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int lastIndexOf(Object object) {
        dsTaint.addTaint(object.dsTaint);
        Object[] snapshot;
        snapshot = elements;
        int var363578769FBDCE20799A418E17F6DBCF_636356020 = (lastIndexOf(object, snapshot, 0, snapshot.length));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return lastIndexOf(object, snapshot, 0, snapshot.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.477 -0400", hash_original_method = "E13DA7C33D486C9539B3B38ADEEDBA9D", hash_generated_method = "9C3BDBBB8EF22750FDADB55AB60C5B19")
    @DSModeled(DSC.SAFE)
    public boolean isEmpty() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return elements.length == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.477 -0400", hash_original_method = "8AC2A236339BBBFB218E3FC5088D17DA", hash_generated_method = "DC9B83892FC21C2E30B9D101EEBF79A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Iterator<E> iterator() {
        Object[] snapshot;
        snapshot = elements;
        Iterator<E> var0F7C069E76AE742995465696BD11FA8B_1704714668 = (new CowIterator<E>(snapshot, 0, snapshot.length));
        return (Iterator<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return new CowIterator<E>(snapshot, 0, snapshot.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.478 -0400", hash_original_method = "6CF42CA16C3188E71052A9A04B3E4D16", hash_generated_method = "6632234BCC7371435DCA6A3EFFA4F09A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ListIterator<E> listIterator(int index) {
        dsTaint.addTaint(index);
        Object[] snapshot;
        snapshot = elements;
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("index=" + index + ", length=" + snapshot.length);
        } //End block
        CowIterator<E> result;
        result = new CowIterator<E>(snapshot, 0, snapshot.length);
        result.index = index;
        return (ListIterator<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //if (index < 0 || index > snapshot.length) {
            //throw new IndexOutOfBoundsException("index=" + index + ", length=" + snapshot.length);
        //}
        //CowIterator<E> result = new CowIterator<E>(snapshot, 0, snapshot.length);
        //result.index = index;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.478 -0400", hash_original_method = "A4A3425D1D4C041DAFB5C093D1247DF1", hash_generated_method = "532414281BC919B8199F9EBAE224B229")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ListIterator<E> listIterator() {
        Object[] snapshot;
        snapshot = elements;
        ListIterator<E> var0F7C069E76AE742995465696BD11FA8B_673385872 = (new CowIterator<E>(snapshot, 0, snapshot.length));
        return (ListIterator<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return new CowIterator<E>(snapshot, 0, snapshot.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.478 -0400", hash_original_method = "594A2D8CB57DB4B1D13107F70D453706", hash_generated_method = "F1D47323F133CCD27FBF40CC3F7E3A53")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<E> subList(int from, int to) {
        dsTaint.addTaint(to);
        dsTaint.addTaint(from);
        Object[] snapshot;
        snapshot = elements;
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("from=" + from + ", to=" + to +
                    ", list size=" + snapshot.length);
        } //End block
        List<E> varF8A91220E4B463D713284C9F80ED3DFE_754570552 = (new CowSubList(snapshot, from, to));
        return (List<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //if (from < 0 || from > to || to > snapshot.length) {
            //throw new IndexOutOfBoundsException("from=" + from + ", to=" + to +
                    //", list size=" + snapshot.length);
        //}
        //return new CowSubList(snapshot, from, to);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.478 -0400", hash_original_method = "49659221AAE3F1C0ECCE830D1E5CE8D1", hash_generated_method = "91A0617B0776D094F5B34266022F17B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object[] toArray() {
        Object[] var4FA51AB8D018C0591FC7F646592FA0FD_1623992762 = (elements.clone());
        return (Object[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return elements.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.479 -0400", hash_original_method = "C1E48E79962F836E76F520B2DEE3FDB8", hash_generated_method = "3FAFAAC4ABA1B193022E188F5F583D0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings({"unchecked","SuspiciousSystemArraycopy"})
    public <T> T[] toArray(T[] contents) {
        dsTaint.addTaint(contents[0].dsTaint);
        Object[] snapshot;
        snapshot = elements;
        {
            T[] var9D2B1400BED2CD429127055D368B66D8_56933576 = ((T[]) Arrays.copyOf(snapshot, snapshot.length, contents.getClass()));
        } //End block
        System.arraycopy(snapshot, 0, contents, 0, snapshot.length);
        {
            contents[snapshot.length] = null;
        } //End block
        return (T[])dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.483 -0400", hash_original_method = "6010CBD888F6152118D77E36B5616E02", hash_generated_method = "853F496CAC636A5FA1A9B65AA6812689")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            boolean var8E510C77A3CC00EDD5D5105BB9594676_1556235746 = (this == other
                    || Arrays.equals(elements, ((CopyOnWriteArrayList<?>) other).elements));
        } //End block
        {
            Object[] snapshot;
            snapshot = elements;
            Iterator<?> i;
            i = ((List<?>) other).iterator();
            {
                Object o = snapshot[0];
                {
                    {
                        boolean var6D2C6F2C90F31B26BD0BC8B4289F0FA4_908517010 = (!i.hasNext() || !Objects.equal(o, i.next()));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            boolean varCC7204A921FEC5763B81E50426A88D00_721855173 = (!i.hasNext());
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.484 -0400", hash_original_method = "5CBAD38024C40A34FCDA1A3FF083FDEC", hash_generated_method = "35637A13A3CA754F917B98271E92064A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int varCAF3CD69EA8DECAF9471B49B185EF8B7_1517691607 = (Arrays.hashCode(elements));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Arrays.hashCode(elements);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.484 -0400", hash_original_method = "D569C6F4ED8C88274D5F2CC2C9F6FBD2", hash_generated_method = "33BE41EC0E3A8E6100BCF46D86ED955C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var4477C5F616D763662A9C21C4B3C26C72_541512049 = (Arrays.toString(elements));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return Arrays.toString(elements);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.484 -0400", hash_original_method = "4C47893BDB4E93647009AE85D0DD4F0A", hash_generated_method = "FE12036E0B25FB8602D847EFC9A63F9D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean add(E e) {
        dsTaint.addTaint(e.dsTaint);
        Object[] newElements;
        newElements = new Object[elements.length + 1];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        newElements[elements.length] = e;
        elements = newElements;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Object[] newElements = new Object[elements.length + 1];
        //System.arraycopy(elements, 0, newElements, 0, elements.length);
        //newElements[elements.length] = e;
        //elements = newElements;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.485 -0400", hash_original_method = "9DD013FF12CCDC2B9301BB35B7E69B98", hash_generated_method = "59DC8471202C6AE66659536F719D53D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void add(int index, E e) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(e.dsTaint);
        Object[] newElements;
        newElements = new Object[elements.length + 1];
        System.arraycopy(elements, 0, newElements, 0, index);
        newElements[index] = e;
        System.arraycopy(elements, index, newElements, index + 1, elements.length - index);
        elements = newElements;
        // ---------- Original Method ----------
        //Object[] newElements = new Object[elements.length + 1];
        //System.arraycopy(elements, 0, newElements, 0, index);
        //newElements[index] = e;
        //System.arraycopy(elements, index, newElements, index + 1, elements.length - index);
        //elements = newElements;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.485 -0400", hash_original_method = "76766E6A3193E0133903AC8237158932", hash_generated_method = "93685D3F350AF494E5BCABE1B833A226")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean addAll(Collection<? extends E> collection) {
        dsTaint.addTaint(collection.dsTaint);
        boolean var0159BD59FAEB520B52C0A163D95FA273_572024686 = (addAll(elements.length, collection));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return addAll(elements.length, collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.485 -0400", hash_original_method = "16622B391256B6F864845FABB18695E4", hash_generated_method = "ABB07E758FF6F5028C996AF749F1E558")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean addAll(int index, Collection<? extends E> collection) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(collection.dsTaint);
        Object[] toAdd;
        toAdd = collection.toArray();
        Object[] newElements;
        newElements = new Object[elements.length + toAdd.length];
        System.arraycopy(elements, 0, newElements, 0, index);
        System.arraycopy(toAdd, 0, newElements, index, toAdd.length);
        System.arraycopy(elements, index,
                newElements, index + toAdd.length, elements.length - index);
        elements = newElements;
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.490 -0400", hash_original_method = "F6411BBDC5A81E1C464E9CEEEB8CCCF0", hash_generated_method = "3F8AF73CFA672EF321D13D9AF73BF3C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int addAllAbsent(Collection<? extends E> collection) {
        dsTaint.addTaint(collection.dsTaint);
        Object[] toAdd;
        toAdd = collection.toArray();
        Object[] newElements;
        newElements = new Object[elements.length + toAdd.length];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        int addedCount;
        addedCount = 0;
        {
            Object o = toAdd[0];
            {
                {
                    boolean var4BB4DD0650713F3AD6499B5BB3CF0F9C_743930086 = (indexOf(o, newElements, 0, elements.length + addedCount) == -1);
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
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.491 -0400", hash_original_method = "17D643777423FC6042E703F36B3EB43F", hash_generated_method = "A49749D2D51DF10CAC0E7BD0D5E0B882")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean addIfAbsent(E object) {
        dsTaint.addTaint(object.dsTaint);
        {
            boolean var9432A920D7B842B924EF8D1C9DF16F5D_340010351 = (contains(object));
        } //End collapsed parenthetic
        add(object);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (contains(object)) {
            //return false;
        //}
        //add(object);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.491 -0400", hash_original_method = "343DE0C64B38A0F7CE33FC0930F8B1CE", hash_generated_method = "0DD0CCA634A11D0B8559FCC328E0AB07")
    @DSModeled(DSC.SAFE)
    @Override
    public synchronized void clear() {
        elements = EmptyArray.OBJECT;
        // ---------- Original Method ----------
        //elements = EmptyArray.OBJECT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.491 -0400", hash_original_method = "83ED6C7BC28A1565457859811EDD5A3A", hash_generated_method = "8153390BE5A3917C77D50EC1FF1A7F3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized E remove(int index) {
        dsTaint.addTaint(index);
        @SuppressWarnings("unchecked") E removed;
        removed = (E) elements[index];
        removeRange(index, index + 1);
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //@SuppressWarnings("unchecked")
        //E removed = (E) elements[index];
        //removeRange(index, index + 1);
        //return removed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.491 -0400", hash_original_method = "4348B5D441F5A12C585788ED2765C3A4", hash_generated_method = "8AE400D4D1A4A464BA030D93E13405DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean remove(Object o) {
        dsTaint.addTaint(o.dsTaint);
        int index;
        index = indexOf(o);
        remove(index);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int index = indexOf(o);
        //if (index == -1) {
            //return false;
        //}
        //remove(index);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.491 -0400", hash_original_method = "1C7B7BE5468A5E30603ED6851F28BACD", hash_generated_method = "8029BE2706E7A44AFDC69CDCA15E0A37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean removeAll(Collection<?> collection) {
        dsTaint.addTaint(collection.dsTaint);
        boolean varB4080136E4414D738D63F3764F6FBFEE_1059069621 = (removeOrRetain(collection, false, 0, elements.length) != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return removeOrRetain(collection, false, 0, elements.length) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.492 -0400", hash_original_method = "6F7BCA7B0FD040BA943A37C2A3FEA10F", hash_generated_method = "3D5AFB3C4265723277C05BDE91E27F38")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean retainAll(Collection<?> collection) {
        dsTaint.addTaint(collection.dsTaint);
        boolean var9149E6DF8FB33323D0296E3F070EADBC_1981531992 = (removeOrRetain(collection, true, 0, elements.length) != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return removeOrRetain(collection, true, 0, elements.length) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.492 -0400", hash_original_method = "4C6E97480A096674EA078C65954A8FE2", hash_generated_method = "95B1150EBBCBF6FCDCE459664E5CC807")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int removeOrRetain(Collection<?> collection, boolean retain, int from, int to) {
        dsTaint.addTaint(to);
        dsTaint.addTaint(retain);
        dsTaint.addTaint(from);
        dsTaint.addTaint(collection.dsTaint);
        {
            int i;
            i = from;
            {
                {
                    boolean varC6BA4CD1BE642A29C15190B0FCD2F50D_1747989643 = (collection.contains(elements[i]) == retain);
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
                            boolean varEA71BBF34A922A67A0C66E1F44121158_1865664356 = (collection.contains(elements[j]) == retain);
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
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.492 -0400", hash_original_method = "DD4407442CC828B95DFD10F580DA2DDA", hash_generated_method = "F42062E049639B6F9533CC3CA1300A92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized E set(int index, E e) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(e.dsTaint);
        Object[] newElements;
        newElements = elements.clone();
        @SuppressWarnings("unchecked") E result;
        result = (E) newElements[index];
        newElements[index] = e;
        elements = newElements;
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object[] newElements = elements.clone();
        //@SuppressWarnings("unchecked")
        //E result = (E) newElements[index];
        //newElements[index] = e;
        //elements = newElements;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.493 -0400", hash_original_method = "3E2723924788C644A99252EDEC8904D6", hash_generated_method = "54B1D8F1D49EB1B8E7F34A2E16C0F653")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void removeRange(int from, int to) {
        dsTaint.addTaint(to);
        dsTaint.addTaint(from);
        Object[] newElements;
        newElements = new Object[elements.length - (to - from)];
        System.arraycopy(elements, 0, newElements, 0, from);
        System.arraycopy(elements, to, newElements, from, elements.length - to);
        elements = newElements;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.493 -0400", hash_original_method = "223CD20A6350F975434ED49A9EB8E646", hash_generated_method = "D82C34F86403AE1DC209730148B39D5B")
    @DSModeled(DSC.SAFE)
    final Object[] getArray() {
        return (Object[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return elements;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.496 -0400", hash_original_method = "53FDF52EC3502469838FF7FC9C3722C1", hash_generated_method = "47F404DDE88DE4C8F613B02D5025F701")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(ObjectOutputStream out) throws IOException {
        dsTaint.addTaint(out.dsTaint);
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
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //out.defaultWriteObject();
        //out.writeInt(snapshot.length);
        //for (Object o : snapshot) {
            //out.writeObject(o);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.497 -0400", hash_original_method = "5D8878D7111BA02D76F457F9A02251F1", hash_generated_method = "9EF9E30F7C71E6E0BA4F758A85363D3A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        dsTaint.addTaint(in.dsTaint);
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
        // ---------- Original Method ----------
        //in.defaultReadObject();
        //Object[] snapshot = new Object[in.readInt()];
        //for (int i = 0; i < snapshot.length; i++) {
            //snapshot[i] = in.readObject();
        //}
        //elements = snapshot;
    }

    
    class CowSubList extends AbstractList<E> {
        private volatile Slice slice;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.497 -0400", hash_original_method = "19F9B6A2C098797122B64953C4557260", hash_generated_method = "F64E108B943660F315811EED9F40CD18")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CowSubList(Object[] expectedElements, int from, int to) {
            dsTaint.addTaint(to);
            dsTaint.addTaint(expectedElements[0].dsTaint);
            dsTaint.addTaint(from);
            this.slice = new Slice(expectedElements, from, to);
            // ---------- Original Method ----------
            //this.slice = new Slice(expectedElements, from, to);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.497 -0400", hash_original_method = "50828BB5D9839792ECEF31A7338C6C2F", hash_generated_method = "08BEAF9D25162AC95DC9881B68FBC600")
        @DSModeled(DSC.SAFE)
        @Override
        public int size() {
            Slice slice;
            slice = this.slice;
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //return slice.to - slice.from;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.497 -0400", hash_original_method = "9FA55EF0B71DE676ACDFCDE8D001E08C", hash_generated_method = "C595560E6BB725EDF645ADD1D52F727A")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean isEmpty() {
            Slice slice;
            slice = this.slice;
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //return slice.from == slice.to;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.498 -0400", hash_original_method = "E9398BCB1605EBC5A566CA332DEC078B", hash_generated_method = "DC2B72E059DFE11A34E7D79C41BE3202")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings("unchecked")
        @Override
        public E get(int index) {
            dsTaint.addTaint(index);
            Slice slice;
            slice = this.slice;
            Object[] snapshot;
            snapshot = elements;
            slice.checkElementIndex(index);
            slice.checkConcurrentModification(snapshot);
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //Object[] snapshot = elements;
            //slice.checkElementIndex(index);
            //slice.checkConcurrentModification(snapshot);
            //return (E) snapshot[index + slice.from];
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.498 -0400", hash_original_method = "1D00ECD22B3575A885077212162F97B2", hash_generated_method = "548769E8D6F110BB31A18E66CBBC2421")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Iterator<E> iterator() {
            Iterator<E> var4B5B2DE28169C2BFBA180BAF54B9EB3E_2144237014 = (listIterator(0));
            return (Iterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return listIterator(0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.498 -0400", hash_original_method = "DF7BE0B13ABC5A9B1C74313BD06FB64C", hash_generated_method = "65BBE2FEB70FEEA760564D1EC3F2A2C2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public ListIterator<E> listIterator() {
            ListIterator<E> var4B5B2DE28169C2BFBA180BAF54B9EB3E_1551149118 = (listIterator(0));
            return (ListIterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return listIterator(0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.498 -0400", hash_original_method = "2453E5226E92CA007A5F28D50241AFEC", hash_generated_method = "1917EE7FE1B33696D775A4B15648684E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public ListIterator<E> listIterator(int index) {
            dsTaint.addTaint(index);
            Slice slice;
            slice = this.slice;
            Object[] snapshot;
            snapshot = elements;
            slice.checkPositionIndex(index);
            slice.checkConcurrentModification(snapshot);
            CowIterator<E> result;
            result = new CowIterator<E>(snapshot, slice.from, slice.to);
            result.index = slice.from + index;
            return (ListIterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //Object[] snapshot = elements;
            //slice.checkPositionIndex(index);
            //slice.checkConcurrentModification(snapshot);
            //CowIterator<E> result = new CowIterator<E>(snapshot, slice.from, slice.to);
            //result.index = slice.from + index;
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.498 -0400", hash_original_method = "3CF9433C05AE07A5EB66F121888070F6", hash_generated_method = "9908453F6ADBBFC508E0DBA0FEE441A5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int indexOf(Object object) {
            dsTaint.addTaint(object.dsTaint);
            Slice slice;
            slice = this.slice;
            Object[] snapshot;
            snapshot = elements;
            slice.checkConcurrentModification(snapshot);
            int result;
            result = CopyOnWriteArrayList.indexOf(object, snapshot, slice.from, slice.to);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //Object[] snapshot = elements;
            //slice.checkConcurrentModification(snapshot);
            //int result = CopyOnWriteArrayList.indexOf(object, snapshot, slice.from, slice.to);
            //return (result != -1) ? (result - slice.from) : -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.499 -0400", hash_original_method = "1CFCD041D8AD8CF1B36536A28BABB7D9", hash_generated_method = "066F0CF7C72461737EA759E6BFCCE512")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int lastIndexOf(Object object) {
            dsTaint.addTaint(object.dsTaint);
            Slice slice;
            slice = this.slice;
            Object[] snapshot;
            snapshot = elements;
            slice.checkConcurrentModification(snapshot);
            int result;
            result = CopyOnWriteArrayList.lastIndexOf(object, snapshot, slice.from, slice.to);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //Object[] snapshot = elements;
            //slice.checkConcurrentModification(snapshot);
            //int result = CopyOnWriteArrayList.lastIndexOf(object, snapshot, slice.from, slice.to);
            //return (result != -1) ? (result - slice.from) : -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.499 -0400", hash_original_method = "3D9C8519C0BA49AAEEEEE7D259DD1898", hash_generated_method = "CDF9654A76A9250A35D28610E2C6B7A1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean contains(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean var1CBE8A280A6EF98EBEBE6D4C530DF78D_427831896 = (indexOf(object) != -1);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return indexOf(object) != -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.499 -0400", hash_original_method = "1CE1F4665E7580AB233B83935273A194", hash_generated_method = "8F681224CED0A9580CED2651AA69C017")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            Slice slice;
            slice = this.slice;
            Object[] snapshot;
            snapshot = elements;
            slice.checkConcurrentModification(snapshot);
            boolean var34F8E2D032BDFD9A299807B37CDBBDC9_501354656 = (CopyOnWriteArrayList.containsAll(collection, snapshot, slice.from, slice.to));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //Object[] snapshot = elements;
            //slice.checkConcurrentModification(snapshot);
            //return CopyOnWriteArrayList.containsAll(collection, snapshot, slice.from, slice.to);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.499 -0400", hash_original_method = "023D8E294D6742BA836A68C5ADAAB497", hash_generated_method = "AC6A0CFD21F57291CC5CDAC3923CA154")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public List<E> subList(int from, int to) {
            dsTaint.addTaint(to);
            dsTaint.addTaint(from);
            Slice slice;
            slice = this.slice;
            {
                boolean var8B44CCFE67682F7E890DAC0190AAF2EF_1664877714 = (from < 0 || from > to || to > size());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("from=" + from + ", to=" + to +
                        ", list size=" + size());
                } //End block
            } //End collapsed parenthetic
            List<E> varBE6DB08C0CDDA47511EA19175DC189CD_324591680 = (new CowSubList(slice.expectedElements, slice.from + from, slice.from + to));
            return (List<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //if (from < 0 || from > to || to > size()) {
                //throw new IndexOutOfBoundsException("from=" + from + ", to=" + to +
                        //", list size=" + size());
            //}
            //return new CowSubList(slice.expectedElements, slice.from + from, slice.from + to);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.500 -0400", hash_original_method = "F47D7AB044AE200CBA9EE898533B8FEC", hash_generated_method = "038A3BE9493323943B8490B2B98FF74D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E remove(int index) {
            dsTaint.addTaint(index);
            {
                Object var0414760F989879E00EA455A9A86D73CF_1848715072 = (CopyOnWriteArrayList.this);
                {
                    slice.checkElementIndex(index);
                    slice.checkConcurrentModification(elements);
                    E removed;
                    removed = CopyOnWriteArrayList.this.remove(slice.from + index);
                    slice = new Slice(elements, slice.from, slice.to - 1);
                } //End block
            } //End collapsed parenthetic
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //slice.checkElementIndex(index);
                //slice.checkConcurrentModification(elements);
                //E removed = CopyOnWriteArrayList.this.remove(slice.from + index);
                //slice = new Slice(elements, slice.from, slice.to - 1);
                //return removed;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.500 -0400", hash_original_method = "E7748E0E6765940072A4C93526FE4787", hash_generated_method = "129D20CAE26C9E3BA68B321B3B1D01DD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void clear() {
            {
                Object var0414760F989879E00EA455A9A86D73CF_62160263 = (CopyOnWriteArrayList.this);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.500 -0400", hash_original_method = "7558F5D9173C65FEAD4E275F1C1E5A80", hash_generated_method = "009DF9CEE1FF4E6AD671DCC664A9AA92")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void add(int index, E object) {
            dsTaint.addTaint(index);
            dsTaint.addTaint(object.dsTaint);
            {
                Object var0414760F989879E00EA455A9A86D73CF_234054765 = (CopyOnWriteArrayList.this);
                {
                    slice.checkPositionIndex(index);
                    slice.checkConcurrentModification(elements);
                    CopyOnWriteArrayList.this.add(index + slice.from, object);
                    slice = new Slice(elements, slice.from, slice.to + 1);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //slice.checkPositionIndex(index);
                //slice.checkConcurrentModification(elements);
                //CopyOnWriteArrayList.this.add(index + slice.from, object);
                //slice = new Slice(elements, slice.from, slice.to + 1);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.501 -0400", hash_original_method = "E905080D7BBE0BD2F3F279BF8EF6D6A8", hash_generated_method = "5EAEFE54602179BD00458787FD0CD357")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean add(E object) {
            dsTaint.addTaint(object.dsTaint);
            {
                Object var0414760F989879E00EA455A9A86D73CF_865390411 = (CopyOnWriteArrayList.this);
                {
                    add(slice.to - slice.from, object);
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //add(slice.to - slice.from, object);
                //return true;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.501 -0400", hash_original_method = "1293804DB9B63143F37D5D821EA6A87E", hash_generated_method = "9D6687C9C4E5BABEE8A7162914F1925A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean addAll(int index, Collection<? extends E> collection) {
            dsTaint.addTaint(index);
            dsTaint.addTaint(collection.dsTaint);
            {
                Object var0414760F989879E00EA455A9A86D73CF_2125335399 = (CopyOnWriteArrayList.this);
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
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.501 -0400", hash_original_method = "2FF5E8554EDDACF9F2F627214E3BC10D", hash_generated_method = "9F894D3554339DA6794C09ED8DC90BC7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean addAll(Collection<? extends E> collection) {
            dsTaint.addTaint(collection.dsTaint);
            {
                Object var0414760F989879E00EA455A9A86D73CF_1621523932 = (CopyOnWriteArrayList.this);
                {
                    boolean var74E51E10D11DF48379CEFE0A325D5F6E_1772412653 = (addAll(size(), collection));
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //return addAll(size(), collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.502 -0400", hash_original_method = "E52798445FC11575DB685349896EB8F6", hash_generated_method = "BF45167F4E574A2D452CCD19D0E96EFF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public E set(int index, E object) {
            dsTaint.addTaint(index);
            dsTaint.addTaint(object.dsTaint);
            {
                Object var0414760F989879E00EA455A9A86D73CF_1686888100 = (CopyOnWriteArrayList.this);
                {
                    slice.checkElementIndex(index);
                    slice.checkConcurrentModification(elements);
                    E result;
                    result = CopyOnWriteArrayList.this.set(index + slice.from, object);
                    slice = new Slice(elements, slice.from, slice.to);
                } //End block
            } //End collapsed parenthetic
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //slice.checkElementIndex(index);
                //slice.checkConcurrentModification(elements);
                //E result = CopyOnWriteArrayList.this.set(index + slice.from, object);
                //slice = new Slice(elements, slice.from, slice.to);
                //return result;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.502 -0400", hash_original_method = "924C9E5471F08F30B8E12AD962D48DF2", hash_generated_method = "5134C63D06EFCE2ECCCF6A88FCC9ABE9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean remove(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                Object var0414760F989879E00EA455A9A86D73CF_1762461640 = (CopyOnWriteArrayList.this);
                {
                    int index;
                    index = indexOf(object);
                    remove(index);
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.503 -0400", hash_original_method = "6ECA6BCBA1861C546E018F40208C7C7C", hash_generated_method = "536602DC0F7889C004333ACDEB1D1A8C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean removeAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            {
                Object var0414760F989879E00EA455A9A86D73CF_85168371 = (CopyOnWriteArrayList.this);
                {
                    slice.checkConcurrentModification(elements);
                    int removed;
                    removed = removeOrRetain(collection, false, slice.from, slice.to);
                    slice = new Slice(elements, slice.from, slice.to - removed);
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //slice.checkConcurrentModification(elements);
                //int removed = removeOrRetain(collection, false, slice.from, slice.to);
                //slice = new Slice(elements, slice.from, slice.to - removed);
                //return removed != 0;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.504 -0400", hash_original_method = "055B3FCFE954B48BD2D5F95BFF90FFFE", hash_generated_method = "AF7BA7CBD25079EB15F8FCECDF73E2EE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean retainAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            {
                Object var0414760F989879E00EA455A9A86D73CF_2084175105 = (CopyOnWriteArrayList.this);
                {
                    slice.checkConcurrentModification(elements);
                    int removed;
                    removed = removeOrRetain(collection, true, slice.from, slice.to);
                    slice = new Slice(elements, slice.from, slice.to - removed);
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
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
        private Object[] expectedElements;
        private int from;
        private int to;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.504 -0400", hash_original_method = "83A1C0AAD9B8B03E61B8B75E1CD914D7", hash_generated_method = "91F8465BBA417CAC79119E7546CEE9CB")
        @DSModeled(DSC.SAFE)
         Slice(Object[] expectedElements, int from, int to) {
            dsTaint.addTaint(to);
            dsTaint.addTaint(expectedElements[0].dsTaint);
            dsTaint.addTaint(from);
            // ---------- Original Method ----------
            //this.expectedElements = expectedElements;
            //this.from = from;
            //this.to = to;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.504 -0400", hash_original_method = "C41DDBF64E4B04157ED5EDFC21AF561C", hash_generated_method = "2B6F47A76437F2BE5043CC5E5E618410")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void checkElementIndex(int index) {
            dsTaint.addTaint(index);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("index=" + index + ", size=" + (to - from));
            } //End block
            // ---------- Original Method ----------
            //if (index < 0 || index >= to - from) {
                //throw new IndexOutOfBoundsException("index=" + index + ", size=" + (to - from));
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.505 -0400", hash_original_method = "D022C90E4388D47B06DB5C9D4119BF1C", hash_generated_method = "33F5DEA2964B1DFBBD15B853C7A4890B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void checkPositionIndex(int index) {
            dsTaint.addTaint(index);
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("index=" + index + ", size=" + (to - from));
            } //End block
            // ---------- Original Method ----------
            //if (index < 0 || index > to - from) {
                //throw new IndexOutOfBoundsException("index=" + index + ", size=" + (to - from));
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.505 -0400", hash_original_method = "7DF1E46EED7497F4680296245E77E1DC", hash_generated_method = "1B2E94A7F61187CB2AAD5AD6233BC5F8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         void checkConcurrentModification(Object[] snapshot) {
            dsTaint.addTaint(snapshot[0].dsTaint);
            {
                if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            } //End block
            // ---------- Original Method ----------
            //if (expectedElements != snapshot) {
                //throw new ConcurrentModificationException();
            //}
        }

        
    }


    
    static class CowIterator<E> implements ListIterator<E> {
        private Object[] snapshot;
        private int from;
        private int to;
        private int index = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.505 -0400", hash_original_method = "E0987AFDD42E4364FE4BB0FD3F1A0501", hash_generated_method = "BBED0BA15606D33AAA20DD02E8967B23")
        @DSModeled(DSC.SAFE)
         CowIterator(Object[] snapshot, int from, int to) {
            dsTaint.addTaint(to);
            dsTaint.addTaint(snapshot[0].dsTaint);
            dsTaint.addTaint(from);
            // ---------- Original Method ----------
            //this.snapshot = snapshot;
            //this.from = from;
            //this.to = to;
            //this.index = from;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.505 -0400", hash_original_method = "960DAE05B3D69FE5F79E9628DB5B33E6", hash_generated_method = "DFB086FCFDFE85E8C965B69A6B2B4337")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void add(E object) {
            dsTaint.addTaint(object.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.505 -0400", hash_original_method = "D639D4E7D9CD50DE4105991F3953FD80", hash_generated_method = "BBC8D7E78600D0E22338846F6AFE813C")
        @DSModeled(DSC.SAFE)
        public boolean hasNext() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return index < to;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.506 -0400", hash_original_method = "EC30B2CF9A7B23E69047D11D06EFA3CA", hash_generated_method = "AE4F5B4753B6FFE4C2AB9718DCFCD83C")
        @DSModeled(DSC.SAFE)
        public boolean hasPrevious() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return index > from;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.506 -0400", hash_original_method = "32D582641092A62093AF5BD2A9D350AD", hash_generated_method = "6369C3B3F22D338CA9337E5EC8ADBEE3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings("unchecked")
        public E next() {
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (index < to) {
                //return (E) snapshot[index++];
            //} else {
                //throw new NoSuchElementException();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.506 -0400", hash_original_method = "B3E96A2468FAF72FDE35394237D3EDCC", hash_generated_method = "3E16B3FCEDCEADD2E65E95850FD83815")
        @DSModeled(DSC.SAFE)
        public int nextIndex() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return index;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.506 -0400", hash_original_method = "7AA7D7DC0436E32BBB89C3C957160D69", hash_generated_method = "76E98CD05CE30869DD69E794DBCA80EC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings("unchecked")
        public E previous() {
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            } //End block
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (index > from) {
                //return (E) snapshot[--index];
            //} else {
                //throw new NoSuchElementException();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.506 -0400", hash_original_method = "30EF9C1C05880C206BCB89722B1108E9", hash_generated_method = "BD77A65265904F922E96FF6BDF9D424E")
        @DSModeled(DSC.SAFE)
        public int previousIndex() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return index - 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.506 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "BD0416D7797F4CCA5C01710103DCE99D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void remove() {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.506 -0400", hash_original_method = "1001E1C2B2FD09C7DE97126421AC0A91", hash_generated_method = "C00FCAABE7C3D5B9F6C6928CD2F7AB6C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void set(E object) {
            dsTaint.addTaint(object.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
    }


    
    private static final long serialVersionUID = 8673264195747942595L;
}

