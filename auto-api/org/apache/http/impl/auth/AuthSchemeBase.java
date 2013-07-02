package org.apache.http.impl.auth;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.auth.AUTH;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;

public abstract class AuthSchemeBase implements AuthScheme {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.770 -0400", hash_original_field = "431387EB7262E1CFC79B125EB8A67C60", hash_generated_field = "90A6DE2E00E635760A3B1A224459E469")

    private boolean proxy;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.770 -0400", hash_original_method = "7082ED5A83D0EFFA08BB77E1EC0EBD1E", hash_generated_method = "0AE5056767E4146DFC6F431C6B92E16B")
    public  AuthSchemeBase() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.771 -0400", hash_original_method = "59A8005652A60A6022050E43FD761E80", hash_generated_method = "451158B3780A9994F6A77D677D3D83AB")
    public void processChallenge(final Header header) throws MalformedChallengeException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Header may not be null");
        } 
        String authheader = header.getName();
        {
            boolean var8DC398C4CAF9AC0E511D2C3D0DF740FC_734281397 = (authheader.equalsIgnoreCase(AUTH.WWW_AUTH));
            {
                this.proxy = false;
            } 
            {
                boolean varBFE84D9EF92FF162D0DB5E549DFF104B_438660981 = (authheader.equalsIgnoreCase(AUTH.PROXY_AUTH));
                {
                    this.proxy = true;
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new MalformedChallengeException("Unexpected header name: " + authheader);
                } 
            } 
        } 
        CharArrayBuffer buffer;
        int pos;
        {
            buffer = ((FormattedHeader) header).getBuffer();
            pos = ((FormattedHeader) header).getValuePos();
        } 
        {
            String s = header.getValue();
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedChallengeException("Header value is null");
            } 
            buffer = new CharArrayBuffer(s.length());
            buffer.append(s);
            pos = 0;
        } 
        {
            boolean var3EDF5BAA6101A06E7CDE5C0535EFFC3A_2012418186 = (pos < buffer.length() && HTTP.isWhitespace(buffer.charAt(pos)));
        } 
        int beginIndex = pos;
        {
            boolean var9771168623308666B24A198A57036589_243545606 = (pos < buffer.length() && !HTTP.isWhitespace(buffer.charAt(pos)));
        } 
        int endIndex = pos;
        String s = buffer.substring(beginIndex, endIndex);
        {
            boolean varAAFA4FBFDBD33BB5860DD895AF0E9A5B_1096801203 = (!s.equalsIgnoreCase(getSchemeName()));
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedChallengeException("Invalid scheme identifier: " + s);
            } 
        } 
        parseChallenge(buffer, pos, buffer.length());
        addTaint(header.getTaint());
        
        
    }

    
    protected abstract void parseChallenge(
            CharArrayBuffer buffer, int pos, int len) throws MalformedChallengeException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.771 -0400", hash_original_method = "268F84420EF1E9954B4C291A99275A1C", hash_generated_method = "3CBB18721890B0B414FE72366373FABA")
    public boolean isProxy() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_149349725 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_149349725;
        
        
    }

    
}

