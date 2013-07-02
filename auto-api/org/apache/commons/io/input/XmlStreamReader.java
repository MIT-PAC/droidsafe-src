package org.apache.commons.io.input;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.434 -0400", hash_original_field = "1DE9B0A30075AE8C303EB420C103C320", hash_generated_field = "506A19594AC0AF91386404965612888E")

    private Reader reader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.434 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "AA03A19AA54A465901EEA798BB232EAE")

    private String encoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.434 -0400", hash_original_field = "2E6818A22DEC05B4DD41A9B586220A42", hash_generated_field = "7380F104304B5118624DAE9AD6B460C4")

    private String defaultEncoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.435 -0400", hash_original_method = "0BFB3D2359EDBDC19A64BE4776F868C5", hash_generated_method = "41324A7FBB096AF5846EAE2932463266")
    public  XmlStreamReader(File file) throws IOException {
        this(new FileInputStream(file));
        addTaint(file.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.435 -0400", hash_original_method = "CCF5242DCBD71EEA1ABE8079B8405291", hash_generated_method = "E5503EEB4BB5B41EB6701421A0D0F5F1")
    public  XmlStreamReader(InputStream is) throws IOException {
        this(is, true);
        addTaint(is.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.435 -0400", hash_original_method = "D7947FA233878C6544C57437912F92F2", hash_generated_method = "DD631CB8E69DA291C1960856946E1A41")
    public  XmlStreamReader(InputStream is, boolean lenient) throws IOException {
        this(is, lenient, null);
        addTaint(is.getTaint());
        addTaint(lenient);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.436 -0400", hash_original_method = "5C48388612DBB8741549449AC63D1729", hash_generated_method = "95672CDBB60CC34C6E1E9502A8A1F51F")
    public  XmlStreamReader(InputStream is, boolean lenient, String defaultEncoding) throws IOException {
        this.defaultEncoding = defaultEncoding;
        BOMInputStream bom = new BOMInputStream(new BufferedInputStream(is, BUFFER_SIZE), false, BOMS);
        BOMInputStream pis = new BOMInputStream(bom, true, XML_GUESS_BYTES);
        this.encoding = doRawStream(bom, pis, lenient);
        this.reader = new InputStreamReader(pis, encoding);
        addTaint(is.getTaint());
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.436 -0400", hash_original_method = "82CEBF9DB72DF26FA989C8ED45B81C3F", hash_generated_method = "DF694AB6D00E0458AB676F776FD53EEF")
    public  XmlStreamReader(URL url) throws IOException {
        this(url.openConnection(), null);
        addTaint(url.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.436 -0400", hash_original_method = "6E809D2B5EA529301630C2D41F24024A", hash_generated_method = "44AD5F19EDBC51C24C52589B0BCE91A4")
    public  XmlStreamReader(URLConnection conn, String defaultEncoding) throws IOException {
        this.defaultEncoding = defaultEncoding;
        boolean lenient = true;
        String contentType = conn.getContentType();
        InputStream is = conn.getInputStream();
        BOMInputStream bom = new BOMInputStream(new BufferedInputStream(is, BUFFER_SIZE), false, BOMS);
        BOMInputStream pis = new BOMInputStream(bom, true, XML_GUESS_BYTES);
        {
            this.encoding = doHttpStream(bom, pis, contentType, lenient);
        } 
        {
            this.encoding = doRawStream(bom, pis, lenient);
        } 
        this.reader = new InputStreamReader(pis, encoding);
        addTaint(conn.getTaint());
        
        
        
        
        
        
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.437 -0400", hash_original_method = "648C41F575208FF436E3CD65D6AE1F65", hash_generated_method = "727D714F8D181A1D21315953B9989E0C")
    public  XmlStreamReader(InputStream is, String httpContentType) throws IOException {
        this(is, httpContentType, true);
        addTaint(is.getTaint());
        addTaint(httpContentType.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.437 -0400", hash_original_method = "F5BDC5C163DAC78E32A16CC3317DDC65", hash_generated_method = "7B21C6070B8076A9C300CCE99D82F799")
    public  XmlStreamReader(InputStream is, String httpContentType,
            boolean lenient, String defaultEncoding) throws IOException {
        this.defaultEncoding = defaultEncoding;
        BOMInputStream bom = new BOMInputStream(new BufferedInputStream(is, BUFFER_SIZE), false, BOMS);
        BOMInputStream pis = new BOMInputStream(bom, true, XML_GUESS_BYTES);
        this.encoding = doHttpStream(bom, pis, httpContentType, lenient);
        this.reader = new InputStreamReader(pis, encoding);
        addTaint(is.getTaint());
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.438 -0400", hash_original_method = "197DFCD51BDEB338A6D65B1B8F7F2862", hash_generated_method = "9AD7A5B4FA7A05024CEDBA4C2380FEF5")
    public  XmlStreamReader(InputStream is, String httpContentType,
            boolean lenient) throws IOException {
        this(is, httpContentType, lenient, null);
        addTaint(is.getTaint());
        addTaint(httpContentType.getTaint());
        addTaint(lenient);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.439 -0400", hash_original_method = "F443D1F05E85BC7B1454291BD7671BD0", hash_generated_method = "2D42FA2D03182FDF9036B4B88049D3B8")
    public String getDefaultEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1296131386 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1296131386 = defaultEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_1296131386.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1296131386;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.439 -0400", hash_original_method = "ECC6E581C26F132636CDCE9C9A5E5807", hash_generated_method = "3873AF688284E81BB4CF28453BE4BF2F")
    public String getEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1310510683 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1310510683 = encoding;
        varB4EAC82CA7396A68D541C85D26508E83_1310510683.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1310510683;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.440 -0400", hash_original_method = "36C1E95AD8A6DF443D7A292EAE48D897", hash_generated_method = "0FB5F3C2F9BAB4688F9A31A5FA93172A")
    @Override
    public int read(char[] buf, int offset, int len) throws IOException {
        int varE6208E871A644876F7A6FF91A8F8C1CC_1618202235 = (reader.read(buf, offset, len));
        addTaint(buf[0]);
        addTaint(offset);
        addTaint(len);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_709338127 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_709338127;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.440 -0400", hash_original_method = "A1FFC9B80BA56A6C1B0EFB45497D16D1", hash_generated_method = "B3E1029E376B5E0CFBFF8FD738B892BD")
    @Override
    public void close() throws IOException {
        reader.close();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.441 -0400", hash_original_method = "2A9E440FCF0AAE6B2EF64361426B6DDA", hash_generated_method = "5044E512D948F9F6C77FD6B1655915CC")
    private String doRawStream(BOMInputStream bom, BOMInputStream pis, boolean lenient) throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_1205871776 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1038356510 = null; 
        String bomEnc = bom.getBOMCharsetName();
        String xmlGuessEnc = pis.getBOMCharsetName();
        String xmlEnc = getXmlProlog(pis, xmlGuessEnc);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1205871776 = calculateRawEncoding(bomEnc, xmlGuessEnc, xmlEnc);
        } 
        catch (XmlStreamReaderException ex)
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1038356510 = doLenientDetection(null, ex);
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw ex;
            } 
        } 
        addTaint(bom.getTaint());
        addTaint(pis.getTaint());
        addTaint(lenient);
        String varA7E53CE21691AB073D9660D615818899_1448159960; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1448159960 = varB4EAC82CA7396A68D541C85D26508E83_1205871776;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1448159960 = varB4EAC82CA7396A68D541C85D26508E83_1038356510;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1448159960.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1448159960;
        
        
        
        
        
            
        
            
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.441 -0400", hash_original_method = "58151B4DA62D82E62869FF632AE48FF5", hash_generated_method = "074E731C7D1599DBAE7AAC30A344BF3F")
    private String doHttpStream(BOMInputStream bom, BOMInputStream pis, String httpContentType,
            boolean lenient) throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_233425179 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1732768436 = null; 
        String bomEnc = bom.getBOMCharsetName();
        String xmlGuessEnc = pis.getBOMCharsetName();
        String xmlEnc = getXmlProlog(pis, xmlGuessEnc);
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_233425179 = calculateHttpEncoding(httpContentType, bomEnc,
                    xmlGuessEnc, xmlEnc, lenient);
        } 
        catch (XmlStreamReaderException ex)
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1732768436 = doLenientDetection(httpContentType, ex);
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw ex;
            } 
        } 
        addTaint(bom.getTaint());
        addTaint(pis.getTaint());
        addTaint(httpContentType.getTaint());
        addTaint(lenient);
        String varA7E53CE21691AB073D9660D615818899_1487119754; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1487119754 = varB4EAC82CA7396A68D541C85D26508E83_233425179;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1487119754 = varB4EAC82CA7396A68D541C85D26508E83_1732768436;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1487119754.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1487119754;
        
        
        
        
        
            
                    
        
            
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.442 -0400", hash_original_method = "68E74736656E5A93054BE7DF7FDFC9F5", hash_generated_method = "5E89BF90D08C28CAB0DEEC87060D60A7")
    private String doLenientDetection(String httpContentType,
            XmlStreamReaderException ex) throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_1693643197 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1738404103 = null; 
        {
            boolean varADC12483E48F090449D7F503883EB5FD_1000353939 = (httpContentType != null && httpContentType.startsWith("text/html"));
            {
                httpContentType = httpContentType.substring("text/html".length());
                httpContentType = "text/xml" + httpContentType;
                try 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1693643197 = calculateHttpEncoding(httpContentType, ex.getBomEncoding(),
                        ex.getXmlGuessEncoding(), ex.getXmlEncoding(), true);
                } 
                catch (XmlStreamReaderException ex2)
                {
                    ex = ex2;
                } 
            } 
        } 
        String encoding = ex.getXmlEncoding();
        {
            encoding = ex.getContentTypeEncoding();
        } 
        {
            encoding = defaultEncoding == null ? UTF_8 : defaultEncoding;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1738404103 = encoding;
        addTaint(httpContentType.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1583537920; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1583537920 = varB4EAC82CA7396A68D541C85D26508E83_1693643197;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1583537920 = varB4EAC82CA7396A68D541C85D26508E83_1738404103;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1583537920.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1583537920;
        
        
            
            
            
                
                        
            
                
            
        
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.444 -0400", hash_original_method = "598A080C11FF68E733FEC8702F091B2A", hash_generated_method = "5F55A06B0A1FEB85E43D7AB714B0BB21")
     String calculateRawEncoding(String bomEnc, String xmlGuessEnc,
            String xmlEnc) throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_1160970339 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_164904718 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_577798875 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_166929682 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_729748047 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1756546362 = null; 
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1160970339 = defaultEncoding == null ? UTF_8 : defaultEncoding;
            } 
            {
                boolean varD72E639AC4AA6EF933351F21134C75F3_169981857 = (xmlEnc.equals(UTF_16) &&
               (xmlGuessEnc.equals(UTF_16BE) || xmlGuessEnc.equals(UTF_16LE)));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_164904718 = xmlGuessEnc;
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_577798875 = xmlEnc;
        } 
        {
            boolean var05D4235A5AAB64E1B9E697B33C4708A3_369627692 = (bomEnc.equals(UTF_8));
            {
                {
                    boolean var62524306C0F31023C39194E845ABF38F_371390487 = (xmlGuessEnc != null && !xmlGuessEnc.equals(UTF_8));
                    {
                        String msg = MessageFormat.format(RAW_EX_1, new Object[] { bomEnc, xmlGuessEnc, xmlEnc });
                        if (DroidSafeAndroidRuntime.control) throw new XmlStreamReaderException(msg, bomEnc, xmlGuessEnc, xmlEnc);
                    } 
                } 
                {
                    boolean var337070B8C81CC48CA52092D74E98A2BA_1358762787 = (xmlEnc != null && !xmlEnc.equals(UTF_8));
                    {
                        String msg = MessageFormat.format(RAW_EX_1, new Object[] { bomEnc, xmlGuessEnc, xmlEnc });
                        if (DroidSafeAndroidRuntime.control) throw new XmlStreamReaderException(msg, bomEnc, xmlGuessEnc, xmlEnc);
                    } 
                } 
                varB4EAC82CA7396A68D541C85D26508E83_166929682 = bomEnc;
            } 
        } 
        {
            boolean var95C6B3606E306A883C5DAD27B2011DC1_1416414553 = (bomEnc.equals(UTF_16BE) || bomEnc.equals(UTF_16LE));
            {
                {
                    boolean var6F26888B9BC93081AE7350D9D7FEAEC1_639280957 = (xmlGuessEnc != null && !xmlGuessEnc.equals(bomEnc));
                    {
                        String msg = MessageFormat.format(RAW_EX_1, new Object[] { bomEnc, xmlGuessEnc, xmlEnc });
                        if (DroidSafeAndroidRuntime.control) throw new XmlStreamReaderException(msg, bomEnc, xmlGuessEnc, xmlEnc);
                    } 
                } 
                {
                    boolean varE205CCAAD1CE92A671F2E030AFBF9C4B_876302473 = (xmlEnc != null && !xmlEnc.equals(UTF_16) && !xmlEnc.equals(bomEnc));
                    {
                        String msg = MessageFormat.format(RAW_EX_1, new Object[] { bomEnc, xmlGuessEnc, xmlEnc });
                        if (DroidSafeAndroidRuntime.control) throw new XmlStreamReaderException(msg, bomEnc, xmlGuessEnc, xmlEnc);
                    } 
                } 
                varB4EAC82CA7396A68D541C85D26508E83_729748047 = bomEnc;
            } 
        } 
        {
            boolean var5B4EFAC3FCA3ADDEFE671851D965B899_135296297 = (bomEnc.equals(UTF_32BE) || bomEnc.equals(UTF_32LE));
            {
                {
                    boolean var6F26888B9BC93081AE7350D9D7FEAEC1_142007910 = (xmlGuessEnc != null && !xmlGuessEnc.equals(bomEnc));
                    {
                        String msg = MessageFormat.format(RAW_EX_1, new Object[] { bomEnc, xmlGuessEnc, xmlEnc });
                        if (DroidSafeAndroidRuntime.control) throw new XmlStreamReaderException(msg, bomEnc, xmlGuessEnc, xmlEnc);
                    } 
                } 
                {
                    boolean varE4672F12009CFFB765D33593ECEA1058_415773054 = (xmlEnc != null && !xmlEnc.equals(UTF_32) && !xmlEnc.equals(bomEnc));
                    {
                        String msg = MessageFormat.format(RAW_EX_1, new Object[] { bomEnc, xmlGuessEnc, xmlEnc });
                        if (DroidSafeAndroidRuntime.control) throw new XmlStreamReaderException(msg, bomEnc, xmlGuessEnc, xmlEnc);
                    } 
                } 
                varB4EAC82CA7396A68D541C85D26508E83_1756546362 = bomEnc;
            } 
        } 
        String msg = MessageFormat.format(RAW_EX_2, new Object[] { bomEnc, xmlGuessEnc, xmlEnc });
        if (DroidSafeAndroidRuntime.control) throw new XmlStreamReaderException(msg, bomEnc, xmlGuessEnc, xmlEnc);
        addTaint(bomEnc.getTaint());
        addTaint(xmlGuessEnc.getTaint());
        addTaint(xmlEnc.getTaint());
        String varA7E53CE21691AB073D9660D615818899_2051776113; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2051776113 = varB4EAC82CA7396A68D541C85D26508E83_1160970339;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_2051776113 = varB4EAC82CA7396A68D541C85D26508E83_164904718;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_2051776113 = varB4EAC82CA7396A68D541C85D26508E83_577798875;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_2051776113 = varB4EAC82CA7396A68D541C85D26508E83_166929682;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_2051776113 = varB4EAC82CA7396A68D541C85D26508E83_729748047;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2051776113 = varB4EAC82CA7396A68D541C85D26508E83_1756546362;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2051776113.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2051776113;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.445 -0400", hash_original_method = "473EAA9BFD3853985435EE444206468A", hash_generated_method = "AC69316EF268E0B6DF5C6A8773BFBDC7")
     String calculateHttpEncoding(String httpContentType,
            String bomEnc, String xmlGuessEnc, String xmlEnc,
            boolean lenient) throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_1445836206 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1110478457 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_117853990 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_550856604 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_908510384 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_296496625 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1705908471 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_666329513 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1445836206 = xmlEnc;
        } 
        String cTMime = getContentTypeMime(httpContentType);
        String cTEnc = getContentTypeEncoding(httpContentType);
        boolean appXml = isAppXml(cTMime);
        boolean textXml = isTextXml(cTMime);
        {
            String msg = MessageFormat.format(HTTP_EX_3, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
            if (DroidSafeAndroidRuntime.control) throw new XmlStreamReaderException(msg, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
        } 
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1110478457 = calculateRawEncoding(bomEnc, xmlGuessEnc, xmlEnc);
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_117853990 = defaultEncoding == null ? US_ASCII : defaultEncoding;
            } 
        } 
        {
            boolean varA66ED870F91B3E206532F611AC081DC4_1679127383 = (cTEnc.equals(UTF_16BE) || cTEnc.equals(UTF_16LE));
            {
                {
                    String msg = MessageFormat.format(HTTP_EX_1, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
                    if (DroidSafeAndroidRuntime.control) throw new XmlStreamReaderException(msg, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
                } 
                varB4EAC82CA7396A68D541C85D26508E83_550856604 = cTEnc;
            } 
        } 
        {
            boolean varAD0794C12B61186D2901F9D6CE6CDBA0_1284070874 = (cTEnc.equals(UTF_16));
            {
                {
                    boolean var206F7FB41A85C55720A99BCA525A0222_1360810885 = (bomEnc != null && bomEnc.startsWith(UTF_16));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_908510384 = bomEnc;
                    } 
                } 
                String msg = MessageFormat.format(HTTP_EX_2, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
                if (DroidSafeAndroidRuntime.control) throw new XmlStreamReaderException(msg, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
            } 
        } 
        {
            boolean varA1FB0DF7C2C4A3058B94A15EEAC2F5BD_272644916 = (cTEnc.equals(UTF_32BE) || cTEnc.equals(UTF_32LE));
            {
                {
                    String msg = MessageFormat.format(HTTP_EX_1, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
                    if (DroidSafeAndroidRuntime.control) throw new XmlStreamReaderException(msg, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
                } 
                varB4EAC82CA7396A68D541C85D26508E83_296496625 = cTEnc;
            } 
        } 
        {
            boolean varDA94B5F3AFAF374AF5D7C303065796A9_388705640 = (cTEnc.equals(UTF_32));
            {
                {
                    boolean var1928AC4E0FFCF8A4AF1F5570C0051B8D_2022056509 = (bomEnc != null && bomEnc.startsWith(UTF_32));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1705908471 = bomEnc;
                    } 
                } 
                String msg = MessageFormat.format(HTTP_EX_2, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
                if (DroidSafeAndroidRuntime.control) throw new XmlStreamReaderException(msg, cTMime, cTEnc, bomEnc, xmlGuessEnc, xmlEnc);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_666329513 = cTEnc;
        addTaint(httpContentType.getTaint());
        addTaint(bomEnc.getTaint());
        addTaint(xmlGuessEnc.getTaint());
        addTaint(xmlEnc.getTaint());
        addTaint(lenient);
        String varA7E53CE21691AB073D9660D615818899_712770196; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_712770196 = varB4EAC82CA7396A68D541C85D26508E83_1445836206;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_712770196 = varB4EAC82CA7396A68D541C85D26508E83_1110478457;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_712770196 = varB4EAC82CA7396A68D541C85D26508E83_117853990;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_712770196 = varB4EAC82CA7396A68D541C85D26508E83_550856604;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_712770196 = varB4EAC82CA7396A68D541C85D26508E83_908510384;
                break;
            case 6: 
                varA7E53CE21691AB073D9660D615818899_712770196 = varB4EAC82CA7396A68D541C85D26508E83_296496625;
                break;
            case 7: 
                varA7E53CE21691AB073D9660D615818899_712770196 = varB4EAC82CA7396A68D541C85D26508E83_1705908471;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_712770196 = varB4EAC82CA7396A68D541C85D26508E83_666329513;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_712770196.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_712770196;
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    static boolean isAppXml(String mime) {
        return mime != null &&
               (mime.equals("application/xml") || 
                mime.equals("application/xml-dtd") ||
                mime.equals("application/xml-external-parsed-entity") ||
               mime.startsWith("application/") && mime.endsWith("+xml"));
    }

    
    @DSModeled(DSC.SAFE)
    static boolean isTextXml(String mime) {
        return mime != null &&
              (mime.equals("text/xml") ||
               mime.equals("text/xml-external-parsed-entity") ||
              mime.startsWith("text/") && mime.endsWith("+xml"));
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.447 -0400", hash_original_field = "2B07217CBE09429BD34768CAB6EB3687", hash_generated_field = "2D6932277766CC46C6A5DD6909FDCC5E")

    private static final int BUFFER_SIZE = 4096;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.447 -0400", hash_original_field = "923519EE0F5F6D2A4432D632B72D3636", hash_generated_field = "C8915AECAD93B0288C9E401509C4DC97")

    private static final String UTF_8 = "UTF-8";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.447 -0400", hash_original_field = "3366608D595FEC4D1002965F1D6B7A40", hash_generated_field = "A01FFAD120BAFBCC19A6B7C5143F201D")

    private static final String US_ASCII = "US-ASCII";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.447 -0400", hash_original_field = "063081C6B6338AA593B9BD7B1869D671", hash_generated_field = "E701533E6B02B7C236C9FAEDE9A2150C")

    private static final String UTF_16BE = "UTF-16BE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.447 -0400", hash_original_field = "2CB45C0D573BC3D13B29603F5683068C", hash_generated_field = "4205932278CFED46C32ECDD6D3406976")

    private static final String UTF_16LE = "UTF-16LE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.447 -0400", hash_original_field = "FCDE3D5EDC9A8E3C945CFF4CFE958F25", hash_generated_field = "8A030FA5B47049C6296A6C0C9C516C34")

    private static final String UTF_32BE = "UTF-32BE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.447 -0400", hash_original_field = "68423F9B0C3E3D103C69D8DA0AC8A30E", hash_generated_field = "49D8B86B8D54FAE3DA944F6508FA19B2")

    private static final String UTF_32LE = "UTF-32LE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.447 -0400", hash_original_field = "EE694B7D03608A3D6DED57D0864C1D7D", hash_generated_field = "7051634EA32B327445B8E2BB4F066F7D")

    private static final String UTF_16 = "UTF-16";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.447 -0400", hash_original_field = "B37FC3161667C9A58215DA11E351264B", hash_generated_field = "5437F39279BDC878DC8ACAFCAF96A46F")

    private static final String UTF_32 = "UTF-32";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.447 -0400", hash_original_field = "B5D8CB20D7ED7BB8C60D3A0790885F81", hash_generated_field = "5516F8607A7F101B59189B0A59ABC227")

    private static final String EBCDIC = "CP1047";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.447 -0400", hash_original_field = "BCF9C344BAD5BCA63743A9E7C00DAFDD", hash_generated_field = "FE04BF8F1F477166F38E2C68EF521413")

    private static final ByteOrderMark[] BOMS = new ByteOrderMark[] {
        ByteOrderMark.UTF_8,
        ByteOrderMark.UTF_16BE,
        ByteOrderMark.UTF_16LE,
        ByteOrderMark.UTF_32BE,
        ByteOrderMark.UTF_32LE
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.447 -0400", hash_original_field = "7262F6B46264CC81F2C9B0D461E5E765", hash_generated_field = "6303B29D1D3BBF1CC690B3723D4AC1A5")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.447 -0400", hash_original_field = "E93463F9AD4ABDB2BC1B5D54C5CDBCE4", hash_generated_field = "0705AF6236794B3774BD3D3DF175B9BB")

    private static final Pattern CHARSET_PATTERN = Pattern
            .compile("charset=[\"']?([.[^; \"']]*)[\"']?");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.448 -0400", hash_original_field = "162F6E8430AADCA87B9B59D662C33537", hash_generated_field = "DEFAFF066C62F1F078270AB77D86A366")

    public static final Pattern ENCODING_PATTERN = Pattern.compile(
            "<\\?xml.*encoding[\\s]*=[\\s]*((?:\".[^\"]*\")|(?:'.[^']*'))",
            Pattern.MULTILINE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.448 -0400", hash_original_field = "362A03DBB7926243A30FD51049410321", hash_generated_field = "35EBF43677D1D8478ABBAFCB40A12E69")

    private static final String RAW_EX_1 = "Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.448 -0400", hash_original_field = "92DE7A15249FEA6598F55FAF0E54E562", hash_generated_field = "24C2E2082AE939075F2AE9E126F5324F")

    private static final String RAW_EX_2 = "Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] unknown BOM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.448 -0400", hash_original_field = "6094B713482D3FA9DF0B9EF7EEBA8C48", hash_generated_field = "6E61DB8F27F7F53C3DDE60B2F26D297C")

    private static final String HTTP_EX_1 = "Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], BOM must be NULL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.448 -0400", hash_original_field = "8DE76BF9FB9A94A77AF152AA598C2D92", hash_generated_field = "AA7C5E28C91FEB5082829DEA29E4E014")

    private static final String HTTP_EX_2 = "Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], encoding mismatch";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:32.448 -0400", hash_original_field = "F0151DE2D936369B97F9D97A85304A23", hash_generated_field = "61A10800F6134B0D772DFD5EAE17C60E")

    private static final String HTTP_EX_3 = "Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], Invalid MIME";
}

