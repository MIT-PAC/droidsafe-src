package droidsafe.concrete;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import droidsafe.annotations.DSCat;
import droidsafe.annotations.DSComment;
import droidsafe.annotations.DSSource;
import droidsafe.annotations.DSSourceKind;
import droidsafe.annotations.DSSpec;
import droidsafe.runtime.DroidSafeAndroidRuntime;

public class DroidSafeFileInputStream extends FileInputStream {	
    
    public DroidSafeFileInputStream(String path) throws FileNotFoundException {
        super(path);		
    }
    
    @DSSource({DSSourceKind.IO})
    public int read() throws IOException {
        //DO NOT CHANGE: FilePrecisionTransforms depends on this exact body
        return DroidSafeAndroidRuntime.FILE_SYSTEM_TAINT;
    }

}
