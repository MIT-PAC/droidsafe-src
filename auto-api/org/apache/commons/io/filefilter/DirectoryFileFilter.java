package org.apache.commons.io.filefilter;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.File;
import java.io.Serializable;

public class DirectoryFileFilter extends AbstractFileFilter implements Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.526 -0400", hash_original_method = "271A2DD2196E2818F8A34D7CEDB3A1A7", hash_generated_method = "0D5911F1A17B74E32BF0921AEF88F306")
    protected  DirectoryFileFilter() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.527 -0400", hash_original_method = "39BD0BE636DBD4121253CD6DED7A982C", hash_generated_method = "63016730DED8A36B9014C4A4465005F6")
    @Override
    public boolean accept(File file) {
        boolean var01ABB463F7875458D9545BDC15E68739_278495032 = (file.isDirectory());
        addTaint(file.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_962029362 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_962029362;
        // ---------- Original Method ----------
        //return file.isDirectory();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.527 -0400", hash_original_field = "559F4822D1EA0083710F9598EE051F94", hash_generated_field = "FFBDC809D4125F87CAD18CEFA7FC4B5F")

    public static final IOFileFilter DIRECTORY = new DirectoryFileFilter();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.527 -0400", hash_original_field = "DAAAF2C102539CA5D63554C13738CC3E", hash_generated_field = "459FDE62E0410679E44CF019FA244A16")

    public static final IOFileFilter INSTANCE = DIRECTORY;
}

