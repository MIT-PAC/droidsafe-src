package org.apache.http.auth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class AuthState {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.755 -0400", hash_original_field = "4929F7972D41B5CCD4EDC2D87BC594B6", hash_generated_field = "BD9BCA899CE487533F83BB63B68D9949")

    private AuthScheme authScheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.756 -0400", hash_original_field = "58EC6F20D429B755132D90C27CF86926", hash_generated_field = "D3EB159289FA6A5F760C58B08C36D985")

    private AuthScope authScope;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.756 -0400", hash_original_field = "D3ED68F7315B7E72B8D886B2278FCAC3", hash_generated_field = "80CCC649DBABDA6B9444725B03E08041")

    private Credentials credentials;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.756 -0400", hash_original_method = "42AD4E0626C603EC8E908340F6792E72", hash_generated_method = "141CC616389653FC1DF842DB00A69935")
    public  AuthState() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.766 -0400", hash_original_method = "2D3305654C6E379145E705984DE22DF2", hash_generated_method = "A55C2F4BEB1F546A14687031FC4380AC")
    public void invalidate() {
        this.authScheme = null;
        this.authScope = null;
        this.credentials = null;
        // ---------- Original Method ----------
        //this.authScheme = null;
        //this.authScope = null;
        //this.credentials = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.766 -0400", hash_original_method = "62DF5636D6479423C69AE868EF58D0CB", hash_generated_method = "E06B9AA84593EB7FA5787A776725C9E5")
    public boolean isValid() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_251129287 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_251129287;
        // ---------- Original Method ----------
        //return this.authScheme != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.767 -0400", hash_original_method = "B1DDF15E8AF9EFEA4D87152524FB22A7", hash_generated_method = "D7D515A27842BB230A63BC54B6C96EE2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.767 -0400", hash_original_method = "C7CF977B6EF3E7F983B2AE16A4014379", hash_generated_method = "DA7A8BEC95490D44EDCBA45AB628F08F")
    public AuthScheme getAuthScheme() {
        AuthScheme varB4EAC82CA7396A68D541C85D26508E83_545278649 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_545278649 = this.authScheme;
        varB4EAC82CA7396A68D541C85D26508E83_545278649.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_545278649;
        // ---------- Original Method ----------
        //return this.authScheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.768 -0400", hash_original_method = "57CD79A3968806BAC032754AA40A41DA", hash_generated_method = "EE69EFB80A15447BA02735A77E461C40")
    public Credentials getCredentials() {
        Credentials varB4EAC82CA7396A68D541C85D26508E83_647365584 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_647365584 = this.credentials;
        varB4EAC82CA7396A68D541C85D26508E83_647365584.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_647365584;
        // ---------- Original Method ----------
        //return this.credentials;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.768 -0400", hash_original_method = "CA0BD3D3E2D3BF9E673535ADF196F87D", hash_generated_method = "3DD02DA100E700462E960E48422CA3F9")
    public void setCredentials(final Credentials credentials) {
        this.credentials = credentials;
        // ---------- Original Method ----------
        //this.credentials = credentials;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.768 -0400", hash_original_method = "BF313F23BCC888676D9F0166A2639A73", hash_generated_method = "9A2E388AADF6EA4D0E6332F1D6566230")
    public AuthScope getAuthScope() {
        AuthScope varB4EAC82CA7396A68D541C85D26508E83_1312158736 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1312158736 = this.authScope;
        varB4EAC82CA7396A68D541C85D26508E83_1312158736.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1312158736;
        // ---------- Original Method ----------
        //return this.authScope;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.769 -0400", hash_original_method = "608941030C588F83A6C921F3D04280DF", hash_generated_method = "7D1366DFB32085A799B9EEC519DF7012")
    public void setAuthScope(final AuthScope authScope) {
        this.authScope = authScope;
        // ---------- Original Method ----------
        //this.authScope = authScope;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.770 -0400", hash_original_method = "CD2C06D38ABEB8110AC037A3B94BECA0", hash_generated_method = "B23BDFBAAE39AEC87240B1980C33E104")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1826031063 = null; //Variable for return #1
        StringBuilder buffer;
        buffer = new StringBuilder();
        buffer.append("auth scope [");
        buffer.append(this.authScope);
        buffer.append("]; credentials set [");
        buffer.append(this.credentials != null ? "true" : "false");
        buffer.append("]");
        varB4EAC82CA7396A68D541C85D26508E83_1826031063 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1826031063.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1826031063;
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

