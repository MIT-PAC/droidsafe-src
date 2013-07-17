package java.nio.channels;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.SelectorProvider;

public abstract class Pipe {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.243 -0400", hash_original_method = "AB1C252ACF4CEE3E1F01631225D9EB55", hash_generated_method = "FDC0FEC870B63611D7A177DD42514223")
    protected  Pipe() {
        // ---------- Original Method ----------
    }

    
    public static Pipe open() throws IOException {
        return SelectorProvider.provider().openPipe();
    }

    
    @DSModeled(DSC.SAFE)
    public abstract SinkChannel sink();

    
    @DSModeled(DSC.SAFE)
    public abstract SourceChannel source();

    
    public static abstract class SinkChannel extends AbstractSelectableChannel implements WritableByteChannel, GatheringByteChannel {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.245 -0400", hash_original_method = "6199DECCB48C88702EC19067764991B0", hash_generated_method = "C72698FDAA0C247A4C9BAA911A820984")
        protected  SinkChannel(SelectorProvider provider) {
            super(provider);
            addTaint(provider.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.246 -0400", hash_original_method = "C028D25CCC7628B8923253B7D8B4C45A", hash_generated_method = "5678EAF84A8EE85979DC14D88223D018")
        @Override
        public final int validOps() {
            int var53A444133ECFA2A63AB8406200B028D1_73088768 = (SelectionKey.OP_WRITE);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2025395353 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2025395353;
            // ---------- Original Method ----------
            //return SelectionKey.OP_WRITE;
        }

        
    }


    
    public static abstract class SourceChannel extends AbstractSelectableChannel implements ReadableByteChannel, ScatteringByteChannel {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.247 -0400", hash_original_method = "9817FE62735CF1F1F50A3C676A019302", hash_generated_method = "F17F93443685466D9F960296B170ECA4")
        protected  SourceChannel(SelectorProvider provider) {
            super(provider);
            addTaint(provider.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.248 -0400", hash_original_method = "D2EA48B97033CCCA8D2B0ECC7F0D7822", hash_generated_method = "D2C69C211E2C5158B83CDBE936CFD2D3")
        @Override
        public final int validOps() {
            int varA020689BBAF72FA5CC26EDDF439F5FFD_1279661883 = (SelectionKey.OP_READ);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_770043295 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_770043295;
            // ---------- Original Method ----------
            //return SelectionKey.OP_READ;
        }

        
    }


    
}

