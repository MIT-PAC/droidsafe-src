package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;






public class DERExternalParser implements DEREncodable, InMemoryRepresentable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:16.834 -0500", hash_original_field = "8EE68094F784B2C8EC928CABAEA021F0", hash_generated_field = "76949B28A5103E4F545C65F9E6322200")

    private ASN1StreamParser _parser;

    /**
     * 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:16.836 -0500", hash_original_method = "57CF5022A9E21A477DCDCEAF7C51B0D4", hash_generated_method = "F505B05D99F2DE5FF2C2987BE8AC72F8")
    
public DERExternalParser(ASN1StreamParser parser)
    {
        this._parser = parser;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:16.839 -0500", hash_original_method = "C77FFAC7A6753577CB275ABB55D17A64", hash_generated_method = "7E945A4F85D137716A9450ED5D0C4580")
    
public DEREncodable readObject()
        throws IOException
    {
        return _parser.readObject();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:16.841 -0500", hash_original_method = "E08AB982B1429E7FF32DFAFFCE3445B5", hash_generated_method = "4A2E829A47D0A9B8FB249AAF832C7104")
    
public DERObject getLoadedObject()
        throws IOException
    {
        try
        {
            return new DERExternal(_parser.readVector());
        }
        catch (IllegalArgumentException e)
        {
            throw new ASN1Exception(e.getMessage(), e);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:16.844 -0500", hash_original_method = "E8FC5EC09DAB37CBF457EC44DD373FAE", hash_generated_method = "F9B8446EC893DB68692D12EE87A9BC4E")
    
public DERObject getDERObject()
    {
        try 
        {
            return getLoadedObject();
        }
        catch (IOException ioe) 
        {
            throw new ASN1ParsingException("unable to get DER object", ioe);
        }
        catch (IllegalArgumentException ioe) 
        {
            throw new ASN1ParsingException("unable to get DER object", ioe);
        }
    }

    
}

