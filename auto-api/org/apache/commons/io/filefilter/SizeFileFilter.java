package org.apache.commons.io.filefilter;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.File;
import java.io.Serializable;

public class SizeFileFilter extends AbstractFileFilter implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.935 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "CB917F06730B11F4BAAAFECA2C1D90A2")

    private long size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.935 -0400", hash_original_field = "A5D3176F343A19DA0115EBC646D3F2C9", hash_generated_field = "A18E88D88160DB836B3E001438D9A208")

    private boolean acceptLarger;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.935 -0400", hash_original_method = "4719DD4974D08080A970216FF9540658", hash_generated_method = "90D279A5F9AF58833923C35227D69308")
    public  SizeFileFilter(long size) {
        this(size, true);
        addTaint(size);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.936 -0400", hash_original_method = "6B587AAF95AB16F29075A6F84F0CB503", hash_generated_method = "3BD8B82809E2CDF90FDA1900B5A234F1")
    public  SizeFileFilter(long size, boolean acceptLarger) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The size must be non-negative");
        } 
        this.size = size;
        this.acceptLarger = acceptLarger;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.936 -0400", hash_original_method = "13EB4F7103C9E58EC2AD605053CF5788", hash_generated_method = "30CAEA7473C2C3B262ABAECD4BBEFEFC")
    @Override
    public boolean accept(File file) {
        boolean smaller = file.length() < size;
        addTaint(file.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_394332050 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_394332050;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.936 -0400", hash_original_method = "9CC552A05DC39BBA2C336B2A0E87E39E", hash_generated_method = "F6C4D8B71FA160155C64274CC79C8D22")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_796050906 = null; 
        String condition;
        condition = ">=";
        condition = "<";
        varB4EAC82CA7396A68D541C85D26508E83_796050906 = super.toString() + "(" + condition + size + ")";
        varB4EAC82CA7396A68D541C85D26508E83_796050906.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_796050906;
        
        
        
    }

    
}

