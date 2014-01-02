package dalvik.system;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface DalvikLogHandler {

    
    void publish(Logger source, String tag, Level level, String message);

    
}
