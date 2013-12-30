package android.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;





public class HttpAuthHeader {

    /**
     * Trims double-quotes around a parameter value if there are any.
     * @return The string value without the outermost pair of double-
     * quotes or null if the original value is null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.402 -0500", hash_original_method = "8BB21142A239D7B3379295133F294A9B", hash_generated_method = "87ABD1B79CDBE3CA7FB6FCF973691D0A")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.301 -0500", hash_original_field = "1F68925E58EA1009957761C8F5ED4411", hash_generated_field = "986C424100AA2C3A2DDC20F5EE727677")

    public final static String BASIC_TOKEN = "Basic";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.303 -0500", hash_original_field = "B92D5342849ACC5DEA01E9A21172FB7E", hash_generated_field = "D52B97DABBD8FCDD390C982C4167F6B8")

    public final static String DIGEST_TOKEN = "Digest";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.306 -0500", hash_original_field = "3AFAF6D243BF22AB499C2557D7784207", hash_generated_field = "7C84E5A4C0DE9A95A192EA063C6A497A")


    private final static String REALM_TOKEN = "realm";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.308 -0500", hash_original_field = "BF7AF071AF5526CD082BCFF0D672BF7E", hash_generated_field = "1B11EFC48FC7008004C2BCDE71004BDB")

    private final static String NONCE_TOKEN = "nonce";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.310 -0500", hash_original_field = "70C8A544DD5FEF8AD16785E436E7183F", hash_generated_field = "404A54A7C4B675C9BCF19A7F54BDC9A6")

    private final static String STALE_TOKEN = "stale";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.313 -0500", hash_original_field = "4B751CF475D5E3D2A41FBBD38EE4B744", hash_generated_field = "B368EA3D7E87ACA3FA578A36B31F0EE6")

    private final static String OPAQUE_TOKEN = "opaque";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.315 -0500", hash_original_field = "B18E61D3328499DEF858E7AFEDFE5030", hash_generated_field = "64FE6F3FE5E85E777A8724688308BC45")

    private final static String QOP_TOKEN = "qop";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.318 -0500", hash_original_field = "DFE9BC32EDA2873CEBE6FC41E9A44858", hash_generated_field = "B88BEF540D3A6859924C7436392FF8F5")

    private final static String ALGORITHM_TOKEN = "algorithm";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.322 -0500", hash_original_field = "A8F66825F9B3BFFF84E8E21A24CF617F", hash_generated_field = "847D4677A6A1533A543ECA012114829C")


    public static final int UNKNOWN = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.324 -0500", hash_original_field = "79FA73196EC6792823F903104FD945FE", hash_generated_field = "B0822A45DCF04E972AB9BA01D4ACE62D")

    public static final int BASIC = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.327 -0500", hash_original_field = "83C80344E816C3CEB8D650876BCCF180", hash_generated_field = "8CA30E62B2B8C2B08E10EA394B68719F")

    public static final int DIGEST = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.320 -0500", hash_original_field = "D448690E06493376061854EE84DF8690", hash_generated_field = "E6BEC331CEEA80F82B83B12255B86465")

    private int mScheme;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.329 -0500", hash_original_field = "175EF7D894504FAB84E7378892513CDE", hash_generated_field = "F1E8A28CAB6C00E7A6B325F09B3FED3E")

    private boolean mStale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.331 -0500", hash_original_field = "2855A899D7F1EC7F95EB4862397BCC66", hash_generated_field = "5A777CBABA6AAC673CE6F5CC9C524A3C")

    private String mRealm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.333 -0500", hash_original_field = "4C8F1EB8E8BD6A0FC6E5C264F76F551A", hash_generated_field = "2EDF64CB0EA09AFD7AB8BCF896D658BC")

    private String mNonce;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.335 -0500", hash_original_field = "273F7D06918FC03113B265A3B6E2F96F", hash_generated_field = "23C76B623A92D22536ACABC3A6FBC3E5")

    private String mOpaque;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.337 -0500", hash_original_field = "7D09901D5117CCE70F192405CCA301B9", hash_generated_field = "39F05D5CDDC8244A3C6F7C97D22D161B")

    private String mQop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.340 -0500", hash_original_field = "547EDA4EBB820CF81E310F66117096A1", hash_generated_field = "956ACE7C8B70403F27CAFAD0405E65A1")

    private String mAlgorithm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.342 -0500", hash_original_field = "4E997AFACC70C94F60A61A89F21942C3", hash_generated_field = "17B726A8F381AA988EF07CFC9F1FA12A")

    private boolean mIsProxy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.344 -0500", hash_original_field = "F6C0B2A92BAD484AE3E9DE7409D6C7A8", hash_generated_field = "50564F75BBDED0F5A11BFE739FB8373A")

    private String mUsername;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.346 -0500", hash_original_field = "6E680D0312272F1C50F2E99ACBEA882B", hash_generated_field = "44A1332F4D6AD461D600A43252892695")

    private String mPassword;

    /**
     * Creates a new HTTP-authentication header object from the
     * input header string.
     * The header string is assumed to contain parameters of at
     * most one authentication-scheme (ensured by the caller).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.348 -0500", hash_original_method = "1FD1D3A9087ED95F87943CC7E812BAFE", hash_generated_method = "B33138E7D369A93F9F0EA70E05862C0D")
    
public HttpAuthHeader(String header) {
        if (header != null) {
            parseHeader(header);
        }
    }

    /**
     * @return True iff this is a proxy authentication header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.351 -0500", hash_original_method = "E3B47ECF178F55BDD1E428FED9536544", hash_generated_method = "935CEB8EE31BD7C94006B9CFD27ADDAD")
    
public boolean isProxy() {
        return mIsProxy;
    }

    /**
     * Marks this header as a proxy authentication header.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.353 -0500", hash_original_method = "F484596B8E11A4861D504E7FDD37DA10", hash_generated_method = "6A39527DD6DD71A023B5353E14E2BB05")
    
public void setProxy() {
        mIsProxy = true;
    }

    /**
     * @return The username string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.356 -0500", hash_original_method = "DC420B5834A563247800515BC4094ADD", hash_generated_method = "9B63FD49EC64FC3BD11D0CDA8801CF81")
    
public String getUsername() {
        return mUsername;
    }

    /**
     * Sets the username string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.358 -0500", hash_original_method = "0E33D9E279BEDC5DAB4D3AD6DE953552", hash_generated_method = "85B15D4C5718CD108D5F233949E6BBBE")
    
public void setUsername(String username) {
        mUsername = username;
    }

    /**
     * @return The password string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.360 -0500", hash_original_method = "352B20CA8286B4BCFAD735A80A162186", hash_generated_method = "9B2AF8FA5A4898123492BF46BD6C9002")
    
public String getPassword() {
        return mPassword;
    }

    /**
     * Sets the password string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.362 -0500", hash_original_method = "5BECAD2A732AB83E1664BF3A6C903529", hash_generated_method = "43BD72A3FF54A927E5AB60CB4F18E74A")
    
public void setPassword(String password) {
        mPassword = password;
    }

    /**
     * @return True iff this is the  BASIC-authentication request.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.365 -0500", hash_original_method = "C2242C4025DD65A560A889E41F117AB7", hash_generated_method = "E69ED53AF8537C50C682B7115F64E3BC")
    
public boolean isBasic () {
        return mScheme == BASIC;
    }

    /**
     * @return True iff this is the DIGEST-authentication request.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.367 -0500", hash_original_method = "C6AFC1E0D0B142E9C4DE27602A4BC054", hash_generated_method = "6E7AAA6209C1305803EE507EFCDA278C")
    
public boolean isDigest() {
        return mScheme == DIGEST;
    }

    /**
     * @return The authentication scheme requested. We currently
     * support two schemes:
     * HttpAuthHeader.BASIC  - basic, and
     * HttpAuthHeader.DIGEST - digest (algorithm=MD5, QOP="auth").
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.369 -0500", hash_original_method = "29E6CF58C110B66305B7C71C00259314", hash_generated_method = "0E29535BACD0BE25AC8933AFFC02BAA7")
    
public int getScheme() {
        return mScheme;
    }

    /**
     * @return True if indicating that the previous request from
     * the client was rejected because the nonce value was stale.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.371 -0500", hash_original_method = "3E3CDB0E616B9E56522984F92CB979FB", hash_generated_method = "A20900995F9497A937281117A3F749A1")
    
public boolean getStale() {
        return mStale;
    }

    /**
     * @return The realm value or null if there is none.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.374 -0500", hash_original_method = "E61C0128BAAE9B474452BFCEF0497CDD", hash_generated_method = "E12446354EB4BBA93A3443D8A7B88EBF")
    
public String getRealm() {
        return mRealm;
    }

    /**
     * @return The nonce value or null if there is none.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.376 -0500", hash_original_method = "B08110B485A4DA24A232A0CC9BEA47F4", hash_generated_method = "A0A85AB6A5FC88D73837681ECFEAAFA9")
    
public String getNonce() {
        return mNonce;
    }

    /**
     * @return The opaque value or null if there is none.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.379 -0500", hash_original_method = "40DED5E91C6F5AFDC12D505952D89AC1", hash_generated_method = "40CF3980CB392F9CB5AA3BE5C663A212")
    
public String getOpaque() {
        return mOpaque;
    }

    /**
     * @return The QOP ("quality-of_protection") value or null if
     * there is none. The QOP value is always lower-case.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.381 -0500", hash_original_method = "7F9926D57780B6A835584FF0B4884044", hash_generated_method = "915284DF2ECBD09017ECB9E168EE63AC")
    
public String getQop() {
        return mQop;
    }

    /**
     * @return The name of the algorithm used or null if there is
     * none. By default, MD5 is used.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.383 -0500", hash_original_method = "0FF39221585FBFD96D2157CC36F75665", hash_generated_method = "CD8C2AAE1A69A038767DF100104B0C38")
    
public String getAlgorithm() {
        return mAlgorithm;
    }

    /**
     * @return True iff the authentication scheme requested by the
     * server is supported; currently supported schemes:
     * BASIC,
     * DIGEST (only algorithm="md5", no qop or qop="auth).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.385 -0500", hash_original_method = "1B2B63EC3C55FEF6363AE03FA64546E8", hash_generated_method = "CD191005DC6E49FD3E6EAB9184081BD1")
    
public boolean isSupportedScheme() {
        // it is a good idea to enforce non-null realms!
        if (mRealm != null) {
            if (mScheme == BASIC) {
                return true;
            } else {
                if (mScheme == DIGEST) {
                    return
                        mAlgorithm.equals("md5") &&
                        (mQop == null || mQop.equals("auth"));
                }
            }
        }

        return false;
    }

    /**
     * Parses the header scheme name and then scheme parameters if
     * the scheme is supported.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.388 -0500", hash_original_method = "5A9C556851102A9977303C7DFC694964", hash_generated_method = "7680988B0AE93E017ADB68EA9FB5FB67")
    
private void parseHeader(String header) {
        if (HttpLog.LOGV) {
            HttpLog.v("HttpAuthHeader.parseHeader(): header: " + header);
        }

        if (header != null) {
            String parameters = parseScheme(header);
            if (parameters != null) {
                // if we have a supported scheme
                if (mScheme != UNKNOWN) {
                    parseParameters(parameters);
                }
            }
        }
    }

    /**
     * Parses the authentication scheme name. If we have a Digest
     * scheme, sets the algorithm value to the default of MD5.
     * @return The authentication scheme parameters string to be
     * parsed later (if the scheme is supported) or null if failed
     * to parse the scheme (the header value is null?).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.390 -0500", hash_original_method = "BA2F0752C4374C507095962D429C28E1", hash_generated_method = "D288CECB993F6AA23666CE3989EA440C")
    
private String parseScheme(String header) {
        if (header != null) {
            int i = header.indexOf(' ');
            if (i >= 0) {
                String scheme = header.substring(0, i).trim();
                if (scheme.equalsIgnoreCase(DIGEST_TOKEN)) {
                    mScheme = DIGEST;

                    // md5 is the default algorithm!!!
                    mAlgorithm = "md5";
                } else {
                    if (scheme.equalsIgnoreCase(BASIC_TOKEN)) {
                        mScheme = BASIC;
                    }
                }

                return header.substring(i + 1);
            }
        }

        return null;
    }

    /**
     * Parses a comma-separated list of authentification scheme
     * parameters.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.392 -0500", hash_original_method = "2438A746B67FAB4E454DBFA828DCDAA3", hash_generated_method = "296ACCF2FB476623414493F173998EA9")
    
private void parseParameters(String parameters) {
        if (HttpLog.LOGV) {
            HttpLog.v("HttpAuthHeader.parseParameters():" +
                      " parameters: " + parameters);
        }

        if (parameters != null) {
            int i;
            do {
                i = parameters.indexOf(',');
                if (i < 0) {
                    // have only one parameter
                    parseParameter(parameters);
                } else {
                    parseParameter(parameters.substring(0, i));
                    parameters = parameters.substring(i + 1);
                }
            } while (i >= 0);
        }
    }

    /**
     * Parses a single authentication scheme parameter. The parameter
     * string is expected to follow the format: PARAMETER=VALUE.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.395 -0500", hash_original_method = "5835A4879F5A1904E0EE047AD8542D67", hash_generated_method = "955E0A89025059E0BD16C48CDA98CC23")
    
private void parseParameter(String parameter) {
        if (parameter != null) {
            // here, we are looking for the 1st occurence of '=' only!!!
            int i = parameter.indexOf('=');
            if (i >= 0) {
                String token = parameter.substring(0, i).trim();
                String value =
                    trimDoubleQuotesIfAny(parameter.substring(i + 1).trim());

                if (HttpLog.LOGV) {
                    HttpLog.v("HttpAuthHeader.parseParameter():" +
                              " token: " + token +
                              " value: " + value);
                }

                if (token.equalsIgnoreCase(REALM_TOKEN)) {
                    mRealm = value;
                } else {
                    if (mScheme == DIGEST) {
                        parseParameter(token, value);
                    }
                }
            }
        }
    }

    /**
     * If the token is a known parameter name, parses and initializes
     * the token value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.397 -0500", hash_original_method = "5C1E65D88B1AA36ECF03FA5CEB305F59", hash_generated_method = "7E7C53D67F6B3E597D57AF7EF225E810")
    
private void parseParameter(String token, String value) {
        if (token != null && value != null) {
            if (token.equalsIgnoreCase(NONCE_TOKEN)) {
                mNonce = value;
                return;
            }

            if (token.equalsIgnoreCase(STALE_TOKEN)) {
                parseStale(value);
                return;
            }

            if (token.equalsIgnoreCase(OPAQUE_TOKEN)) {
                mOpaque = value;
                return;
            }

            if (token.equalsIgnoreCase(QOP_TOKEN)) {
                mQop = value.toLowerCase();
                return;
            }

            if (token.equalsIgnoreCase(ALGORITHM_TOKEN)) {
                mAlgorithm = value.toLowerCase();
                return;
            }
        }
    }

    /**
     * Parses and initializes the 'stale' paramer value. Any value
     * different from case-insensitive "true" is considered "false".
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.399 -0500", hash_original_method = "76A5C02B3DC683D5BF99D1052171A66C", hash_generated_method = "09185FFE4AB317576453852013B0DBCE")
    
private void parseStale(String value) {
        if (value != null) {
            if (value.equalsIgnoreCase("true")) {
                mStale = true;
            }
        }
    }
}

