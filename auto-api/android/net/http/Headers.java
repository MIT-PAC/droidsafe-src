package android.net.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.832 -0400", hash_original_field = "BF0487A5497D96D26C24936A4DAD1B2F", hash_generated_field = "F2168064076810E0CC499B9D7EF97699")

    private long transferEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.832 -0400", hash_original_field = "C22384F3ABFE57BC648B6E1701C98123", hash_generated_field = "0235B86EE2D19DB7BC14B5867FCABFC4")

    private long contentLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.832 -0400", hash_original_field = "211C5E8A476F3181470CEE17081D7958", hash_generated_field = "DA79CCF89C0444B28B1A4FCF4B709AC2")

    private int connectionType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.833 -0400", hash_original_field = "5204FD70AB0CA4AB431F9A4DF4CD9C50", hash_generated_field = "059D703F12F9B58BFA7B38580D912F7A")

    private ArrayList<String> cookies = new ArrayList<String>(2);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.833 -0400", hash_original_field = "DDA6AB837C8C8328F79C6876FD10B24A", hash_generated_field = "86073EAB5791FF38D937FACC8B8B5D5A")

    private String[] mHeaders = new String[HEADER_COUNT];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.833 -0400", hash_original_field = "F4FD85C873339BB50CE1A07443D5EE9F", hash_generated_field = "591B6F2110CB6CDD1C1A9CAA5287338F")

    private ArrayList<String> mExtraHeaderNames = new ArrayList<String>(4);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.833 -0400", hash_original_field = "D6CEC2A0096C2E751F2D33225691E9F6", hash_generated_field = "41D0A1235C58997B9BD356936A71763B")

    private ArrayList<String> mExtraHeaderValues = new ArrayList<String>(4);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.833 -0400", hash_original_method = "4806F09499B83A0F8F6BA6D2EDAE6CDA", hash_generated_method = "8727A8D60C0E27C0BFDFF3C48804DA1B")
    public  Headers() {
        transferEncoding = NO_TRANSFER_ENCODING;
        contentLength = NO_CONTENT_LENGTH;
        connectionType = NO_CONN_TYPE;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.835 -0400", hash_original_method = "2601C4AB5843D67812F736A8664254C1", hash_generated_method = "352A1F1A9468A3689C2D72A9049B6886")
    public void parseHeader(CharArrayBuffer buffer) {
        int pos = CharArrayBuffers.setLowercaseIndexOf(buffer, ':');
        String name = buffer.substringTrimmed(0, pos);
        {
            boolean var162A1A174B912EA806BA20275BF238E6_774324466 = (name.length() == 0);
        } 
        String val = buffer.substringTrimmed(pos, buffer.length());
        {
            HttpLog.v("hdr " + buffer.length() + " " + buffer);
        } 
        {
            Object varD5CE5E51886CB990D3E836A2F031F3B0_129429344 = (name.hashCode());
            
            {
                boolean var7B54C8F384C00CCC2D9E2DD19E269C8C_328915146 = (name.equals(TRANSFER_ENCODING));
                {
                    mHeaders[IDX_TRANSFER_ENCODING] = val;
                    HeaderElement[] encodings = BasicHeaderValueParser.DEFAULT
                        .parseElements(buffer, new ParserCursor(pos,
                                buffer.length()));
                    int len = encodings.length;
                    {
                        boolean var68C5892BBE06DBB503602F92C86B60E5_639324514 = (HTTP.IDENTITY_CODING.equalsIgnoreCase(val));
                        {
                            transferEncoding = ContentLengthStrategy.IDENTITY;
                        } 
                        {
                            boolean varAD6F03450544B8A04DF43EF0CB2A1703_2108671479 = ((len > 0)
                        && (HTTP.CHUNK_CODING
                                .equalsIgnoreCase(encodings[len - 1].getName())));
                            {
                                transferEncoding = ContentLengthStrategy.CHUNKED;
                            } 
                            {
                                transferEncoding = ContentLengthStrategy.IDENTITY;
                            } 
                        } 
                    } 
                } 
            } 
            
            
            {
                boolean var18348926E9101CCB629C034EED46C4CB_531044317 = (name.equals(CONTENT_LEN));
                {
                    mHeaders[IDX_CONTENT_LEN] = val;
                    try 
                    {
                        contentLength = Long.parseLong(val);
                    } 
                    catch (NumberFormatException e)
                    { }
                } 
            } 
            
            
            {
                boolean varC01F98D6C1790EC66A7769901CC9D809_1706713007 = (name.equals(CONTENT_TYPE));
                {
                    mHeaders[IDX_CONTENT_TYPE] = val;
                } 
            } 
            
            
            {
                boolean var5E5F6438CD092B168AAEBE25B8F7BB52_1694076878 = (name.equals(CONTENT_ENCODING));
                {
                    mHeaders[IDX_CONTENT_ENCODING] = val;
                } 
            } 
            
            
            {
                boolean var7A7E6C3E8726D6115E4F34285EB1E137_167944382 = (name.equals(CONN_DIRECTIVE));
                {
                    mHeaders[IDX_CONN_DIRECTIVE] = val;
                    setConnectionType(buffer, pos);
                } 
            } 
            
            
            {
                boolean varFA51CCC753CEF9E5173C29BE531D1272_819774695 = (name.equals(LOCATION));
                {
                    mHeaders[IDX_LOCATION] = val;
                } 
            } 
            
            
            {
                boolean var9DB86CF8694E1F6C31F3801051E035C2_791301511 = (name.equals(PROXY_CONNECTION));
                {
                    mHeaders[IDX_PROXY_CONNECTION] = val;
                    setConnectionType(buffer, pos);
                } 
            } 
            
            
            {
                boolean varDFE2C07C26EDE1ADE7EBA6270E49931D_536611703 = (name.equals(WWW_AUTHENTICATE));
                {
                    mHeaders[IDX_WWW_AUTHENTICATE] = val;
                } 
            } 
            
            
            {
                boolean var48D7193659B5612617AE289242213B39_508008903 = (name.equals(PROXY_AUTHENTICATE));
                {
                    mHeaders[IDX_PROXY_AUTHENTICATE] = val;
                } 
            } 
            
            
            {
                boolean var1F3158CAF77BB123FBC69291627CD604_1207934023 = (name.equals(CONTENT_DISPOSITION));
                {
                    mHeaders[IDX_CONTENT_DISPOSITION] = val;
                } 
            } 
            
            
            {
                boolean varE6220C0D44AC55608E493A184A4CFA67_1353176670 = (name.equals(ACCEPT_RANGES));
                {
                    mHeaders[IDX_ACCEPT_RANGES] = val;
                } 
            } 
            
            
            {
                boolean varAC41375E8DF79B2C665DEB3A150610E3_2036239985 = (name.equals(EXPIRES));
                {
                    mHeaders[IDX_EXPIRES] = val;
                } 
            } 
            
            
            {
                boolean varB2DF48D1D5C2D6CBDEA54D19FA792A43_715845134 = (name.equals(CACHE_CONTROL));
                {
                    {
                        boolean varB92945A8CCA4959ECEB90265B45FC92E_993469341 = (mHeaders[IDX_CACHE_CONTROL] != null &&
                    mHeaders[IDX_CACHE_CONTROL].length() > 0);
                        {
                            mHeaders[IDX_CACHE_CONTROL] += (',' + val);
                        } 
                        {
                            mHeaders[IDX_CACHE_CONTROL] = val;
                        } 
                    } 
                } 
            } 
            
            
            {
                boolean var8B1FC06FEB8C0848F1DC31BCC2A17465_313833277 = (name.equals(LAST_MODIFIED));
                {
                    mHeaders[IDX_LAST_MODIFIED] = val;
                } 
            } 
            
            
            {
                boolean varFA835B8351F1FE6D77BE4CF0BB1E41A5_745888598 = (name.equals(ETAG));
                {
                    mHeaders[IDX_ETAG] = val;
                } 
            } 
            
            
            {
                boolean var86BE53AF69B78EC6486FB922C7BA0B5E_1366586110 = (name.equals(SET_COOKIE));
                {
                    mHeaders[IDX_SET_COOKIE] = val;
                    cookies.add(val);
                } 
            } 
            
            
            {
                boolean var68267221AB9433567AE0493C282A1BAA_1491026782 = (name.equals(PRAGMA));
                {
                    mHeaders[IDX_PRAGMA] = val;
                } 
            } 
            
            
            {
                boolean var9D64B646E30BE6948B4EB435C06BDDBD_57754133 = (name.equals(REFRESH));
                {
                    mHeaders[IDX_REFRESH] = val;
                } 
            } 
            
            
            {
                boolean varBA8E759A71FDF489DB2F1A5427B1F174_1061654305 = (name.equals(X_PERMITTED_CROSS_DOMAIN_POLICIES));
                {
                    mHeaders[IDX_X_PERMITTED_CROSS_DOMAIN_POLICIES] = val;
                } 
            } 
            
            
            mExtraHeaderNames.add(name);
            
            
            mExtraHeaderValues.add(val);
            
        } 
        addTaint(buffer.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.835 -0400", hash_original_method = "839965513DF286AFAE2E56076E19ADBF", hash_generated_method = "C75AAC8523178C552CEDF102803D20EC")
    public long getTransferEncoding() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1511909331 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1511909331;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.836 -0400", hash_original_method = "043A311B0C55CC2C0E7ED635C15C25FD", hash_generated_method = "4080D7EB8A0059E73386F7A3BD42F972")
    public long getContentLength() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1795875094 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1795875094;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.836 -0400", hash_original_method = "16A8DC2EF1F4EBF751AEB83B8F69222E", hash_generated_method = "138088A20F02C6BF1A1BE4B611FCF71E")
    public int getConnectionType() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1592397590 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1592397590;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.836 -0400", hash_original_method = "0358D0D4AEFF84195277AB782B3FFDE2", hash_generated_method = "A3747CD4326300F1476F9B4E2109DEC8")
    public String getContentType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1541920106 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1541920106 = mHeaders[IDX_CONTENT_TYPE];
        varB4EAC82CA7396A68D541C85D26508E83_1541920106.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1541920106;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.837 -0400", hash_original_method = "DC3B5CC0DA80597E20563D04CDFF5783", hash_generated_method = "DCD4DA23B2829602107392AECF249CA4")
    public String getContentEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1280128603 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1280128603 = mHeaders[IDX_CONTENT_ENCODING];
        varB4EAC82CA7396A68D541C85D26508E83_1280128603.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1280128603;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.837 -0400", hash_original_method = "3BEB5C295081F99F7A9897994B243966", hash_generated_method = "7955D9BAAA69D52CAA2C3C60BF3AC03B")
    public String getLocation() {
        String varB4EAC82CA7396A68D541C85D26508E83_767420029 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_767420029 = mHeaders[IDX_LOCATION];
        varB4EAC82CA7396A68D541C85D26508E83_767420029.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_767420029;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.838 -0400", hash_original_method = "2ABA1BEE8C50AB0C1324E3514B439A3C", hash_generated_method = "99D12E34A22943950B7F31680003A873")
    public String getWwwAuthenticate() {
        String varB4EAC82CA7396A68D541C85D26508E83_1365779221 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1365779221 = mHeaders[IDX_WWW_AUTHENTICATE];
        varB4EAC82CA7396A68D541C85D26508E83_1365779221.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1365779221;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.838 -0400", hash_original_method = "2251D004613BB9CDF5BB072ECCA1B196", hash_generated_method = "4FDAA4A1E4049979EF3AED0202429E37")
    public String getProxyAuthenticate() {
        String varB4EAC82CA7396A68D541C85D26508E83_268347534 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_268347534 = mHeaders[IDX_PROXY_AUTHENTICATE];
        varB4EAC82CA7396A68D541C85D26508E83_268347534.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_268347534;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.838 -0400", hash_original_method = "B3734B1B2E8291E968F6C56DD5A68AFD", hash_generated_method = "EE7FD5DB31021F64D51CBAA603B20943")
    public String getContentDisposition() {
        String varB4EAC82CA7396A68D541C85D26508E83_118687074 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_118687074 = mHeaders[IDX_CONTENT_DISPOSITION];
        varB4EAC82CA7396A68D541C85D26508E83_118687074.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_118687074;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.839 -0400", hash_original_method = "56F3083ED56642A8109311F7B75978CE", hash_generated_method = "F3402A7CBE3D15BEFC1B8CC1ED2ED288")
    public String getAcceptRanges() {
        String varB4EAC82CA7396A68D541C85D26508E83_1261769231 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1261769231 = mHeaders[IDX_ACCEPT_RANGES];
        varB4EAC82CA7396A68D541C85D26508E83_1261769231.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1261769231;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.839 -0400", hash_original_method = "AD48730753A27EE5F83CD5FBE4AD4C5B", hash_generated_method = "B9D98474845EDF9A02C628F4950E4A00")
    public String getExpires() {
        String varB4EAC82CA7396A68D541C85D26508E83_1948882408 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1948882408 = mHeaders[IDX_EXPIRES];
        varB4EAC82CA7396A68D541C85D26508E83_1948882408.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1948882408;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.840 -0400", hash_original_method = "FAE5B14F1D1AF7F7C5B34799287CB96B", hash_generated_method = "532E5777CDEDB4BBB89BA08BD0B93316")
    public String getCacheControl() {
        String varB4EAC82CA7396A68D541C85D26508E83_991786796 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_991786796 = mHeaders[IDX_CACHE_CONTROL];
        varB4EAC82CA7396A68D541C85D26508E83_991786796.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_991786796;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.840 -0400", hash_original_method = "5FC9B5DD06D10DB2F99A11CF11E84611", hash_generated_method = "F43900E15DCC55CFD96A5888C93C3465")
    public String getLastModified() {
        String varB4EAC82CA7396A68D541C85D26508E83_584811519 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_584811519 = mHeaders[IDX_LAST_MODIFIED];
        varB4EAC82CA7396A68D541C85D26508E83_584811519.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_584811519;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.841 -0400", hash_original_method = "2356D85AA5974933778FA07340E360AB", hash_generated_method = "C3C343F5366017ECF2E35F93C8363E25")
    public String getEtag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1433539511 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1433539511 = mHeaders[IDX_ETAG];
        varB4EAC82CA7396A68D541C85D26508E83_1433539511.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1433539511;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.841 -0400", hash_original_method = "30BF89B95A4B495DCD1A87F8054AFEC5", hash_generated_method = "DB3A415CADB89DE77C16746F03565EA4")
    public ArrayList<String> getSetCookie() {
        ArrayList<String> varB4EAC82CA7396A68D541C85D26508E83_1332526122 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1332526122 = this.cookies;
        varB4EAC82CA7396A68D541C85D26508E83_1332526122.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1332526122;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.841 -0400", hash_original_method = "A30AE7605FF81FB95FDA5AAF057C022D", hash_generated_method = "7F283B0CEEE2435F0BB9201DBBC788A0")
    public String getPragma() {
        String varB4EAC82CA7396A68D541C85D26508E83_1091544272 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1091544272 = mHeaders[IDX_PRAGMA];
        varB4EAC82CA7396A68D541C85D26508E83_1091544272.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1091544272;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.842 -0400", hash_original_method = "847E30EC42ECB16F3B862D5A0C1778F0", hash_generated_method = "38F14BD8794851A57E8A794D532B5D31")
    public String getRefresh() {
        String varB4EAC82CA7396A68D541C85D26508E83_1944361180 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1944361180 = mHeaders[IDX_REFRESH];
        varB4EAC82CA7396A68D541C85D26508E83_1944361180.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1944361180;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.842 -0400", hash_original_method = "120DF6C7E530068F21D41A0CCD884530", hash_generated_method = "6938BF772E481B8C7755FC46F38DDA70")
    public String getXPermittedCrossDomainPolicies() {
        String varB4EAC82CA7396A68D541C85D26508E83_1033622695 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1033622695 = mHeaders[IDX_X_PERMITTED_CROSS_DOMAIN_POLICIES];
        varB4EAC82CA7396A68D541C85D26508E83_1033622695.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1033622695;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.843 -0400", hash_original_method = "655405705FFA26A24CEE799E196F64CA", hash_generated_method = "70CE888A9FFED207F0803974796E927C")
    public void setContentLength(long value) {
        this.contentLength = value;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.843 -0400", hash_original_method = "DBD4B3393EC7C86D318F09AACB690C16", hash_generated_method = "A9ED9CE54B818219D22AD6B7B9BAB2F8")
    public void setContentType(String value) {
        mHeaders[IDX_CONTENT_TYPE] = value;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.843 -0400", hash_original_method = "795639D1D1B96C335181D978646FFEAC", hash_generated_method = "77D9B1C07F0FB32A9761C4B3F088F7CB")
    public void setContentEncoding(String value) {
        mHeaders[IDX_CONTENT_ENCODING] = value;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.843 -0400", hash_original_method = "91ACBD0DA1F8B6B752177E887C1E560A", hash_generated_method = "FA0850D4F4C77DC48C8661B4E06FCDA6")
    public void setLocation(String value) {
        mHeaders[IDX_LOCATION] = value;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.844 -0400", hash_original_method = "78E4D283A358D7F9AC830EDA5944CEC1", hash_generated_method = "4AAFA72378B619A1D7E762612FFED29E")
    public void setWwwAuthenticate(String value) {
        mHeaders[IDX_WWW_AUTHENTICATE] = value;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.844 -0400", hash_original_method = "EB3C03E25C95805816417AB68A1F4E73", hash_generated_method = "FBAD98CF9FAB5BEE89E177BB5EA0711D")
    public void setProxyAuthenticate(String value) {
        mHeaders[IDX_PROXY_AUTHENTICATE] = value;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.844 -0400", hash_original_method = "CAF824941A606D9472E6B7F4D5AE8EAB", hash_generated_method = "6DBDC101C7D94B0D6851269BE8387BAB")
    public void setContentDisposition(String value) {
        mHeaders[IDX_CONTENT_DISPOSITION] = value;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.844 -0400", hash_original_method = "42F6F595EF9293A515A4DDDF580E03E6", hash_generated_method = "5F85D3501DB5288A00CF9DDAB3832102")
    public void setAcceptRanges(String value) {
        mHeaders[IDX_ACCEPT_RANGES] = value;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.845 -0400", hash_original_method = "7D2DC3B419C5BDAB21BBD8535AC32115", hash_generated_method = "76EA542A919CE34FD4D665398C623FD5")
    public void setExpires(String value) {
        mHeaders[IDX_EXPIRES] = value;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.845 -0400", hash_original_method = "461838AAEBDAFBB838DA60C8789FC643", hash_generated_method = "EEFBEAB5A98EC1741302CE7707E5564D")
    public void setCacheControl(String value) {
        mHeaders[IDX_CACHE_CONTROL] = value;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.845 -0400", hash_original_method = "E44516D40CA535A9E78D483DC766FE77", hash_generated_method = "88933EBF372CD7EBEFB5BE34D231304F")
    public void setLastModified(String value) {
        mHeaders[IDX_LAST_MODIFIED] = value;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.846 -0400", hash_original_method = "7E96E0634D296A60D862609FEA944EA2", hash_generated_method = "B4F381619A4DF76AF492305D6EACCE95")
    public void setEtag(String value) {
        mHeaders[IDX_ETAG] = value;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.846 -0400", hash_original_method = "860A5481555AE910297114E1D7478814", hash_generated_method = "F2E6E48B412C72FEA2876958E6643E79")
    public void setXPermittedCrossDomainPolicies(String value) {
        mHeaders[IDX_X_PERMITTED_CROSS_DOMAIN_POLICIES] = value;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.846 -0400", hash_original_method = "C9CAD2CB40E843B6A6F48005E0DE2B60", hash_generated_method = "A3E3AE7477320D8DA5BACEBA540B82E7")
    public void getHeaders(HeaderCallback hcb) {
        {
            int i = 0;
            {
                String h = mHeaders[i];
                {
                    hcb.header(sHeaderNames[i], h);
                } 
            } 
        } 
        int extraLen = mExtraHeaderNames.size();
        {
            int i = 0;
            {
                {
                    HttpLog.v("Headers.getHeaders() extra: " + i + " " +
                          mExtraHeaderNames.get(i) + " " + mExtraHeaderValues.get(i));
                } 
                hcb.header(mExtraHeaderNames.get(i),
                       mExtraHeaderValues.get(i));
            } 
        } 
        addTaint(hcb.getTaint());
        
        
            
            
                
            
        
        
        
            
                
                          
            
            
                       
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.847 -0400", hash_original_method = "D8DC07475CD7B5300779AA7E8CC52DE7", hash_generated_method = "5191F8A2B2C77019EE94AD9A5CC1C32A")
    private void setConnectionType(CharArrayBuffer buffer, int pos) {
        {
            boolean varA7F18A145505BA8F70BFD34F9C06069F_353235965 = (CharArrayBuffers.containsIgnoreCaseTrimmed(
                buffer, pos, HTTP.CONN_CLOSE));
            {
                connectionType = CONN_CLOSE;
            } 
            {
                boolean varFA43AAAB4BAA63E0806E72853F50D31D_248329356 = (CharArrayBuffers.containsIgnoreCaseTrimmed(
                buffer, pos, HTTP.CONN_KEEP_ALIVE));
                {
                    connectionType = CONN_KEEP_ALIVE;
                } 
            } 
        } 
        addTaint(buffer.getTaint());
        addTaint(pos);
        
        
                
            
        
                
            
        
    }

    
    public interface HeaderCallback {
        public void header(String name, String value);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.847 -0400", hash_original_field = "612150595DFE4003266A71271894AF14", hash_generated_field = "26F6F5D2EF35FA86B8698978CE2FD0C9")

    private static final String LOGTAG = "Http";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.847 -0400", hash_original_field = "407E5F680BD04BACCEB817A103A50F00", hash_generated_field = "790FEF378F4A1A682AF4B41C9D24056F")

    public final static int CONN_CLOSE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.847 -0400", hash_original_field = "AEA735DA8BC832151ED189F82C31380B", hash_generated_field = "759A5671D76D24A450C80BB03C36839E")

    public final static int CONN_KEEP_ALIVE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.847 -0400", hash_original_field = "AFDBF9109F5A97B7016A1F87CA2E9846", hash_generated_field = "C649382C9AB58722060DB5AB1682F97D")

    public final static int NO_CONN_TYPE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.847 -0400", hash_original_field = "06952937F57CD8F7F43890043A86569F", hash_generated_field = "2FEECAE3BB793FDC0977A48B3934C1D7")

    public final static long NO_TRANSFER_ENCODING = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.847 -0400", hash_original_field = "5CEE9DB3A27E759D7AD398670A1CE790", hash_generated_field = "72BAC6DB337B3CBFE2C5510E69BA9F9E")

    public final static long NO_CONTENT_LENGTH = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.847 -0400", hash_original_field = "8DEB0311F0771D7522F79D89A21FE9B4", hash_generated_field = "81C0E7C8A5CDB2B0264004F8265CD667")

    public final static String TRANSFER_ENCODING = "transfer-encoding";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.847 -0400", hash_original_field = "F79EA97808642189968D19702A213671", hash_generated_field = "BBF93059A8ED698C0E55DF623F564D01")

    public final static String CONTENT_LEN = "content-length";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.847 -0400", hash_original_field = "3A558F5CAC0A7C913876ED4BEB31EAFC", hash_generated_field = "2216C6197D13B1CBCAB1FA436EA38B66")

    public final static String CONTENT_TYPE = "content-type";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.847 -0400", hash_original_field = "E960502D2AEEE0B4E0D2CF7652723A27", hash_generated_field = "AC7AEC23F2048D9EE3693A58E4F60F88")

    public final static String CONTENT_ENCODING = "content-encoding";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.847 -0400", hash_original_field = "E069D9D71F7EA60B8007325A29248070", hash_generated_field = "6192728184263C4E2E5B9E3FD278B74C")

    public final static String CONN_DIRECTIVE = "connection";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.847 -0400", hash_original_field = "AC3E5DB01896625C1947D64A70E083AC", hash_generated_field = "077B87B3238F3F1EF051B3253D47554A")

    public final static String LOCATION = "location";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.847 -0400", hash_original_field = "EF27CB722D0DB21D221A1917469E487D", hash_generated_field = "6B767E1F6F824B91FB0417CE6C9A3AF6")

    public final static String PROXY_CONNECTION = "proxy-connection";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.847 -0400", hash_original_field = "1B148D03B85D8CE7FE00DB85C486A904", hash_generated_field = "2D2256243B60098BAF60048C051D5E97")

    public final static String WWW_AUTHENTICATE = "www-authenticate";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.847 -0400", hash_original_field = "9413542422C0321085C75B8F2F1DEE10", hash_generated_field = "8E642334C5E492A104D3B96159F6D444")

    public final static String PROXY_AUTHENTICATE = "proxy-authenticate";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.847 -0400", hash_original_field = "9FBB81C1524477CB4404ACE5734E25B8", hash_generated_field = "77979705F62BBE313F3A54727E5E587F")

    public final static String CONTENT_DISPOSITION = "content-disposition";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.847 -0400", hash_original_field = "EB4B1B63CA3D3B3640F6BC82505CB7F7", hash_generated_field = "4F1D8FC17C7B449521008CC2D5D5ED06")

    public final static String ACCEPT_RANGES = "accept-ranges";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "899162B90BDD687F90078C4CDC23D4AA", hash_generated_field = "801AFDC8DD450D337B40F6B07B2264AB")

    public final static String EXPIRES = "expires";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "995039850F6933531ADBF085144D875B", hash_generated_field = "450B3E04B5010DB41F35CA8B949FED30")

    public final static String CACHE_CONTROL = "cache-control";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "3CAC844485C9DD5182F7F1556C4AA670", hash_generated_field = "F6800EEE3C9C1A70EB3C6720414DA669")

    public final static String LAST_MODIFIED = "last-modified";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "6A21E681F37FC63154C540A8DA9B79E2", hash_generated_field = "88106202FCB92FEEAF5138D6C6806089")

    public final static String ETAG = "etag";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "183FE31C48369038CD715D85AB864C12", hash_generated_field = "A7FDB9E1F185D0CC04AEFA5AC7F01D3F")

    public final static String SET_COOKIE = "set-cookie";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "22A260DE0D42B99893815DC8FEC81C94", hash_generated_field = "D6513DD9C72F81B9F9DC8D34DCFDB1E7")

    public final static String PRAGMA = "pragma";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "FDEC2DDED8A4771AEC1D10E2C4B907F1", hash_generated_field = "3265C52EE1FA28461C3C83C045036136")

    public final static String REFRESH = "refresh";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "1A2BA4D108EFCE51C6D5B0B466E17EBF", hash_generated_field = "589DB52C07CE6D4B43E09172999F3F5B")

    public final static String X_PERMITTED_CROSS_DOMAIN_POLICIES = "x-permitted-cross-domain-policies";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "7DCB1E6E2419AE8BB6354AE32469CD1F", hash_generated_field = "E51E16F4FF72FD9B60ABEA316B8E6844")

    private final static int HASH_TRANSFER_ENCODING = 1274458357;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "F6AE93C62A9C4B1C446A9C376B0E9163", hash_generated_field = "F5FC2613E3682B4D30CB8F24594897C4")

    private final static int HASH_CONTENT_LEN = -1132779846;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "CE3FA19000F98F6961CB547308644806", hash_generated_field = "2EB57F7DCB54A1F1F5E38F0E0B773D84")

    private final static int HASH_CONTENT_TYPE = 785670158;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "C4E8C552997FADBF3ECEE84D6AD484BC", hash_generated_field = "10EE589BA2B105C140483634F384D4F1")

    private final static int HASH_CONTENT_ENCODING = 2095084583;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "12EF68F4DCD0171AE874356453CD2A94", hash_generated_field = "5F7325D24DBA2A1B8D67785D7C472600")

    private final static int HASH_CONN_DIRECTIVE = -775651618;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "066291ADE0198A023FD5EC6848430241", hash_generated_field = "E76AC333D9C173505D096F550CDC6F3F")

    private final static int HASH_LOCATION = 1901043637;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "F1E815604E3F947BC9B72101D1EDA7BB", hash_generated_field = "A32A3662A238F5A1AEFE7F75FA20BF09")

    private final static int HASH_PROXY_CONNECTION = 285929373;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "0F517DCECEA0C8AE9647445A793F3987", hash_generated_field = "3C987A8C74D00860013829B971A62ADE")

    private final static int HASH_WWW_AUTHENTICATE = -243037365;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "ED06A9BFF04FECE4950DFDEE5EE05AF1", hash_generated_field = "39B9CF5AFF4E85B3FB6C5386F84E577C")

    private final static int HASH_PROXY_AUTHENTICATE = -301767724;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "173E3BE9FAADF30845277AFB76CEEFB3", hash_generated_field = "60255A27DD37AF204BCBD75849E718A0")

    private final static int HASH_CONTENT_DISPOSITION = -1267267485;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "8FF5693B66F696F6A1F2B1F33A4DEA52", hash_generated_field = "8A32E37D07F6A32183177C86830D94FA")

    private final static int HASH_ACCEPT_RANGES = 1397189435;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "F6F1A192B0ADD1AC6EE258779D3787A0", hash_generated_field = "31BDF9B854D8ABD34017DFF737725819")

    private final static int HASH_EXPIRES = -1309235404;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "D6CB01DA7CF812A3B6A997EA09D61439", hash_generated_field = "A85CE708DEA5EFD2FB8BB109D6D0F3A4")

    private final static int HASH_CACHE_CONTROL = -208775662;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "461388A74CBC8602EEC3AD4B6E6BB52E", hash_generated_field = "2CD1F0F8BA900D39E844CE159B9E6448")

    private final static int HASH_LAST_MODIFIED = 150043680;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "3BFBA6538863A5E450CC20B064E9D3CA", hash_generated_field = "D0C9F7793ED99283D48E66BC52020A9E")

    private final static int HASH_ETAG = 3123477;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "10860C69BEBEE45F29490E3AA41152D5", hash_generated_field = "B917EBF6C3762CC1FE11961B1D17BA92")

    private final static int HASH_SET_COOKIE = 1237214767;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "3577DD8B81ACAD928BE112A59D0AF344", hash_generated_field = "98D663F2063865F4E92610AB48B9DCB2")

    private final static int HASH_PRAGMA = -980228804;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "4D3A0B7EC348FF1B2216015904A0A246", hash_generated_field = "8613521BF28512C3BE1153253E6BB597")

    private final static int HASH_REFRESH = 1085444827;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "8F019FCD8B7537C9357B0736043BB896", hash_generated_field = "9B9326E4B74B05E67C82C6AC78AE288D")

    private final static int HASH_X_PERMITTED_CROSS_DOMAIN_POLICIES = -1345594014;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "5DC62DF0C607BF8770D9D95A9669A08B", hash_generated_field = "73EAC9AA21355E40798F02139655C5A2")

    private final static int IDX_TRANSFER_ENCODING = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "EBA2F308DA19F0AE1299FEA3E9D475DD", hash_generated_field = "E6C21E4C7442EABC526E43342529ECBA")

    private final static int IDX_CONTENT_LEN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "B22051A9603BF3F6248FC62174D5028D", hash_generated_field = "F17D959A03C864A3D9E9C85EBE639D3A")

    private final static int IDX_CONTENT_TYPE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "3BAC7725457934B469099E50BCB1680A", hash_generated_field = "81924568DEED109B60E51488E4E4D2D4")

    private final static int IDX_CONTENT_ENCODING = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "2FD60D3A896321F0522A9CA27C68E8BA", hash_generated_field = "45CEAC5BEA88F3D103A34151707BCB5A")

    private final static int IDX_CONN_DIRECTIVE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "BEAF16303B80BEE827DD7BC0E9B94D15", hash_generated_field = "DAC5FEF48DD7C7DEFDB2EC3117246238")

    private final static int IDX_LOCATION = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "8E26C8DF9181BFA2B29149C63FEF68BC", hash_generated_field = "DA0E1FF2661CBA411A805657AD8983AD")

    private final static int IDX_PROXY_CONNECTION = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "74EF79A98544A41388966EDCD0014263", hash_generated_field = "BC104A1300C317C8DAE09161D68B7C76")

    private final static int IDX_WWW_AUTHENTICATE = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.848 -0400", hash_original_field = "7CE1AD0D75649A86FC46477FFA0F8D62", hash_generated_field = "83E881AD61875794DE6BD1EFA4BBE2DA")

    private final static int IDX_PROXY_AUTHENTICATE = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.849 -0400", hash_original_field = "8067B6920D348FF78943CBB1E8986ABD", hash_generated_field = "70C052905F33EAB389A11D557D076555")

    private final static int IDX_CONTENT_DISPOSITION = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.849 -0400", hash_original_field = "15A667D02E4D22D9F1A2C8F8D47DE2F8", hash_generated_field = "27766383D0D77C40D8B42F938D2C0C9F")

    private final static int IDX_ACCEPT_RANGES = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.849 -0400", hash_original_field = "2239F69C37846C8CA137B37B1FAA5E74", hash_generated_field = "D77A6684E8819F46E09969079559D5B7")

    private final static int IDX_EXPIRES = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.849 -0400", hash_original_field = "7FC67061ACDBE2D6B74D34C2A94596A7", hash_generated_field = "208E75CAF22A97D5A5E0232968B5F2E4")

    private final static int IDX_CACHE_CONTROL = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.849 -0400", hash_original_field = "0E84955E44F8C16470103D1D87936A80", hash_generated_field = "762CA1BA4BAD411E079325B2EDAC957D")

    private final static int IDX_LAST_MODIFIED = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.849 -0400", hash_original_field = "9C097AA1DAD7FEFE6E9EC1C94A0DFC50", hash_generated_field = "68DABB6487881B218EDDBC8C79608FC1")

    private final static int IDX_ETAG = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.849 -0400", hash_original_field = "79B3D5DCFD65ABEFE489ACE52AE20AC2", hash_generated_field = "B35684FB62BE0B535A372DBEE609ABE3")

    private final static int IDX_SET_COOKIE = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.849 -0400", hash_original_field = "1B246BDA80341FA31A6A704F0475652E", hash_generated_field = "46633A8E677F58AEFC32AB0BBD6EB035")

    private final static int IDX_PRAGMA = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.849 -0400", hash_original_field = "39E4FBE534CCB95945B78E9221D44677", hash_generated_field = "BEF97DDEA89012BFE6995EE975B0F93B")

    private final static int IDX_REFRESH = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.849 -0400", hash_original_field = "7153FB040BE584719153829EC7123080", hash_generated_field = "95DE7AD1FEC1D3A3BFBE6B5D8ECCDCB1")

    private final static int IDX_X_PERMITTED_CROSS_DOMAIN_POLICIES = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.849 -0400", hash_original_field = "910C9F4D2F4555FCDC34B7D607B41581", hash_generated_field = "0B2442CA0B92E2CCC52F7846B6D391D9")

    private final static int HEADER_COUNT = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.849 -0400", hash_original_field = "C23E4839C27DCAEECF0DD9B376F20AC7", hash_generated_field = "22ED680D75DAA14488B618AAD5F441A4")

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

