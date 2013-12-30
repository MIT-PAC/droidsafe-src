package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Locale;






public class StreamTokenizer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.482 -0500", hash_original_field = "9FFA8D2E6CD3A706488AC551C3F7491D", hash_generated_field = "CE1461C2F3CB152AF49883B7F99787FB")

    public static final int TT_EOF = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.485 -0500", hash_original_field = "A928B6F26A8AD973AF98F18523F03161", hash_generated_field = "B268C6BA8A886B092A77409C21A1508B")

    public static final int TT_EOL = '\n';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.487 -0500", hash_original_field = "0C934AEE80099C74273977B7F2FF4F36", hash_generated_field = "C7B7189E8CD30D5160940E644F967084")

    public static final int TT_NUMBER = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.490 -0500", hash_original_field = "5CA3AA306522417ED0688E533E00354D", hash_generated_field = "E9C083A72C44A8E06557D4F80D18307A")

    public static final int TT_WORD = -3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.493 -0500", hash_original_field = "C4AB8C23D65CD4494DB33DAC05D40AB9", hash_generated_field = "C157BC2C8DB11DFCC846C695B2AD57DC")

    private static final int TT_UNKNOWN = -4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.500 -0500", hash_original_field = "FCE204270CBBB6F8A40C3A1BC1ECE596", hash_generated_field = "B5B31D6CF53277606D69A20BBD672055")


    private static final byte TOKEN_COMMENT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.503 -0500", hash_original_field = "77CCB0435DDCC6C52DE4ED919447477A", hash_generated_field = "47A200D0084A16EFA9E30FE833AFB1FB")


    private static final byte TOKEN_QUOTE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.506 -0500", hash_original_field = "CCC412E8EA36C20B937CB98E89378E8B", hash_generated_field = "C9DC638D16F1182F35227918AFD70078")


    private static final byte TOKEN_WHITE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.508 -0500", hash_original_field = "EBB2EFD888EBCCEFED12A4AB8BCDE680", hash_generated_field = "2AE0950E5470D97CB17C370704304234")


    private static final byte TOKEN_WORD = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.511 -0500", hash_original_field = "99B9C35765C7289AF2FA63F418B0BA28", hash_generated_field = "7175EE1ADBAA718DFE8844137332396F")


    private static final byte TOKEN_DIGIT = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.477 -0500", hash_original_field = "A3FBF74367DF67847DBDF32C85EFD9A3", hash_generated_field = "61CABEDACAAE440F819A66BD081717D9")

    public double nval;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.479 -0500", hash_original_field = "386CBDA2E518FF47CCEF2AF34230E00C", hash_generated_field = "6B1824743AABE9479A43318581BA47FF")

    public String sval;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.495 -0500", hash_original_field = "C20007798FEF485E1E8684BCD2FEC9EE", hash_generated_field = "77D997FE9B64F760BAC88B55FE1EF2E2")

    public int ttype = TT_UNKNOWN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.498 -0500", hash_original_field = "FCCF8D5533673495458160EFA9A2676B", hash_generated_field = "806B2BD50024961410FB07586F0E377B")

    private byte[] tokenTypes = new byte[256];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.513 -0500", hash_original_field = "62A9370282965B498A7A3EC27A93F8C0", hash_generated_field = "27FA2CFD35EEFAE64C7DFD7FF18A54A3")


    private int lineNumber = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.517 -0500", hash_original_field = "6A9488FF441BB4D26B1371315081F117", hash_generated_field = "7FF9EA1081BB65BCD5D6FFEE94A98B82")


    private boolean forceLowercase;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.519 -0500", hash_original_field = "9CA1EB89C174418E4E1EF05B9653FDBE", hash_generated_field = "D954790BC163C65FCE60F79A2C012ED2")


    private boolean isEOLSignificant;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.521 -0500", hash_original_field = "E271CE5DF4396F279A1523B6A823C032", hash_generated_field = "D47D5E18F60921FF3632B427BB9CD0AA")


    private boolean slashStarComments;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.524 -0500", hash_original_field = "24A615E423AB8776BB7EF7CD8FC182CD", hash_generated_field = "DC8C8DC2DAFEE20CDA1B1F463AF2DF71")


    private boolean slashSlashComments;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.526 -0500", hash_original_field = "F90EFD8038931D03AABF5F432D393CE8", hash_generated_field = "49F6B836F7E1D68FD6E01FA2485232FE")


    private boolean pushBackToken;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.528 -0500", hash_original_field = "C0F5897A1978853F42D2445160B14D7D", hash_generated_field = "96F646C740AFE4E9E4C51A083C4D3595")


    private boolean lastCr;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.530 -0500", hash_original_field = "CE67F8E6759E7AA9F0B2D1B1C622FA48", hash_generated_field = "848E95AB29D035B62B017F39E2191D18")

    private InputStream inStream;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.533 -0500", hash_original_field = "8713F9F3C39C80F819723C0F08FAA90C", hash_generated_field = "BBEB5044AD720FD044C79AD81CEC888B")


    private Reader inReader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.535 -0500", hash_original_field = "2BE9E8C231D8C8B24DBE2BA2B804400D", hash_generated_field = "32E47E44D4C148CFC795B5BAC1FD140A")


    private int peekChar = -2;

    /**
     * Private constructor to initialize the default values according to the
     * specification.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.538 -0500", hash_original_method = "0C9484F593CC2C76BC0994AA6F883855", hash_generated_method = "59C15A26070F0EA645890B8321BCD69A")
    
private StreamTokenizer() {
        /*
         * Initialize the default state per specification. All byte values 'A'
         * through 'Z', 'a' through 'z', and '\u00A0' through '\u00FF' are
         * considered to be alphabetic.
         */
        wordChars('A', 'Z');
        wordChars('a', 'z');
        wordChars(160, 255);
        /**
         * All byte values '\u0000' through '\u0020' are considered to be white
         * space.
         */
        whitespaceChars(0, 32);
        /**
         * '/' is a comment character. Single quote '\'' and double quote '"'
         * are string quote characters.
         */
        commentChar('/');
        quoteChar('"');
        quoteChar('\'');
        /**
         * Numbers are parsed.
         */
        parseNumbers();
        /**
         * Ends of lines are treated as white space, not as separate tokens.
         * C-style and C++-style comments are not recognized. These are the
         * defaults and are not needed in constructor.
         */
    }

    /**
     * Constructs a new {@code StreamTokenizer} with {@code is} as source input
     * stream. This constructor is deprecated; instead, the constructor that
     * takes a {@code Reader} as an arugment should be used.
     *
     * @param is
     *            the source stream from which to parse tokens.
     * @throws NullPointerException
     *             if {@code is} is {@code null}.
     * @deprecated Use {@link #StreamTokenizer(Reader)}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.541 -0500", hash_original_method = "024007D8DD8258E54D25FF7D12CDFD92", hash_generated_method = "9281B1450B96D88DCCF110F938D67969")
    
@Deprecated
    public StreamTokenizer(InputStream is) {
        this();
        if (is == null) {
            throw new NullPointerException();
        }
        inStream = is;
    }

    /**
     * Constructs a new {@code StreamTokenizer} with {@code r} as source reader.
     * The tokenizer's initial state is as follows:
     * <ul>
     * <li>All byte values 'A' through 'Z', 'a' through 'z', and '&#92;u00A0'
     * through '&#92;u00FF' are considered to be alphabetic.</li>
     * <li>All byte values '&#92;u0000' through '&#92;u0020' are considered to
     * be white space. '/' is a comment character.</li>
     * <li>Single quote '\'' and double quote '"' are string quote characters.
     * </li>
     * <li>Numbers are parsed.</li>
     * <li>End of lines are considered to be white space rather than separate
     * tokens.</li>
     * <li>C-style and C++-style comments are not recognized.</LI>
     * </ul>
     *
     * @param r
     *            the source reader from which to parse tokens.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.544 -0500", hash_original_method = "0EF3862126AC8C7CB18364F21A3441E5", hash_generated_method = "DA54452B233966B0DC8F99E27DD787B4")
    
public StreamTokenizer(Reader r) {
        this();
        if (r == null) {
            throw new NullPointerException();
        }
        inReader = r;
    }

    /**
     * Specifies that the character {@code ch} shall be treated as a comment
     * character.
     *
     * @param ch
     *            the character to be considered a comment character.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.546 -0500", hash_original_method = "E38E4469494A7A375F4DC16613BFC71B", hash_generated_method = "7F0C6F85EC86737B702FCFC7BFADF15B")
    
public void commentChar(int ch) {
        if (ch >= 0 && ch < tokenTypes.length) {
            tokenTypes[ch] = TOKEN_COMMENT;
        }
    }

    /**
     * Specifies whether the end of a line is significant and should be returned
     * as {@code TT_EOF} in {@code ttype} by this tokenizer.
     *
     * @param flag
     *            {@code true} if EOL is significant, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.548 -0500", hash_original_method = "4574927758DBFC248F61FB44F6B60AD5", hash_generated_method = "0BB1EBC83EEB3B665AC453A21C10DD5F")
    
public void eolIsSignificant(boolean flag) {
        isEOLSignificant = flag;
    }

    /**
     * Returns the current line number.
     *
     * @return this tokenizer's current line number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.551 -0500", hash_original_method = "CFD9FB1CAAFA0B398D0DDE009E39DD95", hash_generated_method = "5768348636FA99EA8D51BE31A105096C")
    
public int lineno() {
        return lineNumber;
    }

    /**
     * Specifies whether word tokens should be converted to lower case when they
     * are stored in {@code sval}.
     *
     * @param flag
     *            {@code true} if {@code sval} should be converted to lower
     *            case, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.553 -0500", hash_original_method = "C3C8ED01DF0631C29C770DF7973EAB61", hash_generated_method = "999D5038A12757E897453D5ABC7D784D")
    
public void lowerCaseMode(boolean flag) {
        forceLowercase = flag;
    }

    /**
     * Parses the next token from this tokenizer's source stream or reader. The
     * type of the token is stored in the {@code ttype} field, additional
     * information may be stored in the {@code nval} or {@code sval} fields.
     *
     * @return the value of {@code ttype}.
     * @throws IOException
     *             if an I/O error occurs while parsing the next token.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.560 -0500", hash_original_method = "6817D84A74EC2CE0E287784F864856A8", hash_generated_method = "2CF64434253B80CFD6CA9D8BAC292055")
    
public int nextToken() throws IOException {
        if (pushBackToken) {
            pushBackToken = false;
            if (ttype != TT_UNKNOWN) {
                return ttype;
            }
        }
        sval = null; // Always reset sval to null
        int currentChar = peekChar == -2 ? read() : peekChar;

        if (lastCr && currentChar == '\n') {
            lastCr = false;
            currentChar = read();
        }
        if (currentChar == -1) {
            return (ttype = TT_EOF);
        }

        byte currentType = currentChar > 255 ? TOKEN_WORD
                : tokenTypes[currentChar];
        while ((currentType & TOKEN_WHITE) != 0) {
            /**
             * Skip over white space until we hit a new line or a real token
             */
            if (currentChar == '\r') {
                lineNumber++;
                if (isEOLSignificant) {
                    lastCr = true;
                    peekChar = -2;
                    return (ttype = TT_EOL);
                }
                if ((currentChar = read()) == '\n') {
                    currentChar = read();
                }
            } else if (currentChar == '\n') {
                lineNumber++;
                if (isEOLSignificant) {
                    peekChar = -2;
                    return (ttype = TT_EOL);
                }
                currentChar = read();
            } else {
                // Advance over this white space character and try again.
                currentChar = read();
            }
            if (currentChar == -1) {
                return (ttype = TT_EOF);
            }
            currentType = currentChar > 255 ? TOKEN_WORD
                    : tokenTypes[currentChar];
        }

        /**
         * Check for digits before checking for words since digits can be
         * contained within words.
         */
        if ((currentType & TOKEN_DIGIT) != 0) {
            StringBuilder digits = new StringBuilder(20);
            boolean haveDecimal = false, checkJustNegative = currentChar == '-';
            while (true) {
                if (currentChar == '.') {
                    haveDecimal = true;
                }
                digits.append((char) currentChar);
                currentChar = read();
                if ((currentChar < '0' || currentChar > '9')
                        && (haveDecimal || currentChar != '.')) {
                    break;
                }
            }
            peekChar = currentChar;
            if (checkJustNegative && digits.length() == 1) {
                // Didn't get any other digits other than '-'
                return (ttype = '-');
            }
            try {
                nval = Double.valueOf(digits.toString()).doubleValue();
            } catch (NumberFormatException e) {
                // Unsure what to do, will write test.
                nval = 0;
            }
            return (ttype = TT_NUMBER);
        }
        // Check for words
        if ((currentType & TOKEN_WORD) != 0) {
            StringBuilder word = new StringBuilder(20);
            while (true) {
                word.append((char) currentChar);
                currentChar = read();
                if (currentChar == -1
                        || (currentChar < 256 && (tokenTypes[currentChar] & (TOKEN_WORD | TOKEN_DIGIT)) == 0)) {
                    break;
                }
            }
            peekChar = currentChar;
            sval = word.toString();
            if (forceLowercase) {
                sval = sval.toLowerCase(Locale.getDefault());
            }
            return (ttype = TT_WORD);
        }
        // Check for quoted character
        if (currentType == TOKEN_QUOTE) {
            int matchQuote = currentChar;
            StringBuilder quoteString = new StringBuilder();
            int peekOne = read();
            while (peekOne >= 0 && peekOne != matchQuote && peekOne != '\r'
                    && peekOne != '\n') {
                boolean readPeek = true;
                if (peekOne == '\\') {
                    int c1 = read();
                    // Check for quoted octal IE: \377
                    if (c1 <= '7' && c1 >= '0') {
                        int digitValue = c1 - '0';
                        c1 = read();
                        if (c1 > '7' || c1 < '0') {
                            readPeek = false;
                        } else {
                            digitValue = digitValue * 8 + (c1 - '0');
                            c1 = read();
                            // limit the digit value to a byte
                            if (digitValue > 037 || c1 > '7' || c1 < '0') {
                                readPeek = false;
                            } else {
                                digitValue = digitValue * 8 + (c1 - '0');
                            }
                        }
                        if (!readPeek) {
                            // We've consumed one to many
                            quoteString.append((char) digitValue);
                            peekOne = c1;
                        } else {
                            peekOne = digitValue;
                        }
                    } else {
                        switch (c1) {
                            case 'a':
                                peekOne = 0x7;
                                break;
                            case 'b':
                                peekOne = 0x8;
                                break;
                            case 'f':
                                peekOne = 0xc;
                                break;
                            case 'n':
                                peekOne = 0xA;
                                break;
                            case 'r':
                                peekOne = 0xD;
                                break;
                            case 't':
                                peekOne = 0x9;
                                break;
                            case 'v':
                                peekOne = 0xB;
                                break;
                            default:
                                peekOne = c1;
                        }
                    }
                }
                if (readPeek) {
                    quoteString.append((char) peekOne);
                    peekOne = read();
                }
            }
            if (peekOne == matchQuote) {
                peekOne = read();
            }
            peekChar = peekOne;
            ttype = matchQuote;
            sval = quoteString.toString();
            return ttype;
        }
        // Do comments, both "//" and "/*stuff*/"
        if (currentChar == '/' && (slashSlashComments || slashStarComments)) {
            if ((currentChar = read()) == '*' && slashStarComments) {
                int peekOne = read();
                while (true) {
                    currentChar = peekOne;
                    peekOne = read();
                    if (currentChar == -1) {
                        peekChar = -1;
                        return (ttype = TT_EOF);
                    }
                    if (currentChar == '\r') {
                        if (peekOne == '\n') {
                            peekOne = read();
                        }
                        lineNumber++;
                    } else if (currentChar == '\n') {
                        lineNumber++;
                    } else if (currentChar == '*' && peekOne == '/') {
                        peekChar = read();
                        return nextToken();
                    }
                }
            } else if (currentChar == '/' && slashSlashComments) {
                // Skip to EOF or new line then return the next token
                while ((currentChar = read()) >= 0 && currentChar != '\r'
                        && currentChar != '\n') {
                    // Intentionally empty
                }
                peekChar = currentChar;
                return nextToken();
            } else if (currentType != TOKEN_COMMENT) {
                // Was just a slash by itself
                peekChar = currentChar;
                return (ttype = '/');
            }
        }
        // Check for comment character
        if (currentType == TOKEN_COMMENT) {
            // Skip to EOF or new line then return the next token
            while ((currentChar = read()) >= 0 && currentChar != '\r'
                    && currentChar != '\n') {
                // Intentionally empty
            }
            peekChar = currentChar;
            return nextToken();
        }

        peekChar = read();
        return (ttype = currentChar);
    }

    /**
     * Specifies that the character {@code ch} shall be treated as an ordinary
     * character by this tokenizer. That is, it has no special meaning as a
     * comment character, word component, white space, string delimiter or
     * number.
     *
     * @param ch
     *            the character to be considered an ordinary character.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.563 -0500", hash_original_method = "F56215932CA46446CC1F49421E19E4D4", hash_generated_method = "FE73AB64A9B0534F2BA9B0CC734066DC")
    
public void ordinaryChar(int ch) {
        if (ch >= 0 && ch < tokenTypes.length) {
            tokenTypes[ch] = 0;
        }
    }

    /**
     * Specifies that the characters in the range from {@code low} to {@code hi}
     * shall be treated as an ordinary character by this tokenizer. That is,
     * they have no special meaning as a comment character, word component,
     * white space, string delimiter or number.
     *
     * @param low
     *            the first character in the range of ordinary characters.
     * @param hi
     *            the last character in the range of ordinary characters.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.565 -0500", hash_original_method = "022AE8E9D3C39CFDE89A16E6E6C68B23", hash_generated_method = "52BA0B167609E5679095B45B3B35AD52")
    
public void ordinaryChars(int low, int hi) {
        if (low < 0) {
            low = 0;
        }
        if (hi > tokenTypes.length) {
            hi = tokenTypes.length - 1;
        }
        for (int i = low; i <= hi; i++) {
            tokenTypes[i] = 0;
        }
    }

    /**
     * Specifies that this tokenizer shall parse numbers.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.568 -0500", hash_original_method = "F9A1AE339D1E856A34C84852283E0CEC", hash_generated_method = "4550DB6B0B89EFEC22ABA39ADEF6F9B3")
    
public void parseNumbers() {
        for (int i = '0'; i <= '9'; i++) {
            tokenTypes[i] |= TOKEN_DIGIT;
        }
        tokenTypes['.'] |= TOKEN_DIGIT;
        tokenTypes['-'] |= TOKEN_DIGIT;
    }

    /**
     * Indicates that the current token should be pushed back and returned again
     * the next time {@code nextToken()} is called.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.570 -0500", hash_original_method = "60DC1125C539441B12106C43E5B596F1", hash_generated_method = "0DA1AE0A12E28F5546407A3A792B5B65")
    
public void pushBack() {
        pushBackToken = true;
    }

    /**
     * Specifies that the character {@code ch} shall be treated as a quote
     * character.
     *
     * @param ch
     *            the character to be considered a quote character.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.573 -0500", hash_original_method = "9CC8FE0D7A922378FBAE42482AA646D9", hash_generated_method = "C1BDA2EACBFD811D74E9AC042DBC8862")
    
public void quoteChar(int ch) {
        if (ch >= 0 && ch < tokenTypes.length) {
            tokenTypes[ch] = TOKEN_QUOTE;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.575 -0500", hash_original_method = "056CD8A5FA209600CEBA1D62E49B6620", hash_generated_method = "4800411E189D789392246574C073EF9B")
    
private int read() throws IOException {
        // Call the read for the appropriate stream
        if (inStream == null) {
            return inReader.read();
        }
        return inStream.read();
    }

    /**
     * Specifies that all characters shall be treated as ordinary characters.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.578 -0500", hash_original_method = "2D6865C117A48D63E7E9EC7F43B1136B", hash_generated_method = "B099C923E044E90EB2791899D000130F")
    
public void resetSyntax() {
        for (int i = 0; i < 256; i++) {
            tokenTypes[i] = 0;
        }
    }

    /**
     * Specifies whether "slash-slash" (C++-style) comments shall be recognized.
     * This kind of comment ends at the end of the line.
     *
     * @param flag
     *            {@code true} if {@code //} should be recognized as the start
     *            of a comment, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.580 -0500", hash_original_method = "0BBEE324D353623AAF036FC109969157", hash_generated_method = "5CAB1DD456441AB86684A0413EFE130B")
    
public void slashSlashComments(boolean flag) {
        slashSlashComments = flag;
    }

    /**
     * Specifies whether "slash-star" (C-style) comments shall be recognized.
     * Slash-star comments cannot be nested and end when a star-slash
     * combination is found.
     *
     * @param flag
     *            {@code true} if {@code /*} should be recognized as the start
     *            of a comment, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.583 -0500", hash_original_method = "73AA04832C7FF855283D30769102DB3E", hash_generated_method = "52BDA03110C8591AE9A174CDB7E57ADB")
    
public void slashStarComments(boolean flag) {
        slashStarComments = flag;
    }

    /**
     * Returns the state of this tokenizer in a readable format.
     *
     * @return the current state of this tokenizer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.586 -0500", hash_original_method = "00DF77F4EAECB68BC1742A03B5A51C8E", hash_generated_method = "447CCF55C0CC97BFF2C53A213E0DA55F")
    
@Override
    public String toString() {
        // Values determined through experimentation
        StringBuilder result = new StringBuilder();
        result.append("Token[");
        switch (ttype) {
            case TT_EOF:
                result.append("EOF");
                break;
            case TT_EOL:
                result.append("EOL");
                break;
            case TT_NUMBER:
                result.append("n=");
                result.append(nval);
                break;
            case TT_WORD:
                result.append(sval);
                break;
            default:
                if (ttype == TT_UNKNOWN || tokenTypes[ttype] == TOKEN_QUOTE) {
                    result.append(sval);
                } else {
                    result.append('\'');
                    result.append((char) ttype);
                    result.append('\'');
                }
        }
        result.append("], line ");
        result.append(lineNumber);
        return result.toString();
    }

    /**
     * Specifies that the characters in the range from {@code low} to {@code hi}
     * shall be treated as whitespace characters by this tokenizer.
     *
     * @param low
     *            the first character in the range of whitespace characters.
     * @param hi
     *            the last character in the range of whitespace characters.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.588 -0500", hash_original_method = "70A99B8CFA2D4FEC72EA62C54EC3FE21", hash_generated_method = "886AD5A03CDC150FF83F6B79F23DADE6")
    
public void whitespaceChars(int low, int hi) {
        if (low < 0) {
            low = 0;
        }
        if (hi > tokenTypes.length) {
            hi = tokenTypes.length - 1;
        }
        for (int i = low; i <= hi; i++) {
            tokenTypes[i] = TOKEN_WHITE;
        }
    }

    /**
     * Specifies that the characters in the range from {@code low} to {@code hi}
     * shall be treated as word characters by this tokenizer. A word consists of
     * a word character followed by zero or more word or number characters.
     *
     * @param low
     *            the first character in the range of word characters.
     * @param hi
     *            the last character in the range of word characters.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:41.591 -0500", hash_original_method = "CCF6D4E2D65BDFCC5D3A11ED629A7633", hash_generated_method = "52B35AE962EAD0414A4065673EFFA221")
    
public void wordChars(int low, int hi) {
        if (low < 0) {
            low = 0;
        }
        if (hi > tokenTypes.length) {
            hi = tokenTypes.length - 1;
        }
        for (int i = low; i <= hi; i++) {
            tokenTypes[i] |= TOKEN_WORD;
        }
    }
}

