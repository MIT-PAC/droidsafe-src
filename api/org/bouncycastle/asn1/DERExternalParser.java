package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;






public class DERExternalParser implements DEREncodable, InMemoryRepresentable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.238 -0400", hash_original_field = "5431B8D4D4E17964894E609DD0DF69C0", hash_generated_field = "76949B28A5103E4F545C65F9E6322200")

    private ASN1StreamParser _parser;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.239 -0400", hash_original_method = "57CF5022A9E21A477DCDCEAF7C51B0D4", hash_generated_method = "7EDCED9947F31976FEF2A31F5A0A78AE")
    public  DERExternalParser(ASN1StreamParser parser) {
        this._parser = parser;
        // ---------- Original Method ----------
        //this._parser = parser;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.240 -0400", hash_original_method = "C77FFAC7A6753577CB275ABB55D17A64", hash_generated_method = "71399FC874B3E47CE077CFDDAE748A44")
    public DEREncodable readObject() throws IOException {
DEREncodable var7FA56CC8A68C244D303C7C9A462CBFE7_635418125 =         _parser.readObject();
        var7FA56CC8A68C244D303C7C9A462CBFE7_635418125.addTaint(taint);
        return var7FA56CC8A68C244D303C7C9A462CBFE7_635418125;
        // ---------- Original Method ----------
        //return _parser.readObject();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.240 -0400", hash_original_method = "E08AB982B1429E7FF32DFAFFCE3445B5", hash_generated_method = "63D85F3DDFF7989698DE295CC23BAF47")
    public DERObject getLoadedObject() throws IOException {
        try 
        {
DERObject varD972B7683CF111A6F634D8311D8A2756_720291731 =             new DERExternal(_parser.readVector());
            varD972B7683CF111A6F634D8311D8A2756_720291731.addTaint(taint);
            return varD972B7683CF111A6F634D8311D8A2756_720291731;
        } //End block
        catch (IllegalArgumentException e)
        {
            ASN1Exception var0C661CC8D68A7CEB6D600868B2DB3BFE_712755727 = new ASN1Exception(e.getMessage(), e);
            var0C661CC8D68A7CEB6D600868B2DB3BFE_712755727.addTaint(taint);
            throw var0C661CC8D68A7CEB6D600868B2DB3BFE_712755727;
        } //End block
        // ---------- Original Method ----------
        //try
        //{
            //return new DERExternal(_parser.readVector());
        //}
        //catch (IllegalArgumentException e)
        //{
            //throw new ASN1Exception(e.getMessage(), e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.241 -0400", hash_original_method = "E8FC5EC09DAB37CBF457EC44DD373FAE", hash_generated_method = "28CF12EAEADEC7A937FFC510C7135B9D")
    public DERObject getDERObject() {
        try 
        {
DERObject var7CA8C38BF885E63AD9395CA9CA98D912_1822600138 =             getLoadedObject();
            var7CA8C38BF885E63AD9395CA9CA98D912_1822600138.addTaint(taint);
            return var7CA8C38BF885E63AD9395CA9CA98D912_1822600138;
        } //End block
        catch (IOException ioe)
        {
            ASN1ParsingException varBB040B8DD50C72730A5D9D57A355B101_1457825886 = new ASN1ParsingException("unable to get DER object", ioe);
            varBB040B8DD50C72730A5D9D57A355B101_1457825886.addTaint(taint);
            throw varBB040B8DD50C72730A5D9D57A355B101_1457825886;
        } //End block
        catch (IllegalArgumentException ioe)
        {
            ASN1ParsingException varBB040B8DD50C72730A5D9D57A355B101_94972004 = new ASN1ParsingException("unable to get DER object", ioe);
            varBB040B8DD50C72730A5D9D57A355B101_94972004.addTaint(taint);
            throw varBB040B8DD50C72730A5D9D57A355B101_94972004;
        } //End block
        // ---------- Original Method ----------
        //try 
        //{
            //return getLoadedObject();
        //}
        //catch (IOException ioe) 
        //{
            //throw new ASN1ParsingException("unable to get DER object", ioe);
        //}
        //catch (IllegalArgumentException ioe) 
        //{
            //throw new ASN1ParsingException("unable to get DER object", ioe);
        //}
    }

    
}

