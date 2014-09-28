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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.input.XmlStreamReader;

/**
 * Character stream that handles all the necessary Voodo to figure out the
 * charset encoding of the XML document written to the stream.
 *
 * @version $Id: XmlStreamWriter.java 1304052 2012-03-22 20:55:29Z ggregory $
 * @see XmlStreamReader
 * @since 2.0
 */
public class XmlStreamWriter extends Writer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.910 -0400", hash_original_field = "EC47A1FE0AFB91C4F12D021F998D9DF1", hash_generated_field = "2D6932277766CC46C6A5DD6909FDCC5E")

    private static final int BUFFER_SIZE = 4096;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.920 -0400", hash_original_field = "80F5A9B26E7EF9888CA395F4BDA59FE5", hash_generated_field = "478C9F2A44B2C1DA6B3E4CE1EE47FEAB")

    static final Pattern ENCODING_PATTERN = XmlStreamReader.ENCODING_PATTERN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.911 -0400", hash_original_field = "045D3F20D319391451B40CE63253C516", hash_generated_field = "FAC7CE5410064D378AF9E7B2309C5BE9")

    private  OutputStream out;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.911 -0400", hash_original_field = "17CBCAF681BCBD1F3719DE3FA392874D", hash_generated_field = "7380F104304B5118624DAE9AD6B460C4")

    private  String defaultEncoding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.911 -0400", hash_original_field = "1D4494F6BB155270CD9061EE9E31C50B", hash_generated_field = "3B0F841FF7E21C2FBFE8FB4592CC4284")

    private StringWriter xmlPrologWriter = new StringWriter(BUFFER_SIZE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.912 -0400", hash_original_field = "2893095D821727F8868345026D6906A1", hash_generated_field = "DB075F4140D7FA00980C54A40F997F59")

    private Writer writer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.912 -0400", hash_original_field = "C7941A2E59CC2DF1A97D47295C728725", hash_generated_field = "AA03A19AA54A465901EEA798BB232EAE")

    private String encoding;

    /**
     * Construct an new XML stream writer for the specified output stream
     * with a default encoding of UTF-8.
     *
     * @param out The output stream
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.913 -0400", hash_original_method = "1F07F2996D4303D16171195260C51826", hash_generated_method = "3323F907E6CEC5C0205A9AAF6E5F9261")
    
public XmlStreamWriter(OutputStream out) {
        this(out, null);
    }

    /**
     * Construct an new XML stream writer for the specified output stream
     * with the specified default encoding.
     *
     * @param out The output stream
     * @param defaultEncoding The default encoding if not encoding could be detected
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.914 -0400", hash_original_method = "0133DB5409861AC1C5AE03D509257B31", hash_generated_method = "29366EECD33865A5ACAF47EFA1A55D33")
    
public XmlStreamWriter(OutputStream out, String defaultEncoding) {
        this.out = out;
        this.defaultEncoding = defaultEncoding != null ? defaultEncoding : "UTF-8";
    }

    /**
     * Construct an new XML stream writer for the specified file
     * with a default encoding of UTF-8.
     * 
     * @param file The file to write to
     * @throws FileNotFoundException if there is an error creating or
     * opening the file
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.915 -0400", hash_original_method = "50002FAC0CC159EBEC26C7D3BEE7C633", hash_generated_method = "1B7200FDFBA1CFC37E61FAB2E13DF1EF")
    
public XmlStreamWriter(File file) throws FileNotFoundException {
        this(file, null);
    }

    /**
     * Construct an new XML stream writer for the specified file
     * with the specified default encoding.
     * 
     * @param file The file to write to
     * @param defaultEncoding The default encoding if not encoding could be detected
     * @throws FileNotFoundException if there is an error creating or
     * opening the file
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.915 -0400", hash_original_method = "AA99CD590672754F26A4EEAA3056CABB", hash_generated_method = "A8E8F097898534372BDC255832D74B58")
    
public XmlStreamWriter(File file, String defaultEncoding) throws FileNotFoundException {
        this(new FileOutputStream(file), defaultEncoding);
    }

    /**
     * Return the detected encoding.
     *
     * @return the detected encoding
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.916 -0400", hash_original_method = "ECC6E581C26F132636CDCE9C9A5E5807", hash_generated_method = "AB48E45DF4593246DCA3A0BE40153818")
    
public String getEncoding() {
        return encoding;
    }

    /**
     * Return the default encoding.
     *
     * @return the default encoding
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.916 -0400", hash_original_method = "F443D1F05E85BC7B1454291BD7671BD0", hash_generated_method = "6799ACA480A1E1B4C5AF5DB520288446")
    
public String getDefaultEncoding() {
        return defaultEncoding;
    }

    /**
     * Close the underlying writer.
     *
     * @throws IOException if an error occurs closing the underlying writer
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.917 -0400", hash_original_method = "FA1D85D28CEAB4A4964615D0CD6BE099", hash_generated_method = "9A62DA35FF42BC4BB25038177C97FF8C")
    
@Override
    public void close() throws IOException {
        if (writer == null) {
            encoding = defaultEncoding;
            writer = new OutputStreamWriter(out, encoding);
            writer.write(xmlPrologWriter.toString());
        }
        writer.close();
    }

    /**
     * Flush the underlying writer.
     *
     * @throws IOException if an error occurs flushing the underlying writer
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.917 -0400", hash_original_method = "1CF6DC5DA7BB65AAE6632CB394BB4ED7", hash_generated_method = "AAB7FB16372FD91C75BD3F54F1BFA948")
    
@Override
    public void flush() throws IOException {
        if (writer != null) {
            writer.flush();
        }
    }

    /**
     * Detect the encoding.
     *
     * @param cbuf the buffer to write the characters from
     * @param off The start offset
     * @param len The number of characters to write
     * @throws IOException if an error occurs detecting the encoding
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.918 -0400", hash_original_method = "5F0F76B2AEC559A82852132C77730119", hash_generated_method = "761CCC5FECDDA74F16E4367258F3BE74")
    
private void detectEncoding(char[] cbuf, int off, int len)
            throws IOException {
        int size = len;
        StringBuffer xmlProlog = xmlPrologWriter.getBuffer();
        if (xmlProlog.length() + len > BUFFER_SIZE) {
            size = BUFFER_SIZE - xmlProlog.length();
        }
        xmlPrologWriter.write(cbuf, off, size);

        // try to determine encoding
        if (xmlProlog.length() >= 5) {
            if (xmlProlog.substring(0, 5).equals("<?xml")) {
                // try to extract encoding from XML prolog
                int xmlPrologEnd = xmlProlog.indexOf("?>");
                if (xmlPrologEnd > 0) {
                    // ok, full XML prolog written: let's extract encoding
                    Matcher m = ENCODING_PATTERN.matcher(xmlProlog.substring(0,
                            xmlPrologEnd));
                    if (m.find()) {
                        encoding = m.group(1).toUpperCase();
                        encoding = encoding.substring(1, encoding.length() - 1);
                    } else {
                        // no encoding found in XML prolog: using default
                        // encoding
                        encoding = defaultEncoding;
                    }
                } else {
                    if (xmlProlog.length() >= BUFFER_SIZE) {
                        // no encoding found in first characters: using default
                        // encoding
                        encoding = defaultEncoding;
                    }
                }
            } else {
                // no XML prolog: using default encoding
                encoding = defaultEncoding;
            }
            if (encoding != null) {
                // encoding has been chosen: let's do it
                xmlPrologWriter = null;
                writer = new OutputStreamWriter(out, encoding);
                writer.write(xmlProlog.toString());
                if (len > size) {
                    writer.write(cbuf, off + size, len - size);
                }
            }
        }
    }

    /**
     * Write the characters to the underlying writer, detecing encoding.
     * 
     * @param cbuf the buffer to write the characters from
     * @param off The start offset
     * @param len The number of characters to write
     * @throws IOException if an error occurs detecting the encoding
     */
    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.919 -0400", hash_original_method = "C7BCA488F553457389C8980637630468", hash_generated_method = "BD9165060D8477FEE4401F2563C4F2FB")
    
@Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        if (xmlPrologWriter != null) {
            detectEncoding(cbuf, off, len);
        } else {
            writer.write(cbuf, off, len);
        }
    }
}
