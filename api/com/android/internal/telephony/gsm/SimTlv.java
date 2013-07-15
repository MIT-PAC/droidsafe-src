package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class SimTlv {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.647 -0400", hash_original_field = "3D5BD4084DB83091C19B38CDE3CD87DC", hash_generated_field = "86A3D06170A107D6E7EB13AB011FB99A")

    byte record[];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.647 -0400", hash_original_field = "E2B4151B50688473F71AFE1FB755AD75", hash_generated_field = "D147F0D478C2342F201DCEE95A03F836")

    int tlvOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.647 -0400", hash_original_field = "A9710895280944E1DE08D91C952E4E70", hash_generated_field = "82FDB9F34711313F943D487A032AA8D8")

    int tlvLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.647 -0400", hash_original_field = "09BAA70832EF6D58FE97F2F73D8741AC", hash_generated_field = "E50E239246ADC4865FC274DA29EA5932")

    int curOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.647 -0400", hash_original_field = "C748D037279E844CDFEB298FB0BB0999", hash_generated_field = "6695F7C9D6FCE76D260D6C9AD1A93C05")

    int curDataOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.647 -0400", hash_original_field = "31CD9271850BA1C91C69B4C3D7280CB4", hash_generated_field = "823C0C869A766E421635006E39577408")

    int curDataLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.647 -0400", hash_original_field = "D91501AE627873BC4A3030BD7AD0D179", hash_generated_field = "F39BF030C5DE9481BD5AE1757D50CE0A")

    boolean hasValidTlvObject;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.648 -0400", hash_original_method = "09DDFD30343833E55BD01CFD3EB31B7F", hash_generated_method = "47A157035D4E147914ED7DBCABB4C887")
    public  SimTlv(byte[] record, int offset, int length) {
        this.record = record;
        this.tlvOffset = offset;
        this.tlvLength = length;
        curOffset = offset;
        hasValidTlvObject = parseCurrentTlvObject();
        // ---------- Original Method ----------
        //this.record = record;
        //this.tlvOffset = offset;
        //this.tlvLength = length;
        //curOffset = offset;
        //hasValidTlvObject = parseCurrentTlvObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.649 -0400", hash_original_method = "E4941B82FB2B1D8A93B786E30A0BC739", hash_generated_method = "A37B0429F9D4E524C1A9996F4E0BFA29")
    public boolean nextObject() {
    if(!hasValidTlvObject)        
        {
        boolean var68934A3E9455FA72420237EB05902327_516405925 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1439986571 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1439986571;
        }
        curOffset = curDataOffset + curDataLength;
        hasValidTlvObject = parseCurrentTlvObject();
        boolean varD91501AE627873BC4A3030BD7AD0D179_545985968 = (hasValidTlvObject);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_715139979 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_715139979;
        // ---------- Original Method ----------
        //if (!hasValidTlvObject) return false;
        //curOffset = curDataOffset + curDataLength;
        //hasValidTlvObject = parseCurrentTlvObject();
        //return hasValidTlvObject;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.649 -0400", hash_original_method = "6E8A16A8DAAB3D52539EED38524C3D56", hash_generated_method = "CFEB0194BE8D4DE1D2AC852610DC2567")
    public boolean isValidObject() {
        boolean varD91501AE627873BC4A3030BD7AD0D179_1812187988 = (hasValidTlvObject);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1296309727 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1296309727;
        // ---------- Original Method ----------
        //return hasValidTlvObject;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.649 -0400", hash_original_method = "6A87500957D7F16920BD9A3282060AAA", hash_generated_method = "DFBBAE40261C4385BF271B6317BC8BB9")
    public int getTag() {
    if(!hasValidTlvObject)        
        {
        int varCFCD208495D565EF66E7DFF9F98764DA_1343612589 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1890543556 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1890543556;
        }
        int varD79CED434C53030CA3BD0EDB662DECAA_812693474 = (record[curOffset] & 0xff);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1997117439 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1997117439;
        // ---------- Original Method ----------
        //if (!hasValidTlvObject) return 0;
        //return record[curOffset] & 0xff;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.650 -0400", hash_original_method = "0617D6165A26B8CE55A8A8181EBF929A", hash_generated_method = "D541605DAF5FA3E8FD3AE26317B04E7A")
    public byte[] getData() {
    if(!hasValidTlvObject)        
        {
        byte[] var37A6259CC0C1DAE299A7866489DFF0BD_731699812 = (null);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_609953022 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_609953022;
        }
        byte[] ret = new byte[curDataLength];
        System.arraycopy(record, curDataOffset, ret, 0, curDataLength);
        byte[] var2CB9DF9898E55FD0AD829DC202DDBD1C_1920875471 = (ret);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2069067887 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2069067887;
        // ---------- Original Method ----------
        //if (!hasValidTlvObject) return null;
        //byte[] ret = new byte[curDataLength];
        //System.arraycopy(record, curDataOffset, ret, 0, curDataLength);
        //return ret;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:28.651 -0400", hash_original_method = "F0FED94C714DCB7A0D654E5FF6165803", hash_generated_method = "185F735666EC66585FA2801ADAE05C43")
    private boolean parseCurrentTlvObject() {
        try 
        {
    if(record[curOffset] == 0 || (record[curOffset] & 0xff) == 0xff)            
            {
                boolean var68934A3E9455FA72420237EB05902327_282312399 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1083046292 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1083046292;
            } //End block
    if((record[curOffset + 1] & 0xff) < 0x80)            
            {
                curDataLength = record[curOffset + 1] & 0xff;
                curDataOffset = curOffset + 2;
            } //End block
            else
    if((record[curOffset + 1] & 0xff) == 0x81)            
            {
                curDataLength = record[curOffset + 2] & 0xff;
                curDataOffset = curOffset + 3;
            } //End block
            else
            {
                boolean var68934A3E9455FA72420237EB05902327_1259736935 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_59523449 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_59523449;
            } //End block
        } //End block
        catch (ArrayIndexOutOfBoundsException ex)
        {
            boolean var68934A3E9455FA72420237EB05902327_1285066174 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1397473701 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1397473701;
        } //End block
    if(curDataLength + curDataOffset > tlvOffset + tlvLength)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1761335376 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_401993407 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_401993407;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_151698927 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1871155193 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1871155193;
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

