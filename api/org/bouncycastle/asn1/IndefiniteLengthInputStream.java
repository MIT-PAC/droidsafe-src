package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

class IndefiniteLengthInputStream extends LimitedInputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.618 -0500", hash_original_field = "2E6688B071EBDE694CC6A067296A4CA2", hash_generated_field = "EED902105BB6C063F6B373DB3476C8FB")

    private int _b1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.620 -0500", hash_original_field = "63039838C3CD2AC9E717D32B1AE9C4D6", hash_generated_field = "426DDC02F906D649216E5B1E08F10CEF")

    private int _b2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.623 -0500", hash_original_field = "224C2B22C3FD85FF5594F9AB4725A184", hash_generated_field = "4B4EC70DC676150A8948D59857F39D79")

    private boolean _eofReached = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.626 -0500", hash_original_field = "CF8E93947D844EE1F970E96872E0F56A", hash_generated_field = "3020A059BACD857B3764B343B2F5D363")

    private boolean _eofOn00 = true;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.629 -0500", hash_original_method = "2A5952809765D349E8595E91B1C3BF8F", hash_generated_method = "BB11001A280430E08429D05DDAE9F44E")
    
IndefiniteLengthInputStream(
        InputStream in,
        int         limit)
        throws IOException
    {
        super(in, limit);

        _b1 = in.read();
        _b2 = in.read();

        if (_b2 < 0)
        {
            // Corrupted stream
            throw new EOFException();
        }

        checkForEof();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.631 -0500", hash_original_method = "32A1BF96E83BDB9D0A76804DE17B7296", hash_generated_method = "32A1BF96E83BDB9D0A76804DE17B7296")
    
void setEofOn00(
        boolean eofOn00)
    {
        _eofOn00 = eofOn00;
        checkForEof();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.633 -0500", hash_original_method = "4FDE0FC0A80FB708AB4FF6F00CAD13DD", hash_generated_method = "23B32280FDDF1D96959AB222F428D32F")
    
private boolean checkForEof()
    {
        if (!_eofReached && _eofOn00 && (_b1 == 0x00 && _b2 == 0x00))
        {
            _eofReached = true;
            setParentEofDetect(true);
        }
        return _eofReached;
    }

    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.636 -0500", hash_original_method = "5E4C46F83EA6D4798D78ECC8F00428E0", hash_generated_method = "A9CCE6A1BB4F56629983BCB0CADD6D12")
    
public int read(byte[] b, int off, int len)
        throws IOException
    {
        // Only use this optimisation if we aren't checking for 00
        if (_eofOn00 || len < 3)
        {
            return super.read(b, off, len);
        }

        if (_eofReached)
        {
            return -1;
        }

        int numRead = _in.read(b, off + 2, len - 2);

        if (numRead < 0)
        {
            // Corrupted stream
            throw new EOFException();
        }

        b[off] = (byte)_b1;
        b[off + 1] = (byte)_b2;

        _b1 = _in.read();
        _b2 = _in.read();

        if (_b2 < 0)
        {
            // Corrupted stream
            throw new EOFException();
        }

        return numRead + 2;
    }

    @DSSource({DSSourceKind.IO})
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:28.638 -0500", hash_original_method = "2ACBDCB4D97DF4112755C3E9E6B4B6A1", hash_generated_method = "1DAFA9B84AE28F0440025C14E1CACA7F")
    
public int read()
        throws IOException
    {
        if (checkForEof())
        {
            return -1;
        }

        int b = _in.read();

        if (b < 0)
        {
            // Corrupted stream
            throw new EOFException();
        }

        int v = _b1;

        _b1 = _b2;
        _b2 = b;

        return v;
    }
    
}

