package libcore.net.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Map;

public final class RequestHeaders {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.436 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "DDFAECCF21F90F28142F5C866534A5C3")

    private URI uri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.436 -0400", hash_original_field = "4340FD73E75DF7A9D9E45902A59BA3A4", hash_generated_field = "534F1B0AE2D401678B9C67DE48E937E4")

    private RawHeaders headers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.436 -0400", hash_original_field = "3EDE331CCA63FAAFB68A34ACB42767C6", hash_generated_field = "5465707577DD6326819BA83CC3A7DE3E")

    private boolean noCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.436 -0400", hash_original_field = "B29571B8149006A2CE1968134C4493D4", hash_generated_field = "6AE706B03701B766A1504BFD91199E77")

    private int maxAgeSeconds = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.436 -0400", hash_original_field = "EB27223B0D697FBC5A0E3696484CEBF2", hash_generated_field = "CE7B115851142EB428D4DC9E717F3041")

    private int maxStaleSeconds = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.436 -0400", hash_original_field = "DF3895087E94DE990A4249993859153E", hash_generated_field = "086F715250E1F43550756BC1900CA699")

    private int minFreshSeconds = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.436 -0400", hash_original_field = "F491C72B7AA8BF6E23C3939D53E7D9D4", hash_generated_field = "57743485CCD77CC05F45CCC698FBC278")

    private boolean onlyIfCached;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.436 -0400", hash_original_field = "FBB6410F1A466A6B597EBD0789DC10B3", hash_generated_field = "7ED9453D363B09CB6651EDC899592357")

    private boolean hasAuthorization;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.436 -0400", hash_original_field = "23620B0ED7D2D6853307DFADB119A41C", hash_generated_field = "C51A9B467DA1E79F88DC6617E76DB248")

    private int contentLength = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.436 -0400", hash_original_field = "BF0487A5497D96D26C24936A4DAD1B2F", hash_generated_field = "53F1E445144D7EEFF13D2F87736EF02D")

    private String transferEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.436 -0400", hash_original_field = "FA71F997FA1A947459DC5495FDB40B0F", hash_generated_field = "88333D67CF65F12E18B2CCFFCF6A1193")

    private String userAgent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.436 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "6D420698033AD4B037D630A04933A2DD")

    private String host;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.436 -0400", hash_original_field = "4717D53EBFDFEA8477F780EC66151DCB", hash_generated_field = "DB0F18ED2FD7BBA4B7D89988BC77D94E")

    private String connection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.436 -0400", hash_original_field = "06F96423E5EC24DC63EB2A62F09C225E", hash_generated_field = "EE8FD96001498BFE0A0B28028AB9D38D")

    private String acceptEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.436 -0400", hash_original_field = "DF5FEAFAB86601EA0E1E6FE6E20DF6C5", hash_generated_field = "F7D06CB833C0C0295691396E4B1D1656")

    private String contentType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.436 -0400", hash_original_field = "61C0F054FFE1E91934EAEB56EE7AF160", hash_generated_field = "501F5A3170249BC588BDE376EE56533C")

    private String ifModifiedSince;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.436 -0400", hash_original_field = "7A87F2F7FF842E2E29E32BEE5A30CC0A", hash_generated_field = "09393A990220AB5E7CED6C5DBA647C56")

    private String ifNoneMatch;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.436 -0400", hash_original_field = "B61FEA397951D150206ED116095C53BC", hash_generated_field = "6C4DFB7A35D3B140FF1CF00900EC5F99")

    private String proxyAuthorization;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.437 -0400", hash_original_method = "43C01170F0D6680BF52373FD0CBCB9B1", hash_generated_method = "E66DA1780289F1CF3177BEBA7C8A256F")
    public  RequestHeaders(URI uri, RawHeaders headers) {
        this.uri = uri;
        this.headers = headers;
        HeaderParser.CacheControlHandler handler = new HeaderParser.CacheControlHandler() {
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
            int i = 0;
            boolean var160466EB7D7D5C6ABB8E6B06A85E2B1F_23417598 = (i < headers.length());
            {
                String fieldName = headers.getFieldName(i);
                String value = headers.getValue(i);
                {
                    boolean varD77C8259EAFC94FDC3D657C8834E9487_839022175 = ("Cache-Control".equalsIgnoreCase(fieldName));
                    {
                        HeaderParser.parseCacheControl(value, handler);
                    } 
                    {
                        boolean var56F25C5265F567B26213F2536EF32AC1_1758336370 = ("Pragma".equalsIgnoreCase(fieldName));
                        {
                            {
                                boolean var43BD107A6E901C7747CCE7BFBB8DD07E_304921587 = (value.equalsIgnoreCase("no-cache"));
                                {
                                    noCache = true;
                                } 
                            } 
                        } 
                        {
                            boolean var8DAE09CD6FB1152EE1004A7A7A8CE5E0_1364219116 = ("If-None-Match".equalsIgnoreCase(fieldName));
                            {
                                ifNoneMatch = value;
                            } 
                            {
                                boolean varB088D15F96093D53CB7FE5B7CC0836F4_786188180 = ("If-Modified-Since".equalsIgnoreCase(fieldName));
                                {
                                    ifModifiedSince = value;
                                } 
                                {
                                    boolean varC67E0A5BE37C2BCADE7BD8E8FBD99D7C_1575808683 = ("Authorization".equalsIgnoreCase(fieldName));
                                    {
                                        hasAuthorization = true;
                                    } 
                                    {
                                        boolean var83FEBE437E90CCE4FDE377518B344B6F_1488468601 = ("Content-Length".equalsIgnoreCase(fieldName));
                                        {
                                            try 
                                            {
                                                contentLength = Integer.parseInt(value);
                                            } 
                                            catch (NumberFormatException ignored)
                                            { }
                                        } 
                                        {
                                            boolean varFEB01C2A2FAB43A71ACF71F602A1E7B8_1698734791 = ("Transfer-Encoding".equalsIgnoreCase(fieldName));
                                            {
                                                transferEncoding = value;
                                            } 
                                            {
                                                boolean var26CB77545109E7877658F31017118009_2118225432 = ("User-Agent".equalsIgnoreCase(fieldName));
                                                {
                                                    userAgent = value;
                                                } 
                                                {
                                                    boolean var91F34C4C3A2BB00AFC6A87F65E9909E1_637959743 = ("Host".equalsIgnoreCase(fieldName));
                                                    {
                                                        host = value;
                                                    } 
                                                    {
                                                        boolean varA2563F9A072AFEA1AC1CD72AE8BD1A4E_495379428 = ("Connection".equalsIgnoreCase(fieldName));
                                                        {
                                                            connection = value;
                                                        } 
                                                        {
                                                            boolean var6D5B3BEE656FBD0AF9E0BE01F11D009B_90860161 = ("Accept-Encoding".equalsIgnoreCase(fieldName));
                                                            {
                                                                acceptEncoding = value;
                                                            } 
                                                            {
                                                                boolean var426283D7FE1D047628A22BB787AE0450_1046988229 = ("Content-Type".equalsIgnoreCase(fieldName));
                                                                {
                                                                    contentType = value;
                                                                } 
                                                                {
                                                                    boolean varE9641B340B6E4D94EEAB0A00C194975F_1208037435 = ("Proxy-Authorization".equalsIgnoreCase(fieldName));
                                                                    {
                                                                        proxyAuthorization = value;
                                                                    } 
                                                                } 
                                                            } 
                                                        } 
                                                    } 
                                                } 
                                            } 
                                        } 
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.437 -0400", hash_original_method = "00B64F53B1189DFD8EFC83FE9CA41E37", hash_generated_method = "FD6E72764FE6A3DB4E9A08F4E816E58E")
    public boolean isChunked() {
        boolean varA16BCACE603C83FBCA10B7C6B1A17953_816913939 = ("chunked".equalsIgnoreCase(transferEncoding));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_553367130 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_553367130;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.438 -0400", hash_original_method = "0C9005E446549CA2DCD479C6BCCC6A35", hash_generated_method = "7B41B191E5B5E9BC09D6CAE19C6695AF")
    public boolean hasConnectionClose() {
        boolean var81EEBB6E2271640A61DE6C091C411E9C_1700994508 = ("close".equalsIgnoreCase(connection));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_790373579 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_790373579;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.438 -0400", hash_original_method = "F8E205165DB0FFA5BCD89362DFA95E13", hash_generated_method = "2C11375D97D5EB96394DD5CACC42B08C")
    public URI getUri() {
        URI varB4EAC82CA7396A68D541C85D26508E83_725914374 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_725914374 = uri;
        varB4EAC82CA7396A68D541C85D26508E83_725914374.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_725914374;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.438 -0400", hash_original_method = "8B8008667EA7E940C84B2A1E4AADF211", hash_generated_method = "940C09754066C95BF2C1862E5EC74D67")
    public RawHeaders getHeaders() {
        RawHeaders varB4EAC82CA7396A68D541C85D26508E83_521810279 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_521810279 = headers;
        varB4EAC82CA7396A68D541C85D26508E83_521810279.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_521810279;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.439 -0400", hash_original_method = "6FC1CEF1DCDA63846245A172D489494E", hash_generated_method = "2893960F8F4168C6D48B26F61FB58A24")
    public boolean isNoCache() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2008430153 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2008430153;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.439 -0400", hash_original_method = "A8F2E8C976B81B2FCD2E37C57E26B8BC", hash_generated_method = "8094BC17093CF180FD3EA2EFBFF82FA4")
    public int getMaxAgeSeconds() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1328194788 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1328194788;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.439 -0400", hash_original_method = "1283AA8CCC67672D62DEF88994766C86", hash_generated_method = "B9FD6B2C45AE1A3BF04D71107156129D")
    public int getMaxStaleSeconds() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1564752840 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1564752840;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.439 -0400", hash_original_method = "4A1D928FA98CACC97BCF438ADC331E21", hash_generated_method = "11E5DBEE893491EC481012AA3F81D0D2")
    public int getMinFreshSeconds() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1152278322 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1152278322;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.439 -0400", hash_original_method = "C7564B78FAA65700183F7B25F17E4F9C", hash_generated_method = "0DC3FBBCC84CECBF16E9B9B49F2570D7")
    public boolean isOnlyIfCached() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_725286792 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_725286792;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.440 -0400", hash_original_method = "C62515C32B43542C8AED5B07CDF87144", hash_generated_method = "B6B59B1585FAD8BB445871A5998B8AC9")
    public boolean hasAuthorization() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1462598522 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1462598522;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.440 -0400", hash_original_method = "1B52BDD2BF1D0E488CD60B58C0023743", hash_generated_method = "00634F254C60EDAE3E5A426985EDD1D9")
    public int getContentLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_623193279 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_623193279;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.440 -0400", hash_original_method = "0DD6BAEEA01532BD95CE2FFB6DF498BA", hash_generated_method = "D2392E7D1C095315C501C642CB35A81B")
    public String getTransferEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1353535265 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1353535265 = transferEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_1353535265.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1353535265;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.441 -0400", hash_original_method = "3896A2F0D61044E6B048D62FF1831396", hash_generated_method = "625E2F8A8BCC668584F8526D6B1FB8FB")
    public String getUserAgent() {
        String varB4EAC82CA7396A68D541C85D26508E83_2070057606 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2070057606 = userAgent;
        varB4EAC82CA7396A68D541C85D26508E83_2070057606.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2070057606;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.441 -0400", hash_original_method = "2F2AEDD17A97DC05E80343AAC323BA28", hash_generated_method = "46EC712BD51E25884DC46AC2F482415E")
    public String getHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_2108948998 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2108948998 = host;
        varB4EAC82CA7396A68D541C85D26508E83_2108948998.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2108948998;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.441 -0400", hash_original_method = "B2D78684E046945E6BE853B24B15E901", hash_generated_method = "6DA1950CA8C3F77FDC10990A2C5E85AC")
    public String getConnection() {
        String varB4EAC82CA7396A68D541C85D26508E83_1569884002 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1569884002 = connection;
        varB4EAC82CA7396A68D541C85D26508E83_1569884002.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1569884002;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.442 -0400", hash_original_method = "410EE1417DB3FF49910D59AA9DB70C64", hash_generated_method = "0ECC28F3E557E35922B596E6F58AD624")
    public String getAcceptEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1007658196 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1007658196 = acceptEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_1007658196.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1007658196;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.442 -0400", hash_original_method = "4B51DEA5FB62A221AFC62E38AC96F76E", hash_generated_method = "607AF8004B58A048DC75455E3728992A")
    public String getContentType() {
        String varB4EAC82CA7396A68D541C85D26508E83_828150506 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_828150506 = contentType;
        varB4EAC82CA7396A68D541C85D26508E83_828150506.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_828150506;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.442 -0400", hash_original_method = "1155C704429D96DA13DD63BD82AA2AE1", hash_generated_method = "A67FD134CADCB76AB6B9B72921A6AFC1")
    public String getIfModifiedSince() {
        String varB4EAC82CA7396A68D541C85D26508E83_971054939 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_971054939 = ifModifiedSince;
        varB4EAC82CA7396A68D541C85D26508E83_971054939.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_971054939;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.442 -0400", hash_original_method = "94547B6348D449CB198230E7B6BBA258", hash_generated_method = "54A69F87D9057CCFAA7628843445B583")
    public String getIfNoneMatch() {
        String varB4EAC82CA7396A68D541C85D26508E83_306879084 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_306879084 = ifNoneMatch;
        varB4EAC82CA7396A68D541C85D26508E83_306879084.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_306879084;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.443 -0400", hash_original_method = "0FC6BE3D1567DA200B4FD09DB67F8721", hash_generated_method = "B8F2C636C2CD540E3567A1C3E299C361")
    public String getProxyAuthorization() {
        String varB4EAC82CA7396A68D541C85D26508E83_1791441391 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1791441391 = proxyAuthorization;
        varB4EAC82CA7396A68D541C85D26508E83_1791441391.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1791441391;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.443 -0400", hash_original_method = "F33F8EDA09BCA13DCC3086A1647AF7B6", hash_generated_method = "E6960D9F60ED956BE541131B3F1B8283")
    public void setChunked() {
        {
            headers.removeAll("Transfer-Encoding");
        } 
        headers.add("Transfer-Encoding", "chunked");
        this.transferEncoding = "chunked";
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.443 -0400", hash_original_method = "B694A143946FBE7D78723DAA6432C1D4", hash_generated_method = "6FBC4E51BD6CDECD17F4FB5EEC734CFA")
    public void setContentLength(int contentLength) {
        {
            headers.removeAll("Content-Length");
        } 
        headers.add("Content-Length", Integer.toString(contentLength));
        this.contentLength = contentLength;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.444 -0400", hash_original_method = "DC11EC3DFE82D6B10C121117898B0E91", hash_generated_method = "496E60B2FDDD5519A4561AB71B57F978")
    public void setUserAgent(String userAgent) {
        {
            headers.removeAll("User-Agent");
        } 
        headers.add("User-Agent", userAgent);
        this.userAgent = userAgent;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.444 -0400", hash_original_method = "4B7D91EC3E8FCE0AF18D6E617B1DB541", hash_generated_method = "D9899DF3449911473AC09C9E5484D0D5")
    public void setHost(String host) {
        {
            headers.removeAll("Host");
        } 
        headers.add("Host", host);
        this.host = host;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.444 -0400", hash_original_method = "3089C76E2E8A40B02693EB13728E7CA8", hash_generated_method = "987FA60620B025A6FD4AFACD5B9FF9BE")
    public void setConnection(String connection) {
        {
            headers.removeAll("Connection");
        } 
        headers.add("Connection", connection);
        this.connection = connection;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.444 -0400", hash_original_method = "3166B34126860E43A5A770AE5259F680", hash_generated_method = "A0EEABB8BAE272D93330554EE3541856")
    public void setAcceptEncoding(String acceptEncoding) {
        {
            headers.removeAll("Accept-Encoding");
        } 
        headers.add("Accept-Encoding", acceptEncoding);
        this.acceptEncoding = acceptEncoding;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.445 -0400", hash_original_method = "F11902D80B4B7789460A90B0230527B4", hash_generated_method = "0CDB4AD100FC8114C372C03961E376AD")
    public void setContentType(String contentType) {
        {
            headers.removeAll("Content-Type");
        } 
        headers.add("Content-Type", contentType);
        this.contentType = contentType;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.445 -0400", hash_original_method = "64EEBAAA82D27C1188C64EDA1E7A0A05", hash_generated_method = "DF4520990954E1DA595A74F04F991BCA")
    public void setIfModifiedSince(Date date) {
        {
            headers.removeAll("If-Modified-Since");
        } 
        String formattedDate = HttpDate.format(date);
        headers.add("If-Modified-Since", formattedDate);
        ifModifiedSince = formattedDate;
        addTaint(date.getTaint());
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.445 -0400", hash_original_method = "E4824BE31FA5B08E01F3918FCE59BE57", hash_generated_method = "C427E25E5D5FD840D8CDE50218DF82FC")
    public void setIfNoneMatch(String ifNoneMatch) {
        {
            headers.removeAll("If-None-Match");
        } 
        headers.add("If-None-Match", ifNoneMatch);
        this.ifNoneMatch = ifNoneMatch;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.445 -0400", hash_original_method = "9FAB8376A6C98C10EDB080B222142712", hash_generated_method = "71C9DB9D701693A3519B0B7138BC3808")
    public boolean hasConditions() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_987012143 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_987012143;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.449 -0400", hash_original_method = "C85A0BA397422D1E98BAC89C6D5C00C6", hash_generated_method = "2191C397CC397E176A207D98DF0CD0A0")
    public void addCookies(Map<String, List<String>> allCookieHeaders) {
        {
            Iterator<Map.Entry<String, List<String>>> var4ABBCFEEDD6A26C4CC7635D7335E8FDA_1566952507 = (allCookieHeaders.entrySet()).iterator();
            var4ABBCFEEDD6A26C4CC7635D7335E8FDA_1566952507.hasNext();
            Map.Entry<String, List<String>> entry = var4ABBCFEEDD6A26C4CC7635D7335E8FDA_1566952507.next();
            {
                String key = entry.getKey();
                {
                    boolean varFF8A784490A70F627778704160B1BFA5_905091148 = ("Cookie".equalsIgnoreCase(key) || "Cookie2".equalsIgnoreCase(key));
                    {
                        headers.addAll(key, entry.getValue());
                    } 
                } 
            } 
        } 
        addTaint(allCookieHeaders.getTaint());
        
        
            
            
                
            
        
    }
}

