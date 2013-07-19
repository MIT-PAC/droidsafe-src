package org.bouncycastle.asn1;

// Droidsafe Imports
import java.io.IOException;

import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class DERSequenceParser implements ASN1SequenceParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.530 -0400", hash_original_field = "5431B8D4D4E17964894E609DD0DF69C0", hash_generated_field = "76949B28A5103E4F545C65F9E6322200")

    private ASN1StreamParser _parser;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.530 -0400", hash_original_method = "8848C9C8ECB0CA0AB2FE0EC7BB14F901", hash_generated_method = "0F5A98184A067094E1008BF346904948")
      DERSequenceParser(ASN1StreamParser parser) {
        this._parser = parser;
        // ---------- Original Method ----------
        //this._parser = parser;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.530 -0400", hash_original_method = "C77FFAC7A6753577CB275ABB55D17A64", hash_generated_method = "C6BCA50C0ECFF2C2949CE689DD266926")
    public DEREncodable readObject() throws IOException {
DEREncodable var7FA56CC8A68C244D303C7C9A462CBFE7_889662834 =         _parser.readObject();
        var7FA56CC8A68C244D303C7C9A462CBFE7_889662834.addTaint(taint);
        return var7FA56CC8A68C244D303C7C9A462CBFE7_889662834;
        // ---------- Original Method ----------
        //return _parser.readObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.530 -0400", hash_original_method = "6CB3748BA1DF3221B502A0BCD2F9C771", hash_generated_method = "5F1C229EB11DEF6BD4708BFC67C1FDAF")
    public DERObject getLoadedObject() throws IOException {
DERObject var149AA351DB5DEA0CBA4DC65888095652_945961427 =         new DERSequence(_parser.readVector());
        var149AA351DB5DEA0CBA4DC65888095652_945961427.addTaint(taint);
        return var149AA351DB5DEA0CBA4DC65888095652_945961427;
        // ---------- Original Method ----------
        //return new DERSequence(_parser.readVector());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.531 -0400", hash_original_method = "6EDDECA4629CF39F1ED286974E98F21F", hash_generated_method = "67570F88B29712015ED84317B8D7B385")
    public DERObject getDERObject() {
        try 
        {
DERObject var7CA8C38BF885E63AD9395CA9CA98D912_1539759612 =             getLoadedObject();
            var7CA8C38BF885E63AD9395CA9CA98D912_1539759612.addTaint(taint);
            return var7CA8C38BF885E63AD9395CA9CA98D912_1539759612;
        } //End block
        catch (IOException e)
        {
            IllegalStateException var49138AC78EB5C3712B0E46EA65CA7614_405877346 = new IllegalStateException(e.getMessage());
            var49138AC78EB5C3712B0E46EA65CA7614_405877346.addTaint(taint);
            throw var49138AC78EB5C3712B0E46EA65CA7614_405877346;
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

