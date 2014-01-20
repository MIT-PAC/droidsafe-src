package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Date;

public class ASN1UTCTime extends DERUTCTime {
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.376 -0500", hash_original_method = "9FB0B414332B377CAC617115546A77CB", hash_generated_method = "9FB0B414332B377CAC617115546A77CB")
    
ASN1UTCTime(byte[] bytes)
    {
        super(bytes);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.379 -0500", hash_original_method = "51D45B3CCAB2D6EB6F627DE79DEFE5C9", hash_generated_method = "64617487B3C72561F581D1EC7D18FB10")
    
public ASN1UTCTime(Date time)
    {
        super(time);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.381 -0500", hash_original_method = "56D06078D341C61AAEA2DCB1CFA1CC92", hash_generated_method = "03C35778C4E82030CB93F9B01BF2E403")
    
public ASN1UTCTime(String time)
    {
        super(time);
    }
    
}

