package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedExceptionAction;
import java.security.PrivilegedActionException;
import java.security.AccessControlException;

public class Executors {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.656 -0400", hash_original_method = "F4CB3C27487DF72857FE3507DC40AD75", hash_generated_method = "27F2BAE4FD286E326334A8739E3D4262")
    @DSModeled(DSC.SAFE)
    private Executors() {
        // ---------- Original Method ----------
    }

    
        public static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>());
    }

    
        public static ExecutorService newFixedThreadPool(int nThreads, ThreadFactory threadFactory) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>(),
                                      threadFactory);
    }

    
        public static ExecutorService newSingleThreadExecutor() {
        return new FinalizableDelegatedExecutorService
            (new ThreadPoolExecutor(1, 1,
                                    0L, TimeUnit.MILLISECONDS,
                                    new LinkedBlockingQueue<Runnable>()));
    }

    
        public static ExecutorService newSingleThreadExecutor(ThreadFactory threadFactory) {
        return new FinalizableDelegatedExecutorService
            (new ThreadPoolExecutor(1, 1,
                                    0L, TimeUnit.MILLISECONDS,
                                    new LinkedBlockingQueue<Runnable>(),
                                    threadFactory));
    }

    
        public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                      60L, TimeUnit.SECONDS,
                                      new SynchronousQueue<Runnable>());
    }

    
        public static ExecutorService newCachedThreadPool(ThreadFactory threadFactory) {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                      60L, TimeUnit.SECONDS,
                                      new SynchronousQueue<Runnable>(),
                                      threadFactory);
    }

    
        public static ScheduledExecutorService newSingleThreadScheduledExecutor() {
        return new DelegatedScheduledExecutorService
            (new ScheduledThreadPoolExecutor(1));
    }

    
        public static ScheduledExecutorService newSingleThreadScheduledExecutor(ThreadFactory threadFactory) {
        return new DelegatedScheduledExecutorService
            (new ScheduledThreadPoolExecutor(1, threadFactory));
    }

    
        public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize) {
        return new ScheduledThreadPoolExecutor(corePoolSize);
    }

    
        public static ScheduledExecutorService newScheduledThreadPool(
            int corePoolSize, ThreadFactory threadFactory) {
        return new ScheduledThreadPoolExecutor(corePoolSize, threadFactory);
    }

    
        public static ExecutorService unconfigurableExecutorService(ExecutorService executor) {
        if (executor == null)
            throw new NullPointerException();
        return new DelegatedExecutorService(executor);
    }

    
        public static ScheduledExecutorService unconfigurableScheduledExecutorService(ScheduledExecutorService executor) {
        if (executor == null)
            throw new NullPointerException();
        return new DelegatedScheduledExecutorService(executor);
    }

    
        public static ThreadFactory defaultThreadFactory() {
        return new DefaultThreadFactory();
    }

    
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
        Runnable task;
        T result;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.659 -0400", hash_original_method = "39BEB710EA675D51CD733BCB993FC74E", hash_generated_method = "760DA5C47A152F91FDFD6451280E1CFB")
        @DSModeled(DSC.SAFE)
         RunnableAdapter(Runnable task, T result) {
            dsTaint.addTaint(result.dsTaint);
            dsTaint.addTaint(task.dsTaint);
            // ---------- Original Method ----------
            //this.task = task;
            //this.result = result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.659 -0400", hash_original_method = "0255C7C18478A7E06F3D7DE61652A41C", hash_generated_method = "3FD1719EEDA65DF71F6B98E422915E98")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public T call() {
            task.run();
            return (T)dsTaint.getTaint();
            // ---------- Original Method ----------
            //task.run();
            //return result;
        }

        
    }


    
    static final class PrivilegedCallable<T> implements Callable<T> {
        private Callable<T> task;
        private AccessControlContext acc;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.660 -0400", hash_original_method = "12C65A09BA65E906C8B3945E2B4DB442", hash_generated_method = "F62CF428DF05497DF78A5EF6607769AC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         PrivilegedCallable(Callable<T> task) {
            dsTaint.addTaint(task.dsTaint);
            this.acc = AccessController.getContext();
            // ---------- Original Method ----------
            //this.task = task;
            //this.acc = AccessController.getContext();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.660 -0400", hash_original_method = "9B84B0D9F1F9FF2095D253EA33535221", hash_generated_method = "7054E9F6F9C2C56FF2E4D16A7F8AEEC2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public T call() throws Exception {
            try 
            {
                T var3B74C500068E329A67DC91FD90888384_352542707 = (AccessController.doPrivileged(
                    new PrivilegedExceptionAction<T>() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.660 -0400", hash_original_method = "2C30E1492126DFE1004B0460419644DD", hash_generated_method = "98124A5CB8952E9A0C1ECB55E9B6266A")
                    //DSFIXME:  CODE0002: Requires DSC value to be set
                    public T run() throws Exception {
                        T var9F2AB630FB4C37E79621CFAAF017608E_1412347860 = (task.call());
                        return (T)dsTaint.getTaint();
                        // ---------- Original Method ----------
                        //return task.call();
                    }
}, acc));
            } //End block
            catch (PrivilegedActionException e)
            {
                if (DroidSafeAndroidRuntime.control) throw e.getException();
            } //End block
            return (T)dsTaint.getTaint();
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

        
    }


    
    static final class PrivilegedCallableUsingCurrentClassLoader<T> implements Callable<T> {
        private Callable<T> task;
        private AccessControlContext acc;
        private ClassLoader ccl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.660 -0400", hash_original_method = "A45AF0A17387712B1B0259CF7D85D2E1", hash_generated_method = "049848C765FFAD28CA74A4DCFB9E0408")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         PrivilegedCallableUsingCurrentClassLoader(Callable<T> task) {
            dsTaint.addTaint(task.dsTaint);
            SecurityManager sm;
            sm = System.getSecurityManager();
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
            //this.task = task;
            //this.acc = AccessController.getContext();
            //this.ccl = Thread.currentThread().getContextClassLoader();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.661 -0400", hash_original_method = "083E1FD40613168D34C9FEEE9DFC0EBD", hash_generated_method = "5B08F1EC5B524398DABC06AB73F938C8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public T call() throws Exception {
            try 
            {
                T var0669DDCF1FAE92BFFB6CA64DDDA37A2C_1124294571 = (AccessController.doPrivileged(
                    new PrivilegedExceptionAction<T>() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.661 -0400", hash_original_method = "EAF5A8360517EEB3FD91B09A069198A5", hash_generated_method = "8436C4FC813BC965A5D7D435B7FF581B")
                    //DSFIXME:  CODE0002: Requires DSC value to be set
                    public T run() throws Exception {
                        ClassLoader savedcl;
                        savedcl = null;
                        Thread t;
                        t = Thread.currentThread();
                        try 
                        {
                            ClassLoader cl;
                            cl = t.getContextClassLoader();
                            {
                                t.setContextClassLoader(ccl);
                                savedcl = cl;
                            } //End block
                            T varD3A360AF8FC251D5DD24B35FCCB96940_1784191676 = (task.call());
                        } //End block
                        finally 
                        {
                            t.setContextClassLoader(savedcl);
                        } //End block
                        return (T)dsTaint.getTaint();
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
}, acc));
            } //End block
            catch (PrivilegedActionException e)
            {
                if (DroidSafeAndroidRuntime.control) throw e.getException();
            } //End block
            return (T)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    static class DefaultThreadFactory implements ThreadFactory {
        private ThreadGroup group;
        private AtomicInteger threadNumber = new AtomicInteger(1);
        private String namePrefix;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.661 -0400", hash_original_method = "6C4DB34AB218BB8D6524A59E94717A2E", hash_generated_method = "A97E98CC6A9DCA4F4D0AEA26CD18D1F6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         DefaultThreadFactory() {
            SecurityManager s;
            s = System.getSecurityManager();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.662 -0400", hash_original_method = "FA504429181C673B0F1001408D56C877", hash_generated_method = "2F890955110664607F0EAE81E1B5976D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Thread newThread(Runnable r) {
            dsTaint.addTaint(r.dsTaint);
            Thread t;
            t = new Thread(group, r,
                                  namePrefix + threadNumber.getAndIncrement(),
                                  0);
            {
                boolean varF7C18CDC40FE52729E732C3509DE30D5_360785479 = (t.isDaemon());
                t.setDaemon(false);
            } //End collapsed parenthetic
            {
                boolean var79BB14B3C56BE9336B8108F98A5C5A41_799968711 = (t.getPriority() != Thread.NORM_PRIORITY);
                t.setPriority(Thread.NORM_PRIORITY);
            } //End collapsed parenthetic
            return (Thread)dsTaint.getTaint();
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

        
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
    }


    
    static class PrivilegedThreadFactory extends DefaultThreadFactory {
        private AccessControlContext acc;
        private ClassLoader ccl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.662 -0400", hash_original_method = "1637F6F8B2206F80B43C5E6A7CCBC9A4", hash_generated_method = "5826413C4321FC7E59BF30F85D515A56")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         PrivilegedThreadFactory() {
            super();
            SecurityManager sm;
            sm = System.getSecurityManager();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.663 -0400", hash_original_method = "0BB5C6FA3ECC4446695A9AB19E82A9A9", hash_generated_method = "22D96E2CBB638F47D32B190ED1DE862D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Thread newThread(final Runnable r) {
            dsTaint.addTaint(r.dsTaint);
            Thread var96798822220CF5C975CBFF94501002C5_504620050 = (super.newThread(new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.663 -0400", hash_original_method = "3766F05AB50EC7E8431DCAB08B326340", hash_generated_method = "85CBA7F985A88617EF0981F0C1AFEFF8")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                public void run() {
                    AccessController.doPrivileged(new PrivilegedAction<Void>() {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.662 -0400", hash_original_method = "99386286B0FCA4E3E184AF51137A113C", hash_generated_method = "598977CDB0283F15D7A0F55FD8615C7C")
                        //DSFIXME:  CODE0002: Requires DSC value to be set
                        public Void run() {
                            Thread.currentThread().setContextClassLoader(ccl);
                            r.run();
                            return (Void)dsTaint.getTaint();
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
}));
            return (Thread)dsTaint.getTaint();
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
        private ExecutorService e;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.663 -0400", hash_original_method = "69B8656E71D4B49ACEB9CE44B20A63F5", hash_generated_method = "2627D03E6299C45314C93442C4D8E4AE")
        @DSModeled(DSC.SAFE)
         DelegatedExecutorService(ExecutorService executor) {
            dsTaint.addTaint(executor.dsTaint);
            // ---------- Original Method ----------
            //e = executor;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.663 -0400", hash_original_method = "680CD1247FE9848C91F828B8B2655AA2", hash_generated_method = "59CD0A3E7D72E190DE160E7043380C93")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void execute(Runnable command) {
            dsTaint.addTaint(command.dsTaint);
            e.execute(command);
            // ---------- Original Method ----------
            //e.execute(command);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.663 -0400", hash_original_method = "AC5ABD61901BFC6045B0080105C55DDA", hash_generated_method = "870B34DC67E6CAF4D4CA22846B67BE5A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void shutdown() {
            e.shutdown();
            // ---------- Original Method ----------
            //e.shutdown();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.663 -0400", hash_original_method = "96CCD300667A8693DD62C1833316B3E7", hash_generated_method = "D2830C1F654EA26EB0718376843EB563")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public List<Runnable> shutdownNow() {
            List<Runnable> varF57DDCA1E1CA1715D0F81F845E8F13F8_1276990137 = (e.shutdownNow());
            return (List<Runnable>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return e.shutdownNow();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.664 -0400", hash_original_method = "6953493B1D30A903FCCDB4081BC753C6", hash_generated_method = "58DE67265373EB50ADD84E5AB7DA936A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean isShutdown() {
            boolean var36CED742EFDAB0F6D9A92D25333E2306_1558340827 = (e.isShutdown());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return e.isShutdown();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.664 -0400", hash_original_method = "BA72422211BC216152EB93C851C6051E", hash_generated_method = "FFDDFAADCE63F0EC97C4792AD67AF4C7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean isTerminated() {
            boolean var6E4612614060DC815BDD3E4518A67800_1078878707 = (e.isTerminated());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return e.isTerminated();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.664 -0400", hash_original_method = "7B27D3C16A1D302AD16E181EBB018DAC", hash_generated_method = "A4150F2FAF69967AA3119F999B2BEFE1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
            dsTaint.addTaint(unit.dsTaint);
            dsTaint.addTaint(timeout);
            boolean var20413AB9E53FCD248F27D8E43F3504BD_165909631 = (e.awaitTermination(timeout, unit));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return e.awaitTermination(timeout, unit);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.664 -0400", hash_original_method = "70A4BA700942918290F358C98B70C3C4", hash_generated_method = "B8F7177191AD53ED8029E477823260B1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Future<?> submit(Runnable task) {
            dsTaint.addTaint(task.dsTaint);
            Future<?> var4D3DE64B26B9CCB88467461A11CA0AD7_1228603690 = (e.submit(task));
            return (Future<?>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return e.submit(task);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.664 -0400", hash_original_method = "83E0E20FEE789D6C0B6E1A8BE258D9AC", hash_generated_method = "7F8246B2861AEBD19204428FE22BE41D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public <T> Future<T> submit(Callable<T> task) {
            dsTaint.addTaint(task.dsTaint);
            Future<T> var4D3DE64B26B9CCB88467461A11CA0AD7_249406156 = (e.submit(task));
            return (Future<T>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return e.submit(task);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.664 -0400", hash_original_method = "7C597CCD4131D2329D010B8EED3AD866", hash_generated_method = "BD3DD6FE5758E06CDC764F1E7ADB872D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public <T> Future<T> submit(Runnable task, T result) {
            dsTaint.addTaint(result.dsTaint);
            dsTaint.addTaint(task.dsTaint);
            Future<T> varDA15F8DE10514ED30B98ADAA2EDC3AB7_2014899794 = (e.submit(task, result));
            return (Future<T>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return e.submit(task, result);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.665 -0400", hash_original_method = "F48A0D0A4C3710017B7673C8DB7925EC", hash_generated_method = "8FF4A6F2E90C4E7106B6E6DFB2422918")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
            dsTaint.addTaint(tasks.dsTaint);
            List<Future<T>> var1C13705CA4DD085B05324AF5E7DE96D9_2069018978 = (e.invokeAll(tasks));
            return (List<Future<T>>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return e.invokeAll(tasks);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.665 -0400", hash_original_method = "5F911CE685489301A15E24D766797016", hash_generated_method = "D2CBDD5CE74261DD242D36DEB52CBF3D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks,
                                             long timeout, TimeUnit unit) throws InterruptedException {
            dsTaint.addTaint(unit.dsTaint);
            dsTaint.addTaint(tasks.dsTaint);
            dsTaint.addTaint(timeout);
            List<Future<T>> var24AC2E47C00CE77B69A5F18E2A5833D7_207866530 = (e.invokeAll(tasks, timeout, unit));
            return (List<Future<T>>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return e.invokeAll(tasks, timeout, unit);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.665 -0400", hash_original_method = "4C0A5FF3374B9876DAD3CF3A7DB4F9BC", hash_generated_method = "7C68BBC05CB957AD730347BCA51A0A5C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
            dsTaint.addTaint(tasks.dsTaint);
            T var2E0764D98D82FE057C8BE42C49BBE9DB_36191326 = (e.invokeAny(tasks));
            return (T)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return e.invokeAny(tasks);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.665 -0400", hash_original_method = "D15E2648AE9554DE3EDB2502DC3264EF", hash_generated_method = "2E170D42ACD6A481F649535EA273836D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public <T> T invokeAny(Collection<? extends Callable<T>> tasks,
                               long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            dsTaint.addTaint(unit.dsTaint);
            dsTaint.addTaint(tasks.dsTaint);
            dsTaint.addTaint(timeout);
            T varD152C5F5BC2811FE88010BAFCFD80B6A_709297772 = (e.invokeAny(tasks, timeout, unit));
            return (T)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return e.invokeAny(tasks, timeout, unit);
        }

        
    }


    
    static class FinalizableDelegatedExecutorService extends DelegatedExecutorService {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.665 -0400", hash_original_method = "0BC6912A00A2948375A36BA345B953A1", hash_generated_method = "296CDB1CDD64C38E7D1F2A6C488AFA49")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         FinalizableDelegatedExecutorService(ExecutorService executor) {
            super(executor);
            dsTaint.addTaint(executor.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.665 -0400", hash_original_method = "EFBA277C67FEFB15F281D1F7A5118361", hash_generated_method = "75FB1DC5FB180CA67655AFF259FD4832")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected void finalize() {
            super.shutdown();
            // ---------- Original Method ----------
            //super.shutdown();
        }

        
    }


    
    static class DelegatedScheduledExecutorService extends DelegatedExecutorService implements ScheduledExecutorService {
        private ScheduledExecutorService e;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.666 -0400", hash_original_method = "B9414E1A08721941535D3112D446A4F5", hash_generated_method = "1F538583E456E0CC524D17930914EA0B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         DelegatedScheduledExecutorService(ScheduledExecutorService executor) {
            super(executor);
            dsTaint.addTaint(executor.dsTaint);
            // ---------- Original Method ----------
            //e = executor;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.666 -0400", hash_original_method = "D790041C21C164D4B5FF50718A4BC1E6", hash_generated_method = "EDABAD63EFE1781397129CC3296593C7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ScheduledFuture<?> schedule(Runnable command, long delay,  TimeUnit unit) {
            dsTaint.addTaint(unit.dsTaint);
            dsTaint.addTaint(command.dsTaint);
            dsTaint.addTaint(delay);
            ScheduledFuture<?> var13979FEBFABC2A2FD7221A291BDEE95E_1061028609 = (e.schedule(command, delay, unit));
            return (ScheduledFuture<?>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return e.schedule(command, delay, unit);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.666 -0400", hash_original_method = "21B2A7EFB4EC4FCA85726955706F3411", hash_generated_method = "8CB02A40C0CB2575F94160204FA5B45A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
            dsTaint.addTaint(unit.dsTaint);
            dsTaint.addTaint(callable.dsTaint);
            dsTaint.addTaint(delay);
            ScheduledFuture<V> varEEB0E012B2C6FFAFA94E210CEE258C7C_1583246237 = (e.schedule(callable, delay, unit));
            return (ScheduledFuture<V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return e.schedule(callable, delay, unit);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.666 -0400", hash_original_method = "913AC360688F049D7C1CA1D721236AC7", hash_generated_method = "770D02F56EF03C0711E0AC0B95DE8A11")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay,  long period, TimeUnit unit) {
            dsTaint.addTaint(unit.dsTaint);
            dsTaint.addTaint(initialDelay);
            dsTaint.addTaint(command.dsTaint);
            dsTaint.addTaint(period);
            ScheduledFuture<?> var0E4FB196D8706A279BC2A91999BA184C_475297638 = (e.scheduleAtFixedRate(command, initialDelay, period, unit));
            return (ScheduledFuture<?>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return e.scheduleAtFixedRate(command, initialDelay, period, unit);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:34.666 -0400", hash_original_method = "6DC4F7F046861AD80936134D3479B23D", hash_generated_method = "BEE8115F7AD985649D3AAFD3FC718B5F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay,  long delay, TimeUnit unit) {
            dsTaint.addTaint(unit.dsTaint);
            dsTaint.addTaint(initialDelay);
            dsTaint.addTaint(command.dsTaint);
            dsTaint.addTaint(delay);
            ScheduledFuture<?> var23719CB537297917BAEC7C4EC90384B4_562939547 = (e.scheduleWithFixedDelay(command, initialDelay, delay, unit));
            return (ScheduledFuture<?>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return e.scheduleWithFixedDelay(command, initialDelay, delay, unit);
        }

        
    }


    
}

