package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public final class ASN1Explicit extends ASN1Constructed {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.491 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AC7D2E3EF11E777F80843D5021489F8A")

    public ASN1Type type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.492 -0400", hash_original_method = "B0F7BA820AB1A580DEB9F8D4C1B1D195", hash_generated_method = "CA71C1370A04DC8BDB05E00851CEE9B0")
    public  ASN1Explicit(int tagNumber, ASN1Type type) {
        this(CLASS_CONTEXTSPECIFIC, tagNumber, type);
        addTaint(tagNumber);
        addTaint(type.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.492 -0400", hash_original_method = "3F0FA66BFD46DABED8E86D16322A75CE", hash_generated_method = "DB9D8A3016AAEDEF88110689DA899F67")
    public  ASN1Explicit(int tagClass, int tagNumber, ASN1Type type) {
        super(tagClass, tagNumber);
        this.type = type;
        addTaint(tagClass);
        addTaint(tagNumber);
        // ---------- Original Method ----------
        //this.type = type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.494 -0400", hash_original_method = "BF5194A9A90A1C345CA0C933EC20C89E", hash_generated_method = "BBAFF8F0FED22F4B9577CA4A5EC499D2")
    public Object decode(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_570916762 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_626931091 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 explicitly tagged type is expected at [" +
                    in.tagOffset + "]. Expected tag: " + Integer.toHexString(constrId) + ", " +
                    "but encountered tag " + Integer.toHexString(in.tag));
        } //End block
        in.next();
        in.content = type.decode(in);
        {
            varB4EAC82CA7396A68D541C85D26508E83_570916762 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_626931091 = getDecodedObject(in);
        addTaint(in.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_111396031; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_111396031 = varB4EAC82CA7396A68D541C85D26508E83_570916762;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_111396031 = varB4EAC82CA7396A68D541C85D26508E83_626931091;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_111396031.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_111396031;
        // ---------- Original Method ----------
        //if (constrId != in.tag) {
            //throw new ASN1Exception("ASN.1 explicitly tagged type is expected at [" +
                    //in.tagOffset + "]. Expected tag: " + Integer.toHexString(constrId) + ", " +
                    //"but encountered tag " + Integer.toHexString(in.tag));
        //}
        //in.next();
        //in.content = type.decode(in);
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.494 -0400", hash_original_method = "185B9650CC00F76A6008982D1539FA31", hash_generated_method = "852239BAD4699BA48117A978FF49E2A6")
    public void encodeContent(BerOutputStream out) {
        out.encodeExplicit(this);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.encodeExplicit(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.494 -0400", hash_original_method = "8EE64F8332C91721514C0E16F4A7E840", hash_generated_method = "0412E9CFB735B05F0765627261DD4844")
    public void setEncodingContent(BerOutputStream out) {
        out.getExplicitLength(this);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.getExplicitLength(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.495 -0400", hash_original_method = "8627A6334FE9B6784BD6CB87A9255671", hash_generated_method = "138FDB0A22F6405788D7AE8B34A5F6FA")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1001144361 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1001144361 = super.toString() + " for type " + type;
        varB4EAC82CA7396A68D541C85D26508E83_1001144361.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1001144361;
        // ---------- Original Method ----------
        //return super.toString() + " for type " + type;
    }

    
}

