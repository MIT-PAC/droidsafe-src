package java.util.regex;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import droidsafe.helpers.DSUtils;

public final class Matcher implements MatchResult {

    /**
     * Returns a replacement string for the given one that has all backslashes
     * and dollar signs escaped.
     *
     * @param s
     *            the input string.
     * @return the input string, with all backslashes and dollar signs having
     *         been escaped.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.337 -0500", hash_original_method = "412B90C2E6660CBD34B9FCD7AA411423", hash_generated_method = "5C0A490BD2CE9B2C5AFFFA4AB2680065")
    
public static String quoteReplacement(String s) {
        StringBuilder result = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '\\' || c == '$') {
                result.append('\\');
            }
            result.append(c);
        }
        return result.toString();
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void closeImpl(int addr) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean findImpl(int addr, String s, int startIndex, int[] offsets) {
        return toTaintBoolean((addr + s.getTaintInt() + startIndex + offsets[0] + offsets.getTaintInt()));
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean findNextImpl(int addr, String s, int[] offsets) {
        return toTaintBoolean((addr + s.getTaintInt() + offsets[0] + offsets.getTaintInt()));
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int groupCountImpl(int addr) {
        return addr;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean hitEndImpl(int addr) {
        return toTaintBoolean(addr);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean lookingAtImpl(int addr, String s, int[] offsets) {
        return toTaintBoolean((addr + s.getTaintInt() + offsets[0] + offsets.getTaintInt()));
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean matchesImpl(int addr, String s, int[] offsets) {
        return toTaintBoolean((addr + s.getTaintInt() + offsets[0] + offsets.getTaintInt()));
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int openImpl(int patternAddr) {
        return patternAddr;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static boolean requireEndImpl(int addr) {
        return toTaintBoolean(addr);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void setInputImpl(int addr, String s, int start, int end) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void useAnchoringBoundsImpl(int addr, boolean value) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void useTransparentBoundsImpl(int addr, boolean value) {
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.253 -0500", hash_original_field = "6E570AE90FE80F8D699376520DF9AF12", hash_generated_field = "F8E35FE12BF69D119F3D49E111B1D9A2")

    private Pattern pattern;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.256 -0500", hash_original_field = "0EFD4B56D5F68F850B84173C34758709", hash_generated_field = "849BAB492558B51E7BC4F1C331A435E4")

    private int address;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.258 -0500", hash_original_field = "5C462996083F0F42B19C9D5F27993F9B", hash_generated_field = "6283A1859476002FA59A8C77FB48608E")

    private String input;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.261 -0500", hash_original_field = "E221F04B79BCADEE1DA42928436D8A71", hash_generated_field = "4BFD2E9911A5B09AFA78246F140BA69E")

    private int regionStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.264 -0500", hash_original_field = "DAB290A72B637B9964872BC0AD517090", hash_generated_field = "81B8E8F63D0573D4ED10DF96945C6FEF")

    private int regionEnd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.266 -0500", hash_original_field = "D6C7E040FF5993B1FC6E671FF05B4952", hash_generated_field = "12D45F7A9DCD34D02837FD43189B6ED4")

    private int findPos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.269 -0500", hash_original_field = "628DD164F70FA1C37462BE7AA55AE2B5", hash_generated_field = "7897EAE2C904551FD3FBA85C5C84AFAC")

    private int appendPos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.271 -0500", hash_original_field = "13B102BDCA7D7704F167E32C0D02D022", hash_generated_field = "7C4C3171C0696160D17E6982793E0AF8")

    private boolean matchFound;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.274 -0500", hash_original_field = "B771E42E7E97191E934E9D468633CEF0", hash_generated_field = "6F546FFAFB8033C940863BBC52B1D28B")

    private int[] matchOffsets;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.276 -0500", hash_original_field = "6935A1DC0C54A1FDF57120833FF4915D", hash_generated_field = "84D0C0F3D7AD96896E61ACD06804F92F")

    private boolean anchoringBounds = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.278 -0500", hash_original_field = "090B82930260019A97CA434100CA47CF", hash_generated_field = "9AD9F3963812EC3748D564A27742AD96")

    private boolean transparentBounds;

    /**
     * Creates a matcher for a given combination of pattern and input. Both
     * elements can be changed later on.
     *
     * @param pattern
     *            the pattern to use.
     * @param input
     *            the input to use.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.282 -0500", hash_original_method = "3CAF328B13970C51C4DF071BCDFD21EA", hash_generated_method = "3CAF328B13970C51C4DF071BCDFD21EA")
    
Matcher(Pattern pattern, CharSequence input) {
        usePattern(pattern);
        reset(input);
    }

    /**
     * Appends a literal part of the input plus a replacement for the current
     * match to a given {@link StringBuffer}. The literal part is exactly the
     * part of the input between the previous match and the current match. The
     * method can be used in conjunction with {@link #find()} and
     * {@link #appendTail(StringBuffer)} to walk through the input and replace
     * all occurrences of the {@code Pattern} with something else.
     *
     * @param buffer
     *            the {@code StringBuffer} to append to.
     * @param replacement
     *            the replacement text.
     * @return the {@code Matcher} itself.
     * @throws IllegalStateException
     *             if no successful match has been made.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.284 -0500", hash_original_method = "0ABA3494B4138038176605DE83A643DA", hash_generated_method = "57D827A243CBB13E27B2C47A1F00497F")
    
public Matcher appendReplacement(StringBuffer buffer, String replacement) {
        buffer.append(input.substring(appendPos, start()));
        appendEvaluated(buffer, replacement);
        appendPos = end();

        return this;
    }

    /**
     * Internal helper method to append a given string to a given string buffer.
     * If the string contains any references to groups, these are replaced by
     * the corresponding group's contents.
     *
     * @param buffer
     *            the string buffer.
     * @param s
     *            the string to append.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.287 -0500", hash_original_method = "5B3F4DCDB18701B7EDED77C3B9D3C550", hash_generated_method = "1059C2B39BA7CB5FDAEFB1C86FD435AA")
    
private void appendEvaluated(StringBuffer buffer, String s) {
        boolean escape = false;
        boolean dollar = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '\\' && !escape) {
                escape = true;
            } else if (c == '$' && !escape) {
                dollar = true;
            } else if (c >= '0' && c <= '9' && dollar) {
                buffer.append(group(c - '0'));
                dollar = false;
            } else {
                buffer.append(c);
                dollar = false;
                escape = false;
            }
        }

        // This seemingly stupid piece of code reproduces a JDK bug.
        if (escape) {
            throw new ArrayIndexOutOfBoundsException(s.length());
        }
    }

    /**
     * Resets the {@code Matcher}. This results in the region being set to the
     * whole input. Results of a previous find get lost. The next attempt to
     * find an occurrence of the {@link Pattern} in the string will start at the
     * beginning of the input.
     *
     * @return the {@code Matcher} itself.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.290 -0500", hash_original_method = "9AD9707639C16EE18626C91A471BEAF6", hash_generated_method = "4D667382892858143D169D9743A5A820")
    
public Matcher reset() {
        return reset(input, 0, input.length());
    }

    /**
     * Provides a new input and resets the {@code Matcher}. This results in the
     * region being set to the whole input. Results of a previous find get lost.
     * The next attempt to find an occurrence of the {@link Pattern} in the
     * string will start at the beginning of the input.
     *
     * @param input
     *            the new input sequence.
     *
     * @return the {@code Matcher} itself.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.293 -0500", hash_original_method = "6A88D6B012E13AB6428E01867B9DB072", hash_generated_method = "F0DB5BA28D3FD055B8E50A7F9BD86263")
    
public Matcher reset(CharSequence input) {
        return reset(input, 0, input.length());
    }

    /**
     * Resets the Matcher. A new input sequence and a new region can be
     * specified. Results of a previous find get lost. The next attempt to find
     * an occurrence of the Pattern in the string will start at the beginning of
     * the region. This is the internal version of reset() to which the several
     * public versions delegate.
     *
     * @param input
     *            the input sequence.
     * @param start
     *            the start of the region.
     * @param end
     *            the end of the region.
     *
     * @return the matcher itself.
     */
    @DSComment("Private Method")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.295 -0500", hash_original_method = "1E13D8D8B85E56AF9BB58282CB9C7392", hash_generated_method = "0FE0075551BE07BF37B703967428CA6E")
    
private Matcher reset(CharSequence input, int start, int end) {
        if (input == null) {
            throw new IllegalArgumentException();
        }

        if (start < 0 || end < 0 || start > input.length() || end > input.length() || start > end) {
            throw new IndexOutOfBoundsException();
        }

        this.input = input.toString();
        this.regionStart = start;
        this.regionEnd = end;
        resetForInput();

        matchFound = false;
        findPos = regionStart;
        appendPos = 0;

        return this;
    }

