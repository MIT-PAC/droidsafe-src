package java.util.logging;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface Filter {

    
    boolean isLoggable(LogRecord record);
}
