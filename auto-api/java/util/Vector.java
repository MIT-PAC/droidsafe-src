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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.729 -0400", hash_original_field = "BC8C6DCF12CE09E50A98BB57ADFCADD9", hash_generated_field = "499A2D73243CED99A42E214D64505A6C")

    protected int elementCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.729 -0400", hash_original_field = "8D395F1876FF8AE01BE52A9C4C2ED552", hash_generated_field = "0B3F426A5758654DA42168DCEAA2747C")

    protected Object[] elementData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.729 -0400", hash_original_field = "7D8D485EB9C5EE294297FC18663D46D8", hash_generated_field = "C57732C85DED3048B8128B9506ED7293")

    protected int capacityIncrement;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.729 -0400", hash_original_method = "DACE16FEA3F29475D20FB4F2AE2C4BF3", hash_generated_method = "F92FDEEA28BC7E4B901A0A343D42232D")
    public  Vector() {
        this(DEFAULT_SIZE, 0);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.730 -0400", hash_original_method = "516F631FEB27C4B8AC76BAFF727DB150", hash_generated_method = "F3CDA2715564D8E8516468F487D83DFA")
    public  Vector(int capacity) {
        this(capacity, 0);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.730 -0400", hash_original_method = "B35B3D540AE265DD802702BED4157C47", hash_generated_method = "1D161C898B7C2B3F0F38E06F9F5D1032")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.730 -0400", hash_original_method = "5554DADF2588E03BDCF1E2168D3E3C3F", hash_generated_method = "8FCAC5EA739BC2C7A033829C1AD4D7F5")
    public  Vector(Collection<? extends E> collection) {
        this(collection.size(), 0);
        Iterator<? extends E> it;
        it = collection.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1874864811 = (it.hasNext());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.732 -0400", hash_original_method = "088E691065B085AAA9856C71AD537C28", hash_generated_method = "A2CAC55ED352D262C4D1D3D3730762AD")
    @SuppressWarnings("unchecked")
    private E[] newElementArray(int size) {
        E[] varB4EAC82CA7396A68D541C85D26508E83_1713156274 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1713156274 = (E[]) new Object[size];
        addTaint(size);
        varB4EAC82CA7396A68D541C85D26508E83_1713156274.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1713156274;
        // ---------- Original Method ----------
        //return (E[]) new Object[size];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.738 -0400", hash_original_method = "48191DBEFAEF26CE3AD2676469C6C588", hash_generated_method = "3476632618807434BE8A96CCB83845B5")
    @Override
    public void add(int location, E object) {
        insertElementAt(object, location);
        addTaint(location);
        addTaint(object.getTaint());
        // ---------- Original Method ----------
        //insertElementAt(object, location);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.741 -0400", hash_original_method = "4A1B135502A4FBF53B5971ADD0895265", hash_generated_method = "EBF563FAB64A5FEE74CC4B1B127F4D89")
    @Override
    public synchronized boolean add(E object) {
        {
            growByOne();
        } //End block
        elementData[elementCount++] = object;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_949581 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_949581;
        // ---------- Original Method ----------
        //if (elementCount == elementData.length) {
            //growByOne();
        //}
        //elementData[elementCount++] = object;
        //modCount++;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.753 -0400", hash_original_method = "721C95E0B3ACA6F09AE8F219EA79313F", hash_generated_method = "9E1430CD6B1B58F90D499CA6A90D033A")
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
                boolean varB2FF4435B274CC4BE01D264DEA08F957_2091433550 = (it.hasNext());
                {
                    elementData[location++] = it.next();
                } //End block
            } //End collapsed parenthetic
            elementCount += size;
        } //End block
        if (DroidSafeAndroidRuntime.control) throw arrayIndexOutOfBoundsException(location, elementCount);
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1988060137 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1988060137;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.763 -0400", hash_original_method = "936868945967E6EE9BEE2301A3FC2D7D", hash_generated_method = "67E36690C891322BE372CA0FBA26E18E")
    @Override
    public synchronized boolean addAll(Collection<? extends E> collection) {
        boolean var03502A2162BCCC449AB5D23C58C8227A_687756962 = (addAll(elementCount, collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_693610385 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_693610385;
        // ---------- Original Method ----------
        //return addAll(elementCount, collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.763 -0400", hash_original_method = "A5163E0F34F09A3D8DEA4C412903D1D1", hash_generated_method = "DBB5A700C860712A2B4620057CA642F0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.763 -0400", hash_original_method = "DD1AE1F8EA98D3605FDD193E0651B9D6", hash_generated_method = "17C3593AC85D1E7703C3FF6048ABAFE7")
    public synchronized int capacity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_922701829 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_922701829;
        // ---------- Original Method ----------
        //return elementData.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.764 -0400", hash_original_method = "1F4E1B041EF06199B18000DD20E283A1", hash_generated_method = "CB8944604C59D0C0C157C3038F849082")
    @Override
    public void clear() {
        removeAllElements();
        // ---------- Original Method ----------
        //removeAllElements();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.764 -0400", hash_original_method = "1610A6C93F0D6F1C66DC0DFCBD33D1B2", hash_generated_method = "E52B2169CF84D530A97AFF47FB346C2D")
    @Override
    @SuppressWarnings("unchecked")
    public synchronized Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_113461486 = null; //Variable for return #1
        try 
        {
            Vector<E> vector;
            vector = (Vector<E>) super.clone();
            vector.elementData = elementData.clone();
            varB4EAC82CA7396A68D541C85D26508E83_113461486 = vector;
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_113461486.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_113461486;
        // ---------- Original Method ----------
        //try {
            //Vector<E> vector = (Vector<E>) super.clone();
            //vector.elementData = elementData.clone();
            //return vector;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.765 -0400", hash_original_method = "4017403066D0A85EBF82EC88CFE4ED84", hash_generated_method = "746682DA119F179928B8FFCD154A154A")
    @Override
    public boolean contains(Object object) {
        boolean varFC609B1C0AB8A3A126012E7353465119_915748622 = (indexOf(object, 0) != -1);
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1097617251 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1097617251;
        // ---------- Original Method ----------
        //return indexOf(object, 0) != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.765 -0400", hash_original_method = "51334898ABB14C1CD821FC4FE1B2383C", hash_generated_method = "CA23279C3DDE494F5546264B07865C4E")
    @Override
    public synchronized boolean containsAll(Collection<?> collection) {
        boolean varF935A9EEA803E51431822CE5207F3376_2122107468 = (super.containsAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1780718032 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1780718032;
        // ---------- Original Method ----------
        //return super.containsAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.765 -0400", hash_original_method = "9FCD2BB7391A67913F5DC5B0A38C9668", hash_generated_method = "729DF9DBCFE6AECF2FE7D68CF505468B")
    public synchronized void copyInto(Object[] elements) {
        System.arraycopy(elementData, 0, elements, 0, elementCount);
        addTaint(elements[0].getTaint());
        // ---------- Original Method ----------
        //System.arraycopy(elementData, 0, elements, 0, elementCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.766 -0400", hash_original_method = "3CA02A8FB0EDF4F6C1F1F261516DC679", hash_generated_method = "BF75639BD507330F1BFD7164921D3135")
    @SuppressWarnings("unchecked")
    public synchronized E elementAt(int location) {
        E varB4EAC82CA7396A68D541C85D26508E83_124527571 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_124527571 = (E) elementData[location];
        } //End block
        if (DroidSafeAndroidRuntime.control) throw arrayIndexOutOfBoundsException(location, elementCount);
        addTaint(location);
        varB4EAC82CA7396A68D541C85D26508E83_124527571.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_124527571;
        // ---------- Original Method ----------
        //if (location < elementCount) {
            //return (E) elementData[location];
        //}
        //throw arrayIndexOutOfBoundsException(location, elementCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.766 -0400", hash_original_method = "B6E84DE201AAEF8307F5E7CA8A6AEF90", hash_generated_method = "0B720FBCA13E5C34B9402EE6E6F5A413")
    public Enumeration<E> elements() {
        Enumeration<E> varB4EAC82CA7396A68D541C85D26508E83_732300442 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_732300442 = new Enumeration<E>() {
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
        varB4EAC82CA7396A68D541C85D26508E83_732300442.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_732300442;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.777 -0400", hash_original_method = "DF06508A0F0ED83B84FE34EF6D5FCD26", hash_generated_method = "C53A44241982828EC648670E9BDF7D51")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.778 -0400", hash_original_method = "18CA94477F381022C117A5BE2C4C7154", hash_generated_method = "E77213452478B3A7CD1EA2E442781CEB")
    @Override
    public synchronized boolean equals(Object object) {
        {
            List<?> list;
            list = (List<?>) object;
            {
                boolean var87DA8CDCBC1CCBE821948EA1C5E2BC78_1350090760 = (list.size() != elementCount);
            } //End collapsed parenthetic
            int index;
            index = 0;
            Iterator<?> it;
            it = list.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_556417276 = (it.hasNext());
                {
                    Object e1, e2;
                    e1 = elementData[index++];
                    e2 = it.next();
                    {
                        boolean var340C63FF299BF53687C9CFA16F96F134_239890973 = (!(e1 == null ? e2 == null : e1.equals(e2))); //DSFIXME:  CODE0008: Nested ternary operator in expression
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1420447095 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1420447095;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.778 -0400", hash_original_method = "D89343B924D76ED75CDC4E663D066F77", hash_generated_method = "0855AB9A0F0134E4BD481391EB43B16B")
    @SuppressWarnings("unchecked")
    public synchronized E firstElement() {
        E varB4EAC82CA7396A68D541C85D26508E83_548975975 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_548975975 = (E) elementData[0];
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_548975975.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_548975975;
        // ---------- Original Method ----------
        //if (elementCount > 0) {
            //return (E) elementData[0];
        //}
        //throw new NoSuchElementException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.779 -0400", hash_original_method = "E09D80C19A651BF8C26D5375E71CA6A0", hash_generated_method = "6D9D7602654D33A1F639FF47CB316D4D")
    @Override
    public E get(int location) {
        E varB4EAC82CA7396A68D541C85D26508E83_916906717 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_916906717 = elementAt(location);
        addTaint(location);
        varB4EAC82CA7396A68D541C85D26508E83_916906717.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_916906717;
        // ---------- Original Method ----------
        //return elementAt(location);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.779 -0400", hash_original_method = "B022A84D94038C9BB0C01ED819C072BD", hash_generated_method = "64010BA86B8C23F5876C3F998703F841")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.780 -0400", hash_original_method = "183736DEF5A7AE33048C32065B21DF67", hash_generated_method = "76C7FF8F44788509C25EE819CAEA61F6")
    private void growByOne() {
        int adding;
        adding = 0;
        {
            {
                boolean var28F6DF2B41A53CDE1C60C1BFD65ACDED_544172479 = ((adding = elementData.length) == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.800 -0400", hash_original_method = "1763D1FD6D85CB337349BE3D39A45770", hash_generated_method = "64585961BE78D51B39475D74894EC2DC")
    private void growBy(int required) {
        int adding;
        adding = 0;
        {
            {
                boolean var28F6DF2B41A53CDE1C60C1BFD65ACDED_1956757588 = ((adding = elementData.length) == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.801 -0400", hash_original_method = "20A64E7812064C08C37EDD86F8A561DF", hash_generated_method = "4E11AF6FDE6D2DEA767715029A78BD1E")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1194031720 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1194031720;
        // ---------- Original Method ----------
        //int result = 1;
        //for (int i = 0; i < elementCount; i++) {
            //result = (31 * result)
                    //+ (elementData[i] == null ? 0 : elementData[i].hashCode());
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.801 -0400", hash_original_method = "BA52EF79315F2CDCEE831A2AC6873E19", hash_generated_method = "130681DBB9A5F9550674022B4C8D2B9C")
    @Override
    public int indexOf(Object object) {
        int varE73F9E0C1A3B81CDEF050C43218DC8D9_1072351420 = (indexOf(object, 0));
        addTaint(object.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1801096412 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1801096412;
        // ---------- Original Method ----------
        //return indexOf(object, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.815 -0400", hash_original_method = "24750353DFD7303BB9261ABCF2B08CBF", hash_generated_method = "31A0A6456B7D07A63947A8EB14D8EE27")
    public synchronized int indexOf(Object object, int location) {
        {
            {
                int i;
                i = location;
                {
                    {
                        boolean var6058C077AE20E477BC66A81239047631_558756147 = (object.equals(elementData[i]));
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1414831569 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1414831569;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.819 -0400", hash_original_method = "288EF4E8EFAE610E93F8F6663B1B7C8C", hash_generated_method = "7976CB8E209B87918ADBD7DF261C96DB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.819 -0400", hash_original_method = "0D33E0C5C56D3A9FC9F5E73253A3A2D0", hash_generated_method = "023A1E501E7327A0F29C067D345B0263")
    @Override
    public synchronized boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_168107877 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_168107877;
        // ---------- Original Method ----------
        //return elementCount == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.825 -0400", hash_original_method = "BB5B48C89086DB15EEAE482333CC1417", hash_generated_method = "A128575229660BC2C07B5A5742F86533")
    @SuppressWarnings("unchecked")
    public synchronized E lastElement() {
        E varB4EAC82CA7396A68D541C85D26508E83_1635283049 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1635283049 = (E) elementData[elementCount - 1];
        } //End block
        catch (IndexOutOfBoundsException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1635283049.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1635283049;
        // ---------- Original Method ----------
        //try {
            //return (E) elementData[elementCount - 1];
        //} catch (IndexOutOfBoundsException e) {
            //throw new NoSuchElementException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.825 -0400", hash_original_method = "A9A619C02ADFE7E6CEBC127D6A8D9A71", hash_generated_method = "B09042EA0DAC2F9004F0C756197A4DE1")
    @Override
    public synchronized int lastIndexOf(Object object) {
        int var511076739D83F05D2B69CDA20C63B8A3_817492091 = (lastIndexOf(object, elementCount - 1));
        addTaint(object.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1890409757 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1890409757;
        // ---------- Original Method ----------
        //return lastIndexOf(object, elementCount - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.829 -0400", hash_original_method = "DAE93837888D415686D1D0DD0C8E6815", hash_generated_method = "CF7BC1E9DCE10D86BCCAA547009418E9")
    public synchronized int lastIndexOf(Object object, int location) {
        {
            {
                {
                    int i;
                    i = location;
                    {
                        {
                            boolean var3A356DDF00F01E8F368FF4B2197B5E1F_631922782 = (object.equals(elementData[i]));
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_32994678 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_32994678;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.841 -0400", hash_original_method = "E42458246EBBDA79B230DDF671CA6424", hash_generated_method = "B350D98976F4E618238FE143B83CC72D")
    @SuppressWarnings("unchecked")
    @Override
    public synchronized E remove(int location) {
        E varB4EAC82CA7396A68D541C85D26508E83_1039740157 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_1039740157 = result;
        } //End block
        if (DroidSafeAndroidRuntime.control) throw arrayIndexOutOfBoundsException(location, elementCount);
        addTaint(location);
        varB4EAC82CA7396A68D541C85D26508E83_1039740157.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1039740157;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.841 -0400", hash_original_method = "823A94C57B65BF07C08540507330C163", hash_generated_method = "1D1E410A6C7DB0EDB1762E38FC9E7147")
    @Override
    public boolean remove(Object object) {
        boolean var2DF3D1B602150B1D95CE5F3A3FDBC88F_814556390 = (removeElement(object));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_726544482 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_726544482;
        // ---------- Original Method ----------
        //return removeElement(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.856 -0400", hash_original_method = "8C6CFD9299AE63E6D8F991F5FD437E67", hash_generated_method = "648801BFFD838C6F2C47D577A45B6CB3")
    @Override
    public synchronized boolean removeAll(Collection<?> collection) {
        boolean var683870BA88109C83545AC694C96B458A_641411808 = (super.removeAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1518577932 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1518577932;
        // ---------- Original Method ----------
        //return super.removeAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.859 -0400", hash_original_method = "B99CB02C0986A5ACE1171E44B2E88FC0", hash_generated_method = "C7C25FD730655FC2413FA1DEF25647CC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.860 -0400", hash_original_method = "A6C501B9D7921F5FC1AF3EFCF61D0AD0", hash_generated_method = "0763E03CFC9E52547F8AD00E84DA2D16")
    public synchronized boolean removeElement(Object object) {
        int index;
        {
            boolean var00053FECC15E7E9615B66BDB6BEEF16F_666933690 = ((index = indexOf(object, 0)) == -1);
        } //End collapsed parenthetic
        removeElementAt(index);
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1796366724 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1796366724;
        // ---------- Original Method ----------
        //int index;
        //if ((index = indexOf(object, 0)) == -1) {
            //return false;
        //}
        //removeElementAt(index);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.861 -0400", hash_original_method = "81AD5D3720D67EB52B93171772D8B025", hash_generated_method = "BEA29F4841AEE3122FFF19A3C5A9D756")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.865 -0400", hash_original_method = "6B459A814E902B0310B875E965EBDC88", hash_generated_method = "5F543292EC3AF66BE0C13914868580CB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.883 -0400", hash_original_method = "3D3F7D0269EE9A4A0E6B970CD7AB0599", hash_generated_method = "7A7E857F2AC2CDDE23F9053BD57AA69F")
    @Override
    public synchronized boolean retainAll(Collection<?> collection) {
        boolean var2CAA4A68044DBB7B5CB3E7FF23679230_1037277547 = (super.retainAll(collection));
        addTaint(collection.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_297797954 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_297797954;
        // ---------- Original Method ----------
        //return super.retainAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.884 -0400", hash_original_method = "5EA1E920588C93D742AF1B9C3DFE2811", hash_generated_method = "75CC8F040A65A485059D9598390BF019")
    @SuppressWarnings("unchecked")
    @Override
    public synchronized E set(int location, E object) {
        E varB4EAC82CA7396A68D541C85D26508E83_1866446861 = null; //Variable for return #1
        {
            E result;
            result = (E) elementData[location];
            elementData[location] = object;
            varB4EAC82CA7396A68D541C85D26508E83_1866446861 = result;
        } //End block
        if (DroidSafeAndroidRuntime.control) throw arrayIndexOutOfBoundsException(location, elementCount);
        varB4EAC82CA7396A68D541C85D26508E83_1866446861.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1866446861;
        // ---------- Original Method ----------
        //if (location < elementCount) {
            //E result = (E) elementData[location];
            //elementData[location] = object;
            //return result;
        //}
        //throw arrayIndexOutOfBoundsException(location, elementCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.885 -0400", hash_original_method = "BE9BD0132B3B62E633B4EDB307CB7290", hash_generated_method = "030B361439082E69E82E2D7C9F0593A1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.891 -0400", hash_original_method = "7F3B955AC73FEA732765CAFEDD4BC76C", hash_generated_method = "5792814B6D0CC16CE4918C0316A03F68")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.903 -0400", hash_original_method = "81BBFD456B62650530A643B4CB14DC43", hash_generated_method = "098DB0B1E6B975204278368E9AE7EF0A")
    @Override
    public synchronized int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_579731014 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_579731014;
        // ---------- Original Method ----------
        //return elementCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.911 -0400", hash_original_method = "12E21B76E32A1D6BB3AE5A157C1F7673", hash_generated_method = "8ABDDD8FFBD4D4ECE59E1C1B58FB0AB9")
    @Override
    public synchronized List<E> subList(int start, int end) {
        List<E> varB4EAC82CA7396A68D541C85D26508E83_969625908 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_969625908 = new Collections.SynchronizedRandomAccessList<E>(super.subList(
                start, end), this);
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_969625908.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_969625908;
        // ---------- Original Method ----------
        //return new Collections.SynchronizedRandomAccessList<E>(super.subList(
                //start, end), this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.912 -0400", hash_original_method = "6F1E76A2D55423060704E3AA65069BB2", hash_generated_method = "8A77CEC6A4DE14BF3BDB9982DC7AC8F2")
    @Override
    public synchronized Object[] toArray() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_1545876312 = null; //Variable for return #1
        Object[] result;
        result = new Object[elementCount];
        System.arraycopy(elementData, 0, result, 0, elementCount);
        varB4EAC82CA7396A68D541C85D26508E83_1545876312 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1545876312.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1545876312;
        // ---------- Original Method ----------
        //Object[] result = new Object[elementCount];
        //System.arraycopy(elementData, 0, result, 0, elementCount);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.914 -0400", hash_original_method = "70C5BC6785EB6C524C2B60C494DFFFBE", hash_generated_method = "73060AF391A0F06979188FB32ED88213")
    @Override
    @SuppressWarnings("unchecked")
    public synchronized <T> T[] toArray(T[] contents) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_1849475474 = null; //Variable for return #1
        {
            Class<?> ct;
            ct = contents.getClass().getComponentType();
            contents = (T[]) Array.newInstance(ct, elementCount);
        } //End block
        System.arraycopy(elementData, 0, contents, 0, elementCount);
        {
            contents[elementCount] = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1849475474 = contents;
        varB4EAC82CA7396A68D541C85D26508E83_1849475474.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1849475474;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.928 -0400", hash_original_method = "0DD9DB5F445E75E250BA34836212BB86", hash_generated_method = "985E1DB7D737DEB7F237E4F16B77E5CB")
    @Override
    public synchronized String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_141574420 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_404520877 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_141574420 = "[]";
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
                    boolean var1EAEC00226A70062D4821DCC23A131E8_71760741 = (elementData[i] == this);
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
            boolean var133E8E0A94865404CC8E7824CF7E87B9_1854175686 = (elementData[length] == this);
            {
                buffer.append("(this Collection)");
            } //End block
            {
                buffer.append(elementData[length]);
            } //End block
        } //End collapsed parenthetic
        buffer.append(']');
        varB4EAC82CA7396A68D541C85D26508E83_404520877 = buffer.toString();
        String varA7E53CE21691AB073D9660D615818899_643270012; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_643270012 = varB4EAC82CA7396A68D541C85D26508E83_141574420;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_643270012 = varB4EAC82CA7396A68D541C85D26508E83_404520877;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_643270012.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_643270012;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.929 -0400", hash_original_method = "FC23934C3FC3508F47E3F895F030378B", hash_generated_method = "67BB08EED6E7441D6B67A75C72DF5B64")
    public synchronized void trimToSize() {
        {
            grow(elementCount);
        } //End block
        // ---------- Original Method ----------
        //if (elementData.length != elementCount) {
            //grow(elementCount);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.930 -0400", hash_original_method = "93271132EFBEDC29196C798673AC5EE7", hash_generated_method = "00A9C4D3DE0B50771808F817E4C6F9F8")
    private synchronized void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        //stream.defaultWriteObject();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.930 -0400", hash_original_field = "63388E0D41356F5B13E53DDDE229677C", hash_generated_field = "221DC1B405F92F6FA4C6FD7306DFBBE1")

    private static long serialVersionUID = -2767605614048989439L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:54.930 -0400", hash_original_field = "F94234FC21E5DB8AB303ACA6C6E18129", hash_generated_field = "4911CD497D3EBB1CE18CD40D6F15774C")

    private static int DEFAULT_SIZE = 10;
}

