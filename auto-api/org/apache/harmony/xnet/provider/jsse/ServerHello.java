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
    byte[] server_version = new byte[2];
    byte[] random = new byte[32];
    byte[] session_id;
    CipherSuite cipher_suite;
    byte compression_method;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.380 -0400", hash_original_method = "9AA41B9BF38033172F833E5120B7F6E3", hash_generated_method = "0B34965558AF1858143E769DE9DE8339")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServerHello(SecureRandom sr, byte[] server_version,
            byte[] session_id, CipherSuite cipher_suite, byte compression_method) {
        dsTaint.addTaint(session_id[0]);
        dsTaint.addTaint(compression_method);
        dsTaint.addTaint(server_version[0]);
        dsTaint.addTaint(sr.dsTaint);
        dsTaint.addTaint(cipher_suite.dsTaint);
        long gmt_unix_time;
        gmt_unix_time = new java.util.Date().getTime() / 1000;
        sr.nextBytes(random);
        random[0] = (byte) ((gmt_unix_time & 0xFF000000) >>> 24);
        random[1] = (byte) ((gmt_unix_time & 0xFF0000) >>> 16);
        random[2] = (byte) ((gmt_unix_time & 0xFF00) >>> 8);
        random[3] = (byte) (gmt_unix_time & 0xFF);
        length = 38 + session_id.length;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.381 -0400", hash_original_method = "23655B86BFA253F8DFEBCBADE0DA1F73", hash_generated_method = "CCF194FEC5AAF3E2D9D7CD299FF05AE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServerHello(HandshakeIODataStream in, int length) throws IOException {
        dsTaint.addTaint(length);
        dsTaint.addTaint(in.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.381 -0400", hash_original_method = "58B711F614C57C81491E703600BC8F27", hash_generated_method = "2ED0DCB8D8868A602B91CFE082BC3A93")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void send(HandshakeIODataStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.write(server_version);
        out.write(random);
        out.writeUint8(session_id.length);
        out.write(session_id);
        out.write(cipher_suite.toBytes());
        out.write(compression_method);
        length = 38 + session_id.length;
        // ---------- Original Method ----------
        //out.write(server_version);
        //out.write(random);
        //out.writeUint8(session_id.length);
        //out.write(session_id);
        //out.write(cipher_suite.toBytes());
        //out.write(compression_method);
        //length = 38 + session_id.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.381 -0400", hash_original_method = "EDD7E5211887C4E217154E276BC2B61E", hash_generated_method = "008ED2AC815A0D40BB7DADF7F9678F58")
    @DSModeled(DSC.SAFE)
    public byte[] getRandom() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return random;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.382 -0400", hash_original_method = "51302607A7CDE0350AA8DCA604C2ADD7", hash_generated_method = "E3C55E1BE0D6EA9BD95826812934743F")
    @DSModeled(DSC.SAFE)
    @Override
    public int getType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Handshake.SERVER_HELLO;
    }

    
}

