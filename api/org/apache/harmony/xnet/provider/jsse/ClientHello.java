package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Arrays;
import libcore.io.Streams;
import libcore.util.EmptyArray;

public class ClientHello extends Message {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.143 -0400", hash_original_field = "AD8EBE9263231F4547FD53D5849AC965", hash_generated_field = "87AFE8194BC492AFC7167BB3A54122B9")

    byte[] client_version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.143 -0400", hash_original_field = "207D91A53A99C0890FBC2F7C6872CC3D", hash_generated_field = "D668480B0E83A7483DCEBA9C8392548F")

    final byte[] random = new byte[32];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.143 -0400", hash_original_field = "7FC8EF54A8154C28341BF9A47443A5CE", hash_generated_field = "464E487327E8A3D68CAEEB2871FE01AA")

    byte[] session_id;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.143 -0400", hash_original_field = "A2AE8B2C9178F243D1D66776A3B6AE29", hash_generated_field = "A0A44A96F6DB28A1A612B3ED93B5B66F")

    CipherSuite[] cipher_suites;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.143 -0400", hash_original_field = "0A29CD02A8D38C8C61DF9A86DDBE1BAB", hash_generated_field = "47F40258F3E60116F552FCA9A35A3742")

    byte[] compression_methods;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.145 -0400", hash_original_method = "B360A744DA2558AEF3A4AD32A9DD66E9", hash_generated_method = "FFD2B2CAD76C273C2B27B53586298235")
    public  ClientHello(SecureRandom sr, byte[] version, byte[] ses_id,
            CipherSuite[] cipher_suite) {
        addTaint(sr.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.147 -0400", hash_original_method = "9848891785B38B606D088EC36D49C2E1", hash_generated_method = "BA28F8FB2240AF44C54308F741784EA7")
    public  ClientHello(HandshakeIODataStream in, int length) throws IOException {
        addTaint(length);
        client_version = new byte[2];
        client_version[0] = (byte) in.readUint8();
        client_version[1] = (byte) in.readUint8();
        Streams.readFully(in, random);
        int size = in.read();
        session_id = new byte[size];
        in.read(session_id, 0, size);
        int l = in.readUint16();
    if((l & 0x01) == 0x01)        
        {
            fatalAlert(AlertProtocol.DECODE_ERROR,
                    "DECODE ERROR: incorrect ClientHello");
        } //End block
        size = l >> 1;
        cipher_suites = new CipherSuite[size];
for(int i = 0;i < size;i++)
        {
            byte b0 = (byte) in.read();
            byte b1 = (byte) in.read();
            cipher_suites[i] = CipherSuite.getByCode(b0, b1);
        } //End block
        size = in.read();
        compression_methods = new byte[size];
        in.read(compression_methods, 0, size);
        this.length = 38 + session_id.length + (cipher_suites.length << 1)
                + compression_methods.length;
    if(this.length > length)        
        {
            fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect ClientHello");
        } //End block
    if(this.length < length)        
        {
            in.skip(length - this.length);
            this.length = length;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.149 -0400", hash_original_method = "092EDC6A6C17B41B7BF7C969F19C771C", hash_generated_method = "CA49944348A00565B338B86632135D1F")
    public  ClientHello(HandshakeIODataStream in) throws IOException {
    if(in.readUint8() != 1)        
        {
            fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect V2ClientHello");
        } //End block
        client_version = new byte[2];
        client_version[0] = (byte) in.readUint8();
        client_version[1] = (byte) in.readUint8();
        int cipher_spec_length = in.readUint16();
    if(in.readUint16() != 0)        
        {
            fatalAlert(AlertProtocol.DECODE_ERROR,
                    "DECODE ERROR: incorrect V2ClientHello, cannot be used for resuming");
        } //End block
        int challenge_length = in.readUint16();
    if(challenge_length < 16)        
        {
            fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect V2ClientHello, short challenge data");
        } //End block
        session_id = EmptyArray.BYTE;
        cipher_suites = new CipherSuite[cipher_spec_length/3];
for(int i = 0;i < cipher_suites.length;i++)
        {
            byte b0 = (byte) in.read();
            byte b1 = (byte) in.read();
            byte b2 = (byte) in.read();
            cipher_suites[i] = CipherSuite.getByCode(b0, b1, b2);
        } //End block
        compression_methods = new byte[] { 0 };
    if(challenge_length < 32)        
        {
            Arrays.fill(random, 0, 32 - challenge_length, (byte)0);
            System.arraycopy(in.read(challenge_length), 0, random, 32 - challenge_length, challenge_length);
        } //End block
        else
    if(challenge_length == 32)        
        {
            System.arraycopy(in.read(32), 0, random, 0, 32);
        } //End block
        else
        {
            System.arraycopy(in.read(challenge_length), challenge_length - 32, random, 0, 32);
        } //End block
    if(in.available() > 0)        
        {
            fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect V2ClientHello, extra data");
        } //End block
        this.length = 38 + session_id.length + (cipher_suites.length << 1)
                + compression_methods.length;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.150 -0400", hash_original_method = "89F344582D255D48D3BC56CB8686027C", hash_generated_method = "B14597BF86D209FD8A2BBB6F8E95E874")
    @Override
    public void send(HandshakeIODataStream out) {
        addTaint(out.getTaint());
        out.write(client_version);
        out.write(random);
        out.writeUint8(session_id.length);
        out.write(session_id);
        int size = cipher_suites.length << 1;
        out.writeUint16(size);
for(int i = 0;i < cipher_suites.length;i++)
        {
            out.write(cipher_suites[i].toBytes());
        } //End block
        out.writeUint8(compression_methods.length);
for(int i = 0;i < compression_methods.length;i++)
        {
            out.write(compression_methods[i]);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.150 -0400", hash_original_method = "EDD7E5211887C4E217154E276BC2B61E", hash_generated_method = "F1CF4F7F6C2913E867938921546A1EEB")
    public byte[] getRandom() {
        byte[] var7DDF32E17A6AC5CE04A8ECBF782CA509_475078483 = (random);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_496490283 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_496490283;
        // ---------- Original Method ----------
        //return random;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.151 -0400", hash_original_method = "CF19DA1ECE12A56ABD61504AAFBBFE23", hash_generated_method = "FFA7C40C3CB9258706847A42638636DC")
    @Override
    public int getType() {
        int varE71280FEA2F0862AC622F392C3B87AED_1591167262 = (Handshake.CLIENT_HELLO);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_403199118 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_403199118;
        // ---------- Original Method ----------
        //return Handshake.CLIENT_HELLO;
    }

    
}

