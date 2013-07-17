package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.cookie.SM;
import org.apache.http.message.BufferedHeader;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;

public class NetscapeDraftSpec extends CookieSpecBase {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.981 -0400", hash_original_field = "60E59FA1D4034653FC981EEB8C0CE3F3", hash_generated_field = "41DF6CEE83D74A6FDB1FAB0DD1A4D526")

    private String[] datepatterns;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.982 -0400", hash_original_method = "9A47B9CC7B92F95BCFF768FA5CC6D454", hash_generated_method = "EDE04D62F30DCE22B8B1CE1521989C67")
    public  NetscapeDraftSpec(final String[] datepatterns) {
        super();
        if(datepatterns != null)        
        {
            this.datepatterns = datepatterns.clone();
        } //End block
        else
        {
            this.datepatterns = new String[] { EXPIRES_PATTERN };
        } //End block
        registerAttribHandler(ClientCookie.PATH_ATTR, new BasicPathHandler());
        registerAttribHandler(ClientCookie.DOMAIN_ATTR, new NetscapeDomainHandler());
        registerAttribHandler(ClientCookie.MAX_AGE_ATTR, new BasicMaxAgeHandler());
        registerAttribHandler(ClientCookie.SECURE_ATTR, new BasicSecureHandler());
        registerAttribHandler(ClientCookie.COMMENT_ATTR, new BasicCommentHandler());
        registerAttribHandler(ClientCookie.EXPIRES_ATTR, new BasicExpiresHandler(
                this.datepatterns));
        // ---------- Original Method ----------
        //if (datepatterns != null) {
            //this.datepatterns = datepatterns.clone();
        //} else {
            //this.datepatterns = new String[] { EXPIRES_PATTERN };
        //}
        //registerAttribHandler(ClientCookie.PATH_ATTR, new BasicPathHandler());
        //registerAttribHandler(ClientCookie.DOMAIN_ATTR, new NetscapeDomainHandler());
        //registerAttribHandler(ClientCookie.MAX_AGE_ATTR, new BasicMaxAgeHandler());
        //registerAttribHandler(ClientCookie.SECURE_ATTR, new BasicSecureHandler());
        //registerAttribHandler(ClientCookie.COMMENT_ATTR, new BasicCommentHandler());
        //registerAttribHandler(ClientCookie.EXPIRES_ATTR, new BasicExpiresHandler(
                //this.datepatterns));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.983 -0400", hash_original_method = "6C3990D1C0CF4149D1074399C8EE261A", hash_generated_method = "F26D5995B8A8A9F5B2F2F2A5E9F900D8")
    public  NetscapeDraftSpec() {
        this(null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.984 -0400", hash_original_method = "4C234501C46CBF19AFF354B62202B78D", hash_generated_method = "E3DEA6D395D9099503DCFDA3023D669D")
    public List<Cookie> parse(final Header header, final CookieOrigin origin) throws MalformedCookieException {
        addTaint(origin.getTaint());
        addTaint(header.getTaint());
        if(header == null)        
        {
            IllegalArgumentException var655E57DE77F969F763516260E292795B_757175391 = new IllegalArgumentException("Header may not be null");
            var655E57DE77F969F763516260E292795B_757175391.addTaint(taint);
            throw var655E57DE77F969F763516260E292795B_757175391;
        } //End block
        if(origin == null)        
        {
            IllegalArgumentException var4264914F0057BA70A0B3E6621821A095_1852018677 = new IllegalArgumentException("Cookie origin may not be null");
            var4264914F0057BA70A0B3E6621821A095_1852018677.addTaint(taint);
            throw var4264914F0057BA70A0B3E6621821A095_1852018677;
        } //End block
        NetscapeDraftHeaderParser parser = NetscapeDraftHeaderParser.DEFAULT;
        CharArrayBuffer buffer;
        ParserCursor cursor;
        if(header instanceof FormattedHeader)        
        {
            buffer = ((FormattedHeader) header).getBuffer();
            cursor = new ParserCursor(
                    ((FormattedHeader) header).getValuePos(), 
                    buffer.length());
        } //End block
        else
        {
            String s = header.getValue();
            if(s == null)            
            {
                MalformedCookieException var559921376C3ECF399D4F4743EF8ED9B9_367776218 = new MalformedCookieException("Header value is null");
                var559921376C3ECF399D4F4743EF8ED9B9_367776218.addTaint(taint);
                throw var559921376C3ECF399D4F4743EF8ED9B9_367776218;
            } //End block
            buffer = new CharArrayBuffer(s.length());
            buffer.append(s);
            cursor = new ParserCursor(0, buffer.length());
        } //End block
List<Cookie> var84675F43B27C949A0B55204549B6B899_697467792 =         parse(new HeaderElement[] { parser.parseHeader(buffer, cursor) }, origin);
        var84675F43B27C949A0B55204549B6B899_697467792.addTaint(taint);
        return var84675F43B27C949A0B55204549B6B899_697467792;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.985 -0400", hash_original_method = "A256F1B3B1422E7AF6F0628F304CDE1F", hash_generated_method = "6D5933E49505B5A44CA51C2B117A6002")
    public List<Header> formatCookies(final List<Cookie> cookies) {
        addTaint(cookies.getTaint());
        if(cookies == null)        
        {
            IllegalArgumentException varF8FD3AA86899D4A0D763F37D49D2DC0B_855579346 = new IllegalArgumentException("List of cookies may not be null");
            varF8FD3AA86899D4A0D763F37D49D2DC0B_855579346.addTaint(taint);
            throw varF8FD3AA86899D4A0D763F37D49D2DC0B_855579346;
        } //End block
        if(cookies.isEmpty())        
        {
            IllegalArgumentException varA9E78185ACB38B15D24741774F0DBD8F_2095211126 = new IllegalArgumentException("List of cookies may not be empty");
            varA9E78185ACB38B15D24741774F0DBD8F_2095211126.addTaint(taint);
            throw varA9E78185ACB38B15D24741774F0DBD8F_2095211126;
        } //End block
        CharArrayBuffer buffer = new CharArrayBuffer(20 * cookies.size());
        buffer.append(SM.COOKIE);
        buffer.append(": ");
for(int i = 0;i < cookies.size();i++)
        {
            Cookie cookie = cookies.get(i);
            if(i > 0)            
            {
                buffer.append("; ");
            } //End block
            buffer.append(cookie.getName());
            String s = cookie.getValue();
            if(s != null)            
            {
                buffer.append("=");
                buffer.append(s);
            } //End block
        } //End block
        List<Header> headers = new ArrayList<Header>(1);
        headers.add(new BufferedHeader(buffer));
List<Header> var6937E37BAD8D53F9D49A0E32C69A3A2C_609852318 =         headers;
        var6937E37BAD8D53F9D49A0E32C69A3A2C_609852318.addTaint(taint);
        return var6937E37BAD8D53F9D49A0E32C69A3A2C_609852318;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.986 -0400", hash_original_method = "F5A7F7B6DBF07E93DFA757749FB9F06B", hash_generated_method = "6C098E4ACD0AA4BC2935DAE9C2513161")
    public int getVersion() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1731840139 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1684859215 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1684859215;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.986 -0400", hash_original_method = "C1FA79C2C3115B4C8F8CB20B10CB9417", hash_generated_method = "8791D0F903315AB55F40BB602F843DF9")
    public Header getVersionHeader() {
Header var540C13E9E156B687226421B24F2DF178_1427804482 =         null;
        var540C13E9E156B687226421B24F2DF178_1427804482.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1427804482;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:35.986 -0400", hash_original_field = "75C758E6AD4D039ECEF0019A9E74D3BE", hash_generated_field = "75A930ACC00C38EA525AA6DCE1798995")

    protected static final String EXPIRES_PATTERN = "EEE, dd-MMM-yyyy HH:mm:ss z";
}

