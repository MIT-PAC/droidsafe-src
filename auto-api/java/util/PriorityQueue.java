package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PriorityQueue<E> extends AbstractQueue<E> implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.355 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "F06612A05C836674433E69C513561353")

    private int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.355 -0400", hash_original_field = "4092F21BD0E2CC3C9CA971DF59AA8608", hash_generated_field = "0E313AD6D66C4F0B00F12D6B16E96047")

    private Comparator<? super E> comparator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.355 -0400", hash_original_field = "6A7F245843454CF4F28AD7C5E2572AA2", hash_generated_field = "777D1E33E50D4CDEA795A5FBEBE9B75E")

    private transient E[] elements;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.356 -0400", hash_original_method = "58E13E76C10508B840C89750DBA2F694", hash_generated_method = "E9B04ED5345B292AB2449CD20B00601E")
    public  PriorityQueue() {
        this(DEFAULT_CAPACITY);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.356 -0400", hash_original_method = "911F14A3F7F22EFA3B185959CB78D2B3", hash_generated_method = "ACF5EE27996EEA2E09D5472C34B00B28")
    public  PriorityQueue(int initialCapacity) {
        this(initialCapacity, null);
        addTaint(initialCapacity);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.356 -0400", hash_original_method = "8DDCD911658428EEC7F53C9270972E95", hash_generated_method = "2D885A182777F261205D361EA73AADAA")
    public  PriorityQueue(int initialCapacity, Comparator<? super E> comparator) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } 
        elements = newElementArray(initialCapacity);
        this.comparator = comparator;
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.357 -0400", hash_original_method = "C29AE678CCE898A5EAC5F93683C50E53", hash_generated_method = "8256F0D9F24915C551496FD016A950B7")
    public  PriorityQueue(Collection<? extends E> c) {
        {
            getFromPriorityQueue((PriorityQueue<? extends E>) c);
        } 
        {
            getFromSortedSet((SortedSet<? extends E>) c);
        } 
        {
            initSize(c);
            addAll(c);
        } 
        addTaint(c.getTaint());
        
        
            
        
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.357 -0400", hash_original_method = "DE95FDD082B572F7824AA76C4D6C59F3", hash_generated_method = "6C27BC807D16E35A1B59FBE7A015FC0E")
    public  PriorityQueue(PriorityQueue<? extends E> c) {
        getFromPriorityQueue(c);
        addTaint(c.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.357 -0400", hash_original_method = "2B1757BB83768A507629744C75B61CCF", hash_generated_method = "42979B879C4FD51A50B4D214039D47DA")
    public  PriorityQueue(SortedSet<? extends E> c) {
        getFromSortedSet(c);
        addTaint(c.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.358 -0400", hash_original_method = "29E42406182AF866EF1235165AD5E16B", hash_generated_method = "E557993BC29F11C4E70B1A54514AF5D4")
    @Override
    public Iterator<E> iterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_144127799 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_144127799 = new PriorityIterator();
        varB4EAC82CA7396A68D541C85D26508E83_144127799.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_144127799;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.358 -0400", hash_original_method = "3CA361324F026F8C9B0AA94A864ACDD9", hash_generated_method = "5059254B682A72BC10BE9786EA964038")
    @Override
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_817692981 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_817692981;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.358 -0400", hash_original_method = "B6F04CCC5A967411777D1204AE8409FD", hash_generated_method = "88680BC391D87D89DDEAB30C7B19D82A")
    @Override
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.359 -0400", hash_original_method = "0719F1496073B58B1DCD9EB6FF49B15B", hash_generated_method = "5864C6EC71D652ADDFAA75B3D143E2D7")
    public boolean offer(E o) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        growToSize(size + 1);
        elements[size] = o;
        siftUp(size++);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1397346400 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1397346400;
        
        
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.359 -0400", hash_original_method = "A38C03A45CA3873EDA3CC27F4EA1E154", hash_generated_method = "26F13869F5B332E5F1DD03AEB264D8C9")
    public E poll() {
        E varB4EAC82CA7396A68D541C85D26508E83_2020860148 = null; 
        E varB4EAC82CA7396A68D541C85D26508E83_1021745944 = null; 
        {
            boolean var8697D8FD88387502770F7E34BAFBCF5A_984000370 = (isEmpty());
            {
                varB4EAC82CA7396A68D541C85D26508E83_2020860148 = null;
            } 
        } 
        E result = elements[0];
        removeAt(0);
        varB4EAC82CA7396A68D541C85D26508E83_1021745944 = result;
        E varA7E53CE21691AB073D9660D615818899_401393758; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_401393758 = varB4EAC82CA7396A68D541C85D26508E83_2020860148;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_401393758 = varB4EAC82CA7396A68D541C85D26508E83_1021745944;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_401393758.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_401393758;
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.360 -0400", hash_original_method = "E20ADCFD9D589330A90956929B5E43AA", hash_generated_method = "8BC8F49EB63A51A43195CF211DAA544E")
    public E peek() {
        E varB4EAC82CA7396A68D541C85D26508E83_1024095134 = null; 
        E varB4EAC82CA7396A68D541C85D26508E83_291889699 = null; 
        {
            boolean var8697D8FD88387502770F7E34BAFBCF5A_877777293 = (isEmpty());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1024095134 = null;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_291889699 = elements[0];
        E varA7E53CE21691AB073D9660D615818899_183154460; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_183154460 = varB4EAC82CA7396A68D541C85D26508E83_1024095134;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_183154460 = varB4EAC82CA7396A68D541C85D26508E83_291889699;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_183154460.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_183154460;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.360 -0400", hash_original_method = "83ACC201A16F2FDDF97B6B07FFFB2168", hash_generated_method = "51248D1257B23F0B894654C066CAF1B3")
    public Comparator<? super E> comparator() {
        Comparator<? super E> varB4EAC82CA7396A68D541C85D26508E83_1041404170 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1041404170 = comparator;
        varB4EAC82CA7396A68D541C85D26508E83_1041404170.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1041404170;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.360 -0400", hash_original_method = "688475050D9EB13B173156735A8487EC", hash_generated_method = "43D549823E94F374F977723202463E91")
    @Override
    @SuppressWarnings("unchecked")
    public boolean remove(Object o) {
        {
            int targetIndex = 0;
            {
                {
                    boolean var14BEDC89BBCC9A2F0435768C7E2596C0_503464608 = (o.equals(elements[targetIndex]));
                    {
                        removeAt(targetIndex);
                    } 
                } 
            } 
        } 
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2091697702 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2091697702;
        
        
            
        
        
            
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.361 -0400", hash_original_method = "B47D74753BC2900138E758F55799A6CE", hash_generated_method = "73A0DB32F9537369A2C01B85B208C21A")
    @Override
    public boolean add(E o) {
        boolean var64BBDD044E2016C4CCF9BF6F99B3CA5E_2112694002 = (offer(o));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1167175134 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1167175134;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.361 -0400", hash_original_method = "21BC9CFA0DCB43D7F88609A00A8387EA", hash_generated_method = "C39464255834500D84AC122C8073B91E")
    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        in.defaultReadObject();
        int capacity = in.readInt();
        elements = newElementArray(capacity);
        {
            int i = 0;
            {
                elements[i] = (E) in.readObject();
            } 
        } 
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.362 -0400", hash_original_method = "AD595EBD68A8B9AE564B2F0FB242243F", hash_generated_method = "4A543299568D78B054C848E208183E0F")
    @SuppressWarnings("unchecked")
    private E[] newElementArray(int capacity) {
        E[] varB4EAC82CA7396A68D541C85D26508E83_933228281 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_933228281 = (E[]) new Object[capacity];
        addTaint(capacity);
        varB4EAC82CA7396A68D541C85D26508E83_933228281.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_933228281;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.362 -0400", hash_original_method = "B9F4F56172F737D7C7C85B3EBC28F8E6", hash_generated_method = "7657E28F2641C936672FE1F4C7EE8E7C")
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(elements.length);
        {
            int i = 0;
            {
                out.writeObject(elements[i]);
            } 
        } 
        addTaint(out.getTaint());
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.363 -0400", hash_original_method = "D14ABECCFCD1D91F89D634472CAA5A57", hash_generated_method = "A964D74645D797898043F81B6EEC66B2")
    @SuppressWarnings("unchecked")
    private void getFromPriorityQueue(PriorityQueue<? extends E> c) {
        initSize(c);
        comparator = (Comparator<? super E>) c.comparator();
        System.arraycopy(c.elements, 0, elements, 0, c.size());
        size = c.size();
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.363 -0400", hash_original_method = "4C352FE9F3E754E26A0F4A78FD0E430D", hash_generated_method = "9ADA6D0B0100F240DC8D1476401214F9")
    @SuppressWarnings("unchecked")
    private void getFromSortedSet(SortedSet<? extends E> c) {
        initSize(c);
        comparator = (Comparator<? super E>) c.comparator();
        Iterator<? extends E> iter = c.iterator();
        {
            boolean varADABAFEBBAB7E585DD903333BD7F20A8_1082245223 = (iter.hasNext());
            {
                elements[size++] = iter.next();
            } 
        } 
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.363 -0400", hash_original_method = "13EA6CC04750FAC13EC27ED999F2AF83", hash_generated_method = "91FB57E0438A27000EA5AC33112B8E90")
    private void removeAt(int index) {
        elements[index] = elements[size];
        siftDown(index);
        elements[size] = null;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.364 -0400", hash_original_method = "A0927ACC17EA40D5CE28A0E243882DFA", hash_generated_method = "604EA5C9B5B5FAA2E6837EA7F743F919")
    private int compare(E o1, E o2) {
        {
            int var8E6857C2AA67AFE2E02DAFE705F5A103_3372592 = (comparator.compare(o1, o2));
        } 
        int var003A3D2E3C76D1E7F67F3C0717E9BFEE_1912894637 = (((Comparable<? super E>) o1).compareTo(o2));
        addTaint(o1.getTaint());
        addTaint(o2.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_537603091 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_537603091;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.365 -0400", hash_original_method = "800D9111DE2C548E56C8C7DBADDE1532", hash_generated_method = "F1AE1444C90103F087C13A3A5CD038C3")
    private void siftUp(int childIndex) {
        E target = elements[childIndex];
        int parentIndex;
        {
            parentIndex = (childIndex - 1) / 2;
            E parent = elements[parentIndex];
            {
                boolean var23A6EC4002301EE935E150767260E50F_88356570 = (compare(parent, target) <= 0);
            } 
            elements[childIndex] = parent;
            childIndex = parentIndex;
        } 
        elements[childIndex] = target;
        
        
        
        
            
            
            
                
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.365 -0400", hash_original_method = "1734F3496FF56F66F4EE0A19F9B9DAC6", hash_generated_method = "D799A1E6A8041244934CDD8A4B90F1AB")
    private void siftDown(int rootIndex) {
        E target = elements[rootIndex];
        int childIndex;
        {
            boolean var2BE9875CC5BE2A3B1EB426DF1CD26854_1399895646 = ((childIndex = rootIndex * 2 + 1) < size);
            {
                {
                    boolean var5A0855C6AD3F11E6528C84B7FB574B75_514614097 = (childIndex + 1 < size
                    && compare(elements[childIndex + 1], elements[childIndex]) < 0);
                } 
                {
                    boolean var2D362E3D6324559A45021D01616493EC_97853681 = (compare(target, elements[childIndex]) <= 0);
                } 
                elements[rootIndex] = elements[childIndex];
                rootIndex = childIndex;
            } 
        } 
        elements[rootIndex] = target;
        
        
        
        
            
                    
                
            
            
                
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.366 -0400", hash_original_method = "EB006E653F2B1C142E2B4E925ED799D5", hash_generated_method = "68C77DCE4A5F7D25CA8ED733072F0014")
    private void initSize(Collection<? extends E> c) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        {
            boolean var528EAD02A70F822F393BB0C54FBB923C_511133190 = (c.isEmpty());
            {
                elements = newElementArray(1);
            } 
            {
                int capacity = (int) Math.ceil(c.size()
                    * DEFAULT_INIT_CAPACITY_RATIO);
                elements = newElementArray(capacity);
            } 
        } 
        addTaint(c.getTaint());
        
        
            
        
        
            
        
            
                    
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.366 -0400", hash_original_method = "69C661AD3CEEB8E6AEE784D427C4FE57", hash_generated_method = "222FBC5F209088B508B6EC841803FD40")
    private void growToSize(int size) {
        {
            E[] newElements = newElementArray(size * DEFAULT_CAPACITY_RATIO);
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        } 
        addTaint(size);
        
        
            
            
            
        
    }

    
    private class PriorityIterator implements Iterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.367 -0400", hash_original_field = "0FDC7B8AD151A087959E8267B1003E57", hash_generated_field = "930A7091E390C9A7E80CCAF83CF059FC")

        private int currentIndex = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.367 -0400", hash_original_field = "C8CBC8273C760FD4AFB07C11B42120E4", hash_generated_field = "46337D80FA4CAC78540F7C8D494816D7")

        private boolean allowRemove = false;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.367 -0400", hash_original_method = "2E6FB10AA8F6C05F40E19220FCEB4F6A", hash_generated_method = "2E6FB10AA8F6C05F40E19220FCEB4F6A")
        public PriorityIterator ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.367 -0400", hash_original_method = "0FB46E9366D1118FDBE303EE479D4896", hash_generated_method = "0EE3FAA6D3BD2A23B869F0B2670CB37C")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_909373420 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_909373420;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.368 -0400", hash_original_method = "23667DB5E37E55798D44E0D3057B4835", hash_generated_method = "0ED9F2A1A9148BECB2BC61DFAE458042")
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_1314774558 = null; 
            {
                boolean var61E0EA93C8F2038A69462393E2D5DF33_1325653677 = (!hasNext());
                {
                    if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                } 
            } 
            allowRemove = true;
            varB4EAC82CA7396A68D541C85D26508E83_1314774558 = elements[++currentIndex];
            varB4EAC82CA7396A68D541C85D26508E83_1314774558.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1314774558;
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.368 -0400", hash_original_method = "DB2903D95C50C28D70F9F205A7F7C8FE", hash_generated_method = "4654C17AF11C21C01E664DAF5AF1C650")
        public void remove() {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            } 
            allowRemove = false;
            removeAt(currentIndex--);
            
            
                
            
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.368 -0400", hash_original_field = "A8CEBCDC9E5A376437C3BCDBEE826CAD", hash_generated_field = "6ED9460F7E864D123E91629C31FC972F")

    private static final long serialVersionUID = -7720805057305804111L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.368 -0400", hash_original_field = "C6D4C85929CA1814E8D05E351A264EE9", hash_generated_field = "BCEA1D95B9B50E0A58555DB49184C7B7")

    private static final int DEFAULT_CAPACITY = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.368 -0400", hash_original_field = "47A5B89B204E4D35D409724169D22E2B", hash_generated_field = "B4498717B3B173B14E1D93EC7A27ECD2")

    private static final double DEFAULT_INIT_CAPACITY_RATIO = 1.1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.368 -0400", hash_original_field = "6B51169B7E5BF711B9FF1384EA7CF00E", hash_generated_field = "406B4BAD8512687AA764242F2E961671")

    private static final int DEFAULT_CAPACITY_RATIO = 2;
}

