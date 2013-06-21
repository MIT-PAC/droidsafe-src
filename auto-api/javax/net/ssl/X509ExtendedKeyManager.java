package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.Principal;

public abstract class X509ExtendedKeyManager implements X509KeyManager {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.121 -0400", hash_original_method = "F0C30C87B7D84E85B2225C595BCE43AB", hash_generated_method = "ECFBAFB3CA1273D939EFCE735EEEA01E")
    @DSModeled(DSC.SAFE)
    protected X509ExtendedKeyManager() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.121 -0400", hash_original_method = "EA8A569E03B996F70B23469E519E27CE", hash_generated_method = "A8BD8E7F01B1C6111B81606E71E5C750")
    @DSModeled(DSC.SAFE)
    public String chooseEngineClientAlias(String[] keyType,
            Principal[] issuers, SSLEngine engine) {
        dsTaint.addTaint(issuers[0].dsTaint);
        dsTaint.addTaint(keyType[0]);
        dsTaint.addTaint(engine.dsTaint);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.121 -0400", hash_original_method = "3FE28D69AE0A8005556F51C699865935", hash_generated_method = "7D244670D31A4ABC7B45D2C3349960A0")
    @DSModeled(DSC.SAFE)
    public String chooseEngineServerAlias(String keyType, Principal[] issuers,
            SSLEngine engine) {
        dsTaint.addTaint(issuers[0].dsTaint);
        dsTaint.addTaint(keyType);
        dsTaint.addTaint(engine.dsTaint);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
}

