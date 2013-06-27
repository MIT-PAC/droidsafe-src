package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class BERApplicationSpecificParser implements ASN1ApplicationSpecificParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.759 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "3577E5E669CAE3960DB734B50E9992AB")

    private int tag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.759 -0400", hash_original_field = "3643B86326B2FFCC0A085B4DD3A4309B", hash_generated_field = "BDA992D1A9789DCE4BA9542117A08206")

    private ASN1StreamParser parser;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.759 -0400", hash_original_method = "E0609A70F39E6E6F4E13B827D68F5B4C", hash_generated_method = "1CDD23288A33C70CA68843FF735DD782")
      BERApplicationSpecificParser(int tag, ASN1StreamParser parser) {
        this.tag = tag;
        this.parser = parser;
        // ---------- Original Method ----------
        //this.tag = tag;
        //this.parser = parser;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.760 -0400", hash_original_method = "FC19FBA5450B1E3458DF66BAD498F5C7", hash_generated_method = "9E08A29A0A88ACCB169E0534E78567F4")
    public DEREncodable readObject() throws IOException {
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1576121796 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1576121796 = parser.readObject();
        varB4EAC82CA7396A68D541C85D26508E83_1576121796.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1576121796;
        // ---------- Original Method ----------
        //return parser.readObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.761 -0400", hash_original_method = "B2A8CB4DD75EA6F990011FAB1A0E301F", hash_generated_method = "7B506EE1D42B3415979C431C5C88587B")
    public DERObject getLoadedObject() throws IOException {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_434383410 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_434383410 = new BERApplicationSpecific(tag, parser.readVector());
        varB4EAC82CA7396A68D541C85D26508E83_434383410.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_434383410;
        // ---------- Original Method ----------
        //return new BERApplicationSpecific(tag, parser.readVector());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.761 -0400", hash_original_method = "C25B7E6814F316F8AC8F55D830DF862A", hash_generated_method = "F0F10994BEF6D60D7937C1546A16C800")
    public DERObject getDERObject() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_559401040 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_559401040 = getLoadedObject();
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1ParsingException(e.getMessage(), e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_559401040.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_559401040;
        // ---------- Original Method ----------
        //try
        //{
            //return getLoadedObject();
        //}
        //catch (IOException e)
        //{
            //throw new ASN1ParsingException(e.getMessage(), e);
        //}
    }

    
}

