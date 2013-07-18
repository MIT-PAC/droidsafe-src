package libcore.net.http;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

enum ResponseSource {
    CACHE,
    CONDITIONAL_CACHE,
    NETWORK;
    @DSModeled(DSC.SAFE)
    public boolean requiresConnection() {
        return this == CONDITIONAL_CACHE || this == NETWORK;
    }
}
