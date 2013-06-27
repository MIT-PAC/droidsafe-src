package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.NullCipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLProtocolException;

public class ConnectionStateSSLv3 extends ConnectionState {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.920 -0400", hash_original_field = "ABD8CEEC1ABEC18BFFD5F706BD225E2C", hash_generated_field = "FCEAD5705B5DC9FB1937BC2FCBBCA9AF")

    private MessageDigest messageDigest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.920 -0400", hash_original_field = "F85BBA0E630CCB87E9E057F7843E5155", hash_generated_field = "52F0A7E7FB8F697BA2DBD34D808EE930")

    private byte[] mac_write_secret;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.920 -0400", hash_original_field = "3B74FE391AD121B35F4BE239E37BF1FC", hash_generated_field = "8761BC41F67E290D2E4C5002A6776D51")

    private byte[] mac_read_secret;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.920 -0400", hash_original_field = "D60CD0414222997422D40AFDFECFC5D1", hash_generated_field = "F7AB63294607944F603CC7ED7CDCFB7E")

    private byte[] pad_1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.920 -0400", hash_original_field = "73A175169C50E148A373BDA5B6FE3A81", hash_generated_field = "BB8A0D4D3287636E4CC9DC82B8FCDD50")

    private byte[] pad_2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.920 -0400", hash_original_field = "19F0223DFC6BB343CC9A355E163DEDDF", hash_generated_field = "F5AA97A99B3282312E34C79F4A415BDB")

