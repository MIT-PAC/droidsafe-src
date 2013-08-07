package javax.sip.address;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface Hop {
    String getHost();
    int getPort();
    String getTransport();

    boolean isURIRoute();
    void setURIRouteFlag();

    String toString();
}
