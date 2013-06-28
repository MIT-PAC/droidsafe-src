package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class IllegalStateException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.099 -0400", hash_original_method = "A3FE636ADA4040CA4955BB4251C76DAB", hash_generated_method = "4CD9063F55FB314B76AC101B41C0985A")
    public  IllegalStateException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.099 -0400", hash_original_method = "F14466412D9BB118D44B7BD1FD4B4021", hash_generated_method = "A5F36BE7CB5D7DAB70401E4669633775")
    public  IllegalStateException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.100 -0400", hash_original_method = "6F3B5205BA771B0DF92BD44831C586ED", hash_generated_method = "A4CA28C8C551D740ED10A1C367FA8627")
    public  IllegalStateException(String message, Throwable cause) {
        super(message, cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.100 -0400", hash_original_method = "6DC0580FE34F314D6F80EBAA4A416AA3", hash_generated_method = "208877ADA52089296AE9E95BA684BC40")
    public  IllegalStateException(Throwable cause) {
        super((cause == null ? null : cause.toString()), cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:50.100 -0400", hash_original_field = "7E64C51578B30AF46D784D38966F29AA", hash_generated_field = "DCC0988018DD2FB77D529B43591FE9E8")

    private static final long serialVersionUID = -1848914673093119416L;
}

