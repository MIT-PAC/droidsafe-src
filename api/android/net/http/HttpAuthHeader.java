package android.net.http;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class HttpAuthHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.138 -0400", hash_original_field = "51CA147512905722A26C3D219A583C78", hash_generated_field = "E6BEC331CEEA80F82B83B12255B86465")

    private int mScheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.139 -0400", hash_original_field = "152C8B4B0CCFD745368735E28EBFFA00", hash_generated_field = "F1E8A28CAB6C00E7A6B325F09B3FED3E")

    private boolean mStale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.139 -0400", hash_original_field = "D6C54CCF8E100F0747350A2B2CAC95FD", hash_generated_field = "5A777CBABA6AAC673CE6F5CC9C524A3C")

    private String mRealm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.139 -0400", hash_original_field = "63EA1DF1089A1758FF90C84142C0B973", hash_generated_field = "2EDF64CB0EA09AFD7AB8BCF896D658BC")

    private String mNonce;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.139 -0400", hash_original_field = "D57F412B2FBE34E5266AB85A3EC09555", hash_generated_field = "23C76B623A92D22536ACABC3A6FBC3E5")

    private String mOpaque;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.139 -0400", hash_original_field = "669AC09116EDE1210AE984751680B609", hash_generated_field = "39F05D5CDDC8244A3C6F7C97D22D161B")

    private String mQop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.139 -0400", hash_original_field = "F6E257862B80390CD13E2E0129E87947", hash_generated_field = "956ACE7C8B70403F27CAFAD0405E65A1")

    private String mAlgorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.139 -0400", hash_original_field = "DE5F3ADAFBA0C6CBA55780675ACC563E", hash_generated_field = "17B726A8F381AA988EF07CFC9F1FA12A")

    private boolean mIsProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.139 -0400", hash_original_field = "2FB3EB7CD104D0E14FE0487884A12591", hash_generated_field = "50564F75BBDED0F5A11BFE739FB8373A")

    private String mUsername;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.139 -0400", hash_original_field = "5C6B7EE711155A7472DA571800057A96", hash_generated_field = "44A1332F4D6AD461D600A43252892695")

    private String mPassword;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.140 -0400", hash_original_method = "1FD1D3A9087ED95F87943CC7E812BAFE", hash_generated_method = "F9B21B17678E528B8266CEE8970F31A3")
    public  HttpAuthHeader(String header) {
        addTaint(header.getTaint());
        if(header != null)        
        {
            parseHeader(header);
        } //End block
        // ---------- Original Method ----------
        //if (header != null) {
            //parseHeader(header);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.140 -0400", hash_original_method = "E3B47ECF178F55BDD1E428FED9536544", hash_generated_method = "2368901511138871305F7222014DB402")
    public boolean isProxy() {
        boolean varDE5F3ADAFBA0C6CBA55780675ACC563E_1967583916 = (mIsProxy);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1621337555 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1621337555;
        // ---------- Original Method ----------
        //return mIsProxy;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.141 -0400", hash_original_method = "F484596B8E11A4861D504E7FDD37DA10", hash_generated_method = "DD3E3DD04D17DDB30604953E8A9252B1")
    public void setProxy() {
        mIsProxy = true;
        // ---------- Original Method ----------
        //mIsProxy = true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.142 -0400", hash_original_method = "DC420B5834A563247800515BC4094ADD", hash_generated_method = "7B8ACE9D781F40A52BB21DDD6D431980")
    public String getUsername() {
String var283B9DD020EB2821600E129BC9B96F6C_226449233 =         mUsername;
        var283B9DD020EB2821600E129BC9B96F6C_226449233.addTaint(taint);
        return var283B9DD020EB2821600E129BC9B96F6C_226449233;
        // ---------- Original Method ----------
        //return mUsername;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.143 -0400", hash_original_method = "0E33D9E279BEDC5DAB4D3AD6DE953552", hash_generated_method = "3955AB7BA77A651158545815C33BA20C")
    public void setUsername(String username) {
        mUsername = username;
        // ---------- Original Method ----------
        //mUsername = username;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.143 -0400", hash_original_method = "352B20CA8286B4BCFAD735A80A162186", hash_generated_method = "1D20D711E92D2EE6E84E5667880D8683")
    public String getPassword() {
String var8A1D2454BCA4BED59D7FC1FA34A5817A_381614463 =         mPassword;
        var8A1D2454BCA4BED59D7FC1FA34A5817A_381614463.addTaint(taint);
        return var8A1D2454BCA4BED59D7FC1FA34A5817A_381614463;
        // ---------- Original Method ----------
        //return mPassword;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.144 -0400", hash_original_method = "5BECAD2A732AB83E1664BF3A6C903529", hash_generated_method = "0844A0EC752FFDF12DBAC561F066925A")
    public void setPassword(String password) {
        mPassword = password;
        // ---------- Original Method ----------
        //mPassword = password;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.144 -0400", hash_original_method = "C2242C4025DD65A560A889E41F117AB7", hash_generated_method = "3D527BECF5ECADC363423F85F9E75BB2")
    public boolean isBasic() {
        boolean var344CDD0B32278D6F0479629B38EE4FB6_535740672 = (mScheme == BASIC);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1575211256 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1575211256;
        // ---------- Original Method ----------
        //return mScheme == BASIC;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.144 -0400", hash_original_method = "C6AFC1E0D0B142E9C4DE27602A4BC054", hash_generated_method = "7763B278F637D261B27507670577C77C")
    public boolean isDigest() {
        boolean var7E1D6E88AE66122283033958CA4447A5_783386142 = (mScheme == DIGEST);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1013983570 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1013983570;
        // ---------- Original Method ----------
        //return mScheme == DIGEST;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.145 -0400", hash_original_method = "29E6CF58C110B66305B7C71C00259314", hash_generated_method = "2F0E82AD826FD1CAB1FCE5442494CA50")
    public int getScheme() {
        int var51CA147512905722A26C3D219A583C78_1025566873 = (mScheme);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1088941522 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1088941522;
        // ---------- Original Method ----------
        //return mScheme;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.145 -0400", hash_original_method = "3E3CDB0E616B9E56522984F92CB979FB", hash_generated_method = "5B4A0C30AE3584E947F1EB4A5D030C8F")
    public boolean getStale() {
        boolean var152C8B4B0CCFD745368735E28EBFFA00_1016807952 = (mStale);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_306635194 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_306635194;
        // ---------- Original Method ----------
        //return mStale;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.146 -0400", hash_original_method = "E61C0128BAAE9B474452BFCEF0497CDD", hash_generated_method = "BBDC421F51DCA8502F70A8392DDE9D55")
    public String getRealm() {
String var67C0344E1DC3B1D95F644291EF949DFF_285294141 =         mRealm;
        var67C0344E1DC3B1D95F644291EF949DFF_285294141.addTaint(taint);
        return var67C0344E1DC3B1D95F644291EF949DFF_285294141;
        // ---------- Original Method ----------
        //return mRealm;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.146 -0400", hash_original_method = "B08110B485A4DA24A232A0CC9BEA47F4", hash_generated_method = "D0AD870E72DC54FEE0C5276BCEB9A481")
    public String getNonce() {
String varEABCD339805209D3F9FB66B444AEC327_94881102 =         mNonce;
        varEABCD339805209D3F9FB66B444AEC327_94881102.addTaint(taint);
        return varEABCD339805209D3F9FB66B444AEC327_94881102;
        // ---------- Original Method ----------
        //return mNonce;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.146 -0400", hash_original_method = "40DED5E91C6F5AFDC12D505952D89AC1", hash_generated_method = "B88DC687EA12D354568A2AD202BD0E5C")
    public String getOpaque() {
String varD348638229B29F337841BA6DC87C999F_1776039889 =         mOpaque;
        varD348638229B29F337841BA6DC87C999F_1776039889.addTaint(taint);
        return varD348638229B29F337841BA6DC87C999F_1776039889;
        // ---------- Original Method ----------
        //return mOpaque;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.147 -0400", hash_original_method = "7F9926D57780B6A835584FF0B4884044", hash_generated_method = "6026833A0292DB038189DFBB6EE98985")
    public String getQop() {
String var5DFA3C48EEFA60EFF5B348166AD9F9F0_1351312875 =         mQop;
        var5DFA3C48EEFA60EFF5B348166AD9F9F0_1351312875.addTaint(taint);
        return var5DFA3C48EEFA60EFF5B348166AD9F9F0_1351312875;
        // ---------- Original Method ----------
        //return mQop;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.147 -0400", hash_original_method = "0FF39221585FBFD96D2157CC36F75665", hash_generated_method = "C3A1F5AECD83414EF9773F56577C1B68")
    public String getAlgorithm() {
String var38B0E4F53D6ADAB33FE69F422516B97C_634740316 =         mAlgorithm;
        var38B0E4F53D6ADAB33FE69F422516B97C_634740316.addTaint(taint);
        return var38B0E4F53D6ADAB33FE69F422516B97C_634740316;
        // ---------- Original Method ----------
        //return mAlgorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.147 -0400", hash_original_method = "1B2B63EC3C55FEF6363AE03FA64546E8", hash_generated_method = "4FA2D8EA26E6049BB13DEEAB23410050")
    public boolean isSupportedScheme() {
        if(mRealm != null)        
        {
            if(mScheme == BASIC)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_799433100 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_861715555 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_861715555;
            } //End block
            else
            {
                if(mScheme == DIGEST)                
                {
                    boolean var289E998ECE4DAD8183663A1273ADEB34_590999495 = (mAlgorithm.equals("md5") &&
                        (mQop == null || mQop.equals("auth")));
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1147466076 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1147466076;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_983961188 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1819251461 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1819251461;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.148 -0400", hash_original_method = "5A9C556851102A9977303C7DFC694964", hash_generated_method = "0291FE61F2970BB6EF1936E146E0E8D8")
    private void parseHeader(String header) {
        addTaint(header.getTaint());
        if(HttpLog.LOGV)        
        {
            HttpLog.v("HttpAuthHeader.parseHeader(): header: " + header);
        } //End block
        if(header != null)        
        {
            String parameters = parseScheme(header);
            if(parameters != null)            
            {
                if(mScheme != UNKNOWN)                
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.149 -0400", hash_original_method = "BA2F0752C4374C507095962D429C28E1", hash_generated_method = "DD05FA1781019FF9FECA31586ED31132")
    private String parseScheme(String header) {
        addTaint(header.getTaint());
        if(header != null)        
        {
            int i = header.indexOf(' ');
            if(i >= 0)            
            {
                String scheme = header.substring(0, i).trim();
                if(scheme.equalsIgnoreCase(DIGEST_TOKEN))                
                {
                    mScheme = DIGEST;
                    mAlgorithm = "md5";
                } //End block
                else
                {
                    if(scheme.equalsIgnoreCase(BASIC_TOKEN))                    
                    {
                        mScheme = BASIC;
                    } //End block
                } //End block
String var9CDFC82E8557C9B0092FA616C6CDAFB3_598514320 =                 header.substring(i + 1);
                var9CDFC82E8557C9B0092FA616C6CDAFB3_598514320.addTaint(taint);
                return var9CDFC82E8557C9B0092FA616C6CDAFB3_598514320;
            } //End block
        } //End block
String var540C13E9E156B687226421B24F2DF178_1420658291 =         null;
        var540C13E9E156B687226421B24F2DF178_1420658291.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1420658291;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.150 -0400", hash_original_method = "2438A746B67FAB4E454DBFA828DCDAA3", hash_generated_method = "58AB52FC335127CE70968A88D05CEBE0")
    private void parseParameters(String parameters) {
        addTaint(parameters.getTaint());
        if(HttpLog.LOGV)        
        {
            HttpLog.v("HttpAuthHeader.parseParameters():" +
                      " parameters: " + parameters);
        } //End block
        if(parameters != null)        
        {
            int i;
            do {
                {
                    i = parameters.indexOf(',');
                    if(i < 0)                    
                    {
                        parseParameter(parameters);
                    } //End block
                    else
                    {
                        parseParameter(parameters.substring(0, i));
                        parameters = parameters.substring(i + 1);
                    } //End block
                } //End block
} while (i >= 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.151 -0400", hash_original_method = "5835A4879F5A1904E0EE047AD8542D67", hash_generated_method = "66150F99C8572EB2A375D03CB931E264")
    private void parseParameter(String parameter) {
        addTaint(parameter.getTaint());
        if(parameter != null)        
        {
            int i = parameter.indexOf('=');
            if(i >= 0)            
            {
                String token = parameter.substring(0, i).trim();
                String value = trimDoubleQuotesIfAny(parameter.substring(i + 1).trim());
                if(HttpLog.LOGV)                
                {
                    HttpLog.v("HttpAuthHeader.parseParameter():" +
                              " token: " + token +
                              " value: " + value);
                } //End block
                if(token.equalsIgnoreCase(REALM_TOKEN))                
                {
                    mRealm = value;
                } //End block
                else
                {
                    if(mScheme == DIGEST)                    
                    {
                        parseParameter(token, value);
                    } //End block
                } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.151 -0400", hash_original_method = "5C1E65D88B1AA36ECF03FA5CEB305F59", hash_generated_method = "E357F9EB9EF85D7A8D42840BD28729A4")
    private void parseParameter(String token, String value) {
        addTaint(token.getTaint());
        if(token != null && value != null)        
        {
            if(token.equalsIgnoreCase(NONCE_TOKEN))            
            {
                mNonce = value;
                return;
            } //End block
            if(token.equalsIgnoreCase(STALE_TOKEN))            
            {
                parseStale(value);
                return;
            } //End block
            if(token.equalsIgnoreCase(OPAQUE_TOKEN))            
            {
                mOpaque = value;
                return;
            } //End block
            if(token.equalsIgnoreCase(QOP_TOKEN))            
            {
                mQop = value.toLowerCase();
                return;
            } //End block
            if(token.equalsIgnoreCase(ALGORITHM_TOKEN))            
            {
                mAlgorithm = value.toLowerCase();
                return;
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.151 -0400", hash_original_method = "76A5C02B3DC683D5BF99D1052171A66C", hash_generated_method = "DEEEA44EBEEAF69D5C92628A6D06A331")
    private void parseStale(String value) {
        addTaint(value.getTaint());
        if(value != null)        
        {
            if(value.equalsIgnoreCase("true"))            
            {
                mStale = true;
            } //End block
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.151 -0400", hash_original_field = "62F0D6DB44FFD6767F4DA02B347D55CD", hash_generated_field = "986C424100AA2C3A2DDC20F5EE727677")

    public final static String BASIC_TOKEN = "Basic";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.152 -0400", hash_original_field = "E52D22C623D30409901F6AFE282F08E6", hash_generated_field = "D52B97DABBD8FCDD390C982C4167F6B8")

    public final static String DIGEST_TOKEN = "Digest";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.152 -0400", hash_original_field = "B0912BBD4ACDE3258F57D5DF55282454", hash_generated_field = "7C84E5A4C0DE9A95A192EA063C6A497A")

    private final static String REALM_TOKEN = "realm";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.152 -0400", hash_original_field = "A6A1BB8AFE958AA07077FF8CA4A566BB", hash_generated_field = "1B11EFC48FC7008004C2BCDE71004BDB")

    private final static String NONCE_TOKEN = "nonce";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.152 -0400", hash_original_field = "0C8A401D125645B459114E0E35EC58C2", hash_generated_field = "404A54A7C4B675C9BCF19A7F54BDC9A6")

    private final static String STALE_TOKEN = "stale";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.152 -0400", hash_original_field = "A5A1D4C16CEDCC27568022EA37A317FF", hash_generated_field = "B368EA3D7E87ACA3FA578A36B31F0EE6")

    private final static String OPAQUE_TOKEN = "opaque";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.152 -0400", hash_original_field = "03CE70FBE077F3DFDEC017814765A5FC", hash_generated_field = "64FE6F3FE5E85E777A8724688308BC45")

    private final static String QOP_TOKEN = "qop";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.152 -0400", hash_original_field = "FE6A5F2F87A68DB77C03C0F759E3739B", hash_generated_field = "B88BEF540D3A6859924C7436392FF8F5")

    private final static String ALGORITHM_TOKEN = "algorithm";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.152 -0400", hash_original_field = "94E61C192E6109B85BABEC62149624F0", hash_generated_field = "847D4677A6A1533A543ECA012114829C")

    public static final int UNKNOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.152 -0400", hash_original_field = "8BE3D57849A09DB037F845BA2CBCB6D0", hash_generated_field = "B0822A45DCF04E972AB9BA01D4ACE62D")

    public static final int BASIC = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.152 -0400", hash_original_field = "39DBEBA79D94DA916843FBD7FF49E9AA", hash_generated_field = "8CA30E62B2B8C2B08E10EA394B68719F")

    public static final int DIGEST = 2;
}

