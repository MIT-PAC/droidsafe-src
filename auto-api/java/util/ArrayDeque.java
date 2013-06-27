package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.*;

public class ArrayDeque<E> extends AbstractCollection<E> implements Deque<E>, Cloneable, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.458 -0400", hash_original_field = "6A7F245843454CF4F28AD7C5E2572AA2", hash_generated_field = "777D1E33E50D4CDEA795A5FBEBE9B75E")

    private transient E[] elements;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.459 -0400", hash_original_field = "96E89A298E0A9F469B9AE458D6AFAE9F", hash_generated_field = "C80FE6D9E9CF1E423738D59094B3A099")

    private transient int head;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.459 -0400", hash_original_field = "7AEA2552DFE7EB84B9443B6FC9BA6E01", hash_generated_field = "993ACFB1D5CE316FEA289C1E850AAC75")

    private transient int tail;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.459 -0400", hash_original_method = "8C7B174379DD3B2C843811B1130834BD", hash_generated_method = "151203C88A4AC41E68C2D3AED6B6A179")
    public  ArrayDeque() {
        elements = (E[]) new Object[16];
        // ---------- Original Method ----------
        //elements = (E[]) new Object[16];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.459 -0400", hash_original_method = "690593276EDD66C533F49BEE09E9C663", hash_generated_method = "961A3DCC13843F4EF778BFE212FF8CDC")
    public  ArrayDeque(int numElements) {
        allocateElements(numElements);
        addTaint(numElements);
        // ---------- Original Method ----------
        //allocateElements(numElements);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.459 -0400", hash_original_method = "5E7B6C878951D7CA458070D073F03065", hash_generated_method = "E857B3907858ED486A3251136AC22BF3")
    public  ArrayDeque(Collection<? extends E> c) {
        allocateElements(c.size());
        addAll(c);
        addTaint(c.getTaint());
        // ---------- Original Method ----------
        //allocateElements(c.size());
        //addAll(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.460 -0400", hash_original_method = "86AF4C096D752C20A8CB0D886E79B7FB", hash_generated_method = "73170BA05D699447015820472AA83DC3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.461 -0400", hash_original_method = "35225802D7F18BE5673FDDFDE4B70B2E", hash_generated_method = "456FB0945A4044D9A5C32B631DAA4D26")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.473 -0400", hash_original_method = "5E8669E32F5C4FDF3D4D82BA2C3949A2", hash_generated_method = "A685F9F7CCBA17C68A28045F3CDFF3AD")
    private <T> T[] copyElements(T[] a) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_1073212488 = null; //Variable for return #1
        {
            System.arraycopy(elements, head, a, 0, size());
        } //End block
        {
            int headPortionLen;
            headPortionLen = elements.length - head;
            System.arraycopy(elements, head, a, 0, headPortionLen);
            System.arraycopy(elements, 0, a, headPortionLen, tail);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1073212488 = a;
        addTaint(a[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1073212488.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1073212488;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.474 -0400", hash_original_method = "CBAC64602FF2D7F893923E0ABA8C507E", hash_generated_method = "43D388445E29AF9CA2D6DC6F0D76AE09")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.474 -0400", hash_original_method = "1B31DB8E2D035FB7799256F8004C4036", hash_generated_method = "C0651B7FA1A97E2D58482960E467EE26")
    public void addLast(E e) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        elements[tail] = e;
        {
            boolean var7F88578DCEE369DCF633CD33646CC15C_1183386892 = ((tail = (tail + 1) & (elements.length - 1)) == head);
            doubleCapacity();
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (e == null)
            //throw new NullPointerException();
        //elements[tail] = e;
        //if ( (tail = (tail + 1) & (elements.length - 1)) == head)
            //doubleCapacity();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.475 -0400", hash_original_method = "8D3228F5DEFAE0131B22F51707654BE0", hash_generated_method = "B7C643DA82FF128877EFD0FC6A50B331")
    public boolean offerFirst(E e) {
        addFirst(e);
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_813959172 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_813959172;
        // ---------- Original Method ----------
        //addFirst(e);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.475 -0400", hash_original_method = "15C090CE1A98280B8C8C7B6514A10013", hash_generated_method = "E78BF1D0C79423CC067EEAD52BA52D94")
    public boolean offerLast(E e) {
        addLast(e);
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_104989001 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_104989001;
        // ---------- Original Method ----------
        //addLast(e);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.479 -0400", hash_original_method = "8D1F2D8C9F4BF8EC3B65B975014CE8A7", hash_generated_method = "67051D772CD82944C77B4E8244920FB8")
    public E removeFirst() {
        E varB4EAC82CA7396A68D541C85D26508E83_1160917576 = null; //Variable for return #1
        E x;
        x = pollFirst();
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_1160917576 = x;
        varB4EAC82CA7396A68D541C85D26508E83_1160917576.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1160917576;
        // ---------- Original Method ----------
        //E x = pollFirst();
        //if (x == null)
            //throw new NoSuchElementException();
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.480 -0400", hash_original_method = "90A521D0942C6C4821F3F861C2808726", hash_generated_method = "FB3396F0484A1EDED8FFB46B95452980")
    public E removeLast() {
        E varB4EAC82CA7396A68D541C85D26508E83_636806781 = null; //Variable for return #1
        E x;
        x = pollLast();
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_636806781 = x;
        varB4EAC82CA7396A68D541C85D26508E83_636806781.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_636806781;
        // ---------- Original Method ----------
        //E x = pollLast();
        //if (x == null)
            //throw new NoSuchElementException();
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.481 -0400", hash_original_method = "70BCEEA789C7C02318BA6052E8B29D53", hash_generated_method = "5FB105DEEB65B5440A75E15298530BBB")
    public E pollFirst() {
        E varB4EAC82CA7396A68D541C85D26508E83_1257421002 = null; //Variable for return #1
        E varB4EAC82CA7396A68D541C85D26508E83_654510598 = null; //Variable for return #2
        int h;
        h = head;
        E result;
        result = elements[h];
        varB4EAC82CA7396A68D541C85D26508E83_1257421002 = null;
        elements[h] = null;
        head = (h + 1) & (elements.length - 1);
        varB4EAC82CA7396A68D541C85D26508E83_654510598 = result;
        E varA7E53CE21691AB073D9660D615818899_1285788906; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1285788906 = varB4EAC82CA7396A68D541C85D26508E83_1257421002;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1285788906 = varB4EAC82CA7396A68D541C85D26508E83_654510598;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1285788906.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1285788906;
        // ---------- Original Method ----------
        //int h = head;
        //E result = elements[h];
        //if (result == null)
            //return null;
        //elements[h] = null;
        //head = (h + 1) & (elements.length - 1);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.511 -0400", hash_original_method = "CC3133A0441CFBBC149D7C0D4094D190", hash_generated_method = "8B6A65E049BE736AF98360E50CB619F8")
    public E pollLast() {
        E varB4EAC82CA7396A68D541C85D26508E83_1574023207 = null; //Variable for return #1
        E varB4EAC82CA7396A68D541C85D26508E83_1151789267 = null; //Variable for return #2
        int t;
        t = (tail - 1) & (elements.length - 1);
        E result;
        result = elements[t];
        varB4EAC82CA7396A68D541C85D26508E83_1574023207 = null;
        elements[t] = null;
        tail = t;
        varB4EAC82CA7396A68D541C85D26508E83_1151789267 = result;
        E varA7E53CE21691AB073D9660D615818899_2067606369; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2067606369 = varB4EAC82CA7396A68D541C85D26508E83_1574023207;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2067606369 = varB4EAC82CA7396A68D541C85D26508E83_1151789267;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2067606369.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2067606369;
        // ---------- Original Method ----------
        //int t = (tail - 1) & (elements.length - 1);
        //E result = elements[t];
        //if (result == null)
            //return null;
        //elements[t] = null;
        //tail = t;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.512 -0400", hash_original_method = "969C370DEEB1254D835EA60A850D9474", hash_generated_method = "45DFA88D0638C314B49080E1801E0660")
    public E getFirst() {
        E varB4EAC82CA7396A68D541C85D26508E83_909795537 = null; //Variable for return #1
        E x;
        x = elements[head];
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_909795537 = x;
        varB4EAC82CA7396A68D541C85D26508E83_909795537.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_909795537;
        // ---------- Original Method ----------
        //E x = elements[head];
        //if (x == null)
            //throw new NoSuchElementException();
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.512 -0400", hash_original_method = "609D7D9752B1EA7B409577881D715ECB", hash_generated_method = "C181C1BB697431B2B52D53978B162463")
    public E getLast() {
        E varB4EAC82CA7396A68D541C85D26508E83_44585354 = null; //Variable for return #1
        E x;
        x = elements[(tail - 1) & (elements.length - 1)];
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_44585354 = x;
        varB4EAC82CA7396A68D541C85D26508E83_44585354.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_44585354;
        // ---------- Original Method ----------
        //E x = elements[(tail - 1) & (elements.length - 1)];
        //if (x == null)
            //throw new NoSuchElementException();
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.513 -0400", hash_original_method = "1112FC6950CD2F89C0F90F3FD6940182", hash_generated_method = "18436FE99A62717DC5B1BAA047ED2D47")
    public E peekFirst() {
        E varB4EAC82CA7396A68D541C85D26508E83_1740855015 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1740855015 = elements[head];
        varB4EAC82CA7396A68D541C85D26508E83_1740855015.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1740855015;
        // ---------- Original Method ----------
        //return elements[head];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.513 -0400", hash_original_method = "2FB93C1E4553786B68715ADDCB3204FE", hash_generated_method = "7A186B18BDC1D329F5884AE84E719FB4")
    public E peekLast() {
        E varB4EAC82CA7396A68D541C85D26508E83_451178790 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_451178790 = elements[(tail - 1) & (elements.length - 1)];
        varB4EAC82CA7396A68D541C85D26508E83_451178790.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_451178790;
        // ---------- Original Method ----------
        //return elements[(tail - 1) & (elements.length - 1)];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.514 -0400", hash_original_method = "2655E37A6129D552BDB18D712FBDBB78", hash_generated_method = "B841C0029F91F4C1700A9CE1934ECB6A")
    public boolean removeFirstOccurrence(Object o) {
        int mask;
        mask = elements.length - 1;
        int i;
        i = head;
        E x;
        {
            boolean var1329AA2C156BE9C813DA2AD363D45946_1080535278 = ((x = elements[i]) != null);
            {
                {
                    boolean var8C3257AD3EAB1DB4919EC2B6E1BD3609_2052801502 = (o.equals(x));
                    {
                        delete(i);
                    } //End block
                } //End collapsed parenthetic
                i = (i + 1) & mask;
            } //End block
        } //End collapsed parenthetic
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_18390882 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_18390882;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.514 -0400", hash_original_method = "67D061371E16CEF717EF2A58AA73F6CB", hash_generated_method = "A2109759057B0E55F4764EB1C20119EA")
    public boolean removeLastOccurrence(Object o) {
        int mask;
        mask = elements.length - 1;
        int i;
        i = (tail - 1) & mask;
        E x;
        {
            boolean var1329AA2C156BE9C813DA2AD363D45946_1163900908 = ((x = elements[i]) != null);
            {
                {
                    boolean var8C3257AD3EAB1DB4919EC2B6E1BD3609_1574667396 = (o.equals(x));
                    {
                        delete(i);
                    } //End block
                } //End collapsed parenthetic
                i = (i - 1) & mask;
            } //End block
        } //End collapsed parenthetic
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1689346369 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1689346369;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.515 -0400", hash_original_method = "056B268263D9E7E4C2239F12D1024514", hash_generated_method = "1A7462D93AADB7B72009FDE967DBA1CB")
    public boolean add(E e) {
        addLast(e);
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1561342282 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1561342282;
        // ---------- Original Method ----------
        //addLast(e);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.515 -0400", hash_original_method = "90158A89D183AFC9420F99CD4C19A119", hash_generated_method = "F263DED43F69AFFCFEE5DEA1CE22E63D")
    public boolean offer(E e) {
        boolean var1C8D098E0D25C154182D97F2DFA9E90F_1289951738 = (offerLast(e));
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1858698450 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1858698450;
        // ---------- Original Method ----------
        //return offerLast(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.516 -0400", hash_original_method = "5200E72EC4A7AF0A97DAC56CA915551B", hash_generated_method = "8728C1BD701437020109C2105F25D563")
    public E remove() {
        E varB4EAC82CA7396A68D541C85D26508E83_494594122 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_494594122 = removeFirst();
        varB4EAC82CA7396A68D541C85D26508E83_494594122.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_494594122;
        // ---------- Original Method ----------
        //return removeFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.517 -0400", hash_original_method = "D6F4991F5239518842015971CA437CF0", hash_generated_method = "FF417AA23DEEA1D27D35624B8068CE16")
    public E poll() {
        E varB4EAC82CA7396A68D541C85D26508E83_1776903809 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1776903809 = pollFirst();
        varB4EAC82CA7396A68D541C85D26508E83_1776903809.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1776903809;
        // ---------- Original Method ----------
        //return pollFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.521 -0400", hash_original_method = "C3B5A6F3A12E32CB352921DD8911C7F3", hash_generated_method = "9EAD779B36AF6EC87508503147DCA974")
    public E element() {
        E varB4EAC82CA7396A68D541C85D26508E83_1150438997 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1150438997 = getFirst();
        varB4EAC82CA7396A68D541C85D26508E83_1150438997.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1150438997;
        // ---------- Original Method ----------
        //return getFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.522 -0400", hash_original_method = "A003E27ECA2FE3193555598EEC98E09D", hash_generated_method = "91D8FB06A8621AF0F54869F0FA26BB3F")
    public E peek() {
        E varB4EAC82CA7396A68D541C85D26508E83_465172537 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_465172537 = peekFirst();
        varB4EAC82CA7396A68D541C85D26508E83_465172537.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_465172537;
        // ---------- Original Method ----------
        //return peekFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.530 -0400", hash_original_method = "848DD27BB905F5A807C52ED75E19F6C3", hash_generated_method = "72C186ED1744A0D2DEFAA4DDE67D7864")
    public void push(E e) {
        addFirst(e);
        addTaint(e.getTaint());
        // ---------- Original Method ----------
        //addFirst(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.531 -0400", hash_original_method = "158DA4E81D3B40D802055686181E6101", hash_generated_method = "816C8C66A7C04A7AE01EF39365DCD5C1")
    public E pop() {
        E varB4EAC82CA7396A68D541C85D26508E83_1827173846 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1827173846 = removeFirst();
        varB4EAC82CA7396A68D541C85D26508E83_1827173846.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1827173846;
        // ---------- Original Method ----------
        //return removeFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.531 -0400", hash_original_method = "BBF79E0ADE5790277B99F1D7AA727B20", hash_generated_method = "1D9C6F57BCDE2C7294D7BB32ACA5DF67")
    private void checkInvariants() {
        // ---------- Original Method ----------
        //assert elements[tail] == null;
        //assert head == tail ? elements[head] == null :
            //(elements[head] != null &&
             //elements[(tail - 1) & (elements.length - 1)] != null);
        //assert elements[(head - 1) & (elements.length - 1)] == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.532 -0400", hash_original_method = "6B28B7CDDDC5837E98E272935A4DA74A", hash_generated_method = "501907991D4B9C20640AC7EC6FE81328")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1954518511 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1954518511;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.545 -0400", hash_original_method = "D58AA3C48B1B36CF35B203F4633D4120", hash_generated_method = "3F4E15B7E3368FCA293E510D78DF13BF")
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_617317516 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_617317516;
        // ---------- Original Method ----------
        //return (tail - head) & (elements.length - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.545 -0400", hash_original_method = "029A9450FF46747D2F1AB4761630FBFA", hash_generated_method = "16BDC575B7646E882F97E0617909ECDF")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1224011651 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1224011651;
        // ---------- Original Method ----------
        //return head == tail;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.546 -0400", hash_original_method = "ECCE71EADB88CB0EFABEE24B7316B6D0", hash_generated_method = "4864EE87AC1A4656CB5658B7203150BA")
    public Iterator<E> iterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_1540803479 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1540803479 = new DeqIterator();
        varB4EAC82CA7396A68D541C85D26508E83_1540803479.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1540803479;
        // ---------- Original Method ----------
        //return new DeqIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.546 -0400", hash_original_method = "09A6B8B983928A3C88383EF59752C844", hash_generated_method = "648142675081B328DAE708E1AD7E8990")
    public Iterator<E> descendingIterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_274769148 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_274769148 = new DescendingIterator();
        varB4EAC82CA7396A68D541C85D26508E83_274769148.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_274769148;
        // ---------- Original Method ----------
        //return new DescendingIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.547 -0400", hash_original_method = "76B0F415E6F814FE548D14BC6D5843EE", hash_generated_method = "836474FB234E95B0760120DD2D3F0622")
    public boolean contains(Object o) {
        int mask;
        mask = elements.length - 1;
        int i;
        i = head;
        E x;
        {
            boolean var1329AA2C156BE9C813DA2AD363D45946_1083877371 = ((x = elements[i]) != null);
            {
                {
                    boolean var8C3257AD3EAB1DB4919EC2B6E1BD3609_1999353247 = (o.equals(x));
                } //End collapsed parenthetic
                i = (i + 1) & mask;
            } //End block
        } //End collapsed parenthetic
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1490647340 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1490647340;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.548 -0400", hash_original_method = "953726349F424E37042C19BD0C0A52B8", hash_generated_method = "013DCC8679C3999999DBC71D6FFD6400")
    public boolean remove(Object o) {
        boolean varB3B6A07AEF87793955942F9770654762_963563062 = (removeFirstOccurrence(o));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1024264355 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1024264355;
        // ---------- Original Method ----------
        //return removeFirstOccurrence(o);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.548 -0400", hash_original_method = "AB065CB5BA1D923138DE6DFF9B806E2B", hash_generated_method = "46BF4EA79B8F3F655FE56357D4AF4ABB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.549 -0400", hash_original_method = "33D76C50C1E8C0374668B986897D9D9E", hash_generated_method = "75F0598E0A91B243A266F555FB5179C5")
    public Object[] toArray() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_1219439604 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1219439604 = copyElements(new Object[size()]);
        varB4EAC82CA7396A68D541C85D26508E83_1219439604.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1219439604;
        // ---------- Original Method ----------
        //return copyElements(new Object[size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.557 -0400", hash_original_method = "38034B8DDDAB71FC35937F12D964AD07", hash_generated_method = "50859F340B9CA5FFBB5A921B41593BE3")
    public <T> T[] toArray(T[] a) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_664498761 = null; //Variable for return #1
        int size;
        size = size();
        a = (T[])java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size);
        copyElements(a);
        a[size] = null;
        varB4EAC82CA7396A68D541C85D26508E83_664498761 = a;
        addTaint(a[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_664498761.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_664498761;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.561 -0400", hash_original_method = "A2826FA19E4353225E0757D076E8282A", hash_generated_method = "21F9F8EC71E60801DD0C078A5424C71B")
    public ArrayDeque<E> clone() {
        ArrayDeque<E> varB4EAC82CA7396A68D541C85D26508E83_1562707467 = null; //Variable for return #1
        try 
        {
            ArrayDeque<E> result;
            result = (ArrayDeque<E>) super.clone();
            result.elements = Arrays.copyOf(elements, elements.length);
            varB4EAC82CA7396A68D541C85D26508E83_1562707467 = result;
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1562707467.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1562707467;
        // ---------- Original Method ----------
        //try {
            //ArrayDeque<E> result = (ArrayDeque<E>) super.clone();
            //result.elements = Arrays.copyOf(elements, elements.length);
            //return result;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.576 -0400", hash_original_method = "5A84D35A2C5A040CC18139106D665D0E", hash_generated_method = "6381745500BDB723703A170DB99EE97C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.578 -0400", hash_original_method = "ABF871D717FCC2D87CA02E500CE54CBF", hash_generated_method = "805B405F0AC99AB671AFE4082C7A104A")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.578 -0400", hash_original_field = "A6C3E4B2DB56705F1E0449DB0F2C2FBA", hash_generated_field = "44DF51687F75FF9B360C641B654097EA")

        private int cursor = head;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.578 -0400", hash_original_field = "A59CA35B929091FBAF4213A76A4791DD", hash_generated_field = "CD264196D1FE9C34BAABF3EB22B1DEF4")

        private int fence = tail;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.578 -0400", hash_original_field = "05BB3FB56C1D06F12491BD981603A511", hash_generated_field = "C24010450EAB67B935A24ED5E0D44753")

        private int lastRet = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.578 -0400", hash_original_method = "8F728FEBD0A799A5BB08E38FDCDEB966", hash_generated_method = "8F728FEBD0A799A5BB08E38FDCDEB966")
        public DeqIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.578 -0400", hash_original_method = "8D6FDA09A878582CCF6BFDDE96A3C673", hash_generated_method = "C7E20815A8644AAA9D06F3A4471B223E")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_214361222 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_214361222;
            // ---------- Original Method ----------
            //return cursor != fence;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.582 -0400", hash_original_method = "9CABF9BA27B0EE6B683FFA8F5EC2BB0E", hash_generated_method = "91E0FD1E07A5EE0E74D97D96F51B17CE")
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_294148013 = null; //Variable for return #1
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            E result;
            result = elements[cursor];
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            lastRet = cursor;
            cursor = (cursor + 1) & (elements.length - 1);
            varB4EAC82CA7396A68D541C85D26508E83_294148013 = result;
            varB4EAC82CA7396A68D541C85D26508E83_294148013.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_294148013;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.583 -0400", hash_original_method = "A6EE424EC418974FAC2A0A9E736B0189", hash_generated_method = "90C67DDA081E8F46298467F7B4058811")
        public void remove() {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            {
                boolean varC9E761FAC14702C2B623BE027E2F7281_464261245 = (delete(lastRet));
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.587 -0400", hash_original_field = "D7BB8B9FE9FDF2C1C79C88B1A34D38AF", hash_generated_field = "9C757AFC9A7098F996E37879537F5728")

        private int cursor = tail;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.587 -0400", hash_original_field = "EFD18F3C9098DD073CE26810B5D769B0", hash_generated_field = "EB9AC1D6784E298C35CBEF17C766890F")

        private int fence = head;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.587 -0400", hash_original_field = "05BB3FB56C1D06F12491BD981603A511", hash_generated_field = "C24010450EAB67B935A24ED5E0D44753")

        private int lastRet = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.587 -0400", hash_original_method = "EFD23C54297A65B9A603FACFE0E34AA6", hash_generated_method = "EFD23C54297A65B9A603FACFE0E34AA6")
        public DescendingIterator ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.588 -0400", hash_original_method = "8D6FDA09A878582CCF6BFDDE96A3C673", hash_generated_method = "65E415A723B95627E8CCC4510ED0D614")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1089059530 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1089059530;
            // ---------- Original Method ----------
            //return cursor != fence;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.589 -0400", hash_original_method = "5248F2967157124DAD3A5B8F2BA1B9D6", hash_generated_method = "DD8331917D8589535FEADAB758B8E900")
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_607278289 = null; //Variable for return #1
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            cursor = (cursor - 1) & (elements.length - 1);
            E result;
            result = elements[cursor];
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            lastRet = cursor;
            varB4EAC82CA7396A68D541C85D26508E83_607278289 = result;
            varB4EAC82CA7396A68D541C85D26508E83_607278289.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_607278289;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.608 -0400", hash_original_method = "C558887990F4F262B85810625D57822A", hash_generated_method = "2AC4D8E4E7409CB287EDD1E972B8B03B")
        public void remove() {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            {
                boolean var3942AF7F654E16207FF88B33EBA55990_696295570 = (!delete(lastRet));
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.608 -0400", hash_original_field = "FA7CACCF7CB1913464940178A51F4202", hash_generated_field = "6E7CD6762AD4CB4CE9AB508DAEB6C66F")

    private static int MIN_INITIAL_CAPACITY = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:49.608 -0400", hash_original_field = "CE1576C94D2F8F975B0823F778718192", hash_generated_field = "5D2DFEA6D297ABF43DA859264DB0C963")

    private static long serialVersionUID = 2340985798034038923L;
}

