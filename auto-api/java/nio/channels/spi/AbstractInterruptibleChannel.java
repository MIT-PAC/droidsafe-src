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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.584 -0400", hash_original_field = "1E79543A888DE7BB0ADBB289A8F4251D", hash_generated_field = "ACA7C061F36840D4F0EB869DD1E1AB7C")

    private volatile boolean closed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.585 -0400", hash_original_field = "BA68CAEFFB1A8327FC6344D171E392C8", hash_generated_field = "40A458BD5C00C50CD6C70C9B2D7F702B")

    volatile boolean interrupted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.592 -0400", hash_original_field = "EABFBB4303F4F38DE6361EA110D0C225", hash_generated_field = "B2D49D52DA0242C9BB4F0C2CC7C3410C")

    private Runnable interruptAndCloseRunnable = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.591 -0400", hash_original_method = "AE7E9C29A12236996DA74E23561B6760", hash_generated_method = "A82EC148D3A353CBA856B48EDD1EC897")
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

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.592 -0400", hash_original_method = "8D566223F7B6A201818F5E4BFCF4F6EB", hash_generated_method = "06F598EF6A4A993889CD9DF449D06062")
    protected  AbstractInterruptibleChannel() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.593 -0400", hash_original_method = "EEF08D7C99E69679C24335EC336EDE1D", hash_generated_method = "B6FD5AE31BBEBD36A7B421BD4C2442D1")
    @Override
    public synchronized final boolean isOpen() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_584074474 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_584074474;
        // ---------- Original Method ----------
        //return !closed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.600 -0400", hash_original_method = "4C9E4AC237D7628755D560FFD1AA5234", hash_generated_method = "BCA59A95215F14F7536ADCAE6AB1CFE0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.612 -0400", hash_original_method = "F0AA56CB3350B0CEA7EF4FF29453D45D", hash_generated_method = "6DCC83F0ECF94F334D94D331BE79DAA7")
    protected final void begin() {
        Thread.currentThread().pushInterruptAction$(interruptAndCloseRunnable);
        // ---------- Original Method ----------
        //Thread.currentThread().pushInterruptAction$(interruptAndCloseRunnable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:46.629 -0400", hash_original_method = "9F919A15107680D02C9F3C07FD906976", hash_generated_method = "64CD59270C91E6188321961303BAFEB1")
    protected final void end(boolean success) throws AsynchronousCloseException {
        Thread.currentThread().popInterruptAction$(interruptAndCloseRunnable);
        {
            interrupted = false;
            if (DroidSafeAndroidRuntime.control) throw new ClosedByInterruptException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new AsynchronousCloseException();
        } //End block
        addTaint(success);
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

