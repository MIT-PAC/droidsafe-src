package org.apache.http.auth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class AuthState {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.704 -0400", hash_original_field = "4929F7972D41B5CCD4EDC2D87BC594B6", hash_generated_field = "BD9BCA899CE487533F83BB63B68D9949")

    private AuthScheme authScheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.704 -0400", hash_original_field = "58EC6F20D429B755132D90C27CF86926", hash_generated_field = "D3EB159289FA6A5F760C58B08C36D985")

    private AuthScope authScope;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.704 -0400", hash_original_field = "D3ED68F7315B7E72B8D886B2278FCAC3", hash_generated_field = "80CCC649DBABDA6B9444725B03E08041")

    private Credentials credentials;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.705 -0400", hash_original_method = "42AD4E0626C603EC8E908340F6792E72", hash_generated_method = "141CC616389653FC1DF842DB00A69935")
    public  AuthState() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.706 -0400", hash_original_method = "2D3305654C6E379145E705984DE22DF2", hash_generated_method = "A55C2F4BEB1F546A14687031FC4380AC")
    public void invalidate() {
        this.authScheme = null;
        this.authScope = null;
        this.credentials = null;
        // ---------- Original Method ----------
        //this.authScheme = null;
        //this.authScope = null;
        //this.credentials = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.706 -0400", hash_original_method = "62DF5636D6479423C69AE868EF58D0CB", hash_generated_method = "3028BCAF928D0C706E49E5AE70B02EED")
    public boolean isValid() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_317383093 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_317383093;
        // ---------- Original Method ----------
        //return this.authScheme != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.706 -0400", hash_original_method = "B1DDF15E8AF9EFEA4D87152524FB22A7", hash_generated_method = "D7D515A27842BB230A63BC54B6C96EE2")
    public void setAuthScheme(final AuthScheme authScheme) {
        {
            invalidate();
        } //End block
        this.authScheme = authScheme;
        // ---------- Original Method ----------
        //if (authScheme == null) {
            //invalidate();
            //return;
        //}
        //this.authScheme = authScheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.715 -0400", hash_original_method = "C7CF977B6EF3E7F983B2AE16A4014379", hash_generated_method = "F2C89C0DFB9B6454527491B74622A0CF")
    public AuthScheme getAuthScheme() {
        AuthScheme varB4EAC82CA7396A68D541C85D26508E83_748306319 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_748306319 = this.authScheme;
        varB4EAC82CA7396A68D541C85D26508E83_748306319.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_748306319;
        // ---------- Original Method ----------
        //return this.authScheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.720 -0400", hash_original_method = "57CD79A3968806BAC032754AA40A41DA", hash_generated_method = "8A4FF0562359521C0E0B69918D093ADA")
    public Credentials getCredentials() {
        Credentials varB4EAC82CA7396A68D541C85D26508E83_967636459 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_967636459 = this.credentials;
        varB4EAC82CA7396A68D541C85D26508E83_967636459.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_967636459;
        // ---------- Original Method ----------
        //return this.credentials;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.730 -0400", hash_original_method = "CA0BD3D3E2D3BF9E673535ADF196F87D", hash_generated_method = "3DD02DA100E700462E960E48422CA3F9")
    public void setCredentials(final Credentials credentials) {
        this.credentials = credentials;
        // ---------- Original Method ----------
        //this.credentials = credentials;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.738 -0400", hash_original_method = "BF313F23BCC888676D9F0166A2639A73", hash_generated_method = "146E5AA1D6E01DE2355D0804A9B5E245")
    public AuthScope getAuthScope() {
        AuthScope varB4EAC82CA7396A68D541C85D26508E83_825690557 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_825690557 = this.authScope;
        varB4EAC82CA7396A68D541C85D26508E83_825690557.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_825690557;
        // ---------- Original Method ----------
        //return this.authScope;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.738 -0400", hash_original_method = "608941030C588F83A6C921F3D04280DF", hash_generated_method = "7D1366DFB32085A799B9EEC519DF7012")
    public void setAuthScope(final AuthScope authScope) {
        this.authScope = authScope;
        // ---------- Original Method ----------
        //this.authScope = authScope;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.739 -0400", hash_original_method = "CD2C06D38ABEB8110AC037A3B94BECA0", hash_generated_method = "C8E81F12CEBEE53F02E55EAF9BAB9AAA")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1006450365 = null; //Variable for return #1
        StringBuilder buffer;
        buffer = new StringBuilder();
        buffer.append("auth scope [");
        buffer.append(this.authScope);
        buffer.append("]; credentials set [");
        buffer.append(this.credentials != null ? "true" : "false");
        buffer.append("]");
        varB4EAC82CA7396A68D541C85D26508E83_1006450365 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1006450365.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1006450365;
        // ---------- Original Method ----------
        //StringBuilder buffer = new StringBuilder();
        //buffer.append("auth scope [");
        //buffer.append(this.authScope);
        //buffer.append("]; credentials set [");
        //buffer.append(this.credentials != null ? "true" : "false");
        //buffer.append("]");
        //return buffer.toString();
    }

    
}

