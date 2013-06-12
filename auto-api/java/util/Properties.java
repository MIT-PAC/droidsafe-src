package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class Properties extends Hashtable<Object, Object> {
    private static final long serialVersionUID = 4112578634029874840L;
    private transient DocumentBuilder builder = null;
    private static final String PROP_DTD_NAME = "http://java.sun.com/dtd/properties.dtd";
    private static final String PROP_DTD = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
            + "    <!ELEMENT properties (comment?, entry*) >"
            + "    <!ATTLIST properties version CDATA #FIXED \"1.0\" >"
            + "    <!ELEMENT comment (#PCDATA) >"
            + "    <!ELEMENT entry (#PCDATA) >"
            + "    <!ATTLIST entry key CDATA #REQUIRED >";
    protected Properties defaults;
    private static final int NONE = 0, SLASH = 1, UNICODE = 2, CONTINUE = 3,
            KEY_DONE = 4, IGNORE = 5;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.804 -0400", hash_original_method = "15BC7402B615AC640D692CA8D591C86A", hash_generated_method = "1B6E54BF34A2555119858BCA495BD623")
    @DSModeled(DSC.SAFE)
    public Properties() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.804 -0400", hash_original_method = "5F2D706A0CAB1895C5A727D855C46322", hash_generated_method = "80C4031F8745A49D849F3F2E0C4623D4")
    @DSModeled(DSC.SAFE)
    public Properties(Properties properties) {
        dsTaint.addTaint(properties.dsTaint);
        // ---------- Original Method ----------
        //defaults = properties;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.805 -0400", hash_original_method = "8670FB32C289DA514C35A14528148A6D", hash_generated_method = "2BA60DBC8E7E3D697AC40A2BBD605C24")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void dumpString(StringBuilder buffer, String string, boolean key) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(string);
        dsTaint.addTaint(key);
        int i;
        i = 0;
        {
            boolean var34D0A0FAAC14922733F9F34BCB213788_263222167 = (!key && i < string.length() && string.charAt(i) == ' ');
            {
                buffer.append("\\ ");
                i++;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var729E5A733A8BA5CCFE0E0BA21DE6759C_1027654254 = (i < string.length());
            {
                char ch;
                ch = string.charAt(i);
                //Begin case '\t' 
                buffer.append("\\t");
                //End case '\t' 
                //Begin case '\n' 
                buffer.append("\\n");
                //End case '\n' 
                //Begin case '\f' 
                buffer.append("\\f");
                //End case '\f' 
                //Begin case '\r' 
                buffer.append("\\r");
                //End case '\r' 
                //Begin case default 
                {
                    boolean var5DFC28C43123261F22231B1072AE287F_496700530 = ("\\#!=:".indexOf(ch) >= 0 || (key && ch == ' '));
                    {
                        buffer.append('\\');
                    } //End block
                } //End collapsed parenthetic
                //End case default 
                //Begin case default 
                {
                    buffer.append(ch);
                } //End block
                {
                    String hex;
                    hex = Integer.toHexString(ch);
                    buffer.append("\\u");
                    {
                        int j;
                        j = 0;
                        boolean var370BB82D6D90CD983B3EBAA925D59283_457416336 = (j < 4 - hex.length());
                        {
                            buffer.append("0");
                        } //End block
                    } //End collapsed parenthetic
                    buffer.append(hex);
                } //End block
                //End case default 
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.805 -0400", hash_original_method = "B2B08C7B9AD3334D72416F92376E272C", hash_generated_method = "19A06D470260A056F61F13D8521EB77B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getProperty(String name) {
        dsTaint.addTaint(name);
        Object result;
        result = super.get(name);
        String property;
        property = (String) result;
        property = null;
        {
            property = defaults.getProperty(name);
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Object result = super.get(name);
        //String property = result instanceof String ? (String) result : null;
        //if (property == null && defaults != null) {
            //property = defaults.getProperty(name);
        //}
        //return property;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.805 -0400", hash_original_method = "3601550743DD7ED6E54F365D9B667C39", hash_generated_method = "43CD5016548A4F956F83BE626116A0E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getProperty(String name, String defaultValue) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue);
        Object result;
        result = super.get(name);
        String property;
        property = (String) result;
        property = null;
        {
            property = defaults.getProperty(name);
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Object result = super.get(name);
        //String property = result instanceof String ? (String) result : null;
        //if (property == null && defaults != null) {
            //property = defaults.getProperty(name);
        //}
        //if (property == null) {
            //return defaultValue;
        //}
        //return property;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.805 -0400", hash_original_method = "C9FDCBF4B35B89B1D79FB5B2779CDC77", hash_generated_method = "5F3A399311FF3935A928164D0EE58C22")
    @DSModeled(DSC.SAFE)
    public void list(PrintStream out) {
        dsTaint.addTaint(out.dsTaint);
        listToAppendable(out);
        // ---------- Original Method ----------
        //listToAppendable(out);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.805 -0400", hash_original_method = "2577CE734D2D6BD05EB3CE3808D03445", hash_generated_method = "80DB0F2035C7A6116F2CD391766D6DA0")
    @DSModeled(DSC.SAFE)
    public void list(PrintWriter out) {
        dsTaint.addTaint(out.dsTaint);
        listToAppendable(out);
        // ---------- Original Method ----------
        //listToAppendable(out);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.805 -0400", hash_original_method = "68CAE489B2B77D788FAF807067B604BA", hash_generated_method = "3769563959379C103023D3A408BFCD71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void listToAppendable(Appendable out) {
        dsTaint.addTaint(out.dsTaint);
        try 
        {
        	if (DroidSafeAndroidRuntime.control) {
                throw new NullPointerException("out == null");
            } //End block
            StringBuilder sb;
            sb = new StringBuilder(80);
            Enumeration<?> keys;
            keys = propertyNames();
            {
                boolean var50D6288C676B93E5C0384206AD0778B6_1283434075 = (keys.hasMoreElements());
                {
                    String key;
                    key = (String) keys.nextElement();
                    sb.append(key);
                    sb.append('=');
                    String property;
                    property = (String) super.get(key);
                    Properties def;
                    def = defaults;
                    {
                        property = (String) def.get(key);
                        def = def.defaults;
                    } //End block
                    {
                        boolean var8F62FE0E7F6AF45BBD78239662846E5F_110981358 = (property.length() > 40);
                        {
                            sb.append(property.substring(0, 37));
                            sb.append("...");
                        } //End block
                        {
                            sb.append(property);
                        } //End block
                    } //End collapsed parenthetic
                    sb.append(System.lineSeparator());
                    out.append(sb.toString());
                    sb.setLength(0);
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (IOException ex)
        {
            throw new AssertionError(ex);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.805 -0400", hash_original_method = "B8EDE929B09671D07A2F603EF776CD24", hash_generated_method = "C2868446C9D816F1260F8F36664FB5E3")
    @DSModeled(DSC.SAFE)
    public synchronized void load(InputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        if (DroidSafeAndroidRuntime.control) {
            throw new NullPointerException();
        } //End block
        load(new InputStreamReader(in, "ISO-8859-1"));
        // ---------- Original Method ----------
        //if (in == null) {
            //throw new NullPointerException();
        //}
        //load(new InputStreamReader(in, "ISO-8859-1"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.806 -0400", hash_original_method = "3CECE8DDCAF4401F719C3D407BA79CAE", hash_generated_method = "CCE7814D26C7DA232B9EE825ECCA2D16")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("fallthrough")
    public synchronized void load(Reader in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        if (DroidSafeAndroidRuntime.control) {
            throw new NullPointerException();
        } //End block
        int mode, unicode, count;
        mode = NONE;
        unicode = 0;
        count = 0;
        char nextChar, buf[];
        buf = new char[40];
        int offset, keyLength, intVal;
        offset = 0;
        keyLength = -1;
        boolean firstChar;
        firstChar = true;
        BufferedReader br;
        br = new BufferedReader(in);
        {
            intVal = br.read();
            nextChar = (char) intVal;
            {
                char[] newBuf;
                newBuf = new char[buf.length * 2];
                System.arraycopy(buf, 0, newBuf, 0, offset);
                buf = newBuf;
            } //End block
            {
                int digit;
                digit = Character.digit(nextChar, 16);
                {
                    unicode = (unicode << 4) + digit;
                } //End block
                if (DroidSafeAndroidRuntime.control) {
                    throw new IllegalArgumentException("Invalid Unicode sequence: illegal character");
                } //End block
                mode = NONE;
                buf[offset++] = (char) unicode;
            } //End block
            {
                mode = NONE;
                //Begin case '\r' 
                mode = CONTINUE;
                //End case '\r' 
                //Begin case '\n' 
                mode = IGNORE;
                //End case '\n' 
                //Begin case 'b' 
                nextChar = '\b';
                //End case 'b' 
                //Begin case 'f' 
                nextChar = '\f';
                //End case 'f' 
                //Begin case 'n' 
                nextChar = '\n';
                //End case 'n' 
                //Begin case 'r' 
                nextChar = '\r';
                //End case 'r' 
                //Begin case 't' 
                nextChar = '\t';
                //End case 't' 
                //Begin case 'u' 
                mode = UNICODE;
                //End case 'u' 
                //Begin case 'u' 
                unicode = count = 0;
                //End case 'u' 
            } //End block
            {
                //Begin case '#' '!' 
                {
                    {
                        intVal = br.read();
                        nextChar = (char) intVal;
                    } //End block
                } //End block
                //End case '#' '!' 
                //Begin case '\n' 
                {
                    mode = IGNORE;
                } //End block
                //End case '\n' 
                //Begin case '\r' 
                mode = NONE;
                //End case '\r' 
                //Begin case '\r' 
                firstChar = true;
                //End case '\r' 
                //Begin case '\r' 
                {
                    {
                        keyLength = offset;
                    } //End block
                    String temp;
                    temp = new String(buf, 0, offset);
                    put(temp.substring(0, keyLength), temp
                                .substring(keyLength));
                } //End block
                //End case '\r' 
                //Begin case '\r' 
                keyLength = -1;
                //End case '\r' 
                //Begin case '\r' 
                offset = 0;
                //End case '\r' 
                //Begin case '\\' 
                {
                    keyLength = offset;
                } //End block
                //End case '\\' 
                //Begin case '\\' 
                mode = SLASH;
                //End case '\\' 
                //Begin case ':' '=' 
                {
                    mode = NONE;
                    keyLength = offset;
                } //End block
                //End case ':' '=' 
                {
                    boolean var1ED420F8964B295D71B68F4D48D8A3E6_1617349996 = (Character.isWhitespace(nextChar));
                    {
                        {
                            mode = IGNORE;
                        } //End block
                        {
                            mode = KEY_DONE;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                {
                    mode = NONE;
                } //End block
            } //End block
            firstChar = false;
            {
                keyLength = offset;
                mode = NONE;
            } //End block
            buf[offset++] = nextChar;
        } //End block
        if (DroidSafeAndroidRuntime.control) {
            throw new IllegalArgumentException("Invalid Unicode sequence: expected format \\uxxxx");
        } //End block
        {
            keyLength = offset;
        } //End block
        {
            String temp;
            temp = new String(buf, 0, offset);
            String key;
            key = temp.substring(0, keyLength);
            String value;
            value = temp.substring(keyLength);
            {
                value += "\u0000";
            } //End block
            put(key, value);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.806 -0400", hash_original_method = "1BF2C237B8DD3958FB1B8B5C0AE1938E", hash_generated_method = "4F1D94B109C54AAC0B466E5D92910D66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Enumeration<?> propertyNames() {
        Hashtable<Object, Object> selected;
        selected = new Hashtable<Object, Object>();
        selectProperties(selected, false);
        Enumeration<?> var28ABE3DBB5AE8A37862D04643A91343E_979053521 = (selected.keys());
        return (Enumeration<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Hashtable<Object, Object> selected = new Hashtable<Object, Object>();
        //selectProperties(selected, false);
        //return selected.keys();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.806 -0400", hash_original_method = "3F48821B050A70D7E4FF424CB7AEEF4F", hash_generated_method = "0CFDE7FC27A8BCD284EA2C4B44ECCC85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<String> stringPropertyNames() {
        Hashtable<String, Object> stringProperties;
        stringProperties = new Hashtable<String, Object>();
        selectProperties(stringProperties, true);
        Set<String> varBED74A0AE226998015CF403B132781D6_628994957 = (Collections.unmodifiableSet(stringProperties.keySet()));
        return (Set<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Hashtable<String, Object> stringProperties = new Hashtable<String, Object>();
        //selectProperties(stringProperties, true);
        //return Collections.unmodifiableSet(stringProperties.keySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.807 -0400", hash_original_method = "A87BE62C7A489C0C3750546357B411C0", hash_generated_method = "8532634057A6E9EA1EB7E3FA87BCE3B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private <K> void selectProperties(Hashtable<K, Object> selectProperties, final boolean isStringOnly) {
        dsTaint.addTaint(isStringOnly);
        dsTaint.addTaint(selectProperties.dsTaint);
        {
            defaults.selectProperties(selectProperties, isStringOnly);
        } //End block
        Enumeration<Object> keys;
        keys = keys();
        {
            boolean var92FA05435258CA7C805716F7AD9C73B4_1727203832 = (keys.hasMoreElements());
            {
                @SuppressWarnings("unchecked") K key;
                key = (K) keys.nextElement();
                Object value;
                value = get(key);
                selectProperties.put(key, value);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (defaults != null) {
            //defaults.selectProperties(selectProperties, isStringOnly);
        //}
        //Enumeration<Object> keys = keys();
        //while (keys.hasMoreElements()) {
            //@SuppressWarnings("unchecked")
            //K key = (K) keys.nextElement();
            //if (isStringOnly && !(key instanceof String)) {
                //continue;
            //}
            //Object value = get(key);
            //selectProperties.put(key, value);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.807 -0400", hash_original_method = "4460892848C3864FEFFB544B0F6CDF7A", hash_generated_method = "6A0764FBB8A277F886EA7EA0EEF08102")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void save(OutputStream out, String comment) {
        dsTaint.addTaint(comment);
        dsTaint.addTaint(out.dsTaint);
        try 
        {
            store(out, comment);
        } //End block
        catch (IOException e)
        { }
        // ---------- Original Method ----------
        //try {
            //store(out, comment);
        //} catch (IOException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.807 -0400", hash_original_method = "B5A66BBC4F63569C92BD357B6A0BCEAB", hash_generated_method = "F090C19B2A57E34A3CC0BC6ECC7C9975")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object setProperty(String name, String value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        Object var941E67453FF51A43FE5EC92D5E498D61_1308242552 = (put(name, value));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return put(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.807 -0400", hash_original_method = "97010F07EC41CFBEB746B7A1A80A2C1A", hash_generated_method = "F2DD9E07D361AC93DA30372F7B48463F")
    @DSModeled(DSC.SAFE)
    public synchronized void store(OutputStream out, String comment) throws IOException {
        dsTaint.addTaint(comment);
        dsTaint.addTaint(out.dsTaint);
        store(new OutputStreamWriter(out, "ISO-8859-1"), comment);
        // ---------- Original Method ----------
        //store(new OutputStreamWriter(out, "ISO-8859-1"), comment);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.807 -0400", hash_original_method = "8076CC1A9EBA7B35E4BEA25CCAC41B73", hash_generated_method = "3FD26B61DAD6354D5AA92DB1798837CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void store(Writer writer, String comment) throws IOException {
        dsTaint.addTaint(writer.dsTaint);
        dsTaint.addTaint(comment);
        {
            writer.write("#");
            writer.write(comment);
            writer.write(System.lineSeparator());
        } //End block
        writer.write("#");
        writer.write(new Date().toString());
        writer.write(System.lineSeparator());
        StringBuilder sb;
        sb = new StringBuilder(200);
        {
            Iterator<Map.Entry<Object, Object>> seatecAstronomy42 = entrySet().iterator();
            seatecAstronomy42.hasNext();
            Map.Entry<Object, Object> entry = seatecAstronomy42.next();
            {
                String key;
                key = (String) entry.getKey();
                dumpString(sb, key, true);
                sb.append('=');
                dumpString(sb, (String) entry.getValue(), false);
                sb.append(System.lineSeparator());
                writer.write(sb.toString());
                sb.setLength(0);
            } //End block
        } //End collapsed parenthetic
        writer.flush();
        // ---------- Original Method ----------
        //if (comment != null) {
            //writer.write("#");
            //writer.write(comment);
            //writer.write(System.lineSeparator());
        //}
        //writer.write("#");
        //writer.write(new Date().toString());
        //writer.write(System.lineSeparator());
        //StringBuilder sb = new StringBuilder(200);
        //for (Map.Entry<Object, Object> entry : entrySet()) {
            //String key = (String) entry.getKey();
            //dumpString(sb, key, true);
            //sb.append('=');
            //dumpString(sb, (String) entry.getValue(), false);
            //sb.append(System.lineSeparator());
            //writer.write(sb.toString());
            //sb.setLength(0);
        //}
        //writer.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.807 -0400", hash_original_method = "2CD21803BBD0B22DE3395585690DDBAE", hash_generated_method = "0E71DD30761E8BD931D56A84646B54A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void loadFromXML(InputStream in) throws IOException,
            InvalidPropertiesFormatException {
        dsTaint.addTaint(in.dsTaint);
        if (DroidSafeAndroidRuntime.control) {
            throw new NullPointerException();
        } //End block
        {
            DocumentBuilderFactory factory;
            factory = DocumentBuilderFactory.newInstance();
            try 
            {
                builder = factory.newDocumentBuilder();
            } //End block
            catch (ParserConfigurationException e)
            {
                throw new Error(e);
            } //End block
            builder.setErrorHandler(new ErrorHandler() {
                public void warning(SAXParseException e) throws SAXException {
                    throw e;
                }
                public void error(SAXParseException e) throws SAXException {
                    throw e;
                }
                public void fatalError(SAXParseException e) throws SAXException {
                    throw e;
                }
            });
            builder.setEntityResolver(new EntityResolver() {
                public InputSource resolveEntity(String publicId,
                        String systemId) throws SAXException, IOException {
                    if (systemId.equals(PROP_DTD_NAME)) {
                        InputSource result = new InputSource(new StringReader(
                                PROP_DTD));
                        result.setSystemId(PROP_DTD_NAME);
                        return result;
                    }
                    throw new SAXException("Invalid DOCTYPE declaration: "
                            + systemId);
                }
            });
        } //End block
        try 
        {
            Document doc;
            doc = builder.parse(in);
            NodeList entries;
            entries = doc.getElementsByTagName("entry");
            int entriesListLength;
            entriesListLength = entries.getLength();
            {
                int i;
                i = 0;
                {
                    Element entry;
                    entry = (Element) entries.item(i);
                    String key;
                    key = entry.getAttribute("key");
                    String value;
                    value = entry.getTextContent();
                    put(key, value);
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (IOException e)
        {
            throw e;
        } //End block
        catch (SAXException e)
        {
            throw new InvalidPropertiesFormatException(e);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.807 -0400", hash_original_method = "CF08828D5EA0BDD9B2ACD5D46AA8D14C", hash_generated_method = "F018D3521AEA8F405C19F0732B59A456")
    @DSModeled(DSC.SAFE)
    public void storeToXML(OutputStream os, String comment) throws IOException {
        dsTaint.addTaint(os.dsTaint);
        dsTaint.addTaint(comment);
        storeToXML(os, comment, "UTF-8");
        // ---------- Original Method ----------
        //storeToXML(os, comment, "UTF-8");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.808 -0400", hash_original_method = "88C35F171CF08E9C818A3957B761A932", hash_generated_method = "7DD1A14F6C8D89AB968746EF0ADC89F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void storeToXML(OutputStream os, String comment,
            String encoding) throws IOException {
        dsTaint.addTaint(os.dsTaint);
        dsTaint.addTaint(encoding);
        dsTaint.addTaint(comment);
        if (DroidSafeAndroidRuntime.control) {
            throw new NullPointerException();
        } //End block
        String encodingCanonicalName;
        try 
        {
            encodingCanonicalName = Charset.forName(encoding).name();
        } //End block
        catch (IllegalCharsetNameException e)
        {
            System.out.println("Warning: encoding name " + encoding
                    + " is illegal, using UTF-8 as default encoding");
            encodingCanonicalName = "UTF-8";
        } //End block
        catch (UnsupportedCharsetException e)
        {
            System.out.println("Warning: encoding " + encoding
                    + " is not supported, using UTF-8 as default encoding");
            encodingCanonicalName = "UTF-8";
        } //End block
        PrintStream printStream;
        printStream = new PrintStream(os, false,
                encodingCanonicalName);
        printStream.print("<?xml version=\"1.0\" encoding=\"");
        printStream.print(encodingCanonicalName);
        printStream.println("\"?>");
        printStream.print("<!DOCTYPE properties SYSTEM \"");
        printStream.print(PROP_DTD_NAME);
        printStream.println("\">");
        printStream.println("<properties>");
        {
            printStream.print("<comment>");
            printStream.print(substitutePredefinedEntries(comment));
            printStream.println("</comment>");
        } //End block
        {
            Iterator<Map.Entry<Object, Object>> seatecAstronomy42 = entrySet().iterator();
            seatecAstronomy42.hasNext();
            Map.Entry<Object, Object> entry = seatecAstronomy42.next();
            {
                String keyValue;
                keyValue = (String) entry.getKey();
                String entryValue;
                entryValue = (String) entry.getValue();
                printStream.print("<entry key=\"");
                printStream.print(substitutePredefinedEntries(keyValue));
                printStream.print("\">");
                printStream.print(substitutePredefinedEntries(entryValue));
                printStream.println("</entry>");
            } //End block
        } //End collapsed parenthetic
        printStream.println("</properties>");
        printStream.flush();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.808 -0400", hash_original_method = "C245FBB3FF946795FFB47FE71F12C3B1", hash_generated_method = "81D2BE0F318CEF71D1D1CEB483850740")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String substitutePredefinedEntries(String s) {
        dsTaint.addTaint(s);
        s = s.replaceAll("&", "&amp;");
        s = s.replaceAll("<", "&lt;");
        s = s.replaceAll(">", "&gt;");
        s = s.replaceAll("'", "&apos;");
        s = s.replaceAll("\"", "&quot;");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //s = s.replaceAll("&", "&amp;");
        //s = s.replaceAll("<", "&lt;");
        //s = s.replaceAll(">", "&gt;");
        //s = s.replaceAll("'", "&apos;");
        //s = s.replaceAll("\"", "&quot;");
        //return s;
    }

    
}


