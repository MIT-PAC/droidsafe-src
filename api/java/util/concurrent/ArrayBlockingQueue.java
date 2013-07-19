package java.util.concurrent;

// Droidsafe Imports
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ArrayBlockingQueue<E> extends AbstractQueue<E> implements BlockingQueue<E>, java.io.Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.278 -0400", hash_original_field = "691D502CFD0E0626CD3B058E5682AD1C", hash_generated_field = "BAB14770993D8E8C5F571816E68BB451")

    Object[] items;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.278 -0400", hash_original_field = "248C717869EF457873D5265F0D566C26", hash_generated_field = "155CD9B83999F44788DDAFF138F1D62C")

    int takeIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.278 -0400", hash_original_field = "EC20CABCDA9500AB408F58648A4190A5", hash_generated_field = "C304AC129AAA2CC4EBBA14BAA5601D08")

    int putIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.278 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "B83BF7ED7F5719DA923E1BC0AC69952B")

    int count;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.278 -0400", hash_original_field = "DCE7C4174CE9323904A934A486C41288", hash_generated_field = "684903DA26FF3CD98DD43FF6C66C5020")

    ReentrantLock lock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.278 -0400", hash_original_field = "4D495F503708F3E21723219DA12E7651", hash_generated_field = "6208B332BB61DB5EFD3387E35BF3069A")

    private Condition notEmpty;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.278 -0400", hash_original_field = "8BBF6A14B0983B211D60B3FC3BF73A3F", hash_generated_field = "9BD2EF78405D878781918D2C46F5ACCE")

    private Condition notFull;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.279 -0400", hash_original_method = "989EAF8314C95E2BC3034097E1831933", hash_generated_method = "83B64C9C6E2AFE89CF5D0C45CAB4ECE4")
    public  ArrayBlockingQueue(int capacity) {
        this(capacity, false);
        addTaint(capacity);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.279 -0400", hash_original_method = "D00F5C645B4A4E3D47EB794330FD0093", hash_generated_method = "DE5BA143BA36F058685D94959E9418CD")
    public  ArrayBlockingQueue(int capacity, boolean fair) {
        if(capacity <= 0)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1879056103 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_1879056103.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_1879056103;
        }
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.280 -0400", hash_original_method = "27F14E8862A13463ECADB9F13ABB8363", hash_generated_method = "1A4AB006F45191EFDB1A5CC6399AE462")
    public  ArrayBlockingQueue(int capacity, boolean fair,
                              Collection<? extends E> c) {
        this(capacity, fair);
        addTaint(c.getTaint());
        addTaint(fair);
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            int i = 0;
            try 
            {
for(E e : c)
                {
                    checkNotNull(e);
                    items[i++] = e;
                } //End block
            } //End block
            catch (ArrayIndexOutOfBoundsException ex)
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_985961786 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_985961786.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_985961786;
            } //End block
            count = i;
            putIndex = (i == capacity) ? 0 : i;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.281 -0400", hash_original_method = "225BF2AA9DF4D481E4497FC0C844BC07", hash_generated_method = "2A0C3A9C4C07A709278032C5E51DBEAC")
    final int inc(int i) {
        addTaint(i);
        int varBA3B9C49CA451726D3D7186554707730_1271020570 = ((++i == items.length) ? 0 : i);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1238825418 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1238825418;
        // ---------- Original Method ----------
        //return (++i == items.length) ? 0 : i;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.281 -0400", hash_original_method = "3E735D41E2F85E8ACC700EB7ACA7DBFD", hash_generated_method = "1F9407E9BED595B12ECBEBD890A4D126")
    final int dec(int i) {
        addTaint(i);
        int var114DA9C8D681E8A923C713114451F831_1099038182 = (((i == 0) ? items.length : i) - 1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_277996051 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_277996051;
        // ---------- Original Method ----------
        //return ((i == 0) ? items.length : i) - 1;
    }

    
    @DSModeled(DSC.SAFE)
    @SuppressWarnings("unchecked")
    static <E> E cast(Object item) {
        return (E) item;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.281 -0400", hash_original_method = "D27765FC19695D3D1037FEAF928DE057", hash_generated_method = "BB239A07227E7E789B4350B4B973A036")
    final E itemAt(int i) {
        addTaint(i);
E var3C45A13E1663E5EB1E89D586B823C6D6_1237879280 =         this.<E>cast(items[i]);
        var3C45A13E1663E5EB1E89D586B823C6D6_1237879280.addTaint(taint);
        return var3C45A13E1663E5EB1E89D586B823C6D6_1237879280;
        // ---------- Original Method ----------
        //return this.<E>cast(items[i]);
    }

    
    @DSModeled(DSC.SAFE)
    private static void checkNotNull(Object v) {
        if (v == null)
            throw new NullPointerException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.282 -0400", hash_original_method = "7F66A086F3C39CFEE464DF3F42EF745A", hash_generated_method = "64F96985DE28D2DA338226764931CAD7")
    private void insert(E x) {
        items[putIndex] = x;
        putIndex = inc(putIndex);
        ++count;
        notEmpty.signal();
        // ---------- Original Method ----------
        //items[putIndex] = x;
        //putIndex = inc(putIndex);
        //++count;
        //notEmpty.signal();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.283 -0400", hash_original_method = "FAA6B2CA6161B01EDCE06644087258E9", hash_generated_method = "9C7EF44205F6DDD590CC7EFC544840EE")
    private E extract() {
        final Object[] items = this.items;
        E x = this.<E>cast(items[takeIndex]);
        items[takeIndex] = null;
        takeIndex = inc(takeIndex);
        --count;
        notFull.signal();
E varEA5659DA512DECF23E6D37EE8060D074_1681566646 =         x;
        varEA5659DA512DECF23E6D37EE8060D074_1681566646.addTaint(taint);
        return varEA5659DA512DECF23E6D37EE8060D074_1681566646;
        // ---------- Original Method ----------
        //final Object[] items = this.items;
        //E x = this.<E>cast(items[takeIndex]);
        //items[takeIndex] = null;
        //takeIndex = inc(takeIndex);
        //--count;
        //notFull.signal();
        //return x;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.283 -0400", hash_original_method = "94E6DD980D252AA320ADEF879614EDE5", hash_generated_method = "8F5B2102189F9A6F63B19017E904D742")
     void removeAt(int i) {
        final Object[] items = this.items;
        if(i == takeIndex)        
        {
            items[takeIndex] = null;
            takeIndex = inc(takeIndex);
        } //End block
        else
        {
for(;;)
            {
                int nexti = inc(i);
                if(nexti != putIndex)                
                {
                    items[i] = items[nexti];
                    i = nexti;
                } //End block
                else
                {
                    items[i] = null;
                    putIndex = i;
                    break;
                } //End block
            } //End block
        } //End block
        --count;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.284 -0400", hash_original_method = "656D7386EF8E1EB18507F4383E955E73", hash_generated_method = "D32E179367231EE161C610B489DD706E")
    public boolean add(E e) {
        addTaint(e.getTaint());
        boolean varA7CCA3687A894CC27F98CC580073D365_27730493 = (super.add(e));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_4991771 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_4991771;
        // ---------- Original Method ----------
        //return super.add(e);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.285 -0400", hash_original_method = "9E7F5A1AF35EF2F840CAB652EE8C4445", hash_generated_method = "04BE7FC78BC0C71D484D2BCA0C4444A2")
    public boolean offer(E e) {
        addTaint(e.getTaint());
        checkNotNull(e);
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            if(count == items.length)            
            {
            boolean var68934A3E9455FA72420237EB05902327_1399588784 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1527326965 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1527326965;
            }
            else
            {
                insert(e);
                boolean varB326B5062B2F0E69046810717534CB09_534239082 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_342217871 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_342217871;
            } //End block
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.285 -0400", hash_original_method = "5E01CBD1D1D4C5DC328EF4CF7109CA33", hash_generated_method = "1DB528BA746450D6D0E01C2616B96BAF")
    public void put(E e) throws InterruptedException {
        addTaint(e.getTaint());
        checkNotNull(e);
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try 
        {
            while
(count == items.length)            
            notFull.await();
            insert(e);
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.286 -0400", hash_original_method = "B8C47E86765DFB497203F72EAEF6D248", hash_generated_method = "4C681AF781DAAFBF789BE55735C9685C")
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        addTaint(unit.getTaint());
        addTaint(timeout);
        addTaint(e.getTaint());
        checkNotNull(e);
        long nanos = unit.toNanos(timeout);
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try 
        {
            while
(count == items.length)            
            {
                if(nanos <= 0)                
                {
                boolean var68934A3E9455FA72420237EB05902327_556870697 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1313990407 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1313990407;
                }
                nanos = notFull.awaitNanos(nanos);
            } //End block
            insert(e);
            boolean varB326B5062B2F0E69046810717534CB09_853059020 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1516548305 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1516548305;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.287 -0400", hash_original_method = "0415B543E2D9F81F71C1F297B3EB3C5B", hash_generated_method = "419BAD434B0B197BEA91D0F660AA0BF4")
    public E poll() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
E var49B3C758081A731D6E293307824D4F5A_720759225 =             (count == 0) ? null : extract();
            var49B3C758081A731D6E293307824D4F5A_720759225.addTaint(taint);
            return var49B3C758081A731D6E293307824D4F5A_720759225;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //return (count == 0) ? null : extract();
        //} finally {
            //lock.unlock();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.287 -0400", hash_original_method = "30071A1958BC767E727888E18C86B273", hash_generated_method = "28A68688C1BD1AAE61666C6D55DD22E7")
    public E take() throws InterruptedException {
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try 
        {
            while
(count == 0)            
            notEmpty.await();
E var87CCC06374952BB6688DD7356AF1A436_1406779335 =             extract();
            var87CCC06374952BB6688DD7356AF1A436_1406779335.addTaint(taint);
            return var87CCC06374952BB6688DD7356AF1A436_1406779335;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.288 -0400", hash_original_method = "9A4759FF3B4CF20FAA7F6E911397CD3E", hash_generated_method = "9CA36109B040AEC59C10D97DD2A72EF7")
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        addTaint(unit.getTaint());
        addTaint(timeout);
        long nanos = unit.toNanos(timeout);
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try 
        {
            while
(count == 0)            
            {
                if(nanos <= 0)                
                {
E var540C13E9E156B687226421B24F2DF178_127256557 =                 null;
                var540C13E9E156B687226421B24F2DF178_127256557.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_127256557;
                }
                nanos = notEmpty.awaitNanos(nanos);
            } //End block
E var87CCC06374952BB6688DD7356AF1A436_564916897 =             extract();
            var87CCC06374952BB6688DD7356AF1A436_564916897.addTaint(taint);
            return var87CCC06374952BB6688DD7356AF1A436_564916897;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.288 -0400", hash_original_method = "36198DC803CD2F28AA6354324378D8A6", hash_generated_method = "7CC2C4B6FC52066C4E4D59A56730F1A8")
    public E peek() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
E var65CCE84B9EFC74DB0B7D03429679E67A_438303008 =             (count == 0) ? null : itemAt(takeIndex);
            var65CCE84B9EFC74DB0B7D03429679E67A_438303008.addTaint(taint);
            return var65CCE84B9EFC74DB0B7D03429679E67A_438303008;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //return (count == 0) ? null : itemAt(takeIndex);
        //} finally {
            //lock.unlock();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.288 -0400", hash_original_method = "455EA274614F97D61B2EABEB4507FE65", hash_generated_method = "DBBA3949DD9E44B953D6402627F12EE3")
    public int size() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            int varE2942A04780E223B215EB8B663CF5353_573698721 = (count);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1157502029 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1157502029;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //return count;
        //} finally {
            //lock.unlock();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.289 -0400", hash_original_method = "93162D5A121913041A27A55F13ABACF8", hash_generated_method = "5D732E9A44376A526BFAE2FC5FA7DF5F")
    public int remainingCapacity() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            int var437CC1969DBDA270CF25BFC3C57A567D_877673139 = (items.length - count);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_778816851 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_778816851;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
        // ---------- Original Method ----------
        //final ReentrantLock lock = this.lock;
        //lock.lock();
        //try {
            //return items.length - count;
        //} finally {
            //lock.unlock();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.289 -0400", hash_original_method = "DAEECD7AA7FBEB0DFD3FA22914451AA9", hash_generated_method = "F663C8737C1DF81BC06E459921D06DDC")
    public boolean remove(Object o) {
        addTaint(o.getTaint());
        if(o == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_537634455 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_448635458 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_448635458;
        }
        final Object[] items = this.items;
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
for(int i = takeIndex, k = count;k > 0;i = inc(i),k--)
            {
                if(o.equals(items[i]))                
                {
                    removeAt(i);
                    boolean varB326B5062B2F0E69046810717534CB09_273905638 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_833433749 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_833433749;
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_762981411 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_975601173 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_975601173;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.289 -0400", hash_original_method = "BABF8DBF8C2C3831FF0E73AA93059482", hash_generated_method = "7040DC5AC8D69BC84A79FBBF86C973F5")
    public boolean contains(Object o) {
        addTaint(o.getTaint());
        if(o == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1177390779 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_108431409 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_108431409;
        }
        final Object[] items = this.items;
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
for(int i = takeIndex, k = count;k > 0;i = inc(i),k--)
            if(o.equals(items[i]))            
            {
            boolean varB326B5062B2F0E69046810717534CB09_18614552 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_626292449 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_626292449;
            }
            boolean var68934A3E9455FA72420237EB05902327_19656450 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1152132236 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1152132236;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.290 -0400", hash_original_method = "75EA37BFFAA918A3594F9496C85F47EF", hash_generated_method = "8854CD94FBE2C365BCAF468FE2E8CA34")
    public Object[] toArray() {
        final Object[] items = this.items;
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            final int count = this.count;
            Object[] a = new Object[count];
for(int i = takeIndex, k = 0;k < count;i = inc(i),k++)
            a[k] = items[i];
Object[] var3F5343BF1D849954A73F0BB303805FFD_338825171 =             a;
            var3F5343BF1D849954A73F0BB303805FFD_338825171.addTaint(taint);
            return var3F5343BF1D849954A73F0BB303805FFD_338825171;
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
            //final int count = this.count;
            //Object[] a = new Object[count];
            //for (int i = takeIndex, k = 0; k < count; i = inc(i), k++)
                //a[k] = items[i];
            //return a;
        //} finally {
            //lock.unlock();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.290 -0400", hash_original_method = "95E1CD553E699913E584434D85EF3537", hash_generated_method = "5C2B2E0C8958A722ACF17A9AFE742A50")
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        final Object[] items = this.items;
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            final int count = this.count;
            final int len = a.length;
            if(len < count)            
            a = (T[])java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), count);
for(int i = takeIndex, k = 0;k < count;i = inc(i),k++)
            a[k] = (T) items[i];
            if(len > count)            
            a[count] = null;
T[] var3F5343BF1D849954A73F0BB303805FFD_969682730 =             a;
            var3F5343BF1D849954A73F0BB303805FFD_969682730.addTaint(taint);
            return var3F5343BF1D849954A73F0BB303805FFD_969682730;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.291 -0400", hash_original_method = "21683449F727FF2B89133F444D211102", hash_generated_method = "0523B51E29F7140C2A91AE36E5A2BA8C")
    public String toString() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            int k = count;
            if(k == 0)            
            {
String varAA6F5C51D397701D3E65BDD2DF6A0CE1_1631770640 =             "[]";
            varAA6F5C51D397701D3E65BDD2DF6A0CE1_1631770640.addTaint(taint);
            return varAA6F5C51D397701D3E65BDD2DF6A0CE1_1631770640;
            }
            StringBuilder sb = new StringBuilder();
            sb.append('[');
for(int i = takeIndex;;i = inc(i))
            {
                Object e = items[i];
                sb.append(e == this ? "(this Collection)" : e);
                if(--k == 0)                
                {
String var9C07C753C7E9BC277E7521552478C668_1289507030 =                 sb.append(']').toString();
                var9C07C753C7E9BC277E7521552478C668_1289507030.addTaint(taint);
                return var9C07C753C7E9BC277E7521552478C668_1289507030;
                }
                sb.append(',').append(' ');
            } //End block
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.292 -0400", hash_original_method = "F51B80356A627C7A0236999C18E5CD11", hash_generated_method = "96AC7C404388A9DFF5C2AB73DCD0EE8A")
    public void clear() {
        final Object[] items = this.items;
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
for(int i = takeIndex, k = count;k > 0;i = inc(i),k--)
            items[i] = null;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.293 -0400", hash_original_method = "9E472A4F64A42299055CA91AF4F47C7E", hash_generated_method = "03C3747BD1238AA7A6B7E6E5CBDBA7B1")
    public int drainTo(Collection<? super E> c) {
        addTaint(c.getTaint());
        checkNotNull(c);
        if(c == this)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_506073165 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_506073165.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_506073165;
        }
        final Object[] items = this.items;
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            int i = takeIndex;
            int n = 0;
            int max = count;
            while
(n < max)            
            {
                c.add(this.<E>cast(items[i]));
                items[i] = null;
                i = inc(i);
                ++n;
            } //End block
            if(n > 0)            
            {
                count = 0;
                putIndex = 0;
                takeIndex = 0;
                notFull.signalAll();
            } //End block
            int var7B8B965AD4BCA0E41AB51DE7B31363A1_1392871519 = (n);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_242219351 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_242219351;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.293 -0400", hash_original_method = "0815910D9B0DDA035601CF2006E12E28", hash_generated_method = "F92398FA351C9F0671CB84E43E1538ED")
    public int drainTo(Collection<? super E> c, int maxElements) {
        addTaint(maxElements);
        addTaint(c.getTaint());
        checkNotNull(c);
        if(c == this)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_58583221 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_58583221.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_58583221;
        }
        if(maxElements <= 0)        
        {
        int varCFCD208495D565EF66E7DFF9F98764DA_583802373 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1476973500 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1476973500;
        }
        final Object[] items = this.items;
        final ReentrantLock lock = this.lock;
        lock.lock();
        try 
        {
            int i = takeIndex;
            int n = 0;
            int max = (maxElements < count) ? maxElements : count;
            while
(n < max)            
            {
                c.add(this.<E>cast(items[i]));
                items[i] = null;
                i = inc(i);
                ++n;
            } //End block
            if(n > 0)            
            {
                count -= n;
                takeIndex = i;
                notFull.signalAll();
            } //End block
            int var7B8B965AD4BCA0E41AB51DE7B31363A1_517765461 = (n);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_355191152 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_355191152;
        } //End block
        finally 
        {
            lock.unlock();
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.294 -0400", hash_original_method = "756A0449DBEE27B15290EF9912B6D98E", hash_generated_method = "CFE6B5FC0E76874884191A6FC87C5084")
    public Iterator<E> iterator() {
Iterator<E> varB10D928EC6DDAEBFD727C2EDCEC6EDF5_1534803965 =         new Itr();
        varB10D928EC6DDAEBFD727C2EDCEC6EDF5_1534803965.addTaint(taint);
        return varB10D928EC6DDAEBFD727C2EDCEC6EDF5_1534803965;
        // ---------- Original Method ----------
        //return new Itr();
    }

    
    private class Itr implements Iterator<E> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.294 -0400", hash_original_field = "2626772C17D90CF46BE4FE981FF30AC8", hash_generated_field = "08CB7792A99A5A14518905B73B1C610C")

        private int remaining;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.294 -0400", hash_original_field = "B6F75212F617C3E247C9474AFDA3B784", hash_generated_field = "034BA54D940F805E8FC30757D561B54A")

        private int nextIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.294 -0400", hash_original_field = "F0B5FE0A0CBE5E14CD07AF33AB522BBE", hash_generated_field = "97D8B84DA75A48FD27623CFC43E53C30")

        private E nextItem;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.294 -0400", hash_original_field = "A3375B9A5635553DD1D72BB32EB6E910", hash_generated_field = "5341FD00C1AC5699186B67EAA1884C7B")

        private E lastItem;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.294 -0400", hash_original_field = "BB3AE5C41B0FFE5CC0DAF60D4592524F", hash_generated_field = "E31E901BD2416B5BAAA1A584141A7427")

        private int lastRet;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.295 -0400", hash_original_method = "34A8A1361DC6E07DEA1D770580A406E1", hash_generated_method = "9B192081A4F4F6EC1238902C5B1DC882")
          Itr() {
            final ReentrantLock lock = ArrayBlockingQueue.this.lock;
            lock.lock();
            try 
            {
                lastRet = -1;
                if((remaining = count) > 0)                
                nextItem = itemAt(nextIndex = takeIndex);
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.295 -0400", hash_original_method = "BD6D3436A392753337E742307DB75B57", hash_generated_method = "1E5510986EFD7AF806125986F323E9C9")
        public boolean hasNext() {
            boolean varD90E782091E9A9F4CD91CC9C5582F361_1951614772 = (remaining > 0);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1089168394 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1089168394;
            // ---------- Original Method ----------
            //return remaining > 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.295 -0400", hash_original_method = "707282FAA8902CEC9C63EE3C89931C62", hash_generated_method = "A225EBD2E3B0BD0836698925CC660CB9")
        public E next() {
            final ReentrantLock lock = ArrayBlockingQueue.this.lock;
            lock.lock();
            try 
            {
                if(remaining <= 0)                
                {
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_193092382 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_193092382.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_193092382;
                }
                lastRet = nextIndex;
                E x = itemAt(nextIndex);
                if(x == null)                
                {
                    x = nextItem;
                    lastItem = null;
                } //End block
                else
                lastItem = x;
                while
(--remaining > 0 && 
                       (nextItem = itemAt(nextIndex = inc(nextIndex))) == null)                
                ;
E varEA5659DA512DECF23E6D37EE8060D074_185947305 =                 x;
                varEA5659DA512DECF23E6D37EE8060D074_185947305.addTaint(taint);
                return varEA5659DA512DECF23E6D37EE8060D074_185947305;
            } //End block
            finally 
            {
                lock.unlock();
            } //End block
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.296 -0400", hash_original_method = "E7345F06EBC3C2DA4E698FB7A5897ADC", hash_generated_method = "2A7BE45CD87BA5181CE3E7B8037A79C5")
        public void remove() {
            final ReentrantLock lock = ArrayBlockingQueue.this.lock;
            lock.lock();
            try 
            {
                int i = lastRet;
                if(i == -1)                
                {
                IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1888994645 = new IllegalStateException();
                varC311A989A119B96A6232C22ABFE87C25_1888994645.addTaint(taint);
                throw varC311A989A119B96A6232C22ABFE87C25_1888994645;
                }
                lastRet = -1;
                E x = lastItem;
                lastItem = null;
                if(x != null && x == items[i])                
                {
                    boolean removingHead = (i == takeIndex);
                    removeAt(i);
                    if(!removingHead)                    
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:13.296 -0400", hash_original_field = "71B20139B7EBDC51889FB159BA77840C", hash_generated_field = "0F849197A37E65A00343ED59063639C5")

    private static final long serialVersionUID = -817911632652898426L;
}

