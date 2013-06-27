package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Locale;

public class StreamTokenizer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.995 -0400", hash_original_field = "A5E0FB6CA915CF212B6528E5AE1786F2", hash_generated_field = "61CABEDACAAE440F819A66BD081717D9")

    public double nval;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.995 -0400", hash_original_field = "2D79067F0FCB37A2C56A7C466F56F0AE", hash_generated_field = "6B1824743AABE9479A43318581BA47FF")

    public String sval;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.995 -0400", hash_original_field = "2FF2B7A9D7E3F51194AECDB2DEF7015A", hash_generated_field = "77D997FE9B64F760BAC88B55FE1EF2E2")

    public int ttype = TT_UNKNOWN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.995 -0400", hash_original_field = "F654207B294D7A54BC9568D754FF03F2", hash_generated_field = "806B2BD50024961410FB07586F0E377B")

    private byte[] tokenTypes = new byte[256];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.995 -0400", hash_original_field = "3D3962D4BEE62481EA3F8021EB635761", hash_generated_field = "27FA2CFD35EEFAE64C7DFD7FF18A54A3")

    private int lineNumber = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.995 -0400", hash_original_field = "2162448399292E41CD22AF0B3E6362A0", hash_generated_field = "7FF9EA1081BB65BCD5D6FFEE94A98B82")

    private boolean forceLowercase;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.995 -0400", hash_original_field = "D7D91BD6C27586C91F5A3200B0CA749A", hash_generated_field = "D954790BC163C65FCE60F79A2C012ED2")

    private boolean isEOLSignificant;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.995 -0400", hash_original_field = "2869BD2BB302CF004B256C95A190DDE9", hash_generated_field = "D47D5E18F60921FF3632B427BB9CD0AA")

    private boolean slashStarComments;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.996 -0400", hash_original_field = "A2B17AEA17376EAFFB815FF1EAF59BA2", hash_generated_field = "DC8C8DC2DAFEE20CDA1B1F463AF2DF71")

    private boolean slashSlashComments;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.996 -0400", hash_original_field = "8FF35407B7DAC048097ECDB9CFCFAE49", hash_generated_field = "49F6B836F7E1D68FD6E01FA2485232FE")

    private boolean pushBackToken;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.996 -0400", hash_original_field = "309C533BBCC25BEBC30324D8F938367E", hash_generated_field = "96F646C740AFE4E9E4C51A083C4D3595")

    private boolean lastCr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.996 -0400", hash_original_field = "F62CCA1498B2D705CDB564215019352D", hash_generated_field = "848E95AB29D035B62B017F39E2191D18")

    private InputStream inStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.996 -0400", hash_original_field = "1C0589F3DEF8F87395787308689FA47B", hash_generated_field = "BBEB5044AD720FD044C79AD81CEC888B")

    private Reader inReader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.996 -0400", hash_original_field = "D6FB9E4F04EEAFAE1871788DA81B6560", hash_generated_field = "32E47E44D4C148CFC795B5BAC1FD140A")

    private int peekChar = -2;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.996 -0400", hash_original_method = "0C9484F593CC2C76BC0994AA6F883855", hash_generated_method = "BFE199D36DA44C634A3493E1E1F493C8")
    private  StreamTokenizer() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.996 -0400", hash_original_method = "024007D8DD8258E54D25FF7D12CDFD92", hash_generated_method = "E4110815E4048DFF7C9844C439D979C3")
    @Deprecated
    public  StreamTokenizer(InputStream is) {
        this();
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        inStream = is;
        // ---------- Original Method ----------
        //if (is == null) {
            //throw new NullPointerException();
        //}
        //inStream = is;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.997 -0400", hash_original_method = "0EF3862126AC8C7CB18364F21A3441E5", hash_generated_method = "0D15C8DC5D37C3410CFFAE2FC6214FF6")
    public  StreamTokenizer(Reader r) {
        this();
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        inReader = r;
        // ---------- Original Method ----------
        //if (r == null) {
            //throw new NullPointerException();
        //}
        //inReader = r;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.997 -0400", hash_original_method = "E38E4469494A7A375F4DC16613BFC71B", hash_generated_method = "6B98B5A84BF1906BF44570E0CF67C2E2")
    public void commentChar(int ch) {
        {
            tokenTypes[ch] = TOKEN_COMMENT;
        } //End block
        // ---------- Original Method ----------
        //if (ch >= 0 && ch < tokenTypes.length) {
            //tokenTypes[ch] = TOKEN_COMMENT;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.999 -0400", hash_original_method = "4574927758DBFC248F61FB44F6B60AD5", hash_generated_method = "E7ACAC53B63CEEEDB7720AC0F5F43491")
    public void eolIsSignificant(boolean flag) {
        isEOLSignificant = flag;
        // ---------- Original Method ----------
        //isEOLSignificant = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.000 -0400", hash_original_method = "CFD9FB1CAAFA0B398D0DDE009E39DD95", hash_generated_method = "0F0C09FF01C0790173858445DE132C6E")
    public int lineno() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1572269363 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1572269363;
        // ---------- Original Method ----------
        //return lineNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.000 -0400", hash_original_method = "C3C8ED01DF0631C29C770DF7973EAB61", hash_generated_method = "BED58A09E44AEB960ACFACB2D18D13A6")
    public void lowerCaseMode(boolean flag) {
        forceLowercase = flag;
        // ---------- Original Method ----------
        //forceLowercase = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.028 -0400", hash_original_method = "6817D84A74EC2CE0E287784F864856A8", hash_generated_method = "5E3E75671AC6F4F0FA2B8373BF84E6EB")
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
            int var17C05B32AD394A4CBEBB2B851E4EA4AB_629431133 = ((ttype = TT_EOF));
        } //End block
        byte currentType;
        currentType = TOKEN_WORD;
        currentType = tokenTypes[currentChar];
        {
            {
                {
                    lastCr = true;
                    peekChar = -2;
                    int var2F623C72499F8529FA801CB02BFBAD9C_1511791140 = ((ttype = TT_EOL));
                } //End block
                {
                    boolean varCD31E5D361309EFEAEC95C77708754BA_1078118610 = ((currentChar = read()) == '\n');
                    {
                        currentChar = read();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    peekChar = -2;
                    int var2F623C72499F8529FA801CB02BFBAD9C_297893494 = ((ttype = TT_EOL));
                } //End block
                currentChar = read();
            } //End block
            {
                currentChar = read();
            } //End block
            {
                int var061EA61648A946E752E81360A8626CBC_1447741916 = ((ttype = TT_EOF));
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
                boolean varB46BEBABFCE2ADF32A4BAE6982576127_785529248 = (checkJustNegative && digits.length() == 1);
                {
                    int var1F147751DA2366DB3B63FF702929E5CA_1829686481 = ((ttype = '-'));
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
            int var12F9A9044A4D8A12472DFF66BBC77784_956523688 = ((ttype = TT_NUMBER));
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
            int var1D67CB335E27D24492DE41527B52985A_299285836 = ((ttype = TT_WORD));
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
                boolean var72FDA29550C5DA6495D00C7F15A9B87A_940706490 = ((currentChar = read()) == '*' && slashStarComments);
                {
                    int peekOne;
                    peekOne = read();
                    {
                        currentChar = peekOne;
                        peekOne = read();
                        {
                            peekChar = -1;
                            int var9876CE61C45609B4CCA0BBBEB428CF76_1234049560 = ((ttype = TT_EOF));
                        } //End block
                        {
                            {
                                peekOne = read();
                            } //End block
                        } //End block
                        {
                            peekChar = read();
                            int var7D5AC34CE07646C4210056D34B004003_307178446 = (nextToken());
                        } //End block
                    } //End block
                } //End block
                {
                    {
                        boolean var6F3B1E23367A173B795E7B7019053D39_430946366 = ((currentChar = read()) >= 0 && currentChar != '\r'
                        && currentChar != '\n');
                    } //End collapsed parenthetic
                    peekChar = currentChar;
                    int var73914B109F928801A1A2BAD2774AFFAC_1785714604 = (nextToken());
                } //End block
                {
                    peekChar = currentChar;
                    int var404135D2182227365EE19289C9AAE88B_1303324096 = ((ttype = '/'));
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean var4CDDE76CAE3442F3A7EDAC9B601E603B_1390516052 = ((currentChar = read()) >= 0 && currentChar != '\r'
                    && currentChar != '\n');
            } //End collapsed parenthetic
            peekChar = currentChar;
            int varE9995CE7B76BA31C319036288CB615F9_1575403328 = (nextToken());
        } //End block
        peekChar = read();
        int varE630A50255FA0F6D82561A4E33322DC6_2003860137 = ((ttype = currentChar));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_960863369 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_960863369;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.036 -0400", hash_original_method = "F56215932CA46446CC1F49421E19E4D4", hash_generated_method = "E4938415BBCA225FE3069BBDF8033E3A")
    public void ordinaryChar(int ch) {
        {
            tokenTypes[ch] = 0;
        } //End block
        // ---------- Original Method ----------
        //if (ch >= 0 && ch < tokenTypes.length) {
            //tokenTypes[ch] = 0;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.036 -0400", hash_original_method = "022AE8E9D3C39CFDE89A16E6E6C68B23", hash_generated_method = "5C3ED678672FAB24945337770E30D025")
    public void ordinaryChars(int low, int hi) {
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
        addTaint(low);
        addTaint(hi);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.045 -0400", hash_original_method = "F9A1AE339D1E856A34C84852283E0CEC", hash_generated_method = "737F0FC3780F20EE288C2019D4F43260")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.045 -0400", hash_original_method = "60DC1125C539441B12106C43E5B596F1", hash_generated_method = "A3EF001CA6E665A21C1D9FF188DBBDB5")
    public void pushBack() {
        pushBackToken = true;
        // ---------- Original Method ----------
        //pushBackToken = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.046 -0400", hash_original_method = "9CC8FE0D7A922378FBAE42482AA646D9", hash_generated_method = "74F12F505C8935267B617613214DF3C2")
    public void quoteChar(int ch) {
        {
            tokenTypes[ch] = TOKEN_QUOTE;
        } //End block
        // ---------- Original Method ----------
        //if (ch >= 0 && ch < tokenTypes.length) {
            //tokenTypes[ch] = TOKEN_QUOTE;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.046 -0400", hash_original_method = "056CD8A5FA209600CEBA1D62E49B6620", hash_generated_method = "596B5C29A133628846FF087632E8B581")
    private int read() throws IOException {
        {
            int varC4C6DAE5422CCF4C0F11D932EDC135E6_2090649745 = (inReader.read());
        } //End block
        int var00673B8227E32F75A138B89CA02A0FA2_888648535 = (inStream.read());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1738678817 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1738678817;
        // ---------- Original Method ----------
        //if (inStream == null) {
            //return inReader.read();
        //}
        //return inStream.read();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.046 -0400", hash_original_method = "2D6865C117A48D63E7E9EC7F43B1136B", hash_generated_method = "54201012E0B04CC1DDAFF46E938942E9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.046 -0400", hash_original_method = "0BBEE324D353623AAF036FC109969157", hash_generated_method = "54079048C39252366A87C0EA330A3491")
    public void slashSlashComments(boolean flag) {
        slashSlashComments = flag;
        // ---------- Original Method ----------
        //slashSlashComments = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.053 -0400", hash_original_method = "73AA04832C7FF855283D30769102DB3E", hash_generated_method = "FEA5FDEAC577D365D3552916E6F5E766")
    public void slashStarComments(boolean flag) {
        slashStarComments = flag;
        // ---------- Original Method ----------
        //slashStarComments = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.054 -0400", hash_original_method = "00DF77F4EAECB68BC1742A03B5A51C8E", hash_generated_method = "7A463CF737978E94AA463D1E3F051A37")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_419005243 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_419005243 = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_419005243.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_419005243;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.054 -0400", hash_original_method = "70A99B8CFA2D4FEC72EA62C54EC3FE21", hash_generated_method = "EDD99D61B8E82FDC891248A0D53049E8")
    public void whitespaceChars(int low, int hi) {
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
        addTaint(low);
        addTaint(hi);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.055 -0400", hash_original_method = "CCF6D4E2D65BDFCC5D3A11ED629A7633", hash_generated_method = "A517066681F915F39186E3BF7E31F1CC")
    public void wordChars(int low, int hi) {
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
        addTaint(low);
        addTaint(hi);
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.055 -0400", hash_original_field = "FDB01D851A4EBA0C887B2F68F1C3C6A4", hash_generated_field = "CE1461C2F3CB152AF49883B7F99787FB")

    public static final int TT_EOF = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.055 -0400", hash_original_field = "4EF94701AEAAA3CA8541C1A101C83D91", hash_generated_field = "B268C6BA8A886B092A77409C21A1508B")

    public static final int TT_EOL = '\n';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.055 -0400", hash_original_field = "5108BCA93811DA61F80F5DA2F50E5C14", hash_generated_field = "C7B7189E8CD30D5160940E644F967084")

    public static final int TT_NUMBER = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.055 -0400", hash_original_field = "181F50EC6B729B7C935E30AFFE05AED2", hash_generated_field = "E9C083A72C44A8E06557D4F80D18307A")

    public static final int TT_WORD = -3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.055 -0400", hash_original_field = "021ED851CBCF97041718C0A9C1430D31", hash_generated_field = "28B0A18902C4352815BEFF4A50B04642")

    private static int TT_UNKNOWN = -4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.055 -0400", hash_original_field = "D602C9123075FDBD43D3FE3D370FC4E9", hash_generated_field = "8E7BDF9FB2FE2BE9C636C36D88E3F9BF")

    private static byte TOKEN_COMMENT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.055 -0400", hash_original_field = "1244EFFF7FC5AA8C0FD2F5862B37FC41", hash_generated_field = "C1137E65BCC8419CABE9050B585DE94E")

    private static byte TOKEN_QUOTE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.055 -0400", hash_original_field = "A30240EC2C4DFE148259020BF190CD57", hash_generated_field = "82DF82C6CA4F20964F24A78242370554")

    private static byte TOKEN_WHITE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.055 -0400", hash_original_field = "6735463E1C48D7A09032639A044397E8", hash_generated_field = "C2AC22C096E1AF2EFFD39FF6286F143C")

    private static byte TOKEN_WORD = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.055 -0400", hash_original_field = "3C63E8BC82C64D7EA112B998A2074689", hash_generated_field = "C4E2674017BCBB3835AB298360589417")

    private static byte TOKEN_DIGIT = 16;
}

