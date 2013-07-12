package java.util.concurrent;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.941 -0400", hash_original_method = "F4CB3C27487DF72857FE3507DC40AD75", hash_generated_method = "27F2BAE4FD286E326334A8739E3D4262")
    private  Executors() {
        
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

    
        public static <T> Callable<T> privilegedCallable(Callable<T> callable) {
        if (callable == null)
            throw new NullPointerException();
        return new PrivilegedCallable<T>(callable);
    }

    
        public static <T> Callable<T> privilegedCallableUsingCurrentClassLoader(Callable<T> callable) {
        if (callable == null)
            throw new NullPointerException();
        return new PrivilegedCallableUsingCurrentClassLoader<T>(callable);
    }

    
    static final class RunnableAdapter<T> implements Callable<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.945 -0400", hash_original_field = "478F3A4C51824AD23CB50C1C60670C0F", hash_generated_field = "3B9DB014EA5583311EF52FFA01325C0E")

        Runnable task;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.945 -0400", hash_original_field = "B4A88417B3D0170D754C647C30B7216A", hash_generated_field = "8B901F4123EF91F350535EEC5A55F787")

        T result;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.946 -0400", hash_original_method = "39BEB710EA675D51CD733BCB993FC74E", hash_generated_method = "B66D71CB0E2F61493FC0C79EA7F2EE40")
          RunnableAdapter(Runnable task, T result) {
            this.task = task;
            this.result = result;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.946 -0400", hash_original_method = "0255C7C18478A7E06F3D7DE61652A41C", hash_generated_method = "FE6D65A25A8E4FC91202214AD1735A8E")
        public T call() {
            task.run();
T varDC838461EE2FA0CA4C9BBB70A15456B0_1852082106 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_1852082106.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_1852082106;
            
            
            
        }

        
    }


    
    static final class PrivilegedCallable<T> implements Callable<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.947 -0400", hash_original_field = "478F3A4C51824AD23CB50C1C60670C0F", hash_generated_field = "CFBF2BD2CA84F7FFF876D42173005A51")

        private Callable<T> task;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.947 -0400", hash_original_field = "1673448EE7064C989D02579C534F6B66", hash_generated_field = "5E0BB9B3EC8D99479706D49A606F3BE8")

        private AccessControlContext acc;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.947 -0400", hash_original_method = "12C65A09BA65E906C8B3945E2B4DB442", hash_generated_method = "407881EAC3D9A4573DC5616AB923DB76")
          PrivilegedCallable(Callable<T> task) {
            this.task = task;
            this.acc = AccessController.getContext();
            
            
            
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
                
                
            }
}, acc);
                var8C0E7955A367AA4C5A2C7492B4312867_977516067.addTaint(taint);
                return var8C0E7955A367AA4C5A2C7492B4312867_977516067;
            } 
            catch (PrivilegedActionException e)
            {
                Exception varB727EB75A5923A25079A15DB07B65969_1926769963 = e.getException();
                varB727EB75A5923A25079A15DB07B65969_1926769963.addTaint(taint);
                throw varB727EB75A5923A25079A15DB07B65969_1926769963;
            } 
            
            
                
                    
                        
                            
                        
                    
            
                
            
        }

        
        
        public T run() throws Exception {
                            return task.call();
                        }
        
    }


    
    static final class PrivilegedCallableUsingCurrentClassLoader<T> implements Callable<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.950 -0400", hash_original_field = "478F3A4C51824AD23CB50C1C60670C0F", hash_generated_field = "CFBF2BD2CA84F7FFF876D42173005A51")

        private Callable<T> task;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.950 -0400", hash_original_field = "1673448EE7064C989D02579C534F6B66", hash_generated_field = "5E0BB9B3EC8D99479706D49A606F3BE8")

        private AccessControlContext acc;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.950 -0400", hash_original_field = "95BBC40CB7BBF40EBF7B825922894718", hash_generated_field = "F0BF273B591E278A790B33F9A1F9CEDB")

        private ClassLoader ccl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.951 -0400", hash_original_method = "A45AF0A17387712B1B0259CF7D85D2E1", hash_generated_method = "5E92716C021B3E4BA5538C1BD0AE719E")
          PrivilegedCallableUsingCurrentClassLoader(Callable<T> task) {
            SecurityManager sm = System.getSecurityManager();
    if(sm != null)            
            {
                sm.checkPermission(new RuntimePermission("getContextClassLoader"));
                sm.checkPermission(new RuntimePermission("setContextClassLoader"));
            } 
            this.task = task;
            this.acc = AccessController.getContext();
            this.ccl = Thread.currentThread().getContextClassLoader();
            
            
            
                
                
            
            
            
            
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
                    } 
