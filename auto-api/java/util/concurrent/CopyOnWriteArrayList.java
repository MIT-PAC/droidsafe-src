package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final long serialVersionUID = 8673264195747942595L;
    private transient volatile Object[] elements;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.895 -0400", hash_original_method = "E357703A48348C8EEE9667190E563C6C", hash_generated_method = "D63ADE2B6FFB22E3F8B15A74EEE3B28D")
    @DSModeled(DSC.SAFE)
    public CopyOnWriteArrayList() {
        elements = EmptyArray.OBJECT;
        // ---------- Original Method ----------
        //elements = EmptyArray.OBJECT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.895 -0400", hash_original_method = "84AACC1E4283EC6F676E4F2CD339FC5B", hash_generated_method = "E94A74A0F09030EF253EC41E2CF6E427")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public CopyOnWriteArrayList(Collection<? extends E> collection) {
        this((E[]) collection.toArray());
        dsTaint.addTaint(collection.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.895 -0400", hash_original_method = "51C6AA63C04D903DC2F19EE7270C9A87", hash_generated_method = "42CB776D4E8F5550181765B3737A1A9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CopyOnWriteArrayList(E[] array) {
        dsTaint.addTaint(array.dsTaint);
        this.elements = Arrays.copyOf(array, array.length, Object[].class);
        // ---------- Original Method ----------
        //this.elements = Arrays.copyOf(array, array.length, Object[].class);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.896 -0400", hash_original_method = "FF2ED4DF1B70DABD1A45F755E1952592", hash_generated_method = "5D22E127D0244BA58A0892DF9D70C9FA")
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
            throw new AssertionError(e);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.896 -0400", hash_original_method = "68DC52534F60D1A5138253A79B12E67C", hash_generated_method = "399D7D733A67738BECD3511DECEF7ECE")
    @DSModeled(DSC.SAFE)
    public int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return elements.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.896 -0400", hash_original_method = "07C72EA93D8BC7AB1EE5326762E05E69", hash_generated_method = "F2B8A539DE456BC986E3752621D91887")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    public E get(int index) {
        dsTaint.addTaint(index);
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (E) elements[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.896 -0400", hash_original_method = "1274BF0858E749C3D9852E86C4A99C22", hash_generated_method = "7F22514C37555723F252E1B4C4216F12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean contains(Object o) {
        dsTaint.addTaint(o.dsTaint);
        boolean var2580C065AD3F25FA806E0EC1F5491D61_1146686190 = (indexOf(o) != -1);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return indexOf(o) != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.896 -0400", hash_original_method = "F181183DABCA5209C115C87B0BC63071", hash_generated_method = "17BB555A11B87AC30DBF08E62ADDC9F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsAll(Collection<?> collection) {
        dsTaint.addTaint(collection.dsTaint);
        Object[] snapshot;
        snapshot = elements;
        boolean varB51CD127B94D30044743FDBEC427798E_481020909 = (containsAll(collection, snapshot, 0, snapshot.length));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return containsAll(collection, snapshot, 0, snapshot.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.896 -0400", hash_original_method = "C42EED85EE25206F94CCF01E5CEAD68C", hash_generated_method = "6B24A90E95A1434E966751946DCEB460")
    static boolean containsAll(Collection<?> collection, Object[] snapshot, int from, int to) {
        for (Object o : collection) {
            if (indexOf(o, snapshot, from, to) == -1) {
                return false;
            }
        }
        return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.896 -0400", hash_original_method = "8F838DDE7B5E08714D6360ECE6328BF5", hash_generated_method = "499F5E4BFEEABC1DE8AC32ACA1FAF8C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int indexOf(E object, int from) {
        dsTaint.addTaint(object.dsTaint);
        dsTaint.addTaint(from);
        Object[] snapshot;
        snapshot = elements;
        int var3F4FFEA1DA0968D7F475C5A4D1C4F62D_1989544893 = (indexOf(object, snapshot, from, snapshot.length));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return indexOf(object, snapshot, from, snapshot.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.896 -0400", hash_original_method = "3333011450759BE4404CA7231EDCF09F", hash_generated_method = "9F42552C1FF4D423E265D4D266DD82AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int indexOf(Object object) {
        dsTaint.addTaint(object.dsTaint);
        Object[] snapshot;
        snapshot = elements;
        int varF95830349FA4633C99755E2E13FD61DA_1742283237 = (indexOf(object, snapshot, 0, snapshot.length));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return indexOf(object, snapshot, 0, snapshot.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.896 -0400", hash_original_method = "19C8A04DC3A46E49A84DF6B57E1917A9", hash_generated_method = "1AD9FE8B3ADE8E99B2832125B05791AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int lastIndexOf(E object, int to) {
        dsTaint.addTaint(to);
        dsTaint.addTaint(object.dsTaint);
        Object[] snapshot;
        snapshot = elements;
        int var044750AB099D388AF4C1D65CC717289C_2026731365 = (lastIndexOf(object, snapshot, 0, to));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return lastIndexOf(object, snapshot, 0, to);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.896 -0400", hash_original_method = "D45902A72D19AFDC170F4A4D129ABA97", hash_generated_method = "FF4A370C254E3E1110A8DE91E2D52395")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int lastIndexOf(Object object) {
        dsTaint.addTaint(object.dsTaint);
        Object[] snapshot;
        snapshot = elements;
        int var363578769FBDCE20799A418E17F6DBCF_724268135 = (lastIndexOf(object, snapshot, 0, snapshot.length));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return lastIndexOf(object, snapshot, 0, snapshot.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.896 -0400", hash_original_method = "E13DA7C33D486C9539B3B38ADEEDBA9D", hash_generated_method = "FBDF42B8B8E348FF346718696B46929D")
    @DSModeled(DSC.SAFE)
    public boolean isEmpty() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return elements.length == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.896 -0400", hash_original_method = "8AC2A236339BBBFB218E3FC5088D17DA", hash_generated_method = "60727C84452DF82CAFC5B7E6C6D33FFD")
    @DSModeled(DSC.SAFE)
    public Iterator<E> iterator() {
        Object[] snapshot;
        snapshot = elements;
        return (Iterator<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return new CowIterator<E>(snapshot, 0, snapshot.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.896 -0400", hash_original_method = "6CF42CA16C3188E71052A9A04B3E4D16", hash_generated_method = "1A3229E53528CFDC802FF52DDD6CC4F5")
    @DSModeled(DSC.SAFE)
    public ListIterator<E> listIterator(int index) {
        dsTaint.addTaint(index);
        Object[] snapshot;
        snapshot = elements;
        {
            throw new IndexOutOfBoundsException("index=" + index + ", length=" + snapshot.length);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.896 -0400", hash_original_method = "A4A3425D1D4C041DAFB5C093D1247DF1", hash_generated_method = "9AC4F62CEB376970528B18F37B26A27C")
    @DSModeled(DSC.SAFE)
    public ListIterator<E> listIterator() {
        Object[] snapshot;
        snapshot = elements;
        return (ListIterator<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //return new CowIterator<E>(snapshot, 0, snapshot.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.896 -0400", hash_original_method = "594A2D8CB57DB4B1D13107F70D453706", hash_generated_method = "4FA9D722B3C3D6F3F714CD17E79734E4")
    @DSModeled(DSC.SAFE)
    public List<E> subList(int from, int to) {
        dsTaint.addTaint(to);
        dsTaint.addTaint(from);
        Object[] snapshot;
        snapshot = elements;
        {
            throw new IndexOutOfBoundsException("from=" + from + ", to=" + to +
                    ", list size=" + snapshot.length);
        } //End block
        return (List<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object[] snapshot = elements;
        //if (from < 0 || from > to || to > snapshot.length) {
            //throw new IndexOutOfBoundsException("from=" + from + ", to=" + to +
                    //", list size=" + snapshot.length);
        //}
        //return new CowSubList(snapshot, from, to);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.896 -0400", hash_original_method = "49659221AAE3F1C0ECCE830D1E5CE8D1", hash_generated_method = "BC4F9F08DF80B6E3CE93B38E204EDB5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object[] toArray() {
        Object[] var4FA51AB8D018C0591FC7F646592FA0FD_479868133 = (elements.clone());
        return (Object[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return elements.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.897 -0400", hash_original_method = "C1E48E79962F836E76F520B2DEE3FDB8", hash_generated_method = "8225846092238ABB1FFF7FB3FC995342")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings({"unchecked","SuspiciousSystemArraycopy"})
    public <T> T[] toArray(T[] contents) {
        dsTaint.addTaint(contents.dsTaint);
        Object[] snapshot;
        snapshot = elements;
        {
            T[] var9D2B1400BED2CD429127055D368B66D8_981697882 = ((T[]) Arrays.copyOf(snapshot, snapshot.length, contents.getClass()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.897 -0400", hash_original_method = "6010CBD888F6152118D77E36B5616E02", hash_generated_method = "967D7271075B84516B6D713339A49F83")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            boolean var8E510C77A3CC00EDD5D5105BB9594676_785136510 = (this == other
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
                        boolean var6D2C6F2C90F31B26BD0BC8B4289F0FA4_74877303 = (!i.hasNext() || !Objects.equal(o, i.next()));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            boolean varCC7204A921FEC5763B81E50426A88D00_2017468972 = (!i.hasNext());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.897 -0400", hash_original_method = "5CBAD38024C40A34FCDA1A3FF083FDEC", hash_generated_method = "3173E285457E737E874D4F1084C067E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int varCAF3CD69EA8DECAF9471B49B185EF8B7_733920001 = (Arrays.hashCode(elements));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Arrays.hashCode(elements);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.897 -0400", hash_original_method = "D569C6F4ED8C88274D5F2CC2C9F6FBD2", hash_generated_method = "FC9E93B7166C2FE04097DB926E678179")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var4477C5F616D763662A9C21C4B3C26C72_15118897 = (Arrays.toString(elements));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return Arrays.toString(elements);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.897 -0400", hash_original_method = "4C47893BDB4E93647009AE85D0DD4F0A", hash_generated_method = "F41DEB8E9CFB883C65E0EE1B54BDADB4")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.897 -0400", hash_original_method = "9DD013FF12CCDC2B9301BB35B7E69B98", hash_generated_method = "C9CF301A7E6ED0F04D6F47C627B16AB6")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.897 -0400", hash_original_method = "76766E6A3193E0133903AC8237158932", hash_generated_method = "54FC37779425EE035F1F5DEA35A89EC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean addAll(Collection<? extends E> collection) {
        dsTaint.addTaint(collection.dsTaint);
        boolean var0159BD59FAEB520B52C0A163D95FA273_157040844 = (addAll(elements.length, collection));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return addAll(elements.length, collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.897 -0400", hash_original_method = "16622B391256B6F864845FABB18695E4", hash_generated_method = "37B1AB6571B6A0EF4F8C05AFEA800077")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.898 -0400", hash_original_method = "F6411BBDC5A81E1C464E9CEEEB8CCCF0", hash_generated_method = "A4A5F3769D8833E9770061505C370C56")
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
                    boolean var4BB4DD0650713F3AD6499B5BB3CF0F9C_269765384 = (indexOf(o, newElements, 0, elements.length + addedCount) == -1);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.898 -0400", hash_original_method = "17D643777423FC6042E703F36B3EB43F", hash_generated_method = "F540C6CCBEB7CF5955B3C3222BE15138")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean addIfAbsent(E object) {
        dsTaint.addTaint(object.dsTaint);
        {
            boolean var9432A920D7B842B924EF8D1C9DF16F5D_1716652312 = (contains(object));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.898 -0400", hash_original_method = "343DE0C64B38A0F7CE33FC0930F8B1CE", hash_generated_method = "BEFF5F247E8372D5EE36AF7CAB584F3C")
    @DSModeled(DSC.SAFE)
    @Override
    public synchronized void clear() {
        elements = EmptyArray.OBJECT;
        // ---------- Original Method ----------
        //elements = EmptyArray.OBJECT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.898 -0400", hash_original_method = "83ED6C7BC28A1565457859811EDD5A3A", hash_generated_method = "3E022D857C15C2F455ACA7AD58A198C3")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.898 -0400", hash_original_method = "4348B5D441F5A12C585788ED2765C3A4", hash_generated_method = "5D78A05F175BEEFCD6B8946E186F621D")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.898 -0400", hash_original_method = "1C7B7BE5468A5E30603ED6851F28BACD", hash_generated_method = "BBA3EB1011D1725FEA9D544B70966BB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean removeAll(Collection<?> collection) {
        dsTaint.addTaint(collection.dsTaint);
        boolean varB4080136E4414D738D63F3764F6FBFEE_163000109 = (removeOrRetain(collection, false, 0, elements.length) != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return removeOrRetain(collection, false, 0, elements.length) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.898 -0400", hash_original_method = "6F7BCA7B0FD040BA943A37C2A3FEA10F", hash_generated_method = "AB5494CFD4585F97E2872450FDCFFB39")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean retainAll(Collection<?> collection) {
        dsTaint.addTaint(collection.dsTaint);
        boolean var9149E6DF8FB33323D0296E3F070EADBC_230394657 = (removeOrRetain(collection, true, 0, elements.length) != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return removeOrRetain(collection, true, 0, elements.length) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.898 -0400", hash_original_method = "4C6E97480A096674EA078C65954A8FE2", hash_generated_method = "4E013830595216967DC514F50AEB290B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int removeOrRetain(Collection<?> collection, boolean retain, int from, int to) {
        dsTaint.addTaint(to);
        dsTaint.addTaint(retain);
        dsTaint.addTaint(collection.dsTaint);
        dsTaint.addTaint(from);
        {
            int i;
            i = from;
            {
                {
                    boolean varC6BA4CD1BE642A29C15190B0FCD2F50D_1194760904 = (collection.contains(elements[i]) == retain);
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
                            boolean varEA71BBF34A922A67A0C66E1F44121158_1142629606 = (collection.contains(elements[j]) == retain);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.898 -0400", hash_original_method = "DD4407442CC828B95DFD10F580DA2DDA", hash_generated_method = "2C1E9299C051E2B2A6ACAE63C3277B4F")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.898 -0400", hash_original_method = "3E2723924788C644A99252EDEC8904D6", hash_generated_method = "09BFE46F6702956BDECE9C3CAA6269B6")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.898 -0400", hash_original_method = "AE5D3DEFCCE0E3FC6EC46BC47A64D153", hash_generated_method = "55332F1BF88F2737B54A34D956F8DBAC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.898 -0400", hash_original_method = "504933ED8B334053A53FA397546C5B85", hash_generated_method = "C18CB0FE7B2EB3676356370B7238F27B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.899 -0400", hash_original_method = "223CD20A6350F975434ED49A9EB8E646", hash_generated_method = "9CDC5EF866F4A61C9B786F4C476E5DEC")
    @DSModeled(DSC.SAFE)
    final Object[] getArray() {
        return (Object[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return elements;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.899 -0400", hash_original_method = "53FDF52EC3502469838FF7FC9C3722C1", hash_generated_method = "9A4964654611810F5F524DD6BCA7D419")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.899 -0400", hash_original_method = "5D8878D7111BA02D76F457F9A02251F1", hash_generated_method = "E9B8E26B121451CD20B895299874D798")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.899 -0400", hash_original_method = "19F9B6A2C098797122B64953C4557260", hash_generated_method = "0C37DC83ABE81E79094C26D2D64BEB35")
        @DSModeled(DSC.SAFE)
        public CowSubList(Object[] expectedElements, int from, int to) {
            dsTaint.addTaint(to);
            dsTaint.addTaint(expectedElements.dsTaint);
            dsTaint.addTaint(from);
            this.slice = new Slice(expectedElements, from, to);
            // ---------- Original Method ----------
            //this.slice = new Slice(expectedElements, from, to);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.899 -0400", hash_original_method = "50828BB5D9839792ECEF31A7338C6C2F", hash_generated_method = "3183DB086DFBF727E93C17F3BF80C5FB")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.899 -0400", hash_original_method = "9FA55EF0B71DE676ACDFCDE8D001E08C", hash_generated_method = "3BE9761BE39369B56BB56C4DAF58A470")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.899 -0400", hash_original_method = "E9398BCB1605EBC5A566CA332DEC078B", hash_generated_method = "81913DDB2BC0D9E6CA3FB2D0A36BCC92")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.899 -0400", hash_original_method = "1D00ECD22B3575A885077212162F97B2", hash_generated_method = "7E87D1FA2BA237A6DAAFD25B022F599C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Iterator<E> iterator() {
            Iterator<E> var4B5B2DE28169C2BFBA180BAF54B9EB3E_1022247044 = (listIterator(0));
            return (Iterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return listIterator(0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.899 -0400", hash_original_method = "DF7BE0B13ABC5A9B1C74313BD06FB64C", hash_generated_method = "A6853348BF0628A31B25F0A52ECEA248")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public ListIterator<E> listIterator() {
            ListIterator<E> var4B5B2DE28169C2BFBA180BAF54B9EB3E_1570893553 = (listIterator(0));
            return (ListIterator<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return listIterator(0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.899 -0400", hash_original_method = "2453E5226E92CA007A5F28D50241AFEC", hash_generated_method = "471129025CE3883DBA1590B89DB8A758")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.899 -0400", hash_original_method = "3CF9433C05AE07A5EB66F121888070F6", hash_generated_method = "B8DBDDC6BD54205BFEE48C58B6484094")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.899 -0400", hash_original_method = "1CFCD041D8AD8CF1B36536A28BABB7D9", hash_generated_method = "A6459B53D9DA31C4BD109898E6B8C91D")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.899 -0400", hash_original_method = "3D9C8519C0BA49AAEEEEE7D259DD1898", hash_generated_method = "533C485CE8A64344660C4EEE55D251CC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean contains(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean var1CBE8A280A6EF98EBEBE6D4C530DF78D_1303871039 = (indexOf(object) != -1);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return indexOf(object) != -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.900 -0400", hash_original_method = "1CE1F4665E7580AB233B83935273A194", hash_generated_method = "E539A08181FD1CE97C6129BC8CE74A37")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean containsAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            Slice slice;
            slice = this.slice;
            Object[] snapshot;
            snapshot = elements;
            slice.checkConcurrentModification(snapshot);
            boolean var34F8E2D032BDFD9A299807B37CDBBDC9_1214072193 = (CopyOnWriteArrayList.containsAll(collection, snapshot, slice.from, slice.to));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //Object[] snapshot = elements;
            //slice.checkConcurrentModification(snapshot);
            //return CopyOnWriteArrayList.containsAll(collection, snapshot, slice.from, slice.to);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.900 -0400", hash_original_method = "023D8E294D6742BA836A68C5ADAAB497", hash_generated_method = "8CE0A9EE67CC69B077059AFAD2A6FAD2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public List<E> subList(int from, int to) {
            dsTaint.addTaint(to);
            dsTaint.addTaint(from);
            Slice slice;
            slice = this.slice;
            {
                boolean var8B44CCFE67682F7E890DAC0190AAF2EF_544110414 = (from < 0 || from > to || to > size());
                {
                    throw new IndexOutOfBoundsException("from=" + from + ", to=" + to +
                        ", list size=" + size());
                } //End block
            } //End collapsed parenthetic
            return (List<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Slice slice = this.slice;
            //if (from < 0 || from > to || to > size()) {
                //throw new IndexOutOfBoundsException("from=" + from + ", to=" + to +
                        //", list size=" + size());
            //}
            //return new CowSubList(slice.expectedElements, slice.from + from, slice.from + to);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.900 -0400", hash_original_method = "F47D7AB044AE200CBA9EE898533B8FEC", hash_generated_method = "FCBB3E56438398921EBC72006A14E127")
        @DSModeled(DSC.SAFE)
        @Override
        public E remove(int index) {
            dsTaint.addTaint(index);
            {
                slice.checkElementIndex(index);
                slice.checkConcurrentModification(elements);
                E removed;
                removed = CopyOnWriteArrayList.this.remove(slice.from + index);
                slice = new Slice(elements, slice.from, slice.to - 1);
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.900 -0400", hash_original_method = "E7748E0E6765940072A4C93526FE4787", hash_generated_method = "8094599FA71E828389E306B7E054CE13")
        @DSModeled(DSC.SAFE)
        @Override
        public void clear() {
            {
                slice.checkConcurrentModification(elements);
                CopyOnWriteArrayList.this.removeRange(slice.from, slice.to);
                slice = new Slice(elements, slice.from, slice.from);
            } //End block
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //slice.checkConcurrentModification(elements);
                //CopyOnWriteArrayList.this.removeRange(slice.from, slice.to);
                //slice = new Slice(elements, slice.from, slice.from);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.900 -0400", hash_original_method = "7558F5D9173C65FEAD4E275F1C1E5A80", hash_generated_method = "7A19EBD54C127B80319AFACC1BA36113")
        @DSModeled(DSC.SAFE)
        @Override
        public void add(int index, E object) {
            dsTaint.addTaint(index);
            dsTaint.addTaint(object.dsTaint);
            {
                slice.checkPositionIndex(index);
                slice.checkConcurrentModification(elements);
                CopyOnWriteArrayList.this.add(index + slice.from, object);
                slice = new Slice(elements, slice.from, slice.to + 1);
            } //End block
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //slice.checkPositionIndex(index);
                //slice.checkConcurrentModification(elements);
                //CopyOnWriteArrayList.this.add(index + slice.from, object);
                //slice = new Slice(elements, slice.from, slice.to + 1);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.900 -0400", hash_original_method = "E905080D7BBE0BD2F3F279BF8EF6D6A8", hash_generated_method = "335D772188B2B1B2D14D62D2452083B8")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean add(E object) {
            dsTaint.addTaint(object.dsTaint);
            {
                add(slice.to - slice.from, object);
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //add(slice.to - slice.from, object);
                //return true;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.900 -0400", hash_original_method = "1293804DB9B63143F37D5D821EA6A87E", hash_generated_method = "328B96109FE94AFB04C23E358A0A32E1")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean addAll(int index, Collection<? extends E> collection) {
            dsTaint.addTaint(index);
            dsTaint.addTaint(collection.dsTaint);
            {
                slice.checkPositionIndex(index);
                slice.checkConcurrentModification(elements);
                int oldSize;
                oldSize = elements.length;
                boolean result;
                result = CopyOnWriteArrayList.this.addAll(index + slice.from, collection);
                slice = new Slice(elements, slice.from, slice.to + (elements.length - oldSize));
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.900 -0400", hash_original_method = "2FF5E8554EDDACF9F2F627214E3BC10D", hash_generated_method = "ADA9B26126C11F1A3DA65D23E4FFDAC5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean addAll(Collection<? extends E> collection) {
            dsTaint.addTaint(collection.dsTaint);
            {
                boolean varF1B61C2D490EA0DB75D24249FD7599AB_758702447 = (addAll(size(), collection));
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //return addAll(size(), collection);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.900 -0400", hash_original_method = "E52798445FC11575DB685349896EB8F6", hash_generated_method = "1315B8AB5A704012FD2B57EFE802B6B2")
        @DSModeled(DSC.SAFE)
        @Override
        public E set(int index, E object) {
            dsTaint.addTaint(index);
            dsTaint.addTaint(object.dsTaint);
            {
                slice.checkElementIndex(index);
                slice.checkConcurrentModification(elements);
                E result;
                result = CopyOnWriteArrayList.this.set(index + slice.from, object);
                slice = new Slice(elements, slice.from, slice.to);
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.900 -0400", hash_original_method = "924C9E5471F08F30B8E12AD962D48DF2", hash_generated_method = "227BFE5AA199124227E72FA7677A0B68")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean remove(Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                int index;
                index = indexOf(object);
                remove(index);
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.901 -0400", hash_original_method = "6ECA6BCBA1861C546E018F40208C7C7C", hash_generated_method = "A7C2E4F59BCA0AFF628E4A20C7F01B67")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean removeAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            {
                slice.checkConcurrentModification(elements);
                int removed;
                removed = removeOrRetain(collection, false, slice.from, slice.to);
                slice = new Slice(elements, slice.from, slice.to - removed);
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //synchronized (CopyOnWriteArrayList.this) {
                //slice.checkConcurrentModification(elements);
                //int removed = removeOrRetain(collection, false, slice.from, slice.to);
                //slice = new Slice(elements, slice.from, slice.to - removed);
                //return removed != 0;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.901 -0400", hash_original_method = "055B3FCFE954B48BD2D5F95BFF90FFFE", hash_generated_method = "5F1769FDD287ACEA1F0C192C5D7D181D")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean retainAll(Collection<?> collection) {
            dsTaint.addTaint(collection.dsTaint);
            {
                slice.checkConcurrentModification(elements);
                int removed;
                removed = removeOrRetain(collection, true, slice.from, slice.to);
                slice = new Slice(elements, slice.from, slice.to - removed);
            } //End block
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
        private final Object[] expectedElements;
        private final int from;
        private final int to;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.901 -0400", hash_original_method = "83A1C0AAD9B8B03E61B8B75E1CD914D7", hash_generated_method = "B18B0BD3D2604336AB7F7905B2471600")
        @DSModeled(DSC.SAFE)
         Slice(Object[] expectedElements, int from, int to) {
            dsTaint.addTaint(to);
            dsTaint.addTaint(expectedElements.dsTaint);
            dsTaint.addTaint(from);
            // ---------- Original Method ----------
            //this.expectedElements = expectedElements;
            //this.from = from;
            //this.to = to;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.901 -0400", hash_original_method = "C41DDBF64E4B04157ED5EDFC21AF561C", hash_generated_method = "D450F34EC6A3074202F5E739713AE158")
        @DSModeled(DSC.SAFE)
         void checkElementIndex(int index) {
            dsTaint.addTaint(index);
            {
                throw new IndexOutOfBoundsException("index=" + index + ", size=" + (to - from));
            } //End block
            // ---------- Original Method ----------
            //if (index < 0 || index >= to - from) {
                //throw new IndexOutOfBoundsException("index=" + index + ", size=" + (to - from));
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.901 -0400", hash_original_method = "D022C90E4388D47B06DB5C9D4119BF1C", hash_generated_method = "45D56F6CD9E8FC4B5A10E99499EB6FC4")
        @DSModeled(DSC.SAFE)
         void checkPositionIndex(int index) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(index);
            {
                throw new IndexOutOfBoundsException("index=" + index + ", size=" + (to - from));
            } //End block
            // ---------- Original Method ----------
            //if (index < 0 || index > to - from) {
                //throw new IndexOutOfBoundsException("index=" + index + ", size=" + (to - from));
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.901 -0400", hash_original_method = "7DF1E46EED7497F4680296245E77E1DC", hash_generated_method = "A001A228B1CC103245533736CCCD858C")
        @DSModeled(DSC.SAFE)
         void checkConcurrentModification(Object[] snapshot) {
            dsTaint.addTaint(snapshot.dsTaint);
            {
                throw new ConcurrentModificationException();
            } //End block
            // ---------- Original Method ----------
            //if (expectedElements != snapshot) {
                //throw new ConcurrentModificationException();
            //}
        }

        
    }


    
    static class CowIterator<E> implements ListIterator<E> {
        private final Object[] snapshot;
        private final int from;
        private final int to;
        private int index = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.901 -0400", hash_original_method = "E0987AFDD42E4364FE4BB0FD3F1A0501", hash_generated_method = "930CB690E6382C9824BC9D3F4BB8FFDA")
        @DSModeled(DSC.SAFE)
         CowIterator(Object[] snapshot, int from, int to) {
            dsTaint.addTaint(to);
            dsTaint.addTaint(snapshot.dsTaint);
            dsTaint.addTaint(from);
            // ---------- Original Method ----------
            //this.snapshot = snapshot;
            //this.from = from;
            //this.to = to;
            //this.index = from;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.901 -0400", hash_original_method = "960DAE05B3D69FE5F79E9628DB5B33E6", hash_generated_method = "C353DF914B3C202A81272AA8BE8767A9")
        @DSModeled(DSC.SAFE)
        public void add(E object) {
            dsTaint.addTaint(object.dsTaint);
            throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.901 -0400", hash_original_method = "D639D4E7D9CD50DE4105991F3953FD80", hash_generated_method = "AC1078C3D69482EF0DE171CC27D69ACA")
        @DSModeled(DSC.SAFE)
        public boolean hasNext() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return index < to;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.901 -0400", hash_original_method = "EC30B2CF9A7B23E69047D11D06EFA3CA", hash_generated_method = "FDD922D0A9BA29918970F0088CCA57A2")
        @DSModeled(DSC.SAFE)
        public boolean hasPrevious() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return index > from;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.901 -0400", hash_original_method = "32D582641092A62093AF5BD2A9D350AD", hash_generated_method = "CD8D6BEE47DFC1494C11DD900D4D6D25")
        @DSModeled(DSC.SAFE)
        @SuppressWarnings("unchecked")
        public E next() {
            {
                throw new NoSuchElementException();
            } //End block
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (index < to) {
                //return (E) snapshot[index++];
            //} else {
                //throw new NoSuchElementException();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.901 -0400", hash_original_method = "B3E96A2468FAF72FDE35394237D3EDCC", hash_generated_method = "ECDF75713DB0929A62B319F0DE35441A")
        @DSModeled(DSC.SAFE)
        public int nextIndex() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return index;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.901 -0400", hash_original_method = "7AA7D7DC0436E32BBB89C3C957160D69", hash_generated_method = "D6FED054F4E1716B3F35C1785B460F00")
        @DSModeled(DSC.SAFE)
        @SuppressWarnings("unchecked")
        public E previous() {
            {
                throw new NoSuchElementException();
            } //End block
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (index > from) {
                //return (E) snapshot[--index];
            //} else {
                //throw new NoSuchElementException();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.901 -0400", hash_original_method = "30EF9C1C05880C206BCB89722B1108E9", hash_generated_method = "1A6C709E9DFD7440B4E8DD42AD1C3D8E")
        @DSModeled(DSC.SAFE)
        public int previousIndex() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return index - 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.901 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "70F9650B41A870182901E546A7AB0548")
        @DSModeled(DSC.SAFE)
        public void remove() {
            throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.901 -0400", hash_original_method = "1001E1C2B2FD09C7DE97126421AC0A91", hash_generated_method = "407DC9884DC828DE269C69F873AF453E")
        @DSModeled(DSC.SAFE)
        public void set(E object) {
            dsTaint.addTaint(object.dsTaint);
            throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
    }


    
}


