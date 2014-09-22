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
package org.apache.commons.io.filefilter;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Arrays;

import org.apache.commons.io.IOUtils;

/**
 * <p>
 * File filter for matching files containing a "magic number". A magic number 
 * is a unique series of bytes common to all files of a specific file format.
 * For instance, all Java class files begin with the bytes 
 * <code>0xCAFEBABE</code>. 
 * </p>
 * 
 * <code><pre>
 * File dir = new File(".");
 * MagicNumberFileFilter javaClassFileFilter =
 *     MagicNumberFileFilter(new byte[] {(byte) 0xCA, (byte) 0xFE, 
 *       (byte) 0xBA, (byte) 0xBE}); 
 * String[] javaClassFiles = dir.list(javaClassFileFilter);
 * for (String javaClassFile : javaClassFiles) {
 *     System.out.println(javaClassFile);
 * }
 * </pre></code>
 * 
 * <p>
 * Sometimes, such as in the case of TAR files, the
 * magic number will be offset by a certain number of bytes in the file. In the
 * case of TAR archive files, this offset is 257 bytes.
 * </p>
 * 
 * <code><pre>
 * File dir = new File(".");
 * MagicNumberFileFilter tarFileFilter = 
 *     MagicNumberFileFilter("ustar", 257); 
 * String[] tarFiles = dir.list(tarFileFilter);
 * for (String tarFile : tarFiles) {
 *     System.out.println(tarFile);
 * }
 * </pre></code>
 * @since 2.0
 * @see FileFilterUtils#magicNumberFileFilter(byte[])
 * @see FileFilterUtils#magicNumberFileFilter(String)
 * @see FileFilterUtils#magicNumberFileFilter(byte[], long)
 * @see FileFilterUtils#magicNumberFileFilter(String, long)
 */
