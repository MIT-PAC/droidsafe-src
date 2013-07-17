package org.apache.http.impl.auth;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.373 -0400", hash_original_field = "431387EB7262E1CFC79B125EB8A67C60", hash_generated_field = "90A6DE2E00E635760A3B1A224459E469")

    private boolean proxy;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.373 -0400", hash_original_method = "7082ED5A83D0EFFA08BB77E1EC0EBD1E", hash_generated_method = "0AE5056767E4146DFC6F431C6B92E16B")
    public  AuthSchemeBase() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.374 -0400", hash_original_method = "59A8005652A60A6022050E43FD761E80", hash_generated_method = "34BCC8C6222698DB7916F4BA3F6F6F8E")
    public void processChallenge(final Header header) throws MalformedChallengeException {
        addTaint(header.getTaint());
        if(header == null)        
        {
            IllegalArgumentException var655E57DE77F969F763516260E292795B_1843117350 = new IllegalArgumentException("Header may not be null");
            var655E57DE77F969F763516260E292795B_1843117350.addTaint(taint);
            throw var655E57DE77F969F763516260E292795B_1843117350;
        } //End block
        String authheader = header.getName();
        if(authheader.equalsIgnoreCase(AUTH.WWW_AUTH))        
        {
            this.proxy = false;
        } //End block
        else
        if(authheader.equalsIgnoreCase(AUTH.PROXY_AUTH))        
        {
            this.proxy = true;
        } //End block
        else
        {
            MalformedChallengeException varE6D8B5DE8CD72B409B9E0AC22A5316F9_1001754713 = new MalformedChallengeException("Unexpected header name: " + authheader);
            varE6D8B5DE8CD72B409B9E0AC22A5316F9_1001754713.addTaint(taint);
            throw varE6D8B5DE8CD72B409B9E0AC22A5316F9_1001754713;
        } //End block
        CharArrayBuffer buffer;
        int pos;
        if(header instanceof FormattedHeader)        
        {
            buffer = ((FormattedHeader) header).getBuffer();
            pos = ((FormattedHeader) header).getValuePos();
        } //End block
        else
        {
            String s = header.getValue();
            if(s == null)            
            {
                MalformedChallengeException var7F2BB44ACA42A76F5E79899908E75392_1313302726 = new MalformedChallengeException("Header value is null");
                var7F2BB44ACA42A76F5E79899908E75392_1313302726.addTaint(taint);
                throw var7F2BB44ACA42A76F5E79899908E75392_1313302726;
            } //End block
            buffer = new CharArrayBuffer(s.length());
            buffer.append(s);
            pos = 0;
        } //End block
        while
(pos < buffer.length() && HTTP.isWhitespace(buffer.charAt(pos)))        
        {
            pos++;
        } //End block
        int beginIndex = pos;
        while
(pos < buffer.length() && !HTTP.isWhitespace(buffer.charAt(pos)))        
        {
            pos++;
        } //End block
        int endIndex = pos;
        String s = buffer.substring(beginIndex, endIndex);
        if(!s.equalsIgnoreCase(getSchemeName()))        
        {
            MalformedChallengeException varC286765E94B92B0BD8B4C84A6DF93210_326136105 = new MalformedChallengeException("Invalid scheme identifier: " + s);
            varC286765E94B92B0BD8B4C84A6DF93210_326136105.addTaint(taint);
            throw varC286765E94B92B0BD8B4C84A6DF93210_326136105;
        } //End block
        parseChallenge(buffer, pos, buffer.length());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract void parseChallenge(
            CharArrayBuffer buffer, int pos, int len) throws MalformedChallengeException;

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.374 -0400", hash_original_method = "268F84420EF1E9954B4C291A99275A1C", hash_generated_method = "6115C468FDB0F19BC170A844C1F6FF8D")
    public boolean isProxy() {
        boolean var8D85537F0BC6D0E5E9FAD030D5A879CA_1890798894 = (this.proxy);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_915732747 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_915732747;
        // ---------- Original Method ----------
        //return this.proxy;
    }

    
}

