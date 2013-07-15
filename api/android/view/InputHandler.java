package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface InputHandler {
    
    public void handleKey(KeyEvent event, InputQueue.FinishedCallback finishedCallback);
    
    
    public void handleMotion(MotionEvent event, InputQueue.FinishedCallback finishedCallback);
}
