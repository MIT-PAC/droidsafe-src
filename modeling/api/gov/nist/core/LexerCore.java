package gov.nist.core;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;
import java.util.Hashtable;

public class LexerCore extends StringTokenizer {

    /**
     * JvB: utility function added to validate tokens
     *
     * @see RFC3261 section 25.1:
     * token       =  1*(alphanum / "-" / "." / "!" / "%" / "*"
                     / "_" / "+" / "`" / "'" / "~" )

     * @param c - character to check
     * @return true iff character c is a valid token character as per RFC3261
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.965 -0500", hash_original_method = "4A4AB033B083C67B221AE13033277F17", hash_generated_method = "544A6B6EDA131E6A46BEE222A46A2B42")
    
public static final boolean isTokenChar( char c ) {
        if ( isAlphaDigit(c) ) return true;
        else switch (c)
        {
            case '-':
            case '.':
            case '!':
            case '%':
            case '*':
            case '_':
            case '+':
            case '`':
            case '\'':
            case '~':
                return true;
            default:
                return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:51.003 -0500", hash_original_method = "14A8D24BF03E3A4324F76756B52A282E", hash_generated_method = "9DEB958354F7A4B0B42AAF3D86E19E59")
    
public static String charAsString(char ch) {
        return String.valueOf(ch);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.810 -0500", hash_original_field = "2D583086D140CC063786953829C11FEE", hash_generated_field = "42FCC650A8DCEEE6AA1C2C58CC59524F")

    public static final int START = 2048;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.813 -0500", hash_original_field = "FB822DB1035230A730329C836FF13717", hash_generated_field = "4D6E959ADFA99AA4AA54B17A19891BBC")

    public static final int END = START + 2048;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.815 -0500", hash_original_field = "CD0D544FD4D57239F9753DCF73DAE065", hash_generated_field = "F67FCD2E62BF19D4DCBD11EB4FDC57CB")

    public static final int ID = END - 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.818 -0500", hash_original_field = "FCA98E806FFD608B71AC3287A6A38ED9", hash_generated_field = "9F05BDB481A04F2AAF5084878ADCF1FB")

    public static final int SAFE = END - 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.820 -0500", hash_original_field = "3B18EE4E76331382DE571BF1FD651CCF", hash_generated_field = "C17723D563FB32573D21F1791836F81A")

    public static final int WHITESPACE = END + 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.822 -0500", hash_original_field = "757347E75A64AD6D296494A926F4689E", hash_generated_field = "F28563C191C95FA92F1C4D0946BEBD84")

    public static final int DIGIT = END + 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.825 -0500", hash_original_field = "38C7B00EA2DFCA251CE26DB088687F54", hash_generated_field = "FCC8A042E3C973A365D943D306241AEF")

    public static final int ALPHA = END + 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.828 -0500", hash_original_field = "D32F9DBA7D81295BA50FAB8B3DBB7472", hash_generated_field = "E2E5343A09E9903C4D1A5A78F45ECA36")

    public static final int BACKSLASH = (int) '\\';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.831 -0500", hash_original_field = "AA5CABF62F4AC2A09779CC2B92F340C5", hash_generated_field = "008AC3E66AF32B5DBAFEB8ED408692BF")

    public static final int QUOTE = (int) '\'';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.833 -0500", hash_original_field = "92D3F7FA2B7C35BB42B971A5C83FFD5C", hash_generated_field = "0E63DD0BBE26268078E2DBF6C03CF049")

    public static final int AT = (int) '@';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.836 -0500", hash_original_field = "25C5F1ABEB017B399E4C9B1BA9FB9A36", hash_generated_field = "65A0FF9BC1214F9DC13DF3F98E49A358")

    public static final int SP = (int) ' ';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.838 -0500", hash_original_field = "33052B41C777A362A3D5A2EA38C73E8F", hash_generated_field = "A5CE1F2E561873DF97B24EDC61B6E021")

    public static final int HT = (int) '\t';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.841 -0500", hash_original_field = "C1FFADBA1A6945C77B7F061BEABDC0D1", hash_generated_field = "D7E6C3010C38900FC22DEBEF5CCC0BAF")

    public static final int COLON = (int) ':';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.843 -0500", hash_original_field = "304FCAAEA398FB0E6B110A93895C8405", hash_generated_field = "5577E36B751431D0650DCAB0614F5191")

    public static final int STAR = (int) '*';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.846 -0500", hash_original_field = "89B75325ECEEA31C7373845B2EA4BF59", hash_generated_field = "231FAE26C0C2B9FBC64DCFC753F1AC1B")

    public static final int DOLLAR = (int) '$';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.848 -0500", hash_original_field = "E74BD13C57C050A60406BAC02C2F37E7", hash_generated_field = "C62A528B6CDE9BA9CC913A79EC1A48BA")

    public static final int PLUS = (int) '+';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.852 -0500", hash_original_field = "FDBA118F1A53E31858AF3862575AA490", hash_generated_field = "4B930043CB5FB0157482480B46607D54")

    public static final int POUND = (int) '#';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.854 -0500", hash_original_field = "D4FCC083E22B1195EF96265B117C221C", hash_generated_field = "2A069EBC792AD71EBEEF3ED900453580")

    public static final int MINUS = (int) '-';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.857 -0500", hash_original_field = "8F001029C0FFF2614E3DAEC69A4E80C7", hash_generated_field = "698ADD1884DA7FE94B15F67D55E1FCDA")

    public static final int DOUBLEQUOTE = (int) '\"';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.860 -0500", hash_original_field = "3306E860D71919AED81175213B7C82B1", hash_generated_field = "292F6240589161556EC3428CE3789C07")

    public static final int TILDE = (int) '~';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.862 -0500", hash_original_field = "C1D3395DC3FF51B2C3F4A7F0F1B1D0A1", hash_generated_field = "4891B8D8EDA80AEA9A9D9833D5CE8769")

    public static final int BACK_QUOTE = (int) '`';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.864 -0500", hash_original_field = "3C2A8CA73C3A0EEFE95B8164887B9D3E", hash_generated_field = "6F22E0D1261A966DAEE18D177D7331F8")

    public static final int NULL = (int) '\0';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.867 -0500", hash_original_field = "1D7ACE7AFD5B919A99E7B3349D2EE225", hash_generated_field = "94F502FA8271B6C9F53A58E364FD31A0")

    public static final int EQUALS = (int) '=';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.869 -0500", hash_original_field = "26789344B05BF897DB25C93B842AB0F6", hash_generated_field = "3B7D3591D25BBAA77F0237477D39C2A8")

    public static final int SEMICOLON = (int) ';';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.872 -0500", hash_original_field = "FE4BBA9F07D8DEA979D78BE94E77FCF8", hash_generated_field = "4296368DF34F2F6EE376EFA924B0864B")

    public static final int SLASH = (int) '/';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.875 -0500", hash_original_field = "B488066025F968BF7AE27ED34F2922A1", hash_generated_field = "4C993680785AFCD43E6BC94D781CB373")

    public static final int L_SQUARE_BRACKET = (int) '[';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.877 -0500", hash_original_field = "40003C1731B144D32736BB017A51B790", hash_generated_field = "D6D5110A208194AF7B1EC486B63405DD")

    public static final int R_SQUARE_BRACKET = (int) ']';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.880 -0500", hash_original_field = "F769ED6EDAF6B8C2AFDA68FF5E1193DA", hash_generated_field = "A1E2A4AF20AABBE655EBFE36649C9595")

    public static final int R_CURLY = (int) '}';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.883 -0500", hash_original_field = "EE85AA58B4D002B50F3317135CB6E2B5", hash_generated_field = "6D77C6B80D66382592FDE34848F4C1FF")

    public static final int L_CURLY = (int) '{';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.885 -0500", hash_original_field = "D8239031961C1BB0F430271557819BC7", hash_generated_field = "763AD424A9EB120D14D6402087824468")

    public static final int HAT = (int) '^';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.888 -0500", hash_original_field = "7829FA29A05E60B8CAF711A993B2B773", hash_generated_field = "E4EEAF80F73B9E93D9CF6DEED4993BAE")

    public static final int BAR = (int) '|';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.890 -0500", hash_original_field = "1B597B86E2306C4269B1E10514FBCC1D", hash_generated_field = "09D2F8A6FE8AA7284E3E06A6C6C606EF")

    public static final int DOT = (int) '.';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.893 -0500", hash_original_field = "2F9B10BC3C855777E17089BF8F5A09BD", hash_generated_field = "45631F45802F5CBBB666B8BF83AB239B")

    public static final int EXCLAMATION = (int) '!';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.896 -0500", hash_original_field = "EEBAE820B71E32E82C9388B314E1A603", hash_generated_field = "F2FC2CAE354F85A66D31202E3AFC6343")

    public static final int LPAREN = (int) '(';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.899 -0500", hash_original_field = "265214A2A06AA81AEDEA01143A30923D", hash_generated_field = "E7AE3F587B3D4886E7DB9CFDDC53E2EA")

    public static final int RPAREN = (int) ')';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.901 -0500", hash_original_field = "C9F605B56817A9B440B0183EEF368483", hash_generated_field = "65D1F17C93E1F09812E4B69F43BE3B23")

    public static final int GREATER_THAN = (int) '>';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.904 -0500", hash_original_field = "EC23EB0B0D028CAE82B3336B12FF6C6A", hash_generated_field = "9205B2F85DE81720CBD2E7916081200F")

    public static final int LESS_THAN = (int) '<';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.906 -0500", hash_original_field = "FD3901DF77F928BB03285D843AC59A14", hash_generated_field = "36822253DE16D15C507CA4AD98B0D4AF")

    public static final int PERCENT = (int) '%';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.909 -0500", hash_original_field = "61DE3075A086A0A9F5DB8AF66DDE74B3", hash_generated_field = "C59D2238695EF14FB400F2DEBCEFB200")

    public static final int QUESTION = (int) '?';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.911 -0500", hash_original_field = "408BBB574433C9B7EE52AB43837374CD", hash_generated_field = "95AD51D349B8D0A02402803B1A69149C")

    public static final int AND = (int) '&';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.913 -0500", hash_original_field = "B3696767D8DD64C2AAD49377FC5304FD", hash_generated_field = "D9C0E3D2A8514389A067E4ACE778BC68")

    public static final int UNDERSCORE = (int) '_';
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.917 -0500", hash_original_field = "4E15CDF1BE145AF026EDAE66A7BF1576", hash_generated_field = "9A4439847AD02C063A85CA312E27B5B7")

    protected static  Hashtable globalSymbolTable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.919 -0500", hash_original_field = "0BECC17D64220268F84BA0A9601234A5", hash_generated_field = "94CD673D75FBEC685CA66860DE29769A")

    protected static  Hashtable lexerTables;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.979 -0500", hash_original_field = "64B71AE2BB908DE3B11B125428D25665", hash_generated_field = "98DA5713B8CB9625620DDB4ECDE10877")

    static final char ALPHA_VALID_CHARS = Character.MAX_VALUE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.981 -0500", hash_original_field = "8F8DB3D35C099F222E2F7337A7CCB09A", hash_generated_field = "A91B938778BCC54CB153A8DC19B91D12")

    static final char DIGIT_VALID_CHARS = Character.MAX_VALUE - 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.983 -0500", hash_original_field = "59B5ED39193D8F36B56BCE2F128EB2FB", hash_generated_field = "1A8926B139F3055FA0C68CABB3D5FDC9")

    static final char ALPHADIGIT_VALID_CHARS = Character.MAX_VALUE - 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.921 -0500", hash_original_field = "601BA088DA2A1C7AC9F386843E2FA549", hash_generated_field = "73DC8498A7AED0DB7B89805A8124EB6C")

    protected Hashtable currentLexer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.924 -0500", hash_original_field = "031E5A9A4053C22D1602A4F7D08592F1", hash_generated_field = "CBCC5F8F420E7C818FCF47E1FDA6C4BE")

    protected String currentLexerName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.926 -0500", hash_original_field = "8EF9E4A180FEF63368754DEFCF443DAF", hash_generated_field = "A0375D48FDB0A7A220B130B3BD520E09")

    protected Token currentMatch;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.940 -0500", hash_original_method = "F81A1A23CDDF7D21ADD1D8559F70EDF8", hash_generated_method = "6E14F6FB40CAAC0B0BCB06CF8D99CF22")
    
protected LexerCore() {
        this.currentLexer = new Hashtable();
        this.currentLexerName = "charLexer";
    }

    /** Initialize the lexer with a buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.943 -0500", hash_original_method = "E63C8DBFE6FAFFBE522AAC8B0CA2CC77", hash_generated_method = "661E5E37D12B645292144BB68339A415")
    
public LexerCore(String lexerName, String buffer) {
        super(buffer);
        this.currentLexerName = lexerName;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.929 -0500", hash_original_method = "AD96F60DA08AE9E896CB042D3CC5B1A1", hash_generated_method = "C3B1C2FA4A45B4AC89017279AA382D37")
    
protected void addKeyword(String name, int value) {
        // System.out.println("addKeyword " + name + " value = " + value);
        // new Exception().printStackTrace();
        Integer val = Integer.valueOf(value);
        currentLexer.put(name, val);
        if (!globalSymbolTable.containsKey(val))
            globalSymbolTable.put(val, name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.932 -0500", hash_original_method = "3D857462C470E4A1F5CD1262364F803E", hash_generated_method = "75F1B026E89AD7429817AD7FC26B2037")
    
public String lookupToken(int value) {
        if (value > START) {
            return (String) globalSymbolTable.get(Integer.valueOf(value));
        } else {
            Character ch = Character.valueOf((char) value);
            return ch.toString();
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.936 -0500", hash_original_method = "A9968CF51D1D67FF8D3FB6DE23BFC8AA", hash_generated_method = "0CD7688F819297B2CE7E4487B70146ED")
    
protected Hashtable addLexer(String lexerName) {
        currentLexer = (Hashtable) lexerTables.get(lexerName);
        if (currentLexer == null) {
            currentLexer = new Hashtable();
            lexerTables.put(lexerName, currentLexer);
        }
        return currentLexer;
    }

    //public abstract void selectLexer(String lexerName);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.938 -0500", hash_original_method = "D20C9FA92CD9B4968A44EC6CC8CD338F", hash_generated_method = "44F572784B918B199803C1A54FDA6D53")
    
public void selectLexer(String lexerName) {
        this.currentLexerName = lexerName;
    }

    /** Peek the next id but dont move the buffer pointer forward.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.946 -0500", hash_original_method = "490BF814B9BDCA5834E18A73438F6256", hash_generated_method = "B6FD469B2019DB97B9FE9BF5DC2F2868")
    
public String peekNextId() {
        int oldPtr = ptr;
        String retval = ttoken();
        savedPtr = ptr;
        ptr = oldPtr;
        return retval;
    }

    /** Get the next id.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.948 -0500", hash_original_method = "7F6D0FFBB3DD0E896E18057F7DC876B2", hash_generated_method = "4EEC32D944698BE420AF830EEFAD8040")
    
public String getNextId() {
        return ttoken();
    }

    // call this after you call match
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.951 -0500", hash_original_method = "DD3F66B83694243DF059D5B5621ADB54", hash_generated_method = "AC958D60942083B4834D606B96511C69")
    
public Token getNextToken() {
        return this.currentMatch;

    }

    /** Look ahead for one token.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.953 -0500", hash_original_method = "7245F245408FA6FEC683585F2431BE34", hash_generated_method = "A9BC3AD2BEFC181DC641ACC40C3AFB3B")
    
public Token peekNextToken() throws ParseException {
        return (Token) peekNextToken(1)[0];
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.956 -0500", hash_original_method = "E053A5C6A0917BEE124D59DA4B3EBFD6", hash_generated_method = "992E1330C1CE9A9FF2C91E4A293DC434")
    
public Token[] peekNextToken(int ntokens) throws ParseException {
        int old = ptr;
        Token[] retval = new Token[ntokens];
        for (int i = 0; i < ntokens; i++) {
            Token tok = new Token();
            if (startsId()) {
                String id = ttoken();
                tok.tokenValue = id;
                String idUppercase = id.toUpperCase();
                if (currentLexer.containsKey(idUppercase)) {
                    Integer type = (Integer) currentLexer.get(idUppercase);
                    tok.tokenType = type.intValue();
                } else
                    tok.tokenType = ID;
            } else {
                char nextChar = getNextChar();
                tok.tokenValue = String.valueOf(nextChar);
                if (isAlpha(nextChar)) {
                    tok.tokenType = ALPHA;
                } else if (isDigit(nextChar)) {
                    tok.tokenType = DIGIT;
                } else
                    tok.tokenType = (int) nextChar;
            }
            retval[i] = tok;
        }
        savedPtr = ptr;
        ptr = old;
        return retval;
    }

    /** Match the given token or throw an exception if no such token
     * can be matched.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.959 -0500", hash_original_method = "EF527252962F704D7452C6B99500917D", hash_generated_method = "BE7655C07E1329CD326693E64EB0674A")
    
public Token match(int tok) throws ParseException {
        if (Debug.parserDebug) {
            Debug.println("match " + tok);
        }
        if (tok > START && tok < END) {
            if (tok == ID) {
                // Generic ID sought.
                if (!startsId())
                    throw new ParseException(buffer + "\nID expected", ptr);
                String id = getNextId();
                this.currentMatch = new Token();
                this.currentMatch.tokenValue = id;
                this.currentMatch.tokenType = ID;
            } else if (tok == SAFE) {
                if (!startsSafeToken())
                    throw new ParseException(buffer + "\nID expected", ptr);
                String id = ttokenSafe();
                this.currentMatch = new Token();
                this.currentMatch.tokenValue = id;
                this.currentMatch.tokenType = SAFE;
            } else {
                String nexttok = getNextId();
                Integer cur = (Integer) currentLexer.get(nexttok.toUpperCase());

                if (cur == null || cur.intValue() != tok)
                    throw new ParseException(
                        buffer + "\nUnexpected Token : " + nexttok,
                        ptr);
                this.currentMatch = new Token();
                this.currentMatch.tokenValue = nexttok;
                this.currentMatch.tokenType = tok;
            }
        } else if (tok > END) {
            // Character classes.
            char next = lookAhead(0);
            if (tok == DIGIT) {
                if (!isDigit(next))
                    throw new ParseException(buffer + "\nExpecting DIGIT", ptr);
                this.currentMatch = new Token();
                this.currentMatch.tokenValue =
                    String.valueOf(next);
                this.currentMatch.tokenType = tok;
                consume(1);

            } else if (tok == ALPHA) {
                if (!isAlpha(next))
                    throw new ParseException(buffer + "\nExpecting ALPHA", ptr);
                this.currentMatch = new Token();
                this.currentMatch.tokenValue =
                    String.valueOf(next);
                this.currentMatch.tokenType = tok;
                consume(1);

            }

        } else {
            // This is a direct character spec.
            char ch = (char) tok;
            char next = lookAhead(0);
            if (next == ch) {
                /*this.currentMatch = new Token();
                this.currentMatch.tokenValue =
                    String.valueOf(ch);
                this.currentMatch.tokenType = tok;*/
                consume(1);
            } else
                throw new ParseException(
                    buffer + "\nExpecting  >>>" + ch + "<<< got >>>"
                    + next + "<<<", ptr);
        }
        return this.currentMatch;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.962 -0500", hash_original_method = "2A2C3BB94776A03619BA392D0DD9FA22", hash_generated_method = "9FE9873E1D35CB4BA391D981218E14FE")
    
