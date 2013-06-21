package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import dalvik.system.VMRuntime;
import java.lang.ref.FinalizerReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeoutException;
import libcore.util.EmptyArray;

public final class Daemons {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.665 -0400", hash_original_method = "6EE1D3D3CD0B81CFA27759049D391561", hash_generated_method = "6EE1D3D3CD0B81CFA27759049D391561")
        public Daemons ()
    {
    }


        public static void start() {
        ReferenceQueueDaemon.INSTANCE.start();
        FinalizerDaemon.INSTANCE.start();
        FinalizerWatchdogDaemon.INSTANCE.start();
    }

    
        public static void stop() {
        ReferenceQueueDaemon.INSTANCE.stop();
        FinalizerDaemon.INSTANCE.stop();
        FinalizerWatchdogDaemon.INSTANCE.stop();
    }

    
    private static abstract class Daemon implements Runnable {
        private Thread thread;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.666 -0400", hash_original_method = "A88E7802739B3958277E95A83F913069", hash_generated_method = "A88E7802739B3958277E95A83F913069")
                public Daemon ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.666 -0400", hash_original_method = "BFB12BB46815FEE0BC693DC0650B4AEF", hash_generated_method = "D1B7C32EEBB5CBD1CDD8A6AF6B9872FB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public synchronized void start() {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("already running");
            } //End block
            thread = new Thread(this, getClass().getSimpleName());
            thread.setDaemon(true);
            thread.start();
            // ---------- Original Method ----------
            //if (thread != null) {
                //throw new IllegalStateException("already running");
            //}
            //thread = new Thread(this, getClass().getSimpleName());
            //thread.setDaemon(true);
            //thread.start();
        }

        
        public abstract void run();

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.666 -0400", hash_original_method = "DAD25559614D18C95C6D7AD3A5FF9D6E", hash_generated_method = "50778E85ACCEA111E5C648E96C50A4D0")
        @DSModeled(DSC.SAFE)
        protected synchronized boolean isRunning() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return thread != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.667 -0400", hash_original_method = "87D921900F5E002E9B0AB652C178420C", hash_generated_method = "27B8EE26DCF234A1C89D52B6990A77A8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public synchronized void interrupt() {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("not running");
            } //End block
            thread.interrupt();
            // ---------- Original Method ----------
            //if (thread == null) {
                //throw new IllegalStateException("not running");
            //}
            //thread.interrupt();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.667 -0400", hash_original_method = "26FE25A9A5C4B7C9ED7155D7450987C1", hash_generated_method = "3773FF745E767DE2419DDBB071A5FE1D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void stop() {
            Thread threadToStop;
            {
                threadToStop = thread;
                thread = null;
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("not running");
            } //End block
            threadToStop.interrupt();
            {
                try 
                {
                    threadToStop.join();
                } //End block
                catch (InterruptedException ignored)
                { }
            } //End block
            // ---------- Original Method ----------
            //Thread threadToStop;
            //synchronized (this) {
                //threadToStop = thread;
                //thread = null;
            //}
            //if (threadToStop == null) {
                //throw new IllegalStateException("not running");
            //}
            //threadToStop.interrupt();
            //while (true) {
                //try {
                    //threadToStop.join();
                    //return;
                //} catch (InterruptedException ignored) {
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.667 -0400", hash_original_method = "71D841FC79E6E388CBA40EED62E5BA4E", hash_generated_method = "190DD19C06DBA03393A110568990F567")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public synchronized StackTraceElement[] getStackTrace() {
            {
                Object var7C117FC58CEEFC4EC4FB699049DB4321_1648541485 = (thread.getStackTrace());
            } //End flattened ternary
            return (StackTraceElement[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return thread != null ? thread.getStackTrace() : EmptyArray.STACK_TRACE_ELEMENT;
        }

        
    }


    
    private static class ReferenceQueueDaemon extends Daemon {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.667 -0400", hash_original_method = "82172BC1EFA3A237D257702AE354C8DD", hash_generated_method = "82172BC1EFA3A237D257702AE354C8DD")
                public ReferenceQueueDaemon ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.667 -0400", hash_original_method = "16C06FBAF3631080CE709DA6BD6140A9", hash_generated_method = "5BF353FCA7D167778774204CA3B03ECF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void run() {
            {
                boolean varC4B3EF749887CF146FD60924F3630457_2036405337 = (isRunning());
                {
                    Reference<?> list;
                    try 
                    {
                        {
                            {
                                ReferenceQueue.class.wait();
                            } //End block
                            list = ReferenceQueue.unenqueued;
                            ReferenceQueue.unenqueued = null;
                        } //End block
                    } //End block
                    catch (InterruptedException e)
                    { }
                    enqueue(list);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //while (isRunning()) {
                //Reference<?> list;
                //try {
                    //synchronized (ReferenceQueue.class) {
                        //while (ReferenceQueue.unenqueued == null) {
                            //ReferenceQueue.class.wait();
                        //}
                        //list = ReferenceQueue.unenqueued;
                        //ReferenceQueue.unenqueued = null;
                    //}
                //} catch (InterruptedException e) {
                    //continue;
                //}
                //enqueue(list);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.668 -0400", hash_original_method = "0570BE5ED95D81092ACBC3B5B723C1BE", hash_generated_method = "DBDF730DD7F934A2C814F1468D146F40")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void enqueue(Reference<?> list) {
            dsTaint.addTaint(list.dsTaint);
            {
                Reference<?> reference;
                {
                    reference = list;
                    reference.pendingNext = null;
                    list = null;
                } //End block
                {
                    reference = list.pendingNext;
                    list.pendingNext = reference.pendingNext;
                    reference.pendingNext = null;
                } //End block
                reference.enqueueInternal();
            } //End block
            // ---------- Original Method ----------
            //while (list != null) {
                //Reference<?> reference;
                //if (list == list.pendingNext) {
                    //reference = list;
                    //reference.pendingNext = null;
                    //list = null;
                //} else {
                    //reference = list.pendingNext;
                    //list.pendingNext = reference.pendingNext;
                    //reference.pendingNext = null;
                //}
                //reference.enqueueInternal();
            //}
        }

        
        private static final ReferenceQueueDaemon INSTANCE = new ReferenceQueueDaemon();
    }


    
    private static class FinalizerDaemon extends Daemon {
        private ReferenceQueue<Object> queue = FinalizerReference.queue;
        private volatile Object finalizingObject;
        private volatile long finalizingStartedNanos;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.668 -0400", hash_original_method = "35F3CB8B6ADE77580067E8C57E164A43", hash_generated_method = "35F3CB8B6ADE77580067E8C57E164A43")
                public FinalizerDaemon ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.668 -0400", hash_original_method = "C183E2A6A7B3ED28464B9D0F97F171B5", hash_generated_method = "658E69B22286D5ABEE5247C43C722541")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void run() {
            {
                boolean varC4B3EF749887CF146FD60924F3630457_763504882 = (isRunning());
                {
                    try 
                    {
                        doFinalize((FinalizerReference<?>) queue.remove());
                    } //End block
                    catch (InterruptedException ignored)
                    { }
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //while (isRunning()) {
                //try {
                    //doFinalize((FinalizerReference<?>) queue.remove());
                //} catch (InterruptedException ignored) {
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.668 -0400", hash_original_method = "BF4896400D2910C88936D4B81319EC1C", hash_generated_method = "B021827C3F816F4795256ECBDE301963")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @FindBugsSuppressWarnings("FI_EXPLICIT_INVOCATION")
        private void doFinalize(FinalizerReference<?> reference) {
            dsTaint.addTaint(reference.dsTaint);
            FinalizerReference.remove(reference);
            Object object;
            object = reference.get();
            reference.clear();
            try 
            {
                finalizingStartedNanos = System.nanoTime();
                finalizingObject = object;
                object.finalize();
            } //End block
            catch (Throwable ex)
            {
                System.logE("Uncaught exception thrown by finalizer", ex);
            } //End block
            finally 
            {
                finalizingObject = null;
            } //End block
            // ---------- Original Method ----------
            //FinalizerReference.remove(reference);
            //Object object = reference.get();
            //reference.clear();
            //try {
                //finalizingStartedNanos = System.nanoTime();
                //finalizingObject = object;
                //object.finalize();
            //} catch (Throwable ex) {
                //System.logE("Uncaught exception thrown by finalizer", ex);
            //} finally {
                //finalizingObject = null;
            //}
        }

        
        private static final FinalizerDaemon INSTANCE = new FinalizerDaemon();
    }


    
    private static class FinalizerWatchdogDaemon extends Daemon {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.668 -0400", hash_original_method = "B03DF6E824102CC8FDA489F9DB31B37E", hash_generated_method = "B03DF6E824102CC8FDA489F9DB31B37E")
                public FinalizerWatchdogDaemon ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.669 -0400", hash_original_method = "0D26D8241DE84FB86F73D585D59D0B9C", hash_generated_method = "561AD29BED78B78B042AFC05FC967EE0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void run() {
            {
                boolean varC4B3EF749887CF146FD60924F3630457_1580202586 = (isRunning());
                {
                    Object object;
                    object = FinalizerDaemon.INSTANCE.finalizingObject;
                    long startedNanos;
                    startedNanos = FinalizerDaemon.INSTANCE.finalizingStartedNanos;
                    long sleepMillis;
                    sleepMillis = MAX_FINALIZE_MILLIS;
                    {
                        long elapsedMillis;
                        elapsedMillis = (System.nanoTime() - startedNanos) / NANOS_PER_MILLI;
                        sleepMillis -= elapsedMillis;
                    } //End block
                    {
                        try 
                        {
                            Thread.sleep(sleepMillis);
                        } //End block
                        catch (InterruptedException e)
                        { }
                    } //End block
                    {
                        boolean var68D19C7C3B190184EF9D4D6C9275C8D8_1438711625 = (object == null
                        || object != FinalizerDaemon.INSTANCE.finalizingObject
                        || VMRuntime.getRuntime().isDebuggerActive());
                    } //End collapsed parenthetic
                    long elapsedMillis;
                    elapsedMillis = (System.nanoTime() - startedNanos) / NANOS_PER_MILLI;
                    Exception syntheticException;
                    syntheticException = new TimeoutException();
                    syntheticException.setStackTrace(FinalizerDaemon.INSTANCE.getStackTrace());
                    System.logE(object.getClass().getName() + ".finalize() timed out after "
                        + elapsedMillis + " ms; limit is " + MAX_FINALIZE_MILLIS + " ms",
                        syntheticException);
                    System.exit(2);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        private static final FinalizerWatchdogDaemon INSTANCE = new FinalizerWatchdogDaemon();
    }


    
    private static final int NANOS_PER_MILLI = 1000000;
    private static final long MAX_FINALIZE_MILLIS = 10L * 1000L;
}

