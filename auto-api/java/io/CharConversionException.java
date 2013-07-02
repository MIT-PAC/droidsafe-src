package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class CharConversionException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.576 -0400", hash_original_method = "DC569460E6B613C2EB5E9DBFD397A52F", hash_generated_method = "9D02A3AF17326460C375C01A7E899BB2")
    public  CharConversionException() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.576 -0400", hash_original_method = "FDBB99B99B9CAB30BA127F908E7A50CF", hash_generated_method = "754392A6268252EBA331B5B982ECEF8A")
    public  CharConversionException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.576 -0400", hash_original_field = "8426614A2AF0B4D3FD282DF8C353B803", hash_generated_field = "65B2BE3C51DC9ACB0D9DEF0D743B85D6")

    private static final long serialVersionUID = -8680016352018427031L;
}

