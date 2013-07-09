package java.util.concurrent;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.concurrent.locks.*;
import java.util.*;

public class ArrayBlockingQueue<E> extends AbstractQueue<E> implements BlockingQueue<E>, java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.113 -0400", hash_original_field = "691D502CFD0E0626CD3B058E5682AD1C", hash_generated_field = "BAB14770993D8E8C5F571816E68BB451")

    Object[] items;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.113 -0400", hash_original_field = "248C717869EF457873D5265F0D566C26", hash_generated_field = "155CD9B83999F44788DDAFF138F1D62C")

    int takeIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.113 -0400", hash_original_field = "EC20CABCDA9500AB408F58648A4190A5", hash_generated_field = "C304AC129AAA2CC4EBBA14BAA5601D08")

    int putIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.113 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "B83BF7ED7F5719DA923E1BC0AC69952B")

    int count;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.113 -0400", hash_original_field = "DCE7C4174CE9323904A934A486C41288", hash_generated_field = "684903DA26FF3CD98DD43FF6C66C5020")

    ReentrantLock lock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.113 -0400", hash_original_field = "4D495F503708F3E21723219DA12E7651", hash_generated_field = "6208B332BB61DB5EFD3387E35BF3069A")

    private Condition notEmpty;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.113 -0400", hash_original_field = "8BBF6A14B0983B211D60B3FC3BF73A3F", hash_generated_field = "9BD2EF78405D878781918D2C46F5ACCE")

    private Condition notFull;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.114 -0400", hash_original_method = "989EAF8314C95E2BC3034097E1831933", hash_generated_method = "83B64C9C6E2AFE89CF5D0C45CAB4ECE4")
    public  ArrayBlockingQueue(int capacity) {
        this(capacity, false);
        addTaint(capacity);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.114 -0400", hash_original_method = "D00F5C645B4A4E3D47EB794330FD0093", hash_generated_method = "0A473E5EB0452CD5D8C2AFBE5957D4FB")
    public  ArrayBlockingQueue(int capacity, boolean fair) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        this.items = new Object[capacity];
        lock = new ReentrantLock(fair);
        notEmpty = lock.newCondition();
        notFull =  lock.newCondition();
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.118 -0400", hash_original_method = "27F14E8862A13463ECADB9F13ABB8363", hash_generated_method = "29CF6BEC1B2DEC98235635795D57E651")
    public  ArrayBlockingQueue(int capacity, boolean fair,
                              Collection<? extends E> c) {
        this(capacity, fair);
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            int i = 0;
            try 
            {
                {
                    Iterator<? extends E> var334ED49EB23041C8D120547C1BB713D2_513174870 = (c).iterator();
                    var334ED49EB23041C8D120547C1BB713D2_513174870.hasNext();
                    E e = var334ED49EB23041C8D120547C1BB713D2_513174870.next();
                    {
                        checkNotNull(e);
                        items[i++] = e;
                    } 
                } 
            } 
            catch (ArrayIndexOutOfBoundsException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } 
            count = i;
            putIndex = (i == capacity) ? 0 : i;
        } 
        finally 
        {
            lock.unlock();
        } 
        addTaint(fair);
        addTaint(c.getTaint());
        
        
        
        
            
            
                
                    
                    
                
            
                
            
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.118 -0400", hash_original_method = "225BF2AA9DF4D481E4497FC0C844BC07", hash_generated_method = "601FF866943B82B6BD5B1603A2B399CC")
    final int inc(int i) {
        addTaint(i);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1883099914 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1883099914;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.119 -0400", hash_original_method = "3E735D41E2F85E8ACC700EB7ACA7DBFD", hash_generated_method = "B660FE91108CAAC4ACE1680AE21D44E1")
    final int dec(int i) {
        addTaint(i);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1462126309 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1462126309;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    static <E> E cast(Object item) {
        return (E) item;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.120 -0400", hash_original_method = "D27765FC19695D3D1037FEAF928DE057", hash_generated_method = "53C88BA5C07A96D1AD8B352F3FFA2006")
    final E itemAt(int i) {
        E varB4EAC82CA7396A68D541C85D26508E83_1824219954 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1824219954 = this.<E>cast(items[i]);
        addTaint(i);
        varB4EAC82CA7396A68D541C85D26508E83_1824219954.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1824219954;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void checkNotNull(Object v) {
        if (v == null)
            throw new NullPointerException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.121 -0400", hash_original_method = "7F66A086F3C39CFEE464DF3F42EF745A", hash_generated_method = "C732451D3875B8BA1917FD882A718428")
    private void insert(E x) {
        items[putIndex] = x;
        putIndex = inc(putIndex);
        notEmpty.signal();
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.122 -0400", hash_original_method = "FAA6B2CA6161B01EDCE06644087258E9", hash_generated_method = "0B27F1AACDF0C1E02423F9BCE155BE60")
    private E extract() {
        E varB4EAC82CA7396A68D541C85D26508E83_853725490 = null; 
        final Object[] items = this.items;
        E x = this.<E>cast(items[takeIndex]);
        items[takeIndex] = null;
        takeIndex = inc(takeIndex);
        notFull.signal();
        varB4EAC82CA7396A68D541C85D26508E83_853725490 = x;
        varB4EAC82CA7396A68D541C85D26508E83_853725490.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_853725490;
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.122 -0400", hash_original_method = "94E6DD980D252AA320ADEF879614EDE5", hash_generated_method = "8FEBAEE14BE375F726CEC9769D253297")
     void removeAt(int i) {
        final Object[] items = this.items;
        {
            items[takeIndex] = null;
            takeIndex = inc(takeIndex);
        } 
        {
            {
                int nexti = inc(i);
                {
                    items[i] = items[nexti];
                    i = nexti;
                } 
                {
                    items[i] = null;
                    putIndex = i;
                } 
            } 
        } 
        notFull.signal();
        
        
        
            
            
        
            
                
                
                    
                    
                
                    
                    
                    
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.123 -0400", hash_original_method = "656D7386EF8E1EB18507F4383E955E73", hash_generated_method = "19C3BC91B4A9D11AE3B674265A10F266")
    public boolean add(E e) {
        boolean var2080333CA7DC32E7DD58836F2E497C8E_478803635 = (super.add(e));
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1922864715 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1922864715;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.123 -0400", hash_original_method = "9E7F5A1AF35EF2F840CAB652EE8C4445", hash_generated_method = "7EA06BACB4B4835E26E7D1BD09F256CE")
    public boolean offer(E e) {
        checkNotNull(e);
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            {
                insert(e);
            } 
        } 
        finally 
        {
            lock.unlock();
        } 
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_940469896 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_940469896;
        
        
        
        
        
            
                
            
                
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.123 -0400", hash_original_method = "5E01CBD1D1D4C5DC328EF4CF7109CA33", hash_generated_method = "9CB1A1C5E95257D669701C8500496819")
    public void put(E e) throws InterruptedException {
        checkNotNull(e);
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try 
        {
            notFull.await();
            insert(e);
        } 
        finally 
        {
            lock.unlock();
        } 
        addTaint(e.getTaint());
        
        
        
        
        
            
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.124 -0400", hash_original_method = "B8C47E86765DFB497203F72EAEF6D248", hash_generated_method = "9B0172B8DE8A98A9B6D6DDA688C0C115")
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        checkNotNull(e);
        long nanos = unit.toNanos(timeout);
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try 
        {
            {
                nanos = notFull.awaitNanos(nanos);
            } 
            insert(e);
        } 
        finally 
        {
            lock.unlock();
        } 
        addTaint(e.getTaint());
        addTaint(timeout);
        addTaint(unit.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_362902891 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_362902891;
        
        
        
        
        
        
            
                
                    
                
            
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.124 -0400", hash_original_method = "0415B543E2D9F81F71C1F297B3EB3C5B", hash_generated_method = "FA1DB3CD65579F9B15038983B3FCF16E")
    public E poll() {
        E varB4EAC82CA7396A68D541C85D26508E83_2050380488 = null; 
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2050380488 = (count == 0) ? null : extract();
        } 
        finally 
        {
            lock.unlock();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2050380488.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2050380488;
        
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.125 -0400", hash_original_method = "30071A1958BC767E727888E18C86B273", hash_generated_method = "9606E835918E73A710EDC022FF523791")
    public E take() throws InterruptedException {
        E varB4EAC82CA7396A68D541C85D26508E83_993745996 = null; 
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try 
        {
            notEmpty.await();
            varB4EAC82CA7396A68D541C85D26508E83_993745996 = extract();
        } 
        finally 
        {
            lock.unlock();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_993745996.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_993745996;
        
        
        
        
            
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.126 -0400", hash_original_method = "9A4759FF3B4CF20FAA7F6E911397CD3E", hash_generated_method = "8492D2B4EEDB4D7BA9940B740CC8B540")
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        E varB4EAC82CA7396A68D541C85D26508E83_938603626 = null; 
        E varB4EAC82CA7396A68D541C85D26508E83_236156939 = null; 
        long nanos = unit.toNanos(timeout);
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try 
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_938603626 = null;
                nanos = notEmpty.awaitNanos(nanos);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_236156939 = extract();
        } 
        finally 
        {
            lock.unlock();
        } 
        addTaint(timeout);
        addTaint(unit.getTaint());
        E varA7E53CE21691AB073D9660D615818899_195078243; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_195078243 = varB4EAC82CA7396A68D541C85D26508E83_938603626;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_195078243 = varB4EAC82CA7396A68D541C85D26508E83_236156939;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_195078243.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_195078243;
        
        
        
        
        
            
                
                    
                
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.126 -0400", hash_original_method = "36198DC803CD2F28AA6354324378D8A6", hash_generated_method = "A4F758B8ED478D5CCE371EAEC8E13240")
    public E peek() {
        E varB4EAC82CA7396A68D541C85D26508E83_1517462679 = null; 
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1517462679 = (count == 0) ? null : itemAt(takeIndex);
        } 
        finally 
        {
            lock.unlock();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1517462679.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1517462679;
        
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.127 -0400", hash_original_method = "455EA274614F97D61B2EABEB4507FE65", hash_generated_method = "1E6E31C6990BE837F453AB8A98EDF0F1")
    public int size() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1091741922 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1091741922;
        
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.127 -0400", hash_original_method = "93162D5A121913041A27A55F13ABACF8", hash_generated_method = "BA5352AE772E6F51CCBB0065D1AFE1B3")
    public int remainingCapacity() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1056617412 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1056617412;
        
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.127 -0400", hash_original_method = "DAEECD7AA7FBEB0DFD3FA22914451AA9", hash_generated_method = "E7D9B7A16499B16AB7CCD4D13E324E69")
    public boolean remove(Object o) {
        final Object[] items = this.items;
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            {
                int i = takeIndex;
                int k = count;
                i = inc(i);
                {
                    {
                        boolean var236AB91C5F60C89756F7224AEACDA86C_484328845 = (o.equals(items[i]));
                        {
                            removeAt(i);
                        } 
                    } 
                } 
            } 
        } 
        finally 
        {
            lock.unlock();
        } 
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_597774410 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_597774410;
        
        
        
        
        
        
            
                
                    
                    
                
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.128 -0400", hash_original_method = "BABF8DBF8C2C3831FF0E73AA93059482", hash_generated_method = "06A3B28301D4625A2E1065117221EB09")
    public boolean contains(Object o) {
        final Object[] items = this.items;
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            {
                int i = takeIndex;
                int k = count;
                i = inc(i);
                {
                    boolean varFB370F6F5D0FE842A8BFC3F3EB196D0D_1439923973 = (o.equals(items[i]));
                } 
            } 
        } 
        finally 
        {
            lock.unlock();
        } 
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_94564580 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_94564580;
        
        
        
        
        
        
            
                
                    
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.129 -0400", hash_original_method = "75EA37BFFAA918A3594F9496C85F47EF", hash_generated_method = "C83E010965B41E804024E996E1D435F7")
    public Object[] toArray() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_416128236 = null; 
        final Object[] items = this.items;
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            final int count = this.count;
            Object[] a = new Object[count];
            {
                int i = takeIndex;
                int k = 0;
                i = inc(i);
                a[k] = items[i];
            } 
            varB4EAC82CA7396A68D541C85D26508E83_416128236 = a;
        } 
        finally 
        {
            lock.unlock();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_416128236.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_416128236;
        
        
        
        
        
            
            
            
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.132 -0400", hash_original_method = "95E1CD553E699913E584434D85EF3537", hash_generated_method = "FC4CC7F9A3A1665F36A20770D5E8B611")
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_456196711 = null; 
        final Object[] items = this.items;
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            final int count = this.count;
            final int len = a.length;
            a = (T[])java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), count);
            {
                int i = takeIndex;
                int k = 0;
                i = inc(i);
                a[k] = (T) items[i];
            } 
            a[count] = null;
            varB4EAC82CA7396A68D541C85D26508E83_456196711 = a;
        } 
        finally 
        {
            lock.unlock();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_456196711.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_456196711;
        
        
        
        
        
            
            
            
                
                    
            
                
            
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.134 -0400", hash_original_method = "21683449F727FF2B89133F444D211102", hash_generated_method = "97921664B1CB5ADE24759603FB3F7C8E")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_623893992 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1636111782 = null; 
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            int k = count;
            varB4EAC82CA7396A68D541C85D26508E83_623893992 = "[]";
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            {
                int i = takeIndex;
                i = inc(i);
                {
                    Object e = items[i];
                    sb.append(e == this ? "(this Collection)" : e);
                    varB4EAC82CA7396A68D541C85D26508E83_1636111782 = sb.append(']').toString();
                    sb.append(',').append(' ');
                } 
            } 
        } 
        finally 
        {
            lock.unlock();
        } 
        String varA7E53CE21691AB073D9660D615818899_1866246457; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1866246457 = varB4EAC82CA7396A68D541C85D26508E83_623893992;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1866246457 = varB4EAC82CA7396A68D541C85D26508E83_1636111782;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1866246457.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1866246457;
        
        
        
        
            
            
                
            
            
            
                
                
                
                    
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.134 -0400", hash_original_method = "F51B80356A627C7A0236999C18E5CD11", hash_generated_method = "F78C939E2B4B3D1ADBF43F7724FCCEE6")
    public void clear() {
        final Object[] items = this.items;
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            {
                int i = takeIndex;
                int k = count;
                i = inc(i);
                items[i] = null;
            } 
            count = 0;
            putIndex = 0;
            takeIndex = 0;
            notFull.signalAll();
        } 
        finally 
        {
            lock.unlock();
        } 
        
        
        
        
        
            
                
            
            
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.135 -0400", hash_original_method = "9E472A4F64A42299055CA91AF4F47C7E", hash_generated_method = "B4C5F242767D20C93F129E3AE59D90A4")
    public int drainTo(Collection<? super E> c) {
        checkNotNull(c);
        {
            boolean var9AEE7ACC5B0D4AF26CA46D5AFC07CCF3_582805239 = (c == this);
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } 
        final Object[] items = this.items;
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            int i = takeIndex;
            int n = 0;
            int max = count;
            {
                c.add(this.<E>cast(items[i]));
                items[i] = null;
                i = inc(i);
            } 
            {
                count = 0;
                putIndex = 0;
                takeIndex = 0;
                notFull.signalAll();
            } 
        } 
        finally 
        {
            lock.unlock();
        } 
        addTaint(c.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_315758685 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_315758685;
        
        
        
            
        
        
        
        
            
            
            
            
                
                
                
                
            
            
                
                
                
                
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.136 -0400", hash_original_method = "0815910D9B0DDA035601CF2006E12E28", hash_generated_method = "F0A580C45F3B0DC56145149AA997EE85")
    public int drainTo(Collection<? super E> c, int maxElements) {
        checkNotNull(c);
        {
            boolean var9AEE7ACC5B0D4AF26CA46D5AFC07CCF3_1181002305 = (c == this);
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } 
        final Object[] items = this.items;
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            int i = takeIndex;
            int n = 0;
            int max;
            max = maxElements;
            max = count;
            {
                c.add(this.<E>cast(items[i]));
                items[i] = null;
                i = inc(i);
            } 
            {
                count -= n;
                takeIndex = i;
                notFull.signalAll();
            } 
        } 
        finally 
        {
            lock.unlock();
        } 
        addTaint(c.getTaint());
        addTaint(maxElements);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1960560018 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1960560018;
        
        
        
            
        
            
        
        
        
        
            
            
            
            
                
                
                
                
            
            
                
                
                
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.137 -0400", hash_original_method = "756A0449DBEE27B15290EF9912B6D98E", hash_generated_method = "A2F9452A4B37F23F12BF460D0231B7BE")
    public Iterator<E> iterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_2065580283 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2065580283 = new Itr();
        varB4EAC82CA7396A68D541C85D26508E83_2065580283.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2065580283;
        
        
    }

    
    private class Itr implements Iterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.137 -0400", hash_original_field = "2626772C17D90CF46BE4FE981FF30AC8", hash_generated_field = "08CB7792A99A5A14518905B73B1C610C")

        private int remaining;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.137 -0400", hash_original_field = "B6F75212F617C3E247C9474AFDA3B784", hash_generated_field = "034BA54D940F805E8FC30757D561B54A")

        private int nextIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.137 -0400", hash_original_field = "F0B5FE0A0CBE5E14CD07AF33AB522BBE", hash_generated_field = "97D8B84DA75A48FD27623CFC43E53C30")

        private E nextItem;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.137 -0400", hash_original_field = "A3375B9A5635553DD1D72BB32EB6E910", hash_generated_field = "5341FD00C1AC5699186B67EAA1884C7B")

        private E lastItem;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.137 -0400", hash_original_field = "BB3AE5C41B0FFE5CC0DAF60D4592524F", hash_generated_field = "E31E901BD2416B5BAAA1A584141A7427")

        private int lastRet;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.138 -0400", hash_original_method = "34A8A1361DC6E07DEA1D770580A406E1", hash_generated_method = "C27659E48E75DB5FC8BEE52F990CCC15")
          Itr() {
            final ReentrantLock lock = ArrayBlockingQueue.this.lock;
            lock.lock();
            try 
            {
                lastRet = -1;
                {
                    boolean varDEBA6385209CBA28FD0C5F5C6396BCCD_1442609245 = ((remaining = count) > 0);
                    nextItem = itemAt(nextIndex = takeIndex);
                } 
            } 
            finally 
            {
                lock.unlock();
            } 
            
            
            
            
                
                
                    
            
                
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.138 -0400", hash_original_method = "BD6D3436A392753337E742307DB75B57", hash_generated_method = "F2A1A288327F24E4B4E38F48137A70E9")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1587729408 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1587729408;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.140 -0400", hash_original_method = "707282FAA8902CEC9C63EE3C89931C62", hash_generated_method = "4C8BF6D308B1EB7E4E3EC2898B70A332")
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_1937988191 = null; 
            final ReentrantLock lock = ArrayBlockingQueue.this.lock;
            lock.lock();
            try 
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                lastRet = nextIndex;
                E x = itemAt(nextIndex);
                {
                    x = nextItem;
                    lastItem = null;
                } 
                lastItem = x;
                {
                    boolean var40DD84A561ABE2EDE6BEB0C7CCDFB796_1468241129 = (--remaining > 0 && 
                       (nextItem = itemAt(nextIndex = inc(nextIndex))) == null);
                    ;
                } 
                varB4EAC82CA7396A68D541C85D26508E83_1937988191 = x;
            } 
            finally 
            {
                lock.unlock();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1937988191.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1937988191;
            
            
            
            
                
                    
                
                
                
                    
                    
                
                
                    
                
                       
                    
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.143 -0400", hash_original_method = "E7345F06EBC3C2DA4E698FB7A5897ADC", hash_generated_method = "3A373563EE556F87C056CA9F9FE6D0CB")
        public void remove() {
            final ReentrantLock lock = ArrayBlockingQueue.this.lock;
            lock.lock();
            try 
            {
                int i = lastRet;
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
                lastRet = -1;
                E x = lastItem;
                lastItem = null;
                {
                    boolean removingHead = (i == takeIndex);
                    removeAt(i);
                    nextIndex = dec(nextIndex);
                } 
            } 
            finally 
            {
                lock.unlock();
            } 
            
            
            
            
                
                
                    
                
                
                
                
                    
                    
                    
                        
                
            
                
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:13.144 -0400", hash_original_field = "71B20139B7EBDC51889FB159BA77840C", hash_generated_field = "0F849197A37E65A00343ED59063639C5")

    private static final long serialVersionUID = -817911632652898426L;
}

