package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Locale;

public class StreamTokenizer {
    public double nval;
    public String sval;
    public int ttype = TT_UNKNOWN;
    private byte[] tokenTypes = new byte[256];
    private int lineNumber = 1;
    private boolean forceLowercase;
    private boolean isEOLSignificant;
    private boolean slashStarComments;
    private boolean slashSlashComments;
    private boolean pushBackToken;
    private boolean lastCr;
    private InputStream inStream;
    private Reader inReader;
    private int peekChar = -2;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.329 -0400", hash_original_method = "0C9484F593CC2C76BC0994AA6F883855", hash_generated_method = "BFE199D36DA44C634A3493E1E1F493C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private StreamTokenizer() {
        wordChars('A', 'Z');
        wordChars('a', 'z');
        wordChars(160, 255);
        whitespaceChars(0, 32);
        commentChar('/');
        quoteChar('"');
        quoteChar('\'');
        parseNumbers();
        // ---------- Original Method ----------
        //wordChars('A', 'Z');
        //wordChars('a', 'z');
        //wordChars(160, 255);
        //whitespaceChars(0, 32);
        //commentChar('/');
        //quoteChar('"');
        //quoteChar('\'');
        //parseNumbers();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.329 -0400", hash_original_method = "024007D8DD8258E54D25FF7D12CDFD92", hash_generated_method = "EA58EAFF3D1E0FDFB49C0E269389F738")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public StreamTokenizer(InputStream is) {
        this();
        dsTaint.addTaint(is.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        // ---------- Original Method ----------
        //if (is == null) {
            //throw new NullPointerException();
        //}
        //inStream = is;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.329 -0400", hash_original_method = "0EF3862126AC8C7CB18364F21A3441E5", hash_generated_method = "5436C5A6A008F7BCDE88B2144AA69423")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StreamTokenizer(Reader r) {
        this();
        dsTaint.addTaint(r.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        // ---------- Original Method ----------
        //if (r == null) {
            //throw new NullPointerException();
        //}
        //inReader = r;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.329 -0400", hash_original_method = "E38E4469494A7A375F4DC16613BFC71B", hash_generated_method = "5C3A11F301AEB8E3957AFB2AE11B56D2")
    @DSModeled(DSC.SAFE)
    public void commentChar(int ch) {
        dsTaint.addTaint(ch);
        {
            tokenTypes[ch] = TOKEN_COMMENT;
        } //End block
        // ---------- Original Method ----------
        //if (ch >= 0 && ch < tokenTypes.length) {
            //tokenTypes[ch] = TOKEN_COMMENT;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.329 -0400", hash_original_method = "4574927758DBFC248F61FB44F6B60AD5", hash_generated_method = "DA793CA2233EF30D794003B5E17FC0A4")
    @DSModeled(DSC.SAFE)
    public void eolIsSignificant(boolean flag) {
        dsTaint.addTaint(flag);
        // ---------- Original Method ----------
        //isEOLSignificant = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.329 -0400", hash_original_method = "CFD9FB1CAAFA0B398D0DDE009E39DD95", hash_generated_method = "98B181D00FA0B2A6B256AD859C457D23")
    @DSModeled(DSC.SAFE)
    public int lineno() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return lineNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.330 -0400", hash_original_method = "C3C8ED01DF0631C29C770DF7973EAB61", hash_generated_method = "8191D8312FBADFA802979F5CB033B54D")
    @DSModeled(DSC.SAFE)
    public void lowerCaseMode(boolean flag) {
        dsTaint.addTaint(flag);
        // ---------- Original Method ----------
        //forceLowercase = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.332 -0400", hash_original_method = "6817D84A74EC2CE0E287784F864856A8", hash_generated_method = "6929F8B2EBBD914AD48E606A66A32410")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int nextToken() throws IOException {
        {
            pushBackToken = false;
        } //End block
        sval = null;
        int currentChar;
        currentChar = read();
        currentChar = peekChar;
        {
            lastCr = false;
            currentChar = read();
        } //End block
        {
            int var17C05B32AD394A4CBEBB2B851E4EA4AB_27494673 = ((ttype = TT_EOF));
        } //End block
        byte currentType;
        currentType = TOKEN_WORD;
        currentType = tokenTypes[currentChar];
        {
            {
                {
                    lastCr = true;
                    peekChar = -2;
                    int var2F623C72499F8529FA801CB02BFBAD9C_2141786406 = ((ttype = TT_EOL));
                } //End block
                {
                    boolean varCD31E5D361309EFEAEC95C77708754BA_277616485 = ((currentChar = read()) == '\n');
                    {
                        currentChar = read();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    peekChar = -2;
                    int var2F623C72499F8529FA801CB02BFBAD9C_1146609165 = ((ttype = TT_EOL));
                } //End block
                currentChar = read();
            } //End block
            {
                currentChar = read();
            } //End block
            {
                int var061EA61648A946E752E81360A8626CBC_1914330705 = ((ttype = TT_EOF));
            } //End block
            currentType = currentChar > 255 ? TOKEN_WORD
                    : tokenTypes[currentChar];
        } //End block
        {
            StringBuilder digits;
            digits = new StringBuilder(20);
            boolean haveDecimal, checkJustNegative;
            haveDecimal = false;
            checkJustNegative = currentChar == '-';
            {
                {
                    haveDecimal = true;
                } //End block
                digits.append((char) currentChar);
                currentChar = read();
            } //End block
            peekChar = currentChar;
            {
                boolean varB46BEBABFCE2ADF32A4BAE6982576127_512892299 = (checkJustNegative && digits.length() == 1);
                {
                    int var1F147751DA2366DB3B63FF702929E5CA_1760832610 = ((ttype = '-'));
                } //End block
            } //End collapsed parenthetic
            try 
            {
                nval = Double.valueOf(digits.toString()).doubleValue();
            } //End block
            catch (NumberFormatException e)
            {
                nval = 0;
            } //End block
            int var12F9A9044A4D8A12472DFF66BBC77784_242845622 = ((ttype = TT_NUMBER));
        } //End block
        {
            StringBuilder word;
            word = new StringBuilder(20);
            {
                word.append((char) currentChar);
                currentChar = read();
            } //End block
            peekChar = currentChar;
            sval = word.toString();
            {
                sval = sval.toLowerCase(Locale.getDefault());
            } //End block
            int var1D67CB335E27D24492DE41527B52985A_557816809 = ((ttype = TT_WORD));
        } //End block
        {
            int matchQuote;
            matchQuote = currentChar;
            StringBuilder quoteString;
            quoteString = new StringBuilder();
            int peekOne;
            peekOne = read();
            {
                boolean readPeek;
                readPeek = true;
                {
                    int c1;
                    c1 = read();
                    {
                        int digitValue;
                        digitValue = c1 - '0';
                        c1 = read();
                        {
                            readPeek = false;
                        } //End block
                        {
                            digitValue = digitValue * 8 + (c1 - '0');
                            c1 = read();
                            {
                                readPeek = false;
                            } //End block
                            {
                                digitValue = digitValue * 8 + (c1 - '0');
                            } //End block
                        } //End block
                        {
                            quoteString.append((char) digitValue);
                            peekOne = c1;
                        } //End block
                        {
                            peekOne = digitValue;
                        } //End block
                    } //End block
                    {
                        //Begin case 'a' 
                        peekOne = 0x7;
                        //End case 'a' 
                        //Begin case 'b' 
                        peekOne = 0x8;
                        //End case 'b' 
                        //Begin case 'f' 
                        peekOne = 0xc;
                        //End case 'f' 
                        //Begin case 'n' 
                        peekOne = 0xA;
                        //End case 'n' 
                        //Begin case 'r' 
                        peekOne = 0xD;
                        //End case 'r' 
                        //Begin case 't' 
                        peekOne = 0x9;
                        //End case 't' 
                        //Begin case 'v' 
                        peekOne = 0xB;
                        //End case 'v' 
                        //Begin case default 
                        peekOne = c1;
                        //End case default 
                    } //End block
                } //End block
                {
                    quoteString.append((char) peekOne);
                    peekOne = read();
                } //End block
            } //End block
            {
                peekOne = read();
            } //End block
            peekChar = peekOne;
            ttype = matchQuote;
            sval = quoteString.toString();
        } //End block
        {
            {
                boolean var72FDA29550C5DA6495D00C7F15A9B87A_760306756 = ((currentChar = read()) == '*' && slashStarComments);
                {
                    int peekOne;
                    peekOne = read();
                    {
                        currentChar = peekOne;
                        peekOne = read();
                        {
                            peekChar = -1;
                            int var9876CE61C45609B4CCA0BBBEB428CF76_1261889641 = ((ttype = TT_EOF));
                        } //End block
                        {
                            {
                                peekOne = read();
                            } //End block
                        } //End block
                        {
                            peekChar = read();
                            int var7D5AC34CE07646C4210056D34B004003_949839744 = (nextToken());
                        } //End block
                    } //End block
                } //End block
                {
                    {
                        boolean var6F3B1E23367A173B795E7B7019053D39_417676736 = ((currentChar = read()) >= 0 && currentChar != '\r'
                        && currentChar != '\n');
                    } //End collapsed parenthetic
                    peekChar = currentChar;
                    int var73914B109F928801A1A2BAD2774AFFAC_366346338 = (nextToken());
                } //End block
                {
                    peekChar = currentChar;
                    int var404135D2182227365EE19289C9AAE88B_1804357395 = ((ttype = '/'));
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var4CDDE76CAE3442F3A7EDAC9B601E603B_205197561 = ((currentChar = read()) >= 0 && currentChar != '\r'
                    && currentChar != '\n');
            } //End collapsed parenthetic
            peekChar = currentChar;
            int varE9995CE7B76BA31C319036288CB615F9_1191733418 = (nextToken());
        } //End block
        peekChar = read();
        int varE630A50255FA0F6D82561A4E33322DC6_664887432 = ((ttype = currentChar));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.333 -0400", hash_original_method = "F56215932CA46446CC1F49421E19E4D4", hash_generated_method = "04B6171B021B83569E6254D16B37CD42")
    @DSModeled(DSC.SAFE)
    public void ordinaryChar(int ch) {
        dsTaint.addTaint(ch);
        {
            tokenTypes[ch] = 0;
        } //End block
        // ---------- Original Method ----------
        //if (ch >= 0 && ch < tokenTypes.length) {
            //tokenTypes[ch] = 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.334 -0400", hash_original_method = "022AE8E9D3C39CFDE89A16E6E6C68B23", hash_generated_method = "D72ACE5F5EA4D29921AEF4F4C2DAEC4E")
    @DSModeled(DSC.SAFE)
    public void ordinaryChars(int low, int hi) {
        dsTaint.addTaint(hi);
        dsTaint.addTaint(low);
        {
            low = 0;
        } //End block
        {
            hi = tokenTypes.length - 1;
        } //End block
        {
            int i;
            i = low;
            {
                tokenTypes[i] = 0;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (low < 0) {
            //low = 0;
        //}
        //if (hi > tokenTypes.length) {
            //hi = tokenTypes.length - 1;
        //}
        //for (int i = low; i <= hi; i++) {
            //tokenTypes[i] = 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.335 -0400", hash_original_method = "F9A1AE339D1E856A34C84852283E0CEC", hash_generated_method = "737F0FC3780F20EE288C2019D4F43260")
    @DSModeled(DSC.SAFE)
    public void parseNumbers() {
        {
            int i;
            i = '0';
            {
                tokenTypes[i] |= TOKEN_DIGIT;
            } //End block
        } //End collapsed parenthetic
        tokenTypes['.'] |= TOKEN_DIGIT;
        tokenTypes['-'] |= TOKEN_DIGIT;
        // ---------- Original Method ----------
        //for (int i = '0'; i <= '9'; i++) {
            //tokenTypes[i] |= TOKEN_DIGIT;
        //}
        //tokenTypes['.'] |= TOKEN_DIGIT;
        //tokenTypes['-'] |= TOKEN_DIGIT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.335 -0400", hash_original_method = "60DC1125C539441B12106C43E5B596F1", hash_generated_method = "A3EF001CA6E665A21C1D9FF188DBBDB5")
    @DSModeled(DSC.SAFE)
    public void pushBack() {
        pushBackToken = true;
        // ---------- Original Method ----------
        //pushBackToken = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.335 -0400", hash_original_method = "9CC8FE0D7A922378FBAE42482AA646D9", hash_generated_method = "67D3B042006CCBA18CFBA5DB4400C1E2")
    @DSModeled(DSC.SAFE)
    public void quoteChar(int ch) {
        dsTaint.addTaint(ch);
        {
            tokenTypes[ch] = TOKEN_QUOTE;
        } //End block
        // ---------- Original Method ----------
        //if (ch >= 0 && ch < tokenTypes.length) {
            //tokenTypes[ch] = TOKEN_QUOTE;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.336 -0400", hash_original_method = "056CD8A5FA209600CEBA1D62E49B6620", hash_generated_method = "37F52D6754F7D562E22D9C53FCFFEA5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int read() throws IOException {
        {
            int varC4C6DAE5422CCF4C0F11D932EDC135E6_1665258418 = (inReader.read());
        } //End block
        int var00673B8227E32F75A138B89CA02A0FA2_1241572901 = (inStream.read());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (inStream == null) {
            //return inReader.read();
        //}
        //return inStream.read();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.336 -0400", hash_original_method = "2D6865C117A48D63E7E9EC7F43B1136B", hash_generated_method = "54201012E0B04CC1DDAFF46E938942E9")
    @DSModeled(DSC.SAFE)
    public void resetSyntax() {
        {
            int i;
            i = 0;
            {
                tokenTypes[i] = 0;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (int i = 0; i < 256; i++) {
            //tokenTypes[i] = 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.336 -0400", hash_original_method = "0BBEE324D353623AAF036FC109969157", hash_generated_method = "98C28A83D067D1D0356809CA862BFFBA")
    @DSModeled(DSC.SAFE)
    public void slashSlashComments(boolean flag) {
        dsTaint.addTaint(flag);
        // ---------- Original Method ----------
        //slashSlashComments = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.336 -0400", hash_original_method = "73AA04832C7FF855283D30769102DB3E", hash_generated_method = "DB6A67824AEC5EE472E8D278E1F1B406")
    @DSModeled(DSC.SAFE)
    public void slashStarComments(boolean flag) {
        dsTaint.addTaint(flag);
        // ---------- Original Method ----------
        //slashStarComments = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.336 -0400", hash_original_method = "00DF77F4EAECB68BC1742A03B5A51C8E", hash_generated_method = "F2B456077F0CBB1AA1AE98503FCF7FFF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder result;
        result = new StringBuilder();
        result.append("Token[");
        //Begin case TT_EOF 
        result.append("EOF");
        //End case TT_EOF 
        //Begin case TT_EOL 
        result.append("EOL");
        //End case TT_EOL 
        //Begin case TT_NUMBER 
        result.append("n=");
        //End case TT_NUMBER 
        //Begin case TT_NUMBER 
        result.append(nval);
        //End case TT_NUMBER 
        //Begin case TT_WORD 
        result.append(sval);
        //End case TT_WORD 
        //Begin case default 
        {
            result.append(sval);
        } //End block
        {
            result.append('\'');
            result.append((char) ttype);
            result.append('\'');
        } //End block
        //End case default 
        result.append("], line ");
        result.append(lineNumber);
        String varEA70154FDA28CC59402440C6317B57EF_1594795241 = (result.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.337 -0400", hash_original_method = "70A99B8CFA2D4FEC72EA62C54EC3FE21", hash_generated_method = "088A6A800DD8F7408C89DF962C5A18B6")
    @DSModeled(DSC.SAFE)
    public void whitespaceChars(int low, int hi) {
        dsTaint.addTaint(hi);
        dsTaint.addTaint(low);
        {
            low = 0;
        } //End block
        {
            hi = tokenTypes.length - 1;
        } //End block
        {
            int i;
            i = low;
            {
                tokenTypes[i] = TOKEN_WHITE;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (low < 0) {
            //low = 0;
        //}
        //if (hi > tokenTypes.length) {
            //hi = tokenTypes.length - 1;
        //}
        //for (int i = low; i <= hi; i++) {
            //tokenTypes[i] = TOKEN_WHITE;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.337 -0400", hash_original_method = "CCF6D4E2D65BDFCC5D3A11ED629A7633", hash_generated_method = "14DC45A7D2EDC0E278FBC5B76BEFFED7")
    @DSModeled(DSC.SAFE)
    public void wordChars(int low, int hi) {
        dsTaint.addTaint(hi);
        dsTaint.addTaint(low);
        {
            low = 0;
        } //End block
        {
            hi = tokenTypes.length - 1;
        } //End block
        {
            int i;
            i = low;
            {
                tokenTypes[i] |= TOKEN_WORD;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (low < 0) {
            //low = 0;
        //}
        //if (hi > tokenTypes.length) {
            //hi = tokenTypes.length - 1;
        //}
        //for (int i = low; i <= hi; i++) {
            //tokenTypes[i] |= TOKEN_WORD;
        //}
    }

    
    public static final int TT_EOF = -1;
    public static final int TT_EOL = '\n';
    public static final int TT_NUMBER = -2;
    public static final int TT_WORD = -3;
    private static final int TT_UNKNOWN = -4;
    private static final byte TOKEN_COMMENT = 1;
    private static final byte TOKEN_QUOTE = 2;
    private static final byte TOKEN_WHITE = 4;
    private static final byte TOKEN_WORD = 8;
    private static final byte TOKEN_DIGIT = 16;
}

