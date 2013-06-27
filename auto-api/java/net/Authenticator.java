package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class Authenticator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.031 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "6D420698033AD4B037D630A04933A2DD")

    private String host;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.031 -0400", hash_original_field = "3EF9A0D7FAB5D2BCABF0978C0A35244E", hash_generated_field = "0B6CE69CF925D6E46B22FFB8B45B7F59")

    private InetAddress addr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.031 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "D40522EE9D0571A9162D4F847D658065")

    private int port;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.031 -0400", hash_original_field = "81788BA0D7D02D81C063DBCA621BA11B", hash_generated_field = "512C13BA7A4120A610964F395EA31E91")

    private String protocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.031 -0400", hash_original_field = "4AE35DBB42614D2429B7D6D181A950BB", hash_generated_field = "73A8FB617E5E6FEE69E01BC210863E4D")

    private String prompt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.031 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "CBE7A470226A0B2957A605279AD0FD59")

    private String scheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.031 -0400", hash_original_field = "572D4E421E5E6B9BC11D815E8A027112", hash_generated_field = "4E8909F55682E93D265FDB05DA0C8C95")

    private URL url;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.031 -0400", hash_original_field = "822050D9AE3C47F54BEE71B85FCE1487", hash_generated_field = "9714F053F4B331A2C144544CF89DAA37")

    private RequestorType rt;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.031 -0400", hash_original_method = "B4C23A0C6FE3AF9F3FBB3DA6EF5F723C", hash_generated_method = "B4C23A0C6FE3AF9F3FBB3DA6EF5F723C")
    public Authenticator ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.032 -0400", hash_original_method = "3093C4DCBD758CB1DB7C3B81720996CD", hash_generated_method = "E151AE412A84D4D3830FB49EAC1D0A46")
    protected PasswordAuthentication getPasswordAuthentication() {
        PasswordAuthentication varB4EAC82CA7396A68D541C85D26508E83_658645157 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_658645157 = null;
        varB4EAC82CA7396A68D541C85D26508E83_658645157.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_658645157;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.032 -0400", hash_original_method = "DC9C52EAA515BAD6BDD0FA3590432E35", hash_generated_method = "154A7D51F4F8776C5C755A21E5AE7272")
    protected final int getRequestingPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_233955803 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_233955803;
        // ---------- Original Method ----------
        //return this.port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.033 -0400", hash_original_method = "2B14AF242379C7938332ECF0E248EB1C", hash_generated_method = "C5D5E3958C7FC6A66DC3154AEC43AA5A")
    protected final InetAddress getRequestingSite() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_292103148 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_292103148 = this.addr;
        varB4EAC82CA7396A68D541C85D26508E83_292103148.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_292103148;
        // ---------- Original Method ----------
        //return this.addr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.033 -0400", hash_original_method = "77C5C0A5F58C3B05E3A20169E90243A2", hash_generated_method = "B580C42A058484E8136694CF9B9F0812")
    protected final String getRequestingPrompt() {
        String varB4EAC82CA7396A68D541C85D26508E83_929470594 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_929470594 = this.prompt;
        varB4EAC82CA7396A68D541C85D26508E83_929470594.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_929470594;
        // ---------- Original Method ----------
        //return this.prompt;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.054 -0400", hash_original_method = "0EEBE945906182A6ED15FB53AC64D909", hash_generated_method = "63961D427C9FE5846A2C2B677389B3D7")
    protected final String getRequestingProtocol() {
        String varB4EAC82CA7396A68D541C85D26508E83_1369455671 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1369455671 = this.protocol;
        varB4EAC82CA7396A68D541C85D26508E83_1369455671.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1369455671;
        // ---------- Original Method ----------
        //return this.protocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.055 -0400", hash_original_method = "09F9AD99062E3C7EFE932F710107733C", hash_generated_method = "C38F148D5BFB87964C47A162549505DB")
    protected final String getRequestingScheme() {
        String varB4EAC82CA7396A68D541C85D26508E83_1477052752 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1477052752 = this.scheme;
        varB4EAC82CA7396A68D541C85D26508E83_1477052752.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1477052752;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.056 -0400", hash_original_method = "8CC1A8E4CE78153F4006F6F40BA275CE", hash_generated_method = "9F7D3E92C2A6B9643577F4897FC3BA44")
    protected final String getRequestingHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_304170919 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_304170919 = host;
        varB4EAC82CA7396A68D541C85D26508E83_304170919.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_304170919;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.057 -0400", hash_original_method = "3D575AEF6CE8C91A17FF3C39D0168781", hash_generated_method = "14717A1B67B9B14B5EF190B9E5F81C0E")
    protected URL getRequestingURL() {
        URL varB4EAC82CA7396A68D541C85D26508E83_1772982127 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1772982127 = url;
        varB4EAC82CA7396A68D541C85D26508E83_1772982127.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1772982127;
        // ---------- Original Method ----------
        //return url;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.057 -0400", hash_original_method = "55F670A5333D0DDAF23FC0CC5542C3C2", hash_generated_method = "56627B7CD05B5FB9DA7A925B66221661")
    protected Authenticator.RequestorType getRequestorType() {
        Authenticator.RequestorType varB4EAC82CA7396A68D541C85D26508E83_309950213 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_309950213 = rt;
        varB4EAC82CA7396A68D541C85D26508E83_309950213.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_309950213;
        // ---------- Original Method ----------
        //return rt;
    }

    
    public enum RequestorType {
        PROXY,
        SERVER
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.057 -0400", hash_original_field = "681237294EFAC21D812BBE59B576F197", hash_generated_field = "8E8E0EE210D2CBD416C2EDF43F2EB51A")

    private static Authenticator thisAuthenticator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.058 -0400", hash_original_field = "CC9E932000D6C6445D0FD8B29F480F3B", hash_generated_field = "31D687B9323AF6C3F02A7B039CE74E26")

    private static NetPermission requestPasswordAuthenticationPermission = new NetPermission(
            "requestPasswordAuthentication");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.058 -0400", hash_original_field = "E901A00515CBFCAC8355CB31C33B7587", hash_generated_field = "AB695A9550BBD8155187081C1BA0D68F")

    private static NetPermission setDefaultAuthenticatorPermission = new NetPermission(
            "setDefaultAuthenticator");
}

