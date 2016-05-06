package droidsafe.concrete;

import droidsafe.runtime.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.File;

import droidsafe.annotations.DSCat;
import droidsafe.annotations.DSSink;
import droidsafe.annotations.DSSinkKind;
import droidsafe.annotations.DSSpec;

public class DroidSafeFileOutputStream extends FileOutputStream {

    public DroidSafeFileOutputStream(String path) throws FileNotFoundException {
        super(path);
    }

    public DroidSafeFileOutputStream(String path, boolean append) throws FileNotFoundException {
        super(path, append);
    }

    public DroidSafeFileOutputStream(File path) throws FileNotFoundException {
        super(path);
    }

    public DroidSafeFileOutputStream(File path, boolean append) throws FileNotFoundException {
        super(path, append);
    }

    
    public DroidSafeFileOutputStream(String path, int mode) throws FileNotFoundException {
        super(path, mode);
    }

    
    @Override
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.IO})
    public void write(int v) {
        //DO NOT CHANGE: FilePrecisionTransforms depends on this exact body
        DroidSafeAndroidRuntime.FILE_SYSTEM_TAINT = v;
    }	
}
