package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;




public class BERApplicationSpecificParser implements ASN1ApplicationSpecificParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.906 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "3577E5E669CAE3960DB734B50E9992AB")

    private int tag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.906 -0400", hash_original_field = "3643B86326B2FFCC0A085B4DD3A4309B", hash_generated_field = "BDA992D1A9789DCE4BA9542117A08206")

    private ASN1StreamParser parser;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.907 -0400", hash_original_method = "E0609A70F39E6E6F4E13B827D68F5B4C", hash_generated_method = "1CDD23288A33C70CA68843FF735DD782")
      BERApplicationSpecificParser(int tag, ASN1StreamParser parser) {
        this.tag = tag;
        this.parser = parser;
        // ---------- Original Method ----------
        //this.tag = tag;
        //this.parser = parser;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.908 -0400", hash_original_method = "FC19FBA5450B1E3458DF66BAD498F5C7", hash_generated_method = "44BE4CC0A7DE22EC96AFE206026D3BCD")
    public DEREncodable readObject() throws IOException {
DEREncodable var09F4702C04B163043983FE2F5378920C_988842123 =         parser.readObject();
        var09F4702C04B163043983FE2F5378920C_988842123.addTaint(taint);
        return var09F4702C04B163043983FE2F5378920C_988842123;
        // ---------- Original Method ----------
        //return parser.readObject();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.908 -0400", hash_original_method = "B2A8CB4DD75EA6F990011FAB1A0E301F", hash_generated_method = "8766793ED3D5D71BD05548C737BE0CC1")
    public DERObject getLoadedObject() throws IOException {
DERObject var49C379AB737313FF79147B13CD4AA097_648277679 =         new BERApplicationSpecific(tag, parser.readVector());
        var49C379AB737313FF79147B13CD4AA097_648277679.addTaint(taint);
        return var49C379AB737313FF79147B13CD4AA097_648277679;
        // ---------- Original Method ----------
        //return new BERApplicationSpecific(tag, parser.readVector());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.909 -0400", hash_original_method = "C25B7E6814F316F8AC8F55D830DF862A", hash_generated_method = "DA3E7B6F468DB5F43FA6B7650BDE03AD")
    public DERObject getDERObject() {
        try 
        {
DERObject var7CA8C38BF885E63AD9395CA9CA98D912_1539224900 =             getLoadedObject();
            var7CA8C38BF885E63AD9395CA9CA98D912_1539224900.addTaint(taint);
            return var7CA8C38BF885E63AD9395CA9CA98D912_1539224900;
        } //End block
        catch (IOException e)
        {
            ASN1ParsingException var2B5ADF01A3F8BD267A883C161A3838C1_1806115039 = new ASN1ParsingException(e.getMessage(), e);
            var2B5ADF01A3F8BD267A883C161A3838C1_1806115039.addTaint(taint);
            throw var2B5ADF01A3F8BD267A883C161A3838C1_1806115039;
        } //End block
        // ---------- Original Method ----------
        //try
        //{
            //return getLoadedObject();
        //}
        //catch (IOException e)
        //{
            //throw new ASN1ParsingException(e.getMessage(), e);
        //}
    }

    
}

