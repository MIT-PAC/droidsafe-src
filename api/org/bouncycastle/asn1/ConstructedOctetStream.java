package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;

class ConstructedOctetStream extends InputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.247 -0500", hash_original_field = "8EE68094F784B2C8EC928CABAEA021F0", hash_generated_field = "76949B28A5103E4F545C65F9E6322200")

    private  ASN1StreamParser _parser;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.250 -0500", hash_original_field = "44B450E74685E14F5383B7BF2C5A29D9", hash_generated_field = "5715766DFE7FD713CE352A25A0465277")

    private boolean                _first = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.253 -0500", hash_original_field = "3BA1CD15C4D2976DF18B717C1B9EDBDD", hash_generated_field = "B436CB06F4CDF9C194959E64C13D82E8")

    private InputStream            _currentStream;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.255 -0500", hash_original_method = "25BBB36D71D2D30850B0439DCA6D8B9F", hash_generated_method = "25BBB36D71D2D30850B0439DCA6D8B9F")
    
ConstructedOctetStream(
        ASN1StreamParser parser)
    {
        _parser = parser;
    }

    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.258 -0500", hash_original_method = "30D34BC5FF70D0CD39A8963110E96C00", hash_generated_method = "856060C89570C4D8A7405ED013082B72")
    
public int read(byte[] b, int off, int len) throws IOException
    {
        if (_currentStream == null)
        {
            if (!_first)
            {
                return -1;
            }

            ASN1OctetStringParser s = (ASN1OctetStringParser)_parser.readObject();

            if (s == null)
            {
                return -1;
            }

            _first = false;
            _currentStream = s.getOctetStream();
        }

        int totalRead = 0;

        for (;;)
        {
            int numRead = _currentStream.read(b, off + totalRead, len - totalRead);

            if (numRead >= 0)
            {
                totalRead += numRead;

                if (totalRead == len)
                {
                    return totalRead;
                }
            }
            else
            {
                ASN1OctetStringParser aos = (ASN1OctetStringParser)_parser.readObject();

                if (aos == null)
                {
                    _currentStream = null;
                    return totalRead < 1 ? -1 : totalRead;
                }

                _currentStream = aos.getOctetStream();
            }
        }
    }

    @DSSource({DSSourceKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:24.261 -0500", hash_original_method = "07E101CE9B272EF565A5C01515093572", hash_generated_method = "EAB34531997E05CBD874F4E2A14601F2")
    
public int read()
        throws IOException
    {
        if (_currentStream == null)
        {
            if (!_first)
            {
                return -1;
            }

            ASN1OctetStringParser s = (ASN1OctetStringParser)_parser.readObject();
    
            if (s == null)
            {
                return -1;
            }
    
            _first = false;
            _currentStream = s.getOctetStream();
        }

        for (;;)
        {
            int b = _currentStream.read();

            if (b >= 0)
            {
                return b;
            }

            ASN1OctetStringParser s = (ASN1OctetStringParser)_parser.readObject();

            if (s == null)
            {
                _currentStream = null;
                return -1;
            }

            _currentStream = s.getOctetStream();
        }
    }
    
}

