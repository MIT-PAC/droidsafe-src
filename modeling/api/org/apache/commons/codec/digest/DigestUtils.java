/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.commons.codec.digest;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;

/**
 * Operations to simplifiy common {@link java.security.MessageDigest} tasks. This class is thread safe.
 * 
 * @author Apache Software Foundation
 * @version $Id: DigestUtils.java 801391 2009-08-05 19:55:54Z ggregory $
 */
public class DigestUtils {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:28.794 -0500", hash_original_field = "718C7B67F12CEA0A799121EFB073D08C", hash_generated_field = "45326B07D4C6B386899414D6534492F3")

    private static final int STREAM_BUFFER_LENGTH = 1024;

    /**
     * Read through an InputStream and returns the digest for the data
     * 
     * @param digest
     *            The MessageDigest to use (e.g. MD5)
     * @param data
     *            Data to digest
     * @return MD5 digest
     * @throws IOException
     *             On error reading from the stream
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:28.810 -0500", hash_original_method = "BAFA9801ECAE5A57159F89B1B15A5520", hash_generated_method = "6612F428A82251604690485051B0E8F1")
    @DSVerified
    @DSBan(DSCat.PRIVATE_METHOD)
private static byte[] digest(MessageDigest digest, InputStream data) throws IOException {
        byte[] buffer = new byte[STREAM_BUFFER_LENGTH];
        int read = data.read(buffer, 0, STREAM_BUFFER_LENGTH);

        while (read > -1) {
            digest.update(buffer, 0, read);
            read = data.read(buffer, 0, STREAM_BUFFER_LENGTH);
        }

        return digest.digest();
    }

    /**
     * Calls {@link StringUtils#getBytesUtf8(String)}
     * 
     * @param string
     *            the String to encode
     * @return encoded bytes
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:28.820 -0500", hash_original_method = "A8B0080D1D1763385555EF19824C3EF8", hash_generated_method = "8347A029A22C8DEAFDD98626A0D51ECE")
    @DSVerified
    @DSBan(DSCat.PRIVATE_METHOD)
private static byte[] getBytesUtf8(String data) {
        return StringUtils.getBytesUtf8(data);
    }

    /**
     * Returns a <code>MessageDigest</code> for the given <code>algorithm</code>.
     * 
     * @param algorithm
     *            the name of the algorithm requested. See <a
     *            href="http://java.sun.com/j2se/1.3/docs/guide/security/CryptoSpec.html#AppA">Appendix A in the Java
     *            Cryptography Architecture API Specification & Reference</a> for information about standard algorithm
     *            names.
     * @return An MD5 digest instance.
     * @see MessageDigest#getInstance(String)
     * @throws RuntimeException
     *             when a {@link java.security.NoSuchAlgorithmException} is caught.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:28.829 -0500", hash_original_method = "DF3EB66B32665F0E060EA973C31CF288", hash_generated_method = "9337AD88611322AB413985FD8680517F")
    @DSVerified
    @DSBan(DSCat.PRIVATE_METHOD)
static MessageDigest getDigest(String algorithm) {
        try {
            return MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * Returns an MD5 MessageDigest.
     * 
     * @return An MD5 digest instance.
     * @throws RuntimeException
     *             when a {@link java.security.NoSuchAlgorithmException} is caught.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:28.837 -0500", hash_original_method = "D4D63FEDABEF4EF55F5253455D6FD62A", hash_generated_method = "179828FD688E99CC10FB94D3AC359465")
    @DSVerified
    @DSBan(DSCat.PRIVATE_METHOD)
    
private static MessageDigest getMd5Digest() {
        return getDigest("MD5");
    }

    /**
     * Returns an SHA-256 digest.
     * <p>
     * Throws a <code>RuntimeException</code> on JRE versions prior to 1.4.0.
     * </p>
     * 
     * @return An SHA-256 digest instance.
     * @throws RuntimeException
     *             when a {@link java.security.NoSuchAlgorithmException} is caught.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:28.845 -0500", hash_original_method = "C40472FA90D03E56A65788B3F30F1505", hash_generated_method = "944ED692D318F99A77B3B94F802CCAEE")
    @DSVerified
    @DSBan(DSCat.PRIVATE_METHOD)
    
private static MessageDigest getSha256Digest() {
        return getDigest("SHA-256");
    }

    /**
     * Returns an SHA-384 digest.
     * <p>
     * Throws a <code>RuntimeException</code> on JRE versions prior to 1.4.0.
     * </p>
     * 
     * @return An SHA-384 digest instance.
     * @throws RuntimeException
     *             when a {@link java.security.NoSuchAlgorithmException} is caught.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:28.855 -0500", hash_original_method = "FC66D14619CB0FA76AAA16BA67DE1568", hash_generated_method = "1B0A440754E4142A5587C800AE51AA7F")
    @DSVerified
    @DSBan(DSCat.PRIVATE_METHOD)
    
private static MessageDigest getSha384Digest() {
        return getDigest("SHA-384");
    }

    /**
     * Returns an SHA-512 digest.
     * <p>
     * Throws a <code>RuntimeException</code> on JRE versions prior to 1.4.0.
     * </p>
     * 
     * @return An SHA-512 digest instance.
     * @throws RuntimeException
     *             when a {@link java.security.NoSuchAlgorithmException} is caught.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:28.875 -0500", hash_original_method = "189A841D5543ABC845DFBC7A4FD63D8E", hash_generated_method = "80CBDD2A1EA74BA138E0462179A09548")
    @DSVerified
    @DSBan(DSCat.PRIVATE_METHOD)
    
private static MessageDigest getSha512Digest() {
        return getDigest("SHA-512");
    }

    /**
     * Returns an SHA-1 digest.
     * 
     * @return An SHA-1 digest instance.
     * @throws RuntimeException
     *             when a {@link java.security.NoSuchAlgorithmException} is caught.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:28.883 -0500", hash_original_method = "67A8755B6FEC4D1EE7852954389B4C25", hash_generated_method = "582CA9FED788F960CB552A4CECB7C6FF")
    @DSVerified
    @DSBan(DSCat.PRIVATE_METHOD)
    
private static MessageDigest getShaDigest() {
        return getDigest("SHA");
    }

    /**
     * Calculates the MD5 digest and returns the value as a 16 element <code>byte[]</code>.
     * 
     * @param data
     *            Data to digest
     * @return MD5 digest
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:28.891 -0500", hash_original_method = "00DBA8C010B7C6EA5434D2AA9DA14C52", hash_generated_method = "15BD38599AF7D061ABB2FD3E07715A6F")
    @DSVerified
    @DSSafe(DSCat.UTIL_FUNCTION)

public static byte[] md5(byte[] data) {
        return getMd5Digest().digest(data);
    }

    /**
     * Calculates the MD5 digest and returns the value as a 16 element <code>byte[]</code>.
     * 
     * @param data
     *            Data to digest
     * @return MD5 digest
     * @throws IOException
     *             On error reading from the stream
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:28.900 -0500", hash_original_method = "243500F1445933375EAF83B185206C46", hash_generated_method = "929939B76AC27F3A6404EAF1F8A34505")
    @DSVerified
    @DSSafe(DSCat.UTIL_FUNCTION)
    
public static byte[] md5(InputStream data) throws IOException {
        return digest(getMd5Digest(), data);
    }

    /**
     * Calculates the MD5 digest and returns the value as a 16 element <code>byte[]</code>.
     * 
     * @param data
     *            Data to digest
     * @return MD5 digest
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:28.909 -0500", hash_original_method = "99D6F1BE9B07C777E93D0137AC6E1BBF", hash_generated_method = "9E441756E06B451610AEEC84CCF0ADE2")
    @DSVerified
    @DSSafe(DSCat.UTIL_FUNCTION)
    
public static byte[] md5(String data) {
        return md5(getBytesUtf8(data));
    }

    /**
     * Calculates the MD5 digest and returns the value as a 32 character hex string.
     * 
     * @param data
     *            Data to digest
     * @return MD5 digest as a hex string
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:28.917 -0500", hash_original_method = "EBC869C8721A27887ED9951AEA7B17B3", hash_generated_method = "1504F92F15CA490B1D914F13AB913CE9")
    @DSVerified
    @DSSafe(DSCat.UTIL_FUNCTION)
    
    public static String md5Hex(byte[] data) {
        return Hex.encodeHexString(data);
    }

    /**
     * Calculates the MD5 digest and returns the value as a 32 character hex string.
     * 
     * @param data
     *            Data to digest
     * @return MD5 digest as a hex string
     * @throws IOException
     *             On error reading from the stream
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:28.924 -0500", hash_original_method = "A73BACA3B4E038192E965F607F850638", hash_generated_method = "76CBEB04D25F4B740E807CEBA3814F28")
    @DSVerified
    @DSSpec(DSCat.IO)
    
public static String md5Hex(InputStream data) throws IOException {
        return Hex.encodeHexString(md5(data));
    }

    /**
     * Calculates the MD5 digest and returns the value as a 32 character hex string.
     * 
     * @param data
     *            Data to digest
     * @return MD5 digest as a hex string
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:28.932 -0500", hash_original_method = "59142F99E3CC6A5A81C344A4B40F2377", hash_generated_method = "33411700A0440DA9267F9A90B6ABF1A9")
    @DSVerified
    @DSSafe(DSCat.UTIL_FUNCTION)
    
public static String md5Hex(String data) {
        return Hex.encodeHexString(md5(data));
    }

    /**
     * Calculates the SHA-1 digest and returns the value as a <code>byte[]</code>.
     * 
     * @param data
     *            Data to digest
     * @return SHA-1 digest
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:28.940 -0500", hash_original_method = "03753254E092E96423C7A83C5CC1A9C3", hash_generated_method = "CC15A200A73D4992EC958230437F897A")
    @DSVerified
    @DSSafe(DSCat.UTIL_FUNCTION)
    
public static byte[] sha(byte[] data) {
        return getShaDigest().digest(data);
    }

    /**
     * Calculates the SHA-1 digest and returns the value as a <code>byte[]</code>.
     * 
     * @param data
     *            Data to digest
     * @return SHA-1 digest
     * @throws IOException
     *             On error reading from the stream
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:28.948 -0500", hash_original_method = "5EBDBC89FA3BA8C18CA2B40A1EE5F87F", hash_generated_method = "E2ADD2BD170BA1BBD2CA7F91DAFB9CE5")
    @DSVerified
    @DSSpec(DSCat.IO)
    
public static byte[] sha(InputStream data) throws IOException {
        return digest(getShaDigest(), data);
    }

    /**
     * Calculates the SHA-1 digest and returns the value as a <code>byte[]</code>.
     * 
     * @param data
     *            Data to digest
     * @return SHA-1 digest
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:28.955 -0500", hash_original_method = "15F41961C160D456F8E3323E6B9C04D5", hash_generated_method = "7B1C4F23D15C491ABD48D4EF17B52A80")
    
public static byte[] sha(String data) {
        return sha(getBytesUtf8(data));
    }

    /**
     * Calculates the SHA-256 digest and returns the value as a <code>byte[]</code>.
     * <p>
     * Throws a <code>RuntimeException</code> on JRE versions prior to 1.4.0.
     * </p>
     * 
     * @param data
     *            Data to digest
     * @return SHA-256 digest
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:28.963 -0500", hash_original_method = "771B6175C18C16E526CCE4BE3670ABE7", hash_generated_method = "4AA4C7197C7DFB863833D1384EE6EC43")
    
public static byte[] sha256(byte[] data) {
        return getSha256Digest().digest(data);
    }

    /**
     * Calculates the SHA-256 digest and returns the value as a <code>byte[]</code>.
     * <p>
     * Throws a <code>RuntimeException</code> on JRE versions prior to 1.4.0.
     * </p>
     * 
     * @param data
     *            Data to digest
     * @return SHA-256 digest
     * @throws IOException
     *             On error reading from the stream
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:28.970 -0500", hash_original_method = "DC2799CF7E851187E8911CC07ABDB302", hash_generated_method = "AE851C4DDB9B7D0AB27D748CDE20FEDB")
    @DSSpec(DSCat.IO)
public static byte[] sha256(InputStream data) throws IOException {
        return digest(getSha256Digest(), data);
    }

    /**
     * Calculates the SHA-256 digest and returns the value as a <code>byte[]</code>.
     * <p>
     * Throws a <code>RuntimeException</code> on JRE versions prior to 1.4.0.
     * </p>
     * 
     * @param data
     *            Data to digest
     * @return SHA-256 digest
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:28.979 -0500", hash_original_method = "CE03E382F03DD025A15A85972E158DBD", hash_generated_method = "23DA72A1294124428699B7735C4B2D39")
    
public static byte[] sha256(String data) {
        return sha256(getBytesUtf8(data));
    }

    /**
     * Calculates the SHA-256 digest and returns the value as a hex string.
     * <p>
     * Throws a <code>RuntimeException</code> on JRE versions prior to 1.4.0.
     * </p>
     * 
     * @param data
     *            Data to digest
     * @return SHA-256 digest as a hex string
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:28.986 -0500", hash_original_method = "EF8E21E51839AAB1349659EC74B1B426", hash_generated_method = "AC761BC7A5BAF33023980C3C9405E238")
    @DSSafe(DSCat.SAFE_OTHERS)
public static String sha256Hex(byte[] data) {
        return Hex.encodeHexString(sha256(data));
    }

    /**
     * Calculates the SHA-256 digest and returns the value as a hex string.
     * <p>
     * Throws a <code>RuntimeException</code> on JRE versions prior to 1.4.0.
     * </p>
     * 
     * @param data
     *            Data to digest
     * @return SHA-256 digest as a hex string
     * @throws IOException
     *             On error reading from the stream
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:28.994 -0500", hash_original_method = "AAE83DB2AD919861A82743950CD3FB58", hash_generated_method = "0F979C24F235B4A55DE46CF03C3C005E")
    @DSSafe(DSCat.SAFE_OTHERS)
public static String sha256Hex(InputStream data) throws IOException {
        return Hex.encodeHexString(sha256(data));
    }

    /**
     * Calculates the SHA-256 digest and returns the value as a hex string.
     * <p>
     * Throws a <code>RuntimeException</code> on JRE versions prior to 1.4.0.
     * </p>
     * 
     * @param data
     *            Data to digest
     * @return SHA-256 digest as a hex string
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:29.002 -0500", hash_original_method = "EE0D2036A98AFA5E0CE17A68BC067450", hash_generated_method = "C37F99D5AD6A2CE17E7DCCD941CE8EA5")
    @DSSafe(DSCat.SAFE_OTHERS)
public static String sha256Hex(String data) {
        return Hex.encodeHexString(sha256(data));
    }

    /**
     * Calculates the SHA-384 digest and returns the value as a <code>byte[]</code>.
     * <p>
     * Throws a <code>RuntimeException</code> on JRE versions prior to 1.4.0.
     * </p>
     * 
     * @param data
     *            Data to digest
     * @return SHA-384 digest
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:29.009 -0500", hash_original_method = "4C3E3E79257D1C7DB00CE411F8327D07", hash_generated_method = "3054D1C06BD5E4739C41763303021BC5")
    @DSSafe(DSCat.SAFE_OTHERS)
public static byte[] sha384(byte[] data) {
        return getSha384Digest().digest(data);
    }

    /**
     * Calculates the SHA-384 digest and returns the value as a <code>byte[]</code>.
     * <p>
     * Throws a <code>RuntimeException</code> on JRE versions prior to 1.4.0.
     * </p>
     * 
     * @param data
     *            Data to digest
     * @return SHA-384 digest
     * @throws IOException
     *             On error reading from the stream
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:29.017 -0500", hash_original_method = "BFC7ADC7798C8B302495F7610AC35F84", hash_generated_method = "FEC72A6428B4F8560217DFB206957375")
    @DSSafe(DSCat.SAFE_OTHERS)
public static byte[] sha384(InputStream data) throws IOException {
        return digest(getSha384Digest(), data);
    }

    /**
     * Calculates the SHA-384 digest and returns the value as a <code>byte[]</code>.
     * <p>
     * Throws a <code>RuntimeException</code> on JRE versions prior to 1.4.0.
     * </p>
     * 
     * @param data
     *            Data to digest
     * @return SHA-384 digest
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:29.024 -0500", hash_original_method = "6986A2B37C5264417B79B1F4A45429BD", hash_generated_method = "6F8E3293883354154DEC75EA3C73E4E0")
    @DSSafe(DSCat.SAFE_OTHERS)
public static byte[] sha384(String data) {
        return sha384(getBytesUtf8(data));
    }

    /**
     * Calculates the SHA-384 digest and returns the value as a hex string.
     * <p>
     * Throws a <code>RuntimeException</code> on JRE versions prior to 1.4.0.
     * </p>
     * 
     * @param data
     *            Data to digest
     * @return SHA-384 digest as a hex string
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:29.033 -0500", hash_original_method = "50190664B4123DF961B95E3A5EE265B2", hash_generated_method = "037F29B581B8F268FEEE3957B5B12B60")
    @DSSafe(DSCat.SAFE_OTHERS)
public static String sha384Hex(byte[] data) {
        return Hex.encodeHexString(sha384(data));
    }

    /**
     * Calculates the SHA-384 digest and returns the value as a hex string.
     * <p>
     * Throws a <code>RuntimeException</code> on JRE versions prior to 1.4.0.
     * </p>
     * 
     * @param data
     *            Data to digest
     * @return SHA-384 digest as a hex string
     * @throws IOException
     *             On error reading from the stream
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:29.040 -0500", hash_original_method = "71657F1F40B071F0D037E7FC1F4B435E", hash_generated_method = "09DDDB55F67DB2F444CBAA4BB2514CF2")
    @DSSpec(DSCat.IO)
public static String sha384Hex(InputStream data) throws IOException {
        return Hex.encodeHexString(sha384(data));
    }

    /**
     * Calculates the SHA-384 digest and returns the value as a hex string.
     * <p>
     * Throws a <code>RuntimeException</code> on JRE versions prior to 1.4.0.
     * </p>
     * 
     * @param data
     *            Data to digest
     * @return SHA-384 digest as a hex string
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:29.047 -0500", hash_original_method = "712C5AB3F2E44A74D99CC74A47C4F0D4", hash_generated_method = "5D493C2C508F1F007BC26D2B80424BEC")
    
    @DSSafe(DSCat.SAFE_OTHERS)
public static String sha384Hex(String data) {
        return Hex.encodeHexString(sha384(data));
    }

    /**
     * Calculates the SHA-512 digest and returns the value as a <code>byte[]</code>.
     * <p>
     * Throws a <code>RuntimeException</code> on JRE versions prior to 1.4.0.
     * </p>
     * 
     * @param data
     *            Data to digest
     * @return SHA-512 digest
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:29.056 -0500", hash_original_method = "8FCC3F0E0A5D8FFFF2EC5D3079BCE516", hash_generated_method = "89D82F7C27D9F3D996D8459B5098596C")
    
    @DSSafe(DSCat.SAFE_OTHERS)
public static byte[] sha512(byte[] data) {
        return getSha512Digest().digest(data);
    }

    /**
     * Calculates the SHA-512 digest and returns the value as a <code>byte[]</code>.
     * <p>
     * Throws a <code>RuntimeException</code> on JRE versions prior to 1.4.0.
     * </p>
     * 
     * @param data
     *            Data to digest
     * @return SHA-512 digest
     * @throws IOException
     *             On error reading from the stream
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:29.063 -0500", hash_original_method = "983E0E6C2CAAD08C146D380FD1390B11", hash_generated_method = "50A8FDFF2CCC7D0C4B6537E24623E557")
    @DSSpec(DSCat.IO)    
public static byte[] sha512(InputStream data) throws IOException {
        return digest(getSha512Digest(), data);
    }

    /**
     * Calculates the SHA-512 digest and returns the value as a <code>byte[]</code>.
     * <p>
     * Throws a <code>RuntimeException</code> on JRE versions prior to 1.4.0.
     * </p>
     * 
     * @param data
     *            Data to digest
     * @return SHA-512 digest
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:29.071 -0500", hash_original_method = "6A7026A9D9DABE2CFEC525523BE2256F", hash_generated_method = "454135273088C4BA6B3CEA5E93C7CB5F")
    @DSSafe(DSCat.SAFE_OTHERS)
public static byte[] sha512(String data) {
        return sha512(getBytesUtf8(data));
    }

    /**
     * Calculates the SHA-512 digest and returns the value as a hex string.
     * <p>
     * Throws a <code>RuntimeException</code> on JRE versions prior to 1.4.0.
     * </p>
     * 
     * @param data
     *            Data to digest
     * @return SHA-512 digest as a hex string
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:29.079 -0500", hash_original_method = "E7C11CC1C20C82FA934F4E0A14372CFF", hash_generated_method = "C18525F72545C4D0BED4CCF2CFBC6A7D")
    
    @DSSafe(DSCat.SAFE_OTHERS)
public static String sha512Hex(byte[] data) {
        return Hex.encodeHexString(sha512(data));
    }

    /**
     * Calculates the SHA-512 digest and returns the value as a hex string.
     * <p>
     * Throws a <code>RuntimeException</code> on JRE versions prior to 1.4.0.
     * </p>
     * 
     * @param data
     *            Data to digest
     * @return SHA-512 digest as a hex string
     * @throws IOException
     *             On error reading from the stream
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:29.087 -0500", hash_original_method = "B33F4935D7EC88037EE2967518A095D3", hash_generated_method = "94868AEDB16628F241D8220AA3C50090")
    @DSSpec(DSCat.IO)    
public static String sha512Hex(InputStream data) throws IOException {
        return Hex.encodeHexString(sha512(data));
    }

    /**
     * Calculates the SHA-512 digest and returns the value as a hex string.
     * <p>
     * Throws a <code>RuntimeException</code> on JRE versions prior to 1.4.0.
     * </p>
     * 
     * @param data
     *            Data to digest
     * @return SHA-512 digest as a hex string
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:29.095 -0500", hash_original_method = "A969952D53CEAA1B2502233B0103B168", hash_generated_method = "C990E26B56E4D40DE2701EE3C30A7542")
    
    @DSSafe(DSCat.SAFE_OTHERS)
public static String sha512Hex(String data) {
        return Hex.encodeHexString(sha512(data));
    }

    /**
     * Calculates the SHA-1 digest and returns the value as a hex string.
     * 
     * @param data
     *            Data to digest
     * @return SHA-1 digest as a hex string
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:29.103 -0500", hash_original_method = "F28F727E5F413064904114AD04815D92", hash_generated_method = "09DA7215CDE229B39D8436EBEC11F48F")
    
    @DSSafe(DSCat.SAFE_OTHERS)
public static String shaHex(byte[] data) {
        return Hex.encodeHexString(sha(data));
    }

    /**
     * Calculates the SHA-1 digest and returns the value as a hex string.
     * 
     * @param data
     *            Data to digest
     * @return SHA-1 digest as a hex string
     * @throws IOException
     *             On error reading from the stream
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:29.111 -0500", hash_original_method = "595FB122BE687C917ADE2E9A2DC3AEA8", hash_generated_method = "8B068CE3B77028BCE3825E6279217FDE")
    @DSSpec(DSCat.IO)    
public static String shaHex(InputStream data) throws IOException {
        return Hex.encodeHexString(sha(data));
    }

    /**
     * Calculates the SHA-1 digest and returns the value as a hex string.
     * 
     * @param data
     *            Data to digest
     * @return SHA-1 digest as a hex string
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-24 15:47:29.119 -0500", hash_original_method = "6929FD851823CABACBBA56CA25293DF7", hash_generated_method = "C4E4AC3662EE8D02DA0C6E726D1236E4")
    
    @DSSafe(DSCat.SAFE_OTHERS)
public static String shaHex(String data) {
        return Hex.encodeHexString(sha(data));
    }
}
