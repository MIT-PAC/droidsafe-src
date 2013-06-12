package dalvik.system.profiler;

// Droidsafe Imports
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.runtime.DroidSafeAndroidRuntime;

public final class BinaryHprofWriter {
    private int nextStringId = 1;
    private int nextClassId = 1;
    private int nextStackFrameId = 1;
    private final Map<String, Integer> stringToId = new HashMap<String, Integer>();
    private final Map<String, Integer> classNameToId = new HashMap<String, Integer>();
    private final Map<StackTraceElement, Integer> stackFrameToId
            = new HashMap<StackTraceElement, Integer>();
    private HprofData data;
    private final DataOutputStream out;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.329 -0400", hash_original_method = "732DAB84FABC53991CAEE3EC9AA68C95", hash_generated_method = "8439D380D278275BA969E5A7731B8AB3")
    @DSModeled(DSC.SAFE)
    private BinaryHprofWriter(HprofData data, OutputStream outputStream) {
        dsTaint.addTaint(outputStream.dsTaint);
        dsTaint.addTaint(data.dsTaint);
        this.out = new DataOutputStream(outputStream);
        // ---------- Original Method ----------
        //this.data = data;
        //this.out = new DataOutputStream(outputStream);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.329 -0400", hash_original_method = "C319F61C77453FA6E7A0623E5D902038", hash_generated_method = "17F9EECE1A2A53AF05E8AE65670A5B6E")
    public static void write(HprofData data, OutputStream outputStream) throws IOException {
        new BinaryHprofWriter(data, outputStream).write();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.329 -0400", hash_original_method = "6C7AC0DF0B31CD08E559C12305128F3F", hash_generated_method = "107B30257E0A7B97B203FE769697E4E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void write() throws IOException {
        try 
        {
            writeHeader(data.getStartMillis());
            writeControlSettings(data.getFlags(), data.getDepth());
            {
                Iterator<HprofData.ThreadEvent> seatecAstronomy42 = data.getThreadHistory().iterator();
                seatecAstronomy42.hasNext();
                HprofData.ThreadEvent event = seatecAstronomy42.next();
                {
                    writeThreadEvent(event);
                } //End block
            } //End collapsed parenthetic
            Set<HprofData.Sample> samples;
            samples = data.getSamples();
            int total;
            total = 0;
            {
                Iterator<HprofData.Sample> seatecAstronomy42 = samples.iterator();
                seatecAstronomy42.hasNext();
                HprofData.Sample sample = seatecAstronomy42.next();
                {
                    total += sample.count;
                    writeStackTrace(sample.stackTrace);
                } //End block
            } //End collapsed parenthetic
            writeCpuSamples(total, samples);
        } //End block
        finally 
        {
            out.flush();
        } //End block
        // ---------- Original Method ----------
        //try {
            //writeHeader(data.getStartMillis());
            //writeControlSettings(data.getFlags(), data.getDepth());
            //for (HprofData.ThreadEvent event : data.getThreadHistory()) {
                //writeThreadEvent(event);
            //}
            //Set<HprofData.Sample> samples = data.getSamples();
            //int total = 0;
            //for (HprofData.Sample sample : samples) {
                //total += sample.count;
                //writeStackTrace(sample.stackTrace);
            //}
            //writeCpuSamples(total, samples);
        //} finally {
            //out.flush();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.329 -0400", hash_original_method = "C85B61C59E3F834AB2B5E220076F97DE", hash_generated_method = "D3E021FC3E7AECD333D5B9E3A13F712E")
    @DSModeled(DSC.SAFE)
    private void writeHeader(long dumpTimeInMilliseconds) throws IOException {
        dsTaint.addTaint(dumpTimeInMilliseconds);
        out.writeBytes(BinaryHprof.MAGIC + "1.0.2");
        out.writeByte(0);
        out.writeInt(BinaryHprof.ID_SIZE);
        out.writeLong(dumpTimeInMilliseconds);
        // ---------- Original Method ----------
        //out.writeBytes(BinaryHprof.MAGIC + "1.0.2");
        //out.writeByte(0);
        //out.writeInt(BinaryHprof.ID_SIZE);
        //out.writeLong(dumpTimeInMilliseconds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.329 -0400", hash_original_method = "FDE35A19003ED22B657F91A2F0E06CCE", hash_generated_method = "1F382A1E78944FC9184EAED5A873A93F")
    @DSModeled(DSC.SAFE)
    private void writeControlSettings(int flags, int depth) throws IOException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(depth);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("depth too large for binary hprof: "
                                               + depth + " > " + Short.MAX_VALUE);
        } //End block
        writeRecordHeader(BinaryHprof.Tag.CONTROL_SETTINGS,
                          0,
                          BinaryHprof.Tag.CONTROL_SETTINGS.maximumSize);
        out.writeInt(flags);
        out.writeShort((short) depth);
        // ---------- Original Method ----------
        //if (depth > Short.MAX_VALUE) {
            //throw new IllegalArgumentException("depth too large for binary hprof: "
                                               //+ depth + " > " + Short.MAX_VALUE);
        //}
        //writeRecordHeader(BinaryHprof.Tag.CONTROL_SETTINGS,
                          //0,
                          //BinaryHprof.Tag.CONTROL_SETTINGS.maximumSize);
        //out.writeInt(flags);
        //out.writeShort((short) depth);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.329 -0400", hash_original_method = "1F5D47BDA1DF5C3350AF092C7A31D89B", hash_generated_method = "886DB3D7455129698378711C1588EE16")
    @DSModeled(DSC.SAFE)
    private void writeThreadEvent(HprofData.ThreadEvent e) throws IOException {
        dsTaint.addTaint(e.dsTaint);
        //Begin case START 
        writeStartThread(e);
        //End case START 
        //Begin case END 
        writeStopThread(e);
        //End case END 
        throw new IllegalStateException(e.type.toString());
        // ---------- Original Method ----------
        //switch (e.type) {
            //case START:
                //writeStartThread(e);
                //return;
            //case END:
                //writeStopThread(e);
                //return;
        //}
        //throw new IllegalStateException(e.type.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.329 -0400", hash_original_method = "8E01CAF6795D5E83C54B68F6912FFEBF", hash_generated_method = "AD5180143BE91D61C013E3C07BD2F3FB")
    @DSModeled(DSC.SAFE)
    private void writeStartThread(HprofData.ThreadEvent e) throws IOException {
        dsTaint.addTaint(e.dsTaint);
        int threadNameId;
        threadNameId = writeString(e.threadName);
        int groupNameId;
        groupNameId = writeString(e.groupName);
        int parentGroupNameId;
        parentGroupNameId = writeString(e.parentGroupName);
        writeRecordHeader(BinaryHprof.Tag.START_THREAD,
                          0,
                          BinaryHprof.Tag.START_THREAD.maximumSize);
        out.writeInt(e.threadId);
        writeId(e.objectId);
        out.writeInt(0);
        writeId(threadNameId);
        writeId(groupNameId);
        writeId(parentGroupNameId);
        // ---------- Original Method ----------
        //int threadNameId = writeString(e.threadName);
        //int groupNameId = writeString(e.groupName);
        //int parentGroupNameId = writeString(e.parentGroupName);
        //writeRecordHeader(BinaryHprof.Tag.START_THREAD,
                          //0,
                          //BinaryHprof.Tag.START_THREAD.maximumSize);
        //out.writeInt(e.threadId);
        //writeId(e.objectId);
        //out.writeInt(0);
        //writeId(threadNameId);
        //writeId(groupNameId);
        //writeId(parentGroupNameId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.329 -0400", hash_original_method = "22EC0A4C26BDEF90544F91DCC7CD0649", hash_generated_method = "F86F2063826140910EAA131C8AFEB22D")
    @DSModeled(DSC.SAFE)
    private void writeStopThread(HprofData.ThreadEvent e) throws IOException {
        dsTaint.addTaint(e.dsTaint);
        writeRecordHeader(BinaryHprof.Tag.END_THREAD,
                          0,
                          BinaryHprof.Tag.END_THREAD.maximumSize);
        out.writeInt(e.threadId);
        // ---------- Original Method ----------
        //writeRecordHeader(BinaryHprof.Tag.END_THREAD,
                          //0,
                          //BinaryHprof.Tag.END_THREAD.maximumSize);
        //out.writeInt(e.threadId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.330 -0400", hash_original_method = "676873B3FD0126014DC640E27218ACDD", hash_generated_method = "47B9FCC337BA29E450ED492CEC9D5A6B")
    @DSModeled(DSC.SAFE)
    private void writeRecordHeader(BinaryHprof.Tag hprofTag,
                                   int timeDeltaInMicroseconds,
                                   int recordLength) throws IOException {
        dsTaint.addTaint(timeDeltaInMicroseconds);
        dsTaint.addTaint(recordLength);
        dsTaint.addTaint(hprofTag.dsTaint);
        String error;
        error = hprofTag.checkSize(recordLength);
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(error);
        } //End block
        out.writeByte(hprofTag.tag);
        out.writeInt(timeDeltaInMicroseconds);
        out.writeInt(recordLength);
        // ---------- Original Method ----------
        //String error = hprofTag.checkSize(recordLength);
        //if (error != null) {
            //throw new AssertionError(error);
        //}
        //out.writeByte(hprofTag.tag);
        //out.writeInt(timeDeltaInMicroseconds);
        //out.writeInt(recordLength);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.330 -0400", hash_original_method = "444AE2A435FAF86B0F2CBA448766AD4E", hash_generated_method = "88E68778EAC9DCF6543D739C506265FF")
    @DSModeled(DSC.SAFE)
    private void writeId(int id) throws IOException {
        dsTaint.addTaint(id);
        out.writeInt(id);
        // ---------- Original Method ----------
        //out.writeInt(id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.330 -0400", hash_original_method = "F126C5267DAD0F96A8C03752944B8779", hash_generated_method = "4237A55FF8CF6EC49E50F804082D9D95")
    @DSModeled(DSC.SAFE)
    private int writeString(String string) throws IOException {
        dsTaint.addTaint(string);
        Integer identifier;
        identifier = stringToId.get(string);
        int id;
        id = nextStringId++;
        stringToId.put(string, id);
        byte[] bytes;
        bytes = string.getBytes("UTF-8");
        writeRecordHeader(BinaryHprof.Tag.STRING_IN_UTF8,
                          0,
                          BinaryHprof.ID_SIZE + bytes.length);
        out.writeInt(id);
        out.write(bytes, 0, bytes.length);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (string == null) {
            //return 0;
        //}
        //Integer identifier = stringToId.get(string);
        //if (identifier != null) {
            //return identifier;
        //}
        //int id = nextStringId++;
        //stringToId.put(string, id);
        //byte[] bytes = string.getBytes("UTF-8");
        //writeRecordHeader(BinaryHprof.Tag.STRING_IN_UTF8,
                          //0,
                          //BinaryHprof.ID_SIZE + bytes.length);
        //out.writeInt(id);
        //out.write(bytes, 0, bytes.length);
        //return id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.330 -0400", hash_original_method = "759EEA3A3B19BFF3937058AF4EFC13EB", hash_generated_method = "52E70F6037C1C91487AD456FA59CBC16")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeCpuSamples(int totalSamples, Set<HprofData.Sample> samples) throws IOException {
        dsTaint.addTaint(totalSamples);
        dsTaint.addTaint(samples.dsTaint);
        int samplesCount;
        samplesCount = samples.size();
        writeRecordHeader(BinaryHprof.Tag.CPU_SAMPLES, 0, 4 + 4 + (samplesCount * (4 + 4)));
        out.writeInt(totalSamples);
        out.writeInt(samplesCount);
        {
            Iterator<HprofData.Sample> seatecAstronomy42 = samples.iterator();
            seatecAstronomy42.hasNext();
            HprofData.Sample sample = seatecAstronomy42.next();
            {
                out.writeInt(sample.count);
                out.writeInt(sample.stackTrace.stackTraceId);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //int samplesCount = samples.size();
        //if (samplesCount == 0) {
            //return;
        //}
        //writeRecordHeader(BinaryHprof.Tag.CPU_SAMPLES, 0, 4 + 4 + (samplesCount * (4 + 4)));
        //out.writeInt(totalSamples);
        //out.writeInt(samplesCount);
        //for (HprofData.Sample sample : samples) {
            //out.writeInt(sample.count);
            //out.writeInt(sample.stackTrace.stackTraceId);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.330 -0400", hash_original_method = "AA7BB7F509E670C633C84E0D44DE5DDB", hash_generated_method = "FD88578A8F115CDE8732B9BDD1FE3EE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeStackTrace(HprofData.StackTrace stackTrace) throws IOException {
        dsTaint.addTaint(stackTrace.dsTaint);
        int frames;
        frames = stackTrace.stackFrames.length;
        int[] stackFrameIds;
        stackFrameIds = new int[frames];
        {
            int i;
            i = 0;
            {
                stackFrameIds[i] = writeStackFrame(stackTrace.stackFrames[i]);
            } //End block
        } //End collapsed parenthetic
        writeRecordHeader(BinaryHprof.Tag.STACK_TRACE,
                          0,
                          4 + 4 + 4 + (frames * BinaryHprof.ID_SIZE));
        out.writeInt(stackTrace.stackTraceId);
        out.writeInt(stackTrace.threadId);
        out.writeInt(frames);
        {
            int stackFrameId = stackFrameIds[0];
            {
                writeId(stackFrameId);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //int frames = stackTrace.stackFrames.length;
        //int[] stackFrameIds = new int[frames];
        //for (int i = 0; i < frames; i++) {
            //stackFrameIds[i] = writeStackFrame(stackTrace.stackFrames[i]);
        //}
        //writeRecordHeader(BinaryHprof.Tag.STACK_TRACE,
                          //0,
                          //4 + 4 + 4 + (frames * BinaryHprof.ID_SIZE));
        //out.writeInt(stackTrace.stackTraceId);
        //out.writeInt(stackTrace.threadId);
        //out.writeInt(frames);
        //for (int stackFrameId : stackFrameIds) {
            //writeId(stackFrameId);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.330 -0400", hash_original_method = "564218335BC7BDEEE42DF1829D6316AF", hash_generated_method = "B247E749E3F6015D4681C5DDCB33D006")
    @DSModeled(DSC.SAFE)
    private int writeLoadClass(String className) throws IOException {
        dsTaint.addTaint(className);
        Integer identifier;
        identifier = classNameToId.get(className);
        int id;
        id = nextClassId++;
        classNameToId.put(className, id);
        int classNameId;
        classNameId = writeString(className);
        writeRecordHeader(BinaryHprof.Tag.LOAD_CLASS,
                          0,
                          BinaryHprof.Tag.LOAD_CLASS.maximumSize);
        out.writeInt(id);
        writeId(0);
        out.writeInt(0);
        writeId(classNameId);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Integer identifier = classNameToId.get(className);
        //if (identifier != null) {
            //return identifier;
        //}
        //int id = nextClassId++;
        //classNameToId.put(className, id);
        //int classNameId = writeString(className);
        //writeRecordHeader(BinaryHprof.Tag.LOAD_CLASS,
                          //0,
                          //BinaryHprof.Tag.LOAD_CLASS.maximumSize);
        //out.writeInt(id);
        //writeId(0);
        //out.writeInt(0);
        //writeId(classNameId);
        //return id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.330 -0400", hash_original_method = "0C83F2A39C21D86EF68CFCB925D16EF6", hash_generated_method = "713EC65A51279B290E746F327E0BFFF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int writeStackFrame(StackTraceElement stackFrame) throws IOException {
        dsTaint.addTaint(stackFrame.dsTaint);
        Integer identifier;
        identifier = stackFrameToId.get(stackFrame);
        int id;
        id = nextStackFrameId++;
        stackFrameToId.put(stackFrame, id);
        int classId;
        classId = writeLoadClass(stackFrame.getClassName());
        int methodNameId;
        methodNameId = writeString(stackFrame.getMethodName());
        int sourceId;
        sourceId = writeString(stackFrame.getFileName());
        writeRecordHeader(BinaryHprof.Tag.STACK_FRAME,
                          0,
                          BinaryHprof.Tag.STACK_FRAME.maximumSize);
        writeId(id);
        writeId(methodNameId);
        writeId(0);
        writeId(sourceId);
        out.writeInt(classId);
        out.writeInt(stackFrame.getLineNumber());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Integer identifier = stackFrameToId.get(stackFrame);
        //if (identifier != null) {
            //return identifier;
        //}
        //int id = nextStackFrameId++;
        //stackFrameToId.put(stackFrame, id);
        //int classId = writeLoadClass(stackFrame.getClassName());
        //int methodNameId = writeString(stackFrame.getMethodName());
        //int sourceId = writeString(stackFrame.getFileName());
        //writeRecordHeader(BinaryHprof.Tag.STACK_FRAME,
                          //0,
                          //BinaryHprof.Tag.STACK_FRAME.maximumSize);
        //writeId(id);
        //writeId(methodNameId);
        //writeId(0);
        //writeId(sourceId);
        //out.writeInt(classId);
        //out.writeInt(stackFrame.getLineNumber());
        //return id;
    }

    
}


