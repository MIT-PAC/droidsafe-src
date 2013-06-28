package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ExceptionInInitializerError extends LinkageError {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.991 -0400", hash_original_field = "42552B1F133F9F8EB406D4F306EA9FD1", hash_generated_field = "3848780C3E4557B7B025FBB998A1DBF6")

    private Throwable exception;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.991 -0400", hash_original_method = "6D1A3A1944D703E56CAA922913525A43", hash_generated_method = "FD2365B6B4CCF743258ED4506CBE1824")
    public  ExceptionInInitializerError() {
        initCause(null);
        // ---------- Original Method ----------
        //initCause(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.991 -0400", hash_original_method = "CDE8F850C70A27B83A36A148C961A5A1", hash_generated_method = "7E15430257ABFC244484A3B0E492A56B")
    public  ExceptionInInitializerError(String detailMessage) {
        super(detailMessage);
        initCause(null);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
        //initCause(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.992 -0400", hash_original_method = "C6EE88DB95324F4EE61EE6CA197E1367", hash_generated_method = "90578C0383D83BA5A895D7BA4F8F9AD9")
    public  ExceptionInInitializerError(Throwable exception) {
        this.exception = exception;
        initCause(exception);
        // ---------- Original Method ----------
        //this.exception = exception;
        //initCause(exception);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.992 -0400", hash_original_method = "7090E247F85246652792FDABBC14B51F", hash_generated_method = "9A93BB91ABDD6319B2E23E9B6EEDDB5F")
    public Throwable getException() {
        Throwable varB4EAC82CA7396A68D541C85D26508E83_1259889270 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1259889270 = exception;
        varB4EAC82CA7396A68D541C85D26508E83_1259889270.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1259889270;
        // ---------- Original Method ----------
        //return exception;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.992 -0400", hash_original_method = "28A8EFFB85C5CFA84BB4445EFA004CE6", hash_generated_method = "F02E1D49DA9BB12679954F5A979C78F6")
    @Override
    public Throwable getCause() {
        Throwable varB4EAC82CA7396A68D541C85D26508E83_657270800 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_657270800 = exception;
        varB4EAC82CA7396A68D541C85D26508E83_657270800.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_657270800;
        // ---------- Original Method ----------
        //return exception;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.992 -0400", hash_original_field = "4B8E39DAC3C5732C9EB5AB8EA55581C9", hash_generated_field = "7192C69596784210497884AC1F9F31E5")

    private static final long serialVersionUID = 1521711792217232256L;
}

