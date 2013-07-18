package java.net;

// Droidsafe Imports
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class BindException extends SocketException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.289 -0400", hash_original_method = "D66D1C4C5928E000A465F2B26896B637", hash_generated_method = "C638B86E6197A90D0C5D3DF2A4972BCE")
    public  BindException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.289 -0400", hash_original_method = "6FF32DF773E2792C41FA7AD13FDCFDDC", hash_generated_method = "BE7E73FDC246F21A9CA5B2C1286D2489")
    public  BindException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.290 -0400", hash_original_method = "C8F93BE3A806C12732DAADB48D8791E4", hash_generated_method = "7529504FC975453FD409C06506129ECE")
    public  BindException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        addTaint(cause.getTaint());
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.290 -0400", hash_original_field = "7A61C5E0953A7786CF3BC27BE1A3D948", hash_generated_field = "EA3137D160EDA862C3C64F1345348850")

    private static final long serialVersionUID = -5945005768251722951L;
}

