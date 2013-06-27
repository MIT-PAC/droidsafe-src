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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.861 -0400", hash_original_field = "96E89A298E0A9F469B9AE458D6AFAE9F", hash_generated_field = "B57EDCA0C5D8B188A31356A19160405D")

    private transient volatile Node<E> head;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.861 -0400", hash_original_field = "7AEA2552DFE7EB84B9443B6FC9BA6E01", hash_generated_field = "44C1E7DD6E43696E7B1931FD10B83ECF")

    private transient volatile Node<E> tail;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.861 -0400", hash_original_method = "6A57FB745E5D860E38239AF0DB1591EF", hash_generated_method = "38B3499791573BCF992A48C491B8F223")
    public  ConcurrentLinkedQueue() {
        head = tail = new Node<E>(null);
        // ---------- Original Method ----------
        //head = tail = new Node<E>(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.873 -0400", hash_original_method = "6F01EA166BC3601049062B90A5587D9E", hash_generated_method = "A25D59B6707379F7CD32F2C4464E3DA7")
    public  ConcurrentLinkedQueue(Collection<? extends E> c) {
        Node<E> h, t;
        h = null;
        t = null;
        {
            Iterator<E> var334ED49EB23041C8D120547C1BB713D2_327811890 = (c).iterator();
            var334ED49EB23041C8D120547C1BB713D2_327811890.hasNext();
            E e = var334ED49EB23041C8D120547C1BB713D2_327811890.next();
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
        addTaint(c.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.887 -0400", hash_original_method = "F77A4F330ECF7476CC7AF200B57EFA7F", hash_generated_method = "F11ADF6434000431B9427F89E4964243")
    public boolean add(E e) {
        boolean var42B2AD017FC8EAA920A05640330B5300_778119661 = (offer(e));
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1344275399 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1344275399;
        // ---------- Original Method ----------
        //return offer(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.888 -0400", hash_original_method = "73F32BBDAFE1515404B45EC2F1869A3A", hash_generated_method = "7897470DFAB8C1A554F0CC2225E6AB01")
    final void updateHead(Node<E> h, Node<E> p) {
        {
            boolean var7123F851FBEE3C76B17CEBC3B4CD2BA7_2123024137 = (h != p && casHead(h, p));
            h.lazySetNext(h);
        } //End collapsed parenthetic
        addTaint(h.getTaint());
        addTaint(p.getTaint());
        // ---------- Original Method ----------
        //if (h != p && casHead(h, p))
            //h.lazySetNext(h);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.889 -0400", hash_original_method = "FA81D040C1BC0670D20AF3D93B255BE4", hash_generated_method = "6C8AE18B29CC5CE2AD98CC2195DC6351")
    final Node<E> succ(Node<E> p) {
        Node<E> varB4EAC82CA7396A68D541C85D26508E83_1689396108 = null; //Variable for return #1
        Node<E> next;
        next = p.next;
        varB4EAC82CA7396A68D541C85D26508E83_1689396108 = (p == next) ? head : next;
        addTaint(p.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1689396108.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1689396108;
        // ---------- Original Method ----------
        //Node<E> next = p.next;
        //return (p == next) ? head : next;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.890 -0400", hash_original_method = "6C2ABD9F3905A9D98C3CBF8AF5320B8C", hash_generated_method = "90D91974534AE00A36C8DD2DDA44E25E")
    public boolean offer(E e) {
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
                        boolean var2BA484C7DDF9D4041386A4B333B12D81_822363712 = (p.casNext(null, newNode));
                        {
                            casTail(t, newNode);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                p = (t != (t = tail)) ? t : head;
                p = (p != t && t != (t = tail)) ? t : q;
            } //End block
        } //End collapsed parenthetic
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_235795408 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_235795408;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.897 -0400", hash_original_method = "1F662EFABD15CE7BE1315E55CBBE7D30", hash_generated_method = "7CB82827749F4AD4A50A3B3CE34856F7")
    public E poll() {
        E varB4EAC82CA7396A68D541C85D26508E83_1822130623 = null; //Variable for return #1
        E varB4EAC82CA7396A68D541C85D26508E83_1863474069 = null; //Variable for return #2
        {
            {
                Node<E> h, p, q;
                h = head;
                p = h;
                {
                    E item;
                    item = p.item;
                    {
                        boolean varC8C4A461318E46D0BC1501B6EABCDE54_49965794 = (item != null && p.casItem(item, null));
                        {
                            updateHead(h, ((q = p.next) != null) ? q : p);
                            varB4EAC82CA7396A68D541C85D26508E83_1822130623 = item;
                        } //End block
                        {
                            boolean var8BE540D5FC6E4CB40142D36887F473F3_212835953 = ((q = p.next) == null);
                            {
                                updateHead(h, p);
                                varB4EAC82CA7396A68D541C85D26508E83_1863474069 = null;
                            } //End block
                            p = q;
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        E varA7E53CE21691AB073D9660D615818899_766032980; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_766032980 = varB4EAC82CA7396A68D541C85D26508E83_1822130623;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_766032980 = varB4EAC82CA7396A68D541C85D26508E83_1863474069;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_766032980.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_766032980;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.898 -0400", hash_original_method = "61FBF64CA94D04AD27A6643CEF7D7285", hash_generated_method = "5848CFB3DE88B1E1B8B5056E02A06918")
    public E peek() {
        E varB4EAC82CA7396A68D541C85D26508E83_1362465980 = null; //Variable for return #1
        {
            {
                Node<E> h, p, q;
                h = head;
                p = h;
                {
                    E item;
                    item = p.item;
                    {
                        boolean varAD2BE2138A3B6098AAD73179D8035E96_1596634183 = (item != null || (q = p.next) == null);
                        {
                            updateHead(h, p);
                            varB4EAC82CA7396A68D541C85D26508E83_1362465980 = item;
                        } //End block
                        p = q;
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1362465980.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1362465980;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.912 -0400", hash_original_method = "0B74804F51F2B061D3EF3D31C957BAFB", hash_generated_method = "A2A153B8CA5767A0BD49552616909B8B")
     Node<E> first() {
        Node<E> varB4EAC82CA7396A68D541C85D26508E83_1936556059 = null; //Variable for return #1
        {
            {
                Node<E> h, p, q;
                h = head;
                p = h;
                {
                    boolean hasItem;
                    hasItem = (p.item != null);
                    {
                        boolean varFE99A4C31017C1282311C0F02C136904_361244410 = (hasItem || (q = p.next) == null);
                        {
                            updateHead(h, p);
                            varB4EAC82CA7396A68D541C85D26508E83_1936556059 = hasItem ? p : null;
                        } //End block
                        p = q;
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1936556059.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1936556059;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.912 -0400", hash_original_method = "5BBCBCAD5CC8F01475F9C33B1A8BDA76", hash_generated_method = "6F9CDC02013A2D9FC67B4300F7599E2E")
    public boolean isEmpty() {
        boolean var89FAA2B2667CA18AE9AC7E5CA6DD11F2_1441546273 = (first() == null);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_65870435 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_65870435;
        // ---------- Original Method ----------
        //return first() == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.913 -0400", hash_original_method = "8378A4BA724609F4EE8D701FE95A4146", hash_generated_method = "007862CE7A1094263B1B1200381F9A00")
    public int size() {
        int count;
        count = 0;
        {
            Node<E> p;
            p = first();
            p = succ(p);
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1025590363 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1025590363;
        // ---------- Original Method ----------
        //int count = 0;
        //for (Node<E> p = first(); p != null; p = succ(p))
            //if (p.item != null)
                //if (++count == Integer.MAX_VALUE)
                    //break;
        //return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.913 -0400", hash_original_method = "D3CFD955C2206E78AC2D6D0AA96542FF", hash_generated_method = "109CC6601C64E3760BC96A5BDDFF8B72")
    public boolean contains(Object o) {
        {
            Node<E> p;
            p = first();
            p = succ(p);
            {
                E item;
                item = p.item;
                {
                    boolean var78EFDDD54EDA7A2EF92D05AFDA21B0F0_687173997 = (item != null && o.equals(item));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_595613721 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_595613721;
        // ---------- Original Method ----------
        //if (o == null) return false;
        //for (Node<E> p = first(); p != null; p = succ(p)) {
            //E item = p.item;
            //if (item != null && o.equals(item))
                //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:55.917 -0400", hash_original_method = "47B1B9EE8A66BF6628AC85F9580DDA03", hash_generated_method = "083FFB427AF6C56EDD0A38E5241ED890")
    public boolean remove(Object o) {
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
                    boolean var1884BD078C421998AC004ED6F1FA894F_47294328 = (item != null &&
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
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1445223729 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1445223729;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.191 -0400", hash_original_method = "C76E29CF6BEEA629C4456D9BD8199C10", hash_generated_method = "F008FC0DBEFDF449EFC855480F5051E8")
    public boolean addAll(Collection<? extends E> c) {
        {
            boolean var9AEE7ACC5B0D4AF26CA46D5AFC07CCF3_1400810082 = (c == this);
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End collapsed parenthetic
        Node<E> beginningOfTheEnd, last;
        beginningOfTheEnd = null;
        last = null;
        {
            Iterator<E> var334ED49EB23041C8D120547C1BB713D2_751270644 = (c).iterator();
            var334ED49EB23041C8D120547C1BB713D2_751270644.hasNext();
            E e = var334ED49EB23041C8D120547C1BB713D2_751270644.next();
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
                        boolean varB24173BE9368D665F44721313D1CC18A_1812970722 = (p.casNext(null, beginningOfTheEnd));
                        {
                            {
                                boolean var07DE4BBC46A16E37AF2F91F79F231BEF_567052250 = (!casTail(t, last));
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
        addTaint(c.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_547552367 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_547552367;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.195 -0400", hash_original_method = "9AE75EDD15A5D634A14FDDC5ABF53B75", hash_generated_method = "A58EE5B5F945BCF082BCCFA74A5A4036")
    public Object[] toArray() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_1123560204 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1123560204 = al.toArray();
        varB4EAC82CA7396A68D541C85D26508E83_1123560204.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1123560204;
        // ---------- Original Method ----------
        //ArrayList<E> al = new ArrayList<E>();
        //for (Node<E> p = first(); p != null; p = succ(p)) {
            //E item = p.item;
            //if (item != null)
                //al.add(item);
        //}
        //return al.toArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.220 -0400", hash_original_method = "1B34191977E7D82DF73C99DC22E56270", hash_generated_method = "24D46486483051A245BD552B848914E1")
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_1220989218 = null; //Variable for return #1
        T[] varB4EAC82CA7396A68D541C85D26508E83_167905479 = null; //Variable for return #2
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
            varB4EAC82CA7396A68D541C85D26508E83_1220989218 = a;
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
        varB4EAC82CA7396A68D541C85D26508E83_167905479 = al.toArray(a);
        addTaint(a[0].getTaint());
        T[] varA7E53CE21691AB073D9660D615818899_653601078; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_653601078 = varB4EAC82CA7396A68D541C85D26508E83_1220989218;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_653601078 = varB4EAC82CA7396A68D541C85D26508E83_167905479;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_653601078.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_653601078;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.220 -0400", hash_original_method = "756A0449DBEE27B15290EF9912B6D98E", hash_generated_method = "D3C6FC60264F1B10D85934D76DBCC28A")
    public Iterator<E> iterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_1036944856 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1036944856 = new Itr();
        varB4EAC82CA7396A68D541C85D26508E83_1036944856.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1036944856;
        // ---------- Original Method ----------
        //return new Itr();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.221 -0400", hash_original_method = "2DB3995911F14A1266042DB21211C241", hash_generated_method = "F8F82558564C5F63BE0F091B2FDFF9AC")
    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
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
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //s.defaultWriteObject();
        //for (Node<E> p = first(); p != null; p = succ(p)) {
            //Object item = p.item;
            //if (item != null)
                //s.writeObject(item);
        //}
        //s.writeObject(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.233 -0400", hash_original_method = "4C4E4F1C2555347B7DA11DAA134BF488", hash_generated_method = "3CD8D53BF7BC827A2D3F56764F92FC69")
    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
        s.defaultReadObject();
        Node<E> h, t;
        h = null;
        t = null;
        Object item;
        {
            boolean var58A05DCB9BD1EA70E953ADB97702880A_1537815456 = ((item = s.readObject()) != null);
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
        addTaint(s.getTaint());
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

    
        private static void checkNotNull(Object v) {
        if (v == null)
            throw new NullPointerException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.234 -0400", hash_original_method = "691EF799FFE1B91CC4D8DBAB0EEF43D5", hash_generated_method = "38AE4CE1E91F2B619B47DC39F463F335")
    private boolean casTail(Node<E> cmp, Node<E> val) {
        boolean var148723A1440E79C87AAEF06ABB06011C_921168081 = (UNSAFE.compareAndSwapObject(this, tailOffset, cmp, val));
        addTaint(cmp.getTaint());
        addTaint(val.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1508338736 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1508338736;
        // ---------- Original Method ----------
        //return UNSAFE.compareAndSwapObject(this, tailOffset, cmp, val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.235 -0400", hash_original_method = "BC5855BB8BED9A25EA66B96BB6A04937", hash_generated_method = "C3B16A6C1771F3CF98F869A0BD18CDE8")
    private boolean casHead(Node<E> cmp, Node<E> val) {
        boolean var2ACD734B2826D29DC9E81F8F842141EB_1596694535 = (UNSAFE.compareAndSwapObject(this, headOffset, cmp, val));
        addTaint(cmp.getTaint());
        addTaint(val.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1946366032 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1946366032;
        // ---------- Original Method ----------
        //return UNSAFE.compareAndSwapObject(this, headOffset, cmp, val);
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.235 -0400", hash_original_field = "447B7147E84BE512208DCC0995D67EBC", hash_generated_field = "10095ABA73A923383E44F968C6C62945")

        volatile E item;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.235 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "7BB4D15B501C737F5EC180DC75EDF910")

        volatile Node<E> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.235 -0400", hash_original_method = "368F2FAFC4A206C09EED76798A5342BA", hash_generated_method = "F1023E253DAAA039114181AB1622E4D4")
          Node(E item) {
            UNSAFE.putObject(this, itemOffset, item);
            addTaint(item.getTaint());
            // ---------- Original Method ----------
            //UNSAFE.putObject(this, itemOffset, item);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.251 -0400", hash_original_method = "51A0AA76262E736F2E39BE7CE12CF006", hash_generated_method = "4B68B5D7A7FC64CB58F37BCA93269660")
         boolean casItem(E cmp, E val) {
            boolean varAB73C02AC2746F108426D5EF37A2AE33_1119013116 = (UNSAFE.compareAndSwapObject(this, itemOffset, cmp, val));
            addTaint(cmp.getTaint());
            addTaint(val.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1780022791 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1780022791;
            // ---------- Original Method ----------
            //return UNSAFE.compareAndSwapObject(this, itemOffset, cmp, val);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.251 -0400", hash_original_method = "E78DBD679DC5F596F67B7449AE69FAB3", hash_generated_method = "8C328DE61CED5CC182A880891B0D2DC0")
         void lazySetNext(Node<E> val) {
            UNSAFE.putOrderedObject(this, nextOffset, val);
            addTaint(val.getTaint());
            // ---------- Original Method ----------
            //UNSAFE.putOrderedObject(this, nextOffset, val);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.252 -0400", hash_original_method = "C86D1E5E3D7752CB8E68445595A8E8EC", hash_generated_method = "845417CA4FEBA3BED9939F840F467ACD")
         boolean casNext(Node<E> cmp, Node<E> val) {
            boolean var4388198BD3D1F6D9D982D24482ED2DA0_492566987 = (UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val));
            addTaint(cmp.getTaint());
            addTaint(val.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_614138141 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_614138141;
            // ---------- Original Method ----------
            //return UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.252 -0400", hash_original_field = "3E088F71F6042050BDAAA79B57C7A5CD", hash_generated_field = "C80AC2E3A7FB8F5C36B566CB2C09667F")

        private static sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.252 -0400", hash_original_field = "108A0FC2EFFA51A6A4ED34085DD96763", hash_generated_field = "540A161BFCC8068884C8E991E0880CDD")

        private static long nextOffset = objectFieldOffset(UNSAFE, "next", Node.class);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.252 -0400", hash_original_field = "A5D5E3563F1AF395A91EE0E3AAB35ED9", hash_generated_field = "552DB8B63027F811F67757A1F34106C6")

        private static long itemOffset = objectFieldOffset(UNSAFE, "item", Node.class);
    }


    
    private class Itr implements Iterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.252 -0400", hash_original_field = "06038CE55A37CEF0CD18EC9EDC7B6BC0", hash_generated_field = "BD45C7FA08D8C17CC087E2A8B9D2DBAA")

        private Node<E> nextNode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.252 -0400", hash_original_field = "F0B5FE0A0CBE5E14CD07AF33AB522BBE", hash_generated_field = "97D8B84DA75A48FD27623CFC43E53C30")

        private E nextItem;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.252 -0400", hash_original_field = "BB3AE5C41B0FFE5CC0DAF60D4592524F", hash_generated_field = "9782A09877DFB4D434246B92A2C403C0")

        private Node<E> lastRet;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.252 -0400", hash_original_method = "A56873641F7861FCF92703A510E041DF", hash_generated_method = "9DA9D44375E67CD77614346D5F2A644C")
          Itr() {
            advance();
            // ---------- Original Method ----------
            //advance();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.271 -0400", hash_original_method = "530B75A5B8DF2D5033AF3BE4C3DEE1C2", hash_generated_method = "34BE1BC4B691412AC621394ACFAF3F49")
        private E advance() {
            E varB4EAC82CA7396A68D541C85D26508E83_133958038 = null; //Variable for return #1
            E varB4EAC82CA7396A68D541C85D26508E83_2024105233 = null; //Variable for return #2
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
                    varB4EAC82CA7396A68D541C85D26508E83_133958038 = x;
                } //End block
                E item;
                item = p.item;
                {
                    nextNode = p;
                    nextItem = item;
                    varB4EAC82CA7396A68D541C85D26508E83_2024105233 = x;
                } //End block
                {
                    Node<E> next;
                    next = succ(p);
                    pred.casNext(p, next);
                    p = next;
                } //End block
            } //End block
            E varA7E53CE21691AB073D9660D615818899_841245593; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_841245593 = varB4EAC82CA7396A68D541C85D26508E83_133958038;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_841245593 = varB4EAC82CA7396A68D541C85D26508E83_2024105233;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_841245593.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_841245593;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.272 -0400", hash_original_method = "F3203522041DB53AA10973946A26B4E6", hash_generated_method = "FFF9589814607D31447BE97F82878BB0")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1786198316 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1786198316;
            // ---------- Original Method ----------
            //return nextNode != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.272 -0400", hash_original_method = "0C68CBDEA1D7969059001FABF149348A", hash_generated_method = "9585C8A8B0A6188C7269E963B9FBD231")
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_1481870295 = null; //Variable for return #1
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            varB4EAC82CA7396A68D541C85D26508E83_1481870295 = advance();
            varB4EAC82CA7396A68D541C85D26508E83_1481870295.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1481870295;
            // ---------- Original Method ----------
            //if (nextNode == null) throw new NoSuchElementException();
            //return advance();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.278 -0400", hash_original_method = "4D06856C6560F115B6FF7F073DDF82B7", hash_generated_method = "37F5FB48F695C6C75EF67D8264AEC365")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.279 -0400", hash_original_field = "4A0B1D2A0E315E7FA396E6E695D2A7F6", hash_generated_field = "A642862553075353D0B03EE4CEC8C390")

    private static long serialVersionUID = 196745693267521676L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.279 -0400", hash_original_field = "3E088F71F6042050BDAAA79B57C7A5CD", hash_generated_field = "C80AC2E3A7FB8F5C36B566CB2C09667F")

    private static sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.279 -0400", hash_original_field = "56D723F37A869C1262C5569D7C8C1DA3", hash_generated_field = "D3FF6741C9EDB387B3E098B84B3D75CC")

    private static long headOffset = objectFieldOffset(UNSAFE, "head", ConcurrentLinkedQueue.class);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:56.279 -0400", hash_original_field = "2C6D04E7D796BD39F92EB88FDEC1AE7B", hash_generated_field = "BC9CA0F4E94665A5D19B07E9C3E00BF4")

    private static long tailOffset = objectFieldOffset(UNSAFE, "tail", ConcurrentLinkedQueue.class);
}

