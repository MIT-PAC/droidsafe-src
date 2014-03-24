package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.ref.FinalizerReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeoutException;

import libcore.util.EmptyArray;
import dalvik.system.VMRuntime;

public final class Daemons { // 10 seconds

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.197 -0500", hash_original_method = "96A953FF88701F6481E522FC8FA197D7", hash_generated_method = "2395E1790BBF4FC36EFA3ECFEA4E2E25")
    
public static void start() {
        ReferenceQueueDaemon.INSTANCE.start();
        FinalizerDaemon.INSTANCE.start();
        FinalizerWatchdogDaemon.INSTANCE.start();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.199 -0500", hash_original_method = "01FE43DD1B18473A1B4EAB38BEF5123E", hash_generated_method = "EF7B44655E1B56080C1DDD6B9D887AE4")
    
public static void stop() {
        ReferenceQueueDaemon.INSTANCE.stop();
        FinalizerDaemon.INSTANCE.stop();
        FinalizerWatchdogDaemon.INSTANCE.stop();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.191 -0500", hash_original_field = "5FC7F9392DE523EE635F94A39030F4C7", hash_generated_field = "E32D593DEDB2FDC7FE0DFB7474352DBA")

    private static final int NANOS_PER_MILLI = 1000000;
    
    private static abstract class Daemon implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.203 -0500", hash_original_field = "AB87C4F6E5547EBD7483F34732EA576D", hash_generated_field = "3B3F78C77D023C4AC9933B933AD9AFEC")

        private Thread thread;
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.802 -0400", hash_original_method = "E956A3D7836B08A486122F00857B9C56", hash_generated_method = "E956A3D7836B08A486122F00857B9C56")
        public Daemon ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.205 -0500", hash_original_method = "BFB12BB46815FEE0BC693DC0650B4AEF", hash_generated_method = "50AC94AAD67F31C694C0D4B0E3B5C163")
        
public synchronized void start() {
            if (thread != null) {
                throw new IllegalStateException("already running");
            }
            thread = new Thread(this, getClass().getSimpleName());
            thread.setDaemon(true);
            thread.start();
        }

        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.208 -0500", hash_original_method = "2C6A443C83148E86AAD705D9EE784F75", hash_generated_method = "5BBE1BCB74D1FAFBB58FE7F038D48F66")
        
public abstract void run();

        /**
         * Returns true while the current thread should continue to run; false
         * when it should return.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.211 -0500", hash_original_method = "DAD25559614D18C95C6D7AD3A5FF9D6E", hash_generated_method = "8B7294982D4EEACFF88A4080ED0EA4C4")
        
protected synchronized boolean isRunning() {
            if (thread != null)
                return thread.getTaintBoolean();
            return getTaintBoolean();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.214 -0500", hash_original_method = "87D921900F5E002E9B0AB652C178420C", hash_generated_method = "0D5FBDB54D594FDB7E4154CC30D14C2A")
        
public synchronized void interrupt() {
            if (thread == null) {
                throw new IllegalStateException("not running");
            }
            thread.interrupt();
        }

        /**
         * Waits for the runtime thread to stop. This interrupts the thread
         * currently running the runnable and then waits for it to exit.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.217 -0500", hash_original_method = "26FE25A9A5C4B7C9ED7155D7450987C1", hash_generated_method = "D83001AE4C2ABC96E6B836B265860449")
        
public void stop() {
            Thread threadToStop;
            synchronized (this) {
                threadToStop = thread;
                thread = null;
            }
            if (threadToStop == null) {
                throw new IllegalStateException("not running");
            }
            threadToStop.interrupt();
            while (true) {
                try {
                    threadToStop.join();
                    return;
                } catch (InterruptedException ignored) {
                }
            }
        }

        /**
         * Returns the current stack trace of the thread, or an empty stack trace
         * if the thread is not currently running.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.219 -0500", hash_original_method = "71D841FC79E6E388CBA40EED62E5BA4E", hash_generated_method = "105C2CE68BDD769E05A16DDB9C0E0A27")
        
public synchronized StackTraceElement[] getStackTrace() {
            return thread != null ? thread.getStackTrace() : EmptyArray.STACK_TRACE_ELEMENT;
        }
        
    }
    
    private static class ReferenceQueueDaemon extends Daemon {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.225 -0500", hash_original_field = "B0F27D05C2E84AEB476CFD29B14CB3E0", hash_generated_field = "C275CE9279DB140FF5DBBF91CA644933")

        private static final ReferenceQueueDaemon INSTANCE = new ReferenceQueueDaemon();
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.824 -0400", hash_original_method = "CD631EFADB4142F64B0E6D0342597BAC", hash_generated_method = "CD631EFADB4142F64B0E6D0342597BAC")
        public ReferenceQueueDaemon ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.229 -0500", hash_original_method = "16C06FBAF3631080CE709DA6BD6140A9", hash_generated_method = "BB50CA5A56634F733BDC6409BC634E9F")
        
@Override public void run() {
            while (isRunning()) {
                Reference<?> list;
                try {
                    synchronized (ReferenceQueue.class) {
                        while (ReferenceQueue.unenqueued == null) {
                            ReferenceQueue.class.wait();
                        }
                        list = ReferenceQueue.unenqueued;
                        ReferenceQueue.unenqueued = null;
                    }
                } catch (InterruptedException e) {
                    continue;
                }
                enqueue(list);
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.232 -0500", hash_original_method = "0570BE5ED95D81092ACBC3B5B723C1BE", hash_generated_method = "D0980855FDF2338435348904BBF0C5B8")
        
private void enqueue(Reference<?> list) {
            while (list != null) {
                Reference<?> reference;
                // pendingNext is owned by the GC so no synchronization is required
                if (list == list.pendingNext) {
                    reference = list;
                    reference.pendingNext = null;
                    list = null;
                } else {
                    reference = list.pendingNext;
                    list.pendingNext = reference.pendingNext;
                    reference.pendingNext = null;
                }
                reference.enqueueInternal();
            }
        }
    }
    
    private static class FinalizerDaemon extends Daemon {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.238 -0500", hash_original_field = "06A9C4E4F8ECA95CA5CB0653FBCBED36", hash_generated_field = "420894E7A6688AFF48001D45B60EC731")

        private static final FinalizerDaemon INSTANCE = new FinalizerDaemon();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.241 -0500", hash_original_field = "A143AA90664A24D531DBBD9C087A3DD4", hash_generated_field = "A531B66CCCD67B32A728191891E2B401")

        private final ReferenceQueue<Object> queue = FinalizerReference.queue;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.243 -0500", hash_original_field = "060A289BB00834FB32A6570A4BEA728C", hash_generated_field = "4F48F43C1EA34CA35E4F2B48487C2292")

        private volatile Object finalizingObject;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.246 -0500", hash_original_field = "73DD3B0498BAFF0D8787D68270FBE7E7", hash_generated_field = "6FF12A6336A3541467350E5F1F9250E6")

        private volatile long finalizingStartedNanos;
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.825 -0400", hash_original_method = "4CAA35D6DE3500E449D08F039EDA298E", hash_generated_method = "4CAA35D6DE3500E449D08F039EDA298E")
        public FinalizerDaemon ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.248 -0500", hash_original_method = "C183E2A6A7B3ED28464B9D0F97F171B5", hash_generated_method = "481A0A577577C8299EC96B1C29FA2111")
        
@Override public void run() {
            while (isRunning()) {
                // Take a reference, blocking until one is ready or the thread should stop
                try {
                    doFinalize((FinalizerReference<?>) queue.remove());
                } catch (InterruptedException ignored) {
                }
            }
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.251 -0500", hash_original_method = "BF4896400D2910C88936D4B81319EC1C", hash_generated_method = "2622F85051A17208714787B5F21EAAA0")
        
@FindBugsSuppressWarnings("FI_EXPLICIT_INVOCATION")
        private void doFinalize(FinalizerReference<?> reference) {
            FinalizerReference.remove(reference);
            Object object = reference.get();
            reference.clear();
            try {
                finalizingStartedNanos = System.nanoTime();
                finalizingObject = object;
                object.finalize();
            } catch (Throwable ex) {
                // The RI silently swallows these, but Android has always logged.
                System.logE("Uncaught exception thrown by finalizer", ex);
            } finally {
                finalizingObject = null;
            }
        }
    }
    
    private static class FinalizerWatchdogDaemon extends Daemon {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.257 -0500", hash_original_field = "E7302A9C7CAB59DD513C6917B373DF25", hash_generated_field = "6FC68EE84E3EFE1A4A91B7713085F78F")

        private static final FinalizerWatchdogDaemon INSTANCE = new FinalizerWatchdogDaemon();
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.826 -0400", hash_original_method = "703968011540BAA8269C6E22457DD3B1", hash_generated_method = "703968011540BAA8269C6E22457DD3B1")
        public FinalizerWatchdogDaemon ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.261 -0500", hash_original_method = "0D26D8241DE84FB86F73D585D59D0B9C", hash_generated_method = "E3A131D6A3B25BC2DFD72F217E1027D6")
        
@Override public void run() {
            while (isRunning()) {
                Object object = FinalizerDaemon.INSTANCE.finalizingObject;
                long startedNanos = FinalizerDaemon.INSTANCE.finalizingStartedNanos;

                long sleepMillis = MAX_FINALIZE_MILLIS;
                if (object != null) {
                    long elapsedMillis = (System.nanoTime() - startedNanos) / NANOS_PER_MILLI;
                    sleepMillis -= elapsedMillis;
                }

                if (sleepMillis > 0) {
                    try {
                        Thread.sleep(sleepMillis);
                    } catch (InterruptedException e) {
                        continue;
                    }
                }

                if (object == null
                        || object != FinalizerDaemon.INSTANCE.finalizingObject
                        || VMRuntime.getRuntime().isDebuggerActive()) {
                    continue;
                }

                // The current object has exceeded the finalization deadline; abort!
                long elapsedMillis = (System.nanoTime() - startedNanos) / NANOS_PER_MILLI;
                Exception syntheticException = new TimeoutException();
                syntheticException.setStackTrace(FinalizerDaemon.INSTANCE.getStackTrace());
                System.logE(object.getClass().getName() + ".finalize() timed out after "
                        + elapsedMillis + " ms; limit is " + MAX_FINALIZE_MILLIS + " ms",
                        syntheticException);
                System.exit(2);
            }
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:17.194 -0500", hash_original_field = "7EE9460B052D8725729D28B2E15113EB", hash_generated_field = "338AD99210C288DAC8FF0ED003934C14")

    private static final long MAX_FINALIZE_MILLIS = 10L * 1000L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.801 -0400", hash_original_method = "12604031794E0E37BA5BBC4D434861F1", hash_generated_method = "12604031794E0E37BA5BBC4D434861F1")
    public Daemons ()
    {
        //Synthesized constructor
    }
}

