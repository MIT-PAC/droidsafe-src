package java.util.concurrent;

// Droidsafe Imports
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ConcurrentLinkedQueue<E> extends AbstractQueue<E> implements Queue<E>, java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.709 -0400", hash_original_field = "96E89A298E0A9F469B9AE458D6AFAE9F", hash_generated_field = "B57EDCA0C5D8B188A31356A19160405D")

    private transient volatile Node<E> head;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.709 -0400", hash_original_field = "7AEA2552DFE7EB84B9443B6FC9BA6E01", hash_generated_field = "44C1E7DD6E43696E7B1931FD10B83ECF")

    private transient volatile Node<E> tail;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.709 -0400", hash_original_method = "6A57FB745E5D860E38239AF0DB1591EF", hash_generated_method = "38B3499791573BCF992A48C491B8F223")
    public  ConcurrentLinkedQueue() {
        head = tail = new Node<E>(null);
        // ---------- Original Method ----------
        //head = tail = new Node<E>(null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.710 -0400", hash_original_method = "6F01EA166BC3601049062B90A5587D9E", hash_generated_method = "CBA4B15CAEA0C43B4F30FE78B169603F")
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
            } //End block
        } //End block
        if(h == null)        
        h = t = new Node<E>(null);
        head = h;
        tail = t;
        // ---------- Original Method ----------
        //Node<E> h = null, t = null;
        //for (E e : c) {
            //checkNotNull(e);
            //Node<E> newNode = new Node<E>(e);
            //if (h == null)
                //h = t = newNode;
            //else {
                //t.lazySetNext(newNode);
                //t = newNode;
            //}
        //}
        //if (h == null)
            //h = t = new Node<E>(null);
        //head = h;
        //tail = t;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.711 -0400", hash_original_method = "F77A4F330ECF7476CC7AF200B57EFA7F", hash_generated_method = "A3F6A65D585C24EF79186A5F845A2A87")
    public boolean add(E e) {
        addTaint(e.getTaint());
        boolean var753C0332450253282F40FDC9097055BE_1678775241 = (offer(e));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1526914511 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1526914511;
        // ---------- Original Method ----------
        //return offer(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.711 -0400", hash_original_method = "73F32BBDAFE1515404B45EC2F1869A3A", hash_generated_method = "712D2CE041D3BC5E79F9C66171CEC302")
    final void updateHead(Node<E> h, Node<E> p) {
        addTaint(p.getTaint());
        addTaint(h.getTaint());
        if(h != p && casHead(h, p))        
        h.lazySetNext(h);
        // ---------- Original Method ----------
        //if (h != p && casHead(h, p))
            //h.lazySetNext(h);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.712 -0400", hash_original_method = "FA81D040C1BC0670D20AF3D93B255BE4", hash_generated_method = "126AB194F176D7BBDF55294389D27DC5")
    final Node<E> succ(Node<E> p) {
        addTaint(p.getTaint());
        Node<E> next = p.next;
Node<E> var38526534D800D5249E337269E6B24E55_588676772 =         (p == next) ? head : next;
        var38526534D800D5249E337269E6B24E55_588676772.addTaint(taint);
        return var38526534D800D5249E337269E6B24E55_588676772;
        // ---------- Original Method ----------
        //Node<E> next = p.next;
        //return (p == next) ? head : next;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.713 -0400", hash_original_method = "6C2ABD9F3905A9D98C3CBF8AF5320B8C", hash_generated_method = "5B9937721254219332067F1AAE02C6A2")
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
                    boolean varB326B5062B2F0E69046810717534CB09_5661684 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1628065726 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1628065726;
                } //End block
            } //End block
            else
            if(p == q)            
            p = (t != (t = tail)) ? t : head;
            else
            p = (p != t && t != (t = tail)) ? t : q;
        } //End block
        // ---------- Original Method ----------
        //checkNotNull(e);
        //final Node<E> newNode = new Node<E>(e);
        //for (Node<E> t = tail, p = t;;) {
            //Node<E> q = p.next;
            //if (q == null) {
                //if (p.casNext(null, newNode)) {
                    //if (p != t) 
                        //casTail(t, newNode);  
                    //return true;
                //}
            //}
            //else if (p == q)
                //p = (t != (t = tail)) ? t : head;
            //else
                //p = (p != t && t != (t = tail)) ? t : q;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.714 -0400", hash_original_method = "1F662EFABD15CE7BE1315E55CBBE7D30", hash_generated_method = "9E4164FCC2500926846FFC33DAF815F1")
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
E var393CF4FD24220F0ED4B080A1E7108CD3_298675241 =                     item;
                    var393CF4FD24220F0ED4B080A1E7108CD3_298675241.addTaint(taint);
                    return var393CF4FD24220F0ED4B080A1E7108CD3_298675241;
                } //End block
                else
                if((q = p.next) == null)                
                {
                    updateHead(h, p);
E var540C13E9E156B687226421B24F2DF178_1408843336 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1408843336.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1408843336;
                } //End block
                else
                if(p == q)                
                continue restartFromHead;
                else
                p = q;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //restartFromHead:
        //for (;;) {
            //for (Node<E> h = head, p = h, q;;) {
                //E item = p.item;
                //if (item != null && p.casItem(item, null)) {
                    //if (p != h) 
                        //updateHead(h, ((q = p.next) != null) ? q : p);
                    //return item;
                //}
                //else if ((q = p.next) == null) {
                    //updateHead(h, p);
                    //return null;
                //}
                //else if (p == q)
                    //continue restartFromHead;
                //else
                    //p = q;
            //}
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.715 -0400", hash_original_method = "61FBF64CA94D04AD27A6643CEF7D7285", hash_generated_method = "FC21CAD97AEBA98564C4CF1F4B739D80")
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
E var393CF4FD24220F0ED4B080A1E7108CD3_1803747530 =                     item;
                    var393CF4FD24220F0ED4B080A1E7108CD3_1803747530.addTaint(taint);
                    return var393CF4FD24220F0ED4B080A1E7108CD3_1803747530;
                } //End block
                else
                if(p == q)                
                continue restartFromHead;
                else
                p = q;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //restartFromHead:
        //for (;;) {
            //for (Node<E> h = head, p = h, q;;) {
                //E item = p.item;
                //if (item != null || (q = p.next) == null) {
                    //updateHead(h, p);
                    //return item;
                //}
                //else if (p == q)
                    //continue restartFromHead;
                //else
                    //p = q;
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.715 -0400", hash_original_method = "0B74804F51F2B061D3EF3D31C957BAFB", hash_generated_method = "D61EE49DBAAC3260920411A83FBB04F7")
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
Node<E> var96AB332339E0E5CFEEDCBAEFBC25BC0C_1804185546 =                     hasItem ? p : null;
                    var96AB332339E0E5CFEEDCBAEFBC25BC0C_1804185546.addTaint(taint);
                    return var96AB332339E0E5CFEEDCBAEFBC25BC0C_1804185546;
                } //End block
                else
                if(p == q)                
                continue restartFromHead;
                else
                p = q;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //restartFromHead:
        //for (;;) {
            //for (Node<E> h = head, p = h, q;;) {
                //boolean hasItem = (p.item != null);
                //if (hasItem || (q = p.next) == null) {
                    //updateHead(h, p);
                    //return hasItem ? p : null;
                //}
                //else if (p == q)
                    //continue restartFromHead;
                //else
                    //p = q;
            //}
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.716 -0400", hash_original_method = "5BBCBCAD5CC8F01475F9C33B1A8BDA76", hash_generated_method = "F3750F5AADEC65E44B00E5CE4CB64A36")
    public boolean isEmpty() {
        boolean var85FADA70E940F9843AC6C44F04024FA4_1323437160 = (first() == null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_921035277 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_921035277;
        // ---------- Original Method ----------
        //return first() == null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.716 -0400", hash_original_method = "8378A4BA724609F4EE8D701FE95A4146", hash_generated_method = "0372C88A7A1DEA51D3176FC2DC2EF412")
    public int size() {
        int count = 0;
for(Node<E> p = first();p != null;p = succ(p))
        if(p.item != null)        
        if(++count == Integer.MAX_VALUE)        
        break;
        int varE2942A04780E223B215EB8B663CF5353_1555424329 = (count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_483092281 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_483092281;
        // ---------- Original Method ----------
        //int count = 0;
        //for (Node<E> p = first(); p != null; p = succ(p))
            //if (p.item != null)
                //if (++count == Integer.MAX_VALUE)
                    //break;
        //return count;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.717 -0400", hash_original_method = "D3CFD955C2206E78AC2D6D0AA96542FF", hash_generated_method = "AA9427993B9248C8656E54DABDE39F09")
    public boolean contains(Object o) {
        addTaint(o.getTaint());
        if(o == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1676025335 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1663158870 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1663158870;
        }
for(Node<E> p = first();p != null;p = succ(p))
        {
            E item = p.item;
            if(item != null && o.equals(item))            
            {
            boolean varB326B5062B2F0E69046810717534CB09_454358909 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1778552565 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1778552565;
            }
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_994454943 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1118252844 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1118252844;
        // ---------- Original Method ----------
        //if (o == null) return false;
        //for (Node<E> p = first(); p != null; p = succ(p)) {
            //E item = p.item;
            //if (item != null && o.equals(item))
                //return true;
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.718 -0400", hash_original_method = "47B1B9EE8A66BF6628AC85F9580DDA03", hash_generated_method = "C870C41EE73A791371CA7EF4E49A22E5")
    public boolean remove(Object o) {
        addTaint(o.getTaint());
        if(o == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1386696141 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_385965523 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_385965523;
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
                boolean varB326B5062B2F0E69046810717534CB09_1112059307 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1057603014 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1057603014;
            } //End block
            pred = p;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_329103268 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_640871895 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_640871895;
        // ---------- Original Method ----------
        //if (o == null) return false;
        //Node<E> pred = null;
        //for (Node<E> p = first(); p != null; p = succ(p)) {
            //E item = p.item;
            //if (item != null &&
                //o.equals(item) &&
                //p.casItem(item, null)) {
                //Node<E> next = succ(p);
                //if (pred != null && next != null)
                    //pred.casNext(p, next);
                //return true;
            //}
            //pred = p;
        //}
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.719 -0400", hash_original_method = "C76E29CF6BEEA629C4456D9BD8199C10", hash_generated_method = "FE6074082DAD592010CCE5812739D1C3")
    public boolean addAll(Collection<? extends E> c) {
        addTaint(c.getTaint());
        if(c == this)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_525558257 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_525558257.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_525558257;
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
            } //End block
        } //End block
        if(beginningOfTheEnd == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1154743589 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_665121870 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_665121870;
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
                    } //End block
                    boolean varB326B5062B2F0E69046810717534CB09_1936826205 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_62060525 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_62060525;
                } //End block
            } //End block
            else
            if(p == q)            
            p = (t != (t = tail)) ? t : head;
            else
            p = (p != t && t != (t = tail)) ? t : q;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.720 -0400", hash_original_method = "9AE75EDD15A5D634A14FDDC5ABF53B75", hash_generated_method = "62CDCF437EA6FC8B136C207900FF77B5")
    public Object[] toArray() {
        ArrayList<E> al = new ArrayList<E>();
for(Node<E> p = first();p != null;p = succ(p))
        {
            E item = p.item;
            if(item != null)            
            al.add(item);
        } //End block
Object[] varEE356BC8028D35EDB407C2CD6F5C7F86_1815237208 =         al.toArray();
        varEE356BC8028D35EDB407C2CD6F5C7F86_1815237208.addTaint(taint);
        return varEE356BC8028D35EDB407C2CD6F5C7F86_1815237208;
        // ---------- Original Method ----------
        //ArrayList<E> al = new ArrayList<E>();
        //for (Node<E> p = first(); p != null; p = succ(p)) {
            //E item = p.item;
            //if (item != null)
                //al.add(item);
        //}
        //return al.toArray();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.721 -0400", hash_original_method = "1B34191977E7D82DF73C99DC22E56270", hash_generated_method = "083DB23FA5D6BA154941AB836C30B5AA")
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
        } //End block
        if(p == null)        
        {
            if(k < a.length)            
            a[k] = null;
T[] var3F5343BF1D849954A73F0BB303805FFD_1239886747 =             a;
            var3F5343BF1D849954A73F0BB303805FFD_1239886747.addTaint(taint);
            return var3F5343BF1D849954A73F0BB303805FFD_1239886747;
        } //End block
        ArrayList<E> al = new ArrayList<E>();
for(Node<E> q = first();q != null;q = succ(q))
        {
            E item = q.item;
            if(item != null)            
            al.add(item);
        } //End block
T[] varAA44379FEF6B0261A49B4F9151CB856C_1343847510 =         al.toArray(a);
        varAA44379FEF6B0261A49B4F9151CB856C_1343847510.addTaint(taint);
        return varAA44379FEF6B0261A49B4F9151CB856C_1343847510;
        // ---------- Original Method ----------
        //int k = 0;
        //Node<E> p;
        //for (p = first(); p != null && k < a.length; p = succ(p)) {
            //E item = p.item;
            //if (item != null)
                //a[k++] = (T)item;
        //}
        //if (p == null) {
            //if (k < a.length)
                //a[k] = null;
            //return a;
        //}
        //ArrayList<E> al = new ArrayList<E>();
        //for (Node<E> q = first(); q != null; q = succ(q)) {
            //E item = q.item;
            //if (item != null)
                //al.add(item);
        //}
        //return al.toArray(a);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.722 -0400", hash_original_method = "756A0449DBEE27B15290EF9912B6D98E", hash_generated_method = "586A7D96C88B281BAA7321E3EBADF3FE")
    public Iterator<E> iterator() {
Iterator<E> varB10D928EC6DDAEBFD727C2EDCEC6EDF5_1010483202 =         new Itr();
        varB10D928EC6DDAEBFD727C2EDCEC6EDF5_1010483202.addTaint(taint);
        return varB10D928EC6DDAEBFD727C2EDCEC6EDF5_1010483202;
        // ---------- Original Method ----------
        //return new Itr();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.722 -0400", hash_original_method = "2DB3995911F14A1266042DB21211C241", hash_generated_method = "9A9EEB9CFF7C391D2CFCCB2B2CD0E570")
    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
        addTaint(s.getTaint());
        s.defaultWriteObject();
for(Node<E> p = first();p != null;p = succ(p))
        {
            Object item = p.item;
            if(item != null)            
            s.writeObject(item);
        } //End block
        s.writeObject(null);
        // ---------- Original Method ----------
        //s.defaultWriteObject();
        //for (Node<E> p = first(); p != null; p = succ(p)) {
            //Object item = p.item;
            //if (item != null)
                //s.writeObject(item);
        //}
        //s.writeObject(null);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.723 -0400", hash_original_method = "4C4E4F1C2555347B7DA11DAA134BF488", hash_generated_method = "A35953104F72E0350AB56B538DA6704A")
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
            } //End block
        } //End block
        if(h == null)        
        h = t = new Node<E>(null);
        head = h;
        tail = t;
        // ---------- Original Method ----------
        //s.defaultReadObject();
        //Node<E> h = null, t = null;
        //Object item;
        //while ((item = s.readObject()) != null) {
            //@SuppressWarnings("unchecked")
            //Node<E> newNode = new Node<E>((E) item);
            //if (h == null)
                //h = t = newNode;
            //else {
                //t.lazySetNext(newNode);
                //t = newNode;
            //}
        //}
        //if (h == null)
            //h = t = new Node<E>(null);
        //head = h;
        //tail = t;
    }

    
    @DSModeled(DSC.SAFE)
    private static void checkNotNull(Object v) {
        if (v == null)
            throw new NullPointerException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.724 -0400", hash_original_method = "691EF799FFE1B91CC4D8DBAB0EEF43D5", hash_generated_method = "C3E52DFEC439F09D5EDED13DAD2EDDE9")
    private boolean casTail(Node<E> cmp, Node<E> val) {
        addTaint(val.getTaint());
        addTaint(cmp.getTaint());
        boolean var7E8AA0CE41D7E99D8A58CC79419B8677_1913686080 = (UNSAFE.compareAndSwapObject(this, tailOffset, cmp, val));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1556197711 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1556197711;
        // ---------- Original Method ----------
        //return UNSAFE.compareAndSwapObject(this, tailOffset, cmp, val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.725 -0400", hash_original_method = "BC5855BB8BED9A25EA66B96BB6A04937", hash_generated_method = "DA1D9B0C76352AE3E9A04CDA75AC5E11")
    private boolean casHead(Node<E> cmp, Node<E> val) {
        addTaint(val.getTaint());
        addTaint(cmp.getTaint());
        boolean varF75C9E8D581D74DDAFA53D9D3A5118DF_23464981 = (UNSAFE.compareAndSwapObject(this, headOffset, cmp, val));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1194129603 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1194129603;
        // ---------- Original Method ----------
        //return UNSAFE.compareAndSwapObject(this, headOffset, cmp, val);
    }

    
    @DSModeled(DSC.SAFE)
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.725 -0400", hash_original_field = "447B7147E84BE512208DCC0995D67EBC", hash_generated_field = "10095ABA73A923383E44F968C6C62945")

        volatile E item;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.726 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "7BB4D15B501C737F5EC180DC75EDF910")

        volatile Node<E> next;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.726 -0400", hash_original_method = "368F2FAFC4A206C09EED76798A5342BA", hash_generated_method = "8522189974E03349D022CF3B873FDD36")
          Node(E item) {
            addTaint(item.getTaint());
            UNSAFE.putObject(this, itemOffset, item);
            // ---------- Original Method ----------
            //UNSAFE.putObject(this, itemOffset, item);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.727 -0400", hash_original_method = "51A0AA76262E736F2E39BE7CE12CF006", hash_generated_method = "E6D72FBBA298A7F99C681A25FDF86171")
         boolean casItem(E cmp, E val) {
            addTaint(val.getTaint());
            addTaint(cmp.getTaint());
            boolean var74F63A1693D321748DC62AE0D1A13C35_1770667415 = (UNSAFE.compareAndSwapObject(this, itemOffset, cmp, val));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1812471854 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1812471854;
            // ---------- Original Method ----------
            //return UNSAFE.compareAndSwapObject(this, itemOffset, cmp, val);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.727 -0400", hash_original_method = "E78DBD679DC5F596F67B7449AE69FAB3", hash_generated_method = "BBC155EE5E769344F67858DD529FDE45")
         void lazySetNext(Node<E> val) {
            addTaint(val.getTaint());
            UNSAFE.putOrderedObject(this, nextOffset, val);
            // ---------- Original Method ----------
            //UNSAFE.putOrderedObject(this, nextOffset, val);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.727 -0400", hash_original_method = "C86D1E5E3D7752CB8E68445595A8E8EC", hash_generated_method = "6C801E5AF0BDE9DD13DCCB999D422946")
         boolean casNext(Node<E> cmp, Node<E> val) {
            addTaint(val.getTaint());
            addTaint(cmp.getTaint());
            boolean varBE28632200F09419D5ABEBABBCCD9D55_1056923389 = (UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_829954699 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_829954699;
            // ---------- Original Method ----------
            //return UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.727 -0400", hash_original_field = "3E088F71F6042050BDAAA79B57C7A5CD", hash_generated_field = "42C3BEC243DA1A57DFC4FB82C324F252")

        private static final sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.728 -0400", hash_original_field = "108A0FC2EFFA51A6A4ED34085DD96763", hash_generated_field = "D9FDE22F87B42653A7025C63A9991763")

        private static final long nextOffset = objectFieldOffset(UNSAFE, "next", Node.class);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.728 -0400", hash_original_field = "A5D5E3563F1AF395A91EE0E3AAB35ED9", hash_generated_field = "E138439E2B895339EC3451FCFE9CA960")

        private static final long itemOffset = objectFieldOffset(UNSAFE, "item", Node.class);
    }


    
    private class Itr implements Iterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.728 -0400", hash_original_field = "06038CE55A37CEF0CD18EC9EDC7B6BC0", hash_generated_field = "BD45C7FA08D8C17CC087E2A8B9D2DBAA")

        private Node<E> nextNode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.728 -0400", hash_original_field = "F0B5FE0A0CBE5E14CD07AF33AB522BBE", hash_generated_field = "97D8B84DA75A48FD27623CFC43E53C30")

        private E nextItem;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.729 -0400", hash_original_field = "BB3AE5C41B0FFE5CC0DAF60D4592524F", hash_generated_field = "9782A09877DFB4D434246B92A2C403C0")

        private Node<E> lastRet;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.729 -0400", hash_original_method = "A56873641F7861FCF92703A510E041DF", hash_generated_method = "9DA9D44375E67CD77614346D5F2A644C")
          Itr() {
            advance();
            // ---------- Original Method ----------
            //advance();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.730 -0400", hash_original_method = "530B75A5B8DF2D5033AF3BE4C3DEE1C2", hash_generated_method = "FB1C2D51DC8757480B0A901438224A88")
        private E advance() {
            lastRet = nextNode;
            E x = nextItem;
            Node<E> pred;
            Node<E> p;
            if(nextNode == null)            
            {
                p = first();
                pred = null;
            } //End block
            else
            {
                pred = nextNode;
                p = succ(nextNode);
            } //End block
for(;;)
            {
                if(p == null)                
                {
                    nextNode = null;
                    nextItem = null;
E varEA5659DA512DECF23E6D37EE8060D074_1575195596 =                     x;
                    varEA5659DA512DECF23E6D37EE8060D074_1575195596.addTaint(taint);
                    return varEA5659DA512DECF23E6D37EE8060D074_1575195596;
                } //End block
                E item = p.item;
                if(item != null)                
                {
                    nextNode = p;
                    nextItem = item;
E varEA5659DA512DECF23E6D37EE8060D074_1639144093 =                     x;
                    varEA5659DA512DECF23E6D37EE8060D074_1639144093.addTaint(taint);
                    return varEA5659DA512DECF23E6D37EE8060D074_1639144093;
                } //End block
                else
                {
                    Node<E> next = succ(p);
                    if(pred != null && next != null)                    
                    pred.casNext(p, next);
                    p = next;
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.731 -0400", hash_original_method = "F3203522041DB53AA10973946A26B4E6", hash_generated_method = "BF24DA271B91EAF20B1F24BD2CA4DC10")
        public boolean hasNext() {
            boolean var055287C88A3BCA17E817C22C28D72D59_973374057 = (nextNode != null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_837795474 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_837795474;
            // ---------- Original Method ----------
            //return nextNode != null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.731 -0400", hash_original_method = "0C68CBDEA1D7969059001FABF149348A", hash_generated_method = "9941A2EE2E1A956554AA938D208E478C")
        public E next() {
            if(nextNode == null)            
            {
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_1146952391 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_1146952391.addTaint(taint);
            throw var28D00AB599969908D71F102AF992D49A_1146952391;
            }
E var0AF7A6725AB70DB809AACAEE1668A258_271422078 =             advance();
            var0AF7A6725AB70DB809AACAEE1668A258_271422078.addTaint(taint);
            return var0AF7A6725AB70DB809AACAEE1668A258_271422078;
            // ---------- Original Method ----------
            //if (nextNode == null) throw new NoSuchElementException();
            //return advance();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.731 -0400", hash_original_method = "4D06856C6560F115B6FF7F073DDF82B7", hash_generated_method = "B083E3AD4DF76CB5835E8DC21604D55C")
        public void remove() {
            Node<E> l = lastRet;
            if(l == null)            
            {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1614421303 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1614421303.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1614421303;
            }
            l.item = null;
            lastRet = null;
            // ---------- Original Method ----------
            //Node<E> l = lastRet;
            //if (l == null) throw new IllegalStateException();
            //l.item = null;
            //lastRet = null;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.731 -0400", hash_original_field = "4A0B1D2A0E315E7FA396E6E695D2A7F6", hash_generated_field = "552079242BF4D3962F1F3E89C3B525FA")

    private static final long serialVersionUID = 196745693267521676L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.732 -0400", hash_original_field = "3E088F71F6042050BDAAA79B57C7A5CD", hash_generated_field = "42C3BEC243DA1A57DFC4FB82C324F252")

    private static final sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.732 -0400", hash_original_field = "56D723F37A869C1262C5569D7C8C1DA3", hash_generated_field = "9EFA27FCA31FFA33F7E605E12104104C")

    private static final long headOffset = objectFieldOffset(UNSAFE, "head", ConcurrentLinkedQueue.class);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.732 -0400", hash_original_field = "2C6D04E7D796BD39F92EB88FDEC1AE7B", hash_generated_field = "B885C4C60FF837953D19E1C9D06EABC1")

    private static final long tailOffset = objectFieldOffset(UNSAFE, "tail", ConcurrentLinkedQueue.class);
}

