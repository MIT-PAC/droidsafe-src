package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public class ASN1SequenceOf extends ASN1ValueCollection {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.415 -0400", hash_original_method = "21EE3E508EAE978A6E4C8F66A4495FB2", hash_generated_method = "6AA343111503CCCABA03EAC384BEDE01")
    public  ASN1SequenceOf(ASN1Type type) {
        super(TAG_SEQUENCE, type);
        addTaint(type.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.416 -0400", hash_original_method = "1210CAF0851F865D477F96ED0B5EA47B", hash_generated_method = "E3329B25F4C3E622152052121370C0FC")
    public Object decode(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_891267161 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_734878126 = null; //Variable for return #2
        in.readSequenceOf(this);
        {
            varB4EAC82CA7396A68D541C85D26508E83_891267161 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_734878126 = getDecodedObject(in);
        addTaint(in.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_1874254182; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1874254182 = varB4EAC82CA7396A68D541C85D26508E83_891267161;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1874254182 = varB4EAC82CA7396A68D541C85D26508E83_734878126;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1874254182.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1874254182;
        // ---------- Original Method ----------
        //in.readSequenceOf(this);
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.416 -0400", hash_original_method = "501E4537A812C53E7A97F9D07A5FDD79", hash_generated_method = "7CBAA074EE40169E508399A1B9082F42")
    public final void encodeContent(BerOutputStream out) {
        out.encodeSequenceOf(this);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.encodeSequenceOf(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.416 -0400", hash_original_method = "7ECE29473F04DAB7CB66888A658BFD1F", hash_generated_method = "28AD3CE6EEB3CFB920F23788E1BA81B5")
    public final void setEncodingContent(BerOutputStream out) {
        out.getSequenceOfLength(this);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.getSequenceOfLength(this);
    }

    
}

