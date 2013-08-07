package java.util.zip;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Arrays;

import libcore.util.EmptyArray;
import dalvik.system.CloseGuard;





public class Deflater {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.526 -0400", hash_original_field = "7E745DE7D3A52F3AD2B672676574182F", hash_generated_field = "FE9D47B0BB2944D7D04C48564510EA37")

    private int flushParm = NO_FLUSH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.526 -0400", hash_original_field = "A5D7CEB2C59B8CEE46C2953FEC9ABC19", hash_generated_field = "3E2B0E3E2E572DECE0B20D77E19B79CF")

    private boolean finished;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.526 -0400", hash_original_field = "F6FB501133FB7F003C31FA527165FE2A", hash_generated_field = "27139595293C7DFAFE0E0E3302C66E6F")

    private int compressLevel = DEFAULT_COMPRESSION;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.527 -0400", hash_original_field = "0E99398BDADBA8620ADD18F39EB56C38", hash_generated_field = "BB7C60E9AAF3128E30F80132DBC518E3")

    private int strategy = DEFAULT_STRATEGY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.527 -0400", hash_original_field = "8FDC9AB7980AD9BE440CE02ACB10A779", hash_generated_field = "96E9A434433050A3F1202A32F9BF2C55")

    private long streamHandle = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.527 -0400", hash_original_field = "25DFA9D3CDA92CA96C2E6EEEBDCB3CD5", hash_generated_field = "97F892FF664C2B7167B136A4B04D7E33")

    private byte[] inputBuffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.527 -0400", hash_original_field = "B6FF059B29EA3AB5FB0489449FEC7684", hash_generated_field = "04384C2608AA53E3C7DB2B14F64353DB")

    private int inRead;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.527 -0400", hash_original_field = "61CD1212E4A9CF832E845DAAE8793B2B", hash_generated_field = "0E7AF8D739309A330EB7DABC780C6592")

    private int inLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.527 -0400", hash_original_field = "73ABE739BEC4C3DB38D39FA43D36469F", hash_generated_field = "E7FAF2CA4E8E292A9B5FAAE3D4817EEC")

