package java.lang;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Process;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.lang.InterruptedException;



public class DroidSafeProcess extends Process {
    
    @DSModeled(DSC.SAFE)
    public DroidSafeProcess ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    public void destroy() {
    }

    
    @DSModeled(DSC.SPEC)
    public int exitValue() {
        return getTaintInt();
    }

    
    @DSModeled(DSC.SPEC)
    public  InputStream getErrorStream() {
        return new PipedInputStream();
    }

    
    @DSModeled(DSC.SPEC)
    public  InputStream getInputStream() {
        return new PipedInputStream();
    }

    
    @DSModeled(DSC.SPEC)
    public  OutputStream getOutputStream() {
        return new PipedOutputStream();
    }

    
    @DSModeled(DSC.SPEC)
    public  int waitFor() throws InterruptedException {
        if (getTaintBoolean())
            throw new InterruptedException();
        return getTaintInt();
    }

    
}

