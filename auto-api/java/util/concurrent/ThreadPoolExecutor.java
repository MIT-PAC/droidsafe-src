package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.concurrent.locks.*;
import java.util.concurrent.atomic.*;
import java.util.*;

public class ThreadPoolExecutor extends AbstractExecutorService {
    private AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    private BlockingQueue<Runnable> workQueue;
    private ReentrantLock mainLock = new ReentrantLock();
    private HashSet<Worker> workers = new HashSet<Worker>();
    private Condition termination = mainLock.newCondition();
    private int largestPoolSize;
    private long completedTaskCount;
    private volatile ThreadFactory threadFactory;
    private volatile RejectedExecutionHandler handler;
    private volatile long keepAliveTime;
    private volatile boolean allowCoreThreadTimeOut;
    private volatile int corePoolSize;
    private volatile int maximumPoolSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.923 -0400", hash_original_method = "6852B7239AD6D12F00F6FD31EAEE07F2", hash_generated_method = "A5D225A2CA171DC38900895597B2DE25")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
             Executors.defaultThreadFactory(), defaultHandler);
        dsTaint.addTaint(unit.dsTaint);
        dsTaint.addTaint(corePoolSize);
        dsTaint.addTaint(workQueue.dsTaint);
        dsTaint.addTaint(maximumPoolSize);
        dsTaint.addTaint(keepAliveTime);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.923 -0400", hash_original_method = "472CB7CD686E5ED3EB32346C564DBF00", hash_generated_method = "087AA88E42E6C5EC2918EFE2052C1A2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              ThreadFactory threadFactory) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
             threadFactory, defaultHandler);
        dsTaint.addTaint(threadFactory.dsTaint);
        dsTaint.addTaint(unit.dsTaint);
        dsTaint.addTaint(corePoolSize);
        dsTaint.addTaint(workQueue.dsTaint);
        dsTaint.addTaint(maximumPoolSize);
        dsTaint.addTaint(keepAliveTime);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.923 -0400", hash_original_method = "13BA0DF22A91EC098F651B146B1F0D91", hash_generated_method = "808F67C846AD83EBCDDE8BC97596C4E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              RejectedExecutionHandler handler) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
             Executors.defaultThreadFactory(), handler);
        dsTaint.addTaint(unit.dsTaint);
        dsTaint.addTaint(corePoolSize);
        dsTaint.addTaint(workQueue.dsTaint);
        dsTaint.addTaint(maximumPoolSize);
        dsTaint.addTaint(keepAliveTime);
        dsTaint.addTaint(handler.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.924 -0400", hash_original_method = "7927F5CAD81FDA69C812A57334363D0A", hash_generated_method = "4B9191D27E598D100C28ADC5E66A78D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              ThreadFactory threadFactory,
                              RejectedExecutionHandler handler) {
        dsTaint.addTaint(threadFactory.dsTaint);
        dsTaint.addTaint(unit.dsTaint);
        dsTaint.addTaint(corePoolSize);
        dsTaint.addTaint(workQueue.dsTaint);
        dsTaint.addTaint(maximumPoolSize);
        dsTaint.addTaint(keepAliveTime);
        dsTaint.addTaint(handler.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        this.keepAliveTime = unit.toNanos(keepAliveTime);
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

    
        private static int runStateOf(int c) {
        return c & ~CAPACITY;
    }

    
        private static int workerCountOf(int c) {
        return c & CAPACITY;
    }

    
        private static int ctlOf(int rs, int wc) {
        return rs | wc;
    }

    
        private static boolean runStateLessThan(int c, int s) {
        return c < s;
    }

    
        private static boolean runStateAtLeast(int c, int s) {
        return c >= s;
    }

    
        private static boolean isRunning(int c) {
        return c < SHUTDOWN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.924 -0400", hash_original_method = "AB721E5F3628508DEF5AE872A937DFD4", hash_generated_method = "48A5BB59E453CD70D4FB89A351B6EDD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean compareAndIncrementWorkerCount(int expect) {
        dsTaint.addTaint(expect);
        boolean var0D25B4A75418F47C3A1EE479FF3954DB_1252721810 = (ctl.compareAndSet(expect, expect + 1));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ctl.compareAndSet(expect, expect + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.925 -0400", hash_original_method = "046A4642208AB0946E7553D201BA8A62", hash_generated_method = "70408782DBAC75708C99D94724867058")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean compareAndDecrementWorkerCount(int expect) {
        dsTaint.addTaint(expect);
        boolean varCEAB9D2C7D844A2C607832120A9DF559_208487395 = (ctl.compareAndSet(expect, expect - 1));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ctl.compareAndSet(expect, expect - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.925 -0400", hash_original_method = "197D64850896CFE44F6E60A0B666E58B", hash_generated_method = "1ACCB26E8DF0A5EC7D1619A65A03279A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void decrementWorkerCount() {
        {
            boolean var9E72ADC6AC1B6DC8A6652AF23ECFA13A_1168083967 = (! compareAndDecrementWorkerCount(ctl.get()));
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //do {} while (! compareAndDecrementWorkerCount(ctl.get()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.925 -0400", hash_original_method = "F2BE86117A689CA9DA89AB2ED7F58DB7", hash_generated_method = "883F2F9532B20B1A48B0825BA680E0DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void advanceRunState(int targetState) {
        dsTaint.addTaint(targetState);
        {
            int c;
            c = ctl.get();
            {
                boolean var377820E787C2969E8C3C8BC9C2D5039B_1331442106 = (runStateAtLeast(c, targetState) ||
                ctl.compareAndSet(c, ctlOf(targetState, workerCountOf(c))));
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //for (;;) {
            //int c = ctl.get();
            //if (runStateAtLeast(c, targetState) ||
                //ctl.compareAndSet(c, ctlOf(targetState, workerCountOf(c))))
                //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.926 -0400", hash_original_method = "80042B52D4C8A465DC8857956BEE8BCA", hash_generated_method = "3EAC0C980029EDB78B91D33C1EBB5FD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void tryTerminate() {
        {
            int c;
            c = ctl.get();
            {
                boolean var74E7770FE49A3B736EAFA345B26F794C_569810402 = (isRunning(c) ||
                runStateAtLeast(c, TIDYING) ||
                (runStateOf(c) == SHUTDOWN && ! workQueue.isEmpty()));
            } //End collapsed parenthetic
            {
                boolean var15C00CEC4F0FF9F08AE224FA2AB90491_609031348 = (workerCountOf(c) != 0);
                {
                    interruptIdleWorkers(ONLY_ONE);
                } //End block
            } //End collapsed parenthetic
            ReentrantLock mainLock;
            mainLock = this.mainLock;
            mainLock.lock();
            try 
            {
                {
                    boolean var14DDDB09283814740A1263C9A3AF2248_1280870606 = (ctl.compareAndSet(c, ctlOf(TIDYING, 0)));
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
                    } //End block
                } //End collapsed parenthetic
            } //End block
            finally 
            {
                mainLock.unlock();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.929 -0400", hash_original_method = "AA36F499694835EB802B188BC7C59A14", hash_generated_method = "9BFA7260BE44C830D8BBAFA094C9C21A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkShutdownAccess() {
        SecurityManager security;
        security = System.getSecurityManager();
        {
            security.checkPermission(shutdownPerm);
            ReentrantLock mainLock;
            mainLock = this.mainLock;
            mainLock.lock();
            try 
            {
                {
                    Iterator<Worker> var6931C42F4C1AD656649FE9715A90096D_38985557 = (workers).iterator();
                    var6931C42F4C1AD656649FE9715A90096D_38985557.hasNext();
                    Worker w = var6931C42F4C1AD656649FE9715A90096D_38985557.next();
                    security.checkAccess(w.thread);
                } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.933 -0400", hash_original_method = "3FD8BB870BC89D5588F0560753D4337F", hash_generated_method = "F6704BA2652A6F400FCCDE9C8EB6B31A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void interruptWorkers() {
        ReentrantLock mainLock;
        mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            {
                Iterator<Worker> var6931C42F4C1AD656649FE9715A90096D_1772564585 = (workers).iterator();
                var6931C42F4C1AD656649FE9715A90096D_1772564585.hasNext();
                Worker w = var6931C42F4C1AD656649FE9715A90096D_1772564585.next();
                {
                    try 
                    {
                        w.thread.interrupt();
                    } //End block
                    catch (SecurityException ignore)
                    { }
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.941 -0400", hash_original_method = "C11819B67BF410300D59BD8104FE87A4", hash_generated_method = "242FA6AE2A5E2FF3EE453C155CC74512")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void interruptIdleWorkers(boolean onlyOne) {
        dsTaint.addTaint(onlyOne);
        ReentrantLock mainLock;
        mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            {
                Iterator<Worker> var6931C42F4C1AD656649FE9715A90096D_450713599 = (workers).iterator();
                var6931C42F4C1AD656649FE9715A90096D_450713599.hasNext();
                Worker w = var6931C42F4C1AD656649FE9715A90096D_450713599.next();
                {
                    Thread t;
                    t = w.thread;
                    {
                        boolean varF302C64E2A8A3FADF9D2B8BA25676B4F_253757812 = (!t.isInterrupted() && w.tryLock());
                        {
                            try 
                            {
                                t.interrupt();
                            } //End block
                            catch (SecurityException ignore)
                            { }
                            finally 
                            {
                                w.unlock();
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.941 -0400", hash_original_method = "8AE0F2FE6E5901DBE1EC6FD71BA67D3B", hash_generated_method = "5A72F35E8F8382990E1FD3DE61AAA8EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void interruptIdleWorkers() {
        interruptIdleWorkers(false);
        // ---------- Original Method ----------
        //interruptIdleWorkers(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.941 -0400", hash_original_method = "41D1BD0CB95E0A52108020867995148C", hash_generated_method = "A97CD87D7FA0121D0AF5CEDE4E64D0ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void clearInterruptsForTaskRun() {
        {
            boolean var6ECBD5FE4E49C98E8A2343B113A3ED8B_652746555 = (runStateLessThan(ctl.get(), STOP) &&
            Thread.interrupted() &&
            runStateAtLeast(ctl.get(), STOP));
            Thread.currentThread().interrupt();
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (runStateLessThan(ctl.get(), STOP) &&
            //Thread.interrupted() &&
            //runStateAtLeast(ctl.get(), STOP))
            //Thread.currentThread().interrupt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.942 -0400", hash_original_method = "DBD2AA47670972F837B77D54B6813996", hash_generated_method = "F15F000DF76114A6AF72F61FF36A3E9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void reject(Runnable command) {
        dsTaint.addTaint(command.dsTaint);
        handler.rejectedExecution(command, this);
        // ---------- Original Method ----------
        //handler.rejectedExecution(command, this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.942 -0400", hash_original_method = "0A1F69177689475EC5D7889C7292052F", hash_generated_method = "A8810A0A581CC8BD0FA906871342B1C5")
    @DSModeled(DSC.SAFE)
     void onShutdown() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.942 -0400", hash_original_method = "270A029E5D11891F0D07089698FD1A31", hash_generated_method = "769FE5A59F827E4066F731545CC34CC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final boolean isRunningOrShutdown(boolean shutdownOK) {
        dsTaint.addTaint(shutdownOK);
        int rs;
        rs = runStateOf(ctl.get());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int rs = runStateOf(ctl.get());
        //return rs == RUNNING || (rs == SHUTDOWN && shutdownOK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.945 -0400", hash_original_method = "4695ACF3E76D112BC6AF0E9543CB0BFB", hash_generated_method = "10230E99D67D0113E165751E2795B3BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private List<Runnable> drainQueue() {
        BlockingQueue<Runnable> q;
        q = workQueue;
        List<Runnable> taskList;
        taskList = new ArrayList<Runnable>();
        q.drainTo(taskList);
        {
            boolean var24D3CA3473EF320EA6AF15C01960EBAE_582628594 = (!q.isEmpty());
            {
                {
                    Iterator<Runnable> var9EF8E3C34F168ACADC01921A433EFEF9_866396579 = (q.toArray(new Runnable[0])).iterator();
                    var9EF8E3C34F168ACADC01921A433EFEF9_866396579.hasNext();
                    Runnable r = var9EF8E3C34F168ACADC01921A433EFEF9_866396579.next();
                    {
                        {
                            boolean var8576918424BDAE7AC11C88E260CF968E_1123313693 = (q.remove(r));
                            taskList.add(r);
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (List<Runnable>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.946 -0400", hash_original_method = "7812A944CC6B2EE743043503F380EB35", hash_generated_method = "A1B5C73672037989B867EAF98F391494")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean addWorker(Runnable firstTask, boolean core) {
        dsTaint.addTaint(core);
        dsTaint.addTaint(firstTask.dsTaint);
        {
            int c;
            c = ctl.get();
            int rs;
            rs = runStateOf(c);
            {
                boolean varA0E9E20F717B7D472E07BEC2B53FC068_1974304610 = (rs >= SHUTDOWN &&
                ! (rs == SHUTDOWN &&
                   firstTask == null &&
                   ! workQueue.isEmpty()));
            } //End collapsed parenthetic
            {
                int wc;
                wc = workerCountOf(c);
                {
                    boolean varD3106FA273E29E33F79B0F29BC71E3E9_1490595004 = (compareAndIncrementWorkerCount(c));
                } //End collapsed parenthetic
                c = ctl.get();
                {
                    boolean var006D8DC234DA1DD78318D93B61711BB4_599386576 = (runStateOf(c) != rs);
                } //End collapsed parenthetic
            } //End block
        } //End block
        Worker w;
        w = new Worker(firstTask);
        Thread t;
        t = w.thread;
        ReentrantLock mainLock;
        mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            int c;
            c = ctl.get();
            int rs;
            rs = runStateOf(c);
            {
                decrementWorkerCount();
                tryTerminate();
            } //End block
            workers.add(w);
            int s;
            s = workers.size();
            largestPoolSize = s;
        } //End block
        finally 
        {
            mainLock.unlock();
        } //End block
        t.start();
        {
            boolean var1EB04529E4A4A4FAC968DC4C0BDBF0D5_934322859 = (runStateOf(ctl.get()) == STOP && ! t.isInterrupted());
            t.interrupt();
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.947 -0400", hash_original_method = "98853BED73C436EB42A5D4B84EE5AAA8", hash_generated_method = "BF52C1C35E06A2ABAD0023986CE17461")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void processWorkerExit(Worker w, boolean completedAbruptly) {
        dsTaint.addTaint(w.dsTaint);
        dsTaint.addTaint(completedAbruptly);
        decrementWorkerCount();
        ReentrantLock mainLock;
        mainLock = this.mainLock;
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
        int c;
        c = ctl.get();
        {
            boolean var5863C63A1BA4393B602043CEAC609960_1616190127 = (runStateLessThan(c, STOP));
            {
                {
                    int min;
                    min = 0;
                    min = corePoolSize;
                    {
                        boolean var6D8D038A4484600C74CF88FBA3B0A889_490752459 = (min == 0 && ! workQueue.isEmpty());
                        min = 1;
                    } //End collapsed parenthetic
                    {
                        boolean varABFCCB119B36440534356FFDFEBD1734_1048669447 = (workerCountOf(c) >= min);
                    } //End collapsed parenthetic
                } //End block
                addWorker(null, false);
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.959 -0400", hash_original_method = "CCE5E762047CA277EB153A60A9218EEF", hash_generated_method = "B302F5963A203C56A4A6F555B685ECEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Runnable getTask() {
        boolean timedOut;
        timedOut = false;
        {
            int c;
            c = ctl.get();
            int rs;
            rs = runStateOf(c);
            {
                boolean var74A3816C5E5F9D38AA1ACD2BDAD2E3B8_750966343 = (rs >= SHUTDOWN && (rs >= STOP || workQueue.isEmpty()));
                {
                    decrementWorkerCount();
                } //End block
            } //End collapsed parenthetic
            boolean timed;
            {
                int wc;
                wc = workerCountOf(c);
                timed = allowCoreThreadTimeOut || wc > corePoolSize;
                {
                    boolean var6AE6FD94B8549E87FF836D5CDDE57650_1848304040 = (compareAndDecrementWorkerCount(c));
                } //End collapsed parenthetic
                c = ctl.get();
                {
                    boolean var006D8DC234DA1DD78318D93B61711BB4_33012781 = (runStateOf(c) != rs);
                } //End collapsed parenthetic
            } //End block
            try 
            {
                Runnable r;
                r = workQueue.poll(keepAliveTime, TimeUnit.NANOSECONDS);
                r = workQueue.take();
                timedOut = true;
            } //End block
            catch (InterruptedException retry)
            {
                timedOut = false;
            } //End block
        } //End block
        return (Runnable)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.962 -0400", hash_original_method = "55359692B6793E8A8B1383DAA231ACAC", hash_generated_method = "A682EAE8C3C489E5A04F0D68ED8E6E2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void runWorker(Worker w) {
        dsTaint.addTaint(w.dsTaint);
        Runnable task;
        task = w.firstTask;
        w.firstTask = null;
        boolean completedAbruptly;
        completedAbruptly = true;
        try 
        {
            {
                boolean var0A8D38871405FE6EBA17CA92E1725233_499217940 = (task != null || (task = getTask()) != null);
                {
                    w.lock();
                    clearInterruptsForTaskRun();
                    try 
                    {
                        beforeExecute(w.thread, task);
                        Throwable thrown;
                        thrown = null;
                        try 
                        {
                            task.run();
                        } //End block
                        catch (RuntimeException x)
                        {
                            thrown = x;
                            if (DroidSafeAndroidRuntime.control) throw x;
                        } //End block
                        catch (Error x)
                        {
                            thrown = x;
                            if (DroidSafeAndroidRuntime.control) throw x;
                        } //End block
                        catch (Throwable x)
                        {
                            thrown = x;
                            if (DroidSafeAndroidRuntime.control) throw new Error(x);
                        } //End block
                        finally 
                        {
                            afterExecute(task, thrown);
                        } //End block
                    } //End block
                    finally 
                    {
                        task = null;
                        w.unlock();
                    } //End block
                } //End block
            } //End collapsed parenthetic
            completedAbruptly = false;
        } //End block
        finally 
        {
            processWorkerExit(w, completedAbruptly);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.963 -0400", hash_original_method = "D2720E6C2ABD70ABBFB850D5E1C9152E", hash_generated_method = "73EDA8A05BD732F72796A6E46CD54CEF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void execute(Runnable command) {
        dsTaint.addTaint(command.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        int c;
        c = ctl.get();
        {
            boolean var2DAF44B9E4AFD0B4443B645D193B1C58_48486189 = (workerCountOf(c) < corePoolSize);
            {
                {
                    boolean varF2EFA0687D3A42E9CB40767BB4923E49_1326500090 = (addWorker(command, true));
                } //End collapsed parenthetic
                c = ctl.get();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var4A9938DA2F57582B9B2A24D4AB9321D5_401831331 = (isRunning(c) && workQueue.offer(command));
            {
                int recheck;
                recheck = ctl.get();
                {
                    boolean var2016F270A276BB1ABC44EDF164942688_169566439 = (! isRunning(recheck) && remove(command));
                    reject(command);
                    {
                        boolean varAA10E01B7AA21E8BCFA73D357B3B2488_931729559 = (workerCountOf(recheck) == 0);
                        addWorker(null, false);
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
            {
                boolean varA615DB9E0F0C450CB87AF373F5D24117_1972158329 = (!addWorker(command, false));
                reject(command);
            } //End collapsed parenthetic
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.964 -0400", hash_original_method = "B2E77DE3594C1CCAEA14C26F5B572C39", hash_generated_method = "357CDF6EDD9490DE996143E392EB0474")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void shutdown() {
        ReentrantLock mainLock;
        mainLock = this.mainLock;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.974 -0400", hash_original_method = "D65CB76EC87687B7E50B9EEFFDD4C298", hash_generated_method = "C1440AC5A03B2163E43F21100DE9F090")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<Runnable> shutdownNow() {
        List<Runnable> tasks;
        ReentrantLock mainLock;
        mainLock = this.mainLock;
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
        return (List<Runnable>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.974 -0400", hash_original_method = "968CAF504B3356CA71CED595275477F9", hash_generated_method = "B7536226D565BFDCC203EC567DEB8A34")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isShutdown() {
        boolean varF33AAB80735339C8E62ED2354FD74B60_871657735 = (! isRunning(ctl.get()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ! isRunning(ctl.get());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.974 -0400", hash_original_method = "1B50F454F3FDC6963CA79768BA657116", hash_generated_method = "6A7B27547028052CE2E5DE328F715051")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isTerminating() {
        int c;
        c = ctl.get();
        boolean varE0B540E2ECAB27CA369AF9F26DBBDA29_1718995568 = (! isRunning(c) && runStateLessThan(c, TERMINATED));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int c = ctl.get();
        //return ! isRunning(c) && runStateLessThan(c, TERMINATED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.975 -0400", hash_original_method = "9F60EBE4EAB8D07AF1E9485C91ACF37E", hash_generated_method = "00D7C05338E567B1F8113B420B80A6EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isTerminated() {
        boolean var9820E1CCF8E41D81F088906A90AC2F49_1108091918 = (runStateAtLeast(ctl.get(), TERMINATED));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return runStateAtLeast(ctl.get(), TERMINATED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.975 -0400", hash_original_method = "D4E88A24481EFB5D05D58739D7C6B24D", hash_generated_method = "C6C5727813C1E8E94BC536C3F79C7C19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        dsTaint.addTaint(unit.dsTaint);
        dsTaint.addTaint(timeout);
        long nanos;
        nanos = unit.toNanos(timeout);
        ReentrantLock mainLock;
        mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            {
                {
                    boolean var0E078804F1366C01333D9AD026B9E5A4_716592027 = (runStateAtLeast(ctl.get(), TERMINATED));
                } //End collapsed parenthetic
                nanos = termination.awaitNanos(nanos);
            } //End block
        } //End block
        finally 
        {
            mainLock.unlock();
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.976 -0400", hash_original_method = "54A2A12810CC337A284FDAF9A692A515", hash_generated_method = "57134A5D1161D28260EB34D287472E08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void finalize() {
        shutdown();
        // ---------- Original Method ----------
        //shutdown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.976 -0400", hash_original_method = "59E32FCC6E49B2109079BB0F3E4FFE2B", hash_generated_method = "3D577C114A3204E598F2EF08C1290B6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setThreadFactory(ThreadFactory threadFactory) {
        dsTaint.addTaint(threadFactory.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        // ---------- Original Method ----------
        //if (threadFactory == null)
            //throw new NullPointerException();
        //this.threadFactory = threadFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.976 -0400", hash_original_method = "304653AC486A914BB8844AA1040FA7EB", hash_generated_method = "098FCD8A4EA73558F343FED9289D46AB")
    @DSModeled(DSC.SAFE)
    public ThreadFactory getThreadFactory() {
        return (ThreadFactory)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return threadFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.976 -0400", hash_original_method = "7F03D06860A87C46B9897C91E7329182", hash_generated_method = "9E5DC9FD0E0BBB25EE891B5B038C4CA9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setRejectedExecutionHandler(RejectedExecutionHandler handler) {
        dsTaint.addTaint(handler.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        // ---------- Original Method ----------
        //if (handler == null)
            //throw new NullPointerException();
        //this.handler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.977 -0400", hash_original_method = "6DBE484B7F2A61BE5C5EC698F3E381D8", hash_generated_method = "39B602E07066F5D86C8B5B9E18913278")
    @DSModeled(DSC.SAFE)
    public RejectedExecutionHandler getRejectedExecutionHandler() {
        return (RejectedExecutionHandler)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.977 -0400", hash_original_method = "753479E48A5DF49EEF8BAF55BE437F30", hash_generated_method = "4EC510239B70D64EBB6A14A94ED51D2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCorePoolSize(int corePoolSize) {
        dsTaint.addTaint(corePoolSize);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        int delta;
        delta = corePoolSize - this.corePoolSize;
        {
            boolean varF68CA397C3D415D393630F535946AE03_668558473 = (workerCountOf(ctl.get()) > corePoolSize);
            interruptIdleWorkers();
            {
                int k;
                k = Math.min(delta, workQueue.size());
                {
                    boolean varEF5AAA249FA3E26F2F3951ACFA377289_2032093646 = (k-- > 0 && addWorker(null, true));
                    {
                        {
                            boolean var2AF1FFECF97D5086EAD41EBD9DCCCBAF_20399547 = (workQueue.isEmpty());
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.990 -0400", hash_original_method = "51C354BC1AFFD9D1E19ED52BB81EBE2C", hash_generated_method = "FC747A5EEDE232232098A80062E9E86D")
    @DSModeled(DSC.SAFE)
    public int getCorePoolSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return corePoolSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.990 -0400", hash_original_method = "C3B1E657CEA1E5B0B9267C982B6F89C3", hash_generated_method = "B39A3C1186425A0C4FD6B865CD476DB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean prestartCoreThread() {
        boolean var500E50B69291F8AC83E0DBD4A5C0288F_1717364637 = (workerCountOf(ctl.get()) < corePoolSize &&
            addWorker(null, true));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return workerCountOf(ctl.get()) < corePoolSize &&
            //addWorker(null, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.990 -0400", hash_original_method = "BD3CEF4F9337B2BC7C235E398D43BE2A", hash_generated_method = "E26A060DEF648696AA3CD9953B9B7D4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int prestartAllCoreThreads() {
        int n;
        n = 0;
        {
            boolean var096EA4F950A8AEAC16821018608A2A21_876054845 = (addWorker(null, true));
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int n = 0;
        //while (addWorker(null, true))
            //++n;
        //return n;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.991 -0400", hash_original_method = "B47D14DD952D3505364B334F55BDAD78", hash_generated_method = "41966F6AF3AFC02D4203AD732D456350")
    @DSModeled(DSC.SAFE)
    public boolean allowsCoreThreadTimeOut() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return allowCoreThreadTimeOut;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.993 -0400", hash_original_method = "3CB040DA26A3A7AB5E245CC61764B17D", hash_generated_method = "6396DC081ABA30FBA8750D5EE5FCC3C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void allowCoreThreadTimeOut(boolean value) {
        dsTaint.addTaint(value);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Core threads must have nonzero keep alive times");
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.993 -0400", hash_original_method = "21349012A93D2851376CF1101665B5CB", hash_generated_method = "870C30F72FEE2A768DCC4DD6EC7F5E2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMaximumPoolSize(int maximumPoolSize) {
        dsTaint.addTaint(maximumPoolSize);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        {
            boolean var05D3AFE401306D7B03478EC9AD8483E3_1403572422 = (workerCountOf(ctl.get()) > maximumPoolSize);
            interruptIdleWorkers();
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (maximumPoolSize <= 0 || maximumPoolSize < corePoolSize)
            //throw new IllegalArgumentException();
        //this.maximumPoolSize = maximumPoolSize;
        //if (workerCountOf(ctl.get()) > maximumPoolSize)
            //interruptIdleWorkers();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.996 -0400", hash_original_method = "4164BA9A7B4677354D8831E6C94ADF71", hash_generated_method = "E73ED1B068DCE7CE9C153FE5002C4F23")
    @DSModeled(DSC.SAFE)
    public int getMaximumPoolSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return maximumPoolSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.997 -0400", hash_original_method = "863FC09A28296060918F86FB184DF489", hash_generated_method = "D05F947D4020922053796AE16A49AF89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setKeepAliveTime(long time, TimeUnit unit) {
        dsTaint.addTaint(unit.dsTaint);
        dsTaint.addTaint(time);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        {
            boolean varE36A88334ABAF702C248888F469CB1B5_1223135597 = (time == 0 && allowsCoreThreadTimeOut());
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Core threads must have nonzero keep alive times");
        } //End collapsed parenthetic
        long keepAliveTime;
        keepAliveTime = unit.toNanos(time);
        long delta;
        delta = keepAliveTime - this.keepAliveTime;
        this.keepAliveTime = keepAliveTime;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.006 -0400", hash_original_method = "DF59E7D78F54A4D1FBC20C042F5F1838", hash_generated_method = "781BAACFF69934773EA92BF5A6F8F86D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getKeepAliveTime(TimeUnit unit) {
        dsTaint.addTaint(unit.dsTaint);
        long var21762EF164EDAA82F42EC374AF5B3AFC_391651281 = (unit.convert(keepAliveTime, TimeUnit.NANOSECONDS));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return unit.convert(keepAliveTime, TimeUnit.NANOSECONDS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.006 -0400", hash_original_method = "BD8FCC0E1F95E7B090761BC333422796", hash_generated_method = "7EAB547CB45020AFE2065D74DD71AFCA")
    @DSModeled(DSC.SAFE)
    public BlockingQueue<Runnable> getQueue() {
        return (BlockingQueue<Runnable>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return workQueue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.006 -0400", hash_original_method = "79BF7D79C72AB53C9D385B8F29AB696D", hash_generated_method = "E3C0B84799331AF38A04DAAA1C92A88B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean remove(Runnable task) {
        dsTaint.addTaint(task.dsTaint);
        boolean removed;
        removed = workQueue.remove(task);
        tryTerminate();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean removed = workQueue.remove(task);
        //tryTerminate();
        //return removed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.022 -0400", hash_original_method = "9B9E8DAAF98D7F6DDC91DC997B50219A", hash_generated_method = "1A5248CBCAA58A31689B509B6D86A671")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void purge() {
        BlockingQueue<Runnable> q;
        q = workQueue;
        try 
        {
            Iterator<Runnable> it;
            it = q.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_837481544 = (it.hasNext());
                {
                    Runnable r;
                    r = it.next();
                    {
                        boolean var270276E750C193C865B578E1AE2E22C1_478220139 = (r instanceof Future<?> && ((Future<?>)r).isCancelled());
                        it.remove();
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (ConcurrentModificationException fallThrough)
        {
            {
                Object r = q.toArray()[0];
                {
                    boolean var4E8BBA7479E6059D39986F5769B4F8FA_1183570839 = (r instanceof Future<?> && ((Future<?>)r).isCancelled());
                    q.remove(r);
                } //End collapsed parenthetic
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.025 -0400", hash_original_method = "4852DC9A347396E4E4A26FF1AFDF98FD", hash_generated_method = "D3812BD5B0AC244054B90F45819C4A3B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPoolSize() {
        ReentrantLock mainLock;
        mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            {
                boolean varF68CB7F835009006B5FA4F669CE04294_1098645648 = (runStateAtLeast(ctl.get(), TIDYING));
                Object var741C3FF695A194FA69D4BFA4908B5EDF_483882106 = (workers.size());
            } //End flattened ternary
        } //End block
        finally 
        {
            mainLock.unlock();
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.032 -0400", hash_original_method = "F897DAAB3F6E4FA542BB8276CD2A7AD3", hash_generated_method = "EB8D465AA098227D6D811A35A91D670F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getActiveCount() {
        ReentrantLock mainLock;
        mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            int n;
            n = 0;
            {
                Iterator<Worker> var6931C42F4C1AD656649FE9715A90096D_1437559667 = (workers).iterator();
                var6931C42F4C1AD656649FE9715A90096D_1437559667.hasNext();
                Worker w = var6931C42F4C1AD656649FE9715A90096D_1437559667.next();
                {
                    boolean varBC60F1E56E351594899C6DC36F026C6D_1825994763 = (w.isLocked());
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            mainLock.unlock();
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.033 -0400", hash_original_method = "B4A579D5588949E5556CF38ABCB55065", hash_generated_method = "63F2E11F9B22A64F25610F20E646821A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLargestPoolSize() {
        ReentrantLock mainLock;
        mainLock = this.mainLock;
        mainLock.lock();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //final ReentrantLock mainLock = this.mainLock;
        //mainLock.lock();
        //try {
            //return largestPoolSize;
        //} finally {
            //mainLock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.039 -0400", hash_original_method = "145E6751E1E0E0F3E4FA35DB76B7EDE5", hash_generated_method = "1A42266ABC9DDEE2B0A6D593258D1869")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getTaskCount() {
        ReentrantLock mainLock;
        mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            long n;
            n = completedTaskCount;
            {
                Iterator<Worker> var6931C42F4C1AD656649FE9715A90096D_1603237869 = (workers).iterator();
                var6931C42F4C1AD656649FE9715A90096D_1603237869.hasNext();
                Worker w = var6931C42F4C1AD656649FE9715A90096D_1603237869.next();
                {
                    n += w.completedTasks;
                    {
                        boolean var522A9CF7E3545C172CF36E5345BFAC72_1212709674 = (w.isLocked());
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            long varB956FA447F2D153BA84914B4AF4D6590_1903950148 = (n + workQueue.size());
        } //End block
        finally 
        {
            mainLock.unlock();
        } //End block
        return dsTaint.getTaintLong();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.045 -0400", hash_original_method = "C21C1799DAC41B07982333C8F3E02012", hash_generated_method = "3C75A491A1526419D88CBE0A80C4EFEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getCompletedTaskCount() {
        ReentrantLock mainLock;
        mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            long n;
            n = completedTaskCount;
            {
                Iterator<Worker> var6931C42F4C1AD656649FE9715A90096D_233457501 = (workers).iterator();
                var6931C42F4C1AD656649FE9715A90096D_233457501.hasNext();
                Worker w = var6931C42F4C1AD656649FE9715A90096D_233457501.next();
                n += w.completedTasks;
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            mainLock.unlock();
        } //End block
        return dsTaint.getTaintLong();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.055 -0400", hash_original_method = "AA5F5BF44F4DA05ED8C1D4957936AC31", hash_generated_method = "A89B4897EBF3E6B4152F37A2167C08A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        long ncompleted;
        int nworkers, nactive;
        ReentrantLock mainLock;
        mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            ncompleted = completedTaskCount;
            nactive = 0;
            nworkers = workers.size();
            {
                Iterator<Worker> var6931C42F4C1AD656649FE9715A90096D_158838570 = (workers).iterator();
                var6931C42F4C1AD656649FE9715A90096D_158838570.hasNext();
                Worker w = var6931C42F4C1AD656649FE9715A90096D_158838570.next();
                {
                    ncompleted += w.completedTasks;
                    {
                        boolean var522A9CF7E3545C172CF36E5345BFAC72_526100895 = (w.isLocked());
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            mainLock.unlock();
        } //End block
        int c;
        c = ctl.get();
        String rs;
        rs = (runStateLessThan(c, SHUTDOWN) ? "Running" :
                     (runStateAtLeast(c, TERMINATED) ? "Terminated" :
                      "Shutting down"));//DSFIXME:  CODE0008: Nested ternary operator in expression
        String varFEE103B8838FAC52A03AAD564FBB278B_420696080 = (super.toString() +
            "[" + rs +
            ", pool size = " + nworkers +
            ", active threads = " + nactive +
            ", queued tasks = " + workQueue.size() +
            ", completed tasks = " + ncompleted +
            "]");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.056 -0400", hash_original_method = "4C3878CDFFA0878930C89982189B5032", hash_generated_method = "ED9D6885008FD7052FB2CDAD546C6D87")
    @DSModeled(DSC.SAFE)
    protected void beforeExecute(Thread t, Runnable r) {
        dsTaint.addTaint(t.dsTaint);
        dsTaint.addTaint(r.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.056 -0400", hash_original_method = "1E835AC60F46FC4FB8E958FFB42880D4", hash_generated_method = "56986BAACB7B5DC3A421C001D5C5FC54")
    @DSModeled(DSC.SAFE)
    protected void afterExecute(Runnable r, Throwable t) {
        dsTaint.addTaint(t.dsTaint);
        dsTaint.addTaint(r.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.056 -0400", hash_original_method = "A29D7F7280B94AB8E3FBFAF6674D4BBC", hash_generated_method = "F157B5EF4A6890FC5741BB31F75810D9")
    @DSModeled(DSC.SAFE)
    protected void terminated() {
        // ---------- Original Method ----------
    }

    
    private final class Worker extends AbstractQueuedSynchronizer implements Runnable {
        Thread thread;
        Runnable firstTask;
        volatile long completedTasks;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.057 -0400", hash_original_method = "8E628C9261C64BEE296D97D919DD4FB9", hash_generated_method = "78F41BA4E0084C110C367E3A3076D7FB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Worker(Runnable firstTask) {
            dsTaint.addTaint(firstTask.dsTaint);
            this.thread = getThreadFactory().newThread(this);
            // ---------- Original Method ----------
            //this.firstTask = firstTask;
            //this.thread = getThreadFactory().newThread(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.057 -0400", hash_original_method = "776DC8B2F80D9EC817EF7446A13B40B9", hash_generated_method = "1D172B8AE706040037220A6FE99238AC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            runWorker(this);
            // ---------- Original Method ----------
            //runWorker(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.057 -0400", hash_original_method = "C9E6BAFAC050F423C4392C73A0972F98", hash_generated_method = "BCCB5B01165BD8C83830D7BFA21FE828")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected boolean isHeldExclusively() {
            boolean var19B741D0D216C6237072ABA5B53D29C0_307877470 = (getState() == 1);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return getState() == 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.057 -0400", hash_original_method = "48A928967742ABFEBADE0574311D01BE", hash_generated_method = "81F80122B948CA805A4CA63A2ADAC766")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected boolean tryAcquire(int unused) {
            dsTaint.addTaint(unused);
            {
                boolean varF425053993EA879E03DA150C877D7F5C_532324567 = (compareAndSetState(0, 1));
                {
                    setExclusiveOwnerThread(Thread.currentThread());
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (compareAndSetState(0, 1)) {
                //setExclusiveOwnerThread(Thread.currentThread());
                //return true;
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.058 -0400", hash_original_method = "CF73EFA48EB2690CB7BA351224285F0C", hash_generated_method = "3EC54605D3800C06C1EC83B1642C2786")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected boolean tryRelease(int unused) {
            dsTaint.addTaint(unused);
            setExclusiveOwnerThread(null);
            setState(0);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //setExclusiveOwnerThread(null);
            //setState(0);
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.058 -0400", hash_original_method = "E6AC2D5893CA21F5681F81CF00C94AEB", hash_generated_method = "E250ED120425ABD3596F0FB44742AE76")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void lock() {
            acquire(1);
            // ---------- Original Method ----------
            //acquire(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.058 -0400", hash_original_method = "0FBAB3A752D629DDEE7FCF88CA811E1B", hash_generated_method = "615B72C176832ED6682C93D388055EF4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean tryLock() {
            boolean var983EB53456294FEAD564C34A6EB40052_432790724 = (tryAcquire(1));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return tryAcquire(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.058 -0400", hash_original_method = "375F138297D7668DFC40E00540A7DE61", hash_generated_method = "9980155D40CCECC3DD5DA1A3CA7D2CB7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void unlock() {
            release(1);
            // ---------- Original Method ----------
            //release(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.059 -0400", hash_original_method = "0FBE2B31D6107275F6E2B1C06D400675", hash_generated_method = "2461DE39674C40694B97CAB0B75EE88B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean isLocked() {
            boolean var7307B0E63112DD101487F0593BCA6CC3_1136441906 = (isHeldExclusively());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return isHeldExclusively();
        }

        
        private static final long serialVersionUID = 6138294804551838833L;
    }


    
    public static class CallerRunsPolicy implements RejectedExecutionHandler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.059 -0400", hash_original_method = "0024AA22CD353D26AF52EE7A7BFF5B6A", hash_generated_method = "EE6F5E0062E38533EDD0CC7DB47C5E41")
        @DSModeled(DSC.SAFE)
        public CallerRunsPolicy() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.059 -0400", hash_original_method = "1E8BCB605E875657A6EC0245732A9544", hash_generated_method = "6C77B745EB9E62D92ECC19B4B0D0949D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            dsTaint.addTaint(e.dsTaint);
            dsTaint.addTaint(r.dsTaint);
            {
                boolean var25A2508FD0F77674F14744C27A3265D3_308939 = (!e.isShutdown());
                {
                    r.run();
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (!e.isShutdown()) {
                //r.run();
            //}
        }

        
    }


    
    public static class AbortPolicy implements RejectedExecutionHandler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.059 -0400", hash_original_method = "0E304EA6C47EF7342B79AE7423647CD0", hash_generated_method = "179F0278660B104E944DF3C713C65A75")
        @DSModeled(DSC.SAFE)
        public AbortPolicy() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.060 -0400", hash_original_method = "499AAA3E1602997D93E7C4E818F2EBAC", hash_generated_method = "7FC98E3BE9E989516BA1C6E010CAFAB4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            dsTaint.addTaint(e.dsTaint);
            dsTaint.addTaint(r.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new RejectedExecutionException("Task " + r.toString() +
                                                 " rejected from " +
                                                 e.toString());
            // ---------- Original Method ----------
            //throw new RejectedExecutionException("Task " + r.toString() +
                                                 //" rejected from " +
                                                 //e.toString());
        }

        
    }


    
    public static class DiscardPolicy implements RejectedExecutionHandler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.060 -0400", hash_original_method = "F09B76305D692D1CB8CB62E17F499CB5", hash_generated_method = "C4B475A3525556F9D1B8C945DF152CD4")
        @DSModeled(DSC.SAFE)
        public DiscardPolicy() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.060 -0400", hash_original_method = "81B7AD8C9B3A9908C7C41F3CCCB6E30B", hash_generated_method = "794A4C8058BA56B0976E6ED8D139E650")
        @DSModeled(DSC.SAFE)
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            dsTaint.addTaint(e.dsTaint);
            dsTaint.addTaint(r.dsTaint);
            // ---------- Original Method ----------
        }

        
    }


    
    public static class DiscardOldestPolicy implements RejectedExecutionHandler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.061 -0400", hash_original_method = "7D42DC0AF0C4E1A1DAE9147B8685950D", hash_generated_method = "887F469A96FA729D52338C565521C0C6")
        @DSModeled(DSC.SAFE)
        public DiscardOldestPolicy() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.061 -0400", hash_original_method = "BC4245492A96EB743D1DE4975B9A07C3", hash_generated_method = "A20770A061D4C1F2466AA7C44E0901E4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            dsTaint.addTaint(e.dsTaint);
            dsTaint.addTaint(r.dsTaint);
            {
                boolean var25A2508FD0F77674F14744C27A3265D3_1274400025 = (!e.isShutdown());
                {
                    e.getQueue().poll();
                    e.execute(r);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (!e.isShutdown()) {
                //e.getQueue().poll();
                //e.execute(r);
            //}
        }

        
    }


    
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;
    private static final RejectedExecutionHandler defaultHandler =
        new AbortPolicy();
    private static final RuntimePermission shutdownPerm =
        new RuntimePermission("modifyThread");
    private static final boolean ONLY_ONE = true;
}

