package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public final class ASN1Any extends ASN1Type {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.159 -0400", hash_original_method = "DC9940F4B091FD322F1F3A80DE5DA9F7", hash_generated_method = "4BC9F36E0DA8D5C47FBAC49DEA0BD42A")
    public  ASN1Any() {
        super(TAG_ANY);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public static ASN1Any getInstance() {
        return ASN1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.159 -0400", hash_original_method = "0A9787140DA63C802B73071FD0FF80EC", hash_generated_method = "213EB9AE69913113877FA2808F8B687C")
    public final boolean checkTag(int identifier) {
        addTaint(identifier);
        boolean varB326B5062B2F0E69046810717534CB09_1434399458 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_126304386 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_126304386;
        // ---------- Original Method ----------
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.160 -0400", hash_original_method = "F8B6556748DA568C4BCDCD3BC4853721", hash_generated_method = "188C5495DD5D5D09EABE55F0A8B5AA39")
    public Object decode(BerInputStream in) throws IOException {
        addTaint(in.getTaint());
        in.readContent();
        if(in.isVerify)        
        {
Object var540C13E9E156B687226421B24F2DF178_1973267755 =             null;
            var540C13E9E156B687226421B24F2DF178_1973267755.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1973267755;
        } //End block
Object var6AD043AF0280111F31D0D60A6CD70863_1431694785 =         getDecodedObject(in);
        var6AD043AF0280111F31D0D60A6CD70863_1431694785.addTaint(taint);
        return var6AD043AF0280111F31D0D60A6CD70863_1431694785;
        // ---------- Original Method ----------
        //in.readContent();
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.160 -0400", hash_original_method = "7A8EAE0B0D15C25D8FE798817C72F0C1", hash_generated_method = "2FC4AEE65EF83D8E34249D853F20E23A")
    public Object getDecodedObject(BerInputStream in) throws IOException {
        addTaint(in.getTaint());
        byte[] bytesEncoded = new byte[in.offset - in.tagOffset];
        System.arraycopy(in.buffer, in.tagOffset, bytesEncoded, 0,
                bytesEncoded.length);
Object varE123E70E73254F8B84526419D168A7C8_1669735155 =         bytesEncoded;
        varE123E70E73254F8B84526419D168A7C8_1669735155.addTaint(taint);
        return varE123E70E73254F8B84526419D168A7C8_1669735155;
        // ---------- Original Method ----------
        //byte[] bytesEncoded = new byte[in.offset - in.tagOffset];
        //System.arraycopy(in.buffer, in.tagOffset, bytesEncoded, 0,
                //bytesEncoded.length);
        //return bytesEncoded;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.160 -0400", hash_original_method = "7511C9B0E36E939B1775FC9EA0F02F20", hash_generated_method = "7AA877D0BC5E134FD6F8182E63D2D768")
    public void encodeASN(BerOutputStream out) {
        addTaint(out.getTaint());
        out.encodeANY();
        // ---------- Original Method ----------
        //out.encodeANY();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.160 -0400", hash_original_method = "E4481BCA62553D7934DD52F370937ED4", hash_generated_method = "F15B1202ECDA9F7A7EF12645667039EF")
    public void encodeContent(BerOutputStream out) {
        addTaint(out.getTaint());
        out.encodeANY();
        // ---------- Original Method ----------
        //out.encodeANY();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.161 -0400", hash_original_method = "9FE1E04620BBFE07A0C8F71EADD10582", hash_generated_method = "CF6C0D89125D265A070FAEF45137B38D")
    public void setEncodingContent(BerOutputStream out) {
        addTaint(out.getTaint());
        out.length = ((byte[]) out.content).length;
        // ---------- Original Method ----------
        //out.length = ((byte[]) out.content).length;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.161 -0400", hash_original_method = "4E35D9A00930BDC0DD7D3944E7329986", hash_generated_method = "CBE5DAA8DAB0A80124611CCA5B5136E8")
    public int getEncodedLength(BerOutputStream out) {
        addTaint(out.getTaint());
        int var495E17F7A475D066F64F81410EECEEB8_1705566015 = (out.length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_816577687 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_816577687;
        // ---------- Original Method ----------
        //return out.length;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.161 -0400", hash_original_field = "0236CB100B50FFA118DD93153CCD6AB1", hash_generated_field = "C58706DC2D33CE9466BC907D05FF43CF")

    private static final ASN1Any ASN1 = new ASN1Any();
}

