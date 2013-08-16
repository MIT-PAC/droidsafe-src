package java.util;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;






public class Vector<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.767 -0400", hash_original_field = "BC8C6DCF12CE09E50A98BB57ADFCADD9", hash_generated_field = "499A2D73243CED99A42E214D64505A6C")

    protected int elementCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.768 -0400", hash_original_field = "8D395F1876FF8AE01BE52A9C4C2ED552", hash_generated_field = "0B3F426A5758654DA42168DCEAA2747C")

    protected Object[] elementData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.768 -0400", hash_original_field = "7D8D485EB9C5EE294297FC18663D46D8", hash_generated_field = "C57732C85DED3048B8128B9506ED7293")

    protected int capacityIncrement;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.768 -0400", hash_original_method = "DACE16FEA3F29475D20FB4F2AE2C4BF3", hash_generated_method = "F92FDEEA28BC7E4B901A0A343D42232D")
    public  Vector() {
        this(DEFAULT_SIZE, 0);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.768 -0400", hash_original_method = "516F631FEB27C4B8AC76BAFF727DB150", hash_generated_method = "F3CDA2715564D8E8516468F487D83DFA")
    public  Vector(int capacity) {
        this(capacity, 0);
        addTaint(capacity);
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.770 -0400", hash_original_method = "5554DADF2588E03BDCF1E2168D3E3C3F", hash_generated_method = "AB91ED40A9838270A2ED5EA6CEA47583")
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.770 -0400", hash_original_method = "088E691065B085AAA9856C71AD537C28", hash_generated_method = "D6A38108D0F472EE1508408B82FFDB6D")
    @SuppressWarnings("unchecked")
    private E[] newElementArray(int size) {
        addTaint(size);
E[] var1B2FE2B69B45A4B74BDC1E1658079136_1942140942 =         (E[]) new Object[size];
        var1B2FE2B69B45A4B74BDC1E1658079136_1942140942.addTaint(taint);
        return var1B2FE2B69B45A4B74BDC1E1658079136_1942140942;
        // ---------- Original Method ----------
        //return (E[]) new Object[size];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.770 -0400", hash_original_method = "48191DBEFAEF26CE3AD2676469C6C588", hash_generated_method = "21D6949D568C503AE4CDB992DFC1EAB1")
    @Override
    public void add(int location, E object) {
        addTaint(object.getTaint());
        addTaint(location);
        insertElementAt(object, location);
        // ---------- Original Method ----------
        //insertElementAt(object, location);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.771 -0400", hash_original_method = "4A1B135502A4FBF53B5971ADD0895265", hash_generated_method = "BF3B82877E4DDEEE7C6737C2C008AFAD")
    @Override
    public synchronized boolean add(E object) {
        if(elementCount == elementData.length)        
        {
            growByOne();
        } //End block
        elementData[elementCount++] = object;
        modCount++;
        boolean varB326B5062B2F0E69046810717534CB09_1129931999 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_171566143 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_171566143;
        // ---------- Original Method ----------
        //if (elementCount == elementData.length) {
            //growByOne();
        //}
        //elementData[elementCount++] = object;
        //modCount++;
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.779 -0400", hash_original_method = "721C95E0B3ACA6F09AE8F219EA79313F", hash_generated_method = "FEED2E7AF62F09D2E0571F71F47C5EAA")
    @Override
    public synchronized boolean addAll(int location, Collection<? extends E> collection) {
        addTaint(collection.getTaint());
        if(location >= 0 && location <= elementCount)        
        {
            int size = collection.size();
            if(size == 0)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1291997417 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_107037384 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_107037384;
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
            boolean varB326B5062B2F0E69046810717534CB09_151790388 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_414269003 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_414269003;
        } //End block
        java.lang.ArrayIndexOutOfBoundsException varC4E99290A8E221CD17D3A059991A865D_691002185 = arrayIndexOutOfBoundsException(location, elementCount);
        varC4E99290A8E221CD17D3A059991A865D_691002185.addTaint(taint);
        throw varC4E99290A8E221CD17D3A059991A865D_691002185;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.781 -0400", hash_original_method = "936868945967E6EE9BEE2301A3FC2D7D", hash_generated_method = "9F3835C87913D8025D0DB15A02796858")
    @Override
    public synchronized boolean addAll(Collection<? extends E> collection) {
        addTaint(collection.getTaint());
        boolean var0FEBF37003C2F5CB55B75F0E5C98FB17_1899137916 = (addAll(elementCount, collection));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_262300855 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_262300855;
        // ---------- Original Method ----------
        //return addAll(elementCount, collection);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.781 -0400", hash_original_method = "A5163E0F34F09A3D8DEA4C412903D1D1", hash_generated_method = "A227B57D2FB30D770C2C72C2E445FBFD")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.781 -0400", hash_original_method = "DD1AE1F8EA98D3605FDD193E0651B9D6", hash_generated_method = "7262DE01DC95807F0A43071764ECEBC7")
    public synchronized int capacity() {
        int var07C376840AFF9C17A8118A6D2922D513_475383977 = (elementData.length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2115132097 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2115132097;
        // ---------- Original Method ----------
        //return elementData.length;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.782 -0400", hash_original_method = "1F4E1B041EF06199B18000DD20E283A1", hash_generated_method = "CB8944604C59D0C0C157C3038F849082")
    @Override
    public void clear() {
        removeAllElements();
        // ---------- Original Method ----------
        //removeAllElements();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.782 -0400", hash_original_method = "1610A6C93F0D6F1C66DC0DFCBD33D1B2", hash_generated_method = "B1E43A5F6043F01F2CC8B48FFF7ADD88")
    @Override
    @SuppressWarnings("unchecked")
    public synchronized Object clone() {
        try 
        {
            Vector<E> vector = (Vector<E>) super.clone();
            vector.elementData = elementData.clone();
Object varAFE05DA6BCC31D768176AC4CA91A2154_1962887840 =             vector;
            varAFE05DA6BCC31D768176AC4CA91A2154_1962887840.addTaint(taint);
            return varAFE05DA6BCC31D768176AC4CA91A2154_1962887840;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_1274453417 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_1274453417.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_1274453417;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.783 -0400", hash_original_method = "4017403066D0A85EBF82EC88CFE4ED84", hash_generated_method = "C6EA1A24971FDED6ADFF730BAF853145")
    @Override
    public boolean contains(Object object) {
        addTaint(object.getTaint());
        boolean var2B4521032507EC37772354BF4D8E8ED8_437464688 = (indexOf(object, 0) != -1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2140241920 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2140241920;
        // ---------- Original Method ----------
        //return indexOf(object, 0) != -1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.783 -0400", hash_original_method = "51334898ABB14C1CD821FC4FE1B2383C", hash_generated_method = "93D61FF6AC6A8D03C267CFAE0DDE3DE9")
    @Override
    public synchronized boolean containsAll(Collection<?> collection) {
        addTaint(collection.getTaint());
        boolean var7D226F5CF447636EBAEB56D51C084B69_2126402487 = (super.containsAll(collection));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_888060326 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_888060326;
        // ---------- Original Method ----------
        //return super.containsAll(collection);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.784 -0400", hash_original_method = "9FCD2BB7391A67913F5DC5B0A38C9668", hash_generated_method = "ABCEE675B5AABD0DFD2EE89ECE981656")
    public synchronized void copyInto(Object[] elements) {
        addTaint(elements[0].getTaint());
        System.arraycopy(elementData, 0, elements, 0, elementCount);
        // ---------- Original Method ----------
        //System.arraycopy(elementData, 0, elements, 0, elementCount);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.800 -0400", hash_original_method = "B6E84DE201AAEF8307F5E7CA8A6AEF90", hash_generated_method = "3394A8B949040FA17A0B7582B856E695")
    public Enumeration<E> elements() {
Enumeration<E> varBE1AF8000F96BB9037958F34C83E40EA_1239515166 =         new Enumeration<E>() {        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.798 -0400", hash_original_field = "30905E6E8D02502121446F7E78ED3C72", hash_generated_field = "BEC7A604E336F37C0CC9A9336799291F")
        int pos = 0;
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.799 -0400", hash_original_method = "BE1470CA1AE3A8E761558BC585309C9C", hash_generated_method = "9F02CF1DB09C1E75313C933287122881")
        public boolean hasMoreElements() {
            boolean varE2C04D119C3740B4B44C2924A8601E86_922556880 = (pos < elementCount);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_19258372 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_19258372;
            // ---------- Original Method ----------
            //return pos < elementCount;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.800 -0400", hash_original_method = "587FDB7AD89D6517798ABA6D2628416A", hash_generated_method = "2BD8115E021EF9A4CB1A087B6FE4287C")
        @SuppressWarnings("unchecked")
        public E nextElement() {
            synchronized
(Vector.this)            {
                if(pos < elementCount)                
                {
E varC0FA0F1B092A92789BDD5894D3168FF7_658788251 =                     (E) elementData[pos++];
                    varC0FA0F1B092A92789BDD5894D3168FF7_658788251.addTaint(taint);
                    return varC0FA0F1B092A92789BDD5894D3168FF7_658788251;
                } //End block
            } //End block
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_1042799906 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_1042799906.addTaint(taint);
            throw var28D00AB599969908D71F102AF992D49A_1042799906;
            // ---------- Original Method ----------
            //synchronized (Vector.this) {
                    //if (pos < elementCount) {
                        //return (E) elementData[pos++];
                    //}
                //}
            //throw new NoSuchElementException();
        }
};
        varBE1AF8000F96BB9037958F34C83E40EA_1239515166.addTaint(taint);
        return varBE1AF8000F96BB9037958F34C83E40EA_1239515166;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.801 -0400", hash_original_method = "18CA94477F381022C117A5BE2C4C7154", hash_generated_method = "4C2D7C68945F209C93ED4EC720F3912B")
    @Override
    public synchronized boolean equals(Object object) {
        addTaint(object.getTaint());
        if(this == object)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_376308279 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_883737317 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_883737317;
        } //End block
        if(object instanceof List)        
        {
            List<?> list = (List<?>) object;
            if(list.size() != elementCount)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1279691008 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1935065855 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1935065855;
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
                    boolean var68934A3E9455FA72420237EB05902327_256147772 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1605196046 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1605196046;
                } //End block
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1234099447 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1301191835 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1301191835;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_2135617834 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1571457023 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1571457023;
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
        if(elementCount > 0)        
        {
E var13CFD9961928450F08557A948826D5C4_1049594729 =             (E) elementData[0];
            var13CFD9961928450F08557A948826D5C4_1049594729.addTaint(taint);
            return var13CFD9961928450F08557A948826D5C4_1049594729;
        } //End block
        NoSuchElementException var28D00AB599969908D71F102AF992D49A_1965079916 = new NoSuchElementException();
        var28D00AB599969908D71F102AF992D49A_1965079916.addTaint(taint);
        throw var28D00AB599969908D71F102AF992D49A_1965079916;
        // ---------- Original Method ----------
        //if (elementCount > 0) {
            //return (E) elementData[0];
        //}
        //throw new NoSuchElementException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.802 -0400", hash_original_method = "E09D80C19A651BF8C26D5375E71CA6A0", hash_generated_method = "85A02216BB63ABF61B439E3F860A1A8A")
    @Override
    public E get(int location) {
        addTaint(location);
E var1488522CA63FA559F06B9E300ACDBE8D_2059536130 =         elementAt(location);
        var1488522CA63FA559F06B9E300ACDBE8D_2059536130.addTaint(taint);
        return var1488522CA63FA559F06B9E300ACDBE8D_2059536130;
        // ---------- Original Method ----------
        //return elementAt(location);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.803 -0400", hash_original_method = "B022A84D94038C9BB0C01ED819C072BD", hash_generated_method = "98CD7C8BB70A99FB1026BA9FE2AED777")
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.803 -0400", hash_original_method = "183736DEF5A7AE33048C32065B21DF67", hash_generated_method = "79E3116E494A0C4F1C4B2091C2181850")
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.804 -0400", hash_original_method = "1763D1FD6D85CB337349BE3D39A45770", hash_generated_method = "44C8DD9A6652B3DEE402B9A6406F2A03")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.804 -0400", hash_original_method = "20A64E7812064C08C37EDD86F8A561DF", hash_generated_method = "D3BA7DA16F2EBD1CCD1302E2BC904439")
    @Override
    public synchronized int hashCode() {
        int result = 1;
for(int i = 0;i < elementCount;i++)
        {
            result = (31 * result)
                    + (elementData[i] == null ? 0 : elementData[i].hashCode());
        } //End block
        int varB4A88417B3D0170D754C647C30B7216A_1945214544 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_80958529 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_80958529;
        // ---------- Original Method ----------
        //int result = 1;
        //for (int i = 0; i < elementCount; i++) {
            //result = (31 * result)
                    //+ (elementData[i] == null ? 0 : elementData[i].hashCode());
        //}
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.804 -0400", hash_original_method = "BA52EF79315F2CDCEE831A2AC6873E19", hash_generated_method = "BBF62EC9A4B3C519C76290E509EE57B4")
    @Override
    public int indexOf(Object object) {
        addTaint(object.getTaint());
        int var2BE7006E4C22B56F0FFEDA28C6FCFD50_1646584472 = (indexOf(object, 0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1879284039 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1879284039;
        // ---------- Original Method ----------
        //return indexOf(object, 0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.805 -0400", hash_original_method = "24750353DFD7303BB9261ABCF2B08CBF", hash_generated_method = "2A2E2AB039FE45D1C4871E0EB007D7DF")
    public synchronized int indexOf(Object object, int location) {
        addTaint(location);
        addTaint(object.getTaint());
        if(object != null)        
        {
for(int i = location;i < elementCount;i++)
            {
                if(object.equals(elementData[i]))                
                {
                    int var865C0C0B4AB0E063E5CAA3387C1A8741_170137486 = (i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1572949403 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1572949403;
                } //End block
            } //End block
        } //End block
        else
        {
for(int i = location;i < elementCount;i++)
            {
                if(elementData[i] == null)                
                {
                    int var865C0C0B4AB0E063E5CAA3387C1A8741_1904531090 = (i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1222299025 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1222299025;
                } //End block
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_784645560 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2109627067 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2109627067;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.813 -0400", hash_original_method = "0D33E0C5C56D3A9FC9F5E73253A3A2D0", hash_generated_method = "0A5BEC4EF52F3443321F854CCB7AB3E1")
    @Override
    public synchronized boolean isEmpty() {
        boolean var994633B9330EF4CC2EF62FBA7868E730_74534386 = (elementCount == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_568829597 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_568829597;
        // ---------- Original Method ----------
        //return elementCount == 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.813 -0400", hash_original_method = "BB5B48C89086DB15EEAE482333CC1417", hash_generated_method = "876320CD924F3782A5F64F8FF9E9BE4D")
    @SuppressWarnings("unchecked")
    public synchronized E lastElement() {
        try 
        {
E var844EE4F2CEF6A403C269534F85F70712_650222600 =             (E) elementData[elementCount - 1];
            var844EE4F2CEF6A403C269534F85F70712_650222600.addTaint(taint);
            return var844EE4F2CEF6A403C269534F85F70712_650222600;
        } //End block
        catch (IndexOutOfBoundsException e)
        {
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_89226828 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_89226828.addTaint(taint);
            throw var28D00AB599969908D71F102AF992D49A_89226828;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return (E) elementData[elementCount - 1];
        //} catch (IndexOutOfBoundsException e) {
            //throw new NoSuchElementException();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.814 -0400", hash_original_method = "A9A619C02ADFE7E6CEBC127D6A8D9A71", hash_generated_method = "3D5774CA09DD2DEA5CA806CB9553B507")
    @Override
    public synchronized int lastIndexOf(Object object) {
        addTaint(object.getTaint());
        int var91DE122ABF61FCD89ABEA9888C49C0A6_1829282765 = (lastIndexOf(object, elementCount - 1));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_745935511 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_745935511;
        // ---------- Original Method ----------
        //return lastIndexOf(object, elementCount - 1);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.820 -0400", hash_original_method = "DAE93837888D415686D1D0DD0C8E6815", hash_generated_method = "4CC0D52AD094205C4CCF6239F4B7A605")
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
                        int var865C0C0B4AB0E063E5CAA3387C1A8741_1300920309 = (i);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1971167513 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1971167513;
                    } //End block
                } //End block
            } //End block
            else
            {
for(int i = location;i >= 0;i--)
                {
                    if(elementData[i] == null)                    
                    {
                        int var865C0C0B4AB0E063E5CAA3387C1A8741_1310325522 = (i);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_227724086 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_227724086;
                    } //End block
                } //End block
            } //End block
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1317863459 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_790608020 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_790608020;
        } //End block
        java.lang.ArrayIndexOutOfBoundsException varC4E99290A8E221CD17D3A059991A865D_827782882 = arrayIndexOutOfBoundsException(location, elementCount);
        varC4E99290A8E221CD17D3A059991A865D_827782882.addTaint(taint);
        throw varC4E99290A8E221CD17D3A059991A865D_827782882;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.823 -0400", hash_original_method = "823A94C57B65BF07C08540507330C163", hash_generated_method = "B7EDDE50079D42CB864743FB94FE5182")
    @Override
    public boolean remove(Object object) {
        addTaint(object.getTaint());
        boolean varF4EF6A684640D8A7FEA1988BB06F1E78_854417059 = (removeElement(object));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_175798264 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_175798264;
        // ---------- Original Method ----------
        //return removeElement(object);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.824 -0400", hash_original_method = "8C6CFD9299AE63E6D8F991F5FD437E67", hash_generated_method = "0A7F2CB40947192C34EF68B4D34ECD2B")
    @Override
    public synchronized boolean removeAll(Collection<?> collection) {
        addTaint(collection.getTaint());
        boolean varC59E950B034B0097B868C2C96544231D_1466040334 = (super.removeAll(collection));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1255691325 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1255691325;
        // ---------- Original Method ----------
        //return super.removeAll(collection);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.824 -0400", hash_original_method = "B99CB02C0986A5ACE1171E44B2E88FC0", hash_generated_method = "B1AF8F7A62BE803D9C4214E5FFF1A75D")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.824 -0400", hash_original_method = "A6C501B9D7921F5FC1AF3EFCF61D0AD0", hash_generated_method = "E7F332CFDD1F1B8882214C1269A1F7DE")
    public synchronized boolean removeElement(Object object) {
        addTaint(object.getTaint());
        int index;
        if((index = indexOf(object, 0)) == -1)        
        {
            boolean var68934A3E9455FA72420237EB05902327_311176651 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1851562123 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1851562123;
        } //End block
        removeElementAt(index);
        boolean varB326B5062B2F0E69046810717534CB09_926006293 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_546543185 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_546543185;
        // ---------- Original Method ----------
        //int index;
        //if ((index = indexOf(object, 0)) == -1) {
            //return false;
        //}
        //removeElementAt(index);
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.837 -0400", hash_original_method = "81AD5D3720D67EB52B93171772D8B025", hash_generated_method = "43A8FD57FD3A1C92BAFE9A37DFF51013")
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
            java.lang.ArrayIndexOutOfBoundsException varC4E99290A8E221CD17D3A059991A865D_1280172705 = arrayIndexOutOfBoundsException(location, elementCount);
            varC4E99290A8E221CD17D3A059991A865D_1280172705.addTaint(taint);
            throw varC4E99290A8E221CD17D3A059991A865D_1280172705;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.838 -0400", hash_original_method = "6B459A814E902B0310B875E965EBDC88", hash_generated_method = "3BB2FD6F02A79F548038750D3FFF8F55")
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
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1596236107 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1596236107.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1596236107;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.839 -0400", hash_original_method = "3D3F7D0269EE9A4A0E6B970CD7AB0599", hash_generated_method = "8170F1AD4F47B779A8BA92E76EEF169E")
    @Override
    public synchronized boolean retainAll(Collection<?> collection) {
        addTaint(collection.getTaint());
        boolean var503FF497CC541185965B7F24CCB51DB8_621346309 = (super.retainAll(collection));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1035375438 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1035375438;
        // ---------- Original Method ----------
        //return super.retainAll(collection);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.BAN)
    private static ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException(int index, int size) {
        throw new ArrayIndexOutOfBoundsException(size, index);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.852 -0400", hash_original_method = "7F3B955AC73FEA732765CAFEDD4BC76C", hash_generated_method = "CCB086EE295D5FF0DEEB7C9BC28997E9")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.852 -0400", hash_original_method = "81BBFD456B62650530A643B4CB14DC43", hash_generated_method = "3D6CB99E8C32E1AA1AE8D4ABFC47E67D")
    @Override
    public synchronized int size() {
        int varBC8C6DCF12CE09E50A98BB57ADFCADD9_169368641 = (elementCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1765012930 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1765012930;
        // ---------- Original Method ----------
        //return elementCount;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.852 -0400", hash_original_method = "12E21B76E32A1D6BB3AE5A157C1F7673", hash_generated_method = "D2AF8258C812D24BD3B011CE4F372BE7")
    @Override
    public synchronized List<E> subList(int start, int end) {
        addTaint(end);
        addTaint(start);
List<E> varEAFB8AFCC789DE374EB117D1E52E1A39_880135079 =         new Collections.SynchronizedRandomAccessList<E>(super.subList(
                start, end), this);
        varEAFB8AFCC789DE374EB117D1E52E1A39_880135079.addTaint(taint);
        return varEAFB8AFCC789DE374EB117D1E52E1A39_880135079;
        // ---------- Original Method ----------
        //return new Collections.SynchronizedRandomAccessList<E>(super.subList(
                //start, end), this);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.852 -0400", hash_original_method = "6F1E76A2D55423060704E3AA65069BB2", hash_generated_method = "C290DE7BADBB750F25A3E134EF8357C6")
    @Override
    public synchronized Object[] toArray() {
        Object[] result = new Object[elementCount];
        System.arraycopy(elementData, 0, result, 0, elementCount);
Object[] varDC838461EE2FA0CA4C9BBB70A15456B0_110351784 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_110351784.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_110351784;
        // ---------- Original Method ----------
        //Object[] result = new Object[elementCount];
        //System.arraycopy(elementData, 0, result, 0, elementCount);
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.852 -0400", hash_original_method = "70C5BC6785EB6C524C2B60C494DFFFBE", hash_generated_method = "1F9F14715127FF28B278B82333D21149")
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
T[] var5DC9C33EDB9F81CF1216538024B770BE_2124147956 =         contents;
        var5DC9C33EDB9F81CF1216538024B770BE_2124147956.addTaint(taint);
        return var5DC9C33EDB9F81CF1216538024B770BE_2124147956;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.853 -0400", hash_original_method = "0DD9DB5F445E75E250BA34836212BB86", hash_generated_method = "12B603844139A5BD52EC9721C94F1CD7")
    @Override
    public synchronized String toString() {
        if(elementCount == 0)        
        {
String varAA6F5C51D397701D3E65BDD2DF6A0CE1_382590946 =             "[]";
            varAA6F5C51D397701D3E65BDD2DF6A0CE1_382590946.addTaint(taint);
            return varAA6F5C51D397701D3E65BDD2DF6A0CE1_382590946;
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
        if(elementData.length != elementCount)        
        {
            grow(elementCount);
        } //End block
        // ---------- Original Method ----------
        //if (elementData.length != elementCount) {
            //grow(elementCount);
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.853 -0400", hash_original_method = "93271132EFBEDC29196C798673AC5EE7", hash_generated_method = "17A96E89DBC8BDB21D3336A9C484CCA6")
    private synchronized void writeObject(ObjectOutputStream stream) throws IOException {
        addTaint(stream.getTaint());
        stream.defaultWriteObject();
        // ---------- Original Method ----------
        //stream.defaultWriteObject();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.853 -0400", hash_original_field = "63388E0D41356F5B13E53DDDE229677C", hash_generated_field = "39DE62F55D74BDCEA57CB029AC7D9C53")

    private static final long serialVersionUID = -2767605614048989439L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.853 -0400", hash_original_field = "F94234FC21E5DB8AB303ACA6C6E18129", hash_generated_field = "F9EDE767CC2D62732638F03DE92C8707")

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

