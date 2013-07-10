package android.graphics.drawable;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface Animatable {
    
    void start();

    
    void stop();

    
    boolean isRunning();
}
