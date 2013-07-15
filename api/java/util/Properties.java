package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.318 -0400", hash_original_field = "C968D5902105C7A38B74CBA2C954C7FE", hash_generated_field = "FD91B16F92409AD1E464978ACF6CCD28")

    private transient DocumentBuilder builder = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.318 -0400", hash_original_field = "A4A918A45181164207929D52AEC36AEC", hash_generated_field = "FFB6C63B9AE394F9A7BA81EBAD128C5B")

    protected Properties defaults;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.318 -0400", hash_original_method = "15BC7402B615AC640D692CA8D591C86A", hash_generated_method = "A0C8CF0DEBFCC799D900ACDC0026C561")
    public  Properties() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.319 -0400", hash_original_method = "5F2D706A0CAB1895C5A727D855C46322", hash_generated_method = "DDFB4D46DBC5C7586044047CB8719A59")
    public  Properties(Properties properties) {
        defaults = properties;
        // ---------- Original Method ----------
        //defaults = properties;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.319 -0400", hash_original_method = "8670FB32C289DA514C35A14528148A6D", hash_generated_method = "DB4D712D977768F08744F22087605AA7")
    private void dumpString(StringBuilder buffer, String string, boolean key) {
        addTaint(key);
        addTaint(string.getTaint());
        addTaint(buffer.getTaint());
        int i = 0;
    if(!key && i < string.length() && string.charAt(i) == ' ')        
        {
            buffer.append("\\ ");
            i++;
        } //End block
for(;i < string.length();i++)
        {
            char ch = string.charAt(i);
switch(ch){
            case '\t':
            buffer.append("\\t");
            break;
            case '\n':
            buffer.append("\\n");
            break;
            case '\f':
            buffer.append("\\f");
            break;
            case '\r':
            buffer.append("\\r");
            break;
            default:
    if("\\#!=:".indexOf(ch) >= 0 || (key && ch == ' '))            
            {
                buffer.append('\\');
            } //End block
    if(ch >= ' ' && ch <= '~')            
            {
                buffer.append(ch);
            } //End block
            else
            {
                String hex = Integer.toHexString(ch);
                buffer.append("\\u");
for(int j = 0;j < 4 - hex.length();j++)
                {
                    buffer.append("0");
                } //End block
                buffer.append(hex);
            } //End block
}
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.320 -0400", hash_original_method = "B2B08C7B9AD3334D72416F92376E272C", hash_generated_method = "64D938A519C839ABD7BB68CA41778F49")
    public String getProperty(String name) {
        addTaint(name.getTaint());
        Object result = super.get(name);
        String property = result instanceof String ? (String) result : null;
    if(property == null && defaults != null)        
        {
            property = defaults.getProperty(name);
        } //End block
String varA1B66E00F250B2004594D11D7A1EDAF2_125606913 =         property;
        varA1B66E00F250B2004594D11D7A1EDAF2_125606913.addTaint(taint);
        return varA1B66E00F250B2004594D11D7A1EDAF2_125606913;
        // ---------- Original Method ----------
        //Object result = super.get(name);
        //String property = result instanceof String ? (String) result : null;
        //if (property == null && defaults != null) {
            //property = defaults.getProperty(name);
        //}
        //return property;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.321 -0400", hash_original_method = "3601550743DD7ED6E54F365D9B667C39", hash_generated_method = "C12679FDF697CF827AB9173E384C33D2")
    public String getProperty(String name, String defaultValue) {
        addTaint(defaultValue.getTaint());
        addTaint(name.getTaint());
        Object result = super.get(name);
        String property = result instanceof String ? (String) result : null;
    if(property == null && defaults != null)        
        {
            property = defaults.getProperty(name);
        } //End block
    if(property == null)        
        {
String var6042003835E71BD302E1524BA5D2EC10_837658717 =             defaultValue;
            var6042003835E71BD302E1524BA5D2EC10_837658717.addTaint(taint);
            return var6042003835E71BD302E1524BA5D2EC10_837658717;
        } //End block
String varA1B66E00F250B2004594D11D7A1EDAF2_48565127 =         property;
        varA1B66E00F250B2004594D11D7A1EDAF2_48565127.addTaint(taint);
        return varA1B66E00F250B2004594D11D7A1EDAF2_48565127;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.321 -0400", hash_original_method = "C9FDCBF4B35B89B1D79FB5B2779CDC77", hash_generated_method = "CBE2DDE6E4F552DA015DD74E7E1B9271")
    public void list(PrintStream out) {
        addTaint(out.getTaint());
        listToAppendable(out);
        // ---------- Original Method ----------
        //listToAppendable(out);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.321 -0400", hash_original_method = "2577CE734D2D6BD05EB3CE3808D03445", hash_generated_method = "C5884C59C3680F2F741CCE12AB527B87")
    public void list(PrintWriter out) {
        addTaint(out.getTaint());
        listToAppendable(out);
        // ---------- Original Method ----------
        //listToAppendable(out);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.322 -0400", hash_original_method = "68CAE489B2B77D788FAF807067B604BA", hash_generated_method = "49D9DFA9BAAF6AC45052EDE5510BF6A3")
    private void listToAppendable(Appendable out) {
        addTaint(out.getTaint());
        try 
        {
    if(out == null)            
            {
                NullPointerException varF1992D5A35D07B60F06D2FCD426180C4_882573564 = new NullPointerException("out == null");
                varF1992D5A35D07B60F06D2FCD426180C4_882573564.addTaint(taint);
                throw varF1992D5A35D07B60F06D2FCD426180C4_882573564;
            } //End block
            StringBuilder sb = new StringBuilder(80);
            Enumeration<?> keys = propertyNames();
            while
(keys.hasMoreElements())            
            {
                String key = (String) keys.nextElement();
                sb.append(key);
                sb.append('=');
                String property = (String) super.get(key);
                Properties def = defaults;
                while
(property == null)                
                {
                    property = (String) def.get(key);
                    def = def.defaults;
                } //End block
    if(property.length() > 40)                
                {
                    sb.append(property.substring(0, 37));
                    sb.append("...");
                } //End block
                else
                {
                    sb.append(property);
                } //End block
                sb.append(System.lineSeparator());
                out.append(sb.toString());
                sb.setLength(0);
            } //End block
        } //End block
        catch (IOException ex)
        {
            AssertionError var856F93FDE0E323DC56DBDD84445E8491_514666068 = new AssertionError(ex);
            var856F93FDE0E323DC56DBDD84445E8491_514666068.addTaint(taint);
            throw var856F93FDE0E323DC56DBDD84445E8491_514666068;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.323 -0400", hash_original_method = "B8EDE929B09671D07A2F603EF776CD24", hash_generated_method = "16581405B6AE17BD7C7C3B03E349E383")
    public synchronized void load(InputStream in) throws IOException {
        addTaint(in.getTaint());
    if(in == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_407615730 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_407615730.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_407615730;
        } //End block
        load(new InputStreamReader(in, "ISO-8859-1"));
        // ---------- Original Method ----------
        //if (in == null) {
            //throw new NullPointerException();
        //}
        //load(new InputStreamReader(in, "ISO-8859-1"));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.327 -0400", hash_original_method = "3CECE8DDCAF4401F719C3D407BA79CAE", hash_generated_method = "F310F69FF865693208FC08EED5C82255")
    @SuppressWarnings("fallthrough")
    public synchronized void load(Reader in) throws IOException {
        addTaint(in.getTaint());
    if(in == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_65373788 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_65373788.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_65373788;
        } //End block
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
        while
(true)        
        {
            intVal = br.read();
    if(intVal == -1)            
            {
                break;
            } //End block
            nextChar = (char) intVal;
    if(offset == buf.length)            
            {
                char[] newBuf = new char[buf.length * 2];
                System.arraycopy(buf, 0, newBuf, 0, offset);
                buf = newBuf;
            } //End block
    if(mode == UNICODE)            
            {
                int digit = Character.digit(nextChar, 16);
    if(digit >= 0)                
                {
                    unicode = (unicode << 4) + digit;
    if(++count < 4)                    
                    {
                        continue;
                    } //End block
                } //End block
                else
    if(count <= 4)                
                {
                    IllegalArgumentException var957E64F47DC2D55A2E1BDDB9B6E071C9_1308542863 = new IllegalArgumentException("Invalid Unicode sequence: illegal character");
                    var957E64F47DC2D55A2E1BDDB9B6E071C9_1308542863.addTaint(taint);
                    throw var957E64F47DC2D55A2E1BDDB9B6E071C9_1308542863;
                } //End block
                mode = NONE;
                buf[offset++] = (char) unicode;
    if(nextChar != '\n')                
                {
                    continue;
                } //End block
            } //End block
    if(mode == SLASH)            
            {
                mode = NONE;
switch(nextChar){
                case '\r':
                mode = CONTINUE;
                continue;
                case '\n':
                mode = IGNORE;
                continue;
                case 'b':
                nextChar = '\b';
                break;
                case 'f':
                nextChar = '\f';
                break;
                case 'n':
                nextChar = '\n';
                break;
                case 'r':
                nextChar = '\r';
                break;
                case 't':
                nextChar = '\t';
                break;
                case 'u':
                mode = UNICODE;
                unicode = count = 0;
                continue;
}
            } //End block
            else
            {
switch(nextChar){
                case '#':
                case '!':
    if(firstChar)                
                {
                    while
(true)                    
                    {
                        intVal = br.read();
    if(intVal == -1)                        
                        {
                            break;
                        } //End block
                        nextChar = (char) intVal;
    if(nextChar == '\r' || nextChar == '\n')                        
                        {
                            break;
                        } //End block
                    } //End block
                    continue;
                } //End block
                break;
                case '\n':
    if(mode == CONTINUE)                
                {
                    mode = IGNORE;
                    continue;
                } //End block
                case '\r':
                mode = NONE;
                firstChar = true;
    if(offset > 0 || (offset == 0 && keyLength == 0))                
                {
    if(keyLength == -1)                    
                    {
                        keyLength = offset;
                    } //End block
                    String temp = new String(buf, 0, offset);
                    put(temp.substring(0, keyLength), temp
                                .substring(keyLength));
                } //End block
                keyLength = -1;
                offset = 0;
                continue;
                case '\\':
    if(mode == KEY_DONE)                
                {
                    keyLength = offset;
                } //End block
                mode = SLASH;
                continue;
                case ':':
                case '=':
    if(keyLength == -1)                
                {
                    mode = NONE;
                    keyLength = offset;
                    continue;
                } //End block
                break;
}    if(Character.isWhitespace(nextChar))                
                {
    if(mode == CONTINUE)                    
                    {
                        mode = IGNORE;
                    } //End block
    if(offset == 0 || offset == keyLength || mode == IGNORE)                    
                    {
                        continue;
                    } //End block
    if(keyLength == -1)                    
                    {
                        mode = KEY_DONE;
                        continue;
                    } //End block
                } //End block
    if(mode == IGNORE || mode == CONTINUE)                
                {
                    mode = NONE;
                } //End block
            } //End block
            firstChar = false;
    if(mode == KEY_DONE)            
            {
                keyLength = offset;
                mode = NONE;
            } //End block
            buf[offset++] = nextChar;
        } //End block
    if(mode == UNICODE && count <= 4)        
        {
            IllegalArgumentException varFB4847902D96F6C3CCB92EF47A108E5E_1598470152 = new IllegalArgumentException("Invalid Unicode sequence: expected format \\uxxxx");
            varFB4847902D96F6C3CCB92EF47A108E5E_1598470152.addTaint(taint);
            throw varFB4847902D96F6C3CCB92EF47A108E5E_1598470152;
        } //End block
    if(keyLength == -1 && offset > 0)        
        {
            keyLength = offset;
        } //End block
    if(keyLength >= 0)        
        {
            String temp = new String(buf, 0, offset);
            String key = temp.substring(0, keyLength);
            String value = temp.substring(keyLength);
    if(mode == SLASH)            
            {
                value += "\u0000";
            } //End block
            put(key, value);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.329 -0400", hash_original_method = "1BF2C237B8DD3958FB1B8B5C0AE1938E", hash_generated_method = "05C101D12C106F7708EB1B02624D4F1C")
    public Enumeration<?> propertyNames() {
        Hashtable<Object, Object> selected = new Hashtable<Object, Object>();
        selectProperties(selected, false);
Enumeration<?> var80055F469BD9AFB17C389AD471454A49_1631038633 =         selected.keys();
        var80055F469BD9AFB17C389AD471454A49_1631038633.addTaint(taint);
        return var80055F469BD9AFB17C389AD471454A49_1631038633;
        // ---------- Original Method ----------
        //Hashtable<Object, Object> selected = new Hashtable<Object, Object>();
        //selectProperties(selected, false);
        //return selected.keys();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.329 -0400", hash_original_method = "3F48821B050A70D7E4FF424CB7AEEF4F", hash_generated_method = "F1B2856761234C7C568E3BAA044A8CC4")
    public Set<String> stringPropertyNames() {
        Hashtable<String, Object> stringProperties = new Hashtable<String, Object>();
        selectProperties(stringProperties, true);
Set<String> var1DD546152BB75C36ADB53C3247459F46_535073900 =         Collections.unmodifiableSet(stringProperties.keySet());
        var1DD546152BB75C36ADB53C3247459F46_535073900.addTaint(taint);
        return var1DD546152BB75C36ADB53C3247459F46_535073900;
        // ---------- Original Method ----------
        //Hashtable<String, Object> stringProperties = new Hashtable<String, Object>();
        //selectProperties(stringProperties, true);
        //return Collections.unmodifiableSet(stringProperties.keySet());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.330 -0400", hash_original_method = "A87BE62C7A489C0C3750546357B411C0", hash_generated_method = "0A8899B8A69A32A18E613C9F0DB4012D")
    private <K> void selectProperties(Hashtable<K, Object> selectProperties, final boolean isStringOnly) {
        addTaint(isStringOnly);
        addTaint(selectProperties.getTaint());
    if(defaults != null)        
        {
            defaults.selectProperties(selectProperties, isStringOnly);
        } //End block
        Enumeration<Object> keys = keys();
        while
(keys.hasMoreElements())        
        {
            @SuppressWarnings("unchecked") K key = (K) keys.nextElement();
    if(isStringOnly && !(key instanceof String))            
            {
                continue;
            } //End block
            Object value = get(key);
            selectProperties.put(key, value);
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.330 -0400", hash_original_method = "4460892848C3864FEFFB544B0F6CDF7A", hash_generated_method = "2907924549EF5AD58CEB1F833FD3C166")
    @Deprecated
    public void save(OutputStream out, String comment) {
        addTaint(comment.getTaint());
        addTaint(out.getTaint());
        try 
        {
            store(out, comment);
        } //End block
        catch (IOException e)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //store(out, comment);
        //} catch (IOException e) {
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.331 -0400", hash_original_method = "B5A66BBC4F63569C92BD357B6A0BCEAB", hash_generated_method = "68F6D02BEC4581F1C2F714E225AB9109")
    public Object setProperty(String name, String value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
Object varF4258CA79FCE8127789B8A196F5E12F0_2107488641 =         put(name, value);
        varF4258CA79FCE8127789B8A196F5E12F0_2107488641.addTaint(taint);
        return varF4258CA79FCE8127789B8A196F5E12F0_2107488641;
        // ---------- Original Method ----------
        //return put(name, value);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.331 -0400", hash_original_method = "97010F07EC41CFBEB746B7A1A80A2C1A", hash_generated_method = "1848F7881E3CEF4A766A0A5ACFE66A19")
    public synchronized void store(OutputStream out, String comment) throws IOException {
        addTaint(comment.getTaint());
        addTaint(out.getTaint());
        store(new OutputStreamWriter(out, "ISO-8859-1"), comment);
        // ---------- Original Method ----------
        //store(new OutputStreamWriter(out, "ISO-8859-1"), comment);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.332 -0400", hash_original_method = "8076CC1A9EBA7B35E4BEA25CCAC41B73", hash_generated_method = "9CBEEA0A0BD6CBEF5B88B71D71A9DCE4")
    public synchronized void store(Writer writer, String comment) throws IOException {
        addTaint(comment.getTaint());
        addTaint(writer.getTaint());
    if(comment != null)        
        {
            writer.write("#");
            writer.write(comment);
            writer.write(System.lineSeparator());
        } //End block
        writer.write("#");
        writer.write(new Date().toString());
        writer.write(System.lineSeparator());
        StringBuilder sb = new StringBuilder(200);
for(Map.Entry<Object, Object> entry : entrySet())
        {
            String key = (String) entry.getKey();
            dumpString(sb, key, true);
            sb.append('=');
            dumpString(sb, (String) entry.getValue(), false);
            sb.append(System.lineSeparator());
            writer.write(sb.toString());
            sb.setLength(0);
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.335 -0400", hash_original_method = "2CD21803BBD0B22DE3395585690DDBAE", hash_generated_method = "68FD53FEB1F37E315AC5F25728A2F061")
    public synchronized void loadFromXML(InputStream in) throws IOException,
            InvalidPropertiesFormatException {
        addTaint(in.getTaint());
    if(in == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1760072058 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1760072058.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1760072058;
        } //End block
    if(builder == null)        
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            try 
            {
                builder = factory.newDocumentBuilder();
            } //End block
            catch (ParserConfigurationException e)
            {
                Error varD7D5CC05F351C45F26A7F84C2C962F04_658518519 = new Error(e);
                varD7D5CC05F351C45F26A7F84C2C962F04_658518519.addTaint(taint);
                throw varD7D5CC05F351C45F26A7F84C2C962F04_658518519;
            } //End block
            builder.setErrorHandler(new ErrorHandler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.333 -0400", hash_original_method = "A780B405018C6E806DD90859BE935681", hash_generated_method = "A585F38429FF8D5BBD722B25895B6137")
        public void warning(SAXParseException e) throws SAXException {
            addTaint(e.getTaint());
            e.addTaint(taint);
            throw e;
            // ---------- Original Method ----------
            //throw e;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.333 -0400", hash_original_method = "1BA627FA566198BCA8957A882673AC06", hash_generated_method = "377AAD29C1633EC96EC6B447775EDD25")
        public void error(SAXParseException e) throws SAXException {
            addTaint(e.getTaint());
            e.addTaint(taint);
            throw e;
            // ---------- Original Method ----------
            //throw e;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.334 -0400", hash_original_method = "3CBD306431C0846BE7A7FBEF3B9920DA", hash_generated_method = "0179C6E37915287522939865529DEE7D")
        public void fatalError(SAXParseException e) throws SAXException {
            addTaint(e.getTaint());
            e.addTaint(taint);
            throw e;
            // ---------- Original Method ----------
            //throw e;
        }
});
            builder.setEntityResolver(new EntityResolver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.334 -0400", hash_original_method = "7B6D510D74072B007F41B0B5792E868F", hash_generated_method = "7EF1BF11E852B4AA7FC3CFB1E1E44ED8")
        public InputSource resolveEntity(String publicId,
                        String systemId) throws SAXException, IOException {
            addTaint(systemId.getTaint());
            addTaint(publicId.getTaint());
    if(systemId.equals(PROP_DTD_NAME))            
            {
                InputSource result = new InputSource(new StringReader(
                                PROP_DTD));
                result.setSystemId(PROP_DTD_NAME);
InputSource varDC838461EE2FA0CA4C9BBB70A15456B0_782419023 =                 result;
                varDC838461EE2FA0CA4C9BBB70A15456B0_782419023.addTaint(taint);
                return varDC838461EE2FA0CA4C9BBB70A15456B0_782419023;
            } //End block
            SAXException var276054049D12298E733DD841025C1A71_2056436551 = new SAXException("Invalid DOCTYPE declaration: "
                            + systemId);
            var276054049D12298E733DD841025C1A71_2056436551.addTaint(taint);
            throw var276054049D12298E733DD841025C1A71_2056436551;
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
            Document doc = builder.parse(in);
            NodeList entries = doc.getElementsByTagName("entry");
    if(entries == null)            
            {
                return;
            } //End block
            int entriesListLength = entries.getLength();
for(int i = 0;i < entriesListLength;i++)
            {
                Element entry = (Element) entries.item(i);
                String key = entry.getAttribute("key");
                String value = entry.getTextContent();
                put(key, value);
            } //End block
        } //End block
        catch (IOException e)
        {
            e.addTaint(taint);
            throw e;
        } //End block
        catch (SAXException e)
        {
            InvalidPropertiesFormatException var764BEE11ACAB04F9CC0D2D21744DD45D_990395283 = new InvalidPropertiesFormatException(e);
            var764BEE11ACAB04F9CC0D2D21744DD45D_990395283.addTaint(taint);
            throw var764BEE11ACAB04F9CC0D2D21744DD45D_990395283;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.336 -0400", hash_original_method = "CF08828D5EA0BDD9B2ACD5D46AA8D14C", hash_generated_method = "B717234FF9BED9A1726641D81063AE94")
    public void storeToXML(OutputStream os, String comment) throws IOException {
        addTaint(comment.getTaint());
        addTaint(os.getTaint());
        storeToXML(os, comment, "UTF-8");
        // ---------- Original Method ----------
        //storeToXML(os, comment, "UTF-8");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.337 -0400", hash_original_method = "88C35F171CF08E9C818A3957B761A932", hash_generated_method = "82DD2AE5784E0BE797FA0BD1DB1821E1")
    public synchronized void storeToXML(OutputStream os, String comment,
            String encoding) throws IOException {
        addTaint(encoding.getTaint());
        addTaint(comment.getTaint());
        addTaint(os.getTaint());
    if(os == null || encoding == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1233380493 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1233380493.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1233380493;
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
        PrintStream printStream = new PrintStream(os, false,
                encodingCanonicalName);
        printStream.print("<?xml version=\"1.0\" encoding=\"");
        printStream.print(encodingCanonicalName);
        printStream.println("\"?>");
        printStream.print("<!DOCTYPE properties SYSTEM \"");
        printStream.print(PROP_DTD_NAME);
        printStream.println("\">");
        printStream.println("<properties>");
    if(comment != null)        
        {
            printStream.print("<comment>");
            printStream.print(substitutePredefinedEntries(comment));
            printStream.println("</comment>");
        } //End block
for(Map.Entry<Object, Object> entry : entrySet())
        {
            String keyValue = (String) entry.getKey();
            String entryValue = (String) entry.getValue();
            printStream.print("<entry key=\"");
            printStream.print(substitutePredefinedEntries(keyValue));
            printStream.print("\">");
            printStream.print(substitutePredefinedEntries(entryValue));
            printStream.println("</entry>");
        } //End block
        printStream.println("</properties>");
        printStream.flush();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.338 -0400", hash_original_method = "C245FBB3FF946795FFB47FE71F12C3B1", hash_generated_method = "E07D31756838EB6FA0C9348366079EA4")
    private String substitutePredefinedEntries(String s) {
        addTaint(s.getTaint());
        s = s.replaceAll("&", "&amp;");
        s = s.replaceAll("<", "&lt;");
        s = s.replaceAll(">", "&gt;");
        s = s.replaceAll("'", "&apos;");
        s = s.replaceAll("\"", "&quot;");
String var0478718F0636FB61899C13801CE9FE09_1750781808 =         s;
        var0478718F0636FB61899C13801CE9FE09_1750781808.addTaint(taint);
        return var0478718F0636FB61899C13801CE9FE09_1750781808;
        // ---------- Original Method ----------
        //s = s.replaceAll("&", "&amp;");
        //s = s.replaceAll("<", "&lt;");
        //s = s.replaceAll(">", "&gt;");
        //s = s.replaceAll("'", "&apos;");
        //s = s.replaceAll("\"", "&quot;");
        //return s;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.338 -0400", hash_original_field = "3E7ACF4375E68B6EA0BCA2BE83B25596", hash_generated_field = "B9B3DC636549D3041EBFB366A6464B2E")

    private static final long serialVersionUID = 4112578634029874840L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.338 -0400", hash_original_field = "950AEF4954A3EB33D8EA9CE52A6C7335", hash_generated_field = "6EB68577AA63C8CE23A5572AC9077D85")

    private static final String PROP_DTD_NAME = "http://java.sun.com/dtd/properties.dtd";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.338 -0400", hash_original_field = "60953D0FB090018CDD85598651263315", hash_generated_field = "12D66A953921A104006A54797CCD01D0")

    private static final String PROP_DTD = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
            + "    <!ELEMENT properties (comment?, entry*) >"
            + "    <!ATTLIST properties version CDATA #FIXED \"1.0\" >"
            + "    <!ELEMENT comment (#PCDATA) >"
            + "    <!ELEMENT entry (#PCDATA) >"
            + "    <!ATTLIST entry key CDATA #REQUIRED >";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.338 -0400", hash_original_field = "4F2536D0D627A82B4C8A0BFFFEFBF7DA", hash_generated_field = "76E820B599FE28B3403AD7E6FB9DE931")

    private static final int NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.339 -0400", hash_original_field = "891D8F71F28248053B8F5A2BAE3EEDD4", hash_generated_field = "A660E479CB11A03AEF0EBDF15B325E19")

    private static final int SLASH = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.339 -0400", hash_original_field = "27BBE49DEAA2708F51AB22AF9E02694A", hash_generated_field = "279F3AC27643FBAD4A1141944F156982")

    private static final int UNICODE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.339 -0400", hash_original_field = "3EEE4D5909DE4458D87CC1DBB27D23E8", hash_generated_field = "6A88BA6F8613415BC01634427DC9E4C4")

    private static final int CONTINUE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.339 -0400", hash_original_field = "F06DF84D977CB8AE06C888CA7E01B4E2", hash_generated_field = "03E2C41D67B733CE677B61203540AA72")

    private static final int KEY_DONE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.339 -0400", hash_original_field = "2244D293D67AF3EF08FD93F9C1A68030", hash_generated_field = "BB2FAFE0C6AEB56E9A6250AD961B8C45")

    private static final int IGNORE = 5;
}

