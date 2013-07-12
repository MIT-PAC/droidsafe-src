package java.nio.channels;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.SelectorProvider;

public abstract class Pipe {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.647 -0400", hash_original_method = "AB1C252ACF4CEE3E1F01631225D9EB55", hash_generated_method = "FDC0FEC870B63611D7A177DD42514223")
    protected  Pipe() {
        
    }

    
        public static Pipe open() throws IOException {
        return SelectorProvider.provider().openPipe();
    }

    
    public abstract SinkChannel sink();

    
    public abstract SourceChannel source();

    
    public static abstract class SinkChannel extends AbstractSelectableChannel implements WritableByteChannel, GatheringByteChannel {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.647 -0400", hash_original_method = "6199DECCB48C88702EC19067764991B0", hash_generated_method = "C72698FDAA0C247A4C9BAA911A820984")
        protected  SinkChannel(SelectorProvider provider) {
            super(provider);
            addTaint(provider.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.647 -0400", hash_original_method = "C028D25CCC7628B8923253B7D8B4C45A", hash_generated_method = "1CAAE29B290218B105591B343C027639")
        @Override
        public final int validOps() {
            int var53A444133ECFA2A63AB8406200B028D1_1590976626 = (SelectionKey.OP_WRITE);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1267108520 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1267108520;
            
            
        }

        
    }


    
    public static abstract class SourceChannel extends AbstractSelectableChannel implements ReadableByteChannel, ScatteringByteChannel {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.648 -0400", hash_original_method = "9817FE62735CF1F1F50A3C676A019302", hash_generated_method = "F17F93443685466D9F960296B170ECA4")
        protected  SourceChannel(SelectorProvider provider) {
            super(provider);
            addTaint(provider.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.648 -0400", hash_original_method = "D2EA48B97033CCCA8D2B0ECC7F0D7822", hash_generated_method = "99828B99DCF9717EC715257387ADFB90")
        @Override
        public final int validOps() {
            int varA020689BBAF72FA5CC26EDDF439F5FFD_847478766 = (SelectionKey.OP_READ);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_583562569 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_583562569;
            
            
        }

        
    }


    
}

