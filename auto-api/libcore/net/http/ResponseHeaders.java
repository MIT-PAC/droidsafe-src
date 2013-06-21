package libcore.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import libcore.util.Objects;

public final class ResponseHeaders {
    private URI uri;
    private RawHeaders headers;
    private Date servedDate;
    private Date lastModified;
    private Date expires;
    private long sentRequestMillis;
    private long receivedResponseMillis;
    private boolean noCache;
    private boolean noStore;
    private int maxAgeSeconds = -1;
    private int sMaxAgeSeconds = -1;
    private boolean isPublic;
    private boolean mustRevalidate;
    private String etag;
    private int ageSeconds = -1;
    private Set<String> varyFields = Collections.emptySet();
    private String contentEncoding;
    private String transferEncoding;
    private int contentLength = -1;
    private String connection;
    private String proxyAuthenticate;
    private String wwwAuthenticate;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.547 -0400", hash_original_method = "DB24454BC912323B5FCB6CCA35CD9240", hash_generated_method = "04EBEC48E9678489A657052C2B79C848")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ResponseHeaders(URI uri, RawHeaders headers) {
        dsTaint.addTaint(headers.dsTaint);
        dsTaint.addTaint(uri.dsTaint);
        HeaderParser.CacheControlHandler handler;
        handler = new HeaderParser.CacheControlHandler() {
            @Override public void handle(String directive, String parameter) {
                if (directive.equalsIgnoreCase("no-cache")) {
                    noCache = true;
                } else if (directive.equalsIgnoreCase("no-store")) {
                    noStore = true;
                } else if (directive.equalsIgnoreCase("max-age")) {
                    maxAgeSeconds = HeaderParser.parseSeconds(parameter);
                } else if (directive.equalsIgnoreCase("s-maxage")) {
                    sMaxAgeSeconds = HeaderParser.parseSeconds(parameter);
                } else if (directive.equalsIgnoreCase("public")) {
                    isPublic = true;
                } else if (directive.equalsIgnoreCase("must-revalidate")) {
                    mustRevalidate = true;
                }
            }
        };
        {
            int i;
            i = 0;
            boolean var160466EB7D7D5C6ABB8E6B06A85E2B1F_2018724708 = (i < headers.length());
            {
                String fieldName;
                fieldName = headers.getFieldName(i);
                String value;
                value = headers.getValue(i);
                {
                    boolean varD77C8259EAFC94FDC3D657C8834E9487_265021359 = ("Cache-Control".equalsIgnoreCase(fieldName));
                    {
                        HeaderParser.parseCacheControl(value, handler);
                    } //End block
                    {
                        boolean varCD2F40E0A98D4A2889CEF7D95E8C27B6_322638119 = ("Date".equalsIgnoreCase(fieldName));
                        {
                            servedDate = HttpDate.parse(value);
                        } //End block
                        {
                            boolean varFF31A566C873782CB1B6419F2EA65B9B_824513759 = ("Expires".equalsIgnoreCase(fieldName));
                            {
                                expires = HttpDate.parse(value);
                            } //End block
                            {
                                boolean varF822263BF24EE652AEAC401809AA6D16_2058054991 = ("Last-Modified".equalsIgnoreCase(fieldName));
                                {
                                    lastModified = HttpDate.parse(value);
                                } //End block
                                {
                                    boolean varF8CE2CB6DBD80B918C5E86CA7C93086E_520682129 = ("ETag".equalsIgnoreCase(fieldName));
                                    {
                                        etag = value;
                                    } //End block
                                    {
                                        boolean varF67FD1E33B33C098C7C18DAC1CAB54CA_98652547 = ("Pragma".equalsIgnoreCase(fieldName));
                                        {
                                            {
                                                boolean varBF5A1C7105ABE0EE086840F1E4D55F8F_1801793515 = (value.equalsIgnoreCase("no-cache"));
                                                {
                                                    noCache = true;
                                                } //End block
                                            } //End collapsed parenthetic
                                        } //End block
                                        {
                                            boolean var99A7D647B7FD011AD12776CEEB4CB8E4_1844763710 = ("Age".equalsIgnoreCase(fieldName));
                                            {
                                                ageSeconds = HeaderParser.parseSeconds(value);
                                            } //End block
                                            {
                                                boolean var612924547FC43DA2310DC180CE3DB55D_186144442 = ("Vary".equalsIgnoreCase(fieldName));
                                                {
                                                    {
                                                        boolean var17D81E0032232EA0EDAFB415443EF53C_1944934534 = (varyFields.isEmpty());
                                                        {
                                                            varyFields = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
                                                        } //End block
                                                    } //End collapsed parenthetic
                                                    {
                                                        Iterator<String> var154416020BE200D943446034B260BA51_746887860 = (value.split(",")).iterator();
                                                        var154416020BE200D943446034B260BA51_746887860.hasNext();
                                                        String varyField = var154416020BE200D943446034B260BA51_746887860.next();
                                                        {
                                                            varyFields.add(varyField.trim());
                                                        } //End block
                                                    } //End collapsed parenthetic
                                                } //End block
                                                {
                                                    boolean varEEEFC20C1240BBA2C8B42C2F114E2C2A_218477292 = ("Content-Encoding".equalsIgnoreCase(fieldName));
                                                    {
                                                        contentEncoding = value;
                                                    } //End block
                                                    {
                                                        boolean varA366C7C732EE22377F02D6DB49D33763_2078149309 = ("Transfer-Encoding".equalsIgnoreCase(fieldName));
                                                        {
                                                            transferEncoding = value;
                                                        } //End block
                                                        {
                                                            boolean var4E5AA53DFDC181F206D0324535D36C6E_1107207113 = ("Content-Length".equalsIgnoreCase(fieldName));
                                                            {
                                                                try 
                                                                {
                                                                    contentLength = Integer.parseInt(value);
                                                                } //End block
                                                                catch (NumberFormatException ignored)
                                                                { }
                                                            } //End block
                                                            {
                                                                boolean var5C79FBE6D9AF7B34CADBD78E33DD3307_2118869914 = ("Connection".equalsIgnoreCase(fieldName));
                                                                {
                                                                    connection = value;
                                                                } //End block
                                                                {
                                                                    boolean varED6BC7458920C777A36871BDDC3FC8DD_427995186 = ("Proxy-Authenticate".equalsIgnoreCase(fieldName));
                                                                    {
                                                                        proxyAuthenticate = value;
                                                                    } //End block
                                                                    {
                                                                        boolean var62B7EE9803087906A523F2C6F7F108AF_980698464 = ("WWW-Authenticate".equalsIgnoreCase(fieldName));
                                                                        {
                                                                            wwwAuthenticate = value;
                                                                        } //End block
                                                                        {
                                                                            boolean var7282ECC69B104D2DF8853E528D50BFCD_583437949 = (SENT_MILLIS.equalsIgnoreCase(fieldName));
                                                                            {
                                                                                sentRequestMillis = Long.parseLong(value);
                                                                            } //End block
                                                                            {
                                                                                boolean var9A941839153BEAB247C8984F1B4249AA_1023608692 = (RECEIVED_MILLIS.equalsIgnoreCase(fieldName));
                                                                                {
                                                                                    receivedResponseMillis = Long.parseLong(value);
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
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.547 -0400", hash_original_method = "796365D0FCCA6BD674FA822FBE40C059", hash_generated_method = "99E08EB3A5AE86D289FC5AC77DD2D705")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isContentEncodingGzip() {
        boolean varC0E28EA1539FF174C033FE8D4327D4D0_78375092 = ("gzip".equalsIgnoreCase(contentEncoding));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return "gzip".equalsIgnoreCase(contentEncoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.548 -0400", hash_original_method = "AD1C758BD3B96983B4362B4ECCA164D6", hash_generated_method = "E13F95E67AAC2117E89E0EFDCED90CA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void stripContentEncoding() {
        contentEncoding = null;
        headers.removeAll("Content-Encoding");
        // ---------- Original Method ----------
        //contentEncoding = null;
        //headers.removeAll("Content-Encoding");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.548 -0400", hash_original_method = "00B64F53B1189DFD8EFC83FE9CA41E37", hash_generated_method = "D00BADC21C9DABE7A147A7D6506E9769")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isChunked() {
        boolean varA16BCACE603C83FBCA10B7C6B1A17953_884052118 = ("chunked".equalsIgnoreCase(transferEncoding));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return "chunked".equalsIgnoreCase(transferEncoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.548 -0400", hash_original_method = "0C9005E446549CA2DCD479C6BCCC6A35", hash_generated_method = "5040B9D8B722BBF3564736A08D18EBA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasConnectionClose() {
        boolean var81EEBB6E2271640A61DE6C091C411E9C_80485265 = ("close".equalsIgnoreCase(connection));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return "close".equalsIgnoreCase(connection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.548 -0400", hash_original_method = "F8E205165DB0FFA5BCD89362DFA95E13", hash_generated_method = "CAAD0265727026E42057C7BCE517B59B")
    @DSModeled(DSC.SAFE)
    public URI getUri() {
        return (URI)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return uri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.548 -0400", hash_original_method = "8B8008667EA7E940C84B2A1E4AADF211", hash_generated_method = "91D9B9F7B36389F05554D9B4DE89DAD8")
    @DSModeled(DSC.SAFE)
    public RawHeaders getHeaders() {
        return (RawHeaders)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return headers;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.548 -0400", hash_original_method = "F90446E53D3AF5BE7BA6FACCF3504208", hash_generated_method = "783BAB89C6FA6181DDBDBCFD772C3C4E")
    @DSModeled(DSC.SAFE)
    public Date getServedDate() {
        return (Date)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return servedDate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.549 -0400", hash_original_method = "B44D0D5D3FBE8A04568E9D9F3E9708AC", hash_generated_method = "3D9989AD7BA40C4178166C9996F4806B")
    @DSModeled(DSC.SAFE)
    public Date getLastModified() {
        return (Date)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return lastModified;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.549 -0400", hash_original_method = "D14D02C8B70C044F75369CCEC64D849F", hash_generated_method = "0766EB3A124EEAE05B05273BEFCB349A")
    @DSModeled(DSC.SAFE)
    public Date getExpires() {
        return (Date)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return expires;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.549 -0400", hash_original_method = "6FC1CEF1DCDA63846245A172D489494E", hash_generated_method = "D1F65CA1B4A55A8E1CE6A321D63E615C")
    @DSModeled(DSC.SAFE)
    public boolean isNoCache() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return noCache;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.549 -0400", hash_original_method = "41C92D037056676770FDD2CB72F93600", hash_generated_method = "5D50F8633257EE5E60E0993FF8B9F766")
    @DSModeled(DSC.SAFE)
    public boolean isNoStore() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return noStore;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.549 -0400", hash_original_method = "A8F2E8C976B81B2FCD2E37C57E26B8BC", hash_generated_method = "8BA69AF453FE5D1E1BF7158A2ABCAD93")
    @DSModeled(DSC.SAFE)
    public int getMaxAgeSeconds() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return maxAgeSeconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.549 -0400", hash_original_method = "E2E5751856DD8B4562FF25B8FB1901CF", hash_generated_method = "7EB0F9E3359FAA207B474708440BD736")
    @DSModeled(DSC.SAFE)
    public int getSMaxAgeSeconds() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return sMaxAgeSeconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.549 -0400", hash_original_method = "5C207DA5362424777671E2427CD32289", hash_generated_method = "A67EAEC2D80E21AD100D87235A43FB9A")
    @DSModeled(DSC.SAFE)
    public boolean isPublic() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isPublic;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.549 -0400", hash_original_method = "E05A87C935BB761C11F60283BED9A93A", hash_generated_method = "8CA7B40C7C9AF725288B2F05EA17CA5D")
    @DSModeled(DSC.SAFE)
    public boolean isMustRevalidate() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mustRevalidate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.550 -0400", hash_original_method = "2F22856D0A054825BF540D28FE4EB44E", hash_generated_method = "217052B056B03E257190192EE00F10EE")
    @DSModeled(DSC.SAFE)
    public String getEtag() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return etag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.550 -0400", hash_original_method = "C8C00D8A1144BBC8C8A6E2EAAA43E379", hash_generated_method = "B922BCDD95D118E220823E01A57E8288")
    @DSModeled(DSC.SAFE)
    public Set<String> getVaryFields() {
        return (Set<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return varyFields;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.550 -0400", hash_original_method = "801F0D0C73EEE64E68A729BCCDAD74D7", hash_generated_method = "704B84FBBE477A3F8F3B8A9F3EFCEBD6")
    @DSModeled(DSC.SAFE)
    public String getContentEncoding() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return contentEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.550 -0400", hash_original_method = "1B52BDD2BF1D0E488CD60B58C0023743", hash_generated_method = "72FABB692620F0ACFDCF6F51DF11F0A6")
    @DSModeled(DSC.SAFE)
    public int getContentLength() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return contentLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.550 -0400", hash_original_method = "B2D78684E046945E6BE853B24B15E901", hash_generated_method = "73507F45539D20AC61D9DC6B62F252A5")
    @DSModeled(DSC.SAFE)
    public String getConnection() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return connection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.550 -0400", hash_original_method = "BA8A66BA629083526749CA96982906E0", hash_generated_method = "0B73AC9DD0653086E0E5D172026ECB00")
    @DSModeled(DSC.SAFE)
    public String getProxyAuthenticate() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return proxyAuthenticate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.550 -0400", hash_original_method = "9336A6C75F9FBB86806462CCF41FEBB3", hash_generated_method = "2B09068ED31BAB4AF6CA3338FFB7442C")
    @DSModeled(DSC.SAFE)
    public String getWwwAuthenticate() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return wwwAuthenticate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.551 -0400", hash_original_method = "22FEE68D81D5D179ED2595CC992792BF", hash_generated_method = "722EAFA4CC0F3DF58EDECB64BBEC3594")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setLocalTimestamps(long sentRequestMillis, long receivedResponseMillis) {
        dsTaint.addTaint(receivedResponseMillis);
        dsTaint.addTaint(sentRequestMillis);
        headers.add(SENT_MILLIS, Long.toString(sentRequestMillis));
        headers.add(RECEIVED_MILLIS, Long.toString(receivedResponseMillis));
        // ---------- Original Method ----------
        //this.sentRequestMillis = sentRequestMillis;
        //headers.add(SENT_MILLIS, Long.toString(sentRequestMillis));
        //this.receivedResponseMillis = receivedResponseMillis;
        //headers.add(RECEIVED_MILLIS, Long.toString(receivedResponseMillis));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.551 -0400", hash_original_method = "62B4E508B2BD1FD8674C188E31D3FA94", hash_generated_method = "971AB1A3665C590A81D32E5BD38BA6C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private long computeAge(long nowMillis) {
        dsTaint.addTaint(nowMillis);
        long apparentReceivedAge;
        apparentReceivedAge = Math.max(0, receivedResponseMillis - servedDate.getTime());
        apparentReceivedAge = 0;
        long receivedAge;
        receivedAge = Math.max(apparentReceivedAge, TimeUnit.SECONDS.toMillis(ageSeconds));
        receivedAge = apparentReceivedAge;
        long responseDuration;
        responseDuration = receivedResponseMillis - sentRequestMillis;
        long residentDuration;
        residentDuration = nowMillis - receivedResponseMillis;
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //long apparentReceivedAge = servedDate != null
                //? Math.max(0, receivedResponseMillis - servedDate.getTime())
                //: 0;
        //long receivedAge = ageSeconds != -1
                //? Math.max(apparentReceivedAge, TimeUnit.SECONDS.toMillis(ageSeconds))
                //: apparentReceivedAge;
        //long responseDuration = receivedResponseMillis - sentRequestMillis;
        //long residentDuration = nowMillis - receivedResponseMillis;
        //return receivedAge + responseDuration + residentDuration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.551 -0400", hash_original_method = "723583A81B93D8753154A40B95765CF8", hash_generated_method = "168FEF9EC742102CBDFA8B7B48D8CBA9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private long computeFreshnessLifetime() {
        {
            long varE87156FA27F9CF79D97CBA7040DC6B66_515971986 = (TimeUnit.SECONDS.toMillis(maxAgeSeconds));
        } //End block
        {
            long servedMillis;
            servedMillis = servedDate.getTime();
            servedMillis = receivedResponseMillis;
            long delta;
            delta = expires.getTime() - servedMillis;
        } //End block
        {
            boolean var9B1D6757A89860DA2B5EAB9B5FBCE1D5_528376566 = (lastModified != null && uri.getRawQuery() == null);
            {
                long servedMillis;
                servedMillis = servedDate.getTime();
                servedMillis = sentRequestMillis;
                long delta;
                delta = servedMillis - lastModified.getTime();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if (maxAgeSeconds != -1) {
            //return TimeUnit.SECONDS.toMillis(maxAgeSeconds);
        //} else if (expires != null) {
            //long servedMillis = servedDate != null ? servedDate.getTime() : receivedResponseMillis;
            //long delta = expires.getTime() - servedMillis;
            //return delta > 0 ? delta : 0;
        //} else if (lastModified != null && uri.getRawQuery() == null) {
            //long servedMillis = servedDate != null ? servedDate.getTime() : sentRequestMillis;
            //long delta = servedMillis - lastModified.getTime();
            //return delta > 0 ? (delta / 10) : 0;
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.551 -0400", hash_original_method = "8F28A3C0281B6F16DECF00092A03388F", hash_generated_method = "A671F0A6AB615070BB9D503F40E348A2")
    @DSModeled(DSC.SAFE)
    private boolean isFreshnessLifetimeHeuristic() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return maxAgeSeconds == -1 && expires == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.552 -0400", hash_original_method = "E402151342DE994EEE4FC3989E09156E", hash_generated_method = "2F2068401834FB4226CB9C4A448BEEAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isCacheable(RequestHeaders request) {
        dsTaint.addTaint(request.dsTaint);
        int responseCode;
        responseCode = headers.getResponseCode();
        {
            boolean varE24C55697985C1233F502262CD22E5D4_1136433735 = (request.hasAuthorization()
                && !isPublic
                && !mustRevalidate
                && sMaxAgeSeconds == -1);
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int responseCode = headers.getResponseCode();
        //if (responseCode != HttpURLConnection.HTTP_OK
                //&& responseCode != HttpURLConnection.HTTP_NOT_AUTHORITATIVE
                //&& responseCode != HttpURLConnection.HTTP_MULT_CHOICE
                //&& responseCode != HttpURLConnection.HTTP_MOVED_PERM
                //&& responseCode != HttpURLConnection.HTTP_GONE) {
            //return false;
        //}
        //if (request.hasAuthorization()
                //&& !isPublic
                //&& !mustRevalidate
                //&& sMaxAgeSeconds == -1) {
            //return false;
        //}
        //if (noStore) {
            //return false;
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.552 -0400", hash_original_method = "937D0115F7BB3894701032373C9A4BC7", hash_generated_method = "1A7F6DECE5763CC601959507C5DD36DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasVaryAll() {
        boolean varC738253CEA254131A804BC3CB6A34FC1_1896289028 = (varyFields.contains("*"));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return varyFields.contains("*");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.555 -0400", hash_original_method = "AE2D57CEA29D6AAD43D079D6A743C143", hash_generated_method = "369FD12350F796E92897C8978DA98449")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean varyMatches(Map<String, List<String>> cachedRequest,
            Map<String, List<String>> newRequest) {
        dsTaint.addTaint(cachedRequest.dsTaint);
        dsTaint.addTaint(newRequest.dsTaint);
        {
            Iterator<String> varC1185F1BCBF99AA0F507E14EFA1E99A9_1696407345 = (varyFields).iterator();
            varC1185F1BCBF99AA0F507E14EFA1E99A9_1696407345.hasNext();
            String field = varC1185F1BCBF99AA0F507E14EFA1E99A9_1696407345.next();
            {
                {
                    boolean var757B3024B7F14E3064F0E604913C8246_463820194 = (!Objects.equal(cachedRequest.get(field), newRequest.get(field)));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //for (String field : varyFields) {
            //if (!Objects.equal(cachedRequest.get(field), newRequest.get(field))) {
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.556 -0400", hash_original_method = "564BBC9A8CA0CE268623CE0DAE1CD407", hash_generated_method = "F024196F285EA618C7AF700DC395609A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ResponseSource chooseResponseSource(long nowMillis, RequestHeaders request) {
        dsTaint.addTaint(request.dsTaint);
        dsTaint.addTaint(nowMillis);
        {
            boolean var7012CA4B5F50B57A637C81F78E278477_899070788 = (!isCacheable(request));
        } //End collapsed parenthetic
        {
            boolean var183378DFF7F1E73CE42B495ED68511EB_1836670214 = (request.isNoCache() || request.hasConditions());
        } //End collapsed parenthetic
        long ageMillis;
        ageMillis = computeAge(nowMillis);
        long freshMillis;
        freshMillis = computeFreshnessLifetime();
        {
            boolean varFA1EF6C3F76EDF9563757934756DC958_1292825990 = (request.getMaxAgeSeconds() != -1);
            {
                freshMillis = Math.min(freshMillis,
                    TimeUnit.SECONDS.toMillis(request.getMaxAgeSeconds()));
            } //End block
        } //End collapsed parenthetic
        long minFreshMillis;
        minFreshMillis = 0;
        {
            boolean var0812931521313686CF4E34A994C81573_1675343272 = (request.getMinFreshSeconds() != -1);
            {
                minFreshMillis = TimeUnit.SECONDS.toMillis(request.getMinFreshSeconds());
            } //End block
        } //End collapsed parenthetic
        long maxStaleMillis;
        maxStaleMillis = 0;
        {
            boolean varBE22EC61E082962B9A28D480363F4C25_268693721 = (!mustRevalidate && request.getMaxStaleSeconds() != -1);
            {
                maxStaleMillis = TimeUnit.SECONDS.toMillis(request.getMaxStaleSeconds());
            } //End block
        } //End collapsed parenthetic
        {
            {
                headers.add("Warning", "110 HttpURLConnection \"Response is stale\"");
            } //End block
            {
                boolean var2B158D5C216D94EE4BBEF348BC4C77DA_352567324 = (ageMillis > TimeUnit.HOURS.toMillis(24) && isFreshnessLifetimeHeuristic());
                {
                    headers.add("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            request.setIfModifiedSince(lastModified);
        } //End block
        {
            request.setIfModifiedSince(servedDate);
        } //End block
        {
            request.setIfNoneMatch(etag);
        } //End block
        {
            boolean var365E7747104012F8E837CD902BFFBED2_1710263158 = (request.hasConditions());
        } //End flattened ternary
        return (ResponseSource)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.556 -0400", hash_original_method = "824AD0BBE6883E3213FE3DC10E71C2FB", hash_generated_method = "DDE054D28113AE5953DF4A239757D66B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean validate(ResponseHeaders networkResponse) {
        dsTaint.addTaint(networkResponse.dsTaint);
        {
            boolean var69CB999E5360904B86AF7CF73BDBAAEE_115758987 = (networkResponse.headers.getResponseCode() == HttpURLConnection.HTTP_NOT_MODIFIED);
        } //End collapsed parenthetic
        {
            boolean var834D152FE75AE1012A8E1C348C001FBE_753176708 = (lastModified != null
                && networkResponse.lastModified != null
                && networkResponse.lastModified.getTime() < lastModified.getTime());
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (networkResponse.headers.getResponseCode() == HttpURLConnection.HTTP_NOT_MODIFIED) {
            //return true;
        //}
        //if (lastModified != null
                //&& networkResponse.lastModified != null
                //&& networkResponse.lastModified.getTime() < lastModified.getTime()) {
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.557 -0400", hash_original_method = "22AFCF8A6EE54CCCB143274E3F308CC7", hash_generated_method = "CC3149DB100CFB4C6AB4C0419625D664")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ResponseHeaders combine(ResponseHeaders network) {
        dsTaint.addTaint(network.dsTaint);
        RawHeaders result;
        result = new RawHeaders();
        {
            int i;
            i = 0;
            boolean var160466EB7D7D5C6ABB8E6B06A85E2B1F_1240414674 = (i < headers.length());
            {
                String fieldName;
                fieldName = headers.getFieldName(i);
                String value;
                value = headers.getValue(i);
                {
                    boolean varFBC607F7190EEEDE1D047F61F2153C09_1196397704 = (fieldName.equals("Warning") && value.startsWith("1"));
                } //End collapsed parenthetic
                {
                    boolean var70955E32A6C50C8029AEBBD58FEE2C66_109597068 = (!isEndToEnd(fieldName) || network.headers.get(fieldName) == null);
                    {
                        result.add(fieldName, value);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            int i;
            i = 0;
            boolean var1DD03E9C0E7D3AA92950B78E75AFC7C3_182255793 = (i < network.headers.length());
            {
                String fieldName;
                fieldName = network.headers.getFieldName(i);
                {
                    boolean var9350CBC579AD9A7B70EC635F591BE067_1772866838 = (isEndToEnd(fieldName));
                    {
                        result.add(fieldName, network.headers.getValue(i));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        ResponseHeaders var1EB20F6028C78BF4F19AB86686562F34_118983783 = (new ResponseHeaders(uri, result));
        return (ResponseHeaders)dsTaint.getTaint();
        // ---------- Original Method ----------
        //RawHeaders result = new RawHeaders();
        //for (int i = 0; i < headers.length(); i++) {
            //String fieldName = headers.getFieldName(i);
            //String value = headers.getValue(i);
            //if (fieldName.equals("Warning") && value.startsWith("1")) {
                //continue; 
            //}
            //if (!isEndToEnd(fieldName) || network.headers.get(fieldName) == null) {
                //result.add(fieldName, value);
            //}
        //}
        //for (int i = 0; i < network.headers.length(); i++) {
            //String fieldName = network.headers.getFieldName(i);
            //if (isEndToEnd(fieldName)) {
                //result.add(fieldName, network.headers.getValue(i));
            //}
        //}
        //return new ResponseHeaders(uri, result);
    }

    
        private static boolean isEndToEnd(String fieldName) {
        return !fieldName.equalsIgnoreCase("Connection")
                && !fieldName.equalsIgnoreCase("Keep-Alive")
                && !fieldName.equalsIgnoreCase("Proxy-Authenticate")
                && !fieldName.equalsIgnoreCase("Proxy-Authorization")
                && !fieldName.equalsIgnoreCase("TE")
                && !fieldName.equalsIgnoreCase("Trailers")
                && !fieldName.equalsIgnoreCase("Transfer-Encoding")
                && !fieldName.equalsIgnoreCase("Upgrade");
    }

    
    private static final String SENT_MILLIS = "X-Android-Sent-Millis";
    private static final String RECEIVED_MILLIS = "X-Android-Received-Millis";
}

