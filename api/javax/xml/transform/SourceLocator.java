package javax.xml.transform;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface SourceLocator {

    
    public String getPublicId();

    
    public String getSystemId();

    
    public int getLineNumber();

    
    public int getColumnNumber();
}
