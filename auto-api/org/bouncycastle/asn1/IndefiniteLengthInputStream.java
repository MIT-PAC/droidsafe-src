package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

class IndefiniteLengthInputStream extends LimitedInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.363 -0400", hash_original_field = "738F8790AC12386096EC5731A3B156E1", hash_generated_field = "EED902105BB6C063F6B373DB3476C8FB")

    private int _b1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.363 -0400", hash_original_field = "99A4E251D5322495475ED45AE733ED8B", hash_generated_field = "426DDC02F906D649216E5B1E08F10CEF")

    private int _b2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.363 -0400", hash_original_field = "F5A6449C443427402A6E590E62AF27E0", hash_generated_field = "4B4EC70DC676150A8948D59857F39D79")

    private boolean _eofReached = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.363 -0400", hash_original_field = "AF75841A76ABAAC2806DF9D839AFFA68", hash_generated_field = "3020A059BACD857B3764B343B2F5D363")

    private boolean _eofOn00 = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.365 -0400", hash_original_method = "2A5952809765D349E8595E91B1C3BF8F", hash_generated_method = "E74ACA9D8D6EF624D8E3471C7968D2CC")
      IndefiniteLengthInputStream(
        InputStream in,
        int         limit) throws IOException {
        super(in, limit);
        _b1 = in.read();
        _b2 = in.read();
        {
            if (DroidSafeAndroidRuntime.control) throw new EOFException();
        } //End block
        checkForEof();
        addTaint(limit);
        // ---------- Original Method ----------
        //_b1 = in.read();
        //_b2 = in.read();
        //if (_b2 < 0)
        //{
            //throw new EOFException();
        //}
        //checkForEof();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.372 -0400", hash_original_method = "32A1BF96E83BDB9D0A76804DE17B7296", hash_generated_method = "DA25567DD9B76875DA00C799349624F3")
     void setEofOn00(
        boolean eofOn00) {
        _eofOn00 = eofOn00;
        checkForEof();
        // ---------- Original Method ----------
        //_eofOn00 = eofOn00;
        //checkForEof();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.372 -0400", hash_original_method = "4FDE0FC0A80FB708AB4FF6F00CAD13DD", hash_generated_method = "1F938525BBAB9CE91E68A52ABAB7DE65")
    private boolean checkForEof() {
        {
            _eofReached = true;
            setParentEofDetect(true);
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1264048053 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1264048053;
        // ---------- Original Method ----------
        //if (!_eofReached && _eofOn00 && (_b1 == 0x00 && _b2 == 0x00))
        //{
            //_eofReached = true;
            //setParentEofDetect(true);
        //}
        //return _eofReached;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.380 -0400", hash_original_method = "5E4C46F83EA6D4798D78ECC8F00428E0", hash_generated_method = "94648C9ECBF4B2D7C1F5F93D5D2E4655")
    public int read(byte[] b, int off, int len) throws IOException {
        {
            int var2CF40C4E9D4CDCDB484B1322C20F465D_385972224 = (super.read(b, off, len));
        } //End block
        int numRead;
        numRead = _in.read(b, off + 2, len - 2);
        {
            if (DroidSafeAndroidRuntime.control) throw new EOFException();
        } //End block
        b[off] = (byte)_b1;
        b[off + 1] = (byte)_b2;
        _b1 = _in.read();
        _b2 = _in.read();
        {
            if (DroidSafeAndroidRuntime.control) throw new EOFException();
        } //End block
        addTaint(b[0]);
        addTaint(off);
        addTaint(len);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_856619164 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_856619164;
        // ---------- Original Method ----------
        //if (_eofOn00 || len < 3)
        //{
            //return super.read(b, off, len);
        //}
        //if (_eofReached)
        //{
            //return -1;
        //}
        //int numRead = _in.read(b, off + 2, len - 2);
        //if (numRead < 0)
        //{
            //throw new EOFException();
        //}
        //b[off] = (byte)_b1;
        //b[off + 1] = (byte)_b2;
        //_b1 = _in.read();
        //_b2 = _in.read();
        //if (_b2 < 0)
        //{
            //throw new EOFException();
        //}
        //return numRead + 2;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.381 -0400", hash_original_method = "2ACBDCB4D97DF4112755C3E9E6B4B6A1", hash_generated_method = "607A648D61D776D3B16D579284805BC9")
    public int read() throws IOException {
        {
            boolean var85FEC683EA7194083EC6A4CE45268360_648728444 = (checkForEof());
        } //End collapsed parenthetic
        int b;
        b = _in.read();
        {
            if (DroidSafeAndroidRuntime.control) throw new EOFException();
        } //End block
        int v;
        v = _b1;
        _b1 = _b2;
        _b2 = b;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_920023619 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_920023619;
        // ---------- Original Method ----------
        //if (checkForEof())
        //{
            //return -1;
        //}
        //int b = _in.read();
        //if (b < 0)
        //{
            //throw new EOFException();
        //}
        //int v = _b1;
        //_b1 = _b2;
        //_b2 = b;
        //return v;
    }

    
}

