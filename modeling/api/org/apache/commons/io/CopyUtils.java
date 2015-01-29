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
package org.apache.commons.io;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;

/**
 * This class provides static utility methods for buffered
 * copying between sources (<code>InputStream</code>, <code>Reader</code>,
 * <code>String</code> and <code>byte[]</code>) and destinations
 * (<code>OutputStream</code>, <code>Writer</code>, <code>String</code> and
 * <code>byte[]</code>).
 * <p>
 * Unless otherwise noted, these <code>copy</code> methods do <em>not</em>
 * flush or close the streams. Often doing so would require making non-portable
 * assumptions about the streams' origin and further use. This means that both
 * streams' <code>close()</code> methods must be called after copying. if one
 * omits this step, then the stream resources (sockets, file descriptors) are
 * released when the associated Stream is garbage-collected. It is not a good
 * idea to rely on this mechanism. For a good overview of the distinction
 * between "memory management" and "resource management", see
 * <a href="http://www.unixreview.com/articles/1998/9804/9804ja/ja.htm">this
 * UnixReview article</a>.
 * <p>
 * For byte-to-char methods, a <code>copy</code> variant allows the encoding
 * to be selected (otherwise the platform default is used). We would like to
 * encourage you to always specify the encoding because relying on the platform
 * default can lead to unexpected results.
 * <p
 * We don't provide special variants for the <code>copy</code> methods that
 * let you specify the buffer size because in modern VMs the impact on speed
 * seems to be minimal. We're using a default buffer size of 4 KB.
 * <p>
 * The <code>copy</code> methods use an internal buffer when copying. It is
 * therefore advisable <em>not</em> to deliberately wrap the stream arguments
 * to the <code>copy</code> methods in <code>Buffered*</code> streams. For
 * example, don't do the following:
 * <pre>
 *  copy( new BufferedInputStream( in ), new BufferedOutputStream( out ) );
 *  </pre>
 * The rationale is as follows:
 * <p>
 * Imagine that an InputStream's read() is a very expensive operation, which
 * would usually suggest wrapping in a BufferedInputStream. The
 * BufferedInputStream works by issuing infrequent
 * {@link java.io.InputStream#read(byte[] b, int off, int len)} requests on the
 * underlying InputStream, to fill an internal buffer, from which further
 * <code>read</code> requests can inexpensively get their data (until the buffer
 * runs out).
 * <p>
 * However, the <code>copy</code> methods do the same thing, keeping an
 * internal buffer, populated by
 * {@link InputStream#read(byte[] b, int off, int len)} requests. Having two
 * buffers (or three if the destination stream is also buffered) is pointless,
 * and the unnecessary buffer management hurts performance slightly (about 3%,
 * according to some simple experiments).
 * <p>
 * Behold, intrepid explorers; a map of this class:
 * <pre>
 *       Method      Input               Output          Dependency
 *       ------      -----               ------          -------
 * 1     copy        InputStream         OutputStream    (primitive)
 * 2     copy        Reader              Writer          (primitive)
 *
 * 3     copy        InputStream         Writer          2
 *
 * 4     copy        Reader              OutputStream    2
 *
 * 5     copy        String              OutputStream    2
 * 6     copy        String              Writer          (trivial)
 *
 * 7     copy        byte[]              Writer          3
 * 8     copy        byte[]              OutputStream    (trivial)
 * </pre>
 * <p>
 * Note that only the first two methods shuffle bytes; the rest use these
 * two, or (if possible) copy using native Java copy methods. As there are
 * method variants to specify the encoding, each row may
 * correspond to up to 2 methods.
 * <p>
 * Origin of code: Excalibur.
 *
 * @version $Id: CopyUtils.java 1302056 2012-03-18 03:03:38Z ggregory $
 * @deprecated Use IOUtils. Will be removed in 2.0.
 *  Methods renamed to IOUtils.write() or IOUtils.copy().
 *  Null handling behaviour changed in IOUtils (null data does not
 *  throw NullPointerException).
 */
