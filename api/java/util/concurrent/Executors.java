package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedExceptionAction;
import java.security.PrivilegedActionException;
import java.security.AccessControlException;

public class Executors {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.426 -0400", hash_original_method = "F4CB3C27487DF72857FE3507DC40AD75", hash_generated_method = "27F2BAE4FD286E326334A8739E3D4262")
    private  Executors() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>());
    }

    
    @DSModeled(DSC.SAFE)
    public static ExecutorService newFixedThreadPool(int nThreads, ThreadFactory threadFactory) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>(),
                                      threadFactory);
    }

    
    @DSModeled(DSC.SAFE)
    public static ExecutorService newSingleThreadExecutor() {
        return new FinalizableDelegatedExecutorService
            (new ThreadPoolExecutor(1, 1,
                                    0L, TimeUnit.MILLISECONDS,
                                    new LinkedBlockingQueue<Runnable>()));
    }

    
    @DSModeled(DSC.SAFE)
    public static ExecutorService newSingleThreadExecutor(ThreadFactory threadFactory) {
        return new FinalizableDelegatedExecutorService
            (new ThreadPoolExecutor(1, 1,
                                    0L, TimeUnit.MILLISECONDS,
                                    new LinkedBlockingQueue<Runnable>(),
                                    threadFactory));
    }

    
    @DSModeled(DSC.SAFE)
    public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                      60L, TimeUnit.SECONDS,
                                      new SynchronousQueue<Runnable>());
    }

    
    @DSModeled(DSC.SAFE)
    public static ExecutorService newCachedThreadPool(ThreadFactory threadFactory) {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                      60L, TimeUnit.SECONDS,
                                      new SynchronousQueue<Runnable>(),
                                      threadFactory);
    }

    
    @DSModeled(DSC.SAFE)
    public static ScheduledExecutorService newSingleThreadScheduledExecutor() {
        return new DelegatedScheduledExecutorService
            (new ScheduledThreadPoolExecutor(1));
    }

    
    @DSModeled(DSC.SAFE)
    public static ScheduledExecutorService newSingleThreadScheduledExecutor(ThreadFactory threadFactory) {
        return new DelegatedScheduledExecutorService
            (new ScheduledThreadPoolExecutor(1, threadFactory));
    }

    
    @DSModeled(DSC.SAFE)
    public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize) {
        return new ScheduledThreadPoolExecutor(corePoolSize);
    }

    
    @DSModeled(DSC.SAFE)
    public static ScheduledExecutorService newScheduledThreadPool(
            int corePoolSize, ThreadFactory threadFactory) {
        return new ScheduledThreadPoolExecutor(corePoolSize, threadFactory);
    }

    
    @DSModeled(DSC.SAFE)
    public static ExecutorService unconfigurableExecutorService(ExecutorService executor) {
        if (executor == null)
            throw new NullPointerException();
        return new DelegatedExecutorService(executor);
    }

    
    @DSModeled(DSC.SAFE)
    public static ScheduledExecutorService unconfigurableScheduledExecutorService(ScheduledExecutorService executor) {
        if (executor == null)
            throw new NullPointerException();
        return new DelegatedScheduledExecutorService(executor);
    }

    
    @DSModeled(DSC.SAFE)
    public static ThreadFactory defaultThreadFactory() {
        return new DefaultThreadFactory();
    }

    
    @DSModeled(DSC.SAFE)
    public static ThreadFactory privilegedThreadFactory() {
        return new PrivilegedThreadFactory();
    }

    
    public static <T> Callable<T> callable(Runnable task, T result) {
        if (task == null)
            throw new NullPointerException();
        return new RunnableAdapter<T>(task, result);
    }

    
    @DSModeled(DSC.SAFE)
    public static Callable<Object> callable(Runnable task) {
        if (task == null)
            throw new NullPointerException();
        return new RunnableAdapter<Object>(task, null);
    }

    
    public static Callable<Object> callable(final PrivilegedAction<?> action) {
        if (action == null)
            throw new NullPointerException();
        return new Callable<Object>() {
            public Object call() { return action.run(); }};
    }

    
    public static Callable<Object> callable(final PrivilegedExceptionAction<?> action) {
        if (action == null)
            throw new NullPointerException();
        return new Callable<Object>() {
            public Object call() throws Exception { return action.run(); }};
    }

    
    @DSModeled(DSC.SAFE)
    public static <T> Callable<T> privilegedCallable(Callable<T> callable) {
        if (callable == null)
            throw new NullPointerException();
        return new PrivilegedCallable<T>(callable);
    }

    
    @DSModeled(DSC.SAFE)
    public static <T> Callable<T> privilegedCallableUsingCurrentClassLoader(Callable<T> callable) {
        if (callable == null)
            throw new NullPointerException();
        return new PrivilegedCallableUsingCurrentClassLoader<T>(callable);
    }

    
    static final class RunnableAdapter<T> implements Callable<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.430 -0400", hash_original_field = "478F3A4C51824AD23CB50C1C60670C0F", hash_generated_field = "3B9DB014EA5583311EF52FFA01325C0E")

        Runnable task;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.430 -0400", hash_original_field = "B4A88417B3D0170D754C647C30B7216A", hash_generated_field = "8B901F4123EF91F350535EEC5A55F787")

        T result;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.430 -0400", hash_original_method = "39BEB710EA675D51CD733BCB993FC74E", hash_generated_method = "B66D71CB0E2F61493FC0C79EA7F2EE40")
          RunnableAdapter(Runnable task, T result) {
            this.task = task;
            this.result = result;
            // ---------- Original Method ----------
            //this.task = task;
            //this.result = result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.430 -0400", hash_original_method = "0255C7C18478A7E06F3D7DE61652A41C", hash_generated_method = "6F253A85148304728DB61338FAA62866")
        public T call() {
            task.run();
T varDC838461EE2FA0CA4C9BBB70A15456B0_1786702208 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1786702208.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1786702208;
            // ---------- Original Method ----------
            //task.run();
            //return result;
        }

        
    }


    
    static final class PrivilegedCallable<T> implements Callable<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.430 -0400", hash_original_field = "478F3A4C51824AD23CB50C1C60670C0F", hash_generated_field = "CFBF2BD2CA84F7FFF876D42173005A51")

        private Callable<T> task;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.431 -0400", hash_original_field = "1673448EE7064C989D02579C534F6B66", hash_generated_field = "5E0BB9B3EC8D99479706D49A606F3BE8")

        private AccessControlContext acc;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.431 -0400", hash_original_method = "12C65A09BA65E906C8B3945E2B4DB442", hash_generated_method = "407881EAC3D9A4573DC5616AB923DB76")
          PrivilegedCallable(Callable<T> task) {
            this.task = task;
            this.acc = AccessController.getContext();
            // ---------- Original Method ----------
            //this.task = task;
            //this.acc = AccessController.getContext();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.949 -0400", hash_original_method = "9B84B0D9F1F9FF2095D253EA33535221", hash_generated_method = "E14DBC5527319FD92CE738D97A5FE7C1")
        public T call() throws Exception {
            try 
            {
T var8C0E7955A367AA4C5A2C7492B4312867_977516067 =                 AccessController.doPrivileged(
                    new PrivilegedExceptionAction<T>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.948 -0400", hash_original_method = "2C30E1492126DFE1004B0460419644DD", hash_generated_method = "FAB0BD0888C539370D5ACFEDD4A9B839")
            public T run() throws Exception {
T var1E6FFBD2B2AE8130DD2A092BC0BC400B_1871312491 =                 task.call();
                var1E6FFBD2B2AE8130DD2A092BC0BC400B_1871312491.addTaint(taint);
                return var1E6FFBD2B2AE8130DD2A092BC0BC400B_1871312491;
                // ---------- Original Method ----------
                //return task.call();
            }
}, acc);
                var8C0E7955A367AA4C5A2C7492B4312867_977516067.addTaint(taint);
                return var8C0E7955A367AA4C5A2C7492B4312867_977516067;
            } //End block
            catch (PrivilegedActionException e)
            {
                Exception varB727EB75A5923A25079A15DB07B65969_1926769963 = e.getException();
                varB727EB75A5923A25079A15DB07B65969_1926769963.addTaint(taint);
                throw varB727EB75A5923A25079A15DB07B65969_1926769963;
            } //End block
            // ---------- Original Method ----------
            //try {
                //return AccessController.doPrivileged(
                    //new PrivilegedExceptionAction<T>() {
                        //public T run() throws Exception {
                            //return task.call();
                        //}
                    //}, acc);
            //} catch (PrivilegedActionException e) {
                //throw e.getException();
            //}
        }

        
        // orphaned legacy method
        public T run() throws Exception {
                            return task.call();
                        }
        
    }


    
    static final class PrivilegedCallableUsingCurrentClassLoader<T> implements Callable<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.432 -0400", hash_original_field = "478F3A4C51824AD23CB50C1C60670C0F", hash_generated_field = "CFBF2BD2CA84F7FFF876D42173005A51")

        private Callable<T> task;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.432 -0400", hash_original_field = "1673448EE7064C989D02579C534F6B66", hash_generated_field = "5E0BB9B3EC8D99479706D49A606F3BE8")

        private AccessControlContext acc;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.432 -0400", hash_original_field = "95BBC40CB7BBF40EBF7B825922894718", hash_generated_field = "F0BF273B591E278A790B33F9A1F9CEDB")

        private ClassLoader ccl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.433 -0400", hash_original_method = "A45AF0A17387712B1B0259CF7D85D2E1", hash_generated_method = "5E92716C021B3E4BA5538C1BD0AE719E")
          PrivilegedCallableUsingCurrentClassLoader(Callable<T> task) {
            SecurityManager sm = System.getSecurityManager();
            if(sm != null)            
            {
                sm.checkPermission(new RuntimePermission("getContextClassLoader"));
                sm.checkPermission(new RuntimePermission("setContextClassLoader"));
            } //End block
            this.task = task;
            this.acc = AccessController.getContext();
            this.ccl = Thread.currentThread().getContextClassLoader();
            // ---------- Original Method ----------
            //SecurityManager sm = System.getSecurityManager();
            //if (sm != null) {
                //sm.checkPermission(new RuntimePermission("getContextClassLoader")); 
                //sm.checkPermission(new RuntimePermission("setContextClassLoader"));
            //}
            //this.task = task;
            //this.acc = AccessController.getContext();
            //this.ccl = Thread.currentThread().getContextClassLoader();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.953 -0400", hash_original_method = "083E1FD40613168D34C9FEEE9DFC0EBD", hash_generated_method = "A36CDEF7A248443757048A585C2D137C")
        public T call() throws Exception {
            try 
            {
T varBCBFD1547E568D77EC8B60D97435E881_964807118 =                 AccessController.doPrivileged(
                    new PrivilegedExceptionAction<T>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.951 -0400", hash_original_method = "EAF5A8360517EEB3FD91B09A069198A5", hash_generated_method = "2D3353BB6FE023B0BE3D25B9E05D356B")
            public T run() throws Exception {
                ClassLoader savedcl = null;
                Thread t = Thread.currentThread();
                try 
                {
                    ClassLoader cl = t.getContextClassLoader();
    if(ccl != cl)                    
                    {
                        t.setContextClassLoader(ccl);
                        savedcl = cl;
                    } //End block
T var1E6FFBD2B2AE8130DD2A092BC0BC400B_480532354 =                     task.call();
                    var1E6FFBD2B2AE8130DD2A092BC0BC400B_480532354.addTaint(taint);
                    return var1E6FFBD2B2AE8130DD2A092BC0BC400B_480532354;
                } //End block
                finally 
                {
    if(savedcl != null)                    
                    t.setContextClassLoader(savedcl);
                } //End block
                // ---------- Original Method ----------
                //ClassLoader savedcl = null;
                //Thread t = Thread.currentThread();
                //try {
                                //ClassLoader cl = t.getContextClassLoader();
                                //if (ccl != cl) {
                                    //t.setContextClassLoader(ccl);
                                    //savedcl = cl;
                                //}
                                //return task.call();
                            //} finally {
                                //if (savedcl != null)
                                    //t.setContextClassLoader(savedcl);
                            //}
            }
}, acc);
                varBCBFD1547E568D77EC8B60D97435E881_964807118.addTaint(taint);
                return varBCBFD1547E568D77EC8B60D97435E881_964807118;
            } //End block
            catch (PrivilegedActionException e)
            {
                Exception varB727EB75A5923A25079A15DB07B65969_1592493440 = e.getException();
                varB727EB75A5923A25079A15DB07B65969_1592493440.addTaint(taint);
                throw varB727EB75A5923A25079A15DB07B65969_1592493440;
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        // orphaned legacy method
        public T run() throws Exception {
                            ClassLoader savedcl = null;
                            Thread t = Thread.currentThread();
                            try {
                                ClassLoader cl = t.getContextClassLoader();
                                if (ccl != cl) {
                                    t.setContextClassLoader(ccl);
                                    savedcl = cl;
                                }
                                return task.call();
                            } finally {
                                if (savedcl != null)
                                    t.setContextClassLoader(savedcl);
                            }
                        }
        
    }


    
    static class DefaultThreadFactory implements ThreadFactory {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.434 -0400", hash_original_field = "DB0F6F37EBEB6EA09489124345AF2A45", hash_generated_field = "6F10AD05CE1F57FC2F4A5DF43A505F99")

        private ThreadGroup group;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.434 -0400", hash_original_field = "29DCC4905D6FB1DA2B7219093C787E49", hash_generated_field = "1DD6DDF0F67F2F10AA2E1938FCC29304")

        private final AtomicInteger threadNumber = new AtomicInteger(1);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.434 -0400", hash_original_field = "4110ADAB8C8C67636BBEC549E9B73281", hash_generated_field = "2F76B01D831BB088ADF19AC1319DB54D")

        private String namePrefix;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.435 -0400", hash_original_method = "6C4DB34AB218BB8D6524A59E94717A2E", hash_generated_method = "8BE04B7CF7D9B446A09A2C26EE6BA63C")
          DefaultThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                                  Thread.currentThread().getThreadGroup();
            namePrefix = "pool-" +
                          poolNumber.getAndIncrement() +
                         "-thread-";
            // ---------- Original Method ----------
            //SecurityManager s = System.getSecurityManager();
            //group = (s != null) ? s.getThreadGroup() :
                                  //Thread.currentThread().getThreadGroup();
            //namePrefix = "pool-" +
                          //poolNumber.getAndIncrement() +
                         //"-thread-";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.435 -0400", hash_original_method = "FA504429181C673B0F1001408D56C877", hash_generated_method = "2E04FE3CC591FD0FFFDE5E99E7C62483")
        public Thread newThread(Runnable r) {
            addTaint(r.getTaint());
            Thread t = new Thread(group, r,
                                  namePrefix + threadNumber.getAndIncrement(),
                                  0);
            if(t.isDaemon())            
            t.setDaemon(false);
            if(t.getPriority() != Thread.NORM_PRIORITY)            
            t.setPriority(Thread.NORM_PRIORITY);
Thread varE0D714D758F1540A8DF364A965AF9150_1865533905 =             t;
            varE0D714D758F1540A8DF364A965AF9150_1865533905.addTaint(taint);
            return varE0D714D758F1540A8DF364A965AF9150_1865533905;
            // ---------- Original Method ----------
            //Thread t = new Thread(group, r,
                                  //namePrefix + threadNumber.getAndIncrement(),
                                  //0);
            //if (t.isDaemon())
                //t.setDaemon(false);
            //if (t.getPriority() != Thread.NORM_PRIORITY)
                //t.setPriority(Thread.NORM_PRIORITY);
            //return t;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.435 -0400", hash_original_field = "8173E1475D6022921D6CE09AFFF974B7", hash_generated_field = "4D1AD706E0B207CD49EDE0FDF77D35E3")

        private static final AtomicInteger poolNumber = new AtomicInteger(1);
    }


    
    static class PrivilegedThreadFactory extends DefaultThreadFactory {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.435 -0400", hash_original_field = "1673448EE7064C989D02579C534F6B66", hash_generated_field = "5E0BB9B3EC8D99479706D49A606F3BE8")

        private AccessControlContext acc;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.435 -0400", hash_original_field = "95BBC40CB7BBF40EBF7B825922894718", hash_generated_field = "F0BF273B591E278A790B33F9A1F9CEDB")

        private ClassLoader ccl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.435 -0400", hash_original_method = "1637F6F8B2206F80B43C5E6A7CCBC9A4", hash_generated_method = "F91B3DAB0C57DC65E77479441B3B8393")
          PrivilegedThreadFactory() {
            super();
            SecurityManager sm = System.getSecurityManager();
            if(sm != null)            
            {
                sm.checkPermission(new RuntimePermission("getContextClassLoader"));
                sm.checkPermission(new RuntimePermission("setContextClassLoader"));
            } //End block
            this.acc = AccessController.getContext();
            this.ccl = Thread.currentThread().getContextClassLoader();
            // ---------- Original Method ----------
            //SecurityManager sm = System.getSecurityManager();
            //if (sm != null) {
                //sm.checkPermission(new RuntimePermission("getContextClassLoader")); 
                //sm.checkPermission(new RuntimePermission("setContextClassLoader"));
            //}
            //this.acc = AccessController.getContext();
            //this.ccl = Thread.currentThread().getContextClassLoader();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.436 -0400", hash_original_method = "0BB5C6FA3ECC4446695A9AB19E82A9A9", hash_generated_method = "61D578F034A061841ED18D157F62D535")
        public Thread newThread(final Runnable r) {
            addTaint(r.getTaint());
Thread var801BC3E623C83925F37035F64FDA758D_46944935 =             super.newThread(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.435 -0400", hash_original_method = "3766F05AB50EC7E8431DCAB08B326340", hash_generated_method = "059A4FD028D84A43BB9ED932DC1A53D9")
            public void run() {
                AccessController.doPrivileged(new PrivilegedAction<Void>() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.435 -0400", hash_original_method = "99386286B0FCA4E3E184AF51137A113C", hash_generated_method = "D7F0E00D488ABC9624F3DD75A60D3B27")
                public Void run() {
                    Thread.currentThread().setContextClassLoader(ccl);
                    r.run();
Void var540C13E9E156B687226421B24F2DF178_1354572354 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1354572354.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1354572354;
                    // ---------- Original Method ----------
                    //Thread.currentThread().setContextClassLoader(ccl);
                    //r.run();
                    //return null;
                }
}, acc);
                // ---------- Original Method ----------
                //AccessController.doPrivileged(new PrivilegedAction<Void>() {
                        //public Void run() {
                            //Thread.currentThread().setContextClassLoader(ccl);
                            //r.run();
                            //return null;
                        //}
                    //}, acc);
            }
});
            var801BC3E623C83925F37035F64FDA758D_46944935.addTaint(taint);
            return var801BC3E623C83925F37035F64FDA758D_46944935;
            // ---------- Original Method ----------
            //return super.newThread(new Runnable() {
                //public void run() {
                    //AccessController.doPrivileged(new PrivilegedAction<Void>() {
                        //public Void run() {
                            //Thread.currentThread().setContextClassLoader(ccl);
                            //r.run();
                            //return null;
                        //}
                    //}, acc);
                //}
            //});
        }

        
    }


    
    static class DelegatedExecutorService extends AbstractExecutorService {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.436 -0400", hash_original_field = "E1671797C52E15F763380B45E841EC32", hash_generated_field = "11B8F83ADD158AE4ADD1E7AA1252842D")

        private ExecutorService e;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.436 -0400", hash_original_method = "69B8656E71D4B49ACEB9CE44B20A63F5", hash_generated_method = "FF9F28349FB8E5F20D2028CD89D51AA0")
          DelegatedExecutorService(ExecutorService executor) {
            e = executor;
            // ---------- Original Method ----------
            //e = executor;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.436 -0400", hash_original_method = "680CD1247FE9848C91F828B8B2655AA2", hash_generated_method = "DFB7C3A39554EE1AD7A22617C0DA9F83")
        public void execute(Runnable command) {
            addTaint(command.getTaint());
            e.execute(command);
            // ---------- Original Method ----------
            //e.execute(command);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.436 -0400", hash_original_method = "AC5ABD61901BFC6045B0080105C55DDA", hash_generated_method = "870B34DC67E6CAF4D4CA22846B67BE5A")
        public void shutdown() {
            e.shutdown();
            // ---------- Original Method ----------
            //e.shutdown();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.436 -0400", hash_original_method = "96CCD300667A8693DD62C1833316B3E7", hash_generated_method = "C89216CF547C5189EE2A2B0ADB429289")
        public List<Runnable> shutdownNow() {
List<Runnable> varE7D27192245C2FE3CA0A1CDFDB021EEB_952287628 =             e.shutdownNow();
            varE7D27192245C2FE3CA0A1CDFDB021EEB_952287628.addTaint(taint);
            return varE7D27192245C2FE3CA0A1CDFDB021EEB_952287628;
            // ---------- Original Method ----------
            //return e.shutdownNow();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.436 -0400", hash_original_method = "6953493B1D30A903FCCDB4081BC753C6", hash_generated_method = "90EB68F341C33D6FBE9C33AAAF45698F")
        public boolean isShutdown() {
            boolean varC6BFDE34389895E5EC4C039BD088BBC2_32415577 = (e.isShutdown());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1542383937 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1542383937;
            // ---------- Original Method ----------
            //return e.isShutdown();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.436 -0400", hash_original_method = "BA72422211BC216152EB93C851C6051E", hash_generated_method = "8DACF0D4E51128270E49EF6F8D1E9D4F")
        public boolean isTerminated() {
            boolean var9CE7EBB7372D816EEE62EC46692AA90B_240768458 = (e.isTerminated());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_565674509 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_565674509;
            // ---------- Original Method ----------
            //return e.isTerminated();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.436 -0400", hash_original_method = "7B27D3C16A1D302AD16E181EBB018DAC", hash_generated_method = "A2FAF0B6E306E88BF86C154237733DC2")
        public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
            addTaint(unit.getTaint());
            addTaint(timeout);
            boolean varF366CFDDB9AAE5CFAA90DAA671DBA4AC_2109988839 = (e.awaitTermination(timeout, unit));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1194473400 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1194473400;
            // ---------- Original Method ----------
            //return e.awaitTermination(timeout, unit);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.437 -0400", hash_original_method = "70A4BA700942918290F358C98B70C3C4", hash_generated_method = "EB011DAE7C18DACDCFEFD5F8739889FF")
        public Future<?> submit(Runnable task) {
            addTaint(task.getTaint());
Future<?> var3A821B5C48F3C73F2F85580271A54221_1530461288 =             e.submit(task);
            var3A821B5C48F3C73F2F85580271A54221_1530461288.addTaint(taint);
            return var3A821B5C48F3C73F2F85580271A54221_1530461288;
            // ---------- Original Method ----------
            //return e.submit(task);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.437 -0400", hash_original_method = "83E0E20FEE789D6C0B6E1A8BE258D9AC", hash_generated_method = "AA01AE8CA15C63BFFFD6A901646BAC26")
        public <T> Future<T> submit(Callable<T> task) {
            addTaint(task.getTaint());
Future<T> var3A821B5C48F3C73F2F85580271A54221_1800187115 =             e.submit(task);
            var3A821B5C48F3C73F2F85580271A54221_1800187115.addTaint(taint);
            return var3A821B5C48F3C73F2F85580271A54221_1800187115;
            // ---------- Original Method ----------
            //return e.submit(task);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.437 -0400", hash_original_method = "7C597CCD4131D2329D010B8EED3AD866", hash_generated_method = "0AA752005320E5BA2422D1327FD79FC5")
        public <T> Future<T> submit(Runnable task, T result) {
            addTaint(result.getTaint());
            addTaint(task.getTaint());
Future<T> varEAF64FBE2776E66AA7D7A86DC0368144_678840174 =             e.submit(task, result);
            varEAF64FBE2776E66AA7D7A86DC0368144_678840174.addTaint(taint);
            return varEAF64FBE2776E66AA7D7A86DC0368144_678840174;
            // ---------- Original Method ----------
            //return e.submit(task, result);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.437 -0400", hash_original_method = "F48A0D0A4C3710017B7673C8DB7925EC", hash_generated_method = "763A8BDAED7E7F87F7780CC06FF23828")
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
            addTaint(tasks.getTaint());
List<Future<T>> var501DF73082C68D7843A2F94A5A9D39DE_125190879 =             e.invokeAll(tasks);
            var501DF73082C68D7843A2F94A5A9D39DE_125190879.addTaint(taint);
            return var501DF73082C68D7843A2F94A5A9D39DE_125190879;
            // ---------- Original Method ----------
            //return e.invokeAll(tasks);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.437 -0400", hash_original_method = "5F911CE685489301A15E24D766797016", hash_generated_method = "F4AC9DAD7CAA5186CA2E4402CBC77145")
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks,
                                             long timeout, TimeUnit unit) throws InterruptedException {
            addTaint(unit.getTaint());
            addTaint(timeout);
            addTaint(tasks.getTaint());
List<Future<T>> var87E281F68E17B3CFFAEC895C8A8BFC68_708146293 =             e.invokeAll(tasks, timeout, unit);
            var87E281F68E17B3CFFAEC895C8A8BFC68_708146293.addTaint(taint);
            return var87E281F68E17B3CFFAEC895C8A8BFC68_708146293;
            // ---------- Original Method ----------
            //return e.invokeAll(tasks, timeout, unit);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.437 -0400", hash_original_method = "4C0A5FF3374B9876DAD3CF3A7DB4F9BC", hash_generated_method = "8B5EE102BC34D4E24BA7EFBB0665BD75")
        public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
            addTaint(tasks.getTaint());
T var7ECF5F9BD3788A61679614FEA5EAB1C2_271945437 =             e.invokeAny(tasks);
            var7ECF5F9BD3788A61679614FEA5EAB1C2_271945437.addTaint(taint);
            return var7ECF5F9BD3788A61679614FEA5EAB1C2_271945437;
            // ---------- Original Method ----------
            //return e.invokeAny(tasks);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.437 -0400", hash_original_method = "D15E2648AE9554DE3EDB2502DC3264EF", hash_generated_method = "C9B006B0B01AB1143ACEE71469CEF48F")
        public <T> T invokeAny(Collection<? extends Callable<T>> tasks,
                               long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            addTaint(unit.getTaint());
            addTaint(timeout);
            addTaint(tasks.getTaint());
T varE9E99FB5B2AB72C024FC741DCEE9DEC0_196926114 =             e.invokeAny(tasks, timeout, unit);
            varE9E99FB5B2AB72C024FC741DCEE9DEC0_196926114.addTaint(taint);
            return varE9E99FB5B2AB72C024FC741DCEE9DEC0_196926114;
            // ---------- Original Method ----------
            //return e.invokeAny(tasks, timeout, unit);
        }

        
    }


    
    static class FinalizableDelegatedExecutorService extends DelegatedExecutorService {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.437 -0400", hash_original_method = "0BC6912A00A2948375A36BA345B953A1", hash_generated_method = "0427AB51E917327C91B17605314F9B9B")
          FinalizableDelegatedExecutorService(ExecutorService executor) {
            super(executor);
            addTaint(executor.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.437 -0400", hash_original_method = "EFBA277C67FEFB15F281D1F7A5118361", hash_generated_method = "75FB1DC5FB180CA67655AFF259FD4832")
        protected void finalize() {
            super.shutdown();
            // ---------- Original Method ----------
            //super.shutdown();
        }

        
    }


    
    static class DelegatedScheduledExecutorService extends DelegatedExecutorService implements ScheduledExecutorService {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.437 -0400", hash_original_field = "E1671797C52E15F763380B45E841EC32", hash_generated_field = "3D78CFB93E5EA21FD7B6DC753DB36818")

        private ScheduledExecutorService e;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.438 -0400", hash_original_method = "B9414E1A08721941535D3112D446A4F5", hash_generated_method = "88B596860003D7EDE125C8F0F2905303")
          DelegatedScheduledExecutorService(ScheduledExecutorService executor) {
            super(executor);
            e = executor;
            // ---------- Original Method ----------
            //e = executor;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.438 -0400", hash_original_method = "D790041C21C164D4B5FF50718A4BC1E6", hash_generated_method = "CC2A44F65D99B80994B94F2F81F0B0F2")
        public ScheduledFuture<?> schedule(Runnable command, long delay,  TimeUnit unit) {
            addTaint(unit.getTaint());
            addTaint(delay);
            addTaint(command.getTaint());
ScheduledFuture<?> var892BAF045ECBDE9C241F5DCF1E691A8C_921751076 =             e.schedule(command, delay, unit);
            var892BAF045ECBDE9C241F5DCF1E691A8C_921751076.addTaint(taint);
            return var892BAF045ECBDE9C241F5DCF1E691A8C_921751076;
            // ---------- Original Method ----------
            //return e.schedule(command, delay, unit);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.438 -0400", hash_original_method = "21B2A7EFB4EC4FCA85726955706F3411", hash_generated_method = "10925EFC86BE3C187277C3C9203C26A9")
        public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
            addTaint(unit.getTaint());
            addTaint(delay);
            addTaint(callable.getTaint());
ScheduledFuture<V> var25477A3DA2D98386CF98CD42AD75D94E_288143507 =             e.schedule(callable, delay, unit);
            var25477A3DA2D98386CF98CD42AD75D94E_288143507.addTaint(taint);
            return var25477A3DA2D98386CF98CD42AD75D94E_288143507;
            // ---------- Original Method ----------
            //return e.schedule(callable, delay, unit);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.438 -0400", hash_original_method = "913AC360688F049D7C1CA1D721236AC7", hash_generated_method = "3A70982516235D3D7B142027509D9924")
        public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay,  long period, TimeUnit unit) {
            addTaint(unit.getTaint());
            addTaint(period);
            addTaint(initialDelay);
            addTaint(command.getTaint());
ScheduledFuture<?> var620733992FDA5475960C5660CA3DFFF4_735047314 =             e.scheduleAtFixedRate(command, initialDelay, period, unit);
            var620733992FDA5475960C5660CA3DFFF4_735047314.addTaint(taint);
            return var620733992FDA5475960C5660CA3DFFF4_735047314;
            // ---------- Original Method ----------
            //return e.scheduleAtFixedRate(command, initialDelay, period, unit);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:14.438 -0400", hash_original_method = "6DC4F7F046861AD80936134D3479B23D", hash_generated_method = "038A39FAE6F83E14E3BA1597CD180C9D")
        public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay,  long delay, TimeUnit unit) {
            addTaint(unit.getTaint());
            addTaint(delay);
            addTaint(initialDelay);
            addTaint(command.getTaint());
ScheduledFuture<?> var53F2CCDC6067CE879ED6DFB893DF41AA_294129280 =             e.scheduleWithFixedDelay(command, initialDelay, delay, unit);
            var53F2CCDC6067CE879ED6DFB893DF41AA_294129280.addTaint(taint);
            return var53F2CCDC6067CE879ED6DFB893DF41AA_294129280;
            // ---------- Original Method ----------
            //return e.scheduleWithFixedDelay(command, initialDelay, delay, unit);
        }

        
    }


    
}

