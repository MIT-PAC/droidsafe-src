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
    private int inLength;
    private int inRead;
    private boolean finished;
    private boolean needsDictionary;
    private long streamHandle = -1;
    private CloseGuard guard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.778 -0400", hash_original_method = "52564046B1BB792C24EFCB3BD00F948F", hash_generated_method = "AC707E8623E67425139398D18FBF6D77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Inflater() {
        this(false);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.779 -0400", hash_original_method = "6E14F1A8283580C2FF6B640CB113BDBB", hash_generated_method = "2F93CAF69F0C30F06A414988F41C6250")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Inflater(boolean noHeader) {
        dsTaint.addTaint(noHeader);
        streamHandle = createStream(noHeader);
        guard.open("end");
        // ---------- Original Method ----------
        //streamHandle = createStream(noHeader);
        //guard.open("end");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.779 -0400", hash_original_method = "EB8AEE543E2EBA4CEDE95D04C6068F47", hash_generated_method = "2D88701BA360D4CD27B52E529476F947")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private long createStream(boolean noHeader1) {
        dsTaint.addTaint(noHeader1);
        return dsTaint.getTaintLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.779 -0400", hash_original_method = "2BA55F9CC22F910CD3563C29BAA19EFA", hash_generated_method = "90192E7CE08E9CB52E215C74BC2B6E8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.779 -0400", hash_original_method = "3E089BB1F2369FD5C4FB6F32377D1DAC", hash_generated_method = "A82D71DE046E333CE9C5997B28EE7E8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void endImpl(long handle) {
        dsTaint.addTaint(handle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.780 -0400", hash_original_method = "C6D54AF1AC1AC75675A3D536A7405AD5", hash_generated_method = "0D13B19E410AB05D57205178EE4B3F70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.780 -0400", hash_original_method = "AE445D0E75B15DAD06E7B3F2F4342E00", hash_generated_method = "2FA78662B1E1ABF5ADF30F385EFE918E")
    @DSModeled(DSC.SAFE)
    public synchronized boolean finished() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return finished;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.780 -0400", hash_original_method = "DDE5644D46702B730F5378ABED0CC02C", hash_generated_method = "ACE29EE91A08CE794EE78E5BD8B103CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int getAdler() {
        checkOpen();
        int var7C17F99AF382ECAC44C03A9EA8865A67_212514269 = (getAdlerImpl(streamHandle));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkOpen();
        //return getAdlerImpl(streamHandle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.780 -0400", hash_original_method = "B92F3D2B64C580905B1CBAEAEEC7E950", hash_generated_method = "E8007A4EC17B7C24FAD0675CFC7539EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getAdlerImpl(long handle) {
        dsTaint.addTaint(handle);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.781 -0400", hash_original_method = "B419E0AF253F709FCCBF4031C175C3E0", hash_generated_method = "D405D228C0790E4DCA3CA00858035888")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized long getBytesRead() {
        checkOpen();
        long var6C0E09A019AABCCDC70FCCC5BD7FF31D_786396895 = (getTotalInImpl(streamHandle));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //checkOpen();
        //return getTotalInImpl(streamHandle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.781 -0400", hash_original_method = "B14826F1D1678AA7FAF007D6D8541F5C", hash_generated_method = "27B2492EB03365F31F2238D47493A30F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized long getBytesWritten() {
        checkOpen();
        long var4BCD5BD6475949FEF14EA9C64C6BCE8A_1625512627 = (getTotalOutImpl(streamHandle));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //checkOpen();
        //return getTotalOutImpl(streamHandle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.781 -0400", hash_original_method = "32C3A4ADD77E37876C3BDB6A1F021118", hash_generated_method = "5F6F938CF4605C6847B3CA610027D915")
    @DSModeled(DSC.SAFE)
    public synchronized int getRemaining() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return inLength - inRead;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.781 -0400", hash_original_method = "9AAB506621EC0609B7127649800D2F50", hash_generated_method = "127E9C316CDAB8FEA75576B2C9356379")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int getTotalIn() {
        checkOpen();
        int var28402305727AF84CD5CF2E283F6E8AA0_800111217 = ((int) Math.min(getTotalInImpl(streamHandle), (long) Integer.MAX_VALUE));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkOpen();
        //return (int) Math.min(getTotalInImpl(streamHandle), (long) Integer.MAX_VALUE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.781 -0400", hash_original_method = "BB22F222483240F64BF20392C09B432F", hash_generated_method = "B3CC389EEFEB24F526D02301EC27265A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private long getTotalInImpl(long handle) {
        dsTaint.addTaint(handle);
        return dsTaint.getTaintLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.782 -0400", hash_original_method = "FABA8B5ADD5ED280AE5319590E5362F9", hash_generated_method = "19539BE0846ABB6322BA41413B546C05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int getTotalOut() {
        checkOpen();
        int var4862387F17435FA32F87B1F7CDE9AAF2_470378584 = ((int) Math.min(getTotalOutImpl(streamHandle), (long) Integer.MAX_VALUE));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkOpen();
        //return (int) Math.min(getTotalOutImpl(streamHandle), (long) Integer.MAX_VALUE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.782 -0400", hash_original_method = "2C5C1800FBCC7A9569101FDF1B411571", hash_generated_method = "0BE7075C40B6D82EAC565E7B8E8640B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private long getTotalOutImpl(long handle) {
        dsTaint.addTaint(handle);
        return dsTaint.getTaintLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.782 -0400", hash_original_method = "7C5FBD7958B67E2748697C6AE75EF54A", hash_generated_method = "980C6F0AA72222EA73EDF04B76407082")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int inflate(byte[] buf) throws DataFormatException {
        dsTaint.addTaint(buf[0]);
        int varF6678BD8648B61E5E4F1D27B0C57AA1A_1256066425 = (inflate(buf, 0, buf.length));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return inflate(buf, 0, buf.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.782 -0400", hash_original_method = "A9BECE182D792DD8518CBB91F9F00FF9", hash_generated_method = "84A4E6782D1BD2705929AE147332486B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized int inflate(byte[] buf, int offset, int byteCount) throws DataFormatException {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(buf[0]);
        Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        checkOpen();
        {
            boolean var2A60890E3F6E7BEB547797026F828D12_1753285386 = (needsInput());
        } //End collapsed parenthetic
        boolean neededDict;
        neededDict = needsDictionary;
        needsDictionary = false;
        int result;
        result = inflateImpl(buf, offset, byteCount, streamHandle);
        {
            if (DroidSafeAndroidRuntime.control) throw new DataFormatException("Needs dictionary");
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.783 -0400", hash_original_method = "A8B950E858D2B61E3A45CBD5749ED1E4", hash_generated_method = "8FE13829163D82C29909EFD7F6DC349D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int inflateImpl(byte[] buf, int offset, int byteCount, long handle) {
        dsTaint.addTaint(handle);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(buf[0]);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.783 -0400", hash_original_method = "2E859AFCAB2941AC9B20C295FD1D1EA5", hash_generated_method = "61F0A9187AAA72F32B28A49EFEBABA6C")
    @DSModeled(DSC.SAFE)
    public synchronized boolean needsDictionary() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return needsDictionary;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.783 -0400", hash_original_method = "2FEA461389DC997E7C6EFE4743DC8941", hash_generated_method = "34A44B89952E56D07AC254B950807783")
    @DSModeled(DSC.SAFE)
    public synchronized boolean needsInput() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return inRead == inLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.784 -0400", hash_original_method = "0513FF2BBDC9BF2AA8F8AFEEBE87C2FB", hash_generated_method = "9138E4362FA0CE03C0B84709CEB65B62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.785 -0400", hash_original_method = "D92307F0039AB335BB1BCA1E70FBBC75", hash_generated_method = "73B15643397824AB64E6F0FDE50D65BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void resetImpl(long handle) {
        dsTaint.addTaint(handle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.787 -0400", hash_original_method = "49DAD22714BA16C1AC9D80CF714D4798", hash_generated_method = "24AB90735223A617A314A4D25EC06A12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setDictionary(byte[] dictionary) {
        dsTaint.addTaint(dictionary[0]);
        setDictionary(dictionary, 0, dictionary.length);
        // ---------- Original Method ----------
        //setDictionary(dictionary, 0, dictionary.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.789 -0400", hash_original_method = "568AFB946554DE560CCB8443B419A0F6", hash_generated_method = "E4F9A8D32DE646529600FA16691A2572")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setDictionary(byte[] dictionary, int offset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(dictionary[0]);
        dsTaint.addTaint(offset);
        checkOpen();
        Arrays.checkOffsetAndCount(dictionary.length, offset, byteCount);
        setDictionaryImpl(dictionary, offset, byteCount, streamHandle);
        // ---------- Original Method ----------
        //checkOpen();
        //Arrays.checkOffsetAndCount(dictionary.length, offset, byteCount);
        //setDictionaryImpl(dictionary, offset, byteCount, streamHandle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.790 -0400", hash_original_method = "3A877A890ED74FC0EF087E03CFE5648B", hash_generated_method = "1A097F6A0FB6ABE86838197C5EAEBC75")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setDictionaryImpl(byte[] dictionary, int offset, int byteCount, long handle) {
        dsTaint.addTaint(handle);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(dictionary[0]);
        dsTaint.addTaint(offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.798 -0400", hash_original_method = "76E6701B8618856CEE42A14EB071C689", hash_generated_method = "DA5020B0A418B3752B282EF35EAC4071")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setInput(byte[] buf) {
        dsTaint.addTaint(buf[0]);
        setInput(buf, 0, buf.length);
        // ---------- Original Method ----------
        //setInput(buf, 0, buf.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.804 -0400", hash_original_method = "D18140A9F42CF395349CBB05A8109835", hash_generated_method = "3DEC260048DF3F9757143C1B0A6301E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void setInput(byte[] buf, int offset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(buf[0]);
        checkOpen();
        Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        inRead = 0;
        setInputImpl(buf, offset, byteCount, streamHandle);
        // ---------- Original Method ----------
        //checkOpen();
        //Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        //inRead = 0;
        //inLength = byteCount;
        //setInputImpl(buf, offset, byteCount, streamHandle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.804 -0400", hash_original_method = "CFB5087A7D9EFE706B98C4EB08838FDC", hash_generated_method = "B928F4A9223A597711DB1784A903921E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setInputImpl(byte[] buf, int offset, int byteCount, long handle) {
        dsTaint.addTaint(handle);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(buf[0]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.805 -0400", hash_original_method = "AC4A3418B937D51D6E31ACAFC1E07B42", hash_generated_method = "A50BB1E8C83210C349049A2181E2CC00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized int setFileInput(FileDescriptor fd, long offset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(fd.dsTaint);
        checkOpen();
        inRead = 0;
        inLength = setFileInputImpl(fd, offset, byteCount, streamHandle);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkOpen();
        //inRead = 0;
        //inLength = setFileInputImpl(fd, offset, byteCount, streamHandle);
        //return inLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.805 -0400", hash_original_method = "E3E6A66CB79BDD3B7E592B29E67DC77B", hash_generated_method = "5437ADF7EFA962BD4A7DFA89CE9DB75A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int setFileInputImpl(FileDescriptor fd, long offset, int byteCount, long handle) {
        dsTaint.addTaint(handle);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(fd.dsTaint);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.806 -0400", hash_original_method = "477FE56B6846A3E6E3ED71C242A2D9F4", hash_generated_method = "AF3A8A7419C815DC828233CF022989F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

