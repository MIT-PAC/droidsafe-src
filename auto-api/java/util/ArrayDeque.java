package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.*;

public class ArrayDeque<E> extends AbstractCollection<E> implements Deque<E>, Cloneable, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.658 -0400", hash_original_field = "6A7F245843454CF4F28AD7C5E2572AA2", hash_generated_field = "777D1E33E50D4CDEA795A5FBEBE9B75E")

    private transient E[] elements;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.658 -0400", hash_original_field = "96E89A298E0A9F469B9AE458D6AFAE9F", hash_generated_field = "C80FE6D9E9CF1E423738D59094B3A099")

    private transient int head;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.658 -0400", hash_original_field = "7AEA2552DFE7EB84B9443B6FC9BA6E01", hash_generated_field = "993ACFB1D5CE316FEA289C1E850AAC75")

    private transient int tail;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.659 -0400", hash_original_method = "8C7B174379DD3B2C843811B1130834BD", hash_generated_method = "151203C88A4AC41E68C2D3AED6B6A179")
    public  ArrayDeque() {
        elements = (E[]) new Object[16];
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.659 -0400", hash_original_method = "690593276EDD66C533F49BEE09E9C663", hash_generated_method = "961A3DCC13843F4EF778BFE212FF8CDC")
    public  ArrayDeque(int numElements) {
        allocateElements(numElements);
        addTaint(numElements);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.659 -0400", hash_original_method = "5E7B6C878951D7CA458070D073F03065", hash_generated_method = "E857B3907858ED486A3251136AC22BF3")
    public  ArrayDeque(Collection<? extends E> c) {
        allocateElements(c.size());
        addAll(c);
        addTaint(c.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.659 -0400", hash_original_method = "86AF4C096D752C20A8CB0D886E79B7FB", hash_generated_method = "776AA9151FAD73EFE988A7995D6E6806")
    private void allocateElements(int numElements) {
        int initialCapacity = MIN_INITIAL_CAPACITY;
        {
            initialCapacity = numElements;
            initialCapacity |= (initialCapacity >>>  1);
            initialCapacity |= (initialCapacity >>>  2);
            initialCapacity |= (initialCapacity >>>  4);
            initialCapacity |= (initialCapacity >>>  8);
            initialCapacity |= (initialCapacity >>> 16);
            initialCapacity >>>= 1;
        } 
        elements = (E[]) new Object[initialCapacity];
        addTaint(numElements);
        
        
        
            
            
            
            
            
            
            
            
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.660 -0400", hash_original_method = "35225802D7F18BE5673FDDFDE4B70B2E", hash_generated_method = "2DDD87C0C29DA39AF5480D9444113348")
    private void doubleCapacity() {
        int p = head;
        int n = elements.length;
        int r = n - p;
        int newCapacity = n << 1;
        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Sorry, deque too big");
        Object[] a = new Object[newCapacity];
        System.arraycopy(elements, p, a, 0, r);
        System.arraycopy(elements, 0, a, r, p);
        elements = (E[])a;
        head = 0;
        tail = n;
        
        
        
        
        
        
        
            
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.661 -0400", hash_original_method = "5E8669E32F5C4FDF3D4D82BA2C3949A2", hash_generated_method = "D357682DEE5017151CFE9C76268B6F32")
    private <T> T[] copyElements(T[] a) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_17839969 = null; 
        {
            System.arraycopy(elements, head, a, 0, size());
        } 
        {
            int headPortionLen = elements.length - head;
            System.arraycopy(elements, head, a, 0, headPortionLen);
            System.arraycopy(elements, 0, a, headPortionLen, tail);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_17839969 = a;
        addTaint(a[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_17839969.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_17839969;
        
        
            
        
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.662 -0400", hash_original_method = "CBAC64602FF2D7F893923E0ABA8C507E", hash_generated_method = "43D388445E29AF9CA2D6DC6F0D76AE09")
    public void addFirst(E e) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        elements[head = (head - 1) & (elements.length - 1)] = e;
        doubleCapacity();
        
        
            
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.663 -0400", hash_original_method = "1B31DB8E2D035FB7799256F8004C4036", hash_generated_method = "0B40DDD564869045C6F700693C8FFF2F")
    public void addLast(E e) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        elements[tail] = e;
        {
            boolean var7F88578DCEE369DCF633CD33646CC15C_881585054 = ((tail = (tail + 1) & (elements.length - 1)) == head);
            doubleCapacity();
        } 
        
        
            
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.664 -0400", hash_original_method = "8D3228F5DEFAE0131B22F51707654BE0", hash_generated_method = "EB5D2EDDCB43FF496F783C2207E48799")
    public boolean offerFirst(E e) {
        addFirst(e);
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_149834128 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_149834128;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.664 -0400", hash_original_method = "15C090CE1A98280B8C8C7B6514A10013", hash_generated_method = "E4B36881393F00F8D6EEDAB136648FAB")
    public boolean offerLast(E e) {
        addLast(e);
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_744803059 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_744803059;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.665 -0400", hash_original_method = "8D1F2D8C9F4BF8EC3B65B975014CE8A7", hash_generated_method = "80AF9C2E8E16621278FFA91ED4218AFA")
    public E removeFirst() {
        E varB4EAC82CA7396A68D541C85D26508E83_1765191769 = null; 
        E x = pollFirst();
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_1765191769 = x;
        varB4EAC82CA7396A68D541C85D26508E83_1765191769.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1765191769;
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.665 -0400", hash_original_method = "90A521D0942C6C4821F3F861C2808726", hash_generated_method = "277CE87C23A234D1F6957466A7CB8913")
    public E removeLast() {
        E varB4EAC82CA7396A68D541C85D26508E83_105366724 = null; 
        E x = pollLast();
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_105366724 = x;
        varB4EAC82CA7396A68D541C85D26508E83_105366724.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_105366724;
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.666 -0400", hash_original_method = "70BCEEA789C7C02318BA6052E8B29D53", hash_generated_method = "FC2A0D3BE87FB6F845BDDD24B66E8DD8")
    public E pollFirst() {
        E varB4EAC82CA7396A68D541C85D26508E83_173524213 = null; 
        E varB4EAC82CA7396A68D541C85D26508E83_2095718585 = null; 
        int h = head;
        E result = elements[h];
        varB4EAC82CA7396A68D541C85D26508E83_173524213 = null;
        elements[h] = null;
        head = (h + 1) & (elements.length - 1);
        varB4EAC82CA7396A68D541C85D26508E83_2095718585 = result;
        E varA7E53CE21691AB073D9660D615818899_2055080814; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2055080814 = varB4EAC82CA7396A68D541C85D26508E83_173524213;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2055080814 = varB4EAC82CA7396A68D541C85D26508E83_2095718585;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2055080814.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2055080814;
        
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.666 -0400", hash_original_method = "CC3133A0441CFBBC149D7C0D4094D190", hash_generated_method = "CCFA9198E669EF20C3DF0F2815B49117")
    public E pollLast() {
        E varB4EAC82CA7396A68D541C85D26508E83_2120753223 = null; 
        E varB4EAC82CA7396A68D541C85D26508E83_1175050128 = null; 
        int t = (tail - 1) & (elements.length - 1);
        E result = elements[t];
        varB4EAC82CA7396A68D541C85D26508E83_2120753223 = null;
        elements[t] = null;
        tail = t;
        varB4EAC82CA7396A68D541C85D26508E83_1175050128 = result;
        E varA7E53CE21691AB073D9660D615818899_398819247; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_398819247 = varB4EAC82CA7396A68D541C85D26508E83_2120753223;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_398819247 = varB4EAC82CA7396A68D541C85D26508E83_1175050128;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_398819247.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_398819247;
        
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.667 -0400", hash_original_method = "969C370DEEB1254D835EA60A850D9474", hash_generated_method = "864752FE98430CF8E2A2E6D44028A066")
    public E getFirst() {
        E varB4EAC82CA7396A68D541C85D26508E83_1081063145 = null; 
        E x = elements[head];
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_1081063145 = x;
        varB4EAC82CA7396A68D541C85D26508E83_1081063145.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1081063145;
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.667 -0400", hash_original_method = "609D7D9752B1EA7B409577881D715ECB", hash_generated_method = "E15B446D90594058589182C5F6B84DF2")
    public E getLast() {
        E varB4EAC82CA7396A68D541C85D26508E83_1953753583 = null; 
        E x = elements[(tail - 1) & (elements.length - 1)];
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_1953753583 = x;
        varB4EAC82CA7396A68D541C85D26508E83_1953753583.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1953753583;
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.668 -0400", hash_original_method = "1112FC6950CD2F89C0F90F3FD6940182", hash_generated_method = "B0A5185C21266887F3A2BED439A6B641")
    public E peekFirst() {
        E varB4EAC82CA7396A68D541C85D26508E83_1895582458 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1895582458 = elements[head];
        varB4EAC82CA7396A68D541C85D26508E83_1895582458.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1895582458;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.668 -0400", hash_original_method = "2FB93C1E4553786B68715ADDCB3204FE", hash_generated_method = "A10740EA15ACC8A7CEC9179118908354")
    public E peekLast() {
        E varB4EAC82CA7396A68D541C85D26508E83_1887951933 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1887951933 = elements[(tail - 1) & (elements.length - 1)];
        varB4EAC82CA7396A68D541C85D26508E83_1887951933.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1887951933;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.669 -0400", hash_original_method = "2655E37A6129D552BDB18D712FBDBB78", hash_generated_method = "94769BD85793C8F85A46419C01195B28")
    public boolean removeFirstOccurrence(Object o) {
        int mask = elements.length - 1;
        int i = head;
        E x;
        {
            boolean var1329AA2C156BE9C813DA2AD363D45946_1031322675 = ((x = elements[i]) != null);
            {
                {
                    boolean var8C3257AD3EAB1DB4919EC2B6E1BD3609_1947128265 = (o.equals(x));
                    {
                        delete(i);
                    } 
                } 
                i = (i + 1) & mask;
            } 
        } 
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1901309552 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1901309552;
        
        
            
        
        
        
        
            
                
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.669 -0400", hash_original_method = "67D061371E16CEF717EF2A58AA73F6CB", hash_generated_method = "3B0BF7E75A32B24D4EC90132C53277EA")
    public boolean removeLastOccurrence(Object o) {
        int mask = elements.length - 1;
        int i = (tail - 1) & mask;
        E x;
        {
            boolean var1329AA2C156BE9C813DA2AD363D45946_495996232 = ((x = elements[i]) != null);
            {
                {
                    boolean var8C3257AD3EAB1DB4919EC2B6E1BD3609_476831793 = (o.equals(x));
                    {
                        delete(i);
                    } 
                } 
                i = (i - 1) & mask;
            } 
        } 
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2069988759 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2069988759;
        
        
            
        
        
        
        
            
                
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.670 -0400", hash_original_method = "056B268263D9E7E4C2239F12D1024514", hash_generated_method = "D0BD89CE4D01AA5343152EE95DA64F72")
    public boolean add(E e) {
        addLast(e);
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1506638367 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1506638367;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.670 -0400", hash_original_method = "90158A89D183AFC9420F99CD4C19A119", hash_generated_method = "86CED908DDC663534B5BDD418DA79F2C")
    public boolean offer(E e) {
        boolean var1C8D098E0D25C154182D97F2DFA9E90F_1368686786 = (offerLast(e));
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_745681520 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_745681520;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.671 -0400", hash_original_method = "5200E72EC4A7AF0A97DAC56CA915551B", hash_generated_method = "23B9C7672D05A1E4CEF6F191F5424287")
    public E remove() {
        E varB4EAC82CA7396A68D541C85D26508E83_736654760 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_736654760 = removeFirst();
        varB4EAC82CA7396A68D541C85D26508E83_736654760.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_736654760;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.672 -0400", hash_original_method = "D6F4991F5239518842015971CA437CF0", hash_generated_method = "2D9EA035875C30705CE16CA8F975A0D6")
    public E poll() {
        E varB4EAC82CA7396A68D541C85D26508E83_1777091825 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1777091825 = pollFirst();
        varB4EAC82CA7396A68D541C85D26508E83_1777091825.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1777091825;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.673 -0400", hash_original_method = "C3B5A6F3A12E32CB352921DD8911C7F3", hash_generated_method = "A7FEABCF51D818128ADEEC6E89E1371A")
    public E element() {
        E varB4EAC82CA7396A68D541C85D26508E83_1377055774 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1377055774 = getFirst();
        varB4EAC82CA7396A68D541C85D26508E83_1377055774.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1377055774;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.674 -0400", hash_original_method = "A003E27ECA2FE3193555598EEC98E09D", hash_generated_method = "8A4355EF375FC0E6E3CE5A71EBB45F78")
    public E peek() {
        E varB4EAC82CA7396A68D541C85D26508E83_837349204 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_837349204 = peekFirst();
        varB4EAC82CA7396A68D541C85D26508E83_837349204.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_837349204;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.674 -0400", hash_original_method = "848DD27BB905F5A807C52ED75E19F6C3", hash_generated_method = "72C186ED1744A0D2DEFAA4DDE67D7864")
    public void push(E e) {
        addFirst(e);
        addTaint(e.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.675 -0400", hash_original_method = "158DA4E81D3B40D802055686181E6101", hash_generated_method = "E2F8849354A8F2E9A72F5DFFFB5358CD")
    public E pop() {
        E varB4EAC82CA7396A68D541C85D26508E83_439686327 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_439686327 = removeFirst();
        varB4EAC82CA7396A68D541C85D26508E83_439686327.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_439686327;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.675 -0400", hash_original_method = "BBF79E0ADE5790277B99F1D7AA727B20", hash_generated_method = "1D9C6F57BCDE2C7294D7BB32ACA5DF67")
    private void checkInvariants() {
        
        
        
            
             
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.677 -0400", hash_original_method = "6B28B7CDDDC5837E98E272935A4DA74A", hash_generated_method = "04EBD2BEF739A0ED309A9D54879B1D1D")
    private boolean delete(int i) {
        checkInvariants();
        final E[] elements = this.elements;
        final int mask = elements.length - 1;
        final int h = head;
        final int t = tail;
        final int front = (i - h) & mask;
        final int back = (t - i) & mask;
        if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
        {
            {
                System.arraycopy(elements, h, elements, h + 1, front);
            } 
            {
                System.arraycopy(elements, 0, elements, 1, i);
                elements[0] = elements[mask];
                System.arraycopy(elements, h, elements, h + 1, mask - h);
            } 
            elements[h] = null;
            head = (h + 1) & mask;
        } 
        {
            {
                System.arraycopy(elements, i + 1, elements, i, back);
                tail = t - 1;
            } 
            {
                System.arraycopy(elements, i + 1, elements, i, mask - i);
                elements[mask] = elements[0];
                System.arraycopy(elements, 1, elements, 0, t);
                tail = (t - 1) & mask;
            } 
        } 
        addTaint(i);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_875494357 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_875494357;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.678 -0400", hash_original_method = "D58AA3C48B1B36CF35B203F4633D4120", hash_generated_method = "D0C56CBAA05FE6987DAC637DFC02AC22")
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1582857512 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1582857512;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.679 -0400", hash_original_method = "029A9450FF46747D2F1AB4761630FBFA", hash_generated_method = "FE85B2771955E6BF4B1C1AF67D7888D2")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1175858800 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1175858800;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.681 -0400", hash_original_method = "ECCE71EADB88CB0EFABEE24B7316B6D0", hash_generated_method = "117DF02821613A6E4B91E732D813706D")
    public Iterator<E> iterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_1366264826 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1366264826 = new DeqIterator();
        varB4EAC82CA7396A68D541C85D26508E83_1366264826.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1366264826;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.683 -0400", hash_original_method = "09A6B8B983928A3C88383EF59752C844", hash_generated_method = "3D9CAD2A016AADB81669FA3D58C4214D")
    public Iterator<E> descendingIterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_2114212678 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2114212678 = new DescendingIterator();
        varB4EAC82CA7396A68D541C85D26508E83_2114212678.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2114212678;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.684 -0400", hash_original_method = "76B0F415E6F814FE548D14BC6D5843EE", hash_generated_method = "FBA2F6729AD14349A2037D22E83AB358")
    public boolean contains(Object o) {
        int mask = elements.length - 1;
        int i = head;
        E x;
        {
            boolean var1329AA2C156BE9C813DA2AD363D45946_1784131312 = ((x = elements[i]) != null);
            {
                {
                    boolean var8C3257AD3EAB1DB4919EC2B6E1BD3609_1686839500 = (o.equals(x));
                } 
                i = (i + 1) & mask;
            } 
        } 
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_266919355 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_266919355;
        
        
            
        
        
        
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.685 -0400", hash_original_method = "953726349F424E37042C19BD0C0A52B8", hash_generated_method = "682CAAB71C8B949EBB05F04ED7654D5D")
    public boolean remove(Object o) {
        boolean varB3B6A07AEF87793955942F9770654762_1878474795 = (removeFirstOccurrence(o));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_308962354 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_308962354;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.687 -0400", hash_original_method = "AB065CB5BA1D923138DE6DFF9B806E2B", hash_generated_method = "1F80827C555E8A146AF8D534108BA8B9")
    public void clear() {
        int h = head;
        int t = tail;
        {
            head = tail = 0;
            int i = h;
            int mask = elements.length - 1;
            {
                elements[i] = null;
                i = (i + 1) & mask;
            } 
        } 
        
        
        
        
            
            
            
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.688 -0400", hash_original_method = "33D76C50C1E8C0374668B986897D9D9E", hash_generated_method = "5608A19260610F47A759F829D06EEBE0")
    public Object[] toArray() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_1448473145 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1448473145 = copyElements(new Object[size()]);
        varB4EAC82CA7396A68D541C85D26508E83_1448473145.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1448473145;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.689 -0400", hash_original_method = "38034B8DDDAB71FC35937F12D964AD07", hash_generated_method = "D321118CF7CF1E02D72A4B0DEAA0B25C")
    public <T> T[] toArray(T[] a) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_1641936842 = null; 
        int size = size();
        a = (T[])java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size);
        copyElements(a);
        a[size] = null;
        varB4EAC82CA7396A68D541C85D26508E83_1641936842 = a;
        addTaint(a[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1641936842.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1641936842;
        
        
        
            
                    
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.690 -0400", hash_original_method = "A2826FA19E4353225E0757D076E8282A", hash_generated_method = "263C512F14A63D1ABED2F5C280F0B93D")
    public ArrayDeque<E> clone() {
        ArrayDeque<E> varB4EAC82CA7396A68D541C85D26508E83_1061149038 = null; 
        try 
        {
            ArrayDeque<E> result = (ArrayDeque<E>) super.clone();
            result.elements = Arrays.copyOf(elements, elements.length);
            varB4EAC82CA7396A68D541C85D26508E83_1061149038 = result;
        } 
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1061149038.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1061149038;
        
        
            
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.691 -0400", hash_original_method = "5A84D35A2C5A040CC18139106D665D0E", hash_generated_method = "CB0801C72CB6255DDB2A0771B61C886B")
    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(size());
        int mask = elements.length - 1;
        {
            int i = head;
            i = (i + 1) & mask;
            s.writeObject(elements[i]);
        } 
        addTaint(s.getTaint());
        
        
        
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.691 -0400", hash_original_method = "ABF871D717FCC2D87CA02E500CE54CBF", hash_generated_method = "BA77B0323D252D4A684FD3FF1CB19441")
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        int size = s.readInt();
        allocateElements(size);
        head = 0;
        tail = size;
        {
            int i = 0;
            elements[i] = (E)s.readObject();
        } 
        
        
        
        
        
        
        
            
    }

    
    private class DeqIterator implements Iterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.691 -0400", hash_original_field = "A6C3E4B2DB56705F1E0449DB0F2C2FBA", hash_generated_field = "44DF51687F75FF9B360C641B654097EA")

        private int cursor = head;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.691 -0400", hash_original_field = "A59CA35B929091FBAF4213A76A4791DD", hash_generated_field = "CD264196D1FE9C34BAABF3EB22B1DEF4")

        private int fence = tail;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.691 -0400", hash_original_field = "05BB3FB56C1D06F12491BD981603A511", hash_generated_field = "C24010450EAB67B935A24ED5E0D44753")

        private int lastRet = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.691 -0400", hash_original_method = "8F728FEBD0A799A5BB08E38FDCDEB966", hash_generated_method = "8F728FEBD0A799A5BB08E38FDCDEB966")
        public DeqIterator ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.691 -0400", hash_original_method = "8D6FDA09A878582CCF6BFDDE96A3C673", hash_generated_method = "8DA842879753F5174A5E7B187466DF93")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_826252627 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_826252627;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.692 -0400", hash_original_method = "9CABF9BA27B0EE6B683FFA8F5EC2BB0E", hash_generated_method = "99DC45114471BF0552DF7EA75C343FDA")
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_1516979655 = null; 
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            E result = elements[cursor];
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            lastRet = cursor;
            cursor = (cursor + 1) & (elements.length - 1);
            varB4EAC82CA7396A68D541C85D26508E83_1516979655 = result;
            varB4EAC82CA7396A68D541C85D26508E83_1516979655.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1516979655;
            
            
                
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.692 -0400", hash_original_method = "A6EE424EC418974FAC2A0A9E736B0189", hash_generated_method = "A3D2DB0E5FBA07CEEEEC52724D970B29")
        public void remove() {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            {
                boolean varC9E761FAC14702C2B623BE027E2F7281_1761408376 = (delete(lastRet));
                {
                    cursor = (cursor - 1) & (elements.length - 1);
                    fence = tail;
                } 
            } 
            lastRet = -1;
            
            
                
            
                
                
            
            
        }

        
    }


    
    private class DescendingIterator implements Iterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.692 -0400", hash_original_field = "D7BB8B9FE9FDF2C1C79C88B1A34D38AF", hash_generated_field = "9C757AFC9A7098F996E37879537F5728")

        private int cursor = tail;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.693 -0400", hash_original_field = "EFD18F3C9098DD073CE26810B5D769B0", hash_generated_field = "EB9AC1D6784E298C35CBEF17C766890F")

        private int fence = head;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.693 -0400", hash_original_field = "05BB3FB56C1D06F12491BD981603A511", hash_generated_field = "C24010450EAB67B935A24ED5E0D44753")

        private int lastRet = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.693 -0400", hash_original_method = "EFD23C54297A65B9A603FACFE0E34AA6", hash_generated_method = "EFD23C54297A65B9A603FACFE0E34AA6")
        public DescendingIterator ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.693 -0400", hash_original_method = "8D6FDA09A878582CCF6BFDDE96A3C673", hash_generated_method = "DDF217922FF80566E0A2BBBFC785DE29")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_775818751 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_775818751;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.694 -0400", hash_original_method = "5248F2967157124DAD3A5B8F2BA1B9D6", hash_generated_method = "8FF3735F4190975C14705A0529074878")
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_968792576 = null; 
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            cursor = (cursor - 1) & (elements.length - 1);
            E result = elements[cursor];
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            lastRet = cursor;
            varB4EAC82CA7396A68D541C85D26508E83_968792576 = result;
            varB4EAC82CA7396A68D541C85D26508E83_968792576.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_968792576;
            
            
                
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.695 -0400", hash_original_method = "C558887990F4F262B85810625D57822A", hash_generated_method = "A46D9DF134909567688446EFAAF6FAD6")
        public void remove() {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            {
                boolean var3942AF7F654E16207FF88B33EBA55990_864576041 = (!delete(lastRet));
                {
                    cursor = (cursor + 1) & (elements.length - 1);
                    fence = head;
                } 
            } 
            lastRet = -1;
            
            
                
            
                
                
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.695 -0400", hash_original_field = "FA7CACCF7CB1913464940178A51F4202", hash_generated_field = "9C3B8B7AFE1FAFCE87E9784F2B7C8D5F")

    private static final int MIN_INITIAL_CAPACITY = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:00.695 -0400", hash_original_field = "CE1576C94D2F8F975B0823F778718192", hash_generated_field = "7C4DAA612FFE9A2D14BBB1700B6F7B63")

    private static final long serialVersionUID = 2340985798034038923L;
}

