package droidsafe.concrete;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Process;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.lang.InterruptedException;

public class DroidSafeProcess extends Process {
    
    @DSSafe(DSCat.SAFE_LIST)

    public DroidSafeProcess ()
    {
        //Synthesized constructor
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    public void destroy() {
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.OS_PROCESS})
    public int exitValue() {
        return getTaintInt();
    }
    
    @DSSpec(DSCat.IO) 
    public  InputStream getErrorStream() {
        return new PipedInputStream();
    }
    
    @DSSource({DSSourceKind.OS_PROCESS})
    @DSSpec(DSCat.IO) 
    public  InputStream getInputStream() {        
        return new PipedInputStream();
    }
    
   @DSSpec(DSCat.IO) 
    public  OutputStream getOutputStream() {
        return new PipedOutputStream();
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    public  int waitFor() throws InterruptedException {
        if (getTaintBoolean())
            throw new InterruptedException();
        return getTaintInt();
    }
    
}

