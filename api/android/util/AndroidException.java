package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;




public class AndroidException extends Exception {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.274 -0500", hash_original_method = "B114E564F5DD3A8162C6B705516D48E4", hash_generated_method = "2F56F4C683EAA0F88385B28E913DE98B")
    public AndroidException() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.276 -0500", hash_original_method = "891590FF533F04EE265F2E23F15D3AEC", hash_generated_method = "26BFED3394D7D87E6F8342B2930FD0CE")
    public AndroidException(String name) {
        super(name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.277 -0500", hash_original_method = "B244007C3BAFD44F95BE0B614ABC1B32", hash_generated_method = "0C9FD68964CA7287C46A5D85CE1C03B7")
    public AndroidException(String name, Throwable cause) {
        super(name, cause);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:35.277 -0500", hash_original_method = "C5375F3D80EA6460B68F9344F734F18D", hash_generated_method = "C9A0F0DF4F7C2C984BB141F0FBEAAF04")
    public AndroidException(Exception cause) {
        super(cause);
    }

    
}

