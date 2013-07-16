package java.util.zip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import dalvik.system.CloseGuard;
import java.io.FileDescriptor;
import java.util.Arrays;

public class Inflater {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.428 -0400", hash_original_field = "61CD1212E4A9CF832E845DAAE8793B2B", hash_generated_field = "0E7AF8D739309A330EB7DABC780C6592")

    private int inLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.428 -0400", hash_original_field = "B6FF059B29EA3AB5FB0489449FEC7684", hash_generated_field = "04384C2608AA53E3C7DB2B14F64353DB")

    private int inRead;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.428 -0400", hash_original_field = "A5D7CEB2C59B8CEE46C2953FEC9ABC19", hash_generated_field = "3E2B0E3E2E572DECE0B20D77E19B79CF")

    private boolean finished;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.428 -0400", hash_original_field = "A97C6D1E094CFFCDE0CAA628171AAED3", hash_generated_field = "ABAE73DF8C1106FF2AA116571646D44D")

    private boolean needsDictionary;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.428 -0400", hash_original_field = "8FDC9AB7980AD9BE440CE02ACB10A779", hash_generated_field = "96E9A434433050A3F1202A32F9BF2C55")

    private long streamHandle = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.428 -0400", hash_original_field = "73ABE739BEC4C3DB38D39FA43D36469F", hash_generated_field = "E7FAF2CA4E8E292A9B5FAAE3D4817EEC")

