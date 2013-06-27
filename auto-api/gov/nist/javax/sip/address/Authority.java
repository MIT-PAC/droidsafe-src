package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.*;

public class Authority extends NetObject {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.515 -0400", hash_original_field = "49F2258E7805F5114B9F128DEA103237", hash_generated_field = "E3D0876BE26B08994B6482E2303E79F8")

    protected HostPort hostPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.516 -0400", hash_original_field = "49F290D6E8459C53F31F97DE37921086", hash_generated_field = "57D80508218E6D78D40A7308D7B8E3EC")

    protected UserInfo userInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.516 -0400", hash_original_method = "29F4443983F8620AB75DA78FB49F743F", hash_generated_method = "29F4443983F8620AB75DA78FB49F743F")
    public Authority ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.517 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "11970542F42AB1AF20FD84730E9F5169")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1681803288 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1681803288 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1681803288.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1681803288;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.519 -0400", hash_original_method = "FAE680A5CA07F26487D44D1B3D4D213C", hash_generated_method = "3047289A1EF1F1A80C04D0AC94398F0A")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1421281931 = null; //Variable for return #1
        {
            userInfo.encode(buffer);
            buffer.append(AT);
            hostPort.encode(buffer);
        } //End block
        {
            hostPort.encode(buffer);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1421281931 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1421281931.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1421281931;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.531 -0400", hash_original_method = "B8EA6629A21322DA3947DE0C5AE42A40", hash_generated_method = "168C30DE0B092E256B3A7E348895BF29")
    @Override
    public boolean equals(Object other) {
        {
            boolean varBCFF74C4EC650CC46A218C4FB3AF1C23_1009894860 = (other.getClass() != getClass());
        } //End collapsed parenthetic
        Authority otherAuth;
        otherAuth = (Authority) other;
        {
            boolean varD6CA791ABA172ED81C3844866E9137CC_279234824 = (!this.hostPort.equals(otherAuth.hostPort));
        } //End collapsed parenthetic
        {
            {
                boolean varF575B78950222F8AAFC7D2AE139F0844_168404564 = (!this.userInfo.equals(otherAuth.userInfo));
            } //End collapsed parenthetic
        } //End block
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_135451398 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_135451398;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.535 -0400", hash_original_method = "96FAFC3A7A03957C239B3F2891116715", hash_generated_method = "55572F8D9E0DD1AB43E4DF2EFAC97C72")
    public HostPort getHostPort() {
        HostPort varB4EAC82CA7396A68D541C85D26508E83_1807067406 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1807067406 = hostPort;
        varB4EAC82CA7396A68D541C85D26508E83_1807067406.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1807067406;
        // ---------- Original Method ----------
        //return hostPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.536 -0400", hash_original_method = "7432173A73E0C28FDB3243D392049BFB", hash_generated_method = "7564B2025C962C5A33AB38735FAC1075")
    public UserInfo getUserInfo() {
        UserInfo varB4EAC82CA7396A68D541C85D26508E83_1015774718 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1015774718 = userInfo;
        varB4EAC82CA7396A68D541C85D26508E83_1015774718.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1015774718;
        // ---------- Original Method ----------
        //return userInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.541 -0400", hash_original_method = "0D75875975A37063C0158825ECC49152", hash_generated_method = "EB47E52CC26483BD33FD9E83BCC1E4DA")
    public String getPassword() {
        String varB4EAC82CA7396A68D541C85D26508E83_346054729 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_124629055 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_346054729 = null;
        varB4EAC82CA7396A68D541C85D26508E83_124629055 = userInfo.password;
        String varA7E53CE21691AB073D9660D615818899_383127194; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_383127194 = varB4EAC82CA7396A68D541C85D26508E83_346054729;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_383127194 = varB4EAC82CA7396A68D541C85D26508E83_124629055;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_383127194.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_383127194;
        // ---------- Original Method ----------
        //if (userInfo == null)
            //return null;
        //else
            //return userInfo.password;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.542 -0400", hash_original_method = "A937EFB3E6E8C8E07C44A0CAF1D94D2D", hash_generated_method = "C969BF23C379AAE3BEB061A0E7C337B1")
    public String getUser() {
        String varB4EAC82CA7396A68D541C85D26508E83_425499286 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_425499286 = userInfo != null ? userInfo.user : null;
        varB4EAC82CA7396A68D541C85D26508E83_425499286.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_425499286;
        // ---------- Original Method ----------
        //return userInfo != null ? userInfo.user : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.552 -0400", hash_original_method = "36AABAF7F60E6F4B05DBAF6E2BFF1DAC", hash_generated_method = "78F9244AEC934232CF85A96C4D8133EA")
    public Host getHost() {
        Host varB4EAC82CA7396A68D541C85D26508E83_1704910323 = null; //Variable for return #1
        Host varB4EAC82CA7396A68D541C85D26508E83_1170386564 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1704910323 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1170386564 = hostPort.getHost();
        Host varA7E53CE21691AB073D9660D615818899_1105132481; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1105132481 = varB4EAC82CA7396A68D541C85D26508E83_1704910323;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1105132481 = varB4EAC82CA7396A68D541C85D26508E83_1170386564;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1105132481.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1105132481;
        // ---------- Original Method ----------
        //if (hostPort == null)
            //return null;
        //else
            //return hostPort.getHost();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.553 -0400", hash_original_method = "94F38CD1718C7E4E03E245C5A4A2F71A", hash_generated_method = "10860D83F0102A0A9284F8C53BFBEB23")
    public int getPort() {
        int varE20CC0FC720F4ED394AC344E2BF47690_249666457 = (hostPort.getPort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_897415715 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_897415715;
        // ---------- Original Method ----------
        //if (hostPort == null)
            //return -1;
        //else
            //return hostPort.getPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.553 -0400", hash_original_method = "03A0EAC86168733AADB73171D9F2D86A", hash_generated_method = "C14D8A4F04979C1F187834AD19497B03")
    public void removePort() {
        hostPort.removePort();
        // ---------- Original Method ----------
        //if (hostPort != null)
            //hostPort.removePort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.554 -0400", hash_original_method = "8346E0D819EDE7DDC699DC8693996508", hash_generated_method = "E22F075E0722B10A66F7D6F3CCF357E8")
    public void setPassword(String passwd) {
        userInfo = new UserInfo();
        userInfo.setPassword(passwd);
        addTaint(passwd.getTaint());
        // ---------- Original Method ----------
        //if (userInfo == null)
            //userInfo = new UserInfo();
        //userInfo.setPassword(passwd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.554 -0400", hash_original_method = "0EF31135B34CFA44FF4FE8878DF2C9B5", hash_generated_method = "276C1314EF7411974385CA5A4AA14F2D")
    public void setUser(String user) {
        userInfo = new UserInfo();
        this.userInfo.setUser(user);
        addTaint(user.getTaint());
        // ---------- Original Method ----------
        //if (userInfo == null)
            //userInfo = new UserInfo();
        //this.userInfo.setUser(user);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.554 -0400", hash_original_method = "201068C9F082E3325F0A6DFD9E3C4A4F", hash_generated_method = "D3FF73EFB54EAF514CB30E7AC67608C4")
    public void setHost(Host host) {
        hostPort = new HostPort();
        hostPort.setHost(host);
        addTaint(host.getTaint());
        // ---------- Original Method ----------
        //if (hostPort == null)
            //hostPort = new HostPort();
        //hostPort.setHost(host);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.558 -0400", hash_original_method = "3BD3C551AB75CBED14D6B43386D78BE7", hash_generated_method = "D59BB7ED37E3988956FC06767B5B8BEA")
    public void setPort(int port) {
        hostPort = new HostPort();
        hostPort.setPort(port);
        addTaint(port);
        // ---------- Original Method ----------
        //if (hostPort == null)
            //hostPort = new HostPort();
        //hostPort.setPort(port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.559 -0400", hash_original_method = "D8F21BCC66A176F57688F337D1095243", hash_generated_method = "B745BD321C9016470F27FA9AECB556E7")
    public void setHostPort(HostPort h) {
        hostPort = h;
        // ---------- Original Method ----------
        //hostPort = h;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.559 -0400", hash_original_method = "108550F6AB3E82CA87F2AE105EB44E65", hash_generated_method = "A34790455365BCD424DE7999BCD46105")
    public void setUserInfo(UserInfo u) {
        userInfo = u;
        // ---------- Original Method ----------
        //userInfo = u;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.566 -0400", hash_original_method = "92EC2CE878476F294B46126B230CFAA0", hash_generated_method = "FAD43CE7B46962FC334CBF7E370A70DE")
    public void removeUserInfo() {
        this.userInfo = null;
        // ---------- Original Method ----------
        //this.userInfo = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.580 -0400", hash_original_method = "7BE32291F5E6B71E31FC3F9305E1CD28", hash_generated_method = "EC625983118342F23F324E9AFAA316C4")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1194736598 = null; //Variable for return #1
        Authority retval;
        retval = (Authority) super.clone();
        retval.hostPort = (HostPort) this.hostPort.clone();
        retval.userInfo = (UserInfo) this.userInfo.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1194736598 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1194736598.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1194736598;
        // ---------- Original Method ----------
        //Authority retval = (Authority) super.clone();
        //if (this.hostPort != null)
            //retval.hostPort = (HostPort) this.hostPort.clone();
        //if (this.userInfo != null)
            //retval.userInfo = (UserInfo) this.userInfo.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.581 -0400", hash_original_method = "1A4F7C0F8CD9FB9B3174AB163DBDBDD1", hash_generated_method = "DCD94ADA9C61887718F1B3A2A72794CA")
    @Override
    public int hashCode() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Null hostPort cannot compute hashcode");
        int var7F9EE2A0D174F62AF476EACFC04AD62C_2017519123 = (this.hostPort.encode().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_648999808 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_648999808;
        // ---------- Original Method ----------
        //if ( this.hostPort == null ) throw new UnsupportedOperationException("Null hostPort cannot compute hashcode");
        //return this.hostPort.encode().hashCode();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:30.581 -0400", hash_original_field = "3A34C83A02A60E6C75C2BC7FEDB12B10", hash_generated_field = "B0E492CADABFBA46C7B1187CF653623F")

    private static long serialVersionUID = -3570349777347017894L;
}

