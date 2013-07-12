package org.apache.http.impl.cookie;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.649 -0400", hash_original_field = "60E59FA1D4034653FC981EEB8C0CE3F3", hash_generated_field = "41DF6CEE83D74A6FDB1FAB0DD1A4D526")

    private String[] datepatterns;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.651 -0400", hash_original_method = "9A47B9CC7B92F95BCFF768FA5CC6D454", hash_generated_method = "EDE04D62F30DCE22B8B1CE1521989C67")
    public  NetscapeDraftSpec(final String[] datepatterns) {
        super();
    if(datepatterns != null)        
        {
            this.datepatterns = datepatterns.clone();
        } 
        else
        {
            this.datepatterns = new String[] { EXPIRES_PATTERN };
        } 
        registerAttribHandler(ClientCookie.PATH_ATTR, new BasicPathHandler());
        registerAttribHandler(ClientCookie.DOMAIN_ATTR, new NetscapeDomainHandler());
        registerAttribHandler(ClientCookie.MAX_AGE_ATTR, new BasicMaxAgeHandler());
        registerAttribHandler(ClientCookie.SECURE_ATTR, new BasicSecureHandler());
        registerAttribHandler(ClientCookie.COMMENT_ATTR, new BasicCommentHandler());
        registerAttribHandler(ClientCookie.EXPIRES_ATTR, new BasicExpiresHandler(
                this.datepatterns));
        
        
            
        
            
        
        
        
        
        
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.651 -0400", hash_original_method = "6C3990D1C0CF4149D1074399C8EE261A", hash_generated_method = "F26D5995B8A8A9F5B2F2F2A5E9F900D8")
    public  NetscapeDraftSpec() {
        this(null);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.652 -0400", hash_original_method = "4C234501C46CBF19AFF354B62202B78D", hash_generated_method = "84DB3BCAEBA99460E078BF236EB0B880")
    public List<Cookie> parse(final Header header, final CookieOrigin origin) throws MalformedCookieException {
        addTaint(origin.getTaint());
        addTaint(header.getTaint());
    if(header == null)        
        {
            IllegalArgumentException var655E57DE77F969F763516260E292795B_836642499 = new IllegalArgumentException("Header may not be null");
            var655E57DE77F969F763516260E292795B_836642499.addTaint(taint);
            throw var655E57DE77F969F763516260E292795B_836642499;
        } 
    if(origin == null)        
        {
            IllegalArgumentException var4264914F0057BA70A0B3E6621821A095_799342345 = new IllegalArgumentException("Cookie origin may not be null");
            var4264914F0057BA70A0B3E6621821A095_799342345.addTaint(taint);
            throw var4264914F0057BA70A0B3E6621821A095_799342345;
        } 
        NetscapeDraftHeaderParser parser = NetscapeDraftHeaderParser.DEFAULT;
        CharArrayBuffer buffer;
        ParserCursor cursor;
    if(header instanceof FormattedHeader)        
        {
            buffer = ((FormattedHeader) header).getBuffer();
            cursor = new ParserCursor(
                    ((FormattedHeader) header).getValuePos(), 
                    buffer.length());
        } 
        else
        {
            String s = header.getValue();
    if(s == null)            
            {
                MalformedCookieException var559921376C3ECF399D4F4743EF8ED9B9_66077714 = new MalformedCookieException("Header value is null");
                var559921376C3ECF399D4F4743EF8ED9B9_66077714.addTaint(taint);
                throw var559921376C3ECF399D4F4743EF8ED9B9_66077714;
            } 
            buffer = new CharArrayBuffer(s.length());
            buffer.append(s);
            cursor = new ParserCursor(0, buffer.length());
        } 
List<Cookie> var84675F43B27C949A0B55204549B6B899_2020616725 =         parse(new HeaderElement[] { parser.parseHeader(buffer, cursor) }, origin);
        var84675F43B27C949A0B55204549B6B899_2020616725.addTaint(taint);
        return var84675F43B27C949A0B55204549B6B899_2020616725;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.653 -0400", hash_original_method = "A256F1B3B1422E7AF6F0628F304CDE1F", hash_generated_method = "973AB907F3D453D2770CD5D392F6AF29")
    public List<Header> formatCookies(final List<Cookie> cookies) {
        addTaint(cookies.getTaint());
    if(cookies == null)        
        {
            IllegalArgumentException varF8FD3AA86899D4A0D763F37D49D2DC0B_225581401 = new IllegalArgumentException("List of cookies may not be null");
            varF8FD3AA86899D4A0D763F37D49D2DC0B_225581401.addTaint(taint);
            throw varF8FD3AA86899D4A0D763F37D49D2DC0B_225581401;
        } 
    if(cookies.isEmpty())        
        {
            IllegalArgumentException varA9E78185ACB38B15D24741774F0DBD8F_2146755478 = new IllegalArgumentException("List of cookies may not be empty");
            varA9E78185ACB38B15D24741774F0DBD8F_2146755478.addTaint(taint);
            throw varA9E78185ACB38B15D24741774F0DBD8F_2146755478;
        } 
        CharArrayBuffer buffer = new CharArrayBuffer(20 * cookies.size());
        buffer.append(SM.COOKIE);
        buffer.append(": ");
for(int i = 0;i < cookies.size();i++)
        {
            Cookie cookie = cookies.get(i);
    if(i > 0)            
            {
                buffer.append("; ");
            } 
            buffer.append(cookie.getName());
            String s = cookie.getValue();
    if(s != null)            
            {
                buffer.append("=");
                buffer.append(s);
            } 
        } 
        List<Header> headers = new ArrayList<Header>(1);
        headers.add(new BufferedHeader(buffer));
List<Header> var6937E37BAD8D53F9D49A0E32C69A3A2C_313033165 =         headers;
        var6937E37BAD8D53F9D49A0E32C69A3A2C_313033165.addTaint(taint);
        return var6937E37BAD8D53F9D49A0E32C69A3A2C_313033165;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.654 -0400", hash_original_method = "F5A7F7B6DBF07E93DFA757749FB9F06B", hash_generated_method = "3FC71C2D63F7C9A0EAD07FA8749411A6")
    public int getVersion() {
        int varCFCD208495D565EF66E7DFF9F98764DA_471923646 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1903406492 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1903406492;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.654 -0400", hash_original_method = "C1FA79C2C3115B4C8F8CB20B10CB9417", hash_generated_method = "D6C97A90CFE2ABB4281F8DFD8AF9E4F6")
    public Header getVersionHeader() {
Header var540C13E9E156B687226421B24F2DF178_1060866469 =         null;
        var540C13E9E156B687226421B24F2DF178_1060866469.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1060866469;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:36.654 -0400", hash_original_field = "75C758E6AD4D039ECEF0019A9E74D3BE", hash_generated_field = "75A930ACC00C38EA525AA6DCE1798995")

    protected static final String EXPIRES_PATTERN = "EEE, dd-MMM-yyyy HH:mm:ss z";
}

