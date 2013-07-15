package javax.xml.transform;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface SourceLocator {

    
    public String getPublicId();

    
    public String getSystemId();

    
    public int getLineNumber();

    
    public int getColumnNumber();
}
