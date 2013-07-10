package java.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;

public class MalformedURLException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.433 -0400", hash_original_method = "6F3415F478603350217F65D672585814", hash_generated_method = "AD568FEDA3A16AFE9C14138F3CCC4B4D")
    public  MalformedURLException() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.434 -0400", hash_original_method = "1BAAD892782075B201BE55BD9DAC535A", hash_generated_method = "2B443BF0D497DC20D8C94025C945071B")
    public  MalformedURLException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.434 -0400", hash_original_method = "ACF50FF54717652ACCF5120218FC2A60", hash_generated_method = "5A138E743CF20FE2AED5A274FD7A02A7")
    public  MalformedURLException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        addTaint(detailMessage.getTaint());
        addTaint(cause.getTaint());
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.434 -0400", hash_original_field = "461BDBAF1E8B8B185701E277A76730F6", hash_generated_field = "B44A4BD557582E4A416B968EA462C43E")

    private static final long serialVersionUID = -182787522200415866L;
}

