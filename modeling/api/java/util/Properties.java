package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class Properties extends Hashtable<Object, Object> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.643 -0500", hash_original_field = "BA688B944BBA15F59D0A59A7FE9F7ACD", hash_generated_field = "B9B3DC636549D3041EBFB366A6464B2E")

    private static final long serialVersionUID = 4112578634029874840L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.647 -0500", hash_original_field = "394FA6EC18447760AEBCB3606F9106F9", hash_generated_field = "6EB68577AA63C8CE23A5572AC9077D85")

    private static final String PROP_DTD_NAME = "http://java.sun.com/dtd/properties.dtd";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.650 -0500", hash_original_field = "3B34675D0BD1B6C926F86DE4D2BA9D9C", hash_generated_field = "12D66A953921A104006A54797CCD01D0")

    private static final String PROP_DTD = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
            + "    <!ELEMENT properties (comment?, entry*) >"
            + "    <!ATTLIST properties version CDATA #FIXED \"1.0\" >"
            + "    <!ELEMENT comment (#PCDATA) >"
            + "    <!ELEMENT entry (#PCDATA) >"
            + "    <!ATTLIST entry key CDATA #REQUIRED >";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.438 -0400", hash_original_field = "4F2536D0D627A82B4C8A0BFFFEFBF7DA", hash_generated_field = "76E820B599FE28B3403AD7E6FB9DE931")

    private static final int NONE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.438 -0400", hash_original_field = "891D8F71F28248053B8F5A2BAE3EEDD4", hash_generated_field = "A660E479CB11A03AEF0EBDF15B325E19")

    private static final int SLASH = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.438 -0400", hash_original_field = "27BBE49DEAA2708F51AB22AF9E02694A", hash_generated_field = "279F3AC27643FBAD4A1141944F156982")

    private static final int UNICODE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.438 -0400", hash_original_field = "3EEE4D5909DE4458D87CC1DBB27D23E8", hash_generated_field = "6A88BA6F8613415BC01634427DC9E4C4")

    private static final int CONTINUE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.438 -0400", hash_original_field = "F06DF84D977CB8AE06C888CA7E01B4E2", hash_generated_field = "03E2C41D67B733CE677B61203540AA72")

    private static final int KEY_DONE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.438 -0400", hash_original_field = "2244D293D67AF3EF08FD93F9C1A68030", hash_generated_field = "BB2FAFE0C6AEB56E9A6250AD961B8C45")

    private static final int IGNORE = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.645 -0500", hash_original_field = "CEC094AA6BF918752009818D630EB1FD", hash_generated_field = "FD91B16F92409AD1E464978ACF6CCD28")

    private transient DocumentBuilder builder = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.652 -0500", hash_original_field = "ED6F441B204B59837D765FE7BF823FA6", hash_generated_field = "FFB6C63B9AE394F9A7BA81EBAD128C5B")

    protected Properties defaults;

    /**
     * Constructs a new {@code Properties} object.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.658 -0500", hash_original_method = "15BC7402B615AC640D692CA8D591C86A", hash_generated_method = "7795BAC062AED72B959D89678A199367")
    
public Properties() {
    }

    /**
     * Constructs a new {@code Properties} object using the specified default
     * {@code Properties}.
     *
     * @param properties
     *            the default {@code Properties}.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.661 -0500", hash_original_method = "5F2D706A0CAB1895C5A727D855C46322", hash_generated_method = "6B25AC4C2F6728C40E756CFE46A2AEED")
    
public Properties(Properties properties) {
        defaults = properties;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.664 -0500", hash_original_method = "8670FB32C289DA514C35A14528148A6D", hash_generated_method = "AD797BDA8958849190F0E26D2B0F2B59")
    
private void dumpString(StringBuilder buffer, String string, boolean key) {
        int i = 0;
        if (!key && i < string.length() && string.charAt(i) == ' ') {
            buffer.append("\\ ");
            i++;
        }

        for (; i < string.length(); i++) {
            char ch = string.charAt(i);
            switch (ch) {
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
                if ("\\#!=:".indexOf(ch) >= 0 || (key && ch == ' ')) {
                    buffer.append('\\');
                }
                if (ch >= ' ' && ch <= '~') {
                    buffer.append(ch);
                } else {
                    String hex = Integer.toHexString(ch);
                    buffer.append("\\u");
                    for (int j = 0; j < 4 - hex.length(); j++) {
                        buffer.append("0");
                    }
                    buffer.append(hex);
                }
            }
        }
    }

    /**
     * Searches for the property with the specified name. If the property is not
     * found, the default {@code Properties} are checked. If the property is not
     * found in the default {@code Properties}, {@code null} is returned.
     *
     * @param name
     *            the name of the property to find.
     * @return the named property value, or {@code null} if it can't be found.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.666 -0500", hash_original_method = "B2B08C7B9AD3334D72416F92376E272C", hash_generated_method = "FE43F53EBFA7D65B5C53EC5509BBE58A")
    
public String getProperty(String name) {
        Object result = super.get(name);
        String property = result instanceof String ? (String) result : null;
        if (property == null && defaults != null) {
            property = defaults.getProperty(name);
        }
        return property;
    }

    /**
     * Searches for the property with the specified name. If the property is not
     * found, it looks in the default {@code Properties}. If the property is not
     * found in the default {@code Properties}, it returns the specified
     * default.
     *
     * @param name
     *            the name of the property to find.
     * @param defaultValue
     *            the default value.
     * @return the named property value.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.668 -0500", hash_original_method = "3601550743DD7ED6E54F365D9B667C39", hash_generated_method = "C6113C6A35092CBD196D8546F6153BFC")
    
public String getProperty(String name, String defaultValue) {
        Object result = super.get(name);
        String property = result instanceof String ? (String) result : null;
        if (property == null && defaults != null) {
            property = defaults.getProperty(name);
        }
        if (property == null) {
            return defaultValue;
        }
        return property;
    }

    /**
     * Lists the mappings in this {@code Properties} to {@code out} in a human-readable form.
     * Note that values are truncated to 37 characters, so this method is rarely useful.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.670 -0500", hash_original_method = "C9FDCBF4B35B89B1D79FB5B2779CDC77", hash_generated_method = "27BBBF78C9C7B66CC25786B094817EAF")
    
public void list(PrintStream out) {
        listToAppendable(out);
    }

    /**
     * Lists the mappings in this {@code Properties} to {@code out} in a human-readable form.
     * Note that values are truncated to 37 characters, so this method is rarely useful.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.672 -0500", hash_original_method = "2577CE734D2D6BD05EB3CE3808D03445", hash_generated_method = "1FA778C7F4AB37BE4F17095F5BD082BA")
    
public void list(PrintWriter out) {
        listToAppendable(out);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.676 -0500", hash_original_method = "68CAE489B2B77D788FAF807067B604BA", hash_generated_method = "ABEBE0DA40E4B91C3DFCF5DB4AF1855C")
    
private void listToAppendable(Appendable out) {
        try {
            if (out == null) {
                throw new NullPointerException("out == null");
            }
            StringBuilder sb = new StringBuilder(80);
            Enumeration<?> keys = propertyNames();
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                sb.append(key);
                sb.append('=');
                String property = (String) super.get(key);
                Properties def = defaults;
                while (property == null) {
                    property = (String) def.get(key);
                    def = def.defaults;
                }
                if (property.length() > 40) {
                    sb.append(property.substring(0, 37));
                    sb.append("...");
                } else {
                    sb.append(property);
                }
                sb.append(System.lineSeparator());
                out.append(sb.toString());
                sb.setLength(0);
            }
        } catch (IOException ex) {
            // Appendable.append throws IOException, but PrintStream and PrintWriter don't.
            throw new AssertionError(ex);
        }
    }

    /**
     * Loads properties from the specified {@code InputStream}, assumed to be ISO-8859-1.
     * See "<a href="#character_encoding">Character Encoding</a>".
     *
     * @param in the {@code InputStream}
     * @throws IOException
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.679 -0500", hash_original_method = "B8EDE929B09671D07A2F603EF776CD24", hash_generated_method = "ABC75A374DCCE012A8512AE368C0A34C")
    
public synchronized void load(InputStream in) throws IOException {
        if (in == null) {
            throw new NullPointerException();
        }
        load(new InputStreamReader(in, "ISO-8859-1"));
    }

    /**
     * Loads properties from the specified {@code Reader}.
     * The properties file is interpreted according to the following rules:
     * <ul>
     * <li>Empty lines are ignored.</li>
     * <li>Lines starting with either a "#" or a "!" are comment lines and are
     * ignored.</li>
     * <li>A backslash at the end of the line escapes the following newline
     * character ("\r", "\n", "\r\n"). If there's whitespace after the
     * backslash it will just escape that whitespace instead of concatenating
     * the lines. This does not apply to comment lines.</li>
     * <li>A property line consists of the key, the space between the key and
     * the value, and the value. The key goes up to the first whitespace, "=" or
     * ":" that is not escaped. The space between the key and the value contains
     * either one whitespace, one "=" or one ":" and any amount of additional
     * whitespace before and after that character. The value starts with the
     * first character after the space between the key and the value.</li>
     * <li>Following escape sequences are recognized: "\ ", "\\", "\r", "\n",
     * "\!", "\#", "\t", "\b", "\f", and "&#92;uXXXX" (unicode character).</li>
     * </ul>
     *
     * @param in the {@code Reader}
     * @throws IOException
     * @since 1.6
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.684 -0500", hash_original_method = "3CECE8DDCAF4401F719C3D407BA79CAE", hash_generated_method = "D0BF6D33A4A91FE458CF6CCAAAA791D1")
    
@SuppressWarnings("fallthrough")
    public synchronized void load(Reader in) throws IOException {
        if (in == null) {
            throw new NullPointerException();
        }
        int mode = NONE, unicode = 0, count = 0;
        char nextChar, buf[] = new char[40];
        int offset = 0, keyLength = -1, intVal;
        boolean firstChar = true;

        BufferedReader br = new BufferedReader(in);

        while (true) {
            intVal = br.read();
            if (intVal == -1) {
                break;
            }
            nextChar = (char) intVal;

            if (offset == buf.length) {
                char[] newBuf = new char[buf.length * 2];
                System.arraycopy(buf, 0, newBuf, 0, offset);
                buf = newBuf;
            }
            if (mode == UNICODE) {
                int digit = Character.digit(nextChar, 16);
                if (digit >= 0) {
                    unicode = (unicode << 4) + digit;
                    if (++count < 4) {
                        continue;
                    }
                } else if (count <= 4) {
                    throw new IllegalArgumentException("Invalid Unicode sequence: illegal character");
                }
                mode = NONE;
                buf[offset++] = (char) unicode;
                if (nextChar != '\n') {
                    continue;
                }
            }
            if (mode == SLASH) {
                mode = NONE;
                switch (nextChar) {
                case '\r':
                    mode = CONTINUE; // Look for a following \n
                    continue;
                case '\n':
                    mode = IGNORE; // Ignore whitespace on the next line
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
            } else {
                switch (nextChar) {
                case '#':
                case '!':
                    if (firstChar) {
                        while (true) {
                            intVal = br.read();
                            if (intVal == -1) {
                                break;
                            }
                            nextChar = (char) intVal;
                            if (nextChar == '\r' || nextChar == '\n') {
                                break;
                            }
                        }
                        continue;
                    }
                    break;
                case '\n':
                    if (mode == CONTINUE) { // Part of a \r\n sequence
                        mode = IGNORE; // Ignore whitespace on the next line
                        continue;
                    }
                    // fall into the next case
                case '\r':
                    mode = NONE;
                    firstChar = true;
                    if (offset > 0 || (offset == 0 && keyLength == 0)) {
                        if (keyLength == -1) {
                            keyLength = offset;
                        }
                        String temp = new String(buf, 0, offset);
                        put(temp.substring(0, keyLength), temp
                                .substring(keyLength));
                    }
                    keyLength = -1;
                    offset = 0;
                    continue;
                case '\\':
                    if (mode == KEY_DONE) {
                        keyLength = offset;
                    }
                    mode = SLASH;
                    continue;
                case ':':
                case '=':
                    if (keyLength == -1) { // if parsing the key
                        mode = NONE;
                        keyLength = offset;
                        continue;
                    }
                    break;
                }
                if (Character.isWhitespace(nextChar)) {
                    if (mode == CONTINUE) {
                        mode = IGNORE;
                    }
                    // if key length == 0 or value length == 0
                    if (offset == 0 || offset == keyLength || mode == IGNORE) {
                        continue;
                    }
                    if (keyLength == -1) { // if parsing the key
                        mode = KEY_DONE;
                        continue;
                    }
                }
                if (mode == IGNORE || mode == CONTINUE) {
                    mode = NONE;
                }
            }
            firstChar = false;
            if (mode == KEY_DONE) {
                keyLength = offset;
                mode = NONE;
            }
            buf[offset++] = nextChar;
        }
        if (mode == UNICODE && count <= 4) {
            throw new IllegalArgumentException("Invalid Unicode sequence: expected format \\uxxxx");
        }
        if (keyLength == -1 && offset > 0) {
            keyLength = offset;
        }
        if (keyLength >= 0) {
            String temp = new String(buf, 0, offset);
            String key = temp.substring(0, keyLength);
            String value = temp.substring(keyLength);
            if (mode == SLASH) {
                value += "\u0000";
            }
            put(key, value);
        }
    }

    /**
     * Returns all of the property names (keys) in this {@code Properties} object.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.687 -0500", hash_original_method = "1BF2C237B8DD3958FB1B8B5C0AE1938E", hash_generated_method = "DF74DE310FA8CC69912084B9A763044F")
    
public Enumeration<?> propertyNames() {
        Hashtable<Object, Object> selected = new Hashtable<Object, Object>();
        selectProperties(selected, false);
        return selected.keys();
    }

    /**
     * Returns those property names (keys) in this {@code Properties} object for which
     * both key and value are strings.
     *
     * @return a set of keys in the property list
     * @since 1.6
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.689 -0500", hash_original_method = "3F48821B050A70D7E4FF424CB7AEEF4F", hash_generated_method = "4A180296BFD4FFE6723C6460EBAAC04D")
    
public Set<String> stringPropertyNames() {
        Hashtable<String, Object> stringProperties = new Hashtable<String, Object>();
        selectProperties(stringProperties, true);
        return Collections.unmodifiableSet(stringProperties.keySet());
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.432 -0400", hash_original_method = "A87BE62C7A489C0C3750546357B411C0", hash_generated_method = "0A8899B8A69A32A18E613C9F0DB4012D")
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

    /**
     * Saves the mappings in this {@code Properties} to the specified {@code
     * OutputStream}, putting the specified comment at the beginning. The output
     * from this method is suitable for being read by the
     * {@link #load(InputStream)} method.
     *
     * @param out the {@code OutputStream} to write to.
     * @param comment the comment to add at the beginning.
     * @throws ClassCastException if the key or value of a mapping is not a
     *                String.
     * @deprecated This method ignores any {@code IOException} thrown while
     *             writing -- use {@link #store} instead for better exception
     *             handling.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.694 -0500", hash_original_method = "4460892848C3864FEFFB544B0F6CDF7A", hash_generated_method = "1BF756A007554B5ED33DCC871BAE1B22")
    
@Deprecated
    public void save(OutputStream out, String comment) {
        try {
            store(out, comment);
        } catch (IOException e) {
        }
    }

    /**
     * Maps the specified key to the specified value. If the key already exists,
     * the old value is replaced. The key and value cannot be {@code null}.
     *
     * @param name
     *            the key.
     * @param value
     *            the value.
     * @return the old value mapped to the key, or {@code null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.696 -0500", hash_original_method = "B5A66BBC4F63569C92BD357B6A0BCEAB", hash_generated_method = "56F4E85497B4F5EC660B941BA40CCE46")
    
public Object setProperty(String name, String value) {
        return put(name, value);
    }

    /**
     * Stores properties to the specified {@code OutputStream}, using ISO-8859-1.
     * See "<a href="#character_encoding">Character Encoding</a>".
     *
     * @param out the {@code OutputStream}
     * @param comment an optional comment to be written, or null
     * @throws IOException
     * @throws ClassCastException if a key or value is not a string
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.699 -0500", hash_original_method = "97010F07EC41CFBEB746B7A1A80A2C1A", hash_generated_method = "646D9E8375B20D6B807EFFBEEE3722CD")
    
public synchronized void store(OutputStream out, String comment) throws IOException {
        store(new OutputStreamWriter(out, "ISO-8859-1"), comment);
    }

    /**
     * Stores the mappings in this {@code Properties} object to {@code out},
     * putting the specified comment at the beginning.
     *
     * @param writer the {@code Writer}
     * @param comment an optional comment to be written, or null
     * @throws IOException
     * @throws ClassCastException if a key or value is not a string
     * @since 1.6
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.702 -0500", hash_original_method = "8076CC1A9EBA7B35E4BEA25CCAC41B73", hash_generated_method = "525ADF1180D463C4ACA782A1639904CB")
    
public synchronized void store(Writer writer, String comment) throws IOException {
        if (comment != null) {
            writer.write("#");
            writer.write(comment);
            writer.write(System.lineSeparator());
        }
        writer.write("#");
        writer.write(new Date().toString());
        writer.write(System.lineSeparator());

        StringBuilder sb = new StringBuilder(200);
        for (Map.Entry<Object, Object> entry : entrySet()) {
            String key = (String) entry.getKey();
            dumpString(sb, key, true);
            sb.append('=');
            dumpString(sb, (String) entry.getValue(), false);
            sb.append(System.lineSeparator());
            writer.write(sb.toString());
            sb.setLength(0);
        }
        writer.flush();
    }
        
@DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.436 -0400", hash_original_method = "2CD21803BBD0B22DE3395585690DDBAE", hash_generated_method = "B1418958B0758A3E1EA0E924AE7F14B1")
    public synchronized void loadFromXML(InputStream in) throws IOException,
            InvalidPropertiesFormatException {
        addTaint(in.getTaint());
        if(in == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_511171775 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_511171775.addTaint(getTaint());
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_511171775;
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
                Error varD7D5CC05F351C45F26A7F84C2C962F04_883337655 = new Error(e);
                varD7D5CC05F351C45F26A7F84C2C962F04_883337655.addTaint(getTaint());
                throw varD7D5CC05F351C45F26A7F84C2C962F04_883337655;
            } //End block
            builder.setErrorHandler(new ErrorHandler() {
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.705 -0500", hash_original_method = "A780B405018C6E806DD90859BE935681", hash_generated_method = "5DADC32ECCFAECCD4F18AF4B73111C38")
                
public void warning(SAXParseException e) throws SAXException {
                    throw e;
                }

                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.708 -0500", hash_original_method = "1BA627FA566198BCA8957A882673AC06", hash_generated_method = "D10193ADE3BD34266E46CB7EF385B5B4")
                
public void error(SAXParseException e) throws SAXException {
                    throw e;
                }

                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.711 -0500", hash_original_method = "3CBD306431C0846BE7A7FBEF3B9920DA", hash_generated_method = "8BE9290E5A78003CD3400FC7458B6660")
                
public void fatalError(SAXParseException e) throws SAXException {
                    throw e;
                }
});
            builder.setEntityResolver(new EntityResolver() {
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.714 -0500", hash_original_method = "7B6D510D74072B007F41B0B5792E868F", hash_generated_method = "6BFCF27FC3FC55DC302EBDECB3B9D81A")
                
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
            e.addTaint(getTaint());
            throw e;
        } //End block
        catch (SAXException e)
        {
            InvalidPropertiesFormatException var764BEE11ACAB04F9CC0D2D21744DD45D_1659499523 = new InvalidPropertiesFormatException(e);
            var764BEE11ACAB04F9CC0D2D21744DD45D_1659499523.addTaint(getTaint());
            throw var764BEE11ACAB04F9CC0D2D21744DD45D_1659499523;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    /**
     * Writes all properties stored in this instance into the {@code
     * OutputStream} in XML representation. The DOCTYPE is
     *
     * <pre>
     * &lt;!DOCTYPE properties SYSTEM &quot;http://java.sun.com/dtd/properties.dtd&quot;&gt;
     * </pre>
     *
     * If the comment is null, no comment is added to the output. UTF-8 is used
     * as the encoding. The {@code OutputStream} is not closed at the end. A
     * call to this method is the same as a call to {@code storeToXML(os,
     * comment, "UTF-8")}.
     *
     * @param os the {@code OutputStream} to write to.
     * @param comment the comment to add. If null, no comment is added.
     * @throws IOException if an error occurs during writing to the output.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.720 -0500", hash_original_method = "CF08828D5EA0BDD9B2ACD5D46AA8D14C", hash_generated_method = "01C07DD124F02978143E065FA8AE7B2B")
    
public void storeToXML(OutputStream os, String comment) throws IOException {
        storeToXML(os, comment, "UTF-8");
    }

    /**
     * Writes all properties stored in this instance into the {@code
     * OutputStream} in XML representation. The DOCTYPE is
     *
     * <pre>
     * &lt;!DOCTYPE properties SYSTEM &quot;http://java.sun.com/dtd/properties.dtd&quot;&gt;
     * </pre>
     *
     * If the comment is null, no comment is added to the output. The parameter
     * {@code encoding} defines which encoding should be used. The {@code
     * OutputStream} is not closed at the end.
     *
     * @param os the {@code OutputStream} to write to.
     * @param comment the comment to add. If null, no comment is added.
     * @param encoding the code identifying the encoding that should be used to
     *            write into the {@code OutputStream}.
     * @throws IOException if an error occurs during writing to the output.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.724 -0500", hash_original_method = "88C35F171CF08E9C818A3957B761A932", hash_generated_method = "314055A6A376FFCBC591266AF54683BD")
    
public synchronized void storeToXML(OutputStream os, String comment,
            String encoding) throws IOException {

        if (os == null || encoding == null) {
            throw new NullPointerException();
        }

        /*
         * We can write to XML file using encoding parameter but note that some
         * aliases for encodings are not supported by the XML parser. Thus we
         * have to know canonical name for encoding used to store data in XML
         * since the XML parser must recognize encoding name used to store data.
         */

        String encodingCanonicalName;
        try {
            encodingCanonicalName = Charset.forName(encoding).name();
        } catch (IllegalCharsetNameException e) {
            System.out.println("Warning: encoding name " + encoding
                    + " is illegal, using UTF-8 as default encoding");
            encodingCanonicalName = "UTF-8";
        } catch (UnsupportedCharsetException e) {
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

        if (comment != null) {
            printStream.print("<comment>");
            printStream.print(substitutePredefinedEntries(comment));
            printStream.println("</comment>");
        }

        for (Map.Entry<Object, Object> entry : entrySet()) {
            String keyValue = (String) entry.getKey();
            String entryValue = (String) entry.getValue();
            printStream.print("<entry key=\"");
            printStream.print(substitutePredefinedEntries(keyValue));
            printStream.print("\">");
            printStream.print(substitutePredefinedEntries(entryValue));
            printStream.println("</entry>");
        }
        printStream.println("</properties>");
        printStream.flush();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:41.726 -0500", hash_original_method = "C245FBB3FF946795FFB47FE71F12C3B1", hash_generated_method = "E762A0C9495B2E72FE293E3B09EADF7B")
    
private String substitutePredefinedEntries(String s) {
        // substitution for predefined character entities to use them safely in XML.
        s = s.replaceAll("&", "&amp;");
        s = s.replaceAll("<", "&lt;");
        s = s.replaceAll(">", "&gt;");
        s = s.replaceAll("'", "&apos;");
        s = s.replaceAll("\"", "&quot;");
        return s;
    }
}

