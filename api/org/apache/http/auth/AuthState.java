package org.apache.http.auth;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class AuthState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.374 -0500", hash_original_field = "91E690EEF42A939FE7DD8AED9D5FDB64", hash_generated_field = "BD9BCA899CE487533F83BB63B68D9949")

    private AuthScheme authScheme;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.375 -0500", hash_original_field = "66FC8997E9F1ABED49D8750FAACAF1B0", hash_generated_field = "D3EB159289FA6A5F760C58B08C36D985")

    private AuthScope authScope;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.375 -0500", hash_original_field = "98D4768B33AC8E92FED138E189AE0189", hash_generated_field = "80CCC649DBABDA6B9444725B03E08041")

    private Credentials credentials;
    
    /**
     * Default constructor.
     * 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.376 -0500", hash_original_method = "42AD4E0626C603EC8E908340F6792E72", hash_generated_method = "CD5A41D7B6E8944446C7181525AF6289")
    public AuthState() {
        super();
    }

    /**
     * Invalidates the authentication state by resetting its parameters.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.377 -0500", hash_original_method = "2D3305654C6E379145E705984DE22DF2", hash_generated_method = "5570DE3BCBE6276A5E09638DE2DD058C")
    public void invalidate() {
        this.authScheme = null;
        this.authScope = null;
        this.credentials = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.378 -0500", hash_original_method = "62DF5636D6479423C69AE868EF58D0CB", hash_generated_method = "5A09D7428DA933419450A5E689692C7A")
    public boolean isValid() {
        return this.authScheme != null;
    }
    
    /**
     * Assigns the given {@link AuthScheme authentication scheme}.
     * 
     * @param authScheme the {@link AuthScheme authentication scheme}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.379 -0500", hash_original_method = "B1DDF15E8AF9EFEA4D87152524FB22A7", hash_generated_method = "FF972CF2BCAD71FDCF0B6788AE79E076")
    public void setAuthScheme(final AuthScheme authScheme) {
        if (authScheme == null) {
            invalidate();
            return;
        }
        this.authScheme = authScheme;
    }

    /**
     * Returns the {@link AuthScheme authentication scheme}.
     * 
     * @return {@link AuthScheme authentication scheme}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.379 -0500", hash_original_method = "C7CF977B6EF3E7F983B2AE16A4014379", hash_generated_method = "1D8B8A090266D18EC10416DB7F2651EB")
    public AuthScheme getAuthScheme() {
        return this.authScheme;
    }
    
    
    /** 
     * Returns user {@link Credentials} selected for authentication if available
     * 
     * @return user credentials if available, <code>null</code otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.380 -0500", hash_original_method = "57CD79A3968806BAC032754AA40A41DA", hash_generated_method = "38D007598656000EB67CFC934EFB819F")
    public Credentials getCredentials() {
        return this.credentials;
    }

    
    /** 
     * Sets user {@link Credentials} to be used for authentication
     * 
     * @param credentials User credentials
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.381 -0500", hash_original_method = "CA0BD3D3E2D3BF9E673535ADF196F87D", hash_generated_method = "5135CEE9E8D734C4B578E3F3E78609F1")
    public void setCredentials(final Credentials credentials) {
        this.credentials = credentials;
    }


    /** 
     * Returns actual {@link AuthScope} if available
     * 
     * @return actual authentication scope if available, <code>null</code otherwise
     */
     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.382 -0500", hash_original_method = "BF313F23BCC888676D9F0166A2639A73", hash_generated_method = "B2EF6C42DF166ECED5736B231AAFF90E")
    public AuthScope getAuthScope() {
        return this.authScope;
     }

     /** 
      * Sets actual {@link AuthScope}.
      * 
      * @param authScope Authentication scope
      */
     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.383 -0500", hash_original_method = "608941030C588F83A6C921F3D04280DF", hash_generated_method = "78C833521E6521DD2920EFC6E5DEE8AB")
    public void setAuthScope(final AuthScope authScope) {
        this.authScope = authScope;
     }

     
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.384 -0500", hash_original_method = "CD2C06D38ABEB8110AC037A3B94BECA0", hash_generated_method = "F37DB38818C4B1AFDF67CBBAC2647BEE")
    @Override
public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append("auth scope [");
        buffer.append(this.authScope);
        buffer.append("]; credentials set [");
        buffer.append(this.credentials != null ? "true" : "false");
        buffer.append("]");
        return buffer.toString();
    }

    
}

