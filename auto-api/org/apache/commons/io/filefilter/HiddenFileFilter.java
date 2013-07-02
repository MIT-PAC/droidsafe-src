package org.apache.commons.io.filefilter;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.File;
import java.io.Serializable;

public class HiddenFileFilter extends AbstractFileFilter implements Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.802 -0400", hash_original_method = "27CCA45322132EC040C5AEC325BA1F4E", hash_generated_method = "75985F963D626935C7BD7BE3A1D941DF")
    protected  HiddenFileFilter() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.803 -0400", hash_original_method = "423B72A848C918F2592E84C74B14F648", hash_generated_method = "4C7BA4A4619ABEEB5BC09FB2D4C757D5")
    @Override
    public boolean accept(File file) {
        boolean var8600FFEF40CC08E92310742EB4C75B96_2043263133 = (file.isHidden());
        addTaint(file.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1327078616 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1327078616;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.803 -0400", hash_original_field = "1C150BB359A52FB4290ACF04133BD440", hash_generated_field = "FE73352A357F740BB4C5E6EAE324D092")

    public static final IOFileFilter HIDDEN  = new HiddenFileFilter();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.803 -0400", hash_original_field = "C53B2D055FD8D82A2BA942B4DE3CB7AD", hash_generated_field = "B1C20113B87CE45E1D42C35241C448E2")

    public static final IOFileFilter VISIBLE = new NotFileFilter(HIDDEN);
}

