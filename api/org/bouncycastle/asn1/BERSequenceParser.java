package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;




public class BERSequenceParser implements ASN1SequenceParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.967 -0400", hash_original_field = "5431B8D4D4E17964894E609DD0DF69C0", hash_generated_field = "76949B28A5103E4F545C65F9E6322200")

    private ASN1StreamParser _parser;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.968 -0400", hash_original_method = "0FD98DAB53613A9925FD049FC2961E55", hash_generated_method = "C654E682B02E53A6F891C99264E7B745")
      BERSequenceParser(ASN1StreamParser parser) {
        this._parser = parser;
        // ---------- Original Method ----------
        //this._parser = parser;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.969 -0400", hash_original_method = "C77FFAC7A6753577CB275ABB55D17A64", hash_generated_method = "42962A028C5C9A82774F8EFAE3DAA6B3")
    public DEREncodable readObject() throws IOException {
DEREncodable var7FA56CC8A68C244D303C7C9A462CBFE7_1029177644 =         _parser.readObject();
        var7FA56CC8A68C244D303C7C9A462CBFE7_1029177644.addTaint(taint);
        return var7FA56CC8A68C244D303C7C9A462CBFE7_1029177644;
        // ---------- Original Method ----------
        //return _parser.readObject();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.969 -0400", hash_original_method = "B637F95456A6C0EC98A52773252AB22D", hash_generated_method = "BFEFC54A47A570876D6353F958CFC9FC")
    public DERObject getLoadedObject() throws IOException {
DERObject var21DEBB4142B2B66D46250DEF57F91A81_2118873726 =         new BERSequence(_parser.readVector());
        var21DEBB4142B2B66D46250DEF57F91A81_2118873726.addTaint(taint);
        return var21DEBB4142B2B66D46250DEF57F91A81_2118873726;
        // ---------- Original Method ----------
        //return new BERSequence(_parser.readVector());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.970 -0400", hash_original_method = "6EDDECA4629CF39F1ED286974E98F21F", hash_generated_method = "A7DC97C3964E3A85C417C8E8B525C5FD")
    public DERObject getDERObject() {
        try 
        {
DERObject var7CA8C38BF885E63AD9395CA9CA98D912_1565800730 =             getLoadedObject();
            var7CA8C38BF885E63AD9395CA9CA98D912_1565800730.addTaint(taint);
            return var7CA8C38BF885E63AD9395CA9CA98D912_1565800730;
        } //End block
        catch (IOException e)
        {
            IllegalStateException var49138AC78EB5C3712B0E46EA65CA7614_1271321648 = new IllegalStateException(e.getMessage());
            var49138AC78EB5C3712B0E46EA65CA7614_1271321648.addTaint(taint);
            throw var49138AC78EB5C3712B0E46EA65CA7614_1271321648;
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

