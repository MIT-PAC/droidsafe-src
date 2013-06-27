package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class DERExternalParser implements DEREncodable, InMemoryRepresentable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.941 -0400", hash_original_field = "5431B8D4D4E17964894E609DD0DF69C0", hash_generated_field = "76949B28A5103E4F545C65F9E6322200")

    private ASN1StreamParser _parser;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.942 -0400", hash_original_method = "57CF5022A9E21A477DCDCEAF7C51B0D4", hash_generated_method = "7EDCED9947F31976FEF2A31F5A0A78AE")
    public  DERExternalParser(ASN1StreamParser parser) {
        this._parser = parser;
        // ---------- Original Method ----------
        //this._parser = parser;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.942 -0400", hash_original_method = "C77FFAC7A6753577CB275ABB55D17A64", hash_generated_method = "42A15B2A3D423760626D02032DF53F86")
    public DEREncodable readObject() throws IOException {
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1348815841 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1348815841 = _parser.readObject();
        varB4EAC82CA7396A68D541C85D26508E83_1348815841.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1348815841;
        // ---------- Original Method ----------
        //return _parser.readObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.942 -0400", hash_original_method = "E08AB982B1429E7FF32DFAFFCE3445B5", hash_generated_method = "696202BC633AC0CC3B45EC21EC5E16CB")
    public DERObject getLoadedObject() throws IOException {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_183459161 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_183459161 = new DERExternal(_parser.readVector());
        } //End block
        catch (IllegalArgumentException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception(e.getMessage(), e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_183459161.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_183459161;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.943 -0400", hash_original_method = "E8FC5EC09DAB37CBF457EC44DD373FAE", hash_generated_method = "FABD6E1A7B1CA1AF91C715BC5B5AF6D1")
    public DERObject getDERObject() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_654340061 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_654340061 = getLoadedObject();
        } //End block
        catch (IOException ioe)
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1ParsingException("unable to get DER object", ioe);
        } //End block
        catch (IllegalArgumentException ioe)
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1ParsingException("unable to get DER object", ioe);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_654340061.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_654340061;
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

