package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedBlockingQueue<E> extends AbstractQueue<E> implements BlockingQueue<E>, java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.572 -0400", hash_original_field = "7BD14A231864E618E1840C7E117E59C1", hash_generated_field = "277B4266A058D752E724058E1F215618")

    private int capacity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.572 -0400", hash_original_field = "E15431B372E31BBE6073FBB6C5E792BB", hash_generated_field = "BBA980D7D7B7F08CF4B42F041B343B13")

    private final AtomicInteger count = new AtomicInteger(0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.572 -0400", hash_original_field = "96E89A298E0A9F469B9AE458D6AFAE9F", hash_generated_field = "48C6F3CDEAC5EAEAC23BFB1092B4D3A3")

    private transient Node<E> head;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.572 -0400", hash_original_field = "98BD1C45684CF587AC2347A92DD7BB51", hash_generated_field = "9882BA72234087D024BDEB5C6D765CDA")

    private transient Node<E> last;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.572 -0400", hash_original_field = "5322750CBC5FB7E2B3FB560931054E46", hash_generated_field = "2489B27DF1A4E990956C48CE97BB7781")

    private final ReentrantLock takeLock = new ReentrantLock();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.572 -0400", hash_original_field = "CEF6C451AADF04E0C65480DEFEC861F2", hash_generated_field = "A3C160CB8F7274E37EB4990919FC4F81")

    private final Condition notEmpty = takeLock.newCondition();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.572 -0400", hash_original_field = "286E62C1C5B79371FA322708D11C41C5", hash_generated_field = "9E4EEFB3EF021ED502CF0754B96D9D32")

    private final ReentrantLock putLock = new ReentrantLock();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.572 -0400", hash_original_field = "FA225E5A4B225155E82C7ABA1BEF10B6", hash_generated_field = "22DCE80F4D8874940E856E975444C863")

    private final Condition notFull = putLock.newCondition();
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.572 -0400", hash_original_method = "632CB0CBBBC44DF00B6EA380FB3D1564", hash_generated_method = "7E050AD6D76868049EBE527D41ED6759")
    public  LinkedBlockingQueue() {
        this(Integer.MAX_VALUE);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.573 -0400", hash_original_method = "B75314FE98F585143D624DCD24C1F5B2", hash_generated_method = "522EF65C31FF32FCF5C754001FD46FDB")
    public  LinkedBlockingQueue(int capacity) {
        if(capacity <= 0)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_271081503 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_271081503.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_271081503;
        }
        this.capacity = capacity;
        last = head = new Node<E>(null);
        // ---------- Original Method ----------
        //if (capacity <= 0) throw new IllegalArgumentException();
        //this.capacity = capacity;
        //last = head = new Node<E>(null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.574 -0400", hash_original_method = "76A1733AA4693E67903F6C627D09C67F", hash_generated_method = "231A0E6B3DAD427E63F24FB2FA22DABC")
    public  LinkedBlockingQueue(Collection<? extends E> c) {
        this(Integer.MAX_VALUE);
        addTaint(c.getTaint());
        final ReentrantLock putLock = this.putLock;
        putLock.lock();
        try 
        {
            int n = 0;
for(E e : c)
            {
                if(e == null)                
                {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1137393368 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1137393368.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1137393368;
                }
                if(n == capacity)                
                {
                IllegalStateException varA33CF04882B88437ABCEE84817862B41_296752655 = new IllegalStateException("Queue full");
                varA33CF04882B88437ABCEE84817862B41_296752655.addTaint(taint);
                throw varA33CF04882B88437ABCEE84817862B41_296752655;
                }
                enqueue(new Node<E>(e));
                ++n;
            } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.574 -0400", hash_original_method = "15D22B562F85AEAC3F4AC4996FFD23A3", hash_generated_method = "C88CC2A92019BFE63FC44817948B087E")
    private void signalNotEmpty() {
        final ReentrantLock takeLock = this.takeLock;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.575 -0400", hash_original_method = "23256B84FD63DB25D1FF9FA99CF29C9A", hash_generated_method = "72C992F6506997D32138FF21DE2D90EF")
    private void signalNotFull() {
        final ReentrantLock putLock = this.putLock;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.575 -0400", hash_original_method = "050BE5B4C52573633224C87BCCA985D9", hash_generated_method = "1294900CE5F97C64F9A5E140C9BF1299")
    private void enqueue(Node<E> node) {
        last = last.next = node;
        // ---------- Original Method ----------
        //last = last.next = node;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.576 -0400", hash_original_method = "0F3CD055205E18F01917D382EBA2EDD8", hash_generated_method = "A117563231F238FD00F0D41BA76B0E81")
    private E dequeue() {
        Node<E> h = head;
        Node<E> first = h.next;
        h.next = h;
        head = first;
        E x = first.item;
        first.item = null;
E varEA5659DA512DECF23E6D37EE8060D074_819748895 =         x;
        varEA5659DA512DECF23E6D37EE8060D074_819748895.addTaint(taint);
        return varEA5659DA512DECF23E6D37EE8060D074_819748895;
        // ---------- Original Method ----------
        //Node<E> h = head;
        //Node<E> first = h.next;
        //h.next = h;
        //head = first;
        //E x = first.item;
        //first.item = null;
        //return x;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.576 -0400", hash_original_method = "8626572E0FE15707F18ECC5A9712CA34", hash_generated_method = "3646A04C6AE367BA0A6AA42D1CCE1C16")
     void fullyLock() {
        putLock.lock();
        takeLock.lock();
        // ---------- Original Method ----------
        //putLock.lock();
        //takeLock.lock();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.576 -0400", hash_original_method = "5557FE5692936575245483F7CDC5CE2B", hash_generated_method = "DB6AEC1BC900D9A1E58F0AE1939A9554")
     void fullyUnlock() {
        takeLock.unlock();
        putLock.unlock();
        // ---------- Original Method ----------
        //takeLock.unlock();
        //putLock.unlock();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.577 -0400", hash_original_method = "FC3CFC9E56AD635CFF4ED177A60462DA", hash_generated_method = "00EADA5064772E37C51BFDB44BAE02F7")
    public int size() {
        int varF07AF9B5EBE1BDA12C06190B44E1F695_608047208 = (count.get());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1412759457 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1412759457;
        // ---------- Original Method ----------
        //return count.get();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.577 -0400", hash_original_method = "F6FFB0DBE2C073472862E76EB78E2D9E", hash_generated_method = "66B5F54A4693523FA4D7F182D0522FEB")
    public int remainingCapacity() {
        int var3C1171412FC071707DFA3A3D59A03AD0_1415676515 = (capacity - count.get());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1016447045 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1016447045;
        // ---------- Original Method ----------
        //return capacity - count.get();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.578 -0400", hash_original_method = "37DF2D00E21001E825743AC7943B033F", hash_generated_method = "EB395E62435205A29BEA409AB44568F7")
    public void put(E e) throws InterruptedException {
        addTaint(e.getTaint());
        if(e == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_438874313 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_438874313.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_438874313;
        }
        int c = -1;
        Node<E> node = new Node(e);
        final ReentrantLock putLock = this.putLock;
        final AtomicInteger count = this.count;
        putLock.lockInterruptibly();
        try 
        {
            while
(count.get() == capacity)            
            {
                notFull.await();
            } //End block
            enqueue(node);
            c = count.getAndIncrement();
            if(c + 1 < capacity)            
            notFull.signal();
        } //End block
        finally 
        {
            putLock.unlock();
        } //End block
        if(c == 0)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.578 -0400", hash_original_method = "D5F3AC00421DA10DEFBB832E0EC3BAC8", hash_generated_method = "6C3CB7B06B05C7F7868B934CE3A59979")
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        addTaint(unit.getTaint());
        addTaint(timeout);
        addTaint(e.getTaint());
        if(e == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_2140182930 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_2140182930.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_2140182930;
        }
        long nanos = unit.toNanos(timeout);
        int c = -1;
        final ReentrantLock putLock = this.putLock;
        final AtomicInteger count = this.count;
        putLock.lockInterruptibly();
        try 
        {
            while
(count.get() == capacity)            
            {
                if(nanos <= 0)                
                {
                boolean var68934A3E9455FA72420237EB05902327_1798056142 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_225162242 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_225162242;
                }
                nanos = notFull.awaitNanos(nanos);
            } //End block
            enqueue(new Node<E>(e));
            c = count.getAndIncrement();
            if(c + 1 < capacity)            
            notFull.signal();
        } //End block
        finally 
        {
            putLock.unlock();
        } //End block
        if(c == 0)        
        signalNotEmpty();
        boolean varB326B5062B2F0E69046810717534CB09_1762601393 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_668526819 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_668526819;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.579 -0400", hash_original_method = "751C55DFDD2504B6D9AAA83EF3048DDA", hash_generated_method = "992DC16B54CE3EEDAD3FC82ED39949B5")
    public boolean offer(E e) {
        addTaint(e.getTaint());
        if(e == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1994568557 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1994568557.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1994568557;
        }
        final AtomicInteger count = this.count;
        if(count.get() == capacity)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1845001768 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_562956420 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_562956420;
        }
        int c = -1;
        Node<E> node = new Node(e);
        final ReentrantLock putLock = this.putLock;
        putLock.lock();
        try 
        {
            if(count.get() < capacity)            
            {
                enqueue(node);
                c = count.getAndIncrement();
                if(c + 1 < capacity)                
                notFull.signal();
            } //End block
        } //End block
        finally 
        {
            putLock.unlock();
        } //End block
        if(c == 0)        
        signalNotEmpty();
        boolean var6EBA6DF55A2DFD6D58CC892FE0ED47AD_597125921 = (c >= 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_69409545 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_69409545;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.580 -0400", hash_original_method = "022306A077B45DC674F98467F25F93CD", hash_generated_method = "684CE32812682A5C391C64E874FBE2B8")
    public E take() throws InterruptedException {
        E x;
        int c = -1;
        final AtomicInteger count = this.count;
        final ReentrantLock takeLock = this.takeLock;
        takeLock.lockInterruptibly();
        try 
        {
            while
(count.get() == 0)            
            {
                notEmpty.await();
            } //End block
            x = dequeue();
            c = count.getAndDecrement();
            if(c > 1)            
            notEmpty.signal();
        } //End block
        finally 
        {
            takeLock.unlock();
        } //End block
        if(c == capacity)        
        signalNotFull();
E varEA5659DA512DECF23E6D37EE8060D074_616531983 =         x;
        varEA5659DA512DECF23E6D37EE8060D074_616531983.addTaint(taint);
        return varEA5659DA512DECF23E6D37EE8060D074_616531983;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.581 -0400", hash_original_method = "AA8094BF5AEC46D297071331A526D258", hash_generated_method = "36C076C2A2F22898E7B9169D796BD579")
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        addTaint(unit.getTaint());
        addTaint(timeout);
        E x = null;
        int c = -1;
        long nanos = unit.toNanos(timeout);
        final AtomicInteger count = this.count;
        final ReentrantLock takeLock = this.takeLock;
        takeLock.lockInterruptibly();
        try 
        {
            while
(count.get() == 0)            
            {
                if(nanos <= 0)                
                {
E var540C13E9E156B687226421B24F2DF178_1611225758 =                 null;
                var540C13E9E156B687226421B24F2DF178_1611225758.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1611225758;
                }
                nanos = notEmpty.awaitNanos(nanos);
            } //End block
            x = dequeue();
            c = count.getAndDecrement();
            if(c > 1)            
            notEmpty.signal();
        } //End block
        finally 
        {
            takeLock.unlock();
        } //End block
        if(c == capacity)        
        signalNotFull();
E varEA5659DA512DECF23E6D37EE8060D074_1276814945 =         x;
        varEA5659DA512DECF23E6D37EE8060D074_1276814945.addTaint(taint);
        return varEA5659DA512DECF23E6D37EE8060D074_1276814945;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.581 -0400", hash_original_method = "D22B106AF12DCACC53C408D22FAEA025", hash_generated_method = "3229BA0226D251C80450412C77636306")
    public E poll() {
        final AtomicInteger count = this.count;
        if(count.get() == 0)        
        {
E var540C13E9E156B687226421B24F2DF178_2048647385 =         null;
        var540C13E9E156B687226421B24F2DF178_2048647385.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2048647385;
        }
        E x = null;
        int c = -1;
        final ReentrantLock takeLock = this.takeLock;
        takeLock.lock();
        try 
        {
            if(count.get() > 0)            
            {
                x = dequeue();
                c = count.getAndDecrement();
                if(c > 1)                
                notEmpty.signal();
            } //End block
        } //End block
        finally 
        {
            takeLock.unlock();
        } //End block
        if(c == capacity)        
        signalNotFull();
E varEA5659DA512DECF23E6D37EE8060D074_791350341 =         x;
        varEA5659DA512DECF23E6D37EE8060D074_791350341.addTaint(taint);
        return varEA5659DA512DECF23E6D37EE8060D074_791350341;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.582 -0400", hash_original_method = "6BD887DAC1ACD373E1861DD85FA5D83B", hash_generated_method = "47DB5FFCEB65876861252F52DF6595EE")
    public E peek() {
        if(count.get() == 0)        
        {
E var540C13E9E156B687226421B24F2DF178_418607702 =         null;
        var540C13E9E156B687226421B24F2DF178_418607702.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_418607702;
        }
        final ReentrantLock takeLock = this.takeLock;
        takeLock.lock();
        try 
        {
            Node<E> first = head.next;
            if(first == null)            
            {
E var540C13E9E156B687226421B24F2DF178_265863264 =             null;
            var540C13E9E156B687226421B24F2DF178_265863264.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_265863264;
            }
            else
            {
E var30B383EF1E5A298C086E51BB7B7C5921_1764209665 =             first.item;
            var30B383EF1E5A298C086E51BB7B7C5921_1764209665.addTaint(taint);
            return var30B383EF1E5A298C086E51BB7B7C5921_1764209665;
            }
        } //End block
        finally 
        {
            takeLock.unlock();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.583 -0400", hash_original_method = "354B8979A292DF58D8ACD150BF598C2B", hash_generated_method = "22D67B5BF57C5A5189D49DEFF4070BEC")
     void unlink(Node<E> p, Node<E> trail) {
        addTaint(p.getTaint());
        p.item = null;
        trail.next = p.next;
        if(last == p)        
        last = trail;
        if(count.getAndDecrement() == capacity)        
        notFull.signal();
        // ---------- Original Method ----------
        //p.item = null;
        //trail.next = p.next;
        //if (last == p)
            //last = trail;
        //if (count.getAndDecrement() == capacity)
            //notFull.signal();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.584 -0400", hash_original_method = "43DA2AA0857729B72806FF0ABDC45219", hash_generated_method = "64EE43387BC6C39DD7A01CBF5C63CD27")
    public boolean remove(Object o) {
        addTaint(o.getTaint());
        if(o == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1079397815 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_90113482 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_90113482;
        }
        fullyLock();
        try 
        {
for(Node<E> trail = head, p = trail.next;p != null;trail = p,p = p.next)
            {
                if(o.equals(p.item))                
                {
                    unlink(p, trail);
                    boolean varB326B5062B2F0E69046810717534CB09_429105445 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_118096876 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_118096876;
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1785796128 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1449841571 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1449841571;
        } //End block
        finally 
        {
            fullyUnlock();
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.584 -0400", hash_original_method = "A4E3D89F8C47A7118ADD1757BF8D3A46", hash_generated_method = "32DE336F3CFB9CA0C294BDEC4043F1E7")
    public boolean contains(Object o) {
        addTaint(o.getTaint());
        if(o == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_2120078893 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1867712474 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1867712474;
        }
        fullyLock();
        try 
        {
for(Node<E> p = head.next;p != null;p = p.next)
            if(o.equals(p.item))            
            {
            boolean varB326B5062B2F0E69046810717534CB09_938421147 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_682654074 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_682654074;
            }
            boolean var68934A3E9455FA72420237EB05902327_1930202202 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1837243310 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1837243310;
        } //End block
        finally 
        {
            fullyUnlock();
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.585 -0400", hash_original_method = "A06A302045E6771EA320A7223F86E4E8", hash_generated_method = "F54C26383D4EC7BD5FFCDB0D813C0246")
    public Object[] toArray() {
        fullyLock();
        try 
        {
            int size = count.get();
            Object[] a = new Object[size];
            int k = 0;
for(Node<E> p = head.next;p != null;p = p.next)
            a[k++] = p.item;
Object[] var3F5343BF1D849954A73F0BB303805FFD_91543116 =             a;
            var3F5343BF1D849954A73F0BB303805FFD_91543116.addTaint(taint);
            return var3F5343BF1D849954A73F0BB303805FFD_91543116;
        } //End block
        finally 
        {
            fullyUnlock();
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.586 -0400", hash_original_method = "3C0973EC18B4AB6267920EDC87F075C5", hash_generated_method = "765D849DB37E2E7E74B6D5F8CD431089")
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        addTaint(a[0].getTaint());
        fullyLock();
        try 
        {
            int size = count.get();
            if(a.length < size)            
            a = (T[])java.lang.reflect.Array.newInstance
                    (a.getClass().getComponentType(), size);
            int k = 0;
for(Node<E> p = head.next;p != null;p = p.next)
            a[k++] = (T)p.item;
            if(a.length > k)            
            a[k] = null;
T[] var3F5343BF1D849954A73F0BB303805FFD_1520448393 =             a;
            var3F5343BF1D849954A73F0BB303805FFD_1520448393.addTaint(taint);
            return var3F5343BF1D849954A73F0BB303805FFD_1520448393;
        } //End block
        finally 
        {
            fullyUnlock();
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.587 -0400", hash_original_method = "74ADAA84A44AA4C99AF60EA5FA9916C8", hash_generated_method = "9684AF8ABEDE35C95A8DBC90B754465F")
    public String toString() {
        fullyLock();
        try 
        {
            Node<E> p = head.next;
            if(p == null)            
            {
String varAA6F5C51D397701D3E65BDD2DF6A0CE1_1739166552 =             "[]";
            varAA6F5C51D397701D3E65BDD2DF6A0CE1_1739166552.addTaint(taint);
            return varAA6F5C51D397701D3E65BDD2DF6A0CE1_1739166552;
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
String var9C07C753C7E9BC277E7521552478C668_598335495 =                 sb.append(']').toString();
                var9C07C753C7E9BC277E7521552478C668_598335495.addTaint(taint);
                return var9C07C753C7E9BC277E7521552478C668_598335495;
                }
                sb.append(',').append(' ');
            } //End block
        } //End block
        finally 
        {
            fullyUnlock();
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.588 -0400", hash_original_method = "2B97B8EA201FFE74530152ABDF41ED91", hash_generated_method = "2579CD725F5E3B0D02F69C687EF47762")
    public void clear() {
        fullyLock();
        try 
        {
for(Node<E> p, h = head;(p = h.next) != null;h = p)
            {
                h.next = h;
                p.item = null;
            } //End block
            head = last;
            if(count.getAndSet(0) == capacity)            
            notFull.signal();
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.588 -0400", hash_original_method = "848AB2101C925A7DB8B05331DC1D79E6", hash_generated_method = "898A76258C1133A39B100E8F4712B5CB")
    public int drainTo(Collection<? super E> c) {
        addTaint(c.getTaint());
        int var3828B170D96FB98999BED4414DDE0658_832181772 = (drainTo(c, Integer.MAX_VALUE));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_752576453 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_752576453;
        // ---------- Original Method ----------
        //return drainTo(c, Integer.MAX_VALUE);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.589 -0400", hash_original_method = "3B8D4B25C05B9AD02BEBED4DB8AC9EEC", hash_generated_method = "71D2310332018101FC1069FA20210D69")
    public int drainTo(Collection<? super E> c, int maxElements) {
        addTaint(maxElements);
        addTaint(c.getTaint());
        if(c == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_297123630 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_297123630.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_297123630;
        }
        if(c == this)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_126615116 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_126615116.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_126615116;
        }
        boolean signalNotFull = false;
        final ReentrantLock takeLock = this.takeLock;
        takeLock.lock();
        try 
        {
            int n = Math.min(maxElements, count.get());
            Node<E> h = head;
            int i = 0;
            try 
            {
                while
(i < n)                
                {
                    Node<E> p = h.next;
                    c.add(p.item);
                    p.item = null;
                    h.next = h;
                    h = p;
                    ++i;
                } //End block
                int var7B8B965AD4BCA0E41AB51DE7B31363A1_204334090 = (n);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2106660865 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2106660865;
            } //End block
            finally 
            {
                if(i > 0)                
                {
                    head = h;
                    signalNotFull = (count.getAndAdd(-i) == capacity);
                } //End block
            } //End block
        } //End block
        finally 
        {
            takeLock.unlock();
            if(signalNotFull)            
            signalNotFull();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.589 -0400", hash_original_method = "756A0449DBEE27B15290EF9912B6D98E", hash_generated_method = "94EC6335D99BE66FD20FE17602FFE65C")
    public Iterator<E> iterator() {
Iterator<E> varB10D928EC6DDAEBFD727C2EDCEC6EDF5_1840524097 =         new Itr();
        varB10D928EC6DDAEBFD727C2EDCEC6EDF5_1840524097.addTaint(taint);
        return varB10D928EC6DDAEBFD727C2EDCEC6EDF5_1840524097;
        // ---------- Original Method ----------
        //return new Itr();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.589 -0400", hash_original_method = "407E789BCFB8527B31EA0FCB2D45014F", hash_generated_method = "3FC85FCF0701BFD63D43A7F2EA01AB0D")
    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
        addTaint(s.getTaint());
        fullyLock();
        try 
        {
            s.defaultWriteObject();
for(Node<E> p = head.next;p != null;p = p.next)
            s.writeObject(p.item);
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.590 -0400", hash_original_method = "2A845E5CA6C44D2307376F014D4A5DD1", hash_generated_method = "A3E6A002B5F48C4FDF8D7D334C83F6BF")
    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
        addTaint(s.getTaint());
        s.defaultReadObject();
        count.set(0);
        last = head = new Node<E>(null);
for(;;)
        {
            @SuppressWarnings("unchecked") E item = (E)s.readObject();
            if(item == null)            
            break;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.590 -0400", hash_original_field = "447B7147E84BE512208DCC0995D67EBC", hash_generated_field = "25C1B4BE35B7528A52E74D8E56CE9F0B")

        E item;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.590 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "A089DAAEF049057EDB97CA1342EE38E4")

        Node<E> next;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.590 -0400", hash_original_method = "E24CFB813CF8D6D3545154C1747D57F8", hash_generated_method = "F143FACCEFEC2EC78FAE43B87B01534B")
          Node(E x) {
            item = x;
            // ---------- Original Method ----------
            //item = x;
        }

        
    }


    
    private class Itr implements Iterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.590 -0400", hash_original_field = "43B5C9175984C071F30B873FDCE0A000", hash_generated_field = "96ED1A7AC98C85D7CD0CAC3D4B53A034")

        private Node<E> current;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.590 -0400", hash_original_field = "BB3AE5C41B0FFE5CC0DAF60D4592524F", hash_generated_field = "9782A09877DFB4D434246B92A2C403C0")

        private Node<E> lastRet;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.590 -0400", hash_original_field = "72629BFF0AB58C6A7222BC4792DD9B5D", hash_generated_field = "09FAC7A7C45F476EE0F649D7F47824AF")

        private E currentElement;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.590 -0400", hash_original_method = "5363017965403D930144EB6431B1229A", hash_generated_method = "173E625799237D8F29CD5FD5A03F020E")
          Itr() {
            fullyLock();
            try 
            {
                current = head.next;
                if(current != null)                
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.591 -0400", hash_original_method = "930D47D628EF4F4226A6936FD0C40F3E", hash_generated_method = "AFDF19F42845D77047EA9FC8179B8588")
        public boolean hasNext() {
            boolean var97D04F0DD15D17F3CFE71371925A4C92_1985880180 = (current != null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1861250905 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1861250905;
            // ---------- Original Method ----------
            //return current != null;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.591 -0400", hash_original_method = "4F1204B9DEA81FB44DF832DBC08BD27C", hash_generated_method = "CADC8B68EF823325A3C6EE16ECA1A987")
        private Node<E> nextNode(Node<E> p) {
            addTaint(p.getTaint());
for(;;)
            {
                Node<E> s = p.next;
                if(s == p)                
                {
Node<E> var39B7F799C65BAEAC2ED5979661FC6E84_529808893 =                 head.next;
                var39B7F799C65BAEAC2ED5979661FC6E84_529808893.addTaint(taint);
                return var39B7F799C65BAEAC2ED5979661FC6E84_529808893;
                }
                if(s == null || s.item != null)                
                {
Node<E> var0478718F0636FB61899C13801CE9FE09_1438655342 =                 s;
                var0478718F0636FB61899C13801CE9FE09_1438655342.addTaint(taint);
                return var0478718F0636FB61899C13801CE9FE09_1438655342;
                }
                p = s;
            } //End block
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.592 -0400", hash_original_method = "B1551F09E1CC1CE37F95082545A7F15D", hash_generated_method = "1DABA7CD7FEDDC84D3C370B5CB91F05A")
        public E next() {
            fullyLock();
            try 
            {
                if(current == null)                
                {
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_607510721 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_607510721.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_607510721;
                }
                E x = currentElement;
                lastRet = current;
                current = nextNode(current);
                currentElement = (current == null) ? null : current.item;
E varEA5659DA512DECF23E6D37EE8060D074_2112758168 =                 x;
                varEA5659DA512DECF23E6D37EE8060D074_2112758168.addTaint(taint);
                return varEA5659DA512DECF23E6D37EE8060D074_2112758168;
            } //End block
            finally 
            {
                fullyUnlock();
            } //End block
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.593 -0400", hash_original_method = "9DBE3C9C0D54D1E1956F6E76D38BE63A", hash_generated_method = "A9069276B91C51B6871CD1F97228123C")
        public void remove() {
            if(lastRet == null)            
            {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_71148274 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_71148274.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_71148274;
            }
            fullyLock();
            try 
            {
                Node<E> node = lastRet;
                lastRet = null;
for(Node<E> trail = head, p = trail.next;p != null;trail = p,p = p.next)
                {
                    if(p == node)                    
                    {
                        unlink(p, trail);
                        break;
                    } //End block
                } //End block
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.594 -0400", hash_original_field = "4579BD0787ACC5EBD7BBE120D66D1B32", hash_generated_field = "900FED93BFD035CADEBF9B3700EB152D")

    private static final long serialVersionUID = -6903933977591709194L;
}

