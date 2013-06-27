package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class InvalidClassException extends ObjectStreamException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.034 -0400", hash_original_field = "26B2A720F7B8C9BD8D3999C52DA409D0", hash_generated_field = "B0C75E444ABFD30811DA4022885A4FE7")

    public String classname;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.035 -0400", hash_original_method = "EFF9B20162E74D1DBB80ACE44E70A573", hash_generated_method = "F8B3DAD56180F56E19D0C8EF9347D6B4")
    public  InvalidClassException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.035 -0400", hash_original_method = "A0014C5B63B7954D0D217FAB7EAA1F21", hash_generated_method = "6B923E52137D83FF72C508399EA0D22E")
    public  InvalidClassException(String className, String detailMessage) {
        super(detailMessage);
        this.classname = className;
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
        //this.classname = className;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.044 -0400", hash_original_method = "F4D165DC6F6D9B89EF49B0E2E4445877", hash_generated_method = "7ADC2B0CDA60C4D952F5DA58B71023DE")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_579504834 = null; //Variable for return #1
        String msg;
        msg = super.getMessage();
        {
            msg = classname + "; " + msg;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_579504834 = msg;
        varB4EAC82CA7396A68D541C85D26508E83_579504834.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_579504834;
        // ---------- Original Method ----------
        //String msg = super.getMessage();
        //if (classname != null) {
            //msg = classname + "; " + msg;
        //}
        //return msg;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.044 -0400", hash_original_field = "72D7A703CD0FB4057452DEA0641D5BCD", hash_generated_field = "673322D552595B264E76F3F9CDBEC537")

    private static long serialVersionUID = -4333316296251054416L;
}

