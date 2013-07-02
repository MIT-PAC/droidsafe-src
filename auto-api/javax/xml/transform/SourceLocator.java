package javax.xml.transform;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface SourceLocator {

    
    public String getPublicId();

    
    public String getSystemId();

    
    public int getLineNumber();

    
    public int getColumnNumber();
}
