package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;

public class ServerKeyExchange extends Message {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.677 -0400", hash_original_field = "A4B5CEBA5CB5266E48EF58509253C548", hash_generated_field = "F2393EDA2114C170A28B32BCFE39CA4A")

    BigInteger par1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.677 -0400", hash_original_field = "A44801A7A0E742E9C7A7556B9B22A51D", hash_generated_field = "EACF62C123FC164BE029507CCE179CCF")

    byte[] bytes1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.677 -0400", hash_original_field = "E88C2E31C94DBA9E37EB394165345BE2", hash_generated_field = "49DF98649AA30F777A7B9E97B2259031")

    BigInteger par2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.677 -0400", hash_original_field = "23ACCEECF103768F091B36010844EA27", hash_generated_field = "A1E23DAADE58A1B5E338B97B1B783D02")

    byte[] bytes2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.678 -0400", hash_original_field = "B2CD717F860FE999FE1B3F4F4CBFD70D", hash_generated_field = "04ADECD493FBEAF3F6DA9C0D47888E6A")

    BigInteger par3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.678 -0400", hash_original_field = "DA1812648B0B1EC93962F174E6095D65", hash_generated_field = "A96D0DD7D69372A4FE08B07AE1E6E7B2")

    byte[] bytes3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.678 -0400", hash_original_field = "0800FC577294C34E0B28AD2839435945", hash_generated_field = "6195FCC77BFDBC9D95F3A31F9C19748F")

    byte[] hash;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.678 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "2C21B14519E4B3866FCF3554754DEBAE")

    private RSAPublicKey key;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.680 -0400", hash_original_method = "BAF04F24660E6C5095996548EBED85A1", hash_generated_method = "014A3310402719A730AA9214365124BC")
    public  ServerKeyExchange(BigInteger par1, BigInteger par2, BigInteger par3,
            byte[] hash) {
        this.par1 = par1;
        this.par2 = par2;
        this.par3 = par3;
        this.hash = hash;
        bytes1 = toUnsignedByteArray(this.par1);
        bytes2 = toUnsignedByteArray(this.par2);
        length = 4 + bytes1.length + bytes2.length;
    if(hash != null)        
        {
            length += 2 + hash.length;
        } //End block
    if(par3 == null)        
        {
            bytes3 = null;
            return;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.685 -0400", hash_original_method = "0FED75D6D7B207E32712BBEB8093B91D", hash_generated_method = "3E8DA7F8435B4C72CF941A1C5F30E6EA")
    public  ServerKeyExchange(HandshakeIODataStream in, int length,
            int keyExchange) throws IOException {
        addTaint(keyExchange);
        addTaint(length);
        int size = in.readUint16();
        bytes1 = in.read(size);
        par1 = new BigInteger(1, bytes1);
        this.length = 2 + bytes1.length;
        size = in.readUint16();
        bytes2 = in.read(size);
        par2 = new BigInteger(1, bytes2);
        this.length += 2 + bytes2.length;
    if(keyExchange != CipherSuite.KEY_EXCHANGE_RSA_EXPORT)        
        {
            size = in.readUint16();
            bytes3 = in.read(size);
            par3 = new BigInteger(1, bytes3);
            this.length += 2 + bytes3.length;
        } //End block
        else
        {
            par3 = null;
            bytes3 = null;
        } //End block
    if(keyExchange != CipherSuite.KEY_EXCHANGE_DH_anon_EXPORT
                && keyExchange != CipherSuite.KEY_EXCHANGE_DH_anon)        
        {
            size = in.readUint16();
            hash = in.read(size);
            this.length += 2 + hash.length;
        } //End block
        else
        {
            hash = null;
        } //End block
    if(this.length != length)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.687 -0400", hash_original_method = "2B7BAEA20D94561E69BFE5897EA1BEB9", hash_generated_method = "26707A5C2D788078CB431B2940CA17F6")
    @Override
    public void send(HandshakeIODataStream out) {
        addTaint(out.getTaint());
        out.writeUint16(bytes1.length);
        out.write(bytes1);
        out.writeUint16(bytes2.length);
        out.write(bytes2);
    if(bytes3 != null)        
        {
            out.writeUint16(bytes3.length);
            out.write(bytes3);
        } //End block
    if(hash != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.688 -0400", hash_original_method = "72FB1E0FC95B638A772EDD07E458B713", hash_generated_method = "EA2ED49E12359E3BBDBABBB6B316A6BD")
    public RSAPublicKey getRSAPublicKey() {
    if(key != null)        
        {
RSAPublicKey var6A95247616A3A8B93CFF7783DABD08D4_1885864872 =             key;
            var6A95247616A3A8B93CFF7783DABD08D4_1885864872.addTaint(taint);
            return var6A95247616A3A8B93CFF7783DABD08D4_1885864872;
        } //End block
        try 
        {
            KeyFactory kf = KeyFactory.getInstance("RSA");
            key = (RSAPublicKey) kf.generatePublic(new RSAPublicKeySpec(par1,
                    par2));
        } //End block
        catch (Exception e)
        {
RSAPublicKey var540C13E9E156B687226421B24F2DF178_161459358 =             null;
            var540C13E9E156B687226421B24F2DF178_161459358.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_161459358;
        } //End block
RSAPublicKey var6A95247616A3A8B93CFF7783DABD08D4_511960425 =         key;
        var6A95247616A3A8B93CFF7783DABD08D4_511960425.addTaint(taint);
        return var6A95247616A3A8B93CFF7783DABD08D4_511960425;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.689 -0400", hash_original_method = "620B9D3699DFA1CCAA0EB56AC40BC192", hash_generated_method = "63797F7AD4E910CEFC9B62FC7C6B11B4")
    @Override
    public int getType() {
        int var652F7368021684034DA1DE93A12D12E0_2021589586 = (Handshake.SERVER_KEY_EXCHANGE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_394836234 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_394836234;
        // ---------- Original Method ----------
        //return Handshake.SERVER_KEY_EXCHANGE;
    }

    
}

