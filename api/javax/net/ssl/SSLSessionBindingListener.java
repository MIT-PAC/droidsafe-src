package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.EventListener;

public interface SSLSessionBindingListener extends EventListener {

    
    public void valueBound(SSLSessionBindingEvent event);

    
    public void valueUnbound(SSLSessionBindingEvent event);

}
