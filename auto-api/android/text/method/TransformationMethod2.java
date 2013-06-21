package android.text.method;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface TransformationMethod2 extends TransformationMethod {
    
    public void setLengthChangesAllowed(boolean allowLengthChanges);
}
