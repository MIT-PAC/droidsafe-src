package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;




public class BERSequenceParser implements ASN1SequenceParser {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.875 -0500", hash_original_field = "8EE68094F784B2C8EC928CABAEA021F0", hash_generated_field = "76949B28A5103E4F545C65F9E6322200")

    private ASN1StreamParser _parser;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.876 -0500", hash_original_method = "0FD98DAB53613A9925FD049FC2961E55", hash_generated_method = "0FD98DAB53613A9925FD049FC2961E55")
    BERSequenceParser(ASN1StreamParser parser)
    {
        this._parser = parser;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.876 -0500", hash_original_method = "C77FFAC7A6753577CB275ABB55D17A64", hash_generated_method = "7E945A4F85D137716A9450ED5D0C4580")
    public DEREncodable readObject()
        throws IOException
    {
        return _parser.readObject();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.877 -0500", hash_original_method = "B637F95456A6C0EC98A52773252AB22D", hash_generated_method = "EAE6724EEB3AC359EB5D7FE2FC860A0A")
    public DERObject getLoadedObject()
        throws IOException
    {
        return new BERSequence(_parser.readVector());
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:49.878 -0500", hash_original_method = "6EDDECA4629CF39F1ED286974E98F21F", hash_generated_method = "F078EE785C827540DC9A78151C43A9E1")
    public DERObject getDERObject()
    {
        try
        {
            return getLoadedObject();
        }
        catch (IOException e)
        {
            throw new IllegalStateException(e.getMessage());
        }
    }

    
}

