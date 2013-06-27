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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.625 -0400", hash_original_method = "F4CB3C27487DF72857FE3507DC40AD75", hash_generated_method = "27F2BAE4FD286E326334A8739E3D4262")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.628 -0400", hash_original_field = "478F3A4C51824AD23CB50C1C60670C0F", hash_generated_field = "3B9DB014EA5583311EF52FFA01325C0E")

        Runnable task;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.628 -0400", hash_original_field = "B4A88417B3D0170D754C647C30B7216A", hash_generated_field = "8B901F4123EF91F350535EEC5A55F787")

        T result;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.630 -0400", hash_original_method = "39BEB710EA675D51CD733BCB993FC74E", hash_generated_method = "B66D71CB0E2F61493FC0C79EA7F2EE40")
          RunnableAdapter(Runnable task, T result) {
            this.task = task;
            this.result = result;
            // ---------- Original Method ----------
            //this.task = task;
            //this.result = result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.631 -0400", hash_original_method = "0255C7C18478A7E06F3D7DE61652A41C", hash_generated_method = "9E8717EA0D302260422520FF626FE41B")
        public T call() {
            T varB4EAC82CA7396A68D541C85D26508E83_1532639392 = null; //Variable for return #1
            task.run();
            varB4EAC82CA7396A68D541C85D26508E83_1532639392 = result;
            varB4EAC82CA7396A68D541C85D26508E83_1532639392.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1532639392;
            // ---------- Original Method ----------
            //task.run();
            //return result;
        }

        
    }


    
    static final class PrivilegedCallable<T> implements Callable<T> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.631 -0400", hash_original_field = "478F3A4C51824AD23CB50C1C60670C0F", hash_generated_field = "CFBF2BD2CA84F7FFF876D42173005A51")

        private Callable<T> task;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.631 -0400", hash_original_field = "1673448EE7064C989D02579C534F6B66", hash_generated_field = "5E0BB9B3EC8D99479706D49A606F3BE8")

        private AccessControlContext acc;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.631 -0400", hash_original_method = "12C65A09BA65E906C8B3945E2B4DB442", hash_generated_method = "407881EAC3D9A4573DC5616AB923DB76")
          PrivilegedCallable(Callable<T> task) {
            this.task = task;
            this.acc = AccessController.getContext();
            // ---------- Original Method ----------
            //this.task = task;
            //this.acc = AccessController.getContext();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.632 -0400", hash_original_method = "9B84B0D9F1F9FF2095D253EA33535221", hash_generated_method = "A0C1AF08EB217F0C07DF2CEE51BBA626")
        public T call() throws Exception {
            T varB4EAC82CA7396A68D541C85D26508E83_1860490857 = null; //Variable for return #1
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1860490857 = AccessController.doPrivileged(
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
            varB4EAC82CA7396A68D541C85D26508E83_1860490857.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1860490857;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.632 -0400", hash_original_field = "478F3A4C51824AD23CB50C1C60670C0F", hash_generated_field = "CFBF2BD2CA84F7FFF876D42173005A51")

        private Callable<T> task;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.632 -0400", hash_original_field = "1673448EE7064C989D02579C534F6B66", hash_generated_field = "5E0BB9B3EC8D99479706D49A606F3BE8")

        private AccessControlContext acc;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.632 -0400", hash_original_field = "95BBC40CB7BBF40EBF7B825922894718", hash_generated_field = "F0BF273B591E278A790B33F9A1F9CEDB")

        private ClassLoader ccl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.633 -0400", hash_original_method = "A45AF0A17387712B1B0259CF7D85D2E1", hash_generated_method = "926912BCBE3158888A2CEA0053FAE53C")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.634 -0400", hash_original_method = "083E1FD40613168D34C9FEEE9DFC0EBD", hash_generated_method = "CAB20CB53E4B2E93401F9A3912104605")
        public T call() throws Exception {
            T varB4EAC82CA7396A68D541C85D26508E83_2125081537 = null; //Variable for return #1
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_2125081537 = AccessController.doPrivileged(
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
            varB4EAC82CA7396A68D541C85D26508E83_2125081537.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2125081537;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    static class DefaultThreadFactory implements ThreadFactory {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.634 -0400", hash_original_field = "DB0F6F37EBEB6EA09489124345AF2A45", hash_generated_field = "6F10AD05CE1F57FC2F4A5DF43A505F99")

        private ThreadGroup group;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.634 -0400", hash_original_field = "29DCC4905D6FB1DA2B7219093C787E49", hash_generated_field = "FC834C1CDDA76E03B061000A8FB13177")

        private AtomicInteger threadNumber = new AtomicInteger(1);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.634 -0400", hash_original_field = "4110ADAB8C8C67636BBEC549E9B73281", hash_generated_field = "2F76B01D831BB088ADF19AC1319DB54D")

        private String namePrefix;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.634 -0400", hash_original_method = "6C4DB34AB218BB8D6524A59E94717A2E", hash_generated_method = "A97E98CC6A9DCA4F4D0AEA26CD18D1F6")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.648 -0400", hash_original_method = "FA504429181C673B0F1001408D56C877", hash_generated_method = "DE00A1385EEE35CDC1BE3AFBF4F5C2AF")
        public Thread newThread(Runnable r) {
            Thread varB4EAC82CA7396A68D541C85D26508E83_1434963860 = null; //Variable for return #1
            Thread t;
            t = new Thread(group, r,
                                  namePrefix + threadNumber.getAndIncrement(),
                                  0);
            {
                boolean varF7C18CDC40FE52729E732C3509DE30D5_388404314 = (t.isDaemon());
                t.setDaemon(false);
            } //End collapsed parenthetic
            {
                boolean var79BB14B3C56BE9336B8108F98A5C5A41_1246566835 = (t.getPriority() != Thread.NORM_PRIORITY);
                t.setPriority(Thread.NORM_PRIORITY);
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1434963860 = t;
            addTaint(r.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1434963860.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1434963860;
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.648 -0400", hash_original_field = "8173E1475D6022921D6CE09AFFF974B7", hash_generated_field = "5A0893C8966417C7756225AAB82EED8B")

        private static AtomicInteger poolNumber = new AtomicInteger(1);
    }


    
    static class PrivilegedThreadFactory extends DefaultThreadFactory {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.648 -0400", hash_original_field = "1673448EE7064C989D02579C534F6B66", hash_generated_field = "5E0BB9B3EC8D99479706D49A606F3BE8")

        private AccessControlContext acc;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.648 -0400", hash_original_field = "95BBC40CB7BBF40EBF7B825922894718", hash_generated_field = "F0BF273B591E278A790B33F9A1F9CEDB")

        private ClassLoader ccl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.649 -0400", hash_original_method = "1637F6F8B2206F80B43C5E6A7CCBC9A4", hash_generated_method = "5826413C4321FC7E59BF30F85D515A56")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.655 -0400", hash_original_method = "0BB5C6FA3ECC4446695A9AB19E82A9A9", hash_generated_method = "49A54293852BC57A47AFF63E9B03B088")
        public Thread newThread(final Runnable r) {
            Thread varB4EAC82CA7396A68D541C85D26508E83_667173734 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_667173734 = super.newThread(new Runnable() {
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
            varB4EAC82CA7396A68D541C85D26508E83_667173734.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_667173734;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.655 -0400", hash_original_field = "E1671797C52E15F763380B45E841EC32", hash_generated_field = "11B8F83ADD158AE4ADD1E7AA1252842D")

        private ExecutorService e;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.659 -0400", hash_original_method = "69B8656E71D4B49ACEB9CE44B20A63F5", hash_generated_method = "FF9F28349FB8E5F20D2028CD89D51AA0")
          DelegatedExecutorService(ExecutorService executor) {
            e = executor;
            // ---------- Original Method ----------
            //e = executor;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.660 -0400", hash_original_method = "680CD1247FE9848C91F828B8B2655AA2", hash_generated_method = "5F7903F2121667E833BE4695A2135537")
        public void execute(Runnable command) {
            e.execute(command);
            addTaint(command.getTaint());
            // ---------- Original Method ----------
            //e.execute(command);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.664 -0400", hash_original_method = "AC5ABD61901BFC6045B0080105C55DDA", hash_generated_method = "870B34DC67E6CAF4D4CA22846B67BE5A")
        public void shutdown() {
            e.shutdown();
            // ---------- Original Method ----------
            //e.shutdown();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.665 -0400", hash_original_method = "96CCD300667A8693DD62C1833316B3E7", hash_generated_method = "6764C71D516AB293F04E3052463A2E35")
        public List<Runnable> shutdownNow() {
            List<Runnable> varB4EAC82CA7396A68D541C85D26508E83_361710453 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_361710453 = e.shutdownNow();
            varB4EAC82CA7396A68D541C85D26508E83_361710453.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_361710453;
            // ---------- Original Method ----------
            //return e.shutdownNow();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.666 -0400", hash_original_method = "6953493B1D30A903FCCDB4081BC753C6", hash_generated_method = "BF0911C5062472596B9CE9426A01654B")
        public boolean isShutdown() {
            boolean var36CED742EFDAB0F6D9A92D25333E2306_1814991669 = (e.isShutdown());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1645129235 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1645129235;
            // ---------- Original Method ----------
            //return e.isShutdown();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.669 -0400", hash_original_method = "BA72422211BC216152EB93C851C6051E", hash_generated_method = "3BBCFE9340973D9188670D20734D77F8")
        public boolean isTerminated() {
            boolean var6E4612614060DC815BDD3E4518A67800_263606049 = (e.isTerminated());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_216472513 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_216472513;
            // ---------- Original Method ----------
            //return e.isTerminated();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.670 -0400", hash_original_method = "7B27D3C16A1D302AD16E181EBB018DAC", hash_generated_method = "C96C4BBFBC3C82ED873267508FD8734E")
        public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
            boolean var20413AB9E53FCD248F27D8E43F3504BD_1555492637 = (e.awaitTermination(timeout, unit));
            addTaint(timeout);
            addTaint(unit.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2116024057 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2116024057;
            // ---------- Original Method ----------
            //return e.awaitTermination(timeout, unit);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.686 -0400", hash_original_method = "70A4BA700942918290F358C98B70C3C4", hash_generated_method = "85BAA23F009CBF699AE1C9E8C570B60C")
        public Future<?> submit(Runnable task) {
            Future<?> varB4EAC82CA7396A68D541C85D26508E83_920210987 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_920210987 = e.submit(task);
            addTaint(task.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_920210987.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_920210987;
            // ---------- Original Method ----------
            //return e.submit(task);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.687 -0400", hash_original_method = "83E0E20FEE789D6C0B6E1A8BE258D9AC", hash_generated_method = "4CB6BCD9474A60651BED293E131933FF")
        public <T> Future<T> submit(Callable<T> task) {
            Future<T> varB4EAC82CA7396A68D541C85D26508E83_54426398 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_54426398 = e.submit(task);
            addTaint(task.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_54426398.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_54426398;
            // ---------- Original Method ----------
            //return e.submit(task);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.688 -0400", hash_original_method = "7C597CCD4131D2329D010B8EED3AD866", hash_generated_method = "BE741D2ADE6AB265865B723B7D42F845")
        public <T> Future<T> submit(Runnable task, T result) {
            Future<T> varB4EAC82CA7396A68D541C85D26508E83_783013400 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_783013400 = e.submit(task, result);
            addTaint(task.getTaint());
            addTaint(result.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_783013400.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_783013400;
            // ---------- Original Method ----------
            //return e.submit(task, result);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.688 -0400", hash_original_method = "F48A0D0A4C3710017B7673C8DB7925EC", hash_generated_method = "5AB94976C72097D86F6768F009F8ED66")
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
            List<Future<T>> varB4EAC82CA7396A68D541C85D26508E83_25020888 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_25020888 = e.invokeAll(tasks);
            addTaint(tasks.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_25020888.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_25020888;
            // ---------- Original Method ----------
            //return e.invokeAll(tasks);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.688 -0400", hash_original_method = "5F911CE685489301A15E24D766797016", hash_generated_method = "0806A4B8E2F821ACCF997842DA99ABD6")
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks,
                                             long timeout, TimeUnit unit) throws InterruptedException {
            List<Future<T>> varB4EAC82CA7396A68D541C85D26508E83_1011687954 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1011687954 = e.invokeAll(tasks, timeout, unit);
            addTaint(tasks.getTaint());
            addTaint(timeout);
            addTaint(unit.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1011687954.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1011687954;
            // ---------- Original Method ----------
            //return e.invokeAll(tasks, timeout, unit);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.693 -0400", hash_original_method = "4C0A5FF3374B9876DAD3CF3A7DB4F9BC", hash_generated_method = "73EE5F896EA990915F6C204A7E4916B8")
        public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
            T varB4EAC82CA7396A68D541C85D26508E83_1043014820 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1043014820 = e.invokeAny(tasks);
            addTaint(tasks.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1043014820.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1043014820;
            // ---------- Original Method ----------
            //return e.invokeAny(tasks);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.693 -0400", hash_original_method = "D15E2648AE9554DE3EDB2502DC3264EF", hash_generated_method = "06D53B7E3B5F0C4F2A830E1408849270")
        public <T> T invokeAny(Collection<? extends Callable<T>> tasks,
                               long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            T varB4EAC82CA7396A68D541C85D26508E83_1789060492 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1789060492 = e.invokeAny(tasks, timeout, unit);
            addTaint(tasks.getTaint());
            addTaint(timeout);
            addTaint(unit.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1789060492.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1789060492;
            // ---------- Original Method ----------
            //return e.invokeAny(tasks, timeout, unit);
        }

        
    }


    
    static class FinalizableDelegatedExecutorService extends DelegatedExecutorService {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.704 -0400", hash_original_method = "0BC6912A00A2948375A36BA345B953A1", hash_generated_method = "0427AB51E917327C91B17605314F9B9B")
          FinalizableDelegatedExecutorService(ExecutorService executor) {
            super(executor);
            addTaint(executor.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.704 -0400", hash_original_method = "EFBA277C67FEFB15F281D1F7A5118361", hash_generated_method = "75FB1DC5FB180CA67655AFF259FD4832")
        protected void finalize() {
            super.shutdown();
            // ---------- Original Method ----------
            //super.shutdown();
        }

        
    }


    
    static class DelegatedScheduledExecutorService extends DelegatedExecutorService implements ScheduledExecutorService {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.705 -0400", hash_original_field = "E1671797C52E15F763380B45E841EC32", hash_generated_field = "3D78CFB93E5EA21FD7B6DC753DB36818")

        private ScheduledExecutorService e;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.712 -0400", hash_original_method = "B9414E1A08721941535D3112D446A4F5", hash_generated_method = "88B596860003D7EDE125C8F0F2905303")
          DelegatedScheduledExecutorService(ScheduledExecutorService executor) {
            super(executor);
            e = executor;
            // ---------- Original Method ----------
            //e = executor;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.713 -0400", hash_original_method = "D790041C21C164D4B5FF50718A4BC1E6", hash_generated_method = "F50400339E5CC6A154FB4FFE47A63888")
        public ScheduledFuture<?> schedule(Runnable command, long delay,  TimeUnit unit) {
            ScheduledFuture<?> varB4EAC82CA7396A68D541C85D26508E83_151033959 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_151033959 = e.schedule(command, delay, unit);
            addTaint(command.getTaint());
            addTaint(delay);
            addTaint(unit.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_151033959.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_151033959;
            // ---------- Original Method ----------
            //return e.schedule(command, delay, unit);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.714 -0400", hash_original_method = "21B2A7EFB4EC4FCA85726955706F3411", hash_generated_method = "3378FA4E75BDED742207701285995061")
        public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
            ScheduledFuture<V> varB4EAC82CA7396A68D541C85D26508E83_1996709197 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1996709197 = e.schedule(callable, delay, unit);
            addTaint(callable.getTaint());
            addTaint(delay);
            addTaint(unit.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1996709197.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1996709197;
            // ---------- Original Method ----------
            //return e.schedule(callable, delay, unit);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.714 -0400", hash_original_method = "913AC360688F049D7C1CA1D721236AC7", hash_generated_method = "B3A134C4A5C9587D23C238D19DBCEA9F")
        public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay,  long period, TimeUnit unit) {
            ScheduledFuture<?> varB4EAC82CA7396A68D541C85D26508E83_1971485325 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1971485325 = e.scheduleAtFixedRate(command, initialDelay, period, unit);
            addTaint(command.getTaint());
            addTaint(initialDelay);
            addTaint(period);
            addTaint(unit.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1971485325.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1971485325;
            // ---------- Original Method ----------
            //return e.scheduleAtFixedRate(command, initialDelay, period, unit);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:57.721 -0400", hash_original_method = "6DC4F7F046861AD80936134D3479B23D", hash_generated_method = "25C4EF836E317D7E0CCBA77A5E24FCE9")
        public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay,  long delay, TimeUnit unit) {
            ScheduledFuture<?> varB4EAC82CA7396A68D541C85D26508E83_1051846647 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1051846647 = e.scheduleWithFixedDelay(command, initialDelay, delay, unit);
            addTaint(command.getTaint());
            addTaint(initialDelay);
            addTaint(delay);
            addTaint(unit.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1051846647.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1051846647;
            // ---------- Original Method ----------
            //return e.scheduleWithFixedDelay(command, initialDelay, delay, unit);
        }

        
    }


    
}

