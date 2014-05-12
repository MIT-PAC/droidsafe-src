package org.apache.http.auth;

// Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.helpers.*;

import droidsafe.runtime.*;
import java.security.Principal;
import org.apache.http.util.LangUtils;

public class UsernamePasswordCredentials implements Credentials {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.382 -0500", hash_original_field = "F93842AFCA5096FA57DD8770403FD97C", hash_generated_field = "F686C01E11EE32E33613A169940ADF19")

    private  BasicUserPrincipal principal;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.384 -0500", hash_original_field = "2AFEDC818D0EF3384B2D2537704E6E21", hash_generated_field = "690A5FCB6F6469C4B045B751039E14AE")

    private  String password;
     
    /**
     * The constructor with the username and password combined string argument.
     *
     * @param usernamePassword the username:password formed string
     * @see #toString
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.387 -0500", hash_original_method = "3728C308DDC1875044F9155978A28028", hash_generated_method = "C572CC27D20A5C8C052D2D08A429D4AA")
    
public UsernamePasswordCredentials(String usernamePassword) {
        super();
        if (usernamePassword == null) {
            throw new IllegalArgumentException("Username:password string may not be null");            
        }
        int atColon = usernamePassword.indexOf(':');
        if (atColon >= 0) {
            this.principal = new BasicUserPrincipal(usernamePassword.substring(0, atColon));
            this.password = usernamePassword.substring(atColon + 1);
        } else {
            this.principal = new BasicUserPrincipal(usernamePassword);
            this.password = null;
        }
    }

    /**
     * The constructor with the username and password arguments.
     *
     * @param userName the user name
     * @param password the password
     */
    @DSComment("no suspicious activity, only creates object")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.395 -0500", hash_original_method = "214A596E68D335B6B76C9680AF9532F2", hash_generated_method = "4FBEE594BDCE02B0031C333C9D820FDC")
    
public UsernamePasswordCredentials(String userName, String password) {
        super();
        if (userName == null) {
            throw new IllegalArgumentException("Username may not be null");            
        }
        this.principal = new BasicUserPrincipal(userName);
        this.password = password;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.398 -0500", hash_original_method = "BB172E7710F2C6896B8F9EADD44CB225", hash_generated_method = "A41C8FC17036BC805EB11F650E75E163")
    
public Principal getUserPrincipal() {
        return this.principal;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.400 -0500", hash_original_method = "6347097AADB7B31CC60D07DB2FA74ADC", hash_generated_method = "2209C780968F133DA4040FC6ACC8C215")
    
public String getUserName() {
        return this.principal.getName();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.403 -0500", hash_original_method = "9DBD0BEF507048073F2256BD69D03A45", hash_generated_method = "3422D16EB2EB2FA3C8F125F717D7CA7E")
    
public String getPassword() {
        return password;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.405 -0500", hash_original_method = "5706D3CF5C9B96E72AB79DF75196B0CC", hash_generated_method = "E9415AC900696208422A480BFD414B4D")
    
@Override
    public int hashCode() {
        return this.principal.hashCode();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.408 -0500", hash_original_method = "A404630EB6A67A8A7586EF96E1D8B3C7", hash_generated_method = "4443CE4BA3F4B8331E98C5D19A3B91E4")
    
@Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (o instanceof UsernamePasswordCredentials) {
            UsernamePasswordCredentials that = (UsernamePasswordCredentials) o;
            if (LangUtils.equals(this.principal, that.principal)) {
                return true;
            }
        }
        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:30.411 -0500", hash_original_method = "55E8D51693AC55264ABFBD18A6F31F91", hash_generated_method = "D39539D32F47AC5C651B46D55227C39D")
    
@Override
    public String toString() {
        return this.principal.toString();
    }
    
}

