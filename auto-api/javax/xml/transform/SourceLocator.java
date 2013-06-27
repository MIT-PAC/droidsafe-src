package javax.xml.transform;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface SourceLocator {

    
    public String getPublicId();

    
    public String getSystemId();

    
    public int getLineNumber();

    
    public int getColumnNumber();
}
