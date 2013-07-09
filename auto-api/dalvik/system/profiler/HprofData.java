package dalvik.system.profiler;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;

public final class HprofData {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.055 -0400", hash_original_field = "B9A6573709935C9B3FECAA4DEC3B7269", hash_generated_field = "3F4204ABC43917BE7A39B6FD85E75A38")

    private long startMillis;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.055 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "C01DA7975DA485EEDBF522635D053B3B")

    private int flags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.055 -0400", hash_original_field = "12A055BF01A31369FE81AC35D85C7BC1", hash_generated_field = "9E4E1D4E0DD2F9B43B1F6C7CB67C1409")

    private int depth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.055 -0400", hash_original_field = "79C1034D7397FA5B6459F68812FA26AA", hash_generated_field = "EBD0F48FF63E7A93B0B5B1649E0D9BEE")

    private final List<ThreadEvent> threadHistory = new ArrayList<ThreadEvent>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.055 -0400", hash_original_field = "FB662DEE8F61DD38591C8A93726EB143", hash_generated_field = "5C4F57CC1BAFED6BB9221F867FA6736B")

    private final Map<Integer, ThreadEvent> threadIdToThreadEvent = new HashMap<Integer, ThreadEvent>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.055 -0400", hash_original_field = "580229FDC7FA8EFE701CD2061D469688", hash_generated_field = "2E2E6C57E5FA37C42CB4DC1BB6563D4D")

    private Map<HprofData.StackTrace, int[]> stackTraces;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.055 -0400", hash_original_method = "A1B0101007C345DF1FDD21D474244925", hash_generated_method = "9495FB0F7CC531BE07007EC718608206")
    public  HprofData(Map<StackTrace, int[]> stackTraces) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("stackTraces == null");
        } 
        this.stackTraces = stackTraces;
        
        
            
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.055 -0400", hash_original_method = "CC766E32F9FC42071F3CC3CB88E9A18A", hash_generated_method = "B248CB0816DADB76F203C2C590FE73D3")
    public long getStartMillis() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2029881342 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2029881342;
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.056 -0400", hash_original_method = "B0BB2E1F2492EC486CB4460593218E46", hash_generated_method = "32E114486602338DC0FFC6C493371EE3")
    public void setStartMillis(long startMillis) {
        this.startMillis = startMillis;
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.056 -0400", hash_original_method = "292C3EF40E00AFB28AC60AF92A04DB70", hash_generated_method = "F9436BA22E30B07472BA6D81605FFF53")
    public int getFlags() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1985953678 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1985953678;
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.056 -0400", hash_original_method = "E55E0ED6FE66EB0D458BFDED224C9943", hash_generated_method = "F61A3B65ECD9BA445206989DF2EF1A1F")
    public void setFlags(int flags) {
        this.flags = flags;
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.056 -0400", hash_original_method = "FBD5046615AAE9EDCC3CA2ADE86A92C3", hash_generated_method = "263F311861B7D4AC8A2823F1BF5D2F83")
    public int getDepth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1448025043 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1448025043;
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.056 -0400", hash_original_method = "7E87B9040AF172D5ADB37F7AF7F75CA6", hash_generated_method = "FFC7D812D0FFB494BA967C34F7E21CCC")
    public void setDepth(int depth) {
        this.depth = depth;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.057 -0400", hash_original_method = "8C7F14531209B0BE4CB8ACECEBC720CC", hash_generated_method = "C3E5F166DDD11FA946412B762A206E28")
    public List<ThreadEvent> getThreadHistory() {
        List<ThreadEvent> varB4EAC82CA7396A68D541C85D26508E83_357137246 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_357137246 = Collections.unmodifiableList(threadHistory);
        varB4EAC82CA7396A68D541C85D26508E83_357137246.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_357137246;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.064 -0400", hash_original_method = "F4E32CE6895396BD588CC20D263E2FB4", hash_generated_method = "F31DA47C096889D17B8E513E22E8B70A")
    public Set<Sample> getSamples() {
        Set<Sample> varB4EAC82CA7396A68D541C85D26508E83_129841385 = null; 
        Set<Sample> samples = new HashSet<Sample>(stackTraces.size());
        {
            Iterator<Entry<StackTrace, int[]>> var90BB71089607029678F04EF3DD4C4774_1298533215 = (stackTraces.entrySet()).iterator();
            var90BB71089607029678F04EF3DD4C4774_1298533215.hasNext();
            Entry<StackTrace, int[]> e = var90BB71089607029678F04EF3DD4C4774_1298533215.next();
            {
                StackTrace stackTrace = e.getKey();
                int countCell[] = e.getValue();
                int count = countCell[0];
                Sample sample = new Sample(stackTrace, count);
                samples.add(sample);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_129841385 = samples;
        varB4EAC82CA7396A68D541C85D26508E83_129841385.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_129841385;
        
        
        
            
            
            
            
            
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.065 -0400", hash_original_method = "3644EE7A7CD6AEAD3C58A3E47BD5EAC7", hash_generated_method = "338819FD6CEB162E08D2114A3EF1A10A")
    public void addThreadEvent(ThreadEvent event) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("event == null");
        } 
        ThreadEvent old = threadIdToThreadEvent.put(event.threadId, event);
        
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("ThreadEvent already registered for id "
                                                       + event.threadId);
        } 
        
        
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Duplicate ThreadEvent.end for id "
                                                       + event.threadId);
        } 
        
        threadHistory.add(event);
        addTaint(event.getTaint());
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.065 -0400", hash_original_method = "ED310F254F72ACCB3181D18F31C09E67", hash_generated_method = "70CB2C60B267D45FE0CED6A9C85EF762")
    public void addStackTrace(StackTrace stackTrace, int[] countCell) {
        {
            boolean varF730A1A3EABF99869C11ED3AF87B008F_1108894586 = (!threadIdToThreadEvent.containsKey(stackTrace.threadId));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown thread id " + stackTrace.threadId);
            } 
        } 
        int[] old = stackTraces.put(stackTrace, countCell);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("StackTrace already registered for id "
                                               + stackTrace.stackTraceId + ":\n" + stackTrace);
        } 
        addTaint(stackTrace.getTaint());
        addTaint(countCell[0]);
        
        
            
        
        
        
            
                                               
        
    }

    
    public static enum ThreadEventType { START, END }

    
    public static final class ThreadEvent {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.065 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "7D87225C2426FF111F6FEB910554E402")

        public ThreadEventType type;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.065 -0400", hash_original_field = "16B2B26000987FACCB260B9D39DF1269", hash_generated_field = "50DDAAE60FEC6646E9C40B14D16B89C4")

        public int objectId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.065 -0400", hash_original_field = "61DC2BD347732448287F2A6771F304D8", hash_generated_field = "F04E415998CFF5C3E3E3A9ABC2303E69")

        public int threadId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.065 -0400", hash_original_field = "4810534ACF4D829946E1AC0A954285B9", hash_generated_field = "113B76C8DC7050E98D3CE8623AE010CB")

        public String threadName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.065 -0400", hash_original_field = "A2B861D0E7719D9108522AACFD4181BC", hash_generated_field = "93B2A487547CBE3E3CA82EF8BA52C0EE")

        public String groupName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.065 -0400", hash_original_field = "41866721A70EAC235AF31A5AD4E3B6DD", hash_generated_field = "CA659A31009B2F91CD0C2968AC161B2C")

        public String parentGroupName;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.066 -0400", hash_original_method = "418862520135AFAF9D5B41BB00EA7C53", hash_generated_method = "4EA439894D1EE123896B2FF7BACDB21C")
        private  ThreadEvent(ThreadEventType type, int objectId, int threadId,
                            String threadName, String groupName, String parentGroupName) {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("threadName == null");
            } 
            this.type = ThreadEventType.START;
            this.objectId = objectId;
            this.threadId = threadId;
            this.threadName = threadName;
            this.groupName = groupName;
            this.parentGroupName = parentGroupName;
            
            
                
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.066 -0400", hash_original_method = "87F2300773E111C1834911C7597238E6", hash_generated_method = "9601CB79B6EA603856556CF9BC4D5103")
        private  ThreadEvent(ThreadEventType type, int threadId) {
            this.type = ThreadEventType.END;
            this.objectId = -1;
            this.threadId = threadId;
            this.threadName = null;
            this.groupName = null;
            this.parentGroupName = null;
            
            
            
            
            
            
            
        }

        
                @DSModeled(DSC.BAN)
        public static ThreadEvent start(int objectId, int threadId, String threadName,
                                        String groupName, String parentGroupName) {
            return new ThreadEvent(ThreadEventType.START, objectId, threadId,
                                   threadName, groupName, parentGroupName);
        }

        
                @DSModeled(DSC.BAN)
        public static ThreadEvent end(int threadId) {
            return new ThreadEvent(ThreadEventType.END, threadId);
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.072 -0400", hash_original_method = "FD54D2802DF7D246F84571D313E0773D", hash_generated_method = "D1108B2896A11C51E36A612451851C6D")
        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + objectId;
            result = 31 * result + threadId;
            result = 31 * result + hashCode(threadName);
            result = 31 * result + hashCode(groupName);
            result = 31 * result + hashCode(parentGroupName);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1429360751 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1429360751;
            
            
            
            
            
            
            
            
        }

        
                @DSModeled(DSC.BAN)
        private static int hashCode(Object o) {
            return (o == null) ? 0 : o.hashCode();
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.073 -0400", hash_original_method = "11A9724AFC12A4881460E902B1AEFFA3", hash_generated_method = "65D6E34D80F643B7F8A28BF0F96DAE68")
        @Override
        public boolean equals(Object o) {
            ThreadEvent event = (ThreadEvent) o;
            boolean var4A4581E64171586ED6B283FBA9E8FB21_1924865891 = ((this.type == event.type
                    && this.objectId == event.objectId
                    && this.threadId == event.threadId
                    && equal(this.threadName, event.threadName)
                    && equal(this.groupName, event.groupName)
                    && equal(this.parentGroupName, event.parentGroupName)));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_264653393 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_264653393;
            
            
                
            
            
            
                    
                    
                    
                    
                    
        }

        
                @DSModeled(DSC.BAN)
        private static boolean equal(Object a, Object b) {
            return a == b || (a != null && a.equals(b));
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.074 -0400", hash_original_method = "B2760D4380298F8E4BDF009F5947B547", hash_generated_method = "8F9D65EE5FD1CBB76D6CBCCB4CFF4494")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1013603380 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_1605857930 = null; 
            
            varB4EAC82CA7396A68D541C85D26508E83_1013603380 = String.format(
                            "THREAD START (obj=%d, id = %d, name=\"%s\", group=\"%s\")",
                            objectId, threadId, threadName, groupName);
            
            
            varB4EAC82CA7396A68D541C85D26508E83_1605857930 = String.format("THREAD END (id = %d)", threadId);
            
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(type.toString());
            String varA7E53CE21691AB073D9660D615818899_1304261715; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1304261715 = varB4EAC82CA7396A68D541C85D26508E83_1013603380;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1304261715 = varB4EAC82CA7396A68D541C85D26508E83_1605857930;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1304261715.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1304261715;
            
            
                
                    
                            
                            
                
                    
            
            
        }

        
    }


    
    public static final class StackTrace {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.074 -0400", hash_original_field = "5A1B7B013BF1B5500278A118121BAFD2", hash_generated_field = "4628C5C3D0941960F68046E7C771CD60")

        public int stackTraceId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.074 -0400", hash_original_field = "61DC2BD347732448287F2A6771F304D8", hash_generated_field = "21BB19B62D16F0B2F30983971184762D")

        int threadId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.074 -0400", hash_original_field = "BA28502755EA3671FD39FBD3FFA05E42", hash_generated_field = "088C6E829F236000DB4EE42B0CB07B24")

        StackTraceElement[] stackFrames;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.074 -0400", hash_original_method = "937A3F2A08E08A14F8EC24A94B9A8468", hash_generated_method = "B8B05431485364C1F4F77D04A35AC9F2")
          StackTrace() {
            this.stackTraceId = -1;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.075 -0400", hash_original_method = "D4A1391652F07F93D8818AA4C8761514", hash_generated_method = "CEC68BA887B17DB2F0DC64DA5E4F1807")
        public  StackTrace(int stackTraceId, int threadId, StackTraceElement[] stackFrames) {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("stackFrames == null");
            } 
            this.stackTraceId = stackTraceId;
            this.threadId = threadId;
            this.stackFrames = stackFrames;
            
            
                
            
            
            
            
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.075 -0400", hash_original_method = "904149F69266C7F1ED9811C71073DCCC", hash_generated_method = "45B020A46A7BF635E6C322977C46CB3A")
        public int getThreadId() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2046741135 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2046741135;
            
            
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.076 -0400", hash_original_method = "825D6A57778B026225A4AA6FF793AA6E", hash_generated_method = "A6074E76A31D44F42ABAADE00B99E8DF")
        public StackTraceElement[] getStackFrames() {
            StackTraceElement[] varB4EAC82CA7396A68D541C85D26508E83_1959729994 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1959729994 = stackFrames;
            varB4EAC82CA7396A68D541C85D26508E83_1959729994.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1959729994;
            
            
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.076 -0400", hash_original_method = "E0B79EC3EEC67C907668B24F8C3EF7D1", hash_generated_method = "ECE21444546DA09A07FD5D65CE2AEB31")
        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + threadId;
            result = 31 * result + Arrays.hashCode(stackFrames);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2122904945 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2122904945;
            
            
            
            
            
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.077 -0400", hash_original_method = "A370788F6EF207DC60ADB1FE1413BF45", hash_generated_method = "6722D1929D95996D1EB404135C35DDA8")
        @Override
        public boolean equals(Object o) {
            StackTrace s = (StackTrace) o;
            boolean varB7031E8E3AFE83BB1AAB81E860AA93C0_2070052938 = (threadId == s.threadId && Arrays.equals(stackFrames, s.stackFrames));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1871880532 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1871880532;
            
            
                
            
            
            
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.086 -0400", hash_original_method = "2C975038FABEA62C51E7521430E68593", hash_generated_method = "E796FC4CE82F7ACBEDFDE7780C126F29")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_2124514530 = null; 
            StringBuilder frames = new StringBuilder();
            {
                frames.append('\n');
                {
                    StackTraceElement stackFrame = stackFrames[0];
                    {
                        frames.append("\t at ");
                        frames.append(stackFrame);
                        frames.append('\n');
                    } 
                } 
            } 
            {
                frames.append("<empty>");
            } 
            varB4EAC82CA7396A68D541C85D26508E83_2124514530 = "StackTrace[stackTraceId=" + stackTraceId
                    + ", threadId=" + threadId
                    + ", frames=" + frames + "]";
            varB4EAC82CA7396A68D541C85D26508E83_2124514530.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2124514530;
            
            
            
                
                
                    
                    
                    
                
            
                
            
            
                    
                    
        }

        
    }


    
    public static final class Sample {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.086 -0400", hash_original_field = "FCD4E36FD80F450979495718DBDDAACF", hash_generated_field = "3CCE78B4D1712F23531BA45DE99ABF0D")

        public StackTrace stackTrace;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.086 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "21B1DF5337CCD3E0731435FB1361ED67")

        public int count;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.088 -0400", hash_original_method = "8A8A799FE1363281492F811288A07E90", hash_generated_method = "E56FFA7D550B53B389BAB315057562CE")
        private  Sample(StackTrace stackTrace, int count) {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("stackTrace == null");
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("count < 0:" + count);
            } 
            this.stackTrace = stackTrace;
            this.count = count;
            
            
                
            
            
                
            
            
            
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.089 -0400", hash_original_method = "EB1A3879F5EB62721F94FC1BD32D5C70", hash_generated_method = "5D02618619EF2ED034BE5DD633B7584B")
        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + stackTrace.hashCode();
            result = 31 * result + count;
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1819451191 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1819451191;
            
            
            
            
            
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.090 -0400", hash_original_method = "9F96433135E9DB2A8F09B7286FEF9854", hash_generated_method = "D184E5C878631F009672E16F0AABBEF1")
        @Override
        public boolean equals(Object o) {
            Sample s = (Sample) o;
            boolean varA505477D65492DF14AC1310AAE4A1E15_1665535186 = (count == s.count && stackTrace.equals(s.stackTrace));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1271299389 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1271299389;
            
            
                
            
            
            
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.091 -0400", hash_original_method = "27C27C8BDAE57781C2B46A818775E5B8", hash_generated_method = "EF00CA4472AE9456BAC64EBEC6AAD010")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1499287359 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1499287359 = "Sample[count=" + count + " " + stackTrace + "]";
            varB4EAC82CA7396A68D541C85D26508E83_1499287359.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1499287359;
            
            
        }

        
    }


    
}

