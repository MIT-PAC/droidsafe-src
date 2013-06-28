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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.880 -0400", hash_original_field = "AD8EBE9263231F4547FD53D5849AC965", hash_generated_field = "87AFE8194BC492AFC7167BB3A54122B9")

    byte[] client_version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.880 -0400", hash_original_field = "207D91A53A99C0890FBC2F7C6872CC3D", hash_generated_field = "D668480B0E83A7483DCEBA9C8392548F")

    final byte[] random = new byte[32];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.880 -0400", hash_original_field = "7FC8EF54A8154C28341BF9A47443A5CE", hash_generated_field = "464E487327E8A3D68CAEEB2871FE01AA")

    byte[] session_id;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.880 -0400", hash_original_field = "A2AE8B2C9178F243D1D66776A3B6AE29", hash_generated_field = "A0A44A96F6DB28A1A612B3ED93B5B66F")

    CipherSuite[] cipher_suites;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.880 -0400", hash_original_field = "0A29CD02A8D38C8C61DF9A86DDBE1BAB", hash_generated_field = "47F40258F3E60116F552FCA9A35A3742")

    byte[] compression_methods;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.881 -0400", hash_original_method = "B360A744DA2558AEF3A4AD32A9DD66E9", hash_generated_method = "CCF127010845E50DE4D7EE0247D49E78")
    public  ClientHello(SecureRandom sr, byte[] version, byte[] ses_id,
            CipherSuite[] cipher_suite) {
        client_version = version;
        long gmt_unix_time = System.currentTimeMillis()/1000;
        sr.nextBytes(random);
        random[0] = (byte) (gmt_unix_time & 0xFF000000 >>> 24);
        random[1] = (byte) (gmt_unix_time & 0xFF0000 >>> 16);
        random[2] = (byte) (gmt_unix_time & 0xFF00 >>> 8);
        random[3] = (byte) (gmt_unix_time & 0xFF);
        session_id = ses_id;
        this.cipher_suites = cipher_suite;
        compression_methods = new byte[] { 0 };
        length = 38 + session_id.length + (this.cipher_suites.length << 1)
                + compression_methods.length;
        addTaint(sr.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.882 -0400", hash_original_method = "9848891785B38B606D088EC36D49C2E1", hash_generated_method = "9840E7CC21BDB5FB14D5A18DBD7F899C")
    public  ClientHello(HandshakeIODataStream in, int length) throws IOException {
        client_version = new byte[2];
        client_version[0] = (byte) in.readUint8();
        client_version[1] = (byte) in.readUint8();
        Streams.readFully(in, random);
        int size = in.read();
        session_id = new byte[size];
        in.read(session_id, 0, size);
        int l = in.readUint16();
        {
            fatalAlert(AlertProtocol.DECODE_ERROR,
                    "DECODE ERROR: incorrect ClientHello");
        } //End block
        size = l >> 1;
        cipher_suites = new CipherSuite[size];
        {
            int i = 0;
            {
                byte b0 = (byte) in.read();
                byte b1 = (byte) in.read();
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
        addTaint(length);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.884 -0400", hash_original_method = "092EDC6A6C17B41B7BF7C969F19C771C", hash_generated_method = "495C57DA3EA4280E348A6E29E8C26317")
    public  ClientHello(HandshakeIODataStream in) throws IOException {
        {
            boolean var022F181FCD3ECCEDD53D5E77DDFAF49D_2009087539 = (in.readUint8() != 1);
            {
                fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect V2ClientHello");
            } //End block
        } //End collapsed parenthetic
        client_version = new byte[2];
        client_version[0] = (byte) in.readUint8();
        client_version[1] = (byte) in.readUint8();
        int cipher_spec_length = in.readUint16();
        {
            boolean varDCD0C84AEEE1853740202846CF98E636_1878180798 = (in.readUint16() != 0);
            {
                fatalAlert(AlertProtocol.DECODE_ERROR,
                    "DECODE ERROR: incorrect V2ClientHello, cannot be used for resuming");
            } //End block
        } //End collapsed parenthetic
        int challenge_length = in.readUint16();
        {
            fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect V2ClientHello, short challenge data");
        } //End block
        session_id = EmptyArray.BYTE;
        cipher_suites = new CipherSuite[cipher_spec_length/3];
        {
            int i = 0;
            {
                byte b0 = (byte) in.read();
                byte b1 = (byte) in.read();
                byte b2 = (byte) in.read();
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
            boolean varE684FF4D92AACF44A45D4FF9CA23ABC5_1144675224 = (in.available() > 0);
            {
                fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect V2ClientHello, extra data");
            } //End block
        } //End collapsed parenthetic
        this.length = 38 + session_id.length + (cipher_suites.length << 1)
                + compression_methods.length;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.884 -0400", hash_original_method = "89F344582D255D48D3BC56CB8686027C", hash_generated_method = "CE6AB30DE3BD6FCC627925BD87406F79")
    @Override
    public void send(HandshakeIODataStream out) {
        out.write(client_version);
        out.write(random);
        out.writeUint8(session_id.length);
        out.write(session_id);
        int size = cipher_suites.length << 1;
        out.writeUint16(size);
        {
            int i = 0;
            {
                out.write(cipher_suites[i].toBytes());
            } //End block
        } //End collapsed parenthetic
        out.writeUint8(compression_methods.length);
        {
            int i = 0;
            {
                out.write(compression_methods[i]);
            } //End block
        } //End collapsed parenthetic
        addTaint(out.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.885 -0400", hash_original_method = "EDD7E5211887C4E217154E276BC2B61E", hash_generated_method = "2B6CFFC1725BAC857D96065DA5E6BD90")
    public byte[] getRandom() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1740665797 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1740665797;
        // ---------- Original Method ----------
        //return random;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.885 -0400", hash_original_method = "CF19DA1ECE12A56ABD61504AAFBBFE23", hash_generated_method = "BC6AA7BA21BD59684C76A21EF481FD17")
    @Override
    public int getType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_354222949 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_354222949;
        // ---------- Original Method ----------
        //return Handshake.CLIENT_HELLO;
    }

    
}

