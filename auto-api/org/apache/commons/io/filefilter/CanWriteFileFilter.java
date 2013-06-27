package org.apache.commons.io.filefilter;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.File;
import java.io.Serializable;

public class CanWriteFileFilter extends AbstractFileFilter implements Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.559 -0400", hash_original_method = "AE68C1645286560831358DD2BB3F1723", hash_generated_method = "0B6033D5281775EE9204ED7901AE31EE")
    protected  CanWriteFileFilter() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.559 -0400", hash_original_method = "B6CCE4550C29DDD6A02AB62B3A5D936A", hash_generated_method = "6147F528B33DA24AD1CB7F21A075B90E")
    @Override
    public boolean accept(File file) {
        boolean varF6D83568CA313D1752DE7261BFDB7B3A_37379493 = (file.canWrite());
        addTaint(file.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1713602031 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1713602031;
        // ---------- Original Method ----------
        //return file.canWrite();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.559 -0400", hash_original_field = "17A1807418F78A380B43923FEEDF331F", hash_generated_field = "A3964A58D6B3E2E13859E9158683D5C1")

    public static final IOFileFilter CAN_WRITE = new CanWriteFileFilter();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.559 -0400", hash_original_field = "930200FA00633805C288CCD3E13F0FE3", hash_generated_field = "85C2AAC3B405DA292BEEC74A1FADE62C")

    public static final IOFileFilter CANNOT_WRITE = new NotFileFilter(CAN_WRITE);
}

