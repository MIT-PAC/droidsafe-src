package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.core.*;

public class Authority extends NetObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.986 -0400", hash_original_field = "49F2258E7805F5114B9F128DEA103237", hash_generated_field = "E3D0876BE26B08994B6482E2303E79F8")

    protected HostPort hostPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.986 -0400", hash_original_field = "49F290D6E8459C53F31F97DE37921086", hash_generated_field = "57D80508218E6D78D40A7308D7B8E3EC")

    protected UserInfo userInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.986 -0400", hash_original_method = "29F4443983F8620AB75DA78FB49F743F", hash_generated_method = "29F4443983F8620AB75DA78FB49F743F")
    public Authority ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.986 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "9185D8E57B2E3CA82A8EDFF8873B9559")
    public String encode() {
String var678B6FE61D54E5BD4E109D01C318C133_1573081841 =         encode(new StringBuffer()).toString();
        var678B6FE61D54E5BD4E109D01C318C133_1573081841.addTaint(taint);
        return var678B6FE61D54E5BD4E109D01C318C133_1573081841;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.988 -0400", hash_original_method = "FAE680A5CA07F26487D44D1B3D4D213C", hash_generated_method = "19B82B1D6EF894E8A3E939C472B52E88")
    public StringBuffer encode(StringBuffer buffer) {
        addTaint(buffer.getTaint());
        if(userInfo != null)        
        {
            userInfo.encode(buffer);
            buffer.append(AT);
            hostPort.encode(buffer);
        } //End block
        else
        {
            hostPort.encode(buffer);
        } //End block
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_1859663457 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_1859663457.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_1859663457;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.990 -0400", hash_original_method = "B8EA6629A21322DA3947DE0C5AE42A40", hash_generated_method = "F9E4A913DDF6350FEDF7FF532A58D76E")
    @Override
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(other == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_563171449 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_530075874 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_530075874;
        }
        if(other.getClass() != getClass())        
        {
            boolean var68934A3E9455FA72420237EB05902327_2005964396 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1675998034 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1675998034;
        } //End block
        Authority otherAuth = (Authority) other;
        if(!this.hostPort.equals(otherAuth.hostPort))        
        {
            boolean var68934A3E9455FA72420237EB05902327_2061314145 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_426518295 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_426518295;
        } //End block
        if(this.userInfo != null && otherAuth.userInfo != null)        
        {
            if(!this.userInfo.equals(otherAuth.userInfo))            
            {
                boolean var68934A3E9455FA72420237EB05902327_654794666 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_946495807 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_946495807;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_460611585 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1830206749 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1830206749;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.991 -0400", hash_original_method = "96FAFC3A7A03957C239B3F2891116715", hash_generated_method = "4CADDD0F3A168F13C9C304F10689514E")
    public HostPort getHostPort() {
HostPort varC69BCF37E6F4CB44985D44EE2B636B42_197196050 =         hostPort;
        varC69BCF37E6F4CB44985D44EE2B636B42_197196050.addTaint(taint);
        return varC69BCF37E6F4CB44985D44EE2B636B42_197196050;
        // ---------- Original Method ----------
        //return hostPort;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.991 -0400", hash_original_method = "7432173A73E0C28FDB3243D392049BFB", hash_generated_method = "7B4E6DC97CF55AAB65464DE54000F38F")
    public UserInfo getUserInfo() {
UserInfo varBCE8ED9572054839A8E4DF19F3B230E6_247922673 =         userInfo;
        varBCE8ED9572054839A8E4DF19F3B230E6_247922673.addTaint(taint);
        return varBCE8ED9572054839A8E4DF19F3B230E6_247922673;
        // ---------- Original Method ----------
        //return userInfo;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.991 -0400", hash_original_method = "0D75875975A37063C0158825ECC49152", hash_generated_method = "83D0267438CD6BE9EC8A3A2E8697DE04")
    public String getPassword() {
        if(userInfo == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1696169303 =         null;
        var540C13E9E156B687226421B24F2DF178_1696169303.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1696169303;
        }
        else
        {
String varF14E064AD47F65E107652DE288491D5A_1473356368 =         userInfo.password;
        varF14E064AD47F65E107652DE288491D5A_1473356368.addTaint(taint);
        return varF14E064AD47F65E107652DE288491D5A_1473356368;
        }
        // ---------- Original Method ----------
        //if (userInfo == null)
            //return null;
        //else
            //return userInfo.password;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.992 -0400", hash_original_method = "A937EFB3E6E8C8E07C44A0CAF1D94D2D", hash_generated_method = "AFAF47C17C99B0326294EBD14020C6E2")
    public String getUser() {
String var31E056143C78D6E6129B1F4C8736AA40_1136582125 =         userInfo != null ? userInfo.user : null;
        var31E056143C78D6E6129B1F4C8736AA40_1136582125.addTaint(taint);
        return var31E056143C78D6E6129B1F4C8736AA40_1136582125;
        // ---------- Original Method ----------
        //return userInfo != null ? userInfo.user : null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.992 -0400", hash_original_method = "36AABAF7F60E6F4B05DBAF6E2BFF1DAC", hash_generated_method = "6809C8F6DE0414A8C13B6C68B7F2EF4C")
    public Host getHost() {
        if(hostPort == null)        
        {
Host var540C13E9E156B687226421B24F2DF178_405285082 =         null;
        var540C13E9E156B687226421B24F2DF178_405285082.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_405285082;
        }
        else
        {
Host varC61FD8E4ECACCEF1005E4A1D852E769B_1183741388 =         hostPort.getHost();
        varC61FD8E4ECACCEF1005E4A1D852E769B_1183741388.addTaint(taint);
        return varC61FD8E4ECACCEF1005E4A1D852E769B_1183741388;
        }
        // ---------- Original Method ----------
        //if (hostPort == null)
            //return null;
        //else
            //return hostPort.getHost();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.993 -0400", hash_original_method = "94F38CD1718C7E4E03E245C5A4A2F71A", hash_generated_method = "EC224A1727C88C4418C6EDE61815502D")
    public int getPort() {
        if(hostPort == null)        
        {
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1839352001 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_36844399 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_36844399;
        }
        else
        {
        int varD636CA45A4AF5DE37473FCFB52613B84_1251860159 = (hostPort.getPort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_121864737 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_121864737;
        }
        // ---------- Original Method ----------
        //if (hostPort == null)
            //return -1;
        //else
            //return hostPort.getPort();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.993 -0400", hash_original_method = "03A0EAC86168733AADB73171D9F2D86A", hash_generated_method = "468D076FBFE9279FCFB5937FE7962A07")
    public void removePort() {
        if(hostPort != null)        
        hostPort.removePort();
        // ---------- Original Method ----------
        //if (hostPort != null)
            //hostPort.removePort();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.994 -0400", hash_original_method = "8346E0D819EDE7DDC699DC8693996508", hash_generated_method = "BAA16AFA453B6666BE97F4D9F7070413")
    public void setPassword(String passwd) {
        addTaint(passwd.getTaint());
        if(userInfo == null)        
        userInfo = new UserInfo();
        userInfo.setPassword(passwd);
        // ---------- Original Method ----------
        //if (userInfo == null)
            //userInfo = new UserInfo();
        //userInfo.setPassword(passwd);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.994 -0400", hash_original_method = "0EF31135B34CFA44FF4FE8878DF2C9B5", hash_generated_method = "36F37FEBBC3A006EA49DACDF242828B0")
    public void setUser(String user) {
        addTaint(user.getTaint());
        if(userInfo == null)        
        userInfo = new UserInfo();
        this.userInfo.setUser(user);
        // ---------- Original Method ----------
        //if (userInfo == null)
            //userInfo = new UserInfo();
        //this.userInfo.setUser(user);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.995 -0400", hash_original_method = "201068C9F082E3325F0A6DFD9E3C4A4F", hash_generated_method = "969E84364A5812E77EE8BFDC29C47EDF")
    public void setHost(Host host) {
        addTaint(host.getTaint());
        if(hostPort == null)        
        hostPort = new HostPort();
        hostPort.setHost(host);
        // ---------- Original Method ----------
        //if (hostPort == null)
            //hostPort = new HostPort();
        //hostPort.setHost(host);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.996 -0400", hash_original_method = "3BD3C551AB75CBED14D6B43386D78BE7", hash_generated_method = "D4415A7A4A8A500E619F7E687FEEBC90")
    public void setPort(int port) {
        addTaint(port);
        if(hostPort == null)        
        hostPort = new HostPort();
        hostPort.setPort(port);
        // ---------- Original Method ----------
        //if (hostPort == null)
            //hostPort = new HostPort();
        //hostPort.setPort(port);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.997 -0400", hash_original_method = "D8F21BCC66A176F57688F337D1095243", hash_generated_method = "B745BD321C9016470F27FA9AECB556E7")
    public void setHostPort(HostPort h) {
        hostPort = h;
        // ---------- Original Method ----------
        //hostPort = h;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.997 -0400", hash_original_method = "108550F6AB3E82CA87F2AE105EB44E65", hash_generated_method = "A34790455365BCD424DE7999BCD46105")
    public void setUserInfo(UserInfo u) {
        userInfo = u;
        // ---------- Original Method ----------
        //userInfo = u;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.998 -0400", hash_original_method = "92EC2CE878476F294B46126B230CFAA0", hash_generated_method = "FAD43CE7B46962FC334CBF7E370A70DE")
    public void removeUserInfo() {
        this.userInfo = null;
        // ---------- Original Method ----------
        //this.userInfo = null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.999 -0400", hash_original_method = "7BE32291F5E6B71E31FC3F9305E1CD28", hash_generated_method = "3B2B2933365540CDA53C4C4C43CD3FC8")
    public Object clone() {
        Authority retval = (Authority) super.clone();
        if(this.hostPort != null)        
        retval.hostPort = (HostPort) this.hostPort.clone();
        if(this.userInfo != null)        
        retval.userInfo = (UserInfo) this.userInfo.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_1550107920 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1550107920.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1550107920;
        // ---------- Original Method ----------
        //Authority retval = (Authority) super.clone();
        //if (this.hostPort != null)
            //retval.hostPort = (HostPort) this.hostPort.clone();
        //if (this.userInfo != null)
            //retval.userInfo = (UserInfo) this.userInfo.clone();
        //return retval;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.000 -0400", hash_original_method = "1A4F7C0F8CD9FB9B3174AB163DBDBDD1", hash_generated_method = "65EF925246CC7808270321DA66D2770D")
    @Override
    public int hashCode() {
        if(this.hostPort == null)        
        {
        UnsupportedOperationException var822900E0B2A7E1DCB9C45EBB49FE0FB5_1816423982 = new UnsupportedOperationException("Null hostPort cannot compute hashcode");
        var822900E0B2A7E1DCB9C45EBB49FE0FB5_1816423982.addTaint(taint);
        throw var822900E0B2A7E1DCB9C45EBB49FE0FB5_1816423982;
        }
        int var7ABF06F5CDB72087A23B2AC4B1B967C1_2096010930 = (this.hostPort.encode().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_373529440 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_373529440;
        // ---------- Original Method ----------
        //if ( this.hostPort == null ) throw new UnsupportedOperationException("Null hostPort cannot compute hashcode");
        //return this.hostPort.encode().hashCode();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.000 -0400", hash_original_field = "3A34C83A02A60E6C75C2BC7FEDB12B10", hash_generated_field = "392436036450DA670DF3C59C429C18F7")

    private static final long serialVersionUID = -3570349777347017894L;
}

