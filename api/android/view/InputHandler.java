package android.view;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface InputHandler {
    
    public void handleKey(KeyEvent event, InputQueue.FinishedCallback finishedCallback);
    
    
    public void handleMotion(MotionEvent event, InputQueue.FinishedCallback finishedCallback);
}
