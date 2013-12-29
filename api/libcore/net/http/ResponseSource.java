package libcore.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



enum ResponseSource {
    CACHE,
    CONDITIONAL_CACHE,
    NETWORK;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:41.037 -0500", hash_original_method = "52EE5357478D4C53EADF509665F97F6B", hash_generated_method = "C46FD3099A4A2B1F148211C293341C66")
        public boolean requiresConnection() {
        return this == CONDITIONAL_CACHE || this == NETWORK;
    }
}
