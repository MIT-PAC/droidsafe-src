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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.587 -0400", hash_original_method = "F4CB3C27487DF72857FE3507DC40AD75", hash_generated_method = "607904F258B8ED01BB19286317E17FED")
    @DSModeled(DSC.SAFE)
    private Executors() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.588 -0400", hash_original_method = "4E40ED8EF1E85B572E2151F7FE652635", hash_generated_method = "24FC77A84622C7E6D132714BA0E4E804")
    public static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.590 -0400", hash_original_method = "B4B819B5FCF44407B1B16756E048CBA8", hash_generated_method = "E3B00C6A4203188D2006ED62C0A7DE75")
    public static ExecutorService newFixedThreadPool(int nThreads, ThreadFactory threadFactory) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>(),
                                      threadFactory);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.592 -0400", hash_original_method = "C1C113EB7A09B292CF1C69F4CC48EB73", hash_generated_method = "9221D76F05BD5816E653D4B3D94FCBF6")
    public static ExecutorService newSingleThreadExecutor() {
        return new FinalizableDelegatedExecutorService
            (new ThreadPoolExecutor(1, 1,
                                    0L, TimeUnit.MILLISECONDS,
                                    new LinkedBlockingQueue<Runnable>()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.593 -0400", hash_original_method = "B2D89085FD1440204585B1FDE708D472", hash_generated_method = "0DB1D891C4BC734697C61313156F9928")
    public static ExecutorService newSingleThreadExecutor(ThreadFactory threadFactory) {
        return new FinalizableDelegatedExecutorService
            (new ThreadPoolExecutor(1, 1,
                                    0L, TimeUnit.MILLISECONDS,
                                    new LinkedBlockingQueue<Runnable>(),
                                    threadFactory));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.595 -0400", hash_original_method = "F8AEA60969AF891BED1528CB27A5B3DF", hash_generated_method = "5531971EB656A2DB0F9493BF080E0215")
    public static ExecutorService newCachedThreadPool() {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                      60L, TimeUnit.SECONDS,
                                      new SynchronousQueue<Runnable>());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.597 -0400", hash_original_method = "75C2AC8A8F418D624F70F1077C2FBC95", hash_generated_method = "A546D36DD3CD43F0C743AE5AE607FB0C")
    public static ExecutorService newCachedThreadPool(ThreadFactory threadFactory) {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                                      60L, TimeUnit.SECONDS,
                                      new SynchronousQueue<Runnable>(),
                                      threadFactory);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.598 -0400", hash_original_method = "3B8D30E77CB845E3C376AA2B983070C1", hash_generated_method = "55D57A7E9E195C304A2DD55867C5D9F9")
    public static ScheduledExecutorService newSingleThreadScheduledExecutor() {
        return new DelegatedScheduledExecutorService
            (new ScheduledThreadPoolExecutor(1));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.599 -0400", hash_original_method = "662E48DC77F0E634963E4AF8B4B2319F", hash_generated_method = "3031A768012849957C19B4921EB5DA3F")
    public static ScheduledExecutorService newSingleThreadScheduledExecutor(ThreadFactory threadFactory) {
        return new DelegatedScheduledExecutorService
            (new ScheduledThreadPoolExecutor(1, threadFactory));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.601 -0400", hash_original_method = "27FBCCF1D4D5EC0F51777630C21B1B2E", hash_generated_method = "D472E85837C5D4BE96BA90F2DAE0F3A5")
    public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize) {
        return new ScheduledThreadPoolExecutor(corePoolSize);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.602 -0400", hash_original_method = "D2C28C34E5EB211F6345884E8C056637", hash_generated_method = "5881D63D11562D74770FEB0EA1531801")
    public static ScheduledExecutorService newScheduledThreadPool(
            int corePoolSize, ThreadFactory threadFactory) {
        return new ScheduledThreadPoolExecutor(corePoolSize, threadFactory);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.603 -0400", hash_original_method = "70EF475EAD59784B9F4988C66F330DB5", hash_generated_method = "11F8FC8C39CCEECCB7A9FB73F6C578A4")
    public static ExecutorService unconfigurableExecutorService(ExecutorService executor) {
        if (executor == null)
            throw new NullPointerException();
        return new DelegatedExecutorService(executor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.605 -0400", hash_original_method = "CB4FE1F500230F7BE13AAEEB48858B34", hash_generated_method = "BA534C9653084D895D901BCD16036D28")
    public static ScheduledExecutorService unconfigurableScheduledExecutorService(ScheduledExecutorService executor) {
        if (executor == null)
            throw new NullPointerException();
        return new DelegatedScheduledExecutorService(executor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.606 -0400", hash_original_method = "B7AE3746CAE0BF4DA70BB99A06CCB766", hash_generated_method = "FF7C731BBAD164B6710B160D5B3024B5")
    public static ThreadFactory defaultThreadFactory() {
        return new DefaultThreadFactory();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.608 -0400", hash_original_method = "B9A1CBBC5DC86C417067189200E34377", hash_generated_method = "78C9982FEA6BC9F8BF1266665F95D38E")
    public static ThreadFactory privilegedThreadFactory() {
        return new PrivilegedThreadFactory();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.609 -0400", hash_original_method = "593630779FE21A2EB281F86344626C5A", hash_generated_method = "3034BAE88CB744313F891E6D1DA32164")
    public static <T> Callable<T> callable(Runnable task, T result) {
        if (task == null)
            throw new NullPointerException();
        return new RunnableAdapter<T>(task, result);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.612 -0400", hash_original_method = "B54692C5F74502C1CEAE2E6CE0A90F1F", hash_generated_method = "8E843E3A5EF673FDB9702C5AAD91BD00")
    public static Callable<Object> callable(Runnable task) {
        if (task == null)
            throw new NullPointerException();
        return new RunnableAdapter<Object>(task, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.614 -0400", hash_original_method = "F6FC70FD2057C587C6268022A75CFBC6", hash_generated_method = "0069F1EAA731D9CB4AE019BB10DF004D")
    public static Callable<Object> callable(final PrivilegedAction<?> action) {
        if (action == null)
            throw new NullPointerException();
        return new Callable<Object>() {
            public Object call() { return action.run(); }};
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.617 -0400", hash_original_method = "359460025258D9D5DCCDA9E43BB1EDE6", hash_generated_method = "E46C05FBDBDD6F6AACF28A3DBB02B0C1")
    public static Callable<Object> callable(final PrivilegedExceptionAction<?> action) {
        if (action == null)
            throw new NullPointerException();
        return new Callable<Object>() {
            public Object call() throws Exception { return action.run(); }};
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.618 -0400", hash_original_method = "FEFC08FC985E9FC45457DDDDC2538C69", hash_generated_method = "1817DA93F7116B89EC91597F8F02976C")
    public static <T> Callable<T> privilegedCallable(Callable<T> callable) {
        if (callable == null)
            throw new NullPointerException();
        return new PrivilegedCallable<T>(callable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.620 -0400", hash_original_method = "C1A53F7A7776D6727A792E068EADCE23", hash_generated_method = "1156AB34BF5EF063A8DE045A8E6C2DEC")
    public static <T> Callable<T> privilegedCallableUsingCurrentClassLoader(Callable<T> callable) {
        if (callable == null)
            throw new NullPointerException();
        return new PrivilegedCallableUsingCurrentClassLoader<T>(callable);
    }

    
    static final class RunnableAdapter<T> implements Callable<T> {
        Runnable task;
        T result;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.621 -0400", hash_original_method = "39BEB710EA675D51CD733BCB993FC74E", hash_generated_method = "2BB0664F821C8F89F1071CD1FC8C1852")
        @DSModeled(DSC.SAFE)
         RunnableAdapter(Runnable task, T result) {
            dsTaint.addTaint(result.dsTaint);
            dsTaint.addTaint(task.dsTaint);
            // ---------- Original Method ----------
            //this.task = task;
            //this.result = result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.623 -0400", hash_original_method = "0255C7C18478A7E06F3D7DE61652A41C", hash_generated_method = "665C9455C5A6A70161FD1CE7C9E51F64")
        @DSModeled(DSC.SAFE)
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.624 -0400", hash_original_method = "12C65A09BA65E906C8B3945E2B4DB442", hash_generated_method = "47AE49EA0EF7D00F564E59B0088CB910")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         PrivilegedCallable(Callable<T> task) {
            dsTaint.addTaint(task.dsTaint);
            this.acc = AccessController.getContext();
            // ---------- Original Method ----------
            //this.task = task;
            //this.acc = AccessController.getContext();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.626 -0400", hash_original_method = "9B84B0D9F1F9FF2095D253EA33535221", hash_generated_method = "4ADDC151D94A4FCC8928DBF6208296BA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public T call() throws Exception {
            try 
            {
                T var8DB3A1C18DE1E3562C286C9116B53929_29216894 = (AccessController.doPrivileged(
                    new PrivilegedExceptionAction<T>() {
                        public T run() throws Exception {
                            return task.call();
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.629 -0400", hash_original_method = "A45AF0A17387712B1B0259CF7D85D2E1", hash_generated_method = "2C66F1BBC22E031EF8D372B08CD11E0A")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.632 -0400", hash_original_method = "083E1FD40613168D34C9FEEE9DFC0EBD", hash_generated_method = "6CECE88C0755DB2AD3DFEBF36975AC26")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public T call() throws Exception {
            try 
            {
                T varEF508918CCBC98F990C9567C572D083A_302614539 = (AccessController.doPrivileged(
                    new PrivilegedExceptionAction<T>() {
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
        private static AtomicInteger poolNumber = new AtomicInteger(1);
        private ThreadGroup group;
        private AtomicInteger threadNumber = new AtomicInteger(1);
        private String namePrefix;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.634 -0400", hash_original_method = "6C4DB34AB218BB8D6524A59E94717A2E", hash_generated_method = "098154119540BEFE772EA1D13DE40762")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.637 -0400", hash_original_method = "FA504429181C673B0F1001408D56C877", hash_generated_method = "4B832732D1F2B9D830F90C095BFAE64D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Thread newThread(Runnable r) {
            dsTaint.addTaint(r.dsTaint);
            Thread t;
            t = new Thread(group, r,
                                  namePrefix + threadNumber.getAndIncrement(),
                                  0);
            {
                boolean varF7C18CDC40FE52729E732C3509DE30D5_610206367 = (t.isDaemon());
                t.setDaemon(false);
            } //End collapsed parenthetic
            {
                boolean var79BB14B3C56BE9336B8108F98A5C5A41_686879010 = (t.getPriority() != Thread.NORM_PRIORITY);
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

        
    }


    
    static class PrivilegedThreadFactory extends DefaultThreadFactory {
        private AccessControlContext acc;
        private ClassLoader ccl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.639 -0400", hash_original_method = "1637F6F8B2206F80B43C5E6A7CCBC9A4", hash_generated_method = "E6973B917D80FB0ED90BFB4C1DF5B886")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.641 -0400", hash_original_method = "0BB5C6FA3ECC4446695A9AB19E82A9A9", hash_generated_method = "DE15AE1276177218DFC384528738FD1E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Thread newThread(final Runnable r) {
            dsTaint.addTaint(r.dsTaint);
            Thread var97D34F2E49507BCB6D6EA9B93550CFEA_1245703285 = (super.newThread(new Runnable() {
                public void run() {
                    AccessController.doPrivileged(new PrivilegedAction<Void>() {
                        public Void run() {
                            Thread.currentThread().setContextClassLoader(ccl);
                            r.run();
                            return null;
                        }
                    }, acc);
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.643 -0400", hash_original_method = "69B8656E71D4B49ACEB9CE44B20A63F5", hash_generated_method = "24EF845B663DCD3B7ED0BDBA948172B2")
        @DSModeled(DSC.SAFE)
         DelegatedExecutorService(ExecutorService executor) {
            dsTaint.addTaint(executor.dsTaint);
            // ---------- Original Method ----------
            //e = executor;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.644 -0400", hash_original_method = "680CD1247FE9848C91F828B8B2655AA2", hash_generated_method = "AEA1AD7CCF76CCBE72DCFD943E6AE717")
        @DSModeled(DSC.SAFE)
        public void execute(Runnable command) {
            dsTaint.addTaint(command.dsTaint);
            e.execute(command);
            // ---------- Original Method ----------
            //e.execute(command);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.651 -0400", hash_original_method = "AC5ABD61901BFC6045B0080105C55DDA", hash_generated_method = "6C91816D584F77A27A02BAAFA9E02EE1")
        @DSModeled(DSC.SAFE)
        public void shutdown() {
            e.shutdown();
            // ---------- Original Method ----------
            //e.shutdown();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.653 -0400", hash_original_method = "96CCD300667A8693DD62C1833316B3E7", hash_generated_method = "F7A1F6DFD0724667E935B7D1EF791665")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public List<Runnable> shutdownNow() {
            List<Runnable> varF57DDCA1E1CA1715D0F81F845E8F13F8_1249419202 = (e.shutdownNow());
            return (List<Runnable>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return e.shutdownNow();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.654 -0400", hash_original_method = "6953493B1D30A903FCCDB4081BC753C6", hash_generated_method = "CF86B1F6680F30B262AA9D8F04C4249E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean isShutdown() {
            boolean var36CED742EFDAB0F6D9A92D25333E2306_174442801 = (e.isShutdown());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return e.isShutdown();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.656 -0400", hash_original_method = "BA72422211BC216152EB93C851C6051E", hash_generated_method = "D617DA3ED61164B80A6DACF259212635")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean isTerminated() {
            boolean var6E4612614060DC815BDD3E4518A67800_181297721 = (e.isTerminated());
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return e.isTerminated();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.658 -0400", hash_original_method = "7B27D3C16A1D302AD16E181EBB018DAC", hash_generated_method = "7FF0A310022F1ECED3D2C32EF5E296B5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
            dsTaint.addTaint(unit.dsTaint);
            dsTaint.addTaint(timeout);
            boolean var20413AB9E53FCD248F27D8E43F3504BD_1541001049 = (e.awaitTermination(timeout, unit));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return e.awaitTermination(timeout, unit);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.660 -0400", hash_original_method = "70A4BA700942918290F358C98B70C3C4", hash_generated_method = "8437961E6236AB178C9726401B355605")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Future<?> submit(Runnable task) {
            dsTaint.addTaint(task.dsTaint);
            Future<?> var4D3DE64B26B9CCB88467461A11CA0AD7_626701065 = (e.submit(task));
            return (Future<?>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return e.submit(task);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.662 -0400", hash_original_method = "83E0E20FEE789D6C0B6E1A8BE258D9AC", hash_generated_method = "18F4E26F6165246A0AD20FD30E096F5E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public <T> Future<T> submit(Callable<T> task) {
            dsTaint.addTaint(task.dsTaint);
            Future<T> var4D3DE64B26B9CCB88467461A11CA0AD7_1418573793 = (e.submit(task));
            return (Future<T>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return e.submit(task);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.663 -0400", hash_original_method = "7C597CCD4131D2329D010B8EED3AD866", hash_generated_method = "CB6E9068B7ABC66F65ED660E15DE4483")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public <T> Future<T> submit(Runnable task, T result) {
            dsTaint.addTaint(result.dsTaint);
            dsTaint.addTaint(task.dsTaint);
            Future<T> varDA15F8DE10514ED30B98ADAA2EDC3AB7_1750930818 = (e.submit(task, result));
            return (Future<T>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return e.submit(task, result);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.665 -0400", hash_original_method = "F48A0D0A4C3710017B7673C8DB7925EC", hash_generated_method = "B2A1461C1AC791F82D52D56F7A682464")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
            dsTaint.addTaint(tasks.dsTaint);
            List<Future<T>> var1C13705CA4DD085B05324AF5E7DE96D9_1709351209 = (e.invokeAll(tasks));
            return (List<Future<T>>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return e.invokeAll(tasks);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.668 -0400", hash_original_method = "5F911CE685489301A15E24D766797016", hash_generated_method = "E85A9EA436CFC04006FDBCF3B31AE173")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks,
                                             long timeout, TimeUnit unit) throws InterruptedException {
            dsTaint.addTaint(unit.dsTaint);
            dsTaint.addTaint(tasks.dsTaint);
            dsTaint.addTaint(timeout);
            List<Future<T>> var24AC2E47C00CE77B69A5F18E2A5833D7_638797155 = (e.invokeAll(tasks, timeout, unit));
            return (List<Future<T>>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return e.invokeAll(tasks, timeout, unit);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.670 -0400", hash_original_method = "4C0A5FF3374B9876DAD3CF3A7DB4F9BC", hash_generated_method = "AC6072C4CBD870C88E9D097E9F0DDD30")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
            dsTaint.addTaint(tasks.dsTaint);
            T var2E0764D98D82FE057C8BE42C49BBE9DB_646036297 = (e.invokeAny(tasks));
            return (T)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return e.invokeAny(tasks);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.672 -0400", hash_original_method = "D15E2648AE9554DE3EDB2502DC3264EF", hash_generated_method = "5EE6A0121FE345C8EED67515D7908A06")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public <T> T invokeAny(Collection<? extends Callable<T>> tasks,
                               long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            dsTaint.addTaint(unit.dsTaint);
            dsTaint.addTaint(tasks.dsTaint);
            dsTaint.addTaint(timeout);
            T varD152C5F5BC2811FE88010BAFCFD80B6A_727764726 = (e.invokeAny(tasks, timeout, unit));
            return (T)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return e.invokeAny(tasks, timeout, unit);
        }

        
    }


    
    static class FinalizableDelegatedExecutorService extends DelegatedExecutorService {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.673 -0400", hash_original_method = "0BC6912A00A2948375A36BA345B953A1", hash_generated_method = "0930F83134C3A644A020FB31E70543B0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         FinalizableDelegatedExecutorService(ExecutorService executor) {
            super(executor);
            dsTaint.addTaint(executor.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.675 -0400", hash_original_method = "EFBA277C67FEFB15F281D1F7A5118361", hash_generated_method = "D162B94D2A00C2EAD006BACECBCC712E")
        @DSModeled(DSC.SAFE)
        protected void finalize() {
            super.shutdown();
            // ---------- Original Method ----------
            //super.shutdown();
        }

        
    }


    
    static class DelegatedScheduledExecutorService extends DelegatedExecutorService implements ScheduledExecutorService {
        private ScheduledExecutorService e;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.678 -0400", hash_original_method = "B9414E1A08721941535D3112D446A4F5", hash_generated_method = "6FDFE3DDEAE109FD77477FE555CCE4D1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         DelegatedScheduledExecutorService(ScheduledExecutorService executor) {
            super(executor);
            dsTaint.addTaint(executor.dsTaint);
            // ---------- Original Method ----------
            //e = executor;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.686 -0400", hash_original_method = "D790041C21C164D4B5FF50718A4BC1E6", hash_generated_method = "DFBF12289AEC0E68DA5C97E3B03CA031")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ScheduledFuture<?> schedule(Runnable command, long delay,  TimeUnit unit) {
            dsTaint.addTaint(unit.dsTaint);
            dsTaint.addTaint(command.dsTaint);
            dsTaint.addTaint(delay);
            ScheduledFuture<?> var13979FEBFABC2A2FD7221A291BDEE95E_867915042 = (e.schedule(command, delay, unit));
            return (ScheduledFuture<?>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return e.schedule(command, delay, unit);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.689 -0400", hash_original_method = "21B2A7EFB4EC4FCA85726955706F3411", hash_generated_method = "3C7CFC05359F08981EDFD8A63A24F89D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
            dsTaint.addTaint(unit.dsTaint);
            dsTaint.addTaint(callable.dsTaint);
            dsTaint.addTaint(delay);
            ScheduledFuture<V> varEEB0E012B2C6FFAFA94E210CEE258C7C_169660029 = (e.schedule(callable, delay, unit));
            return (ScheduledFuture<V>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return e.schedule(callable, delay, unit);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.691 -0400", hash_original_method = "913AC360688F049D7C1CA1D721236AC7", hash_generated_method = "BA1961E58138234343F9DAEE15B7F8FC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay,  long period, TimeUnit unit) {
            dsTaint.addTaint(unit.dsTaint);
            dsTaint.addTaint(initialDelay);
            dsTaint.addTaint(command.dsTaint);
            dsTaint.addTaint(period);
            ScheduledFuture<?> var0E4FB196D8706A279BC2A91999BA184C_1273274525 = (e.scheduleAtFixedRate(command, initialDelay, period, unit));
            return (ScheduledFuture<?>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return e.scheduleAtFixedRate(command, initialDelay, period, unit);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:36:27.694 -0400", hash_original_method = "6DC4F7F046861AD80936134D3479B23D", hash_generated_method = "A125A1E4BE92516525C04D7B0C3748D3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay,  long delay, TimeUnit unit) {
            dsTaint.addTaint(unit.dsTaint);
            dsTaint.addTaint(initialDelay);
            dsTaint.addTaint(command.dsTaint);
            dsTaint.addTaint(delay);
            ScheduledFuture<?> var23719CB537297917BAEC7C4EC90384B4_624007852 = (e.scheduleWithFixedDelay(command, initialDelay, delay, unit));
            return (ScheduledFuture<?>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return e.scheduleWithFixedDelay(command, initialDelay, delay, unit);
        }

        
    }


    
}


