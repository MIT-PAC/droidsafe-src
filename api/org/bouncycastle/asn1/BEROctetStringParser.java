package org.bouncycastle.asn1;

// Droidsafe Imports
import java.io.IOException;
import java.io.InputStream;

import org.bouncycastle.util.io.Streams;

import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class BEROctetStringParser implements ASN1OctetStringParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.942 -0400", hash_original_field = "5431B8D4D4E17964894E609DD0DF69C0", hash_generated_field = "76949B28A5103E4F545C65F9E6322200")

    private ASN1StreamParser _parser;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.942 -0400", hash_original_method = "9F96CED2BAFBB7EF85E1F3DCE32D3250", hash_generated_method = "D0CEB2B3AD1C579896D18B795405F0C8")
      BEROctetStringParser(
        ASN1StreamParser parser) {
        _parser = parser;
        // ---------- Original Method ----------
        //_parser = parser;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.943 -0400", hash_original_method = "B14EADD9BAF46A36395A6C914A60709A", hash_generated_method = "350B26367462734E77B0F6337ABADC75")
    public InputStream getOctetStream() {
InputStream var9094BCFA8FD71609D2E0842140A5418B_1914053898 =         new ConstructedOctetStream(_parser);
        var9094BCFA8FD71609D2E0842140A5418B_1914053898.addTaint(taint);
        return var9094BCFA8FD71609D2E0842140A5418B_1914053898;
        // ---------- Original Method ----------
        //return new ConstructedOctetStream(_parser);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.943 -0400", hash_original_method = "0C4B1CCBA41C89EAEA4B5E86000D0763", hash_generated_method = "059E1419481179DB7FF61C490EAE28E2")
    public DERObject getLoadedObject() throws IOException {
DERObject var94959E75F831C89F6F810CE88A32FE89_1039015071 =         new BERConstructedOctetString(Streams.readAll(getOctetStream()));
        var94959E75F831C89F6F810CE88A32FE89_1039015071.addTaint(taint);
        return var94959E75F831C89F6F810CE88A32FE89_1039015071;
        // ---------- Original Method ----------
        //return new BERConstructedOctetString(Streams.readAll(getOctetStream()));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.943 -0400", hash_original_method = "9966B03EEC95948C208DE961DDFE6334", hash_generated_method = "0F908A579B81B08DD0C48C7C20E8372C")
    public DERObject getDERObject() {
        try 
        {
DERObject var7CA8C38BF885E63AD9395CA9CA98D912_517178044 =             getLoadedObject();
            var7CA8C38BF885E63AD9395CA9CA98D912_517178044.addTaint(taint);
            return var7CA8C38BF885E63AD9395CA9CA98D912_517178044;
        } //End block
        catch (IOException e)
        {
            ASN1ParsingException varD0CC19A43964E4E112C5E76CFAB8A437_1054139327 = new ASN1ParsingException("IOException converting stream to byte array: " + e.getMessage(), e);
            varD0CC19A43964E4E112C5E76CFAB8A437_1054139327.addTaint(taint);
            throw varD0CC19A43964E4E112C5E76CFAB8A437_1054139327;
        } //End block
        // ---------- Original Method ----------
        //try
        //{
            //return getLoadedObject();
        //}
        //catch (IOException e)
        //{
            //throw new ASN1ParsingException("IOException converting stream to byte array: " + e.getMessage(), e);
        //}
    }

    
}

