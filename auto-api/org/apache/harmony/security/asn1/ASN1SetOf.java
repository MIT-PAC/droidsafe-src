package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class ASN1SetOf extends ASN1ValueCollection {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.432 -0400", hash_original_method = "49B473C463A20ED93456B0E252B9BBF0", hash_generated_method = "010E6CB1BA97B161E8C9420B580E2B49")
    public  ASN1SetOf(ASN1Type type) {
        super(TAG_SETOF, type);
        addTaint(type.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.432 -0400", hash_original_method = "F57C1115BE0470F5CDF9CC2B3F700EBD", hash_generated_method = "13C4EBAF3440EE445EE102AFEEF5707C")
    public Object decode(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_273509117 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_627886209 = null; //Variable for return #2
        in.readSetOf(this);
        {
            varB4EAC82CA7396A68D541C85D26508E83_273509117 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_627886209 = getDecodedObject(in);
        addTaint(in.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_1900817794; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1900817794 = varB4EAC82CA7396A68D541C85D26508E83_273509117;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1900817794 = varB4EAC82CA7396A68D541C85D26508E83_627886209;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1900817794.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1900817794;
        // ---------- Original Method ----------
        //in.readSetOf(this);
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.436 -0400", hash_original_method = "4C2F70C283FCFB9FEA82A949984FC67E", hash_generated_method = "58104E86AE1296D24D8A33D8D9862C69")
    public final void encodeContent(BerOutputStream out) {
        out.encodeSetOf(this);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.encodeSetOf(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.436 -0400", hash_original_method = "0CA5076CBF895038CB7C559B8AB50108", hash_generated_method = "77515CBB134A112A68EC0A23B18FCF48")
    public final void setEncodingContent(BerOutputStream out) {
        out.getSetOfLength(this);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.getSetOfLength(this);
    }

    
}

