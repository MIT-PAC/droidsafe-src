package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.*;

public class ArrayDeque<E> extends AbstractCollection<E> implements Deque<E>, Cloneable, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.725 -0400", hash_original_field = "6A7F245843454CF4F28AD7C5E2572AA2", hash_generated_field = "777D1E33E50D4CDEA795A5FBEBE9B75E")

    private transient E[] elements;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.726 -0400", hash_original_field = "96E89A298E0A9F469B9AE458D6AFAE9F", hash_generated_field = "C80FE6D9E9CF1E423738D59094B3A099")

    private transient int head;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.726 -0400", hash_original_field = "7AEA2552DFE7EB84B9443B6FC9BA6E01", hash_generated_field = "993ACFB1D5CE316FEA289C1E850AAC75")

    private transient int tail;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.726 -0400", hash_original_method = "8C7B174379DD3B2C843811B1130834BD", hash_generated_method = "151203C88A4AC41E68C2D3AED6B6A179")
    public  ArrayDeque() {
        elements = (E[]) new Object[16];
        // ---------- Original Method ----------
        //elements = (E[]) new Object[16];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.726 -0400", hash_original_method = "690593276EDD66C533F49BEE09E9C663", hash_generated_method = "158643740CD6A5825D055EBD586D1359")
    public  ArrayDeque(int numElements) {
        addTaint(numElements);
        allocateElements(numElements);
        // ---------- Original Method ----------
        //allocateElements(numElements);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.726 -0400", hash_original_method = "5E7B6C878951D7CA458070D073F03065", hash_generated_method = "BC9ADF117A4CF804C2DF42F6B0498A6D")
    public  ArrayDeque(Collection<? extends E> c) {
        addTaint(c.getTaint());
        allocateElements(c.size());
        addAll(c);
        // ---------- Original Method ----------
        //allocateElements(c.size());
        //addAll(c);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.728 -0400", hash_original_method = "86AF4C096D752C20A8CB0D886E79B7FB", hash_generated_method = "7880F76458629820F33A005C779B0222")
    private void allocateElements(int numElements) {
        addTaint(numElements);
        int initialCapacity = MIN_INITIAL_CAPACITY;
        if(numElements >= initialCapacity)        
        {
            initialCapacity = numElements;
            initialCapacity |= (initialCapacity >>>  1);
            initialCapacity |= (initialCapacity >>>  2);
            initialCapacity |= (initialCapacity >>>  4);
            initialCapacity |= (initialCapacity >>>  8);
            initialCapacity |= (initialCapacity >>> 16);
            initialCapacity++;
            if(initialCapacity < 0)            
            initialCapacity >>>= 1;
        } //End block
        elements = (E[]) new Object[initialCapacity];
        // ---------- Original Method ----------
        //int initialCapacity = MIN_INITIAL_CAPACITY;
        //if (numElements >= initialCapacity) {
            //initialCapacity = numElements;
            //initialCapacity |= (initialCapacity >>>  1);
            //initialCapacity |= (initialCapacity >>>  2);
            //initialCapacity |= (initialCapacity >>>  4);
            //initialCapacity |= (initialCapacity >>>  8);
            //initialCapacity |= (initialCapacity >>> 16);
            //initialCapacity++;
            //if (initialCapacity < 0)   
                //initialCapacity >>>= 1;
        //}
        //elements = (E[]) new Object[initialCapacity];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.728 -0400", hash_original_method = "35225802D7F18BE5673FDDFDE4B70B2E", hash_generated_method = "0A01FF0183A6B9E76A7B5CEE19A7D9B8")
    private void doubleCapacity() {
        int p = head;
        int n = elements.length;
        int r = n - p;
        int newCapacity = n << 1;
        if(newCapacity < 0)        
        {
        IllegalStateException varBACFC6F98A2905FEC7065F6EA8110323_346360423 = new IllegalStateException("Sorry, deque too big");
        varBACFC6F98A2905FEC7065F6EA8110323_346360423.addTaint(taint);
        throw varBACFC6F98A2905FEC7065F6EA8110323_346360423;
        }
        Object[] a = new Object[newCapacity];
        System.arraycopy(elements, p, a, 0, r);
        System.arraycopy(elements, 0, a, r, p);
        elements = (E[])a;
        head = 0;
        tail = n;
        // ---------- Original Method ----------
        //assert head == tail;
        //int p = head;
        //int n = elements.length;
        //int r = n - p;
        //int newCapacity = n << 1;
        //if (newCapacity < 0)
            //throw new IllegalStateException("Sorry, deque too big");
        //Object[] a = new Object[newCapacity];
        //System.arraycopy(elements, p, a, 0, r);
        //System.arraycopy(elements, 0, a, r, p);
        //elements = (E[])a;
        //head = 0;
        //tail = n;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.729 -0400", hash_original_method = "5E8669E32F5C4FDF3D4D82BA2C3949A2", hash_generated_method = "A27DAFB69608B631E191921E359A6DED")
    private <T> T[] copyElements(T[] a) {
        addTaint(a[0].getTaint());
        if(head < tail)        
        {
            System.arraycopy(elements, head, a, 0, size());
        } //End block
        else
        if(head > tail)        
        {
            int headPortionLen = elements.length - head;
            System.arraycopy(elements, head, a, 0, headPortionLen);
            System.arraycopy(elements, 0, a, headPortionLen, tail);
        } //End block
T[] var3F5343BF1D849954A73F0BB303805FFD_458471027 =         a;
        var3F5343BF1D849954A73F0BB303805FFD_458471027.addTaint(taint);
        return var3F5343BF1D849954A73F0BB303805FFD_458471027;
        // ---------- Original Method ----------
        //if (head < tail) {
            //System.arraycopy(elements, head, a, 0, size());
        //} else if (head > tail) {
            //int headPortionLen = elements.length - head;
            //System.arraycopy(elements, head, a, 0, headPortionLen);
            //System.arraycopy(elements, 0, a, headPortionLen, tail);
        //}
        //return a;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.730 -0400", hash_original_method = "CBAC64602FF2D7F893923E0ABA8C507E", hash_generated_method = "4EB3BC2DDD2EE9B46B68F4708F22550C")
    public void addFirst(E e) {
        if(e == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_49122253 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_49122253.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_49122253;
        }
        elements[head = (head - 1) & (elements.length - 1)] = e;
        if(head == tail)        
        doubleCapacity();
        // ---------- Original Method ----------
        //if (e == null)
            //throw new NullPointerException();
        //elements[head = (head - 1) & (elements.length - 1)] = e;
        //if (head == tail)
            //doubleCapacity();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.731 -0400", hash_original_method = "1B31DB8E2D035FB7799256F8004C4036", hash_generated_method = "0A5235C7AFE0CB0B03A14FADC8B2E955")
    public void addLast(E e) {
        if(e == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_967927525 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_967927525.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_967927525;
        }
        elements[tail] = e;
        if((tail = (tail + 1) & (elements.length - 1)) == head)        
        doubleCapacity();
        // ---------- Original Method ----------
        //if (e == null)
            //throw new NullPointerException();
        //elements[tail] = e;
        //if ( (tail = (tail + 1) & (elements.length - 1)) == head)
            //doubleCapacity();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.731 -0400", hash_original_method = "8D3228F5DEFAE0131B22F51707654BE0", hash_generated_method = "5E75FF8E4CA766061823BF6AC08FD2C4")
    public boolean offerFirst(E e) {
        addTaint(e.getTaint());
        addFirst(e);
        boolean varB326B5062B2F0E69046810717534CB09_1601080266 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1710028328 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1710028328;
        // ---------- Original Method ----------
        //addFirst(e);
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.732 -0400", hash_original_method = "15C090CE1A98280B8C8C7B6514A10013", hash_generated_method = "A8FD57B00AB2A1AA27D9747EF93FDB51")
    public boolean offerLast(E e) {
        addTaint(e.getTaint());
        addLast(e);
        boolean varB326B5062B2F0E69046810717534CB09_1997748932 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_93757537 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_93757537;
        // ---------- Original Method ----------
        //addLast(e);
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.732 -0400", hash_original_method = "8D1F2D8C9F4BF8EC3B65B975014CE8A7", hash_generated_method = "CDAA52422CAD9E08AADDBCEC33509664")
    public E removeFirst() {
        E x = pollFirst();
        if(x == null)        
        {
        NoSuchElementException var28D00AB599969908D71F102AF992D49A_886266804 = new NoSuchElementException();
        var28D00AB599969908D71F102AF992D49A_886266804.addTaint(taint);
        throw var28D00AB599969908D71F102AF992D49A_886266804;
        }
E varEA5659DA512DECF23E6D37EE8060D074_2025198964 =         x;
        varEA5659DA512DECF23E6D37EE8060D074_2025198964.addTaint(taint);
        return varEA5659DA512DECF23E6D37EE8060D074_2025198964;
        // ---------- Original Method ----------
        //E x = pollFirst();
        //if (x == null)
            //throw new NoSuchElementException();
        //return x;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.732 -0400", hash_original_method = "90A521D0942C6C4821F3F861C2808726", hash_generated_method = "0F6BBAECA2528F22631C957A201879DE")
    public E removeLast() {
        E x = pollLast();
        if(x == null)        
        {
        NoSuchElementException var28D00AB599969908D71F102AF992D49A_1855857546 = new NoSuchElementException();
        var28D00AB599969908D71F102AF992D49A_1855857546.addTaint(taint);
        throw var28D00AB599969908D71F102AF992D49A_1855857546;
        }
E varEA5659DA512DECF23E6D37EE8060D074_1790393804 =         x;
        varEA5659DA512DECF23E6D37EE8060D074_1790393804.addTaint(taint);
        return varEA5659DA512DECF23E6D37EE8060D074_1790393804;
        // ---------- Original Method ----------
        //E x = pollLast();
        //if (x == null)
            //throw new NoSuchElementException();
        //return x;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.733 -0400", hash_original_method = "70BCEEA789C7C02318BA6052E8B29D53", hash_generated_method = "9FE78BB158E1DF0F5E73E129D4AEA2C3")
    public E pollFirst() {
        int h = head;
        E result = elements[h];
        if(result == null)        
        {
E var540C13E9E156B687226421B24F2DF178_2145325675 =         null;
        var540C13E9E156B687226421B24F2DF178_2145325675.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2145325675;
        }
        elements[h] = null;
        head = (h + 1) & (elements.length - 1);
E varDC838461EE2FA0CA4C9BBB70A15456B0_493226968 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_493226968.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_493226968;
        // ---------- Original Method ----------
        //int h = head;
        //E result = elements[h];
        //if (result == null)
            //return null;
        //elements[h] = null;
        //head = (h + 1) & (elements.length - 1);
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.733 -0400", hash_original_method = "CC3133A0441CFBBC149D7C0D4094D190", hash_generated_method = "4C070CEECC46FCC9D29381D1DF816A5C")
    public E pollLast() {
        int t = (tail - 1) & (elements.length - 1);
        E result = elements[t];
        if(result == null)        
        {
E var540C13E9E156B687226421B24F2DF178_944141222 =         null;
        var540C13E9E156B687226421B24F2DF178_944141222.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_944141222;
        }
        elements[t] = null;
        tail = t;
E varDC838461EE2FA0CA4C9BBB70A15456B0_228412425 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_228412425.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_228412425;
        // ---------- Original Method ----------
        //int t = (tail - 1) & (elements.length - 1);
        //E result = elements[t];
        //if (result == null)
            //return null;
        //elements[t] = null;
        //tail = t;
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.733 -0400", hash_original_method = "969C370DEEB1254D835EA60A850D9474", hash_generated_method = "E5F112DF0F3AFE4C5DCC4980CA87FFDF")
    public E getFirst() {
        E x = elements[head];
        if(x == null)        
        {
        NoSuchElementException var28D00AB599969908D71F102AF992D49A_235420439 = new NoSuchElementException();
        var28D00AB599969908D71F102AF992D49A_235420439.addTaint(taint);
        throw var28D00AB599969908D71F102AF992D49A_235420439;
        }
E varEA5659DA512DECF23E6D37EE8060D074_1161861009 =         x;
        varEA5659DA512DECF23E6D37EE8060D074_1161861009.addTaint(taint);
        return varEA5659DA512DECF23E6D37EE8060D074_1161861009;
        // ---------- Original Method ----------
        //E x = elements[head];
        //if (x == null)
            //throw new NoSuchElementException();
        //return x;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.734 -0400", hash_original_method = "609D7D9752B1EA7B409577881D715ECB", hash_generated_method = "39EFE08E8B9B7EB5136659505321C2CE")
    public E getLast() {
        E x = elements[(tail - 1) & (elements.length - 1)];
        if(x == null)        
        {
        NoSuchElementException var28D00AB599969908D71F102AF992D49A_599771137 = new NoSuchElementException();
        var28D00AB599969908D71F102AF992D49A_599771137.addTaint(taint);
        throw var28D00AB599969908D71F102AF992D49A_599771137;
        }
E varEA5659DA512DECF23E6D37EE8060D074_1486773562 =         x;
        varEA5659DA512DECF23E6D37EE8060D074_1486773562.addTaint(taint);
        return varEA5659DA512DECF23E6D37EE8060D074_1486773562;
        // ---------- Original Method ----------
        //E x = elements[(tail - 1) & (elements.length - 1)];
        //if (x == null)
            //throw new NoSuchElementException();
        //return x;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.734 -0400", hash_original_method = "1112FC6950CD2F89C0F90F3FD6940182", hash_generated_method = "8EDAAECCBABF3CE511EE60CB0592A284")
    public E peekFirst() {
E var297F504D134443EA5FCC106634CF91BA_1865454275 =         elements[head];
        var297F504D134443EA5FCC106634CF91BA_1865454275.addTaint(taint);
        return var297F504D134443EA5FCC106634CF91BA_1865454275;
        // ---------- Original Method ----------
        //return elements[head];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.734 -0400", hash_original_method = "2FB93C1E4553786B68715ADDCB3204FE", hash_generated_method = "FA9DB123D239963177D82C8A8795DD35")
    public E peekLast() {
E varF0B2874D5567D866BA71F92F44C6276F_169328717 =         elements[(tail - 1) & (elements.length - 1)];
        varF0B2874D5567D866BA71F92F44C6276F_169328717.addTaint(taint);
        return varF0B2874D5567D866BA71F92F44C6276F_169328717;
        // ---------- Original Method ----------
        //return elements[(tail - 1) & (elements.length - 1)];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.735 -0400", hash_original_method = "2655E37A6129D552BDB18D712FBDBB78", hash_generated_method = "CC2763FF7F05BA1A006ADE717E43D8AD")
    public boolean removeFirstOccurrence(Object o) {
        addTaint(o.getTaint());
        if(o == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_485980950 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1164429647 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1164429647;
        }
        int mask = elements.length - 1;
        int i = head;
        E x;
        while
((x = elements[i]) != null)        
        {
            if(o.equals(x))            
            {
                delete(i);
                boolean varB326B5062B2F0E69046810717534CB09_1103446349 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1002527607 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1002527607;
            } //End block
            i = (i + 1) & mask;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_214452402 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_253027082 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_253027082;
        // ---------- Original Method ----------
        //if (o == null)
            //return false;
        //int mask = elements.length - 1;
        //int i = head;
        //E x;
        //while ( (x = elements[i]) != null) {
            //if (o.equals(x)) {
                //delete(i);
                //return true;
            //}
            //i = (i + 1) & mask;
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.735 -0400", hash_original_method = "67D061371E16CEF717EF2A58AA73F6CB", hash_generated_method = "1104EB4ADA5273FB526B26AD5B56B5BD")
    public boolean removeLastOccurrence(Object o) {
        addTaint(o.getTaint());
        if(o == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1145266827 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1448197973 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1448197973;
        }
        int mask = elements.length - 1;
        int i = (tail - 1) & mask;
        E x;
        while
((x = elements[i]) != null)        
        {
            if(o.equals(x))            
            {
                delete(i);
                boolean varB326B5062B2F0E69046810717534CB09_355473402 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_896724221 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_896724221;
            } //End block
            i = (i - 1) & mask;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1482212521 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1110051806 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1110051806;
        // ---------- Original Method ----------
        //if (o == null)
            //return false;
        //int mask = elements.length - 1;
        //int i = (tail - 1) & mask;
        //E x;
        //while ( (x = elements[i]) != null) {
            //if (o.equals(x)) {
                //delete(i);
                //return true;
            //}
            //i = (i - 1) & mask;
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.736 -0400", hash_original_method = "056B268263D9E7E4C2239F12D1024514", hash_generated_method = "C7BF1C147156C6CD40BC6C9CFA6C685E")
    public boolean add(E e) {
        addTaint(e.getTaint());
        addLast(e);
        boolean varB326B5062B2F0E69046810717534CB09_1732122601 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1602998163 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1602998163;
        // ---------- Original Method ----------
        //addLast(e);
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.736 -0400", hash_original_method = "90158A89D183AFC9420F99CD4C19A119", hash_generated_method = "78DBFCD9D2A0E938985373D283D2BB8C")
    public boolean offer(E e) {
        addTaint(e.getTaint());
        boolean varE4235613B1D945AEF4FDF4363C71A8BF_1394116965 = (offerLast(e));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_306968911 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_306968911;
        // ---------- Original Method ----------
        //return offerLast(e);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.736 -0400", hash_original_method = "5200E72EC4A7AF0A97DAC56CA915551B", hash_generated_method = "34D32B5A7DA132A4E59174BF8EA92257")
    public E remove() {
E var2157E264C867DE2EF0CC4E40F6B9582B_1599406212 =         removeFirst();
        var2157E264C867DE2EF0CC4E40F6B9582B_1599406212.addTaint(taint);
        return var2157E264C867DE2EF0CC4E40F6B9582B_1599406212;
        // ---------- Original Method ----------
        //return removeFirst();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.736 -0400", hash_original_method = "D6F4991F5239518842015971CA437CF0", hash_generated_method = "1AC4464D58E00AD7A245A50AF9AA0132")
    public E poll() {
E var268557EBF9358B7227A2055747F14D9D_776124257 =         pollFirst();
        var268557EBF9358B7227A2055747F14D9D_776124257.addTaint(taint);
        return var268557EBF9358B7227A2055747F14D9D_776124257;
        // ---------- Original Method ----------
        //return pollFirst();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.737 -0400", hash_original_method = "C3B5A6F3A12E32CB352921DD8911C7F3", hash_generated_method = "DE40E28F9822013F6D90BE6BCC1E222F")
    public E element() {
E var9C3B53F949FCC17872659181725745DF_1503358767 =         getFirst();
        var9C3B53F949FCC17872659181725745DF_1503358767.addTaint(taint);
        return var9C3B53F949FCC17872659181725745DF_1503358767;
        // ---------- Original Method ----------
        //return getFirst();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.737 -0400", hash_original_method = "A003E27ECA2FE3193555598EEC98E09D", hash_generated_method = "2808123366A8171A173ECAA90C620E8E")
    public E peek() {
E var217A98F40A2036F4314C54A2E490EB26_360867986 =         peekFirst();
        var217A98F40A2036F4314C54A2E490EB26_360867986.addTaint(taint);
        return var217A98F40A2036F4314C54A2E490EB26_360867986;
        // ---------- Original Method ----------
        //return peekFirst();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.737 -0400", hash_original_method = "848DD27BB905F5A807C52ED75E19F6C3", hash_generated_method = "A83DB173C00003D26BF7385B9CAA2489")
    public void push(E e) {
        addTaint(e.getTaint());
        addFirst(e);
        // ---------- Original Method ----------
        //addFirst(e);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.737 -0400", hash_original_method = "158DA4E81D3B40D802055686181E6101", hash_generated_method = "069983A52FE32EE40B0E635940E8DC8F")
    public E pop() {
E var2157E264C867DE2EF0CC4E40F6B9582B_2099015912 =         removeFirst();
        var2157E264C867DE2EF0CC4E40F6B9582B_2099015912.addTaint(taint);
        return var2157E264C867DE2EF0CC4E40F6B9582B_2099015912;
        // ---------- Original Method ----------
        //return removeFirst();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.738 -0400", hash_original_method = "BBF79E0ADE5790277B99F1D7AA727B20", hash_generated_method = "1D9C6F57BCDE2C7294D7BB32ACA5DF67")
    private void checkInvariants() {
        // ---------- Original Method ----------
        //assert elements[tail] == null;
        //assert head == tail ? elements[head] == null :
            //(elements[head] != null &&
             //elements[(tail - 1) & (elements.length - 1)] != null);
        //assert elements[(head - 1) & (elements.length - 1)] == null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.740 -0400", hash_original_method = "6B28B7CDDDC5837E98E272935A4DA74A", hash_generated_method = "18C9FAF10DB497F37E9739E298F6C96C")
    private boolean delete(int i) {
        addTaint(i);
        checkInvariants();
        final E[] elements = this.elements;
        final int mask = elements.length - 1;
        final int h = head;
        final int t = tail;
        final int front = (i - h) & mask;
        final int back = (t - i) & mask;
        if(front >= ((t - h) & mask))        
        {
        ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_1121120673 = new ConcurrentModificationException();
        var779BA6969BD29E5F2D0448781C543B65_1121120673.addTaint(taint);
        throw var779BA6969BD29E5F2D0448781C543B65_1121120673;
        }
        if(front < back)        
        {
            if(h <= i)            
            {
                System.arraycopy(elements, h, elements, h + 1, front);
            } //End block
            else
            {
                System.arraycopy(elements, 0, elements, 1, i);
                elements[0] = elements[mask];
                System.arraycopy(elements, h, elements, h + 1, mask - h);
            } //End block
            elements[h] = null;
            head = (h + 1) & mask;
            boolean var68934A3E9455FA72420237EB05902327_934507923 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1082372036 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1082372036;
        } //End block
        else
        {
            if(i < t)            
            {
                System.arraycopy(elements, i + 1, elements, i, back);
                tail = t - 1;
            } //End block
            else
            {
                System.arraycopy(elements, i + 1, elements, i, mask - i);
                elements[mask] = elements[0];
                System.arraycopy(elements, 1, elements, 0, t);
                tail = (t - 1) & mask;
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1167024817 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1522787911 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1522787911;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.740 -0400", hash_original_method = "D58AA3C48B1B36CF35B203F4633D4120", hash_generated_method = "8FA1F0A2EFEB8EFB97041730224AFDAB")
    public int size() {
        int var53753E05B8FB8484B39EF846CAB8CEDF_909135668 = ((tail - head) & (elements.length - 1));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1767933196 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1767933196;
        // ---------- Original Method ----------
        //return (tail - head) & (elements.length - 1);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.741 -0400", hash_original_method = "029A9450FF46747D2F1AB4761630FBFA", hash_generated_method = "C286893FD247CA2F9FAD5C39E8A29CFC")
    public boolean isEmpty() {
        boolean varB2DD0C25DFB38C2E9B584FF5E8E2A5EA_1550805129 = (head == tail);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2026229557 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2026229557;
        // ---------- Original Method ----------
        //return head == tail;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.741 -0400", hash_original_method = "ECCE71EADB88CB0EFABEE24B7316B6D0", hash_generated_method = "7E5EBF25AE1E21F971BEABC09FEC7E10")
    public Iterator<E> iterator() {
Iterator<E> varEE02B56C0952177FF7B9B6EF5EC917CC_1339572856 =         new DeqIterator();
        varEE02B56C0952177FF7B9B6EF5EC917CC_1339572856.addTaint(taint);
        return varEE02B56C0952177FF7B9B6EF5EC917CC_1339572856;
        // ---------- Original Method ----------
        //return new DeqIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.741 -0400", hash_original_method = "09A6B8B983928A3C88383EF59752C844", hash_generated_method = "1A3A1254C70A00D556D849A0B86928F3")
    public Iterator<E> descendingIterator() {
Iterator<E> var79122F73E4C010A8E7103B4CCD1BD3AA_1729431235 =         new DescendingIterator();
        var79122F73E4C010A8E7103B4CCD1BD3AA_1729431235.addTaint(taint);
        return var79122F73E4C010A8E7103B4CCD1BD3AA_1729431235;
        // ---------- Original Method ----------
        //return new DescendingIterator();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.742 -0400", hash_original_method = "76B0F415E6F814FE548D14BC6D5843EE", hash_generated_method = "7C214122290F9198517C293DB3350BF8")
    public boolean contains(Object o) {
        addTaint(o.getTaint());
        if(o == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_519146685 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_515943160 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_515943160;
        }
        int mask = elements.length - 1;
        int i = head;
        E x;
        while
((x = elements[i]) != null)        
        {
            if(o.equals(x))            
            {
            boolean varB326B5062B2F0E69046810717534CB09_803772782 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1294322812 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1294322812;
            }
            i = (i + 1) & mask;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_415352692 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1681932184 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1681932184;
        // ---------- Original Method ----------
        //if (o == null)
            //return false;
        //int mask = elements.length - 1;
        //int i = head;
        //E x;
        //while ( (x = elements[i]) != null) {
            //if (o.equals(x))
                //return true;
            //i = (i + 1) & mask;
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.742 -0400", hash_original_method = "953726349F424E37042C19BD0C0A52B8", hash_generated_method = "84479F9FAC29EA387237F70246EA4623")
    public boolean remove(Object o) {
        addTaint(o.getTaint());
        boolean var6E37986A993A2A916076A1C4367014FB_1956273794 = (removeFirstOccurrence(o));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_79566554 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_79566554;
        // ---------- Original Method ----------
        //return removeFirstOccurrence(o);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.743 -0400", hash_original_method = "AB065CB5BA1D923138DE6DFF9B806E2B", hash_generated_method = "3BCD3849948858A40A885C9B955FBE53")
    public void clear() {
        int h = head;
        int t = tail;
        if(h != t)        
        {
            head = tail = 0;
            int i = h;
            int mask = elements.length - 1;
            do {
                {
                    elements[i] = null;
                    i = (i + 1) & mask;
                } //End block
} while (i != t);
        } //End block
        // ---------- Original Method ----------
        //int h = head;
        //int t = tail;
        //if (h != t) { 
            //head = tail = 0;
            //int i = h;
            //int mask = elements.length - 1;
            //do {
                //elements[i] = null;
                //i = (i + 1) & mask;
            //} while (i != t);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.744 -0400", hash_original_method = "33D76C50C1E8C0374668B986897D9D9E", hash_generated_method = "CF824BB32BEAC25BB2DE3631ADB9F13E")
    public Object[] toArray() {
Object[] var6FD0027538EDD1DC845C98DBD6A35104_1400577027 =         copyElements(new Object[size()]);
        var6FD0027538EDD1DC845C98DBD6A35104_1400577027.addTaint(taint);
        return var6FD0027538EDD1DC845C98DBD6A35104_1400577027;
        // ---------- Original Method ----------
        //return copyElements(new Object[size()]);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.744 -0400", hash_original_method = "38034B8DDDAB71FC35937F12D964AD07", hash_generated_method = "06E5913149E402B6AB4BF8BCBD73C8FC")
    public <T> T[] toArray(T[] a) {
        addTaint(a[0].getTaint());
        int size = size();
        if(a.length < size)        
        a = (T[])java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size);
        copyElements(a);
        if(a.length > size)        
        a[size] = null;
T[] var3F5343BF1D849954A73F0BB303805FFD_87702147 =         a;
        var3F5343BF1D849954A73F0BB303805FFD_87702147.addTaint(taint);
        return var3F5343BF1D849954A73F0BB303805FFD_87702147;
        // ---------- Original Method ----------
        //int size = size();
        //if (a.length < size)
            //a = (T[])java.lang.reflect.Array.newInstance(
                    //a.getClass().getComponentType(), size);
        //copyElements(a);
        //if (a.length > size)
            //a[size] = null;
        //return a;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.745 -0400", hash_original_method = "A2826FA19E4353225E0757D076E8282A", hash_generated_method = "C277AE12AC822A5E88C8604301CDD69D")
    public ArrayDeque<E> clone() {
        try 
        {
            ArrayDeque<E> result = (ArrayDeque<E>) super.clone();
            result.elements = Arrays.copyOf(elements, elements.length);
ArrayDeque<E> varDC838461EE2FA0CA4C9BBB70A15456B0_1268751069 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1268751069.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1268751069;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA81442E36297E737EB908877E58260E8_583128848 = new AssertionError();
            varA81442E36297E737EB908877E58260E8_583128848.addTaint(taint);
            throw varA81442E36297E737EB908877E58260E8_583128848;
        } //End block
        // ---------- Original Method ----------
        //try {
            //ArrayDeque<E> result = (ArrayDeque<E>) super.clone();
            //result.elements = Arrays.copyOf(elements, elements.length);
            //return result;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.747 -0400", hash_original_method = "5A84D35A2C5A040CC18139106D665D0E", hash_generated_method = "93EB7642BA8BB24E3533817E9BA3E16B")
    private void writeObject(ObjectOutputStream s) throws IOException {
        addTaint(s.getTaint());
        s.defaultWriteObject();
        s.writeInt(size());
        int mask = elements.length - 1;
for(int i = head;i != tail;i = (i + 1) & mask)
        s.writeObject(elements[i]);
        // ---------- Original Method ----------
        //s.defaultWriteObject();
        //s.writeInt(size());
        //int mask = elements.length - 1;
        //for (int i = head; i != tail; i = (i + 1) & mask)
            //s.writeObject(elements[i]);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.748 -0400", hash_original_method = "ABF871D717FCC2D87CA02E500CE54CBF", hash_generated_method = "247F5C6B322A797807EB5831518B08F7")
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        int size = s.readInt();
        allocateElements(size);
        head = 0;
        tail = size;
for(int i = 0;i < size;i++)
        elements[i] = (E)s.readObject();
        // ---------- Original Method ----------
        //s.defaultReadObject();
        //int size = s.readInt();
        //allocateElements(size);
        //head = 0;
        //tail = size;
        //for (int i = 0; i < size; i++)
            //elements[i] = (E)s.readObject();
    }

    
    private class DeqIterator implements Iterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.748 -0400", hash_original_field = "A6C3E4B2DB56705F1E0449DB0F2C2FBA", hash_generated_field = "44DF51687F75FF9B360C641B654097EA")

        private int cursor = head;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.748 -0400", hash_original_field = "A59CA35B929091FBAF4213A76A4791DD", hash_generated_field = "CD264196D1FE9C34BAABF3EB22B1DEF4")

        private int fence = tail;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.749 -0400", hash_original_field = "05BB3FB56C1D06F12491BD981603A511", hash_generated_field = "C24010450EAB67B935A24ED5E0D44753")

        private int lastRet = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.749 -0400", hash_original_method = "8F728FEBD0A799A5BB08E38FDCDEB966", hash_generated_method = "8F728FEBD0A799A5BB08E38FDCDEB966")
        public DeqIterator ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.749 -0400", hash_original_method = "8D6FDA09A878582CCF6BFDDE96A3C673", hash_generated_method = "3B7596CD28B41EBB5FFAFA1E034ADCBE")
        public boolean hasNext() {
            boolean varBB2FFB801149738DC5BBBE92D097852F_1787299883 = (cursor != fence);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1737109548 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1737109548;
            // ---------- Original Method ----------
            //return cursor != fence;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.750 -0400", hash_original_method = "9CABF9BA27B0EE6B683FFA8F5EC2BB0E", hash_generated_method = "250D2E9B3914C8B869CA2E07D8F16E85")
        public E next() {
            if(cursor == fence)            
            {
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_826809091 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_826809091.addTaint(taint);
            throw var28D00AB599969908D71F102AF992D49A_826809091;
            }
            E result = elements[cursor];
            if(tail != fence || result == null)            
            {
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_2116302770 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_2116302770.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_2116302770;
            }
            lastRet = cursor;
            cursor = (cursor + 1) & (elements.length - 1);
E varDC838461EE2FA0CA4C9BBB70A15456B0_514598320 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_514598320.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_514598320;
            // ---------- Original Method ----------
            //if (cursor == fence)
                //throw new NoSuchElementException();
            //E result = elements[cursor];
            //if (tail != fence || result == null)
                //throw new ConcurrentModificationException();
            //lastRet = cursor;
            //cursor = (cursor + 1) & (elements.length - 1);
            //return result;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.750 -0400", hash_original_method = "A6EE424EC418974FAC2A0A9E736B0189", hash_generated_method = "25D718AC8A8E01A153473C3E3CEFBE48")
        public void remove() {
            if(lastRet < 0)            
            {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1491351107 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1491351107.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1491351107;
            }
            if(delete(lastRet))            
            {
                cursor = (cursor - 1) & (elements.length - 1);
                fence = tail;
            } //End block
            lastRet = -1;
            // ---------- Original Method ----------
            //if (lastRet < 0)
                //throw new IllegalStateException();
            //if (delete(lastRet)) { 
                //cursor = (cursor - 1) & (elements.length - 1);
                //fence = tail;
            //}
            //lastRet = -1;
        }

        
    }


    
    private class DescendingIterator implements Iterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.750 -0400", hash_original_field = "D7BB8B9FE9FDF2C1C79C88B1A34D38AF", hash_generated_field = "9C757AFC9A7098F996E37879537F5728")

        private int cursor = tail;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.751 -0400", hash_original_field = "EFD18F3C9098DD073CE26810B5D769B0", hash_generated_field = "EB9AC1D6784E298C35CBEF17C766890F")

        private int fence = head;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.751 -0400", hash_original_field = "05BB3FB56C1D06F12491BD981603A511", hash_generated_field = "C24010450EAB67B935A24ED5E0D44753")

        private int lastRet = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.751 -0400", hash_original_method = "EFD23C54297A65B9A603FACFE0E34AA6", hash_generated_method = "EFD23C54297A65B9A603FACFE0E34AA6")
        public DescendingIterator ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.751 -0400", hash_original_method = "8D6FDA09A878582CCF6BFDDE96A3C673", hash_generated_method = "EA79BB4D708C25EA4B4BD4C58664009F")
        public boolean hasNext() {
            boolean varBB2FFB801149738DC5BBBE92D097852F_1993605188 = (cursor != fence);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1675373593 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1675373593;
            // ---------- Original Method ----------
            //return cursor != fence;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.751 -0400", hash_original_method = "5248F2967157124DAD3A5B8F2BA1B9D6", hash_generated_method = "140CA19736CCD683FBDFEEB246D73013")
        public E next() {
            if(cursor == fence)            
            {
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_2011776464 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_2011776464.addTaint(taint);
            throw var28D00AB599969908D71F102AF992D49A_2011776464;
            }
            cursor = (cursor - 1) & (elements.length - 1);
            E result = elements[cursor];
            if(head != fence || result == null)            
            {
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_1596012345 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_1596012345.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_1596012345;
            }
            lastRet = cursor;
E varDC838461EE2FA0CA4C9BBB70A15456B0_509801580 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_509801580.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_509801580;
            // ---------- Original Method ----------
            //if (cursor == fence)
                //throw new NoSuchElementException();
            //cursor = (cursor - 1) & (elements.length - 1);
            //E result = elements[cursor];
            //if (head != fence || result == null)
                //throw new ConcurrentModificationException();
            //lastRet = cursor;
            //return result;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.752 -0400", hash_original_method = "C558887990F4F262B85810625D57822A", hash_generated_method = "4A8E4374D0369F963AAEB60A23853F37")
        public void remove() {
            if(lastRet < 0)            
            {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_362995051 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_362995051.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_362995051;
            }
            if(!delete(lastRet))            
            {
                cursor = (cursor + 1) & (elements.length - 1);
                fence = head;
            } //End block
            lastRet = -1;
            // ---------- Original Method ----------
            //if (lastRet < 0)
                //throw new IllegalStateException();
            //if (!delete(lastRet)) {
                //cursor = (cursor + 1) & (elements.length - 1);
                //fence = head;
            //}
            //lastRet = -1;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.752 -0400", hash_original_field = "FA7CACCF7CB1913464940178A51F4202", hash_generated_field = "9C3B8B7AFE1FAFCE87E9784F2B7C8D5F")

    private static final int MIN_INITIAL_CAPACITY = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.752 -0400", hash_original_field = "CE1576C94D2F8F975B0823F778718192", hash_generated_field = "7C4DAA612FFE9A2D14BBB1700B6F7B63")

    private static final long serialVersionUID = 2340985798034038923L;
}

