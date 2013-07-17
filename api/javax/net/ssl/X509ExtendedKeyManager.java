package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.Principal;

public abstract class X509ExtendedKeyManager implements X509KeyManager {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.845 -0400", hash_original_method = "F0C30C87B7D84E85B2225C595BCE43AB", hash_generated_method = "ECFBAFB3CA1273D939EFCE735EEEA01E")
    protected  X509ExtendedKeyManager() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.846 -0400", hash_original_method = "EA8A569E03B996F70B23469E519E27CE", hash_generated_method = "F533628C92DDE2065E314C5D91786066")
    public String chooseEngineClientAlias(String[] keyType,
            Principal[] issuers, SSLEngine engine) {
        addTaint(engine.getTaint());
        addTaint(issuers[0].getTaint());
        addTaint(keyType[0].getTaint());
String var540C13E9E156B687226421B24F2DF178_781122245 =         null;
        var540C13E9E156B687226421B24F2DF178_781122245.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_781122245;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.846 -0400", hash_original_method = "3FE28D69AE0A8005556F51C699865935", hash_generated_method = "F21E4798A1835E78F7749BF6A62F4AB2")
    public String chooseEngineServerAlias(String keyType, Principal[] issuers,
            SSLEngine engine) {
        addTaint(engine.getTaint());
        addTaint(issuers[0].getTaint());
        addTaint(keyType.getTaint());
String var540C13E9E156B687226421B24F2DF178_1711251425 =         null;
        var540C13E9E156B687226421B24F2DF178_1711251425.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1711251425;
        // ---------- Original Method ----------
        //return null;
    }

    
}

