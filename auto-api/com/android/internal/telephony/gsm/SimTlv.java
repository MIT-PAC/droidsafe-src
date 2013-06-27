package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SimTlv {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.820 -0400", hash_original_field = "3D5BD4084DB83091C19B38CDE3CD87DC", hash_generated_field = "86A3D06170A107D6E7EB13AB011FB99A")

    byte record[];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.820 -0400", hash_original_field = "E2B4151B50688473F71AFE1FB755AD75", hash_generated_field = "D147F0D478C2342F201DCEE95A03F836")

    int tlvOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.820 -0400", hash_original_field = "A9710895280944E1DE08D91C952E4E70", hash_generated_field = "82FDB9F34711313F943D487A032AA8D8")

    int tlvLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.820 -0400", hash_original_field = "09BAA70832EF6D58FE97F2F73D8741AC", hash_generated_field = "E50E239246ADC4865FC274DA29EA5932")

    int curOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.821 -0400", hash_original_field = "C748D037279E844CDFEB298FB0BB0999", hash_generated_field = "6695F7C9D6FCE76D260D6C9AD1A93C05")

    int curDataOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.821 -0400", hash_original_field = "31CD9271850BA1C91C69B4C3D7280CB4", hash_generated_field = "823C0C869A766E421635006E39577408")

    int curDataLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.821 -0400", hash_original_field = "D91501AE627873BC4A3030BD7AD0D179", hash_generated_field = "F39BF030C5DE9481BD5AE1757D50CE0A")

    boolean hasValidTlvObject;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.830 -0400", hash_original_method = "09DDFD30343833E55BD01CFD3EB31B7F", hash_generated_method = "4A99F64C77ADCF7148B2AD1312C8C856")
    public  SimTlv(byte[] record, int offset, int length) {
        this.record = record;
        this.tlvOffset = offset;
        this.tlvLength = length;
        curOffset = offset;
        hasValidTlvObject = parseCurrentTlvObject();
        addTaint(record[0]);
        // ---------- Original Method ----------
        //this.record = record;
        //this.tlvOffset = offset;
        //this.tlvLength = length;
        //curOffset = offset;
        //hasValidTlvObject = parseCurrentTlvObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.831 -0400", hash_original_method = "E4941B82FB2B1D8A93B786E30A0BC739", hash_generated_method = "71B478A42B8B30E01709D8B02355CCD1")
    public boolean nextObject() {
        curOffset = curDataOffset + curDataLength;
        hasValidTlvObject = parseCurrentTlvObject();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_170205594 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_170205594;
        // ---------- Original Method ----------
        //if (!hasValidTlvObject) return false;
        //curOffset = curDataOffset + curDataLength;
        //hasValidTlvObject = parseCurrentTlvObject();
        //return hasValidTlvObject;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.831 -0400", hash_original_method = "6E8A16A8DAAB3D52539EED38524C3D56", hash_generated_method = "580031B2538EF2A96291C00FA5D27DC5")
    public boolean isValidObject() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1524285779 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1524285779;
        // ---------- Original Method ----------
        //return hasValidTlvObject;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.836 -0400", hash_original_method = "6A87500957D7F16920BD9A3282060AAA", hash_generated_method = "5BB94EBD4312B99D13A770AA5266FB93")
    public int getTag() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_637491224 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_637491224;
        // ---------- Original Method ----------
        //if (!hasValidTlvObject) return 0;
        //return record[curOffset] & 0xff;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.837 -0400", hash_original_method = "0617D6165A26B8CE55A8A8181EBF929A", hash_generated_method = "7977039C10B348DEFECF2F5C30A1B908")
    public byte[] getData() {
        byte[] ret;
        ret = new byte[curDataLength];
        System.arraycopy(record, curDataOffset, ret, 0, curDataLength);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_57525923 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_57525923;
        // ---------- Original Method ----------
        //if (!hasValidTlvObject) return null;
        //byte[] ret = new byte[curDataLength];
        //System.arraycopy(record, curDataOffset, ret, 0, curDataLength);
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.838 -0400", hash_original_method = "F0FED94C714DCB7A0D654E5FF6165803", hash_generated_method = "A91A40DA988FD349CEFDE2A26945585F")
    private boolean parseCurrentTlvObject() {
        try 
        {
            {
                curDataLength = record[curOffset + 1] & 0xff;
                curDataOffset = curOffset + 2;
            } //End block
            {
                curDataLength = record[curOffset + 2] & 0xff;
                curDataOffset = curOffset + 3;
            } //End block
        } //End block
        catch (ArrayIndexOutOfBoundsException ex)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1416182439 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1416182439;
        // ---------- Original Method ----------
        //try {
            //if (record[curOffset] == 0 || (record[curOffset] & 0xff) == 0xff) {
                //return false;
            //}
            //if ((record[curOffset + 1] & 0xff) < 0x80) {
                //curDataLength = record[curOffset + 1] & 0xff;
                //curDataOffset = curOffset + 2;
            //} else if ((record[curOffset + 1] & 0xff) == 0x81) {
                //curDataLength = record[curOffset + 2] & 0xff;
                //curDataOffset = curOffset + 3;
            //} else {
                //return false;
            //}
        //} catch (ArrayIndexOutOfBoundsException ex) {
            //return false;
        //}
        //if (curDataLength + curDataOffset > tlvOffset + tlvLength) {
            //return false;
        //}
        //return true;
    }

    
}

