package org.apache.commons.io.filefilter;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.File;
import java.io.Serializable;

public class FileFileFilter extends AbstractFileFilter implements Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.725 -0400", hash_original_method = "6C359A458FCB96D5F455747E20D28BA8", hash_generated_method = "D35D8143BC7776BC0DB590B3613E1A0B")
    protected  FileFileFilter() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.725 -0400", hash_original_method = "981FD37767829C6F7D8558BD0416446C", hash_generated_method = "3A493F0AA7CE86A34ED15B2C57664969")
    @Override
    public boolean accept(File file) {
        boolean varE0D8C254B67919B0273BA9DE431A7A83_152028870 = (file.isFile());
        addTaint(file.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_439099738 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_439099738;
        // ---------- Original Method ----------
        //return file.isFile();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.725 -0400", hash_original_field = "D2350BCB921DA11A683B2DE15E615547", hash_generated_field = "92710DC7C7D00B54B62B3FA27DB38D86")

    public static final IOFileFilter FILE = new FileFileFilter();
}

