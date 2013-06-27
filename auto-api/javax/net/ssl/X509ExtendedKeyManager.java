package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.Principal;

public abstract class X509ExtendedKeyManager implements X509KeyManager {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.381 -0400", hash_original_method = "F0C30C87B7D84E85B2225C595BCE43AB", hash_generated_method = "ECFBAFB3CA1273D939EFCE735EEEA01E")
    protected  X509ExtendedKeyManager() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.381 -0400", hash_original_method = "EA8A569E03B996F70B23469E519E27CE", hash_generated_method = "EC9C899952F5899B19DC230EFA08655A")
    public String chooseEngineClientAlias(String[] keyType,
            Principal[] issuers, SSLEngine engine) {
        String varB4EAC82CA7396A68D541C85D26508E83_170166290 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_170166290 = null;
        addTaint(keyType[0].getTaint());
        addTaint(issuers[0].getTaint());
        addTaint(engine.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_170166290.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_170166290;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.384 -0400", hash_original_method = "3FE28D69AE0A8005556F51C699865935", hash_generated_method = "D4E028A26AEDF568A0CFC2C09894D87A")
    public String chooseEngineServerAlias(String keyType, Principal[] issuers,
            SSLEngine engine) {
        String varB4EAC82CA7396A68D541C85D26508E83_1170674257 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1170674257 = null;
        addTaint(keyType.getTaint());
        addTaint(issuers[0].getTaint());
        addTaint(engine.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1170674257.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1170674257;
        // ---------- Original Method ----------
        //return null;
    }

    
}

