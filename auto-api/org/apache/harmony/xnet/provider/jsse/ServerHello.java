package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.security.SecureRandom;
import libcore.io.Streams;

public class ServerHello extends Message {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.079 -0400", hash_original_field = "0E1AF9DC094ABB94D4A3E3D06C82935F", hash_generated_field = "459F4848AA92E1CD0637FF4F2809E745")

    byte[] server_version = new byte[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.080 -0400", hash_original_field = "207D91A53A99C0890FBC2F7C6872CC3D", hash_generated_field = "99091ADCC73FE81C2F7FCEF8EA8CC707")

    byte[] random = new byte[32];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.080 -0400", hash_original_field = "7FC8EF54A8154C28341BF9A47443A5CE", hash_generated_field = "464E487327E8A3D68CAEEB2871FE01AA")

    byte[] session_id;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.080 -0400", hash_original_field = "9A6393DA00519A757BFDC959428BEB1D", hash_generated_field = "A81D6CEDC86413368148153BE0D55442")

    CipherSuite cipher_suite;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.080 -0400", hash_original_field = "DB3AEE50C351C4180615C1A2BD01FF0A", hash_generated_field = "0D42E45E4884DABCFCE12BD7447CC09E")

    byte compression_method;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.090 -0400", hash_original_method = "9AA41B9BF38033172F833E5120B7F6E3", hash_generated_method = "0D159F400D6E8DE09611445FF6D85894")
    public  ServerHello(SecureRandom sr, byte[] server_version,
            byte[] session_id, CipherSuite cipher_suite, byte compression_method) {
        long gmt_unix_time;
        gmt_unix_time = new java.util.Date().getTime() / 1000;
        sr.nextBytes(random);
        random[0] = (byte) ((gmt_unix_time & 0xFF000000) >>> 24);
        random[1] = (byte) ((gmt_unix_time & 0xFF0000) >>> 16);
        random[2] = (byte) ((gmt_unix_time & 0xFF00) >>> 8);
        random[3] = (byte) (gmt_unix_time & 0xFF);
        this.session_id = session_id;
        this.cipher_suite = cipher_suite;
        this.compression_method = compression_method;
        this.server_version = server_version;
        length = 38 + session_id.length;
        addTaint(sr.getTaint());
        // ---------- Original Method ----------
        //long gmt_unix_time = new java.util.Date().getTime() / 1000;
        //sr.nextBytes(random);
        //random[0] = (byte) ((gmt_unix_time & 0xFF000000) >>> 24);
        //random[1] = (byte) ((gmt_unix_time & 0xFF0000) >>> 16);
        //random[2] = (byte) ((gmt_unix_time & 0xFF00) >>> 8);
        //random[3] = (byte) (gmt_unix_time & 0xFF);
        //this.session_id = session_id;
        //this.cipher_suite = cipher_suite;
        //this.compression_method = compression_method;
        //this.server_version = server_version;
        //length = 38 + session_id.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.091 -0400", hash_original_method = "23655B86BFA253F8DFEBCBADE0DA1F73", hash_generated_method = "DD255D0C2B53ED2AF46FBAC6BA10602C")
    public  ServerHello(HandshakeIODataStream in, int length) throws IOException {
        server_version[0] = (byte) in.read();
        server_version[1] = (byte) in.read();
        Streams.readFully(in, random);
        int size;
        size = in.readUint8();
        session_id = new byte[size];
        in.read(session_id, 0, size);
        byte b0;
        b0 = (byte) in.read();
        byte b1;
        b1 = (byte) in.read();
        cipher_suite = CipherSuite.getByCode(b0, b1);
        compression_method = (byte) in.read();
        this.length = 38 + session_id.length;
        {
            fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect ServerHello");
        } //End block
        addTaint(length);
        // ---------- Original Method ----------
        //server_version[0] = (byte) in.read();
        //server_version[1] = (byte) in.read();
        //Streams.readFully(in, random);
        //int size = in.readUint8();
        //session_id = new byte[size];
        //in.read(session_id, 0, size);
        //byte b0 = (byte) in.read();
        //byte b1 = (byte) in.read();
        //cipher_suite = CipherSuite.getByCode(b0, b1);
        //compression_method = (byte) in.read();
        //this.length = 38 + session_id.length;
        //if (this.length != length) {
            //fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect ServerHello");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.094 -0400", hash_original_method = "58B711F614C57C81491E703600BC8F27", hash_generated_method = "F9C83BCB1D601E4FD82B8356902C7E65")
    @Override
    public void send(HandshakeIODataStream out) {
        out.write(server_version);
        out.write(random);
        out.writeUint8(session_id.length);
        out.write(session_id);
        out.write(cipher_suite.toBytes());
        out.write(compression_method);
        length = 38 + session_id.length;
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.write(server_version);
        //out.write(random);
        //out.writeUint8(session_id.length);
        //out.write(session_id);
        //out.write(cipher_suite.toBytes());
        //out.write(compression_method);
        //length = 38 + session_id.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.094 -0400", hash_original_method = "EDD7E5211887C4E217154E276BC2B61E", hash_generated_method = "9B1BEE93A2D3124ECEB7DB2B5B939494")
    public byte[] getRandom() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1374720079 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1374720079;
        // ---------- Original Method ----------
        //return random;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.094 -0400", hash_original_method = "51302607A7CDE0350AA8DCA604C2ADD7", hash_generated_method = "51E19A83235D1EF68E204DF27F30CFD8")
    @Override
    public int getType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1410856718 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1410856718;
        // ---------- Original Method ----------
        //return Handshake.SERVER_HELLO;
    }

    
}

