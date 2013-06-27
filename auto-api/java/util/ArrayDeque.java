package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.*;

public class ArrayDeque<E> extends AbstractCollection<E> implements Deque<E>, Cloneable, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.481 -0400", hash_original_field = "6A7F245843454CF4F28AD7C5E2572AA2", hash_generated_field = "777D1E33E50D4CDEA795A5FBEBE9B75E")

    private transient E[] elements;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.481 -0400", hash_original_field = "96E89A298E0A9F469B9AE458D6AFAE9F", hash_generated_field = "C80FE6D9E9CF1E423738D59094B3A099")

    private transient int head;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.481 -0400", hash_original_field = "7AEA2552DFE7EB84B9443B6FC9BA6E01", hash_generated_field = "993ACFB1D5CE316FEA289C1E850AAC75")

    private transient int tail;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.481 -0400", hash_original_method = "8C7B174379DD3B2C843811B1130834BD", hash_generated_method = "151203C88A4AC41E68C2D3AED6B6A179")
    public  ArrayDeque() {
        elements = (E[]) new Object[16];
        // ---------- Original Method ----------
        //elements = (E[]) new Object[16];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.482 -0400", hash_original_method = "690593276EDD66C533F49BEE09E9C663", hash_generated_method = "961A3DCC13843F4EF778BFE212FF8CDC")
    public  ArrayDeque(int numElements) {
        allocateElements(numElements);
        addTaint(numElements);
        // ---------- Original Method ----------
        //allocateElements(numElements);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.482 -0400", hash_original_method = "5E7B6C878951D7CA458070D073F03065", hash_generated_method = "E857B3907858ED486A3251136AC22BF3")
    public  ArrayDeque(Collection<? extends E> c) {
        allocateElements(c.size());
        addAll(c);
        addTaint(c.getTaint());
        // ---------- Original Method ----------
        //allocateElements(c.size());
        //addAll(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.483 -0400", hash_original_method = "86AF4C096D752C20A8CB0D886E79B7FB", hash_generated_method = "73170BA05D699447015820472AA83DC3")
    private void allocateElements(int numElements) {
        int initialCapacity;
        initialCapacity = MIN_INITIAL_CAPACITY;
        {
            initialCapacity = numElements;
            initialCapacity |= (initialCapacity >>>  1);
            initialCapacity |= (initialCapacity >>>  2);
            initialCapacity |= (initialCapacity >>>  4);
            initialCapacity |= (initialCapacity >>>  8);
            initialCapacity |= (initialCapacity >>> 16);
            initialCapacity >>>= 1;
        } //End block
        elements = (E[]) new Object[initialCapacity];
        addTaint(numElements);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.484 -0400", hash_original_method = "35225802D7F18BE5673FDDFDE4B70B2E", hash_generated_method = "456FB0945A4044D9A5C32B631DAA4D26")
    private void doubleCapacity() {
        int p;
        p = head;
        int n;
        n = elements.length;
        int r;
        r = n - p;
        int newCapacity;
        newCapacity = n << 1;
        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Sorry, deque too big");
        Object[] a;
        a = new Object[newCapacity];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.484 -0400", hash_original_method = "5E8669E32F5C4FDF3D4D82BA2C3949A2", hash_generated_method = "50A12809748523E980575688663D63E2")
    private <T> T[] copyElements(T[] a) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_1243406020 = null; //Variable for return #1
        {
            System.arraycopy(elements, head, a, 0, size());
        } //End block
        {
            int headPortionLen;
            headPortionLen = elements.length - head;
            System.arraycopy(elements, head, a, 0, headPortionLen);
            System.arraycopy(elements, 0, a, headPortionLen, tail);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1243406020 = a;
        addTaint(a[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1243406020.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1243406020;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.485 -0400", hash_original_method = "CBAC64602FF2D7F893923E0ABA8C507E", hash_generated_method = "43D388445E29AF9CA2D6DC6F0D76AE09")
    public void addFirst(E e) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        elements[head = (head - 1) & (elements.length - 1)] = e;
        doubleCapacity();
        // ---------- Original Method ----------
        //if (e == null)
            //throw new NullPointerException();
        //elements[head = (head - 1) & (elements.length - 1)] = e;
        //if (head == tail)
            //doubleCapacity();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.485 -0400", hash_original_method = "1B31DB8E2D035FB7799256F8004C4036", hash_generated_method = "212EADD213C8443C28B13578B880863A")
    public void addLast(E e) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        elements[tail] = e;
        {
            boolean var7F88578DCEE369DCF633CD33646CC15C_1690533925 = ((tail = (tail + 1) & (elements.length - 1)) == head);
            doubleCapacity();
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (e == null)
            //throw new NullPointerException();
        //elements[tail] = e;
        //if ( (tail = (tail + 1) & (elements.length - 1)) == head)
            //doubleCapacity();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.485 -0400", hash_original_method = "8D3228F5DEFAE0131B22F51707654BE0", hash_generated_method = "F85313CB02AE47E020325A25273AC5BF")
    public boolean offerFirst(E e) {
        addFirst(e);
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_539579458 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_539579458;
        // ---------- Original Method ----------
        //addFirst(e);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.498 -0400", hash_original_method = "15C090CE1A98280B8C8C7B6514A10013", hash_generated_method = "A17DEC4B9D9006184E9CB097C151545E")
    public boolean offerLast(E e) {
        addLast(e);
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_347744491 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_347744491;
        // ---------- Original Method ----------
        //addLast(e);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.501 -0400", hash_original_method = "8D1F2D8C9F4BF8EC3B65B975014CE8A7", hash_generated_method = "620FCC2CA08BDDA9B1E760E651ACD26A")
    public E removeFirst() {
        E varB4EAC82CA7396A68D541C85D26508E83_1096288838 = null; //Variable for return #1
        E x;
        x = pollFirst();
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_1096288838 = x;
        varB4EAC82CA7396A68D541C85D26508E83_1096288838.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1096288838;
        // ---------- Original Method ----------
        //E x = pollFirst();
        //if (x == null)
            //throw new NoSuchElementException();
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.502 -0400", hash_original_method = "90A521D0942C6C4821F3F861C2808726", hash_generated_method = "3287D4F60B7335C8234F453DB8B2F82C")
    public E removeLast() {
        E varB4EAC82CA7396A68D541C85D26508E83_1788740738 = null; //Variable for return #1
        E x;
        x = pollLast();
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_1788740738 = x;
        varB4EAC82CA7396A68D541C85D26508E83_1788740738.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1788740738;
        // ---------- Original Method ----------
        //E x = pollLast();
        //if (x == null)
            //throw new NoSuchElementException();
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.502 -0400", hash_original_method = "70BCEEA789C7C02318BA6052E8B29D53", hash_generated_method = "4CBBAD7311DCE23F0C354D2D92286679")
    public E pollFirst() {
        E varB4EAC82CA7396A68D541C85D26508E83_362470925 = null; //Variable for return #1
        E varB4EAC82CA7396A68D541C85D26508E83_1698298447 = null; //Variable for return #2
        int h;
        h = head;
        E result;
        result = elements[h];
        varB4EAC82CA7396A68D541C85D26508E83_362470925 = null;
        elements[h] = null;
        head = (h + 1) & (elements.length - 1);
        varB4EAC82CA7396A68D541C85D26508E83_1698298447 = result;
        E varA7E53CE21691AB073D9660D615818899_575320533; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_575320533 = varB4EAC82CA7396A68D541C85D26508E83_362470925;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_575320533 = varB4EAC82CA7396A68D541C85D26508E83_1698298447;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_575320533.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_575320533;
        // ---------- Original Method ----------
        //int h = head;
        //E result = elements[h];
        //if (result == null)
            //return null;
        //elements[h] = null;
        //head = (h + 1) & (elements.length - 1);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.505 -0400", hash_original_method = "CC3133A0441CFBBC149D7C0D4094D190", hash_generated_method = "59C67C7FF5856280C41B27F197A6F3BB")
    public E pollLast() {
        E varB4EAC82CA7396A68D541C85D26508E83_879537716 = null; //Variable for return #1
        E varB4EAC82CA7396A68D541C85D26508E83_778311432 = null; //Variable for return #2
        int t;
        t = (tail - 1) & (elements.length - 1);
        E result;
        result = elements[t];
        varB4EAC82CA7396A68D541C85D26508E83_879537716 = null;
        elements[t] = null;
        tail = t;
        varB4EAC82CA7396A68D541C85D26508E83_778311432 = result;
        E varA7E53CE21691AB073D9660D615818899_1591928130; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1591928130 = varB4EAC82CA7396A68D541C85D26508E83_879537716;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1591928130 = varB4EAC82CA7396A68D541C85D26508E83_778311432;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1591928130.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1591928130;
        // ---------- Original Method ----------
        //int t = (tail - 1) & (elements.length - 1);
        //E result = elements[t];
        //if (result == null)
            //return null;
        //elements[t] = null;
        //tail = t;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.505 -0400", hash_original_method = "969C370DEEB1254D835EA60A850D9474", hash_generated_method = "733719D135382D8A107364C59C085BC2")
    public E getFirst() {
        E varB4EAC82CA7396A68D541C85D26508E83_1024359691 = null; //Variable for return #1
        E x;
        x = elements[head];
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_1024359691 = x;
        varB4EAC82CA7396A68D541C85D26508E83_1024359691.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1024359691;
        // ---------- Original Method ----------
        //E x = elements[head];
        //if (x == null)
            //throw new NoSuchElementException();
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.517 -0400", hash_original_method = "609D7D9752B1EA7B409577881D715ECB", hash_generated_method = "A27418DF03922F4338140E4DDE5DF6E5")
    public E getLast() {
        E varB4EAC82CA7396A68D541C85D26508E83_1396486997 = null; //Variable for return #1
        E x;
        x = elements[(tail - 1) & (elements.length - 1)];
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_1396486997 = x;
        varB4EAC82CA7396A68D541C85D26508E83_1396486997.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1396486997;
        // ---------- Original Method ----------
        //E x = elements[(tail - 1) & (elements.length - 1)];
        //if (x == null)
            //throw new NoSuchElementException();
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.517 -0400", hash_original_method = "1112FC6950CD2F89C0F90F3FD6940182", hash_generated_method = "0C7E8F31AF50AFDACC2BB912D4181353")
    public E peekFirst() {
        E varB4EAC82CA7396A68D541C85D26508E83_1660167295 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1660167295 = elements[head];
        varB4EAC82CA7396A68D541C85D26508E83_1660167295.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1660167295;
        // ---------- Original Method ----------
        //return elements[head];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.518 -0400", hash_original_method = "2FB93C1E4553786B68715ADDCB3204FE", hash_generated_method = "1E1B0462C2FBEB18B0723C4D7354BAA4")
    public E peekLast() {
        E varB4EAC82CA7396A68D541C85D26508E83_1433930426 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1433930426 = elements[(tail - 1) & (elements.length - 1)];
        varB4EAC82CA7396A68D541C85D26508E83_1433930426.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1433930426;
        // ---------- Original Method ----------
        //return elements[(tail - 1) & (elements.length - 1)];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.518 -0400", hash_original_method = "2655E37A6129D552BDB18D712FBDBB78", hash_generated_method = "257F93A5998258C7A9FE8511CCFEC1D8")
    public boolean removeFirstOccurrence(Object o) {
        int mask;
        mask = elements.length - 1;
        int i;
        i = head;
        E x;
        {
            boolean var1329AA2C156BE9C813DA2AD363D45946_383309059 = ((x = elements[i]) != null);
            {
                {
                    boolean var8C3257AD3EAB1DB4919EC2B6E1BD3609_2082656514 = (o.equals(x));
                    {
                        delete(i);
                    } //End block
                } //End collapsed parenthetic
                i = (i + 1) & mask;
            } //End block
        } //End collapsed parenthetic
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_528944957 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_528944957;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.519 -0400", hash_original_method = "67D061371E16CEF717EF2A58AA73F6CB", hash_generated_method = "DBF8ACB0DE2ADB511D6AEA4D556545BD")
    public boolean removeLastOccurrence(Object o) {
        int mask;
        mask = elements.length - 1;
        int i;
        i = (tail - 1) & mask;
        E x;
        {
            boolean var1329AA2C156BE9C813DA2AD363D45946_373641120 = ((x = elements[i]) != null);
            {
                {
                    boolean var8C3257AD3EAB1DB4919EC2B6E1BD3609_1511533066 = (o.equals(x));
                    {
                        delete(i);
                    } //End block
                } //End collapsed parenthetic
                i = (i - 1) & mask;
            } //End block
        } //End collapsed parenthetic
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1095436894 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1095436894;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.533 -0400", hash_original_method = "056B268263D9E7E4C2239F12D1024514", hash_generated_method = "E69C6E2FF4CF375FD1450792C4C43E1A")
    public boolean add(E e) {
        addLast(e);
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1235801017 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1235801017;
        // ---------- Original Method ----------
        //addLast(e);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.533 -0400", hash_original_method = "90158A89D183AFC9420F99CD4C19A119", hash_generated_method = "B469EF94730B19D10C41BE1944CDBA65")
    public boolean offer(E e) {
        boolean var1C8D098E0D25C154182D97F2DFA9E90F_443289914 = (offerLast(e));
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_739922347 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_739922347;
        // ---------- Original Method ----------
        //return offerLast(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.533 -0400", hash_original_method = "5200E72EC4A7AF0A97DAC56CA915551B", hash_generated_method = "B0F0A9DCFC171D4BA671D039106A631B")
    public E remove() {
        E varB4EAC82CA7396A68D541C85D26508E83_500339793 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_500339793 = removeFirst();
        varB4EAC82CA7396A68D541C85D26508E83_500339793.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_500339793;
        // ---------- Original Method ----------
        //return removeFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.534 -0400", hash_original_method = "D6F4991F5239518842015971CA437CF0", hash_generated_method = "4A38B9DC3965FB4BD81B84D23B3502EE")
    public E poll() {
        E varB4EAC82CA7396A68D541C85D26508E83_874190273 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_874190273 = pollFirst();
        varB4EAC82CA7396A68D541C85D26508E83_874190273.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_874190273;
        // ---------- Original Method ----------
        //return pollFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.534 -0400", hash_original_method = "C3B5A6F3A12E32CB352921DD8911C7F3", hash_generated_method = "70A49B514F1DDE3B928D496A56E71790")
    public E element() {
        E varB4EAC82CA7396A68D541C85D26508E83_1243407786 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1243407786 = getFirst();
        varB4EAC82CA7396A68D541C85D26508E83_1243407786.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1243407786;
        // ---------- Original Method ----------
        //return getFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.534 -0400", hash_original_method = "A003E27ECA2FE3193555598EEC98E09D", hash_generated_method = "22BFACAF33C2925484321CCBD725F956")
    public E peek() {
        E varB4EAC82CA7396A68D541C85D26508E83_911481830 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_911481830 = peekFirst();
        varB4EAC82CA7396A68D541C85D26508E83_911481830.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_911481830;
        // ---------- Original Method ----------
        //return peekFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.535 -0400", hash_original_method = "848DD27BB905F5A807C52ED75E19F6C3", hash_generated_method = "72C186ED1744A0D2DEFAA4DDE67D7864")
    public void push(E e) {
        addFirst(e);
        addTaint(e.getTaint());
        // ---------- Original Method ----------
        //addFirst(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.536 -0400", hash_original_method = "158DA4E81D3B40D802055686181E6101", hash_generated_method = "51D57FED2E8EBE91D508DDF5844AEDF7")
    public E pop() {
        E varB4EAC82CA7396A68D541C85D26508E83_1010295015 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1010295015 = removeFirst();
        varB4EAC82CA7396A68D541C85D26508E83_1010295015.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1010295015;
        // ---------- Original Method ----------
        //return removeFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.536 -0400", hash_original_method = "BBF79E0ADE5790277B99F1D7AA727B20", hash_generated_method = "1D9C6F57BCDE2C7294D7BB32ACA5DF67")
    private void checkInvariants() {
        // ---------- Original Method ----------
        //assert elements[tail] == null;
        //assert head == tail ? elements[head] == null :
            //(elements[head] != null &&
             //elements[(tail - 1) & (elements.length - 1)] != null);
        //assert elements[(head - 1) & (elements.length - 1)] == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.546 -0400", hash_original_method = "6B28B7CDDDC5837E98E272935A4DA74A", hash_generated_method = "F9B7A4C07C7F6AB17212E05E04C5ABB8")
    private boolean delete(int i) {
        checkInvariants();
        E[] elements;
        elements = this.elements;
        int mask;
        mask = elements.length - 1;
        int h;
        h = head;
        int t;
        t = tail;
        int front;
        front = (i - h) & mask;
        int back;
        back = (t - i) & mask;
        if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
        {
            {
                System.arraycopy(elements, h, elements, h + 1, front);
            } //End block
            {
                System.arraycopy(elements, 0, elements, 1, i);
                elements[0] = elements[mask];
                System.arraycopy(elements, h, elements, h + 1, mask - h);
            } //End block
            elements[h] = null;
            head = (h + 1) & mask;
        } //End block
        {
            {
                System.arraycopy(elements, i + 1, elements, i, back);
                tail = t - 1;
            } //End block
            {
                System.arraycopy(elements, i + 1, elements, i, mask - i);
                elements[mask] = elements[0];
                System.arraycopy(elements, 1, elements, 0, t);
                tail = (t - 1) & mask;
            } //End block
        } //End block
        addTaint(i);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_995056545 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_995056545;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.551 -0400", hash_original_method = "D58AA3C48B1B36CF35B203F4633D4120", hash_generated_method = "C4E46844B39C679DCF2993D3BDF24B9B")
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1595536466 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1595536466;
        // ---------- Original Method ----------
        //return (tail - head) & (elements.length - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.551 -0400", hash_original_method = "029A9450FF46747D2F1AB4761630FBFA", hash_generated_method = "899A6CB66190EC76997108348EB52480")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1817949277 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1817949277;
        // ---------- Original Method ----------
        //return head == tail;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.552 -0400", hash_original_method = "ECCE71EADB88CB0EFABEE24B7316B6D0", hash_generated_method = "C45F0FE6E7DE9743837C3C3E673DA3DF")
    public Iterator<E> iterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_2031427629 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2031427629 = new DeqIterator();
        varB4EAC82CA7396A68D541C85D26508E83_2031427629.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2031427629;
        // ---------- Original Method ----------
        //return new DeqIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.552 -0400", hash_original_method = "09A6B8B983928A3C88383EF59752C844", hash_generated_method = "026B1BC18FB9EDC845380F2D044459DD")
    public Iterator<E> descendingIterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_1754903 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1754903 = new DescendingIterator();
        varB4EAC82CA7396A68D541C85D26508E83_1754903.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1754903;
        // ---------- Original Method ----------
        //return new DescendingIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.553 -0400", hash_original_method = "76B0F415E6F814FE548D14BC6D5843EE", hash_generated_method = "239199E77A8A533B91916E109693C41B")
    public boolean contains(Object o) {
        int mask;
        mask = elements.length - 1;
        int i;
        i = head;
        E x;
        {
            boolean var1329AA2C156BE9C813DA2AD363D45946_690194274 = ((x = elements[i]) != null);
            {
                {
                    boolean var8C3257AD3EAB1DB4919EC2B6E1BD3609_1623458238 = (o.equals(x));
                } //End collapsed parenthetic
                i = (i + 1) & mask;
            } //End block
        } //End collapsed parenthetic
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1381659286 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1381659286;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.558 -0400", hash_original_method = "953726349F424E37042C19BD0C0A52B8", hash_generated_method = "437095FB8E246B070A1E4B9B57DF41FF")
    public boolean remove(Object o) {
        boolean varB3B6A07AEF87793955942F9770654762_1656540934 = (removeFirstOccurrence(o));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_134985063 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_134985063;
        // ---------- Original Method ----------
        //return removeFirstOccurrence(o);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.567 -0400", hash_original_method = "AB065CB5BA1D923138DE6DFF9B806E2B", hash_generated_method = "46BF4EA79B8F3F655FE56357D4AF4ABB")
    public void clear() {
        int h;
        h = head;
        int t;
        t = tail;
        {
            head = tail = 0;
            int i;
            i = h;
            int mask;
            mask = elements.length - 1;
            {
                elements[i] = null;
                i = (i + 1) & mask;
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.568 -0400", hash_original_method = "33D76C50C1E8C0374668B986897D9D9E", hash_generated_method = "3E943247484A556AD6C8C24E6338DDCB")
    public Object[] toArray() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_650322647 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_650322647 = copyElements(new Object[size()]);
        varB4EAC82CA7396A68D541C85D26508E83_650322647.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_650322647;
        // ---------- Original Method ----------
        //return copyElements(new Object[size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.568 -0400", hash_original_method = "38034B8DDDAB71FC35937F12D964AD07", hash_generated_method = "A7E72CA19C5D015A1D4DC2D62E24284C")
    public <T> T[] toArray(T[] a) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_2040341925 = null; //Variable for return #1
        int size;
        size = size();
        a = (T[])java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size);
        copyElements(a);
        a[size] = null;
        varB4EAC82CA7396A68D541C85D26508E83_2040341925 = a;
        addTaint(a[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2040341925.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2040341925;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.573 -0400", hash_original_method = "A2826FA19E4353225E0757D076E8282A", hash_generated_method = "05E8DA4F27C6B039530A55CFBC113ABA")
    public ArrayDeque<E> clone() {
        ArrayDeque<E> varB4EAC82CA7396A68D541C85D26508E83_1659163080 = null; //Variable for return #1
        try 
        {
            ArrayDeque<E> result;
            result = (ArrayDeque<E>) super.clone();
            result.elements = Arrays.copyOf(elements, elements.length);
            varB4EAC82CA7396A68D541C85D26508E83_1659163080 = result;
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1659163080.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1659163080;
        // ---------- Original Method ----------
        //try {
            //ArrayDeque<E> result = (ArrayDeque<E>) super.clone();
            //result.elements = Arrays.copyOf(elements, elements.length);
            //return result;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.573 -0400", hash_original_method = "5A84D35A2C5A040CC18139106D665D0E", hash_generated_method = "6381745500BDB723703A170DB99EE97C")
    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(size());
        int mask;
        mask = elements.length - 1;
        {
            int i;
            i = head;
            i = (i + 1) & mask;
            s.writeObject(elements[i]);
        } //End collapsed parenthetic
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //s.defaultWriteObject();
        //s.writeInt(size());
        //int mask = elements.length - 1;
        //for (int i = head; i != tail; i = (i + 1) & mask)
            //s.writeObject(elements[i]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.574 -0400", hash_original_method = "ABF871D717FCC2D87CA02E500CE54CBF", hash_generated_method = "805B405F0AC99AB671AFE4082C7A104A")
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        int size;
        size = s.readInt();
        allocateElements(size);
        head = 0;
        tail = size;
        {
            int i;
            i = 0;
            elements[i] = (E)s.readObject();
        } //End collapsed parenthetic
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.574 -0400", hash_original_field = "A6C3E4B2DB56705F1E0449DB0F2C2FBA", hash_generated_field = "44DF51687F75FF9B360C641B654097EA")

        private int cursor = head;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.574 -0400", hash_original_field = "A59CA35B929091FBAF4213A76A4791DD", hash_generated_field = "CD264196D1FE9C34BAABF3EB22B1DEF4")

        private int fence = tail;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.574 -0400", hash_original_field = "05BB3FB56C1D06F12491BD981603A511", hash_generated_field = "C24010450EAB67B935A24ED5E0D44753")

        private int lastRet = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.574 -0400", hash_original_method = "8F728FEBD0A799A5BB08E38FDCDEB966", hash_generated_method = "8F728FEBD0A799A5BB08E38FDCDEB966")
        public DeqIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.574 -0400", hash_original_method = "8D6FDA09A878582CCF6BFDDE96A3C673", hash_generated_method = "737526EC22E9F8CF2E44D30A38E5E262")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_142725657 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_142725657;
            // ---------- Original Method ----------
            //return cursor != fence;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.575 -0400", hash_original_method = "9CABF9BA27B0EE6B683FFA8F5EC2BB0E", hash_generated_method = "33B276FDAD334B174FFCB1D969025912")
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_1493463622 = null; //Variable for return #1
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            E result;
            result = elements[cursor];
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            lastRet = cursor;
            cursor = (cursor + 1) & (elements.length - 1);
            varB4EAC82CA7396A68D541C85D26508E83_1493463622 = result;
            varB4EAC82CA7396A68D541C85D26508E83_1493463622.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1493463622;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.586 -0400", hash_original_method = "A6EE424EC418974FAC2A0A9E736B0189", hash_generated_method = "D867C05BD1057475A5AA6796CA6E617A")
        public void remove() {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            {
                boolean varC9E761FAC14702C2B623BE027E2F7281_917836848 = (delete(lastRet));
                {
                    cursor = (cursor - 1) & (elements.length - 1);
                    fence = tail;
                } //End block
            } //End collapsed parenthetic
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.586 -0400", hash_original_field = "D7BB8B9FE9FDF2C1C79C88B1A34D38AF", hash_generated_field = "9C757AFC9A7098F996E37879537F5728")

        private int cursor = tail;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.586 -0400", hash_original_field = "EFD18F3C9098DD073CE26810B5D769B0", hash_generated_field = "EB9AC1D6784E298C35CBEF17C766890F")

        private int fence = head;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.586 -0400", hash_original_field = "05BB3FB56C1D06F12491BD981603A511", hash_generated_field = "C24010450EAB67B935A24ED5E0D44753")

        private int lastRet = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.586 -0400", hash_original_method = "EFD23C54297A65B9A603FACFE0E34AA6", hash_generated_method = "EFD23C54297A65B9A603FACFE0E34AA6")
        public DescendingIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.587 -0400", hash_original_method = "8D6FDA09A878582CCF6BFDDE96A3C673", hash_generated_method = "6AEE14BEB356C092144C279049781087")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_206084281 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_206084281;
            // ---------- Original Method ----------
            //return cursor != fence;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.588 -0400", hash_original_method = "5248F2967157124DAD3A5B8F2BA1B9D6", hash_generated_method = "2211771D6D0A0C0AED162559C91DB04A")
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_434925802 = null; //Variable for return #1
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            cursor = (cursor - 1) & (elements.length - 1);
            E result;
            result = elements[cursor];
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            lastRet = cursor;
            varB4EAC82CA7396A68D541C85D26508E83_434925802 = result;
            varB4EAC82CA7396A68D541C85D26508E83_434925802.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_434925802;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.592 -0400", hash_original_method = "C558887990F4F262B85810625D57822A", hash_generated_method = "C75F4A280DC62E725822112908CDDBAF")
        public void remove() {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            {
                boolean var3942AF7F654E16207FF88B33EBA55990_741207364 = (!delete(lastRet));
                {
                    cursor = (cursor + 1) & (elements.length - 1);
                    fence = head;
                } //End block
            } //End collapsed parenthetic
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.592 -0400", hash_original_field = "FA7CACCF7CB1913464940178A51F4202", hash_generated_field = "6E7CD6762AD4CB4CE9AB508DAEB6C66F")

    private static int MIN_INITIAL_CAPACITY = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:49.592 -0400", hash_original_field = "CE1576C94D2F8F975B0823F778718192", hash_generated_field = "5D2DFEA6D297ABF43DA859264DB0C963")

    private static long serialVersionUID = 2340985798034038923L;
}

