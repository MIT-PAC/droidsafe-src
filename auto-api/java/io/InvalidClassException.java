package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class InvalidClassException extends ObjectStreamException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.113 -0400", hash_original_field = "26B2A720F7B8C9BD8D3999C52DA409D0", hash_generated_field = "B0C75E444ABFD30811DA4022885A4FE7")

    public String classname;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.113 -0400", hash_original_method = "EFF9B20162E74D1DBB80ACE44E70A573", hash_generated_method = "F8B3DAD56180F56E19D0C8EF9347D6B4")
    public  InvalidClassException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.114 -0400", hash_original_method = "A0014C5B63B7954D0D217FAB7EAA1F21", hash_generated_method = "6B923E52137D83FF72C508399EA0D22E")
    public  InvalidClassException(String className, String detailMessage) {
        super(detailMessage);
        this.classname = className;
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
        //this.classname = className;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.114 -0400", hash_original_method = "F4D165DC6F6D9B89EF49B0E2E4445877", hash_generated_method = "ECAF31FD9F147E232636807BA6B073B2")
    @Override
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_914234018 = null; //Variable for return #1
        String msg = super.getMessage();
        {
            msg = classname + "; " + msg;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_914234018 = msg;
        varB4EAC82CA7396A68D541C85D26508E83_914234018.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_914234018;
        // ---------- Original Method ----------
        //String msg = super.getMessage();
        //if (classname != null) {
            //msg = classname + "; " + msg;
        //}
        //return msg;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.114 -0400", hash_original_field = "72D7A703CD0FB4057452DEA0641D5BCD", hash_generated_field = "D4E2FCFAAD906D95CB6BCEB015D3083F")

    private static final long serialVersionUID = -4333316296251054416L;
}

