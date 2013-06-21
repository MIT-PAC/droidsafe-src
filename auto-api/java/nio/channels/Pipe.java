package java.nio.channels;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.SelectorProvider;

public abstract class Pipe {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.127 -0400", hash_original_method = "AB1C252ACF4CEE3E1F01631225D9EB55", hash_generated_method = "FDC0FEC870B63611D7A177DD42514223")
    @DSModeled(DSC.SAFE)
    protected Pipe() {
        // ---------- Original Method ----------
    }

    
        public static Pipe open() throws IOException {
        return SelectorProvider.provider().openPipe();
    }

    
    public abstract SinkChannel sink();

    
    public abstract SourceChannel source();

    
    public static abstract class SinkChannel extends AbstractSelectableChannel implements WritableByteChannel, GatheringByteChannel {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.127 -0400", hash_original_method = "6199DECCB48C88702EC19067764991B0", hash_generated_method = "417E7A8811CBA5EA794546377F37BCF1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected SinkChannel(SelectorProvider provider) {
            super(provider);
            dsTaint.addTaint(provider.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.128 -0400", hash_original_method = "C028D25CCC7628B8923253B7D8B4C45A", hash_generated_method = "BE9884454A23F3696D37891485B229D5")
        @DSModeled(DSC.SAFE)
        @Override
        public final int validOps() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return SelectionKey.OP_WRITE;
        }

        
    }


    
    public static abstract class SourceChannel extends AbstractSelectableChannel implements ReadableByteChannel, ScatteringByteChannel {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.128 -0400", hash_original_method = "9817FE62735CF1F1F50A3C676A019302", hash_generated_method = "1D41F71234BBD2E635F7E2B511C9C57F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected SourceChannel(SelectorProvider provider) {
            super(provider);
            dsTaint.addTaint(provider.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.128 -0400", hash_original_method = "D2EA48B97033CCCA8D2B0ECC7F0D7822", hash_generated_method = "847151EAC92D6B1914F6039F45AA083D")
        @DSModeled(DSC.SAFE)
        @Override
        public final int validOps() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return SelectionKey.OP_READ;
        }

        
    }


    
}

