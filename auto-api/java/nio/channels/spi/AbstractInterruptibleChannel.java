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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.143 -0400", hash_original_method = "AE7E9C29A12236996DA74E23561B6760", hash_generated_method = "A82EC148D3A353CBA856B48EDD1EC897")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.144 -0400", hash_original_method = "8D566223F7B6A201818F5E4BFCF4F6EB", hash_generated_method = "06F598EF6A4A993889CD9DF449D06062")
    @DSModeled(DSC.SAFE)
    protected AbstractInterruptibleChannel() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.146 -0400", hash_original_method = "EEF08D7C99E69679C24335EC336EDE1D", hash_generated_method = "30C0D6B2AB303DC54CC8C51F91761B94")
    @DSModeled(DSC.SAFE)
    @Override
    public synchronized final boolean isOpen() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return !closed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.146 -0400", hash_original_method = "4C9E4AC237D7628755D560FFD1AA5234", hash_generated_method = "BCA59A95215F14F7536ADCAE6AB1CFE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.147 -0400", hash_original_method = "F0AA56CB3350B0CEA7EF4FF29453D45D", hash_generated_method = "6DCC83F0ECF94F334D94D331BE79DAA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected final void begin() {
        Thread.currentThread().pushInterruptAction$(interruptAndCloseRunnable);
        // ---------- Original Method ----------
        //Thread.currentThread().pushInterruptAction$(interruptAndCloseRunnable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.147 -0400", hash_original_method = "9F919A15107680D02C9F3C07FD906976", hash_generated_method = "A9DFB77C1442091619A40F973FF47D75")
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

