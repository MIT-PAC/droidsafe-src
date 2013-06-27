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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.227 -0400", hash_original_field = "7BD14A231864E618E1840C7E117E59C1", hash_generated_field = "277B4266A058D752E724058E1F215618")

    private int capacity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.227 -0400", hash_original_field = "E15431B372E31BBE6073FBB6C5E792BB", hash_generated_field = "E3075C09E1F84C26089996C19069EAFE")

    private AtomicInteger count = new AtomicInteger(0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.227 -0400", hash_original_field = "96E89A298E0A9F469B9AE458D6AFAE9F", hash_generated_field = "48C6F3CDEAC5EAEAC23BFB1092B4D3A3")

    private transient Node<E> head;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.227 -0400", hash_original_field = "98BD1C45684CF587AC2347A92DD7BB51", hash_generated_field = "9882BA72234087D024BDEB5C6D765CDA")

    private transient Node<E> last;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.227 -0400", hash_original_field = "5322750CBC5FB7E2B3FB560931054E46", hash_generated_field = "D458C959FF9DAE03274B0CB89E092A9E")

    private ReentrantLock takeLock = new ReentrantLock();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.227 -0400", hash_original_field = "CEF6C451AADF04E0C65480DEFEC861F2", hash_generated_field = "0A88A7B4D35038828E7A999545772CEB")

    private Condition notEmpty = takeLock.newCondition();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.227 -0400", hash_original_field = "286E62C1C5B79371FA322708D11C41C5", hash_generated_field = "46D5D61A3F0859B494413F327D1AB41B")

    private ReentrantLock putLock = new ReentrantLock();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.227 -0400", hash_original_field = "FA225E5A4B225155E82C7ABA1BEF10B6", hash_generated_field = "322C2C210EDCF6544B91FA60BDDD0102")

    private Condition notFull = putLock.newCondition();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.237 -0400", hash_original_method = "632CB0CBBBC44DF00B6EA380FB3D1564", hash_generated_method = "7E050AD6D76868049EBE527D41ED6759")
    public  LinkedBlockingQueue() {
        this(Integer.MAX_VALUE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.238 -0400", hash_original_method = "B75314FE98F585143D624DCD24C1F5B2", hash_generated_method = "05708A5EE54B0DB4CAE63635F386D894")
    public  LinkedBlockingQueue(int capacity) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        this.capacity = capacity;
        last = head = new Node<E>(null);
        // ---------- Original Method ----------
        //if (capacity <= 0) throw new IllegalArgumentException();
        //this.capacity = capacity;
        //last = head = new Node<E>(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.250 -0400", hash_original_method = "76A1733AA4693E67903F6C627D09C67F", hash_generated_method = "F0F87243708361375D7A5248C17A8E32")
    public  LinkedBlockingQueue(Collection<? extends E> c) {
        this(Integer.MAX_VALUE);
        ReentrantLock putLock;
        putLock = this.putLock;
        putLock.lock();
        try 
        {
            int n;
            n = 0;
            {
                Iterator<E> var334ED49EB23041C8D120547C1BB713D2_1144274693 = (c).iterator();
                var334ED49EB23041C8D120547C1BB713D2_1144274693.hasNext();
                E e = var334ED49EB23041C8D120547C1BB713D2_1144274693.next();
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
        addTaint(c.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.251 -0400", hash_original_method = "15D22B562F85AEAC3F4AC4996FFD23A3", hash_generated_method = "B1B3CF7D29F9116BCA483B5BD502B5C9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.251 -0400", hash_original_method = "23256B84FD63DB25D1FF9FA99CF29C9A", hash_generated_method = "868FD6C751B6DFE434E0B8C8168BA9BB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.251 -0400", hash_original_method = "050BE5B4C52573633224C87BCCA985D9", hash_generated_method = "1294900CE5F97C64F9A5E140C9BF1299")
    private void enqueue(Node<E> node) {
        last = last.next = node;
        // ---------- Original Method ----------
        //last = last.next = node;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.261 -0400", hash_original_method = "0F3CD055205E18F01917D382EBA2EDD8", hash_generated_method = "5B876E3E51EEAF4C5AFB17F379366C3F")
    private E dequeue() {
        E varB4EAC82CA7396A68D541C85D26508E83_1417732261 = null; //Variable for return #1
        Node<E> h;
        h = head;
        Node<E> first;
        first = h.next;
        h.next = h;
        head = first;
        E x;
        x = first.item;
        first.item = null;
        varB4EAC82CA7396A68D541C85D26508E83_1417732261 = x;
        varB4EAC82CA7396A68D541C85D26508E83_1417732261.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1417732261;
        // ---------- Original Method ----------
        //Node<E> h = head;
        //Node<E> first = h.next;
        //h.next = h;
        //head = first;
        //E x = first.item;
        //first.item = null;
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.261 -0400", hash_original_method = "8626572E0FE15707F18ECC5A9712CA34", hash_generated_method = "3646A04C6AE367BA0A6AA42D1CCE1C16")
     void fullyLock() {
        putLock.lock();
        takeLock.lock();
        // ---------- Original Method ----------
        //putLock.lock();
        //takeLock.lock();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.262 -0400", hash_original_method = "5557FE5692936575245483F7CDC5CE2B", hash_generated_method = "DB6AEC1BC900D9A1E58F0AE1939A9554")
     void fullyUnlock() {
        takeLock.unlock();
        putLock.unlock();
        // ---------- Original Method ----------
        //takeLock.unlock();
        //putLock.unlock();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.262 -0400", hash_original_method = "FC3CFC9E56AD635CFF4ED177A60462DA", hash_generated_method = "5E7DA768EB40363D69441327EF2F795E")
    public int size() {
        int var9D4B6D8BE09F232CC6DFC96E7C27D965_75430736 = (count.get());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_628438797 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_628438797;
        // ---------- Original Method ----------
        //return count.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.263 -0400", hash_original_method = "F6FFB0DBE2C073472862E76EB78E2D9E", hash_generated_method = "A91325F4054F24003C66C909E685EB94")
    public int remainingCapacity() {
        int var1DA51DA4294BA3DCCB36CDBA725495A8_523656731 = (capacity - count.get());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_931739309 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_931739309;
        // ---------- Original Method ----------
        //return capacity - count.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.263 -0400", hash_original_method = "37DF2D00E21001E825743AC7943B033F", hash_generated_method = "C4F6B111B24047173D852DE6EFC0617A")
    public void put(E e) throws InterruptedException {
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
                boolean var948F57AE74E06F0875AD4FB7B59A7541_1477197134 = (count.get() == capacity);
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
        addTaint(e.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.264 -0400", hash_original_method = "D5F3AC00421DA10DEFBB832E0EC3BAC8", hash_generated_method = "B7A1E9D3EB6A50E674E43D151D85E5A2")
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
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
                boolean var948F57AE74E06F0875AD4FB7B59A7541_1225414020 = (count.get() == capacity);
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
        addTaint(e.getTaint());
        addTaint(timeout);
        addTaint(unit.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1667973172 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1667973172;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.268 -0400", hash_original_method = "751C55DFDD2504B6D9AAA83EF3048DDA", hash_generated_method = "CB35013FEA8E0421A19E8AC0045731A0")
    public boolean offer(E e) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        AtomicInteger count;
        count = this.count;
        {
            boolean var02EF388EE672A52C47389F83DEF5E6E1_18976397 = (count.get() == capacity);
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
                boolean var75CFCFA13C6DD354C40B5B06E074720E_835301114 = (count.get() < capacity);
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
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_635353494 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_635353494;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.278 -0400", hash_original_method = "022306A077B45DC674F98467F25F93CD", hash_generated_method = "AF45FB9722FC40F20616A485AF7607BA")
    public E take() throws InterruptedException {
        E varB4EAC82CA7396A68D541C85D26508E83_1049002301 = null; //Variable for return #1
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
                boolean varC5243B16B9F11FD69A1317C582A7E86C_786438323 = (count.get() == 0);
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
        varB4EAC82CA7396A68D541C85D26508E83_1049002301 = x;
        varB4EAC82CA7396A68D541C85D26508E83_1049002301.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1049002301;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.279 -0400", hash_original_method = "AA8094BF5AEC46D297071331A526D258", hash_generated_method = "658007A71CACF5E4244D301EC33FDEA3")
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        E varB4EAC82CA7396A68D541C85D26508E83_1408751468 = null; //Variable for return #1
        E varB4EAC82CA7396A68D541C85D26508E83_1972548418 = null; //Variable for return #2
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
                boolean varC5243B16B9F11FD69A1317C582A7E86C_803074024 = (count.get() == 0);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1408751468 = null;
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
        varB4EAC82CA7396A68D541C85D26508E83_1972548418 = x;
        addTaint(timeout);
        addTaint(unit.getTaint());
        E varA7E53CE21691AB073D9660D615818899_95036153; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_95036153 = varB4EAC82CA7396A68D541C85D26508E83_1408751468;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_95036153 = varB4EAC82CA7396A68D541C85D26508E83_1972548418;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_95036153.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_95036153;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.301 -0400", hash_original_method = "D22B106AF12DCACC53C408D22FAEA025", hash_generated_method = "84E043E278F191BE9860F43AC0A8C5C7")
    public E poll() {
        E varB4EAC82CA7396A68D541C85D26508E83_759651389 = null; //Variable for return #1
        E varB4EAC82CA7396A68D541C85D26508E83_1634754459 = null; //Variable for return #2
        AtomicInteger count;
        count = this.count;
        {
            boolean varEE4074E3A1B29EE612CF7959D3B3BF7F_75358105 = (count.get() == 0);
            varB4EAC82CA7396A68D541C85D26508E83_759651389 = null;
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
                boolean var703747557BF3624C6F05C238D80E7799_1986707461 = (count.get() > 0);
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
        varB4EAC82CA7396A68D541C85D26508E83_1634754459 = x;
        E varA7E53CE21691AB073D9660D615818899_1384838014; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1384838014 = varB4EAC82CA7396A68D541C85D26508E83_759651389;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1384838014 = varB4EAC82CA7396A68D541C85D26508E83_1634754459;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1384838014.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1384838014;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.302 -0400", hash_original_method = "6BD887DAC1ACD373E1861DD85FA5D83B", hash_generated_method = "FAEE81BE96A1DDAE002A8CA94B4B57FB")
    public E peek() {
        E varB4EAC82CA7396A68D541C85D26508E83_613209678 = null; //Variable for return #1
        E varB4EAC82CA7396A68D541C85D26508E83_693406476 = null; //Variable for return #2
        E varB4EAC82CA7396A68D541C85D26508E83_515842152 = null; //Variable for return #3
        {
            boolean varEE4074E3A1B29EE612CF7959D3B3BF7F_43730356 = (count.get() == 0);
            varB4EAC82CA7396A68D541C85D26508E83_613209678 = null;
        } //End collapsed parenthetic
        ReentrantLock takeLock;
        takeLock = this.takeLock;
        takeLock.lock();
        try 
        {
            Node<E> first;
            first = head.next;
            varB4EAC82CA7396A68D541C85D26508E83_693406476 = null;
            varB4EAC82CA7396A68D541C85D26508E83_515842152 = first.item;
        } //End block
        finally 
        {
            takeLock.unlock();
        } //End block
        E varA7E53CE21691AB073D9660D615818899_1354911677; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1354911677 = varB4EAC82CA7396A68D541C85D26508E83_613209678;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1354911677 = varB4EAC82CA7396A68D541C85D26508E83_693406476;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1354911677 = varB4EAC82CA7396A68D541C85D26508E83_515842152;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1354911677.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1354911677;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.302 -0400", hash_original_method = "354B8979A292DF58D8ACD150BF598C2B", hash_generated_method = "27271A4C03AF32F3C341383DBC1C84CD")
     void unlink(Node<E> p, Node<E> trail) {
        p.item = null;
        trail.next = p.next;
        last = trail;
        {
            boolean var7A6724B3243CB327213BB455F7018D95_1356831971 = (count.getAndDecrement() == capacity);
            notFull.signal();
        } //End collapsed parenthetic
        addTaint(p.getTaint());
        // ---------- Original Method ----------
        //p.item = null;
        //trail.next = p.next;
        //if (last == p)
            //last = trail;
        //if (count.getAndDecrement() == capacity)
            //notFull.signal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.303 -0400", hash_original_method = "43DA2AA0857729B72806FF0ABDC45219", hash_generated_method = "6AE7BE6CA05D7479F8A6EBBEFD32F2FC")
    public boolean remove(Object o) {
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
                        boolean varD072E6E000FCF729BD7B2505F48F68BD_297190867 = (o.equals(p.item));
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
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1213195010 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1213195010;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.303 -0400", hash_original_method = "A4E3D89F8C47A7118ADD1757BF8D3A46", hash_generated_method = "3107A2077CB98218FC0AB718F4DDABDD")
    public boolean contains(Object o) {
        fullyLock();
        try 
        {
            {
                Node<E> p;
                p = head.next;
                p = p.next;
                {
                    boolean varF9DBDF4C5289176897871C74CFE4EAD8_224204213 = (o.equals(p.item));
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            fullyUnlock();
        } //End block
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1226507257 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1226507257;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.316 -0400", hash_original_method = "A06A302045E6771EA320A7223F86E4E8", hash_generated_method = "088ED64CAF66C906CD596B71AC6D7448")
    public Object[] toArray() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_1170561398 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_1170561398 = a;
        } //End block
        finally 
        {
            fullyUnlock();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1170561398.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1170561398;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.317 -0400", hash_original_method = "3C0973EC18B4AB6267920EDC87F075C5", hash_generated_method = "5ECEAF2DD692C6EE2A4CB2412EF676CE")
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_2024561616 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_2024561616 = a;
        } //End block
        finally 
        {
            fullyUnlock();
        } //End block
        addTaint(a[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2024561616.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2024561616;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.318 -0400", hash_original_method = "74ADAA84A44AA4C99AF60EA5FA9916C8", hash_generated_method = "957A40F116FCC366D91A2317CB278752")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1395283529 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1711466740 = null; //Variable for return #2
        fullyLock();
        try 
        {
            Node<E> p;
            p = head.next;
            varB4EAC82CA7396A68D541C85D26508E83_1395283529 = "[]";
            StringBuilder sb;
            sb = new StringBuilder();
            sb.append('[');
            {
                E e;
                e = p.item;
                sb.append(e == this ? "(this Collection)" : e);
                p = p.next;
                varB4EAC82CA7396A68D541C85D26508E83_1711466740 = sb.append(']').toString();
                sb.append(',').append(' ');
            } //End block
        } //End block
        finally 
        {
            fullyUnlock();
        } //End block
        String varA7E53CE21691AB073D9660D615818899_2082521645; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2082521645 = varB4EAC82CA7396A68D541C85D26508E83_1395283529;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2082521645 = varB4EAC82CA7396A68D541C85D26508E83_1711466740;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2082521645.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2082521645;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.330 -0400", hash_original_method = "2B97B8EA201FFE74530152ABDF41ED91", hash_generated_method = "745AFC60B34D974CCB174A137E27E43F")
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
                boolean var5902D34412C5485351BC60F7B41D52F8_306432746 = (count.getAndSet(0) == capacity);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.330 -0400", hash_original_method = "848AB2101C925A7DB8B05331DC1D79E6", hash_generated_method = "E70B3D655A9C75600D6F5491C2B3C5CB")
    public int drainTo(Collection<? super E> c) {
        int var0B753C0ADE2F28D7A7716F28C1FC5A12_538144353 = (drainTo(c, Integer.MAX_VALUE));
        addTaint(c.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_42755895 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_42755895;
        // ---------- Original Method ----------
        //return drainTo(c, Integer.MAX_VALUE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.331 -0400", hash_original_method = "3B8D4B25C05B9AD02BEBED4DB8AC9EEC", hash_generated_method = "F58B06FF2420651AF7A945E3FB5A8C6E")
    public int drainTo(Collection<? super E> c, int maxElements) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        {
            boolean var9AEE7ACC5B0D4AF26CA46D5AFC07CCF3_736323762 = (c == this);
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
        addTaint(c.getTaint());
        addTaint(maxElements);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1705340160 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1705340160;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.332 -0400", hash_original_method = "756A0449DBEE27B15290EF9912B6D98E", hash_generated_method = "1F026F83F6E020E73F663B69DD3CD4F4")
    public Iterator<E> iterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_218172850 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_218172850 = new Itr();
        varB4EAC82CA7396A68D541C85D26508E83_218172850.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_218172850;
        // ---------- Original Method ----------
        //return new Itr();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.332 -0400", hash_original_method = "407E789BCFB8527B31EA0FCB2D45014F", hash_generated_method = "D200B0D252D82E2891B01EA89272ECBE")
    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
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
        addTaint(s.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.348 -0400", hash_original_method = "2A845E5CA6C44D2307376F014D4A5DD1", hash_generated_method = "84FA07E192F7997765D10DB94187B355")
    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
        s.defaultReadObject();
        count.set(0);
        last = head = new Node<E>(null);
        {
            @SuppressWarnings("unchecked") E item;
            item = (E)s.readObject();
            add(item);
        } //End block
        addTaint(s.getTaint());
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.348 -0400", hash_original_field = "447B7147E84BE512208DCC0995D67EBC", hash_generated_field = "25C1B4BE35B7528A52E74D8E56CE9F0B")

        E item;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.348 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "A089DAAEF049057EDB97CA1342EE38E4")

        Node<E> next;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.348 -0400", hash_original_method = "E24CFB813CF8D6D3545154C1747D57F8", hash_generated_method = "F143FACCEFEC2EC78FAE43B87B01534B")
          Node(E x) {
            item = x;
            // ---------- Original Method ----------
            //item = x;
        }

        
    }


    
    private class Itr implements Iterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.349 -0400", hash_original_field = "43B5C9175984C071F30B873FDCE0A000", hash_generated_field = "96ED1A7AC98C85D7CD0CAC3D4B53A034")

        private Node<E> current;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.349 -0400", hash_original_field = "BB3AE5C41B0FFE5CC0DAF60D4592524F", hash_generated_field = "9782A09877DFB4D434246B92A2C403C0")

        private Node<E> lastRet;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.349 -0400", hash_original_field = "72629BFF0AB58C6A7222BC4792DD9B5D", hash_generated_field = "09FAC7A7C45F476EE0F649D7F47824AF")

        private E currentElement;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.349 -0400", hash_original_method = "5363017965403D930144EB6431B1229A", hash_generated_method = "7BAD25B3B01523F245BCD4EDCDD09007")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.349 -0400", hash_original_method = "930D47D628EF4F4226A6936FD0C40F3E", hash_generated_method = "DF9C6FDE225E49709F207B553197016B")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_807517880 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_807517880;
            // ---------- Original Method ----------
            //return current != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.350 -0400", hash_original_method = "4F1204B9DEA81FB44DF832DBC08BD27C", hash_generated_method = "990E103DD082EC6324308CD1D001BEF4")
        private Node<E> nextNode(Node<E> p) {
            Node<E> varB4EAC82CA7396A68D541C85D26508E83_735818136 = null; //Variable for return #1
            Node<E> varB4EAC82CA7396A68D541C85D26508E83_1571905618 = null; //Variable for return #2
            {
                Node<E> s;
                s = p.next;
                varB4EAC82CA7396A68D541C85D26508E83_735818136 = head.next;
                varB4EAC82CA7396A68D541C85D26508E83_1571905618 = s;
                p = s;
            } //End block
            addTaint(p.getTaint());
            Node<E> varA7E53CE21691AB073D9660D615818899_640525049; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_640525049 = varB4EAC82CA7396A68D541C85D26508E83_735818136;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_640525049 = varB4EAC82CA7396A68D541C85D26508E83_1571905618;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_640525049.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_640525049;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.353 -0400", hash_original_method = "B1551F09E1CC1CE37F95082545A7F15D", hash_generated_method = "AD0C9B40EB38408CA4ADD44C1C8791C5")
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_808913136 = null; //Variable for return #1
            fullyLock();
            try 
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                E x;
                x = currentElement;
                lastRet = current;
                current = nextNode(current);
                currentElement = (current == null) ? null : current.item;
                varB4EAC82CA7396A68D541C85D26508E83_808913136 = x;
            } //End block
            finally 
            {
                fullyUnlock();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_808913136.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_808913136;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.357 -0400", hash_original_method = "9DBE3C9C0D54D1E1956F6E76D38BE63A", hash_generated_method = "D26161053794EB7BCF80A9C413DF3A28")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.358 -0400", hash_original_field = "4579BD0787ACC5EBD7BBE120D66D1B32", hash_generated_field = "C6813AE7A51DB0A3925170515025EF82")

    private static long serialVersionUID = -6903933977591709194L;
}

