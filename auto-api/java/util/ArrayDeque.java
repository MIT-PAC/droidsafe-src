package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

import java.io.*;

public class ArrayDeque<E> extends AbstractCollection<E> implements Deque<E>, Cloneable, Serializable {
    private transient E[] elements;
    private transient int head;
    private transient int tail;
    private static final int MIN_INITIAL_CAPACITY = 8;
    private static final long serialVersionUID = 2340985798034038923L;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:20.921 -0400", hash_original_method = "8C7B174379DD3B2C843811B1130834BD", hash_generated_method = "E54E50868A62AFBFDEE145AD1E467BC3")
    @DSModeled(DSC.SAFE)
    public ArrayDeque() {
        elements = (E[]) new Object[16];
        // ---------- Original Method ----------
        //elements = (E[]) new Object[16];
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:20.925 -0400", hash_original_method = "690593276EDD66C533F49BEE09E9C663", hash_generated_method = "33EA45277D14C3E8A9302F40B66CB8C5")
    @DSModeled(DSC.SAFE)
    public ArrayDeque(int numElements) {
        dsTaint.addTaint(numElements);
        allocateElements(numElements);
        // ---------- Original Method ----------
        //allocateElements(numElements);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:20.928 -0400", hash_original_method = "5E7B6C878951D7CA458070D073F03065", hash_generated_method = "41A1F99A93892F2BCABAA771FE36AB66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayDeque(Collection<? extends E> c) {
        dsTaint.addTaint(c.dsTaint);
        allocateElements(c.size());
        addAll(c);
        // ---------- Original Method ----------
        //allocateElements(c.size());
        //addAll(c);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:20.937 -0400", hash_original_method = "86AF4C096D752C20A8CB0D886E79B7FB", hash_generated_method = "4F8360955586193D76A9F9E7E2838D67")
    @DSModeled(DSC.SAFE)
    private void allocateElements(int numElements) {
        dsTaint.addTaint(numElements);
        int initialCapacity;
        initialCapacity = MIN_INITIAL_CAPACITY;
        {
            initialCapacity = numElements;
            initialCapacity |= (initialCapacity >>>  1);
            initialCapacity |= (initialCapacity >>>  2);
            initialCapacity |= (initialCapacity >>>  4);
            initialCapacity |= (initialCapacity >>>  8);
            initialCapacity |= (initialCapacity >>> 16);
            initialCapacity++;
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:20.951 -0400", hash_original_method = "35225802D7F18BE5673FDDFDE4B70B2E", hash_generated_method = "76A82A2B35382DC533FC3EF04159DA15")
    @DSModeled(DSC.SAFE)
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:20.970 -0400", hash_original_method = "5E8669E32F5C4FDF3D4D82BA2C3949A2", hash_generated_method = "7DB6CEAFD074ECC4B7B8623BFB31C9D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private <T> T[] copyElements(T[] a) {
        dsTaint.addTaint(a[0].dsTaint);
        {
            System.arraycopy(elements, head, a, 0, size());
        } //End block
        {
            int headPortionLen;
            headPortionLen = elements.length - head;
            System.arraycopy(elements, head, a, 0, headPortionLen);
            System.arraycopy(elements, 0, a, headPortionLen, tail);
        } //End block
        return (T[])dsTaint.getTaint();
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:20.974 -0400", hash_original_method = "CBAC64602FF2D7F893923E0ABA8C507E", hash_generated_method = "A6AED8638E3010A813C7996FC8AA4C01")
    @DSModeled(DSC.SAFE)
    public void addFirst(E e) {
        dsTaint.addTaint(e.dsTaint);
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:20.980 -0400", hash_original_method = "1B31DB8E2D035FB7799256F8004C4036", hash_generated_method = "48A0786BABE288C0C002C6BE9C09DC4A")
    @DSModeled(DSC.SAFE)
    public void addLast(E e) {
        dsTaint.addTaint(e.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        elements[tail] = e;
        {
            boolean var7F88578DCEE369DCF633CD33646CC15C_1936708384 = ((tail = (tail + 1) & (elements.length - 1)) == head);
            doubleCapacity();
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (e == null)
            //throw new NullPointerException();
        //elements[tail] = e;
        //if ( (tail = (tail + 1) & (elements.length - 1)) == head)
            //doubleCapacity();
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:20.983 -0400", hash_original_method = "8D3228F5DEFAE0131B22F51707654BE0", hash_generated_method = "C592B6BD62C792E7B7BCD9A4F97F3C13")
    @DSModeled(DSC.SAFE)
    public boolean offerFirst(E e) {
        dsTaint.addTaint(e.dsTaint);
        addFirst(e);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //addFirst(e);
        //return true;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:20.989 -0400", hash_original_method = "15C090CE1A98280B8C8C7B6514A10013", hash_generated_method = "623B3E5F8C7D894BB6AA532AD53084C2")
    @DSModeled(DSC.SAFE)
    public boolean offerLast(E e) {
        dsTaint.addTaint(e.dsTaint);
        addLast(e);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //addLast(e);
        //return true;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:20.997 -0400", hash_original_method = "8D1F2D8C9F4BF8EC3B65B975014CE8A7", hash_generated_method = "0654F91391C82D0D52A75AAD0E08C916")
    @DSModeled(DSC.SAFE)
    public E removeFirst() {
        E x;
        x = pollFirst();
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //E x = pollFirst();
        //if (x == null)
            //throw new NoSuchElementException();
        //return x;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.004 -0400", hash_original_method = "90A521D0942C6C4821F3F861C2808726", hash_generated_method = "FCB80AA2C4E50F44A8EEFC0572283D46")
    @DSModeled(DSC.SAFE)
    public E removeLast() {
        E x;
        x = pollLast();
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //E x = pollLast();
        //if (x == null)
            //throw new NoSuchElementException();
        //return x;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.016 -0400", hash_original_method = "70BCEEA789C7C02318BA6052E8B29D53", hash_generated_method = "41259401304A8838315E2C74AFB6EE15")
    @DSModeled(DSC.SAFE)
    public E pollFirst() {
        int h;
        h = head;
        E result;
        result = elements[h];
        elements[h] = null;
        head = (h + 1) & (elements.length - 1);
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int h = head;
        //E result = elements[h];
        //if (result == null)
            //return null;
        //elements[h] = null;
        //head = (h + 1) & (elements.length - 1);
        //return result;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.020 -0400", hash_original_method = "CC3133A0441CFBBC149D7C0D4094D190", hash_generated_method = "421D5B89358CECE525494D0BE82FCA22")
    @DSModeled(DSC.SAFE)
    public E pollLast() {
        int t;
        t = (tail - 1) & (elements.length - 1);
        E result;
        result = elements[t];
        elements[t] = null;
        tail = t;
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int t = (tail - 1) & (elements.length - 1);
        //E result = elements[t];
        //if (result == null)
            //return null;
        //elements[t] = null;
        //tail = t;
        //return result;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.033 -0400", hash_original_method = "969C370DEEB1254D835EA60A850D9474", hash_generated_method = "D5E97FABA934B2C95BFB83660276B04D")
    @DSModeled(DSC.SAFE)
    public E getFirst() {
        E x;
        x = elements[head];
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //E x = elements[head];
        //if (x == null)
            //throw new NoSuchElementException();
        //return x;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.045 -0400", hash_original_method = "609D7D9752B1EA7B409577881D715ECB", hash_generated_method = "0BEE2DCECD6D6E26CEBC6C119C80F806")
    @DSModeled(DSC.SAFE)
    public E getLast() {
        E x;
        x = elements[(tail - 1) & (elements.length - 1)];
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //E x = elements[(tail - 1) & (elements.length - 1)];
        //if (x == null)
            //throw new NoSuchElementException();
        //return x;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.047 -0400", hash_original_method = "1112FC6950CD2F89C0F90F3FD6940182", hash_generated_method = "161F5718A678BE654E3CD7445E64205B")
    @DSModeled(DSC.SAFE)
    public E peekFirst() {
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return elements[head];
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.049 -0400", hash_original_method = "2FB93C1E4553786B68715ADDCB3204FE", hash_generated_method = "83AC0D942C1D0EACEFACDB0DE853A1A1")
    @DSModeled(DSC.SAFE)
    public E peekLast() {
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return elements[(tail - 1) & (elements.length - 1)];
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.059 -0400", hash_original_method = "2655E37A6129D552BDB18D712FBDBB78", hash_generated_method = "523F6877B66433388C363EE2F0F14EEF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean removeFirstOccurrence(Object o) {
        dsTaint.addTaint(o.dsTaint);
        int mask;
        mask = elements.length - 1;
        int i;
        i = head;
        E x;
        {
            boolean var1329AA2C156BE9C813DA2AD363D45946_1761750717 = ((x = elements[i]) != null);
            {
                {
                    boolean var8C3257AD3EAB1DB4919EC2B6E1BD3609_1925848378 = (o.equals(x));
                    {
                        delete(i);
                    } //End block
                } //End collapsed parenthetic
                i = (i + 1) & mask;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.071 -0400", hash_original_method = "67D061371E16CEF717EF2A58AA73F6CB", hash_generated_method = "C1A21DC346AFBBA1E97A3423E5591FC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean removeLastOccurrence(Object o) {
        dsTaint.addTaint(o.dsTaint);
        int mask;
        mask = elements.length - 1;
        int i;
        i = (tail - 1) & mask;
        E x;
        {
            boolean var1329AA2C156BE9C813DA2AD363D45946_1739252890 = ((x = elements[i]) != null);
            {
                {
                    boolean var8C3257AD3EAB1DB4919EC2B6E1BD3609_960166812 = (o.equals(x));
                    {
                        delete(i);
                    } //End block
                } //End collapsed parenthetic
                i = (i - 1) & mask;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.078 -0400", hash_original_method = "056B268263D9E7E4C2239F12D1024514", hash_generated_method = "4A8C0B70B6D5558934C2FEA7DB6D6F3D")
    @DSModeled(DSC.SAFE)
    public boolean add(E e) {
        dsTaint.addTaint(e.dsTaint);
        addLast(e);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //addLast(e);
        //return true;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.080 -0400", hash_original_method = "90158A89D183AFC9420F99CD4C19A119", hash_generated_method = "882CDD562A8B40B3512ADBAC3F6B4DA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean offer(E e) {
        dsTaint.addTaint(e.dsTaint);
        boolean var1C8D098E0D25C154182D97F2DFA9E90F_1617889491 = (offerLast(e));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return offerLast(e);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.088 -0400", hash_original_method = "5200E72EC4A7AF0A97DAC56CA915551B", hash_generated_method = "762D69EEFD46F5FB3F0ED6D21B250DC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E remove() {
        E var9618F1EE3794F973149A1F955F9C4810_1641681413 = (removeFirst());
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return removeFirst();
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.091 -0400", hash_original_method = "D6F4991F5239518842015971CA437CF0", hash_generated_method = "52B507BF31A3CFC493BC322D66BD489F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E poll() {
        E varD3ED620EAF86151359736BDC9ACD315E_775126150 = (pollFirst());
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return pollFirst();
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.093 -0400", hash_original_method = "C3B5A6F3A12E32CB352921DD8911C7F3", hash_generated_method = "944AEA9F0B17F8A02727AE0B6A792A67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E element() {
        E var58DD305D38CE085F5069F0E1FAACA46E_930833792 = (getFirst());
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getFirst();
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.101 -0400", hash_original_method = "A003E27ECA2FE3193555598EEC98E09D", hash_generated_method = "FA72561DA4A57EBD5D605F25EF5FD1D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E peek() {
        E varC18B05CCC3587F9766AC9846B6CD4DAB_1544569728 = (peekFirst());
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return peekFirst();
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.103 -0400", hash_original_method = "848DD27BB905F5A807C52ED75E19F6C3", hash_generated_method = "D45DE2705EB9AE2AFF1379F41F6852EF")
    @DSModeled(DSC.SAFE)
    public void push(E e) {
        dsTaint.addTaint(e.dsTaint);
        addFirst(e);
        // ---------- Original Method ----------
        //addFirst(e);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.112 -0400", hash_original_method = "158DA4E81D3B40D802055686181E6101", hash_generated_method = "FF91FD219AB29A4038F4AE41D3FA8B17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E pop() {
        E var9618F1EE3794F973149A1F955F9C4810_349103786 = (removeFirst());
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return removeFirst();
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.114 -0400", hash_original_method = "BBF79E0ADE5790277B99F1D7AA727B20", hash_generated_method = "91526078795BBC453C893D53B2735210")
    @DSModeled(DSC.SAFE)
    private void checkInvariants() {
        // ---------- Original Method ----------
        //assert elements[tail] == null;
        //assert head == tail ? elements[head] == null :
            //(elements[head] != null &&
             //elements[(tail - 1) & (elements.length - 1)] != null);
        //assert elements[(head - 1) & (elements.length - 1)] == null;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.123 -0400", hash_original_method = "6B28B7CDDDC5837E98E272935A4DA74A", hash_generated_method = "08C0E4CE2213E6D29A7F260EC63F0E02")
    @DSModeled(DSC.SAFE)
    private boolean delete(int i) {
        dsTaint.addTaint(i);
        checkInvariants();
        final E[] elements;
        elements = this.elements;
        final int mask;
        mask = elements.length - 1;
        final int h;
        h = head;
        final int t;
        t = tail;
        final int front;
        front = (i - h) & mask;
        final int back;
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.138 -0400", hash_original_method = "D58AA3C48B1B36CF35B203F4633D4120", hash_generated_method = "FE9979EBBAC3EB42CC30270108E229F6")
    @DSModeled(DSC.SAFE)
    public int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (tail - head) & (elements.length - 1);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.144 -0400", hash_original_method = "029A9450FF46747D2F1AB4761630FBFA", hash_generated_method = "2E780238ED59BCD087C75AF0E9A3358E")
    @DSModeled(DSC.SAFE)
    public boolean isEmpty() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return head == tail;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.146 -0400", hash_original_method = "ECCE71EADB88CB0EFABEE24B7316B6D0", hash_generated_method = "4003A5821724025CF32BCDC8F37488DD")
    @DSModeled(DSC.SAFE)
    public Iterator<E> iterator() {
        return (Iterator<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new DeqIterator();
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.148 -0400", hash_original_method = "09A6B8B983928A3C88383EF59752C844", hash_generated_method = "C2B4D1D1969C76E33D4618406428183C")
    @DSModeled(DSC.SAFE)
    public Iterator<E> descendingIterator() {
        return (Iterator<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new DescendingIterator();
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.151 -0400", hash_original_method = "76B0F415E6F814FE548D14BC6D5843EE", hash_generated_method = "ADFDB1F900BC72CE919BC89B1FEF360F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean contains(Object o) {
        dsTaint.addTaint(o.dsTaint);
        int mask;
        mask = elements.length - 1;
        int i;
        i = head;
        E x;
        {
            boolean var1329AA2C156BE9C813DA2AD363D45946_1265937243 = ((x = elements[i]) != null);
            {
                {
                    boolean var8C3257AD3EAB1DB4919EC2B6E1BD3609_815222096 = (o.equals(x));
                } //End collapsed parenthetic
                i = (i + 1) & mask;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.153 -0400", hash_original_method = "953726349F424E37042C19BD0C0A52B8", hash_generated_method = "C4FE138D11EC51FA456044FD29D3072E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean remove(Object o) {
        dsTaint.addTaint(o.dsTaint);
        boolean varB3B6A07AEF87793955942F9770654762_965776641 = (removeFirstOccurrence(o));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return removeFirstOccurrence(o);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.158 -0400", hash_original_method = "AB065CB5BA1D923138DE6DFF9B806E2B", hash_generated_method = "B456BF095625F5296BE24BE48DB89DA3")
    @DSModeled(DSC.SAFE)
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.162 -0400", hash_original_method = "33D76C50C1E8C0374668B986897D9D9E", hash_generated_method = "492F3C824634675D67A843F94937E5DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object[] toArray() {
        Object[] varA6F150C326F7123F8EB50A189C86BABA_1885305818 = (copyElements(new Object[size()]));
        return (Object[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return copyElements(new Object[size()]);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.176 -0400", hash_original_method = "38034B8DDDAB71FC35937F12D964AD07", hash_generated_method = "39D0C6BDD7A004846B21D80B50D737E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public <T> T[] toArray(T[] a) {
        dsTaint.addTaint(a[0].dsTaint);
        int size;
        size = size();
        a = (T[])java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size);
        copyElements(a);
        a[size] = null;
        return (T[])dsTaint.getTaint();
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.186 -0400", hash_original_method = "A2826FA19E4353225E0757D076E8282A", hash_generated_method = "E0856182718553577691DFAF9AAEC7AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayDeque<E> clone() {
        try
        {
            ArrayDeque<E> result;
            result = (ArrayDeque<E>) super.clone();
            result.elements = Arrays.copyOf(elements, elements.length);
            return (ArrayDeque<E>)dsTaint.getTaint();
        } //End block
        catch (CloneNotSupportedException e){
            if (DroidSafeAndroidRuntime.control) throw new AssertionError();
            return null;
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.190 -0400", hash_original_method = "5A84D35A2C5A040CC18139106D665D0E", hash_generated_method = "35B1E38B13225709151D19D045D24ADF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(ObjectOutputStream s) throws IOException {
        dsTaint.addTaint(s.dsTaint);
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
        // ---------- Original Method ----------
        //s.defaultWriteObject();
        //s.writeInt(size());
        //int mask = elements.length - 1;
        //for (int i = head; i != tail; i = (i + 1) & mask)
            //s.writeObject(elements[i]);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.197 -0400", hash_original_method = "ABF871D717FCC2D87CA02E500CE54CBF", hash_generated_method = "6CD65B772A0BAAF80E12AC8B7216E867")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        dsTaint.addTaint(s.dsTaint);
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
        private int cursor = head;
        private int fence = tail;
        private int lastRet = -1;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.200 -0400", hash_original_method = "8D6FDA09A878582CCF6BFDDE96A3C673", hash_generated_method = "5B330917F9E390B5DEDA241289ADA061")
        @DSModeled(DSC.SAFE)
        public boolean hasNext() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return cursor != fence;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.209 -0400", hash_original_method = "9CABF9BA27B0EE6B683FFA8F5EC2BB0E", hash_generated_method = "9C05F365FB62BB7AEDDCEE27984CEBE0")
        @DSModeled(DSC.SAFE)
        public E next() {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            E result;
            result = elements[cursor];
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            lastRet = cursor;
            cursor = (cursor + 1) & (elements.length - 1);
            return (E)dsTaint.getTaint();
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


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.214 -0400", hash_original_method = "A6EE424EC418974FAC2A0A9E736B0189", hash_generated_method = "50B20367B6C12E6E7EBE6929178B4801")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void remove() {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            {
                boolean varC9E761FAC14702C2B623BE027E2F7281_1632053387 = (delete(lastRet));
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
        private int cursor = tail;
        private int fence = head;
        private int lastRet = -1;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.216 -0400", hash_original_method = "8D6FDA09A878582CCF6BFDDE96A3C673", hash_generated_method = "5B330917F9E390B5DEDA241289ADA061")
        @DSModeled(DSC.SAFE)
        public boolean hasNext() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return cursor != fence;
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.222 -0400", hash_original_method = "5248F2967157124DAD3A5B8F2BA1B9D6", hash_generated_method = "2DB9B6C00729710567D8A23D4455B59C")
        @DSModeled(DSC.SAFE)
        public E next() {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            cursor = (cursor - 1) & (elements.length - 1);
            E result;
            result = elements[cursor];
            if (DroidSafeAndroidRuntime.control) throw new ConcurrentModificationException();
            lastRet = cursor;
            return (E)dsTaint.getTaint();
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


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:58:21.232 -0400", hash_original_method = "C558887990F4F262B85810625D57822A", hash_generated_method = "3D3BA5FB2632B9D101EBE20819F2A125")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void remove() {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            {
                boolean var3942AF7F654E16207FF88B33EBA55990_1322415124 = (!delete(lastRet));
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



}


