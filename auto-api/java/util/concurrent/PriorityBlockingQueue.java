package java.util.concurrent;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.concurrent.locks.*;
import java.util.*;

public class PriorityBlockingQueue<E> extends AbstractQueue<E> implements BlockingQueue<E>, java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.667 -0400", hash_original_field = "A9D1CBF71942327E98B40CF5EF38A960", hash_generated_field = "BA6E9BA522BED220E542D0B7B7CCF63A")

    private transient Object[] queue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.667 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "55DCA83C6162ACD637EB02860F7422EE")

    private transient int size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.667 -0400", hash_original_field = "4092F21BD0E2CC3C9CA971DF59AA8608", hash_generated_field = "5D5D7D779E97F5198B6F4EBA3322C270")

    private transient Comparator<? super E> comparator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.667 -0400", hash_original_field = "DCE7C4174CE9323904A934A486C41288", hash_generated_field = "DFE928B318585A72A4580EF29A43B994")

    private ReentrantLock lock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.667 -0400", hash_original_field = "4D495F503708F3E21723219DA12E7651", hash_generated_field = "6208B332BB61DB5EFD3387E35BF3069A")

    private Condition notEmpty;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.667 -0400", hash_original_field = "972C7B8078DBEF6629BA49B6EBAE2B27", hash_generated_field = "36643E2CE9D2E85479B8D7D985E5BE19")

    private transient volatile int allocationSpinLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.667 -0400", hash_original_field = "7694F4A66316E53C8CDD9D9954BD611D", hash_generated_field = "2F802CAB7C8B52D1CCE596848B3698CE")

    private PriorityQueue q;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.668 -0400", hash_original_method = "7097644646C71112C54FBC7AFE99B502", hash_generated_method = "EB3E09F342C2EF21559210AC909696C8")
    public  PriorityBlockingQueue() {
        this(DEFAULT_INITIAL_CAPACITY, null);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.668 -0400", hash_original_method = "9FD50C62507B9B1E2683A0AA12E68611", hash_generated_method = "402DD8B086F03DC462CEFEA0A97221C2")
    public  PriorityBlockingQueue(int initialCapacity) {
        this(initialCapacity, null);
        addTaint(initialCapacity);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.669 -0400", hash_original_method = "DD3F77DD82D0390F8152735FEB2697B3", hash_generated_method = "6ACF53F34DC97EDEA86146D4C16B9B24")
    public  PriorityBlockingQueue(int initialCapacity,
                                 Comparator<? super E> comparator) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        this.lock = new ReentrantLock();
        this.notEmpty = lock.newCondition();
        this.comparator = comparator;
        this.queue = new Object[initialCapacity];
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.670 -0400", hash_original_method = "39ADFE75332ACE4FAADBC9E7644F48C0", hash_generated_method = "3B38887284CB385749AD2CA3A9AE5234")
    public  PriorityBlockingQueue(Collection<? extends E> c) {
        this.lock = new ReentrantLock();
        this.notEmpty = lock.newCondition();
        boolean heapify = true;
        boolean screen = true;
        {
            SortedSet<? extends E> ss = (SortedSet<? extends E>) c;
            this.comparator = (Comparator<? super E>) ss.comparator();
            heapify = false;
        } 
        {
            PriorityBlockingQueue<? extends E> pq = (PriorityBlockingQueue<? extends E>) c;
            this.comparator = (Comparator<? super E>) pq.comparator();
            screen = false;
            {
                boolean var942B84B8F6DD12D131B1B426D916BED5_502929550 = (pq.getClass() == PriorityBlockingQueue.class);
                heapify = false;
            } 
        } 
        Object[] a = c.toArray();
        int n = a.length;
        {
            boolean var16F77EF61B9474A82FE398A385F0E9B1_350390425 = (a.getClass() != Object[].class);
            a = Arrays.copyOf(a, n, Object[].class);
        } 
        {
            {
                int i = 0;
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } 
        } 
        this.queue = a;
        this.size = n;
        heapify();
        addTaint(c.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.673 -0400", hash_original_method = "4FD20927C2E38EB86416DF04242C2C20", hash_generated_method = "873FBB557D561036D5D40B3ED9F9F298")
    private void tryGrow(Object[] array, int oldCap) {
        lock.unlock();
        Object[] newArray = null;
        {
            boolean var5CBD7A5158A3DA3D554450B05320E898_1743201251 = (allocationSpinLock == 0 &&
            UNSAFE.compareAndSwapInt(this, allocationSpinLockOffset,
                                     0, 1));
            {
                try 
                {
                    int newCap = oldCap + ((oldCap < 64) ?
                                       (oldCap + 2) : 
                                       (oldCap >> 1));
                    {
                        int minCap = oldCap + 1;
                        if (DroidSafeAndroidRuntime.control) throw new OutOfMemoryError();
                        newCap = MAX_ARRAY_SIZE;
                    } 
                    newArray = new Object[newCap];
                } 
                finally 
                {
                    allocationSpinLock = 0;
                } 
            } 
        } 
        Thread.yield();
        lock.lock();
        {
            queue = newArray;
            System.arraycopy(array, 0, newArray, 0, oldCap);
        } 
        addTaint(array[0].getTaint());
        addTaint(oldCap);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.675 -0400", hash_original_method = "B92133B4F8095968C1CAA0CBFEDBAB19", hash_generated_method = "23CC9BD393DC7F3001F0811344657CE3")
    private E extract() {
        E varB4EAC82CA7396A68D541C85D26508E83_333961961 = null; 
        E result;
        int n = size - 1;
        result = null;
        {
            Object[] array = queue;
            result = (E) array[0];
            E x = (E) array[n];
            array[n] = null;
            Comparator<? super E> cmp = comparator;
            siftDownComparable(0, x, array, n);
            siftDownUsingComparator(0, x, array, n, cmp);
            size = n;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_333961961 = result;
        varB4EAC82CA7396A68D541C85D26508E83_333961961.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_333961961;
        
        
        
        
            
        
            
            
            
            
            
            
                
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static <T> void siftUpComparable(int k, T x, Object[] array) {
        Comparable<? super T> key = (Comparable<? super T>) x;
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = array[parent];
            if (key.compareTo((T) e) >= 0)
                break;
            array[k] = e;
            k = parent;
        }
        array[k] = key;
    }

    
    @DSModeled(DSC.SAFE)
    private static <T> void siftUpUsingComparator(int k, T x, Object[] array,
                                       Comparator<? super T> cmp) {
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = array[parent];
            if (cmp.compare(x, (T) e) >= 0)
                break;
            array[k] = e;
            k = parent;
        }
        array[k] = x;
    }

    
    @DSModeled(DSC.SAFE)
    private static <T> void siftDownComparable(int k, T x, Object[] array,
                                               int n) {
        Comparable<? super T> key = (Comparable<? super T>)x;
        int half = n >>> 1;
        while (k < half) {
            int child = (k << 1) + 1; 
            Object c = array[child];
            int right = child + 1;
            if (right < n &&
                ((Comparable<? super T>) c).compareTo((T) array[right]) > 0)
                c = array[child = right];
            if (key.compareTo((T) c) <= 0)
                break;
            array[k] = c;
            k = child;
        }
        array[k] = key;
    }

    
    @DSModeled(DSC.SAFE)
    private static <T> void siftDownUsingComparator(int k, T x, Object[] array,
                                                    int n,
                                                    Comparator<? super T> cmp) {
        int half = n >>> 1;
        while (k < half) {
            int child = (k << 1) + 1;
            Object c = array[child];
            int right = child + 1;
            if (right < n && cmp.compare((T) c, (T) array[right]) > 0)
                c = array[child = right];
            if (cmp.compare(x, (T) c) <= 0)
                break;
            array[k] = c;
            k = child;
        }
        array[k] = x;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.677 -0400", hash_original_method = "EE7D24D9E196708648F7B6757F98A148", hash_generated_method = "178459D13DA73782E3C6396E8C5E538F")
    private void heapify() {
        Object[] array = queue;
        int n = size;
        int half = (n >>> 1) - 1;
        Comparator<? super E> cmp = comparator;
        {
            {
                int i = half;
                siftDownComparable(i, (E) array[i], array, n);
            } 
        } 
        {
            {
                int i = half;
                siftDownUsingComparator(i, (E) array[i], array, n, cmp);
            } 
        } 
        
        
        
        
        
        
            
                
        
        
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.677 -0400", hash_original_method = "F77A4F330ECF7476CC7AF200B57EFA7F", hash_generated_method = "4BD4C6CC417F1FE872755C0FE68D176B")
    public boolean add(E e) {
        boolean var42B2AD017FC8EAA920A05640330B5300_1837080757 = (offer(e));
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_44373559 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_44373559;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.678 -0400", hash_original_method = "775A55093A20D9C3EB5D5F7F7F70C525", hash_generated_method = "23C93FDC6B64E1339D658C82B7E64EF2")
    public boolean offer(E e) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        final ReentrantLock lock = this.lock;
        lock.lock();
        int n;
        int cap;
        Object[] array;
        {
            boolean var4531DD35A6B47ED89177DB8A0F1B2960_561984226 = ((n = size) >= (cap = (array = queue).length));
            tryGrow(array, cap);
        } 
        try 
        {
            Comparator<? super E> cmp = comparator;
            siftUpComparable(n, e, array);
            siftUpUsingComparator(n, e, array, cmp);
            size = n + 1;
            notEmpty.signal();
        } 
        finally 
        {
            lock.unlock();
        } 
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_544294309 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_544294309;
        
        
            
        
        
        
        
        
            
        
            
            
                
            
                
            
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.678 -0400", hash_original_method = "C9D180903A7CC0CD8F17729AA0E80F49", hash_generated_method = "518037778B4178C6B51A84243CFC11C5")
    public void put(E e) {
        offer(e);
        addTaint(e.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.678 -0400", hash_original_method = "BFDD71499687D637F57FF5151EA7665D", hash_generated_method = "713A7CBAEFAD567EFBC63F39023BE9DA")
    public boolean offer(E e, long timeout, TimeUnit unit) {
        boolean var42B2AD017FC8EAA920A05640330B5300_1653712358 = (offer(e));
        addTaint(e.getTaint());
        addTaint(timeout);
        addTaint(unit.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1238693078 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1238693078;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.679 -0400", hash_original_method = "A22423A10175E57DE557DAE1EC700763", hash_generated_method = "DD2A62039469358E976348DAD877D380")
    public E poll() {
        E varB4EAC82CA7396A68D541C85D26508E83_1954398660 = null; 
        final ReentrantLock lock = this.lock;
        lock.lock();
        E result;
        try 
        {
            result = extract();
        } 
        finally 
        {
            lock.unlock();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1954398660 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1954398660.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1954398660;
        
        
        
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.679 -0400", hash_original_method = "7702BF7782A7372B6632BD3C70F3CD0F", hash_generated_method = "82E239FBCCB1AABAD770CD002E873EA1")
    public E take() throws InterruptedException {
        E varB4EAC82CA7396A68D541C85D26508E83_1920329186 = null; 
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        E result;
        try 
        {
            {
                boolean varC9C5225C062A6E8E6EB29A2DE54BC6B7_127032504 = ((result = extract()) == null);
                notEmpty.await();
            } 
        } 
        finally 
        {
            lock.unlock();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1920329186 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1920329186.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1920329186;
        
        
        
        
        
            
                
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.680 -0400", hash_original_method = "E1FF0BE92CA560531F5134C8D376F3E9", hash_generated_method = "7075D4C84DDD097FBBD43921BF8E0C29")
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        E varB4EAC82CA7396A68D541C85D26508E83_1821421486 = null; 
        long nanos = unit.toNanos(timeout);
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        E result;
        try 
        {
            {
                boolean var8F587AA462BBB3430969A2F03A01845E_128479600 = ((result = extract()) == null && nanos > 0);
                nanos = notEmpty.awaitNanos(nanos);
            } 
        } 
        finally 
        {
            lock.unlock();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1821421486 = result;
        addTaint(timeout);
        addTaint(unit.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1821421486.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1821421486;
        
        
        
        
        
        
            
                
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.682 -0400", hash_original_method = "6160A1DDBF053B72DB86495140716C8D", hash_generated_method = "2EC0064A45CB7B34B660CDA898AA969C")
    public E peek() {
        E varB4EAC82CA7396A68D541C85D26508E83_692195751 = null; 
        final ReentrantLock lock = this.lock;
        lock.lock();
        E result;
        try 
        {
            result = size > 0 ? (E) queue[0] : null;
        } 
        finally 
        {
            lock.unlock();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_692195751 = result;
        varB4EAC82CA7396A68D541C85D26508E83_692195751.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_692195751;
        
        
        
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.683 -0400", hash_original_method = "83ACC201A16F2FDDF97B6B07FFFB2168", hash_generated_method = "E01C5860A28665AB4E02ADAA6CD89536")
    public Comparator<? super E> comparator() {
        Comparator<? super E> varB4EAC82CA7396A68D541C85D26508E83_1721486949 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1721486949 = comparator;
        varB4EAC82CA7396A68D541C85D26508E83_1721486949.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1721486949;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.683 -0400", hash_original_method = "FB53A461CD3B1BACC3DB27D415F5CC64", hash_generated_method = "665DFA2D6B86BDC17DCA720140FB0C21")
    public int size() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_323706847 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_323706847;
        
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.684 -0400", hash_original_method = "E7CDD1D543D1F61B1D969765A4629893", hash_generated_method = "FF49EC73A4F5DEB7897BEC0CB48E4F11")
    public int remainingCapacity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1154554417 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1154554417;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.685 -0400", hash_original_method = "EC3B7D586FF4D36081EA6F7D19ADE62F", hash_generated_method = "FB253647E4531C9F1C2BD5E89F2805E4")
    private int indexOf(Object o) {
        {
            Object[] array = queue;
            int n = size;
            {
                int i = 0;
                {
                    boolean varD361998FE043BDE60F5D0B136966DE37_1143106835 = (o.equals(array[i]));
                } 
            } 
        } 
        addTaint(o.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_155980010 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_155980010;
        
        
            
            
            
                
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.685 -0400", hash_original_method = "9D73270D970CE651CDDED76CEC412EF8", hash_generated_method = "8677CE0BC2333FAE940A4F737EBEAED6")
    private void removeAt(int i) {
        Object[] array = queue;
        int n = size - 1;
        array[i] = null;
        {
            E moved = (E) array[n];
            array[n] = null;
            Comparator<? super E> cmp = comparator;
            siftDownComparable(i, moved, array, n);
            siftDownUsingComparator(i, moved, array, n, cmp);
            {
                siftUpComparable(i, moved, array);
                siftUpUsingComparator(i, moved, array, cmp);
            } 
        } 
        size = n;
        addTaint(i);
        
        
        
        
            
        
            
            
            
            
                
            
                
            
                
                    
                
                    
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.686 -0400", hash_original_method = "9C7EDF9574A228DB080DCC7A28F18F6B", hash_generated_method = "A59A23B0AC819A23E18D5D71B71DE301")
    public boolean remove(Object o) {
        boolean removed = false;
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            int i = indexOf(o);
            {
                removeAt(i);
                removed = true;
            } 
        } 
        finally 
        {
            lock.unlock();
        } 
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1030372657 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1030372657;
        
        
        
        
        
            
            
                
                
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.686 -0400", hash_original_method = "32C7969330E75D54F62841F3B8B9051A", hash_generated_method = "FEE2C5DE3689DB37A6372D0D6F27FA8C")
    private void removeEQ(Object o) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            Object[] array = queue;
            int n = size;
            {
                int i = 0;
                {
                    {
                        removeAt(i);
                    } 
                } 
            } 
        } 
        finally 
        {
            lock.unlock();
        } 
        addTaint(o.getTaint());
        
        
        
        
            
            
            
                
                    
                    
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.687 -0400", hash_original_method = "C9C3AD49D429D8919794902BE1E1A9F2", hash_generated_method = "3ACAE517B9E287F296141E95ABE5885F")
    public boolean contains(Object o) {
        int index;
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            index = indexOf(o);
        } 
        finally 
        {
            lock.unlock();
        } 
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1227051161 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1227051161;
        
        
        
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.688 -0400", hash_original_method = "8A09FBF09ED2852585642BCE8CE60ACB", hash_generated_method = "41AD7C607D9FED3A7B511293931021DD")
    public Object[] toArray() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_699067606 = null; 
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_699067606 = Arrays.copyOf(queue, size);
        } 
        finally 
        {
            lock.unlock();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_699067606.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_699067606;
        
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.688 -0400", hash_original_method = "394B446E36D7177A8AA9580B0613E718", hash_generated_method = "F347B3395F9066C2055FDEF29119A7BD")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1209169662 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1966234354 = null; 
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            int n = size;
            varB4EAC82CA7396A68D541C85D26508E83_1209169662 = "[]";
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            {
                int i = 0;
                {
                    E e = (E)queue[i];
                    sb.append(e == this ? "(this Collection)" : e);
                    sb.append(',').append(' ');
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1966234354 = sb.append(']').toString();
        } 
        finally 
        {
            lock.unlock();
        } 
        String varA7E53CE21691AB073D9660D615818899_1942276145; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1942276145 = varB4EAC82CA7396A68D541C85D26508E83_1209169662;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1942276145 = varB4EAC82CA7396A68D541C85D26508E83_1966234354;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1942276145.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1942276145;
        
        
        
        
            
            
                
            
            
            
                
                
                
                    
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.689 -0400", hash_original_method = "805242EB6CDCF550F39FC4583E9E3F8E", hash_generated_method = "F844D38DB5EC92FE3D0A912ABECD12A1")
    public int drainTo(Collection<? super E> c) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        {
            boolean var9AEE7ACC5B0D4AF26CA46D5AFC07CCF3_1230977500 = (c == this);
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } 
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            int n = 0;
            E e;
            {
                boolean var848661D55AF18EF6F0879531DA6060ED_1794720534 = ((e = extract()) != null);
                {
                    c.add(e);
                } 
            } 
        } 
        finally 
        {
            lock.unlock();
        } 
        addTaint(c.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_145519792 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_145519792;
        
        
            
        
            
        
        
        
            
            
            
                
                
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.689 -0400", hash_original_method = "B5B895AF26F1F939F2943E595D444903", hash_generated_method = "6ADFC08B38A248215B39C8AE872F60F5")
    public int drainTo(Collection<? super E> c, int maxElements) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        {
            boolean var9AEE7ACC5B0D4AF26CA46D5AFC07CCF3_395181869 = (c == this);
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } 
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            int n = 0;
            E e;
            {
            	if (n < maxElements && (e = extract()) != null)
                {
                    c.add(e);
                } 
            } 
        } 
        finally 
        {
            lock.unlock();
        } 
        addTaint(c.getTaint());
        addTaint(maxElements);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1988093807 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1988093807;
        
        
            
        
            
        
            
        
        
        
            
            
            
                
                
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.690 -0400", hash_original_method = "D7ED8780EA10829FC69FCC0BE368EAAC", hash_generated_method = "51E38DB9B40F25273D7A95C752413E7E")
    public void clear() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            Object[] array = queue;
            int n = size;
            size = 0;
            {
                int i = 0;
                array[i] = null;
            } 
        } 
        finally 
        {
            lock.unlock();
        } 
        
        
        
        
            
            
            
            
                
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.691 -0400", hash_original_method = "6C84403244E1C1A4059442AFEB39A418", hash_generated_method = "0DAF34084D6A806B801BD3F067C91285")
    public <T> T[] toArray(T[] a) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_1508437472 = null; 
        T[] varB4EAC82CA7396A68D541C85D26508E83_1449018870 = null; 
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            int n = size;
            varB4EAC82CA7396A68D541C85D26508E83_1508437472 = (T[]) Arrays.copyOf(queue, size, a.getClass());
            System.arraycopy(queue, 0, a, 0, n);
            a[n] = null;
            varB4EAC82CA7396A68D541C85D26508E83_1449018870 = a;
        } 
        finally 
        {
            lock.unlock();
        } 
        addTaint(a[0].getTaint());
        T[] varA7E53CE21691AB073D9660D615818899_587847984; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_587847984 = varB4EAC82CA7396A68D541C85D26508E83_1508437472;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_587847984 = varB4EAC82CA7396A68D541C85D26508E83_1449018870;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_587847984.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_587847984;
        
        
        
        
            
            
                
            
            
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.692 -0400", hash_original_method = "42CB3EDA719DA2D528DF0D9481F5BC1E", hash_generated_method = "F2D204BE8C9C105D8244E39910976167")
    public Iterator<E> iterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_1929358567 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1929358567 = new Itr(toArray());
        varB4EAC82CA7396A68D541C85D26508E83_1929358567.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1929358567;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.692 -0400", hash_original_method = "4F878ABF7AAF09586275C9E3C0FC32B2", hash_generated_method = "E1D3DA8A81E441390EECCBF3E96CC123")
    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
        lock.lock();
        try 
        {
            int n = size;
            q = new PriorityQueue<E>(n == 0 ? 1 : n, comparator);
            q.addAll(this);
            s.defaultWriteObject();
        } 
        finally 
        {
            q = null;
            lock.unlock();
        } 
        addTaint(s.getTaint());
        
        
        
            
            
            
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.693 -0400", hash_original_method = "29A8172D11EE1F6C2B41EDC469205BD4", hash_generated_method = "93034FB6F0B6D7269346FC5CF72C253B")
    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
        try 
        {
            s.defaultReadObject();
            this.queue = new Object[q.size()];
            comparator = q.comparator();
            addAll(q);
        } 
        finally 
        {
            q = null;
        } 
        addTaint(s.getTaint());
        
        
            
            
            
            
        
            
        
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

    
    final class Itr implements Iterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.694 -0400", hash_original_field = "F1F713C9E000F5D3F280ADBD124DF4F5", hash_generated_field = "3E4C52F6F0428C39E4E692D20A9AA9AA")

        Object[] array;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.694 -0400", hash_original_field = "1791A97A8403730EE0760489A2AEB992", hash_generated_field = "574451AF3BDD0EC887A8F04530DC95F1")

        int cursor;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.694 -0400", hash_original_field = "BB3AE5C41B0FFE5CC0DAF60D4592524F", hash_generated_field = "8BE11FCC759F9AA5663F1AF67D0DDBCD")

        int lastRet;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.695 -0400", hash_original_method = "3D5D0E3420638FA7514533715C7FD5D4", hash_generated_method = "EB06B38A7CA55EB34A1139317AF2CA46")
          Itr(Object[] array) {
            lastRet = -1;
            this.array = array;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.695 -0400", hash_original_method = "C1264B905CC60CA39EE5BE51F177AC9A", hash_generated_method = "86D1ECF74735BE215096B12813D9B00E")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1618545209 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1618545209;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.696 -0400", hash_original_method = "F81A0847679B1E16464240B404F27074", hash_generated_method = "83B1EED75CFF2A6F6033B5DADD40D68F")
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_1348047634 = null; 
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            lastRet = cursor;
            varB4EAC82CA7396A68D541C85D26508E83_1348047634 = (E)array[cursor++];
            varB4EAC82CA7396A68D541C85D26508E83_1348047634.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1348047634;
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.696 -0400", hash_original_method = "1F047BB3E034A57C737F1A0202C892CE", hash_generated_method = "08E09F4344B39683C618BD42C209568B")
        public void remove() {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
            removeEQ(array[lastRet]);
            lastRet = -1;
            
            
                
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.696 -0400", hash_original_field = "6586B719D1CFEBF763733CE7541EF857", hash_generated_field = "811DD10CE0D7C0A698CE066ABFB4BD09")

    private static final long serialVersionUID = 5595510919245408276L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.696 -0400", hash_original_field = "E9227ABF9BE6865B37299BE3C2962628", hash_generated_field = "574A317D9EDD67194D9BED5FE6079949")

    private static final int DEFAULT_INITIAL_CAPACITY = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.696 -0400", hash_original_field = "7495A79320523C6630B77A5679432676", hash_generated_field = "FA2406BBBB27AB0C01366DB7BFD361CA")

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.696 -0400", hash_original_field = "3E088F71F6042050BDAAA79B57C7A5CD", hash_generated_field = "42C3BEC243DA1A57DFC4FB82C324F252")

    private static final sun.misc.Unsafe UNSAFE = sun.misc.Unsafe.getUnsafe();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:14.696 -0400", hash_original_field = "FB72FFD9F0A458E85B595F5B3C6B2241", hash_generated_field = "258087F678D4B6D6AE6DB65BD90AB6E4")

    private static final long allocationSpinLockOffset = objectFieldOffset(UNSAFE, "allocationSpinLock",
                          PriorityBlockingQueue.class);
}

