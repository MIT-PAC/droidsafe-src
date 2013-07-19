package javax.security.auth;

// Droidsafe Imports

public interface Destroyable {

    
    void destroy() throws DestroyFailedException;

    
    boolean isDestroyed();

}
