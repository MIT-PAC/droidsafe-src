package org.apache.commons.io.filefilter;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.File;
import java.io.Serializable;

public class NotFileFilter extends AbstractFileFilter implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.859 -0400", hash_original_field = "B2C97AE425DD751B0E48A3ACAE79CF4A", hash_generated_field = "52033831AA90808CFA0612D7E68F3072")

    private IOFileFilter filter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.860 -0400", hash_original_method = "04147093F1D1C98977C291FCABD47396", hash_generated_method = "85B019E6DF3088463879CD7DAEBFF200")
    public  NotFileFilter(IOFileFilter filter) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The filter must not be null");
        } 
        this.filter = filter;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.860 -0400", hash_original_method = "B4759F01CF5E4CDF4AA4061B5D979652", hash_generated_method = "DD8077FD4D151331D8AE38D61A79F9B2")
    @Override
    public boolean accept(File file) {
        boolean var80D9FD0923D43FFBF468F0752630EE80_171797715 = (! filter.accept(file));
        addTaint(file.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_18824643 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_18824643;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.861 -0400", hash_original_method = "B0A127C96A64726487AA51E16A0E3CC5", hash_generated_method = "EB6AB6FB0EA3C6F8EFE0E30C1AAB172A")
    @Override
    public boolean accept(File file, String name) {
        boolean var6F09DE2E60A0CA42F51700E9824CECB6_396826124 = (! filter.accept(file, name));
        addTaint(file.getTaint());
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1368021819 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1368021819;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.862 -0400", hash_original_method = "0F98CEE5769F2D254ED7C2ED79018DD6", hash_generated_method = "527F9E4E32F39A801AC8F8C26059B2EB")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_248645613 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_248645613 = super.toString() + "(" + filter.toString()  + ")";
        varB4EAC82CA7396A68D541C85D26508E83_248645613.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_248645613;
        
        
    }

    
}

