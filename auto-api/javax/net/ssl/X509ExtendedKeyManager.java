package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.Principal;

public abstract class X509ExtendedKeyManager implements X509KeyManager {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.754 -0400", hash_original_method = "F0C30C87B7D84E85B2225C595BCE43AB", hash_generated_method = "ECFBAFB3CA1273D939EFCE735EEEA01E")
    protected  X509ExtendedKeyManager() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.754 -0400", hash_original_method = "EA8A569E03B996F70B23469E519E27CE", hash_generated_method = "283D3C135EE5AC5D77E2BC0CC130D3FB")
    public String chooseEngineClientAlias(String[] keyType,
            Principal[] issuers, SSLEngine engine) {
        String varB4EAC82CA7396A68D541C85D26508E83_15465089 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_15465089 = null;
        addTaint(keyType[0].getTaint());
        addTaint(issuers[0].getTaint());
        addTaint(engine.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_15465089.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_15465089;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.755 -0400", hash_original_method = "3FE28D69AE0A8005556F51C699865935", hash_generated_method = "20EF0E9F344AE4202FAEE2B93B786A09")
    public String chooseEngineServerAlias(String keyType, Principal[] issuers,
            SSLEngine engine) {
        String varB4EAC82CA7396A68D541C85D26508E83_102190382 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_102190382 = null;
        addTaint(keyType.getTaint());
        addTaint(issuers[0].getTaint());
        addTaint(engine.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_102190382.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_102190382;
        // ---------- Original Method ----------
        //return null;
    }

    
}

