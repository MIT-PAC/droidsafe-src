package java.util.regex;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import droidsafe.helpers.DSUtils;

public final class Pattern implements Serializable {

    /**
     * Returns a compiled form of the given {@code regularExpression}, as modified by the
     * given {@code flags}. See the <a href="#flags">flags overview</a> for more on flags.
     *
     * @throws PatternSyntaxException if the regular expression is syntactically incorrect.
     *
     * @see #CANON_EQ
     * @see #CASE_INSENSITIVE
     * @see #COMMENTS
     * @see #DOTALL
     * @see #LITERAL
     * @see #MULTILINE
     * @see #UNICODE_CASE
     * @see #UNIX_LINES
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.881 -0500", hash_original_method = "029800E42310A5C751B07B4109A52530", hash_generated_method = "480AB8A4C0BB731089E7125A8D3EDCD6")
    
public static Pattern compile(String regularExpression, int flags) throws PatternSyntaxException {
        return new Pattern(regularExpression, flags);
    }

    /**
     * Equivalent to {@code Pattern.compile(pattern, 0)}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.883 -0500", hash_original_method = "F247F5CF281C5F9996F6C94B5EA92FED", hash_generated_method = "314F6EA271F181E366513165FAC3D0EC")
    
public static Pattern compile(String pattern) {
        return new Pattern(pattern, 0);
    }

    /**
     * Tests whether the given {@code regularExpression} matches the given {@code input}.
     * Equivalent to {@code Pattern.compile(regularExpression).matcher(input).matches()}.
     * If the same regular expression is to be used for multiple operations, it may be more
     * efficient to reuse a compiled {@code Pattern}.
     *
     * @see Pattern#compile(java.lang.String, int)
     * @see Matcher#matches()
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.891 -0500", hash_original_method = "3E791313A82E18EC1ADA7594E9746E1F", hash_generated_method = "A62C31C049A9EDD862B1DBC9F26CF5B2")
    
public static boolean matches(String regularExpression, CharSequence input) {
        return new Matcher(new Pattern(regularExpression, 0), input).matches();
    }

    /**
     * Quotes the given {@code string} using "\Q" and "\E", so that all
     * meta-characters lose their special meaning. This method correctly
     * escapes embedded instances of "\Q" or "\E". If the entire result
     * is to be passed verbatim to {@link #compile}, it's usually clearer
     * to use the {@link #LITERAL} flag instead.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.895 -0500", hash_original_method = "B294BEEA973D4CB6A8EA737C4F56E6F2", hash_generated_method = "91B1AE274685940131731B45422E6FFE")
    
public static String quote(String string) {
        StringBuilder sb = new StringBuilder();
        sb.append("\\Q");
        int apos = 0;
        int k;
        while ((k = string.indexOf("\\E", apos)) >= 0) {
            sb.append(string.substring(apos, k + 2)).append("\\\\E\\Q");
            apos = k + 2;
        }
        return sb.append(string.substring(apos)).append("\\E").toString();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void closeImpl(int addr) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int compileImpl(String regex, int flags) {
        return (regex.getTaintInt() + flags);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.833 -0500", hash_original_field = "28B78F8205583CDA257F5D62102A6F9A", hash_generated_field = "89AAD938CC344AC32E4A8CD5D4DF86F6")

    private static final long serialVersionUID = 5073258162644648461L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.836 -0500", hash_original_field = "4CAF10EDA129FF0E1AD4D046D1BC9195", hash_generated_field = "F6F493319E476C50F27832143F659D81")

    public static final int UNIX_LINES = 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.839 -0500", hash_original_field = "1E0F2543DCE2B197080F9E6D6E778936", hash_generated_field = "60FD4E252AB372E1CF2E8086A13086A7")

    public static final int CASE_INSENSITIVE = 0x02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.841 -0500", hash_original_field = "2261FFCADA033E9AF30257383E49AACC", hash_generated_field = "BC52C5452B22EB80FA6F1B6D6AB60466")

    public static final int COMMENTS = 0x04;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.844 -0500", hash_original_field = "A066B83E93EB5BFB08150EDF109A71B7", hash_generated_field = "C887CB44F5482B57F958812A8E704C6B")

    public static final int MULTILINE = 0x08;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.846 -0500", hash_original_field = "8BA02B218EA03AE3AC89FF512BEDAC79", hash_generated_field = "0059CEB2E7FDFB976BF18743C74D0C30")

    public static final int LITERAL = 0x10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.849 -0500", hash_original_field = "0EF0739E47300AC412B5DAC2AB10882E", hash_generated_field = "C3C5A9C94AED77D6EDA7C1E3D3ABFFF8")

    public static final int DOTALL = 0x20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.852 -0500", hash_original_field = "AA3002D3702937AF1326969C68943820", hash_generated_field = "268D1E6E79C1B435EF2D8E59BC94F66D")

    public static final int UNICODE_CASE = 0x40;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.855 -0500", hash_original_field = "2D941DE314551851CA9D72FDFE4092E7", hash_generated_field = "BF4401BCE687E6749EB42AF0574D67ED")

    public static final int CANON_EQ = 0x80;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.858 -0500", hash_original_field = "57C08BF52FBB9452CE610A98F88E4F24", hash_generated_field = "8AE769BFE2CAD1B10C494CCD4D4D489A")

    private  String pattern;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.860 -0500", hash_original_field = "E0CDE1A38A40425C446F52269E5723DC", hash_generated_field = "C01DA7975DA485EEDBF522635D053B3B")

    private  int flags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.863 -0500", hash_original_field = "0EFD4B56D5F68F850B84173C34758709", hash_generated_field = "837A3237EDA74EDFA4F880469076F652")

    transient int address;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.886 -0500", hash_original_method = "F3225888DE48ADF8B6D1D654970A412C", hash_generated_method = "94A2C7A6AEB5FDCD4C4ADCB3D65CA700")
    
private Pattern(String pattern, int flags) throws PatternSyntaxException {
        if ((flags & CANON_EQ) != 0) {
            throw new UnsupportedOperationException("CANON_EQ flag not supported");
        }
        this.pattern = pattern;
        this.flags = flags;
        compile();
    }

    /**
     * Returns a {@link Matcher} for this pattern applied to the given {@code input}.
     * The {@code Matcher} can be used to match the {@code Pattern} against the
     * whole input, find occurrences of the {@code Pattern} in the input, or
     * replace parts of the input.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.865 -0500", hash_original_method = "82136F98856305B5433C94AE9E660844", hash_generated_method = "6247DAB9589B3A3E075EEED0324C9415")
    
public Matcher matcher(CharSequence input) {
        return new Matcher(this, input);
    }

    /**
     * Splits the given {@code input} at occurrences of this pattern.
     *
     * <p>If this pattern does not occur in the input, the result is an
     * array containing the input (converted from a {@code CharSequence} to
     * a {@code String}).
     *
     * <p>Otherwise, the {@code limit} parameter controls the contents of the
     * returned array as described below.
     *
     * @param limit
     *            Determines the maximum number of entries in the resulting
     *            array, and the treatment of trailing empty strings.
     *            <ul>
     *            <li>For n &gt; 0, the resulting array contains at most n
     *            entries. If this is fewer than the number of matches, the
     *            final entry will contain all remaining input.
     *            <li>For n &lt; 0, the length of the resulting array is
     *            exactly the number of occurrences of the {@code Pattern}
     *            plus one for the text after the final separator.
     *            All entries are included.
     *            <li>For n == 0, the result is as for n &lt; 0, except
     *            trailing empty strings will not be returned. (Note that
     *            the case where the input is itself an empty string is
     *            special, as described above, and the limit parameter does
     *            not apply there.)
     *            </ul>
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.868 -0500", hash_original_method = "F7B5873C63BE8AA500AA3CBEE5803928", hash_generated_method = "210B3786FCACE3FBF89CF5B32240270F")
    
public String[] split(CharSequence input, int limit) {
        return Splitter.split(this, pattern, input.toString(), limit);
    }

    /**
     * Equivalent to {@code split(input, 0)}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.871 -0500", hash_original_method = "B852F916561127A3CF7FAAC0D8165D0A", hash_generated_method = "B84ECDD806870D0D60721DE823F133D8")
    
public String[] split(CharSequence input) {
        return split(input, 0);
    }

    /**
     * Returns the regular expression supplied to {@code compile}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.873 -0500", hash_original_method = "266BA96807DA041E9813A92F169CCF9C", hash_generated_method = "0A731FC248A3FE6465B6CF6C9455B5A1")
    
public String pattern() {
        return pattern;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.876 -0500", hash_original_method = "78D8A2FB7B521C80E554EF489653C471", hash_generated_method = "6B49183A6FDA825A00C2924AD9BAA3CC")
    
@Override
    public String toString() {
        return pattern;
    }

    /**
     * Returns the flags supplied to {@code compile}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.878 -0500", hash_original_method = "2653DED91010C405DFA7C9A961BBF2C3", hash_generated_method = "E29A98A382618E4AFF86FBD26B701E8F")
    
public int flags() {
        return flags;
    }

    @DSComment("Private Method")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.889 -0500", hash_original_method = "7197179B856EBAB7792F85CCE5015D4A", hash_generated_method = "AA7F043DF2DC9A09E537E20ED58F78E6")
    
private void compile() throws PatternSyntaxException {
        if (pattern == null) {
            throw new NullPointerException("pattern == null");
        }

        String icuPattern = pattern;
        if ((flags & LITERAL) != 0) {
            icuPattern = quote(pattern);
        }

        // These are the flags natively supported by ICU.
        // They even have the same value in native code.
        int icuFlags = flags & (CASE_INSENSITIVE | COMMENTS | MULTILINE | DOTALL | UNIX_LINES);

        address = compileImpl(icuPattern, icuFlags);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.897 -0500", hash_original_method = "40BF36D36128D4529051C108E3BC0352", hash_generated_method = "46D41D65869DB995C823889BE4DFB5A5")
    
@Override protected void finalize() throws Throwable {
        try {
            closeImpl(address);
        } finally {
            super.finalize();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.900 -0500", hash_original_method = "53B6DF024185B8C2D6E69EA267F8FA46", hash_generated_method = "03705951898BB4A4F0A5F822FE183671")
    
private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        compile();
    }
}

