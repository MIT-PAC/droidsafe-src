package dalvik.system.profiler;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class BinaryHprofWriter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.882 -0400", hash_original_field = "7E68DA75B9A11053C85FBA5DDEFD4449", hash_generated_field = "F6789153277D04B710C8FC8F6CD54F9E")

    private int nextStringId = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.882 -0400", hash_original_field = "C84BDAB09B513196433B1BAEBF02636F", hash_generated_field = "7A760F4F16EAFCB07FE0A0FC4C3F75E3")

    private int nextClassId = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.883 -0400", hash_original_field = "E8225D3D919F19BF647928E1C35BAC9C", hash_generated_field = "E479771D08904C609A002C4DAE48E586")

    private int nextStackFrameId = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.883 -0400", hash_original_field = "C6F94A0430429BC5B5CBDD661134864F", hash_generated_field = "F11F893B57923B552068E07C0B6278CE")

    private final Map<String, Integer> stringToId = new HashMap<String, Integer>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.883 -0400", hash_original_field = "5AF1F4E411FFF4CB8F713A02E8256963", hash_generated_field = "449F2DFD040184E791A3059DABA5B89A")

    private final Map<String, Integer> classNameToId = new HashMap<String, Integer>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.883 -0400", hash_original_field = "48E7FAE6A0D04CC3B01B707722B6D2C1", hash_generated_field = "D35B504B290ED4F518BA1C114674FBAA")

    private final Map<StackTraceElement, Integer> stackFrameToId = new HashMap<StackTraceElement, Integer>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.883 -0400", hash_original_field = "8D777F385D3DFEC8815D20F7496026DC", hash_generated_field = "BD98D42EB76BD47A6FDE7B8FA850AB03")

    private HprofData data;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.883 -0400", hash_original_field = "C68271A63DDBC431C307BEB7D2918275", hash_generated_field = "58B7027288BADB051D787F0275726007")

    private DataOutputStream out;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.883 -0400", hash_original_method = "732DAB84FABC53991CAEE3EC9AA68C95", hash_generated_method = "C306B4BCFF5195975397838E8E1DDCB6")
    private  BinaryHprofWriter(HprofData data, OutputStream outputStream) {
        this.data = data;
        this.out = new DataOutputStream(outputStream);
        // ---------- Original Method ----------
        //this.data = data;
        //this.out = new DataOutputStream(outputStream);
    }

    
        @DSModeled(DSC.BAN)
    public static void write(HprofData data, OutputStream outputStream) throws IOException {
        new BinaryHprofWriter(data, outputStream).write();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.884 -0400", hash_original_method = "6C7AC0DF0B31CD08E559C12305128F3F", hash_generated_method = "5F0EEB5D56F9B378DDB40BD99AF9FB7F")
    private void write() throws IOException {
        try 
        {
            writeHeader(data.getStartMillis());
            writeControlSettings(data.getFlags(), data.getDepth());
for(HprofData.ThreadEvent event : data.getThreadHistory())
            {
                writeThreadEvent(event);
            } //End block
            Set<HprofData.Sample> samples = data.getSamples();
            int total = 0;
for(HprofData.Sample sample : samples)
            {
                total += sample.count;
                writeStackTrace(sample.stackTrace);
            } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.884 -0400", hash_original_method = "C85B61C59E3F834AB2B5E220076F97DE", hash_generated_method = "9D589FAAC75783B5134C89C56F854923")
    private void writeHeader(long dumpTimeInMilliseconds) throws IOException {
        addTaint(dumpTimeInMilliseconds);
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.884 -0400", hash_original_method = "FDE35A19003ED22B657F91A2F0E06CCE", hash_generated_method = "C2140640FC5FA7E2BF00B8B924063F9A")
    private void writeControlSettings(int flags, int depth) throws IOException {
        addTaint(depth);
        addTaint(flags);
    if(depth > Short.MAX_VALUE)        
        {
            IllegalArgumentException var0530ED2CD040142E2D81F55C14ABB8FB_2093574900 = new IllegalArgumentException("depth too large for binary hprof: "
                                               + depth + " > " + Short.MAX_VALUE);
            var0530ED2CD040142E2D81F55C14ABB8FB_2093574900.addTaint(taint);
            throw var0530ED2CD040142E2D81F55C14ABB8FB_2093574900;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.884 -0400", hash_original_method = "1F5D47BDA1DF5C3350AF092C7A31D89B", hash_generated_method = "660C8F8FD72441143349D7875E12201C")
    private void writeThreadEvent(HprofData.ThreadEvent e) throws IOException {
        addTaint(e.getTaint());
switch(e.type){
        case START:
        writeStartThread(e);
        return;
        case END:
        writeStopThread(e);
        return;
}        IllegalStateException var635E1BE283FAD0CAC9F941AB6AFBEC2E_2039466213 = new IllegalStateException(e.type.toString());
        var635E1BE283FAD0CAC9F941AB6AFBEC2E_2039466213.addTaint(taint);
        throw var635E1BE283FAD0CAC9F941AB6AFBEC2E_2039466213;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.885 -0400", hash_original_method = "8E01CAF6795D5E83C54B68F6912FFEBF", hash_generated_method = "9509D57A2F132603DBDAD99682737CFC")
    private void writeStartThread(HprofData.ThreadEvent e) throws IOException {
        addTaint(e.getTaint());
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.885 -0400", hash_original_method = "22EC0A4C26BDEF90544F91DCC7CD0649", hash_generated_method = "D27E018D2CF00E3F2C1E8375B18BEB57")
    private void writeStopThread(HprofData.ThreadEvent e) throws IOException {
        addTaint(e.getTaint());
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.885 -0400", hash_original_method = "676873B3FD0126014DC640E27218ACDD", hash_generated_method = "4E714A85895D9D68AD63D70CE0501E5A")
    private void writeRecordHeader(BinaryHprof.Tag hprofTag,
                                   int timeDeltaInMicroseconds,
                                   int recordLength) throws IOException {
        addTaint(recordLength);
        addTaint(timeDeltaInMicroseconds);
        addTaint(hprofTag.getTaint());
        String error = hprofTag.checkSize(recordLength);
    if(error != null)        
        {
            AssertionError var0733A419E9F722E510B58BCEDEBD505D_1959025590 = new AssertionError(error);
            var0733A419E9F722E510B58BCEDEBD505D_1959025590.addTaint(taint);
            throw var0733A419E9F722E510B58BCEDEBD505D_1959025590;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.885 -0400", hash_original_method = "444AE2A435FAF86B0F2CBA448766AD4E", hash_generated_method = "324EB3191182BD20A9340EA39911B917")
    private void writeId(int id) throws IOException {
        addTaint(id);
        out.writeInt(id);
        // ---------- Original Method ----------
        //out.writeInt(id);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.886 -0400", hash_original_method = "F126C5267DAD0F96A8C03752944B8779", hash_generated_method = "4B0ABACFF4AFB31C8768C1B905BF8D6B")
    private int writeString(String string) throws IOException {
        addTaint(string.getTaint());
    if(string == null)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_246335000 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_41398579 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_41398579;
        } //End block
        Integer identifier = stringToId.get(string);
    if(identifier != null)        
        {
            int varF393F3F5E496869A15BC72CBFD56F541_881428077 = (identifier);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1019166148 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1019166148;
        } //End block
        int id = nextStringId++;
        stringToId.put(string, id);
        byte[] bytes = string.getBytes("UTF-8");
        writeRecordHeader(BinaryHprof.Tag.STRING_IN_UTF8,
                          0,
                          BinaryHprof.ID_SIZE + bytes.length);
        out.writeInt(id);
        out.write(bytes, 0, bytes.length);
        int varB80BB7740288FDA1F201890375A60C8F_391751920 = (id);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_809977645 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_809977645;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.886 -0400", hash_original_method = "759EEA3A3B19BFF3937058AF4EFC13EB", hash_generated_method = "A65B2C6364814B2F3D5658A0D7708771")
    private void writeCpuSamples(int totalSamples, Set<HprofData.Sample> samples) throws IOException {
        addTaint(samples.getTaint());
        addTaint(totalSamples);
        int samplesCount = samples.size();
    if(samplesCount == 0)        
        {
            return;
        } //End block
        writeRecordHeader(BinaryHprof.Tag.CPU_SAMPLES, 0, 4 + 4 + (samplesCount * (4 + 4)));
        out.writeInt(totalSamples);
        out.writeInt(samplesCount);
for(HprofData.Sample sample : samples)
        {
            out.writeInt(sample.count);
            out.writeInt(sample.stackTrace.stackTraceId);
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.887 -0400", hash_original_method = "AA7BB7F509E670C633C84E0D44DE5DDB", hash_generated_method = "CE4863C141CDADF80142D1FEB5BC9A4B")
    private void writeStackTrace(HprofData.StackTrace stackTrace) throws IOException {
        addTaint(stackTrace.getTaint());
        int frames = stackTrace.stackFrames.length;
        int[] stackFrameIds = new int[frames];
for(int i = 0;i < frames;i++)
        {
            stackFrameIds[i] = writeStackFrame(stackTrace.stackFrames[i]);
        } //End block
        writeRecordHeader(BinaryHprof.Tag.STACK_TRACE,
                          0,
                          4 + 4 + 4 + (frames * BinaryHprof.ID_SIZE));
        out.writeInt(stackTrace.stackTraceId);
        out.writeInt(stackTrace.threadId);
        out.writeInt(frames);
for(int stackFrameId : stackFrameIds)
        {
            writeId(stackFrameId);
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.888 -0400", hash_original_method = "564218335BC7BDEEE42DF1829D6316AF", hash_generated_method = "A85941E17108E082BC445D9AD6071811")
    private int writeLoadClass(String className) throws IOException {
        addTaint(className.getTaint());
        Integer identifier = classNameToId.get(className);
    if(identifier != null)        
        {
            int varF393F3F5E496869A15BC72CBFD56F541_466174888 = (identifier);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1724274693 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1724274693;
        } //End block
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
        int varB80BB7740288FDA1F201890375A60C8F_1689372447 = (id);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1480569480 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1480569480;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:32.889 -0400", hash_original_method = "0C83F2A39C21D86EF68CFCB925D16EF6", hash_generated_method = "EF6EFEBE43D874D76BEDF900A941E009")
    private int writeStackFrame(StackTraceElement stackFrame) throws IOException {
        addTaint(stackFrame.getTaint());
        Integer identifier = stackFrameToId.get(stackFrame);
    if(identifier != null)        
        {
            int varF393F3F5E496869A15BC72CBFD56F541_1168367880 = (identifier);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1040075581 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1040075581;
        } //End block
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
        int varB80BB7740288FDA1F201890375A60C8F_2139501450 = (id);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1107283221 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1107283221;
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

