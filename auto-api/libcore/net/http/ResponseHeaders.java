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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.434 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "DDFAECCF21F90F28142F5C866534A5C3")

    private URI uri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.434 -0400", hash_original_field = "4340FD73E75DF7A9D9E45902A59BA3A4", hash_generated_field = "534F1B0AE2D401678B9C67DE48E937E4")

    private RawHeaders headers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.434 -0400", hash_original_field = "255C768659E137E647AD19DAAA113055", hash_generated_field = "3C9D71E60FDD69589ECCD3D4127D69BC")

    private Date servedDate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.434 -0400", hash_original_field = "56D4CE3ADDD9E0185B21EB938EA5BC79", hash_generated_field = "82D9B6029A259946FCFF39FA4D23937A")

    private Date lastModified;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.434 -0400", hash_original_field = "09BCB72D61C0D6D1EFF5336DA6881557", hash_generated_field = "310069CCAEBFEB04D5AA82E2ACE2110A")

    private Date expires;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.434 -0400", hash_original_field = "2DB04C3277683DB70B0D07522DD798E9", hash_generated_field = "53AB8B4205AECB145C66AA09F7622312")

    private long sentRequestMillis;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.434 -0400", hash_original_field = "97EAE8D73925A6238D9D413B6589D432", hash_generated_field = "D2D5C4E73D9772663AEEE06EBF7F2306")

    private long receivedResponseMillis;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.434 -0400", hash_original_field = "3EDE331CCA63FAAFB68A34ACB42767C6", hash_generated_field = "5465707577DD6326819BA83CC3A7DE3E")

    private boolean noCache;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.434 -0400", hash_original_field = "4EAEDC49CC94AC327BA1C989626A4650", hash_generated_field = "E29F285792A57AA06DFE3E8F60AA431B")

    private boolean noStore;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.434 -0400", hash_original_field = "B29571B8149006A2CE1968134C4493D4", hash_generated_field = "6AE706B03701B766A1504BFD91199E77")

    private int maxAgeSeconds = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.434 -0400", hash_original_field = "CABA19AD91000B29CF602FF3160B2505", hash_generated_field = "C42B9B760D56807C5A8089CC41DE4FAD")

    private int sMaxAgeSeconds = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.434 -0400", hash_original_field = "16995EEF256269CFE8804FFAF770CB4B", hash_generated_field = "4315CF686F5A893F6508AE7DC5DB95BF")

    private boolean isPublic;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.434 -0400", hash_original_field = "F743118D2A1306352619EE9399545214", hash_generated_field = "DC5EDF8BDDA2C085BD8FEEA27C73CDDC")

    private boolean mustRevalidate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.434 -0400", hash_original_field = "1872ADE88F3013EDEB33DECD74A4F947", hash_generated_field = "B46F71525C78B55AB18E5645D7ACEB23")

    private String etag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.434 -0400", hash_original_field = "5BEEEA8F4990B45AFEC4D7C108C16DCD", hash_generated_field = "CCAA9D3543734EDD63F2970D27646F7A")

    private int ageSeconds = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.436 -0400", hash_original_field = "69E5F23E7A9FFA364853DD8FDEE9BB4E", hash_generated_field = "6E0F5B8CADA6537D578924642B4404D4")

    private Set<String> varyFields = Collections.emptySet();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.436 -0400", hash_original_field = "8D5FC32AC7506D2C0AC6949566E3BBE2", hash_generated_field = "62E683CB8A19320AEC224EE11BCD9187")

    private String contentEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.436 -0400", hash_original_field = "BF0487A5497D96D26C24936A4DAD1B2F", hash_generated_field = "53F1E445144D7EEFF13D2F87736EF02D")

    private String transferEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.436 -0400", hash_original_field = "23620B0ED7D2D6853307DFADB119A41C", hash_generated_field = "C51A9B467DA1E79F88DC6617E76DB248")

    private int contentLength = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.436 -0400", hash_original_field = "4717D53EBFDFEA8477F780EC66151DCB", hash_generated_field = "DB0F18ED2FD7BBA4B7D89988BC77D94E")

    private String connection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.436 -0400", hash_original_field = "23C886695D450E9E6FBD359CA1A9C75A", hash_generated_field = "9CC28CE45A3E28EC763E1280217EFAB0")

    private String proxyAuthenticate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.436 -0400", hash_original_field = "422BF398592867CC60C026C5302F13F9", hash_generated_field = "9D861AD424B4AE7E491841BD219A8EC5")

    private String wwwAuthenticate;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.466 -0400", hash_original_method = "DB24454BC912323B5FCB6CCA35CD9240", hash_generated_method = "BEAD2635F042056A87C2403B8F2EAA12")
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
            boolean var160466EB7D7D5C6ABB8E6B06A85E2B1F_772388007 = (i < headers.length());
            {
                String fieldName;
                fieldName = headers.getFieldName(i);
                String value;
                value = headers.getValue(i);
                {
                    boolean varD77C8259EAFC94FDC3D657C8834E9487_880107142 = ("Cache-Control".equalsIgnoreCase(fieldName));
                    {
                        HeaderParser.parseCacheControl(value, handler);
                    } //End block
                    {
                        boolean varCD2F40E0A98D4A2889CEF7D95E8C27B6_1223953358 = ("Date".equalsIgnoreCase(fieldName));
                        {
                            servedDate = HttpDate.parse(value);
                        } //End block
                        {
                            boolean varFF31A566C873782CB1B6419F2EA65B9B_21325823 = ("Expires".equalsIgnoreCase(fieldName));
                            {
                                expires = HttpDate.parse(value);
                            } //End block
                            {
                                boolean varF822263BF24EE652AEAC401809AA6D16_780328939 = ("Last-Modified".equalsIgnoreCase(fieldName));
                                {
                                    lastModified = HttpDate.parse(value);
                                } //End block
                                {
                                    boolean varF8CE2CB6DBD80B918C5E86CA7C93086E_1204728602 = ("ETag".equalsIgnoreCase(fieldName));
                                    {
                                        etag = value;
                                    } //End block
                                    {
                                        boolean varF67FD1E33B33C098C7C18DAC1CAB54CA_77056101 = ("Pragma".equalsIgnoreCase(fieldName));
                                        {
                                            {
                                                boolean varBF5A1C7105ABE0EE086840F1E4D55F8F_10617882 = (value.equalsIgnoreCase("no-cache"));
                                                {
                                                    noCache = true;
                                                } //End block
                                            } //End collapsed parenthetic
                                        } //End block
                                        {
                                            boolean var99A7D647B7FD011AD12776CEEB4CB8E4_165414265 = ("Age".equalsIgnoreCase(fieldName));
                                            {
                                                ageSeconds = HeaderParser.parseSeconds(value);
                                            } //End block
                                            {
                                                boolean var612924547FC43DA2310DC180CE3DB55D_157181741 = ("Vary".equalsIgnoreCase(fieldName));
                                                {
                                                    {
                                                        boolean var17D81E0032232EA0EDAFB415443EF53C_723823964 = (varyFields.isEmpty());
                                                        {
                                                            varyFields = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
                                                        } //End block
                                                    } //End collapsed parenthetic
                                                    {
                                                        Iterator<String> var154416020BE200D943446034B260BA51_154608497 = (value.split(",")).iterator();
                                                        var154416020BE200D943446034B260BA51_154608497.hasNext();
                                                        String varyField = var154416020BE200D943446034B260BA51_154608497.next();
                                                        {
                                                            varyFields.add(varyField.trim());
                                                        } //End block
                                                    } //End collapsed parenthetic
                                                } //End block
                                                {
                                                    boolean varEEEFC20C1240BBA2C8B42C2F114E2C2A_2102338724 = ("Content-Encoding".equalsIgnoreCase(fieldName));
                                                    {
                                                        contentEncoding = value;
                                                    } //End block
                                                    {
                                                        boolean varA366C7C732EE22377F02D6DB49D33763_401980878 = ("Transfer-Encoding".equalsIgnoreCase(fieldName));
                                                        {
                                                            transferEncoding = value;
                                                        } //End block
                                                        {
                                                            boolean var4E5AA53DFDC181F206D0324535D36C6E_1036797034 = ("Content-Length".equalsIgnoreCase(fieldName));
                                                            {
                                                                try 
                                                                {
                                                                    contentLength = Integer.parseInt(value);
                                                                } //End block
                                                                catch (NumberFormatException ignored)
                                                                { }
                                                            } //End block
                                                            {
                                                                boolean var5C79FBE6D9AF7B34CADBD78E33DD3307_2002778688 = ("Connection".equalsIgnoreCase(fieldName));
                                                                {
                                                                    connection = value;
                                                                } //End block
                                                                {
                                                                    boolean varED6BC7458920C777A36871BDDC3FC8DD_1453575095 = ("Proxy-Authenticate".equalsIgnoreCase(fieldName));
                                                                    {
                                                                        proxyAuthenticate = value;
                                                                    } //End block
                                                                    {
                                                                        boolean var62B7EE9803087906A523F2C6F7F108AF_1942301978 = ("WWW-Authenticate".equalsIgnoreCase(fieldName));
                                                                        {
                                                                            wwwAuthenticate = value;
                                                                        } //End block
                                                                        {
                                                                            boolean var7282ECC69B104D2DF8853E528D50BFCD_229310293 = (SENT_MILLIS.equalsIgnoreCase(fieldName));
                                                                            {
                                                                                sentRequestMillis = Long.parseLong(value);
                                                                            } //End block
                                                                            {
                                                                                boolean var9A941839153BEAB247C8984F1B4249AA_1777853382 = (RECEIVED_MILLIS.equalsIgnoreCase(fieldName));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.467 -0400", hash_original_method = "796365D0FCCA6BD674FA822FBE40C059", hash_generated_method = "17EA92B3814F34227EB82F701C670649")
    public boolean isContentEncodingGzip() {
        boolean varC0E28EA1539FF174C033FE8D4327D4D0_2058938821 = ("gzip".equalsIgnoreCase(contentEncoding));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2093131238 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2093131238;
        // ---------- Original Method ----------
        //return "gzip".equalsIgnoreCase(contentEncoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.467 -0400", hash_original_method = "AD1C758BD3B96983B4362B4ECCA164D6", hash_generated_method = "E13F95E67AAC2117E89E0EFDCED90CA7")
    public void stripContentEncoding() {
        contentEncoding = null;
        headers.removeAll("Content-Encoding");
        // ---------- Original Method ----------
        //contentEncoding = null;
        //headers.removeAll("Content-Encoding");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.482 -0400", hash_original_method = "00B64F53B1189DFD8EFC83FE9CA41E37", hash_generated_method = "AC42280A16426B613D14B2FB6F142527")
    public boolean isChunked() {
        boolean varA16BCACE603C83FBCA10B7C6B1A17953_1302212136 = ("chunked".equalsIgnoreCase(transferEncoding));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_355945036 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_355945036;
        // ---------- Original Method ----------
        //return "chunked".equalsIgnoreCase(transferEncoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.482 -0400", hash_original_method = "0C9005E446549CA2DCD479C6BCCC6A35", hash_generated_method = "0A7DD93E35D0FE8674F550D71FECD1DC")
    public boolean hasConnectionClose() {
        boolean var81EEBB6E2271640A61DE6C091C411E9C_873827121 = ("close".equalsIgnoreCase(connection));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_374024562 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_374024562;
        // ---------- Original Method ----------
        //return "close".equalsIgnoreCase(connection);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.490 -0400", hash_original_method = "F8E205165DB0FFA5BCD89362DFA95E13", hash_generated_method = "28C7FE60A7094587409E7D7FEE45D492")
    public URI getUri() {
        URI varB4EAC82CA7396A68D541C85D26508E83_1702139464 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1702139464 = uri;
        varB4EAC82CA7396A68D541C85D26508E83_1702139464.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1702139464;
        // ---------- Original Method ----------
        //return uri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.491 -0400", hash_original_method = "8B8008667EA7E940C84B2A1E4AADF211", hash_generated_method = "6A8C2E8C82569BCAAE70521600C45863")
    public RawHeaders getHeaders() {
        RawHeaders varB4EAC82CA7396A68D541C85D26508E83_688840991 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_688840991 = headers;
        varB4EAC82CA7396A68D541C85D26508E83_688840991.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_688840991;
        // ---------- Original Method ----------
        //return headers;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.492 -0400", hash_original_method = "F90446E53D3AF5BE7BA6FACCF3504208", hash_generated_method = "889A07D7D856A6159F0F25D9E31A72EC")
    public Date getServedDate() {
        Date varB4EAC82CA7396A68D541C85D26508E83_1088680450 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1088680450 = servedDate;
        varB4EAC82CA7396A68D541C85D26508E83_1088680450.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1088680450;
        // ---------- Original Method ----------
        //return servedDate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.492 -0400", hash_original_method = "B44D0D5D3FBE8A04568E9D9F3E9708AC", hash_generated_method = "C57E13BABCDACE2B15C14DFA1F30C779")
    public Date getLastModified() {
        Date varB4EAC82CA7396A68D541C85D26508E83_409291227 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_409291227 = lastModified;
        varB4EAC82CA7396A68D541C85D26508E83_409291227.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_409291227;
        // ---------- Original Method ----------
        //return lastModified;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.505 -0400", hash_original_method = "D14D02C8B70C044F75369CCEC64D849F", hash_generated_method = "254D543D7B8C68B16A62CF42632870E0")
    public Date getExpires() {
        Date varB4EAC82CA7396A68D541C85D26508E83_1012341052 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1012341052 = expires;
        varB4EAC82CA7396A68D541C85D26508E83_1012341052.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1012341052;
        // ---------- Original Method ----------
        //return expires;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.505 -0400", hash_original_method = "6FC1CEF1DCDA63846245A172D489494E", hash_generated_method = "A331CBC14813E8610A45453319AAB8CF")
    public boolean isNoCache() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1998713312 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1998713312;
        // ---------- Original Method ----------
        //return noCache;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.506 -0400", hash_original_method = "41C92D037056676770FDD2CB72F93600", hash_generated_method = "00F0C0CF6090EEC5DF90C865C8B1367E")
    public boolean isNoStore() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_476726799 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_476726799;
        // ---------- Original Method ----------
        //return noStore;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.506 -0400", hash_original_method = "A8F2E8C976B81B2FCD2E37C57E26B8BC", hash_generated_method = "CC36B9B25A68AB5FE7DC0CD028C83551")
    public int getMaxAgeSeconds() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_49059897 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_49059897;
        // ---------- Original Method ----------
        //return maxAgeSeconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.507 -0400", hash_original_method = "E2E5751856DD8B4562FF25B8FB1901CF", hash_generated_method = "8CBC327C34858AFBFA29B5E35E60F77F")
    public int getSMaxAgeSeconds() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2040619535 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2040619535;
        // ---------- Original Method ----------
        //return sMaxAgeSeconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.508 -0400", hash_original_method = "5C207DA5362424777671E2427CD32289", hash_generated_method = "02A0E838B40B16C46C8E90AD8EE6C998")
    public boolean isPublic() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2112531945 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2112531945;
        // ---------- Original Method ----------
        //return isPublic;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.508 -0400", hash_original_method = "E05A87C935BB761C11F60283BED9A93A", hash_generated_method = "206BD564D276A88170F888526F9E9D3E")
    public boolean isMustRevalidate() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1965953279 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1965953279;
        // ---------- Original Method ----------
        //return mustRevalidate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.524 -0400", hash_original_method = "2F22856D0A054825BF540D28FE4EB44E", hash_generated_method = "071877164425554494830049F7A6F1A9")
    public String getEtag() {
        String varB4EAC82CA7396A68D541C85D26508E83_2113392255 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2113392255 = etag;
        varB4EAC82CA7396A68D541C85D26508E83_2113392255.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2113392255;
        // ---------- Original Method ----------
        //return etag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.525 -0400", hash_original_method = "C8C00D8A1144BBC8C8A6E2EAAA43E379", hash_generated_method = "859BC49E5F6ED4F34D0D7E1314C61032")
    public Set<String> getVaryFields() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_825281482 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_825281482 = varyFields;
        varB4EAC82CA7396A68D541C85D26508E83_825281482.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_825281482;
        // ---------- Original Method ----------
        //return varyFields;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.526 -0400", hash_original_method = "801F0D0C73EEE64E68A729BCCDAD74D7", hash_generated_method = "BF6B04A88183C07753E2F7AAB547A6A2")
    public String getContentEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1058930291 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1058930291 = contentEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_1058930291.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1058930291;
        // ---------- Original Method ----------
        //return contentEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.526 -0400", hash_original_method = "1B52BDD2BF1D0E488CD60B58C0023743", hash_generated_method = "74A8919267F150F7B59DD79E5A79035F")
    public int getContentLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_764066895 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_764066895;
        // ---------- Original Method ----------
        //return contentLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.527 -0400", hash_original_method = "B2D78684E046945E6BE853B24B15E901", hash_generated_method = "CE9669F14DE2A5C323156E7C8B3F0C3A")
    public String getConnection() {
        String varB4EAC82CA7396A68D541C85D26508E83_304103599 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_304103599 = connection;
        varB4EAC82CA7396A68D541C85D26508E83_304103599.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_304103599;
        // ---------- Original Method ----------
        //return connection;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.527 -0400", hash_original_method = "BA8A66BA629083526749CA96982906E0", hash_generated_method = "F0DCB0F0C828D11722955272A2687663")
    public String getProxyAuthenticate() {
        String varB4EAC82CA7396A68D541C85D26508E83_1226923996 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1226923996 = proxyAuthenticate;
        varB4EAC82CA7396A68D541C85D26508E83_1226923996.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1226923996;
        // ---------- Original Method ----------
        //return proxyAuthenticate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.528 -0400", hash_original_method = "9336A6C75F9FBB86806462CCF41FEBB3", hash_generated_method = "2780D720F0C076DECBD6002F5F9208D4")
    public String getWwwAuthenticate() {
        String varB4EAC82CA7396A68D541C85D26508E83_82361009 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_82361009 = wwwAuthenticate;
        varB4EAC82CA7396A68D541C85D26508E83_82361009.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_82361009;
        // ---------- Original Method ----------
        //return wwwAuthenticate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.538 -0400", hash_original_method = "22FEE68D81D5D179ED2595CC992792BF", hash_generated_method = "DC80F96132036FAD673859E5C2212566")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.538 -0400", hash_original_method = "62B4E508B2BD1FD8674C188E31D3FA94", hash_generated_method = "60FB173A127338B1C1EA6E789B1C8E6E")
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
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1294390674 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1294390674;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.539 -0400", hash_original_method = "723583A81B93D8753154A40B95765CF8", hash_generated_method = "3E14DCB1A47C8169D86792AF6D53A0D2")
    private long computeFreshnessLifetime() {
        {
            long varE87156FA27F9CF79D97CBA7040DC6B66_868818605 = (TimeUnit.SECONDS.toMillis(maxAgeSeconds));
        } //End block
        {
            long servedMillis;
            servedMillis = servedDate.getTime();
            servedMillis = receivedResponseMillis;
            long delta;
            delta = expires.getTime() - servedMillis;
        } //End block
        {
            boolean var9B1D6757A89860DA2B5EAB9B5FBCE1D5_1133803575 = (lastModified != null && uri.getRawQuery() == null);
            {
                long servedMillis;
                servedMillis = servedDate.getTime();
                servedMillis = sentRequestMillis;
                long delta;
                delta = servedMillis - lastModified.getTime();
            } //End block
        } //End collapsed parenthetic
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1702851998 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1702851998;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.539 -0400", hash_original_method = "8F28A3C0281B6F16DECF00092A03388F", hash_generated_method = "00932EA06D7CCCE2B8C771C1EA922E78")
    private boolean isFreshnessLifetimeHeuristic() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1100476510 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1100476510;
        // ---------- Original Method ----------
        //return maxAgeSeconds == -1 && expires == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.550 -0400", hash_original_method = "E402151342DE994EEE4FC3989E09156E", hash_generated_method = "BF704C63636B22C7D47374513594E213")
    public boolean isCacheable(RequestHeaders request) {
        int responseCode;
        responseCode = headers.getResponseCode();
        {
            boolean varE24C55697985C1233F502262CD22E5D4_1226051817 = (request.hasAuthorization()
                && !isPublic
                && !mustRevalidate
                && sMaxAgeSeconds == -1);
        } //End collapsed parenthetic
        addTaint(request.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_710980421 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_710980421;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.550 -0400", hash_original_method = "937D0115F7BB3894701032373C9A4BC7", hash_generated_method = "6CB08F0A29DB4F8EA2A9269EABA08CC0")
    public boolean hasVaryAll() {
        boolean varC738253CEA254131A804BC3CB6A34FC1_1726123536 = (varyFields.contains("*"));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_615933501 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_615933501;
        // ---------- Original Method ----------
        //return varyFields.contains("*");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.570 -0400", hash_original_method = "AE2D57CEA29D6AAD43D079D6A743C143", hash_generated_method = "E42AEE2953C6B3D2CD93C786B6E6965C")
    public boolean varyMatches(Map<String, List<String>> cachedRequest,
            Map<String, List<String>> newRequest) {
        {
            Iterator<String> varC1185F1BCBF99AA0F507E14EFA1E99A9_213420807 = (varyFields).iterator();
            varC1185F1BCBF99AA0F507E14EFA1E99A9_213420807.hasNext();
            String field = varC1185F1BCBF99AA0F507E14EFA1E99A9_213420807.next();
            {
                {
                    boolean var757B3024B7F14E3064F0E604913C8246_164795549 = (!Objects.equal(cachedRequest.get(field), newRequest.get(field)));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(cachedRequest.getTaint());
        addTaint(newRequest.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1389378590 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1389378590;
        // ---------- Original Method ----------
        //for (String field : varyFields) {
            //if (!Objects.equal(cachedRequest.get(field), newRequest.get(field))) {
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.585 -0400", hash_original_method = "564BBC9A8CA0CE268623CE0DAE1CD407", hash_generated_method = "A4617EDE4D99BD5B55EE5148F9A19FE7")
    public ResponseSource chooseResponseSource(long nowMillis, RequestHeaders request) {
        ResponseSource varB4EAC82CA7396A68D541C85D26508E83_1997864882 = null; //Variable for return #1
        ResponseSource varB4EAC82CA7396A68D541C85D26508E83_1982538945 = null; //Variable for return #2
        ResponseSource varB4EAC82CA7396A68D541C85D26508E83_20121393 = null; //Variable for return #3
        ResponseSource varB4EAC82CA7396A68D541C85D26508E83_42172834 = null; //Variable for return #4
        {
            boolean var7012CA4B5F50B57A637C81F78E278477_845561743 = (!isCacheable(request));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1997864882 = ResponseSource.NETWORK;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var183378DFF7F1E73CE42B495ED68511EB_23534860 = (request.isNoCache() || request.hasConditions());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1982538945 = ResponseSource.NETWORK;
            } //End block
        } //End collapsed parenthetic
        long ageMillis;
        ageMillis = computeAge(nowMillis);
        long freshMillis;
        freshMillis = computeFreshnessLifetime();
        {
            boolean varFA1EF6C3F76EDF9563757934756DC958_35796517 = (request.getMaxAgeSeconds() != -1);
            {
                freshMillis = Math.min(freshMillis,
                    TimeUnit.SECONDS.toMillis(request.getMaxAgeSeconds()));
            } //End block
        } //End collapsed parenthetic
        long minFreshMillis;
        minFreshMillis = 0;
        {
            boolean var0812931521313686CF4E34A994C81573_110920465 = (request.getMinFreshSeconds() != -1);
            {
                minFreshMillis = TimeUnit.SECONDS.toMillis(request.getMinFreshSeconds());
            } //End block
        } //End collapsed parenthetic
        long maxStaleMillis;
        maxStaleMillis = 0;
        {
            boolean varBE22EC61E082962B9A28D480363F4C25_974912045 = (!mustRevalidate && request.getMaxStaleSeconds() != -1);
            {
                maxStaleMillis = TimeUnit.SECONDS.toMillis(request.getMaxStaleSeconds());
            } //End block
        } //End collapsed parenthetic
        {
            {
                headers.add("Warning", "110 HttpURLConnection \"Response is stale\"");
            } //End block
            {
                boolean var2B158D5C216D94EE4BBEF348BC4C77DA_2127926407 = (ageMillis > TimeUnit.HOURS.toMillis(24) && isFreshnessLifetimeHeuristic());
                {
                    headers.add("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_20121393 = ResponseSource.CACHE;
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
        varB4EAC82CA7396A68D541C85D26508E83_42172834 = request.hasConditions()
                ? ResponseSource.CONDITIONAL_CACHE
                : ResponseSource.NETWORK;
        addTaint(nowMillis);
        addTaint(request.getTaint());
        ResponseSource varA7E53CE21691AB073D9660D615818899_1664193586; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1664193586 = varB4EAC82CA7396A68D541C85D26508E83_1997864882;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1664193586 = varB4EAC82CA7396A68D541C85D26508E83_1982538945;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1664193586 = varB4EAC82CA7396A68D541C85D26508E83_20121393;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1664193586 = varB4EAC82CA7396A68D541C85D26508E83_42172834;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1664193586.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1664193586;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.586 -0400", hash_original_method = "824AD0BBE6883E3213FE3DC10E71C2FB", hash_generated_method = "850A97FA564FB2929591B62CCF867BB5")
    public boolean validate(ResponseHeaders networkResponse) {
        {
            boolean var69CB999E5360904B86AF7CF73BDBAAEE_1045396856 = (networkResponse.headers.getResponseCode() == HttpURLConnection.HTTP_NOT_MODIFIED);
        } //End collapsed parenthetic
        {
            boolean var834D152FE75AE1012A8E1C348C001FBE_829699898 = (lastModified != null
                && networkResponse.lastModified != null
                && networkResponse.lastModified.getTime() < lastModified.getTime());
        } //End collapsed parenthetic
        addTaint(networkResponse.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_661191714 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_661191714;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.607 -0400", hash_original_method = "22AFCF8A6EE54CCCB143274E3F308CC7", hash_generated_method = "75FEEFF7FAA66888A578C67B16364BDB")
    public ResponseHeaders combine(ResponseHeaders network) {
        ResponseHeaders varB4EAC82CA7396A68D541C85D26508E83_1737926314 = null; //Variable for return #1
        RawHeaders result;
        result = new RawHeaders();
        {
            int i;
            i = 0;
            boolean var160466EB7D7D5C6ABB8E6B06A85E2B1F_1172594633 = (i < headers.length());
            {
                String fieldName;
                fieldName = headers.getFieldName(i);
                String value;
                value = headers.getValue(i);
                {
                    boolean varFBC607F7190EEEDE1D047F61F2153C09_1853779556 = (fieldName.equals("Warning") && value.startsWith("1"));
                } //End collapsed parenthetic
                {
                    boolean var70955E32A6C50C8029AEBBD58FEE2C66_53620789 = (!isEndToEnd(fieldName) || network.headers.get(fieldName) == null);
                    {
                        result.add(fieldName, value);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            int i;
            i = 0;
            boolean var1DD03E9C0E7D3AA92950B78E75AFC7C3_1941241700 = (i < network.headers.length());
            {
                String fieldName;
                fieldName = network.headers.getFieldName(i);
                {
                    boolean var9350CBC579AD9A7B70EC635F591BE067_1963738752 = (isEndToEnd(fieldName));
                    {
                        result.add(fieldName, network.headers.getValue(i));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1737926314 = new ResponseHeaders(uri, result);
        addTaint(network.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1737926314.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1737926314;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.608 -0400", hash_original_field = "9E9631C60162867EAC3B22BAAE81CD7C", hash_generated_field = "F4CDA34343B1A96CE1262FF47CBD6C39")

    private static String SENT_MILLIS = "X-Android-Sent-Millis";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:06.608 -0400", hash_original_field = "DDACC30001586FA5A6ADAB14BD771FAB", hash_generated_field = "F9F61E8092411076DB5AE762F7F62DDF")

    private static String RECEIVED_MILLIS = "X-Android-Received-Millis";
}

