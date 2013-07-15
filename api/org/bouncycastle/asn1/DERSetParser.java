package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public class DERSetParser implements ASN1SetParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.191 -0400", hash_original_field = "5431B8D4D4E17964894E609DD0DF69C0", hash_generated_field = "76949B28A5103E4F545C65F9E6322200")

    private ASN1StreamParser _parser;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.191 -0400", hash_original_method = "B88708124CC7F2028794AA77B282A272", hash_generated_method = "7DBB78AD8D03A8F35D2F6A96F8A8766A")
      DERSetParser(ASN1StreamParser parser) {
        this._parser = parser;
        // ---------- Original Method ----------
        //this._parser = parser;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.191 -0400", hash_original_method = "C77FFAC7A6753577CB275ABB55D17A64", hash_generated_method = "556DB388122784B0FE30BE8C2BA55AE2")
    public DEREncodable readObject() throws IOException {
DEREncodable var7FA56CC8A68C244D303C7C9A462CBFE7_683197748 =         _parser.readObject();
        var7FA56CC8A68C244D303C7C9A462CBFE7_683197748.addTaint(taint);
        return var7FA56CC8A68C244D303C7C9A462CBFE7_683197748;
        // ---------- Original Method ----------
        //return _parser.readObject();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.192 -0400", hash_original_method = "F95A7EBB89400171F1F3290B60410A1D", hash_generated_method = "545CF7A10460CAC6A0855925642C46BD")
    public DERObject getLoadedObject() throws IOException {
DERObject var92F50491F3739C12FE1F6B2D1907A50D_1580165686 =         new DERSet(_parser.readVector(), false);
        var92F50491F3739C12FE1F6B2D1907A50D_1580165686.addTaint(taint);
        return var92F50491F3739C12FE1F6B2D1907A50D_1580165686;
        // ---------- Original Method ----------
        //return new DERSet(_parser.readVector(), false);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.192 -0400", hash_original_method = "C25B7E6814F316F8AC8F55D830DF862A", hash_generated_method = "7832CFF7A246E3B548AB846BFB043DE4")
    public DERObject getDERObject() {
        try 
        {
DERObject var7CA8C38BF885E63AD9395CA9CA98D912_550438794 =             getLoadedObject();
            var7CA8C38BF885E63AD9395CA9CA98D912_550438794.addTaint(taint);
            return var7CA8C38BF885E63AD9395CA9CA98D912_550438794;
        } //End block
        catch (IOException e)
        {
            ASN1ParsingException var2B5ADF01A3F8BD267A883C161A3838C1_524651540 = new ASN1ParsingException(e.getMessage(), e);
            var2B5ADF01A3F8BD267A883C161A3838C1_524651540.addTaint(taint);
            throw var2B5ADF01A3F8BD267A883C161A3838C1_524651540;
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

