package dalvik.system.profiler;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public final class SamplingProfiler {
    private Map<HprofData.StackTrace, int[]> stackTraces
            = new HashMap<HprofData.StackTrace, int[]>();
    private HprofData hprofData = new HprofData(stackTraces);
    private Timer timer = new Timer("SamplingProfiler", true);
    private Sampler sampler;
    private int depth;
    private ThreadSet threadSet;
    private int nextThreadId = 200001;
    private int nextStackTraceId = 300001;
    private int nextObjectId = 1;
    private Thread[] currentThreads = new Thread[0];
    private Map<Thread, Integer> threadIds = new HashMap<Thread, Integer>();
    private HprofData.StackTrace mutableStackTrace = new HprofData.StackTrace();
    private ThreadSampler threadSampler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.428 -0400", hash_original_method = "E2013E33C1696BCCD8E7E5A3F3F67C32", hash_generated_method = "E859C65DF7F245816A12F8FAC949963D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SamplingProfiler(int depth, ThreadSet threadSet) {
        dsTaint.addTaint(threadSet.dsTaint);
        dsTaint.addTaint(depth);
        this.threadSampler = findDefaultThreadSampler();
        threadSampler.setDepth(depth);
        hprofData.setFlags(BinaryHprof.ControlSettings.CPU_SAMPLING.bitmask);
        hprofData.setDepth(depth);
        // ---------- Original Method ----------
        //this.depth = depth;
        //this.threadSet = threadSet;
        //this.threadSampler = findDefaultThreadSampler();
        //threadSampler.setDepth(depth);
        //hprofData.setFlags(BinaryHprof.ControlSettings.CPU_SAMPLING.bitmask);
        //hprofData.setDepth(depth);
    }

    
        private static ThreadSampler findDefaultThreadSampler() {
        if ("Dalvik Core Library".equals(System.getProperty("java.specification.name"))) {
            String className = "dalvik.system.profiler.DalvikThreadSampler";
            try {
                return (ThreadSampler) Class.forName(className).newInstance();
            } catch (Exception e) {
                System.out.println("Problem creating " + className + ": " + e);
            }
        }
        return new PortableThreadSampler();
    }

    
        public static ThreadSet newArrayThreadSet(Thread... threads) {
        return new ArrayThreadSet(threads);
    }

    
        public static ThreadSet newThreadGroupTheadSet(ThreadGroup threadGroup) {
        return new ThreadGroupThreadSet(threadGroup);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.428 -0400", hash_original_method = "27D03994E61C1E4974C7BBD91A5CED76", hash_generated_method = "BFAD7294B15EC209AB3CB12CB9FE3A65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void start(int interval) {
        dsTaint.addTaint(interval);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("interval < 1");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("profiling already started");
        } //End block
        sampler = new Sampler();
        hprofData.setStartMillis(System.currentTimeMillis());
        timer.scheduleAtFixedRate(sampler, 0, interval);
        // ---------- Original Method ----------
        //if (interval < 1) {
            //throw new IllegalArgumentException("interval < 1");
        //}
        //if (sampler != null) {
            //throw new IllegalStateException("profiling already started");
        //}
        //sampler = new Sampler();
        //hprofData.setStartMillis(System.currentTimeMillis());
        //timer.scheduleAtFixedRate(sampler, 0, interval);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.429 -0400", hash_original_method = "67E3C9BA9A63DEAC75D61937C8B159A6", hash_generated_method = "2F55F670185D8318E18E18355C5996E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void stop() {
        {
            sampler.stop = true;
            {
                try 
                {
                    sampler.wait();
                } //End block
                catch (InterruptedException ignored)
                { }
            } //End block
        } //End block
        sampler = null;
        // ---------- Original Method ----------
        //if (sampler == null) {
            //return;
        //}
        //synchronized(sampler) {
            //sampler.stop = true;
            //while (!sampler.stopped) {
                //try {
                    //sampler.wait();
                //} catch (InterruptedException ignored) {
                //}
            //}
        //}
        //sampler = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.429 -0400", hash_original_method = "E9FD5B0933A1848F685AEBC164A37AF6", hash_generated_method = "62A5E416FD9EC25C2C2402805D8B0333")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void shutdown() {
        stop();
        timer.cancel();
        // ---------- Original Method ----------
        //stop();
        //timer.cancel();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.429 -0400", hash_original_method = "ED23570BD9F6C6F13BA5A80428CD13EC", hash_generated_method = "9447CCDF1B59C24771409581A10A593C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HprofData getHprofData() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("cannot access hprof data while sampling");
        } //End block
        return (HprofData)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (sampler != null) {
            //throw new IllegalStateException("cannot access hprof data while sampling");
        //}
        //return hprofData;
    }

    
    private static class ArrayThreadSet implements ThreadSet {
        private Thread[] threads;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.429 -0400", hash_original_method = "77E03C0451741A4E1C44419B134120C8", hash_generated_method = "3244FFC7E7CCFB81F3B5DBB299A67640")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ArrayThreadSet(Thread... threads) {
            dsTaint.addTaint(threads[0].dsTaint);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("threads == null");
            } //End block
            // ---------- Original Method ----------
            //if (threads == null) {
                //throw new NullPointerException("threads == null");
            //}
            //this.threads = threads;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.429 -0400", hash_original_method = "5BD7766F6E0173FC433E1E7F289EB1BE", hash_generated_method = "13C083FC999AFB1D508063D1923FC941")
        @DSModeled(DSC.SAFE)
        public Thread[] threads() {
            return (Thread[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return threads;
        }

        
    }


    
    private static class ThreadGroupThreadSet implements ThreadSet {
        private ThreadGroup threadGroup;
        private Thread[] threads;
        private int lastThread;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.430 -0400", hash_original_method = "A3C3F7BBDEF2CA8B1B158C093A73C39B", hash_generated_method = "26B491EA82E9B54F676D3469383D56AE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ThreadGroupThreadSet(ThreadGroup threadGroup) {
            dsTaint.addTaint(threadGroup.dsTaint);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("threadGroup == null");
            } //End block
            resize();
            // ---------- Original Method ----------
            //if (threadGroup == null) {
                //throw new NullPointerException("threadGroup == null");
            //}
            //this.threadGroup = threadGroup;
            //resize();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.430 -0400", hash_original_method = "634F6B8483D3410BA8D4C537A5664EC3", hash_generated_method = "78040ABA0C8A6E83671D059BA26C97C9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void resize() {
            int count;
            count = threadGroup.activeCount();
            threads = new Thread[count*2];
            lastThread = 0;
            // ---------- Original Method ----------
            //int count = threadGroup.activeCount();
            //threads = new Thread[count*2];
            //lastThread = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.430 -0400", hash_original_method = "32A384241C8D4460079A29E3C7BA2EEB", hash_generated_method = "F85198CA3AB86A8E2A2B9606F3D715A5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Thread[] threads() {
            int threadCount;
            {
                threadCount = threadGroup.enumerate(threads);
                {
                    resize();
                } //End block
            } //End block
            {
                Arrays.fill(threads, threadCount, lastThread, null);
            } //End block
            lastThread = threadCount;
            return (Thread[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //int threadCount;
            //while (true) {
                //threadCount = threadGroup.enumerate(threads);
                //if (threadCount == threads.length) {
                    //resize();
                //} else {
                    //break;
                //}
            //}
            //if (threadCount < lastThread) {
                //Arrays.fill(threads, threadCount, lastThread, null);
            //}
            //lastThread = threadCount;
            //return threads;
        }

        
    }


    
    private class Sampler extends TimerTask {
        private boolean stop;
        private boolean stopped;
        private Thread timerThread;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.430 -0400", hash_original_method = "C02C544879A69B2EE02E209CCC87FDC8", hash_generated_method = "C02C544879A69B2EE02E209CCC87FDC8")
                public Sampler ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.436 -0400", hash_original_method = "3FC3FC48F91B564D9AD79AA9DB2F74C2", hash_generated_method = "A2C2F16DEF8A0CCAF199406060E740C9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            {
                {
                    cancel();
                    stopped = true;
                    notifyAll();
                } //End block
            } //End block
            {
                timerThread = Thread.currentThread();
            } //End block
            Thread[] newThreads;
            newThreads = threadSet.threads();
            {
                boolean var0F1FEDD279682D3FF1BADDAE0138F716_11834214 = (!Arrays.equals(currentThreads, newThreads));
                {
                    updateThreadHistory(currentThreads, newThreads);
                    currentThreads = newThreads.clone();
                } //End block
            } //End collapsed parenthetic
            {
                Thread thread = currentThreads[0];
                {
                    StackTraceElement[] stackFrames;
                    stackFrames = threadSampler.getStackTrace(thread);
                    recordStackTrace(thread, stackFrames);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.437 -0400", hash_original_method = "F11BBDF4101A6D713104B5DB9760A085", hash_generated_method = "A809AFE2216D7B406A47B659C3F1CD48")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void recordStackTrace(Thread thread, StackTraceElement[] stackFrames) {
            dsTaint.addTaint(stackFrames[0].dsTaint);
            dsTaint.addTaint(thread.dsTaint);
            Integer threadId;
            threadId = threadIds.get(thread);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown thread " + thread);
            } //End block
            mutableStackTrace.threadId = threadId;
            mutableStackTrace.stackFrames = stackFrames;
            int[] countCell;
            countCell = stackTraces.get(mutableStackTrace);
            {
                countCell = new int[1];
                StackTraceElement[] stackFramesCopy;
                stackFramesCopy = stackFrames.clone();
                HprofData.StackTrace stackTrace;
                stackTrace = new HprofData.StackTrace(nextStackTraceId++, threadId, stackFramesCopy);
                hprofData.addStackTrace(stackTrace, countCell);
            } //End block
            // ---------- Original Method ----------
            //Integer threadId = threadIds.get(thread);
            //if (threadId == null) {
                //throw new IllegalArgumentException("Unknown thread " + thread);
            //}
            //mutableStackTrace.threadId = threadId;
            //mutableStackTrace.stackFrames = stackFrames;
            //int[] countCell = stackTraces.get(mutableStackTrace);
            //if (countCell == null) {
                //countCell = new int[1];
                //StackTraceElement[] stackFramesCopy = stackFrames.clone();
                //HprofData.StackTrace stackTrace
                        //= new HprofData.StackTrace(nextStackTraceId++, threadId, stackFramesCopy);
                //hprofData.addStackTrace(stackTrace, countCell);
            //}
            //countCell[0]++;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.445 -0400", hash_original_method = "B49A7EC3437DE14BA292DE44FA40B97A", hash_generated_method = "000131B2A0C03A811BC0591DCCF92545")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void updateThreadHistory(Thread[] oldThreads, Thread[] newThreads) {
            dsTaint.addTaint(oldThreads[0].dsTaint);
            dsTaint.addTaint(newThreads[0].dsTaint);
            Set<Thread> n;
            n = new HashSet<Thread>(Arrays.asList(newThreads));
            Set<Thread> o;
            o = new HashSet<Thread>(Arrays.asList(oldThreads));
            Set<Thread> added;
            added = new HashSet<Thread>(n);
            added.removeAll(o);
            Set<Thread> removed;
            removed = new HashSet<Thread>(o);
            removed.removeAll(n);
            {
                Iterator<Thread> var72E8A17AE610D2FCC3673AAD53285BD6_1492105160 = (added).iterator();
                var72E8A17AE610D2FCC3673AAD53285BD6_1492105160.hasNext();
                Thread thread = var72E8A17AE610D2FCC3673AAD53285BD6_1492105160.next();
                {
                    addStartThread(thread);
                } //End block
            } //End collapsed parenthetic
            {
                Iterator<Thread> varB1F20EA814E14D4F55D52568568B3272_2108642339 = (removed).iterator();
                varB1F20EA814E14D4F55D52568568B3272_2108642339.hasNext();
                Thread thread = varB1F20EA814E14D4F55D52568568B3272_2108642339.next();
                {
                    addEndThread(thread);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.446 -0400", hash_original_method = "D7E70BFB99D4B0D69C428CA3433E6D0D", hash_generated_method = "447981CB090AB9DBD8A312F3BC07226F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void addStartThread(Thread thread) {
            dsTaint.addTaint(thread.dsTaint);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("thread == null");
            } //End block
            int threadId;
            threadId = nextThreadId++;
            Integer old;
            old = threadIds.put(thread, threadId);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Thread already registered as " + old);
            } //End block
            String threadName;
            threadName = thread.getName();
            ThreadGroup group;
            group = thread.getThreadGroup();
            String groupName;
            groupName = null;
            groupName = group.getName();
            ThreadGroup parentGroup;
            parentGroup = null;
            parentGroup = group.getParent();
            String parentGroupName;
            parentGroupName = null;
            parentGroupName = parentGroup.getName();
            HprofData.ThreadEvent event;
            event = HprofData.ThreadEvent.start(nextObjectId++, threadId,
                                                  threadName, groupName, parentGroupName);
            hprofData.addThreadEvent(event);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.446 -0400", hash_original_method = "631F90CADC4DC4D78F0863A31213AEA2", hash_generated_method = "D11A0EC785AEC170B7C22DBC14B49CA0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void addEndThread(Thread thread) {
            dsTaint.addTaint(thread.dsTaint);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("thread == null");
            } //End block
            Integer threadId;
            threadId = threadIds.remove(thread);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown thread " + thread);
            } //End block
            HprofData.ThreadEvent event;
            event = HprofData.ThreadEvent.end(threadId);
            hprofData.addThreadEvent(event);
            // ---------- Original Method ----------
            //if (thread == null) {
                //throw new NullPointerException("thread == null");
            //}
            //Integer threadId = threadIds.remove(thread);
            //if (threadId == null) {
                //throw new IllegalArgumentException("Unknown thread " + thread);
            //}
            //HprofData.ThreadEvent event = HprofData.ThreadEvent.end(threadId);
            //hprofData.addThreadEvent(event);
        }

        
    }


    
    public static interface ThreadSet {
        
        public Thread[] threads();
    }
    
}

