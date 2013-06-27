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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.790 -0400", hash_original_field = "BC8C6DCF12CE09E50A98BB57ADFCADD9", hash_generated_field = "499A2D73243CED99A42E214D64505A6C")

    protected int elementCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.808 -0400", hash_original_field = "8D395F1876FF8AE01BE52A9C4C2ED552", hash_generated_field = "0B3F426A5758654DA42168DCEAA2747C")

    protected Object[] elementData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.808 -0400", hash_original_field = "7D8D485EB9C5EE294297FC18663D46D8", hash_generated_field = "C57732C85DED3048B8128B9506ED7293")

    protected int capacityIncrement;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.809 -0400", hash_original_method = "DACE16FEA3F29475D20FB4F2AE2C4BF3", hash_generated_method = "F92FDEEA28BC7E4B901A0A343D42232D")
    public  Vector() {
        this(DEFAULT_SIZE, 0);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.809 -0400", hash_original_method = "516F631FEB27C4B8AC76BAFF727DB150", hash_generated_method = "F3CDA2715564D8E8516468F487D83DFA")
    public  Vector(int capacity) {
        this(capacity, 0);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.809 -0400", hash_original_method = "B35B3D540AE265DD802702BED4157C47", hash_generated_method = "1D161C898B7C2B3F0F38E06F9F5D1032")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.809 -0400", hash_original_method = "5554DADF2588E03BDCF1E2168D3E3C3F", hash_generated_method = "234FB39D1109390FB5C40AC01D45033F")
    public  Vector(Collection<? extends E> collection) {
        this(collection.size(), 0);
        Iterator<? extends E> it;
        it = collection.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1710148652 = (it.hasNext());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.810 -0400", hash_original_method = "088E691065B085AAA9856C71AD537C28", hash_generated_method = "40B99201AB31AB99FA3CBC5F3ECB850D")
    @SuppressWarnings("unchecked")
    private E[] newElementArray(int size) {
        E[] varB4EAC82CA7396A68D541C85D26508E83_729513754 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_729513754 = (E[]) new Object[size];
        addTaint(size);
        varB4EAC82CA7396A68D541C85D26508E83_729513754.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_729513754;
        // ---------- Original Method ----------
        //return (E[]) new Object[size];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.810 -0400", hash_original_method = "48191DBEFAEF26CE3AD2676469C6C588", hash_generated_method = "3476632618807434BE8A96CCB83845B5")
    @Override
    public void add(int location, E object) {
        insertElementAt(object, location);
        addTaint(location);
        addTaint(object.getTaint());
        // ---------- Original Method ----------
        //insertElementAt(object, location);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.810 -0400", hash_original_method = "4A1B135502A4FBF53B5971ADD0895265", hash_generated_method = "3693DA7DC0D4E80F4EB3689C4CA0C6C9")
    @Override
    public synchronized boolean add(E object) {
        {
            growByOne();
        } //End block
        elementData[elementCount++] = object;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1631755053 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1631755053;
        // ---------- Original Method ----------
        //if (elementCount == elementData.length) {
            //growByOne();
        //}
        //elementData[elementCount++] = object;
        //modCount++;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.818 -0400", hash_original_method = "721C95E0B3ACA6F09AE8F219EA79313F", hash_generated_method = "31CA6DF1D1B18CC7B8929EA04512F7FF")
    @Override
    public synchronized boolean addAll(int location, Collection<? extends E> collection) {
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
                boolean varB2FF4435B274CC4BE01D264DEA08F957_526052326 = (it.hasNext());
                {
                    elementData[location++] = it.next();
                } //End block
            } //End collapsed parenthetic
            elementCount += size;
        } //End block
        if (DroidSafeAndroidRuntime.control) throw arrayIndexOutOfBoundsException(location, elementCount);
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1412027974 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1412027974;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.818 -0400", hash_original_method = "936868945967E6EE9BEE2301A3FC2D7D", hash_generated_method = "4EA78DD261DA37BB574F5724FF30CF25")
    @Override
    public synchronized boolean addAll(Collection<? extends E> collection) {
        boolean var03502A2162BCCC449AB5D23C58C8227A_218818840 = (addAll(elementCount, collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1196195000 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1196195000;
        // ---------- Original Method ----------
        //return addAll(elementCount, collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.819 -0400", hash_original_method = "A5163E0F34F09A3D8DEA4C412903D1D1", hash_generated_method = "DBB5A700C860712A2B4620057CA642F0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.819 -0400", hash_original_method = "DD1AE1F8EA98D3605FDD193E0651B9D6", hash_generated_method = "FD66090D5CF29A1FABD3038A3C9B72E4")
    public synchronized int capacity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2114720444 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2114720444;
        // ---------- Original Method ----------
        //return elementData.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.819 -0400", hash_original_method = "1F4E1B041EF06199B18000DD20E283A1", hash_generated_method = "CB8944604C59D0C0C157C3038F849082")
    @Override
    public void clear() {
        removeAllElements();
        // ---------- Original Method ----------
        //removeAllElements();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.820 -0400", hash_original_method = "1610A6C93F0D6F1C66DC0DFCBD33D1B2", hash_generated_method = "539B990A4DAD1BF76DDCA70B3A2649AD")
    @Override
    @SuppressWarnings("unchecked")
    public synchronized Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1368509723 = null; //Variable for return #1
        try 
        {
            Vector<E> vector;
            vector = (Vector<E>) super.clone();
            vector.elementData = elementData.clone();
            varB4EAC82CA7396A68D541C85D26508E83_1368509723 = vector;
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1368509723.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1368509723;
        // ---------- Original Method ----------
        //try {
            //Vector<E> vector = (Vector<E>) super.clone();
            //vector.elementData = elementData.clone();
            //return vector;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.837 -0400", hash_original_method = "4017403066D0A85EBF82EC88CFE4ED84", hash_generated_method = "BACDBCB8C4C90A6A8E0D129643AD6527")
    @Override
    public boolean contains(Object object) {
        boolean varFC609B1C0AB8A3A126012E7353465119_593107225 = (indexOf(object, 0) != -1);
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_230774896 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_230774896;
        // ---------- Original Method ----------
        //return indexOf(object, 0) != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.837 -0400", hash_original_method = "51334898ABB14C1CD821FC4FE1B2383C", hash_generated_method = "98F19113A3D46F949C4487BE0580FB13")
    @Override
    public synchronized boolean containsAll(Collection<?> collection) {
        boolean varF935A9EEA803E51431822CE5207F3376_1819183086 = (super.containsAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_935829708 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_935829708;
        // ---------- Original Method ----------
        //return super.containsAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.838 -0400", hash_original_method = "9FCD2BB7391A67913F5DC5B0A38C9668", hash_generated_method = "729DF9DBCFE6AECF2FE7D68CF505468B")
    public synchronized void copyInto(Object[] elements) {
        System.arraycopy(elementData, 0, elements, 0, elementCount);
        addTaint(elements[0].getTaint());
        // ---------- Original Method ----------
        //System.arraycopy(elementData, 0, elements, 0, elementCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.838 -0400", hash_original_method = "3CA02A8FB0EDF4F6C1F1F261516DC679", hash_generated_method = "3DEF7E534AE2DC3A4AE44CA1AF3A4450")
    @SuppressWarnings("unchecked")
    public synchronized E elementAt(int location) {
        E varB4EAC82CA7396A68D541C85D26508E83_1309031711 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_1309031711 = (E) elementData[location];
        } //End block
        if (DroidSafeAndroidRuntime.control) throw arrayIndexOutOfBoundsException(location, elementCount);
        addTaint(location);
        varB4EAC82CA7396A68D541C85D26508E83_1309031711.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1309031711;
        // ---------- Original Method ----------
        //if (location < elementCount) {
            //return (E) elementData[location];
        //}
        //throw arrayIndexOutOfBoundsException(location, elementCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.858 -0400", hash_original_method = "B6E84DE201AAEF8307F5E7CA8A6AEF90", hash_generated_method = "7EEB0CCA33FC9D913FD838A09D2D5D3F")
    public Enumeration<E> elements() {
        Enumeration<E> varB4EAC82CA7396A68D541C85D26508E83_1210885452 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1210885452 = new Enumeration<E>() {
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
        varB4EAC82CA7396A68D541C85D26508E83_1210885452.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1210885452;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.858 -0400", hash_original_method = "DF06508A0F0ED83B84FE34EF6D5FCD26", hash_generated_method = "C53A44241982828EC648670E9BDF7D51")
    public synchronized void ensureCapacity(int minimumCapacity) {
        {
            int next;
            next = (capacityIncrement <= 0 ? elementData.length
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.859 -0400", hash_original_method = "18CA94477F381022C117A5BE2C4C7154", hash_generated_method = "5DB62F681EBC75328B4D6EFB1DAC13BC")
    @Override
    public synchronized boolean equals(Object object) {
        {
            List<?> list;
            list = (List<?>) object;
            {
                boolean var87DA8CDCBC1CCBE821948EA1C5E2BC78_1545033160 = (list.size() != elementCount);
            } //End collapsed parenthetic
            int index;
            index = 0;
            Iterator<?> it;
            it = list.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_284100640 = (it.hasNext());
                {
                    Object e1, e2;
                    e1 = elementData[index++];
                    e2 = it.next();
                    {
                        boolean var340C63FF299BF53687C9CFA16F96F134_689959957 = (!(e1 == null ? e2 == null : e1.equals(e2))); //DSFIXME:  CODE0008: Nested ternary operator in expression
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_340349835 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_340349835;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.859 -0400", hash_original_method = "D89343B924D76ED75CDC4E663D066F77", hash_generated_method = "E033915EE6EF5B92272F758839FA4747")
    @SuppressWarnings("unchecked")
    public synchronized E firstElement() {
        E varB4EAC82CA7396A68D541C85D26508E83_587894325 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_587894325 = (E) elementData[0];
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_587894325.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_587894325;
        // ---------- Original Method ----------
        //if (elementCount > 0) {
            //return (E) elementData[0];
        //}
        //throw new NoSuchElementException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.860 -0400", hash_original_method = "E09D80C19A651BF8C26D5375E71CA6A0", hash_generated_method = "1C5BB73F2B84A191C929C0D63F95CC43")
    @Override
    public E get(int location) {
        E varB4EAC82CA7396A68D541C85D26508E83_1416337199 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1416337199 = elementAt(location);
        addTaint(location);
        varB4EAC82CA7396A68D541C85D26508E83_1416337199.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1416337199;
        // ---------- Original Method ----------
        //return elementAt(location);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.863 -0400", hash_original_method = "B022A84D94038C9BB0C01ED819C072BD", hash_generated_method = "64010BA86B8C23F5876C3F998703F841")
    private void grow(int newCapacity) {
        E[] newData;
        newData = newElementArray(newCapacity);
        System.arraycopy(elementData, 0, newData, 0, elementCount);
        elementData = newData;
        addTaint(newCapacity);
        // ---------- Original Method ----------
        //E[] newData = newElementArray(newCapacity);
        //assert elementCount <= newCapacity;
        //System.arraycopy(elementData, 0, newData, 0, elementCount);
        //elementData = newData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.863 -0400", hash_original_method = "183736DEF5A7AE33048C32065B21DF67", hash_generated_method = "AFF9E3AD1EAE051EFB41AE3D2B694908")
    private void growByOne() {
        int adding;
        adding = 0;
        {
            {
                boolean var28F6DF2B41A53CDE1C60C1BFD65ACDED_2135676757 = ((adding = elementData.length) == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.869 -0400", hash_original_method = "1763D1FD6D85CB337349BE3D39A45770", hash_generated_method = "AFB540528018718D0B0CE70E3E32A75D")
    private void growBy(int required) {
        int adding;
        adding = 0;
        {
            {
                boolean var28F6DF2B41A53CDE1C60C1BFD65ACDED_152994011 = ((adding = elementData.length) == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.888 -0400", hash_original_method = "20A64E7812064C08C37EDD86F8A561DF", hash_generated_method = "C321C6CF7DE2FE2A3A103AB44C6ABB22")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2115951930 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2115951930;
        // ---------- Original Method ----------
        //int result = 1;
        //for (int i = 0; i < elementCount; i++) {
            //result = (31 * result)
                    //+ (elementData[i] == null ? 0 : elementData[i].hashCode());
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.905 -0400", hash_original_method = "BA52EF79315F2CDCEE831A2AC6873E19", hash_generated_method = "9F4ED13EF10875A518EFB49A2D8DEAF9")
    @Override
    public int indexOf(Object object) {
        int varE73F9E0C1A3B81CDEF050C43218DC8D9_344677756 = (indexOf(object, 0));
        addTaint(object.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_372632165 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_372632165;
        // ---------- Original Method ----------
        //return indexOf(object, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.905 -0400", hash_original_method = "24750353DFD7303BB9261ABCF2B08CBF", hash_generated_method = "1FFD6084E755F6ED2B7A0824B5F394FF")
    public synchronized int indexOf(Object object, int location) {
        {
            {
                int i;
                i = location;
                {
                    {
                        boolean var6058C077AE20E477BC66A81239047631_163984568 = (object.equals(elementData[i]));
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
        addTaint(object.getTaint());
        addTaint(location);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_8228088 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_8228088;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.906 -0400", hash_original_method = "288EF4E8EFAE610E93F8F6663B1B7C8C", hash_generated_method = "7976CB8E209B87918ADBD7DF261C96DB")
    public synchronized void insertElementAt(E object, int location) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.906 -0400", hash_original_method = "0D33E0C5C56D3A9FC9F5E73253A3A2D0", hash_generated_method = "43A80A8947493658ABD341F34CE00DE5")
    @Override
    public synchronized boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1719479 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1719479;
        // ---------- Original Method ----------
        //return elementCount == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.907 -0400", hash_original_method = "BB5B48C89086DB15EEAE482333CC1417", hash_generated_method = "F07763C9624C24C40E9CBFF668183516")
    @SuppressWarnings("unchecked")
    public synchronized E lastElement() {
        E varB4EAC82CA7396A68D541C85D26508E83_1153094929 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1153094929 = (E) elementData[elementCount - 1];
        } //End block
        catch (IndexOutOfBoundsException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1153094929.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1153094929;
        // ---------- Original Method ----------
        //try {
            //return (E) elementData[elementCount - 1];
        //} catch (IndexOutOfBoundsException e) {
            //throw new NoSuchElementException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.907 -0400", hash_original_method = "A9A619C02ADFE7E6CEBC127D6A8D9A71", hash_generated_method = "31D707F5A5894BB2AD0FD9D08DCD1601")
    @Override
    public synchronized int lastIndexOf(Object object) {
        int var511076739D83F05D2B69CDA20C63B8A3_1651865412 = (lastIndexOf(object, elementCount - 1));
        addTaint(object.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1510194811 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1510194811;
        // ---------- Original Method ----------
        //return lastIndexOf(object, elementCount - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.908 -0400", hash_original_method = "DAE93837888D415686D1D0DD0C8E6815", hash_generated_method = "582496C64DEA9C22BC42B26F3CDF277D")
    public synchronized int lastIndexOf(Object object, int location) {
        {
            {
                {
                    int i;
                    i = location;
                    {
                        {
                            boolean var3A356DDF00F01E8F368FF4B2197B5E1F_948826663 = (object.equals(elementData[i]));
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
        addTaint(object.getTaint());
        addTaint(location);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_644395081 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_644395081;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.909 -0400", hash_original_method = "E42458246EBBDA79B230DDF671CA6424", hash_generated_method = "821728DF0E2BFA21EB96CF5D707295B7")
    @SuppressWarnings("unchecked")
    @Override
    public synchronized E remove(int location) {
        E varB4EAC82CA7396A68D541C85D26508E83_1928262628 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_1928262628 = result;
        } //End block
        if (DroidSafeAndroidRuntime.control) throw arrayIndexOutOfBoundsException(location, elementCount);
        addTaint(location);
        varB4EAC82CA7396A68D541C85D26508E83_1928262628.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1928262628;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.909 -0400", hash_original_method = "823A94C57B65BF07C08540507330C163", hash_generated_method = "50FA5B454E86F64EBE23C01F4A14A9EE")
    @Override
    public boolean remove(Object object) {
        boolean var2DF3D1B602150B1D95CE5F3A3FDBC88F_1596097825 = (removeElement(object));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1370728438 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1370728438;
        // ---------- Original Method ----------
        //return removeElement(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.909 -0400", hash_original_method = "8C6CFD9299AE63E6D8F991F5FD437E67", hash_generated_method = "8F896AADA406625C354B017F67A087F5")
    @Override
    public synchronized boolean removeAll(Collection<?> collection) {
        boolean var683870BA88109C83545AC694C96B458A_766896032 = (super.removeAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_879168397 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_879168397;
        // ---------- Original Method ----------
        //return super.removeAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.934 -0400", hash_original_method = "B99CB02C0986A5ACE1171E44B2E88FC0", hash_generated_method = "C7C25FD730655FC2413FA1DEF25647CC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.934 -0400", hash_original_method = "A6C501B9D7921F5FC1AF3EFCF61D0AD0", hash_generated_method = "1174977DF22B8E7468E483DFA81871C6")
    public synchronized boolean removeElement(Object object) {
        int index;
        {
            boolean var00053FECC15E7E9615B66BDB6BEEF16F_1461403979 = ((index = indexOf(object, 0)) == -1);
        } //End collapsed parenthetic
        removeElementAt(index);
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1630802406 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1630802406;
        // ---------- Original Method ----------
        //int index;
        //if ((index = indexOf(object, 0)) == -1) {
            //return false;
        //}
        //removeElementAt(index);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.935 -0400", hash_original_method = "81AD5D3720D67EB52B93171772D8B025", hash_generated_method = "BEA29F4841AEE3122FFF19A3C5A9D756")
    public synchronized void removeElementAt(int location) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.935 -0400", hash_original_method = "6B459A814E902B0310B875E965EBDC88", hash_generated_method = "5F543292EC3AF66BE0C13914868580CB")
    @Override
    protected void removeRange(int start, int end) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.936 -0400", hash_original_method = "3D3F7D0269EE9A4A0E6B970CD7AB0599", hash_generated_method = "3B3E9D50BE04A1A96170D5D590C8FC64")
    @Override
    public synchronized boolean retainAll(Collection<?> collection) {
        boolean var2CAA4A68044DBB7B5CB3E7FF23679230_471285480 = (super.retainAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_615673889 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_615673889;
        // ---------- Original Method ----------
        //return super.retainAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.936 -0400", hash_original_method = "5EA1E920588C93D742AF1B9C3DFE2811", hash_generated_method = "20B5D89D6AE0B1B3BF199A1B436B709D")
    @SuppressWarnings("unchecked")
    @Override
    public synchronized E set(int location, E object) {
        E varB4EAC82CA7396A68D541C85D26508E83_19436905 = null; //Variable for return #1
        {
            E result;
            result = (E) elementData[location];
            elementData[location] = object;
            varB4EAC82CA7396A68D541C85D26508E83_19436905 = result;
        } //End block
        if (DroidSafeAndroidRuntime.control) throw arrayIndexOutOfBoundsException(location, elementCount);
        varB4EAC82CA7396A68D541C85D26508E83_19436905.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_19436905;
        // ---------- Original Method ----------
        //if (location < elementCount) {
            //E result = (E) elementData[location];
            //elementData[location] = object;
            //return result;
        //}
        //throw arrayIndexOutOfBoundsException(location, elementCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.936 -0400", hash_original_method = "BE9BD0132B3B62E633B4EDB307CB7290", hash_generated_method = "030B361439082E69E82E2D7C9F0593A1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.943 -0400", hash_original_method = "7F3B955AC73FEA732765CAFEDD4BC76C", hash_generated_method = "5792814B6D0CC16CE4918C0316A03F68")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.943 -0400", hash_original_method = "81BBFD456B62650530A643B4CB14DC43", hash_generated_method = "0E7728E3670A73F2E1D676709423551F")
    @Override
    public synchronized int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1609246012 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1609246012;
        // ---------- Original Method ----------
        //return elementCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.949 -0400", hash_original_method = "12E21B76E32A1D6BB3AE5A157C1F7673", hash_generated_method = "F558D2DF210F0EF471C756B9C997A04F")
    @Override
    public synchronized List<E> subList(int start, int end) {
        List<E> varB4EAC82CA7396A68D541C85D26508E83_708167508 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_708167508 = new Collections.SynchronizedRandomAccessList<E>(super.subList(
                start, end), this);
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_708167508.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_708167508;
        // ---------- Original Method ----------
        //return new Collections.SynchronizedRandomAccessList<E>(super.subList(
                //start, end), this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.949 -0400", hash_original_method = "6F1E76A2D55423060704E3AA65069BB2", hash_generated_method = "943482411D219DC4C66A267D70AE1673")
    @Override
    public synchronized Object[] toArray() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_1528616860 = null; //Variable for return #1
        Object[] result;
        result = new Object[elementCount];
        System.arraycopy(elementData, 0, result, 0, elementCount);
        varB4EAC82CA7396A68D541C85D26508E83_1528616860 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1528616860.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1528616860;
        // ---------- Original Method ----------
        //Object[] result = new Object[elementCount];
        //System.arraycopy(elementData, 0, result, 0, elementCount);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.968 -0400", hash_original_method = "70C5BC6785EB6C524C2B60C494DFFFBE", hash_generated_method = "9201E23375717296CC75EA05A1C70E9F")
    @Override
    @SuppressWarnings("unchecked")
    public synchronized <T> T[] toArray(T[] contents) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_1546136879 = null; //Variable for return #1
        {
            Class<?> ct;
            ct = contents.getClass().getComponentType();
            contents = (T[]) Array.newInstance(ct, elementCount);
        } //End block
        System.arraycopy(elementData, 0, contents, 0, elementCount);
        {
            contents[elementCount] = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1546136879 = contents;
        varB4EAC82CA7396A68D541C85D26508E83_1546136879.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1546136879;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.969 -0400", hash_original_method = "0DD9DB5F445E75E250BA34836212BB86", hash_generated_method = "AB244DF8B319EDDC40962CE5E5C0D3C1")
    @Override
    public synchronized String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1590136874 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1725990647 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1590136874 = "[]";
        } //End block
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
                    boolean var1EAEC00226A70062D4821DCC23A131E8_188009687 = (elementData[i] == this);
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
            boolean var133E8E0A94865404CC8E7824CF7E87B9_1129626619 = (elementData[length] == this);
            {
                buffer.append("(this Collection)");
            } //End block
            {
                buffer.append(elementData[length]);
            } //End block
        } //End collapsed parenthetic
        buffer.append(']');
        varB4EAC82CA7396A68D541C85D26508E83_1725990647 = buffer.toString();
        String varA7E53CE21691AB073D9660D615818899_1117141000; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1117141000 = varB4EAC82CA7396A68D541C85D26508E83_1590136874;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1117141000 = varB4EAC82CA7396A68D541C85D26508E83_1725990647;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1117141000.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1117141000;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.969 -0400", hash_original_method = "FC23934C3FC3508F47E3F895F030378B", hash_generated_method = "67BB08EED6E7441D6B67A75C72DF5B64")
    public synchronized void trimToSize() {
        {
            grow(elementCount);
        } //End block
        // ---------- Original Method ----------
        //if (elementData.length != elementCount) {
            //grow(elementCount);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.969 -0400", hash_original_method = "93271132EFBEDC29196C798673AC5EE7", hash_generated_method = "00A9C4D3DE0B50771808F817E4C6F9F8")
    private synchronized void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        //stream.defaultWriteObject();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.969 -0400", hash_original_field = "63388E0D41356F5B13E53DDDE229677C", hash_generated_field = "221DC1B405F92F6FA4C6FD7306DFBBE1")

    private static long serialVersionUID = -2767605614048989439L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:54.969 -0400", hash_original_field = "F94234FC21E5DB8AB303ACA6C6E18129", hash_generated_field = "4911CD497D3EBB1CE18CD40D6F15774C")

    private static int DEFAULT_SIZE = 10;
}

