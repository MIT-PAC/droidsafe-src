package android.database;

// Droidsafe Imports
import droidsafe.annotations.*;




public class CursorIndexOutOfBoundsException extends IndexOutOfBoundsException {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.618 -0400", hash_original_method = "7D18BDB25CF5B28922C44487D666A0F3", hash_generated_method = "FB61BDBC65B82502B57056CDC6A52687")
    public  CursorIndexOutOfBoundsException(int index, int size) {
        super("Index " + index + " requested, with a size of " + size);
        addTaint(size);
        addTaint(index);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.619 -0400", hash_original_method = "7E52A2C3F9CDD649181FC5C4A8E3976F", hash_generated_method = "42AC2ADC42E8EC7640C60F95D25F4414")
    public  CursorIndexOutOfBoundsException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
}

