package org.bouncycastle.asn1;

// Droidsafe Imports
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

import org.bouncycastle.util.io.Streams;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

class DefiniteLengthInputStream extends LimitedInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.722 -0400", hash_original_field = "2906002244F44764B3BEBF63B4E23DCA", hash_generated_field = "1665FC1E3CFF38838A5E1CB7D836EA25")

    private int _originalLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.722 -0400", hash_original_field = "991DDDCC8A2D812FA4B424FF9EEFC021", hash_generated_field = "46A946FCA3AF0E5717A8BBE27253E4C6")

    private int _remaining;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.723 -0400", hash_original_method = "5BF1A7CDEE13BEE461E5AA1DCC1B1E57", hash_generated_method = "4E2FF82658553616F2081ECB534E34A2")
      DefiniteLengthInputStream(
        InputStream in,
        int         length) {
        super(in, length);
        addTaint(in.getTaint());
        if(length < 0)        
        {
            IllegalArgumentException varC444AD5860DC69F24E2F1B68799D9567_1748436932 = new IllegalArgumentException("negative lengths not allowed");
            varC444AD5860DC69F24E2F1B68799D9567_1748436932.addTaint(taint);
            throw varC444AD5860DC69F24E2F1B68799D9567_1748436932;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.723 -0400", hash_original_method = "D30FA562EE05AC3CB636487C62BCEE80", hash_generated_method = "41D0F8B2A3D59A24CEBA1EA8F6F5CFF7")
     int getRemaining() {
        int var991DDDCC8A2D812FA4B424FF9EEFC021_630585111 = (_remaining);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_794378752 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_794378752;
        // ---------- Original Method ----------
        //return _remaining;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.724 -0400", hash_original_method = "472AD8364CD714087B8FB4AA07B9D0D1", hash_generated_method = "505C76C4ED1C425FDEF800C7C076779D")
    public int read() throws IOException {
        if(_remaining == 0)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_410059559 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1721178887 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1721178887;
        } //End block
        int b = _in.read();
        if(b < 0)        
        {
            EOFException var6BAD41C92E0D51FC900073070215DE9C_603603707 = new EOFException("DEF length " + _originalLength + " object truncated by " + _remaining);
            var6BAD41C92E0D51FC900073070215DE9C_603603707.addTaint(taint);
            throw var6BAD41C92E0D51FC900073070215DE9C_603603707;
        } //End block
        if(--_remaining == 0)        
        {
            setParentEofDetect(true);
        } //End block
        int var92EB5FFEE6AE2FEC3AD71C777531578F_1979301649 = (b);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1006265794 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1006265794;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.725 -0400", hash_original_method = "A08D5ADC8470447FAA8F1F7D6ED59D8F", hash_generated_method = "7D65EB114736D6687F35DB6371285B68")
    public int read(byte[] buf, int off, int len) throws IOException {
        addTaint(len);
        addTaint(off);
        addTaint(buf[0]);
        if(_remaining == 0)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1147865288 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_941169470 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_941169470;
        } //End block
        int toRead = Math.min(len, _remaining);
        int numRead = _in.read(buf, off, toRead);
        if(numRead < 0)        
        {
            EOFException var6BAD41C92E0D51FC900073070215DE9C_1975900621 = new EOFException("DEF length " + _originalLength + " object truncated by " + _remaining);
            var6BAD41C92E0D51FC900073070215DE9C_1975900621.addTaint(taint);
            throw var6BAD41C92E0D51FC900073070215DE9C_1975900621;
        } //End block
        if((_remaining -= numRead) == 0)        
        {
            setParentEofDetect(true);
        } //End block
        int var8123CD6C0E06912F178DA31EC026F8A0_573460804 = (numRead);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1265678975 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1265678975;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.726 -0400", hash_original_method = "2B4E4858B5FC3F43B2D34DE081975A19", hash_generated_method = "E434023C2815704509C709B5CB460DA0")
     byte[] toByteArray() throws IOException {
        if(_remaining == 0)        
        {
            byte[] var36CED659BD965D568BEA13FDE5BEA432_1895546721 = (EMPTY_BYTES);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1913955465 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1913955465;
        } //End block
        byte[] bytes = new byte[_remaining];
        if((_remaining -= Streams.readFully(_in, bytes)) != 0)        
        {
            EOFException var6BAD41C92E0D51FC900073070215DE9C_1825580601 = new EOFException("DEF length " + _originalLength + " object truncated by " + _remaining);
            var6BAD41C92E0D51FC900073070215DE9C_1825580601.addTaint(taint);
            throw var6BAD41C92E0D51FC900073070215DE9C_1825580601;
        } //End block
        setParentEofDetect(true);
        byte[] var4B3A6218BB3E3A7303E8A171A60FCF92_1383602200 = (bytes);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1074377365 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1074377365;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.726 -0400", hash_original_field = "29B3D4C662B5BB7978CBC0322B561C2A", hash_generated_field = "24B4EEE1E95392A851171438FBC625E7")

    private static final byte[] EMPTY_BYTES = new byte[0];
}

