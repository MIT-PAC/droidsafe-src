package org.apache.http.auth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class AuthState {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.073 -0400", hash_original_field = "4929F7972D41B5CCD4EDC2D87BC594B6", hash_generated_field = "BD9BCA899CE487533F83BB63B68D9949")

    private AuthScheme authScheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.073 -0400", hash_original_field = "58EC6F20D429B755132D90C27CF86926", hash_generated_field = "D3EB159289FA6A5F760C58B08C36D985")

    private AuthScope authScope;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.073 -0400", hash_original_field = "D3ED68F7315B7E72B8D886B2278FCAC3", hash_generated_field = "80CCC649DBABDA6B9444725B03E08041")

    private Credentials credentials;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.074 -0400", hash_original_method = "42AD4E0626C603EC8E908340F6792E72", hash_generated_method = "141CC616389653FC1DF842DB00A69935")
    public  AuthState() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.074 -0400", hash_original_method = "2D3305654C6E379145E705984DE22DF2", hash_generated_method = "A55C2F4BEB1F546A14687031FC4380AC")
    public void invalidate() {
        this.authScheme = null;
        this.authScope = null;
        this.credentials = null;
        // ---------- Original Method ----------
        //this.authScheme = null;
        //this.authScope = null;
        //this.credentials = null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.075 -0400", hash_original_method = "62DF5636D6479423C69AE868EF58D0CB", hash_generated_method = "C68950DBC9078029492D23009FD0A761")
    public boolean isValid() {
        boolean var39BA64E82F9B5713830B802AFB9B26E6_476310465 = (this.authScheme != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1299845364 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1299845364;
        // ---------- Original Method ----------
        //return this.authScheme != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.075 -0400", hash_original_method = "B1DDF15E8AF9EFEA4D87152524FB22A7", hash_generated_method = "9926E88780E110508DD1F150CE516DE0")
    public void setAuthScheme(final AuthScheme authScheme) {
    if(authScheme == null)        
        {
            invalidate();
            return;
        } //End block
        this.authScheme = authScheme;
        // ---------- Original Method ----------
        //if (authScheme == null) {
            //invalidate();
            //return;
        //}
        //this.authScheme = authScheme;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.075 -0400", hash_original_method = "C7CF977B6EF3E7F983B2AE16A4014379", hash_generated_method = "39A6DFB494047ACE567A8979751E9710")
    public AuthScheme getAuthScheme() {
AuthScheme varFB30DC0C87E790EC49F215A7155CDA43_751226765 =         this.authScheme;
        varFB30DC0C87E790EC49F215A7155CDA43_751226765.addTaint(taint);
        return varFB30DC0C87E790EC49F215A7155CDA43_751226765;
        // ---------- Original Method ----------
        //return this.authScheme;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.076 -0400", hash_original_method = "57CD79A3968806BAC032754AA40A41DA", hash_generated_method = "19DF125216FD75D5D587F5BF8139D923")
    public Credentials getCredentials() {
Credentials var64342BF7968F6111C1E5BB4D3DAC5D79_1675954847 =         this.credentials;
        var64342BF7968F6111C1E5BB4D3DAC5D79_1675954847.addTaint(taint);
        return var64342BF7968F6111C1E5BB4D3DAC5D79_1675954847;
        // ---------- Original Method ----------
        //return this.credentials;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.076 -0400", hash_original_method = "CA0BD3D3E2D3BF9E673535ADF196F87D", hash_generated_method = "3DD02DA100E700462E960E48422CA3F9")
    public void setCredentials(final Credentials credentials) {
        this.credentials = credentials;
        // ---------- Original Method ----------
        //this.credentials = credentials;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.076 -0400", hash_original_method = "BF313F23BCC888676D9F0166A2639A73", hash_generated_method = "A9B2966F17B38C6F4BCCBCB718197860")
    public AuthScope getAuthScope() {
AuthScope varB0B030A52916F692F297266F102C8281_375739345 =         this.authScope;
        varB0B030A52916F692F297266F102C8281_375739345.addTaint(taint);
        return varB0B030A52916F692F297266F102C8281_375739345;
        // ---------- Original Method ----------
        //return this.authScope;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.077 -0400", hash_original_method = "608941030C588F83A6C921F3D04280DF", hash_generated_method = "7D1366DFB32085A799B9EEC519DF7012")
    public void setAuthScope(final AuthScope authScope) {
        this.authScope = authScope;
        // ---------- Original Method ----------
        //this.authScope = authScope;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.077 -0400", hash_original_method = "CD2C06D38ABEB8110AC037A3B94BECA0", hash_generated_method = "67D8A2936C9625C58E19B90B21D87D69")
    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("auth scope [");
        buffer.append(this.authScope);
        buffer.append("]; credentials set [");
        buffer.append(this.credentials != null ? "true" : "false");
        buffer.append("]");
String varD03843288D33B9E1D3062E25339ECF6D_731428250 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_731428250.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_731428250;
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

