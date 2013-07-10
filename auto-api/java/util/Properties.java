package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.428 -0400", hash_original_field = "C968D5902105C7A38B74CBA2C954C7FE", hash_generated_field = "FD91B16F92409AD1E464978ACF6CCD28")

    private transient DocumentBuilder builder = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.428 -0400", hash_original_field = "A4A918A45181164207929D52AEC36AEC", hash_generated_field = "FFB6C63B9AE394F9A7BA81EBAD128C5B")

    protected Properties defaults;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.429 -0400", hash_original_method = "15BC7402B615AC640D692CA8D591C86A", hash_generated_method = "A0C8CF0DEBFCC799D900ACDC0026C561")
    public  Properties() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.429 -0400", hash_original_method = "5F2D706A0CAB1895C5A727D855C46322", hash_generated_method = "DDFB4D46DBC5C7586044047CB8719A59")
    public  Properties(Properties properties) {
        defaults = properties;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.430 -0400", hash_original_method = "8670FB32C289DA514C35A14528148A6D", hash_generated_method = "EBE91636B6DEAC102C20B19EDD8B333E")
    private void dumpString(StringBuilder buffer, String string, boolean key) {
        int i = 0;
        {
            boolean var34D0A0FAAC14922733F9F34BCB213788_1433034098 = (!key && i < string.length() && string.charAt(i) == ' ');
            {
                buffer.append("\\ ");
            } 
        } 
        {
            boolean var729E5A733A8BA5CCFE0E0BA21DE6759C_770917864 = (i < string.length());
            {
                char ch = string.charAt(i);
                
                buffer.append("\\t");
                
                
                buffer.append("\\n");
                
                
                buffer.append("\\f");
                
                
                buffer.append("\\r");
                
                
                {
                    boolean var5DFC28C43123261F22231B1072AE287F_2024388441 = ("\\#!=:".indexOf(ch) >= 0 || (key && ch == ' '));
                    {
                        buffer.append('\\');
                    } 
                } 
                
                
                {
                    buffer.append(ch);
                } 
                {
                    String hex = Integer.toHexString(ch);
                    buffer.append("\\u");
                    {
                        int j = 0;
                        boolean var370BB82D6D90CD983B3EBAA925D59283_244631472 = (j < 4 - hex.length());
                        {
                            buffer.append("0");
                        } 
                    } 
                    buffer.append(hex);
                } 
                
            } 
        } 
        addTaint(buffer.getTaint());
        addTaint(string.getTaint());
        addTaint(key);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.431 -0400", hash_original_method = "B2B08C7B9AD3334D72416F92376E272C", hash_generated_method = "25F8B94B0B77D26CFC32AA086A340E6F")
    public String getProperty(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_573027755 = null; 
        Object result = super.get(name);
        String property;
        property = (String) result;
        property = null;
        {
            property = defaults.getProperty(name);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_573027755 = property;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_573027755.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_573027755;
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.432 -0400", hash_original_method = "3601550743DD7ED6E54F365D9B667C39", hash_generated_method = "9B758371AF96FA63987CF9F0F6C46503")
    public String getProperty(String name, String defaultValue) {
        String varB4EAC82CA7396A68D541C85D26508E83_1759947270 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_787389054 = null; 
        Object result = super.get(name);
        String property;
        property = (String) result;
        property = null;
        {
            property = defaults.getProperty(name);
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1759947270 = defaultValue;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_787389054 = property;
        addTaint(name.getTaint());
        addTaint(defaultValue.getTaint());
        String varA7E53CE21691AB073D9660D615818899_749109629; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_749109629 = varB4EAC82CA7396A68D541C85D26508E83_1759947270;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_749109629 = varB4EAC82CA7396A68D541C85D26508E83_787389054;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_749109629.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_749109629;
        
        
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.433 -0400", hash_original_method = "C9FDCBF4B35B89B1D79FB5B2779CDC77", hash_generated_method = "E21A44BBEA8464A2A99922CCCB34A5C3")
    public void list(PrintStream out) {
        listToAppendable(out);
        addTaint(out.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.433 -0400", hash_original_method = "2577CE734D2D6BD05EB3CE3808D03445", hash_generated_method = "6BEDFC494176E84B7E97255CBD826851")
    public void list(PrintWriter out) {
        listToAppendable(out);
        addTaint(out.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.434 -0400", hash_original_method = "68CAE489B2B77D788FAF807067B604BA", hash_generated_method = "2D4343DABDAB67904C69CC487DC555C1")
    private void listToAppendable(Appendable out) {
        try 
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("out == null");
            } 
            StringBuilder sb = new StringBuilder(80);
            Enumeration<?> keys = propertyNames();
            {
                boolean var50D6288C676B93E5C0384206AD0778B6_1058642597 = (keys.hasMoreElements());
                {
                    String key = (String) keys.nextElement();
                    sb.append(key);
                    sb.append('=');
                    String property = (String) super.get(key);
                    Properties def = defaults;
                    {
                        property = (String) def.get(key);
                        def = def.defaults;
                    } 
                    {
                        boolean var8F62FE0E7F6AF45BBD78239662846E5F_823320509 = (property.length() > 40);
                        {
                            sb.append(property.substring(0, 37));
                            sb.append("...");
                        } 
                        {
                            sb.append(property);
                        } 
                    } 
                    sb.append(System.lineSeparator());
                    out.append(sb.toString());
                    sb.setLength(0);
                } 
            } 
        } 
        catch (IOException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(ex);
        } 
        addTaint(out.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.435 -0400", hash_original_method = "B8EDE929B09671D07A2F603EF776CD24", hash_generated_method = "07933C07E7CA1068C0BB8CE619F3BD77")
    public synchronized void load(InputStream in) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        load(new InputStreamReader(in, "ISO-8859-1"));
        addTaint(in.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.436 -0400", hash_original_method = "3CECE8DDCAF4401F719C3D407BA79CAE", hash_generated_method = "0A53F6DAA9CC117B9536B15C400A189D")
    @SuppressWarnings("fallthrough")
    public synchronized void load(Reader in) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        int mode = NONE;
        int unicode = 0;
        int count = 0;
        char nextChar;
        char buf[] = new char[40];
        int offset = 0;
        int keyLength = -1;
        int intVal;
        boolean firstChar = true;
        BufferedReader br = new BufferedReader(in);
        {
            intVal = br.read();
            nextChar = (char) intVal;
            {
                char[] newBuf = new char[buf.length * 2];
                System.arraycopy(buf, 0, newBuf, 0, offset);
                buf = newBuf;
            } 
            {
                int digit = Character.digit(nextChar, 16);
                {
                    unicode = (unicode << 4) + digit;
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid Unicode sequence: illegal character");
                } 
                mode = NONE;
                buf[offset++] = (char) unicode;
            } 
            {
                mode = NONE;
                
                mode = CONTINUE;
                
                
                mode = IGNORE;
                
                
                nextChar = '\b';
                
                
                nextChar = '\f';
                
                
                nextChar = '\n';
                
                
                nextChar = '\r';
                
                
                nextChar = '\t';
                
                
                mode = UNICODE;
                
                
                unicode = count = 0;
                
            } 
            {
                
                {
                    {
                        intVal = br.read();
                        nextChar = (char) intVal;
                    } 
                } 
                
                
                {
                    mode = IGNORE;
                } 
                
                
                mode = NONE;
                
                
                firstChar = true;
                
                
                {
                    {
                        keyLength = offset;
                    } 
                    String temp = new String(buf, 0, offset);
                    put(temp.substring(0, keyLength), temp
                                .substring(keyLength));
                } 
                
                
                keyLength = -1;
                
                
                offset = 0;
                
                
                {
                    keyLength = offset;
                } 
                
                
                mode = SLASH;
                
                
                {
                    mode = NONE;
                    keyLength = offset;
                } 
                
                {
                    boolean var1ED420F8964B295D71B68F4D48D8A3E6_179622501 = (Character.isWhitespace(nextChar));
                    {
                        {
                            mode = IGNORE;
                        } 
                        {
                            mode = KEY_DONE;
                        } 
                    } 
                } 
                {
                    mode = NONE;
                } 
            } 
            firstChar = false;
            {
                keyLength = offset;
                mode = NONE;
            } 
            buf[offset++] = nextChar;
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid Unicode sequence: expected format \\uxxxx");
        } 
        {
            keyLength = offset;
        } 
        {
            String temp = new String(buf, 0, offset);
            String key = temp.substring(0, keyLength);
            String value = temp.substring(keyLength);
            {
                value += "\u0000";
            } 
            put(key, value);
        } 
        addTaint(in.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.437 -0400", hash_original_method = "1BF2C237B8DD3958FB1B8B5C0AE1938E", hash_generated_method = "D07D9721AAEA5280F89D039AEB1C62D6")
    public Enumeration<?> propertyNames() {
        Enumeration<?> varB4EAC82CA7396A68D541C85D26508E83_193040247 = null; 
        Hashtable<Object, Object> selected = new Hashtable<Object, Object>();
        selectProperties(selected, false);
        varB4EAC82CA7396A68D541C85D26508E83_193040247 = selected.keys();
        varB4EAC82CA7396A68D541C85D26508E83_193040247.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_193040247;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.437 -0400", hash_original_method = "3F48821B050A70D7E4FF424CB7AEEF4F", hash_generated_method = "83CA5668A9D203C245C6188182A73ACC")
    public Set<String> stringPropertyNames() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1194146806 = null; 
        Hashtable<String, Object> stringProperties = new Hashtable<String, Object>();
        selectProperties(stringProperties, true);
        varB4EAC82CA7396A68D541C85D26508E83_1194146806 = Collections.unmodifiableSet(stringProperties.keySet());
        varB4EAC82CA7396A68D541C85D26508E83_1194146806.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1194146806;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.437 -0400", hash_original_method = "A87BE62C7A489C0C3750546357B411C0", hash_generated_method = "5C58F0B1B8B0A350B4DC8D24953BD05F")
    private <K> void selectProperties(Hashtable<K, Object> selectProperties, final boolean isStringOnly) {
        {
            defaults.selectProperties(selectProperties, isStringOnly);
        } 
        Enumeration<Object> keys = keys();
        {
            boolean var92FA05435258CA7C805716F7AD9C73B4_2100254778 = (keys.hasMoreElements());
            {
                @SuppressWarnings("unchecked") K key = (K) keys.nextElement();
                Object value = get(key);
                selectProperties.put(key, value);
            } 
        } 
        addTaint(selectProperties.getTaint());
        addTaint(isStringOnly);
        
        
            
        
        
        
            
            
            
                
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.438 -0400", hash_original_method = "4460892848C3864FEFFB544B0F6CDF7A", hash_generated_method = "07BBB0B3C207FE6FB50496F7BED34182")
    @Deprecated
    public void save(OutputStream out, String comment) {
        try 
        {
            store(out, comment);
        } 
        catch (IOException e)
        { }
        addTaint(out.getTaint());
        addTaint(comment.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.438 -0400", hash_original_method = "B5A66BBC4F63569C92BD357B6A0BCEAB", hash_generated_method = "4211E2C358785E87ED840E1AB87B2082")
    public Object setProperty(String name, String value) {
        Object varB4EAC82CA7396A68D541C85D26508E83_12750559 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_12750559 = put(name, value);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_12750559.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_12750559;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.439 -0400", hash_original_method = "97010F07EC41CFBEB746B7A1A80A2C1A", hash_generated_method = "300730174592DBAA5F71123F0E1FC40F")
    public synchronized void store(OutputStream out, String comment) throws IOException {
        store(new OutputStreamWriter(out, "ISO-8859-1"), comment);
        addTaint(out.getTaint());
        addTaint(comment.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.448 -0400", hash_original_method = "8076CC1A9EBA7B35E4BEA25CCAC41B73", hash_generated_method = "10D38835901481783103B45B48A85EC4")
    public synchronized void store(Writer writer, String comment) throws IOException {
        {
            writer.write("#");
            writer.write(comment);
            writer.write(System.lineSeparator());
        } 
        writer.write("#");
        writer.write(new Date().toString());
        writer.write(System.lineSeparator());
        StringBuilder sb = new StringBuilder(200);
        {
            Iterator<Map.Entry<Object, Object>> var0A82970C85229BA60CD383C8AED7D8CF_1298431736 = (entrySet()).iterator();
            var0A82970C85229BA60CD383C8AED7D8CF_1298431736.hasNext();
            Map.Entry<Object, Object> entry = var0A82970C85229BA60CD383C8AED7D8CF_1298431736.next();
            {
                String key = (String) entry.getKey();
                dumpString(sb, key, true);
                sb.append('=');
                dumpString(sb, (String) entry.getValue(), false);
                sb.append(System.lineSeparator());
                writer.write(sb.toString());
                sb.setLength(0);
            } 
        } 
        writer.flush();
        addTaint(writer.getTaint());
        addTaint(comment.getTaint());
        
        
            
            
            
        
        
        
        
        
        
            
            
            
            
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.452 -0400", hash_original_method = "2CD21803BBD0B22DE3395585690DDBAE", hash_generated_method = "E5C46CD7F2215E74C5F73FFCA6CE8090")
    public synchronized void loadFromXML(InputStream in) throws IOException,
            InvalidPropertiesFormatException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            try 
            {
                builder = factory.newDocumentBuilder();
            } 
            catch (ParserConfigurationException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new Error(e);
            } 
            builder.setErrorHandler(new ErrorHandler() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.449 -0400", hash_original_method = "A780B405018C6E806DD90859BE935681", hash_generated_method = "BD229E5C9E40B702A5D1E2D0134171D6")
                public void warning(SAXParseException e) throws SAXException {
                    if (DroidSafeAndroidRuntime.control) throw e;
                    addTaint(e.getTaint());
                    
                    
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.450 -0400", hash_original_method = "1BA627FA566198BCA8957A882673AC06", hash_generated_method = "08441F730E6D4CFD8EFFD245B173D132")
                public void error(SAXParseException e) throws SAXException {
                    if (DroidSafeAndroidRuntime.control) throw e;
                    addTaint(e.getTaint());
                    
                    
                }
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.450 -0400", hash_original_method = "3CBD306431C0846BE7A7FBEF3B9920DA", hash_generated_method = "1D84BA36626C8B0851FA28A0702E4559")
                public void fatalError(SAXParseException e) throws SAXException {
                    if (DroidSafeAndroidRuntime.control) throw e;
                    addTaint(e.getTaint());
                    
                    
                }
});
            builder.setEntityResolver(new EntityResolver() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.451 -0400", hash_original_method = "7B6D510D74072B007F41B0B5792E868F", hash_generated_method = "C40D154825EE5816B721CDD35D94886E")
                public InputSource resolveEntity(String publicId,
                        String systemId) throws SAXException, IOException {
                    InputSource varB4EAC82CA7396A68D541C85D26508E83_1553240704 = null; 
                    {
                        boolean var291D64E633F0D753C1FE55CB540F0B0D_1603647784 = (systemId.equals(PROP_DTD_NAME));
                        {
                            InputSource result = new InputSource(new StringReader(
                                PROP_DTD));
                            result.setSystemId(PROP_DTD_NAME);
                            varB4EAC82CA7396A68D541C85D26508E83_1553240704 = result;
                        } 
                    } 
                    if (DroidSafeAndroidRuntime.control) throw new SAXException("Invalid DOCTYPE declaration: "
                            + systemId);
                    addTaint(publicId.getTaint());
                    addTaint(systemId.getTaint());
                    varB4EAC82CA7396A68D541C85D26508E83_1553240704.addTaint(getTaint()); 
                    return varB4EAC82CA7396A68D541C85D26508E83_1553240704;
                    
                    
                        
                                
                        
                        
                    
                    
                            
                }
});
        } 
        try 
        {
            Document doc = builder.parse(in);
            NodeList entries = doc.getElementsByTagName("entry");
            int entriesListLength = entries.getLength();
            {
                int i = 0;
                {
                    Element entry = (Element) entries.item(i);
                    String key = entry.getAttribute("key");
                    String value = entry.getTextContent();
                    put(key, value);
                } 
            } 
        } 
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw e;
        } 
        catch (SAXException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidPropertiesFormatException(e);
        } 
        addTaint(in.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.452 -0400", hash_original_method = "CF08828D5EA0BDD9B2ACD5D46AA8D14C", hash_generated_method = "5EF0CB072E12BA7C313B737951A6F9CA")
    public void storeToXML(OutputStream os, String comment) throws IOException {
        storeToXML(os, comment, "UTF-8");
        addTaint(os.getTaint());
        addTaint(comment.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.466 -0400", hash_original_method = "88C35F171CF08E9C818A3957B761A932", hash_generated_method = "61D436C0A80292D48DD32B9487768EAB")
    public synchronized void storeToXML(OutputStream os, String comment,
            String encoding) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        String encodingCanonicalName;
        try 
        {
            encodingCanonicalName = Charset.forName(encoding).name();
        } 
        catch (IllegalCharsetNameException e)
        {
            System.out.println("Warning: encoding name " + encoding
                    + " is illegal, using UTF-8 as default encoding");
            encodingCanonicalName = "UTF-8";
        } 
        catch (UnsupportedCharsetException e)
        {
            System.out.println("Warning: encoding " + encoding
                    + " is not supported, using UTF-8 as default encoding");
            encodingCanonicalName = "UTF-8";
        } 
        PrintStream printStream = new PrintStream(os, false,
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
        } 
        {
            Iterator<Map.Entry<Object, Object>> var0A82970C85229BA60CD383C8AED7D8CF_1144256369 = (entrySet()).iterator();
            var0A82970C85229BA60CD383C8AED7D8CF_1144256369.hasNext();
            Map.Entry<Object, Object> entry = var0A82970C85229BA60CD383C8AED7D8CF_1144256369.next();
            {
                String keyValue = (String) entry.getKey();
                String entryValue = (String) entry.getValue();
                printStream.print("<entry key=\"");
                printStream.print(substitutePredefinedEntries(keyValue));
                printStream.print("\">");
                printStream.print(substitutePredefinedEntries(entryValue));
                printStream.println("</entry>");
            } 
        } 
        printStream.println("</properties>");
        printStream.flush();
        addTaint(os.getTaint());
        addTaint(comment.getTaint());
        addTaint(encoding.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.467 -0400", hash_original_method = "C245FBB3FF946795FFB47FE71F12C3B1", hash_generated_method = "C3446F0C1158CB0818BFDC89D41FC064")
    private String substitutePredefinedEntries(String s) {
        String varB4EAC82CA7396A68D541C85D26508E83_1751337248 = null; 
        s = s.replaceAll("&", "&amp;");
        s = s.replaceAll("<", "&lt;");
        s = s.replaceAll(">", "&gt;");
        s = s.replaceAll("'", "&apos;");
        s = s.replaceAll("\"", "&quot;");
        varB4EAC82CA7396A68D541C85D26508E83_1751337248 = s;
        addTaint(s.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1751337248.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1751337248;
        
        
        
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.467 -0400", hash_original_field = "3E7ACF4375E68B6EA0BCA2BE83B25596", hash_generated_field = "B9B3DC636549D3041EBFB366A6464B2E")

    private static final long serialVersionUID = 4112578634029874840L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.467 -0400", hash_original_field = "950AEF4954A3EB33D8EA9CE52A6C7335", hash_generated_field = "6EB68577AA63C8CE23A5572AC9077D85")

    private static final String PROP_DTD_NAME = "http://java.sun.com/dtd/properties.dtd";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.467 -0400", hash_original_field = "60953D0FB090018CDD85598651263315", hash_generated_field = "12D66A953921A104006A54797CCD01D0")

    private static final String PROP_DTD = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
            + "    <!ELEMENT properties (comment?, entry*) >"
            + "    <!ATTLIST properties version CDATA #FIXED \"1.0\" >"
            + "    <!ELEMENT comment (#PCDATA) >"
            + "    <!ELEMENT entry (#PCDATA) >"
            + "    <!ATTLIST entry key CDATA #REQUIRED >";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.467 -0400", hash_original_field = "4F2536D0D627A82B4C8A0BFFFEFBF7DA", hash_generated_field = "76E820B599FE28B3403AD7E6FB9DE931")

    private static final int NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.467 -0400", hash_original_field = "891D8F71F28248053B8F5A2BAE3EEDD4", hash_generated_field = "A660E479CB11A03AEF0EBDF15B325E19")

    private static final int SLASH = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.467 -0400", hash_original_field = "27BBE49DEAA2708F51AB22AF9E02694A", hash_generated_field = "279F3AC27643FBAD4A1141944F156982")

    private static final int UNICODE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.467 -0400", hash_original_field = "3EEE4D5909DE4458D87CC1DBB27D23E8", hash_generated_field = "6A88BA6F8613415BC01634427DC9E4C4")

    private static final int CONTINUE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.467 -0400", hash_original_field = "F06DF84D977CB8AE06C888CA7E01B4E2", hash_generated_field = "03E2C41D67B733CE677B61203540AA72")

    private static final int KEY_DONE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.467 -0400", hash_original_field = "2244D293D67AF3EF08FD93F9C1A68030", hash_generated_field = "BB2FAFE0C6AEB56E9A6250AD961B8C45")

    private static final int IGNORE = 5;
}

