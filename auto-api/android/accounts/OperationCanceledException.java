package android.accounts;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class OperationCanceledException extends AccountsException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.805 -0400", hash_original_method = "6A2CA580ECAC1CA80E08E40CC1DE7A0D", hash_generated_method = "5FBC7ED054974008E3508D207C4F8A0E")
    public  OperationCanceledException() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.806 -0400", hash_original_method = "30D3CCD84D44CE1156B1C66BFE82B5A0", hash_generated_method = "AF2693A0BA0D7DEB3AF3A535CE7B4CE9")
    public  OperationCanceledException(String message) {
        super(message);
        addTaint(message.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.806 -0400", hash_original_method = "35A2345D71CE64B12E61247F60F6496F", hash_generated_method = "196DF6E0A1A48AC6E918AF0A3319BD91")
    public  OperationCanceledException(String message, Throwable cause) {
        super(message, cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:10.807 -0400", hash_original_method = "3CAB85560A3DC981F8F8AE7B1C1F36EB", hash_generated_method = "F64FE4481C6EA21CDC10EEF9DD8B23F6")
    public  OperationCanceledException(Throwable cause) {
        super(cause);
        addTaint(cause.getTaint());
        
    }

    
}

