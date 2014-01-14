package android.text.method;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class SingleLineTransformationMethod extends ReplacementTransformationMethod {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.567 -0500", hash_original_method = "4853BBC3FBC3CF589EEA47536237EC37", hash_generated_method = "B201543D46DD84421BE8C9D74F2BA21C")
    
public static SingleLineTransformationMethod getInstance() {
        if (sInstance != null)
            return sInstance;

        sInstance = new SingleLineTransformationMethod();
        return sInstance;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.556 -0500", hash_original_field = "DADBBF5D30AABE7047FE203379B00ADB", hash_generated_field = "98B422AB3100EE03E170C8673A5F0723")

    private static char[] ORIGINAL = new char[] { '\n', '\r' };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.559 -0500", hash_original_field = "1A27EA87B7F781EEA7745D1D42459150", hash_generated_field = "4BECEA87476210D9FCD61E1027EFAAFB")

    private static char[] REPLACEMENT = new char[] { ' ', '\uFEFF' };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.570 -0500", hash_original_field = "B505C6A37A8E927FABE37FB2E6BE5E2B", hash_generated_field = "6480497BDC465266B7D9E18C73F9BE9F")

    private static SingleLineTransformationMethod sInstance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.728 -0400", hash_original_method = "D4568A7EAB6F00728EAF3C3E423FA0FE", hash_generated_method = "D4568A7EAB6F00728EAF3C3E423FA0FE")
    public SingleLineTransformationMethod ()
    {
        //Synthesized constructor
    }

    /**
     * The characters to be replaced are \n and \r.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.562 -0500", hash_original_method = "64C6D73F3773427C2A2F245DBEBF22E0", hash_generated_method = "B0A9DD46339001C9C3C056197B112335")
    
protected char[] getOriginal() {
        return ORIGINAL;
    }

    /**
     * The character \n is replaced with is space;
     * the character \r is replaced with is FEFF (zero width space).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:00.565 -0500", hash_original_method = "44611EB51BD7B665366AA2036C731932", hash_generated_method = "431C9324C173CE74F01EB19676A0E5B5")
    
protected char[] getReplacement() {
        return REPLACEMENT;
    }
}

