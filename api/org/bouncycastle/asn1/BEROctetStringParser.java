package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;

import org.bouncycastle.util.io.Streams;




public class BEROctetStringParser implements ASN1OctetStringParser {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.406 -0500", hash_original_field = "8EE68094F784B2C8EC928CABAEA021F0", hash_generated_field = "76949B28A5103E4F545C65F9E6322200")

    private ASN1StreamParser _parser;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.409 -0500", hash_original_method = "9F96CED2BAFBB7EF85E1F3DCE32D3250", hash_generated_method = "9F96CED2BAFBB7EF85E1F3DCE32D3250")
    
BEROctetStringParser(
        ASN1StreamParser parser)
    {
        _parser = parser;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.411 -0500", hash_original_method = "B14EADD9BAF46A36395A6C914A60709A", hash_generated_method = "8EFD4FD48FC14FE157730D89189B2C07")
    
public InputStream getOctetStream()
    {
        return new ConstructedOctetStream(_parser);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.414 -0500", hash_original_method = "0C4B1CCBA41C89EAEA4B5E86000D0763", hash_generated_method = "7746B7109AD137515F349F7325A41809")
    
public DERObject getLoadedObject()
        throws IOException
    {
        return new BERConstructedOctetString(Streams.readAll(getOctetStream()));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.416 -0500", hash_original_method = "9966B03EEC95948C208DE961DDFE6334", hash_generated_method = "9790CD21B734F9781C0411A119675869")
    
public DERObject getDERObject()
    {
        try
        {
            return getLoadedObject();
        }
        catch (IOException e)
        {
            throw new ASN1ParsingException("IOException converting stream to byte array: " + e.getMessage(), e);
        }
    }

    
}

