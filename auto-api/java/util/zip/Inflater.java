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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.613 -0400", hash_original_field = "61CD1212E4A9CF832E845DAAE8793B2B", hash_generated_field = "0E7AF8D739309A330EB7DABC780C6592")

    private int inLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.613 -0400", hash_original_field = "B6FF059B29EA3AB5FB0489449FEC7684", hash_generated_field = "04384C2608AA53E3C7DB2B14F64353DB")

    private int inRead;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.613 -0400", hash_original_field = "A5D7CEB2C59B8CEE46C2953FEC9ABC19", hash_generated_field = "3E2B0E3E2E572DECE0B20D77E19B79CF")

    private boolean finished;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.613 -0400", hash_original_field = "A97C6D1E094CFFCDE0CAA628171AAED3", hash_generated_field = "ABAE73DF8C1106FF2AA116571646D44D")

    private boolean needsDictionary;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.613 -0400", hash_original_field = "8FDC9AB7980AD9BE440CE02ACB10A779", hash_generated_field = "96E9A434433050A3F1202A32F9BF2C55")

    private long streamHandle = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.613 -0400", hash_original_field = "73ABE739BEC4C3DB38D39FA43D36469F", hash_generated_field = "2D38C9B39338C5B15F94E3339CE63B3F")

    private CloseGuard guard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.621 -0400", hash_original_method = "52564046B1BB792C24EFCB3BD00F948F", hash_generated_method = "AC707E8623E67425139398D18FBF6D77")
    public  Inflater() {
        this(false);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.629 -0400", hash_original_method = "6E14F1A8283580C2FF6B640CB113BDBB", hash_generated_method = "F3D4E77560F2BE6234598D8358838673")
    public  Inflater(boolean noHeader) {
        streamHandle = createStream(noHeader);
        guard.open("end");
        // ---------- Original Method ----------
        //streamHandle = createStream(noHeader);
        //guard.open("end");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.630 -0400", hash_original_method = "EB8AEE543E2EBA4CEDE95D04C6068F47", hash_generated_method = "C5626DEA5CEBE9A1F66C7319CEBEC107")
    private long createStream(boolean noHeader1) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_526778734 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_526778734;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.630 -0400", hash_original_method = "2BA55F9CC22F910CD3563C29BAA19EFA", hash_generated_method = "90192E7CE08E9CB52E215C74BC2B6E8D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.631 -0400", hash_original_method = "3E089BB1F2369FD5C4FB6F32377D1DAC", hash_generated_method = "69FF97505E0CE664E4B075F4BA3AB10B")
    private void endImpl(long handle) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.643 -0400", hash_original_method = "C6D54AF1AC1AC75675A3D536A7405AD5", hash_generated_method = "0D13B19E410AB05D57205178EE4B3F70")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.644 -0400", hash_original_method = "AE445D0E75B15DAD06E7B3F2F4342E00", hash_generated_method = "BFE15D756693DF03920A4CB03B34FB7A")
    public synchronized boolean finished() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_68047954 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_68047954;
        // ---------- Original Method ----------
        //return finished;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.644 -0400", hash_original_method = "DDE5644D46702B730F5378ABED0CC02C", hash_generated_method = "88E3E7648AFCAD4DA349917552B03757")
    public synchronized int getAdler() {
        checkOpen();
        int var7C17F99AF382ECAC44C03A9EA8865A67_1177393808 = (getAdlerImpl(streamHandle));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1585466786 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1585466786;
        // ---------- Original Method ----------
        //checkOpen();
        //return getAdlerImpl(streamHandle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.645 -0400", hash_original_method = "B92F3D2B64C580905B1CBAEAEEC7E950", hash_generated_method = "5088480D8C36FFCADF5345BE1D6B3B22")
    private int getAdlerImpl(long handle) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_791108285 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_791108285;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.645 -0400", hash_original_method = "B419E0AF253F709FCCBF4031C175C3E0", hash_generated_method = "BF3573962798B94F639884836C8AA939")
    public synchronized long getBytesRead() {
        checkOpen();
        long var6C0E09A019AABCCDC70FCCC5BD7FF31D_1306822600 = (getTotalInImpl(streamHandle));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1991455084 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1991455084;
        // ---------- Original Method ----------
        //checkOpen();
        //return getTotalInImpl(streamHandle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.646 -0400", hash_original_method = "B14826F1D1678AA7FAF007D6D8541F5C", hash_generated_method = "FF8F1C7BBCE3007F3E30839845D3C7A2")
    public synchronized long getBytesWritten() {
        checkOpen();
        long var4BCD5BD6475949FEF14EA9C64C6BCE8A_1611026530 = (getTotalOutImpl(streamHandle));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1837051596 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1837051596;
        // ---------- Original Method ----------
        //checkOpen();
        //return getTotalOutImpl(streamHandle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.671 -0400", hash_original_method = "32C3A4ADD77E37876C3BDB6A1F021118", hash_generated_method = "8B659D8AADE50F5D193575F9C4B826D7")
    public synchronized int getRemaining() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1431749670 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1431749670;
        // ---------- Original Method ----------
        //return inLength - inRead;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.671 -0400", hash_original_method = "9AAB506621EC0609B7127649800D2F50", hash_generated_method = "38A1A4A06B5CD827DCC779BB48D7447B")
    public synchronized int getTotalIn() {
        checkOpen();
        int var28402305727AF84CD5CF2E283F6E8AA0_1295736611 = ((int) Math.min(getTotalInImpl(streamHandle), (long) Integer.MAX_VALUE));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1573157609 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1573157609;
        // ---------- Original Method ----------
        //checkOpen();
        //return (int) Math.min(getTotalInImpl(streamHandle), (long) Integer.MAX_VALUE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.672 -0400", hash_original_method = "BB22F222483240F64BF20392C09B432F", hash_generated_method = "AC5B90D711768A9A5194DF776DF8FCA2")
    private long getTotalInImpl(long handle) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_528184602 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_528184602;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.672 -0400", hash_original_method = "FABA8B5ADD5ED280AE5319590E5362F9", hash_generated_method = "ECB0CF4C0E4F7D7EA5253FCED5B1F8EA")
    public synchronized int getTotalOut() {
        checkOpen();
        int var4862387F17435FA32F87B1F7CDE9AAF2_1926707627 = ((int) Math.min(getTotalOutImpl(streamHandle), (long) Integer.MAX_VALUE));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1540958495 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1540958495;
        // ---------- Original Method ----------
        //checkOpen();
        //return (int) Math.min(getTotalOutImpl(streamHandle), (long) Integer.MAX_VALUE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.672 -0400", hash_original_method = "2C5C1800FBCC7A9569101FDF1B411571", hash_generated_method = "9D35D38B54BDC0B526610E5034586A1E")
    private long getTotalOutImpl(long handle) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1786471292 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1786471292;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.674 -0400", hash_original_method = "7C5FBD7958B67E2748697C6AE75EF54A", hash_generated_method = "59592DBD30E83FBCE412D15EDD27DC2C")
    public int inflate(byte[] buf) throws DataFormatException {
        int varF6678BD8648B61E5E4F1D27B0C57AA1A_439885546 = (inflate(buf, 0, buf.length));
        addTaint(buf[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_755453130 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_755453130;
        // ---------- Original Method ----------
        //return inflate(buf, 0, buf.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.675 -0400", hash_original_method = "A9BECE182D792DD8518CBB91F9F00FF9", hash_generated_method = "23682ED3C3FC03EEDBE2B8DDAB5608CC")
    public synchronized int inflate(byte[] buf, int offset, int byteCount) throws DataFormatException {
        Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        checkOpen();
        {
            boolean var2A60890E3F6E7BEB547797026F828D12_445606917 = (needsInput());
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1053155164 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1053155164;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.675 -0400", hash_original_method = "A8B950E858D2B61E3A45CBD5749ED1E4", hash_generated_method = "C6A6185B438C3D3206597963BBA79BB6")
    private int inflateImpl(byte[] buf, int offset, int byteCount, long handle) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1164716550 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1164716550;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.675 -0400", hash_original_method = "2E859AFCAB2941AC9B20C295FD1D1EA5", hash_generated_method = "8A79827E4EF3FCAC4B76461A453D5F01")
    public synchronized boolean needsDictionary() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1678830724 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1678830724;
        // ---------- Original Method ----------
        //return needsDictionary;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.676 -0400", hash_original_method = "2FEA461389DC997E7C6EFE4743DC8941", hash_generated_method = "C78004062093B5C192CE761E5C5B6147")
    public synchronized boolean needsInput() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_448266663 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_448266663;
        // ---------- Original Method ----------
        //return inRead == inLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.703 -0400", hash_original_method = "0513FF2BBDC9BF2AA8F8AFEEBE87C2FB", hash_generated_method = "9138E4362FA0CE03C0B84709CEB65B62")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.703 -0400", hash_original_method = "D92307F0039AB335BB1BCA1E70FBBC75", hash_generated_method = "828BDA31BE8E9DA88C9805DDF29C0415")
    private void resetImpl(long handle) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.704 -0400", hash_original_method = "49DAD22714BA16C1AC9D80CF714D4798", hash_generated_method = "E430FDAF81BF5D15C7E17F19DF2E5991")
    public synchronized void setDictionary(byte[] dictionary) {
        setDictionary(dictionary, 0, dictionary.length);
        addTaint(dictionary[0]);
        // ---------- Original Method ----------
        //setDictionary(dictionary, 0, dictionary.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.704 -0400", hash_original_method = "568AFB946554DE560CCB8443B419A0F6", hash_generated_method = "9D98C6C3F83E4BDB5153D33243007301")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.704 -0400", hash_original_method = "3A877A890ED74FC0EF087E03CFE5648B", hash_generated_method = "D8569DD1E53C010664D216B77A175707")
    private void setDictionaryImpl(byte[] dictionary, int offset, int byteCount, long handle) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.705 -0400", hash_original_method = "76E6701B8618856CEE42A14EB071C689", hash_generated_method = "362E24DAA8732632000B60035769194D")
    public synchronized void setInput(byte[] buf) {
        setInput(buf, 0, buf.length);
        addTaint(buf[0]);
        // ---------- Original Method ----------
        //setInput(buf, 0, buf.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.706 -0400", hash_original_method = "D18140A9F42CF395349CBB05A8109835", hash_generated_method = "9AA5E2E9FA1E26A79DC843EBB59894A7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.706 -0400", hash_original_method = "CFB5087A7D9EFE706B98C4EB08838FDC", hash_generated_method = "A07D70B78BE6B11783FE90F8CB71C6AF")
    private void setInputImpl(byte[] buf, int offset, int byteCount, long handle) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.712 -0400", hash_original_method = "AC4A3418B937D51D6E31ACAFC1E07B42", hash_generated_method = "377043742823CA740308959AFBA136E7")
    synchronized int setFileInput(FileDescriptor fd, long offset, int byteCount) {
        checkOpen();
        inRead = 0;
        inLength = setFileInputImpl(fd, offset, byteCount, streamHandle);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1825938506 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1825938506;
        // ---------- Original Method ----------
        //checkOpen();
        //inRead = 0;
        //inLength = setFileInputImpl(fd, offset, byteCount, streamHandle);
        //return inLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.726 -0400", hash_original_method = "E3E6A66CB79BDD3B7E592B29E67DC77B", hash_generated_method = "1D1564AD13B4B8FC9278842FA538041C")
    private int setFileInputImpl(FileDescriptor fd, long offset, int byteCount, long handle) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1879021428 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1879021428;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.726 -0400", hash_original_method = "477FE56B6846A3E6E3ED71C242A2D9F4", hash_generated_method = "AF3A8A7419C815DC828233CF022989F3")
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

