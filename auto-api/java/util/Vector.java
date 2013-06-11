package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;

public class Vector<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable {
    private static final long serialVersionUID = -2767605614048989439L;
    protected int elementCount;
    protected Object[] elementData;
    protected int capacityIncrement;
    private static final int DEFAULT_SIZE = 10;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.357 -0400", hash_original_method = "DACE16FEA3F29475D20FB4F2AE2C4BF3", hash_generated_method = "10E122AABD4BAA9CC6C06A14EE57BEB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Vector() {
        this(DEFAULT_SIZE, 0);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.357 -0400", hash_original_method = "516F631FEB27C4B8AC76BAFF727DB150", hash_generated_method = "F852116105E115C6E98F0478EDAA0935")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Vector(int capacity) {
        this(capacity, 0);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.357 -0400", hash_original_method = "B35B3D540AE265DD802702BED4157C47", hash_generated_method = "26B995DDDB90CA58D8809311631CBE85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Vector(int capacity, int capacityIncrement) {
        dsTaint.addTaint(capacityIncrement);
        dsTaint.addTaint(capacity);
        {
            throw new IllegalArgumentException();
        } //End block
        elementData = newElementArray(capacity);
        elementCount = 0;
        // ---------- Original Method ----------
        //if (capacity < 0) {
            //throw new IllegalArgumentException();
        //}
        //elementData = newElementArray(capacity);
        //elementCount = 0;
        //this.capacityIncrement = capacityIncrement;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.357 -0400", hash_original_method = "5554DADF2588E03BDCF1E2168D3E3C3F", hash_generated_method = "20936B002E3A5C222966A18C1BBCBEAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Vector(Collection<? extends E> collection) {
        this(collection.size(), 0);
        dsTaint.addTaint(collection.dsTaint);
        Iterator<? extends E> it;
        it = collection.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1399689266 = (it.hasNext());
            {
                elementData[elementCount++] = it.next();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Iterator<? extends E> it = collection.iterator();
        //while (it.hasNext()) {
            //elementData[elementCount++] = it.next();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.358 -0400", hash_original_method = "088E691065B085AAA9856C71AD537C28", hash_generated_method = "7A3D5E3273EA70764A5D460E4F9EB5E8")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    private E[] newElementArray(int size) {
        dsTaint.addTaint(size);
        return (E[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (E[]) new Object[size];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.358 -0400", hash_original_method = "48191DBEFAEF26CE3AD2676469C6C588", hash_generated_method = "B2F62B6F909E5956CD2F4AFC23447392")
    @DSModeled(DSC.SAFE)
    @Override
    public void add(int location, E object) {
        dsTaint.addTaint(location);
        dsTaint.addTaint(object.dsTaint);
        insertElementAt(object, location);
        // ---------- Original Method ----------
        //insertElementAt(object, location);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.358 -0400", hash_original_method = "4A1B135502A4FBF53B5971ADD0895265", hash_generated_method = "072A79EDC69C35819231BECB00983B15")
    @DSModeled(DSC.SAFE)
    @Override
    public synchronized boolean add(E object) {
        dsTaint.addTaint(object.dsTaint);
        {
            growByOne();
        } //End block
        elementData[elementCount++] = object;
        modCount++;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (elementCount == elementData.length) {
            //growByOne();
        //}
        //elementData[elementCount++] = object;
        //modCount++;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.358 -0400", hash_original_method = "721C95E0B3ACA6F09AE8F219EA79313F", hash_generated_method = "9F8B834A982B48F815D5BF7D1F1D2677")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized boolean addAll(int location, Collection<? extends E> collection) {
        dsTaint.addTaint(location);
        dsTaint.addTaint(collection.dsTaint);
        {
            int size;
            size = collection.size();
            int required;
            required = size - (elementData.length - elementCount);
            {
                growBy(required);
            } //End block
            int count;
            count = elementCount - location;
            {
                System.arraycopy(elementData, location, elementData, location
                        + size, count);
            } //End block
            Iterator<? extends E> it;
            it = collection.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_646445796 = (it.hasNext());
                {
                    elementData[location++] = it.next();
                } //End block
            } //End collapsed parenthetic
            elementCount += size;
            modCount++;
        } //End block
        throw arrayIndexOutOfBoundsException(location, elementCount);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.358 -0400", hash_original_method = "936868945967E6EE9BEE2301A3FC2D7D", hash_generated_method = "B3D12395D5B9B7E68E4B3B438460FD60")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized boolean addAll(Collection<? extends E> collection) {
        dsTaint.addTaint(collection.dsTaint);
        boolean var03502A2162BCCC449AB5D23C58C8227A_1740614291 = (addAll(elementCount, collection));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return addAll(elementCount, collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.358 -0400", hash_original_method = "A5163E0F34F09A3D8DEA4C412903D1D1", hash_generated_method = "77DDD3AE770FA4E3E45CE2BC8EE79013")
    @DSModeled(DSC.SAFE)
    public synchronized void addElement(E object) {
        dsTaint.addTaint(object.dsTaint);
        {
            growByOne();
        } //End block
        elementData[elementCount++] = object;
        modCount++;
        // ---------- Original Method ----------
        //if (elementCount == elementData.length) {
            //growByOne();
        //}
        //elementData[elementCount++] = object;
        //modCount++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.358 -0400", hash_original_method = "DD1AE1F8EA98D3605FDD193E0651B9D6", hash_generated_method = "F7CEECB06C683D98416276D1D784ED03")
    @DSModeled(DSC.SAFE)
    public synchronized int capacity() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return elementData.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.358 -0400", hash_original_method = "1F4E1B041EF06199B18000DD20E283A1", hash_generated_method = "6D4767BD5AC25EDD665607C67F0AB50F")
    @DSModeled(DSC.SAFE)
    @Override
    public void clear() {
        removeAllElements();
        // ---------- Original Method ----------
        //removeAllElements();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.358 -0400", hash_original_method = "1610A6C93F0D6F1C66DC0DFCBD33D1B2", hash_generated_method = "E3E00A865C8D5167BC826F54A2D80F5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    @SuppressWarnings("unchecked")
    public synchronized Object clone() {
        try 
        {
            Vector<E> vector;
            vector = (Vector<E>) super.clone();
            vector.elementData = elementData.clone();
        } //End block
        catch (CloneNotSupportedException e)
        {
            throw new AssertionError(e);
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //Vector<E> vector = (Vector<E>) super.clone();
            //vector.elementData = elementData.clone();
            //return vector;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.358 -0400", hash_original_method = "4017403066D0A85EBF82EC88CFE4ED84", hash_generated_method = "C3CE99A74A05D624F0E15C7C901AE344")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean contains(Object object) {
        dsTaint.addTaint(object.dsTaint);
        boolean varFC609B1C0AB8A3A126012E7353465119_1118310622 = (indexOf(object, 0) != -1);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return indexOf(object, 0) != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.358 -0400", hash_original_method = "51334898ABB14C1CD821FC4FE1B2383C", hash_generated_method = "BC8DBC2A2396577A7E145EE2B670A959")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized boolean containsAll(Collection<?> collection) {
        dsTaint.addTaint(collection.dsTaint);
        boolean varF935A9EEA803E51431822CE5207F3376_921363749 = (super.containsAll(collection));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return super.containsAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.358 -0400", hash_original_method = "9FCD2BB7391A67913F5DC5B0A38C9668", hash_generated_method = "983DF9FF0EC47A1F3B14EF07E1E8724B")
    @DSModeled(DSC.SAFE)
    public synchronized void copyInto(Object[] elements) {
        dsTaint.addTaint(elements.dsTaint);
        System.arraycopy(elementData, 0, elements, 0, elementCount);
        // ---------- Original Method ----------
        //System.arraycopy(elementData, 0, elements, 0, elementCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.358 -0400", hash_original_method = "3CA02A8FB0EDF4F6C1F1F261516DC679", hash_generated_method = "839C7AB19923A4F946FD3ACA59B9C380")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    public synchronized E elementAt(int location) {
        dsTaint.addTaint(location);
        throw arrayIndexOutOfBoundsException(location, elementCount);
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (location < elementCount) {
            //return (E) elementData[location];
        //}
        //throw arrayIndexOutOfBoundsException(location, elementCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.358 -0400", hash_original_method = "B6E84DE201AAEF8307F5E7CA8A6AEF90", hash_generated_method = "4884238FC1DB4CEA8D4CF9DF30D068FB")
    @DSModeled(DSC.SAFE)
    public Enumeration<E> elements() {
        return (Enumeration<E>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.359 -0400", hash_original_method = "DF06508A0F0ED83B84FE34EF6D5FCD26", hash_generated_method = "00F58D2B7A3B03258FE968D0278A26E8")
    @DSModeled(DSC.SAFE)
    public synchronized void ensureCapacity(int minimumCapacity) {
        dsTaint.addTaint(minimumCapacity);
        {
            int next;
            next = (capacityIncrement <= 0 ? elementData.length
                    : capacityIncrement)
                    + elementData.length;//DSFIXME:  CODE0008: Nested ternary operator in expression
            grow(minimumCapacity > next ? minimumCapacity : next);
        } //End block
        // ---------- Original Method ----------
        //if (elementData.length < minimumCapacity) {
            //int next = (capacityIncrement <= 0 ? elementData.length
                    //: capacityIncrement)
                    //+ elementData.length;
            //grow(minimumCapacity > next ? minimumCapacity : next);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.359 -0400", hash_original_method = "18CA94477F381022C117A5BE2C4C7154", hash_generated_method = "C8E79A6F90C0A9C133ADE88517D30795")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        {
            List<?> list;
            list = (List<?>) object;
            {
                boolean var87DA8CDCBC1CCBE821948EA1C5E2BC78_376593663 = (list.size() != elementCount);
            } //End collapsed parenthetic
            int index;
            index = 0;
            Iterator<?> it;
            it = list.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_66964942 = (it.hasNext());
                {
                    Object e1, e2;
                    e1 = elementData[index++];
                    e2 = it.next();
                    {
                        boolean var340C63FF299BF53687C9CFA16F96F134_763035861 = (!(e1 == null ? e2 == null : e1.equals(e2))); //DSFIXME:  CODE0008: Nested ternary operator in expression
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.359 -0400", hash_original_method = "D89343B924D76ED75CDC4E663D066F77", hash_generated_method = "3A08663B76385599C9B080050FBD601A")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    public synchronized E firstElement() {
        throw new NoSuchElementException();
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (elementCount > 0) {
            //return (E) elementData[0];
        //}
        //throw new NoSuchElementException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.359 -0400", hash_original_method = "E09D80C19A651BF8C26D5375E71CA6A0", hash_generated_method = "52E88337722008DD889E3E20AF1E215B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public E get(int location) {
        dsTaint.addTaint(location);
        E var3385AE87BC6AA9BFE91788D456EB4B04_488019308 = (elementAt(location));
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return elementAt(location);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.359 -0400", hash_original_method = "B022A84D94038C9BB0C01ED819C072BD", hash_generated_method = "7A69111E13BEADFC6DD1D248F0D04381")
    @DSModeled(DSC.SAFE)
    private void grow(int newCapacity) {
        dsTaint.addTaint(newCapacity);
        E[] newData;
        newData = newElementArray(newCapacity);
        System.arraycopy(elementData, 0, newData, 0, elementCount);
        elementData = newData;
        // ---------- Original Method ----------
        //E[] newData = newElementArray(newCapacity);
        //assert elementCount <= newCapacity;
        //System.arraycopy(elementData, 0, newData, 0, elementCount);
        //elementData = newData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.359 -0400", hash_original_method = "183736DEF5A7AE33048C32065B21DF67", hash_generated_method = "A11C162CE264C6FC2AF5D0F592C8E360")
    @DSModeled(DSC.SAFE)
    private void growByOne() {
        int adding;
        adding = 0;
        {
            {
                boolean var28F6DF2B41A53CDE1C60C1BFD65ACDED_1138957085 = ((adding = elementData.length) == 0);
                {
                    adding = 1;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            adding = capacityIncrement;
        } //End block
        E[] newData;
        newData = newElementArray(elementData.length + adding);
        System.arraycopy(elementData, 0, newData, 0, elementCount);
        elementData = newData;
        // ---------- Original Method ----------
        //int adding = 0;
        //if (capacityIncrement <= 0) {
            //if ((adding = elementData.length) == 0) {
                //adding = 1;
            //}
        //} else {
            //adding = capacityIncrement;
        //}
        //E[] newData = newElementArray(elementData.length + adding);
        //System.arraycopy(elementData, 0, newData, 0, elementCount);
        //elementData = newData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.359 -0400", hash_original_method = "1763D1FD6D85CB337349BE3D39A45770", hash_generated_method = "D69F5DC39FB95E1B7728DE0E5E83C111")
    @DSModeled(DSC.SAFE)
    private void growBy(int required) {
        dsTaint.addTaint(required);
        int adding;
        adding = 0;
        {
            {
                boolean var28F6DF2B41A53CDE1C60C1BFD65ACDED_1913881776 = ((adding = elementData.length) == 0);
                {
                    adding = required;
                } //End block
            } //End collapsed parenthetic
            {
                adding += adding;
            } //End block
        } //End block
        {
            adding = (required / capacityIncrement) * capacityIncrement;
            {
                adding += capacityIncrement;
            } //End block
        } //End block
        E[] newData;
        newData = newElementArray(elementData.length + adding);
        System.arraycopy(elementData, 0, newData, 0, elementCount);
        elementData = newData;
        // ---------- Original Method ----------
        //int adding = 0;
        //if (capacityIncrement <= 0) {
            //if ((adding = elementData.length) == 0) {
                //adding = required;
            //}
            //while (adding < required) {
                //adding += adding;
            //}
        //} else {
            //adding = (required / capacityIncrement) * capacityIncrement;
            //if (adding < required) {
                //adding += capacityIncrement;
            //}
        //}
        //E[] newData = newElementArray(elementData.length + adding);
        //System.arraycopy(elementData, 0, newData, 0, elementCount);
        //elementData = newData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.360 -0400", hash_original_method = "20A64E7812064C08C37EDD86F8A561DF", hash_generated_method = "1A522BE7C1A504C70C7BC522435DF0FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized int hashCode() {
        int result;
        result = 1;
        {
            int i;
            i = 0;
            {
                result = (31 * result)
                    + (elementData[i] == null ? 0 : elementData[i].hashCode());
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int result = 1;
        //for (int i = 0; i < elementCount; i++) {
            //result = (31 * result)
                    //+ (elementData[i] == null ? 0 : elementData[i].hashCode());
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.360 -0400", hash_original_method = "BA52EF79315F2CDCEE831A2AC6873E19", hash_generated_method = "16EF7CC160FC03490126D90F5C16213B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int indexOf(Object object) {
        dsTaint.addTaint(object.dsTaint);
        int varE73F9E0C1A3B81CDEF050C43218DC8D9_748188259 = (indexOf(object, 0));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return indexOf(object, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.360 -0400", hash_original_method = "24750353DFD7303BB9261ABCF2B08CBF", hash_generated_method = "8E4493A0BD53F20B04AA11F3DA5BFC47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int indexOf(Object object, int location) {
        dsTaint.addTaint(location);
        dsTaint.addTaint(object.dsTaint);
        {
            {
                int i;
                i = location;
                {
                    {
                        boolean var6058C077AE20E477BC66A81239047631_462421907 = (object.equals(elementData[i]));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                int i;
                i = location;
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.360 -0400", hash_original_method = "288EF4E8EFAE610E93F8F6663B1B7C8C", hash_generated_method = "3C0928086C5D629EB3F2C4D9CCDA1BB2")
    @DSModeled(DSC.SAFE)
    public synchronized void insertElementAt(E object, int location) {
        dsTaint.addTaint(location);
        dsTaint.addTaint(object.dsTaint);
        {
            {
                growByOne();
            } //End block
            int count;
            count = elementCount - location;
            {
                System.arraycopy(elementData, location, elementData,
                        location + 1, count);
            } //End block
            elementData[location] = object;
            elementCount++;
            modCount++;
        } //End block
        {
            throw arrayIndexOutOfBoundsException(location, elementCount);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.360 -0400", hash_original_method = "0D33E0C5C56D3A9FC9F5E73253A3A2D0", hash_generated_method = "0348A7B517AD61DC9E057505CC9F8974")
    @DSModeled(DSC.SAFE)
    @Override
    public synchronized boolean isEmpty() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return elementCount == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.360 -0400", hash_original_method = "BB5B48C89086DB15EEAE482333CC1417", hash_generated_method = "BCC9E9632E39F62D73F36B03AD745622")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    public synchronized E lastElement() {
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return (E) elementData[elementCount - 1];
        //} catch (IndexOutOfBoundsException e) {
            //throw new NoSuchElementException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.360 -0400", hash_original_method = "A9A619C02ADFE7E6CEBC127D6A8D9A71", hash_generated_method = "FEAEC4B77DB2B991C0258485291B3349")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized int lastIndexOf(Object object) {
        dsTaint.addTaint(object.dsTaint);
        int var511076739D83F05D2B69CDA20C63B8A3_251997068 = (lastIndexOf(object, elementCount - 1));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return lastIndexOf(object, elementCount - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.360 -0400", hash_original_method = "DAE93837888D415686D1D0DD0C8E6815", hash_generated_method = "1C65DEF8C1D70B769E4D84EC86F58B7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int lastIndexOf(Object object, int location) {
        dsTaint.addTaint(location);
        dsTaint.addTaint(object.dsTaint);
        {
            {
                {
                    int i;
                    i = location;
                    {
                        {
                            boolean var3A356DDF00F01E8F368FF4B2197B5E1F_745071308 = (object.equals(elementData[i]));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    int i;
                    i = location;
                } //End collapsed parenthetic
            } //End block
        } //End block
        throw arrayIndexOutOfBoundsException(location, elementCount);
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.360 -0400", hash_original_method = "E42458246EBBDA79B230DDF671CA6424", hash_generated_method = "2068741725D09E65EE0CAC1F6A54C60D")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    @Override
    public synchronized E remove(int location) {
        dsTaint.addTaint(location);
        {
            E result;
            result = (E) elementData[location];
            elementCount--;
            int size;
            size = elementCount - location;
            {
                System.arraycopy(elementData, location + 1, elementData,
                        location, size);
            } //End block
            elementData[elementCount] = null;
            modCount++;
        } //End block
        throw arrayIndexOutOfBoundsException(location, elementCount);
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (location < elementCount) {
            //E result = (E) elementData[location];
            //elementCount--;
            //int size = elementCount - location;
            //if (size > 0) {
                //System.arraycopy(elementData, location + 1, elementData,
                        //location, size);
            //}
            //elementData[elementCount] = null;
            //modCount++;
            //return result;
        //}
        //throw arrayIndexOutOfBoundsException(location, elementCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.360 -0400", hash_original_method = "823A94C57B65BF07C08540507330C163", hash_generated_method = "066CB413B52B213EC4D1FC8E4BE565F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean remove(Object object) {
        dsTaint.addTaint(object.dsTaint);
        boolean var2DF3D1B602150B1D95CE5F3A3FDBC88F_1090130574 = (removeElement(object));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return removeElement(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.360 -0400", hash_original_method = "8C6CFD9299AE63E6D8F991F5FD437E67", hash_generated_method = "3811CEF0ED60491C761F0A1401C43C9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized boolean removeAll(Collection<?> collection) {
        dsTaint.addTaint(collection.dsTaint);
        boolean var683870BA88109C83545AC694C96B458A_168558299 = (super.removeAll(collection));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return super.removeAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.361 -0400", hash_original_method = "B99CB02C0986A5ACE1171E44B2E88FC0", hash_generated_method = "6307565E81832FF15D6A86C8857FB26E")
    @DSModeled(DSC.SAFE)
    public synchronized void removeAllElements() {
        {
            int i;
            i = 0;
            {
                elementData[i] = null;
            } //End block
        } //End collapsed parenthetic
        modCount++;
        elementCount = 0;
        // ---------- Original Method ----------
        //for (int i = 0; i < elementCount; i++) {
            //elementData[i] = null;
        //}
        //modCount++;
        //elementCount = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.361 -0400", hash_original_method = "A6C501B9D7921F5FC1AF3EFCF61D0AD0", hash_generated_method = "3D536E65F71A4B7DF29E4FEAFAF1B401")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean removeElement(Object object) {
        dsTaint.addTaint(object.dsTaint);
        int index;
        {
            boolean var00053FECC15E7E9615B66BDB6BEEF16F_411897043 = ((index = indexOf(object, 0)) == -1);
        } //End collapsed parenthetic
        removeElementAt(index);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int index;
        //if ((index = indexOf(object, 0)) == -1) {
            //return false;
        //}
        //removeElementAt(index);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.361 -0400", hash_original_method = "81AD5D3720D67EB52B93171772D8B025", hash_generated_method = "BA6F96E29F76ABD2C105B4CD57532D2A")
    @DSModeled(DSC.SAFE)
    public synchronized void removeElementAt(int location) {
        dsTaint.addTaint(location);
        {
            elementCount--;
            int size;
            size = elementCount - location;
            {
                System.arraycopy(elementData, location + 1, elementData,
                        location, size);
            } //End block
            elementData[elementCount] = null;
            modCount++;
        } //End block
        {
            throw arrayIndexOutOfBoundsException(location, elementCount);
        } //End block
        // ---------- Original Method ----------
        //if (location >= 0 && location < elementCount) {
            //elementCount--;
            //int size = elementCount - location;
            //if (size > 0) {
                //System.arraycopy(elementData, location + 1, elementData,
                        //location, size);
            //}
            //elementData[elementCount] = null;
            //modCount++;
        //} else {
            //throw arrayIndexOutOfBoundsException(location, elementCount);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.361 -0400", hash_original_method = "6B459A814E902B0310B875E965EBDC88", hash_generated_method = "D4F834667DB05ED7ADF44CF79950663E")
    @DSModeled(DSC.SAFE)
    @Override
    protected void removeRange(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        {
            {
                System.arraycopy(elementData, end, elementData, start,
                        elementCount - end);
                int newCount;
                newCount = elementCount - (end - start);
                Arrays.fill(elementData, newCount, elementCount, null);
                elementCount = newCount;
            } //End block
            {
                Arrays.fill(elementData, start, elementCount, null);
            } //End block
            modCount++;
        } //End block
        {
            throw new IndexOutOfBoundsException();
        } //End block
        // ---------- Original Method ----------
        //if (start >= 0 && start <= end && end <= elementCount) {
            //if (start == end) {
                //return;
            //}
            //if (end != elementCount) {
                //System.arraycopy(elementData, end, elementData, start,
                        //elementCount - end);
                //int newCount = elementCount - (end - start);
                //Arrays.fill(elementData, newCount, elementCount, null);
                //elementCount = newCount;
            //} else {
                //Arrays.fill(elementData, start, elementCount, null);
                //elementCount = start;
            //}
            //modCount++;
        //} else {
            //throw new IndexOutOfBoundsException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.361 -0400", hash_original_method = "3D3F7D0269EE9A4A0E6B970CD7AB0599", hash_generated_method = "9E9E36132B429B245E5D974D0B28EE90")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized boolean retainAll(Collection<?> collection) {
        dsTaint.addTaint(collection.dsTaint);
        boolean var2CAA4A68044DBB7B5CB3E7FF23679230_645877909 = (super.retainAll(collection));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return super.retainAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.361 -0400", hash_original_method = "5EA1E920588C93D742AF1B9C3DFE2811", hash_generated_method = "76EBE69AEE12E5CE13DC08FDDAC6CD84")
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    @Override
    public synchronized E set(int location, E object) {
        dsTaint.addTaint(location);
        dsTaint.addTaint(object.dsTaint);
        {
            E result;
            result = (E) elementData[location];
            elementData[location] = object;
        } //End block
        throw arrayIndexOutOfBoundsException(location, elementCount);
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (location < elementCount) {
            //E result = (E) elementData[location];
            //elementData[location] = object;
            //return result;
        //}
        //throw arrayIndexOutOfBoundsException(location, elementCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.361 -0400", hash_original_method = "BE9BD0132B3B62E633B4EDB307CB7290", hash_generated_method = "8A15A055176EC8BA166B0E1FC2C55C1F")
    @DSModeled(DSC.SAFE)
    public synchronized void setElementAt(E object, int location) {
        dsTaint.addTaint(location);
        dsTaint.addTaint(object.dsTaint);
        {
            elementData[location] = object;
        } //End block
        {
            throw arrayIndexOutOfBoundsException(location, elementCount);
        } //End block
        // ---------- Original Method ----------
        //if (location < elementCount) {
            //elementData[location] = object;
        //} else {
            //throw arrayIndexOutOfBoundsException(location, elementCount);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.361 -0400", hash_original_method = "9B7D3F2F980E3EB6087A253589224152", hash_generated_method = "241DB74A7C1A3F403B28B3142CB5207F")
    private static ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException(int index, int size) {
        throw new ArrayIndexOutOfBoundsException(size, index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.361 -0400", hash_original_method = "7F3B955AC73FEA732765CAFEDD4BC76C", hash_generated_method = "6C8EC9B8C16A3B7FC1E686040903938F")
    @DSModeled(DSC.SAFE)
    public synchronized void setSize(int length) {
        dsTaint.addTaint(length);
        ensureCapacity(length);
        {
            Arrays.fill(elementData, length, elementCount, null);
        } //End block
        modCount++;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.361 -0400", hash_original_method = "81BBFD456B62650530A643B4CB14DC43", hash_generated_method = "C5E3A693BED9B687A7375B6D18BE10D3")
    @DSModeled(DSC.SAFE)
    @Override
    public synchronized int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return elementCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.361 -0400", hash_original_method = "12E21B76E32A1D6BB3AE5A157C1F7673", hash_generated_method = "D96C2B3E32A66554DF0A2F39265AFCC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized List<E> subList(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        List<E> varB18DC1F3ECFBB98A24E4E553D9EA7248_932657974 = (new Collections.SynchronizedRandomAccessList<E>(super.subList(
                start, end), this));
        return (List<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Collections.SynchronizedRandomAccessList<E>(super.subList(
                //start, end), this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.361 -0400", hash_original_method = "6F1E76A2D55423060704E3AA65069BB2", hash_generated_method = "A853B1980D40D5665C6F8B8EADE39CEA")
    @DSModeled(DSC.SAFE)
    @Override
    public synchronized Object[] toArray() {
        Object[] result;
        result = new Object[elementCount];
        System.arraycopy(elementData, 0, result, 0, elementCount);
        return (Object[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object[] result = new Object[elementCount];
        //System.arraycopy(elementData, 0, result, 0, elementCount);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.362 -0400", hash_original_method = "70C5BC6785EB6C524C2B60C494DFFFBE", hash_generated_method = "2760510A6827872A91852DE35C9431E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    @SuppressWarnings("unchecked")
    public synchronized <T> T[] toArray(T[] contents) {
        dsTaint.addTaint(contents.dsTaint);
        {
            Class<?> ct;
            ct = contents.getClass().getComponentType();
            contents = (T[]) Array.newInstance(ct, elementCount);
        } //End block
        System.arraycopy(elementData, 0, contents, 0, elementCount);
        {
            contents[elementCount] = null;
        } //End block
        return (T[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (elementCount > contents.length) {
            //Class<?> ct = contents.getClass().getComponentType();
            //contents = (T[]) Array.newInstance(ct, elementCount);
        //}
        //System.arraycopy(elementData, 0, contents, 0, elementCount);
        //if (elementCount < contents.length) {
            //contents[elementCount] = null;
        //}
        //return contents;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.362 -0400", hash_original_method = "0DD9DB5F445E75E250BA34836212BB86", hash_generated_method = "6BC13D78F080C07F1337940FE65F2B99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized String toString() {
        int length;
        length = elementCount - 1;
        StringBuilder buffer;
        buffer = new StringBuilder(elementCount * 16);
        buffer.append('[');
        {
            int i;
            i = 0;
            {
                {
                    buffer.append("(this Collection)");
                } //End block
                {
                    buffer.append(elementData[i]);
                } //End block
                buffer.append(", ");
            } //End block
        } //End collapsed parenthetic
        {
            buffer.append("(this Collection)");
        } //End block
        {
            buffer.append(elementData[length]);
        } //End block
        buffer.append(']');
        String varAD28D02EB1C6982A5710D014292E1955_411938549 = (buffer.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.362 -0400", hash_original_method = "FC23934C3FC3508F47E3F895F030378B", hash_generated_method = "CD39BCC1047A950EDD2450A2F6CFB6FB")
    @DSModeled(DSC.SAFE)
    public synchronized void trimToSize() {
        {
            grow(elementCount);
        } //End block
        // ---------- Original Method ----------
        //if (elementData.length != elementCount) {
            //grow(elementCount);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.362 -0400", hash_original_method = "93271132EFBEDC29196C798673AC5EE7", hash_generated_method = "8E7F81D169D9BD036AD3538DA3A3D7C4")
    @DSModeled(DSC.SAFE)
    private synchronized void writeObject(ObjectOutputStream stream) throws IOException {
        dsTaint.addTaint(stream.dsTaint);
        stream.defaultWriteObject();
        // ---------- Original Method ----------
        //stream.defaultWriteObject();
    }

    
}


