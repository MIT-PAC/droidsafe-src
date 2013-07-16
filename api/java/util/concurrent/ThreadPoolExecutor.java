package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.concurrent.locks.*;
import java.util.concurrent.atomic.*;
import java.util.*;

public class ThreadPoolExecutor extends AbstractExecutorService {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.583 -0400", hash_original_field = "A307605A799A74057344483C24FB3CBD", hash_generated_field = "1E5D76E2038757171D1F1EFB86BB7B2D")

    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.583 -0400", hash_original_field = "AD0CB0F61A61787BC239059154A854CE", hash_generated_field = "9E38919357211CC9BEEC80B9F9218347")

    private BlockingQueue<Runnable> workQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.583 -0400", hash_original_field = "79D8A014138E753409EEB9BD3FB796A2", hash_generated_field = "7B35E916BB35C7F976B4653697B4DA98")

    private final ReentrantLock mainLock = new ReentrantLock();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.583 -0400", hash_original_field = "1BF38840E9A66810DC9BC3F81C6E2B56", hash_generated_field = "EB2024D5E063C0CD7389C2261AC46D0A")

    private final HashSet<Worker> workers = new HashSet<Worker>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.584 -0400", hash_original_field = "6F97F9147FB6F0EABAC633096CD156DF", hash_generated_field = "2C20C5A8E5FB5CFA430FBF7CD68E16F8")

    private final Condition termination = mainLock.newCondition();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.584 -0400", hash_original_field = "847B488AE80482898780783A82B6764E", hash_generated_field = "121D2FE9A0E8A1127142F5163851FF7A")

    private int largestPoolSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.584 -0400", hash_original_field = "3017365C67C7718D5147FA190DD40A62", hash_generated_field = "35D6F2A97FA4C37D9711DD0E18037068")

    private long completedTaskCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.584 -0400", hash_original_field = "DCEABFFDB4C91584FC9D3ABFD745936C", hash_generated_field = "33CDA4329AB239C031EC6036B92EA4D7")

    private volatile ThreadFactory threadFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.584 -0400", hash_original_field = "C1CBFE271A40788A00E8BF8574D94D4B", hash_generated_field = "A77EE44F4E847B2CFCF9F9BFF9F8D340")

    private volatile RejectedExecutionHandler handler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.584 -0400", hash_original_field = "66B6676E2358CA03897CC4A63783399D", hash_generated_field = "1EC333D36EC5007BBF0C2C3B15635A7F")

    private volatile long keepAliveTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.584 -0400", hash_original_field = "8479D8297F4B7D8A1CB6952389C8EDC1", hash_generated_field = "E539670BC9790CFFAAC6CA7187FC01F4")

    private volatile boolean allowCoreThreadTimeOut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.585 -0400", hash_original_field = "BC84A0387FED241C4B869E825402E08F", hash_generated_field = "FAC62E0577D05948399014C56DA3CCEB")

    private volatile int corePoolSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.585 -0400", hash_original_field = "54A9EC393DB750BE987C30FFF3A375D2", hash_generated_field = "6C06C7B0806878AD4FB9956F328CBE28")

