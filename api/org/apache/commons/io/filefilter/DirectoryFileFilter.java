package org.apache.commons.io.filefilter;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.File;
import java.io.Serializable;

public class DirectoryFileFilter extends AbstractFileFilter implements Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.713 -0400", hash_original_method = "271A2DD2196E2818F8A34D7CEDB3A1A7", hash_generated_method = "0D5911F1A17B74E32BF0921AEF88F306")
    protected  DirectoryFileFilter() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.713 -0400", hash_original_method = "39BD0BE636DBD4121253CD6DED7A982C", hash_generated_method = "924C55AA0D8B8533D7708A2B5689E9F5")
    @Override
    public boolean accept(File file) {
        boolean var01ABB463F7875458D9545BDC15E68739_72521775 = (file.isDirectory());
        addTaint(file.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_352409670 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_352409670;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.713 -0400", hash_original_field = "559F4822D1EA0083710F9598EE051F94", hash_generated_field = "FFBDC809D4125F87CAD18CEFA7FC4B5F")

    public static final IOFileFilter DIRECTORY = new DirectoryFileFilter();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.713 -0400", hash_original_field = "DAAAF2C102539CA5D63554C13738CC3E", hash_generated_field = "459FDE62E0410679E44CF019FA244A16")

    public static final IOFileFilter INSTANCE = DIRECTORY;
}

