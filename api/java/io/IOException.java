package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class IOException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.768 -0400", hash_original_method = "4DDFF90B7CF8CD74272BB60235E66E65", hash_generated_method = "F4838CE634BCA6B1BFF2D1925B3382CA")
    public  IOException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.769 -0400", hash_original_method = "240D0BB3974E5D097E21F85B24F6FB44", hash_generated_method = "49172DF117E5E7E39EDC3EB9389CE8AC")
    public  IOException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.770 -0400", hash_original_method = "D16D4F9A4DF133858001870C6413D65C", hash_generated_method = "504A579E4909012C787FB734C5F2C1F6")
    public  IOException(String message, Throwable cause) {
        super(message, cause);
        addTaint(cause.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.771 -0400", hash_original_method = "653E955146B329965A610B3602D07E3E", hash_generated_method = "43135D4BCF30C3D2878DAD39CF7DA4C7")
    public  IOException(Throwable cause) {
        super(cause == null ? null : cause.toString(), cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:40.771 -0400", hash_original_field = "78FEAC4AE1D139E9190DA8D44440AFFE", hash_generated_field = "E1BB06D1BDEDB21E301ADD66B95C6A57")

    private static final long serialVersionUID = 7818375828146090155L;
}

