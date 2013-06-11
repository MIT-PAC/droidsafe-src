package java.nio.channels;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.SelectorProvider;

public abstract class Pipe {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.487 -0400", hash_original_method = "AB1C252ACF4CEE3E1F01631225D9EB55", hash_generated_method = "FCBA0F3869BB83F688A1F9381A16CBB7")
    @DSModeled(DSC.SAFE)
    protected Pipe() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.487 -0400", hash_original_method = "DEAA17350CC2E5E935405ABC338450AB", hash_generated_method = "8C5D6C0F92E4264803AD977F0CB40CEC")
    public static Pipe open() throws IOException {
        return SelectorProvider.provider().openPipe();
    }

    
    public abstract SinkChannel sink();

    
    public abstract SourceChannel source();

    
    public static abstract class SinkChannel extends AbstractSelectableChannel implements WritableByteChannel, GatheringByteChannel {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.487 -0400", hash_original_method = "6199DECCB48C88702EC19067764991B0", hash_generated_method = "A3F74DA2A257A5CAC5BF73B36F7BEAC1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected SinkChannel(SelectorProvider provider) {
            super(provider);
            dsTaint.addTaint(provider.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.487 -0400", hash_original_method = "C028D25CCC7628B8923253B7D8B4C45A", hash_generated_method = "E518D284787D808626D10F8FA80C840A")
        @DSModeled(DSC.SAFE)
        @Override
        public final int validOps() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return SelectionKey.OP_WRITE;
        }

        
    }


    
    public static abstract class SourceChannel extends AbstractSelectableChannel implements ReadableByteChannel, ScatteringByteChannel {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.487 -0400", hash_original_method = "9817FE62735CF1F1F50A3C676A019302", hash_generated_method = "14362CDA6C5338C0B348855564F64226")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected SourceChannel(SelectorProvider provider) {
            super(provider);
            dsTaint.addTaint(provider.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.487 -0400", hash_original_method = "D2EA48B97033CCCA8D2B0ECC7F0D7822", hash_generated_method = "C279941EC52A6968843709A500A1E1DF")
        @DSModeled(DSC.SAFE)
        @Override
        public final int validOps() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return SelectionKey.OP_READ;
        }

        
    }


    
}


