package java.lang;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.InputStream;
import java.io.OutputStream;





public abstract class Process {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.423 -0400", hash_original_method = "F1A8A517686D0631650544C6E6120854", hash_generated_method = "F1A8A517686D0631650544C6E6120854")
    public Process ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    public abstract void destroy();

    
    @DSModeled(DSC.SPEC)
    public abstract int exitValue();

    
    @DSModeled(DSC.SPEC)
    public abstract InputStream getErrorStream();

    
    @DSModeled(DSC.SPEC)
    public abstract InputStream getInputStream();

    
    @DSModeled(DSC.SPEC)
    public abstract OutputStream getOutputStream();

    
    @DSModeled(DSC.SPEC)
    public abstract int waitFor() throws InterruptedException;

    
}

