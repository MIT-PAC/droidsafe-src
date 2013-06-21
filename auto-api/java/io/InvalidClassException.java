package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class InvalidClassException extends ObjectStreamException {
    public String classname;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.834 -0400", hash_original_method = "EFF9B20162E74D1DBB80ACE44E70A573", hash_generated_method = "7B85A006B4FA9B952267DF0E1FAAD691")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InvalidClassException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.834 -0400", hash_original_method = "A0014C5B63B7954D0D217FAB7EAA1F21", hash_generated_method = "A2281EC849D5FBF5FE4039815D0023A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InvalidClassException(String className, String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        dsTaint.addTaint(className);
        // ---------- Original Method ----------
        //this.classname = className;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.834 -0400", hash_original_method = "F4D165DC6F6D9B89EF49B0E2E4445877", hash_generated_method = "83174D867E36AF42CD095FE33C95E9ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getMessage() {
        String msg;
        msg = super.getMessage();
        {
            msg = classname + "; " + msg;
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String msg = super.getMessage();
        //if (classname != null) {
            //msg = classname + "; " + msg;
        //}
        //return msg;
    }

    
    private static final long serialVersionUID = -4333316296251054416L;
}

