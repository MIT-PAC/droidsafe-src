package dalvik.system.profiler;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class BinaryHprofWriter {
    private int nextStringId = 1;
    private int nextClassId = 1;
    private int nextStackFrameId = 1;
    private Map<String, Integer> stringToId = new HashMap<String, Integer>();
    private Map<String, Integer> classNameToId = new HashMap<String, Integer>();
    private Map<StackTraceElement, Integer> stackFrameToId
            = new HashMap<StackTraceElement, Integer>();
    private HprofData data;
    private DataOutputStream out;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.330 -0400", hash_original_method = "732DAB84FABC53991CAEE3EC9AA68C95", hash_generated_method = "00A96FB898D03FBCAD0EBDBC8FC1441A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private BinaryHprofWriter(HprofData data, OutputStream outputStream) {
        dsTaint.addTaint(outputStream.dsTaint);
        dsTaint.addTaint(data.dsTaint);
        this.out = new DataOutputStream(outputStream);
        // ---------- Original Method ----------
        //this.data = data;
        //this.out = new DataOutputStream(outputStream);
    }

    
        public static void write(HprofData data, OutputStream outputStream) throws IOException {
        new BinaryHprofWriter(data, outputStream).write();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.337 -0400", hash_original_method = "6C7AC0DF0B31CD08E559C12305128F3F", hash_generated_method = "A7935433237AC3322505ECB581805896")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void write() throws IOException {
        try 
        {
            writeHeader(data.getStartMillis());
            writeControlSettings(data.getFlags(), data.getDepth());
            {
                Iterator<HprofData.ThreadEvent> var070E69574E1A624F954887941AC708CA_1537506538 = (data.getThreadHistory()).iterator();
                var070E69574E1A624F954887941AC708CA_1537506538.hasNext();
                HprofData.ThreadEvent event = var070E69574E1A624F954887941AC708CA_1537506538.next();
                {
                    writeThreadEvent(event);
                } //End block
            } //End collapsed parenthetic
            Set<HprofData.Sample> samples;
            samples = data.getSamples();
            int total;
            total = 0;
            {
                Iterator<HprofData.Sample> varA18F9CCB2314E9522801AE336380C59F_352212580 = (samples).iterator();
                varA18F9CCB2314E9522801AE336380C59F_352212580.hasNext();
                HprofData.Sample sample = varA18F9CCB2314E9522801AE336380C59F_352212580.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.337 -0400", hash_original_method = "C85B61C59E3F834AB2B5E220076F97DE", hash_generated_method = "1EDB5D776227D0D823DBFF6153DE7034")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.337 -0400", hash_original_method = "FDE35A19003ED22B657F91A2F0E06CCE", hash_generated_method = "3BCA85B9D79BBA7D2256F0220F7A4A12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.337 -0400", hash_original_method = "1F5D47BDA1DF5C3350AF092C7A31D89B", hash_generated_method = "66EBC42F0DEBB70C9B1E432DF160FB12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeThreadEvent(HprofData.ThreadEvent e) throws IOException {
        dsTaint.addTaint(e.dsTaint);
        //Begin case START 
        writeStartThread(e);
        //End case START 
        //Begin case END 
        writeStopThread(e);
        //End case END 
        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(e.type.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.342 -0400", hash_original_method = "8E01CAF6795D5E83C54B68F6912FFEBF", hash_generated_method = "1D26E8175199AE52A1ABF807D53B83FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.342 -0400", hash_original_method = "22EC0A4C26BDEF90544F91DCC7CD0649", hash_generated_method = "F94195CD6325728BC6E45B998A0075F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.342 -0400", hash_original_method = "676873B3FD0126014DC640E27218ACDD", hash_generated_method = "BB25E59758A2D584DDAFECE387F26CA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.343 -0400", hash_original_method = "444AE2A435FAF86B0F2CBA448766AD4E", hash_generated_method = "14B2AF1CB5921A6B028B9AEEFF38463D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeId(int id) throws IOException {
        dsTaint.addTaint(id);
        out.writeInt(id);
        // ---------- Original Method ----------
        //out.writeInt(id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.343 -0400", hash_original_method = "F126C5267DAD0F96A8C03752944B8779", hash_generated_method = "7549B6FA2696138CCA04806F657D1F41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.347 -0400", hash_original_method = "759EEA3A3B19BFF3937058AF4EFC13EB", hash_generated_method = "04BC0F939C73F9A1AAC074C618D91EB6")
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
            Iterator<HprofData.Sample> varA18F9CCB2314E9522801AE336380C59F_1885318157 = (samples).iterator();
            varA18F9CCB2314E9522801AE336380C59F_1885318157.hasNext();
            HprofData.Sample sample = varA18F9CCB2314E9522801AE336380C59F_1885318157.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.350 -0400", hash_original_method = "AA7BB7F509E670C633C84E0D44DE5DDB", hash_generated_method = "BF5CFC9ECE78EC1444EE18CC725C768F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.351 -0400", hash_original_method = "564218335BC7BDEEE42DF1829D6316AF", hash_generated_method = "EACFC02B58C19F2291374F3779F86213")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.352 -0400", hash_original_method = "0C83F2A39C21D86EF68CFCB925D16EF6", hash_generated_method = "D482695634A2E66B5D59BDB223DBEE93")
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

