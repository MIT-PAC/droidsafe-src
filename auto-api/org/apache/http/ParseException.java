package org.apache.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ParseException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.577 -0400", hash_original_method = "43A50A2814EFBF0D7758AAE9FD7C9320", hash_generated_method = "9A467B6CDF547A2C71AA208E65181C5B")
    public  ParseException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.578 -0400", hash_original_method = "AA2D3B43514461050036AD8670526A69", hash_generated_method = "5E059B7A27B3133D67D677E5E1E7ADA4")
    public  ParseException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:14.578 -0400", hash_original_field = "BCD1CEA4A43E96CEC6F1DD6D103C2931", hash_generated_field = "727E1929800005458D5D0A177F3B1103")

    private static long serialVersionUID = -7288819855864183578L;
}

