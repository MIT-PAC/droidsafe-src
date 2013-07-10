package java.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class BindException extends SocketException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.023 -0400", hash_original_method = "D66D1C4C5928E000A465F2B26896B637", hash_generated_method = "C638B86E6197A90D0C5D3DF2A4972BCE")
    public  BindException() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.023 -0400", hash_original_method = "6FF32DF773E2792C41FA7AD13FDCFDDC", hash_generated_method = "BE7E73FDC246F21A9CA5B2C1286D2489")
    public  BindException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.023 -0400", hash_original_method = "C8F93BE3A806C12732DAADB48D8791E4", hash_generated_method = "F6011D23A4A8939CE90F51AA0B55846B")
    public  BindException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        addTaint(detailMessage.getTaint());
        addTaint(cause.getTaint());
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.023 -0400", hash_original_field = "7A61C5E0953A7786CF3BC27BE1A3D948", hash_generated_field = "EA3137D160EDA862C3C64F1345348850")

    private static final long serialVersionUID = -5945005768251722951L;
}

