package java.security;

// Droidsafe Imports
import droidsafe.annotations.*;





public class UnrecoverableKeyException extends UnrecoverableEntryException {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.584 -0400", hash_original_method = "E20357D553B788F278F646C0E3221E57", hash_generated_method = "39C1C493987B5B97D605567FC88B9169")
    public  UnrecoverableKeyException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.584 -0400", hash_original_method = "03224602BAA5F9956174116E90B167DC", hash_generated_method = "457CE1EC41599347D74B5CD5A4C0D88F")
    public  UnrecoverableKeyException() {
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.585 -0400", hash_original_field = "11328B0FEED491A9602A36ADED762421", hash_generated_field = "3ACA87301D5DF7DF8197CF313220208D")

    private static final long serialVersionUID = 7275063078190151277L;
}

