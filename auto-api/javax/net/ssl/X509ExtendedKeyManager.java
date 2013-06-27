package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.Principal;

public abstract class X509ExtendedKeyManager implements X509KeyManager {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.746 -0400", hash_original_method = "F0C30C87B7D84E85B2225C595BCE43AB", hash_generated_method = "ECFBAFB3CA1273D939EFCE735EEEA01E")
    protected  X509ExtendedKeyManager() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.747 -0400", hash_original_method = "EA8A569E03B996F70B23469E519E27CE", hash_generated_method = "8BD973CADEF561E80FD9BF0678CDC535")
    public String chooseEngineClientAlias(String[] keyType,
            Principal[] issuers, SSLEngine engine) {
        String varB4EAC82CA7396A68D541C85D26508E83_1146320338 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1146320338 = null;
        addTaint(keyType[0].getTaint());
        addTaint(issuers[0].getTaint());
        addTaint(engine.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1146320338.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1146320338;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.747 -0400", hash_original_method = "3FE28D69AE0A8005556F51C699865935", hash_generated_method = "C079D94FB249E99D75C5168BDCE7AA49")
    public String chooseEngineServerAlias(String keyType, Principal[] issuers,
            SSLEngine engine) {
        String varB4EAC82CA7396A68D541C85D26508E83_1551078313 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1551078313 = null;
        addTaint(keyType.getTaint());
        addTaint(issuers[0].getTaint());
        addTaint(engine.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1551078313.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1551078313;
        // ---------- Original Method ----------
        //return null;
    }

    
}

