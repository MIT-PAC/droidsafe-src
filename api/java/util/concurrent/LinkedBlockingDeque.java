package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LinkedBlockingDeque<E> extends AbstractQueue<E> implements BlockingDeque<E>, java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.700 -0400", hash_original_field = "8B04D5E3775D298E78455EFC5CA404D5", hash_generated_field = "B953F2DA9AB6C212A9E3462BBC6D0DD3")

    transient Node<E> first;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.701 -0400", hash_original_field = "98BD1C45684CF587AC2347A92DD7BB51", hash_generated_field = "68FEEFB065E74B1419C2CD65ECD35DDE")

    transient Node<E> last;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.702 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "FF3E1C3A7415684C56884C6A4B36275E")

    private transient int count;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.703 -0400", hash_original_field = "7BD14A231864E618E1840C7E117E59C1", hash_generated_field = "277B4266A058D752E724058E1F215618")

    private int capacity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.705 -0400", hash_original_field = "CD2F0EC2CC3E15FC9F14D13EF4CCDCBB", hash_generated_field = "B0934DA6255E093761388B9A5B38B6D7")

    final ReentrantLock lock = new ReentrantLock();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.706 -0400", hash_original_field = "BBA850CA76BD62A0E877882CD64D6154", hash_generated_field = "9FD9379D1FC8CCF1865C665664A25E7F")

    private final Condition notEmpty = lock.newCondition();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.707 -0400", hash_original_field = "5E8F964E21EE9116314CFB10D69DF8BF", hash_generated_field = "19093F87C48F83B3E20DD52DF9B24BF6")

    private final Condition notFull = lock.newCondition();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.708 -0400", hash_original_method = "249100E9D6D687E7D39D2C34E44C91A8", hash_generated_method = "E3BE42F00612F355BFAC74D87EF1DA2E")
    public  LinkedBlockingDeque() {
        this(Integer.MAX_VALUE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.711 -0400", hash_original_method = "FF241F26E4F2B23472530DEBE913F0CA", hash_generated_method = "A6D67A58433C9C995BC626F9AF54921B")
    public  LinkedBlockingDeque(int capacity) {
        if(capacity <= 0)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_723836431 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_723836431.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_723836431;
        }
        this.capacity = capacity;
        // ---------- Original Method ----------
        //if (capacity <= 0) throw new IllegalArgumentException();
        //this.capacity = capacity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.714 -0400", hash_original_method = "439D82303085A1CC8269C4DDD811FDB3", hash_generated_method = "34AC68F131991B2B961A7CAEFCB03225")
    public  LinkedBlockingDeque(Collection<? extends E> c) {
        this(Integer.MAX_VALUE);
        addTaint(c.getTaint());
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
for(E e : c)
            {
                if(e == null)                
                {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_2088851222 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_2088851222.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_2088851222;
                }
                if(!linkLast(new Node<E>(e)))                
                {
                IllegalStateException varF42F43A7DF8B59692CD142A79563FD41_1453177142 = new IllegalStateException("Deque full");
                varF42F43A7DF8B59692CD142A79563FD41_1453177142.addTaint(taint);
                throw varF42F43A7DF8B59692CD142A79563FD41_1453177142;
                }
            } //End block
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //for (E e : c) {
                //if (e == null)
                    //throw new NullPointerException();
                //if (!linkLast(new Node<E>(e)))
                    //throw new IllegalStateException("Deque full");
            //}
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.720 -0400", hash_original_method = "F1FEA35FDC461C140B4532DA56C7987F", hash_generated_method = "189573407A78815D1D5FA47C990276CF")
    private boolean linkFirst(Node<E> node) {
        if(count >= capacity)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1303272254 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1242020503 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1242020503;
        }
        Node<E> f = first;
        node.next = f;
        first = node;
        if(last == null)        
        last = node;
        else
        f.prev = node;
        ++count;
        notEmpty.signal();
        boolean varB326B5062B2F0E69046810717534CB09_1448587823 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_157866969 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_157866969;
        // ---------- Original Method ----------
        //if (count >= capacity)
            //return false;
        //Node<E> f = first;
        //node.next = f;
        //first = node;
        //if (last == null)
            //last = node;
        //else
            //f.prev = node;
        //++count;
        //notEmpty.signal();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.729 -0400", hash_original_method = "A7FA4F0AF7ECA6F754653DE93F8ED423", hash_generated_method = "00E24EF7B726C9A205C9D413BE809E13")
    private boolean linkLast(Node<E> node) {
        if(count >= capacity)        
        {
        boolean var68934A3E9455FA72420237EB05902327_265188282 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_895227393 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_895227393;
        }
        Node<E> l = last;
        node.prev = l;
        last = node;
        if(first == null)        
        first = node;
        else
        l.next = node;
        ++count;
        notEmpty.signal();
        boolean varB326B5062B2F0E69046810717534CB09_1412616527 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_298509240 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_298509240;
        // ---------- Original Method ----------
        //if (count >= capacity)
            //return false;
        //Node<E> l = last;
        //node.prev = l;
        //last = node;
        //if (first == null)
            //first = node;
        //else
            //l.next = node;
        //++count;
        //notEmpty.signal();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.737 -0400", hash_original_method = "B7345027764D354450098F40DD004B57", hash_generated_method = "35DB90E7A7F154AD4BEB88B9F67BCD08")
    private E unlinkFirst() {
        Node<E> f = first;
        if(f == null)        
        {
E var540C13E9E156B687226421B24F2DF178_497948969 =         null;
        var540C13E9E156B687226421B24F2DF178_497948969.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_497948969;
        }
        Node<E> n = f.next;
        E item = f.item;
        f.item = null;
        f.next = f;
        first = n;
        if(n == null)        
        last = null;
        else
        n.prev = null;
        --count;
        notFull.signal();
E var393CF4FD24220F0ED4B080A1E7108CD3_770806298 =         item;
        var393CF4FD24220F0ED4B080A1E7108CD3_770806298.addTaint(taint);
        return var393CF4FD24220F0ED4B080A1E7108CD3_770806298;
        // ---------- Original Method ----------
        //Node<E> f = first;
        //if (f == null)
            //return null;
        //Node<E> n = f.next;
        //E item = f.item;
        //f.item = null;
        //f.next = f;
        //first = n;
        //if (n == null)
            //last = null;
        //else
            //n.prev = null;
        //--count;
        //notFull.signal();
        //return item;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.746 -0400", hash_original_method = "AF190978DF5C122F110919244C9479F2", hash_generated_method = "E9807FBE7F1CC160386518861D65C777")
    private E unlinkLast() {
        Node<E> l = last;
        if(l == null)        
        {
E var540C13E9E156B687226421B24F2DF178_1108785489 =         null;
        var540C13E9E156B687226421B24F2DF178_1108785489.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1108785489;
        }
        Node<E> p = l.prev;
        E item = l.item;
        l.item = null;
        l.prev = l;
        last = p;
        if(p == null)        
        first = null;
        else
        p.next = null;
        --count;
        notFull.signal();
E var393CF4FD24220F0ED4B080A1E7108CD3_664473672 =         item;
        var393CF4FD24220F0ED4B080A1E7108CD3_664473672.addTaint(taint);
        return var393CF4FD24220F0ED4B080A1E7108CD3_664473672;
        // ---------- Original Method ----------
        //Node<E> l = last;
        //if (l == null)
            //return null;
        //Node<E> p = l.prev;
        //E item = l.item;
        //l.item = null;
        //l.prev = l;
        //last = p;
        //if (p == null)
            //first = null;
        //else
            //p.next = null;
        //--count;
        //notFull.signal();
        //return item;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.751 -0400", hash_original_method = "1D9FD16EE202C66D2F53FBE6A3602BA7", hash_generated_method = "71BE392BB8FB689880D711985156CDE4")
     void unlink(Node<E> x) {
        addTaint(x.getTaint());
        Node<E> p = x.prev;
        Node<E> n = x.next;
        if(p == null)        
        {
            unlinkFirst();
        } //End block
        else
        if(n == null)        
        {
            unlinkLast();
        } //End block
        else
        {
            p.next = n;
            n.prev = p;
            x.item = null;
            --count;
            notFull.signal();
        } //End block
        // ---------- Original Method ----------
        //Node<E> p = x.prev;
        //Node<E> n = x.next;
        //if (p == null) {
            //unlinkFirst();
        //} else if (n == null) {
            //unlinkLast();
        //} else {
            //p.next = n;
            //n.prev = p;
            //x.item = null;
            //--count;
            //notFull.signal();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.755 -0400", hash_original_method = "E867E212B6967896682403DEE3888034", hash_generated_method = "7582751F485806E51ECBE47F35632277")
    public void addFirst(E e) {
        addTaint(e.getTaint());
        if(!offerFirst(e))        
        {
        IllegalStateException varF42F43A7DF8B59692CD142A79563FD41_328626291 = new IllegalStateException("Deque full");
        varF42F43A7DF8B59692CD142A79563FD41_328626291.addTaint(taint);
        throw varF42F43A7DF8B59692CD142A79563FD41_328626291;
        }
        // ---------- Original Method ----------
        //if (!offerFirst(e))
            //throw new IllegalStateException("Deque full");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.757 -0400", hash_original_method = "B487A5071408DAF9039EED205B0601B1", hash_generated_method = "CA6B1E4D3CC01CB245BB0F809DA4EE10")
    public void addLast(E e) {
        addTaint(e.getTaint());
        if(!offerLast(e))        
        {
        IllegalStateException varF42F43A7DF8B59692CD142A79563FD41_1146361615 = new IllegalStateException("Deque full");
        varF42F43A7DF8B59692CD142A79563FD41_1146361615.addTaint(taint);
        throw varF42F43A7DF8B59692CD142A79563FD41_1146361615;
        }
        // ---------- Original Method ----------
        //if (!offerLast(e))
            //throw new IllegalStateException("Deque full");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.761 -0400", hash_original_method = "BE955938F466098B732744A4435FF66E", hash_generated_method = "EC22509A82FC7F32F332BF54BA1E66B6")
    public boolean offerFirst(E e) {
        addTaint(e.getTaint());
        if(e == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_291010558 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_291010558.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_291010558;
        }
        Node<E> node = new Node<E>(e);
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            boolean var6A99E317DA6D53156DC90C1CE1017904_1350548070 = (linkFirst(node));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1973974282 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1973974282;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        // ---------- Original Method ----------
        //if (e == null) throw new NullPointerException();
        //Node<E> node = new Node<E>(e);
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //return linkFirst(node);
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.764 -0400", hash_original_method = "1944181CAD6733F95AAB9BA74E74F57C", hash_generated_method = "00B53549DEA5FE572C07D9F3F013E8AB")
    public boolean offerLast(E e) {
        addTaint(e.getTaint());
        if(e == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_277402301 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_277402301.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_277402301;
        }
        Node<E> node = new Node<E>(e);
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            boolean var80D160ABD932875C09EEE3F72E6759B0_664195061 = (linkLast(node));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1438259986 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1438259986;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        // ---------- Original Method ----------
        //if (e == null) throw new NullPointerException();
        //Node<E> node = new Node<E>(e);
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //return linkLast(node);
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.769 -0400", hash_original_method = "C2A955C9F8C1BE3FAF21A972EF83A87B", hash_generated_method = "0B7C4D136460B71A8845D9E1EC44C0F4")
    public void putFirst(E e) throws InterruptedException {
        addTaint(e.getTaint());
        if(e == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1657671398 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1657671398.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1657671398;
        }
        Node<E> node = new Node<E>(e);
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            while
(!linkFirst(node))            
            notFull.await();
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        // ---------- Original Method ----------
        //if (e == null) throw new NullPointerException();
        //Node<E> node = new Node<E>(e);
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //while (!linkFirst(node))
                //notFull.await();
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.772 -0400", hash_original_method = "90F899FEDAEBCF4E183EEEA72670B0D4", hash_generated_method = "C72AF4189B78C19E8236EF8ECCECCAAF")
    public void putLast(E e) throws InterruptedException {
        addTaint(e.getTaint());
        if(e == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1589981557 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1589981557.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1589981557;
        }
        Node<E> node = new Node<E>(e);
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            while
(!linkLast(node))            
            notFull.await();
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        // ---------- Original Method ----------
        //if (e == null) throw new NullPointerException();
        //Node<E> node = new Node<E>(e);
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //while (!linkLast(node))
                //notFull.await();
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.776 -0400", hash_original_method = "14A0E8066E53E8F404179324D8A2A7E0", hash_generated_method = "79563520EBDF7EC35BD1B68DE15E1782")
    public boolean offerFirst(E e, long timeout, TimeUnit unit) throws InterruptedException {
        addTaint(unit.getTaint());
        addTaint(timeout);
        addTaint(e.getTaint());
        if(e == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_630863704 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_630863704.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_630863704;
        }
        Node<E> node = new Node<E>(e);
        long nanos = unit.toNanos(timeout);
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try 
        {
            while
(!linkFirst(node))            
            {
                if(nanos <= 0)                
                {
                boolean var68934A3E9455FA72420237EB05902327_792621826 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1936988314 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1936988314;
                }
                nanos = notFull.awaitNanos(nanos);
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_792453593 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_179923656 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_179923656;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        // ---------- Original Method ----------
        //if (e == null) throw new NullPointerException();
        //Node<E> node = new Node<E>(e);
        //long nanos = unit.toNanos(timeout);
        //final ReentrantLock lock = this.lock;
        //lock.lockInterruptibly();
        //try {
            //while (!linkFirst(node)) {
                //if (nanos <= 0)
                    //return false;
                //nanos = notFull.awaitNanos(nanos);
            //}
            //return true;
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.783 -0400", hash_original_method = "D6F2690B9DE8E1D2C78F1E640A084B19", hash_generated_method = "141516A9E84557E16FD244F9FA15C817")
    public boolean offerLast(E e, long timeout, TimeUnit unit) throws InterruptedException {
        addTaint(unit.getTaint());
        addTaint(timeout);
        addTaint(e.getTaint());
        if(e == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_721138077 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_721138077.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_721138077;
        }
        Node<E> node = new Node<E>(e);
        long nanos = unit.toNanos(timeout);
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try 
        {
            while
(!linkLast(node))            
            {
                if(nanos <= 0)                
                {
                boolean var68934A3E9455FA72420237EB05902327_536979506 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_604555789 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_604555789;
                }
                nanos = notFull.awaitNanos(nanos);
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_780396990 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_194655445 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_194655445;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        // ---------- Original Method ----------
        //if (e == null) throw new NullPointerException();
        //Node<E> node = new Node<E>(e);
        //long nanos = unit.toNanos(timeout);
        //final ReentrantLock lock = this.lock;
        //lock.lockInterruptibly();
        //try {
            //while (!linkLast(node)) {
                //if (nanos <= 0)
                    //return false;
                //nanos = notFull.awaitNanos(nanos);
            //}
            //return true;
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.787 -0400", hash_original_method = "8D1F2D8C9F4BF8EC3B65B975014CE8A7", hash_generated_method = "357511A3359C1E9FF2C6B2C5F1ABBCC3")
    public E removeFirst() {
        E x = pollFirst();
        if(x == null)        
        {
        NoSuchElementException var28D00AB599969908D71F102AF992D49A_523009090 = new NoSuchElementException();
        var28D00AB599969908D71F102AF992D49A_523009090.addTaint(taint);
        throw var28D00AB599969908D71F102AF992D49A_523009090;
        }
E varEA5659DA512DECF23E6D37EE8060D074_1346261231 =         x;
        varEA5659DA512DECF23E6D37EE8060D074_1346261231.addTaint(taint);
        return varEA5659DA512DECF23E6D37EE8060D074_1346261231;
        // ---------- Original Method ----------
        //E x = pollFirst();
        //if (x == null) throw new NoSuchElementException();
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.791 -0400", hash_original_method = "90A521D0942C6C4821F3F861C2808726", hash_generated_method = "CE085DAB95A48A7BF408598D252F44C5")
    public E removeLast() {
        E x = pollLast();
        if(x == null)        
        {
        NoSuchElementException var28D00AB599969908D71F102AF992D49A_2091502878 = new NoSuchElementException();
        var28D00AB599969908D71F102AF992D49A_2091502878.addTaint(taint);
        throw var28D00AB599969908D71F102AF992D49A_2091502878;
        }
E varEA5659DA512DECF23E6D37EE8060D074_178010785 =         x;
        varEA5659DA512DECF23E6D37EE8060D074_178010785.addTaint(taint);
        return varEA5659DA512DECF23E6D37EE8060D074_178010785;
        // ---------- Original Method ----------
        //E x = pollLast();
        //if (x == null) throw new NoSuchElementException();
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.794 -0400", hash_original_method = "4BCCC1BED6E23489D206E4138D3675FF", hash_generated_method = "C65A4B8B7D72B8E17BDB55B75DC8B546")
    public E pollFirst() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
E var85C21652916C45578E50EC82F29D1047_292336918 =             unlinkFirst();
            var85C21652916C45578E50EC82F29D1047_292336918.addTaint(taint);
            return var85C21652916C45578E50EC82F29D1047_292336918;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //return unlinkFirst();
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.798 -0400", hash_original_method = "D2B0F76144A8C0FD857C7F3A67B82206", hash_generated_method = "E331A72CA246ED3F6E29137AD220741C")
    public E pollLast() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
E var54A55219231E40FBC21CEF5052C2810C_851486419 =             unlinkLast();
            var54A55219231E40FBC21CEF5052C2810C_851486419.addTaint(taint);
            return var54A55219231E40FBC21CEF5052C2810C_851486419;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //return unlinkLast();
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.801 -0400", hash_original_method = "AF3CDBD12E7133B877B3C968B0B44866", hash_generated_method = "9D4C1324D535A421F86F3E6DE6ECCCEE")
    public E takeFirst() throws InterruptedException {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            E x;
            while
((x = unlinkFirst()) == null)            
            notEmpty.await();
E varEA5659DA512DECF23E6D37EE8060D074_1018400453 =             x;
            varEA5659DA512DECF23E6D37EE8060D074_1018400453.addTaint(taint);
            return varEA5659DA512DECF23E6D37EE8060D074_1018400453;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //E x;
            //while ( (x = unlinkFirst()) == null)
                //notEmpty.await();
            //return x;
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.807 -0400", hash_original_method = "FB7D91E8092FFF58EBD05C4560E68DC5", hash_generated_method = "C97B38FA1E76D8FA9B47C623DF8D0FCB")
    public E takeLast() throws InterruptedException {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            E x;
            while
((x = unlinkLast()) == null)            
            notEmpty.await();
E varEA5659DA512DECF23E6D37EE8060D074_896868952 =             x;
            varEA5659DA512DECF23E6D37EE8060D074_896868952.addTaint(taint);
            return varEA5659DA512DECF23E6D37EE8060D074_896868952;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //E x;
            //while ( (x = unlinkLast()) == null)
                //notEmpty.await();
            //return x;
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.813 -0400", hash_original_method = "F9AABEF2F1BCB257250D3454F49A6E99", hash_generated_method = "9C549B86B749B2A69A0A31B0DF02300B")
    public E pollFirst(long timeout, TimeUnit unit) throws InterruptedException {
        addTaint(unit.getTaint());
        addTaint(timeout);
        long nanos = unit.toNanos(timeout);
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try 
        {
            E x;
            while
((x = unlinkFirst()) == null)            
            {
                if(nanos <= 0)                
                {
E var540C13E9E156B687226421B24F2DF178_698979028 =                 null;
                var540C13E9E156B687226421B24F2DF178_698979028.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_698979028;
                }
                nanos = notEmpty.awaitNanos(nanos);
            } //End block
E varEA5659DA512DECF23E6D37EE8060D074_2018854566 =             x;
            varEA5659DA512DECF23E6D37EE8060D074_2018854566.addTaint(taint);
            return varEA5659DA512DECF23E6D37EE8060D074_2018854566;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        // ---------- Original Method ----------
        //long nanos = unit.toNanos(timeout);
        //final ReentrantLock lock = this.lock;
        //lock.lockInterruptibly();
        //try {
            //E x;
            //while ( (x = unlinkFirst()) == null) {
                //if (nanos <= 0)
                    //return null;
                //nanos = notEmpty.awaitNanos(nanos);
            //}
            //return x;
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.823 -0400", hash_original_method = "441DC167F175C62B6ECB09DED87CDC8D", hash_generated_method = "EA9A9A0837B0168E873F076B1D1B0D04")
    public E pollLast(long timeout, TimeUnit unit) throws InterruptedException {
        addTaint(unit.getTaint());
        addTaint(timeout);
        long nanos = unit.toNanos(timeout);
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try 
        {
            E x;
            while
((x = unlinkLast()) == null)            
            {
                if(nanos <= 0)                
                {
E var540C13E9E156B687226421B24F2DF178_519532006 =                 null;
                var540C13E9E156B687226421B24F2DF178_519532006.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_519532006;
                }
                nanos = notEmpty.awaitNanos(nanos);
            } //End block
E varEA5659DA512DECF23E6D37EE8060D074_883451070 =             x;
            varEA5659DA512DECF23E6D37EE8060D074_883451070.addTaint(taint);
            return varEA5659DA512DECF23E6D37EE8060D074_883451070;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        // ---------- Original Method ----------
        //long nanos = unit.toNanos(timeout);
        //final ReentrantLock lock = this.lock;
        //lock.lockInterruptibly();
        //try {
            //E x;
            //while ( (x = unlinkLast()) == null) {
                //if (nanos <= 0)
                    //return null;
                //nanos = notEmpty.awaitNanos(nanos);
            //}
            //return x;
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.827 -0400", hash_original_method = "F4DA2AE3D58549E0544F32F7ECC367F9", hash_generated_method = "24FAB20005625362E5BC487128EF5E46")
    public E getFirst() {
        E x = peekFirst();
        if(x == null)        
        {
        NoSuchElementException var28D00AB599969908D71F102AF992D49A_1760566042 = new NoSuchElementException();
        var28D00AB599969908D71F102AF992D49A_1760566042.addTaint(taint);
        throw var28D00AB599969908D71F102AF992D49A_1760566042;
        }
E varEA5659DA512DECF23E6D37EE8060D074_346373270 =         x;
        varEA5659DA512DECF23E6D37EE8060D074_346373270.addTaint(taint);
        return varEA5659DA512DECF23E6D37EE8060D074_346373270;
        // ---------- Original Method ----------
        //E x = peekFirst();
        //if (x == null) throw new NoSuchElementException();
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.830 -0400", hash_original_method = "CA6BD988176C06418CE77F8F50D6B256", hash_generated_method = "6779FDFA89AB149B2A96003E6DEB5BD1")
    public E getLast() {
        E x = peekLast();
        if(x == null)        
        {
        NoSuchElementException var28D00AB599969908D71F102AF992D49A_740916984 = new NoSuchElementException();
        var28D00AB599969908D71F102AF992D49A_740916984.addTaint(taint);
        throw var28D00AB599969908D71F102AF992D49A_740916984;
        }
E varEA5659DA512DECF23E6D37EE8060D074_519322036 =         x;
        varEA5659DA512DECF23E6D37EE8060D074_519322036.addTaint(taint);
        return varEA5659DA512DECF23E6D37EE8060D074_519322036;
        // ---------- Original Method ----------
        //E x = peekLast();
        //if (x == null) throw new NoSuchElementException();
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.833 -0400", hash_original_method = "61802C5E2F0A50DC70950560F84AD209", hash_generated_method = "4FE9AEC0EB5C055CA818287E558FD6B5")
    public E peekFirst() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
E var065B29CBD1840C6F91299464D5493225_2125318789 =             (first == null) ? null : first.item;
            var065B29CBD1840C6F91299464D5493225_2125318789.addTaint(taint);
            return var065B29CBD1840C6F91299464D5493225_2125318789;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //return (first == null) ? null : first.item;
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.836 -0400", hash_original_method = "0A003440458459B8BB085FC2BE3ABB07", hash_generated_method = "81FB382360EC8E7BE36BEED0B3F59FD8")
    public E peekLast() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
E varD02DCBCB452BC76CBE86344103CE3A4B_1418348787 =             (last == null) ? null : last.item;
            varD02DCBCB452BC76CBE86344103CE3A4B_1418348787.addTaint(taint);
            return varD02DCBCB452BC76CBE86344103CE3A4B_1418348787;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //return (last == null) ? null : last.item;
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.847 -0400", hash_original_method = "73CE4C57004AC162E8700E668E08F7DA", hash_generated_method = "DD3E8C47BC19646FEDB07570A4C90914")
    public boolean removeFirstOccurrence(Object o) {
        addTaint(o.getTaint());
        if(o == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1396913803 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1391274283 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1391274283;
        }
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
for(Node<E> p = first;p != null;p = p.next)
            {
                if(o.equals(p.item))                
                {
                    unlink(p);
                    boolean varB326B5062B2F0E69046810717534CB09_1563574482 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_463266200 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_463266200;
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_74520330 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_651712562 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_651712562;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        // ---------- Original Method ----------
        //if (o == null) return false;
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //for (Node<E> p = first; p != null; p = p.next) {
                //if (o.equals(p.item)) {
                    //unlink(p);
                    //return true;
                //}
            //}
            //return false;
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.853 -0400", hash_original_method = "D957C1235A0ED720512232AF3579C614", hash_generated_method = "3470A47251B0B62B12C7A14BFEAC9FBE")
    public boolean removeLastOccurrence(Object o) {
        addTaint(o.getTaint());
        if(o == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_592787773 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1885917681 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1885917681;
        }
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
for(Node<E> p = last;p != null;p = p.prev)
            {
                if(o.equals(p.item))                
                {
                    unlink(p);
                    boolean varB326B5062B2F0E69046810717534CB09_122628549 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1941328047 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1941328047;
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_982387155 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_752986567 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_752986567;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        // ---------- Original Method ----------
        //if (o == null) return false;
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //for (Node<E> p = last; p != null; p = p.prev) {
                //if (o.equals(p.item)) {
                    //unlink(p);
                    //return true;
                //}
            //}
            //return false;
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.856 -0400", hash_original_method = "056B268263D9E7E4C2239F12D1024514", hash_generated_method = "F759B75128F51786483D6D27DA22AA4E")
    public boolean add(E e) {
        addTaint(e.getTaint());
        addLast(e);
        boolean varB326B5062B2F0E69046810717534CB09_480093520 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1914040108 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1914040108;
        // ---------- Original Method ----------
        //addLast(e);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.859 -0400", hash_original_method = "90158A89D183AFC9420F99CD4C19A119", hash_generated_method = "182BB205BBA9BF31B9E11E3D4B1B18E7")
    public boolean offer(E e) {
        addTaint(e.getTaint());
        boolean varE4235613B1D945AEF4FDF4363C71A8BF_1137724277 = (offerLast(e));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2125541197 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2125541197;
        // ---------- Original Method ----------
        //return offerLast(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.861 -0400", hash_original_method = "091B896CDB22071FD0356886E4E18520", hash_generated_method = "1DF059A278CE72487C6C6C08EAA045B4")
    public void put(E e) throws InterruptedException {
        addTaint(e.getTaint());
        putLast(e);
        // ---------- Original Method ----------
        //putLast(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.867 -0400", hash_original_method = "04D6F44E140F1E68CFC8217F9A649648", hash_generated_method = "731EDA062F581152DF94DA6DA42FB604")
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        addTaint(unit.getTaint());
        addTaint(timeout);
        addTaint(e.getTaint());
        boolean var4A52FFB6539AC5D193187CF1DF1E676B_1907267553 = (offerLast(e, timeout, unit));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1869624040 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1869624040;
        // ---------- Original Method ----------
        //return offerLast(e, timeout, unit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.872 -0400", hash_original_method = "5200E72EC4A7AF0A97DAC56CA915551B", hash_generated_method = "CB226AC83643CD5177E4593919AFCCD8")
    public E remove() {
E var2157E264C867DE2EF0CC4E40F6B9582B_715093675 =         removeFirst();
        var2157E264C867DE2EF0CC4E40F6B9582B_715093675.addTaint(taint);
        return var2157E264C867DE2EF0CC4E40F6B9582B_715093675;
        // ---------- Original Method ----------
        //return removeFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.875 -0400", hash_original_method = "D6F4991F5239518842015971CA437CF0", hash_generated_method = "B267F504FF11EE87B8DC012F5F740CD9")
    public E poll() {
E var268557EBF9358B7227A2055747F14D9D_1135172486 =         pollFirst();
        var268557EBF9358B7227A2055747F14D9D_1135172486.addTaint(taint);
        return var268557EBF9358B7227A2055747F14D9D_1135172486;
        // ---------- Original Method ----------
        //return pollFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.878 -0400", hash_original_method = "71C603C063999AE26BDD685834231EF7", hash_generated_method = "4695BD337D6CE03097C7292B81BCF7AE")
    public E take() throws InterruptedException {
E var866409523F4A1D60B2F923BD47D885AD_505287785 =         takeFirst();
        var866409523F4A1D60B2F923BD47D885AD_505287785.addTaint(taint);
        return var866409523F4A1D60B2F923BD47D885AD_505287785;
        // ---------- Original Method ----------
        //return takeFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.881 -0400", hash_original_method = "1736A91E2A3C93B5CBB10674E58366F8", hash_generated_method = "0F7EB1687A61C823E1BDA2AF3DF317B5")
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        addTaint(unit.getTaint());
        addTaint(timeout);
E var7A707AA6C4922DD4804C774D94AAF2BB_719155526 =         pollFirst(timeout, unit);
        var7A707AA6C4922DD4804C774D94AAF2BB_719155526.addTaint(taint);
        return var7A707AA6C4922DD4804C774D94AAF2BB_719155526;
        // ---------- Original Method ----------
        //return pollFirst(timeout, unit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.885 -0400", hash_original_method = "C3B5A6F3A12E32CB352921DD8911C7F3", hash_generated_method = "EE6ABB590DC467658C145C312CF11E98")
    public E element() {
E var9C3B53F949FCC17872659181725745DF_2006712622 =         getFirst();
        var9C3B53F949FCC17872659181725745DF_2006712622.addTaint(taint);
        return var9C3B53F949FCC17872659181725745DF_2006712622;
        // ---------- Original Method ----------
        //return getFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.889 -0400", hash_original_method = "A003E27ECA2FE3193555598EEC98E09D", hash_generated_method = "9615DE25BD440BA62E570EDB3F1CC894")
    public E peek() {
E var217A98F40A2036F4314C54A2E490EB26_634703593 =         peekFirst();
        var217A98F40A2036F4314C54A2E490EB26_634703593.addTaint(taint);
        return var217A98F40A2036F4314C54A2E490EB26_634703593;
        // ---------- Original Method ----------
        //return peekFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.894 -0400", hash_original_method = "04FC8DBE8B6CF08AC1A142B1DC50B6B4", hash_generated_method = "4726E1A6B1108CC75447EFAD817406DC")
    public int remainingCapacity() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            int var81BEEE2F9334AC9895DD96ACB462FA4E_591765150 = (capacity - count);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1390093726 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1390093726;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //return capacity - count;
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.899 -0400", hash_original_method = "848AB2101C925A7DB8B05331DC1D79E6", hash_generated_method = "7C2E5392BFE62C1CE6789FAC24D5786A")
    public int drainTo(Collection<? super E> c) {
        addTaint(c.getTaint());
        int var3828B170D96FB98999BED4414DDE0658_1374242867 = (drainTo(c, Integer.MAX_VALUE));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_828378630 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_828378630;
        // ---------- Original Method ----------
        //return drainTo(c, Integer.MAX_VALUE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.904 -0400", hash_original_method = "8D6DC3C307065A1D2B18F15D4F19D5EE", hash_generated_method = "52B0BE084A541FF6D8D0B0D415C44FD6")
    public int drainTo(Collection<? super E> c, int maxElements) {
        addTaint(maxElements);
        addTaint(c.getTaint());
        if(c == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1838448440 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1838448440.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1838448440;
        }
        if(c == this)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_202066614 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_202066614.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_202066614;
        }
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            int n = Math.min(maxElements, count);
for(int i = 0;i < n;i++)
            {
                c.add(first.item);
                unlinkFirst();
            } //End block
            int var7B8B965AD4BCA0E41AB51DE7B31363A1_32789369 = (n);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1347147681 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1347147681;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        // ---------- Original Method ----------
        //if (c == null)
            //throw new NullPointerException();
        //if (c == this)
            //throw new IllegalArgumentException();
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //int n = Math.min(maxElements, count);
            //for (int i = 0; i < n; i++) {
                //c.add(first.item);   
                //unlinkFirst();
            //}
            //return n;
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.909 -0400", hash_original_method = "848DD27BB905F5A807C52ED75E19F6C3", hash_generated_method = "A83DB173C00003D26BF7385B9CAA2489")
    public void push(E e) {
        addTaint(e.getTaint());
        addFirst(e);
        // ---------- Original Method ----------
        //addFirst(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.913 -0400", hash_original_method = "158DA4E81D3B40D802055686181E6101", hash_generated_method = "A27106D7ED01102B647E26CCB4BFC45F")
    public E pop() {
E var2157E264C867DE2EF0CC4E40F6B9582B_772647809 =         removeFirst();
        var2157E264C867DE2EF0CC4E40F6B9582B_772647809.addTaint(taint);
        return var2157E264C867DE2EF0CC4E40F6B9582B_772647809;
        // ---------- Original Method ----------
        //return removeFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.919 -0400", hash_original_method = "953726349F424E37042C19BD0C0A52B8", hash_generated_method = "B0893CA2358691EC3F1ADD4BF2A02584")
    public boolean remove(Object o) {
        addTaint(o.getTaint());
        boolean var6E37986A993A2A916076A1C4367014FB_1788441742 = (removeFirstOccurrence(o));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2098740497 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2098740497;
        // ---------- Original Method ----------
        //return removeFirstOccurrence(o);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.924 -0400", hash_original_method = "455EA274614F97D61B2EABEB4507FE65", hash_generated_method = "A280373D703E5B0F9A26BBF0D04AC59A")
    public int size() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            int varE2942A04780E223B215EB8B663CF5353_1820622690 = (count);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1509225353 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1509225353;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //return count;
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.931 -0400", hash_original_method = "682A3652CE664466B96C29E268D51A9E", hash_generated_method = "5E146CB81C7A0CCF007314842E894707")
    public boolean contains(Object o) {
        addTaint(o.getTaint());
        if(o == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1338696615 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1495124464 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1495124464;
        }
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
for(Node<E> p = first;p != null;p = p.next)
            if(o.equals(p.item))            
            {
            boolean varB326B5062B2F0E69046810717534CB09_1402162563 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_617451771 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_617451771;
            }
            boolean var68934A3E9455FA72420237EB05902327_517590536 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1654620362 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1654620362;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        // ---------- Original Method ----------
        //if (o == null) return false;
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //for (Node<E> p = first; p != null; p = p.next)
                //if (o.equals(p.item))
                    //return true;
            //return false;
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.938 -0400", hash_original_method = "6060745C6F54AC5BF252877A9090AD60", hash_generated_method = "AD5214399DA3DFFA9D1C88F7A743AFC1")
    @SuppressWarnings("unchecked")
    public Object[] toArray() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            Object[] a = new Object[count];
            int k = 0;
for(Node<E> p = first;p != null;p = p.next)
            a[k++] = p.item;
Object[] var3F5343BF1D849954A73F0BB303805FFD_44926136 =             a;
            var3F5343BF1D849954A73F0BB303805FFD_44926136.addTaint(taint);
            return var3F5343BF1D849954A73F0BB303805FFD_44926136;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //Object[] a = new Object[count];
            //int k = 0;
            //for (Node<E> p = first; p != null; p = p.next)
                //a[k++] = p.item;
            //return a;
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.949 -0400", hash_original_method = "ED2A1A13D07CD52AFD81A3297D99D370", hash_generated_method = "8A8E855B9D909F40908C749AED694946")
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        addTaint(a[0].getTaint());
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            if(a.length < count)            
            a = (T[])java.lang.reflect.Array.newInstance
                    (a.getClass().getComponentType(), count);
            int k = 0;
for(Node<E> p = first;p != null;p = p.next)
            a[k++] = (T)p.item;
            if(a.length > k)            
            a[k] = null;
T[] var3F5343BF1D849954A73F0BB303805FFD_2033373084 =             a;
            var3F5343BF1D849954A73F0BB303805FFD_2033373084.addTaint(taint);
            return var3F5343BF1D849954A73F0BB303805FFD_2033373084;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //if (a.length < count)
                //a = (T[])java.lang.reflect.Array.newInstance
                    //(a.getClass().getComponentType(), count);
            //int k = 0;
            //for (Node<E> p = first; p != null; p = p.next)
                //a[k++] = (T)p.item;
            //if (a.length > k)
                //a[k] = null;
            //return a;
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.953 -0400", hash_original_method = "C6BF4E291CC9ACD611C7F11D96A47702", hash_generated_method = "5549E7CD7DF5FFCEE19BC3C5E0C59862")
    public String toString() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            Node<E> p = first;
            if(p == null)            
            {
String varAA6F5C51D397701D3E65BDD2DF6A0CE1_1884540539 =             "[]";
            varAA6F5C51D397701D3E65BDD2DF6A0CE1_1884540539.addTaint(taint);
            return varAA6F5C51D397701D3E65BDD2DF6A0CE1_1884540539;
            }
            StringBuilder sb = new StringBuilder();
            sb.append('[');
for(;;)
            {
                E e = p.item;
                sb.append(e == this ? "(this Collection)" : e);
                p = p.next;
                if(p == null)                
                {
String var9C07C753C7E9BC277E7521552478C668_1715224636 =                 sb.append(']').toString();
                var9C07C753C7E9BC277E7521552478C668_1715224636.addTaint(taint);
                return var9C07C753C7E9BC277E7521552478C668_1715224636;
                }
                sb.append(',').append(' ');
            } //End block
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //Node<E> p = first;
            //if (p == null)
                //return "[]";
            //StringBuilder sb = new StringBuilder();
            //sb.append('[');
            //for (;;) {
                //E e = p.item;
                //sb.append(e == this ? "(this Collection)" : e);
                //p = p.next;
                //if (p == null)
                    //return sb.append(']').toString();
                //sb.append(',').append(' ');
            //}
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.962 -0400", hash_original_method = "1459F438368C53F5F75C3D780C8B3096", hash_generated_method = "0F78623C29194EC3058C76447A93C3C7")
    public void clear() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
for(Node<E> f = first;f != null;)
            {
                f.item = null;
                Node<E> n = f.next;
                f.prev = null;
                f.next = null;
                f = n;
            } //End block
            first = last = null;
            count = 0;
            notFull.signalAll();
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //for (Node<E> f = first; f != null; ) {
                //f.item = null;
                //Node<E> n = f.next;
                //f.prev = null;
                //f.next = null;
                //f = n;
            //}
            //first = last = null;
            //count = 0;
            //notFull.signalAll();
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.966 -0400", hash_original_method = "756A0449DBEE27B15290EF9912B6D98E", hash_generated_method = "F213F6E9DCA6520E48D28E837813F484")
    public Iterator<E> iterator() {
Iterator<E> varB10D928EC6DDAEBFD727C2EDCEC6EDF5_455594950 =         new Itr();
        varB10D928EC6DDAEBFD727C2EDCEC6EDF5_455594950.addTaint(taint);
        return varB10D928EC6DDAEBFD727C2EDCEC6EDF5_455594950;
        // ---------- Original Method ----------
        //return new Itr();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.970 -0400", hash_original_method = "E2FFEA86BDF1CF0D788CD9C05CB28749", hash_generated_method = "AE71AB3BA7EC281B07761C010C93C193")
    public Iterator<E> descendingIterator() {
Iterator<E> varD71DCCF07C208773CB9A425C9B28D734_1061259920 =         new DescendingItr();
        varD71DCCF07C208773CB9A425C9B28D734_1061259920.addTaint(taint);
        return varD71DCCF07C208773CB9A425C9B28D734_1061259920;
        // ---------- Original Method ----------
        //return new DescendingItr();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.973 -0400", hash_original_method = "00D32B8E76B917A114B33777EC6C582C", hash_generated_method = "4278E6237DCE8BF6B1E001C5333C7FB0")
    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
        addTaint(s.getTaint());
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            s.defaultWriteObject();
for(Node<E> p = first;p != null;p = p.next)
            s.writeObject(p.item);
            s.writeObject(null);
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //s.defaultWriteObject();
            //for (Node<E> p = first; p != null; p = p.next)
                //s.writeObject(p.item);
            //s.writeObject(null);
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.977 -0400", hash_original_method = "56ED7CDA4A1F5E7C2D4B953EF10E899A", hash_generated_method = "5FC864D0A1897AC0AF28A7A3C8951862")
    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
        addTaint(s.getTaint());
        s.defaultReadObject();
        count = 0;
        first = null;
        last = null;
for(;;)
        {
            @SuppressWarnings("unchecked") E item = (E)s.readObject();
            if(item == null)            
            break;
            add(item);
        } //End block
        // ---------- Original Method ----------
        //s.defaultReadObject();
        //count = 0;
        //first = null;
        //last = null;
        //for (;;) {
            //@SuppressWarnings("unchecked")
            //E item = (E)s.readObject();
            //if (item == null)
                //break;
            //add(item);
        //}
    }

    
    static final class Node<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.979 -0400", hash_original_field = "447B7147E84BE512208DCC0995D67EBC", hash_generated_field = "25C1B4BE35B7528A52E74D8E56CE9F0B")

        E item;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.980 -0400", hash_original_field = "FCB08B164AC83E09964DEB24F2D2E80B", hash_generated_field = "7FBB8703B6D1E4FD63D7312AF905F1D0")

        Node<E> prev;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.981 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "A089DAAEF049057EDB97CA1342EE38E4")

        Node<E> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.983 -0400", hash_original_method = "E24CFB813CF8D6D3545154C1747D57F8", hash_generated_method = "F143FACCEFEC2EC78FAE43B87B01534B")
          Node(E x) {
            item = x;
            // ---------- Original Method ----------
            //item = x;
        }

        
    }


    
    private abstract class AbstractItr implements Iterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.985 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "A089DAAEF049057EDB97CA1342EE38E4")

        Node<E> next;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.986 -0400", hash_original_field = "F0B5FE0A0CBE5E14CD07AF33AB522BBE", hash_generated_field = "FC047D97EB4DD102072D6594B14B8B33")

        E nextItem;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.987 -0400", hash_original_field = "BB3AE5C41B0FFE5CC0DAF60D4592524F", hash_generated_field = "9782A09877DFB4D434246B92A2C403C0")

        private Node<E> lastRet;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.990 -0400", hash_original_method = "D7A0B463A5093578F0D94B98618BF3C0", hash_generated_method = "DD248D074C274E6AB8B983F351A97A11")
          AbstractItr() {
            final ReentrantLock lock = LinkedBlockingDeque.this.lock;
            lock.lock();
            try 
            {
                next = firstNode();
                nextItem = (next == null) ? null : next.item;
            } //End block
            finally 
            {
                lock.unlock();
            } //End block
            // ---------- Original Method ----------
            //final ReentrantLock lock = LinkedBlockingDeque.this.lock;
            //lock.lock();
            //try {
                //next = firstNode();
                //nextItem = (next == null) ? null : next.item;
            //} finally {
                //lock.unlock();
            //}
        }

        
        abstract Node<E> firstNode();

        
        abstract Node<E> nextNode(Node<E> n);

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:55.996 -0400", hash_original_method = "D73368529643E6DA5D3CCB05A337F2C2", hash_generated_method = "7F945041346F2B7D0377B0DB3DA09CE3")
        private Node<E> succ(Node<E> n) {
            addTaint(n.getTaint());
for(;;)
            {
                Node<E> s = nextNode(n);
                if(s == null)                
                {
Node<E> var540C13E9E156B687226421B24F2DF178_2118433419 =                 null;
                var540C13E9E156B687226421B24F2DF178_2118433419.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_2118433419;
                }
                else
                if(s.item != null)                
                {
Node<E> var0478718F0636FB61899C13801CE9FE09_722157919 =                 s;
                var0478718F0636FB61899C13801CE9FE09_722157919.addTaint(taint);
                return var0478718F0636FB61899C13801CE9FE09_722157919;
                }
                else
                if(s == n)                
                {
Node<E> varF5CD8D7CA701CEA2223F30343E08C456_1806713055 =                 firstNode();
                varF5CD8D7CA701CEA2223F30343E08C456_1806713055.addTaint(taint);
                return varF5CD8D7CA701CEA2223F30343E08C456_1806713055;
                }
                else
                n = s;
            } //End block
            // ---------- Original Method ----------
            //for (;;) {
                //Node<E> s = nextNode(n);
                //if (s == null)
                    //return null;
                //else if (s.item != null)
                    //return s;
                //else if (s == n)
                    //return firstNode();
                //else
                    //n = s;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.000 -0400", hash_original_method = "2DD616E77FD4CF0B4B36F4DDA6D06963", hash_generated_method = "3650A52AB62E3B6230B26DD8C1566EDC")
         void advance() {
            final ReentrantLock lock = LinkedBlockingDeque.this.lock;
            lock.lock();
            try 
            {
                next = succ(next);
                nextItem = (next == null) ? null : next.item;
            } //End block
            finally 
            {
                lock.unlock();
            } //End block
            // ---------- Original Method ----------
            //final ReentrantLock lock = LinkedBlockingDeque.this.lock;
            //lock.lock();
            //try {
                //next = succ(next);
                //nextItem = (next == null) ? null : next.item;
            //} finally {
                //lock.unlock();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.003 -0400", hash_original_method = "5C1B7B0DA20667590A4D5C5559468A28", hash_generated_method = "C899AD311135FB37ECE9EB8CC4F3413B")
        public boolean hasNext() {
            boolean var1D0482B34E42F032728DF2F52373E7A2_1791548933 = (next != null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1787282359 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1787282359;
            // ---------- Original Method ----------
            //return next != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.007 -0400", hash_original_method = "A893921D404CCDA66FADBF0BB5913A0B", hash_generated_method = "38B88956DF9A62AC3F9546C2905904C5")
        public E next() {
            if(next == null)            
            {
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_808246159 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_808246159.addTaint(taint);
            throw var28D00AB599969908D71F102AF992D49A_808246159;
            }
            lastRet = next;
            E x = nextItem;
            advance();
E varEA5659DA512DECF23E6D37EE8060D074_1343687515 =             x;
            varEA5659DA512DECF23E6D37EE8060D074_1343687515.addTaint(taint);
            return varEA5659DA512DECF23E6D37EE8060D074_1343687515;
            // ---------- Original Method ----------
            //if (next == null)
                //throw new NoSuchElementException();
            //lastRet = next;
            //E x = nextItem;
            //advance();
            //return x;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.012 -0400", hash_original_method = "91F393F6D6922E17D234B4F4A87152D4", hash_generated_method = "7DCE8F4B1BF87451B2691A742C55D983")
        public void remove() {
            Node<E> n = lastRet;
            if(n == null)            
            {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_517520907 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_517520907.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_517520907;
            }
            lastRet = null;
            final ReentrantLock lock = LinkedBlockingDeque.this.lock;
            lock.lock();
            try 
            {
                if(n.item != null)                
                unlink(n);
            } //End block
            finally 
            {
                lock.unlock();
            } //End block
            // ---------- Original Method ----------
            //Node<E> n = lastRet;
            //if (n == null)
                //throw new IllegalStateException();
            //lastRet = null;
            //final ReentrantLock lock = LinkedBlockingDeque.this.lock;
            //lock.lock();
            //try {
                //if (n.item != null)
                    //unlink(n);
            //} finally {
                //lock.unlock();
            //}
        }

        
    }


    
    private class Itr extends AbstractItr {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.014 -0400", hash_original_method = "2FF8F1B9AF2988B00A6C7863D292475A", hash_generated_method = "2FF8F1B9AF2988B00A6C7863D292475A")
        public Itr ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.017 -0400", hash_original_method = "F5496DA38BC198471A9339E337F6A141", hash_generated_method = "3AAE4E6FEA5FEBEB8D5876E1965B07F8")
         Node<E> firstNode() {
Node<E> varE482A44025F9BB049EB1ED87F45C5909_653192742 =             first;
            varE482A44025F9BB049EB1ED87F45C5909_653192742.addTaint(taint);
            return varE482A44025F9BB049EB1ED87F45C5909_653192742;
            // ---------- Original Method ----------
            //return first;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.021 -0400", hash_original_method = "7337A72D0DFE873C08C820C315C83AB4", hash_generated_method = "F7F988BC9D7131E30890D535CFF9DC0E")
         Node<E> nextNode(Node<E> n) {
            addTaint(n.getTaint());
Node<E> varA19CA4987492BF572DBA7DC0930E79F5_302681239 =             n.next;
            varA19CA4987492BF572DBA7DC0930E79F5_302681239.addTaint(taint);
            return varA19CA4987492BF572DBA7DC0930E79F5_302681239;
            // ---------- Original Method ----------
            //return n.next;
        }

        
    }


    
    private class DescendingItr extends AbstractItr {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.023 -0400", hash_original_method = "0432E36D4F5ED7D39A08DA6620AAF627", hash_generated_method = "0432E36D4F5ED7D39A08DA6620AAF627")
        public DescendingItr ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.026 -0400", hash_original_method = "935F8554484A3F626F85F03E205FB5CA", hash_generated_method = "B0C30A522AB680A3E253D86372864B11")
         Node<E> firstNode() {
Node<E> var3D331EA760A7BCD3BF7E380A6C79C638_409110253 =             last;
            var3D331EA760A7BCD3BF7E380A6C79C638_409110253.addTaint(taint);
            return var3D331EA760A7BCD3BF7E380A6C79C638_409110253;
            // ---------- Original Method ----------
            //return last;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.029 -0400", hash_original_method = "A98E9809BC87B643D4F952FCC7CB50C4", hash_generated_method = "DA0191C6BBAB1FD9AEA605F67635767A")
         Node<E> nextNode(Node<E> n) {
            addTaint(n.getTaint());
Node<E> varFB816D3342FECDFD216396599AFCC461_116192214 =             n.prev;
            varFB816D3342FECDFD216396599AFCC461_116192214.addTaint(taint);
            return varFB816D3342FECDFD216396599AFCC461_116192214;
            // ---------- Original Method ----------
            //return n.prev;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:56.030 -0400", hash_original_field = "EC69805AB5EB939803A84DAF9D237360", hash_generated_field = "2FC1AEBFA22450C18CBB99BA3CB2FBF7")

    private static final long serialVersionUID = -387911632671998426L;
}

