package org.apache.commons.io.input;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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

public class XmlStreamReader extends Reader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.386 -0400", hash_original_field = "1DE9B0A30075AE8C303EB420C103C320", hash_generated_field = "506A19594AC0AF91386404965612888E")

    private Reader reader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.386 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "AA03A19AA54A465901EEA798BB232EAE")

    private String encoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.386 -0400", hash_original_field = "2E6818A22DEC05B4DD41A9B586220A42", hash_generated_field = "7380F104304B5118624DAE9AD6B460C4")

    private String defaultEncoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.387 -0400", hash_original_method = "0BFB3D2359EDBDC19A64BE4776F868C5", hash_generated_method = "41324A7FBB096AF5846EAE2932463266")
    public  XmlStreamReader(File file) throws IOException {
        this(new FileInputStream(file));
        addTaint(file.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.391 -0400", hash_original_method = "CCF5242DCBD71EEA1ABE8079B8405291", hash_generated_method = "E5503EEB4BB5B41EB6701421A0D0F5F1")
    public  XmlStreamReader(InputStream is) throws IOException {
        this(is, true);
        addTaint(is.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.393 -0400", hash_original_method = "D7947FA233878C6544C57437912F92F2", hash_generated_method = "DD631CB8E69DA291C1960856946E1A41")
    public  XmlStreamReader(InputStream is, boolean lenient) throws IOException {
        this(is, lenient, null);
        addTaint(is.getTaint());
        addTaint(lenient);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.403 -0400", hash_original_method = "5C48388612DBB8741549449AC63D1729", hash_generated_method = "12654BE6EA67FA7DB175EE239E450201")
    public  XmlStreamReader(InputStream is, boolean lenient, String defaultEncoding) throws IOException {
        this.defaultEncoding = defaultEncoding;
        BOMInputStream bom;
        bom = new BOMInputStream(new BufferedInputStream(is, BUFFER_SIZE), false, BOMS);
        BOMInputStream pis;
        pis = new BOMInputStream(bom, true, XML_GUESS_BYTES);
        this.encoding = doRawStream(bom, pis, lenient);
        this.reader = new InputStreamReader(pis, encoding);
        addTaint(is.getTaint());
        // ---------- Original Method ----------
        //this.defaultEncoding = defaultEncoding;
        //BOMInputStream bom = new BOMInputStream(new BufferedInputStream(is, BUFFER_SIZE), false, BOMS);
        //BOMInputStream pis = new BOMInputStream(bom, true, XML_GUESS_BYTES);
        //this.encoding = doRawStream(bom, pis, lenient);
        //this.reader = new InputStreamReader(pis, encoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.403 -0400", hash_original_method = "82CEBF9DB72DF26FA989C8ED45B81C3F", hash_generated_method = "DF694AB6D00E0458AB676F776FD53EEF")
    public  XmlStreamReader(URL url) throws IOException {
        this(url.openConnection(), null);
        addTaint(url.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.404 -0400", hash_original_method = "6E809D2B5EA529301630C2D41F24024A", hash_generated_method = "CDB6E4299B6EBFDDB379EE8FA673EB12")
    public  XmlStreamReader(URLConnection conn, String defaultEncoding) throws IOException {
        this.defaultEncoding = defaultEncoding;
        boolean lenient;
        lenient = true;
        String contentType;
        contentType = conn.getContentType();
        InputStream is;
        is = conn.getInputStream();
        BOMInputStream bom;
        bom = new BOMInputStream(new BufferedInputStream(is, BUFFER_SIZE), false, BOMS);
        BOMInputStream pis;
        pis = new BOMInputStream(bom, true, XML_GUESS_BYTES);
        {
            this.encoding = doHttpStream(bom, pis, contentType, lenient);
        } //End block
        {
            this.encoding = doRawStream(bom, pis, lenient);
        } //End block
        this.reader = new InputStreamReader(pis, encoding);
        addTaint(conn.getTaint());
        // ---------- Original Method ----------
        //this.defaultEncoding = defaultEncoding;
        //boolean lenient = true;
        //String contentType = conn.getContentType();
        //InputStream is = conn.getInputStream();
        //BOMInputStream bom = new BOMInputStream(new BufferedInputStream(is, BUFFER_SIZE), false, BOMS);
        //BOMInputStream pis = new BOMInputStream(bom, true, XML_GUESS_BYTES);
        //if (conn instanceof HttpURLConnection || contentType != null) {
            //this.encoding = doHttpStream(bom, pis, contentType, lenient);
        //} else {
            //this.encoding = doRawStream(bom, pis, lenient);
        //}
        //this.reader = new InputStreamReader(pis, encoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.404 -0400", hash_original_method = "648C41F575208FF436E3CD65D6AE1F65", hash_generated_method = "727D714F8D181A1D21315953B9989E0C")
    public  XmlStreamReader(InputStream is, String httpContentType) throws IOException {
        this(is, httpContentType, true);
        addTaint(is.getTaint());
        addTaint(httpContentType.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.405 -0400", hash_original_method = "F5BDC5C163DAC78E32A16CC3317DDC65", hash_generated_method = "D8E97CFA2E36521BA88BFFC90376F212")
    public  XmlStreamReader(InputStream is, String httpContentType,
            boolean lenient, String defaultEncoding) throws IOException {
        this.defaultEncoding = defaultEncoding;
        BOMInputStream bom;
        bom = new BOMInputStream(new BufferedInputStream(is, BUFFER_SIZE), false, BOMS);
        BOMInputStream pis;
        pis = new BOMInputStream(bom, true, XML_GUESS_BYTES);
        this.encoding = doHttpStream(bom, pis, httpContentType, lenient);
        this.reader = new InputStreamReader(pis, encoding);
        addTaint(is.getTaint());
        // ---------- Original Method ----------
        //this.defaultEncoding = defaultEncoding;
        //BOMInputStream bom = new BOMInputStream(new BufferedInputStream(is, BUFFER_SIZE), false, BOMS);
        //BOMInputStream pis = new BOMInputStream(bom, true, XML_GUESS_BYTES);
        //this.encoding = doHttpStream(bom, pis, httpContentType, lenient);
        //this.reader = new InputStreamReader(pis, encoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.405 -0400", hash_original_method = "197DFCD51BDEB338A6D65B1B8F7F2862", hash_generated_method = "9AD7A5B4FA7A05024CEDBA4C2380FEF5")
    public  XmlStreamReader(InputStream is, String httpContentType,
            boolean lenient) throws IOException {
        this(is, httpContentType, lenient, null);
        addTaint(is.getTaint());
        addTaint(httpContentType.getTaint());
        addTaint(lenient);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.409 -0400", hash_original_method = "F443D1F05E85BC7B1454291BD7671BD0", hash_generated_method = "988CD1AA9E7DEFF8CF2D97A931D77415")
    public String getDefaultEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1384159246 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1384159246 = defaultEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_1384159246.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1384159246;
        // ---------- Original Method ----------
        //return defaultEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.412 -0400", hash_original_method = "ECC6E581C26F132636CDCE9C9A5E5807", hash_generated_method = "E6F7D797451231C6897B28472E0597C4")
    public String getEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_662947405 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_662947405 = encoding;
        varB4EAC82CA7396A68D541C85D26508E83_662947405.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_662947405;
        // ---------- Original Method ----------
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.413 -0400", hash_original_method = "36C1E95AD8A6DF443D7A292EAE48D897", hash_generated_method = "D90A5F3B24434D2105CF460716E991BF")
    @Override
    public int read(char[] buf, int offset, int len) throws IOException {
        int varE6208E871A644876F7A6FF91A8F8C1CC_979783501 = (reader.read(buf, offset, len));
        addTaint(buf[0]);
        addTaint(offset);
        addTaint(len);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_420900507 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_420900507;
        // ---------- Original Method ----------
        //return reader.read(buf, offset, len);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.426 -0400", hash_original_method = "A1FFC9B80BA56A6C1B0EFB45497D16D1", hash_generated_method = "B3E1029E376B5E0CFBFF8FD738B892BD")
    @Override
    public void close() throws IOException {
        reader.close();
        // ---------- Original Method ----------
        //reader.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.426 -0400", hash_original_method = "2A9E440FCF0AAE6B2EF64361426B6DDA", hash_generated_method = "2325905732495D54B182FD401BAFBA0A")
    private String doRawStream(BOMInputStream bom, BOMInputStream pis, boolean lenient) throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_1001703578 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1228088785 = null; //Variable for return #2
        String bomEnc;
        bomEnc = bom.getBOMCharsetName();
        String xmlGuessEnc;
        xmlGuessEnc = pis.getBOMCharsetName();
        String xmlEnc;
        xmlEnc = getXmlProlog(pis, xmlGuessEnc);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1001703578 = calculateRawEncoding(bomEnc, xmlGuessEnc, xmlEnc);
        } //End block
        catch (XmlStreamReaderException ex)
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1228088785 = doLenientDetection(null, ex);
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw ex;
            } //End block
        } //End block
        addTaint(bom.getTaint());
        addTaint(pis.getTaint());
        addTaint(lenient);
        String varA7E53CE21691AB073D9660D615818899_1953456758; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1953456758 = varB4EAC82CA7396A68D541C85D26508E83_1001703578;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1953456758 = varB4EAC82CA7396A68D541C85D26508E83_1228088785;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1953456758.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1953456758;
        // ---------- Original Method ----------
        //String bomEnc      = bom.getBOMCharsetName();
        //String xmlGuessEnc = pis.getBOMCharsetName();
        //String xmlEnc = getXmlProlog(pis, xmlGuessEnc);
        //try {
            //return calculateRawEncoding(bomEnc, xmlGuessEnc, xmlEnc);
        //} catch (XmlStreamReaderException ex) {
            //if (lenient) {
                //return doLenientDetection(null, ex);
            //} else {
                //throw ex;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.427 -0400", hash_original_method = "58151B4DA62D82E62869FF632AE48FF5", hash_generated_method = "30F5AFAD7F72AA2AA16F6BE1B74665CA")
    private String doHttpStream(BOMInputStream bom, BOMInputStream pis, String httpContentType,
            boolean lenient) throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_1025269188 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_388604044 = null; //Variable for return #2
        String bomEnc;
        bomEnc = bom.getBOMCharsetName();
        String xmlGuessEnc;
        xmlGuessEnc = pis.getBOMCharsetName();
        String xmlEnc;
        xmlEnc = getXmlProlog(pis, xmlGuessEnc);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1025269188 = calculateHttpEncoding(httpContentType, bomEnc,
                    xmlGuessEnc, xmlEnc, lenient);
        } //End block
        catch (XmlStreamReaderException ex)
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_388604044 = doLenientDetection(httpContentType, ex);
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw ex;
            } //End block
        } //End block
        addTaint(bom.getTaint());
        addTaint(pis.getTaint());
        addTaint(httpContentType.getTaint());
        addTaint(lenient);
        String varA7E53CE21691AB073D9660D615818899_1821902913; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1821902913 = varB4EAC82CA7396A68D541C85D26508E83_1025269188;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1821902913 = varB4EAC82CA7396A68D541C85D26508E83_388604044;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1821902913.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1821902913;
        // ---------- Original Method ----------
        //String bomEnc      = bom.getBOMCharsetName();
        //String xmlGuessEnc = pis.getBOMCharsetName();
        //String xmlEnc = getXmlProlog(pis, xmlGuessEnc);
        //try {
            //return calculateHttpEncoding(httpContentType, bomEnc,
                    //xmlGuessEnc, xmlEnc, lenient);
        //} catch (XmlStreamReaderException ex) {
            //if (lenient) {
                //return doLenientDetection(httpContentType, ex);
            //} else {
                //throw ex;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.428 -0400", hash_original_method = "68E74736656E5A93054BE7DF7FDFC9F5", hash_generated_method = "6AF79A8D4D5C76B9F3F888FFA863A7A1")
    private String doLenientDetection(String httpContentType,
            XmlStreamReaderException ex) throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_2146348981 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1582954993 = null; //Variable for return #2
        {
            boolean varADC12483E48F090449D7F503883EB5FD_1823057744 = (httpContentType != null && httpContentType.startsWith("text/html"));
            {
                httpContentType = httpContentType.substring("text/html".length());
                httpContentType = "text/xml" + httpContentType;
                try 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_2146348981 = calculateHttpEncoding(httpContentType, ex.getBomEncoding(),
                        ex.getXmlGuessEncoding(), ex.getXmlEncoding(), true);
                } //End block
                catch (XmlStreamReaderException ex2)
                {
                    ex = ex2;
                } //End block
            } //End block
        } //End collapsed parenthetic
        String encoding;
        encoding = ex.getXmlEncoding();
        {
            encoding = ex.getContentTypeEncoding();
        } //End block
        {
            encoding = defaultEncoding == null ? UTF_8 : defaultEncoding;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1582954993 = encoding;
        addTaint(httpContentType.getTaint());
        String varA7E53CE21691AB073D9660D615818899_240631441; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_240631441 = varB4EAC82CA7396A68D541C85D26508E83_2146348981;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_240631441 = varB4EAC82CA7396A68D541C85D26508E83_1582954993;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_240631441.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_240631441;
        // ---------- Original Method ----------
        //if (httpContentType != null && httpContentType.startsWith("text/html")) {
            //httpContentType = httpContentType.substring("text/html".length());
            //httpContentType = "text/xml" + httpContentType;
            //try {
                //return calculateHttpEncoding(httpContentType, ex.getBomEncoding(),
                        //ex.getXmlGuessEncoding(), ex.getXmlEncoding(), true);
            //} catch (XmlStreamReaderException ex2) {
                //ex = ex2;
            //}
        //}
        //String encoding = ex.getXmlEncoding();
        //if (encoding == null) {
            //encoding = ex.getContentTypeEncoding();
        //}
        //if (encoding == null) {
            //encoding = defaultEncoding == null ? UTF_8 : defaultEncoding;
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.436 -0400", hash_original_method = "598A080C11FF68E733FEC8702F091B2A", hash_generated_method = "40E1D547B2157190E2BD238EFF9B72B3")
     String calculateRawEncoding(String bomEnc, String xmlGuessEnc,
            String xmlEnc) throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_430030498 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1484990267 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1328890579 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_628048042 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_948661453 = null; //Variable for return #5
        String varB4EAC82CA7396A68D541C85D26508E83_254203552 = null; //Variable for return #6
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_430030498 = defaultEncoding == null ? UTF_8 : defaultEncoding;
            } //End block
            {
                boolean varD72E639AC4AA6EF933351F21134C75F3_1660896879 = (xmlEnc.equals(UTF_16) &&
               (xmlGuessEnc.equals(UTF_16BE) || xmlGuessEnc.equals(UTF_16LE)));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1484990267 = xmlGuessEnc;
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1328890579 = xmlEnc;
        } //End block
        {
            boolean var05D4235A5AAB64E1B9E697B33C4708A3_822922642 = (bomEnc.equals(UTF_8));
            {
                {
                    boolean var62524306C0F31023C39194E845ABF38F_311482342 = (xmlGuessEnc != null && !xmlGuessEnc.equals(UTF_8));
                    {
                        String msg;
                        msg = MessageFormat.format(RAW_EX_1, new Object[] { bomEnc, xmlGuessEnc, xmlEnc });
                        if (DroidSafeAndroidRuntime.control) throw new XmlStreamReaderException(msg, bomEnc, xmlGuessEnc, xmlEnc);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var337070B8C81CC48CA52092D74E98A2BA_87390966 = (xmlEnc != null && !xmlEnc.equals(UTF_8));
                    {
                        String msg;
                        msg = MessageFormat.format(RAW_EX_1, new Object[] { bomEnc, xmlGuessEnc, xmlEnc });
                        if (DroidSafeAndroidRuntime.control) throw new XmlStreamReaderException(msg, bomEnc, xmlGuessEnc, xmlEnc);
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_628048042 = bomEnc;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var95C6B3606E306A883C5DAD27B2011DC1_857748135 = (bomEnc.equals(UTF_16BE) || bomEnc.equals(UTF_16LE));
            {
                {
                    boolean var6F26888B9BC93081AE7350D9D7FEAEC1_795372466 = (xmlGuessEnc != null && !xmlGuessEnc.equals(bomEnc));
                    {
                        String msg;
                        msg = MessageFormat.format(RAW_EX_1, new Object[] { bomEnc, xmlGuessEnc, xmlEnc });
                        if (DroidSafeAndroidRuntime.control) throw new XmlStreamReaderException(msg, bomEnc, xmlGuessEnc, xmlEnc);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varE205CCAAD1CE92A671F2E030AFBF9C4B_1600989708 = (xmlEnc != null && !xmlEnc.equals(UTF_16) && !xmlEnc.equals(bomEnc));
                    {
                        String msg;
                        msg = MessageFormat.format(RAW_EX_1, new Object[] { bomEnc, xmlGuessEnc, xmlEnc });
                        if (DroidSafeAndroidRuntime.control) throw new XmlStreamReaderException(msg, bomEnc, xmlGuessEnc, xmlEnc);
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_948661453 = bomEnc;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var5B4EFAC3FCA3ADDEFE671851D965B899_357190994 = (bomEnc.equals(UTF_32BE) || bomEnc.equals(UTF_32LE));
            {
                {
                    boolean var6F26888B9BC93081AE7350D9D7FEAEC1_1370244431 = (xmlGuessEnc != null && !xmlGuessEnc.equals(bomEnc));
                    {
                        String msg;
                        msg = MessageFormat.format(RAW_EX_1, new Object[] { bomEnc, xmlGuessEnc, xmlEnc });
                        if (DroidSafeAndroidRuntime.control) throw new XmlStreamReaderException(msg, bomEnc, xmlGuessEnc, xmlEnc);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varE4672F12009CFFB765D33593ECEA1058_1923555379 = (xmlEnc != null && !xmlEnc.equals(UTF_32) && !xmlEnc.equals(bomEnc));
                    {
                        String msg;
                        msg = MessageFormat.format(RAW_EX_1, new Object[] { bomEnc, xmlGuessEnc, xmlEnc });
                        if (DroidSafeAndroidRuntime.control) throw new XmlStreamReaderException(msg, bomEnc, xmlGuessEnc, xmlEnc);
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_254203552 = bomEnc;
            } //End block
        } //End collapsed parenthetic
        String msg;
        msg = MessageFormat.format(RAW_EX_2, new Object[] { bomEnc, xmlGuessEnc, xmlEnc });
        if (DroidSafeAndroidRuntime.control) throw new XmlStreamReaderException(msg, bomEnc, xmlGuessEnc, xmlEnc);
        addTaint(bomEnc.getTaint());
        addTaint(xmlGuessEnc.getTaint());
        addTaint(xmlEnc.getTaint());
        String varA7E53CE21691AB073D9660D615818899_751928248; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_751928248 = varB4EAC82CA7396A68D541C85D26508E83_430030498;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_751928248 = varB4EAC82CA7396A68D541C85D26508E83_1484990267;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_751928248 = varB4EAC82CA7396A68D541C85D26508E83_1328890579;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_751928248 = varB4EAC82CA7396A68D541C85D26508E83_628048042;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_751928248 = varB4EAC82CA7396A68D541C85D26508E83_948661453;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_751928248 = varB4EAC82CA7396A68D541C85D26508E83_254203552;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_751928248.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_751928248;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.451 -0400", hash_original_method = "473EAA9BFD3853985435EE444206468A", hash_generated_method = "6AF82875EFE558DE8531AA8966423EE0")
     String calculateHttpEncoding(String httpContentType,
            String bomEnc, String xmlGuessEnc, String xmlEnc,
            boolean lenient) throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_1624622892 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1564118797 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_333719965 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1119938472 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_190816764 = null; //Variable for return #5
        String varB4EAC82CA7396A68D541C85D26508E83_101822846 = null; //Variable for return #6
        String varB4EAC82CA7396A68D541C85D26508E83_1176889091 = null; //Variable for return #7
        String varB4EAC82CA7396A68D541C85D26508E83_1321206706 = null; //Variable for return #8
        {
            varB4EAC82CA7396A68D541C85D26508E83_1624622892 = xmlEnc;
        } //End block
        String cTMime;
        cTMime = getContentTypeMime(httpContentType);
        String cTEnc;
        cTEnc = getContentTypeEncoding(httpContentType);
        boolean appXml;
        appXml = isAppXml(cTMime);
        boolean textXml;
        textXml = isTextXml(cTMime);
        {
            String msg;
            msg = MessageFormat.format(HTTP_EX_3, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
            if (DroidSafeAndroidRuntime.control) throw new XmlStreamReaderException(msg, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
        } //End block
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1564118797 = calculateRawEncoding(bomEnc, xmlGuessEnc, xmlEnc);
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_333719965 = defaultEncoding == null ? US_ASCII : defaultEncoding;
            } //End block
        } //End block
        {
            boolean varA66ED870F91B3E206532F611AC081DC4_382666983 = (cTEnc.equals(UTF_16BE) || cTEnc.equals(UTF_16LE));
            {
                {
                    String msg;
                    msg = MessageFormat.format(HTTP_EX_1, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
                    if (DroidSafeAndroidRuntime.control) throw new XmlStreamReaderException(msg, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_1119938472 = cTEnc;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varAD0794C12B61186D2901F9D6CE6CDBA0_767419897 = (cTEnc.equals(UTF_16));
            {
                {
                    boolean var206F7FB41A85C55720A99BCA525A0222_1484244780 = (bomEnc != null && bomEnc.startsWith(UTF_16));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_190816764 = bomEnc;
                    } //End block
                } //End collapsed parenthetic
                String msg;
                msg = MessageFormat.format(HTTP_EX_2, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
                if (DroidSafeAndroidRuntime.control) throw new XmlStreamReaderException(msg, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varA1FB0DF7C2C4A3058B94A15EEAC2F5BD_1249165145 = (cTEnc.equals(UTF_32BE) || cTEnc.equals(UTF_32LE));
            {
                {
                    String msg;
                    msg = MessageFormat.format(HTTP_EX_1, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
                    if (DroidSafeAndroidRuntime.control) throw new XmlStreamReaderException(msg, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_101822846 = cTEnc;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varDA94B5F3AFAF374AF5D7C303065796A9_1028127164 = (cTEnc.equals(UTF_32));
            {
                {
                    boolean var1928AC4E0FFCF8A4AF1F5570C0051B8D_1674378828 = (bomEnc != null && bomEnc.startsWith(UTF_32));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1176889091 = bomEnc;
                    } //End block
                } //End collapsed parenthetic
                String msg;
                msg = MessageFormat.format(HTTP_EX_2, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
                if (DroidSafeAndroidRuntime.control) throw new XmlStreamReaderException(msg, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1321206706 = cTEnc;
        addTaint(httpContentType.getTaint());
        addTaint(bomEnc.getTaint());
        addTaint(xmlGuessEnc.getTaint());
        addTaint(xmlEnc.getTaint());
        addTaint(lenient);
        String varA7E53CE21691AB073D9660D615818899_1788880664; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1788880664 = varB4EAC82CA7396A68D541C85D26508E83_1624622892;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1788880664 = varB4EAC82CA7396A68D541C85D26508E83_1564118797;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1788880664 = varB4EAC82CA7396A68D541C85D26508E83_333719965;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1788880664 = varB4EAC82CA7396A68D541C85D26508E83_1119938472;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1788880664 = varB4EAC82CA7396A68D541C85D26508E83_190816764;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1788880664 = varB4EAC82CA7396A68D541C85D26508E83_101822846;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_1788880664 = varB4EAC82CA7396A68D541C85D26508E83_1176889091;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1788880664 = varB4EAC82CA7396A68D541C85D26508E83_1321206706;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1788880664.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1788880664;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
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

    
        private static String getXmlProlog(InputStream is, String guessedEnc) throws IOException {
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

    
        static boolean isAppXml(String mime) {
        return mime != null &&
               (mime.equals("application/xml") || 
                mime.equals("application/xml-dtd") ||
                mime.equals("application/xml-external-parsed-entity") ||
               mime.startsWith("application/") && mime.endsWith("+xml"));
    }

    
        static boolean isTextXml(String mime) {
        return mime != null &&
              (mime.equals("text/xml") ||
               mime.equals("text/xml-external-parsed-entity") ||
              mime.startsWith("text/") && mime.endsWith("+xml"));
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.456 -0400", hash_original_field = "2B07217CBE09429BD34768CAB6EB3687", hash_generated_field = "C8F27ACB387136509673C7BF8F97DCB5")

    private static int BUFFER_SIZE = 4096;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.456 -0400", hash_original_field = "923519EE0F5F6D2A4432D632B72D3636", hash_generated_field = "692BCBFE21600E16D517CCAC238F59BB")

    private static String UTF_8 = "UTF-8";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.456 -0400", hash_original_field = "3366608D595FEC4D1002965F1D6B7A40", hash_generated_field = "055DBE847470FE9B21104F6631F8DBD8")

    private static String US_ASCII = "US-ASCII";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.456 -0400", hash_original_field = "063081C6B6338AA593B9BD7B1869D671", hash_generated_field = "699FA638594F34FEB702806190F59D09")

    private static String UTF_16BE = "UTF-16BE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.456 -0400", hash_original_field = "2CB45C0D573BC3D13B29603F5683068C", hash_generated_field = "D34CA9C5E9F4E08E94B44F72EC517077")

    private static String UTF_16LE = "UTF-16LE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.456 -0400", hash_original_field = "FCDE3D5EDC9A8E3C945CFF4CFE958F25", hash_generated_field = "10BDD6CD80C22C1D4D05DE65EABEE34F")

    private static String UTF_32BE = "UTF-32BE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.456 -0400", hash_original_field = "68423F9B0C3E3D103C69D8DA0AC8A30E", hash_generated_field = "7C2F428DC94A12DBFEBEBD61751784D5")

    private static String UTF_32LE = "UTF-32LE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.456 -0400", hash_original_field = "EE694B7D03608A3D6DED57D0864C1D7D", hash_generated_field = "D87897BC5BCF467D59D419687E546689")

    private static String UTF_16 = "UTF-16";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.456 -0400", hash_original_field = "B37FC3161667C9A58215DA11E351264B", hash_generated_field = "EC1A7C7593E598674CBB7E3A2FB86827")

    private static String UTF_32 = "UTF-32";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.456 -0400", hash_original_field = "B5D8CB20D7ED7BB8C60D3A0790885F81", hash_generated_field = "CBDB632B6647C83E838B32CC9B595C83")

    private static String EBCDIC = "CP1047";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.456 -0400", hash_original_field = "BCF9C344BAD5BCA63743A9E7C00DAFDD", hash_generated_field = "754B175F035775498E3ED3DA50BB7005")

    private static ByteOrderMark[] BOMS = new ByteOrderMark[] {
        ByteOrderMark.UTF_8,
        ByteOrderMark.UTF_16BE,
        ByteOrderMark.UTF_16LE,
        ByteOrderMark.UTF_32BE,
        ByteOrderMark.UTF_32LE
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.456 -0400", hash_original_field = "7262F6B46264CC81F2C9B0D461E5E765", hash_generated_field = "D38F96918F25A579E57F7916664961DF")

    private static ByteOrderMark[] XML_GUESS_BYTES = new ByteOrderMark[] {
        new ByteOrderMark(UTF_8,    0x3C, 0x3F, 0x78, 0x6D),
        new ByteOrderMark(UTF_16BE, 0x00, 0x3C, 0x00, 0x3F),
        new ByteOrderMark(UTF_16LE, 0x3C, 0x00, 0x3F, 0x00),
        new ByteOrderMark(UTF_32BE, 0x00, 0x00, 0x00, 0x3C, 
                0x00, 0x00, 0x00, 0x3F, 0x00, 0x00, 0x00, 0x78, 0x00, 0x00, 0x00, 0x6D),
        new ByteOrderMark(UTF_32LE, 0x3C, 0x00, 0x00, 0x00, 
                0x3F, 0x00, 0x00, 0x00, 0x78, 0x00, 0x00, 0x00, 0x6D, 0x00, 0x00, 0x00),
        new ByteOrderMark(EBCDIC,   0x4C, 0x6F, 0xA7, 0x94)
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.456 -0400", hash_original_field = "E93463F9AD4ABDB2BC1B5D54C5CDBCE4", hash_generated_field = "96067BA6F609E60A7DDA48094271BF7A")

    private static Pattern CHARSET_PATTERN = Pattern
            .compile("charset=[\"']?([.[^; \"']]*)[\"']?");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.456 -0400", hash_original_field = "162F6E8430AADCA87B9B59D662C33537", hash_generated_field = "DEFAFF066C62F1F078270AB77D86A366")

    public static final Pattern ENCODING_PATTERN = Pattern.compile(
            "<\\?xml.*encoding[\\s]*=[\\s]*((?:\".[^\"]*\")|(?:'.[^']*'))",
            Pattern.MULTILINE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.456 -0400", hash_original_field = "362A03DBB7926243A30FD51049410321", hash_generated_field = "B338166D1D353B84F38F9109E94DF3FE")

    private static String RAW_EX_1 = "Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.467 -0400", hash_original_field = "92DE7A15249FEA6598F55FAF0E54E562", hash_generated_field = "A65E249D266F2E273A147FF1A0B9433C")

    private static String RAW_EX_2 = "Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] unknown BOM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.467 -0400", hash_original_field = "6094B713482D3FA9DF0B9EF7EEBA8C48", hash_generated_field = "B57061920EA5C45DEED2BBC99338C151")

    private static String HTTP_EX_1 = "Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], BOM must be NULL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.467 -0400", hash_original_field = "8DE76BF9FB9A94A77AF152AA598C2D92", hash_generated_field = "CE2BB1711B86B0ABAE39194F252CEA5C")

    private static String HTTP_EX_2 = "Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], encoding mismatch";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:08.467 -0400", hash_original_field = "F0151DE2D936369B97F9D97A85304A23", hash_generated_field = "7CABD51345C474E0F60C48971EAAFE29")

    private static String HTTP_EX_3 = "Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], Invalid MIME";
}

