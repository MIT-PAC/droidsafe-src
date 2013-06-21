package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.*;

public class Authority extends NetObject {
    protected HostPort hostPort;
    protected UserInfo userInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.372 -0400", hash_original_method = "58ABFDF570F03A468A23F7D00620F794", hash_generated_method = "58ABFDF570F03A468A23F7D00620F794")
        public Authority ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.372 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "091E80AE8192734F0C2711A4E8CB5A26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encode() {
        String varFFB45C40AF627644780ECFF5921CFE15_483497782 = (encode(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.373 -0400", hash_original_method = "FAE680A5CA07F26487D44D1B3D4D213C", hash_generated_method = "CA4B2754CEA1A554911CDA3150165B88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer encode(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        {
            userInfo.encode(buffer);
            buffer.append(AT);
            hostPort.encode(buffer);
        } //End block
        {
            hostPort.encode(buffer);
        } //End block
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (userInfo != null) {
            //userInfo.encode(buffer);
            //buffer.append(AT);
            //hostPort.encode(buffer);
        //} else {
            //hostPort.encode(buffer);
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.373 -0400", hash_original_method = "B8EA6629A21322DA3947DE0C5AE42A40", hash_generated_method = "90636E826D5FD9C5D08CF614A5CAF1BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            boolean varBCFF74C4EC650CC46A218C4FB3AF1C23_1553675965 = (other.getClass() != getClass());
        } //End collapsed parenthetic
        Authority otherAuth;
        otherAuth = (Authority) other;
        {
            boolean varD6CA791ABA172ED81C3844866E9137CC_1682258641 = (!this.hostPort.equals(otherAuth.hostPort));
        } //End collapsed parenthetic
        {
            {
                boolean varF575B78950222F8AAFC7D2AE139F0844_1727053051 = (!this.userInfo.equals(otherAuth.userInfo));
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (other == null) return false;
        //if (other.getClass() != getClass()) {
            //return false;
        //}
        //Authority otherAuth = (Authority) other;
        //if (!this.hostPort.equals(otherAuth.hostPort)) {
            //return false;
        //}
        //if (this.userInfo != null && otherAuth.userInfo != null) {
            //if (!this.userInfo.equals(otherAuth.userInfo)) {
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.373 -0400", hash_original_method = "96FAFC3A7A03957C239B3F2891116715", hash_generated_method = "8AF7D07C0C05ACD07CF77232D14A5811")
    @DSModeled(DSC.SAFE)
    public HostPort getHostPort() {
        return (HostPort)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return hostPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.373 -0400", hash_original_method = "7432173A73E0C28FDB3243D392049BFB", hash_generated_method = "73EF7DB19E2036D573A984533BE1A070")
    @DSModeled(DSC.SAFE)
    public UserInfo getUserInfo() {
        return (UserInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return userInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.373 -0400", hash_original_method = "0D75875975A37063C0158825ECC49152", hash_generated_method = "4C5FD1209D30C5A395085C340A71C246")
    @DSModeled(DSC.SAFE)
    public String getPassword() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (userInfo == null)
            //return null;
        //else
            //return userInfo.password;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.374 -0400", hash_original_method = "A937EFB3E6E8C8E07C44A0CAF1D94D2D", hash_generated_method = "157C6F7D9D58A0F94A18C0168AB6A544")
    @DSModeled(DSC.SAFE)
    public String getUser() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return userInfo != null ? userInfo.user : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.374 -0400", hash_original_method = "36AABAF7F60E6F4B05DBAF6E2BFF1DAC", hash_generated_method = "860951D9037891E30C48F8F0F47F38A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Host getHost() {
        Host varD3DF73AF572EA7CADD49A5C069515983_515476197 = (hostPort.getHost());
        return (Host)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (hostPort == null)
            //return null;
        //else
            //return hostPort.getHost();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.374 -0400", hash_original_method = "94F38CD1718C7E4E03E245C5A4A2F71A", hash_generated_method = "3BA3A7BF786ECB6DC5928887BD186963")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getPort() {
        int varE20CC0FC720F4ED394AC344E2BF47690_1088832558 = (hostPort.getPort());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (hostPort == null)
            //return -1;
        //else
            //return hostPort.getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.374 -0400", hash_original_method = "03A0EAC86168733AADB73171D9F2D86A", hash_generated_method = "C14D8A4F04979C1F187834AD19497B03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removePort() {
        hostPort.removePort();
        // ---------- Original Method ----------
        //if (hostPort != null)
            //hostPort.removePort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.374 -0400", hash_original_method = "8346E0D819EDE7DDC699DC8693996508", hash_generated_method = "27116344C7BF70239BE60FF63FEF71BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPassword(String passwd) {
        dsTaint.addTaint(passwd);
        userInfo = new UserInfo();
        userInfo.setPassword(passwd);
        // ---------- Original Method ----------
        //if (userInfo == null)
            //userInfo = new UserInfo();
        //userInfo.setPassword(passwd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.374 -0400", hash_original_method = "0EF31135B34CFA44FF4FE8878DF2C9B5", hash_generated_method = "B018E977F01E0AA086AE399E141E5518")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setUser(String user) {
        dsTaint.addTaint(user);
        userInfo = new UserInfo();
        this.userInfo.setUser(user);
        // ---------- Original Method ----------
        //if (userInfo == null)
            //userInfo = new UserInfo();
        //this.userInfo.setUser(user);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.375 -0400", hash_original_method = "201068C9F082E3325F0A6DFD9E3C4A4F", hash_generated_method = "B80224BFE9B44A4E6F2A281DF72591A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setHost(Host host) {
        dsTaint.addTaint(host.dsTaint);
        hostPort = new HostPort();
        hostPort.setHost(host);
        // ---------- Original Method ----------
        //if (hostPort == null)
            //hostPort = new HostPort();
        //hostPort.setHost(host);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.375 -0400", hash_original_method = "3BD3C551AB75CBED14D6B43386D78BE7", hash_generated_method = "D0AAFCB32C422816A7614255682C9105")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPort(int port) {
        dsTaint.addTaint(port);
        hostPort = new HostPort();
        hostPort.setPort(port);
        // ---------- Original Method ----------
        //if (hostPort == null)
            //hostPort = new HostPort();
        //hostPort.setPort(port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.375 -0400", hash_original_method = "D8F21BCC66A176F57688F337D1095243", hash_generated_method = "9E26FC926A50E32A46A983F9E1473C0A")
    @DSModeled(DSC.SAFE)
    public void setHostPort(HostPort h) {
        dsTaint.addTaint(h.dsTaint);
        // ---------- Original Method ----------
        //hostPort = h;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.375 -0400", hash_original_method = "108550F6AB3E82CA87F2AE105EB44E65", hash_generated_method = "18ABA8543F11F7A6C0096661D89C4FF2")
    @DSModeled(DSC.SAFE)
    public void setUserInfo(UserInfo u) {
        dsTaint.addTaint(u.dsTaint);
        // ---------- Original Method ----------
        //userInfo = u;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.375 -0400", hash_original_method = "92EC2CE878476F294B46126B230CFAA0", hash_generated_method = "FAD43CE7B46962FC334CBF7E370A70DE")
    @DSModeled(DSC.SAFE)
    public void removeUserInfo() {
        this.userInfo = null;
        // ---------- Original Method ----------
        //this.userInfo = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.376 -0400", hash_original_method = "7BE32291F5E6B71E31FC3F9305E1CD28", hash_generated_method = "D563C194B2305E79280F8454546FDB45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        Authority retval;
        retval = (Authority) super.clone();
        retval.hostPort = (HostPort) this.hostPort.clone();
        retval.userInfo = (UserInfo) this.userInfo.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Authority retval = (Authority) super.clone();
        //if (this.hostPort != null)
            //retval.hostPort = (HostPort) this.hostPort.clone();
        //if (this.userInfo != null)
            //retval.userInfo = (UserInfo) this.userInfo.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.376 -0400", hash_original_method = "1A4F7C0F8CD9FB9B3174AB163DBDBDD1", hash_generated_method = "E36AB640DD3C5DA59CC748DC87F463E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Null hostPort cannot compute hashcode");
        int var7F9EE2A0D174F62AF476EACFC04AD62C_1363152747 = (this.hostPort.encode().hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if ( this.hostPort == null ) throw new UnsupportedOperationException("Null hostPort cannot compute hashcode");
        //return this.hostPort.encode().hashCode();
    }

    
    private static final long serialVersionUID = -3570349777347017894L;
}

