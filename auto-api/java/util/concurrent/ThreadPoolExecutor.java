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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.908 -0400", hash_original_field = "A307605A799A74057344483C24FB3CBD", hash_generated_field = "56FF12A82BDA1C2A55082B25F4945E37")

    private AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.908 -0400", hash_original_field = "AD0CB0F61A61787BC239059154A854CE", hash_generated_field = "9E38919357211CC9BEEC80B9F9218347")

    private BlockingQueue<Runnable> workQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.908 -0400", hash_original_field = "79D8A014138E753409EEB9BD3FB796A2", hash_generated_field = "A9C6167F7869CEA592BE0D401A3C4B31")

    private ReentrantLock mainLock = new ReentrantLock();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.908 -0400", hash_original_field = "1BF38840E9A66810DC9BC3F81C6E2B56", hash_generated_field = "2B87C3BFCD67AD82D16EC85966FD04E8")

    private HashSet<Worker> workers = new HashSet<Worker>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.908 -0400", hash_original_field = "6F97F9147FB6F0EABAC633096CD156DF", hash_generated_field = "9852601D86B0C07034C8756174AEC06E")

    private Condition termination = mainLock.newCondition();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.908 -0400", hash_original_field = "847B488AE80482898780783A82B6764E", hash_generated_field = "121D2FE9A0E8A1127142F5163851FF7A")

    private int largestPoolSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.908 -0400", hash_original_field = "3017365C67C7718D5147FA190DD40A62", hash_generated_field = "35D6F2A97FA4C37D9711DD0E18037068")

    private long completedTaskCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.908 -0400", hash_original_field = "DCEABFFDB4C91584FC9D3ABFD745936C", hash_generated_field = "33CDA4329AB239C031EC6036B92EA4D7")

    private volatile ThreadFactory threadFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.908 -0400", hash_original_field = "C1CBFE271A40788A00E8BF8574D94D4B", hash_generated_field = "A77EE44F4E847B2CFCF9F9BFF9F8D340")

    private volatile RejectedExecutionHandler handler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.909 -0400", hash_original_field = "66B6676E2358CA03897CC4A63783399D", hash_generated_field = "1EC333D36EC5007BBF0C2C3B15635A7F")

    private volatile long keepAliveTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.909 -0400", hash_original_field = "8479D8297F4B7D8A1CB6952389C8EDC1", hash_generated_field = "E539670BC9790CFFAAC6CA7187FC01F4")

    private volatile boolean allowCoreThreadTimeOut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.909 -0400", hash_original_field = "BC84A0387FED241C4B869E825402E08F", hash_generated_field = "FAC62E0577D05948399014C56DA3CCEB")

    private volatile int corePoolSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.909 -0400", hash_original_field = "54A9EC393DB750BE987C30FFF3A375D2", hash_generated_field = "6C06C7B0806878AD4FB9956F328CBE28")

    private volatile int maximumPoolSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.909 -0400", hash_original_method = "6852B7239AD6D12F00F6FD31EAEE07F2", hash_generated_method = "FBE4044BADAAC96D5B2C575DEE4173F1")
    public  ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
             Executors.defaultThreadFactory(), defaultHandler);
        addTaint(corePoolSize);
        addTaint(maximumPoolSize);
        addTaint(keepAliveTime);
        addTaint(unit.getTaint());
        addTaint(workQueue.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.909 -0400", hash_original_method = "472CB7CD686E5ED3EB32346C564DBF00", hash_generated_method = "609A21BDC5DC9D2E9FE8684C9951DFAC")
    public  ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              ThreadFactory threadFactory) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
             threadFactory, defaultHandler);
        addTaint(corePoolSize);
        addTaint(maximumPoolSize);
        addTaint(keepAliveTime);
        addTaint(unit.getTaint());
        addTaint(workQueue.getTaint());
        addTaint(threadFactory.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.910 -0400", hash_original_method = "13BA0DF22A91EC098F651B146B1F0D91", hash_generated_method = "A587E33489D704564D43BBD37E111950")
    public  ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              RejectedExecutionHandler handler) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
             Executors.defaultThreadFactory(), handler);
        addTaint(corePoolSize);
        addTaint(maximumPoolSize);
        addTaint(keepAliveTime);
        addTaint(unit.getTaint());
        addTaint(workQueue.getTaint());
        addTaint(handler.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.911 -0400", hash_original_method = "7927F5CAD81FDA69C812A57334363D0A", hash_generated_method = "1FB812B81C71E3DE8D7CAC0B3A0DACD8")
    public  ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              ThreadFactory threadFactory,
                              RejectedExecutionHandler handler) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.940 -0400", hash_original_method = "AB721E5F3628508DEF5AE872A937DFD4", hash_generated_method = "3003D0774A584BDAD7F9D5DBDC9963FD")
    private boolean compareAndIncrementWorkerCount(int expect) {
        boolean var0D25B4A75418F47C3A1EE479FF3954DB_1238937984 = (ctl.compareAndSet(expect, expect + 1));
        addTaint(expect);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1870520901 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1870520901;
        // ---------- Original Method ----------
        //return ctl.compareAndSet(expect, expect + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.941 -0400", hash_original_method = "046A4642208AB0946E7553D201BA8A62", hash_generated_method = "2934F509555C163B61FBEEB86F08AF72")
    private boolean compareAndDecrementWorkerCount(int expect) {
        boolean varCEAB9D2C7D844A2C607832120A9DF559_1105290104 = (ctl.compareAndSet(expect, expect - 1));
        addTaint(expect);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_646331660 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_646331660;
        // ---------- Original Method ----------
        //return ctl.compareAndSet(expect, expect - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.941 -0400", hash_original_method = "197D64850896CFE44F6E60A0B666E58B", hash_generated_method = "90D3430929F0449BF9A246BEF6304C00")
    private void decrementWorkerCount() {
        {
            boolean var9E72ADC6AC1B6DC8A6652AF23ECFA13A_799467184 = (! compareAndDecrementWorkerCount(ctl.get()));
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //do {} while (! compareAndDecrementWorkerCount(ctl.get()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.942 -0400", hash_original_method = "F2BE86117A689CA9DA89AB2ED7F58DB7", hash_generated_method = "71472C81A569C8221EABB1496A81F734")
    private void advanceRunState(int targetState) {
        {
            int c;
            c = ctl.get();
            {
                boolean var377820E787C2969E8C3C8BC9C2D5039B_1297124180 = (runStateAtLeast(c, targetState) ||
                ctl.compareAndSet(c, ctlOf(targetState, workerCountOf(c))));
            } //End collapsed parenthetic
        } //End block
        addTaint(targetState);
        // ---------- Original Method ----------
        //for (;;) {
            //int c = ctl.get();
            //if (runStateAtLeast(c, targetState) ||
                //ctl.compareAndSet(c, ctlOf(targetState, workerCountOf(c))))
                //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.942 -0400", hash_original_method = "80042B52D4C8A465DC8857956BEE8BCA", hash_generated_method = "37CB51D7AB503671A5A1C1EF67763C3D")
    final void tryTerminate() {
        {
            int c;
            c = ctl.get();
            {
                boolean var74E7770FE49A3B736EAFA345B26F794C_1964723286 = (isRunning(c) ||
                runStateAtLeast(c, TIDYING) ||
                (runStateOf(c) == SHUTDOWN && ! workQueue.isEmpty()));
            } //End collapsed parenthetic
            {
                boolean var15C00CEC4F0FF9F08AE224FA2AB90491_1194035758 = (workerCountOf(c) != 0);
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
                    boolean var14DDDB09283814740A1263C9A3AF2248_1369685170 = (ctl.compareAndSet(c, ctlOf(TIDYING, 0)));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.007 -0400", hash_original_method = "AA36F499694835EB802B188BC7C59A14", hash_generated_method = "B3D2809A761ADA6D55E8FE7EFCBEB204")
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
                    Iterator<Worker> var6931C42F4C1AD656649FE9715A90096D_1670967699 = (workers).iterator();
                    var6931C42F4C1AD656649FE9715A90096D_1670967699.hasNext();
                    Worker w = var6931C42F4C1AD656649FE9715A90096D_1670967699.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.104 -0400", hash_original_method = "3FD8BB870BC89D5588F0560753D4337F", hash_generated_method = "C11A670FEF9E5FF82631A8EC05A6038E")
    private void interruptWorkers() {
        ReentrantLock mainLock;
        mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            {
                Iterator<Worker> var6931C42F4C1AD656649FE9715A90096D_403916607 = (workers).iterator();
                var6931C42F4C1AD656649FE9715A90096D_403916607.hasNext();
                Worker w = var6931C42F4C1AD656649FE9715A90096D_403916607.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.211 -0400", hash_original_method = "C11819B67BF410300D59BD8104FE87A4", hash_generated_method = "2F92D8E06130781FF7DBEF16B46CCAF3")
    private void interruptIdleWorkers(boolean onlyOne) {
        ReentrantLock mainLock;
        mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            {
                Iterator<Worker> var6931C42F4C1AD656649FE9715A90096D_28016583 = (workers).iterator();
                var6931C42F4C1AD656649FE9715A90096D_28016583.hasNext();
                Worker w = var6931C42F4C1AD656649FE9715A90096D_28016583.next();
                {
                    Thread t;
                    t = w.thread;
                    {
                        boolean varF302C64E2A8A3FADF9D2B8BA25676B4F_1664753993 = (!t.isInterrupted() && w.tryLock());
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
        addTaint(onlyOne);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.212 -0400", hash_original_method = "8AE0F2FE6E5901DBE1EC6FD71BA67D3B", hash_generated_method = "5A72F35E8F8382990E1FD3DE61AAA8EA")
    private void interruptIdleWorkers() {
        interruptIdleWorkers(false);
        // ---------- Original Method ----------
        //interruptIdleWorkers(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.213 -0400", hash_original_method = "41D1BD0CB95E0A52108020867995148C", hash_generated_method = "E64747FC847AD3DA2C119BEA55480721")
    private void clearInterruptsForTaskRun() {
        {
            boolean var6ECBD5FE4E49C98E8A2343B113A3ED8B_1976494949 = (runStateLessThan(ctl.get(), STOP) &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.214 -0400", hash_original_method = "DBD2AA47670972F837B77D54B6813996", hash_generated_method = "843942F6F18190C6E577182957B98B11")
    final void reject(Runnable command) {
        handler.rejectedExecution(command, this);
        addTaint(command.getTaint());
        // ---------- Original Method ----------
        //handler.rejectedExecution(command, this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.214 -0400", hash_original_method = "0A1F69177689475EC5D7889C7292052F", hash_generated_method = "A8810A0A581CC8BD0FA906871342B1C5")
     void onShutdown() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.214 -0400", hash_original_method = "270A029E5D11891F0D07089698FD1A31", hash_generated_method = "DF326F940352AC54D0B54BB17CE57B10")
    final boolean isRunningOrShutdown(boolean shutdownOK) {
        int rs;
        rs = runStateOf(ctl.get());
        addTaint(shutdownOK);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_644568496 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_644568496;
        // ---------- Original Method ----------
        //int rs = runStateOf(ctl.get());
        //return rs == RUNNING || (rs == SHUTDOWN && shutdownOK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.256 -0400", hash_original_method = "4695ACF3E76D112BC6AF0E9543CB0BFB", hash_generated_method = "26A2F9F120362D1866913B66E8D7C780")
    private List<Runnable> drainQueue() {
        List<Runnable> varB4EAC82CA7396A68D541C85D26508E83_2095765852 = null; //Variable for return #1
        BlockingQueue<Runnable> q;
        q = workQueue;
        List<Runnable> taskList;
        taskList = new ArrayList<Runnable>();
        q.drainTo(taskList);
        {
            boolean var24D3CA3473EF320EA6AF15C01960EBAE_771249757 = (!q.isEmpty());
            {
                {
                    Iterator<Runnable> var9EF8E3C34F168ACADC01921A433EFEF9_353448518 = (q.toArray(new Runnable[0])).iterator();
                    var9EF8E3C34F168ACADC01921A433EFEF9_353448518.hasNext();
                    Runnable r = var9EF8E3C34F168ACADC01921A433EFEF9_353448518.next();
                    {
                        {
                            boolean var8576918424BDAE7AC11C88E260CF968E_2039437155 = (q.remove(r));
                            taskList.add(r);
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2095765852 = taskList;
        varB4EAC82CA7396A68D541C85D26508E83_2095765852.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2095765852;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.264 -0400", hash_original_method = "7812A944CC6B2EE743043503F380EB35", hash_generated_method = "9D7AC7F01DE1E476561A6A0CD8BB92A3")
    private boolean addWorker(Runnable firstTask, boolean core) {
        {
            int c;
            c = ctl.get();
            int rs;
            rs = runStateOf(c);
            {
                boolean varA0E9E20F717B7D472E07BEC2B53FC068_96013318 = (rs >= SHUTDOWN &&
                ! (rs == SHUTDOWN &&
                   firstTask == null &&
                   ! workQueue.isEmpty()));
            } //End collapsed parenthetic
            {
                int wc;
                wc = workerCountOf(c);
                {
                    boolean varD3106FA273E29E33F79B0F29BC71E3E9_755071827 = (compareAndIncrementWorkerCount(c));
                } //End collapsed parenthetic
                c = ctl.get();
                {
                    boolean var006D8DC234DA1DD78318D93B61711BB4_142919170 = (runStateOf(c) != rs);
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
            boolean var1EB04529E4A4A4FAC968DC4C0BDBF0D5_695615014 = (runStateOf(ctl.get()) == STOP && ! t.isInterrupted());
            t.interrupt();
        } //End collapsed parenthetic
        addTaint(firstTask.getTaint());
        addTaint(core);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_156889977 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_156889977;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.265 -0400", hash_original_method = "98853BED73C436EB42A5D4B84EE5AAA8", hash_generated_method = "74E0A61ADA84FDAA1418D05934C37041")
    private void processWorkerExit(Worker w, boolean completedAbruptly) {
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
            boolean var5863C63A1BA4393B602043CEAC609960_1455567159 = (runStateLessThan(c, STOP));
            {
                {
                    int min;
                    min = 0;
                    min = corePoolSize;
                    {
                        boolean var6D8D038A4484600C74CF88FBA3B0A889_1212461377 = (min == 0 && ! workQueue.isEmpty());
                        min = 1;
                    } //End collapsed parenthetic
                    {
                        boolean varABFCCB119B36440534356FFDFEBD1734_1352736280 = (workerCountOf(c) >= min);
                    } //End collapsed parenthetic
                } //End block
                addWorker(null, false);
            } //End block
        } //End collapsed parenthetic
        addTaint(completedAbruptly);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.344 -0400", hash_original_method = "CCE5E762047CA277EB153A60A9218EEF", hash_generated_method = "9583CA1DB0987604FEA5308334249639")
    private Runnable getTask() {
        Runnable varB4EAC82CA7396A68D541C85D26508E83_1261177781 = null; //Variable for return #1
        Runnable varB4EAC82CA7396A68D541C85D26508E83_71179497 = null; //Variable for return #2
        Runnable varB4EAC82CA7396A68D541C85D26508E83_227546041 = null; //Variable for return #3
        boolean timedOut;
        timedOut = false;
        {
            int c;
            c = ctl.get();
            int rs;
            rs = runStateOf(c);
            {
                boolean var74A3816C5E5F9D38AA1ACD2BDAD2E3B8_592902472 = (rs >= SHUTDOWN && (rs >= STOP || workQueue.isEmpty()));
                {
                    decrementWorkerCount();
                    varB4EAC82CA7396A68D541C85D26508E83_1261177781 = null;
                } //End block
            } //End collapsed parenthetic
            boolean timed;
            {
                int wc;
                wc = workerCountOf(c);
                timed = allowCoreThreadTimeOut || wc > corePoolSize;
                {
                    boolean var6AE6FD94B8549E87FF836D5CDDE57650_124685475 = (compareAndDecrementWorkerCount(c));
                    varB4EAC82CA7396A68D541C85D26508E83_71179497 = null;
                } //End collapsed parenthetic
                c = ctl.get();
                {
                    boolean var006D8DC234DA1DD78318D93B61711BB4_679501934 = (runStateOf(c) != rs);
                } //End collapsed parenthetic
            } //End block
            try 
            {
                Runnable r;
                r = workQueue.poll(keepAliveTime, TimeUnit.NANOSECONDS);
                r = workQueue.take();
                varB4EAC82CA7396A68D541C85D26508E83_227546041 = r;
                timedOut = true;
            } //End block
            catch (InterruptedException retry)
            {
                timedOut = false;
            } //End block
        } //End block
        Runnable varA7E53CE21691AB073D9660D615818899_542469049; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_542469049 = varB4EAC82CA7396A68D541C85D26508E83_1261177781;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_542469049 = varB4EAC82CA7396A68D541C85D26508E83_71179497;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_542469049 = varB4EAC82CA7396A68D541C85D26508E83_227546041;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_542469049.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_542469049;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.346 -0400", hash_original_method = "55359692B6793E8A8B1383DAA231ACAC", hash_generated_method = "3E6102BD25FEADBDB6A6D31104F46A3C")
    final void runWorker(Worker w) {
        Runnable task;
        task = w.firstTask;
        w.firstTask = null;
        boolean completedAbruptly;
        completedAbruptly = true;
        try 
        {
            {
                boolean var0A8D38871405FE6EBA17CA92E1725233_1965490510 = (task != null || (task = getTask()) != null);
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
        addTaint(w.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.348 -0400", hash_original_method = "D2720E6C2ABD70ABBFB850D5E1C9152E", hash_generated_method = "920D767A0C03535CBC77CDC8D300A918")
    public void execute(Runnable command) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        int c;
        c = ctl.get();
        {
            boolean var2DAF44B9E4AFD0B4443B645D193B1C58_1616981343 = (workerCountOf(c) < corePoolSize);
            {
                {
                    boolean varF2EFA0687D3A42E9CB40767BB4923E49_2106562698 = (addWorker(command, true));
                } //End collapsed parenthetic
                c = ctl.get();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var4A9938DA2F57582B9B2A24D4AB9321D5_2002297416 = (isRunning(c) && workQueue.offer(command));
            {
                int recheck;
                recheck = ctl.get();
                {
                    boolean var2016F270A276BB1ABC44EDF164942688_221522850 = (! isRunning(recheck) && remove(command));
                    reject(command);
                    {
                        boolean varAA10E01B7AA21E8BCFA73D357B3B2488_2045819929 = (workerCountOf(recheck) == 0);
                        addWorker(null, false);
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
            {
                boolean varA615DB9E0F0C450CB87AF373F5D24117_572148623 = (!addWorker(command, false));
                reject(command);
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(command.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.349 -0400", hash_original_method = "B2E77DE3594C1CCAEA14C26F5B572C39", hash_generated_method = "357CDF6EDD9490DE996143E392EB0474")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.354 -0400", hash_original_method = "D65CB76EC87687B7E50B9EEFFDD4C298", hash_generated_method = "4B1703CABB11EA988DD50A4AFDFA790A")
    public List<Runnable> shutdownNow() {
        List<Runnable> varB4EAC82CA7396A68D541C85D26508E83_46257309 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_46257309 = tasks;
        varB4EAC82CA7396A68D541C85D26508E83_46257309.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_46257309;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.354 -0400", hash_original_method = "968CAF504B3356CA71CED595275477F9", hash_generated_method = "A72CE23E82ACEBF0E5FB166FEC734F89")
    public boolean isShutdown() {
        boolean varF33AAB80735339C8E62ED2354FD74B60_2131385542 = (! isRunning(ctl.get()));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_452254446 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_452254446;
        // ---------- Original Method ----------
        //return ! isRunning(ctl.get());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.363 -0400", hash_original_method = "1B50F454F3FDC6963CA79768BA657116", hash_generated_method = "DC4E9949FC329EF9CE47034C1E5BC4B1")
    public boolean isTerminating() {
        int c;
        c = ctl.get();
        boolean varE0B540E2ECAB27CA369AF9F26DBBDA29_1584967266 = (! isRunning(c) && runStateLessThan(c, TERMINATED));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1960285348 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1960285348;
        // ---------- Original Method ----------
        //int c = ctl.get();
        //return ! isRunning(c) && runStateLessThan(c, TERMINATED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.364 -0400", hash_original_method = "9F60EBE4EAB8D07AF1E9485C91ACF37E", hash_generated_method = "68E3135A06178BCC341283A332DE393A")
    public boolean isTerminated() {
        boolean var9820E1CCF8E41D81F088906A90AC2F49_2105354179 = (runStateAtLeast(ctl.get(), TERMINATED));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_131821300 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_131821300;
        // ---------- Original Method ----------
        //return runStateAtLeast(ctl.get(), TERMINATED);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.367 -0400", hash_original_method = "D4E88A24481EFB5D05D58739D7C6B24D", hash_generated_method = "D463F0617EF5AC52974393F68CB82426")
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        long nanos;
        nanos = unit.toNanos(timeout);
        ReentrantLock mainLock;
        mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            {
                {
                    boolean var0E078804F1366C01333D9AD026B9E5A4_878771714 = (runStateAtLeast(ctl.get(), TERMINATED));
                } //End collapsed parenthetic
                nanos = termination.awaitNanos(nanos);
            } //End block
        } //End block
        finally 
        {
            mainLock.unlock();
        } //End block
        addTaint(timeout);
        addTaint(unit.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1924114592 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1924114592;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.367 -0400", hash_original_method = "54A2A12810CC337A284FDAF9A692A515", hash_generated_method = "57134A5D1161D28260EB34D287472E08")
    protected void finalize() {
        shutdown();
        // ---------- Original Method ----------
        //shutdown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.384 -0400", hash_original_method = "59E32FCC6E49B2109079BB0F3E4FFE2B", hash_generated_method = "A88DED1D742F584BEAE5A804A420AB50")
    public void setThreadFactory(ThreadFactory threadFactory) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        this.threadFactory = threadFactory;
        // ---------- Original Method ----------
        //if (threadFactory == null)
            //throw new NullPointerException();
        //this.threadFactory = threadFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.385 -0400", hash_original_method = "304653AC486A914BB8844AA1040FA7EB", hash_generated_method = "17A988EB64FE8B4274973018CC2F6632")
    public ThreadFactory getThreadFactory() {
        ThreadFactory varB4EAC82CA7396A68D541C85D26508E83_2003350164 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2003350164 = threadFactory;
        varB4EAC82CA7396A68D541C85D26508E83_2003350164.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2003350164;
        // ---------- Original Method ----------
        //return threadFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.385 -0400", hash_original_method = "7F03D06860A87C46B9897C91E7329182", hash_generated_method = "69935C6E7F8CF7E6CF73E6589A399FE1")
    public void setRejectedExecutionHandler(RejectedExecutionHandler handler) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        this.handler = handler;
        // ---------- Original Method ----------
        //if (handler == null)
            //throw new NullPointerException();
        //this.handler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.387 -0400", hash_original_method = "6DBE484B7F2A61BE5C5EC698F3E381D8", hash_generated_method = "C86A51306EFD321700D3B67EC36E41D2")
    public RejectedExecutionHandler getRejectedExecutionHandler() {
        RejectedExecutionHandler varB4EAC82CA7396A68D541C85D26508E83_80654716 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_80654716 = handler;
        varB4EAC82CA7396A68D541C85D26508E83_80654716.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_80654716;
        // ---------- Original Method ----------
        //return handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.388 -0400", hash_original_method = "753479E48A5DF49EEF8BAF55BE437F30", hash_generated_method = "18CB1713D5A130F19740BE561E1D6203")
    public void setCorePoolSize(int corePoolSize) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        int delta;
        delta = corePoolSize - this.corePoolSize;
        this.corePoolSize = corePoolSize;
        {
            boolean varF68CA397C3D415D393630F535946AE03_393513307 = (workerCountOf(ctl.get()) > corePoolSize);
            interruptIdleWorkers();
            {
                int k;
                k = Math.min(delta, workQueue.size());
                {
                    boolean varEF5AAA249FA3E26F2F3951ACFA377289_1309877475 = (k-- > 0 && addWorker(null, true));
                    {
                        {
                            boolean var2AF1FFECF97D5086EAD41EBD9DCCCBAF_1725827555 = (workQueue.isEmpty());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.389 -0400", hash_original_method = "51C354BC1AFFD9D1E19ED52BB81EBE2C", hash_generated_method = "750B38B19FF2B9AF257625F2D3619103")
    public int getCorePoolSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2005990428 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2005990428;
        // ---------- Original Method ----------
        //return corePoolSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.390 -0400", hash_original_method = "C3B1E657CEA1E5B0B9267C982B6F89C3", hash_generated_method = "3005416246E6674314E41053F5576812")
    public boolean prestartCoreThread() {
        boolean var500E50B69291F8AC83E0DBD4A5C0288F_1670092298 = (workerCountOf(ctl.get()) < corePoolSize &&
            addWorker(null, true));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_114571126 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_114571126;
        // ---------- Original Method ----------
        //return workerCountOf(ctl.get()) < corePoolSize &&
            //addWorker(null, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.390 -0400", hash_original_method = "BD3CEF4F9337B2BC7C235E398D43BE2A", hash_generated_method = "4B9D891DC8DBE9756BCBD5CA3315C1EF")
    public int prestartAllCoreThreads() {
        int n;
        n = 0;
        {
            boolean var096EA4F950A8AEAC16821018608A2A21_1699522916 = (addWorker(null, true));
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1062148007 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1062148007;
        // ---------- Original Method ----------
        //int n = 0;
        //while (addWorker(null, true))
            //++n;
        //return n;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.398 -0400", hash_original_method = "B47D14DD952D3505364B334F55BDAD78", hash_generated_method = "40991E18045E3F4CAD1E4E439E83441B")
    public boolean allowsCoreThreadTimeOut() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1747106812 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1747106812;
        // ---------- Original Method ----------
        //return allowCoreThreadTimeOut;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.400 -0400", hash_original_method = "3CB040DA26A3A7AB5E245CC61764B17D", hash_generated_method = "85D9BB0D78E10396CBC3943BF9368F98")
    public void allowCoreThreadTimeOut(boolean value) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Core threads must have nonzero keep alive times");
        {
            allowCoreThreadTimeOut = value;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.405 -0400", hash_original_method = "21349012A93D2851376CF1101665B5CB", hash_generated_method = "BC7E26294EE4DCDDFB6BDBF86724914B")
    public void setMaximumPoolSize(int maximumPoolSize) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        this.maximumPoolSize = maximumPoolSize;
        {
            boolean var05D3AFE401306D7B03478EC9AD8483E3_1934438849 = (workerCountOf(ctl.get()) > maximumPoolSize);
            interruptIdleWorkers();
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (maximumPoolSize <= 0 || maximumPoolSize < corePoolSize)
            //throw new IllegalArgumentException();
        //this.maximumPoolSize = maximumPoolSize;
        //if (workerCountOf(ctl.get()) > maximumPoolSize)
            //interruptIdleWorkers();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.405 -0400", hash_original_method = "4164BA9A7B4677354D8831E6C94ADF71", hash_generated_method = "5893363BBCEA197944261995009073F2")
    public int getMaximumPoolSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_803505608 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_803505608;
        // ---------- Original Method ----------
        //return maximumPoolSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.410 -0400", hash_original_method = "863FC09A28296060918F86FB184DF489", hash_generated_method = "DB456FAC79424CCBA1BE34C400631E40")
    public void setKeepAliveTime(long time, TimeUnit unit) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        {
            boolean varE36A88334ABAF702C248888F469CB1B5_1513063420 = (time == 0 && allowsCoreThreadTimeOut());
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Core threads must have nonzero keep alive times");
        } //End collapsed parenthetic
        long keepAliveTime;
        keepAliveTime = unit.toNanos(time);
        long delta;
        delta = keepAliveTime - this.keepAliveTime;
        this.keepAliveTime = keepAliveTime;
        interruptIdleWorkers();
        addTaint(time);
        addTaint(unit.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.427 -0400", hash_original_method = "DF59E7D78F54A4D1FBC20C042F5F1838", hash_generated_method = "33442118486A2D113FEE330BCAE18972")
    public long getKeepAliveTime(TimeUnit unit) {
        long var21762EF164EDAA82F42EC374AF5B3AFC_791308172 = (unit.convert(keepAliveTime, TimeUnit.NANOSECONDS));
        addTaint(unit.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1974057403 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1974057403;
        // ---------- Original Method ----------
        //return unit.convert(keepAliveTime, TimeUnit.NANOSECONDS);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.428 -0400", hash_original_method = "BD8FCC0E1F95E7B090761BC333422796", hash_generated_method = "B1A4F62F6FD9C1B0781D29B8CDB748DC")
    public BlockingQueue<Runnable> getQueue() {
        BlockingQueue<Runnable> varB4EAC82CA7396A68D541C85D26508E83_181249352 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_181249352 = workQueue;
        varB4EAC82CA7396A68D541C85D26508E83_181249352.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_181249352;
        // ---------- Original Method ----------
        //return workQueue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.429 -0400", hash_original_method = "79BF7D79C72AB53C9D385B8F29AB696D", hash_generated_method = "7298941171013B9DFB5C8033204A59B4")
    public boolean remove(Runnable task) {
        boolean removed;
        removed = workQueue.remove(task);
        tryTerminate();
        addTaint(task.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1628727994 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1628727994;
        // ---------- Original Method ----------
        //boolean removed = workQueue.remove(task);
        //tryTerminate();
        //return removed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.587 -0400", hash_original_method = "9B9E8DAAF98D7F6DDC91DC997B50219A", hash_generated_method = "43932800D8E4ADAF4106BFE8ACF98C71")
    public void purge() {
        BlockingQueue<Runnable> q;
        q = workQueue;
        try 
        {
            Iterator<Runnable> it;
            it = q.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_736278646 = (it.hasNext());
                {
                    Runnable r;
                    r = it.next();
                    {
                        boolean var270276E750C193C865B578E1AE2E22C1_1101339208 = (r instanceof Future<?> && ((Future<?>)r).isCancelled());
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
                    boolean var4E8BBA7479E6059D39986F5769B4F8FA_279708316 = (r instanceof Future<?> && ((Future<?>)r).isCancelled());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.589 -0400", hash_original_method = "4852DC9A347396E4E4A26FF1AFDF98FD", hash_generated_method = "49B72A80DE85A8B5FAADF3B8A41AFD3E")
    public int getPoolSize() {
        ReentrantLock mainLock;
        mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            {
                boolean varF68CB7F835009006B5FA4F669CE04294_372974290 = (runStateAtLeast(ctl.get(), TIDYING));
                Object var741C3FF695A194FA69D4BFA4908B5EDF_486318415 = (workers.size());
            } //End flattened ternary
        } //End block
        finally 
        {
            mainLock.unlock();
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_433453849 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_433453849;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.687 -0400", hash_original_method = "F897DAAB3F6E4FA542BB8276CD2A7AD3", hash_generated_method = "1EE3285C641C9FF3B2C060C77328B6F7")
    public int getActiveCount() {
        ReentrantLock mainLock;
        mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            int n;
            n = 0;
            {
                Iterator<Worker> var6931C42F4C1AD656649FE9715A90096D_998521678 = (workers).iterator();
                var6931C42F4C1AD656649FE9715A90096D_998521678.hasNext();
                Worker w = var6931C42F4C1AD656649FE9715A90096D_998521678.next();
                {
                    boolean varBC60F1E56E351594899C6DC36F026C6D_810835586 = (w.isLocked());
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            mainLock.unlock();
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1707427786 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1707427786;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.687 -0400", hash_original_method = "B4A579D5588949E5556CF38ABCB55065", hash_generated_method = "9DCA143282D30840F9D47CA5519EB900")
    public int getLargestPoolSize() {
        ReentrantLock mainLock;
        mainLock = this.mainLock;
        mainLock.lock();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1487641682 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1487641682;
        // ---------- Original Method ----------
        //final ReentrantLock mainLock = this.mainLock;
        //mainLock.lock();
        //try {
            //return largestPoolSize;
        //} finally {
            //mainLock.unlock();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.759 -0400", hash_original_method = "145E6751E1E0E0F3E4FA35DB76B7EDE5", hash_generated_method = "0BEEFD06BEB636B6530CCE4187FCA61C")
    public long getTaskCount() {
        ReentrantLock mainLock;
        mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            long n;
            n = completedTaskCount;
            {
                Iterator<Worker> var6931C42F4C1AD656649FE9715A90096D_1804499143 = (workers).iterator();
                var6931C42F4C1AD656649FE9715A90096D_1804499143.hasNext();
                Worker w = var6931C42F4C1AD656649FE9715A90096D_1804499143.next();
                {
                    n += w.completedTasks;
                    {
                        boolean var522A9CF7E3545C172CF36E5345BFAC72_1193126436 = (w.isLocked());
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            long varB956FA447F2D153BA84914B4AF4D6590_444078315 = (n + workQueue.size());
        } //End block
        finally 
        {
            mainLock.unlock();
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_460079297 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_460079297;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.807 -0400", hash_original_method = "C21C1799DAC41B07982333C8F3E02012", hash_generated_method = "3C37F0FF47E738605B0671A110BBE80C")
    public long getCompletedTaskCount() {
        ReentrantLock mainLock;
        mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            long n;
            n = completedTaskCount;
            {
                Iterator<Worker> var6931C42F4C1AD656649FE9715A90096D_1219255625 = (workers).iterator();
                var6931C42F4C1AD656649FE9715A90096D_1219255625.hasNext();
                Worker w = var6931C42F4C1AD656649FE9715A90096D_1219255625.next();
                n += w.completedTasks;
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            mainLock.unlock();
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1781199005 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1781199005;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.964 -0400", hash_original_method = "AA5F5BF44F4DA05ED8C1D4957936AC31", hash_generated_method = "C1409F9EFE750440DED86470FCCC3E0C")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1525442491 = null; //Variable for return #1
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
                Iterator<Worker> var6931C42F4C1AD656649FE9715A90096D_1157822824 = (workers).iterator();
                var6931C42F4C1AD656649FE9715A90096D_1157822824.hasNext();
                Worker w = var6931C42F4C1AD656649FE9715A90096D_1157822824.next();
                {
                    ncompleted += w.completedTasks;
                    {
                        boolean var522A9CF7E3545C172CF36E5345BFAC72_1213116518 = (w.isLocked());
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
        varB4EAC82CA7396A68D541C85D26508E83_1525442491 = super.toString() +
            "[" + rs +
            ", pool size = " + nworkers +
            ", active threads = " + nactive +
            ", queued tasks = " + workQueue.size() +
            ", completed tasks = " + ncompleted +
            "]";
        varB4EAC82CA7396A68D541C85D26508E83_1525442491.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1525442491;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.968 -0400", hash_original_method = "4C3878CDFFA0878930C89982189B5032", hash_generated_method = "695E162B3A9788D8D0A44B85DD6CC7FB")
    protected void beforeExecute(Thread t, Runnable r) {
        addTaint(t.getTaint());
        addTaint(r.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.969 -0400", hash_original_method = "1E835AC60F46FC4FB8E958FFB42880D4", hash_generated_method = "5571B558345407E7529C983C9B921829")
    protected void afterExecute(Runnable r, Throwable t) {
        addTaint(r.getTaint());
        addTaint(t.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.969 -0400", hash_original_method = "A29D7F7280B94AB8E3FBFAF6674D4BBC", hash_generated_method = "F157B5EF4A6890FC5741BB31F75810D9")
    protected void terminated() {
        // ---------- Original Method ----------
    }

    
    private final class Worker extends AbstractQueuedSynchronizer implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.969 -0400", hash_original_field = "DC127F5D2483352FD20EADDB38FEB6D2", hash_generated_field = "AB87C4F6E5547EBD7483F34732EA576D")

        Thread thread;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.969 -0400", hash_original_field = "AB088EE69C51E9415A270FBD75F5B952", hash_generated_field = "52D2DAE86CEE20DA5D093E6C8E8D890A")

        Runnable firstTask;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.969 -0400", hash_original_field = "3537605F39622BC6E15B1019401ED976", hash_generated_field = "A27B0F0FE609EB920C0300ECD3CAA2E3")

        volatile long completedTasks;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.970 -0400", hash_original_method = "8E628C9261C64BEE296D97D919DD4FB9", hash_generated_method = "4DEC29ECDD14EB9919329B70C54FB56D")
          Worker(Runnable firstTask) {
            this.firstTask = firstTask;
            this.thread = getThreadFactory().newThread(this);
            // ---------- Original Method ----------
            //this.firstTask = firstTask;
            //this.thread = getThreadFactory().newThread(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.970 -0400", hash_original_method = "776DC8B2F80D9EC817EF7446A13B40B9", hash_generated_method = "1D172B8AE706040037220A6FE99238AC")
        public void run() {
            runWorker(this);
            // ---------- Original Method ----------
            //runWorker(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.971 -0400", hash_original_method = "C9E6BAFAC050F423C4392C73A0972F98", hash_generated_method = "47307D24B9193F02DC7C08FEA932263E")
        protected boolean isHeldExclusively() {
            boolean var19B741D0D216C6237072ABA5B53D29C0_142892580 = (getState() == 1);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2123936502 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2123936502;
            // ---------- Original Method ----------
            //return getState() == 1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.971 -0400", hash_original_method = "48A928967742ABFEBADE0574311D01BE", hash_generated_method = "F9E83B3F4F1C6EB1704CD7478A63E9BC")
        protected boolean tryAcquire(int unused) {
            {
                boolean varF425053993EA879E03DA150C877D7F5C_1613648670 = (compareAndSetState(0, 1));
                {
                    setExclusiveOwnerThread(Thread.currentThread());
                } //End block
            } //End collapsed parenthetic
            addTaint(unused);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_870343168 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_870343168;
            // ---------- Original Method ----------
            //if (compareAndSetState(0, 1)) {
                //setExclusiveOwnerThread(Thread.currentThread());
                //return true;
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.972 -0400", hash_original_method = "CF73EFA48EB2690CB7BA351224285F0C", hash_generated_method = "EE69F078FF96ED62A5B3EA6B97F08ABD")
        protected boolean tryRelease(int unused) {
            setExclusiveOwnerThread(null);
            setState(0);
            addTaint(unused);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_541704259 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_541704259;
            // ---------- Original Method ----------
            //setExclusiveOwnerThread(null);
            //setState(0);
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.981 -0400", hash_original_method = "E6AC2D5893CA21F5681F81CF00C94AEB", hash_generated_method = "E250ED120425ABD3596F0FB44742AE76")
        public void lock() {
            acquire(1);
            // ---------- Original Method ----------
            //acquire(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.981 -0400", hash_original_method = "0FBAB3A752D629DDEE7FCF88CA811E1B", hash_generated_method = "0187853065BC73201E20FCE460F6110E")
        public boolean tryLock() {
            boolean var983EB53456294FEAD564C34A6EB40052_2021686560 = (tryAcquire(1));
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1503534758 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1503534758;
            // ---------- Original Method ----------
            //return tryAcquire(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.987 -0400", hash_original_method = "375F138297D7668DFC40E00540A7DE61", hash_generated_method = "9980155D40CCECC3DD5DA1A3CA7D2CB7")
        public void unlock() {
            release(1);
            // ---------- Original Method ----------
            //release(1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.988 -0400", hash_original_method = "0FBE2B31D6107275F6E2B1C06D400675", hash_generated_method = "579E0DCA5A07D36101241CC57840155A")
        public boolean isLocked() {
            boolean var7307B0E63112DD101487F0593BCA6CC3_2031013872 = (isHeldExclusively());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1372021848 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1372021848;
            // ---------- Original Method ----------
            //return isHeldExclusively();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.988 -0400", hash_original_field = "CD164B34526C2858AEAF8B60C2D2C494", hash_generated_field = "F18E1D1BE8C7C6B9D63B859471C02515")

        private static long serialVersionUID = 6138294804551838833L;
    }


    
    public static class CallerRunsPolicy implements RejectedExecutionHandler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:58.996 -0400", hash_original_method = "0024AA22CD353D26AF52EE7A7BFF5B6A", hash_generated_method = "EE6F5E0062E38533EDD0CC7DB47C5E41")
        public  CallerRunsPolicy() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.000 -0400", hash_original_method = "1E8BCB605E875657A6EC0245732A9544", hash_generated_method = "ACA2A62977855F1E250D4A3B31E3785F")
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            {
                boolean var25A2508FD0F77674F14744C27A3265D3_43435004 = (!e.isShutdown());
                {
                    r.run();
                } //End block
            } //End collapsed parenthetic
            addTaint(r.getTaint());
            addTaint(e.getTaint());
            // ---------- Original Method ----------
            //if (!e.isShutdown()) {
                //r.run();
            //}
        }

        
    }


    
    public static class AbortPolicy implements RejectedExecutionHandler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.001 -0400", hash_original_method = "0E304EA6C47EF7342B79AE7423647CD0", hash_generated_method = "179F0278660B104E944DF3C713C65A75")
        public  AbortPolicy() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.012 -0400", hash_original_method = "499AAA3E1602997D93E7C4E818F2EBAC", hash_generated_method = "EFE6E1EE41233AD052BA4B7817BED0D7")
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            if (DroidSafeAndroidRuntime.control) throw new RejectedExecutionException("Task " + r.toString() +
                                                 " rejected from " +
                                                 e.toString());
            addTaint(r.getTaint());
            addTaint(e.getTaint());
            // ---------- Original Method ----------
            //throw new RejectedExecutionException("Task " + r.toString() +
                                                 //" rejected from " +
                                                 //e.toString());
        }

        
    }


    
    public static class DiscardPolicy implements RejectedExecutionHandler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.013 -0400", hash_original_method = "F09B76305D692D1CB8CB62E17F499CB5", hash_generated_method = "C4B475A3525556F9D1B8C945DF152CD4")
        public  DiscardPolicy() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.013 -0400", hash_original_method = "81B7AD8C9B3A9908C7C41F3CCCB6E30B", hash_generated_method = "3F6D29A84EB37505757D74358D3B6FBC")
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            addTaint(r.getTaint());
            addTaint(e.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    public static class DiscardOldestPolicy implements RejectedExecutionHandler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.013 -0400", hash_original_method = "7D42DC0AF0C4E1A1DAE9147B8685950D", hash_generated_method = "887F469A96FA729D52338C565521C0C6")
        public  DiscardOldestPolicy() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.014 -0400", hash_original_method = "BC4245492A96EB743D1DE4975B9A07C3", hash_generated_method = "81C3A4C54C0B152B3A28E291AEB58666")
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            {
                boolean var25A2508FD0F77674F14744C27A3265D3_1827240058 = (!e.isShutdown());
                {
                    e.getQueue().poll();
                    e.execute(r);
                } //End block
            } //End collapsed parenthetic
            addTaint(r.getTaint());
            addTaint(e.getTaint());
            // ---------- Original Method ----------
            //if (!e.isShutdown()) {
                //e.getQueue().poll();
                //e.execute(r);
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.014 -0400", hash_original_field = "2AD2E6A7A23B57F7662422A52B95CC09", hash_generated_field = "8B95AD04DC9E61A27923B0230DD10993")

    private static int COUNT_BITS = Integer.SIZE - 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.014 -0400", hash_original_field = "6F4706F438E735959AC77A0E013826F9", hash_generated_field = "B61A28C84DF65F1D3F46BC07D3D44FDD")

    private static int CAPACITY = (1 << COUNT_BITS) - 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.014 -0400", hash_original_field = "7E2DC2CDAE866B990CCFB9F99485888D", hash_generated_field = "ECB41A5732A87B94018DCE6BC31C5BB6")

    private static int RUNNING = -1 << COUNT_BITS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.014 -0400", hash_original_field = "F45465E1DCD849E3752A2369BF892D71", hash_generated_field = "FDC5B8D737A65FB71CE2A672D82006AE")

    private static int SHUTDOWN = 0 << COUNT_BITS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.014 -0400", hash_original_field = "04AE349763D898E1D79F4CA49A2289E1", hash_generated_field = "C4A10B0CF492CCDBAE29A80C76C75740")

    private static int STOP = 1 << COUNT_BITS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.014 -0400", hash_original_field = "90217937E23D86674136EE5F6F9762F5", hash_generated_field = "9DC19E3ECB9B0A379B330C5E4EA22BA1")

    private static int TIDYING = 2 << COUNT_BITS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.015 -0400", hash_original_field = "A23623286A319227DF0EDB01163E3BBD", hash_generated_field = "7BDBF712E8EA9131082D188647728761")

    private static int TERMINATED = 3 << COUNT_BITS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.015 -0400", hash_original_field = "5AA44F02EBBBA45DF7D7B7C9828E325E", hash_generated_field = "C7D3E6F08C9F71289D6C8E415AF9D46B")

    private static RejectedExecutionHandler defaultHandler = new AbortPolicy();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.015 -0400", hash_original_field = "C6A5F234FA8B366F73521414CAEB2E7B", hash_generated_field = "ABDED740608BE81ED5E35E316F0C6534")

    private static RuntimePermission shutdownPerm = new RuntimePermission("modifyThread");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.015 -0400", hash_original_field = "DCF5310FAB389A27E2F24E12DE639C90", hash_generated_field = "45E967A019D264CF663531F30F5AE324")

    private static boolean ONLY_ONE = true;
}

