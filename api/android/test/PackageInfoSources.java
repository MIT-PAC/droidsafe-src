package android.test;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class PackageInfoSources {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.039 -0500", hash_original_method = "9719EF5B549FD66C156C59417FC5EEF1", hash_generated_method = "9CFD097D0752C8E55434B0E41F3C2A43")
    
public static ClassPathPackageInfoSource forClassPath(ClassLoader classLoader) {
        if (classPathSource == null) {
            classPathSource = new ClassPathPackageInfoSource();
            classPathSource.setClassLoader(classLoader);
        }
        return classPathSource;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.034 -0500", hash_original_field = "85C40957B1A3F8C6ADB9A21ACCD9244D", hash_generated_field = "CC66F29E48F19D052BC50DDBC8CF9308")


    private static ClassPathPackageInfoSource classPathSource;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.037 -0500", hash_original_method = "20BC19A093C9C1A7F81C885B5938F700", hash_generated_method = "C5DFAB45B0528626C1774129AE322A2A")
    
private PackageInfoSources() {
    }
}

