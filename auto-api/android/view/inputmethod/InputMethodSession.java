package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;

public interface InputMethodSession {
    
    public interface EventCallback {
        void finishedEvent(int seq, boolean handled);
    }
    
    
    public void finishInput();

    
    public void updateSelection(int oldSelStart, int oldSelEnd,
            int newSelStart, int newSelEnd,
            int candidatesStart, int candidatesEnd);

    
    public void viewClicked(boolean focusChanged);

    
    public void updateCursor(Rect newCursor);
    
    
    public void displayCompletions(CompletionInfo[] completions);
    
    
    public void updateExtractedText(int token, ExtractedText text);
    
    
    public void dispatchKeyEvent(int seq, KeyEvent event, EventCallback callback);

    
    public void dispatchTrackballEvent(int seq, MotionEvent event, EventCallback callback);

    
    public void appPrivateCommand(String action, Bundle data);
    
    
    public void toggleSoftInput(int showFlags, int hideFlags);
}
