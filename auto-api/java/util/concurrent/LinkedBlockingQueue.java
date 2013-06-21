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
    private int capacity;
    private AtomicInteger count = new AtomicInteger(0);
    private transient Node<E> head;
    private transient Node<E> last;
    private ReentrantLock takeLock = new ReentrantLock();
    private Condition notEmpty = takeLock.newCondition();
    private ReentrantLock putLock = new ReentrantLock();
    private Condition notFull = putLock.newCondition();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.731 -0400", hash_original_method = "632CB0CBBBC44DF00B6EA380FB3D1564", hash_generated_method = "7E050AD6D76868049EBE527D41ED6759")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkedBlockingQueue() {
        this(Integer.MAX_VALUE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.732 -0400", hash_original_method = "B75314FE98F585143D624DCD24C1F5B2", hash_generated_method = "93152630D480AD97515039EA7217678F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkedBlockingQueue(int capacity) {
        dsTaint.addTaint(capacity);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        last = head = new Node<E>(null);
        // ---------- Original Method ----------
        //if (capacity <= 0) throw new IllegalArgumentException();
        //this.capacity = capacity;
        //last = head = new Node<E>(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.734 -0400", hash_original_method = "76A1733AA4693E67903F6C627D09C67F", hash_generated_method = "AF46D308E5D72CD73F2CF2E81584610E")
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
                Iterator<E> var334ED49EB23041C8D120547C1BB713D2_531779905 = (c).iterator();
                var334ED49EB23041C8D120547C1BB713D2_531779905.hasNext();
                E e = var334ED49EB23041C8D120547C1BB713D2_531779905.next();
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Queue full");
                    enqueue(new Node<E>(e));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.734 -0400", hash_original_method = "15D22B562F85AEAC3F4AC4996FFD23A3", hash_generated_method = "B1B3CF7D29F9116BCA483B5BD502B5C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.734 -0400", hash_original_method = "23256B84FD63DB25D1FF9FA99CF29C9A", hash_generated_method = "868FD6C751B6DFE434E0B8C8168BA9BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.734 -0400", hash_original_method = "050BE5B4C52573633224C87BCCA985D9", hash_generated_method = "DD6E6A7B5020FF9566009EE1FE1446C1")
    @DSModeled(DSC.SAFE)
    private void enqueue(Node<E> node) {
        dsTaint.addTaint(node.dsTaint);
        last = last.next = node;
        // ---------- Original Method ----------
        //last = last.next = node;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.735 -0400", hash_original_method = "0F3CD055205E18F01917D382EBA2EDD8", hash_generated_method = "FA7DCB0D7986DDA84FF8E2DF82EB0E96")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.735 -0400", hash_original_method = "8626572E0FE15707F18ECC5A9712CA34", hash_generated_method = "3646A04C6AE367BA0A6AA42D1CCE1C16")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void fullyLock() {
        putLock.lock();
        takeLock.lock();
        // ---------- Original Method ----------
        //putLock.lock();
        //takeLock.lock();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.735 -0400", hash_original_method = "5557FE5692936575245483F7CDC5CE2B", hash_generated_method = "DB6AEC1BC900D9A1E58F0AE1939A9554")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void fullyUnlock() {
        takeLock.unlock();
        putLock.unlock();
        // ---------- Original Method ----------
        //takeLock.unlock();
        //putLock.unlock();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.735 -0400", hash_original_method = "FC3CFC9E56AD635CFF4ED177A60462DA", hash_generated_method = "B0D9A21CA83DD8BFF0358E50681621BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int size() {
        int var9D4B6D8BE09F232CC6DFC96E7C27D965_299102702 = (count.get());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return count.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.735 -0400", hash_original_method = "F6FFB0DBE2C073472862E76EB78E2D9E", hash_generated_method = "207A197C9DA4D51BBFABA07B16AE3391")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int remainingCapacity() {
        int var1DA51DA4294BA3DCCB36CDBA725495A8_1966462612 = (capacity - count.get());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return capacity - count.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.736 -0400", hash_original_method = "37DF2D00E21001E825743AC7943B033F", hash_generated_method = "DC50F97D0BBB105B3A462735E109F3A1")
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
                boolean var948F57AE74E06F0875AD4FB7B59A7541_1870824824 = (count.get() == capacity);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.736 -0400", hash_original_method = "D5F3AC00421DA10DEFBB832E0EC3BAC8", hash_generated_method = "7BDA84CC4E38420FE7AF74150BDDDFE2")
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
                boolean var948F57AE74E06F0875AD4FB7B59A7541_1997023139 = (count.get() == capacity);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.737 -0400", hash_original_method = "751C55DFDD2504B6D9AAA83EF3048DDA", hash_generated_method = "FBE4F72DD5271F7863A092A3C490D37E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean offer(E e) {
        dsTaint.addTaint(e.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        AtomicInteger count;
        count = this.count;
        {
            boolean var02EF388EE672A52C47389F83DEF5E6E1_1129057819 = (count.get() == capacity);
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
                boolean var75CFCFA13C6DD354C40B5B06E074720E_751075940 = (count.get() < capacity);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.737 -0400", hash_original_method = "022306A077B45DC674F98467F25F93CD", hash_generated_method = "ACD0F969A4EC17E407E64899F7DD10E8")
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
                boolean varC5243B16B9F11FD69A1317C582A7E86C_609581454 = (count.get() == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.737 -0400", hash_original_method = "AA8094BF5AEC46D297071331A526D258", hash_generated_method = "BB2B2A56AC80EA0BDB496BC527FF9BE4")
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
                boolean varC5243B16B9F11FD69A1317C582A7E86C_532039756 = (count.get() == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.738 -0400", hash_original_method = "D22B106AF12DCACC53C408D22FAEA025", hash_generated_method = "FABE5A4C09C8F53FF480FDC1E21A8DB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E poll() {
        AtomicInteger count;
        count = this.count;
        {
            boolean varEE4074E3A1B29EE612CF7959D3B3BF7F_941780097 = (count.get() == 0);
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
                boolean var703747557BF3624C6F05C238D80E7799_449626460 = (count.get() > 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.738 -0400", hash_original_method = "6BD887DAC1ACD373E1861DD85FA5D83B", hash_generated_method = "794C5EA38E186F5D1A6C191C6ACD59B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public E peek() {
        {
            boolean varEE4074E3A1B29EE612CF7959D3B3BF7F_2034033226 = (count.get() == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.738 -0400", hash_original_method = "354B8979A292DF58D8ACD150BF598C2B", hash_generated_method = "E314A1ABB5AB9967F360D2E1D23E422C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void unlink(Node<E> p, Node<E> trail) {
        dsTaint.addTaint(trail.dsTaint);
        dsTaint.addTaint(p.dsTaint);
        p.item = null;
        trail.next = p.next;
        {
            boolean var7A6724B3243CB327213BB455F7018D95_396942968 = (count.getAndDecrement() == capacity);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.739 -0400", hash_original_method = "43DA2AA0857729B72806FF0ABDC45219", hash_generated_method = "7ED2A6D3EEF92D2E4C942268CC0CC9AB")
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
                        boolean varD072E6E000FCF729BD7B2505F48F68BD_735340428 = (o.equals(p.item));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.739 -0400", hash_original_method = "A4E3D89F8C47A7118ADD1757BF8D3A46", hash_generated_method = "2435E5986798A1C81E3E0F56ABE27F13")
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
                    boolean varF9DBDF4C5289176897871C74CFE4EAD8_937611547 = (o.equals(p.item));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.739 -0400", hash_original_method = "A06A302045E6771EA320A7223F86E4E8", hash_generated_method = "06A0651DAA13D490A8025698331DE398")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.740 -0400", hash_original_method = "3C0973EC18B4AB6267920EDC87F075C5", hash_generated_method = "C55673E6FA84EACCBD580A9948235BFF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.740 -0400", hash_original_method = "74ADAA84A44AA4C99AF60EA5FA9916C8", hash_generated_method = "23E5E7D01891D6415EDFAA6A6718D677")
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
                String varD42D473455208C786FFB91F2E8BAED69_650633070 = (sb.append(']').toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.741 -0400", hash_original_method = "2B97B8EA201FFE74530152ABDF41ED91", hash_generated_method = "CBDA23879802AB4A8ABB8F0EAF667716")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clear() {
        fullyLock();
        try 
        {
            {
                Node<E> p, h;
                h = head;
                h = p;
                {
                    h.next = h;
                    p.item = null;
                } //End block
            } //End collapsed parenthetic
            head = last;
            {
                boolean var5902D34412C5485351BC60F7B41D52F8_997042508 = (count.getAndSet(0) == capacity);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.741 -0400", hash_original_method = "848AB2101C925A7DB8B05331DC1D79E6", hash_generated_method = "7A84F8775676740DDA70340D46A2196B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int drainTo(Collection<? super E> c) {
        dsTaint.addTaint(c.dsTaint);
        int var0B753C0ADE2F28D7A7716F28C1FC5A12_542635288 = (drainTo(c, Integer.MAX_VALUE));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return drainTo(c, Integer.MAX_VALUE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.741 -0400", hash_original_method = "3B8D4B25C05B9AD02BEBED4DB8AC9EEC", hash_generated_method = "9ACA3A415A0608BDFE9BDC71DAFA3B27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int drainTo(Collection<? super E> c, int maxElements) {
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(maxElements);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        {
            boolean var9AEE7ACC5B0D4AF26CA46D5AFC07CCF3_1550567546 = (c == this);
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.742 -0400", hash_original_method = "756A0449DBEE27B15290EF9912B6D98E", hash_generated_method = "496A269561344D3D95948D69C3189214")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Iterator<E> iterator() {
        Iterator<E> var6FD43ACE88DA273A205C691B9F46907D_1769569068 = (new Itr());
        return (Iterator<E>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Itr();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.742 -0400", hash_original_method = "407E789BCFB8527B31EA0FCB2D45014F", hash_generated_method = "6C16251C7D9F1BAD432525B905A12B48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.742 -0400", hash_original_method = "2A845E5CA6C44D2307376F014D4A5DD1", hash_generated_method = "A5A78C8627AAC6F024E6E961B0FACD16")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.742 -0400", hash_original_method = "E24CFB813CF8D6D3545154C1747D57F8", hash_generated_method = "35C6C75F3F8AA0F73D89AC19772A7FE3")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.743 -0400", hash_original_method = "5363017965403D930144EB6431B1229A", hash_generated_method = "7BAD25B3B01523F245BCD4EDCDD09007")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.743 -0400", hash_original_method = "930D47D628EF4F4226A6936FD0C40F3E", hash_generated_method = "0F8CF49A330F029D6CCA6B0E41EEBB7A")
        @DSModeled(DSC.SAFE)
        public boolean hasNext() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return current != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.743 -0400", hash_original_method = "4F1204B9DEA81FB44DF832DBC08BD27C", hash_generated_method = "D835E0EA84ADC9A21124831DDC6A9680")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.743 -0400", hash_original_method = "B1551F09E1CC1CE37F95082545A7F15D", hash_generated_method = "51ED5D6BDE8901E06CB4397AB2733752")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.744 -0400", hash_original_method = "9DBE3C9C0D54D1E1956F6E76D38BE63A", hash_generated_method = "D26161053794EB7BCF80A9C413DF3A28")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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


    
    private static final long serialVersionUID = -6903933977591709194L;
}

