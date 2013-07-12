package java.util.concurrent;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ConcurrentLinkedQueue<E> extends AbstractQueue<E> implements Queue<E>, java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.615 -0400", hash_original_field = "96E89A298E0A9F469B9AE458D6AFAE9F", hash_generated_field = "B57EDCA0C5D8B188A31356A19160405D")

    private transient volatile Node<E> head;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.615 -0400", hash_original_field = "7AEA2552DFE7EB84B9443B6FC9BA6E01", hash_generated_field = "44C1E7DD6E43696E7B1931FD10B83ECF")

    private transient volatile Node<E> tail;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.616 -0400", hash_original_method = "6A57FB745E5D860E38239AF0DB1591EF", hash_generated_method = "38B3499791573BCF992A48C491B8F223")
    public  ConcurrentLinkedQueue() {
        head = tail = new Node<E>(null);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.617 -0400", hash_original_method = "6F01EA166BC3601049062B90A5587D9E", hash_generated_method = "CBA4B15CAEA0C43B4F30FE78B169603F")
    public  ConcurrentLinkedQueue(Collection<? extends E> c) {
        addTaint(c.getTaint());
        Node<E> h = null;
        Node<E> t = null;
for(E e : c)
        {
            checkNotNull(e);
            Node<E> newNode = new Node<E>(e);
    if(h == null)            
            h = t = newNode;
            else
            {
                t.lazySetNext(newNode);
                t = newNode;
            } 
        } 
    if(h == null)        
        h = t = new Node<E>(null);
        head = h;
        tail = t;
        
        
        
            
            
            
                
            
                
                
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.618 -0400", hash_original_method = "F77A4F330ECF7476CC7AF200B57EFA7F", hash_generated_method = "73621D22A480AA6007B3F5730DCBCB36")
    public boolean add(E e) {
        addTaint(e.getTaint());
        boolean var753C0332450253282F40FDC9097055BE_1842559179 = (offer(e));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_181244718 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_181244718;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.619 -0400", hash_original_method = "73F32BBDAFE1515404B45EC2F1869A3A", hash_generated_method = "712D2CE041D3BC5E79F9C66171CEC302")
    final void updateHead(Node<E> h, Node<E> p) {
        addTaint(p.getTaint());
        addTaint(h.getTaint());
    if(h != p && casHead(h, p))        
        h.lazySetNext(h);
        
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.620 -0400", hash_original_method = "FA81D040C1BC0670D20AF3D93B255BE4", hash_generated_method = "3172FB58C06F1572F6876EEC1DEF8E1A")
    final Node<E> succ(Node<E> p) {
        addTaint(p.getTaint());
        Node<E> next = p.next;
Node<E> var38526534D800D5249E337269E6B24E55_979391048 =         (p == next) ? head : next;
        var38526534D800D5249E337269E6B24E55_979391048.addTaint(taint);
        return var38526534D800D5249E337269E6B24E55_979391048;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.621 -0400", hash_original_method = "6C2ABD9F3905A9D98C3CBF8AF5320B8C", hash_generated_method = "62AB9318C38374A750A7DC197BF7E3D4")
    public boolean offer(E e) {
        addTaint(e.getTaint());
        checkNotNull(e);
        final Node<E> newNode = new Node<E>(e);
for(Node<E> t = tail, p = t;;)
        {
            Node<E> q = p.next;
    if(q == null)            
            {
    if(p.casNext(null, newNode))                
                {
    if(p != t)                    
                    casTail(t, newNode);
                    boolean varB326B5062B2F0E69046810717534CB09_801218061 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_323601211 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_323601211;
                } 
            } 
            else
    if(p == q)            
            p = (t != (t = tail)) ? t : head;
            else
            p = (p != t && t != (t = tail)) ? t : q;
        } 
        
        
        
        
            
            
                
                    
                        
                    
                
            
            
                
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.623 -0400", hash_original_method = "1F662EFABD15CE7BE1315E55CBBE7D30", hash_generated_method = "9907BE538E6E326DC40D73EB187B3486")
    public E poll() {
    restartFromHead        :
for(;;)
        {
for(Node<E> h = head, p = h, q;;)
            {
                E item = p.item;
    if(item != null && p.casItem(item, null))                
                {
    if(p != h)                    
                    updateHead(h, ((q = p.next) != null) ? q : p);
E var393CF4FD24220F0ED4B080A1E7108CD3_1865927953 =                     item;
                    var393CF4FD24220F0ED4B080A1E7108CD3_1865927953.addTaint(taint);
                    return var393CF4FD24220F0ED4B080A1E7108CD3_1865927953;
                } 
                else
    if((q = p.next) == null)                
                {
                    updateHead(h, p);
E var540C13E9E156B687226421B24F2DF178_1030503427 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1030503427.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1030503427;
                } 
                else
    if(p == q)                
                continue restartFromHead;
                else
                p = q;
            } 
        } 
        
        
        
            
                
                
                    
                        
                    
                
                
                    
                    
                
                
                    
                
                    
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.623 -0400", hash_original_method = "61FBF64CA94D04AD27A6643CEF7D7285", hash_generated_method = "679CD731733281D2E5DBC4FFB5C885C4")
    public E peek() {
    restartFromHead        :
for(;;)
        {
for(Node<E> h = head, p = h, q;;)
            {
                E item = p.item;
    if(item != null || (q = p.next) == null)                
                {
                    updateHead(h, p);
E var393CF4FD24220F0ED4B080A1E7108CD3_1177207009 =                     item;
                    var393CF4FD24220F0ED4B080A1E7108CD3_1177207009.addTaint(taint);
                    return var393CF4FD24220F0ED4B080A1E7108CD3_1177207009;
                } 
                else
    if(p == q)                
                continue restartFromHead;
                else
                p = q;
            } 
        } 
        
        
        
            
                
                
                    
                    
                
                
                    
                
                    
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.624 -0400", hash_original_method = "0B74804F51F2B061D3EF3D31C957BAFB", hash_generated_method = "FCA0BEE84549C54D77FF2A6C23773AAF")
     Node<E> first() {
    restartFromHead        :
for(;;)
        {
for(Node<E> h = head, p = h, q;;)
            {
                boolean hasItem = (p.item != null);
    if(hasItem || (q = p.next) == null)                
                {
                    updateHead(h, p);
Node<E> var96AB332339E0E5CFEEDCBAEFBC25BC0C_1943616109 =                     hasItem ? p : null;
                    var96AB332339E0E5CFEEDCBAEFBC25BC0C_1943616109.addTaint(taint);
                    return var96AB332339E0E5CFEEDCBAEFBC25BC0C_1943616109;
                } 
                else
    if(p == q)                
                continue restartFromHead;
                else
                p = q;
            } 
        } 
        
        
        
            
                
                
                    
                    
                
                
                    
                
                    
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.624 -0400", hash_original_method = "5BBCBCAD5CC8F01475F9C33B1A8BDA76", hash_generated_method = "5B6EE25C85C936DDB8CC3C4512F780A0")
    public boolean isEmpty() {
        boolean var85FADA70E940F9843AC6C44F04024FA4_1585976066 = (first() == null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_403642107 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_403642107;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.625 -0400", hash_original_method = "8378A4BA724609F4EE8D701FE95A4146", hash_generated_method = "3977F64D429AEAF5050EBAC825C213EA")
    public int size() {
        int count = 0;
for(Node<E> p = first();p != null;p = succ(p))
    if(p.item != null)        
    if(++count == Integer.MAX_VALUE)        
        break;
        int varE2942A04780E223B215EB8B663CF5353_858268126 = (count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1971691667 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1971691667;
        
        
        
            
                
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.625 -0400", hash_original_method = "D3CFD955C2206E78AC2D6D0AA96542FF", hash_generated_method = "CF65781E2F3D49A04DE1772C519B2876")
    public boolean contains(Object o) {
        addTaint(o.getTaint());
    if(o == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_766711014 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_724367510 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_724367510;
        }
for(Node<E> p = first();p != null;p = succ(p))
        {
            E item = p.item;
    if(item != null && o.equals(item))            
            {
            boolean varB326B5062B2F0E69046810717534CB09_853446819 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2068507205 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2068507205;
            }
        } 
        boolean var68934A3E9455FA72420237EB05902327_608405522 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2008754773 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2008754773;
        
        
        
            
            
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.626 -0400", hash_original_method = "47B1B9EE8A66BF6628AC85F9580DDA03", hash_generated_method = "7EB2D0BAEAD8E3508DDFF8E3CA1B218B")
    public boolean remove(Object o) {
        addTaint(o.getTaint());
    if(o == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_827711111 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_461814227 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_461814227;
        }
        Node<E> pred = null;
for(Node<E> p = first();p != null;p = succ(p))
        {
            E item = p.item;
    if(item != null &&
                o.equals(item) &&
                p.casItem(item, null))            
            {
                Node<E> next = succ(p);
    if(pred != null && next != null)                
                pred.casNext(p, next);
                boolean varB326B5062B2F0E69046810717534CB09_1442557725 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_945814257 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_945814257;
            } 
            pred = p;
        } 
        boolean var68934A3E9455FA72420237EB05902327_220947827 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_100578164 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_100578164;
        
        
        
        
            
            
                
                
                
                
                    
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.627 -0400", hash_original_method = "C76E29CF6BEEA629C4456D9BD8199C10", hash_generated_method = "58A5E0B9262F95648C0EDD6EEB5B6C3D")
    public boolean addAll(Collection<? extends E> c) {
        addTaint(c.getTaint());
    if(c == this)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1511928858 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_1511928858.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_1511928858;
        }
        Node<E> beginningOfTheEnd = null;
        Node<E> last = null;
for(E e : c)
        {
            checkNotNull(e);
            Node<E> newNode = new Node<E>(e);
    if(beginningOfTheEnd == null)            
            beginningOfTheEnd = last = newNode;
            else
            {
                last.lazySetNext(newNode);
                last = newNode;
            } 
        } 
    if(beginningOfTheEnd == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_567725920 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_698102163 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_698102163;
        }
for(Node<E> t = tail, p = t;;)
        {
            Node<E> q = p.next;
    if(q == null)            
            {
    if(p.casNext(null, beginningOfTheEnd))                
                {
    if(!casTail(t, last))                    
                    {
                        t = tail;
    if(last.next == null)                        
                        casTail(t, last);
                    } 
                    boolean varB326B5062B2F0E69046810717534CB09_363598575 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_979056564 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_979056564;
                } 
            } 
            else
    if(p == q)            
            p = (t != (t = tail)) ? t : head;
            else
            p = (p != t && t != (t = tail)) ? t : q;
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.628 -0400", hash_original_method = "9AE75EDD15A5D634A14FDDC5ABF53B75", hash_generated_method = "2877605C76E375A09D2A319EC9AE8AAB")
    public Object[] toArray() {
        ArrayList<E> al = new ArrayList<E>();
for(Node<E> p = first();p != null;p = succ(p))
        {
            E item = p.item;
    if(item != null)            
            al.add(item);
        } 
Object[] varEE356BC8028D35EDB407C2CD6F5C7F86_1559507938 =         al.toArray();
        varEE356BC8028D35EDB407C2CD6F5C7F86_1559507938.addTaint(taint);
        return varEE356BC8028D35EDB407C2CD6F5C7F86_1559507938;
        
        
        
            
            
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.629 -0400", hash_original_method = "1B34191977E7D82DF73C99DC22E56270", hash_generated_method = "26EB0EFDC520E9EB971F6B346D97DEA4")
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        addTaint(a[0].getTaint());
        int k = 0;
        Node<E> p;
for(p = first();p != null && k < a.length;p = succ(p))
        {
            E item = p.item;
    if(item != null)            
            a[k++] = (T)item;
        } 
    if(p == null)        
        {
    if(k < a.length)            
            a[k] = null;
T[] var3F5343BF1D849954A73F0BB303805FFD_124254659 =             a;
            var3F5343BF1D849954A73F0BB303805FFD_124254659.addTaint(taint);
            return var3F5343BF1D849954A73F0BB303805FFD_124254659;
        } 
        ArrayList<E> al = new ArrayList<E>();
for(Node<E> q = first();q != null;q = succ(q))
        {
            E item = q.item;
    if(item != null)            
            al.add(item);
        } 
T[] varAA44379FEF6B0261A49B4F9151CB856C_759521527 =         al.toArray(a);
        varAA44379FEF6B0261A49B4F9151CB856C_759521527.addTaint(taint);
        return varAA44379FEF6B0261A49B4F9151CB856C_759521527;
        
        
        
        
            
            
                
        
        
            
                
            
        
        
        
            
            
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.630 -0400", hash_original_method = "756A0449DBEE27B15290EF9912B6D98E", hash_generated_method = "3EC22EE9B62CA0D0C139C5ABF74575A0")
    public Iterator<E> iterator() {
Iterator<E> varB10D928EC6DDAEBFD727C2EDCEC6EDF5_1168628771 =         new Itr();
        varB10D928EC6DDAEBFD727C2EDCEC6EDF5_1168628771.addTaint(taint);
        return varB10D928EC6DDAEBFD727C2EDCEC6EDF5_1168628771;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.630 -0400", hash_original_method = "2DB3995911F14A1266042DB21211C241", hash_generated_method = "9A9EEB9CFF7C391D2CFCCB2B2CD0E570")
    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
        addTaint(s.getTaint());
        s.defaultWriteObject();
for(Node<E> p = first();p != null;p = succ(p))
        {
            Object item = p.item;
    if(item != null)            
            s.writeObject(item);
        } 
        s.writeObject(null);
        
        
        
            
            
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.631 -0400", hash_original_method = "4C4E4F1C2555347B7DA11DAA134BF488", hash_generated_method = "A35953104F72E0350AB56B538DA6704A")
    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
        addTaint(s.getTaint());
        s.defaultReadObject();
        Node<E> h = null;
        Node<E> t = null;
        Object item;
        while
((item = s.readObject()) != null)        
        {
            @SuppressWarnings("unchecked") Node<E> newNode = new Node<E>((E) item);
    if(h == null)            
            h = t = newNode;
            else
            {
                t.lazySetNext(newNode);
                t = newNode;
            } 
        } 
    if(h == null)        
        h = t = new Node<E>(null);
        head = h;
        tail = t;
        
        
        
        
        
            
            
            
                
            
                
                
            
        
        
            
        
        
    }

    
        @DSModeled(DSC.SAFE)
    private static void checkNotNull(Object v) {
        if (v == null)
            throw new NullPointerException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.632 -0400", hash_original_method = "691EF799FFE1B91CC4D8DBAB0EEF43D5", hash_generated_method = "6039EF6BAC5FDB67BE30493EB5DC2251")
    private boolean casTail(Node<E> cmp, Node<E> val) {
        addTaint(val.getTaint());
        addTaint(cmp.getTaint());
        boolean var7E8AA0CE41D7E99D8A58CC79419B8677_942575488 = (UNSAFE.compareAndSwapObject(this, tailOffset, cmp, val));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1134462251 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1134462251;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.632 -0400", hash_original_method = "BC5855BB8BED9A25EA66B96BB6A04937", hash_generated_method = "9270D4E91C988A8303B82751E6C71347")
    private boolean casHead(Node<E> cmp, Node<E> val) {
        addTaint(val.getTaint());
        addTaint(cmp.getTaint());
        boolean varF75C9E8D581D74DDAFA53D9D3A5118DF_1900448144 = (UNSAFE.compareAndSwapObject(this, headOffset, cmp, val));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_314476307 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_314476307;
        
        
    }

    
        static long objectFieldOffset(sun.misc.Unsafe UNSAFE,
                                  String field, Class<?> klazz) {
        try {
            return UNSAFE.objectFieldOffset(klazz.getDeclaredField(field));
        } catch (NoSuchFieldException e) {
            NoSuchFieldError error = new NoSuchFieldError(field);
            error.initCause(e);
            throw error;
        }
    }

    
    private static class Node<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.633 -0400", hash_original_field = "447B7147E84BE512208DCC0995D67EBC", hash_generated_field = "10095ABA73A923383E44F968C6C62945")

        volatile E item;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.633 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "7BB4D15B501C737F5EC180DC75EDF910")

        volatile Node<E> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.633 -0400", hash_original_method = "368F2FAFC4A206C09EED76798A5342BA", hash_generated_method = "8522189974E03349D022CF3B873FDD36")
          Node(E item) {
            addTaint(item.getTaint());
            UNSAFE.putObject(this, itemOffset, item);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.633 -0400", hash_original_method = "51A0AA76262E736F2E39BE7CE12CF006", hash_generated_method = "24F38EC0988E677C0845C8F01362B887")
         boolean casItem(E cmp, E val) {
            addTaint(val.getTaint());
            addTaint(cmp.getTaint());
            boolean var74F63A1693D321748DC62AE0D1A13C35_1970338744 = (UNSAFE.compareAndSwapObject(this, itemOffset, cmp, val));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1030418389 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1030418389;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.634 -0400", hash_original_method = "E78DBD679DC5F596F67B7449AE69FAB3", hash_generated_method = "BBC155EE5E769344F67858DD529FDE45")
         void lazySetNext(Node<E> val) {
            addTaint(val.getTaint());
            UNSAFE.putOrderedObject(this, nextOffset, val);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.634 -0400", hash_original_method = "C86D1E5E3D7752CB8E68445595A8E8EC", hash_generated_method = "7C0EDC5474E7B9C7E48E592322374613")
         boolean casNext(Node<E> cmp, Node<E> val) {
            addTaint(val.getTaint());
            addTaint(cmp.getTaint());
            boolean varBE28632200F09419D5ABEBABBCCD9D55_1252416129 = (UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1630588497 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1630588497;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.634 -0400", hash_original_field = "3E088F71F6042050BDAAA79B57C7A5CD", hash_generated_field = "42C3BEC243DA1A57DFC4FB82C324F252")

        private static final sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.634 -0400", hash_original_field = "108A0FC2EFFA51A6A4ED34085DD96763", hash_generated_field = "D9FDE22F87B42653A7025C63A9991763")

        private static final long nextOffset = objectFieldOffset(UNSAFE, "next", Node.class);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.634 -0400", hash_original_field = "A5D5E3563F1AF395A91EE0E3AAB35ED9", hash_generated_field = "E138439E2B895339EC3451FCFE9CA960")

        private static final long itemOffset = objectFieldOffset(UNSAFE, "item", Node.class);
    }


    
    private class Itr implements Iterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.634 -0400", hash_original_field = "06038CE55A37CEF0CD18EC9EDC7B6BC0", hash_generated_field = "BD45C7FA08D8C17CC087E2A8B9D2DBAA")

        private Node<E> nextNode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.634 -0400", hash_original_field = "F0B5FE0A0CBE5E14CD07AF33AB522BBE", hash_generated_field = "97D8B84DA75A48FD27623CFC43E53C30")

        private E nextItem;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.634 -0400", hash_original_field = "BB3AE5C41B0FFE5CC0DAF60D4592524F", hash_generated_field = "9782A09877DFB4D434246B92A2C403C0")

        private Node<E> lastRet;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.635 -0400", hash_original_method = "A56873641F7861FCF92703A510E041DF", hash_generated_method = "9DA9D44375E67CD77614346D5F2A644C")
          Itr() {
            advance();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.636 -0400", hash_original_method = "530B75A5B8DF2D5033AF3BE4C3DEE1C2", hash_generated_method = "90487DF91D86D2C6CD12F09BB0EE4433")
        private E advance() {
            lastRet = nextNode;
            E x = nextItem;
            Node<E> pred;
            Node<E> p;
    if(nextNode == null)            
            {
                p = first();
                pred = null;
            } 
            else
            {
                pred = nextNode;
                p = succ(nextNode);
            } 
for(;;)
            {
    if(p == null)                
                {
                    nextNode = null;
                    nextItem = null;
E varEA5659DA512DECF23E6D37EE8060D074_526607385 =                     x;
                    varEA5659DA512DECF23E6D37EE8060D074_526607385.addTaint(taint);
                    return varEA5659DA512DECF23E6D37EE8060D074_526607385;
                } 
                E item = p.item;
    if(item != null)                
                {
                    nextNode = p;
                    nextItem = item;
E varEA5659DA512DECF23E6D37EE8060D074_78716230 =                     x;
                    varEA5659DA512DECF23E6D37EE8060D074_78716230.addTaint(taint);
                    return varEA5659DA512DECF23E6D37EE8060D074_78716230;
                } 
                else
                {
                    Node<E> next = succ(p);
    if(pred != null && next != null)                    
                    pred.casNext(p, next);
                    p = next;
                } 
            } 
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.636 -0400", hash_original_method = "F3203522041DB53AA10973946A26B4E6", hash_generated_method = "9E3DC0B4E42301D3FBDBD2FA61BC1C5D")
        public boolean hasNext() {
            boolean var055287C88A3BCA17E817C22C28D72D59_1527372399 = (nextNode != null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_408504475 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_408504475;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.636 -0400", hash_original_method = "0C68CBDEA1D7969059001FABF149348A", hash_generated_method = "D68FAF5B32A62CEBE433F86A26AAB865")
        public E next() {
    if(nextNode == null)            
            {
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_1562930533 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_1562930533.addTaint(taint);
            throw var28D00AB599969908D71F102AF992D49A_1562930533;
            }
E var0AF7A6725AB70DB809AACAEE1668A258_344250919 =             advance();
            var0AF7A6725AB70DB809AACAEE1668A258_344250919.addTaint(taint);
            return var0AF7A6725AB70DB809AACAEE1668A258_344250919;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.637 -0400", hash_original_method = "4D06856C6560F115B6FF7F073DDF82B7", hash_generated_method = "A5EE4A127C495717C9DEE524D7844D05")
        public void remove() {
            Node<E> l = lastRet;
    if(l == null)            
            {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_390483908 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_390483908.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_390483908;
            }
            l.item = null;
            lastRet = null;
            
            
            
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.637 -0400", hash_original_field = "4A0B1D2A0E315E7FA396E6E695D2A7F6", hash_generated_field = "552079242BF4D3962F1F3E89C3B525FA")

    private static final long serialVersionUID = 196745693267521676L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.637 -0400", hash_original_field = "3E088F71F6042050BDAAA79B57C7A5CD", hash_generated_field = "42C3BEC243DA1A57DFC4FB82C324F252")

    private static final sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.637 -0400", hash_original_field = "56D723F37A869C1262C5569D7C8C1DA3", hash_generated_field = "9EFA27FCA31FFA33F7E605E12104104C")

    private static final long headOffset = objectFieldOffset(UNSAFE, "head", ConcurrentLinkedQueue.class);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:15.637 -0400", hash_original_field = "2C6D04E7D796BD39F92EB88FDEC1AE7B", hash_generated_field = "B885C4C60FF837953D19E1C9D06EABC1")

    private static final long tailOffset = objectFieldOffset(UNSAFE, "tail", ConcurrentLinkedQueue.class);
}

