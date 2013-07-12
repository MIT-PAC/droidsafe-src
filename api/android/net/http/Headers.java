package android.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.Log;
import java.util.ArrayList;
import org.apache.http.HeaderElement;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.message.BasicHeaderValueParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;

public final class Headers {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.107 -0400", hash_original_field = "BF0487A5497D96D26C24936A4DAD1B2F", hash_generated_field = "F2168064076810E0CC499B9D7EF97699")

    private long transferEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.108 -0400", hash_original_field = "C22384F3ABFE57BC648B6E1701C98123", hash_generated_field = "0235B86EE2D19DB7BC14B5867FCABFC4")

    private long contentLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.108 -0400", hash_original_field = "211C5E8A476F3181470CEE17081D7958", hash_generated_field = "DA79CCF89C0444B28B1A4FCF4B709AC2")

    private int connectionType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.108 -0400", hash_original_field = "5204FD70AB0CA4AB431F9A4DF4CD9C50", hash_generated_field = "059D703F12F9B58BFA7B38580D912F7A")

    private ArrayList<String> cookies = new ArrayList<String>(2);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.108 -0400", hash_original_field = "DDA6AB837C8C8328F79C6876FD10B24A", hash_generated_field = "86073EAB5791FF38D937FACC8B8B5D5A")

    private String[] mHeaders = new String[HEADER_COUNT];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.108 -0400", hash_original_field = "F4FD85C873339BB50CE1A07443D5EE9F", hash_generated_field = "591B6F2110CB6CDD1C1A9CAA5287338F")

    private ArrayList<String> mExtraHeaderNames = new ArrayList<String>(4);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.108 -0400", hash_original_field = "D6CEC2A0096C2E751F2D33225691E9F6", hash_generated_field = "41D0A1235C58997B9BD356936A71763B")

