package java.nio.charset;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.289 -0500", hash_original_method = "1B562419FBD56BE2B33ED98FD4ABE386", hash_generated_method = "A2F453F6E5C441B83EF70DACAF3D16D1")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.292 -0500", hash_original_method = "9034B02728818A8ACE22749851509C68", hash_generated_method = "C5A1AB7024C0FABC4FCBF5F9A0833A7E")
    
private static boolean isValidCharsetNameCharacter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') ||
                c == '-' || c == '.' || c == ':' || c == '_';
    }

    /**
     * Returns an immutable case-insensitive map from canonical names to {@code Charset} instances.
     * If multiple charsets have the same canonical name, it is unspecified which is returned in
     * the map. This method may be slow. If you know which charset you're looking for, use
     * {@link #forName}.
     * @return an immutable case-insensitive map from canonical names to {@code Charset} instances
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.295 -0500", hash_original_method = "D24D2A1747F6B2E65F29AFB88655D52E", hash_generated_method = "5D1C082AF22914BF205E1FC6133ED7FB")
    
public static SortedMap<String, Charset> availableCharsets() {
        // Start with a copy of the built-in charsets...
        TreeMap<String, Charset> charsets = new TreeMap<String, Charset>(String.CASE_INSENSITIVE_ORDER);
        for (String charsetName : NativeConverter.getAvailableCharsetNames()) {
            Charset charset = NativeConverter.charsetForName(charsetName);
            charsets.put(charset.name(), charset);
        }

        // Add all charsets provided by all charset providers...
        for (CharsetProvider charsetProvider : ServiceLoader.load(CharsetProvider.class)) {
            Iterator<Charset> it = charsetProvider.charsets();
            while (it.hasNext()) {
                Charset cs = it.next();
                // A CharsetProvider can't override a built-in Charset.
                if (!charsets.containsKey(cs.name())) {
                    charsets.put(cs.name(), cs);
                }
            }
        }

        return Collections.unmodifiableSortedMap(charsets);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.298 -0500", hash_original_method = "B40419257A5AD729851C1FAA17AEA345", hash_generated_method = "D5458060AD1FD9E91B602F46F2745714")
    
private static Charset cacheCharset(String charsetName, Charset cs) {
        synchronized (CACHED_CHARSETS) {
            // Get the canonical name for this charset, and the canonical instance from the table.
            String canonicalName = cs.name();
            Charset canonicalCharset = CACHED_CHARSETS.get(canonicalName);
            if (canonicalCharset == null) {
                canonicalCharset = cs;
            }

            // Cache the charset by its canonical name...
            CACHED_CHARSETS.put(canonicalName, canonicalCharset);

            // And the name the user used... (Section 1.4 of http://unicode.org/reports/tr22/ means
            // that many non-alias, non-canonical names are valid. For example, "utf8" isn't an
            // alias of the canonical name "UTF-8", but we shouldn't penalize consistent users of
            // such names unduly.)
            CACHED_CHARSETS.put(charsetName, canonicalCharset);

            // And all its aliases...
            for (String alias : cs.aliasesSet) {
                CACHED_CHARSETS.put(alias, canonicalCharset);
            }

            return canonicalCharset;
        }
    }

    /**
     * Returns a {@code Charset} instance for the named charset.
     *
     * @param charsetName a charset name (either canonical or an alias)
     * @throws IllegalCharsetNameException
     *             if the specified charset name is illegal.
     * @throws UnsupportedCharsetException
     *             if the desired charset is not supported by this runtime.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.301 -0500", hash_original_method = "B31D6DDF47464344AF549FF7AC79952D", hash_generated_method = "69512781EC40B9F94DBA1CA7BA3C02E4")
    
public static Charset forName(String charsetName) {
        // Is this charset in our cache?
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

        // Is this a built-in charset supported by ICU?
        checkCharsetName(charsetName);
        cs = NativeConverter.charsetForName(charsetName);
        if (cs != null) {
            return cacheCharset(charsetName, cs);
        }

        // Does a configured CharsetProvider have this charset?
        for (CharsetProvider charsetProvider : ServiceLoader.load(CharsetProvider.class)) {
            cs = charsetProvider.charsetForName(charsetName);
            if (cs != null) {
                return cacheCharset(charsetName, cs);
            }
        }

        throw new UnsupportedCharsetException(charsetName);
    }

    /**
     * Equivalent to {@code forName} but only throws {@code UnsupportedEncodingException},
     * which is all pre-nio code claims to throw.
     *
     * @hide internal use only
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.304 -0500", hash_original_method = "39C868A7F6BE4E7CAAAB060CBA114FE7", hash_generated_method = "A8507DD64484C4216686DD6B37AB27CD")
    
public static Charset forNameUEE(String charsetName) throws UnsupportedEncodingException {
        try {
            return Charset.forName(charsetName);
        } catch (Exception cause) {
            UnsupportedEncodingException ex = new UnsupportedEncodingException(charsetName);
            ex.initCause(cause);
            throw ex;
        }
    }

    /**
     * Determines whether the specified charset is supported by this runtime.
     *
     * @param charsetName
     *            the name of the charset.
     * @return true if the specified charset is supported, otherwise false.
     * @throws IllegalCharsetNameException
     *             if the specified charset name is illegal.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.306 -0500", hash_original_method = "2258B85E90751D38D59545D446F21DAF", hash_generated_method = "F1FCF7A11E7BE0F00CC3916486AD6B55")
    
public static boolean isSupported(String charsetName) {
        try {
            forName(charsetName);
            return true;
        } catch (UnsupportedCharsetException ex) {
            return false;
        }
    }

    /**
     * Returns the system's default charset. This is determined during VM startup, and will not
     * change thereafter. On Android, the default charset is UTF-8.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.349 -0500", hash_original_method = "CB788AA26F30894D1ACC3158AB47347B", hash_generated_method = "FD6E03E59F62AFEA1334A4C4783FC444")
    
public static Charset defaultCharset() {
        return DEFAULT_CHARSET;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.352 -0500", hash_original_method = "CF00CD3332842EC74198C62C87ED0076", hash_generated_method = "E9F8BE2CBB97B961A5CDA9BA052EE481")
    
private static Charset getDefaultCharset() {
        String encoding = System.getProperty("file.encoding", "UTF-8");
        try {
            return Charset.forName(encoding);
        } catch (UnsupportedCharsetException e) {
            return Charset.forName("UTF-8");
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.276 -0500", hash_original_field = "460C9BF0E81398E540D5223DD230E9C6", hash_generated_field = "978C227844F811E8AD7601EBA458F045")

    private static final HashMap<String, Charset> CACHED_CHARSETS = new HashMap<String, Charset>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.279 -0500", hash_original_field = "4B19164BB0D16E04460F0646F28D0382", hash_generated_field = "1A1C1C599D3935A97F31144300864BDF")


    private static final Charset DEFAULT_CHARSET = getDefaultCharset();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.281 -0500", hash_original_field = "232080F63068CCD875338225CCA78208", hash_generated_field = "4394C126BF71D5F3C3D84B833D0FB596")


    private  String canonicalName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.283 -0500", hash_original_field = "90FA4A58C475317C95CCF8F7B07CCD67", hash_generated_field = "94A607030E0CCDFE52CAD878DD81F6F9")


    private  HashSet<String> aliasesSet;

    /**
     * Constructs a <code>Charset</code> object. Duplicated aliases are
     * ignored.
     *
     * @param canonicalName
     *            the canonical name of the charset.
     * @param aliases
     *            an array containing all aliases of the charset. May be null.
     * @throws IllegalCharsetNameException
     *             on an illegal value being supplied for either
     *             <code>canonicalName</code> or for any element of
     *             <code>aliases</code>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.286 -0500", hash_original_method = "70538FAF149E20AD4492F643DB83EDCB", hash_generated_method = "016567F5CC6270A495B7E1BAB908D5B9")
    
protected Charset(String canonicalName, String[] aliases) {
        // check whether the given canonical name is legal
        checkCharsetName(canonicalName);
        this.canonicalName = canonicalName;
        // check each alias and put into a set
        this.aliasesSet = new HashSet<String>();
        if (aliases != null) {
            for (String alias : aliases) {
                checkCharsetName(alias);
                this.aliasesSet.add(alias);
            }
        }
    }

    /**
     * Determines whether this charset is a superset of the given charset. A charset C1 contains
     * charset C2 if every character representable by C2 is also representable by C1. This means
     * that lossless conversion is possible from C2 to C1 (but not necessarily the other way
     * round). It does <i>not</i> imply that the two charsets use the same byte sequences for the
     * characters they share.
     *
     * <p>Note that this method is allowed to be conservative, and some implementations may return
     * false when this charset does contain the other charset. Android's implementation is precise,
     * and will always return true in such cases.
     *
     * @param charset
     *            a given charset.
     * @return true if this charset is a super set of the given charset,
     *         false if it's unknown or this charset is not a superset of
     *         the given charset.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.309 -0500", hash_original_method = "A170E8D5F907BC2C49EE2B6B025995E0", hash_generated_method = "69BECE17D88537817044B7AB49A588D2")
    
public abstract boolean contains(Charset charset);

    /**
     * Gets a new instance of an encoder for this charset.
     *
     * @return a new instance of an encoder for this charset.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.311 -0500", hash_original_method = "6CE48151599625E957ABC6EC54C683E1", hash_generated_method = "F7342451161EBEDD0F2A5E305B52C07E")
    
public abstract CharsetEncoder newEncoder();

    /**
     * Gets a new instance of a decoder for this charset.
     *
     * @return a new instance of a decoder for this charset.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.314 -0500", hash_original_method = "87399EF201DA00E186FBDB0ABC0F624F", hash_generated_method = "2CC99218A52107AA79DA0D19E105B263")
    
public abstract CharsetDecoder newDecoder();

    /**
     * Gets the canonical name of this charset.
     *
     * @return this charset's name in canonical form.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.316 -0500", hash_original_method = "C591AF6945C669FCF4033528E86B2077", hash_generated_method = "F1A503D43EE7081C90FA96704A313AB1")
    
public final String name() {
        return this.canonicalName;
    }

    /**
     * Gets the set of this charset's aliases.
     *
     * @return an unmodifiable set of this charset's aliases.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.319 -0500", hash_original_method = "9500673A94BC6D8C4BDA9785EBDB1148", hash_generated_method = "0ED77981E1A594D94B2465B8E5BD1417")
    
public final Set<String> aliases() {
        return Collections.unmodifiableSet(this.aliasesSet);
    }

    /**
     * Gets the name of this charset for the default locale.
     *
     * <p>The default implementation returns the canonical name of this charset.
     * Subclasses may return a localized display name.
     *
     * @return the name of this charset for the default locale.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.321 -0500", hash_original_method = "73ACF950C7885C6BB8F7DA98628525CE", hash_generated_method = "C81EFE7C54130562A9C7F28495E6FF33")
    
public String displayName() {
        return this.canonicalName;
    }

    /**
     * Gets the name of this charset for the specified locale.
     *
     * <p>The default implementation returns the canonical name of this charset.
     * Subclasses may return a localized display name.
     *
     * @param l
     *            a certain locale
     * @return the name of this charset for the specified locale
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.323 -0500", hash_original_method = "E11EA2F6EB7DD1956A05FA3724D0F65C", hash_generated_method = "BED343CA7CEF0EFC2756AF3D17A24CC9")
    
public String displayName(Locale l) {
        return this.canonicalName;
    }

    /**
     * Indicates whether this charset is known to be registered in the IANA
     * Charset Registry.
     *
     * @return true if the charset is known to be registered, otherwise returns
     *         false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.326 -0500", hash_original_method = "CFCFCF944F2C53D97106092AE9D34706", hash_generated_method = "58415664DD6D3EEA215DBD1790F7BD8B")
    
public final boolean isRegistered() {
        return !canonicalName.startsWith("x-") && !canonicalName.startsWith("X-");
    }

    /**
     * Returns true if this charset supports encoding, false otherwise.
     *
     * @return true if this charset supports encoding, false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.328 -0500", hash_original_method = "CFD47AB423921DC9B7AAA90F2EE94666", hash_generated_method = "71E8CFF7EE016C06ABA91169FC86F58B")
    
public boolean canEncode() {
        return true;
    }

    /**
     * Returns a new {@code ByteBuffer} containing the bytes encoding the characters from
     * {@code buffer}.
     * This method uses {@code CodingErrorAction.REPLACE}.
     *
     * <p>Applications should generally create a {@link CharsetEncoder} using {@link #newEncoder}
     * for performance.
     *
     * @param buffer
     *            the character buffer containing the content to be encoded.
     * @return the result of the encoding.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.331 -0500", hash_original_method = "0107CD00701D9024191BE26A03E59733", hash_generated_method = "054B9100A5F8034807034FD772D16332")
    
public final ByteBuffer encode(CharBuffer buffer) {
        try {
            return newEncoder()
                    .onMalformedInput(CodingErrorAction.REPLACE)
                    .onUnmappableCharacter(CodingErrorAction.REPLACE).encode(
                            buffer);
        } catch (CharacterCodingException ex) {
            throw new Error(ex.getMessage(), ex);
        }
    }

    /**
     * Returns a new {@code ByteBuffer} containing the bytes encoding the characters from {@code s}.
     * This method uses {@code CodingErrorAction.REPLACE}.
     *
     * <p>Applications should generally create a {@link CharsetEncoder} using {@link #newEncoder}
     * for performance.
     *
     * @param s the string to be encoded.
     * @return the result of the encoding.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.333 -0500", hash_original_method = "50936E0BD61264091679E7D1BE4B4220", hash_generated_method = "8228597DAB540A67EF7908C4EE6BE165")
    
public final ByteBuffer encode(String s) {
        return encode(CharBuffer.wrap(s));
    }

    /**
     * Returns a new {@code CharBuffer} containing the characters decoded from {@code buffer}.
     * This method uses {@code CodingErrorAction.REPLACE}.
     *
     * <p>Applications should generally create a {@link CharsetDecoder} using {@link #newDecoder}
     * for performance.
     *
     * @param buffer
     *            the byte buffer containing the content to be decoded.
     * @return a character buffer containing the output of the decoding.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.336 -0500", hash_original_method = "126EFF7550A1ED9E8429CF707F327D0E", hash_generated_method = "97FC4D473A4F15EC954C68C08F6C52D7")
    
public final CharBuffer decode(ByteBuffer buffer) {
        try {
            return newDecoder()
                    .onMalformedInput(CodingErrorAction.REPLACE)
                    .onUnmappableCharacter(CodingErrorAction.REPLACE).decode(buffer);
        } catch (CharacterCodingException ex) {
            throw new Error(ex.getMessage(), ex);
        }
    }

    /*
     * -------------------------------------------------------------------
     * Methods implementing parent interface Comparable
     * -------------------------------------------------------------------
     */

    /**
     * Compares this charset with the given charset. This comparison is
     * based on the case insensitive canonical names of the charsets.
     *
     * @param charset
     *            the given object to be compared with.
     * @return a negative integer if less than the given object, a positive
     *         integer if larger than it, or 0 if equal to it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.339 -0500", hash_original_method = "F361CD14D12B60D2CF0F30DB9C5F0195", hash_generated_method = "970DF60F13EB2016958F3F4160211221")
    
public final int compareTo(Charset charset) {
        return this.canonicalName.compareToIgnoreCase(charset.canonicalName);
    }

    /*
     * -------------------------------------------------------------------
     * Methods overriding parent class Object
     * -------------------------------------------------------------------
     */

    /**
     * Determines whether this charset equals to the given object. They are
     * considered to be equal if they have the same canonical name.
     *
     * @param obj
     *            the given object to be compared with.
     * @return true if they have the same canonical name, otherwise false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.342 -0500", hash_original_method = "938368666D1E90E2E2969E1342A5CFE9", hash_generated_method = "D56B522E8E5E3EFAA5FC0B5715399D40")
    
@Override
    public final boolean equals(Object obj) {
        if (obj instanceof Charset) {
            Charset that = (Charset) obj;
            return this.canonicalName.equals(that.canonicalName);
        }
        return false;
    }

    /**
     * Gets the hash code of this charset.
     *
     * @return the hash code of this charset.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.344 -0500", hash_original_method = "D44320DAEF5566E6C5C975F4AAC84659", hash_generated_method = "0572979258B76DCAF0099246B7D5C06A")
    
@Override
    public final int hashCode() {
        return this.canonicalName.hashCode();
    }

    /**
     * Gets a string representation of this charset. Usually this contains the
     * canonical name of the charset.
     *
     * @return a string representation of this charset.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:01.346 -0500", hash_original_method = "D15E03733F40849FC8BB6457075A7CA1", hash_generated_method = "9E43C2B288DD8DD507CF994805407C45")
    
@Override
    public final String toString() {
        return getClass().getName() + "[" + this.canonicalName + "]";
    }
}

