package org.apache.commons.io.filefilter;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.File;

public abstract class AbstractFileFilter implements IOFileFilter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.616 -0400", hash_original_method = "1070BDF040A3E546C698D5308D537416", hash_generated_method = "1070BDF040A3E546C698D5308D537416")
    public AbstractFileFilter ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.616 -0400", hash_original_method = "D5DE3D5D9AF246B7B9A0720792C74103", hash_generated_method = "0375EACD3834ADF7CB74820EBF1D724A")
    public boolean accept(File file) {
        boolean var31E4DD045613FE624A61BA80DF84F8C5_731171701 = (accept(file.getParentFile(), file.getName()));
        addTaint(file.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1117374560 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1117374560;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.617 -0400", hash_original_method = "0C86CF264F403F294009DA2383C206BD", hash_generated_method = "F994DBE34AF5BE7CE2CD183AA356A561")
    public boolean accept(File dir, String name) {
        boolean var3E21D6759A1A343E5617851F35D52AEF_1827340131 = (accept(new File(dir, name)));
        addTaint(dir.getTaint());
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1047582598 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1047582598;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.617 -0400", hash_original_method = "CC6A2D61A01777F134B61F210B4582B4", hash_generated_method = "1FB3800337CF7FF2AA128E16BA055CD7")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_865983891 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_865983891 = getClass().getSimpleName();
        varB4EAC82CA7396A68D541C85D26508E83_865983891.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_865983891;
        
        
    }

    
}

