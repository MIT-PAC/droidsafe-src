package javax.sip;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class TransactionDoesNotExistException extends SipException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.120 -0400", hash_original_method = "750F8F9B78D69ABAD487E00FF1714036", hash_generated_method = "B97A8DA2301BB8BC36CF55AD5F049642")
    public  TransactionDoesNotExistException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.122 -0400", hash_original_method = "FEB1A81DE901FC743AFE681804A1F11C", hash_generated_method = "8DA048A2C5245050F2F850498F31FD30")
    public  TransactionDoesNotExistException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.122 -0400", hash_original_method = "B970C645A776B4A2B1D89F6D22EB1C05", hash_generated_method = "A6FDFD5A7F28F030C365FAF23B69609F")
    public  TransactionDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
}

