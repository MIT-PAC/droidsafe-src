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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.144 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "DDFAECCF21F90F28142F5C866534A5C3")

    private URI uri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.144 -0400", hash_original_field = "4340FD73E75DF7A9D9E45902A59BA3A4", hash_generated_field = "534F1B0AE2D401678B9C67DE48E937E4")

    private RawHeaders headers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.144 -0400", hash_original_field = "255C768659E137E647AD19DAAA113055", hash_generated_field = "3C9D71E60FDD69589ECCD3D4127D69BC")

    private Date servedDate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.144 -0400", hash_original_field = "56D4CE3ADDD9E0185B21EB938EA5BC79", hash_generated_field = "82D9B6029A259946FCFF39FA4D23937A")

    private Date lastModified;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.144 -0400", hash_original_field = "09BCB72D61C0D6D1EFF5336DA6881557", hash_generated_field = "310069CCAEBFEB04D5AA82E2ACE2110A")

    private Date expires;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.144 -0400", hash_original_field = "2DB04C3277683DB70B0D07522DD798E9", hash_generated_field = "53AB8B4205AECB145C66AA09F7622312")

    private long sentRequestMillis;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.144 -0400", hash_original_field = "97EAE8D73925A6238D9D413B6589D432", hash_generated_field = "D2D5C4E73D9772663AEEE06EBF7F2306")

    private long receivedResponseMillis;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.144 -0400", hash_original_field = "3EDE331CCA63FAAFB68A34ACB42767C6", hash_generated_field = "5465707577DD6326819BA83CC3A7DE3E")

    private boolean noCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.144 -0400", hash_original_field = "4EAEDC49CC94AC327BA1C989626A4650", hash_generated_field = "E29F285792A57AA06DFE3E8F60AA431B")

    private boolean noStore;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.144 -0400", hash_original_field = "B29571B8149006A2CE1968134C4493D4", hash_generated_field = "6AE706B03701B766A1504BFD91199E77")

    private int maxAgeSeconds = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.144 -0400", hash_original_field = "CABA19AD91000B29CF602FF3160B2505", hash_generated_field = "C42B9B760D56807C5A8089CC41DE4FAD")

    private int sMaxAgeSeconds = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.144 -0400", hash_original_field = "16995EEF256269CFE8804FFAF770CB4B", hash_generated_field = "4315CF686F5A893F6508AE7DC5DB95BF")

    private boolean isPublic;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.144 -0400", hash_original_field = "F743118D2A1306352619EE9399545214", hash_generated_field = "DC5EDF8BDDA2C085BD8FEEA27C73CDDC")

    private boolean mustRevalidate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.144 -0400", hash_original_field = "1872ADE88F3013EDEB33DECD74A4F947", hash_generated_field = "B46F71525C78B55AB18E5645D7ACEB23")

    private String etag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.144 -0400", hash_original_field = "5BEEEA8F4990B45AFEC4D7C108C16DCD", hash_generated_field = "CCAA9D3543734EDD63F2970D27646F7A")

    private int ageSeconds = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.144 -0400", hash_original_field = "69E5F23E7A9FFA364853DD8FDEE9BB4E", hash_generated_field = "6E0F5B8CADA6537D578924642B4404D4")

    private Set<String> varyFields = Collections.emptySet();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.144 -0400", hash_original_field = "8D5FC32AC7506D2C0AC6949566E3BBE2", hash_generated_field = "62E683CB8A19320AEC224EE11BCD9187")

    private String contentEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.144 -0400", hash_original_field = "BF0487A5497D96D26C24936A4DAD1B2F", hash_generated_field = "53F1E445144D7EEFF13D2F87736EF02D")

    private String transferEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.144 -0400", hash_original_field = "23620B0ED7D2D6853307DFADB119A41C", hash_generated_field = "C51A9B467DA1E79F88DC6617E76DB248")

    private int contentLength = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.144 -0400", hash_original_field = "4717D53EBFDFEA8477F780EC66151DCB", hash_generated_field = "DB0F18ED2FD7BBA4B7D89988BC77D94E")

    private String connection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.144 -0400", hash_original_field = "23C886695D450E9E6FBD359CA1A9C75A", hash_generated_field = "9CC28CE45A3E28EC763E1280217EFAB0")

    private String proxyAuthenticate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.144 -0400", hash_original_field = "422BF398592867CC60C026C5302F13F9", hash_generated_field = "9D861AD424B4AE7E491841BD219A8EC5")

    private String wwwAuthenticate;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.176 -0400", hash_original_method = "DB24454BC912323B5FCB6CCA35CD9240", hash_generated_method = "52BA05F685F30D2A94628FAEC9336ABE")
    public  ResponseHeaders(URI uri, RawHeaders headers) {
        this.uri = uri;
        this.headers = headers;
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
            boolean var160466EB7D7D5C6ABB8E6B06A85E2B1F_2056431622 = (i < headers.length());
            {
                String fieldName;
                fieldName = headers.getFieldName(i);
                String value;
                value = headers.getValue(i);
                {
                    boolean varD77C8259EAFC94FDC3D657C8834E9487_398597685 = ("Cache-Control".equalsIgnoreCase(fieldName));
                    {
                        HeaderParser.parseCacheControl(value, handler);
                    } //End block
                    {
                        boolean varCD2F40E0A98D4A2889CEF7D95E8C27B6_483007966 = ("Date".equalsIgnoreCase(fieldName));
                        {
                            servedDate = HttpDate.parse(value);
                        } //End block
                        {
                            boolean varFF31A566C873782CB1B6419F2EA65B9B_888125421 = ("Expires".equalsIgnoreCase(fieldName));
                            {
                                expires = HttpDate.parse(value);
                            } //End block
                            {
                                boolean varF822263BF24EE652AEAC401809AA6D16_1822981498 = ("Last-Modified".equalsIgnoreCase(fieldName));
                                {
                                    lastModified = HttpDate.parse(value);
                                } //End block
                                {
                                    boolean varF8CE2CB6DBD80B918C5E86CA7C93086E_533610674 = ("ETag".equalsIgnoreCase(fieldName));
                                    {
                                        etag = value;
                                    } //End block
                                    {
                                        boolean varF67FD1E33B33C098C7C18DAC1CAB54CA_266633541 = ("Pragma".equalsIgnoreCase(fieldName));
                                        {
                                            {
                                                boolean varBF5A1C7105ABE0EE086840F1E4D55F8F_542842216 = (value.equalsIgnoreCase("no-cache"));
                                                {
                                                    noCache = true;
                                                } //End block
                                            } //End collapsed parenthetic
                                        } //End block
                                        {
                                            boolean var99A7D647B7FD011AD12776CEEB4CB8E4_768656775 = ("Age".equalsIgnoreCase(fieldName));
                                            {
                                                ageSeconds = HeaderParser.parseSeconds(value);
                                            } //End block
                                            {
                                                boolean var612924547FC43DA2310DC180CE3DB55D_908911116 = ("Vary".equalsIgnoreCase(fieldName));
                                                {
                                                    {
                                                        boolean var17D81E0032232EA0EDAFB415443EF53C_252025480 = (varyFields.isEmpty());
                                                        {
                                                            varyFields = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
                                                        } //End block
                                                    } //End collapsed parenthetic
                                                    {
                                                        Iterator<String> var154416020BE200D943446034B260BA51_196118224 = (value.split(",")).iterator();
                                                        var154416020BE200D943446034B260BA51_196118224.hasNext();
                                                        String varyField = var154416020BE200D943446034B260BA51_196118224.next();
                                                        {
                                                            varyFields.add(varyField.trim());
                                                        } //End block
                                                    } //End collapsed parenthetic
                                                } //End block
                                                {
                                                    boolean varEEEFC20C1240BBA2C8B42C2F114E2C2A_2073726820 = ("Content-Encoding".equalsIgnoreCase(fieldName));
                                                    {
                                                        contentEncoding = value;
                                                    } //End block
                                                    {
                                                        boolean varA366C7C732EE22377F02D6DB49D33763_1172710265 = ("Transfer-Encoding".equalsIgnoreCase(fieldName));
                                                        {
                                                            transferEncoding = value;
                                                        } //End block
                                                        {
                                                            boolean var4E5AA53DFDC181F206D0324535D36C6E_346684723 = ("Content-Length".equalsIgnoreCase(fieldName));
                                                            {
                                                                try 
                                                                {
                                                                    contentLength = Integer.parseInt(value);
                                                                } //End block
                                                                catch (NumberFormatException ignored)
                                                                { }
                                                            } //End block
                                                            {
                                                                boolean var5C79FBE6D9AF7B34CADBD78E33DD3307_2138919975 = ("Connection".equalsIgnoreCase(fieldName));
                                                                {
                                                                    connection = value;
                                                                } //End block
                                                                {
                                                                    boolean varED6BC7458920C777A36871BDDC3FC8DD_984578870 = ("Proxy-Authenticate".equalsIgnoreCase(fieldName));
                                                                    {
                                                                        proxyAuthenticate = value;
                                                                    } //End block
                                                                    {
                                                                        boolean var62B7EE9803087906A523F2C6F7F108AF_1841270451 = ("WWW-Authenticate".equalsIgnoreCase(fieldName));
                                                                        {
                                                                            wwwAuthenticate = value;
                                                                        } //End block
                                                                        {
                                                                            boolean var7282ECC69B104D2DF8853E528D50BFCD_1948013351 = (SENT_MILLIS.equalsIgnoreCase(fieldName));
                                                                            {
                                                                                sentRequestMillis = Long.parseLong(value);
                                                                            } //End block
                                                                            {
                                                                                boolean var9A941839153BEAB247C8984F1B4249AA_2145888337 = (RECEIVED_MILLIS.equalsIgnoreCase(fieldName));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.177 -0400", hash_original_method = "796365D0FCCA6BD674FA822FBE40C059", hash_generated_method = "BD6D59D34D43251876A016BCCB2D3A41")
    public boolean isContentEncodingGzip() {
        boolean varC0E28EA1539FF174C033FE8D4327D4D0_526527252 = ("gzip".equalsIgnoreCase(contentEncoding));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1902607727 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1902607727;
        // ---------- Original Method ----------
        //return "gzip".equalsIgnoreCase(contentEncoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.177 -0400", hash_original_method = "AD1C758BD3B96983B4362B4ECCA164D6", hash_generated_method = "E13F95E67AAC2117E89E0EFDCED90CA7")
    public void stripContentEncoding() {
        contentEncoding = null;
        headers.removeAll("Content-Encoding");
        // ---------- Original Method ----------
        //contentEncoding = null;
        //headers.removeAll("Content-Encoding");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.186 -0400", hash_original_method = "00B64F53B1189DFD8EFC83FE9CA41E37", hash_generated_method = "E1EF7BE8E77CA19C990B83E11BCBC4E3")
    public boolean isChunked() {
        boolean varA16BCACE603C83FBCA10B7C6B1A17953_1268193031 = ("chunked".equalsIgnoreCase(transferEncoding));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1526717511 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1526717511;
        // ---------- Original Method ----------
        //return "chunked".equalsIgnoreCase(transferEncoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.186 -0400", hash_original_method = "0C9005E446549CA2DCD479C6BCCC6A35", hash_generated_method = "FABE49037383E11535AA391342DB6D2B")
    public boolean hasConnectionClose() {
        boolean var81EEBB6E2271640A61DE6C091C411E9C_685228335 = ("close".equalsIgnoreCase(connection));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1136128709 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1136128709;
        // ---------- Original Method ----------
        //return "close".equalsIgnoreCase(connection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.187 -0400", hash_original_method = "F8E205165DB0FFA5BCD89362DFA95E13", hash_generated_method = "ADF55FCC1C7B0A7BEF10029972DAE9EE")
    public URI getUri() {
        URI varB4EAC82CA7396A68D541C85D26508E83_571275681 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_571275681 = uri;
        varB4EAC82CA7396A68D541C85D26508E83_571275681.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_571275681;
        // ---------- Original Method ----------
        //return uri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.187 -0400", hash_original_method = "8B8008667EA7E940C84B2A1E4AADF211", hash_generated_method = "1698F31729A09123F0CC9E1E76B446E7")
    public RawHeaders getHeaders() {
        RawHeaders varB4EAC82CA7396A68D541C85D26508E83_1597550867 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1597550867 = headers;
        varB4EAC82CA7396A68D541C85D26508E83_1597550867.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1597550867;
        // ---------- Original Method ----------
        //return headers;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.188 -0400", hash_original_method = "F90446E53D3AF5BE7BA6FACCF3504208", hash_generated_method = "B6CB91A5846CBC5EC11D6351FC02181E")
    public Date getServedDate() {
        Date varB4EAC82CA7396A68D541C85D26508E83_480212175 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_480212175 = servedDate;
        varB4EAC82CA7396A68D541C85D26508E83_480212175.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_480212175;
        // ---------- Original Method ----------
        //return servedDate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.188 -0400", hash_original_method = "B44D0D5D3FBE8A04568E9D9F3E9708AC", hash_generated_method = "5F26C444D774CD512B559EE5A26A7F25")
    public Date getLastModified() {
        Date varB4EAC82CA7396A68D541C85D26508E83_815669992 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_815669992 = lastModified;
        varB4EAC82CA7396A68D541C85D26508E83_815669992.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_815669992;
        // ---------- Original Method ----------
        //return lastModified;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.189 -0400", hash_original_method = "D14D02C8B70C044F75369CCEC64D849F", hash_generated_method = "6A1FE3570ABFFB2A89EFEA98DA99A430")
    public Date getExpires() {
        Date varB4EAC82CA7396A68D541C85D26508E83_935506333 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_935506333 = expires;
        varB4EAC82CA7396A68D541C85D26508E83_935506333.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_935506333;
        // ---------- Original Method ----------
        //return expires;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.189 -0400", hash_original_method = "6FC1CEF1DCDA63846245A172D489494E", hash_generated_method = "E667B7FBB306BD23DB20BDDCE38F2F30")
    public boolean isNoCache() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1113955549 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1113955549;
        // ---------- Original Method ----------
        //return noCache;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.189 -0400", hash_original_method = "41C92D037056676770FDD2CB72F93600", hash_generated_method = "7BA5976CB955058EEE31D8FC1DCAE230")
    public boolean isNoStore() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_99008598 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_99008598;
        // ---------- Original Method ----------
        //return noStore;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.190 -0400", hash_original_method = "A8F2E8C976B81B2FCD2E37C57E26B8BC", hash_generated_method = "3307AA251D23AB143F38F4879C28EC97")
    public int getMaxAgeSeconds() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_764721386 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_764721386;
        // ---------- Original Method ----------
        //return maxAgeSeconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.196 -0400", hash_original_method = "E2E5751856DD8B4562FF25B8FB1901CF", hash_generated_method = "F9D34F4FBF95F94842C2B34268B10770")
    public int getSMaxAgeSeconds() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_340016521 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_340016521;
        // ---------- Original Method ----------
        //return sMaxAgeSeconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.196 -0400", hash_original_method = "5C207DA5362424777671E2427CD32289", hash_generated_method = "56B075EDB823FAC82A04067898B263A8")
    public boolean isPublic() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1913245055 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1913245055;
        // ---------- Original Method ----------
        //return isPublic;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.209 -0400", hash_original_method = "E05A87C935BB761C11F60283BED9A93A", hash_generated_method = "398C24AAE721E280B9B35976A81FBB6C")
    public boolean isMustRevalidate() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1686555399 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1686555399;
        // ---------- Original Method ----------
        //return mustRevalidate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.210 -0400", hash_original_method = "2F22856D0A054825BF540D28FE4EB44E", hash_generated_method = "E298B90477A678DF1B67E261DE256CA9")
    public String getEtag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1841458719 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1841458719 = etag;
        varB4EAC82CA7396A68D541C85D26508E83_1841458719.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1841458719;
        // ---------- Original Method ----------
        //return etag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.211 -0400", hash_original_method = "C8C00D8A1144BBC8C8A6E2EAAA43E379", hash_generated_method = "EDF342EBEE325EBABE014ABF6575EF32")
    public Set<String> getVaryFields() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1340637399 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1340637399 = varyFields;
        varB4EAC82CA7396A68D541C85D26508E83_1340637399.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1340637399;
        // ---------- Original Method ----------
        //return varyFields;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.211 -0400", hash_original_method = "801F0D0C73EEE64E68A729BCCDAD74D7", hash_generated_method = "837BC532344B6A55746F72D9AC362427")
    public String getContentEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1918607427 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1918607427 = contentEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_1918607427.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1918607427;
        // ---------- Original Method ----------
        //return contentEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.211 -0400", hash_original_method = "1B52BDD2BF1D0E488CD60B58C0023743", hash_generated_method = "5F91DD03B93D9F62156058C5B80F4A78")
    public int getContentLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_613938099 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_613938099;
        // ---------- Original Method ----------
        //return contentLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.219 -0400", hash_original_method = "B2D78684E046945E6BE853B24B15E901", hash_generated_method = "4523ACFE733C0B3B43ABFE56132A5494")
    public String getConnection() {
        String varB4EAC82CA7396A68D541C85D26508E83_1563502569 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1563502569 = connection;
        varB4EAC82CA7396A68D541C85D26508E83_1563502569.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1563502569;
        // ---------- Original Method ----------
        //return connection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.220 -0400", hash_original_method = "BA8A66BA629083526749CA96982906E0", hash_generated_method = "71CD663D74E1C293D11A1B75059871AD")
    public String getProxyAuthenticate() {
        String varB4EAC82CA7396A68D541C85D26508E83_2128295486 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2128295486 = proxyAuthenticate;
        varB4EAC82CA7396A68D541C85D26508E83_2128295486.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2128295486;
        // ---------- Original Method ----------
        //return proxyAuthenticate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.220 -0400", hash_original_method = "9336A6C75F9FBB86806462CCF41FEBB3", hash_generated_method = "683DEE1A633858D4AE6DE10D9F4725B5")
    public String getWwwAuthenticate() {
        String varB4EAC82CA7396A68D541C85D26508E83_90009318 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_90009318 = wwwAuthenticate;
        varB4EAC82CA7396A68D541C85D26508E83_90009318.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_90009318;
        // ---------- Original Method ----------
        //return wwwAuthenticate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.221 -0400", hash_original_method = "22FEE68D81D5D179ED2595CC992792BF", hash_generated_method = "DC80F96132036FAD673859E5C2212566")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.221 -0400", hash_original_method = "62B4E508B2BD1FD8674C188E31D3FA94", hash_generated_method = "ED12E8631E3C340A2B79234127462245")
    private long computeAge(long nowMillis) {
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
        addTaint(nowMillis);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1480298260 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1480298260;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.222 -0400", hash_original_method = "723583A81B93D8753154A40B95765CF8", hash_generated_method = "2BAE4B363D9597E8D006AC5FDE869EF4")
    private long computeFreshnessLifetime() {
        {
            long varE87156FA27F9CF79D97CBA7040DC6B66_1421151374 = (TimeUnit.SECONDS.toMillis(maxAgeSeconds));
        } //End block
        {
            long servedMillis;
            servedMillis = servedDate.getTime();
            servedMillis = receivedResponseMillis;
            long delta;
            delta = expires.getTime() - servedMillis;
        } //End block
        {
            boolean var9B1D6757A89860DA2B5EAB9B5FBCE1D5_281426465 = (lastModified != null && uri.getRawQuery() == null);
            {
                long servedMillis;
                servedMillis = servedDate.getTime();
                servedMillis = sentRequestMillis;
                long delta;
                delta = servedMillis - lastModified.getTime();
            } //End block
        } //End collapsed parenthetic
        long var0F5264038205EDFB1AC05FBB0E8C5E94_348433164 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_348433164;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.222 -0400", hash_original_method = "8F28A3C0281B6F16DECF00092A03388F", hash_generated_method = "73881DAAFB02D584F7CD41F7556B4828")
    private boolean isFreshnessLifetimeHeuristic() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1708536767 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1708536767;
        // ---------- Original Method ----------
        //return maxAgeSeconds == -1 && expires == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.223 -0400", hash_original_method = "E402151342DE994EEE4FC3989E09156E", hash_generated_method = "C1F1A7F6DD23BAD982FF73D8A76A3662")
    public boolean isCacheable(RequestHeaders request) {
        int responseCode;
        responseCode = headers.getResponseCode();
        {
            boolean varE24C55697985C1233F502262CD22E5D4_422244207 = (request.hasAuthorization()
                && !isPublic
                && !mustRevalidate
                && sMaxAgeSeconds == -1);
        } //End collapsed parenthetic
        addTaint(request.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_402763248 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_402763248;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.227 -0400", hash_original_method = "937D0115F7BB3894701032373C9A4BC7", hash_generated_method = "3DA86FF0FDB8DA47574F08E294FC764F")
    public boolean hasVaryAll() {
        boolean varC738253CEA254131A804BC3CB6A34FC1_770009601 = (varyFields.contains("*"));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1081784807 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1081784807;
        // ---------- Original Method ----------
        //return varyFields.contains("*");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.250 -0400", hash_original_method = "AE2D57CEA29D6AAD43D079D6A743C143", hash_generated_method = "7431387E763399261C201F1FD3C9B2D2")
    public boolean varyMatches(Map<String, List<String>> cachedRequest,
            Map<String, List<String>> newRequest) {
        {
            Iterator<String> varC1185F1BCBF99AA0F507E14EFA1E99A9_1088646316 = (varyFields).iterator();
            varC1185F1BCBF99AA0F507E14EFA1E99A9_1088646316.hasNext();
            String field = varC1185F1BCBF99AA0F507E14EFA1E99A9_1088646316.next();
            {
                {
                    boolean var757B3024B7F14E3064F0E604913C8246_1515252402 = (!Objects.equal(cachedRequest.get(field), newRequest.get(field)));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(cachedRequest.getTaint());
        addTaint(newRequest.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1270342214 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1270342214;
        // ---------- Original Method ----------
        //for (String field : varyFields) {
            //if (!Objects.equal(cachedRequest.get(field), newRequest.get(field))) {
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.261 -0400", hash_original_method = "564BBC9A8CA0CE268623CE0DAE1CD407", hash_generated_method = "4E1DEFFCDD8A33000556EB5C9125074C")
    public ResponseSource chooseResponseSource(long nowMillis, RequestHeaders request) {
        ResponseSource varB4EAC82CA7396A68D541C85D26508E83_266267953 = null; //Variable for return #1
        ResponseSource varB4EAC82CA7396A68D541C85D26508E83_920538280 = null; //Variable for return #2
        ResponseSource varB4EAC82CA7396A68D541C85D26508E83_93766698 = null; //Variable for return #3
        ResponseSource varB4EAC82CA7396A68D541C85D26508E83_238874354 = null; //Variable for return #4
        {
            boolean var7012CA4B5F50B57A637C81F78E278477_953671983 = (!isCacheable(request));
            {
                varB4EAC82CA7396A68D541C85D26508E83_266267953 = ResponseSource.NETWORK;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var183378DFF7F1E73CE42B495ED68511EB_211196533 = (request.isNoCache() || request.hasConditions());
            {
                varB4EAC82CA7396A68D541C85D26508E83_920538280 = ResponseSource.NETWORK;
            } //End block
        } //End collapsed parenthetic
        long ageMillis;
        ageMillis = computeAge(nowMillis);
        long freshMillis;
        freshMillis = computeFreshnessLifetime();
        {
            boolean varFA1EF6C3F76EDF9563757934756DC958_503406332 = (request.getMaxAgeSeconds() != -1);
            {
                freshMillis = Math.min(freshMillis,
                    TimeUnit.SECONDS.toMillis(request.getMaxAgeSeconds()));
            } //End block
        } //End collapsed parenthetic
        long minFreshMillis;
        minFreshMillis = 0;
        {
            boolean var0812931521313686CF4E34A994C81573_2050704088 = (request.getMinFreshSeconds() != -1);
            {
                minFreshMillis = TimeUnit.SECONDS.toMillis(request.getMinFreshSeconds());
            } //End block
        } //End collapsed parenthetic
        long maxStaleMillis;
        maxStaleMillis = 0;
        {
            boolean varBE22EC61E082962B9A28D480363F4C25_875645875 = (!mustRevalidate && request.getMaxStaleSeconds() != -1);
            {
                maxStaleMillis = TimeUnit.SECONDS.toMillis(request.getMaxStaleSeconds());
            } //End block
        } //End collapsed parenthetic
        {
            {
                headers.add("Warning", "110 HttpURLConnection \"Response is stale\"");
            } //End block
            {
                boolean var2B158D5C216D94EE4BBEF348BC4C77DA_467099293 = (ageMillis > TimeUnit.HOURS.toMillis(24) && isFreshnessLifetimeHeuristic());
                {
                    headers.add("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_93766698 = ResponseSource.CACHE;
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
        varB4EAC82CA7396A68D541C85D26508E83_238874354 = request.hasConditions()
                ? ResponseSource.CONDITIONAL_CACHE
                : ResponseSource.NETWORK;
        addTaint(nowMillis);
        addTaint(request.getTaint());
        ResponseSource varA7E53CE21691AB073D9660D615818899_118714029; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_118714029 = varB4EAC82CA7396A68D541C85D26508E83_266267953;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_118714029 = varB4EAC82CA7396A68D541C85D26508E83_920538280;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_118714029 = varB4EAC82CA7396A68D541C85D26508E83_93766698;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_118714029 = varB4EAC82CA7396A68D541C85D26508E83_238874354;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_118714029.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_118714029;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.263 -0400", hash_original_method = "824AD0BBE6883E3213FE3DC10E71C2FB", hash_generated_method = "907E9BE3CA411E6C1C9A79E52A1E7575")
    public boolean validate(ResponseHeaders networkResponse) {
        {
            boolean var69CB999E5360904B86AF7CF73BDBAAEE_979860655 = (networkResponse.headers.getResponseCode() == HttpURLConnection.HTTP_NOT_MODIFIED);
        } //End collapsed parenthetic
        {
            boolean var834D152FE75AE1012A8E1C348C001FBE_934508727 = (lastModified != null
                && networkResponse.lastModified != null
                && networkResponse.lastModified.getTime() < lastModified.getTime());
        } //End collapsed parenthetic
        addTaint(networkResponse.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1178223168 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1178223168;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.274 -0400", hash_original_method = "22AFCF8A6EE54CCCB143274E3F308CC7", hash_generated_method = "3BB4FEA4CDC35BC5E127326BFDBE1C23")
    public ResponseHeaders combine(ResponseHeaders network) {
        ResponseHeaders varB4EAC82CA7396A68D541C85D26508E83_161750412 = null; //Variable for return #1
        RawHeaders result;
        result = new RawHeaders();
        {
            int i;
            i = 0;
            boolean var160466EB7D7D5C6ABB8E6B06A85E2B1F_1139968485 = (i < headers.length());
            {
                String fieldName;
                fieldName = headers.getFieldName(i);
                String value;
                value = headers.getValue(i);
                {
                    boolean varFBC607F7190EEEDE1D047F61F2153C09_1078130102 = (fieldName.equals("Warning") && value.startsWith("1"));
                } //End collapsed parenthetic
                {
                    boolean var70955E32A6C50C8029AEBBD58FEE2C66_658963594 = (!isEndToEnd(fieldName) || network.headers.get(fieldName) == null);
                    {
                        result.add(fieldName, value);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            int i;
            i = 0;
            boolean var1DD03E9C0E7D3AA92950B78E75AFC7C3_1719572943 = (i < network.headers.length());
            {
                String fieldName;
                fieldName = network.headers.getFieldName(i);
                {
                    boolean var9350CBC579AD9A7B70EC635F591BE067_1702285667 = (isEndToEnd(fieldName));
                    {
                        result.add(fieldName, network.headers.getValue(i));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_161750412 = new ResponseHeaders(uri, result);
        addTaint(network.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_161750412.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_161750412;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.275 -0400", hash_original_field = "9E9631C60162867EAC3B22BAAE81CD7C", hash_generated_field = "F4CDA34343B1A96CE1262FF47CBD6C39")

    private static String SENT_MILLIS = "X-Android-Sent-Millis";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:05.275 -0400", hash_original_field = "DDACC30001586FA5A6ADAB14BD771FAB", hash_generated_field = "F9F61E8092411076DB5AE762F7F62DDF")

    private static String RECEIVED_MILLIS = "X-Android-Received-Millis";
}

