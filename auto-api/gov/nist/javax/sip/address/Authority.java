package gov.nist.javax.sip.address;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.core.*;

public class Authority extends NetObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.210 -0400", hash_original_field = "49F2258E7805F5114B9F128DEA103237", hash_generated_field = "E3D0876BE26B08994B6482E2303E79F8")

    protected HostPort hostPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.210 -0400", hash_original_field = "49F290D6E8459C53F31F97DE37921086", hash_generated_field = "57D80508218E6D78D40A7308D7B8E3EC")

    protected UserInfo userInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.210 -0400", hash_original_method = "29F4443983F8620AB75DA78FB49F743F", hash_generated_method = "29F4443983F8620AB75DA78FB49F743F")
    public Authority ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.211 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "1B96C993F299EBB14E27F7239F886521")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_2014305530 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2014305530 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_2014305530.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2014305530;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.211 -0400", hash_original_method = "FAE680A5CA07F26487D44D1B3D4D213C", hash_generated_method = "3103733D014359EEE794860DC81B87BF")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1421285373 = null; 
        {
            userInfo.encode(buffer);
            buffer.append(AT);
            hostPort.encode(buffer);
        } 
        {
            hostPort.encode(buffer);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1421285373 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1421285373.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1421285373;
        
        
            
            
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.212 -0400", hash_original_method = "B8EA6629A21322DA3947DE0C5AE42A40", hash_generated_method = "3B9D22060E869F3FEF981EBD151ADDDF")
    @Override
    public boolean equals(Object other) {
        {
            boolean varBCFF74C4EC650CC46A218C4FB3AF1C23_116750075 = (other.getClass() != getClass());
        } 
        Authority otherAuth = (Authority) other;
        {
            boolean varD6CA791ABA172ED81C3844866E9137CC_626139348 = (!this.hostPort.equals(otherAuth.hostPort));
        } 
        {
            {
                boolean varF575B78950222F8AAFC7D2AE139F0844_579207786 = (!this.userInfo.equals(otherAuth.userInfo));
            } 
        } 
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_330955494 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_330955494;
        
        
        
            
        
        
        
            
        
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.212 -0400", hash_original_method = "96FAFC3A7A03957C239B3F2891116715", hash_generated_method = "018C0C416F19B49CC5BEA9F1FA08557E")
    public HostPort getHostPort() {
        HostPort varB4EAC82CA7396A68D541C85D26508E83_1325236006 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1325236006 = hostPort;
        varB4EAC82CA7396A68D541C85D26508E83_1325236006.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1325236006;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.213 -0400", hash_original_method = "7432173A73E0C28FDB3243D392049BFB", hash_generated_method = "2CB188FBD00996182B3BF4EC54F6DF77")
    public UserInfo getUserInfo() {
        UserInfo varB4EAC82CA7396A68D541C85D26508E83_2026475520 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2026475520 = userInfo;
        varB4EAC82CA7396A68D541C85D26508E83_2026475520.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2026475520;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.213 -0400", hash_original_method = "0D75875975A37063C0158825ECC49152", hash_generated_method = "D03C3354C168B8DBE544303F17B42551")
    public String getPassword() {
        String varB4EAC82CA7396A68D541C85D26508E83_2062931823 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_73984106 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2062931823 = null;
        varB4EAC82CA7396A68D541C85D26508E83_73984106 = userInfo.password;
        String varA7E53CE21691AB073D9660D615818899_552174216; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_552174216 = varB4EAC82CA7396A68D541C85D26508E83_2062931823;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_552174216 = varB4EAC82CA7396A68D541C85D26508E83_73984106;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_552174216.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_552174216;
        
        
            
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.214 -0400", hash_original_method = "A937EFB3E6E8C8E07C44A0CAF1D94D2D", hash_generated_method = "13F4E9C9D2FC4E12F4B43AF57119392C")
    public String getUser() {
        String varB4EAC82CA7396A68D541C85D26508E83_1122385401 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1122385401 = userInfo != null ? userInfo.user : null;
        varB4EAC82CA7396A68D541C85D26508E83_1122385401.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1122385401;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.215 -0400", hash_original_method = "36AABAF7F60E6F4B05DBAF6E2BFF1DAC", hash_generated_method = "54F75D28866C7369A0E2E1D38A65530F")
    public Host getHost() {
        Host varB4EAC82CA7396A68D541C85D26508E83_910900154 = null; 
        Host varB4EAC82CA7396A68D541C85D26508E83_2079886327 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_910900154 = null;
        varB4EAC82CA7396A68D541C85D26508E83_2079886327 = hostPort.getHost();
        Host varA7E53CE21691AB073D9660D615818899_92274117; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_92274117 = varB4EAC82CA7396A68D541C85D26508E83_910900154;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_92274117 = varB4EAC82CA7396A68D541C85D26508E83_2079886327;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_92274117.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_92274117;
        
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.215 -0400", hash_original_method = "94F38CD1718C7E4E03E245C5A4A2F71A", hash_generated_method = "81D846C1D59AA0D541CBCD103F51ED31")
    public int getPort() {
        int varE20CC0FC720F4ED394AC344E2BF47690_263198527 = (hostPort.getPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1155967908 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1155967908;
        
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.216 -0400", hash_original_method = "03A0EAC86168733AADB73171D9F2D86A", hash_generated_method = "C14D8A4F04979C1F187834AD19497B03")
    public void removePort() {
        hostPort.removePort();
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.216 -0400", hash_original_method = "8346E0D819EDE7DDC699DC8693996508", hash_generated_method = "E22F075E0722B10A66F7D6F3CCF357E8")
    public void setPassword(String passwd) {
        userInfo = new UserInfo();
        userInfo.setPassword(passwd);
        addTaint(passwd.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.216 -0400", hash_original_method = "0EF31135B34CFA44FF4FE8878DF2C9B5", hash_generated_method = "276C1314EF7411974385CA5A4AA14F2D")
    public void setUser(String user) {
        userInfo = new UserInfo();
        this.userInfo.setUser(user);
        addTaint(user.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.217 -0400", hash_original_method = "201068C9F082E3325F0A6DFD9E3C4A4F", hash_generated_method = "D3FF73EFB54EAF514CB30E7AC67608C4")
    public void setHost(Host host) {
        hostPort = new HostPort();
        hostPort.setHost(host);
        addTaint(host.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.217 -0400", hash_original_method = "3BD3C551AB75CBED14D6B43386D78BE7", hash_generated_method = "D59BB7ED37E3988956FC06767B5B8BEA")
    public void setPort(int port) {
        hostPort = new HostPort();
        hostPort.setPort(port);
        addTaint(port);
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.217 -0400", hash_original_method = "D8F21BCC66A176F57688F337D1095243", hash_generated_method = "B745BD321C9016470F27FA9AECB556E7")
    public void setHostPort(HostPort h) {
        hostPort = h;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.217 -0400", hash_original_method = "108550F6AB3E82CA87F2AE105EB44E65", hash_generated_method = "A34790455365BCD424DE7999BCD46105")
    public void setUserInfo(UserInfo u) {
        userInfo = u;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.218 -0400", hash_original_method = "92EC2CE878476F294B46126B230CFAA0", hash_generated_method = "FAD43CE7B46962FC334CBF7E370A70DE")
    public void removeUserInfo() {
        this.userInfo = null;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.218 -0400", hash_original_method = "7BE32291F5E6B71E31FC3F9305E1CD28", hash_generated_method = "92968DB07B599A5E739F081EBE9EBAD1")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1605081791 = null; 
        Authority retval = (Authority) super.clone();
        retval.hostPort = (HostPort) this.hostPort.clone();
        retval.userInfo = (UserInfo) this.userInfo.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1605081791 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1605081791.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1605081791;
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.218 -0400", hash_original_method = "1A4F7C0F8CD9FB9B3174AB163DBDBDD1", hash_generated_method = "E3DCD8DC56BE29DA4B92AE9CE09B3253")
    @Override
    public int hashCode() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Null hostPort cannot compute hashcode");
        int var7F9EE2A0D174F62AF476EACFC04AD62C_1055853247 = (this.hostPort.encode().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_961982071 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_961982071;
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.218 -0400", hash_original_field = "3A34C83A02A60E6C75C2BC7FEDB12B10", hash_generated_field = "392436036450DA670DF3C59C429C18F7")

    private static final long serialVersionUID = -3570349777347017894L;
}

