package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface Checkable {
    
    
    void setChecked(boolean checked);
        
    
    boolean isChecked();
    
    
    void toggle();
}
