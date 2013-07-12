package org.apache.http.impl.auth;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.auth.AUTH;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;

public abstract class AuthSchemeBase implements AuthScheme {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.096 -0400", hash_original_field = "431387EB7262E1CFC79B125EB8A67C60", hash_generated_field = "90A6DE2E00E635760A3B1A224459E469")

    private boolean proxy;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.096 -0400", hash_original_method = "7082ED5A83D0EFFA08BB77E1EC0EBD1E", hash_generated_method = "0AE5056767E4146DFC6F431C6B92E16B")
    public  AuthSchemeBase() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.097 -0400", hash_original_method = "59A8005652A60A6022050E43FD761E80", hash_generated_method = "68DD2A907A13385F2B9254A88C7BC511")
    public void processChallenge(final Header header) throws MalformedChallengeException {
        addTaint(header.getTaint());
    if(header == null)        
        {
            IllegalArgumentException var655E57DE77F969F763516260E292795B_1506695045 = new IllegalArgumentException("Header may not be null");
            var655E57DE77F969F763516260E292795B_1506695045.addTaint(taint);
            throw var655E57DE77F969F763516260E292795B_1506695045;
        } 
        String authheader = header.getName();
    if(authheader.equalsIgnoreCase(AUTH.WWW_AUTH))        
        {
            this.proxy = false;
        } 
        else
    if(authheader.equalsIgnoreCase(AUTH.PROXY_AUTH))        
        {
            this.proxy = true;
        } 
        else
        {
            MalformedChallengeException varE6D8B5DE8CD72B409B9E0AC22A5316F9_1072795465 = new MalformedChallengeException("Unexpected header name: " + authheader);
            varE6D8B5DE8CD72B409B9E0AC22A5316F9_1072795465.addTaint(taint);
            throw varE6D8B5DE8CD72B409B9E0AC22A5316F9_1072795465;
        } 
        CharArrayBuffer buffer;
        int pos;
    if(header instanceof FormattedHeader)        
        {
            buffer = ((FormattedHeader) header).getBuffer();
            pos = ((FormattedHeader) header).getValuePos();
        } 
        else
        {
            String s = header.getValue();
    if(s == null)            
            {
                MalformedChallengeException var7F2BB44ACA42A76F5E79899908E75392_622802740 = new MalformedChallengeException("Header value is null");
                var7F2BB44ACA42A76F5E79899908E75392_622802740.addTaint(taint);
                throw var7F2BB44ACA42A76F5E79899908E75392_622802740;
            } 
            buffer = new CharArrayBuffer(s.length());
            buffer.append(s);
            pos = 0;
        } 
        while
(pos < buffer.length() && HTTP.isWhitespace(buffer.charAt(pos)))        
        {
            pos++;
        } 
        int beginIndex = pos;
        while
(pos < buffer.length() && !HTTP.isWhitespace(buffer.charAt(pos)))        
        {
            pos++;
        } 
        int endIndex = pos;
        String s = buffer.substring(beginIndex, endIndex);
    if(!s.equalsIgnoreCase(getSchemeName()))        
        {
            MalformedChallengeException varC286765E94B92B0BD8B4C84A6DF93210_928851454 = new MalformedChallengeException("Invalid scheme identifier: " + s);
            varC286765E94B92B0BD8B4C84A6DF93210_928851454.addTaint(taint);
            throw varC286765E94B92B0BD8B4C84A6DF93210_928851454;
        } 
        parseChallenge(buffer, pos, buffer.length());
        
        
    }

    
    protected abstract void parseChallenge(
            CharArrayBuffer buffer, int pos, int len) throws MalformedChallengeException;

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.099 -0400", hash_original_method = "268F84420EF1E9954B4C291A99275A1C", hash_generated_method = "744324C8C62ECA0A7E68F43E0460614D")
    public boolean isProxy() {
        boolean var8D85537F0BC6D0E5E9FAD030D5A879CA_1057904560 = (this.proxy);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1389265919 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1389265919;
        
        
    }

    
}

