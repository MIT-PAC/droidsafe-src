package org.apache.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class ParseException extends RuntimeException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:27.423 -0500", hash_original_field = "E19C8717934231C920AD6F30E71BC83A", hash_generated_field = "D9C114BB8386200D98E8040578E8C75C")

    private static final long serialVersionUID = -7288819855864183578L;

    /**
     * Creates a {@link ParseException} without details.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:27.426 -0500", hash_original_method = "43A50A2814EFBF0D7758AAE9FD7C9320", hash_generated_method = "00404CCAB93CD9FB4A71881A3ACD10B5")
    
public ParseException() {
        super();
    }

    /**
     * Creates a {@link ParseException} with a detail message.
     * 
     * @param message the exception detail message, or <code>null</code>
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:27.428 -0500", hash_original_method = "AA2D3B43514461050036AD8670526A69", hash_generated_method = "B7F8F15591BDA2D742576262916B6A93")
    
public ParseException(String message) {
        super(message);
    }
}

