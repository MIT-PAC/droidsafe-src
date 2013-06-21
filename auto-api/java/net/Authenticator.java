package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class Authenticator {
    private String host;
    private InetAddress addr;
    private int port;
    private String protocol;
    private String prompt;
    private String scheme;
    private URL url;
    private RequestorType rt;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.742 -0400", hash_original_method = "AB2CF60147C9D5F9DE242A68B4B95FC0", hash_generated_method = "AB2CF60147C9D5F9DE242A68B4B95FC0")
        public Authenticator ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.742 -0400", hash_original_method = "3093C4DCBD758CB1DB7C3B81720996CD", hash_generated_method = "368F8C89C5C6D5764580E094F48E05FD")
    @DSModeled(DSC.SAFE)
    protected PasswordAuthentication getPasswordAuthentication() {
        return (PasswordAuthentication)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.742 -0400", hash_original_method = "DC9C52EAA515BAD6BDD0FA3590432E35", hash_generated_method = "0BF2FE5A5735B16833709D633299DE59")
    @DSModeled(DSC.SAFE)
    protected final int getRequestingPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.742 -0400", hash_original_method = "2B14AF242379C7938332ECF0E248EB1C", hash_generated_method = "C238767B425E30D7713AA26E30F16CE5")
    @DSModeled(DSC.SAFE)
    protected final InetAddress getRequestingSite() {
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.addr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.742 -0400", hash_original_method = "77C5C0A5F58C3B05E3A20169E90243A2", hash_generated_method = "DB5053613D7EC7B3B2605380FF4293FB")
    @DSModeled(DSC.SAFE)
    protected final String getRequestingPrompt() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.prompt;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.742 -0400", hash_original_method = "0EEBE945906182A6ED15FB53AC64D909", hash_generated_method = "6CE9F6DA91AAC789DDF286AB8D819924")
    @DSModeled(DSC.SAFE)
    protected final String getRequestingProtocol() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.protocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.742 -0400", hash_original_method = "09F9AD99062E3C7EFE932F710107733C", hash_generated_method = "49239A22EE6D001CD650E62325B273B4")
    @DSModeled(DSC.SAFE)
    protected final String getRequestingScheme() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.scheme;
    }

    
        public static synchronized PasswordAuthentication requestPasswordAuthentication(
            InetAddress rAddr, int rPort, String rProtocol, String rPrompt,
            String rScheme) {
        if (thisAuthenticator == null) {
            return null;
        }
        thisAuthenticator.addr = rAddr;
        thisAuthenticator.port = rPort;
        thisAuthenticator.protocol = rProtocol;
        thisAuthenticator.prompt = rPrompt;
        thisAuthenticator.scheme = rScheme;
        thisAuthenticator.rt = RequestorType.SERVER;
        return thisAuthenticator.getPasswordAuthentication();
    }

    
        public static void setDefault(Authenticator a) {
        thisAuthenticator = a;
    }

    
        public static synchronized PasswordAuthentication requestPasswordAuthentication(
            String rHost, InetAddress rAddr, int rPort, String rProtocol,
            String rPrompt, String rScheme) {
        if (thisAuthenticator == null) {
            return null;
        }
        thisAuthenticator.host = rHost;
        thisAuthenticator.addr = rAddr;
        thisAuthenticator.port = rPort;
        thisAuthenticator.protocol = rProtocol;
        thisAuthenticator.prompt = rPrompt;
        thisAuthenticator.scheme = rScheme;
        thisAuthenticator.rt = RequestorType.SERVER;
        return thisAuthenticator.getPasswordAuthentication();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.743 -0400", hash_original_method = "8CC1A8E4CE78153F4006F6F40BA275CE", hash_generated_method = "85DAF70A455F65F6D1C746ABD5164633")
    @DSModeled(DSC.SAFE)
    protected final String getRequestingHost() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return host;
    }

    
        public static PasswordAuthentication requestPasswordAuthentication(
            String rHost, InetAddress rAddr, int rPort, String rProtocol,
            String rPrompt, String rScheme, URL rURL,
            Authenticator.RequestorType reqType) {
        if (thisAuthenticator == null) {
            return null;
        }
        thisAuthenticator.host = rHost;
        thisAuthenticator.addr = rAddr;
        thisAuthenticator.port = rPort;
        thisAuthenticator.protocol = rProtocol;
        thisAuthenticator.prompt = rPrompt;
        thisAuthenticator.scheme = rScheme;
        thisAuthenticator.url = rURL;
        thisAuthenticator.rt = reqType;
        return thisAuthenticator.getPasswordAuthentication();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.743 -0400", hash_original_method = "3D575AEF6CE8C91A17FF3C39D0168781", hash_generated_method = "4AFD952B59941F8431133DE9E98F4414")
    @DSModeled(DSC.SAFE)
    protected URL getRequestingURL() {
        return (URL)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return url;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.743 -0400", hash_original_method = "55F670A5333D0DDAF23FC0CC5542C3C2", hash_generated_method = "7D285492C8FD39B41C56A4CA3E05CAC0")
    @DSModeled(DSC.SAFE)
    protected Authenticator.RequestorType getRequestorType() {
        return (Authenticator.RequestorType)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return rt;
    }

    
    public enum RequestorType {
        PROXY,
        SERVER
    }

    
    private static Authenticator thisAuthenticator;
    private static final NetPermission requestPasswordAuthenticationPermission = new NetPermission(
            "requestPasswordAuthentication");
    private static final NetPermission setDefaultAuthenticatorPermission = new NetPermission(
            "setDefaultAuthenticator");
}

