package libcore.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

    /**
     * Returns true if {@code fieldName} is an end-to-end HTTP header, as
     * defined by RFC 2616, 13.5.1.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.693 -0500", hash_original_method = "73456A0877A0ABD5FC9108B2B0BE45A1", hash_generated_method = "A94F03796C461FF02A2281F0F5E18630")
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.645 -0500", hash_original_field = "266AFC899C01BE41BD68190730AA41C8", hash_generated_field = "9986D9D5D7C36DB8D79AB8BB9949FD3C")

    private static final String SENT_MILLIS = "X-Android-Sent-Millis";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.646 -0500", hash_original_field = "4DC6B8D555D49843D4E8958C101DA07B", hash_generated_field = "AFD1C82C7B74A7F57C473B3A0514C0CC")

    private static final String RECEIVED_MILLIS = "X-Android-Received-Millis";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.647 -0500", hash_original_field = "1154143EF3A042E6515BD6D5B42C64B6", hash_generated_field = "DDFAECCF21F90F28142F5C866534A5C3")


    private  URI uri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.648 -0500", hash_original_field = "721E352764832BEC7D2888A7B819E7BB", hash_generated_field = "534F1B0AE2D401678B9C67DE48E937E4")

    private  RawHeaders headers;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.648 -0500", hash_original_field = "F12E5D3DE3EECDFF2E0F1F7E0FA12FC7", hash_generated_field = "3C9D71E60FDD69589ECCD3D4127D69BC")

    private Date servedDate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.649 -0500", hash_original_field = "8A9CF2FAD5F8A077959F0448EF441805", hash_generated_field = "82D9B6029A259946FCFF39FA4D23937A")

    private Date lastModified;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.650 -0500", hash_original_field = "ABC9F34E0FCDBBF0A295F9E3040E0AAA", hash_generated_field = "310069CCAEBFEB04D5AA82E2ACE2110A")

    private Date expires;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.651 -0500", hash_original_field = "2BEAB6EBF3C8D9ED850BD613FB76590B", hash_generated_field = "53AB8B4205AECB145C66AA09F7622312")

    private long sentRequestMillis;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.651 -0500", hash_original_field = "F46EC7B16FFAAC5F08C4DC7ABC68AF0D", hash_generated_field = "D2D5C4E73D9772663AEEE06EBF7F2306")

    private long receivedResponseMillis;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.652 -0500", hash_original_field = "C359567A28AD1D5994F4F32F817A1408", hash_generated_field = "5465707577DD6326819BA83CC3A7DE3E")

    private boolean noCache;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.653 -0500", hash_original_field = "AA68488E77B000527F0B660AAE06302C", hash_generated_field = "E29F285792A57AA06DFE3E8F60AA431B")

    private boolean noStore;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.654 -0500", hash_original_field = "8E16EB77C76FEA4C8000F125EC5F79EC", hash_generated_field = "6AE706B03701B766A1504BFD91199E77")

    private int maxAgeSeconds = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.655 -0500", hash_original_field = "A8D9A50D875498F7AAB7BB06B869CDFE", hash_generated_field = "C42B9B760D56807C5A8089CC41DE4FAD")

    private int sMaxAgeSeconds = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.655 -0500", hash_original_field = "42BA6BA556701B39681BE026C528FD83", hash_generated_field = "4315CF686F5A893F6508AE7DC5DB95BF")

    private boolean isPublic;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.656 -0500", hash_original_field = "70FB41CDF76710B1C447121FB07EF2EB", hash_generated_field = "DC5EDF8BDDA2C085BD8FEEA27C73CDDC")

    private boolean mustRevalidate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.657 -0500", hash_original_field = "00F25F78CD9C317A5119E7AB2B23712A", hash_generated_field = "B46F71525C78B55AB18E5645D7ACEB23")

    private String etag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.658 -0500", hash_original_field = "6D4729615DE30A2042D8B4A6F8E81062", hash_generated_field = "CCAA9D3543734EDD63F2970D27646F7A")

    private int ageSeconds = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.658 -0500", hash_original_field = "6D5562026EB0DF459349875868195A67", hash_generated_field = "6E0F5B8CADA6537D578924642B4404D4")

    private Set<String> varyFields = Collections.emptySet();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.659 -0500", hash_original_field = "CEA29DCF66C639EAD8E96ECC619BF901", hash_generated_field = "62E683CB8A19320AEC224EE11BCD9187")


    private String contentEncoding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.660 -0500", hash_original_field = "3AD1B7A7AEDBE1A2DB22642DAB10A01F", hash_generated_field = "53F1E445144D7EEFF13D2F87736EF02D")

    private String transferEncoding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.661 -0500", hash_original_field = "DCA513098DC932271B140492EF640274", hash_generated_field = "C51A9B467DA1E79F88DC6617E76DB248")

    private int contentLength = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.661 -0500", hash_original_field = "8022296E52E90E64CBEABC7223F35EEE", hash_generated_field = "DB0F18ED2FD7BBA4B7D89988BC77D94E")

    private String connection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.662 -0500", hash_original_field = "1AFEFE779B09E9F1079BABD09EEE693C", hash_generated_field = "9CC28CE45A3E28EC763E1280217EFAB0")

    private String proxyAuthenticate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.663 -0500", hash_original_field = "558CE8CEC48FA28D923BA4C5B17A7889", hash_generated_field = "9D861AD424B4AE7E491841BD219A8EC5")

    private String wwwAuthenticate;
    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.075 -0400", hash_original_method = "DB24454BC912323B5FCB6CCA35CD9240", hash_generated_method = "B1262A28C863954B742AD0D089384546")
    public  ResponseHeaders(URI uri, RawHeaders headers) {
        this.uri = uri;
        this.headers = headers;
        HeaderParser.CacheControlHandler handler = new HeaderParser.CacheControlHandler() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.664 -0500", hash_original_method = "2F4EA238B9FB66AA2D15E84BE4D2AA7D", hash_generated_method = "6170BA67803077C11654104DFED8E942")
            @Override
public void handle(String directive, String parameter) {
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
for(int i = 0;i < headers.length();i++)
        {
            String fieldName = headers.getFieldName(i);
            String value = headers.getValue(i);
            if("Cache-Control".equalsIgnoreCase(fieldName))            
            {
                HeaderParser.parseCacheControl(value, handler);
            } //End block
            else
            if("Date".equalsIgnoreCase(fieldName))            
            {
                servedDate = HttpDate.parse(value);
            } //End block
            else
            if("Expires".equalsIgnoreCase(fieldName))            
            {
                expires = HttpDate.parse(value);
            } //End block
            else
            if("Last-Modified".equalsIgnoreCase(fieldName))            
            {
                lastModified = HttpDate.parse(value);
            } //End block
            else
            if("ETag".equalsIgnoreCase(fieldName))            
            {
                etag = value;
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
            if("Age".equalsIgnoreCase(fieldName))            
            {
                ageSeconds = HeaderParser.parseSeconds(value);
            } //End block
            else
            if("Vary".equalsIgnoreCase(fieldName))            
            {
                if(varyFields.isEmpty())                
                {
                    varyFields = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
                } //End block
for(String varyField : value.split(","))
                {
                    varyFields.add(varyField.trim());
                } //End block
            } //End block
            else
            if("Content-Encoding".equalsIgnoreCase(fieldName))            
            {
                contentEncoding = value;
            } //End block
            else
            if("Transfer-Encoding".equalsIgnoreCase(fieldName))            
            {
                transferEncoding = value;
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
            if("Connection".equalsIgnoreCase(fieldName))            
            {
                connection = value;
            } //End block
            else
            if("Proxy-Authenticate".equalsIgnoreCase(fieldName))            
            {
                proxyAuthenticate = value;
            } //End block
            else
            if("WWW-Authenticate".equalsIgnoreCase(fieldName))            
            {
                wwwAuthenticate = value;
            } //End block
            else
            if(SENT_MILLIS.equalsIgnoreCase(fieldName))            
            {
                sentRequestMillis = Long.parseLong(value);
            } //End block
            else
            if(RECEIVED_MILLIS.equalsIgnoreCase(fieldName))            
            {
                receivedResponseMillis = Long.parseLong(value);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.667 -0500", hash_original_method = "796365D0FCCA6BD674FA822FBE40C059", hash_generated_method = "635B065BF3CC98DF5FFB9E8AB1709E59")
    public boolean isContentEncodingGzip() {
        return "gzip".equalsIgnoreCase(contentEncoding);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.667 -0500", hash_original_method = "AD1C758BD3B96983B4362B4ECCA164D6", hash_generated_method = "9BFFA0B20EF31D533CA9BE0E35C6729F")
    public void stripContentEncoding() {
        contentEncoding = null;
        headers.removeAll("Content-Encoding");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.668 -0500", hash_original_method = "00B64F53B1189DFD8EFC83FE9CA41E37", hash_generated_method = "729C893AD1C21AE18D4F12D29D1C61DA")
    public boolean isChunked() {
        return "chunked".equalsIgnoreCase(transferEncoding);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.669 -0500", hash_original_method = "0C9005E446549CA2DCD479C6BCCC6A35", hash_generated_method = "EC0E49DCEE398A593CFEE12404E07E77")
    public boolean hasConnectionClose() {
        return "close".equalsIgnoreCase(connection);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.670 -0500", hash_original_method = "F8E205165DB0FFA5BCD89362DFA95E13", hash_generated_method = "60830F5EFD10217EDDCE0C85CD9D74A2")
    public URI getUri() {
        return uri;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.671 -0500", hash_original_method = "8B8008667EA7E940C84B2A1E4AADF211", hash_generated_method = "6022E25C4F7FF0168ED06357F484B603")
    public RawHeaders getHeaders() {
        return headers;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.672 -0500", hash_original_method = "F90446E53D3AF5BE7BA6FACCF3504208", hash_generated_method = "B721D470AF2F977A8DACEC13BF87060F")
    public Date getServedDate() {
        return servedDate;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.672 -0500", hash_original_method = "B44D0D5D3FBE8A04568E9D9F3E9708AC", hash_generated_method = "7E4E66EB9FC04F32FD29EBCB3D973A08")
    public Date getLastModified() {
        return lastModified;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.673 -0500", hash_original_method = "D14D02C8B70C044F75369CCEC64D849F", hash_generated_method = "590A8DE512F2CE04891F9CBE35387515")
    public Date getExpires() {
        return expires;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.674 -0500", hash_original_method = "6FC1CEF1DCDA63846245A172D489494E", hash_generated_method = "F80B03F9D6A493EAD09B6933DD20850A")
    public boolean isNoCache() {
        return noCache;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.674 -0500", hash_original_method = "41C92D037056676770FDD2CB72F93600", hash_generated_method = "39DFC9448526DC80896114D7B00B4371")
    public boolean isNoStore() {
        return noStore;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.675 -0500", hash_original_method = "A8F2E8C976B81B2FCD2E37C57E26B8BC", hash_generated_method = "F01A0136F83C79BFF39A10D41A61EBE7")
    public int getMaxAgeSeconds() {
        return maxAgeSeconds;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.676 -0500", hash_original_method = "E2E5751856DD8B4562FF25B8FB1901CF", hash_generated_method = "A6B364C97C02ACE65692AC0243D33810")
    public int getSMaxAgeSeconds() {
        return sMaxAgeSeconds;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.677 -0500", hash_original_method = "5C207DA5362424777671E2427CD32289", hash_generated_method = "69678295FE395540ED39E44E59F9F2D5")
    public boolean isPublic() {
        return isPublic;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.677 -0500", hash_original_method = "E05A87C935BB761C11F60283BED9A93A", hash_generated_method = "639AAB6BEC9768D3EC6AF5399EA6BB29")
    public boolean isMustRevalidate() {
        return mustRevalidate;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.678 -0500", hash_original_method = "2F22856D0A054825BF540D28FE4EB44E", hash_generated_method = "B2B8A4100F53D6A2840E8CBAAA94F54B")
    public String getEtag() {
        return etag;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.679 -0500", hash_original_method = "C8C00D8A1144BBC8C8A6E2EAAA43E379", hash_generated_method = "147EAB972B46E0CB87AC4642E1E1FC32")
    public Set<String> getVaryFields() {
        return varyFields;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.679 -0500", hash_original_method = "801F0D0C73EEE64E68A729BCCDAD74D7", hash_generated_method = "61860FA8B805FE53FAA336A24BBA3D52")
    public String getContentEncoding() {
        return contentEncoding;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.680 -0500", hash_original_method = "1B52BDD2BF1D0E488CD60B58C0023743", hash_generated_method = "3EA641A4B2840232F93FE75B9CA26F40")
    public int getContentLength() {
        return contentLength;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.681 -0500", hash_original_method = "B2D78684E046945E6BE853B24B15E901", hash_generated_method = "78E1AA902D6B9D44AB023C3342795437")
    public String getConnection() {
        return connection;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.682 -0500", hash_original_method = "BA8A66BA629083526749CA96982906E0", hash_generated_method = "2EB2760C6295E7AD623E2DC69A546DFF")
    public String getProxyAuthenticate() {
        return proxyAuthenticate;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.682 -0500", hash_original_method = "9336A6C75F9FBB86806462CCF41FEBB3", hash_generated_method = "0AD2C87C11191A15C7C4A9018FF8DF99")
    public String getWwwAuthenticate() {
        return wwwAuthenticate;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.683 -0500", hash_original_method = "22FEE68D81D5D179ED2595CC992792BF", hash_generated_method = "8F00751DEC29462FD19DC9D010B36B8F")
    public void setLocalTimestamps(long sentRequestMillis, long receivedResponseMillis) {
        this.sentRequestMillis = sentRequestMillis;
        headers.add(SENT_MILLIS, Long.toString(sentRequestMillis));
        this.receivedResponseMillis = receivedResponseMillis;
        headers.add(RECEIVED_MILLIS, Long.toString(receivedResponseMillis));
    }

    /**
     * Returns the current age of the response, in milliseconds. The calculation
     * is specified by RFC 2616, 13.2.3 Age Calculations.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.684 -0500", hash_original_method = "62B4E508B2BD1FD8674C188E31D3FA94", hash_generated_method = "F2364D7E3AE13D2A42D3A4CBE3B02500")
    private long computeAge(long nowMillis) {
        long apparentReceivedAge = servedDate != null
                ? Math.max(0, receivedResponseMillis - servedDate.getTime())
                : 0;
        long receivedAge = ageSeconds != -1
                ? Math.max(apparentReceivedAge, TimeUnit.SECONDS.toMillis(ageSeconds))
                : apparentReceivedAge;
        long responseDuration = receivedResponseMillis - sentRequestMillis;
        long residentDuration = nowMillis - receivedResponseMillis;
        return receivedAge + responseDuration + residentDuration;
    }

    /**
     * Returns the number of milliseconds that the response was fresh for,
     * starting from the served date.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.686 -0500", hash_original_method = "723583A81B93D8753154A40B95765CF8", hash_generated_method = "38A63EEC2A6796D02AEF351E230EEF19")
    private long computeFreshnessLifetime() {
        if (maxAgeSeconds != -1) {
            return TimeUnit.SECONDS.toMillis(maxAgeSeconds);
        } else if (expires != null) {
            long servedMillis = servedDate != null ? servedDate.getTime() : receivedResponseMillis;
            long delta = expires.getTime() - servedMillis;
            return delta > 0 ? delta : 0;
        } else if (lastModified != null && uri.getRawQuery() == null) {
            /*
             * As recommended by the HTTP RFC and implemented in Firefox, the
             * max age of a document should be defaulted to 10% of the
             * document's age at the time it was served. Default expiration
             * dates aren't used for URIs containing a query.
             */
            long servedMillis = servedDate != null ? servedDate.getTime() : sentRequestMillis;
            long delta = servedMillis - lastModified.getTime();
            return delta > 0 ? (delta / 10) : 0;
        }
        return 0;
    }

    /**
     * Returns true if computeFreshnessLifetime used a heuristic. If we used a
     * heuristic to serve a cached response older than 24 hours, we are required
     * to attach a warning.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.686 -0500", hash_original_method = "8F28A3C0281B6F16DECF00092A03388F", hash_generated_method = "E6B3AE3BEB63D05981CAAF6DB37BEC46")
    private boolean isFreshnessLifetimeHeuristic() {
        return maxAgeSeconds == -1 && expires == null;
    }

    /**
     * Returns true if this response can be stored to later serve another
     * request.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.687 -0500", hash_original_method = "E402151342DE994EEE4FC3989E09156E", hash_generated_method = "D3D0154E7DB983A5A59A506AA3B22B95")
    public boolean isCacheable(RequestHeaders request) {
        /*
         * Always go to network for uncacheable response codes (RFC 2616, 13.4),
         * This implementation doesn't support caching partial content.
         */
        int responseCode = headers.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK
                && responseCode != HttpURLConnection.HTTP_NOT_AUTHORITATIVE
                && responseCode != HttpURLConnection.HTTP_MULT_CHOICE
                && responseCode != HttpURLConnection.HTTP_MOVED_PERM
                && responseCode != HttpURLConnection.HTTP_GONE) {
            return false;
        }

        /*
         * Responses to authorized requests aren't cacheable unless they include
         * a 'public', 'must-revalidate' or 's-maxage' directive.
         */
        if (request.hasAuthorization()
                && !isPublic
                && !mustRevalidate
                && sMaxAgeSeconds == -1) {
            return false;
        }

        if (noStore) {
            return false;
        }

        return true;
    }

    /**
     * Returns true if a Vary header contains an asterisk. Such responses cannot
     * be cached.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.688 -0500", hash_original_method = "937D0115F7BB3894701032373C9A4BC7", hash_generated_method = "C9B13E42E413956CD49FBE30E23328D3")
    public boolean hasVaryAll() {
        return varyFields.contains("*");
    }

    /**
     * Returns true if none of the Vary headers on this response have changed
     * between {@code cachedRequest} and {@code newRequest}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.689 -0500", hash_original_method = "AE2D57CEA29D6AAD43D079D6A743C143", hash_generated_method = "9BAF369CD75D47C3100ECC1CBBD56498")
    public boolean varyMatches(Map<String, List<String>> cachedRequest,
            Map<String, List<String>> newRequest) {
        for (String field : varyFields) {
            if (!Objects.equal(cachedRequest.get(field), newRequest.get(field))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the source to satisfy {@code request} given this cached response.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.690 -0500", hash_original_method = "564BBC9A8CA0CE268623CE0DAE1CD407", hash_generated_method = "3EF0B26AF8F9EED11048A2F66F552082")
    public ResponseSource chooseResponseSource(long nowMillis, RequestHeaders request) {
        /*
         * If this response shouldn't have been stored, it should never be used
         * as a response source. This check should be redundant as long as the
         * persistence store is well-behaved and the rules are constant.
         */
        if (!isCacheable(request)) {
            return ResponseSource.NETWORK;
        }

        if (request.isNoCache() || request.hasConditions()) {
            return ResponseSource.NETWORK;
        }

        long ageMillis = computeAge(nowMillis);
        long freshMillis = computeFreshnessLifetime();

        if (request.getMaxAgeSeconds() != -1) {
            freshMillis = Math.min(freshMillis,
                    TimeUnit.SECONDS.toMillis(request.getMaxAgeSeconds()));
        }

        long minFreshMillis = 0;
        if (request.getMinFreshSeconds() != -1) {
            minFreshMillis = TimeUnit.SECONDS.toMillis(request.getMinFreshSeconds());
        }

        long maxStaleMillis = 0;
        if (!mustRevalidate && request.getMaxStaleSeconds() != -1) {
            maxStaleMillis = TimeUnit.SECONDS.toMillis(request.getMaxStaleSeconds());
        }

        if (!noCache && ageMillis + minFreshMillis < freshMillis + maxStaleMillis) {
            if (ageMillis + minFreshMillis >= freshMillis) {
                headers.add("Warning", "110 HttpURLConnection \"Response is stale\"");
            }
            if (ageMillis > TimeUnit.HOURS.toMillis(24) && isFreshnessLifetimeHeuristic()) {
                headers.add("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
            }
            return ResponseSource.CACHE;
        }

        if (lastModified != null) {
            request.setIfModifiedSince(lastModified);
        } else if (servedDate != null) {
            request.setIfModifiedSince(servedDate);
        }

        if (etag != null) {
            request.setIfNoneMatch(etag);
        }

        return request.hasConditions()
                ? ResponseSource.CONDITIONAL_CACHE
                : ResponseSource.NETWORK;
    }

    /**
     * Returns true if this cached response should be used; false if the
     * network response should be used.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.691 -0500", hash_original_method = "824AD0BBE6883E3213FE3DC10E71C2FB", hash_generated_method = "4A5C1EC293677C95F0C856DF32C7EB86")
    public boolean validate(ResponseHeaders networkResponse) {
        if (networkResponse.headers.getResponseCode() == HttpURLConnection.HTTP_NOT_MODIFIED) {
            return true;
        }

        /*
         * The HTTP spec says that if the network's response is older than our
         * cached response, we may return the cache's response. Like Chrome (but
         * unlike Firefox), this client prefers to return the newer response.
         */
        if (lastModified != null
                && networkResponse.lastModified != null
                && networkResponse.lastModified.getTime() < lastModified.getTime()) {
            return true;
        }

        return false;
    }

    /**
     * Combines this cached header with a network header as defined by RFC 2616,
     * 13.5.3.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:42.692 -0500", hash_original_method = "22AFCF8A6EE54CCCB143274E3F308CC7", hash_generated_method = "ABA44C554E38D1547244623253CC4B81")
    public ResponseHeaders combine(ResponseHeaders network) {
        RawHeaders result = new RawHeaders();

        for (int i = 0; i < headers.length(); i++) {
            String fieldName = headers.getFieldName(i);
            String value = headers.getValue(i);
            if (fieldName.equals("Warning") && value.startsWith("1")) {
                continue; // drop 100-level freshness warnings
            }
            if (!isEndToEnd(fieldName) || network.headers.get(fieldName) == null) {
                result.add(fieldName, value);
            }
        }

        for (int i = 0; i < network.headers.length(); i++) {
            String fieldName = network.headers.getFieldName(i);
            if (isEndToEnd(fieldName)) {
                result.add(fieldName, network.headers.getValue(i));
            }
        }

        return new ResponseHeaders(uri, result);
    }
}

