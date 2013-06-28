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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.730 -0400", hash_original_field = "BC8C6DCF12CE09E50A98BB57ADFCADD9", hash_generated_field = "499A2D73243CED99A42E214D64505A6C")

    protected int elementCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.730 -0400", hash_original_field = "8D395F1876FF8AE01BE52A9C4C2ED552", hash_generated_field = "0B3F426A5758654DA42168DCEAA2747C")

    protected Object[] elementData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.730 -0400", hash_original_field = "7D8D485EB9C5EE294297FC18663D46D8", hash_generated_field = "C57732C85DED3048B8128B9506ED7293")

    protected int capacityIncrement;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.730 -0400", hash_original_method = "DACE16FEA3F29475D20FB4F2AE2C4BF3", hash_generated_method = "F92FDEEA28BC7E4B901A0A343D42232D")
    public  Vector() {
        this(DEFAULT_SIZE, 0);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.730 -0400", hash_original_method = "516F631FEB27C4B8AC76BAFF727DB150", hash_generated_method = "F3CDA2715564D8E8516468F487D83DFA")
    public  Vector(int capacity) {
        this(capacity, 0);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.731 -0400", hash_original_method = "B35B3D540AE265DD802702BED4157C47", hash_generated_method = "1D161C898B7C2B3F0F38E06F9F5D1032")
    public  Vector(int capacity, int capacityIncrement) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        elementData = newElementArray(capacity);
        elementCount = 0;
        this.capacityIncrement = capacityIncrement;
        // ---------- Original Method ----------
        //if (capacity < 0) {
            //throw new IllegalArgumentException();
        //}
        //elementData = newElementArray(capacity);
        //elementCount = 0;
        //this.capacityIncrement = capacityIncrement;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.731 -0400", hash_original_method = "5554DADF2588E03BDCF1E2168D3E3C3F", hash_generated_method = "C6BF00053EF6279149BE93F0C6B45FB0")
    public  Vector(Collection<? extends E> collection) {
        this(collection.size(), 0);
        Iterator<? extends E> it = collection.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1175881308 = (it.hasNext());
            {
                elementData[elementCount++] = it.next();
            } //End block
        } //End collapsed parenthetic
        addTaint(collection.getTaint());
        // ---------- Original Method ----------
        //Iterator<? extends E> it = collection.iterator();
        //while (it.hasNext()) {
            //elementData[elementCount++] = it.next();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.731 -0400", hash_original_method = "088E691065B085AAA9856C71AD537C28", hash_generated_method = "A7342C7ECE27002AC7EF3B3C77884C39")
    @SuppressWarnings("unchecked")
    private E[] newElementArray(int size) {
        E[] varB4EAC82CA7396A68D541C85D26508E83_1783714254 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1783714254 = (E[]) new Object[size];
        addTaint(size);
        varB4EAC82CA7396A68D541C85D26508E83_1783714254.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1783714254;
        // ---------- Original Method ----------
        //return (E[]) new Object[size];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.732 -0400", hash_original_method = "48191DBEFAEF26CE3AD2676469C6C588", hash_generated_method = "3476632618807434BE8A96CCB83845B5")
    @Override
    public void add(int location, E object) {
        insertElementAt(object, location);
        addTaint(location);
        addTaint(object.getTaint());
        // ---------- Original Method ----------
        //insertElementAt(object, location);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.732 -0400", hash_original_method = "4A1B135502A4FBF53B5971ADD0895265", hash_generated_method = "0F85A7CBAE6A4BFEF765523DCDF2E126")
    @Override
    public synchronized boolean add(E object) {
        {
            growByOne();
        } //End block
        elementData[elementCount++] = object;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1367671126 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1367671126;
        // ---------- Original Method ----------
        //if (elementCount == elementData.length) {
            //growByOne();
        //}
        //elementData[elementCount++] = object;
        //modCount++;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.733 -0400", hash_original_method = "721C95E0B3ACA6F09AE8F219EA79313F", hash_generated_method = "78E5737951E95AB951AF2D7BFEE5E4E9")
    @Override
    public synchronized boolean addAll(int location, Collection<? extends E> collection) {
        {
            int size = collection.size();
            int required = size - (elementData.length - elementCount);
            {
                growBy(required);
            } //End block
            int count = elementCount - location;
            {
                System.arraycopy(elementData, location, elementData, location
                        + size, count);
            } //End block
            Iterator<? extends E> it = collection.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1366884337 = (it.hasNext());
                {
                    elementData[location++] = it.next();
                } //End block
            } //End collapsed parenthetic
            elementCount += size;
        } //End block
        if (DroidSafeAndroidRuntime.control) throw arrayIndexOutOfBoundsException(location, elementCount);
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1596666879 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1596666879;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.733 -0400", hash_original_method = "936868945967E6EE9BEE2301A3FC2D7D", hash_generated_method = "C70F7723D5855C479BFC98853DB87C1C")
    @Override
    public synchronized boolean addAll(Collection<? extends E> collection) {
        boolean var03502A2162BCCC449AB5D23C58C8227A_1239444347 = (addAll(elementCount, collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2084452888 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2084452888;
        // ---------- Original Method ----------
        //return addAll(elementCount, collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.734 -0400", hash_original_method = "A5163E0F34F09A3D8DEA4C412903D1D1", hash_generated_method = "DBB5A700C860712A2B4620057CA642F0")
    public synchronized void addElement(E object) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.735 -0400", hash_original_method = "DD1AE1F8EA98D3605FDD193E0651B9D6", hash_generated_method = "0B028296284412CE40D49226F2D80821")
    public synchronized int capacity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_513365483 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_513365483;
        // ---------- Original Method ----------
        //return elementData.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.735 -0400", hash_original_method = "1F4E1B041EF06199B18000DD20E283A1", hash_generated_method = "CB8944604C59D0C0C157C3038F849082")
    @Override
    public void clear() {
        removeAllElements();
        // ---------- Original Method ----------
        //removeAllElements();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.738 -0400", hash_original_method = "1610A6C93F0D6F1C66DC0DFCBD33D1B2", hash_generated_method = "9248F9EFCF4B65AD44544949EE0B7371")
    @Override
    @SuppressWarnings("unchecked")
    public synchronized Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1393559686 = null; //Variable for return #1
        try 
        {
            Vector<E> vector = (Vector<E>) super.clone();
            vector.elementData = elementData.clone();
            varB4EAC82CA7396A68D541C85D26508E83_1393559686 = vector;
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1393559686.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1393559686;
        // ---------- Original Method ----------
        //try {
            //Vector<E> vector = (Vector<E>) super.clone();
            //vector.elementData = elementData.clone();
            //return vector;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.739 -0400", hash_original_method = "4017403066D0A85EBF82EC88CFE4ED84", hash_generated_method = "A2B3B48B6D15D7685AAA2D144FCAD12E")
    @Override
    public boolean contains(Object object) {
        boolean varFC609B1C0AB8A3A126012E7353465119_199898712 = (indexOf(object, 0) != -1);
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1979531528 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1979531528;
        // ---------- Original Method ----------
        //return indexOf(object, 0) != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.739 -0400", hash_original_method = "51334898ABB14C1CD821FC4FE1B2383C", hash_generated_method = "F77BB192CE9F63BE3CB98B35F64D73DB")
    @Override
    public synchronized boolean containsAll(Collection<?> collection) {
        boolean varF935A9EEA803E51431822CE5207F3376_1952047577 = (super.containsAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_776564303 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_776564303;
        // ---------- Original Method ----------
        //return super.containsAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.740 -0400", hash_original_method = "9FCD2BB7391A67913F5DC5B0A38C9668", hash_generated_method = "729DF9DBCFE6AECF2FE7D68CF505468B")
    public synchronized void copyInto(Object[] elements) {
        System.arraycopy(elementData, 0, elements, 0, elementCount);
        addTaint(elements[0].getTaint());
        // ---------- Original Method ----------
        //System.arraycopy(elementData, 0, elements, 0, elementCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.741 -0400", hash_original_method = "3CA02A8FB0EDF4F6C1F1F261516DC679", hash_generated_method = "FCE24F9457D3AEA329E368D64F0D57A4")
    @SuppressWarnings("unchecked")
    public synchronized E elementAt(int location) {
        E varB4EAC82CA7396A68D541C85D26508E83_2039591183 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_2039591183 = (E) elementData[location];
        } //End block
        if (DroidSafeAndroidRuntime.control) throw arrayIndexOutOfBoundsException(location, elementCount);
        addTaint(location);
        varB4EAC82CA7396A68D541C85D26508E83_2039591183.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2039591183;
        // ---------- Original Method ----------
        //if (location < elementCount) {
            //return (E) elementData[location];
        //}
        //throw arrayIndexOutOfBoundsException(location, elementCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.742 -0400", hash_original_method = "B6E84DE201AAEF8307F5E7CA8A6AEF90", hash_generated_method = "E7E27DD6C041B605124BD655E74FB942")
    public Enumeration<E> elements() {
        Enumeration<E> varB4EAC82CA7396A68D541C85D26508E83_1742210215 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1742210215 = new Enumeration<E>() {
            int pos = 0;
            public boolean hasMoreElements() {
                return pos < elementCount;
            }
            @SuppressWarnings("unchecked")
            public E nextElement() {
                synchronized (Vector.this) {
                    if (pos < elementCount) {
                        return (E) elementData[pos++];
                    }
                }
                throw new NoSuchElementException();
            }
        };
        varB4EAC82CA7396A68D541C85D26508E83_1742210215.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1742210215;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.743 -0400", hash_original_method = "DF06508A0F0ED83B84FE34EF6D5FCD26", hash_generated_method = "8326FBD7D8B862E9526544548BBAB3A6")
    public synchronized void ensureCapacity(int minimumCapacity) {
        {
            int next = (capacityIncrement <= 0 ? elementData.length
                    : capacityIncrement)
                    + elementData.length;//DSFIXME:  CODE0008: Nested ternary operator in expression
            grow(minimumCapacity > next ? minimumCapacity : next);
        } //End block
        addTaint(minimumCapacity);
        // ---------- Original Method ----------
        //if (elementData.length < minimumCapacity) {
            //int next = (capacityIncrement <= 0 ? elementData.length
                    //: capacityIncrement)
                    //+ elementData.length;
            //grow(minimumCapacity > next ? minimumCapacity : next);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.743 -0400", hash_original_method = "18CA94477F381022C117A5BE2C4C7154", hash_generated_method = "BE2C33E0679FAFA578586BC9920620E2")
    @Override
    public synchronized boolean equals(Object object) {
        {
            List<?> list = (List<?>) object;
            {
                boolean var87DA8CDCBC1CCBE821948EA1C5E2BC78_1739431664 = (list.size() != elementCount);
            } //End collapsed parenthetic
            int index = 0;
            Iterator<?> it = list.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1884903307 = (it.hasNext());
                {
                    Object e1 = elementData[index++];
                    Object e2 = it.next();
                    {
                        boolean var340C63FF299BF53687C9CFA16F96F134_141801668 = (!(e1 == null ? e2 == null : e1.equals(e2))); //DSFIXME:  CODE0008: Nested ternary operator in expression
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1964414372 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1964414372;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.744 -0400", hash_original_method = "D89343B924D76ED75CDC4E663D066F77", hash_generated_method = "7F5D50886ECAC27098EA7B16E0A792E7")
    @SuppressWarnings("unchecked")
    public synchronized E firstElement() {
        E varB4EAC82CA7396A68D541C85D26508E83_1589101725 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_1589101725 = (E) elementData[0];
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_1589101725.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1589101725;
        // ---------- Original Method ----------
        //if (elementCount > 0) {
            //return (E) elementData[0];
        //}
        //throw new NoSuchElementException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.746 -0400", hash_original_method = "E09D80C19A651BF8C26D5375E71CA6A0", hash_generated_method = "487860E6AABF98125C66489A532944E2")
    @Override
    public E get(int location) {
        E varB4EAC82CA7396A68D541C85D26508E83_941722390 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_941722390 = elementAt(location);
        addTaint(location);
        varB4EAC82CA7396A68D541C85D26508E83_941722390.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_941722390;
        // ---------- Original Method ----------
        //return elementAt(location);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.746 -0400", hash_original_method = "B022A84D94038C9BB0C01ED819C072BD", hash_generated_method = "E35871C26F51620688DDEE4EFEDDE624")
    private void grow(int newCapacity) {
        E[] newData = newElementArray(newCapacity);
        System.arraycopy(elementData, 0, newData, 0, elementCount);
        elementData = newData;
        addTaint(newCapacity);
        // ---------- Original Method ----------
        //E[] newData = newElementArray(newCapacity);
        //assert elementCount <= newCapacity;
        //System.arraycopy(elementData, 0, newData, 0, elementCount);
        //elementData = newData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.747 -0400", hash_original_method = "183736DEF5A7AE33048C32065B21DF67", hash_generated_method = "3BE46AB6E90C5CAC5CB4B1431C7214D4")
    private void growByOne() {
        int adding = 0;
        {
            {
                boolean var28F6DF2B41A53CDE1C60C1BFD65ACDED_1719158366 = ((adding = elementData.length) == 0);
                {
                    adding = 1;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            adding = capacityIncrement;
        } //End block
        E[] newData = newElementArray(elementData.length + adding);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.748 -0400", hash_original_method = "1763D1FD6D85CB337349BE3D39A45770", hash_generated_method = "A93631D9400C7AA3F7FD9EFE36FD8F73")
    private void growBy(int required) {
        int adding = 0;
        {
            {
                boolean var28F6DF2B41A53CDE1C60C1BFD65ACDED_265058985 = ((adding = elementData.length) == 0);
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
        E[] newData = newElementArray(elementData.length + adding);
        System.arraycopy(elementData, 0, newData, 0, elementCount);
        elementData = newData;
        addTaint(required);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.749 -0400", hash_original_method = "20A64E7812064C08C37EDD86F8A561DF", hash_generated_method = "6D578A5735CF71384462A41B75F86B20")
    @Override
    public synchronized int hashCode() {
        int result = 1;
        {
            int i = 0;
            {
                result = (31 * result)
                    + (elementData[i] == null ? 0 : elementData[i].hashCode());
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_719158657 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_719158657;
        // ---------- Original Method ----------
        //int result = 1;
        //for (int i = 0; i < elementCount; i++) {
            //result = (31 * result)
                    //+ (elementData[i] == null ? 0 : elementData[i].hashCode());
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.749 -0400", hash_original_method = "BA52EF79315F2CDCEE831A2AC6873E19", hash_generated_method = "9F0A8608AE1F7D8905EC3E45483530DE")
    @Override
    public int indexOf(Object object) {
        int varE73F9E0C1A3B81CDEF050C43218DC8D9_618235098 = (indexOf(object, 0));
        addTaint(object.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_670866018 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_670866018;
        // ---------- Original Method ----------
        //return indexOf(object, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.750 -0400", hash_original_method = "24750353DFD7303BB9261ABCF2B08CBF", hash_generated_method = "F7C34CC55A83288A45B9A5F8ED031EEE")
    public synchronized int indexOf(Object object, int location) {
        {
            {
                int i = location;
                {
                    {
                        boolean var6058C077AE20E477BC66A81239047631_14648893 = (object.equals(elementData[i]));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                int i = location;
            } //End collapsed parenthetic
        } //End block
        addTaint(object.getTaint());
        addTaint(location);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_619891988 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_619891988;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.750 -0400", hash_original_method = "288EF4E8EFAE610E93F8F6663B1B7C8C", hash_generated_method = "1DC56E3FFA4F9F15331761FD505027B7")
    public synchronized void insertElementAt(E object, int location) {
        {
            {
                growByOne();
            } //End block
            int count = elementCount - location;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.750 -0400", hash_original_method = "0D33E0C5C56D3A9FC9F5E73253A3A2D0", hash_generated_method = "58815CB51F1D7B440102812F13D51AFF")
    @Override
    public synchronized boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_418706317 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_418706317;
        // ---------- Original Method ----------
        //return elementCount == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.751 -0400", hash_original_method = "BB5B48C89086DB15EEAE482333CC1417", hash_generated_method = "66FE665DF3F2EA58E57E871B6EBE1DB1")
    @SuppressWarnings("unchecked")
    public synchronized E lastElement() {
        E varB4EAC82CA7396A68D541C85D26508E83_1631730493 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1631730493 = (E) elementData[elementCount - 1];
        } //End block
        catch (IndexOutOfBoundsException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1631730493.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1631730493;
        // ---------- Original Method ----------
        //try {
            //return (E) elementData[elementCount - 1];
        //} catch (IndexOutOfBoundsException e) {
            //throw new NoSuchElementException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.751 -0400", hash_original_method = "A9A619C02ADFE7E6CEBC127D6A8D9A71", hash_generated_method = "29832DA939BBED341CF5F20F288F6757")
    @Override
    public synchronized int lastIndexOf(Object object) {
        int var511076739D83F05D2B69CDA20C63B8A3_352364243 = (lastIndexOf(object, elementCount - 1));
        addTaint(object.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_892008491 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_892008491;
        // ---------- Original Method ----------
        //return lastIndexOf(object, elementCount - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.752 -0400", hash_original_method = "DAE93837888D415686D1D0DD0C8E6815", hash_generated_method = "099EEB5201505988A9835400E32CEB69")
    public synchronized int lastIndexOf(Object object, int location) {
        {
            {
                {
                    int i = location;
                    {
                        {
                            boolean var3A356DDF00F01E8F368FF4B2197B5E1F_1106580872 = (object.equals(elementData[i]));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    int i = location;
                } //End collapsed parenthetic
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) throw arrayIndexOutOfBoundsException(location, elementCount);
        addTaint(object.getTaint());
        addTaint(location);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1888802953 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1888802953;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.752 -0400", hash_original_method = "E42458246EBBDA79B230DDF671CA6424", hash_generated_method = "F183D368109A5C48DB5EE9DD56908913")
    @SuppressWarnings("unchecked")
    @Override
    public synchronized E remove(int location) {
        E varB4EAC82CA7396A68D541C85D26508E83_1737764874 = null; //Variable for return #1
        {
            E result = (E) elementData[location];
            int size = elementCount - location;
            {
                System.arraycopy(elementData, location + 1, elementData,
                        location, size);
            } //End block
            elementData[elementCount] = null;
            varB4EAC82CA7396A68D541C85D26508E83_1737764874 = result;
        } //End block
        if (DroidSafeAndroidRuntime.control) throw arrayIndexOutOfBoundsException(location, elementCount);
        addTaint(location);
        varB4EAC82CA7396A68D541C85D26508E83_1737764874.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1737764874;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.753 -0400", hash_original_method = "823A94C57B65BF07C08540507330C163", hash_generated_method = "6EAF8E9972899202CE1D6C3F77896480")
    @Override
    public boolean remove(Object object) {
        boolean var2DF3D1B602150B1D95CE5F3A3FDBC88F_1605544224 = (removeElement(object));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_912908264 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_912908264;
        // ---------- Original Method ----------
        //return removeElement(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.753 -0400", hash_original_method = "8C6CFD9299AE63E6D8F991F5FD437E67", hash_generated_method = "BA84A1BB73659C52078BA8FB89128878")
    @Override
    public synchronized boolean removeAll(Collection<?> collection) {
        boolean var683870BA88109C83545AC694C96B458A_1507186093 = (super.removeAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_829250619 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_829250619;
        // ---------- Original Method ----------
        //return super.removeAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.753 -0400", hash_original_method = "B99CB02C0986A5ACE1171E44B2E88FC0", hash_generated_method = "5330FE2E74493E3618E66F0B127A6CEB")
    public synchronized void removeAllElements() {
        {
            int i = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.754 -0400", hash_original_method = "A6C501B9D7921F5FC1AF3EFCF61D0AD0", hash_generated_method = "F218F36770727BDBBF3C8BCF2A93EA6D")
    public synchronized boolean removeElement(Object object) {
        int index;
        {
            boolean var00053FECC15E7E9615B66BDB6BEEF16F_553924843 = ((index = indexOf(object, 0)) == -1);
        } //End collapsed parenthetic
        removeElementAt(index);
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1485476996 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1485476996;
        // ---------- Original Method ----------
        //int index;
        //if ((index = indexOf(object, 0)) == -1) {
            //return false;
        //}
        //removeElementAt(index);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.755 -0400", hash_original_method = "81AD5D3720D67EB52B93171772D8B025", hash_generated_method = "02AD496B5309AC9B1BA38F59E4F5003D")
    public synchronized void removeElementAt(int location) {
        {
            int size = elementCount - location;
            {
                System.arraycopy(elementData, location + 1, elementData,
                        location, size);
            } //End block
            elementData[elementCount] = null;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw arrayIndexOutOfBoundsException(location, elementCount);
        } //End block
        addTaint(location);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.756 -0400", hash_original_method = "6B459A814E902B0310B875E965EBDC88", hash_generated_method = "7966B55378C6E0485C0D06AE5E03A711")
    @Override
    protected void removeRange(int start, int end) {
        {
            {
                System.arraycopy(elementData, end, elementData, start,
                        elementCount - end);
                int newCount = elementCount - (end - start);
                Arrays.fill(elementData, newCount, elementCount, null);
                elementCount = newCount;
            } //End block
            {
                Arrays.fill(elementData, start, elementCount, null);
                elementCount = start;
            } //End block
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
        } //End block
        addTaint(end);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.757 -0400", hash_original_method = "3D3F7D0269EE9A4A0E6B970CD7AB0599", hash_generated_method = "4AE2577762F11940BA14ECE5803BC18C")
    @Override
    public synchronized boolean retainAll(Collection<?> collection) {
        boolean var2CAA4A68044DBB7B5CB3E7FF23679230_255001806 = (super.retainAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2072418738 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2072418738;
        // ---------- Original Method ----------
        //return super.retainAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.758 -0400", hash_original_method = "5EA1E920588C93D742AF1B9C3DFE2811", hash_generated_method = "14C27036F1B8C39E1C4E97ED9252F966")
    @SuppressWarnings("unchecked")
    @Override
    public synchronized E set(int location, E object) {
        E varB4EAC82CA7396A68D541C85D26508E83_1634191884 = null; //Variable for return #1
        {
            E result = (E) elementData[location];
            elementData[location] = object;
            varB4EAC82CA7396A68D541C85D26508E83_1634191884 = result;
        } //End block
        if (DroidSafeAndroidRuntime.control) throw arrayIndexOutOfBoundsException(location, elementCount);
        varB4EAC82CA7396A68D541C85D26508E83_1634191884.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1634191884;
        // ---------- Original Method ----------
        //if (location < elementCount) {
            //E result = (E) elementData[location];
            //elementData[location] = object;
            //return result;
        //}
        //throw arrayIndexOutOfBoundsException(location, elementCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.758 -0400", hash_original_method = "BE9BD0132B3B62E633B4EDB307CB7290", hash_generated_method = "030B361439082E69E82E2D7C9F0593A1")
    public synchronized void setElementAt(E object, int location) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.759 -0400", hash_original_method = "7F3B955AC73FEA732765CAFEDD4BC76C", hash_generated_method = "5792814B6D0CC16CE4918C0316A03F68")
    public synchronized void setSize(int length) {
        ensureCapacity(length);
        {
            Arrays.fill(elementData, length, elementCount, null);
        } //End block
        elementCount = length;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.760 -0400", hash_original_method = "81BBFD456B62650530A643B4CB14DC43", hash_generated_method = "97B413752CD80B9C6234B1C5DFDA813B")
    @Override
    public synchronized int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_686819363 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_686819363;
        // ---------- Original Method ----------
        //return elementCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.761 -0400", hash_original_method = "12E21B76E32A1D6BB3AE5A157C1F7673", hash_generated_method = "01997A7D62CD2294FF361F913BA9D1ED")
    @Override
    public synchronized List<E> subList(int start, int end) {
        List<E> varB4EAC82CA7396A68D541C85D26508E83_714719332 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_714719332 = new Collections.SynchronizedRandomAccessList<E>(super.subList(
                start, end), this);
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_714719332.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_714719332;
        // ---------- Original Method ----------
        //return new Collections.SynchronizedRandomAccessList<E>(super.subList(
                //start, end), this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.762 -0400", hash_original_method = "6F1E76A2D55423060704E3AA65069BB2", hash_generated_method = "15178B6EE4F1981D6E43F1A191457374")
    @Override
    public synchronized Object[] toArray() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_147190128 = null; //Variable for return #1
        Object[] result = new Object[elementCount];
        System.arraycopy(elementData, 0, result, 0, elementCount);
        varB4EAC82CA7396A68D541C85D26508E83_147190128 = result;
        varB4EAC82CA7396A68D541C85D26508E83_147190128.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_147190128;
        // ---------- Original Method ----------
        //Object[] result = new Object[elementCount];
        //System.arraycopy(elementData, 0, result, 0, elementCount);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.765 -0400", hash_original_method = "70C5BC6785EB6C524C2B60C494DFFFBE", hash_generated_method = "E159629F882E96450EF09C0E1217B037")
    @Override
    @SuppressWarnings("unchecked")
    public synchronized <T> T[] toArray(T[] contents) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_1815539513 = null; //Variable for return #1
        {
            Class<?> ct = contents.getClass().getComponentType();
            contents = (T[]) Array.newInstance(ct, elementCount);
        } //End block
        System.arraycopy(elementData, 0, contents, 0, elementCount);
        {
            contents[elementCount] = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1815539513 = contents;
        varB4EAC82CA7396A68D541C85D26508E83_1815539513.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1815539513;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.768 -0400", hash_original_method = "0DD9DB5F445E75E250BA34836212BB86", hash_generated_method = "DBE1B13F7864038B68B74190B08F64AF")
    @Override
    public synchronized String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_409765710 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_852504972 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_409765710 = "[]";
        } //End block
        int length = elementCount - 1;
        StringBuilder buffer = new StringBuilder(elementCount * 16);
        buffer.append('[');
        {
            int i = 0;
            {
                {
                    boolean var1EAEC00226A70062D4821DCC23A131E8_2082826708 = (elementData[i] == this);
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
            boolean var133E8E0A94865404CC8E7824CF7E87B9_119931053 = (elementData[length] == this);
            {
                buffer.append("(this Collection)");
            } //End block
            {
                buffer.append(elementData[length]);
            } //End block
        } //End collapsed parenthetic
        buffer.append(']');
        varB4EAC82CA7396A68D541C85D26508E83_852504972 = buffer.toString();
        String varA7E53CE21691AB073D9660D615818899_1270715558; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1270715558 = varB4EAC82CA7396A68D541C85D26508E83_409765710;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1270715558 = varB4EAC82CA7396A68D541C85D26508E83_852504972;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1270715558.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1270715558;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.769 -0400", hash_original_method = "FC23934C3FC3508F47E3F895F030378B", hash_generated_method = "67BB08EED6E7441D6B67A75C72DF5B64")
    public synchronized void trimToSize() {
        {
            grow(elementCount);
        } //End block
        // ---------- Original Method ----------
        //if (elementData.length != elementCount) {
            //grow(elementCount);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.770 -0400", hash_original_method = "93271132EFBEDC29196C798673AC5EE7", hash_generated_method = "00A9C4D3DE0B50771808F817E4C6F9F8")
    private synchronized void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        //stream.defaultWriteObject();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.770 -0400", hash_original_field = "63388E0D41356F5B13E53DDDE229677C", hash_generated_field = "39DE62F55D74BDCEA57CB029AC7D9C53")

    private static final long serialVersionUID = -2767605614048989439L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:12.770 -0400", hash_original_field = "F94234FC21E5DB8AB303ACA6C6E18129", hash_generated_field = "F9EDE767CC2D62732638F03DE92C8707")

    private static final int DEFAULT_SIZE = 10;
    // orphaned legacy method
    @SuppressWarnings("unchecked")
            public E nextElement() {
                synchronized (Vector.this) {
                    if (pos < elementCount) {
                        return (E) elementData[pos++];
                    }
                }
                throw new NoSuchElementException();
            }
    
    // orphaned legacy method
    public boolean hasMoreElements() {
                return pos < elementCount;
            }
    
    // orphaned legacy field
    int pos = 0;
    
}