    private final CloseGuard guard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.428 -0400", hash_original_method = "52564046B1BB792C24EFCB3BD00F948F", hash_generated_method = "AC707E8623E67425139398D18FBF6D77")
    public  Inflater() {
        this(false);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.429 -0400", hash_original_method = "6E14F1A8283580C2FF6B640CB113BDBB", hash_generated_method = "F3D4E77560F2BE6234598D8358838673")
    public  Inflater(boolean noHeader) {
        streamHandle = createStream(noHeader);
        guard.open("end");
        // ---------- Original Method ----------
        //streamHandle = createStream(noHeader);
        //guard.open("end");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.429 -0400", hash_original_method = "EB8AEE543E2EBA4CEDE95D04C6068F47", hash_generated_method = "561BB4497366AC7C6C3B664543BCABCC")
    private long createStream(boolean noHeader1) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_229909496 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_229909496;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.430 -0400", hash_original_method = "2BA55F9CC22F910CD3563C29BAA19EFA", hash_generated_method = "E2BE49D33080C68EF930B0F0DDD61B0D")
    public synchronized void end() {
        guard.close();
    if(streamHandle != -1)        
        {
            endImpl(streamHandle);
            inRead = 0;
            inLength = 0;
            streamHandle = -1;
        } //End block
        // ---------- Original Method ----------
        //guard.close();
        //if (streamHandle != -1) {
            //endImpl(streamHandle);
            //inRead = 0;
            //inLength = 0;
            //streamHandle = -1;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.430 -0400", hash_original_method = "3E089BB1F2369FD5C4FB6F32377D1DAC", hash_generated_method = "69FF97505E0CE664E4B075F4BA3AB10B")
    private void endImpl(long handle) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.430 -0400", hash_original_method = "C6D54AF1AC1AC75675A3D536A7405AD5", hash_generated_method = "288F954BA952FE4D3D00559CB5AA6C74")
    @Override
    protected void finalize() {
        try 
        {
    if(guard != null)            
            {
                guard.warnIfOpen();
            } //End block
            end();
        } //End block
        finally 
        {
            try 
            {
                super.finalize();
            } //End block
            catch (Throwable t)
            {
                AssertionError var31F1143F51E5C3306DAC550F61AF5CBA_1306349404 = new AssertionError(t);
                var31F1143F51E5C3306DAC550F61AF5CBA_1306349404.addTaint(taint);
                throw var31F1143F51E5C3306DAC550F61AF5CBA_1306349404;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //try {
            //if (guard != null) {
                //guard.warnIfOpen();
            //}
            //end();
        //} finally {
            //try {
                //super.finalize();
            //} catch (Throwable t) {
                //throw new AssertionError(t);
            //}
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.431 -0400", hash_original_method = "AE445D0E75B15DAD06E7B3F2F4342E00", hash_generated_method = "3E1688F618667AAF0A6C44FB8BCBEB16")
    public synchronized boolean finished() {
        boolean varA5D7CEB2C59B8CEE46C2953FEC9ABC19_968962416 = (finished);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_776934736 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_776934736;
        // ---------- Original Method ----------
        //return finished;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.431 -0400", hash_original_method = "DDE5644D46702B730F5378ABED0CC02C", hash_generated_method = "2B62E4D596C3115A28FBEB9E3BED25AB")
    public synchronized int getAdler() {
        checkOpen();
        int var61302C031A2885A841CE2FB4B1CD67CE_753693527 = (getAdlerImpl(streamHandle));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_438143224 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_438143224;
        // ---------- Original Method ----------
        //checkOpen();
        //return getAdlerImpl(streamHandle);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.431 -0400", hash_original_method = "B92F3D2B64C580905B1CBAEAEEC7E950", hash_generated_method = "178A18A10D3048CB63C987470D8BA54B")
    private int getAdlerImpl(long handle) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_332670360 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_332670360;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.432 -0400", hash_original_method = "B419E0AF253F709FCCBF4031C175C3E0", hash_generated_method = "356B6B445C62850B5699328C4203B5FD")
    public synchronized long getBytesRead() {
        checkOpen();
        long varFFF9322F09CACDF491BC38F3E51EFD52_25852685 = (getTotalInImpl(streamHandle));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_647463345 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_647463345;
        // ---------- Original Method ----------
        //checkOpen();
        //return getTotalInImpl(streamHandle);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.432 -0400", hash_original_method = "B14826F1D1678AA7FAF007D6D8541F5C", hash_generated_method = "442E2F957B5D6A7DC90FC5F3222E4296")
    public synchronized long getBytesWritten() {
        checkOpen();
        long varF50D575295CFD2BB6AFCADFDDD55EBD6_320417173 = (getTotalOutImpl(streamHandle));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1413633739 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1413633739;
        // ---------- Original Method ----------
        //checkOpen();
        //return getTotalOutImpl(streamHandle);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.432 -0400", hash_original_method = "32C3A4ADD77E37876C3BDB6A1F021118", hash_generated_method = "FB635AABB44D53E09DC48EBBA3F9BE0D")
    public synchronized int getRemaining() {
        int varDB4C5E48B6C5A944BF7B0AF024D11240_1151421836 = (inLength - inRead);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1354143583 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1354143583;
        // ---------- Original Method ----------
        //return inLength - inRead;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.433 -0400", hash_original_method = "9AAB506621EC0609B7127649800D2F50", hash_generated_method = "524405112A309318674D39DE6CD60EA2")
    public synchronized int getTotalIn() {
        checkOpen();
        int var00434087A5B0E0A926DE9A3C60A9B221_177498927 = ((int) Math.min(getTotalInImpl(streamHandle), (long) Integer.MAX_VALUE));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2135688618 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2135688618;
        // ---------- Original Method ----------
        //checkOpen();
        //return (int) Math.min(getTotalInImpl(streamHandle), (long) Integer.MAX_VALUE);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.433 -0400", hash_original_method = "BB22F222483240F64BF20392C09B432F", hash_generated_method = "35EA9B30C7A6775AE62AD4591E2C48A1")
    private long getTotalInImpl(long handle) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1204272315 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1204272315;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.433 -0400", hash_original_method = "FABA8B5ADD5ED280AE5319590E5362F9", hash_generated_method = "C575CC9F5D94BCF6ED8769103B7C5F61")
    public synchronized int getTotalOut() {
        checkOpen();
        int var876CDB6655B12BF320F458DE3670827E_1673531448 = ((int) Math.min(getTotalOutImpl(streamHandle), (long) Integer.MAX_VALUE));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1669861290 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1669861290;
        // ---------- Original Method ----------
        //checkOpen();
        //return (int) Math.min(getTotalOutImpl(streamHandle), (long) Integer.MAX_VALUE);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.434 -0400", hash_original_method = "2C5C1800FBCC7A9569101FDF1B411571", hash_generated_method = "7565467F6A4C950D4C2A4D220E1CC438")
    private long getTotalOutImpl(long handle) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_76608234 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_76608234;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.434 -0400", hash_original_method = "7C5FBD7958B67E2748697C6AE75EF54A", hash_generated_method = "C4E3C11AA35D43557B64815D50AAEF5C")
    public int inflate(byte[] buf) throws DataFormatException {
        addTaint(buf[0]);
        int var1052D5169319D2CD6915B8944C037D04_1543235757 = (inflate(buf, 0, buf.length));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_852798404 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_852798404;
        // ---------- Original Method ----------
        //return inflate(buf, 0, buf.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.435 -0400", hash_original_method = "A9BECE182D792DD8518CBB91F9F00FF9", hash_generated_method = "D267B0BB48D0F60E2A14107B423FF96B")
    public synchronized int inflate(byte[] buf, int offset, int byteCount) throws DataFormatException {
        addTaint(byteCount);
        addTaint(offset);
        addTaint(buf[0]);
        Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        checkOpen();
    if(needsInput())        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1089718249 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2030628138 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2030628138;
        } //End block
        boolean neededDict = needsDictionary;
        needsDictionary = false;
        int result = inflateImpl(buf, offset, byteCount, streamHandle);
    if(needsDictionary && neededDict)        
        {
            DataFormatException var85ADD7DE909FD19CD00AFBA1902F5797_2077863206 = new DataFormatException("Needs dictionary");
            var85ADD7DE909FD19CD00AFBA1902F5797_2077863206.addTaint(taint);
            throw var85ADD7DE909FD19CD00AFBA1902F5797_2077863206;
        } //End block
        int varB4A88417B3D0170D754C647C30B7216A_214662791 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_9799372 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_9799372;
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        //checkOpen();
        //if (needsInput()) {
            //return 0;
        //}
        //boolean neededDict = needsDictionary;
        //needsDictionary = false;
        //int result = inflateImpl(buf, offset, byteCount, streamHandle);
        //if (needsDictionary && neededDict) {
            //throw new DataFormatException("Needs dictionary");
        //}
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.435 -0400", hash_original_method = "A8B950E858D2B61E3A45CBD5749ED1E4", hash_generated_method = "7AD358BA53F1E36BE879D3F7DBC1D31C")
    private int inflateImpl(byte[] buf, int offset, int byteCount, long handle) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1460017447 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1460017447;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.435 -0400", hash_original_method = "2E859AFCAB2941AC9B20C295FD1D1EA5", hash_generated_method = "C21D10A2B2DBD7EF16658D6566FD882D")
    public synchronized boolean needsDictionary() {
        boolean varA97C6D1E094CFFCDE0CAA628171AAED3_164762158 = (needsDictionary);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1471313418 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1471313418;
        // ---------- Original Method ----------
        //return needsDictionary;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.436 -0400", hash_original_method = "2FEA461389DC997E7C6EFE4743DC8941", hash_generated_method = "6E9461CC9F941673D5ADE3608BFD42FB")
    public synchronized boolean needsInput() {
        boolean var8421F335F8C4BFF221A6FB370125003A_732373208 = (inRead == inLength);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1632389872 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1632389872;
        // ---------- Original Method ----------
        //return inRead == inLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.436 -0400", hash_original_method = "0513FF2BBDC9BF2AA8F8AFEEBE87C2FB", hash_generated_method = "9138E4362FA0CE03C0B84709CEB65B62")
    public synchronized void reset() {
        checkOpen();
        finished = false;
        needsDictionary = false;
        inLength = inRead = 0;
        resetImpl(streamHandle);
        // ---------- Original Method ----------
        //checkOpen();
        //finished = false;
        //needsDictionary = false;
        //inLength = inRead = 0;
        //resetImpl(streamHandle);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.436 -0400", hash_original_method = "D92307F0039AB335BB1BCA1E70FBBC75", hash_generated_method = "828BDA31BE8E9DA88C9805DDF29C0415")
    private void resetImpl(long handle) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.437 -0400", hash_original_method = "49DAD22714BA16C1AC9D80CF714D4798", hash_generated_method = "29F4987B3EDC9F789F4884806618B350")
    public synchronized void setDictionary(byte[] dictionary) {
        addTaint(dictionary[0]);
        setDictionary(dictionary, 0, dictionary.length);
        // ---------- Original Method ----------
        //setDictionary(dictionary, 0, dictionary.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.437 -0400", hash_original_method = "568AFB946554DE560CCB8443B419A0F6", hash_generated_method = "1F8CA16C85F6C4079C1E5679BE9CA957")
    public synchronized void setDictionary(byte[] dictionary, int offset, int byteCount) {
        addTaint(byteCount);
        addTaint(offset);
        addTaint(dictionary[0]);
        checkOpen();
        Arrays.checkOffsetAndCount(dictionary.length, offset, byteCount);
        setDictionaryImpl(dictionary, offset, byteCount, streamHandle);
        // ---------- Original Method ----------
        //checkOpen();
        //Arrays.checkOffsetAndCount(dictionary.length, offset, byteCount);
        //setDictionaryImpl(dictionary, offset, byteCount, streamHandle);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.438 -0400", hash_original_method = "3A877A890ED74FC0EF087E03CFE5648B", hash_generated_method = "D8569DD1E53C010664D216B77A175707")
    private void setDictionaryImpl(byte[] dictionary, int offset, int byteCount, long handle) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.438 -0400", hash_original_method = "76E6701B8618856CEE42A14EB071C689", hash_generated_method = "0A72E7D23D3DE9BB626F5F031DD7EB52")
    public synchronized void setInput(byte[] buf) {
        addTaint(buf[0]);
        setInput(buf, 0, buf.length);
        // ---------- Original Method ----------
        //setInput(buf, 0, buf.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.438 -0400", hash_original_method = "D18140A9F42CF395349CBB05A8109835", hash_generated_method = "89768F05B7E01AB0E40B62686905C084")
    public synchronized void setInput(byte[] buf, int offset, int byteCount) {
        addTaint(offset);
        addTaint(buf[0]);
        checkOpen();
        Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        inRead = 0;
        inLength = byteCount;
        setInputImpl(buf, offset, byteCount, streamHandle);
        // ---------- Original Method ----------
        //checkOpen();
        //Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        //inRead = 0;
        //inLength = byteCount;
        //setInputImpl(buf, offset, byteCount, streamHandle);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.439 -0400", hash_original_method = "CFB5087A7D9EFE706B98C4EB08838FDC", hash_generated_method = "A07D70B78BE6B11783FE90F8CB71C6AF")
    private void setInputImpl(byte[] buf, int offset, int byteCount, long handle) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.439 -0400", hash_original_method = "AC4A3418B937D51D6E31ACAFC1E07B42", hash_generated_method = "21CD576802B45CF54A9483340B5F2C0A")
    synchronized int setFileInput(FileDescriptor fd, long offset, int byteCount) {
        checkOpen();
        inRead = 0;
        inLength = setFileInputImpl(fd, offset, byteCount, streamHandle);
        int var61CD1212E4A9CF832E845DAAE8793B2B_1254506112 = (inLength);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1387724330 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1387724330;
        // ---------- Original Method ----------
        //checkOpen();
        //inRead = 0;
        //inLength = setFileInputImpl(fd, offset, byteCount, streamHandle);
        //return inLength;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.440 -0400", hash_original_method = "E3E6A66CB79BDD3B7E592B29E67DC77B", hash_generated_method = "71CD99950C3BFAC4764FA9964DE3E230")
    private int setFileInputImpl(FileDescriptor fd, long offset, int byteCount, long handle) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1099851501 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1099851501;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.440 -0400", hash_original_method = "477FE56B6846A3E6E3ED71C242A2D9F4", hash_generated_method = "C01997F13A778759DC3B6EB6D62797D1")
    private void checkOpen() {
    if(streamHandle == -1)        
        {
            IllegalStateException varA0A4A2CBBB9200D79D5367B783C58685_1313813378 = new IllegalStateException("attempt to use Inflater after calling end");
            varA0A4A2CBBB9200D79D5367B783C58685_1313813378.addTaint(taint);
            throw varA0A4A2CBBB9200D79D5367B783C58685_1313813378;
        } //End block
        // ---------- Original Method ----------
        //if (streamHandle == -1) {
            //throw new IllegalStateException("attempt to use Inflater after calling end");
        //}
    }

    
}

