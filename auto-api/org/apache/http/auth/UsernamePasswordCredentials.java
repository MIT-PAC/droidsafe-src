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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.810 -0400", hash_original_field = "E7D715A9B79D263AE527955341BBE9B1", hash_generated_field = "F686C01E11EE32E33613A169940ADF19")

    private BasicUserPrincipal principal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.810 -0400", hash_original_field = "5F4DCC3B5AA765D61D8327DEB882CF99", hash_generated_field = "690A5FCB6F6469C4B045B751039E14AE")

    private String password;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.811 -0400", hash_original_method = "3728C308DDC1875044F9155978A28028", hash_generated_method = "DA483985C9C5D90060E8DF4EBC450988")
    public  UsernamePasswordCredentials(String usernamePassword) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Username:password string may not be null");
        } //End block
        int atColon;
        atColon = usernamePassword.indexOf(':');
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.824 -0400", hash_original_method = "214A596E68D335B6B76C9680AF9532F2", hash_generated_method = "A6C52C7FD98FA090F3BC9C5BBE8B6697")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.824 -0400", hash_original_method = "BB172E7710F2C6896B8F9EADD44CB225", hash_generated_method = "0D31C68F12D7526414E75B164F121AC2")
    public Principal getUserPrincipal() {
        Principal varB4EAC82CA7396A68D541C85D26508E83_2033403435 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2033403435 = this.principal;
        varB4EAC82CA7396A68D541C85D26508E83_2033403435.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2033403435;
        // ---------- Original Method ----------
        //return this.principal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.824 -0400", hash_original_method = "6347097AADB7B31CC60D07DB2FA74ADC", hash_generated_method = "B20BCAD0A58A7EF482BF37265963AE1A")
    public String getUserName() {
        String varB4EAC82CA7396A68D541C85D26508E83_706079337 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_706079337 = this.principal.getName();
        varB4EAC82CA7396A68D541C85D26508E83_706079337.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_706079337;
        // ---------- Original Method ----------
        //return this.principal.getName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.834 -0400", hash_original_method = "9DBD0BEF507048073F2256BD69D03A45", hash_generated_method = "6BBD4746D86085B87E24BA311CB8757A")
    public String getPassword() {
        String varB4EAC82CA7396A68D541C85D26508E83_1576750669 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1576750669 = password;
        varB4EAC82CA7396A68D541C85D26508E83_1576750669.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1576750669;
        // ---------- Original Method ----------
        //return password;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.847 -0400", hash_original_method = "5706D3CF5C9B96E72AB79DF75196B0CC", hash_generated_method = "BF7B86DAE5D9B7890B28F5645FB41BB6")
    @Override
    public int hashCode() {
        int var0985487B1799840C3C4D72177BE5287C_2015796879 = (this.principal.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1360597534 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1360597534;
        // ---------- Original Method ----------
        //return this.principal.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.849 -0400", hash_original_method = "A404630EB6A67A8A7586EF96E1D8B3C7", hash_generated_method = "C3C27DAA59A1F59F8C7101E3CFE73E31")
    @Override
    public boolean equals(Object o) {
        {
            UsernamePasswordCredentials that;
            that = (UsernamePasswordCredentials) o;
            {
                boolean var3A4AD8A7C633E641B4BB314A77C1A712_1298687406 = (LangUtils.equals(this.principal, that.principal));
            } //End collapsed parenthetic
        } //End block
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_538233591 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_538233591;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.860 -0400", hash_original_method = "55E8D51693AC55264ABFBD18A6F31F91", hash_generated_method = "858F96DD0E908E8C66BDBE857646D9C6")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_587643278 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_587643278 = this.principal.toString();
        varB4EAC82CA7396A68D541C85D26508E83_587643278.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_587643278;
        // ---------- Original Method ----------
        //return this.principal.toString();
    }

    
}

