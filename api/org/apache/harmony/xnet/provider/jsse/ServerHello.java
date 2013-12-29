package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.security.SecureRandom;

import libcore.io.Streams;





public class ServerHello extends Message {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:12.288 -0500", hash_original_field = "459F4848AA92E1CD0637FF4F2809E745", hash_generated_field = "459F4848AA92E1CD0637FF4F2809E745")

    byte[] server_version = new byte[2];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:12.289 -0500", hash_original_field = "99091ADCC73FE81C2F7FCEF8EA8CC707", hash_generated_field = "99091ADCC73FE81C2F7FCEF8EA8CC707")

    byte[] random = new byte[32];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:12.289 -0500", hash_original_field = "464E487327E8A3D68CAEEB2871FE01AA", hash_generated_field = "464E487327E8A3D68CAEEB2871FE01AA")

    byte[] session_id;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:12.290 -0500", hash_original_field = "A81D6CEDC86413368148153BE0D55442", hash_generated_field = "A81D6CEDC86413368148153BE0D55442")

    CipherSuite cipher_suite;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:12.291 -0500", hash_original_field = "0D42E45E4884DABCFCE12BD7447CC09E", hash_generated_field = "0D42E45E4884DABCFCE12BD7447CC09E")

    byte compression_method;

    /**
     * Creates outbound message
     * @param sr
     * @param server_version
     * @param session_id
     * @param cipher_suite
     * @param compression_method
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:12.292 -0500", hash_original_method = "9AA41B9BF38033172F833E5120B7F6E3", hash_generated_method = "21295F50A856000D35FCE235E745C6DC")
    public ServerHello(SecureRandom sr, byte[] server_version,
            byte[] session_id, CipherSuite cipher_suite, byte compression_method) {
        long gmt_unix_time = new java.util.Date().getTime() / 1000;
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
    }

    /**
     * Creates inbound message
     * @param in
     * @param length
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:12.293 -0500", hash_original_method = "23655B86BFA253F8DFEBCBADE0DA1F73", hash_generated_method = "B1D7D4075D6AEAC29FB9F4ABA7263B55")
    public ServerHello(HandshakeIODataStream in, int length) throws IOException {

        server_version[0] = (byte) in.read();
        server_version[1] = (byte) in.read();
        Streams.readFully(in, random);
        int size = in.readUint8();
        session_id = new byte[size];
        in.read(session_id, 0, size);
        byte b0 = (byte) in.read();
        byte b1 = (byte) in.read();
        cipher_suite = CipherSuite.getByCode(b0, b1);
        compression_method = (byte) in.read();
        this.length = 38 + session_id.length;
        if (this.length != length) {
            fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect ServerHello");
        }

    }

    /**
     * Sends message
     * @param out
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:12.294 -0500", hash_original_method = "58B711F614C57C81491E703600BC8F27", hash_generated_method = "B00A61178886376BB0ED507E42165532")
    @Override
public void send(HandshakeIODataStream out) {
        out.write(server_version);
        out.write(random);
        out.writeUint8(session_id.length);
        out.write(session_id);
        out.write(cipher_suite.toBytes());
        out.write(compression_method);
        length = 38 + session_id.length;
    }

    /**
     * Returns server random
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:12.295 -0500", hash_original_method = "EDD7E5211887C4E217154E276BC2B61E", hash_generated_method = "AD106D7FEAE26F7078E90292C4E75999")
    public byte[] getRandom() {
        return random;
    }

    /**
     * Returns message type
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:12.296 -0500", hash_original_method = "51302607A7CDE0350AA8DCA604C2ADD7", hash_generated_method = "2841712EA3AB027EFC548258BB4CDAA4")
    @Override
public int getType() {
        return Handshake.SERVER_HELLO;
    }

    
}

