package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.DigestException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.net.ssl.SSLException;
import libcore.util.EmptyArray;

public class DigitalSignature {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.000 -0400", hash_original_field = "1BC29B36F623BA82AAF6724FD3B16718", hash_generated_field = "B22BEAD2E03E6DC9EC1B452A01F5C921")

    private MessageDigest md5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.000 -0400", hash_original_field = "CA794FB2D950ACF25C964ECC35F2D7E2", hash_generated_field = "4A489BD95B8D8991536BCB0FDC9BD1C9")

    private MessageDigest sha;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.000 -0400", hash_original_field = "AC201FD270C3B96BEAB24F2829780AB2", hash_generated_field = "EDE925851E2EC9CBDC61CDF457BBC562")

    private Signature signature;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.001 -0400", hash_original_field = "08406A6E18BDF83010DDD1187251454D", hash_generated_field = "2FF9F58B969F4213F59ABA296D3A8FC3")

    private Cipher cipher;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.001 -0400", hash_original_field = "0AA9F2A2AD1505835EE3219279F6CE49", hash_generated_field = "ECDEF14A5FC64303858BAA6FBF50E641")

    private byte[] md5_hash;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.001 -0400", hash_original_field = "628B7C89674C807D5623BDF0304CFF13", hash_generated_field = "433DF2E11EA67703110F7E1DEC3E0303")

