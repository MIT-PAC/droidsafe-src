package java.util.concurrent;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedBlockingQueue<E> extends AbstractQueue<E> implements BlockingQueue<E>, java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.587 -0400", hash_original_field = "7BD14A231864E618E1840C7E117E59C1", hash_generated_field = "277B4266A058D752E724058E1F215618")

    private int capacity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.587 -0400", hash_original_field = "E15431B372E31BBE6073FBB6C5E792BB", hash_generated_field = "BBA980D7D7B7F08CF4B42F041B343B13")

    private final AtomicInteger count = new AtomicInteger(0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.587 -0400", hash_original_field = "96E89A298E0A9F469B9AE458D6AFAE9F", hash_generated_field = "48C6F3CDEAC5EAEAC23BFB1092B4D3A3")

    private transient Node<E> head;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.587 -0400", hash_original_field = "98BD1C45684CF587AC2347A92DD7BB51", hash_generated_field = "9882BA72234087D024BDEB5C6D765CDA")

    private transient Node<E> last;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.587 -0400", hash_original_field = "5322750CBC5FB7E2B3FB560931054E46", hash_generated_field = "2489B27DF1A4E990956C48CE97BB7781")

    private final ReentrantLock takeLock = new ReentrantLock();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.587 -0400", hash_original_field = "CEF6C451AADF04E0C65480DEFEC861F2", hash_generated_field = "A3C160CB8F7274E37EB4990919FC4F81")

    private final Condition notEmpty = takeLock.newCondition();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.587 -0400", hash_original_field = "286E62C1C5B79371FA322708D11C41C5", hash_generated_field = "9E4EEFB3EF021ED502CF0754B96D9D32")

    private final ReentrantLock putLock = new ReentrantLock();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.587 -0400", hash_original_field = "FA225E5A4B225155E82C7ABA1BEF10B6", hash_generated_field = "22DCE80F4D8874940E856E975444C863")

    private final Condition notFull = putLock.newCondition();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.588 -0400", hash_original_method = "632CB0CBBBC44DF00B6EA380FB3D1564", hash_generated_method = "7E050AD6D76868049EBE527D41ED6759")
    public  LinkedBlockingQueue() {
        this(Integer.MAX_VALUE);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.588 -0400", hash_original_method = "B75314FE98F585143D624DCD24C1F5B2", hash_generated_method = "05708A5EE54B0DB4CAE63635F386D894")
    public  LinkedBlockingQueue(int capacity) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        this.capacity = capacity;
        last = head = new Node<E>(null);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.591 -0400", hash_original_method = "76A1733AA4693E67903F6C627D09C67F", hash_generated_method = "FAC76D986A4B25A46F01CD2568273C99")
    public  LinkedBlockingQueue(Collection<? extends E> c) {
        this(Integer.MAX_VALUE);
        final ReentrantLock putLock = this.putLock;
        putLock.lock();
        try 
        {
            int n = 0;
            {
                Iterator<? extends E> var334ED49EB23041C8D120547C1BB713D2_111169439 = (c).iterator();
                var334ED49EB23041C8D120547C1BB713D2_111169439.hasNext();
                E e = var334ED49EB23041C8D120547C1BB713D2_111169439.next();
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Queue full");
                    enqueue(new Node<E>(e));
                } 
            } 
            count.set(n);
        } 
        finally 
        {
            putLock.unlock();
        } 
        addTaint(c.getTaint());
        
        
        
        
            
            
                
                    
                
                    
                
                
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.591 -0400", hash_original_method = "15D22B562F85AEAC3F4AC4996FFD23A3", hash_generated_method = "C88CC2A92019BFE63FC44817948B087E")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.592 -0400", hash_original_method = "23256B84FD63DB25D1FF9FA99CF29C9A", hash_generated_method = "72C992F6506997D32138FF21DE2D90EF")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.592 -0400", hash_original_method = "050BE5B4C52573633224C87BCCA985D9", hash_generated_method = "1294900CE5F97C64F9A5E140C9BF1299")
    private void enqueue(Node<E> node) {
        last = last.next = node;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.593 -0400", hash_original_method = "0F3CD055205E18F01917D382EBA2EDD8", hash_generated_method = "D98F9075CFA29C47F57EE147448070CF")
    private E dequeue() {
        E varB4EAC82CA7396A68D541C85D26508E83_604321655 = null; 
        Node<E> h = head;
        Node<E> first = h.next;
        h.next = h;
        head = first;
        E x = first.item;
        first.item = null;
        varB4EAC82CA7396A68D541C85D26508E83_604321655 = x;
        varB4EAC82CA7396A68D541C85D26508E83_604321655.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_604321655;
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.593 -0400", hash_original_method = "8626572E0FE15707F18ECC5A9712CA34", hash_generated_method = "3646A04C6AE367BA0A6AA42D1CCE1C16")
     void fullyLock() {
        putLock.lock();
        takeLock.lock();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.593 -0400", hash_original_method = "5557FE5692936575245483F7CDC5CE2B", hash_generated_method = "DB6AEC1BC900D9A1E58F0AE1939A9554")
     void fullyUnlock() {
        takeLock.unlock();
        putLock.unlock();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.593 -0400", hash_original_method = "FC3CFC9E56AD635CFF4ED177A60462DA", hash_generated_method = "66BC05F58B38CC972E03EB2CB590A57F")
    public int size() {
        int var9D4B6D8BE09F232CC6DFC96E7C27D965_252282189 = (count.get());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_559729488 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_559729488;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.594 -0400", hash_original_method = "F6FFB0DBE2C073472862E76EB78E2D9E", hash_generated_method = "546ACBD9770409D8FE7B7657F08FC152")
    public int remainingCapacity() {
        int var1DA51DA4294BA3DCCB36CDBA725495A8_1737285283 = (capacity - count.get());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_666496945 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_666496945;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.594 -0400", hash_original_method = "37DF2D00E21001E825743AC7943B033F", hash_generated_method = "AC3EB921E25D77ECE56704CEB207564F")
    public void put(E e) throws InterruptedException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        int c = -1;
        Node<E> node = new Node(e);
        final ReentrantLock putLock = this.putLock;
        final AtomicInteger count = this.count;
        putLock.lockInterruptibly();
        try 
        {
            {
                boolean var948F57AE74E06F0875AD4FB7B59A7541_246808981 = (count.get() == capacity);
                {
                    notFull.await();
                } 
            } 
            enqueue(node);
            c = count.getAndIncrement();
            notFull.signal();
        } 
        finally 
        {
            putLock.unlock();
        } 
        signalNotEmpty();
        addTaint(e.getTaint());
        
        
        
        
        
        
        
        
            
                
            
            
            
            
                
        
            
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.595 -0400", hash_original_method = "D5F3AC00421DA10DEFBB832E0EC3BAC8", hash_generated_method = "EA109D358CB921C343AEF4B1DB460E3D")
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        long nanos = unit.toNanos(timeout);
        int c = -1;
        final ReentrantLock putLock = this.putLock;
        final AtomicInteger count = this.count;
        putLock.lockInterruptibly();
        try 
        {
            {
                boolean var948F57AE74E06F0875AD4FB7B59A7541_755250943 = (count.get() == capacity);
                {
                    nanos = notFull.awaitNanos(nanos);
                } 
            } 
            enqueue(new Node<E>(e));
            c = count.getAndIncrement();
            notFull.signal();
        } 
        finally 
        {
            putLock.unlock();
        } 
        signalNotEmpty();
        addTaint(e.getTaint());
        addTaint(timeout);
        addTaint(unit.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1576253744 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1576253744;
        
        
        
        
        
        
        
        
            
                
                    
                
            
            
            
            
                
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.595 -0400", hash_original_method = "751C55DFDD2504B6D9AAA83EF3048DDA", hash_generated_method = "70DDB0E39D334B4A3388946FC0BD2B3E")
    public boolean offer(E e) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        final AtomicInteger count = this.count;
        {
            boolean var02EF388EE672A52C47389F83DEF5E6E1_2069781202 = (count.get() == capacity);
        } 
        int c = -1;
        Node<E> node = new Node(e);
        final ReentrantLock putLock = this.putLock;
        putLock.lock();
        try 
        {
            {
                boolean var75CFCFA13C6DD354C40B5B06E074720E_1658487126 = (count.get() < capacity);
                {
                    enqueue(node);
                    c = count.getAndIncrement();
                    notFull.signal();
                } 
            } 
        } 
        finally 
        {
            putLock.unlock();
        } 
        signalNotEmpty();
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_456556773 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_456556773;
        
        
        
        
            
        
        
        
        
        
            
                
                
                
                    
            
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.596 -0400", hash_original_method = "022306A077B45DC674F98467F25F93CD", hash_generated_method = "A2F3E76891E2A6A0C4D7A54DC334246F")
    public E take() throws InterruptedException {
        E varB4EAC82CA7396A68D541C85D26508E83_2146393258 = null; 
        E x;
        int c = -1;
        final AtomicInteger count = this.count;
        final ReentrantLock takeLock = this.takeLock;
        takeLock.lockInterruptibly();
        try 
        {
            {
                boolean varC5243B16B9F11FD69A1317C582A7E86C_786606617 = (count.get() == 0);
                {
                    notEmpty.await();
                } 
            } 
            x = dequeue();
            c = count.getAndDecrement();
            notEmpty.signal();
        } 
        finally 
        {
            takeLock.unlock();
        } 
        signalNotFull();
        varB4EAC82CA7396A68D541C85D26508E83_2146393258 = x;
        varB4EAC82CA7396A68D541C85D26508E83_2146393258.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2146393258;
        
        
        
        
        
        
        
            
                
            
            
            
            
                
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.598 -0400", hash_original_method = "AA8094BF5AEC46D297071331A526D258", hash_generated_method = "75EF87CD2069ACC16686CCF037549B48")
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        E varB4EAC82CA7396A68D541C85D26508E83_1557062730 = null; 
        E varB4EAC82CA7396A68D541C85D26508E83_1051099572 = null; 
        E x = null;
        int c = -1;
        long nanos = unit.toNanos(timeout);
        final AtomicInteger count = this.count;
        final ReentrantLock takeLock = this.takeLock;
        takeLock.lockInterruptibly();
        try 
        {
            {
                boolean varC5243B16B9F11FD69A1317C582A7E86C_1443771745 = (count.get() == 0);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1557062730 = null;
                    nanos = notEmpty.awaitNanos(nanos);
                } 
            } 
            x = dequeue();
            c = count.getAndDecrement();
            notEmpty.signal();
        } 
        finally 
        {
            takeLock.unlock();
        } 
        signalNotFull();
        varB4EAC82CA7396A68D541C85D26508E83_1051099572 = x;
        addTaint(timeout);
        addTaint(unit.getTaint());
        E varA7E53CE21691AB073D9660D615818899_1904125108; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1904125108 = varB4EAC82CA7396A68D541C85D26508E83_1557062730;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1904125108 = varB4EAC82CA7396A68D541C85D26508E83_1051099572;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1904125108.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1904125108;
        
        
        
        
        
        
        
        
            
                
                    
                
            
            
            
            
                
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.599 -0400", hash_original_method = "D22B106AF12DCACC53C408D22FAEA025", hash_generated_method = "65D08B10AE83CA5BBBD6EFF46781ED0C")
    public E poll() {
        E varB4EAC82CA7396A68D541C85D26508E83_1559221965 = null; 
        E varB4EAC82CA7396A68D541C85D26508E83_1656510182 = null; 
        final AtomicInteger count = this.count;
        {
            boolean varEE4074E3A1B29EE612CF7959D3B3BF7F_1815716874 = (count.get() == 0);
            varB4EAC82CA7396A68D541C85D26508E83_1559221965 = null;
        } 
        E x = null;
        int c = -1;
        final ReentrantLock takeLock = this.takeLock;
        takeLock.lock();
        try 
        {
            {
                boolean var703747557BF3624C6F05C238D80E7799_300211618 = (count.get() > 0);
                {
                    x = dequeue();
                    c = count.getAndDecrement();
                    notEmpty.signal();
                } 
            } 
        } 
        finally 
        {
            takeLock.unlock();
        } 
        signalNotFull();
        varB4EAC82CA7396A68D541C85D26508E83_1656510182 = x;
        E varA7E53CE21691AB073D9660D615818899_218914682; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_218914682 = varB4EAC82CA7396A68D541C85D26508E83_1559221965;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_218914682 = varB4EAC82CA7396A68D541C85D26508E83_1656510182;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_218914682.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_218914682;
        
        
        
            
        
        
        
        
        
            
                
                
                
                    
            
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.600 -0400", hash_original_method = "6BD887DAC1ACD373E1861DD85FA5D83B", hash_generated_method = "C94F626A50CE8F4360A9752870E09AB9")
    public E peek() {
        E varB4EAC82CA7396A68D541C85D26508E83_238703496 = null; 
        E varB4EAC82CA7396A68D541C85D26508E83_603909273 = null; 
        E varB4EAC82CA7396A68D541C85D26508E83_1461917277 = null; 
        {
            boolean varEE4074E3A1B29EE612CF7959D3B3BF7F_1034926571 = (count.get() == 0);
            varB4EAC82CA7396A68D541C85D26508E83_238703496 = null;
        } 
        final ReentrantLock takeLock = this.takeLock;
        takeLock.lock();
        try 
        {
            Node<E> first = head.next;
            varB4EAC82CA7396A68D541C85D26508E83_603909273 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1461917277 = first.item;
        } 
        finally 
        {
            takeLock.unlock();
        } 
        E varA7E53CE21691AB073D9660D615818899_934581521; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_934581521 = varB4EAC82CA7396A68D541C85D26508E83_238703496;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_934581521 = varB4EAC82CA7396A68D541C85D26508E83_603909273;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_934581521 = varB4EAC82CA7396A68D541C85D26508E83_1461917277;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_934581521.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_934581521;
        
        
            
        
        
        
            
            
                
            
                
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.601 -0400", hash_original_method = "354B8979A292DF58D8ACD150BF598C2B", hash_generated_method = "65A8D236012E2848A4DB548832EF5F49")
     void unlink(Node<E> p, Node<E> trail) {
        p.item = null;
        trail.next = p.next;
        last = trail;
        {
            boolean var7A6724B3243CB327213BB455F7018D95_837559086 = (count.getAndDecrement() == capacity);
            notFull.signal();
        } 
        addTaint(p.getTaint());
        
        
        
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.603 -0400", hash_original_method = "43DA2AA0857729B72806FF0ABDC45219", hash_generated_method = "9A0666D79809FF030A88B2720D51938A")
    public boolean remove(Object o) {
        fullyLock();
        try 
        {
            {
                Node<E> trail = head;
                Node<E> p = trail.next;
                trail = p;
                p = p.next;
                {
                    {
                        boolean varD072E6E000FCF729BD7B2505F48F68BD_994786863 = (o.equals(p.item));
                        {
                            unlink(p, trail);
                        } 
                    } 
                } 
            } 
        } 
        finally 
        {
            fullyUnlock();
        } 
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_457969732 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_457969732;
        
        
        
        
            
                 
                 
                
                    
                    
                
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.604 -0400", hash_original_method = "A4E3D89F8C47A7118ADD1757BF8D3A46", hash_generated_method = "FD633963E789F1303E5530A7E1CA90C2")
    public boolean contains(Object o) {
        fullyLock();
        try 
        {
            {
                Node<E> p = head.next;
                p = p.next;
                {
                    boolean varF9DBDF4C5289176897871C74CFE4EAD8_781774948 = (o.equals(p.item));
                } 
            } 
        } 
        finally 
        {
            fullyUnlock();
        } 
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_371484166 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_371484166;
        
        
        
        
            
                
                    
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.605 -0400", hash_original_method = "A06A302045E6771EA320A7223F86E4E8", hash_generated_method = "F41E6CB07A7D9541B564F6CFC40EEB75")
    public Object[] toArray() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_1346747877 = null; 
        fullyLock();
        try 
        {
            int size = count.get();
            Object[] a = new Object[size];
            int k = 0;
            {
                Node<E> p = head.next;
                p = p.next;
                a[k++] = p.item;
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1346747877 = a;
        } 
        finally 
        {
            fullyUnlock();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1346747877.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1346747877;
        
        
        
            
            
            
            
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.606 -0400", hash_original_method = "3C0973EC18B4AB6267920EDC87F075C5", hash_generated_method = "4E04730C84BDD0B2B74BAEFB00F75766")
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_1972360946 = null; 
        fullyLock();
        try 
        {
            int size = count.get();
            a = (T[])java.lang.reflect.Array.newInstance
                    (a.getClass().getComponentType(), size);
            int k = 0;
            {
                Node<E> p = head.next;
                p = p.next;
                a[k++] = (T)p.item;
            } 
            a[k] = null;
            varB4EAC82CA7396A68D541C85D26508E83_1972360946 = a;
        } 
        finally 
        {
            fullyUnlock();
        } 
        addTaint(a[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1972360946.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1972360946;
        
        
        
            
            
                
                    
            
            
                
            
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.606 -0400", hash_original_method = "74ADAA84A44AA4C99AF60EA5FA9916C8", hash_generated_method = "8258DCA634B7B7D756A9E0910DBBEEE5")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_606157534 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_165309227 = null; 
        fullyLock();
        try 
        {
            Node<E> p = head.next;
            varB4EAC82CA7396A68D541C85D26508E83_606157534 = "[]";
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            {
                E e = p.item;
                sb.append(e == this ? "(this Collection)" : e);
                p = p.next;
                varB4EAC82CA7396A68D541C85D26508E83_165309227 = sb.append(']').toString();
                sb.append(',').append(' ');
            } 
        } 
        finally 
        {
            fullyUnlock();
        } 
        String varA7E53CE21691AB073D9660D615818899_438097593; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_438097593 = varB4EAC82CA7396A68D541C85D26508E83_606157534;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_438097593 = varB4EAC82CA7396A68D541C85D26508E83_165309227;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_438097593.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_438097593;
        
        
        
            
            
                
            
            
            
                
                
                
                
                    
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.607 -0400", hash_original_method = "2B97B8EA201FFE74530152ABDF41ED91", hash_generated_method = "2D643BCD21138E060AEDFB0AF3EA126B")
    public void clear() {
        fullyLock();
        try 
        {
            {
                Node<E> p;
                Node<E> h = head;
                p = h.next;
                {
                    h.next = h;
                    p.item = null;
                } 
                h = p;
            } 
            head = last;
            {
                boolean var5902D34412C5485351BC60F7B41D52F8_1469648644 = (count.getAndSet(0) == capacity);
                notFull.signal();
            } 
        } 
        finally 
        {
            fullyUnlock();
        } 
        
        
        
            
                
                
            
            
            
                
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.607 -0400", hash_original_method = "848AB2101C925A7DB8B05331DC1D79E6", hash_generated_method = "E83E7DF7C2F0152B8030C8F3BF327486")
    public int drainTo(Collection<? super E> c) {
        int var0B753C0ADE2F28D7A7716F28C1FC5A12_1060372427 = (drainTo(c, Integer.MAX_VALUE));
        addTaint(c.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_333232579 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_333232579;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.608 -0400", hash_original_method = "3B8D4B25C05B9AD02BEBED4DB8AC9EEC", hash_generated_method = "A1BCF3835E5AAD83CD80EF3C7D34CC29")
    public int drainTo(Collection<? super E> c, int maxElements) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        {
            boolean var9AEE7ACC5B0D4AF26CA46D5AFC07CCF3_1585021908 = (c == this);
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
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
                {
                    Node<E> p = h.next;
                    c.add(p.item);
                    p.item = null;
                    h.next = h;
                    h = p;
                } 
            } 
            finally 
            {
                {
                    head = h;
                    signalNotFull = (count.getAndAdd(-i) == capacity);
                } 
            } 
        } 
        finally 
        {
            takeLock.unlock();
            signalNotFull();
        } 
        addTaint(c.getTaint());
        addTaint(maxElements);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1704881045 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1704881045;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.608 -0400", hash_original_method = "756A0449DBEE27B15290EF9912B6D98E", hash_generated_method = "33A0CE7F108BB6D1607BFB17168CE947")
    public Iterator<E> iterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_695688028 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_695688028 = new Itr();
        varB4EAC82CA7396A68D541C85D26508E83_695688028.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_695688028;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.609 -0400", hash_original_method = "407E789BCFB8527B31EA0FCB2D45014F", hash_generated_method = "6A6010D63307FDFC29707ADA3F2544C7")
    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
        fullyLock();
        try 
        {
            s.defaultWriteObject();
            {
                Node<E> p = head.next;
                p = p.next;
                s.writeObject(p.item);
            } 
            s.writeObject(null);
        } 
        finally 
        {
            fullyUnlock();
        } 
        addTaint(s.getTaint());
        
        
        
            
            
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.609 -0400", hash_original_method = "2A845E5CA6C44D2307376F014D4A5DD1", hash_generated_method = "85922FF5B0CB66D7B98FF0B2B6E5672B")
    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
        s.defaultReadObject();
        count.set(0);
        last = head = new Node<E>(null);
        {
            @SuppressWarnings("unchecked") E item = (E)s.readObject();
            add(item);
        } 
        addTaint(s.getTaint());
        
        
        
        
        
            
            
            
                
            
        
    }

    
    static class Node<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.609 -0400", hash_original_field = "447B7147E84BE512208DCC0995D67EBC", hash_generated_field = "25C1B4BE35B7528A52E74D8E56CE9F0B")

        E item;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.609 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "A089DAAEF049057EDB97CA1342EE38E4")

        Node<E> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.610 -0400", hash_original_method = "E24CFB813CF8D6D3545154C1747D57F8", hash_generated_method = "F143FACCEFEC2EC78FAE43B87B01534B")
          Node(E x) {
            item = x;
            
            
        }

        
    }


    
    private class Itr implements Iterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.610 -0400", hash_original_field = "43B5C9175984C071F30B873FDCE0A000", hash_generated_field = "96ED1A7AC98C85D7CD0CAC3D4B53A034")

        private Node<E> current;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.610 -0400", hash_original_field = "BB3AE5C41B0FFE5CC0DAF60D4592524F", hash_generated_field = "9782A09877DFB4D434246B92A2C403C0")

        private Node<E> lastRet;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.610 -0400", hash_original_field = "72629BFF0AB58C6A7222BC4792DD9B5D", hash_generated_field = "09FAC7A7C45F476EE0F649D7F47824AF")

        private E currentElement;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.611 -0400", hash_original_method = "5363017965403D930144EB6431B1229A", hash_generated_method = "7BAD25B3B01523F245BCD4EDCDD09007")
          Itr() {
            fullyLock();
            try 
            {
                current = head.next;
                currentElement = current.item;
            } 
            finally 
            {
                fullyUnlock();
            } 
            
            
            
                
                
                    
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.611 -0400", hash_original_method = "930D47D628EF4F4226A6936FD0C40F3E", hash_generated_method = "1362A8BED954358CDF71ECC4A866B468")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_720703106 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_720703106;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.612 -0400", hash_original_method = "4F1204B9DEA81FB44DF832DBC08BD27C", hash_generated_method = "1164065FB3D90A77574AA47181FA59EE")
        private Node<E> nextNode(Node<E> p) {
            Node<E> varB4EAC82CA7396A68D541C85D26508E83_956674619 = null; 
            Node<E> varB4EAC82CA7396A68D541C85D26508E83_1971866374 = null; 
            {
                Node<E> s = p.next;
                varB4EAC82CA7396A68D541C85D26508E83_956674619 = head.next;
                varB4EAC82CA7396A68D541C85D26508E83_1971866374 = s;
                p = s;
            } 
            addTaint(p.getTaint());
            Node<E> varA7E53CE21691AB073D9660D615818899_874842472; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_874842472 = varB4EAC82CA7396A68D541C85D26508E83_956674619;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_874842472 = varB4EAC82CA7396A68D541C85D26508E83_1971866374;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_874842472.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_874842472;
            
            
                
                
                    
                
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.614 -0400", hash_original_method = "B1551F09E1CC1CE37F95082545A7F15D", hash_generated_method = "6BB044A853A15253C733055EB5642807")
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_573119495 = null; 
            fullyLock();
            try 
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                E x = currentElement;
                lastRet = current;
                current = nextNode(current);
                currentElement = (current == null) ? null : current.item;
                varB4EAC82CA7396A68D541C85D26508E83_573119495 = x;
            } 
            finally 
            {
                fullyUnlock();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_573119495.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_573119495;
            
            
            
                
                    
                
                
                
                
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.615 -0400", hash_original_method = "9DBE3C9C0D54D1E1956F6E76D38BE63A", hash_generated_method = "6BE2E60D249C9275B62707AC85ECC177")
        public void remove() {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            fullyLock();
            try 
            {
                Node<E> node = lastRet;
                lastRet = null;
                {
                    Node<E> trail = head;
                    Node<E> p = trail.next;
                    trail = p;
                    p = p.next;
                    {
                        {
                            unlink(p, trail);
                        } 
                    } 
                } 
            } 
            finally 
            {
                fullyUnlock();
            } 
            
            
                
            
            
                
                
                
                     
                     
                    
                        
                        
                    
                
            
                
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.616 -0400", hash_original_field = "4579BD0787ACC5EBD7BBE120D66D1B32", hash_generated_field = "900FED93BFD035CADEBF9B3700EB152D")

    private static final long serialVersionUID = -6903933977591709194L;
}

