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
    private long startMillis;
    private int flags;
    private int depth;
    private List<ThreadEvent> threadHistory = new ArrayList<ThreadEvent>();
    private Map<Integer, ThreadEvent> threadIdToThreadEvent
            = new HashMap<Integer, ThreadEvent>();
    private Map<HprofData.StackTrace, int[]> stackTraces;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.393 -0400", hash_original_method = "A1B0101007C345DF1FDD21D474244925", hash_generated_method = "E38DB41FE099E681CDFF3F24AF1102E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HprofData(Map<StackTrace, int[]> stackTraces) {
        dsTaint.addTaint(stackTraces.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("stackTraces == null");
        } //End block
        // ---------- Original Method ----------
        //if (stackTraces == null) {
            //throw new NullPointerException("stackTraces == null");
        //}
        //this.stackTraces = stackTraces;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.394 -0400", hash_original_method = "CC766E32F9FC42071F3CC3CB88E9A18A", hash_generated_method = "7DF664B05A85E904624BC16FD8560973")
    @DSModeled(DSC.SAFE)
    public long getStartMillis() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return startMillis;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.394 -0400", hash_original_method = "B0BB2E1F2492EC486CB4460593218E46", hash_generated_method = "81B50CB93CA49342DF027A37728FA556")
    @DSModeled(DSC.SAFE)
    public void setStartMillis(long startMillis) {
        dsTaint.addTaint(startMillis);
        // ---------- Original Method ----------
        //this.startMillis = startMillis;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.394 -0400", hash_original_method = "292C3EF40E00AFB28AC60AF92A04DB70", hash_generated_method = "1099582F53B3A7632B745D2BB78E8F73")
    @DSModeled(DSC.SAFE)
    public int getFlags() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.394 -0400", hash_original_method = "E55E0ED6FE66EB0D458BFDED224C9943", hash_generated_method = "A8DB46EB4A58F2C806160FC39051134C")
    @DSModeled(DSC.SAFE)
    public void setFlags(int flags) {
        dsTaint.addTaint(flags);
        // ---------- Original Method ----------
        //this.flags = flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.394 -0400", hash_original_method = "FBD5046615AAE9EDCC3CA2ADE86A92C3", hash_generated_method = "C632BC23F6868B2745BC9D50605AAAD3")
    @DSModeled(DSC.SAFE)
    public int getDepth() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return depth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.394 -0400", hash_original_method = "7E87B9040AF172D5ADB37F7AF7F75CA6", hash_generated_method = "4FE50B0BBD61FA3BA825142A9EE197D2")
    @DSModeled(DSC.SAFE)
    public void setDepth(int depth) {
        dsTaint.addTaint(depth);
        // ---------- Original Method ----------
        //this.depth = depth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.395 -0400", hash_original_method = "8C7F14531209B0BE4CB8ACECEBC720CC", hash_generated_method = "D92F20540F7FD93D844FD8EE4B090689")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<ThreadEvent> getThreadHistory() {
        List<ThreadEvent> varF9FCB2B0C28C601696B7DC9544FB3080_460589783 = (Collections.unmodifiableList(threadHistory));
        return (List<ThreadEvent>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Collections.unmodifiableList(threadHistory);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.396 -0400", hash_original_method = "F4E32CE6895396BD588CC20D263E2FB4", hash_generated_method = "FEC5B29AFB5DFF624DE85F9E7D89C576")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<Sample> getSamples() {
        Set<Sample> samples;
        samples = new HashSet<Sample>(stackTraces.size());
        {
            Iterator<Entry<StackTrace, int[]>> var90BB71089607029678F04EF3DD4C4774_126334716 = (stackTraces.entrySet()).iterator();
            var90BB71089607029678F04EF3DD4C4774_126334716.hasNext();
            Entry<StackTrace, int[]> e = var90BB71089607029678F04EF3DD4C4774_126334716.next();
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
        return (Set<Sample>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.396 -0400", hash_original_method = "3644EE7A7CD6AEAD3C58A3E47BD5EAC7", hash_generated_method = "2E0C8F34C30930B3DBF6E2B1690755EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addThreadEvent(ThreadEvent event) {
        dsTaint.addTaint(event.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.396 -0400", hash_original_method = "ED310F254F72ACCB3181D18F31C09E67", hash_generated_method = "7B14F9E389B0DF01050A9DCBEB972257")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addStackTrace(StackTrace stackTrace, int[] countCell) {
        dsTaint.addTaint(countCell[0]);
        dsTaint.addTaint(stackTrace.dsTaint);
        {
            boolean varF730A1A3EABF99869C11ED3AF87B008F_646917094 = (!threadIdToThreadEvent.containsKey(stackTrace.threadId));
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
        public ThreadEventType type;
        public int objectId;
        public int threadId;
        public String threadName;
        public String groupName;
        public String parentGroupName;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.397 -0400", hash_original_method = "418862520135AFAF9D5B41BB00EA7C53", hash_generated_method = "156C4EEB3520C41AEB891D5F401FEEC0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private ThreadEvent(ThreadEventType type, int objectId, int threadId,
                            String threadName, String groupName, String parentGroupName) {
            dsTaint.addTaint(groupName);
            dsTaint.addTaint(threadName);
            dsTaint.addTaint(threadId);
            dsTaint.addTaint(objectId);
            dsTaint.addTaint(parentGroupName);
            dsTaint.addTaint(type.dsTaint);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("threadName == null");
            } //End block
            this.type = ThreadEventType.START;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.397 -0400", hash_original_method = "87F2300773E111C1834911C7597238E6", hash_generated_method = "CA09CF9A75CF35D06EEC5E42DD56FA7B")
        @DSModeled(DSC.SAFE)
        private ThreadEvent(ThreadEventType type, int threadId) {
            dsTaint.addTaint(threadId);
            dsTaint.addTaint(type.dsTaint);
            this.type = ThreadEventType.END;
            this.objectId = -1;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.398 -0400", hash_original_method = "FD54D2802DF7D246F84571D313E0773D", hash_generated_method = "55CE26F0F43D7642760CC7E65B54EB3A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int result;
            result = 17;
            result = 31 * result + objectId;
            result = 31 * result + threadId;
            result = 31 * result + hashCode(threadName);
            result = 31 * result + hashCode(groupName);
            result = 31 * result + hashCode(parentGroupName);
            return dsTaint.getTaintInt();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.398 -0400", hash_original_method = "11A9724AFC12A4881460E902B1AEFFA3", hash_generated_method = "5F2AE201C804740ADADA1ED229295CDD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object o) {
            dsTaint.addTaint(o.dsTaint);
            ThreadEvent event;
            event = (ThreadEvent) o;
            boolean var4A4581E64171586ED6B283FBA9E8FB21_661424768 = ((this.type == event.type
                    && this.objectId == event.objectId
                    && this.threadId == event.threadId
                    && equal(this.threadName, event.threadName)
                    && equal(this.groupName, event.groupName)
                    && equal(this.parentGroupName, event.parentGroupName)));
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.399 -0400", hash_original_method = "B2760D4380298F8E4BDF009F5947B547", hash_generated_method = "4C6AFF84549EDAAF03190A168DFA3AA3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            //Begin case START 
            String varEA5F0E22DF5832A925FB033595AA2B0E_718126660 = (String.format(
                            "THREAD START (obj=%d, id = %d, name=\"%s\", group=\"%s\")",
                            objectId, threadId, threadName, groupName));
            //End case START 
            //Begin case END 
            String varC89EC01CF9CE07D23CE6BC3343C2AB37_1958596163 = (String.format("THREAD END (id = %d)", threadId));
            //End case END 
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(type.toString());
            return dsTaint.getTaintString();
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
        public int stackTraceId;
        int threadId;
        StackTraceElement[] stackFrames;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.402 -0400", hash_original_method = "937A3F2A08E08A14F8EC24A94B9A8468", hash_generated_method = "B8B05431485364C1F4F77D04A35AC9F2")
        @DSModeled(DSC.SAFE)
         StackTrace() {
            this.stackTraceId = -1;
            // ---------- Original Method ----------
            //this.stackTraceId = -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.402 -0400", hash_original_method = "D4A1391652F07F93D8818AA4C8761514", hash_generated_method = "5A3EF24B3B88FF9F62953FA0F4F44801")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public StackTrace(int stackTraceId, int threadId, StackTraceElement[] stackFrames) {
            dsTaint.addTaint(stackFrames[0].dsTaint);
            dsTaint.addTaint(threadId);
            dsTaint.addTaint(stackTraceId);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("stackFrames == null");
            } //End block
            // ---------- Original Method ----------
            //if (stackFrames == null) {
                //throw new NullPointerException("stackFrames == null");
            //}
            //this.stackTraceId = stackTraceId;
            //this.threadId = threadId;
            //this.stackFrames = stackFrames;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.402 -0400", hash_original_method = "904149F69266C7F1ED9811C71073DCCC", hash_generated_method = "DFB6A699F613056A4C102310E5D99B6C")
        @DSModeled(DSC.SAFE)
        public int getThreadId() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return threadId;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.402 -0400", hash_original_method = "825D6A57778B026225A4AA6FF793AA6E", hash_generated_method = "D5969790DC6BEE46498A12653CA9FC50")
        @DSModeled(DSC.SAFE)
        public StackTraceElement[] getStackFrames() {
            return (StackTraceElement[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return stackFrames;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.403 -0400", hash_original_method = "E0B79EC3EEC67C907668B24F8C3EF7D1", hash_generated_method = "3473F48EBEEEDF36A2CC983402B64B1C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int result;
            result = 17;
            result = 31 * result + threadId;
            result = 31 * result + Arrays.hashCode(stackFrames);
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int result = 17;
            //result = 31 * result + threadId;
            //result = 31 * result + Arrays.hashCode(stackFrames);
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.403 -0400", hash_original_method = "A370788F6EF207DC60ADB1FE1413BF45", hash_generated_method = "1EA02CAEE7375405E31E17AE89F349FC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object o) {
            dsTaint.addTaint(o.dsTaint);
            StackTrace s;
            s = (StackTrace) o;
            boolean varB7031E8E3AFE83BB1AAB81E860AA93C0_23739217 = (threadId == s.threadId && Arrays.equals(stackFrames, s.stackFrames));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (!(o instanceof StackTrace)) {
                //return false;
            //}
            //StackTrace s = (StackTrace) o;
            //return threadId == s.threadId && Arrays.equals(stackFrames, s.stackFrames);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.407 -0400", hash_original_method = "2C975038FABEA62C51E7521430E68593", hash_generated_method = "97D7982C3711C53DEC2FE5A97F5078B1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public String toString() {
            StringBuilder frames;
            frames = new StringBuilder();
            {
                frames.append('\n');
                {
                    StackTraceElement stackFrame = stackFrames[0];
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
            return dsTaint.getTaintString();
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
        public StackTrace stackTrace;
        public int count;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.407 -0400", hash_original_method = "8A8A799FE1363281492F811288A07E90", hash_generated_method = "6EA9C74D94B9BDDFC3B49BCC19B49894")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Sample(StackTrace stackTrace, int count) {
            dsTaint.addTaint(count);
            dsTaint.addTaint(stackTrace.dsTaint);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("stackTrace == null");
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("count < 0:" + count);
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.408 -0400", hash_original_method = "EB1A3879F5EB62721F94FC1BD32D5C70", hash_generated_method = "1F2320D868707ADAA6F0686629A40CD7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int result;
            result = 17;
            result = 31 * result + stackTrace.hashCode();
            result = 31 * result + count;
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int result = 17;
            //result = 31 * result + stackTrace.hashCode();
            //result = 31 * result + count;
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.408 -0400", hash_original_method = "9F96433135E9DB2A8F09B7286FEF9854", hash_generated_method = "0EDE3084E92FD0FBEBBB99A747F59061")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object o) {
            dsTaint.addTaint(o.dsTaint);
            Sample s;
            s = (Sample) o;
            boolean varA505477D65492DF14AC1310AAE4A1E15_1342852073 = (count == s.count && stackTrace.equals(s.stackTrace));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (!(o instanceof Sample)) {
                //return false;
            //}
            //Sample s = (Sample) o;
            //return count == s.count && stackTrace.equals(s.stackTrace);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.408 -0400", hash_original_method = "27C27C8BDAE57781C2B46A818775E5B8", hash_generated_method = "8CF424EEB65851D065EC51D4DA5B1629")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "Sample[count=" + count + " " + stackTrace + "]";
        }

        
    }


    
}

