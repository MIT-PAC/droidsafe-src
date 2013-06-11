package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.concurrent.locks.*;
import java.util.concurrent.atomic.*;
import java.util.*;

public class ThreadPoolExecutor extends AbstractExecutorService {
    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;
    private final BlockingQueue<Runnable> workQueue;
    private final ReentrantLock mainLock = new ReentrantLock();
    private final HashSet<Worker> workers = new HashSet<Worker>();
    private final Condition termination = mainLock.newCondition();
    private int largestPoolSize;
    private long completedTaskCount;
    private volatile ThreadFactory threadFactory;
    private volatile RejectedExecutionHandler handler;
    private volatile long keepAliveTime;
    private volatile boolean allowCoreThreadTimeOut;
    private volatile int corePoolSize;
    private volatile int maximumPoolSize;
    private static final RejectedExecutionHandler defaultHandler =
        new AbortPolicy();
    private static final RuntimePermission shutdownPerm =
        new RuntimePermission("modifyThread");
    private static final boolean ONLY_ONE = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.080 -0400", hash_original_method = "6852B7239AD6D12F00F6FD31EAEE07F2", hash_generated_method = "194557C83CEAFB660D176CC3BF670D4F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.080 -0400", hash_original_method = "472CB7CD686E5ED3EB32346C564DBF00", hash_generated_method = "F728EC4BC805DFE82583CFE0C3615BAA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.080 -0400", hash_original_method = "13BA0DF22A91EC098F651B146B1F0D91", hash_generated_method = "C3D2818B1D9F135B110700AEE741C3B3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.080 -0400", hash_original_method = "7927F5CAD81FDA69C812A57334363D0A", hash_generated_method = "3FDF41A0A0966B0DAA659C982ECC0FDA")
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
        throw new IllegalArgumentException();
        throw new NullPointerException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.081 -0400", hash_original_method = "35D20B7433D8164BEFED9190D6BE2329", hash_generated_method = "C62077775D699E39D0F9E2FD3271FE98")
    private static int runStateOf(int c) {
        return c & ~CAPACITY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.081 -0400", hash_original_method = "621333305A7F85CE314303492213D34F", hash_generated_method = "3F6DB8D2AF9BE83CFB6E6678E2245387")
    private static int workerCountOf(int c) {
        return c & CAPACITY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.081 -0400", hash_original_method = "12A3626063CD1D901A2F97DB97430792", hash_generated_method = "EDD0F382D13688A2B100EBA36802BC87")
    private static int ctlOf(int rs, int wc) {
        return rs | wc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.081 -0400", hash_original_method = "FA1A16BC6D47806587415BDA14DAC745", hash_generated_method = "EF0039E40E3F50A7A9E85DC0443D2F01")
    private static boolean runStateLessThan(int c, int s) {
        return c < s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.081 -0400", hash_original_method = "493C1CFFB986457DAF9A40F53248A6E5", hash_generated_method = "C40DB75C4C0E5D690D3B22605714AAB8")
    private static boolean runStateAtLeast(int c, int s) {
        return c >= s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.081 -0400", hash_original_method = "11B81231945C57BFAFCA8253946950FE", hash_generated_method = "E45AF9BEAE37D18E69403B2D0717B63D")
    private static boolean isRunning(int c) {
        return c < SHUTDOWN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.081 -0400", hash_original_method = "AB721E5F3628508DEF5AE872A937DFD4", hash_generated_method = "0A040AEB9EF8525CC390D03FCD42C62F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean compareAndIncrementWorkerCount(int expect) {
        dsTaint.addTaint(expect);
        boolean var0D25B4A75418F47C3A1EE479FF3954DB_783824140 = (ctl.compareAndSet(expect, expect + 1));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ctl.compareAndSet(expect, expect + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.081 -0400", hash_original_method = "046A4642208AB0946E7553D201BA8A62", hash_generated_method = "66D4039004C64D91806238ACDED16662")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean compareAndDecrementWorkerCount(int expect) {
        dsTaint.addTaint(expect);
        boolean varCEAB9D2C7D844A2C607832120A9DF559_1620934513 = (ctl.compareAndSet(expect, expect - 1));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ctl.compareAndSet(expect, expect - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.081 -0400", hash_original_method = "197D64850896CFE44F6E60A0B666E58B", hash_generated_method = "0D0256C7C2905974A126F6D6A3A95255")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void decrementWorkerCount() {
        {
            boolean var9E72ADC6AC1B6DC8A6652AF23ECFA13A_1666894492 = (! compareAndDecrementWorkerCount(ctl.get()));
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //do {} while (! compareAndDecrementWorkerCount(ctl.get()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.081 -0400", hash_original_method = "F2BE86117A689CA9DA89AB2ED7F58DB7", hash_generated_method = "E6A066B5F7F8F5C29FD88C08155EBA9E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void advanceRunState(int targetState) {
        dsTaint.addTaint(targetState);
        {
            int c;
            c = ctl.get();
            {
                boolean var377820E787C2969E8C3C8BC9C2D5039B_1880506345 = (runStateAtLeast(c, targetState) ||
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.081 -0400", hash_original_method = "80042B52D4C8A465DC8857956BEE8BCA", hash_generated_method = "857A840CBD1267B80BF1ACECA12B3BD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void tryTerminate() {
        {
            int c;
            c = ctl.get();
            {
                boolean var74E7770FE49A3B736EAFA345B26F794C_1106100734 = (isRunning(c) ||
                runStateAtLeast(c, TIDYING) ||
                (runStateOf(c) == SHUTDOWN && ! workQueue.isEmpty()));
            } //End collapsed parenthetic
            {
                boolean var15C00CEC4F0FF9F08AE224FA2AB90491_1836286997 = (workerCountOf(c) != 0);
                {
                    interruptIdleWorkers(ONLY_ONE);
                } //End block
            } //End collapsed parenthetic
            final ReentrantLock mainLock;
            mainLock = this.mainLock;
            mainLock.lock();
            try 
            {
                {
                    boolean var14DDDB09283814740A1263C9A3AF2248_1400927008 = (ctl.compareAndSet(c, ctlOf(TIDYING, 0)));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.081 -0400", hash_original_method = "AA36F499694835EB802B188BC7C59A14", hash_generated_method = "7925D6CCDFD400C3AC08B5AA74AEDC9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkShutdownAccess() {
        SecurityManager security;
        security = System.getSecurityManager();
        {
            security.checkPermission(shutdownPerm);
            final ReentrantLock mainLock;
            mainLock = this.mainLock;
            mainLock.lock();
            try 
            {
                {
                    Iterator<Worker> seatecAstronomy42 = workers.iterator();
                    seatecAstronomy42.hasNext();
                    Worker w = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.081 -0400", hash_original_method = "3FD8BB870BC89D5588F0560753D4337F", hash_generated_method = "AF242C5A6C8C11C693BC0C24B8658F65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void interruptWorkers() {
        final ReentrantLock mainLock;
        mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            {
                Iterator<Worker> seatecAstronomy42 = workers.iterator();
                seatecAstronomy42.hasNext();
                Worker w = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.082 -0400", hash_original_method = "C11819B67BF410300D59BD8104FE87A4", hash_generated_method = "1873072BCDA545B51B78EF60643995BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void interruptIdleWorkers(boolean onlyOne) {
        dsTaint.addTaint(onlyOne);
        final ReentrantLock mainLock;
        mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            {
                Iterator<Worker> seatecAstronomy42 = workers.iterator();
                seatecAstronomy42.hasNext();
                Worker w = seatecAstronomy42.next();
                {
                    Thread t;
                    t = w.thread;
                    {
                        boolean varF302C64E2A8A3FADF9D2B8BA25676B4F_1660506081 = (!t.isInterrupted() && w.tryLock());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.082 -0400", hash_original_method = "8AE0F2FE6E5901DBE1EC6FD71BA67D3B", hash_generated_method = "C275308F7E58C989B3FEA66A2D156A85")
    @DSModeled(DSC.SAFE)
    private void interruptIdleWorkers() {
        interruptIdleWorkers(false);
        // ---------- Original Method ----------
        //interruptIdleWorkers(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.082 -0400", hash_original_method = "41D1BD0CB95E0A52108020867995148C", hash_generated_method = "FB89D21E35A160841210F4EF24D1DA94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void clearInterruptsForTaskRun() {
        {
            boolean var6ECBD5FE4E49C98E8A2343B113A3ED8B_1431526394 = (runStateLessThan(ctl.get(), STOP) &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.082 -0400", hash_original_method = "DBD2AA47670972F837B77D54B6813996", hash_generated_method = "D10CE2E09314E132E86A0E8819E2FF54")
    @DSModeled(DSC.SAFE)
    final void reject(Runnable command) {
        dsTaint.addTaint(command.dsTaint);
        handler.rejectedExecution(command, this);
        // ---------- Original Method ----------
        //handler.rejectedExecution(command, this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.082 -0400", hash_original_method = "0A1F69177689475EC5D7889C7292052F", hash_generated_method = "9F2E6BA2ADB0A6F9D1047EC495E58FAB")
    @DSModeled(DSC.SAFE)
     void onShutdown() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.082 -0400", hash_original_method = "270A029E5D11891F0D07089698FD1A31", hash_generated_method = "D5EBC3A83AC954DA11F1219B0ADD9180")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.082 -0400", hash_original_method = "4695ACF3E76D112BC6AF0E9543CB0BFB", hash_generated_method = "7487587F98770821709463FAD51CC07E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private List<Runnable> drainQueue() {
        BlockingQueue<Runnable> q;
        q = workQueue;
        List<Runnable> taskList;
        taskList = new ArrayList<Runnable>();
        q.drainTo(taskList);
        {
            boolean var24D3CA3473EF320EA6AF15C01960EBAE_2042205745 = (!q.isEmpty());
            {
                {
                    Runnable r= q.toArray(new Runnable[0])[0];
                    {
                        {
                            boolean var8576918424BDAE7AC11C88E260CF968E_1643417017 = (q.remove(r));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.082 -0400", hash_original_method = "7812A944CC6B2EE743043503F380EB35", hash_generated_method = "516671838B07AA3A7A3A2F2B42A8FB00")
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
                boolean varA0E9E20F717B7D472E07BEC2B53FC068_1531277326 = (rs >= SHUTDOWN &&
                ! (rs == SHUTDOWN &&
                   firstTask == null &&
                   ! workQueue.isEmpty()));
            } //End collapsed parenthetic
            {
                int wc;
                wc = workerCountOf(c);
                {
                    boolean varD3106FA273E29E33F79B0F29BC71E3E9_785233728 = (compareAndIncrementWorkerCount(c));
                } //End collapsed parenthetic
                c = ctl.get();
                {
                    boolean var006D8DC234DA1DD78318D93B61711BB4_1584629421 = (runStateOf(c) != rs);
                } //End collapsed parenthetic
            } //End block
        } //End block
        Worker w;
        w = new Worker(firstTask);
        Thread t;
        t = w.thread;
        final ReentrantLock mainLock;
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
            boolean var1EB04529E4A4A4FAC968DC4C0BDBF0D5_744382568 = (runStateOf(ctl.get()) == STOP && ! t.isInterrupted());
            t.interrupt();
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.083 -0400", hash_original_method = "98853BED73C436EB42A5D4B84EE5AAA8", hash_generated_method = "53656776E3953D2473D921EF11E039A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void processWorkerExit(Worker w, boolean completedAbruptly) {
        dsTaint.addTaint(w.dsTaint);
        dsTaint.addTaint(completedAbruptly);
        decrementWorkerCount();
        final ReentrantLock mainLock;
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
            boolean var5863C63A1BA4393B602043CEAC609960_585036994 = (runStateLessThan(c, STOP));
            {
                {
                    int min;
                    min = 0;
                    min = corePoolSize;
                    {
                        boolean var6D8D038A4484600C74CF88FBA3B0A889_1778777611 = (min == 0 && ! workQueue.isEmpty());
                        min = 1;
                    } //End collapsed parenthetic
                    {
                        boolean varABFCCB119B36440534356FFDFEBD1734_474568765 = (workerCountOf(c) >= min);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.083 -0400", hash_original_method = "CCE5E762047CA277EB153A60A9218EEF", hash_generated_method = "C3B48BA6F44D89151B61A6B34871B80B")
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
                boolean var74A3816C5E5F9D38AA1ACD2BDAD2E3B8_854128656 = (rs >= SHUTDOWN && (rs >= STOP || workQueue.isEmpty()));
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
                    boolean var6AE6FD94B8549E87FF836D5CDDE57650_1830637167 = (compareAndDecrementWorkerCount(c));
                } //End collapsed parenthetic
                c = ctl.get();
                {
                    boolean var006D8DC234DA1DD78318D93B61711BB4_1500686194 = (runStateOf(c) != rs);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.083 -0400", hash_original_method = "55359692B6793E8A8B1383DAA231ACAC", hash_generated_method = "7446EA53E75C5CC56C63BE9B29C9C38B")
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
                boolean var0A8D38871405FE6EBA17CA92E1725233_1643578761 = (task != null || (task = getTask()) != null);
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
                            throw x;
                        } //End block
                        catch (Error x)
                        {
                            thrown = x;
                            throw x;
                        } //End block
                        catch (Throwable x)
                        {
                            thrown = x;
                            throw new Error(x);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.083 -0400", hash_original_method = "D2720E6C2ABD70ABBFB850D5E1C9152E", hash_generated_method = "2B4E110833062A1C415598653D013FC9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void execute(Runnable command) {
        dsTaint.addTaint(command.dsTaint);
        throw new NullPointerException();
        int c;
        c = ctl.get();
        {
            boolean var2DAF44B9E4AFD0B4443B645D193B1C58_636361687 = (workerCountOf(c) < corePoolSize);
            {
                {
                    boolean varF2EFA0687D3A42E9CB40767BB4923E49_248042944 = (addWorker(command, true));
                } //End collapsed parenthetic
                c = ctl.get();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var4A9938DA2F57582B9B2A24D4AB9321D5_1206491280 = (isRunning(c) && workQueue.offer(command));
            {
                int recheck;
                recheck = ctl.get();
                {
                    boolean var2016F270A276BB1ABC44EDF164942688_45231430 = (! isRunning(recheck) && remove(command));
                    reject(command);
                    {
                        boolean varAA10E01B7AA21E8BCFA73D357B3B2488_1163040294 = (workerCountOf(recheck) == 0);
                        addWorker(null, false);
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
            {
                boolean varA615DB9E0F0C450CB87AF373F5D24117_41697930 = (!addWorker(command, false));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.084 -0400", hash_original_method = "B2E77DE3594C1CCAEA14C26F5B572C39", hash_generated_method = "F784EB4EF7C77DB18D4D4F8BF2F38090")
    @DSModeled(DSC.SAFE)
    public void shutdown() {
        final ReentrantLock mainLock;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.084 -0400", hash_original_method = "D65CB76EC87687B7E50B9EEFFDD4C298", hash_generated_method = "5F22C7755B2E7C83B5D02E57CC6A7822")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<Runnable> shutdownNow() {
        List<Runnable> tasks;
        final ReentrantLock mainLock;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.084 -0400", hash_original_method = "968CAF504B3356CA71CED595275477F9", hash_generated_method = "1733B860FADA9CCCA6121A6B216E86A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isShutdown() {
        boolean varF33AAB80735339C8E62ED2354FD74B60_508195775 = (! isRunning(ctl.get()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ! isRunning(ctl.get());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.084 -0400", hash_original_method = "1B50F454F3FDC6963CA79768BA657116", hash_generated_method = "8E8DED81DF5D591DE0E392376FD3E044")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isTerminating() {
        int c;
        c = ctl.get();
        boolean varE0B540E2ECAB27CA369AF9F26DBBDA29_26412885 = (! isRunning(c) && runStateLessThan(c, TERMINATED));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int c = ctl.get();
        //return ! isRunning(c) && runStateLessThan(c, TERMINATED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.084 -0400", hash_original_method = "9F60EBE4EAB8D07AF1E9485C91ACF37E", hash_generated_method = "52D90CF9671902E1E4E8CF681B03F5CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isTerminated() {
        boolean var9820E1CCF8E41D81F088906A90AC2F49_1771342281 = (runStateAtLeast(ctl.get(), TERMINATED));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return runStateAtLeast(ctl.get(), TERMINATED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.084 -0400", hash_original_method = "D4E88A24481EFB5D05D58739D7C6B24D", hash_generated_method = "BA3A38F64C84C02898DFC48F7D379FB0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        dsTaint.addTaint(unit.dsTaint);
        dsTaint.addTaint(timeout);
        long nanos;
        nanos = unit.toNanos(timeout);
        final ReentrantLock mainLock;
        mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            {
                {
                    boolean var0E078804F1366C01333D9AD026B9E5A4_223528452 = (runStateAtLeast(ctl.get(), TERMINATED));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.084 -0400", hash_original_method = "54A2A12810CC337A284FDAF9A692A515", hash_generated_method = "B2C82D7DC35F764374E8B61A325DBCF7")
    @DSModeled(DSC.SAFE)
    protected void finalize() {
        shutdown();
        // ---------- Original Method ----------
        //shutdown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.084 -0400", hash_original_method = "59E32FCC6E49B2109079BB0F3E4FFE2B", hash_generated_method = "79DDB78D7F6C3E5AD67CB3676F701B3F")
    @DSModeled(DSC.SAFE)
    public void setThreadFactory(ThreadFactory threadFactory) {
        dsTaint.addTaint(threadFactory.dsTaint);
        throw new NullPointerException();
        // ---------- Original Method ----------
        //if (threadFactory == null)
            //throw new NullPointerException();
        //this.threadFactory = threadFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.084 -0400", hash_original_method = "304653AC486A914BB8844AA1040FA7EB", hash_generated_method = "50155A0F5AB896BA215E9DD783812A20")
    @DSModeled(DSC.SAFE)
    public ThreadFactory getThreadFactory() {
        return (ThreadFactory)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return threadFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.084 -0400", hash_original_method = "7F03D06860A87C46B9897C91E7329182", hash_generated_method = "88700041C439C257859712EBD5554099")
    @DSModeled(DSC.SAFE)
    public void setRejectedExecutionHandler(RejectedExecutionHandler handler) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(handler.dsTaint);
        throw new NullPointerException();
        // ---------- Original Method ----------
        //if (handler == null)
            //throw new NullPointerException();
        //this.handler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.084 -0400", hash_original_method = "6DBE484B7F2A61BE5C5EC698F3E381D8", hash_generated_method = "F439062E892BCACBAB91F372BA0B1187")
    @DSModeled(DSC.SAFE)
    public RejectedExecutionHandler getRejectedExecutionHandler() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return (RejectedExecutionHandler)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.084 -0400", hash_original_method = "753479E48A5DF49EEF8BAF55BE437F30", hash_generated_method = "40117D8CBB3D8D6E5D4D248DB95D3537")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCorePoolSize(int corePoolSize) {
        dsTaint.addTaint(corePoolSize);
        throw new IllegalArgumentException();
        int delta;
        delta = corePoolSize - this.corePoolSize;
        {
            boolean varF68CA397C3D415D393630F535946AE03_1920163055 = (workerCountOf(ctl.get()) > corePoolSize);
            interruptIdleWorkers();
            {
                int k;
                k = Math.min(delta, workQueue.size());
                {
                    boolean varEF5AAA249FA3E26F2F3951ACFA377289_1152823085 = (k-- > 0 && addWorker(null, true));
                    {
                        {
                            boolean var2AF1FFECF97D5086EAD41EBD9DCCCBAF_552739016 = (workQueue.isEmpty());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.084 -0400", hash_original_method = "51C354BC1AFFD9D1E19ED52BB81EBE2C", hash_generated_method = "F116161823F756A412D167E2AA825440")
    @DSModeled(DSC.SAFE)
    public int getCorePoolSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return corePoolSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.085 -0400", hash_original_method = "C3B1E657CEA1E5B0B9267C982B6F89C3", hash_generated_method = "902DA4AFA7A2EE3DCB1870458E2D7C67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean prestartCoreThread() {
        boolean var500E50B69291F8AC83E0DBD4A5C0288F_1540878614 = (workerCountOf(ctl.get()) < corePoolSize &&
            addWorker(null, true));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return workerCountOf(ctl.get()) < corePoolSize &&
            //addWorker(null, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.085 -0400", hash_original_method = "BD3CEF4F9337B2BC7C235E398D43BE2A", hash_generated_method = "EC5221FA73544C807D61C8023DA0703E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int prestartAllCoreThreads() {
        int n;
        n = 0;
        {
            boolean var096EA4F950A8AEAC16821018608A2A21_1406029099 = (addWorker(null, true));
            ++n;
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int n = 0;
        //while (addWorker(null, true))
            //++n;
        //return n;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.085 -0400", hash_original_method = "B47D14DD952D3505364B334F55BDAD78", hash_generated_method = "D39D47CD2FDD319956C079B441354704")
    @DSModeled(DSC.SAFE)
    public boolean allowsCoreThreadTimeOut() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return allowCoreThreadTimeOut;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.085 -0400", hash_original_method = "3CB040DA26A3A7AB5E245CC61764B17D", hash_generated_method = "DD6AEA4417243A00EB11BFC83C743E1E")
    @DSModeled(DSC.SAFE)
    public void allowCoreThreadTimeOut(boolean value) {
        dsTaint.addTaint(value);
        throw new IllegalArgumentException("Core threads must have nonzero keep alive times");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.085 -0400", hash_original_method = "21349012A93D2851376CF1101665B5CB", hash_generated_method = "54149F1CF76E0ADAB633807B9426210F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMaximumPoolSize(int maximumPoolSize) {
        dsTaint.addTaint(maximumPoolSize);
        throw new IllegalArgumentException();
        {
            boolean var05D3AFE401306D7B03478EC9AD8483E3_262382844 = (workerCountOf(ctl.get()) > maximumPoolSize);
            interruptIdleWorkers();
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (maximumPoolSize <= 0 || maximumPoolSize < corePoolSize)
            //throw new IllegalArgumentException();
        //this.maximumPoolSize = maximumPoolSize;
        //if (workerCountOf(ctl.get()) > maximumPoolSize)
            //interruptIdleWorkers();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.085 -0400", hash_original_method = "4164BA9A7B4677354D8831E6C94ADF71", hash_generated_method = "404ABDE5AEF43F57B695118DBC02D77B")
    @DSModeled(DSC.SAFE)
    public int getMaximumPoolSize() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return maximumPoolSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.085 -0400", hash_original_method = "863FC09A28296060918F86FB184DF489", hash_generated_method = "174792D6445A5233DC84A6B074C26389")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setKeepAliveTime(long time, TimeUnit unit) {
        dsTaint.addTaint(unit.dsTaint);
        dsTaint.addTaint(time);
        throw new IllegalArgumentException();
        {
            boolean varE36A88334ABAF702C248888F469CB1B5_1191396700 = (time == 0 && allowsCoreThreadTimeOut());
            throw new IllegalArgumentException("Core threads must have nonzero keep alive times");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.085 -0400", hash_original_method = "DF59E7D78F54A4D1FBC20C042F5F1838", hash_generated_method = "3606C4430187941351DF456AE13CCBDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getKeepAliveTime(TimeUnit unit) {
        dsTaint.addTaint(unit.dsTaint);
        long var21762EF164EDAA82F42EC374AF5B3AFC_375643694 = (unit.convert(keepAliveTime, TimeUnit.NANOSECONDS));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return unit.convert(keepAliveTime, TimeUnit.NANOSECONDS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.085 -0400", hash_original_method = "BD8FCC0E1F95E7B090761BC333422796", hash_generated_method = "9A7B8E9D18711AC3FAEF864D98EB72E6")
    @DSModeled(DSC.SAFE)
    public BlockingQueue<Runnable> getQueue() {
        return (BlockingQueue<Runnable>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return workQueue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.085 -0400", hash_original_method = "79BF7D79C72AB53C9D385B8F29AB696D", hash_generated_method = "6AB3B3236D4E09DF9F28E0EE57A8F008")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.085 -0400", hash_original_method = "9B9E8DAAF98D7F6DDC91DC997B50219A", hash_generated_method = "0B5E8347385FEC718CA5B1B6DA778A03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void purge() {
        final BlockingQueue<Runnable> q;
        q = workQueue;
        try 
        {
            Iterator<Runnable> it;
            it = q.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1525999008 = (it.hasNext());
                {
                    Runnable r;
                    r = it.next();
                    {
                        boolean var270276E750C193C865B578E1AE2E22C1_370700029 = (r instanceof Future<?> && ((Future<?>)r).isCancelled());
                        it.remove();
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (ConcurrentModificationException fallThrough)
        {
            {
                Object r = q.toArray().iterator();
                {
                    boolean var4E8BBA7479E6059D39986F5769B4F8FA_1458685636 = (r instanceof Future<?> && ((Future<?>)r).isCancelled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.085 -0400", hash_original_method = "4852DC9A347396E4E4A26FF1AFDF98FD", hash_generated_method = "2DBAAB32F545F5C989705262D18CFE64")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPoolSize() {
        final ReentrantLock mainLock;
        mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            {
                boolean varF68CB7F835009006B5FA4F669CE04294_1977150612 = (runStateAtLeast(ctl.get(), TIDYING));
                Object var741C3FF695A194FA69D4BFA4908B5EDF_898377221 = (workers.size());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.086 -0400", hash_original_method = "F897DAAB3F6E4FA542BB8276CD2A7AD3", hash_generated_method = "1A038ED82D9F0A84060BD44665EC60C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getActiveCount() {
        final ReentrantLock mainLock;
        mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            int n;
            n = 0;
            {
                Iterator<Worker> seatecAstronomy42 = workers.iterator();
                seatecAstronomy42.hasNext();
                Worker w = seatecAstronomy42.next();
                {
                    boolean varBC60F1E56E351594899C6DC36F026C6D_1597575263 = (w.isLocked());
                    ++n;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.086 -0400", hash_original_method = "B4A579D5588949E5556CF38ABCB55065", hash_generated_method = "976A72083117645962F8071FB49C4C90")
    @DSModeled(DSC.SAFE)
    public int getLargestPoolSize() {
        final ReentrantLock mainLock;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.086 -0400", hash_original_method = "145E6751E1E0E0F3E4FA35DB76B7EDE5", hash_generated_method = "18E008501504D78B52F8F7EFE1B98138")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getTaskCount() {
        final ReentrantLock mainLock;
        mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            long n;
            n = completedTaskCount;
            {
                Iterator<Worker> seatecAstronomy42 = workers.iterator();
                seatecAstronomy42.hasNext();
                Worker w = seatecAstronomy42.next();
                {
                    n += w.completedTasks;
                    {
                        boolean var522A9CF7E3545C172CF36E5345BFAC72_571154338 = (w.isLocked());
                        ++n;
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            long varB956FA447F2D153BA84914B4AF4D6590_890415606 = (n + workQueue.size());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.086 -0400", hash_original_method = "C21C1799DAC41B07982333C8F3E02012", hash_generated_method = "272890BF4739F9D06A2B051A33406127")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getCompletedTaskCount() {
        final ReentrantLock mainLock;
        mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            long n;
            n = completedTaskCount;
            {
                Iterator<Worker> seatecAstronomy42 = workers.iterator();
                seatecAstronomy42.hasNext();
                Worker w = seatecAstronomy42.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.086 -0400", hash_original_method = "AA5F5BF44F4DA05ED8C1D4957936AC31", hash_generated_method = "7585134E3A809BD446827A7FE84EFF08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        long ncompleted;
        int nworkers, nactive;
        final ReentrantLock mainLock;
        mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            ncompleted = completedTaskCount;
            nactive = 0;
            nworkers = workers.size();
            {
                Iterator<Worker> seatecAstronomy42 = workers.iterator();
                seatecAstronomy42.hasNext();
                Worker w = seatecAstronomy42.next();
                {
                    ncompleted += w.completedTasks;
                    {
                        boolean var522A9CF7E3545C172CF36E5345BFAC72_1584160462 = (w.isLocked());
                        ++nactive;
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
        String varFEE103B8838FAC52A03AAD564FBB278B_1124707225 = (super.toString() +
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.086 -0400", hash_original_method = "4C3878CDFFA0878930C89982189B5032", hash_generated_method = "4F3AFF7D69C8BE36B2ECDA13922FCDC7")
    @DSModeled(DSC.SAFE)
    protected void beforeExecute(Thread t, Runnable r) {
        dsTaint.addTaint(t.dsTaint);
        dsTaint.addTaint(r.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.086 -0400", hash_original_method = "1E835AC60F46FC4FB8E958FFB42880D4", hash_generated_method = "6157F0D4BA552554BC0F7ABDF7509B1E")
    @DSModeled(DSC.SAFE)
    protected void afterExecute(Runnable r, Throwable t) {
        dsTaint.addTaint(t.dsTaint);
        dsTaint.addTaint(r.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.086 -0400", hash_original_method = "A29D7F7280B94AB8E3FBFAF6674D4BBC", hash_generated_method = "E30E383294027854FBD1335FB4F11A6A")
    @DSModeled(DSC.SAFE)
    protected void terminated() {
        // ---------- Original Method ----------
    }

    
    private final class Worker extends AbstractQueuedSynchronizer implements Runnable {
        private static final long serialVersionUID = 6138294804551838833L;
        final Thread thread;
        Runnable firstTask;
        volatile long completedTasks;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.086 -0400", hash_original_method = "8E628C9261C64BEE296D97D919DD4FB9", hash_generated_method = "9253A83C72ACA7BE3D0559795B93EA7A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         Worker(Runnable firstTask) {
            dsTaint.addTaint(firstTask.dsTaint);
            this.thread = getThreadFactory().newThread(this);
            // ---------- Original Method ----------
            //this.firstTask = firstTask;
            //this.thread = getThreadFactory().newThread(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.086 -0400", hash_original_method = "776DC8B2F80D9EC817EF7446A13B40B9", hash_generated_method = "78ED496D88E89FE3D1E4055F33D87370")
        @DSModeled(DSC.SAFE)
        public void run() {
            runWorker(this);
            // ---------- Original Method ----------
            //runWorker(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.086 -0400", hash_original_method = "C9E6BAFAC050F423C4392C73A0972F98", hash_generated_method = "8EA59F0621AD8CC31FBBDAD060CD5CA2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected boolean isHeldExclusively() {
            boolean var19B741D0D216C6237072ABA5B53D29C0_1873637013 = (getState() == 1);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return getState() == 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.087 -0400", hash_original_method = "48A928967742ABFEBADE0574311D01BE", hash_generated_method = "C0FECA7F22A782743C4354CC7966FA63")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected boolean tryAcquire(int unused) {
            dsTaint.addTaint(unused);
            {
                boolean varF425053993EA879E03DA150C877D7F5C_1823368710 = (compareAndSetState(0, 1));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.087 -0400", hash_original_method = "CF73EFA48EB2690CB7BA351224285F0C", hash_generated_method = "4A93B0CDEAD0F445F7F644D4FA8DC425")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.087 -0400", hash_original_method = "E6AC2D5893CA21F5681F81CF00C94AEB", hash_generated_method = "35C5540C0AD3C6DCD6A4B72A83FA2A87")
        @DSModeled(DSC.SAFE)
        public void lock() {
            acquire(1);
            // ---------- Original Method ----------
            //acquire(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.087 -0400", hash_original_method = "0FBAB3A752D629DDEE7FCF88CA811E1B", hash_generated_method = "551314A6C52468975F188C48B16CA10E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean tryLock() {
            boolean var983EB53456294FEAD564C34A6EB40052_1832624778 = (tryAcquire(1));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return tryAcquire(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.087 -0400", hash_original_method = "375F138297D7668DFC40E00540A7DE61", hash_generated_method = "3624B05341B7A96FAE829FF90781D708")
        @DSModeled(DSC.SAFE)
        public void unlock() {
            release(1);
            // ---------- Original Method ----------
            //release(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.087 -0400", hash_original_method = "0FBE2B31D6107275F6E2B1C06D400675", hash_generated_method = "41C641D0EE3129B7C0CDBE1AD8F7729A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean isLocked() {
            boolean var7307B0E63112DD101487F0593BCA6CC3_1799727483 = (isHeldExclusively());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return isHeldExclusively();
        }

        
    }


    
    public static class CallerRunsPolicy implements RejectedExecutionHandler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.087 -0400", hash_original_method = "0024AA22CD353D26AF52EE7A7BFF5B6A", hash_generated_method = "017EBF34A937C8D6C78F295880640495")
        @DSModeled(DSC.SAFE)
        public CallerRunsPolicy() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.087 -0400", hash_original_method = "1E8BCB605E875657A6EC0245732A9544", hash_generated_method = "5FCEA6004821B62D07A99829BB2565FE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            dsTaint.addTaint(e.dsTaint);
            dsTaint.addTaint(r.dsTaint);
            {
                boolean var25A2508FD0F77674F14744C27A3265D3_1306817524 = (!e.isShutdown());
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.087 -0400", hash_original_method = "0E304EA6C47EF7342B79AE7423647CD0", hash_generated_method = "A0DF89FDD5481B43102613A412714D65")
        @DSModeled(DSC.SAFE)
        public AbortPolicy() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.087 -0400", hash_original_method = "499AAA3E1602997D93E7C4E818F2EBAC", hash_generated_method = "93A703326B7B98E2132F4E3517485995")
        @DSModeled(DSC.SAFE)
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            dsTaint.addTaint(e.dsTaint);
            dsTaint.addTaint(r.dsTaint);
            throw new RejectedExecutionException("Task " + r.toString() +
                                                 " rejected from " +
                                                 e.toString());
            // ---------- Original Method ----------
            //throw new RejectedExecutionException("Task " + r.toString() +
                                                 //" rejected from " +
                                                 //e.toString());
        }

        
    }


    
    public static class DiscardPolicy implements RejectedExecutionHandler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.087 -0400", hash_original_method = "F09B76305D692D1CB8CB62E17F499CB5", hash_generated_method = "6963966D3F9B926C5104CFCEF881FA0A")
        @DSModeled(DSC.SAFE)
        public DiscardPolicy() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.087 -0400", hash_original_method = "81B7AD8C9B3A9908C7C41F3CCCB6E30B", hash_generated_method = "777D93D47EC76F6EC564F76CCA9A8FDD")
        @DSModeled(DSC.SAFE)
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            dsTaint.addTaint(e.dsTaint);
            dsTaint.addTaint(r.dsTaint);
            // ---------- Original Method ----------
        }

        
    }


    
    public static class DiscardOldestPolicy implements RejectedExecutionHandler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.087 -0400", hash_original_method = "7D42DC0AF0C4E1A1DAE9147B8685950D", hash_generated_method = "49012A472DBBA0C1C29DA09A83A0EC90")
        @DSModeled(DSC.SAFE)
        public DiscardOldestPolicy() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.087 -0400", hash_original_method = "BC4245492A96EB743D1DE4975B9A07C3", hash_generated_method = "F23C3922BBFF0D5C7607136F14C4A3EA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            dsTaint.addTaint(e.dsTaint);
            dsTaint.addTaint(r.dsTaint);
            {
                boolean var25A2508FD0F77674F14744C27A3265D3_2051614809 = (!e.isShutdown());
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


    
}


