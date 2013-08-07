package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface Animatable {
    
    void start();

    
    void stop();

    
    boolean isRunning();
}
