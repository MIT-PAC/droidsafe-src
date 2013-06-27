package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.NullCipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLProtocolException;

public class ConnectionStateTLS extends ConnectionState {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.915 -0400", hash_original_field = "E0BC9005FCA6DD6D01FDAF621E6B05BF", hash_generated_field = "8EFC7A4F1C288592B3AB26CC617B3592")

    private Mac encMac;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.916 -0400", hash_original_field = "84C3A68C014535ADCE9C7C0179A1EB44", hash_generated_field = "51E887829C16E119E6B76A07E982A6A6")

    private Mac decMac;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.916 -0400", hash_original_field = "F119236CA59ECCBFFA641A3A68808615", hash_generated_field = "E364DDD13A180721EE5CD83B799348E0")

    private byte[] mac_material_header = new byte[] {0, 3, 1, 0, 0};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.932 -0400", hash_original_method = "983E273AE559F45D4EDE298176308BF7", hash_generated_method = "A0FB42CF46462D6B7669136CC835C807")
    protected  ConnectionStateTLS(SSLSessionImpl session) {
        try 
        {
            CipherSuite cipherSuite;
            cipherSuite = session.cipherSuite;
            hash_size = cipherSuite.getMACLength();
            boolean is_exportabe;
            is_exportabe = cipherSuite.isExportable();
            int key_size;
            key_size = cipherSuite.keyMaterial;
            key_size = cipherSuite.expandedKeyMaterial;
            int iv_size;
            iv_size = cipherSuite.ivSize;
            block_size = cipherSuite.getBlockSize();
            String algName;
            algName = cipherSuite.getBulkEncryptionAlgorithm();
            String macName;
            macName = cipherSuite.getHmacName();
            {
                logger.println("ConnectionStateTLS.create:");
                logger.println("  cipher suite name: "
                                            + cipherSuite.getName());
                logger.println("  encryption alg name: " + algName);
                logger.println("  mac alg name: " + macName);
                logger.println("  hash size: " + hash_size);
                logger.println("  block size: " + block_size);
                logger.println("  IV size:" + iv_size);
                logger.println("  key size: " + key_size);
            } //End block
            byte[] clientRandom;
            clientRandom = session.clientRandom;
            byte[] serverRandom;
            serverRandom = session.serverRandom;
            byte[] key_block;
            key_block = new byte[2*hash_size + 2*key_size + 2*iv_size];
            byte[] seed;
            seed = new byte[clientRandom.length + serverRandom.length];
            System.arraycopy(serverRandom, 0, seed, 0, serverRandom.length);
            System.arraycopy(clientRandom, 0, seed, serverRandom.length,
                    clientRandom.length);
            PRF.computePRF(key_block, session.master_secret,
                    KEY_EXPANSION_LABEL, seed);
            byte[] client_mac_secret;
            client_mac_secret = new byte[hash_size];
            byte[] server_mac_secret;
            server_mac_secret = new byte[hash_size];
            byte[] client_key;
            client_key = new byte[key_size];
            byte[] server_key;
            server_key = new byte[key_size];
            boolean is_client;
            is_client = !session.isServer;
            System.arraycopy(key_block, 0, client_mac_secret, 0, hash_size);
            System.arraycopy(key_block, hash_size,
                    server_mac_secret, 0, hash_size);
            System.arraycopy(key_block, 2*hash_size, client_key, 0, key_size);
            System.arraycopy(key_block, 2*hash_size+key_size,
                    server_key, 0, key_size);
            IvParameterSpec clientIV;
            clientIV = null;
            IvParameterSpec serverIV;
            serverIV = null;
            {
                System.arraycopy(clientRandom, 0,
                        seed, 0, clientRandom.length);
                System.arraycopy(serverRandom, 0,
                        seed, clientRandom.length, serverRandom.length);
                byte[] final_client_key;
                final_client_key = new byte[cipherSuite.expandedKeyMaterial];
                byte[] final_server_key;
                final_server_key = new byte[cipherSuite.expandedKeyMaterial];
                PRF.computePRF(final_client_key, client_key,
                        CLIENT_WRITE_KEY_LABEL, seed);
                PRF.computePRF(final_server_key, server_key,
                        SERVER_WRITE_KEY_LABEL, seed);
                client_key = final_client_key;
                server_key = final_server_key;
                {
                    byte[] iv_block;
                    iv_block = new byte[2*iv_size];
                    PRF.computePRF(iv_block, null, IV_BLOCK_LABEL, seed);
                    clientIV = new IvParameterSpec(iv_block, 0, iv_size);
                    serverIV = new IvParameterSpec(iv_block, iv_size, iv_size);
                } //End block
            } //End block
            {
                clientIV = new IvParameterSpec(key_block,
                        2*(hash_size+key_size), iv_size);
                serverIV = new IvParameterSpec(key_block,
                        2*(hash_size+key_size)+iv_size, iv_size);
            } //End block
            {
                logger.println("is exportable: "+is_exportabe);
                logger.println("master_secret");
                logger.print(session.master_secret);
                logger.println("client_random");
                logger.print(clientRandom);
                logger.println("server_random");
                logger.print(serverRandom);
                logger.println("client_mac_secret");
                logger.print(client_mac_secret);
                logger.println("server_mac_secret");
                logger.print(server_mac_secret);
                logger.println("client_key");
                logger.print(client_key);
                logger.println("server_key");
                logger.print(server_key);
                {
                    logger.println("no IV.");
                } //End block
                {
                    logger.println("client_iv");
                    logger.print(clientIV.getIV());
                    logger.println("server_iv");
                    logger.print(serverIV.getIV());
                } //End block
            } //End block
            {
                encCipher = new NullCipher();
                decCipher = new NullCipher();
            } //End block
            {
                encCipher = Cipher.getInstance(algName);
                decCipher = Cipher.getInstance(algName);
                {
                    encCipher.init(Cipher.ENCRYPT_MODE,
                                   new SecretKeySpec(client_key, algName), clientIV);
                    decCipher.init(Cipher.DECRYPT_MODE,
                                   new SecretKeySpec(server_key, algName), serverIV);
                } //End block
                {
                    encCipher.init(Cipher.ENCRYPT_MODE,
                                   new SecretKeySpec(server_key, algName), serverIV);
                    decCipher.init(Cipher.DECRYPT_MODE,
                                   new SecretKeySpec(client_key, algName), clientIV);
                } //End block
            } //End block
            encMac = Mac.getInstance(macName);
            decMac = Mac.getInstance(macName);
            {
                encMac.init(new SecretKeySpec(client_mac_secret, macName));
                decMac.init(new SecretKeySpec(server_mac_secret, macName));
            } //End block
            {
                encMac.init(new SecretKeySpec(server_mac_secret, macName));
                decMac.init(new SecretKeySpec(client_mac_secret, macName));
            } //End block
        } //End block
        catch (Exception e)
        {
            e.printStackTrace();
            if (DroidSafeAndroidRuntime.control) throw new AlertException(AlertProtocol.INTERNAL_ERROR,
                    new SSLProtocolException(
                        "Error during computation of security parameters"));
        } //End block
        addTaint(session.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.944 -0400", hash_original_method = "B9B8901A6530A5AA902AF1AE1DCFF588", hash_generated_method = "DA86B6861ED085194CB7064F7989950F")
    @Override
    protected byte[] encrypt(byte type, byte[] fragment, int offset, int len) {
        try 
        {
            int content_mac_length;
            content_mac_length = len + hash_size;
            int padding_length;
            padding_length = 0;
            padding_length = getPaddingSize(++content_mac_length);
            byte[] res;
            res = new byte[content_mac_length + padding_length];
            System.arraycopy(fragment, offset, res, 0, len);
            mac_material_header[0] = type;
            mac_material_header[3] = (byte) ((0x00FF00 & len) >> 8);
            mac_material_header[4] = (byte) (0x0000FF & len);
            encMac.update(write_seq_num);
            encMac.update(mac_material_header);
            encMac.update(fragment, offset, len);
            encMac.doFinal(res, len);
            {
                Arrays.fill(res, content_mac_length-1,
                        res.length, (byte) (padding_length));
            } //End block
            {
                logger.println("SSLRecordProtocol.do_encryption: Generic"
                        + (block_size != 0
                            ? "BlockCipher with padding["+padding_length+"]:"
                            : "StreamCipher:"));
                logger.print(res);
            } //End block
            byte[] rez;
            rez = new byte[encCipher.getOutputSize(res.length)];
            encCipher.update(res, 0, res.length, rez);
            incSequenceNumber(write_seq_num);
        } //End block
        catch (GeneralSecurityException e)
        {
            e.printStackTrace();
            if (DroidSafeAndroidRuntime.control) throw new AlertException(AlertProtocol.INTERNAL_ERROR,
                    new SSLProtocolException("Error during the encryption"));
        } //End block
        addTaint(fragment[0]);
        addTaint(offset);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_198139101 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_198139101;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.953 -0400", hash_original_method = "A0319C4335A825139157822F68CBECCE", hash_generated_method = "AAA66C35B9AB775E79B1E8BB79163EB7")
    @Override
    protected byte[] decrypt(byte type, byte[] fragment,
            int offset, int len) {
        byte[] data;
        data = decCipher.update(fragment, offset, len);
        byte[] content;
        {
            int padding_length;
            padding_length = data[data.length-1];
            {
                int i;
                i = 0;
                {
                    {
                        if (DroidSafeAndroidRuntime.control) throw new AlertException(
                            AlertProtocol.DECRYPTION_FAILED,
                            new SSLProtocolException(
                                "Received message has bad padding"));
                    } //End block
                } //End block
            } //End collapsed parenthetic
            content = new byte[data.length - hash_size - padding_length - 1];
        } //End block
        {
            content = new byte[data.length - hash_size];
        } //End block
        mac_material_header[0] = type;
        mac_material_header[3] = (byte) ((0x00FF00 & content.length) >> 8);
        mac_material_header[4] = (byte) (0x0000FF & content.length);
        decMac.update(read_seq_num);
        decMac.update(mac_material_header);
        decMac.update(data, 0, content.length);
        byte[] mac_value;
        mac_value = decMac.doFinal();
        {
            logger.println("Decrypted:");
            logger.print(data);
            logger.println("Expected mac value:");
            logger.print(mac_value);
        } //End block
        {
            int i;
            i = 0;
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new AlertException(AlertProtocol.BAD_RECORD_MAC,
                        new SSLProtocolException("Bad record MAC"));
                } //End block
            } //End block
        } //End collapsed parenthetic
        System.arraycopy(data, 0, content, 0, content.length);
        incSequenceNumber(read_seq_num);
        addTaint(fragment[0]);
        addTaint(offset);
        addTaint(len);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1652741249 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1652741249;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.953 -0400", hash_original_field = "0E2A504262552D9749CD1373F8A09D99", hash_generated_field = "66981A4FF9F53755909FBD1327C4F999")

    private static byte[] KEY_EXPANSION_LABEL = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.953 -0400", hash_original_field = "12289A14F46830DC4B2848515395FF0A", hash_generated_field = "7E1AEDF1E0558D47B4BDE505E854D909")

    private static byte[] CLIENT_WRITE_KEY_LABEL = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.953 -0400", hash_original_field = "DC0BC54E0907B08B214623058A3F6592", hash_generated_field = "B8AB876E73DE219F32A846B6DD0128B9")

    private static byte[] SERVER_WRITE_KEY_LABEL = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.953 -0400", hash_original_field = "E696196A19942D342CC87A22753A2C19", hash_generated_field = "5602F48B82836D195D5349D628731015")

    private static byte[] IV_BLOCK_LABEL = ;
}

