package java.util.zip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import dalvik.system.CloseGuard;
import java.io.FileDescriptor;
import java.util.Arrays;

public class Inflater {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.811 -0400", hash_original_field = "61CD1212E4A9CF832E845DAAE8793B2B", hash_generated_field = "0E7AF8D739309A330EB7DABC780C6592")

    private int inLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.811 -0400", hash_original_field = "B6FF059B29EA3AB5FB0489449FEC7684", hash_generated_field = "04384C2608AA53E3C7DB2B14F64353DB")

    private int inRead;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.811 -0400", hash_original_field = "A5D7CEB2C59B8CEE46C2953FEC9ABC19", hash_generated_field = "3E2B0E3E2E572DECE0B20D77E19B79CF")

    private boolean finished;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.811 -0400", hash_original_field = "A97C6D1E094CFFCDE0CAA628171AAED3", hash_generated_field = "ABAE73DF8C1106FF2AA116571646D44D")

    private boolean needsDictionary;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.811 -0400", hash_original_field = "8FDC9AB7980AD9BE440CE02ACB10A779", hash_generated_field = "96E9A434433050A3F1202A32F9BF2C55")

    private long streamHandle = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.814 -0400", hash_original_field = "73ABE739BEC4C3DB38D39FA43D36469F", hash_generated_field = "2D38C9B39338C5B15F94E3339CE63B3F")

