package java.util.concurrent;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.concurrent.locks.*;
import java.util.concurrent.atomic.*;
import java.util.*;

public class ThreadPoolExecutor extends AbstractExecutorService {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.162 -0400", hash_original_field = "A307605A799A74057344483C24FB3CBD", hash_generated_field = "1E5D76E2038757171D1F1EFB86BB7B2D")

    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.162 -0400", hash_original_field = "AD0CB0F61A61787BC239059154A854CE", hash_generated_field = "9E38919357211CC9BEEC80B9F9218347")

    private BlockingQueue<Runnable> workQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.162 -0400", hash_original_field = "79D8A014138E753409EEB9BD3FB796A2", hash_generated_field = "7B35E916BB35C7F976B4653697B4DA98")

    private final ReentrantLock mainLock = new ReentrantLock();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.162 -0400", hash_original_field = "1BF38840E9A66810DC9BC3F81C6E2B56", hash_generated_field = "EB2024D5E063C0CD7389C2261AC46D0A")

    private final HashSet<Worker> workers = new HashSet<Worker>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.162 -0400", hash_original_field = "6F97F9147FB6F0EABAC633096CD156DF", hash_generated_field = "2C20C5A8E5FB5CFA430FBF7CD68E16F8")

    private final Condition termination = mainLock.newCondition();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.162 -0400", hash_original_field = "847B488AE80482898780783A82B6764E", hash_generated_field = "121D2FE9A0E8A1127142F5163851FF7A")

    private int largestPoolSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.162 -0400", hash_original_field = "3017365C67C7718D5147FA190DD40A62", hash_generated_field = "35D6F2A97FA4C37D9711DD0E18037068")

    private long completedTaskCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.162 -0400", hash_original_field = "DCEABFFDB4C91584FC9D3ABFD745936C", hash_generated_field = "33CDA4329AB239C031EC6036B92EA4D7")

    private volatile ThreadFactory threadFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.162 -0400", hash_original_field = "C1CBFE271A40788A00E8BF8574D94D4B", hash_generated_field = "A77EE44F4E847B2CFCF9F9BFF9F8D340")

    private volatile RejectedExecutionHandler handler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.162 -0400", hash_original_field = "66B6676E2358CA03897CC4A63783399D", hash_generated_field = "1EC333D36EC5007BBF0C2C3B15635A7F")

    private volatile long keepAliveTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.163 -0400", hash_original_field = "8479D8297F4B7D8A1CB6952389C8EDC1", hash_generated_field = "E539670BC9790CFFAAC6CA7187FC01F4")

    private volatile boolean allowCoreThreadTimeOut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.163 -0400", hash_original_field = "BC84A0387FED241C4B869E825402E08F", hash_generated_field = "FAC62E0577D05948399014C56DA3CCEB")

    private volatile int corePoolSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.163 -0400", hash_original_field = "54A9EC393DB750BE987C30FFF3A375D2", hash_generated_field = "6C06C7B0806878AD4FB9956F328CBE28")

