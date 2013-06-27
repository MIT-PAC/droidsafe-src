package javax.security.auth.callback;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class UnsupportedCallbackException extends Exception {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.418 -0400", hash_original_field = "924A8CEEAC17F54D3BE3F8CDF1C04EB2", hash_generated_field = "1B1600DBF2D274518D5E0379C95B483E")

    private Callback callback;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.418 -0400", hash_original_method = "6F64A91CCA6DECE8990E118F6F2706F6", hash_generated_method = "D0D2AF18505AA576BB4AA2E2936C7D6B")
    public  UnsupportedCallbackException(Callback callback) {
        this.callback = callback;
        // ---------- Original Method ----------
        //this.callback = callback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.427 -0400", hash_original_method = "E54A6FA33A5BFCD773DCE92A09F71FE9", hash_generated_method = "5FCD1F7CCAD84C9DACAD33A9C7D63603")
    public  UnsupportedCallbackException(Callback callback, String message) {
        super(message);
        this.callback = callback;
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //this.callback = callback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.427 -0400", hash_original_method = "C52CB6D8F1111BAF8BAA5D6F66319767", hash_generated_method = "AACA75C522107129302411F7AC51C59C")
    public Callback getCallback() {
        Callback varB4EAC82CA7396A68D541C85D26508E83_1352891318 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1352891318 = callback;
        varB4EAC82CA7396A68D541C85D26508E83_1352891318.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1352891318;
        // ---------- Original Method ----------
        //return callback;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.427 -0400", hash_original_field = "8EAB790C17550FAD68CD57E527710DAC", hash_generated_field = "62B72A48BD4D378E0EC990C764C01B39")

    private static long serialVersionUID = -6873556327655666839L;
}

