package java.util.zip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;

public class CRC32 implements Checksum {
    private long crc = 0L;
    long tbytes = 0L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.679 -0400", hash_original_method = "3DAAB1A82287A731049DDEFF7BCD59B5", hash_generated_method = "3DAAB1A82287A731049DDEFF7BCD59B5")
        public CRC32 ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.679 -0400", hash_original_method = "854FE5E27AD17353F420BE5FB492E27A", hash_generated_method = "26EEEA2D01FB84350BB03A2965A9D248")
    @DSModeled(DSC.SAFE)
    public long getValue() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return crc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.679 -0400", hash_original_method = "3C94069B7580B83ACAD9A7049BA1E3DA", hash_generated_method = "1BE2E86E9BDD5C182F7FDC8F08658625")
    @DSModeled(DSC.SAFE)
    public void reset() {
        tbytes = crc = 0;
        // ---------- Original Method ----------
        //tbytes = crc = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.679 -0400", hash_original_method = "CC03AC9F84902D02E7C98FF0D9B3A071", hash_generated_method = "5D9D507D2129D68B89836E683DC40352")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void update(int val) {
        dsTaint.addTaint(val);
        crc = updateByteImpl((byte) val, crc);
        // ---------- Original Method ----------
        //crc = updateByteImpl((byte) val, crc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.680 -0400", hash_original_method = "CE6B29801A6FECCB312673EE525F73B5", hash_generated_method = "677F3A4BECD4382C5249F9361F8143A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void update(byte[] buf) {
        dsTaint.addTaint(buf[0]);
        update(buf, 0, buf.length);
        // ---------- Original Method ----------
        //update(buf, 0, buf.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.680 -0400", hash_original_method = "FA32CF22527C3BE95E419FDEDA807F82", hash_generated_method = "40E1E819CEF88A09D5B5EE70FD8CFF84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void update(byte[] buf, int offset, int byteCount) {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(buf[0]);
        Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        crc = updateImpl(buf, offset, byteCount, crc);
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
        //tbytes += byteCount;
        //crc = updateImpl(buf, offset, byteCount, crc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.680 -0400", hash_original_method = "680551833B0F700FD9FEA4D72A9561BF", hash_generated_method = "7C91D80F9FF2A1B3CC1523059999CDDC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private long updateImpl(byte[] buf, int offset, int byteCount, long crc1) {
        dsTaint.addTaint(crc1);
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(buf[0]);
        return dsTaint.getTaintLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.680 -0400", hash_original_method = "90348FBF3DF8B04612B506AE017DBA82", hash_generated_method = "84A0739C8B5A70B0340A99F09CD67908")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private long updateByteImpl(byte val, long crc1) {
        dsTaint.addTaint(val);
        dsTaint.addTaint(crc1);
        return dsTaint.getTaintLong();
    }

    
}

