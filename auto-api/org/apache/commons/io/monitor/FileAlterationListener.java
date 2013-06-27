package org.apache.commons.io.monitor;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.File;

public interface FileAlterationListener {

    
    void onStart(final FileAlterationObserver observer);

    
    void onDirectoryCreate(final File directory);

    
    void onDirectoryChange(final File directory);

    
    void onDirectoryDelete(final File directory);

    
    void onFileCreate(final File file);

    
    void onFileChange(final File file);

    
    void onFileDelete(final File file);

    
    void onStop(final FileAlterationObserver observer);
}
