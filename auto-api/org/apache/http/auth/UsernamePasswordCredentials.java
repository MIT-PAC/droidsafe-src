package org.apache.http.auth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.Principal;
import org.apache.http.util.LangUtils;

public class UsernamePasswordCredentials implements Credentials {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.667 -0400", hash_original_field = "E7D715A9B79D263AE527955341BBE9B1", hash_generated_field = "F686C01E11EE32E33613A169940ADF19")

    private BasicUserPrincipal principal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.667 -0400", hash_original_field = "5F4DCC3B5AA765D61D8327DEB882CF99", hash_generated_field = "690A5FCB6F6469C4B045B751039E14AE")

    private String password;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.668 -0400", hash_original_method = "3728C308DDC1875044F9155978A28028", hash_generated_method = "3AFE894330F9217587CB9AD3E25273A1")
    public  UsernamePasswordCredentials(String usernamePassword) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Username:password string may not be null");
        } //End block
        int atColon = usernamePassword.indexOf(':');
        {
            this.principal = new BasicUserPrincipal(usernamePassword.substring(0, atColon));
            this.password = usernamePassword.substring(atColon + 1);
        } //End block
        {
            this.principal = new BasicUserPrincipal(usernamePassword);
            this.password = null;
        } //End block
        // ---------- Original Method ----------
        //if (usernamePassword == null) {
            //throw new IllegalArgumentException("Username:password string may not be null");            
        //}
        //int atColon = usernamePassword.indexOf(':');
        //if (atColon >= 0) {
            //this.principal = new BasicUserPrincipal(usernamePassword.substring(0, atColon));
            //this.password = usernamePassword.substring(atColon + 1);
        //} else {
            //this.principal = new BasicUserPrincipal(usernamePassword);
            //this.password = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.668 -0400", hash_original_method = "214A596E68D335B6B76C9680AF9532F2", hash_generated_method = "A6C52C7FD98FA090F3BC9C5BBE8B6697")
    public  UsernamePasswordCredentials(String userName, String password) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Username may not be null");
        } //End block
        this.principal = new BasicUserPrincipal(userName);
        this.password = password;
        // ---------- Original Method ----------
        //if (userName == null) {
            //throw new IllegalArgumentException("Username may not be null");            
        //}
        //this.principal = new BasicUserPrincipal(userName);
        //this.password = password;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.669 -0400", hash_original_method = "BB172E7710F2C6896B8F9EADD44CB225", hash_generated_method = "6E35974BD256DE407BE463B8AD5D6F86")
    public Principal getUserPrincipal() {
        Principal varB4EAC82CA7396A68D541C85D26508E83_934480254 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_934480254 = this.principal;
        varB4EAC82CA7396A68D541C85D26508E83_934480254.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_934480254;
        // ---------- Original Method ----------
        //return this.principal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.670 -0400", hash_original_method = "6347097AADB7B31CC60D07DB2FA74ADC", hash_generated_method = "5B7D40A310688D190B06B4C8D38A8843")
    public String getUserName() {
        String varB4EAC82CA7396A68D541C85D26508E83_148844738 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_148844738 = this.principal.getName();
        varB4EAC82CA7396A68D541C85D26508E83_148844738.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_148844738;
        // ---------- Original Method ----------
        //return this.principal.getName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.671 -0400", hash_original_method = "9DBD0BEF507048073F2256BD69D03A45", hash_generated_method = "E822F85E657BA7AB1A612E424DCDCBB6")
    public String getPassword() {
        String varB4EAC82CA7396A68D541C85D26508E83_985749785 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_985749785 = password;
        varB4EAC82CA7396A68D541C85D26508E83_985749785.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_985749785;
        // ---------- Original Method ----------
        //return password;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.671 -0400", hash_original_method = "5706D3CF5C9B96E72AB79DF75196B0CC", hash_generated_method = "5E05EF1E31113A19077FD55468AC324B")
    @Override
    public int hashCode() {
        int var0985487B1799840C3C4D72177BE5287C_1140532600 = (this.principal.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_247616642 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_247616642;
        // ---------- Original Method ----------
        //return this.principal.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.672 -0400", hash_original_method = "A404630EB6A67A8A7586EF96E1D8B3C7", hash_generated_method = "29281CA8486351E5E0FCBD5430C4D735")
    @Override
    public boolean equals(Object o) {
        {
            UsernamePasswordCredentials that = (UsernamePasswordCredentials) o;
            {
                boolean var3A4AD8A7C633E641B4BB314A77C1A712_809827678 = (LangUtils.equals(this.principal, that.principal));
            } //End collapsed parenthetic
        } //End block
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1359568901 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1359568901;
        // ---------- Original Method ----------
        //if (o == null) return false;
        //if (this == o) return true;
        //if (o instanceof UsernamePasswordCredentials) {
            //UsernamePasswordCredentials that = (UsernamePasswordCredentials) o;
            //if (LangUtils.equals(this.principal, that.principal)) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.672 -0400", hash_original_method = "55E8D51693AC55264ABFBD18A6F31F91", hash_generated_method = "614EA2757C9FFBA6B38D02836ACBB067")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1858844208 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1858844208 = this.principal.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1858844208.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1858844208;
        // ---------- Original Method ----------
        //return this.principal.toString();
    }

    
}

