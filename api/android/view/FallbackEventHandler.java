package android.view;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface FallbackEventHandler {
    public void setView(View v);
    public void preDispatchKeyEvent(KeyEvent event);
    public boolean dispatchKeyEvent(KeyEvent event);
}
