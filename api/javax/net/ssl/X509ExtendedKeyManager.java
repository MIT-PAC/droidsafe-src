package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.Principal;

public abstract class X509ExtendedKeyManager implements X509KeyManager {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.839 -0400", hash_original_method = "F0C30C87B7D84E85B2225C595BCE43AB", hash_generated_method = "ECFBAFB3CA1273D939EFCE735EEEA01E")
    protected  X509ExtendedKeyManager() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.839 -0400", hash_original_method = "EA8A569E03B996F70B23469E519E27CE", hash_generated_method = "AC3D3838A4BDF7AD35270AA9F56516E2")
    public String chooseEngineClientAlias(String[] keyType,
            Principal[] issuers, SSLEngine engine) {
        addTaint(engine.getTaint());
        addTaint(issuers[0].getTaint());
        addTaint(keyType[0].getTaint());
String var540C13E9E156B687226421B24F2DF178_1448201204 =         null;
        var540C13E9E156B687226421B24F2DF178_1448201204.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1448201204;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.840 -0400", hash_original_method = "3FE28D69AE0A8005556F51C699865935", hash_generated_method = "7384B013E3CC3D248031ECDF077E6BBD")
    public String chooseEngineServerAlias(String keyType, Principal[] issuers,
            SSLEngine engine) {
        addTaint(engine.getTaint());
        addTaint(issuers[0].getTaint());
        addTaint(keyType.getTaint());
String var540C13E9E156B687226421B24F2DF178_705286429 =         null;
        var540C13E9E156B687226421B24F2DF178_705286429.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_705286429;
        // ---------- Original Method ----------
        //return null;
    }

    
}

