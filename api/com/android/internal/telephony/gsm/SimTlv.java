package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class SimTlv {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.828 -0500", hash_original_field = "86A3D06170A107D6E7EB13AB011FB99A", hash_generated_field = "86A3D06170A107D6E7EB13AB011FB99A")


    byte record[];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.830 -0500", hash_original_field = "D147F0D478C2342F201DCEE95A03F836", hash_generated_field = "D147F0D478C2342F201DCEE95A03F836")

    int tlvOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.832 -0500", hash_original_field = "82FDB9F34711313F943D487A032AA8D8", hash_generated_field = "82FDB9F34711313F943D487A032AA8D8")

    int tlvLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.834 -0500", hash_original_field = "E50E239246ADC4865FC274DA29EA5932", hash_generated_field = "E50E239246ADC4865FC274DA29EA5932")

    int curOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.836 -0500", hash_original_field = "6695F7C9D6FCE76D260D6C9AD1A93C05", hash_generated_field = "6695F7C9D6FCE76D260D6C9AD1A93C05")

    int curDataOffset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.838 -0500", hash_original_field = "823C0C869A766E421635006E39577408", hash_generated_field = "823C0C869A766E421635006E39577408")

    int curDataLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.840 -0500", hash_original_field = "F39BF030C5DE9481BD5AE1757D50CE0A", hash_generated_field = "F39BF030C5DE9481BD5AE1757D50CE0A")

    boolean hasValidTlvObject;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.843 -0500", hash_original_method = "09DDFD30343833E55BD01CFD3EB31B7F", hash_generated_method = "83B2AB36439D293AD02B628975E225F3")
    
public SimTlv(byte[] record, int offset, int length) {
        this.record = record;

        this.tlvOffset = offset;
        this.tlvLength = length;
        curOffset = offset;

        hasValidTlvObject = parseCurrentTlvObject();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.845 -0500", hash_original_method = "E4941B82FB2B1D8A93B786E30A0BC739", hash_generated_method = "2DCE90955577C8715ACD7920C4A4FE4E")
    
public boolean nextObject() {
        if (!hasValidTlvObject) return false;
        curOffset = curDataOffset + curDataLength;
        hasValidTlvObject = parseCurrentTlvObject();
        return hasValidTlvObject;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.848 -0500", hash_original_method = "6E8A16A8DAAB3D52539EED38524C3D56", hash_generated_method = "C34B63EC86D3AC922B62FDE4A3223514")
    
public boolean isValidObject() {
        return hasValidTlvObject;
    }

    /**
     * Returns the tag for the current TLV object
     * Return 0 if !isValidObject()
     * 0 and 0xff are invalid tag values
     * valid tags range from 1 - 0xfe
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.850 -0500", hash_original_method = "6A87500957D7F16920BD9A3282060AAA", hash_generated_method = "73856AB5111A8AF2E54409EBBA60D4D7")
    
public int getTag() {
        if (!hasValidTlvObject) return 0;
        return record[curOffset] & 0xff;
    }

    /**
     * Returns data associated with current TLV object
     * returns null if !isValidObject()
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.853 -0500", hash_original_method = "0617D6165A26B8CE55A8A8181EBF929A", hash_generated_method = "CE2F089CF59F88F6A9421DF63DB16F20")
    
public byte[] getData() {
        if (!hasValidTlvObject) return null;

        byte[] ret = new byte[curDataLength];
        System.arraycopy(record, curDataOffset, ret, 0, curDataLength);
        return ret;
    }

    /**
     * Updates curDataLength and curDataOffset
     * @return false on invalid record, true on valid record
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:29.855 -0500", hash_original_method = "F0FED94C714DCB7A0D654E5FF6165803", hash_generated_method = "DC16AC6C2BF1FCD472133390104DC745")
    
private boolean parseCurrentTlvObject() {
        // 0x00 and 0xff are invalid tag values

        try {
            if (record[curOffset] == 0 || (record[curOffset] & 0xff) == 0xff) {
                return false;
            }

            if ((record[curOffset + 1] & 0xff) < 0x80) {
                // one byte length 0 - 0x7f
                curDataLength = record[curOffset + 1] & 0xff;
                curDataOffset = curOffset + 2;
            } else if ((record[curOffset + 1] & 0xff) == 0x81) {
                // two byte length 0x80 - 0xff
                curDataLength = record[curOffset + 2] & 0xff;
                curDataOffset = curOffset + 3;
            } else {
                return false;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            return false;
        }

        if (curDataLength + curDataOffset > tlvOffset + tlvLength) {
            return false;
        }

        return true;
    }

    
}

