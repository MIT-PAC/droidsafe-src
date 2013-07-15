package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.io.Streams;

class DefiniteLengthInputStream extends LimitedInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.293 -0400", hash_original_field = "2906002244F44764B3BEBF63B4E23DCA", hash_generated_field = "1665FC1E3CFF38838A5E1CB7D836EA25")

    private int _originalLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.293 -0400", hash_original_field = "991DDDCC8A2D812FA4B424FF9EEFC021", hash_generated_field = "46A946FCA3AF0E5717A8BBE27253E4C6")

    private int _remaining;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.294 -0400", hash_original_method = "5BF1A7CDEE13BEE461E5AA1DCC1B1E57", hash_generated_method = "A8586BBC2D62F003404C020976520FDD")
      DefiniteLengthInputStream(
        InputStream in,
        int         length) {
        super(in, length);
        addTaint(in.getTaint());
    if(length < 0)        
        {
            IllegalArgumentException varC444AD5860DC69F24E2F1B68799D9567_818169471 = new IllegalArgumentException("negative lengths not allowed");
            varC444AD5860DC69F24E2F1B68799D9567_818169471.addTaint(taint);
            throw varC444AD5860DC69F24E2F1B68799D9567_818169471;
        } //End block
        this._originalLength = length;
        this._remaining = length;
    if(length == 0)        
        {
            setParentEofDetect(true);
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.294 -0400", hash_original_method = "D30FA562EE05AC3CB636487C62BCEE80", hash_generated_method = "72850C3E49766768F02CC2B16632D2A6")
     int getRemaining() {
        int var991DDDCC8A2D812FA4B424FF9EEFC021_2015185475 = (_remaining);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1606987590 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1606987590;
        // ---------- Original Method ----------
        //return _remaining;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.295 -0400", hash_original_method = "472AD8364CD714087B8FB4AA07B9D0D1", hash_generated_method = "B72B710A98EC39E4A1B7F4C50AA71D9E")
    public int read() throws IOException {
    if(_remaining == 0)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_221043619 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_90871542 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_90871542;
        } //End block
        int b = _in.read();
    if(b < 0)        
        {
            EOFException var6BAD41C92E0D51FC900073070215DE9C_1121312750 = new EOFException("DEF length " + _originalLength + " object truncated by " + _remaining);
            var6BAD41C92E0D51FC900073070215DE9C_1121312750.addTaint(taint);
            throw var6BAD41C92E0D51FC900073070215DE9C_1121312750;
        } //End block
    if(--_remaining == 0)        
        {
            setParentEofDetect(true);
        } //End block
        int var92EB5FFEE6AE2FEC3AD71C777531578F_1523594368 = (b);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_841309330 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_841309330;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.295 -0400", hash_original_method = "A08D5ADC8470447FAA8F1F7D6ED59D8F", hash_generated_method = "15263431CAF8DC6F3CBE61E03E57CC67")
    public int read(byte[] buf, int off, int len) throws IOException {
        addTaint(len);
        addTaint(off);
        addTaint(buf[0]);
    if(_remaining == 0)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_760190888 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_383334505 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_383334505;
        } //End block
        int toRead = Math.min(len, _remaining);
        int numRead = _in.read(buf, off, toRead);
    if(numRead < 0)        
        {
            EOFException var6BAD41C92E0D51FC900073070215DE9C_564075912 = new EOFException("DEF length " + _originalLength + " object truncated by " + _remaining);
            var6BAD41C92E0D51FC900073070215DE9C_564075912.addTaint(taint);
            throw var6BAD41C92E0D51FC900073070215DE9C_564075912;
        } //End block
    if((_remaining -= numRead) == 0)        
        {
            setParentEofDetect(true);
        } //End block
        int var8123CD6C0E06912F178DA31EC026F8A0_20286318 = (numRead);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1959406280 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1959406280;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.296 -0400", hash_original_method = "2B4E4858B5FC3F43B2D34DE081975A19", hash_generated_method = "735C1F012A70C9269D22B589245AFCCC")
     byte[] toByteArray() throws IOException {
    if(_remaining == 0)        
        {
            byte[] var36CED659BD965D568BEA13FDE5BEA432_1709899915 = (EMPTY_BYTES);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1607070493 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1607070493;
        } //End block
        byte[] bytes = new byte[_remaining];
    if((_remaining -= Streams.readFully(_in, bytes)) != 0)        
        {
            EOFException var6BAD41C92E0D51FC900073070215DE9C_201401653 = new EOFException("DEF length " + _originalLength + " object truncated by " + _remaining);
            var6BAD41C92E0D51FC900073070215DE9C_201401653.addTaint(taint);
            throw var6BAD41C92E0D51FC900073070215DE9C_201401653;
        } //End block
        setParentEofDetect(true);
        byte[] var4B3A6218BB3E3A7303E8A171A60FCF92_1650380995 = (bytes);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1958453810 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1958453810;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.296 -0400", hash_original_field = "29B3D4C662B5BB7978CBC0322B561C2A", hash_generated_field = "24B4EEE1E95392A851171438FBC625E7")

    private static final byte[] EMPTY_BYTES = new byte[0];
}

