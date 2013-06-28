package java.util.zip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public class Adler32 implements Checksum {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.700 -0400", hash_original_field = "E0E02EB46E5C1345AA3D787548501D80", hash_generated_field = "340637C3F9F3E2C0581BDB7710DDE74A")

    private long adler = 1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.700 -0400", hash_original_method = "44A37FF32832D6270D5CA824FAC1DB11", hash_generated_method = "44A37FF32832D6270D5CA824FAC1DB11")
    public Adler32 ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.702 -0400", hash_original_method = "7548992455680731B7C95F9AA9AA74C4", hash_generated_method = "9EA2E79104AF3C4DFB1E3E3B7C851593")
    public long getValue() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_306479454 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_306479454;
        // ---------- Original Method ----------
        //return adler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.703 -0400", hash_original_method = "1433914DD19ED8527D865BA07D38D783", hash_generated_method = "A833C721B36C9DD33845C86043BAF555")
    public void reset() {
        adler = 1;
        // ---------- Original Method ----------
        //adler = 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.703 -0400", hash_original_method = "031B66345AD9B4CB1EA8EFF22DB8DC3B", hash_generated_method = "342DD84DCAF0223E8E3E5B65B71564AD")
    public void update(int i) {
        adler = updateByteImpl(i, adler);
        // ---------- Original Method ----------
        //adler = updateByteImpl(i, adler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.703 -0400", hash_original_method = "CE6B29801A6FECCB312673EE525F73B5", hash_generated_method = "13C689D50A12C9C127D21D737DB67415")
    public void update(byte[] buf) {
        update(buf, 0, buf.length);
        addTaint(buf[0]);
        // ---------- Original Method ----------
        //update(buf, 0, buf.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.704 -0400", hash_original_method = "33C110C69CF248DAE45848AD232AAEEC", hash_generated_method = "AEDBCB2904C45ED2AEF4CC71D178612E")
    public void update(byte[] buf, int offset, int byteCount) {
        Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        adler = updateImpl(buf, offset, byteCount, adler);
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        //adler = updateImpl(buf, offset, byteCount, adler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.704 -0400", hash_original_method = "26D22C50972EAA3B6C38F09F454AF8CC", hash_generated_method = "249A985ACB6DCBF87342501D010A0A77")
    private long updateImpl(byte[] buf, int offset, int byteCount, long adler1) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_133518606 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_133518606;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.704 -0400", hash_original_method = "259D32F9E4CE523F9078FA0D9CF43194", hash_generated_method = "585DE88476A68071905588163709590C")
    private long updateByteImpl(int val, long adler1) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1449465643 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1449465643;
    }

    
}

