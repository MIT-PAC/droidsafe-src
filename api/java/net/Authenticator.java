package java.net;

// Droidsafe Imports
import droidsafe.annotations.*;





public abstract class Authenticator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.274 -0400", hash_original_field = "67B3DBA8BC6778101892EB77249DB32E", hash_generated_field = "6D420698033AD4B037D630A04933A2DD")

    private String host;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.274 -0400", hash_original_field = "3EF9A0D7FAB5D2BCABF0978C0A35244E", hash_generated_field = "0B6CE69CF925D6E46B22FFB8B45B7F59")

    private InetAddress addr;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.274 -0400", hash_original_field = "901555FB06E346CB065CEB9808DCFC25", hash_generated_field = "D40522EE9D0571A9162D4F847D658065")

    private int port;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.274 -0400", hash_original_field = "81788BA0D7D02D81C063DBCA621BA11B", hash_generated_field = "512C13BA7A4120A610964F395EA31E91")

    private String protocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.274 -0400", hash_original_field = "4AE35DBB42614D2429B7D6D181A950BB", hash_generated_field = "73A8FB617E5E6FEE69E01BC210863E4D")

    private String prompt;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.274 -0400", hash_original_field = "41323917EF8089432959A3C33269DEBF", hash_generated_field = "CBE7A470226A0B2957A605279AD0FD59")

    private String scheme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.274 -0400", hash_original_field = "572D4E421E5E6B9BC11D815E8A027112", hash_generated_field = "4E8909F55682E93D265FDB05DA0C8C95")

    private URL url;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.274 -0400", hash_original_field = "822050D9AE3C47F54BEE71B85FCE1487", hash_generated_field = "9714F053F4B331A2C144544CF89DAA37")

    private RequestorType rt;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.275 -0400", hash_original_method = "B4C23A0C6FE3AF9F3FBB3DA6EF5F723C", hash_generated_method = "B4C23A0C6FE3AF9F3FBB3DA6EF5F723C")
    public Authenticator ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.275 -0400", hash_original_method = "3093C4DCBD758CB1DB7C3B81720996CD", hash_generated_method = "4A3DB95C55CAC8515919B2C60BAD10B7")
    protected PasswordAuthentication getPasswordAuthentication() {
PasswordAuthentication var540C13E9E156B687226421B24F2DF178_381795775 =         null;
        var540C13E9E156B687226421B24F2DF178_381795775.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_381795775;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.275 -0400", hash_original_method = "DC9C52EAA515BAD6BDD0FA3590432E35", hash_generated_method = "452275E6B6A20F1418722B4392753815")
    protected final int getRequestingPort() {
        int var02075052AFB1BA5EC4413B52BC401B14_58753117 = (this.port);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_572694922 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_572694922;
        // ---------- Original Method ----------
        //return this.port;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.275 -0400", hash_original_method = "2B14AF242379C7938332ECF0E248EB1C", hash_generated_method = "754EAB83F7A5CE84C0AAA875C129EFB7")
    protected final InetAddress getRequestingSite() {
InetAddress var55D6C22980A62580DC8102E7BF2936A0_512086249 =         this.addr;
        var55D6C22980A62580DC8102E7BF2936A0_512086249.addTaint(taint);
        return var55D6C22980A62580DC8102E7BF2936A0_512086249;
        // ---------- Original Method ----------
        //return this.addr;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.276 -0400", hash_original_method = "77C5C0A5F58C3B05E3A20169E90243A2", hash_generated_method = "14E54AECCD9C85A781E393B272165880")
    protected final String getRequestingPrompt() {
String varFC2405A39E5229F9CD5628628F064ED2_1934116561 =         this.prompt;
        varFC2405A39E5229F9CD5628628F064ED2_1934116561.addTaint(taint);
        return varFC2405A39E5229F9CD5628628F064ED2_1934116561;
        // ---------- Original Method ----------
        //return this.prompt;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.276 -0400", hash_original_method = "0EEBE945906182A6ED15FB53AC64D909", hash_generated_method = "A9AE1F583E4ED75D66020C640CEFD9D0")
    protected final String getRequestingProtocol() {
String var6B7E338C8BD363F309A7E471EADA8AA9_1005703013 =         this.protocol;
        var6B7E338C8BD363F309A7E471EADA8AA9_1005703013.addTaint(taint);
        return var6B7E338C8BD363F309A7E471EADA8AA9_1005703013;
        // ---------- Original Method ----------
        //return this.protocol;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.276 -0400", hash_original_method = "09F9AD99062E3C7EFE932F710107733C", hash_generated_method = "B4C1BF40FC8C90EA6A45E2EB463CEEF2")
    protected final String getRequestingScheme() {
String varBF26C0D1E8CB9E7F67A307E664136E8F_116923122 =         this.scheme;
        varBF26C0D1E8CB9E7F67A307E664136E8F_116923122.addTaint(taint);
        return varBF26C0D1E8CB9E7F67A307E664136E8F_116923122;
        // ---------- Original Method ----------
        //return this.scheme;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.279 -0400", hash_original_method = "8CC1A8E4CE78153F4006F6F40BA275CE", hash_generated_method = "6D99C1CB1D6FD3925C3AF64C80CAD944")
    protected final String getRequestingHost() {
String var872E07117C05F1A34EC24B57B694B8E3_2118576289 =         host;
        var872E07117C05F1A34EC24B57B694B8E3_2118576289.addTaint(taint);
        return var872E07117C05F1A34EC24B57B694B8E3_2118576289;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.280 -0400", hash_original_method = "3D575AEF6CE8C91A17FF3C39D0168781", hash_generated_method = "0C1C63804AECF69B06321C843F8952BF")
    protected URL getRequestingURL() {
URL var4F9C62D322C7F68D5668056D4B193F9B_488632360 =         url;
        var4F9C62D322C7F68D5668056D4B193F9B_488632360.addTaint(taint);
        return var4F9C62D322C7F68D5668056D4B193F9B_488632360;
        // ---------- Original Method ----------
        //return url;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.281 -0400", hash_original_method = "55F670A5333D0DDAF23FC0CC5542C3C2", hash_generated_method = "2AEF2560850BD98B6C5E2ED6D6AC8278")
    protected Authenticator.RequestorType getRequestorType() {
Authenticator.RequestorType var6495F2B70B76ACA4ECED69A6FD453ED2_27072360 =         rt;
        var6495F2B70B76ACA4ECED69A6FD453ED2_27072360.addTaint(taint);
        return var6495F2B70B76ACA4ECED69A6FD453ED2_27072360;
        // ---------- Original Method ----------
        //return rt;
    }

    
    public enum RequestorType {
        PROXY,
        SERVER
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.281 -0400", hash_original_field = "681237294EFAC21D812BBE59B576F197", hash_generated_field = "8E8E0EE210D2CBD416C2EDF43F2EB51A")

    private static Authenticator thisAuthenticator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.281 -0400", hash_original_field = "CC9E932000D6C6445D0FD8B29F480F3B", hash_generated_field = "0600E962B7B6CE9DE248036206873A5F")

    private static final NetPermission requestPasswordAuthenticationPermission = new NetPermission(
            "requestPasswordAuthentication");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.281 -0400", hash_original_field = "E901A00515CBFCAC8355CB31C33B7587", hash_generated_field = "21B565F35E37E56DBE475EE1E023C013")

    private static final NetPermission setDefaultAuthenticatorPermission = new NetPermission(
            "setDefaultAuthenticator");
}

