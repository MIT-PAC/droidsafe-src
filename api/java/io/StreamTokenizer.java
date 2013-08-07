package java.io;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Locale;






public class StreamTokenizer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.679 -0400", hash_original_field = "A5E0FB6CA915CF212B6528E5AE1786F2", hash_generated_field = "61CABEDACAAE440F819A66BD081717D9")

    public double nval;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.679 -0400", hash_original_field = "2D79067F0FCB37A2C56A7C466F56F0AE", hash_generated_field = "6B1824743AABE9479A43318581BA47FF")

    public String sval;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.679 -0400", hash_original_field = "2FF2B7A9D7E3F51194AECDB2DEF7015A", hash_generated_field = "77D997FE9B64F760BAC88B55FE1EF2E2")

    public int ttype = TT_UNKNOWN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.679 -0400", hash_original_field = "F654207B294D7A54BC9568D754FF03F2", hash_generated_field = "806B2BD50024961410FB07586F0E377B")

    private byte[] tokenTypes = new byte[256];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.679 -0400", hash_original_field = "3D3962D4BEE62481EA3F8021EB635761", hash_generated_field = "27FA2CFD35EEFAE64C7DFD7FF18A54A3")

    private int lineNumber = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.679 -0400", hash_original_field = "2162448399292E41CD22AF0B3E6362A0", hash_generated_field = "7FF9EA1081BB65BCD5D6FFEE94A98B82")

    private boolean forceLowercase;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.680 -0400", hash_original_field = "D7D91BD6C27586C91F5A3200B0CA749A", hash_generated_field = "D954790BC163C65FCE60F79A2C012ED2")

    private boolean isEOLSignificant;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.680 -0400", hash_original_field = "2869BD2BB302CF004B256C95A190DDE9", hash_generated_field = "D47D5E18F60921FF3632B427BB9CD0AA")

    private boolean slashStarComments;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.680 -0400", hash_original_field = "A2B17AEA17376EAFFB815FF1EAF59BA2", hash_generated_field = "DC8C8DC2DAFEE20CDA1B1F463AF2DF71")

    private boolean slashSlashComments;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.680 -0400", hash_original_field = "8FF35407B7DAC048097ECDB9CFCFAE49", hash_generated_field = "49F6B836F7E1D68FD6E01FA2485232FE")

    private boolean pushBackToken;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.680 -0400", hash_original_field = "309C533BBCC25BEBC30324D8F938367E", hash_generated_field = "96F646C740AFE4E9E4C51A083C4D3595")

    private boolean lastCr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.680 -0400", hash_original_field = "F62CCA1498B2D705CDB564215019352D", hash_generated_field = "848E95AB29D035B62B017F39E2191D18")

    private InputStream inStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.680 -0400", hash_original_field = "1C0589F3DEF8F87395787308689FA47B", hash_generated_field = "BBEB5044AD720FD044C79AD81CEC888B")

    private Reader inReader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.680 -0400", hash_original_field = "D6FB9E4F04EEAFAE1871788DA81B6560", hash_generated_field = "32E47E44D4C148CFC795B5BAC1FD140A")

    private int peekChar = -2;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.680 -0400", hash_original_method = "0C9484F593CC2C76BC0994AA6F883855", hash_generated_method = "BFE199D36DA44C634A3493E1E1F493C8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.681 -0400", hash_original_method = "024007D8DD8258E54D25FF7D12CDFD92", hash_generated_method = "F9FDA718FD20269C8A1E4422C6DC9A0A")
    @Deprecated
    public  StreamTokenizer(InputStream is) {
        this();
        if(is == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1057314373 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1057314373.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1057314373;
        } //End block
        inStream = is;
        // ---------- Original Method ----------
        //if (is == null) {
            //throw new NullPointerException();
        //}
        //inStream = is;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.681 -0400", hash_original_method = "0EF3862126AC8C7CB18364F21A3441E5", hash_generated_method = "0473AA46308B4DE5E949124FFF8B3242")
    public  StreamTokenizer(Reader r) {
        this();
        if(r == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_572050451 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_572050451.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_572050451;
        } //End block
        inReader = r;
        // ---------- Original Method ----------
        //if (r == null) {
            //throw new NullPointerException();
        //}
        //inReader = r;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.682 -0400", hash_original_method = "E38E4469494A7A375F4DC16613BFC71B", hash_generated_method = "ED124AB306A25409029CC9A90A681766")
    public void commentChar(int ch) {
        if(ch >= 0 && ch < tokenTypes.length)        
        {
            tokenTypes[ch] = TOKEN_COMMENT;
        } //End block
        // ---------- Original Method ----------
        //if (ch >= 0 && ch < tokenTypes.length) {
            //tokenTypes[ch] = TOKEN_COMMENT;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.682 -0400", hash_original_method = "4574927758DBFC248F61FB44F6B60AD5", hash_generated_method = "E7ACAC53B63CEEEDB7720AC0F5F43491")
    public void eolIsSignificant(boolean flag) {
        isEOLSignificant = flag;
        // ---------- Original Method ----------
        //isEOLSignificant = flag;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.683 -0400", hash_original_method = "CFD9FB1CAAFA0B398D0DDE009E39DD95", hash_generated_method = "663B338A623B588A5D808E7D4113A31B")
    public int lineno() {
        int varBB8A5A0BF5B38F7D371E940DAED92DA6_1056846937 = (lineNumber);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1902707606 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1902707606;
        // ---------- Original Method ----------
        //return lineNumber;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.683 -0400", hash_original_method = "C3C8ED01DF0631C29C770DF7973EAB61", hash_generated_method = "BED58A09E44AEB960ACFACB2D18D13A6")
    public void lowerCaseMode(boolean flag) {
        forceLowercase = flag;
        // ---------- Original Method ----------
        //forceLowercase = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.724 -0400", hash_original_method = "6817D84A74EC2CE0E287784F864856A8", hash_generated_method = "5591F4212A7ADD61489606CDB42FDA90")
    public int nextToken() throws IOException {
        if(pushBackToken)        
        {
            pushBackToken = false;
            if(ttype != TT_UNKNOWN)            
            {
                int var8812C2D4C7F71CB374BF8DD7386F19CF_881333977 = (ttype);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1012189119 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1012189119;
            } //End block
        } //End block
        sval = null;
        int currentChar = peekChar == -2 ? read() : peekChar;
        if(lastCr && currentChar == '\n')        
        {
            lastCr = false;
            currentChar = read();
        } //End block
        if(currentChar == -1)        
        {
            int varC9DE119BAFD1DCCB628DC3D44BBA1AF5_1931404512 = ((ttype = TT_EOF));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1376321483 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1376321483;
        } //End block
        byte currentType = currentChar > 255 ? TOKEN_WORD
                : tokenTypes[currentChar];
        while
((currentType & TOKEN_WHITE) != 0)        
        {
            if(currentChar == '\r')            
            {
                lineNumber++;
                if(isEOLSignificant)                
                {
                    lastCr = true;
                    peekChar = -2;
                    int varA4395DC2D3B87A20D350581C3116D9E3_1669330842 = ((ttype = TT_EOL));
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2087680958 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2087680958;
                } //End block
                if((currentChar = read()) == '\n')                
                {
                    currentChar = read();
                } //End block
            } //End block
            else
            if(currentChar == '\n')            
            {
                lineNumber++;
                if(isEOLSignificant)                
                {
                    peekChar = -2;
                    int varA4395DC2D3B87A20D350581C3116D9E3_1221613898 = ((ttype = TT_EOL));
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_200905067 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_200905067;
                } //End block
                currentChar = read();
            } //End block
            else
            {
                currentChar = read();
            } //End block
            if(currentChar == -1)            
            {
                int varC9DE119BAFD1DCCB628DC3D44BBA1AF5_1937742465 = ((ttype = TT_EOF));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_956261438 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_956261438;
            } //End block
            currentType = currentChar > 255 ? TOKEN_WORD
                    : tokenTypes[currentChar];
        } //End block
        if((currentType & TOKEN_DIGIT) != 0)        
        {
            StringBuilder digits = new StringBuilder(20);
            boolean haveDecimal = false;
            boolean checkJustNegative = currentChar == '-';
            while
(true)            
            {
                if(currentChar == '.')                
                {
                    haveDecimal = true;
                } //End block
                digits.append((char) currentChar);
                currentChar = read();
                if((currentChar < '0' || currentChar > '9')
                        && (haveDecimal || currentChar != '.'))                
                {
                    break;
                } //End block
            } //End block
            peekChar = currentChar;
            if(checkJustNegative && digits.length() == 1)            
            {
                int var73250C787BA7444F0D63A654EAB220B8_1325688606 = ((ttype = '-'));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_869737757 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_869737757;
            } //End block
            try 
            {
                nval = Double.valueOf(digits.toString()).doubleValue();
            } //End block
            catch (NumberFormatException e)
            {
                nval = 0;
            } //End block
            int var351A85F054D52C6754D94EF5B167FD54_1771626104 = ((ttype = TT_NUMBER));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1310105770 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1310105770;
        } //End block
        if((currentType & TOKEN_WORD) != 0)        
        {
            StringBuilder word = new StringBuilder(20);
            while
(true)            
            {
                word.append((char) currentChar);
                currentChar = read();
                if(currentChar == -1
                        || (currentChar < 256 && (tokenTypes[currentChar] & (TOKEN_WORD | TOKEN_DIGIT)) == 0))                
                {
                    break;
                } //End block
            } //End block
            peekChar = currentChar;
            sval = word.toString();
            if(forceLowercase)            
            {
                sval = sval.toLowerCase(Locale.getDefault());
            } //End block
            int var181E792688DB98713E1CB956D35C356C_769285719 = ((ttype = TT_WORD));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1165449699 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1165449699;
        } //End block
        if(currentType == TOKEN_QUOTE)        
        {
            int matchQuote = currentChar;
            StringBuilder quoteString = new StringBuilder();
            int peekOne = read();
            while
(peekOne >= 0 && peekOne != matchQuote && peekOne != '\r'
                    && peekOne != '\n')            
            {
                boolean readPeek = true;
                if(peekOne == '\\')                
                {
                    int c1 = read();
                    if(c1 <= '7' && c1 >= '0')                    
                    {
                        int digitValue = c1 - '0';
                        c1 = read();
                        if(c1 > '7' || c1 < '0')                        
                        {
                            readPeek = false;
                        } //End block
                        else
                        {
                            digitValue = digitValue * 8 + (c1 - '0');
                            c1 = read();
                            if(digitValue > 037 || c1 > '7' || c1 < '0')                            
                            {
                                readPeek = false;
                            } //End block
                            else
                            {
                                digitValue = digitValue * 8 + (c1 - '0');
                            } //End block
                        } //End block
                        if(!readPeek)                        
                        {
                            quoteString.append((char) digitValue);
                            peekOne = c1;
                        } //End block
                        else
                        {
                            peekOne = digitValue;
                        } //End block
                    } //End block
                    else
                    {
switch(c1){
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
                    } //End block
                } //End block
                if(readPeek)                
                {
                    quoteString.append((char) peekOne);
                    peekOne = read();
                } //End block
            } //End block
            if(peekOne == matchQuote)            
            {
                peekOne = read();
            } //End block
            peekChar = peekOne;
            ttype = matchQuote;
            sval = quoteString.toString();
            int var8812C2D4C7F71CB374BF8DD7386F19CF_1226951931 = (ttype);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1548112544 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1548112544;
        } //End block
        if(currentChar == '/' && (slashSlashComments || slashStarComments))        
        {
            if((currentChar = read()) == '*' && slashStarComments)            
            {
                int peekOne = read();
                while
(true)                
                {
                    currentChar = peekOne;
                    peekOne = read();
                    if(currentChar == -1)                    
                    {
                        peekChar = -1;
                        int varC9DE119BAFD1DCCB628DC3D44BBA1AF5_1395417390 = ((ttype = TT_EOF));
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_715582451 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_715582451;
                    } //End block
                    if(currentChar == '\r')                    
                    {
                        if(peekOne == '\n')                        
                        {
                            peekOne = read();
                        } //End block
                        lineNumber++;
                    } //End block
                    else
                    if(currentChar == '\n')                    
                    {
                        lineNumber++;
                    } //End block
                    else
                    if(currentChar == '*' && peekOne == '/')                    
                    {
                        peekChar = read();
                        int var751813CF5AC7FADDD843B4C87D27707A_2108736917 = (nextToken());
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1679318648 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1679318648;
                    } //End block
                } //End block
            } //End block
            else
            if(currentChar == '/' && slashSlashComments)            
            {
                while
((currentChar = read()) >= 0 && currentChar != '\r'
                        && currentChar != '\n')                
                {
                } //End block
                peekChar = currentChar;
                int var751813CF5AC7FADDD843B4C87D27707A_1888212106 = (nextToken());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_487611112 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_487611112;
            } //End block
            else
            if(currentType != TOKEN_COMMENT)            
            {
                peekChar = currentChar;
                int varD9EC5456601809E2A13F311A8B31D33B_843455583 = ((ttype = '/'));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_475148911 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_475148911;
            } //End block
        } //End block
        if(currentType == TOKEN_COMMENT)        
        {
            while
((currentChar = read()) >= 0 && currentChar != '\r'
                    && currentChar != '\n')            
            {
            } //End block
            peekChar = currentChar;
            int var751813CF5AC7FADDD843B4C87D27707A_880145176 = (nextToken());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_389831450 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_389831450;
        } //End block
        peekChar = read();
        int var70029BB3C7E3C6FD887C1A992CC874F5_1587549317 = ((ttype = currentChar));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1875781300 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1875781300;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.726 -0400", hash_original_method = "F56215932CA46446CC1F49421E19E4D4", hash_generated_method = "6C1B78B929C369C2F919B80E00706968")
    public void ordinaryChar(int ch) {
        if(ch >= 0 && ch < tokenTypes.length)        
        {
            tokenTypes[ch] = 0;
        } //End block
        // ---------- Original Method ----------
        //if (ch >= 0 && ch < tokenTypes.length) {
            //tokenTypes[ch] = 0;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.726 -0400", hash_original_method = "022AE8E9D3C39CFDE89A16E6E6C68B23", hash_generated_method = "A8CD68C8B88D027BF8A246225A237EE5")
    public void ordinaryChars(int low, int hi) {
        addTaint(hi);
        addTaint(low);
        if(low < 0)        
        {
            low = 0;
        } //End block
        if(hi > tokenTypes.length)        
        {
            hi = tokenTypes.length - 1;
        } //End block
for(int i = low;i <= hi;i++)
        {
            tokenTypes[i] = 0;
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.727 -0400", hash_original_method = "F9A1AE339D1E856A34C84852283E0CEC", hash_generated_method = "FA88DE51AA39EE60F6FD01320465E0DB")
    public void parseNumbers() {
for(int i = '0';i <= '9';i++)
        {
            tokenTypes[i] |= TOKEN_DIGIT;
        } //End block
        tokenTypes['.'] |= TOKEN_DIGIT;
        tokenTypes['-'] |= TOKEN_DIGIT;
        // ---------- Original Method ----------
        //for (int i = '0'; i <= '9'; i++) {
            //tokenTypes[i] |= TOKEN_DIGIT;
        //}
        //tokenTypes['.'] |= TOKEN_DIGIT;
        //tokenTypes['-'] |= TOKEN_DIGIT;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.727 -0400", hash_original_method = "60DC1125C539441B12106C43E5B596F1", hash_generated_method = "A3EF001CA6E665A21C1D9FF188DBBDB5")
    public void pushBack() {
        pushBackToken = true;
        // ---------- Original Method ----------
        //pushBackToken = true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.728 -0400", hash_original_method = "9CC8FE0D7A922378FBAE42482AA646D9", hash_generated_method = "CE49B7669173FB20506B3DDECDA93C7F")
    public void quoteChar(int ch) {
        if(ch >= 0 && ch < tokenTypes.length)        
        {
            tokenTypes[ch] = TOKEN_QUOTE;
        } //End block
        // ---------- Original Method ----------
        //if (ch >= 0 && ch < tokenTypes.length) {
            //tokenTypes[ch] = TOKEN_QUOTE;
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.728 -0400", hash_original_method = "056CD8A5FA209600CEBA1D62E49B6620", hash_generated_method = "AE4B258FC04CDAFB0E083125428A786B")
    private int read() throws IOException {
        if(inStream == null)        
        {
            int varA3AB61B365B0DB71BD77D5CF383908F8_1251709713 = (inReader.read());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_912583382 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_912583382;
        } //End block
        int var53C087BBC2F9BF571A1BBD6418D936C3_135526946 = (inStream.read());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1298866356 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1298866356;
        // ---------- Original Method ----------
        //if (inStream == null) {
            //return inReader.read();
        //}
        //return inStream.read();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.728 -0400", hash_original_method = "2D6865C117A48D63E7E9EC7F43B1136B", hash_generated_method = "D7551DC93546FF8CDC2C89A563FCBE0F")
    public void resetSyntax() {
for(int i = 0;i < 256;i++)
        {
            tokenTypes[i] = 0;
        } //End block
        // ---------- Original Method ----------
        //for (int i = 0; i < 256; i++) {
            //tokenTypes[i] = 0;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.729 -0400", hash_original_method = "0BBEE324D353623AAF036FC109969157", hash_generated_method = "54079048C39252366A87C0EA330A3491")
    public void slashSlashComments(boolean flag) {
        slashSlashComments = flag;
        // ---------- Original Method ----------
        //slashSlashComments = flag;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.729 -0400", hash_original_method = "73AA04832C7FF855283D30769102DB3E", hash_generated_method = "FEA5FDEAC577D365D3552916E6F5E766")
    public void slashStarComments(boolean flag) {
        slashStarComments = flag;
        // ---------- Original Method ----------
        //slashStarComments = flag;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.730 -0400", hash_original_method = "00DF77F4EAECB68BC1742A03B5A51C8E", hash_generated_method = "352784A43818BB202DDD27BB27F02DFB")
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Token[");
switch(ttype){
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
        if(ttype == TT_UNKNOWN || tokenTypes[ttype] == TOKEN_QUOTE)        
        {
            result.append(sval);
        } //End block
        else
        {
            result.append('\'');
            result.append((char) ttype);
            result.append('\'');
        } //End block
}        result.append("], line ");
        result.append(lineNumber);
String varE65B3A02759122992CB82C0E651AD408_1096359202 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_1096359202.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_1096359202;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.730 -0400", hash_original_method = "70A99B8CFA2D4FEC72EA62C54EC3FE21", hash_generated_method = "7E9F6E09F46B343D5F6C7CB3F7D3EC77")
    public void whitespaceChars(int low, int hi) {
        addTaint(hi);
        addTaint(low);
        if(low < 0)        
        {
            low = 0;
        } //End block
        if(hi > tokenTypes.length)        
        {
            hi = tokenTypes.length - 1;
        } //End block
for(int i = low;i <= hi;i++)
        {
            tokenTypes[i] = TOKEN_WHITE;
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.731 -0400", hash_original_method = "CCF6D4E2D65BDFCC5D3A11ED629A7633", hash_generated_method = "D771BE83CC2CECAC2C457D2D8EA1A207")
    public void wordChars(int low, int hi) {
        addTaint(hi);
        addTaint(low);
        if(low < 0)        
        {
            low = 0;
        } //End block
        if(hi > tokenTypes.length)        
        {
            hi = tokenTypes.length - 1;
        } //End block
for(int i = low;i <= hi;i++)
        {
            tokenTypes[i] |= TOKEN_WORD;
        } //End block
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.731 -0400", hash_original_field = "FDB01D851A4EBA0C887B2F68F1C3C6A4", hash_generated_field = "CE1461C2F3CB152AF49883B7F99787FB")

    public static final int TT_EOF = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.731 -0400", hash_original_field = "4EF94701AEAAA3CA8541C1A101C83D91", hash_generated_field = "B268C6BA8A886B092A77409C21A1508B")

    public static final int TT_EOL = '\n';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.731 -0400", hash_original_field = "5108BCA93811DA61F80F5DA2F50E5C14", hash_generated_field = "C7B7189E8CD30D5160940E644F967084")

    public static final int TT_NUMBER = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.732 -0400", hash_original_field = "181F50EC6B729B7C935E30AFFE05AED2", hash_generated_field = "E9C083A72C44A8E06557D4F80D18307A")

    public static final int TT_WORD = -3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.732 -0400", hash_original_field = "021ED851CBCF97041718C0A9C1430D31", hash_generated_field = "C157BC2C8DB11DFCC846C695B2AD57DC")

    private static final int TT_UNKNOWN = -4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.732 -0400", hash_original_field = "D602C9123075FDBD43D3FE3D370FC4E9", hash_generated_field = "B5B31D6CF53277606D69A20BBD672055")

    private static final byte TOKEN_COMMENT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.732 -0400", hash_original_field = "1244EFFF7FC5AA8C0FD2F5862B37FC41", hash_generated_field = "47A200D0084A16EFA9E30FE833AFB1FB")

    private static final byte TOKEN_QUOTE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.732 -0400", hash_original_field = "A30240EC2C4DFE148259020BF190CD57", hash_generated_field = "C9DC638D16F1182F35227918AFD70078")

    private static final byte TOKEN_WHITE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.732 -0400", hash_original_field = "6735463E1C48D7A09032639A044397E8", hash_generated_field = "2AE0950E5470D97CB17C370704304234")

    private static final byte TOKEN_WORD = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.732 -0400", hash_original_field = "3C63E8BC82C64D7EA112B998A2074689", hash_generated_field = "7175EE1ADBAA718DFE8844137332396F")

    private static final byte TOKEN_DIGIT = 16;
}

