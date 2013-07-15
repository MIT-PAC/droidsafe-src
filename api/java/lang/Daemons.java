package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import dalvik.system.VMRuntime;
import java.lang.ref.FinalizerReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeoutException;
import libcore.util.EmptyArray;

public final class Daemons {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:50.047 -0400", hash_original_method = "12604031794E0E37BA5BBC4D434861F1", hash_generated_method = "12604031794E0E37BA5BBC4D434861F1")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:50.049 -0400", hash_original_field = "DC127F5D2483352FD20EADDB38FEB6D2", hash_generated_field = "3B3F78C77D023C4AC9933B933AD9AFEC")

        private Thread thread;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:50.049 -0400", hash_original_method = "E956A3D7836B08A486122F00857B9C56", hash_generated_method = "E956A3D7836B08A486122F00857B9C56")
        public Daemon ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:50.050 -0400", hash_original_method = "BFB12BB46815FEE0BC693DC0650B4AEF", hash_generated_method = "55D07D61D2F907CAB9C27B9D62ABD799")
        public synchronized void start() {
    if(thread != null)            
            {
                IllegalStateException varB62FF47358887E899850ABAD5F07AEDD_1727720862 = new IllegalStateException("already running");
                varB62FF47358887E899850ABAD5F07AEDD_1727720862.addTaint(taint);
                throw varB62FF47358887E899850ABAD5F07AEDD_1727720862;
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

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:50.051 -0400", hash_original_method = "DAD25559614D18C95C6D7AD3A5FF9D6E", hash_generated_method = "86E05CA2A6D1353660F27AAD7E84E7B7")
        protected synchronized boolean isRunning() {
            boolean varDFF88D74CC68B19FF5DB0AFB25CEF91C_2075692256 = (thread != null);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_451468531 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_451468531;
            // ---------- Original Method ----------
            //return thread != null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:50.051 -0400", hash_original_method = "87D921900F5E002E9B0AB652C178420C", hash_generated_method = "C20EBE901A62C91A3B4B2E835132BF18")
        public synchronized void interrupt() {
    if(thread == null)            
            {
                IllegalStateException var9D4D07E302FAF498B25B68C78C8D69AE_899849712 = new IllegalStateException("not running");
                var9D4D07E302FAF498B25B68C78C8D69AE_899849712.addTaint(taint);
                throw var9D4D07E302FAF498B25B68C78C8D69AE_899849712;
            } //End block
            thread.interrupt();
            // ---------- Original Method ----------
            //if (thread == null) {
                //throw new IllegalStateException("not running");
            //}
            //thread.interrupt();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:50.052 -0400", hash_original_method = "26FE25A9A5C4B7C9ED7155D7450987C1", hash_generated_method = "A2106BF8459439EC2D18C4F981E5EB3F")
        public void stop() {
            Thread threadToStop;
            synchronized
(this)            {
                threadToStop = thread;
                thread = null;
            } //End block
    if(threadToStop == null)            
            {
                IllegalStateException var9D4D07E302FAF498B25B68C78C8D69AE_131227194 = new IllegalStateException("not running");
                var9D4D07E302FAF498B25B68C78C8D69AE_131227194.addTaint(taint);
                throw var9D4D07E302FAF498B25B68C78C8D69AE_131227194;
            } //End block
            threadToStop.interrupt();
            while
(true)            
            {
                try 
                {
                    threadToStop.join();
                    return;
                } //End block
                catch (InterruptedException ignored)
                {
                } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:50.053 -0400", hash_original_method = "71D841FC79E6E388CBA40EED62E5BA4E", hash_generated_method = "624353E65FDFB5A4D6FCAE8E7E7FEA7A")
        public synchronized StackTraceElement[] getStackTrace() {
StackTraceElement[] var3EF384E039755933EEB005EFF8EF56C6_174517329 =             thread != null ? thread.getStackTrace() : EmptyArray.STACK_TRACE_ELEMENT;
            var3EF384E039755933EEB005EFF8EF56C6_174517329.addTaint(taint);
            return var3EF384E039755933EEB005EFF8EF56C6_174517329;
            // ---------- Original Method ----------
            //return thread != null ? thread.getStackTrace() : EmptyArray.STACK_TRACE_ELEMENT;
        }

        
    }


    
    private static class ReferenceQueueDaemon extends Daemon {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:50.054 -0400", hash_original_method = "CD631EFADB4142F64B0E6D0342597BAC", hash_generated_method = "CD631EFADB4142F64B0E6D0342597BAC")
        public ReferenceQueueDaemon ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:50.054 -0400", hash_original_method = "16C06FBAF3631080CE709DA6BD6140A9", hash_generated_method = "A2EE438EB53EFA418E9773C20AA08633")
        @Override
        public void run() {
            while
(isRunning())            
            {
                Reference<?> list;
                try 
                {
                    synchronized
(ReferenceQueue.class)                    {
                        while
(ReferenceQueue.unenqueued == null)                        
                        {
                            ReferenceQueue.class.wait();
                        } //End block
                        list = ReferenceQueue.unenqueued;
                        ReferenceQueue.unenqueued = null;
                    } //End block
                } //End block
                catch (InterruptedException e)
                {
                    continue;
                } //End block
                enqueue(list);
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:50.056 -0400", hash_original_method = "0570BE5ED95D81092ACBC3B5B723C1BE", hash_generated_method = "5C3C5A2BAB4ACE3B52734338830D180E")
        private void enqueue(Reference<?> list) {
            addTaint(list.getTaint());
            while
(list != null)            
            {
                Reference<?> reference;
    if(list == list.pendingNext)                
                {
                    reference = list;
                    reference.pendingNext = null;
                    list = null;
                } //End block
                else
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:50.056 -0400", hash_original_field = "5650660E20B53883AE4489C1195AA841", hash_generated_field = "C275CE9279DB140FF5DBBF91CA644933")

        private static final ReferenceQueueDaemon INSTANCE = new ReferenceQueueDaemon();
    }


    
    private static class FinalizerDaemon extends Daemon {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:50.056 -0400", hash_original_field = "4B4A54D76D30CD0234D169C4531A2DD6", hash_generated_field = "A531B66CCCD67B32A728191891E2B401")

        private final ReferenceQueue<Object> queue = FinalizerReference.queue;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:50.056 -0400", hash_original_field = "701768BB7ADB1CB2751C9C863BA6D59D", hash_generated_field = "4F48F43C1EA34CA35E4F2B48487C2292")

        private volatile Object finalizingObject;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:50.056 -0400", hash_original_field = "B1777B42F737CBCB0DCE53521B3D003E", hash_generated_field = "6FF12A6336A3541467350E5F1F9250E6")

        private volatile long finalizingStartedNanos;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:50.056 -0400", hash_original_method = "4CAA35D6DE3500E449D08F039EDA298E", hash_generated_method = "4CAA35D6DE3500E449D08F039EDA298E")
        public FinalizerDaemon ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:50.057 -0400", hash_original_method = "C183E2A6A7B3ED28464B9D0F97F171B5", hash_generated_method = "A7EB9B9888DC71412D353561A29F06B9")
        @Override
        public void run() {
            while
(isRunning())            
            {
                try 
                {
                    doFinalize((FinalizerReference<?>) queue.remove());
                } //End block
                catch (InterruptedException ignored)
                {
                } //End block
            } //End block
            // ---------- Original Method ----------
            //while (isRunning()) {
                //try {
                    //doFinalize((FinalizerReference<?>) queue.remove());
                //} catch (InterruptedException ignored) {
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:50.057 -0400", hash_original_method = "BF4896400D2910C88936D4B81319EC1C", hash_generated_method = "24B1AF5C973D39046DDDECBC0A50CBDE")
        @FindBugsSuppressWarnings("FI_EXPLICIT_INVOCATION")
        private void doFinalize(FinalizerReference<?> reference) {
            addTaint(reference.getTaint());
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:50.058 -0400", hash_original_field = "F3CD5CFCB43A075A403BBAF9D101689C", hash_generated_field = "420894E7A6688AFF48001D45B60EC731")

        private static final FinalizerDaemon INSTANCE = new FinalizerDaemon();
    }


    
    private static class FinalizerWatchdogDaemon extends Daemon {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:50.058 -0400", hash_original_method = "703968011540BAA8269C6E22457DD3B1", hash_generated_method = "703968011540BAA8269C6E22457DD3B1")
        public FinalizerWatchdogDaemon ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:50.058 -0400", hash_original_method = "0D26D8241DE84FB86F73D585D59D0B9C", hash_generated_method = "E3C3D8AD8336E0BCD453566E6C9C19D6")
        @Override
        public void run() {
            while
(isRunning())            
            {
                Object object = FinalizerDaemon.INSTANCE.finalizingObject;
                long startedNanos = FinalizerDaemon.INSTANCE.finalizingStartedNanos;
                long sleepMillis = MAX_FINALIZE_MILLIS;
    if(object != null)                
                {
                    long elapsedMillis = (System.nanoTime() - startedNanos) / NANOS_PER_MILLI;
                    sleepMillis -= elapsedMillis;
                } //End block
    if(sleepMillis > 0)                
                {
                    try 
                    {
                        Thread.sleep(sleepMillis);
                    } //End block
                    catch (InterruptedException e)
                    {
                        continue;
                    } //End block
                } //End block
    if(object == null
                        || object != FinalizerDaemon.INSTANCE.finalizingObject
                        || VMRuntime.getRuntime().isDebuggerActive())                
                {
                    continue;
                } //End block
                long elapsedMillis = (System.nanoTime() - startedNanos) / NANOS_PER_MILLI;
                Exception syntheticException = new TimeoutException();
                syntheticException.setStackTrace(FinalizerDaemon.INSTANCE.getStackTrace());
                System.logE(object.getClass().getName() + ".finalize() timed out after "
                        + elapsedMillis + " ms; limit is " + MAX_FINALIZE_MILLIS + " ms",
                        syntheticException);
                System.exit(2);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:50.058 -0400", hash_original_field = "875E76F0367FD406AB3EACA1D853D3E1", hash_generated_field = "6FC68EE84E3EFE1A4A91B7713085F78F")

        private static final FinalizerWatchdogDaemon INSTANCE = new FinalizerWatchdogDaemon();
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:50.059 -0400", hash_original_field = "90F159E16A269B6F875D096F21ED865D", hash_generated_field = "E32D593DEDB2FDC7FE0DFB7474352DBA")

    private static final int NANOS_PER_MILLI = 1000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:50.059 -0400", hash_original_field = "7E70092D9C82948944E1EEE8DBEBD35E", hash_generated_field = "338AD99210C288DAC8FF0ED003934C14")

    private static final long MAX_FINALIZE_MILLIS = 10L * 1000L;
}

