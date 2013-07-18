package java.net;

// Droidsafe Imports
import java.io.IOException;

import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class MalformedURLException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.759 -0400", hash_original_method = "6F3415F478603350217F65D672585814", hash_generated_method = "AD568FEDA3A16AFE9C14138F3CCC4B4D")
    public  MalformedURLException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.759 -0400", hash_original_method = "1BAAD892782075B201BE55BD9DAC535A", hash_generated_method = "2B443BF0D497DC20D8C94025C945071B")
    public  MalformedURLException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.760 -0400", hash_original_method = "ACF50FF54717652ACCF5120218FC2A60", hash_generated_method = "8387E598B6C25BB03E3569D4E90956E0")
    public  MalformedURLException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        addTaint(cause.getTaint());
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.760 -0400", hash_original_field = "461BDBAF1E8B8B185701E277A76730F6", hash_generated_field = "B44A4BD557582E4A416B968EA462C43E")

    private static final long serialVersionUID = -182787522200415866L;
}