    /**
     * Sets a new pattern for the {@code Matcher}. Results of a previous find
     * get lost. The next attempt to find an occurrence of the {@link Pattern}
     * in the string will start at the beginning of the input.
     *
     * @param pattern
     *            the new {@code Pattern}.
     *
     * @return the {@code Matcher} itself.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.298 -0500", hash_original_method = "2FE41CFA985CF6A9EFE2D0795A2797F8", hash_generated_method = "2A67705620C5FED45539FA2A8AC5BCAF")
    
public Matcher usePattern(Pattern pattern) {
        if (pattern == null) {
            throw new IllegalArgumentException();
        }

        this.pattern = pattern;

        if (address != 0) {
            closeImpl(address);
            address = 0;
        }
        address = openImpl(pattern.address);

        if (input != null) {
            resetForInput();
        }

        matchOffsets = new int[(groupCount() + 1) * 2];
        matchFound = false;
        return this;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.300 -0500", hash_original_method = "4B8F5281B8D449CBFD7748E2AB98FC6B", hash_generated_method = "3687FD6AD64E4420BA08D2A6C33C4568")
    
private void resetForInput() {
        setInputImpl(address, input, regionStart, regionEnd);
        useAnchoringBoundsImpl(address, anchoringBounds);
        useTransparentBoundsImpl(address, transparentBounds);
    }

    /**
     * Resets this matcher and sets a region. Only characters inside the region
     * are considered for a match.
     *
     * @param start
     *            the first character of the region.
     * @param end
     *            the first character after the end of the region.
     * @return the {@code Matcher} itself.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.303 -0500", hash_original_method = "764159AB96CDD9290AC2E4282412C52D", hash_generated_method = "8C82E85DEB08E4AD4A6B6EC8A7E2BD0C")
    
public Matcher region(int start, int end) {
        return reset(input, start, end);
    }

    /**
     * Appends the (unmatched) remainder of the input to the given
     * {@link StringBuffer}. The method can be used in conjunction with
     * {@link #find()} and {@link #appendReplacement(StringBuffer, String)} to
     * walk through the input and replace all matches of the {@code Pattern}
     * with something else.
     *
     * @param buffer
     *            the {@code StringBuffer} to append to.
     * @return the {@code StringBuffer}.
     * @throws IllegalStateException
     *             if no successful match has been made.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.306 -0500", hash_original_method = "26B8601C4A947AF0FE4D833433D4DFA4", hash_generated_method = "3A04BD6B9EC09919B6409CEF75406050")
    
public StringBuffer appendTail(StringBuffer buffer) {
        if (appendPos < regionEnd) {
            buffer.append(input.substring(appendPos, regionEnd));
        }
        return buffer;
    }

    /**
     * Replaces the first occurrence of this matcher's pattern in the input with
     * a given string.
     *
     * @param replacement
     *            the replacement text.
     * @return the modified input string.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.308 -0500", hash_original_method = "902CB288EB494C9205FE6BF90EDE4AF5", hash_generated_method = "FC1FE090735FBE5C0F1CC10B889AFD9F")
    
public String replaceFirst(String replacement) {
        reset();
        StringBuffer buffer = new StringBuffer(input.length());
        if (find()) {
            appendReplacement(buffer, replacement);
        }
        return appendTail(buffer).toString();
    }

    /**
     * Replaces all occurrences of this matcher's pattern in the input with a
     * given string.
     *
     * @param replacement
     *            the replacement text.
     * @return the modified input string.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.312 -0500", hash_original_method = "DCC3E518C2D0EED9BFA3E6DD970895A0", hash_generated_method = "36D843F1C66F77DDBDC244F3701C2300")
    
public String replaceAll(String replacement) {
        reset();
        StringBuffer buffer = new StringBuffer(input.length());
        while (find()) {
            appendReplacement(buffer, replacement);
        }
        return appendTail(buffer).toString();
    }

    /**
     * Returns the {@link Pattern} instance used inside this matcher.
     *
     * @return the {@code Pattern} instance.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.314 -0500", hash_original_method = "29D81214171EEBB46568323FF70F06B8", hash_generated_method = "80B68F97348D33B2EBEFAA36485AA577")
    
public Pattern pattern() {
        return pattern;
    }

    /**
     * Returns the text that matched a given group of the regular expression.
     * Explicit capturing groups in the pattern are numbered left to right in order
     * of their <i>opening</i> parenthesis, starting at 1.
     * The special group 0 represents the entire match (as if the entire pattern is surrounded
     * by an implicit capturing group).
     * For example, "a((b)c)" matching "abc" would give the following groups:
     * <pre>
     * 0 "abc"
     * 1 "bc"
     * 2 "b"
     * </pre>
     *
     * <p>An optional capturing group that failed to match as part of an overall
     * successful match (for example, "a(b)?c" matching "ac") returns null.
     * A capturing group that matched the empty string (for example, "a(b?)c" matching "ac")
     * returns the empty string.
     *
     * @throws IllegalStateException
     *             if no successful match has been made.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.316 -0500", hash_original_method = "C5DB0A67F29696168A3714469C702630", hash_generated_method = "17F81C3787B9565BD1B0254B8E1B8ADF")
    
public String group(int group) {
        ensureMatch();
        int from = matchOffsets[group * 2];
        int to = matchOffsets[(group * 2) + 1];
        if (from == -1 || to == -1) {
            return null;
        } else {
            return input.substring(from, to);
        }
    }

    /**
     * Returns the text that matched the whole regular expression.
     *
     * @return the text.
     * @throws IllegalStateException
     *             if no successful match has been made.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.319 -0500", hash_original_method = "B66B9D5A22E4810AC45D3DC362BC1AC2", hash_generated_method = "B39BB31E1BE3EBDBA3318B7C22DF6856")
    
public String group() {
        return group(0);
    }

    /**
     * Returns the next occurrence of the {@link Pattern} in the input. The
     * method starts the search from the given character in the input.
     *
     * @param start
     *            The index in the input at which the find operation is to
     *            begin. If this is less than the start of the region, it is
     *            automatically adjusted to that value. If it is beyond the end
     *            of the region, the method will fail.
     * @return true if (and only if) a match has been found.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.321 -0500", hash_original_method = "1E0A41464CCCF143B80A589A774A22D2", hash_generated_method = "A2A5E4E76B9D8B6E5F60E9F4BC7C4ADD")
    
public boolean find(int start) {
        findPos = start;

        if (findPos < regionStart) {
            findPos = regionStart;
        } else if (findPos >= regionEnd) {
            matchFound = false;
            return false;
        }

        matchFound = findImpl(address, input, findPos, matchOffsets);
        if (matchFound) {
            findPos = matchOffsets[1];
        }
        return matchFound;
    }

    /**
     * Returns the next occurrence of the {@link Pattern} in the input. If a
     * previous match was successful, the method continues the search from the
     * first character following that match in the input. Otherwise it searches
     * either from the region start (if one has been set), or from position 0.
     *
     * @return true if (and only if) a match has been found.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.324 -0500", hash_original_method = "B9818686B652967984036901E54AA9CC", hash_generated_method = "563384DBAAC5EDE43CB5E15DE2F7DCAB")
    
public boolean find() {
        matchFound = findNextImpl(address, input, matchOffsets);
        if (matchFound) {
            findPos = matchOffsets[1];
        }
        return matchFound;
    }

    /**
     * Tries to match the {@link Pattern}, starting from the beginning of the
     * region (or the beginning of the input, if no region has been set).
     * Doesn't require the {@code Pattern} to match against the whole region.
     *
     * @return true if (and only if) the {@code Pattern} matches.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.327 -0500", hash_original_method = "97077CE30676723FC89EE7203F75639E", hash_generated_method = "F235DFCFCD7F82EF9AFA030CD1FA494C")
    
public boolean lookingAt() {
        matchFound = lookingAtImpl(address, input, matchOffsets);
        if (matchFound) {
            findPos = matchOffsets[1];
        }
        return matchFound;
    }

    /**
     * Tries to match the {@link Pattern} against the entire region (or the
     * entire input, if no region has been set).
     *
     * @return true if (and only if) the {@code Pattern} matches the entire
     *         region.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.330 -0500", hash_original_method = "F2B231DFAE39F525F974692AFF77961B", hash_generated_method = "CC2B8D9B8A5E27DF79CC905F2BE1F277")
    
public boolean matches() {
        matchFound = matchesImpl(address, input, matchOffsets);
        if (matchFound) {
            findPos = matchOffsets[1];
        }
        return matchFound;
    }

    /**
     * Returns the index of the first character of the text that matched a given
     * group.
     *
     * @param group
     *            the group, ranging from 0 to groupCount() - 1, with 0
     *            representing the whole pattern.
     * @return the character index.
     * @throws IllegalStateException
     *             if no successful match has been made.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.332 -0500", hash_original_method = "AB3FAB8AD474566DF13ED737E690D125", hash_generated_method = "C9F93BAC225C470B9A43EA17AC68246C")
    
public int start(int group) throws IllegalStateException {
        ensureMatch();
        return matchOffsets[group * 2];
    }

    /**
     * Returns the index of the first character following the text that matched
     * a given group.
     *
     * @param group
     *            the group, ranging from 0 to groupCount() - 1, with 0
     *            representing the whole pattern.
     * @return the character index.
     * @throws IllegalStateException
     *             if no successful match has been made.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.335 -0500", hash_original_method = "3B2B065B47272EA82FEECDA7C28418A1", hash_generated_method = "DCAE168E828A3CB300DD535007B50601")
    
public int end(int group) {
        ensureMatch();
        return matchOffsets[(group * 2) + 1];
    }

    /**
     * Returns the index of the first character of the text that matched the
     * whole regular expression.
     *
     * @return the character index.
     * @throws IllegalStateException
     *             if no successful match has been made.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.340 -0500", hash_original_method = "B8A7B4640F8CA15D86AD2B2DA38E6CD3", hash_generated_method = "418FAD9CD57B1DF307E434ACAC1968EE")
    
public int start() {
        return start(0);
    }

    /**
     * Returns the number of groups in the results, which is always equal to
     * the number of groups in the original regular expression.
     *
     * @return the number of groups.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.342 -0500", hash_original_method = "2C579AC6636E2BB6A85949F583F18EF9", hash_generated_method = "BF92F82CA65A332BEDA014B468BCBADD")
    
public int groupCount() {
        return groupCountImpl(address);
    }

    /**
     * Returns the index of the first character following the text that matched
     * the whole regular expression.
     *
     * @return the character index.
     * @throws IllegalStateException
     *             if no successful match has been made.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.345 -0500", hash_original_method = "57032B96B3878CEC3CD253F707148B38", hash_generated_method = "CC234EA5E37E807494135274DD1A4092")
    
public int end() {
        return end(0);
    }

    /**
     * Converts the current match into a separate {@link MatchResult} instance
     * that is independent from this matcher. The new object is unaffected when
     * the state of this matcher changes.
     *
     * @return the new {@code MatchResult}.
     * @throws IllegalStateException
     *             if no successful match has been made.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.348 -0500", hash_original_method = "AA5E91AED2A0230E676820BFF0A777EF", hash_generated_method = "CA9ED716ED2088486B8FAB0EACD3EE7E")
    
public MatchResult toMatchResult() {
        ensureMatch();
        return new MatchResultImpl(input, matchOffsets);
    }

    /**
     * Determines whether this matcher has anchoring bounds enabled or not. When
     * anchoring bounds are enabled, the start and end of the input match the
     * '^' and '$' meta-characters, otherwise not. Anchoring bounds are enabled
     * by default.
     *
     * @param value
     *            the new value for anchoring bounds.
     * @return the {@code Matcher} itself.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.350 -0500", hash_original_method = "785D7AD880670D6D8A0DF6FCE0749ACB", hash_generated_method = "EDA23E10272D09A6B3C2CF7A4A28DC19")
    
public Matcher useAnchoringBounds(boolean value) {
        anchoringBounds = value;
        useAnchoringBoundsImpl(address, value);
        return this;
    }

    /**
     * Indicates whether this matcher has anchoring bounds enabled. When
     * anchoring bounds are enabled, the start and end of the input match the
     * '^' and '$' meta-characters, otherwise not. Anchoring bounds are enabled
     * by default.
     *
     * @return true if (and only if) the {@code Matcher} uses anchoring bounds.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.353 -0500", hash_original_method = "56179EEEB1BB6D253C6C82DD4DB81ED5", hash_generated_method = "18CE5E3E77DB977F3B95FE9B38EC4A03")
    
public boolean hasAnchoringBounds() {
        return anchoringBounds;
    }

    /**
     * Determines whether this matcher has transparent bounds enabled or not.
     * When transparent bounds are enabled, the parts of the input outside the
     * region are subject to lookahead and lookbehind, otherwise they are not.
     * Transparent bounds are disabled by default.
     *
     * @param value
     *            the new value for transparent bounds.
     * @return the {@code Matcher} itself.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.355 -0500", hash_original_method = "EB1ABBA9A1AC428A5376D92D0ECDDD75", hash_generated_method = "B08B3A0DADC6C8E514CD9EA0934E24A9")
    
public Matcher useTransparentBounds(boolean value) {
        transparentBounds = value;
        useTransparentBoundsImpl(address, value);
        return this;
    }

    /**
     * Makes sure that a successful match has been made. Is invoked internally
     * from various places in the class.
     *
     * @throws IllegalStateException
     *             if no successful match has been made.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.358 -0500", hash_original_method = "62DD7ED3C887DF9CAF781EDBA38B8A50", hash_generated_method = "29C7770F294FC656D07D466B02A78774")
    
private void ensureMatch() {
        if (!matchFound) {
            throw new IllegalStateException("No successful match so far");
        }
    }

    /**
     * Indicates whether this matcher has transparent bounds enabled. When
     * transparent bounds are enabled, the parts of the input outside the region
     * are subject to lookahead and lookbehind, otherwise they are not.
     * Transparent bounds are disabled by default.
     *
     * @return true if (and only if) the {@code Matcher} uses anchoring bounds.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.360 -0500", hash_original_method = "935CF82B5FBC95B795356ABD430E53CE", hash_generated_method = "CEFB23A880BD8E7601151C5A26A2B60A")
    
public boolean hasTransparentBounds() {
        return transparentBounds;
    }

    /**
     * Returns this matcher's region start, that is, the first character that is
     * considered for a match.
     *
     * @return the start of the region.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.362 -0500", hash_original_method = "1309D9DA3902B8EF77EAE3BBEDE0D6E3", hash_generated_method = "3164AD5F9817D9B1ADFA7239E670A2D9")
    
public int regionStart() {
        return regionStart;
    }

    /**
     * Returns this matcher's region end, that is, the first character that is
     * not considered for a match.
     *
     * @return the end of the region.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.365 -0500", hash_original_method = "A2DEE293E79DD1E070648045D7A01545", hash_generated_method = "2B2B696A74FFA6DDB0F0633FC45A2113")
    
public int regionEnd() {
        return regionEnd;
    }

    /**
     * Indicates whether more input might change a successful match into an
     * unsuccessful one.
     *
     * @return true if (and only if) more input might change a successful match
     *         into an unsuccessful one.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.367 -0500", hash_original_method = "6469C197EE58C69EE809CEC9FEDF2877", hash_generated_method = "26DA4060817535BC8379662FF9821E13")
    
public boolean requireEnd() {
        return requireEndImpl(address);
    }

    /**
     * Indicates whether the last match hit the end of the input.
     *
     * @return true if (and only if) the last match hit the end of the input.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.369 -0500", hash_original_method = "EDB1A66CB81652E7B35BD52D60EF4E40", hash_generated_method = "E10AC36B7BD8F6B478BBAF24D7AE3276")
    
public boolean hitEnd() {
        return hitEndImpl(address);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:01.372 -0500", hash_original_method = "40BF36D36128D4529051C108E3BC0352", hash_generated_method = "46D41D65869DB995C823889BE4DFB5A5")
    
@Override protected void finalize() throws Throwable {
        try {
            closeImpl(address);
        } finally {
            super.finalize();
        }
    }
    
}

