package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class BERApplicationSpecificParser implements ASN1ApplicationSpecificParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.098 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "3577E5E669CAE3960DB734B50E9992AB")

    private int tag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.099 -0400", hash_original_field = "3643B86326B2FFCC0A085B4DD3A4309B", hash_generated_field = "BDA992D1A9789DCE4BA9542117A08206")

    private ASN1StreamParser parser;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.099 -0400", hash_original_method = "E0609A70F39E6E6F4E13B827D68F5B4C", hash_generated_method = "1CDD23288A33C70CA68843FF735DD782")
      BERApplicationSpecificParser(int tag, ASN1StreamParser parser) {
        this.tag = tag;
        this.parser = parser;
        // ---------- Original Method ----------
        //this.tag = tag;
        //this.parser = parser;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.099 -0400", hash_original_method = "FC19FBA5450B1E3458DF66BAD498F5C7", hash_generated_method = "22B360C6E13993C8FBF29720CE5BB5CB")
    public DEREncodable readObject() throws IOException {
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1206445314 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1206445314 = parser.readObject();
        varB4EAC82CA7396A68D541C85D26508E83_1206445314.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1206445314;
        // ---------- Original Method ----------
        //return parser.readObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.100 -0400", hash_original_method = "B2A8CB4DD75EA6F990011FAB1A0E301F", hash_generated_method = "8AB714B8B54D983699AB02AA733C975C")
    public DERObject getLoadedObject() throws IOException {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_2008229275 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2008229275 = new BERApplicationSpecific(tag, parser.readVector());
        varB4EAC82CA7396A68D541C85D26508E83_2008229275.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2008229275;
        // ---------- Original Method ----------
        //return new BERApplicationSpecific(tag, parser.readVector());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.100 -0400", hash_original_method = "C25B7E6814F316F8AC8F55D830DF862A", hash_generated_method = "F6B986AE09886FD3888A9C55E4F8FDD1")
    public DERObject getDERObject() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_355169937 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_355169937 = getLoadedObject();
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1ParsingException(e.getMessage(), e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_355169937.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_355169937;
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

