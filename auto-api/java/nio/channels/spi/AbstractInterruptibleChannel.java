package java.nio.channels.spi;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.Channel;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.InterruptibleChannel;

public abstract class AbstractInterruptibleChannel implements Channel, InterruptibleChannel {
    private volatile boolean closed = false;
    volatile boolean interrupted = false;
    private final Runnable interruptAndCloseRunnable = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:53:51.886 -0400", hash_original_method = "AE7E9C29A12236996DA74E23561B6760", hash_generated_method = "D0927743EF96EFD1561F4B9790CACAA2")
        @DSModeled(DSC.SAFE)
        @Override
        public void run() {
            try 
            {
                interrupted = true;
                AbstractInterruptibleChannel.this.close();
            } //End block
            catch (IOException ignored)
            { }
            // ---------- Original Method ----------
            //try {
                //interrupted = true;
                //AbstractInterruptibleChannel.this.close();
            //} catch (IOException ignored) {
            //}
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:53:51.889 -0400", hash_original_method = "8D566223F7B6A201818F5E4BFCF4F6EB", hash_generated_method = "4966A9D2453BAE8CDF6DB3253BDB1A26")
    @DSModeled(DSC.SAFE)
    protected AbstractInterruptibleChannel() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:53:51.891 -0400", hash_original_method = "EEF08D7C99E69679C24335EC336EDE1D", hash_generated_method = "7CB1A2AED7CAF78EB0D177D1C78CD72E")
    @DSModeled(DSC.SAFE)
    @Override
    public synchronized final boolean isOpen() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return !closed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:53:51.894 -0400", hash_original_method = "4C9E4AC237D7628755D560FFD1AA5234", hash_generated_method = "1A26DE8D835D63DFF10DA0634B0E04FF")
    @DSModeled(DSC.SAFE)
    @Override
    public final void close() throws IOException {
        {
            {
                {
                    closed = true;
                    implCloseChannel();
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (!closed) {
            //synchronized (this) {
                //if (!closed) {
                    //closed = true;
                    //implCloseChannel();
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:53:51.898 -0400", hash_original_method = "F0AA56CB3350B0CEA7EF4FF29453D45D", hash_generated_method = "BCB0111FB79D81ED2998E59B04BF3891")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void begin() {
        Thread.currentThread().pushInterruptAction$(interruptAndCloseRunnable);
        // ---------- Original Method ----------
        //Thread.currentThread().pushInterruptAction$(interruptAndCloseRunnable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 11:53:51.906 -0400", hash_original_method = "9F919A15107680D02C9F3C07FD906976", hash_generated_method = "9AE647C5A1F4007C0208F7677DF76B2F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void end(boolean success) throws AsynchronousCloseException {
        dsTaint.addTaint(success);
        Thread.currentThread().popInterruptAction$(interruptAndCloseRunnable);
        {
            interrupted = false;
            if (DroidSafeAndroidRuntime.control) throw new ClosedByInterruptException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new AsynchronousCloseException();
        } //End block
        // ---------- Original Method ----------
        //Thread.currentThread().popInterruptAction$(interruptAndCloseRunnable);
        //if (interrupted) {
            //interrupted = false;
            //throw new ClosedByInterruptException();
        //}
        //if (!success && closed) {
            //throw new AsynchronousCloseException();
        //}
    }

    
    protected abstract void implCloseChannel() throws IOException;

    
}


