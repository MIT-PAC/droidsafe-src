package dalvik.system.profiler;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public final class SamplingProfiler {
    private final Map<HprofData.StackTrace, int[]> stackTraces
            = new HashMap<HprofData.StackTrace, int[]>();
    private final HprofData hprofData = new HprofData(stackTraces);
    private final Timer timer = new Timer("SamplingProfiler", true);
    private Sampler sampler;
    private final int depth;
    private final ThreadSet threadSet;
    private int nextThreadId = 200001;
    private int nextStackTraceId = 300001;
    private int nextObjectId = 1;
    private Thread[] currentThreads = new Thread[0];
    private final Map<Thread, Integer> threadIds = new HashMap<Thread, Integer>();
    private final HprofData.StackTrace mutableStackTrace = new HprofData.StackTrace();
    private final ThreadSampler threadSampler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.339 -0400", hash_original_method = "E2013E33C1696BCCD8E7E5A3F3F67C32", hash_generated_method = "89F27476C55C10A42D112D9B6A9EA104")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.339 -0400", hash_original_method = "E43429358514D6D4B0CC42164635A3D5", hash_generated_method = "5333A58376E57A2EF0CC34755B4EA12E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.339 -0400", hash_original_method = "A889DB559A2B33228A53B2099C98311C", hash_generated_method = "5FA86A629A29ABCD0F96C031729855F7")
    public static ThreadSet newArrayThreadSet(Thread... threads) {
        return new ArrayThreadSet(threads);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.339 -0400", hash_original_method = "F09FDB9755D99D32743DCF4D175D4564", hash_generated_method = "527DBF9DF3B9076857FC6255C04563C4")
    public static ThreadSet newThreadGroupTheadSet(ThreadGroup threadGroup) {
        return new ThreadGroupThreadSet(threadGroup);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.339 -0400", hash_original_method = "27D03994E61C1E4974C7BBD91A5CED76", hash_generated_method = "C9C9253F1175C0098FBE32783C7E3A5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void start(int interval) {
        dsTaint.addTaint(interval);
        {
            throw new IllegalArgumentException("interval < 1");
        } //End block
        {
            throw new IllegalStateException("profiling already started");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.339 -0400", hash_original_method = "67E3C9BA9A63DEAC75D61937C8B159A6", hash_generated_method = "2C5BF96F788F90A6F9A5B7B8E227A83C")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.339 -0400", hash_original_method = "E9FD5B0933A1848F685AEBC164A37AF6", hash_generated_method = "CB71F5F7FE0AFCBA48B3CB84BD77F928")
    @DSModeled(DSC.SAFE)
    public void shutdown() {
        stop();
        timer.cancel();
        // ---------- Original Method ----------
        //stop();
        //timer.cancel();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.339 -0400", hash_original_method = "ED23570BD9F6C6F13BA5A80428CD13EC", hash_generated_method = "9EA266FFE412C37A69CBCF61273D78E9")
    @DSModeled(DSC.SAFE)
    public HprofData getHprofData() {
        {
            throw new IllegalStateException("cannot access hprof data while sampling");
        } //End block
        return (HprofData)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (sampler != null) {
            //throw new IllegalStateException("cannot access hprof data while sampling");
        //}
        //return hprofData;
    }

    
    private static class ArrayThreadSet implements ThreadSet {
        private final Thread[] threads;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.339 -0400", hash_original_method = "77E03C0451741A4E1C44419B134120C8", hash_generated_method = "13476ED21F2D7FD37181E3EE43511318")
        @DSModeled(DSC.SAFE)
        public ArrayThreadSet(Thread... threads) {
            dsTaint.addTaint(threads.dsTaint);
            {
                throw new NullPointerException("threads == null");
            } //End block
            // ---------- Original Method ----------
            //if (threads == null) {
                //throw new NullPointerException("threads == null");
            //}
            //this.threads = threads;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.340 -0400", hash_original_method = "5BD7766F6E0173FC433E1E7F289EB1BE", hash_generated_method = "1F3958A442897609C1F2185A99922A5B")
        @DSModeled(DSC.SAFE)
        public Thread[] threads() {
            return (Thread[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return threads;
        }

        
    }


    
    private static class ThreadGroupThreadSet implements ThreadSet {
        private final ThreadGroup threadGroup;
        private Thread[] threads;
        private int lastThread;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.340 -0400", hash_original_method = "A3C3F7BBDEF2CA8B1B158C093A73C39B", hash_generated_method = "235199B3EDC795A7F976E281C01F3328")
        @DSModeled(DSC.SAFE)
        public ThreadGroupThreadSet(ThreadGroup threadGroup) {
            dsTaint.addTaint(threadGroup.dsTaint);
            {
                throw new NullPointerException("threadGroup == null");
            } //End block
            resize();
            // ---------- Original Method ----------
            //if (threadGroup == null) {
                //throw new NullPointerException("threadGroup == null");
            //}
            //this.threadGroup = threadGroup;
            //resize();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.340 -0400", hash_original_method = "634F6B8483D3410BA8D4C537A5664EC3", hash_generated_method = "0F5FF224488CF2E0D96A77786B0E8D4E")
        @DSModeled(DSC.SAFE)
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.340 -0400", hash_original_method = "32A384241C8D4460079A29E3C7BA2EEB", hash_generated_method = "5ED573A21CB627B407468425772DD1D8")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.340 -0400", hash_original_method = "3FC3FC48F91B564D9AD79AA9DB2F74C2", hash_generated_method = "D2B5E6793E6A3F5EEB51E6241E6B95CB")
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
                boolean var0F1FEDD279682D3FF1BADDAE0138F716_142204469 = (!Arrays.equals(currentThreads, newThreads));
                {
                    updateThreadHistory(currentThreads, newThreads);
                    currentThreads = newThreads.clone();
                } //End block
            } //End collapsed parenthetic
            {
                Iterator<Thread> seatecAstronomy42 = currentThreads.iterator();
                seatecAstronomy42.hasNext();
                Thread thread = seatecAstronomy42.next();
                {
                    StackTraceElement[] stackFrames;
                    stackFrames = threadSampler.getStackTrace(thread);
                    recordStackTrace(thread, stackFrames);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.340 -0400", hash_original_method = "F11BBDF4101A6D713104B5DB9760A085", hash_generated_method = "40D1E92733F9529BBAB6A892595B89AC")
        @DSModeled(DSC.SAFE)
        private void recordStackTrace(Thread thread, StackTraceElement[] stackFrames) {
            dsTaint.addTaint(stackFrames.dsTaint);
            dsTaint.addTaint(thread.dsTaint);
            Integer threadId;
            threadId = threadIds.get(thread);
            {
                throw new IllegalArgumentException("Unknown thread " + thread);
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
            countCell[0]++;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.340 -0400", hash_original_method = "B49A7EC3437DE14BA292DE44FA40B97A", hash_generated_method = "44735356387EE5891382C2A8EF8771A8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void updateThreadHistory(Thread[] oldThreads, Thread[] newThreads) {
            dsTaint.addTaint(oldThreads.dsTaint);
            dsTaint.addTaint(newThreads.dsTaint);
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
                Iterator<Thread> seatecAstronomy42 = added.iterator();
                seatecAstronomy42.hasNext();
                Thread thread = seatecAstronomy42.next();
                {
                    addStartThread(thread);
                } //End block
            } //End collapsed parenthetic
            {
                Iterator<Thread> seatecAstronomy42 = removed.iterator();
                seatecAstronomy42.hasNext();
                Thread thread = seatecAstronomy42.next();
                {
                    addEndThread(thread);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.341 -0400", hash_original_method = "D7E70BFB99D4B0D69C428CA3433E6D0D", hash_generated_method = "4C90AF282FCED42728E0BEB03C18B63C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void addStartThread(Thread thread) {
            dsTaint.addTaint(thread.dsTaint);
            {
                throw new NullPointerException("thread == null");
            } //End block
            int threadId;
            threadId = nextThreadId++;
            Integer old;
            old = threadIds.put(thread, threadId);
            {
                throw new IllegalArgumentException("Thread already registered as " + old);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.341 -0400", hash_original_method = "631F90CADC4DC4D78F0863A31213AEA2", hash_generated_method = "C1DAE08450C90C287B469900C9D0ECB0")
        @DSModeled(DSC.SAFE)
        private void addEndThread(Thread thread) {
            dsTaint.addTaint(thread.dsTaint);
            {
                throw new NullPointerException("thread == null");
            } //End block
            Integer threadId;
            threadId = threadIds.remove(thread);
            {
                throw new IllegalArgumentException("Unknown thread " + thread);
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


