package dalvik.system.profiler;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.967 -0400", hash_original_field = "B9A6573709935C9B3FECAA4DEC3B7269", hash_generated_field = "3F4204ABC43917BE7A39B6FD85E75A38")

    private long startMillis;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.967 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "C01DA7975DA485EEDBF522635D053B3B")

    private int flags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.968 -0400", hash_original_field = "12A055BF01A31369FE81AC35D85C7BC1", hash_generated_field = "9E4E1D4E0DD2F9B43B1F6C7CB67C1409")

    private int depth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.968 -0400", hash_original_field = "79C1034D7397FA5B6459F68812FA26AA", hash_generated_field = "EBD0F48FF63E7A93B0B5B1649E0D9BEE")

    private final List<ThreadEvent> threadHistory = new ArrayList<ThreadEvent>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.968 -0400", hash_original_field = "FB662DEE8F61DD38591C8A93726EB143", hash_generated_field = "5C4F57CC1BAFED6BB9221F867FA6736B")

    private final Map<Integer, ThreadEvent> threadIdToThreadEvent = new HashMap<Integer, ThreadEvent>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.968 -0400", hash_original_field = "580229FDC7FA8EFE701CD2061D469688", hash_generated_field = "2E2E6C57E5FA37C42CB4DC1BB6563D4D")

    private Map<HprofData.StackTrace, int[]> stackTraces;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.968 -0400", hash_original_method = "A1B0101007C345DF1FDD21D474244925", hash_generated_method = "B8044C04B1428A50CC0B08591D628F88")
    public  HprofData(Map<StackTrace, int[]> stackTraces) {
    if(stackTraces == null)        
        {
            NullPointerException varC5C35CCE41CBA75F4AE4D0EE6DF48B47_1748382760 = new NullPointerException("stackTraces == null");
            varC5C35CCE41CBA75F4AE4D0EE6DF48B47_1748382760.addTaint(taint);
            throw varC5C35CCE41CBA75F4AE4D0EE6DF48B47_1748382760;
        } //End block
        this.stackTraces = stackTraces;
        // ---------- Original Method ----------
        //if (stackTraces == null) {
            //throw new NullPointerException("stackTraces == null");
        //}
        //this.stackTraces = stackTraces;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.969 -0400", hash_original_method = "CC766E32F9FC42071F3CC3CB88E9A18A", hash_generated_method = "6735888E2C8CD9B108ADE126DC940266")
    public long getStartMillis() {
        long varB9A6573709935C9B3FECAA4DEC3B7269_1125705581 = (startMillis);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_608392083 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_608392083;
        // ---------- Original Method ----------
        //return startMillis;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.969 -0400", hash_original_method = "B0BB2E1F2492EC486CB4460593218E46", hash_generated_method = "32E114486602338DC0FFC6C493371EE3")
    public void setStartMillis(long startMillis) {
        this.startMillis = startMillis;
        // ---------- Original Method ----------
        //this.startMillis = startMillis;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.970 -0400", hash_original_method = "292C3EF40E00AFB28AC60AF92A04DB70", hash_generated_method = "19D30E777A686ABF78A69F4D9105DF61")
    public int getFlags() {
        int var4E5868D676CB634AA75B125A0F741ABF_351345668 = (flags);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_399180279 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_399180279;
        // ---------- Original Method ----------
        //return flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.971 -0400", hash_original_method = "E55E0ED6FE66EB0D458BFDED224C9943", hash_generated_method = "F61A3B65ECD9BA445206989DF2EF1A1F")
    public void setFlags(int flags) {
        this.flags = flags;
        // ---------- Original Method ----------
        //this.flags = flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.971 -0400", hash_original_method = "FBD5046615AAE9EDCC3CA2ADE86A92C3", hash_generated_method = "54554D05DD733E634BB5AF8ECACEC16E")
    public int getDepth() {
        int var12A055BF01A31369FE81AC35D85C7BC1_604713096 = (depth);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1321644806 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1321644806;
        // ---------- Original Method ----------
        //return depth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.971 -0400", hash_original_method = "7E87B9040AF172D5ADB37F7AF7F75CA6", hash_generated_method = "FFC7D812D0FFB494BA967C34F7E21CCC")
    public void setDepth(int depth) {
        this.depth = depth;
        // ---------- Original Method ----------
        //this.depth = depth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.972 -0400", hash_original_method = "8C7F14531209B0BE4CB8ACECEBC720CC", hash_generated_method = "53DB11416E1F8A7915035C5912EA52E9")
    public List<ThreadEvent> getThreadHistory() {
List<ThreadEvent> var6EA9A1CCACBDEC7F01C787F92F96DACA_881249824 =         Collections.unmodifiableList(threadHistory);
        var6EA9A1CCACBDEC7F01C787F92F96DACA_881249824.addTaint(taint);
        return var6EA9A1CCACBDEC7F01C787F92F96DACA_881249824;
        // ---------- Original Method ----------
        //return Collections.unmodifiableList(threadHistory);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.972 -0400", hash_original_method = "F4E32CE6895396BD588CC20D263E2FB4", hash_generated_method = "01BCD817996E9FA7BB3A76AE1C8881C0")
    public Set<Sample> getSamples() {
        Set<Sample> samples = new HashSet<Sample>(stackTraces.size());
for(Entry<StackTrace, int[]> e : stackTraces.entrySet())
        {
            StackTrace stackTrace = e.getKey();
            int countCell[] = e.getValue();
            int count = countCell[0];
            Sample sample = new Sample(stackTrace, count);
            samples.add(sample);
        } //End block
Set<Sample> varCC8F20BA380947D12EB15521202A774B_1508752701 =         samples;
        varCC8F20BA380947D12EB15521202A774B_1508752701.addTaint(taint);
        return varCC8F20BA380947D12EB15521202A774B_1508752701;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.972 -0400", hash_original_method = "3644EE7A7CD6AEAD3C58A3E47BD5EAC7", hash_generated_method = "9CC4E5E0A2D552E3E8115A1A2BA8E4F3")
    public void addThreadEvent(ThreadEvent event) {
        addTaint(event.getTaint());
    if(event == null)        
        {
            NullPointerException var720A849C11C902F227883AA3CF5FB824_1611737497 = new NullPointerException("event == null");
            var720A849C11C902F227883AA3CF5FB824_1611737497.addTaint(taint);
            throw var720A849C11C902F227883AA3CF5FB824_1611737497;
        } //End block
        ThreadEvent old = threadIdToThreadEvent.put(event.threadId, event);
switch(event.type){
        case START:
    if(old != null)        
        {
            IllegalArgumentException var836872742DFF045AC05FF4F88D73F43F_560389597 = new IllegalArgumentException("ThreadEvent already registered for id "
                                                       + event.threadId);
            var836872742DFF045AC05FF4F88D73F43F_560389597.addTaint(taint);
            throw var836872742DFF045AC05FF4F88D73F43F_560389597;
        } //End block
        break;
        case END:
    if(old != null && old.type == ThreadEventType.END)        
        {
            IllegalArgumentException var7372BBE1EF979C8D4D784BD6336691F7_279950182 = new IllegalArgumentException("Duplicate ThreadEvent.end for id "
                                                       + event.threadId);
            var7372BBE1EF979C8D4D784BD6336691F7_279950182.addTaint(taint);
            throw var7372BBE1EF979C8D4D784BD6336691F7_279950182;
        } //End block
        break;
}        threadHistory.add(event);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.973 -0400", hash_original_method = "ED310F254F72ACCB3181D18F31C09E67", hash_generated_method = "F5109AA0ED29A6BED098DE2BDF0020D7")
    public void addStackTrace(StackTrace stackTrace, int[] countCell) {
        addTaint(countCell[0]);
        addTaint(stackTrace.getTaint());
    if(!threadIdToThreadEvent.containsKey(stackTrace.threadId))        
        {
            IllegalArgumentException var4658F66361FFE021F600A43B98061EA6_419100754 = new IllegalArgumentException("Unknown thread id " + stackTrace.threadId);
            var4658F66361FFE021F600A43B98061EA6_419100754.addTaint(taint);
            throw var4658F66361FFE021F600A43B98061EA6_419100754;
        } //End block
        int[] old = stackTraces.put(stackTrace, countCell);
    if(old != null)        
        {
            IllegalArgumentException var577A9650CDAAA4C1351DB458601B8945_1786933208 = new IllegalArgumentException("StackTrace already registered for id "
                                               + stackTrace.stackTraceId + ":\n" + stackTrace);
            var577A9650CDAAA4C1351DB458601B8945_1786933208.addTaint(taint);
            throw var577A9650CDAAA4C1351DB458601B8945_1786933208;
        } //End block
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.973 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "7D87225C2426FF111F6FEB910554E402")

        public ThreadEventType type;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.973 -0400", hash_original_field = "16B2B26000987FACCB260B9D39DF1269", hash_generated_field = "50DDAAE60FEC6646E9C40B14D16B89C4")

        public int objectId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.973 -0400", hash_original_field = "61DC2BD347732448287F2A6771F304D8", hash_generated_field = "F04E415998CFF5C3E3E3A9ABC2303E69")

        public int threadId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.973 -0400", hash_original_field = "4810534ACF4D829946E1AC0A954285B9", hash_generated_field = "113B76C8DC7050E98D3CE8623AE010CB")

        public String threadName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.974 -0400", hash_original_field = "A2B861D0E7719D9108522AACFD4181BC", hash_generated_field = "93B2A487547CBE3E3CA82EF8BA52C0EE")

        public String groupName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.974 -0400", hash_original_field = "41866721A70EAC235AF31A5AD4E3B6DD", hash_generated_field = "CA659A31009B2F91CD0C2968AC161B2C")

        public String parentGroupName;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.976 -0400", hash_original_method = "418862520135AFAF9D5B41BB00EA7C53", hash_generated_method = "59A0E2BA0E2ED6081C457D4BBF807355")
        private  ThreadEvent(ThreadEventType type, int objectId, int threadId,
                            String threadName, String groupName, String parentGroupName) {
    if(threadName == null)            
            {
                NullPointerException var97AB7DB46FD14543B4445CB9575F26ED_1862075830 = new NullPointerException("threadName == null");
                var97AB7DB46FD14543B4445CB9575F26ED_1862075830.addTaint(taint);
                throw var97AB7DB46FD14543B4445CB9575F26ED_1862075830;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.977 -0400", hash_original_method = "87F2300773E111C1834911C7597238E6", hash_generated_method = "9601CB79B6EA603856556CF9BC4D5103")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.978 -0400", hash_original_method = "FD54D2802DF7D246F84571D313E0773D", hash_generated_method = "1AFB775BFF64753B3137A43CAD8AD8F4")
        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + objectId;
            result = 31 * result + threadId;
            result = 31 * result + hashCode(threadName);
            result = 31 * result + hashCode(groupName);
            result = 31 * result + hashCode(parentGroupName);
            int varB4A88417B3D0170D754C647C30B7216A_100120803 = (result);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1558615790 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1558615790;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.978 -0400", hash_original_method = "11A9724AFC12A4881460E902B1AEFFA3", hash_generated_method = "079F1DC85308FDE5EE9E07A34A531E06")
        @Override
        public boolean equals(Object o) {
            addTaint(o.getTaint());
    if(!(o instanceof ThreadEvent))            
            {
                boolean var68934A3E9455FA72420237EB05902327_1928131795 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1023503627 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1023503627;
            } //End block
            ThreadEvent event = (ThreadEvent) o;
            boolean var59A95C1E2945742B12509258514F1A38_84382986 = ((this.type == event.type
                    && this.objectId == event.objectId
                    && this.threadId == event.threadId
                    && equal(this.threadName, event.threadName)
                    && equal(this.groupName, event.groupName)
                    && equal(this.parentGroupName, event.parentGroupName)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1922427672 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1922427672;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.979 -0400", hash_original_method = "B2760D4380298F8E4BDF009F5947B547", hash_generated_method = "A5A30BD2241EB0268056E651BD7C8356")
        @Override
        public String toString() {
switch(type){
            case START:
String var465BAC2459816299C8E49956A26F8834_618893120 =             String.format(
                            "THREAD START (obj=%d, id = %d, name=\"%s\", group=\"%s\")",
                            objectId, threadId, threadName, groupName);
            var465BAC2459816299C8E49956A26F8834_618893120.addTaint(taint);
            return var465BAC2459816299C8E49956A26F8834_618893120;
            case END:
String var00B1B2FF6D903F68E7D679B21A349625_1126133881 =             String.format("THREAD END (id = %d)", threadId);
            var00B1B2FF6D903F68E7D679B21A349625_1126133881.addTaint(taint);
            return var00B1B2FF6D903F68E7D679B21A349625_1126133881;
}            IllegalStateException varA0714593821DBC140611C44112217EB5_1870400530 = new IllegalStateException(type.toString());
            varA0714593821DBC140611C44112217EB5_1870400530.addTaint(taint);
            throw varA0714593821DBC140611C44112217EB5_1870400530;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.979 -0400", hash_original_field = "5A1B7B013BF1B5500278A118121BAFD2", hash_generated_field = "4628C5C3D0941960F68046E7C771CD60")

        public int stackTraceId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.980 -0400", hash_original_field = "61DC2BD347732448287F2A6771F304D8", hash_generated_field = "21BB19B62D16F0B2F30983971184762D")

        int threadId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.980 -0400", hash_original_field = "BA28502755EA3671FD39FBD3FFA05E42", hash_generated_field = "088C6E829F236000DB4EE42B0CB07B24")

        StackTraceElement[] stackFrames;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.980 -0400", hash_original_method = "937A3F2A08E08A14F8EC24A94B9A8468", hash_generated_method = "B8B05431485364C1F4F77D04A35AC9F2")
          StackTrace() {
            this.stackTraceId = -1;
            // ---------- Original Method ----------
            //this.stackTraceId = -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.982 -0400", hash_original_method = "D4A1391652F07F93D8818AA4C8761514", hash_generated_method = "1FC22075DBBF6B11BC1F0733B401DF87")
        public  StackTrace(int stackTraceId, int threadId, StackTraceElement[] stackFrames) {
    if(stackFrames == null)            
            {
                NullPointerException var6DF2EF6279C309737D3589C9DD0A324E_412303270 = new NullPointerException("stackFrames == null");
                var6DF2EF6279C309737D3589C9DD0A324E_412303270.addTaint(taint);
                throw var6DF2EF6279C309737D3589C9DD0A324E_412303270;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.983 -0400", hash_original_method = "904149F69266C7F1ED9811C71073DCCC", hash_generated_method = "6C7E7B6D8A13D19741CAAC46777CAFB9")
        public int getThreadId() {
            int var61DC2BD347732448287F2A6771F304D8_739826353 = (threadId);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1603070496 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1603070496;
            // ---------- Original Method ----------
            //return threadId;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.983 -0400", hash_original_method = "825D6A57778B026225A4AA6FF793AA6E", hash_generated_method = "14AFEB9DC816530DE1F8703AB3F26E80")
        public StackTraceElement[] getStackFrames() {
StackTraceElement[] varE98473DA09074D13245C9DB218456746_1227809009 =             stackFrames;
            varE98473DA09074D13245C9DB218456746_1227809009.addTaint(taint);
            return varE98473DA09074D13245C9DB218456746_1227809009;
            // ---------- Original Method ----------
            //return stackFrames;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.984 -0400", hash_original_method = "E0B79EC3EEC67C907668B24F8C3EF7D1", hash_generated_method = "ACD391C65C41A7170C9F76D4C3226BC4")
        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + threadId;
            result = 31 * result + Arrays.hashCode(stackFrames);
            int varB4A88417B3D0170D754C647C30B7216A_331856566 = (result);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_723971558 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_723971558;
            // ---------- Original Method ----------
            //int result = 17;
            //result = 31 * result + threadId;
            //result = 31 * result + Arrays.hashCode(stackFrames);
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.984 -0400", hash_original_method = "A370788F6EF207DC60ADB1FE1413BF45", hash_generated_method = "F8D8CFF8A71C1252622097114A5586C9")
        @Override
        public boolean equals(Object o) {
            addTaint(o.getTaint());
    if(!(o instanceof StackTrace))            
            {
                boolean var68934A3E9455FA72420237EB05902327_70170181 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_481743135 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_481743135;
            } //End block
            StackTrace s = (StackTrace) o;
            boolean var2B9F6575C073433CEAA93447BBC4318D_2118111922 = (threadId == s.threadId && Arrays.equals(stackFrames, s.stackFrames));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1615324016 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1615324016;
            // ---------- Original Method ----------
            //if (!(o instanceof StackTrace)) {
                //return false;
            //}
            //StackTrace s = (StackTrace) o;
            //return threadId == s.threadId && Arrays.equals(stackFrames, s.stackFrames);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.985 -0400", hash_original_method = "2C975038FABEA62C51E7521430E68593", hash_generated_method = "13D95D6B7164500E6DF458875BFE0A37")
        @Override
        public String toString() {
            StringBuilder frames = new StringBuilder();
    if(stackFrames.length > 0)            
            {
                frames.append('\n');
for(StackTraceElement stackFrame : stackFrames)
                {
                    frames.append("\t at ");
                    frames.append(stackFrame);
                    frames.append('\n');
                } //End block
            } //End block
            else
            {
                frames.append("<empty>");
            } //End block
String var30DC02AFA0A56F317C6F6FEE3F2FBD1E_641705422 =             "StackTrace[stackTraceId=" + stackTraceId
                    + ", threadId=" + threadId
                    + ", frames=" + frames + "]";
            var30DC02AFA0A56F317C6F6FEE3F2FBD1E_641705422.addTaint(taint);
            return var30DC02AFA0A56F317C6F6FEE3F2FBD1E_641705422;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.985 -0400", hash_original_field = "FCD4E36FD80F450979495718DBDDAACF", hash_generated_field = "3CCE78B4D1712F23531BA45DE99ABF0D")

        public StackTrace stackTrace;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.985 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "21B1DF5337CCD3E0731435FB1361ED67")

        public int count;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.986 -0400", hash_original_method = "8A8A799FE1363281492F811288A07E90", hash_generated_method = "66DA3F45D9F21ABC2ADD07B199A75ADB")
        private  Sample(StackTrace stackTrace, int count) {
    if(stackTrace == null)            
            {
                NullPointerException var9D50D5940EDBFAB3655F2E487BAA36B1_855798518 = new NullPointerException("stackTrace == null");
                var9D50D5940EDBFAB3655F2E487BAA36B1_855798518.addTaint(taint);
                throw var9D50D5940EDBFAB3655F2E487BAA36B1_855798518;
            } //End block
    if(count < 0)            
            {
                IllegalArgumentException varDF85253FA76530F6E00B5E06FF7A8377_196518168 = new IllegalArgumentException("count < 0:" + count);
                varDF85253FA76530F6E00B5E06FF7A8377_196518168.addTaint(taint);
                throw varDF85253FA76530F6E00B5E06FF7A8377_196518168;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.986 -0400", hash_original_method = "EB1A3879F5EB62721F94FC1BD32D5C70", hash_generated_method = "D160DCDBBC831290250F0126F782F6A9")
        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + stackTrace.hashCode();
            result = 31 * result + count;
            int varB4A88417B3D0170D754C647C30B7216A_1160119341 = (result);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_884466130 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_884466130;
            // ---------- Original Method ----------
            //int result = 17;
            //result = 31 * result + stackTrace.hashCode();
            //result = 31 * result + count;
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.987 -0400", hash_original_method = "9F96433135E9DB2A8F09B7286FEF9854", hash_generated_method = "9F79DEE65D9D959B4867717D63048F27")
        @Override
        public boolean equals(Object o) {
            addTaint(o.getTaint());
    if(!(o instanceof Sample))            
            {
                boolean var68934A3E9455FA72420237EB05902327_1465480183 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1507899697 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1507899697;
            } //End block
            Sample s = (Sample) o;
            boolean var146294C726FD5568C55561DD938A6C96_1459183630 = (count == s.count && stackTrace.equals(s.stackTrace));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_810295638 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_810295638;
            // ---------- Original Method ----------
            //if (!(o instanceof Sample)) {
                //return false;
            //}
            //Sample s = (Sample) o;
            //return count == s.count && stackTrace.equals(s.stackTrace);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.987 -0400", hash_original_method = "27C27C8BDAE57781C2B46A818775E5B8", hash_generated_method = "E6C5A37EB8D56942D84DF0A1FED973D6")
        @Override
        public String toString() {
String var23E8050A5E12C325B3BF3D999702FC4F_851884406 =             "Sample[count=" + count + " " + stackTrace + "]";
            var23E8050A5E12C325B3BF3D999702FC4F_851884406.addTaint(taint);
            return var23E8050A5E12C325B3BF3D999702FC4F_851884406;
            // ---------- Original Method ----------
            //return "Sample[count=" + count + " " + stackTrace + "]";
        }

        
    }


    
}

