package org.bouncycastle.asn1;

// Droidsafe Imports
import java.io.IOException;

import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class BERSetParser implements ASN1SetParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.990 -0400", hash_original_field = "5431B8D4D4E17964894E609DD0DF69C0", hash_generated_field = "76949B28A5103E4F545C65F9E6322200")

    private ASN1StreamParser _parser;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.991 -0400", hash_original_method = "EF8530238239035799CD0A162B856113", hash_generated_method = "3CBB13114A6B7C956C1CC85AC277075B")
      BERSetParser(ASN1StreamParser parser) {
        this._parser = parser;
        // ---------- Original Method ----------
        //this._parser = parser;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.991 -0400", hash_original_method = "C77FFAC7A6753577CB275ABB55D17A64", hash_generated_method = "6B2742B759CB8653CB20552458C61C35")
    public DEREncodable readObject() throws IOException {
DEREncodable var7FA56CC8A68C244D303C7C9A462CBFE7_2120186703 =         _parser.readObject();
        var7FA56CC8A68C244D303C7C9A462CBFE7_2120186703.addTaint(taint);
        return var7FA56CC8A68C244D303C7C9A462CBFE7_2120186703;
        // ---------- Original Method ----------
        //return _parser.readObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.992 -0400", hash_original_method = "1B045C000E117296EF92C9846060EDEF", hash_generated_method = "8701DE530C8A5D0BB74E79F6C6A9CE91")
    public DERObject getLoadedObject() throws IOException {
DERObject varCD53C84A7035F718828F2CEE10D8CCE5_1626572601 =         new BERSet(_parser.readVector(), false);
        varCD53C84A7035F718828F2CEE10D8CCE5_1626572601.addTaint(taint);
        return varCD53C84A7035F718828F2CEE10D8CCE5_1626572601;
        // ---------- Original Method ----------
        //return new BERSet(_parser.readVector(), false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.992 -0400", hash_original_method = "C25B7E6814F316F8AC8F55D830DF862A", hash_generated_method = "7945F0A6257D3EC12B82CE8F66C4ACDE")
    public DERObject getDERObject() {
        try 
        {
DERObject var7CA8C38BF885E63AD9395CA9CA98D912_1848917081 =             getLoadedObject();
            var7CA8C38BF885E63AD9395CA9CA98D912_1848917081.addTaint(taint);
            return var7CA8C38BF885E63AD9395CA9CA98D912_1848917081;
        } //End block
        catch (IOException e)
        {
            ASN1ParsingException var2B5ADF01A3F8BD267A883C161A3838C1_257381241 = new ASN1ParsingException(e.getMessage(), e);
            var2B5ADF01A3F8BD267A883C161A3838C1_257381241.addTaint(taint);
            throw var2B5ADF01A3F8BD267A883C161A3838C1_257381241;
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

