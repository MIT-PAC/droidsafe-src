package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public interface ComponentCallbacks2 extends ComponentCallbacks {

    
    static final int TRIM_MEMORY_COMPLETE = 80;
    
    
    static final int TRIM_MEMORY_MODERATE = 60;
    
    
    static final int TRIM_MEMORY_BACKGROUND = 40;
    
    
    static final int TRIM_MEMORY_UI_HIDDEN = 20;

    
    void onTrimMemory(int level);
}

