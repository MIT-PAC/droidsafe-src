package org.apache.commons.io.filefilter;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.Serializable;

public class DelegateFileFilter extends AbstractFileFilter implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.700 -0400", hash_original_field = "0B21892525E827C717C0BF1B97DB1F53", hash_generated_field = "3508DB9A679B391304D72C5E2F8C7ED4")

    private FilenameFilter filenameFilter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.700 -0400", hash_original_field = "DD3C21767F834808110E982822401857", hash_generated_field = "C458D0AE68C90865AFA5E634223F0231")

    private FileFilter fileFilter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.701 -0400", hash_original_method = "06A6660F6D4FB6BA3833CB3AAC8DFB22", hash_generated_method = "DDA3AFF55F22E2FCEFF7085646460E05")
    public  DelegateFileFilter(FilenameFilter filter) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The FilenameFilter must not be null");
        } 
        this.filenameFilter = filter;
        this.fileFilter = null;
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.702 -0400", hash_original_method = "D78E0EE5BCA43F28DAC7F37C22E8C1C2", hash_generated_method = "67F844875D43E8DF04666B31093B2758")
    public  DelegateFileFilter(FileFilter filter) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("The FileFilter must not be null");
        } 
        this.fileFilter = filter;
        this.filenameFilter = null;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.703 -0400", hash_original_method = "66B0B66E42A219E5BE68409D81797981", hash_generated_method = "A8A14AEA005364767C23D3E87B122A67")
    @Override
    public boolean accept(File file) {
        {
            boolean var2B418F20FFEE7D76673E383CB25ACBD3_1020066169 = (fileFilter.accept(file));
        } 
        {
            boolean varCDFF85CE41A2DAC29FF41B261822C377_1849738807 = (super.accept(file));
        } 
        addTaint(file.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1306503891 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1306503891;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.704 -0400", hash_original_method = "49013355B881E412B579D906E9AC6664", hash_generated_method = "A2B4703B3170DFAB4787ABCBF99C3D78")
    @Override
    public boolean accept(File dir, String name) {
        {
            boolean var845564FB8B8D666082E9C4D6C1DC5970_1534066412 = (filenameFilter.accept(dir, name));
        } 
        {
            boolean var5E8120C1715727F7D44E792F61CF882A_664345810 = (super.accept(dir, name));
        } 
        addTaint(dir.getTaint());
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1984137861 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1984137861;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.707 -0400", hash_original_method = "91D8A9301108FBA1FFC97CB499D3FAE9", hash_generated_method = "26AEB266DD198ACF58D2ECE7851E162F")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1565906693 = null; 
        String delegate;
        delegate = fileFilter.toString();
        delegate = filenameFilter.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1565906693 = super.toString() + "(" + delegate + ")";
        varB4EAC82CA7396A68D541C85D26508E83_1565906693.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1565906693;
        
        
        
    }

    
}

