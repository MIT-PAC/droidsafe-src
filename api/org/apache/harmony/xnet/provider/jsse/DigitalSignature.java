package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.annotations.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.464 -0400", hash_original_field = "1BC29B36F623BA82AAF6724FD3B16718", hash_generated_field = "B22BEAD2E03E6DC9EC1B452A01F5C921")

    private MessageDigest md5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.464 -0400", hash_original_field = "CA794FB2D950ACF25C964ECC35F2D7E2", hash_generated_field = "4A489BD95B8D8991536BCB0FDC9BD1C9")

    private MessageDigest sha;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.464 -0400", hash_original_field = "AC201FD270C3B96BEAB24F2829780AB2", hash_generated_field = "EDE925851E2EC9CBDC61CDF457BBC562")

    private Signature signature;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.464 -0400", hash_original_field = "08406A6E18BDF83010DDD1187251454D", hash_generated_field = "2FF9F58B969F4213F59ABA296D3A8FC3")

    private Cipher cipher;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.464 -0400", hash_original_field = "0AA9F2A2AD1505835EE3219279F6CE49", hash_generated_field = "ECDEF14A5FC64303858BAA6FBF50E641")

    private byte[] md5_hash;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.464 -0400", hash_original_field = "628B7C89674C807D5623BDF0304CFF13", hash_generated_field = "433DF2E11EA67703110F7E1DEC3E0303")

    private byte[] sha_hash;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.466 -0400", hash_original_method = "038F050AED1C1465ECEA892ABE879633", hash_generated_method = "F6847B6CDB42236B432965E203D7A05E")
    public  DigitalSignature(String authType) {
        addTaint(authType.getTaint());
        try 
        {
            sha = MessageDigest.getInstance("SHA-1");
            if("RSA".equals(authType))            
            {
                md5 = MessageDigest.getInstance("MD5");
                cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                signature = null;
            } //End block
            else
            if("DSA".equals(authType))            
            {
                signature = Signature.getInstance("NONEwithDSA");
                cipher = null;
                md5 = null;
            } //End block
            else
            {
                cipher = null;
                signature = null;
                md5 = null;
            } //End block
        } //End block
        catch (NoSuchAlgorithmException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_1018032558 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_1018032558.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_1018032558;
        } //End block
        catch (NoSuchPaddingException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_1284098119 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_1284098119.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_1284098119;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.466 -0400", hash_original_method = "63DCB38A03804A8CF42B493B58B13DDC", hash_generated_method = "E18D9C3BB60FBD3608F8E2772B99BEBF")
    public void init(PrivateKey key) {
        addTaint(key.getTaint());
        try 
        {
            if(signature != null)            
            {
                signature.initSign(key);
            } //End block
            else
            if(cipher != null)            
            {
                cipher.init(Cipher.ENCRYPT_MODE, key);
            } //End block
        } //End block
        catch (InvalidKeyException e)
        {
            AlertException varD14376A4A254DC0A9403DE7522B2B246_119991088 = new AlertException(AlertProtocol.BAD_CERTIFICATE,
                    new SSLException("init - invalid private key", e));
            varD14376A4A254DC0A9403DE7522B2B246_119991088.addTaint(taint);
            throw varD14376A4A254DC0A9403DE7522B2B246_119991088;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.467 -0400", hash_original_method = "E5B57B76E0D4C32AD6E030FA95B32ACD", hash_generated_method = "EB3F695A316B53FCE33534CFB231B839")
    public void init(Certificate cert) {
        addTaint(cert.getTaint());
        try 
        {
            if(signature != null)            
            {
                signature.initVerify(cert);
            } //End block
            else
            if(cipher != null)            
            {
                cipher.init(Cipher.DECRYPT_MODE, cert);
            } //End block
        } //End block
        catch (InvalidKeyException e)
        {
            AlertException var2604754B7D822F88D7C081596E2C49C4_390930966 = new AlertException(AlertProtocol.BAD_CERTIFICATE,
                    new SSLException("init - invalid certificate", e));
            var2604754B7D822F88D7C081596E2C49C4_390930966.addTaint(taint);
            throw var2604754B7D822F88D7C081596E2C49C4_390930966;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.468 -0400", hash_original_method = "D74E9B3F4153C40FBC49F204F5B3A569", hash_generated_method = "654188A9A61FDE9860096C42F70D14D0")
    public void update(byte[] data) {
        addTaint(data[0]);
        if(sha != null)        
        {
            sha.update(data);
        } //End block
        if(md5 != null)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.469 -0400", hash_original_method = "B9CA7162ECD9A3463C27E4B77DAB6CBA", hash_generated_method = "2581847F6C7AB0F9303F842275B2D775")
    public void setMD5(byte[] data) {
        md5_hash = data;
        // ---------- Original Method ----------
        //md5_hash = data;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.470 -0400", hash_original_method = "3BA66B7FA2FDB006FB2AA15DCD71C98C", hash_generated_method = "6D5B34CD82B069FE4DDB4F1367E06DCE")
    public void setSHA(byte[] data) {
        sha_hash = data;
        // ---------- Original Method ----------
        //sha_hash = data;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.471 -0400", hash_original_method = "15C049C524B86A812CBA705875D88ECC", hash_generated_method = "9FAE95B72FAB95BC29C708C318D95EBB")
    public byte[] sign() {
        try 
        {
            if(md5 != null && md5_hash == null)            
            {
                md5_hash = new byte[16];
                md5.digest(md5_hash, 0, md5_hash.length);
            } //End block
            if(md5_hash != null)            
            {
                if(signature != null)                
                {
                    signature.update(md5_hash);
                } //End block
                else
                if(cipher != null)                
                {
                    cipher.update(md5_hash);
                } //End block
            } //End block
            if(sha != null && sha_hash == null)            
            {
                sha_hash = new byte[20];
                sha.digest(sha_hash, 0, sha_hash.length);
            } //End block
            if(sha_hash != null)            
            {
                if(signature != null)                
                {
                    signature.update(sha_hash);
                } //End block
                else
                if(cipher != null)                
                {
                    cipher.update(sha_hash);
                } //End block
            } //End block
            if(signature != null)            
            {
                byte[] varE1C34A68714F912C80D90E85CF4F6C48_308501070 = (signature.sign());
                                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1141858279 = {getTaintByte()};
                return var2F9C81BC6E497382285CD6B7A7E33DE1_1141858279;
            } //End block
            else
            if(cipher != null)            
            {
                byte[] var224C8F2D014E680AECAD85B8F4AAB42E_1642816616 = (cipher.doFinal());
                                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1501235957 = {getTaintByte()};
                return var2F9C81BC6E497382285CD6B7A7E33DE1_1501235957;
            } //End block
            byte[] varA5FACF7093451CD76BBFDE3F1270A007_1987262661 = (EmptyArray.BYTE);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_17259998 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_17259998;
        } //End block
        catch (DigestException e)
        {
            byte[] varA5FACF7093451CD76BBFDE3F1270A007_1143779392 = (EmptyArray.BYTE);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_101754768 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_101754768;
        } //End block
        catch (SignatureException e)
        {
            byte[] varA5FACF7093451CD76BBFDE3F1270A007_1037567150 = (EmptyArray.BYTE);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_474583406 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_474583406;
        } //End block
        catch (BadPaddingException e)
        {
            byte[] varA5FACF7093451CD76BBFDE3F1270A007_1400666140 = (EmptyArray.BYTE);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1843800327 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1843800327;
        } //End block
        catch (IllegalBlockSizeException e)
        {
            byte[] varA5FACF7093451CD76BBFDE3F1270A007_1671510712 = (EmptyArray.BYTE);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_574645323 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_574645323;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.474 -0400", hash_original_method = "19503CD9A5095168C8826497974984EF", hash_generated_method = "B865D95D13C8A49824FB897883656AE6")
    public boolean verifySignature(byte[] data) {
        addTaint(data[0]);
        if(signature != null)        
        {
            try 
            {
                signature.update(sha_hash);
                boolean varA21EF8359C9E3C4A8620F383D18CE086_313189238 = (signature.verify(data));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_427718394 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_427718394;
            } //End block
            catch (SignatureException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_1858231811 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1402132131 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1402132131;
            } //End block
        } //End block
        if(cipher != null)        
        {
            byte[] decrypt;
            try 
            {
                decrypt = cipher.doFinal(data);
            } //End block
            catch (IllegalBlockSizeException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_791763719 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_742397514 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_742397514;
            } //End block
            catch (BadPaddingException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_106068273 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_769911869 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_769911869;
            } //End block
            byte[] md5_sha;
            if(md5_hash != null && sha_hash != null)            
            {
                md5_sha = new byte[md5_hash.length + sha_hash.length];
                System.arraycopy(md5_hash, 0, md5_sha, 0, md5_hash.length);
                System.arraycopy(sha_hash, 0, md5_sha, md5_hash.length, sha_hash.length);
            } //End block
            else
            if(md5_hash != null)            
            {
                md5_sha = md5_hash;
            } //End block
            else
            {
                md5_sha = sha_hash;
            } //End block
            boolean var09F761CD984DE0753AA1AD32E0C8FF93_1320396437 = (Arrays.equals(decrypt, md5_sha));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2123338446 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2123338446;
        } //End block
        else
        if(data == null || data.length == 0)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_257495133 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1112401381 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1112401381;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_2141040767 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1216625779 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1216625779;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

