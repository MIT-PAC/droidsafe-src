package org.apache.http.auth;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class AuthState {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.625 -0400", hash_original_field = "4929F7972D41B5CCD4EDC2D87BC594B6", hash_generated_field = "BD9BCA899CE487533F83BB63B68D9949")

    private AuthScheme authScheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.625 -0400", hash_original_field = "58EC6F20D429B755132D90C27CF86926", hash_generated_field = "D3EB159289FA6A5F760C58B08C36D985")

    private AuthScope authScope;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.625 -0400", hash_original_field = "D3ED68F7315B7E72B8D886B2278FCAC3", hash_generated_field = "80CCC649DBABDA6B9444725B03E08041")

    private Credentials credentials;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.626 -0400", hash_original_method = "42AD4E0626C603EC8E908340F6792E72", hash_generated_method = "141CC616389653FC1DF842DB00A69935")
    public  AuthState() {
        super();
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.626 -0400", hash_original_method = "2D3305654C6E379145E705984DE22DF2", hash_generated_method = "A55C2F4BEB1F546A14687031FC4380AC")
    public void invalidate() {
        this.authScheme = null;
        this.authScope = null;
        this.credentials = null;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.627 -0400", hash_original_method = "62DF5636D6479423C69AE868EF58D0CB", hash_generated_method = "8DDA4F48F27A88B7F4B74D394EF30643")
    public boolean isValid() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1393569238 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1393569238;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.627 -0400", hash_original_method = "B1DDF15E8AF9EFEA4D87152524FB22A7", hash_generated_method = "D7D515A27842BB230A63BC54B6C96EE2")
    public void setAuthScheme(final AuthScheme authScheme) {
        {
            invalidate();
        } 
        this.authScheme = authScheme;
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.628 -0400", hash_original_method = "C7CF977B6EF3E7F983B2AE16A4014379", hash_generated_method = "531AC3D9CBA0AAA3A0C0BDA94C666006")
    public AuthScheme getAuthScheme() {
        AuthScheme varB4EAC82CA7396A68D541C85D26508E83_1920624008 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1920624008 = this.authScheme;
        varB4EAC82CA7396A68D541C85D26508E83_1920624008.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1920624008;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.628 -0400", hash_original_method = "57CD79A3968806BAC032754AA40A41DA", hash_generated_method = "393D7361805C4D11099EB654619A560E")
    public Credentials getCredentials() {
        Credentials varB4EAC82CA7396A68D541C85D26508E83_1198666106 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1198666106 = this.credentials;
        varB4EAC82CA7396A68D541C85D26508E83_1198666106.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1198666106;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.629 -0400", hash_original_method = "CA0BD3D3E2D3BF9E673535ADF196F87D", hash_generated_method = "3DD02DA100E700462E960E48422CA3F9")
    public void setCredentials(final Credentials credentials) {
        this.credentials = credentials;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.629 -0400", hash_original_method = "BF313F23BCC888676D9F0166A2639A73", hash_generated_method = "3B95D00C3E82BE92151B923B64FD1E45")
    public AuthScope getAuthScope() {
        AuthScope varB4EAC82CA7396A68D541C85D26508E83_283640859 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_283640859 = this.authScope;
        varB4EAC82CA7396A68D541C85D26508E83_283640859.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_283640859;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.629 -0400", hash_original_method = "608941030C588F83A6C921F3D04280DF", hash_generated_method = "7D1366DFB32085A799B9EEC519DF7012")
    public void setAuthScope(final AuthScope authScope) {
        this.authScope = authScope;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.630 -0400", hash_original_method = "CD2C06D38ABEB8110AC037A3B94BECA0", hash_generated_method = "058F340942FBC19F4A710C9EE24AB6B4")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2005898877 = null; 
        StringBuilder buffer = new StringBuilder();
        buffer.append("auth scope [");
        buffer.append(this.authScope);
        buffer.append("]; credentials set [");
        buffer.append(this.credentials != null ? "true" : "false");
        buffer.append("]");
        varB4EAC82CA7396A68D541C85D26508E83_2005898877 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_2005898877.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2005898877;
        
        
        
        
        
        
        
        
    }

    
}

