package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.io.Streams;

public class BEROctetStringParser implements ASN1OctetStringParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.803 -0400", hash_original_field = "5431B8D4D4E17964894E609DD0DF69C0", hash_generated_field = "76949B28A5103E4F545C65F9E6322200")

    private ASN1StreamParser _parser;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.803 -0400", hash_original_method = "9F96CED2BAFBB7EF85E1F3DCE32D3250", hash_generated_method = "D0CEB2B3AD1C579896D18B795405F0C8")
      BEROctetStringParser(
        ASN1StreamParser parser) {
        _parser = parser;
        // ---------- Original Method ----------
        //_parser = parser;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.803 -0400", hash_original_method = "B14EADD9BAF46A36395A6C914A60709A", hash_generated_method = "F6F6E4147240DCD5C571C8D535AA2110")
    public InputStream getOctetStream() {
InputStream var9094BCFA8FD71609D2E0842140A5418B_1024995830 =         new ConstructedOctetStream(_parser);
        var9094BCFA8FD71609D2E0842140A5418B_1024995830.addTaint(taint);
        return var9094BCFA8FD71609D2E0842140A5418B_1024995830;
        // ---------- Original Method ----------
        //return new ConstructedOctetStream(_parser);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.804 -0400", hash_original_method = "0C4B1CCBA41C89EAEA4B5E86000D0763", hash_generated_method = "56BFD5F21D78764AD6D28B9E7CF7CA03")
    public DERObject getLoadedObject() throws IOException {
DERObject var94959E75F831C89F6F810CE88A32FE89_741010007 =         new BERConstructedOctetString(Streams.readAll(getOctetStream()));
        var94959E75F831C89F6F810CE88A32FE89_741010007.addTaint(taint);
        return var94959E75F831C89F6F810CE88A32FE89_741010007;
        // ---------- Original Method ----------
        //return new BERConstructedOctetString(Streams.readAll(getOctetStream()));
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.804 -0400", hash_original_method = "9966B03EEC95948C208DE961DDFE6334", hash_generated_method = "A139A41A0059777A48771F2F885EA783")
    public DERObject getDERObject() {
        try 
        {
DERObject var7CA8C38BF885E63AD9395CA9CA98D912_157639819 =             getLoadedObject();
            var7CA8C38BF885E63AD9395CA9CA98D912_157639819.addTaint(taint);
            return var7CA8C38BF885E63AD9395CA9CA98D912_157639819;
        } //End block
        catch (IOException e)
        {
            ASN1ParsingException varD0CC19A43964E4E112C5E76CFAB8A437_681188296 = new ASN1ParsingException("IOException converting stream to byte array: " + e.getMessage(), e);
            varD0CC19A43964E4E112C5E76CFAB8A437_681188296.addTaint(taint);
            throw varD0CC19A43964E4E112C5E76CFAB8A437_681188296;
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

