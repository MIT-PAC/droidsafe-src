package org.apache.commons.io.filefilter;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.List;

public interface ConditionalFileFilter {

    
    void addFileFilter(IOFileFilter ioFileFilter);

    
    List<IOFileFilter> getFileFilters();

    
    boolean removeFileFilter(IOFileFilter ioFileFilter);

    
    void setFileFilters(List<IOFileFilter> fileFilters);

}
