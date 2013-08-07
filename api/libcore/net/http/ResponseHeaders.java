package libcore.net.http;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.070 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "DDFAECCF21F90F28142F5C866534A5C3")

    private URI uri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.070 -0400", hash_original_field = "4340FD73E75DF7A9D9E45902A59BA3A4", hash_generated_field = "534F1B0AE2D401678B9C67DE48E937E4")

    private RawHeaders headers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.070 -0400", hash_original_field = "255C768659E137E647AD19DAAA113055", hash_generated_field = "3C9D71E60FDD69589ECCD3D4127D69BC")

    private Date servedDate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.070 -0400", hash_original_field = "56D4CE3ADDD9E0185B21EB938EA5BC79", hash_generated_field = "82D9B6029A259946FCFF39FA4D23937A")

    private Date lastModified;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.070 -0400", hash_original_field = "09BCB72D61C0D6D1EFF5336DA6881557", hash_generated_field = "310069CCAEBFEB04D5AA82E2ACE2110A")

    private Date expires;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.070 -0400", hash_original_field = "2DB04C3277683DB70B0D07522DD798E9", hash_generated_field = "53AB8B4205AECB145C66AA09F7622312")

    private long sentRequestMillis;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.070 -0400", hash_original_field = "97EAE8D73925A6238D9D413B6589D432", hash_generated_field = "D2D5C4E73D9772663AEEE06EBF7F2306")

    private long receivedResponseMillis;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.071 -0400", hash_original_field = "3EDE331CCA63FAAFB68A34ACB42767C6", hash_generated_field = "5465707577DD6326819BA83CC3A7DE3E")

    private boolean noCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.071 -0400", hash_original_field = "4EAEDC49CC94AC327BA1C989626A4650", hash_generated_field = "E29F285792A57AA06DFE3E8F60AA431B")

    private boolean noStore;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.071 -0400", hash_original_field = "B29571B8149006A2CE1968134C4493D4", hash_generated_field = "6AE706B03701B766A1504BFD91199E77")

    private int maxAgeSeconds = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.071 -0400", hash_original_field = "CABA19AD91000B29CF602FF3160B2505", hash_generated_field = "C42B9B760D56807C5A8089CC41DE4FAD")

    private int sMaxAgeSeconds = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.071 -0400", hash_original_field = "16995EEF256269CFE8804FFAF770CB4B", hash_generated_field = "4315CF686F5A893F6508AE7DC5DB95BF")

    private boolean isPublic;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.071 -0400", hash_original_field = "F743118D2A1306352619EE9399545214", hash_generated_field = "DC5EDF8BDDA2C085BD8FEEA27C73CDDC")

    private boolean mustRevalidate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.071 -0400", hash_original_field = "1872ADE88F3013EDEB33DECD74A4F947", hash_generated_field = "B46F71525C78B55AB18E5645D7ACEB23")

    private String etag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.071 -0400", hash_original_field = "5BEEEA8F4990B45AFEC4D7C108C16DCD", hash_generated_field = "CCAA9D3543734EDD63F2970D27646F7A")

    private int ageSeconds = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.071 -0400", hash_original_field = "69E5F23E7A9FFA364853DD8FDEE9BB4E", hash_generated_field = "6E0F5B8CADA6537D578924642B4404D4")

    private Set<String> varyFields = Collections.emptySet();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.071 -0400", hash_original_field = "8D5FC32AC7506D2C0AC6949566E3BBE2", hash_generated_field = "62E683CB8A19320AEC224EE11BCD9187")

    private String contentEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.071 -0400", hash_original_field = "BF0487A5497D96D26C24936A4DAD1B2F", hash_generated_field = "53F1E445144D7EEFF13D2F87736EF02D")

    private String transferEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.071 -0400", hash_original_field = "23620B0ED7D2D6853307DFADB119A41C", hash_generated_field = "C51A9B467DA1E79F88DC6617E76DB248")

    private int contentLength = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.071 -0400", hash_original_field = "4717D53EBFDFEA8477F780EC66151DCB", hash_generated_field = "DB0F18ED2FD7BBA4B7D89988BC77D94E")

    private String connection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.071 -0400", hash_original_field = "23C886695D450E9E6FBD359CA1A9C75A", hash_generated_field = "9CC28CE45A3E28EC763E1280217EFAB0")

    private String proxyAuthenticate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.071 -0400", hash_original_field = "422BF398592867CC60C026C5302F13F9", hash_generated_field = "9D861AD424B4AE7E491841BD219A8EC5")

    private String wwwAuthenticate;
    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.075 -0400", hash_original_method = "DB24454BC912323B5FCB6CCA35CD9240", hash_generated_method = "B1262A28C863954B742AD0D089384546")
    public  ResponseHeaders(URI uri, RawHeaders headers) {
        this.uri = uri;
        this.headers = headers;
        HeaderParser.CacheControlHandler handler = new HeaderParser.CacheControlHandler() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.078 -0400", hash_original_method = "796365D0FCCA6BD674FA822FBE40C059", hash_generated_method = "452012271DD782CB86893D007F8F7706")
    public boolean isContentEncodingGzip() {
        boolean var94B5B502A2ABF1EBBFD2D6372DF3B2FF_363050857 = ("gzip".equalsIgnoreCase(contentEncoding));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1643761767 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1643761767;
        // ---------- Original Method ----------
        //return "gzip".equalsIgnoreCase(contentEncoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.078 -0400", hash_original_method = "AD1C758BD3B96983B4362B4ECCA164D6", hash_generated_method = "E13F95E67AAC2117E89E0EFDCED90CA7")
    public void stripContentEncoding() {
        contentEncoding = null;
        headers.removeAll("Content-Encoding");
        // ---------- Original Method ----------
        //contentEncoding = null;
        //headers.removeAll("Content-Encoding");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.078 -0400", hash_original_method = "00B64F53B1189DFD8EFC83FE9CA41E37", hash_generated_method = "FCED540DBDFA7DE416DC9745C84A0DCF")
    public boolean isChunked() {
        boolean var1990FB90873D18F505D59F3D0EED154E_1940744693 = ("chunked".equalsIgnoreCase(transferEncoding));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1965170725 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1965170725;
        // ---------- Original Method ----------
        //return "chunked".equalsIgnoreCase(transferEncoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.079 -0400", hash_original_method = "0C9005E446549CA2DCD479C6BCCC6A35", hash_generated_method = "1A2EA71DF1E2854988A44FD769CA7B67")
    public boolean hasConnectionClose() {
        boolean varF2BCD5BC5E8773DEF14059362B3DF736_153700245 = ("close".equalsIgnoreCase(connection));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1296595858 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1296595858;
        // ---------- Original Method ----------
        //return "close".equalsIgnoreCase(connection);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.079 -0400", hash_original_method = "F8E205165DB0FFA5BCD89362DFA95E13", hash_generated_method = "30DF44860DA851D23ED76F1B713686F1")
    public URI getUri() {
URI varD12B663A5EB2F9B068EED08B4C05ECCC_13210929 =         uri;
        varD12B663A5EB2F9B068EED08B4C05ECCC_13210929.addTaint(taint);
        return varD12B663A5EB2F9B068EED08B4C05ECCC_13210929;
        // ---------- Original Method ----------
        //return uri;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.079 -0400", hash_original_method = "8B8008667EA7E940C84B2A1E4AADF211", hash_generated_method = "F8FCB70F3C193ACD1161A81601F085FD")
    public RawHeaders getHeaders() {
RawHeaders var6937E37BAD8D53F9D49A0E32C69A3A2C_298610077 =         headers;
        var6937E37BAD8D53F9D49A0E32C69A3A2C_298610077.addTaint(taint);
        return var6937E37BAD8D53F9D49A0E32C69A3A2C_298610077;
        // ---------- Original Method ----------
        //return headers;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.079 -0400", hash_original_method = "F90446E53D3AF5BE7BA6FACCF3504208", hash_generated_method = "DCCC0ACA1EFD036023D98030854D4DF8")
    public Date getServedDate() {
Date var71066E34313B9F8FAC6BB6F01EB14C6F_60547569 =         servedDate;
        var71066E34313B9F8FAC6BB6F01EB14C6F_60547569.addTaint(taint);
        return var71066E34313B9F8FAC6BB6F01EB14C6F_60547569;
        // ---------- Original Method ----------
        //return servedDate;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.079 -0400", hash_original_method = "B44D0D5D3FBE8A04568E9D9F3E9708AC", hash_generated_method = "EE024020D5801A2D125568212EA58827")
    public Date getLastModified() {
Date var516C2A6FCD26E1D0D88121A19963AD63_994448536 =         lastModified;
        var516C2A6FCD26E1D0D88121A19963AD63_994448536.addTaint(taint);
        return var516C2A6FCD26E1D0D88121A19963AD63_994448536;
        // ---------- Original Method ----------
        //return lastModified;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.080 -0400", hash_original_method = "D14D02C8B70C044F75369CCEC64D849F", hash_generated_method = "31113F74C90D239797D9689202DDAC44")
    public Date getExpires() {
Date var1F40635C1A2E405B8C2A4BA335625EE0_1065107799 =         expires;
        var1F40635C1A2E405B8C2A4BA335625EE0_1065107799.addTaint(taint);
        return var1F40635C1A2E405B8C2A4BA335625EE0_1065107799;
        // ---------- Original Method ----------
        //return expires;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.080 -0400", hash_original_method = "6FC1CEF1DCDA63846245A172D489494E", hash_generated_method = "362B9D63E2015772EE51919BAB2DA23B")
    public boolean isNoCache() {
        boolean var3EDE331CCA63FAAFB68A34ACB42767C6_281529188 = (noCache);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1734442974 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1734442974;
        // ---------- Original Method ----------
        //return noCache;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.080 -0400", hash_original_method = "41C92D037056676770FDD2CB72F93600", hash_generated_method = "C2E7F7EBF3763CE425C9AB409EA7BBF7")
    public boolean isNoStore() {
        boolean var4EAEDC49CC94AC327BA1C989626A4650_1284965654 = (noStore);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_254671000 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_254671000;
        // ---------- Original Method ----------
        //return noStore;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.080 -0400", hash_original_method = "A8F2E8C976B81B2FCD2E37C57E26B8BC", hash_generated_method = "19067AE2CFF1A944E92EABBE17B6FE78")
    public int getMaxAgeSeconds() {
        int var060B48DC3D605436BA3D6E7F3BA7AA44_1942313659 = (maxAgeSeconds);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_542081661 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_542081661;
        // ---------- Original Method ----------
        //return maxAgeSeconds;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.081 -0400", hash_original_method = "E2E5751856DD8B4562FF25B8FB1901CF", hash_generated_method = "1F8DF4177A92A903AF836CBBA0DB6F55")
    public int getSMaxAgeSeconds() {
        int var5695C2567BA60BF76B8E8D719C58F914_1484355763 = (sMaxAgeSeconds);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1432979459 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1432979459;
        // ---------- Original Method ----------
        //return sMaxAgeSeconds;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.081 -0400", hash_original_method = "5C207DA5362424777671E2427CD32289", hash_generated_method = "27FB9CF3AAA3505C2AACBCB130BD17C2")
    public boolean isPublic() {
        boolean var16995EEF256269CFE8804FFAF770CB4B_821679674 = (isPublic);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1663064748 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1663064748;
        // ---------- Original Method ----------
        //return isPublic;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.081 -0400", hash_original_method = "E05A87C935BB761C11F60283BED9A93A", hash_generated_method = "91DB2560FD100C7B81C573BDF778EDD8")
    public boolean isMustRevalidate() {
        boolean varF743118D2A1306352619EE9399545214_36026152 = (mustRevalidate);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1616500402 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1616500402;
        // ---------- Original Method ----------
        //return mustRevalidate;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.081 -0400", hash_original_method = "2F22856D0A054825BF540D28FE4EB44E", hash_generated_method = "FE9EEB12E9F8C56AFDB91BA3CCE31B97")
    public String getEtag() {
String var5EC213F5B8A0028786E3BB0C8E4ED840_1231833201 =         etag;
        var5EC213F5B8A0028786E3BB0C8E4ED840_1231833201.addTaint(taint);
        return var5EC213F5B8A0028786E3BB0C8E4ED840_1231833201;
        // ---------- Original Method ----------
        //return etag;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.081 -0400", hash_original_method = "C8C00D8A1144BBC8C8A6E2EAAA43E379", hash_generated_method = "C379FC4BF5EE8156275F1D18A51FA729")
    public Set<String> getVaryFields() {
Set<String> varF9D3B650D43A4B0402EC4AA1395AF54F_1368303581 =         varyFields;
        varF9D3B650D43A4B0402EC4AA1395AF54F_1368303581.addTaint(taint);
        return varF9D3B650D43A4B0402EC4AA1395AF54F_1368303581;
        // ---------- Original Method ----------
        //return varyFields;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.082 -0400", hash_original_method = "801F0D0C73EEE64E68A729BCCDAD74D7", hash_generated_method = "9802DA9BE3B216C185F05CE667C6B24F")
    public String getContentEncoding() {
String varB77403BF8D1FE544589F5EE718B4AD53_746545995 =         contentEncoding;
        varB77403BF8D1FE544589F5EE718B4AD53_746545995.addTaint(taint);
        return varB77403BF8D1FE544589F5EE718B4AD53_746545995;
        // ---------- Original Method ----------
        //return contentEncoding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.082 -0400", hash_original_method = "1B52BDD2BF1D0E488CD60B58C0023743", hash_generated_method = "293DF4365E7E84636A9534B1901CE201")
    public int getContentLength() {
        int varC22384F3ABFE57BC648B6E1701C98123_1819376713 = (contentLength);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1575255286 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1575255286;
        // ---------- Original Method ----------
        //return contentLength;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.082 -0400", hash_original_method = "B2D78684E046945E6BE853B24B15E901", hash_generated_method = "6E64CAA25B9E382E0964AFF473BB6B04")
    public String getConnection() {
String var9911BB1C5F1522C1630847C40E8BC67E_2136350198 =         connection;
        var9911BB1C5F1522C1630847C40E8BC67E_2136350198.addTaint(taint);
        return var9911BB1C5F1522C1630847C40E8BC67E_2136350198;
        // ---------- Original Method ----------
        //return connection;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.083 -0400", hash_original_method = "BA8A66BA629083526749CA96982906E0", hash_generated_method = "71D9F92B982EA0CB45709F17265A43AE")
    public String getProxyAuthenticate() {
String var4031BD8BE5A0F3F4514FF0093E626D68_145102834 =         proxyAuthenticate;
        var4031BD8BE5A0F3F4514FF0093E626D68_145102834.addTaint(taint);
        return var4031BD8BE5A0F3F4514FF0093E626D68_145102834;
        // ---------- Original Method ----------
        //return proxyAuthenticate;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.083 -0400", hash_original_method = "9336A6C75F9FBB86806462CCF41FEBB3", hash_generated_method = "53F128FAFF3EE17A0EBA0647E2883AE4")
    public String getWwwAuthenticate() {
String varBCB9696E34DE6C6E990E36231F1734E3_1338706236 =         wwwAuthenticate;
        varBCB9696E34DE6C6E990E36231F1734E3_1338706236.addTaint(taint);
        return varBCB9696E34DE6C6E990E36231F1734E3_1338706236;
        // ---------- Original Method ----------
        //return wwwAuthenticate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.084 -0400", hash_original_method = "22FEE68D81D5D179ED2595CC992792BF", hash_generated_method = "DC80F96132036FAD673859E5C2212566")
    public void setLocalTimestamps(long sentRequestMillis, long receivedResponseMillis) {
        this.sentRequestMillis = sentRequestMillis;
        headers.add(SENT_MILLIS, Long.toString(sentRequestMillis));
        this.receivedResponseMillis = receivedResponseMillis;
        headers.add(RECEIVED_MILLIS, Long.toString(receivedResponseMillis));
        // ---------- Original Method ----------
        //this.sentRequestMillis = sentRequestMillis;
        //headers.add(SENT_MILLIS, Long.toString(sentRequestMillis));
        //this.receivedResponseMillis = receivedResponseMillis;
        //headers.add(RECEIVED_MILLIS, Long.toString(receivedResponseMillis));
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.084 -0400", hash_original_method = "62B4E508B2BD1FD8674C188E31D3FA94", hash_generated_method = "2E9FBB544F1618D12A9DD259DE29C8C8")
    private long computeAge(long nowMillis) {
        addTaint(nowMillis);
        long apparentReceivedAge = servedDate != null
                ? Math.max(0, receivedResponseMillis - servedDate.getTime())
                : 0;
        long receivedAge = ageSeconds != -1
                ? Math.max(apparentReceivedAge, TimeUnit.SECONDS.toMillis(ageSeconds))
                : apparentReceivedAge;
        long responseDuration = receivedResponseMillis - sentRequestMillis;
        long residentDuration = nowMillis - receivedResponseMillis;
        long var4585CEC63AD76EE55FC01133BA9ECCFA_147371401 = (receivedAge + responseDuration + residentDuration);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1815673397 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1815673397;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.085 -0400", hash_original_method = "723583A81B93D8753154A40B95765CF8", hash_generated_method = "65FCF710A3FBB29126B019FFA93D32BE")
    private long computeFreshnessLifetime() {
        if(maxAgeSeconds != -1)        
        {
            long varD2683FB4F2DB6C3418FEDD2606FAD52C_926198713 = (TimeUnit.SECONDS.toMillis(maxAgeSeconds));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1616752740 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1616752740;
        } //End block
        else
        if(expires != null)        
        {
            long servedMillis = servedDate != null ? servedDate.getTime() : receivedResponseMillis;
            long delta = expires.getTime() - servedMillis;
            long var320EB9F973EB306CB43AB59D08EDF71D_1396105955 = (delta > 0 ? delta : 0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_197714525 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_197714525;
        } //End block
        else
        if(lastModified != null && uri.getRawQuery() == null)        
        {
            long servedMillis = servedDate != null ? servedDate.getTime() : sentRequestMillis;
            long delta = servedMillis - lastModified.getTime();
            long varBE25EAEA3A9694D5A837C61CE4E6E0DB_549771482 = (delta > 0 ? (delta / 10) : 0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1894080573 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1894080573;
        } //End block
        long varCFCD208495D565EF66E7DFF9F98764DA_694727820 = (0);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_338166707 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_338166707;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.085 -0400", hash_original_method = "8F28A3C0281B6F16DECF00092A03388F", hash_generated_method = "5DBE9BFC33F61CF9246438B69278AF8D")
    private boolean isFreshnessLifetimeHeuristic() {
        boolean varB3779E1B2D66F50C18AC10B4E5E4B2CF_1278389083 = (maxAgeSeconds == -1 && expires == null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_824271414 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_824271414;
        // ---------- Original Method ----------
        //return maxAgeSeconds == -1 && expires == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.087 -0400", hash_original_method = "E402151342DE994EEE4FC3989E09156E", hash_generated_method = "5601485C65AA9919C066BE81E45EC615")
    public boolean isCacheable(RequestHeaders request) {
        addTaint(request.getTaint());
        int responseCode = headers.getResponseCode();
        if(responseCode != HttpURLConnection.HTTP_OK
                && responseCode != HttpURLConnection.HTTP_NOT_AUTHORITATIVE
                && responseCode != HttpURLConnection.HTTP_MULT_CHOICE
                && responseCode != HttpURLConnection.HTTP_MOVED_PERM
                && responseCode != HttpURLConnection.HTTP_GONE)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1537051193 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1107278191 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1107278191;
        } //End block
        if(request.hasAuthorization()
                && !isPublic
                && !mustRevalidate
                && sMaxAgeSeconds == -1)        
        {
            boolean var68934A3E9455FA72420237EB05902327_773478113 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_691096518 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_691096518;
        } //End block
        if(noStore)        
        {
            boolean var68934A3E9455FA72420237EB05902327_532385058 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1978690572 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1978690572;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_310573949 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1775556414 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1775556414;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.087 -0400", hash_original_method = "937D0115F7BB3894701032373C9A4BC7", hash_generated_method = "AEC56CBECF6336E14FA0DC2960B92187")
    public boolean hasVaryAll() {
        boolean varE1CCDF3C03F32095F5952C20B938A67A_689127782 = (varyFields.contains("*"));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_872981984 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_872981984;
        // ---------- Original Method ----------
        //return varyFields.contains("*");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.088 -0400", hash_original_method = "AE2D57CEA29D6AAD43D079D6A743C143", hash_generated_method = "B2E08F32AB65D612AE49EF9A12F3A611")
    public boolean varyMatches(Map<String, List<String>> cachedRequest,
            Map<String, List<String>> newRequest) {
        addTaint(newRequest.getTaint());
        addTaint(cachedRequest.getTaint());
for(String field : varyFields)
        {
            if(!Objects.equal(cachedRequest.get(field), newRequest.get(field)))            
            {
                boolean var68934A3E9455FA72420237EB05902327_851377738 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1821587204 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1821587204;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1083731275 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_470996361 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_470996361;
        // ---------- Original Method ----------
        //for (String field : varyFields) {
            //if (!Objects.equal(cachedRequest.get(field), newRequest.get(field))) {
                //return false;
            //}
        //}
        //return true;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.089 -0400", hash_original_method = "564BBC9A8CA0CE268623CE0DAE1CD407", hash_generated_method = "FF7FD44C591403434F1511622D8E347E")
    public ResponseSource chooseResponseSource(long nowMillis, RequestHeaders request) {
        addTaint(request.getTaint());
        addTaint(nowMillis);
        if(!isCacheable(request))        
        {
ResponseSource var1757A0F5354633F73AEA23B0AFFDA71F_123719786 =             ResponseSource.NETWORK;
            var1757A0F5354633F73AEA23B0AFFDA71F_123719786.addTaint(taint);
            return var1757A0F5354633F73AEA23B0AFFDA71F_123719786;
        } //End block
        if(request.isNoCache() || request.hasConditions())        
        {
ResponseSource var1757A0F5354633F73AEA23B0AFFDA71F_491399948 =             ResponseSource.NETWORK;
            var1757A0F5354633F73AEA23B0AFFDA71F_491399948.addTaint(taint);
            return var1757A0F5354633F73AEA23B0AFFDA71F_491399948;
        } //End block
        long ageMillis = computeAge(nowMillis);
        long freshMillis = computeFreshnessLifetime();
        if(request.getMaxAgeSeconds() != -1)        
        {
            freshMillis = Math.min(freshMillis,
                    TimeUnit.SECONDS.toMillis(request.getMaxAgeSeconds()));
        } //End block
        long minFreshMillis = 0;
        if(request.getMinFreshSeconds() != -1)        
        {
            minFreshMillis = TimeUnit.SECONDS.toMillis(request.getMinFreshSeconds());
        } //End block
        long maxStaleMillis = 0;
        if(!mustRevalidate && request.getMaxStaleSeconds() != -1)        
        {
            maxStaleMillis = TimeUnit.SECONDS.toMillis(request.getMaxStaleSeconds());
        } //End block
        if(!noCache && ageMillis + minFreshMillis < freshMillis + maxStaleMillis)        
        {
            if(ageMillis + minFreshMillis >= freshMillis)            
            {
                headers.add("Warning", "110 HttpURLConnection \"Response is stale\"");
            } //End block
            if(ageMillis > TimeUnit.HOURS.toMillis(24) && isFreshnessLifetimeHeuristic())            
            {
                headers.add("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
            } //End block
ResponseSource varC45261C4506407293CB2645C2C48C010_1175401213 =             ResponseSource.CACHE;
            varC45261C4506407293CB2645C2C48C010_1175401213.addTaint(taint);
            return varC45261C4506407293CB2645C2C48C010_1175401213;
        } //End block
        if(lastModified != null)        
        {
            request.setIfModifiedSince(lastModified);
        } //End block
        else
        if(servedDate != null)        
        {
            request.setIfModifiedSince(servedDate);
        } //End block
        if(etag != null)        
        {
            request.setIfNoneMatch(etag);
        } //End block
ResponseSource var119A68D99E23251C9C650BF5A4F6C09B_981139120 =         request.hasConditions()
                ? ResponseSource.CONDITIONAL_CACHE
                : ResponseSource.NETWORK;
        var119A68D99E23251C9C650BF5A4F6C09B_981139120.addTaint(taint);
        return var119A68D99E23251C9C650BF5A4F6C09B_981139120;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.090 -0400", hash_original_method = "824AD0BBE6883E3213FE3DC10E71C2FB", hash_generated_method = "81A5BFBBEE4081D1A0362949EF354705")
    public boolean validate(ResponseHeaders networkResponse) {
        addTaint(networkResponse.getTaint());
        if(networkResponse.headers.getResponseCode() == HttpURLConnection.HTTP_NOT_MODIFIED)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1002413282 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1415804530 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1415804530;
        } //End block
        if(lastModified != null
                && networkResponse.lastModified != null
                && networkResponse.lastModified.getTime() < lastModified.getTime())        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1360849747 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1368311690 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1368311690;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_87078231 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1507689018 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1507689018;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.092 -0400", hash_original_method = "22AFCF8A6EE54CCCB143274E3F308CC7", hash_generated_method = "69FF3063519630884BC2BECD348DB94F")
    public ResponseHeaders combine(ResponseHeaders network) {
        addTaint(network.getTaint());
        RawHeaders result = new RawHeaders();
for(int i = 0;i < headers.length();i++)
        {
            String fieldName = headers.getFieldName(i);
            String value = headers.getValue(i);
            if(fieldName.equals("Warning") && value.startsWith("1"))            
            {
                continue;
            } //End block
            if(!isEndToEnd(fieldName) || network.headers.get(fieldName) == null)            
            {
                result.add(fieldName, value);
            } //End block
        } //End block
for(int i = 0;i < network.headers.length();i++)
        {
            String fieldName = network.headers.getFieldName(i);
            if(isEndToEnd(fieldName))            
            {
                result.add(fieldName, network.headers.getValue(i));
            } //End block
        } //End block
ResponseHeaders varBC0B9C117D11B2A6A830E7D800770C7D_1047153866 =         new ResponseHeaders(uri, result);
        varBC0B9C117D11B2A6A830E7D800770C7D_1047153866.addTaint(taint);
        return varBC0B9C117D11B2A6A830E7D800770C7D_1047153866;
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

    
    @DSModeled(DSC.BAN)
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.093 -0400", hash_original_field = "9E9631C60162867EAC3B22BAAE81CD7C", hash_generated_field = "9986D9D5D7C36DB8D79AB8BB9949FD3C")

    private static final String SENT_MILLIS = "X-Android-Sent-Millis";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.093 -0400", hash_original_field = "DDACC30001586FA5A6ADAB14BD771FAB", hash_generated_field = "AFD1C82C7B74A7F57C473B3A0514C0CC")

    private static final String RECEIVED_MILLIS = "X-Android-Received-Millis";
}

