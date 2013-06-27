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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.918 -0400", hash_original_field = "3FD37E7C1754DA8004AB09E17AD51B85", hash_generated_field = "4394C126BF71D5F3C3D84B833D0FB596")

    private String canonicalName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.918 -0400", hash_original_field = "496C43E2A9F7F1C8928D93EF34796C9E", hash_generated_field = "94A607030E0CCDFE52CAD878DD81F6F9")

    private HashSet<String> aliasesSet;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.942 -0400", hash_original_method = "70538FAF149E20AD4492F643DB83EDCB", hash_generated_method = "FEF9D5849B61F084513B83917A4B67BD")
    protected  Charset(String canonicalName, String[] aliases) {
        checkCharsetName(canonicalName);
        this.canonicalName = canonicalName;
        this.aliasesSet = new HashSet<String>();
        {
            {
                Iterator<String> var06384BB0465CAA9396B17F3A4E2F7242_131415703 = (aliases).iterator();
                var06384BB0465CAA9396B17F3A4E2F7242_131415703.hasNext();
                String alias = var06384BB0465CAA9396B17F3A4E2F7242_131415703.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.956 -0400", hash_original_method = "C591AF6945C669FCF4033528E86B2077", hash_generated_method = "1ED9444B060DACA5FA8201354B706083")
    public final String name() {
        String varB4EAC82CA7396A68D541C85D26508E83_1279855551 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1279855551 = this.canonicalName;
        varB4EAC82CA7396A68D541C85D26508E83_1279855551.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1279855551;
        // ---------- Original Method ----------
        //return this.canonicalName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.956 -0400", hash_original_method = "9500673A94BC6D8C4BDA9785EBDB1148", hash_generated_method = "0677C17116DF640F02197129F077BB25")
    public final Set<String> aliases() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_797318571 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_797318571 = Collections.unmodifiableSet(this.aliasesSet);
        varB4EAC82CA7396A68D541C85D26508E83_797318571.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_797318571;
        // ---------- Original Method ----------
        //return Collections.unmodifiableSet(this.aliasesSet);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.957 -0400", hash_original_method = "73ACF950C7885C6BB8F7DA98628525CE", hash_generated_method = "E95FAB3F2C557B806944DF81FB939458")
    public String displayName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1863518758 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1863518758 = this.canonicalName;
        varB4EAC82CA7396A68D541C85D26508E83_1863518758.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1863518758;
        // ---------- Original Method ----------
        //return this.canonicalName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.963 -0400", hash_original_method = "E11EA2F6EB7DD1956A05FA3724D0F65C", hash_generated_method = "5E3DE9B73457B9096F34C3ADA34512D2")
    public String displayName(Locale l) {
        String varB4EAC82CA7396A68D541C85D26508E83_530479617 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_530479617 = this.canonicalName;
        addTaint(l.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_530479617.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_530479617;
        // ---------- Original Method ----------
        //return this.canonicalName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.963 -0400", hash_original_method = "CFCFCF944F2C53D97106092AE9D34706", hash_generated_method = "7E5BD63A7365D5496689FA6AE736C301")
    public final boolean isRegistered() {
        boolean var3B73AEDD09B4861B9A3C141DEEE06E96_1117691263 = (!canonicalName.startsWith("x-") && !canonicalName.startsWith("X-"));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_872114920 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_872114920;
        // ---------- Original Method ----------
        //return !canonicalName.startsWith("x-") && !canonicalName.startsWith("X-");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.963 -0400", hash_original_method = "CFD47AB423921DC9B7AAA90F2EE94666", hash_generated_method = "8FA1AB7A0E585B40598761E64B5A947F")
    public boolean canEncode() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_793064241 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_793064241;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.964 -0400", hash_original_method = "0107CD00701D9024191BE26A03E59733", hash_generated_method = "9243E5D4E1C4573CE2A59D2AA4EAC7AE")
    public final ByteBuffer encode(CharBuffer buffer) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_644518231 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_644518231 = newEncoder()
                    .onMalformedInput(CodingErrorAction.REPLACE)
                    .onUnmappableCharacter(CodingErrorAction.REPLACE).encode(
                            buffer);
        } //End block
        catch (CharacterCodingException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new Error(ex.getMessage(), ex);
        } //End block
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_644518231.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_644518231;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.980 -0400", hash_original_method = "50936E0BD61264091679E7D1BE4B4220", hash_generated_method = "78AC5D268D6D7376B9832504E7EBEDBC")
    public final ByteBuffer encode(String s) {
        ByteBuffer varB4EAC82CA7396A68D541C85D26508E83_1491987221 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1491987221 = encode(CharBuffer.wrap(s));
        addTaint(s.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1491987221.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1491987221;
        // ---------- Original Method ----------
        //return encode(CharBuffer.wrap(s));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.980 -0400", hash_original_method = "126EFF7550A1ED9E8429CF707F327D0E", hash_generated_method = "8D2907454BAE3DFD833CB5A22E531C25")
    public final CharBuffer decode(ByteBuffer buffer) {
        CharBuffer varB4EAC82CA7396A68D541C85D26508E83_886072617 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_886072617 = newDecoder()
                    .onMalformedInput(CodingErrorAction.REPLACE)
                    .onUnmappableCharacter(CodingErrorAction.REPLACE).decode(buffer);
        } //End block
        catch (CharacterCodingException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new Error(ex.getMessage(), ex);
        } //End block
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_886072617.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_886072617;
        // ---------- Original Method ----------
        //try {
            //return newDecoder()
                    //.onMalformedInput(CodingErrorAction.REPLACE)
                    //.onUnmappableCharacter(CodingErrorAction.REPLACE).decode(buffer);
        //} catch (CharacterCodingException ex) {
            //throw new Error(ex.getMessage(), ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.980 -0400", hash_original_method = "F361CD14D12B60D2CF0F30DB9C5F0195", hash_generated_method = "9BB69ED1C752249B0261A60372C2B5C7")
    public final int compareTo(Charset charset) {
        int var5E75C664065B999E9D43350A25501221_277804715 = (this.canonicalName.compareToIgnoreCase(charset.canonicalName));
        addTaint(charset.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1149882846 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1149882846;
        // ---------- Original Method ----------
        //return this.canonicalName.compareToIgnoreCase(charset.canonicalName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.981 -0400", hash_original_method = "938368666D1E90E2E2969E1342A5CFE9", hash_generated_method = "5B429B05E4B1CF7626BEA0F796D35D6D")
    @Override
    public final boolean equals(Object obj) {
        {
            Charset that;
            that = (Charset) obj;
            boolean var3A9E52C18FAB21FC4EE49D12300F7231_602527151 = (this.canonicalName.equals(that.canonicalName));
        } //End block
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1886390782 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1886390782;
        // ---------- Original Method ----------
        //if (obj instanceof Charset) {
            //Charset that = (Charset) obj;
            //return this.canonicalName.equals(that.canonicalName);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.985 -0400", hash_original_method = "D44320DAEF5566E6C5C975F4AAC84659", hash_generated_method = "0BC31243FC694D0AFEE14B54D9091953")
    @Override
    public final int hashCode() {
        int var89A35454DD807C2B21DDBF4CE1F01CBB_1927276329 = (this.canonicalName.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_811865988 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_811865988;
        // ---------- Original Method ----------
        //return this.canonicalName.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.985 -0400", hash_original_method = "D15E03733F40849FC8BB6457075A7CA1", hash_generated_method = "445F634782141F37F4C97D21F24115DA")
    @Override
    public final String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1423689153 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1423689153 = getClass().getName() + "[" + this.canonicalName + "]";
        varB4EAC82CA7396A68D541C85D26508E83_1423689153.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1423689153;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.998 -0400", hash_original_field = "3E37B559443703B81C9FE09E876D37B5", hash_generated_field = "CF50A3D5104067966AFB77197BE7C5DE")

    private static HashMap<String, Charset> CACHED_CHARSETS = new HashMap<String, Charset>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:45.998 -0400", hash_original_field = "A025188D4D53C27CDD8B23136A99AC7E", hash_generated_field = "02D30A06826CAABF7156262C9EAA2104")

    private static Charset DEFAULT_CHARSET = getDefaultCharset();
}

