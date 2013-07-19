package javax.net.ssl;

// Droidsafe Imports
import java.util.EventListener;

public interface SSLSessionBindingListener extends EventListener {

    
    public void valueBound(SSLSessionBindingEvent event);

    
    public void valueUnbound(SSLSessionBindingEvent event);

}
