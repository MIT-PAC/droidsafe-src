package java.util.zip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import dalvik.system.CloseGuard;
import java.util.Arrays;
import libcore.util.EmptyArray;

public class Deflater {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.493 -0400", hash_original_field = "7E745DE7D3A52F3AD2B672676574182F", hash_generated_field = "FE9D47B0BB2944D7D04C48564510EA37")

    private int flushParm = NO_FLUSH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.493 -0400", hash_original_field = "A5D7CEB2C59B8CEE46C2953FEC9ABC19", hash_generated_field = "3E2B0E3E2E572DECE0B20D77E19B79CF")

    private boolean finished;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.493 -0400", hash_original_field = "F6FB501133FB7F003C31FA527165FE2A", hash_generated_field = "27139595293C7DFAFE0E0E3302C66E6F")

    private int compressLevel = DEFAULT_COMPRESSION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.493 -0400", hash_original_field = "0E99398BDADBA8620ADD18F39EB56C38", hash_generated_field = "BB7C60E9AAF3128E30F80132DBC518E3")

    private int strategy = DEFAULT_STRATEGY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.493 -0400", hash_original_field = "8FDC9AB7980AD9BE440CE02ACB10A779", hash_generated_field = "96E9A434433050A3F1202A32F9BF2C55")

    private long streamHandle = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.493 -0400", hash_original_field = "25DFA9D3CDA92CA96C2E6EEEBDCB3CD5", hash_generated_field = "97F892FF664C2B7167B136A4B04D7E33")

    private byte[] inputBuffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.493 -0400", hash_original_field = "B6FF059B29EA3AB5FB0489449FEC7684", hash_generated_field = "04384C2608AA53E3C7DB2B14F64353DB")

    private int inRead;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.493 -0400", hash_original_field = "61CD1212E4A9CF832E845DAAE8793B2B", hash_generated_field = "0E7AF8D739309A330EB7DABC780C6592")

    private int inLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.493 -0400", hash_original_field = "73ABE739BEC4C3DB38D39FA43D36469F", hash_generated_field = "2D38C9B39338C5B15F94E3339CE63B3F")

