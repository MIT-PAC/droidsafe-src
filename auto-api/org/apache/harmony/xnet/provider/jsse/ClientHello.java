package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Arrays;
import libcore.io.Streams;
import libcore.util.EmptyArray;

public class ClientHello extends Message {
    byte[] client_version;
    byte[] random = new byte[32];
    byte[] session_id;
    CipherSuite[] cipher_suites;
    byte[] compression_methods;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.654 -0400", hash_original_method = "B360A744DA2558AEF3A4AD32A9DD66E9", hash_generated_method = "9B7003BFE79788DCFD05FD5E8D64E1DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ClientHello(SecureRandom sr, byte[] version, byte[] ses_id,
            CipherSuite[] cipher_suite) {
        dsTaint.addTaint(sr.dsTaint);
        dsTaint.addTaint(ses_id[0]);
        dsTaint.addTaint(cipher_suite[0].dsTaint);
        dsTaint.addTaint(version[0]);
        long gmt_unix_time;
        gmt_unix_time = System.currentTimeMillis()/1000;
        sr.nextBytes(random);
        random[0] = (byte) (gmt_unix_time & 0xFF000000 >>> 24);
        random[1] = (byte) (gmt_unix_time & 0xFF0000 >>> 16);
        random[2] = (byte) (gmt_unix_time & 0xFF00 >>> 8);
        random[3] = (byte) (gmt_unix_time & 0xFF);
        compression_methods = new byte[] { 0 };
        length = 38 + session_id.length + (this.cipher_suites.length << 1)
                + compression_methods.length;
        // ---------- Original Method ----------
        //client_version = version;
        //long gmt_unix_time = System.currentTimeMillis()/1000;
        //sr.nextBytes(random);
        //random[0] = (byte) (gmt_unix_time & 0xFF000000 >>> 24);
        //random[1] = (byte) (gmt_unix_time & 0xFF0000 >>> 16);
        //random[2] = (byte) (gmt_unix_time & 0xFF00 >>> 8);
        //random[3] = (byte) (gmt_unix_time & 0xFF);
        //session_id = ses_id;
        //this.cipher_suites = cipher_suite;
        //compression_methods = new byte[] { 0 };
        //length = 38 + session_id.length + (this.cipher_suites.length << 1)
                //+ compression_methods.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.655 -0400", hash_original_method = "9848891785B38B606D088EC36D49C2E1", hash_generated_method = "E3E993D5AE92491C63A5B8B6BBABD481")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ClientHello(HandshakeIODataStream in, int length) throws IOException {
        dsTaint.addTaint(length);
        dsTaint.addTaint(in.dsTaint);
        client_version = new byte[2];
        client_version[0] = (byte) in.readUint8();
        client_version[1] = (byte) in.readUint8();
        Streams.readFully(in, random);
        int size;
        size = in.read();
        session_id = new byte[size];
        in.read(session_id, 0, size);
        int l;
        l = in.readUint16();
        {
            fatalAlert(AlertProtocol.DECODE_ERROR,
                    "DECODE ERROR: incorrect ClientHello");
        } //End block
        size = l >> 1;
        cipher_suites = new CipherSuite[size];
        {
            int i;
            i = 0;
            {
                byte b0;
                b0 = (byte) in.read();
                byte b1;
                b1 = (byte) in.read();
                cipher_suites[i] = CipherSuite.getByCode(b0, b1);
            } //End block
        } //End collapsed parenthetic
        size = in.read();
        compression_methods = new byte[size];
        in.read(compression_methods, 0, size);
        this.length = 38 + session_id.length + (cipher_suites.length << 1)
                + compression_methods.length;
        {
            fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect ClientHello");
        } //End block
        {
            in.skip(length - this.length);
            this.length = length;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.655 -0400", hash_original_method = "092EDC6A6C17B41B7BF7C969F19C771C", hash_generated_method = "15CC6B66C562D9D5DB0A2F2241DC92E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ClientHello(HandshakeIODataStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        {
            boolean var022F181FCD3ECCEDD53D5E77DDFAF49D_51238840 = (in.readUint8() != 1);
            {
                fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect V2ClientHello");
            } //End block
        } //End collapsed parenthetic
        client_version = new byte[2];
        client_version[0] = (byte) in.readUint8();
        client_version[1] = (byte) in.readUint8();
        int cipher_spec_length;
        cipher_spec_length = in.readUint16();
        {
            boolean varDCD0C84AEEE1853740202846CF98E636_1993296261 = (in.readUint16() != 0);
            {
                fatalAlert(AlertProtocol.DECODE_ERROR,
                    "DECODE ERROR: incorrect V2ClientHello, cannot be used for resuming");
            } //End block
        } //End collapsed parenthetic
        int challenge_length;
        challenge_length = in.readUint16();
        {
            fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect V2ClientHello, short challenge data");
        } //End block
        session_id = EmptyArray.BYTE;
        cipher_suites = new CipherSuite[cipher_spec_length/3];
        {
            int i;
            i = 0;
            {
                byte b0;
                b0 = (byte) in.read();
                byte b1;
                b1 = (byte) in.read();
                byte b2;
                b2 = (byte) in.read();
                cipher_suites[i] = CipherSuite.getByCode(b0, b1, b2);
            } //End block
        } //End collapsed parenthetic
        compression_methods = new byte[] { 0 };
        {
            Arrays.fill(random, 0, 32 - challenge_length, (byte)0);
            System.arraycopy(in.read(challenge_length), 0, random, 32 - challenge_length, challenge_length);
        } //End block
        {
            System.arraycopy(in.read(32), 0, random, 0, 32);
        } //End block
        {
            System.arraycopy(in.read(challenge_length), challenge_length - 32, random, 0, 32);
        } //End block
        {
            boolean varE684FF4D92AACF44A45D4FF9CA23ABC5_680981043 = (in.available() > 0);
            {
                fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect V2ClientHello, extra data");
            } //End block
        } //End collapsed parenthetic
        this.length = 38 + session_id.length + (cipher_suites.length << 1)
                + compression_methods.length;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.656 -0400", hash_original_method = "89F344582D255D48D3BC56CB8686027C", hash_generated_method = "B5D6353E8E64BFB79D75951539374FD3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void send(HandshakeIODataStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.write(client_version);
        out.write(random);
        out.writeUint8(session_id.length);
        out.write(session_id);
        int size;
        size = cipher_suites.length << 1;
        out.writeUint16(size);
        {
            int i;
            i = 0;
            {
                out.write(cipher_suites[i].toBytes());
            } //End block
        } //End collapsed parenthetic
        out.writeUint8(compression_methods.length);
        {
            int i;
            i = 0;
            {
                out.write(compression_methods[i]);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //out.write(client_version);
        //out.write(random);
        //out.writeUint8(session_id.length);
        //out.write(session_id);
        //int size = cipher_suites.length << 1;
        //out.writeUint16(size);
        //for (int i = 0; i < cipher_suites.length; i++) {
            //out.write(cipher_suites[i].toBytes());
        //}
        //out.writeUint8(compression_methods.length);
        //for (int i = 0; i < compression_methods.length; i++) {
            //out.write(compression_methods[i]);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.656 -0400", hash_original_method = "EDD7E5211887C4E217154E276BC2B61E", hash_generated_method = "008ED2AC815A0D40BB7DADF7F9678F58")
    @DSModeled(DSC.SAFE)
    public byte[] getRandom() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return random;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.656 -0400", hash_original_method = "CF19DA1ECE12A56ABD61504AAFBBFE23", hash_generated_method = "42A6DE80EE939E82E3E9061873BDB91E")
    @DSModeled(DSC.SAFE)
    @Override
    public int getType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Handshake.CLIENT_HELLO;
    }

    
}

