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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.572 -0400", hash_original_method = "F4CB3C27487DF72857FE3507DC40AD75", hash_generated_method = "27F2BAE4FD286E326334A8739E3D4262")
    private  Executors() {
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.597 -0400", hash_original_field = "478F3A4C51824AD23CB50C1C60670C0F", hash_generated_field = "3B9DB014EA5583311EF52FFA01325C0E")

        Runnable task;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.597 -0400", hash_original_field = "B4A88417B3D0170D754C647C30B7216A", hash_generated_field = "8B901F4123EF91F350535EEC5A55F787")

        T result;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.597 -0400", hash_original_method = "39BEB710EA675D51CD733BCB993FC74E", hash_generated_method = "B66D71CB0E2F61493FC0C79EA7F2EE40")
          RunnableAdapter(Runnable task, T result) {
            this.task = task;
            this.result = result;
            // ---------- Original Method ----------
            //this.task = task;
            //this.result = result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.598 -0400", hash_original_method = "0255C7C18478A7E06F3D7DE61652A41C", hash_generated_method = "04138F976F36129E899169A98A479356")
        public T call() {
            T varB4EAC82CA7396A68D541C85D26508E83_645532174 = null; //Variable for return #1
            task.run();
            varB4EAC82CA7396A68D541C85D26508E83_645532174 = result;
            varB4EAC82CA7396A68D541C85D26508E83_645532174.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_645532174;
            // ---------- Original Method ----------
            //task.run();
            //return result;
        }

        
    }


    
    static final class PrivilegedCallable<T> implements Callable<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.598 -0400", hash_original_field = "478F3A4C51824AD23CB50C1C60670C0F", hash_generated_field = "CFBF2BD2CA84F7FFF876D42173005A51")

        private Callable<T> task;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.598 -0400", hash_original_field = "1673448EE7064C989D02579C534F6B66", hash_generated_field = "5E0BB9B3EC8D99479706D49A606F3BE8")

        private AccessControlContext acc;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.599 -0400", hash_original_method = "12C65A09BA65E906C8B3945E2B4DB442", hash_generated_method = "407881EAC3D9A4573DC5616AB923DB76")
          PrivilegedCallable(Callable<T> task) {
            this.task = task;
            this.acc = AccessController.getContext();
            // ---------- Original Method ----------
            //this.task = task;
            //this.acc = AccessController.getContext();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.622 -0400", hash_original_method = "9B84B0D9F1F9FF2095D253EA33535221", hash_generated_method = "35D7C84662223879BE2CF00AF70C0F8E")
        public T call() throws Exception {
            T varB4EAC82CA7396A68D541C85D26508E83_1485767305 = null; //Variable for return #1
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1485767305 = AccessController.doPrivileged(
                    new PrivilegedExceptionAction<T>() {
                        public T run() throws Exception {
                            return task.call();
                        }
                    }, acc);
            } //End block
            catch (PrivilegedActionException e)
            {
                if (DroidSafeAndroidRuntime.control) throw e.getException();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1485767305.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1485767305;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.622 -0400", hash_original_field = "478F3A4C51824AD23CB50C1C60670C0F", hash_generated_field = "CFBF2BD2CA84F7FFF876D42173005A51")

        private Callable<T> task;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.622 -0400", hash_original_field = "1673448EE7064C989D02579C534F6B66", hash_generated_field = "5E0BB9B3EC8D99479706D49A606F3BE8")

        private AccessControlContext acc;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.622 -0400", hash_original_field = "95BBC40CB7BBF40EBF7B825922894718", hash_generated_field = "F0BF273B591E278A790B33F9A1F9CEDB")

        private ClassLoader ccl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.623 -0400", hash_original_method = "A45AF0A17387712B1B0259CF7D85D2E1", hash_generated_method = "926912BCBE3158888A2CEA0053FAE53C")
          PrivilegedCallableUsingCurrentClassLoader(Callable<T> task) {
            SecurityManager sm;
            sm = System.getSecurityManager();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.726 -0400", hash_original_method = "083E1FD40613168D34C9FEEE9DFC0EBD", hash_generated_method = "1A1161733D65FC97F3917B956E007B8B")
        public T call() throws Exception {
            T varB4EAC82CA7396A68D541C85D26508E83_1787183513 = null; //Variable for return #1
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1787183513 = AccessController.doPrivileged(
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
                    }, acc);
            } //End block
            catch (PrivilegedActionException e)
            {
                if (DroidSafeAndroidRuntime.control) throw e.getException();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1787183513.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1787183513;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    static class DefaultThreadFactory implements ThreadFactory {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.727 -0400", hash_original_field = "DB0F6F37EBEB6EA09489124345AF2A45", hash_generated_field = "6F10AD05CE1F57FC2F4A5DF43A505F99")

        private ThreadGroup group;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.727 -0400", hash_original_field = "29DCC4905D6FB1DA2B7219093C787E49", hash_generated_field = "FC834C1CDDA76E03B061000A8FB13177")

        private AtomicInteger threadNumber = new AtomicInteger(1);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.728 -0400", hash_original_field = "4110ADAB8C8C67636BBEC549E9B73281", hash_generated_field = "2F76B01D831BB088ADF19AC1319DB54D")

        private String namePrefix;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.728 -0400", hash_original_method = "6C4DB34AB218BB8D6524A59E94717A2E", hash_generated_method = "A97E98CC6A9DCA4F4D0AEA26CD18D1F6")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.729 -0400", hash_original_method = "FA504429181C673B0F1001408D56C877", hash_generated_method = "667C353304CFE1FD7B71E7740797E11C")
        public Thread newThread(Runnable r) {
            Thread varB4EAC82CA7396A68D541C85D26508E83_37542164 = null; //Variable for return #1
            Thread t;
            t = new Thread(group, r,
                                  namePrefix + threadNumber.getAndIncrement(),
                                  0);
            {
                boolean varF7C18CDC40FE52729E732C3509DE30D5_1369066213 = (t.isDaemon());
                t.setDaemon(false);
            } //End collapsed parenthetic
            {
                boolean var79BB14B3C56BE9336B8108F98A5C5A41_1353369268 = (t.getPriority() != Thread.NORM_PRIORITY);
                t.setPriority(Thread.NORM_PRIORITY);
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_37542164 = t;
            addTaint(r.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_37542164.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_37542164;
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.730 -0400", hash_original_field = "8173E1475D6022921D6CE09AFFF974B7", hash_generated_field = "5A0893C8966417C7756225AAB82EED8B")

        private static AtomicInteger poolNumber = new AtomicInteger(1);
    }


    
    static class PrivilegedThreadFactory extends DefaultThreadFactory {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.730 -0400", hash_original_field = "1673448EE7064C989D02579C534F6B66", hash_generated_field = "5E0BB9B3EC8D99479706D49A606F3BE8")

        private AccessControlContext acc;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.730 -0400", hash_original_field = "95BBC40CB7BBF40EBF7B825922894718", hash_generated_field = "F0BF273B591E278A790B33F9A1F9CEDB")

        private ClassLoader ccl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.730 -0400", hash_original_method = "1637F6F8B2206F80B43C5E6A7CCBC9A4", hash_generated_method = "5826413C4321FC7E59BF30F85D515A56")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.731 -0400", hash_original_method = "0BB5C6FA3ECC4446695A9AB19E82A9A9", hash_generated_method = "0DF21FE396869A5777193DF9EDD01D50")
        public Thread newThread(final Runnable r) {
            Thread varB4EAC82CA7396A68D541C85D26508E83_1807692660 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1807692660 = super.newThread(new Runnable() {
                public void run() {
                    AccessController.doPrivileged(new PrivilegedAction<Void>() {
                        public Void run() {
                            Thread.currentThread().setContextClassLoader(ccl);
                            r.run();
                            return null;
                        }
                    }, acc);
                }
            });
            addTaint(r.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1807692660.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1807692660;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.731 -0400", hash_original_field = "E1671797C52E15F763380B45E841EC32", hash_generated_field = "11B8F83ADD158AE4ADD1E7AA1252842D")

        private ExecutorService e;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.731 -0400", hash_original_method = "69B8656E71D4B49ACEB9CE44B20A63F5", hash_generated_method = "FF9F28349FB8E5F20D2028CD89D51AA0")
          DelegatedExecutorService(ExecutorService executor) {
            e = executor;
            // ---------- Original Method ----------
            //e = executor;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.731 -0400", hash_original_method = "680CD1247FE9848C91F828B8B2655AA2", hash_generated_method = "5F7903F2121667E833BE4695A2135537")
        public void execute(Runnable command) {
            e.execute(command);
            addTaint(command.getTaint());
            // ---------- Original Method ----------
            //e.execute(command);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.731 -0400", hash_original_method = "AC5ABD61901BFC6045B0080105C55DDA", hash_generated_method = "870B34DC67E6CAF4D4CA22846B67BE5A")
        public void shutdown() {
            e.shutdown();
            // ---------- Original Method ----------
            //e.shutdown();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.732 -0400", hash_original_method = "96CCD300667A8693DD62C1833316B3E7", hash_generated_method = "85CA25231D00CF13B62598EDA4B4369E")
        public List<Runnable> shutdownNow() {
            List<Runnable> varB4EAC82CA7396A68D541C85D26508E83_790333557 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_790333557 = e.shutdownNow();
            varB4EAC82CA7396A68D541C85D26508E83_790333557.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_790333557;
            // ---------- Original Method ----------
            //return e.shutdownNow();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.732 -0400", hash_original_method = "6953493B1D30A903FCCDB4081BC753C6", hash_generated_method = "4ECD242B4FF5950363BC9E5A056D9E9A")
        public boolean isShutdown() {
            boolean var36CED742EFDAB0F6D9A92D25333E2306_902538380 = (e.isShutdown());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1788513710 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1788513710;
            // ---------- Original Method ----------
            //return e.isShutdown();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.732 -0400", hash_original_method = "BA72422211BC216152EB93C851C6051E", hash_generated_method = "0C758F4442236E0BCAFBD93527A689CB")
        public boolean isTerminated() {
            boolean var6E4612614060DC815BDD3E4518A67800_1782792026 = (e.isTerminated());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_474555615 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_474555615;
            // ---------- Original Method ----------
            //return e.isTerminated();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.734 -0400", hash_original_method = "7B27D3C16A1D302AD16E181EBB018DAC", hash_generated_method = "B55D80DCCA17ECD15FEC4EFFF6848223")
        public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
            boolean var20413AB9E53FCD248F27D8E43F3504BD_979177612 = (e.awaitTermination(timeout, unit));
            addTaint(timeout);
            addTaint(unit.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1950748939 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1950748939;
            // ---------- Original Method ----------
            //return e.awaitTermination(timeout, unit);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.735 -0400", hash_original_method = "70A4BA700942918290F358C98B70C3C4", hash_generated_method = "50FE91EB846AC0DD544D99AEBBB89327")
        public Future<?> submit(Runnable task) {
            Future<?> varB4EAC82CA7396A68D541C85D26508E83_1822294061 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1822294061 = e.submit(task);
            addTaint(task.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1822294061.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1822294061;
            // ---------- Original Method ----------
            //return e.submit(task);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.735 -0400", hash_original_method = "83E0E20FEE789D6C0B6E1A8BE258D9AC", hash_generated_method = "F36A10EA89E2C32B0E037AD8AEC59D8F")
        public <T> Future<T> submit(Callable<T> task) {
            Future<T> varB4EAC82CA7396A68D541C85D26508E83_2107075249 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2107075249 = e.submit(task);
            addTaint(task.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2107075249.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2107075249;
            // ---------- Original Method ----------
            //return e.submit(task);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.736 -0400", hash_original_method = "7C597CCD4131D2329D010B8EED3AD866", hash_generated_method = "D7689E3A884187123D0EC3068B3A43B3")
        public <T> Future<T> submit(Runnable task, T result) {
            Future<T> varB4EAC82CA7396A68D541C85D26508E83_1820067559 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1820067559 = e.submit(task, result);
            addTaint(task.getTaint());
            addTaint(result.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1820067559.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1820067559;
            // ---------- Original Method ----------
            //return e.submit(task, result);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.762 -0400", hash_original_method = "F48A0D0A4C3710017B7673C8DB7925EC", hash_generated_method = "4B1FBEC4483572D91ABCE485B322ACA0")
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
            List<Future<T>> varB4EAC82CA7396A68D541C85D26508E83_572225880 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_572225880 = e.invokeAll(tasks);
            addTaint(tasks.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_572225880.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_572225880;
            // ---------- Original Method ----------
            //return e.invokeAll(tasks);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.762 -0400", hash_original_method = "5F911CE685489301A15E24D766797016", hash_generated_method = "0F119334454BB2BD7DAB5111A129480C")
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks,
                                             long timeout, TimeUnit unit) throws InterruptedException {
            List<Future<T>> varB4EAC82CA7396A68D541C85D26508E83_580664287 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_580664287 = e.invokeAll(tasks, timeout, unit);
            addTaint(tasks.getTaint());
            addTaint(timeout);
            addTaint(unit.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_580664287.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_580664287;
            // ---------- Original Method ----------
            //return e.invokeAll(tasks, timeout, unit);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.763 -0400", hash_original_method = "4C0A5FF3374B9876DAD3CF3A7DB4F9BC", hash_generated_method = "8D5E6D15206894E14501F499A9AE1FE8")
        public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
            T varB4EAC82CA7396A68D541C85D26508E83_1560009249 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1560009249 = e.invokeAny(tasks);
            addTaint(tasks.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1560009249.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1560009249;
            // ---------- Original Method ----------
            //return e.invokeAny(tasks);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.763 -0400", hash_original_method = "D15E2648AE9554DE3EDB2502DC3264EF", hash_generated_method = "5AE8F0349C7D36A53A106230B1F2A022")
        public <T> T invokeAny(Collection<? extends Callable<T>> tasks,
                               long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            T varB4EAC82CA7396A68D541C85D26508E83_1042497129 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1042497129 = e.invokeAny(tasks, timeout, unit);
            addTaint(tasks.getTaint());
            addTaint(timeout);
            addTaint(unit.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1042497129.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1042497129;
            // ---------- Original Method ----------
            //return e.invokeAny(tasks, timeout, unit);
        }

        
    }


    
    static class FinalizableDelegatedExecutorService extends DelegatedExecutorService {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.764 -0400", hash_original_method = "0BC6912A00A2948375A36BA345B953A1", hash_generated_method = "0427AB51E917327C91B17605314F9B9B")
          FinalizableDelegatedExecutorService(ExecutorService executor) {
            super(executor);
            addTaint(executor.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.764 -0400", hash_original_method = "EFBA277C67FEFB15F281D1F7A5118361", hash_generated_method = "75FB1DC5FB180CA67655AFF259FD4832")
        protected void finalize() {
            super.shutdown();
            // ---------- Original Method ----------
            //super.shutdown();
        }

        
    }


    
    static class DelegatedScheduledExecutorService extends DelegatedExecutorService implements ScheduledExecutorService {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.764 -0400", hash_original_field = "E1671797C52E15F763380B45E841EC32", hash_generated_field = "3D78CFB93E5EA21FD7B6DC753DB36818")

        private ScheduledExecutorService e;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.764 -0400", hash_original_method = "B9414E1A08721941535D3112D446A4F5", hash_generated_method = "88B596860003D7EDE125C8F0F2905303")
          DelegatedScheduledExecutorService(ScheduledExecutorService executor) {
            super(executor);
            e = executor;
            // ---------- Original Method ----------
            //e = executor;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.772 -0400", hash_original_method = "D790041C21C164D4B5FF50718A4BC1E6", hash_generated_method = "E35A17EE3DA4C322A229C7A588DEE784")
        public ScheduledFuture<?> schedule(Runnable command, long delay,  TimeUnit unit) {
            ScheduledFuture<?> varB4EAC82CA7396A68D541C85D26508E83_761231432 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_761231432 = e.schedule(command, delay, unit);
            addTaint(command.getTaint());
            addTaint(delay);
            addTaint(unit.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_761231432.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_761231432;
            // ---------- Original Method ----------
            //return e.schedule(command, delay, unit);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.777 -0400", hash_original_method = "21B2A7EFB4EC4FCA85726955706F3411", hash_generated_method = "C2C2F87C7EE2E04DFBFD8D8AC1F4487B")
        public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
            ScheduledFuture<V> varB4EAC82CA7396A68D541C85D26508E83_31143757 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_31143757 = e.schedule(callable, delay, unit);
            addTaint(callable.getTaint());
            addTaint(delay);
            addTaint(unit.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_31143757.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_31143757;
            // ---------- Original Method ----------
            //return e.schedule(callable, delay, unit);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.778 -0400", hash_original_method = "913AC360688F049D7C1CA1D721236AC7", hash_generated_method = "7C7DE13D0F73166911288DC7BBF541DC")
        public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay,  long period, TimeUnit unit) {
            ScheduledFuture<?> varB4EAC82CA7396A68D541C85D26508E83_103931674 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_103931674 = e.scheduleAtFixedRate(command, initialDelay, period, unit);
            addTaint(command.getTaint());
            addTaint(initialDelay);
            addTaint(period);
            addTaint(unit.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_103931674.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_103931674;
            // ---------- Original Method ----------
            //return e.scheduleAtFixedRate(command, initialDelay, period, unit);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.779 -0400", hash_original_method = "6DC4F7F046861AD80936134D3479B23D", hash_generated_method = "39283B4DC28634D5576F69AEE33B13B8")
        public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay,  long delay, TimeUnit unit) {
            ScheduledFuture<?> varB4EAC82CA7396A68D541C85D26508E83_532443784 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_532443784 = e.scheduleWithFixedDelay(command, initialDelay, delay, unit);
            addTaint(command.getTaint());
            addTaint(initialDelay);
            addTaint(delay);
            addTaint(unit.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_532443784.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_532443784;
            // ---------- Original Method ----------
            //return e.scheduleWithFixedDelay(command, initialDelay, delay, unit);
        }

        
    }


    
}

