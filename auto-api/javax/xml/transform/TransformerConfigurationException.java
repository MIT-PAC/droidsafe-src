package javax.xml.transform;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class TransformerConfigurationException extends TransformerException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.936 -0400", hash_original_method = "BD9B4D3E21457DCFC8705065705F7747", hash_generated_method = "A2C224685083B7346EB781B715051790")
    public  TransformerConfigurationException() {
        super("Configuration Error");
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.936 -0400", hash_original_method = "69DD6C44C48D0F6E1DFC35936EC71C54", hash_generated_method = "2C587EB6794FA44A96176FA58F93735B")
    public  TransformerConfigurationException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.936 -0400", hash_original_method = "E488733BAF7BF3463DC8581AFFE97D88", hash_generated_method = "35315BAF79F925897FB1279B6C9C75EC")
    public  TransformerConfigurationException(Throwable e) {
        super(e);
        addTaint(e.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.936 -0400", hash_original_method = "BD51DDC4165DA92B6AA2ED19748DFB52", hash_generated_method = "D8ED1AFF2BC107880372D0CF311D249C")
    public  TransformerConfigurationException(String msg, Throwable e) {
        super(msg, e);
        addTaint(msg.getTaint());
        addTaint(e.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.937 -0400", hash_original_method = "81D0C9E7195DBF524596695CB4BBF5D5", hash_generated_method = "E3CD85CAFC29E3F37BF8701BFCAD5705")
    public  TransformerConfigurationException(String message,
                                             SourceLocator locator) {
        super(message, locator);
        addTaint(message.getTaint());
        addTaint(locator.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.937 -0400", hash_original_method = "C1BB4F182A4DB12C2F5D6DBB3B298E48", hash_generated_method = "9F67301AD0E7494BDB75F37AD8A94FA5")
    public  TransformerConfigurationException(String message,
                                             SourceLocator locator,
                                             Throwable e) {
        super(message, locator, e);
        addTaint(message.getTaint());
        addTaint(locator.getTaint());
        addTaint(e.getTaint());
        // ---------- Original Method ----------
    }

    
}

