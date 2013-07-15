package dalvik.system.profiler;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public final class SamplingProfiler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.027 -0400", hash_original_field = "7866DB6D1CAD3E99097EE63747D20CDC", hash_generated_field = "C152621F50161C6F4001CF97446A8451")

    private final Map<HprofData.StackTrace, int[]> stackTraces = new HashMap<HprofData.StackTrace, int[]>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.027 -0400", hash_original_field = "D3F69843432527D27B9F70243D4738E6", hash_generated_field = "F415E27C9756B61B500D699D2023DCBE")

    private final HprofData hprofData = new HprofData(stackTraces);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.027 -0400", hash_original_field = "B2A1EC6A134051B2BECC350BA483F707", hash_generated_field = "5257F3CDD26BE88471BAA3D827A1AB12")

    private final Timer timer = new Timer("SamplingProfiler", true);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.027 -0400", hash_original_field = "2B06A2251D39E28F8220696766DCD136", hash_generated_field = "B562247DC5E7C6FB74DB56F365094BB7")

    private Sampler sampler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.028 -0400", hash_original_field = "12A055BF01A31369FE81AC35D85C7BC1", hash_generated_field = "9E4E1D4E0DD2F9B43B1F6C7CB67C1409")

    private int depth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.028 -0400", hash_original_field = "2A2EAFF312975D3A7E09D22B9CCFCAD9", hash_generated_field = "8D44FD9456A73317948C7E807ED46A93")

    private ThreadSet threadSet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.028 -0400", hash_original_field = "7F2BBDE4434C6D4803D9A3D2CEC94381", hash_generated_field = "35EE7CB938A7415269E60299D636CE4A")

    private int nextThreadId = 200001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.028 -0400", hash_original_field = "822A88F92A7A4ED470671D0922726D59", hash_generated_field = "3A74A24BBD1F02EFA2B8941E3667D65C")

    private int nextStackTraceId = 300001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.028 -0400", hash_original_field = "9EF789A0F64032D151127B5877D9AF59", hash_generated_field = "D8831A1D35C191C6860F2D253762F36B")

    private int nextObjectId = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.028 -0400", hash_original_field = "A2F63F97A4FA40E8B1432B72844E3D99", hash_generated_field = "956AF7D907252A038357B38A0B0DC19F")

    private Thread[] currentThreads = new Thread[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.028 -0400", hash_original_field = "B8B10EFC009F1FE82E85280803BEC216", hash_generated_field = "F0D9524D154438AC2ADFB8BD79774D4B")

    private final Map<Thread, Integer> threadIds = new HashMap<Thread, Integer>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.028 -0400", hash_original_field = "91563BFC59C09EBB861EF7427C3AC2A5", hash_generated_field = "518C2C85A6D73F9426E4B044DBE9A0B5")

    private final HprofData.StackTrace mutableStackTrace = new HprofData.StackTrace();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.028 -0400", hash_original_field = "2FDFF0D7E588BE6078234AE8AAB725FF", hash_generated_field = "3A1BD9A3E1F8ED3ABCF715F52B0C955E")

    private ThreadSampler threadSampler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.029 -0400", hash_original_method = "E2013E33C1696BCCD8E7E5A3F3F67C32", hash_generated_method = "B76DB7C625B045DFE876895F1C48B5DF")
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

    
        @DSModeled(DSC.BAN)
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

    
        @DSModeled(DSC.BAN)
    public static ThreadSet newThreadGroupTheadSet(ThreadGroup threadGroup) {
        return new ThreadGroupThreadSet(threadGroup);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.031 -0400", hash_original_method = "27D03994E61C1E4974C7BBD91A5CED76", hash_generated_method = "89C08EEE429592B6AEB20F7B85DCB500")
    public void start(int interval) {
        addTaint(interval);
    if(interval < 1)        
        {
            IllegalArgumentException var794F692BC1032CF0D8D616A6F96EC22C_1012261386 = new IllegalArgumentException("interval < 1");
            var794F692BC1032CF0D8D616A6F96EC22C_1012261386.addTaint(taint);
            throw var794F692BC1032CF0D8D616A6F96EC22C_1012261386;
        } //End block
    if(sampler != null)        
        {
            IllegalStateException var5ED3F8A5F822F4D84B55231116591162_1729487390 = new IllegalStateException("profiling already started");
            var5ED3F8A5F822F4D84B55231116591162_1729487390.addTaint(taint);
            throw var5ED3F8A5F822F4D84B55231116591162_1729487390;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.032 -0400", hash_original_method = "67E3C9BA9A63DEAC75D61937C8B159A6", hash_generated_method = "F9E263991FB21D850EAF5C968D85AAAA")
    public void stop() {
    if(sampler == null)        
        {
            return;
        } //End block
        synchronized
(sampler)        {
            sampler.stop = true;
            while
(!sampler.stopped)            
            {
                try 
                {
                    sampler.wait();
                } //End block
                catch (InterruptedException ignored)
                {
                } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.032 -0400", hash_original_method = "E9FD5B0933A1848F685AEBC164A37AF6", hash_generated_method = "62A5E416FD9EC25C2C2402805D8B0333")
    public void shutdown() {
        stop();
        timer.cancel();
        // ---------- Original Method ----------
        //stop();
        //timer.cancel();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.033 -0400", hash_original_method = "ED23570BD9F6C6F13BA5A80428CD13EC", hash_generated_method = "2A6A537E5F2AFD9D8B7664DCCB2B18C2")
    public HprofData getHprofData() {
    if(sampler != null)        
        {
            IllegalStateException varFDCC8B667CCE424A2920AB5B7B905509_1118696501 = new IllegalStateException("cannot access hprof data while sampling");
            varFDCC8B667CCE424A2920AB5B7B905509_1118696501.addTaint(taint);
            throw varFDCC8B667CCE424A2920AB5B7B905509_1118696501;
        } //End block
HprofData varED34D148516840494CB2AFCDA086D3AF_1096977522 =         hprofData;
        varED34D148516840494CB2AFCDA086D3AF_1096977522.addTaint(taint);
        return varED34D148516840494CB2AFCDA086D3AF_1096977522;
        // ---------- Original Method ----------
        //if (sampler != null) {
            //throw new IllegalStateException("cannot access hprof data while sampling");
        //}
        //return hprofData;
    }

    
    private static class ArrayThreadSet implements ThreadSet {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.033 -0400", hash_original_field = "0919FE44FDBBD233E5E2E8587006B7B2", hash_generated_field = "8B8AD11FAF84DF554AF601CECEC03259")

        private Thread[] threads;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.033 -0400", hash_original_method = "77E03C0451741A4E1C44419B134120C8", hash_generated_method = "D514E5A94E051ADC3DDBFCF2D54535B3")
        public  ArrayThreadSet(Thread... threads) {
    if(threads == null)            
            {
                NullPointerException var258B69D0D4A2C1357E11EC34983461F7_1576147329 = new NullPointerException("threads == null");
                var258B69D0D4A2C1357E11EC34983461F7_1576147329.addTaint(taint);
                throw var258B69D0D4A2C1357E11EC34983461F7_1576147329;
            } //End block
            this.threads = threads;
            // ---------- Original Method ----------
            //if (threads == null) {
                //throw new NullPointerException("threads == null");
            //}
            //this.threads = threads;
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.034 -0400", hash_original_method = "5BD7766F6E0173FC433E1E7F289EB1BE", hash_generated_method = "935E2B3BB6CD57CE4AAD031D80B9FCEB")
        public Thread[] threads() {
Thread[] var67CF445A22B0B72AFF038F817DEEC61B_1386471828 =             threads;
            var67CF445A22B0B72AFF038F817DEEC61B_1386471828.addTaint(taint);
            return var67CF445A22B0B72AFF038F817DEEC61B_1386471828;
            // ---------- Original Method ----------
            //return threads;
        }

        
    }


    
    private static class ThreadGroupThreadSet implements ThreadSet {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.034 -0400", hash_original_field = "6BEAA1F97596278D78CCE1EF27DBF861", hash_generated_field = "D74D206E5EAABCB0D7E64D0C4C1175DD")

        private ThreadGroup threadGroup;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.034 -0400", hash_original_field = "0919FE44FDBBD233E5E2E8587006B7B2", hash_generated_field = "8B8AD11FAF84DF554AF601CECEC03259")

        private Thread[] threads;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.034 -0400", hash_original_field = "16EFE7F4BDC7C82D49050446A1F9B9F7", hash_generated_field = "DEAE23277D73F2DAC1D40D5B772DC02F")

        private int lastThread;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.034 -0400", hash_original_method = "A3C3F7BBDEF2CA8B1B158C093A73C39B", hash_generated_method = "632C96C2D961A7E346F7C616D3A7D098")
        public  ThreadGroupThreadSet(ThreadGroup threadGroup) {
    if(threadGroup == null)            
            {
                NullPointerException varCDAFA6034E5A6DEDBED6DC7A39334ED6_1216262971 = new NullPointerException("threadGroup == null");
                varCDAFA6034E5A6DEDBED6DC7A39334ED6_1216262971.addTaint(taint);
                throw varCDAFA6034E5A6DEDBED6DC7A39334ED6_1216262971;
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

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.035 -0400", hash_original_method = "634F6B8483D3410BA8D4C537A5664EC3", hash_generated_method = "0ABB5E8BF62D0F7A316F1DDBBCEFC259")
        private void resize() {
            int count = threadGroup.activeCount();
            threads = new Thread[count*2];
            lastThread = 0;
            // ---------- Original Method ----------
            //int count = threadGroup.activeCount();
            //threads = new Thread[count*2];
            //lastThread = 0;
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.036 -0400", hash_original_method = "32A384241C8D4460079A29E3C7BA2EEB", hash_generated_method = "85A7BF57753AC88D810AE58DE84CD2AF")
        public Thread[] threads() {
            int threadCount;
            while
(true)            
            {
                threadCount = threadGroup.enumerate(threads);
    if(threadCount == threads.length)                
                {
                    resize();
                } //End block
                else
                {
                    break;
                } //End block
            } //End block
    if(threadCount < lastThread)            
            {
                Arrays.fill(threads, threadCount, lastThread, null);
            } //End block
            lastThread = threadCount;
Thread[] var67CF445A22B0B72AFF038F817DEEC61B_1370469589 =             threads;
            var67CF445A22B0B72AFF038F817DEEC61B_1370469589.addTaint(taint);
            return var67CF445A22B0B72AFF038F817DEEC61B_1370469589;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.036 -0400", hash_original_field = "EF399B2D446BB37B7C32AD2CC1B6045B", hash_generated_field = "91757D5DBCDAA06E67EF5972E830A2B9")

        private boolean stop;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.036 -0400", hash_original_field = "F0A0BFE6BC7D2C58D2989034F83183E0", hash_generated_field = "BD6E6476D8652DE9C3E25371CF8C1362")

        private boolean stopped;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.036 -0400", hash_original_field = "15B2BDA77D73E8B6CFA962C2D1BF5879", hash_generated_field = "194CA93403950BFAA6E74788498143CF")

        private Thread timerThread;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.036 -0400", hash_original_method = "CE87D296BDEBBC5B0D30A5ECC13871DD", hash_generated_method = "CE87D296BDEBBC5B0D30A5ECC13871DD")
        public Sampler ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.037 -0400", hash_original_method = "3FC3FC48F91B564D9AD79AA9DB2F74C2", hash_generated_method = "C93F15E37D57A7DDDAB6892502AEC0BA")
        public void run() {
            synchronized
(this)            {
    if(stop)                
                {
                    cancel();
                    stopped = true;
                    notifyAll();
                    return;
                } //End block
            } //End block
    if(timerThread == null)            
            {
                timerThread = Thread.currentThread();
            } //End block
            Thread[] newThreads = threadSet.threads();
    if(!Arrays.equals(currentThreads, newThreads))            
            {
                updateThreadHistory(currentThreads, newThreads);
                currentThreads = newThreads.clone();
            } //End block
for(Thread thread : currentThreads)
            {
    if(thread == null)                
                {
                    break;
                } //End block
    if(thread == timerThread)                
                {
                    continue;
                } //End block
                StackTraceElement[] stackFrames = threadSampler.getStackTrace(thread);
    if(stackFrames == null)                
                {
                    continue;
                } //End block
                recordStackTrace(thread, stackFrames);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.038 -0400", hash_original_method = "F11BBDF4101A6D713104B5DB9760A085", hash_generated_method = "8F6DBA28B8FE39359C1C3D9DD5258F1A")
        private void recordStackTrace(Thread thread, StackTraceElement[] stackFrames) {
            addTaint(stackFrames[0].getTaint());
            addTaint(thread.getTaint());
            Integer threadId = threadIds.get(thread);
    if(threadId == null)            
            {
                IllegalArgumentException varB4CF2BD55112C1CED34A8923E8F43362_240231285 = new IllegalArgumentException("Unknown thread " + thread);
                varB4CF2BD55112C1CED34A8923E8F43362_240231285.addTaint(taint);
                throw varB4CF2BD55112C1CED34A8923E8F43362_240231285;
            } //End block
            mutableStackTrace.threadId = threadId;
            mutableStackTrace.stackFrames = stackFrames;
            int[] countCell = stackTraces.get(mutableStackTrace);
    if(countCell == null)            
            {
                countCell = new int[1];
                StackTraceElement[] stackFramesCopy = stackFrames.clone();
                HprofData.StackTrace stackTrace = new HprofData.StackTrace(nextStackTraceId++, threadId, stackFramesCopy);
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

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.039 -0400", hash_original_method = "B49A7EC3437DE14BA292DE44FA40B97A", hash_generated_method = "4D3C0F75BDB35EB440EF1B5D6B51AE7B")
        private void updateThreadHistory(Thread[] oldThreads, Thread[] newThreads) {
            addTaint(newThreads[0].getTaint());
            addTaint(oldThreads[0].getTaint());
            Set<Thread> n = new HashSet<Thread>(Arrays.asList(newThreads));
            Set<Thread> o = new HashSet<Thread>(Arrays.asList(oldThreads));
            Set<Thread> added = new HashSet<Thread>(n);
            added.removeAll(o);
            Set<Thread> removed = new HashSet<Thread>(o);
            removed.removeAll(n);
for(Thread thread : added)
            {
    if(thread == null)                
                {
                    continue;
                } //End block
    if(thread == timerThread)                
                {
                    continue;
                } //End block
                addStartThread(thread);
            } //End block
for(Thread thread : removed)
            {
    if(thread == null)                
                {
                    continue;
                } //End block
    if(thread == timerThread)                
                {
                    continue;
                } //End block
                addEndThread(thread);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.040 -0400", hash_original_method = "D7E70BFB99D4B0D69C428CA3433E6D0D", hash_generated_method = "18D3EC400DDDCACC4A696B9FA5EFA1BA")
        private void addStartThread(Thread thread) {
            addTaint(thread.getTaint());
    if(thread == null)            
            {
                NullPointerException var8BA1A1DD61D992C72EF6A20FC49A560E_532962339 = new NullPointerException("thread == null");
                var8BA1A1DD61D992C72EF6A20FC49A560E_532962339.addTaint(taint);
                throw var8BA1A1DD61D992C72EF6A20FC49A560E_532962339;
            } //End block
            int threadId = nextThreadId++;
            Integer old = threadIds.put(thread, threadId);
    if(old != null)            
            {
                IllegalArgumentException varA8BFE586E288E5CBAD29016D9A621FB0_763804309 = new IllegalArgumentException("Thread already registered as " + old);
                varA8BFE586E288E5CBAD29016D9A621FB0_763804309.addTaint(taint);
                throw varA8BFE586E288E5CBAD29016D9A621FB0_763804309;
            } //End block
            String threadName = thread.getName();
            ThreadGroup group = thread.getThreadGroup();
            String groupName = group == null ? null : group.getName();
            ThreadGroup parentGroup = group == null ? null : group.getParent();
            String parentGroupName = parentGroup == null ? null : parentGroup.getName();
            HprofData.ThreadEvent event = HprofData.ThreadEvent.start(nextObjectId++, threadId,
                                                  threadName, groupName, parentGroupName);
            hprofData.addThreadEvent(event);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.041 -0400", hash_original_method = "631F90CADC4DC4D78F0863A31213AEA2", hash_generated_method = "5177424C0A265153A3AC2FF4C4886B6A")
        private void addEndThread(Thread thread) {
            addTaint(thread.getTaint());
    if(thread == null)            
            {
                NullPointerException var8BA1A1DD61D992C72EF6A20FC49A560E_14820023 = new NullPointerException("thread == null");
                var8BA1A1DD61D992C72EF6A20FC49A560E_14820023.addTaint(taint);
                throw var8BA1A1DD61D992C72EF6A20FC49A560E_14820023;
            } //End block
            Integer threadId = threadIds.remove(thread);
    if(threadId == null)            
            {
                IllegalArgumentException varB4CF2BD55112C1CED34A8923E8F43362_501730967 = new IllegalArgumentException("Unknown thread " + thread);
                varB4CF2BD55112C1CED34A8923E8F43362_501730967.addTaint(taint);
                throw varB4CF2BD55112C1CED34A8923E8F43362_501730967;
            } //End block
            HprofData.ThreadEvent event = HprofData.ThreadEvent.end(threadId);
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

