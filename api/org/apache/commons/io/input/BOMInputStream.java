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
package org.apache.commons.io.input;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.io.ByteOrderMark;

/**
 * This class is used to wrap a stream that includes an encoded {@link ByteOrderMark} as its first bytes.
 * 
 * This class detects these bytes and, if required, can automatically skip them and return the subsequent byte as the
 * first byte in the stream.
 * 
 * The {@link ByteOrderMark} implementation has the following pre-defined BOMs:
 * <ul>
 * <li>UTF-8 - {@link ByteOrderMark#UTF_8}</li>
 * <li>UTF-16BE - {@link ByteOrderMark#UTF_16LE}</li>
 * <li>UTF-16LE - {@link ByteOrderMark#UTF_16BE}</li>
 * <li>UTF-32BE - {@link ByteOrderMark#UTF_32LE}</li>
 * <li>UTF-32LE - {@link ByteOrderMark#UTF_32BE}</li>
 * </ul>
 * 
 * 
 * <h3>Example 1 - Detect and exclude a UTF-8 BOM</h3>
 * 
 * <pre>
 * BOMInputStream bomIn = new BOMInputStream(in);
 * if (bomIn.hasBOM()) {
 *     // has a UTF-8 BOM
 * }
 * </pre>
 * 
 * <h3>Example 2 - Detect a UTF-8 BOM (but don't exclude it)</h3>
 * 
 * <pre>
 * boolean include = true;
 * BOMInputStream bomIn = new BOMInputStream(in, include);
 * if (bomIn.hasBOM()) {
 *     // has a UTF-8 BOM
 * }
 * </pre>
 * 
 * <h3>Example 3 - Detect Multiple BOMs</h3>
 * 
 * <pre>
 * BOMInputStream bomIn = new BOMInputStream(in, 
 *   ByteOrderMark.UTF_16LE, ByteOrderMark.UTF_16BE,
 *   ByteOrderMark.UTF_32LE, ByteOrderMark.UTF_32BE
 *   );
 * if (bomIn.hasBOM() == false) {
 *     // No BOM found
 * } else if (bomIn.hasBOM(ByteOrderMark.UTF_16LE)) {
 *     // has a UTF-16LE BOM
 * } else if (bomIn.hasBOM(ByteOrderMark.UTF_16BE)) {
 *     // has a UTF-16BE BOM
 * } else if (bomIn.hasBOM(ByteOrderMark.UTF_32LE)) {
 *     // has a UTF-32LE BOM
 * } else if (bomIn.hasBOM(ByteOrderMark.UTF_32BE)) {
 *     // has a UTF-32BE BOM
 * }
 * </pre>
 * 
 * @see org.apache.commons.io.ByteOrderMark
 * @see <a href="http://en.wikipedia.org/wiki/Byte_order_mark">Wikipedia - Byte Order Mark</a>
 * @version $Id: BOMInputStream.java 1346400 2012-06-05 14:48:01Z ggregory $
 * @since 2.0
 */
