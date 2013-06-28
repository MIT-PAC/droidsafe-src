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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.630 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "DDFAECCF21F90F28142F5C866534A5C3")

    private URI uri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.630 -0400", hash_original_field = "4340FD73E75DF7A9D9E45902A59BA3A4", hash_generated_field = "534F1B0AE2D401678B9C67DE48E937E4")

    private RawHeaders headers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.630 -0400", hash_original_field = "255C768659E137E647AD19DAAA113055", hash_generated_field = "3C9D71E60FDD69589ECCD3D4127D69BC")

    private Date servedDate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.630 -0400", hash_original_field = "56D4CE3ADDD9E0185B21EB938EA5BC79", hash_generated_field = "82D9B6029A259946FCFF39FA4D23937A")

    private Date lastModified;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.630 -0400", hash_original_field = "09BCB72D61C0D6D1EFF5336DA6881557", hash_generated_field = "310069CCAEBFEB04D5AA82E2ACE2110A")

    private Date expires;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.630 -0400", hash_original_field = "2DB04C3277683DB70B0D07522DD798E9", hash_generated_field = "53AB8B4205AECB145C66AA09F7622312")

    private long sentRequestMillis;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.630 -0400", hash_original_field = "97EAE8D73925A6238D9D413B6589D432", hash_generated_field = "D2D5C4E73D9772663AEEE06EBF7F2306")

    private long receivedResponseMillis;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.630 -0400", hash_original_field = "3EDE331CCA63FAAFB68A34ACB42767C6", hash_generated_field = "5465707577DD6326819BA83CC3A7DE3E")

    private boolean noCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.630 -0400", hash_original_field = "4EAEDC49CC94AC327BA1C989626A4650", hash_generated_field = "E29F285792A57AA06DFE3E8F60AA431B")

    private boolean noStore;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.630 -0400", hash_original_field = "B29571B8149006A2CE1968134C4493D4", hash_generated_field = "6AE706B03701B766A1504BFD91199E77")

    private int maxAgeSeconds = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.630 -0400", hash_original_field = "CABA19AD91000B29CF602FF3160B2505", hash_generated_field = "C42B9B760D56807C5A8089CC41DE4FAD")

    private int sMaxAgeSeconds = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.630 -0400", hash_original_field = "16995EEF256269CFE8804FFAF770CB4B", hash_generated_field = "4315CF686F5A893F6508AE7DC5DB95BF")

    private boolean isPublic;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.630 -0400", hash_original_field = "F743118D2A1306352619EE9399545214", hash_generated_field = "DC5EDF8BDDA2C085BD8FEEA27C73CDDC")

    private boolean mustRevalidate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.630 -0400", hash_original_field = "1872ADE88F3013EDEB33DECD74A4F947", hash_generated_field = "B46F71525C78B55AB18E5645D7ACEB23")

    private String etag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.630 -0400", hash_original_field = "5BEEEA8F4990B45AFEC4D7C108C16DCD", hash_generated_field = "CCAA9D3543734EDD63F2970D27646F7A")

    private int ageSeconds = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.630 -0400", hash_original_field = "69E5F23E7A9FFA364853DD8FDEE9BB4E", hash_generated_field = "6E0F5B8CADA6537D578924642B4404D4")

    private Set<String> varyFields = Collections.emptySet();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.630 -0400", hash_original_field = "8D5FC32AC7506D2C0AC6949566E3BBE2", hash_generated_field = "62E683CB8A19320AEC224EE11BCD9187")

    private String contentEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.630 -0400", hash_original_field = "BF0487A5497D96D26C24936A4DAD1B2F", hash_generated_field = "53F1E445144D7EEFF13D2F87736EF02D")

    private String transferEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.630 -0400", hash_original_field = "23620B0ED7D2D6853307DFADB119A41C", hash_generated_field = "C51A9B467DA1E79F88DC6617E76DB248")

    private int contentLength = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.630 -0400", hash_original_field = "4717D53EBFDFEA8477F780EC66151DCB", hash_generated_field = "DB0F18ED2FD7BBA4B7D89988BC77D94E")

    private String connection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.630 -0400", hash_original_field = "23C886695D450E9E6FBD359CA1A9C75A", hash_generated_field = "9CC28CE45A3E28EC763E1280217EFAB0")

    private String proxyAuthenticate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.630 -0400", hash_original_field = "422BF398592867CC60C026C5302F13F9", hash_generated_field = "9D861AD424B4AE7E491841BD219A8EC5")

    private String wwwAuthenticate;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.634 -0400", hash_original_method = "DB24454BC912323B5FCB6CCA35CD9240", hash_generated_method = "016C2F6B4BC703A585DAD99C9952435A")
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
        {
            int i = 0;
            boolean var160466EB7D7D5C6ABB8E6B06A85E2B1F_1148782849 = (i < headers.length());
            {
                String fieldName = headers.getFieldName(i);
                String value = headers.getValue(i);
                {
                    boolean varD77C8259EAFC94FDC3D657C8834E9487_1716969225 = ("Cache-Control".equalsIgnoreCase(fieldName));
                    {
                        HeaderParser.parseCacheControl(value, handler);
                    } //End block
                    {
                        boolean varCD2F40E0A98D4A2889CEF7D95E8C27B6_623421720 = ("Date".equalsIgnoreCase(fieldName));
                        {
                            servedDate = HttpDate.parse(value);
                        } //End block
                        {
                            boolean varFF31A566C873782CB1B6419F2EA65B9B_476433061 = ("Expires".equalsIgnoreCase(fieldName));
                            {
                                expires = HttpDate.parse(value);
                            } //End block
                            {
                                boolean varF822263BF24EE652AEAC401809AA6D16_1542074357 = ("Last-Modified".equalsIgnoreCase(fieldName));
                                {
                                    lastModified = HttpDate.parse(value);
                                } //End block
                                {
                                    boolean varF8CE2CB6DBD80B918C5E86CA7C93086E_1920787260 = ("ETag".equalsIgnoreCase(fieldName));
                                    {
                                        etag = value;
                                    } //End block
                                    {
                                        boolean varF67FD1E33B33C098C7C18DAC1CAB54CA_95144626 = ("Pragma".equalsIgnoreCase(fieldName));
                                        {
                                            {
                                                boolean varBF5A1C7105ABE0EE086840F1E4D55F8F_1320244684 = (value.equalsIgnoreCase("no-cache"));
                                                {
                                                    noCache = true;
                                                } //End block
                                            } //End collapsed parenthetic
                                        } //End block
                                        {
                                            boolean var99A7D647B7FD011AD12776CEEB4CB8E4_361574071 = ("Age".equalsIgnoreCase(fieldName));
                                            {
                                                ageSeconds = HeaderParser.parseSeconds(value);
                                            } //End block
                                            {
                                                boolean var612924547FC43DA2310DC180CE3DB55D_1952496268 = ("Vary".equalsIgnoreCase(fieldName));
                                                {
                                                    {
                                                        boolean var17D81E0032232EA0EDAFB415443EF53C_1708393836 = (varyFields.isEmpty());
                                                        {
                                                            varyFields = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
                                                        } //End block
                                                    } //End collapsed parenthetic
                                                    {
                                                        Iterator<String> var154416020BE200D943446034B260BA51_1343928621 = (value.split(",")).iterator();
                                                        var154416020BE200D943446034B260BA51_1343928621.hasNext();
                                                        String varyField = var154416020BE200D943446034B260BA51_1343928621.next();
                                                        {
                                                            varyFields.add(varyField.trim());
                                                        } //End block
                                                    } //End collapsed parenthetic
                                                } //End block
                                                {
                                                    boolean varEEEFC20C1240BBA2C8B42C2F114E2C2A_1883870516 = ("Content-Encoding".equalsIgnoreCase(fieldName));
                                                    {
                                                        contentEncoding = value;
                                                    } //End block
                                                    {
                                                        boolean varA366C7C732EE22377F02D6DB49D33763_1389942509 = ("Transfer-Encoding".equalsIgnoreCase(fieldName));
                                                        {
                                                            transferEncoding = value;
                                                        } //End block
                                                        {
                                                            boolean var4E5AA53DFDC181F206D0324535D36C6E_1861712534 = ("Content-Length".equalsIgnoreCase(fieldName));
                                                            {
                                                                try 
                                                                {
                                                                    contentLength = Integer.parseInt(value);
                                                                } //End block
                                                                catch (NumberFormatException ignored)
                                                                { }
                                                            } //End block
                                                            {
                                                                boolean var5C79FBE6D9AF7B34CADBD78E33DD3307_1764448716 = ("Connection".equalsIgnoreCase(fieldName));
                                                                {
                                                                    connection = value;
                                                                } //End block
                                                                {
                                                                    boolean varED6BC7458920C777A36871BDDC3FC8DD_2012328777 = ("Proxy-Authenticate".equalsIgnoreCase(fieldName));
                                                                    {
                                                                        proxyAuthenticate = value;
                                                                    } //End block
                                                                    {
                                                                        boolean var62B7EE9803087906A523F2C6F7F108AF_1453342386 = ("WWW-Authenticate".equalsIgnoreCase(fieldName));
                                                                        {
                                                                            wwwAuthenticate = value;
                                                                        } //End block
                                                                        {
                                                                            boolean var7282ECC69B104D2DF8853E528D50BFCD_170363314 = (SENT_MILLIS.equalsIgnoreCase(fieldName));
                                                                            {
                                                                                sentRequestMillis = Long.parseLong(value);
                                                                            } //End block
                                                                            {
                                                                                boolean var9A941839153BEAB247C8984F1B4249AA_2081176060 = (RECEIVED_MILLIS.equalsIgnoreCase(fieldName));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.635 -0400", hash_original_method = "796365D0FCCA6BD674FA822FBE40C059", hash_generated_method = "5AD6CC566F45939FDCEAC8A04795F01E")
    public boolean isContentEncodingGzip() {
        boolean varC0E28EA1539FF174C033FE8D4327D4D0_1871276416 = ("gzip".equalsIgnoreCase(contentEncoding));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1306463600 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1306463600;
        // ---------- Original Method ----------
        //return "gzip".equalsIgnoreCase(contentEncoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.635 -0400", hash_original_method = "AD1C758BD3B96983B4362B4ECCA164D6", hash_generated_method = "E13F95E67AAC2117E89E0EFDCED90CA7")
    public void stripContentEncoding() {
        contentEncoding = null;
        headers.removeAll("Content-Encoding");
        // ---------- Original Method ----------
        //contentEncoding = null;
        //headers.removeAll("Content-Encoding");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.635 -0400", hash_original_method = "00B64F53B1189DFD8EFC83FE9CA41E37", hash_generated_method = "ABDF8C2CAD8CAFF93A06B73327CE91BF")
    public boolean isChunked() {
        boolean varA16BCACE603C83FBCA10B7C6B1A17953_1389324346 = ("chunked".equalsIgnoreCase(transferEncoding));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_636220734 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_636220734;
        // ---------- Original Method ----------
        //return "chunked".equalsIgnoreCase(transferEncoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.635 -0400", hash_original_method = "0C9005E446549CA2DCD479C6BCCC6A35", hash_generated_method = "DD629A0613EDB51C1765C152C56DC704")
    public boolean hasConnectionClose() {
        boolean var81EEBB6E2271640A61DE6C091C411E9C_1181290896 = ("close".equalsIgnoreCase(connection));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1780923428 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1780923428;
        // ---------- Original Method ----------
        //return "close".equalsIgnoreCase(connection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.636 -0400", hash_original_method = "F8E205165DB0FFA5BCD89362DFA95E13", hash_generated_method = "D015062AA56BE220F10BCDBD287908A2")
    public URI getUri() {
        URI varB4EAC82CA7396A68D541C85D26508E83_804041582 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_804041582 = uri;
        varB4EAC82CA7396A68D541C85D26508E83_804041582.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_804041582;
        // ---------- Original Method ----------
        //return uri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.636 -0400", hash_original_method = "8B8008667EA7E940C84B2A1E4AADF211", hash_generated_method = "CFED94A60AFF0D9CEBCE5D8BE1C23D4B")
    public RawHeaders getHeaders() {
        RawHeaders varB4EAC82CA7396A68D541C85D26508E83_1271436575 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1271436575 = headers;
        varB4EAC82CA7396A68D541C85D26508E83_1271436575.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1271436575;
        // ---------- Original Method ----------
        //return headers;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.637 -0400", hash_original_method = "F90446E53D3AF5BE7BA6FACCF3504208", hash_generated_method = "3E428F8B7B9B2FF464D4213556404265")
    public Date getServedDate() {
        Date varB4EAC82CA7396A68D541C85D26508E83_188795332 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_188795332 = servedDate;
        varB4EAC82CA7396A68D541C85D26508E83_188795332.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_188795332;
        // ---------- Original Method ----------
        //return servedDate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.637 -0400", hash_original_method = "B44D0D5D3FBE8A04568E9D9F3E9708AC", hash_generated_method = "D021F7D3B576DA35ACE20F8FFFA2B317")
    public Date getLastModified() {
        Date varB4EAC82CA7396A68D541C85D26508E83_1792869398 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1792869398 = lastModified;
        varB4EAC82CA7396A68D541C85D26508E83_1792869398.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1792869398;
        // ---------- Original Method ----------
        //return lastModified;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.637 -0400", hash_original_method = "D14D02C8B70C044F75369CCEC64D849F", hash_generated_method = "4A9E61D817439830DB0B9434C28C2DC4")
    public Date getExpires() {
        Date varB4EAC82CA7396A68D541C85D26508E83_1418543276 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1418543276 = expires;
        varB4EAC82CA7396A68D541C85D26508E83_1418543276.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1418543276;
        // ---------- Original Method ----------
        //return expires;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.638 -0400", hash_original_method = "6FC1CEF1DCDA63846245A172D489494E", hash_generated_method = "8285787F4C9F06A97F023B8210BCCD03")
    public boolean isNoCache() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2101394224 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2101394224;
        // ---------- Original Method ----------
        //return noCache;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.638 -0400", hash_original_method = "41C92D037056676770FDD2CB72F93600", hash_generated_method = "FF4D8F888967CCE2437CAD354DB7A238")
    public boolean isNoStore() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_762338267 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_762338267;
        // ---------- Original Method ----------
        //return noStore;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.638 -0400", hash_original_method = "A8F2E8C976B81B2FCD2E37C57E26B8BC", hash_generated_method = "3908FAB00B006070E061C17981406F30")
    public int getMaxAgeSeconds() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_128435273 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_128435273;
        // ---------- Original Method ----------
        //return maxAgeSeconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.638 -0400", hash_original_method = "E2E5751856DD8B4562FF25B8FB1901CF", hash_generated_method = "F83EA14ACB09EF4E66F943EA1BAE715E")
    public int getSMaxAgeSeconds() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1407481454 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1407481454;
        // ---------- Original Method ----------
        //return sMaxAgeSeconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.638 -0400", hash_original_method = "5C207DA5362424777671E2427CD32289", hash_generated_method = "F4BF9EF0A41538D2371CDA35A2306932")
    public boolean isPublic() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_812048115 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_812048115;
        // ---------- Original Method ----------
        //return isPublic;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.638 -0400", hash_original_method = "E05A87C935BB761C11F60283BED9A93A", hash_generated_method = "831C73102A2D3D7906E738789DD05644")
    public boolean isMustRevalidate() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1129661314 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1129661314;
        // ---------- Original Method ----------
        //return mustRevalidate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.639 -0400", hash_original_method = "2F22856D0A054825BF540D28FE4EB44E", hash_generated_method = "BE6B77BB2997CCA90E55412CF0EAF4BA")
    public String getEtag() {
        String varB4EAC82CA7396A68D541C85D26508E83_2095425857 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2095425857 = etag;
        varB4EAC82CA7396A68D541C85D26508E83_2095425857.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2095425857;
        // ---------- Original Method ----------
        //return etag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.639 -0400", hash_original_method = "C8C00D8A1144BBC8C8A6E2EAAA43E379", hash_generated_method = "C76FF728B379A21307D71910433843A4")
    public Set<String> getVaryFields() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_602726918 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_602726918 = varyFields;
        varB4EAC82CA7396A68D541C85D26508E83_602726918.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_602726918;
        // ---------- Original Method ----------
        //return varyFields;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.639 -0400", hash_original_method = "801F0D0C73EEE64E68A729BCCDAD74D7", hash_generated_method = "10855C78DF4006BC7139077A4CD3FAE2")
    public String getContentEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1204797653 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1204797653 = contentEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_1204797653.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1204797653;
        // ---------- Original Method ----------
        //return contentEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.640 -0400", hash_original_method = "1B52BDD2BF1D0E488CD60B58C0023743", hash_generated_method = "33BE6D4E1F2F0B8DEBED160DD2DB0781")
    public int getContentLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1378256941 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1378256941;
        // ---------- Original Method ----------
        //return contentLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.640 -0400", hash_original_method = "B2D78684E046945E6BE853B24B15E901", hash_generated_method = "828D35D0AF5112A9424B0911E3288274")
    public String getConnection() {
        String varB4EAC82CA7396A68D541C85D26508E83_211890439 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_211890439 = connection;
        varB4EAC82CA7396A68D541C85D26508E83_211890439.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_211890439;
        // ---------- Original Method ----------
        //return connection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.640 -0400", hash_original_method = "BA8A66BA629083526749CA96982906E0", hash_generated_method = "2B523D1DEF1F98917C83F18EE588A592")
    public String getProxyAuthenticate() {
        String varB4EAC82CA7396A68D541C85D26508E83_916444344 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_916444344 = proxyAuthenticate;
        varB4EAC82CA7396A68D541C85D26508E83_916444344.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_916444344;
        // ---------- Original Method ----------
        //return proxyAuthenticate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.641 -0400", hash_original_method = "9336A6C75F9FBB86806462CCF41FEBB3", hash_generated_method = "5E9ABAE95E13857C25713FA326F687AA")
    public String getWwwAuthenticate() {
        String varB4EAC82CA7396A68D541C85D26508E83_957386119 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_957386119 = wwwAuthenticate;
        varB4EAC82CA7396A68D541C85D26508E83_957386119.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_957386119;
        // ---------- Original Method ----------
        //return wwwAuthenticate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.641 -0400", hash_original_method = "22FEE68D81D5D179ED2595CC992792BF", hash_generated_method = "DC80F96132036FAD673859E5C2212566")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.641 -0400", hash_original_method = "62B4E508B2BD1FD8674C188E31D3FA94", hash_generated_method = "F6DB5ABE9F594102FFE89F87A4680F13")
    private long computeAge(long nowMillis) {
        long apparentReceivedAge;
        apparentReceivedAge = Math.max(0, receivedResponseMillis - servedDate.getTime());
        apparentReceivedAge = 0;
        long receivedAge;
        receivedAge = Math.max(apparentReceivedAge, TimeUnit.SECONDS.toMillis(ageSeconds));
        receivedAge = apparentReceivedAge;
        long responseDuration = receivedResponseMillis - sentRequestMillis;
        long residentDuration = nowMillis - receivedResponseMillis;
        addTaint(nowMillis);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_275894846 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_275894846;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.642 -0400", hash_original_method = "723583A81B93D8753154A40B95765CF8", hash_generated_method = "A3DD28A58B79627780002B0A314536D0")
    private long computeFreshnessLifetime() {
        {
            long varE87156FA27F9CF79D97CBA7040DC6B66_1106200653 = (TimeUnit.SECONDS.toMillis(maxAgeSeconds));
        } //End block
        {
            long servedMillis;
            servedMillis = servedDate.getTime();
            servedMillis = receivedResponseMillis;
            long delta = expires.getTime() - servedMillis;
        } //End block
        {
            boolean var9B1D6757A89860DA2B5EAB9B5FBCE1D5_1749845720 = (lastModified != null && uri.getRawQuery() == null);
            {
                long servedMillis;
                servedMillis = servedDate.getTime();
                servedMillis = sentRequestMillis;
                long delta = servedMillis - lastModified.getTime();
            } //End block
        } //End collapsed parenthetic
        long var0F5264038205EDFB1AC05FBB0E8C5E94_152079811 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_152079811;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.642 -0400", hash_original_method = "8F28A3C0281B6F16DECF00092A03388F", hash_generated_method = "1433982791B4E8F6EFE85A47B708851F")
    private boolean isFreshnessLifetimeHeuristic() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_484711243 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_484711243;
        // ---------- Original Method ----------
        //return maxAgeSeconds == -1 && expires == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.642 -0400", hash_original_method = "E402151342DE994EEE4FC3989E09156E", hash_generated_method = "E269982E6DA8B3F715E06B8711367069")
    public boolean isCacheable(RequestHeaders request) {
        int responseCode = headers.getResponseCode();
        {
            boolean varE24C55697985C1233F502262CD22E5D4_1143801755 = (request.hasAuthorization()
                && !isPublic
                && !mustRevalidate
                && sMaxAgeSeconds == -1);
        } //End collapsed parenthetic
        addTaint(request.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_322236265 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_322236265;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.643 -0400", hash_original_method = "937D0115F7BB3894701032373C9A4BC7", hash_generated_method = "0B97AE8C5D4A427833DD52139523A5E9")
    public boolean hasVaryAll() {
        boolean varC738253CEA254131A804BC3CB6A34FC1_1762605139 = (varyFields.contains("*"));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1631810346 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1631810346;
        // ---------- Original Method ----------
        //return varyFields.contains("*");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.660 -0400", hash_original_method = "AE2D57CEA29D6AAD43D079D6A743C143", hash_generated_method = "32D41472983882F12D740C6A908A95A6")
    public boolean varyMatches(Map<String, List<String>> cachedRequest,
            Map<String, List<String>> newRequest) {
        {
            Iterator<String> varC1185F1BCBF99AA0F507E14EFA1E99A9_1496634673 = (varyFields).iterator();
            varC1185F1BCBF99AA0F507E14EFA1E99A9_1496634673.hasNext();
            String field = varC1185F1BCBF99AA0F507E14EFA1E99A9_1496634673.next();
            {
                {
                    boolean var757B3024B7F14E3064F0E604913C8246_228663944 = (!Objects.equal(cachedRequest.get(field), newRequest.get(field)));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(cachedRequest.getTaint());
        addTaint(newRequest.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2138135731 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2138135731;
        // ---------- Original Method ----------
        //for (String field : varyFields) {
            //if (!Objects.equal(cachedRequest.get(field), newRequest.get(field))) {
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.662 -0400", hash_original_method = "564BBC9A8CA0CE268623CE0DAE1CD407", hash_generated_method = "371A36B7BC40BD24CFF2A110C8EEB2A1")
    public ResponseSource chooseResponseSource(long nowMillis, RequestHeaders request) {
        ResponseSource varB4EAC82CA7396A68D541C85D26508E83_678501019 = null; //Variable for return #1
        ResponseSource varB4EAC82CA7396A68D541C85D26508E83_364278123 = null; //Variable for return #2
        ResponseSource varB4EAC82CA7396A68D541C85D26508E83_1877888649 = null; //Variable for return #3
        ResponseSource varB4EAC82CA7396A68D541C85D26508E83_261893131 = null; //Variable for return #4
        {
            boolean var7012CA4B5F50B57A637C81F78E278477_2130283133 = (!isCacheable(request));
            {
                varB4EAC82CA7396A68D541C85D26508E83_678501019 = ResponseSource.NETWORK;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var183378DFF7F1E73CE42B495ED68511EB_1991217404 = (request.isNoCache() || request.hasConditions());
            {
                varB4EAC82CA7396A68D541C85D26508E83_364278123 = ResponseSource.NETWORK;
            } //End block
        } //End collapsed parenthetic
        long ageMillis = computeAge(nowMillis);
        long freshMillis = computeFreshnessLifetime();
        {
            boolean varFA1EF6C3F76EDF9563757934756DC958_1070702793 = (request.getMaxAgeSeconds() != -1);
            {
                freshMillis = Math.min(freshMillis,
                    TimeUnit.SECONDS.toMillis(request.getMaxAgeSeconds()));
            } //End block
        } //End collapsed parenthetic
        long minFreshMillis = 0;
        {
            boolean var0812931521313686CF4E34A994C81573_863886308 = (request.getMinFreshSeconds() != -1);
            {
                minFreshMillis = TimeUnit.SECONDS.toMillis(request.getMinFreshSeconds());
            } //End block
        } //End collapsed parenthetic
        long maxStaleMillis = 0;
        {
            boolean varBE22EC61E082962B9A28D480363F4C25_449795308 = (!mustRevalidate && request.getMaxStaleSeconds() != -1);
            {
                maxStaleMillis = TimeUnit.SECONDS.toMillis(request.getMaxStaleSeconds());
            } //End block
        } //End collapsed parenthetic
        {
            {
                headers.add("Warning", "110 HttpURLConnection \"Response is stale\"");
            } //End block
            {
                boolean var2B158D5C216D94EE4BBEF348BC4C77DA_1637435554 = (ageMillis > TimeUnit.HOURS.toMillis(24) && isFreshnessLifetimeHeuristic());
                {
                    headers.add("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1877888649 = ResponseSource.CACHE;
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
        varB4EAC82CA7396A68D541C85D26508E83_261893131 = request.hasConditions()
                ? ResponseSource.CONDITIONAL_CACHE
                : ResponseSource.NETWORK;
        addTaint(nowMillis);
        addTaint(request.getTaint());
        ResponseSource varA7E53CE21691AB073D9660D615818899_613740460; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_613740460 = varB4EAC82CA7396A68D541C85D26508E83_678501019;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_613740460 = varB4EAC82CA7396A68D541C85D26508E83_364278123;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_613740460 = varB4EAC82CA7396A68D541C85D26508E83_1877888649;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_613740460 = varB4EAC82CA7396A68D541C85D26508E83_261893131;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_613740460.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_613740460;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.665 -0400", hash_original_method = "824AD0BBE6883E3213FE3DC10E71C2FB", hash_generated_method = "3C2EEB4BA9518698B7BC62A67C15B9E1")
    public boolean validate(ResponseHeaders networkResponse) {
        {
            boolean var69CB999E5360904B86AF7CF73BDBAAEE_376733588 = (networkResponse.headers.getResponseCode() == HttpURLConnection.HTTP_NOT_MODIFIED);
        } //End collapsed parenthetic
        {
            boolean var834D152FE75AE1012A8E1C348C001FBE_1467503876 = (lastModified != null
                && networkResponse.lastModified != null
                && networkResponse.lastModified.getTime() < lastModified.getTime());
        } //End collapsed parenthetic
        addTaint(networkResponse.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_629253753 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_629253753;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.666 -0400", hash_original_method = "22AFCF8A6EE54CCCB143274E3F308CC7", hash_generated_method = "FF33AFEC78580EB2DDBE20A7382AB9B0")
    public ResponseHeaders combine(ResponseHeaders network) {
        ResponseHeaders varB4EAC82CA7396A68D541C85D26508E83_792578401 = null; //Variable for return #1
        RawHeaders result = new RawHeaders();
        {
            int i = 0;
            boolean var160466EB7D7D5C6ABB8E6B06A85E2B1F_1162524473 = (i < headers.length());
            {
                String fieldName = headers.getFieldName(i);
                String value = headers.getValue(i);
                {
                    boolean varFBC607F7190EEEDE1D047F61F2153C09_2134217177 = (fieldName.equals("Warning") && value.startsWith("1"));
                } //End collapsed parenthetic
                {
                    boolean var70955E32A6C50C8029AEBBD58FEE2C66_345606849 = (!isEndToEnd(fieldName) || network.headers.get(fieldName) == null);
                    {
                        result.add(fieldName, value);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            int i = 0;
            boolean var1DD03E9C0E7D3AA92950B78E75AFC7C3_108850033 = (i < network.headers.length());
            {
                String fieldName = network.headers.getFieldName(i);
                {
                    boolean var9350CBC579AD9A7B70EC635F591BE067_694948253 = (isEndToEnd(fieldName));
                    {
                        result.add(fieldName, network.headers.getValue(i));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_792578401 = new ResponseHeaders(uri, result);
        addTaint(network.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_792578401.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_792578401;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.667 -0400", hash_original_field = "9E9631C60162867EAC3B22BAAE81CD7C", hash_generated_field = "9986D9D5D7C36DB8D79AB8BB9949FD3C")

    private static final String SENT_MILLIS = "X-Android-Sent-Millis";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:29.667 -0400", hash_original_field = "DDACC30001586FA5A6ADAB14BD771FAB", hash_generated_field = "AFD1C82C7B74A7F57C473B3A0514C0CC")

    private static final String RECEIVED_MILLIS = "X-Android-Received-Millis";
    // orphaned legacy method
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
    
}

