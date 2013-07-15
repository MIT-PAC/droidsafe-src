package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.*;

public class ArrayDeque<E> extends AbstractCollection<E> implements Deque<E>, Cloneable, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.296 -0400", hash_original_field = "6A7F245843454CF4F28AD7C5E2572AA2", hash_generated_field = "777D1E33E50D4CDEA795A5FBEBE9B75E")

    private transient E[] elements;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.296 -0400", hash_original_field = "96E89A298E0A9F469B9AE458D6AFAE9F", hash_generated_field = "C80FE6D9E9CF1E423738D59094B3A099")

    private transient int head;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.296 -0400", hash_original_field = "7AEA2552DFE7EB84B9443B6FC9BA6E01", hash_generated_field = "993ACFB1D5CE316FEA289C1E850AAC75")

    private transient int tail;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.296 -0400", hash_original_method = "8C7B174379DD3B2C843811B1130834BD", hash_generated_method = "151203C88A4AC41E68C2D3AED6B6A179")
    public  ArrayDeque() {
        elements = (E[]) new Object[16];
        // ---------- Original Method ----------
        //elements = (E[]) new Object[16];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.296 -0400", hash_original_method = "690593276EDD66C533F49BEE09E9C663", hash_generated_method = "158643740CD6A5825D055EBD586D1359")
    public  ArrayDeque(int numElements) {
        addTaint(numElements);
        allocateElements(numElements);
        // ---------- Original Method ----------
        //allocateElements(numElements);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.297 -0400", hash_original_method = "5E7B6C878951D7CA458070D073F03065", hash_generated_method = "BC9ADF117A4CF804C2DF42F6B0498A6D")
    public  ArrayDeque(Collection<? extends E> c) {
        addTaint(c.getTaint());
        allocateElements(c.size());
        addAll(c);
        // ---------- Original Method ----------
        //allocateElements(c.size());
        //addAll(c);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.298 -0400", hash_original_method = "86AF4C096D752C20A8CB0D886E79B7FB", hash_generated_method = "7880F76458629820F33A005C779B0222")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.300 -0400", hash_original_method = "35225802D7F18BE5673FDDFDE4B70B2E", hash_generated_method = "E4219F5A662CDA7DF3953A3D54FFFB1D")
    private void doubleCapacity() {
        int p = head;
        int n = elements.length;
        int r = n - p;
        int newCapacity = n << 1;
    if(newCapacity < 0)        
        {
        IllegalStateException varBACFC6F98A2905FEC7065F6EA8110323_1211616024 = new IllegalStateException("Sorry, deque too big");
        varBACFC6F98A2905FEC7065F6EA8110323_1211616024.addTaint(taint);
        throw varBACFC6F98A2905FEC7065F6EA8110323_1211616024;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.301 -0400", hash_original_method = "5E8669E32F5C4FDF3D4D82BA2C3949A2", hash_generated_method = "A5A440AE01B577034729B3CE3D9684BB")
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
T[] var3F5343BF1D849954A73F0BB303805FFD_1355809722 =         a;
        var3F5343BF1D849954A73F0BB303805FFD_1355809722.addTaint(taint);
        return var3F5343BF1D849954A73F0BB303805FFD_1355809722;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.302 -0400", hash_original_method = "CBAC64602FF2D7F893923E0ABA8C507E", hash_generated_method = "444A086386B38438D7A36380E6285414")
    public void addFirst(E e) {
    if(e == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_21196026 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_21196026.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_21196026;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.302 -0400", hash_original_method = "1B31DB8E2D035FB7799256F8004C4036", hash_generated_method = "4077DCE74B0C6E4B25E991A177A89F6F")
    public void addLast(E e) {
    if(e == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_2093006604 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_2093006604.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_2093006604;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.303 -0400", hash_original_method = "8D3228F5DEFAE0131B22F51707654BE0", hash_generated_method = "1B65E76EFDD14CBBEDBA56E42034A983")
    public boolean offerFirst(E e) {
        addTaint(e.getTaint());
        addFirst(e);
        boolean varB326B5062B2F0E69046810717534CB09_1224718487 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_20518279 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_20518279;
        // ---------- Original Method ----------
        //addFirst(e);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.303 -0400", hash_original_method = "15C090CE1A98280B8C8C7B6514A10013", hash_generated_method = "58FE27F234EDF61792E65F0C020901C0")
    public boolean offerLast(E e) {
        addTaint(e.getTaint());
        addLast(e);
        boolean varB326B5062B2F0E69046810717534CB09_517003688 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_195296799 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_195296799;
        // ---------- Original Method ----------
        //addLast(e);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.303 -0400", hash_original_method = "8D1F2D8C9F4BF8EC3B65B975014CE8A7", hash_generated_method = "198B9E02D2C25BB6C68391093D267E96")
    public E removeFirst() {
        E x = pollFirst();
    if(x == null)        
        {
        NoSuchElementException var28D00AB599969908D71F102AF992D49A_2111357081 = new NoSuchElementException();
        var28D00AB599969908D71F102AF992D49A_2111357081.addTaint(taint);
        throw var28D00AB599969908D71F102AF992D49A_2111357081;
        }
E varEA5659DA512DECF23E6D37EE8060D074_1479077215 =         x;
        varEA5659DA512DECF23E6D37EE8060D074_1479077215.addTaint(taint);
        return varEA5659DA512DECF23E6D37EE8060D074_1479077215;
        // ---------- Original Method ----------
        //E x = pollFirst();
        //if (x == null)
            //throw new NoSuchElementException();
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.303 -0400", hash_original_method = "90A521D0942C6C4821F3F861C2808726", hash_generated_method = "333C9798A804F962F557D48F8C489786")
    public E removeLast() {
        E x = pollLast();
    if(x == null)        
        {
        NoSuchElementException var28D00AB599969908D71F102AF992D49A_179140049 = new NoSuchElementException();
        var28D00AB599969908D71F102AF992D49A_179140049.addTaint(taint);
        throw var28D00AB599969908D71F102AF992D49A_179140049;
        }
E varEA5659DA512DECF23E6D37EE8060D074_1780918085 =         x;
        varEA5659DA512DECF23E6D37EE8060D074_1780918085.addTaint(taint);
        return varEA5659DA512DECF23E6D37EE8060D074_1780918085;
        // ---------- Original Method ----------
        //E x = pollLast();
        //if (x == null)
            //throw new NoSuchElementException();
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.304 -0400", hash_original_method = "70BCEEA789C7C02318BA6052E8B29D53", hash_generated_method = "71ADD1C57CF6C277A556807463B56729")
    public E pollFirst() {
        int h = head;
        E result = elements[h];
    if(result == null)        
        {
E var540C13E9E156B687226421B24F2DF178_1000308713 =         null;
        var540C13E9E156B687226421B24F2DF178_1000308713.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1000308713;
        }
        elements[h] = null;
        head = (h + 1) & (elements.length - 1);
E varDC838461EE2FA0CA4C9BBB70A15456B0_1312680936 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1312680936.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1312680936;
        // ---------- Original Method ----------
        //int h = head;
        //E result = elements[h];
        //if (result == null)
            //return null;
        //elements[h] = null;
        //head = (h + 1) & (elements.length - 1);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.304 -0400", hash_original_method = "CC3133A0441CFBBC149D7C0D4094D190", hash_generated_method = "1FD544E3BFC76F192692412082E513A3")
    public E pollLast() {
        int t = (tail - 1) & (elements.length - 1);
        E result = elements[t];
    if(result == null)        
        {
E var540C13E9E156B687226421B24F2DF178_102130178 =         null;
        var540C13E9E156B687226421B24F2DF178_102130178.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_102130178;
        }
        elements[t] = null;
        tail = t;
E varDC838461EE2FA0CA4C9BBB70A15456B0_1544972162 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1544972162.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1544972162;
        // ---------- Original Method ----------
        //int t = (tail - 1) & (elements.length - 1);
        //E result = elements[t];
        //if (result == null)
            //return null;
        //elements[t] = null;
        //tail = t;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.304 -0400", hash_original_method = "969C370DEEB1254D835EA60A850D9474", hash_generated_method = "F0C128916784662C06CCE5F3A2B87FBE")
    public E getFirst() {
        E x = elements[head];
    if(x == null)        
        {
        NoSuchElementException var28D00AB599969908D71F102AF992D49A_1228207408 = new NoSuchElementException();
        var28D00AB599969908D71F102AF992D49A_1228207408.addTaint(taint);
        throw var28D00AB599969908D71F102AF992D49A_1228207408;
        }
E varEA5659DA512DECF23E6D37EE8060D074_209807203 =         x;
        varEA5659DA512DECF23E6D37EE8060D074_209807203.addTaint(taint);
        return varEA5659DA512DECF23E6D37EE8060D074_209807203;
        // ---------- Original Method ----------
        //E x = elements[head];
        //if (x == null)
            //throw new NoSuchElementException();
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.305 -0400", hash_original_method = "609D7D9752B1EA7B409577881D715ECB", hash_generated_method = "120A2AF920BEB8D554005454BBEFE985")
    public E getLast() {
        E x = elements[(tail - 1) & (elements.length - 1)];
    if(x == null)        
        {
        NoSuchElementException var28D00AB599969908D71F102AF992D49A_1049337522 = new NoSuchElementException();
        var28D00AB599969908D71F102AF992D49A_1049337522.addTaint(taint);
        throw var28D00AB599969908D71F102AF992D49A_1049337522;
        }
E varEA5659DA512DECF23E6D37EE8060D074_572768200 =         x;
        varEA5659DA512DECF23E6D37EE8060D074_572768200.addTaint(taint);
        return varEA5659DA512DECF23E6D37EE8060D074_572768200;
        // ---------- Original Method ----------
        //E x = elements[(tail - 1) & (elements.length - 1)];
        //if (x == null)
            //throw new NoSuchElementException();
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.305 -0400", hash_original_method = "1112FC6950CD2F89C0F90F3FD6940182", hash_generated_method = "D06A5F96A2D1B428C165198FD475850F")
    public E peekFirst() {
E var297F504D134443EA5FCC106634CF91BA_750801766 =         elements[head];
        var297F504D134443EA5FCC106634CF91BA_750801766.addTaint(taint);
        return var297F504D134443EA5FCC106634CF91BA_750801766;
        // ---------- Original Method ----------
        //return elements[head];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.305 -0400", hash_original_method = "2FB93C1E4553786B68715ADDCB3204FE", hash_generated_method = "9694423DD69BA47F7A06948A8954DC64")
    public E peekLast() {
E varF0B2874D5567D866BA71F92F44C6276F_656722780 =         elements[(tail - 1) & (elements.length - 1)];
        varF0B2874D5567D866BA71F92F44C6276F_656722780.addTaint(taint);
        return varF0B2874D5567D866BA71F92F44C6276F_656722780;
        // ---------- Original Method ----------
        //return elements[(tail - 1) & (elements.length - 1)];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.306 -0400", hash_original_method = "2655E37A6129D552BDB18D712FBDBB78", hash_generated_method = "4CA33911EB983BAD4AC0D2149A8C8D4C")
    public boolean removeFirstOccurrence(Object o) {
        addTaint(o.getTaint());
    if(o == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1981646517 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_7690270 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_7690270;
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
                boolean varB326B5062B2F0E69046810717534CB09_1285166608 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_354638252 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_354638252;
            } //End block
            i = (i + 1) & mask;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_2115816786 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_691061835 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_691061835;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.306 -0400", hash_original_method = "67D061371E16CEF717EF2A58AA73F6CB", hash_generated_method = "96592FC28524D7AC28BAD8470F219F45")
    public boolean removeLastOccurrence(Object o) {
        addTaint(o.getTaint());
    if(o == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_23705943 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1328953705 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1328953705;
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
                boolean varB326B5062B2F0E69046810717534CB09_360417096 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_96372536 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_96372536;
            } //End block
            i = (i - 1) & mask;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_838986932 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1245300552 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1245300552;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.306 -0400", hash_original_method = "056B268263D9E7E4C2239F12D1024514", hash_generated_method = "6DEC8C56F854E0CCE4FDE894CC7BBBE3")
    public boolean add(E e) {
        addTaint(e.getTaint());
        addLast(e);
        boolean varB326B5062B2F0E69046810717534CB09_886787946 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_692006905 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_692006905;
        // ---------- Original Method ----------
        //addLast(e);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.307 -0400", hash_original_method = "90158A89D183AFC9420F99CD4C19A119", hash_generated_method = "F6030228063FE78B1CA8DCAB435BF5A5")
    public boolean offer(E e) {
        addTaint(e.getTaint());
        boolean varE4235613B1D945AEF4FDF4363C71A8BF_1330762748 = (offerLast(e));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1879092226 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1879092226;
        // ---------- Original Method ----------
        //return offerLast(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.307 -0400", hash_original_method = "5200E72EC4A7AF0A97DAC56CA915551B", hash_generated_method = "BEC625ECDA49F435EFE6C7148D2FC643")
    public E remove() {
E var2157E264C867DE2EF0CC4E40F6B9582B_1276253779 =         removeFirst();
        var2157E264C867DE2EF0CC4E40F6B9582B_1276253779.addTaint(taint);
        return var2157E264C867DE2EF0CC4E40F6B9582B_1276253779;
        // ---------- Original Method ----------
        //return removeFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.307 -0400", hash_original_method = "D6F4991F5239518842015971CA437CF0", hash_generated_method = "5917746E98D05FF310FFE5D13EC62728")
    public E poll() {
E var268557EBF9358B7227A2055747F14D9D_125865923 =         pollFirst();
        var268557EBF9358B7227A2055747F14D9D_125865923.addTaint(taint);
        return var268557EBF9358B7227A2055747F14D9D_125865923;
        // ---------- Original Method ----------
        //return pollFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.307 -0400", hash_original_method = "C3B5A6F3A12E32CB352921DD8911C7F3", hash_generated_method = "969636142B049D0299D620C9E3BB714A")
    public E element() {
E var9C3B53F949FCC17872659181725745DF_124020136 =         getFirst();
        var9C3B53F949FCC17872659181725745DF_124020136.addTaint(taint);
        return var9C3B53F949FCC17872659181725745DF_124020136;
        // ---------- Original Method ----------
        //return getFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.307 -0400", hash_original_method = "A003E27ECA2FE3193555598EEC98E09D", hash_generated_method = "34118DC5E37282860BFF3277EDF88E1E")
    public E peek() {
E var217A98F40A2036F4314C54A2E490EB26_964362583 =         peekFirst();
        var217A98F40A2036F4314C54A2E490EB26_964362583.addTaint(taint);
        return var217A98F40A2036F4314C54A2E490EB26_964362583;
        // ---------- Original Method ----------
        //return peekFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.308 -0400", hash_original_method = "848DD27BB905F5A807C52ED75E19F6C3", hash_generated_method = "A83DB173C00003D26BF7385B9CAA2489")
    public void push(E e) {
        addTaint(e.getTaint());
        addFirst(e);
        // ---------- Original Method ----------
        //addFirst(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.308 -0400", hash_original_method = "158DA4E81D3B40D802055686181E6101", hash_generated_method = "E27590B9DB88202E5DA35A248DB232A8")
    public E pop() {
E var2157E264C867DE2EF0CC4E40F6B9582B_700236210 =         removeFirst();
        var2157E264C867DE2EF0CC4E40F6B9582B_700236210.addTaint(taint);
        return var2157E264C867DE2EF0CC4E40F6B9582B_700236210;
        // ---------- Original Method ----------
        //return removeFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.308 -0400", hash_original_method = "BBF79E0ADE5790277B99F1D7AA727B20", hash_generated_method = "1D9C6F57BCDE2C7294D7BB32ACA5DF67")
    private void checkInvariants() {
        // ---------- Original Method ----------
        //assert elements[tail] == null;
        //assert head == tail ? elements[head] == null :
            //(elements[head] != null &&
             //elements[(tail - 1) & (elements.length - 1)] != null);
        //assert elements[(head - 1) & (elements.length - 1)] == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.309 -0400", hash_original_method = "6B28B7CDDDC5837E98E272935A4DA74A", hash_generated_method = "687DD7CBA6DEC3A1EE5BFD52B31E6E12")
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
        ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_1642436099 = new ConcurrentModificationException();
        var779BA6969BD29E5F2D0448781C543B65_1642436099.addTaint(taint);
        throw var779BA6969BD29E5F2D0448781C543B65_1642436099;
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
            boolean var68934A3E9455FA72420237EB05902327_646068009 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1378178296 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1378178296;
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
            boolean varB326B5062B2F0E69046810717534CB09_1262724157 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2068617956 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2068617956;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.310 -0400", hash_original_method = "D58AA3C48B1B36CF35B203F4633D4120", hash_generated_method = "E0EDD6CA4D052B0929AC0E990AAB3BAC")
    public int size() {
        int var53753E05B8FB8484B39EF846CAB8CEDF_1201820863 = ((tail - head) & (elements.length - 1));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1023654853 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1023654853;
        // ---------- Original Method ----------
        //return (tail - head) & (elements.length - 1);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.310 -0400", hash_original_method = "029A9450FF46747D2F1AB4761630FBFA", hash_generated_method = "BC30E759B0D249D83F0AAA32E564B760")
    public boolean isEmpty() {
        boolean varB2DD0C25DFB38C2E9B584FF5E8E2A5EA_193647773 = (head == tail);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1097501797 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1097501797;
        // ---------- Original Method ----------
        //return head == tail;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.310 -0400", hash_original_method = "ECCE71EADB88CB0EFABEE24B7316B6D0", hash_generated_method = "E9D31CBF2C9E645609F0EEC614592798")
    public Iterator<E> iterator() {
Iterator<E> varEE02B56C0952177FF7B9B6EF5EC917CC_952980723 =         new DeqIterator();
        varEE02B56C0952177FF7B9B6EF5EC917CC_952980723.addTaint(taint);
        return varEE02B56C0952177FF7B9B6EF5EC917CC_952980723;
        // ---------- Original Method ----------
        //return new DeqIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.310 -0400", hash_original_method = "09A6B8B983928A3C88383EF59752C844", hash_generated_method = "2B1269F4345E8181DE690FCAED86E0CA")
    public Iterator<E> descendingIterator() {
Iterator<E> var79122F73E4C010A8E7103B4CCD1BD3AA_1630821938 =         new DescendingIterator();
        var79122F73E4C010A8E7103B4CCD1BD3AA_1630821938.addTaint(taint);
        return var79122F73E4C010A8E7103B4CCD1BD3AA_1630821938;
        // ---------- Original Method ----------
        //return new DescendingIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.311 -0400", hash_original_method = "76B0F415E6F814FE548D14BC6D5843EE", hash_generated_method = "E038C062F25BB7D737F7DD2A989AAD0D")
    public boolean contains(Object o) {
        addTaint(o.getTaint());
    if(o == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1478146860 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_575255234 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_575255234;
        }
        int mask = elements.length - 1;
        int i = head;
        E x;
        while
((x = elements[i]) != null)        
        {
    if(o.equals(x))            
            {
            boolean varB326B5062B2F0E69046810717534CB09_108986564 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1853442314 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1853442314;
            }
            i = (i + 1) & mask;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_82637768 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1833183270 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1833183270;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.311 -0400", hash_original_method = "953726349F424E37042C19BD0C0A52B8", hash_generated_method = "44B444A20F0FECF1187C62BD5533D503")
    public boolean remove(Object o) {
        addTaint(o.getTaint());
        boolean var6E37986A993A2A916076A1C4367014FB_1938411874 = (removeFirstOccurrence(o));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1107614956 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1107614956;
        // ---------- Original Method ----------
        //return removeFirstOccurrence(o);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.312 -0400", hash_original_method = "AB065CB5BA1D923138DE6DFF9B806E2B", hash_generated_method = "3BCD3849948858A40A885C9B955FBE53")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.312 -0400", hash_original_method = "33D76C50C1E8C0374668B986897D9D9E", hash_generated_method = "EECD777348082AE7032A970F05F6D9E3")
    public Object[] toArray() {
Object[] var6FD0027538EDD1DC845C98DBD6A35104_1052444438 =         copyElements(new Object[size()]);
        var6FD0027538EDD1DC845C98DBD6A35104_1052444438.addTaint(taint);
        return var6FD0027538EDD1DC845C98DBD6A35104_1052444438;
        // ---------- Original Method ----------
        //return copyElements(new Object[size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.313 -0400", hash_original_method = "38034B8DDDAB71FC35937F12D964AD07", hash_generated_method = "D47B399EEE82A90B56AB27C041F897E8")
    public <T> T[] toArray(T[] a) {
        addTaint(a[0].getTaint());
        int size = size();
    if(a.length < size)        
        a = (T[])java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size);
        copyElements(a);
    if(a.length > size)        
        a[size] = null;
T[] var3F5343BF1D849954A73F0BB303805FFD_420248428 =         a;
        var3F5343BF1D849954A73F0BB303805FFD_420248428.addTaint(taint);
        return var3F5343BF1D849954A73F0BB303805FFD_420248428;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.313 -0400", hash_original_method = "A2826FA19E4353225E0757D076E8282A", hash_generated_method = "53ECC0BA6E055D8050B154CFCBF43553")
    public ArrayDeque<E> clone() {
        try 
        {
            ArrayDeque<E> result = (ArrayDeque<E>) super.clone();
            result.elements = Arrays.copyOf(elements, elements.length);
ArrayDeque<E> varDC838461EE2FA0CA4C9BBB70A15456B0_528796972 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_528796972.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_528796972;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA81442E36297E737EB908877E58260E8_1453137482 = new AssertionError();
            varA81442E36297E737EB908877E58260E8_1453137482.addTaint(taint);
            throw varA81442E36297E737EB908877E58260E8_1453137482;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.314 -0400", hash_original_method = "5A84D35A2C5A040CC18139106D665D0E", hash_generated_method = "93EB7642BA8BB24E3533817E9BA3E16B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.314 -0400", hash_original_method = "ABF871D717FCC2D87CA02E500CE54CBF", hash_generated_method = "247F5C6B322A797807EB5831518B08F7")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.314 -0400", hash_original_field = "A6C3E4B2DB56705F1E0449DB0F2C2FBA", hash_generated_field = "44DF51687F75FF9B360C641B654097EA")

        private int cursor = head;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.314 -0400", hash_original_field = "A59CA35B929091FBAF4213A76A4791DD", hash_generated_field = "CD264196D1FE9C34BAABF3EB22B1DEF4")

        private int fence = tail;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.314 -0400", hash_original_field = "05BB3FB56C1D06F12491BD981603A511", hash_generated_field = "C24010450EAB67B935A24ED5E0D44753")

        private int lastRet = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.314 -0400", hash_original_method = "8F728FEBD0A799A5BB08E38FDCDEB966", hash_generated_method = "8F728FEBD0A799A5BB08E38FDCDEB966")
        public DeqIterator ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.314 -0400", hash_original_method = "8D6FDA09A878582CCF6BFDDE96A3C673", hash_generated_method = "3A79DAD59E65E3487D948FA6BCEA0772")
        public boolean hasNext() {
            boolean varBB2FFB801149738DC5BBBE92D097852F_1962929142 = (cursor != fence);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1837565780 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1837565780;
            // ---------- Original Method ----------
            //return cursor != fence;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.315 -0400", hash_original_method = "9CABF9BA27B0EE6B683FFA8F5EC2BB0E", hash_generated_method = "F84BC837774831B64E5C49C199D0325C")
        public E next() {
    if(cursor == fence)            
            {
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_1331907826 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_1331907826.addTaint(taint);
            throw var28D00AB599969908D71F102AF992D49A_1331907826;
            }
            E result = elements[cursor];
    if(tail != fence || result == null)            
            {
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_154334213 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_154334213.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_154334213;
            }
            lastRet = cursor;
            cursor = (cursor + 1) & (elements.length - 1);
E varDC838461EE2FA0CA4C9BBB70A15456B0_2002252077 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_2002252077.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_2002252077;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.315 -0400", hash_original_method = "A6EE424EC418974FAC2A0A9E736B0189", hash_generated_method = "65259A8C2002691D89B52BC9EFAC28BD")
        public void remove() {
    if(lastRet < 0)            
            {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_746932235 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_746932235.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_746932235;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.316 -0400", hash_original_field = "D7BB8B9FE9FDF2C1C79C88B1A34D38AF", hash_generated_field = "9C757AFC9A7098F996E37879537F5728")

        private int cursor = tail;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.316 -0400", hash_original_field = "EFD18F3C9098DD073CE26810B5D769B0", hash_generated_field = "EB9AC1D6784E298C35CBEF17C766890F")

        private int fence = head;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.316 -0400", hash_original_field = "05BB3FB56C1D06F12491BD981603A511", hash_generated_field = "C24010450EAB67B935A24ED5E0D44753")

        private int lastRet = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.316 -0400", hash_original_method = "EFD23C54297A65B9A603FACFE0E34AA6", hash_generated_method = "EFD23C54297A65B9A603FACFE0E34AA6")
        public DescendingIterator ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.316 -0400", hash_original_method = "8D6FDA09A878582CCF6BFDDE96A3C673", hash_generated_method = "6365C8E9384BF696C7C4D56DF1C27B7F")
        public boolean hasNext() {
            boolean varBB2FFB801149738DC5BBBE92D097852F_1578215704 = (cursor != fence);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_868137100 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_868137100;
            // ---------- Original Method ----------
            //return cursor != fence;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.316 -0400", hash_original_method = "5248F2967157124DAD3A5B8F2BA1B9D6", hash_generated_method = "432840E97195D4A7DA1EBB2A4150C2E6")
        public E next() {
    if(cursor == fence)            
            {
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_1706179906 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_1706179906.addTaint(taint);
            throw var28D00AB599969908D71F102AF992D49A_1706179906;
            }
            cursor = (cursor - 1) & (elements.length - 1);
            E result = elements[cursor];
    if(head != fence || result == null)            
            {
            ConcurrentModificationException var779BA6969BD29E5F2D0448781C543B65_1803157382 = new ConcurrentModificationException();
            var779BA6969BD29E5F2D0448781C543B65_1803157382.addTaint(taint);
            throw var779BA6969BD29E5F2D0448781C543B65_1803157382;
            }
            lastRet = cursor;
E varDC838461EE2FA0CA4C9BBB70A15456B0_1937113322 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1937113322.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1937113322;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.317 -0400", hash_original_method = "C558887990F4F262B85810625D57822A", hash_generated_method = "7752840B0360D5FEAEDB9F6CDBB87B06")
        public void remove() {
    if(lastRet < 0)            
            {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1012339149 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1012339149.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1012339149;
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.317 -0400", hash_original_field = "FA7CACCF7CB1913464940178A51F4202", hash_generated_field = "9C3B8B7AFE1FAFCE87E9784F2B7C8D5F")

    private static final int MIN_INITIAL_CAPACITY = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:01.317 -0400", hash_original_field = "CE1576C94D2F8F975B0823F778718192", hash_generated_field = "7C4DAA612FFE9A2D14BBB1700B6F7B63")

    private static final long serialVersionUID = 2340985798034038923L;
}

