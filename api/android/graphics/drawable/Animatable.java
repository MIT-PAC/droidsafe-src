package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface Animatable {
    
    void start();

    
    void stop();

    
    boolean isRunning();
}