    private final CloseGuard guard = CloseGuard.get();
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.527 -0400", hash_original_method = "6DBC61BE4FC097F2420F36A015A6138C", hash_generated_method = "9C40E2104F522B79F67B639B9E119058")
    public  Deflater() {
        this(DEFAULT_COMPRESSION, false);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.528 -0400", hash_original_method = "EE2B377CE8D615D75129B5A0881EF06D", hash_generated_method = "2E0BA1C539FDDA7B77880E2D876F384D")
    public  Deflater(int level) {
        this(level, false);
        addTaint(level);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.528 -0400", hash_original_method = "2C334DD40EC2ED2E518DCA464DFDC51E", hash_generated_method = "30A5FC836DD04E926F1B59850B19C1F3")
    public  Deflater(int level, boolean noHeader) {
        if(level < DEFAULT_COMPRESSION || level > BEST_COMPRESSION)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1660819400 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1660819400.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1660819400;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.529 -0400", hash_original_method = "611AF07E266F550F53CDF01F1CC352A1", hash_generated_method = "E6360D18F848ED42AF782345B3521A15")
    public int deflate(byte[] buf) {
        addTaint(buf[0]);
        int varA8F44DDEC9B217F87113F6C0B5BF8DE5_1776936248 = (deflate(buf, 0, buf.length));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1786168221 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1786168221;
        // ---------- Original Method ----------
        //return deflate(buf, 0, buf.length);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.530 -0400", hash_original_method = "0A84F3CD8D711F8E28F74CE9A11C545E", hash_generated_method = "F48E75C2627294951C0BD303A053B7A4")
    public synchronized int deflate(byte[] buf, int offset, int byteCount) {
        addTaint(byteCount);
        addTaint(offset);
        addTaint(buf[0]);
        int varA5702F46C8E38B7BDFD7C450700F752B_1456428264 = (deflateImpl(buf, offset, byteCount, flushParm));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_819650102 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_819650102;
        // ---------- Original Method ----------
        //return deflateImpl(buf, offset, byteCount, flushParm);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.531 -0400", hash_original_method = "0DC5FF46D79769AAEF0B4E5EA32BA58D", hash_generated_method = "038B08E91880A6788944C9A612067B3F")
    public synchronized int deflate(byte[] buf, int offset, int byteCount, int flush) {
        addTaint(flush);
        addTaint(byteCount);
        addTaint(offset);
        addTaint(buf[0]);
        if(flush != NO_FLUSH && flush != SYNC_FLUSH && flush != FULL_FLUSH)        
        {
            IllegalArgumentException varCA1A5F6BE6BDD0C30D9068D7DE94DA43_953787578 = new IllegalArgumentException("Bad flush value: " + flush);
            varCA1A5F6BE6BDD0C30D9068D7DE94DA43_953787578.addTaint(taint);
            throw varCA1A5F6BE6BDD0C30D9068D7DE94DA43_953787578;
        } //End block
        int var281DA5A3D40EC030E887F16FF2C45B2C_1660988754 = (deflateImpl(buf, offset, byteCount, flush));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2108872621 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2108872621;
        // ---------- Original Method ----------
        //if (flush != NO_FLUSH && flush != SYNC_FLUSH && flush != FULL_FLUSH) {
            //throw new IllegalArgumentException("Bad flush value: " + flush);
        //}
        //return deflateImpl(buf, offset, byteCount, flush);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.531 -0400", hash_original_method = "CF6CE2BCD1B535E0E9CC69A73F69BC28", hash_generated_method = "8FC3DDB743C68B6A52E8EF3C9DB27BBA")
    private synchronized int deflateImpl(byte[] buf, int offset, int byteCount, int flush) {
        addTaint(flush);
        addTaint(byteCount);
        addTaint(offset);
        addTaint(buf[0]);
        checkOpen();
        Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        if(inputBuffer == null)        
        {
            setInput(EmptyArray.BYTE);
        } //End block
        int var45514BCF67F8B5276617017342205801_835821847 = (deflateImpl(buf, offset, byteCount, streamHandle, flush));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1259844168 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1259844168;
        // ---------- Original Method ----------
        //checkOpen();
        //Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        //if (inputBuffer == null) {
            //setInput(EmptyArray.BYTE);
        //}
        //return deflateImpl(buf, offset, byteCount, streamHandle, flush);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.532 -0400", hash_original_method = "54CA80994C94CBB2D32C9857F1640D60", hash_generated_method = "79F9D3D2765532FF697E3AF4356BD916")
    private int deflateImpl(byte[] buf, int offset, int byteCount, long handle, int flushParm) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_934640093 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_934640093;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.532 -0400", hash_original_method = "59D998A9FACC96CAD9DEE3EEFD22688A", hash_generated_method = "B152F8064A4030CE4BA6346CB469F4A5")
    public synchronized void end() {
        guard.close();
        endImpl();
        // ---------- Original Method ----------
        //guard.close();
        //endImpl();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.533 -0400", hash_original_method = "4DA7D037A1FCD4109F30526C6DE57D1C", hash_generated_method = "8911A22A5517BD371D1F518C6E8C1FBA")
    private void endImpl() {
        if(streamHandle != -1)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.533 -0400", hash_original_method = "3E089BB1F2369FD5C4FB6F32377D1DAC", hash_generated_method = "69FF97505E0CE664E4B075F4BA3AB10B")
    private void endImpl(long handle) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.533 -0400", hash_original_method = "FC32DF56978CE95FA2CC2CA96409152E", hash_generated_method = "520175E894BE45D532F2DE43BC2548B1")
    @Override
    protected void finalize() {
        try 
        {
            if(guard != null)            
            {
                guard.warnIfOpen();
            } //End block
            synchronized
(this)            {
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
                AssertionError var31F1143F51E5C3306DAC550F61AF5CBA_150842118 = new AssertionError(t);
                var31F1143F51E5C3306DAC550F61AF5CBA_150842118.addTaint(taint);
                throw var31F1143F51E5C3306DAC550F61AF5CBA_150842118;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.534 -0400", hash_original_method = "CE8BB8EC5EB7D8A83BE6D0D952D2FABD", hash_generated_method = "DE0495773E68A9D77614A209FED334FD")
    public synchronized void finish() {
        flushParm = FINISH;
        // ---------- Original Method ----------
        //flushParm = FINISH;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.534 -0400", hash_original_method = "AE445D0E75B15DAD06E7B3F2F4342E00", hash_generated_method = "09512255A4A1A46ADE0323EAE02FAEA7")
    public synchronized boolean finished() {
        boolean varA5D7CEB2C59B8CEE46C2953FEC9ABC19_1544321833 = (finished);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_673332469 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_673332469;
        // ---------- Original Method ----------
        //return finished;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.535 -0400", hash_original_method = "DDE5644D46702B730F5378ABED0CC02C", hash_generated_method = "8A0D575B82F66756AC5319E05C40AD98")
    public synchronized int getAdler() {
        checkOpen();
        int var61302C031A2885A841CE2FB4B1CD67CE_1682539467 = (getAdlerImpl(streamHandle));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1219166145 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1219166145;
        // ---------- Original Method ----------
        //checkOpen();
        //return getAdlerImpl(streamHandle);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.535 -0400", hash_original_method = "B92F3D2B64C580905B1CBAEAEEC7E950", hash_generated_method = "5F2B6D690BFD66AA4627B3B7720C3C39")
    private int getAdlerImpl(long handle) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1175186103 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1175186103;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.536 -0400", hash_original_method = "26E16A0AF7B91ACC2C2C1D26CF0A41A1", hash_generated_method = "612A0E1D79A4500A1C1779633F2617AF")
    public synchronized int getTotalIn() {
        checkOpen();
        int var41FF03F033445FC50B95D7E5B48795BC_974465852 = ((int) getTotalInImpl(streamHandle));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1827582121 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1827582121;
        // ---------- Original Method ----------
        //checkOpen();
        //return (int) getTotalInImpl(streamHandle);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.536 -0400", hash_original_method = "BB22F222483240F64BF20392C09B432F", hash_generated_method = "E70A834103F03723776D5C898AFB93A3")
    private long getTotalInImpl(long handle) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1253904415 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1253904415;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.537 -0400", hash_original_method = "20FDDC2AB6FE185B9CAB89D86709EB03", hash_generated_method = "466F8E7447F44EA758AEDD4AE663A552")
    public synchronized int getTotalOut() {
        checkOpen();
        int var9C35427B72469E54B140D55A741E94F0_1928151009 = ((int) getTotalOutImpl(streamHandle));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1190420844 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1190420844;
        // ---------- Original Method ----------
        //checkOpen();
        //return (int) getTotalOutImpl(streamHandle);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.537 -0400", hash_original_method = "2C5C1800FBCC7A9569101FDF1B411571", hash_generated_method = "A7D9820D588E87D1A8B7670DD50B7043")
    private long getTotalOutImpl(long handle) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_625310048 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_625310048;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.538 -0400", hash_original_method = "F6DEF148508A4D024151CB5B8FE739D4", hash_generated_method = "DAB49D5C99EF2E874F8B49954ECACEFD")
    public synchronized boolean needsInput() {
        if(inputBuffer == null)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1743163704 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2090861787 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2090861787;
        } //End block
        boolean var8421F335F8C4BFF221A6FB370125003A_1494107470 = (inRead == inLength);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_164541302 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_164541302;
        // ---------- Original Method ----------
        //if (inputBuffer == null) {
            //return true;
        //}
        //return inRead == inLength;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.539 -0400", hash_original_method = "F900704F0994CBD6978E5E4205C2BFAA", hash_generated_method = "8F653F79FAF5A2A59E779C8C5328349D")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.539 -0400", hash_original_method = "D92307F0039AB335BB1BCA1E70FBBC75", hash_generated_method = "828BDA31BE8E9DA88C9805DDF29C0415")
    private void resetImpl(long handle) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.540 -0400", hash_original_method = "49DAD22714BA16C1AC9D80CF714D4798", hash_generated_method = "4D724A8ECD7AE3937EE4599C59FE11A4")
    public void setDictionary(byte[] dictionary) {
        addTaint(dictionary[0]);
        setDictionary(dictionary, 0, dictionary.length);
        // ---------- Original Method ----------
        //setDictionary(dictionary, 0, dictionary.length);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.540 -0400", hash_original_method = "7FB505FB7F1826F86B368368EBDBCA40", hash_generated_method = "00E16111DA834DB862B75A1889B4C75D")
    public synchronized void setDictionary(byte[] buf, int offset, int byteCount) {
        addTaint(byteCount);
        addTaint(offset);
        addTaint(buf[0]);
        checkOpen();
        Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        setDictionaryImpl(buf, offset, byteCount, streamHandle);
        // ---------- Original Method ----------
        //checkOpen();
        //Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        //setDictionaryImpl(buf, offset, byteCount, streamHandle);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.540 -0400", hash_original_method = "7E435812B66ABED0B356693E1B3AC0D7", hash_generated_method = "27D3805C15D2F67C20A0B01214394D68")
    private void setDictionaryImpl(byte[] buf, int offset, int byteCount, long handle) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.541 -0400", hash_original_method = "76E6701B8618856CEE42A14EB071C689", hash_generated_method = "9429CE27A248D7FFA1B8BD97D04D159D")
    public void setInput(byte[] buf) {
        addTaint(buf[0]);
        setInput(buf, 0, buf.length);
        // ---------- Original Method ----------
        //setInput(buf, 0, buf.length);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.541 -0400", hash_original_method = "5EAC232252C5BA68B98F924DC24DA75C", hash_generated_method = "01AC352D63E24C97AA9CB6B98A46A8CC")
    public synchronized void setInput(byte[] buf, int offset, int byteCount) {
        addTaint(offset);
        checkOpen();
        Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        inLength = byteCount;
        inRead = 0;
        if(inputBuffer == null)        
        {
            setLevelsImpl(compressLevel, strategy, streamHandle);
        } //End block
        inputBuffer = buf;
        setInputImpl(buf, offset, byteCount, streamHandle);
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.542 -0400", hash_original_method = "6366C8E331223E53339096A4FF906729", hash_generated_method = "AF1DD229C3811CE1BC4818D190947479")
    private void setLevelsImpl(int level, int strategy, long handle) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.542 -0400", hash_original_method = "CFB5087A7D9EFE706B98C4EB08838FDC", hash_generated_method = "A07D70B78BE6B11783FE90F8CB71C6AF")
    private void setInputImpl(byte[] buf, int offset, int byteCount, long handle) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.543 -0400", hash_original_method = "56416D14F8B23CE0A4E07C0AD61CD8D1", hash_generated_method = "845812E14A35EC83840F1D9249FC3DB3")
    public synchronized void setLevel(int level) {
        if(level < DEFAULT_COMPRESSION || level > BEST_COMPRESSION)        
        {
            IllegalArgumentException var88B06204DF75B47E4B0EB8082FA374A6_1951613057 = new IllegalArgumentException("Bad level: " + level);
            var88B06204DF75B47E4B0EB8082FA374A6_1951613057.addTaint(taint);
            throw var88B06204DF75B47E4B0EB8082FA374A6_1951613057;
        } //End block
        if(inputBuffer != null)        
        {
            IllegalStateException var9F85BFFC2A78B73C26EE75C2D725A938_970265153 = new IllegalStateException("setLevel cannot be called after setInput");
            var9F85BFFC2A78B73C26EE75C2D725A938_970265153.addTaint(taint);
            throw var9F85BFFC2A78B73C26EE75C2D725A938_970265153;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.544 -0400", hash_original_method = "9A84D355252A826695237C59231B1742", hash_generated_method = "1EAFE4767286629B1B2CF9EEBA6D4916")
    public synchronized void setStrategy(int strategy) {
        if(strategy < DEFAULT_STRATEGY || strategy > HUFFMAN_ONLY)        
        {
            IllegalArgumentException var4DD0F176114E3F4B8603693A103B43BC_1110301522 = new IllegalArgumentException("Bad strategy: " + strategy);
            var4DD0F176114E3F4B8603693A103B43BC_1110301522.addTaint(taint);
            throw var4DD0F176114E3F4B8603693A103B43BC_1110301522;
        } //End block
        if(inputBuffer != null)        
        {
            IllegalStateException var6137D35C5BCBE0FD3CC3B4BE51EB9B50_818934190 = new IllegalStateException("setStrategy cannot be called after setInput");
            var6137D35C5BCBE0FD3CC3B4BE51EB9B50_818934190.addTaint(taint);
            throw var6137D35C5BCBE0FD3CC3B4BE51EB9B50_818934190;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.544 -0400", hash_original_method = "B419E0AF253F709FCCBF4031C175C3E0", hash_generated_method = "833DD4ED68E34407B31D5E42F2407C7E")
    public synchronized long getBytesRead() {
        checkOpen();
        long varFFF9322F09CACDF491BC38F3E51EFD52_917752094 = (getTotalInImpl(streamHandle));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1890146603 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1890146603;
        // ---------- Original Method ----------
        //checkOpen();
        //return getTotalInImpl(streamHandle);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.545 -0400", hash_original_method = "B14826F1D1678AA7FAF007D6D8541F5C", hash_generated_method = "59F7804ADC3A509BA39D5D806E2F3851")
    public synchronized long getBytesWritten() {
        checkOpen();
        long varF50D575295CFD2BB6AFCADFDDD55EBD6_1670442489 = (getTotalOutImpl(streamHandle));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1672888869 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1672888869;
        // ---------- Original Method ----------
        //checkOpen();
        //return getTotalOutImpl(streamHandle);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.545 -0400", hash_original_method = "C56CB62EAF4356747257EC4F43A6E2A6", hash_generated_method = "45143BC08A4BEBD53791E6DCFD2B9CBB")
    private long createStream(int level, int strategy1, boolean noHeader1) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_574573432 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_574573432;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.545 -0400", hash_original_method = "367A42A5784C609E2D8E37BE922AB4A4", hash_generated_method = "A80896747C9B0F2B6DE5780AB15EB009")
    private void checkOpen() {
        if(streamHandle == -1)        
        {
            IllegalStateException varF2D7421E593C8F4E0E44F2BEF15B7FD9_1254046956 = new IllegalStateException("attempt to use Deflater after calling end");
            varF2D7421E593C8F4E0E44F2BEF15B7FD9_1254046956.addTaint(taint);
            throw varF2D7421E593C8F4E0E44F2BEF15B7FD9_1254046956;
        } //End block
        // ---------- Original Method ----------
        //if (streamHandle == -1) {
            //throw new IllegalStateException("attempt to use Deflater after calling end");
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.546 -0400", hash_original_field = "DFD33B6DC0EAFDE3106DA69F92951B0E", hash_generated_field = "13698D975E7B2387C4A72B340600110B")

    public static final int BEST_COMPRESSION = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.546 -0400", hash_original_field = "485ED5EC9902D9CCF9B0BED1AC4C60F7", hash_generated_field = "890A9513D044EA8A70C3430C0F3910C0")

    public static final int BEST_SPEED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.546 -0400", hash_original_field = "68084C7B8CEB476AD9400A318B9289F8", hash_generated_field = "E7BE2C778DA6187E3452B1A718873C24")

    public static final int DEFAULT_COMPRESSION = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.546 -0400", hash_original_field = "DC267C89A79E63427169027C01602490", hash_generated_field = "19AAC35E658ABBCEB552A5E24211DA20")

    public static final int DEFAULT_STRATEGY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.546 -0400", hash_original_field = "869069D8A539375615C84E9AABE70433", hash_generated_field = "F94D24D83064DA464F1E7F5CBAFCBAC0")

    public static final int DEFLATED = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.546 -0400", hash_original_field = "9AEB1CBA759FFEC8E3029046459ACFBA", hash_generated_field = "2321B2F07267BE7486401DE443318EEF")

    public static final int FILTERED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.547 -0400", hash_original_field = "587FD8F588F29F99FE1AA7FE176137CD", hash_generated_field = "4686D220D976568E44E871FF5A4F153B")

    public static final int HUFFMAN_ONLY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.547 -0400", hash_original_field = "6369E00445C8DA2CFF94672929AF2707", hash_generated_field = "7E480562BE1ECBC592DFD29907509C69")

    public static final int NO_COMPRESSION = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.547 -0400", hash_original_field = "97E4576ACCE5DEA2E02C7121612FE89C", hash_generated_field = "64337D4FC74C09056924942AC04865E4")

    public static final int NO_FLUSH = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.547 -0400", hash_original_field = "C362DFE347A4CD740BB5E73ED98D07FA", hash_generated_field = "7943C4EAA611D10AC2C91440A4B6FD09")

    public static final int SYNC_FLUSH = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.547 -0400", hash_original_field = "27A0AF59BC20A67B97D53567F9B4D04F", hash_generated_field = "7C02FA0E9AA9D37F4E5455FE8EF0CA0F")

    public static final int FULL_FLUSH = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.547 -0400", hash_original_field = "241C8085F9268A3474DFE8D78B638619", hash_generated_field = "7F3FB3722552665A1F9F50826D383337")

    private static final int FINISH = 4;
}

