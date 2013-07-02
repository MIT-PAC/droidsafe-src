package android.net.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class HttpAuthHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.874 -0400", hash_original_field = "51CA147512905722A26C3D219A583C78", hash_generated_field = "E6BEC331CEEA80F82B83B12255B86465")

    private int mScheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.874 -0400", hash_original_field = "152C8B4B0CCFD745368735E28EBFFA00", hash_generated_field = "F1E8A28CAB6C00E7A6B325F09B3FED3E")

    private boolean mStale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.874 -0400", hash_original_field = "D6C54CCF8E100F0747350A2B2CAC95FD", hash_generated_field = "5A777CBABA6AAC673CE6F5CC9C524A3C")

    private String mRealm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.874 -0400", hash_original_field = "63EA1DF1089A1758FF90C84142C0B973", hash_generated_field = "2EDF64CB0EA09AFD7AB8BCF896D658BC")

    private String mNonce;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.874 -0400", hash_original_field = "D57F412B2FBE34E5266AB85A3EC09555", hash_generated_field = "23C76B623A92D22536ACABC3A6FBC3E5")

    private String mOpaque;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.874 -0400", hash_original_field = "669AC09116EDE1210AE984751680B609", hash_generated_field = "39F05D5CDDC8244A3C6F7C97D22D161B")

    private String mQop;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.874 -0400", hash_original_field = "F6E257862B80390CD13E2E0129E87947", hash_generated_field = "956ACE7C8B70403F27CAFAD0405E65A1")

    private String mAlgorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.874 -0400", hash_original_field = "DE5F3ADAFBA0C6CBA55780675ACC563E", hash_generated_field = "17B726A8F381AA988EF07CFC9F1FA12A")

    private boolean mIsProxy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.874 -0400", hash_original_field = "2FB3EB7CD104D0E14FE0487884A12591", hash_generated_field = "50564F75BBDED0F5A11BFE739FB8373A")

    private String mUsername;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.874 -0400", hash_original_field = "5C6B7EE711155A7472DA571800057A96", hash_generated_field = "44A1332F4D6AD461D600A43252892695")

    private String mPassword;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.875 -0400", hash_original_method = "1FD1D3A9087ED95F87943CC7E812BAFE", hash_generated_method = "CE896D69A4909608CB69BB7C189C9898")
    public  HttpAuthHeader(String header) {
        {
            parseHeader(header);
        } 
        addTaint(header.getTaint());
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.875 -0400", hash_original_method = "E3B47ECF178F55BDD1E428FED9536544", hash_generated_method = "C29C21A06D1027B95299BF7F1EEB1440")
    public boolean isProxy() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1283225826 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1283225826;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.875 -0400", hash_original_method = "F484596B8E11A4861D504E7FDD37DA10", hash_generated_method = "DD3E3DD04D17DDB30604953E8A9252B1")
    public void setProxy() {
        mIsProxy = true;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.875 -0400", hash_original_method = "DC420B5834A563247800515BC4094ADD", hash_generated_method = "C15D5B05C42B729D87BEB70BBAAFF4F2")
    public String getUsername() {
        String varB4EAC82CA7396A68D541C85D26508E83_55713467 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_55713467 = mUsername;
        varB4EAC82CA7396A68D541C85D26508E83_55713467.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_55713467;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.876 -0400", hash_original_method = "0E33D9E279BEDC5DAB4D3AD6DE953552", hash_generated_method = "3955AB7BA77A651158545815C33BA20C")
    public void setUsername(String username) {
        mUsername = username;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.876 -0400", hash_original_method = "352B20CA8286B4BCFAD735A80A162186", hash_generated_method = "B6D564C3995D1C80ADE103B2D4BD186D")
    public String getPassword() {
        String varB4EAC82CA7396A68D541C85D26508E83_166547581 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_166547581 = mPassword;
        varB4EAC82CA7396A68D541C85D26508E83_166547581.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_166547581;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.877 -0400", hash_original_method = "5BECAD2A732AB83E1664BF3A6C903529", hash_generated_method = "0844A0EC752FFDF12DBAC561F066925A")
    public void setPassword(String password) {
        mPassword = password;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.877 -0400", hash_original_method = "C2242C4025DD65A560A889E41F117AB7", hash_generated_method = "C78BA6C27883BB2D78B213CA74D2B346")
    public boolean isBasic() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1456732216 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1456732216;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.878 -0400", hash_original_method = "C6AFC1E0D0B142E9C4DE27602A4BC054", hash_generated_method = "4A2B5802220DBF4805184DA262DAED3C")
    public boolean isDigest() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_418170681 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_418170681;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.878 -0400", hash_original_method = "29E6CF58C110B66305B7C71C00259314", hash_generated_method = "8B9EA35A7DE540645274A1B194AB86DD")
    public int getScheme() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_387870854 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_387870854;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.878 -0400", hash_original_method = "3E3CDB0E616B9E56522984F92CB979FB", hash_generated_method = "C3C43B915B3770B954D17743CE87F344")
    public boolean getStale() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2074589569 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2074589569;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.879 -0400", hash_original_method = "E61C0128BAAE9B474452BFCEF0497CDD", hash_generated_method = "9BEB6494428159CE71FA8733E39EC41A")
    public String getRealm() {
        String varB4EAC82CA7396A68D541C85D26508E83_737938622 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_737938622 = mRealm;
        varB4EAC82CA7396A68D541C85D26508E83_737938622.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_737938622;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.879 -0400", hash_original_method = "B08110B485A4DA24A232A0CC9BEA47F4", hash_generated_method = "EC307AADA62B90BA4562F999EA8C457D")
    public String getNonce() {
        String varB4EAC82CA7396A68D541C85D26508E83_335173798 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_335173798 = mNonce;
        varB4EAC82CA7396A68D541C85D26508E83_335173798.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_335173798;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.880 -0400", hash_original_method = "40DED5E91C6F5AFDC12D505952D89AC1", hash_generated_method = "393688E85452EFBA269691166E93AD4C")
    public String getOpaque() {
        String varB4EAC82CA7396A68D541C85D26508E83_1608850622 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1608850622 = mOpaque;
        varB4EAC82CA7396A68D541C85D26508E83_1608850622.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1608850622;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.880 -0400", hash_original_method = "7F9926D57780B6A835584FF0B4884044", hash_generated_method = "C436855635BE6C66E4A637DB2CE513C3")
    public String getQop() {
        String varB4EAC82CA7396A68D541C85D26508E83_583702095 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_583702095 = mQop;
        varB4EAC82CA7396A68D541C85D26508E83_583702095.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_583702095;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.881 -0400", hash_original_method = "0FF39221585FBFD96D2157CC36F75665", hash_generated_method = "28CE7A9757227CEDF0CA2D5B97D588B0")
    public String getAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_1694083880 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1694083880 = mAlgorithm;
        varB4EAC82CA7396A68D541C85D26508E83_1694083880.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1694083880;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.881 -0400", hash_original_method = "1B2B63EC3C55FEF6363AE03FA64546E8", hash_generated_method = "CE1CF7B8073930E2EB8A09AA575AB35B")
    public boolean isSupportedScheme() {
        {
            {
                {
                    boolean var74F77E97056CDC845905F625FD4FAE6E_1641629614 = (mAlgorithm.equals("md5") &&
                        (mQop == null || mQop.equals("auth")));
                } 
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1115111365 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1115111365;
        
        
            
                
            
                
                    
                        
                        
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.881 -0400", hash_original_method = "5A9C556851102A9977303C7DFC694964", hash_generated_method = "0F34D68012D4AAEFF4D022CA4BD5D8CE")
    private void parseHeader(String header) {
        {
            HttpLog.v("HttpAuthHeader.parseHeader(): header: " + header);
        } 
        {
            String parameters = parseScheme(header);
            {
                {
                    parseParameters(parameters);
                } 
            } 
        } 
        addTaint(header.getTaint());
        
        
            
        
        
            
            
                
                    
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.882 -0400", hash_original_method = "BA2F0752C4374C507095962D429C28E1", hash_generated_method = "46BA9CBCC62413A80A631B5C95559D8D")
    private String parseScheme(String header) {
        String varB4EAC82CA7396A68D541C85D26508E83_313763841 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_926543721 = null; 
        {
            int i = header.indexOf(' ');
            {
                String scheme = header.substring(0, i).trim();
                {
                    boolean var3F3171EEAA43F511CD6F1C3DB88CF340_714660264 = (scheme.equalsIgnoreCase(DIGEST_TOKEN));
                    {
                        mScheme = DIGEST;
                        mAlgorithm = "md5";
                    } 
                    {
                        {
                            boolean var16CB325F43B7CEA678BFF5231E7CFB88_82693709 = (scheme.equalsIgnoreCase(BASIC_TOKEN));
                            {
                                mScheme = BASIC;
                            } 
                        } 
                    } 
                } 
                varB4EAC82CA7396A68D541C85D26508E83_313763841 = header.substring(i + 1);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_926543721 = null;
        addTaint(header.getTaint());
        String varA7E53CE21691AB073D9660D615818899_9860920; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_9860920 = varB4EAC82CA7396A68D541C85D26508E83_313763841;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_9860920 = varB4EAC82CA7396A68D541C85D26508E83_926543721;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_9860920.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_9860920;
        
        
            
            
                
                
                    
                    
                
                    
                        
                    
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.883 -0400", hash_original_method = "2438A746B67FAB4E454DBFA828DCDAA3", hash_generated_method = "73CCFFF0CCC4B765FD35B53AD2A08E5E")
    private void parseParameters(String parameters) {
        {
            HttpLog.v("HttpAuthHeader.parseParameters():" +
                      " parameters: " + parameters);
        } 
        {
            int i;
            {
                i = parameters.indexOf(',');
                {
                    parseParameter(parameters);
                } 
                {
                    parseParameter(parameters.substring(0, i));
                    parameters = parameters.substring(i + 1);
                } 
            } 
        } 
        addTaint(parameters.getTaint());
        
        
            
                      
        
        
            
            
                
                
                    
                
                    
                    
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.883 -0400", hash_original_method = "5835A4879F5A1904E0EE047AD8542D67", hash_generated_method = "5A08DF24BCA52FD79FD0937B25B2B745")
    private void parseParameter(String parameter) {
        {
            int i = parameter.indexOf('=');
            {
                String token = parameter.substring(0, i).trim();
                String value = trimDoubleQuotesIfAny(parameter.substring(i + 1).trim());
                {
                    HttpLog.v("HttpAuthHeader.parseParameter():" +
                              " token: " + token +
                              " value: " + value);
                } 
                {
                    boolean varCEC1DBC4ECC877291DF9F6E9273F6D58_165416871 = (token.equalsIgnoreCase(REALM_TOKEN));
                    {
                        mRealm = value;
                    } 
                    {
                        {
                            parseParameter(token, value);
                        } 
                    } 
                } 
            } 
        } 
        addTaint(parameter.getTaint());
        
        
            
            
                
                
                    
                
                    
                              
                              
                
                
                    
                
                    
                        
                    
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.884 -0400", hash_original_method = "5C1E65D88B1AA36ECF03FA5CEB305F59", hash_generated_method = "2CCDC817FD3A0B5A286ADB7612020F54")
    private void parseParameter(String token, String value) {
        {
            {
                boolean var15BA235533ABCE547E0797A898456E7C_1721560878 = (token.equalsIgnoreCase(NONCE_TOKEN));
                {
                    mNonce = value;
                } 
            } 
            {
                boolean varB44C547194E6F53089412783571B2447_1549357496 = (token.equalsIgnoreCase(STALE_TOKEN));
                {
                    parseStale(value);
                } 
            } 
            {
                boolean var60D1503A4A333BAFF728E7D81DC09722_919901967 = (token.equalsIgnoreCase(OPAQUE_TOKEN));
                {
                    mOpaque = value;
                } 
            } 
            {
                boolean var22053CACB180CCB306D6CA26A6BD8471_938307381 = (token.equalsIgnoreCase(QOP_TOKEN));
                {
                    mQop = value.toLowerCase();
                } 
            } 
            {
                boolean varD433831E97890454AF3D37C7538A019B_1431571254 = (token.equalsIgnoreCase(ALGORITHM_TOKEN));
                {
                    mAlgorithm = value.toLowerCase();
                } 
            } 
        } 
        addTaint(token.getTaint());
        
        
            
                
                
            
            
                
                
            
            
                
                
            
            
                
                
            
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.884 -0400", hash_original_method = "76A5C02B3DC683D5BF99D1052171A66C", hash_generated_method = "FC3984F4AE7C801EAAC19795B2520902")
    private void parseStale(String value) {
        {
            {
                boolean varF9F03D746A978112631EA8BA624DD149_81577129 = (value.equalsIgnoreCase("true"));
                {
                    mStale = true;
                } 
            } 
        } 
        addTaint(value.getTaint());
        
        
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.885 -0400", hash_original_field = "62F0D6DB44FFD6767F4DA02B347D55CD", hash_generated_field = "986C424100AA2C3A2DDC20F5EE727677")

    public final static String BASIC_TOKEN = "Basic";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.885 -0400", hash_original_field = "E52D22C623D30409901F6AFE282F08E6", hash_generated_field = "D52B97DABBD8FCDD390C982C4167F6B8")

    public final static String DIGEST_TOKEN = "Digest";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.885 -0400", hash_original_field = "B0912BBD4ACDE3258F57D5DF55282454", hash_generated_field = "7C84E5A4C0DE9A95A192EA063C6A497A")

    private final static String REALM_TOKEN = "realm";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.885 -0400", hash_original_field = "A6A1BB8AFE958AA07077FF8CA4A566BB", hash_generated_field = "1B11EFC48FC7008004C2BCDE71004BDB")

    private final static String NONCE_TOKEN = "nonce";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.885 -0400", hash_original_field = "0C8A401D125645B459114E0E35EC58C2", hash_generated_field = "404A54A7C4B675C9BCF19A7F54BDC9A6")

    private final static String STALE_TOKEN = "stale";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.885 -0400", hash_original_field = "A5A1D4C16CEDCC27568022EA37A317FF", hash_generated_field = "B368EA3D7E87ACA3FA578A36B31F0EE6")

    private final static String OPAQUE_TOKEN = "opaque";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.885 -0400", hash_original_field = "03CE70FBE077F3DFDEC017814765A5FC", hash_generated_field = "64FE6F3FE5E85E777A8724688308BC45")

    private final static String QOP_TOKEN = "qop";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.885 -0400", hash_original_field = "FE6A5F2F87A68DB77C03C0F759E3739B", hash_generated_field = "B88BEF540D3A6859924C7436392FF8F5")

    private final static String ALGORITHM_TOKEN = "algorithm";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.885 -0400", hash_original_field = "94E61C192E6109B85BABEC62149624F0", hash_generated_field = "847D4677A6A1533A543ECA012114829C")

    public static final int UNKNOWN = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.885 -0400", hash_original_field = "8BE3D57849A09DB037F845BA2CBCB6D0", hash_generated_field = "B0822A45DCF04E972AB9BA01D4ACE62D")

    public static final int BASIC = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.885 -0400", hash_original_field = "39DBEBA79D94DA916843FBD7FF49E9AA", hash_generated_field = "8CA30E62B2B8C2B08E10EA394B68719F")

    public static final int DIGEST = 2;
}

