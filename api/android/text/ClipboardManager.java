package android.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public abstract class ClipboardManager {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.480 -0400", hash_original_method = "47A2DF210DD8BA7527F7EBA65DD74954", hash_generated_method = "47A2DF210DD8BA7527F7EBA65DD74954")
    public ClipboardManager ()
    {
        //Synthesized constructor
    }
    /**
     * Returns the text on the clipboard.  It will eventually be possible
     * to store types other than text too, in which case this will return
     * null if the type cannot be coerced to text.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.647 -0500", hash_original_method = "F253B5A800FFE39B36B9B816BB348763", hash_generated_method = "748527C2FC98E6C1FD97D7948B23BF56")
    
public abstract CharSequence getText();

    /**
     * Sets the contents of the clipboard to the specified text.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.649 -0500", hash_original_method = "7694500E873F3B5A010FB45AB92E588E", hash_generated_method = "1B0356A0E99BE3853E335A9D1544F6DC")
    
public abstract void setText(CharSequence text);

    /**
     * Returns true if the clipboard contains text; false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:04.652 -0500", hash_original_method = "FEE95F46D40A81ECD11480FFA4D48D25", hash_generated_method = "62298B6995888C651FA05A1C1F62E311")
    
public abstract boolean hasText();
    
}