public class MagicNumberFileFilter extends AbstractFileFilter implements
        Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.981 -0400", hash_original_field = "89A10596F0FDB3A1DEAAE69720F7C9DE", hash_generated_field = "3D72E565CCDBEA9E9149D396EC67955D")

    private static final long serialVersionUID = -547733176983104172L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.982 -0400", hash_original_field = "6FC0688624AC94720D0E9544E1A70E09", hash_generated_field = "43B4B88F8872CE70BC0ACCCB066E1B74")

    private  byte[] magicNumbers;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.982 -0400", hash_original_field = "056601C0DAB9167E2A12FE4FA751739F", hash_generated_field = "EAC26F9C009071957019CBC1252212E9")

    private  long byteOffset;
    
    /**
     * <p>
     * Constructs a new MagicNumberFileFilter and associates it with the magic
     * number to test for in files. This constructor assumes a starting offset
     * of <code>0</code>.
     * </p>
     * 
     * <p>
     * It is important to note that <em>the array is not cloned</em> and that
     * any changes to the magic number array after construction will affect the
     * behavior of this file filter.
     * </p>
     * 
     * <code><pre>
     * MagicNumberFileFilter javaClassFileFilter =
     *     MagicNumberFileFilter(new byte[] {(byte) 0xCA, (byte) 0xFE, 
     *       (byte) 0xBA, (byte) 0xBE}); 
     * </pre></code>
     * 
     * @param magicNumber the magic number to look for in the file.
     * 
     * @throws IllegalArgumentException if <code>magicNumber</code> is 
     *         {@code null}, or contains no bytes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.983 -0400", hash_original_method = "C78AFEA84D3E16F05915DC512C12F4E5", hash_generated_method = "C3204024855C82A82A55E8905C45204F")
    
public MagicNumberFileFilter(byte[] magicNumber) {
        this(magicNumber, 0);
    }
    
    /**
     * <p>
     * Constructs a new MagicNumberFileFilter and associates it with the magic
     * number to test for in files. This constructor assumes a starting offset
     * of <code>0</code>.
     * </p>
     * 
     * Example usage:
     * <pre>
     * {@code
     * MagicNumberFileFilter xmlFileFilter = 
     *     MagicNumberFileFilter("<?xml"); 
     * }
     * </pre>
     * 
     * @param magicNumber the magic number to look for in the file.
     *        The string is converted to bytes using the platform default charset.
     *
     * @throws IllegalArgumentException if <code>magicNumber</code> is 
     *         {@code null} or the empty String.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.983 -0400", hash_original_method = "46FC766430A04DE64FCA15E7760EC637", hash_generated_method = "6A18B900A3FD348B51DEACB4F7F27DE7")
    
public MagicNumberFileFilter(String magicNumber) {
        this(magicNumber, 0);
    }
    
    /**
     * <p>
     * Constructs a new MagicNumberFileFilter and associates it with the magic
     * number to test for in files and the byte offset location in the file to
     * to look for that magic number.
     * </p>
     * 
     * <code><pre>
     * MagicNumberFileFilter tarFileFilter = 
     *     MagicNumberFileFilter("ustar", 257); 
     * </pre></code>
     * 
     * @param magicNumber the magic number to look for in the file. 
     *        The string is converted to bytes using the platform default charset.
     * @param offset the byte offset in the file to start comparing bytes.
     * 
     * @throws IllegalArgumentException if <code>magicNumber</code> is 
     *         {@code null} or the empty String, or <code>offset</code> is 
     *         a negative number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.984 -0400", hash_original_method = "DEAF1CD32A03908C66FCBD851D1A4D16", hash_generated_method = "AD18EC5ED27B6B841B29EC1DF5A51D47")
    
public MagicNumberFileFilter(String magicNumber, long offset) {
        if (magicNumber == null) {
            throw new IllegalArgumentException("The magic number cannot be null");
        }
        if (magicNumber.length() == 0) {
            throw new IllegalArgumentException("The magic number must contain at least one byte");
        }
        if (offset < 0) {
            throw new IllegalArgumentException("The offset cannot be negative");
        }
        
        this.magicNumbers = magicNumber.getBytes(); // uses the platform default charset
        this.byteOffset = offset;
    }
    
    /**
     * <p>
     * Constructs a new MagicNumberFileFilter and associates it with the magic
     * number to test for in files and the byte offset location in the file to
     * to look for that magic number.
     * </p>
     * 
     * <p>
     * It is important to note that <em>the array is not cloned</em> and that
     * any changes to the magic number array after construction will affect the
     * behavior of this file filter.
     * </p>
     * 
     * <code><pre>
     * MagicNumberFileFilter tarFileFilter =
     *     MagicNumberFileFilter(new byte[] {0x75, 0x73, 0x74, 0x61, 0x72}, 257); 
     * </pre></code>
     * 
     * <code><pre>
     * MagicNumberFileFilter javaClassFileFilter =
     *     MagicNumberFileFilter(new byte[] {0xCA, 0xFE, 0xBA, 0xBE}, 0); 
     * </pre></code>
     * 
     * @param magicNumber the magic number to look for in the file.
     * @param offset the byte offset in the file to start comparing bytes.
     * 
     * @throws IllegalArgumentException if <code>magicNumber</code> is 
     *         {@code null}, or contains no bytes, or <code>offset</code> 
     *         is a negative number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.985 -0400", hash_original_method = "D2ACF25BC388A9DF48A2CB806BA6CFAE", hash_generated_method = "CFEE8616F5B98043F7F236D46BC5E8DE")
    
public MagicNumberFileFilter(byte[] magicNumber, long offset) {
        if (magicNumber == null) {
            throw new IllegalArgumentException("The magic number cannot be null");
        }
        if (magicNumber.length == 0) {
            throw new IllegalArgumentException("The magic number must contain at least one byte");
        }
        if (offset < 0) {
            throw new IllegalArgumentException("The offset cannot be negative");
        }
        
        this.magicNumbers = new byte[magicNumber.length];
        System.arraycopy(magicNumber, 0, this.magicNumbers, 0, magicNumber.length);
        this.byteOffset = offset;
    }
    
    /**
     * <p>
     * Accepts the provided file if the file contains the file filter's magic
     * number at the specified offset.
     * </p>
     * 
     * <p>
     * If any {@link IOException}s occur while reading the file, the file will
     * be rejected.
     * </p>
     * 
     * @param file the file to accept or reject.
     * 
     * @return {@code true} if the file contains the filter's magic number 
     *         at the specified offset, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.986 -0400", hash_original_method = "B71D2F390F50A93DB66E9BFC22DCB2BE", hash_generated_method = "A38847374E5303EDABDBBBA7B0B041C8")
    
@Override
    public boolean accept(File file) {
        if (file != null && file.isFile() && file.canRead()) {
            RandomAccessFile randomAccessFile = null;
            try {
                byte[] fileBytes = new byte[this.magicNumbers.length]; 
                randomAccessFile = new RandomAccessFile(file, "r");
                randomAccessFile.seek(byteOffset);
                int read = randomAccessFile.read(fileBytes);
                if (read != magicNumbers.length) {
                    return false;
                }
                return Arrays.equals(this.magicNumbers, fileBytes);
            } catch (IOException ioe) {
                // Do nothing, fall through and do not accept file
            } finally {
                IOUtils.closeQuietly(randomAccessFile);
            }
        }
        
        return false;
    }

    /**
     * Returns a String representation of the file filter, which includes the 
     * magic number bytes and byte offset.
     * 
     * @return a String representation of the file filter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.987 -0400", hash_original_method = "CB513BDE86C193A798DC85AC9115E8A4", hash_generated_method = "7FFE9169098715172BAEA6D91F058509")
    
@Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append("(");
        builder.append(new String(magicNumbers));// TODO perhaps use hex if value is not printable
        builder.append(",");
        builder.append(this.byteOffset);
        builder.append(")");
        return builder.toString();
    }
}
