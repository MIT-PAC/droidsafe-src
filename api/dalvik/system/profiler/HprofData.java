package dalvik.system.profiler;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;






public final class HprofData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.693 -0500", hash_original_field = "CCC3D06B79CAFED038554FC560DC20F2", hash_generated_field = "3F4204ABC43917BE7A39B6FD85E75A38")

    private long startMillis;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.695 -0500", hash_original_field = "E0CDE1A38A40425C446F52269E5723DC", hash_generated_field = "C01DA7975DA485EEDBF522635D053B3B")

    private int flags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.697 -0500", hash_original_field = "C1588B2CF4C1B54961548959E16213DF", hash_generated_field = "9E4E1D4E0DD2F9B43B1F6C7CB67C1409")

    private int depth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.700 -0500", hash_original_field = "81F44FDB112AAC24AED075B1DEF972B3", hash_generated_field = "EBD0F48FF63E7A93B0B5B1649E0D9BEE")

    private final List<ThreadEvent> threadHistory = new ArrayList<ThreadEvent>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.703 -0500", hash_original_field = "93AC4A9709C005797F6D97D5912CB92B", hash_generated_field = "5C4F57CC1BAFED6BB9221F867FA6736B")

    private final Map<Integer, ThreadEvent> threadIdToThreadEvent
            = new HashMap<Integer, ThreadEvent>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.705 -0500", hash_original_field = "0A492A65D02690DA4DE193CD8C2DAF94", hash_generated_field = "2E2E6C57E5FA37C42CB4DC1BB6563D4D")

    private  Map<HprofData.StackTrace, int[]> stackTraces;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.708 -0500", hash_original_method = "A1B0101007C345DF1FDD21D474244925", hash_generated_method = "C59968D73AF1C25ADDA3C8D54E6E39B9")
    
