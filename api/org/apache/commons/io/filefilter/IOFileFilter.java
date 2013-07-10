package org.apache.commons.io.filefilter;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public interface IOFileFilter extends FileFilter, FilenameFilter {

    
    boolean accept(File file);

    
    boolean accept(File dir, String name);
    
}