T var1E6FFBD2B2AE8130DD2A092BC0BC400B_480532354 =                     task.call();
                    var1E6FFBD2B2AE8130DD2A092BC0BC400B_480532354.addTaint(taint);
                    return var1E6FFBD2B2AE8130DD2A092BC0BC400B_480532354;
                } 
                finally 
                {
    if(savedcl != null)                    
                    t.setContextClassLoader(savedcl);
                } 
                
                
                
                
                                
                                
                                    
                                    
                                
                                
                            
                                
                                    
                            
            }
}, acc);
                varBCBFD1547E568D77EC8B60D97435E881_964807118.addTaint(taint);
                return varBCBFD1547E568D77EC8B60D97435E881_964807118;
            } 
            catch (PrivilegedActionException e)
            {
                Exception varB727EB75A5923A25079A15DB07B65969_1592493440 = e.getException();
                varB727EB75A5923A25079A15DB07B65969_1592493440.addTaint(taint);
                throw varB727EB75A5923A25079A15DB07B65969_1592493440;
            } 
            
            
        }

        
        
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.953 -0400", hash_original_field = "DB0F6F37EBEB6EA09489124345AF2A45", hash_generated_field = "6F10AD05CE1F57FC2F4A5DF43A505F99")

        private ThreadGroup group;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.953 -0400", hash_original_field = "29DCC4905D6FB1DA2B7219093C787E49", hash_generated_field = "1DD6DDF0F67F2F10AA2E1938FCC29304")

        private final AtomicInteger threadNumber = new AtomicInteger(1);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.953 -0400", hash_original_field = "4110ADAB8C8C67636BBEC549E9B73281", hash_generated_field = "2F76B01D831BB088ADF19AC1319DB54D")

        private String namePrefix;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.954 -0400", hash_original_method = "6C4DB34AB218BB8D6524A59E94717A2E", hash_generated_method = "8BE04B7CF7D9B446A09A2C26EE6BA63C")
          DefaultThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                                  Thread.currentThread().getThreadGroup();
            namePrefix = "pool-" +
                          poolNumber.getAndIncrement() +
                         "-thread-";
            
            
            
                                  
            
                          
                         
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.954 -0400", hash_original_method = "FA504429181C673B0F1001408D56C877", hash_generated_method = "DDAAA3796130EA9E43563D3FBFC12774")
        public Thread newThread(Runnable r) {
            addTaint(r.getTaint());
            Thread t = new Thread(group, r,
                                  namePrefix + threadNumber.getAndIncrement(),
                                  0);
    if(t.isDaemon())            
            t.setDaemon(false);
    if(t.getPriority() != Thread.NORM_PRIORITY)            
            t.setPriority(Thread.NORM_PRIORITY);
Thread varE0D714D758F1540A8DF364A965AF9150_526642371 =             t;
            varE0D714D758F1540A8DF364A965AF9150_526642371.addTaint(taint);
            return varE0D714D758F1540A8DF364A965AF9150_526642371;
            
            
                                  
                                  
            
                
            
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.954 -0400", hash_original_field = "8173E1475D6022921D6CE09AFFF974B7", hash_generated_field = "4D1AD706E0B207CD49EDE0FDF77D35E3")

        private static final AtomicInteger poolNumber = new AtomicInteger(1);
    }


    
    static class PrivilegedThreadFactory extends DefaultThreadFactory {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.954 -0400", hash_original_field = "1673448EE7064C989D02579C534F6B66", hash_generated_field = "5E0BB9B3EC8D99479706D49A606F3BE8")

        private AccessControlContext acc;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.955 -0400", hash_original_field = "95BBC40CB7BBF40EBF7B825922894718", hash_generated_field = "F0BF273B591E278A790B33F9A1F9CEDB")

        private ClassLoader ccl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.955 -0400", hash_original_method = "1637F6F8B2206F80B43C5E6A7CCBC9A4", hash_generated_method = "F91B3DAB0C57DC65E77479441B3B8393")
          PrivilegedThreadFactory() {
            super();
            SecurityManager sm = System.getSecurityManager();
    if(sm != null)            
            {
                sm.checkPermission(new RuntimePermission("getContextClassLoader"));
                sm.checkPermission(new RuntimePermission("setContextClassLoader"));
            } 
            this.acc = AccessController.getContext();
            this.ccl = Thread.currentThread().getContextClassLoader();
            
            
            
                
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.956 -0400", hash_original_method = "0BB5C6FA3ECC4446695A9AB19E82A9A9", hash_generated_method = "B6AE8F9F2DC2CEC7C2059555500C0362")
        public Thread newThread(final Runnable r) {
            addTaint(r.getTaint());
Thread var801BC3E623C83925F37035F64FDA758D_962732214 =             super.newThread(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.956 -0400", hash_original_method = "3766F05AB50EC7E8431DCAB08B326340", hash_generated_method = "6236D4A2CEB149B90F57BEEDD81A0B8A")
            public void run() {
                AccessController.doPrivileged(new PrivilegedAction<Void>() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.956 -0400", hash_original_method = "99386286B0FCA4E3E184AF51137A113C", hash_generated_method = "76C019876A0A5F61DB3AF70C9016E775")
                public Void run() {
                    Thread.currentThread().setContextClassLoader(ccl);
                    r.run();
Void var540C13E9E156B687226421B24F2DF178_1627636724 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1627636724.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1627636724;
                    
                    
                    
                    
                }
}, acc);
                
                
                        
                            
                            
                            
                        
                    
            }
});
            var801BC3E623C83925F37035F64FDA758D_962732214.addTaint(taint);
            return var801BC3E623C83925F37035F64FDA758D_962732214;
            
            
                
                    
                        
                            
                            
                            
                        
                    
                
            
        }

        
    }


    
    static class DelegatedExecutorService extends AbstractExecutorService {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.957 -0400", hash_original_field = "E1671797C52E15F763380B45E841EC32", hash_generated_field = "11B8F83ADD158AE4ADD1E7AA1252842D")

        private ExecutorService e;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.957 -0400", hash_original_method = "69B8656E71D4B49ACEB9CE44B20A63F5", hash_generated_method = "FF9F28349FB8E5F20D2028CD89D51AA0")
          DelegatedExecutorService(ExecutorService executor) {
            e = executor;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.957 -0400", hash_original_method = "680CD1247FE9848C91F828B8B2655AA2", hash_generated_method = "DFB7C3A39554EE1AD7A22617C0DA9F83")
        public void execute(Runnable command) {
            addTaint(command.getTaint());
            e.execute(command);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.958 -0400", hash_original_method = "AC5ABD61901BFC6045B0080105C55DDA", hash_generated_method = "870B34DC67E6CAF4D4CA22846B67BE5A")
        public void shutdown() {
            e.shutdown();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.958 -0400", hash_original_method = "96CCD300667A8693DD62C1833316B3E7", hash_generated_method = "0C8F22D07BF01C32CAB861E83F406F7B")
        public List<Runnable> shutdownNow() {
List<Runnable> varE7D27192245C2FE3CA0A1CDFDB021EEB_110328660 =             e.shutdownNow();
            varE7D27192245C2FE3CA0A1CDFDB021EEB_110328660.addTaint(taint);
            return varE7D27192245C2FE3CA0A1CDFDB021EEB_110328660;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.958 -0400", hash_original_method = "6953493B1D30A903FCCDB4081BC753C6", hash_generated_method = "39EE793BCB34D9049C84CDB097CC76EE")
        public boolean isShutdown() {
            boolean varC6BFDE34389895E5EC4C039BD088BBC2_1072579422 = (e.isShutdown());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1808514395 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1808514395;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.958 -0400", hash_original_method = "BA72422211BC216152EB93C851C6051E", hash_generated_method = "9071D8BC9B9BDEB5A69966DA1E0CAABE")
        public boolean isTerminated() {
            boolean var9CE7EBB7372D816EEE62EC46692AA90B_2081984493 = (e.isTerminated());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1521707067 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1521707067;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.959 -0400", hash_original_method = "7B27D3C16A1D302AD16E181EBB018DAC", hash_generated_method = "814F8E0F4621B16B1E72B35107CA4979")
        public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
            addTaint(unit.getTaint());
            addTaint(timeout);
            boolean varF366CFDDB9AAE5CFAA90DAA671DBA4AC_630302767 = (e.awaitTermination(timeout, unit));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_640633988 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_640633988;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.959 -0400", hash_original_method = "70A4BA700942918290F358C98B70C3C4", hash_generated_method = "A1A430428E6027A398E5C7378AB7492C")
        public Future<?> submit(Runnable task) {
            addTaint(task.getTaint());
Future<?> var3A821B5C48F3C73F2F85580271A54221_83310055 =             e.submit(task);
            var3A821B5C48F3C73F2F85580271A54221_83310055.addTaint(taint);
            return var3A821B5C48F3C73F2F85580271A54221_83310055;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.959 -0400", hash_original_method = "83E0E20FEE789D6C0B6E1A8BE258D9AC", hash_generated_method = "031A14FC38C1994D836A2AEEB791DE13")
        public <T> Future<T> submit(Callable<T> task) {
            addTaint(task.getTaint());
Future<T> var3A821B5C48F3C73F2F85580271A54221_1188930025 =             e.submit(task);
            var3A821B5C48F3C73F2F85580271A54221_1188930025.addTaint(taint);
            return var3A821B5C48F3C73F2F85580271A54221_1188930025;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.960 -0400", hash_original_method = "7C597CCD4131D2329D010B8EED3AD866", hash_generated_method = "A69A0D49CD7DE0B80E289C034FA1BEAA")
        public <T> Future<T> submit(Runnable task, T result) {
            addTaint(result.getTaint());
            addTaint(task.getTaint());
Future<T> varEAF64FBE2776E66AA7D7A86DC0368144_280892647 =             e.submit(task, result);
            varEAF64FBE2776E66AA7D7A86DC0368144_280892647.addTaint(taint);
            return varEAF64FBE2776E66AA7D7A86DC0368144_280892647;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.960 -0400", hash_original_method = "F48A0D0A4C3710017B7673C8DB7925EC", hash_generated_method = "3BD54F9A8C34E046FE5B6182EBF57741")
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
            addTaint(tasks.getTaint());
List<Future<T>> var501DF73082C68D7843A2F94A5A9D39DE_71047622 =             e.invokeAll(tasks);
            var501DF73082C68D7843A2F94A5A9D39DE_71047622.addTaint(taint);
            return var501DF73082C68D7843A2F94A5A9D39DE_71047622;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.960 -0400", hash_original_method = "5F911CE685489301A15E24D766797016", hash_generated_method = "958F5890836A601E098573705E037E12")
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks,
                                             long timeout, TimeUnit unit) throws InterruptedException {
            addTaint(unit.getTaint());
            addTaint(timeout);
            addTaint(tasks.getTaint());
List<Future<T>> var87E281F68E17B3CFFAEC895C8A8BFC68_804337449 =             e.invokeAll(tasks, timeout, unit);
            var87E281F68E17B3CFFAEC895C8A8BFC68_804337449.addTaint(taint);
            return var87E281F68E17B3CFFAEC895C8A8BFC68_804337449;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.961 -0400", hash_original_method = "4C0A5FF3374B9876DAD3CF3A7DB4F9BC", hash_generated_method = "FB16C514EDF287ADF8FF201AC4FC79EF")
        public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
            addTaint(tasks.getTaint());
T var7ECF5F9BD3788A61679614FEA5EAB1C2_1915503339 =             e.invokeAny(tasks);
            var7ECF5F9BD3788A61679614FEA5EAB1C2_1915503339.addTaint(taint);
            return var7ECF5F9BD3788A61679614FEA5EAB1C2_1915503339;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.961 -0400", hash_original_method = "D15E2648AE9554DE3EDB2502DC3264EF", hash_generated_method = "C6331F2FEE29EB7FD49F57D2BFCA0847")
        public <T> T invokeAny(Collection<? extends Callable<T>> tasks,
                               long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            addTaint(unit.getTaint());
            addTaint(timeout);
            addTaint(tasks.getTaint());
T varE9E99FB5B2AB72C024FC741DCEE9DEC0_397899579 =             e.invokeAny(tasks, timeout, unit);
            varE9E99FB5B2AB72C024FC741DCEE9DEC0_397899579.addTaint(taint);
            return varE9E99FB5B2AB72C024FC741DCEE9DEC0_397899579;
            
            
        }

        
    }


    
    static class FinalizableDelegatedExecutorService extends DelegatedExecutorService {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.961 -0400", hash_original_method = "0BC6912A00A2948375A36BA345B953A1", hash_generated_method = "0427AB51E917327C91B17605314F9B9B")
          FinalizableDelegatedExecutorService(ExecutorService executor) {
            super(executor);
            addTaint(executor.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.962 -0400", hash_original_method = "EFBA277C67FEFB15F281D1F7A5118361", hash_generated_method = "75FB1DC5FB180CA67655AFF259FD4832")
        protected void finalize() {
            super.shutdown();
            
            
        }

        
    }


    
    static class DelegatedScheduledExecutorService extends DelegatedExecutorService implements ScheduledExecutorService {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.962 -0400", hash_original_field = "E1671797C52E15F763380B45E841EC32", hash_generated_field = "3D78CFB93E5EA21FD7B6DC753DB36818")

        private ScheduledExecutorService e;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.962 -0400", hash_original_method = "B9414E1A08721941535D3112D446A4F5", hash_generated_method = "88B596860003D7EDE125C8F0F2905303")
          DelegatedScheduledExecutorService(ScheduledExecutorService executor) {
            super(executor);
            e = executor;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.963 -0400", hash_original_method = "D790041C21C164D4B5FF50718A4BC1E6", hash_generated_method = "001090D58ADEAE7C819F6ABB79069C15")
        public ScheduledFuture<?> schedule(Runnable command, long delay,  TimeUnit unit) {
            addTaint(unit.getTaint());
            addTaint(delay);
            addTaint(command.getTaint());
ScheduledFuture<?> var892BAF045ECBDE9C241F5DCF1E691A8C_709367732 =             e.schedule(command, delay, unit);
            var892BAF045ECBDE9C241F5DCF1E691A8C_709367732.addTaint(taint);
            return var892BAF045ECBDE9C241F5DCF1E691A8C_709367732;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.963 -0400", hash_original_method = "21B2A7EFB4EC4FCA85726955706F3411", hash_generated_method = "160D9F6C76FA1A7ED2C60F836D49E92E")
        public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
            addTaint(unit.getTaint());
            addTaint(delay);
            addTaint(callable.getTaint());
ScheduledFuture<V> var25477A3DA2D98386CF98CD42AD75D94E_1923230214 =             e.schedule(callable, delay, unit);
            var25477A3DA2D98386CF98CD42AD75D94E_1923230214.addTaint(taint);
            return var25477A3DA2D98386CF98CD42AD75D94E_1923230214;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.963 -0400", hash_original_method = "913AC360688F049D7C1CA1D721236AC7", hash_generated_method = "2FB3545D073C4349C017DBBB121A23C5")
        public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay,  long period, TimeUnit unit) {
            addTaint(unit.getTaint());
            addTaint(period);
            addTaint(initialDelay);
            addTaint(command.getTaint());
ScheduledFuture<?> var620733992FDA5475960C5660CA3DFFF4_596188277 =             e.scheduleAtFixedRate(command, initialDelay, period, unit);
            var620733992FDA5475960C5660CA3DFFF4_596188277.addTaint(taint);
            return var620733992FDA5475960C5660CA3DFFF4_596188277;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:07.964 -0400", hash_original_method = "6DC4F7F046861AD80936134D3479B23D", hash_generated_method = "EB294B78D821FABE7BF981AB3BBA7832")
        public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay,  long delay, TimeUnit unit) {
            addTaint(unit.getTaint());
            addTaint(delay);
            addTaint(initialDelay);
            addTaint(command.getTaint());
ScheduledFuture<?> var53F2CCDC6067CE879ED6DFB893DF41AA_703097685 =             e.scheduleWithFixedDelay(command, initialDelay, delay, unit);
            var53F2CCDC6067CE879ED6DFB893DF41AA_703097685.addTaint(taint);
            return var53F2CCDC6067CE879ED6DFB893DF41AA_703097685;
            
            
        }

        
    }


    
}