    private ArrayList<String> mExtraHeaderValues = new ArrayList<String>(4);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.109 -0400", hash_original_method = "4806F09499B83A0F8F6BA6D2EDAE6CDA", hash_generated_method = "8727A8D60C0E27C0BFDFF3C48804DA1B")
    public  Headers() {
        transferEncoding = NO_TRANSFER_ENCODING;
        contentLength = NO_CONTENT_LENGTH;
        connectionType = NO_CONN_TYPE;
        // ---------- Original Method ----------
        //transferEncoding = NO_TRANSFER_ENCODING;
        //contentLength = NO_CONTENT_LENGTH;
        //connectionType = NO_CONN_TYPE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.112 -0400", hash_original_method = "2601C4AB5843D67812F736A8664254C1", hash_generated_method = "D5921096C543C09E21EC2A037C4802B6")
    public void parseHeader(CharArrayBuffer buffer) {
        addTaint(buffer.getTaint());
        int pos = CharArrayBuffers.setLowercaseIndexOf(buffer, ':');
    if(pos == -1)        
        {
            return;
        } //End block
        String name = buffer.substringTrimmed(0, pos);
    if(name.length() == 0)        
        {
            return;
        } //End block
        pos++;
        String val = buffer.substringTrimmed(pos, buffer.length());
    if(HttpLog.LOGV)        
        {
            HttpLog.v("hdr " + buffer.length() + " " + buffer);
        } //End block
switch(name.hashCode()){
        case HASH_TRANSFER_ENCODING:
    if(name.equals(TRANSFER_ENCODING))        
        {
            mHeaders[IDX_TRANSFER_ENCODING] = val;
            HeaderElement[] encodings = BasicHeaderValueParser.DEFAULT
                        .parseElements(buffer, new ParserCursor(pos,
                                buffer.length()));
            int len = encodings.length;
    if(HTTP.IDENTITY_CODING.equalsIgnoreCase(val))            
            {
                transferEncoding = ContentLengthStrategy.IDENTITY;
            } //End block
            else
    if((len > 0)
                        && (HTTP.CHUNK_CODING
                                .equalsIgnoreCase(encodings[len - 1].getName())))            
            {
                transferEncoding = ContentLengthStrategy.CHUNKED;
            } //End block
            else
            {
                transferEncoding = ContentLengthStrategy.IDENTITY;
            } //End block
        } //End block
        break;
        case HASH_CONTENT_LEN:
    if(name.equals(CONTENT_LEN))        
        {
            mHeaders[IDX_CONTENT_LEN] = val;
            try 
            {
                contentLength = Long.parseLong(val);
            } //End block
            catch (NumberFormatException e)
            {
    if(false)                
                {
                } //End block
            } //End block
        } //End block
        break;
        case HASH_CONTENT_TYPE:
    if(name.equals(CONTENT_TYPE))        
        {
            mHeaders[IDX_CONTENT_TYPE] = val;
        } //End block
        break;
        case HASH_CONTENT_ENCODING:
    if(name.equals(CONTENT_ENCODING))        
        {
            mHeaders[IDX_CONTENT_ENCODING] = val;
        } //End block
        break;
        case HASH_CONN_DIRECTIVE:
    if(name.equals(CONN_DIRECTIVE))        
        {
            mHeaders[IDX_CONN_DIRECTIVE] = val;
            setConnectionType(buffer, pos);
        } //End block
        break;
        case HASH_LOCATION:
    if(name.equals(LOCATION))        
        {
            mHeaders[IDX_LOCATION] = val;
        } //End block
        break;
        case HASH_PROXY_CONNECTION:
    if(name.equals(PROXY_CONNECTION))        
        {
            mHeaders[IDX_PROXY_CONNECTION] = val;
            setConnectionType(buffer, pos);
        } //End block
        break;
        case HASH_WWW_AUTHENTICATE:
    if(name.equals(WWW_AUTHENTICATE))        
        {
            mHeaders[IDX_WWW_AUTHENTICATE] = val;
        } //End block
        break;
        case HASH_PROXY_AUTHENTICATE:
    if(name.equals(PROXY_AUTHENTICATE))        
        {
            mHeaders[IDX_PROXY_AUTHENTICATE] = val;
        } //End block
        break;
        case HASH_CONTENT_DISPOSITION:
    if(name.equals(CONTENT_DISPOSITION))        
        {
            mHeaders[IDX_CONTENT_DISPOSITION] = val;
        } //End block
        break;
        case HASH_ACCEPT_RANGES:
    if(name.equals(ACCEPT_RANGES))        
        {
            mHeaders[IDX_ACCEPT_RANGES] = val;
        } //End block
        break;
        case HASH_EXPIRES:
    if(name.equals(EXPIRES))        
        {
            mHeaders[IDX_EXPIRES] = val;
        } //End block
        break;
        case HASH_CACHE_CONTROL:
    if(name.equals(CACHE_CONTROL))        
        {
    if(mHeaders[IDX_CACHE_CONTROL] != null &&
                    mHeaders[IDX_CACHE_CONTROL].length() > 0)            
            {
                mHeaders[IDX_CACHE_CONTROL] += (',' + val);
            } //End block
            else
            {
                mHeaders[IDX_CACHE_CONTROL] = val;
            } //End block
        } //End block
        break;
        case HASH_LAST_MODIFIED:
    if(name.equals(LAST_MODIFIED))        
        {
            mHeaders[IDX_LAST_MODIFIED] = val;
        } //End block
        break;
        case HASH_ETAG:
    if(name.equals(ETAG))        
        {
            mHeaders[IDX_ETAG] = val;
        } //End block
        break;
        case HASH_SET_COOKIE:
    if(name.equals(SET_COOKIE))        
        {
            mHeaders[IDX_SET_COOKIE] = val;
            cookies.add(val);
        } //End block
        break;
        case HASH_PRAGMA:
    if(name.equals(PRAGMA))        
        {
            mHeaders[IDX_PRAGMA] = val;
        } //End block
        break;
        case HASH_REFRESH:
    if(name.equals(REFRESH))        
        {
            mHeaders[IDX_REFRESH] = val;
        } //End block
        break;
        case HASH_X_PERMITTED_CROSS_DOMAIN_POLICIES:
    if(name.equals(X_PERMITTED_CROSS_DOMAIN_POLICIES))        
        {
            mHeaders[IDX_X_PERMITTED_CROSS_DOMAIN_POLICIES] = val;
        } //End block
        break;
        default:
        mExtraHeaderNames.add(name);
        mExtraHeaderValues.add(val);
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.114 -0400", hash_original_method = "839965513DF286AFAE2E56076E19ADBF", hash_generated_method = "FE3FED2B4761F57AEC3C406C4B276F23")
    public long getTransferEncoding() {
        long varBF0487A5497D96D26C24936A4DAD1B2F_76398384 = (transferEncoding);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_142392775 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_142392775;
        // ---------- Original Method ----------
        //return transferEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.114 -0400", hash_original_method = "043A311B0C55CC2C0E7ED635C15C25FD", hash_generated_method = "C48635C8E665D6898028BA4CF3CCB544")
    public long getContentLength() {
        long varC22384F3ABFE57BC648B6E1701C98123_1736362261 = (contentLength);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_950902136 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_950902136;
        // ---------- Original Method ----------
        //return contentLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.114 -0400", hash_original_method = "16A8DC2EF1F4EBF751AEB83B8F69222E", hash_generated_method = "54061D012BCED82C3247B3E6D7BDBAB2")
    public int getConnectionType() {
        int var211C5E8A476F3181470CEE17081D7958_765362991 = (connectionType);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1333827424 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1333827424;
        // ---------- Original Method ----------
        //return connectionType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.114 -0400", hash_original_method = "0358D0D4AEFF84195277AB782B3FFDE2", hash_generated_method = "7F95E6082B61715167F426A45FE4935D")
    public String getContentType() {
String var68DFEFC547B2BB8B52F5A11CFF9F7372_1514771473 =         mHeaders[IDX_CONTENT_TYPE];
        var68DFEFC547B2BB8B52F5A11CFF9F7372_1514771473.addTaint(taint);
        return var68DFEFC547B2BB8B52F5A11CFF9F7372_1514771473;
        // ---------- Original Method ----------
        //return mHeaders[IDX_CONTENT_TYPE];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.115 -0400", hash_original_method = "DC3B5CC0DA80597E20563D04CDFF5783", hash_generated_method = "AF7B4E2FE721D9FB9FD710E897C6D036")
    public String getContentEncoding() {
String varF6E2606C1B28A3BEE2306FE43C1825FD_776647401 =         mHeaders[IDX_CONTENT_ENCODING];
        varF6E2606C1B28A3BEE2306FE43C1825FD_776647401.addTaint(taint);
        return varF6E2606C1B28A3BEE2306FE43C1825FD_776647401;
        // ---------- Original Method ----------
        //return mHeaders[IDX_CONTENT_ENCODING];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.115 -0400", hash_original_method = "3BEB5C295081F99F7A9897994B243966", hash_generated_method = "FD3DE476CD00F5AD9F745438AB997296")
    public String getLocation() {
String var6B2671B19DAC1D6F7A2CBEC3FBEB845F_1636102423 =         mHeaders[IDX_LOCATION];
        var6B2671B19DAC1D6F7A2CBEC3FBEB845F_1636102423.addTaint(taint);
        return var6B2671B19DAC1D6F7A2CBEC3FBEB845F_1636102423;
        // ---------- Original Method ----------
        //return mHeaders[IDX_LOCATION];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.115 -0400", hash_original_method = "2ABA1BEE8C50AB0C1324E3514B439A3C", hash_generated_method = "93BA2B0512A99923FF0991B5544598B8")
    public String getWwwAuthenticate() {
String var035667D994870A2BA864BEE4C8A0B623_693790961 =         mHeaders[IDX_WWW_AUTHENTICATE];
        var035667D994870A2BA864BEE4C8A0B623_693790961.addTaint(taint);
        return var035667D994870A2BA864BEE4C8A0B623_693790961;
        // ---------- Original Method ----------
        //return mHeaders[IDX_WWW_AUTHENTICATE];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.116 -0400", hash_original_method = "2251D004613BB9CDF5BB072ECCA1B196", hash_generated_method = "3D438F8C37648A040F1AC23D54D84F71")
    public String getProxyAuthenticate() {
String var11A843757674ABCDB749B9892F94AE04_1253943729 =         mHeaders[IDX_PROXY_AUTHENTICATE];
        var11A843757674ABCDB749B9892F94AE04_1253943729.addTaint(taint);
        return var11A843757674ABCDB749B9892F94AE04_1253943729;
        // ---------- Original Method ----------
        //return mHeaders[IDX_PROXY_AUTHENTICATE];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.116 -0400", hash_original_method = "B3734B1B2E8291E968F6C56DD5A68AFD", hash_generated_method = "88F9277AE3A7BBE8E3CE2AE60488789B")
    public String getContentDisposition() {
String var58A187BDC6B26516F0532A0CEE3FF76C_107958234 =         mHeaders[IDX_CONTENT_DISPOSITION];
        var58A187BDC6B26516F0532A0CEE3FF76C_107958234.addTaint(taint);
        return var58A187BDC6B26516F0532A0CEE3FF76C_107958234;
        // ---------- Original Method ----------
        //return mHeaders[IDX_CONTENT_DISPOSITION];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.116 -0400", hash_original_method = "56F3083ED56642A8109311F7B75978CE", hash_generated_method = "A78CB4864839BEF2ACC843DCF066E006")
    public String getAcceptRanges() {
String var8832B2B34856DC6643D46FB7F38ADDBB_377223366 =         mHeaders[IDX_ACCEPT_RANGES];
        var8832B2B34856DC6643D46FB7F38ADDBB_377223366.addTaint(taint);
        return var8832B2B34856DC6643D46FB7F38ADDBB_377223366;
        // ---------- Original Method ----------
        //return mHeaders[IDX_ACCEPT_RANGES];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.116 -0400", hash_original_method = "AD48730753A27EE5F83CD5FBE4AD4C5B", hash_generated_method = "D4DF90AC74819E3A5D7DA5D7FB0C1725")
    public String getExpires() {
String varBC431B5F34399A1FDE55577E9841D5BA_342310168 =         mHeaders[IDX_EXPIRES];
        varBC431B5F34399A1FDE55577E9841D5BA_342310168.addTaint(taint);
        return varBC431B5F34399A1FDE55577E9841D5BA_342310168;
        // ---------- Original Method ----------
        //return mHeaders[IDX_EXPIRES];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.117 -0400", hash_original_method = "FAE5B14F1D1AF7F7C5B34799287CB96B", hash_generated_method = "F711CDB3EEA9C15A781C98886E5B5127")
    public String getCacheControl() {
String varF9B244B3639BD646319F32F483E2ADC8_1783127658 =         mHeaders[IDX_CACHE_CONTROL];
        varF9B244B3639BD646319F32F483E2ADC8_1783127658.addTaint(taint);
        return varF9B244B3639BD646319F32F483E2ADC8_1783127658;
        // ---------- Original Method ----------
        //return mHeaders[IDX_CACHE_CONTROL];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.117 -0400", hash_original_method = "5FC9B5DD06D10DB2F99A11CF11E84611", hash_generated_method = "1D36D0A30C2E71690959D98E7856CF4C")
    public String getLastModified() {
String var5CBB8E7B291E7845AD9CB798C889A166_905031905 =         mHeaders[IDX_LAST_MODIFIED];
        var5CBB8E7B291E7845AD9CB798C889A166_905031905.addTaint(taint);
        return var5CBB8E7B291E7845AD9CB798C889A166_905031905;
        // ---------- Original Method ----------
        //return mHeaders[IDX_LAST_MODIFIED];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.117 -0400", hash_original_method = "2356D85AA5974933778FA07340E360AB", hash_generated_method = "1CD1828A95CFD935D288EEC319E9083D")
    public String getEtag() {
String varEA40237F28A2A49ABCE426F07305D1E1_1538096892 =         mHeaders[IDX_ETAG];
        varEA40237F28A2A49ABCE426F07305D1E1_1538096892.addTaint(taint);
        return varEA40237F28A2A49ABCE426F07305D1E1_1538096892;
        // ---------- Original Method ----------
        //return mHeaders[IDX_ETAG];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.117 -0400", hash_original_method = "30BF89B95A4B495DCD1A87F8054AFEC5", hash_generated_method = "37D09C685BA6CD53ABB0A7FB1CC7BD9C")
    public ArrayList<String> getSetCookie() {
ArrayList<String> varDA579E1AE78A0708AD34B938DB7932DB_307414046 =         this.cookies;
        varDA579E1AE78A0708AD34B938DB7932DB_307414046.addTaint(taint);
        return varDA579E1AE78A0708AD34B938DB7932DB_307414046;
        // ---------- Original Method ----------
        //return this.cookies;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.118 -0400", hash_original_method = "A30AE7605FF81FB95FDA5AAF057C022D", hash_generated_method = "1A856F95FD407509339D052EB342D3FA")
    public String getPragma() {
String var2E7E189C4E4E5089F1B117342ED1C0B0_130796988 =         mHeaders[IDX_PRAGMA];
        var2E7E189C4E4E5089F1B117342ED1C0B0_130796988.addTaint(taint);
        return var2E7E189C4E4E5089F1B117342ED1C0B0_130796988;
        // ---------- Original Method ----------
        //return mHeaders[IDX_PRAGMA];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.118 -0400", hash_original_method = "847E30EC42ECB16F3B862D5A0C1778F0", hash_generated_method = "A58290A9FA457124DC8EE69137C7BA34")
    public String getRefresh() {
String var3839F9F3082033EEC8BC7C5F80E7CDF1_2136180173 =         mHeaders[IDX_REFRESH];
        var3839F9F3082033EEC8BC7C5F80E7CDF1_2136180173.addTaint(taint);
        return var3839F9F3082033EEC8BC7C5F80E7CDF1_2136180173;
        // ---------- Original Method ----------
        //return mHeaders[IDX_REFRESH];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.118 -0400", hash_original_method = "120DF6C7E530068F21D41A0CCD884530", hash_generated_method = "B67C73B6463A71BFDB18441AEBCB41E7")
    public String getXPermittedCrossDomainPolicies() {
String var17C6D7BCB7048A099232B37BE34F1343_1825000810 =         mHeaders[IDX_X_PERMITTED_CROSS_DOMAIN_POLICIES];
        var17C6D7BCB7048A099232B37BE34F1343_1825000810.addTaint(taint);
        return var17C6D7BCB7048A099232B37BE34F1343_1825000810;
        // ---------- Original Method ----------
        //return mHeaders[IDX_X_PERMITTED_CROSS_DOMAIN_POLICIES];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.119 -0400", hash_original_method = "655405705FFA26A24CEE799E196F64CA", hash_generated_method = "70CE888A9FFED207F0803974796E927C")
    public void setContentLength(long value) {
        this.contentLength = value;
        // ---------- Original Method ----------
        //this.contentLength = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.122 -0400", hash_original_method = "DBD4B3393EC7C86D318F09AACB690C16", hash_generated_method = "A9ED9CE54B818219D22AD6B7B9BAB2F8")
    public void setContentType(String value) {
        mHeaders[IDX_CONTENT_TYPE] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_CONTENT_TYPE] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.123 -0400", hash_original_method = "795639D1D1B96C335181D978646FFEAC", hash_generated_method = "77D9B1C07F0FB32A9761C4B3F088F7CB")
    public void setContentEncoding(String value) {
        mHeaders[IDX_CONTENT_ENCODING] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_CONTENT_ENCODING] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.124 -0400", hash_original_method = "91ACBD0DA1F8B6B752177E887C1E560A", hash_generated_method = "FA0850D4F4C77DC48C8661B4E06FCDA6")
    public void setLocation(String value) {
        mHeaders[IDX_LOCATION] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_LOCATION] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.125 -0400", hash_original_method = "78E4D283A358D7F9AC830EDA5944CEC1", hash_generated_method = "4AAFA72378B619A1D7E762612FFED29E")
    public void setWwwAuthenticate(String value) {
        mHeaders[IDX_WWW_AUTHENTICATE] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_WWW_AUTHENTICATE] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.125 -0400", hash_original_method = "EB3C03E25C95805816417AB68A1F4E73", hash_generated_method = "FBAD98CF9FAB5BEE89E177BB5EA0711D")
    public void setProxyAuthenticate(String value) {
        mHeaders[IDX_PROXY_AUTHENTICATE] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_PROXY_AUTHENTICATE] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.126 -0400", hash_original_method = "CAF824941A606D9472E6B7F4D5AE8EAB", hash_generated_method = "6DBDC101C7D94B0D6851269BE8387BAB")
    public void setContentDisposition(String value) {
        mHeaders[IDX_CONTENT_DISPOSITION] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_CONTENT_DISPOSITION] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.126 -0400", hash_original_method = "42F6F595EF9293A515A4DDDF580E03E6", hash_generated_method = "5F85D3501DB5288A00CF9DDAB3832102")
    public void setAcceptRanges(String value) {
        mHeaders[IDX_ACCEPT_RANGES] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_ACCEPT_RANGES] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.126 -0400", hash_original_method = "7D2DC3B419C5BDAB21BBD8535AC32115", hash_generated_method = "76EA542A919CE34FD4D665398C623FD5")
    public void setExpires(String value) {
        mHeaders[IDX_EXPIRES] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_EXPIRES] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.127 -0400", hash_original_method = "461838AAEBDAFBB838DA60C8789FC643", hash_generated_method = "EEFBEAB5A98EC1741302CE7707E5564D")
    public void setCacheControl(String value) {
        mHeaders[IDX_CACHE_CONTROL] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_CACHE_CONTROL] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.127 -0400", hash_original_method = "E44516D40CA535A9E78D483DC766FE77", hash_generated_method = "88933EBF372CD7EBEFB5BE34D231304F")
    public void setLastModified(String value) {
        mHeaders[IDX_LAST_MODIFIED] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_LAST_MODIFIED] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.127 -0400", hash_original_method = "7E96E0634D296A60D862609FEA944EA2", hash_generated_method = "B4F381619A4DF76AF492305D6EACCE95")
    public void setEtag(String value) {
        mHeaders[IDX_ETAG] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_ETAG] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.128 -0400", hash_original_method = "860A5481555AE910297114E1D7478814", hash_generated_method = "F2E6E48B412C72FEA2876958E6643E79")
    public void setXPermittedCrossDomainPolicies(String value) {
        mHeaders[IDX_X_PERMITTED_CROSS_DOMAIN_POLICIES] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_X_PERMITTED_CROSS_DOMAIN_POLICIES] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.128 -0400", hash_original_method = "C9CAD2CB40E843B6A6F48005E0DE2B60", hash_generated_method = "30923DA0AE57756E8A61F663E0DC7572")
    public void getHeaders(HeaderCallback hcb) {
        addTaint(hcb.getTaint());
for(int i = 0;i < HEADER_COUNT;i++)
        {
            String h = mHeaders[i];
    if(h != null)            
            {
                hcb.header(sHeaderNames[i], h);
            } //End block
        } //End block
        int extraLen = mExtraHeaderNames.size();
for(int i = 0;i < extraLen;i++)
        {
    if(false)            
            {
                HttpLog.v("Headers.getHeaders() extra: " + i + " " +
                          mExtraHeaderNames.get(i) + " " + mExtraHeaderValues.get(i));
            } //End block
            hcb.header(mExtraHeaderNames.get(i),
                       mExtraHeaderValues.get(i));
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.129 -0400", hash_original_method = "D8DC07475CD7B5300779AA7E8CC52DE7", hash_generated_method = "66B7C8385AE771D2870E1D0EB24C67DF")
    private void setConnectionType(CharArrayBuffer buffer, int pos) {
        addTaint(pos);
        addTaint(buffer.getTaint());
    if(CharArrayBuffers.containsIgnoreCaseTrimmed(
                buffer, pos, HTTP.CONN_CLOSE))        
        {
            connectionType = CONN_CLOSE;
        } //End block
        else
    if(CharArrayBuffers.containsIgnoreCaseTrimmed(
                buffer, pos, HTTP.CONN_KEEP_ALIVE))        
        {
            connectionType = CONN_KEEP_ALIVE;
        } //End block
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.129 -0400", hash_original_field = "612150595DFE4003266A71271894AF14", hash_generated_field = "26F6F5D2EF35FA86B8698978CE2FD0C9")

    private static final String LOGTAG = "Http";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.129 -0400", hash_original_field = "407E5F680BD04BACCEB817A103A50F00", hash_generated_field = "790FEF378F4A1A682AF4B41C9D24056F")

    public final static int CONN_CLOSE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.129 -0400", hash_original_field = "AEA735DA8BC832151ED189F82C31380B", hash_generated_field = "759A5671D76D24A450C80BB03C36839E")

    public final static int CONN_KEEP_ALIVE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.129 -0400", hash_original_field = "AFDBF9109F5A97B7016A1F87CA2E9846", hash_generated_field = "C649382C9AB58722060DB5AB1682F97D")

    public final static int NO_CONN_TYPE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.129 -0400", hash_original_field = "06952937F57CD8F7F43890043A86569F", hash_generated_field = "2FEECAE3BB793FDC0977A48B3934C1D7")

    public final static long NO_TRANSFER_ENCODING = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.129 -0400", hash_original_field = "5CEE9DB3A27E759D7AD398670A1CE790", hash_generated_field = "72BAC6DB337B3CBFE2C5510E69BA9F9E")

    public final static long NO_CONTENT_LENGTH = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.129 -0400", hash_original_field = "8DEB0311F0771D7522F79D89A21FE9B4", hash_generated_field = "81C0E7C8A5CDB2B0264004F8265CD667")

    public final static String TRANSFER_ENCODING = "transfer-encoding";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.130 -0400", hash_original_field = "F79EA97808642189968D19702A213671", hash_generated_field = "BBF93059A8ED698C0E55DF623F564D01")

    public final static String CONTENT_LEN = "content-length";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.130 -0400", hash_original_field = "3A558F5CAC0A7C913876ED4BEB31EAFC", hash_generated_field = "2216C6197D13B1CBCAB1FA436EA38B66")

    public final static String CONTENT_TYPE = "content-type";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.130 -0400", hash_original_field = "E960502D2AEEE0B4E0D2CF7652723A27", hash_generated_field = "AC7AEC23F2048D9EE3693A58E4F60F88")

    public final static String CONTENT_ENCODING = "content-encoding";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.130 -0400", hash_original_field = "E069D9D71F7EA60B8007325A29248070", hash_generated_field = "6192728184263C4E2E5B9E3FD278B74C")

    public final static String CONN_DIRECTIVE = "connection";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.130 -0400", hash_original_field = "AC3E5DB01896625C1947D64A70E083AC", hash_generated_field = "077B87B3238F3F1EF051B3253D47554A")

    public final static String LOCATION = "location";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.130 -0400", hash_original_field = "EF27CB722D0DB21D221A1917469E487D", hash_generated_field = "6B767E1F6F824B91FB0417CE6C9A3AF6")

    public final static String PROXY_CONNECTION = "proxy-connection";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.130 -0400", hash_original_field = "1B148D03B85D8CE7FE00DB85C486A904", hash_generated_field = "2D2256243B60098BAF60048C051D5E97")

    public final static String WWW_AUTHENTICATE = "www-authenticate";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.130 -0400", hash_original_field = "9413542422C0321085C75B8F2F1DEE10", hash_generated_field = "8E642334C5E492A104D3B96159F6D444")

    public final static String PROXY_AUTHENTICATE = "proxy-authenticate";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.130 -0400", hash_original_field = "9FBB81C1524477CB4404ACE5734E25B8", hash_generated_field = "77979705F62BBE313F3A54727E5E587F")

    public final static String CONTENT_DISPOSITION = "content-disposition";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.130 -0400", hash_original_field = "EB4B1B63CA3D3B3640F6BC82505CB7F7", hash_generated_field = "4F1D8FC17C7B449521008CC2D5D5ED06")

    public final static String ACCEPT_RANGES = "accept-ranges";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.130 -0400", hash_original_field = "899162B90BDD687F90078C4CDC23D4AA", hash_generated_field = "801AFDC8DD450D337B40F6B07B2264AB")

    public final static String EXPIRES = "expires";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.130 -0400", hash_original_field = "995039850F6933531ADBF085144D875B", hash_generated_field = "450B3E04B5010DB41F35CA8B949FED30")

    public final static String CACHE_CONTROL = "cache-control";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.130 -0400", hash_original_field = "3CAC844485C9DD5182F7F1556C4AA670", hash_generated_field = "F6800EEE3C9C1A70EB3C6720414DA669")

    public final static String LAST_MODIFIED = "last-modified";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.131 -0400", hash_original_field = "6A21E681F37FC63154C540A8DA9B79E2", hash_generated_field = "88106202FCB92FEEAF5138D6C6806089")

    public final static String ETAG = "etag";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.131 -0400", hash_original_field = "183FE31C48369038CD715D85AB864C12", hash_generated_field = "A7FDB9E1F185D0CC04AEFA5AC7F01D3F")

    public final static String SET_COOKIE = "set-cookie";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.131 -0400", hash_original_field = "22A260DE0D42B99893815DC8FEC81C94", hash_generated_field = "D6513DD9C72F81B9F9DC8D34DCFDB1E7")

    public final static String PRAGMA = "pragma";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.131 -0400", hash_original_field = "FDEC2DDED8A4771AEC1D10E2C4B907F1", hash_generated_field = "3265C52EE1FA28461C3C83C045036136")

    public final static String REFRESH = "refresh";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.131 -0400", hash_original_field = "1A2BA4D108EFCE51C6D5B0B466E17EBF", hash_generated_field = "589DB52C07CE6D4B43E09172999F3F5B")

    public final static String X_PERMITTED_CROSS_DOMAIN_POLICIES = "x-permitted-cross-domain-policies";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.131 -0400", hash_original_field = "7DCB1E6E2419AE8BB6354AE32469CD1F", hash_generated_field = "E51E16F4FF72FD9B60ABEA316B8E6844")

    private final static int HASH_TRANSFER_ENCODING = 1274458357;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.131 -0400", hash_original_field = "F6AE93C62A9C4B1C446A9C376B0E9163", hash_generated_field = "F5FC2613E3682B4D30CB8F24594897C4")

    private final static int HASH_CONTENT_LEN = -1132779846;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.131 -0400", hash_original_field = "CE3FA19000F98F6961CB547308644806", hash_generated_field = "2EB57F7DCB54A1F1F5E38F0E0B773D84")

    private final static int HASH_CONTENT_TYPE = 785670158;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.131 -0400", hash_original_field = "C4E8C552997FADBF3ECEE84D6AD484BC", hash_generated_field = "10EE589BA2B105C140483634F384D4F1")

    private final static int HASH_CONTENT_ENCODING = 2095084583;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.131 -0400", hash_original_field = "12EF68F4DCD0171AE874356453CD2A94", hash_generated_field = "5F7325D24DBA2A1B8D67785D7C472600")

    private final static int HASH_CONN_DIRECTIVE = -775651618;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.131 -0400", hash_original_field = "066291ADE0198A023FD5EC6848430241", hash_generated_field = "E76AC333D9C173505D096F550CDC6F3F")

    private final static int HASH_LOCATION = 1901043637;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.131 -0400", hash_original_field = "F1E815604E3F947BC9B72101D1EDA7BB", hash_generated_field = "A32A3662A238F5A1AEFE7F75FA20BF09")

    private final static int HASH_PROXY_CONNECTION = 285929373;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.132 -0400", hash_original_field = "0F517DCECEA0C8AE9647445A793F3987", hash_generated_field = "3C987A8C74D00860013829B971A62ADE")

    private final static int HASH_WWW_AUTHENTICATE = -243037365;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.132 -0400", hash_original_field = "ED06A9BFF04FECE4950DFDEE5EE05AF1", hash_generated_field = "39B9CF5AFF4E85B3FB6C5386F84E577C")

    private final static int HASH_PROXY_AUTHENTICATE = -301767724;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.132 -0400", hash_original_field = "173E3BE9FAADF30845277AFB76CEEFB3", hash_generated_field = "60255A27DD37AF204BCBD75849E718A0")

    private final static int HASH_CONTENT_DISPOSITION = -1267267485;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.132 -0400", hash_original_field = "8FF5693B66F696F6A1F2B1F33A4DEA52", hash_generated_field = "8A32E37D07F6A32183177C86830D94FA")

    private final static int HASH_ACCEPT_RANGES = 1397189435;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.132 -0400", hash_original_field = "F6F1A192B0ADD1AC6EE258779D3787A0", hash_generated_field = "31BDF9B854D8ABD34017DFF737725819")

    private final static int HASH_EXPIRES = -1309235404;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.132 -0400", hash_original_field = "D6CB01DA7CF812A3B6A997EA09D61439", hash_generated_field = "A85CE708DEA5EFD2FB8BB109D6D0F3A4")

    private final static int HASH_CACHE_CONTROL = -208775662;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.132 -0400", hash_original_field = "461388A74CBC8602EEC3AD4B6E6BB52E", hash_generated_field = "2CD1F0F8BA900D39E844CE159B9E6448")

    private final static int HASH_LAST_MODIFIED = 150043680;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.132 -0400", hash_original_field = "3BFBA6538863A5E450CC20B064E9D3CA", hash_generated_field = "D0C9F7793ED99283D48E66BC52020A9E")

    private final static int HASH_ETAG = 3123477;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.132 -0400", hash_original_field = "10860C69BEBEE45F29490E3AA41152D5", hash_generated_field = "B917EBF6C3762CC1FE11961B1D17BA92")

    private final static int HASH_SET_COOKIE = 1237214767;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.132 -0400", hash_original_field = "3577DD8B81ACAD928BE112A59D0AF344", hash_generated_field = "98D663F2063865F4E92610AB48B9DCB2")

    private final static int HASH_PRAGMA = -980228804;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.132 -0400", hash_original_field = "4D3A0B7EC348FF1B2216015904A0A246", hash_generated_field = "8613521BF28512C3BE1153253E6BB597")

    private final static int HASH_REFRESH = 1085444827;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.132 -0400", hash_original_field = "8F019FCD8B7537C9357B0736043BB896", hash_generated_field = "9B9326E4B74B05E67C82C6AC78AE288D")

    private final static int HASH_X_PERMITTED_CROSS_DOMAIN_POLICIES = -1345594014;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.132 -0400", hash_original_field = "5DC62DF0C607BF8770D9D95A9669A08B", hash_generated_field = "73EAC9AA21355E40798F02139655C5A2")

    private final static int IDX_TRANSFER_ENCODING = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.133 -0400", hash_original_field = "EBA2F308DA19F0AE1299FEA3E9D475DD", hash_generated_field = "E6C21E4C7442EABC526E43342529ECBA")

    private final static int IDX_CONTENT_LEN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.133 -0400", hash_original_field = "B22051A9603BF3F6248FC62174D5028D", hash_generated_field = "F17D959A03C864A3D9E9C85EBE639D3A")

    private final static int IDX_CONTENT_TYPE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.133 -0400", hash_original_field = "3BAC7725457934B469099E50BCB1680A", hash_generated_field = "81924568DEED109B60E51488E4E4D2D4")

    private final static int IDX_CONTENT_ENCODING = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.133 -0400", hash_original_field = "2FD60D3A896321F0522A9CA27C68E8BA", hash_generated_field = "45CEAC5BEA88F3D103A34151707BCB5A")

    private final static int IDX_CONN_DIRECTIVE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.133 -0400", hash_original_field = "BEAF16303B80BEE827DD7BC0E9B94D15", hash_generated_field = "DAC5FEF48DD7C7DEFDB2EC3117246238")

    private final static int IDX_LOCATION = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.133 -0400", hash_original_field = "8E26C8DF9181BFA2B29149C63FEF68BC", hash_generated_field = "DA0E1FF2661CBA411A805657AD8983AD")

    private final static int IDX_PROXY_CONNECTION = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.133 -0400", hash_original_field = "74EF79A98544A41388966EDCD0014263", hash_generated_field = "BC104A1300C317C8DAE09161D68B7C76")

    private final static int IDX_WWW_AUTHENTICATE = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.133 -0400", hash_original_field = "7CE1AD0D75649A86FC46477FFA0F8D62", hash_generated_field = "83E881AD61875794DE6BD1EFA4BBE2DA")

    private final static int IDX_PROXY_AUTHENTICATE = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.133 -0400", hash_original_field = "8067B6920D348FF78943CBB1E8986ABD", hash_generated_field = "70C052905F33EAB389A11D557D076555")

    private final static int IDX_CONTENT_DISPOSITION = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.133 -0400", hash_original_field = "15A667D02E4D22D9F1A2C8F8D47DE2F8", hash_generated_field = "27766383D0D77C40D8B42F938D2C0C9F")

    private final static int IDX_ACCEPT_RANGES = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.133 -0400", hash_original_field = "2239F69C37846C8CA137B37B1FAA5E74", hash_generated_field = "D77A6684E8819F46E09969079559D5B7")

    private final static int IDX_EXPIRES = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.133 -0400", hash_original_field = "7FC67061ACDBE2D6B74D34C2A94596A7", hash_generated_field = "208E75CAF22A97D5A5E0232968B5F2E4")

    private final static int IDX_CACHE_CONTROL = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.134 -0400", hash_original_field = "0E84955E44F8C16470103D1D87936A80", hash_generated_field = "762CA1BA4BAD411E079325B2EDAC957D")

    private final static int IDX_LAST_MODIFIED = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.134 -0400", hash_original_field = "9C097AA1DAD7FEFE6E9EC1C94A0DFC50", hash_generated_field = "68DABB6487881B218EDDBC8C79608FC1")

    private final static int IDX_ETAG = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.134 -0400", hash_original_field = "79B3D5DCFD65ABEFE489ACE52AE20AC2", hash_generated_field = "B35684FB62BE0B535A372DBEE609ABE3")

    private final static int IDX_SET_COOKIE = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.134 -0400", hash_original_field = "1B246BDA80341FA31A6A704F0475652E", hash_generated_field = "46633A8E677F58AEFC32AB0BBD6EB035")

    private final static int IDX_PRAGMA = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.134 -0400", hash_original_field = "39E4FBE534CCB95945B78E9221D44677", hash_generated_field = "BEF97DDEA89012BFE6995EE975B0F93B")

    private final static int IDX_REFRESH = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.134 -0400", hash_original_field = "7153FB040BE584719153829EC7123080", hash_generated_field = "95DE7AD1FEC1D3A3BFBE6B5D8ECCDCB1")

    private final static int IDX_X_PERMITTED_CROSS_DOMAIN_POLICIES = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.134 -0400", hash_original_field = "910C9F4D2F4555FCDC34B7D607B41581", hash_generated_field = "0B2442CA0B92E2CCC52F7846B6D391D9")

    private final static int HEADER_COUNT = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:27.134 -0400", hash_original_field = "C23E4839C27DCAEECF0DD9B376F20AC7", hash_generated_field = "22ED680D75DAA14488B618AAD5F441A4")

    private final static String[] sHeaderNames = {
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

