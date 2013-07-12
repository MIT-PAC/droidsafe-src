package javax.xml.transform;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class TransformerConfigurationException extends TransformerException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.009 -0400", hash_original_method = "BD9B4D3E21457DCFC8705065705F7747", hash_generated_method = "A2C224685083B7346EB781B715051790")
    public  TransformerConfigurationException() {
        super("Configuration Error");
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.010 -0400", hash_original_method = "69DD6C44C48D0F6E1DFC35936EC71C54", hash_generated_method = "2C587EB6794FA44A96176FA58F93735B")
    public  TransformerConfigurationException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.010 -0400", hash_original_method = "E488733BAF7BF3463DC8581AFFE97D88", hash_generated_method = "35315BAF79F925897FB1279B6C9C75EC")
    public  TransformerConfigurationException(Throwable e) {
        super(e);
        addTaint(e.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.010 -0400", hash_original_method = "BD51DDC4165DA92B6AA2ED19748DFB52", hash_generated_method = "A27AAEC34B1FD03AE1D73009425312DA")
    public  TransformerConfigurationException(String msg, Throwable e) {
        super(msg, e);
        addTaint(e.getTaint());
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.011 -0400", hash_original_method = "81D0C9E7195DBF524596695CB4BBF5D5", hash_generated_method = "3F558539687DDB6672E5D2F87DE8AC3C")
    public  TransformerConfigurationException(String message,
                                             SourceLocator locator) {
        super(message, locator);
        addTaint(locator.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.011 -0400", hash_original_method = "C1BB4F182A4DB12C2F5D6DBB3B298E48", hash_generated_method = "1E6895881AD831C0C703BB020DD55F0D")
    public  TransformerConfigurationException(String message,
                                             SourceLocator locator,
                                             Throwable e) {
        super(message, locator, e);
        addTaint(e.getTaint());
        addTaint(locator.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
}

