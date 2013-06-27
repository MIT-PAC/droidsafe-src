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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.306 -0400", hash_original_field = "8B04D5E3775D298E78455EFC5CA404D5", hash_generated_field = "B953F2DA9AB6C212A9E3462BBC6D0DD3")

    transient Node<E> first;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.306 -0400", hash_original_field = "98BD1C45684CF587AC2347A92DD7BB51", hash_generated_field = "68FEEFB065E74B1419C2CD65ECD35DDE")

    transient Node<E> last;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.306 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "FF3E1C3A7415684C56884C6A4B36275E")

    private transient int count;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.306 -0400", hash_original_field = "7BD14A231864E618E1840C7E117E59C1", hash_generated_field = "277B4266A058D752E724058E1F215618")

    private int capacity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.306 -0400", hash_original_field = "CD2F0EC2CC3E15FC9F14D13EF4CCDCBB", hash_generated_field = "1400DAF04929C6FE417E223B70E97891")

    ReentrantLock lock = new ReentrantLock();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.306 -0400", hash_original_field = "BBA850CA76BD62A0E877882CD64D6154", hash_generated_field = "F00D1EE20EBA81346319F2EF7C48D338")

    private Condition notEmpty = lock.newCondition();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.306 -0400", hash_original_field = "5E8F964E21EE9116314CFB10D69DF8BF", hash_generated_field = "8A5AA2A66148D4F8BB6299659D85E073")

    private Condition notFull = lock.newCondition();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.318 -0400", hash_original_method = "249100E9D6D687E7D39D2C34E44C91A8", hash_generated_method = "E3BE42F00612F355BFAC74D87EF1DA2E")
    public  LinkedBlockingDeque() {
        this(Integer.MAX_VALUE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.318 -0400", hash_original_method = "FF241F26E4F2B23472530DEBE913F0CA", hash_generated_method = "8682B1E0CAEA70D93A28E8E2B0B15495")
    public  LinkedBlockingDeque(int capacity) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        this.capacity = capacity;
        // ---------- Original Method ----------
        //if (capacity <= 0) throw new IllegalArgumentException();
        //this.capacity = capacity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.339 -0400", hash_original_method = "439D82303085A1CC8269C4DDD811FDB3", hash_generated_method = "49A28AB188820F0EB874A9D076ADE594")
    public  LinkedBlockingDeque(Collection<? extends E> c) {
        this(Integer.MAX_VALUE);
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        try 
        {
            {
                Iterator<E> var334ED49EB23041C8D120547C1BB713D2_1297354049 = (c).iterator();
                var334ED49EB23041C8D120547C1BB713D2_1297354049.hasNext();
                E e = var334ED49EB23041C8D120547C1BB713D2_1297354049.next();
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
                    {
                        boolean var1E9AEB73CCD197914A3E493D7A79F7AE_1060581002 = (!linkLast(new Node<E>(e)));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.339 -0400", hash_original_method = "F1FEA35FDC461C140B4532DA56C7987F", hash_generated_method = "0C0FB04D967DDE9739E99BA80C6837C7")
    private boolean linkFirst(Node<E> node) {
        Node<E> f;
        f = first;
        node.next = f;
        first = node;
        last = node;
        f.prev = node;
        notEmpty.signal();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1276544069 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1276544069;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.343 -0400", hash_original_method = "A7FA4F0AF7ECA6F754653DE93F8ED423", hash_generated_method = "3AAC154A1186CD631D86DBCE32187DDE")
    private boolean linkLast(Node<E> node) {
        Node<E> l;
        l = last;
        node.prev = l;
        last = node;
        first = node;
        l.next = node;
        notEmpty.signal();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_591655699 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_591655699;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.353 -0400", hash_original_method = "B7345027764D354450098F40DD004B57", hash_generated_method = "F4104BEF28823E05B6ABE5F798830866")
    private E unlinkFirst() {
        E varB4EAC82CA7396A68D541C85D26508E83_454206502 = null; //Variable for return #1
        E varB4EAC82CA7396A68D541C85D26508E83_906908395 = null; //Variable for return #2
        Node<E> f;
        f = first;
        varB4EAC82CA7396A68D541C85D26508E83_454206502 = null;
        Node<E> n;
        n = f.next;
        E item;
        item = f.item;
        f.item = null;
        f.next = f;
        first = n;
        last = null;
        n.prev = null;
        notFull.signal();
        varB4EAC82CA7396A68D541C85D26508E83_906908395 = item;
        E varA7E53CE21691AB073D9660D615818899_1639723743; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1639723743 = varB4EAC82CA7396A68D541C85D26508E83_454206502;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1639723743 = varB4EAC82CA7396A68D541C85D26508E83_906908395;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1639723743.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1639723743;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.361 -0400", hash_original_method = "AF190978DF5C122F110919244C9479F2", hash_generated_method = "1623F7601F5CF905EE6D36C6CA23F9EB")
    private E unlinkLast() {
        E varB4EAC82CA7396A68D541C85D26508E83_252647670 = null; //Variable for return #1
        E varB4EAC82CA7396A68D541C85D26508E83_41801855 = null; //Variable for return #2
        Node<E> l;
        l = last;
        varB4EAC82CA7396A68D541C85D26508E83_252647670 = null;
        Node<E> p;
        p = l.prev;
        E item;
        item = l.item;
        l.item = null;
        l.prev = l;
        last = p;
        first = null;
        p.next = null;
        notFull.signal();
        varB4EAC82CA7396A68D541C85D26508E83_41801855 = item;
        E varA7E53CE21691AB073D9660D615818899_1586587975; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1586587975 = varB4EAC82CA7396A68D541C85D26508E83_252647670;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1586587975 = varB4EAC82CA7396A68D541C85D26508E83_41801855;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1586587975.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1586587975;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.362 -0400", hash_original_method = "1D9FD16EE202C66D2F53FBE6A3602BA7", hash_generated_method = "2E7ECD65BF5970208863758016CCB1E8")
     void unlink(Node<E> x) {
        Node<E> p;
        p = x.prev;
        Node<E> n;
        n = x.next;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.362 -0400", hash_original_method = "E867E212B6967896682403DEE3888034", hash_generated_method = "4C83ADBC75B8C4C75C6A8345506230F6")
    public void addFirst(E e) {
        {
            boolean var5C0D7E3C6AA777739E756E8EAE0C9228_2043114839 = (!offerFirst(e));
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Deque full");
        } //End collapsed parenthetic
        addTaint(e.getTaint());
        // ---------- Original Method ----------
        //if (!offerFirst(e))
            //throw new IllegalStateException("Deque full");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.362 -0400", hash_original_method = "B487A5071408DAF9039EED205B0601B1", hash_generated_method = "E06AAEBB2A9CE47212015360FC2DE7B0")
    public void addLast(E e) {
        {
            boolean var90637F446D34B905E9B56D462DE169DC_556593176 = (!offerLast(e));
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Deque full");
        } //End collapsed parenthetic
        addTaint(e.getTaint());
        // ---------- Original Method ----------
        //if (!offerLast(e))
            //throw new IllegalStateException("Deque full");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.362 -0400", hash_original_method = "BE955938F466098B732744A4435FF66E", hash_generated_method = "7A774AFE54AEB667727C0DC8BFBCC130")
    public boolean offerFirst(E e) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        Node<E> node;
        node = new Node<E>(e);
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        try 
        {
            boolean varE1FB9FCECEF8074AC981D528C7C0CB67_1976507110 = (linkFirst(node));
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1028075989 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1028075989;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.363 -0400", hash_original_method = "1944181CAD6733F95AAB9BA74E74F57C", hash_generated_method = "B58FAB8F56A5EE0E6A1E08B76DF9E9D6")
    public boolean offerLast(E e) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        Node<E> node;
        node = new Node<E>(e);
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        try 
        {
            boolean varE012F7B0E47B9110FF28D1A1658A888C_168751019 = (linkLast(node));
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1819200984 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1819200984;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.363 -0400", hash_original_method = "C2A955C9F8C1BE3FAF21A972EF83A87B", hash_generated_method = "C336F3F637A46C25D3847E80F06FFC3A")
    public void putFirst(E e) throws InterruptedException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        Node<E> node;
        node = new Node<E>(e);
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        try 
        {
            {
                boolean var2FEC5472714EFC76E0A1E992CA7557AA_95253071 = (!linkFirst(node));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.379 -0400", hash_original_method = "90F899FEDAEBCF4E183EEEA72670B0D4", hash_generated_method = "F1DB4E97494328BD41CD2E2C102D0946")
    public void putLast(E e) throws InterruptedException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        Node<E> node;
        node = new Node<E>(e);
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        try 
        {
            {
                boolean var93E27FF336A9E0ECE5D11949553BA0B7_861550010 = (!linkLast(node));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.380 -0400", hash_original_method = "14A0E8066E53E8F404179324D8A2A7E0", hash_generated_method = "A8D6A6A6CF22039C35FDB3F9BF501B27")
    public boolean offerFirst(E e, long timeout, TimeUnit unit) throws InterruptedException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        Node<E> node;
        node = new Node<E>(e);
        long nanos;
        nanos = unit.toNanos(timeout);
        ReentrantLock lock;
        lock = this.lock;
        lock.lockInterruptibly();
        try 
        {
            {
                boolean var2FEC5472714EFC76E0A1E992CA7557AA_1996821082 = (!linkFirst(node));
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_921572832 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_921572832;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.381 -0400", hash_original_method = "D6F2690B9DE8E1D2C78F1E640A084B19", hash_generated_method = "DECA1395CF5D7C72A30AC198772BFAD2")
    public boolean offerLast(E e, long timeout, TimeUnit unit) throws InterruptedException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        Node<E> node;
        node = new Node<E>(e);
        long nanos;
        nanos = unit.toNanos(timeout);
        ReentrantLock lock;
        lock = this.lock;
        lock.lockInterruptibly();
        try 
        {
            {
                boolean var93E27FF336A9E0ECE5D11949553BA0B7_939779474 = (!linkLast(node));
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_653759374 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_653759374;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.391 -0400", hash_original_method = "8D1F2D8C9F4BF8EC3B65B975014CE8A7", hash_generated_method = "4F414E3649B1D2164F5BE93EF8DF11C4")
    public E removeFirst() {
        E varB4EAC82CA7396A68D541C85D26508E83_644883637 = null; //Variable for return #1
        E x;
        x = pollFirst();
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_644883637 = x;
        varB4EAC82CA7396A68D541C85D26508E83_644883637.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_644883637;
        // ---------- Original Method ----------
        //E x = pollFirst();
        //if (x == null) throw new NoSuchElementException();
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.391 -0400", hash_original_method = "90A521D0942C6C4821F3F861C2808726", hash_generated_method = "D050EB648437DCDBCD6459DE8C330396")
    public E removeLast() {
        E varB4EAC82CA7396A68D541C85D26508E83_1214203734 = null; //Variable for return #1
        E x;
        x = pollLast();
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_1214203734 = x;
        varB4EAC82CA7396A68D541C85D26508E83_1214203734.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1214203734;
        // ---------- Original Method ----------
        //E x = pollLast();
        //if (x == null) throw new NoSuchElementException();
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.393 -0400", hash_original_method = "4BCCC1BED6E23489D206E4138D3675FF", hash_generated_method = "DC71C20EF130C1FE61F46EAA737D122B")
    public E pollFirst() {
        E varB4EAC82CA7396A68D541C85D26508E83_2005586485 = null; //Variable for return #1
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2005586485 = unlinkFirst();
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2005586485.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2005586485;
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //return unlinkFirst();
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.403 -0400", hash_original_method = "D2B0F76144A8C0FD857C7F3A67B82206", hash_generated_method = "E220E5645780162FE00B22D7D9AC181A")
    public E pollLast() {
        E varB4EAC82CA7396A68D541C85D26508E83_1974083321 = null; //Variable for return #1
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1974083321 = unlinkLast();
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1974083321.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1974083321;
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //return unlinkLast();
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.404 -0400", hash_original_method = "AF3CDBD12E7133B877B3C968B0B44866", hash_generated_method = "43307401AA67F9A3E463A4063C8F3351")
    public E takeFirst() throws InterruptedException {
        E varB4EAC82CA7396A68D541C85D26508E83_244241947 = null; //Variable for return #1
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        try 
        {
            E x;
            {
                boolean var694B543BE841898C631F1A346443AC8C_631676021 = ((x = unlinkFirst()) == null);
                notEmpty.await();
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_244241947 = x;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_244241947.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_244241947;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.405 -0400", hash_original_method = "FB7D91E8092FFF58EBD05C4560E68DC5", hash_generated_method = "4FA803515807D3B82C20A47FF517C79F")
    public E takeLast() throws InterruptedException {
        E varB4EAC82CA7396A68D541C85D26508E83_1007148897 = null; //Variable for return #1
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        try 
        {
            E x;
            {
                boolean var50D9F533AA08B5FCD2E05DC6B26DB2BD_810268655 = ((x = unlinkLast()) == null);
                notEmpty.await();
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1007148897 = x;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1007148897.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1007148897;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.409 -0400", hash_original_method = "F9AABEF2F1BCB257250D3454F49A6E99", hash_generated_method = "E1BF4B95146D088825BB091D8DA5DD6E")
    public E pollFirst(long timeout, TimeUnit unit) throws InterruptedException {
        E varB4EAC82CA7396A68D541C85D26508E83_1466213110 = null; //Variable for return #1
        E varB4EAC82CA7396A68D541C85D26508E83_1514989052 = null; //Variable for return #2
        long nanos;
        nanos = unit.toNanos(timeout);
        ReentrantLock lock;
        lock = this.lock;
        lock.lockInterruptibly();
        try 
        {
            E x;
            {
                boolean var694B543BE841898C631F1A346443AC8C_366824371 = ((x = unlinkFirst()) == null);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1466213110 = null;
                    nanos = notEmpty.awaitNanos(nanos);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1514989052 = x;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        addTaint(timeout);
        addTaint(unit.getTaint());
        E varA7E53CE21691AB073D9660D615818899_1380737930; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1380737930 = varB4EAC82CA7396A68D541C85D26508E83_1466213110;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1380737930 = varB4EAC82CA7396A68D541C85D26508E83_1514989052;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1380737930.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1380737930;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.425 -0400", hash_original_method = "441DC167F175C62B6ECB09DED87CDC8D", hash_generated_method = "137AFBDE7C0A6AC3A62358A045160F10")
    public E pollLast(long timeout, TimeUnit unit) throws InterruptedException {
        E varB4EAC82CA7396A68D541C85D26508E83_1874446288 = null; //Variable for return #1
        E varB4EAC82CA7396A68D541C85D26508E83_128452893 = null; //Variable for return #2
        long nanos;
        nanos = unit.toNanos(timeout);
        ReentrantLock lock;
        lock = this.lock;
        lock.lockInterruptibly();
        try 
        {
            E x;
            {
                boolean var50D9F533AA08B5FCD2E05DC6B26DB2BD_1068873850 = ((x = unlinkLast()) == null);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1874446288 = null;
                    nanos = notEmpty.awaitNanos(nanos);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_128452893 = x;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        addTaint(timeout);
        addTaint(unit.getTaint());
        E varA7E53CE21691AB073D9660D615818899_37076527; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_37076527 = varB4EAC82CA7396A68D541C85D26508E83_1874446288;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_37076527 = varB4EAC82CA7396A68D541C85D26508E83_128452893;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_37076527.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_37076527;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.425 -0400", hash_original_method = "F4DA2AE3D58549E0544F32F7ECC367F9", hash_generated_method = "BCBAAD70843B3AB85097E577168515D6")
    public E getFirst() {
        E varB4EAC82CA7396A68D541C85D26508E83_46029328 = null; //Variable for return #1
        E x;
        x = peekFirst();
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_46029328 = x;
        varB4EAC82CA7396A68D541C85D26508E83_46029328.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_46029328;
        // ---------- Original Method ----------
        //E x = peekFirst();
        //if (x == null) throw new NoSuchElementException();
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.426 -0400", hash_original_method = "CA6BD988176C06418CE77F8F50D6B256", hash_generated_method = "F52810838865119D5289BDBDA7014F60")
    public E getLast() {
        E varB4EAC82CA7396A68D541C85D26508E83_1328310083 = null; //Variable for return #1
        E x;
        x = peekLast();
        if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
        varB4EAC82CA7396A68D541C85D26508E83_1328310083 = x;
        varB4EAC82CA7396A68D541C85D26508E83_1328310083.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1328310083;
        // ---------- Original Method ----------
        //E x = peekLast();
        //if (x == null) throw new NoSuchElementException();
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.426 -0400", hash_original_method = "61802C5E2F0A50DC70950560F84AD209", hash_generated_method = "DCA1DBB03B05CF640D7514AC5AFD8D54")
    public E peekFirst() {
        E varB4EAC82CA7396A68D541C85D26508E83_91762759 = null; //Variable for return #1
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_91762759 = (first == null) ? null : first.item;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_91762759.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_91762759;
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //return (first == null) ? null : first.item;
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.427 -0400", hash_original_method = "0A003440458459B8BB085FC2BE3ABB07", hash_generated_method = "CB124A04070C190897B643F70A046928")
    public E peekLast() {
        E varB4EAC82CA7396A68D541C85D26508E83_33002429 = null; //Variable for return #1
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_33002429 = (last == null) ? null : last.item;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_33002429.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_33002429;
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //return (last == null) ? null : last.item;
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.436 -0400", hash_original_method = "73CE4C57004AC162E8700E668E08F7DA", hash_generated_method = "F196FFE166FEF0F571D959673AEFAF11")
    public boolean removeFirstOccurrence(Object o) {
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        try 
        {
            {
                Node<E> p;
                p = first;
                p = p.next;
                {
                    {
                        boolean varD072E6E000FCF729BD7B2505F48F68BD_2234212 = (o.equals(p.item));
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_731508507 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_731508507;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.437 -0400", hash_original_method = "D957C1235A0ED720512232AF3579C614", hash_generated_method = "FF90B837D00CB831FAC51161F7F45052")
    public boolean removeLastOccurrence(Object o) {
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        try 
        {
            {
                Node<E> p;
                p = last;
                p = p.prev;
                {
                    {
                        boolean varD072E6E000FCF729BD7B2505F48F68BD_691341861 = (o.equals(p.item));
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_880019177 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_880019177;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.437 -0400", hash_original_method = "056B268263D9E7E4C2239F12D1024514", hash_generated_method = "38D6CBA9567DFFE16D637F0C7DCFFA8D")
    public boolean add(E e) {
        addLast(e);
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_732039677 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_732039677;
        // ---------- Original Method ----------
        //addLast(e);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.437 -0400", hash_original_method = "90158A89D183AFC9420F99CD4C19A119", hash_generated_method = "F6133B0EE1F27FC2FF8CDAC72A00EA99")
    public boolean offer(E e) {
        boolean var1C8D098E0D25C154182D97F2DFA9E90F_1197952355 = (offerLast(e));
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_915447548 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_915447548;
        // ---------- Original Method ----------
        //return offerLast(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.455 -0400", hash_original_method = "091B896CDB22071FD0356886E4E18520", hash_generated_method = "809893F6DDC4DDAACE74D73ABDEF1ED8")
    public void put(E e) throws InterruptedException {
        putLast(e);
        addTaint(e.getTaint());
        // ---------- Original Method ----------
        //putLast(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.455 -0400", hash_original_method = "04D6F44E140F1E68CFC8217F9A649648", hash_generated_method = "4BBB65D785EFB9FA2D34A11ADA080E4E")
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        boolean var4F1D7242ECA30177669F884F86DBFB49_1259779446 = (offerLast(e, timeout, unit));
        addTaint(e.getTaint());
        addTaint(timeout);
        addTaint(unit.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1129844403 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1129844403;
        // ---------- Original Method ----------
        //return offerLast(e, timeout, unit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.456 -0400", hash_original_method = "5200E72EC4A7AF0A97DAC56CA915551B", hash_generated_method = "2ACD5AF5FB413F43C8F2699EA70A9AB7")
    public E remove() {
        E varB4EAC82CA7396A68D541C85D26508E83_1688784081 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1688784081 = removeFirst();
        varB4EAC82CA7396A68D541C85D26508E83_1688784081.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1688784081;
        // ---------- Original Method ----------
        //return removeFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.456 -0400", hash_original_method = "D6F4991F5239518842015971CA437CF0", hash_generated_method = "4E4628464807AC3A5E9CDECF28A60A55")
    public E poll() {
        E varB4EAC82CA7396A68D541C85D26508E83_723860298 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_723860298 = pollFirst();
        varB4EAC82CA7396A68D541C85D26508E83_723860298.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_723860298;
        // ---------- Original Method ----------
        //return pollFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.457 -0400", hash_original_method = "71C603C063999AE26BDD685834231EF7", hash_generated_method = "E0D14F3DB8C2A7774D98949A7C27009E")
    public E take() throws InterruptedException {
        E varB4EAC82CA7396A68D541C85D26508E83_1065205806 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1065205806 = takeFirst();
        varB4EAC82CA7396A68D541C85D26508E83_1065205806.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1065205806;
        // ---------- Original Method ----------
        //return takeFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.463 -0400", hash_original_method = "1736A91E2A3C93B5CBB10674E58366F8", hash_generated_method = "3F5477912A26324E3E28BC6CC18F099F")
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        E varB4EAC82CA7396A68D541C85D26508E83_1182020003 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1182020003 = pollFirst(timeout, unit);
        addTaint(timeout);
        addTaint(unit.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1182020003.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1182020003;
        // ---------- Original Method ----------
        //return pollFirst(timeout, unit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.464 -0400", hash_original_method = "C3B5A6F3A12E32CB352921DD8911C7F3", hash_generated_method = "B5D76899B859937B53935A59DBF8B466")
    public E element() {
        E varB4EAC82CA7396A68D541C85D26508E83_154616379 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_154616379 = getFirst();
        varB4EAC82CA7396A68D541C85D26508E83_154616379.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_154616379;
        // ---------- Original Method ----------
        //return getFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.464 -0400", hash_original_method = "A003E27ECA2FE3193555598EEC98E09D", hash_generated_method = "9ED9095CDCB5C84E5428DDE10E8B6B2C")
    public E peek() {
        E varB4EAC82CA7396A68D541C85D26508E83_2061718636 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2061718636 = peekFirst();
        varB4EAC82CA7396A68D541C85D26508E83_2061718636.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2061718636;
        // ---------- Original Method ----------
        //return peekFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.465 -0400", hash_original_method = "04FC8DBE8B6CF08AC1A142B1DC50B6B4", hash_generated_method = "432B8B17AFEE380199EE482110277EE9")
    public int remainingCapacity() {
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1878714091 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1878714091;
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //return capacity - count;
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.465 -0400", hash_original_method = "848AB2101C925A7DB8B05331DC1D79E6", hash_generated_method = "F90FE07D3A8E86BA7AFE3D53F326C25A")
    public int drainTo(Collection<? super E> c) {
        int var0B753C0ADE2F28D7A7716F28C1FC5A12_2122938466 = (drainTo(c, Integer.MAX_VALUE));
        addTaint(c.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_752893715 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_752893715;
        // ---------- Original Method ----------
        //return drainTo(c, Integer.MAX_VALUE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.481 -0400", hash_original_method = "8D6DC3C307065A1D2B18F15D4F19D5EE", hash_generated_method = "02DE6520B0B69D782458B2F98FBBBAF8")
    public int drainTo(Collection<? super E> c, int maxElements) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        {
            boolean var9AEE7ACC5B0D4AF26CA46D5AFC07CCF3_1602882922 = (c == this);
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End collapsed parenthetic
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        try 
        {
            int n;
            n = Math.min(maxElements, count);
            {
                int i;
                i = 0;
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1225179961 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1225179961;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.482 -0400", hash_original_method = "848DD27BB905F5A807C52ED75E19F6C3", hash_generated_method = "72C186ED1744A0D2DEFAA4DDE67D7864")
    public void push(E e) {
        addFirst(e);
        addTaint(e.getTaint());
        // ---------- Original Method ----------
        //addFirst(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.482 -0400", hash_original_method = "158DA4E81D3B40D802055686181E6101", hash_generated_method = "DF3C295EEEC7FD83E6D057DDCAE709CD")
    public E pop() {
        E varB4EAC82CA7396A68D541C85D26508E83_191819120 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_191819120 = removeFirst();
        varB4EAC82CA7396A68D541C85D26508E83_191819120.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_191819120;
        // ---------- Original Method ----------
        //return removeFirst();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.482 -0400", hash_original_method = "953726349F424E37042C19BD0C0A52B8", hash_generated_method = "85022D345EA2ADF7443C6FE9254E25C2")
    public boolean remove(Object o) {
        boolean varB3B6A07AEF87793955942F9770654762_965097365 = (removeFirstOccurrence(o));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_19583226 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_19583226;
        // ---------- Original Method ----------
        //return removeFirstOccurrence(o);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.483 -0400", hash_original_method = "455EA274614F97D61B2EABEB4507FE65", hash_generated_method = "4F9C54A1697AA02619FB863E0C99DD59")
    public int size() {
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1730508486 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1730508486;
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //return count;
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.483 -0400", hash_original_method = "682A3652CE664466B96C29E268D51A9E", hash_generated_method = "DE98696575C6018357F0A583747366C4")
    public boolean contains(Object o) {
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        try 
        {
            {
                Node<E> p;
                p = first;
                p = p.next;
                {
                    boolean varF9DBDF4C5289176897871C74CFE4EAD8_902459947 = (o.equals(p.item));
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_286270718 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_286270718;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.490 -0400", hash_original_method = "6060745C6F54AC5BF252877A9090AD60", hash_generated_method = "DFB1C60DDBC4BF97240123EC55EF9B24")
    @SuppressWarnings("unchecked")
    public Object[] toArray() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_1757959586 = null; //Variable for return #1
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        try 
        {
            Object[] a;
            a = new Object[count];
            int k;
            k = 0;
            {
                Node<E> p;
                p = first;
                p = p.next;
                a[k++] = p.item;
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1757959586 = a;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1757959586.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1757959586;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.496 -0400", hash_original_method = "ED2A1A13D07CD52AFD81A3297D99D370", hash_generated_method = "2816BE29BE10D0C13EC2688B61A8912A")
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_1315599050 = null; //Variable for return #1
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        try 
        {
            a = (T[])java.lang.reflect.Array.newInstance
                    (a.getClass().getComponentType(), count);
            int k;
            k = 0;
            {
                Node<E> p;
                p = first;
                p = p.next;
                a[k++] = (T)p.item;
            } //End collapsed parenthetic
            a[k] = null;
            varB4EAC82CA7396A68D541C85D26508E83_1315599050 = a;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        addTaint(a[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1315599050.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1315599050;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.514 -0400", hash_original_method = "C6BF4E291CC9ACD611C7F11D96A47702", hash_generated_method = "66A444176B64961409302D08E8DBB78E")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1582772809 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2074640358 = null; //Variable for return #2
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        try 
        {
            Node<E> p;
            p = first;
            varB4EAC82CA7396A68D541C85D26508E83_1582772809 = "[]";
            StringBuilder sb;
            sb = new StringBuilder();
            sb.append('[');
            {
                E e;
                e = p.item;
                sb.append(e == this ? "(this Collection)" : e);
                p = p.next;
                varB4EAC82CA7396A68D541C85D26508E83_2074640358 = sb.append(']').toString();
                sb.append(',').append(' ');
            } //End block
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1480400425; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1480400425 = varB4EAC82CA7396A68D541C85D26508E83_1582772809;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1480400425 = varB4EAC82CA7396A68D541C85D26508E83_2074640358;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1480400425.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1480400425;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.522 -0400", hash_original_method = "1459F438368C53F5F75C3D780C8B3096", hash_generated_method = "7C67EF840EAA819328FEC4844BFFB73E")
    public void clear() {
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        try 
        {
            {
                Node<E> f;
                f = first;
                {
                    f.item = null;
                    Node<E> n;
                    n = f.next;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.523 -0400", hash_original_method = "756A0449DBEE27B15290EF9912B6D98E", hash_generated_method = "46804C35674A0E2FB0BF56DCB1525CC5")
    public Iterator<E> iterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_928623032 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_928623032 = new Itr();
        varB4EAC82CA7396A68D541C85D26508E83_928623032.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_928623032;
        // ---------- Original Method ----------
        //return new Itr();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.524 -0400", hash_original_method = "E2FFEA86BDF1CF0D788CD9C05CB28749", hash_generated_method = "9F7668838FE14CD11ADB1D314EBB0DA6")
    public Iterator<E> descendingIterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_1874154327 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1874154327 = new DescendingItr();
        varB4EAC82CA7396A68D541C85D26508E83_1874154327.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1874154327;
        // ---------- Original Method ----------
        //return new DescendingItr();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.531 -0400", hash_original_method = "00D32B8E76B917A114B33777EC6C582C", hash_generated_method = "5FA08212D2A446F8000C80D257868B96")
    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        try 
        {
            s.defaultWriteObject();
            {
                Node<E> p;
                p = first;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.532 -0400", hash_original_method = "56ED7CDA4A1F5E7C2D4B953EF10E899A", hash_generated_method = "B8A5588277457F51B0D86D4EF9F47FF1")
    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
        s.defaultReadObject();
        count = 0;
        first = null;
        last = null;
        {
            @SuppressWarnings("unchecked") E item;
            item = (E)s.readObject();
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.532 -0400", hash_original_field = "447B7147E84BE512208DCC0995D67EBC", hash_generated_field = "25C1B4BE35B7528A52E74D8E56CE9F0B")

        E item;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.532 -0400", hash_original_field = "FCB08B164AC83E09964DEB24F2D2E80B", hash_generated_field = "7FBB8703B6D1E4FD63D7312AF905F1D0")

        Node<E> prev;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.532 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "A089DAAEF049057EDB97CA1342EE38E4")

        Node<E> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.532 -0400", hash_original_method = "E24CFB813CF8D6D3545154C1747D57F8", hash_generated_method = "F143FACCEFEC2EC78FAE43B87B01534B")
          Node(E x) {
            item = x;
            // ---------- Original Method ----------
            //item = x;
        }

        
    }


    
    private abstract class AbstractItr implements Iterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.533 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "A089DAAEF049057EDB97CA1342EE38E4")

        Node<E> next;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.533 -0400", hash_original_field = "F0B5FE0A0CBE5E14CD07AF33AB522BBE", hash_generated_field = "FC047D97EB4DD102072D6594B14B8B33")

        E nextItem;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.533 -0400", hash_original_field = "BB3AE5C41B0FFE5CC0DAF60D4592524F", hash_generated_field = "9782A09877DFB4D434246B92A2C403C0")

        private Node<E> lastRet;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.533 -0400", hash_original_method = "D7A0B463A5093578F0D94B98618BF3C0", hash_generated_method = "E1593B87C77772D846CD6E3C7A0CC5FC")
          AbstractItr() {
            ReentrantLock lock;
            lock = LinkedBlockingDeque.this.lock;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.550 -0400", hash_original_method = "D73368529643E6DA5D3CCB05A337F2C2", hash_generated_method = "C230762FEF4D766D7984EA8018D2D270")
        private Node<E> succ(Node<E> n) {
            Node<E> varB4EAC82CA7396A68D541C85D26508E83_1093044431 = null; //Variable for return #1
            Node<E> varB4EAC82CA7396A68D541C85D26508E83_1646915887 = null; //Variable for return #2
            Node<E> varB4EAC82CA7396A68D541C85D26508E83_180013275 = null; //Variable for return #3
            {
                Node<E> s;
                s = nextNode(n);
                varB4EAC82CA7396A68D541C85D26508E83_1093044431 = null;
                varB4EAC82CA7396A68D541C85D26508E83_1646915887 = s;
                varB4EAC82CA7396A68D541C85D26508E83_180013275 = firstNode();
                n = s;
            } //End block
            addTaint(n.getTaint());
            Node<E> varA7E53CE21691AB073D9660D615818899_804209727; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_804209727 = varB4EAC82CA7396A68D541C85D26508E83_1093044431;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_804209727 = varB4EAC82CA7396A68D541C85D26508E83_1646915887;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_804209727 = varB4EAC82CA7396A68D541C85D26508E83_180013275;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_804209727.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_804209727;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.550 -0400", hash_original_method = "2DD616E77FD4CF0B4B36F4DDA6D06963", hash_generated_method = "B7502AECF29652E7DAE6391CDAE30F1B")
         void advance() {
            ReentrantLock lock;
            lock = LinkedBlockingDeque.this.lock;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.551 -0400", hash_original_method = "5C1B7B0DA20667590A4D5C5559468A28", hash_generated_method = "EA42A2ABBA93DBD1E18CA83C8E7D50C9")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1615461330 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1615461330;
            // ---------- Original Method ----------
            //return next != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.562 -0400", hash_original_method = "A893921D404CCDA66FADBF0BB5913A0B", hash_generated_method = "E7BB7A1A307D1BA2DB5AACF491A54D73")
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_1340865024 = null; //Variable for return #1
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            lastRet = next;
            E x;
            x = nextItem;
            advance();
            varB4EAC82CA7396A68D541C85D26508E83_1340865024 = x;
            varB4EAC82CA7396A68D541C85D26508E83_1340865024.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1340865024;
            // ---------- Original Method ----------
            //if (next == null)
                //throw new NoSuchElementException();
            //lastRet = next;
            //E x = nextItem;
            //advance();
            //return x;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.563 -0400", hash_original_method = "91F393F6D6922E17D234B4F4A87152D4", hash_generated_method = "A7282200813C0760EE2D25DA21C3BFBF")
        public void remove() {
            Node<E> n;
            n = lastRet;
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            lastRet = null;
            ReentrantLock lock;
            lock = LinkedBlockingDeque.this.lock;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.563 -0400", hash_original_method = "2FF8F1B9AF2988B00A6C7863D292475A", hash_generated_method = "2FF8F1B9AF2988B00A6C7863D292475A")
        public Itr ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.563 -0400", hash_original_method = "F5496DA38BC198471A9339E337F6A141", hash_generated_method = "5F6F7EFE52A698A0D0ACBFFE36C30F76")
         Node<E> firstNode() {
            Node<E> varB4EAC82CA7396A68D541C85D26508E83_55844404 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_55844404 = first;
            varB4EAC82CA7396A68D541C85D26508E83_55844404.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_55844404;
            // ---------- Original Method ----------
            //return first;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.564 -0400", hash_original_method = "7337A72D0DFE873C08C820C315C83AB4", hash_generated_method = "04F680D9B5670CF51AD87F4051D2C595")
         Node<E> nextNode(Node<E> n) {
            Node<E> varB4EAC82CA7396A68D541C85D26508E83_1934616592 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1934616592 = n.next;
            addTaint(n.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1934616592.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1934616592;
            // ---------- Original Method ----------
            //return n.next;
        }

        
    }


    
    private class DescendingItr extends AbstractItr {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.572 -0400", hash_original_method = "0432E36D4F5ED7D39A08DA6620AAF627", hash_generated_method = "0432E36D4F5ED7D39A08DA6620AAF627")
        public DescendingItr ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.583 -0400", hash_original_method = "935F8554484A3F626F85F03E205FB5CA", hash_generated_method = "88276AAD2B5225E5D86238D8CEB262D9")
         Node<E> firstNode() {
            Node<E> varB4EAC82CA7396A68D541C85D26508E83_176044596 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_176044596 = last;
            varB4EAC82CA7396A68D541C85D26508E83_176044596.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_176044596;
            // ---------- Original Method ----------
            //return last;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.584 -0400", hash_original_method = "A98E9809BC87B643D4F952FCC7CB50C4", hash_generated_method = "DACEBB9C4245267115C69A2137F1BC31")
         Node<E> nextNode(Node<E> n) {
            Node<E> varB4EAC82CA7396A68D541C85D26508E83_893790113 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_893790113 = n.prev;
            addTaint(n.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_893790113.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_893790113;
            // ---------- Original Method ----------
            //return n.prev;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.584 -0400", hash_original_field = "EC69805AB5EB939803A84DAF9D237360", hash_generated_field = "BC44836C331019064A4EB2FC6EEED016")

    private static long serialVersionUID = -387911632671998426L;
}

