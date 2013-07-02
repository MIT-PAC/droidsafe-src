package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.security.SecureRandom;
import libcore.io.Streams;

public class ServerHello extends Message {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.256 -0400", hash_original_field = "0E1AF9DC094ABB94D4A3E3D06C82935F", hash_generated_field = "459F4848AA92E1CD0637FF4F2809E745")

    byte[] server_version = new byte[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.256 -0400", hash_original_field = "207D91A53A99C0890FBC2F7C6872CC3D", hash_generated_field = "99091ADCC73FE81C2F7FCEF8EA8CC707")

    byte[] random = new byte[32];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.256 -0400", hash_original_field = "7FC8EF54A8154C28341BF9A47443A5CE", hash_generated_field = "464E487327E8A3D68CAEEB2871FE01AA")

    byte[] session_id;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.256 -0400", hash_original_field = "9A6393DA00519A757BFDC959428BEB1D", hash_generated_field = "A81D6CEDC86413368148153BE0D55442")

    CipherSuite cipher_suite;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.256 -0400", hash_original_field = "DB3AEE50C351C4180615C1A2BD01FF0A", hash_generated_field = "0D42E45E4884DABCFCE12BD7447CC09E")

    byte compression_method;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.257 -0400", hash_original_method = "9AA41B9BF38033172F833E5120B7F6E3", hash_generated_method = "AC9DD6788F467D87ECB15E6F19D64875")
    public  ServerHello(SecureRandom sr, byte[] server_version,
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
        addTaint(sr.getTaint());
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.257 -0400", hash_original_method = "23655B86BFA253F8DFEBCBADE0DA1F73", hash_generated_method = "C425330E080B5281287ECA787B822447")
    public  ServerHello(HandshakeIODataStream in, int length) throws IOException {
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
        {
            fatalAlert(AlertProtocol.DECODE_ERROR, "DECODE ERROR: incorrect ServerHello");
        } 
        addTaint(length);
        
        
        
        
        
        
        
        
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.258 -0400", hash_original_method = "58B711F614C57C81491E703600BC8F27", hash_generated_method = "F9C83BCB1D601E4FD82B8356902C7E65")
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
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.259 -0400", hash_original_method = "EDD7E5211887C4E217154E276BC2B61E", hash_generated_method = "1A6D9F56AC4210E92E47799E66BCB6CA")
    public byte[] getRandom() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_684625917 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_684625917;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.260 -0400", hash_original_method = "51302607A7CDE0350AA8DCA604C2ADD7", hash_generated_method = "0724E763C53DFBD1626EB631EBFFDF22")
    @Override
    public int getType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_179567336 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_179567336;
        
        
    }

    
}

