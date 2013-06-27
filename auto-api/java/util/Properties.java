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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.796 -0400", hash_original_field = "C968D5902105C7A38B74CBA2C954C7FE", hash_generated_field = "FD91B16F92409AD1E464978ACF6CCD28")

    private transient DocumentBuilder builder = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.796 -0400", hash_original_field = "A4A918A45181164207929D52AEC36AEC", hash_generated_field = "FFB6C63B9AE394F9A7BA81EBAD128C5B")

    protected Properties defaults;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.796 -0400", hash_original_method = "15BC7402B615AC640D692CA8D591C86A", hash_generated_method = "A0C8CF0DEBFCC799D900ACDC0026C561")
    public  Properties() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.800 -0400", hash_original_method = "5F2D706A0CAB1895C5A727D855C46322", hash_generated_method = "DDFB4D46DBC5C7586044047CB8719A59")
    public  Properties(Properties properties) {
        defaults = properties;
        // ---------- Original Method ----------
        //defaults = properties;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.802 -0400", hash_original_method = "8670FB32C289DA514C35A14528148A6D", hash_generated_method = "229FA25CABC4E976C9DAC6B0BFE35CEF")
    private void dumpString(StringBuilder buffer, String string, boolean key) {
        int i;
        i = 0;
        {
            boolean var34D0A0FAAC14922733F9F34BCB213788_921297213 = (!key && i < string.length() && string.charAt(i) == ' ');
            {
                buffer.append("\\ ");
            } //End block
        } //End collapsed parenthetic
        {
            boolean var729E5A733A8BA5CCFE0E0BA21DE6759C_1180384028 = (i < string.length());
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
                    boolean var5DFC28C43123261F22231B1072AE287F_599659605 = ("\\#!=:".indexOf(ch) >= 0 || (key && ch == ' '));
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
                        boolean var370BB82D6D90CD983B3EBAA925D59283_1036745259 = (j < 4 - hex.length());
                        {
                            buffer.append("0");
                        } //End block
                    } //End collapsed parenthetic
                    buffer.append(hex);
                } //End block
                //End case default 
            } //End block
        } //End collapsed parenthetic
        addTaint(buffer.getTaint());
        addTaint(string.getTaint());
        addTaint(key);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.813 -0400", hash_original_method = "B2B08C7B9AD3334D72416F92376E272C", hash_generated_method = "906DA78578E4B1A50E010C76D33574D1")
    public String getProperty(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_1930618380 = null; //Variable for return #1
        Object result;
        result = super.get(name);
        String property;
        property = (String) result;
        property = null;
        {
            property = defaults.getProperty(name);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1930618380 = property;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1930618380.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1930618380;
        // ---------- Original Method ----------
        //Object result = super.get(name);
        //String property = result instanceof String ? (String) result : null;
        //if (property == null && defaults != null) {
            //property = defaults.getProperty(name);
        //}
        //return property;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.827 -0400", hash_original_method = "3601550743DD7ED6E54F365D9B667C39", hash_generated_method = "4E24E96C7841635416D3C6C3483AF167")
    public String getProperty(String name, String defaultValue) {
        String varB4EAC82CA7396A68D541C85D26508E83_1935958220 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_657734627 = null; //Variable for return #2
        Object result;
        result = super.get(name);
        String property;
        property = (String) result;
        property = null;
        {
            property = defaults.getProperty(name);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1935958220 = defaultValue;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_657734627 = property;
        addTaint(name.getTaint());
        addTaint(defaultValue.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1869898696; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1869898696 = varB4EAC82CA7396A68D541C85D26508E83_1935958220;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1869898696 = varB4EAC82CA7396A68D541C85D26508E83_657734627;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1869898696.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1869898696;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.828 -0400", hash_original_method = "C9FDCBF4B35B89B1D79FB5B2779CDC77", hash_generated_method = "E21A44BBEA8464A2A99922CCCB34A5C3")
    public void list(PrintStream out) {
        listToAppendable(out);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //listToAppendable(out);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.828 -0400", hash_original_method = "2577CE734D2D6BD05EB3CE3808D03445", hash_generated_method = "6BEDFC494176E84B7E97255CBD826851")
    public void list(PrintWriter out) {
        listToAppendable(out);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //listToAppendable(out);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.829 -0400", hash_original_method = "68CAE489B2B77D788FAF807067B604BA", hash_generated_method = "DC7D2238008715F02DB195AD8944B767")
    private void listToAppendable(Appendable out) {
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
                boolean var50D6288C676B93E5C0384206AD0778B6_845309139 = (keys.hasMoreElements());
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
                        boolean var8F62FE0E7F6AF45BBD78239662846E5F_367475335 = (property.length() > 40);
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
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.842 -0400", hash_original_method = "B8EDE929B09671D07A2F603EF776CD24", hash_generated_method = "07933C07E7CA1068C0BB8CE619F3BD77")
    public synchronized void load(InputStream in) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        load(new InputStreamReader(in, "ISO-8859-1"));
        addTaint(in.getTaint());
        // ---------- Original Method ----------
        //if (in == null) {
            //throw new NullPointerException();
        //}
        //load(new InputStreamReader(in, "ISO-8859-1"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.845 -0400", hash_original_method = "3CECE8DDCAF4401F719C3D407BA79CAE", hash_generated_method = "8E934D02E1B4C4C53A02DDF3DF0B31E5")
    @SuppressWarnings("fallthrough")
    public synchronized void load(Reader in) throws IOException {
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
                    boolean var1ED420F8964B295D71B68F4D48D8A3E6_1368437590 = (Character.isWhitespace(nextChar));
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
        addTaint(in.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.846 -0400", hash_original_method = "1BF2C237B8DD3958FB1B8B5C0AE1938E", hash_generated_method = "4AE3FDC8A4E406F66DE759FBFCA8E535")
    public Enumeration<?> propertyNames() {
        Enumeration<?> varB4EAC82CA7396A68D541C85D26508E83_1885336809 = null; //Variable for return #1
        Hashtable<Object, Object> selected;
        selected = new Hashtable<Object, Object>();
        selectProperties(selected, false);
        varB4EAC82CA7396A68D541C85D26508E83_1885336809 = selected.keys();
        varB4EAC82CA7396A68D541C85D26508E83_1885336809.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1885336809;
        // ---------- Original Method ----------
        //Hashtable<Object, Object> selected = new Hashtable<Object, Object>();
        //selectProperties(selected, false);
        //return selected.keys();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.859 -0400", hash_original_method = "3F48821B050A70D7E4FF424CB7AEEF4F", hash_generated_method = "7A969C18722B01EB40DABD3A0FEFAEB4")
    public Set<String> stringPropertyNames() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_103621041 = null; //Variable for return #1
        Hashtable<String, Object> stringProperties;
        stringProperties = new Hashtable<String, Object>();
        selectProperties(stringProperties, true);
        varB4EAC82CA7396A68D541C85D26508E83_103621041 = Collections.unmodifiableSet(stringProperties.keySet());
        varB4EAC82CA7396A68D541C85D26508E83_103621041.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_103621041;
        // ---------- Original Method ----------
        //Hashtable<String, Object> stringProperties = new Hashtable<String, Object>();
        //selectProperties(stringProperties, true);
        //return Collections.unmodifiableSet(stringProperties.keySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.860 -0400", hash_original_method = "A87BE62C7A489C0C3750546357B411C0", hash_generated_method = "60B1B021F6DA0DFF0147BE3D181F6CD8")
    private <K> void selectProperties(Hashtable<K, Object> selectProperties, final boolean isStringOnly) {
        {
            defaults.selectProperties(selectProperties, isStringOnly);
        } //End block
        Enumeration<Object> keys;
        keys = keys();
        {
            boolean var92FA05435258CA7C805716F7AD9C73B4_634417799 = (keys.hasMoreElements());
            {
                @SuppressWarnings("unchecked") K key;
                key = (K) keys.nextElement();
                Object value;
                value = get(key);
                selectProperties.put(key, value);
            } //End block
        } //End collapsed parenthetic
        addTaint(selectProperties.getTaint());
        addTaint(isStringOnly);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.860 -0400", hash_original_method = "4460892848C3864FEFFB544B0F6CDF7A", hash_generated_method = "07BBB0B3C207FE6FB50496F7BED34182")
    @Deprecated
    public void save(OutputStream out, String comment) {
        try 
        {
            store(out, comment);
        } //End block
        catch (IOException e)
        { }
        addTaint(out.getTaint());
        addTaint(comment.getTaint());
        // ---------- Original Method ----------
        //try {
            //store(out, comment);
        //} catch (IOException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.860 -0400", hash_original_method = "B5A66BBC4F63569C92BD357B6A0BCEAB", hash_generated_method = "97B294ABD2402FC126941F2F113ECF6A")
    public Object setProperty(String name, String value) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1855706908 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1855706908 = put(name, value);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1855706908.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1855706908;
        // ---------- Original Method ----------
        //return put(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.861 -0400", hash_original_method = "97010F07EC41CFBEB746B7A1A80A2C1A", hash_generated_method = "300730174592DBAA5F71123F0E1FC40F")
    public synchronized void store(OutputStream out, String comment) throws IOException {
        store(new OutputStreamWriter(out, "ISO-8859-1"), comment);
        addTaint(out.getTaint());
        addTaint(comment.getTaint());
        // ---------- Original Method ----------
        //store(new OutputStreamWriter(out, "ISO-8859-1"), comment);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.916 -0400", hash_original_method = "8076CC1A9EBA7B35E4BEA25CCAC41B73", hash_generated_method = "523D3C051F2EDF2E2819689C596ACBB3")
    public synchronized void store(Writer writer, String comment) throws IOException {
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
            Iterator<Map.Entry<Object, Object>> var0A82970C85229BA60CD383C8AED7D8CF_1244766697 = (entrySet()).iterator();
            var0A82970C85229BA60CD383C8AED7D8CF_1244766697.hasNext();
            Map.Entry<Object, Object> entry = var0A82970C85229BA60CD383C8AED7D8CF_1244766697.next();
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
        addTaint(writer.getTaint());
        addTaint(comment.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.920 -0400", hash_original_method = "2CD21803BBD0B22DE3395585690DDBAE", hash_generated_method = "F6952B755A6D838B0EB19899520A1F45")
    public synchronized void loadFromXML(InputStream in) throws IOException,
            InvalidPropertiesFormatException {
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
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.917 -0400", hash_original_method = "A780B405018C6E806DD90859BE935681", hash_generated_method = "BD229E5C9E40B702A5D1E2D0134171D6")
                public void warning(SAXParseException e) throws SAXException {
                    if (DroidSafeAndroidRuntime.control) throw e;
                    addTaint(e.getTaint());
                    // ---------- Original Method ----------
                    //throw e;
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.918 -0400", hash_original_method = "1BA627FA566198BCA8957A882673AC06", hash_generated_method = "08441F730E6D4CFD8EFFD245B173D132")
                public void error(SAXParseException e) throws SAXException {
                    if (DroidSafeAndroidRuntime.control) throw e;
                    addTaint(e.getTaint());
                    // ---------- Original Method ----------
                    //throw e;
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.918 -0400", hash_original_method = "3CBD306431C0846BE7A7FBEF3B9920DA", hash_generated_method = "1D84BA36626C8B0851FA28A0702E4559")
                public void fatalError(SAXParseException e) throws SAXException {
                    if (DroidSafeAndroidRuntime.control) throw e;
                    addTaint(e.getTaint());
                    // ---------- Original Method ----------
                    //throw e;
                }
});
            builder.setEntityResolver(new EntityResolver() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.920 -0400", hash_original_method = "7B6D510D74072B007F41B0B5792E868F", hash_generated_method = "43010520578480EDBA2A1487350B5D04")
                public InputSource resolveEntity(String publicId,
                        String systemId) throws SAXException, IOException {
                    InputSource varB4EAC82CA7396A68D541C85D26508E83_842694141 = null; //Variable for return #1
                    {
                        boolean var291D64E633F0D753C1FE55CB540F0B0D_1632089041 = (systemId.equals(PROP_DTD_NAME));
                        {
                            InputSource result;
                            result = new InputSource(new StringReader(
                                PROP_DTD));
                            result.setSystemId(PROP_DTD_NAME);
                            varB4EAC82CA7396A68D541C85D26508E83_842694141 = result;
                        } //End block
                    } //End collapsed parenthetic
                    if (DroidSafeAndroidRuntime.control) throw new SAXException("Invalid DOCTYPE declaration: "
                            + systemId);
                    addTaint(publicId.getTaint());
                    addTaint(systemId.getTaint());
                    varB4EAC82CA7396A68D541C85D26508E83_842694141.addTaint(getTaint()); //Add taint from parent
                    return varB4EAC82CA7396A68D541C85D26508E83_842694141;
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
        addTaint(in.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.921 -0400", hash_original_method = "CF08828D5EA0BDD9B2ACD5D46AA8D14C", hash_generated_method = "5EF0CB072E12BA7C313B737951A6F9CA")
    public void storeToXML(OutputStream os, String comment) throws IOException {
        storeToXML(os, comment, "UTF-8");
        addTaint(os.getTaint());
        addTaint(comment.getTaint());
        // ---------- Original Method ----------
        //storeToXML(os, comment, "UTF-8");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.996 -0400", hash_original_method = "88C35F171CF08E9C818A3957B761A932", hash_generated_method = "B51CDA54F3061F9F6C13AB73B1512E91")
    public synchronized void storeToXML(OutputStream os, String comment,
            String encoding) throws IOException {
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
            Iterator<Map.Entry<Object, Object>> var0A82970C85229BA60CD383C8AED7D8CF_2040782395 = (entrySet()).iterator();
            var0A82970C85229BA60CD383C8AED7D8CF_2040782395.hasNext();
            Map.Entry<Object, Object> entry = var0A82970C85229BA60CD383C8AED7D8CF_2040782395.next();
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
        addTaint(os.getTaint());
        addTaint(comment.getTaint());
        addTaint(encoding.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.997 -0400", hash_original_method = "C245FBB3FF946795FFB47FE71F12C3B1", hash_generated_method = "C68E588F5CD25AB3EA94CF249E4375BA")
    private String substitutePredefinedEntries(String s) {
        String varB4EAC82CA7396A68D541C85D26508E83_972296652 = null; //Variable for return #1
        s = s.replaceAll("&", "&amp;");
        s = s.replaceAll("<", "&lt;");
        s = s.replaceAll(">", "&gt;");
        s = s.replaceAll("'", "&apos;");
        s = s.replaceAll("\"", "&quot;");
        varB4EAC82CA7396A68D541C85D26508E83_972296652 = s;
        addTaint(s.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_972296652.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_972296652;
        // ---------- Original Method ----------
        //s = s.replaceAll("&", "&amp;");
        //s = s.replaceAll("<", "&lt;");
        //s = s.replaceAll(">", "&gt;");
        //s = s.replaceAll("'", "&apos;");
        //s = s.replaceAll("\"", "&quot;");
        //return s;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.997 -0400", hash_original_field = "3E7ACF4375E68B6EA0BCA2BE83B25596", hash_generated_field = "25AFC785DC01F27367482FF9CBFD1A78")

    private static long serialVersionUID = 4112578634029874840L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.997 -0400", hash_original_field = "950AEF4954A3EB33D8EA9CE52A6C7335", hash_generated_field = "00BF625FC344E491972A577C7F0F4F69")

    private static String PROP_DTD_NAME = "http://java.sun.com/dtd/properties.dtd";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.998 -0400", hash_original_field = "60953D0FB090018CDD85598651263315", hash_generated_field = "1290D968FB1EA09BB23FDF32C7953DF1")

    private static String PROP_DTD = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
            + "    <!ELEMENT properties (comment?, entry*) >"
            + "    <!ATTLIST properties version CDATA #FIXED \"1.0\" >"
            + "    <!ELEMENT comment (#PCDATA) >"
            + "    <!ELEMENT entry (#PCDATA) >"
            + "    <!ATTLIST entry key CDATA #REQUIRED >";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.998 -0400", hash_original_field = "4F2536D0D627A82B4C8A0BFFFEFBF7DA", hash_generated_field = "7285E259B290F7E6942A2AC1E5166429")

    private static int NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.998 -0400", hash_original_field = "891D8F71F28248053B8F5A2BAE3EEDD4", hash_generated_field = "B12ABB5174A3A70B79653B87F985E1B7")

    private static int SLASH = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.998 -0400", hash_original_field = "27BBE49DEAA2708F51AB22AF9E02694A", hash_generated_field = "97AFB59B23C319F602D087815DE8FF3C")

    private static int UNICODE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.998 -0400", hash_original_field = "3EEE4D5909DE4458D87CC1DBB27D23E8", hash_generated_field = "0EE3E3562DFBE99E15A3B50CFD781988")

    private static int CONTINUE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.998 -0400", hash_original_field = "F06DF84D977CB8AE06C888CA7E01B4E2", hash_generated_field = "185F0F5D1EBA95881EC662D970EBF82A")

    private static int KEY_DONE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:52.998 -0400", hash_original_field = "2244D293D67AF3EF08FD93F9C1A68030", hash_generated_field = "B4961B44E69DF5D4EEBFF188AB61E92F")

    private static int IGNORE = 5;
}

