package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;






public class ServerKeyExchange extends Message {

    /**
     * Remove first byte if 0. Needed because BigInteger.toByteArray() sometimes
     * returns a zero prefix.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.676 -0500", hash_original_method = "742AAF4B41AFCCB3DF4DF84474592F25", hash_generated_method = "DB47A975A9AC8C2C01808AEA60F19D71")
    
public static byte[] toUnsignedByteArray(BigInteger bi) {
        if (bi == null) {
            return null;
        }
        byte[] bb = bi.toByteArray();
        // bb is not null, and has at least 1 byte - ZERO is represented as [0]
        if (bb[0] == 0) {
            byte[] noZero = new byte[bb.length - 1];
            System.arraycopy(bb, 1, noZero, 0, noZero.length);
            return noZero;
        } else {
            return bb;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.654 -0500", hash_original_field = "F2393EDA2114C170A28B32BCFE39CA4A", hash_generated_field = "F2393EDA2114C170A28B32BCFE39CA4A")

     BigInteger par1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.657 -0500", hash_original_field = "EACF62C123FC164BE029507CCE179CCF", hash_generated_field = "EACF62C123FC164BE029507CCE179CCF")

     byte[] bytes1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.659 -0500", hash_original_field = "49DF98649AA30F777A7B9E97B2259031", hash_generated_field = "49DF98649AA30F777A7B9E97B2259031")


     BigInteger par2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.662 -0500", hash_original_field = "A1E23DAADE58A1B5E338B97B1B783D02", hash_generated_field = "A1E23DAADE58A1B5E338B97B1B783D02")

     byte[] bytes2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.664 -0500", hash_original_field = "04ADECD493FBEAF3F6DA9C0D47888E6A", hash_generated_field = "04ADECD493FBEAF3F6DA9C0D47888E6A")


     BigInteger par3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.666 -0500", hash_original_field = "A96D0DD7D69372A4FE08B07AE1E6E7B2", hash_generated_field = "A96D0DD7D69372A4FE08B07AE1E6E7B2")

     byte[] bytes3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.668 -0500", hash_original_field = "6195FCC77BFDBC9D95F3A31F9C19748F", hash_generated_field = "6195FCC77BFDBC9D95F3A31F9C19748F")

     byte[] hash;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.670 -0500", hash_original_field = "F63DCAD7F3A074B3619ED6D0D6ADB2CE", hash_generated_field = "2C21B14519E4B3866FCF3554754DEBAE")


    private RSAPublicKey key;

    /**
     * Creates outbound message
     * @param par1 rsa_modulus or dh_p
     * @param par2 rsa_exponent or dh_g
     * @param par3 dh_Ys for ServerDHParams; should be null for ServerRSAParams
     * @param hash should be null for anonymous SignatureAlgorithm
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.673 -0500", hash_original_method = "BAF04F24660E6C5095996548EBED85A1", hash_generated_method = "2776557779CA2C278A208A7575A76BF4")
    
public ServerKeyExchange(BigInteger par1, BigInteger par2, BigInteger par3,
            byte[] hash) {
        this.par1 = par1;
        this.par2 = par2;
        this.par3 = par3;
        this.hash = hash;

        bytes1 = toUnsignedByteArray(this.par1);

        bytes2 = toUnsignedByteArray(this.par2);

        length = 4 + bytes1.length + bytes2.length;
        if (hash != null) {
            length += 2 + hash.length;
        }
        if (par3 == null) {
            bytes3 = null;
            return;
        }
        bytes3 = toUnsignedByteArray(this.par3);
        length += 2 + bytes3.length;
    }

    /**
     * Creates inbound message
     * @param in
     * @param length
     * @param keyExchange
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.679 -0500", hash_original_method = "0FED75D6D7B207E32712BBEB8093B91D", hash_generated_method = "6FC8ED0338E954EB3F74DF47F1EE5440")
    
public ServerKeyExchange(HandshakeIODataStream in, int length,
            int keyExchange) throws IOException {

        int size = in.readUint16();
        bytes1 = in.read(size);
        par1 = new BigInteger(1, bytes1);
        this.length = 2 + bytes1.length;
        size = in.readUint16();
        bytes2 = in.read(size);
        par2 = new BigInteger(1, bytes2);
        this.length += 2 + bytes2.length;
        if (keyExchange != CipherSuite.KEY_EXCHANGE_RSA_EXPORT) {
            size = in.readUint16();
            bytes3 = in.read(size);
            par3 = new BigInteger(1, bytes3);
            this.length += 2 + bytes3.length;
        } else {
            par3 = null;
            bytes3 = null;
        }
        if (keyExchange != CipherSuite.KEY_EXCHANGE_DH_anon_EXPORT
                && keyExchange != CipherSuite.KEY_EXCHANGE_DH_anon) {
            size = in.readUint16();
            hash = in.read(size);
            this.length += 2 + hash.length;
        } else {
            hash = null;
        }
        if (this.length != length) {
            fatalAlert(AlertProtocol.DECODE_ERROR,
                    "DECODE ERROR: incorrect ServerKeyExchange");
        }
    }

    /**
     * Sends message
     * @param out
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.682 -0500", hash_original_method = "2B7BAEA20D94561E69BFE5897EA1BEB9", hash_generated_method = "316B677311269FE7A70880051EF64718")
    
@Override
    public void send(HandshakeIODataStream out) {
        out.writeUint16(bytes1.length);
        out.write(bytes1);
        out.writeUint16(bytes2.length);
        out.write(bytes2);
        if (bytes3 != null) {
            out.writeUint16(bytes3.length);
            out.write(bytes3);
        }
        if (hash != null) {
            out.writeUint16(hash.length);
            out.write(hash);
        }
    }

    /**
     * Returns RSAPublicKey generated using ServerRSAParams
     * (rsa_modulus and rsa_exponent).
     *
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.684 -0500", hash_original_method = "72FB1E0FC95B638A772EDD07E458B713", hash_generated_method = "5CC42133DB9D05A4256503D09C60F486")
    
public RSAPublicKey getRSAPublicKey() {
        if (key != null) {
            return key;
        }
        try {
            KeyFactory kf = KeyFactory.getInstance("RSA");
            key = (RSAPublicKey) kf.generatePublic(new RSAPublicKeySpec(par1,
                    par2));
        } catch (Exception e) {
            return null;
        }
        return key;
    }

    /**
     * Returns message type
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:17.687 -0500", hash_original_method = "620B9D3699DFA1CCAA0EB56AC40BC192", hash_generated_method = "5AF29C62290EC2907F6A69FAFE3ED111")
    
@Override
    public int getType() {
        return Handshake.SERVER_KEY_EXCHANGE;
    }

    
}

