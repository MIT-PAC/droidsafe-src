package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

import org.bouncycastle.util.io.Streams;

class DefiniteLengthInputStream extends LimitedInputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.849 -0500", hash_original_field = "FA9F5D306967EDE285ED41554EF4C64B", hash_generated_field = "24B4EEE1E95392A851171438FBC625E7")

    private static final byte[] EMPTY_BYTES = new byte[0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.851 -0500", hash_original_field = "58B9D9227A2F3C41909AC4D1C83E292D", hash_generated_field = "1665FC1E3CFF38838A5E1CB7D836EA25")

    private  int _originalLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.854 -0500", hash_original_field = "82D86337DAD7E6B44E8285FF023DF02A", hash_generated_field = "46A946FCA3AF0E5717A8BBE27253E4C6")

    private int _remaining;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.856 -0500", hash_original_method = "5BF1A7CDEE13BEE461E5AA1DCC1B1E57", hash_generated_method = "5BF1A7CDEE13BEE461E5AA1DCC1B1E57")
    
DefiniteLengthInputStream(
        InputStream in,
        int         length)
    {
        super(in, length);

        if (length < 0)
        {
            throw new IllegalArgumentException("negative lengths not allowed");
        }

        this._originalLength = length;
        this._remaining = length;

        if (length == 0)
        {
            setParentEofDetect(true);
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.859 -0500", hash_original_method = "D30FA562EE05AC3CB636487C62BCEE80", hash_generated_method = "D30FA562EE05AC3CB636487C62BCEE80")
    
int getRemaining()
    {
        return _remaining;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.864 -0500", hash_original_method = "472AD8364CD714087B8FB4AA07B9D0D1", hash_generated_method = "FACEEB51C917595EE003E5CC52AC793A")
    
public int read()
        throws IOException
    {
        if (_remaining == 0)
        {
            return -1;
        }

        int b = _in.read();

        if (b < 0)
        {
            throw new EOFException("DEF length " + _originalLength + " object truncated by " + _remaining);
        }

        if (--_remaining == 0)
        {
            setParentEofDetect(true);
        }

        return b;
    }

    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.869 -0500", hash_original_method = "A08D5ADC8470447FAA8F1F7D6ED59D8F", hash_generated_method = "67EBC3DF45850592C2B8D3FCBC4DB713")
    
public int read(byte[] buf, int off, int len)
        throws IOException
    {
        if (_remaining == 0)
        {
            return -1;
        }

        int toRead = Math.min(len, _remaining);
        int numRead = _in.read(buf, off, toRead);

        if (numRead < 0)
        {
            throw new EOFException("DEF length " + _originalLength + " object truncated by " + _remaining);
        }

        if ((_remaining -= numRead) == 0)
        {
            setParentEofDetect(true);
        }

        return numRead;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:12.873 -0500", hash_original_method = "2B4E4858B5FC3F43B2D34DE081975A19", hash_generated_method = "2B4E4858B5FC3F43B2D34DE081975A19")
    
byte[] toByteArray()
        throws IOException
    {
        if (_remaining == 0)
        {
            return EMPTY_BYTES;
        }

        byte[] bytes = new byte[_remaining];
        if ((_remaining -= Streams.readFully(_in, bytes)) != 0)
        {
            throw new EOFException("DEF length " + _originalLength + " object truncated by " + _remaining);
        }
        setParentEofDetect(true);
        return bytes;
    }
}

