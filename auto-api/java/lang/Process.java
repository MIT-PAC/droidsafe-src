package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class Process {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.918 -0400", hash_original_method = "86A1594DC3DA916C52311729E4DF63F1", hash_generated_method = "86A1594DC3DA916C52311729E4DF63F1")
        public Process ()
    {
    }


    public abstract void destroy();

    
    public abstract int exitValue();

    
    public abstract InputStream getErrorStream();

    
    public abstract InputStream getInputStream();

    
    public abstract OutputStream getOutputStream();

    
    public abstract int waitFor() throws InterruptedException;

    
}

