package droidsafe.runtime;

import droidsafe.concrete.*;

public class DroidSafeGlobals {
    public static DroidSafeContext context;
    public static DSContentResolver contentResolver;
    
    static {
        context = new DroidSafeContext();
        contentResolver = new DSContentResolver(context);
    }
}
