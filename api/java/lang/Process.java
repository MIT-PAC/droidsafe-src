package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class Process {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.101 -0400", hash_original_method = "F1A8A517686D0631650544C6E6120854", hash_generated_method = "F1A8A517686D0631650544C6E6120854")
    public Process ()
    {
        //Synthesized constructor
    }


    public abstract void destroy();

    
    public abstract int exitValue();

    
    public abstract InputStream getErrorStream();

    
    public abstract InputStream getInputStream();

    
    public abstract OutputStream getOutputStream();

    
    public abstract int waitFor() throws InterruptedException;

    
}

