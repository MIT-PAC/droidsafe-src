package java.nio.charset;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final HashMap<String, Charset> CACHED_CHARSETS = new HashMap<String, Charset>();
    private static final Charset DEFAULT_CHARSET = getDefaultCharset();
    private String canonicalName;
    private HashSet<String> aliasesSet;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.526 -0400", hash_original_method = "70538FAF149E20AD4492F643DB83EDCB", hash_generated_method = "E80383F4DE7895B4D8DB185388FA7A1A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Charset(String canonicalName, String[] aliases) {
        dsTaint.addTaint(canonicalName);
        dsTaint.addTaint(aliases);
        checkCharsetName(canonicalName);
        this.aliasesSet = new HashSet<String>();
        {
			{
                String alias = aliases[0];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.526 -0400", hash_original_method = "1B562419FBD56BE2B33ED98FD4ABE386", hash_generated_method = "A2F453F6E5C441B83EF70DACAF3D16D1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.526 -0400", hash_original_method = "9034B02728818A8ACE22749851509C68", hash_generated_method = "C5A1AB7024C0FABC4FCBF5F9A0833A7E")
    private static boolean isValidCharsetNameCharacter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') ||
                c == '-' || c == '.' || c == ':' || c == '_';
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.526 -0400", hash_original_method = "D24D2A1747F6B2E65F29AFB88655D52E", hash_generated_method = "8DBF19BBFB0C9F9BD7C5C78BAD40C74C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.526 -0400", hash_original_method = "B40419257A5AD729851C1FAA17AEA345", hash_generated_method = "8CF3253EEC79298A98CD4370E674920A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.526 -0400", hash_original_method = "B31D6DDF47464344AF549FF7AC79952D", hash_generated_method = "AA70CAC206BD2DA96F33BC322460E22C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.526 -0400", hash_original_method = "39C868A7F6BE4E7CAAAB060CBA114FE7", hash_generated_method = "A8507DD64484C4216686DD6B37AB27CD")
    public static Charset forNameUEE(String charsetName) throws UnsupportedEncodingException {
        try {
            return Charset.forName(charsetName);
        } catch (Exception cause) {
            UnsupportedEncodingException ex = new UnsupportedEncodingException(charsetName);
            ex.initCause(cause);
            throw ex;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.526 -0400", hash_original_method = "2258B85E90751D38D59545D446F21DAF", hash_generated_method = "F1FCF7A11E7BE0F00CC3916486AD6B55")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.526 -0400", hash_original_method = "C591AF6945C669FCF4033528E86B2077", hash_generated_method = "62742DF49F509804005DA4C8E289530A")
    @DSModeled(DSC.SAFE)
    public final String name() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.canonicalName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.526 -0400", hash_original_method = "9500673A94BC6D8C4BDA9785EBDB1148", hash_generated_method = "CCB0B726A16594B2022A669F0CB99AEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Set<String> aliases() {
        Set<String> var025A059729F78F178A3FE08996F2CD2C_657361645 = (Collections.unmodifiableSet(this.aliasesSet));
        return (Set<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Collections.unmodifiableSet(this.aliasesSet);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.526 -0400", hash_original_method = "73ACF950C7885C6BB8F7DA98628525CE", hash_generated_method = "F4F286695D31ECAF8891CEA4BC80D90B")
    @DSModeled(DSC.SAFE)
    public String displayName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.canonicalName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.526 -0400", hash_original_method = "E11EA2F6EB7DD1956A05FA3724D0F65C", hash_generated_method = "A6E3A8C7B70087DEABAB7168378F9D2B")
    @DSModeled(DSC.SAFE)
    public String displayName(Locale l) {
        dsTaint.addTaint(l.dsTaint);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.canonicalName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.527 -0400", hash_original_method = "CFCFCF944F2C53D97106092AE9D34706", hash_generated_method = "D0A01AF32976BC0F5BFCE16526F73664")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isRegistered() {
        boolean var3B73AEDD09B4861B9A3C141DEEE06E96_1572337528 = (!canonicalName.startsWith("x-") && !canonicalName.startsWith("X-"));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return !canonicalName.startsWith("x-") && !canonicalName.startsWith("X-");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.527 -0400", hash_original_method = "CFD47AB423921DC9B7AAA90F2EE94666", hash_generated_method = "07C925815CAD3D7A84FB50CA49B66B02")
    @DSModeled(DSC.SAFE)
    public boolean canEncode() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.527 -0400", hash_original_method = "0107CD00701D9024191BE26A03E59733", hash_generated_method = "DB6F2B96AA7F12138B2A7F84C8CC188A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final ByteBuffer encode(CharBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        try 
        {
            ByteBuffer varF4EE3BE615484862DDFC07A9F61F525F_492781566 = (newEncoder()
                    .onMalformedInput(CodingErrorAction.REPLACE)
                    .onUnmappableCharacter(CodingErrorAction.REPLACE).encode(
                            buffer));
        } //End block
        catch (CharacterCodingException ex)
        {
            throw new Error(ex.getMessage(), ex);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.527 -0400", hash_original_method = "50936E0BD61264091679E7D1BE4B4220", hash_generated_method = "A17A1C46854670CF011A43EF7724799A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final ByteBuffer encode(String s) {
        dsTaint.addTaint(s);
        ByteBuffer var7B7112E79914354F6E36EAF30D8181BD_905523337 = (encode(CharBuffer.wrap(s)));
        return (ByteBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return encode(CharBuffer.wrap(s));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.527 -0400", hash_original_method = "126EFF7550A1ED9E8429CF707F327D0E", hash_generated_method = "1E0A75D271F161217CD455A12EF0C9CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final CharBuffer decode(ByteBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        try 
        {
            CharBuffer var0414ECACC4D9B4522D32BB3F2634F460_970490996 = (newDecoder()
                    .onMalformedInput(CodingErrorAction.REPLACE)
                    .onUnmappableCharacter(CodingErrorAction.REPLACE).decode(buffer));
        } //End block
        catch (CharacterCodingException ex)
        {
            throw new Error(ex.getMessage(), ex);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.527 -0400", hash_original_method = "F361CD14D12B60D2CF0F30DB9C5F0195", hash_generated_method = "374E4E75EC02B846C39F91CF5D2C848D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int compareTo(Charset charset) {
        dsTaint.addTaint(charset.dsTaint);
        int var5E75C664065B999E9D43350A25501221_769364495 = (this.canonicalName.compareToIgnoreCase(charset.canonicalName));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.canonicalName.compareToIgnoreCase(charset.canonicalName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.527 -0400", hash_original_method = "938368666D1E90E2E2969E1342A5CFE9", hash_generated_method = "D4FA622C5899F94C7CF3F2DC04AFB6EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        {
            Charset that;
            that = (Charset) obj;
            boolean var3A9E52C18FAB21FC4EE49D12300F7231_391684903 = (this.canonicalName.equals(that.canonicalName));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (obj instanceof Charset) {
            //Charset that = (Charset) obj;
            //return this.canonicalName.equals(that.canonicalName);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.527 -0400", hash_original_method = "D44320DAEF5566E6C5C975F4AAC84659", hash_generated_method = "6D92D7DEC69F88A6327E1F36233F34EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final int hashCode() {
        int var89A35454DD807C2B21DDBF4CE1F01CBB_106189419 = (this.canonicalName.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.canonicalName.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.527 -0400", hash_original_method = "D15E03733F40849FC8BB6457075A7CA1", hash_generated_method = "3E26DB8E84ECCD83F0CE3DFA94EE9F35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final String toString() {
        String var1B46FF0EFAA1F7E7813CA4BF58409178_758850349 = (getClass().getName() + "[" + this.canonicalName + "]");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getClass().getName() + "[" + this.canonicalName + "]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.527 -0400", hash_original_method = "CB788AA26F30894D1ACC3158AB47347B", hash_generated_method = "FD6E03E59F62AFEA1334A4C4783FC444")
    public static Charset defaultCharset() {
        return DEFAULT_CHARSET;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.527 -0400", hash_original_method = "CF00CD3332842EC74198C62C87ED0076", hash_generated_method = "E9F8BE2CBB97B961A5CDA9BA052EE481")
    private static Charset getDefaultCharset() {
        String encoding = System.getProperty("file.encoding", "UTF-8");
        try {
            return Charset.forName(encoding);
        } catch (UnsupportedCharsetException e) {
            return Charset.forName("UTF-8");
        }
    }

    
}


