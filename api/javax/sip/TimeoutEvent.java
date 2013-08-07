package javax.sip;

// Droidsafe Imports
import droidsafe.annotations.*;





public class TimeoutEvent extends TransactionTerminatedEvent {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.348 -0400", hash_original_field = "A6EFB54FFD2811DD57158A62FDEF145A", hash_generated_field = "FE277A87B690B80ED89C5FD5CAD03096")

    private Timeout mTimeout;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.349 -0400", hash_original_method = "B54F2DD7A2EA500C648BF1D67EA727CB", hash_generated_method = "9201C5CBD9D816D4A5BFCF53B1912A3B")
    public  TimeoutEvent(Object source, ServerTransaction serverTransaction,
            Timeout timeout) {
        super(source, serverTransaction);
        addTaint(serverTransaction.getTaint());
        addTaint(source.getTaint());
        mTimeout = timeout;
        // ---------- Original Method ----------
        //mTimeout = timeout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.350 -0400", hash_original_method = "E3A1CE6AED4C8EB398A7A856D4DC19D6", hash_generated_method = "D2C2BDC001CAB1565EE9CA0A62B15457")
    public  TimeoutEvent(Object source, ClientTransaction clientTransaction,
            Timeout timeout) {
        super(source, clientTransaction);
        addTaint(clientTransaction.getTaint());
        addTaint(source.getTaint());
        mTimeout = timeout;
        // ---------- Original Method ----------
        //mTimeout = timeout;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.350 -0400", hash_original_method = "83172AE614FED36EC49043A629BB9E54", hash_generated_method = "81A06CB5C49BFC73DCEAD677E1B0A16C")
    public Timeout getTimeout() {
Timeout var8318AEC113BDBBB67AC369DA259B4BA7_2059670843 =         mTimeout;
        var8318AEC113BDBBB67AC369DA259B4BA7_2059670843.addTaint(taint);
        return var8318AEC113BDBBB67AC369DA259B4BA7_2059670843;
        // ---------- Original Method ----------
        //return mTimeout;
    }

    
}

