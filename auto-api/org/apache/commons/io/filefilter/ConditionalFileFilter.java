package org.apache.commons.io.filefilter;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.List;

public interface ConditionalFileFilter {

    
    void addFileFilter(IOFileFilter ioFileFilter);

    
    List<IOFileFilter> getFileFilters();

    
    boolean removeFileFilter(IOFileFilter ioFileFilter);

    
    void setFileFilters(List<IOFileFilter> fileFilters);

}
