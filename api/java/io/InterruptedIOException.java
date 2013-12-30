package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class InterruptedIOException extends IOException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.620 -0500", hash_original_field = "D1BB675B1635CBE9F0E1026ABD5ABCD7", hash_generated_field = "00B7350ACE79265F1BE5866C28B5A783")


    private static final long serialVersionUID = 4020568460727500567L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.622 -0500", hash_original_field = "BD85AB55237C037827FEDC1A9DD400CE", hash_generated_field = "ADADEC4FF5BBED2ACE9FA0E36B78EE7E")

    public int bytesTransferred;

    /**
     * Constructs a new instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.625 -0500", hash_original_method = "BB9DACD07ED93D41347C3772C10021CB", hash_generated_method = "DA2DCBE5F00DBE7618C1F279A9CD37FF")
    
public InterruptedIOException() {
    }

    /**
     * Constructs a new instance with the given detail message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.628 -0500", hash_original_method = "9DCF8CB18681541ED5194D8FB0295B7F", hash_generated_method = "837332240A809019E15EECCF3637FEBC")
    
public InterruptedIOException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs a new instance with given detail message and cause.
     * @hide internal use only
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.630 -0500", hash_original_method = "4976F1F97DF8BBE1F3AC7D56299FEDE9", hash_generated_method = "B7BD75FFB7A63D382828D0D142B70454")
    
public InterruptedIOException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
    }
}

