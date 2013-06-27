package libcore.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Map;

public final class RequestHeaders {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.551 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "DDFAECCF21F90F28142F5C866534A5C3")

    private URI uri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.551 -0400", hash_original_field = "4340FD73E75DF7A9D9E45902A59BA3A4", hash_generated_field = "534F1B0AE2D401678B9C67DE48E937E4")

    private RawHeaders headers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.551 -0400", hash_original_field = "3EDE331CCA63FAAFB68A34ACB42767C6", hash_generated_field = "5465707577DD6326819BA83CC3A7DE3E")

    private boolean noCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.551 -0400", hash_original_field = "B29571B8149006A2CE1968134C4493D4", hash_generated_field = "6AE706B03701B766A1504BFD91199E77")

    private int maxAgeSeconds = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.551 -0400", hash_original_field = "EB27223B0D697FBC5A0E3696484CEBF2", hash_generated_field = "CE7B115851142EB428D4DC9E717F3041")

    private int maxStaleSeconds = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.551 -0400", hash_original_field = "DF3895087E94DE990A4249993859153E", hash_generated_field = "086F715250E1F43550756BC1900CA699")

    private int minFreshSeconds = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.551 -0400", hash_original_field = "F491C72B7AA8BF6E23C3939D53E7D9D4", hash_generated_field = "57743485CCD77CC05F45CCC698FBC278")

    private boolean onlyIfCached;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.551 -0400", hash_original_field = "FBB6410F1A466A6B597EBD0789DC10B3", hash_generated_field = "7ED9453D363B09CB6651EDC899592357")

    private boolean hasAuthorization;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.551 -0400", hash_original_field = "23620B0ED7D2D6853307DFADB119A41C", hash_generated_field = "C51A9B467DA1E79F88DC6617E76DB248")

    private int contentLength = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.551 -0400", hash_original_field = "BF0487A5497D96D26C24936A4DAD1B2F", hash_generated_field = "53F1E445144D7EEFF13D2F87736EF02D")

    private String transferEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.551 -0400", hash_original_field = "FA71F997FA1A947459DC5495FDB40B0F", hash_generated_field = "88333D67CF65F12E18B2CCFFCF6A1193")

    private String userAgent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.551 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "6D420698033AD4B037D630A04933A2DD")

    private String host;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.551 -0400", hash_original_field = "4717D53EBFDFEA8477F780EC66151DCB", hash_generated_field = "DB0F18ED2FD7BBA4B7D89988BC77D94E")

    private String connection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.551 -0400", hash_original_field = "06F96423E5EC24DC63EB2A62F09C225E", hash_generated_field = "EE8FD96001498BFE0A0B28028AB9D38D")

    private String acceptEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.551 -0400", hash_original_field = "DF5FEAFAB86601EA0E1E6FE6E20DF6C5", hash_generated_field = "F7D06CB833C0C0295691396E4B1D1656")

    private String contentType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.551 -0400", hash_original_field = "61C0F054FFE1E91934EAEB56EE7AF160", hash_generated_field = "501F5A3170249BC588BDE376EE56533C")

    private String ifModifiedSince;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.551 -0400", hash_original_field = "7A87F2F7FF842E2E29E32BEE5A30CC0A", hash_generated_field = "09393A990220AB5E7CED6C5DBA647C56")

    private String ifNoneMatch;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.551 -0400", hash_original_field = "B61FEA397951D150206ED116095C53BC", hash_generated_field = "6C4DFB7A35D3B140FF1CF00900EC5F99")

    private String proxyAuthorization;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.566 -0400", hash_original_method = "43C01170F0D6680BF52373FD0CBCB9B1", hash_generated_method = "DB04E05EFF1A9837809869B1CEC2B551")
    public  RequestHeaders(URI uri, RawHeaders headers) {
        this.uri = uri;
        this.headers = headers;
        HeaderParser.CacheControlHandler handler;
        handler = new HeaderParser.CacheControlHandler() {
            @Override public void handle(String directive, String parameter) {
                if (directive.equalsIgnoreCase("no-cache")) {
                    noCache = true;
                } else if (directive.equalsIgnoreCase("max-age")) {
                    maxAgeSeconds = HeaderParser.parseSeconds(parameter);
                } else if (directive.equalsIgnoreCase("max-stale")) {
                    maxStaleSeconds = HeaderParser.parseSeconds(parameter);
                } else if (directive.equalsIgnoreCase("min-fresh")) {
                    minFreshSeconds = HeaderParser.parseSeconds(parameter);
                } else if (directive.equalsIgnoreCase("only-if-cached")) {
                    onlyIfCached = true;
                }
            }
        };
        {
            int i;
            i = 0;
            boolean var160466EB7D7D5C6ABB8E6B06A85E2B1F_1467471192 = (i < headers.length());
            {
                String fieldName;
                fieldName = headers.getFieldName(i);
                String value;
                value = headers.getValue(i);
                {
                    boolean varD77C8259EAFC94FDC3D657C8834E9487_1605493580 = ("Cache-Control".equalsIgnoreCase(fieldName));
                    {
                        HeaderParser.parseCacheControl(value, handler);
                    } //End block
                    {
                        boolean var56F25C5265F567B26213F2536EF32AC1_1443058803 = ("Pragma".equalsIgnoreCase(fieldName));
                        {
                            {
                                boolean var43BD107A6E901C7747CCE7BFBB8DD07E_1846406547 = (value.equalsIgnoreCase("no-cache"));
                                {
                                    noCache = true;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            boolean var8DAE09CD6FB1152EE1004A7A7A8CE5E0_1892243971 = ("If-None-Match".equalsIgnoreCase(fieldName));
                            {
                                ifNoneMatch = value;
                            } //End block
                            {
                                boolean varB088D15F96093D53CB7FE5B7CC0836F4_1344997452 = ("If-Modified-Since".equalsIgnoreCase(fieldName));
                                {
                                    ifModifiedSince = value;
                                } //End block
                                {
                                    boolean varC67E0A5BE37C2BCADE7BD8E8FBD99D7C_1937707666 = ("Authorization".equalsIgnoreCase(fieldName));
                                    {
                                        hasAuthorization = true;
                                    } //End block
                                    {
                                        boolean var83FEBE437E90CCE4FDE377518B344B6F_137173669 = ("Content-Length".equalsIgnoreCase(fieldName));
                                        {
                                            try 
                                            {
                                                contentLength = Integer.parseInt(value);
                                            } //End block
                                            catch (NumberFormatException ignored)
                                            { }
                                        } //End block
                                        {
                                            boolean varFEB01C2A2FAB43A71ACF71F602A1E7B8_1127353065 = ("Transfer-Encoding".equalsIgnoreCase(fieldName));
                                            {
                                                transferEncoding = value;
                                            } //End block
                                            {
                                                boolean var26CB77545109E7877658F31017118009_1268634897 = ("User-Agent".equalsIgnoreCase(fieldName));
                                                {
                                                    userAgent = value;
                                                } //End block
                                                {
                                                    boolean var91F34C4C3A2BB00AFC6A87F65E9909E1_1333914880 = ("Host".equalsIgnoreCase(fieldName));
                                                    {
                                                        host = value;
                                                    } //End block
                                                    {
                                                        boolean varA2563F9A072AFEA1AC1CD72AE8BD1A4E_1258552919 = ("Connection".equalsIgnoreCase(fieldName));
                                                        {
                                                            connection = value;
                                                        } //End block
                                                        {
                                                            boolean var6D5B3BEE656FBD0AF9E0BE01F11D009B_1959679488 = ("Accept-Encoding".equalsIgnoreCase(fieldName));
                                                            {
                                                                acceptEncoding = value;
                                                            } //End block
                                                            {
                                                                boolean var426283D7FE1D047628A22BB787AE0450_1470393502 = ("Content-Type".equalsIgnoreCase(fieldName));
                                                                {
                                                                    contentType = value;
                                                                } //End block
                                                                {
                                                                    boolean varE9641B340B6E4D94EEAB0A00C194975F_904465931 = ("Proxy-Authorization".equalsIgnoreCase(fieldName));
                                                                    {
                                                                        proxyAuthorization = value;
                                                                    } //End block
                                                                } //End collapsed parenthetic
                                                            } //End collapsed parenthetic
                                                        } //End collapsed parenthetic
                                                    } //End collapsed parenthetic
                                                } //End collapsed parenthetic
                                            } //End collapsed parenthetic
                                        } //End collapsed parenthetic
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.567 -0400", hash_original_method = "00B64F53B1189DFD8EFC83FE9CA41E37", hash_generated_method = "7BE9EA8CC8793AAB639310595636EFFA")
    public boolean isChunked() {
        boolean varA16BCACE603C83FBCA10B7C6B1A17953_1005815346 = ("chunked".equalsIgnoreCase(transferEncoding));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_616780341 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_616780341;
        // ---------- Original Method ----------
        //return "chunked".equalsIgnoreCase(transferEncoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.570 -0400", hash_original_method = "0C9005E446549CA2DCD479C6BCCC6A35", hash_generated_method = "2AA8F14D0E86C7BD2BBAD7E5FF092833")
    public boolean hasConnectionClose() {
        boolean var81EEBB6E2271640A61DE6C091C411E9C_1097436060 = ("close".equalsIgnoreCase(connection));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_682239951 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_682239951;
        // ---------- Original Method ----------
        //return "close".equalsIgnoreCase(connection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.572 -0400", hash_original_method = "F8E205165DB0FFA5BCD89362DFA95E13", hash_generated_method = "B64DD67C8A6DD73719418D16DB8E9B37")
    public URI getUri() {
        URI varB4EAC82CA7396A68D541C85D26508E83_1019549841 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1019549841 = uri;
        varB4EAC82CA7396A68D541C85D26508E83_1019549841.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1019549841;
        // ---------- Original Method ----------
        //return uri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.592 -0400", hash_original_method = "8B8008667EA7E940C84B2A1E4AADF211", hash_generated_method = "230ECE0EAB36439FC9E3B289595AFE7D")
    public RawHeaders getHeaders() {
        RawHeaders varB4EAC82CA7396A68D541C85D26508E83_1708145921 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1708145921 = headers;
        varB4EAC82CA7396A68D541C85D26508E83_1708145921.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1708145921;
        // ---------- Original Method ----------
        //return headers;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.592 -0400", hash_original_method = "6FC1CEF1DCDA63846245A172D489494E", hash_generated_method = "3ABDDA7009384A0C1A7241995304B0C0")
    public boolean isNoCache() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1234599951 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1234599951;
        // ---------- Original Method ----------
        //return noCache;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.593 -0400", hash_original_method = "A8F2E8C976B81B2FCD2E37C57E26B8BC", hash_generated_method = "84597034B0C8A3CD1A6D6CA099E970C6")
    public int getMaxAgeSeconds() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1941786837 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1941786837;
        // ---------- Original Method ----------
        //return maxAgeSeconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.593 -0400", hash_original_method = "1283AA8CCC67672D62DEF88994766C86", hash_generated_method = "9081E5A0F9A8D85107A6AF420267C896")
    public int getMaxStaleSeconds() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_565880384 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_565880384;
        // ---------- Original Method ----------
        //return maxStaleSeconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.594 -0400", hash_original_method = "4A1D928FA98CACC97BCF438ADC331E21", hash_generated_method = "7DDA6759712820781BE0A8AF915FBA6D")
    public int getMinFreshSeconds() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1959745321 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1959745321;
        // ---------- Original Method ----------
        //return minFreshSeconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.594 -0400", hash_original_method = "C7564B78FAA65700183F7B25F17E4F9C", hash_generated_method = "7CB9B5E54866722B093C9702EB5ADD36")
    public boolean isOnlyIfCached() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2066725705 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2066725705;
        // ---------- Original Method ----------
        //return onlyIfCached;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.594 -0400", hash_original_method = "C62515C32B43542C8AED5B07CDF87144", hash_generated_method = "FDAB0A30485F98CEE5F1FF43820794B8")
    public boolean hasAuthorization() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1545440819 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1545440819;
        // ---------- Original Method ----------
        //return hasAuthorization;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.594 -0400", hash_original_method = "1B52BDD2BF1D0E488CD60B58C0023743", hash_generated_method = "7B50585465E1820C89B7FC2AADFCBCB6")
    public int getContentLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1820750568 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1820750568;
        // ---------- Original Method ----------
        //return contentLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.595 -0400", hash_original_method = "0DD6BAEEA01532BD95CE2FFB6DF498BA", hash_generated_method = "DD3836F3D846F79D74E0F184420203B3")
    public String getTransferEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1532619702 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1532619702 = transferEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_1532619702.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1532619702;
        // ---------- Original Method ----------
        //return transferEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.599 -0400", hash_original_method = "3896A2F0D61044E6B048D62FF1831396", hash_generated_method = "EB2AD0035C41CB2B8F98F53A3F09C0F7")
    public String getUserAgent() {
        String varB4EAC82CA7396A68D541C85D26508E83_397614603 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_397614603 = userAgent;
        varB4EAC82CA7396A68D541C85D26508E83_397614603.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_397614603;
        // ---------- Original Method ----------
        //return userAgent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.603 -0400", hash_original_method = "2F2AEDD17A97DC05E80343AAC323BA28", hash_generated_method = "D158F9B15EB133646EE93ED190275EBB")
    public String getHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_24685246 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_24685246 = host;
        varB4EAC82CA7396A68D541C85D26508E83_24685246.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_24685246;
        // ---------- Original Method ----------
        //return host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.604 -0400", hash_original_method = "B2D78684E046945E6BE853B24B15E901", hash_generated_method = "092DBE031E9A76ACFCB9FFD9B34E12C7")
    public String getConnection() {
        String varB4EAC82CA7396A68D541C85D26508E83_2013464562 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2013464562 = connection;
        varB4EAC82CA7396A68D541C85D26508E83_2013464562.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2013464562;
        // ---------- Original Method ----------
        //return connection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.604 -0400", hash_original_method = "410EE1417DB3FF49910D59AA9DB70C64", hash_generated_method = "7D04BEC9607A87BFCF47B73B3C27A112")
    public String getAcceptEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1685478082 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1685478082 = acceptEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_1685478082.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1685478082;
        // ---------- Original Method ----------
        //return acceptEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.678 -0400", hash_original_method = "4B51DEA5FB62A221AFC62E38AC96F76E", hash_generated_method = "269779CE3473E89056664DDB1B9BE2F2")
    public String getContentType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1052574156 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1052574156 = contentType;
        varB4EAC82CA7396A68D541C85D26508E83_1052574156.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1052574156;
        // ---------- Original Method ----------
        //return contentType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.678 -0400", hash_original_method = "1155C704429D96DA13DD63BD82AA2AE1", hash_generated_method = "6DF1530032DDC22B258847EBC5C578F6")
    public String getIfModifiedSince() {
        String varB4EAC82CA7396A68D541C85D26508E83_758129696 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_758129696 = ifModifiedSince;
        varB4EAC82CA7396A68D541C85D26508E83_758129696.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_758129696;
        // ---------- Original Method ----------
        //return ifModifiedSince;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.679 -0400", hash_original_method = "94547B6348D449CB198230E7B6BBA258", hash_generated_method = "5DA40A55CFEC850B012D564EC983BC82")
    public String getIfNoneMatch() {
        String varB4EAC82CA7396A68D541C85D26508E83_1294650471 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1294650471 = ifNoneMatch;
        varB4EAC82CA7396A68D541C85D26508E83_1294650471.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1294650471;
        // ---------- Original Method ----------
        //return ifNoneMatch;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.679 -0400", hash_original_method = "0FC6BE3D1567DA200B4FD09DB67F8721", hash_generated_method = "4962ACC4E97733D95FF24F67D3489823")
    public String getProxyAuthorization() {
        String varB4EAC82CA7396A68D541C85D26508E83_225947067 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_225947067 = proxyAuthorization;
        varB4EAC82CA7396A68D541C85D26508E83_225947067.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_225947067;
        // ---------- Original Method ----------
        //return proxyAuthorization;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.679 -0400", hash_original_method = "F33F8EDA09BCA13DCC3086A1647AF7B6", hash_generated_method = "E6960D9F60ED956BE541131B3F1B8283")
    public void setChunked() {
        {
            headers.removeAll("Transfer-Encoding");
        } //End block
        headers.add("Transfer-Encoding", "chunked");
        this.transferEncoding = "chunked";
        // ---------- Original Method ----------
        //if (this.transferEncoding != null) {
            //headers.removeAll("Transfer-Encoding");
        //}
        //headers.add("Transfer-Encoding", "chunked");
        //this.transferEncoding = "chunked";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.686 -0400", hash_original_method = "B694A143946FBE7D78723DAA6432C1D4", hash_generated_method = "6FBC4E51BD6CDECD17F4FB5EEC734CFA")
    public void setContentLength(int contentLength) {
        {
            headers.removeAll("Content-Length");
        } //End block
        headers.add("Content-Length", Integer.toString(contentLength));
        this.contentLength = contentLength;
        // ---------- Original Method ----------
        //if (this.contentLength != -1) {
            //headers.removeAll("Content-Length");
        //}
        //headers.add("Content-Length", Integer.toString(contentLength));
        //this.contentLength = contentLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.687 -0400", hash_original_method = "DC11EC3DFE82D6B10C121117898B0E91", hash_generated_method = "496E60B2FDDD5519A4561AB71B57F978")
    public void setUserAgent(String userAgent) {
        {
            headers.removeAll("User-Agent");
        } //End block
        headers.add("User-Agent", userAgent);
        this.userAgent = userAgent;
        // ---------- Original Method ----------
        //if (this.userAgent != null) {
            //headers.removeAll("User-Agent");
        //}
        //headers.add("User-Agent", userAgent);
        //this.userAgent = userAgent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.687 -0400", hash_original_method = "4B7D91EC3E8FCE0AF18D6E617B1DB541", hash_generated_method = "D9899DF3449911473AC09C9E5484D0D5")
    public void setHost(String host) {
        {
            headers.removeAll("Host");
        } //End block
        headers.add("Host", host);
        this.host = host;
        // ---------- Original Method ----------
        //if (this.host != null) {
            //headers.removeAll("Host");
        //}
        //headers.add("Host", host);
        //this.host = host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.695 -0400", hash_original_method = "3089C76E2E8A40B02693EB13728E7CA8", hash_generated_method = "987FA60620B025A6FD4AFACD5B9FF9BE")
    public void setConnection(String connection) {
        {
            headers.removeAll("Connection");
        } //End block
        headers.add("Connection", connection);
        this.connection = connection;
        // ---------- Original Method ----------
        //if (this.connection != null) {
            //headers.removeAll("Connection");
        //}
        //headers.add("Connection", connection);
        //this.connection = connection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.695 -0400", hash_original_method = "3166B34126860E43A5A770AE5259F680", hash_generated_method = "A0EEABB8BAE272D93330554EE3541856")
    public void setAcceptEncoding(String acceptEncoding) {
        {
            headers.removeAll("Accept-Encoding");
        } //End block
        headers.add("Accept-Encoding", acceptEncoding);
        this.acceptEncoding = acceptEncoding;
        // ---------- Original Method ----------
        //if (this.acceptEncoding != null) {
            //headers.removeAll("Accept-Encoding");
        //}
        //headers.add("Accept-Encoding", acceptEncoding);
        //this.acceptEncoding = acceptEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.696 -0400", hash_original_method = "F11902D80B4B7789460A90B0230527B4", hash_generated_method = "0CDB4AD100FC8114C372C03961E376AD")
    public void setContentType(String contentType) {
        {
            headers.removeAll("Content-Type");
        } //End block
        headers.add("Content-Type", contentType);
        this.contentType = contentType;
        // ---------- Original Method ----------
        //if (this.contentType != null) {
            //headers.removeAll("Content-Type");
        //}
        //headers.add("Content-Type", contentType);
        //this.contentType = contentType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.696 -0400", hash_original_method = "64EEBAAA82D27C1188C64EDA1E7A0A05", hash_generated_method = "6D04992E0B00D197B3D4BD74E2312802")
    public void setIfModifiedSince(Date date) {
        {
            headers.removeAll("If-Modified-Since");
        } //End block
        String formattedDate;
        formattedDate = HttpDate.format(date);
        headers.add("If-Modified-Since", formattedDate);
        ifModifiedSince = formattedDate;
        addTaint(date.getTaint());
        // ---------- Original Method ----------
        //if (ifModifiedSince != null) {
            //headers.removeAll("If-Modified-Since");
        //}
        //String formattedDate = HttpDate.format(date);
        //headers.add("If-Modified-Since", formattedDate);
        //ifModifiedSince = formattedDate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.703 -0400", hash_original_method = "E4824BE31FA5B08E01F3918FCE59BE57", hash_generated_method = "C427E25E5D5FD840D8CDE50218DF82FC")
    public void setIfNoneMatch(String ifNoneMatch) {
        {
            headers.removeAll("If-None-Match");
        } //End block
        headers.add("If-None-Match", ifNoneMatch);
        this.ifNoneMatch = ifNoneMatch;
        // ---------- Original Method ----------
        //if (this.ifNoneMatch != null) {
            //headers.removeAll("If-None-Match");
        //}
        //headers.add("If-None-Match", ifNoneMatch);
        //this.ifNoneMatch = ifNoneMatch;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.703 -0400", hash_original_method = "9FAB8376A6C98C10EDB080B222142712", hash_generated_method = "BA71692632E68069BC429B71C0E40915")
    public boolean hasConditions() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1101003458 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1101003458;
        // ---------- Original Method ----------
        //return ifModifiedSince != null || ifNoneMatch != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:04.737 -0400", hash_original_method = "C85A0BA397422D1E98BAC89C6D5C00C6", hash_generated_method = "BB1176C65471B51779A8800ED098DA46")
    public void addCookies(Map<String, List<String>> allCookieHeaders) {
        {
            Iterator<Map.Entry<String, List<String>>> var4ABBCFEEDD6A26C4CC7635D7335E8FDA_909772568 = (allCookieHeaders.entrySet()).iterator();
            var4ABBCFEEDD6A26C4CC7635D7335E8FDA_909772568.hasNext();
            Map.Entry<String, List<String>> entry = var4ABBCFEEDD6A26C4CC7635D7335E8FDA_909772568.next();
            {
                String key;
                key = entry.getKey();
                {
                    boolean varFF8A784490A70F627778704160B1BFA5_1299749447 = ("Cookie".equalsIgnoreCase(key) || "Cookie2".equalsIgnoreCase(key));
                    {
                        headers.addAll(key, entry.getValue());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(allCookieHeaders.getTaint());
        // ---------- Original Method ----------
        //for (Map.Entry<String, List<String>> entry : allCookieHeaders.entrySet()) {
            //String key = entry.getKey();
            //if ("Cookie".equalsIgnoreCase(key) || "Cookie2".equalsIgnoreCase(key)) {
                //headers.addAll(key, entry.getValue());
            //}
        //}
    }

    
}

