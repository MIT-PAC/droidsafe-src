package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

class IndefiniteLengthInputStream extends LimitedInputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.304 -0400", hash_original_field = "738F8790AC12386096EC5731A3B156E1", hash_generated_field = "EED902105BB6C063F6B373DB3476C8FB")

    private int _b1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.304 -0400", hash_original_field = "99A4E251D5322495475ED45AE733ED8B", hash_generated_field = "426DDC02F906D649216E5B1E08F10CEF")

    private int _b2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.304 -0400", hash_original_field = "F5A6449C443427402A6E590E62AF27E0", hash_generated_field = "4B4EC70DC676150A8948D59857F39D79")

    private boolean _eofReached = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.304 -0400", hash_original_field = "AF75841A76ABAAC2806DF9D839AFFA68", hash_generated_field = "3020A059BACD857B3764B343B2F5D363")

    private boolean _eofOn00 = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.305 -0400", hash_original_method = "2A5952809765D349E8595E91B1C3BF8F", hash_generated_method = "19F48D56AB284FD385A132842C430A11")
      IndefiniteLengthInputStream(
        InputStream in,
        int         limit) throws IOException {
        super(in, limit);
        addTaint(limit);
        _b1 = in.read();
        _b2 = in.read();
    if(_b2 < 0)        
        {
            EOFException var0239D63DB748BB20D119EB36D6D1C384_798500876 = new EOFException();
            var0239D63DB748BB20D119EB36D6D1C384_798500876.addTaint(taint);
            throw var0239D63DB748BB20D119EB36D6D1C384_798500876;
        } //End block
        checkForEof();
        // ---------- Original Method ----------
        //_b1 = in.read();
        //_b2 = in.read();
        //if (_b2 < 0)
        //{
            //throw new EOFException();
        //}
        //checkForEof();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.305 -0400", hash_original_method = "32A1BF96E83BDB9D0A76804DE17B7296", hash_generated_method = "DA25567DD9B76875DA00C799349624F3")
     void setEofOn00(
        boolean eofOn00) {
        _eofOn00 = eofOn00;
        checkForEof();
        // ---------- Original Method ----------
        //_eofOn00 = eofOn00;
        //checkForEof();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.306 -0400", hash_original_method = "4FDE0FC0A80FB708AB4FF6F00CAD13DD", hash_generated_method = "71EE0FCF4F936C038033608FB2A36447")
    private boolean checkForEof() {
    if(!_eofReached && _eofOn00 && (_b1 == 0x00 && _b2 == 0x00))        
        {
            _eofReached = true;
            setParentEofDetect(true);
        } //End block
        boolean var218B6DABB70AD67737B64B3B25E2287A_1746028105 = (_eofReached);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_274992235 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_274992235;
        // ---------- Original Method ----------
        //if (!_eofReached && _eofOn00 && (_b1 == 0x00 && _b2 == 0x00))
        //{
            //_eofReached = true;
            //setParentEofDetect(true);
        //}
        //return _eofReached;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.307 -0400", hash_original_method = "5E4C46F83EA6D4798D78ECC8F00428E0", hash_generated_method = "DC829571E7FF2F86DF2671A44157BAAD")
    public int read(byte[] b, int off, int len) throws IOException {
        addTaint(len);
        addTaint(off);
        addTaint(b[0]);
    if(_eofOn00 || len < 3)        
        {
            int var48B3EFAF438A7AA7380C0F5886A076AA_2056935938 = (super.read(b, off, len));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1684199462 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1684199462;
        } //End block
    if(_eofReached)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_518500472 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_504526350 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_504526350;
        } //End block
        int numRead = _in.read(b, off + 2, len - 2);
    if(numRead < 0)        
        {
            EOFException var0239D63DB748BB20D119EB36D6D1C384_923786676 = new EOFException();
            var0239D63DB748BB20D119EB36D6D1C384_923786676.addTaint(taint);
            throw var0239D63DB748BB20D119EB36D6D1C384_923786676;
        } //End block
        b[off] = (byte)_b1;
        b[off + 1] = (byte)_b2;
        _b1 = _in.read();
        _b2 = _in.read();
    if(_b2 < 0)        
        {
            EOFException var0239D63DB748BB20D119EB36D6D1C384_2024576456 = new EOFException();
            var0239D63DB748BB20D119EB36D6D1C384_2024576456.addTaint(taint);
            throw var0239D63DB748BB20D119EB36D6D1C384_2024576456;
        } //End block
        int varC3453D8ED018A27EE5F4A01D4B45E766_712007361 = (numRead + 2);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2109686493 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2109686493;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.307 -0400", hash_original_method = "2ACBDCB4D97DF4112755C3E9E6B4B6A1", hash_generated_method = "71100D0C4829326733528B2B016E2D59")
    public int read() throws IOException {
    if(checkForEof())        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1010473636 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_476051591 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_476051591;
        } //End block
        int b = _in.read();
    if(b < 0)        
        {
            EOFException var0239D63DB748BB20D119EB36D6D1C384_2102047479 = new EOFException();
            var0239D63DB748BB20D119EB36D6D1C384_2102047479.addTaint(taint);
            throw var0239D63DB748BB20D119EB36D6D1C384_2102047479;
        } //End block
        int v = _b1;
        _b1 = _b2;
        _b2 = b;
        int var9E3669D19B675BD57058FD4664205D2A_652995417 = (v);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_154099017 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_154099017;
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

