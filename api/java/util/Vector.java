package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;






public class Vector<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable {

    /**
     * This method was extracted to encourage VM to inline callers.
     * TODO: when we have a VM that can actually inline, move the test in here too!
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:55.737 -0500", hash_original_method = "9B7D3F2F980E3EB6087A253589224152", hash_generated_method = "241DB74A7C1A3F403B28B3142CB5207F")
    private static ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException(int index, int size) {
        throw new ArrayIndexOutOfBoundsException(size, index);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:55.690 -0500", hash_original_field = "5935DD24AA8693898A933569EC7C6CB5", hash_generated_field = "39DE62F55D74BDCEA57CB029AC7D9C53")


    private static final long serialVersionUID = -2767605614048989439L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:55.694 -0500", hash_original_field = "6C149789F0A7E32E47B3C38C0FFD610C", hash_generated_field = "F9EDE767CC2D62732638F03DE92C8707")


    private static final int DEFAULT_SIZE = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:55.691 -0500", hash_original_field = "BF84735BCD9327FC2D1CC927ED35945D", hash_generated_field = "499A2D73243CED99A42E214D64505A6C")

    protected int elementCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:55.692 -0500", hash_original_field = "67BBD4B95E990052FBB9600D15E343A4", hash_generated_field = "0B3F426A5758654DA42168DCEAA2747C")

    protected Object[] elementData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:55.693 -0500", hash_original_field = "889865FA0F0C3F87B19387BF7C2B7B95", hash_generated_field = "C57732C85DED3048B8128B9506ED7293")

    protected int capacityIncrement;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.768 -0400", hash_original_method = "DACE16FEA3F29475D20FB4F2AE2C4BF3", hash_generated_method = "F92FDEEA28BC7E4B901A0A343D42232D")
    public  Vector() {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.768 -0400", hash_original_method = "516F631FEB27C4B8AC76BAFF727DB150", hash_generated_method = "F3CDA2715564D8E8516468F487D83DFA")
    public  Vector(int capacity) {
        addTaint(capacity);
        requestCapacity(capacity);

        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.769 -0400", hash_original_method = "B35B3D540AE265DD802702BED4157C47", hash_generated_method = "BF9A3C0BA660B360DF1D292D1829D8E7")
    public  Vector(int capacity, int capacityIncrement) {
        if(capacity < 0)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_962100488 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_962100488.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_962100488;
        } //End block
        requestCapacity(capacity);
        this.capacityIncrement = capacityIncrement;
        // ---------- Original Method ----------
        //if (capacity < 0) {
            //throw new IllegalArgumentException();
        //}
        //elementData = newElementArray(capacity);
        //elementCount = 0;
        //this.capacityIncrement = capacityIncrement;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.770 -0400", hash_original_method = "5554DADF2588E03BDCF1E2168D3E3C3F", hash_generated_method = "AB91ED40A9838270A2ED5EA6CEA47583")
    public  Vector(Collection<? extends E> collection) {
        super.addAll(collection);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.781 -0400", hash_original_method = "A5163E0F34F09A3D8DEA4C412903D1D1", hash_generated_method = "A227B57D2FB30D770C2C72C2E445FBFD")
    public synchronized void addElement(E object) {
        add(object);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.781 -0400", hash_original_method = "DD1AE1F8EA98D3605FDD193E0651B9D6", hash_generated_method = "7262DE01DC95807F0A43071764ECEBC7")
    public synchronized int capacity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2115132097 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2115132097;
        // ---------- Original Method ----------
        //return elementData.length;
    }
        
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.782 -0400", hash_original_method = "1610A6C93F0D6F1C66DC0DFCBD33D1B2", hash_generated_method = "B1E43A5F6043F01F2CC8B48FFF7ADD88")
    @Override
    @SuppressWarnings("unchecked")
        public synchronized Object clone() {

            if (DroidSafeAndroidRuntime.control)
            {
                AssertionError assertionException = new AssertionError(new CloneNotSupportedException());
                assertionException.addTaint(taint);
                throw assertionException;
            } //End block

            Vector<E> vector = new Vector<E>(capacity);
            vector.addAll(this);
            vector.addTaint(getTaint());
            return vector;

            // ---------- Original Method ----------
            //try {
            //Vector<E> vector = (Vector<E>) super.clone();
            //vector.elementData = elementData.clone();
            //return vector;
            //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
            //}
        }

   
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.784 -0400", hash_original_method = "9FCD2BB7391A67913F5DC5B0A38C9668", hash_generated_method = "ABCEE675B5AABD0DFD2EE89ECE981656")
    public synchronized void copyInto(Object[] elements) {

        super.clear();
        for (int i = 0; i < elements.length; i++) {
            addTaint(elements[i].getTaint());
            add((E)elements[i]);
        }
        // ---------- Original Method ----------
        //System.arraycopy(elementData, 0, elements, 0, elementCount);
    }

    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.947 -0400", hash_original_method = "3CA02A8FB0EDF4F6C1F1F261516DC679", hash_generated_method = "332C428346B2A785B67C0F0C561271B3")
    @SuppressWarnings("unchecked")
    public synchronized E elementAt(int location) {
        if(location < size())        
        {
            return getElementAt(location);
        } //End block

        addTaint(location);
        ArrayIndexOutOfBoundsException varC4E99290A8E221CD17D3A059991A865D_386874881 = arrayIndexOutOfBoundsException(location, elementCount);
        varC4E99290A8E221CD17D3A059991A865D_386874881.addTaint(taint);
        throw varC4E99290A8E221CD17D3A059991A865D_386874881;
        // ---------- Original Method ----------
        //if (location < elementCount) {
            //return (E) elementData[location];
        //}
        //throw arrayIndexOutOfBoundsException(location, elementCount);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.800 -0400", hash_original_method = "B6E84DE201AAEF8307F5E7CA8A6AEF90", hash_generated_method = "3394A8B949040FA17A0B7582B856E695")
    public Enumeration<E> elements() {
        return getEnumeration();
       // ---------- Original Method ----------
        //return new Enumeration<E>() {
            //int pos = 0;
            //public boolean hasMoreElements() {
                //return pos < elementCount;
            //}
            //@SuppressWarnings("unchecked")
            //public E nextElement() {
                //synchronized (Vector.this) {
                    //if (pos < elementCount) {
                        //return (E) elementData[pos++];
                    //}
                //}
                //throw new NoSuchElementException();
            //}
        //};
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.801 -0400", hash_original_method = "DF06508A0F0ED83B84FE34EF6D5FCD26", hash_generated_method = "742A353D3915ECCD250517FD19695D0A")
    public synchronized void ensureCapacity(int minimumCapacity) {
        addTaint(minimumCapacity);
        requestCapacity(minimumCapacity);
        // ---------- Original Method ----------
        //if (elementData.length < minimumCapacity) {
            //int next = (capacityIncrement <= 0 ? elementData.length
                    //: capacityIncrement)
                    //+ elementData.length;
            //grow(minimumCapacity > next ? minimumCapacity : next);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.801 -0400", hash_original_method = "18CA94477F381022C117A5BE2C4C7154", hash_generated_method = "4C2D7C68945F209C93ED4EC720F3912B")
    @Override
    public synchronized boolean equals(Object object) {
        return isEqualTo(object);
        // ---------- Original Method ----------
        //if (this == object) {
            //return true;
        //}
        //if (object instanceof List) {
            //List<?> list = (List<?>) object;
            //if (list.size() != elementCount) {
                //return false;
            //}
            //int index = 0;
            //Iterator<?> it = list.iterator();
            //while (it.hasNext()) {
                //Object e1 = elementData[index++], e2 = it.next();
                //if (!(e1 == null ? e2 == null : e1.equals(e2))) {
                    //return false;
                //}
            //}
            //return true;
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.802 -0400", hash_original_method = "D89343B924D76ED75CDC4E663D066F77", hash_generated_method = "8A79F7DF07987B16DC761699141B59D7")
    @SuppressWarnings("unchecked")
    public synchronized E firstElement() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        return getFirstElement();
        
        // ---------- Original Method ----------
        //if (elementCount > 0) {
            //return (E) elementData[0];
        //}
        //throw new NoSuchElementException();
    }

    /**
     * Returns an integer hash code for the receiver. Objects which are equal
     * return the same value for this method.
     *
     * @return the receiver's hash.
     * @see #equals
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:55.720 -0500", hash_original_method = "20A64E7812064C08C37EDD86F8A561DF", hash_generated_method = "E03AFB35E1AB6EEEE84CD19F72F0EB38")
    @Override
public synchronized int hashCode() {
        int result = 1;
        for (int i = 0; i < elementCount; i++) {
            result = (31 * result)
                    + (elementData[i] == null ? 0 : elementData[i].hashCode());
        }
        return result;
    }

        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.805 -0400", hash_original_method = "24750353DFD7303BB9261ABCF2B08CBF", hash_generated_method = "2A2E2AB039FE45D1C4871E0EB007D7DF")
    public synchronized int indexOf(Object object, int location) {
        addTaint(location);
        addTaint(object.getTaint());
        return super.getLastIndexOf(object, location);
        
        // ---------- Original Method ----------
        //if (object != null) {
            //for (int i = location; i < elementCount; i++) {
                //if (object.equals(elementData[i])) {
                    //return i;
                //}
            //}
        //} else {
            //for (int i = location; i < elementCount; i++) {
                //if (elementData[i] == null) {
                    //return i;
                //}
            //}
        //}
        //return -1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.962 -0400", hash_original_method = "288EF4E8EFAE610E93F8F6663B1B7C8C", hash_generated_method = "C0A66FD1831034185EC522D491C92763")
    public synchronized void insertElementAt(E object, int location) {
        addElementAt(location, object);
    
        // ---------- Original Method ----------
        //if (location >= 0 && location <= elementCount) {
            //if (elementCount == elementData.length) {
                //growByOne();
            //}
            //int count = elementCount - location;
            //if (count > 0) {
                //System.arraycopy(elementData, location, elementData,
                        //location + 1, count);
            //}
            //elementData[location] = object;
            //elementCount++;
            //modCount++;
        //} else {
            //throw arrayIndexOutOfBoundsException(location, elementCount);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.813 -0400", hash_original_method = "0D33E0C5C56D3A9FC9F5E73253A3A2D0", hash_generated_method = "0A5BEC4EF52F3443321F854CCB7AB3E1")
    @Override
    public synchronized boolean isEmpty() {
        return super.isEmpty();
        // ---------- Original Method ----------
        //return elementCount == 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.813 -0400", hash_original_method = "BB5B48C89086DB15EEAE482333CC1417", hash_generated_method = "876320CD924F3782A5F64F8FF9E9BE4D")
    @SuppressWarnings("unchecked")
    public synchronized E lastElement() {
        if (DroidSafeAndroidRuntime.control)
        {
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_89226828 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_89226828.addTaint(taint);
            throw var28D00AB599969908D71F102AF992D49A_89226828;
        } //End block
        
        return super.getLastElement();
        // ---------- Original Method ----------
        //try {
            //return (E) elementData[elementCount - 1];
        //} catch (IndexOutOfBoundsException e) {
            //throw new NoSuchElementException();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.820 -0400", hash_original_method = "DAE93837888D415686D1D0DD0C8E6815", hash_generated_method = "4CC0D52AD094205C4CCF6239F4B7A605")
    public synchronized int lastIndexOf(Object object, int location) {
        if (DroidSafeAndroidRuntime.control) {
            addTaint(location);
            addTaint(object.getTaint());
            java.lang.ArrayIndexOutOfBoundsException varC4E99290A8E221CD17D3A059991A865D_827782882 = arrayIndexOutOfBoundsException(location, elementCount);
            varC4E99290A8E221CD17D3A059991A865D_827782882.addTaint(taint);
            throw varC4E99290A8E221CD17D3A059991A865D_827782882;
        }

        return getLastIndexOf(object, location);
        
        // ---------- Original Method ----------
        //if (location < elementCount) {
            //if (object != null) {
                //for (int i = location; i >= 0; i--) {
                    //if (object.equals(elementData[i])) {
                        //return i;
                    //}
                //}
            //} else {
                //for (int i = location; i >= 0; i--) {
                    //if (elementData[i] == null) {
                        //return i;
                    //}
                //}
            //}
            //return -1;
        //}
        //throw arrayIndexOutOfBoundsException(location, elementCount);
    }

        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.824 -0400", hash_original_method = "B99CB02C0986A5ACE1171E44B2E88FC0", hash_generated_method = "B1AF8F7A62BE803D9C4214E5FFF1A75D")
    public synchronized void removeAllElements() {
        clear();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.824 -0400", hash_original_method = "A6C501B9D7921F5FC1AF3EFCF61D0AD0", hash_generated_method = "E7F332CFDD1F1B8882214C1269A1F7DE")
    public synchronized boolean removeElement(Object object) {
        addTaint(object.getTaint());
        remove(object);
        return getTaintBoolean();
        
        // ---------- Original Method ----------
        //int index;
        //if ((index = indexOf(object, 0)) == -1) {
            //return false;
        //}
        //removeElementAt(index);
        //return true;
    }

    /**
     * Removes all objects from this vector that are not contained in the
     * specified collection.
     *
     * @param collection
     *            the collection of objects to retain.
     * @return {@code true} if this vector is modified, {@code false} otherwise.
     * @see #remove(Object)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:55.733 -0500", hash_original_method = "3D3F7D0269EE9A4A0E6B970CD7AB0599", hash_generated_method = "50571D3BC1ED74E3C9E79E72C232E208")
    @Override
public synchronized boolean retainAll(Collection<?> collection) {
        return super.retainAll(collection);
    }

    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.004 -0400", hash_original_method = "BE9BD0132B3B62E633B4EDB307CB7290", hash_generated_method = "EB4FEAFEFF2F9B8F2670ED49875A91C2")
    public synchronized void setElementAt(E object, int location) {
        super.setElementAt(location, object);
    }

        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.852 -0400", hash_original_method = "7F3B955AC73FEA732765CAFEDD4BC76C", hash_generated_method = "CCB086EE295D5FF0DEEB7C9BC28997E9")
    public synchronized void setSize(int length) {
        if(length < size())        
        {
            return;
        } //End block
        requestCapacity(length);
        int extra = size() - len;
        for (int i = 0; i < extra; i++) {
            add(null);
        }
        // ---------- Original Method ----------
        //if (length == elementCount) {
            //return;
        //}
        //ensureCapacity(length);
        //if (elementCount > length) {
            //Arrays.fill(elementData, length, elementCount, null);
        //}
        //elementCount = length;
        //modCount++;
    }

    
   
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.853 -0400", hash_original_method = "0DD9DB5F445E75E250BA34836212BB86", hash_generated_method = "12B603844139A5BD52EC9721C94F1CD7")
    @Override
    public synchronized String toString() {
        int size = size();
        if(size == 0)        
        {
String varAA6F5C51D397701D3E65BDD2DF6A0CE1_382590946 =             "[]";
            varAA6F5C51D397701D3E65BDD2DF6A0CE1_382590946.addTaint(taint);
            return varAA6F5C51D397701D3E65BDD2DF6A0CE1_382590946;
        } //End block
        int length = size - 1;
        StringBuilder buffer = new StringBuilder(size* 16);
        buffer.append('[');
for(int i = 0;i < length;i++)
        {
            if(getElementAt(i) == this)            
            {
                buffer.append("(this Collection)");
            } //End block
            else
            {
                buffer.append(getElementAt(i));
            } //End block
            buffer.append(", ");
        } //End block
        if(elementData[length] == this)        
        {
            buffer.append("(this Collection)");
        } //End block
        else
        {
            buffer.append(elementData[length]);
        } //End block
        buffer.append(']');
String varD03843288D33B9E1D3062E25339ECF6D_693101289 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_693101289.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_693101289;
        // ---------- Original Method ----------
        //if (elementCount == 0) {
            //return "[]";
        //}
        //int length = elementCount - 1;
        //StringBuilder buffer = new StringBuilder(elementCount * 16);
        //buffer.append('[');
        //for (int i = 0; i < length; i++) {
            //if (elementData[i] == this) {
                //buffer.append("(this Collection)");
            //} else {
                //buffer.append(elementData[i]);
            //}
            //buffer.append(", ");
        //}
        //if (elementData[length] == this) {
            //buffer.append("(this Collection)");
        //} else {
            //buffer.append(elementData[length]);
        //}
        //buffer.append(']');
        //return buffer.toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.853 -0400", hash_original_method = "FC23934C3FC3508F47E3F895F030378B", hash_generated_method = "AB706EF10710F9F57A98E4CD283E9A4E")
    public synchronized void trimToSize() {
        // ---------- Original Method ----------
        //if (elementData.length != elementCount) {
            //grow(elementCount);
        //}
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:55.744 -0500", hash_original_method = "93271132EFBEDC29196C798673AC5EE7", hash_generated_method = "D143AA14F535C1E7B75B98ADCA9EA642")
    private synchronized void writeObject(ObjectOutputStream stream)
            throws IOException {
        stream.defaultWriteObject();
    }

    @Override
    @DSModeled(DSC.SAFE)
    public E get(int location) {
        // TODO Auto-generated method stub
        return getElementAt(location);
    }
    
}

