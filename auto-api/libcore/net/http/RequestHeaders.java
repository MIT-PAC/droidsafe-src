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
    private URI uri;
    private RawHeaders headers;
    private boolean noCache;
    private int maxAgeSeconds = -1;
    private int maxStaleSeconds = -1;
    private int minFreshSeconds = -1;
    private boolean onlyIfCached;
    private boolean hasAuthorization;
    private int contentLength = -1;
    private String transferEncoding;
    private String userAgent;
    private String host;
    private String connection;
    private String acceptEncoding;
    private String contentType;
    private String ifModifiedSince;
    private String ifNoneMatch;
    private String proxyAuthorization;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.447 -0400", hash_original_method = "43C01170F0D6680BF52373FD0CBCB9B1", hash_generated_method = "5871C8B38FBAF18BF899D620401B8FCC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RequestHeaders(URI uri, RawHeaders headers) {
        dsTaint.addTaint(headers.dsTaint);
        dsTaint.addTaint(uri.dsTaint);
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
            boolean var160466EB7D7D5C6ABB8E6B06A85E2B1F_1991149205 = (i < headers.length());
            {
                String fieldName;
                fieldName = headers.getFieldName(i);
                String value;
                value = headers.getValue(i);
                {
                    boolean varD77C8259EAFC94FDC3D657C8834E9487_299583639 = ("Cache-Control".equalsIgnoreCase(fieldName));
                    {
                        HeaderParser.parseCacheControl(value, handler);
                    } //End block
                    {
                        boolean var56F25C5265F567B26213F2536EF32AC1_573991080 = ("Pragma".equalsIgnoreCase(fieldName));
                        {
                            {
                                boolean var43BD107A6E901C7747CCE7BFBB8DD07E_1438494830 = (value.equalsIgnoreCase("no-cache"));
                                {
                                    noCache = true;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            boolean var8DAE09CD6FB1152EE1004A7A7A8CE5E0_1393780279 = ("If-None-Match".equalsIgnoreCase(fieldName));
                            {
                                ifNoneMatch = value;
                            } //End block
                            {
                                boolean varB088D15F96093D53CB7FE5B7CC0836F4_1979355616 = ("If-Modified-Since".equalsIgnoreCase(fieldName));
                                {
                                    ifModifiedSince = value;
                                } //End block
                                {
                                    boolean varC67E0A5BE37C2BCADE7BD8E8FBD99D7C_531119304 = ("Authorization".equalsIgnoreCase(fieldName));
                                    {
                                        hasAuthorization = true;
                                    } //End block
                                    {
                                        boolean var83FEBE437E90CCE4FDE377518B344B6F_739525844 = ("Content-Length".equalsIgnoreCase(fieldName));
                                        {
                                            try 
                                            {
                                                contentLength = Integer.parseInt(value);
                                            } //End block
                                            catch (NumberFormatException ignored)
                                            { }
                                        } //End block
                                        {
                                            boolean varFEB01C2A2FAB43A71ACF71F602A1E7B8_647414246 = ("Transfer-Encoding".equalsIgnoreCase(fieldName));
                                            {
                                                transferEncoding = value;
                                            } //End block
                                            {
                                                boolean var26CB77545109E7877658F31017118009_1111413760 = ("User-Agent".equalsIgnoreCase(fieldName));
                                                {
                                                    userAgent = value;
                                                } //End block
                                                {
                                                    boolean var91F34C4C3A2BB00AFC6A87F65E9909E1_1782723835 = ("Host".equalsIgnoreCase(fieldName));
                                                    {
                                                        host = value;
                                                    } //End block
                                                    {
                                                        boolean varA2563F9A072AFEA1AC1CD72AE8BD1A4E_1057082745 = ("Connection".equalsIgnoreCase(fieldName));
                                                        {
                                                            connection = value;
                                                        } //End block
                                                        {
                                                            boolean var6D5B3BEE656FBD0AF9E0BE01F11D009B_1207343570 = ("Accept-Encoding".equalsIgnoreCase(fieldName));
                                                            {
                                                                acceptEncoding = value;
                                                            } //End block
                                                            {
                                                                boolean var426283D7FE1D047628A22BB787AE0450_231552458 = ("Content-Type".equalsIgnoreCase(fieldName));
                                                                {
                                                                    contentType = value;
                                                                } //End block
                                                                {
                                                                    boolean varE9641B340B6E4D94EEAB0A00C194975F_845180362 = ("Proxy-Authorization".equalsIgnoreCase(fieldName));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.447 -0400", hash_original_method = "00B64F53B1189DFD8EFC83FE9CA41E37", hash_generated_method = "5BBA0B90D9FAFEBBFF8E3507E28B4F6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isChunked() {
        boolean varA16BCACE603C83FBCA10B7C6B1A17953_1132626700 = ("chunked".equalsIgnoreCase(transferEncoding));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return "chunked".equalsIgnoreCase(transferEncoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.447 -0400", hash_original_method = "0C9005E446549CA2DCD479C6BCCC6A35", hash_generated_method = "4C35760F819B9CD222602F01CC6547D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasConnectionClose() {
        boolean var81EEBB6E2271640A61DE6C091C411E9C_1957502366 = ("close".equalsIgnoreCase(connection));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return "close".equalsIgnoreCase(connection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.448 -0400", hash_original_method = "F8E205165DB0FFA5BCD89362DFA95E13", hash_generated_method = "CAAD0265727026E42057C7BCE517B59B")
    @DSModeled(DSC.SAFE)
    public URI getUri() {
        return (URI)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return uri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.448 -0400", hash_original_method = "8B8008667EA7E940C84B2A1E4AADF211", hash_generated_method = "91D9B9F7B36389F05554D9B4DE89DAD8")
    @DSModeled(DSC.SAFE)
    public RawHeaders getHeaders() {
        return (RawHeaders)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return headers;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.448 -0400", hash_original_method = "6FC1CEF1DCDA63846245A172D489494E", hash_generated_method = "D1F65CA1B4A55A8E1CE6A321D63E615C")
    @DSModeled(DSC.SAFE)
    public boolean isNoCache() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return noCache;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.448 -0400", hash_original_method = "A8F2E8C976B81B2FCD2E37C57E26B8BC", hash_generated_method = "8BA69AF453FE5D1E1BF7158A2ABCAD93")
    @DSModeled(DSC.SAFE)
    public int getMaxAgeSeconds() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return maxAgeSeconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.448 -0400", hash_original_method = "1283AA8CCC67672D62DEF88994766C86", hash_generated_method = "AB7F07372DF1899047770993F7D2D99A")
    @DSModeled(DSC.SAFE)
    public int getMaxStaleSeconds() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return maxStaleSeconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.448 -0400", hash_original_method = "4A1D928FA98CACC97BCF438ADC331E21", hash_generated_method = "392D4548E3CC1DB15251FB3138E3D483")
    @DSModeled(DSC.SAFE)
    public int getMinFreshSeconds() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return minFreshSeconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.449 -0400", hash_original_method = "C7564B78FAA65700183F7B25F17E4F9C", hash_generated_method = "7D57A43D6AC99DFD1D75FED99462B79C")
    @DSModeled(DSC.SAFE)
    public boolean isOnlyIfCached() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return onlyIfCached;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.449 -0400", hash_original_method = "C62515C32B43542C8AED5B07CDF87144", hash_generated_method = "9A3A086CD9426027CBFF5BE8AB03AC19")
    @DSModeled(DSC.SAFE)
    public boolean hasAuthorization() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return hasAuthorization;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.449 -0400", hash_original_method = "1B52BDD2BF1D0E488CD60B58C0023743", hash_generated_method = "72FABB692620F0ACFDCF6F51DF11F0A6")
    @DSModeled(DSC.SAFE)
    public int getContentLength() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return contentLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.449 -0400", hash_original_method = "0DD6BAEEA01532BD95CE2FFB6DF498BA", hash_generated_method = "244F2941785C628BF0F8694685C07053")
    @DSModeled(DSC.SAFE)
    public String getTransferEncoding() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return transferEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.449 -0400", hash_original_method = "3896A2F0D61044E6B048D62FF1831396", hash_generated_method = "7E84169B3A317857870EA040641A708C")
    @DSModeled(DSC.SAFE)
    public String getUserAgent() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return userAgent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.449 -0400", hash_original_method = "2F2AEDD17A97DC05E80343AAC323BA28", hash_generated_method = "5963FFD88478AF2B93ECD8C406035DCE")
    @DSModeled(DSC.SAFE)
    public String getHost() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.450 -0400", hash_original_method = "B2D78684E046945E6BE853B24B15E901", hash_generated_method = "73507F45539D20AC61D9DC6B62F252A5")
    @DSModeled(DSC.SAFE)
    public String getConnection() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return connection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.450 -0400", hash_original_method = "410EE1417DB3FF49910D59AA9DB70C64", hash_generated_method = "65CE021FCC0BD8710CCE7453BFC08047")
    @DSModeled(DSC.SAFE)
    public String getAcceptEncoding() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return acceptEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.450 -0400", hash_original_method = "4B51DEA5FB62A221AFC62E38AC96F76E", hash_generated_method = "8E41FB7BF6AA7CDC0A3F13D50D011EF3")
    @DSModeled(DSC.SAFE)
    public String getContentType() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return contentType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.450 -0400", hash_original_method = "1155C704429D96DA13DD63BD82AA2AE1", hash_generated_method = "948220895BC504527D73D944FA353FA3")
    @DSModeled(DSC.SAFE)
    public String getIfModifiedSince() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return ifModifiedSince;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.450 -0400", hash_original_method = "94547B6348D449CB198230E7B6BBA258", hash_generated_method = "4A2BEB470E1B54F38EC9C96596E98B7D")
    @DSModeled(DSC.SAFE)
    public String getIfNoneMatch() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return ifNoneMatch;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.450 -0400", hash_original_method = "0FC6BE3D1567DA200B4FD09DB67F8721", hash_generated_method = "65F095563AED95733FF245A5DECC32AD")
    @DSModeled(DSC.SAFE)
    public String getProxyAuthorization() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return proxyAuthorization;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.451 -0400", hash_original_method = "F33F8EDA09BCA13DCC3086A1647AF7B6", hash_generated_method = "E6960D9F60ED956BE541131B3F1B8283")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.451 -0400", hash_original_method = "B694A143946FBE7D78723DAA6432C1D4", hash_generated_method = "C26865826340BDD8F41C15521461BBDE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setContentLength(int contentLength) {
        dsTaint.addTaint(contentLength);
        {
            headers.removeAll("Content-Length");
        } //End block
        headers.add("Content-Length", Integer.toString(contentLength));
        // ---------- Original Method ----------
        //if (this.contentLength != -1) {
            //headers.removeAll("Content-Length");
        //}
        //headers.add("Content-Length", Integer.toString(contentLength));
        //this.contentLength = contentLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.451 -0400", hash_original_method = "DC11EC3DFE82D6B10C121117898B0E91", hash_generated_method = "51660EB56A2B0B35221FB541331B1BFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setUserAgent(String userAgent) {
        dsTaint.addTaint(userAgent);
        {
            headers.removeAll("User-Agent");
        } //End block
        headers.add("User-Agent", userAgent);
        // ---------- Original Method ----------
        //if (this.userAgent != null) {
            //headers.removeAll("User-Agent");
        //}
        //headers.add("User-Agent", userAgent);
        //this.userAgent = userAgent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.451 -0400", hash_original_method = "4B7D91EC3E8FCE0AF18D6E617B1DB541", hash_generated_method = "397CFD44F357522DB8932B922438437C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setHost(String host) {
        dsTaint.addTaint(host);
        {
            headers.removeAll("Host");
        } //End block
        headers.add("Host", host);
        // ---------- Original Method ----------
        //if (this.host != null) {
            //headers.removeAll("Host");
        //}
        //headers.add("Host", host);
        //this.host = host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.452 -0400", hash_original_method = "3089C76E2E8A40B02693EB13728E7CA8", hash_generated_method = "0C6C4FD688A0D58E5A354CDA0FCD5C12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setConnection(String connection) {
        dsTaint.addTaint(connection);
        {
            headers.removeAll("Connection");
        } //End block
        headers.add("Connection", connection);
        // ---------- Original Method ----------
        //if (this.connection != null) {
            //headers.removeAll("Connection");
        //}
        //headers.add("Connection", connection);
        //this.connection = connection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.452 -0400", hash_original_method = "3166B34126860E43A5A770AE5259F680", hash_generated_method = "265489AAC131A81B2314554741E51503")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAcceptEncoding(String acceptEncoding) {
        dsTaint.addTaint(acceptEncoding);
        {
            headers.removeAll("Accept-Encoding");
        } //End block
        headers.add("Accept-Encoding", acceptEncoding);
        // ---------- Original Method ----------
        //if (this.acceptEncoding != null) {
            //headers.removeAll("Accept-Encoding");
        //}
        //headers.add("Accept-Encoding", acceptEncoding);
        //this.acceptEncoding = acceptEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.452 -0400", hash_original_method = "F11902D80B4B7789460A90B0230527B4", hash_generated_method = "261A0587427475427E6941F8B7049EB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setContentType(String contentType) {
        dsTaint.addTaint(contentType);
        {
            headers.removeAll("Content-Type");
        } //End block
        headers.add("Content-Type", contentType);
        // ---------- Original Method ----------
        //if (this.contentType != null) {
            //headers.removeAll("Content-Type");
        //}
        //headers.add("Content-Type", contentType);
        //this.contentType = contentType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.452 -0400", hash_original_method = "64EEBAAA82D27C1188C64EDA1E7A0A05", hash_generated_method = "10DE4A85C683082A64CC809A279B4E15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIfModifiedSince(Date date) {
        dsTaint.addTaint(date.dsTaint);
        {
            headers.removeAll("If-Modified-Since");
        } //End block
        String formattedDate;
        formattedDate = HttpDate.format(date);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.452 -0400", hash_original_method = "E4824BE31FA5B08E01F3918FCE59BE57", hash_generated_method = "52C3CD68C7578CACB8106CE248C8346C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIfNoneMatch(String ifNoneMatch) {
        dsTaint.addTaint(ifNoneMatch);
        {
            headers.removeAll("If-None-Match");
        } //End block
        headers.add("If-None-Match", ifNoneMatch);
        // ---------- Original Method ----------
        //if (this.ifNoneMatch != null) {
            //headers.removeAll("If-None-Match");
        //}
        //headers.add("If-None-Match", ifNoneMatch);
        //this.ifNoneMatch = ifNoneMatch;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.453 -0400", hash_original_method = "9FAB8376A6C98C10EDB080B222142712", hash_generated_method = "2653B9B0635293F73A12BD7735B5B069")
    @DSModeled(DSC.SAFE)
    public boolean hasConditions() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ifModifiedSince != null || ifNoneMatch != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.456 -0400", hash_original_method = "C85A0BA397422D1E98BAC89C6D5C00C6", hash_generated_method = "5136E738BBB466366C14C1DA29F67881")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addCookies(Map<String, List<String>> allCookieHeaders) {
        dsTaint.addTaint(allCookieHeaders.dsTaint);
        {
            Iterator<Map.Entry<String, List<String>>> var4ABBCFEEDD6A26C4CC7635D7335E8FDA_765045440 = (allCookieHeaders.entrySet()).iterator();
            var4ABBCFEEDD6A26C4CC7635D7335E8FDA_765045440.hasNext();
            Map.Entry<String, List<String>> entry = var4ABBCFEEDD6A26C4CC7635D7335E8FDA_765045440.next();
            {
                String key;
                key = entry.getKey();
                {
                    boolean varFF8A784490A70F627778704160B1BFA5_431320183 = ("Cookie".equalsIgnoreCase(key) || "Cookie2".equalsIgnoreCase(key));
                    {
                        headers.addAll(key, entry.getValue());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (Map.Entry<String, List<String>> entry : allCookieHeaders.entrySet()) {
            //String key = entry.getKey();
            //if ("Cookie".equalsIgnoreCase(key) || "Cookie2".equalsIgnoreCase(key)) {
                //headers.addAll(key, entry.getValue());
            //}
        //}
    }

    
}

