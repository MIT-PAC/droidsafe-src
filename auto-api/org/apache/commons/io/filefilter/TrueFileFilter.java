package org.apache.commons.io.filefilter;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.File;
import java.io.Serializable;

public class TrueFileFilter implements IOFileFilter, Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.771 -0400", hash_original_method = "623EDDCAAC7B1519CF46C5182C287E51", hash_generated_method = "BA8AAA9E71FB16CD802B9E79E6DC9141")
    protected  TrueFileFilter() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.771 -0400", hash_original_method = "E5F31B8C7E0E55836854007EF229F8F0", hash_generated_method = "D2B64BAE12484F2B723AFF03F18A2B65")
    public boolean accept(File file) {
        addTaint(file.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_530917035 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_530917035;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.772 -0400", hash_original_method = "DC2C6FD0F14A1434DB9ECFEAE61B09B4", hash_generated_method = "5CAD40620003CA1B87FF6A5B63D8CDA7")
    public boolean accept(File dir, String name) {
        addTaint(dir.getTaint());
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_834875276 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_834875276;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.772 -0400", hash_original_field = "E64B30149C802DBCED359EE56567D600", hash_generated_field = "9ECCE779CFBBCF3D69F57CEC53256E69")

    public static final IOFileFilter TRUE = new TrueFileFilter();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:06.772 -0400", hash_original_field = "25EF5C19B0F970AD7306D8FE5852D90C", hash_generated_field = "FAA97B620273D1C27003F3B6358EDC7A")

    public static final IOFileFilter INSTANCE = TRUE;
}

