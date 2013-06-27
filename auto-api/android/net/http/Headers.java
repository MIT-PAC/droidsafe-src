package android.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;
import java.util.ArrayList;
import org.apache.http.HeaderElement;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.message.BasicHeaderValueParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;

public final class Headers {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.912 -0400", hash_original_field = "BF0487A5497D96D26C24936A4DAD1B2F", hash_generated_field = "F2168064076810E0CC499B9D7EF97699")

    private long transferEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.912 -0400", hash_original_field = "C22384F3ABFE57BC648B6E1701C98123", hash_generated_field = "0235B86EE2D19DB7BC14B5867FCABFC4")

    private long contentLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.912 -0400", hash_original_field = "211C5E8A476F3181470CEE17081D7958", hash_generated_field = "DA79CCF89C0444B28B1A4FCF4B709AC2")

    private int connectionType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.912 -0400", hash_original_field = "5204FD70AB0CA4AB431F9A4DF4CD9C50", hash_generated_field = "059D703F12F9B58BFA7B38580D912F7A")

    private ArrayList<String> cookies = new ArrayList<String>(2);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.912 -0400", hash_original_field = "DDA6AB837C8C8328F79C6876FD10B24A", hash_generated_field = "86073EAB5791FF38D937FACC8B8B5D5A")

    private String[] mHeaders = new String[HEADER_COUNT];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.913 -0400", hash_original_field = "F4FD85C873339BB50CE1A07443D5EE9F", hash_generated_field = "591B6F2110CB6CDD1C1A9CAA5287338F")

    private ArrayList<String> mExtraHeaderNames = new ArrayList<String>(4);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.913 -0400", hash_original_field = "D6CEC2A0096C2E751F2D33225691E9F6", hash_generated_field = "41D0A1235C58997B9BD356936A71763B")

