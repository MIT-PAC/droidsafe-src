package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.GeneralSecurityException;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.NullCipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLProtocolException;




public class ConnectionStateTLS extends ConnectionState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:11.560 -0500", hash_original_field = "4F425BFD35DE911FA82CD0B2BD6D4B47", hash_generated_field = "78310D04C76BEF7DDAAA4993644FDA12")

    // "key expansion".getBytes()
    private static byte[] KEY_EXPANSION_LABEL = {
        (byte) 0x6B, (byte) 0x65, (byte) 0x79, (byte) 0x20, (byte) 0x65,
        (byte) 0x78, (byte) 0x70, (byte) 0x61, (byte) 0x6E, (byte) 0x73,
        (byte) 0x69, (byte) 0x6F, (byte) 0x6E };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:11.561 -0500", hash_original_field = "E2037E1CA2A438047A6D230D66B66290", hash_generated_field = "03141D4442DE03CB1D96006A96ECABC7")

    private static byte[] CLIENT_WRITE_KEY_LABEL = {
        (byte) 0x63, (byte) 0x6C, (byte) 0x69, (byte) 0x65, (byte) 0x6E,
        (byte) 0x74, (byte) 0x20, (byte) 0x77, (byte) 0x72, (byte) 0x69,
        (byte) 0x74, (byte) 0x65, (byte) 0x20, (byte) 0x6B, (byte) 0x65,
        (byte) 0x79 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:11.562 -0500", hash_original_field = "67AAB164A883D345DBD9943CEE70AF3F", hash_generated_field = "2187DB19BDC5CED9C76C076C88F0005A")

    private static byte[] SERVER_WRITE_KEY_LABEL = {
        (byte) 0x73, (byte) 0x65, (byte) 0x72, (byte) 0x76, (byte) 0x65,
        (byte) 0x72, (byte) 0x20, (byte) 0x77, (byte) 0x72, (byte) 0x69,
        (byte) 0x74, (byte) 0x65, (byte) 0x20, (byte) 0x6B, (byte) 0x65,
        (byte) 0x79 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:11.563 -0500", hash_original_field = "2063C36D72CAB6B44145F32BE388DDCD", hash_generated_field = "BDE6D8351AF1668167AEDB127CBA6E19")

    private static byte[] IV_BLOCK_LABEL = {
        (byte) 0x49, (byte) 0x56, (byte) 0x20, (byte) 0x62, (byte) 0x6C,
        (byte) 0x6F, (byte) 0x63, (byte) 0x6B };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:11.563 -0500", hash_original_field = "6E6D289B0707CE2B44A2EF6E3D8CEDE3", hash_generated_field = "8EFC7A4F1C288592B3AB26CC617B3592")

    private  Mac encMac;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:11.564 -0500", hash_original_field = "FA5114D18D9A3ABD3F494970EC77051D", hash_generated_field = "51E887829C16E119E6B76A07E982A6A6")

    private  Mac decMac;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:11.565 -0500", hash_original_field = "366CBCF5B70427527595FBDFFD6D97BC", hash_generated_field = "CF41C83F36C0AF13D0D35A874EA4B54A")

    // is used to create the header of the MAC material value:
    // 5 == 1(TLSCompressed.type) + 2(TLSCompressed.version) +
    //      2(TLSCompressed.length)
    private final byte[] mac_material_header = new byte[] {0, 3, 1, 0, 0};

    /**
     * Creates the instance of TLS v1 Connection State. All of the
     * security parameters are provided by session object.
     * @param   session: the sessin object which incapsulates
     * all of the security parameters established by handshake protocol.
     * The key calculation for the state is done according
     * to the TLS v 1.0 Protocol specification.
     * (http://www.ietf.org/rfc/rfc2246.txt)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:11.567 -0500", hash_original_method = "983E273AE559F45D4EDE298176308BF7", hash_generated_method = "6876FAA0A14C8DDB8A1888D1F6A2F700")
    protected ConnectionStateTLS(SSLSessionImpl session) {
        try {
            CipherSuite cipherSuite = session.cipherSuite;

            hash_size = cipherSuite.getMACLength();
            boolean is_exportabe =  cipherSuite.isExportable();
            int key_size = (is_exportabe)
                ? cipherSuite.keyMaterial
                : cipherSuite.expandedKeyMaterial;
            int iv_size = cipherSuite.ivSize;
            block_size = cipherSuite.getBlockSize();

            String algName = cipherSuite.getBulkEncryptionAlgorithm();
            String macName = cipherSuite.getHmacName();
            if (logger != null) {
                logger.println("ConnectionStateTLS.create:");
                logger.println("  cipher suite name: "
                                            + cipherSuite.getName());
                logger.println("  encryption alg name: " + algName);
                logger.println("  mac alg name: " + macName);
                logger.println("  hash size: " + hash_size);
                logger.println("  block size: " + block_size);
                logger.println("  IV size:" + iv_size);
                logger.println("  key size: " + key_size);
            }

            byte[] clientRandom = session.clientRandom;
            byte[] serverRandom = session.serverRandom;
            // so we need PRF value of size of
            // 2*hash_size + 2*key_size + 2*iv_size
            byte[] key_block = new byte[2*hash_size + 2*key_size + 2*iv_size];
            byte[] seed = new byte[clientRandom.length + serverRandom.length];
            System.arraycopy(serverRandom, 0, seed, 0, serverRandom.length);
            System.arraycopy(clientRandom, 0, seed, serverRandom.length,
                    clientRandom.length);

            PRF.computePRF(key_block, session.master_secret,
                    KEY_EXPANSION_LABEL, seed);

            byte[] client_mac_secret = new byte[hash_size];
            byte[] server_mac_secret = new byte[hash_size];
            byte[] client_key = new byte[key_size];
            byte[] server_key = new byte[key_size];

            boolean is_client = !session.isServer;

            System.arraycopy(key_block, 0, client_mac_secret, 0, hash_size);
            System.arraycopy(key_block, hash_size,
                    server_mac_secret, 0, hash_size);
            System.arraycopy(key_block, 2*hash_size, client_key, 0, key_size);
            System.arraycopy(key_block, 2*hash_size+key_size,
                    server_key, 0, key_size);

            IvParameterSpec clientIV = null;
            IvParameterSpec serverIV = null;

            if (is_exportabe) {
                System.arraycopy(clientRandom, 0,
                        seed, 0, clientRandom.length);
                System.arraycopy(serverRandom, 0,
                        seed, clientRandom.length, serverRandom.length);
                byte[] final_client_key =
                    new byte[cipherSuite.expandedKeyMaterial];
                byte[] final_server_key =
                    new byte[cipherSuite.expandedKeyMaterial];
                PRF.computePRF(final_client_key, client_key,
                        CLIENT_WRITE_KEY_LABEL, seed);
                PRF.computePRF(final_server_key, server_key,
                        SERVER_WRITE_KEY_LABEL, seed);
                client_key = final_client_key;
                server_key = final_server_key;
                if (block_size != 0) {
                    byte[] iv_block = new byte[2*iv_size];
                    PRF.computePRF(iv_block, null, IV_BLOCK_LABEL, seed);
                    clientIV = new IvParameterSpec(iv_block, 0, iv_size);
                    serverIV = new IvParameterSpec(iv_block, iv_size, iv_size);
                }
            } else if (block_size != 0) {
                clientIV = new IvParameterSpec(key_block,
                        2*(hash_size+key_size), iv_size);
                serverIV = new IvParameterSpec(key_block,
                        2*(hash_size+key_size)+iv_size, iv_size);
            }

            if (logger != null) {
                logger.println("is exportable: "+is_exportabe);
                logger.println("master_secret");
                logger.print(session.master_secret);
                logger.println("client_random");
                logger.print(clientRandom);
                logger.println("server_random");
                logger.print(serverRandom);
                //logger.println("key_block");
                //logger.print(key_block);
                logger.println("client_mac_secret");
                logger.print(client_mac_secret);
                logger.println("server_mac_secret");
                logger.print(server_mac_secret);
                logger.println("client_key");
                logger.print(client_key);
                logger.println("server_key");
                logger.print(server_key);
                if (clientIV == null) {
                    logger.println("no IV.");
                } else {
                    logger.println("client_iv");
                    logger.print(clientIV.getIV());
                    logger.println("server_iv");
                    logger.print(serverIV.getIV());
                }
            }

            if (algName == null) {
                encCipher = new NullCipher();
                decCipher = new NullCipher();
            } else {
                encCipher = Cipher.getInstance(algName);
                decCipher = Cipher.getInstance(algName);
                if (is_client) { // client side
                    encCipher.init(Cipher.ENCRYPT_MODE,
                                   new SecretKeySpec(client_key, algName), clientIV);
                    decCipher.init(Cipher.DECRYPT_MODE,
                                   new SecretKeySpec(server_key, algName), serverIV);
                } else { // server side
                    encCipher.init(Cipher.ENCRYPT_MODE,
                                   new SecretKeySpec(server_key, algName), serverIV);
                    decCipher.init(Cipher.DECRYPT_MODE,
                                   new SecretKeySpec(client_key, algName), clientIV);
                }
            }

            encMac = Mac.getInstance(macName);
            decMac = Mac.getInstance(macName);
            if (is_client) { // client side
                encMac.init(new SecretKeySpec(client_mac_secret, macName));
                decMac.init(new SecretKeySpec(server_mac_secret, macName));
            } else { // server side
                encMac.init(new SecretKeySpec(server_mac_secret, macName));
                decMac.init(new SecretKeySpec(client_mac_secret, macName));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new AlertException(AlertProtocol.INTERNAL_ERROR,
                    new SSLProtocolException(
                        "Error during computation of security parameters"));
        }
    }

    /**
     * Creates the GenericStreamCipher or GenericBlockCipher
     * data structure for specified data of specified type.
     * @throws AlertException if alert was occurred.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:11.568 -0500", hash_original_method = "B9B8901A6530A5AA902AF1AE1DCFF588", hash_generated_method = "F8972AB866C91994CC0AFCC2BDFED45D")
    @Override
protected byte[] encrypt(byte type, byte[] fragment, int offset, int len) {
        try {
            int content_mac_length = len + hash_size;
            int padding_length = (block_size == 0) ? 0 : getPaddingSize(++content_mac_length);
            byte[] res = new byte[content_mac_length + padding_length];
            System.arraycopy(fragment, offset, res, 0, len);

            mac_material_header[0] = type;
            mac_material_header[3] = (byte) ((0x00FF00 & len) >> 8);
            mac_material_header[4] = (byte) (0x0000FF & len);

            encMac.update(write_seq_num);
            encMac.update(mac_material_header);
            encMac.update(fragment, offset, len);
            encMac.doFinal(res, len);

            //if (logger != null) {
            //    logger.println("MAC Material:");
            //    logger.print(write_seq_num);
            //    logger.print(mac_material_header);
            //    logger.print(fragment, offset, len);
            //}

            if (block_size != 0) {
                // do padding:
                Arrays.fill(res, content_mac_length-1,
                        res.length, (byte) (padding_length));
            }
            if (logger != null) {
                logger.println("SSLRecordProtocol.do_encryption: Generic"
                        + (block_size != 0
                            ? "BlockCipher with padding["+padding_length+"]:"
                            : "StreamCipher:"));
                logger.print(res);
            }
            byte[] rez = new byte[encCipher.getOutputSize(res.length)];
            // We should not call just doFinal because it reinitialize
            // the cipher, but as says rfc 2246:
            // "For stream ciphers that do not use a synchronization
            // vector (such as RC4), the stream cipher state from the end
            // of one record is simply used on the subsequent packet."
            // and for block ciphers:
            // "The IV for subsequent records is the last ciphertext block from
            // the previous record."
            // i.e. we should keep the cipher state.
            encCipher.update(res, 0, res.length, rez);
            incSequenceNumber(write_seq_num);
            return rez;
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
            throw new AlertException(AlertProtocol.INTERNAL_ERROR,
                    new SSLProtocolException("Error during the encryption"));
        }
    }

    /**
     * Retrieves the fragment of the Plaintext structure of
     * the specified type from the provided data representing
     * the Generic[Stream|Block]Cipher structure.
     * @throws AlertException if alert was occurred.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:11.569 -0500", hash_original_method = "A0319C4335A825139157822F68CBECCE", hash_generated_method = "ADE86886EFEDCE64F50DB21D25A6794B")
    @Override
protected byte[] decrypt(byte type, byte[] fragment,
            int offset, int len) {
        // plain data of the Generic[Stream|Block]Cipher structure
        byte[] data = decCipher.update(fragment, offset, len);
        // the 'content' part of the structure
        byte[] content;
        if (block_size != 0) {
            // check padding
            int padding_length = data[data.length-1];
            for (int i=0; i<padding_length; i++) {
                if (data[data.length-2-i] != padding_length) {
                    throw new AlertException(
                            AlertProtocol.DECRYPTION_FAILED,
                            new SSLProtocolException(
                                "Received message has bad padding"));
                }
            }
            content = new byte[data.length - hash_size - padding_length - 1];
        } else {
            content = new byte[data.length - hash_size];
        }

        mac_material_header[0] = type;
        mac_material_header[3] = (byte) ((0x00FF00 & content.length) >> 8);
        mac_material_header[4] = (byte) (0x0000FF & content.length);

        decMac.update(read_seq_num);
        decMac.update(mac_material_header);
        decMac.update(data, 0, content.length); // mac.update(fragment);
        byte[] mac_value = decMac.doFinal();
        if (logger != null) {
            logger.println("Decrypted:");
            logger.print(data);
            //logger.println("MAC Material:");
            //logger.print(read_seq_num);
            //logger.print(mac_material_header);
            //logger.print(data, 0, content.length);
            logger.println("Expected mac value:");
            logger.print(mac_value);
        }
        // checking the mac value
        for (int i=0; i<hash_size; i++) {
            if (mac_value[i] != data[i+content.length]) {
                throw new AlertException(AlertProtocol.BAD_RECORD_MAC,
                        new SSLProtocolException("Bad record MAC"));
            }
        }
        System.arraycopy(data, 0, content, 0, content.length);
        incSequenceNumber(read_seq_num);
        return content;
    }
}

