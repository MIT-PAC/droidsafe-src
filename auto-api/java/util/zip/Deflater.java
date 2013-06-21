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
    private int flushParm = NO_FLUSH;
    private boolean finished;
    private int compressLevel = DEFAULT_COMPRESSION;
    private int strategy = DEFAULT_STRATEGY;
    private long streamHandle = -1;
    private byte[] inputBuffer;
    private int inRead;
    private int inLength;
    private CloseGuard guard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.691 -0400", hash_original_method = "6DBC61BE4FC097F2420F36A015A6138C", hash_generated_method = "9C40E2104F522B79F67B639B9E119058")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Deflater() {
        this(DEFAULT_COMPRESSION, false);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.692 -0400", hash_original_method = "EE2B377CE8D615D75129B5A0881EF06D", hash_generated_method = "8E861DCB0448C46D273C0CCE3B02F447")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Deflater(int level) {
        this(level, false);
        dsTaint.addTaint(level);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.692 -0400", hash_original_method = "2C334DD40EC2ED2E518DCA464DFDC51E", hash_generated_method = "657DCA63EB17EDC3DD3DA86EAD1FE10E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Deflater(int level, boolean noHeader) {
        dsTaint.addTaint(level);
        dsTaint.addTaint(noHeader);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.693 -0400", hash_original_method = "611AF07E266F550F53CDF01F1CC352A1", hash_generated_method = "196C8B549948CFF4732692B71B90223E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int deflate(byte[] buf) {
        dsTaint.addTaint(buf[0]);
        int var893D70D789FDACB292CF86FBFBD44137_1128776395 = (deflate(buf, 0, buf.length));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return deflate(buf, 0, buf.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.694 -0400", hash_original_method = "0A84F3CD8D711F8E28F74CE9A11C545E", hash_generated_method = "8DA273EA3967C9FEACD2A477DC54FBEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int deflate(byte[] buf, int offset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(buf[0]);
        int var80F4309DE603341EFB6F6849C7300032_1512065730 = (deflateImpl(buf, offset, byteCount, flushParm));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return deflateImpl(buf, offset, byteCount, flushParm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.695 -0400", hash_original_method = "0DC5FF46D79769AAEF0B4E5EA32BA58D", hash_generated_method = "FBD2BA70CB83771837221969B75282B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int deflate(byte[] buf, int offset, int byteCount, int flush) {
        dsTaint.addTaint(flush);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(buf[0]);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad flush value: " + flush);
        } //End block
        int varA9D81B6768F6208DCAEAF06A930A0D7A_507174627 = (deflateImpl(buf, offset, byteCount, flush));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (flush != NO_FLUSH && flush != SYNC_FLUSH && flush != FULL_FLUSH) {
            //throw new IllegalArgumentException("Bad flush value: " + flush);
        //}
        //return deflateImpl(buf, offset, byteCount, flush);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.696 -0400", hash_original_method = "CF6CE2BCD1B535E0E9CC69A73F69BC28", hash_generated_method = "8711238613EDC5619B9F24B803246F1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized int deflateImpl(byte[] buf, int offset, int byteCount, int flush) {
        dsTaint.addTaint(flush);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(buf[0]);
        checkOpen();
        Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        {
            setInput(EmptyArray.BYTE);
        } //End block
        int varF117D10B15EF7E16529E8E5A17ABF988_63146322 = (deflateImpl(buf, offset, byteCount, streamHandle, flush));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkOpen();
        //Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        //if (inputBuffer == null) {
            //setInput(EmptyArray.BYTE);
        //}
        //return deflateImpl(buf, offset, byteCount, streamHandle, flush);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.696 -0400", hash_original_method = "54CA80994C94CBB2D32C9857F1640D60", hash_generated_method = "749AFE9FE5E2BD230B6C21D39DDB3EFF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int deflateImpl(byte[] buf, int offset, int byteCount, long handle, int flushParm) {
        dsTaint.addTaint(handle);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(flushParm);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(buf[0]);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.696 -0400", hash_original_method = "59D998A9FACC96CAD9DEE3EEFD22688A", hash_generated_method = "B152F8064A4030CE4BA6346CB469F4A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void end() {
        guard.close();
        endImpl();
        // ---------- Original Method ----------
        //guard.close();
        //endImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.696 -0400", hash_original_method = "4DA7D037A1FCD4109F30526C6DE57D1C", hash_generated_method = "9E4BD957FB186A2C3EA067CA99A72F76")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.696 -0400", hash_original_method = "3E089BB1F2369FD5C4FB6F32377D1DAC", hash_generated_method = "A82D71DE046E333CE9C5997B28EE7E8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void endImpl(long handle) {
        dsTaint.addTaint(handle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.697 -0400", hash_original_method = "FC32DF56978CE95FA2CC2CA96409152E", hash_generated_method = "35E298592E9F780BD76C099CA75D8A15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.697 -0400", hash_original_method = "CE8BB8EC5EB7D8A83BE6D0D952D2FABD", hash_generated_method = "DE0495773E68A9D77614A209FED334FD")
    @DSModeled(DSC.SAFE)
    public synchronized void finish() {
        flushParm = FINISH;
        // ---------- Original Method ----------
        //flushParm = FINISH;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.697 -0400", hash_original_method = "AE445D0E75B15DAD06E7B3F2F4342E00", hash_generated_method = "2FA78662B1E1ABF5ADF30F385EFE918E")
    @DSModeled(DSC.SAFE)
    public synchronized boolean finished() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return finished;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.697 -0400", hash_original_method = "DDE5644D46702B730F5378ABED0CC02C", hash_generated_method = "955D95273E2BBC1DDBE3CA632E559660")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int getAdler() {
        checkOpen();
        int var7C17F99AF382ECAC44C03A9EA8865A67_175204961 = (getAdlerImpl(streamHandle));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkOpen();
        //return getAdlerImpl(streamHandle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.697 -0400", hash_original_method = "B92F3D2B64C580905B1CBAEAEEC7E950", hash_generated_method = "E8007A4EC17B7C24FAD0675CFC7539EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getAdlerImpl(long handle) {
        dsTaint.addTaint(handle);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.698 -0400", hash_original_method = "26E16A0AF7B91ACC2C2C1D26CF0A41A1", hash_generated_method = "BA8167430375129CDB7F643DA91EB9BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int getTotalIn() {
        checkOpen();
        int var071A51235A297A3E32C97CEC93F0F7A3_1597358577 = ((int) getTotalInImpl(streamHandle));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkOpen();
        //return (int) getTotalInImpl(streamHandle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.698 -0400", hash_original_method = "BB22F222483240F64BF20392C09B432F", hash_generated_method = "B3CC389EEFEB24F526D02301EC27265A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private long getTotalInImpl(long handle) {
        dsTaint.addTaint(handle);
        return dsTaint.getTaintLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.698 -0400", hash_original_method = "20FDDC2AB6FE185B9CAB89D86709EB03", hash_generated_method = "2DB4AD2B40E5734123AB670BAD8695C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int getTotalOut() {
        checkOpen();
        int var48AD0E5A1DEFA4126AF03485C5098F68_245934333 = ((int) getTotalOutImpl(streamHandle));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkOpen();
        //return (int) getTotalOutImpl(streamHandle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.698 -0400", hash_original_method = "2C5C1800FBCC7A9569101FDF1B411571", hash_generated_method = "0BE7075C40B6D82EAC565E7B8E8640B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private long getTotalOutImpl(long handle) {
        dsTaint.addTaint(handle);
        return dsTaint.getTaintLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.698 -0400", hash_original_method = "F6DEF148508A4D024151CB5B8FE739D4", hash_generated_method = "D6B67205C174F8D26DBC9B675365375A")
    @DSModeled(DSC.SAFE)
    public synchronized boolean needsInput() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (inputBuffer == null) {
            //return true;
        //}
        //return inRead == inLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.699 -0400", hash_original_method = "F900704F0994CBD6978E5E4205C2BFAA", hash_generated_method = "8F653F79FAF5A2A59E779C8C5328349D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.699 -0400", hash_original_method = "D92307F0039AB335BB1BCA1E70FBBC75", hash_generated_method = "73B15643397824AB64E6F0FDE50D65BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void resetImpl(long handle) {
        dsTaint.addTaint(handle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.699 -0400", hash_original_method = "49DAD22714BA16C1AC9D80CF714D4798", hash_generated_method = "B34C129A86578E8E9287FA26AEA45DC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDictionary(byte[] dictionary) {
        dsTaint.addTaint(dictionary[0]);
        setDictionary(dictionary, 0, dictionary.length);
        // ---------- Original Method ----------
        //setDictionary(dictionary, 0, dictionary.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.708 -0400", hash_original_method = "7FB505FB7F1826F86B368368EBDBCA40", hash_generated_method = "DF7247512F5EC4FBD0553D5C2FED6BF3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setDictionary(byte[] buf, int offset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(buf[0]);
        checkOpen();
        Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        setDictionaryImpl(buf, offset, byteCount, streamHandle);
        // ---------- Original Method ----------
        //checkOpen();
        //Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        //setDictionaryImpl(buf, offset, byteCount, streamHandle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.709 -0400", hash_original_method = "7E435812B66ABED0B356693E1B3AC0D7", hash_generated_method = "55D859B28D22B87E43563F2FF7202928")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setDictionaryImpl(byte[] buf, int offset, int byteCount, long handle) {
        dsTaint.addTaint(handle);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(buf[0]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.709 -0400", hash_original_method = "76E6701B8618856CEE42A14EB071C689", hash_generated_method = "0E2AAFE04E117BDB0B5872F4BBCCD849")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setInput(byte[] buf) {
        dsTaint.addTaint(buf[0]);
        setInput(buf, 0, buf.length);
        // ---------- Original Method ----------
        //setInput(buf, 0, buf.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.711 -0400", hash_original_method = "5EAC232252C5BA68B98F924DC24DA75C", hash_generated_method = "B003456EF7FDA87AFC7C3F5A789AB877")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setInput(byte[] buf, int offset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(buf[0]);
        checkOpen();
        Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        inRead = 0;
        {
            setLevelsImpl(compressLevel, strategy, streamHandle);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.711 -0400", hash_original_method = "6366C8E331223E53339096A4FF906729", hash_generated_method = "CE987098FE601DDE1B4C6FEB07B43B41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setLevelsImpl(int level, int strategy, long handle) {
        dsTaint.addTaint(handle);
        dsTaint.addTaint(level);
        dsTaint.addTaint(strategy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.712 -0400", hash_original_method = "CFB5087A7D9EFE706B98C4EB08838FDC", hash_generated_method = "B928F4A9223A597711DB1784A903921E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setInputImpl(byte[] buf, int offset, int byteCount, long handle) {
        dsTaint.addTaint(handle);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(buf[0]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.712 -0400", hash_original_method = "56416D14F8B23CE0A4E07C0AD61CD8D1", hash_generated_method = "D37D939593FFCDEC515DF32091B58656")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setLevel(int level) {
        dsTaint.addTaint(level);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad level: " + level);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("setLevel cannot be called after setInput");
        } //End block
        // ---------- Original Method ----------
        //if (level < DEFAULT_COMPRESSION || level > BEST_COMPRESSION) {
            //throw new IllegalArgumentException("Bad level: " + level);
        //}
        //if (inputBuffer != null) {
            //throw new IllegalStateException("setLevel cannot be called after setInput");
        //}
        //compressLevel = level;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.712 -0400", hash_original_method = "9A84D355252A826695237C59231B1742", hash_generated_method = "95289CDD0DB7653DB8A09C06125FF168")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setStrategy(int strategy) {
        dsTaint.addTaint(strategy);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad strategy: " + strategy);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("setStrategy cannot be called after setInput");
        } //End block
        // ---------- Original Method ----------
        //if (strategy < DEFAULT_STRATEGY || strategy > HUFFMAN_ONLY) {
            //throw new IllegalArgumentException("Bad strategy: " + strategy);
        //}
        //if (inputBuffer != null) {
            //throw new IllegalStateException("setStrategy cannot be called after setInput");
        //}
        //this.strategy = strategy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.712 -0400", hash_original_method = "B419E0AF253F709FCCBF4031C175C3E0", hash_generated_method = "886C893111CA943556DE6A4C2E822FF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized long getBytesRead() {
        checkOpen();
        long var6C0E09A019AABCCDC70FCCC5BD7FF31D_1463630865 = (getTotalInImpl(streamHandle));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //checkOpen();
        //return getTotalInImpl(streamHandle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.713 -0400", hash_original_method = "B14826F1D1678AA7FAF007D6D8541F5C", hash_generated_method = "5A790DC9F51FAC358CD0317D3137E615")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized long getBytesWritten() {
        checkOpen();
        long var4BCD5BD6475949FEF14EA9C64C6BCE8A_1712852159 = (getTotalOutImpl(streamHandle));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //checkOpen();
        //return getTotalOutImpl(streamHandle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.713 -0400", hash_original_method = "C56CB62EAF4356747257EC4F43A6E2A6", hash_generated_method = "DEE50FE22B8F961557FE3DA5DF416F70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private long createStream(int level, int strategy1, boolean noHeader1) {
        dsTaint.addTaint(strategy1);
        dsTaint.addTaint(level);
        dsTaint.addTaint(noHeader1);
        return dsTaint.getTaintLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.713 -0400", hash_original_method = "367A42A5784C609E2D8E37BE922AB4A4", hash_generated_method = "C8C55B8B52143CB776406B58F0800BC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkOpen() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("attempt to use Deflater after calling end");
        } //End block
        // ---------- Original Method ----------
        //if (streamHandle == -1) {
            //throw new IllegalStateException("attempt to use Deflater after calling end");
        //}
    }

    
    public static final int BEST_COMPRESSION = 9;
    public static final int BEST_SPEED = 1;
    public static final int DEFAULT_COMPRESSION = -1;
    public static final int DEFAULT_STRATEGY = 0;
    public static final int DEFLATED = 8;
    public static final int FILTERED = 1;
    public static final int HUFFMAN_ONLY = 2;
    public static final int NO_COMPRESSION = 0;
    public static final int NO_FLUSH = 0;
    public static final int SYNC_FLUSH = 2;
    public static final int FULL_FLUSH = 3;
    private static final int FINISH = 4;
}

