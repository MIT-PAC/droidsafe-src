package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface Checkable {
    
    
    void setChecked(boolean checked);
        
    
    boolean isChecked();
    
    
    void toggle();
}
