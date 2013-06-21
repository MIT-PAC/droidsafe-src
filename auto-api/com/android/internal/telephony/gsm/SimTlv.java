package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class SimTlv {
    byte record[];
    int tlvOffset;
    int tlvLength;
    int curOffset;
    int curDataOffset;
    int curDataLength;
    boolean hasValidTlvObject;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.874 -0400", hash_original_method = "09DDFD30343833E55BD01CFD3EB31B7F", hash_generated_method = "51DB2F340E8BD2A2330163FD45469627")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SimTlv(byte[] record, int offset, int length) {
        dsTaint.addTaint(record[0]);
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        this.record = record;
        hasValidTlvObject = parseCurrentTlvObject();
        // ---------- Original Method ----------
        //this.record = record;
        //this.tlvOffset = offset;
        //this.tlvLength = length;
        //curOffset = offset;
        //hasValidTlvObject = parseCurrentTlvObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.874 -0400", hash_original_method = "E4941B82FB2B1D8A93B786E30A0BC739", hash_generated_method = "19CD6F4D30A4EFA2A13ED5CDFB3D6217")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean nextObject() {
        curOffset = curDataOffset + curDataLength;
        hasValidTlvObject = parseCurrentTlvObject();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!hasValidTlvObject) return false;
        //curOffset = curDataOffset + curDataLength;
        //hasValidTlvObject = parseCurrentTlvObject();
        //return hasValidTlvObject;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.875 -0400", hash_original_method = "6E8A16A8DAAB3D52539EED38524C3D56", hash_generated_method = "B58F5727915EAD91D2D7F36134ABFE5C")
    @DSModeled(DSC.SAFE)
    public boolean isValidObject() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return hasValidTlvObject;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.875 -0400", hash_original_method = "6A87500957D7F16920BD9A3282060AAA", hash_generated_method = "E896496C66D385082F9EA1EA881CAEEC")
    @DSModeled(DSC.SAFE)
    public int getTag() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (!hasValidTlvObject) return 0;
        //return record[curOffset] & 0xff;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.875 -0400", hash_original_method = "0617D6165A26B8CE55A8A8181EBF929A", hash_generated_method = "A3434FE06CFA873E53958E0CD2EF2372")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getData() {
        byte[] ret;
        ret = new byte[curDataLength];
        System.arraycopy(record, curDataOffset, ret, 0, curDataLength);
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (!hasValidTlvObject) return null;
        //byte[] ret = new byte[curDataLength];
        //System.arraycopy(record, curDataOffset, ret, 0, curDataLength);
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.875 -0400", hash_original_method = "F0FED94C714DCB7A0D654E5FF6165803", hash_generated_method = "334BE343573CFE8318D2C5D89906986D")
    @DSModeled(DSC.SAFE)
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
        return dsTaint.getTaintBoolean();
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

