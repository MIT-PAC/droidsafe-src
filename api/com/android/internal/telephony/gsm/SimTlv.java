package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class SimTlv {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.670 -0400", hash_original_field = "3D5BD4084DB83091C19B38CDE3CD87DC", hash_generated_field = "86A3D06170A107D6E7EB13AB011FB99A")

    byte record[];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.670 -0400", hash_original_field = "E2B4151B50688473F71AFE1FB755AD75", hash_generated_field = "D147F0D478C2342F201DCEE95A03F836")

    int tlvOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.670 -0400", hash_original_field = "A9710895280944E1DE08D91C952E4E70", hash_generated_field = "82FDB9F34711313F943D487A032AA8D8")

    int tlvLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.670 -0400", hash_original_field = "09BAA70832EF6D58FE97F2F73D8741AC", hash_generated_field = "E50E239246ADC4865FC274DA29EA5932")

    int curOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.670 -0400", hash_original_field = "C748D037279E844CDFEB298FB0BB0999", hash_generated_field = "6695F7C9D6FCE76D260D6C9AD1A93C05")

    int curDataOffset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.670 -0400", hash_original_field = "31CD9271850BA1C91C69B4C3D7280CB4", hash_generated_field = "823C0C869A766E421635006E39577408")

    int curDataLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.670 -0400", hash_original_field = "D91501AE627873BC4A3030BD7AD0D179", hash_generated_field = "F39BF030C5DE9481BD5AE1757D50CE0A")

    boolean hasValidTlvObject;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.671 -0400", hash_original_method = "09DDFD30343833E55BD01CFD3EB31B7F", hash_generated_method = "47A157035D4E147914ED7DBCABB4C887")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.672 -0400", hash_original_method = "E4941B82FB2B1D8A93B786E30A0BC739", hash_generated_method = "BCC1DFBD26AE452A48C12318457CCF7A")
    public boolean nextObject() {
        if(!hasValidTlvObject)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1628018686 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1556420774 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1556420774;
        }
        curOffset = curDataOffset + curDataLength;
        hasValidTlvObject = parseCurrentTlvObject();
        boolean varD91501AE627873BC4A3030BD7AD0D179_975122290 = (hasValidTlvObject);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_946028590 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_946028590;
        // ---------- Original Method ----------
        //if (!hasValidTlvObject) return false;
        //curOffset = curDataOffset + curDataLength;
        //hasValidTlvObject = parseCurrentTlvObject();
        //return hasValidTlvObject;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.672 -0400", hash_original_method = "6E8A16A8DAAB3D52539EED38524C3D56", hash_generated_method = "BE1DEC992C269CA84D615823436E3B44")
    public boolean isValidObject() {
        boolean varD91501AE627873BC4A3030BD7AD0D179_296385010 = (hasValidTlvObject);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_829977862 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_829977862;
        // ---------- Original Method ----------
        //return hasValidTlvObject;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.673 -0400", hash_original_method = "6A87500957D7F16920BD9A3282060AAA", hash_generated_method = "D9EA23D923730A10740E88D649B69AD4")
    public int getTag() {
        if(!hasValidTlvObject)        
        {
        int varCFCD208495D565EF66E7DFF9F98764DA_651511562 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1833276124 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1833276124;
        }
        int varD79CED434C53030CA3BD0EDB662DECAA_1105275211 = (record[curOffset] & 0xff);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_137967057 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_137967057;
        // ---------- Original Method ----------
        //if (!hasValidTlvObject) return 0;
        //return record[curOffset] & 0xff;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.673 -0400", hash_original_method = "0617D6165A26B8CE55A8A8181EBF929A", hash_generated_method = "B7CB16615620C6F24146E0CC3926B807")
    public byte[] getData() {
        if(!hasValidTlvObject)        
        {
        byte[] var37A6259CC0C1DAE299A7866489DFF0BD_473366533 = (null);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1201541759 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1201541759;
        }
        byte[] ret = new byte[curDataLength];
        System.arraycopy(record, curDataOffset, ret, 0, curDataLength);
        byte[] var2CB9DF9898E55FD0AD829DC202DDBD1C_5541138 = (ret);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1098452346 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1098452346;
        // ---------- Original Method ----------
        //if (!hasValidTlvObject) return null;
        //byte[] ret = new byte[curDataLength];
        //System.arraycopy(record, curDataOffset, ret, 0, curDataLength);
        //return ret;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.675 -0400", hash_original_method = "F0FED94C714DCB7A0D654E5FF6165803", hash_generated_method = "4AF8B6E2A53F314D9CFFA4833A27969E")
    private boolean parseCurrentTlvObject() {
        try 
        {
            if(record[curOffset] == 0 || (record[curOffset] & 0xff) == 0xff)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1900336079 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_101774999 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_101774999;
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
                boolean var68934A3E9455FA72420237EB05902327_2027336008 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_842081966 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_842081966;
            } //End block
        } //End block
        catch (ArrayIndexOutOfBoundsException ex)
        {
            boolean var68934A3E9455FA72420237EB05902327_1497186482 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_26399937 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_26399937;
        } //End block
        if(curDataLength + curDataOffset > tlvOffset + tlvLength)        
        {
            boolean var68934A3E9455FA72420237EB05902327_627651571 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1619729558 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1619729558;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_951904890 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1629851307 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1629851307;
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

