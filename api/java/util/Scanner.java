package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.CharBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import libcore.io.IoUtils;

public final class Scanner implements Iterator<String> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.436 -0500", hash_original_field = "B47F8D0CFB8B0A8E74ACEF69EFAAF7CA", hash_generated_field = "198E8DC61E6EE6260DD0FD67EC1BE70A")

    private static final Pattern DEFAULT_DELIMITER = Pattern
            .compile("\\p{javaWhitespace}+");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.438 -0500", hash_original_field = "E6072ECAB98B788CF6574D4C97D8D133", hash_generated_field = "A53C7CC23A0CC495ADEF2FAB7B5DCB77")

    private static final Pattern BOOLEAN_PATTERN = Pattern.compile(
            "true|false", Pattern.CASE_INSENSITIVE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.441 -0500", hash_original_field = "0BF1909410F4A29EC6B6ABDEDC782911", hash_generated_field = "34D957310674ACDBDEF2BA84C8EFAF52")

    private static  Pattern LINE_TERMINATOR;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.443 -0500", hash_original_field = "CF20E0E1E14B42FCBC3774DAA78CE133", hash_generated_field = "6C40428A55C17D2895C0B094BEB1F611")

    private static  Pattern MULTI_LINE_TERMINATOR;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.446 -0500", hash_original_field = "A71AF44F8C916A62639225A5929D8710", hash_generated_field = "3C4C83BD4BB2A832CA90E27F9C78BAE2")

    private static  Pattern LINE_PATTERN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.449 -0500", hash_original_field = "078F02C6E7267763693DC0BE3C6B9AC7", hash_generated_field = "D845CBECA21831ED0A78D9A752686AC5")

    private static final Pattern ANY_PATTERN = Pattern.compile("(?s).*");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.452 -0500", hash_original_field = "0ABE4119F73D0DFB83A02A15D725E728", hash_generated_field = "3BA97B4331D762E18310C69487A4537F")

    private static final int DIPLOID = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.454 -0500", hash_original_field = "EB97D6C44BD18C424D4E82265283D91D", hash_generated_field = "6AD996F6F0E1D10B17B6B57671BFAA93")

    private static final int DEFAULT_RADIX = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.456 -0500", hash_original_field = "28E0DBF2907BB09A2F5C21AB717FC9F5", hash_generated_field = "943912C72E8350CCD8E69B9D60A0C886")

    private static final int DEFAULT_TRUNK_SIZE = 1024;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.459 -0500", hash_original_field = "65616AC57FB84BDA6BF682056C572304", hash_generated_field = "E0D52F97F351E69EECDE3C383EA70269")

    private Readable input;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.461 -0500", hash_original_field = "89091A77A3F40B97932F1F5BA644968C", hash_generated_field = "D260AE04E52CF23D72C8A3D8295E450B")

    private CharBuffer buffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.463 -0500", hash_original_field = "817851E00C2E34D79720AD08AAA6BADB", hash_generated_field = "7320765086863239DD8B2CE732355E5C")

    private Pattern delimiter = DEFAULT_DELIMITER;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.465 -0500", hash_original_field = "C7324B9A1B7E5BCAD3D2B1A512AC9CEE", hash_generated_field = "B6C086223608E4F54F76DF9A158EFEB4")

    private Matcher matcher;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.468 -0500", hash_original_field = "EB84341BC05B1803B3A35E00097AB259", hash_generated_field = "C3DABC3C885E91F4BEBE65D18A5D41DF")

    private int integerRadix = DEFAULT_RADIX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.470 -0500", hash_original_field = "8B296BE1494CF2FB637267DFD6EEFC9C", hash_generated_field = "E93B6DD8D2B917BF94B1E13ADC86BBF9")

    private Locale locale = Locale.getDefault();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.472 -0500", hash_original_field = "D8305FA40AEB30D5626E8AD10AD16362", hash_generated_field = "08240EC224E7D1F658B6C3E2B561656E")

    private int findStartIndex = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.474 -0500", hash_original_field = "8583C5362BF485A0C6C00658F881BB2D", hash_generated_field = "6421FE0EA4BD2B6775B9AA3004FC3126")

    private int preStartIndex = findStartIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.477 -0500", hash_original_field = "D56A6B35B888DDB27932ABF7650D0DD1", hash_generated_field = "C005C413DDA0AFEE3D457FA4BFDF129F")

    private int bufferLength = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.479 -0500", hash_original_field = "3AA5C7F0C9D40E3C1B48B8404423A098", hash_generated_field = "C3C8C0E68189514A1B9B3B296C0A3F2A")

    // is closed.
    private boolean closed = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.482 -0500", hash_original_field = "2D64161965ACCFD5E6EAFC7F1C573898", hash_generated_field = "94160D1F6EC5CF5867F2CCE7946E9FCB")

    private IOException lastIOException;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.484 -0500", hash_original_field = "1C6D1D477DD6E2911B78F6585589561F", hash_generated_field = "FB51DEF3DC08BBEC5FA219733A95DF92")

    private boolean matchSuccessful = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.486 -0500", hash_original_field = "B59EEAA341F75708242A9E3221E821BD", hash_generated_field = "5CD50592C114680F0C3429A3015DD789")

    private DecimalFormat decimalFormat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.488 -0500", hash_original_field = "12665679D2CAFF8C4A053D9B20D5EF70", hash_generated_field = "835E9638D88C3871B5D667F83042A305")

    private boolean inputExhausted = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.491 -0500", hash_original_field = "A51D0ECC63E18EDB9ADABF3293B68917", hash_generated_field = "16846571F2386772C11DF4DB11C6F290")

    private Object cacheHasNextValue = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.493 -0500", hash_original_field = "A4D950C48A6DDF26C40A5B63963E74FC", hash_generated_field = "890CB8D9E7ACCC8E639BDCEBE76016CB")

    private int cachehasNextIndex = -1;

    /**
     * Creates a {@code Scanner} with the specified {@code File} as input. The default charset
     * is applied when reading the file.
     *
     * @param src
     *            the file to be scanned.
     * @throws FileNotFoundException
     *             if the specified file does not exist.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.498 -0500", hash_original_method = "B810C33BB807151E40D15163250E5E02", hash_generated_method = "D26577CCB9043AF802260E163F23AE5F")
    
public Scanner(File src) throws FileNotFoundException {
        this(src, Charset.defaultCharset().name());
    }

    /**
     * Creates a {@code Scanner} with the specified {@code File} as input. The specified charset
     * is applied when reading the file.
     *
     * @param src
     *            the file to be scanned.
     * @param charsetName
     *            the name of the encoding type of the file.
     * @throws FileNotFoundException
     *             if the specified file does not exist.
     * @throws IllegalArgumentException
     *             if the specified coding does not exist.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.500 -0500", hash_original_method = "CF25217F399E81A22DEECAEA7B649FFD", hash_generated_method = "BCC05EBF9F99943E48C097803F5E86A7")
    
public Scanner(File src, String charsetName) throws FileNotFoundException {
        if (src == null) {
            throw new NullPointerException("src == null");
        }
        FileInputStream fis = new FileInputStream(src);
        if (charsetName == null) {
            throw new IllegalArgumentException("charsetName == null");
        }
        try {
            input = new InputStreamReader(fis, charsetName);
        } catch (UnsupportedEncodingException e) {
            IoUtils.closeQuietly(fis);
            throw new IllegalArgumentException(e.getMessage());
        }
        initialization();
    }

    /**
     * Creates a {@code Scanner} on the specified string.
     *
     * @param src
     *            the string to be scanned.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.503 -0500", hash_original_method = "4332C70F225A92CAAA372FEA2EE20E90", hash_generated_method = "9A8745855040CE72758452F40B97FD65")
    
public Scanner(String src) {
        input = new StringReader(src);
        initialization();
    }

    /**
     * Creates a {@code Scanner} on the specified {@code InputStream}. The default charset is
     * applied when decoding the input.
     *
     * @param src
     *            the {@code InputStream} to be scanned.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.505 -0500", hash_original_method = "C892D51D9056C33835D132934536F6A9", hash_generated_method = "1871A8297329316346417FC0FD505506")
    
public Scanner(InputStream src) {
        this(src, Charset.defaultCharset().name());
    }

    /**
     * Creates a {@code Scanner} on the specified {@code InputStream}. The specified charset is
     * applied when decoding the input.
     *
     * @param src
     *            the {@code InputStream} to be scanned.
     * @param charsetName
     *            the encoding type of the {@code InputStream}.
     * @throws IllegalArgumentException
     *             if the specified character set is not found.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.508 -0500", hash_original_method = "BF515108409EAD1D2D6060053F2B8EDA", hash_generated_method = "F01C1A51850B7F9FA80CC88D51BB9A3D")
    
public Scanner(InputStream src, String charsetName) {
        if (src == null) {
            throw new NullPointerException("src == null");
        }
        try {
            input = new InputStreamReader(src, charsetName);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        initialization();
    }

    /**
     * Creates a {@code Scanner} with the specified {@code Readable} as input.
     *
     * @param src
     *            the {@code Readable} to be scanned.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.512 -0500", hash_original_method = "E0E6972A58007CF9E26777BD359FD5D7", hash_generated_method = "2A8F26655E138D46B6E3613B4BE01534")
    
public Scanner(Readable src) {
        if (src == null) {
            throw new NullPointerException();
        }
        input = src;
        initialization();
    }

    /**
     * Creates a {@code Scanner} with the specified {@code ReadableByteChannel} as
     * input. The default charset is applied when decoding the input.
     *
     * @param src
     *            the {@code ReadableByteChannel} to be scanned.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.514 -0500", hash_original_method = "246C896BCE9403BE34073893721DED9F", hash_generated_method = "069714EF3DCA6F62A8E3A391D2BFABFE")
    
public Scanner(ReadableByteChannel src) {
        this(src, Charset.defaultCharset().name());
    }

    /**
     * Creates a {@code Scanner} with the specified {@code ReadableByteChannel} as
     * input. The specified charset is applied when decoding the input.
     *
     * @param src
     *            the {@code ReadableByteChannel} to be scanned.
     * @param charsetName
     *            the encoding type of the content.
     * @throws IllegalArgumentException
     *             if the specified character set is not found.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.517 -0500", hash_original_method = "88C5EB3CF5CA9A4257014ADC8E6F132C", hash_generated_method = "F52F3CC8E84801B31B8691294881609F")
    
public Scanner(ReadableByteChannel src, String charsetName) {
        if (src == null) {
            throw new NullPointerException("src == null");
        }
        if (charsetName == null) {
            throw new IllegalArgumentException("charsetName == null");
        }
        input = Channels.newReader(src, charsetName);
        initialization();
    }

    /**
     * Closes this {@code Scanner} and the underlying input if the input implements
     * {@code Closeable}. If the {@code Scanner} has been closed, this method will have
     * no effect. Any scanning operation called after calling this method will throw
     * an {@code IllegalStateException}.
     *
     * @see Closeable
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.520 -0500", hash_original_method = "BE0E5A82355C52347C0C57A7BA02C4C5", hash_generated_method = "4981E93226D3D642ADB0B81DB0C8464D")
    
public void close() {
        if (closed) {
            return;
        }
        if (input instanceof Closeable) {
            try {
                ((Closeable) input).close();
            } catch (IOException e) {
                lastIOException = e;
            }
        }
        closed = true;
    }

    /**
     * Returns the delimiter {@code Pattern} in use by this {@code Scanner}.
     *
     * @return the delimiter {@code Pattern} in use by this {@code Scanner}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.522 -0500", hash_original_method = "E452C40637B7AD54EC03E79C646861D9", hash_generated_method = "DFF982F44BD23684A397DA7C52C5E9C6")
    
public Pattern delimiter() {
        return delimiter;
    }

    /**
     * Tries to find the pattern in the input. Delimiters are ignored. If the
     * pattern is found before line terminator, the matched string will be
     * returned, and the {@code Scanner} will advance to the end of the matched string.
     * Otherwise, {@code null} will be returned and the {@code Scanner} will not advance.
     * When waiting for input, the {@code Scanner} may be blocked. All the
     * input may be cached if no line terminator exists in the buffer.
     *
     * @param pattern
     *            the pattern to find in the input.
     * @return the matched string or {@code null} if the pattern is not found
     *         before the next line terminator.
     * @throws IllegalStateException
     *             if the {@code Scanner} is closed.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.526 -0500", hash_original_method = "8312FC53E313435440A1A7306CBE2B24", hash_generated_method = "0665BC44FDAB5AFF5C5B8A4F09E9EA4A")
    
public String findInLine(Pattern pattern) {
        checkClosed();
        checkNull(pattern);
        int horizonLineSeparator = 0;

        matcher.usePattern(MULTI_LINE_TERMINATOR);
        matcher.region(findStartIndex, bufferLength);

        boolean findComplete = false;
        int terminatorLength = 0;
        while (!findComplete) {
            if (matcher.find()) {
                horizonLineSeparator = matcher.start();
                terminatorLength = matcher.end() - matcher.start();
                findComplete = true;
            } else {
                if (!inputExhausted) {
                    readMore();
                    resetMatcher();
                } else {
                    horizonLineSeparator = bufferLength;
                    findComplete = true;
                }
            }
        }

        matcher.usePattern(pattern);

        /*
         * TODO The following 2 statements are used to deal with regex's bug.
         * java.util.regex.Matcher.region(int start, int end) implementation
         * does not have any effects when called. They will be removed once the
         * bug is fixed.
         */
        int oldLimit = buffer.limit();
        // Considering the look ahead feature, the line terminator should be involved as RI
        buffer.limit(horizonLineSeparator + terminatorLength);
        // ========== To deal with regex bug ====================

        // Considering the look ahead feature, the line terminator should be involved as RI
        matcher.region(findStartIndex, horizonLineSeparator + terminatorLength);
        if (matcher.find()) {
            // The scanner advances past the input that matched
            findStartIndex = matcher.end();
            // If the matched pattern is immediately followed by line
            // terminator.
            if (horizonLineSeparator == matcher.end()) {
                findStartIndex += terminatorLength;
            }
            // the line terminator itself should not be a part of
            // the match result according to the Spec
            if (horizonLineSeparator != bufferLength
                    && (horizonLineSeparator + terminatorLength == matcher
                            .end())) {
                // ========== To deal with regex bug ====================
                buffer.limit(oldLimit);
                // ========== To deal with regex bug ====================

                matchSuccessful = false;
                return null;
            }
            matchSuccessful = true;

            // ========== To deal with regex bug ====================
            buffer.limit(oldLimit);
            // ========== To deal with regex bug ====================

            return matcher.group();
        }

        // ========== To deal with regex bug ====================
        buffer.limit(oldLimit);
        // ========== To deal with regex bug ====================

        matchSuccessful = false;
        return null;
    }

    /**
     * Compiles the pattern string and tries to find a substing matching it in the input data. The
     * delimiter will be ignored. This is the same as invoking
     * {@code findInLine(Pattern.compile(pattern))}.
     *
     * @param pattern
     *            a string used to construct a pattern which is in turn used to
     *            match a substring of the input data.
     * @return the matched string or {@code null} if the pattern is not found
     *         before the next line terminator.
     * @throws IllegalStateException
     *             if the {@code Scanner} is closed.
     * @see #findInLine(Pattern)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.528 -0500", hash_original_method = "D8B205142F30EEA5F1FA557732B63716", hash_generated_method = "BC32758F998B73A2DB17BCD342A1D048")
    
public String findInLine(String pattern) {
        return findInLine(Pattern.compile(pattern));
    }

    /**
     * Tries to find the pattern in the input between the current position and the specified
     * horizon. Delimiters are ignored. If the pattern is found, the matched
     * string will be returned, and the {@code Scanner} will advance to the end of the
     * matched string. Otherwise, null will be returned and {@code Scanner} will not
     * advance. When waiting for input, the {@code Scanner} may be blocked.
     * <p>
     * The {@code Scanner}'s search will never go more than {@code horizon} code points from current
     * position. The position of {@code horizon} does have an effect on the result of the
     * match. For example, when the input is "123" and current position is at zero,
     * <code>findWithinHorizon(Pattern.compile("\\p{Digit}{3}"), 2)</code>
     * will return {@code null}, while
     * <code>findWithinHorizon(Pattern.compile("\\p{Digit}{3}"), 3)</code>
     * will return {@code "123"}. {@code horizon} is treated as a transparent,
     * non-anchoring bound. (refer to
     * {@link Matcher#useTransparentBounds(boolean)} and
     * {@link Matcher#useAnchoringBounds(boolean)})
     * <p>
     * A {@code horizon} whose value is zero will be ignored and the whole input will be
     * used for search. In this situation, all the input may be cached.
     *
     * @param pattern
     *            the pattern used to scan.
     * @param horizon
     *            the search limit.
     * @return the matched string or {@code null} if the pattern is not found
     *         within the specified {@code horizon}.
     * @throws IllegalStateException
     *             if the {@code Scanner} is closed.
     * @throws IllegalArgumentException
     *             if {@code horizon} is less than zero.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.532 -0500", hash_original_method = "9C32C72D7AABC6AF4F26B68B84901E99", hash_generated_method = "A2989CF0C81C88E8B5DCC98A1B678232")
    
public String findWithinHorizon(Pattern pattern, int horizon) {
        checkClosed();
        checkNull(pattern);
        if (horizon < 0) {
            throw new IllegalArgumentException("horizon < 0");
        }
        matcher.usePattern(pattern);

        String result = null;
        int findEndIndex = 0;
        int horizonEndIndex = 0;
        if (horizon == 0) {
            horizonEndIndex = Integer.MAX_VALUE;
        } else {
            horizonEndIndex = findStartIndex + horizon;
        }
        while (true) {
            findEndIndex = bufferLength;

            // If horizon > 0, then search up to
            // min( bufferLength, findStartIndex + horizon).
            // Otherwise search until readable is exhausted.
            findEndIndex = Math.min(horizonEndIndex, bufferLength);
            // If horizon == 0, consider horizon as always outside buffer.
            boolean isHorizonInBuffer = (horizonEndIndex <= bufferLength);
            // First, try to find pattern within buffer. If pattern can not be
            // found in buffer, then expand the buffer and try again,
            // util horizonEndIndex is exceeded or no more input left.
            matcher.region(findStartIndex, findEndIndex);
            if (matcher.find()) {
                if (isHorizonInBuffer || inputExhausted) {
                    result = matcher.group();
                    break;
                }
            } else {
                // Pattern is not found in buffer while horizonEndIndex is
                // within buffer, or input is exhausted. Under this situation,
                // it can be judged that find fails.
                if (isHorizonInBuffer || inputExhausted) {
                    break;
                }
            }

            // Expand buffer and reset matcher if needed.
            if (!inputExhausted) {
                readMore();
                resetMatcher();
            }
        }
        if (result != null) {
            findStartIndex = matcher.end();
            matchSuccessful = true;
        } else {
            matchSuccessful = false;
        }
        return result;
    }

    /**
     * Tries to find the pattern in the input between the current position and the specified
     * {@code horizon}. Delimiters are ignored. This call is the same as invoking
     * {@code findWithinHorizon(Pattern.compile(pattern))}.
     *
     * @param pattern
     *            the pattern used to scan.
     * @param horizon
     *            the search limit.
     * @return the matched string, or {@code null} if the pattern is not found
     *         within the specified horizon.
     * @throws IllegalStateException
     *             if the {@code Scanner} is closed.
     * @throws IllegalArgumentException
     *             if {@code horizon} is less than zero.
     * @see #findWithinHorizon(Pattern, int)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.534 -0500", hash_original_method = "A3C55B99475A85AD2BF4742E957D07D7", hash_generated_method = "8B42006EAC7EE929F9A09B522FEFB34E")
    
public String findWithinHorizon(String pattern, int horizon) {
        return findWithinHorizon(Pattern.compile(pattern), horizon);
    }

    /**
     * Returns whether this {@code Scanner} has one or more tokens remaining to parse.
     * This method will block if the data is still being read.
     *
     * @return {@code true} if this {@code Scanner} has one or more tokens remaining,
     *         otherwise {@code false}.
     * @throws IllegalStateException
     *             if the {@code Scanner} has been closed.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.536 -0500", hash_original_method = "A3E9F8A3E3BBCA86A059EA14ECB05A95", hash_generated_method = "8ACF5D97C09012CFC95287039A2EEAF0")
    
public boolean hasNext() {
        return hasNext(ANY_PATTERN);
    }

    /**
     * Returns whether this {@code Scanner} has one or more tokens remaining to parse
     * and the next token matches the given pattern. This method will block if the data is
     * still being read.
     *
     * @param pattern
     *            the pattern to check for.
     * @return {@code true} if this {@code Scanner} has more tokens and the next token
     *         matches the pattern, {@code false} otherwise.
     * @throws IllegalStateException
     *             if the {@code Scanner} has been closed.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.539 -0500", hash_original_method = "31E7CF1F7239BC857AE7CC1A1F63EEFE", hash_generated_method = "91000FE766A7F566C442F9715F92DD46")
    
public boolean hasNext(Pattern pattern) {
        checkClosed();
        checkNull(pattern);
        matchSuccessful = false;
        saveCurrentStatus();
        // if the next token exists, set the match region, otherwise return
        // false
        if (!setTokenRegion()) {
            recoverPreviousStatus();
            return false;
        }
        matcher.usePattern(pattern);
        boolean hasNext = false;
        // check whether next token matches the specified pattern
        if (matcher.matches()) {
            cachehasNextIndex = findStartIndex;
            matchSuccessful = true;
            hasNext = true;
        }
        recoverPreviousStatus();
        return hasNext;
    }

    /**
     * Returns {@code true} if this {@code Scanner} has one or more tokens remaining to parse
     * and the next token matches a pattern compiled from the given string. This method will
     * block if the data is still being read. This call is equivalent to
     * {@code hasNext(Pattern.compile(pattern))}.
     *
     * @param pattern
     *            the string specifying the pattern to scan for
     * @return {@code true} if the specified pattern matches this {@code Scanner}'s
     *         next token, {@code false} otherwise.
     * @throws IllegalStateException
     *             if the {@code Scanner} has been closed.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.541 -0500", hash_original_method = "9958A7260053054A7CE88A67057D0BAF", hash_generated_method = "3CAEEBC9983F9DD4125ABDBE34B87EB3")
    
public boolean hasNext(String pattern) {
        return hasNext(Pattern.compile(pattern));
    }

    /**
     * Returns whether the next token can be translated into a valid
     * {@code BigDecimal}.
     *
     * @return {@code true} if the next token can be translated into a valid
     *         {@code BigDecimal}, otherwise {@code false.}
     * @throws IllegalStateException
     *             if the {@code Scanner} has been closed.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.544 -0500", hash_original_method = "725531718FDC15B509CB20755672217B", hash_generated_method = "F3CE9986D9718C8BA2EC07532D1859BA")
    
public boolean hasNextBigDecimal() {
        Pattern floatPattern = getFloatPattern();
        boolean isBigDecimalValue = false;
        if (hasNext(floatPattern)) {
            String floatString = matcher.group();
            floatString = removeLocaleInfoFromFloat(floatString);
            try {
                cacheHasNextValue = new BigDecimal(floatString);
                isBigDecimalValue = true;
            } catch (NumberFormatException e) {
                matchSuccessful = false;
            }
        }
        return isBigDecimalValue;
    }

    /**
     * Returns whether the next token can be translated into a valid
     * {@code BigInteger} in the default radix.
     *
     * @return {@code true} if the next token can be translated into a valid
     *         {@code BigInteger}, otherwise {@code false}.
     * @throws IllegalStateException
     *             if the {@code Scanner} has been closed.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.546 -0500", hash_original_method = "E4D3C235D8E1DAFC304BAA9FB6E2754B", hash_generated_method = "7EE56A2CED0FB3287ABEDB164A2C2507")
    
public boolean hasNextBigInteger() {
        return hasNextBigInteger(integerRadix);
    }

    /**
     * Returns whether the next token can be translated into a valid
     * {@code BigInteger} in the specified radix.
     *
     * @param radix
     *            the radix used to translate the token into a
     *            {@code BigInteger}.
     * @return {@code true} if the next token can be translated into a valid
     *         {@code BigInteger}, otherwise {@code false}.
     * @throws IllegalStateException
     *             if the {@code Scanner} has been closed.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.548 -0500", hash_original_method = "C25E77B6A38D1DC9BA3B0FA0BBEC50D5", hash_generated_method = "CEF42E54E0D157534F17D4FDF6FD2AAE")
    
public boolean hasNextBigInteger(int radix) {
        Pattern integerPattern = getIntegerPattern(radix);
        boolean isBigIntegerValue = false;
        if (hasNext(integerPattern)) {
            String intString = matcher.group();
            intString = removeLocaleInfo(intString, DataType.INT);
            try {
                cacheHasNextValue = new BigInteger(intString, radix);
                isBigIntegerValue = true;
            } catch (NumberFormatException e) {
                matchSuccessful = false;
            }
        }
        return isBigIntegerValue;
    }

    /**
     * Returns whether the next token can be translated into a valid
     * {@code boolean} value.
     *
     * @return {@code true} if the next token can be translated into a valid
     *         {@code boolean} value, otherwise {@code false}.
     * @throws IllegalStateException
     *             if the {@code Scanner} has been closed.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.550 -0500", hash_original_method = "EB649DF4AB30251C023B5B81F2B2B0E4", hash_generated_method = "5E2F13790BE01AB548A4A994457B6D74")
    
public boolean hasNextBoolean() {
        return hasNext(BOOLEAN_PATTERN);
    }

    /**
     * Returns whether the next token can be translated into a valid
     * {@code byte} value in the default radix.
     *
     * @return {@code true} if the next token can be translated into a valid
     *         {@code byte} value, otherwise {@code false}.
     * @throws IllegalStateException
     *             if the {@code Scanner} has been closed.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.553 -0500", hash_original_method = "58199F8244631FBA465F06EC32762D29", hash_generated_method = "66103AC50E2D34E655900B44943C3E44")
    
public boolean hasNextByte() {
        return hasNextByte(integerRadix);
    }

    /**
     * Returns whether the next token can be translated into a valid
     * {@code byte} value in the specified radix.
     *
     * @param radix
     *            the radix used to translate the token into a {@code byte}
     *            value
     * @return {@code true} if the next token can be translated into a valid
     *         {@code byte} value, otherwise {@code false}.
     * @throws IllegalStateException
     *             if the {@code Scanner} has been closed.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.556 -0500", hash_original_method = "A5B80B22ED065BD547115A7BB2F2B96D", hash_generated_method = "765DA349C498F3E2D333DCF93C4154AC")
    
public boolean hasNextByte(int radix) {
        Pattern integerPattern = getIntegerPattern(radix);
        boolean isByteValue = false;
        if (hasNext(integerPattern)) {
            String intString = matcher.group();
            intString = removeLocaleInfo(intString, DataType.INT);
            try {
                cacheHasNextValue = Byte.valueOf(intString, radix);
                isByteValue = true;
            } catch (NumberFormatException e) {
                matchSuccessful = false;
            }
        }
        return isByteValue;
    }

    /**
     * Returns whether the next token translated into a valid {@code double}
     * value.
     *
     * @return {@code true} if the next token can be translated into a valid
     *         {@code double} value, otherwise {@code false}.
     * @throws IllegalStateException
     *             if the {@code Scanner} has been closed.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.558 -0500", hash_original_method = "66A96A75B245956604135FA693CF46B1", hash_generated_method = "F8B531C62063230A6EE1A40D271FC11A")
    
public boolean hasNextDouble() {
        Pattern floatPattern = getFloatPattern();
        boolean isDoubleValue = false;
        if (hasNext(floatPattern)) {
            String floatString = matcher.group();
            floatString = removeLocaleInfoFromFloat(floatString);
            try {
                cacheHasNextValue = Double.valueOf(floatString);
                isDoubleValue = true;
            } catch (NumberFormatException e) {
                matchSuccessful = false;
            }
        }
        return isDoubleValue;
    }

    /**
     * Returns whether the next token can be translated into a valid
     * {@code float} value.
     *
     * @return {@code true} if the next token can be translated into a valid
     *         {@code float} value, otherwise {@code false}.
     * @throws IllegalStateException
     *             if the {@code Scanner} has been closed.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.561 -0500", hash_original_method = "FBD2AAA8FD71EC1957BF71E495BA575B", hash_generated_method = "8F6A1E1F5F736C31E893878B03609D18")
    
public boolean hasNextFloat() {
        Pattern floatPattern = getFloatPattern();
        boolean isFloatValue = false;
        if (hasNext(floatPattern)) {
            String floatString = matcher.group();
            floatString = removeLocaleInfoFromFloat(floatString);
            try {
                cacheHasNextValue = Float.valueOf(floatString);
                isFloatValue = true;
            } catch (NumberFormatException e) {
                matchSuccessful = false;
            }
        }
        return isFloatValue;
    }

    /**
     * Returns whether the next token can be translated into a valid {@code int}
     * value in the default radix.
     *
     * @return {@code true} if the next token can be translated into a valid
     *         {@code int} value, otherwise {@code false}.
     * @throws IllegalStateException
     *             if the {@code Scanner} has been closed,
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.563 -0500", hash_original_method = "5C4A5382507FD210B704AB0FDDE676B5", hash_generated_method = "607A88F24BF4021BB120DA8DCA567014")
    
public boolean hasNextInt() {
        return hasNextInt(integerRadix);
    }

    /**
     * Returns whether the next token can be translated into a valid {@code int}
     * value in the specified radix.
     *
     * @param radix
     *            the radix used to translate the token into an {@code int}
     *            value.
     * @return {@code true} if the next token in this {@code Scanner}'s input can be
     *         translated into a valid {@code int} value, otherwise
     *         {@code false}.
     * @throws IllegalStateException
     *             if the {@code Scanner} has been closed.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.566 -0500", hash_original_method = "98DA0996AE9A85FE2EB4C6BCBC334600", hash_generated_method = "69B1860955268A674911C0D4299B3B4C")
    
public boolean hasNextInt(int radix) {
        Pattern integerPattern = getIntegerPattern(radix);
        boolean isIntValue = false;
        if (hasNext(integerPattern)) {
            String intString = matcher.group();
            intString = removeLocaleInfo(intString, DataType.INT);
            try {
                cacheHasNextValue = Integer.valueOf(intString, radix);
                isIntValue = true;
            } catch (NumberFormatException e) {
                matchSuccessful = false;
            }
        }
        return isIntValue;
    }

    /**
     * Returns whether there is a line terminator in the input.
     * This method may block.
     *
     * @return {@code true} if there is a line terminator in the input,
     *         otherwise, {@code false}.
     * @throws IllegalStateException
     *             if the {@code Scanner} is closed.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.568 -0500", hash_original_method = "F85B53817DDA0DC627A3FD344338966A", hash_generated_method = "E1AA38C47583B8A7FD0F5013C7785A12")
    
public boolean hasNextLine() {
        checkClosed();
        matcher.usePattern(LINE_PATTERN);
        matcher.region(findStartIndex, bufferLength);

        boolean hasNextLine = false;
        while (true) {
            if (matcher.find()) {
                if (inputExhausted || matcher.end() != bufferLength) {
                    matchSuccessful = true;
                    hasNextLine = true;
                    break;
                }
            } else {
                if (inputExhausted) {
                    matchSuccessful = false;
                    break;
                }
            }
            if (!inputExhausted) {
                readMore();
                resetMatcher();
            }
        }
        return hasNextLine;
    }

    /**
     * Returns whether the next token can be translated into a valid
     * {@code long} value in the default radix.
     *
     * @return {@code true} if the next token can be translated into a valid
     *         {@code long} value, otherwise {@code false}.
     * @throws IllegalStateException
     *             if the {@code Scanner} has been closed.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.571 -0500", hash_original_method = "4E2EF7109AFFFF700ACDD8E154A60B95", hash_generated_method = "E1BC5DC88D8FA8113CEC2DA7D72F6A33")
    
public boolean hasNextLong() {
        return hasNextLong(integerRadix);
    }

    /**
     * Returns whether the next token can be translated into a valid
     * {@code long} value in the specified radix.
     *
     * @param radix
     *            the radix used to translate the token into a {@code long}
     *            value.
     * @return {@code true} if the next token can be translated into a valid
     *         {@code long} value, otherwise {@code false}.
     * @throws IllegalStateException
     *             if the {@code Scanner} has been closed.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.574 -0500", hash_original_method = "9F7A3D072C1FB851C44AA1EFB73ED70A", hash_generated_method = "3488429AADF56C1BF642DD376DE24243")
    
public boolean hasNextLong(int radix) {
        Pattern integerPattern = getIntegerPattern(radix);
        boolean isLongValue = false;
        if (hasNext(integerPattern)) {
            String intString = matcher.group();
            intString = removeLocaleInfo(intString, DataType.INT);
            try {
                cacheHasNextValue = Long.valueOf(intString, radix);
                isLongValue = true;
            } catch (NumberFormatException e) {
                matchSuccessful = false;
            }
        }
        return isLongValue;
    }

    /**
     * Returns whether the next token can be translated into a valid
     * {@code short} value in the default radix.
     *
     * @return {@code true} if the next token can be translated into a valid
     *         {@code short} value, otherwise {@code false}.
     * @throws IllegalStateException
     *             if the {@code Scanner} has been closed.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.576 -0500", hash_original_method = "68819BFDCF6E57EBBFC27075215E0009", hash_generated_method = "8DC980CE9BECAAB756362F4C52E78435")
    
public boolean hasNextShort() {
        return hasNextShort(integerRadix);
    }

    /**
     * Returns whether the next token can be translated into a valid
     * {@code short} value in the specified radix.
     *
     * @param radix
     *            the radix used to translate the token into a {@code short}
     *            value.
     * @return {@code true} if the next token can be translated into a valid
     *         {@code short} value, otherwise {@code false}.
     * @throws IllegalStateException
     *             if the {@code Scanner} has been closed.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.579 -0500", hash_original_method = "BC1837EAC21D315C1A66DDC5582DCF81", hash_generated_method = "325B69F645497A2CDF3612F30CB4DFD3")
    
public boolean hasNextShort(int radix) {
        Pattern integerPattern = getIntegerPattern(radix);
        boolean isShortValue = false;
        if (hasNext(integerPattern)) {
            String intString = matcher.group();
            intString = removeLocaleInfo(intString, DataType.INT);
            try {
                cacheHasNextValue = Short.valueOf(intString, radix);
                isShortValue = true;
            } catch (NumberFormatException e) {
                matchSuccessful = false;
            }
        }
        return isShortValue;
    }

    /**
     * Returns the last {@code IOException} that was raised while reading from the underlying
     * input.
     *
     * @return the last thrown {@code IOException}, or {@code null} if none was thrown.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.581 -0500", hash_original_method = "AF5FE6AF92A07FF4E461FEC03ECD4D84", hash_generated_method = "9021EA20032F11132D2B9F300EA6476A")
    
public IOException ioException() {
        return lastIOException;
    }

    /**
     * Return the {@code Locale} of this {@code Scanner}.
     *
     * @return the {@code Locale} of this {@code Scanner}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.583 -0500", hash_original_method = "21C822C4BC15A6F74D874095878E5501", hash_generated_method = "844FD25BD3EAACE05B7B47916D0B681B")
    
public Locale locale() {
        return locale;
    }

    /**
     * Returns the result of the last matching operation.
     * <p>
     * The next* and find* methods return the match result in the case of a
     * successful match.
     *
     * @return the match result of the last successful match operation
     * @throws IllegalStateException
     *             if the match result is not available, of if the last match
     *             was not successful.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.586 -0500", hash_original_method = "2D94F093F10F1A8356EDEC86FADDCA70", hash_generated_method = "5641FECC4850BFBA421BE67B82DBDED5")
    
public MatchResult match() {
        if (!matchSuccessful) {
            throw new IllegalStateException();
        }
        return matcher.toMatchResult();
    }

    /**
     * Returns the next token. The token will be both prefixed and postfixed by
     * the delimiter that is currently being used (or a string that matches the
     * delimiter pattern). This method will block if input is being read.
     *
     * @return the next complete token.
     * @throws IllegalStateException
     *             if this {@code Scanner} has been closed.
     * @throws NoSuchElementException
     *             if input has been exhausted.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.588 -0500", hash_original_method = "A473F9C9E320CD6CEDCE3CE271E08C07", hash_generated_method = "5AD096FC9C61E6884323F08CF48B6FE0")
    
public String next() {
        return next(ANY_PATTERN);
    }

    /**
     * Returns the next token if it matches the specified pattern. The token
     * will be both prefixed and postfixed by the delimiter that is currently
     * being used (or a string that matches the delimiter pattern). This method will block
     * if input is being read.
     *
     * @param pattern
     *            the specified pattern to scan.
     * @return the next token.
     * @throws IllegalStateException
     *             if this {@code Scanner} has been closed.
     * @throws NoSuchElementException
     *             if input has been exhausted.
     * @throws InputMismatchException
     *             if the next token does not match the pattern given.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.590 -0500", hash_original_method = "064C5502A668BA6541E1986AFB8ECCE1", hash_generated_method = "3B0A40E136CAEE9ADB002BDD01A8DD39")
    
public String next(Pattern pattern) {
        checkClosed();
        checkNull(pattern);
        matchSuccessful = false;
        saveCurrentStatus();
        if (!setTokenRegion()) {
            recoverPreviousStatus();
            // if setting match region fails
            throw new NoSuchElementException();
        }
        matcher.usePattern(pattern);
        if (!matcher.matches()) {
            recoverPreviousStatus();
            throw new InputMismatchException();

        }
        matchSuccessful = true;
        return matcher.group();
    }

    /**
     * Returns the next token if it matches the specified pattern. The token
     * will be both prefixed and postfixed by the delimiter that is currently
     * being used (or a string that matches the delimiter pattern). This method will block
     * if input is being read. Calling this method is equivalent to
     * {@code next(Pattern.compile(pattern))}.
     *
     * @param pattern
     *            the string specifying the pattern to scan for.
     * @return the next token.
     * @throws IllegalStateException
     *             if this {@code Scanner} has been closed.
     * @throws NoSuchElementException
     *             if input has been exhausted.
     * @throws InputMismatchException
     *             if the next token does not match the pattern given.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.593 -0500", hash_original_method = "4894718ADE2D067062D34204C5088110", hash_generated_method = "6A7C61792D0E39B4E38E7DBC1DC510B8")
    
public String next(String pattern) {
        return next(Pattern.compile(pattern));
    }

    /**
     * Returns the next token as a {@code BigDecimal}. This method will block if input is
     * being read. If the next token can be translated into a {@code BigDecimal}
     * the following is done: All {@code Locale}-specific prefixes, group separators,
     * and {@code Locale}-specific suffixes are removed. Then non-ASCII digits are
     * mapped into ASCII digits via {@link Character#digit(char, int)}, and a
     * negative sign (-) is added if the {@code Locale}-specific negative prefix or
     * suffix was present. Finally the resulting string is passed to
     * {@code BigDecimal(String) }.
     *
     * @return the next token as a {@code BigDecimal}.
     * @throws IllegalStateException
     *             if this {@code Scanner} has been closed.
     * @throws NoSuchElementException
     *             if input has been exhausted.
     * @throws InputMismatchException
     *             if the next token can not be translated into a valid
     *             {@code BigDecimal}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.595 -0500", hash_original_method = "E9A644C72A3309EE871164344474A07C", hash_generated_method = "A6FC10D084F11C0FD29AA7D7677E5B62")
    
public BigDecimal nextBigDecimal() {
        checkClosed();
        Object obj = cacheHasNextValue;
        cacheHasNextValue = null;
        if (obj instanceof BigDecimal) {
            findStartIndex = cachehasNextIndex;
            return (BigDecimal) obj;
        }
        Pattern floatPattern = getFloatPattern();
        String floatString = next(floatPattern);
        floatString = removeLocaleInfoFromFloat(floatString);
        BigDecimal bigDecimalValue;
        try {
            bigDecimalValue = new BigDecimal(floatString);
        } catch (NumberFormatException e) {
            matchSuccessful = false;
            recoverPreviousStatus();
            throw new InputMismatchException();
        }
        return bigDecimalValue;
    }

    /**
     * Returns the next token as a {@code BigInteger}. This method will block if input is
     * being read. Equivalent to {@code nextBigInteger(DEFAULT_RADIX)}.
     *
     * @return the next token as {@code BigInteger}.
     * @throws IllegalStateException
     *             if this {@code Scanner} has been closed.
     * @throws NoSuchElementException
     *             if input has been exhausted.
     * @throws InputMismatchException
     *             if the next token can not be translated into a valid
     *             {@code BigInteger}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.597 -0500", hash_original_method = "144A2EEE9BFD199E176BF785D76B1260", hash_generated_method = "5B039D66EE6ED1F670308D7D32127FB6")
    
public BigInteger nextBigInteger() {
        return nextBigInteger(integerRadix);
    }

    /**
     * Returns the next token as a {@code BigInteger} with the specified radix.
     * This method will block if input is being read. If the next token can be translated
     * into a {@code BigInteger} the following is done: All {@code Locale}-specific
     * prefixes, group separators, and {@code Locale}-specific suffixes are removed.
     * Then non-ASCII digits are mapped into ASCII digits via
     * {@link Character#digit(char, int)}, and a negative sign (-) is added if the
     * {@code Locale}-specific negative prefix or suffix was present. Finally the
     * resulting String is passed to {@link BigInteger#BigInteger(String, int)}}
     * with the specified radix.
     *
     * @param radix
     *            the radix used to translate the token into a
     *            {@code BigInteger}.
     * @return the next token as a {@code BigInteger}
     * @throws IllegalStateException
     *             if this {@code Scanner} has been closed.
     * @throws NoSuchElementException
     *             if input has been exhausted.
     * @throws InputMismatchException
     *             if the next token can not be translated into a valid
     *             {@code BigInteger}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.600 -0500", hash_original_method = "A32F88E5530C257A4D62223BBE0A1F90", hash_generated_method = "6F0D66E3D4C02FAC893009D665798369")
    
public BigInteger nextBigInteger(int radix) {
        checkClosed();
        Object obj = cacheHasNextValue;
        cacheHasNextValue = null;
        if (obj instanceof BigInteger) {
            findStartIndex = cachehasNextIndex;
            return (BigInteger) obj;
        }
        Pattern integerPattern = getIntegerPattern(radix);
        String intString = next(integerPattern);
        intString = removeLocaleInfo(intString, DataType.INT);
        BigInteger bigIntegerValue;
        try {
            bigIntegerValue = new BigInteger(intString, radix);
        } catch (NumberFormatException e) {
            matchSuccessful = false;
            recoverPreviousStatus();
            throw new InputMismatchException();
        }
        return bigIntegerValue;
    }

    /**
     * Returns the next token as a {@code boolean}. This method will block if input is
     * being read.
     *
     * @return the next token as a {@code boolean}.
     * @throws IllegalStateException
     *             if this {@code Scanner} has been closed.
     * @throws NoSuchElementException
     *             if input has been exhausted.
     * @throws InputMismatchException
     *             if the next token can not be translated into a valid
     *             {@code boolean} value.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.603 -0500", hash_original_method = "D0E4DE4C67E1DCF9B9C54027B3E1E21D", hash_generated_method = "EB909912857FD197A194F38FBA4A9EA8")
    
public boolean nextBoolean() {
        return Boolean.parseBoolean(next(BOOLEAN_PATTERN));
    }

    /**
     * Returns the next token as a {@code byte}. This method will block if input is being
     * read. Equivalent to {@code nextByte(DEFAULT_RADIX)}.
     *
     * @return the next token as a {@code byte}.
     * @throws IllegalStateException
     *             if this {@code Scanner} has been closed.
     * @throws NoSuchElementException
     *             if input has been exhausted.
     * @throws InputMismatchException
     *             if the next token can not be translated into a valid
     *             {@code byte} value.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.605 -0500", hash_original_method = "7CE1C60D76B7F2532B9BC1651A113CEF", hash_generated_method = "C642C25DB42477C1DD6ABDC20CB0DB38")
    
public byte nextByte() {
        return nextByte(integerRadix);
    }

    /**
     * Returns the next token as a {@code byte} with the specified radix. Will
     * block if input is being read. If the next token can be translated into a
     * {@code byte} the following is done: All {@code Locale}-specific prefixes, group
     * separators, and {@code Locale}-specific suffixes are removed. Then non-ASCII
     * digits are mapped into ASCII digits via
     * {@link Character#digit(char, int)}, and a negative sign (-) is added if the
     * {@code Locale}-specific negative prefix or suffix was present. Finally the
     * resulting String is passed to {@link Byte#parseByte(String, int)}} with
     * the specified radix.
     *
     * @param radix
     *            the radix used to translate the token into {@code byte} value.
     * @return the next token as a {@code byte}.
     * @throws IllegalStateException
     *             if this {@code Scanner} has been closed.
     * @throws NoSuchElementException
     *             if input has been exhausted.
     * @throws InputMismatchException
     *             if the next token can not be translated into a valid
     *             {@code byte} value.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.609 -0500", hash_original_method = "9181863BF854F96D8E1FF1A461B82F5F", hash_generated_method = "EF247ECD09C24698B239C83C3A87996D")
    
@SuppressWarnings("boxing")
    public byte nextByte(int radix) {
        checkClosed();
        Object obj = cacheHasNextValue;
        cacheHasNextValue = null;
        if (obj instanceof Byte) {
            findStartIndex = cachehasNextIndex;
            return (Byte) obj;
        }
        Pattern integerPattern = getIntegerPattern(radix);
        String intString = next(integerPattern);
        intString = removeLocaleInfo(intString, DataType.INT);
        byte byteValue = 0;
        try {
            byteValue = Byte.parseByte(intString, radix);
        } catch (NumberFormatException e) {
            matchSuccessful = false;
            recoverPreviousStatus();
            throw new InputMismatchException();
        }
        return byteValue;
    }

    /**
     * Returns the next token as a {@code double}. This method will block if input is being
     * read. If the next token can be translated into a {@code double} the
     * following is done: All {@code Locale}-specific prefixes, group separators, and
     * {@code Locale}-specific suffixes are removed. Then non-ASCII digits are mapped
     * into ASCII digits via {@link Character#digit(char, int)}, and a negative
     * sign (-) is added if the {@code Locale}-specific negative prefix or suffix was
     * present. Finally the resulting String is passed to
     * {@link Double#parseDouble(String)}}. If the token matches the localized
     * NaN or infinity strings, it is also passed to
     * {@link Double#parseDouble(String)}}.
     *
     * @return the next token as a {@code double}.
     * @throws IllegalStateException
     *             if this {@code Scanner} has been closed.
     * @throws NoSuchElementException
     *             if input has been exhausted.
     * @throws InputMismatchException
     *             if the next token can not be translated into a valid
     *             {@code double} value.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.612 -0500", hash_original_method = "59ED3F69878B10BC787D8DCCAB5B2B3E", hash_generated_method = "5E03FA7352C1C59BCA9729DCDDF2A859")
    
@SuppressWarnings("boxing")
    public double nextDouble() {
        checkClosed();
        Object obj = cacheHasNextValue;
        cacheHasNextValue = null;
        if (obj instanceof Double) {
            findStartIndex = cachehasNextIndex;
            return (Double) obj;
        }
        Pattern floatPattern = getFloatPattern();
        String floatString = next(floatPattern);
        floatString = removeLocaleInfoFromFloat(floatString);
        double doubleValue = 0;
        try {
            doubleValue = Double.parseDouble(floatString);
        } catch (NumberFormatException e) {
            matchSuccessful = false;
            recoverPreviousStatus();
            throw new InputMismatchException();
        }
        return doubleValue;
    }

    /**
     * Returns the next token as a {@code float}. This method will block if input is being
     * read. If the next token can be translated into a {@code float} the
     * following is done: All {@code Locale}-specific prefixes, group separators, and
     * {@code Locale}-specific suffixes are removed. Then non-ASCII digits are mapped
     * into ASCII digits via {@link Character#digit(char, int)}, and a negative
     * sign (-) is added if the {@code Locale}-specific negative prefix or suffix was
     * present. Finally the resulting String is passed to
     * {@link Float#parseFloat(String)}}.If the token matches the localized NaN
     * or infinity strings, it is also passed to
     * {@link Float#parseFloat(String)}}.
     *
     * @return the next token as a {@code float}.
     * @throws IllegalStateException
     *             if this {@code Scanner} has been closed.
     * @throws NoSuchElementException
     *             if input has been exhausted.
     * @throws InputMismatchException
     *             if the next token can not be translated into a valid
     *             {@code float} value.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.614 -0500", hash_original_method = "465894BBFB87D2894D77A1BB6EACCD0F", hash_generated_method = "960CA18B06981941274FE4D936B5B297")
    
@SuppressWarnings("boxing")
    public float nextFloat() {
        checkClosed();
        Object obj = cacheHasNextValue;
        cacheHasNextValue = null;
        if (obj instanceof Float) {
            findStartIndex = cachehasNextIndex;
            return (Float) obj;
        }
        Pattern floatPattern = getFloatPattern();
        String floatString = next(floatPattern);
        floatString = removeLocaleInfoFromFloat(floatString);
        float floatValue = 0;
        try {
            floatValue = Float.parseFloat(floatString);
        } catch (NumberFormatException e) {
            matchSuccessful = false;
            recoverPreviousStatus();
            throw new InputMismatchException();
        }
        return floatValue;
    }

    /**
     * Returns the next token as an {@code int}. This method will block if input is being
     * read. Equivalent to {@code nextInt(DEFAULT_RADIX)}.
     *
     * @return the next token as an {@code int}
     * @throws IllegalStateException
     *             if this {@code Scanner} has been closed.
     * @throws NoSuchElementException
     *             if input has been exhausted.
     * @throws InputMismatchException
     *             if the next token can not be translated into a valid
     *             {@code int} value.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.617 -0500", hash_original_method = "5185135F499E2963894A73963B55B971", hash_generated_method = "4D7E86235A8A3FDAE9C860E44B38B8E5")
    
public int nextInt() {
        return nextInt(integerRadix);
    }

    /**
     * Returns the next token as an {@code int} with the specified radix. This method will
     * block if input is being read. If the next token can be translated into an
     * {@code int} the following is done: All {@code Locale}-specific prefixes, group
     * separators, and {@code Locale}-specific suffixes are removed. Then non-ASCII
     * digits are mapped into ASCII digits via
     * {@link Character#digit(char, int)}, and a negative sign (-) is added if the
     * {@code Locale}-specific negative prefix or suffix was present. Finally the
     * resulting String is passed to {@link Integer#parseInt(String, int)} with
     * the specified radix.
     *
     * @param radix
     *            the radix used to translate the token into an {@code int}
     *            value.
     * @return the next token as an {@code int}.
     * @throws IllegalStateException
     *             if this {@code Scanner} has been closed.
     * @throws NoSuchElementException
     *             if input has been exhausted.
     * @throws InputMismatchException
     *             if the next token can not be translated into a valid
     *             {@code int} value.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.619 -0500", hash_original_method = "B06EC911E3305341017BDCE4EADE227D", hash_generated_method = "83B58D6B235A69C4D91062F3D70D49DD")
    
@SuppressWarnings("boxing")
    public int nextInt(int radix) {
        checkClosed();
        Object obj = cacheHasNextValue;
        cacheHasNextValue = null;
        if (obj instanceof Integer) {
            findStartIndex = cachehasNextIndex;
            return (Integer) obj;
        }
        Pattern integerPattern = getIntegerPattern(radix);
        String intString = next(integerPattern);
        intString = removeLocaleInfo(intString, DataType.INT);
        int intValue = 0;
        try {
            intValue = Integer.parseInt(intString, radix);
        } catch (NumberFormatException e) {
            matchSuccessful = false;
            recoverPreviousStatus();
            throw new InputMismatchException();
        }
        return intValue;
    }

    /**
     * Returns the skipped input and advances the {@code Scanner} to the beginning of
     * the next line. The returned result will exclude any line terminator. When
     * searching, if no line terminator is found, then a large amount of input
     * will be cached. If no line at all can be found, a {@code NoSuchElementException}
     * will be thrown.
     *
     * @return the skipped line.
     * @throws IllegalStateException
     *             if the {@code Scanner} is closed.
     * @throws NoSuchElementException
     *             if no line can be found, e.g. when input is an empty string.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.622 -0500", hash_original_method = "3D66719B22D4824A272B09AB38D3D0FA", hash_generated_method = "A67F991174304DC7835FDA74A6F7E641")
    
public String nextLine() {
        checkClosed();

        matcher.usePattern(LINE_PATTERN);
        matcher.region(findStartIndex, bufferLength);
        String result = null;
        while (true) {
            if (matcher.find()) {
                if (inputExhausted || matcher.end() != bufferLength
                        || bufferLength < buffer.capacity()) {
                    matchSuccessful = true;
                    findStartIndex = matcher.end();
                    result = matcher.group();
                    break;
                }
            } else {
                if (inputExhausted) {
                    matchSuccessful = false;
                    throw new NoSuchElementException();
                }
            }
            if (!inputExhausted) {
                readMore();
                resetMatcher();
            }
        }
        // Find text without line terminator here.
        if (result != null) {
            Matcher terminatorMatcher = LINE_TERMINATOR.matcher(result);
            if (terminatorMatcher.find()) {
                result = result.substring(0, terminatorMatcher.start());
            }
        }
        return result;
    }

    /**
     * Returns the next token as a {@code long}. This method will block if input is being
     * read. Equivalent to {@code nextLong(DEFAULT_RADIX)}.
     *
     * @return the next token as a {@code long}.
     * @throws IllegalStateException
     *             if this {@code Scanner} has been closed.
     * @throws NoSuchElementException
     *             if input has been exhausted.
     * @throws InputMismatchException
     *             if the next token can not be translated into a valid
     *             {@code long} value.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.625 -0500", hash_original_method = "6374462D33C9F89E6E50C3F6D20F5373", hash_generated_method = "3BBB9A10635ED766175135AD0EBB0FE7")
    
public long nextLong() {
        return nextLong(integerRadix);
    }

    /**
     * Returns the next token as a {@code long} with the specified radix. This method will
     * block if input is being read. If the next token can be translated into a
     * {@code long} the following is done: All {@code Locale}-specific prefixes, group
     * separators, and {@code Locale}-specific suffixes are removed. Then non-ASCII
     * digits are mapped into ASCII digits via
     * {@link Character#digit(char, int)}, and a negative sign (-) is added if the
     * {@code Locale}-specific negative prefix or suffix was present. Finally the
     * resulting String is passed to {@link Long#parseLong(String, int)}} with
     * the specified radix.
     *
     * @param radix
     *            the radix used to translate the token into a {@code long}
     *            value.
     * @return the next token as a {@code long}.
     * @throws IllegalStateException
     *             if this {@code Scanner} has been closed.
     * @throws NoSuchElementException
     *             if input has been exhausted.
     * @throws InputMismatchException
     *             if the next token can not be translated into a valid
     *             {@code long} value.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.627 -0500", hash_original_method = "36B6D1B74C7A404A698E79C7D45F2371", hash_generated_method = "9963EDFD210EE22DE7D5B9BFF4A29C45")
    
@SuppressWarnings("boxing")
    public long nextLong(int radix) {
        checkClosed();
        Object obj = cacheHasNextValue;
        cacheHasNextValue = null;
        if (obj instanceof Long) {
            findStartIndex = cachehasNextIndex;
            return (Long) obj;
        }
        Pattern integerPattern = getIntegerPattern(radix);
        String intString = next(integerPattern);
        intString = removeLocaleInfo(intString, DataType.INT);
        long longValue = 0;
        try {
            longValue = Long.parseLong(intString, radix);
        } catch (NumberFormatException e) {
            matchSuccessful = false;
            recoverPreviousStatus();
            throw new InputMismatchException();
        }
        return longValue;
    }

    /**
     * Returns the next token as a {@code short}. This method will block if input is being
     * read. Equivalent to {@code nextShort(DEFAULT_RADIX)}.
     *
     * @return the next token as a {@code short}.
     * @throws IllegalStateException
     *             if this {@code Scanner} has been closed.
     * @throws NoSuchElementException
     *             if input has been exhausted.
     * @throws InputMismatchException
     *             if the next token can not be translated into a valid
     *             {@code short} value.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.630 -0500", hash_original_method = "D33600E854DF5F367D7728611F6ACBC6", hash_generated_method = "8EF6F9187C3D1ADACA2CC8597573C8A8")
    
public short nextShort() {
        return nextShort(integerRadix);
    }

    /**
     * Returns the next token as a {@code short} with the specified radix. This method will
     * block if input is being read. If the next token can be translated into a
     * {@code short} the following is done: All {@code Locale}-specific prefixes, group
     * separators, and {@code Locale}-specific suffixes are removed. Then non-ASCII
     * digits are mapped into ASCII digits via
     * {@link Character#digit(char, int)}, and a negative sign (-) is added if the
     * {@code Locale}-specific negative prefix or suffix was present. Finally the
     * resulting String is passed to {@link Short#parseShort(String, int)}}
     * with the specified radix.
     *
     * @param radix
     *            the radix used to translate the token into {@code short}
     *            value.
     * @return the next token as a {@code short}.
     * @throws IllegalStateException
     *             if this {@code Scanner} has been closed.
     * @throws NoSuchElementException
     *             if input has been exhausted.
     * @throws InputMismatchException
     *             if the next token can not be translated into a valid
     *             {@code short} value.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.633 -0500", hash_original_method = "74041A63415BC5E03BF2BCCD0D0C92EB", hash_generated_method = "519B225D4032AF6626D88746299F7E18")
    
@SuppressWarnings("boxing")
    public short nextShort(int radix) {
        checkClosed();
        Object obj = cacheHasNextValue;
        cacheHasNextValue = null;
        if (obj instanceof Short) {
            findStartIndex = cachehasNextIndex;
            return (Short) obj;
        }
        Pattern integerPattern = getIntegerPattern(radix);
        String intString = next(integerPattern);
        intString = removeLocaleInfo(intString, DataType.INT);
        short shortValue = 0;
        try {
            shortValue = Short.parseShort(intString, radix);
        } catch (NumberFormatException e) {
            matchSuccessful = false;
            recoverPreviousStatus();
            throw new InputMismatchException();
        }
        return shortValue;
    }

    /**
     * Return the radix of this {@code Scanner}.
     *
     * @return the radix of this {@code Scanner}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.635 -0500", hash_original_method = "108FFB02BFAD84F212F542E44C9F6CE4", hash_generated_method = "60B2C488923915D138DB59CA6F833796")
    
public int radix() {
        return integerRadix;
    }

    /**
     * Tries to use specified pattern to match input starting from the current position.
     * The delimiter will be ignored. If a match is found, the matched input will be
     * skipped. If an anchored match of the specified pattern succeeds, the corresponding input
     * will also be skipped. Otherwise, a {@code NoSuchElementException} will be thrown.
     * Patterns that can match a lot of input may cause the {@code Scanner} to read
     * in a large amount of input.
     *
     * @param pattern
     *            used to skip over input.
     * @return the {@code Scanner} itself.
     * @throws IllegalStateException
     *             if the {@code Scanner} is closed.
     * @throws NoSuchElementException
     *             if the specified pattern match fails.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.637 -0500", hash_original_method = "EA8E10FC12D1B40BE210D235F143A214", hash_generated_method = "D687E245D884C1A05D43A7AA64DF9E41")
    
public Scanner skip(Pattern pattern) {
        checkClosed();
        checkNull(pattern);
        matcher.usePattern(pattern);
        matcher.region(findStartIndex, bufferLength);
        while (true) {
            if (matcher.lookingAt()) {
                boolean matchInBuffer = matcher.end() < bufferLength
                        || (matcher.end() == bufferLength && inputExhausted);
                if (matchInBuffer) {
                    matchSuccessful = true;
                    findStartIndex = matcher.end();
                    break;
                }
            } else {
                if (inputExhausted) {
                    matchSuccessful = false;
                    throw new NoSuchElementException();
                }
            }
            if (!inputExhausted) {
                readMore();
                resetMatcher();
            }
        }
        return this;
    }

    /**
     * Tries to use the specified string to construct a pattern and then uses
     * the constructed pattern to match input starting from the current position. The
     * delimiter will be ignored. This call is the same as invoke
     * {@code skip(Pattern.compile(pattern))}.
     *
     * @param pattern
     *            the string used to construct a pattern which in turn is used to
     *            match input.
     * @return the {@code Scanner} itself.
     * @throws IllegalStateException
     *             if the {@code Scanner} is closed.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.640 -0500", hash_original_method = "B5629C8DC277AD4A72B913564449A4A1", hash_generated_method = "EE099B8A0CB9887603937DAD664F147E")
    
public Scanner skip(String pattern) {
        return skip(Pattern.compile(pattern));
    }

    /**
     * Returns a string representation of this {@code Scanner}. The information
     * returned may be helpful for debugging. The format of the string is unspecified.
     *
     * @return a string representation of this {@code Scanner}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.642 -0500", hash_original_method = "13B9E1963603D8F8D017FAED70E76372", hash_generated_method = "3C2663A8A94A2D3F1590CC05F9225C3F")
    
@Override
    public String toString() {
        return getClass().getName() +
                "[delimiter=" + delimiter +
                ",findStartIndex=" + findStartIndex +
                ",matchSuccessful=" + matchSuccessful +
                ",closed=" + closed +
                "]";
    }

    /**
     * Sets the delimiting pattern of this {@code Scanner}.
     *
     * @param pattern
     *            the delimiting pattern to use.
     * @return this {@code Scanner}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.644 -0500", hash_original_method = "E89CBE82FDB8B0CDDF4705672288D942", hash_generated_method = "4D64D29F69F9DEBA174C001EE6A817A9")
    
public Scanner useDelimiter(Pattern pattern) {
        delimiter = pattern;
        return this;
    }

    /**
     * Sets the delimiting pattern of this {@code Scanner} with a pattern compiled from
     * the supplied string value.
     *
     * @param pattern
     *            a string from which a {@code Pattern} can be compiled.
     * @return this {@code Scanner}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.647 -0500", hash_original_method = "353C3ED30BA7FF969DF17D7F091BC9CC", hash_generated_method = "1D64DC9B54D27C13E0181D72A1A4168B")
    
public Scanner useDelimiter(String pattern) {
        return useDelimiter(Pattern.compile(pattern));
    }

    /**
     * Sets the {@code Locale} of this {@code Scanner} to a specified {@code Locale}.
     *
     * @param l
     *            the specified {@code Locale} to use.
     * @return this {@code Scanner}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.649 -0500", hash_original_method = "A3D9C7BB7710DA92E291534F4EEE6EBE", hash_generated_method = "7890CDABECF8145D5EFFB94664E6F13E")
    
public Scanner useLocale(Locale l) {
        if (l == null) {
            throw new NullPointerException();
        }
        this.locale = l;
        return this;
    }

    /**
     * Sets the radix of this {@code Scanner} to the specified radix.
     *
     * @param radix
     *            the specified radix to use.
     * @return this {@code Scanner}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.652 -0500", hash_original_method = "345B5E07834B16EBD69B375363EEC767", hash_generated_method = "BD3246A81CFD23034FE57C1950675DF1")
    
public Scanner useRadix(int radix) {
        checkRadix(radix);
        this.integerRadix = radix;
        return this;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.655 -0500", hash_original_method = "A1030C8BAA30073CC5ACF726BB676E36", hash_generated_method = "9679C0000F24C0D7305319F9A71B6D9B")
    
private void checkRadix(int radix) {
        if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX) {
            throw new IllegalArgumentException("Invalid radix: " + radix);
        }
    }

    /**
     * Remove is not a supported operation on {@code Scanner}.
     *
     * @throws UnsupportedOperationException
     *             if this method is invoked.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.657 -0500", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "5B2A4852FF2684177E07742561C615C2")
    
public void remove() {
        throw new UnsupportedOperationException();
    }

    /*
     * Initialize some components.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.659 -0500", hash_original_method = "406043B74DF8E969B61AA0BA511B152F", hash_generated_method = "79289E1E750749625EC821690D670138")
    
private void initialization() {
        buffer = CharBuffer.allocate(DEFAULT_TRUNK_SIZE);
        buffer.limit(0);
        matcher = delimiter.matcher(buffer);
    }

    /*
     * Check the {@code Scanner}'s state, if it is closed, IllegalStateException will be
     * thrown.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.661 -0500", hash_original_method = "B30B600A81B32166D215C68FA4624658", hash_generated_method = "04B3916192B420CA2BBD922CB53A10AE")
    
private void checkClosed() {
        if (closed) {
            throw new IllegalStateException();
        }
    }

    /*
     * Check the inputed pattern. If it is null, then a NullPointerException
     * will be thrown out.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.664 -0500", hash_original_method = "36E7BDE51D05E7575D4F9253BA0F7A7F", hash_generated_method = "373C3C3F2BF4F3BDAB51AE9E5AD728B3")
    
private void checkNull(Pattern pattern) {
        if (pattern == null) {
            throw new NullPointerException();
        }
    }

    /*
     * Change the matcher's string after reading input
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.666 -0500", hash_original_method = "EB8AF45030CFA93895E22043F16AA91D", hash_generated_method = "04067805E7449EAF64C1FAE30FAB4D55")
    
private void resetMatcher() {
        if (matcher == null) {
            matcher = delimiter.matcher(buffer);
        } else {
            matcher.reset(buffer);
        }
        matcher.region(findStartIndex, bufferLength);
    }

    /*
     * Save the matcher's last find position
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.668 -0500", hash_original_method = "8767C8E3B92497CDD5E1C8E3E9AF12A5", hash_generated_method = "F033BB3D8F2D204583029D755746C95A")
    
private void saveCurrentStatus() {
        preStartIndex = findStartIndex;
    }

    /*
     * Change the matcher's status to last find position
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.671 -0500", hash_original_method = "C4EDF4CCA1B99C808834619656C45D45", hash_generated_method = "E3DB46B8A8AF36053DB62D7867AB1516")
    
private void recoverPreviousStatus() {
        findStartIndex = preStartIndex;
    }

    /*
     * Get integer's pattern
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.673 -0500", hash_original_method = "B97F3D0429BBD1DC99EF41C42DDF373F", hash_generated_method = "799570D06D0C4023ECB1B158D31696DB")
    
private Pattern getIntegerPattern(int radix) {
        checkRadix(radix);
        decimalFormat = (DecimalFormat) NumberFormat.getInstance(locale);

        String allAvailableDigits = "0123456789abcdefghijklmnopqrstuvwxyz";
        String ASCIIDigit = allAvailableDigits.substring(0, radix);
        String nonZeroASCIIDigit = allAvailableDigits.substring(1, radix);

        StringBuilder digit = new StringBuilder("((?i)[").append(ASCIIDigit)
                .append("]|\\p{javaDigit})");
        StringBuilder nonZeroDigit = new StringBuilder("((?i)[").append(
                nonZeroASCIIDigit).append("]|([\\p{javaDigit}&&[^0]]))");
        StringBuilder numeral = getNumeral(digit, nonZeroDigit);

        StringBuilder integer = new StringBuilder("(([-+]?(").append(numeral)
                .append(")))|(").append(addPositiveSign(numeral)).append(")|(")
                .append(addNegativeSign(numeral)).append(")");

        Pattern integerPattern = Pattern.compile(integer.toString());
        return integerPattern;
    }

    /*
     * Get pattern of float
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.677 -0500", hash_original_method = "C0E115C785C5444E26611E86ADCD9532", hash_generated_method = "E2F50B51F92C15F431F41B593BEE77F8")
    
private Pattern getFloatPattern() {
        decimalFormat = (DecimalFormat) NumberFormat.getInstance(locale);

        StringBuilder digit = new StringBuilder("([0-9]|(\\p{javaDigit}))");
        StringBuilder nonZeroDigit = new StringBuilder("[\\p{javaDigit}&&[^0]]");
        StringBuilder numeral = getNumeral(digit, nonZeroDigit);

        String decimalSeparator = "\\" + decimalFormat.getDecimalFormatSymbols()
                        .getDecimalSeparator();
        StringBuilder decimalNumeral = new StringBuilder("(").append(numeral)
                .append("|").append(numeral)
                .append(decimalSeparator).append(digit).append("*+|").append(
                        decimalSeparator).append(digit).append("++)");
        StringBuilder exponent = new StringBuilder("([eE][+-]?").append(digit)
                .append("+)?");

        StringBuilder decimal = new StringBuilder("(([-+]?").append(
                decimalNumeral).append("(").append(exponent).append("?)")
                .append(")|(").append(addPositiveSign(decimalNumeral)).append(
                        "(").append(exponent).append("?)").append(")|(")
                .append(addNegativeSign(decimalNumeral)).append("(").append(
                        exponent).append("?)").append("))");

        StringBuilder hexFloat = new StringBuilder("([-+]?0[xX][0-9a-fA-F]*")
                .append("\\.").append(
                        "[0-9a-fA-F]+([pP][-+]?[0-9]+)?)");
        String localNaN = decimalFormat.getDecimalFormatSymbols().getNaN();
        String localeInfinity = decimalFormat.getDecimalFormatSymbols()
                .getInfinity();
        StringBuilder nonNumber = new StringBuilder("(NaN|\\Q").append(localNaN)
                .append("\\E|Infinity|\\Q").append(localeInfinity).append("\\E)");
        StringBuilder singedNonNumber = new StringBuilder("((([-+]?(").append(
                nonNumber).append(")))|(").append(addPositiveSign(nonNumber))
                .append(")|(").append(addNegativeSign(nonNumber)).append("))");

        StringBuilder floatString = new StringBuilder().append(decimal).append(
                "|").append(hexFloat).append("|").append(singedNonNumber);
        Pattern floatPattern = Pattern.compile(floatString.toString());
        return floatPattern;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.679 -0500", hash_original_method = "F633057156584A1CC211DF943CEE8B2E", hash_generated_method = "73748FC15FE66879BF1AE7A44A42B0EA")
    
private StringBuilder getNumeral(StringBuilder digit,
            StringBuilder nonZeroDigit) {
        String groupSeparator = "\\"
                + decimalFormat.getDecimalFormatSymbols()
                        .getGroupingSeparator();
        StringBuilder groupedNumeral = new StringBuilder("(").append(
                nonZeroDigit).append(digit).append("?").append(digit).append(
                "?(").append(groupSeparator).append(digit).append(digit)
                .append(digit).append(")+)");
        StringBuilder numeral = new StringBuilder("((").append(digit).append(
                "++)|").append(groupedNumeral).append(")");
        return numeral;
    }

    /*
     * Add the locale specific positive prefixes and suffixes to the pattern
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.682 -0500", hash_original_method = "F4802B299CEDF4B393BE453F4FA35C1C", hash_generated_method = "7D85113D4BF0815A0B463659BDFF04AE")
    
private StringBuilder addPositiveSign(StringBuilder unSignNumeral) {
        String positivePrefix = "";
        String positiveSuffix = "";
        if (!decimalFormat.getPositivePrefix().isEmpty()) {
            positivePrefix = "\\Q" + decimalFormat.getPositivePrefix() + "\\E";
        }
        if (!decimalFormat.getPositiveSuffix().isEmpty()) {
            positiveSuffix = "\\Q" + decimalFormat.getPositiveSuffix() + "\\E";
        }
        StringBuilder signedNumeral = new StringBuilder()
                .append(positivePrefix).append(unSignNumeral).append(
                        positiveSuffix);
        return signedNumeral;
    }

    /*
     * Add the locale specific negative prefixes and suffixes to the pattern
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.684 -0500", hash_original_method = "52EA29890EB11047B6BC838B1D351A19", hash_generated_method = "1CA5D0203C2E79AAAF9425ADD7E5B1AE")
    
private StringBuilder addNegativeSign(StringBuilder unSignNumeral) {
        String negativePrefix = "";
        String negativeSuffix = "";
        if (!decimalFormat.getNegativePrefix().isEmpty()) {
            negativePrefix = "\\Q" + decimalFormat.getNegativePrefix() + "\\E";
        }
        if (!decimalFormat.getNegativeSuffix().isEmpty()) {
            negativeSuffix = "\\Q" + decimalFormat.getNegativeSuffix() + "\\E";
        }
        StringBuilder signedNumeral = new StringBuilder()
                .append(negativePrefix).append(unSignNumeral).append(
                        negativeSuffix);
        return signedNumeral;
    }

    /*
     * Remove locale related information from float String
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.688 -0500", hash_original_method = "E9627567024197FCA7EA352F1F4FD73F", hash_generated_method = "AF6FFAAA17BE7962B31E3F8E8F3E2D0A")
    
private String removeLocaleInfoFromFloat(String floatString) {
        // If the token is HexFloat
        if (-1 != floatString.indexOf('x') || -1 != floatString.indexOf('X')) {
            return floatString;
        }

        int exponentIndex;
        String decimalNumeralString;
        String exponentString;
        // If the token is scientific notation
        if (-1 != (exponentIndex = floatString.indexOf('e'))
                || -1 != (exponentIndex = floatString.indexOf('E'))) {
            decimalNumeralString = floatString.substring(0, exponentIndex);
            exponentString = floatString.substring(exponentIndex + 1,
                    floatString.length());
            decimalNumeralString = removeLocaleInfo(decimalNumeralString,
                    DataType.FLOAT);
            return decimalNumeralString + "e" + exponentString;
        }
        return removeLocaleInfo(floatString, DataType.FLOAT);
    }
    
    private enum DataType {
        INT,
        FLOAT;
    }

    /*
     * Remove the locale specific prefixes, group separators, and locale
     * specific suffixes from input string
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.691 -0500", hash_original_method = "E0679D6E03D5A7C0D246B9231F9BA005", hash_generated_method = "DF8CE1CE2A873757BB46E37CCE99B79D")
    
private String removeLocaleInfo(String token, DataType type) {
        StringBuilder tokenBuilder = new StringBuilder(token);
        boolean negative = removeLocaleSign(tokenBuilder);
        // Remove group separator
        String groupSeparator = String.valueOf(decimalFormat
                .getDecimalFormatSymbols().getGroupingSeparator());
        int separatorIndex = -1;
        while (-1 != (separatorIndex = tokenBuilder.indexOf(groupSeparator))) {
            tokenBuilder.delete(separatorIndex, separatorIndex + 1);
        }
        // Remove decimal separator
        String decimalSeparator = String.valueOf(decimalFormat
                .getDecimalFormatSymbols().getDecimalSeparator());
        separatorIndex = tokenBuilder.indexOf(decimalSeparator);
        StringBuilder result = new StringBuilder("");
        if (DataType.INT == type) {
            for (int i = 0; i < tokenBuilder.length(); i++) {
                if (-1 != Character.digit(tokenBuilder.charAt(i),
                        Character.MAX_RADIX)) {
                    result.append(tokenBuilder.charAt(i));
                }
            }
        }
        if (DataType.FLOAT == type) {
            if (tokenBuilder.toString().equals(
                    decimalFormat.getDecimalFormatSymbols().getNaN())) {
                result.append("NaN");
            } else if (tokenBuilder.toString().equals(
                    decimalFormat.getDecimalFormatSymbols().getInfinity())) {
                result.append("Infinity");
            } else {
                for (int i = 0; i < tokenBuilder.length(); i++) {
                    if (-1 != Character.digit(tokenBuilder.charAt(i), 10)) {
                        result.append(Character.digit(tokenBuilder.charAt(i),
                                10));
                    }
                }
            }
        }
        // Token is NaN or Infinity
        if (result.length() == 0) {
            result = tokenBuilder;
        }
        if (-1 != separatorIndex) {
            result.insert(separatorIndex, ".");
        }
        // If input is negative
        if (negative) {
            result.insert(0, '-');
        }
        return result.toString();
    }

    /*
     * Remove positive and negative sign from the parameter stringBuilder, and
     * return whether the input string is negative
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.694 -0500", hash_original_method = "78E2FFE43DDA019FB87A76C655422357", hash_generated_method = "547428C328765DB155CB245C2CAA68E0")
    
private boolean removeLocaleSign(StringBuilder tokenBuilder) {
        String positivePrefix = decimalFormat.getPositivePrefix();
        String positiveSuffix = decimalFormat.getPositiveSuffix();
        String negativePrefix = decimalFormat.getNegativePrefix();
        String negativeSuffix = decimalFormat.getNegativeSuffix();

        if (tokenBuilder.indexOf("+") == 0) {
            tokenBuilder.delete(0, 1);
        }
        if (!positivePrefix.isEmpty() && tokenBuilder.indexOf(positivePrefix) == 0) {
            tokenBuilder.delete(0, positivePrefix.length());
        }
        if (!positiveSuffix.isEmpty()
                && -1 != tokenBuilder.indexOf(positiveSuffix)) {
            tokenBuilder.delete(
                    tokenBuilder.length() - positiveSuffix.length(),
                    tokenBuilder.length());
        }
        boolean negative = false;
        if (tokenBuilder.indexOf("-") == 0) {
            tokenBuilder.delete(0, 1);
            negative = true;
        }
        if (!negativePrefix.isEmpty() && tokenBuilder.indexOf(negativePrefix) == 0) {
            tokenBuilder.delete(0, negativePrefix.length());
            negative = true;
        }
        if (!negativeSuffix.isEmpty()
                && -1 != tokenBuilder.indexOf(negativeSuffix)) {
            tokenBuilder.delete(
                    tokenBuilder.length() - negativeSuffix.length(),
                    tokenBuilder.length());
            negative = true;
        }
        return negative;
    }

    /*
     * Find the prefixed delimiter and posefixed delimiter in the input resource
     * and set the start index and end index of Matcher region. If postfixed
     * delimiter does not exist, the end index is set to be end of input.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.697 -0500", hash_original_method = "F9C3F510E83B834D3EF4AA01E6CFE4F9", hash_generated_method = "68AB05A16E0FE35AF872C4C2509251D2")
    
private boolean setTokenRegion() {
        // The position where token begins
        int tokenStartIndex = 0;
        // The position where token ends
        int tokenEndIndex = 0;
        // Use delimiter pattern
        matcher.usePattern(delimiter);
        matcher.region(findStartIndex, bufferLength);

        tokenStartIndex = findPreDelimiter();
        if (setHeadTokenRegion(tokenStartIndex)) {
            return true;
        }
        tokenEndIndex = findPostDelimiter();
        // If the second delimiter is not found
        if (-1 == tokenEndIndex) {
            // Just first Delimiter Exists
            if (findStartIndex == bufferLength) {
                return false;
            }
            tokenEndIndex = bufferLength;
            findStartIndex = bufferLength;
        }

        matcher.region(tokenStartIndex, tokenEndIndex);
        return true;
    }

    /*
     * Find prefix delimiter
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.700 -0500", hash_original_method = "C22FCAE783E3B780837C6EC57B7427D4", hash_generated_method = "74D02CA3B586F483486C4941572061CE")
    
private int findPreDelimiter() {
        int tokenStartIndex;
        boolean findComplete = false;
        while (!findComplete) {
            if (matcher.find()) {
                findComplete = true;
                // If just delimiter remains
                if (matcher.start() == findStartIndex
                        && matcher.end() == bufferLength) {
                    // If more input resource exists
                    if (!inputExhausted) {
                        readMore();
                        resetMatcher();
                        findComplete = false;
                    }
                }
            } else {
                if (!inputExhausted) {
                    readMore();
                    resetMatcher();
                } else {
                    return -1;
                }
            }
        }
        tokenStartIndex = matcher.end();
        findStartIndex = matcher.end();
        return tokenStartIndex;
    }

    /*
     * Handle some special cases
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.703 -0500", hash_original_method = "CDCEB3053237613D9179B8FF1482F233", hash_generated_method = "1F02923AA39AAEEAD799B42A8247F79B")
    
private boolean setHeadTokenRegion(int findIndex) {
        int tokenStartIndex;
        int tokenEndIndex;
        boolean setSuccess = false;
        // If no delimiter exists, but something exites in this scanner
        if (-1 == findIndex && preStartIndex != bufferLength) {
            tokenStartIndex = preStartIndex;
            tokenEndIndex = bufferLength;
            findStartIndex = bufferLength;
            matcher.region(tokenStartIndex, tokenEndIndex);
            setSuccess = true;
        }
        // If the first delimiter of scanner is not at the find start position
        if (-1 != findIndex && preStartIndex != matcher.start()) {
            tokenStartIndex = preStartIndex;
            tokenEndIndex = matcher.start();
            findStartIndex = matcher.start();
            // set match region and return
            matcher.region(tokenStartIndex, tokenEndIndex);
            setSuccess = true;
        }
        return setSuccess;
    }
    static {
        String NL = "\n|\r\n|\r|\u0085|\u2028|\u2029";
        LINE_TERMINATOR = Pattern.compile(NL);
        MULTI_LINE_TERMINATOR = Pattern.compile("(" + NL + ")+");
        LINE_PATTERN = Pattern.compile(".*(" + NL + ")|.+(" + NL + ")?");
    }

    /*
     * Find postfix delimiter
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.706 -0500", hash_original_method = "2DA8EAAAB20ACFBF7221E1B39889C369", hash_generated_method = "D3203076C152DC16E53D674D548AA877")
    
private int findPostDelimiter() {
        int tokenEndIndex = 0;
        boolean findComplete = false;
        while (!findComplete) {
            if (matcher.find()) {
                findComplete = true;
                if (matcher.start() == findStartIndex
                        && matcher.start() == matcher.end()) {
                    findComplete = false;
                }
            } else {
                if (!inputExhausted) {
                    readMore();
                    resetMatcher();
                } else {
                    return -1;
                }
            }
        }
        tokenEndIndex = matcher.start();
        findStartIndex = matcher.start();
        return tokenEndIndex;
    }

    /*
     * Read more data from underlying Readable. If nothing is available or I/O
     * operation fails, global boolean variable inputExhausted will be set to
     * true, otherwise set to false.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.709 -0500", hash_original_method = "71E256A499C0BF5FC1327A59408A7116", hash_generated_method = "6E64D940A09BB57189208F09D6ED3FA6")
    
private void readMore() {
        int oldPosition = buffer.position();
        int oldBufferLength = bufferLength;
        // Increase capacity if empty space is not enough
        if (bufferLength >= buffer.capacity()) {
            expandBuffer();
        }

        // Read input resource
        int readCount = 0;
        try {
            buffer.limit(buffer.capacity());
            buffer.position(oldBufferLength);
            while ((readCount = input.read(buffer)) == 0) {
                // nothing to do here
            }
        } catch (IOException e) {
            // Consider the scenario: readable puts 4 chars into
            // buffer and then an IOException is thrown out. In this case,
            // buffer is
            // actually grown, but readable.read() will never return.
            bufferLength = buffer.position();
            /*
             * Uses -1 to record IOException occurring, and no more input can be
             * read.
             */
            readCount = -1;
            lastIOException = e;
        }

        buffer.flip();
        buffer.position(oldPosition);
        if (-1 == readCount) {
            inputExhausted = true;
        } else {
            bufferLength = readCount + bufferLength;
        }
    }

    // Expand the size of internal buffer.
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.711 -0500", hash_original_method = "333CE5605A5055092BA8AAF7729359CC", hash_generated_method = "1F8C96133D01F88B888A13E0AA6E5864")
    
private void expandBuffer() {
        int oldPosition = buffer.position();
        int oldCapacity = buffer.capacity();
        int oldLimit = buffer.limit();
        int newCapacity = oldCapacity * DIPLOID;
        char[] newBuffer = new char[newCapacity];
        System.arraycopy(buffer.array(), 0, newBuffer, 0, oldLimit);
        buffer = CharBuffer.wrap(newBuffer, 0, newCapacity);
        buffer.position(oldPosition);
        buffer.limit(oldLimit);
    }

    /**
     * Resets this scanner's delimiter, locale, and radix.
     *
     * @return this scanner
     * @since 1.6
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:26.714 -0500", hash_original_method = "6E6895DF0C38F7FD4A1856B0BE65A90D", hash_generated_method = "853C9A1985467115793F13C6AA0E5867")
    
public Scanner reset() {
        delimiter = DEFAULT_DELIMITER;
        locale = Locale.getDefault();
        integerRadix = 10;
        return this;
    }
}

