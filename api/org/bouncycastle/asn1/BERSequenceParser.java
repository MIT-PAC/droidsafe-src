package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public class BERSequenceParser implements ASN1SequenceParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.814 -0400", hash_original_field = "5431B8D4D4E17964894E609DD0DF69C0", hash_generated_field = "76949B28A5103E4F545C65F9E6322200")

    private ASN1StreamParser _parser;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.814 -0400", hash_original_method = "0FD98DAB53613A9925FD049FC2961E55", hash_generated_method = "C654E682B02E53A6F891C99264E7B745")
      BERSequenceParser(ASN1StreamParser parser) {
        this._parser = parser;
        // ---------- Original Method ----------
        //this._parser = parser;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.814 -0400", hash_original_method = "C77FFAC7A6753577CB275ABB55D17A64", hash_generated_method = "EA03BA661425E775D0C1D10CCBC77364")
    public DEREncodable readObject() throws IOException {
DEREncodable var7FA56CC8A68C244D303C7C9A462CBFE7_461185065 =         _parser.readObject();
        var7FA56CC8A68C244D303C7C9A462CBFE7_461185065.addTaint(taint);
        return var7FA56CC8A68C244D303C7C9A462CBFE7_461185065;
        // ---------- Original Method ----------
        //return _parser.readObject();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.815 -0400", hash_original_method = "B637F95456A6C0EC98A52773252AB22D", hash_generated_method = "F6A95E62C1762FE33EE13D1E8BCC1BD5")
    public DERObject getLoadedObject() throws IOException {
DERObject var21DEBB4142B2B66D46250DEF57F91A81_61935691 =         new BERSequence(_parser.readVector());
        var21DEBB4142B2B66D46250DEF57F91A81_61935691.addTaint(taint);
        return var21DEBB4142B2B66D46250DEF57F91A81_61935691;
        // ---------- Original Method ----------
        //return new BERSequence(_parser.readVector());
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.815 -0400", hash_original_method = "6EDDECA4629CF39F1ED286974E98F21F", hash_generated_method = "629A57CF35963F98B84B438094F02994")
    public DERObject getDERObject() {
        try 
        {
DERObject var7CA8C38BF885E63AD9395CA9CA98D912_1049765524 =             getLoadedObject();
            var7CA8C38BF885E63AD9395CA9CA98D912_1049765524.addTaint(taint);
            return var7CA8C38BF885E63AD9395CA9CA98D912_1049765524;
        } //End block
        catch (IOException e)
        {
            IllegalStateException var49138AC78EB5C3712B0E46EA65CA7614_1942888468 = new IllegalStateException(e.getMessage());
            var49138AC78EB5C3712B0E46EA65CA7614_1942888468.addTaint(taint);
            throw var49138AC78EB5C3712B0E46EA65CA7614_1942888468;
        } //End block
        // ---------- Original Method ----------
        //try
        //{
            //return getLoadedObject();
        //}
        //catch (IOException e)
        //{
            //throw new IllegalStateException(e.getMessage());
        //}
    }

    
}

