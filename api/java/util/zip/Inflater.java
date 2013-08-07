package java.util.zip;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.util.Arrays;

import dalvik.system.CloseGuard;





public class Inflater {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.654 -0400", hash_original_field = "61CD1212E4A9CF832E845DAAE8793B2B", hash_generated_field = "0E7AF8D739309A330EB7DABC780C6592")

    private int inLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.654 -0400", hash_original_field = "B6FF059B29EA3AB5FB0489449FEC7684", hash_generated_field = "04384C2608AA53E3C7DB2B14F64353DB")

    private int inRead;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.654 -0400", hash_original_field = "A5D7CEB2C59B8CEE46C2953FEC9ABC19", hash_generated_field = "3E2B0E3E2E572DECE0B20D77E19B79CF")

    private boolean finished;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.654 -0400", hash_original_field = "A97C6D1E094CFFCDE0CAA628171AAED3", hash_generated_field = "ABAE73DF8C1106FF2AA116571646D44D")

    private boolean needsDictionary;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.654 -0400", hash_original_field = "8FDC9AB7980AD9BE440CE02ACB10A779", hash_generated_field = "96E9A434433050A3F1202A32F9BF2C55")

    private long streamHandle = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.654 -0400", hash_original_field = "73ABE739BEC4C3DB38D39FA43D36469F", hash_generated_field = "E7FAF2CA4E8E292A9B5FAAE3D4817EEC")

