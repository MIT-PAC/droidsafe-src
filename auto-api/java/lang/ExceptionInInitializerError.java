package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ExceptionInInitializerError extends LinkageError {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.660 -0400", hash_original_field = "42552B1F133F9F8EB406D4F306EA9FD1", hash_generated_field = "3848780C3E4557B7B025FBB998A1DBF6")

    private Throwable exception;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.662 -0400", hash_original_method = "6D1A3A1944D703E56CAA922913525A43", hash_generated_method = "FD2365B6B4CCF743258ED4506CBE1824")
    public  ExceptionInInitializerError() {
        initCause(null);
        // ---------- Original Method ----------
        //initCause(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.662 -0400", hash_original_method = "CDE8F850C70A27B83A36A148C961A5A1", hash_generated_method = "7E15430257ABFC244484A3B0E492A56B")
    public  ExceptionInInitializerError(String detailMessage) {
        super(detailMessage);
        initCause(null);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
        //initCause(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.662 -0400", hash_original_method = "C6EE88DB95324F4EE61EE6CA197E1367", hash_generated_method = "90578C0383D83BA5A895D7BA4F8F9AD9")
    public  ExceptionInInitializerError(Throwable exception) {
        this.exception = exception;
        initCause(exception);
        // ---------- Original Method ----------
        //this.exception = exception;
        //initCause(exception);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.663 -0400", hash_original_method = "7090E247F85246652792FDABBC14B51F", hash_generated_method = "37C4592F0358A82B240CED6CA6F68EB3")
    public Throwable getException() {
        Throwable varB4EAC82CA7396A68D541C85D26508E83_1386897197 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1386897197 = exception;
        varB4EAC82CA7396A68D541C85D26508E83_1386897197.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1386897197;
        // ---------- Original Method ----------
        //return exception;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.664 -0400", hash_original_method = "28A8EFFB85C5CFA84BB4445EFA004CE6", hash_generated_method = "6B9A5FFE7D54396499B834CA97AE8849")
    @Override
    public Throwable getCause() {
        Throwable varB4EAC82CA7396A68D541C85D26508E83_1667704682 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1667704682 = exception;
        varB4EAC82CA7396A68D541C85D26508E83_1667704682.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1667704682;
        // ---------- Original Method ----------
        //return exception;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.664 -0400", hash_original_field = "4B8E39DAC3C5732C9EB5AB8EA55581C9", hash_generated_field = "D0793C7FA7A70983779D0126FE0B4E16")

    private static long serialVersionUID = 1521711792217232256L;
}

