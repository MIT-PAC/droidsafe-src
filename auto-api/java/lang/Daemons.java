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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.908 -0400", hash_original_method = "12604031794E0E37BA5BBC4D434861F1", hash_generated_method = "12604031794E0E37BA5BBC4D434861F1")
    public Daemons ()
    {
        //Synthesized constructor
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.909 -0400", hash_original_field = "DC127F5D2483352FD20EADDB38FEB6D2", hash_generated_field = "3B3F78C77D023C4AC9933B933AD9AFEC")

        private Thread thread;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.909 -0400", hash_original_method = "E956A3D7836B08A486122F00857B9C56", hash_generated_method = "E956A3D7836B08A486122F00857B9C56")
        public Daemon ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.909 -0400", hash_original_method = "BFB12BB46815FEE0BC693DC0650B4AEF", hash_generated_method = "D1B7C32EEBB5CBD1CDD8A6AF6B9872FB")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.910 -0400", hash_original_method = "DAD25559614D18C95C6D7AD3A5FF9D6E", hash_generated_method = "FEF7BFC80693958320B124FC53E51EEB")
        protected synchronized boolean isRunning() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_467039261 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_467039261;
            // ---------- Original Method ----------
            //return thread != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.910 -0400", hash_original_method = "87D921900F5E002E9B0AB652C178420C", hash_generated_method = "27B8EE26DCF234A1C89D52B6990A77A8")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.910 -0400", hash_original_method = "26FE25A9A5C4B7C9ED7155D7450987C1", hash_generated_method = "3773FF745E767DE2419DDBB071A5FE1D")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.911 -0400", hash_original_method = "71D841FC79E6E388CBA40EED62E5BA4E", hash_generated_method = "D1F368CD8B044565F0606E1C48F57DD6")
        public synchronized StackTraceElement[] getStackTrace() {
            StackTraceElement[] varB4EAC82CA7396A68D541C85D26508E83_1625839043 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1625839043 = thread != null ? thread.getStackTrace() : EmptyArray.STACK_TRACE_ELEMENT;
            varB4EAC82CA7396A68D541C85D26508E83_1625839043.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1625839043;
            // ---------- Original Method ----------
            //return thread != null ? thread.getStackTrace() : EmptyArray.STACK_TRACE_ELEMENT;
        }

        
    }


    
    private static class ReferenceQueueDaemon extends Daemon {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.911 -0400", hash_original_method = "CD631EFADB4142F64B0E6D0342597BAC", hash_generated_method = "CD631EFADB4142F64B0E6D0342597BAC")
        public ReferenceQueueDaemon ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.912 -0400", hash_original_method = "16C06FBAF3631080CE709DA6BD6140A9", hash_generated_method = "14F78DE7A93FE1A91FAB249AAD36B1C1")
        @Override
        public void run() {
            {
                boolean varC4B3EF749887CF146FD60924F3630457_971481185 = (isRunning());
                {
                    Reference<?> list = null;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.913 -0400", hash_original_method = "0570BE5ED95D81092ACBC3B5B723C1BE", hash_generated_method = "84A7F1AFAD840BF764A7467BBBBAB1EF")
        private void enqueue(Reference<?> list) {
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
            addTaint(list.getTaint());
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.913 -0400", hash_original_field = "5650660E20B53883AE4489C1195AA841", hash_generated_field = "C275CE9279DB140FF5DBBF91CA644933")

        private static final ReferenceQueueDaemon INSTANCE = new ReferenceQueueDaemon();
    }


    
    private static class FinalizerDaemon extends Daemon {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.913 -0400", hash_original_field = "4B4A54D76D30CD0234D169C4531A2DD6", hash_generated_field = "A531B66CCCD67B32A728191891E2B401")

        private final ReferenceQueue<Object> queue = FinalizerReference.queue;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.913 -0400", hash_original_field = "701768BB7ADB1CB2751C9C863BA6D59D", hash_generated_field = "4F48F43C1EA34CA35E4F2B48487C2292")

        private volatile Object finalizingObject;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.913 -0400", hash_original_field = "B1777B42F737CBCB0DCE53521B3D003E", hash_generated_field = "6FF12A6336A3541467350E5F1F9250E6")

        private volatile long finalizingStartedNanos;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.913 -0400", hash_original_method = "4CAA35D6DE3500E449D08F039EDA298E", hash_generated_method = "4CAA35D6DE3500E449D08F039EDA298E")
        public FinalizerDaemon ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.913 -0400", hash_original_method = "C183E2A6A7B3ED28464B9D0F97F171B5", hash_generated_method = "2B0020441DFC8B79D50258602187352A")
        @Override
        public void run() {
            {
                boolean varC4B3EF749887CF146FD60924F3630457_1799091402 = (isRunning());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.914 -0400", hash_original_method = "BF4896400D2910C88936D4B81319EC1C", hash_generated_method = "5B7D58A852355FB9E2041E4D545358FE")
        @FindBugsSuppressWarnings("FI_EXPLICIT_INVOCATION")
        private void doFinalize(FinalizerReference<?> reference) {
            FinalizerReference.remove(reference);
            Object object = reference.get();
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
            addTaint(reference.getTaint());
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.914 -0400", hash_original_field = "F3CD5CFCB43A075A403BBAF9D101689C", hash_generated_field = "420894E7A6688AFF48001D45B60EC731")

        private static final FinalizerDaemon INSTANCE = new FinalizerDaemon();
    }


    
    private static class FinalizerWatchdogDaemon extends Daemon {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.914 -0400", hash_original_method = "703968011540BAA8269C6E22457DD3B1", hash_generated_method = "703968011540BAA8269C6E22457DD3B1")
        public FinalizerWatchdogDaemon ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.915 -0400", hash_original_method = "0D26D8241DE84FB86F73D585D59D0B9C", hash_generated_method = "555BA8D392291470E9197C4E884902FA")
        @Override
        public void run() {
            {
                boolean varC4B3EF749887CF146FD60924F3630457_1920629481 = (isRunning());
                {
                    Object object = FinalizerDaemon.INSTANCE.finalizingObject;
                    long startedNanos = FinalizerDaemon.INSTANCE.finalizingStartedNanos;
                    long sleepMillis = MAX_FINALIZE_MILLIS;
                    {
                        long elapsedMillis = (System.nanoTime() - startedNanos) / NANOS_PER_MILLI;
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
                        boolean var68D19C7C3B190184EF9D4D6C9275C8D8_491038238 = (object == null
                        || object != FinalizerDaemon.INSTANCE.finalizingObject
                        || VMRuntime.getRuntime().isDebuggerActive());
                    } //End collapsed parenthetic
                    long elapsedMillis = (System.nanoTime() - startedNanos) / NANOS_PER_MILLI;
                    Exception syntheticException = new TimeoutException();
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.915 -0400", hash_original_field = "875E76F0367FD406AB3EACA1D853D3E1", hash_generated_field = "6FC68EE84E3EFE1A4A91B7713085F78F")

        private static final FinalizerWatchdogDaemon INSTANCE = new FinalizerWatchdogDaemon();
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.915 -0400", hash_original_field = "90F159E16A269B6F875D096F21ED865D", hash_generated_field = "E32D593DEDB2FDC7FE0DFB7474352DBA")

    private static final int NANOS_PER_MILLI = 1000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.915 -0400", hash_original_field = "7E70092D9C82948944E1EEE8DBEBD35E", hash_generated_field = "338AD99210C288DAC8FF0ED003934C14")

    private static final long MAX_FINALIZE_MILLIS = 10L * 1000L;
}

