package org.apache.commons.io.output;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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

public class XmlStreamWriter extends Writer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.616 -0400", hash_original_field = "C68271A63DDBC431C307BEB7D2918275", hash_generated_field = "FAC7CE5410064D378AF9E7B2309C5BE9")

    private OutputStream out;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.620 -0400", hash_original_field = "2E6818A22DEC05B4DD41A9B586220A42", hash_generated_field = "7380F104304B5118624DAE9AD6B460C4")

    private String defaultEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.620 -0400", hash_original_field = "AA7F80165C079ADF57A3569621F249A9", hash_generated_field = "3B0F841FF7E21C2FBFE8FB4592CC4284")

    private StringWriter xmlPrologWriter = new StringWriter(BUFFER_SIZE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.620 -0400", hash_original_field = "A82FEEE3CC1AF8BCABDA979E8775EF0F", hash_generated_field = "DB075F4140D7FA00980C54A40F997F59")

    private Writer writer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.621 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "AA03A19AA54A465901EEA798BB232EAE")

    private String encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.621 -0400", hash_original_method = "1F07F2996D4303D16171195260C51826", hash_generated_method = "14A9326B322AE22E42390B51E266C695")
    public  XmlStreamWriter(OutputStream out) {
        this(out, null);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.629 -0400", hash_original_method = "0133DB5409861AC1C5AE03D509257B31", hash_generated_method = "75841183AF2B3EDA71DCC4F694CA00E4")
    public  XmlStreamWriter(OutputStream out, String defaultEncoding) {
        this.out = out;
        this.defaultEncoding = defaultEncoding != null ? defaultEncoding : "UTF-8";
        // ---------- Original Method ----------
        //this.out = out;
        //this.defaultEncoding = defaultEncoding != null ? defaultEncoding : "UTF-8";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.629 -0400", hash_original_method = "50002FAC0CC159EBEC26C7D3BEE7C633", hash_generated_method = "003FB404A13B2CE413943B60312FDA43")
    public  XmlStreamWriter(File file) throws FileNotFoundException {
        this(file, null);
        addTaint(file.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.630 -0400", hash_original_method = "AA99CD590672754F26A4EEAA3056CABB", hash_generated_method = "253CCA8EEA0AB3465F107E59422FB41A")
    public  XmlStreamWriter(File file, String defaultEncoding) throws FileNotFoundException {
        this(new FileOutputStream(file), defaultEncoding);
        addTaint(file.getTaint());
        addTaint(defaultEncoding.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.630 -0400", hash_original_method = "ECC6E581C26F132636CDCE9C9A5E5807", hash_generated_method = "D55E49CA7F490FABF485F3F4ED01F7DF")
    public String getEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1120634302 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1120634302 = encoding;
        varB4EAC82CA7396A68D541C85D26508E83_1120634302.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1120634302;
        // ---------- Original Method ----------
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.631 -0400", hash_original_method = "F443D1F05E85BC7B1454291BD7671BD0", hash_generated_method = "E803D40778493AC23E8DED3725001386")
    public String getDefaultEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1053909600 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1053909600 = defaultEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_1053909600.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1053909600;
        // ---------- Original Method ----------
        //return defaultEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.631 -0400", hash_original_method = "FA1D85D28CEAB4A4964615D0CD6BE099", hash_generated_method = "03962F4131E01C5529A0AA392200B1E0")
    @Override
    public void close() throws IOException {
        {
            encoding = defaultEncoding;
            writer = new OutputStreamWriter(out, encoding);
            writer.write(xmlPrologWriter.toString());
        } //End block
        writer.close();
        // ---------- Original Method ----------
        //if (writer == null) {
            //encoding = defaultEncoding;
            //writer = new OutputStreamWriter(out, encoding);
            //writer.write(xmlPrologWriter.toString());
        //}
        //writer.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.631 -0400", hash_original_method = "1CF6DC5DA7BB65AAE6632CB394BB4ED7", hash_generated_method = "398F8A52357FFC35C6508A83FB165B25")
    @Override
    public void flush() throws IOException {
        {
            writer.flush();
        } //End block
        // ---------- Original Method ----------
        //if (writer != null) {
            //writer.flush();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.644 -0400", hash_original_method = "5F0F76B2AEC559A82852132C77730119", hash_generated_method = "293C4BEB008570661A2148AA5372A290")
    private void detectEncoding(char[] cbuf, int off, int len) throws IOException {
        int size;
        size = len;
        StringBuffer xmlProlog;
        xmlProlog = xmlPrologWriter.getBuffer();
        {
            boolean varD9957D3FD4CB10228126C5F962847E92_1812657873 = (xmlProlog.length() + len > BUFFER_SIZE);
            {
                size = BUFFER_SIZE - xmlProlog.length();
            } //End block
        } //End collapsed parenthetic
        xmlPrologWriter.write(cbuf, off, size);
        {
            boolean varDF24240208512C3DF755D8EE557D0A72_1271902618 = (xmlProlog.length() >= 5);
            {
                {
                    boolean varA1ABE447723AE3CA0BBFA51ED018C4EE_1385448960 = (xmlProlog.substring(0, 5).equals("<?xml"));
                    {
                        int xmlPrologEnd;
                        xmlPrologEnd = xmlProlog.indexOf("?>");
                        {
                            Matcher m;
                            m = ENCODING_PATTERN.matcher(xmlProlog.substring(0,
                            xmlPrologEnd));
                            {
                                boolean var930BFA526DCF6357FE8249ED2F9A3630_175574107 = (m.find());
                                {
                                    encoding = m.group(1).toUpperCase();
                                    encoding = encoding.substring(1, encoding.length() - 1);
                                } //End block
                                {
                                    encoding = defaultEncoding;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            {
                                boolean var7E3F1E5C2978757E3C07EAB3109B998A_888905052 = (xmlProlog.length() >= BUFFER_SIZE);
                                {
                                    encoding = defaultEncoding;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                    {
                        encoding = defaultEncoding;
                    } //End block
                } //End collapsed parenthetic
                {
                    xmlPrologWriter = null;
                    writer = new OutputStreamWriter(out, encoding);
                    writer.write(xmlProlog.toString());
                    {
                        writer.write(cbuf, off + size, len - size);
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(cbuf[0]);
        addTaint(off);
        addTaint(len);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.645 -0400", hash_original_method = "C7BCA488F553457389C8980637630468", hash_generated_method = "F8E23E27BBBA26CB6130B1844D6AF095")
    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        {
            detectEncoding(cbuf, off, len);
        } //End block
        {
            writer.write(cbuf, off, len);
        } //End block
        addTaint(cbuf[0]);
        addTaint(off);
        addTaint(len);
        // ---------- Original Method ----------
        //if (xmlPrologWriter != null) {
            //detectEncoding(cbuf, off, len);
        //} else {
            //writer.write(cbuf, off, len);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.646 -0400", hash_original_field = "2B07217CBE09429BD34768CAB6EB3687", hash_generated_field = "C8F27ACB387136509673C7BF8F97DCB5")

    private static int BUFFER_SIZE = 4096;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.646 -0400", hash_original_field = "A4A1FFEDC51839AC7A96EA4A9CE18547", hash_generated_field = "B4D8FCD16C60DF30033816E7B0DD0931")

    static Pattern ENCODING_PATTERN = XmlStreamReader.ENCODING_PATTERN;
}

