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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.977 -0400", hash_original_field = "B9A6573709935C9B3FECAA4DEC3B7269", hash_generated_field = "3F4204ABC43917BE7A39B6FD85E75A38")

    private long startMillis;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.977 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "C01DA7975DA485EEDBF522635D053B3B")

    private int flags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.977 -0400", hash_original_field = "12A055BF01A31369FE81AC35D85C7BC1", hash_generated_field = "9E4E1D4E0DD2F9B43B1F6C7CB67C1409")

    private int depth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.977 -0400", hash_original_field = "79C1034D7397FA5B6459F68812FA26AA", hash_generated_field = "EBD0F48FF63E7A93B0B5B1649E0D9BEE")

    private final List<ThreadEvent> threadHistory = new ArrayList<ThreadEvent>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.977 -0400", hash_original_field = "FB662DEE8F61DD38591C8A93726EB143", hash_generated_field = "5C4F57CC1BAFED6BB9221F867FA6736B")

    private final Map<Integer, ThreadEvent> threadIdToThreadEvent = new HashMap<Integer, ThreadEvent>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.977 -0400", hash_original_field = "580229FDC7FA8EFE701CD2061D469688", hash_generated_field = "2E2E6C57E5FA37C42CB4DC1BB6563D4D")

    private Map<HprofData.StackTrace, int[]> stackTraces;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.978 -0400", hash_original_method = "A1B0101007C345DF1FDD21D474244925", hash_generated_method = "4AEC10D58AD8986EFE43DEA110E448DE")
    public  HprofData(Map<StackTrace, int[]> stackTraces) {
        if(stackTraces == null)        
        {
            NullPointerException varC5C35CCE41CBA75F4AE4D0EE6DF48B47_1416986424 = new NullPointerException("stackTraces == null");
            varC5C35CCE41CBA75F4AE4D0EE6DF48B47_1416986424.addTaint(taint);
            throw varC5C35CCE41CBA75F4AE4D0EE6DF48B47_1416986424;
        } //End block
        this.stackTraces = stackTraces;
        // ---------- Original Method ----------
        //if (stackTraces == null) {
            //throw new NullPointerException("stackTraces == null");
        //}
        //this.stackTraces = stackTraces;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.978 -0400", hash_original_method = "CC766E32F9FC42071F3CC3CB88E9A18A", hash_generated_method = "CF2686383E2A5F9123D77A7E1D21D52C")
    public long getStartMillis() {
        long varB9A6573709935C9B3FECAA4DEC3B7269_269433339 = (startMillis);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1925756494 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1925756494;
        // ---------- Original Method ----------
        //return startMillis;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.978 -0400", hash_original_method = "B0BB2E1F2492EC486CB4460593218E46", hash_generated_method = "32E114486602338DC0FFC6C493371EE3")
    public void setStartMillis(long startMillis) {
        this.startMillis = startMillis;
        // ---------- Original Method ----------
        //this.startMillis = startMillis;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.979 -0400", hash_original_method = "292C3EF40E00AFB28AC60AF92A04DB70", hash_generated_method = "DFD492EBAAFE686D7BF9123FB7047319")
    public int getFlags() {
        int var4E5868D676CB634AA75B125A0F741ABF_364535101 = (flags);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_439432266 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_439432266;
        // ---------- Original Method ----------
        //return flags;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.979 -0400", hash_original_method = "E55E0ED6FE66EB0D458BFDED224C9943", hash_generated_method = "F61A3B65ECD9BA445206989DF2EF1A1F")
    public void setFlags(int flags) {
        this.flags = flags;
        // ---------- Original Method ----------
        //this.flags = flags;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.979 -0400", hash_original_method = "FBD5046615AAE9EDCC3CA2ADE86A92C3", hash_generated_method = "7EE5945DA6B43D190A8542CD1F6F66AB")
    public int getDepth() {
        int var12A055BF01A31369FE81AC35D85C7BC1_1142830048 = (depth);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1611163982 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1611163982;
        // ---------- Original Method ----------
        //return depth;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.980 -0400", hash_original_method = "7E87B9040AF172D5ADB37F7AF7F75CA6", hash_generated_method = "FFC7D812D0FFB494BA967C34F7E21CCC")
    public void setDepth(int depth) {
        this.depth = depth;
        // ---------- Original Method ----------
        //this.depth = depth;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.980 -0400", hash_original_method = "8C7F14531209B0BE4CB8ACECEBC720CC", hash_generated_method = "6615F9C103299A26BD800E8B6DD4322D")
    public List<ThreadEvent> getThreadHistory() {
List<ThreadEvent> var6EA9A1CCACBDEC7F01C787F92F96DACA_670432949 =         Collections.unmodifiableList(threadHistory);
        var6EA9A1CCACBDEC7F01C787F92F96DACA_670432949.addTaint(taint);
        return var6EA9A1CCACBDEC7F01C787F92F96DACA_670432949;
        // ---------- Original Method ----------
        //return Collections.unmodifiableList(threadHistory);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.981 -0400", hash_original_method = "F4E32CE6895396BD588CC20D263E2FB4", hash_generated_method = "7A46E52A35EF2C68AD392151C83B10D2")
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
Set<Sample> varCC8F20BA380947D12EB15521202A774B_1049930207 =         samples;
        varCC8F20BA380947D12EB15521202A774B_1049930207.addTaint(taint);
        return varCC8F20BA380947D12EB15521202A774B_1049930207;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.982 -0400", hash_original_method = "3644EE7A7CD6AEAD3C58A3E47BD5EAC7", hash_generated_method = "727FE68211D0C98B32DD654E7EB99094")
    public void addThreadEvent(ThreadEvent event) {
        addTaint(event.getTaint());
        if(event == null)        
        {
            NullPointerException var720A849C11C902F227883AA3CF5FB824_1505158600 = new NullPointerException("event == null");
            var720A849C11C902F227883AA3CF5FB824_1505158600.addTaint(taint);
            throw var720A849C11C902F227883AA3CF5FB824_1505158600;
        } //End block
        ThreadEvent old = threadIdToThreadEvent.put(event.threadId, event);
switch(event.type){
        case START:
        if(old != null)        
        {
            IllegalArgumentException var836872742DFF045AC05FF4F88D73F43F_252676137 = new IllegalArgumentException("ThreadEvent already registered for id "
                                                       + event.threadId);
            var836872742DFF045AC05FF4F88D73F43F_252676137.addTaint(taint);
            throw var836872742DFF045AC05FF4F88D73F43F_252676137;
        } //End block
        break;
        case END:
        if(old != null && old.type == ThreadEventType.END)        
        {
            IllegalArgumentException var7372BBE1EF979C8D4D784BD6336691F7_516899442 = new IllegalArgumentException("Duplicate ThreadEvent.end for id "
                                                       + event.threadId);
            var7372BBE1EF979C8D4D784BD6336691F7_516899442.addTaint(taint);
            throw var7372BBE1EF979C8D4D784BD6336691F7_516899442;
        } //End block
        break;
}        threadHistory.add(event);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.983 -0400", hash_original_method = "ED310F254F72ACCB3181D18F31C09E67", hash_generated_method = "B1D8E8BFB400088D91BF8CFE785E95B8")
    public void addStackTrace(StackTrace stackTrace, int[] countCell) {
        addTaint(countCell[0]);
        addTaint(stackTrace.getTaint());
        if(!threadIdToThreadEvent.containsKey(stackTrace.threadId))        
        {
            IllegalArgumentException var4658F66361FFE021F600A43B98061EA6_615517634 = new IllegalArgumentException("Unknown thread id " + stackTrace.threadId);
            var4658F66361FFE021F600A43B98061EA6_615517634.addTaint(taint);
            throw var4658F66361FFE021F600A43B98061EA6_615517634;
        } //End block
        int[] old = stackTraces.put(stackTrace, countCell);
        if(old != null)        
        {
            IllegalArgumentException var577A9650CDAAA4C1351DB458601B8945_273296519 = new IllegalArgumentException("StackTrace already registered for id "
                                               + stackTrace.stackTraceId + ":\n" + stackTrace);
            var577A9650CDAAA4C1351DB458601B8945_273296519.addTaint(taint);
            throw var577A9650CDAAA4C1351DB458601B8945_273296519;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.983 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "7D87225C2426FF111F6FEB910554E402")

        public ThreadEventType type;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.983 -0400", hash_original_field = "16B2B26000987FACCB260B9D39DF1269", hash_generated_field = "50DDAAE60FEC6646E9C40B14D16B89C4")

        public int objectId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.983 -0400", hash_original_field = "61DC2BD347732448287F2A6771F304D8", hash_generated_field = "F04E415998CFF5C3E3E3A9ABC2303E69")

        public int threadId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.983 -0400", hash_original_field = "4810534ACF4D829946E1AC0A954285B9", hash_generated_field = "113B76C8DC7050E98D3CE8623AE010CB")

        public String threadName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.983 -0400", hash_original_field = "A2B861D0E7719D9108522AACFD4181BC", hash_generated_field = "93B2A487547CBE3E3CA82EF8BA52C0EE")

        public String groupName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.983 -0400", hash_original_field = "41866721A70EAC235AF31A5AD4E3B6DD", hash_generated_field = "CA659A31009B2F91CD0C2968AC161B2C")

        public String parentGroupName;
        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.985 -0400", hash_original_method = "418862520135AFAF9D5B41BB00EA7C53", hash_generated_method = "9DBC89DE2029C65C7C19D793D6567F34")
        private  ThreadEvent(ThreadEventType type, int objectId, int threadId,
                            String threadName, String groupName, String parentGroupName) {
            if(threadName == null)            
            {
                NullPointerException var97AB7DB46FD14543B4445CB9575F26ED_51761403 = new NullPointerException("threadName == null");
                var97AB7DB46FD14543B4445CB9575F26ED_51761403.addTaint(taint);
                throw var97AB7DB46FD14543B4445CB9575F26ED_51761403;
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

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.986 -0400", hash_original_method = "87F2300773E111C1834911C7597238E6", hash_generated_method = "9601CB79B6EA603856556CF9BC4D5103")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.988 -0400", hash_original_method = "FD54D2802DF7D246F84571D313E0773D", hash_generated_method = "9A598AF9BC04A1FA2BA698817FD66677")
        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + objectId;
            result = 31 * result + threadId;
            result = 31 * result + hashCode(threadName);
            result = 31 * result + hashCode(groupName);
            result = 31 * result + hashCode(parentGroupName);
            int varB4A88417B3D0170D754C647C30B7216A_1707085225 = (result);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1850378585 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1850378585;
            // ---------- Original Method ----------
            //int result = 17;
            //result = 31 * result + objectId;
            //result = 31 * result + threadId;
            //result = 31 * result + hashCode(threadName);
            //result = 31 * result + hashCode(groupName);
            //result = 31 * result + hashCode(parentGroupName);
            //return result;
        }

        
        @DSModeled(DSC.BAN)
        private static int hashCode(Object o) {
            return (o == null) ? 0 : o.hashCode();
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.988 -0400", hash_original_method = "11A9724AFC12A4881460E902B1AEFFA3", hash_generated_method = "7C41CA184D8BEA5AD823E84991483C62")
        @Override
        public boolean equals(Object o) {
            addTaint(o.getTaint());
            if(!(o instanceof ThreadEvent))            
            {
                boolean var68934A3E9455FA72420237EB05902327_7337351 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_748094810 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_748094810;
            } //End block
            ThreadEvent event = (ThreadEvent) o;
            boolean var59A95C1E2945742B12509258514F1A38_864144621 = ((this.type == event.type
                    && this.objectId == event.objectId
                    && this.threadId == event.threadId
                    && equal(this.threadName, event.threadName)
                    && equal(this.groupName, event.groupName)
                    && equal(this.parentGroupName, event.parentGroupName)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1114612309 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1114612309;
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

        
        @DSModeled(DSC.BAN)
        private static boolean equal(Object a, Object b) {
            return a == b || (a != null && a.equals(b));
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.988 -0400", hash_original_method = "B2760D4380298F8E4BDF009F5947B547", hash_generated_method = "1E948C4426D904F938D828D89FFF4BDF")
        @Override
        public String toString() {
switch(type){
            case START:
String var465BAC2459816299C8E49956A26F8834_111261866 =             String.format(
                            "THREAD START (obj=%d, id = %d, name=\"%s\", group=\"%s\")",
                            objectId, threadId, threadName, groupName);
            var465BAC2459816299C8E49956A26F8834_111261866.addTaint(taint);
            return var465BAC2459816299C8E49956A26F8834_111261866;
            case END:
String var00B1B2FF6D903F68E7D679B21A349625_54733603 =             String.format("THREAD END (id = %d)", threadId);
            var00B1B2FF6D903F68E7D679B21A349625_54733603.addTaint(taint);
            return var00B1B2FF6D903F68E7D679B21A349625_54733603;
}            IllegalStateException varA0714593821DBC140611C44112217EB5_1988350753 = new IllegalStateException(type.toString());
            varA0714593821DBC140611C44112217EB5_1988350753.addTaint(taint);
            throw varA0714593821DBC140611C44112217EB5_1988350753;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.989 -0400", hash_original_field = "5A1B7B013BF1B5500278A118121BAFD2", hash_generated_field = "4628C5C3D0941960F68046E7C771CD60")

        public int stackTraceId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.989 -0400", hash_original_field = "61DC2BD347732448287F2A6771F304D8", hash_generated_field = "21BB19B62D16F0B2F30983971184762D")

        int threadId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.989 -0400", hash_original_field = "BA28502755EA3671FD39FBD3FFA05E42", hash_generated_field = "088C6E829F236000DB4EE42B0CB07B24")

        StackTraceElement[] stackFrames;
        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.989 -0400", hash_original_method = "937A3F2A08E08A14F8EC24A94B9A8468", hash_generated_method = "B8B05431485364C1F4F77D04A35AC9F2")
          StackTrace() {
            this.stackTraceId = -1;
            // ---------- Original Method ----------
            //this.stackTraceId = -1;
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.989 -0400", hash_original_method = "D4A1391652F07F93D8818AA4C8761514", hash_generated_method = "00B60B62191A8437EA0A5D90D453769E")
        public  StackTrace(int stackTraceId, int threadId, StackTraceElement[] stackFrames) {
            if(stackFrames == null)            
            {
                NullPointerException var6DF2EF6279C309737D3589C9DD0A324E_1063156111 = new NullPointerException("stackFrames == null");
                var6DF2EF6279C309737D3589C9DD0A324E_1063156111.addTaint(taint);
                throw var6DF2EF6279C309737D3589C9DD0A324E_1063156111;
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

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.989 -0400", hash_original_method = "904149F69266C7F1ED9811C71073DCCC", hash_generated_method = "494797E90872487485F65DAA9B487B00")
        public int getThreadId() {
            int var61DC2BD347732448287F2A6771F304D8_584556113 = (threadId);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1311489500 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1311489500;
            // ---------- Original Method ----------
            //return threadId;
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.989 -0400", hash_original_method = "825D6A57778B026225A4AA6FF793AA6E", hash_generated_method = "E16A78B8476A2182682BB8F634EFC6F3")
        public StackTraceElement[] getStackFrames() {
StackTraceElement[] varE98473DA09074D13245C9DB218456746_1530930583 =             stackFrames;
            varE98473DA09074D13245C9DB218456746_1530930583.addTaint(taint);
            return varE98473DA09074D13245C9DB218456746_1530930583;
            // ---------- Original Method ----------
            //return stackFrames;
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.990 -0400", hash_original_method = "E0B79EC3EEC67C907668B24F8C3EF7D1", hash_generated_method = "CAAF344BE3A04AB52F8601104F08B544")
        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + threadId;
            result = 31 * result + Arrays.hashCode(stackFrames);
            int varB4A88417B3D0170D754C647C30B7216A_828707892 = (result);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2007910281 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2007910281;
            // ---------- Original Method ----------
            //int result = 17;
            //result = 31 * result + threadId;
            //result = 31 * result + Arrays.hashCode(stackFrames);
            //return result;
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.990 -0400", hash_original_method = "A370788F6EF207DC60ADB1FE1413BF45", hash_generated_method = "3B034F702F349C3B4D500E05AEF256C3")
        @Override
        public boolean equals(Object o) {
            addTaint(o.getTaint());
            if(!(o instanceof StackTrace))            
            {
                boolean var68934A3E9455FA72420237EB05902327_1463176533 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_821014256 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_821014256;
            } //End block
            StackTrace s = (StackTrace) o;
            boolean var2B9F6575C073433CEAA93447BBC4318D_673622762 = (threadId == s.threadId && Arrays.equals(stackFrames, s.stackFrames));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_944092987 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_944092987;
            // ---------- Original Method ----------
            //if (!(o instanceof StackTrace)) {
                //return false;
            //}
            //StackTrace s = (StackTrace) o;
            //return threadId == s.threadId && Arrays.equals(stackFrames, s.stackFrames);
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.990 -0400", hash_original_method = "2C975038FABEA62C51E7521430E68593", hash_generated_method = "311CEA1BA9E23C5122A514519DB27560")
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
String var30DC02AFA0A56F317C6F6FEE3F2FBD1E_1859317849 =             "StackTrace[stackTraceId=" + stackTraceId
                    + ", threadId=" + threadId
                    + ", frames=" + frames + "]";
            var30DC02AFA0A56F317C6F6FEE3F2FBD1E_1859317849.addTaint(taint);
            return var30DC02AFA0A56F317C6F6FEE3F2FBD1E_1859317849;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.991 -0400", hash_original_field = "FCD4E36FD80F450979495718DBDDAACF", hash_generated_field = "3CCE78B4D1712F23531BA45DE99ABF0D")

        public StackTrace stackTrace;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.991 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "21B1DF5337CCD3E0731435FB1361ED67")

        public int count;
        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.992 -0400", hash_original_method = "8A8A799FE1363281492F811288A07E90", hash_generated_method = "AE22455CF3247AD5CD09BD19FA49D31B")
        private  Sample(StackTrace stackTrace, int count) {
            if(stackTrace == null)            
            {
                NullPointerException var9D50D5940EDBFAB3655F2E487BAA36B1_699244843 = new NullPointerException("stackTrace == null");
                var9D50D5940EDBFAB3655F2E487BAA36B1_699244843.addTaint(taint);
                throw var9D50D5940EDBFAB3655F2E487BAA36B1_699244843;
            } //End block
            if(count < 0)            
            {
                IllegalArgumentException varDF85253FA76530F6E00B5E06FF7A8377_1245921775 = new IllegalArgumentException("count < 0:" + count);
                varDF85253FA76530F6E00B5E06FF7A8377_1245921775.addTaint(taint);
                throw varDF85253FA76530F6E00B5E06FF7A8377_1245921775;
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

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.992 -0400", hash_original_method = "EB1A3879F5EB62721F94FC1BD32D5C70", hash_generated_method = "E1F3148DE9E4582DD020693407E98F90")
        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + stackTrace.hashCode();
            result = 31 * result + count;
            int varB4A88417B3D0170D754C647C30B7216A_1446183895 = (result);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_59538515 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_59538515;
            // ---------- Original Method ----------
            //int result = 17;
            //result = 31 * result + stackTrace.hashCode();
            //result = 31 * result + count;
            //return result;
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.993 -0400", hash_original_method = "9F96433135E9DB2A8F09B7286FEF9854", hash_generated_method = "FF0FF1A1BD344810C61BD8BC2F8EC25D")
        @Override
        public boolean equals(Object o) {
            addTaint(o.getTaint());
            if(!(o instanceof Sample))            
            {
                boolean var68934A3E9455FA72420237EB05902327_1426777416 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_667542048 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_667542048;
            } //End block
            Sample s = (Sample) o;
            boolean var146294C726FD5568C55561DD938A6C96_1831665319 = (count == s.count && stackTrace.equals(s.stackTrace));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1307179420 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1307179420;
            // ---------- Original Method ----------
            //if (!(o instanceof Sample)) {
                //return false;
            //}
            //Sample s = (Sample) o;
            //return count == s.count && stackTrace.equals(s.stackTrace);
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.993 -0400", hash_original_method = "27C27C8BDAE57781C2B46A818775E5B8", hash_generated_method = "D6DB040F3718418A708F7E4587245BFD")
        @Override
        public String toString() {
String var23E8050A5E12C325B3BF3D999702FC4F_1719034158 =             "Sample[count=" + count + " " + stackTrace + "]";
            var23E8050A5E12C325B3BF3D999702FC4F_1719034158.addTaint(taint);
            return var23E8050A5E12C325B3BF3D999702FC4F_1719034158;
            // ---------- Original Method ----------
            //return "Sample[count=" + count + " " + stackTrace + "]";
        }

        
    }


    
}

