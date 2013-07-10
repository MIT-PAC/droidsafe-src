package org.apache.commons.io.filefilter;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.File;
import java.io.Serializable;

public class CanWriteFileFilter extends AbstractFileFilter implements Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.693 -0400", hash_original_method = "AE68C1645286560831358DD2BB3F1723", hash_generated_method = "0B6033D5281775EE9204ED7901AE31EE")
    protected  CanWriteFileFilter() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.693 -0400", hash_original_method = "B6CCE4550C29DDD6A02AB62B3A5D936A", hash_generated_method = "6D5712D088C2A2F034307F0B7BA37F5B")
    @Override
    public boolean accept(File file) {
        boolean varF6D83568CA313D1752DE7261BFDB7B3A_1485778355 = (file.canWrite());
        addTaint(file.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_856400135 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_856400135;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.693 -0400", hash_original_field = "17A1807418F78A380B43923FEEDF331F", hash_generated_field = "A3964A58D6B3E2E13859E9158683D5C1")

    public static final IOFileFilter CAN_WRITE = new CanWriteFileFilter();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.693 -0400", hash_original_field = "930200FA00633805C288CCD3E13F0FE3", hash_generated_field = "85C2AAC3B405DA292BEEC74A1FADE62C")

    public static final IOFileFilter CANNOT_WRITE = new NotFileFilter(CAN_WRITE);
}

