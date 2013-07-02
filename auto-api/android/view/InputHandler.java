package android.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface InputHandler {
    
    public void handleKey(KeyEvent event, InputQueue.FinishedCallback finishedCallback);
    
    
    public void handleMotion(MotionEvent event, InputQueue.FinishedCallback finishedCallback);
}