    private volatile int maximumPoolSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.163 -0400", hash_original_method = "6852B7239AD6D12F00F6FD31EAEE07F2", hash_generated_method = "FBE4044BADAAC96D5B2C575DEE4173F1")
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
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.163 -0400", hash_original_method = "472CB7CD686E5ED3EB32346C564DBF00", hash_generated_method = "609A21BDC5DC9D2E9FE8684C9951DFAC")
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
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.163 -0400", hash_original_method = "13BA0DF22A91EC098F651B146B1F0D91", hash_generated_method = "A587E33489D704564D43BBD37E111950")
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
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.164 -0400", hash_original_method = "7927F5CAD81FDA69C812A57334363D0A", hash_generated_method = "1FB812B81C71E3DE8D7CAC0B3A0DACD8")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.165 -0400", hash_original_method = "AB721E5F3628508DEF5AE872A937DFD4", hash_generated_method = "E8E1FB0E744931F957C5FA5B0B304332")
    private boolean compareAndIncrementWorkerCount(int expect) {
        boolean var0D25B4A75418F47C3A1EE479FF3954DB_1159899436 = (ctl.compareAndSet(expect, expect + 1));
        addTaint(expect);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_515139490 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_515139490;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.166 -0400", hash_original_method = "046A4642208AB0946E7553D201BA8A62", hash_generated_method = "13BB9A9A9A3416C9A513FDAE7AD504FF")
    private boolean compareAndDecrementWorkerCount(int expect) {
        boolean varCEAB9D2C7D844A2C607832120A9DF559_1869918352 = (ctl.compareAndSet(expect, expect - 1));
        addTaint(expect);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1741746755 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1741746755;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.166 -0400", hash_original_method = "197D64850896CFE44F6E60A0B666E58B", hash_generated_method = "F54F8A429506A3E9BF789D340C57887D")
    private void decrementWorkerCount() {
        {
            boolean var9E72ADC6AC1B6DC8A6652AF23ECFA13A_92757482 = (! compareAndDecrementWorkerCount(ctl.get()));
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.167 -0400", hash_original_method = "F2BE86117A689CA9DA89AB2ED7F58DB7", hash_generated_method = "36904528D1C385BA6C1F6C14D7F26319")
    private void advanceRunState(int targetState) {
        {
            int c = ctl.get();
            {
                boolean var377820E787C2969E8C3C8BC9C2D5039B_1987795452 = (runStateAtLeast(c, targetState) ||
                ctl.compareAndSet(c, ctlOf(targetState, workerCountOf(c))));
            } 
        } 
        addTaint(targetState);
        
        
            
            
                
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.168 -0400", hash_original_method = "80042B52D4C8A465DC8857956BEE8BCA", hash_generated_method = "582E206A31E432C491F222303C370360")
    final void tryTerminate() {
        {
            int c = ctl.get();
            {
                boolean var74E7770FE49A3B736EAFA345B26F794C_1605697477 = (isRunning(c) ||
                runStateAtLeast(c, TIDYING) ||
                (runStateOf(c) == SHUTDOWN && ! workQueue.isEmpty()));
            } 
            {
                boolean var15C00CEC4F0FF9F08AE224FA2AB90491_383423094 = (workerCountOf(c) != 0);
                {
                    interruptIdleWorkers(ONLY_ONE);
                } 
            } 
            final ReentrantLock mainLock = this.mainLock;
            mainLock.lock();
            try 
            {
                {
                    boolean var14DDDB09283814740A1263C9A3AF2248_1250969902 = (ctl.compareAndSet(c, ctlOf(TIDYING, 0)));
                    {
                        try 
                        {
                            terminated();
                        } 
                        finally 
                        {
                            ctl.set(ctlOf(TERMINATED, 0));
                            termination.signalAll();
                        } 
                    } 
                } 
            } 
            finally 
            {
                mainLock.unlock();
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.172 -0400", hash_original_method = "AA36F499694835EB802B188BC7C59A14", hash_generated_method = "06C4281B8B348FBB3BBC07F3FFEC743A")
    private void checkShutdownAccess() {
        SecurityManager security = System.getSecurityManager();
        {
            security.checkPermission(shutdownPerm);
            final ReentrantLock mainLock = this.mainLock;
            mainLock.lock();
            try 
            {
                {
                    Iterator<Worker> var6931C42F4C1AD656649FE9715A90096D_1886702992 = (workers).iterator();
                    var6931C42F4C1AD656649FE9715A90096D_1886702992.hasNext();
                    Worker w = var6931C42F4C1AD656649FE9715A90096D_1886702992.next();
                    security.checkAccess(w.thread);
                } 
            } 
            finally 
            {
                mainLock.unlock();
            } 
        } 
        
        
        
            
            
            
            
                
                    
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.176 -0400", hash_original_method = "3FD8BB870BC89D5588F0560753D4337F", hash_generated_method = "B85C3BBCFDB667C96111FF704ADCB2B9")
    private void interruptWorkers() {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            {
                Iterator<Worker> var6931C42F4C1AD656649FE9715A90096D_2022996322 = (workers).iterator();
                var6931C42F4C1AD656649FE9715A90096D_2022996322.hasNext();
                Worker w = var6931C42F4C1AD656649FE9715A90096D_2022996322.next();
                {
                    try 
                    {
                        w.thread.interrupt();
                    } 
                    catch (SecurityException ignore)
                    { }
                } 
            } 
        } 
        finally 
        {
            mainLock.unlock();
        } 
        
        
        
        
            
                
                    
                
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.184 -0400", hash_original_method = "C11819B67BF410300D59BD8104FE87A4", hash_generated_method = "07768E6CCFFF2C8619F820B8A75DF0EE")
    private void interruptIdleWorkers(boolean onlyOne) {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            {
                Iterator<Worker> var6931C42F4C1AD656649FE9715A90096D_86428091 = (workers).iterator();
                var6931C42F4C1AD656649FE9715A90096D_86428091.hasNext();
                Worker w = var6931C42F4C1AD656649FE9715A90096D_86428091.next();
                {
                    Thread t = w.thread;
                    {
                        boolean varF302C64E2A8A3FADF9D2B8BA25676B4F_1963276969 = (!t.isInterrupted() && w.tryLock());
                        {
                            try 
                            {
                                t.interrupt();
                            } 
                            catch (SecurityException ignore)
                            { }
                            finally 
                            {
                                w.unlock();
                            } 
                        } 
                    } 
                } 
            } 
        } 
        finally 
        {
            mainLock.unlock();
        } 
        addTaint(onlyOne);
        
        
        
        
            
                
                
                    
                        
                    
                    
                        
                    
                
                
                    
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.184 -0400", hash_original_method = "8AE0F2FE6E5901DBE1EC6FD71BA67D3B", hash_generated_method = "5A72F35E8F8382990E1FD3DE61AAA8EA")
    private void interruptIdleWorkers() {
        interruptIdleWorkers(false);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.185 -0400", hash_original_method = "41D1BD0CB95E0A52108020867995148C", hash_generated_method = "5B706AFE715C952CE3A9AE42EE408F30")
    private void clearInterruptsForTaskRun() {
        {
            boolean var6ECBD5FE4E49C98E8A2343B113A3ED8B_772780193 = (runStateLessThan(ctl.get(), STOP) &&
            Thread.interrupted() &&
            runStateAtLeast(ctl.get(), STOP));
            Thread.currentThread().interrupt();
        } 
        
        
            
            
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.185 -0400", hash_original_method = "DBD2AA47670972F837B77D54B6813996", hash_generated_method = "843942F6F18190C6E577182957B98B11")
    final void reject(Runnable command) {
        handler.rejectedExecution(command, this);
        addTaint(command.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.185 -0400", hash_original_method = "0A1F69177689475EC5D7889C7292052F", hash_generated_method = "A8810A0A581CC8BD0FA906871342B1C5")
     void onShutdown() {
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.185 -0400", hash_original_method = "270A029E5D11891F0D07089698FD1A31", hash_generated_method = "C29E217DDA68AFFC53639BC236A47C5A")
    final boolean isRunningOrShutdown(boolean shutdownOK) {
        int rs = runStateOf(ctl.get());
        addTaint(shutdownOK);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2111537618 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2111537618;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.190 -0400", hash_original_method = "4695ACF3E76D112BC6AF0E9543CB0BFB", hash_generated_method = "3A34452FF741ECA75276BB5BBED0F622")
    private List<Runnable> drainQueue() {
        List<Runnable> varB4EAC82CA7396A68D541C85D26508E83_627223557 = null; 
        BlockingQueue<Runnable> q = workQueue;
        List<Runnable> taskList = new ArrayList<Runnable>();
        q.drainTo(taskList);
        {
            boolean var24D3CA3473EF320EA6AF15C01960EBAE_706255328 = (!q.isEmpty());
            {
                {
                    Runnable r = q.toArray(new Runnable[0])[0];
                    {
                        {
                            boolean var8576918424BDAE7AC11C88E260CF968E_1697624208 = (q.remove(r));
                            taskList.add(r);
                        } 
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_627223557 = taskList;
        varB4EAC82CA7396A68D541C85D26508E83_627223557.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_627223557;
        
        
        
        
        
            
                
                    
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.191 -0400", hash_original_method = "7812A944CC6B2EE743043503F380EB35", hash_generated_method = "204A7FBA6AA037678E3C54B330B507E5")
    private boolean addWorker(Runnable firstTask, boolean core) {
        {
            int c = ctl.get();
            int rs = runStateOf(c);
            {
                boolean varA0E9E20F717B7D472E07BEC2B53FC068_720405137 = (rs >= SHUTDOWN &&
                ! (rs == SHUTDOWN &&
                   firstTask == null &&
                   ! workQueue.isEmpty()));
            } 
            {
                int wc = workerCountOf(c);
                {
                    boolean varD3106FA273E29E33F79B0F29BC71E3E9_1460549087 = (compareAndIncrementWorkerCount(c));
                } 
                c = ctl.get();
                {
                    boolean var006D8DC234DA1DD78318D93B61711BB4_2100985367 = (runStateOf(c) != rs);
                } 
            } 
        } 
        Worker w = new Worker(firstTask);
        Thread t = w.thread;
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            int c = ctl.get();
            int rs = runStateOf(c);
            {
                decrementWorkerCount();
                tryTerminate();
            } 
            workers.add(w);
            int s = workers.size();
            largestPoolSize = s;
        } 
        finally 
        {
            mainLock.unlock();
        } 
        t.start();
        {
            boolean var1EB04529E4A4A4FAC968DC4C0BDBF0D5_370247167 = (runStateOf(ctl.get()) == STOP && ! t.isInterrupted());
            t.interrupt();
        } 
        addTaint(firstTask.getTaint());
        addTaint(core);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2078127375 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2078127375;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.192 -0400", hash_original_method = "98853BED73C436EB42A5D4B84EE5AAA8", hash_generated_method = "920AE6A2F5C7B59F092F1D2AA9B560B6")
    private void processWorkerExit(Worker w, boolean completedAbruptly) {
        decrementWorkerCount();
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            completedTaskCount += w.completedTasks;
            workers.remove(w);
        } 
        finally 
        {
            mainLock.unlock();
        } 
        tryTerminate();
        int c = ctl.get();
        {
            boolean var5863C63A1BA4393B602043CEAC609960_1563787419 = (runStateLessThan(c, STOP));
            {
                {
                    int min;
                    min = 0;
                    min = corePoolSize;
                    {
                        boolean var6D8D038A4484600C74CF88FBA3B0A889_835619924 = (min == 0 && ! workQueue.isEmpty());
                        min = 1;
                    } 
                    {
                        boolean varABFCCB119B36440534356FFDFEBD1734_388048410 = (workerCountOf(c) >= min);
                    } 
                } 
                addWorker(null, false);
            } 
        } 
        addTaint(completedAbruptly);
        
        
            
        
        
        
            
            
        
            
        
        
        
        
            
                
                
                    
                
                    
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.193 -0400", hash_original_method = "CCE5E762047CA277EB153A60A9218EEF", hash_generated_method = "9F76E4685FCBAD8F4F019AB22079FBA7")
    private Runnable getTask() {
        Runnable varB4EAC82CA7396A68D541C85D26508E83_1361426928 = null; 
        Runnable varB4EAC82CA7396A68D541C85D26508E83_812316812 = null; 
        Runnable varB4EAC82CA7396A68D541C85D26508E83_1816906029 = null; 
        boolean timedOut = false;
        {
            int c = ctl.get();
            int rs = runStateOf(c);
            {
                boolean var74A3816C5E5F9D38AA1ACD2BDAD2E3B8_1434815218 = (rs >= SHUTDOWN && (rs >= STOP || workQueue.isEmpty()));
                {
                    decrementWorkerCount();
                    varB4EAC82CA7396A68D541C85D26508E83_1361426928 = null;
                } 
            } 
            boolean timed;
            {
                int wc = workerCountOf(c);
                timed = allowCoreThreadTimeOut || wc > corePoolSize;
                {
                    boolean var6AE6FD94B8549E87FF836D5CDDE57650_1449404972 = (compareAndDecrementWorkerCount(c));
                    varB4EAC82CA7396A68D541C85D26508E83_812316812 = null;
                } 
                c = ctl.get();
                {
                    boolean var006D8DC234DA1DD78318D93B61711BB4_1784948096 = (runStateOf(c) != rs);
                } 
            } 
            try 
            {
                Runnable r;
                r = workQueue.poll(keepAliveTime, TimeUnit.NANOSECONDS);
                r = workQueue.take();
                varB4EAC82CA7396A68D541C85D26508E83_1816906029 = r;
                timedOut = true;
            } 
            catch (InterruptedException retry)
            {
                timedOut = false;
            } 
        } 
        Runnable varA7E53CE21691AB073D9660D615818899_108963955; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_108963955 = varB4EAC82CA7396A68D541C85D26508E83_1361426928;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_108963955 = varB4EAC82CA7396A68D541C85D26508E83_812316812;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_108963955 = varB4EAC82CA7396A68D541C85D26508E83_1816906029;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_108963955.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_108963955;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.194 -0400", hash_original_method = "55359692B6793E8A8B1383DAA231ACAC", hash_generated_method = "13543119BDFBDFAD8427D2DDA9F59082")
    final void runWorker(Worker w) {
        Runnable task = w.firstTask;
        w.firstTask = null;
        boolean completedAbruptly = true;
        try 
        {
            {
                boolean var0A8D38871405FE6EBA17CA92E1725233_670128955 = (task != null || (task = getTask()) != null);
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
                        } 
                        catch (RuntimeException x)
                        {
                            thrown = x;
                            if (DroidSafeAndroidRuntime.control) throw x;
                        } 
                        catch (Error x)
                        {
                            thrown = x;
                            if (DroidSafeAndroidRuntime.control) throw x;
                        } 
                        catch (Throwable x)
                        {
                            thrown = x;
                            if (DroidSafeAndroidRuntime.control) throw new Error(x);
                        } 
                        finally 
                        {
                            afterExecute(task, thrown);
                        } 
                    } 
                    finally 
                    {
                        task = null;
                        w.unlock();
                    } 
                } 
            } 
            completedAbruptly = false;
        } 
        finally 
        {
            processWorkerExit(w, completedAbruptly);
        } 
        addTaint(w.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.195 -0400", hash_original_method = "D2720E6C2ABD70ABBFB850D5E1C9152E", hash_generated_method = "BE982933F99083E5432BCFF28733163F")
    public void execute(Runnable command) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        int c = ctl.get();
        {
            boolean var2DAF44B9E4AFD0B4443B645D193B1C58_59860470 = (workerCountOf(c) < corePoolSize);
            {
                {
                    boolean varF2EFA0687D3A42E9CB40767BB4923E49_552019201 = (addWorker(command, true));
                } 
                c = ctl.get();
            } 
        } 
        {
            boolean var4A9938DA2F57582B9B2A24D4AB9321D5_263182475 = (isRunning(c) && workQueue.offer(command));
            {
                int recheck = ctl.get();
                {
                    boolean var2016F270A276BB1ABC44EDF164942688_1247411739 = (! isRunning(recheck) && remove(command));
                    reject(command);
                    {
                        boolean varAA10E01B7AA21E8BCFA73D357B3B2488_1327931040 = (workerCountOf(recheck) == 0);
                        addWorker(null, false);
                    } 
                } 
            } 
            {
                boolean varA615DB9E0F0C450CB87AF373F5D24117_1003703695 = (!addWorker(command, false));
                reject(command);
            } 
        } 
        addTaint(command.getTaint());
        
        
            
        
        
            
                
            
        
        
            
            
                
            
                
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.196 -0400", hash_original_method = "B2E77DE3594C1CCAEA14C26F5B572C39", hash_generated_method = "556962D5741EED8D70DCDA38C6FF2F42")
    public void shutdown() {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            checkShutdownAccess();
            advanceRunState(SHUTDOWN);
            interruptIdleWorkers();
            onShutdown();
        } 
        finally 
        {
            mainLock.unlock();
        } 
        tryTerminate();
        
        
        
        
            
            
            
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.198 -0400", hash_original_method = "D65CB76EC87687B7E50B9EEFFDD4C298", hash_generated_method = "5D3B060566E3A1921E02DFD124ACA799")
    public List<Runnable> shutdownNow() {
        List<Runnable> varB4EAC82CA7396A68D541C85D26508E83_1881440208 = null; 
        List<Runnable> tasks;
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            checkShutdownAccess();
            advanceRunState(STOP);
            interruptWorkers();
            tasks = drainQueue();
        } 
        finally 
        {
            mainLock.unlock();
        } 
        tryTerminate();
        varB4EAC82CA7396A68D541C85D26508E83_1881440208 = tasks;
        varB4EAC82CA7396A68D541C85D26508E83_1881440208.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1881440208;
        
        
        
        
        
            
            
            
            
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.199 -0400", hash_original_method = "968CAF504B3356CA71CED595275477F9", hash_generated_method = "78C28230A48DEB5D464BF98EFE4196C5")
    public boolean isShutdown() {
        boolean varF33AAB80735339C8E62ED2354FD74B60_138709195 = (! isRunning(ctl.get()));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1521055378 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1521055378;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.200 -0400", hash_original_method = "1B50F454F3FDC6963CA79768BA657116", hash_generated_method = "6624AC9672ABFFDA06389A72744C52BB")
    public boolean isTerminating() {
        int c = ctl.get();
        boolean varE0B540E2ECAB27CA369AF9F26DBBDA29_455056514 = (! isRunning(c) && runStateLessThan(c, TERMINATED));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_28823827 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_28823827;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.201 -0400", hash_original_method = "9F60EBE4EAB8D07AF1E9485C91ACF37E", hash_generated_method = "1772FC4295B8D81301FEAB17897718D9")
    public boolean isTerminated() {
        boolean var9820E1CCF8E41D81F088906A90AC2F49_223988238 = (runStateAtLeast(ctl.get(), TERMINATED));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_845243869 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_845243869;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.203 -0400", hash_original_method = "D4E88A24481EFB5D05D58739D7C6B24D", hash_generated_method = "9FDB9EFDECDE6C945FC058D11800E579")
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        long nanos = unit.toNanos(timeout);
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            {
                {
                    boolean var0E078804F1366C01333D9AD026B9E5A4_51391061 = (runStateAtLeast(ctl.get(), TERMINATED));
                } 
                nanos = termination.awaitNanos(nanos);
            } 
        } 
        finally 
        {
            mainLock.unlock();
        } 
        addTaint(timeout);
        addTaint(unit.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1614837427 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1614837427;
        
        
        
        
        
            
                
                    
                
                    
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.204 -0400", hash_original_method = "54A2A12810CC337A284FDAF9A692A515", hash_generated_method = "57134A5D1161D28260EB34D287472E08")
    protected void finalize() {
        shutdown();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.205 -0400", hash_original_method = "59E32FCC6E49B2109079BB0F3E4FFE2B", hash_generated_method = "A88DED1D742F584BEAE5A804A420AB50")
    public void setThreadFactory(ThreadFactory threadFactory) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        this.threadFactory = threadFactory;
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.206 -0400", hash_original_method = "304653AC486A914BB8844AA1040FA7EB", hash_generated_method = "C007348DC07E525492F357A41A24B6EA")
    public ThreadFactory getThreadFactory() {
        ThreadFactory varB4EAC82CA7396A68D541C85D26508E83_2014873921 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2014873921 = threadFactory;
        varB4EAC82CA7396A68D541C85D26508E83_2014873921.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2014873921;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.206 -0400", hash_original_method = "7F03D06860A87C46B9897C91E7329182", hash_generated_method = "69935C6E7F8CF7E6CF73E6589A399FE1")
    public void setRejectedExecutionHandler(RejectedExecutionHandler handler) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        this.handler = handler;
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.207 -0400", hash_original_method = "6DBE484B7F2A61BE5C5EC698F3E381D8", hash_generated_method = "1AB24D65F86869BB9C93C01B72793DEC")
    public RejectedExecutionHandler getRejectedExecutionHandler() {
        RejectedExecutionHandler varB4EAC82CA7396A68D541C85D26508E83_991063695 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_991063695 = handler;
        varB4EAC82CA7396A68D541C85D26508E83_991063695.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_991063695;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.207 -0400", hash_original_method = "753479E48A5DF49EEF8BAF55BE437F30", hash_generated_method = "6E94A9F32B12C5C85B7F9848B8FAF29E")
    public void setCorePoolSize(int corePoolSize) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        int delta = corePoolSize - this.corePoolSize;
        this.corePoolSize = corePoolSize;
        {
            boolean varF68CA397C3D415D393630F535946AE03_1807694115 = (workerCountOf(ctl.get()) > corePoolSize);
            interruptIdleWorkers();
            {
                int k = Math.min(delta, workQueue.size());
                {
                    boolean varEF5AAA249FA3E26F2F3951ACFA377289_826907890 = (k-- > 0 && addWorker(null, true));
                    {
                        {
                            boolean var2AF1FFECF97D5086EAD41EBD9DCCCBAF_1950448072 = (workQueue.isEmpty());
                        } 
                    } 
                } 
            } 
        } 
        
        
            
        
        
        
            
        
            
            
                
                    
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.208 -0400", hash_original_method = "51C354BC1AFFD9D1E19ED52BB81EBE2C", hash_generated_method = "04B1B39C5DF67AFE914D35D0E9371273")
    public int getCorePoolSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1500779267 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1500779267;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.208 -0400", hash_original_method = "C3B1E657CEA1E5B0B9267C982B6F89C3", hash_generated_method = "F6392A5E3A499A7EAB98CB19BE947EE2")
    public boolean prestartCoreThread() {
        boolean var500E50B69291F8AC83E0DBD4A5C0288F_389735976 = (workerCountOf(ctl.get()) < corePoolSize &&
            addWorker(null, true));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1471500391 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1471500391;
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.209 -0400", hash_original_method = "BD3CEF4F9337B2BC7C235E398D43BE2A", hash_generated_method = "28BE3DC4D81729E7F73748F3B3D3D850")
    public int prestartAllCoreThreads() {
        int n = 0;
        {
            boolean var096EA4F950A8AEAC16821018608A2A21_19938394 = (addWorker(null, true));
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_900815835 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_900815835;
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.210 -0400", hash_original_method = "B47D14DD952D3505364B334F55BDAD78", hash_generated_method = "E0B0583680914EB6E55A38D347459620")
    public boolean allowsCoreThreadTimeOut() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1780481581 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1780481581;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.211 -0400", hash_original_method = "3CB040DA26A3A7AB5E245CC61764B17D", hash_generated_method = "85D9BB0D78E10396CBC3943BF9368F98")
    public void allowCoreThreadTimeOut(boolean value) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Core threads must have nonzero keep alive times");
        {
            allowCoreThreadTimeOut = value;
            interruptIdleWorkers();
        } 
        
        
            
        
            
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.211 -0400", hash_original_method = "21349012A93D2851376CF1101665B5CB", hash_generated_method = "1DCD5CFF286710F7DDBF71CDF83A86CC")
    public void setMaximumPoolSize(int maximumPoolSize) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        this.maximumPoolSize = maximumPoolSize;
        {
            boolean var05D3AFE401306D7B03478EC9AD8483E3_655593036 = (workerCountOf(ctl.get()) > maximumPoolSize);
            interruptIdleWorkers();
        } 
        
        
            
        
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.212 -0400", hash_original_method = "4164BA9A7B4677354D8831E6C94ADF71", hash_generated_method = "9EF16CC41D35B41CEF9B22C5A4C44D54")
    public int getMaximumPoolSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1909639860 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1909639860;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.212 -0400", hash_original_method = "863FC09A28296060918F86FB184DF489", hash_generated_method = "21FF2F8954CA1C66BBCFE8D70804D1BA")
    public void setKeepAliveTime(long time, TimeUnit unit) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        {
            boolean varE36A88334ABAF702C248888F469CB1B5_1299594167 = (time == 0 && allowsCoreThreadTimeOut());
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Core threads must have nonzero keep alive times");
        } 
        long keepAliveTime = unit.toNanos(time);
        long delta = keepAliveTime - this.keepAliveTime;
        this.keepAliveTime = keepAliveTime;
        interruptIdleWorkers();
        addTaint(time);
        addTaint(unit.getTaint());
        
        
            
        
            
        
        
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.213 -0400", hash_original_method = "DF59E7D78F54A4D1FBC20C042F5F1838", hash_generated_method = "D7AA23731F429584BE7E73F0938F0664")
    public long getKeepAliveTime(TimeUnit unit) {
        long var21762EF164EDAA82F42EC374AF5B3AFC_1825410024 = (unit.convert(keepAliveTime, TimeUnit.NANOSECONDS));
        addTaint(unit.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1302517389 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1302517389;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.213 -0400", hash_original_method = "BD8FCC0E1F95E7B090761BC333422796", hash_generated_method = "86F65FDC726583CC2853A76C8A912CD6")
    public BlockingQueue<Runnable> getQueue() {
        BlockingQueue<Runnable> varB4EAC82CA7396A68D541C85D26508E83_1743938517 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1743938517 = workQueue;
        varB4EAC82CA7396A68D541C85D26508E83_1743938517.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1743938517;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.213 -0400", hash_original_method = "79BF7D79C72AB53C9D385B8F29AB696D", hash_generated_method = "6B1B302731BB3C367228C02B64452BB8")
    public boolean remove(Runnable task) {
        boolean removed = workQueue.remove(task);
        tryTerminate();
        addTaint(task.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_233521600 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_233521600;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.221 -0400", hash_original_method = "9B9E8DAAF98D7F6DDC91DC997B50219A", hash_generated_method = "8AC4C0F917969C1B2677DD100FB629D9")
    public void purge() {
        final BlockingQueue<Runnable> q = workQueue;
        try 
        {
            Iterator<Runnable> it = q.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_89282210 = (it.hasNext());
                {
                    Runnable r = it.next();
                    {
                        boolean var270276E750C193C865B578E1AE2E22C1_1523552807 = (r instanceof Future<?> && ((Future<?>)r).isCancelled());
                        it.remove();
                    } 
                } 
            } 
        } 
        catch (ConcurrentModificationException fallThrough)
        {
            {
                Object r = q.toArray()[0];
                {
                    boolean var4E8BBA7479E6059D39986F5769B4F8FA_1337632776 = (r instanceof Future<?> && ((Future<?>)r).isCancelled());
                    q.remove(r);
                } 
            } 
        } 
        tryTerminate();
        
        
        
            
            
                
                
                    
            
        
            
                
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.222 -0400", hash_original_method = "4852DC9A347396E4E4A26FF1AFDF98FD", hash_generated_method = "9130516003907D231D8C2B6879831DC8")
    public int getPoolSize() {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            {
                boolean varF68CB7F835009006B5FA4F669CE04294_1583569079 = (runStateAtLeast(ctl.get(), TIDYING));
                Object var741C3FF695A194FA69D4BFA4908B5EDF_1428622905 = (workers.size());
            } 
        } 
        finally 
        {
            mainLock.unlock();
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_798861381 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_798861381;
        
        
        
        
            
                
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.233 -0400", hash_original_method = "F897DAAB3F6E4FA542BB8276CD2A7AD3", hash_generated_method = "B9ABEA3868501FF913812C462EF1EC42")
    public int getActiveCount() {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            int n = 0;
            {
                Iterator<Worker> var6931C42F4C1AD656649FE9715A90096D_560784024 = (workers).iterator();
                var6931C42F4C1AD656649FE9715A90096D_560784024.hasNext();
                Worker w = var6931C42F4C1AD656649FE9715A90096D_560784024.next();
                {
                    boolean varBC60F1E56E351594899C6DC36F026C6D_547451880 = (w.isLocked());
                } 
            } 
        } 
        finally 
        {
            mainLock.unlock();
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1501404283 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1501404283;
        
        
        
        
            
            
                
                    
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.234 -0400", hash_original_method = "B4A579D5588949E5556CF38ABCB55065", hash_generated_method = "7F7C83EAD6691B841CEAE17D28E05800")
    public int getLargestPoolSize() {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1309830356 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1309830356;
        
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.240 -0400", hash_original_method = "145E6751E1E0E0F3E4FA35DB76B7EDE5", hash_generated_method = "C3554F5E4F345C82B0D0691858EE5B7B")
    public long getTaskCount() {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            long n = completedTaskCount;
            {
                Iterator<Worker> var6931C42F4C1AD656649FE9715A90096D_102300448 = (workers).iterator();
                var6931C42F4C1AD656649FE9715A90096D_102300448.hasNext();
                Worker w = var6931C42F4C1AD656649FE9715A90096D_102300448.next();
                {
                    n += w.completedTasks;
                    {
                        boolean var522A9CF7E3545C172CF36E5345BFAC72_1976327526 = (w.isLocked());
                    } 
                } 
            } 
            long varB956FA447F2D153BA84914B4AF4D6590_1581696450 = (n + workQueue.size());
        } 
        finally 
        {
            mainLock.unlock();
        } 
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1632342008 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1632342008;
        
        
        
        
            
            
                
                
                    
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.246 -0400", hash_original_method = "C21C1799DAC41B07982333C8F3E02012", hash_generated_method = "CE076E6965E4D57ECE5038D16AFB10EC")
    public long getCompletedTaskCount() {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try 
        {
            long n = completedTaskCount;
            {
                Iterator<Worker> var6931C42F4C1AD656649FE9715A90096D_474203727 = (workers).iterator();
                var6931C42F4C1AD656649FE9715A90096D_474203727.hasNext();
                Worker w = var6931C42F4C1AD656649FE9715A90096D_474203727.next();
                n += w.completedTasks;
            } 
        } 
        finally 
        {
            mainLock.unlock();
        } 
        long var0F5264038205EDFB1AC05FBB0E8C5E94_693918806 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_693918806;
        
        
        
        
            
            
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.265 -0400", hash_original_method = "AA5F5BF44F4DA05ED8C1D4957936AC31", hash_generated_method = "E32D7A10A628205AE3CAE94DD68C5063")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_493387981 = null; 
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
            {
                Iterator<Worker> var6931C42F4C1AD656649FE9715A90096D_89839473 = (workers).iterator();
                var6931C42F4C1AD656649FE9715A90096D_89839473.hasNext();
                Worker w = var6931C42F4C1AD656649FE9715A90096D_89839473.next();
                {
                    ncompleted += w.completedTasks;
                    {
                        boolean var522A9CF7E3545C172CF36E5345BFAC72_1363935640 = (w.isLocked());
                    } 
                } 
            } 
        } 
        finally 
        {
            mainLock.unlock();
        } 
        int c = ctl.get();
        String rs = (runStateLessThan(c, SHUTDOWN) ? "Running" :
                     (runStateAtLeast(c, TERMINATED) ? "Terminated" :
                      "Shutting down"));
        varB4EAC82CA7396A68D541C85D26508E83_493387981 = super.toString() +
            "[" + rs +
            ", pool size = " + nworkers +
            ", active threads = " + nactive +
            ", queued tasks = " + workQueue.size() +
            ", completed tasks = " + ncompleted +
            "]";
        varB4EAC82CA7396A68D541C85D26508E83_493387981.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_493387981;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.267 -0400", hash_original_method = "4C3878CDFFA0878930C89982189B5032", hash_generated_method = "695E162B3A9788D8D0A44B85DD6CC7FB")
    protected void beforeExecute(Thread t, Runnable r) {
        addTaint(t.getTaint());
        addTaint(r.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.271 -0400", hash_original_method = "1E835AC60F46FC4FB8E958FFB42880D4", hash_generated_method = "5571B558345407E7529C983C9B921829")
    protected void afterExecute(Runnable r, Throwable t) {
        addTaint(r.getTaint());
        addTaint(t.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.273 -0400", hash_original_method = "A29D7F7280B94AB8E3FBFAF6674D4BBC", hash_generated_method = "F157B5EF4A6890FC5741BB31F75810D9")
    protected void terminated() {
        
    }

    
    private final class Worker extends AbstractQueuedSynchronizer implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.273 -0400", hash_original_field = "DC127F5D2483352FD20EADDB38FEB6D2", hash_generated_field = "AB87C4F6E5547EBD7483F34732EA576D")

        Thread thread;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.273 -0400", hash_original_field = "AB088EE69C51E9415A270FBD75F5B952", hash_generated_field = "52D2DAE86CEE20DA5D093E6C8E8D890A")

        Runnable firstTask;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.273 -0400", hash_original_field = "3537605F39622BC6E15B1019401ED976", hash_generated_field = "A27B0F0FE609EB920C0300ECD3CAA2E3")

        volatile long completedTasks;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.276 -0400", hash_original_method = "8E628C9261C64BEE296D97D919DD4FB9", hash_generated_method = "4DEC29ECDD14EB9919329B70C54FB56D")
          Worker(Runnable firstTask) {
            this.firstTask = firstTask;
            this.thread = getThreadFactory().newThread(this);
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.279 -0400", hash_original_method = "776DC8B2F80D9EC817EF7446A13B40B9", hash_generated_method = "1D172B8AE706040037220A6FE99238AC")
        public void run() {
            runWorker(this);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.282 -0400", hash_original_method = "C9E6BAFAC050F423C4392C73A0972F98", hash_generated_method = "A6012F98D97F7D1F8FF9C3E5075CFE7F")
        protected boolean isHeldExclusively() {
            boolean var19B741D0D216C6237072ABA5B53D29C0_696392414 = (getState() == 1);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1775473470 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1775473470;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.283 -0400", hash_original_method = "48A928967742ABFEBADE0574311D01BE", hash_generated_method = "5642CA41979C14765C45394767A45945")
        protected boolean tryAcquire(int unused) {
            {
                boolean varF425053993EA879E03DA150C877D7F5C_332975912 = (compareAndSetState(0, 1));
                {
                    setExclusiveOwnerThread(Thread.currentThread());
                } 
            } 
            addTaint(unused);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1649620143 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1649620143;
            
            
                
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.284 -0400", hash_original_method = "CF73EFA48EB2690CB7BA351224285F0C", hash_generated_method = "FF09E9908851BFCC5153AF78DFF466EE")
        protected boolean tryRelease(int unused) {
            setExclusiveOwnerThread(null);
            setState(0);
            addTaint(unused);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1228988503 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1228988503;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.285 -0400", hash_original_method = "E6AC2D5893CA21F5681F81CF00C94AEB", hash_generated_method = "E250ED120425ABD3596F0FB44742AE76")
        public void lock() {
            acquire(1);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.286 -0400", hash_original_method = "0FBAB3A752D629DDEE7FCF88CA811E1B", hash_generated_method = "4D3A60225370AB51A8A6CA15C9BEC36E")
        public boolean tryLock() {
            boolean var983EB53456294FEAD564C34A6EB40052_737293217 = (tryAcquire(1));
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_908669594 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_908669594;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.286 -0400", hash_original_method = "375F138297D7668DFC40E00540A7DE61", hash_generated_method = "9980155D40CCECC3DD5DA1A3CA7D2CB7")
        public void unlock() {
            release(1);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.287 -0400", hash_original_method = "0FBE2B31D6107275F6E2B1C06D400675", hash_generated_method = "BE654CC63238406564E6CE46F5F69233")
        public boolean isLocked() {
            boolean var7307B0E63112DD101487F0593BCA6CC3_725428659 = (isHeldExclusively());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1356190748 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1356190748;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.287 -0400", hash_original_field = "CD164B34526C2858AEAF8B60C2D2C494", hash_generated_field = "F8F6CAECCAD1418C4C9E71235F2C474E")

        private static final long serialVersionUID = 6138294804551838833L;
    }


    
    public static class CallerRunsPolicy implements RejectedExecutionHandler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.289 -0400", hash_original_method = "0024AA22CD353D26AF52EE7A7BFF5B6A", hash_generated_method = "EE6F5E0062E38533EDD0CC7DB47C5E41")
        public  CallerRunsPolicy() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.290 -0400", hash_original_method = "1E8BCB605E875657A6EC0245732A9544", hash_generated_method = "FCDF5FB5CD8C8149A38211EC494FC292")
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            {
                boolean var25A2508FD0F77674F14744C27A3265D3_405780564 = (!e.isShutdown());
                {
                    r.run();
                } 
            } 
            addTaint(r.getTaint());
            addTaint(e.getTaint());
            
            
                
            
        }

        
    }


    
    public static class AbortPolicy implements RejectedExecutionHandler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.291 -0400", hash_original_method = "0E304EA6C47EF7342B79AE7423647CD0", hash_generated_method = "179F0278660B104E944DF3C713C65A75")
        public  AbortPolicy() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.291 -0400", hash_original_method = "499AAA3E1602997D93E7C4E818F2EBAC", hash_generated_method = "EFE6E1EE41233AD052BA4B7817BED0D7")
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            if (DroidSafeAndroidRuntime.control) throw new RejectedExecutionException("Task " + r.toString() +
                                                 " rejected from " +
                                                 e.toString());
            addTaint(r.getTaint());
            addTaint(e.getTaint());
            
            
                                                 
                                                 
        }

        
    }


    
    public static class DiscardPolicy implements RejectedExecutionHandler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.292 -0400", hash_original_method = "F09B76305D692D1CB8CB62E17F499CB5", hash_generated_method = "C4B475A3525556F9D1B8C945DF152CD4")
        public  DiscardPolicy() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.292 -0400", hash_original_method = "81B7AD8C9B3A9908C7C41F3CCCB6E30B", hash_generated_method = "3F6D29A84EB37505757D74358D3B6FBC")
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            addTaint(r.getTaint());
            addTaint(e.getTaint());
            
        }

        
    }


    
    public static class DiscardOldestPolicy implements RejectedExecutionHandler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.292 -0400", hash_original_method = "7D42DC0AF0C4E1A1DAE9147B8685950D", hash_generated_method = "887F469A96FA729D52338C565521C0C6")
        public  DiscardOldestPolicy() {
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.293 -0400", hash_original_method = "BC4245492A96EB743D1DE4975B9A07C3", hash_generated_method = "CFD7F264E3871F72EC123AC9317506DB")
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            {
                boolean var25A2508FD0F77674F14744C27A3265D3_1358199046 = (!e.isShutdown());
                {
                    e.getQueue().poll();
                    e.execute(r);
                } 
            } 
            addTaint(r.getTaint());
            addTaint(e.getTaint());
            
            
                
                
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.293 -0400", hash_original_field = "2AD2E6A7A23B57F7662422A52B95CC09", hash_generated_field = "C674AAE591A4C2A6EB2F67EA80F2DE13")

    private static final int COUNT_BITS = Integer.SIZE - 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.293 -0400", hash_original_field = "6F4706F438E735959AC77A0E013826F9", hash_generated_field = "CF878CE62C328436BA99760DFF82027D")

    private static final int CAPACITY = (1 << COUNT_BITS) - 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.293 -0400", hash_original_field = "7E2DC2CDAE866B990CCFB9F99485888D", hash_generated_field = "CAC5C6E1B12A6971FDAEB64BF4F42B8A")

    private static final int RUNNING = -1 << COUNT_BITS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.293 -0400", hash_original_field = "F45465E1DCD849E3752A2369BF892D71", hash_generated_field = "88B12340C5E9ABC6D057CFECE99CB6E3")

    private static final int SHUTDOWN = 0 << COUNT_BITS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.293 -0400", hash_original_field = "04AE349763D898E1D79F4CA49A2289E1", hash_generated_field = "6E7F0CA66443C48AA2015EE41BE176B0")

    private static final int STOP = 1 << COUNT_BITS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.293 -0400", hash_original_field = "90217937E23D86674136EE5F6F9762F5", hash_generated_field = "8F8DF3A5844AACE6D200E7F78FE2ADD1")

    private static final int TIDYING = 2 << COUNT_BITS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.293 -0400", hash_original_field = "A23623286A319227DF0EDB01163E3BBD", hash_generated_field = "0385C889A493B24F4B17131E67614BDD")

    private static final int TERMINATED = 3 << COUNT_BITS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.293 -0400", hash_original_field = "5AA44F02EBBBA45DF7D7B7C9828E325E", hash_generated_field = "D9AB1E8CC26AED3D197149D01E447734")

    private static final RejectedExecutionHandler defaultHandler = new AbortPolicy();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.293 -0400", hash_original_field = "C6A5F234FA8B366F73521414CAEB2E7B", hash_generated_field = "EE8D52406DBEBB0DDE00DE5ED1AF90DE")

    private static final RuntimePermission shutdownPerm = new RuntimePermission("modifyThread");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.293 -0400", hash_original_field = "DCF5310FAB389A27E2F24E12DE639C90", hash_generated_field = "5E955A6108BE148E09061102B5987F21")

    private static final boolean ONLY_ONE = true;
}

