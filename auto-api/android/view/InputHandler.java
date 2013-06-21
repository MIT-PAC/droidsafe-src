package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface InputHandler {
    
    public void handleKey(KeyEvent event, InputQueue.FinishedCallback finishedCallback);
    
    
    public void handleMotion(MotionEvent event, InputQueue.FinishedCallback finishedCallback);
}
