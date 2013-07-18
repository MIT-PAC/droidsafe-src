package java.lang;

// Droidsafe Imports
import java.io.InputStream;
import java.io.OutputStream;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class Process {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.423 -0400", hash_original_method = "F1A8A517686D0631650544C6E6120854", hash_generated_method = "F1A8A517686D0631650544C6E6120854")
    public Process ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    public abstract void destroy();

    
    @DSModeled(DSC.SAFE)
    public abstract int exitValue();

    
    @DSModeled(DSC.SAFE)
    public abstract InputStream getErrorStream();

    
    @DSModeled(DSC.SAFE)
    public abstract InputStream getInputStream();

    
    @DSModeled(DSC.SAFE)
    public abstract OutputStream getOutputStream();

    
    @DSModeled(DSC.SAFE)
    public abstract int waitFor() throws InterruptedException;

    
}

