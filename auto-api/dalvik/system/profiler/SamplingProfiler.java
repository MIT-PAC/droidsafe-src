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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.422 -0400", hash_original_field = "7866DB6D1CAD3E99097EE63747D20CDC", hash_generated_field = "2572F99AE826E3BA8AB64199CA3F4E1E")

    private Map<HprofData.StackTrace, int[]> stackTraces = new HashMap<HprofData.StackTrace, int[]>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.422 -0400", hash_original_field = "D3F69843432527D27B9F70243D4738E6", hash_generated_field = "7E3B3773D7D7D9F8C46BF6462A5FEF99")

    private HprofData hprofData = new HprofData(stackTraces);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.422 -0400", hash_original_field = "B2A1EC6A134051B2BECC350BA483F707", hash_generated_field = "311DE542AFBEE41C5DE93BA5F963BF01")

    private Timer timer = new Timer("SamplingProfiler", true);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.422 -0400", hash_original_field = "2B06A2251D39E28F8220696766DCD136", hash_generated_field = "B562247DC5E7C6FB74DB56F365094BB7")

    private Sampler sampler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.422 -0400", hash_original_field = "12A055BF01A31369FE81AC35D85C7BC1", hash_generated_field = "9E4E1D4E0DD2F9B43B1F6C7CB67C1409")

    private int depth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.422 -0400", hash_original_field = "2A2EAFF312975D3A7E09D22B9CCFCAD9", hash_generated_field = "8D44FD9456A73317948C7E807ED46A93")

    private ThreadSet threadSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.422 -0400", hash_original_field = "7F2BBDE4434C6D4803D9A3D2CEC94381", hash_generated_field = "35EE7CB938A7415269E60299D636CE4A")

    private int nextThreadId = 200001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.422 -0400", hash_original_field = "822A88F92A7A4ED470671D0922726D59", hash_generated_field = "3A74A24BBD1F02EFA2B8941E3667D65C")

    private int nextStackTraceId = 300001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.422 -0400", hash_original_field = "9EF789A0F64032D151127B5877D9AF59", hash_generated_field = "D8831A1D35C191C6860F2D253762F36B")

    private int nextObjectId = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.422 -0400", hash_original_field = "A2F63F97A4FA40E8B1432B72844E3D99", hash_generated_field = "956AF7D907252A038357B38A0B0DC19F")

    private Thread[] currentThreads = new Thread[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.422 -0400", hash_original_field = "B8B10EFC009F1FE82E85280803BEC216", hash_generated_field = "C488B6E7DD77B8429C99AB87075CDC2C")

    private Map<Thread, Integer> threadIds = new HashMap<Thread, Integer>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.422 -0400", hash_original_field = "91563BFC59C09EBB861EF7427C3AC2A5", hash_generated_field = "F3AB88F49019F5831024324EDACFFAEE")

    private HprofData.StackTrace mutableStackTrace = new HprofData.StackTrace();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.422 -0400", hash_original_field = "2FDFF0D7E588BE6078234AE8AAB725FF", hash_generated_field = "3A1BD9A3E1F8ED3ABCF715F52B0C955E")

    private ThreadSampler threadSampler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.428 -0400", hash_original_method = "E2013E33C1696BCCD8E7E5A3F3F67C32", hash_generated_method = "B76DB7C625B045DFE876895F1C48B5DF")
    public  SamplingProfiler(int depth, ThreadSet threadSet) {
        this.depth = depth;
        this.threadSet = threadSet;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.429 -0400", hash_original_method = "27D03994E61C1E4974C7BBD91A5CED76", hash_generated_method = "2705245FE9A54719445D9CA658697092")
    public void start(int interval) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("interval < 1");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("profiling already started");
        } //End block
        sampler = new Sampler();
        hprofData.setStartMillis(System.currentTimeMillis());
        timer.scheduleAtFixedRate(sampler, 0, interval);
        addTaint(interval);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.429 -0400", hash_original_method = "67E3C9BA9A63DEAC75D61937C8B159A6", hash_generated_method = "2F55F670185D8318E18E18355C5996E6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.435 -0400", hash_original_method = "E9FD5B0933A1848F685AEBC164A37AF6", hash_generated_method = "62A5E416FD9EC25C2C2402805D8B0333")
    public void shutdown() {
        stop();
        timer.cancel();
        // ---------- Original Method ----------
        //stop();
        //timer.cancel();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.440 -0400", hash_original_method = "ED23570BD9F6C6F13BA5A80428CD13EC", hash_generated_method = "71DCE7F912CA506594462B89199E1527")
    public HprofData getHprofData() {
        HprofData varB4EAC82CA7396A68D541C85D26508E83_1002971073 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("cannot access hprof data while sampling");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1002971073 = hprofData;
        varB4EAC82CA7396A68D541C85D26508E83_1002971073.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1002971073;
        // ---------- Original Method ----------
        //if (sampler != null) {
            //throw new IllegalStateException("cannot access hprof data while sampling");
        //}
        //return hprofData;
    }

    
    private static class ArrayThreadSet implements ThreadSet {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.440 -0400", hash_original_field = "0919FE44FDBBD233E5E2E8587006B7B2", hash_generated_field = "8B8AD11FAF84DF554AF601CECEC03259")

        private Thread[] threads;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.441 -0400", hash_original_method = "77E03C0451741A4E1C44419B134120C8", hash_generated_method = "9144D8AD8ABDD10332839396B3E1B8AF")
        public  ArrayThreadSet(Thread... threads) {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("threads == null");
            } //End block
            this.threads = threads;
            // ---------- Original Method ----------
            //if (threads == null) {
                //throw new NullPointerException("threads == null");
            //}
            //this.threads = threads;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.441 -0400", hash_original_method = "5BD7766F6E0173FC433E1E7F289EB1BE", hash_generated_method = "DD7ED8F509DA8A88CADA744DAA97A016")
        public Thread[] threads() {
            Thread[] varB4EAC82CA7396A68D541C85D26508E83_546197016 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_546197016 = threads;
            varB4EAC82CA7396A68D541C85D26508E83_546197016.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_546197016;
            // ---------- Original Method ----------
            //return threads;
        }

        
    }


    
    private static class ThreadGroupThreadSet implements ThreadSet {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.441 -0400", hash_original_field = "6BEAA1F97596278D78CCE1EF27DBF861", hash_generated_field = "D74D206E5EAABCB0D7E64D0C4C1175DD")

        private ThreadGroup threadGroup;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.441 -0400", hash_original_field = "0919FE44FDBBD233E5E2E8587006B7B2", hash_generated_field = "8B8AD11FAF84DF554AF601CECEC03259")

        private Thread[] threads;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.442 -0400", hash_original_field = "16EFE7F4BDC7C82D49050446A1F9B9F7", hash_generated_field = "DEAE23277D73F2DAC1D40D5B772DC02F")

        private int lastThread;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.442 -0400", hash_original_method = "A3C3F7BBDEF2CA8B1B158C093A73C39B", hash_generated_method = "CBE021A15AEE2CEA73FFEA75084614CD")
        public  ThreadGroupThreadSet(ThreadGroup threadGroup) {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("threadGroup == null");
            } //End block
            this.threadGroup = threadGroup;
            resize();
            // ---------- Original Method ----------
            //if (threadGroup == null) {
                //throw new NullPointerException("threadGroup == null");
            //}
            //this.threadGroup = threadGroup;
            //resize();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.447 -0400", hash_original_method = "634F6B8483D3410BA8D4C537A5664EC3", hash_generated_method = "78040ABA0C8A6E83671D059BA26C97C9")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.450 -0400", hash_original_method = "32A384241C8D4460079A29E3C7BA2EEB", hash_generated_method = "697B6F1B7CE446B7E6441D45F7102946")
        public Thread[] threads() {
            Thread[] varB4EAC82CA7396A68D541C85D26508E83_1393965936 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_1393965936 = threads;
            varB4EAC82CA7396A68D541C85D26508E83_1393965936.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1393965936;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.450 -0400", hash_original_field = "EF399B2D446BB37B7C32AD2CC1B6045B", hash_generated_field = "91757D5DBCDAA06E67EF5972E830A2B9")

        private boolean stop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.450 -0400", hash_original_field = "F0A0BFE6BC7D2C58D2989034F83183E0", hash_generated_field = "BD6E6476D8652DE9C3E25371CF8C1362")

        private boolean stopped;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.450 -0400", hash_original_field = "15B2BDA77D73E8B6CFA962C2D1BF5879", hash_generated_field = "194CA93403950BFAA6E74788498143CF")

        private Thread timerThread;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.450 -0400", hash_original_method = "CE87D296BDEBBC5B0D30A5ECC13871DD", hash_generated_method = "CE87D296BDEBBC5B0D30A5ECC13871DD")
        public Sampler ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.516 -0400", hash_original_method = "3FC3FC48F91B564D9AD79AA9DB2F74C2", hash_generated_method = "2C934737FE7144A855830F7FD4444CE1")
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
                boolean var0F1FEDD279682D3FF1BADDAE0138F716_1458241964 = (!Arrays.equals(currentThreads, newThreads));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.529 -0400", hash_original_method = "F11BBDF4101A6D713104B5DB9760A085", hash_generated_method = "0E9C5E87F2214451576D38BBFC1AFBB1")
        private void recordStackTrace(Thread thread, StackTraceElement[] stackFrames) {
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
            addTaint(thread.getTaint());
            addTaint(stackFrames[0].getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.566 -0400", hash_original_method = "B49A7EC3437DE14BA292DE44FA40B97A", hash_generated_method = "D26D3C3995FCA6BBFB9ABC1A6667AA5D")
        private void updateThreadHistory(Thread[] oldThreads, Thread[] newThreads) {
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
                Iterator<Thread> var72E8A17AE610D2FCC3673AAD53285BD6_266163956 = (added).iterator();
                var72E8A17AE610D2FCC3673AAD53285BD6_266163956.hasNext();
                Thread thread = var72E8A17AE610D2FCC3673AAD53285BD6_266163956.next();
                {
                    addStartThread(thread);
                } //End block
            } //End collapsed parenthetic
            {
                Iterator<Thread> varB1F20EA814E14D4F55D52568568B3272_399325680 = (removed).iterator();
                varB1F20EA814E14D4F55D52568568B3272_399325680.hasNext();
                Thread thread = varB1F20EA814E14D4F55D52568568B3272_399325680.next();
                {
                    addEndThread(thread);
                } //End block
            } //End collapsed parenthetic
            addTaint(oldThreads[0].getTaint());
            addTaint(newThreads[0].getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.569 -0400", hash_original_method = "D7E70BFB99D4B0D69C428CA3433E6D0D", hash_generated_method = "FD79450F3651E797E256BA165587FA15")
        private void addStartThread(Thread thread) {
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
            addTaint(thread.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.569 -0400", hash_original_method = "631F90CADC4DC4D78F0863A31213AEA2", hash_generated_method = "25C6B504FEAB45FB59AAEE9FDA2F9EE8")
        private void addEndThread(Thread thread) {
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
            addTaint(thread.getTaint());
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

