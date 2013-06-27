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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.680 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "DDFAECCF21F90F28142F5C866534A5C3")

    private URI uri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.680 -0400", hash_original_field = "4340FD73E75DF7A9D9E45902A59BA3A4", hash_generated_field = "534F1B0AE2D401678B9C67DE48E937E4")

    private RawHeaders headers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.680 -0400", hash_original_field = "3EDE331CCA63FAAFB68A34ACB42767C6", hash_generated_field = "5465707577DD6326819BA83CC3A7DE3E")

    private boolean noCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.680 -0400", hash_original_field = "B29571B8149006A2CE1968134C4493D4", hash_generated_field = "6AE706B03701B766A1504BFD91199E77")

    private int maxAgeSeconds = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.680 -0400", hash_original_field = "EB27223B0D697FBC5A0E3696484CEBF2", hash_generated_field = "CE7B115851142EB428D4DC9E717F3041")

    private int maxStaleSeconds = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.680 -0400", hash_original_field = "DF3895087E94DE990A4249993859153E", hash_generated_field = "086F715250E1F43550756BC1900CA699")

    private int minFreshSeconds = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.681 -0400", hash_original_field = "F491C72B7AA8BF6E23C3939D53E7D9D4", hash_generated_field = "57743485CCD77CC05F45CCC698FBC278")

    private boolean onlyIfCached;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.681 -0400", hash_original_field = "FBB6410F1A466A6B597EBD0789DC10B3", hash_generated_field = "7ED9453D363B09CB6651EDC899592357")

    private boolean hasAuthorization;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.681 -0400", hash_original_field = "23620B0ED7D2D6853307DFADB119A41C", hash_generated_field = "C51A9B467DA1E79F88DC6617E76DB248")

    private int contentLength = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.681 -0400", hash_original_field = "BF0487A5497D96D26C24936A4DAD1B2F", hash_generated_field = "53F1E445144D7EEFF13D2F87736EF02D")

    private String transferEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.700 -0400", hash_original_field = "FA71F997FA1A947459DC5495FDB40B0F", hash_generated_field = "88333D67CF65F12E18B2CCFFCF6A1193")

    private String userAgent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.700 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "6D420698033AD4B037D630A04933A2DD")

    private String host;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.700 -0400", hash_original_field = "4717D53EBFDFEA8477F780EC66151DCB", hash_generated_field = "DB0F18ED2FD7BBA4B7D89988BC77D94E")

    private String connection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.700 -0400", hash_original_field = "06F96423E5EC24DC63EB2A62F09C225E", hash_generated_field = "EE8FD96001498BFE0A0B28028AB9D38D")

    private String acceptEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.700 -0400", hash_original_field = "DF5FEAFAB86601EA0E1E6FE6E20DF6C5", hash_generated_field = "F7D06CB833C0C0295691396E4B1D1656")

    private String contentType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.700 -0400", hash_original_field = "61C0F054FFE1E91934EAEB56EE7AF160", hash_generated_field = "501F5A3170249BC588BDE376EE56533C")

    private String ifModifiedSince;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.700 -0400", hash_original_field = "7A87F2F7FF842E2E29E32BEE5A30CC0A", hash_generated_field = "09393A990220AB5E7CED6C5DBA647C56")

    private String ifNoneMatch;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.700 -0400", hash_original_field = "B61FEA397951D150206ED116095C53BC", hash_generated_field = "6C4DFB7A35D3B140FF1CF00900EC5F99")

    private String proxyAuthorization;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.702 -0400", hash_original_method = "43C01170F0D6680BF52373FD0CBCB9B1", hash_generated_method = "FEF820C59E1DAC7D43389C4A1B296847")
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
            boolean var160466EB7D7D5C6ABB8E6B06A85E2B1F_1351154744 = (i < headers.length());
            {
                String fieldName;
                fieldName = headers.getFieldName(i);
                String value;
                value = headers.getValue(i);
                {
                    boolean varD77C8259EAFC94FDC3D657C8834E9487_44582369 = ("Cache-Control".equalsIgnoreCase(fieldName));
                    {
                        HeaderParser.parseCacheControl(value, handler);
                    } //End block
                    {
                        boolean var56F25C5265F567B26213F2536EF32AC1_930098585 = ("Pragma".equalsIgnoreCase(fieldName));
                        {
                            {
                                boolean var43BD107A6E901C7747CCE7BFBB8DD07E_1125243320 = (value.equalsIgnoreCase("no-cache"));
                                {
                                    noCache = true;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            boolean var8DAE09CD6FB1152EE1004A7A7A8CE5E0_1883251244 = ("If-None-Match".equalsIgnoreCase(fieldName));
                            {
                                ifNoneMatch = value;
                            } //End block
                            {
                                boolean varB088D15F96093D53CB7FE5B7CC0836F4_456025928 = ("If-Modified-Since".equalsIgnoreCase(fieldName));
                                {
                                    ifModifiedSince = value;
                                } //End block
                                {
                                    boolean varC67E0A5BE37C2BCADE7BD8E8FBD99D7C_811597906 = ("Authorization".equalsIgnoreCase(fieldName));
                                    {
                                        hasAuthorization = true;
                                    } //End block
                                    {
                                        boolean var83FEBE437E90CCE4FDE377518B344B6F_237748466 = ("Content-Length".equalsIgnoreCase(fieldName));
                                        {
                                            try 
                                            {
                                                contentLength = Integer.parseInt(value);
                                            } //End block
                                            catch (NumberFormatException ignored)
                                            { }
                                        } //End block
                                        {
                                            boolean varFEB01C2A2FAB43A71ACF71F602A1E7B8_1381298621 = ("Transfer-Encoding".equalsIgnoreCase(fieldName));
                                            {
                                                transferEncoding = value;
                                            } //End block
                                            {
                                                boolean var26CB77545109E7877658F31017118009_1181706077 = ("User-Agent".equalsIgnoreCase(fieldName));
                                                {
                                                    userAgent = value;
                                                } //End block
                                                {
                                                    boolean var91F34C4C3A2BB00AFC6A87F65E9909E1_2047172611 = ("Host".equalsIgnoreCase(fieldName));
                                                    {
                                                        host = value;
                                                    } //End block
                                                    {
                                                        boolean varA2563F9A072AFEA1AC1CD72AE8BD1A4E_816354992 = ("Connection".equalsIgnoreCase(fieldName));
                                                        {
                                                            connection = value;
                                                        } //End block
                                                        {
                                                            boolean var6D5B3BEE656FBD0AF9E0BE01F11D009B_1196913561 = ("Accept-Encoding".equalsIgnoreCase(fieldName));
                                                            {
                                                                acceptEncoding = value;
                                                            } //End block
                                                            {
                                                                boolean var426283D7FE1D047628A22BB787AE0450_1383016031 = ("Content-Type".equalsIgnoreCase(fieldName));
                                                                {
                                                                    contentType = value;
                                                                } //End block
                                                                {
                                                                    boolean varE9641B340B6E4D94EEAB0A00C194975F_619145281 = ("Proxy-Authorization".equalsIgnoreCase(fieldName));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.718 -0400", hash_original_method = "00B64F53B1189DFD8EFC83FE9CA41E37", hash_generated_method = "DE6743A040B49A328E651E3B1CD9F09A")
    public boolean isChunked() {
        boolean varA16BCACE603C83FBCA10B7C6B1A17953_1010138829 = ("chunked".equalsIgnoreCase(transferEncoding));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1323874578 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1323874578;
        // ---------- Original Method ----------
        //return "chunked".equalsIgnoreCase(transferEncoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.719 -0400", hash_original_method = "0C9005E446549CA2DCD479C6BCCC6A35", hash_generated_method = "5EF27B5AC24B2DF47B6EEF1098024471")
    public boolean hasConnectionClose() {
        boolean var81EEBB6E2271640A61DE6C091C411E9C_27799734 = ("close".equalsIgnoreCase(connection));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1015523643 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1015523643;
        // ---------- Original Method ----------
        //return "close".equalsIgnoreCase(connection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.720 -0400", hash_original_method = "F8E205165DB0FFA5BCD89362DFA95E13", hash_generated_method = "CF6817A0F8396B0B8628ECAE0527464A")
    public URI getUri() {
        URI varB4EAC82CA7396A68D541C85D26508E83_2007757884 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2007757884 = uri;
        varB4EAC82CA7396A68D541C85D26508E83_2007757884.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2007757884;
        // ---------- Original Method ----------
        //return uri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.720 -0400", hash_original_method = "8B8008667EA7E940C84B2A1E4AADF211", hash_generated_method = "ED24C1EADB845253D517323FB0CBD5FB")
    public RawHeaders getHeaders() {
        RawHeaders varB4EAC82CA7396A68D541C85D26508E83_895577666 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_895577666 = headers;
        varB4EAC82CA7396A68D541C85D26508E83_895577666.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_895577666;
        // ---------- Original Method ----------
        //return headers;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.724 -0400", hash_original_method = "6FC1CEF1DCDA63846245A172D489494E", hash_generated_method = "E907AEB006A06DC8087C6EDC636A6E74")
    public boolean isNoCache() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_81069252 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_81069252;
        // ---------- Original Method ----------
        //return noCache;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.725 -0400", hash_original_method = "A8F2E8C976B81B2FCD2E37C57E26B8BC", hash_generated_method = "B6150629E5B8171507CB4BAF8B2496CE")
    public int getMaxAgeSeconds() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1543850835 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1543850835;
        // ---------- Original Method ----------
        //return maxAgeSeconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.725 -0400", hash_original_method = "1283AA8CCC67672D62DEF88994766C86", hash_generated_method = "F89B49FCAFFF195858D838C353A089AE")
    public int getMaxStaleSeconds() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1623126405 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1623126405;
        // ---------- Original Method ----------
        //return maxStaleSeconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.725 -0400", hash_original_method = "4A1D928FA98CACC97BCF438ADC331E21", hash_generated_method = "A59A0223E2E3F457652836F694B540BC")
    public int getMinFreshSeconds() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1977732639 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1977732639;
        // ---------- Original Method ----------
        //return minFreshSeconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.729 -0400", hash_original_method = "C7564B78FAA65700183F7B25F17E4F9C", hash_generated_method = "8F901996DB9DF02AF4D994F4E6D9E86C")
    public boolean isOnlyIfCached() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1584690340 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1584690340;
        // ---------- Original Method ----------
        //return onlyIfCached;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.729 -0400", hash_original_method = "C62515C32B43542C8AED5B07CDF87144", hash_generated_method = "6E9D4E76DAC8A5B396996E0D7974B40D")
    public boolean hasAuthorization() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1655132444 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1655132444;
        // ---------- Original Method ----------
        //return hasAuthorization;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.733 -0400", hash_original_method = "1B52BDD2BF1D0E488CD60B58C0023743", hash_generated_method = "D39C412DA968C259D572541CE8D7D2C9")
    public int getContentLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1062608453 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1062608453;
        // ---------- Original Method ----------
        //return contentLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.734 -0400", hash_original_method = "0DD6BAEEA01532BD95CE2FFB6DF498BA", hash_generated_method = "E7C896C14AF1D52E09DBB62EE920961D")
    public String getTransferEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1870824880 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1870824880 = transferEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_1870824880.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1870824880;
        // ---------- Original Method ----------
        //return transferEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.735 -0400", hash_original_method = "3896A2F0D61044E6B048D62FF1831396", hash_generated_method = "58D459E54697ED0538E7EB798A4775F7")
    public String getUserAgent() {
        String varB4EAC82CA7396A68D541C85D26508E83_1445976824 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1445976824 = userAgent;
        varB4EAC82CA7396A68D541C85D26508E83_1445976824.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1445976824;
        // ---------- Original Method ----------
        //return userAgent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.751 -0400", hash_original_method = "2F2AEDD17A97DC05E80343AAC323BA28", hash_generated_method = "9ABA4EBB82F38A678B4D8D83CB73D809")
    public String getHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_481681473 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_481681473 = host;
        varB4EAC82CA7396A68D541C85D26508E83_481681473.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_481681473;
        // ---------- Original Method ----------
        //return host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.751 -0400", hash_original_method = "B2D78684E046945E6BE853B24B15E901", hash_generated_method = "ECCC11AEDAA46F66D04F82790F66E669")
    public String getConnection() {
        String varB4EAC82CA7396A68D541C85D26508E83_1895722546 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1895722546 = connection;
        varB4EAC82CA7396A68D541C85D26508E83_1895722546.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1895722546;
        // ---------- Original Method ----------
        //return connection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.751 -0400", hash_original_method = "410EE1417DB3FF49910D59AA9DB70C64", hash_generated_method = "49F698D4ECC32F544FE513E92C19FA2B")
    public String getAcceptEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1932394337 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1932394337 = acceptEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_1932394337.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1932394337;
        // ---------- Original Method ----------
        //return acceptEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.758 -0400", hash_original_method = "4B51DEA5FB62A221AFC62E38AC96F76E", hash_generated_method = "3CD80542D7B9554DC4B72627BCF9C7FC")
    public String getContentType() {
        String varB4EAC82CA7396A68D541C85D26508E83_97018864 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_97018864 = contentType;
        varB4EAC82CA7396A68D541C85D26508E83_97018864.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_97018864;
        // ---------- Original Method ----------
        //return contentType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.760 -0400", hash_original_method = "1155C704429D96DA13DD63BD82AA2AE1", hash_generated_method = "618C62AD64721F62DEF36B1742A773C4")
    public String getIfModifiedSince() {
        String varB4EAC82CA7396A68D541C85D26508E83_1624984412 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1624984412 = ifModifiedSince;
        varB4EAC82CA7396A68D541C85D26508E83_1624984412.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1624984412;
        // ---------- Original Method ----------
        //return ifModifiedSince;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.760 -0400", hash_original_method = "94547B6348D449CB198230E7B6BBA258", hash_generated_method = "BAFA3DA57B092DCDAB6462B8C10FF9BC")
    public String getIfNoneMatch() {
        String varB4EAC82CA7396A68D541C85D26508E83_1646851641 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1646851641 = ifNoneMatch;
        varB4EAC82CA7396A68D541C85D26508E83_1646851641.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1646851641;
        // ---------- Original Method ----------
        //return ifNoneMatch;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.760 -0400", hash_original_method = "0FC6BE3D1567DA200B4FD09DB67F8721", hash_generated_method = "41585C225F004CF946CD10D384D160A5")
    public String getProxyAuthorization() {
        String varB4EAC82CA7396A68D541C85D26508E83_79151413 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_79151413 = proxyAuthorization;
        varB4EAC82CA7396A68D541C85D26508E83_79151413.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_79151413;
        // ---------- Original Method ----------
        //return proxyAuthorization;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.761 -0400", hash_original_method = "F33F8EDA09BCA13DCC3086A1647AF7B6", hash_generated_method = "E6960D9F60ED956BE541131B3F1B8283")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.761 -0400", hash_original_method = "B694A143946FBE7D78723DAA6432C1D4", hash_generated_method = "6FBC4E51BD6CDECD17F4FB5EEC734CFA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.761 -0400", hash_original_method = "DC11EC3DFE82D6B10C121117898B0E91", hash_generated_method = "496E60B2FDDD5519A4561AB71B57F978")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.772 -0400", hash_original_method = "4B7D91EC3E8FCE0AF18D6E617B1DB541", hash_generated_method = "D9899DF3449911473AC09C9E5484D0D5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.776 -0400", hash_original_method = "3089C76E2E8A40B02693EB13728E7CA8", hash_generated_method = "987FA60620B025A6FD4AFACD5B9FF9BE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.776 -0400", hash_original_method = "3166B34126860E43A5A770AE5259F680", hash_generated_method = "A0EEABB8BAE272D93330554EE3541856")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.777 -0400", hash_original_method = "F11902D80B4B7789460A90B0230527B4", hash_generated_method = "0CDB4AD100FC8114C372C03961E376AD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.777 -0400", hash_original_method = "64EEBAAA82D27C1188C64EDA1E7A0A05", hash_generated_method = "6D04992E0B00D197B3D4BD74E2312802")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.785 -0400", hash_original_method = "E4824BE31FA5B08E01F3918FCE59BE57", hash_generated_method = "C427E25E5D5FD840D8CDE50218DF82FC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.789 -0400", hash_original_method = "9FAB8376A6C98C10EDB080B222142712", hash_generated_method = "FA71D0F5CA99EBF7F92D5B388C778728")
    public boolean hasConditions() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1193292784 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1193292784;
        // ---------- Original Method ----------
        //return ifModifiedSince != null || ifNoneMatch != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:05.826 -0400", hash_original_method = "C85A0BA397422D1E98BAC89C6D5C00C6", hash_generated_method = "5624232385208462644E12C3D287F3B7")
    public void addCookies(Map<String, List<String>> allCookieHeaders) {
        {
            Iterator<Map.Entry<String, List<String>>> var4ABBCFEEDD6A26C4CC7635D7335E8FDA_617554378 = (allCookieHeaders.entrySet()).iterator();
            var4ABBCFEEDD6A26C4CC7635D7335E8FDA_617554378.hasNext();
            Map.Entry<String, List<String>> entry = var4ABBCFEEDD6A26C4CC7635D7335E8FDA_617554378.next();
            {
                String key;
                key = entry.getKey();
                {
                    boolean varFF8A784490A70F627778704160B1BFA5_449456800 = ("Cookie".equalsIgnoreCase(key) || "Cookie2".equalsIgnoreCase(key));
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

