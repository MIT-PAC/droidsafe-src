package javax.sip.address;

// Droidsafe Imports

public interface Hop {
    String getHost();
    int getPort();
    String getTransport();

    boolean isURIRoute();
    void setURIRouteFlag();

    String toString();
}
