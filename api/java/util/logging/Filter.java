package java.util.logging;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface Filter {

    
    boolean isLoggable(LogRecord record);
}
