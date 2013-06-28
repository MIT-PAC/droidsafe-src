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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.875 -0400", hash_original_field = "7E68DA75B9A11053C85FBA5DDEFD4449", hash_generated_field = "F6789153277D04B710C8FC8F6CD54F9E")

    private int nextStringId = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.875 -0400", hash_original_field = "C84BDAB09B513196433B1BAEBF02636F", hash_generated_field = "7A760F4F16EAFCB07FE0A0FC4C3F75E3")

    private int nextClassId = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.875 -0400", hash_original_field = "E8225D3D919F19BF647928E1C35BAC9C", hash_generated_field = "E479771D08904C609A002C4DAE48E586")

    private int nextStackFrameId = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.875 -0400", hash_original_field = "C6F94A0430429BC5B5CBDD661134864F", hash_generated_field = "F11F893B57923B552068E07C0B6278CE")

    private final Map<String, Integer> stringToId = new HashMap<String, Integer>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.875 -0400", hash_original_field = "5AF1F4E411FFF4CB8F713A02E8256963", hash_generated_field = "449F2DFD040184E791A3059DABA5B89A")

    private final Map<String, Integer> classNameToId = new HashMap<String, Integer>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.875 -0400", hash_original_field = "48E7FAE6A0D04CC3B01B707722B6D2C1", hash_generated_field = "D35B504B290ED4F518BA1C114674FBAA")

    private final Map<StackTraceElement, Integer> stackFrameToId = new HashMap<StackTraceElement, Integer>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.875 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "BD98D42EB76BD47A6FDE7B8FA850AB03")

    private HprofData data;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.875 -0400", hash_original_field = "C68271A63DDBC431C307BEB7D2918275", hash_generated_field = "58B7027288BADB051D787F0275726007")

    private DataOutputStream out;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.875 -0400", hash_original_method = "732DAB84FABC53991CAEE3EC9AA68C95", hash_generated_method = "C306B4BCFF5195975397838E8E1DDCB6")
    private  BinaryHprofWriter(HprofData data, OutputStream outputStream) {
        this.data = data;
        this.out = new DataOutputStream(outputStream);
        // ---------- Original Method ----------
        //this.data = data;
        //this.out = new DataOutputStream(outputStream);
    }

    
    public static void write(HprofData data, OutputStream outputStream) throws IOException {
        new BinaryHprofWriter(data, outputStream).write();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.885 -0400", hash_original_method = "6C7AC0DF0B31CD08E559C12305128F3F", hash_generated_method = "A7259672CA800AD8EC10D351C90CE478")
    private void write() throws IOException {
        try 
        {
            writeHeader(data.getStartMillis());
            writeControlSettings(data.getFlags(), data.getDepth());
            {
                Iterator<HprofData.ThreadEvent> var070E69574E1A624F954887941AC708CA_1734549633 = (data.getThreadHistory()).iterator();
                var070E69574E1A624F954887941AC708CA_1734549633.hasNext();
                HprofData.ThreadEvent event = var070E69574E1A624F954887941AC708CA_1734549633.next();
                {
                    writeThreadEvent(event);
                } //End block
            } //End collapsed parenthetic
            Set<HprofData.Sample> samples = data.getSamples();
            int total = 0;
            {
                Iterator<HprofData.Sample> varA18F9CCB2314E9522801AE336380C59F_783081474 = (samples).iterator();
                varA18F9CCB2314E9522801AE336380C59F_783081474.hasNext();
                HprofData.Sample sample = varA18F9CCB2314E9522801AE336380C59F_783081474.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.885 -0400", hash_original_method = "C85B61C59E3F834AB2B5E220076F97DE", hash_generated_method = "309CBD5602C849BC5E57B886A266C33C")
    private void writeHeader(long dumpTimeInMilliseconds) throws IOException {
        out.writeBytes(BinaryHprof.MAGIC + "1.0.2");
        out.writeByte(0);
        out.writeInt(BinaryHprof.ID_SIZE);
        out.writeLong(dumpTimeInMilliseconds);
        addTaint(dumpTimeInMilliseconds);
        // ---------- Original Method ----------
        //out.writeBytes(BinaryHprof.MAGIC + "1.0.2");
        //out.writeByte(0);
        //out.writeInt(BinaryHprof.ID_SIZE);
        //out.writeLong(dumpTimeInMilliseconds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.886 -0400", hash_original_method = "FDE35A19003ED22B657F91A2F0E06CCE", hash_generated_method = "DF4BAF35069C74F3F635C5AF381B8F69")
    private void writeControlSettings(int flags, int depth) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("depth too large for binary hprof: "
                                               + depth + " > " + Short.MAX_VALUE);
        } //End block
        writeRecordHeader(BinaryHprof.Tag.CONTROL_SETTINGS,
                          0,
                          BinaryHprof.Tag.CONTROL_SETTINGS.maximumSize);
        out.writeInt(flags);
        out.writeShort((short) depth);
        addTaint(flags);
        addTaint(depth);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.886 -0400", hash_original_method = "1F5D47BDA1DF5C3350AF092C7A31D89B", hash_generated_method = "0F2DE3230EC283F197093DE4A687E2FD")
    private void writeThreadEvent(HprofData.ThreadEvent e) throws IOException {
        //Begin case START 
        writeStartThread(e);
        //End case START 
        //Begin case END 
        writeStopThread(e);
        //End case END 
        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(e.type.toString());
        addTaint(e.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.887 -0400", hash_original_method = "8E01CAF6795D5E83C54B68F6912FFEBF", hash_generated_method = "0903111945E53A5BE6B6BBDD8395A117")
    private void writeStartThread(HprofData.ThreadEvent e) throws IOException {
        int threadNameId = writeString(e.threadName);
        int groupNameId = writeString(e.groupName);
        int parentGroupNameId = writeString(e.parentGroupName);
        writeRecordHeader(BinaryHprof.Tag.START_THREAD,
                          0,
                          BinaryHprof.Tag.START_THREAD.maximumSize);
        out.writeInt(e.threadId);
        writeId(e.objectId);
        out.writeInt(0);
        writeId(threadNameId);
        writeId(groupNameId);
        writeId(parentGroupNameId);
        addTaint(e.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.887 -0400", hash_original_method = "22EC0A4C26BDEF90544F91DCC7CD0649", hash_generated_method = "42F889CD6216B33A9528B3493A8EF14C")
    private void writeStopThread(HprofData.ThreadEvent e) throws IOException {
        writeRecordHeader(BinaryHprof.Tag.END_THREAD,
                          0,
                          BinaryHprof.Tag.END_THREAD.maximumSize);
        out.writeInt(e.threadId);
        addTaint(e.getTaint());
        // ---------- Original Method ----------
        //writeRecordHeader(BinaryHprof.Tag.END_THREAD,
                          //0,
                          //BinaryHprof.Tag.END_THREAD.maximumSize);
        //out.writeInt(e.threadId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.888 -0400", hash_original_method = "676873B3FD0126014DC640E27218ACDD", hash_generated_method = "AB5B28C39CA7F351FC3EF72C947A7877")
    private void writeRecordHeader(BinaryHprof.Tag hprofTag,
                                   int timeDeltaInMicroseconds,
                                   int recordLength) throws IOException {
        String error = hprofTag.checkSize(recordLength);
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(error);
        } //End block
        out.writeByte(hprofTag.tag);
        out.writeInt(timeDeltaInMicroseconds);
        out.writeInt(recordLength);
        addTaint(hprofTag.getTaint());
        addTaint(timeDeltaInMicroseconds);
        addTaint(recordLength);
        // ---------- Original Method ----------
        //String error = hprofTag.checkSize(recordLength);
        //if (error != null) {
            //throw new AssertionError(error);
        //}
        //out.writeByte(hprofTag.tag);
        //out.writeInt(timeDeltaInMicroseconds);
        //out.writeInt(recordLength);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.889 -0400", hash_original_method = "444AE2A435FAF86B0F2CBA448766AD4E", hash_generated_method = "C4A51450BBCA14F0C5623683FB3F2463")
    private void writeId(int id) throws IOException {
        out.writeInt(id);
        addTaint(id);
        // ---------- Original Method ----------
        //out.writeInt(id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.889 -0400", hash_original_method = "F126C5267DAD0F96A8C03752944B8779", hash_generated_method = "67DFBBB8DAB5CD727D482D19AB166E9D")
    private int writeString(String string) throws IOException {
        Integer identifier = stringToId.get(string);
        int id = nextStringId++;
        stringToId.put(string, id);
        byte[] bytes = string.getBytes("UTF-8");
        writeRecordHeader(BinaryHprof.Tag.STRING_IN_UTF8,
                          0,
                          BinaryHprof.ID_SIZE + bytes.length);
        out.writeInt(id);
        out.write(bytes, 0, bytes.length);
        addTaint(string.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1788913393 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1788913393;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.895 -0400", hash_original_method = "759EEA3A3B19BFF3937058AF4EFC13EB", hash_generated_method = "34BEBC8D96FDFEB1CDA394C1D074028A")
    private void writeCpuSamples(int totalSamples, Set<HprofData.Sample> samples) throws IOException {
        int samplesCount = samples.size();
        writeRecordHeader(BinaryHprof.Tag.CPU_SAMPLES, 0, 4 + 4 + (samplesCount * (4 + 4)));
        out.writeInt(totalSamples);
        out.writeInt(samplesCount);
        {
            Iterator<HprofData.Sample> varA18F9CCB2314E9522801AE336380C59F_1207142012 = (samples).iterator();
            varA18F9CCB2314E9522801AE336380C59F_1207142012.hasNext();
            HprofData.Sample sample = varA18F9CCB2314E9522801AE336380C59F_1207142012.next();
            {
                out.writeInt(sample.count);
                out.writeInt(sample.stackTrace.stackTraceId);
            } //End block
        } //End collapsed parenthetic
        addTaint(totalSamples);
        addTaint(samples.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.897 -0400", hash_original_method = "AA7BB7F509E670C633C84E0D44DE5DDB", hash_generated_method = "57FC0A8387204205F5E87EFE734DD608")
    private void writeStackTrace(HprofData.StackTrace stackTrace) throws IOException {
        int frames = stackTrace.stackFrames.length;
        int[] stackFrameIds = new int[frames];
        {
            int i = 0;
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
        addTaint(stackTrace.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.898 -0400", hash_original_method = "564218335BC7BDEEE42DF1829D6316AF", hash_generated_method = "F63C920E3A0137209C93FFDF742F651E")
    private int writeLoadClass(String className) throws IOException {
        Integer identifier = classNameToId.get(className);
        int id = nextClassId++;
        classNameToId.put(className, id);
        int classNameId = writeString(className);
        writeRecordHeader(BinaryHprof.Tag.LOAD_CLASS,
                          0,
                          BinaryHprof.Tag.LOAD_CLASS.maximumSize);
        out.writeInt(id);
        writeId(0);
        out.writeInt(0);
        writeId(classNameId);
        addTaint(className.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_966442333 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_966442333;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.899 -0400", hash_original_method = "0C83F2A39C21D86EF68CFCB925D16EF6", hash_generated_method = "796A3BB994F60D41E475438057D00C6C")
    private int writeStackFrame(StackTraceElement stackFrame) throws IOException {
        Integer identifier = stackFrameToId.get(stackFrame);
        int id = nextStackFrameId++;
        stackFrameToId.put(stackFrame, id);
        int classId = writeLoadClass(stackFrame.getClassName());
        int methodNameId = writeString(stackFrame.getMethodName());
        int sourceId = writeString(stackFrame.getFileName());
        writeRecordHeader(BinaryHprof.Tag.STACK_FRAME,
                          0,
                          BinaryHprof.Tag.STACK_FRAME.maximumSize);
        writeId(id);
        writeId(methodNameId);
        writeId(0);
        writeId(sourceId);
        out.writeInt(classId);
        out.writeInt(stackFrame.getLineNumber());
        addTaint(stackFrame.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_921628704 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_921628704;
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

