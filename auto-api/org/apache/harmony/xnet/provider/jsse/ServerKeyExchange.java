package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;

public class ServerKeyExchange extends Message {
    BigInteger par1;
    byte[] bytes1;
    BigInteger par2;
    byte[] bytes2;
    BigInteger par3;
    byte[] bytes3;
    byte[] hash;
    private RSAPublicKey key;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.394 -0400", hash_original_method = "BAF04F24660E6C5095996548EBED85A1", hash_generated_method = "EB3D12F8ED749ECCA2A253E2E1CF03DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServerKeyExchange(BigInteger par1, BigInteger par2, BigInteger par3,
            byte[] hash) {
        dsTaint.addTaint(hash[0]);
        dsTaint.addTaint(par3.dsTaint);
        dsTaint.addTaint(par2.dsTaint);
        dsTaint.addTaint(par1.dsTaint);
        bytes1 = toUnsignedByteArray(this.par1);
        bytes2 = toUnsignedByteArray(this.par2);
        length = 4 + bytes1.length + bytes2.length;
        {
            length += 2 + hash.length;
        } //End block
        {
            bytes3 = null;
        } //End block
        bytes3 = toUnsignedByteArray(this.par3);
        length += 2 + bytes3.length;
        // ---------- Original Method ----------
        //this.par1 = par1;
        //this.par2 = par2;
        //this.par3 = par3;
        //this.hash = hash;
        //bytes1 = toUnsignedByteArray(this.par1);
        //bytes2 = toUnsignedByteArray(this.par2);
        //length = 4 + bytes1.length + bytes2.length;
        //if (hash != null) {
            //length += 2 + hash.length;
        //}
        //if (par3 == null) {
            //bytes3 = null;
            //return;
        //}
        //bytes3 = toUnsignedByteArray(this.par3);
        //length += 2 + bytes3.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.394 -0400", hash_original_method = "0FED75D6D7B207E32712BBEB8093B91D", hash_generated_method = "BEF8B1F4F22A6A0CE1E3C3E57B794E10")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServerKeyExchange(HandshakeIODataStream in, int length,
            int keyExchange) throws IOException {
        dsTaint.addTaint(length);
        dsTaint.addTaint(keyExchange);
        dsTaint.addTaint(in.dsTaint);
        int size;
        size = in.readUint16();
        bytes1 = in.read(size);
        par1 = new BigInteger(1, bytes1);
        this.length = 2 + bytes1.length;
        size = in.readUint16();
        bytes2 = in.read(size);
        par2 = new BigInteger(1, bytes2);
        this.length += 2 + bytes2.length;
        {
            size = in.readUint16();
            bytes3 = in.read(size);
            par3 = new BigInteger(1, bytes3);
            this.length += 2 + bytes3.length;
        } //End block
        {
            par3 = null;
            bytes3 = null;
        } //End block
        {
            size = in.readUint16();
            hash = in.read(size);
            this.length += 2 + hash.length;
        } //End block
        {
            hash = null;
        } //End block
        {
            fatalAlert(AlertProtocol.DECODE_ERROR,
                    "DECODE ERROR: incorrect ServerKeyExchange");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static byte[] toUnsignedByteArray(BigInteger bi) {
        if (bi == null) {
            return null;
        }
        byte[] bb = bi.toByteArray();
        if (bb[0] == 0) {
            byte[] noZero = new byte[bb.length - 1];
            System.arraycopy(bb, 1, noZero, 0, noZero.length);
            return noZero;
        } else {
            return bb;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.395 -0400", hash_original_method = "2B7BAEA20D94561E69BFE5897EA1BEB9", hash_generated_method = "413A4438EAE06EED12C6FF676ECC1D79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void send(HandshakeIODataStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.writeUint16(bytes1.length);
        out.write(bytes1);
        out.writeUint16(bytes2.length);
        out.write(bytes2);
        {
            out.writeUint16(bytes3.length);
            out.write(bytes3);
        } //End block
        {
            out.writeUint16(hash.length);
            out.write(hash);
        } //End block
        // ---------- Original Method ----------
        //out.writeUint16(bytes1.length);
        //out.write(bytes1);
        //out.writeUint16(bytes2.length);
        //out.write(bytes2);
        //if (bytes3 != null) {
            //out.writeUint16(bytes3.length);
            //out.write(bytes3);
        //}
        //if (hash != null) {
            //out.writeUint16(hash.length);
            //out.write(hash);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.395 -0400", hash_original_method = "72FB1E0FC95B638A772EDD07E458B713", hash_generated_method = "01757745249D344512C8173EABB5D3A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RSAPublicKey getRSAPublicKey() {
        try 
        {
            KeyFactory kf;
            kf = KeyFactory.getInstance("RSA");
            key = (RSAPublicKey) kf.generatePublic(new RSAPublicKeySpec(par1,
                    par2));
        } //End block
        catch (Exception e)
        { }
        return (RSAPublicKey)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (key != null) {
            //return key;
        //}
        //try {
            //KeyFactory kf = KeyFactory.getInstance("RSA");
            //key = (RSAPublicKey) kf.generatePublic(new RSAPublicKeySpec(par1,
                    //par2));
        //} catch (Exception e) {
            //return null;
        //}
        //return key;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.395 -0400", hash_original_method = "620B9D3699DFA1CCAA0EB56AC40BC192", hash_generated_method = "7F738F7937F26D158004C690D6AD0691")
    @DSModeled(DSC.SAFE)
    @Override
    public int getType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Handshake.SERVER_KEY_EXCHANGE;
    }

    
}

