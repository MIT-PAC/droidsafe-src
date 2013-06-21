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
    private String canonicalName;
    private HashSet<String> aliasesSet;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.187 -0400", hash_original_method = "70538FAF149E20AD4492F643DB83EDCB", hash_generated_method = "113B42225A14E34121C2D68B15D79096")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Charset(String canonicalName, String[] aliases) {
        dsTaint.addTaint(canonicalName);
        dsTaint.addTaint(aliases[0]);
        checkCharsetName(canonicalName);
        this.aliasesSet = new HashSet<String>();
        {
            {
                Iterator<String> var06384BB0465CAA9396B17F3A4E2F7242_1178401090 = (aliases).iterator();
                var06384BB0465CAA9396B17F3A4E2F7242_1178401090.hasNext();
                String alias = var06384BB0465CAA9396B17F3A4E2F7242_1178401090.next();
                {
                    checkCharsetName(alias);
                    this.aliasesSet.add(alias);
                } //End block
            } //End collapsed parenthetic
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.189 -0400", hash_original_method = "C591AF6945C669FCF4033528E86B2077", hash_generated_method = "F1EFC3539684E9ACC120943E8E30B191")
    @DSModeled(DSC.SAFE)
    public final String name() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.canonicalName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.190 -0400", hash_original_method = "9500673A94BC6D8C4BDA9785EBDB1148", hash_generated_method = "0A78AE59FE611007A553DCEAAD1C27CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Set<String> aliases() {
        Set<String> var025A059729F78F178A3FE08996F2CD2C_1116318528 = (Collections.unmodifiableSet(this.aliasesSet));
        return (Set<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Collections.unmodifiableSet(this.aliasesSet);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.190 -0400", hash_original_method = "73ACF950C7885C6BB8F7DA98628525CE", hash_generated_method = "8207E9BFCDBCB6C4CAE806B5E965CF5D")
    @DSModeled(DSC.SAFE)
    public String displayName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.canonicalName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.190 -0400", hash_original_method = "E11EA2F6EB7DD1956A05FA3724D0F65C", hash_generated_method = "52C02FB5AE70772F5799892996568657")
    @DSModeled(DSC.SAFE)
    public String displayName(Locale l) {
        dsTaint.addTaint(l.dsTaint);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.canonicalName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.190 -0400", hash_original_method = "CFCFCF944F2C53D97106092AE9D34706", hash_generated_method = "EA697EEF3185E7A7733DC501EAF36AF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isRegistered() {
        boolean var3B73AEDD09B4861B9A3C141DEEE06E96_699718961 = (!canonicalName.startsWith("x-") && !canonicalName.startsWith("X-"));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return !canonicalName.startsWith("x-") && !canonicalName.startsWith("X-");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.190 -0400", hash_original_method = "CFD47AB423921DC9B7AAA90F2EE94666", hash_generated_method = "C656AEF880A39FBFEF049678AE2C8ECD")
    @DSModeled(DSC.SAFE)
    public boolean canEncode() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.191 -0400", hash_original_method = "0107CD00701D9024191BE26A03E59733", hash_generated_method = "91A588D6952BC284E9DA65ED6533FB4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final ByteBuffer encode(CharBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        try 
        {
            ByteBuffer varF4EE3BE615484862DDFC07A9F61F525F_1810346996 = (newEncoder()
                    .onMalformedInput(CodingErrorAction.REPLACE)
                    .onUnmappableCharacter(CodingErrorAction.REPLACE).encode(
                            buffer));
        } //End block
        catch (CharacterCodingException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new Error(ex.getMessage(), ex);
        } //End block
        return (ByteBuffer)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.191 -0400", hash_original_method = "50936E0BD61264091679E7D1BE4B4220", hash_generated_method = "0F92B3C4514E958A604D96EA0710D182")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final ByteBuffer encode(String s) {
        dsTaint.addTaint(s);
        ByteBuffer var7B7112E79914354F6E36EAF30D8181BD_1834916605 = (encode(CharBuffer.wrap(s)));
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return encode(CharBuffer.wrap(s));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.191 -0400", hash_original_method = "126EFF7550A1ED9E8429CF707F327D0E", hash_generated_method = "FF6F12BF3958521B3DD328068298CC47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final CharBuffer decode(ByteBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        try 
        {
            CharBuffer var0414ECACC4D9B4522D32BB3F2634F460_2022114784 = (newDecoder()
                    .onMalformedInput(CodingErrorAction.REPLACE)
                    .onUnmappableCharacter(CodingErrorAction.REPLACE).decode(buffer));
        } //End block
        catch (CharacterCodingException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new Error(ex.getMessage(), ex);
        } //End block
        return (CharBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return newDecoder()
                    //.onMalformedInput(CodingErrorAction.REPLACE)
                    //.onUnmappableCharacter(CodingErrorAction.REPLACE).decode(buffer);
        //} catch (CharacterCodingException ex) {
            //throw new Error(ex.getMessage(), ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.192 -0400", hash_original_method = "F361CD14D12B60D2CF0F30DB9C5F0195", hash_generated_method = "2B0BD9FC00293B0A9C28C422B21E2768")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int compareTo(Charset charset) {
        dsTaint.addTaint(charset.dsTaint);
        int var5E75C664065B999E9D43350A25501221_479330799 = (this.canonicalName.compareToIgnoreCase(charset.canonicalName));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.canonicalName.compareToIgnoreCase(charset.canonicalName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.192 -0400", hash_original_method = "938368666D1E90E2E2969E1342A5CFE9", hash_generated_method = "58363CA74C8DE3D6CD8FD163E84F5CA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        {
            Charset that;
            that = (Charset) obj;
            boolean var3A9E52C18FAB21FC4EE49D12300F7231_875832811 = (this.canonicalName.equals(that.canonicalName));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (obj instanceof Charset) {
            //Charset that = (Charset) obj;
            //return this.canonicalName.equals(that.canonicalName);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.192 -0400", hash_original_method = "D44320DAEF5566E6C5C975F4AAC84659", hash_generated_method = "1B1F61DD8EF24A66C8BB64A08F66F055")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final int hashCode() {
        int var89A35454DD807C2B21DDBF4CE1F01CBB_2051235851 = (this.canonicalName.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.canonicalName.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.192 -0400", hash_original_method = "D15E03733F40849FC8BB6457075A7CA1", hash_generated_method = "A8DCF1B576CEA5A41F83D45DC713F6FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final String toString() {
        String var1B46FF0EFAA1F7E7813CA4BF58409178_185308021 = (getClass().getName() + "[" + this.canonicalName + "]");
        return dsTaint.getTaintString();
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

    
    private static final HashMap<String, Charset> CACHED_CHARSETS = new HashMap<String, Charset>();
    private static final Charset DEFAULT_CHARSET = getDefaultCharset();
}

