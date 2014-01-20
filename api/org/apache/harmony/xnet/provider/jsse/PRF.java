package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLException;

public class PRF {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.640 -0500", hash_original_method = "9013907446D1B3B1BEF728F3AAC98F14", hash_generated_method = "E9294A72F7A271A4930025976E1BC853")
    
static private void init() {
        try {
            md5_mac = Mac.getInstance("HmacMD5");
            sha_mac = Mac.getInstance("HmacSHA1");
        } catch (NoSuchAlgorithmException e) {
            throw new AlertException(AlertProtocol.INTERNAL_ERROR,
                    new SSLException(
                "There is no provider of HmacSHA1 or HmacMD5 "
                + "algorithms installed in the system"));
        }
        md5_mac_length = md5_mac.getMacLength();
        sha_mac_length = sha_mac.getMacLength();
        try {
            md5 = MessageDigest.getInstance("MD5");
            sha = MessageDigest.getInstance("SHA-1");
        } catch (Exception e) {
            throw new AlertException(AlertProtocol.INTERNAL_ERROR,
                    new SSLException(
                    "Could not initialize the Digest Algorithms."));
        }
    }

    /**
     * Computes the value of SSLv3 pseudo random function.
     * @param   out:    the buffer to fill up with the value of the function.
     * @param   secret: the buffer containing the secret value to generate prf.
     * @param   seed:   the seed to be used.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.644 -0500", hash_original_method = "06B09237572FDBACE4B91CD9A5DB4A4A", hash_generated_method = "14C1CE767CE584FF5B151067AFB17C61")
    
static synchronized void computePRF_SSLv3(byte[] out, byte[] secret, byte[] seed) {
        if (sha == null) {
            init();
        }
        int pos = 0;
        int iteration = 1;
        byte[] digest;
        while (pos < out.length) {
            byte[] pref = new byte[iteration];
            Arrays.fill(pref, (byte) (64 + iteration++));
            sha.update(pref);
            sha.update(secret);
            sha.update(seed);
            md5.update(secret);
            md5.update(sha.digest());
            digest = md5.digest(); // length == 16
            if (pos + 16 > out.length) {
                System.arraycopy(digest, 0, out, pos, out.length - pos);
                pos = out.length;
            } else {
                System.arraycopy(digest, 0, out, pos, 16);
                pos += 16;
            }
        }
    }

    /**
     * Computes the value of TLS pseudo random function.
     * @param   out:    the buffer to fill up with the value of the function.
     * @param   secret: the buffer containing the secret value to generate prf.
     * @param   str_bytes:  the label bytes to be used.
     * @param   seed:   the seed to be used.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.647 -0500", hash_original_method = "1178A5AAEAFD3956E42497222F39B739", hash_generated_method = "1E775A118847D9F735DCABC8A65D2104")
    
synchronized static void computePRF(byte[] out, byte[] secret,
            byte[] str_byts, byte[] seed) throws GeneralSecurityException {
        if (sha_mac == null) {
            init();
        }
        // Do concatenation of the label with the seed:
        // (metterings show that is is faster to concatenate the arrays
        // and to call HMAC.update on cancatenation, than twice call for
        // each of the part, i.e.:
        // time(HMAC.update(label+seed))
        //          < time(HMAC.update(label)) + time(HMAC.update(seed))
        // but it takes more memmory (approximaty on 4%)
        /*
        byte[] tmp_seed = new byte[seed.length + str_byts.length];
        System.arraycopy(str_byts, 0, tmp_seed, 0, str_byts.length);
        System.arraycopy(seed, 0, tmp_seed, str_byts.length, seed.length);
        seed = tmp_seed;
        */
        SecretKeySpec keyMd5;
        SecretKeySpec keySha1;
        if ((secret == null) || (secret.length == 0)) {
            secret = new byte[8];
            keyMd5 = new SecretKeySpec(secret, "HmacMD5");
            keySha1 = new SecretKeySpec(secret, "HmacSHA1");
        } else {
            int length = secret.length >> 1; // division by 2
            int offset = secret.length & 1;  // remainder
            keyMd5 = new SecretKeySpec(secret, 0, length + offset,
                    "HmacMD5");
            keySha1 = new SecretKeySpec(secret, length, length
                    + offset, "HmacSHA1");
        }

