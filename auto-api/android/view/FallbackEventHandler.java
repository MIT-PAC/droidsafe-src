package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface FallbackEventHandler {
    public void setView(View v);
    public void preDispatchKeyEvent(KeyEvent event);
    public boolean dispatchKeyEvent(KeyEvent event);
}