public HprofData(Map<StackTrace, int[]> stackTraces) {
        if (stackTraces == null) {
            throw new NullPointerException("stackTraces == null");
        }
        this.stackTraces = stackTraces;
    }

    /**
     * The start time in milliseconds of the last profiling period.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.710 -0500", hash_original_method = "CC766E32F9FC42071F3CC3CB88E9A18A", hash_generated_method = "5DFED02867B4C86DCD418B60AB8F7F67")
    
public long getStartMillis() {
        return startMillis;
    }

    /**
     * Set the time for the start of the current sampling period.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.712 -0500", hash_original_method = "B0BB2E1F2492EC486CB4460593218E46", hash_generated_method = "5D4D2463FBE03830F631C6E47B6E3896")
    
public void setStartMillis(long startMillis) {
        this.startMillis = startMillis;
    }

    /**
     * Get the {@link BinaryHprof.ControlSettings} flags
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.714 -0500", hash_original_method = "292C3EF40E00AFB28AC60AF92A04DB70", hash_generated_method = "CC5C57694954790DFE0798B5EEEFB43F")
    
public int getFlags() {
        return flags;
    }

    /**
     * Set the {@link BinaryHprof.ControlSettings} flags
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.717 -0500", hash_original_method = "E55E0ED6FE66EB0D458BFDED224C9943", hash_generated_method = "250DC1B2017D37145ED32B9EC5CEF574")
    
public void setFlags(int flags) {
        this.flags = flags;
    }

    /**
     * Get the stack sampling depth
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.720 -0500", hash_original_method = "FBD5046615AAE9EDCC3CA2ADE86A92C3", hash_generated_method = "6ED96C446AA91DED02D62E1E51123207")
    
public int getDepth() {
        return depth;
    }

    /**
     * Set the stack sampling depth
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.722 -0500", hash_original_method = "7E87B9040AF172D5ADB37F7AF7F75CA6", hash_generated_method = "86B481C53ED0C02A380F0F9215CF3469")
    
public void setDepth(int depth) {
        this.depth = depth;
    }

    /**
     * Return an unmodifiable history of start and end thread events.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.724 -0500", hash_original_method = "8C7F14531209B0BE4CB8ACECEBC720CC", hash_generated_method = "3DDF55655FB376AF384993A7404EF90E")
    
public List<ThreadEvent> getThreadHistory() {
        return Collections.unmodifiableList(threadHistory);
    }

    /**
     * Return a new set containing the current sample data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.727 -0500", hash_original_method = "F4E32CE6895396BD588CC20D263E2FB4", hash_generated_method = "92D2F2509F3C364991DD4D5EE192C859")
    
public Set<Sample> getSamples() {
        Set<Sample> samples = new HashSet<Sample>(stackTraces.size());
        for (Entry<StackTrace, int[]> e : stackTraces.entrySet()) {
            StackTrace stackTrace = e.getKey();
            int countCell[] = e.getValue();
            int count = countCell[0];
            Sample sample = new Sample(stackTrace, count);
            samples.add(sample);
        }
        return samples;
    }

    /**
     * Record an event in the thread history.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.729 -0500", hash_original_method = "3644EE7A7CD6AEAD3C58A3E47BD5EAC7", hash_generated_method = "320151FEF5A6590F3282C2B362B54FEA")
    
public void addThreadEvent(ThreadEvent event) {
        if (event == null) {
            throw new NullPointerException("event == null");
        }
        ThreadEvent old = threadIdToThreadEvent.put(event.threadId, event);
        switch (event.type) {
            case START:
                if (old != null) {
                    throw new IllegalArgumentException("ThreadEvent already registered for id "
                                                       + event.threadId);
                }
                break;
            case END:
                // Do not assert that the END_THREAD matches a
                // START_THREAD unless in strict mode. While thhis
                // hold true in the binary hprof BinaryHprofWriter
                // produces, it is not true of hprof files created
                // by the RI. However, if there is an event
                // already registed for a thread id, it should be
                // the matching start, not a duplicate end.
                if (old != null && old.type == ThreadEventType.END) {
                    throw new IllegalArgumentException("Duplicate ThreadEvent.end for id "
                                                       + event.threadId);
                }
                break;
        }
        threadHistory.add(event);
    }

    /**
     * Record an stack trace and an associated int[] cell of
     * sample cound for the stack trace. The caller is allowed
     * retain a pointer to the cell to update the count. The
     * SamplingProfiler intentionally does not present a mutable
     * view of the count.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.732 -0500", hash_original_method = "ED310F254F72ACCB3181D18F31C09E67", hash_generated_method = "7C025AC8F8B6B6795C0C122F7C211279")
    
public void addStackTrace(StackTrace stackTrace, int[] countCell) {
        if (!threadIdToThreadEvent.containsKey(stackTrace.threadId)) {
            throw new IllegalArgumentException("Unknown thread id " + stackTrace.threadId);
        }
        int[] old = stackTraces.put(stackTrace, countCell);
        if (old != null) {
            throw new IllegalArgumentException("StackTrace already registered for id "
                                               + stackTrace.stackTraceId + ":\n" + stackTrace);
        }
    }

    
    public static enum ThreadEventType { START, END }

    
    public static final class ThreadEvent {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.617 -0500", hash_original_method = "8B072BF0CC5004DB46A12D10CCF40F97", hash_generated_method = "A4634E04CF65ADE0D72ACF64F90BC14B")
        
public static ThreadEvent start(int objectId, int threadId, String threadName,
                                        String groupName, String parentGroupName) {
            return new ThreadEvent(ThreadEventType.START, objectId, threadId,
                                   threadName, groupName, parentGroupName);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.619 -0500", hash_original_method = "901E6A93B303D4C7329BD179229E74BE", hash_generated_method = "1D5CF694D615060FE1B48AE9EA0B869F")
        
public static ThreadEvent end(int threadId) {
            return new ThreadEvent(ThreadEventType.END, threadId);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.631 -0500", hash_original_method = "970ADDE5DABB38D7F42BDDA2D6B8B600", hash_generated_method = "19D9FC52574E06EFA4712248DEA04B2B")
        
private static int hashCode(Object o) {
            return (o == null) ? 0 : o.hashCode();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.636 -0500", hash_original_method = "F296275000E1AA53C7B464F5FDA7A4B5", hash_generated_method = "F9577F39E347D35EFA8791D7277C6A04")
        
private static boolean equal(Object a, Object b) {
            return a == b || (a != null && a.equals(b));
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.601 -0500", hash_original_field = "2AA265C03E7586B6734354525F5AB544", hash_generated_field = "7D87225C2426FF111F6FEB910554E402")


        public  ThreadEventType type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.604 -0500", hash_original_field = "00245E1AE29A0DD3B3A439E83E250472", hash_generated_field = "50DDAAE60FEC6646E9C40B14D16B89C4")

        public  int objectId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.607 -0500", hash_original_field = "21BB19B62D16F0B2F30983971184762D", hash_generated_field = "F04E415998CFF5C3E3E3A9ABC2303E69")

        public  int threadId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.609 -0500", hash_original_field = "26B70AE8410A59720B0E47D60285AB1C", hash_generated_field = "113B76C8DC7050E98D3CE8623AE010CB")

        public  String threadName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.612 -0500", hash_original_field = "70C08795F68A01BDC8DAEF2DF8D35A27", hash_generated_field = "93B2A487547CBE3E3CA82EF8BA52C0EE")

        public  String groupName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.614 -0500", hash_original_field = "46D524CB39A5C105040A4A718F15C561", hash_generated_field = "CA659A31009B2F91CD0C2968AC161B2C")

        public  String parentGroupName;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.622 -0500", hash_original_method = "418862520135AFAF9D5B41BB00EA7C53", hash_generated_method = "7BDE17DE9D5281350686029441C1B98B")
        
private ThreadEvent(ThreadEventType type, int objectId, int threadId,
                            String threadName, String groupName, String parentGroupName) {
            if (threadName == null) {
                throw new NullPointerException("threadName == null");
            }
            this.type = ThreadEventType.START;
            this.objectId = objectId;
            this.threadId = threadId;
            this.threadName = threadName;
            this.groupName = groupName;
            this.parentGroupName = parentGroupName;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.626 -0500", hash_original_method = "87F2300773E111C1834911C7597238E6", hash_generated_method = "5C00E1B10C5D38D97ECBA603E0592765")
        
private ThreadEvent(ThreadEventType type, int threadId) {
            this.type = ThreadEventType.END;
            this.objectId = -1;
            this.threadId = threadId;
            this.threadName = null;
            this.groupName = null;
            this.parentGroupName = null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.629 -0500", hash_original_method = "FD54D2802DF7D246F84571D313E0773D", hash_generated_method = "F46316606B4ECC5031DC4889DFA2B97D")
        
@Override public int hashCode() {
            int result = 17;
            result = 31 * result + objectId;
            result = 31 * result + threadId;
            result = 31 * result + hashCode(threadName);
            result = 31 * result + hashCode(groupName);
            result = 31 * result + hashCode(parentGroupName);
            return result;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.633 -0500", hash_original_method = "11A9724AFC12A4881460E902B1AEFFA3", hash_generated_method = "EE11CCD3CC57E7DF758713E3E4B38A33")
        
@Override public boolean equals(Object o) {
            if (!(o instanceof ThreadEvent)) {
                return false;
            }
            ThreadEvent event = (ThreadEvent) o;
            return (this.type == event.type
                    && this.objectId == event.objectId
                    && this.threadId == event.threadId
                    && equal(this.threadName, event.threadName)
                    && equal(this.groupName, event.groupName)
                    && equal(this.parentGroupName, event.parentGroupName));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.638 -0500", hash_original_method = "B2760D4380298F8E4BDF009F5947B547", hash_generated_method = "00D33050A805DF122F8DD66BA58B8B75")
        
@Override public String toString() {
            switch (type) {
                case START:
                    return String.format(
                            "THREAD START (obj=%d, id = %d, name=\"%s\", group=\"%s\")",
                            objectId, threadId, threadName, groupName);
                case END:
                    return String.format("THREAD END (id = %d)", threadId);
            }
            throw new IllegalStateException(type.toString());
        }

        
    }


    
    public static final class StackTrace {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.645 -0500", hash_original_field = "6CD02BBE38AFAB80C88CFC5EE8CFD952", hash_generated_field = "4628C5C3D0941960F68046E7C771CD60")


        public  int stackTraceId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.648 -0500", hash_original_field = "21BB19B62D16F0B2F30983971184762D", hash_generated_field = "21BB19B62D16F0B2F30983971184762D")

        int threadId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.650 -0500", hash_original_field = "088C6E829F236000DB4EE42B0CB07B24", hash_generated_field = "088C6E829F236000DB4EE42B0CB07B24")

        StackTraceElement[] stackFrames;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.653 -0500", hash_original_method = "937A3F2A08E08A14F8EC24A94B9A8468", hash_generated_method = "937A3F2A08E08A14F8EC24A94B9A8468")
        
StackTrace() {
            this.stackTraceId = -1;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.656 -0500", hash_original_method = "D4A1391652F07F93D8818AA4C8761514", hash_generated_method = "4234C078BCD6CF4D3FDD0A8FC7E24BBC")
        
public StackTrace(int stackTraceId, int threadId, StackTraceElement[] stackFrames) {
            if (stackFrames == null) {
                throw new NullPointerException("stackFrames == null");
            }
            this.stackTraceId = stackTraceId;
            this.threadId = threadId;
            this.stackFrames = stackFrames;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.658 -0500", hash_original_method = "904149F69266C7F1ED9811C71073DCCC", hash_generated_method = "B87E220E1B22B36F3EA17408C9656836")
        
public int getThreadId() {
            return threadId;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.660 -0500", hash_original_method = "825D6A57778B026225A4AA6FF793AA6E", hash_generated_method = "E045C14A4037FAF0AFE26F96327575F2")
        
public StackTraceElement[] getStackFrames() {
            return stackFrames;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.663 -0500", hash_original_method = "E0B79EC3EEC67C907668B24F8C3EF7D1", hash_generated_method = "AFE401C67F6D931BCAAEF0E82CFDAA82")
        
@Override public int hashCode() {
            int result = 17;
            result = 31 * result + threadId;
            result = 31 * result + Arrays.hashCode(stackFrames);
            return result;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.665 -0500", hash_original_method = "A370788F6EF207DC60ADB1FE1413BF45", hash_generated_method = "4A682E3E47DCF75C1A45CA35D4B2C91C")
        
@Override public boolean equals(Object o) {
            if (!(o instanceof StackTrace)) {
                return false;
            }
            StackTrace s = (StackTrace) o;
            return threadId == s.threadId && Arrays.equals(stackFrames, s.stackFrames);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.668 -0500", hash_original_method = "2C975038FABEA62C51E7521430E68593", hash_generated_method = "8D486D7C7A0831C4B88D3C042858FBFC")
        
@Override public String toString() {
            StringBuilder frames = new StringBuilder();
            if (stackFrames.length > 0) {
                frames.append('\n');
                for (StackTraceElement stackFrame : stackFrames) {
                    frames.append("\t at ");
                    frames.append(stackFrame);
                    frames.append('\n');
                }
            } else {
                frames.append("<empty>");
            }
            return "StackTrace[stackTraceId=" + stackTraceId
                    + ", threadId=" + threadId
                    + ", frames=" + frames + "]";

        }

        
    }


    
    public static final class Sample {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.675 -0500", hash_original_field = "E3CFE6D063747167045A230949FF33E5", hash_generated_field = "3CCE78B4D1712F23531BA45DE99ABF0D")


        public  StackTrace stackTrace;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.677 -0500", hash_original_field = "B83BF7ED7F5719DA923E1BC0AC69952B", hash_generated_field = "21B1DF5337CCD3E0731435FB1361ED67")

        public  int count;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.680 -0500", hash_original_method = "8A8A799FE1363281492F811288A07E90", hash_generated_method = "FB7B0C4CF16FBFD194CD3684D5B31E85")
        
private Sample(StackTrace stackTrace, int count) {
            if (stackTrace == null) {
                throw new NullPointerException("stackTrace == null");
            }
            if (count < 0) {
                throw new IllegalArgumentException("count < 0:" + count);
            }
            this.stackTrace = stackTrace;
            this.count = count;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.683 -0500", hash_original_method = "EB1A3879F5EB62721F94FC1BD32D5C70", hash_generated_method = "2C3496A2A5F7EE7E98BA86BEBEA28FA1")
        
@Override public int hashCode() {
            int result = 17;
            result = 31 * result + stackTrace.hashCode();
            result = 31 * result + count;
            return result;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.686 -0500", hash_original_method = "9F96433135E9DB2A8F09B7286FEF9854", hash_generated_method = "2B472D21EA9052EA3DFD5383BF7255CA")
        
@Override public boolean equals(Object o) {
            if (!(o instanceof Sample)) {
                return false;
            }
            Sample s = (Sample) o;
            return count == s.count && stackTrace.equals(s.stackTrace);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:40.688 -0500", hash_original_method = "27C27C8BDAE57781C2B46A818775E5B8", hash_generated_method = "91AD06F5748CB950C2424F6F1F5DE469")
        
@Override public String toString() {
            return "Sample[count=" + count + " " + stackTrace + "]";
        }

        
    }


    
}

