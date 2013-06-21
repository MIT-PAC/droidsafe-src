package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private transient DocumentBuilder builder = null;
    protected Properties defaults;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.959 -0400", hash_original_method = "15BC7402B615AC640D692CA8D591C86A", hash_generated_method = "A0C8CF0DEBFCC799D900ACDC0026C561")
    @DSModeled(DSC.SAFE)
    public Properties() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.959 -0400", hash_original_method = "5F2D706A0CAB1895C5A727D855C46322", hash_generated_method = "2D66E38A0473B432E51A8CD924584E6B")
    @DSModeled(DSC.SAFE)
    public Properties(Properties properties) {
        dsTaint.addTaint(properties.dsTaint);
        // ---------- Original Method ----------
        //defaults = properties;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.960 -0400", hash_original_method = "8670FB32C289DA514C35A14528148A6D", hash_generated_method = "714F1E87E772C742BD782F4D7F9A4251")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void dumpString(StringBuilder buffer, String string, boolean key) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(string);
        dsTaint.addTaint(key);
        int i;
        i = 0;
        {
            boolean var34D0A0FAAC14922733F9F34BCB213788_590239517 = (!key && i < string.length() && string.charAt(i) == ' ');
            {
                buffer.append("\\ ");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var729E5A733A8BA5CCFE0E0BA21DE6759C_466812954 = (i < string.length());
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
                    boolean var5DFC28C43123261F22231B1072AE287F_1963833832 = ("\\#!=:".indexOf(ch) >= 0 || (key && ch == ' '));
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
                        boolean var370BB82D6D90CD983B3EBAA925D59283_1707250695 = (j < 4 - hex.length());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.960 -0400", hash_original_method = "B2B08C7B9AD3334D72416F92376E272C", hash_generated_method = "F57F18F6F3E04EB9BB1EDEAAC4B81489")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.960 -0400", hash_original_method = "3601550743DD7ED6E54F365D9B667C39", hash_generated_method = "9F91534365AE8277942793FB88C266E3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.961 -0400", hash_original_method = "C9FDCBF4B35B89B1D79FB5B2779CDC77", hash_generated_method = "D2B4F2C6C452A075BECC5374A934F30A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void list(PrintStream out) {
        dsTaint.addTaint(out.dsTaint);
        listToAppendable(out);
        // ---------- Original Method ----------
        //listToAppendable(out);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.961 -0400", hash_original_method = "2577CE734D2D6BD05EB3CE3808D03445", hash_generated_method = "553C0B5CE472A592A154FDD0C2FA66A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void list(PrintWriter out) {
        dsTaint.addTaint(out.dsTaint);
        listToAppendable(out);
        // ---------- Original Method ----------
        //listToAppendable(out);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.961 -0400", hash_original_method = "68CAE489B2B77D788FAF807067B604BA", hash_generated_method = "5AC46E36AD322637CDFFEEBF63D874E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void listToAppendable(Appendable out) {
        dsTaint.addTaint(out.dsTaint);
        try 
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("out == null");
            } //End block
            StringBuilder sb;
            sb = new StringBuilder(80);
            Enumeration<?> keys;
            keys = propertyNames();
            {
                boolean var50D6288C676B93E5C0384206AD0778B6_790567148 = (keys.hasMoreElements());
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
                        boolean var8F62FE0E7F6AF45BBD78239662846E5F_810786566 = (property.length() > 40);
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
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(ex);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.962 -0400", hash_original_method = "B8EDE929B09671D07A2F603EF776CD24", hash_generated_method = "BAD167DBA2BD365ED38C8EE224C21020")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void load(InputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        load(new InputStreamReader(in, "ISO-8859-1"));
        // ---------- Original Method ----------
        //if (in == null) {
            //throw new NullPointerException();
        //}
        //load(new InputStreamReader(in, "ISO-8859-1"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.963 -0400", hash_original_method = "3CECE8DDCAF4401F719C3D407BA79CAE", hash_generated_method = "D548E117A81F3CF11D0482390A38158E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("fallthrough")
    public synchronized void load(Reader in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
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
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid Unicode sequence: illegal character");
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
                    boolean var1ED420F8964B295D71B68F4D48D8A3E6_686403831 = (Character.isWhitespace(nextChar));
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
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid Unicode sequence: expected format \\uxxxx");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.963 -0400", hash_original_method = "1BF2C237B8DD3958FB1B8B5C0AE1938E", hash_generated_method = "F7CD35F4BB81E2AB2997EB051F6367F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Enumeration<?> propertyNames() {
        Hashtable<Object, Object> selected;
        selected = new Hashtable<Object, Object>();
        selectProperties(selected, false);
        Enumeration<?> var28ABE3DBB5AE8A37862D04643A91343E_1798029638 = (selected.keys());
        return (Enumeration<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Hashtable<Object, Object> selected = new Hashtable<Object, Object>();
        //selectProperties(selected, false);
        //return selected.keys();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.963 -0400", hash_original_method = "3F48821B050A70D7E4FF424CB7AEEF4F", hash_generated_method = "F30884F913D78E030C03F07FBC3FA05E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<String> stringPropertyNames() {
        Hashtable<String, Object> stringProperties;
        stringProperties = new Hashtable<String, Object>();
        selectProperties(stringProperties, true);
        Set<String> varBED74A0AE226998015CF403B132781D6_1648458054 = (Collections.unmodifiableSet(stringProperties.keySet()));
        return (Set<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Hashtable<String, Object> stringProperties = new Hashtable<String, Object>();
        //selectProperties(stringProperties, true);
        //return Collections.unmodifiableSet(stringProperties.keySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.964 -0400", hash_original_method = "A87BE62C7A489C0C3750546357B411C0", hash_generated_method = "619A11B80BEF28B75F9011704D1533CD")
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
            boolean var92FA05435258CA7C805716F7AD9C73B4_1030064607 = (keys.hasMoreElements());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.964 -0400", hash_original_method = "4460892848C3864FEFFB544B0F6CDF7A", hash_generated_method = "83A4442D0A7410F0166549843D84C275")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.964 -0400", hash_original_method = "B5A66BBC4F63569C92BD357B6A0BCEAB", hash_generated_method = "1CBCB12B146E11BA55BA360C98B0A968")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object setProperty(String name, String value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        Object var941E67453FF51A43FE5EC92D5E498D61_371302514 = (put(name, value));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return put(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.964 -0400", hash_original_method = "97010F07EC41CFBEB746B7A1A80A2C1A", hash_generated_method = "B5FE8AA6583BF0F3AAD212B0D2D4F1D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void store(OutputStream out, String comment) throws IOException {
        dsTaint.addTaint(comment);
        dsTaint.addTaint(out.dsTaint);
        store(new OutputStreamWriter(out, "ISO-8859-1"), comment);
        // ---------- Original Method ----------
        //store(new OutputStreamWriter(out, "ISO-8859-1"), comment);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.981 -0400", hash_original_method = "8076CC1A9EBA7B35E4BEA25CCAC41B73", hash_generated_method = "254D7E01C18EED79A34DD2C82BEEE45F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void store(Writer writer, String comment) throws IOException {
        dsTaint.addTaint(comment);
        dsTaint.addTaint(writer.dsTaint);
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
            Iterator<Map.Entry<Object, Object>> var0A82970C85229BA60CD383C8AED7D8CF_1280112461 = (entrySet()).iterator();
            var0A82970C85229BA60CD383C8AED7D8CF_1280112461.hasNext();
            Map.Entry<Object, Object> entry = var0A82970C85229BA60CD383C8AED7D8CF_1280112461.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.983 -0400", hash_original_method = "2CD21803BBD0B22DE3395585690DDBAE", hash_generated_method = "650441BDBF5F663E102935D9BA79E853")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void loadFromXML(InputStream in) throws IOException,
            InvalidPropertiesFormatException {
        dsTaint.addTaint(in.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
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
                if (DroidSafeAndroidRuntime.control) throw new Error(e);
            } //End block
            builder.setErrorHandler(new ErrorHandler() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.981 -0400", hash_original_method = "A780B405018C6E806DD90859BE935681", hash_generated_method = "05E81241878403E3A0A5F335C3A3AA1A")
                @DSModeled(DSC.SAFE)
                public void warning(SAXParseException e) throws SAXException {
                    dsTaint.addTaint(e.dsTaint);
                    if (DroidSafeAndroidRuntime.control) throw e;
                    // ---------- Original Method ----------
                    //throw e;
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.982 -0400", hash_original_method = "1BA627FA566198BCA8957A882673AC06", hash_generated_method = "E78633AB443AEE48B230ADA1D5A2FF6D")
                @DSModeled(DSC.SAFE)
                public void error(SAXParseException e) throws SAXException {
                    dsTaint.addTaint(e.dsTaint);
                    if (DroidSafeAndroidRuntime.control) throw e;
                    // ---------- Original Method ----------
                    //throw e;
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.982 -0400", hash_original_method = "3CBD306431C0846BE7A7FBEF3B9920DA", hash_generated_method = "E7292EEA63660D5A22AF9DD17EF2B8F6")
                @DSModeled(DSC.SAFE)
                public void fatalError(SAXParseException e) throws SAXException {
                    dsTaint.addTaint(e.dsTaint);
                    if (DroidSafeAndroidRuntime.control) throw e;
                    // ---------- Original Method ----------
                    //throw e;
                }
});
            builder.setEntityResolver(new EntityResolver() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.982 -0400", hash_original_method = "7B6D510D74072B007F41B0B5792E868F", hash_generated_method = "0D131FB7B529961C6DF91D7B47E46232")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                public InputSource resolveEntity(String publicId,
                        String systemId) throws SAXException, IOException {
                    dsTaint.addTaint(publicId);
                    dsTaint.addTaint(systemId);
                    {
                        boolean var291D64E633F0D753C1FE55CB540F0B0D_1147628490 = (systemId.equals(PROP_DTD_NAME));
                        {
                            InputSource result;
                            result = new InputSource(new StringReader(
                                PROP_DTD));
                            result.setSystemId(PROP_DTD_NAME);
                        } //End block
                    } //End collapsed parenthetic
                    if (DroidSafeAndroidRuntime.control) throw new SAXException("Invalid DOCTYPE declaration: "
                            + systemId);
                    return (InputSource)dsTaint.getTaint();
                    // ---------- Original Method ----------
                    //if (systemId.equals(PROP_DTD_NAME)) {
                        //InputSource result = new InputSource(new StringReader(
                                //PROP_DTD));
                        //result.setSystemId(PROP_DTD_NAME);
                        //return result;
                    //}
                    //throw new SAXException("Invalid DOCTYPE declaration: "
                            //+ systemId);
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
            if (DroidSafeAndroidRuntime.control) throw e;
        } //End block
        catch (SAXException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidPropertiesFormatException(e);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.984 -0400", hash_original_method = "CF08828D5EA0BDD9B2ACD5D46AA8D14C", hash_generated_method = "2396E4CD5019D867306CC0599DD2F835")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void storeToXML(OutputStream os, String comment) throws IOException {
        dsTaint.addTaint(os.dsTaint);
        dsTaint.addTaint(comment);
        storeToXML(os, comment, "UTF-8");
        // ---------- Original Method ----------
        //storeToXML(os, comment, "UTF-8");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.026 -0400", hash_original_method = "88C35F171CF08E9C818A3957B761A932", hash_generated_method = "8DB0870AD5BF2AFCB6BAFBB77728D924")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void storeToXML(OutputStream os, String comment,
            String encoding) throws IOException {
        dsTaint.addTaint(os.dsTaint);
        dsTaint.addTaint(encoding);
        dsTaint.addTaint(comment);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
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
            Iterator<Map.Entry<Object, Object>> var0A82970C85229BA60CD383C8AED7D8CF_2063482012 = (entrySet()).iterator();
            var0A82970C85229BA60CD383C8AED7D8CF_2063482012.hasNext();
            Map.Entry<Object, Object> entry = var0A82970C85229BA60CD383C8AED7D8CF_2063482012.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.026 -0400", hash_original_method = "C245FBB3FF946795FFB47FE71F12C3B1", hash_generated_method = "12EE7100F2D5C301CC4EA303664628EE")
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

    
    private static final long serialVersionUID = 4112578634029874840L;
    private static final String PROP_DTD_NAME = "http://java.sun.com/dtd/properties.dtd";
    private static final String PROP_DTD = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
            + "    <!ELEMENT properties (comment?, entry*) >"
            + "    <!ATTLIST properties version CDATA #FIXED \"1.0\" >"
            + "    <!ELEMENT comment (#PCDATA) >"
            + "    <!ELEMENT entry (#PCDATA) >"
            + "    <!ATTLIST entry key CDATA #REQUIRED >";
    private static final int NONE = 0, SLASH = 1, UNICODE = 2, CONTINUE = 3,
            KEY_DONE = 4, IGNORE = 5;
}