@Deprecated
public class CopyUtils {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.228 -0400", hash_original_field = "962445CF6D8CBFC319D6FBB13DAEB0E4", hash_generated_field = "AD1955EA27A1323BB99B1EE414E7EB17")

    private static final int DEFAULT_BUFFER_SIZE = 1024 * 4;

    // ----------------------------------------------------------------
    // byte[] -> OutputStream
    // ----------------------------------------------------------------

    /**
     * Copy bytes from a <code>byte[]</code> to an <code>OutputStream</code>.
     * @param input the byte array to read from
     * @param output the <code>OutputStream</code> to write to
     * @throws IOException In case of an I/O problem
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.229 -0400", hash_original_method = "F0BA6BD7A97A3BE1D734FEB4A734FBAE", hash_generated_method = "21C0C1C9E5DDB851177A346608BA8979")
    
public static void copy(byte[] input, OutputStream output)
            throws IOException {
        output.write(input);
    }

    // ----------------------------------------------------------------
    // byte[] -> Writer
    // ----------------------------------------------------------------

    /**
     * Copy and convert bytes from a <code>byte[]</code> to chars on a
     * <code>Writer</code>.
     * The platform's default encoding is used for the byte-to-char conversion.
     * @param input the byte array to read from
     * @param output the <code>Writer</code> to write to
     * @throws IOException In case of an I/O problem
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.229 -0400", hash_original_method = "23536108F435071EFDBDD1BB2093DF63", hash_generated_method = "9288C44D791B96442C881C2550D06EB5")
    
public static void copy(byte[] input, Writer output)
            throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream(input);
        copy(in, output);
    }

    /**
     * Copy and convert bytes from a <code>byte[]</code> to chars on a
     * <code>Writer</code>, using the specified encoding.
     * @param input the byte array to read from
     * @param output the <code>Writer</code> to write to
     * @param encoding The name of a supported character encoding. See the
     * <a href="http://www.iana.org/assignments/character-sets">IANA
     * Charset Registry</a> for a list of valid encoding types.
     * @throws IOException In case of an I/O problem
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.230 -0400", hash_original_method = "975F2644D328BA1CCE74489B7E6C4E93", hash_generated_method = "6B57D2B7E6C1586A46189B258B115386")
    
public static void copy(
            byte[] input,
            Writer output,
            String encoding)
                throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream(input);
        copy(in, output, encoding);
    }

    // ----------------------------------------------------------------
    // Core copy methods
    // ----------------------------------------------------------------

    /**
     * Copy bytes from an <code>InputStream</code> to an
     * <code>OutputStream</code>.
     * @param input the <code>InputStream</code> to read from
     * @param output the <code>OutputStream</code> to write to
     * @return the number of bytes copied
     * @throws IOException In case of an I/O problem
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.231 -0400", hash_original_method = "593EF196512A9E50D807AC65E1BB79E6", hash_generated_method = "FE8F1334BAB370E78F5B50C9D6F496ED")
    
public static int copy(
            InputStream input,
            OutputStream output)
                throws IOException {
        byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
        int count = 0;
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            count += n;
        }
        return count;
    }

    // ----------------------------------------------------------------
    // Reader -> Writer
    // ----------------------------------------------------------------

    /**
     * Copy chars from a <code>Reader</code> to a <code>Writer</code>.
     * @param input the <code>Reader</code> to read from
     * @param output the <code>Writer</code> to write to
     * @return the number of characters copied
     * @throws IOException In case of an I/O problem
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.231 -0400", hash_original_method = "6960AEC98B2B3DE56B5CF65D073FAA4F", hash_generated_method = "22D7F578167645A1CA74B71D4DCC15DA")
    
public static int copy(
            Reader input,
            Writer output)
                throws IOException {
        char[] buffer = new char[DEFAULT_BUFFER_SIZE];
        int count = 0;
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            count += n;
        }
        return count;
    }

    // ----------------------------------------------------------------
    // InputStream -> Writer
    // ----------------------------------------------------------------

    /**
     * Copy and convert bytes from an <code>InputStream</code> to chars on a
     * <code>Writer</code>.
     * The platform's default encoding is used for the byte-to-char conversion.
     * @param input the <code>InputStream</code> to read from
     * @param output the <code>Writer</code> to write to
     * @throws IOException In case of an I/O problem
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.232 -0400", hash_original_method = "0B73E6030E0DCCE4A59142FE847725E7", hash_generated_method = "997E22269BD848FB3E4B34F9D6C89E9C")
    
public static void copy(
            InputStream input,
            Writer output)
                throws IOException {
        InputStreamReader in = new InputStreamReader(input);
        copy(in, output);
    }

    /**
     * Copy and convert bytes from an <code>InputStream</code> to chars on a
     * <code>Writer</code>, using the specified encoding.
     * @param input the <code>InputStream</code> to read from
     * @param output the <code>Writer</code> to write to
     * @param encoding The name of a supported character encoding. See the
     * <a href="http://www.iana.org/assignments/character-sets">IANA
     * Charset Registry</a> for a list of valid encoding types.
     * @throws IOException In case of an I/O problem
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.233 -0400", hash_original_method = "BAF4B95A6524226CE08A8B2424D408F3", hash_generated_method = "BA3619B7F6642E30999D150F7DFA521C")
    
public static void copy(
            InputStream input,
            Writer output,
            String encoding)
                throws IOException {
        InputStreamReader in = new InputStreamReader(input, encoding);
        copy(in, output);
    }

    // ----------------------------------------------------------------
    // Reader -> OutputStream
    // ----------------------------------------------------------------

    /**
     * Serialize chars from a <code>Reader</code> to bytes on an
     * <code>OutputStream</code>, and flush the <code>OutputStream</code>.
     * @param input the <code>Reader</code> to read from
     * @param output the <code>OutputStream</code> to write to
     * @throws IOException In case of an I/O problem
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.233 -0400", hash_original_method = "4A30515545AEE268D8CDF2F6145346D7", hash_generated_method = "D825AA06680C4B1ED6AE74514326B1BE")
    
public static void copy(
            Reader input,
            OutputStream output)
                throws IOException {
        OutputStreamWriter out = new OutputStreamWriter(output);
        copy(input, out);
        // XXX Unless anyone is planning on rewriting OutputStreamWriter, we
        // have to flush here.
        out.flush();
    }

    // ----------------------------------------------------------------
    // String -> OutputStream
    // ----------------------------------------------------------------

    /**
     * Serialize chars from a <code>String</code> to bytes on an
     * <code>OutputStream</code>, and
     * flush the <code>OutputStream</code>.
     * @param input the <code>String</code> to read from
     * @param output the <code>OutputStream</code> to write to
     * @throws IOException In case of an I/O problem
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.234 -0400", hash_original_method = "71BA56061CC566FAF4CE116FA431BE61", hash_generated_method = "D32F87BC18FB23A6AE09E9767CC4DFCD")
    
public static void copy(
            String input,
            OutputStream output)
                throws IOException {
        StringReader in = new StringReader(input);
        OutputStreamWriter out = new OutputStreamWriter(output);
        copy(in, out);
        // XXX Unless anyone is planning on rewriting OutputStreamWriter, we
        // have to flush here.
        out.flush();
    }

    // ----------------------------------------------------------------
    // String -> Writer
    // ----------------------------------------------------------------

    /**
     * Copy chars from a <code>String</code> to a <code>Writer</code>.
     * @param input the <code>String</code> to read from
     * @param output the <code>Writer</code> to write to
     * @throws IOException In case of an I/O problem
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.235 -0400", hash_original_method = "968990997123B88042733533DFA918C0", hash_generated_method = "D3A24179BA1184DD41975C58D8D0D573")
    
public static void copy(String input, Writer output)
                throws IOException {
        output.write(input);
    }

    /**
     * Instances should NOT be constructed in standard programming.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.228 -0400", hash_original_method = "1212272BD01F83C868E797A5AC3981E4", hash_generated_method = "B7ED7482547FB4C801E9956D267E111F")
    
public CopyUtils() { }

}
