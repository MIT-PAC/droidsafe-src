package dalvik.system.profiler;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.430 -0400", hash_original_field = "B9A6573709935C9B3FECAA4DEC3B7269", hash_generated_field = "3F4204ABC43917BE7A39B6FD85E75A38")

    private long startMillis;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.430 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "C01DA7975DA485EEDBF522635D053B3B")

    private int flags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.430 -0400", hash_original_field = "12A055BF01A31369FE81AC35D85C7BC1", hash_generated_field = "9E4E1D4E0DD2F9B43B1F6C7CB67C1409")

    private int depth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.430 -0400", hash_original_field = "79C1034D7397FA5B6459F68812FA26AA", hash_generated_field = "775F5B7FF64FA65316AF7C8C50A37D17")

    private List<ThreadEvent> threadHistory = new ArrayList<ThreadEvent>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.430 -0400", hash_original_field = "FB662DEE8F61DD38591C8A93726EB143", hash_generated_field = "DC557752C450B7F19F7892660D7ABCBC")

    private Map<Integer, ThreadEvent> threadIdToThreadEvent = new HashMap<Integer, ThreadEvent>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.430 -0400", hash_original_field = "580229FDC7FA8EFE701CD2061D469688", hash_generated_field = "2E2E6C57E5FA37C42CB4DC1BB6563D4D")

    private Map<HprofData.StackTrace, int[]> stackTraces;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.430 -0400", hash_original_method = "A1B0101007C345DF1FDD21D474244925", hash_generated_method = "9495FB0F7CC531BE07007EC718608206")
    public  HprofData(Map<StackTrace, int[]> stackTraces) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("stackTraces == null");
        } //End block
        this.stackTraces = stackTraces;
        // ---------- Original Method ----------
        //if (stackTraces == null) {
            //throw new NullPointerException("stackTraces == null");
        //}
        //this.stackTraces = stackTraces;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.437 -0400", hash_original_method = "CC766E32F9FC42071F3CC3CB88E9A18A", hash_generated_method = "1FC41C6A4682C43E949A9755147D8AB5")
    public long getStartMillis() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1474074791 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1474074791;
        // ---------- Original Method ----------
        //return startMillis;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.437 -0400", hash_original_method = "B0BB2E1F2492EC486CB4460593218E46", hash_generated_method = "32E114486602338DC0FFC6C493371EE3")
    public void setStartMillis(long startMillis) {
        this.startMillis = startMillis;
        // ---------- Original Method ----------
        //this.startMillis = startMillis;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.437 -0400", hash_original_method = "292C3EF40E00AFB28AC60AF92A04DB70", hash_generated_method = "73C19D97DD677CB17DECE02752BF0985")
    public int getFlags() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2096993769 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2096993769;
        // ---------- Original Method ----------
        //return flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.438 -0400", hash_original_method = "E55E0ED6FE66EB0D458BFDED224C9943", hash_generated_method = "F61A3B65ECD9BA445206989DF2EF1A1F")
    public void setFlags(int flags) {
        this.flags = flags;
        // ---------- Original Method ----------
        //this.flags = flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.438 -0400", hash_original_method = "FBD5046615AAE9EDCC3CA2ADE86A92C3", hash_generated_method = "E8542E65B577F1DF106EF2108BB52529")
    public int getDepth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1878151904 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1878151904;
        // ---------- Original Method ----------
        //return depth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.438 -0400", hash_original_method = "7E87B9040AF172D5ADB37F7AF7F75CA6", hash_generated_method = "FFC7D812D0FFB494BA967C34F7E21CCC")
    public void setDepth(int depth) {
        this.depth = depth;
        // ---------- Original Method ----------
        //this.depth = depth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.439 -0400", hash_original_method = "8C7F14531209B0BE4CB8ACECEBC720CC", hash_generated_method = "9B87AB799AAAF21E52A07E4C3BDFBF70")
    public List<ThreadEvent> getThreadHistory() {
        List<ThreadEvent> varB4EAC82CA7396A68D541C85D26508E83_1867572184 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1867572184 = Collections.unmodifiableList(threadHistory);
        varB4EAC82CA7396A68D541C85D26508E83_1867572184.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1867572184;
        // ---------- Original Method ----------
        //return Collections.unmodifiableList(threadHistory);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.464 -0400", hash_original_method = "F4E32CE6895396BD588CC20D263E2FB4", hash_generated_method = "7E2D79D7211508A0ED3730AC9AC740B4")
    public Set<Sample> getSamples() {
        Set<Sample> varB4EAC82CA7396A68D541C85D26508E83_946142325 = null; //Variable for return #1
        Set<Sample> samples;
        samples = new HashSet<Sample>(stackTraces.size());
        {
            Iterator<Entry<StackTrace, int[]>> var90BB71089607029678F04EF3DD4C4774_2062951470 = (stackTraces.entrySet()).iterator();
            var90BB71089607029678F04EF3DD4C4774_2062951470.hasNext();
            Entry<StackTrace, int[]> e = var90BB71089607029678F04EF3DD4C4774_2062951470.next();
            {
                StackTrace stackTrace;
                stackTrace = e.getKey();
                int countCell[];
                countCell = e.getValue();
                int count;
                count = countCell[0];
                Sample sample;
                sample = new Sample(stackTrace, count);
                samples.add(sample);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_946142325 = samples;
        varB4EAC82CA7396A68D541C85D26508E83_946142325.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_946142325;
        // ---------- Original Method ----------
        //Set<Sample> samples = new HashSet<Sample>(stackTraces.size());
        //for (Entry<StackTrace, int[]> e : stackTraces.entrySet()) {
            //StackTrace stackTrace = e.getKey();
            //int countCell[] = e.getValue();
            //int count = countCell[0];
            //Sample sample = new Sample(stackTrace, count);
            //samples.add(sample);
        //}
        //return samples;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.464 -0400", hash_original_method = "3644EE7A7CD6AEAD3C58A3E47BD5EAC7", hash_generated_method = "3DC62389DC4001F70C84F8D88E0D4660")
    public void addThreadEvent(ThreadEvent event) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("event == null");
        } //End block
        ThreadEvent old;
        old = threadIdToThreadEvent.put(event.threadId, event);
        //Begin case START 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("ThreadEvent already registered for id "
                                                       + event.threadId);
        } //End block
        //End case START 
        //Begin case END 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Duplicate ThreadEvent.end for id "
                                                       + event.threadId);
        } //End block
        //End case END 
        threadHistory.add(event);
        addTaint(event.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.465 -0400", hash_original_method = "ED310F254F72ACCB3181D18F31C09E67", hash_generated_method = "02168D5E71281FF163AB3A97E5D8252A")
    public void addStackTrace(StackTrace stackTrace, int[] countCell) {
        {
            boolean varF730A1A3EABF99869C11ED3AF87B008F_1349586862 = (!threadIdToThreadEvent.containsKey(stackTrace.threadId));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown thread id " + stackTrace.threadId);
            } //End block
        } //End collapsed parenthetic
        int[] old;
        old = stackTraces.put(stackTrace, countCell);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("StackTrace already registered for id "
                                               + stackTrace.stackTraceId + ":\n" + stackTrace);
        } //End block
        addTaint(stackTrace.getTaint());
        addTaint(countCell[0]);
        // ---------- Original Method ----------
        //if (!threadIdToThreadEvent.containsKey(stackTrace.threadId)) {
            //throw new IllegalArgumentException("Unknown thread id " + stackTrace.threadId);
        //}
        //int[] old = stackTraces.put(stackTrace, countCell);
        //if (old != null) {
            //throw new IllegalArgumentException("StackTrace already registered for id "
                                               //+ stackTrace.stackTraceId + ":\n" + stackTrace);
        //}
    }

    
    public static enum ThreadEventType { START, END }

    
    public static final class ThreadEvent {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.465 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "7D87225C2426FF111F6FEB910554E402")

        public ThreadEventType type;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.465 -0400", hash_original_field = "16B2B26000987FACCB260B9D39DF1269", hash_generated_field = "50DDAAE60FEC6646E9C40B14D16B89C4")

        public int objectId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.465 -0400", hash_original_field = "61DC2BD347732448287F2A6771F304D8", hash_generated_field = "F04E415998CFF5C3E3E3A9ABC2303E69")

        public int threadId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.465 -0400", hash_original_field = "4810534ACF4D829946E1AC0A954285B9", hash_generated_field = "113B76C8DC7050E98D3CE8623AE010CB")

        public String threadName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.465 -0400", hash_original_field = "A2B861D0E7719D9108522AACFD4181BC", hash_generated_field = "93B2A487547CBE3E3CA82EF8BA52C0EE")

        public String groupName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.465 -0400", hash_original_field = "41866721A70EAC235AF31A5AD4E3B6DD", hash_generated_field = "CA659A31009B2F91CD0C2968AC161B2C")

        public String parentGroupName;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.466 -0400", hash_original_method = "418862520135AFAF9D5B41BB00EA7C53", hash_generated_method = "4EA439894D1EE123896B2FF7BACDB21C")
        private  ThreadEvent(ThreadEventType type, int objectId, int threadId,
                            String threadName, String groupName, String parentGroupName) {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("threadName == null");
            } //End block
            this.type = ThreadEventType.START;
            this.objectId = objectId;
            this.threadId = threadId;
            this.threadName = threadName;
            this.groupName = groupName;
            this.parentGroupName = parentGroupName;
            // ---------- Original Method ----------
            //if (threadName == null) {
                //throw new NullPointerException("threadName == null");
            //}
            //this.type = ThreadEventType.START;
            //this.objectId = objectId;
            //this.threadId = threadId;
            //this.threadName = threadName;
            //this.groupName = groupName;
            //this.parentGroupName = parentGroupName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.466 -0400", hash_original_method = "87F2300773E111C1834911C7597238E6", hash_generated_method = "9601CB79B6EA603856556CF9BC4D5103")
        private  ThreadEvent(ThreadEventType type, int threadId) {
            this.type = ThreadEventType.END;
            this.objectId = -1;
            this.threadId = threadId;
            this.threadName = null;
            this.groupName = null;
            this.parentGroupName = null;
            // ---------- Original Method ----------
            //this.type = ThreadEventType.END;
            //this.objectId = -1;
            //this.threadId = threadId;
            //this.threadName = null;
            //this.groupName = null;
            //this.parentGroupName = null;
        }

        
                public static ThreadEvent start(int objectId, int threadId, String threadName,
                                        String groupName, String parentGroupName) {
            return new ThreadEvent(ThreadEventType.START, objectId, threadId,
                                   threadName, groupName, parentGroupName);
        }

        
                public static ThreadEvent end(int threadId) {
            return new ThreadEvent(ThreadEventType.END, threadId);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.483 -0400", hash_original_method = "FD54D2802DF7D246F84571D313E0773D", hash_generated_method = "2C178E199F8268A2A1887CBA18E937F1")
        @Override
        public int hashCode() {
            int result;
            result = 17;
            result = 31 * result + objectId;
            result = 31 * result + threadId;
            result = 31 * result + hashCode(threadName);
            result = 31 * result + hashCode(groupName);
            result = 31 * result + hashCode(parentGroupName);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1615441803 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1615441803;
            // ---------- Original Method ----------
            //int result = 17;
            //result = 31 * result + objectId;
            //result = 31 * result + threadId;
            //result = 31 * result + hashCode(threadName);
            //result = 31 * result + hashCode(groupName);
            //result = 31 * result + hashCode(parentGroupName);
            //return result;
        }

        
                private static int hashCode(Object o) {
            return (o == null) ? 0 : o.hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.487 -0400", hash_original_method = "11A9724AFC12A4881460E902B1AEFFA3", hash_generated_method = "E955A02F7182636395DF952D3061C89B")
        @Override
        public boolean equals(Object o) {
            ThreadEvent event;
            event = (ThreadEvent) o;
            boolean var4A4581E64171586ED6B283FBA9E8FB21_1133900729 = ((this.type == event.type
                    && this.objectId == event.objectId
                    && this.threadId == event.threadId
                    && equal(this.threadName, event.threadName)
                    && equal(this.groupName, event.groupName)
                    && equal(this.parentGroupName, event.parentGroupName)));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_147418992 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_147418992;
            // ---------- Original Method ----------
            //if (!(o instanceof ThreadEvent)) {
                //return false;
            //}
            //ThreadEvent event = (ThreadEvent) o;
            //return (this.type == event.type
                    //&& this.objectId == event.objectId
                    //&& this.threadId == event.threadId
                    //&& equal(this.threadName, event.threadName)
                    //&& equal(this.groupName, event.groupName)
                    //&& equal(this.parentGroupName, event.parentGroupName));
        }

        
                private static boolean equal(Object a, Object b) {
            return a == b || (a != null && a.equals(b));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.493 -0400", hash_original_method = "B2760D4380298F8E4BDF009F5947B547", hash_generated_method = "475F38DDFED598CE6F5AD8E7DADDE452")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1917342804 = null; //Variable for return #1
            String varB4EAC82CA7396A68D541C85D26508E83_571744651 = null; //Variable for return #2
            //Begin case START 
            varB4EAC82CA7396A68D541C85D26508E83_1917342804 = String.format(
                            "THREAD START (obj=%d, id = %d, name=\"%s\", group=\"%s\")",
                            objectId, threadId, threadName, groupName);
            //End case START 
            //Begin case END 
            varB4EAC82CA7396A68D541C85D26508E83_571744651 = String.format("THREAD END (id = %d)", threadId);
            //End case END 
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(type.toString());
            String varA7E53CE21691AB073D9660D615818899_1474485316; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1474485316 = varB4EAC82CA7396A68D541C85D26508E83_1917342804;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1474485316 = varB4EAC82CA7396A68D541C85D26508E83_571744651;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1474485316.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1474485316;
            // ---------- Original Method ----------
            //switch (type) {
                //case START:
                    //return String.format(
                            //"THREAD START (obj=%d, id = %d, name=\"%s\", group=\"%s\")",
                            //objectId, threadId, threadName, groupName);
                //case END:
                    //return String.format("THREAD END (id = %d)", threadId);
            //}
            //throw new IllegalStateException(type.toString());
        }

        
    }


    
    public static final class StackTrace {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.494 -0400", hash_original_field = "5A1B7B013BF1B5500278A118121BAFD2", hash_generated_field = "4628C5C3D0941960F68046E7C771CD60")

        public int stackTraceId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.494 -0400", hash_original_field = "61DC2BD347732448287F2A6771F304D8", hash_generated_field = "21BB19B62D16F0B2F30983971184762D")

        int threadId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.494 -0400", hash_original_field = "BA28502755EA3671FD39FBD3FFA05E42", hash_generated_field = "088C6E829F236000DB4EE42B0CB07B24")

        StackTraceElement[] stackFrames;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.494 -0400", hash_original_method = "937A3F2A08E08A14F8EC24A94B9A8468", hash_generated_method = "B8B05431485364C1F4F77D04A35AC9F2")
          StackTrace() {
            this.stackTraceId = -1;
            // ---------- Original Method ----------
            //this.stackTraceId = -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.494 -0400", hash_original_method = "D4A1391652F07F93D8818AA4C8761514", hash_generated_method = "CEC68BA887B17DB2F0DC64DA5E4F1807")
        public  StackTrace(int stackTraceId, int threadId, StackTraceElement[] stackFrames) {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("stackFrames == null");
            } //End block
            this.stackTraceId = stackTraceId;
            this.threadId = threadId;
            this.stackFrames = stackFrames;
            // ---------- Original Method ----------
            //if (stackFrames == null) {
                //throw new NullPointerException("stackFrames == null");
            //}
            //this.stackTraceId = stackTraceId;
            //this.threadId = threadId;
            //this.stackFrames = stackFrames;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.495 -0400", hash_original_method = "904149F69266C7F1ED9811C71073DCCC", hash_generated_method = "8CECB2742F06E7A97D9613187638F295")
        public int getThreadId() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1604146082 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1604146082;
            // ---------- Original Method ----------
            //return threadId;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.495 -0400", hash_original_method = "825D6A57778B026225A4AA6FF793AA6E", hash_generated_method = "D7BD4B560FACF04C5031AF9A4A522D98")
        public StackTraceElement[] getStackFrames() {
            StackTraceElement[] varB4EAC82CA7396A68D541C85D26508E83_1678901318 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1678901318 = stackFrames;
            varB4EAC82CA7396A68D541C85D26508E83_1678901318.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1678901318;
            // ---------- Original Method ----------
            //return stackFrames;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.517 -0400", hash_original_method = "E0B79EC3EEC67C907668B24F8C3EF7D1", hash_generated_method = "35BD50CEA60BEBAF88F47086CF06296E")
        @Override
        public int hashCode() {
            int result;
            result = 17;
            result = 31 * result + threadId;
            result = 31 * result + Arrays.hashCode(stackFrames);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1738430511 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1738430511;
            // ---------- Original Method ----------
            //int result = 17;
            //result = 31 * result + threadId;
            //result = 31 * result + Arrays.hashCode(stackFrames);
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.526 -0400", hash_original_method = "A370788F6EF207DC60ADB1FE1413BF45", hash_generated_method = "9D70DB307987CA91E25331E9C74C5AAA")
        @Override
        public boolean equals(Object o) {
            StackTrace s;
            s = (StackTrace) o;
            boolean varB7031E8E3AFE83BB1AAB81E860AA93C0_1212356622 = (threadId == s.threadId && Arrays.equals(stackFrames, s.stackFrames));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_607949251 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_607949251;
            // ---------- Original Method ----------
            //if (!(o instanceof StackTrace)) {
                //return false;
            //}
            //StackTrace s = (StackTrace) o;
            //return threadId == s.threadId && Arrays.equals(stackFrames, s.stackFrames);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.563 -0400", hash_original_method = "2C975038FABEA62C51E7521430E68593", hash_generated_method = "8AF961E2DFA0F7A39AB5FA0FEC3C1820")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1593191934 = null; //Variable for return #1
            StringBuilder frames;
            frames = new StringBuilder();
            {
                frames.append('\n');
                {
                    Iterator<StackTraceElement> var7B091650749E3063FD551B3BEFBA9F46_1270322306 = (stackFrames).iterator();
                    var7B091650749E3063FD551B3BEFBA9F46_1270322306.hasNext();
                    StackTraceElement stackFrame = var7B091650749E3063FD551B3BEFBA9F46_1270322306.next();
                    {
                        frames.append("\t at ");
                        frames.append(stackFrame);
                        frames.append('\n');
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                frames.append("<empty>");
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1593191934 = "StackTrace[stackTraceId=" + stackTraceId
                    + ", threadId=" + threadId
                    + ", frames=" + frames + "]";
            varB4EAC82CA7396A68D541C85D26508E83_1593191934.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1593191934;
            // ---------- Original Method ----------
            //StringBuilder frames = new StringBuilder();
            //if (stackFrames.length > 0) {
                //frames.append('\n');
                //for (StackTraceElement stackFrame : stackFrames) {
                    //frames.append("\t at ");
                    //frames.append(stackFrame);
                    //frames.append('\n');
                //}
            //} else {
                //frames.append("<empty>");
            //}
            //return "StackTrace[stackTraceId=" + stackTraceId
                    //+ ", threadId=" + threadId
                    //+ ", frames=" + frames + "]";
        }

        
    }


    
    public static final class Sample {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.563 -0400", hash_original_field = "FCD4E36FD80F450979495718DBDDAACF", hash_generated_field = "3CCE78B4D1712F23531BA45DE99ABF0D")

        public StackTrace stackTrace;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.563 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "21B1DF5337CCD3E0731435FB1361ED67")

        public int count;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.564 -0400", hash_original_method = "8A8A799FE1363281492F811288A07E90", hash_generated_method = "E56FFA7D550B53B389BAB315057562CE")
        private  Sample(StackTrace stackTrace, int count) {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("stackTrace == null");
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("count < 0:" + count);
            } //End block
            this.stackTrace = stackTrace;
            this.count = count;
            // ---------- Original Method ----------
            //if (stackTrace == null) {
                //throw new NullPointerException("stackTrace == null");
            //}
            //if (count < 0) {
                //throw new IllegalArgumentException("count < 0:" + count);
            //}
            //this.stackTrace = stackTrace;
            //this.count = count;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.571 -0400", hash_original_method = "EB1A3879F5EB62721F94FC1BD32D5C70", hash_generated_method = "165AAE5B448CEDF5129E030055B185E8")
        @Override
        public int hashCode() {
            int result;
            result = 17;
            result = 31 * result + stackTrace.hashCode();
            result = 31 * result + count;
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1364982353 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1364982353;
            // ---------- Original Method ----------
            //int result = 17;
            //result = 31 * result + stackTrace.hashCode();
            //result = 31 * result + count;
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.571 -0400", hash_original_method = "9F96433135E9DB2A8F09B7286FEF9854", hash_generated_method = "5A0377EDB561C99B44DDB345BFE0C5AB")
        @Override
        public boolean equals(Object o) {
            Sample s;
            s = (Sample) o;
            boolean varA505477D65492DF14AC1310AAE4A1E15_882822742 = (count == s.count && stackTrace.equals(s.stackTrace));
            addTaint(o.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_617270174 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_617270174;
            // ---------- Original Method ----------
            //if (!(o instanceof Sample)) {
                //return false;
            //}
            //Sample s = (Sample) o;
            //return count == s.count && stackTrace.equals(s.stackTrace);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.572 -0400", hash_original_method = "27C27C8BDAE57781C2B46A818775E5B8", hash_generated_method = "166C8948D2BBA8C3A14E094FA68F56DA")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1398175146 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1398175146 = "Sample[count=" + count + " " + stackTrace + "]";
            varB4EAC82CA7396A68D541C85D26508E83_1398175146.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1398175146;
            // ---------- Original Method ----------
            //return "Sample[count=" + count + " " + stackTrace + "]";
        }

        
    }


    
}

