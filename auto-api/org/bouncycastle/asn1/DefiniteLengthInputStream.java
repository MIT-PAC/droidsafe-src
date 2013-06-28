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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.857 -0400", hash_original_field = "2906002244F44764B3BEBF63B4E23DCA", hash_generated_field = "1665FC1E3CFF38838A5E1CB7D836EA25")

    private int _originalLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.857 -0400", hash_original_field = "991DDDCC8A2D812FA4B424FF9EEFC021", hash_generated_field = "46A946FCA3AF0E5717A8BBE27253E4C6")

    private int _remaining;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.858 -0400", hash_original_method = "5BF1A7CDEE13BEE461E5AA1DCC1B1E57", hash_generated_method = "092B3E97AC9414E795EE5DD01C8239FE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.858 -0400", hash_original_method = "D30FA562EE05AC3CB636487C62BCEE80", hash_generated_method = "34DE4FAD9A1AF476B38DC696F5144CB4")
     int getRemaining() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2061908548 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2061908548;
        // ---------- Original Method ----------
        //return _remaining;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.858 -0400", hash_original_method = "472AD8364CD714087B8FB4AA07B9D0D1", hash_generated_method = "073500295D39CA0CC5F5C6471A8E6E36")
    public int read() throws IOException {
        int b = _in.read();
        {
            if (DroidSafeAndroidRuntime.control) throw new EOFException("DEF length " + _originalLength + " object truncated by " + _remaining);
        } //End block
        {
            setParentEofDetect(true);
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2142458823 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2142458823;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.859 -0400", hash_original_method = "A08D5ADC8470447FAA8F1F7D6ED59D8F", hash_generated_method = "D1083B63FD87F1AE202AE538F3527654")
    public int read(byte[] buf, int off, int len) throws IOException {
        int toRead = Math.min(len, _remaining);
        int numRead = _in.read(buf, off, toRead);
        {
            if (DroidSafeAndroidRuntime.control) throw new EOFException("DEF length " + _originalLength + " object truncated by " + _remaining);
        } //End block
        {
            boolean var7DC1F1C134E4EB2EDC913D527DDDB35A_2119115933 = ((_remaining -= numRead) == 0);
            {
                setParentEofDetect(true);
            } //End block
        } //End collapsed parenthetic
        addTaint(buf[0]);
        addTaint(off);
        addTaint(len);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_273471358 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_273471358;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.859 -0400", hash_original_method = "2B4E4858B5FC3F43B2D34DE081975A19", hash_generated_method = "4B0F18AC757C3B05C53240D85F0541A2")
     byte[] toByteArray() throws IOException {
        byte[] bytes = new byte[_remaining];
        {
            boolean var61DCEE07B8C67DB539A45C1CC538D8A7_1982935224 = ((_remaining -= Streams.readFully(_in, bytes)) != 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new EOFException("DEF length " + _originalLength + " object truncated by " + _remaining);
            } //End block
        } //End collapsed parenthetic
        setParentEofDetect(true);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_189397693 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_189397693;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.859 -0400", hash_original_field = "29B3D4C662B5BB7978CBC0322B561C2A", hash_generated_field = "24B4EEE1E95392A851171438FBC625E7")

    private static final byte[] EMPTY_BYTES = new byte[0];
}

