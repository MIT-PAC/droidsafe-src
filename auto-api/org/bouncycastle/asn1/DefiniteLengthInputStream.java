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
import org.bouncycastle.util.io.Streams;

class DefiniteLengthInputStream extends LimitedInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.311 -0400", hash_original_field = "2906002244F44764B3BEBF63B4E23DCA", hash_generated_field = "1665FC1E3CFF38838A5E1CB7D836EA25")

    private int _originalLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.312 -0400", hash_original_field = "991DDDCC8A2D812FA4B424FF9EEFC021", hash_generated_field = "46A946FCA3AF0E5717A8BBE27253E4C6")

    private int _remaining;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.321 -0400", hash_original_method = "5BF1A7CDEE13BEE461E5AA1DCC1B1E57", hash_generated_method = "092B3E97AC9414E795EE5DD01C8239FE")
      DefiniteLengthInputStream(
        InputStream in,
        int         length) {
        super(in, length);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("negative lengths not allowed");
        } //End block
        this._originalLength = length;
        this._remaining = length;
        {
            setParentEofDetect(true);
        } //End block
        addTaint(in.getTaint());
        // ---------- Original Method ----------
        //if (length < 0)
        //{
            //throw new IllegalArgumentException("negative lengths not allowed");
        //}
        //this._originalLength = length;
        //this._remaining = length;
        //if (length == 0)
        //{
            //setParentEofDetect(true);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.321 -0400", hash_original_method = "D30FA562EE05AC3CB636487C62BCEE80", hash_generated_method = "6873757186629A0CF647451E2221E6DB")
     int getRemaining() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_936701066 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_936701066;
        // ---------- Original Method ----------
        //return _remaining;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.322 -0400", hash_original_method = "472AD8364CD714087B8FB4AA07B9D0D1", hash_generated_method = "67065F7C742BE022CD79F2737650E6AA")
    public int read() throws IOException {
        int b;
        b = _in.read();
        {
            if (DroidSafeAndroidRuntime.control) throw new EOFException("DEF length " + _originalLength + " object truncated by " + _remaining);
        } //End block
        {
            setParentEofDetect(true);
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1304354967 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1304354967;
        // ---------- Original Method ----------
        //if (_remaining == 0)
        //{
            //return -1;
        //}
        //int b = _in.read();
        //if (b < 0)
        //{
            //throw new EOFException("DEF length " + _originalLength + " object truncated by " + _remaining);
        //}
        //if (--_remaining == 0)
        //{
            //setParentEofDetect(true);
        //}
        //return b;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.323 -0400", hash_original_method = "A08D5ADC8470447FAA8F1F7D6ED59D8F", hash_generated_method = "1A66BEBB0DA27C1808BF6AE2C7EB2522")
    public int read(byte[] buf, int off, int len) throws IOException {
        int toRead;
        toRead = Math.min(len, _remaining);
        int numRead;
        numRead = _in.read(buf, off, toRead);
        {
            if (DroidSafeAndroidRuntime.control) throw new EOFException("DEF length " + _originalLength + " object truncated by " + _remaining);
        } //End block
        {
            boolean var7DC1F1C134E4EB2EDC913D527DDDB35A_1897489347 = ((_remaining -= numRead) == 0);
            {
                setParentEofDetect(true);
            } //End block
        } //End collapsed parenthetic
        addTaint(buf[0]);
        addTaint(off);
        addTaint(len);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_658498563 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_658498563;
        // ---------- Original Method ----------
        //if (_remaining == 0)
        //{
            //return -1;
        //}
        //int toRead = Math.min(len, _remaining);
        //int numRead = _in.read(buf, off, toRead);
        //if (numRead < 0)
        //{
            //throw new EOFException("DEF length " + _originalLength + " object truncated by " + _remaining);
        //}
        //if ((_remaining -= numRead) == 0)
        //{
            //setParentEofDetect(true);
        //}
        //return numRead;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.332 -0400", hash_original_method = "2B4E4858B5FC3F43B2D34DE081975A19", hash_generated_method = "AEDC96E2DDEC9764ABEC3B2CFD8ED2A6")
     byte[] toByteArray() throws IOException {
        byte[] bytes;
        bytes = new byte[_remaining];
        {
            boolean var61DCEE07B8C67DB539A45C1CC538D8A7_938980870 = ((_remaining -= Streams.readFully(_in, bytes)) != 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new EOFException("DEF length " + _originalLength + " object truncated by " + _remaining);
            } //End block
        } //End collapsed parenthetic
        setParentEofDetect(true);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2146666466 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2146666466;
        // ---------- Original Method ----------
        //if (_remaining == 0)
        //{
            //return EMPTY_BYTES;
        //}
        //byte[] bytes = new byte[_remaining];
        //if ((_remaining -= Streams.readFully(_in, bytes)) != 0)
        //{
            //throw new EOFException("DEF length " + _originalLength + " object truncated by " + _remaining);
        //}
        //setParentEofDetect(true);
        //return bytes;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.332 -0400", hash_original_field = "29B3D4C662B5BB7978CBC0322B561C2A", hash_generated_field = "31F8FE77B2C5CB0650135BDA1E336A3B")

    private static byte[] EMPTY_BYTES = new byte[0];
}

