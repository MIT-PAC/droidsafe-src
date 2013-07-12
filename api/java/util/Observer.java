package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface Observer {

    
    void update(Observable observable, Object data);
}