public void SPorHT() {
        try {
            char c = lookAhead(0);
            while (c == ' ' || c == '\t') {
                consume(1);
                c = lookAhead(0);
            }
        } catch (ParseException ex) {
            // Ignore
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.968 -0500", hash_original_method = "F58976B32EA8A9502EE0AC2AF2B6A7AB", hash_generated_method = "3059BECAC29D045BDFC2F07B221013DA")
    
public boolean startsId() {
        try {
            char nextChar = lookAhead(0);
            return isTokenChar(nextChar);
        } catch (ParseException ex) {
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.971 -0500", hash_original_method = "F94CBEE0A9F2E4712D2EBE65CDCE3A2F", hash_generated_method = "102D35A932137B1837845E56CC7E12EF")
    
public boolean startsSafeToken() {
        try {
            char nextChar = lookAhead(0);
            if (isAlphaDigit(nextChar)) {
                return true;
            }
            else {
                switch (nextChar) {
                    case '_':
                    case '+':
                    case '-':
                    case '!':
                    case '`':
                    case '\'':
                    case '.':
                    case '/':
                    case '}':
                    case '{':
                    case ']':
                    case '[':
                    case '^':
                    case '|':
                    case '~':
                    case '%': // bug fix by Bruno Konik, JvB copied here
                    case '#':
                    case '@':
                    case '$':
                    case ':':
                    case ';':
                    case '?':
                    case '\"':
                    case '*':
                    case '=': // Issue 155 on java.net
                        return true;
                    default:
                        return false;
                }
            }
        } catch (ParseException ex) {
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.973 -0500", hash_original_method = "263A0804A198D7BD9F45ED20C20E2FC4", hash_generated_method = "8C54C25AB95B5203D09BFC1F6EFDF2FF")
    
public String ttoken() {
        int startIdx = ptr;
        try {
            while (hasMoreChars()) {
                char nextChar = lookAhead(0);
                if ( isTokenChar(nextChar) ) {
                    consume(1);
                } else {
                    break;
                }
            }
            return buffer.substring(startIdx, ptr);
        } catch (ParseException ex) {
            return null;
        }
    }

    /* JvB: unreferenced
    public String ttokenAllowSpace() {
        int startIdx = ptr;
        try {
            while (hasMoreChars()) {
                char nextChar = lookAhead(0);
                if (isAlphaDigit(nextChar)) {
                    consume(1);
                }
                else {
                    boolean isValidChar = false;
                    switch (nextChar) {
                        case '_':
                        case '+':
                        case '-':
                        case '!':
                        case '`':
                        case '\'':
                        case '~':
                        case '%': // bug fix by Bruno Konik, JvB copied here
                        case '.':
                        case ' ':
                        case '\t':
                        case '*':
                            isValidChar = true;
                    }
                    if (isValidChar) {
                        consume(1);
                    }
                    else {
                        break;
                    }
                }

            }
            return buffer.substring(startIdx, ptr);
        } catch (ParseException ex) {
            return null;
        }
    }*/

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.976 -0500", hash_original_method = "888B4B5B30F6453059C386257A5A6804", hash_generated_method = "A8B3BE9ECDABEAF6BC7AB231F439D508")
    
public String ttokenSafe() {
        int startIdx = ptr;
        try {
            while (hasMoreChars()) {
                char nextChar = lookAhead(0);
                if (isAlphaDigit(nextChar)) {
                    consume(1);
                }
                else {
                    boolean isValidChar = false;
                    switch (nextChar) {
                        case '_':
                        case '+':
                        case '-':
                        case '!':
                        case '`':
                        case '\'':
                        case '.':
                        case '/':
                        case '}':
                        case '{':
                        case ']':
                        case '[':
                        case '^':
                        case '|':
                        case '~':
                        case '%': // bug fix by Bruno Konik, JvB copied here
                        case '#':
                        case '@':
                        case '$':
                        case ':':
                        case ';':
                        case '?':
                        case '\"':
                        case '*':
                            isValidChar = true;
                    }
                    if (isValidChar) {
                        consume(1);
                    }
                    else {
                        break;
                    }
                }
            }
            return buffer.substring(startIdx, ptr);
        } catch (ParseException ex) {
            return null;
        }
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.986 -0500", hash_original_method = "8CC0A9D05C89C60DBFAAF7C7ED88483F", hash_generated_method = "AF59C8FA7B7EF5974A245AF39C7B6EBD")
    
public void consumeValidChars(char[] validChars) {
        int validCharsLength = validChars.length;
        try {
            while (hasMoreChars()) {
                char nextChar = lookAhead(0);
                boolean isValid = false;
                for (int i = 0; i < validCharsLength; i++) {
                    char validChar = validChars[i];
                    switch(validChar) {
                        case ALPHA_VALID_CHARS:
                            isValid = isAlpha(nextChar);
                            break;
                        case DIGIT_VALID_CHARS:
                            isValid = isDigit(nextChar);
                            break;
                        case ALPHADIGIT_VALID_CHARS:
                            isValid = isAlphaDigit(nextChar);
                            break;
                        default:
                            isValid = nextChar == validChar;
                    }
                    if (isValid) {
                        break;
                    }
                }
                if (isValid) {
                    consume(1);
                }
                else {
                    break;
                }
            }
        } catch (ParseException ex) {

        }
    }

    /** Parse a comment string cursor is at a ". Leave cursor at closing "
    *@return the substring containing the quoted string excluding the
    * closing quote.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.989 -0500", hash_original_method = "17D25E29F0B0C1524A5E10AF751238A3", hash_generated_method = "966D369F7F49AF139100089A3030EDDB")
    
public String quotedString() throws ParseException {
        int startIdx = ptr + 1;
        if (lookAhead(0) != '\"')
            return null;
        consume(1);
        while (true) {
            char next = getNextChar();
            if (next == '\"') {
                // Got to the terminating quote.
                break;
            } else if (next == '\0') {
                throw new ParseException(
                    this.buffer + " :unexpected EOL",
                    this.ptr);
            } else if (next == '\\') {
                consume(1);
            }
        }
        return buffer.substring(startIdx, ptr - 1);
    }

    /** Parse a comment string cursor is at a "(". Leave cursor at )
    *@return the substring containing the comment excluding the
    * closing brace.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.992 -0500", hash_original_method = "0DEFD663D479F88E7A114CE703AF8835", hash_generated_method = "468767B16106E3DDBED1803029F31BE7")
    
public String comment() throws ParseException {
        StringBuffer retval = new StringBuffer();
        if (lookAhead(0) != '(')
            return null;
        consume(1);
        while (true) {
            char next = getNextChar();
            if (next == ')') {
                break;
            } else if (next == '\0') {
                throw new ParseException(
                    this.buffer + " :unexpected EOL",
                    this.ptr);
            } else if (next == '\\') {
                retval.append(next);
                next = getNextChar();
                if (next == '\0')
                    throw new ParseException(
                        this.buffer + " : unexpected EOL",
                        this.ptr);
                retval.append(next);
            } else {
                retval.append(next);
            }
        }
        return retval.toString();
    }

    /** Return a substring containing no semicolons.
    *@return a substring containing no semicolons.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.995 -0500", hash_original_method = "86F26DE68AB39CE9DEE1E486630D72BD", hash_generated_method = "1D832A1960BD04E82C364D5311BD5FAE")
    
public String byteStringNoSemicolon() {
        StringBuffer retval = new StringBuffer();
        try {
            while (true) {
                char next = lookAhead(0);
                // bug fix from Ben Evans.
                if (next == '\0' || next == '\n' || next == ';' || next == ',' ) {
                    break;
                } else {
                    consume(1);
                    retval.append(next);
                }
            }
        } catch (ParseException ex) {
            return retval.toString();
        }
        return retval.toString();
    }

    /**
     * Scan until you see a slash or an EOL.
     *
     * @return substring containing no slash.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:50.998 -0500", hash_original_method = "B2A0AA5C97E9078316CA6FEBE65DB0C3", hash_generated_method = "FE5A84F56F259ACFA9BFA9B919E878D5")
    
public String byteStringNoSlash() {
        StringBuffer retval = new StringBuffer();
        try {
            while (true) {
                char next = lookAhead(0);
                // bug fix from Ben Evans.
                if (next == '\0' || next == '\n' || next == '/'  ) {
                    break;
                } else {
                    consume(1);
                    retval.append(next);
                }
            }
        } catch (ParseException ex) {
            return retval.toString();
        }
        return retval.toString();
    }

    /** Return a substring containing no commas
    *@return a substring containing no commas.
    */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:51.001 -0500", hash_original_method = "03994A77D1324F910A7EC2E8D4C779CB", hash_generated_method = "90ECE281F75BAE93DFEF4C3AA4D51FDF")
    
public String byteStringNoComma() {
        StringBuffer retval = new StringBuffer();
        try {
            while (true) {
                char next = lookAhead(0);
                if (next == '\n' || next == ',') {
                    break;
                } else {
                    consume(1);
                    retval.append(next);
                }
            }
        } catch (ParseException ex) {
        }
        return retval.toString();
    }

    /** Lookahead in the inputBuffer for n chars and return as a string.
     * Do not consume the input.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:51.006 -0500", hash_original_method = "5A32401256C252E56BBB94CC59C2BA04", hash_generated_method = "7F4E00EEF1E928EE9AF3470BAD683697")
    
public String charAsString(int nchars) {
        return buffer.substring(ptr, ptr + nchars);
    }

    /** Get and consume the next number.
     *@return a substring corresponding to a number
     *(i.e. sequence of digits).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:51.008 -0500", hash_original_method = "322A7AA8BD0B180616D94A352B3FE7FA", hash_generated_method = "834B87B7CF6881F99D4FF70C311C1393")
    
public String number() throws ParseException {

        int startIdx = ptr;
        try {
            if (!isDigit(lookAhead(0))) {
                throw new ParseException(
                    buffer + ": Unexpected token at " + lookAhead(0),
                    ptr);
            }
            consume(1);
            while (true) {
                char next = lookAhead(0);
                if (isDigit(next)) {
                    consume(1);
                } else
                    break;
            }
            return buffer.substring(startIdx, ptr);
        } catch (ParseException ex) {
            return buffer.substring(startIdx, ptr);
        }
    }

    /** Mark the position for backtracking.
     *@return the current location of the pointer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:51.011 -0500", hash_original_method = "8137BED0F2B5219001CD3D42EAB84127", hash_generated_method = "2CC9785B97D070C109318210A08BBBCC")
    
public int markInputPosition() {
        return ptr;
    }

    /** Rewind the input ptr to the marked position.
     *@param position - the position to rewind the parser to.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:51.013 -0500", hash_original_method = "4FFD881D960C22E5DF32EAF983DA52C6", hash_generated_method = "27E9EE37082F3A8B1EF43BCF171B0602")
    
public void rewindInputPosition(int position) {
        this.ptr = position;
    }

    /** Get the rest of the String
     * @return rest of the buffer.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:51.015 -0500", hash_original_method = "2FDB8C189AB11331619907255B1EC94B", hash_generated_method = "0CC817560D3FA6FCA66A4B885D665582")
    
public String getRest() {
        if (ptr >= buffer.length())
            return null;
        else
            return buffer.substring(ptr);
    }

    /** Get the sub-String until the character is encountered
     * @param c the character to match
     * @return the substring that matches.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:51.018 -0500", hash_original_method = "720A9C8698AD8EBEF63DE1F048944846", hash_generated_method = "280573BDFBE88FEAE20614843D1D4CAB")
    
public String getString(char c) throws ParseException {
        StringBuffer retval = new StringBuffer();
        while (true) {
            char next = lookAhead(0);
            //System.out.println(" next = [" + next + ']' + "ptr = " + ptr);
            //System.out.println(next == '\0');

            if (next == '\0') {
                throw new ParseException(
                    this.buffer + "unexpected EOL",
                    this.ptr);
            } else if (next == c) {
                consume(1);
                break;
            } else if (next == '\\') {
                consume(1);
                char nextchar = lookAhead(0);
                if (nextchar == '\0') {
                    throw new ParseException(
                        this.buffer + "unexpected EOL",
                        this.ptr);
                } else {
                    consume(1);
                    retval.append(nextchar);
                }
            } else {
                consume(1);
                retval.append(next);
            }
        }
        return retval.toString();
    }
    static {
        globalSymbolTable = new Hashtable();
        lexerTables = new Hashtable();
    }

    /** Get the read pointer.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:51.021 -0500", hash_original_method = "976AE9BCD44A20D9CC809F6C91A5525F", hash_generated_method = "82AF28238265DE1776FC37087FB0B53F")
    
public int getPtr() {
        return this.ptr;
    }

    /** Get the buffer.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:51.023 -0500", hash_original_method = "E132864DD50CA73C29855C29E535CA90", hash_generated_method = "6E3441502EEC01C275EF7EB724A104D2")
    
public String getBuffer() {
        return this.buffer;
    }

    /** Create a parse exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:51.025 -0500", hash_original_method = "3D7442B3A5CE831DBB9C36AFA9551D12", hash_generated_method = "446CA08DBEC578D6A1C8A4F194264E1A")
    
public ParseException createParseException() {
        return new ParseException(this.buffer, this.ptr);
    }
}

