package java.util;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface Observer {

    
    void update(Observable observable, Object data);
}
