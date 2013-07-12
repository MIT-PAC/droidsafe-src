package java.util.concurrent;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.086 -0400", hash_original_field = "7BD14A231864E618E1840C7E117E59C1", hash_generated_field = "277B4266A058D752E724058E1F215618")

    private int capacity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.087 -0400", hash_original_field = "E15431B372E31BBE6073FBB6C5E792BB", hash_generated_field = "BBA980D7D7B7F08CF4B42F041B343B13")

    private final AtomicInteger count = new AtomicInteger(0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.087 -0400", hash_original_field = "96E89A298E0A9F469B9AE458D6AFAE9F", hash_generated_field = "48C6F3CDEAC5EAEAC23BFB1092B4D3A3")

    private transient Node<E> head;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.087 -0400", hash_original_field = "98BD1C45684CF587AC2347A92DD7BB51", hash_generated_field = "9882BA72234087D024BDEB5C6D765CDA")

    private transient Node<E> last;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.087 -0400", hash_original_field = "5322750CBC5FB7E2B3FB560931054E46", hash_generated_field = "2489B27DF1A4E990956C48CE97BB7781")

    private final ReentrantLock takeLock = new ReentrantLock();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.087 -0400", hash_original_field = "CEF6C451AADF04E0C65480DEFEC861F2", hash_generated_field = "A3C160CB8F7274E37EB4990919FC4F81")

    private final Condition notEmpty = takeLock.newCondition();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.087 -0400", hash_original_field = "286E62C1C5B79371FA322708D11C41C5", hash_generated_field = "9E4EEFB3EF021ED502CF0754B96D9D32")

    private final ReentrantLock putLock = new ReentrantLock();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.087 -0400", hash_original_field = "FA225E5A4B225155E82C7ABA1BEF10B6", hash_generated_field = "22DCE80F4D8874940E856E975444C863")

    private final Condition notFull = putLock.newCondition();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.087 -0400", hash_original_method = "632CB0CBBBC44DF00B6EA380FB3D1564", hash_generated_method = "7E050AD6D76868049EBE527D41ED6759")
    public  LinkedBlockingQueue() {
        this(Integer.MAX_VALUE);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.088 -0400", hash_original_method = "B75314FE98F585143D624DCD24C1F5B2", hash_generated_method = "5B347333FA903F80A1D4D44039985A40")
    public  LinkedBlockingQueue(int capacity) {
    if(capacity <= 0)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1242992397 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_1242992397.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_1242992397;
        }
        this.capacity = capacity;
        last = head = new Node<E>(null);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.089 -0400", hash_original_method = "76A1733AA4693E67903F6C627D09C67F", hash_generated_method = "628BDED7E17A7B74D5FA5A92FC26A700")
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
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_259084470 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_259084470.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_259084470;
                }
    if(n == capacity)                
                {
                IllegalStateException varA33CF04882B88437ABCEE84817862B41_546043702 = new IllegalStateException("Queue full");
                varA33CF04882B88437ABCEE84817862B41_546043702.addTaint(taint);
                throw varA33CF04882B88437ABCEE84817862B41_546043702;
                }
                enqueue(new Node<E>(e));
                ++n;
            } 
            count.set(n);
        } 
        finally 
        {
            putLock.unlock();
        } 
        
        
        
        
            
            
                
                    
                
                    
                
                
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.089 -0400", hash_original_method = "15D22B562F85AEAC3F4AC4996FFD23A3", hash_generated_method = "C88CC2A92019BFE63FC44817948B087E")
    private void signalNotEmpty() {
        final ReentrantLock takeLock = this.takeLock;
        takeLock.lock();
        try 
        {
            notEmpty.signal();
        } 
        finally 
        {
            takeLock.unlock();
        } 
        
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.090 -0400", hash_original_method = "23256B84FD63DB25D1FF9FA99CF29C9A", hash_generated_method = "72C992F6506997D32138FF21DE2D90EF")
    private void signalNotFull() {
        final ReentrantLock putLock = this.putLock;
        putLock.lock();
        try 
        {
            notFull.signal();
        } 
        finally 
        {
            putLock.unlock();
        } 
        
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.090 -0400", hash_original_method = "050BE5B4C52573633224C87BCCA985D9", hash_generated_method = "1294900CE5F97C64F9A5E140C9BF1299")
    private void enqueue(Node<E> node) {
        last = last.next = node;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.091 -0400", hash_original_method = "0F3CD055205E18F01917D382EBA2EDD8", hash_generated_method = "6509C2912E877C42BE06E6EEF54FFFF5")
    private E dequeue() {
        Node<E> h = head;
        Node<E> first = h.next;
        h.next = h;
        head = first;
        E x = first.item;
        first.item = null;
E varEA5659DA512DECF23E6D37EE8060D074_899084514 =         x;
        varEA5659DA512DECF23E6D37EE8060D074_899084514.addTaint(taint);
        return varEA5659DA512DECF23E6D37EE8060D074_899084514;
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.091 -0400", hash_original_method = "8626572E0FE15707F18ECC5A9712CA34", hash_generated_method = "3646A04C6AE367BA0A6AA42D1CCE1C16")
     void fullyLock() {
        putLock.lock();
        takeLock.lock();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.091 -0400", hash_original_method = "5557FE5692936575245483F7CDC5CE2B", hash_generated_method = "DB6AEC1BC900D9A1E58F0AE1939A9554")
     void fullyUnlock() {
        takeLock.unlock();
        putLock.unlock();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.091 -0400", hash_original_method = "FC3CFC9E56AD635CFF4ED177A60462DA", hash_generated_method = "C7EA02A46EC74F4935771B2FF852AEF5")
    public int size() {
        int varF07AF9B5EBE1BDA12C06190B44E1F695_564188709 = (count.get());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1138107082 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1138107082;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.092 -0400", hash_original_method = "F6FFB0DBE2C073472862E76EB78E2D9E", hash_generated_method = "AC4D89C7277413D54827388C0ACC3AE5")
    public int remainingCapacity() {
        int var3C1171412FC071707DFA3A3D59A03AD0_1663170439 = (capacity - count.get());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_710265063 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_710265063;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.092 -0400", hash_original_method = "37DF2D00E21001E825743AC7943B033F", hash_generated_method = "7528C9F52C8EFDFFB943B503B336C896")
    public void put(E e) throws InterruptedException {
        addTaint(e.getTaint());
    if(e == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_96945600 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_96945600.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_96945600;
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
            } 
            enqueue(node);
            c = count.getAndIncrement();
    if(c + 1 < capacity)            
            notFull.signal();
        } 
        finally 
        {
            putLock.unlock();
        } 
    if(c == 0)        
        signalNotEmpty();
        
        
        
        
        
        
        
        
            
                
            
            
            
            
                
        
            
        
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.093 -0400", hash_original_method = "D5F3AC00421DA10DEFBB832E0EC3BAC8", hash_generated_method = "EFE61CBC8D5F21263844E01E805AC1FF")
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        addTaint(unit.getTaint());
        addTaint(timeout);
        addTaint(e.getTaint());
    if(e == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_600605132 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_600605132.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_600605132;
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
                boolean var68934A3E9455FA72420237EB05902327_966376208 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_753548151 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_753548151;
                }
                nanos = notFull.awaitNanos(nanos);
            } 
            enqueue(new Node<E>(e));
            c = count.getAndIncrement();
    if(c + 1 < capacity)            
            notFull.signal();
        } 
        finally 
        {
            putLock.unlock();
        } 
    if(c == 0)        
        signalNotEmpty();
        boolean varB326B5062B2F0E69046810717534CB09_5488510 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1358640120 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1358640120;
        
        
        
        
        
        
        
        
            
                
                    
                
            
            
            
            
                
        
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.094 -0400", hash_original_method = "751C55DFDD2504B6D9AAA83EF3048DDA", hash_generated_method = "CFFA4EF437B18BE61091197BCAB29E22")
    public boolean offer(E e) {
        addTaint(e.getTaint());
    if(e == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1023941556 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1023941556.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1023941556;
        }
        final AtomicInteger count = this.count;
    if(count.get() == capacity)        
        {
        boolean var68934A3E9455FA72420237EB05902327_811358463 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2139882053 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2139882053;
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
            } 
        } 
        finally 
        {
            putLock.unlock();
        } 
    if(c == 0)        
        signalNotEmpty();
        boolean var6EBA6DF55A2DFD6D58CC892FE0ED47AD_1774016166 = (c >= 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1192899545 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1192899545;
        
        
        
        
            
        
        
        
        
        
            
                
                
                
                    
            
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.095 -0400", hash_original_method = "022306A077B45DC674F98467F25F93CD", hash_generated_method = "0D8B55611074D550C570D4DB4AB88BFC")
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
            } 
            x = dequeue();
            c = count.getAndDecrement();
    if(c > 1)            
            notEmpty.signal();
        } 
        finally 
        {
            takeLock.unlock();
        } 
    if(c == capacity)        
        signalNotFull();
E varEA5659DA512DECF23E6D37EE8060D074_1243331420 =         x;
        varEA5659DA512DECF23E6D37EE8060D074_1243331420.addTaint(taint);
        return varEA5659DA512DECF23E6D37EE8060D074_1243331420;
        
        
        
        
        
        
        
            
                
            
            
            
            
                
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.096 -0400", hash_original_method = "AA8094BF5AEC46D297071331A526D258", hash_generated_method = "A05100EBE43044EC2412FABB33010E5C")
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
E var540C13E9E156B687226421B24F2DF178_499703755 =                 null;
                var540C13E9E156B687226421B24F2DF178_499703755.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_499703755;
                }
                nanos = notEmpty.awaitNanos(nanos);
            } 
            x = dequeue();
            c = count.getAndDecrement();
    if(c > 1)            
            notEmpty.signal();
        } 
        finally 
        {
            takeLock.unlock();
        } 
    if(c == capacity)        
        signalNotFull();
E varEA5659DA512DECF23E6D37EE8060D074_800526200 =         x;
        varEA5659DA512DECF23E6D37EE8060D074_800526200.addTaint(taint);
        return varEA5659DA512DECF23E6D37EE8060D074_800526200;
        
        
        
        
        
        
        
        
            
                
                    
                
            
            
            
            
                
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.097 -0400", hash_original_method = "D22B106AF12DCACC53C408D22FAEA025", hash_generated_method = "B1B813049B49A64C8696FB2C86CF5C38")
    public E poll() {
        final AtomicInteger count = this.count;
    if(count.get() == 0)        
        {
E var540C13E9E156B687226421B24F2DF178_155349774 =         null;
        var540C13E9E156B687226421B24F2DF178_155349774.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_155349774;
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
            } 
        } 
        finally 
        {
            takeLock.unlock();
        } 
    if(c == capacity)        
        signalNotFull();
E varEA5659DA512DECF23E6D37EE8060D074_338865570 =         x;
        varEA5659DA512DECF23E6D37EE8060D074_338865570.addTaint(taint);
        return varEA5659DA512DECF23E6D37EE8060D074_338865570;
        
        
        
            
        
        
        
        
        
            
                
                
                
                    
            
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.097 -0400", hash_original_method = "6BD887DAC1ACD373E1861DD85FA5D83B", hash_generated_method = "8F12978D611BE6A567FF4A216ED63296")
    public E peek() {
    if(count.get() == 0)        
        {
E var540C13E9E156B687226421B24F2DF178_367223035 =         null;
        var540C13E9E156B687226421B24F2DF178_367223035.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_367223035;
        }
        final ReentrantLock takeLock = this.takeLock;
        takeLock.lock();
        try 
        {
            Node<E> first = head.next;
    if(first == null)            
            {
E var540C13E9E156B687226421B24F2DF178_1412283414 =             null;
            var540C13E9E156B687226421B24F2DF178_1412283414.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1412283414;
            }
            else
            {
E var30B383EF1E5A298C086E51BB7B7C5921_1084538550 =             first.item;
            var30B383EF1E5A298C086E51BB7B7C5921_1084538550.addTaint(taint);
            return var30B383EF1E5A298C086E51BB7B7C5921_1084538550;
            }
        } 
        finally 
        {
            takeLock.unlock();
        } 
        
        
            
        
        
        
            
            
                
            
                
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.098 -0400", hash_original_method = "354B8979A292DF58D8ACD150BF598C2B", hash_generated_method = "22D67B5BF57C5A5189D49DEFF4070BEC")
     void unlink(Node<E> p, Node<E> trail) {
        addTaint(p.getTaint());
        p.item = null;
        trail.next = p.next;
    if(last == p)        
        last = trail;
    if(count.getAndDecrement() == capacity)        
        notFull.signal();
        
        
        
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.099 -0400", hash_original_method = "43DA2AA0857729B72806FF0ABDC45219", hash_generated_method = "AF9C551BD52AA17369D231186AFCA796")
    public boolean remove(Object o) {
        addTaint(o.getTaint());
    if(o == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1900721726 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_410360148 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_410360148;
        }
        fullyLock();
        try 
        {
for(Node<E> trail = head, p = trail.next;p != null;trail = p,p = p.next)
            {
    if(o.equals(p.item))                
                {
                    unlink(p, trail);
                    boolean varB326B5062B2F0E69046810717534CB09_231912406 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_443621637 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_443621637;
                } 
            } 
            boolean var68934A3E9455FA72420237EB05902327_1396411989 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_63831662 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_63831662;
        } 
        finally 
        {
            fullyUnlock();
        } 
        
        
        
        
            
                 
                 
                
                    
                    
                
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.100 -0400", hash_original_method = "A4E3D89F8C47A7118ADD1757BF8D3A46", hash_generated_method = "C6907FBD5F332A70552046A7F86B1865")
    public boolean contains(Object o) {
        addTaint(o.getTaint());
    if(o == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1082760925 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_864504190 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_864504190;
        }
        fullyLock();
        try 
        {
for(Node<E> p = head.next;p != null;p = p.next)
    if(o.equals(p.item))            
            {
            boolean varB326B5062B2F0E69046810717534CB09_2029550168 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1838967566 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1838967566;
            }
            boolean var68934A3E9455FA72420237EB05902327_565207444 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_655113324 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_655113324;
        } 
        finally 
        {
            fullyUnlock();
        } 
        
        
        
        
            
                
                    
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.101 -0400", hash_original_method = "A06A302045E6771EA320A7223F86E4E8", hash_generated_method = "095BB8E063A0970787CEF9A1283A4C12")
    public Object[] toArray() {
        fullyLock();
        try 
        {
            int size = count.get();
            Object[] a = new Object[size];
            int k = 0;
for(Node<E> p = head.next;p != null;p = p.next)
            a[k++] = p.item;
Object[] var3F5343BF1D849954A73F0BB303805FFD_332685010 =             a;
            var3F5343BF1D849954A73F0BB303805FFD_332685010.addTaint(taint);
            return var3F5343BF1D849954A73F0BB303805FFD_332685010;
        } 
        finally 
        {
            fullyUnlock();
        } 
        
        
        
            
            
            
            
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.102 -0400", hash_original_method = "3C0973EC18B4AB6267920EDC87F075C5", hash_generated_method = "FCF8BFA271B0C2797D65911737BC8C49")
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
T[] var3F5343BF1D849954A73F0BB303805FFD_1439153755 =             a;
            var3F5343BF1D849954A73F0BB303805FFD_1439153755.addTaint(taint);
            return var3F5343BF1D849954A73F0BB303805FFD_1439153755;
        } 
        finally 
        {
            fullyUnlock();
        } 
        
        
        
            
            
                
                    
            
            
                
            
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.102 -0400", hash_original_method = "74ADAA84A44AA4C99AF60EA5FA9916C8", hash_generated_method = "710DFC9267982D1481F721B21163BA21")
    public String toString() {
        fullyLock();
        try 
        {
            Node<E> p = head.next;
    if(p == null)            
            {
String varAA6F5C51D397701D3E65BDD2DF6A0CE1_1821382335 =             "[]";
            varAA6F5C51D397701D3E65BDD2DF6A0CE1_1821382335.addTaint(taint);
            return varAA6F5C51D397701D3E65BDD2DF6A0CE1_1821382335;
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
String var9C07C753C7E9BC277E7521552478C668_1606931693 =                 sb.append(']').toString();
                var9C07C753C7E9BC277E7521552478C668_1606931693.addTaint(taint);
                return var9C07C753C7E9BC277E7521552478C668_1606931693;
                }
                sb.append(',').append(' ');
            } 
        } 
        finally 
        {
            fullyUnlock();
        } 
        
        
        
            
            
                
            
            
            
                
                
                
                
                    
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.103 -0400", hash_original_method = "2B97B8EA201FFE74530152ABDF41ED91", hash_generated_method = "2579CD725F5E3B0D02F69C687EF47762")
    public void clear() {
        fullyLock();
        try 
        {
for(Node<E> p, h = head;(p = h.next) != null;h = p)
            {
                h.next = h;
                p.item = null;
            } 
            head = last;
    if(count.getAndSet(0) == capacity)            
            notFull.signal();
        } 
        finally 
        {
            fullyUnlock();
        } 
        
        
        
            
                
                
            
            
            
                
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.104 -0400", hash_original_method = "848AB2101C925A7DB8B05331DC1D79E6", hash_generated_method = "7294C098DAB4E8804A02B5FA06D37F43")
    public int drainTo(Collection<? super E> c) {
        addTaint(c.getTaint());
        int var3828B170D96FB98999BED4414DDE0658_1016575615 = (drainTo(c, Integer.MAX_VALUE));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1331996135 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1331996135;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.105 -0400", hash_original_method = "3B8D4B25C05B9AD02BEBED4DB8AC9EEC", hash_generated_method = "B0695B9DC6CADF434C83C37E96C07C5D")
    public int drainTo(Collection<? super E> c, int maxElements) {
        addTaint(maxElements);
        addTaint(c.getTaint());
    if(c == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_656815291 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_656815291.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_656815291;
        }
    if(c == this)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_305248449 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_305248449.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_305248449;
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
                } 
                int var7B8B965AD4BCA0E41AB51DE7B31363A1_242415029 = (n);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1688225390 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1688225390;
            } 
            finally 
            {
    if(i > 0)                
                {
                    head = h;
                    signalNotFull = (count.getAndAdd(-i) == capacity);
                } 
            } 
        } 
        finally 
        {
            takeLock.unlock();
    if(signalNotFull)            
            signalNotFull();
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.105 -0400", hash_original_method = "756A0449DBEE27B15290EF9912B6D98E", hash_generated_method = "F2DE7E5068517F3F3476E646BCF41D27")
    public Iterator<E> iterator() {
Iterator<E> varB10D928EC6DDAEBFD727C2EDCEC6EDF5_1543783174 =         new Itr();
        varB10D928EC6DDAEBFD727C2EDCEC6EDF5_1543783174.addTaint(taint);
        return varB10D928EC6DDAEBFD727C2EDCEC6EDF5_1543783174;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.106 -0400", hash_original_method = "407E789BCFB8527B31EA0FCB2D45014F", hash_generated_method = "3FC85FCF0701BFD63D43A7F2EA01AB0D")
    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
        addTaint(s.getTaint());
        fullyLock();
        try 
        {
            s.defaultWriteObject();
for(Node<E> p = head.next;p != null;p = p.next)
            s.writeObject(p.item);
            s.writeObject(null);
        } 
        finally 
        {
            fullyUnlock();
        } 
        
        
        
            
            
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.106 -0400", hash_original_method = "2A845E5CA6C44D2307376F014D4A5DD1", hash_generated_method = "A3E6A002B5F48C4FDF8D7D334C83F6BF")
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
        } 
        
        
        
        
        
            
            
            
                
            
        
    }

    
    static class Node<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.107 -0400", hash_original_field = "447B7147E84BE512208DCC0995D67EBC", hash_generated_field = "25C1B4BE35B7528A52E74D8E56CE9F0B")

        E item;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.107 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "A089DAAEF049057EDB97CA1342EE38E4")

        Node<E> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.107 -0400", hash_original_method = "E24CFB813CF8D6D3545154C1747D57F8", hash_generated_method = "F143FACCEFEC2EC78FAE43B87B01534B")
          Node(E x) {
            item = x;
            
            
        }

        
    }


    
    private class Itr implements Iterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.107 -0400", hash_original_field = "43B5C9175984C071F30B873FDCE0A000", hash_generated_field = "96ED1A7AC98C85D7CD0CAC3D4B53A034")

        private Node<E> current;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.108 -0400", hash_original_field = "BB3AE5C41B0FFE5CC0DAF60D4592524F", hash_generated_field = "9782A09877DFB4D434246B92A2C403C0")

        private Node<E> lastRet;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.108 -0400", hash_original_field = "72629BFF0AB58C6A7222BC4792DD9B5D", hash_generated_field = "09FAC7A7C45F476EE0F649D7F47824AF")

        private E currentElement;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.108 -0400", hash_original_method = "5363017965403D930144EB6431B1229A", hash_generated_method = "173E625799237D8F29CD5FD5A03F020E")
          Itr() {
            fullyLock();
            try 
            {
                current = head.next;
    if(current != null)                
                currentElement = current.item;
            } 
            finally 
            {
                fullyUnlock();
            } 
            
            
            
                
                
                    
            
                
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.108 -0400", hash_original_method = "930D47D628EF4F4226A6936FD0C40F3E", hash_generated_method = "C2DB4269EC3C8157422A50E5C75B51AA")
        public boolean hasNext() {
            boolean var97D04F0DD15D17F3CFE71371925A4C92_1139515096 = (current != null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1043425146 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1043425146;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.109 -0400", hash_original_method = "4F1204B9DEA81FB44DF832DBC08BD27C", hash_generated_method = "B9A1A8463E80CA284E1BBE5D41E73746")
        private Node<E> nextNode(Node<E> p) {
            addTaint(p.getTaint());
for(;;)
            {
                Node<E> s = p.next;
    if(s == p)                
                {
Node<E> var39B7F799C65BAEAC2ED5979661FC6E84_521014082 =                 head.next;
                var39B7F799C65BAEAC2ED5979661FC6E84_521014082.addTaint(taint);
                return var39B7F799C65BAEAC2ED5979661FC6E84_521014082;
                }
    if(s == null || s.item != null)                
                {
Node<E> var0478718F0636FB61899C13801CE9FE09_87483396 =                 s;
                var0478718F0636FB61899C13801CE9FE09_87483396.addTaint(taint);
                return var0478718F0636FB61899C13801CE9FE09_87483396;
                }
                p = s;
            } 
            
            
                
                
                    
                
                    
                
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.110 -0400", hash_original_method = "B1551F09E1CC1CE37F95082545A7F15D", hash_generated_method = "6862ED38DA8964035EE37FD2D699345B")
        public E next() {
            fullyLock();
            try 
            {
    if(current == null)                
                {
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_1617587166 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_1617587166.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_1617587166;
                }
                E x = currentElement;
                lastRet = current;
                current = nextNode(current);
                currentElement = (current == null) ? null : current.item;
E varEA5659DA512DECF23E6D37EE8060D074_922981628 =                 x;
                varEA5659DA512DECF23E6D37EE8060D074_922981628.addTaint(taint);
                return varEA5659DA512DECF23E6D37EE8060D074_922981628;
            } 
            finally 
            {
                fullyUnlock();
            } 
            
            
            
                
                    
                
                
                
                
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.110 -0400", hash_original_method = "9DBE3C9C0D54D1E1956F6E76D38BE63A", hash_generated_method = "BDF383EFDEE35CF1927D950EB878B14D")
        public void remove() {
    if(lastRet == null)            
            {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_567556421 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_567556421.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_567556421;
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
                    } 
                } 
            } 
            finally 
            {
                fullyUnlock();
            } 
            
            
                
            
            
                
                
                
                     
                     
                    
                        
                        
                    
                
            
                
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.114 -0400", hash_original_field = "4579BD0787ACC5EBD7BBE120D66D1B32", hash_generated_field = "900FED93BFD035CADEBF9B3700EB152D")

    private static final long serialVersionUID = -6903933977591709194L;
}