public class BOMInputStream extends ProxyInputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.895 -0400", hash_original_field = "4318D44D8001FBFB9DBE16088B407908", hash_generated_field = "E4A39242B5FB73D31830EC889AA7F6B0")

    private static final Comparator<ByteOrderMark> ByteOrderMarkLengthComparator = new Comparator<ByteOrderMark>() {

        @DSSafe(DSCat.SAFE_LIST)
        public int compare(ByteOrderMark bom1, ByteOrderMark bom2) {
            int len1 = bom1.length();
            int len2 = bom2.length();
            if (len1 > len2) {
                return -1;
            }
            if (len2 > len1) {
                return 1;
            }
            return 0;
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.888 -0400", hash_original_field = "77B86723862A2A417AAF096EE5C79FA7", hash_generated_field = "4732FB9EC479592E31D18C2E147CCEF5")

    private  boolean include;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.889 -0400", hash_original_field = "4FB8C61B1559EDEE1C35FF1A34BEB767", hash_generated_field = "128232CF18F0059B4006C941DC9C3CB4")

    private  List<ByteOrderMark> boms;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.890 -0400", hash_original_field = "C6FD36D8B29DE88E11248CAE678D9101", hash_generated_field = "CA401115BEBAB5CC1A6F32D4C988E25E")

    private ByteOrderMark byteOrderMark;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.890 -0400", hash_original_field = "0087D1874070517526FA45A782C04214", hash_generated_field = "B668286A56203F4EBCDE7FCB958045E0")

    private int[] firstBytes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.891 -0400", hash_original_field = "CF5D939A1EF9F8AAF29BAF86467DC268", hash_generated_field = "EF5803530CF2C32C70962EA47FFF686F")

    private int fbLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.891 -0400", hash_original_field = "AD90F1F6C03A16CE8CB09517C0D1C3E4", hash_generated_field = "BB2CC2EBE7EE3208501861C1CDCACC96")

    private int fbIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.892 -0400", hash_original_field = "FEEB4F48751A6EC151EC899ED97ECFC8", hash_generated_field = "F7971AC97BF92BCF248BAF9A7C60C771")

    private int markFbIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.892 -0400", hash_original_field = "84117F89F52C342DCE04FE189AB2BBD0", hash_generated_field = "EFD3ECCEB5CCD8383331794060B0D974")

    private boolean markedAtStart;

    /**
     * Constructs a new BOM InputStream that excludes a {@link ByteOrderMark#UTF_8} BOM.
     * 
     * @param delegate
     *            the InputStream to delegate to
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.893 -0400", hash_original_method = "8F5EED53C398BBC974E14B6354247605", hash_generated_method = "83605C1A80ECE55FFF0567FA430561AF")
    
public BOMInputStream(InputStream delegate) {
        this(delegate, false, ByteOrderMark.UTF_8);
    }

    /**
     * Constructs a new BOM InputStream that detects a a {@link ByteOrderMark#UTF_8} and optionally includes it.
     * 
     * @param delegate
     *            the InputStream to delegate to
     * @param include
     *            true to include the UTF-8 BOM or false to exclude it
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.893 -0400", hash_original_method = "09BCCCE0FE56EF006EB9ED7A73FB1600", hash_generated_method = "E26F5E092FAEB3842B408B4049D78795")
    
public BOMInputStream(InputStream delegate, boolean include) {
        this(delegate, include, ByteOrderMark.UTF_8);
    }

    /**
     * Constructs a new BOM InputStream that excludes the specified BOMs.
     * 
     * @param delegate
     *            the InputStream to delegate to
     * @param boms
     *            The BOMs to detect and exclude
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.894 -0400", hash_original_method = "3EE76FAAD44E7D402237FB87195A0164", hash_generated_method = "96841BFB408C4B5DF5056E5A74E9CB8E")
    
public BOMInputStream(InputStream delegate, ByteOrderMark... boms) {
        this(delegate, false, boms);
    }

    /**
     * Constructs a new BOM InputStream that detects the specified BOMs and optionally includes them.
     * 
     * @param delegate
     *            the InputStream to delegate to
     * @param include
     *            true to include the specified BOMs or false to exclude them
     * @param boms
     *            The BOMs to detect and optionally exclude
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.896 -0400", hash_original_method = "0CFB1A71152A30E9C19BA043AD8B50FF", hash_generated_method = "F765853CEB70044C2B5E4F540B6E0EEE")
    
public BOMInputStream(InputStream delegate, boolean include, ByteOrderMark... boms) {
        super(delegate);
        if (boms == null || boms.length == 0) {
            throw new IllegalArgumentException("No BOMs specified");
        }
        this.include = include;
        // Sort the BOMs to match the longest BOM first because some BOMs have the same starting two bytes.
        Arrays.sort(boms, ByteOrderMarkLengthComparator);
        this.boms = Arrays.asList(boms);

    }

    /**
     * Indicates whether the stream contains one of the specified BOMs.
     * 
     * @return true if the stream has one of the specified BOMs, otherwise false if it does not
     * @throws IOException
     *             if an error reading the first bytes of the stream occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.897 -0400", hash_original_method = "B6BA1F8A511F86D4BD07A400290A4051", hash_generated_method = "FD075556C8202DAD5701750D95F5D0CB")
    
public boolean hasBOM() throws IOException {
        return getBOM() != null;
    }

    /**
     * Indicates whether the stream contains the specified BOM.
     * 
     * @param bom
     *            The BOM to check for
     * @return true if the stream has the specified BOM, otherwise false if it does not
     * @throws IllegalArgumentException
     *             if the BOM is not one the stream is configured to detect
     * @throws IOException
     *             if an error reading the first bytes of the stream occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.897 -0400", hash_original_method = "76FEA3BC51FC08A39946D800AEA6E194", hash_generated_method = "8BE7AECBAD931DC21189BF552D24BF5F")
    
public boolean hasBOM(ByteOrderMark bom) throws IOException {
        if (!boms.contains(bom)) {
            throw new IllegalArgumentException("Stream not configure to detect " + bom);
        }
        return byteOrderMark != null && getBOM().equals(bom);
    }

    /**
     * Return the BOM (Byte Order Mark).
     * 
     * @return The BOM or null if none
     * @throws IOException
     *             if an error reading the first bytes of the stream occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.898 -0400", hash_original_method = "18EFB02AF45D2A482B99C0D271762E17", hash_generated_method = "357D09C0FC45BED370D2B5FE67BC1A4D")
    
public ByteOrderMark getBOM() throws IOException {
        if (firstBytes == null) {
            fbLength = 0;
            // BOMs are sorted from longest to shortest
            final int maxBomSize = boms.get(0).length();
            firstBytes = new int[maxBomSize];
            // Read first maxBomSize bytes
            for (int i = 0; i < firstBytes.length; i++) {
                firstBytes[i] = in.read();
                fbLength++;
                if (firstBytes[i] < 0) {
                    break;
                }
            }
            // match BOM in firstBytes
            byteOrderMark = find();
            if (byteOrderMark != null) {
                if (!include) {
                    if (byteOrderMark.length() < firstBytes.length) {
                        fbIndex = byteOrderMark.length();
                    } else {
                        fbLength = 0;
                    }
                }
            }
        }
        return byteOrderMark;
    }

    /**
     * Return the BOM charset Name - {@link ByteOrderMark#getCharsetName()}.
     * 
     * @return The BOM charset Name or null if no BOM found
     * @throws IOException
     *             if an error reading the first bytes of the stream occurs
     * 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.899 -0400", hash_original_method = "147F0F142DF712D035A23C7A58DC3617", hash_generated_method = "D2317A0EB99DC568DBC29F7F3BEBA142")
    
public String getBOMCharsetName() throws IOException {
        getBOM();
        return byteOrderMark == null ? null : byteOrderMark.getCharsetName();
    }

    /**
     * This method reads and either preserves or skips the first bytes in the stream. It behaves like the single-byte
     * <code>read()</code> method, either returning a valid byte or -1 to indicate that the initial bytes have been
     * processed already.
     * 
     * @return the byte read (excluding BOM) or -1 if the end of stream
     * @throws IOException
     *             if an I/O error occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.899 -0400", hash_original_method = "08EB96B3976F162AB99C66BBE24B1EE1", hash_generated_method = "8AAD2B13A98CD6FA07ECAD8FA050BE34")
    
private int readFirstBytes() throws IOException {
        getBOM();
        return fbIndex < fbLength ? firstBytes[fbIndex++] : -1;
    }

    /**
     * Find a BOM with the specified bytes.
     * 
     * @return The matched BOM or null if none matched
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.900 -0400", hash_original_method = "4400B3E15A2A28E8125FDEC9DF38B771", hash_generated_method = "92DCC8E1A5682EE4914998B1B41402AB")
    
private ByteOrderMark find() {
        for (ByteOrderMark bom : boms) {
            if (matches(bom)) {
                return bom;
            }
        }
        return null;
    }

    /**
     * Check if the bytes match a BOM.
     * 
     * @param bom
     *            The BOM
     * @return true if the bytes match the bom, otherwise false
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.900 -0400", hash_original_method = "64D36B57D71FC274E4DB32E2B8B74584", hash_generated_method = "FFE7C30F37DD29F4CD5A755E2174E9B5")
    
private boolean matches(ByteOrderMark bom) {
        // if (bom.length() != fbLength) {
        // return false;
        // }
        // firstBytes may be bigger than the BOM bytes
        for (int i = 0; i < bom.length(); i++) {
            if (bom.get(i) != firstBytes[i]) {
                return false;
            }
        }
        return true;
    }

    // ----------------------------------------------------------------------------
    // Implementation of InputStream
    // ----------------------------------------------------------------------------

    /**
     * Invokes the delegate's <code>read()</code> method, detecting and optionally skipping BOM.
     * 
     * @return the byte read (excluding BOM) or -1 if the end of stream
     * @throws IOException
     *             if an I/O error occurs
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.901 -0400", hash_original_method = "F5B14E56E9F55893C6E73E7F84E5B216", hash_generated_method = "DDDED9E8EB076EC7E62CE11BE57C9D18")
    
@Override
    public int read() throws IOException {
        int b = readFirstBytes();
        return b >= 0 ? b : in.read();
    }

    /**
     * Invokes the delegate's <code>read(byte[], int, int)</code> method, detecting and optionally skipping BOM.
     * 
     * @param buf
     *            the buffer to read the bytes into
     * @param off
     *            The start offset
     * @param len
     *            The number of bytes to read (excluding BOM)
     * @return the number of bytes read or -1 if the end of stream
     * @throws IOException
     *             if an I/O error occurs
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.902 -0400", hash_original_method = "98E223E86C4C3137EA234A101C3EBA8B", hash_generated_method = "79BB4DED901112DADFA16BD14893D1B8")
    
@Override
    public int read(byte[] buf, int off, int len) throws IOException {
        int firstCount = 0;
        int b = 0;
        while (len > 0 && b >= 0) {
            b = readFirstBytes();
            if (b >= 0) {
                buf[off++] = (byte) (b & 0xFF);
                len--;
                firstCount++;
            }
        }
        int secondCount = in.read(buf, off, len);
        return secondCount < 0 ? firstCount > 0 ? firstCount : -1 : firstCount + secondCount;
    }

    /**
     * Invokes the delegate's <code>read(byte[])</code> method, detecting and optionally skipping BOM.
     * 
     * @param buf
     *            the buffer to read the bytes into
     * @return the number of bytes read (excluding BOM) or -1 if the end of stream
     * @throws IOException
     *             if an I/O error occurs
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.902 -0400", hash_original_method = "2F668D010292F41F8534D9B42F402EB1", hash_generated_method = "E92D53D06BA9BE55F7FB3173E2C57885")
    
@Override
    public int read(byte[] buf) throws IOException {
        return read(buf, 0, buf.length);
    }

    /**
     * Invokes the delegate's <code>mark(int)</code> method.
     * 
     * @param readlimit
     *            read ahead limit
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.903 -0400", hash_original_method = "6F22E04E6B2233AB267E29E6FFA8C482", hash_generated_method = "240936CBCDAFBFE729A39816CE834244")
    
@Override
    public synchronized void mark(int readlimit) {
        markFbIndex = fbIndex;
        markedAtStart = firstBytes == null;
        in.mark(readlimit);
    }

    /**
     * Invokes the delegate's <code>reset()</code> method.
     * 
     * @throws IOException
     *             if an I/O error occurs
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.904 -0400", hash_original_method = "707E3CF4FCF7B50ABDC5BD8089A4C948", hash_generated_method = "B3C695434B3A659E73AEB9F3AFC5AAFF")
    
@Override
    public synchronized void reset() throws IOException {
        fbIndex = markFbIndex;
        if (markedAtStart) {
            firstBytes = null;
        }

        in.reset();
    }

    /**
     * Invokes the delegate's <code>skip(long)</code> method, detecting and optionallyskipping BOM.
     * 
     * @param n
     *            the number of bytes to skip
     * @return the number of bytes to skipped or -1 if the end of stream
     * @throws IOException
     *             if an I/O error occurs
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.904 -0400", hash_original_method = "56B6CF5404852C2E1FA523B4DDC1E2FF", hash_generated_method = "209C604B5C1640CFBD3CF7995BBB2E9A")
    
@Override
    public long skip(long n) throws IOException {
        while (n > 0 && readFirstBytes() >= 0) {
            n--;
        }
        return in.skip(n);
    }
}