    private CloseGuard guard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.507 -0400", hash_original_method = "6DBC61BE4FC097F2420F36A015A6138C", hash_generated_method = "9C40E2104F522B79F67B639B9E119058")
    public  Deflater() {
        this(DEFAULT_COMPRESSION, false);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.507 -0400", hash_original_method = "EE2B377CE8D615D75129B5A0881EF06D", hash_generated_method = "2E0BA1C539FDDA7B77880E2D876F384D")
    public  Deflater(int level) {
        this(level, false);
        addTaint(level);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.508 -0400", hash_original_method = "2C334DD40EC2ED2E518DCA464DFDC51E", hash_generated_method = "A6FB0C8E2B11FFDF05F967B3E09ACE9A")
    public  Deflater(int level, boolean noHeader) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        compressLevel = level;
        streamHandle = createStream(compressLevel, strategy, noHeader);
        guard.open("end");
        // ---------- Original Method ----------
        //if (level < DEFAULT_COMPRESSION || level > BEST_COMPRESSION) {
            //throw new IllegalArgumentException();
        //}
        //compressLevel = level;
        //streamHandle = createStream(compressLevel, strategy, noHeader);
        //guard.open("end");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.509 -0400", hash_original_method = "611AF07E266F550F53CDF01F1CC352A1", hash_generated_method = "6B469B3D7FA389C6F80543253809F1B3")
    public int deflate(byte[] buf) {
        int var893D70D789FDACB292CF86FBFBD44137_205657435 = (deflate(buf, 0, buf.length));
        addTaint(buf[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_494841251 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_494841251;
        // ---------- Original Method ----------
        //return deflate(buf, 0, buf.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.509 -0400", hash_original_method = "0A84F3CD8D711F8E28F74CE9A11C545E", hash_generated_method = "E4C072ED679448048ED9118DF0337942")
    public synchronized int deflate(byte[] buf, int offset, int byteCount) {
        int var80F4309DE603341EFB6F6849C7300032_407116941 = (deflateImpl(buf, offset, byteCount, flushParm));
        addTaint(buf[0]);
        addTaint(offset);
        addTaint(byteCount);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1282419834 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1282419834;
        // ---------- Original Method ----------
        //return deflateImpl(buf, offset, byteCount, flushParm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.510 -0400", hash_original_method = "0DC5FF46D79769AAEF0B4E5EA32BA58D", hash_generated_method = "C6D28A58A63751E3671410D2FB6ED163")
    public synchronized int deflate(byte[] buf, int offset, int byteCount, int flush) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad flush value: " + flush);
        } //End block
        int varA9D81B6768F6208DCAEAF06A930A0D7A_1573742666 = (deflateImpl(buf, offset, byteCount, flush));
        addTaint(buf[0]);
        addTaint(offset);
        addTaint(byteCount);
        addTaint(flush);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1984303319 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1984303319;
        // ---------- Original Method ----------
        //if (flush != NO_FLUSH && flush != SYNC_FLUSH && flush != FULL_FLUSH) {
            //throw new IllegalArgumentException("Bad flush value: " + flush);
        //}
        //return deflateImpl(buf, offset, byteCount, flush);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.516 -0400", hash_original_method = "CF6CE2BCD1B535E0E9CC69A73F69BC28", hash_generated_method = "A3A6304A489763B29CD57C89341D6A6A")
    private synchronized int deflateImpl(byte[] buf, int offset, int byteCount, int flush) {
        checkOpen();
        Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        {
            setInput(EmptyArray.BYTE);
        } //End block
        int varF117D10B15EF7E16529E8E5A17ABF988_187893688 = (deflateImpl(buf, offset, byteCount, streamHandle, flush));
        addTaint(buf[0]);
        addTaint(offset);
        addTaint(byteCount);
        addTaint(flush);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_959208926 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_959208926;
        // ---------- Original Method ----------
        //checkOpen();
        //Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        //if (inputBuffer == null) {
            //setInput(EmptyArray.BYTE);
        //}
        //return deflateImpl(buf, offset, byteCount, streamHandle, flush);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.516 -0400", hash_original_method = "54CA80994C94CBB2D32C9857F1640D60", hash_generated_method = "FF1F1DB4FDBABA37BB1E6096F38933E7")
    private int deflateImpl(byte[] buf, int offset, int byteCount, long handle, int flushParm) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_46276153 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_46276153;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.517 -0400", hash_original_method = "59D998A9FACC96CAD9DEE3EEFD22688A", hash_generated_method = "B152F8064A4030CE4BA6346CB469F4A5")
    public synchronized void end() {
        guard.close();
        endImpl();
        // ---------- Original Method ----------
        //guard.close();
        //endImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.539 -0400", hash_original_method = "4DA7D037A1FCD4109F30526C6DE57D1C", hash_generated_method = "9E4BD957FB186A2C3EA067CA99A72F76")
    private void endImpl() {
        {
            endImpl(streamHandle);
            inputBuffer = null;
            streamHandle = -1;
        } //End block
        // ---------- Original Method ----------
        //if (streamHandle != -1) {
            //endImpl(streamHandle);
            //inputBuffer = null;
            //streamHandle = -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.539 -0400", hash_original_method = "3E089BB1F2369FD5C4FB6F32377D1DAC", hash_generated_method = "69FF97505E0CE664E4B075F4BA3AB10B")
    private void endImpl(long handle) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.540 -0400", hash_original_method = "FC32DF56978CE95FA2CC2CA96409152E", hash_generated_method = "35E298592E9F780BD76C099CA75D8A15")
    @Override
    protected void finalize() {
        try 
        {
            {
                guard.warnIfOpen();
            } //End block
            {
                end();
                endImpl();
            } //End block
        } //End block
        finally 
        {
            try 
            {
                super.finalize();
            } //End block
            catch (Throwable t)
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError(t);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //try {
            //if (guard != null) {
                //guard.warnIfOpen();
            //}
            //synchronized (this) {
                //end(); 
                //endImpl(); 
            //}
        //} finally {
            //try {
                //super.finalize();
            //} catch (Throwable t) {
                //throw new AssertionError(t);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.540 -0400", hash_original_method = "CE8BB8EC5EB7D8A83BE6D0D952D2FABD", hash_generated_method = "DE0495773E68A9D77614A209FED334FD")
    public synchronized void finish() {
        flushParm = FINISH;
        // ---------- Original Method ----------
        //flushParm = FINISH;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.540 -0400", hash_original_method = "AE445D0E75B15DAD06E7B3F2F4342E00", hash_generated_method = "94739EB8094DDD36965E0195981102B0")
    public synchronized boolean finished() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_36310827 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_36310827;
        // ---------- Original Method ----------
        //return finished;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.541 -0400", hash_original_method = "DDE5644D46702B730F5378ABED0CC02C", hash_generated_method = "1DD8DF88279464CA0B8D7DC8B5D309CE")
    public synchronized int getAdler() {
        checkOpen();
        int var7C17F99AF382ECAC44C03A9EA8865A67_1893985111 = (getAdlerImpl(streamHandle));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2097601407 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2097601407;
        // ---------- Original Method ----------
        //checkOpen();
        //return getAdlerImpl(streamHandle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.541 -0400", hash_original_method = "B92F3D2B64C580905B1CBAEAEEC7E950", hash_generated_method = "94B35C350E286E46C49C700ADAED2E32")
    private int getAdlerImpl(long handle) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_684299617 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_684299617;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.543 -0400", hash_original_method = "26E16A0AF7B91ACC2C2C1D26CF0A41A1", hash_generated_method = "E888CFC07AFC1CFA7CB31A11A9742CEA")
    public synchronized int getTotalIn() {
        checkOpen();
        int var071A51235A297A3E32C97CEC93F0F7A3_1793586045 = ((int) getTotalInImpl(streamHandle));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_235322049 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_235322049;
        // ---------- Original Method ----------
        //checkOpen();
        //return (int) getTotalInImpl(streamHandle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.544 -0400", hash_original_method = "BB22F222483240F64BF20392C09B432F", hash_generated_method = "4FBE3A4A3B0644A687309243F182BBF7")
    private long getTotalInImpl(long handle) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1444952611 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1444952611;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.545 -0400", hash_original_method = "20FDDC2AB6FE185B9CAB89D86709EB03", hash_generated_method = "1E36A03E79B26B8DD1E17509F9CF33B1")
    public synchronized int getTotalOut() {
        checkOpen();
        int var48AD0E5A1DEFA4126AF03485C5098F68_838734874 = ((int) getTotalOutImpl(streamHandle));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1511347132 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1511347132;
        // ---------- Original Method ----------
        //checkOpen();
        //return (int) getTotalOutImpl(streamHandle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.545 -0400", hash_original_method = "2C5C1800FBCC7A9569101FDF1B411571", hash_generated_method = "677E9384802CB2596BFEC5393C58134B")
    private long getTotalOutImpl(long handle) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2129462500 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2129462500;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.545 -0400", hash_original_method = "F6DEF148508A4D024151CB5B8FE739D4", hash_generated_method = "31AC150ACC514170258F6711ADBD1934")
    public synchronized boolean needsInput() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_467954265 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_467954265;
        // ---------- Original Method ----------
        //if (inputBuffer == null) {
            //return true;
        //}
        //return inRead == inLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.555 -0400", hash_original_method = "F900704F0994CBD6978E5E4205C2BFAA", hash_generated_method = "8F653F79FAF5A2A59E779C8C5328349D")
    public synchronized void reset() {
        checkOpen();
        flushParm = NO_FLUSH;
        finished = false;
        resetImpl(streamHandle);
        inputBuffer = null;
        // ---------- Original Method ----------
        //checkOpen();
        //flushParm = NO_FLUSH;
        //finished = false;
        //resetImpl(streamHandle);
        //inputBuffer = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.555 -0400", hash_original_method = "D92307F0039AB335BB1BCA1E70FBBC75", hash_generated_method = "828BDA31BE8E9DA88C9805DDF29C0415")
    private void resetImpl(long handle) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.555 -0400", hash_original_method = "49DAD22714BA16C1AC9D80CF714D4798", hash_generated_method = "77A71E04675454663FCC8638244F8FE1")
    public void setDictionary(byte[] dictionary) {
        setDictionary(dictionary, 0, dictionary.length);
        addTaint(dictionary[0]);
        // ---------- Original Method ----------
        //setDictionary(dictionary, 0, dictionary.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.555 -0400", hash_original_method = "7FB505FB7F1826F86B368368EBDBCA40", hash_generated_method = "EDEB09DBC78839CB69701E3F314750D8")
    public synchronized void setDictionary(byte[] buf, int offset, int byteCount) {
        checkOpen();
        Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        setDictionaryImpl(buf, offset, byteCount, streamHandle);
        addTaint(buf[0]);
        addTaint(offset);
        addTaint(byteCount);
        // ---------- Original Method ----------
        //checkOpen();
        //Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        //setDictionaryImpl(buf, offset, byteCount, streamHandle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.556 -0400", hash_original_method = "7E435812B66ABED0B356693E1B3AC0D7", hash_generated_method = "27D3805C15D2F67C20A0B01214394D68")
    private void setDictionaryImpl(byte[] buf, int offset, int byteCount, long handle) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.556 -0400", hash_original_method = "76E6701B8618856CEE42A14EB071C689", hash_generated_method = "4678032721C869E79830B90CA780BBA5")
    public void setInput(byte[] buf) {
        setInput(buf, 0, buf.length);
        addTaint(buf[0]);
        // ---------- Original Method ----------
        //setInput(buf, 0, buf.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.557 -0400", hash_original_method = "5EAC232252C5BA68B98F924DC24DA75C", hash_generated_method = "F8690C2EC069AAF531F661B526F5625C")
    public synchronized void setInput(byte[] buf, int offset, int byteCount) {
        checkOpen();
        Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        inLength = byteCount;
        inRead = 0;
        {
            setLevelsImpl(compressLevel, strategy, streamHandle);
        } //End block
        inputBuffer = buf;
        setInputImpl(buf, offset, byteCount, streamHandle);
        addTaint(offset);
        // ---------- Original Method ----------
        //checkOpen();
        //Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        //inLength = byteCount;
        //inRead = 0;
        //if (inputBuffer == null) {
            //setLevelsImpl(compressLevel, strategy, streamHandle);
        //}
        //inputBuffer = buf;
        //setInputImpl(buf, offset, byteCount, streamHandle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.557 -0400", hash_original_method = "6366C8E331223E53339096A4FF906729", hash_generated_method = "AF1DD229C3811CE1BC4818D190947479")
    private void setLevelsImpl(int level, int strategy, long handle) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.558 -0400", hash_original_method = "CFB5087A7D9EFE706B98C4EB08838FDC", hash_generated_method = "A07D70B78BE6B11783FE90F8CB71C6AF")
    private void setInputImpl(byte[] buf, int offset, int byteCount, long handle) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.570 -0400", hash_original_method = "56416D14F8B23CE0A4E07C0AD61CD8D1", hash_generated_method = "2B5A6FEA35F1CCCF4D4D4F2EDE9E19FB")
    public synchronized void setLevel(int level) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad level: " + level);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("setLevel cannot be called after setInput");
        } //End block
        compressLevel = level;
        // ---------- Original Method ----------
        //if (level < DEFAULT_COMPRESSION || level > BEST_COMPRESSION) {
            //throw new IllegalArgumentException("Bad level: " + level);
        //}
        //if (inputBuffer != null) {
            //throw new IllegalStateException("setLevel cannot be called after setInput");
        //}
        //compressLevel = level;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.571 -0400", hash_original_method = "9A84D355252A826695237C59231B1742", hash_generated_method = "99D6F666D5E67DA7A28DADE5E7B3D3D6")
    public synchronized void setStrategy(int strategy) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad strategy: " + strategy);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("setStrategy cannot be called after setInput");
        } //End block
        this.strategy = strategy;
        // ---------- Original Method ----------
        //if (strategy < DEFAULT_STRATEGY || strategy > HUFFMAN_ONLY) {
            //throw new IllegalArgumentException("Bad strategy: " + strategy);
        //}
        //if (inputBuffer != null) {
            //throw new IllegalStateException("setStrategy cannot be called after setInput");
        //}
        //this.strategy = strategy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.571 -0400", hash_original_method = "B419E0AF253F709FCCBF4031C175C3E0", hash_generated_method = "98A7F49C65B61C33AB9D2BE1BEB0035C")
    public synchronized long getBytesRead() {
        checkOpen();
        long var6C0E09A019AABCCDC70FCCC5BD7FF31D_160053806 = (getTotalInImpl(streamHandle));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_631427905 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_631427905;
        // ---------- Original Method ----------
        //checkOpen();
        //return getTotalInImpl(streamHandle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.572 -0400", hash_original_method = "B14826F1D1678AA7FAF007D6D8541F5C", hash_generated_method = "A2D4EA5CEDFCEB034845DE170B6992A4")
    public synchronized long getBytesWritten() {
        checkOpen();
        long var4BCD5BD6475949FEF14EA9C64C6BCE8A_1166512884 = (getTotalOutImpl(streamHandle));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_318359300 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_318359300;
        // ---------- Original Method ----------
        //checkOpen();
        //return getTotalOutImpl(streamHandle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.572 -0400", hash_original_method = "C56CB62EAF4356747257EC4F43A6E2A6", hash_generated_method = "318B0C624EE73D9E3CC3F3D91B53DC64")
    private long createStream(int level, int strategy1, boolean noHeader1) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1919884011 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1919884011;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.576 -0400", hash_original_method = "367A42A5784C609E2D8E37BE922AB4A4", hash_generated_method = "C8C55B8B52143CB776406B58F0800BC8")
    private void checkOpen() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("attempt to use Deflater after calling end");
        } //End block
        // ---------- Original Method ----------
        //if (streamHandle == -1) {
            //throw new IllegalStateException("attempt to use Deflater after calling end");
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.587 -0400", hash_original_field = "DFD33B6DC0EAFDE3106DA69F92951B0E", hash_generated_field = "13698D975E7B2387C4A72B340600110B")

    public static final int BEST_COMPRESSION = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.588 -0400", hash_original_field = "485ED5EC9902D9CCF9B0BED1AC4C60F7", hash_generated_field = "890A9513D044EA8A70C3430C0F3910C0")

    public static final int BEST_SPEED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.588 -0400", hash_original_field = "68084C7B8CEB476AD9400A318B9289F8", hash_generated_field = "E7BE2C778DA6187E3452B1A718873C24")

    public static final int DEFAULT_COMPRESSION = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.588 -0400", hash_original_field = "DC267C89A79E63427169027C01602490", hash_generated_field = "19AAC35E658ABBCEB552A5E24211DA20")

    public static final int DEFAULT_STRATEGY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.588 -0400", hash_original_field = "869069D8A539375615C84E9AABE70433", hash_generated_field = "F94D24D83064DA464F1E7F5CBAFCBAC0")

    public static final int DEFLATED = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.588 -0400", hash_original_field = "9AEB1CBA759FFEC8E3029046459ACFBA", hash_generated_field = "2321B2F07267BE7486401DE443318EEF")

    public static final int FILTERED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.588 -0400", hash_original_field = "587FD8F588F29F99FE1AA7FE176137CD", hash_generated_field = "4686D220D976568E44E871FF5A4F153B")

    public static final int HUFFMAN_ONLY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.588 -0400", hash_original_field = "6369E00445C8DA2CFF94672929AF2707", hash_generated_field = "7E480562BE1ECBC592DFD29907509C69")

    public static final int NO_COMPRESSION = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.588 -0400", hash_original_field = "97E4576ACCE5DEA2E02C7121612FE89C", hash_generated_field = "64337D4FC74C09056924942AC04865E4")

    public static final int NO_FLUSH = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.588 -0400", hash_original_field = "C362DFE347A4CD740BB5E73ED98D07FA", hash_generated_field = "7943C4EAA611D10AC2C91440A4B6FD09")

    public static final int SYNC_FLUSH = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.588 -0400", hash_original_field = "27A0AF59BC20A67B97D53567F9B4D04F", hash_generated_field = "7C02FA0E9AA9D37F4E5455FE8EF0CA0F")

    public static final int FULL_FLUSH = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.588 -0400", hash_original_field = "241C8085F9268A3474DFE8D78B638619", hash_generated_field = "121147EAE565F2CE6E5A3AFF58EC3BD3")

    private static int FINISH = 4;
}

