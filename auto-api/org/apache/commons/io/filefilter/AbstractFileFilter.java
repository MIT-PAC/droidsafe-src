package org.apache.commons.io.filefilter;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.File;

public abstract class AbstractFileFilter implements IOFileFilter {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.491 -0400", hash_original_method = "1070BDF040A3E546C698D5308D537416", hash_generated_method = "1070BDF040A3E546C698D5308D537416")
    public AbstractFileFilter ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.492 -0400", hash_original_method = "D5DE3D5D9AF246B7B9A0720792C74103", hash_generated_method = "76AAE1176866EB2D08110284A3338A6F")
    public boolean accept(File file) {
        boolean var31E4DD045613FE624A61BA80DF84F8C5_1069520924 = (accept(file.getParentFile(), file.getName()));
        addTaint(file.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1916331287 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1916331287;
        // ---------- Original Method ----------
        //return accept(file.getParentFile(), file.getName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.492 -0400", hash_original_method = "0C86CF264F403F294009DA2383C206BD", hash_generated_method = "2A4F7E244A74387136E47E207B7F2686")
    public boolean accept(File dir, String name) {
        boolean var3E21D6759A1A343E5617851F35D52AEF_501599539 = (accept(new File(dir, name)));
        addTaint(dir.getTaint());
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_821618086 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_821618086;
        // ---------- Original Method ----------
        //return accept(new File(dir, name));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:07.493 -0400", hash_original_method = "CC6A2D61A01777F134B61F210B4582B4", hash_generated_method = "1C2EC435F25F85CD92EB24609C9FBEC6")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2066774379 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2066774379 = getClass().getSimpleName();
        varB4EAC82CA7396A68D541C85D26508E83_2066774379.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2066774379;
        // ---------- Original Method ----------
        //return getClass().getSimpleName();
    }

    
}

