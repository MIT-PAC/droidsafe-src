package dalvik.system.profiler;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;






public final class BinaryHprofWriter {

    /**
     * Writes the provided data to the specified stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.123 -0500", hash_original_method = "C319F61C77453FA6E7A0623E5D902038", hash_generated_method = "17F9EECE1A2A53AF05E8AE65670A5B6E")
    
public static void write(HprofData data, OutputStream outputStream) throws IOException {
        new BinaryHprofWriter(data, outputStream).write();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.103 -0500", hash_original_field = "2602E3561EFB87B6516825F22CA93B39", hash_generated_field = "F6789153277D04B710C8FC8F6CD54F9E")


    private int nextStringId = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.106 -0500", hash_original_field = "8C680016BB6F7BA0025F3F52CED9F58E", hash_generated_field = "7A760F4F16EAFCB07FE0A0FC4C3F75E3")

    private int nextClassId = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.109 -0500", hash_original_field = "30CED8567CE56DE7FD37C0BAB134168D", hash_generated_field = "E479771D08904C609A002C4DAE48E586")

    private int nextStackFrameId = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.111 -0500", hash_original_field = "01C718425558EEEE04C743D2942164DE", hash_generated_field = "F11F893B57923B552068E07C0B6278CE")

    private final Map<String, Integer> stringToId = new HashMap<String, Integer>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.113 -0500", hash_original_field = "779C49616541098813BF2DD04F7964E0", hash_generated_field = "449F2DFD040184E791A3059DABA5B89A")

    private final Map<String, Integer> classNameToId = new HashMap<String, Integer>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.115 -0500", hash_original_field = "67D59E735E8BD7FDE6089758F243D98D", hash_generated_field = "D35B504B290ED4F518BA1C114674FBAA")

    private final Map<StackTraceElement, Integer> stackFrameToId
            = new HashMap<StackTraceElement, Integer>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.117 -0500", hash_original_field = "C626D5D102B670EE54046C0143D70C68", hash_generated_field = "BD98D42EB76BD47A6FDE7B8FA850AB03")


    private  HprofData data;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.121 -0500", hash_original_field = "9E610CBF013921060FC7250E69532609", hash_generated_field = "58B7027288BADB051D787F0275726007")

    private  DataOutputStream out;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.126 -0500", hash_original_method = "732DAB84FABC53991CAEE3EC9AA68C95", hash_generated_method = "4459778BDBFFDB2D7937D2144DC7C4E5")
    
private BinaryHprofWriter(HprofData data, OutputStream outputStream) {
        this.data = data;
        this.out = new DataOutputStream(outputStream);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.129 -0500", hash_original_method = "6C7AC0DF0B31CD08E559C12305128F3F", hash_generated_method = "4217DD3DC3088714F2B7C6B7CD7B70A7")
    
private void write() throws IOException {
        try {
            writeHeader(data.getStartMillis());

            writeControlSettings(data.getFlags(), data.getDepth());

            for (HprofData.ThreadEvent event : data.getThreadHistory()) {
                writeThreadEvent(event);
            }

            Set<HprofData.Sample> samples = data.getSamples();
            int total = 0;
            for (HprofData.Sample sample : samples) {
                total += sample.count;
                writeStackTrace(sample.stackTrace);
            }
            writeCpuSamples(total, samples);

        } finally {
            out.flush();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.131 -0500", hash_original_method = "C85B61C59E3F834AB2B5E220076F97DE", hash_generated_method = "98FD7EF2F92B051FA11E64DC51DA8F20")
    
private void writeHeader(long dumpTimeInMilliseconds) throws IOException {
        out.writeBytes(BinaryHprof.MAGIC + "1.0.2");
        out.writeByte(0); // null terminated string
        out.writeInt(BinaryHprof.ID_SIZE);
        out.writeLong(dumpTimeInMilliseconds);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.134 -0500", hash_original_method = "FDE35A19003ED22B657F91A2F0E06CCE", hash_generated_method = "DB83CBF92C19DE82B6D43207AE02870B")
    
private void writeControlSettings(int flags, int depth) throws IOException {
        if (depth > Short.MAX_VALUE) {
            throw new IllegalArgumentException("depth too large for binary hprof: "
                                               + depth + " > " + Short.MAX_VALUE);
        }
        writeRecordHeader(BinaryHprof.Tag.CONTROL_SETTINGS,
                          0,
                          BinaryHprof.Tag.CONTROL_SETTINGS.maximumSize);
        out.writeInt(flags);
        out.writeShort((short) depth);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.137 -0500", hash_original_method = "1F5D47BDA1DF5C3350AF092C7A31D89B", hash_generated_method = "6896F570EFEA53C3958BBBD318C324A5")
    
private void writeThreadEvent(HprofData.ThreadEvent e) throws IOException {
        switch (e.type) {
            case START:
                writeStartThread(e);
                return;
            case END:
                writeStopThread(e);
                return;
        }
        throw new IllegalStateException(e.type.toString());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.139 -0500", hash_original_method = "8E01CAF6795D5E83C54B68F6912FFEBF", hash_generated_method = "070FBAD66CE077BB9F93F2DB281ECF9F")
    
private void writeStartThread(HprofData.ThreadEvent e) throws IOException {
        int threadNameId = writeString(e.threadName);
        int groupNameId = writeString(e.groupName);
        int parentGroupNameId = writeString(e.parentGroupName);
        writeRecordHeader(BinaryHprof.Tag.START_THREAD,
                          0,
                          BinaryHprof.Tag.START_THREAD.maximumSize);
        out.writeInt(e.threadId);
        writeId(e.objectId);
        out.writeInt(0); // stack trace where thread was started unavailable
        writeId(threadNameId);
        writeId(groupNameId);
        writeId(parentGroupNameId);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.142 -0500", hash_original_method = "22EC0A4C26BDEF90544F91DCC7CD0649", hash_generated_method = "FFA131DEB394031CB7EB36081EC59D74")
    
private void writeStopThread(HprofData.ThreadEvent e) throws IOException {
        writeRecordHeader(BinaryHprof.Tag.END_THREAD,
                          0,
                          BinaryHprof.Tag.END_THREAD.maximumSize);
        out.writeInt(e.threadId);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.144 -0500", hash_original_method = "676873B3FD0126014DC640E27218ACDD", hash_generated_method = "0DE181AE6356ECF357CAEA762B6C28C3")
    
private void writeRecordHeader(BinaryHprof.Tag hprofTag,
                                   int timeDeltaInMicroseconds,
                                   int recordLength) throws IOException {
        String error = hprofTag.checkSize(recordLength);
        if (error != null) {
            throw new AssertionError(error);
        }
        out.writeByte(hprofTag.tag);
        out.writeInt(timeDeltaInMicroseconds);
        out.writeInt(recordLength);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.147 -0500", hash_original_method = "444AE2A435FAF86B0F2CBA448766AD4E", hash_generated_method = "76D1F877A474B695EC4FF0EA7D55BAF0")
    
private void writeId(int id) throws IOException {
        out.writeInt(id);
    }

    /**
     * Ensures that a string has been writen to the out and
     * returns its ID. The ID of a null string is zero, and
     * doesn't actually result in any output. In a string has
     * already been written previously, the earlier ID will be
     * returned and no output will be written.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.149 -0500", hash_original_method = "F126C5267DAD0F96A8C03752944B8779", hash_generated_method = "ABE2905D17D5E349C98C5348C046E2AE")
    
private int writeString(String string) throws IOException {
        if (string == null) {
            return 0;
        }
        Integer identifier = stringToId.get(string);
        if (identifier != null) {
            return identifier;
        }

        int id = nextStringId++;
        stringToId.put(string, id);

        byte[] bytes = string.getBytes("UTF-8");
        writeRecordHeader(BinaryHprof.Tag.STRING_IN_UTF8,
                          0,
                          BinaryHprof.ID_SIZE + bytes.length);
        out.writeInt(id);
        out.write(bytes, 0, bytes.length);

        return id;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.152 -0500", hash_original_method = "759EEA3A3B19BFF3937058AF4EFC13EB", hash_generated_method = "92898533871983B7E00230F2EF22495E")
    
private void writeCpuSamples(int totalSamples, Set<HprofData.Sample> samples)
            throws IOException {
        int samplesCount = samples.size();
        if (samplesCount == 0) {
            return;
        }
        writeRecordHeader(BinaryHprof.Tag.CPU_SAMPLES, 0, 4 + 4 + (samplesCount * (4 + 4)));
        out.writeInt(totalSamples);
        out.writeInt(samplesCount);
        for (HprofData.Sample sample : samples) {
            out.writeInt(sample.count);
            out.writeInt(sample.stackTrace.stackTraceId);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.155 -0500", hash_original_method = "AA7BB7F509E670C633C84E0D44DE5DDB", hash_generated_method = "54A33998FF1786C8255913660788BA57")
    
private void writeStackTrace(HprofData.StackTrace stackTrace) throws IOException {
        int frames = stackTrace.stackFrames.length;
        int[] stackFrameIds = new int[frames];
        for (int i = 0; i < frames; i++) {
            stackFrameIds[i] = writeStackFrame(stackTrace.stackFrames[i]);
        }
        writeRecordHeader(BinaryHprof.Tag.STACK_TRACE,
                          0,
                          4 + 4 + 4 + (frames * BinaryHprof.ID_SIZE));
        out.writeInt(stackTrace.stackTraceId);
        out.writeInt(stackTrace.threadId);
        out.writeInt(frames);
        for (int stackFrameId : stackFrameIds) {
            writeId(stackFrameId);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.157 -0500", hash_original_method = "564218335BC7BDEEE42DF1829D6316AF", hash_generated_method = "8DE1D2E0112FB7AB0083057B8A1CEED0")
    
private int writeLoadClass(String className) throws IOException {
        Integer identifier = classNameToId.get(className);
        if (identifier != null) {
            return identifier;
        }
        int id = nextClassId++;
        classNameToId.put(className, id);

        int classNameId = writeString(className);
        writeRecordHeader(BinaryHprof.Tag.LOAD_CLASS,
                          0,
                          BinaryHprof.Tag.LOAD_CLASS.maximumSize);
        out.writeInt(id);
        writeId(0); // class object ID
        out.writeInt(0); // stack trace where class was loaded is unavailable
        writeId(classNameId);

        return id;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:41.159 -0500", hash_original_method = "0C83F2A39C21D86EF68CFCB925D16EF6", hash_generated_method = "AA55752FD81E2115236DDBDDB779DE14")
    
private int writeStackFrame(StackTraceElement stackFrame) throws IOException {
        Integer identifier = stackFrameToId.get(stackFrame);
        if (identifier != null) {
            return identifier;
        }

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
        writeId(0); // method signature is unavailable from StackTraceElement
        writeId(sourceId);
        out.writeInt(classId);
        out.writeInt(stackFrame.getLineNumber());

        return id;
    }

    
}

