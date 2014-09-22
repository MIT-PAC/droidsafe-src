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
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.ByteOrderMark;

/**
 * Character stream that handles all the necessary Voodo to figure out the
 * charset encoding of the XML document within the stream.
 * <p>
 * IMPORTANT: This class is not related in any way to the org.xml.sax.XMLReader.
 * This one IS a character stream.
 * <p>
 * All this has to be done without consuming characters from the stream, if not
 * the XML parser will not recognized the document as a valid XML. This is not
 * 100% true, but it's close enough (UTF-8 BOM is not handled by all parsers
 * right now, XmlStreamReader handles it and things work in all parsers).
 * <p>
 * The XmlStreamReader class handles the charset encoding of XML documents in
 * Files, raw streams and HTTP streams by offering a wide set of constructors.
 * <p>
 * By default the charset encoding detection is lenient, the constructor with
 * the lenient flag can be used for an script (following HTTP MIME and XML
 * specifications). All this is nicely explained by Mark Pilgrim in his blog, <a
 * href="http://diveintomark.org/archives/2004/02/13/xml-media-types">
 * Determining the character encoding of a feed</a>.
 * <p>
 * Originally developed for <a href="http://rome.dev.java.net">ROME</a> under
 * Apache License 2.0.
 *
 * @version $Id: XmlStreamReader.java 1346400 2012-06-05 14:48:01Z ggregory $
 * @see org.apache.commons.io.output.XmlStreamWriter
 * @since 2.0
 */