    private final CloseGuard guard = CloseGuard.get();
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.654 -0400", hash_original_method = "52564046B1BB792C24EFCB3BD00F948F", hash_generated_method = "AC707E8623E67425139398D18FBF6D77")
    public  Inflater() {
        this(false);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.655 -0400", hash_original_method = "6E14F1A8283580C2FF6B640CB113BDBB", hash_generated_method = "F3D4E77560F2BE6234598D8358838673")
    public  Inflater(boolean noHeader) {
        streamHandle = createStream(noHeader);
        guard.open("end");
        // ---------- Original Method ----------
        //streamHandle = createStream(noHeader);
        //guard.open("end");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.655 -0400", hash_original_method = "EB8AEE543E2EBA4CEDE95D04C6068F47", hash_generated_method = "2D78E3C5811ED82524F0487CC397E7F8")
    private long createStream(boolean noHeader1) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1028351921 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1028351921;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.656 -0400", hash_original_method = "2BA55F9CC22F910CD3563C29BAA19EFA", hash_generated_method = "E2BE49D33080C68EF930B0F0DDD61B0D")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.657 -0400", hash_original_method = "3E089BB1F2369FD5C4FB6F32377D1DAC", hash_generated_method = "69FF97505E0CE664E4B075F4BA3AB10B")
    private void endImpl(long handle) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.657 -0400", hash_original_method = "C6D54AF1AC1AC75675A3D536A7405AD5", hash_generated_method = "0E8D55CA4F9026C8C4B9DD1938FC42D0")
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
                AssertionError var31F1143F51E5C3306DAC550F61AF5CBA_838290620 = new AssertionError(t);
                var31F1143F51E5C3306DAC550F61AF5CBA_838290620.addTaint(taint);
                throw var31F1143F51E5C3306DAC550F61AF5CBA_838290620;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.658 -0400", hash_original_method = "AE445D0E75B15DAD06E7B3F2F4342E00", hash_generated_method = "FBA6D2397264136360164A827D0095CA")
    public synchronized boolean finished() {
        boolean varA5D7CEB2C59B8CEE46C2953FEC9ABC19_1772849433 = (finished);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1183556282 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1183556282;
        // ---------- Original Method ----------
        //return finished;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.658 -0400", hash_original_method = "DDE5644D46702B730F5378ABED0CC02C", hash_generated_method = "0431D4362071D7034B80CD1025F938CB")
    public synchronized int getAdler() {
        checkOpen();
        int var61302C031A2885A841CE2FB4B1CD67CE_1712786615 = (getAdlerImpl(streamHandle));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_56361720 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_56361720;
        // ---------- Original Method ----------
        //checkOpen();
        //return getAdlerImpl(streamHandle);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.658 -0400", hash_original_method = "B92F3D2B64C580905B1CBAEAEEC7E950", hash_generated_method = "8834011BA58C663919C9BBE918519222")
    private int getAdlerImpl(long handle) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1310061672 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1310061672;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.659 -0400", hash_original_method = "B419E0AF253F709FCCBF4031C175C3E0", hash_generated_method = "9AE3D39C02837638B9846A1772C61D26")
    public synchronized long getBytesRead() {
        checkOpen();
        long varFFF9322F09CACDF491BC38F3E51EFD52_719437738 = (getTotalInImpl(streamHandle));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_169422794 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_169422794;
        // ---------- Original Method ----------
        //checkOpen();
        //return getTotalInImpl(streamHandle);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.659 -0400", hash_original_method = "B14826F1D1678AA7FAF007D6D8541F5C", hash_generated_method = "398A90F028F2DE4C1C6A4F5B59FF6AB5")
    public synchronized long getBytesWritten() {
        checkOpen();
        long varF50D575295CFD2BB6AFCADFDDD55EBD6_175413180 = (getTotalOutImpl(streamHandle));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1053420632 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1053420632;
        // ---------- Original Method ----------
        //checkOpen();
        //return getTotalOutImpl(streamHandle);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.659 -0400", hash_original_method = "32C3A4ADD77E37876C3BDB6A1F021118", hash_generated_method = "A9EE38B69EE92E9492734FBB001DD81D")
    public synchronized int getRemaining() {
        int varDB4C5E48B6C5A944BF7B0AF024D11240_400183156 = (inLength - inRead);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1043240123 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1043240123;
        // ---------- Original Method ----------
        //return inLength - inRead;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.660 -0400", hash_original_method = "9AAB506621EC0609B7127649800D2F50", hash_generated_method = "1F4C054FED5ACB3256D7AEC2FED64AE2")
    public synchronized int getTotalIn() {
        checkOpen();
        int var00434087A5B0E0A926DE9A3C60A9B221_217614137 = ((int) Math.min(getTotalInImpl(streamHandle), (long) Integer.MAX_VALUE));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_709540334 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_709540334;
        // ---------- Original Method ----------
        //checkOpen();
        //return (int) Math.min(getTotalInImpl(streamHandle), (long) Integer.MAX_VALUE);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.660 -0400", hash_original_method = "BB22F222483240F64BF20392C09B432F", hash_generated_method = "2A11FC18D559445BA0928AAEC9D96D75")
    private long getTotalInImpl(long handle) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_853873602 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_853873602;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.660 -0400", hash_original_method = "FABA8B5ADD5ED280AE5319590E5362F9", hash_generated_method = "0F0391A042118F8DFE5600F6F25D9A0A")
    public synchronized int getTotalOut() {
        checkOpen();
        int var876CDB6655B12BF320F458DE3670827E_141541603 = ((int) Math.min(getTotalOutImpl(streamHandle), (long) Integer.MAX_VALUE));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1135144141 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1135144141;
        // ---------- Original Method ----------
        //checkOpen();
        //return (int) Math.min(getTotalOutImpl(streamHandle), (long) Integer.MAX_VALUE);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.661 -0400", hash_original_method = "2C5C1800FBCC7A9569101FDF1B411571", hash_generated_method = "124A24F2D23F02FC1E57C2C632A6139F")
    private long getTotalOutImpl(long handle) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2082399884 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2082399884;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.661 -0400", hash_original_method = "7C5FBD7958B67E2748697C6AE75EF54A", hash_generated_method = "E2ED8618FE13124E5EA1F405364E9DCC")
    public int inflate(byte[] buf) throws DataFormatException {
        addTaint(buf[0]);
        int var1052D5169319D2CD6915B8944C037D04_1928056298 = (inflate(buf, 0, buf.length));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_619120884 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_619120884;
        // ---------- Original Method ----------
        //return inflate(buf, 0, buf.length);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.662 -0400", hash_original_method = "A9BECE182D792DD8518CBB91F9F00FF9", hash_generated_method = "1F7853392C64D40589AFEF95EF9EF78F")
    public synchronized int inflate(byte[] buf, int offset, int byteCount) throws DataFormatException {
        addTaint(byteCount);
        addTaint(offset);
        addTaint(buf[0]);
        Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        checkOpen();
        if(needsInput())        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1521405314 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1264032269 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1264032269;
        } //End block
        boolean neededDict = needsDictionary;
        needsDictionary = false;
        int result = inflateImpl(buf, offset, byteCount, streamHandle);
        if(needsDictionary && neededDict)        
        {
            DataFormatException var85ADD7DE909FD19CD00AFBA1902F5797_104192650 = new DataFormatException("Needs dictionary");
            var85ADD7DE909FD19CD00AFBA1902F5797_104192650.addTaint(taint);
            throw var85ADD7DE909FD19CD00AFBA1902F5797_104192650;
        } //End block
        int varB4A88417B3D0170D754C647C30B7216A_136314594 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1529629259 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1529629259;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.663 -0400", hash_original_method = "A8B950E858D2B61E3A45CBD5749ED1E4", hash_generated_method = "F9040003F25E479D98C05A82D41C2A66")
    private int inflateImpl(byte[] buf, int offset, int byteCount, long handle) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_634656472 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_634656472;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.663 -0400", hash_original_method = "2E859AFCAB2941AC9B20C295FD1D1EA5", hash_generated_method = "596AA7BD1C03A651810FCC19BEFD0A89")
    public synchronized boolean needsDictionary() {
        boolean varA97C6D1E094CFFCDE0CAA628171AAED3_881905810 = (needsDictionary);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_591122678 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_591122678;
        // ---------- Original Method ----------
        //return needsDictionary;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.664 -0400", hash_original_method = "2FEA461389DC997E7C6EFE4743DC8941", hash_generated_method = "DB07862B754ECE010142A6C8107F496C")
    public synchronized boolean needsInput() {
        boolean var8421F335F8C4BFF221A6FB370125003A_1312726960 = (inRead == inLength);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1499270107 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1499270107;
        // ---------- Original Method ----------
        //return inRead == inLength;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.664 -0400", hash_original_method = "0513FF2BBDC9BF2AA8F8AFEEBE87C2FB", hash_generated_method = "9138E4362FA0CE03C0B84709CEB65B62")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.665 -0400", hash_original_method = "D92307F0039AB335BB1BCA1E70FBBC75", hash_generated_method = "828BDA31BE8E9DA88C9805DDF29C0415")
    private void resetImpl(long handle) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.665 -0400", hash_original_method = "49DAD22714BA16C1AC9D80CF714D4798", hash_generated_method = "29F4987B3EDC9F789F4884806618B350")
    public synchronized void setDictionary(byte[] dictionary) {
        addTaint(dictionary[0]);
        setDictionary(dictionary, 0, dictionary.length);
        // ---------- Original Method ----------
        //setDictionary(dictionary, 0, dictionary.length);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.666 -0400", hash_original_method = "568AFB946554DE560CCB8443B419A0F6", hash_generated_method = "1F8CA16C85F6C4079C1E5679BE9CA957")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.667 -0400", hash_original_method = "3A877A890ED74FC0EF087E03CFE5648B", hash_generated_method = "D8569DD1E53C010664D216B77A175707")
    private void setDictionaryImpl(byte[] dictionary, int offset, int byteCount, long handle) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.667 -0400", hash_original_method = "76E6701B8618856CEE42A14EB071C689", hash_generated_method = "0A72E7D23D3DE9BB626F5F031DD7EB52")
    public synchronized void setInput(byte[] buf) {
        addTaint(buf[0]);
        setInput(buf, 0, buf.length);
        // ---------- Original Method ----------
        //setInput(buf, 0, buf.length);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.667 -0400", hash_original_method = "D18140A9F42CF395349CBB05A8109835", hash_generated_method = "89768F05B7E01AB0E40B62686905C084")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.668 -0400", hash_original_method = "CFB5087A7D9EFE706B98C4EB08838FDC", hash_generated_method = "A07D70B78BE6B11783FE90F8CB71C6AF")
    private void setInputImpl(byte[] buf, int offset, int byteCount, long handle) {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.669 -0400", hash_original_method = "AC4A3418B937D51D6E31ACAFC1E07B42", hash_generated_method = "0CBE8E34213C9002CC49DA419F6AE175")
    synchronized int setFileInput(FileDescriptor fd, long offset, int byteCount) {
        checkOpen();
        inRead = 0;
        inLength = setFileInputImpl(fd, offset, byteCount, streamHandle);
        int var61CD1212E4A9CF832E845DAAE8793B2B_137919337 = (inLength);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_901046074 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_901046074;
        // ---------- Original Method ----------
        //checkOpen();
        //inRead = 0;
        //inLength = setFileInputImpl(fd, offset, byteCount, streamHandle);
        //return inLength;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.669 -0400", hash_original_method = "E3E6A66CB79BDD3B7E592B29E67DC77B", hash_generated_method = "B9798856F51B39F4FA87C3CC292F7D16")
    private int setFileInputImpl(FileDescriptor fd, long offset, int byteCount, long handle) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_826383570 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_826383570;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.669 -0400", hash_original_method = "477FE56B6846A3E6E3ED71C242A2D9F4", hash_generated_method = "70CA9E8B3E47A25E5A76A90C740567FB")
    private void checkOpen() {
        if(streamHandle == -1)        
        {
            IllegalStateException varA0A4A2CBBB9200D79D5367B783C58685_910828096 = new IllegalStateException("attempt to use Inflater after calling end");
            varA0A4A2CBBB9200D79D5367B783C58685_910828096.addTaint(taint);
            throw varA0A4A2CBBB9200D79D5367B783C58685_910828096;
        } //End block
        // ---------- Original Method ----------
        //if (streamHandle == -1) {
            //throw new IllegalStateException("attempt to use Inflater after calling end");
        //}
    }

    
}