        //byte[] str_byts = label.getBytes();

        if (logger != null) {
            logger.println("secret["+secret.length+"]: ");
            logger.printAsHex(16, "", " ", secret);
            logger.println("label["+str_byts.length+"]: ");
            logger.printAsHex(16, "", " ", str_byts);
            logger.println("seed["+seed.length+"]: ");
            logger.printAsHex(16, "", " ", seed);
            logger.println("MD5 key:");
            logger.printAsHex(16, "", " ", keyMd5.getEncoded());
            logger.println("SHA1 key:");
            logger.printAsHex(16, "", " ", keySha1.getEncoded());
        }

        md5_mac.init(keyMd5);
        sha_mac.init(keySha1);

        int pos = 0;
        md5_mac.update(str_byts);
        byte[] hash = md5_mac.doFinal(seed); // A(1)
        while (pos < out.length) {
            md5_mac.update(hash);
            md5_mac.update(str_byts);
            md5_mac.update(seed);
            if (pos + md5_mac_length < out.length) {
                md5_mac.doFinal(out, pos);
                pos += md5_mac_length;
            } else {
                System.arraycopy(md5_mac.doFinal(), 0, out,
                        pos, out.length - pos);
                break;
            }
            // make A(i)
            hash = md5_mac.doFinal(hash);
        }
        if (logger != null) {
            logger.println("P_MD5:");
            logger.printAsHex(md5_mac_length, "", " ", out);
        }

        pos = 0;
        sha_mac.update(str_byts);
        hash = sha_mac.doFinal(seed); // A(1)
        byte[] sha1hash;
        while (pos < out.length) {
            sha_mac.update(hash);
            sha_mac.update(str_byts);
            sha1hash = sha_mac.doFinal(seed);
            for (int i = 0; (i < sha_mac_length) & (pos < out.length); i++) {
                out[pos++] ^= sha1hash[i];
            }
            // make A(i)
            hash = sha_mac.doFinal(hash);
        }

        if (logger != null) {
            logger.println("PRF:");
            logger.printAsHex(sha_mac_length, "", " ", out);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.624 -0500", hash_original_field = "28271B1AF1D2D581210181C4029CF145", hash_generated_field = "C3F45E78FDFD4A7B65124F3B5EABEA83")

    private static Logger.Stream logger = Logger.getStream("prf");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.626 -0500", hash_original_field = "26BBB8E702B9EBF3795D483832DA0664", hash_generated_field = "A5684AE7706FA9ECD61E6D3EA8256C34")

    private static Mac md5_mac;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.628 -0500", hash_original_field = "F944C092FFC61EAF52CACD16A5BFB7A4", hash_generated_field = "390D99310B8B23E117E0ACB370C8F537")

    private static Mac sha_mac;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.631 -0500", hash_original_field = "7CC4ADADCF5B81E1EEBC5F8C930336A6", hash_generated_field = "D5F014887D4A79E166510A4FA421D08B")

    protected static MessageDigest md5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.633 -0500", hash_original_field = "592D6316376DEACF69E66590DC353E6F", hash_generated_field = "2E9E9E85A50E6935D767AA6B9691EC63")

    protected static MessageDigest sha;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.635 -0500", hash_original_field = "D4E10FD210A87F88E82946B3C3C2AFB9", hash_generated_field = "2C9D0114C1AC2794837DE00C523B4889")

    private static int md5_mac_length;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:10.637 -0500", hash_original_field = "48A97EEB1C81E96FFC60E879F3BDD3F9", hash_generated_field = "05BC0A15A688E18C1BE91C143F82353B")

    private static int sha_mac_length;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.025 -0400", hash_original_method = "A5FFDA88D1812D20324981FB63A9C9B4", hash_generated_method = "A5FFDA88D1812D20324981FB63A9C9B4")
    public PRF ()
    {
        //Synthesized constructor
    }
}

