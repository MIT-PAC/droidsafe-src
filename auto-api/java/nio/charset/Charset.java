package java.nio.charset;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.spi.CharsetProvider;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import libcore.icu.NativeConverter;

public abstract class Charset implements Comparable<Charset> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.735 -0400", hash_original_field = "3FD37E7C1754DA8004AB09E17AD51B85", hash_generated_field = "4394C126BF71D5F3C3D84B833D0FB596")

    private String canonicalName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.735 -0400", hash_original_field = "496C43E2A9F7F1C8928D93EF34796C9E", hash_generated_field = "94A607030E0CCDFE52CAD878DD81F6F9")

    private HashSet<String> aliasesSet;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.762 -0400", hash_original_method = "70538FAF149E20AD4492F643DB83EDCB", hash_generated_method = "846B040F3125F389F72A7E8E1C98D567")
    protected  Charset(String canonicalName, String[] aliases) {
        checkCharsetName(canonicalName);
        this.canonicalName = canonicalName;
        this.aliasesSet = new HashSet<String>();
        {
            {
                Iterator<String> var06384BB0465CAA9396B17F3A4E2F7242_1563101891 = (aliases).iterator();
                var06384BB0465CAA9396B17F3A4E2F7242_1563101891.hasNext();
                String alias = var06384BB0465CAA9396B17F3A4E2F7242_1563101891.next();
                {
                    checkCharsetName(alias);
                    this.aliasesSet.add(alias);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(aliases[0].getTaint());
        // ---------- Original Method ----------
        //checkCharsetName(canonicalName);
        //this.canonicalName = canonicalName;
        //this.aliasesSet = new HashSet<String>();
        //if (aliases != null) {
            //for (String alias : aliases) {
                //checkCharsetName(alias);
                //this.aliasesSet.add(alias);
            //}
        //}
    }

    
        private static void checkCharsetName(String name) {
        if (name.isEmpty()) {
            throw new IllegalCharsetNameException(name);
        }
        int length = name.length();
        for (int i = 0; i < length; ++i) {
            if (!isValidCharsetNameCharacter(name.charAt(i))) {
                throw new IllegalCharsetNameException(name);
            }
        }
    }

    
        private static boolean isValidCharsetNameCharacter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') ||
                c == '-' || c == '.' || c == ':' || c == '_';
    }

    
        public static SortedMap<String, Charset> availableCharsets() {
        TreeMap<String, Charset> charsets = new TreeMap<String, Charset>(String.CASE_INSENSITIVE_ORDER);
        for (String charsetName : NativeConverter.getAvailableCharsetNames()) {
            Charset charset = NativeConverter.charsetForName(charsetName);
            charsets.put(charset.name(), charset);
        }
        for (CharsetProvider charsetProvider : ServiceLoader.load(CharsetProvider.class)) {
            Iterator<Charset> it = charsetProvider.charsets();
            while (it.hasNext()) {
                Charset cs = it.next();
                if (!charsets.containsKey(cs.name())) {
                    charsets.put(cs.name(), cs);
                }
            }
        }
        return Collections.unmodifiableSortedMap(charsets);
    }

    
        private static Charset cacheCharset(String charsetName, Charset cs) {
        synchronized (CACHED_CHARSETS) {
            String canonicalName = cs.name();
            Charset canonicalCharset = CACHED_CHARSETS.get(canonicalName);
            if (canonicalCharset == null) {
                canonicalCharset = cs;
            }
            CACHED_CHARSETS.put(canonicalName, canonicalCharset);
            CACHED_CHARSETS.put(charsetName, canonicalCharset);
            for (String alias : cs.aliasesSet) {
                CACHED_CHARSETS.put(alias, canonicalCharset);
            }
            return canonicalCharset;
        }
    }

    
        public static Charset forName(String charsetName) {
        Charset cs;
        synchronized (CACHED_CHARSETS) {
            cs = CACHED_CHARSETS.get(charsetName);
            if (cs != null) {
                return cs;
            }
        }
        if (charsetName == null) {
            throw new IllegalCharsetNameException(null);
        }
        checkCharsetName(charsetName);
        cs = NativeConverter.charsetForName(charsetName);
        if (cs != null) {
            return cacheCharset(charsetName, cs);
        }
        for (CharsetProvider charsetProvider : ServiceLoader.load(CharsetProvider.class)) {
            cs = charsetProvider.charsetForName(charsetName);
            if (cs != null) {
                return cacheCharset(charsetName, cs);
            }
        }
        throw new UnsupportedCharsetException(charsetName);
    }

    
        public static Charset forNameUEE(String charsetName) throws UnsupportedEncodingException {
        try {
            return Charset.forName(charsetName);
        } catch (Exception cause) {
            UnsupportedEncodingException ex = new UnsupportedEncodingException(charsetName);
            ex.initCause(cause);
            throw ex;
        }
    }

    
        public static boolean isSupported(String charsetName) {
        try {
            forName(charsetName);
            return true;
        } catch (UnsupportedCharsetException ex) {
            return false;
        }
    }

    
    public abstract boolean contains(Charset charset);

    
    public abstract CharsetEncoder newEncoder();

    
    public abstract CharsetDecoder newDecoder();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.764 -0400", hash_original_method = "C591AF6945C669FCF4033528E86B2077", hash_generated_method = "6A82F6558E93F49D6C461E56D0E49DF4")
    public final String name() {
        String varB4EAC82CA7396A68D541C85D26508E83_1552548279 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1552548279 = this.canonicalName;
        varB4EAC82CA7396A68D541C85D26508E83_1552548279.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1552548279;
        // ---------- Original Method ----------
        //return this.canonicalName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.779 -0400", hash_original_method = "9500673A94BC6D8C4BDA9785EBDB1148", hash_generated_method = "566EB413DAA2601DD20E016F3FE48B40")
    public final Set<String> aliases() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1226464324 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1226464324 = Collections.unmodifiableSet(this.aliasesSet);
        varB4EAC82CA7396A68D541C85D26508E83_1226464324.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1226464324;
        // ---------- Original Method ----------
        //return Collections.unmodifiableSet(this.aliasesSet);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.786 -0400", hash_original_method = "73ACF950C7885C6BB8F7DA98628525CE", hash_generated_method = "84690EF27BD82222FC635EBCA6ADA775")
    public String displayName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1136789903 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1136789903 = this.canonicalName;
        varB4EAC82CA7396A68D541C85D26508E83_1136789903.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1136789903;
        // ---------- Original Method ----------
        //return this.canonicalName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.786 -0400", hash_original_method = "E11EA2F6EB7DD1956A05FA3724D0F65C", hash_generated_method = "92C21EBDF5B7C0ABA01B4983DE075E58")
    public String displayName(Locale l) {
        String varB4EAC82CA7396A68D541C85D26508E83_1540229827 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1540229827 = this.canonicalName;
        addTaint(l.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1540229827.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1540229827;
        // ---------- Original Method ----------
        //return this.canonicalName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.787 -0400", hash_original_method = "CFCFCF944F2C53D97106092AE9D34706", hash_generated_method = "8B86A14C0294851D4439B9BD67D15D65")
    public final boolean isRegistered() {
        boolean var3B73AEDD09B4861B9A3C141DEEE06E96_816961132 = (!canonicalName.startsWith("x-") && !canonicalName.startsWith("X-"));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1816236757 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1816236757;
        // ---------- Original Method ----------
        //return !canonicalName.startsWith("x-") && !canonicalName.startsWith("X-");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.787 -0400", hash_original_method = "CFD47AB423921DC9B7AAA90F2EE94666", hash_generated_method = "E24A5D2D4F50644ACB0995DDA0A2D3E5")
    public boolean canEncode() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1789359591 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1789359591;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.804 -0400", hash_original_method = "0107CD00701D9024191BE26A03E59733", hash_generated_method = "9DD540ABAE71FA465AAF1A9E72011D4F")
    public final ByteBuffer encode(CharBuffer buffer) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1348353189 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1348353189 = newEncoder()
                    .onMalformedInput(CodingErrorAction.REPLACE)
                    .onUnmappableCharacter(CodingErrorAction.REPLACE).encode(
                            buffer);
        } //End block
        catch (CharacterCodingException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new Error(ex.getMessage(), ex);
        } //End block
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1348353189.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1348353189;
        // ---------- Original Method ----------
        //try {
            //return newEncoder()
                    //.onMalformedInput(CodingErrorAction.REPLACE)
                    //.onUnmappableCharacter(CodingErrorAction.REPLACE).encode(
                            //buffer);
        //} catch (CharacterCodingException ex) {
            //throw new Error(ex.getMessage(), ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.813 -0400", hash_original_method = "50936E0BD61264091679E7D1BE4B4220", hash_generated_method = "34EDB4D38106EB007CF7632F7F129813")
    public final ByteBuffer encode(String s) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1468845045 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1468845045 = encode(CharBuffer.wrap(s));
        addTaint(s.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1468845045.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1468845045;
        // ---------- Original Method ----------
        //return encode(CharBuffer.wrap(s));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.813 -0400", hash_original_method = "126EFF7550A1ED9E8429CF707F327D0E", hash_generated_method = "64609111BF05A06EF47963EB60B6D41A")
    public final CharBuffer decode(ByteBuffer buffer) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_1530630430 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1530630430 = newDecoder()
                    .onMalformedInput(CodingErrorAction.REPLACE)
                    .onUnmappableCharacter(CodingErrorAction.REPLACE).decode(buffer);
        } //End block
        catch (CharacterCodingException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new Error(ex.getMessage(), ex);
        } //End block
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1530630430.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1530630430;
        // ---------- Original Method ----------
        //try {
            //return newDecoder()
                    //.onMalformedInput(CodingErrorAction.REPLACE)
                    //.onUnmappableCharacter(CodingErrorAction.REPLACE).decode(buffer);
        //} catch (CharacterCodingException ex) {
            //throw new Error(ex.getMessage(), ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.813 -0400", hash_original_method = "F361CD14D12B60D2CF0F30DB9C5F0195", hash_generated_method = "2F0F79F7CCBC6C7DDB36494082E874DA")
    public final int compareTo(Charset charset) {
        int var5E75C664065B999E9D43350A25501221_745118064 = (this.canonicalName.compareToIgnoreCase(charset.canonicalName));
        addTaint(charset.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1757299972 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1757299972;
        // ---------- Original Method ----------
        //return this.canonicalName.compareToIgnoreCase(charset.canonicalName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.814 -0400", hash_original_method = "938368666D1E90E2E2969E1342A5CFE9", hash_generated_method = "1CC72FBF40389BC1E446E782A1349252")
    @Override
    public final boolean equals(Object obj) {
        {
            Charset that;
            that = (Charset) obj;
            boolean var3A9E52C18FAB21FC4EE49D12300F7231_1991175974 = (this.canonicalName.equals(that.canonicalName));
        } //End block
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_343306012 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_343306012;
        // ---------- Original Method ----------
        //if (obj instanceof Charset) {
            //Charset that = (Charset) obj;
            //return this.canonicalName.equals(that.canonicalName);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.814 -0400", hash_original_method = "D44320DAEF5566E6C5C975F4AAC84659", hash_generated_method = "7D694CEFF05265E2934EC7D4C741D90D")
    @Override
    public final int hashCode() {
        int var89A35454DD807C2B21DDBF4CE1F01CBB_1667117873 = (this.canonicalName.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_867590273 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_867590273;
        // ---------- Original Method ----------
        //return this.canonicalName.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.815 -0400", hash_original_method = "D15E03733F40849FC8BB6457075A7CA1", hash_generated_method = "978D0E445D3D5A010F552EFF42E02339")
    @Override
    public final String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2104136365 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2104136365 = getClass().getName() + "[" + this.canonicalName + "]";
        varB4EAC82CA7396A68D541C85D26508E83_2104136365.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2104136365;
        // ---------- Original Method ----------
        //return getClass().getName() + "[" + this.canonicalName + "]";
    }

    
        public static Charset defaultCharset() {
        return DEFAULT_CHARSET;
    }

    
        private static Charset getDefaultCharset() {
        String encoding = System.getProperty("file.encoding", "UTF-8");
        try {
            return Charset.forName(encoding);
        } catch (UnsupportedCharsetException e) {
            return Charset.forName("UTF-8");
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.816 -0400", hash_original_field = "3E37B559443703B81C9FE09E876D37B5", hash_generated_field = "CF50A3D5104067966AFB77197BE7C5DE")

    private static HashMap<String, Charset> CACHED_CHARSETS = new HashMap<String, Charset>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.816 -0400", hash_original_field = "A025188D4D53C27CDD8B23136A99AC7E", hash_generated_field = "02D30A06826CAABF7156262C9EAA2104")

    private static Charset DEFAULT_CHARSET = getDefaultCharset();
}

