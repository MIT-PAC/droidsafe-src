package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class Authenticator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.451 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "6D420698033AD4B037D630A04933A2DD")

    private String host;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.452 -0400", hash_original_field = "3EF9A0D7FAB5D2BCABF0978C0A35244E", hash_generated_field = "0B6CE69CF925D6E46B22FFB8B45B7F59")

    private InetAddress addr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.452 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "D40522EE9D0571A9162D4F847D658065")

    private int port;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.452 -0400", hash_original_field = "81788BA0D7D02D81C063DBCA621BA11B", hash_generated_field = "512C13BA7A4120A610964F395EA31E91")

    private String protocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.452 -0400", hash_original_field = "4AE35DBB42614D2429B7D6D181A950BB", hash_generated_field = "73A8FB617E5E6FEE69E01BC210863E4D")

    private String prompt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.452 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "CBE7A470226A0B2957A605279AD0FD59")

    private String scheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.452 -0400", hash_original_field = "572D4E421E5E6B9BC11D815E8A027112", hash_generated_field = "4E8909F55682E93D265FDB05DA0C8C95")

    private URL url;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.452 -0400", hash_original_field = "822050D9AE3C47F54BEE71B85FCE1487", hash_generated_field = "9714F053F4B331A2C144544CF89DAA37")

    private RequestorType rt;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.452 -0400", hash_original_method = "B4C23A0C6FE3AF9F3FBB3DA6EF5F723C", hash_generated_method = "B4C23A0C6FE3AF9F3FBB3DA6EF5F723C")
    public Authenticator ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.453 -0400", hash_original_method = "3093C4DCBD758CB1DB7C3B81720996CD", hash_generated_method = "F6CA281235FB7C37D7B259C63325055A")
    protected PasswordAuthentication getPasswordAuthentication() {
PasswordAuthentication var540C13E9E156B687226421B24F2DF178_142959595 =         null;
        var540C13E9E156B687226421B24F2DF178_142959595.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_142959595;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.453 -0400", hash_original_method = "DC9C52EAA515BAD6BDD0FA3590432E35", hash_generated_method = "0C681469A35FF564A010E8939B1AFCD8")
    protected final int getRequestingPort() {
        int var02075052AFB1BA5EC4413B52BC401B14_30246125 = (this.port);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_874161578 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_874161578;
        // ---------- Original Method ----------
        //return this.port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.453 -0400", hash_original_method = "2B14AF242379C7938332ECF0E248EB1C", hash_generated_method = "4A76BC5FE40CF9229CFCE2EF799FB31C")
    protected final InetAddress getRequestingSite() {
InetAddress var55D6C22980A62580DC8102E7BF2936A0_460057803 =         this.addr;
        var55D6C22980A62580DC8102E7BF2936A0_460057803.addTaint(taint);
        return var55D6C22980A62580DC8102E7BF2936A0_460057803;
        // ---------- Original Method ----------
        //return this.addr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.454 -0400", hash_original_method = "77C5C0A5F58C3B05E3A20169E90243A2", hash_generated_method = "B61EA4D843502B9554584E6D0AD7AD7B")
    protected final String getRequestingPrompt() {
String varFC2405A39E5229F9CD5628628F064ED2_1838806965 =         this.prompt;
        varFC2405A39E5229F9CD5628628F064ED2_1838806965.addTaint(taint);
        return varFC2405A39E5229F9CD5628628F064ED2_1838806965;
        // ---------- Original Method ----------
        //return this.prompt;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.454 -0400", hash_original_method = "0EEBE945906182A6ED15FB53AC64D909", hash_generated_method = "CF06798A6C29C883A6EFB4897A365A68")
    protected final String getRequestingProtocol() {
String var6B7E338C8BD363F309A7E471EADA8AA9_1634470286 =         this.protocol;
        var6B7E338C8BD363F309A7E471EADA8AA9_1634470286.addTaint(taint);
        return var6B7E338C8BD363F309A7E471EADA8AA9_1634470286;
        // ---------- Original Method ----------
        //return this.protocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.454 -0400", hash_original_method = "09F9AD99062E3C7EFE932F710107733C", hash_generated_method = "6E0DECBB93EB4B5AAECF082E97E5285B")
    protected final String getRequestingScheme() {
String varBF26C0D1E8CB9E7F67A307E664136E8F_1392710308 =         this.scheme;
        varBF26C0D1E8CB9E7F67A307E664136E8F_1392710308.addTaint(taint);
        return varBF26C0D1E8CB9E7F67A307E664136E8F_1392710308;
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

    
        @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.456 -0400", hash_original_method = "8CC1A8E4CE78153F4006F6F40BA275CE", hash_generated_method = "18536E5ACCF710AC5597A43ED869ED25")
    protected final String getRequestingHost() {
String var872E07117C05F1A34EC24B57B694B8E3_440683512 =         host;
        var872E07117C05F1A34EC24B57B694B8E3_440683512.addTaint(taint);
        return var872E07117C05F1A34EC24B57B694B8E3_440683512;
        // ---------- Original Method ----------
        //return host;
    }

    
        @DSModeled(DSC.SPEC)
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.457 -0400", hash_original_method = "3D575AEF6CE8C91A17FF3C39D0168781", hash_generated_method = "9A094540E4B4F74545FF96FAB2ADA8EA")
    protected URL getRequestingURL() {
URL var4F9C62D322C7F68D5668056D4B193F9B_2011726904 =         url;
        var4F9C62D322C7F68D5668056D4B193F9B_2011726904.addTaint(taint);
        return var4F9C62D322C7F68D5668056D4B193F9B_2011726904;
        // ---------- Original Method ----------
        //return url;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.458 -0400", hash_original_method = "55F670A5333D0DDAF23FC0CC5542C3C2", hash_generated_method = "9F94A3AE610B35D5E4C380D115BDEA71")
    protected Authenticator.RequestorType getRequestorType() {
Authenticator.RequestorType var6495F2B70B76ACA4ECED69A6FD453ED2_634521695 =         rt;
        var6495F2B70B76ACA4ECED69A6FD453ED2_634521695.addTaint(taint);
        return var6495F2B70B76ACA4ECED69A6FD453ED2_634521695;
        // ---------- Original Method ----------
        //return rt;
    }

    
    public enum RequestorType {
        PROXY,
        SERVER
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.459 -0400", hash_original_field = "681237294EFAC21D812BBE59B576F197", hash_generated_field = "8E8E0EE210D2CBD416C2EDF43F2EB51A")

    private static Authenticator thisAuthenticator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.459 -0400", hash_original_field = "CC9E932000D6C6445D0FD8B29F480F3B", hash_generated_field = "0600E962B7B6CE9DE248036206873A5F")

    private static final NetPermission requestPasswordAuthenticationPermission = new NetPermission(
            "requestPasswordAuthentication");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.459 -0400", hash_original_field = "E901A00515CBFCAC8355CB31C33B7587", hash_generated_field = "21B565F35E37E56DBE475EE1E023C013")

    private static final NetPermission setDefaultAuthenticatorPermission = new NetPermission(
            "setDefaultAuthenticator");
}

