package gov.nist.javax.sip.address;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.Host;
import gov.nist.core.HostPort;

public class Authority extends NetObject {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.332 -0500", hash_original_field = "2808D63A626D8F55CDB4D64A62CA28FD", hash_generated_field = "392436036450DA670DF3C59C429C18F7")

    private static final long serialVersionUID = -3570349777347017894L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.335 -0500", hash_original_field = "9B4A41D1F947DB93B1E0620B59F0E903", hash_generated_field = "E3D0876BE26B08994B6482E2303E79F8")

    protected HostPort hostPort;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.338 -0500", hash_original_field = "A8B2D90E3C45645568E6BB5B59CA2CF4", hash_generated_field = "57D80508218E6D78D40A7308D7B8E3EC")

    protected UserInfo userInfo;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:31.986 -0400", hash_original_method = "29F4443983F8620AB75DA78FB49F743F", hash_generated_method = "29F4443983F8620AB75DA78FB49F743F")
    public Authority ()
    {
        //Synthesized constructor
    }

    /**
     * Return the host name in encoded form.
     * @return encoded string (does the same thing as toString)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.342 -0500", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "3E83C3693072E036EE6283AD07E42258")
    
public String encode() {
        return encode(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.347 -0500", hash_original_method = "FAE680A5CA07F26487D44D1B3D4D213C", hash_generated_method = "663D3A07E35FB0FA6C454341DBC5D889")
    
public StringBuffer encode(StringBuffer buffer) {
        if (userInfo != null) {
            userInfo.encode(buffer);
            buffer.append(AT);
            hostPort.encode(buffer);
        } else {
            hostPort.encode(buffer);
        }
        return buffer;
    }

    /** retruns true if the two Objects are equals , false otherwise.
     * @param other Object to test.
     * @return boolean
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.352 -0500", hash_original_method = "B8EA6629A21322DA3947DE0C5AE42A40", hash_generated_method = "465724610F97AA48C0FBD470721B05CD")
    
@Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other.getClass() != getClass()) {
            return false;
        }
        Authority otherAuth = (Authority) other;
        if (!this.hostPort.equals(otherAuth.hostPort)) {
            return false;
        }
        if (this.userInfo != null && otherAuth.userInfo != null) {
            if (!this.userInfo.equals(otherAuth.userInfo)) {
                return false;
            }
        }
        return true;
    }

    /**
     * get the hostPort member.
     * @return HostPort
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.355 -0500", hash_original_method = "96FAFC3A7A03957C239B3F2891116715", hash_generated_method = "66B95A06BB6FD14A22EE11841A58A7BA")
    
public HostPort getHostPort() {
        return hostPort;
    }

    /**
     * get the userInfo memnber.
     * @return UserInfo
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.358 -0500", hash_original_method = "7432173A73E0C28FDB3243D392049BFB", hash_generated_method = "8BCB92082FFA243AA7AABD710317BC1C")
    
public UserInfo getUserInfo() {
        return userInfo;
    }

    /**
         * Get password from the user info.
         * @return String
         */
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.361 -0500", hash_original_method = "0D75875975A37063C0158825ECC49152", hash_generated_method = "BCCE8CAF7F5F6EBEAEBBD075A79310D1")
    
public String getPassword() {
        if (userInfo == null)
            return null;
        else
            return userInfo.password;
    }