    private CloseGuard guard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.815 -0400", hash_original_method = "52564046B1BB792C24EFCB3BD00F948F", hash_generated_method = "AC707E8623E67425139398D18FBF6D77")
    public  Inflater() {
        this(false);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.820 -0400", hash_original_method = "6E14F1A8283580C2FF6B640CB113BDBB", hash_generated_method = "F3D4E77560F2BE6234598D8358838673")
    public  Inflater(boolean noHeader) {
        streamHandle = createStream(noHeader);
        guard.open("end");
        // ---------- Original Method ----------
        //streamHandle = createStream(noHeader);
        //guard.open("end");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.820 -0400", hash_original_method = "EB8AEE543E2EBA4CEDE95D04C6068F47", hash_generated_method = "278719BB1F0614315A65AA7A21A0072F")
    private long createStream(boolean noHeader1) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_20793549 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_20793549;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.827 -0400", hash_original_method = "2BA55F9CC22F910CD3563C29BAA19EFA", hash_generated_method = "90192E7CE08E9CB52E215C74BC2B6E8D")
    public synchronized void end() {
        guard.close();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.827 -0400", hash_original_method = "3E089BB1F2369FD5C4FB6F32377D1DAC", hash_generated_method = "69FF97505E0CE664E4B075F4BA3AB10B")
    private void endImpl(long handle) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.828 -0400", hash_original_method = "C6D54AF1AC1AC75675A3D536A7405AD5", hash_generated_method = "0D13B19E410AB05D57205178EE4B3F70")
    @Override
    protected void finalize() {
        try 
        {
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
                if (DroidSafeAndroidRuntime.control) throw new AssertionError(t);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.828 -0400", hash_original_method = "AE445D0E75B15DAD06E7B3F2F4342E00", hash_generated_method = "A1430F7FBD7EAE9B01823F77CA8C6A17")
    public synchronized boolean finished() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_60541198 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_60541198;
        // ---------- Original Method ----------
        //return finished;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.829 -0400", hash_original_method = "DDE5644D46702B730F5378ABED0CC02C", hash_generated_method = "D26D558BB9E287542ED8D27D007BDE3C")
    public synchronized int getAdler() {
        checkOpen();
        int var7C17F99AF382ECAC44C03A9EA8865A67_1045919299 = (getAdlerImpl(streamHandle));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1031712296 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1031712296;
        // ---------- Original Method ----------
        //checkOpen();
        //return getAdlerImpl(streamHandle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.832 -0400", hash_original_method = "B92F3D2B64C580905B1CBAEAEEC7E950", hash_generated_method = "6F35605ACC4B2382B7F2B92D6982945D")
    private int getAdlerImpl(long handle) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_838913319 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_838913319;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.834 -0400", hash_original_method = "B419E0AF253F709FCCBF4031C175C3E0", hash_generated_method = "BC76C8F857FE0350E9857C6F6542622B")
    public synchronized long getBytesRead() {
        checkOpen();
        long var6C0E09A019AABCCDC70FCCC5BD7FF31D_424059393 = (getTotalInImpl(streamHandle));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1375888757 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1375888757;
        // ---------- Original Method ----------
        //checkOpen();
        //return getTotalInImpl(streamHandle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.840 -0400", hash_original_method = "B14826F1D1678AA7FAF007D6D8541F5C", hash_generated_method = "69FC5A9AE066DD052AEB1CE49243C55E")
    public synchronized long getBytesWritten() {
        checkOpen();
        long var4BCD5BD6475949FEF14EA9C64C6BCE8A_378703499 = (getTotalOutImpl(streamHandle));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_352362712 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_352362712;
        // ---------- Original Method ----------
        //checkOpen();
        //return getTotalOutImpl(streamHandle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.842 -0400", hash_original_method = "32C3A4ADD77E37876C3BDB6A1F021118", hash_generated_method = "68BC6D75D8E699E7435DE26713C52347")
    public synchronized int getRemaining() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1787499029 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1787499029;
        // ---------- Original Method ----------
        //return inLength - inRead;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.843 -0400", hash_original_method = "9AAB506621EC0609B7127649800D2F50", hash_generated_method = "EE31E010CEA9155B2C6580CFD2A9BFA1")
    public synchronized int getTotalIn() {
        checkOpen();
        int var28402305727AF84CD5CF2E283F6E8AA0_2095283247 = ((int) Math.min(getTotalInImpl(streamHandle), (long) Integer.MAX_VALUE));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1242752757 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1242752757;
        // ---------- Original Method ----------
        //checkOpen();
        //return (int) Math.min(getTotalInImpl(streamHandle), (long) Integer.MAX_VALUE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.843 -0400", hash_original_method = "BB22F222483240F64BF20392C09B432F", hash_generated_method = "591ABA5DD7732C4041EDE0BEE56E251E")
    private long getTotalInImpl(long handle) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_672633869 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_672633869;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.843 -0400", hash_original_method = "FABA8B5ADD5ED280AE5319590E5362F9", hash_generated_method = "24D7EF9E6B83836D5B397E4FA4E1B195")
    public synchronized int getTotalOut() {
        checkOpen();
        int var4862387F17435FA32F87B1F7CDE9AAF2_1645835490 = ((int) Math.min(getTotalOutImpl(streamHandle), (long) Integer.MAX_VALUE));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1583943513 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1583943513;
        // ---------- Original Method ----------
        //checkOpen();
        //return (int) Math.min(getTotalOutImpl(streamHandle), (long) Integer.MAX_VALUE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.844 -0400", hash_original_method = "2C5C1800FBCC7A9569101FDF1B411571", hash_generated_method = "044AE0D11EC56BF4639D689FB5CD1B72")
    private long getTotalOutImpl(long handle) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_66354236 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_66354236;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.844 -0400", hash_original_method = "7C5FBD7958B67E2748697C6AE75EF54A", hash_generated_method = "FF8EA6E77784B8BA10006A08B6EC3A0F")
    public int inflate(byte[] buf) throws DataFormatException {
        int varF6678BD8648B61E5E4F1D27B0C57AA1A_1846122649 = (inflate(buf, 0, buf.length));
        addTaint(buf[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2113547634 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2113547634;
        // ---------- Original Method ----------
        //return inflate(buf, 0, buf.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.854 -0400", hash_original_method = "A9BECE182D792DD8518CBB91F9F00FF9", hash_generated_method = "3F257954E4EB3A778D8033DE8AC758E8")
    public synchronized int inflate(byte[] buf, int offset, int byteCount) throws DataFormatException {
        Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        checkOpen();
        {
            boolean var2A60890E3F6E7BEB547797026F828D12_560029436 = (needsInput());
        } //End collapsed parenthetic
        boolean neededDict;
        neededDict = needsDictionary;
        needsDictionary = false;
        int result;
        result = inflateImpl(buf, offset, byteCount, streamHandle);
        {
            if (DroidSafeAndroidRuntime.control) throw new DataFormatException("Needs dictionary");
        } //End block
        addTaint(buf[0]);
        addTaint(offset);
        addTaint(byteCount);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1284291802 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1284291802;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.854 -0400", hash_original_method = "A8B950E858D2B61E3A45CBD5749ED1E4", hash_generated_method = "4CB622F6C7919DE6892B11F2A1F4F759")
    private int inflateImpl(byte[] buf, int offset, int byteCount, long handle) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_431515961 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_431515961;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.855 -0400", hash_original_method = "2E859AFCAB2941AC9B20C295FD1D1EA5", hash_generated_method = "F95348D58A98C55FB074CA33CBE69DBE")
    public synchronized boolean needsDictionary() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_707585158 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_707585158;
        // ---------- Original Method ----------
        //return needsDictionary;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.855 -0400", hash_original_method = "2FEA461389DC997E7C6EFE4743DC8941", hash_generated_method = "E856E87ED56113865CBBE87CF9CDAD2A")
    public synchronized boolean needsInput() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_619384041 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_619384041;
        // ---------- Original Method ----------
        //return inRead == inLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.856 -0400", hash_original_method = "0513FF2BBDC9BF2AA8F8AFEEBE87C2FB", hash_generated_method = "9138E4362FA0CE03C0B84709CEB65B62")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.856 -0400", hash_original_method = "D92307F0039AB335BB1BCA1E70FBBC75", hash_generated_method = "828BDA31BE8E9DA88C9805DDF29C0415")
    private void resetImpl(long handle) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.866 -0400", hash_original_method = "49DAD22714BA16C1AC9D80CF714D4798", hash_generated_method = "E430FDAF81BF5D15C7E17F19DF2E5991")
    public synchronized void setDictionary(byte[] dictionary) {
        setDictionary(dictionary, 0, dictionary.length);
        addTaint(dictionary[0]);
        // ---------- Original Method ----------
        //setDictionary(dictionary, 0, dictionary.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.868 -0400", hash_original_method = "568AFB946554DE560CCB8443B419A0F6", hash_generated_method = "9D98C6C3F83E4BDB5153D33243007301")
    public synchronized void setDictionary(byte[] dictionary, int offset, int byteCount) {
        checkOpen();
        Arrays.checkOffsetAndCount(dictionary.length, offset, byteCount);
        setDictionaryImpl(dictionary, offset, byteCount, streamHandle);
        addTaint(dictionary[0]);
        addTaint(offset);
        addTaint(byteCount);
        // ---------- Original Method ----------
        //checkOpen();
        //Arrays.checkOffsetAndCount(dictionary.length, offset, byteCount);
        //setDictionaryImpl(dictionary, offset, byteCount, streamHandle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.870 -0400", hash_original_method = "3A877A890ED74FC0EF087E03CFE5648B", hash_generated_method = "D8569DD1E53C010664D216B77A175707")
    private void setDictionaryImpl(byte[] dictionary, int offset, int byteCount, long handle) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.904 -0400", hash_original_method = "76E6701B8618856CEE42A14EB071C689", hash_generated_method = "362E24DAA8732632000B60035769194D")
    public synchronized void setInput(byte[] buf) {
        setInput(buf, 0, buf.length);
        addTaint(buf[0]);
        // ---------- Original Method ----------
        //setInput(buf, 0, buf.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.905 -0400", hash_original_method = "D18140A9F42CF395349CBB05A8109835", hash_generated_method = "9AA5E2E9FA1E26A79DC843EBB59894A7")
    public synchronized void setInput(byte[] buf, int offset, int byteCount) {
        checkOpen();
        Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        inRead = 0;
        inLength = byteCount;
        setInputImpl(buf, offset, byteCount, streamHandle);
        addTaint(buf[0]);
        addTaint(offset);
        // ---------- Original Method ----------
        //checkOpen();
        //Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        //inRead = 0;
        //inLength = byteCount;
        //setInputImpl(buf, offset, byteCount, streamHandle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.905 -0400", hash_original_method = "CFB5087A7D9EFE706B98C4EB08838FDC", hash_generated_method = "A07D70B78BE6B11783FE90F8CB71C6AF")
    private void setInputImpl(byte[] buf, int offset, int byteCount, long handle) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.914 -0400", hash_original_method = "AC4A3418B937D51D6E31ACAFC1E07B42", hash_generated_method = "859081FBDBEF136E9042E5CFFE434060")
    synchronized int setFileInput(FileDescriptor fd, long offset, int byteCount) {
        checkOpen();
        inRead = 0;
        inLength = setFileInputImpl(fd, offset, byteCount, streamHandle);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1965355087 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1965355087;
        // ---------- Original Method ----------
        //checkOpen();
        //inRead = 0;
        //inLength = setFileInputImpl(fd, offset, byteCount, streamHandle);
        //return inLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.914 -0400", hash_original_method = "E3E6A66CB79BDD3B7E592B29E67DC77B", hash_generated_method = "55D8EC0984EE6EBA632D802DF54C6621")
    private int setFileInputImpl(FileDescriptor fd, long offset, int byteCount, long handle) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_618533433 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_618533433;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:59.915 -0400", hash_original_method = "477FE56B6846A3E6E3ED71C242A2D9F4", hash_generated_method = "AF3A8A7419C815DC828233CF022989F3")
    private void checkOpen() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("attempt to use Inflater after calling end");
        } //End block
        // ---------- Original Method ----------
        //if (streamHandle == -1) {
            //throw new IllegalStateException("attempt to use Inflater after calling end");
        //}
    }

    
}

