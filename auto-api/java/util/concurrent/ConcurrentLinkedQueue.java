package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ConcurrentLinkedQueue<E> extends AbstractQueue<E> implements Queue<E>, java.io.Serializable {
    private static long serialVersionUID = 196745693267521676L;
    private transient volatile Node<E> head;
    private transient volatile Node<E> tail;
    private static sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
    private static long headOffset =
        objectFieldOffset(UNSAFE, "head", ConcurrentLinkedQueue.class);
    private static long tailOffset =
        objectFieldOffset(UNSAFE, "tail", ConcurrentLinkedQueue.class);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:25.330 -0400", hash_original_method = "6A57FB745E5D860E38239AF0DB1591EF", hash_generated_method = "C5F2E95ACEDA3A1C410227B5A15174A5")
    @DSModeled(DSC.SAFE)
    public ConcurrentLinkedQueue() {
        head = tail = new Node<E>(null);
        // ---------- Original Method ----------
        //head = tail = new Node<E>(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:25.346 -0400", hash_original_method = "6F01EA166BC3601049062B90A5587D9E", hash_generated_method = "E6E261A1C3E4604698A005445B7E45F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ConcurrentLinkedQueue(Collection<? extends E> c) {
        dsTaint.addTaint(c.dsTaint);
        Node<E> h, t;
        h = null;
        t = null;
        {
            c.iterator().hasNext();
            E e = c.iterator().next();
            {
                checkNotNull(e);
                Node<E> newNode;
                newNode = new Node<E>(e);
                h = t = newNode;
                {
                    t.lazySetNext(newNode);
                    t = newNode;
                } //End block
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:25.366 -0400", hash_original_method = "F77A4F330ECF7476CC7AF200B57EFA7F", hash_generated_method = "07C63EDB0330CA356EC5142E2E078895")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean add(E e) {
        dsTaint.addTaint(e.dsTaint);
        boolean var42B2AD017FC8EAA920A05640330B5300_715301131 = (offer(e));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return offer(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:25.393 -0400", hash_original_method = "73F32BBDAFE1515404B45EC2F1869A3A", hash_generated_method = "01DBAEF8CC45842FB5FBD8EA594F2CDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void updateHead(Node<E> h, Node<E> p) {
        dsTaint.addTaint(p.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        {
            boolean var7123F851FBEE3C76B17CEBC3B4CD2BA7_899222098 = (h != p && casHead(h, p));
            h.lazySetNext(h);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (h != p && casHead(h, p))
            //h.lazySetNext(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:25.405 -0400", hash_original_method = "FA81D040C1BC0670D20AF3D93B255BE4", hash_generated_method = "9B05866281C0CA743170A66C588EFC94")
    @DSModeled(DSC.SAFE)
    final Node<E> succ(Node<E> p) {
        dsTaint.addTaint(p.dsTaint);
        Node<E> next;
        next = p.next;
        return (Node<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Node<E> next = p.next;
        //return (p == next) ? head : next;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:25.431 -0400", hash_original_method = "6C2ABD9F3905A9D98C3CBF8AF5320B8C", hash_generated_method = "5C39D0C722E2D0DED7B233E45E1044C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean offer(E e) {
        dsTaint.addTaint(e.dsTaint);
        checkNotNull(e);
        Node<E> newNode;
        newNode = new Node<E>(e);
        {
            Node<E> t, p;
            t = tail;
            p = t;
            {
                Node<E> q;
                q = p.next;
                {
                    {
                        boolean var2BA484C7DDF9D4041386A4B333B12D81_433596785 = (p.casNext(null, newNode));
                        {
                            casTail(t, newNode);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                p = (t != (t = tail)) ? t : head;
                p = (p != t && t != (t = tail)) ? t : q;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:25.463 -0400", hash_original_method = "1F662EFABD15CE7BE1315E55CBBE7D30", hash_generated_method = "703A162E8D79FF9CA9A6E6DA5B9316D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E poll() {
        {
            {
                Node<E> h, p, q;
                h = head;
                p = h;
                {
                    E item;
                    item = p.item;
                    {
                        boolean varC8C4A461318E46D0BC1501B6EABCDE54_1731085880 = (item != null && p.casItem(item, null));
                        {
                            updateHead(h, ((q = p.next) != null) ? q : p);
                        } //End block
                        {
                            boolean var8BE540D5FC6E4CB40142D36887F473F3_715123575 = ((q = p.next) == null);
                            {
                                updateHead(h, p);
                            } //End block
                            p = q;
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (E)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:25.489 -0400", hash_original_method = "61FBF64CA94D04AD27A6643CEF7D7285", hash_generated_method = "B9C884B0794D32E80DAFBB3A44B51370")
    @DSModeled(DSC.SAFE)
    public E peek() {
        {
            {
                Node<E> h, p, q;
                h = head;
                p = h;
                {
                    E item;
                    item = p.item;
                    {
                        boolean varAD2BE2138A3B6098AAD73179D8035E96_427876167 = (item != null || (q = p.next) == null);
                        {
                            updateHead(h, p);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (E)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:25.498 -0400", hash_original_method = "0B74804F51F2B061D3EF3D31C957BAFB", hash_generated_method = "5FD3A9B636F06835712805ACD0C0E038")
    @DSModeled(DSC.SAFE)
     Node<E> first() {
        {
            {
                Node<E> h, p, q;
                h = head;
                p = h;
                {
                    boolean hasItem;
                    hasItem = (p.item != null);
                    {
                        boolean varFE99A4C31017C1282311C0F02C136904_2002297140 = (hasItem || (q = p.next) == null);
                        {
                            updateHead(h, p);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (Node<E>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:25.514 -0400", hash_original_method = "5BBCBCAD5CC8F01475F9C33B1A8BDA76", hash_generated_method = "977652A4E75B33242B9E41A7CEF4E9F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEmpty() {
        boolean var89FAA2B2667CA18AE9AC7E5CA6DD11F2_755846248 = (first() == null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return first() == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:25.526 -0400", hash_original_method = "8378A4BA724609F4EE8D701FE95A4146", hash_generated_method = "9F66FF420FF21DAA3BFD2951796072CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int size() {
        int count;
        count = 0;
        {
            Node<E> p;
            p = first();
            p = succ(p);
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int count = 0;
        //for (Node<E> p = first(); p != null; p = succ(p))
            //if (p.item != null)
                //if (++count == Integer.MAX_VALUE)
                    //break;
        //return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:25.546 -0400", hash_original_method = "D3CFD955C2206E78AC2D6D0AA96542FF", hash_generated_method = "4788435ACC9E8739A7C51B6FD956A079")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean contains(Object o) {
        dsTaint.addTaint(o.dsTaint);
        {
            Node<E> p;
            p = first();
            p = succ(p);
            {
                E item;
                item = p.item;
                {
                    boolean var78EFDDD54EDA7A2EF92D05AFDA21B0F0_635679662 = (item != null && o.equals(item));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (o == null) return false;
        //for (Node<E> p = first(); p != null; p = succ(p)) {
            //E item = p.item;
            //if (item != null && o.equals(item))
                //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:25.572 -0400", hash_original_method = "47B1B9EE8A66BF6628AC85F9580DDA03", hash_generated_method = "AB0DBCC9B0E2FC2284C21F7C8043F1C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean remove(Object o) {
        dsTaint.addTaint(o.dsTaint);
        Node<E> pred;
        pred = null;
        {
            Node<E> p;
            p = first();
            p = succ(p);
            {
                E item;
                item = p.item;
                {
                    boolean var1884BD078C421998AC004ED6F1FA894F_564672136 = (item != null &&
                o.equals(item) &&
                p.casItem(item, null));
                    {
                        Node<E> next;
                        next = succ(p);
                        pred.casNext(p, next);
                    } //End block
                } //End collapsed parenthetic
                pred = p;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:25.595 -0400", hash_original_method = "C76E29CF6BEEA629C4456D9BD8199C10", hash_generated_method = "A4A972B34971233193196CDE905E7420")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean addAll(Collection<? extends E> c) {
        dsTaint.addTaint(c.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        Node<E> beginningOfTheEnd, last;
        beginningOfTheEnd = null;
        last = null;
        {
            c.iterator().hasNext();
            E e = c.iterator().next();
            {
                checkNotNull(e);
                Node<E> newNode;
                newNode = new Node<E>(e);
                beginningOfTheEnd = last = newNode;
                {
                    last.lazySetNext(newNode);
                    last = newNode;
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            Node<E> t, p;
            t = tail;
            p = t;
            {
                Node<E> q;
                q = p.next;
                {
                    {
                        boolean varB24173BE9368D665F44721313D1CC18A_328929505 = (p.casNext(null, beginningOfTheEnd));
                        {
                            {
                                boolean var07DE4BBC46A16E37AF2F91F79F231BEF_733593577 = (!casTail(t, last));
                                {
                                    t = tail;
                                    casTail(t, last);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                p = (t != (t = tail)) ? t : head;
                p = (p != t && t != (t = tail)) ? t : q;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:25.611 -0400", hash_original_method = "9AE75EDD15A5D634A14FDDC5ABF53B75", hash_generated_method = "FF1BEC386EC89F906412D5641BDB3EBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object[] toArray() {
        ArrayList<E> al;
        al = new ArrayList<E>();
        {
            Node<E> p;
            p = first();
            p = succ(p);
            {
                E item;
                item = p.item;
                al.add(item);
            } //End block
        } //End collapsed parenthetic
        Object[] var367FB3FD9D449090316E00FA3AE7836B_1623126419 = (al.toArray());
        return (Object[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //ArrayList<E> al = new ArrayList<E>();
        //for (Node<E> p = first(); p != null; p = succ(p)) {
            //E item = p.item;
            //if (item != null)
                //al.add(item);
        //}
        //return al.toArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:25.624 -0400", hash_original_method = "1B34191977E7D82DF73C99DC22E56270", hash_generated_method = "AF88D2E73E8FF363C7FBC446D3924B69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        dsTaint.addTaint(a[0].dsTaint);
        int k;
        k = 0;
        Node<E> p;
        {
            p = first();
            p = succ(p);
            {
                E item;
                item = p.item;
                a[k++] = (T)item;
            } //End block
        } //End collapsed parenthetic
        {
            a[k] = null;
        } //End block
        ArrayList<E> al;
        al = new ArrayList<E>();
        {
            Node<E> q;
            q = first();
            q = succ(q);
            {
                E item;
                item = q.item;
                al.add(item);
            } //End block
        } //End collapsed parenthetic
        T[] var7F840E6AFE43943720AED82374A8BF19_1271122657 = (al.toArray(a));
        return (T[])dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:25.637 -0400", hash_original_method = "756A0449DBEE27B15290EF9912B6D98E", hash_generated_method = "94563C56B3FC79F1CAFC9B5EBACD20CD")
    @DSModeled(DSC.SAFE)
    public Iterator<E> iterator() {
        return (Iterator<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Itr();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:25.646 -0400", hash_original_method = "2DB3995911F14A1266042DB21211C241", hash_generated_method = "7F0AB581E452F9496921FE6C24B8C7B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
        dsTaint.addTaint(s.dsTaint);
        s.defaultWriteObject();
        {
            Node<E> p;
            p = first();
            p = succ(p);
            {
                Object item;
                item = p.item;
                s.writeObject(item);
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:25.659 -0400", hash_original_method = "4C4E4F1C2555347B7DA11DAA134BF488", hash_generated_method = "89E4E7BBF5FF6C3F35B94264C3EC23E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
        dsTaint.addTaint(s.dsTaint);
        s.defaultReadObject();
        Node<E> h, t;
        h = null;
        t = null;
        Object item;
        {
            boolean var58A05DCB9BD1EA70E953ADB97702880A_124002442 = ((item = s.readObject()) != null);
            {
                @SuppressWarnings("unchecked") Node<E> newNode;
                newNode = new Node<E>((E) item);
                h = t = newNode;
                {
                    t.lazySetNext(newNode);
                    t = newNode;
                } //End block
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:25.676 -0400", hash_original_method = "BBA8F566F6EBBAE4E624DE5E2288492A", hash_generated_method = "5E8CAC32EF86836AAB409F83647A3C3E")
    private static void checkNotNull(Object v) {
        if (v == null)
            throw new NullPointerException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:25.678 -0400", hash_original_method = "691EF799FFE1B91CC4D8DBAB0EEF43D5", hash_generated_method = "1CA2FDDCE19F4B90B52B2C8D4A2D3F11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean casTail(Node<E> cmp, Node<E> val) {
        dsTaint.addTaint(val.dsTaint);
        dsTaint.addTaint(cmp.dsTaint);
        boolean var148723A1440E79C87AAEF06ABB06011C_1711088707 = (UNSAFE.compareAndSwapObject(this, tailOffset, cmp, val));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return UNSAFE.compareAndSwapObject(this, tailOffset, cmp, val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:25.689 -0400", hash_original_method = "BC5855BB8BED9A25EA66B96BB6A04937", hash_generated_method = "D5EEE00ED3B1D9880C6F19150ED22D8B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean casHead(Node<E> cmp, Node<E> val) {
        dsTaint.addTaint(val.dsTaint);
        dsTaint.addTaint(cmp.dsTaint);
        boolean var2ACD734B2826D29DC9E81F8F842141EB_536877139 = (UNSAFE.compareAndSwapObject(this, headOffset, cmp, val));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return UNSAFE.compareAndSwapObject(this, headOffset, cmp, val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:25.695 -0400", hash_original_method = "AB96ED97F4B21B8760238DEC7BD056B4", hash_generated_method = "68F0716004A175F32999E352B740B9DC")
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
        volatile E item;
        volatile Node<E> next;
        private static sun.misc.Unsafe UNSAFE =
            sun.misc.Unsafe.getUnsafe();
        private static long nextOffset =
            objectFieldOffset(UNSAFE, "next", Node.class);
        private static long itemOffset =
            objectFieldOffset(UNSAFE, "item", Node.class);
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:25.704 -0400", hash_original_method = "368F2FAFC4A206C09EED76798A5342BA", hash_generated_method = "42D6FA2D6B72C6EE7378F06BA1E5F9D6")
        @DSModeled(DSC.SAFE)
         Node(E item) {
            dsTaint.addTaint(item.dsTaint);
            UNSAFE.putObject(this, itemOffset, item);
            // ---------- Original Method ----------
            //UNSAFE.putObject(this, itemOffset, item);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:25.716 -0400", hash_original_method = "51A0AA76262E736F2E39BE7CE12CF006", hash_generated_method = "C07638FEE6AF10CAEAAF38D2ED06955F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         boolean casItem(E cmp, E val) {
            dsTaint.addTaint(val.dsTaint);
            dsTaint.addTaint(cmp.dsTaint);
            boolean varAB73C02AC2746F108426D5EF37A2AE33_1140638531 = (UNSAFE.compareAndSwapObject(this, itemOffset, cmp, val));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return UNSAFE.compareAndSwapObject(this, itemOffset, cmp, val);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:25.719 -0400", hash_original_method = "E78DBD679DC5F596F67B7449AE69FAB3", hash_generated_method = "04A07932BB286942E39A39FFA5375647")
        @DSModeled(DSC.SAFE)
         void lazySetNext(Node<E> val) {
            dsTaint.addTaint(val.dsTaint);
            UNSAFE.putOrderedObject(this, nextOffset, val);
            // ---------- Original Method ----------
            //UNSAFE.putOrderedObject(this, nextOffset, val);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:25.729 -0400", hash_original_method = "C86D1E5E3D7752CB8E68445595A8E8EC", hash_generated_method = "CCCA1615191422F60F9B7AEE80DD55F2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         boolean casNext(Node<E> cmp, Node<E> val) {
            dsTaint.addTaint(val.dsTaint);
            dsTaint.addTaint(cmp.dsTaint);
            boolean var4388198BD3D1F6D9D982D24482ED2DA0_979149628 = (UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val);
        }

        
    }


    
    private class Itr implements Iterator<E> {
        private Node<E> nextNode;
        private E nextItem;
        private Node<E> lastRet;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:25.737 -0400", hash_original_method = "A56873641F7861FCF92703A510E041DF", hash_generated_method = "27E9BF1E48217F80D737AD18DA700B79")
        @DSModeled(DSC.SAFE)
         Itr() {
            advance();
            // ---------- Original Method ----------
            //advance();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:25.746 -0400", hash_original_method = "530B75A5B8DF2D5033AF3BE4C3DEE1C2", hash_generated_method = "B6020E490DC4E5FCC211698DC4BD5C33")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private E advance() {
            lastRet = nextNode;
            E x;
            x = nextItem;
            Node<E> pred, p;
            {
                p = first();
                pred = null;
            } //End block
            {
                pred = nextNode;
                p = succ(nextNode);
            } //End block
            {
                {
                    nextNode = null;
                    nextItem = null;
                } //End block
                E item;
                item = p.item;
                {
                    nextNode = p;
                    nextItem = item;
                } //End block
                {
                    Node<E> next;
                    next = succ(p);
                    pred.casNext(p, next);
                    p = next;
                } //End block
            } //End block
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:25.757 -0400", hash_original_method = "F3203522041DB53AA10973946A26B4E6", hash_generated_method = "02A870B1CD18A3D040C3C90546492FD4")
        @DSModeled(DSC.SAFE)
        public boolean hasNext() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return nextNode != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:25.760 -0400", hash_original_method = "0C68CBDEA1D7969059001FABF149348A", hash_generated_method = "B23B71CAD820D884BAD840896AA3B4CB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public E next() {
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            E var06C984C418BB2C627029508CB7AB6FB4_915011685 = (advance());
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (nextNode == null) throw new NoSuchElementException();
            //return advance();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:25.769 -0400", hash_original_method = "4D06856C6560F115B6FF7F073DDF82B7", hash_generated_method = "BEA502BF2472949D1A527C45EE19F28B")
        @DSModeled(DSC.SAFE)
        public void remove() {
            Node<E> l;
            l = lastRet;
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            l.item = null;
            lastRet = null;
            // ---------- Original Method ----------
            //Node<E> l = lastRet;
            //if (l == null) throw new IllegalStateException();
            //l.item = null;
            //lastRet = null;
        }

        
    }


    
}


