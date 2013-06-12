package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;

public interface KeyListener {
    
    public int getInputType();
    
    
    public boolean onKeyDown(View view, Editable text,
                             int keyCode, KeyEvent event);

    
    public boolean onKeyUp(View view, Editable text,
                           int keyCode, KeyEvent event);
    
    
    public boolean onKeyOther(View view, Editable text, KeyEvent event);
    
    
    public void clearMetaKeyState(View view, Editable content, int states);
}

