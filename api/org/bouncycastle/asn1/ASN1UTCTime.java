package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Date;

public class ASN1UTCTime extends DERUTCTime {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.775 -0400", hash_original_method = "9FB0B414332B377CAC617115546A77CB", hash_generated_method = "A013CAF4244210C95264F70A7425C3F5")
      ASN1UTCTime(byte[] bytes) {
        super(bytes);
        addTaint(bytes[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.776 -0400", hash_original_method = "51D45B3CCAB2D6EB6F627DE79DEFE5C9", hash_generated_method = "394B480DAE947C7B9D26A3B85BC2269E")
    public  ASN1UTCTime(Date time) {
        super(time);
        addTaint(time.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.776 -0400", hash_original_method = "56D06078D341C61AAEA2DCB1CFA1CC92", hash_generated_method = "1E5F83B2C9AE131E52F62B2B492A5714")
    public  ASN1UTCTime(String time) {
        super(time);
        addTaint(time.getTaint());
        
    }

    
}

