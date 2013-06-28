package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LinkedBlockingDeque<E> extends AbstractQueue<E> implements BlockingDeque<E>, java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.417 -0400", hash_original_field = "8B04D5E3775D298E78455EFC5CA404D5", hash_generated_field = "B953F2DA9AB6C212A9E3462BBC6D0DD3")

    transient Node<E> first;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.417 -0400", hash_original_field = "98BD1C45684CF587AC2347A92DD7BB51", hash_generated_field = "68FEEFB065E74B1419C2CD65ECD35DDE")

    transient Node<E> last;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.418 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "FF3E1C3A7415684C56884C6A4B36275E")

    private transient int count;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.418 -0400", hash_original_field = "7BD14A231864E618E1840C7E117E59C1", hash_generated_field = "277B4266A058D752E724058E1F215618")

    private int capacity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.418 -0400", hash_original_field = "CD2F0EC2CC3E15FC9F14D13EF4CCDCBB", hash_generated_field = "B0934DA6255E093761388B9A5B38B6D7")

    final ReentrantLock lock = new ReentrantLock();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.418 -0400", hash_original_field = "BBA850CA76BD62A0E877882CD64D6154", hash_generated_field = "9FD9379D1FC8CCF1865C665664A25E7F")

    private final Condition notEmpty = lock.newCondition();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.418 -0400", hash_original_field = "5E8F964E21EE9116314CFB10D69DF8BF", hash_generated_field = "19093F87C48F83B3E20DD52DF9B24BF6")

    private final Condition notFull = lock.newCondition();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.418 -0400", hash_original_method = "249100E9D6D687E7D39D2C34E44C91A8", hash_generated_method = "E3BE42F00612F355BFAC74D87EF1DA2E")
    public  LinkedBlockingDeque() {
        this(Integer.MAX_VALUE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.418 -0400", hash_original_method = "FF241F26E4F2B23472530DEBE913F0CA", hash_generated_method = "8682B1E0CAEA70D93A28E8E2B0B15495")
    public  LinkedBlockingDeque(int capacity) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        this.capacity = capacity;
        // ---------- Original Method ----------
        //if (capacity <= 0) throw new IllegalArgumentException();
        //this.capacity = capacity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.421 -0400", hash_original_method = "439D82303085A1CC8269C4DDD811FDB3", hash_generated_method = "158B2618B8BB75223C56EB5C4E62459A")
    public  LinkedBlockingDeque(Collection<? extends E> c) {
        this(Integer.MAX_VALUE);
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            {
                Iterator<E> var334ED49EB23041C8D120547C1BB713D2_342007629 = (c).iterator();
                var334ED49EB23041C8D120547C1BB713D2_342007629.hasNext();
                E e = var334ED49EB23041C8D120547C1BB713D2_342007629.next();
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
                    {
                        boolean var1E9AEB73CCD197914A3E493D7A79F7AE_1620141017 = (!linkLast(new Node<E>(e)));
                        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Deque full");
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        addTaint(c.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.422 -0400", hash_original_method = "F1FEA35FDC461C140B4532DA56C7987F", hash_generated_method = "EB99EFC4BADF137F561223AFB362C6DF")
    private boolean linkFirst(Node<E> node) {
        Node<E> f = first;
        node.next = f;
        first = node;
        last = node;
        f.prev = node;
        notEmpty.signal();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_487571637 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_487571637;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.422 -0400", hash_original_method = "A7FA4F0AF7ECA6F754653DE93F8ED423", hash_generated_method = "CFAD8E0157BACB83D4C35B992C7DEF27")
    private boolean linkLast(Node<E> node) {
        Node<E> l = last;
        node.prev = l;
        last = node;
        first = node;
        l.next = node;
        notEmpty.signal();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2071580143 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2071580143;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.423 -0400", hash_original_method = "B7345027764D354450098F40DD004B57", hash_generated_method = "B6D5185C2D5F3A894AE2C86342FDCA82")
    private E unlinkFirst() {
        E varB4EAC82CA7396A68D541C85D26508E83_914126934 = null; //Variable for return #1
        E varB4EAC82CA7396A68D541C85D26508E83_43655201 = null; //Variable for return #2
        Node<E> f = first;
        varB4EAC82CA7396A68D541C85D26508E83_914126934 = null;
        Node<E> n = f.next;
        E item = f.item;
        f.item = null;
        f.next = f;
        first = n;
        last = null;
        n.prev = null;
        notFull.signal();
        varB4EAC82CA7396A68D541C85D26508E83_43655201 = item;
        E varA7E53CE21691AB073D9660D615818899_46475119; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_46475119 = varB4EAC82CA7396A68D541C85D26508E83_914126934;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_46475119 = varB4EAC82CA7396A68D541C85D26508E83_43655201;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_46475119.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_46475119;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.424 -0400", hash_original_method = "AF190978DF5C122F110919244C9479F2", hash_generated_method = "CCF698A1CE6DBDDC77A87DAA0CEE5F79")
    private E unlinkLast() {
        E varB4EAC82CA7396A68D541C85D26508E83_352822082 = null; //Variable for return #1
        E varB4EAC82CA7396A68D541C85D26508E83_1281934645 = null; //Variable for return #2
        Node<E> l = last;
        varB4EAC82CA7396A68D541C85D26508E83_352822082 = null;
        Node<E> p = l.prev;
        E item = l.item;
        l.item = null;
        l.prev = l;
        last = p;
        first = null;
        p.next = null;
        notFull.signal();
        varB4EAC82CA7396A68D541C85D26508E83_1281934645 = item;
        E varA7E53CE21691AB073D9660D615818899_1417225404; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1417225404 = varB4EAC82CA7396A68D541C85D26508E83_352822082;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1417225404 = varB4EAC82CA7396A68D541C85D26508E83_1281934645;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1417225404.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1417225404;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.424 -0400", hash_original_method = "1D9FD16EE202C66D2F53FBE6A3602BA7", hash_generated_method = "48D05F3B34B18F914232DFFCA97A2728")
     void unlink(Node<E> x) {
        Node<E> p = x.prev;
        Node<E> n = x.next;
        {
            unlinkFirst();
        } //End block
        {
            unlinkLast();
        } //End block
        {
            p.next = n;
            n.prev = p;
            x.item = null;
            notFull.signal();
        } //End block
        addTaint(x.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.425 -0400", hash_original_method = "E867E212B6967896682403DEE3888034", hash_generated_method = "AC320E90337E4C462822AB5F5E369CF6")
    public void addFirst(E e) {
        {
            boolean var5C0D7E3C6AA777739E756E8EAE0C9228_1924385434 = (!offerFirst(e));
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Deque full");
        } //End collapsed parenthetic
        addTaint(e.getTaint());
        // ---------- Original Method ----------
        //if (!offerFirst(e))
            //throw new IllegalStateException("Deque full");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.425 -0400", hash_original_method = "B487A5071408DAF9039EED205B0601B1", hash_generated_method = "75E7AE7BDE95C1D8B95C79CEEB5AEB4C")
    public void addLast(E e) {
        {
            boolean var90637F446D34B905E9B56D462DE169DC_113659587 = (!offerLast(e));
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Deque full");
        } //End collapsed parenthetic
        addTaint(e.getTaint());
        // ---------- Original Method ----------
        //if (!offerLast(e))
            //throw new IllegalStateException("Deque full");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.425 -0400", hash_original_method = "BE955938F466098B732744A4435FF66E", hash_generated_method = "BBB99762EA7293433F8B4F6C9D9AD20F")
    public boolean offerFirst(E e) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        Node<E> node = new Node<E>(e);
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            boolean varE1FB9FCECEF8074AC981D528C7C0CB67_760093642 = (linkFirst(node));
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_343529374 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_343529374;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.426 -0400", hash_original_method = "1944181CAD6733F95AAB9BA74E74F57C", hash_generated_method = "EFB1A8782E0ECFA4045FF86693DE35EC")
    public boolean offerLast(E e) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        Node<E> node = new Node<E>(e);
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            boolean varE012F7B0E47B9110FF28D1A1658A888C_1332065665 = (linkLast(node));
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1684829382 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1684829382;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.426 -0400", hash_original_method = "C2A955C9F8C1BE3FAF21A972EF83A87B", hash_generated_method = "7E644FBA3BD39B834DCE9FF9FCB98C07")
    public void putFirst(E e) throws InterruptedException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        Node<E> node = new Node<E>(e);
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            {
                boolean var2FEC5472714EFC76E0A1E992CA7557AA_2007012202 = (!linkFirst(node));
                notFull.await();
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        addTaint(e.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.426 -0400", hash_original_method = "90F899FEDAEBCF4E183EEEA72670B0D4", hash_generated_method = "CCE7D82F440BC3BA1EF5C9DF76447DA1")
    public void putLast(E e) throws InterruptedException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        Node<E> node = new Node<E>(e);
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            {
                boolean var93E27FF336A9E0ECE5D11949553BA0B7_1670520524 = (!linkLast(node));
                notFull.await();
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        addTaint(e.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.427 -0400", hash_original_method = "14A0E8066E53E8F404179324D8A2A7E0", hash_generated_method = "FCBE27A085F569E38702DAEC6E7D019D")
    public boolean offerFirst(E e, long timeout, TimeUnit unit) throws InterruptedException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        Node<E> node = new Node<E>(e);
        long nanos = unit.toNanos(timeout);
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try 
        {
            {
                boolean var2FEC5472714EFC76E0A1E992CA7557AA_348429517 = (!linkFirst(node));
                {
                    nanos = notFull.awaitNanos(nanos);
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        addTaint(e.getTaint());
        addTaint(timeout);
        addTaint(unit.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_99832056 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_99832056;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.427 -0400", hash_original_method = "D6F2690B9DE8E1D2C78F1E640A084B19", hash_generated_method = "D7E52C2ECD60316B244F299E64BE9EBE")
    public boolean offerLast(E e, long timeout, TimeUnit unit) throws InterruptedException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        Node<E> node = new Node<E>(e);
        long nanos = unit.toNanos(timeout);
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try 
        {
            {
                boolean var93E27FF336A9E0ECE5D11949553BA0B7_503428170 = (!linkLast(node));
                {
                    nanos = notFull.awaitNanos(nanos);
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        addTaint(e.getTaint());
        addTaint(timeout);
        addTaint(unit.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2024371792 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2024371792;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.428 -0400", hash_original_method = "8D1F2D8C9F4BF8EC3B65B975014CE8A7", hash_generated_method = "4F3ACD6CA1DD5FF9BBDF33875CE73CF2")
    public E removeFirst() {
        E varB4EAC82CA7396A68D541C85D26508E83_565054131 = null; //Variable for return #1
        E x = pollFirst();
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_565054131 = x;
        varB4EAC82CA7396A68D541C85D26508E83_565054131.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_565054131;
        // ---------- Original Method ----------
        //E x = pollFirst();
        //if (x == null) throw new NoSuchElementException();
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.428 -0400", hash_original_method = "90A521D0942C6C4821F3F861C2808726", hash_generated_method = "CA6468466EA5B97E20C79A13FC5A8E92")
    public E removeLast() {
        E varB4EAC82CA7396A68D541C85D26508E83_563926073 = null; //Variable for return #1
        E x = pollLast();
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_563926073 = x;
        varB4EAC82CA7396A68D541C85D26508E83_563926073.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_563926073;
        // ---------- Original Method ----------
        //E x = pollLast();
        //if (x == null) throw new NoSuchElementException();
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.429 -0400", hash_original_method = "4BCCC1BED6E23489D206E4138D3675FF", hash_generated_method = "CC392CCA543316638FB48521C12914BD")
    public E pollFirst() {
        E varB4EAC82CA7396A68D541C85D26508E83_1458089539 = null; //Variable for return #1
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1458089539 = unlinkFirst();
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1458089539.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1458089539;
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //return unlinkFirst();
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.429 -0400", hash_original_method = "D2B0F76144A8C0FD857C7F3A67B82206", hash_generated_method = "80239A6893EE157088C3C67573A42306")
    public E pollLast() {
        E varB4EAC82CA7396A68D541C85D26508E83_604227309 = null; //Variable for return #1
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_604227309 = unlinkLast();
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_604227309.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_604227309;
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //return unlinkLast();
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.430 -0400", hash_original_method = "AF3CDBD12E7133B877B3C968B0B44866", hash_generated_method = "285AAA3456887B0E2D9116C4E2C81FC3")
    public E takeFirst() throws InterruptedException {
        E varB4EAC82CA7396A68D541C85D26508E83_383699522 = null; //Variable for return #1
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            E x;
            {
                boolean var694B543BE841898C631F1A346443AC8C_329940078 = ((x = unlinkFirst()) == null);
                notEmpty.await();
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_383699522 = x;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_383699522.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_383699522;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.431 -0400", hash_original_method = "FB7D91E8092FFF58EBD05C4560E68DC5", hash_generated_method = "6C5B075E53F5DA57DEC7BE6CE6491911")
    public E takeLast() throws InterruptedException {
        E varB4EAC82CA7396A68D541C85D26508E83_455674509 = null; //Variable for return #1
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            E x;
            {
                boolean var50D9F533AA08B5FCD2E05DC6B26DB2BD_1394201885 = ((x = unlinkLast()) == null);
                notEmpty.await();
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_455674509 = x;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_455674509.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_455674509;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.431 -0400", hash_original_method = "F9AABEF2F1BCB257250D3454F49A6E99", hash_generated_method = "F5BF2821D28F417C523FC1E5C4F313C1")
    public E pollFirst(long timeout, TimeUnit unit) throws InterruptedException {
        E varB4EAC82CA7396A68D541C85D26508E83_36241552 = null; //Variable for return #1
        E varB4EAC82CA7396A68D541C85D26508E83_812205013 = null; //Variable for return #2
        long nanos = unit.toNanos(timeout);
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try 
        {
            E x;
            {
                boolean var694B543BE841898C631F1A346443AC8C_1645132213 = ((x = unlinkFirst()) == null);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_36241552 = null;
                    nanos = notEmpty.awaitNanos(nanos);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_812205013 = x;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        addTaint(timeout);
        addTaint(unit.getTaint());
        E varA7E53CE21691AB073D9660D615818899_2050462465; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2050462465 = varB4EAC82CA7396A68D541C85D26508E83_36241552;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2050462465 = varB4EAC82CA7396A68D541C85D26508E83_812205013;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2050462465.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2050462465;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.433 -0400", hash_original_method = "441DC167F175C62B6ECB09DED87CDC8D", hash_generated_method = "4F9F7C893E9D2E9D4655925B7BD2845C")
    public E pollLast(long timeout, TimeUnit unit) throws InterruptedException {
        E varB4EAC82CA7396A68D541C85D26508E83_308428126 = null; //Variable for return #1
        E varB4EAC82CA7396A68D541C85D26508E83_869076418 = null; //Variable for return #2
        long nanos = unit.toNanos(timeout);
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try 
        {
            E x;
            {
                boolean var50D9F533AA08B5FCD2E05DC6B26DB2BD_340590117 = ((x = unlinkLast()) == null);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_308428126 = null;
                    nanos = notEmpty.awaitNanos(nanos);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_869076418 = x;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        addTaint(timeout);
        addTaint(unit.getTaint());
        E varA7E53CE21691AB073D9660D615818899_112938547; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_112938547 = varB4EAC82CA7396A68D541C85D26508E83_308428126;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_112938547 = varB4EAC82CA7396A68D541C85D26508E83_869076418;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_112938547.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_112938547;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.434 -0400", hash_original_method = "F4DA2AE3D58549E0544F32F7ECC367F9", hash_generated_method = "B6A39B9C2BB2E51D2F5BB94E95EE27E6")
    public E getFirst() {
        E varB4EAC82CA7396A68D541C85D26508E83_392816540 = null; //Variable for return #1
        E x = peekFirst();
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_392816540 = x;
        varB4EAC82CA7396A68D541C85D26508E83_392816540.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_392816540;
        // ---------- Original Method ----------
        //E x = peekFirst();
        //if (x == null) throw new NoSuchElementException();
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.435 -0400", hash_original_method = "CA6BD988176C06418CE77F8F50D6B256", hash_generated_method = "0B7A6FFB638AFB1C5FC7F78F981A9AD6")
    public E getLast() {
        E varB4EAC82CA7396A68D541C85D26508E83_822337848 = null; //Variable for return #1
        E x = peekLast();
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_822337848 = x;
        varB4EAC82CA7396A68D541C85D26508E83_822337848.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_822337848;
        // ---------- Original Method ----------
        //E x = peekLast();
        //if (x == null) throw new NoSuchElementException();
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.435 -0400", hash_original_method = "61802C5E2F0A50DC70950560F84AD209", hash_generated_method = "EBE1046F809E204340BB77191CDB4047")
    public E peekFirst() {
        E varB4EAC82CA7396A68D541C85D26508E83_1263028423 = null; //Variable for return #1
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1263028423 = (first == null) ? null : first.item;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1263028423.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1263028423;
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //return (first == null) ? null : first.item;
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.436 -0400", hash_original_method = "0A003440458459B8BB085FC2BE3ABB07", hash_generated_method = "5E58E7CA2F1296724B1F80170C0A3AFA")
    public E peekLast() {
        E varB4EAC82CA7396A68D541C85D26508E83_1546620852 = null; //Variable for return #1
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1546620852 = (last == null) ? null : last.item;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1546620852.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1546620852;
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //return (last == null) ? null : last.item;
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.436 -0400", hash_original_method = "73CE4C57004AC162E8700E668E08F7DA", hash_generated_method = "18A7E06530798860ADAA91DF786FD54D")
    public boolean removeFirstOccurrence(Object o) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            {
                Node<E> p = first;
                p = p.next;
                {
                    {
                        boolean varD072E6E000FCF729BD7B2505F48F68BD_1584271988 = (o.equals(p.item));
                        {
                            unlink(p);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2144081819 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2144081819;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.437 -0400", hash_original_method = "D957C1235A0ED720512232AF3579C614", hash_generated_method = "84E3188E786A1719100EC87D5859FC6B")
    public boolean removeLastOccurrence(Object o) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            {
                Node<E> p = last;
                p = p.prev;
                {
                    {
                        boolean varD072E6E000FCF729BD7B2505F48F68BD_851993962 = (o.equals(p.item));
                        {
                            unlink(p);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1790299283 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1790299283;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.437 -0400", hash_original_method = "056B268263D9E7E4C2239F12D1024514", hash_generated_method = "5BFBE36A1003DB029865CB0C5457B11B")
    public boolean add(E e) {
        addLast(e);
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1378622242 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1378622242;
        // ---------- Original Method ----------
        //addLast(e);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.438 -0400", hash_original_method = "90158A89D183AFC9420F99CD4C19A119", hash_generated_method = "98687DBE065681DE01BEDE391F40353C")
    public boolean offer(E e) {
        boolean var1C8D098E0D25C154182D97F2DFA9E90F_75050443 = (offerLast(e));
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_864767410 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_864767410;
        // ---------- Original Method ----------
        //return offerLast(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.438 -0400", hash_original_method = "091B896CDB22071FD0356886E4E18520", hash_generated_method = "809893F6DDC4DDAACE74D73ABDEF1ED8")
    public void put(E e) throws InterruptedException {
        putLast(e);
        addTaint(e.getTaint());
        // ---------- Original Method ----------
        //putLast(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.439 -0400", hash_original_method = "04D6F44E140F1E68CFC8217F9A649648", hash_generated_method = "7833E637F6B8F1D516E6ED22AFCBE5ED")
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        boolean var4F1D7242ECA30177669F884F86DBFB49_1237184001 = (offerLast(e, timeout, unit));
        addTaint(e.getTaint());
        addTaint(timeout);
        addTaint(unit.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1868489494 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1868489494;
        // ---------- Original Method ----------
        //return offerLast(e, timeout, unit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.439 -0400", hash_original_method = "5200E72EC4A7AF0A97DAC56CA915551B", hash_generated_method = "F571C500E96CEEF0BB5894B9BBBFBB21")
    public E remove() {
        E varB4EAC82CA7396A68D541C85D26508E83_699262849 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_699262849 = removeFirst();
        varB4EAC82CA7396A68D541C85D26508E83_699262849.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_699262849;
        // ---------- Original Method ----------
        //return removeFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.440 -0400", hash_original_method = "D6F4991F5239518842015971CA437CF0", hash_generated_method = "F235D1C3B4DD43ACE227E1C4E1CC8B82")
    public E poll() {
        E varB4EAC82CA7396A68D541C85D26508E83_1734201937 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1734201937 = pollFirst();
        varB4EAC82CA7396A68D541C85D26508E83_1734201937.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1734201937;
        // ---------- Original Method ----------
        //return pollFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.441 -0400", hash_original_method = "71C603C063999AE26BDD685834231EF7", hash_generated_method = "954B48AF47D67D4F0DCF74EFC3C2E3DF")
    public E take() throws InterruptedException {
        E varB4EAC82CA7396A68D541C85D26508E83_187185566 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_187185566 = takeFirst();
        varB4EAC82CA7396A68D541C85D26508E83_187185566.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_187185566;
        // ---------- Original Method ----------
        //return takeFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.442 -0400", hash_original_method = "1736A91E2A3C93B5CBB10674E58366F8", hash_generated_method = "67CA593F28DECC223DF87A272325D155")
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        E varB4EAC82CA7396A68D541C85D26508E83_453202580 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_453202580 = pollFirst(timeout, unit);
        addTaint(timeout);
        addTaint(unit.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_453202580.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_453202580;
        // ---------- Original Method ----------
        //return pollFirst(timeout, unit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.443 -0400", hash_original_method = "C3B5A6F3A12E32CB352921DD8911C7F3", hash_generated_method = "BE30DAB8A7D4825F7C9B0BCE5B28CAE0")
    public E element() {
        E varB4EAC82CA7396A68D541C85D26508E83_739428089 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_739428089 = getFirst();
        varB4EAC82CA7396A68D541C85D26508E83_739428089.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_739428089;
        // ---------- Original Method ----------
        //return getFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.444 -0400", hash_original_method = "A003E27ECA2FE3193555598EEC98E09D", hash_generated_method = "360BDD404A303C3E25B3F7FF96E1EE24")
    public E peek() {
        E varB4EAC82CA7396A68D541C85D26508E83_1326480627 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1326480627 = peekFirst();
        varB4EAC82CA7396A68D541C85D26508E83_1326480627.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1326480627;
        // ---------- Original Method ----------
        //return peekFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.446 -0400", hash_original_method = "04FC8DBE8B6CF08AC1A142B1DC50B6B4", hash_generated_method = "4CF81ABCA74FDD36BBEF0901B48402FE")
    public int remainingCapacity() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1074839725 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1074839725;
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //return capacity - count;
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.448 -0400", hash_original_method = "848AB2101C925A7DB8B05331DC1D79E6", hash_generated_method = "33012EDA27336A5BC7DCF0ABB57DC19A")
    public int drainTo(Collection<? super E> c) {
        int var0B753C0ADE2F28D7A7716F28C1FC5A12_1132143365 = (drainTo(c, Integer.MAX_VALUE));
        addTaint(c.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1503628339 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1503628339;
        // ---------- Original Method ----------
        //return drainTo(c, Integer.MAX_VALUE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.449 -0400", hash_original_method = "8D6DC3C307065A1D2B18F15D4F19D5EE", hash_generated_method = "DFEE9B7FC20F1DA581F1D009AACD8215")
    public int drainTo(Collection<? super E> c, int maxElements) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        {
            boolean var9AEE7ACC5B0D4AF26CA46D5AFC07CCF3_840227453 = (c == this);
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End collapsed parenthetic
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            int n = Math.min(maxElements, count);
            {
                int i = 0;
                {
                    c.add(first.item);
                    unlinkFirst();
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        addTaint(c.getTaint());
        addTaint(maxElements);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1707238152 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1707238152;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.450 -0400", hash_original_method = "848DD27BB905F5A807C52ED75E19F6C3", hash_generated_method = "72C186ED1744A0D2DEFAA4DDE67D7864")
    public void push(E e) {
        addFirst(e);
        addTaint(e.getTaint());
        // ---------- Original Method ----------
        //addFirst(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.451 -0400", hash_original_method = "158DA4E81D3B40D802055686181E6101", hash_generated_method = "C1B5F3EFA78B947B53A29ABB75ACD910")
    public E pop() {
        E varB4EAC82CA7396A68D541C85D26508E83_1046773635 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1046773635 = removeFirst();
        varB4EAC82CA7396A68D541C85D26508E83_1046773635.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1046773635;
        // ---------- Original Method ----------
        //return removeFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.451 -0400", hash_original_method = "953726349F424E37042C19BD0C0A52B8", hash_generated_method = "2E02BEE37AB97C7AC1CC6B370E259BCE")
    public boolean remove(Object o) {
        boolean varB3B6A07AEF87793955942F9770654762_1956586270 = (removeFirstOccurrence(o));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1591182291 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1591182291;
        // ---------- Original Method ----------
        //return removeFirstOccurrence(o);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.452 -0400", hash_original_method = "455EA274614F97D61B2EABEB4507FE65", hash_generated_method = "E7689132484BE64F866DFF24C0A7A25E")
    public int size() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_857216568 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_857216568;
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //return count;
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.452 -0400", hash_original_method = "682A3652CE664466B96C29E268D51A9E", hash_generated_method = "630DABC44BFE9AA107C30956007B3C02")
    public boolean contains(Object o) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            {
                Node<E> p = first;
                p = p.next;
                {
                    boolean varF9DBDF4C5289176897871C74CFE4EAD8_751608445 = (o.equals(p.item));
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1764232153 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1764232153;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.453 -0400", hash_original_method = "6060745C6F54AC5BF252877A9090AD60", hash_generated_method = "360329E73BCBCA4F55E44E4CC9EE51A7")
    @SuppressWarnings("unchecked")
    public Object[] toArray() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_1675461833 = null; //Variable for return #1
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            Object[] a = new Object[count];
            int k = 0;
            {
                Node<E> p = first;
                p = p.next;
                a[k++] = p.item;
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1675461833 = a;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1675461833.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1675461833;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.455 -0400", hash_original_method = "ED2A1A13D07CD52AFD81A3297D99D370", hash_generated_method = "959F81D018704A3637A15F32B714D2B8")
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_136726043 = null; //Variable for return #1
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            a = (T[])java.lang.reflect.Array.newInstance
                    (a.getClass().getComponentType(), count);
            int k = 0;
            {
                Node<E> p = first;
                p = p.next;
                a[k++] = (T)p.item;
            } //End collapsed parenthetic
            a[k] = null;
            varB4EAC82CA7396A68D541C85D26508E83_136726043 = a;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        addTaint(a[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_136726043.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_136726043;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.457 -0400", hash_original_method = "C6BF4E291CC9ACD611C7F11D96A47702", hash_generated_method = "6AC39AE81BDCA7CE4D0B7395982D7865")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_202364811 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1277395157 = null; //Variable for return #2
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            Node<E> p = first;
            varB4EAC82CA7396A68D541C85D26508E83_202364811 = "[]";
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            {
                E e = p.item;
                sb.append(e == this ? "(this Collection)" : e);
                p = p.next;
                varB4EAC82CA7396A68D541C85D26508E83_1277395157 = sb.append(']').toString();
                sb.append(',').append(' ');
            } //End block
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1164084359; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1164084359 = varB4EAC82CA7396A68D541C85D26508E83_202364811;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1164084359 = varB4EAC82CA7396A68D541C85D26508E83_1277395157;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1164084359.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1164084359;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.458 -0400", hash_original_method = "1459F438368C53F5F75C3D780C8B3096", hash_generated_method = "5BE1ECBAA94B449FD3670DCADEC44919")
    public void clear() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            {
                Node<E> f = first;
                {
                    f.item = null;
                    Node<E> n = f.next;
                    f.prev = null;
                    f.next = null;
                    f = n;
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.458 -0400", hash_original_method = "756A0449DBEE27B15290EF9912B6D98E", hash_generated_method = "545149777816FCC6F12D0AD3BC75D1CA")
    public Iterator<E> iterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_628410319 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_628410319 = new Itr();
        varB4EAC82CA7396A68D541C85D26508E83_628410319.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_628410319;
        // ---------- Original Method ----------
        //return new Itr();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.459 -0400", hash_original_method = "E2FFEA86BDF1CF0D788CD9C05CB28749", hash_generated_method = "CB4043C7510FCCDDD7BAB28483929BF2")
    public Iterator<E> descendingIterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_294405351 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_294405351 = new DescendingItr();
        varB4EAC82CA7396A68D541C85D26508E83_294405351.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_294405351;
        // ---------- Original Method ----------
        //return new DescendingItr();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.459 -0400", hash_original_method = "00D32B8E76B917A114B33777EC6C582C", hash_generated_method = "98FAB8172ACFE70CB53C2D515AB09AD9")
    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            s.defaultWriteObject();
            {
                Node<E> p = first;
                p = p.next;
                s.writeObject(p.item);
            } //End collapsed parenthetic
            s.writeObject(null);
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        addTaint(s.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.460 -0400", hash_original_method = "56ED7CDA4A1F5E7C2D4B953EF10E899A", hash_generated_method = "A46584781AF0FCE26291140986160D1D")
    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
        s.defaultReadObject();
        count = 0;
        first = null;
        last = null;
        {
            @SuppressWarnings("unchecked") E item = (E)s.readObject();
            add(item);
        } //End block
        addTaint(s.getTaint());
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.460 -0400", hash_original_field = "447B7147E84BE512208DCC0995D67EBC", hash_generated_field = "25C1B4BE35B7528A52E74D8E56CE9F0B")

        E item;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.460 -0400", hash_original_field = "FCB08B164AC83E09964DEB24F2D2E80B", hash_generated_field = "7FBB8703B6D1E4FD63D7312AF905F1D0")

        Node<E> prev;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.460 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "A089DAAEF049057EDB97CA1342EE38E4")

        Node<E> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.460 -0400", hash_original_method = "E24CFB813CF8D6D3545154C1747D57F8", hash_generated_method = "F143FACCEFEC2EC78FAE43B87B01534B")
          Node(E x) {
            item = x;
            // ---------- Original Method ----------
            //item = x;
        }

        
    }


    
    private abstract class AbstractItr implements Iterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.460 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "A089DAAEF049057EDB97CA1342EE38E4")

        Node<E> next;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.460 -0400", hash_original_field = "F0B5FE0A0CBE5E14CD07AF33AB522BBE", hash_generated_field = "FC047D97EB4DD102072D6594B14B8B33")

        E nextItem;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.460 -0400", hash_original_field = "BB3AE5C41B0FFE5CC0DAF60D4592524F", hash_generated_field = "9782A09877DFB4D434246B92A2C403C0")

        private Node<E> lastRet;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.461 -0400", hash_original_method = "D7A0B463A5093578F0D94B98618BF3C0", hash_generated_method = "DD248D074C274E6AB8B983F351A97A11")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.462 -0400", hash_original_method = "D73368529643E6DA5D3CCB05A337F2C2", hash_generated_method = "CC7D19CF1F11975E946EACA2CC38DD9F")
        private Node<E> succ(Node<E> n) {
            Node<E> varB4EAC82CA7396A68D541C85D26508E83_455141150 = null; //Variable for return #1
            Node<E> varB4EAC82CA7396A68D541C85D26508E83_1370008728 = null; //Variable for return #2
            Node<E> varB4EAC82CA7396A68D541C85D26508E83_147268894 = null; //Variable for return #3
            {
                Node<E> s = nextNode(n);
                varB4EAC82CA7396A68D541C85D26508E83_455141150 = null;
                varB4EAC82CA7396A68D541C85D26508E83_1370008728 = s;
                varB4EAC82CA7396A68D541C85D26508E83_147268894 = firstNode();
                n = s;
            } //End block
            addTaint(n.getTaint());
            Node<E> varA7E53CE21691AB073D9660D615818899_471033924; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_471033924 = varB4EAC82CA7396A68D541C85D26508E83_455141150;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_471033924 = varB4EAC82CA7396A68D541C85D26508E83_1370008728;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_471033924 = varB4EAC82CA7396A68D541C85D26508E83_147268894;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_471033924.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_471033924;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.463 -0400", hash_original_method = "2DD616E77FD4CF0B4B36F4DDA6D06963", hash_generated_method = "3650A52AB62E3B6230B26DD8C1566EDC")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.464 -0400", hash_original_method = "5C1B7B0DA20667590A4D5C5559468A28", hash_generated_method = "460E9400E62110ED7BACCF6441226716")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_833234413 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_833234413;
            // ---------- Original Method ----------
            //return next != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.465 -0400", hash_original_method = "A893921D404CCDA66FADBF0BB5913A0B", hash_generated_method = "F35F74F9686B8F6AD0734B46A87E832F")
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_187578739 = null; //Variable for return #1
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            lastRet = next;
            E x = nextItem;
            advance();
            varB4EAC82CA7396A68D541C85D26508E83_187578739 = x;
            varB4EAC82CA7396A68D541C85D26508E83_187578739.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_187578739;
            // ---------- Original Method ----------
            //if (next == null)
                //throw new NoSuchElementException();
            //lastRet = next;
            //E x = nextItem;
            //advance();
            //return x;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.466 -0400", hash_original_method = "91F393F6D6922E17D234B4F4A87152D4", hash_generated_method = "ECFDFFC286F829171BCBD56209DD053C")
        public void remove() {
            Node<E> n = lastRet;
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            lastRet = null;
            final ReentrantLock lock = LinkedBlockingDeque.this.lock;
            lock.lock();
            try 
            {
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.466 -0400", hash_original_method = "2FF8F1B9AF2988B00A6C7863D292475A", hash_generated_method = "2FF8F1B9AF2988B00A6C7863D292475A")
        public Itr ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.467 -0400", hash_original_method = "F5496DA38BC198471A9339E337F6A141", hash_generated_method = "A7866B3C9473E916F154F4421B9AF86D")
         Node<E> firstNode() {
            Node<E> varB4EAC82CA7396A68D541C85D26508E83_1705593583 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1705593583 = first;
            varB4EAC82CA7396A68D541C85D26508E83_1705593583.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1705593583;
            // ---------- Original Method ----------
            //return first;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.468 -0400", hash_original_method = "7337A72D0DFE873C08C820C315C83AB4", hash_generated_method = "0441A3C21E9D405C000825727A8A060B")
         Node<E> nextNode(Node<E> n) {
            Node<E> varB4EAC82CA7396A68D541C85D26508E83_430609395 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_430609395 = n.next;
            addTaint(n.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_430609395.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_430609395;
            // ---------- Original Method ----------
            //return n.next;
        }

        
    }


    
    private class DescendingItr extends AbstractItr {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.468 -0400", hash_original_method = "0432E36D4F5ED7D39A08DA6620AAF627", hash_generated_method = "0432E36D4F5ED7D39A08DA6620AAF627")
        public DescendingItr ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.469 -0400", hash_original_method = "935F8554484A3F626F85F03E205FB5CA", hash_generated_method = "86FF18C266FAB35CED53019F776DC9E8")
         Node<E> firstNode() {
            Node<E> varB4EAC82CA7396A68D541C85D26508E83_1856328600 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1856328600 = last;
            varB4EAC82CA7396A68D541C85D26508E83_1856328600.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1856328600;
            // ---------- Original Method ----------
            //return last;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.472 -0400", hash_original_method = "A98E9809BC87B643D4F952FCC7CB50C4", hash_generated_method = "8B8E22CA5AAFD39A1B772647CDCF92DB")
         Node<E> nextNode(Node<E> n) {
            Node<E> varB4EAC82CA7396A68D541C85D26508E83_1074411947 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1074411947 = n.prev;
            addTaint(n.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1074411947.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1074411947;
            // ---------- Original Method ----------
            //return n.prev;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.472 -0400", hash_original_field = "EC69805AB5EB939803A84DAF9D237360", hash_generated_field = "2FC1AEBFA22450C18CBB99BA3CB2FBF7")

    private static final long serialVersionUID = -387911632671998426L;
}

