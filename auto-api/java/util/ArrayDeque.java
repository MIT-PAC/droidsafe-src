package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.*;

public class ArrayDeque<E> extends AbstractCollection<E> implements Deque<E>, Cloneable, Serializable {
    private transient E[] elements;
    private transient int head;
    private transient int tail;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.905 -0400", hash_original_method = "8C7B174379DD3B2C843811B1130834BD", hash_generated_method = "151203C88A4AC41E68C2D3AED6B6A179")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayDeque() {
        elements = (E[]) new Object[16];
        // ---------- Original Method ----------
        //elements = (E[]) new Object[16];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.905 -0400", hash_original_method = "690593276EDD66C533F49BEE09E9C663", hash_generated_method = "802B3E1607ED936A7675C9BBCB26CB04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayDeque(int numElements) {
        dsTaint.addTaint(numElements);
        allocateElements(numElements);
        // ---------- Original Method ----------
        //allocateElements(numElements);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.905 -0400", hash_original_method = "5E7B6C878951D7CA458070D073F03065", hash_generated_method = "5C842A5607373CA5B8E71AAC40B1A9C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayDeque(Collection<? extends E> c) {
        dsTaint.addTaint(c.dsTaint);
        allocateElements(c.size());
        addAll(c);
        // ---------- Original Method ----------
        //allocateElements(c.size());
        //addAll(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.906 -0400", hash_original_method = "86AF4C096D752C20A8CB0D886E79B7FB", hash_generated_method = "0EA557CEBBA95B4A6E26E6348C8FA929")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.906 -0400", hash_original_method = "35225802D7F18BE5673FDDFDE4B70B2E", hash_generated_method = "456FB0945A4044D9A5C32B631DAA4D26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.906 -0400", hash_original_method = "5E8669E32F5C4FDF3D4D82BA2C3949A2", hash_generated_method = "9D08CDE9406618A29C401BFE3E4B0DCD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.906 -0400", hash_original_method = "CBAC64602FF2D7F893923E0ABA8C507E", hash_generated_method = "2F1BDC6782ADAB65D839AB12CD11421F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.907 -0400", hash_original_method = "1B31DB8E2D035FB7799256F8004C4036", hash_generated_method = "F17D1FFF404DFCE1E2039C9AC4582D12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addLast(E e) {
        dsTaint.addTaint(e.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        elements[tail] = e;
        {
            boolean var7F88578DCEE369DCF633CD33646CC15C_941230310 = ((tail = (tail + 1) & (elements.length - 1)) == head);
            doubleCapacity();
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (e == null)
            //throw new NullPointerException();
        //elements[tail] = e;
        //if ( (tail = (tail + 1) & (elements.length - 1)) == head)
            //doubleCapacity();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.907 -0400", hash_original_method = "8D3228F5DEFAE0131B22F51707654BE0", hash_generated_method = "84BF475F9A2A164286EA35200459B50A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean offerFirst(E e) {
        dsTaint.addTaint(e.dsTaint);
        addFirst(e);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //addFirst(e);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.907 -0400", hash_original_method = "15C090CE1A98280B8C8C7B6514A10013", hash_generated_method = "C59FA0C155672924C530570154A38CF3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean offerLast(E e) {
        dsTaint.addTaint(e.dsTaint);
        addLast(e);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //addLast(e);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.907 -0400", hash_original_method = "8D1F2D8C9F4BF8EC3B65B975014CE8A7", hash_generated_method = "10832A48586B99054DA2D526BDB911DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.907 -0400", hash_original_method = "90A521D0942C6C4821F3F861C2808726", hash_generated_method = "F149DA6F41DB7528885880DA7193ACB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.908 -0400", hash_original_method = "70BCEEA789C7C02318BA6052E8B29D53", hash_generated_method = "4EA37E9694BE2403DFB2A06028FBC385")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.908 -0400", hash_original_method = "CC3133A0441CFBBC149D7C0D4094D190", hash_generated_method = "8D2CA8A70F28B7DB671BEBED0A29F307")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.908 -0400", hash_original_method = "969C370DEEB1254D835EA60A850D9474", hash_generated_method = "408E7FFF87B6556D0AC410CB39326866")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.908 -0400", hash_original_method = "609D7D9752B1EA7B409577881D715ECB", hash_generated_method = "AAD664E1427A050EF45F98600FF43037")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.908 -0400", hash_original_method = "1112FC6950CD2F89C0F90F3FD6940182", hash_generated_method = "58B5678F17F5B3E83C33D59FF60327DC")
    @DSModeled(DSC.SAFE)
    public E peekFirst() {
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return elements[head];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.909 -0400", hash_original_method = "2FB93C1E4553786B68715ADDCB3204FE", hash_generated_method = "1B0E4B2CA61654D8CE53BD5E782260F7")
    @DSModeled(DSC.SAFE)
    public E peekLast() {
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return elements[(tail - 1) & (elements.length - 1)];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.909 -0400", hash_original_method = "2655E37A6129D552BDB18D712FBDBB78", hash_generated_method = "4A13EDB04E4D7423BB011F7F536DD5DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean removeFirstOccurrence(Object o) {
        dsTaint.addTaint(o.dsTaint);
        int mask;
        mask = elements.length - 1;
        int i;
        i = head;
        E x;
        {
            boolean var1329AA2C156BE9C813DA2AD363D45946_1007031554 = ((x = elements[i]) != null);
            {
                {
                    boolean var8C3257AD3EAB1DB4919EC2B6E1BD3609_1954150224 = (o.equals(x));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.909 -0400", hash_original_method = "67D061371E16CEF717EF2A58AA73F6CB", hash_generated_method = "311D1672060C51606684A2BF9FD4145F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean removeLastOccurrence(Object o) {
        dsTaint.addTaint(o.dsTaint);
        int mask;
        mask = elements.length - 1;
        int i;
        i = (tail - 1) & mask;
        E x;
        {
            boolean var1329AA2C156BE9C813DA2AD363D45946_556760814 = ((x = elements[i]) != null);
            {
                {
                    boolean var8C3257AD3EAB1DB4919EC2B6E1BD3609_1072848688 = (o.equals(x));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.909 -0400", hash_original_method = "056B268263D9E7E4C2239F12D1024514", hash_generated_method = "B44EDCC5B58449239A191FB159C94BB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean add(E e) {
        dsTaint.addTaint(e.dsTaint);
        addLast(e);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //addLast(e);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.910 -0400", hash_original_method = "90158A89D183AFC9420F99CD4C19A119", hash_generated_method = "7DA5BB93CE7DDD63B090EBFC130AC42B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean offer(E e) {
        dsTaint.addTaint(e.dsTaint);
        boolean var1C8D098E0D25C154182D97F2DFA9E90F_942733303 = (offerLast(e));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return offerLast(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.910 -0400", hash_original_method = "5200E72EC4A7AF0A97DAC56CA915551B", hash_generated_method = "FE1E79A05F4627663516B63476EBCE77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E remove() {
        E var9618F1EE3794F973149A1F955F9C4810_1607488124 = (removeFirst());
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return removeFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.910 -0400", hash_original_method = "D6F4991F5239518842015971CA437CF0", hash_generated_method = "D2D51395792408008DF5B9F6AA17D3F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E poll() {
        E varD3ED620EAF86151359736BDC9ACD315E_683561937 = (pollFirst());
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return pollFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.910 -0400", hash_original_method = "C3B5A6F3A12E32CB352921DD8911C7F3", hash_generated_method = "ACBE8E8D8B6522B7B8DF0333A02B7E95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E element() {
        E var58DD305D38CE085F5069F0E1FAACA46E_547027814 = (getFirst());
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.910 -0400", hash_original_method = "A003E27ECA2FE3193555598EEC98E09D", hash_generated_method = "A97C676338AB278F7003AF28213A9545")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E peek() {
        E varC18B05CCC3587F9766AC9846B6CD4DAB_1505964621 = (peekFirst());
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return peekFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.910 -0400", hash_original_method = "848DD27BB905F5A807C52ED75E19F6C3", hash_generated_method = "00F1B7F4842DCBC81A08CDD44FD5A714")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void push(E e) {
        dsTaint.addTaint(e.dsTaint);
        addFirst(e);
        // ---------- Original Method ----------
        //addFirst(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.911 -0400", hash_original_method = "158DA4E81D3B40D802055686181E6101", hash_generated_method = "0E20F3BFE67019EE0BDA92B966185EC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E pop() {
        E var9618F1EE3794F973149A1F955F9C4810_1291368688 = (removeFirst());
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return removeFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.911 -0400", hash_original_method = "BBF79E0ADE5790277B99F1D7AA727B20", hash_generated_method = "1D9C6F57BCDE2C7294D7BB32ACA5DF67")
    @DSModeled(DSC.SAFE)
    private void checkInvariants() {
        // ---------- Original Method ----------
        //assert elements[tail] == null;
        //assert head == tail ? elements[head] == null :
            //(elements[head] != null &&
             //elements[(tail - 1) & (elements.length - 1)] != null);
        //assert elements[(head - 1) & (elements.length - 1)] == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.911 -0400", hash_original_method = "6B28B7CDDDC5837E98E272935A4DA74A", hash_generated_method = "BB1F1A63FC47F5725E79F5C8B0F81D98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean delete(int i) {
        dsTaint.addTaint(i);
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.912 -0400", hash_original_method = "D58AA3C48B1B36CF35B203F4633D4120", hash_generated_method = "E49C956B914B31412344590788729711")
    @DSModeled(DSC.SAFE)
    public int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (tail - head) & (elements.length - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.912 -0400", hash_original_method = "029A9450FF46747D2F1AB4761630FBFA", hash_generated_method = "E771924490E430C992B9E09604998555")
    @DSModeled(DSC.SAFE)
    public boolean isEmpty() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return head == tail;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.912 -0400", hash_original_method = "ECCE71EADB88CB0EFABEE24B7316B6D0", hash_generated_method = "F6D67D4EB53E76369F1557E47C9B383C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Iterator<E> iterator() {
        Iterator<E> var32E86CD73FE182026371A5B5B728FB14_1401551458 = (new DeqIterator());
        return (Iterator<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new DeqIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.912 -0400", hash_original_method = "09A6B8B983928A3C88383EF59752C844", hash_generated_method = "44EEDF9A8EF5C819F575EC8A378FDEDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Iterator<E> descendingIterator() {
        Iterator<E> var2C808ED2EBDD783D41D2A502283D827B_1496398347 = (new DescendingIterator());
        return (Iterator<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new DescendingIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.913 -0400", hash_original_method = "76B0F415E6F814FE548D14BC6D5843EE", hash_generated_method = "0E08093FA95615C766E216CE602416DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean contains(Object o) {
        dsTaint.addTaint(o.dsTaint);
        int mask;
        mask = elements.length - 1;
        int i;
        i = head;
        E x;
        {
            boolean var1329AA2C156BE9C813DA2AD363D45946_738120454 = ((x = elements[i]) != null);
            {
                {
                    boolean var8C3257AD3EAB1DB4919EC2B6E1BD3609_1578009130 = (o.equals(x));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.913 -0400", hash_original_method = "953726349F424E37042C19BD0C0A52B8", hash_generated_method = "FFA9F366D2BD1DB0403FCD392A20CAD1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean remove(Object o) {
        dsTaint.addTaint(o.dsTaint);
        boolean varB3B6A07AEF87793955942F9770654762_831350758 = (removeFirstOccurrence(o));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return removeFirstOccurrence(o);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.913 -0400", hash_original_method = "AB065CB5BA1D923138DE6DFF9B806E2B", hash_generated_method = "46BF4EA79B8F3F655FE56357D4AF4ABB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.913 -0400", hash_original_method = "33D76C50C1E8C0374668B986897D9D9E", hash_generated_method = "2325304DCBADB9449AC78D42C097AA21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object[] toArray() {
        Object[] varA6F150C326F7123F8EB50A189C86BABA_18595132 = (copyElements(new Object[size()]));
        return (Object[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return copyElements(new Object[size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.914 -0400", hash_original_method = "38034B8DDDAB71FC35937F12D964AD07", hash_generated_method = "16C7E8B4F82EFB2B9A8E6D540480A688")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.914 -0400", hash_original_method = "A2826FA19E4353225E0757D076E8282A", hash_generated_method = "8D4B04D8D8CDC46E6EF89EF14AA3C6A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayDeque<E> clone() {
        try 
        {
            ArrayDeque<E> result;
            result = (ArrayDeque<E>) super.clone();
            result.elements = Arrays.copyOf(elements, elements.length);
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        } //End block
        return (ArrayDeque<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //ArrayDeque<E> result = (ArrayDeque<E>) super.clone();
            //result.elements = Arrays.copyOf(elements, elements.length);
            //return result;
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.914 -0400", hash_original_method = "5A84D35A2C5A040CC18139106D665D0E", hash_generated_method = "E7EA9BDA11923DC78D73B3EAF5FD96BD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.915 -0400", hash_original_method = "ABF871D717FCC2D87CA02E500CE54CBF", hash_generated_method = "91B3D1DDF0E6932EF4C4C5BE0AF09FC8")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.915 -0400", hash_original_method = "0516B832B778E31940D68CA241694899", hash_generated_method = "0516B832B778E31940D68CA241694899")
                public DeqIterator ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.915 -0400", hash_original_method = "8D6FDA09A878582CCF6BFDDE96A3C673", hash_generated_method = "F81C8AFCBF34ADF078406494668486FE")
        @DSModeled(DSC.SAFE)
        public boolean hasNext() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return cursor != fence;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.915 -0400", hash_original_method = "9CABF9BA27B0EE6B683FFA8F5EC2BB0E", hash_generated_method = "1142B36F77C2A3044754A6716A3675B2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.915 -0400", hash_original_method = "A6EE424EC418974FAC2A0A9E736B0189", hash_generated_method = "29AFF10A9B656D1F9F28C78AB69B4E6D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void remove() {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            {
                boolean varC9E761FAC14702C2B623BE027E2F7281_1697351941 = (delete(lastRet));
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.916 -0400", hash_original_method = "D95347399862EFD8904DAFA3C99422E6", hash_generated_method = "D95347399862EFD8904DAFA3C99422E6")
                public DescendingIterator ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.916 -0400", hash_original_method = "8D6FDA09A878582CCF6BFDDE96A3C673", hash_generated_method = "F81C8AFCBF34ADF078406494668486FE")
        @DSModeled(DSC.SAFE)
        public boolean hasNext() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return cursor != fence;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.917 -0400", hash_original_method = "5248F2967157124DAD3A5B8F2BA1B9D6", hash_generated_method = "D91CCEB97E289B4C948ECF6838C06854")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.918 -0400", hash_original_method = "C558887990F4F262B85810625D57822A", hash_generated_method = "B850D3DA90D17B465B09E3967626358C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void remove() {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            {
                boolean var3942AF7F654E16207FF88B33EBA55990_1630564895 = (!delete(lastRet));
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


    
    private static final int MIN_INITIAL_CAPACITY = 8;
    private static final long serialVersionUID = 2340985798034038923L;
}

