package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;

public class Vector<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable {
    protected int elementCount;
    protected Object[] elementData;
    protected int capacityIncrement;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.167 -0400", hash_original_method = "DACE16FEA3F29475D20FB4F2AE2C4BF3", hash_generated_method = "F92FDEEA28BC7E4B901A0A343D42232D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Vector() {
        this(DEFAULT_SIZE, 0);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.167 -0400", hash_original_method = "516F631FEB27C4B8AC76BAFF727DB150", hash_generated_method = "2E42BC480AB46CB501CFB8C4BCADFFDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Vector(int capacity) {
        this(capacity, 0);
        dsTaint.addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.167 -0400", hash_original_method = "B35B3D540AE265DD802702BED4157C47", hash_generated_method = "7B52A798F7E891BC751933514AF9CBFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Vector(int capacity, int capacityIncrement) {
        dsTaint.addTaint(capacityIncrement);
        dsTaint.addTaint(capacity);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.167 -0400", hash_original_method = "5554DADF2588E03BDCF1E2168D3E3C3F", hash_generated_method = "BBA8431D5FBB931FA45D7C04C90C35FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Vector(Collection<? extends E> collection) {
        this(collection.size(), 0);
        dsTaint.addTaint(collection.dsTaint);
        Iterator<? extends E> it;
        it = collection.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_789186205 = (it.hasNext());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.167 -0400", hash_original_method = "088E691065B085AAA9856C71AD537C28", hash_generated_method = "7A886A96EA6A1CE3E4C3E005925AAC57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    private E[] newElementArray(int size) {
        dsTaint.addTaint(size);
        E[] varDC79AF069972B95A069B0B069F802B9E_1631320372 = ((E[]) new Object[size]);
        return (E[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (E[]) new Object[size];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.168 -0400", hash_original_method = "48191DBEFAEF26CE3AD2676469C6C588", hash_generated_method = "C7C5E79A2DB5C5F9E93F98A84D5B2CDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void add(int location, E object) {
        dsTaint.addTaint(location);
        dsTaint.addTaint(object.dsTaint);
        insertElementAt(object, location);
        // ---------- Original Method ----------
        //insertElementAt(object, location);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.168 -0400", hash_original_method = "4A1B135502A4FBF53B5971ADD0895265", hash_generated_method = "67D94BAF67E676472CA8996A49287624")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized boolean add(E object) {
        dsTaint.addTaint(object.dsTaint);
        {
            growByOne();
        } //End block
        elementData[elementCount++] = object;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (elementCount == elementData.length) {
            //growByOne();
        //}
        //elementData[elementCount++] = object;
        //modCount++;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.168 -0400", hash_original_method = "721C95E0B3ACA6F09AE8F219EA79313F", hash_generated_method = "1547D3D3637C34237A3A4C6B22A732BC")
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
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1635190942 = (it.hasNext());
                {
                    elementData[location++] = it.next();
                } //End block
            } //End collapsed parenthetic
            elementCount += size;
        } //End block
        if (DroidSafeAndroidRuntime.control) throw arrayIndexOutOfBoundsException(location, elementCount);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.168 -0400", hash_original_method = "936868945967E6EE9BEE2301A3FC2D7D", hash_generated_method = "6E91B4C603F1958C74FD23ADC8317E1F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized boolean addAll(Collection<? extends E> collection) {
        dsTaint.addTaint(collection.dsTaint);
        boolean var03502A2162BCCC449AB5D23C58C8227A_1618920510 = (addAll(elementCount, collection));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return addAll(elementCount, collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.169 -0400", hash_original_method = "A5163E0F34F09A3D8DEA4C412903D1D1", hash_generated_method = "37F5553937A17B4F48843FD0BC4BE062")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void addElement(E object) {
        dsTaint.addTaint(object.dsTaint);
        {
            growByOne();
        } //End block
        elementData[elementCount++] = object;
        // ---------- Original Method ----------
        //if (elementCount == elementData.length) {
            //growByOne();
        //}
        //elementData[elementCount++] = object;
        //modCount++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.169 -0400", hash_original_method = "DD1AE1F8EA98D3605FDD193E0651B9D6", hash_generated_method = "6F243F68FC26095E2AABC9E4B52ADBCD")
    @DSModeled(DSC.SAFE)
    public synchronized int capacity() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return elementData.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.169 -0400", hash_original_method = "1F4E1B041EF06199B18000DD20E283A1", hash_generated_method = "CB8944604C59D0C0C157C3038F849082")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void clear() {
        removeAllElements();
        // ---------- Original Method ----------
        //removeAllElements();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.169 -0400", hash_original_method = "1610A6C93F0D6F1C66DC0DFCBD33D1B2", hash_generated_method = "3A711515D00EB6A3B005C8C83D51C681")
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
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.169 -0400", hash_original_method = "4017403066D0A85EBF82EC88CFE4ED84", hash_generated_method = "0B172C689653F8DD1557303259FB71A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean contains(Object object) {
        dsTaint.addTaint(object.dsTaint);
        boolean varFC609B1C0AB8A3A126012E7353465119_1449423079 = (indexOf(object, 0) != -1);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return indexOf(object, 0) != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.170 -0400", hash_original_method = "51334898ABB14C1CD821FC4FE1B2383C", hash_generated_method = "5B8ED54E9FFB24689507C1AD0CB5BA7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized boolean containsAll(Collection<?> collection) {
        dsTaint.addTaint(collection.dsTaint);
        boolean varF935A9EEA803E51431822CE5207F3376_1011320623 = (super.containsAll(collection));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return super.containsAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.170 -0400", hash_original_method = "9FCD2BB7391A67913F5DC5B0A38C9668", hash_generated_method = "092BCC2C9E98350BDEF2F4B618478B1F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void copyInto(Object[] elements) {
        dsTaint.addTaint(elements[0].dsTaint);
        System.arraycopy(elementData, 0, elements, 0, elementCount);
        // ---------- Original Method ----------
        //System.arraycopy(elementData, 0, elements, 0, elementCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.170 -0400", hash_original_method = "3CA02A8FB0EDF4F6C1F1F261516DC679", hash_generated_method = "D1F15ECA68605A9A6EB0A1DAAC8382FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public synchronized E elementAt(int location) {
        dsTaint.addTaint(location);
        if (DroidSafeAndroidRuntime.control) throw arrayIndexOutOfBoundsException(location, elementCount);
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (location < elementCount) {
            //return (E) elementData[location];
        //}
        //throw arrayIndexOutOfBoundsException(location, elementCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.170 -0400", hash_original_method = "B6E84DE201AAEF8307F5E7CA8A6AEF90", hash_generated_method = "D45C74F8468C49B0FB06A1E0879287F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Enumeration<E> elements() {
        Enumeration<E> varE3E6F33E05286959BCB5D6E5F319F40A_2011627942 = (new Enumeration<E>() {            int pos = 0;
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.170 -0400", hash_original_method = "BE1470CA1AE3A8E761558BC585309C9C", hash_generated_method = "6CF48B7F78EE48B519C7212690DFC7C9")
            @DSModeled(DSC.SAFE)
            public boolean hasMoreElements() {
                return dsTaint.getTaintBoolean();
                // ---------- Original Method ----------
                //return pos < elementCount;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.170 -0400", hash_original_method = "587FDB7AD89D6517798ABA6D2628416A", hash_generated_method = "502500E26B5787E0FEBF1942831401B4")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @SuppressWarnings("unchecked")
            public E nextElement() {
                {
                    Object varD1D6E4D371CCF7375A1CB362810910C2_802585817 = (Vector.this);
                } //End collapsed parenthetic
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                return (E)dsTaint.getTaint();
                // ---------- Original Method ----------
                //synchronized (Vector.this) {
                    //if (pos < elementCount) {
                        //return (E) elementData[pos++];
                    //}
                //}
                //throw new NoSuchElementException();
            }
});
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.171 -0400", hash_original_method = "DF06508A0F0ED83B84FE34EF6D5FCD26", hash_generated_method = "ADDEED736830678D1DD417FF57EBE262")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.171 -0400", hash_original_method = "18CA94477F381022C117A5BE2C4C7154", hash_generated_method = "A74F6D0D7BE41F890442A23912D43D1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        {
            List<?> list;
            list = (List<?>) object;
            {
                boolean var87DA8CDCBC1CCBE821948EA1C5E2BC78_1676561600 = (list.size() != elementCount);
            } //End collapsed parenthetic
            int index;
            index = 0;
            Iterator<?> it;
            it = list.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1760730566 = (it.hasNext());
                {
                    Object e1, e2;
                    e1 = elementData[index++];
                    e2 = it.next();
                    {
                        boolean var340C63FF299BF53687C9CFA16F96F134_1230582317 = (!(e1 == null ? e2 == null : e1.equals(e2))); //DSFIXME:  CODE0008: Nested ternary operator in expression
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.171 -0400", hash_original_method = "D89343B924D76ED75CDC4E663D066F77", hash_generated_method = "6C2A031E8FDF6C9461CD35DD881A3752")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public synchronized E firstElement() {
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (elementCount > 0) {
            //return (E) elementData[0];
        //}
        //throw new NoSuchElementException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.171 -0400", hash_original_method = "E09D80C19A651BF8C26D5375E71CA6A0", hash_generated_method = "AAC91594E1CA98F260FD4832A4245B2B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public E get(int location) {
        dsTaint.addTaint(location);
        E var3385AE87BC6AA9BFE91788D456EB4B04_1181013431 = (elementAt(location));
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return elementAt(location);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.172 -0400", hash_original_method = "B022A84D94038C9BB0C01ED819C072BD", hash_generated_method = "020C5A39A0DB6F5D4481F884B10D30C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.172 -0400", hash_original_method = "183736DEF5A7AE33048C32065B21DF67", hash_generated_method = "98E12374FB08A5927C07FFBDB9985467")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void growByOne() {
        int adding;
        adding = 0;
        {
            {
                boolean var28F6DF2B41A53CDE1C60C1BFD65ACDED_1025468863 = ((adding = elementData.length) == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.172 -0400", hash_original_method = "1763D1FD6D85CB337349BE3D39A45770", hash_generated_method = "F9C29591CB84F6FA8EC9A007781D61FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void growBy(int required) {
        dsTaint.addTaint(required);
        int adding;
        adding = 0;
        {
            {
                boolean var28F6DF2B41A53CDE1C60C1BFD65ACDED_1155216899 = ((adding = elementData.length) == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.172 -0400", hash_original_method = "20A64E7812064C08C37EDD86F8A561DF", hash_generated_method = "E1F2F6770200EE4BF34FF36C3D1BCC26")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.173 -0400", hash_original_method = "BA52EF79315F2CDCEE831A2AC6873E19", hash_generated_method = "CC18BDF9D5D3BFE8FC8B2121C92D7581")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int indexOf(Object object) {
        dsTaint.addTaint(object.dsTaint);
        int varE73F9E0C1A3B81CDEF050C43218DC8D9_333193752 = (indexOf(object, 0));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return indexOf(object, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.173 -0400", hash_original_method = "24750353DFD7303BB9261ABCF2B08CBF", hash_generated_method = "FEC5D4F0DFCEC211B7ADC14909B35255")
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
                        boolean var6058C077AE20E477BC66A81239047631_1179461204 = (object.equals(elementData[i]));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.173 -0400", hash_original_method = "288EF4E8EFAE610E93F8F6663B1B7C8C", hash_generated_method = "498A542740B66D89EB727DCDAB1922AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw arrayIndexOutOfBoundsException(location, elementCount);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.173 -0400", hash_original_method = "0D33E0C5C56D3A9FC9F5E73253A3A2D0", hash_generated_method = "6D41F48C644024464AD137E0A0BD71AA")
    @DSModeled(DSC.SAFE)
    @Override
    public synchronized boolean isEmpty() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return elementCount == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.174 -0400", hash_original_method = "BB5B48C89086DB15EEAE482333CC1417", hash_generated_method = "C6A1B27A453DC15D9604D6F6E299387D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.174 -0400", hash_original_method = "A9A619C02ADFE7E6CEBC127D6A8D9A71", hash_generated_method = "CA64FF465A1488FC78F704C5EFB5B951")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized int lastIndexOf(Object object) {
        dsTaint.addTaint(object.dsTaint);
        int var511076739D83F05D2B69CDA20C63B8A3_2131907938 = (lastIndexOf(object, elementCount - 1));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return lastIndexOf(object, elementCount - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.174 -0400", hash_original_method = "DAE93837888D415686D1D0DD0C8E6815", hash_generated_method = "A40C7EC2BFEAE93DB84F27DC6A0B1475")
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
                            boolean var3A356DDF00F01E8F368FF4B2197B5E1F_492559591 = (object.equals(elementData[i]));
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
        if (DroidSafeAndroidRuntime.control) throw arrayIndexOutOfBoundsException(location, elementCount);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.174 -0400", hash_original_method = "E42458246EBBDA79B230DDF671CA6424", hash_generated_method = "795DE1E9F8486DE87D11E7556A2B90C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    @Override
    public synchronized E remove(int location) {
        dsTaint.addTaint(location);
        {
            E result;
            result = (E) elementData[location];
            int size;
            size = elementCount - location;
            {
                System.arraycopy(elementData, location + 1, elementData,
                        location, size);
            } //End block
            elementData[elementCount] = null;
        } //End block
        if (DroidSafeAndroidRuntime.control) throw arrayIndexOutOfBoundsException(location, elementCount);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.175 -0400", hash_original_method = "823A94C57B65BF07C08540507330C163", hash_generated_method = "9A22D837073C5B4832E3431A1615A7D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean remove(Object object) {
        dsTaint.addTaint(object.dsTaint);
        boolean var2DF3D1B602150B1D95CE5F3A3FDBC88F_1082861193 = (removeElement(object));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return removeElement(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.175 -0400", hash_original_method = "8C6CFD9299AE63E6D8F991F5FD437E67", hash_generated_method = "3EE938DA80ADCA15024D55ED7ED203AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized boolean removeAll(Collection<?> collection) {
        dsTaint.addTaint(collection.dsTaint);
        boolean var683870BA88109C83545AC694C96B458A_651915261 = (super.removeAll(collection));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return super.removeAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.175 -0400", hash_original_method = "B99CB02C0986A5ACE1171E44B2E88FC0", hash_generated_method = "C7C25FD730655FC2413FA1DEF25647CC")
    @DSModeled(DSC.SAFE)
    public synchronized void removeAllElements() {
        {
            int i;
            i = 0;
            {
                elementData[i] = null;
            } //End block
        } //End collapsed parenthetic
        elementCount = 0;
        // ---------- Original Method ----------
        //for (int i = 0; i < elementCount; i++) {
            //elementData[i] = null;
        //}
        //modCount++;
        //elementCount = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.175 -0400", hash_original_method = "A6C501B9D7921F5FC1AF3EFCF61D0AD0", hash_generated_method = "307E0CED770D51139117DC4788F0E6AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized boolean removeElement(Object object) {
        dsTaint.addTaint(object.dsTaint);
        int index;
        {
            boolean var00053FECC15E7E9615B66BDB6BEEF16F_2040515409 = ((index = indexOf(object, 0)) == -1);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.175 -0400", hash_original_method = "81AD5D3720D67EB52B93171772D8B025", hash_generated_method = "634474FAD655D2C2B016E7411C7B503D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void removeElementAt(int location) {
        dsTaint.addTaint(location);
        {
            int size;
            size = elementCount - location;
            {
                System.arraycopy(elementData, location + 1, elementData,
                        location, size);
            } //End block
            elementData[elementCount] = null;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw arrayIndexOutOfBoundsException(location, elementCount);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.176 -0400", hash_original_method = "6B459A814E902B0310B875E965EBDC88", hash_generated_method = "2BD33CAE2AF11C73E8FC1CC7CAF45AE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.176 -0400", hash_original_method = "3D3F7D0269EE9A4A0E6B970CD7AB0599", hash_generated_method = "F912F567E44373470319D6D56234BEF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized boolean retainAll(Collection<?> collection) {
        dsTaint.addTaint(collection.dsTaint);
        boolean var2CAA4A68044DBB7B5CB3E7FF23679230_1568973735 = (super.retainAll(collection));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return super.retainAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.176 -0400", hash_original_method = "5EA1E920588C93D742AF1B9C3DFE2811", hash_generated_method = "3804D03C4CB8B6DA3BBE6F5C7583F257")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        if (DroidSafeAndroidRuntime.control) throw arrayIndexOutOfBoundsException(location, elementCount);
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (location < elementCount) {
            //E result = (E) elementData[location];
            //elementData[location] = object;
            //return result;
        //}
        //throw arrayIndexOutOfBoundsException(location, elementCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.176 -0400", hash_original_method = "BE9BD0132B3B62E633B4EDB307CB7290", hash_generated_method = "50A87D6FF3519D909A17498B987BA954")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setElementAt(E object, int location) {
        dsTaint.addTaint(location);
        dsTaint.addTaint(object.dsTaint);
        {
            elementData[location] = object;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw arrayIndexOutOfBoundsException(location, elementCount);
        } //End block
        // ---------- Original Method ----------
        //if (location < elementCount) {
            //elementData[location] = object;
        //} else {
            //throw arrayIndexOutOfBoundsException(location, elementCount);
        //}
    }

    
        private static ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException(int index, int size) {
        throw new ArrayIndexOutOfBoundsException(size, index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.177 -0400", hash_original_method = "7F3B955AC73FEA732765CAFEDD4BC76C", hash_generated_method = "5029D5C3424DF45D6D1F6B588B378920")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setSize(int length) {
        dsTaint.addTaint(length);
        ensureCapacity(length);
        {
            Arrays.fill(elementData, length, elementCount, null);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.177 -0400", hash_original_method = "81BBFD456B62650530A643B4CB14DC43", hash_generated_method = "C3B8946BA2F8F18A4F3DA806CCCD7A33")
    @DSModeled(DSC.SAFE)
    @Override
    public synchronized int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return elementCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.177 -0400", hash_original_method = "12E21B76E32A1D6BB3AE5A157C1F7673", hash_generated_method = "DE6DC4881E97827AEF3CC623E6155D8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized List<E> subList(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        List<E> varB18DC1F3ECFBB98A24E4E553D9EA7248_1862561781 = (new Collections.SynchronizedRandomAccessList<E>(super.subList(
                start, end), this));
        return (List<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Collections.SynchronizedRandomAccessList<E>(super.subList(
                //start, end), this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.177 -0400", hash_original_method = "6F1E76A2D55423060704E3AA65069BB2", hash_generated_method = "3B30DA7F8E593E3B2A2AA96A014B673C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.178 -0400", hash_original_method = "70C5BC6785EB6C524C2B60C494DFFFBE", hash_generated_method = "7C737378D6CCCE0EBA895998355D2A83")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    @SuppressWarnings("unchecked")
    public synchronized <T> T[] toArray(T[] contents) {
        dsTaint.addTaint(contents[0].dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.178 -0400", hash_original_method = "0DD9DB5F445E75E250BA34836212BB86", hash_generated_method = "751CA087600E7A2BACC3BB1C8CB1770B")
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
                    boolean var1EAEC00226A70062D4821DCC23A131E8_838500397 = (elementData[i] == this);
                    {
                        buffer.append("(this Collection)");
                    } //End block
                    {
                        buffer.append(elementData[i]);
                    } //End block
                } //End collapsed parenthetic
                buffer.append(", ");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var133E8E0A94865404CC8E7824CF7E87B9_74075962 = (elementData[length] == this);
            {
                buffer.append("(this Collection)");
            } //End block
            {
                buffer.append(elementData[length]);
            } //End block
        } //End collapsed parenthetic
        buffer.append(']');
        String varAD28D02EB1C6982A5710D014292E1955_1713043316 = (buffer.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.178 -0400", hash_original_method = "FC23934C3FC3508F47E3F895F030378B", hash_generated_method = "67BB08EED6E7441D6B67A75C72DF5B64")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void trimToSize() {
        {
            grow(elementCount);
        } //End block
        // ---------- Original Method ----------
        //if (elementData.length != elementCount) {
            //grow(elementCount);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.179 -0400", hash_original_method = "93271132EFBEDC29196C798673AC5EE7", hash_generated_method = "E852A14792D784D6DEF97640C31669F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized void writeObject(ObjectOutputStream stream) throws IOException {
        dsTaint.addTaint(stream.dsTaint);
        stream.defaultWriteObject();
        // ---------- Original Method ----------
        //stream.defaultWriteObject();
    }

    
    private static final long serialVersionUID = -2767605614048989439L;
    private static final int DEFAULT_SIZE = 10;
}

