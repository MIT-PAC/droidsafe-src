package gov.nist.javax.sip.address;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.core.*;

public class Authority extends NetObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.035 -0400", hash_original_field = "49F2258E7805F5114B9F128DEA103237", hash_generated_field = "E3D0876BE26B08994B6482E2303E79F8")

    protected HostPort hostPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.035 -0400", hash_original_field = "49F290D6E8459C53F31F97DE37921086", hash_generated_field = "57D80508218E6D78D40A7308D7B8E3EC")

    protected UserInfo userInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.035 -0400", hash_original_method = "29F4443983F8620AB75DA78FB49F743F", hash_generated_method = "29F4443983F8620AB75DA78FB49F743F")
    public Authority ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.036 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "709BCC1B9209953E16881CA178069D17")
    public String encode() {
String var678B6FE61D54E5BD4E109D01C318C133_1697606388 =         encode(new StringBuffer()).toString();
        var678B6FE61D54E5BD4E109D01C318C133_1697606388.addTaint(taint);
        return var678B6FE61D54E5BD4E109D01C318C133_1697606388;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.036 -0400", hash_original_method = "FAE680A5CA07F26487D44D1B3D4D213C", hash_generated_method = "7FB8C76EB26C6C7A7CF9DD536AB574DB")
    public StringBuffer encode(StringBuffer buffer) {
        addTaint(buffer.getTaint());
    if(userInfo != null)        
        {
            userInfo.encode(buffer);
            buffer.append(AT);
            hostPort.encode(buffer);
        } 
        else
        {
            hostPort.encode(buffer);
        } 
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_560654976 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_560654976.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_560654976;
        
        
            
            
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.037 -0400", hash_original_method = "B8EA6629A21322DA3947DE0C5AE42A40", hash_generated_method = "FA2F8D2D3250922479888E8ABF65B393")
    @Override
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(other == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1814017874 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1527642030 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1527642030;
        }
    if(other.getClass() != getClass())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1420331895 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1588849138 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1588849138;
        } 
        Authority otherAuth = (Authority) other;
    if(!this.hostPort.equals(otherAuth.hostPort))        
        {
            boolean var68934A3E9455FA72420237EB05902327_335933622 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_846022784 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_846022784;
        } 
    if(this.userInfo != null && otherAuth.userInfo != null)        
        {
    if(!this.userInfo.equals(otherAuth.userInfo))            
            {
                boolean var68934A3E9455FA72420237EB05902327_355212452 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1946015121 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1946015121;
            } 
        } 
        boolean varB326B5062B2F0E69046810717534CB09_1435920633 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_728652468 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_728652468;
        
        
        
            
        
        
        
            
        
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.038 -0400", hash_original_method = "96FAFC3A7A03957C239B3F2891116715", hash_generated_method = "C9DD935C8FA9516A7B7C8E01C8686934")
    public HostPort getHostPort() {
HostPort varC69BCF37E6F4CB44985D44EE2B636B42_1050713339 =         hostPort;
        varC69BCF37E6F4CB44985D44EE2B636B42_1050713339.addTaint(taint);
        return varC69BCF37E6F4CB44985D44EE2B636B42_1050713339;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.038 -0400", hash_original_method = "7432173A73E0C28FDB3243D392049BFB", hash_generated_method = "B84AE8BCE2D42CB92DC2FC7B559292FF")
    public UserInfo getUserInfo() {
UserInfo varBCE8ED9572054839A8E4DF19F3B230E6_874805107 =         userInfo;
        varBCE8ED9572054839A8E4DF19F3B230E6_874805107.addTaint(taint);
        return varBCE8ED9572054839A8E4DF19F3B230E6_874805107;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.038 -0400", hash_original_method = "0D75875975A37063C0158825ECC49152", hash_generated_method = "B3EFC112A56A7BAA0FD27DF05AE43B1C")
    public String getPassword() {
    if(userInfo == null)        
        {
String var540C13E9E156B687226421B24F2DF178_357486859 =         null;
        var540C13E9E156B687226421B24F2DF178_357486859.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_357486859;
        }
        else
        {
String varF14E064AD47F65E107652DE288491D5A_1784201055 =         userInfo.password;
        varF14E064AD47F65E107652DE288491D5A_1784201055.addTaint(taint);
        return varF14E064AD47F65E107652DE288491D5A_1784201055;
        }
        
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.039 -0400", hash_original_method = "A937EFB3E6E8C8E07C44A0CAF1D94D2D", hash_generated_method = "5A139A4B14172AEE05845DBAFE140171")
    public String getUser() {
String var31E056143C78D6E6129B1F4C8736AA40_1320541940 =         userInfo != null ? userInfo.user : null;
        var31E056143C78D6E6129B1F4C8736AA40_1320541940.addTaint(taint);
        return var31E056143C78D6E6129B1F4C8736AA40_1320541940;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.039 -0400", hash_original_method = "36AABAF7F60E6F4B05DBAF6E2BFF1DAC", hash_generated_method = "07DE51119A7238096318FF0116133F3B")
    public Host getHost() {
    if(hostPort == null)        
        {
Host var540C13E9E156B687226421B24F2DF178_176333945 =         null;
        var540C13E9E156B687226421B24F2DF178_176333945.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_176333945;
        }
        else
        {
Host varC61FD8E4ECACCEF1005E4A1D852E769B_478296858 =         hostPort.getHost();
        varC61FD8E4ECACCEF1005E4A1D852E769B_478296858.addTaint(taint);
        return varC61FD8E4ECACCEF1005E4A1D852E769B_478296858;
        }
        
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.039 -0400", hash_original_method = "94F38CD1718C7E4E03E245C5A4A2F71A", hash_generated_method = "BB9479997C4A732B78FC9F779E071E9D")
    public int getPort() {
    if(hostPort == null)        
        {
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1398262465 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1056787204 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1056787204;
        }
        else
        {
        int varD636CA45A4AF5DE37473FCFB52613B84_1595553255 = (hostPort.getPort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1668818671 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1668818671;
        }
        
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.040 -0400", hash_original_method = "03A0EAC86168733AADB73171D9F2D86A", hash_generated_method = "468D076FBFE9279FCFB5937FE7962A07")
    public void removePort() {
    if(hostPort != null)        
        hostPort.removePort();
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.040 -0400", hash_original_method = "8346E0D819EDE7DDC699DC8693996508", hash_generated_method = "BAA16AFA453B6666BE97F4D9F7070413")
    public void setPassword(String passwd) {
        addTaint(passwd.getTaint());
    if(userInfo == null)        
        userInfo = new UserInfo();
        userInfo.setPassword(passwd);
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.041 -0400", hash_original_method = "0EF31135B34CFA44FF4FE8878DF2C9B5", hash_generated_method = "36F37FEBBC3A006EA49DACDF242828B0")
    public void setUser(String user) {
        addTaint(user.getTaint());
    if(userInfo == null)        
        userInfo = new UserInfo();
        this.userInfo.setUser(user);
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.041 -0400", hash_original_method = "201068C9F082E3325F0A6DFD9E3C4A4F", hash_generated_method = "969E84364A5812E77EE8BFDC29C47EDF")
    public void setHost(Host host) {
        addTaint(host.getTaint());
    if(hostPort == null)        
        hostPort = new HostPort();
        hostPort.setHost(host);
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.042 -0400", hash_original_method = "3BD3C551AB75CBED14D6B43386D78BE7", hash_generated_method = "D4415A7A4A8A500E619F7E687FEEBC90")
    public void setPort(int port) {
        addTaint(port);
    if(hostPort == null)        
        hostPort = new HostPort();
        hostPort.setPort(port);
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.042 -0400", hash_original_method = "D8F21BCC66A176F57688F337D1095243", hash_generated_method = "B745BD321C9016470F27FA9AECB556E7")
    public void setHostPort(HostPort h) {
        hostPort = h;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.042 -0400", hash_original_method = "108550F6AB3E82CA87F2AE105EB44E65", hash_generated_method = "A34790455365BCD424DE7999BCD46105")
    public void setUserInfo(UserInfo u) {
        userInfo = u;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.043 -0400", hash_original_method = "92EC2CE878476F294B46126B230CFAA0", hash_generated_method = "FAD43CE7B46962FC334CBF7E370A70DE")
    public void removeUserInfo() {
        this.userInfo = null;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.043 -0400", hash_original_method = "7BE32291F5E6B71E31FC3F9305E1CD28", hash_generated_method = "0FFC238EAC173A8DEB48F52F456BBF85")
    public Object clone() {
        Authority retval = (Authority) super.clone();
    if(this.hostPort != null)        
        retval.hostPort = (HostPort) this.hostPort.clone();
    if(this.userInfo != null)        
        retval.userInfo = (UserInfo) this.userInfo.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_1703225227 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1703225227.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1703225227;
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.044 -0400", hash_original_method = "1A4F7C0F8CD9FB9B3174AB163DBDBDD1", hash_generated_method = "97E4EFE94EAE2137D2004BF1236A9274")
    @Override
    public int hashCode() {
    if(this.hostPort == null)        
        {
        UnsupportedOperationException var822900E0B2A7E1DCB9C45EBB49FE0FB5_390956493 = new UnsupportedOperationException("Null hostPort cannot compute hashcode");
        var822900E0B2A7E1DCB9C45EBB49FE0FB5_390956493.addTaint(taint);
        throw var822900E0B2A7E1DCB9C45EBB49FE0FB5_390956493;
        }
        int var7ABF06F5CDB72087A23B2AC4B1B967C1_1968067740 = (this.hostPort.encode().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1581221058 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1581221058;
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.044 -0400", hash_original_field = "3A34C83A02A60E6C75C2BC7FEDB12B10", hash_generated_field = "392436036450DA670DF3C59C429C18F7")

    private static final long serialVersionUID = -3570349777347017894L;
}