public class XmlStreamReader extends Reader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.167 -0400", hash_original_field = "EC47A1FE0AFB91C4F12D021F998D9DF1", hash_generated_field = "2D6932277766CC46C6A5DD6909FDCC5E")

    private static final int BUFFER_SIZE = 4096;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.167 -0400", hash_original_field = "4C869B13BEF7E7EB87393F929DAAEF08", hash_generated_field = "C8915AECAD93B0288C9E401509C4DC97")


    private static final String UTF_8 = "UTF-8";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.168 -0400", hash_original_field = "4BA4D73EFE3E4386F492E6E345E19D10", hash_generated_field = "A01FFAD120BAFBCC19A6B7C5143F201D")


    private static final String US_ASCII = "US-ASCII";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.168 -0400", hash_original_field = "7A664CEB53B0C4FA8E002B6DB4DF105A", hash_generated_field = "E701533E6B02B7C236C9FAEDE9A2150C")


    private static final String UTF_16BE = "UTF-16BE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.169 -0400", hash_original_field = "6CC197384106D30E9A24D6D1F6B0E309", hash_generated_field = "4205932278CFED46C32ECDD6D3406976")


    private static final String UTF_16LE = "UTF-16LE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.169 -0400", hash_original_field = "8D9C34BEC241E30E165D0B9284EC951D", hash_generated_field = "8A030FA5B47049C6296A6C0C9C516C34")


    private static final String UTF_32BE = "UTF-32BE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.170 -0400", hash_original_field = "FC279F73E929C6F3F95928AA765C89F9", hash_generated_field = "49D8B86B8D54FAE3DA944F6508FA19B2")


    private static final String UTF_32LE = "UTF-32LE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.171 -0400", hash_original_field = "F937D08544423510C929202A06C5E40C", hash_generated_field = "7051634EA32B327445B8E2BB4F066F7D")


    private static final String UTF_16 = "UTF-16";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.171 -0400", hash_original_field = "98CE4CE367125AB8DAED843B93080AD5", hash_generated_field = "5437F39279BDC878DC8ACAFCAF96A46F")


    private static final String UTF_32 = "UTF-32";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.172 -0400", hash_original_field = "9909E9E688E85F867883A2D972DE4A73", hash_generated_field = "5516F8607A7F101B59189B0A59ABC227")


    private static final String EBCDIC = "CP1047";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.172 -0400", hash_original_field = "33129A8E03FB201698A3DA7B2B1B7220", hash_generated_field = "FE04BF8F1F477166F38E2C68EF521413")


    private static final ByteOrderMark[] BOMS = new ByteOrderMark[] {
        ByteOrderMark.UTF_8,
        ByteOrderMark.UTF_16BE,
        ByteOrderMark.UTF_16LE,
        ByteOrderMark.UTF_32BE,
        ByteOrderMark.UTF_32LE
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.173 -0400", hash_original_field = "A07113A79055CD877A589C1D7501FE39", hash_generated_field = "6303B29D1D3BBF1CC690B3723D4AC1A5")

    private static final ByteOrderMark[] XML_GUESS_BYTES = new ByteOrderMark[] {
        new ByteOrderMark(UTF_8,    0x3C, 0x3F, 0x78, 0x6D),
        new ByteOrderMark(UTF_16BE, 0x00, 0x3C, 0x00, 0x3F),
        new ByteOrderMark(UTF_16LE, 0x3C, 0x00, 0x3F, 0x00),
        new ByteOrderMark(UTF_32BE, 0x00, 0x00, 0x00, 0x3C, 
                0x00, 0x00, 0x00, 0x3F, 0x00, 0x00, 0x00, 0x78, 0x00, 0x00, 0x00, 0x6D),
        new ByteOrderMark(UTF_32LE, 0x3C, 0x00, 0x00, 0x00, 
                0x3F, 0x00, 0x00, 0x00, 0x78, 0x00, 0x00, 0x00, 0x6D, 0x00, 0x00, 0x00),
        new ByteOrderMark(EBCDIC,   0x4C, 0x6F, 0xA7, 0x94)
    };

    /**
     * Returns MIME type or NULL if httpContentType is NULL.
     *
     * @param httpContentType the HTTP content type
     * @return The mime content type
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.190 -0400", hash_original_method = "FCFDB24E9875B2E0BCA7546B4A10A817", hash_generated_method = "13C7D930946957B0508B6B855A709960")
    
static String getContentTypeMime(String httpContentType) {
        String mime = null;
        if (httpContentType != null) {
            int i = httpContentType.indexOf(";");
            if (i >= 0) {
                mime = httpContentType.substring(0, i);
            } else {
                mime = httpContentType;
            }
            mime = mime.trim();
        }
        return mime;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.190 -0400", hash_original_field = "309C8FB8D383C708C974CA908CA2DE4B", hash_generated_field = "0705AF6236794B3774BD3D3DF175B9BB")


    private static final Pattern CHARSET_PATTERN = Pattern
            .compile("charset=[\"']?([.[^; \"']]*)[\"']?");

    /**
     * Returns charset parameter value, NULL if not present, NULL if
     * httpContentType is NULL.
     *
     * @param httpContentType the HTTP content type
     * @return The content type encoding (upcased)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.191 -0400", hash_original_method = "A79F497669D1A1ECD65A8F0904EE0023", hash_generated_method = "37994C94818231AC5D30FA12FD3C804B")
    
static String getContentTypeEncoding(String httpContentType) {
        String encoding = null;
        if (httpContentType != null) {
            int i = httpContentType.indexOf(";");
            if (i > -1) {
                String postMime = httpContentType.substring(i + 1);
                Matcher m = CHARSET_PATTERN.matcher(postMime);
                encoding = m.find() ? m.group(1) : null;
                encoding = encoding != null ? encoding.toUpperCase(Locale.US) : null;
            }
        }
        return encoding;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.192 -0400", hash_original_field = "C6683D5AF370E9F5C011C76B145EAD8F", hash_generated_field = "DEFAFF066C62F1F078270AB77D86A366")


    public static final Pattern ENCODING_PATTERN = Pattern.compile(
            "<\\?xml.*encoding[\\s]*=[\\s]*((?:\".[^\"]*\")|(?:'.[^']*'))",
            Pattern.MULTILINE);

    /**
     * Returns the encoding declared in the <?xml encoding=...?>, NULL if none.
     *
     * @param is InputStream to create the reader from.
     * @param guessedEnc guessed encoding
     * @return the encoding declared in the <?xml encoding=...?>
     * @throws IOException thrown if there is a problem reading the stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.193 -0400", hash_original_method = "162732F0A7E49671436861D5CE08ADF6", hash_generated_method = "4945F71186FE25E05438F92FF29D4797")
    
private static String getXmlProlog(InputStream is, String guessedEnc)
            throws IOException {
        String encoding = null;
        if (guessedEnc != null) {
            byte[] bytes = new byte[BUFFER_SIZE];
            is.mark(BUFFER_SIZE);
            int offset = 0;
            int max = BUFFER_SIZE;
            int c = is.read(bytes, offset, max);
            int firstGT = -1;
            String xmlProlog = null;
            while (c != -1 && firstGT == -1 && offset < BUFFER_SIZE) {
                offset += c;
                max -= c;
                c = is.read(bytes, offset, max);
                xmlProlog = new String(bytes, 0, offset, guessedEnc);
                firstGT = xmlProlog.indexOf('>');
            }
            if (firstGT == -1) {
                if (c == -1) {
                    throw new IOException("Unexpected end of XML stream");
                } else {
                    throw new IOException(
                            "XML prolog or ROOT element not found on first "
                                    + offset + " bytes");
                }
            }
            int bytesRead = offset;
            if (bytesRead > 0) {
                is.reset();
                BufferedReader bReader = new BufferedReader(new StringReader(
                        xmlProlog.substring(0, firstGT + 1)));
                StringBuffer prolog = new StringBuffer();
                String line = bReader.readLine();
                while (line != null) {
                    prolog.append(line);
                    line = bReader.readLine();
                }
                Matcher m = ENCODING_PATTERN.matcher(prolog);
                if (m.find()) {
                    encoding = m.group(1).toUpperCase();
                    encoding = encoding.substring(1, encoding.length() - 1);
                }
            }
        }
        return encoding;
    }

    /**
     * Indicates if the MIME type belongs to the APPLICATION XML family.
     * 
     * @param mime The mime type
     * @return true if the mime type belongs to the APPLICATION XML family,
     * otherwise false
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.194 -0400", hash_original_method = "5460C1BF4694AF8E70CA165118B96A98", hash_generated_method = "70B24E9524D2610955AE19CBC0B320C2")
    
static boolean isAppXml(String mime) {
        return mime != null &&
               (mime.equals("application/xml") || 
                mime.equals("application/xml-dtd") ||
                mime.equals("application/xml-external-parsed-entity") ||
               mime.startsWith("application/") && mime.endsWith("+xml"));
    }

    /**
     * Indicates if the MIME type belongs to the TEXT XML family.
     * 
     * @param mime The mime type
     * @return true if the mime type belongs to the TEXT XML family,
     * otherwise false
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.194 -0400", hash_original_method = "C0219AF1D095DA295F318D03FEFBBE5C", hash_generated_method = "392D25654FB092B347D6206C9962370A")
    
static boolean isTextXml(String mime) {
        return mime != null &&
              (mime.equals("text/xml") ||
               mime.equals("text/xml-external-parsed-entity") ||
              mime.startsWith("text/") && mime.endsWith("+xml"));
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.195 -0400", hash_original_field = "131C79AAA0681F08D2A5306EA98B3A72", hash_generated_field = "35EBF43677D1D8478ABBAFCB40A12E69")


    private static final String RAW_EX_1 =
        "Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.195 -0400", hash_original_field = "C9F79A058283196078767C417421379C", hash_generated_field = "24C2E2082AE939075F2AE9E126F5324F")


    private static final String RAW_EX_2 =
        "Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] unknown BOM";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.196 -0400", hash_original_field = "820BF62D6E742DEB82E6563C94FCD36B", hash_generated_field = "6E61DB8F27F7F53C3DDE60B2F26D297C")


    private static final String HTTP_EX_1 =
        "Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], BOM must be NULL";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.196 -0400", hash_original_field = "57FB5799CEA248CB2CB1FBD23F14E5B3", hash_generated_field = "AA7C5E28C91FEB5082829DEA29E4E014")


    private static final String HTTP_EX_2 =
        "Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], encoding mismatch";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.198 -0400", hash_original_field = "2026AA539337DD74E319FD0814E7144B", hash_generated_field = "61A10800F6134B0D772DFD5EAE17C60E")


    private static final String HTTP_EX_3 =
        "Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], Invalid MIME";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.174 -0400", hash_original_field = "359C2477A0D4C46A46237360E9D6E3E1", hash_generated_field = "506A19594AC0AF91386404965612888E")


    private  Reader reader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.174 -0400", hash_original_field = "C7941A2E59CC2DF1A97D47295C728725", hash_generated_field = "AA03A19AA54A465901EEA798BB232EAE")


    private  String encoding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.175 -0400", hash_original_field = "17CBCAF681BCBD1F3719DE3FA392874D", hash_generated_field = "7380F104304B5118624DAE9AD6B460C4")


    private  String defaultEncoding;

    /**
     * Creates a Reader for a File.
     * <p>
     * It looks for the UTF-8 BOM first, if none sniffs the XML prolog charset,
     * if this is also missing defaults to UTF-8.
     * <p>
     * It does a lenient charset encoding detection, check the constructor with
     * the lenient parameter for details.
     *
     * @param file File to create a Reader from.
     * @throws IOException thrown if there is a problem reading the file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.176 -0400", hash_original_method = "0BFB3D2359EDBDC19A64BE4776F868C5", hash_generated_method = "B59FB592612D15833ABEB33456434AFE")
    
public XmlStreamReader(File file) throws IOException {
        this(new FileInputStream(file));
    }

    /**
     * Creates a Reader for a raw InputStream.
     * <p>
     * It follows the same logic used for files.
     * <p>
     * It does a lenient charset encoding detection, check the constructor with
     * the lenient parameter for details.
     *
     * @param is InputStream to create a Reader from.
     * @throws IOException thrown if there is a problem reading the stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.176 -0400", hash_original_method = "CCF5242DCBD71EEA1ABE8079B8405291", hash_generated_method = "19F8B4D7C587C3F712F7CFE58A36A14E")
    
public XmlStreamReader(InputStream is) throws IOException {
        this(is, true);
    }

    /**
     * Creates a Reader for a raw InputStream.
     * <p>
     * It follows the same logic used for files.
     * <p>
     * If lenient detection is indicated and the detection above fails as per
     * specifications it then attempts the following:
     * <p>
     * If the content type was 'text/html' it replaces it with 'text/xml' and
     * tries the detection again.
     * <p>
     * Else if the XML prolog had a charset encoding that encoding is used.
     * <p>
     * Else if the content type had a charset encoding that encoding is used.
     * <p>
     * Else 'UTF-8' is used.
     * <p>
     * If lenient detection is indicated an XmlStreamReaderException is never
     * thrown.
     *
     * @param is InputStream to create a Reader from.
     * @param lenient indicates if the charset encoding detection should be
     *        relaxed.
     * @throws IOException thrown if there is a problem reading the stream.
     * @throws XmlStreamReaderException thrown if the charset encoding could not
     *         be determined according to the specs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.177 -0400", hash_original_method = "D7947FA233878C6544C57437912F92F2", hash_generated_method = "59FC53656E2191F8D96CD6A9F55E8846")
    
public XmlStreamReader(InputStream is, boolean lenient) throws IOException {
        this(is, lenient, null);
    }

    /**
     * Creates a Reader for a raw InputStream.
     * <p>
     * It follows the same logic used for files.
     * <p>
     * If lenient detection is indicated and the detection above fails as per
     * specifications it then attempts the following:
     * <p>
     * If the content type was 'text/html' it replaces it with 'text/xml' and
     * tries the detection again.
     * <p>
     * Else if the XML prolog had a charset encoding that encoding is used.
     * <p>
     * Else if the content type had a charset encoding that encoding is used.
     * <p>
     * Else 'UTF-8' is used.
     * <p>
     * If lenient detection is indicated an XmlStreamReaderException is never
     * thrown.
     *
     * @param is InputStream to create a Reader from.
     * @param lenient indicates if the charset encoding detection should be
     *        relaxed.
     * @param defaultEncoding The default encoding
     * @throws IOException thrown if there is a problem reading the stream.
     * @throws XmlStreamReaderException thrown if the charset encoding could not
     *         be determined according to the specs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.178 -0400", hash_original_method = "5C48388612DBB8741549449AC63D1729", hash_generated_method = "91B7CC3233998FC6E1FD77B51E745BDC")
    
public XmlStreamReader(InputStream is, boolean lenient, String defaultEncoding) throws IOException {
        this.defaultEncoding = defaultEncoding;
        BOMInputStream bom = new BOMInputStream(new BufferedInputStream(is, BUFFER_SIZE), false, BOMS);
        BOMInputStream pis = new BOMInputStream(bom, true, XML_GUESS_BYTES);
        this.encoding = doRawStream(bom, pis, lenient);
        this.reader = new InputStreamReader(pis, encoding);
    }

    /**
     * Creates a Reader using the InputStream of a URL.
     * <p>
     * If the URL is not of type HTTP and there is not 'content-type' header in
     * the fetched data it uses the same logic used for Files.
     * <p>
     * If the URL is a HTTP Url or there is a 'content-type' header in the
     * fetched data it uses the same logic used for an InputStream with
     * content-type.
     * <p>
     * It does a lenient charset encoding detection, check the constructor with
     * the lenient parameter for details.
     *
     * @param url URL to create a Reader from.
     * @throws IOException thrown if there is a problem reading the stream of
     *         the URL.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.178 -0400", hash_original_method = "82CEBF9DB72DF26FA989C8ED45B81C3F", hash_generated_method = "13CA7B07DD66E14EB0E09ECA75B0157A")
    
public XmlStreamReader(URL url) throws IOException {
        this(url.openConnection(), null);
    }

    /**
     * Creates a Reader using the InputStream of a URLConnection.
     * <p>
     * If the URLConnection is not of type HttpURLConnection and there is not
     * 'content-type' header in the fetched data it uses the same logic used for
     * files.
     * <p>
     * If the URLConnection is a HTTP Url or there is a 'content-type' header in
     * the fetched data it uses the same logic used for an InputStream with
     * content-type.
     * <p>
     * It does a lenient charset encoding detection, check the constructor with
     * the lenient parameter for details.
     *
     * @param conn URLConnection to create a Reader from.
     * @param defaultEncoding The default encoding
     * @throws IOException thrown if there is a problem reading the stream of
     *         the URLConnection.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.179 -0400", hash_original_method = "6E809D2B5EA529301630C2D41F24024A", hash_generated_method = "470AAB13EF43D571F67F166B3B97DF7B")
    
public XmlStreamReader(URLConnection conn, String defaultEncoding) throws IOException {
        this.defaultEncoding = defaultEncoding;
        boolean lenient = true;
        String contentType = conn.getContentType();
        InputStream is = conn.getInputStream();
        BOMInputStream bom = new BOMInputStream(new BufferedInputStream(is, BUFFER_SIZE), false, BOMS);
        BOMInputStream pis = new BOMInputStream(bom, true, XML_GUESS_BYTES);
        if (conn instanceof HttpURLConnection || contentType != null) {
            this.encoding = doHttpStream(bom, pis, contentType, lenient);
        } else {
            this.encoding = doRawStream(bom, pis, lenient);
        }
        this.reader = new InputStreamReader(pis, encoding);
    }

    /**
     * Creates a Reader using an InputStream an the associated content-type
     * header.
     * <p>
     * First it checks if the stream has BOM. If there is not BOM checks the
     * content-type encoding. If there is not content-type encoding checks the
     * XML prolog encoding. If there is not XML prolog encoding uses the default
     * encoding mandated by the content-type MIME type.
     * <p>
     * It does a lenient charset encoding detection, check the constructor with
     * the lenient parameter for details.
     *
     * @param is InputStream to create the reader from.
     * @param httpContentType content-type header to use for the resolution of
     *        the charset encoding.
     * @throws IOException thrown if there is a problem reading the file.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.180 -0400", hash_original_method = "648C41F575208FF436E3CD65D6AE1F65", hash_generated_method = "FC6C665EBE7851ED39ED1FB7B252AEBF")
    
public XmlStreamReader(InputStream is, String httpContentType)
            throws IOException {
        this(is, httpContentType, true);
    }

    /**
     * Creates a Reader using an InputStream an the associated content-type
     * header. This constructor is lenient regarding the encoding detection.
     * <p>
     * First it checks if the stream has BOM. If there is not BOM checks the
     * content-type encoding. If there is not content-type encoding checks the
     * XML prolog encoding. If there is not XML prolog encoding uses the default
     * encoding mandated by the content-type MIME type.
     * <p>
     * If lenient detection is indicated and the detection above fails as per
     * specifications it then attempts the following:
     * <p>
     * If the content type was 'text/html' it replaces it with 'text/xml' and
     * tries the detection again.
     * <p>
     * Else if the XML prolog had a charset encoding that encoding is used.
     * <p>
     * Else if the content type had a charset encoding that encoding is used.
     * <p>
     * Else 'UTF-8' is used.
     * <p>
     * If lenient detection is indicated an XmlStreamReaderException is never
     * thrown.
     *
     * @param is InputStream to create the reader from.
     * @param httpContentType content-type header to use for the resolution of
     *        the charset encoding.
     * @param lenient indicates if the charset encoding detection should be
     *        relaxed.
     * @param defaultEncoding The default encoding
     * @throws IOException thrown if there is a problem reading the file.
     * @throws XmlStreamReaderException thrown if the charset encoding could not
     *         be determined according to the specs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.180 -0400", hash_original_method = "F5BDC5C163DAC78E32A16CC3317DDC65", hash_generated_method = "A85EB6D737AE6C3FCBDAE03631CF2519")
    
public XmlStreamReader(InputStream is, String httpContentType,
            boolean lenient, String defaultEncoding) throws IOException {
        this.defaultEncoding = defaultEncoding;
        BOMInputStream bom = new BOMInputStream(new BufferedInputStream(is, BUFFER_SIZE), false, BOMS);
        BOMInputStream pis = new BOMInputStream(bom, true, XML_GUESS_BYTES);
        this.encoding = doHttpStream(bom, pis, httpContentType, lenient);
        this.reader = new InputStreamReader(pis, encoding);
    }

    /**
     * Creates a Reader using an InputStream an the associated content-type
     * header. This constructor is lenient regarding the encoding detection.
     * <p>
     * First it checks if the stream has BOM. If there is not BOM checks the
     * content-type encoding. If there is not content-type encoding checks the
     * XML prolog encoding. If there is not XML prolog encoding uses the default
     * encoding mandated by the content-type MIME type.
     * <p>
     * If lenient detection is indicated and the detection above fails as per
     * specifications it then attempts the following:
     * <p>
     * If the content type was 'text/html' it replaces it with 'text/xml' and
     * tries the detection again.
     * <p>
     * Else if the XML prolog had a charset encoding that encoding is used.
     * <p>
     * Else if the content type had a charset encoding that encoding is used.
     * <p>
     * Else 'UTF-8' is used.
     * <p>
     * If lenient detection is indicated an XmlStreamReaderException is never
     * thrown.
     *
     * @param is InputStream to create the reader from.
     * @param httpContentType content-type header to use for the resolution of
     *        the charset encoding.
     * @param lenient indicates if the charset encoding detection should be
     *        relaxed.
     * @throws IOException thrown if there is a problem reading the file.
     * @throws XmlStreamReaderException thrown if the charset encoding could not
     *         be determined according to the specs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.181 -0400", hash_original_method = "197DFCD51BDEB338A6D65B1B8F7F2862", hash_generated_method = "3692B3D987668B35D337E90B2AE27249")
    
public XmlStreamReader(InputStream is, String httpContentType,
            boolean lenient) throws IOException {
        this(is, httpContentType, lenient, null);
    }

    /**
     * Returns the default encoding to use if none is set in HTTP content-type,
     * XML prolog and the rules based on content-type are not adequate.
     * <p>
     * If it is NULL the content-type based rules are used.
     *
     * @return the default encoding to use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.175 -0400", hash_original_method = "F443D1F05E85BC7B1454291BD7671BD0", hash_generated_method = "6799ACA480A1E1B4C5AF5DB520288446")
    
public String getDefaultEncoding() {
        return defaultEncoding;
    }

    /**
     * Returns the charset encoding of the XmlStreamReader.
     *
     * @return charset encoding.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.182 -0400", hash_original_method = "ECC6E581C26F132636CDCE9C9A5E5807", hash_generated_method = "AB48E45DF4593246DCA3A0BE40153818")
    
public String getEncoding() {
        return encoding;
    }

    /**
     * Invokes the underlying reader's <code>read(char[], int, int)</code> method.
     * @param buf the buffer to read the characters into
     * @param offset The start offset
     * @param len The number of bytes to read
     * @return the number of characters read or -1 if the end of stream
     * @throws IOException if an I/O error occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.182 -0400", hash_original_method = "36C1E95AD8A6DF443D7A292EAE48D897", hash_generated_method = "F4146742345D588F8015AA41AB33CF4A")
    
@Override
    public int read(char[] buf, int offset, int len) throws IOException {
        return reader.read(buf, offset, len);
    }

    /**
     * Closes the XmlStreamReader stream.
     *
     * @throws IOException thrown if there was a problem closing the stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.183 -0400", hash_original_method = "A1FFC9B80BA56A6C1B0EFB45497D16D1", hash_generated_method = "41BF0F39484A92E2DE0C5158288ACAC3")
    
@Override
    public void close() throws IOException {
        reader.close();
    }

    /**
     * Process the raw stream.
     *
     * @param bom BOMInputStream to detect byte order marks
     * @param pis BOMInputStream to guess XML encoding
     * @param lenient indicates if the charset encoding detection should be
     *        relaxed.
     * @return the encoding to be used
     * @throws IOException thrown if there is a problem reading the stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.183 -0400", hash_original_method = "2A9E440FCF0AAE6B2EF64361426B6DDA", hash_generated_method = "738BEB3568983C73A7474ABE3EBE6D75")
    
private String doRawStream(BOMInputStream bom, BOMInputStream pis, boolean lenient)
            throws IOException {
        String bomEnc      = bom.getBOMCharsetName();
        String xmlGuessEnc = pis.getBOMCharsetName();
        String xmlEnc = getXmlProlog(pis, xmlGuessEnc);
        try {
            return calculateRawEncoding(bomEnc, xmlGuessEnc, xmlEnc);
        } catch (XmlStreamReaderException ex) {
            if (lenient) {
                return doLenientDetection(null, ex);
            } else {
                throw ex;
            }
        }
    }

    /**
     * Process a HTTP stream.
     *
     * @param bom BOMInputStream to detect byte order marks
     * @param pis BOMInputStream to guess XML encoding
     * @param httpContentType The HTTP content type
     * @param lenient indicates if the charset encoding detection should be
     *        relaxed.
     * @return the encoding to be used
     * @throws IOException thrown if there is a problem reading the stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.184 -0400", hash_original_method = "58151B4DA62D82E62869FF632AE48FF5", hash_generated_method = "299A3DFDE9481F7798F49A556FF9A854")
    
private String doHttpStream(BOMInputStream bom, BOMInputStream pis, String httpContentType,
            boolean lenient) throws IOException {
        String bomEnc      = bom.getBOMCharsetName();
        String xmlGuessEnc = pis.getBOMCharsetName();
        String xmlEnc = getXmlProlog(pis, xmlGuessEnc);
        try {
            return calculateHttpEncoding(httpContentType, bomEnc,
                    xmlGuessEnc, xmlEnc, lenient);
        } catch (XmlStreamReaderException ex) {
            if (lenient) {
                return doLenientDetection(httpContentType, ex);
            } else {
                throw ex;
            }
        }
    }

    /**
     * Do lenient detection.
     *
     * @param httpContentType content-type header to use for the resolution of
     *        the charset encoding.
     * @param ex The thrown exception
     * @return the encoding
     * @throws IOException thrown if there is a problem reading the stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.185 -0400", hash_original_method = "68E74736656E5A93054BE7DF7FDFC9F5", hash_generated_method = "308B7815A245DDDD6C83FEC3772FB15D")
    
private String doLenientDetection(String httpContentType,
            XmlStreamReaderException ex) throws IOException {
        if (httpContentType != null && httpContentType.startsWith("text/html")) {
            httpContentType = httpContentType.substring("text/html".length());
            httpContentType = "text/xml" + httpContentType;
            try {
                return calculateHttpEncoding(httpContentType, ex.getBomEncoding(),
                        ex.getXmlGuessEncoding(), ex.getXmlEncoding(), true);
            } catch (XmlStreamReaderException ex2) {
                ex = ex2;
            }
        }
        String encoding = ex.getXmlEncoding();
        if (encoding == null) {
            encoding = ex.getContentTypeEncoding();
        }
        if (encoding == null) {
            encoding = defaultEncoding == null ? UTF_8 : defaultEncoding;
        }
        return encoding;
    }

    /**
     * Calculate the raw encoding.
     *
     * @param bomEnc BOM encoding
     * @param xmlGuessEnc XML Guess encoding
     * @param xmlEnc XML encoding
     * @return the raw encoding
     * @throws IOException thrown if there is a problem reading the stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.187 -0400", hash_original_method = "598A080C11FF68E733FEC8702F091B2A", hash_generated_method = "9B274B45B50C031E497E39349038391A")
    
String calculateRawEncoding(String bomEnc, String xmlGuessEnc,
            String xmlEnc) throws IOException {

        // BOM is Null
        if (bomEnc == null) {
            if (xmlGuessEnc == null || xmlEnc == null) {
                return defaultEncoding == null ? UTF_8 : defaultEncoding;
            }
            if (xmlEnc.equals(UTF_16) &&
               (xmlGuessEnc.equals(UTF_16BE) || xmlGuessEnc.equals(UTF_16LE))) {
                return xmlGuessEnc;
            }
            return xmlEnc;
        }

        // BOM is UTF-8
        if (bomEnc.equals(UTF_8)) {
            if (xmlGuessEnc != null && !xmlGuessEnc.equals(UTF_8)) {
                String msg = MessageFormat.format(RAW_EX_1, new Object[] { bomEnc, xmlGuessEnc, xmlEnc });
                throw new XmlStreamReaderException(msg, bomEnc, xmlGuessEnc, xmlEnc);
            }
            if (xmlEnc != null && !xmlEnc.equals(UTF_8)) {
                String msg = MessageFormat.format(RAW_EX_1, new Object[] { bomEnc, xmlGuessEnc, xmlEnc });
                throw new XmlStreamReaderException(msg, bomEnc, xmlGuessEnc, xmlEnc);
            }
            return bomEnc;
        }

        // BOM is UTF-16BE or UTF-16LE
        if (bomEnc.equals(UTF_16BE) || bomEnc.equals(UTF_16LE)) {
            if (xmlGuessEnc != null && !xmlGuessEnc.equals(bomEnc)) {
                String msg = MessageFormat.format(RAW_EX_1, new Object[] { bomEnc, xmlGuessEnc, xmlEnc });
                throw new XmlStreamReaderException(msg, bomEnc, xmlGuessEnc, xmlEnc);
            }
            if (xmlEnc != null && !xmlEnc.equals(UTF_16) && !xmlEnc.equals(bomEnc)) {
                String msg = MessageFormat.format(RAW_EX_1, new Object[] { bomEnc, xmlGuessEnc, xmlEnc });
                throw new XmlStreamReaderException(msg, bomEnc, xmlGuessEnc, xmlEnc);
            }
            return bomEnc;
        }

        // BOM is UTF-32BE or UTF-32LE
        if (bomEnc.equals(UTF_32BE) || bomEnc.equals(UTF_32LE)) {
            if (xmlGuessEnc != null && !xmlGuessEnc.equals(bomEnc)) {
                String msg = MessageFormat.format(RAW_EX_1, new Object[] { bomEnc, xmlGuessEnc, xmlEnc });
                throw new XmlStreamReaderException(msg, bomEnc, xmlGuessEnc, xmlEnc);
            }
            if (xmlEnc != null && !xmlEnc.equals(UTF_32) && !xmlEnc.equals(bomEnc)) {
                String msg = MessageFormat.format(RAW_EX_1, new Object[] { bomEnc, xmlGuessEnc, xmlEnc });
                throw new XmlStreamReaderException(msg, bomEnc, xmlGuessEnc, xmlEnc);
            }
            return bomEnc;
        }

        // BOM is something else
        String msg = MessageFormat.format(RAW_EX_2, new Object[] { bomEnc, xmlGuessEnc, xmlEnc });
        throw new XmlStreamReaderException(msg, bomEnc, xmlGuessEnc, xmlEnc);
    }


    /**
     * Calculate the HTTP encoding.
     *
     * @param httpContentType The HTTP content type
     * @param bomEnc BOM encoding
     * @param xmlGuessEnc XML Guess encoding
     * @param xmlEnc XML encoding
     * @param lenient indicates if the charset encoding detection should be
     *        relaxed.
     * @return the HTTP encoding
     * @throws IOException thrown if there is a problem reading the stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.189 -0400", hash_original_method = "473EAA9BFD3853985435EE444206468A", hash_generated_method = "B56D8C13B12B0628537BFAE0579EBA98")
    
String calculateHttpEncoding(String httpContentType,
            String bomEnc, String xmlGuessEnc, String xmlEnc,
            boolean lenient) throws IOException {

        // Lenient and has XML encoding
        if (lenient && xmlEnc != null) {
            return xmlEnc;
        }

        // Determine mime/encoding content types from HTTP Content Type
        String cTMime = getContentTypeMime(httpContentType);
        String cTEnc  = getContentTypeEncoding(httpContentType);
        boolean appXml  = isAppXml(cTMime);
        boolean textXml = isTextXml(cTMime);

        // Mime type NOT "application/xml" or "text/xml"
        if (!appXml && !textXml) {
            String msg = MessageFormat.format(HTTP_EX_3, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
            throw new XmlStreamReaderException(msg, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
        }

        // No content type encoding
        if (cTEnc == null) {
            if (appXml) {
                return calculateRawEncoding(bomEnc, xmlGuessEnc, xmlEnc);
            } else {
                return defaultEncoding == null ? US_ASCII : defaultEncoding;
            }
        }

        // UTF-16BE or UTF-16LE content type encoding
        if (cTEnc.equals(UTF_16BE) || cTEnc.equals(UTF_16LE)) {
            if (bomEnc != null) {
                String msg = MessageFormat.format(HTTP_EX_1, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
                throw new XmlStreamReaderException(msg, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
            }
            return cTEnc;
        }

        // UTF-16 content type encoding
        if (cTEnc.equals(UTF_16)) {
            if (bomEnc != null && bomEnc.startsWith(UTF_16)) {
                return bomEnc;
            }
            String msg = MessageFormat.format(HTTP_EX_2, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
            throw new XmlStreamReaderException(msg, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
        }

        // UTF-32BE or UTF-132E content type encoding
        if (cTEnc.equals(UTF_32BE) || cTEnc.equals(UTF_32LE)) {
            if (bomEnc != null) {
                String msg = MessageFormat.format(HTTP_EX_1, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
                throw new XmlStreamReaderException(msg, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
            }
            return cTEnc;
        }

        // UTF-32 content type encoding
        if (cTEnc.equals(UTF_32)) {
            if (bomEnc != null && bomEnc.startsWith(UTF_32)) {
                return bomEnc;
            }
            String msg = MessageFormat.format(HTTP_EX_2, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
            throw new XmlStreamReaderException(msg, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
        }

        return cTEnc;
    }

}
