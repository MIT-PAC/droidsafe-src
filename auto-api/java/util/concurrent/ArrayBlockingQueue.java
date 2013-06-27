package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.concurrent.locks.*;
import java.util.*;

public class ArrayBlockingQueue<E> extends AbstractQueue<E> implements BlockingQueue<E>, java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.367 -0400", hash_original_field = "691D502CFD0E0626CD3B058E5682AD1C", hash_generated_field = "BAB14770993D8E8C5F571816E68BB451")

    Object[] items;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.367 -0400", hash_original_field = "248C717869EF457873D5265F0D566C26", hash_generated_field = "155CD9B83999F44788DDAFF138F1D62C")

    int takeIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.367 -0400", hash_original_field = "EC20CABCDA9500AB408F58648A4190A5", hash_generated_field = "C304AC129AAA2CC4EBBA14BAA5601D08")

    int putIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.367 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "B83BF7ED7F5719DA923E1BC0AC69952B")

    int count;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.367 -0400", hash_original_field = "DCE7C4174CE9323904A934A486C41288", hash_generated_field = "684903DA26FF3CD98DD43FF6C66C5020")

    ReentrantLock lock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.367 -0400", hash_original_field = "4D495F503708F3E21723219DA12E7651", hash_generated_field = "6208B332BB61DB5EFD3387E35BF3069A")

    private Condition notEmpty;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.367 -0400", hash_original_field = "8BBF6A14B0983B211D60B3FC3BF73A3F", hash_generated_field = "9BD2EF78405D878781918D2C46F5ACCE")

    private Condition notFull;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.371 -0400", hash_original_method = "989EAF8314C95E2BC3034097E1831933", hash_generated_method = "83B64C9C6E2AFE89CF5D0C45CAB4ECE4")
    public  ArrayBlockingQueue(int capacity) {
        this(capacity, false);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.372 -0400", hash_original_method = "D00F5C645B4A4E3D47EB794330FD0093", hash_generated_method = "0A473E5EB0452CD5D8C2AFBE5957D4FB")
    public  ArrayBlockingQueue(int capacity, boolean fair) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        this.items = new Object[capacity];
        lock = new ReentrantLock(fair);
        notEmpty = lock.newCondition();
        notFull =  lock.newCondition();
        // ---------- Original Method ----------
        //if (capacity <= 0)
            //throw new IllegalArgumentException();
        //this.items = new Object[capacity];
        //lock = new ReentrantLock(fair);
        //notEmpty = lock.newCondition();
        //notFull =  lock.newCondition();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.388 -0400", hash_original_method = "27F14E8862A13463ECADB9F13ABB8363", hash_generated_method = "0F5C5439002B5D701084D525C55666CE")
    public  ArrayBlockingQueue(int capacity, boolean fair,
                              Collection<? extends E> c) {
        this(capacity, fair);
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        try 
        {
            int i;
            i = 0;
            try 
            {
                {
                    Iterator<E> var334ED49EB23041C8D120547C1BB713D2_450944900 = (c).iterator();
                    var334ED49EB23041C8D120547C1BB713D2_450944900.hasNext();
                    E e = var334ED49EB23041C8D120547C1BB713D2_450944900.next();
                    {
                        checkNotNull(e);
                        items[i++] = e;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            catch (ArrayIndexOutOfBoundsException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
            count = i;
            putIndex = (i == capacity) ? 0 : i;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        addTaint(fair);
        addTaint(c.getTaint());
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //int i = 0;
            //try {
                //for (E e : c) {
                    //checkNotNull(e);
                    //items[i++] = e;
                //}
            //} catch (ArrayIndexOutOfBoundsException ex) {
                //throw new IllegalArgumentException();
            //}
            //count = i;
            //putIndex = (i == capacity) ? 0 : i;
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.391 -0400", hash_original_method = "225BF2AA9DF4D481E4497FC0C844BC07", hash_generated_method = "2FBF9474110690161B5A94C312D63103")
    final int inc(int i) {
        addTaint(i);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_980527769 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_980527769;
        // ---------- Original Method ----------
        //return (++i == items.length) ? 0 : i;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.391 -0400", hash_original_method = "3E735D41E2F85E8ACC700EB7ACA7DBFD", hash_generated_method = "5969FE3C994DD9A47CC82B000627F80B")
    final int dec(int i) {
        addTaint(i);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_772160353 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_772160353;
        // ---------- Original Method ----------
        //return ((i == 0) ? items.length : i) - 1;
    }

    
        @SuppressWarnings("unchecked")
    static <E> E cast(Object item) {
        return (E) item;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.398 -0400", hash_original_method = "D27765FC19695D3D1037FEAF928DE057", hash_generated_method = "FAC4B76A74F757632FBB744387808A4B")
    final E itemAt(int i) {
        E varB4EAC82CA7396A68D541C85D26508E83_70245242 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_70245242 = this.<E>cast(items[i]);
        addTaint(i);
        varB4EAC82CA7396A68D541C85D26508E83_70245242.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_70245242;
        // ---------- Original Method ----------
        //return this.<E>cast(items[i]);
    }

    
        private static void checkNotNull(Object v) {
        if (v == null)
            throw new NullPointerException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.399 -0400", hash_original_method = "7F66A086F3C39CFEE464DF3F42EF745A", hash_generated_method = "C732451D3875B8BA1917FD882A718428")
    private void insert(E x) {
        items[putIndex] = x;
        putIndex = inc(putIndex);
        notEmpty.signal();
        // ---------- Original Method ----------
        //items[putIndex] = x;
        //putIndex = inc(putIndex);
        //++count;
        //notEmpty.signal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.399 -0400", hash_original_method = "FAA6B2CA6161B01EDCE06644087258E9", hash_generated_method = "11EC8189C5F2376C743E632265B85EA0")
    private E extract() {
        E varB4EAC82CA7396A68D541C85D26508E83_1751791218 = null; //Variable for return #1
        Object[] items;
        items = this.items;
        E x;
        x = this.<E>cast(items[takeIndex]);
        items[takeIndex] = null;
        takeIndex = inc(takeIndex);
        notFull.signal();
        varB4EAC82CA7396A68D541C85D26508E83_1751791218 = x;
        varB4EAC82CA7396A68D541C85D26508E83_1751791218.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1751791218;
        // ---------- Original Method ----------
        //final Object[] items = this.items;
        //E x = this.<E>cast(items[takeIndex]);
        //items[takeIndex] = null;
        //takeIndex = inc(takeIndex);
        //--count;
        //notFull.signal();
        //return x;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.400 -0400", hash_original_method = "94E6DD980D252AA320ADEF879614EDE5", hash_generated_method = "E5EE2B9C36780B6234D7CC5A8D872390")
     void removeAt(int i) {
        Object[] items;
        items = this.items;
        {
            items[takeIndex] = null;
            takeIndex = inc(takeIndex);
        } //End block
        {
            {
                int nexti;
                nexti = inc(i);
                {
                    items[i] = items[nexti];
                    i = nexti;
                } //End block
                {
                    items[i] = null;
                    putIndex = i;
                } //End block
            } //End block
        } //End block
        notFull.signal();
        // ---------- Original Method ----------
        //final Object[] items = this.items;
        //if (i == takeIndex) {
            //items[takeIndex] = null;
            //takeIndex = inc(takeIndex);
        //} else {
            //for (;;) {
                //int nexti = inc(i);
                //if (nexti != putIndex) {
                    //items[i] = items[nexti];
                    //i = nexti;
                //} else {
                    //items[i] = null;
                    //putIndex = i;
                    //break;
                //}
            //}
        //}
        //--count;
        //notFull.signal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.401 -0400", hash_original_method = "656D7386EF8E1EB18507F4383E955E73", hash_generated_method = "CDCC4808D331BF4640E139DED8639723")
    public boolean add(E e) {
        boolean var2080333CA7DC32E7DD58836F2E497C8E_566005347 = (super.add(e));
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_695372015 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_695372015;
        // ---------- Original Method ----------
        //return super.add(e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.401 -0400", hash_original_method = "9E7F5A1AF35EF2F840CAB652EE8C4445", hash_generated_method = "E081ABA293574B87C8705674BF2FED28")
    public boolean offer(E e) {
        checkNotNull(e);
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        try 
        {
            {
                insert(e);
            } //End block
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        addTaint(e.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2060827292 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2060827292;
        // ---------- Original Method ----------
        //checkNotNull(e);
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //if (count == items.length)
                //return false;
            //else {
                //insert(e);
                //return true;
            //}
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.401 -0400", hash_original_method = "5E01CBD1D1D4C5DC328EF4CF7109CA33", hash_generated_method = "8C57788817364D01463926B368E87EC4")
    public void put(E e) throws InterruptedException {
        checkNotNull(e);
        ReentrantLock lock;
        lock = this.lock;
        lock.lockInterruptibly();
        try 
        {
            notFull.await();
            insert(e);
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        addTaint(e.getTaint());
        // ---------- Original Method ----------
        //checkNotNull(e);
        //final ReentrantLock lock = this.lock;
        //lock.lockInterruptibly();
        //try {
            //while (count == items.length)
                //notFull.await();
            //insert(e);
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.402 -0400", hash_original_method = "B8C47E86765DFB497203F72EAEF6D248", hash_generated_method = "1F482D0D3D283D9EF9FA9BC09AA7C15A")
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        checkNotNull(e);
        long nanos;
        nanos = unit.toNanos(timeout);
        ReentrantLock lock;
        lock = this.lock;
        lock.lockInterruptibly();
        try 
        {
            {
                nanos = notFull.awaitNanos(nanos);
            } //End block
            insert(e);
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        addTaint(e.getTaint());
        addTaint(timeout);
        addTaint(unit.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_211329099 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_211329099;
        // ---------- Original Method ----------
        //checkNotNull(e);
        //long nanos = unit.toNanos(timeout);
        //final ReentrantLock lock = this.lock;
        //lock.lockInterruptibly();
        //try {
            //while (count == items.length) {
                //if (nanos <= 0)
                    //return false;
                //nanos = notFull.awaitNanos(nanos);
            //}
            //insert(e);
            //return true;
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.431 -0400", hash_original_method = "0415B543E2D9F81F71C1F297B3EB3C5B", hash_generated_method = "9AF2ABE46CCA3B43B166130DEDD53B3F")
    public E poll() {
        E varB4EAC82CA7396A68D541C85D26508E83_21335998 = null; //Variable for return #1
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_21335998 = (count == 0) ? null : extract();
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_21335998.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_21335998;
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //return (count == 0) ? null : extract();
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.432 -0400", hash_original_method = "30071A1958BC767E727888E18C86B273", hash_generated_method = "C581CD770E067306306A5CAB4829F603")
    public E take() throws InterruptedException {
        E varB4EAC82CA7396A68D541C85D26508E83_2002011153 = null; //Variable for return #1
        ReentrantLock lock;
        lock = this.lock;
        lock.lockInterruptibly();
        try 
        {
            notEmpty.await();
            varB4EAC82CA7396A68D541C85D26508E83_2002011153 = extract();
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2002011153.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2002011153;
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lockInterruptibly();
        //try {
            //while (count == 0)
                //notEmpty.await();
            //return extract();
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.434 -0400", hash_original_method = "9A4759FF3B4CF20FAA7F6E911397CD3E", hash_generated_method = "7B072F9934CAA4215ED2A5B6B0D40E6F")
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        E varB4EAC82CA7396A68D541C85D26508E83_423920283 = null; //Variable for return #1
        E varB4EAC82CA7396A68D541C85D26508E83_2045286312 = null; //Variable for return #2
        long nanos;
        nanos = unit.toNanos(timeout);
        ReentrantLock lock;
        lock = this.lock;
        lock.lockInterruptibly();
        try 
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_423920283 = null;
                nanos = notEmpty.awaitNanos(nanos);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_2045286312 = extract();
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        addTaint(timeout);
        addTaint(unit.getTaint());
        E varA7E53CE21691AB073D9660D615818899_1508844406; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1508844406 = varB4EAC82CA7396A68D541C85D26508E83_423920283;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1508844406 = varB4EAC82CA7396A68D541C85D26508E83_2045286312;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1508844406.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1508844406;
        // ---------- Original Method ----------
        //long nanos = unit.toNanos(timeout);
        //final ReentrantLock lock = this.lock;
        //lock.lockInterruptibly();
        //try {
            //while (count == 0) {
                //if (nanos <= 0)
                    //return null;
                //nanos = notEmpty.awaitNanos(nanos);
            //}
            //return extract();
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.435 -0400", hash_original_method = "36198DC803CD2F28AA6354324378D8A6", hash_generated_method = "F2CDCB90980C5204F05902CD8CE5B0E9")
    public E peek() {
        E varB4EAC82CA7396A68D541C85D26508E83_873768849 = null; //Variable for return #1
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_873768849 = (count == 0) ? null : itemAt(takeIndex);
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_873768849.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_873768849;
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //return (count == 0) ? null : itemAt(takeIndex);
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.435 -0400", hash_original_method = "455EA274614F97D61B2EABEB4507FE65", hash_generated_method = "B5C6670638BCBB8B3197A0C495F6F144")
    public int size() {
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_356791565 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_356791565;
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //return count;
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.450 -0400", hash_original_method = "93162D5A121913041A27A55F13ABACF8", hash_generated_method = "FBDA172B91B9E1E0ADE0CF7C9E0D29DF")
    public int remainingCapacity() {
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_375005607 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_375005607;
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //return items.length - count;
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.450 -0400", hash_original_method = "DAEECD7AA7FBEB0DFD3FA22914451AA9", hash_generated_method = "52677896304EC6064829BF9F294F1EB5")
    public boolean remove(Object o) {
        Object[] items;
        items = this.items;
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        try 
        {
            {
                int i, k;
                i = takeIndex;
                k = count;
                i = inc(i);
                {
                    {
                        boolean var236AB91C5F60C89756F7224AEACDA86C_1449843778 = (o.equals(items[i]));
                        {
                            removeAt(i);
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1055632793 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1055632793;
        // ---------- Original Method ----------
        //if (o == null) return false;
        //final Object[] items = this.items;
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //for (int i = takeIndex, k = count; k > 0; i = inc(i), k--) {
                //if (o.equals(items[i])) {
                    //removeAt(i);
                    //return true;
                //}
            //}
            //return false;
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.452 -0400", hash_original_method = "BABF8DBF8C2C3831FF0E73AA93059482", hash_generated_method = "04130FAF497C3F6B7B2FC87E24E3D089")
    public boolean contains(Object o) {
        Object[] items;
        items = this.items;
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        try 
        {
            {
                int i, k;
                i = takeIndex;
                k = count;
                i = inc(i);
                {
                    boolean varFB370F6F5D0FE842A8BFC3F3EB196D0D_541723156 = (o.equals(items[i]));
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1902819608 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1902819608;
        // ---------- Original Method ----------
        //if (o == null) return false;
        //final Object[] items = this.items;
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //for (int i = takeIndex, k = count; k > 0; i = inc(i), k--)
                //if (o.equals(items[i]))
                    //return true;
            //return false;
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.454 -0400", hash_original_method = "75EA37BFFAA918A3594F9496C85F47EF", hash_generated_method = "4ED31B58207E9BE939C268FFDA738D29")
    public Object[] toArray() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_1432702786 = null; //Variable for return #1
        Object[] items;
        items = this.items;
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        try 
        {
            int count;
            count = this.count;
            Object[] a;
            a = new Object[count];
            {
                int i, k;
                i = takeIndex;
                k = 0;
                i = inc(i);
                a[k] = items[i];
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1432702786 = a;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1432702786.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1432702786;
        // ---------- Original Method ----------
        //final Object[] items = this.items;
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //final int count = this.count;
            //Object[] a = new Object[count];
            //for (int i = takeIndex, k = 0; k < count; i = inc(i), k++)
                //a[k] = items[i];
            //return a;
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.468 -0400", hash_original_method = "95E1CD553E699913E584434D85EF3537", hash_generated_method = "A20EE93EBF59C6334EA486680F90C488")
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        T[] varB4EAC82CA7396A68D541C85D26508E83_1544136972 = null; //Variable for return #1
        Object[] items;
        items = this.items;
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        try 
        {
            int count;
            count = this.count;
            int len;
            len = a.length;
            a = (T[])java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), count);
            {
                int i, k;
                i = takeIndex;
                k = 0;
                i = inc(i);
                a[k] = (T) items[i];
            } //End collapsed parenthetic
            a[count] = null;
            varB4EAC82CA7396A68D541C85D26508E83_1544136972 = a;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1544136972.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1544136972;
        // ---------- Original Method ----------
        //final Object[] items = this.items;
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //final int count = this.count;
            //final int len = a.length;
            //if (len < count)
                //a = (T[])java.lang.reflect.Array.newInstance(
                    //a.getClass().getComponentType(), count);
            //for (int i = takeIndex, k = 0; k < count; i = inc(i), k++)
                //a[k] = (T) items[i];
            //if (len > count)
                //a[count] = null;
            //return a;
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.474 -0400", hash_original_method = "21683449F727FF2B89133F444D211102", hash_generated_method = "441C6329C6FC4F6DA2AD59E9D08974F3")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1757273951 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_99534325 = null; //Variable for return #2
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        try 
        {
            int k;
            k = count;
            varB4EAC82CA7396A68D541C85D26508E83_1757273951 = "[]";
            StringBuilder sb;
            sb = new StringBuilder();
            sb.append('[');
            {
                int i;
                i = takeIndex;
                i = inc(i);
                {
                    Object e;
                    e = items[i];
                    sb.append(e == this ? "(this Collection)" : e);
                    varB4EAC82CA7396A68D541C85D26508E83_99534325 = sb.append(']').toString();
                    sb.append(',').append(' ');
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        String varA7E53CE21691AB073D9660D615818899_961310648; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_961310648 = varB4EAC82CA7396A68D541C85D26508E83_1757273951;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_961310648 = varB4EAC82CA7396A68D541C85D26508E83_99534325;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_961310648.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_961310648;
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //int k = count;
            //if (k == 0)
                //return "[]";
            //StringBuilder sb = new StringBuilder();
            //sb.append('[');
            //for (int i = takeIndex; ; i = inc(i)) {
                //Object e = items[i];
                //sb.append(e == this ? "(this Collection)" : e);
                //if (--k == 0)
                    //return sb.append(']').toString();
                //sb.append(',').append(' ');
            //}
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.485 -0400", hash_original_method = "F51B80356A627C7A0236999C18E5CD11", hash_generated_method = "EAE88CF02BAD489F081936083A8B580F")
    public void clear() {
        Object[] items;
        items = this.items;
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        try 
        {
            {
                int i, k;
                i = takeIndex;
                k = count;
                i = inc(i);
                items[i] = null;
            } //End collapsed parenthetic
            count = 0;
            putIndex = 0;
            takeIndex = 0;
            notFull.signalAll();
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        // ---------- Original Method ----------
        //final Object[] items = this.items;
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //for (int i = takeIndex, k = count; k > 0; i = inc(i), k--)
                //items[i] = null;
            //count = 0;
            //putIndex = 0;
            //takeIndex = 0;
            //notFull.signalAll();
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.487 -0400", hash_original_method = "9E472A4F64A42299055CA91AF4F47C7E", hash_generated_method = "82944E6011A57E4035D4572F43BEC4FE")
    public int drainTo(Collection<? super E> c) {
        checkNotNull(c);
        {
            boolean var9AEE7ACC5B0D4AF26CA46D5AFC07CCF3_1552794972 = (c == this);
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End collapsed parenthetic
        Object[] items;
        items = this.items;
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        try 
        {
            int i;
            i = takeIndex;
            int n;
            n = 0;
            int max;
            max = count;
            {
                c.add(this.<E>cast(items[i]));
                items[i] = null;
                i = inc(i);
            } //End block
            {
                count = 0;
                putIndex = 0;
                takeIndex = 0;
                notFull.signalAll();
            } //End block
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        addTaint(c.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1180513586 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1180513586;
        // ---------- Original Method ----------
        //checkNotNull(c);
        //if (c == this)
            //throw new IllegalArgumentException();
        //final Object[] items = this.items;
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //int i = takeIndex;
            //int n = 0;
            //int max = count;
            //while (n < max) {
                //c.add(this.<E>cast(items[i]));
                //items[i] = null;
                //i = inc(i);
                //++n;
            //}
            //if (n > 0) {
                //count = 0;
                //putIndex = 0;
                //takeIndex = 0;
                //notFull.signalAll();
            //}
            //return n;
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.497 -0400", hash_original_method = "0815910D9B0DDA035601CF2006E12E28", hash_generated_method = "355C0A9419237BFFE561F98827EF4DAB")
    public int drainTo(Collection<? super E> c, int maxElements) {
        checkNotNull(c);
        {
            boolean var9AEE7ACC5B0D4AF26CA46D5AFC07CCF3_245541530 = (c == this);
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End collapsed parenthetic
        Object[] items;
        items = this.items;
        ReentrantLock lock;
        lock = this.lock;
        lock.lock();
        try 
        {
            int i;
            i = takeIndex;
            int n;
            n = 0;
            int max;
            max = maxElements;
            max = count;
            {
                c.add(this.<E>cast(items[i]));
                items[i] = null;
                i = inc(i);
            } //End block
            {
                count -= n;
                takeIndex = i;
                notFull.signalAll();
            } //End block
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        addTaint(c.getTaint());
        addTaint(maxElements);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1469728746 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1469728746;
        // ---------- Original Method ----------
        //checkNotNull(c);
        //if (c == this)
            //throw new IllegalArgumentException();
        //if (maxElements <= 0)
            //return 0;
        //final Object[] items = this.items;
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //int i = takeIndex;
            //int n = 0;
            //int max = (maxElements < count) ? maxElements : count;
            //while (n < max) {
                //c.add(this.<E>cast(items[i]));
                //items[i] = null;
                //i = inc(i);
                //++n;
            //}
            //if (n > 0) {
                //count -= n;
                //takeIndex = i;
                //notFull.signalAll();
            //}
            //return n;
        //} finally {
            //lock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.498 -0400", hash_original_method = "756A0449DBEE27B15290EF9912B6D98E", hash_generated_method = "8093CB2B502770DE736E0A411ABF2633")
    public Iterator<E> iterator() {
        Iterator<E> varB4EAC82CA7396A68D541C85D26508E83_1363062530 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1363062530 = new Itr();
        varB4EAC82CA7396A68D541C85D26508E83_1363062530.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1363062530;
        // ---------- Original Method ----------
        //return new Itr();
    }

    
    private class Itr implements Iterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.498 -0400", hash_original_field = "2626772C17D90CF46BE4FE981FF30AC8", hash_generated_field = "08CB7792A99A5A14518905B73B1C610C")

        private int remaining;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.498 -0400", hash_original_field = "B6F75212F617C3E247C9474AFDA3B784", hash_generated_field = "034BA54D940F805E8FC30757D561B54A")

        private int nextIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.498 -0400", hash_original_field = "F0B5FE0A0CBE5E14CD07AF33AB522BBE", hash_generated_field = "97D8B84DA75A48FD27623CFC43E53C30")

        private E nextItem;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.498 -0400", hash_original_field = "A3375B9A5635553DD1D72BB32EB6E910", hash_generated_field = "5341FD00C1AC5699186B67EAA1884C7B")

        private E lastItem;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.498 -0400", hash_original_field = "BB3AE5C41B0FFE5CC0DAF60D4592524F", hash_generated_field = "E31E901BD2416B5BAAA1A584141A7427")

        private int lastRet;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.498 -0400", hash_original_method = "34A8A1361DC6E07DEA1D770580A406E1", hash_generated_method = "90CB5AA03CC2B31FBADB5240E632D5A0")
          Itr() {
            ReentrantLock lock;
            lock = ArrayBlockingQueue.this.lock;
            lock.lock();
            try 
            {
                lastRet = -1;
                {
                    boolean varDEBA6385209CBA28FD0C5F5C6396BCCD_1156818921 = ((remaining = count) > 0);
                    nextItem = itemAt(nextIndex = takeIndex);
                } //End collapsed parenthetic
            } //End block
            finally 
            {
                lock.unlock();
            } //End block
            // ---------- Original Method ----------
            //final ReentrantLock lock = ArrayBlockingQueue.this.lock;
            //lock.lock();
            //try {
                //lastRet = -1;
                //if ((remaining = count) > 0)
                    //nextItem = itemAt(nextIndex = takeIndex);
            //} finally {
                //lock.unlock();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.499 -0400", hash_original_method = "BD6D3436A392753337E742307DB75B57", hash_generated_method = "8A376496BAECA2B6828326CC6009FD8A")
        public boolean hasNext() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_568340139 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_568340139;
            // ---------- Original Method ----------
            //return remaining > 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.514 -0400", hash_original_method = "707282FAA8902CEC9C63EE3C89931C62", hash_generated_method = "CF7EF975DDEDDE98A6915C651683D517")
        public E next() {
            E varB4EAC82CA7396A68D541C85D26508E83_1893352826 = null; //Variable for return #1
            ReentrantLock lock;
            lock = ArrayBlockingQueue.this.lock;
            lock.lock();
            try 
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                lastRet = nextIndex;
                E x;
                x = itemAt(nextIndex);
                {
                    x = nextItem;
                    lastItem = null;
                } //End block
                lastItem = x;
                {
                    boolean var40DD84A561ABE2EDE6BEB0C7CCDFB796_1911527964 = (--remaining > 0 && 
                       (nextItem = itemAt(nextIndex = inc(nextIndex))) == null);
                    ;
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_1893352826 = x;
            } //End block
            finally 
            {
                lock.unlock();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1893352826.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1893352826;
            // ---------- Original Method ----------
            //final ReentrantLock lock = ArrayBlockingQueue.this.lock;
            //lock.lock();
            //try {
                //if (remaining <= 0)
                    //throw new NoSuchElementException();
                //lastRet = nextIndex;
                //E x = itemAt(nextIndex);  
                //if (x == null) {
                    //x = nextItem;         
                    //lastItem = null;      
                //}
                //else
                    //lastItem = x;
                //while (--remaining > 0 && 
                       //(nextItem = itemAt(nextIndex = inc(nextIndex))) == null)
                    //;
                //return x;
            //} finally {
                //lock.unlock();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.515 -0400", hash_original_method = "E7345F06EBC3C2DA4E698FB7A5897ADC", hash_generated_method = "ADB0536B0E1A39FD76A9AC9807A19F1E")
        public void remove() {
            ReentrantLock lock;
            lock = ArrayBlockingQueue.this.lock;
            lock.lock();
            try 
            {
                int i;
                i = lastRet;
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
                lastRet = -1;
                E x;
                x = lastItem;
                lastItem = null;
                {
                    boolean removingHead;
                    removingHead = (i == takeIndex);
                    removeAt(i);
                    nextIndex = dec(nextIndex);
                } //End block
            } //End block
            finally 
            {
                lock.unlock();
            } //End block
            // ---------- Original Method ----------
            //final ReentrantLock lock = ArrayBlockingQueue.this.lock;
            //lock.lock();
            //try {
                //int i = lastRet;
                //if (i == -1)
                    //throw new IllegalStateException();
                //lastRet = -1;
                //E x = lastItem;
                //lastItem = null;
                //if (x != null && x == items[i]) {
                    //boolean removingHead = (i == takeIndex);
                    //removeAt(i);
                    //if (!removingHead)
                        //nextIndex = dec(nextIndex);
                //}
            //} finally {
                //lock.unlock();
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:55.516 -0400", hash_original_field = "71B20139B7EBDC51889FB159BA77840C", hash_generated_field = "1B65E173C39F69338DC488B714712301")

    private static long serialVersionUID = -817911632652898426L;
}

