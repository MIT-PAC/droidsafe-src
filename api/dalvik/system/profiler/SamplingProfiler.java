package dalvik.system.profiler;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public final class SamplingProfiler {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.015 -0500", hash_original_method = "E43429358514D6D4B0CC42164635A3D5", hash_generated_method = "5333A58376E57A2EF0CC34755B4EA12E")
    
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

    /**
     * Returns a ThreadSet for a fixed set of threads that will not
     * vary at runtime. This has less overhead than a dynamically
     * calculated set, such as {@link #newThreadGroupTheadSet}, which has
     * to enumerate the threads each time profiler wants to collect
     * samples.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.020 -0500", hash_original_method = "A889DB559A2B33228A53B2099C98311C", hash_generated_method = "5FA86A629A29ABCD0F96C031729855F7")
    
public static ThreadSet newArrayThreadSet(Thread... threads) {
        return new ArrayThreadSet(threads);
    }

    /**
     * Returns a ThreadSet that is dynamically computed based on the
     * threads found in the specified ThreadGroup and that
     * ThreadGroup's children.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.033 -0500", hash_original_method = "F09FDB9755D99D32743DCF4D175D4564", hash_generated_method = "527DBF9DF3B9076857FC6255C04563C4")
    
public static ThreadSet newThreadGroupTheadSet(ThreadGroup threadGroup) {
        return new ThreadGroupThreadSet(threadGroup);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.978 -0500", hash_original_field = "344EF99E72779EE2E977562D8A7AB919", hash_generated_field = "C152621F50161C6F4001CF97446A8451")

    private final Map<HprofData.StackTrace, int[]> stackTraces
            = new HashMap<HprofData.StackTrace, int[]>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.982 -0500", hash_original_field = "38E55E1AFC70448A490FAC454BEBE59E", hash_generated_field = "F415E27C9756B61B500D699D2023DCBE")

    private final HprofData hprofData = new HprofData(stackTraces);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.984 -0500", hash_original_field = "333CB417F0745C0B73421EE7CBA88425", hash_generated_field = "5257F3CDD26BE88471BAA3D827A1AB12")

    private final Timer timer = new Timer("SamplingProfiler", true);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.987 -0500", hash_original_field = "09892E9C2C490641292D8F0421E47B2C", hash_generated_field = "B562247DC5E7C6FB74DB56F365094BB7")

    private Sampler sampler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.989 -0500", hash_original_field = "C1588B2CF4C1B54961548959E16213DF", hash_generated_field = "9E4E1D4E0DD2F9B43B1F6C7CB67C1409")

    private  int depth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.991 -0500", hash_original_field = "FB1C6C017570BC6E7CE648293BA5263F", hash_generated_field = "8D44FD9456A73317948C7E807ED46A93")

    private  ThreadSet threadSet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.994 -0500", hash_original_field = "DA05ACA940A43C0EF1D3669A3591182C", hash_generated_field = "35EE7CB938A7415269E60299D636CE4A")

    private int nextThreadId = 200001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.996 -0500", hash_original_field = "BE90FFA4F23E96D24768A08AF8657C96", hash_generated_field = "3A74A24BBD1F02EFA2B8941E3667D65C")

    private int nextStackTraceId = 300001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.998 -0500", hash_original_field = "EB1FE381EE33C2D05D66C8C26E56D188", hash_generated_field = "D8831A1D35C191C6860F2D253762F36B")

    private int nextObjectId = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.001 -0500", hash_original_field = "13EA1FB6E9B4D65B695E9C4F63F9FA0F", hash_generated_field = "956AF7D907252A038357B38A0B0DC19F")

    private Thread[] currentThreads = new Thread[0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.003 -0500", hash_original_field = "849A791590542ABCFD2A885D1F50E4D8", hash_generated_field = "F0D9524D154438AC2ADFB8BD79774D4B")

    private final Map<Thread, Integer> threadIds = new HashMap<Thread, Integer>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.006 -0500", hash_original_field = "BEDE88B95619E0741ADA7E666F7BD14E", hash_generated_field = "518C2C85A6D73F9426E4B044DBE9A0B5")

    private final HprofData.StackTrace mutableStackTrace = new HprofData.StackTrace();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.008 -0500", hash_original_field = "EB0D5B1F16840F5930E91BCE48185B18", hash_generated_field = "3A1BD9A3E1F8ED3ABCF715F52B0C955E")

    private  ThreadSampler threadSampler;

    /**
     * Create a sampling profiler that collects stacks with the
     * specified depth from the threads specified by the specified
     * thread collector.
     *
     * @param depth The maximum stack depth to retain for each sample
     * similar to the hprof option of the same name. Any stack deeper
     * than this will be truncated to this depth. A good starting
     * value is 4 although it is not uncommon to need to raise this to
     * get enough context to understand program behavior. While
     * programs with extensive recursion may require a high value for
     * depth, simply passing in a value for Integer.MAX_VALUE is not
     * advised because of the significant memory need to retain such
     * stacks and runtime overhead to compare stacks.
     *
     * @param threadSet The thread set specifies which threads to
     * sample. In a general purpose program, all threads typically
     * should be sample with a ThreadSet such as provied by {@link
     * #newThreadGroupTheadSet newThreadGroupTheadSet}. For a
     * benchmark a fixed set such as provied by {@link
     * #newArrayThreadSet newArrayThreadSet} can reduce the overhead
     * of profiling.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.012 -0500", hash_original_method = "E2013E33C1696BCCD8E7E5A3F3F67C32", hash_generated_method = "6B9CBBB7363AB69129AD6A76DBC53284")
    
public SamplingProfiler(int depth, ThreadSet threadSet) {
        this.depth = depth;
        this.threadSet = threadSet;
        this.threadSampler = findDefaultThreadSampler();
        threadSampler.setDepth(depth);
        hprofData.setFlags(BinaryHprof.ControlSettings.CPU_SAMPLING.bitmask);
        hprofData.setDepth(depth);
    }

    /**
     * Starts profiler sampling at the specified rate.
     *
     * @param interval The number of milliseconds between samples
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.053 -0500", hash_original_method = "27D03994E61C1E4974C7BBD91A5CED76", hash_generated_method = "6C7456B016061B7F4120D2D843F60B55")
    
public void start(int interval) {
        if (interval < 1) {
            throw new IllegalArgumentException("interval < 1");
        }
        if (sampler != null) {
            throw new IllegalStateException("profiling already started");
        }
        sampler = new Sampler();
        hprofData.setStartMillis(System.currentTimeMillis());
        timer.scheduleAtFixedRate(sampler, 0, interval);
    }

    /**
     * Stops profiler sampling. It can be restarted with {@link
     * #start(int)} to continue sampling.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.056 -0500", hash_original_method = "67E3C9BA9A63DEAC75D61937C8B159A6", hash_generated_method = "A3E84E7E869E7895379C64DC36875096")
    
public void stop() {
        if (sampler == null) {
            return;
        }
        synchronized(sampler) {
            sampler.stop = true;
            while (!sampler.stopped) {
                try {
                    sampler.wait();
                } catch (InterruptedException ignored) {
                }
            }
        }
        sampler = null;
    }

    /**
     * Shuts down profiling after which it can not be restarted. It is
     * important to shut down profiling when done to free resources
     * used by the profiler. Shutting down the profiler also stops the
     * profiling if that has not already been done.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.058 -0500", hash_original_method = "E9FD5B0933A1848F685AEBC164A37AF6", hash_generated_method = "A0EFEC2CFE17D3F994F62D62C265521D")
    
public void shutdown() {
        stop();
        timer.cancel();
    }

    /**
     * Returns the hprof data accumulated by the profiler since it was
     * created. The profiler needs to be stopped, but not necessarily
     * shut down, in order to access the data. If the profiler is
     * restarted, there is no thread safe way to access the data.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.060 -0500", hash_original_method = "ED23570BD9F6C6F13BA5A80428CD13EC", hash_generated_method = "0B0D6C138CB6BCA4E38BFCCEE6C7339E")
    
public HprofData getHprofData() {
        if (sampler != null) {
            throw new IllegalStateException("cannot access hprof data while sampling");
        }
        return hprofData;
    }
    
    private static class ArrayThreadSet implements ThreadSet {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.023 -0500", hash_original_field = "4014BA6F6D360F06086C9315C721E47C", hash_generated_field = "8B8AD11FAF84DF554AF601CECEC03259")

        private  Thread[] threads;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.026 -0500", hash_original_method = "77E03C0451741A4E1C44419B134120C8", hash_generated_method = "C3C13985573064CE9B81E6160E9D46B0")
        
public ArrayThreadSet(Thread... threads) {
            if (threads == null) {
                throw new NullPointerException("threads == null");
            }
            this.threads = threads;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.029 -0500", hash_original_method = "5BD7766F6E0173FC433E1E7F289EB1BE", hash_generated_method = "21CDF0CFCE0505A92E1BBD0EE447F92A")
        
public Thread[] threads() {
            return threads;
        }
        
    }
    
    private static class ThreadGroupThreadSet implements ThreadSet {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.036 -0500", hash_original_field = "0F98259F009594C0EAECD9C2806ED897", hash_generated_field = "D74D206E5EAABCB0D7E64D0C4C1175DD")

        private  ThreadGroup threadGroup;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.039 -0500", hash_original_field = "4014BA6F6D360F06086C9315C721E47C", hash_generated_field = "8B8AD11FAF84DF554AF601CECEC03259")

        private Thread[] threads;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.041 -0500", hash_original_field = "9B5AC73CD362E77C68BAE380AFE90CE3", hash_generated_field = "DEAE23277D73F2DAC1D40D5B772DC02F")

        private int lastThread;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.044 -0500", hash_original_method = "A3C3F7BBDEF2CA8B1B158C093A73C39B", hash_generated_method = "64299EC2926A20EF709683F8C32A8B85")
        
public ThreadGroupThreadSet(ThreadGroup threadGroup) {
            if (threadGroup == null) {
                throw new NullPointerException("threadGroup == null");
            }
            this.threadGroup = threadGroup;
            resize();
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.046 -0500", hash_original_method = "634F6B8483D3410BA8D4C537A5664EC3", hash_generated_method = "4F206BBC8A865A4BA945A1AAC83FFB89")
        
private void resize() {
            int count = threadGroup.activeCount();
            // we can only tell if we had enough room for all active
            // threads if we actually are larger than the the number of
            // active threads. making it larger also leaves us room to
            // tolerate additional threads without resizing.
            threads = new Thread[count*2];
            lastThread = 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.049 -0500", hash_original_method = "32A384241C8D4460079A29E3C7BA2EEB", hash_generated_method = "94B94D0955BC2B91CC9DE8B982CF2AC3")
        
public Thread[] threads() {
            int threadCount;
            while (true) {
                threadCount = threadGroup.enumerate(threads);
                if (threadCount == threads.length) {
                    resize();
                } else {
                    break;
                }
            }
            if (threadCount < lastThread) {
                // avoid retaining pointers to threads that have ended
                Arrays.fill(threads, threadCount, lastThread, null);
            }
            lastThread = threadCount;
            return threads;
        }
        
    }
    
    private class Sampler extends TimerTask {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.064 -0500", hash_original_field = "CB4F0C1A424F33342F6A2D8F6FC06C55", hash_generated_field = "91757D5DBCDAA06E67EF5972E830A2B9")

        private boolean stop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.066 -0500", hash_original_field = "B0899FB375A0A57065DA66B38777B6C0", hash_generated_field = "BD6E6476D8652DE9C3E25371CF8C1362")

        private boolean stopped;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.068 -0500", hash_original_field = "368CA83D68B4BBE7822EC5ED4529AC7E", hash_generated_field = "194CA93403950BFAA6E74788498143CF")

        private Thread timerThread;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.045 -0400", hash_original_method = "CE87D296BDEBBC5B0D30A5ECC13871DD", hash_generated_method = "CE87D296BDEBBC5B0D30A5ECC13871DD")
        public Sampler ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.071 -0500", hash_original_method = "3FC3FC48F91B564D9AD79AA9DB2F74C2", hash_generated_method = "AED12429148026D8703D629D3D037125")
        
public void run() {
            synchronized(this) {
                if (stop) {
                    cancel();
                    stopped = true;
                    notifyAll();
                    return;
                }
            }

            if (timerThread == null) {
                timerThread = Thread.currentThread();
            }

            // process thread creation and death first so that we
            // assign thread ids to any new threads before allocating
            // new stacks for them
            Thread[] newThreads = threadSet.threads();
            if (!Arrays.equals(currentThreads, newThreads)) {
                updateThreadHistory(currentThreads, newThreads);
                currentThreads = newThreads.clone();
            }

            for (Thread thread : currentThreads) {
                if (thread == null) {
                    break;
                }
                if (thread == timerThread) {
                    continue;
                }

                StackTraceElement[] stackFrames = threadSampler.getStackTrace(thread);
                if (stackFrames == null) {
                    continue;
                }
                recordStackTrace(thread, stackFrames);
            }
        }

        /**
         * Record a new stack trace. The thread should have been
         * previously registered with addStartThread.
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.074 -0500", hash_original_method = "F11BBDF4101A6D713104B5DB9760A085", hash_generated_method = "4067A3AA11B7AEE60584EB4F50D11EA3")
        
private void recordStackTrace(Thread thread, StackTraceElement[] stackFrames) {
            Integer threadId = threadIds.get(thread);
            if (threadId == null) {
                throw new IllegalArgumentException("Unknown thread " + thread);
            }
            mutableStackTrace.threadId = threadId;
            mutableStackTrace.stackFrames = stackFrames;

            int[] countCell = stackTraces.get(mutableStackTrace);
            if (countCell == null) {
                countCell = new int[1];
                // cloned because the ThreadSampler may reuse the array
                StackTraceElement[] stackFramesCopy = stackFrames.clone();
                HprofData.StackTrace stackTrace
                        = new HprofData.StackTrace(nextStackTraceId++, threadId, stackFramesCopy);
                hprofData.addStackTrace(stackTrace, countCell);
            }
            countCell[0]++;
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.077 -0500", hash_original_method = "B49A7EC3437DE14BA292DE44FA40B97A", hash_generated_method = "782E2E3065A8F07031072AC423775A0D")
        
private void updateThreadHistory(Thread[] oldThreads, Thread[] newThreads) {
            // thread start/stop shouldn't happen too often and
            // these aren't too big, so hopefully this approach
            // won't be too slow...
            Set<Thread> n = new HashSet<Thread>(Arrays.asList(newThreads));
            Set<Thread> o = new HashSet<Thread>(Arrays.asList(oldThreads));

            // added = new-old
            Set<Thread> added = new HashSet<Thread>(n);
            added.removeAll(o);

            // removed = old-new
            Set<Thread> removed = new HashSet<Thread>(o);
            removed.removeAll(n);

            for (Thread thread : added) {
                if (thread == null) {
                    continue;
                }
                if (thread == timerThread) {
                    continue;
                }
                addStartThread(thread);
            }
            for (Thread thread : removed) {
                if (thread == null) {
                    continue;
                }
                if (thread == timerThread) {
                    continue;
                }
                addEndThread(thread);
            }
        }

        /**
         * Record that a newly noticed thread.
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.080 -0500", hash_original_method = "D7E70BFB99D4B0D69C428CA3433E6D0D", hash_generated_method = "5BB011C7DBE53407F8AE7B50A48EB795")
        
private void addStartThread(Thread thread) {
            if (thread == null) {
                throw new NullPointerException("thread == null");
            }
            int threadId = nextThreadId++;
            Integer old = threadIds.put(thread, threadId);
            if (old != null) {
                throw new IllegalArgumentException("Thread already registered as " + old);
            }

            String threadName = thread.getName();
            // group will become null when thread is terminated
            ThreadGroup group = thread.getThreadGroup();
            String groupName = group == null ? null : group.getName();
            ThreadGroup parentGroup = group == null ? null : group.getParent();
            String parentGroupName = parentGroup == null ? null : parentGroup.getName();

            HprofData.ThreadEvent event
                    = HprofData.ThreadEvent.start(nextObjectId++, threadId,
                                                  threadName, groupName, parentGroupName);
            hprofData.addThreadEvent(event);
        }

        /**
         * Record that a thread has disappeared.
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.084 -0500", hash_original_method = "631F90CADC4DC4D78F0863A31213AEA2", hash_generated_method = "A688B080478C127EFDDAD69CC5746D1D")
        
private void addEndThread(Thread thread) {
            if (thread == null) {
                throw new NullPointerException("thread == null");
            }
            Integer threadId = threadIds.remove(thread);
            if (threadId == null) {
                throw new IllegalArgumentException("Unknown thread " + thread);
            }
            HprofData.ThreadEvent event = HprofData.ThreadEvent.end(threadId);
            hprofData.addThreadEvent(event);
        }
        
    }
    
    public static interface ThreadSet {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public Thread[] threads();
    }
    
}

