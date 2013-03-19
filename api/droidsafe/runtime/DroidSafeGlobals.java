package droidsafe.runtime;

import droidsafe.concrete.*;

public class DroidSafeGlobals {
    public static DroidSafeContext context;
    
    static {
        context = new DroidSafeContext();
    }
}
