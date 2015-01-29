package java.nio.channels;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.SelectorProvider;

public abstract class Pipe {

    /**
     * Returns a new pipe from the default {@see java.nio.channels.spi.SelectorProvider}.
     *
     * @throws IOException
     *             if an I/O error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.777 -0500", hash_original_method = "DEAA17350CC2E5E935405ABC338450AB", hash_generated_method = "8C5D6C0F92E4264803AD977F0CB40CEC")
    
public static Pipe open() throws IOException {
        return SelectorProvider.provider().openPipe();
    }

    /**
     * The protected default constructor.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.781 -0500", hash_original_method = "AB1C252ACF4CEE3E1F01631225D9EB55", hash_generated_method = "402940CFAE1ABA8620A2D5B606F4117F")
    
protected Pipe() {
    }

    /**
     * Returns the sink channel of the pipe.
     *
     * @return a writable sink channel of the pipe.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.783 -0500", hash_original_method = "AD3F0081408BB2FCEECAE63479FE7E5A", hash_generated_method = "E0239CD9C0D91AE8D96FDA2FAA979DD8")
    
public abstract SinkChannel sink();

    /**
     * Returns the source channel of the pipe.
     *
     * @return a readable source channel of the pipe.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.786 -0500", hash_original_method = "B343D6974A4C4F073595EF38542D761F", hash_generated_method = "C2E867FEB59FED1AE08078B3B51F39A5")
    
public abstract SourceChannel source();
    
    public static abstract class SinkChannel extends AbstractSelectableChannel implements WritableByteChannel, GatheringByteChannel {
        /**
         * Constructs a new {@code SinkChannel}.
         *
         * @param provider
         *            the provider of the channel.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.763 -0500", hash_original_method = "6199DECCB48C88702EC19067764991B0", hash_generated_method = "85F41140EAC6B7FFBC2B221FE48DA53F")
        
protected SinkChannel(SelectorProvider provider) {
            super(provider);
        }

        /**
         * Indicates that this channel only supports writing.
         *
         * @return a static value of OP_WRITE.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.765 -0500", hash_original_method = "C028D25CCC7628B8923253B7D8B4C45A", hash_generated_method = "EC431122F271EADC293EE80F5B6817E1")
        
@Override
        public final int validOps() {
            return SelectionKey.OP_WRITE;
        }
        
    }
    
    public static abstract class SourceChannel extends AbstractSelectableChannel implements ReadableByteChannel, ScatteringByteChannel {
        /**
         * Constructs a new {@code SourceChannel}.
         *
         * @param provider
         *            the provider of the channel.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.770 -0500", hash_original_method = "9817FE62735CF1F1F50A3C676A019302", hash_generated_method = "C23D2215BDF603EA893EBE51BFD85CCF")
        
protected SourceChannel(SelectorProvider provider) {
            super(provider);
        }

        /**
         * Indicates that this channel only supports reading.
         *
         * @return a static value of OP_READ.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.773 -0500", hash_original_method = "D2EA48B97033CCCA8D2B0ECC7F0D7822", hash_generated_method = "4B8803BC0EE51139D29E4539E5B57336")
        
@Override
        public final int validOps() {
            return SelectionKey.OP_READ;
        }
        
    }
    
}

