package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public interface FallbackEventHandler {
    public void setView(View v);
    public void preDispatchKeyEvent(KeyEvent event);
    public boolean dispatchKeyEvent(KeyEvent event);
}

