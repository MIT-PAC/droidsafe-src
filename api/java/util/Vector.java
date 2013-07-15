package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;

public class Vector<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.928 -0400", hash_original_field = "BC8C6DCF12CE09E50A98BB57ADFCADD9", hash_generated_field = "499A2D73243CED99A42E214D64505A6C")

    protected int elementCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.929 -0400", hash_original_field = "8D395F1876FF8AE01BE52A9C4C2ED552", hash_generated_field = "0B3F426A5758654DA42168DCEAA2747C")

    protected Object[] elementData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.929 -0400", hash_original_field = "7D8D485EB9C5EE294297FC18663D46D8", hash_generated_field = "C57732C85DED3048B8128B9506ED7293")

    protected int capacityIncrement;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.929 -0400", hash_original_method = "DACE16FEA3F29475D20FB4F2AE2C4BF3", hash_generated_method = "F92FDEEA28BC7E4B901A0A343D42232D")
    public  Vector() {
        this(DEFAULT_SIZE, 0);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.929 -0400", hash_original_method = "516F631FEB27C4B8AC76BAFF727DB150", hash_generated_method = "F3CDA2715564D8E8516468F487D83DFA")
    public  Vector(int capacity) {
        this(capacity, 0);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.929 -0400", hash_original_method = "B35B3D540AE265DD802702BED4157C47", hash_generated_method = "1BD13D60C0795FC81A939E9F1E8E8974")
    public  Vector(int capacity, int capacityIncrement) {
    if(capacity < 0)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_650036404 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_650036404.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_650036404;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.929 -0400", hash_original_method = "5554DADF2588E03BDCF1E2168D3E3C3F", hash_generated_method = "AB91ED40A9838270A2ED5EA6CEA47583")
    public  Vector(Collection<? extends E> collection) {
        this(collection.size(), 0);
        addTaint(collection.getTaint());
        Iterator<? extends E> it = collection.iterator();
        while
(it.hasNext())        
        {
            elementData[elementCount++] = it.next();
        } //End block
        // ---------- Original Method ----------
        //Iterator<? extends E> it = collection.iterator();
        //while (it.hasNext()) {
            //elementData[elementCount++] = it.next();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.930 -0400", hash_original_method = "088E691065B085AAA9856C71AD537C28", hash_generated_method = "E8C73FEF0F51A279D70C6CBB74345EF0")
    @SuppressWarnings("unchecked")
    private E[] newElementArray(int size) {
        addTaint(size);
E[] var1B2FE2B69B45A4B74BDC1E1658079136_1984782008 =         (E[]) new Object[size];
        var1B2FE2B69B45A4B74BDC1E1658079136_1984782008.addTaint(taint);
        return var1B2FE2B69B45A4B74BDC1E1658079136_1984782008;
        // ---------- Original Method ----------
        //return (E[]) new Object[size];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.930 -0400", hash_original_method = "48191DBEFAEF26CE3AD2676469C6C588", hash_generated_method = "21D6949D568C503AE4CDB992DFC1EAB1")
    @Override
    public void add(int location, E object) {
        addTaint(object.getTaint());
        addTaint(location);
        insertElementAt(object, location);
        // ---------- Original Method ----------
        //insertElementAt(object, location);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.930 -0400", hash_original_method = "4A1B135502A4FBF53B5971ADD0895265", hash_generated_method = "85D55B98C15BBA7A6A0C26543873A2C9")
    @Override
    public synchronized boolean add(E object) {
    if(elementCount == elementData.length)        
        {
            growByOne();
        } //End block
        elementData[elementCount++] = object;
        modCount++;
        boolean varB326B5062B2F0E69046810717534CB09_1628271270 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1435299996 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1435299996;
        // ---------- Original Method ----------
        //if (elementCount == elementData.length) {
            //growByOne();
        //}
        //elementData[elementCount++] = object;
        //modCount++;
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.937 -0400", hash_original_method = "721C95E0B3ACA6F09AE8F219EA79313F", hash_generated_method = "FBD6B2B21AE81BA1EE1C508EA18E9CB1")
    @Override
    public synchronized boolean addAll(int location, Collection<? extends E> collection) {
        addTaint(collection.getTaint());
    if(location >= 0 && location <= elementCount)        
        {
            int size = collection.size();
    if(size == 0)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1757937228 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1578882861 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1578882861;
            } //End block
            int required = size - (elementData.length - elementCount);
    if(required > 0)            
            {
                growBy(required);
            } //End block
            int count = elementCount - location;
    if(count > 0)            
            {
                System.arraycopy(elementData, location, elementData, location
                        + size, count);
            } //End block
            Iterator<? extends E> it = collection.iterator();
            while
(it.hasNext())            
            {
                elementData[location++] = it.next();
            } //End block
            elementCount += size;
            modCount++;
            boolean varB326B5062B2F0E69046810717534CB09_168392544 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_592656890 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_592656890;
        } //End block
        java.lang.ArrayIndexOutOfBoundsException varC4E99290A8E221CD17D3A059991A865D_1899276491 = arrayIndexOutOfBoundsException(location, elementCount);
        varC4E99290A8E221CD17D3A059991A865D_1899276491.addTaint(taint);
        throw varC4E99290A8E221CD17D3A059991A865D_1899276491;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.937 -0400", hash_original_method = "936868945967E6EE9BEE2301A3FC2D7D", hash_generated_method = "B1B91DBBBE8C2BE91080D1713E067663")
    @Override
    public synchronized boolean addAll(Collection<? extends E> collection) {
        addTaint(collection.getTaint());
        boolean var0FEBF37003C2F5CB55B75F0E5C98FB17_516107794 = (addAll(elementCount, collection));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_882911162 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_882911162;
        // ---------- Original Method ----------
        //return addAll(elementCount, collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.938 -0400", hash_original_method = "A5163E0F34F09A3D8DEA4C412903D1D1", hash_generated_method = "A227B57D2FB30D770C2C72C2E445FBFD")
    public synchronized void addElement(E object) {
    if(elementCount == elementData.length)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.938 -0400", hash_original_method = "DD1AE1F8EA98D3605FDD193E0651B9D6", hash_generated_method = "7962580513937AD8B24559826B5F2CD0")
    public synchronized int capacity() {
        int var07C376840AFF9C17A8118A6D2922D513_1685398618 = (elementData.length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2142275131 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2142275131;
        // ---------- Original Method ----------
        //return elementData.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.939 -0400", hash_original_method = "1F4E1B041EF06199B18000DD20E283A1", hash_generated_method = "CB8944604C59D0C0C157C3038F849082")
    @Override
    public void clear() {
        removeAllElements();
        // ---------- Original Method ----------
        //removeAllElements();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.939 -0400", hash_original_method = "1610A6C93F0D6F1C66DC0DFCBD33D1B2", hash_generated_method = "558ABFC1BB7C81E42C6A6DC1BCE859F5")
    @Override
    @SuppressWarnings("unchecked")
    public synchronized Object clone() {
        try 
        {
            Vector<E> vector = (Vector<E>) super.clone();
            vector.elementData = elementData.clone();
Object varAFE05DA6BCC31D768176AC4CA91A2154_553051461 =             vector;
            varAFE05DA6BCC31D768176AC4CA91A2154_553051461.addTaint(taint);
            return varAFE05DA6BCC31D768176AC4CA91A2154_553051461;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_1914778399 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_1914778399.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_1914778399;
        } //End block
        // ---------- Original Method ----------
        //try {
            //Vector<E> vector = (Vector<E>) super.clone();
            //vector.elementData = elementData.clone();
            //return vector;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.940 -0400", hash_original_method = "4017403066D0A85EBF82EC88CFE4ED84", hash_generated_method = "3356241273EF6FED7A7A69200082C077")
    @Override
    public boolean contains(Object object) {
        addTaint(object.getTaint());
        boolean var2B4521032507EC37772354BF4D8E8ED8_1868056541 = (indexOf(object, 0) != -1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1205503436 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1205503436;
        // ---------- Original Method ----------
        //return indexOf(object, 0) != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.940 -0400", hash_original_method = "51334898ABB14C1CD821FC4FE1B2383C", hash_generated_method = "02B90B2229B894C0966894546BD2A79B")
    @Override
    public synchronized boolean containsAll(Collection<?> collection) {
        addTaint(collection.getTaint());
        boolean var7D226F5CF447636EBAEB56D51C084B69_1682431056 = (super.containsAll(collection));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1064108843 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1064108843;
        // ---------- Original Method ----------
        //return super.containsAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.940 -0400", hash_original_method = "9FCD2BB7391A67913F5DC5B0A38C9668", hash_generated_method = "ABCEE675B5AABD0DFD2EE89ECE981656")
    public synchronized void copyInto(Object[] elements) {
        addTaint(elements[0].getTaint());
        System.arraycopy(elementData, 0, elements, 0, elementCount);
        // ---------- Original Method ----------
        //System.arraycopy(elementData, 0, elements, 0, elementCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.947 -0400", hash_original_method = "3CA02A8FB0EDF4F6C1F1F261516DC679", hash_generated_method = "332C428346B2A785B67C0F0C561271B3")
    @SuppressWarnings("unchecked")
    public synchronized E elementAt(int location) {
        addTaint(location);
    if(location < elementCount)        
        {
E var68EF0BD40932FF2807234701D0B595C2_393938178 =             (E) elementData[location];
            var68EF0BD40932FF2807234701D0B595C2_393938178.addTaint(taint);
            return var68EF0BD40932FF2807234701D0B595C2_393938178;
        } //End block
        ArrayIndexOutOfBoundsException varC4E99290A8E221CD17D3A059991A865D_386874881 = arrayIndexOutOfBoundsException(location, elementCount);
        varC4E99290A8E221CD17D3A059991A865D_386874881.addTaint(taint);
        throw varC4E99290A8E221CD17D3A059991A865D_386874881;
        // ---------- Original Method ----------
        //if (location < elementCount) {
            //return (E) elementData[location];
        //}
        //throw arrayIndexOutOfBoundsException(location, elementCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.949 -0400", hash_original_method = "B6E84DE201AAEF8307F5E7CA8A6AEF90", hash_generated_method = "B87E45276B4FDA423F7913289211B4B0")
    public Enumeration<E> elements() {
Enumeration<E> varBE1AF8000F96BB9037958F34C83E40EA_1562135734 =         new Enumeration<E>() {        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.948 -0400", hash_original_field = "30905E6E8D02502121446F7E78ED3C72", hash_generated_field = "BEC7A604E336F37C0CC9A9336799291F")
        int pos = 0;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.948 -0400", hash_original_method = "BE1470CA1AE3A8E761558BC585309C9C", hash_generated_method = "58C28E87A0A4563EE13B7EC3ED29111A")
        public boolean hasMoreElements() {
            boolean varE2C04D119C3740B4B44C2924A8601E86_1197439440 = (pos < elementCount);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2064759191 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2064759191;
            // ---------- Original Method ----------
            //return pos < elementCount;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.949 -0400", hash_original_method = "587FDB7AD89D6517798ABA6D2628416A", hash_generated_method = "C3ACB5A0237F544803D75AFAEC72E560")
        @SuppressWarnings("unchecked")
        public E nextElement() {
            synchronized
(Vector.this)            {
    if(pos < elementCount)                
                {
E varC0FA0F1B092A92789BDD5894D3168FF7_1828805928 =                     (E) elementData[pos++];
                    varC0FA0F1B092A92789BDD5894D3168FF7_1828805928.addTaint(taint);
                    return varC0FA0F1B092A92789BDD5894D3168FF7_1828805928;
                } //End block
            } //End block
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_627853523 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_627853523.addTaint(taint);
            throw var28D00AB599969908D71F102AF992D49A_627853523;
            // ---------- Original Method ----------
            //synchronized (Vector.this) {
                    //if (pos < elementCount) {
                        //return (E) elementData[pos++];
                    //}
                //}
            //throw new NoSuchElementException();
        }
};
        varBE1AF8000F96BB9037958F34C83E40EA_1562135734.addTaint(taint);
        return varBE1AF8000F96BB9037958F34C83E40EA_1562135734;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.949 -0400", hash_original_method = "DF06508A0F0ED83B84FE34EF6D5FCD26", hash_generated_method = "742A353D3915ECCD250517FD19695D0A")
    public synchronized void ensureCapacity(int minimumCapacity) {
        addTaint(minimumCapacity);
    if(elementData.length < minimumCapacity)        
        {
            int next = (capacityIncrement <= 0 ? elementData.length
                    : capacityIncrement)
                    + elementData.length;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.950 -0400", hash_original_method = "18CA94477F381022C117A5BE2C4C7154", hash_generated_method = "456F55D040BBB15A8FCC542670D86753")
    @Override
    public synchronized boolean equals(Object object) {
        addTaint(object.getTaint());
    if(this == object)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_314531856 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1153023602 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1153023602;
        } //End block
    if(object instanceof List)        
        {
            List<?> list = (List<?>) object;
    if(list.size() != elementCount)            
            {
                boolean var68934A3E9455FA72420237EB05902327_2088044854 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1467971535 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1467971535;
            } //End block
            int index = 0;
            Iterator<?> it = list.iterator();
            while
(it.hasNext())            
            {
                Object e1 = elementData[index++];
                Object e2 = it.next();
    if(!(e1 == null ? e2 == null : e1.equals(e2)))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_2117467916 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_969605670 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_969605670;
                } //End block
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_828178812 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_999756336 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_999756336;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_883591502 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1951462477 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1951462477;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.951 -0400", hash_original_method = "D89343B924D76ED75CDC4E663D066F77", hash_generated_method = "187FE8E988BC74559CACBEF3A1D6DAD4")
    @SuppressWarnings("unchecked")
    public synchronized E firstElement() {
    if(elementCount > 0)        
        {
E var13CFD9961928450F08557A948826D5C4_88263985 =             (E) elementData[0];
            var13CFD9961928450F08557A948826D5C4_88263985.addTaint(taint);
            return var13CFD9961928450F08557A948826D5C4_88263985;
        } //End block
        NoSuchElementException var28D00AB599969908D71F102AF992D49A_2062963217 = new NoSuchElementException();
        var28D00AB599969908D71F102AF992D49A_2062963217.addTaint(taint);
        throw var28D00AB599969908D71F102AF992D49A_2062963217;
        // ---------- Original Method ----------
        //if (elementCount > 0) {
            //return (E) elementData[0];
        //}
        //throw new NoSuchElementException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.951 -0400", hash_original_method = "E09D80C19A651BF8C26D5375E71CA6A0", hash_generated_method = "1754FBFD68EE3D90785929CAF451E6DC")
    @Override
    public E get(int location) {
        addTaint(location);
E var1488522CA63FA559F06B9E300ACDBE8D_1086923829 =         elementAt(location);
        var1488522CA63FA559F06B9E300ACDBE8D_1086923829.addTaint(taint);
        return var1488522CA63FA559F06B9E300ACDBE8D_1086923829;
        // ---------- Original Method ----------
        //return elementAt(location);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.952 -0400", hash_original_method = "B022A84D94038C9BB0C01ED819C072BD", hash_generated_method = "98CD7C8BB70A99FB1026BA9FE2AED777")
    private void grow(int newCapacity) {
        addTaint(newCapacity);
        E[] newData = newElementArray(newCapacity);
        System.arraycopy(elementData, 0, newData, 0, elementCount);
        elementData = newData;
        // ---------- Original Method ----------
        //E[] newData = newElementArray(newCapacity);
        //assert elementCount <= newCapacity;
        //System.arraycopy(elementData, 0, newData, 0, elementCount);
        //elementData = newData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.952 -0400", hash_original_method = "183736DEF5A7AE33048C32065B21DF67", hash_generated_method = "79E3116E494A0C4F1C4B2091C2181850")
    private void growByOne() {
        int adding = 0;
    if(capacityIncrement <= 0)        
        {
    if((adding = elementData.length) == 0)            
            {
                adding = 1;
            } //End block
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.953 -0400", hash_original_method = "1763D1FD6D85CB337349BE3D39A45770", hash_generated_method = "44C8DD9A6652B3DEE402B9A6406F2A03")
    private void growBy(int required) {
        addTaint(required);
        int adding = 0;
    if(capacityIncrement <= 0)        
        {
    if((adding = elementData.length) == 0)            
            {
                adding = required;
            } //End block
            while
(adding < required)            
            {
                adding += adding;
            } //End block
        } //End block
        else
        {
            adding = (required / capacityIncrement) * capacityIncrement;
    if(adding < required)            
            {
                adding += capacityIncrement;
            } //End block
        } //End block
        E[] newData = newElementArray(elementData.length + adding);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.954 -0400", hash_original_method = "20A64E7812064C08C37EDD86F8A561DF", hash_generated_method = "B4D47522534C8C309EB54539CC5FE6D2")
    @Override
    public synchronized int hashCode() {
        int result = 1;
for(int i = 0;i < elementCount;i++)
        {
            result = (31 * result)
                    + (elementData[i] == null ? 0 : elementData[i].hashCode());
        } //End block
        int varB4A88417B3D0170D754C647C30B7216A_1885313474 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_207342112 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_207342112;
        // ---------- Original Method ----------
        //int result = 1;
        //for (int i = 0; i < elementCount; i++) {
            //result = (31 * result)
                    //+ (elementData[i] == null ? 0 : elementData[i].hashCode());
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.955 -0400", hash_original_method = "BA52EF79315F2CDCEE831A2AC6873E19", hash_generated_method = "30BB7C9B7F0CCBADA9A49C32D79F5427")
    @Override
    public int indexOf(Object object) {
        addTaint(object.getTaint());
        int var2BE7006E4C22B56F0FFEDA28C6FCFD50_1406524015 = (indexOf(object, 0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_995238141 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_995238141;
        // ---------- Original Method ----------
        //return indexOf(object, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.955 -0400", hash_original_method = "24750353DFD7303BB9261ABCF2B08CBF", hash_generated_method = "DE6B8ACAA6C8647DB7D2932224F1E189")
    public synchronized int indexOf(Object object, int location) {
        addTaint(location);
        addTaint(object.getTaint());
    if(object != null)        
        {
for(int i = location;i < elementCount;i++)
            {
    if(object.equals(elementData[i]))                
                {
                    int var865C0C0B4AB0E063E5CAA3387C1A8741_1726911493 = (i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_119019062 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_119019062;
                } //End block
            } //End block
        } //End block
        else
        {
for(int i = location;i < elementCount;i++)
            {
    if(elementData[i] == null)                
                {
                    int var865C0C0B4AB0E063E5CAA3387C1A8741_248641622 = (i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_731816483 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_731816483;
                } //End block
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1641500155 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1861886226 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1861886226;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.962 -0400", hash_original_method = "288EF4E8EFAE610E93F8F6663B1B7C8C", hash_generated_method = "C0A66FD1831034185EC522D491C92763")
    public synchronized void insertElementAt(E object, int location) {
    if(location >= 0 && location <= elementCount)        
        {
    if(elementCount == elementData.length)            
            {
                growByOne();
            } //End block
            int count = elementCount - location;
    if(count > 0)            
            {
                System.arraycopy(elementData, location, elementData,
                        location + 1, count);
            } //End block
            elementData[location] = object;
            elementCount++;
            modCount++;
        } //End block
        else
        {
        	ArrayIndexOutOfBoundsException varC4E99290A8E221CD17D3A059991A865D_679423149 = arrayIndexOutOfBoundsException(location, elementCount);
            varC4E99290A8E221CD17D3A059991A865D_679423149.addTaint(taint);
            throw varC4E99290A8E221CD17D3A059991A865D_679423149;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.962 -0400", hash_original_method = "0D33E0C5C56D3A9FC9F5E73253A3A2D0", hash_generated_method = "81540180BD9D3606A3AE3EABD826600E")
    @Override
    public synchronized boolean isEmpty() {
        boolean var994633B9330EF4CC2EF62FBA7868E730_2043735616 = (elementCount == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_853192070 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_853192070;
        // ---------- Original Method ----------
        //return elementCount == 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.963 -0400", hash_original_method = "BB5B48C89086DB15EEAE482333CC1417", hash_generated_method = "2EBB8D2E662377E2A3470E8B795F9259")
    @SuppressWarnings("unchecked")
    public synchronized E lastElement() {
        try 
        {
E var844EE4F2CEF6A403C269534F85F70712_284926325 =             (E) elementData[elementCount - 1];
            var844EE4F2CEF6A403C269534F85F70712_284926325.addTaint(taint);
            return var844EE4F2CEF6A403C269534F85F70712_284926325;
        } //End block
        catch (IndexOutOfBoundsException e)
        {
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_815194438 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_815194438.addTaint(taint);
            throw var28D00AB599969908D71F102AF992D49A_815194438;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return (E) elementData[elementCount - 1];
        //} catch (IndexOutOfBoundsException e) {
            //throw new NoSuchElementException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.963 -0400", hash_original_method = "A9A619C02ADFE7E6CEBC127D6A8D9A71", hash_generated_method = "64FBC4969F76E6B12E825BD23A204613")
    @Override
    public synchronized int lastIndexOf(Object object) {
        addTaint(object.getTaint());
        int var91DE122ABF61FCD89ABEA9888C49C0A6_227981455 = (lastIndexOf(object, elementCount - 1));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_558911559 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_558911559;
        // ---------- Original Method ----------
        //return lastIndexOf(object, elementCount - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.971 -0400", hash_original_method = "DAE93837888D415686D1D0DD0C8E6815", hash_generated_method = "C1CA187804CBC0B7FC7363EE971CB6D0")
    public synchronized int lastIndexOf(Object object, int location) {
        addTaint(location);
        addTaint(object.getTaint());
    if(location < elementCount)        
        {
    if(object != null)            
            {
for(int i = location;i >= 0;i--)
                {
    if(object.equals(elementData[i]))                    
                    {
                        int var865C0C0B4AB0E063E5CAA3387C1A8741_156684374 = (i);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1638194938 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1638194938;
                    } //End block
                } //End block
            } //End block
            else
            {
for(int i = location;i >= 0;i--)
                {
    if(elementData[i] == null)                    
                    {
                        int var865C0C0B4AB0E063E5CAA3387C1A8741_602594769 = (i);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1460266276 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1460266276;
                    } //End block
                } //End block
            } //End block
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1648340500 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1881087292 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1881087292;
        } //End block
        java.lang.ArrayIndexOutOfBoundsException varC4E99290A8E221CD17D3A059991A865D_416710288 = arrayIndexOutOfBoundsException(location, elementCount);
        varC4E99290A8E221CD17D3A059991A865D_416710288.addTaint(taint);
        throw varC4E99290A8E221CD17D3A059991A865D_416710288;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.979 -0400", hash_original_method = "E42458246EBBDA79B230DDF671CA6424", hash_generated_method = "0487B705857BB955EA413BDDCA0B48CF")
    @SuppressWarnings("unchecked")
    @Override
    public synchronized E remove(int location) {
        addTaint(location);
    if(location < elementCount)        
        {
            E result = (E) elementData[location];
            elementCount--;
            int size = elementCount - location;
    if(size > 0)            
            {
                System.arraycopy(elementData, location + 1, elementData,
                        location, size);
            } //End block
            elementData[elementCount] = null;
            modCount++;
E varDC838461EE2FA0CA4C9BBB70A15456B0_416867409 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_416867409.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_416867409;
        } //End block
    ArrayIndexOutOfBoundsException varC4E99290A8E221CD17D3A059991A865D_576774538 = arrayIndexOutOfBoundsException(location, elementCount);
        varC4E99290A8E221CD17D3A059991A865D_576774538.addTaint(taint);
        throw varC4E99290A8E221CD17D3A059991A865D_576774538;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.979 -0400", hash_original_method = "823A94C57B65BF07C08540507330C163", hash_generated_method = "9C8974C16ED1449F66B645263F1E2676")
    @Override
    public boolean remove(Object object) {
        addTaint(object.getTaint());
        boolean varF4EF6A684640D8A7FEA1988BB06F1E78_21953756 = (removeElement(object));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_313584537 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_313584537;
        // ---------- Original Method ----------
        //return removeElement(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.980 -0400", hash_original_method = "8C6CFD9299AE63E6D8F991F5FD437E67", hash_generated_method = "10A6A17A5597CF4A71CE00325738EEE5")
    @Override
    public synchronized boolean removeAll(Collection<?> collection) {
        addTaint(collection.getTaint());
        boolean varC59E950B034B0097B868C2C96544231D_461394745 = (super.removeAll(collection));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_494666006 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_494666006;
        // ---------- Original Method ----------
        //return super.removeAll(collection);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.981 -0400", hash_original_method = "B99CB02C0986A5ACE1171E44B2E88FC0", hash_generated_method = "B1AF8F7A62BE803D9C4214E5FFF1A75D")
    public synchronized void removeAllElements() {
for(int i = 0;i < elementCount;i++)
        {
            elementData[i] = null;
        } //End block
        modCount++;
        elementCount = 0;
        // ---------- Original Method ----------
        //for (int i = 0; i < elementCount; i++) {
            //elementData[i] = null;
        //}
        //modCount++;
        //elementCount = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.981 -0400", hash_original_method = "A6C501B9D7921F5FC1AF3EFCF61D0AD0", hash_generated_method = "E519E477D071209AF424E5C7405F23D3")
    public synchronized boolean removeElement(Object object) {
        addTaint(object.getTaint());
        int index;
    if((index = indexOf(object, 0)) == -1)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1338062525 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_26946720 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_26946720;
        } //End block
        removeElementAt(index);
        boolean varB326B5062B2F0E69046810717534CB09_333711505 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_92332797 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_92332797;
        // ---------- Original Method ----------
        //int index;
        //if ((index = indexOf(object, 0)) == -1) {
            //return false;
        //}
        //removeElementAt(index);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.988 -0400", hash_original_method = "81AD5D3720D67EB52B93171772D8B025", hash_generated_method = "8AD366AA155BD743AB1CCFABD576528A")
    public synchronized void removeElementAt(int location) {
        addTaint(location);
    if(location >= 0 && location < elementCount)        
        {
            elementCount--;
            int size = elementCount - location;
    if(size > 0)            
            {
                System.arraycopy(elementData, location + 1, elementData,
                        location, size);
            } //End block
            elementData[elementCount] = null;
            modCount++;
        } //End block
        else
        {
            java.lang.ArrayIndexOutOfBoundsException varC4E99290A8E221CD17D3A059991A865D_1396277707 = arrayIndexOutOfBoundsException(location, elementCount);
            varC4E99290A8E221CD17D3A059991A865D_1396277707.addTaint(taint);
            throw varC4E99290A8E221CD17D3A059991A865D_1396277707;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.989 -0400", hash_original_method = "6B459A814E902B0310B875E965EBDC88", hash_generated_method = "94F0D8D0CC77F52807A253778D5592DC")
    @Override
    protected void removeRange(int start, int end) {
        addTaint(end);
    if(start >= 0 && start <= end && end <= elementCount)        
        {
    if(start == end)            
            {
                return;
            } //End block
    if(end != elementCount)            
            {
                System.arraycopy(elementData, end, elementData, start,
                        elementCount - end);
                int newCount = elementCount - (end - start);
                Arrays.fill(elementData, newCount, elementCount, null);
                elementCount = newCount;
            } //End block
            else
            {
                Arrays.fill(elementData, start, elementCount, null);
                elementCount = start;
            } //End block
            modCount++;
        } //End block
        else
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1824020578 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1824020578.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1824020578;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.990 -0400", hash_original_method = "3D3F7D0269EE9A4A0E6B970CD7AB0599", hash_generated_method = "143095E20F20608CBD4F1050CCE3495E")
    @Override
    public synchronized boolean retainAll(Collection<?> collection) {
        addTaint(collection.getTaint());
        boolean var503FF497CC541185965B7F24CCB51DB8_90890995 = (super.retainAll(collection));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_351274303 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_351274303;
        // ---------- Original Method ----------
        //return super.retainAll(collection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:06.996 -0400", hash_original_method = "5EA1E920588C93D742AF1B9C3DFE2811", hash_generated_method = "CD1A38AC120A7FFD04756FFC50CF32B4")
    @SuppressWarnings("unchecked")
    @Override
    public synchronized E set(int location, E object) {
    if(location < elementCount)        
        {
            E result = (E) elementData[location];
            elementData[location] = object;
E varDC838461EE2FA0CA4C9BBB70A15456B0_999939029 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_999939029.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_999939029;
        } //End block
    ArrayIndexOutOfBoundsException varC4E99290A8E221CD17D3A059991A865D_1316900323 = arrayIndexOutOfBoundsException(location, elementCount);
        varC4E99290A8E221CD17D3A059991A865D_1316900323.addTaint(taint);
        throw varC4E99290A8E221CD17D3A059991A865D_1316900323;
        // ---------- Original Method ----------
        //if (location < elementCount) {
            //E result = (E) elementData[location];
            //elementData[location] = object;
            //return result;
        //}
        //throw arrayIndexOutOfBoundsException(location, elementCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.004 -0400", hash_original_method = "BE9BD0132B3B62E633B4EDB307CB7290", hash_generated_method = "EB4FEAFEFF2F9B8F2670ED49875A91C2")
    public synchronized void setElementAt(E object, int location) {
    if(location < elementCount)        
        {
            elementData[location] = object;
        } //End block
        else
        {
        	ArrayIndexOutOfBoundsException varC4E99290A8E221CD17D3A059991A865D_231735391 = arrayIndexOutOfBoundsException(location, elementCount);
            varC4E99290A8E221CD17D3A059991A865D_231735391.addTaint(taint);
            throw varC4E99290A8E221CD17D3A059991A865D_231735391;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.005 -0400", hash_original_method = "7F3B955AC73FEA732765CAFEDD4BC76C", hash_generated_method = "CCB086EE295D5FF0DEEB7C9BC28997E9")
    public synchronized void setSize(int length) {
    if(length == elementCount)        
        {
            return;
        } //End block
        ensureCapacity(length);
    if(elementCount > length)        
        {
            Arrays.fill(elementData, length, elementCount, null);
        } //End block
        elementCount = length;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.005 -0400", hash_original_method = "81BBFD456B62650530A643B4CB14DC43", hash_generated_method = "4ADCC6DAE828019329735F1708E5257B")
    @Override
    public synchronized int size() {
        int varBC8C6DCF12CE09E50A98BB57ADFCADD9_2029684486 = (elementCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_530506675 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_530506675;
        // ---------- Original Method ----------
        //return elementCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.005 -0400", hash_original_method = "12E21B76E32A1D6BB3AE5A157C1F7673", hash_generated_method = "4BD31E340E088B074FBCB8B1C5A7431D")
    @Override
    public synchronized List<E> subList(int start, int end) {
        addTaint(end);
        addTaint(start);
List<E> varEAFB8AFCC789DE374EB117D1E52E1A39_443620105 =         new Collections.SynchronizedRandomAccessList<E>(super.subList(
                start, end), this);
        varEAFB8AFCC789DE374EB117D1E52E1A39_443620105.addTaint(taint);
        return varEAFB8AFCC789DE374EB117D1E52E1A39_443620105;
        // ---------- Original Method ----------
        //return new Collections.SynchronizedRandomAccessList<E>(super.subList(
                //start, end), this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.005 -0400", hash_original_method = "6F1E76A2D55423060704E3AA65069BB2", hash_generated_method = "BA64E59C962B0894C5151785F94D8545")
    @Override
    public synchronized Object[] toArray() {
        Object[] result = new Object[elementCount];
        System.arraycopy(elementData, 0, result, 0, elementCount);
Object[] varDC838461EE2FA0CA4C9BBB70A15456B0_227105199 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_227105199.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_227105199;
        // ---------- Original Method ----------
        //Object[] result = new Object[elementCount];
        //System.arraycopy(elementData, 0, result, 0, elementCount);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.006 -0400", hash_original_method = "70C5BC6785EB6C524C2B60C494DFFFBE", hash_generated_method = "B895578376D7FA5559681628B7E7BE12")
    @Override
    @SuppressWarnings("unchecked")
    public synchronized <T> T[] toArray(T[] contents) {
    if(elementCount > contents.length)        
        {
            Class<?> ct = contents.getClass().getComponentType();
            contents = (T[]) Array.newInstance(ct, elementCount);
        } //End block
        System.arraycopy(elementData, 0, contents, 0, elementCount);
    if(elementCount < contents.length)        
        {
            contents[elementCount] = null;
        } //End block
T[] var5DC9C33EDB9F81CF1216538024B770BE_484469863 =         contents;
        var5DC9C33EDB9F81CF1216538024B770BE_484469863.addTaint(taint);
        return var5DC9C33EDB9F81CF1216538024B770BE_484469863;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.006 -0400", hash_original_method = "0DD9DB5F445E75E250BA34836212BB86", hash_generated_method = "118B14B398909B683A534BA5E8896275")
    @Override
    public synchronized String toString() {
    if(elementCount == 0)        
        {
String varAA6F5C51D397701D3E65BDD2DF6A0CE1_289535589 =             "[]";
            varAA6F5C51D397701D3E65BDD2DF6A0CE1_289535589.addTaint(taint);
            return varAA6F5C51D397701D3E65BDD2DF6A0CE1_289535589;
        } //End block
        int length = elementCount - 1;
        StringBuilder buffer = new StringBuilder(elementCount * 16);
        buffer.append('[');
for(int i = 0;i < length;i++)
        {
    if(elementData[i] == this)            
            {
                buffer.append("(this Collection)");
            } //End block
            else
            {
                buffer.append(elementData[i]);
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
String varD03843288D33B9E1D3062E25339ECF6D_797396744 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_797396744.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_797396744;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.007 -0400", hash_original_method = "FC23934C3FC3508F47E3F895F030378B", hash_generated_method = "AB706EF10710F9F57A98E4CD283E9A4E")
    public synchronized void trimToSize() {
    if(elementData.length != elementCount)        
        {
            grow(elementCount);
        } //End block
        // ---------- Original Method ----------
        //if (elementData.length != elementCount) {
            //grow(elementCount);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.007 -0400", hash_original_method = "93271132EFBEDC29196C798673AC5EE7", hash_generated_method = "17A96E89DBC8BDB21D3336A9C484CCA6")
    private synchronized void writeObject(ObjectOutputStream stream) throws IOException {
        addTaint(stream.getTaint());
        stream.defaultWriteObject();
        // ---------- Original Method ----------
        //stream.defaultWriteObject();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.007 -0400", hash_original_field = "63388E0D41356F5B13E53DDDE229677C", hash_generated_field = "39DE62F55D74BDCEA57CB029AC7D9C53")

    private static final long serialVersionUID = -2767605614048989439L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.007 -0400", hash_original_field = "F94234FC21E5DB8AB303ACA6C6E18129", hash_generated_field = "F9EDE767CC2D62732638F03DE92C8707")

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

