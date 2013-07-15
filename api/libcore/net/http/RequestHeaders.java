package libcore.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Map;

public final class RequestHeaders {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.658 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "DDFAECCF21F90F28142F5C866534A5C3")

    private URI uri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.659 -0400", hash_original_field = "4340FD73E75DF7A9D9E45902A59BA3A4", hash_generated_field = "534F1B0AE2D401678B9C67DE48E937E4")

    private RawHeaders headers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.659 -0400", hash_original_field = "3EDE331CCA63FAAFB68A34ACB42767C6", hash_generated_field = "5465707577DD6326819BA83CC3A7DE3E")

    private boolean noCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.659 -0400", hash_original_field = "B29571B8149006A2CE1968134C4493D4", hash_generated_field = "6AE706B03701B766A1504BFD91199E77")

    private int maxAgeSeconds = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.659 -0400", hash_original_field = "EB27223B0D697FBC5A0E3696484CEBF2", hash_generated_field = "CE7B115851142EB428D4DC9E717F3041")

    private int maxStaleSeconds = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.659 -0400", hash_original_field = "DF3895087E94DE990A4249993859153E", hash_generated_field = "086F715250E1F43550756BC1900CA699")

    private int minFreshSeconds = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.659 -0400", hash_original_field = "F491C72B7AA8BF6E23C3939D53E7D9D4", hash_generated_field = "57743485CCD77CC05F45CCC698FBC278")

    private boolean onlyIfCached;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.659 -0400", hash_original_field = "FBB6410F1A466A6B597EBD0789DC10B3", hash_generated_field = "7ED9453D363B09CB6651EDC899592357")

    private boolean hasAuthorization;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.659 -0400", hash_original_field = "23620B0ED7D2D6853307DFADB119A41C", hash_generated_field = "C51A9B467DA1E79F88DC6617E76DB248")

    private int contentLength = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.659 -0400", hash_original_field = "BF0487A5497D96D26C24936A4DAD1B2F", hash_generated_field = "53F1E445144D7EEFF13D2F87736EF02D")

    private String transferEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.659 -0400", hash_original_field = "FA71F997FA1A947459DC5495FDB40B0F", hash_generated_field = "88333D67CF65F12E18B2CCFFCF6A1193")

    private String userAgent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.660 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "6D420698033AD4B037D630A04933A2DD")

    private String host;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.660 -0400", hash_original_field = "4717D53EBFDFEA8477F780EC66151DCB", hash_generated_field = "DB0F18ED2FD7BBA4B7D89988BC77D94E")

    private String connection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.660 -0400", hash_original_field = "06F96423E5EC24DC63EB2A62F09C225E", hash_generated_field = "EE8FD96001498BFE0A0B28028AB9D38D")

    private String acceptEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.660 -0400", hash_original_field = "DF5FEAFAB86601EA0E1E6FE6E20DF6C5", hash_generated_field = "F7D06CB833C0C0295691396E4B1D1656")

    private String contentType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.660 -0400", hash_original_field = "61C0F054FFE1E91934EAEB56EE7AF160", hash_generated_field = "501F5A3170249BC588BDE376EE56533C")

    private String ifModifiedSince;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.660 -0400", hash_original_field = "7A87F2F7FF842E2E29E32BEE5A30CC0A", hash_generated_field = "09393A990220AB5E7CED6C5DBA647C56")

    private String ifNoneMatch;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.660 -0400", hash_original_field = "B61FEA397951D150206ED116095C53BC", hash_generated_field = "6C4DFB7A35D3B140FF1CF00900EC5F99")

    private String proxyAuthorization;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.662 -0400", hash_original_method = "43C01170F0D6680BF52373FD0CBCB9B1", hash_generated_method = "4674D86252DCD3882B7924CBE3BCC387")
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
for(int i = 0;i < headers.length();i++)
        {
            String fieldName = headers.getFieldName(i);
            String value = headers.getValue(i);
    if("Cache-Control".equalsIgnoreCase(fieldName))            
            {
                HeaderParser.parseCacheControl(value, handler);
            } //End block
            else
    if("Pragma".equalsIgnoreCase(fieldName))            
            {
    if(value.equalsIgnoreCase("no-cache"))                
                {
                    noCache = true;
                } //End block
            } //End block
            else
    if("If-None-Match".equalsIgnoreCase(fieldName))            
            {
                ifNoneMatch = value;
            } //End block
            else
    if("If-Modified-Since".equalsIgnoreCase(fieldName))            
            {
                ifModifiedSince = value;
            } //End block
            else
    if("Authorization".equalsIgnoreCase(fieldName))            
            {
                hasAuthorization = true;
            } //End block
            else
    if("Content-Length".equalsIgnoreCase(fieldName))            
            {
                try 
                {
                    contentLength = Integer.parseInt(value);
                } //End block
                catch (NumberFormatException ignored)
                {
                } //End block
            } //End block
            else
    if("Transfer-Encoding".equalsIgnoreCase(fieldName))            
            {
                transferEncoding = value;
            } //End block
            else
    if("User-Agent".equalsIgnoreCase(fieldName))            
            {
                userAgent = value;
            } //End block
            else
    if("Host".equalsIgnoreCase(fieldName))            
            {
                host = value;
            } //End block
            else
    if("Connection".equalsIgnoreCase(fieldName))            
            {
                connection = value;
            } //End block
            else
    if("Accept-Encoding".equalsIgnoreCase(fieldName))            
            {
                acceptEncoding = value;
            } //End block
            else
    if("Content-Type".equalsIgnoreCase(fieldName))            
            {
                contentType = value;
            } //End block
            else
    if("Proxy-Authorization".equalsIgnoreCase(fieldName))            
            {
                proxyAuthorization = value;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.664 -0400", hash_original_method = "00B64F53B1189DFD8EFC83FE9CA41E37", hash_generated_method = "3D6637C11FC555867BBCDCD6FA3E776D")
    public boolean isChunked() {
        boolean var1990FB90873D18F505D59F3D0EED154E_1666854610 = ("chunked".equalsIgnoreCase(transferEncoding));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_338567826 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_338567826;
        // ---------- Original Method ----------
        //return "chunked".equalsIgnoreCase(transferEncoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.664 -0400", hash_original_method = "0C9005E446549CA2DCD479C6BCCC6A35", hash_generated_method = "323DC9247F16377D1822A037EFE3D317")
    public boolean hasConnectionClose() {
        boolean varF2BCD5BC5E8773DEF14059362B3DF736_588483086 = ("close".equalsIgnoreCase(connection));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_288345270 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_288345270;
        // ---------- Original Method ----------
        //return "close".equalsIgnoreCase(connection);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.664 -0400", hash_original_method = "F8E205165DB0FFA5BCD89362DFA95E13", hash_generated_method = "7E50ED4EB19A68071DFA0D5F0860B493")
    public URI getUri() {
URI varD12B663A5EB2F9B068EED08B4C05ECCC_2074360343 =         uri;
        varD12B663A5EB2F9B068EED08B4C05ECCC_2074360343.addTaint(taint);
        return varD12B663A5EB2F9B068EED08B4C05ECCC_2074360343;
        // ---------- Original Method ----------
        //return uri;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.665 -0400", hash_original_method = "8B8008667EA7E940C84B2A1E4AADF211", hash_generated_method = "52698707FBB31674BC1B6343F4C838B4")
    public RawHeaders getHeaders() {
RawHeaders var6937E37BAD8D53F9D49A0E32C69A3A2C_1162859681 =         headers;
        var6937E37BAD8D53F9D49A0E32C69A3A2C_1162859681.addTaint(taint);
        return var6937E37BAD8D53F9D49A0E32C69A3A2C_1162859681;
        // ---------- Original Method ----------
        //return headers;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.665 -0400", hash_original_method = "6FC1CEF1DCDA63846245A172D489494E", hash_generated_method = "FB546F9B2E796894B632761A43298EE9")
    public boolean isNoCache() {
        boolean var3EDE331CCA63FAAFB68A34ACB42767C6_2092964010 = (noCache);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_648426965 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_648426965;
        // ---------- Original Method ----------
        //return noCache;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.665 -0400", hash_original_method = "A8F2E8C976B81B2FCD2E37C57E26B8BC", hash_generated_method = "A2084330DD7C2AA90934E9875340BDE0")
    public int getMaxAgeSeconds() {
        int var060B48DC3D605436BA3D6E7F3BA7AA44_1492889617 = (maxAgeSeconds);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_922315458 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_922315458;
        // ---------- Original Method ----------
        //return maxAgeSeconds;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.665 -0400", hash_original_method = "1283AA8CCC67672D62DEF88994766C86", hash_generated_method = "D3DADE8A33F8B599F93459E19B0EE6D8")
    public int getMaxStaleSeconds() {
        int varB5B9286F1A8339317116A0EC6DAD326A_254447114 = (maxStaleSeconds);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2088826097 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2088826097;
        // ---------- Original Method ----------
        //return maxStaleSeconds;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.666 -0400", hash_original_method = "4A1D928FA98CACC97BCF438ADC331E21", hash_generated_method = "906BB072202C97EC7F2EEEEB6E847A27")
    public int getMinFreshSeconds() {
        int var632F71630BDF37D9D918915F34E3EB04_697244736 = (minFreshSeconds);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2051586387 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2051586387;
        // ---------- Original Method ----------
        //return minFreshSeconds;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.666 -0400", hash_original_method = "C7564B78FAA65700183F7B25F17E4F9C", hash_generated_method = "F8C395EA64A0B07CDB72FC319CBEC0CB")
    public boolean isOnlyIfCached() {
        boolean varF491C72B7AA8BF6E23C3939D53E7D9D4_842675742 = (onlyIfCached);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_173470206 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_173470206;
        // ---------- Original Method ----------
        //return onlyIfCached;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.666 -0400", hash_original_method = "C62515C32B43542C8AED5B07CDF87144", hash_generated_method = "535ED038DD1FD905FE8549C89AA88E2F")
    public boolean hasAuthorization() {
        boolean varFBB6410F1A466A6B597EBD0789DC10B3_2122817021 = (hasAuthorization);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_59352583 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_59352583;
        // ---------- Original Method ----------
        //return hasAuthorization;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.667 -0400", hash_original_method = "1B52BDD2BF1D0E488CD60B58C0023743", hash_generated_method = "7389590EC76400DA5A539DD0B0A59722")
    public int getContentLength() {
        int varC22384F3ABFE57BC648B6E1701C98123_663587910 = (contentLength);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1360643039 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1360643039;
        // ---------- Original Method ----------
        //return contentLength;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.667 -0400", hash_original_method = "0DD6BAEEA01532BD95CE2FFB6DF498BA", hash_generated_method = "3616EED021C43CA6B866F76214EE7C43")
    public String getTransferEncoding() {
String varAC2737785B9D07EBCD57A9429B1591B2_682722413 =         transferEncoding;
        varAC2737785B9D07EBCD57A9429B1591B2_682722413.addTaint(taint);
        return varAC2737785B9D07EBCD57A9429B1591B2_682722413;
        // ---------- Original Method ----------
        //return transferEncoding;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.667 -0400", hash_original_method = "3896A2F0D61044E6B048D62FF1831396", hash_generated_method = "E60F96B578F577FA80A0ACA905453842")
    public String getUserAgent() {
String varB90BAE9CF13799DF66AC7440F5DAE3DA_1105179735 =         userAgent;
        varB90BAE9CF13799DF66AC7440F5DAE3DA_1105179735.addTaint(taint);
        return varB90BAE9CF13799DF66AC7440F5DAE3DA_1105179735;
        // ---------- Original Method ----------
        //return userAgent;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.667 -0400", hash_original_method = "2F2AEDD17A97DC05E80343AAC323BA28", hash_generated_method = "46E9ED69F0C9473A5160D768852287A1")
    public String getHost() {
String var872E07117C05F1A34EC24B57B694B8E3_1700413869 =         host;
        var872E07117C05F1A34EC24B57B694B8E3_1700413869.addTaint(taint);
        return var872E07117C05F1A34EC24B57B694B8E3_1700413869;
        // ---------- Original Method ----------
        //return host;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.668 -0400", hash_original_method = "B2D78684E046945E6BE853B24B15E901", hash_generated_method = "4B2784CAD0D863600BF91EA1C36D7951")
    public String getConnection() {
String var9911BB1C5F1522C1630847C40E8BC67E_1655120125 =         connection;
        var9911BB1C5F1522C1630847C40E8BC67E_1655120125.addTaint(taint);
        return var9911BB1C5F1522C1630847C40E8BC67E_1655120125;
        // ---------- Original Method ----------
        //return connection;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.668 -0400", hash_original_method = "410EE1417DB3FF49910D59AA9DB70C64", hash_generated_method = "3B3A5F418831EBD61278FF466356F62C")
    public String getAcceptEncoding() {
String varE01F2A72A06A1B398025C7E45032A16D_1469888076 =         acceptEncoding;
        varE01F2A72A06A1B398025C7E45032A16D_1469888076.addTaint(taint);
        return varE01F2A72A06A1B398025C7E45032A16D_1469888076;
        // ---------- Original Method ----------
        //return acceptEncoding;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.668 -0400", hash_original_method = "4B51DEA5FB62A221AFC62E38AC96F76E", hash_generated_method = "A51B4ECFA8CE304186EC84F8083F0EFB")
    public String getContentType() {
String var1F9BE0A83D9F0F30EFF7E238CEE615C0_827493692 =         contentType;
        var1F9BE0A83D9F0F30EFF7E238CEE615C0_827493692.addTaint(taint);
        return var1F9BE0A83D9F0F30EFF7E238CEE615C0_827493692;
        // ---------- Original Method ----------
        //return contentType;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.668 -0400", hash_original_method = "1155C704429D96DA13DD63BD82AA2AE1", hash_generated_method = "DB1EB137CDDEBFA39DE40FA0D94C6353")
    public String getIfModifiedSince() {
String var252CA485FDAA3A24A1AFC475784A7860_827182829 =         ifModifiedSince;
        var252CA485FDAA3A24A1AFC475784A7860_827182829.addTaint(taint);
        return var252CA485FDAA3A24A1AFC475784A7860_827182829;
        // ---------- Original Method ----------
        //return ifModifiedSince;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.669 -0400", hash_original_method = "94547B6348D449CB198230E7B6BBA258", hash_generated_method = "7DDDF2B68D47D97D089ED1DC74FF5D00")
    public String getIfNoneMatch() {
String var38A8254DCDAE64FBCED5C1C22CBF8D50_2107196222 =         ifNoneMatch;
        var38A8254DCDAE64FBCED5C1C22CBF8D50_2107196222.addTaint(taint);
        return var38A8254DCDAE64FBCED5C1C22CBF8D50_2107196222;
        // ---------- Original Method ----------
        //return ifNoneMatch;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.669 -0400", hash_original_method = "0FC6BE3D1567DA200B4FD09DB67F8721", hash_generated_method = "147ECF8776EF9E4EE0D404BA001B6A21")
    public String getProxyAuthorization() {
String var0C7AA8BF85EA309C0AB559E085E28DEA_2127557346 =         proxyAuthorization;
        var0C7AA8BF85EA309C0AB559E085E28DEA_2127557346.addTaint(taint);
        return var0C7AA8BF85EA309C0AB559E085E28DEA_2127557346;
        // ---------- Original Method ----------
        //return proxyAuthorization;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.669 -0400", hash_original_method = "F33F8EDA09BCA13DCC3086A1647AF7B6", hash_generated_method = "A313E67A271C5DE73445DBC16A9A9B71")
    public void setChunked() {
    if(this.transferEncoding != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.670 -0400", hash_original_method = "B694A143946FBE7D78723DAA6432C1D4", hash_generated_method = "4E3A77F848346044BA84EFF3C3B693F9")
    public void setContentLength(int contentLength) {
    if(this.contentLength != -1)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.670 -0400", hash_original_method = "DC11EC3DFE82D6B10C121117898B0E91", hash_generated_method = "5D95A767E48FE686194646C257C68EC7")
    public void setUserAgent(String userAgent) {
    if(this.userAgent != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.671 -0400", hash_original_method = "4B7D91EC3E8FCE0AF18D6E617B1DB541", hash_generated_method = "26B3693220C87FC324E0E3A0565E4DF5")
    public void setHost(String host) {
    if(this.host != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.671 -0400", hash_original_method = "3089C76E2E8A40B02693EB13728E7CA8", hash_generated_method = "861AF586BFBDEBA145D397FECC5C529E")
    public void setConnection(String connection) {
    if(this.connection != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.672 -0400", hash_original_method = "3166B34126860E43A5A770AE5259F680", hash_generated_method = "EEB343E3892D5390D804EF590CA0094B")
    public void setAcceptEncoding(String acceptEncoding) {
    if(this.acceptEncoding != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.672 -0400", hash_original_method = "F11902D80B4B7789460A90B0230527B4", hash_generated_method = "897685C7BDD7FD9EC2B888730BCC26E7")
    public void setContentType(String contentType) {
    if(this.contentType != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.673 -0400", hash_original_method = "64EEBAAA82D27C1188C64EDA1E7A0A05", hash_generated_method = "F3B048CFBD1FABD6CAF8B17DD1CD5B50")
    public void setIfModifiedSince(Date date) {
        addTaint(date.getTaint());
    if(ifModifiedSince != null)        
        {
            headers.removeAll("If-Modified-Since");
        } //End block
        String formattedDate = HttpDate.format(date);
        headers.add("If-Modified-Since", formattedDate);
        ifModifiedSince = formattedDate;
        // ---------- Original Method ----------
        //if (ifModifiedSince != null) {
            //headers.removeAll("If-Modified-Since");
        //}
        //String formattedDate = HttpDate.format(date);
        //headers.add("If-Modified-Since", formattedDate);
        //ifModifiedSince = formattedDate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.673 -0400", hash_original_method = "E4824BE31FA5B08E01F3918FCE59BE57", hash_generated_method = "A98D51D621E115CEBEB62F2195F2C1CE")
    public void setIfNoneMatch(String ifNoneMatch) {
    if(this.ifNoneMatch != null)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.673 -0400", hash_original_method = "9FAB8376A6C98C10EDB080B222142712", hash_generated_method = "6CE6068BF54484B290ECEF5B226F68ED")
    public boolean hasConditions() {
        boolean varB0CD10F76EAB253CDD7B9BA0553F3C04_1165309794 = (ifModifiedSince != null || ifNoneMatch != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1663338265 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1663338265;
        // ---------- Original Method ----------
        //return ifModifiedSince != null || ifNoneMatch != null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:16.674 -0400", hash_original_method = "C85A0BA397422D1E98BAC89C6D5C00C6", hash_generated_method = "D8536ABD54E2CD365FB4FAAEDD24950E")
    public void addCookies(Map<String, List<String>> allCookieHeaders) {
        addTaint(allCookieHeaders.getTaint());
for(Map.Entry<String, List<String>> entry : allCookieHeaders.entrySet())
        {
            String key = entry.getKey();
    if("Cookie".equalsIgnoreCase(key) || "Cookie2".equalsIgnoreCase(key))            
            {
                headers.addAll(key, entry.getValue());
            } //End block
        } //End block
        // ---------- Original Method ----------
        //for (Map.Entry<String, List<String>> entry : allCookieHeaders.entrySet()) {
            //String key = entry.getKey();
            //if ("Cookie".equalsIgnoreCase(key) || "Cookie2".equalsIgnoreCase(key)) {
                //headers.addAll(key, entry.getValue());
            //}
        //}
    }

    
}

