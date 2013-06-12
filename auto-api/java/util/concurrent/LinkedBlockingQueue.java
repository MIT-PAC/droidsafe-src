package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedBlockingQueue<E> extends AbstractQueue<E> implements BlockingQueue<E>, java.io.Serializable {
    private static long serialVersionUID = -6903933977591709194L;
    private int capacity;
    private AtomicInteger count = new AtomicInteger(0);
    private transient Node<E> head;
    private transient Node<E> last;
    private ReentrantLock takeLock = new ReentrantLock();
    private Condition notEmpty = takeLock.newCondition();
    private ReentrantLock putLock = new ReentrantLock();
    private Condition notFull = putLock.newCondition();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.997 -0400", hash_original_method = "632CB0CBBBC44DF00B6EA380FB3D1564", hash_generated_method = "FA09A07972C7134BB678A335C21F4AD7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkedBlockingQueue() {
        this(Integer.MAX_VALUE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.999 -0400", hash_original_method = "B75314FE98F585143D624DCD24C1F5B2", hash_generated_method = "C7568F621741C881E76E2647CECE3CDE")
    @DSModeled(DSC.SAFE)
    public LinkedBlockingQueue(int capacity) {
        dsTaint.addTaint(capacity);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        last = head = new Node<E>(null);
        // ---------- Original Method ----------
        //if (capacity <= 0) throw new IllegalArgumentException();
        //this.capacity = capacity;
        //last = head = new Node<E>(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:28.001 -0400", hash_original_method = "76A1733AA4693E67903F6C627D09C67F", hash_generated_method = "A33BD8CFBF205B4D361D8FEAFFE1A349")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkedBlockingQueue(Collection<? extends E> c) {
        this(Integer.MAX_VALUE);
        dsTaint.addTaint(c.dsTaint);
        ReentrantLock putLock;
        putLock = this.putLock;
        putLock.lock();
        try 
        {
            int n;
            n = 0;
            {
                c.iterator().hasNext();
                E e = c.iterator().next();
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Queue full");
                    enqueue(new Node<E>(e));
                    ++n;
                } //End block
            } //End collapsed parenthetic
            count.set(n);
        } //End block
        finally 
        {
            putLock.unlock();
        } //End block
        // ---------- Original Method ----------
        //final ReentrantLock putLock = this.putLock;
        //putLock.lock();
        //try {
            //int n = 0;
            //for (E e : c) {
                //if (e == null)
                    //throw new NullPointerException();
                //if (n == capacity)
                    //throw new IllegalStateException("Queue full");
                //enqueue(new Node<E>(e));
                //++n;
            //}
            //count.set(n);
        //} finally {
            //putLock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:28.009 -0400", hash_original_method = "15D22B562F85AEAC3F4AC4996FFD23A3", hash_generated_method = "C4B06AF891D2A00B45EE1EFC51E07206")
    @DSModeled(DSC.SAFE)
    private void signalNotEmpty() {
        ReentrantLock takeLock;
        takeLock = this.takeLock;
        takeLock.lock();
        try 
        {
            notEmpty.signal();
        } //End block
        finally 
        {
            takeLock.unlock();
        } //End block
        // ---------- Original Method ----------
        //final ReentrantLock takeLock = this.takeLock;
        //takeLock.lock();
        //try {
            //notEmpty.signal();
        //} finally {
            //takeLock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:28.011 -0400", hash_original_method = "23256B84FD63DB25D1FF9FA99CF29C9A", hash_generated_method = "D41BF11CD040B0C59F58D0A07A96EFF8")
    @DSModeled(DSC.SAFE)
    private void signalNotFull() {
        ReentrantLock putLock;
        putLock = this.putLock;
        putLock.lock();
        try 
        {
            notFull.signal();
        } //End block
        finally 
        {
            putLock.unlock();
        } //End block
        // ---------- Original Method ----------
        //final ReentrantLock putLock = this.putLock;
        //putLock.lock();
        //try {
            //notFull.signal();
        //} finally {
            //putLock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:28.012 -0400", hash_original_method = "050BE5B4C52573633224C87BCCA985D9", hash_generated_method = "51A49D740D0F9A87E565D8E8CDA8558A")
    @DSModeled(DSC.SAFE)
    private void enqueue(Node<E> node) {
        dsTaint.addTaint(node.dsTaint);
        last = last.next = node;
        // ---------- Original Method ----------
        //last = last.next = node;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:28.016 -0400", hash_original_method = "0F3CD055205E18F01917D382EBA2EDD8", hash_generated_method = "579AA2D18F8820624894350744F02ADD")
    @DSModeled(DSC.SAFE)
    private E dequeue() {
        Node<E> h;
        h = head;
        Node<E> first;
        first = h.next;
        h.next = h;
        head = first;
        E x;
        x = first.item;
        first.item = null;
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Node<E> h = head;
        //Node<E> first = h.next;
        //h.next = h;
        //head = first;
        //E x = first.item;
        //first.item = null;
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:28.018 -0400", hash_original_method = "8626572E0FE15707F18ECC5A9712CA34", hash_generated_method = "40B105B23664EBC59ED7C83721AB28FD")
    @DSModeled(DSC.SAFE)
     void fullyLock() {
        putLock.lock();
        takeLock.lock();
        // ---------- Original Method ----------
        //putLock.lock();
        //takeLock.lock();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:28.025 -0400", hash_original_method = "5557FE5692936575245483F7CDC5CE2B", hash_generated_method = "FD3F44BAACB37860B1054FCB3A177A12")
    @DSModeled(DSC.SAFE)
     void fullyUnlock() {
        takeLock.unlock();
        putLock.unlock();
        // ---------- Original Method ----------
        //takeLock.unlock();
        //putLock.unlock();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:28.026 -0400", hash_original_method = "FC3CFC9E56AD635CFF4ED177A60462DA", hash_generated_method = "B6F1A8E68945A650D680461F7FDDC680")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int size() {
        int var9D4B6D8BE09F232CC6DFC96E7C27D965_1220185570 = (count.get());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return count.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:28.029 -0400", hash_original_method = "F6FFB0DBE2C073472862E76EB78E2D9E", hash_generated_method = "721A264DEFC4B0C0EBEC2200C720CCE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int remainingCapacity() {
        int var1DA51DA4294BA3DCCB36CDBA725495A8_525860010 = (capacity - count.get());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return capacity - count.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:28.033 -0400", hash_original_method = "37DF2D00E21001E825743AC7943B033F", hash_generated_method = "91B14A97125629F78EB2BB0B42BBEE77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void put(E e) throws InterruptedException {
        dsTaint.addTaint(e.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        int c;
        c = -1;
        Node<E> node;
        node = new Node(e);
        ReentrantLock putLock;
        putLock = this.putLock;
        AtomicInteger count;
        count = this.count;
        putLock.lockInterruptibly();
        try 
        {
            {
                boolean var948F57AE74E06F0875AD4FB7B59A7541_499422605 = (count.get() == capacity);
                {
                    notFull.await();
                } //End block
            } //End collapsed parenthetic
            enqueue(node);
            c = count.getAndIncrement();
            notFull.signal();
        } //End block
        finally 
        {
            putLock.unlock();
        } //End block
        signalNotEmpty();
        // ---------- Original Method ----------
        //if (e == null) throw new NullPointerException();
        //int c = -1;
        //Node<E> node = new Node(e);
        //final ReentrantLock putLock = this.putLock;
        //final AtomicInteger count = this.count;
        //putLock.lockInterruptibly();
        //try {
            //while (count.get() == capacity) {
                //notFull.await();
            //}
            //enqueue(node);
            //c = count.getAndIncrement();
            //if (c + 1 < capacity)
                //notFull.signal();
        //} finally {
            //putLock.unlock();
        //}
        //if (c == 0)
            //signalNotEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:28.037 -0400", hash_original_method = "D5F3AC00421DA10DEFBB832E0EC3BAC8", hash_generated_method = "2F481BA97D6AED254D580B533C33074D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        dsTaint.addTaint(unit.dsTaint);
        dsTaint.addTaint(e.dsTaint);
        dsTaint.addTaint(timeout);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        long nanos;
        nanos = unit.toNanos(timeout);
        int c;
        c = -1;
        ReentrantLock putLock;
        putLock = this.putLock;
        AtomicInteger count;
        count = this.count;
        putLock.lockInterruptibly();
        try 
        {
            {
                boolean var948F57AE74E06F0875AD4FB7B59A7541_176680311 = (count.get() == capacity);
                {
                    nanos = notFull.awaitNanos(nanos);
                } //End block
            } //End collapsed parenthetic
            enqueue(new Node<E>(e));
            c = count.getAndIncrement();
            notFull.signal();
        } //End block
        finally 
        {
            putLock.unlock();
        } //End block
        signalNotEmpty();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (e == null) throw new NullPointerException();
        //long nanos = unit.toNanos(timeout);
        //int c = -1;
        //final ReentrantLock putLock = this.putLock;
        //final AtomicInteger count = this.count;
        //putLock.lockInterruptibly();
        //try {
            //while (count.get() == capacity) {
                //if (nanos <= 0)
                    //return false;
                //nanos = notFull.awaitNanos(nanos);
            //}
            //enqueue(new Node<E>(e));
            //c = count.getAndIncrement();
            //if (c + 1 < capacity)
                //notFull.signal();
        //} finally {
            //putLock.unlock();
        //}
        //if (c == 0)
            //signalNotEmpty();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:28.042 -0400", hash_original_method = "751C55DFDD2504B6D9AAA83EF3048DDA", hash_generated_method = "6B1CD2F13ACC44B0952C65AB47069AA2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean offer(E e) {
        dsTaint.addTaint(e.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        AtomicInteger count;
        count = this.count;
        {
            boolean var02EF388EE672A52C47389F83DEF5E6E1_1460323230 = (count.get() == capacity);
        } //End collapsed parenthetic
        int c;
        c = -1;
        Node<E> node;
        node = new Node(e);
        ReentrantLock putLock;
        putLock = this.putLock;
        putLock.lock();
        try 
        {
            {
                boolean var75CFCFA13C6DD354C40B5B06E074720E_951240880 = (count.get() < capacity);
                {
                    enqueue(node);
                    c = count.getAndIncrement();
                    notFull.signal();
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            putLock.unlock();
        } //End block
        signalNotEmpty();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (e == null) throw new NullPointerException();
        //final AtomicInteger count = this.count;
        //if (count.get() == capacity)
            //return false;
        //int c = -1;
        //Node<E> node = new Node(e);
        //final ReentrantLock putLock = this.putLock;
        //putLock.lock();
        //try {
            //if (count.get() < capacity) {
                //enqueue(node);
                //c = count.getAndIncrement();
                //if (c + 1 < capacity)
                    //notFull.signal();
            //}
        //} finally {
            //putLock.unlock();
        //}
        //if (c == 0)
            //signalNotEmpty();
        //return c >= 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:28.044 -0400", hash_original_method = "022306A077B45DC674F98467F25F93CD", hash_generated_method = "0B978E414E9AEB486EDAC96A7D4EB354")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E take() throws InterruptedException {
        E x;
        int c;
        c = -1;
        AtomicInteger count;
        count = this.count;
        ReentrantLock takeLock;
        takeLock = this.takeLock;
        takeLock.lockInterruptibly();
        try 
        {
            {
                boolean varC5243B16B9F11FD69A1317C582A7E86C_1319819278 = (count.get() == 0);
                {
                    notEmpty.await();
                } //End block
            } //End collapsed parenthetic
            x = dequeue();
            c = count.getAndDecrement();
            notEmpty.signal();
        } //End block
        finally 
        {
            takeLock.unlock();
        } //End block
        signalNotFull();
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //E x;
        //int c = -1;
        //final AtomicInteger count = this.count;
        //final ReentrantLock takeLock = this.takeLock;
        //takeLock.lockInterruptibly();
        //try {
            //while (count.get() == 0) {
                //notEmpty.await();
            //}
            //x = dequeue();
            //c = count.getAndDecrement();
            //if (c > 1)
                //notEmpty.signal();
        //} finally {
            //takeLock.unlock();
        //}
        //if (c == capacity)
            //signalNotFull();
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:28.047 -0400", hash_original_method = "AA8094BF5AEC46D297071331A526D258", hash_generated_method = "BC5FC32BDB66C50729D4A0B892673686")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        dsTaint.addTaint(unit.dsTaint);
        dsTaint.addTaint(timeout);
        E x;
        x = null;
        int c;
        c = -1;
        long nanos;
        nanos = unit.toNanos(timeout);
        AtomicInteger count;
        count = this.count;
        ReentrantLock takeLock;
        takeLock = this.takeLock;
        takeLock.lockInterruptibly();
        try 
        {
            {
                boolean varC5243B16B9F11FD69A1317C582A7E86C_332863688 = (count.get() == 0);
                {
                    nanos = notEmpty.awaitNanos(nanos);
                } //End block
            } //End collapsed parenthetic
            x = dequeue();
            c = count.getAndDecrement();
            notEmpty.signal();
        } //End block
        finally 
        {
            takeLock.unlock();
        } //End block
        signalNotFull();
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //E x = null;
        //int c = -1;
        //long nanos = unit.toNanos(timeout);
        //final AtomicInteger count = this.count;
        //final ReentrantLock takeLock = this.takeLock;
        //takeLock.lockInterruptibly();
        //try {
            //while (count.get() == 0) {
                //if (nanos <= 0)
                    //return null;
                //nanos = notEmpty.awaitNanos(nanos);
            //}
            //x = dequeue();
            //c = count.getAndDecrement();
            //if (c > 1)
                //notEmpty.signal();
        //} finally {
            //takeLock.unlock();
        //}
        //if (c == capacity)
            //signalNotFull();
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:28.052 -0400", hash_original_method = "D22B106AF12DCACC53C408D22FAEA025", hash_generated_method = "9172145DB1F3E3A508DE3C4796443311")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E poll() {
        AtomicInteger count;
        count = this.count;
        {
            boolean varEE4074E3A1B29EE612CF7959D3B3BF7F_932784408 = (count.get() == 0);
        } //End collapsed parenthetic
        E x;
        x = null;
        int c;
        c = -1;
        ReentrantLock takeLock;
        takeLock = this.takeLock;
        takeLock.lock();
        try 
        {
            {
                boolean var703747557BF3624C6F05C238D80E7799_61093517 = (count.get() > 0);
                {
                    x = dequeue();
                    c = count.getAndDecrement();
                    notEmpty.signal();
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            takeLock.unlock();
        } //End block
        signalNotFull();
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final AtomicInteger count = this.count;
        //if (count.get() == 0)
            //return null;
        //E x = null;
        //int c = -1;
        //final ReentrantLock takeLock = this.takeLock;
        //takeLock.lock();
        //try {
            //if (count.get() > 0) {
                //x = dequeue();
                //c = count.getAndDecrement();
                //if (c > 1)
                    //notEmpty.signal();
            //}
        //} finally {
            //takeLock.unlock();
        //}
        //if (c == capacity)
            //signalNotFull();
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:28.056 -0400", hash_original_method = "6BD887DAC1ACD373E1861DD85FA5D83B", hash_generated_method = "5A0BC9FA3D8DF70F8BAD30D601EF8EB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E peek() {
        {
            boolean varEE4074E3A1B29EE612CF7959D3B3BF7F_924017198 = (count.get() == 0);
        } //End collapsed parenthetic
        ReentrantLock takeLock;
        takeLock = this.takeLock;
        takeLock.lock();
        try 
        {
            Node<E> first;
            first = head.next;
        } //End block
        finally 
        {
            takeLock.unlock();
        } //End block
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (count.get() == 0)
            //return null;
        //final ReentrantLock takeLock = this.takeLock;
        //takeLock.lock();
        //try {
            //Node<E> first = head.next;
            //if (first == null)
                //return null;
            //else
                //return first.item;
        //} finally {
            //takeLock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:28.058 -0400", hash_original_method = "354B8979A292DF58D8ACD150BF598C2B", hash_generated_method = "CF8B55B89E82573D3E00A536B0E85DE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void unlink(Node<E> p, Node<E> trail) {
        dsTaint.addTaint(p.dsTaint);
        dsTaint.addTaint(trail.dsTaint);
        p.item = null;
        trail.next = p.next;
        {
            boolean var7A6724B3243CB327213BB455F7018D95_376140682 = (count.getAndDecrement() == capacity);
            notFull.signal();
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //p.item = null;
        //trail.next = p.next;
        //if (last == p)
            //last = trail;
        //if (count.getAndDecrement() == capacity)
            //notFull.signal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:28.061 -0400", hash_original_method = "43DA2AA0857729B72806FF0ABDC45219", hash_generated_method = "C24869774B3C8CBD24A01671A2A270E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean remove(Object o) {
        dsTaint.addTaint(o.dsTaint);
        fullyLock();
        try 
        {
            {
                Node<E> trail, p;
                trail = head;
                p = trail.next;
                trail = p;
                p = p.next;
                {
                    {
                        boolean varD072E6E000FCF729BD7B2505F48F68BD_2070742001 = (o.equals(p.item));
                        {
                            unlink(p, trail);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            fullyUnlock();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (o == null) return false;
        //fullyLock();
        //try {
            //for (Node<E> trail = head, p = trail.next;
                 //p != null;
                 //trail = p, p = p.next) {
                //if (o.equals(p.item)) {
                    //unlink(p, trail);
                    //return true;
                //}
            //}
            //return false;
        //} finally {
            //fullyUnlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:28.064 -0400", hash_original_method = "A4E3D89F8C47A7118ADD1757BF8D3A46", hash_generated_method = "57F1C47B2AB4A2B20817BB26371F59BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean contains(Object o) {
        dsTaint.addTaint(o.dsTaint);
        fullyLock();
        try 
        {
            {
                Node<E> p;
                p = head.next;
                p = p.next;
                {
                    boolean varF9DBDF4C5289176897871C74CFE4EAD8_2107373768 = (o.equals(p.item));
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            fullyUnlock();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (o == null) return false;
        //fullyLock();
        //try {
            //for (Node<E> p = head.next; p != null; p = p.next)
                //if (o.equals(p.item))
                    //return true;
            //return false;
        //} finally {
            //fullyUnlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:28.067 -0400", hash_original_method = "A06A302045E6771EA320A7223F86E4E8", hash_generated_method = "C6294ADC12689CBEB1682DE16CDB71F2")
    @DSModeled(DSC.SAFE)
    public Object[] toArray() {
        fullyLock();
        try 
        {
            int size;
            size = count.get();
            Object[] a;
            a = new Object[size];
            int k;
            k = 0;
            {
                Node<E> p;
                p = head.next;
                p = p.next;
                a[k++] = p.item;
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            fullyUnlock();
        } //End block
        return (Object[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //fullyLock();
        //try {
            //int size = count.get();
            //Object[] a = new Object[size];
            //int k = 0;
            //for (Node<E> p = head.next; p != null; p = p.next)
                //a[k++] = p.item;
            //return a;
        //} finally {
            //fullyUnlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:28.071 -0400", hash_original_method = "3C0973EC18B4AB6267920EDC87F075C5", hash_generated_method = "5D14DDA41379965CB1A042EBE2BECD79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        dsTaint.addTaint(a[0].dsTaint);
        fullyLock();
        try 
        {
            int size;
            size = count.get();
            a = (T[])java.lang.reflect.Array.newInstance
                    (a.getClass().getComponentType(), size);
            int k;
            k = 0;
            {
                Node<E> p;
                p = head.next;
                p = p.next;
                a[k++] = (T)p.item;
            } //End collapsed parenthetic
            a[k] = null;
        } //End block
        finally 
        {
            fullyUnlock();
        } //End block
        return (T[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //fullyLock();
        //try {
            //int size = count.get();
            //if (a.length < size)
                //a = (T[])java.lang.reflect.Array.newInstance
                    //(a.getClass().getComponentType(), size);
            //int k = 0;
            //for (Node<E> p = head.next; p != null; p = p.next)
                //a[k++] = (T)p.item;
            //if (a.length > k)
                //a[k] = null;
            //return a;
        //} finally {
            //fullyUnlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:28.073 -0400", hash_original_method = "74ADAA84A44AA4C99AF60EA5FA9916C8", hash_generated_method = "AA25B062A24C7CC5B8E02DA07418F9DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        fullyLock();
        try 
        {
            Node<E> p;
            p = head.next;
            StringBuilder sb;
            sb = new StringBuilder();
            sb.append('[');
            {
                E e;
                e = p.item;
                sb.append(e == this ? "(this Collection)" : e);
                p = p.next;
                String varD42D473455208C786FFB91F2E8BAED69_1824856762 = (sb.append(']').toString());
                sb.append(',').append(' ');
            } //End block
        } //End block
        finally 
        {
            fullyUnlock();
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //fullyLock();
        //try {
            //Node<E> p = head.next;
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
            //fullyUnlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:28.076 -0400", hash_original_method = "2B97B8EA201FFE74530152ABDF41ED91", hash_generated_method = "8230E667F2DF7E95981ED98026057340")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clear() {
        fullyLock();
        try 
        {
            {
                Node<E> p, h;
                h = head;
                p = h;
                {
                    h.next = h;
                    p.item = null;
                } //End block
            } //End collapsed parenthetic
            head = last;
            {
                boolean var5902D34412C5485351BC60F7B41D52F8_717612737 = (count.getAndSet(0) == capacity);
                notFull.signal();
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            fullyUnlock();
        } //End block
        // ---------- Original Method ----------
        //fullyLock();
        //try {
            //for (Node<E> p, h = head; (p = h.next) != null; h = p) {
                //h.next = h;
                //p.item = null;
            //}
            //head = last;
            //if (count.getAndSet(0) == capacity)
                //notFull.signal();
        //} finally {
            //fullyUnlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:28.078 -0400", hash_original_method = "848AB2101C925A7DB8B05331DC1D79E6", hash_generated_method = "6367BC7BA0A268FC9534B8B9A2FC6BCE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int drainTo(Collection<? super E> c) {
        dsTaint.addTaint(c.dsTaint);
        int var0B753C0ADE2F28D7A7716F28C1FC5A12_1942714571 = (drainTo(c, Integer.MAX_VALUE));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return drainTo(c, Integer.MAX_VALUE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:28.082 -0400", hash_original_method = "3B8D4B25C05B9AD02BEBED4DB8AC9EEC", hash_generated_method = "45226457D6DAC2007A2E684DB163F146")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int drainTo(Collection<? super E> c, int maxElements) {
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(maxElements);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        boolean signalNotFull;
        signalNotFull = false;
        ReentrantLock takeLock;
        takeLock = this.takeLock;
        takeLock.lock();
        try 
        {
            int n;
            n = Math.min(maxElements, count.get());
            Node<E> h;
            h = head;
            int i;
            i = 0;
            try 
            {
                {
                    Node<E> p;
                    p = h.next;
                    c.add(p.item);
                    p.item = null;
                    h.next = h;
                    h = p;
                    ++i;
                } //End block
            } //End block
            finally 
            {
                {
                    head = h;
                    signalNotFull = (count.getAndAdd(-i) == capacity);
                } //End block
            } //End block
        } //End block
        finally 
        {
            takeLock.unlock();
            signalNotFull();
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:28.088 -0400", hash_original_method = "756A0449DBEE27B15290EF9912B6D98E", hash_generated_method = "94563C56B3FC79F1CAFC9B5EBACD20CD")
    @DSModeled(DSC.SAFE)
    public Iterator<E> iterator() {
        return (Iterator<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Itr();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:28.093 -0400", hash_original_method = "407E789BCFB8527B31EA0FCB2D45014F", hash_generated_method = "CCBCB6676CFB64E98F73DA02D9CC6D93")
    @DSModeled(DSC.SAFE)
    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
        dsTaint.addTaint(s.dsTaint);
        fullyLock();
        try 
        {
            s.defaultWriteObject();
            {
                Node<E> p;
                p = head.next;
                p = p.next;
                s.writeObject(p.item);
            } //End collapsed parenthetic
            s.writeObject(null);
        } //End block
        finally 
        {
            fullyUnlock();
        } //End block
        // ---------- Original Method ----------
        //fullyLock();
        //try {
            //s.defaultWriteObject();
            //for (Node<E> p = head.next; p != null; p = p.next)
                //s.writeObject(p.item);
            //s.writeObject(null);
        //} finally {
            //fullyUnlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:28.095 -0400", hash_original_method = "2A845E5CA6C44D2307376F014D4A5DD1", hash_generated_method = "CB867DAFF88433D962050AA7D74ACCE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
        dsTaint.addTaint(s.dsTaint);
        s.defaultReadObject();
        count.set(0);
        last = head = new Node<E>(null);
        {
            @SuppressWarnings("unchecked") E item;
            item = (E)s.readObject();
            add(item);
        } //End block
        // ---------- Original Method ----------
        //s.defaultReadObject();
        //count.set(0);
        //last = head = new Node<E>(null);
        //for (;;) {
            //@SuppressWarnings("unchecked")
            //E item = (E)s.readObject();
            //if (item == null)
                //break;
            //add(item);
        //}
    }

    
    static class Node<E> {
        E item;
        Node<E> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:28.096 -0400", hash_original_method = "E24CFB813CF8D6D3545154C1747D57F8", hash_generated_method = "6CD689F11529D8E358049D384472F6F2")
        @DSModeled(DSC.SAFE)
         Node(E x) {
            dsTaint.addTaint(x.dsTaint);
            // ---------- Original Method ----------
            //item = x;
        }

        
    }


    
    private class Itr implements Iterator<E> {
        private Node<E> current;
        private Node<E> lastRet;
        private E currentElement;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:28.098 -0400", hash_original_method = "5363017965403D930144EB6431B1229A", hash_generated_method = "095F9FB75A48159FCDE3BD9118839598")
        @DSModeled(DSC.SAFE)
         Itr() {
            fullyLock();
            try 
            {
                current = head.next;
                currentElement = current.item;
            } //End block
            finally 
            {
                fullyUnlock();
            } //End block
            // ---------- Original Method ----------
            //fullyLock();
            //try {
                //current = head.next;
                //if (current != null)
                    //currentElement = current.item;
            //} finally {
                //fullyUnlock();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:28.104 -0400", hash_original_method = "930D47D628EF4F4226A6936FD0C40F3E", hash_generated_method = "07685A88A5E83B5A31B6958B7727BAF0")
        @DSModeled(DSC.SAFE)
        public boolean hasNext() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return current != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:28.105 -0400", hash_original_method = "4F1204B9DEA81FB44DF832DBC08BD27C", hash_generated_method = "854273ACCF97118E80F086480430C37A")
        @DSModeled(DSC.SAFE)
        private Node<E> nextNode(Node<E> p) {
            dsTaint.addTaint(p.dsTaint);
            {
                Node<E> s;
                s = p.next;
                p = s;
            } //End block
            return (Node<E>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //for (;;) {
                //Node<E> s = p.next;
                //if (s == p)
                    //return head.next;
                //if (s == null || s.item != null)
                    //return s;
                //p = s;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:28.107 -0400", hash_original_method = "B1551F09E1CC1CE37F95082545A7F15D", hash_generated_method = "375EC9E36F05E8EF1ED8C2D7F2B7F309")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public E next() {
            fullyLock();
            try 
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                E x;
                x = currentElement;
                lastRet = current;
                current = nextNode(current);
                currentElement = (current == null) ? null : current.item;
            } //End block
            finally 
            {
                fullyUnlock();
            } //End block
            return (E)dsTaint.getTaint();
            // ---------- Original Method ----------
            //fullyLock();
            //try {
                //if (current == null)
                    //throw new NoSuchElementException();
                //E x = currentElement;
                //lastRet = current;
                //current = nextNode(current);
                //currentElement = (current == null) ? null : current.item;
                //return x;
            //} finally {
                //fullyUnlock();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:28.110 -0400", hash_original_method = "9DBE3C9C0D54D1E1956F6E76D38BE63A", hash_generated_method = "AD39835B824641E0C7FC6EBDF4E0BD92")
        @DSModeled(DSC.SAFE)
        public void remove() {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            fullyLock();
            try 
            {
                Node<E> node;
                node = lastRet;
                lastRet = null;
                {
                    Node<E> trail, p;
                    trail = head;
                    p = trail.next;
                    trail = p;
                    p = p.next;
                    {
                        {
                            unlink(p, trail);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            finally 
            {
                fullyUnlock();
            } //End block
            // ---------- Original Method ----------
            //if (lastRet == null)
                //throw new IllegalStateException();
            //fullyLock();
            //try {
                //Node<E> node = lastRet;
                //lastRet = null;
                //for (Node<E> trail = head, p = trail.next;
                     //p != null;
                     //trail = p, p = p.next) {
                    //if (p == node) {
                        //unlink(p, trail);
                        //break;
                    //}
                //}
            //} finally {
                //fullyUnlock();
            //}
        }

        
    }


    
}


