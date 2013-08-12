package java.security;

// Droidsafe Imports
import droidsafe.annotations.*;





public class InvalidKeyException extends KeyException {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.859 -0400", hash_original_method = "BC12CDCCA39AEA87BF36441977671D95", hash_generated_method = "19AF4627832A22455F8CDE4EC0A5F487")
    public  InvalidKeyException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.860 -0400", hash_original_method = "4C9DBAC0C74B6F235E7CED5E494EF3EA", hash_generated_method = "92C65BC824CFB76E11B7AB2CF746507A")
    public  InvalidKeyException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.860 -0400", hash_original_method = "F48B209D0258F085C8D5998E4F2F8DB1", hash_generated_method = "44EFBE25DC61D34BFA174CEA89B2FC1B")
    public  InvalidKeyException(String message, Throwable cause) {
        super(message, cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.861 -0400", hash_original_method = "F8B65E52926150DDFBD4B64691704A27", hash_generated_method = "86A90968DBBF5A24975C4DF9C1F74931")
    public  InvalidKeyException(Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.861 -0400", hash_original_field = "11F5C7EB8196B9D76D79C7D0467CBCA6", hash_generated_field = "AE7F6B4A6D2DED1A2EC0CFA8D091C8F7")

    private static final long serialVersionUID = 5698479920593359816L;
}

