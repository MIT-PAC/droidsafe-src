package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class BindException extends SocketException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.048 -0400", hash_original_method = "D66D1C4C5928E000A465F2B26896B637", hash_generated_method = "C638B86E6197A90D0C5D3DF2A4972BCE")
    public  BindException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.048 -0400", hash_original_method = "6FF32DF773E2792C41FA7AD13FDCFDDC", hash_generated_method = "BE7E73FDC246F21A9CA5B2C1286D2489")
    public  BindException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.048 -0400", hash_original_method = "C8F93BE3A806C12732DAADB48D8791E4", hash_generated_method = "F6011D23A4A8939CE90F51AA0B55846B")
    public  BindException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        addTaint(detailMessage.getTaint());
        addTaint(cause.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.049 -0400", hash_original_field = "7A61C5E0953A7786CF3BC27BE1A3D948", hash_generated_field = "AF4D113B316387C2A59C217CBC993996")

    private static long serialVersionUID = -5945005768251722951L;
}