    private ArrayList<String> mExtraHeaderValues = new ArrayList<String>(4);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.914 -0400", hash_original_method = "4806F09499B83A0F8F6BA6D2EDAE6CDA", hash_generated_method = "8727A8D60C0E27C0BFDFF3C48804DA1B")
    public  Headers() {
        transferEncoding = NO_TRANSFER_ENCODING;
        contentLength = NO_CONTENT_LENGTH;
        connectionType = NO_CONN_TYPE;
        // ---------- Original Method ----------
        //transferEncoding = NO_TRANSFER_ENCODING;
        //contentLength = NO_CONTENT_LENGTH;
        //connectionType = NO_CONN_TYPE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.974 -0400", hash_original_method = "2601C4AB5843D67812F736A8664254C1", hash_generated_method = "CECE3006650937F67ECA7D7FDEAC02DA")
    public void parseHeader(CharArrayBuffer buffer) {
        int pos;
        pos = CharArrayBuffers.setLowercaseIndexOf(buffer, ':');
        String name;
        name = buffer.substringTrimmed(0, pos);
        {
            boolean var162A1A174B912EA806BA20275BF238E6_675971730 = (name.length() == 0);
        } //End collapsed parenthetic
        String val;
        val = buffer.substringTrimmed(pos, buffer.length());
        {
            HttpLog.v("hdr " + buffer.length() + " " + buffer);
        } //End block
        {
            Object varD5CE5E51886CB990D3E836A2F031F3B0_694075688 = (name.hashCode());
            //Begin case HASH_TRANSFER_ENCODING 
            {
                boolean var7B54C8F384C00CCC2D9E2DD19E269C8C_1829892495 = (name.equals(TRANSFER_ENCODING));
                {
                    mHeaders[IDX_TRANSFER_ENCODING] = val;
                    HeaderElement[] encodings;
                    encodings = BasicHeaderValueParser.DEFAULT
                        .parseElements(buffer, new ParserCursor(pos,
                                buffer.length()));
                    int len;
                    len = encodings.length;
                    {
                        boolean var68C5892BBE06DBB503602F92C86B60E5_422099026 = (HTTP.IDENTITY_CODING.equalsIgnoreCase(val));
                        {
                            transferEncoding = ContentLengthStrategy.IDENTITY;
                        } //End block
                        {
                            boolean varAD6F03450544B8A04DF43EF0CB2A1703_1108377235 = ((len > 0)
                        && (HTTP.CHUNK_CODING
                                .equalsIgnoreCase(encodings[len - 1].getName())));
                            {
                                transferEncoding = ContentLengthStrategy.CHUNKED;
                            } //End block
                            {
                                transferEncoding = ContentLengthStrategy.IDENTITY;
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            //End case HASH_TRANSFER_ENCODING 
            //Begin case HASH_CONTENT_LEN 
            {
                boolean var18348926E9101CCB629C034EED46C4CB_1479239178 = (name.equals(CONTENT_LEN));
                {
                    mHeaders[IDX_CONTENT_LEN] = val;
                    try 
                    {
                        contentLength = Long.parseLong(val);
                    } //End block
                    catch (NumberFormatException e)
                    { }
                } //End block
            } //End collapsed parenthetic
            //End case HASH_CONTENT_LEN 
            //Begin case HASH_CONTENT_TYPE 
            {
                boolean varC01F98D6C1790EC66A7769901CC9D809_1855535749 = (name.equals(CONTENT_TYPE));
                {
                    mHeaders[IDX_CONTENT_TYPE] = val;
                } //End block
            } //End collapsed parenthetic
            //End case HASH_CONTENT_TYPE 
            //Begin case HASH_CONTENT_ENCODING 
            {
                boolean var5E5F6438CD092B168AAEBE25B8F7BB52_1482525244 = (name.equals(CONTENT_ENCODING));
                {
                    mHeaders[IDX_CONTENT_ENCODING] = val;
                } //End block
            } //End collapsed parenthetic
            //End case HASH_CONTENT_ENCODING 
            //Begin case HASH_CONN_DIRECTIVE 
            {
                boolean var7A7E6C3E8726D6115E4F34285EB1E137_909348453 = (name.equals(CONN_DIRECTIVE));
                {
                    mHeaders[IDX_CONN_DIRECTIVE] = val;
                    setConnectionType(buffer, pos);
                } //End block
            } //End collapsed parenthetic
            //End case HASH_CONN_DIRECTIVE 
            //Begin case HASH_LOCATION 
            {
                boolean varFA51CCC753CEF9E5173C29BE531D1272_1746264730 = (name.equals(LOCATION));
                {
                    mHeaders[IDX_LOCATION] = val;
                } //End block
            } //End collapsed parenthetic
            //End case HASH_LOCATION 
            //Begin case HASH_PROXY_CONNECTION 
            {
                boolean var9DB86CF8694E1F6C31F3801051E035C2_1139481526 = (name.equals(PROXY_CONNECTION));
                {
                    mHeaders[IDX_PROXY_CONNECTION] = val;
                    setConnectionType(buffer, pos);
                } //End block
            } //End collapsed parenthetic
            //End case HASH_PROXY_CONNECTION 
            //Begin case HASH_WWW_AUTHENTICATE 
            {
                boolean varDFE2C07C26EDE1ADE7EBA6270E49931D_228443946 = (name.equals(WWW_AUTHENTICATE));
                {
                    mHeaders[IDX_WWW_AUTHENTICATE] = val;
                } //End block
            } //End collapsed parenthetic
            //End case HASH_WWW_AUTHENTICATE 
            //Begin case HASH_PROXY_AUTHENTICATE 
            {
                boolean var48D7193659B5612617AE289242213B39_1964759080 = (name.equals(PROXY_AUTHENTICATE));
                {
                    mHeaders[IDX_PROXY_AUTHENTICATE] = val;
                } //End block
            } //End collapsed parenthetic
            //End case HASH_PROXY_AUTHENTICATE 
            //Begin case HASH_CONTENT_DISPOSITION 
            {
                boolean var1F3158CAF77BB123FBC69291627CD604_403807703 = (name.equals(CONTENT_DISPOSITION));
                {
                    mHeaders[IDX_CONTENT_DISPOSITION] = val;
                } //End block
            } //End collapsed parenthetic
            //End case HASH_CONTENT_DISPOSITION 
            //Begin case HASH_ACCEPT_RANGES 
            {
                boolean varE6220C0D44AC55608E493A184A4CFA67_1144484551 = (name.equals(ACCEPT_RANGES));
                {
                    mHeaders[IDX_ACCEPT_RANGES] = val;
                } //End block
            } //End collapsed parenthetic
            //End case HASH_ACCEPT_RANGES 
            //Begin case HASH_EXPIRES 
            {
                boolean varAC41375E8DF79B2C665DEB3A150610E3_1074486525 = (name.equals(EXPIRES));
                {
                    mHeaders[IDX_EXPIRES] = val;
                } //End block
            } //End collapsed parenthetic
            //End case HASH_EXPIRES 
            //Begin case HASH_CACHE_CONTROL 
            {
                boolean varB2DF48D1D5C2D6CBDEA54D19FA792A43_1500749911 = (name.equals(CACHE_CONTROL));
                {
                    {
                        boolean varB92945A8CCA4959ECEB90265B45FC92E_1851631616 = (mHeaders[IDX_CACHE_CONTROL] != null &&
                    mHeaders[IDX_CACHE_CONTROL].length() > 0);
                        {
                            mHeaders[IDX_CACHE_CONTROL] += (',' + val);
                        } //End block
                        {
                            mHeaders[IDX_CACHE_CONTROL] = val;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            //End case HASH_CACHE_CONTROL 
            //Begin case HASH_LAST_MODIFIED 
            {
                boolean var8B1FC06FEB8C0848F1DC31BCC2A17465_1574350418 = (name.equals(LAST_MODIFIED));
                {
                    mHeaders[IDX_LAST_MODIFIED] = val;
                } //End block
            } //End collapsed parenthetic
            //End case HASH_LAST_MODIFIED 
            //Begin case HASH_ETAG 
            {
                boolean varFA835B8351F1FE6D77BE4CF0BB1E41A5_161449668 = (name.equals(ETAG));
                {
                    mHeaders[IDX_ETAG] = val;
                } //End block
            } //End collapsed parenthetic
            //End case HASH_ETAG 
            //Begin case HASH_SET_COOKIE 
            {
                boolean var86BE53AF69B78EC6486FB922C7BA0B5E_716356248 = (name.equals(SET_COOKIE));
                {
                    mHeaders[IDX_SET_COOKIE] = val;
                    cookies.add(val);
                } //End block
            } //End collapsed parenthetic
            //End case HASH_SET_COOKIE 
            //Begin case HASH_PRAGMA 
            {
                boolean var68267221AB9433567AE0493C282A1BAA_1230771244 = (name.equals(PRAGMA));
                {
                    mHeaders[IDX_PRAGMA] = val;
                } //End block
            } //End collapsed parenthetic
            //End case HASH_PRAGMA 
            //Begin case HASH_REFRESH 
            {
                boolean var9D64B646E30BE6948B4EB435C06BDDBD_34597014 = (name.equals(REFRESH));
                {
                    mHeaders[IDX_REFRESH] = val;
                } //End block
            } //End collapsed parenthetic
            //End case HASH_REFRESH 
            //Begin case HASH_X_PERMITTED_CROSS_DOMAIN_POLICIES 
            {
                boolean varBA8E759A71FDF489DB2F1A5427B1F174_1345535943 = (name.equals(X_PERMITTED_CROSS_DOMAIN_POLICIES));
                {
                    mHeaders[IDX_X_PERMITTED_CROSS_DOMAIN_POLICIES] = val;
                } //End block
            } //End collapsed parenthetic
            //End case HASH_X_PERMITTED_CROSS_DOMAIN_POLICIES 
            //Begin case default 
            mExtraHeaderNames.add(name);
            //End case default 
            //Begin case default 
            mExtraHeaderValues.add(val);
            //End case default 
        } //End collapsed parenthetic
        addTaint(buffer.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.986 -0400", hash_original_method = "839965513DF286AFAE2E56076E19ADBF", hash_generated_method = "8930DFACFA5BCCE31F906D7D7F16D3DE")
    public long getTransferEncoding() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1975356902 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1975356902;
        // ---------- Original Method ----------
        //return transferEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.986 -0400", hash_original_method = "043A311B0C55CC2C0E7ED635C15C25FD", hash_generated_method = "D343ED2EE682FF9FFFC905A510C98E16")
    public long getContentLength() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_454963741 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_454963741;
        // ---------- Original Method ----------
        //return contentLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:22.987 -0400", hash_original_method = "16A8DC2EF1F4EBF751AEB83B8F69222E", hash_generated_method = "48101564E24530B73A2E185A68C33FC8")
    public int getConnectionType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_644437821 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_644437821;
        // ---------- Original Method ----------
        //return connectionType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.000 -0400", hash_original_method = "0358D0D4AEFF84195277AB782B3FFDE2", hash_generated_method = "FD117B515DC21C08603EF2D476BD53B2")
    public String getContentType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1666884736 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1666884736 = mHeaders[IDX_CONTENT_TYPE];
        varB4EAC82CA7396A68D541C85D26508E83_1666884736.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1666884736;
        // ---------- Original Method ----------
        //return mHeaders[IDX_CONTENT_TYPE];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.001 -0400", hash_original_method = "DC3B5CC0DA80597E20563D04CDFF5783", hash_generated_method = "97F5EE634B153818454F4A8995DBADA9")
    public String getContentEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_179272363 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_179272363 = mHeaders[IDX_CONTENT_ENCODING];
        varB4EAC82CA7396A68D541C85D26508E83_179272363.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_179272363;
        // ---------- Original Method ----------
        //return mHeaders[IDX_CONTENT_ENCODING];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.002 -0400", hash_original_method = "3BEB5C295081F99F7A9897994B243966", hash_generated_method = "914F162C302E2828569D76149FE16096")
    public String getLocation() {
        String varB4EAC82CA7396A68D541C85D26508E83_921207171 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_921207171 = mHeaders[IDX_LOCATION];
        varB4EAC82CA7396A68D541C85D26508E83_921207171.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_921207171;
        // ---------- Original Method ----------
        //return mHeaders[IDX_LOCATION];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.003 -0400", hash_original_method = "2ABA1BEE8C50AB0C1324E3514B439A3C", hash_generated_method = "A19186A83DF22E09247113A9BA72A527")
    public String getWwwAuthenticate() {
        String varB4EAC82CA7396A68D541C85D26508E83_853925328 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_853925328 = mHeaders[IDX_WWW_AUTHENTICATE];
        varB4EAC82CA7396A68D541C85D26508E83_853925328.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_853925328;
        // ---------- Original Method ----------
        //return mHeaders[IDX_WWW_AUTHENTICATE];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.025 -0400", hash_original_method = "2251D004613BB9CDF5BB072ECCA1B196", hash_generated_method = "D3B93A804A9E0AA11CA73EA8507F7DA4")
    public String getProxyAuthenticate() {
        String varB4EAC82CA7396A68D541C85D26508E83_1354197216 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1354197216 = mHeaders[IDX_PROXY_AUTHENTICATE];
        varB4EAC82CA7396A68D541C85D26508E83_1354197216.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1354197216;
        // ---------- Original Method ----------
        //return mHeaders[IDX_PROXY_AUTHENTICATE];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.026 -0400", hash_original_method = "B3734B1B2E8291E968F6C56DD5A68AFD", hash_generated_method = "A17957F203C3946479AC606169D0C076")
    public String getContentDisposition() {
        String varB4EAC82CA7396A68D541C85D26508E83_775998192 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_775998192 = mHeaders[IDX_CONTENT_DISPOSITION];
        varB4EAC82CA7396A68D541C85D26508E83_775998192.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_775998192;
        // ---------- Original Method ----------
        //return mHeaders[IDX_CONTENT_DISPOSITION];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.037 -0400", hash_original_method = "56F3083ED56642A8109311F7B75978CE", hash_generated_method = "EE9C082C0AB5719A7708F6062CDD27BC")
    public String getAcceptRanges() {
        String varB4EAC82CA7396A68D541C85D26508E83_76737259 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_76737259 = mHeaders[IDX_ACCEPT_RANGES];
        varB4EAC82CA7396A68D541C85D26508E83_76737259.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_76737259;
        // ---------- Original Method ----------
        //return mHeaders[IDX_ACCEPT_RANGES];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.039 -0400", hash_original_method = "AD48730753A27EE5F83CD5FBE4AD4C5B", hash_generated_method = "32E732656C7511036A33325E5397596F")
    public String getExpires() {
        String varB4EAC82CA7396A68D541C85D26508E83_327146280 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_327146280 = mHeaders[IDX_EXPIRES];
        varB4EAC82CA7396A68D541C85D26508E83_327146280.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_327146280;
        // ---------- Original Method ----------
        //return mHeaders[IDX_EXPIRES];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.040 -0400", hash_original_method = "FAE5B14F1D1AF7F7C5B34799287CB96B", hash_generated_method = "771E01E4F3FD2A91B45501B9D90CF9ED")
    public String getCacheControl() {
        String varB4EAC82CA7396A68D541C85D26508E83_1615218663 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1615218663 = mHeaders[IDX_CACHE_CONTROL];
        varB4EAC82CA7396A68D541C85D26508E83_1615218663.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1615218663;
        // ---------- Original Method ----------
        //return mHeaders[IDX_CACHE_CONTROL];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.056 -0400", hash_original_method = "5FC9B5DD06D10DB2F99A11CF11E84611", hash_generated_method = "1131F66E04352BC104110F9AC34F5AC0")
    public String getLastModified() {
        String varB4EAC82CA7396A68D541C85D26508E83_1517844566 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1517844566 = mHeaders[IDX_LAST_MODIFIED];
        varB4EAC82CA7396A68D541C85D26508E83_1517844566.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1517844566;
        // ---------- Original Method ----------
        //return mHeaders[IDX_LAST_MODIFIED];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.057 -0400", hash_original_method = "2356D85AA5974933778FA07340E360AB", hash_generated_method = "7DEE14583F85058A3659D91D3EAAFC89")
    public String getEtag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1381846434 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1381846434 = mHeaders[IDX_ETAG];
        varB4EAC82CA7396A68D541C85D26508E83_1381846434.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1381846434;
        // ---------- Original Method ----------
        //return mHeaders[IDX_ETAG];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.073 -0400", hash_original_method = "30BF89B95A4B495DCD1A87F8054AFEC5", hash_generated_method = "B9FFBBD62EF87DE3CBBF3AD06EE719A0")
    public ArrayList<String> getSetCookie() {
        ArrayList<String> varB4EAC82CA7396A68D541C85D26508E83_1910749073 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1910749073 = this.cookies;
        varB4EAC82CA7396A68D541C85D26508E83_1910749073.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1910749073;
        // ---------- Original Method ----------
        //return this.cookies;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.074 -0400", hash_original_method = "A30AE7605FF81FB95FDA5AAF057C022D", hash_generated_method = "4655BA26F415CACBC8DB257319974473")
    public String getPragma() {
        String varB4EAC82CA7396A68D541C85D26508E83_35694611 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_35694611 = mHeaders[IDX_PRAGMA];
        varB4EAC82CA7396A68D541C85D26508E83_35694611.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_35694611;
        // ---------- Original Method ----------
        //return mHeaders[IDX_PRAGMA];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.078 -0400", hash_original_method = "847E30EC42ECB16F3B862D5A0C1778F0", hash_generated_method = "111A2082895DFF82BFA90E411236908A")
    public String getRefresh() {
        String varB4EAC82CA7396A68D541C85D26508E83_1899990474 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1899990474 = mHeaders[IDX_REFRESH];
        varB4EAC82CA7396A68D541C85D26508E83_1899990474.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1899990474;
        // ---------- Original Method ----------
        //return mHeaders[IDX_REFRESH];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.097 -0400", hash_original_method = "120DF6C7E530068F21D41A0CCD884530", hash_generated_method = "2295CEDDE324627291FC8A25B10E0F91")
    public String getXPermittedCrossDomainPolicies() {
        String varB4EAC82CA7396A68D541C85D26508E83_861433393 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_861433393 = mHeaders[IDX_X_PERMITTED_CROSS_DOMAIN_POLICIES];
        varB4EAC82CA7396A68D541C85D26508E83_861433393.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_861433393;
        // ---------- Original Method ----------
        //return mHeaders[IDX_X_PERMITTED_CROSS_DOMAIN_POLICIES];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.098 -0400", hash_original_method = "655405705FFA26A24CEE799E196F64CA", hash_generated_method = "70CE888A9FFED207F0803974796E927C")
    public void setContentLength(long value) {
        this.contentLength = value;
        // ---------- Original Method ----------
        //this.contentLength = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.098 -0400", hash_original_method = "DBD4B3393EC7C86D318F09AACB690C16", hash_generated_method = "A9ED9CE54B818219D22AD6B7B9BAB2F8")
    public void setContentType(String value) {
        mHeaders[IDX_CONTENT_TYPE] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_CONTENT_TYPE] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.099 -0400", hash_original_method = "795639D1D1B96C335181D978646FFEAC", hash_generated_method = "77D9B1C07F0FB32A9761C4B3F088F7CB")
    public void setContentEncoding(String value) {
        mHeaders[IDX_CONTENT_ENCODING] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_CONTENT_ENCODING] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.112 -0400", hash_original_method = "91ACBD0DA1F8B6B752177E887C1E560A", hash_generated_method = "FA0850D4F4C77DC48C8661B4E06FCDA6")
    public void setLocation(String value) {
        mHeaders[IDX_LOCATION] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_LOCATION] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.113 -0400", hash_original_method = "78E4D283A358D7F9AC830EDA5944CEC1", hash_generated_method = "4AAFA72378B619A1D7E762612FFED29E")
    public void setWwwAuthenticate(String value) {
        mHeaders[IDX_WWW_AUTHENTICATE] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_WWW_AUTHENTICATE] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.114 -0400", hash_original_method = "EB3C03E25C95805816417AB68A1F4E73", hash_generated_method = "FBAD98CF9FAB5BEE89E177BB5EA0711D")
    public void setProxyAuthenticate(String value) {
        mHeaders[IDX_PROXY_AUTHENTICATE] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_PROXY_AUTHENTICATE] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.133 -0400", hash_original_method = "CAF824941A606D9472E6B7F4D5AE8EAB", hash_generated_method = "6DBDC101C7D94B0D6851269BE8387BAB")
    public void setContentDisposition(String value) {
        mHeaders[IDX_CONTENT_DISPOSITION] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_CONTENT_DISPOSITION] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.134 -0400", hash_original_method = "42F6F595EF9293A515A4DDDF580E03E6", hash_generated_method = "5F85D3501DB5288A00CF9DDAB3832102")
    public void setAcceptRanges(String value) {
        mHeaders[IDX_ACCEPT_RANGES] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_ACCEPT_RANGES] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.135 -0400", hash_original_method = "7D2DC3B419C5BDAB21BBD8535AC32115", hash_generated_method = "76EA542A919CE34FD4D665398C623FD5")
    public void setExpires(String value) {
        mHeaders[IDX_EXPIRES] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_EXPIRES] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.135 -0400", hash_original_method = "461838AAEBDAFBB838DA60C8789FC643", hash_generated_method = "EEFBEAB5A98EC1741302CE7707E5564D")
    public void setCacheControl(String value) {
        mHeaders[IDX_CACHE_CONTROL] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_CACHE_CONTROL] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.136 -0400", hash_original_method = "E44516D40CA535A9E78D483DC766FE77", hash_generated_method = "88933EBF372CD7EBEFB5BE34D231304F")
    public void setLastModified(String value) {
        mHeaders[IDX_LAST_MODIFIED] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_LAST_MODIFIED] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.155 -0400", hash_original_method = "7E96E0634D296A60D862609FEA944EA2", hash_generated_method = "B4F381619A4DF76AF492305D6EACCE95")
    public void setEtag(String value) {
        mHeaders[IDX_ETAG] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_ETAG] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.160 -0400", hash_original_method = "860A5481555AE910297114E1D7478814", hash_generated_method = "F2E6E48B412C72FEA2876958E6643E79")
    public void setXPermittedCrossDomainPolicies(String value) {
        mHeaders[IDX_X_PERMITTED_CROSS_DOMAIN_POLICIES] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_X_PERMITTED_CROSS_DOMAIN_POLICIES] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.165 -0400", hash_original_method = "C9CAD2CB40E843B6A6F48005E0DE2B60", hash_generated_method = "A37627CB813194D34C5A444B50439158")
    public void getHeaders(HeaderCallback hcb) {
        {
            int i;
            i = 0;
            {
                String h;
                h = mHeaders[i];
                {
                    hcb.header(sHeaderNames[i], h);
                } //End block
            } //End block
        } //End collapsed parenthetic
        int extraLen;
        extraLen = mExtraHeaderNames.size();
        {
            int i;
            i = 0;
            {
                {
                    HttpLog.v("Headers.getHeaders() extra: " + i + " " +
                          mExtraHeaderNames.get(i) + " " + mExtraHeaderValues.get(i));
                } //End block
                hcb.header(mExtraHeaderNames.get(i),
                       mExtraHeaderValues.get(i));
            } //End block
        } //End collapsed parenthetic
        addTaint(hcb.getTaint());
        // ---------- Original Method ----------
        //for (int i = 0; i < HEADER_COUNT; i++) {
            //String h = mHeaders[i];
            //if (h != null) {
                //hcb.header(sHeaderNames[i], h);
            //}
        //}
        //int extraLen = mExtraHeaderNames.size();
        //for (int i = 0; i < extraLen; i++) {
            //if (false) {
                //HttpLog.v("Headers.getHeaders() extra: " + i + " " +
                          //mExtraHeaderNames.get(i) + " " + mExtraHeaderValues.get(i));
            //}
            //hcb.header(mExtraHeaderNames.get(i),
                       //mExtraHeaderValues.get(i));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.166 -0400", hash_original_method = "D8DC07475CD7B5300779AA7E8CC52DE7", hash_generated_method = "372F355821E4F7F7F5FA95618631A0A9")
    private void setConnectionType(CharArrayBuffer buffer, int pos) {
        {
            boolean varA7F18A145505BA8F70BFD34F9C06069F_197880534 = (CharArrayBuffers.containsIgnoreCaseTrimmed(
                buffer, pos, HTTP.CONN_CLOSE));
            {
                connectionType = CONN_CLOSE;
            } //End block
            {
                boolean varFA43AAAB4BAA63E0806E72853F50D31D_130452362 = (CharArrayBuffers.containsIgnoreCaseTrimmed(
                buffer, pos, HTTP.CONN_KEEP_ALIVE));
                {
                    connectionType = CONN_KEEP_ALIVE;
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(buffer.getTaint());
        addTaint(pos);
        // ---------- Original Method ----------
        //if (CharArrayBuffers.containsIgnoreCaseTrimmed(
                //buffer, pos, HTTP.CONN_CLOSE)) {
            //connectionType = CONN_CLOSE;
        //} else if (CharArrayBuffers.containsIgnoreCaseTrimmed(
                //buffer, pos, HTTP.CONN_KEEP_ALIVE)) {
            //connectionType = CONN_KEEP_ALIVE;
        //}
    }

    
    public interface HeaderCallback {
        public void header(String name, String value);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.167 -0400", hash_original_field = "612150595DFE4003266A71271894AF14", hash_generated_field = "D801BA9EDE316931B4F9A041D653A61D")

    private static String LOGTAG = "Http";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.167 -0400", hash_original_field = "407E5F680BD04BACCEB817A103A50F00", hash_generated_field = "790FEF378F4A1A682AF4B41C9D24056F")

    public final static int CONN_CLOSE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.167 -0400", hash_original_field = "AEA735DA8BC832151ED189F82C31380B", hash_generated_field = "759A5671D76D24A450C80BB03C36839E")

    public final static int CONN_KEEP_ALIVE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.167 -0400", hash_original_field = "AFDBF9109F5A97B7016A1F87CA2E9846", hash_generated_field = "C649382C9AB58722060DB5AB1682F97D")

    public final static int NO_CONN_TYPE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.167 -0400", hash_original_field = "06952937F57CD8F7F43890043A86569F", hash_generated_field = "2FEECAE3BB793FDC0977A48B3934C1D7")

    public final static long NO_TRANSFER_ENCODING = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.167 -0400", hash_original_field = "5CEE9DB3A27E759D7AD398670A1CE790", hash_generated_field = "72BAC6DB337B3CBFE2C5510E69BA9F9E")

    public final static long NO_CONTENT_LENGTH = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.168 -0400", hash_original_field = "8DEB0311F0771D7522F79D89A21FE9B4", hash_generated_field = "81C0E7C8A5CDB2B0264004F8265CD667")

    public final static String TRANSFER_ENCODING = "transfer-encoding";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.168 -0400", hash_original_field = "F79EA97808642189968D19702A213671", hash_generated_field = "BBF93059A8ED698C0E55DF623F564D01")

    public final static String CONTENT_LEN = "content-length";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.168 -0400", hash_original_field = "3A558F5CAC0A7C913876ED4BEB31EAFC", hash_generated_field = "2216C6197D13B1CBCAB1FA436EA38B66")

    public final static String CONTENT_TYPE = "content-type";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.168 -0400", hash_original_field = "E960502D2AEEE0B4E0D2CF7652723A27", hash_generated_field = "AC7AEC23F2048D9EE3693A58E4F60F88")

    public final static String CONTENT_ENCODING = "content-encoding";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.168 -0400", hash_original_field = "E069D9D71F7EA60B8007325A29248070", hash_generated_field = "6192728184263C4E2E5B9E3FD278B74C")

    public final static String CONN_DIRECTIVE = "connection";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.168 -0400", hash_original_field = "AC3E5DB01896625C1947D64A70E083AC", hash_generated_field = "077B87B3238F3F1EF051B3253D47554A")

    public final static String LOCATION = "location";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.168 -0400", hash_original_field = "EF27CB722D0DB21D221A1917469E487D", hash_generated_field = "6B767E1F6F824B91FB0417CE6C9A3AF6")

    public final static String PROXY_CONNECTION = "proxy-connection";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.168 -0400", hash_original_field = "1B148D03B85D8CE7FE00DB85C486A904", hash_generated_field = "2D2256243B60098BAF60048C051D5E97")

    public final static String WWW_AUTHENTICATE = "www-authenticate";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.168 -0400", hash_original_field = "9413542422C0321085C75B8F2F1DEE10", hash_generated_field = "8E642334C5E492A104D3B96159F6D444")

    public final static String PROXY_AUTHENTICATE = "proxy-authenticate";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.168 -0400", hash_original_field = "9FBB81C1524477CB4404ACE5734E25B8", hash_generated_field = "77979705F62BBE313F3A54727E5E587F")

    public final static String CONTENT_DISPOSITION = "content-disposition";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.168 -0400", hash_original_field = "EB4B1B63CA3D3B3640F6BC82505CB7F7", hash_generated_field = "4F1D8FC17C7B449521008CC2D5D5ED06")

    public final static String ACCEPT_RANGES = "accept-ranges";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.168 -0400", hash_original_field = "899162B90BDD687F90078C4CDC23D4AA", hash_generated_field = "801AFDC8DD450D337B40F6B07B2264AB")

    public final static String EXPIRES = "expires";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.168 -0400", hash_original_field = "995039850F6933531ADBF085144D875B", hash_generated_field = "450B3E04B5010DB41F35CA8B949FED30")

    public final static String CACHE_CONTROL = "cache-control";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.168 -0400", hash_original_field = "3CAC844485C9DD5182F7F1556C4AA670", hash_generated_field = "F6800EEE3C9C1A70EB3C6720414DA669")

    public final static String LAST_MODIFIED = "last-modified";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.168 -0400", hash_original_field = "6A21E681F37FC63154C540A8DA9B79E2", hash_generated_field = "88106202FCB92FEEAF5138D6C6806089")

    public final static String ETAG = "etag";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.168 -0400", hash_original_field = "183FE31C48369038CD715D85AB864C12", hash_generated_field = "A7FDB9E1F185D0CC04AEFA5AC7F01D3F")

    public final static String SET_COOKIE = "set-cookie";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.168 -0400", hash_original_field = "22A260DE0D42B99893815DC8FEC81C94", hash_generated_field = "D6513DD9C72F81B9F9DC8D34DCFDB1E7")

    public final static String PRAGMA = "pragma";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.169 -0400", hash_original_field = "FDEC2DDED8A4771AEC1D10E2C4B907F1", hash_generated_field = "3265C52EE1FA28461C3C83C045036136")

    public final static String REFRESH = "refresh";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.169 -0400", hash_original_field = "1A2BA4D108EFCE51C6D5B0B466E17EBF", hash_generated_field = "589DB52C07CE6D4B43E09172999F3F5B")

    public final static String X_PERMITTED_CROSS_DOMAIN_POLICIES = "x-permitted-cross-domain-policies";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.169 -0400", hash_original_field = "7DCB1E6E2419AE8BB6354AE32469CD1F", hash_generated_field = "EFDB064AFA88DA4F48503B82BB73FEEC")

    private static int HASH_TRANSFER_ENCODING = 1274458357;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.186 -0400", hash_original_field = "F6AE93C62A9C4B1C446A9C376B0E9163", hash_generated_field = "5A1F24811CFBBE924D134C0DCC6D4B54")

    private static int HASH_CONTENT_LEN = -1132779846;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.186 -0400", hash_original_field = "CE3FA19000F98F6961CB547308644806", hash_generated_field = "19061E374E405E335CAACA1F6A2D2C48")

    private static int HASH_CONTENT_TYPE = 785670158;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.186 -0400", hash_original_field = "C4E8C552997FADBF3ECEE84D6AD484BC", hash_generated_field = "900EEF11E19371AB6E72E948FB6B520A")

    private static int HASH_CONTENT_ENCODING = 2095084583;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.194 -0400", hash_original_field = "12EF68F4DCD0171AE874356453CD2A94", hash_generated_field = "C4A34141A0F0A77BFB359E9C5D6AD8A9")

    private static int HASH_CONN_DIRECTIVE = -775651618;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.195 -0400", hash_original_field = "066291ADE0198A023FD5EC6848430241", hash_generated_field = "F978DB550E08CB70F444D732E92CB06A")

    private static int HASH_LOCATION = 1901043637;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.195 -0400", hash_original_field = "F1E815604E3F947BC9B72101D1EDA7BB", hash_generated_field = "4E50F4E53984D7FC5C9A40AA65DAEAD9")

    private static int HASH_PROXY_CONNECTION = 285929373;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.195 -0400", hash_original_field = "0F517DCECEA0C8AE9647445A793F3987", hash_generated_field = "A523663ACE49479126EB3025477B3946")

    private static int HASH_WWW_AUTHENTICATE = -243037365;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.195 -0400", hash_original_field = "ED06A9BFF04FECE4950DFDEE5EE05AF1", hash_generated_field = "ABCDDB401E9928AC118B456C9CA00DE9")

    private static int HASH_PROXY_AUTHENTICATE = -301767724;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.195 -0400", hash_original_field = "173E3BE9FAADF30845277AFB76CEEFB3", hash_generated_field = "45ECED85A217C1D2C122C84A39DF671C")

    private static int HASH_CONTENT_DISPOSITION = -1267267485;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.195 -0400", hash_original_field = "8FF5693B66F696F6A1F2B1F33A4DEA52", hash_generated_field = "DBBC49E6EEB6681C100DE2D65CEA448C")

    private static int HASH_ACCEPT_RANGES = 1397189435;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.195 -0400", hash_original_field = "F6F1A192B0ADD1AC6EE258779D3787A0", hash_generated_field = "F7590502C44EFAFC663588F130B84B47")

    private static int HASH_EXPIRES = -1309235404;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.195 -0400", hash_original_field = "D6CB01DA7CF812A3B6A997EA09D61439", hash_generated_field = "6121176BDF3FDB1E27981929E3A4D7EF")

    private static int HASH_CACHE_CONTROL = -208775662;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.195 -0400", hash_original_field = "461388A74CBC8602EEC3AD4B6E6BB52E", hash_generated_field = "0D55D55DE11D16B5F8F871785FDDE9A8")

    private static int HASH_LAST_MODIFIED = 150043680;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.195 -0400", hash_original_field = "3BFBA6538863A5E450CC20B064E9D3CA", hash_generated_field = "F184A74E58FAE0DFF795C1A4B4984E2C")

    private static int HASH_ETAG = 3123477;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.196 -0400", hash_original_field = "10860C69BEBEE45F29490E3AA41152D5", hash_generated_field = "A12BE633DED75A8E8C1146CC58DDCFE6")

    private static int HASH_SET_COOKIE = 1237214767;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.196 -0400", hash_original_field = "3577DD8B81ACAD928BE112A59D0AF344", hash_generated_field = "5A9B11F7DE9239DB35FC47350E49E9AA")

    private static int HASH_PRAGMA = -980228804;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.196 -0400", hash_original_field = "4D3A0B7EC348FF1B2216015904A0A246", hash_generated_field = "8FA4676EA65EAE11DAB2E839D135DE09")

    private static int HASH_REFRESH = 1085444827;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.196 -0400", hash_original_field = "8F019FCD8B7537C9357B0736043BB896", hash_generated_field = "0887D96C172D1BB2D99ECA9BC8CFA7F9")

    private static int HASH_X_PERMITTED_CROSS_DOMAIN_POLICIES = -1345594014;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.196 -0400", hash_original_field = "5DC62DF0C607BF8770D9D95A9669A08B", hash_generated_field = "289E5BC6F8A561BA4D5A299EAF673370")

    private static int IDX_TRANSFER_ENCODING = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.196 -0400", hash_original_field = "EBA2F308DA19F0AE1299FEA3E9D475DD", hash_generated_field = "3D78D515AB3F977137608233ABA71359")

    private static int IDX_CONTENT_LEN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.196 -0400", hash_original_field = "B22051A9603BF3F6248FC62174D5028D", hash_generated_field = "54A2913891FF7039D5977A3180B0239B")

    private static int IDX_CONTENT_TYPE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.196 -0400", hash_original_field = "3BAC7725457934B469099E50BCB1680A", hash_generated_field = "0ADC6B9D98A19DF46194B879BC29B27C")

    private static int IDX_CONTENT_ENCODING = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.196 -0400", hash_original_field = "2FD60D3A896321F0522A9CA27C68E8BA", hash_generated_field = "CC5604072B9BD3AC4316FDA568C0B39E")

    private static int IDX_CONN_DIRECTIVE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.196 -0400", hash_original_field = "BEAF16303B80BEE827DD7BC0E9B94D15", hash_generated_field = "130B9C3C054BA80207B30F584AE64C22")

    private static int IDX_LOCATION = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.196 -0400", hash_original_field = "8E26C8DF9181BFA2B29149C63FEF68BC", hash_generated_field = "F1446DB42E0ACDE4C5B849F418593465")

    private static int IDX_PROXY_CONNECTION = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.196 -0400", hash_original_field = "74EF79A98544A41388966EDCD0014263", hash_generated_field = "C431E166C602C46CAF2B827680715271")

    private static int IDX_WWW_AUTHENTICATE = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.196 -0400", hash_original_field = "7CE1AD0D75649A86FC46477FFA0F8D62", hash_generated_field = "84F8F93CF65DDD9BEEB986EFAD622880")

    private static int IDX_PROXY_AUTHENTICATE = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.196 -0400", hash_original_field = "8067B6920D348FF78943CBB1E8986ABD", hash_generated_field = "BEBB397E6A1A8EAF4F984A158E3BD9EA")

    private static int IDX_CONTENT_DISPOSITION = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.197 -0400", hash_original_field = "15A667D02E4D22D9F1A2C8F8D47DE2F8", hash_generated_field = "754048DA46378A2C11A9F8762D3183C2")

    private static int IDX_ACCEPT_RANGES = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.197 -0400", hash_original_field = "2239F69C37846C8CA137B37B1FAA5E74", hash_generated_field = "3B9EC2BBCB7FD8D184C7E3ABFF3D4547")

    private static int IDX_EXPIRES = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.197 -0400", hash_original_field = "7FC67061ACDBE2D6B74D34C2A94596A7", hash_generated_field = "0DFCF9BBE9D74EA618BD19060FF68338")

    private static int IDX_CACHE_CONTROL = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.197 -0400", hash_original_field = "0E84955E44F8C16470103D1D87936A80", hash_generated_field = "D370B216A28DF54FBBBB14742EF8342F")

    private static int IDX_LAST_MODIFIED = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.197 -0400", hash_original_field = "9C097AA1DAD7FEFE6E9EC1C94A0DFC50", hash_generated_field = "B3198308E1032A0633EE1149B448B521")

    private static int IDX_ETAG = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.197 -0400", hash_original_field = "79B3D5DCFD65ABEFE489ACE52AE20AC2", hash_generated_field = "FDEB0919B8B20319F2815508DD030F5B")

    private static int IDX_SET_COOKIE = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.197 -0400", hash_original_field = "1B246BDA80341FA31A6A704F0475652E", hash_generated_field = "494BE8621003596717D24ECA07C35493")

    private static int IDX_PRAGMA = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.197 -0400", hash_original_field = "39E4FBE534CCB95945B78E9221D44677", hash_generated_field = "2DA38FE0AC5BF2D932889CEA96BACE03")

    private static int IDX_REFRESH = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.197 -0400", hash_original_field = "7153FB040BE584719153829EC7123080", hash_generated_field = "7DE226FA0E966A5A9F1D601D1D9E3323")

    private static int IDX_X_PERMITTED_CROSS_DOMAIN_POLICIES = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.197 -0400", hash_original_field = "910C9F4D2F4555FCDC34B7D607B41581", hash_generated_field = "A60D727C2B8187FF81F411D4E8E95A53")

    private static int HEADER_COUNT = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:23.197 -0400", hash_original_field = "C23E4839C27DCAEECF0DD9B376F20AC7", hash_generated_field = "BD18DCA3889C6728159BE69C0CDAE732")

    private static String[] sHeaderNames = {
        TRANSFER_ENCODING,
        CONTENT_LEN,
        CONTENT_TYPE,
        CONTENT_ENCODING,
        CONN_DIRECTIVE,
        LOCATION,
        PROXY_CONNECTION,
        WWW_AUTHENTICATE,
        PROXY_AUTHENTICATE,
        CONTENT_DISPOSITION,
        ACCEPT_RANGES,
        EXPIRES,
        CACHE_CONTROL,
        LAST_MODIFIED,
        ETAG,
        SET_COOKIE,
        PRAGMA,
        REFRESH,
        X_PERMITTED_CROSS_DOMAIN_POLICIES
    };
}

