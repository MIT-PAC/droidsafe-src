package org.apache.http.auth;

// Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.helpers.*;

import droidsafe.runtime.*;
import java.security.Principal;
import org.apache.http.util.LangUtils;

public class UsernamePasswordCredentials implements Credentials {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.107 -0400", hash_original_field = "E7D715A9B79D263AE527955341BBE9B1", hash_generated_field = "F686C01E11EE32E33613A169940ADF19")

    private BasicUserPrincipal principal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.123 -0400", hash_original_field = "5F4DCC3B5AA765D61D8327DEB882CF99", hash_generated_field = "690A5FCB6F6469C4B045B751039E14AE")

    private String password;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.146 -0400", hash_original_method = "3728C308DDC1875044F9155978A28028", hash_generated_method = "B63FFC1ADCF4051569133B97568DBAF2")
    public  UsernamePasswordCredentials(String usernamePassword) {
        super();
        if(usernamePassword == null)        
        {
            IllegalArgumentException var75E7ABC37C3C937D37FA4FDECF2B9005_83108539 = new IllegalArgumentException("Username:password string may not be null");
            var75E7ABC37C3C937D37FA4FDECF2B9005_83108539.addTaint(taint);
            throw var75E7ABC37C3C937D37FA4FDECF2B9005_83108539;
        } //End block
        int atColon = usernamePassword.indexOf(':');
        if(atColon >= 0)        
        {
            this.principal = new BasicUserPrincipal(usernamePassword.substring(0, atColon));
            this.password = usernamePassword.substring(atColon + 1);
        } //End block
        else
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.161 -0400", hash_original_method = "214A596E68D335B6B76C9680AF9532F2", hash_generated_method = "57D70B64FF925EB3247E3163865338D8")
    public  UsernamePasswordCredentials(String userName, String password) {
        super();
        if(userName == null)        
        {
            IllegalArgumentException varA0F831CE07E627C82B4FE3D833EA46C6_1231699145 = new IllegalArgumentException("Username may not be null");
            varA0F831CE07E627C82B4FE3D833EA46C6_1231699145.addTaint(taint);
            throw varA0F831CE07E627C82B4FE3D833EA46C6_1231699145;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.168 -0400", hash_original_method = "BB172E7710F2C6896B8F9EADD44CB225", hash_generated_method = "B205387E5927A8CADBC49236802978C8")
    public Principal getUserPrincipal() {
Principal varA4EE1AD4A5765C52734A508323BADA56_888939726 =         this.principal;
        varA4EE1AD4A5765C52734A508323BADA56_888939726.addTaint(taint);
        return varA4EE1AD4A5765C52734A508323BADA56_888939726;
        // ---------- Original Method ----------
        //return this.principal;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.178 -0400", hash_original_method = "6347097AADB7B31CC60D07DB2FA74ADC", hash_generated_method = "D22C3DB73EF915FE100B508890E17724")
    public String getUserName() {
String var645820FD954E697A3E19AB60B789C574_653362428 =         this.principal.getName();
        var645820FD954E697A3E19AB60B789C574_653362428.addTaint(taint);
        return var645820FD954E697A3E19AB60B789C574_653362428;
        // ---------- Original Method ----------
        //return this.principal.getName();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.184 -0400", hash_original_method = "9DBD0BEF507048073F2256BD69D03A45", hash_generated_method = "997C4E52264C582EF24BCF66B96D9B11")
    public String getPassword() {
String var8371B008E722D01F0CA3A116DA23853F_1175400134 =         password;
        var8371B008E722D01F0CA3A116DA23853F_1175400134.addTaint(taint);
        return var8371B008E722D01F0CA3A116DA23853F_1175400134;
        // ---------- Original Method ----------
        //return password;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.190 -0400", hash_original_method = "5706D3CF5C9B96E72AB79DF75196B0CC", hash_generated_method = "814A4AF1BFB30DAEA083B4B2FC891C53")
    @Override
    public int hashCode() {
        int varE400A445D2E3A0393CF99EFBA65EB901_1502797995 = (this.principal.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_454231671 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_454231671;
        // ---------- Original Method ----------
        //return this.principal.hashCode();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.200 -0400", hash_original_method = "A404630EB6A67A8A7586EF96E1D8B3C7", hash_generated_method = "5AD64D3980D314B7F7771C23695FC421")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        if(o == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_2016330331 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2052821685 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2052821685;
        }
        if(this == o)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_213418989 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1008632506 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1008632506;
        }
        if(o instanceof UsernamePasswordCredentials)        
        {
            UsernamePasswordCredentials that = (UsernamePasswordCredentials) o;
            if(LangUtils.equals(this.principal, that.principal))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_698790298 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1966294638 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1966294638;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_851609492 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1295074843 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1295074843;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.211 -0400", hash_original_method = "55E8D51693AC55264ABFBD18A6F31F91", hash_generated_method = "F6381E5EC5795893BAFA5F57C6BEF60E")
    @Override
    public String toString() {
String varE1A0147196ABC95C2B5B6F778C31E3DC_1553056191 =         this.principal.toString();
        varE1A0147196ABC95C2B5B6F778C31E3DC_1553056191.addTaint(taint);
        return varE1A0147196ABC95C2B5B6F778C31E3DC_1553056191;
        // ---------- Original Method ----------
        //return this.principal.toString();
    }

    
}

