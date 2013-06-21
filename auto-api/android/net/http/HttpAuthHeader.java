package android.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class HttpAuthHeader {
    private int mScheme;
    private boolean mStale;
    private String mRealm;
    private String mNonce;
    private String mOpaque;
    private String mQop;
    private String mAlgorithm;
    private boolean mIsProxy;
    private String mUsername;
    private String mPassword;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.809 -0400", hash_original_method = "1FD1D3A9087ED95F87943CC7E812BAFE", hash_generated_method = "618568C314A583A82716249D5AE42919")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HttpAuthHeader(String header) {
        dsTaint.addTaint(header);
        {
            parseHeader(header);
        } //End block
        // ---------- Original Method ----------
        //if (header != null) {
            //parseHeader(header);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.809 -0400", hash_original_method = "E3B47ECF178F55BDD1E428FED9536544", hash_generated_method = "A4BE948DF237193DBB34A4E83D229845")
    @DSModeled(DSC.SAFE)
    public boolean isProxy() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsProxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.810 -0400", hash_original_method = "F484596B8E11A4861D504E7FDD37DA10", hash_generated_method = "DD3E3DD04D17DDB30604953E8A9252B1")
    @DSModeled(DSC.SAFE)
    public void setProxy() {
        mIsProxy = true;
        // ---------- Original Method ----------
        //mIsProxy = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.810 -0400", hash_original_method = "DC420B5834A563247800515BC4094ADD", hash_generated_method = "E13B76311AC29180B55917CFE610D0B7")
    @DSModeled(DSC.SAFE)
    public String getUsername() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mUsername;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.810 -0400", hash_original_method = "0E33D9E279BEDC5DAB4D3AD6DE953552", hash_generated_method = "3D0B617F1D37E79F0BB2E8E6FBFE9683")
    @DSModeled(DSC.SAFE)
    public void setUsername(String username) {
        dsTaint.addTaint(username);
        // ---------- Original Method ----------
        //mUsername = username;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.810 -0400", hash_original_method = "352B20CA8286B4BCFAD735A80A162186", hash_generated_method = "092F0197408C571D7B3FB565A76F602F")
    @DSModeled(DSC.SAFE)
    public String getPassword() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPassword;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.810 -0400", hash_original_method = "5BECAD2A732AB83E1664BF3A6C903529", hash_generated_method = "652999DF8F5C9D6B3DFECC83E9EA3AC5")
    @DSModeled(DSC.SAFE)
    public void setPassword(String password) {
        dsTaint.addTaint(password);
        // ---------- Original Method ----------
        //mPassword = password;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.811 -0400", hash_original_method = "C2242C4025DD65A560A889E41F117AB7", hash_generated_method = "D92F573D7844D01376EE9D78941EA2E1")
    @DSModeled(DSC.SAFE)
    public boolean isBasic() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mScheme == BASIC;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.811 -0400", hash_original_method = "C6AFC1E0D0B142E9C4DE27602A4BC054", hash_generated_method = "B3BE644FABF44F336655089FA8C31806")
    @DSModeled(DSC.SAFE)
    public boolean isDigest() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mScheme == DIGEST;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.811 -0400", hash_original_method = "29E6CF58C110B66305B7C71C00259314", hash_generated_method = "40995A4B4A22B1E414367E2E293D24E5")
    @DSModeled(DSC.SAFE)
    public int getScheme() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mScheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.811 -0400", hash_original_method = "3E3CDB0E616B9E56522984F92CB979FB", hash_generated_method = "0494C3CED35775E455DC4FA7CF05FFE1")
    @DSModeled(DSC.SAFE)
    public boolean getStale() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mStale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.812 -0400", hash_original_method = "E61C0128BAAE9B474452BFCEF0497CDD", hash_generated_method = "67490F3383108F82BC6D1C225283A836")
    @DSModeled(DSC.SAFE)
    public String getRealm() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mRealm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.812 -0400", hash_original_method = "B08110B485A4DA24A232A0CC9BEA47F4", hash_generated_method = "B3AC500D54D84F6DA35203492512426B")
    @DSModeled(DSC.SAFE)
    public String getNonce() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mNonce;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.812 -0400", hash_original_method = "40DED5E91C6F5AFDC12D505952D89AC1", hash_generated_method = "3470D10BD132C24327ED3D7B5789F5D4")
    @DSModeled(DSC.SAFE)
    public String getOpaque() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mOpaque;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.812 -0400", hash_original_method = "7F9926D57780B6A835584FF0B4884044", hash_generated_method = "2771F09980B57BD598373B379A1C4B32")
    @DSModeled(DSC.SAFE)
    public String getQop() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mQop;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.812 -0400", hash_original_method = "0FF39221585FBFD96D2157CC36F75665", hash_generated_method = "63C3625B37815F8900B61E12D0C4E745")
    @DSModeled(DSC.SAFE)
    public String getAlgorithm() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mAlgorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.813 -0400", hash_original_method = "1B2B63EC3C55FEF6363AE03FA64546E8", hash_generated_method = "8BC115908874D3131A935EE60DD73746")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isSupportedScheme() {
        {
            {
                {
                    boolean var74F77E97056CDC845905F625FD4FAE6E_741039485 = (mAlgorithm.equals("md5") &&
                        (mQop == null || mQop.equals("auth")));
                } //End block
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mRealm != null) {
            //if (mScheme == BASIC) {
                //return true;
            //} else {
                //if (mScheme == DIGEST) {
                    //return
                        //mAlgorithm.equals("md5") &&
                        //(mQop == null || mQop.equals("auth"));
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.813 -0400", hash_original_method = "5A9C556851102A9977303C7DFC694964", hash_generated_method = "EC925F81977E8F96BAA9E9F7D6C7B1D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parseHeader(String header) {
        dsTaint.addTaint(header);
        {
            HttpLog.v("HttpAuthHeader.parseHeader(): header: " + header);
        } //End block
        {
            String parameters;
            parameters = parseScheme(header);
            {
                {
                    parseParameters(parameters);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (HttpLog.LOGV) {
            //HttpLog.v("HttpAuthHeader.parseHeader(): header: " + header);
        //}
        //if (header != null) {
            //String parameters = parseScheme(header);
            //if (parameters != null) {
                //if (mScheme != UNKNOWN) {
                    //parseParameters(parameters);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.814 -0400", hash_original_method = "BA2F0752C4374C507095962D429C28E1", hash_generated_method = "654D82530E2300952251C8B1620142CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String parseScheme(String header) {
        dsTaint.addTaint(header);
        {
            int i;
            i = header.indexOf(' ');
            {
                String scheme;
                scheme = header.substring(0, i).trim();
                {
                    boolean var3F3171EEAA43F511CD6F1C3DB88CF340_1527072661 = (scheme.equalsIgnoreCase(DIGEST_TOKEN));
                    {
                        mScheme = DIGEST;
                        mAlgorithm = "md5";
                    } //End block
                    {
                        {
                            boolean var16CB325F43B7CEA678BFF5231E7CFB88_1376997886 = (scheme.equalsIgnoreCase(BASIC_TOKEN));
                            {
                                mScheme = BASIC;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                String var92DBCB0EF530D725B9CFE84317772117_734181207 = (header.substring(i + 1));
            } //End block
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (header != null) {
            //int i = header.indexOf(' ');
            //if (i >= 0) {
                //String scheme = header.substring(0, i).trim();
                //if (scheme.equalsIgnoreCase(DIGEST_TOKEN)) {
                    //mScheme = DIGEST;
                    //mAlgorithm = "md5";
                //} else {
                    //if (scheme.equalsIgnoreCase(BASIC_TOKEN)) {
                        //mScheme = BASIC;
                    //}
                //}
                //return header.substring(i + 1);
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.814 -0400", hash_original_method = "2438A746B67FAB4E454DBFA828DCDAA3", hash_generated_method = "06018557A75397664F3ED809D968F388")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parseParameters(String parameters) {
        dsTaint.addTaint(parameters);
        {
            HttpLog.v("HttpAuthHeader.parseParameters():" +
                      " parameters: " + parameters);
        } //End block
        {
            int i;
            {
                i = parameters.indexOf(',');
                {
                    parseParameter(parameters);
                } //End block
                {
                    parseParameter(parameters.substring(0, i));
                    parameters = parameters.substring(i + 1);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (HttpLog.LOGV) {
            //HttpLog.v("HttpAuthHeader.parseParameters():" +
                      //" parameters: " + parameters);
        //}
        //if (parameters != null) {
            //int i;
            //do {
                //i = parameters.indexOf(',');
                //if (i < 0) {
                    //parseParameter(parameters);
                //} else {
                    //parseParameter(parameters.substring(0, i));
                    //parameters = parameters.substring(i + 1);
                //}
            //} while (i >= 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.814 -0400", hash_original_method = "5835A4879F5A1904E0EE047AD8542D67", hash_generated_method = "FCE9FD05748A6867CB19CD55FC7E9B6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parseParameter(String parameter) {
        dsTaint.addTaint(parameter);
        {
            int i;
            i = parameter.indexOf('=');
            {
                String token;
                token = parameter.substring(0, i).trim();
                String value;
                value = trimDoubleQuotesIfAny(parameter.substring(i + 1).trim());
                {
                    HttpLog.v("HttpAuthHeader.parseParameter():" +
                              " token: " + token +
                              " value: " + value);
                } //End block
                {
                    boolean varCEC1DBC4ECC877291DF9F6E9273F6D58_1014630930 = (token.equalsIgnoreCase(REALM_TOKEN));
                    {
                        mRealm = value;
                    } //End block
                    {
                        {
                            parseParameter(token, value);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (parameter != null) {
            //int i = parameter.indexOf('=');
            //if (i >= 0) {
                //String token = parameter.substring(0, i).trim();
                //String value =
                    //trimDoubleQuotesIfAny(parameter.substring(i + 1).trim());
                //if (HttpLog.LOGV) {
                    //HttpLog.v("HttpAuthHeader.parseParameter():" +
                              //" token: " + token +
                              //" value: " + value);
                //}
                //if (token.equalsIgnoreCase(REALM_TOKEN)) {
                    //mRealm = value;
                //} else {
                    //if (mScheme == DIGEST) {
                        //parseParameter(token, value);
                    //}
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.815 -0400", hash_original_method = "5C1E65D88B1AA36ECF03FA5CEB305F59", hash_generated_method = "6CBCE4D0D68F004A5049A0F9D0DCC5BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parseParameter(String token, String value) {
        dsTaint.addTaint(token);
        dsTaint.addTaint(value);
        {
            {
                boolean var15BA235533ABCE547E0797A898456E7C_534647085 = (token.equalsIgnoreCase(NONCE_TOKEN));
            } //End collapsed parenthetic
            {
                boolean varB44C547194E6F53089412783571B2447_238892703 = (token.equalsIgnoreCase(STALE_TOKEN));
                {
                    parseStale(value);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var60D1503A4A333BAFF728E7D81DC09722_1481371457 = (token.equalsIgnoreCase(OPAQUE_TOKEN));
            } //End collapsed parenthetic
            {
                boolean var22053CACB180CCB306D6CA26A6BD8471_1955098191 = (token.equalsIgnoreCase(QOP_TOKEN));
                {
                    mQop = value.toLowerCase();
                } //End block
            } //End collapsed parenthetic
            {
                boolean varD433831E97890454AF3D37C7538A019B_2107152136 = (token.equalsIgnoreCase(ALGORITHM_TOKEN));
                {
                    mAlgorithm = value.toLowerCase();
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (token != null && value != null) {
            //if (token.equalsIgnoreCase(NONCE_TOKEN)) {
                //mNonce = value;
                //return;
            //}
            //if (token.equalsIgnoreCase(STALE_TOKEN)) {
                //parseStale(value);
                //return;
            //}
            //if (token.equalsIgnoreCase(OPAQUE_TOKEN)) {
                //mOpaque = value;
                //return;
            //}
            //if (token.equalsIgnoreCase(QOP_TOKEN)) {
                //mQop = value.toLowerCase();
                //return;
            //}
            //if (token.equalsIgnoreCase(ALGORITHM_TOKEN)) {
                //mAlgorithm = value.toLowerCase();
                //return;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.815 -0400", hash_original_method = "76A5C02B3DC683D5BF99D1052171A66C", hash_generated_method = "ED9B2D96541E7B4D7D790782909D55AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void parseStale(String value) {
        dsTaint.addTaint(value);
        {
            {
                boolean varF9F03D746A978112631EA8BA624DD149_1345759531 = (value.equalsIgnoreCase("true"));
                {
                    mStale = true;
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (value != null) {
            //if (value.equalsIgnoreCase("true")) {
                //mStale = true;
            //}
        //}
    }

    
        static private String trimDoubleQuotesIfAny(String value) {
        if (value != null) {
            int len = value.length();
            if (len > 2 &&
                value.charAt(0) == '\"' && value.charAt(len - 1) == '\"') {
                return value.substring(1, len - 1);
            }
        }
        return value;
    }

    
    public final static String BASIC_TOKEN = "Basic";
    public final static String DIGEST_TOKEN = "Digest";
    private final static String REALM_TOKEN = "realm";
    private final static String NONCE_TOKEN = "nonce";
    private final static String STALE_TOKEN = "stale";
    private final static String OPAQUE_TOKEN = "opaque";
    private final static String QOP_TOKEN = "qop";
    private final static String ALGORITHM_TOKEN = "algorithm";
    public static final int UNKNOWN = 0;
    public static final int BASIC = 1;
    public static final int DIGEST = 2;
}

