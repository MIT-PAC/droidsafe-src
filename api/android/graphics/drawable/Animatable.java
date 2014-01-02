package android.graphics.drawable;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface Animatable {
    
    void start();

    
    void stop();

    
    boolean isRunning();
}