    /**
     * Get the user name if it exists.
     * @return String user or null if not set.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.364 -0500", hash_original_method = "A937EFB3E6E8C8E07C44A0CAF1D94D2D", hash_generated_method = "AB2FC18E4D16E447486CDBD6A095E445")
    
public String getUser() {
        return userInfo != null ? userInfo.user : null;
    }

    /**
     * Get the host name.
     * @return Host (null if not set)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.366 -0500", hash_original_method = "36AABAF7F60E6F4B05DBAF6E2BFF1DAC", hash_generated_method = "EC9DA0703D9972DC95DD1470FBB68F79")
    
public Host getHost() {
        if (hostPort == null)
            return null;
        else
            return hostPort.getHost();
    }

    /**
     * Get the port.
     * @return int port (-1) if port is not set.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.369 -0500", hash_original_method = "94F38CD1718C7E4E03E245C5A4A2F71A", hash_generated_method = "C0DC8F0E1ADEB5F2A8C17E7DECC3518E")
    
public int getPort() {
        if (hostPort == null)
            return -1;
        else
            return hostPort.getPort();
    }

    /** remove the port.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.372 -0500", hash_original_method = "03A0EAC86168733AADB73171D9F2D86A", hash_generated_method = "34EC2AB946B822D68C293CFBE8B33CF4")
    
public void removePort() {
        if (hostPort != null)
            hostPort.removePort();
    }

    /**
     * set the password.
     * @param passwd String to set
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.374 -0500", hash_original_method = "8346E0D819EDE7DDC699DC8693996508", hash_generated_method = "E6592F8D679A0E97A10A91F11304BAA9")
    
public void setPassword(String passwd) {
        if (userInfo == null)
            userInfo = new UserInfo();
        userInfo.setPassword(passwd);
    }

    /**
     * Set the user name of the userInfo member.
     * @param user String to set
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.377 -0500", hash_original_method = "0EF31135B34CFA44FF4FE8878DF2C9B5", hash_generated_method = "7C57FEA32B240121A672CFCAD2ACEA13")
    
public void setUser(String user) {
        if (userInfo == null)
            userInfo = new UserInfo();
        this.userInfo.setUser(user);
    }

    /**
     * set the host.
     * @param host Host to set
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.379 -0500", hash_original_method = "201068C9F082E3325F0A6DFD9E3C4A4F", hash_generated_method = "69D3791AA41772A1BBF629F95249F05E")
    
public void setHost(Host host) {
        if (hostPort == null)
            hostPort = new HostPort();
        hostPort.setHost(host);
    }

    /**
     * Set the port.
     * @param port int to set
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.382 -0500", hash_original_method = "3BD3C551AB75CBED14D6B43386D78BE7", hash_generated_method = "F0320919A80AD45DDC258DBC49E73887")
    
public void setPort(int port) {
        if (hostPort == null)
            hostPort = new HostPort();
        hostPort.setPort(port);
    }

    /**
         * Set the hostPort member
         * @param h HostPort to set
         */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.385 -0500", hash_original_method = "D8F21BCC66A176F57688F337D1095243", hash_generated_method = "2EF9DE25564C4BBAC4B1B2F68C77E0A6")
    
public void setHostPort(HostPort h) {
        hostPort = h;
    }

    /**
         * Set the userInfo member
         * @param u UserInfo to set
         */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.387 -0500", hash_original_method = "108550F6AB3E82CA87F2AE105EB44E65", hash_generated_method = "01A43CCBF55896EB37404D78537F038B")
    
public void setUserInfo(UserInfo u) {
        userInfo = u;
    }

    /** Remove the user Infor.
    *
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.389 -0500", hash_original_method = "92EC2CE878476F294B46126B230CFAA0", hash_generated_method = "C81ECE984E1B9187376FA6FCDCE9A2CB")
    
public void removeUserInfo() {
        this.userInfo = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.391 -0500", hash_original_method = "7BE32291F5E6B71E31FC3F9305E1CD28", hash_generated_method = "ACDC0C9FD8840FD42AB9D5AED48027B2")
    
public Object clone() {
        Authority retval = (Authority) super.clone();
        if (this.hostPort != null)
            retval.hostPort = (HostPort) this.hostPort.clone();
        if (this.userInfo != null)
            retval.userInfo = (UserInfo) this.userInfo.clone();
        return retval;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:33.394 -0500", hash_original_method = "1A4F7C0F8CD9FB9B3174AB163DBDBDD1", hash_generated_method = "77DACF58BE8A29D391F22EE93C65BC18")
    
@Override
    public int hashCode() {
        if ( this.hostPort == null ) throw new UnsupportedOperationException("Null hostPort cannot compute hashcode");
        return this.hostPort.encode().hashCode();
    }
}

