package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class Authenticator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.013 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "6D420698033AD4B037D630A04933A2DD")

    private String host;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.013 -0400", hash_original_field = "3EF9A0D7FAB5D2BCABF0978C0A35244E", hash_generated_field = "0B6CE69CF925D6E46B22FFB8B45B7F59")

    private InetAddress addr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.013 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "D40522EE9D0571A9162D4F847D658065")

    private int port;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.013 -0400", hash_original_field = "81788BA0D7D02D81C063DBCA621BA11B", hash_generated_field = "512C13BA7A4120A610964F395EA31E91")

    private String protocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.014 -0400", hash_original_field = "4AE35DBB42614D2429B7D6D181A950BB", hash_generated_field = "73A8FB617E5E6FEE69E01BC210863E4D")

    private String prompt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.014 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "CBE7A470226A0B2957A605279AD0FD59")

    private String scheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.014 -0400", hash_original_field = "572D4E421E5E6B9BC11D815E8A027112", hash_generated_field = "4E8909F55682E93D265FDB05DA0C8C95")

    private URL url;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.014 -0400", hash_original_field = "822050D9AE3C47F54BEE71B85FCE1487", hash_generated_field = "9714F053F4B331A2C144544CF89DAA37")

    private RequestorType rt;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.014 -0400", hash_original_method = "B4C23A0C6FE3AF9F3FBB3DA6EF5F723C", hash_generated_method = "B4C23A0C6FE3AF9F3FBB3DA6EF5F723C")
    public Authenticator ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.014 -0400", hash_original_method = "3093C4DCBD758CB1DB7C3B81720996CD", hash_generated_method = "899F1F1F7617EF9F443ECB0A2A648E90")
    protected PasswordAuthentication getPasswordAuthentication() {
        PasswordAuthentication varB4EAC82CA7396A68D541C85D26508E83_1746231027 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1746231027 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1746231027.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1746231027;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.014 -0400", hash_original_method = "DC9C52EAA515BAD6BDD0FA3590432E35", hash_generated_method = "E99917D0BC9893434D741DD6B0F1F650")
    protected final int getRequestingPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_598448488 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_598448488;
        // ---------- Original Method ----------
        //return this.port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.015 -0400", hash_original_method = "2B14AF242379C7938332ECF0E248EB1C", hash_generated_method = "354E70E85D691029F66C8E0898DB8137")
    protected final InetAddress getRequestingSite() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_592118117 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_592118117 = this.addr;
        varB4EAC82CA7396A68D541C85D26508E83_592118117.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_592118117;
        // ---------- Original Method ----------
        //return this.addr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.015 -0400", hash_original_method = "77C5C0A5F58C3B05E3A20169E90243A2", hash_generated_method = "04B0E107D7F463FF233D78950CA4FD21")
    protected final String getRequestingPrompt() {
        String varB4EAC82CA7396A68D541C85D26508E83_966391876 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_966391876 = this.prompt;
        varB4EAC82CA7396A68D541C85D26508E83_966391876.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_966391876;
        // ---------- Original Method ----------
        //return this.prompt;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.015 -0400", hash_original_method = "0EEBE945906182A6ED15FB53AC64D909", hash_generated_method = "9BF65F2F6376D6642A05F1001493F3BB")
    protected final String getRequestingProtocol() {
        String varB4EAC82CA7396A68D541C85D26508E83_920532238 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_920532238 = this.protocol;
        varB4EAC82CA7396A68D541C85D26508E83_920532238.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_920532238;
        // ---------- Original Method ----------
        //return this.protocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.016 -0400", hash_original_method = "09F9AD99062E3C7EFE932F710107733C", hash_generated_method = "E3ED9918979D27E8F2136E9C4BC3F0D4")
    protected final String getRequestingScheme() {
        String varB4EAC82CA7396A68D541C85D26508E83_1469098866 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1469098866 = this.scheme;
        varB4EAC82CA7396A68D541C85D26508E83_1469098866.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1469098866;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.017 -0400", hash_original_method = "8CC1A8E4CE78153F4006F6F40BA275CE", hash_generated_method = "62A3640DBFB7FF9E95832FE5EBA857C0")
    protected final String getRequestingHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_1961382340 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1961382340 = host;
        varB4EAC82CA7396A68D541C85D26508E83_1961382340.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1961382340;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.017 -0400", hash_original_method = "3D575AEF6CE8C91A17FF3C39D0168781", hash_generated_method = "9BF422E405DDFF535F04A5B478CADAA4")
    protected URL getRequestingURL() {
        URL varB4EAC82CA7396A68D541C85D26508E83_1867394247 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1867394247 = url;
        varB4EAC82CA7396A68D541C85D26508E83_1867394247.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1867394247;
        // ---------- Original Method ----------
        //return url;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.018 -0400", hash_original_method = "55F670A5333D0DDAF23FC0CC5542C3C2", hash_generated_method = "01AC5521BDE5A4071DEBD3DCAA6D441A")
    protected Authenticator.RequestorType getRequestorType() {
        Authenticator.RequestorType varB4EAC82CA7396A68D541C85D26508E83_1727253063 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1727253063 = rt;
        varB4EAC82CA7396A68D541C85D26508E83_1727253063.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1727253063;
        // ---------- Original Method ----------
        //return rt;
    }

    
    public enum RequestorType {
        PROXY,
        SERVER
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.018 -0400", hash_original_field = "681237294EFAC21D812BBE59B576F197", hash_generated_field = "8E8E0EE210D2CBD416C2EDF43F2EB51A")

    private static Authenticator thisAuthenticator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.018 -0400", hash_original_field = "CC9E932000D6C6445D0FD8B29F480F3B", hash_generated_field = "0600E962B7B6CE9DE248036206873A5F")

    private static final NetPermission requestPasswordAuthenticationPermission = new NetPermission(
            "requestPasswordAuthentication");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.018 -0400", hash_original_field = "E901A00515CBFCAC8355CB31C33B7587", hash_generated_field = "21B565F35E37E56DBE475EE1E023C013")

    private static final NetPermission setDefaultAuthenticatorPermission = new NetPermission(
            "setDefaultAuthenticator");
}