    private volatile int maximumPoolSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.585 -0400", hash_original_method = "6852B7239AD6D12F00F6FD31EAEE07F2", hash_generated_method = "305BA5508432005CA7BC348706552D9A")
    public  ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
             Executors.defaultThreadFactory(), defaultHandler);
        addTaint(workQueue.getTaint());
        addTaint(unit.getTaint());
        addTaint(keepAliveTime);
        addTaint(maximumPoolSize);
        addTaint(corePoolSize);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.586 -0400", hash_original_method = "472CB7CD686E5ED3EB32346C564DBF00", hash_generated_method = "79A2CC9274E589573B24B77EC20D2DD0")
    public  ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              ThreadFactory threadFactory) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
             threadFactory, defaultHandler);
        addTaint(threadFactory.getTaint());
        addTaint(workQueue.getTaint());
        addTaint(unit.getTaint());
        addTaint(keepAliveTime);
        addTaint(maximumPoolSize);
        addTaint(corePoolSize);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.586 -0400", hash_original_method = "13BA0DF22A91EC098F651B146B1F0D91", hash_generated_method = "55396CB2562D680D75E8DA45E52B8B44")
    public  ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              RejectedExecutionHandler handler) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
             Executors.defaultThreadFactory(), handler);
        addTaint(handler.getTaint());
        addTaint(workQueue.getTaint());
        addTaint(unit.getTaint());
        addTaint(keepAliveTime);
        addTaint(maximumPoolSize);
        addTaint(corePoolSize);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.588 -0400", hash_original_method = "7927F5CAD81FDA69C812A57334363D0A", hash_generated_method = "53C09B1200C14575E7445104F7EB087A")
    public  ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              ThreadFactory threadFactory,
                              RejectedExecutionHandler handler) {
    if(corePoolSize < 0 ||
            maximumPoolSize <= 0 ||
            maximumPoolSize < corePoolSize ||
            keepAliveTime < 0)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_985134380 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_985134380.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_985134380;
        }
    if(workQueue == null || threadFactory == null || handler == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_77956679 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_77956679.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_77956679;
        }
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.workQueue = workQueue;
        this.keepAliveTime = unit.toNanos(keepAliveTime);
        this.threadFactory = threadFactory;
        this.handler = handler;
        // ---------- Original Method ----------
        //if (corePoolSize < 0 ||
            //maximumPoolSize <= 0 ||
            //maximumPoolSize < corePoolSize ||
            //keepAliveTime < 0)
            //throw new IllegalArgumentException();
        //if (workQueue == null || threadFactory == null || handler == null)
            //throw new NullPointerException();
        //this.corePoolSize = corePoolSize;
        //this.maximumPoolSize = maximumPoolSize;
        //this.workQueue = workQueue;
        //this.keepAliveTime = unit.toNanos(keepAliveTime);
        //this.threadFactory = threadFactory;
        //this.handler = handler;
    }

    
        @DSModeled(DSC.SAFE)
    private static int runStateOf(int c) {
        return c & ~CAPACITY;
    }

    
        @DSModeled(DSC.SAFE)
    private static int workerCountOf(int c) {
        return c & CAPACITY;
    }

    
        @DSModeled(DSC.SAFE)
    private static int ctlOf(int rs, int wc) {
        return rs | wc;
    }

    
        @DSModeled(DSC.SAFE)
    private static boolean runStateLessThan(int c, int s) {
        return c < s;
    }

    
        @DSModeled(DSC.SAFE)
    private static boolean runStateAtLeast(int c, int s) {
        return c >= s;
    }

    
        @DSModeled(DSC.SAFE)
    private static boolean isRunning(int c) {
        return c < SHUTDOWN;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.590 -0400", hash_original_method = "AB721E5F3628508DEF5AE872A937DFD4", hash_generated_method = "7C7A7163FA17EA2D35C896A6C4D7A07C")
    private boolean compareAndIncrementWorkerCount(int expect) {
        addTaint(expect);
        boolean var4CF03DB615690726105C2CA3787E5959_1667021061 = (ctl.compareAndSet(expect, expect + 1));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1772560921 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1772560921;
        // ---------- Original Method ----------
        //return ctl.compareAndSet(expect, expect + 1);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.590 -0400", hash_original_method = "046A4642208AB0946E7553D201BA8A62", hash_generated_method = "D9E883CCDEA25A33AA0AF2F73101847C")
    private boolean compareAndDecrementWorkerCount(int expect) {
        addTaint(expect);
        boolean varED355889F4D8EFE0D994F27983661DA2_236310502 = (ctl.compareAndSet(expect, expect - 1));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1550727310 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1550727310;
        // ---------- Original Method ----------
        //return ctl.compareAndSet(expect, expect - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.590 -0400", hash_original_method = "197D64850896CFE44F6E60A0B666E58B", hash_generated_method = "8F4A1F5693239AC1AA471391B29B19D0")
    private void decrementWorkerCount() {
        do {
            {
            } //End block
} while (! compareAndDecrementWorkerCount(ctl.get()));
        // ---------- Original Method ----------
        //do {} while (! compareAndDecrementWorkerCount(ctl.get()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.591 -0400", hash_original_method = "F2BE86117A689CA9DA89AB2ED7F58DB7", hash_generated_method = "E94285B230068A41C7D79FDF1F44BF21")
    private void advanceRunState(int targetState) {
        addTaint(targetState);
for(;;)
        {
            int c = ctl.get();
    if(runStateAtLeast(c, targetState) ||
                ctl.compareAndSet(c, ctlOf(targetState, workerCountOf(c))))            
            break;
        } //End block
        // ---------- Original Method ----------
        //for (;;) {
            //int c = ctl.get();
            //if (runStateAtLeast(c, targetState) ||
                //ctl.compareAndSet(c, ctlOf(targetState, workerCountOf(c))))
                //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.591 -0400", hash_original_method = "80042B52D4C8A465DC8857956BEE8BCA", hash_generated_method = "9A7627FDD53E3BC745D06C3F25D0AD71")
    final void tryTerminate() {
for(;;)
        {
            int c = ctl.get();
    if(isRunning(c) ||
                runStateAtLeast(c, TIDYING) ||
                (runStateOf(c) == SHUTDOWN && ! workQueue.isEmpty()))            
            return;
    if(workerCountOf(c) != 0)            
            {
                interruptIdleWorkers(ONLY_ONE);
                return;
            } //End block
            final ReentrantLock mainLock = this.mainLock;
            mainLock.lock();
            try 
            {
    if(ctl.compareAndSet(c, ctlOf(TIDYING, 0)))                
                {
                    try 
                    {
                        terminated();
                    } //End block
                    finally 
                    {
                        ctl.set(ctlOf(TERMINATED, 0));
                        termination.signalAll();
                    } //End block
                    return;
                } //End block
            } //End block
            finally 
            {
                mainLock.unlock();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.592 -0400", hash_original_method = "AA36F499694835EB802B188BC7C59A14", hash_generated_method = "06583D556678F9CA21D9CC973213DE1A")
    private void checkShutdownAccess() {
        SecurityManager security = System.getSecurityManager();
    if(security != null)        
        {
            security.checkPermission(shutdownPerm);
            final ReentrantLock mainLock = this.mainLock;
            mainLock.lock();
            try 
            {
for(Worker w : workers)
                security.checkAccess(w.thread);
            } //End block
            finally 
            {
                mainLock.unlock();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //SecurityManager security = System.getSecurityManager();
        //if (security != null) {
            //security.checkPermission(shutdownPerm);
            //final ReentrantLock mainLock = this.mainLock;
            //mainLock.lock();
            //try {
                //for (Worker w : workers)
                    //security.checkAccess(w.thread);
            //} finally {
                //mainLock.unlock();
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.592 -0400", hash_original_method = "3FD8BB870BC89D5588F0560753D4337F", hash_generated_method = "CD273599E9E004032DAC6E5A1850A95E")
    private void interruptWorkers() {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
for(Worker w : workers)
            {
                try 
                {
                    w.thread.interrupt();
                } //End block
                catch (SecurityException ignore)
                {
                } //End block
            } //End block
        } //End block
        finally 
        {
            mainLock.unlock();
        } //End block
        // ---------- Original Method ----------
        //final ReentrantLock mainLock = this.mainLock;
        //mainLock.lock();
        //try {
            //for (Worker w : workers) {
                //try {
                    //w.thread.interrupt();
                //} catch (SecurityException ignore) {
                //}
            //}
        //} finally {
            //mainLock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.593 -0400", hash_original_method = "C11819B67BF410300D59BD8104FE87A4", hash_generated_method = "5F5AE712F812F7CAF2B3399FA80C0F85")
    private void interruptIdleWorkers(boolean onlyOne) {
        addTaint(onlyOne);
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
for(Worker w : workers)
            {
                Thread t = w.thread;
    if(!t.isInterrupted() && w.tryLock())                
                {
                    try 
                    {
                        t.interrupt();
                    } //End block
                    catch (SecurityException ignore)
                    {
                    } //End block
                    finally 
                    {
                        w.unlock();
                    } //End block
                } //End block
    if(onlyOne)                
                break;
            } //End block
        } //End block
        finally 
        {
            mainLock.unlock();
        } //End block
        // ---------- Original Method ----------
        //final ReentrantLock mainLock = this.mainLock;
        //mainLock.lock();
        //try {
            //for (Worker w : workers) {
                //Thread t = w.thread;
                //if (!t.isInterrupted() && w.tryLock()) {
                    //try {
                        //t.interrupt();
                    //} catch (SecurityException ignore) {
                    //} finally {
                        //w.unlock();
                    //}
                //}
                //if (onlyOne)
                    //break;
            //}
        //} finally {
            //mainLock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.594 -0400", hash_original_method = "8AE0F2FE6E5901DBE1EC6FD71BA67D3B", hash_generated_method = "5A72F35E8F8382990E1FD3DE61AAA8EA")
    private void interruptIdleWorkers() {
        interruptIdleWorkers(false);
        // ---------- Original Method ----------
        //interruptIdleWorkers(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.594 -0400", hash_original_method = "41D1BD0CB95E0A52108020867995148C", hash_generated_method = "0166359A1E5FA720D76735778845B3E2")
    private void clearInterruptsForTaskRun() {
    if(runStateLessThan(ctl.get(), STOP) &&
            Thread.interrupted() &&
            runStateAtLeast(ctl.get(), STOP))        
        Thread.currentThread().interrupt();
        // ---------- Original Method ----------
        //if (runStateLessThan(ctl.get(), STOP) &&
            //Thread.interrupted() &&
            //runStateAtLeast(ctl.get(), STOP))
            //Thread.currentThread().interrupt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.594 -0400", hash_original_method = "DBD2AA47670972F837B77D54B6813996", hash_generated_method = "F680FA8890E9C8117B5621BD97E51319")
    final void reject(Runnable command) {
        addTaint(command.getTaint());
        handler.rejectedExecution(command, this);
        // ---------- Original Method ----------
        //handler.rejectedExecution(command, this);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.594 -0400", hash_original_method = "0A1F69177689475EC5D7889C7292052F", hash_generated_method = "A8810A0A581CC8BD0FA906871342B1C5")
     void onShutdown() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.595 -0400", hash_original_method = "270A029E5D11891F0D07089698FD1A31", hash_generated_method = "684CE2DEAD0BF4F8D784BC0D67223396")
    final boolean isRunningOrShutdown(boolean shutdownOK) {
        addTaint(shutdownOK);
        int rs = runStateOf(ctl.get());
        boolean var409AD087F5F43FEB88D877090C121B34_1312687393 = (rs == RUNNING || (rs == SHUTDOWN && shutdownOK));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_138988765 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_138988765;
        // ---------- Original Method ----------
        //int rs = runStateOf(ctl.get());
        //return rs == RUNNING || (rs == SHUTDOWN && shutdownOK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.595 -0400", hash_original_method = "4695ACF3E76D112BC6AF0E9543CB0BFB", hash_generated_method = "61458B656A58918160D671AA5EB6CC34")
    private List<Runnable> drainQueue() {
        BlockingQueue<Runnable> q = workQueue;
        List<Runnable> taskList = new ArrayList<Runnable>();
        q.drainTo(taskList);
    if(!q.isEmpty())        
        {
for(Runnable r : q.toArray(new Runnable[0]))
            {
    if(q.remove(r))                
                taskList.add(r);
            } //End block
        } //End block
List<Runnable> var8E14B675DD0E734D8359E9F7C3310A0E_1402132703 =         taskList;
        var8E14B675DD0E734D8359E9F7C3310A0E_1402132703.addTaint(taint);
        return var8E14B675DD0E734D8359E9F7C3310A0E_1402132703;
        // ---------- Original Method ----------
        //BlockingQueue<Runnable> q = workQueue;
        //List<Runnable> taskList = new ArrayList<Runnable>();
        //q.drainTo(taskList);
        //if (!q.isEmpty()) {
            //for (Runnable r : q.toArray(new Runnable[0])) {
                //if (q.remove(r))
                    //taskList.add(r);
            //}
        //}
        //return taskList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.596 -0400", hash_original_method = "7812A944CC6B2EE743043503F380EB35", hash_generated_method = "50F42BA99465ECA61D92D19E3937390E")
    private boolean addWorker(Runnable firstTask, boolean core) {
        addTaint(core);
        addTaint(firstTask.getTaint());
    retry        :
for(;;)
        {
            int c = ctl.get();
            int rs = runStateOf(c);
    if(rs >= SHUTDOWN &&
                ! (rs == SHUTDOWN &&
                   firstTask == null &&
                   ! workQueue.isEmpty()))            
            {
            boolean var68934A3E9455FA72420237EB05902327_1652048200 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_155687107 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_155687107;
            }
for(;;)
            {
                int wc = workerCountOf(c);
    if(wc >= CAPACITY ||
                    wc >= (core ? corePoolSize : maximumPoolSize))                
                {
                boolean var68934A3E9455FA72420237EB05902327_698670957 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_159632915 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_159632915;
                }
    if(compareAndIncrementWorkerCount(c))                
                break retry;
                c = ctl.get();
    if(runStateOf(c) != rs)                
                continue retry;
            } //End block
        } //End block
        Worker w = new Worker(firstTask);
        Thread t = w.thread;
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            int c = ctl.get();
            int rs = runStateOf(c);
    if(t == null ||
                (rs >= SHUTDOWN &&
                 ! (rs == SHUTDOWN &&
                    firstTask == null)))            
            {
                decrementWorkerCount();
                tryTerminate();
                boolean var68934A3E9455FA72420237EB05902327_354539936 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2069940510 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2069940510;
            } //End block
            workers.add(w);
            int s = workers.size();
    if(s > largestPoolSize)            
            largestPoolSize = s;
        } //End block
        finally 
        {
            mainLock.unlock();
        } //End block
        t.start();
    if(runStateOf(ctl.get()) == STOP && ! t.isInterrupted())        
        t.interrupt();
        boolean varB326B5062B2F0E69046810717534CB09_1811477851 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1047617947 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1047617947;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.598 -0400", hash_original_method = "98853BED73C436EB42A5D4B84EE5AAA8", hash_generated_method = "E47AC5707BABB6BA18F1E6E8F56B0B9B")
    private void processWorkerExit(Worker w, boolean completedAbruptly) {
        addTaint(completedAbruptly);
    if(completedAbruptly)        
        decrementWorkerCount();
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            completedTaskCount += w.completedTasks;
            workers.remove(w);
        } //End block
        finally 
        {
            mainLock.unlock();
        } //End block
        tryTerminate();
        int c = ctl.get();
    if(runStateLessThan(c, STOP))        
        {
    if(!completedAbruptly)            
            {
                int min = allowCoreThreadTimeOut ? 0 : corePoolSize;
    if(min == 0 && ! workQueue.isEmpty())                
                min = 1;
    if(workerCountOf(c) >= min)                
                return;
            } //End block
            addWorker(null, false);
        } //End block
        // ---------- Original Method ----------
        //if (completedAbruptly) 
            //decrementWorkerCount();
        //final ReentrantLock mainLock = this.mainLock;
        //mainLock.lock();
        //try {
            //completedTaskCount += w.completedTasks;
            //workers.remove(w);
        //} finally {
            //mainLock.unlock();
        //}
        //tryTerminate();
        //int c = ctl.get();
        //if (runStateLessThan(c, STOP)) {
            //if (!completedAbruptly) {
                //int min = allowCoreThreadTimeOut ? 0 : corePoolSize;
                //if (min == 0 && ! workQueue.isEmpty())
                    //min = 1;
                //if (workerCountOf(c) >= min)
                    //return; 
            //}
            //addWorker(null, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.599 -0400", hash_original_method = "CCE5E762047CA277EB153A60A9218EEF", hash_generated_method = "C710ECEBA351AC1E8CB75D07E602D562")
    private Runnable getTask() {
        boolean timedOut = false;
    retry        :
for(;;)
        {
            int c = ctl.get();
            int rs = runStateOf(c);
    if(rs >= SHUTDOWN && (rs >= STOP || workQueue.isEmpty()))            
            {
                decrementWorkerCount();
Runnable var540C13E9E156B687226421B24F2DF178_595613620 =                 null;
                var540C13E9E156B687226421B24F2DF178_595613620.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_595613620;
            } //End block
            boolean timed;
for(;;)
            {
                int wc = workerCountOf(c);
                timed = allowCoreThreadTimeOut || wc > corePoolSize;
    if(wc <= maximumPoolSize && ! (timedOut && timed))                
                break;
    if(compareAndDecrementWorkerCount(c))                
                {
Runnable var540C13E9E156B687226421B24F2DF178_434928509 =                 null;
                var540C13E9E156B687226421B24F2DF178_434928509.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_434928509;
                }
                c = ctl.get();
    if(runStateOf(c) != rs)                
                continue retry;
            } //End block
            try 
            {
                Runnable r = timed ?
                    workQueue.poll(keepAliveTime, TimeUnit.NANOSECONDS) :
                    workQueue.take();
    if(r != null)                
                {
Runnable var4C1F3C86A0E56B6E375080F5F710547E_510412530 =                 r;
                var4C1F3C86A0E56B6E375080F5F710547E_510412530.addTaint(taint);
                return var4C1F3C86A0E56B6E375080F5F710547E_510412530;
                }
                timedOut = true;
            } //End block
            catch (InterruptedException retry)
            {
                timedOut = false;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.600 -0400", hash_original_method = "55359692B6793E8A8B1383DAA231ACAC", hash_generated_method = "CC3669CF182FC580D945BC30071D8FE9")
    final void runWorker(Worker w) {
        addTaint(w.getTaint());
        Runnable task = w.firstTask;
        w.firstTask = null;
        boolean completedAbruptly = true;
        try 
        {
            while
(task != null || (task = getTask()) != null)            
            {
                w.lock();
                clearInterruptsForTaskRun();
                try 
                {
                    beforeExecute(w.thread, task);
                    Throwable thrown = null;
                    try 
                    {
                        task.run();
                    } //End block
                    catch (RuntimeException x)
                    {
                        thrown = x;
                        x.addTaint(taint);
                        throw x;
                    } //End block
                    catch (Error x)
                    {
                        thrown = x;
                        x.addTaint(taint);
                        throw x;
                    } //End block
                    catch (Throwable x)
                    {
                        thrown = x;
                        Error varD8FCF97463C4D7219486B460ADF7528B_1369974033 = new Error(x);
                        varD8FCF97463C4D7219486B460ADF7528B_1369974033.addTaint(taint);
                        throw varD8FCF97463C4D7219486B460ADF7528B_1369974033;
                    } //End block
                    finally 
                    {
                        afterExecute(task, thrown);
                    } //End block
                } //End block
                finally 
                {
                    task = null;
                    w.completedTasks++;
                    w.unlock();
                } //End block
            } //End block
            completedAbruptly = false;
        } //End block
        finally 
        {
            processWorkerExit(w, completedAbruptly);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.601 -0400", hash_original_method = "D2720E6C2ABD70ABBFB850D5E1C9152E", hash_generated_method = "11B6D78D16A3D64A8964A86EF69412DE")
    public void execute(Runnable command) {
        addTaint(command.getTaint());
    if(command == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_468015732 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_468015732.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_468015732;
        }
        int c = ctl.get();
    if(workerCountOf(c) < corePoolSize)        
        {
    if(addWorker(command, true))            
            return;
            c = ctl.get();
        } //End block
    if(isRunning(c) && workQueue.offer(command))        
        {
            int recheck = ctl.get();
    if(! isRunning(recheck) && remove(command))            
            reject(command);
            else
    if(workerCountOf(recheck) == 0)            
            addWorker(null, false);
        } //End block
        else
    if(!addWorker(command, false))        
        reject(command);
        // ---------- Original Method ----------
        //if (command == null)
            //throw new NullPointerException();
        //int c = ctl.get();
        //if (workerCountOf(c) < corePoolSize) {
            //if (addWorker(command, true))
                //return;
            //c = ctl.get();
        //}
        //if (isRunning(c) && workQueue.offer(command)) {
            //int recheck = ctl.get();
            //if (! isRunning(recheck) && remove(command))
                //reject(command);
            //else if (workerCountOf(recheck) == 0)
                //addWorker(null, false);
        //}
        //else if (!addWorker(command, false))
            //reject(command);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.602 -0400", hash_original_method = "B2E77DE3594C1CCAEA14C26F5B572C39", hash_generated_method = "556962D5741EED8D70DCDA38C6FF2F42")
    public void shutdown() {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            checkShutdownAccess();
            advanceRunState(SHUTDOWN);
            interruptIdleWorkers();
            onShutdown();
        } //End block
        finally 
        {
            mainLock.unlock();
        } //End block
        tryTerminate();
        // ---------- Original Method ----------
        //final ReentrantLock mainLock = this.mainLock;
        //mainLock.lock();
        //try {
            //checkShutdownAccess();
            //advanceRunState(SHUTDOWN);
            //interruptIdleWorkers();
            //onShutdown(); 
        //} finally {
            //mainLock.unlock();
        //}
        //tryTerminate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.602 -0400", hash_original_method = "D65CB76EC87687B7E50B9EEFFDD4C298", hash_generated_method = "4E1F88CFA64059A02C540FEBE1F8D1D8")
    public List<Runnable> shutdownNow() {
        List<Runnable> tasks;
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            checkShutdownAccess();
            advanceRunState(STOP);
            interruptWorkers();
            tasks = drainQueue();
        } //End block
        finally 
        {
            mainLock.unlock();
        } //End block
        tryTerminate();
List<Runnable> var7E53B1D2085D8C7AE88417ECCC5A0893_1787583479 =         tasks;
        var7E53B1D2085D8C7AE88417ECCC5A0893_1787583479.addTaint(taint);
        return var7E53B1D2085D8C7AE88417ECCC5A0893_1787583479;
        // ---------- Original Method ----------
        //List<Runnable> tasks;
        //final ReentrantLock mainLock = this.mainLock;
        //mainLock.lock();
        //try {
            //checkShutdownAccess();
            //advanceRunState(STOP);
            //interruptWorkers();
            //tasks = drainQueue();
        //} finally {
            //mainLock.unlock();
        //}
        //tryTerminate();
        //return tasks;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.603 -0400", hash_original_method = "968CAF504B3356CA71CED595275477F9", hash_generated_method = "87C9C80CCD045942E715C44607B5D8B0")
    public boolean isShutdown() {
        boolean var4F365FA39DD9B6B15FB3A09F0927D40E_374448476 = (! isRunning(ctl.get()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2086026616 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2086026616;
        // ---------- Original Method ----------
        //return ! isRunning(ctl.get());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.603 -0400", hash_original_method = "1B50F454F3FDC6963CA79768BA657116", hash_generated_method = "48D250B2F4C6424CCCDC7CBA7047287F")
    public boolean isTerminating() {
        int c = ctl.get();
        boolean var4D90DB0C0BB66D84B496970A6DBB406B_492078732 = (! isRunning(c) && runStateLessThan(c, TERMINATED));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_953788314 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_953788314;
        // ---------- Original Method ----------
        //int c = ctl.get();
        //return ! isRunning(c) && runStateLessThan(c, TERMINATED);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.603 -0400", hash_original_method = "9F60EBE4EAB8D07AF1E9485C91ACF37E", hash_generated_method = "623543AC919010E51E5F0AD8B7557F03")
    public boolean isTerminated() {
        boolean varD51322F449BE555009645EFF83261349_1753310655 = (runStateAtLeast(ctl.get(), TERMINATED));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_232959578 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_232959578;
        // ---------- Original Method ----------
        //return runStateAtLeast(ctl.get(), TERMINATED);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.604 -0400", hash_original_method = "D4E88A24481EFB5D05D58739D7C6B24D", hash_generated_method = "E44D4350B7176B754AA870414FBD7D28")
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        addTaint(unit.getTaint());
        addTaint(timeout);
        long nanos = unit.toNanos(timeout);
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
for(;;)
            {
    if(runStateAtLeast(ctl.get(), TERMINATED))                
                {
                boolean varB326B5062B2F0E69046810717534CB09_1832752173 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_584334814 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_584334814;
                }
    if(nanos <= 0)                
                {
                boolean var68934A3E9455FA72420237EB05902327_1706674011 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_555857840 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_555857840;
                }
                nanos = termination.awaitNanos(nanos);
            } //End block
        } //End block
        finally 
        {
            mainLock.unlock();
        } //End block
        // ---------- Original Method ----------
        //long nanos = unit.toNanos(timeout);
        //final ReentrantLock mainLock = this.mainLock;
        //mainLock.lock();
        //try {
            //for (;;) {
                //if (runStateAtLeast(ctl.get(), TERMINATED))
                    //return true;
                //if (nanos <= 0)
                    //return false;
                //nanos = termination.awaitNanos(nanos);
            //}
        //} finally {
            //mainLock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.605 -0400", hash_original_method = "54A2A12810CC337A284FDAF9A692A515", hash_generated_method = "57134A5D1161D28260EB34D287472E08")
    protected void finalize() {
        shutdown();
        // ---------- Original Method ----------
        //shutdown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.605 -0400", hash_original_method = "59E32FCC6E49B2109079BB0F3E4FFE2B", hash_generated_method = "A6E1BAD7793C8FEA9FCF77039D67184D")
    public void setThreadFactory(ThreadFactory threadFactory) {
    if(threadFactory == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1269109306 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_1269109306.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_1269109306;
        }
        this.threadFactory = threadFactory;
        // ---------- Original Method ----------
        //if (threadFactory == null)
            //throw new NullPointerException();
        //this.threadFactory = threadFactory;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.605 -0400", hash_original_method = "304653AC486A914BB8844AA1040FA7EB", hash_generated_method = "DFEE187B1CC880CEE5BD00DB8A8E2DC8")
    public ThreadFactory getThreadFactory() {
ThreadFactory var3580E08ED69603FA4F15CD8F2CD0B9D9_468285180 =         threadFactory;
        var3580E08ED69603FA4F15CD8F2CD0B9D9_468285180.addTaint(taint);
        return var3580E08ED69603FA4F15CD8F2CD0B9D9_468285180;
        // ---------- Original Method ----------
        //return threadFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.606 -0400", hash_original_method = "7F03D06860A87C46B9897C91E7329182", hash_generated_method = "B2EC4BABAD0E133EB82956B7175CF85C")
    public void setRejectedExecutionHandler(RejectedExecutionHandler handler) {
    if(handler == null)        
        {
        NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_241820937 = new NullPointerException();
        var7338BC9F48D81FE0BBD6183F4014DCC4_241820937.addTaint(taint);
        throw var7338BC9F48D81FE0BBD6183F4014DCC4_241820937;
        }
        this.handler = handler;
        // ---------- Original Method ----------
        //if (handler == null)
            //throw new NullPointerException();
        //this.handler = handler;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.606 -0400", hash_original_method = "6DBE484B7F2A61BE5C5EC698F3E381D8", hash_generated_method = "3FAEE695C855C4E7881691E0CC2A0CCF")
    public RejectedExecutionHandler getRejectedExecutionHandler() {
RejectedExecutionHandler var3E73215C2EA435E7F052AAB7C8597D27_2015421571 =         handler;
        var3E73215C2EA435E7F052AAB7C8597D27_2015421571.addTaint(taint);
        return var3E73215C2EA435E7F052AAB7C8597D27_2015421571;
        // ---------- Original Method ----------
        //return handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.607 -0400", hash_original_method = "753479E48A5DF49EEF8BAF55BE437F30", hash_generated_method = "121610753AE7AF7A2F8F658723A34EDD")
    public void setCorePoolSize(int corePoolSize) {
    if(corePoolSize < 0)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1388966746 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_1388966746.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_1388966746;
        }
        int delta = corePoolSize - this.corePoolSize;
        this.corePoolSize = corePoolSize;
    if(workerCountOf(ctl.get()) > corePoolSize)        
        interruptIdleWorkers();
        else
    if(delta > 0)        
        {
            int k = Math.min(delta, workQueue.size());
            while
(k-- > 0 && addWorker(null, true))            
            {
    if(workQueue.isEmpty())                
                break;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (corePoolSize < 0)
            //throw new IllegalArgumentException();
        //int delta = corePoolSize - this.corePoolSize;
        //this.corePoolSize = corePoolSize;
        //if (workerCountOf(ctl.get()) > corePoolSize)
            //interruptIdleWorkers();
        //else if (delta > 0) {
            //int k = Math.min(delta, workQueue.size());
            //while (k-- > 0 && addWorker(null, true)) {
                //if (workQueue.isEmpty())
                    //break;
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.607 -0400", hash_original_method = "51C354BC1AFFD9D1E19ED52BB81EBE2C", hash_generated_method = "9757D55B49C83EE4A96651E2FD6500F3")
    public int getCorePoolSize() {
        int varBC84A0387FED241C4B869E825402E08F_712704149 = (corePoolSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1294089817 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1294089817;
        // ---------- Original Method ----------
        //return corePoolSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.608 -0400", hash_original_method = "C3B1E657CEA1E5B0B9267C982B6F89C3", hash_generated_method = "7C61B047615865D51C78165B29AE4455")
    public boolean prestartCoreThread() {
        boolean var056123DD3251F7BE5F6FD042E93694DE_451940656 = (workerCountOf(ctl.get()) < corePoolSize &&
            addWorker(null, true));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1413580155 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1413580155;
        // ---------- Original Method ----------
        //return workerCountOf(ctl.get()) < corePoolSize &&
            //addWorker(null, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.608 -0400", hash_original_method = "BD3CEF4F9337B2BC7C235E398D43BE2A", hash_generated_method = "8C578317D532F80EF5DB6C48779259ED")
    public int prestartAllCoreThreads() {
        int n = 0;
        while
(addWorker(null, true))        
        ++n;
        int var7B8B965AD4BCA0E41AB51DE7B31363A1_1803674214 = (n);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1296551592 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1296551592;
        // ---------- Original Method ----------
        //int n = 0;
        //while (addWorker(null, true))
            //++n;
        //return n;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.609 -0400", hash_original_method = "B47D14DD952D3505364B334F55BDAD78", hash_generated_method = "65C01DB0019D91AE7719F4DF822477C6")
    public boolean allowsCoreThreadTimeOut() {
        boolean var8479D8297F4B7D8A1CB6952389C8EDC1_1966400091 = (allowCoreThreadTimeOut);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2099909030 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2099909030;
        // ---------- Original Method ----------
        //return allowCoreThreadTimeOut;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.609 -0400", hash_original_method = "3CB040DA26A3A7AB5E245CC61764B17D", hash_generated_method = "60FF6CC8724793E872E5CE2DF7C9D47D")
    public void allowCoreThreadTimeOut(boolean value) {
    if(value && keepAliveTime <= 0)        
        {
        IllegalArgumentException var22407D42BA6C8F83A05E40192C1E9DCA_1695120464 = new IllegalArgumentException("Core threads must have nonzero keep alive times");
        var22407D42BA6C8F83A05E40192C1E9DCA_1695120464.addTaint(taint);
        throw var22407D42BA6C8F83A05E40192C1E9DCA_1695120464;
        }
    if(value != allowCoreThreadTimeOut)        
        {
            allowCoreThreadTimeOut = value;
    if(value)            
            interruptIdleWorkers();
        } //End block
        // ---------- Original Method ----------
        //if (value && keepAliveTime <= 0)
            //throw new IllegalArgumentException("Core threads must have nonzero keep alive times");
        //if (value != allowCoreThreadTimeOut) {
            //allowCoreThreadTimeOut = value;
            //if (value)
                //interruptIdleWorkers();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.610 -0400", hash_original_method = "21349012A93D2851376CF1101665B5CB", hash_generated_method = "0B2F66596554CFA73BCACD51C761233B")
    public void setMaximumPoolSize(int maximumPoolSize) {
    if(maximumPoolSize <= 0 || maximumPoolSize < corePoolSize)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1693783934 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_1693783934.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_1693783934;
        }
        this.maximumPoolSize = maximumPoolSize;
    if(workerCountOf(ctl.get()) > maximumPoolSize)        
        interruptIdleWorkers();
        // ---------- Original Method ----------
        //if (maximumPoolSize <= 0 || maximumPoolSize < corePoolSize)
            //throw new IllegalArgumentException();
        //this.maximumPoolSize = maximumPoolSize;
        //if (workerCountOf(ctl.get()) > maximumPoolSize)
            //interruptIdleWorkers();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.610 -0400", hash_original_method = "4164BA9A7B4677354D8831E6C94ADF71", hash_generated_method = "F5CB28116E84E1B887F12E4CF21B7724")
    public int getMaximumPoolSize() {
        int var54A9EC393DB750BE987C30FFF3A375D2_672825829 = (maximumPoolSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1580543255 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1580543255;
        // ---------- Original Method ----------
        //return maximumPoolSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.611 -0400", hash_original_method = "863FC09A28296060918F86FB184DF489", hash_generated_method = "1715B9024AFDC396D692FE300BCC8B5C")
    public void setKeepAliveTime(long time, TimeUnit unit) {
        addTaint(unit.getTaint());
        addTaint(time);
    if(time < 0)        
        {
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_221842364 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_221842364.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_221842364;
        }
    if(time == 0 && allowsCoreThreadTimeOut())        
        {
        IllegalArgumentException var22407D42BA6C8F83A05E40192C1E9DCA_1951576611 = new IllegalArgumentException("Core threads must have nonzero keep alive times");
        var22407D42BA6C8F83A05E40192C1E9DCA_1951576611.addTaint(taint);
        throw var22407D42BA6C8F83A05E40192C1E9DCA_1951576611;
        }
        long keepAliveTime = unit.toNanos(time);
        long delta = keepAliveTime - this.keepAliveTime;
        this.keepAliveTime = keepAliveTime;
    if(delta < 0)        
        interruptIdleWorkers();
        // ---------- Original Method ----------
        //if (time < 0)
            //throw new IllegalArgumentException();
        //if (time == 0 && allowsCoreThreadTimeOut())
            //throw new IllegalArgumentException("Core threads must have nonzero keep alive times");
        //long keepAliveTime = unit.toNanos(time);
        //long delta = keepAliveTime - this.keepAliveTime;
        //this.keepAliveTime = keepAliveTime;
        //if (delta < 0)
            //interruptIdleWorkers();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.612 -0400", hash_original_method = "DF59E7D78F54A4D1FBC20C042F5F1838", hash_generated_method = "221B3BC0F58521E1A7FC9BC516204E27")
    public long getKeepAliveTime(TimeUnit unit) {
        addTaint(unit.getTaint());
        long var9E239AE39DEF01474F384A33B72F0A5A_90526390 = (unit.convert(keepAliveTime, TimeUnit.NANOSECONDS));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1055812317 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1055812317;
        // ---------- Original Method ----------
        //return unit.convert(keepAliveTime, TimeUnit.NANOSECONDS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.612 -0400", hash_original_method = "BD8FCC0E1F95E7B090761BC333422796", hash_generated_method = "7731ED36C866FD6B8CA525D01B7310CA")
    public BlockingQueue<Runnable> getQueue() {
BlockingQueue<Runnable> var29887FCBEA17534A0106FF38266D9590_1363903281 =         workQueue;
        var29887FCBEA17534A0106FF38266D9590_1363903281.addTaint(taint);
        return var29887FCBEA17534A0106FF38266D9590_1363903281;
        // ---------- Original Method ----------
        //return workQueue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.613 -0400", hash_original_method = "79BF7D79C72AB53C9D385B8F29AB696D", hash_generated_method = "1B65F23B680DB2697CCEE05B28656F98")
    public boolean remove(Runnable task) {
        addTaint(task.getTaint());
        boolean removed = workQueue.remove(task);
        tryTerminate();
        boolean varB07286EBBB5BC7AA91CC3EAA8BC19711_1273007518 = (removed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1592929577 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1592929577;
        // ---------- Original Method ----------
        //boolean removed = workQueue.remove(task);
        //tryTerminate();
        //return removed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.613 -0400", hash_original_method = "9B9E8DAAF98D7F6DDC91DC997B50219A", hash_generated_method = "ABF576AEFD432A519C9D289736A72416")
    public void purge() {
        final BlockingQueue<Runnable> q = workQueue;
        try 
        {
            Iterator<Runnable> it = q.iterator();
            while
(it.hasNext())            
            {
                Runnable r = it.next();
    if(r instanceof Future<?> && ((Future<?>)r).isCancelled())                
                it.remove();
            } //End block
        } //End block
        catch (ConcurrentModificationException fallThrough)
        {
for(Object r : q.toArray())
    if(r instanceof Future<?> && ((Future<?>)r).isCancelled())            
            q.remove(r);
        } //End block
        tryTerminate();
        // ---------- Original Method ----------
        //final BlockingQueue<Runnable> q = workQueue;
        //try {
            //Iterator<Runnable> it = q.iterator();
            //while (it.hasNext()) {
                //Runnable r = it.next();
                //if (r instanceof Future<?> && ((Future<?>)r).isCancelled())
                    //it.remove();
            //}
        //} catch (ConcurrentModificationException fallThrough) {
            //for (Object r : q.toArray())
                //if (r instanceof Future<?> && ((Future<?>)r).isCancelled())
                    //q.remove(r);
        //}
        //tryTerminate();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.614 -0400", hash_original_method = "4852DC9A347396E4E4A26FF1AFDF98FD", hash_generated_method = "60B66A944AD68979371346B6C2D01C73")
    public int getPoolSize() {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            int varD7ECB24D2269806139C1E8F8BBCAD3BD_1612125784 = (runStateAtLeast(ctl.get(), TIDYING) ? 0
                : workers.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1712142736 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1712142736;
        } //End block
        finally 
        {
            mainLock.unlock();
        } //End block
        // ---------- Original Method ----------
        //final ReentrantLock mainLock = this.mainLock;
        //mainLock.lock();
        //try {
            //return runStateAtLeast(ctl.get(), TIDYING) ? 0
                //: workers.size();
        //} finally {
            //mainLock.unlock();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.614 -0400", hash_original_method = "F897DAAB3F6E4FA542BB8276CD2A7AD3", hash_generated_method = "1BF9377A45799DF42ED12E4EDC06898A")
    public int getActiveCount() {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            int n = 0;
for(Worker w : workers)
    if(w.isLocked())            
            ++n;
            int var7B8B965AD4BCA0E41AB51DE7B31363A1_1382184709 = (n);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_102420271 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_102420271;
        } //End block
        finally 
        {
            mainLock.unlock();
        } //End block
        // ---------- Original Method ----------
        //final ReentrantLock mainLock = this.mainLock;
        //mainLock.lock();
        //try {
            //int n = 0;
            //for (Worker w : workers)
                //if (w.isLocked())
                    //++n;
            //return n;
        //} finally {
            //mainLock.unlock();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.615 -0400", hash_original_method = "B4A579D5588949E5556CF38ABCB55065", hash_generated_method = "C686F247C306374C56A269B50D9C0BF7")
    public int getLargestPoolSize() {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            int var847B488AE80482898780783A82B6764E_492278665 = (largestPoolSize);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_908281446 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_908281446;
        } //End block
        finally 
        {
            mainLock.unlock();
        } //End block
        // ---------- Original Method ----------
        //final ReentrantLock mainLock = this.mainLock;
        //mainLock.lock();
        //try {
            //return largestPoolSize;
        //} finally {
            //mainLock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.615 -0400", hash_original_method = "145E6751E1E0E0F3E4FA35DB76B7EDE5", hash_generated_method = "03937CB32A9228BF0A6321D123FEB6A7")
    public long getTaskCount() {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            long n = completedTaskCount;
for(Worker w : workers)
            {
                n += w.completedTasks;
    if(w.isLocked())                
                ++n;
            } //End block
            long var3FBE1EF47BEF7B991B1CDF7AE8CE1157_2109829777 = (n + workQueue.size());
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1116840771 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1116840771;
        } //End block
        finally 
        {
            mainLock.unlock();
        } //End block
        // ---------- Original Method ----------
        //final ReentrantLock mainLock = this.mainLock;
        //mainLock.lock();
        //try {
            //long n = completedTaskCount;
            //for (Worker w : workers) {
                //n += w.completedTasks;
                //if (w.isLocked())
                    //++n;
            //}
            //return n + workQueue.size();
        //} finally {
            //mainLock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.616 -0400", hash_original_method = "C21C1799DAC41B07982333C8F3E02012", hash_generated_method = "D7E1DE0B9B01F51DAF35C3504FB026CF")
    public long getCompletedTaskCount() {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            long n = completedTaskCount;
for(Worker w : workers)
            n += w.completedTasks;
            long var7B8B965AD4BCA0E41AB51DE7B31363A1_149477489 = (n);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_965655161 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_965655161;
        } //End block
        finally 
        {
            mainLock.unlock();
        } //End block
        // ---------- Original Method ----------
        //final ReentrantLock mainLock = this.mainLock;
        //mainLock.lock();
        //try {
            //long n = completedTaskCount;
            //for (Worker w : workers)
                //n += w.completedTasks;
            //return n;
        //} finally {
            //mainLock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.617 -0400", hash_original_method = "AA5F5BF44F4DA05ED8C1D4957936AC31", hash_generated_method = "86EEBC73E04B63369B8E13C6D7FBE873")
    public String toString() {
        long ncompleted;
        int nworkers;
        int nactive;
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            ncompleted = completedTaskCount;
            nactive = 0;
            nworkers = workers.size();
for(Worker w : workers)
            {
                ncompleted += w.completedTasks;
    if(w.isLocked())                
                ++nactive;
            } //End block
        } //End block
        finally 
        {
            mainLock.unlock();
        } //End block
        int c = ctl.get();
        String rs = (runStateLessThan(c, SHUTDOWN) ? "Running" :
                     (runStateAtLeast(c, TERMINATED) ? "Terminated" :
                      "Shutting down"));
String var29FB64F814595F23DD616FE19257F50F_1391862596 =         super.toString() +
            "[" + rs +
            ", pool size = " + nworkers +
            ", active threads = " + nactive +
            ", queued tasks = " + workQueue.size() +
            ", completed tasks = " + ncompleted +
            "]";
        var29FB64F814595F23DD616FE19257F50F_1391862596.addTaint(taint);
        return var29FB64F814595F23DD616FE19257F50F_1391862596;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.618 -0400", hash_original_method = "4C3878CDFFA0878930C89982189B5032", hash_generated_method = "56B6C8F5D1AFC7ADF196D539D3B9EE18")
    protected void beforeExecute(Thread t, Runnable r) {
        addTaint(r.getTaint());
        addTaint(t.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.618 -0400", hash_original_method = "1E835AC60F46FC4FB8E958FFB42880D4", hash_generated_method = "03812D400E0817EB73EE3728ED506683")
    protected void afterExecute(Runnable r, Throwable t) {
        addTaint(t.getTaint());
        addTaint(r.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.618 -0400", hash_original_method = "A29D7F7280B94AB8E3FBFAF6674D4BBC", hash_generated_method = "F157B5EF4A6890FC5741BB31F75810D9")
    protected void terminated() {
        // ---------- Original Method ----------
    }

    
    private final class Worker extends AbstractQueuedSynchronizer implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.618 -0400", hash_original_field = "DC127F5D2483352FD20EADDB38FEB6D2", hash_generated_field = "AB87C4F6E5547EBD7483F34732EA576D")

        Thread thread;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.619 -0400", hash_original_field = "AB088EE69C51E9415A270FBD75F5B952", hash_generated_field = "52D2DAE86CEE20DA5D093E6C8E8D890A")

        Runnable firstTask;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.619 -0400", hash_original_field = "3537605F39622BC6E15B1019401ED976", hash_generated_field = "A27B0F0FE609EB920C0300ECD3CAA2E3")

        volatile long completedTasks;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.619 -0400", hash_original_method = "8E628C9261C64BEE296D97D919DD4FB9", hash_generated_method = "4DEC29ECDD14EB9919329B70C54FB56D")
          Worker(Runnable firstTask) {
            this.firstTask = firstTask;
            this.thread = getThreadFactory().newThread(this);
            // ---------- Original Method ----------
            //this.firstTask = firstTask;
            //this.thread = getThreadFactory().newThread(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.619 -0400", hash_original_method = "776DC8B2F80D9EC817EF7446A13B40B9", hash_generated_method = "1D172B8AE706040037220A6FE99238AC")
        public void run() {
            runWorker(this);
            // ---------- Original Method ----------
            //runWorker(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.620 -0400", hash_original_method = "C9E6BAFAC050F423C4392C73A0972F98", hash_generated_method = "96FDE3C9C9C4C2137739386913F934B7")
        protected boolean isHeldExclusively() {
            boolean varC84F38E8FDD2496C130BD8B8E93D2156_1436841455 = (getState() == 1);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_589163411 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_589163411;
            // ---------- Original Method ----------
            //return getState() == 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.620 -0400", hash_original_method = "48A928967742ABFEBADE0574311D01BE", hash_generated_method = "1C2AD0CDC324ABBA3DDAF3FB656B05BF")
        protected boolean tryAcquire(int unused) {
            addTaint(unused);
    if(compareAndSetState(0, 1))            
            {
                setExclusiveOwnerThread(Thread.currentThread());
                boolean varB326B5062B2F0E69046810717534CB09_1915211714 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1550672090 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1550672090;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_926084379 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2110677597 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2110677597;
            // ---------- Original Method ----------
            //if (compareAndSetState(0, 1)) {
                //setExclusiveOwnerThread(Thread.currentThread());
                //return true;
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.621 -0400", hash_original_method = "CF73EFA48EB2690CB7BA351224285F0C", hash_generated_method = "54AC86EECF276BC28B798F740B02466D")
        protected boolean tryRelease(int unused) {
            addTaint(unused);
            setExclusiveOwnerThread(null);
            setState(0);
            boolean varB326B5062B2F0E69046810717534CB09_2071949197 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1112830550 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1112830550;
            // ---------- Original Method ----------
            //setExclusiveOwnerThread(null);
            //setState(0);
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.621 -0400", hash_original_method = "E6AC2D5893CA21F5681F81CF00C94AEB", hash_generated_method = "E250ED120425ABD3596F0FB44742AE76")
        public void lock() {
            acquire(1);
            // ---------- Original Method ----------
            //acquire(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.621 -0400", hash_original_method = "0FBAB3A752D629DDEE7FCF88CA811E1B", hash_generated_method = "C64AAB71B40F70FB6247C7A13B2A4F0A")
        public boolean tryLock() {
            boolean var348B72E576425BDCF1A5A5892822D3BD_333139670 = (tryAcquire(1));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_908211723 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_908211723;
            // ---------- Original Method ----------
            //return tryAcquire(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.621 -0400", hash_original_method = "375F138297D7668DFC40E00540A7DE61", hash_generated_method = "9980155D40CCECC3DD5DA1A3CA7D2CB7")
        public void unlock() {
            release(1);
            // ---------- Original Method ----------
            //release(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.622 -0400", hash_original_method = "0FBE2B31D6107275F6E2B1C06D400675", hash_generated_method = "40B37D983667EFD769E9ABAB2586B828")
        public boolean isLocked() {
            boolean var7551F9FF3A4762BCD1133DF4B8691B3D_1894442857 = (isHeldExclusively());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_895426070 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_895426070;
            // ---------- Original Method ----------
            //return isHeldExclusively();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.622 -0400", hash_original_field = "CD164B34526C2858AEAF8B60C2D2C494", hash_generated_field = "F8F6CAECCAD1418C4C9E71235F2C474E")

        private static final long serialVersionUID = 6138294804551838833L;
    }


    
    public static class CallerRunsPolicy implements RejectedExecutionHandler {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.622 -0400", hash_original_method = "0024AA22CD353D26AF52EE7A7BFF5B6A", hash_generated_method = "EE6F5E0062E38533EDD0CC7DB47C5E41")
        public  CallerRunsPolicy() {
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.622 -0400", hash_original_method = "1E8BCB605E875657A6EC0245732A9544", hash_generated_method = "41E8071271B295178CB10118669124D1")
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            addTaint(e.getTaint());
            addTaint(r.getTaint());
    if(!e.isShutdown())            
            {
                r.run();
            } //End block
            // ---------- Original Method ----------
            //if (!e.isShutdown()) {
                //r.run();
            //}
        }

        
    }


    
    public static class AbortPolicy implements RejectedExecutionHandler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.623 -0400", hash_original_method = "0E304EA6C47EF7342B79AE7423647CD0", hash_generated_method = "179F0278660B104E944DF3C713C65A75")
        public  AbortPolicy() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.623 -0400", hash_original_method = "499AAA3E1602997D93E7C4E818F2EBAC", hash_generated_method = "0D27FD9565D835A71691F16213A52660")
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            addTaint(e.getTaint());
            addTaint(r.getTaint());
            RejectedExecutionException var0C1678CC02FC0866DA2642AB9692C836_194565457 = new RejectedExecutionException("Task " + r.toString() +
                                                 " rejected from " +
                                                 e.toString());
            var0C1678CC02FC0866DA2642AB9692C836_194565457.addTaint(taint);
            throw var0C1678CC02FC0866DA2642AB9692C836_194565457;
            // ---------- Original Method ----------
            //throw new RejectedExecutionException("Task " + r.toString() +
                                                 //" rejected from " +
                                                 //e.toString());
        }

        
    }


    
    public static class DiscardPolicy implements RejectedExecutionHandler {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.623 -0400", hash_original_method = "F09B76305D692D1CB8CB62E17F499CB5", hash_generated_method = "C4B475A3525556F9D1B8C945DF152CD4")
        public  DiscardPolicy() {
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.624 -0400", hash_original_method = "81B7AD8C9B3A9908C7C41F3CCCB6E30B", hash_generated_method = "6F29E6E993E435A8F0C32060F4A39C0C")
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            addTaint(e.getTaint());
            addTaint(r.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    public static class DiscardOldestPolicy implements RejectedExecutionHandler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.624 -0400", hash_original_method = "7D42DC0AF0C4E1A1DAE9147B8685950D", hash_generated_method = "887F469A96FA729D52338C565521C0C6")
        public  DiscardOldestPolicy() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.624 -0400", hash_original_method = "BC4245492A96EB743D1DE4975B9A07C3", hash_generated_method = "D5FBDA004DC7BDCB996EB068B6ED7C28")
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            addTaint(e.getTaint());
            addTaint(r.getTaint());
    if(!e.isShutdown())            
            {
                e.getQueue().poll();
                e.execute(r);
            } //End block
            // ---------- Original Method ----------
            //if (!e.isShutdown()) {
                //e.getQueue().poll();
                //e.execute(r);
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.625 -0400", hash_original_field = "2AD2E6A7A23B57F7662422A52B95CC09", hash_generated_field = "C674AAE591A4C2A6EB2F67EA80F2DE13")

    private static final int COUNT_BITS = Integer.SIZE - 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.625 -0400", hash_original_field = "6F4706F438E735959AC77A0E013826F9", hash_generated_field = "CF878CE62C328436BA99760DFF82027D")

    private static final int CAPACITY = (1 << COUNT_BITS) - 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.625 -0400", hash_original_field = "7E2DC2CDAE866B990CCFB9F99485888D", hash_generated_field = "CAC5C6E1B12A6971FDAEB64BF4F42B8A")

    private static final int RUNNING = -1 << COUNT_BITS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.625 -0400", hash_original_field = "F45465E1DCD849E3752A2369BF892D71", hash_generated_field = "88B12340C5E9ABC6D057CFECE99CB6E3")

    private static final int SHUTDOWN = 0 << COUNT_BITS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.625 -0400", hash_original_field = "04AE349763D898E1D79F4CA49A2289E1", hash_generated_field = "6E7F0CA66443C48AA2015EE41BE176B0")

    private static final int STOP = 1 << COUNT_BITS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.625 -0400", hash_original_field = "90217937E23D86674136EE5F6F9762F5", hash_generated_field = "8F8DF3A5844AACE6D200E7F78FE2ADD1")

    private static final int TIDYING = 2 << COUNT_BITS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.625 -0400", hash_original_field = "A23623286A319227DF0EDB01163E3BBD", hash_generated_field = "0385C889A493B24F4B17131E67614BDD")

    private static final int TERMINATED = 3 << COUNT_BITS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.625 -0400", hash_original_field = "5AA44F02EBBBA45DF7D7B7C9828E325E", hash_generated_field = "D9AB1E8CC26AED3D197149D01E447734")

    private static final RejectedExecutionHandler defaultHandler = new AbortPolicy();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.625 -0400", hash_original_field = "C6A5F234FA8B366F73521414CAEB2E7B", hash_generated_field = "EE8D52406DBEBB0DDE00DE5ED1AF90DE")

    private static final RuntimePermission shutdownPerm = new RuntimePermission("modifyThread");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.626 -0400", hash_original_field = "DCF5310FAB389A27E2F24E12DE639C90", hash_generated_field = "5E955A6108BE148E09061102B5987F21")

    private static final boolean ONLY_ONE = true;
}

