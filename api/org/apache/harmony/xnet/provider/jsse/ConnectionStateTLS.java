package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import java.security.GeneralSecurityException;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.NullCipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLProtocolException;

import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class ConnectionStateTLS extends ConnectionState {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.390 -0400", hash_original_field = "E0BC9005FCA6DD6D01FDAF621E6B05BF", hash_generated_field = "8EFC7A4F1C288592B3AB26CC617B3592")

    private Mac encMac;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.390 -0400", hash_original_field = "84C3A68C014535ADCE9C7C0179A1EB44", hash_generated_field = "51E887829C16E119E6B76A07E982A6A6")

    private Mac decMac;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.390 -0400", hash_original_field = "F119236CA59ECCBFFA641A3A68808615", hash_generated_field = "3C0FDEE7208CE1A2A2134084F75C8E94")

    private final byte[] mac_material_header = new byte[] {0, 3, 1, 0, 0};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.393 -0400", hash_original_method = "983E273AE559F45D4EDE298176308BF7", hash_generated_method = "AAADF25AFADB24CEC40B58C773B6B068")
    protected  ConnectionStateTLS(SSLSessionImpl session) {
        addTaint(session.getTaint());
        try 
        {
            CipherSuite cipherSuite = session.cipherSuite;
            hash_size = cipherSuite.getMACLength();
            boolean is_exportabe = cipherSuite.isExportable();
            int key_size = (is_exportabe)
                ? cipherSuite.keyMaterial
                : cipherSuite.expandedKeyMaterial;
            int iv_size = cipherSuite.ivSize;
            block_size = cipherSuite.getBlockSize();
            String algName = cipherSuite.getBulkEncryptionAlgorithm();
            String macName = cipherSuite.getHmacName();
            if(logger != null)            
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
            byte[] clientRandom = session.clientRandom;
            byte[] serverRandom = session.serverRandom;
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
            if(is_exportabe)            
            {
                System.arraycopy(clientRandom, 0,
                        seed, 0, clientRandom.length);
                System.arraycopy(serverRandom, 0,
                        seed, clientRandom.length, serverRandom.length);
                byte[] final_client_key = new byte[cipherSuite.expandedKeyMaterial];
                byte[] final_server_key = new byte[cipherSuite.expandedKeyMaterial];
                PRF.computePRF(final_client_key, client_key,
                        CLIENT_WRITE_KEY_LABEL, seed);
                PRF.computePRF(final_server_key, server_key,
                        SERVER_WRITE_KEY_LABEL, seed);
                client_key = final_client_key;
                server_key = final_server_key;
                if(block_size != 0)                
                {
                    byte[] iv_block = new byte[2*iv_size];
                    PRF.computePRF(iv_block, null, IV_BLOCK_LABEL, seed);
                    clientIV = new IvParameterSpec(iv_block, 0, iv_size);
                    serverIV = new IvParameterSpec(iv_block, iv_size, iv_size);
                } //End block
            } //End block
            else
            if(block_size != 0)            
            {
                clientIV = new IvParameterSpec(key_block,
                        2*(hash_size+key_size), iv_size);
                serverIV = new IvParameterSpec(key_block,
                        2*(hash_size+key_size)+iv_size, iv_size);
            } //End block
            if(logger != null)            
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
                if(clientIV == null)                
                {
                    logger.println("no IV.");
                } //End block
                else
                {
                    logger.println("client_iv");
                    logger.print(clientIV.getIV());
                    logger.println("server_iv");
                    logger.print(serverIV.getIV());
                } //End block
            } //End block
            if(algName == null)            
            {
                encCipher = new NullCipher();
                decCipher = new NullCipher();
            } //End block
            else
            {
                encCipher = Cipher.getInstance(algName);
                decCipher = Cipher.getInstance(algName);
                if(is_client)                
                {
                    encCipher.init(Cipher.ENCRYPT_MODE,
                                   new SecretKeySpec(client_key, algName), clientIV);
                    decCipher.init(Cipher.DECRYPT_MODE,
                                   new SecretKeySpec(server_key, algName), serverIV);
                } //End block
                else
                {
                    encCipher.init(Cipher.ENCRYPT_MODE,
                                   new SecretKeySpec(server_key, algName), serverIV);
                    decCipher.init(Cipher.DECRYPT_MODE,
                                   new SecretKeySpec(client_key, algName), clientIV);
                } //End block
            } //End block
            encMac = Mac.getInstance(macName);
            decMac = Mac.getInstance(macName);
            if(is_client)            
            {
                encMac.init(new SecretKeySpec(client_mac_secret, macName));
                decMac.init(new SecretKeySpec(server_mac_secret, macName));
            } //End block
            else
            {
                encMac.init(new SecretKeySpec(server_mac_secret, macName));
                decMac.init(new SecretKeySpec(client_mac_secret, macName));
            } //End block
        } //End block
        catch (Exception e)
        {
            e.printStackTrace();
            AlertException var886399C6341AEABBC45DD13CCAF5571B_714452828 = new AlertException(AlertProtocol.INTERNAL_ERROR,
                    new SSLProtocolException(
                        "Error during computation of security parameters"));
            var886399C6341AEABBC45DD13CCAF5571B_714452828.addTaint(taint);
            throw var886399C6341AEABBC45DD13CCAF5571B_714452828;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.397 -0400", hash_original_method = "B9B8901A6530A5AA902AF1AE1DCFF588", hash_generated_method = "6099C04F05C6C7D9AE156FA1B84AB2D5")
    @Override
    protected byte[] encrypt(byte type, byte[] fragment, int offset, int len) {
        addTaint(offset);
        addTaint(fragment[0]);
        try 
        {
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
            if(block_size != 0)            
            {
                Arrays.fill(res, content_mac_length-1,
                        res.length, (byte) (padding_length));
            } //End block
            if(logger != null)            
            {
                logger.println("SSLRecordProtocol.do_encryption: Generic"
                        + (block_size != 0
                            ? "BlockCipher with padding["+padding_length+"]:"
                            : "StreamCipher:"));
                logger.print(res);
            } //End block
            byte[] rez = new byte[encCipher.getOutputSize(res.length)];
            encCipher.update(res, 0, res.length, rez);
            incSequenceNumber(write_seq_num);
            byte[] varD33BC499CA0ACD0CDF659B4AD190DCEC_1511454654 = (rez);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_994608009 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_994608009;
        } //End block
        catch (GeneralSecurityException e)
        {
            e.printStackTrace();
            AlertException var73EB725A695601E67DA15B6BA3118BBA_605045457 = new AlertException(AlertProtocol.INTERNAL_ERROR,
                    new SSLProtocolException("Error during the encryption"));
            var73EB725A695601E67DA15B6BA3118BBA_605045457.addTaint(taint);
            throw var73EB725A695601E67DA15B6BA3118BBA_605045457;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.399 -0400", hash_original_method = "A0319C4335A825139157822F68CBECCE", hash_generated_method = "B67F555CA5ADCE5A2D5B0837833A6BFF")
    @Override
    protected byte[] decrypt(byte type, byte[] fragment,
            int offset, int len) {
        addTaint(len);
        addTaint(offset);
        addTaint(fragment[0]);
        byte[] data = decCipher.update(fragment, offset, len);
        byte[] content;
        if(block_size != 0)        
        {
            int padding_length = data[data.length-1];
for(int i=0;i<padding_length;i++)
            {
                if(data[data.length-2-i] != padding_length)                
                {
                    AlertException var92834CD3795640470A2BA84DE19F568D_906624075 = new AlertException(
                            AlertProtocol.DECRYPTION_FAILED,
                            new SSLProtocolException(
                                "Received message has bad padding"));
                    var92834CD3795640470A2BA84DE19F568D_906624075.addTaint(taint);
                    throw var92834CD3795640470A2BA84DE19F568D_906624075;
                } //End block
            } //End block
            content = new byte[data.length - hash_size - padding_length - 1];
        } //End block
        else
        {
            content = new byte[data.length - hash_size];
        } //End block
        mac_material_header[0] = type;
        mac_material_header[3] = (byte) ((0x00FF00 & content.length) >> 8);
        mac_material_header[4] = (byte) (0x0000FF & content.length);
        decMac.update(read_seq_num);
        decMac.update(mac_material_header);
        decMac.update(data, 0, content.length);
        byte[] mac_value = decMac.doFinal();
        if(logger != null)        
        {
            logger.println("Decrypted:");
            logger.print(data);
            logger.println("Expected mac value:");
            logger.print(mac_value);
        } //End block
for(int i=0;i<hash_size;i++)
        {
            if(mac_value[i] != data[i+content.length])            
            {
                AlertException var8DEAD6D6B22176DE990E0F77D252D32C_2003819008 = new AlertException(AlertProtocol.BAD_RECORD_MAC,
                        new SSLProtocolException("Bad record MAC"));
                var8DEAD6D6B22176DE990E0F77D252D32C_2003819008.addTaint(taint);
                throw var8DEAD6D6B22176DE990E0F77D252D32C_2003819008;
            } //End block
        } //End block
        System.arraycopy(data, 0, content, 0, content.length);
        incSequenceNumber(read_seq_num);
        byte[] var9A0364B9E99BB480DD25E1F0284C8555_151799145 = (content);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_607193396 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_607193396;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.400 -0400", hash_original_field = "0E2A504262552D9749CD1373F8A09D99", hash_generated_field = "19434D3E92AD7E414CBA841F27ED54E4")

    private static byte[] KEY_EXPANSION_LABEL = {
        (byte) 0x6B, (byte) 0x65, (byte) 0x79, (byte) 0x20, (byte) 0x65,
        (byte) 0x78, (byte) 0x70, (byte) 0x61, (byte) 0x6E, (byte) 0x73,
        (byte) 0x69, (byte) 0x6F, (byte) 0x6E };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.400 -0400", hash_original_field = "12289A14F46830DC4B2848515395FF0A", hash_generated_field = "03141D4442DE03CB1D96006A96ECABC7")

    private static byte[] CLIENT_WRITE_KEY_LABEL = {
        (byte) 0x63, (byte) 0x6C, (byte) 0x69, (byte) 0x65, (byte) 0x6E,
        (byte) 0x74, (byte) 0x20, (byte) 0x77, (byte) 0x72, (byte) 0x69,
        (byte) 0x74, (byte) 0x65, (byte) 0x20, (byte) 0x6B, (byte) 0x65,
        (byte) 0x79 };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.400 -0400", hash_original_field = "DC0BC54E0907B08B214623058A3F6592", hash_generated_field = "2187DB19BDC5CED9C76C076C88F0005A")

    private static byte[] SERVER_WRITE_KEY_LABEL = {
        (byte) 0x73, (byte) 0x65, (byte) 0x72, (byte) 0x76, (byte) 0x65,
        (byte) 0x72, (byte) 0x20, (byte) 0x77, (byte) 0x72, (byte) 0x69,
        (byte) 0x74, (byte) 0x65, (byte) 0x20, (byte) 0x6B, (byte) 0x65,
        (byte) 0x79 };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.400 -0400", hash_original_field = "E696196A19942D342CC87A22753A2C19", hash_generated_field = "BDE6D8351AF1668167AEDB127CBA6E19")

    private static byte[] IV_BLOCK_LABEL = {
        (byte) 0x49, (byte) 0x56, (byte) 0x20, (byte) 0x62, (byte) 0x6C,
        (byte) 0x6F, (byte) 0x63, (byte) 0x6B };
}

