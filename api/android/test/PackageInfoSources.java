package android.test;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class PackageInfoSources {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.124 -0400", hash_original_method = "20BC19A093C9C1A7F81C885B5938F700", hash_generated_method = "846EA8EA3F675CB9A6FF18093CBD0222")
    private  PackageInfoSources() {
        
    }

    
        @DSModeled(DSC.BAN)
    public static ClassPathPackageInfoSource forClassPath(ClassLoader classLoader) {
        if (classPathSource == null) {
            classPathSource = new ClassPathPackageInfoSource();
            classPathSource.setClassLoader(classLoader);
        }
        return classPathSource;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.124 -0400", hash_original_field = "ACCACB8D97A666908FB8109AA56560ED", hash_generated_field = "CC66F29E48F19D052BC50DDBC8CF9308")

    private static ClassPathPackageInfoSource classPathSource;
}

