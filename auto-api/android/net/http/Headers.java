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
    private long transferEncoding;
    private long contentLength;
    private int connectionType;
    private ArrayList<String> cookies = new ArrayList<String>(2);
    private String[] mHeaders = new String[HEADER_COUNT];
    private ArrayList<String> mExtraHeaderNames = new ArrayList<String>(4);
    private ArrayList<String> mExtraHeaderValues = new ArrayList<String>(4);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.788 -0400", hash_original_method = "4806F09499B83A0F8F6BA6D2EDAE6CDA", hash_generated_method = "8727A8D60C0E27C0BFDFF3C48804DA1B")
    @DSModeled(DSC.SAFE)
    public Headers() {
        transferEncoding = NO_TRANSFER_ENCODING;
        contentLength = NO_CONTENT_LENGTH;
        connectionType = NO_CONN_TYPE;
        // ---------- Original Method ----------
        //transferEncoding = NO_TRANSFER_ENCODING;
        //contentLength = NO_CONTENT_LENGTH;
        //connectionType = NO_CONN_TYPE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.790 -0400", hash_original_method = "2601C4AB5843D67812F736A8664254C1", hash_generated_method = "4D0E24624B3B88420CAB1D4D69A16A6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void parseHeader(CharArrayBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        int pos;
        pos = CharArrayBuffers.setLowercaseIndexOf(buffer, ':');
        String name;
        name = buffer.substringTrimmed(0, pos);
        {
            boolean var162A1A174B912EA806BA20275BF238E6_915337901 = (name.length() == 0);
        } //End collapsed parenthetic
        String val;
        val = buffer.substringTrimmed(pos, buffer.length());
        {
            HttpLog.v("hdr " + buffer.length() + " " + buffer);
        } //End block
        {
            Object varD5CE5E51886CB990D3E836A2F031F3B0_1984098076 = (name.hashCode());
            //Begin case HASH_TRANSFER_ENCODING 
            {
                boolean var7B54C8F384C00CCC2D9E2DD19E269C8C_1483606381 = (name.equals(TRANSFER_ENCODING));
                {
                    mHeaders[IDX_TRANSFER_ENCODING] = val;
                    HeaderElement[] encodings;
                    encodings = BasicHeaderValueParser.DEFAULT
                        .parseElements(buffer, new ParserCursor(pos,
                                buffer.length()));
                    int len;
                    len = encodings.length;
                    {
                        boolean var68C5892BBE06DBB503602F92C86B60E5_1816030053 = (HTTP.IDENTITY_CODING.equalsIgnoreCase(val));
                        {
                            transferEncoding = ContentLengthStrategy.IDENTITY;
                        } //End block
                        {
                            boolean varAD6F03450544B8A04DF43EF0CB2A1703_1929105713 = ((len > 0)
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
                boolean var18348926E9101CCB629C034EED46C4CB_231680837 = (name.equals(CONTENT_LEN));
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
                boolean varC01F98D6C1790EC66A7769901CC9D809_1419120117 = (name.equals(CONTENT_TYPE));
                {
                    mHeaders[IDX_CONTENT_TYPE] = val;
                } //End block
            } //End collapsed parenthetic
            //End case HASH_CONTENT_TYPE 
            //Begin case HASH_CONTENT_ENCODING 
            {
                boolean var5E5F6438CD092B168AAEBE25B8F7BB52_595360086 = (name.equals(CONTENT_ENCODING));
                {
                    mHeaders[IDX_CONTENT_ENCODING] = val;
                } //End block
            } //End collapsed parenthetic
            //End case HASH_CONTENT_ENCODING 
            //Begin case HASH_CONN_DIRECTIVE 
            {
                boolean var7A7E6C3E8726D6115E4F34285EB1E137_1296566392 = (name.equals(CONN_DIRECTIVE));
                {
                    mHeaders[IDX_CONN_DIRECTIVE] = val;
                    setConnectionType(buffer, pos);
                } //End block
            } //End collapsed parenthetic
            //End case HASH_CONN_DIRECTIVE 
            //Begin case HASH_LOCATION 
            {
                boolean varFA51CCC753CEF9E5173C29BE531D1272_1776447767 = (name.equals(LOCATION));
                {
                    mHeaders[IDX_LOCATION] = val;
                } //End block
            } //End collapsed parenthetic
            //End case HASH_LOCATION 
            //Begin case HASH_PROXY_CONNECTION 
            {
                boolean var9DB86CF8694E1F6C31F3801051E035C2_570368417 = (name.equals(PROXY_CONNECTION));
                {
                    mHeaders[IDX_PROXY_CONNECTION] = val;
                    setConnectionType(buffer, pos);
                } //End block
            } //End collapsed parenthetic
            //End case HASH_PROXY_CONNECTION 
            //Begin case HASH_WWW_AUTHENTICATE 
            {
                boolean varDFE2C07C26EDE1ADE7EBA6270E49931D_1331272258 = (name.equals(WWW_AUTHENTICATE));
                {
                    mHeaders[IDX_WWW_AUTHENTICATE] = val;
                } //End block
            } //End collapsed parenthetic
            //End case HASH_WWW_AUTHENTICATE 
            //Begin case HASH_PROXY_AUTHENTICATE 
            {
                boolean var48D7193659B5612617AE289242213B39_440032754 = (name.equals(PROXY_AUTHENTICATE));
                {
                    mHeaders[IDX_PROXY_AUTHENTICATE] = val;
                } //End block
            } //End collapsed parenthetic
            //End case HASH_PROXY_AUTHENTICATE 
            //Begin case HASH_CONTENT_DISPOSITION 
            {
                boolean var1F3158CAF77BB123FBC69291627CD604_1989172295 = (name.equals(CONTENT_DISPOSITION));
                {
                    mHeaders[IDX_CONTENT_DISPOSITION] = val;
                } //End block
            } //End collapsed parenthetic
            //End case HASH_CONTENT_DISPOSITION 
            //Begin case HASH_ACCEPT_RANGES 
            {
                boolean varE6220C0D44AC55608E493A184A4CFA67_1461079981 = (name.equals(ACCEPT_RANGES));
                {
                    mHeaders[IDX_ACCEPT_RANGES] = val;
                } //End block
            } //End collapsed parenthetic
            //End case HASH_ACCEPT_RANGES 
            //Begin case HASH_EXPIRES 
            {
                boolean varAC41375E8DF79B2C665DEB3A150610E3_1930400601 = (name.equals(EXPIRES));
                {
                    mHeaders[IDX_EXPIRES] = val;
                } //End block
            } //End collapsed parenthetic
            //End case HASH_EXPIRES 
            //Begin case HASH_CACHE_CONTROL 
            {
                boolean varB2DF48D1D5C2D6CBDEA54D19FA792A43_842074608 = (name.equals(CACHE_CONTROL));
                {
                    {
                        boolean varB92945A8CCA4959ECEB90265B45FC92E_1394807213 = (mHeaders[IDX_CACHE_CONTROL] != null &&
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
                boolean var8B1FC06FEB8C0848F1DC31BCC2A17465_2005980994 = (name.equals(LAST_MODIFIED));
                {
                    mHeaders[IDX_LAST_MODIFIED] = val;
                } //End block
            } //End collapsed parenthetic
            //End case HASH_LAST_MODIFIED 
            //Begin case HASH_ETAG 
            {
                boolean varFA835B8351F1FE6D77BE4CF0BB1E41A5_2071494758 = (name.equals(ETAG));
                {
                    mHeaders[IDX_ETAG] = val;
                } //End block
            } //End collapsed parenthetic
            //End case HASH_ETAG 
            //Begin case HASH_SET_COOKIE 
            {
                boolean var86BE53AF69B78EC6486FB922C7BA0B5E_2108144135 = (name.equals(SET_COOKIE));
                {
                    mHeaders[IDX_SET_COOKIE] = val;
                    cookies.add(val);
                } //End block
            } //End collapsed parenthetic
            //End case HASH_SET_COOKIE 
            //Begin case HASH_PRAGMA 
            {
                boolean var68267221AB9433567AE0493C282A1BAA_492684733 = (name.equals(PRAGMA));
                {
                    mHeaders[IDX_PRAGMA] = val;
                } //End block
            } //End collapsed parenthetic
            //End case HASH_PRAGMA 
            //Begin case HASH_REFRESH 
            {
                boolean var9D64B646E30BE6948B4EB435C06BDDBD_219726418 = (name.equals(REFRESH));
                {
                    mHeaders[IDX_REFRESH] = val;
                } //End block
            } //End collapsed parenthetic
            //End case HASH_REFRESH 
            //Begin case HASH_X_PERMITTED_CROSS_DOMAIN_POLICIES 
            {
                boolean varBA8E759A71FDF489DB2F1A5427B1F174_1156591318 = (name.equals(X_PERMITTED_CROSS_DOMAIN_POLICIES));
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.790 -0400", hash_original_method = "839965513DF286AFAE2E56076E19ADBF", hash_generated_method = "24D61F425E58060ABEBDFDD594BA5FDC")
    @DSModeled(DSC.SAFE)
    public long getTransferEncoding() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return transferEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.791 -0400", hash_original_method = "043A311B0C55CC2C0E7ED635C15C25FD", hash_generated_method = "84773E1BA86644DF0F2D0EF5D9EB2D08")
    @DSModeled(DSC.SAFE)
    public long getContentLength() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return contentLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.791 -0400", hash_original_method = "16A8DC2EF1F4EBF751AEB83B8F69222E", hash_generated_method = "AA90B29BA08C1D222C01C5DA67A6D0A2")
    @DSModeled(DSC.SAFE)
    public int getConnectionType() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return connectionType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.791 -0400", hash_original_method = "0358D0D4AEFF84195277AB782B3FFDE2", hash_generated_method = "B5F6B1650235A7CC3E36DEFE1FE4539F")
    @DSModeled(DSC.SAFE)
    public String getContentType() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mHeaders[IDX_CONTENT_TYPE];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.791 -0400", hash_original_method = "DC3B5CC0DA80597E20563D04CDFF5783", hash_generated_method = "6737D458A8230493B4C921914826B2EA")
    @DSModeled(DSC.SAFE)
    public String getContentEncoding() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mHeaders[IDX_CONTENT_ENCODING];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.791 -0400", hash_original_method = "3BEB5C295081F99F7A9897994B243966", hash_generated_method = "AF60B437DCE3C96394FABEF0FE119543")
    @DSModeled(DSC.SAFE)
    public String getLocation() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mHeaders[IDX_LOCATION];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.792 -0400", hash_original_method = "2ABA1BEE8C50AB0C1324E3514B439A3C", hash_generated_method = "0E3D41CC0284E178B76C9003A2AA2723")
    @DSModeled(DSC.SAFE)
    public String getWwwAuthenticate() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mHeaders[IDX_WWW_AUTHENTICATE];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.792 -0400", hash_original_method = "2251D004613BB9CDF5BB072ECCA1B196", hash_generated_method = "49A3696CC49308DB9DE98019CC85E47A")
    @DSModeled(DSC.SAFE)
    public String getProxyAuthenticate() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mHeaders[IDX_PROXY_AUTHENTICATE];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.792 -0400", hash_original_method = "B3734B1B2E8291E968F6C56DD5A68AFD", hash_generated_method = "02C70A0FE2FE39729AFA72CD3F544D86")
    @DSModeled(DSC.SAFE)
    public String getContentDisposition() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mHeaders[IDX_CONTENT_DISPOSITION];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.792 -0400", hash_original_method = "56F3083ED56642A8109311F7B75978CE", hash_generated_method = "DAFF8153946C127CB933DE8B0130FE79")
    @DSModeled(DSC.SAFE)
    public String getAcceptRanges() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mHeaders[IDX_ACCEPT_RANGES];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.792 -0400", hash_original_method = "AD48730753A27EE5F83CD5FBE4AD4C5B", hash_generated_method = "5DC36AC2C43EA6DDABE166A847098A3F")
    @DSModeled(DSC.SAFE)
    public String getExpires() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mHeaders[IDX_EXPIRES];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.793 -0400", hash_original_method = "FAE5B14F1D1AF7F7C5B34799287CB96B", hash_generated_method = "6808DCB11332DE3952677DE0579FA3D8")
    @DSModeled(DSC.SAFE)
    public String getCacheControl() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mHeaders[IDX_CACHE_CONTROL];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.793 -0400", hash_original_method = "5FC9B5DD06D10DB2F99A11CF11E84611", hash_generated_method = "4F7C3A9CE5E8AAB5FAFD0E217F508382")
    @DSModeled(DSC.SAFE)
    public String getLastModified() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mHeaders[IDX_LAST_MODIFIED];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.793 -0400", hash_original_method = "2356D85AA5974933778FA07340E360AB", hash_generated_method = "954D9BB0AD894E833D7A92A90C84E380")
    @DSModeled(DSC.SAFE)
    public String getEtag() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mHeaders[IDX_ETAG];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.793 -0400", hash_original_method = "30BF89B95A4B495DCD1A87F8054AFEC5", hash_generated_method = "2090913B20A342232C6D89F93E4F15BD")
    @DSModeled(DSC.SAFE)
    public ArrayList<String> getSetCookie() {
        return (ArrayList<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.cookies;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.794 -0400", hash_original_method = "A30AE7605FF81FB95FDA5AAF057C022D", hash_generated_method = "1E402AD5ED4076A94EBC20B15A9DCF7C")
    @DSModeled(DSC.SAFE)
    public String getPragma() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mHeaders[IDX_PRAGMA];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.794 -0400", hash_original_method = "847E30EC42ECB16F3B862D5A0C1778F0", hash_generated_method = "42D68AF198C3898024A26EF4CFF93800")
    @DSModeled(DSC.SAFE)
    public String getRefresh() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mHeaders[IDX_REFRESH];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.794 -0400", hash_original_method = "120DF6C7E530068F21D41A0CCD884530", hash_generated_method = "B739DF914DF7DFC026DE62D3CFAF9C67")
    @DSModeled(DSC.SAFE)
    public String getXPermittedCrossDomainPolicies() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mHeaders[IDX_X_PERMITTED_CROSS_DOMAIN_POLICIES];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.794 -0400", hash_original_method = "655405705FFA26A24CEE799E196F64CA", hash_generated_method = "824A7B07E8EC448A95DC167CDC93C69D")
    @DSModeled(DSC.SAFE)
    public void setContentLength(long value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //this.contentLength = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.795 -0400", hash_original_method = "DBD4B3393EC7C86D318F09AACB690C16", hash_generated_method = "E165B6F3D031A286F09A25383DCB6F94")
    @DSModeled(DSC.SAFE)
    public void setContentType(String value) {
        dsTaint.addTaint(value);
        mHeaders[IDX_CONTENT_TYPE] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_CONTENT_TYPE] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.795 -0400", hash_original_method = "795639D1D1B96C335181D978646FFEAC", hash_generated_method = "1EFD557F30408866A27A9F1A21F759EB")
    @DSModeled(DSC.SAFE)
    public void setContentEncoding(String value) {
        dsTaint.addTaint(value);
        mHeaders[IDX_CONTENT_ENCODING] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_CONTENT_ENCODING] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.795 -0400", hash_original_method = "91ACBD0DA1F8B6B752177E887C1E560A", hash_generated_method = "BEE9B1FF3B897D579596176193D5DEAB")
    @DSModeled(DSC.SAFE)
    public void setLocation(String value) {
        dsTaint.addTaint(value);
        mHeaders[IDX_LOCATION] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_LOCATION] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.795 -0400", hash_original_method = "78E4D283A358D7F9AC830EDA5944CEC1", hash_generated_method = "4829EC7EB5910FCA11239B59B2A314A8")
    @DSModeled(DSC.SAFE)
    public void setWwwAuthenticate(String value) {
        dsTaint.addTaint(value);
        mHeaders[IDX_WWW_AUTHENTICATE] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_WWW_AUTHENTICATE] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.796 -0400", hash_original_method = "EB3C03E25C95805816417AB68A1F4E73", hash_generated_method = "67EE1448EC79F3D39D31C840FE1B6AFC")
    @DSModeled(DSC.SAFE)
    public void setProxyAuthenticate(String value) {
        dsTaint.addTaint(value);
        mHeaders[IDX_PROXY_AUTHENTICATE] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_PROXY_AUTHENTICATE] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.796 -0400", hash_original_method = "CAF824941A606D9472E6B7F4D5AE8EAB", hash_generated_method = "A1E624AA150CBA9B81685E5374C8A0EA")
    @DSModeled(DSC.SAFE)
    public void setContentDisposition(String value) {
        dsTaint.addTaint(value);
        mHeaders[IDX_CONTENT_DISPOSITION] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_CONTENT_DISPOSITION] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.796 -0400", hash_original_method = "42F6F595EF9293A515A4DDDF580E03E6", hash_generated_method = "E6ED43E4A90B2E7EA404BE374760FF3D")
    @DSModeled(DSC.SAFE)
    public void setAcceptRanges(String value) {
        dsTaint.addTaint(value);
        mHeaders[IDX_ACCEPT_RANGES] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_ACCEPT_RANGES] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.796 -0400", hash_original_method = "7D2DC3B419C5BDAB21BBD8535AC32115", hash_generated_method = "E4DE9337E7ECE32D991859C02198EE45")
    @DSModeled(DSC.SAFE)
    public void setExpires(String value) {
        dsTaint.addTaint(value);
        mHeaders[IDX_EXPIRES] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_EXPIRES] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.797 -0400", hash_original_method = "461838AAEBDAFBB838DA60C8789FC643", hash_generated_method = "C874B77ADF6A06A56464B849B25141B6")
    @DSModeled(DSC.SAFE)
    public void setCacheControl(String value) {
        dsTaint.addTaint(value);
        mHeaders[IDX_CACHE_CONTROL] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_CACHE_CONTROL] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.797 -0400", hash_original_method = "E44516D40CA535A9E78D483DC766FE77", hash_generated_method = "23A7C4F2A6BCD24EC37305CC18C9DEC2")
    @DSModeled(DSC.SAFE)
    public void setLastModified(String value) {
        dsTaint.addTaint(value);
        mHeaders[IDX_LAST_MODIFIED] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_LAST_MODIFIED] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.797 -0400", hash_original_method = "7E96E0634D296A60D862609FEA944EA2", hash_generated_method = "3C1B3F27B8E3A8FECA1A0637EC85105C")
    @DSModeled(DSC.SAFE)
    public void setEtag(String value) {
        dsTaint.addTaint(value);
        mHeaders[IDX_ETAG] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_ETAG] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.797 -0400", hash_original_method = "860A5481555AE910297114E1D7478814", hash_generated_method = "DB61CE31D5C4B5E07EA756FB0B54E5DB")
    @DSModeled(DSC.SAFE)
    public void setXPermittedCrossDomainPolicies(String value) {
        dsTaint.addTaint(value);
        mHeaders[IDX_X_PERMITTED_CROSS_DOMAIN_POLICIES] = value;
        // ---------- Original Method ----------
        //mHeaders[IDX_X_PERMITTED_CROSS_DOMAIN_POLICIES] = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.798 -0400", hash_original_method = "C9CAD2CB40E843B6A6F48005E0DE2B60", hash_generated_method = "6636A629DCAE60CE20387321074850E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getHeaders(HeaderCallback hcb) {
        dsTaint.addTaint(hcb.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.798 -0400", hash_original_method = "D8DC07475CD7B5300779AA7E8CC52DE7", hash_generated_method = "A731F07DF1BAAB2A16006F89B86EA001")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setConnectionType(CharArrayBuffer buffer, int pos) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(pos);
        {
            boolean varA7F18A145505BA8F70BFD34F9C06069F_1845955011 = (CharArrayBuffers.containsIgnoreCaseTrimmed(
                buffer, pos, HTTP.CONN_CLOSE));
            {
                connectionType = CONN_CLOSE;
            } //End block
            {
                boolean varFA43AAAB4BAA63E0806E72853F50D31D_570223337 = (CharArrayBuffers.containsIgnoreCaseTrimmed(
                buffer, pos, HTTP.CONN_KEEP_ALIVE));
                {
                    connectionType = CONN_KEEP_ALIVE;
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
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
    
    private static final String LOGTAG = "Http";
    public final static int CONN_CLOSE = 1;
    public final static int CONN_KEEP_ALIVE = 2;
    public final static int NO_CONN_TYPE = 0;
    public final static long NO_TRANSFER_ENCODING = 0;
    public final static long NO_CONTENT_LENGTH = -1;
    public final static String TRANSFER_ENCODING = "transfer-encoding";
    public final static String CONTENT_LEN = "content-length";
    public final static String CONTENT_TYPE = "content-type";
    public final static String CONTENT_ENCODING = "content-encoding";
    public final static String CONN_DIRECTIVE = "connection";
    public final static String LOCATION = "location";
    public final static String PROXY_CONNECTION = "proxy-connection";
    public final static String WWW_AUTHENTICATE = "www-authenticate";
    public final static String PROXY_AUTHENTICATE = "proxy-authenticate";
    public final static String CONTENT_DISPOSITION = "content-disposition";
    public final static String ACCEPT_RANGES = "accept-ranges";
    public final static String EXPIRES = "expires";
    public final static String CACHE_CONTROL = "cache-control";
    public final static String LAST_MODIFIED = "last-modified";
    public final static String ETAG = "etag";
    public final static String SET_COOKIE = "set-cookie";
    public final static String PRAGMA = "pragma";
    public final static String REFRESH = "refresh";
    public final static String X_PERMITTED_CROSS_DOMAIN_POLICIES = "x-permitted-cross-domain-policies";
    private final static int HASH_TRANSFER_ENCODING = 1274458357;
    private final static int HASH_CONTENT_LEN = -1132779846;
    private final static int HASH_CONTENT_TYPE = 785670158;
    private final static int HASH_CONTENT_ENCODING = 2095084583;
    private final static int HASH_CONN_DIRECTIVE = -775651618;
    private final static int HASH_LOCATION = 1901043637;
    private final static int HASH_PROXY_CONNECTION = 285929373;
    private final static int HASH_WWW_AUTHENTICATE = -243037365;
    private final static int HASH_PROXY_AUTHENTICATE = -301767724;
    private final static int HASH_CONTENT_DISPOSITION = -1267267485;
    private final static int HASH_ACCEPT_RANGES = 1397189435;
    private final static int HASH_EXPIRES = -1309235404;
    private final static int HASH_CACHE_CONTROL = -208775662;
    private final static int HASH_LAST_MODIFIED = 150043680;
    private final static int HASH_ETAG = 3123477;
    private final static int HASH_SET_COOKIE = 1237214767;
    private final static int HASH_PRAGMA = -980228804;
    private final static int HASH_REFRESH = 1085444827;
    private final static int HASH_X_PERMITTED_CROSS_DOMAIN_POLICIES = -1345594014;
    private final static int IDX_TRANSFER_ENCODING = 0;
    private final static int IDX_CONTENT_LEN = 1;
    private final static int IDX_CONTENT_TYPE = 2;
    private final static int IDX_CONTENT_ENCODING = 3;
    private final static int IDX_CONN_DIRECTIVE = 4;
    private final static int IDX_LOCATION = 5;
    private final static int IDX_PROXY_CONNECTION = 6;
    private final static int IDX_WWW_AUTHENTICATE = 7;
    private final static int IDX_PROXY_AUTHENTICATE = 8;
    private final static int IDX_CONTENT_DISPOSITION = 9;
    private final static int IDX_ACCEPT_RANGES = 10;
    private final static int IDX_EXPIRES = 11;
    private final static int IDX_CACHE_CONTROL = 12;
    private final static int IDX_LAST_MODIFIED = 13;
    private final static int IDX_ETAG = 14;
    private final static int IDX_SET_COOKIE = 15;
    private final static int IDX_PRAGMA = 16;
    private final static int IDX_REFRESH = 17;
    private final static int IDX_X_PERMITTED_CROSS_DOMAIN_POLICIES = 18;
    private final static int HEADER_COUNT = 19;
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

