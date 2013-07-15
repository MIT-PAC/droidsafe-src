package org.apache.commons.io.filefilter;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.File;
import java.io.Serializable;

public class CanReadFileFilter extends AbstractFileFilter implements Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.690 -0400", hash_original_method = "BDC602CCB29EA618773E287B406AEBFF", hash_generated_method = "3AA53622D67341B3F364451B2BBE4AD8")
    protected  CanReadFileFilter() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.690 -0400", hash_original_method = "04EA67B3A82204BBE7F5B271F46DC797", hash_generated_method = "C01C3413B8FED85B138A5A3D682A88C5")
    @Override
    public boolean accept(File file) {
        boolean var7879C533F0600A2DEB5B558CD8C9817C_1627427693 = (file.canRead());
        addTaint(file.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_691714733 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_691714733;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.690 -0400", hash_original_field = "B4FD8E6B24E4566945169F5CBEE50082", hash_generated_field = "20F7263960F4D59AE6AF2AE0B45193FC")

    public static final IOFileFilter CAN_READ = new CanReadFileFilter();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.690 -0400", hash_original_field = "8BCE6BC1E75C1F38609189F479D02C54", hash_generated_field = "9778DFD6EB1664F640DCDC2A976B47BC")

    public static final IOFileFilter CANNOT_READ = new NotFileFilter(CAN_READ);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.690 -0400", hash_original_field = "E3FA1B7C9B28F897157DAF2E40A406AF", hash_generated_field = "FE092675685C2757B28FB2C1916FBC5B")

    public static final IOFileFilter READ_ONLY = new AndFileFilter(CAN_READ,
                                                CanWriteFileFilter.CANNOT_WRITE);
}

