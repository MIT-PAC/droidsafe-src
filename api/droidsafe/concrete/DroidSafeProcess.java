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
    
    public DroidSafeProcess ()
    {
        //Synthesized constructor
    }
    
    public void destroy() {
    }

    @DSSource({DSSourceKind.OS_PROCESS})
    public int exitValue() {
        return getTaintInt();
    }
    
    public  InputStream getErrorStream() {
        return new PipedInputStream();
    }
    
    @DSSource({DSSourceKind.OS_PROCESS})
    public  InputStream getInputStream() {        
        return new PipedInputStream();
    }
    
    public  OutputStream getOutputStream() {
        return new PipedOutputStream();
    }
    
    public  int waitFor() throws InterruptedException {
        if (getTaintBoolean())
            throw new InterruptedException();
        return getTaintInt();
    }
    
}