    private byte[] sha_hash;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.012 -0400", hash_original_method = "038F050AED1C1465ECEA892ABE879633", hash_generated_method = "0A9674B912FC9BF12A00F6DB5AD26136")
    public  DigitalSignature(String authType) {
        try 
        {
            sha = MessageDigest.getInstance("SHA-1");
            {
                boolean var375059584495A158090778BAD6484C9D_1195882664 = ("RSA".equals(authType));
                {
                    md5 = MessageDigest.getInstance("MD5");
                    cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                    signature = null;
                } //End block
                {
                    boolean var0EEB3843AA0677671237B5C645184A21_420663294 = ("DSA".equals(authType));
                    {
                        signature = Signature.getInstance("NONEwithDSA");
                        cipher = null;
                        md5 = null;
                    } //End block
                    {
                        cipher = null;
                        signature = null;
                        md5 = null;
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        catch (NoSuchAlgorithmException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        catch (NoSuchPaddingException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        addTaint(authType.getTaint());
        // ---------- Original Method ----------
        //try {
            //sha = MessageDigest.getInstance("SHA-1");
            //if ("RSA".equals(authType)) {
                //md5 = MessageDigest.getInstance("MD5");
                //cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                //signature = null;
            //} else if ("DSA".equals(authType)) {
                //signature = Signature.getInstance("NONEwithDSA");
                //cipher = null;
                //md5 = null;
            //} else {
                //cipher = null;
                //signature = null;
                //md5 = null;
            //}
        //} catch (NoSuchAlgorithmException e) {
            //throw new AssertionError(e);
        //} catch (NoSuchPaddingException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.013 -0400", hash_original_method = "63DCB38A03804A8CF42B493B58B13DDC", hash_generated_method = "5DF1F160F081583358D132FB271CE1D5")
    public void init(PrivateKey key) {
        try 
        {
            {
                signature.initSign(key);
            } //End block
            {
                cipher.init(Cipher.ENCRYPT_MODE, key);
            } //End block
        } //End block
        catch (InvalidKeyException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AlertException(AlertProtocol.BAD_CERTIFICATE,
                    new SSLException("init - invalid private key", e));
        } //End block
        addTaint(key.getTaint());
        // ---------- Original Method ----------
        //try {
            //if (signature != null) {
                //signature.initSign(key);
            //} else if (cipher != null) {
                //cipher.init(Cipher.ENCRYPT_MODE, key);
            //}
        //} catch (InvalidKeyException e){
            //throw new AlertException(AlertProtocol.BAD_CERTIFICATE,
                    //new SSLException("init - invalid private key", e));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.014 -0400", hash_original_method = "E5B57B76E0D4C32AD6E030FA95B32ACD", hash_generated_method = "C57026341C363377B44DF904832B768E")
    public void init(Certificate cert) {
        try 
        {
            {
                signature.initVerify(cert);
            } //End block
            {
                cipher.init(Cipher.DECRYPT_MODE, cert);
            } //End block
        } //End block
        catch (InvalidKeyException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AlertException(AlertProtocol.BAD_CERTIFICATE,
                    new SSLException("init - invalid certificate", e));
        } //End block
        addTaint(cert.getTaint());
        // ---------- Original Method ----------
        //try {
            //if (signature != null) {
                //signature.initVerify(cert);
            //} else if (cipher != null) {
                //cipher.init(Cipher.DECRYPT_MODE, cert);
            //}
        //} catch (InvalidKeyException e){
            //throw new AlertException(AlertProtocol.BAD_CERTIFICATE,
                    //new SSLException("init - invalid certificate", e));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.014 -0400", hash_original_method = "D74E9B3F4153C40FBC49F204F5B3A569", hash_generated_method = "8CBD35331EB45C56ED623A0C113F8C29")
    public void update(byte[] data) {
        {
            sha.update(data);
        } //End block
        {
            md5.update(data);
        } //End block
        addTaint(data[0]);
        // ---------- Original Method ----------
        //if (sha != null) {
            //sha.update(data);
        //}
        //if (md5 != null) {
            //md5.update(data);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.020 -0400", hash_original_method = "B9CA7162ECD9A3463C27E4B77DAB6CBA", hash_generated_method = "2581847F6C7AB0F9303F842275B2D775")
    public void setMD5(byte[] data) {
        md5_hash = data;
        // ---------- Original Method ----------
        //md5_hash = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.021 -0400", hash_original_method = "3BA66B7FA2FDB006FB2AA15DCD71C98C", hash_generated_method = "6D5B34CD82B069FE4DDB4F1367E06DCE")
    public void setSHA(byte[] data) {
        sha_hash = data;
        // ---------- Original Method ----------
        //sha_hash = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.022 -0400", hash_original_method = "15C049C524B86A812CBA705875D88ECC", hash_generated_method = "0BC95AA7C28814AF823035BD27D4F2B0")
    public byte[] sign() {
        try 
        {
            {
                md5_hash = new byte[16];
                md5.digest(md5_hash, 0, md5_hash.length);
            } //End block
            {
                {
                    signature.update(md5_hash);
                } //End block
                {
                    cipher.update(md5_hash);
                } //End block
            } //End block
            {
                sha_hash = new byte[20];
                sha.digest(sha_hash, 0, sha_hash.length);
            } //End block
            {
                {
                    signature.update(sha_hash);
                } //End block
                {
                    cipher.update(sha_hash);
                } //End block
            } //End block
            {
                byte[] var27992A18675E368FD486AB5E30CF33F6_1928216821 = (signature.sign());
            } //End block
            {
                byte[] var252117FE5F0DB0862FD7B87315DB100D_917534853 = (cipher.doFinal());
            } //End block
        } //End block
        catch (DigestException e)
        { }
        catch (SignatureException e)
        { }
        catch (BadPaddingException e)
        { }
        catch (IllegalBlockSizeException e)
        { }
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1192226231 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1192226231;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.027 -0400", hash_original_method = "19503CD9A5095168C8826497974984EF", hash_generated_method = "EDADC267AA1095D6B0C7139CBE5EE7A8")
    public boolean verifySignature(byte[] data) {
        {
            try 
            {
                signature.update(sha_hash);
                boolean var71F224FF8F2F61BF06CFD2A39C834040_1055891030 = (signature.verify(data));
            } //End block
            catch (SignatureException e)
            { }
        } //End block
        {
            byte[] decrypt;
            try 
            {
                decrypt = cipher.doFinal(data);
            } //End block
            catch (IllegalBlockSizeException e)
            { }
            catch (BadPaddingException e)
            { }
            byte[] md5_sha;
            {
                md5_sha = new byte[md5_hash.length + sha_hash.length];
                System.arraycopy(md5_hash, 0, md5_sha, 0, md5_hash.length);
                System.arraycopy(sha_hash, 0, md5_sha, md5_hash.length, sha_hash.length);
            } //End block
            {
                md5_sha = md5_hash;
            } //End block
            {
                md5_sha = sha_hash;
            } //End block
            boolean varF1BA09B4F89BE8C64AF3F6EED36BEA58_2139038110 = (Arrays.equals(decrypt, md5_sha));
        } //End block
        addTaint(data[0]);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_400397432 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_400397432;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