    private byte[] mac_material_part = new byte[3];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.936 -0400", hash_original_method = "1B482CA9527A6F5074105168D7DF9619", hash_generated_method = "83D70AC9065E11200F594852E2489955")
    protected  ConnectionStateSSLv3(SSLSessionImpl session) {
        try 
        {
            CipherSuite cipherSuite;
            cipherSuite = session.cipherSuite;
            boolean is_exportabe;
            is_exportabe = cipherSuite.isExportable();
            hash_size = cipherSuite.getMACLength();
            int key_size;
            key_size = cipherSuite.keyMaterial;
            key_size = cipherSuite.expandedKeyMaterial;
            int iv_size;
            iv_size = cipherSuite.ivSize;
            block_size = cipherSuite.getBlockSize();
            String algName;
            algName = cipherSuite.getBulkEncryptionAlgorithm();
            String hashName;
            hashName = cipherSuite.getHashName();
            {
                logger.println("ConnectionStateSSLv3.create:");
                logger.println("  cipher suite name: "
                                        + session.getCipherSuite());
                logger.println("  encryption alg name: " + algName);
                logger.println("  hash alg name: " + hashName);
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
            PRF.computePRF_SSLv3(key_block, session.master_secret, seed);
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
                {
                    logger.println("ConnectionStateSSLv3: is_exportable");
                } //End block
                MessageDigest md5;
                md5 = MessageDigest.getInstance("MD5");
                md5.update(client_key);
                md5.update(clientRandom);
                md5.update(serverRandom);
                client_key = md5.digest();
                md5.update(server_key);
                md5.update(serverRandom);
                md5.update(clientRandom);
                server_key = md5.digest();
                key_size = cipherSuite.expandedKeyMaterial;
                {
                    md5.update(clientRandom);
                    md5.update(serverRandom);
                    clientIV = new IvParameterSpec(md5.digest(), 0, iv_size);
                    md5.update(serverRandom);
                    md5.update(clientRandom);
                    serverIV = new IvParameterSpec(md5.digest(), 0, iv_size);
                } //End block
            } //End block
            {
                clientIV = new IvParameterSpec(key_block,
                        2*hash_size+2*key_size, iv_size);
                serverIV = new IvParameterSpec(key_block,
                        2*hash_size+2*key_size+iv_size, iv_size);
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
                logger.print(client_key, 0, key_size);
                logger.println("server_key");
                logger.print(server_key, 0, key_size);
                {
                    logger.println("client_iv");
                    logger.print(clientIV.getIV());
                    logger.println("server_iv");
                    logger.print(serverIV.getIV());
                } //End block
                {
                    logger.println("no IV.");
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
                                   new SecretKeySpec(client_key, 0, key_size, algName),
                                   clientIV);
                    decCipher.init(Cipher.DECRYPT_MODE,
                                   new SecretKeySpec(server_key, 0, key_size, algName),
                                   serverIV);
                } //End block
                {
                    encCipher.init(Cipher.ENCRYPT_MODE,
                                   new SecretKeySpec(server_key, 0, key_size, algName),
                                   serverIV);
                    decCipher.init(Cipher.DECRYPT_MODE,
                                   new SecretKeySpec(client_key, 0, key_size, algName),
                                   clientIV);
                } //End block
            } //End block
            messageDigest = MessageDigest.getInstance(hashName);
            {
                mac_write_secret = client_mac_secret;
                mac_read_secret = server_mac_secret;
            } //End block
            {
                mac_write_secret = server_mac_secret;
                mac_read_secret = client_mac_secret;
            } //End block
            {
                boolean var91F9EA995693DCE9DEFB76439E7B2DA0_1675523651 = (hashName.equals("MD5"));
                {
                    pad_1 = SSLv3Constants.MD5pad1;
                    pad_2 = SSLv3Constants.MD5pad2;
                } //End block
                {
                    pad_1 = SSLv3Constants.SHApad1;
                    pad_2 = SSLv3Constants.SHApad2;
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.947 -0400", hash_original_method = "3F84D57F957CA4DCEBAF95364A0886D3", hash_generated_method = "64EB17826341980D0814063C1B3B19EF")
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
            mac_material_part[0] = type;
            mac_material_part[1] = (byte) ((0x00FF00 & len) >> 8);
            mac_material_part[2] = (byte) (0x0000FF & len);
            messageDigest.update(mac_write_secret);
            messageDigest.update(pad_1);
            messageDigest.update(write_seq_num);
            messageDigest.update(mac_material_part);
            messageDigest.update(fragment, offset, len);
            byte[] digest;
            digest = messageDigest.digest();
            messageDigest.update(mac_write_secret);
            messageDigest.update(pad_2);
            messageDigest.update(digest);
            digest = messageDigest.digest();
            System.arraycopy(digest, 0, res, len, hash_size);
            {
                Arrays.fill(res, content_mac_length-1,
                        res.length, (byte) (padding_length));
            } //End block
            {
                logger.println("SSLRecordProtocol.encrypt: "
                        + (block_size != 0
                            ? "GenericBlockCipher with padding["
                                +padding_length+"]:"
                            : "GenericStreamCipher:"));
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
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1526749563 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1526749563;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.952 -0400", hash_original_method = "227FECEA7131D056EF18EE2E9369B9A1", hash_generated_method = "C327B6D1BA6705F69D94271DBF7F7C4A")
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
        byte[] mac_value;
        mac_material_part[0] = type;
        mac_material_part[1] = (byte) ((0x00FF00 & content.length) >> 8);
        mac_material_part[2] = (byte) (0x0000FF & content.length);
        messageDigest.update(mac_read_secret);
        messageDigest.update(pad_1);
        messageDigest.update(read_seq_num);
        messageDigest.update(mac_material_part);
        messageDigest.update(data, 0, content.length);
        mac_value = messageDigest.digest();
        messageDigest.update(mac_read_secret);
        messageDigest.update(pad_2);
        messageDigest.update(mac_value);
        mac_value = messageDigest.digest();
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
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_18426502 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_18426502;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.957 -0400", hash_original_method = "193A05B6A3D6926494D4F0030FC865D1", hash_generated_method = "D2F12FCD4357D1B9B048448619BB3025")
    @Override
    protected void shutdown() {
        Arrays.fill(mac_write_secret, (byte) 0);
        Arrays.fill(mac_read_secret, (byte) 0);
        super.shutdown();
        // ---------- Original Method ----------
        //Arrays.fill(mac_write_secret, (byte) 0);
        //Arrays.fill(mac_read_secret, (byte) 0);
        //super.shutdown();
    }

    
}

