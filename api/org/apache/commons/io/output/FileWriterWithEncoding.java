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
package org.apache.commons.io.output;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/**
 * Writer of files that allows the encoding to be set.
 * <p>
 * This class provides a simple alternative to <code>FileWriter</code>
 * that allows an encoding to be set. Unfortunately, it cannot subclass
 * <code>FileWriter</code>.
 * <p>
 * By default, the file will be overwritten, but this may be changed to append.
 * <p>
 * The encoding must be specified using either the name of the {@link Charset},
 * the {@link Charset}, or a {@link CharsetEncoder}. If the default encoding
 * is required then use the {@link java.io.FileWriter} directly, rather than
 * this implementation.
 * <p>
 * 
 *
 * @since 1.4
 * @version $Id: FileWriterWithEncoding.java 1304052 2012-03-22 20:55:29Z ggregory $
 */
public class FileWriterWithEncoding extends Writer {

    //-----------------------------------------------------------------------
    /**
     * Initialise the wrapped file writer.
     * Ensure that a cleanup occurs if the writer creation fails.
     *
     * @param file  the file to be accessed
     * @param encoding  the encoding to use - may be Charset, CharsetEncoder or String
     * @param append  true to append
     * @return the initialised writer
     * @throws NullPointerException if the file or encoding is null
     * @throws IOException if an error occurs
     */
     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.728 -0400", hash_original_method = "058065C74CFCB0AFFAB499776A561505", hash_generated_method = "F3F11C285D3F2B6795073B4C62CE9A1E")
    
private static Writer initWriter(File file, Object encoding, boolean append) throws IOException {
        if (file == null) {
            throw new NullPointerException("File is missing");
        }
        if (encoding == null) {
            throw new NullPointerException("Encoding is missing");
        }
        boolean fileExistedAlready = file.exists();
        OutputStream stream = null;
        Writer writer = null;
        try {
            stream = new FileOutputStream(file, append);
            if (encoding instanceof Charset) {
                writer = new OutputStreamWriter(stream, (Charset)encoding);
            } else if (encoding instanceof CharsetEncoder) {
                writer = new OutputStreamWriter(stream, (CharsetEncoder)encoding);
            } else {
                writer = new OutputStreamWriter(stream, (String)encoding);
            }
        } catch (IOException ex) {
            IOUtils.closeQuietly(writer);
            IOUtils.closeQuietly(stream);
            if (fileExistedAlready == false) {
                FileUtils.deleteQuietly(file);
            }
            throw ex;
        } catch (RuntimeException ex) {
            IOUtils.closeQuietly(writer);
            IOUtils.closeQuietly(stream);
            if (fileExistedAlready == false) {
                FileUtils.deleteQuietly(file);
            }
            throw ex;
        }
        return writer;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.720 -0400", hash_original_field = "EBCE22DD0E30FF0E4040ABB2E7F29C97", hash_generated_field = "F12AA94BCB31ABB5AA988A18E8F8047D")

    // known when super() is called

    /** The writer to decorate. */
    private  Writer out;

    /**
     * Constructs a FileWriterWithEncoding with a file encoding.
     *
     * @param filename  the name of the file to write to, not null
     * @param encoding  the encoding to use, not null
     * @throws NullPointerException if the file name or encoding is null
     * @throws IOException in case of an I/O error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.721 -0400", hash_original_method = "A52AC32E391B7F84AF3674F051432B93", hash_generated_method = "852A0A5625B2CC7105AC40FA77658177")
    
public FileWriterWithEncoding(String filename, String encoding) throws IOException {
        this(new File(filename), encoding, false);
    }

    /**
     * Constructs a FileWriterWithEncoding with a file encoding.
     *
     * @param filename  the name of the file to write to, not null
     * @param encoding  the encoding to use, not null
     * @param append  true if content should be appended, false to overwrite
     * @throws NullPointerException if the file name or encoding is null
     * @throws IOException in case of an I/O error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.722 -0400", hash_original_method = "9268E855F2CAF6B32CC0A84C097AA89C", hash_generated_method = "E7E2D7319E6E880137A7CB4A7F146950")
    
public FileWriterWithEncoding(String filename, String encoding, boolean append) throws IOException {
        this(new File(filename), encoding, append);
    }

    /**
     * Constructs a FileWriterWithEncoding with a file encoding.
     *
     * @param filename  the name of the file to write to, not null
     * @param encoding  the encoding to use, not null
     * @throws NullPointerException if the file name or encoding is null
     * @throws IOException in case of an I/O error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.722 -0400", hash_original_method = "5B48C8683005DB158481C5D53B140180", hash_generated_method = "A6BB146E775EED9D0866F255320E5D83")
    
public FileWriterWithEncoding(String filename, Charset encoding) throws IOException {
        this(new File(filename), encoding, false);
    }

    /**
     * Constructs a FileWriterWithEncoding with a file encoding.
     *
     * @param filename  the name of the file to write to, not null
     * @param encoding  the encoding to use, not null
     * @param append  true if content should be appended, false to overwrite
     * @throws NullPointerException if the file name or encoding is null
     * @throws IOException in case of an I/O error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.723 -0400", hash_original_method = "F4D6C9041E127D6A9D181ECD595CA773", hash_generated_method = "C796E62DC57C7B34B015D2EA37F34B96")
    
public FileWriterWithEncoding(String filename, Charset encoding, boolean append) throws IOException {
        this(new File(filename), encoding, append);
    }

    /**
     * Constructs a FileWriterWithEncoding with a file encoding.
     *
     * @param filename  the name of the file to write to, not null
     * @param encoding  the encoding to use, not null
     * @throws NullPointerException if the file name or encoding is null
     * @throws IOException in case of an I/O error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.723 -0400", hash_original_method = "BE1D40ED821F3E25537E5C6AFC567836", hash_generated_method = "4E1F618E74EC0ED8B817AEFE37FF45E5")
    
public FileWriterWithEncoding(String filename, CharsetEncoder encoding) throws IOException {
        this(new File(filename), encoding, false);
    }

    /**
     * Constructs a FileWriterWithEncoding with a file encoding.
     *
     * @param filename  the name of the file to write to, not null
     * @param encoding  the encoding to use, not null
     * @param append  true if content should be appended, false to overwrite
     * @throws NullPointerException if the file name or encoding is null
     * @throws IOException in case of an I/O error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.724 -0400", hash_original_method = "A695A8BF148290BDBA8C8C60EA64EB2D", hash_generated_method = "D7ACD15EBD2094B01026B6C8D316484C")
    
public FileWriterWithEncoding(String filename, CharsetEncoder encoding, boolean append) throws IOException {
        this(new File(filename), encoding, append);
    }

    /**
     * Constructs a FileWriterWithEncoding with a file encoding.
     *
     * @param file  the file to write to, not null
     * @param encoding  the encoding to use, not null
     * @throws NullPointerException if the file or encoding is null
     * @throws IOException in case of an I/O error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.724 -0400", hash_original_method = "2E483D5B654BC30D2C26E569C2C13C4B", hash_generated_method = "5F1D76CFBAF199BD5A21BCDD569EC76B")
    
public FileWriterWithEncoding(File file, String encoding) throws IOException {
        this(file, encoding, false);
    }

    /**
     * Constructs a FileWriterWithEncoding with a file encoding.
     *
     * @param file  the file to write to, not null
     * @param encoding  the encoding to use, not null
     * @param append  true if content should be appended, false to overwrite
     * @throws NullPointerException if the file or encoding is null
     * @throws IOException in case of an I/O error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.725 -0400", hash_original_method = "8CE491D4D9BE51D07DB14BE0E12E38B2", hash_generated_method = "0813E9C241A583114A6037CEB70A7419")
    
public FileWriterWithEncoding(File file, String encoding, boolean append) throws IOException {
        super();
        this.out = initWriter(file, encoding, append);
    }

    /**
     * Constructs a FileWriterWithEncoding with a file encoding.
     *
     * @param file  the file to write to, not null
     * @param encoding  the encoding to use, not null
     * @throws NullPointerException if the file or encoding is null
     * @throws IOException in case of an I/O error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.725 -0400", hash_original_method = "73F04B968EDAB2AA927750D7924907E5", hash_generated_method = "5DF1A6A078C5A68D443B50DC7D3BF1A1")
    
public FileWriterWithEncoding(File file, Charset encoding) throws IOException {
        this(file, encoding, false);
    }

    /**
     * Constructs a FileWriterWithEncoding with a file encoding.
     *
     * @param file  the file to write to, not null
     * @param encoding  the encoding to use, not null
     * @param append  true if content should be appended, false to overwrite
     * @throws NullPointerException if the file or encoding is null
     * @throws IOException in case of an I/O error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.726 -0400", hash_original_method = "3A1E34D05E51ADA7E2716E6B82EE32B2", hash_generated_method = "279608E87D608D9F7F5726FAA1CD3212")
    
public FileWriterWithEncoding(File file, Charset encoding, boolean append) throws IOException {
        super();
        this.out = initWriter(file, encoding, append);
    }

    /**
     * Constructs a FileWriterWithEncoding with a file encoding.
     *
     * @param file  the file to write to, not null
     * @param encoding  the encoding to use, not null
     * @throws NullPointerException if the file or encoding is null
     * @throws IOException in case of an I/O error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.726 -0400", hash_original_method = "3AF4BFBC54E30FB310A497284D9191E7", hash_generated_method = "A83592AC7DE5DDE9BC2B3211EA492B7C")
    
public FileWriterWithEncoding(File file, CharsetEncoder encoding) throws IOException {
        this(file, encoding, false);
    }

    /**
     * Constructs a FileWriterWithEncoding with a file encoding.
     *
     * @param file  the file to write to, not null
     * @param encoding  the encoding to use, not null
     * @param append  true if content should be appended, false to overwrite
     * @throws NullPointerException if the file or encoding is null
     * @throws IOException in case of an I/O error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.727 -0400", hash_original_method = "DB01DDECD36D428EBB5A472FDA637AEC", hash_generated_method = "6454E4B6084231370733C23A10E39444")
    
public FileWriterWithEncoding(File file, CharsetEncoder encoding, boolean append) throws IOException {
        super();
        this.out = initWriter(file, encoding, append);
    }

    //-----------------------------------------------------------------------
    /**
     * Write a character.
     * @param idx the character to write
     * @throws IOException if an I/O error occurs
     */
     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.728 -0400", hash_original_method = "EE30809419C042C9133DA321A16F7DFD", hash_generated_method = "108A0CC68AF0F1C128B1F7C2EFE7950F")
    
@Override
    public void write(int idx) throws IOException {
        out.write(idx);
    }

    /**
     * Write the characters from an array.
     * @param chr the characters to write
     * @throws IOException if an I/O error occurs
     */
     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.729 -0400", hash_original_method = "46EC5EF747261262EAD8ED1BD4879967", hash_generated_method = "2CB0A7EEA30A4F8FDF3B216777E92993")
    
@Override
    public void write(char[] chr) throws IOException {
        out.write(chr);
    }

    /**
     * Write the specified characters from an array.
     * @param chr the characters to write
     * @param st The start offset
     * @param end The number of characters to write
     * @throws IOException if an I/O error occurs
     */
     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.729 -0400", hash_original_method = "4007BD37B56F652F2DD863D7816336D0", hash_generated_method = "2024B0D60D55840B17528B87EB493ED5")
    
@Override
    public void write(char[] chr, int st, int end) throws IOException {
        out.write(chr, st, end);
    }

    /**
     * Write the characters from a string.
     * @param str the string to write
     * @throws IOException if an I/O error occurs
     */
     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.730 -0400", hash_original_method = "570C1378326063600110CB3D156C7691", hash_generated_method = "11531F2C7D6991750845B0705120981E")
    
@Override
    public void write(String str) throws IOException {
        out.write(str);
    }

    /**
     * Write the specified characters from a string.
     * @param str the string to write
     * @param st The start offset
     * @param end The number of characters to write
     * @throws IOException if an I/O error occurs
     */
     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.730 -0400", hash_original_method = "694B238FF5AB1AB4441171CB6DC98A7A", hash_generated_method = "BD1C54C575DC051B66557980241D013D")
    
@Override
    public void write(String str, int st, int end) throws IOException {
        out.write(str, st, end);
    }

    /**
     * Flush the stream.
     * @throws IOException if an I/O error occurs
     */
     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.731 -0400", hash_original_method = "C99FBA65B0D308569620507D6E099042", hash_generated_method = "5CE80A6225762CA51E516040755CB8E9")
    
@Override
    public void flush() throws IOException {
        out.flush();
    }

    /**
     * Close the stream.
     * @throws IOException if an I/O error occurs
     */
     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.731 -0400", hash_original_method = "607673C7F0C479BD29B5457E75015964", hash_generated_method = "46BBFE1C9011ABBEAFC2BEDE735CE8AA")
    
@Override
    public void close() throws IOException {
        out.close();
    }
}
