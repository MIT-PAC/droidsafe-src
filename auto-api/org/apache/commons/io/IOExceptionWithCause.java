package org.apache.commons.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class IOExceptionWithCause extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.366 -0400", hash_original_method = "D35AEE75131A73F58A55104946C95348", hash_generated_method = "CFC74D70549FE1521C5A3223C12F4C5A")
    public  IOExceptionWithCause(String message, Throwable cause) {
        super(message);
        this.initCause(cause);
        addTaint(message.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
        //this.initCause(cause);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.366 -0400", hash_original_method = "A43E17313B2999FA9C6013736C0761D0", hash_generated_method = "4FE3D2ADF61730ED0B52D5378958074F")
    public  IOExceptionWithCause(Throwable cause) {
        super(cause == null ? null : cause.toString());
        this.initCause(cause);
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
        //this.initCause(cause);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.366 -0400", hash_original_field = "0B32F171B7F0DF451D414BE461B5698C", hash_generated_field = "712212474A80BD328114C4C1DC66CBA3")

    private static final long serialVersionUID = 1L;
}

