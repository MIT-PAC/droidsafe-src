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
    private MessageDigest md5;
    private MessageDigest sha;
    private Signature signature;
    private Cipher cipher;
    private byte[] md5_hash;
    private byte[] sha_hash;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.743 -0400", hash_original_method = "038F050AED1C1465ECEA892ABE879633", hash_generated_method = "92F4F602B4229DACECA7D8ACA231960E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DigitalSignature(String authType) {
        dsTaint.addTaint(authType);
        try 
        {
            sha = MessageDigest.getInstance("SHA-1");
            {
                boolean var375059584495A158090778BAD6484C9D_592749421 = ("RSA".equals(authType));
                {
                    md5 = MessageDigest.getInstance("MD5");
                    cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                    signature = null;
                } //End block
                {
                    boolean var0EEB3843AA0677671237B5C645184A21_975842548 = ("DSA".equals(authType));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.743 -0400", hash_original_method = "63DCB38A03804A8CF42B493B58B13DDC", hash_generated_method = "F395DA0CB600CD49DD4E4CC072E18A63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void init(PrivateKey key) {
        dsTaint.addTaint(key.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.744 -0400", hash_original_method = "E5B57B76E0D4C32AD6E030FA95B32ACD", hash_generated_method = "77C6E5BDF95B3C5FF14F8E65EA54E8E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void init(Certificate cert) {
        dsTaint.addTaint(cert.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.744 -0400", hash_original_method = "D74E9B3F4153C40FBC49F204F5B3A569", hash_generated_method = "B4A47E0CECCBA714D5DE1C7DA44BC27F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void update(byte[] data) {
        dsTaint.addTaint(data[0]);
        {
            sha.update(data);
        } //End block
        {
            md5.update(data);
        } //End block
        // ---------- Original Method ----------
        //if (sha != null) {
            //sha.update(data);
        //}
        //if (md5 != null) {
            //md5.update(data);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.744 -0400", hash_original_method = "B9CA7162ECD9A3463C27E4B77DAB6CBA", hash_generated_method = "BAC44C546EF95923AEFB8C43DBCE19DB")
    @DSModeled(DSC.SAFE)
    public void setMD5(byte[] data) {
        dsTaint.addTaint(data[0]);
        // ---------- Original Method ----------
        //md5_hash = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.744 -0400", hash_original_method = "3BA66B7FA2FDB006FB2AA15DCD71C98C", hash_generated_method = "28A7DFC3AB3CAF32E2F3C46BA91029ED")
    @DSModeled(DSC.SAFE)
    public void setSHA(byte[] data) {
        dsTaint.addTaint(data[0]);
        // ---------- Original Method ----------
        //sha_hash = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.745 -0400", hash_original_method = "15C049C524B86A812CBA705875D88ECC", hash_generated_method = "9904BD46A8BBD1C33C08B70DD6F6F4B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
                byte[] var27992A18675E368FD486AB5E30CF33F6_1915941118 = (signature.sign());
            } //End block
            {
                byte[] var252117FE5F0DB0862FD7B87315DB100D_363545440 = (cipher.doFinal());
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
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.745 -0400", hash_original_method = "19503CD9A5095168C8826497974984EF", hash_generated_method = "0692ECAAEE7B13379B31514A4AA6018E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean verifySignature(byte[] data) {
        dsTaint.addTaint(data[0]);
        {
            try 
            {
                signature.update(sha_hash);
                boolean var71F224FF8F2F61BF06CFD2A39C834040_2070486131 = (signature.verify(data));
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
            boolean varF1BA09B4F89BE8C64AF3F6EED36BEA58_161930753 = (Arrays.equals(decrypt, md5_sha));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

