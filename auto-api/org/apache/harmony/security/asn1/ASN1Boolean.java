package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public final class ASN1Boolean extends ASN1Primitive {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.177 -0400", hash_original_method = "FD99504F4E1A7A3268A56063556CF13F", hash_generated_method = "02BFB4CEBA233BD3B2DAAA4AB6F0DE78")
    public  ASN1Boolean() {
        super(TAG_BOOLEAN);
        // ---------- Original Method ----------
    }

    
        public static ASN1Boolean getInstance() {
        return ASN1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.178 -0400", hash_original_method = "4CABEEE4334687B876309AFB865CC60D", hash_generated_method = "E3AD2B4D5B819A1316196965C9CF4F0C")
    public Object decode(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_2020530190 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_721432751 = null; //Variable for return #2
        in.readBoolean();
        {
            varB4EAC82CA7396A68D541C85D26508E83_2020530190 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_721432751 = getDecodedObject(in);
        addTaint(in.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_675821262; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_675821262 = varB4EAC82CA7396A68D541C85D26508E83_2020530190;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_675821262 = varB4EAC82CA7396A68D541C85D26508E83_721432751;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_675821262.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_675821262;
        // ---------- Original Method ----------
        //in.readBoolean();
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.182 -0400", hash_original_method = "61E80FB6E60B72FAF41ECC8283C8390E", hash_generated_method = "816DB68C49DEA890598E9A36ED6B5688")
    @Override
    public Object getDecodedObject(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1374483823 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_577762791 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1374483823 = Boolean.FALSE;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_577762791 = Boolean.TRUE;
        addTaint(in.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_2129890703; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2129890703 = varB4EAC82CA7396A68D541C85D26508E83_1374483823;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2129890703 = varB4EAC82CA7396A68D541C85D26508E83_577762791;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2129890703.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2129890703;
        // ---------- Original Method ----------
        //if (in.buffer[in.contentOffset] == 0) {
            //return Boolean.FALSE;
        //}
        //return Boolean.TRUE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.182 -0400", hash_original_method = "6CB7A1753C32BDECF173E6F0AF328B6D", hash_generated_method = "683299BC050C2E06B18C4827F7AB4A6F")
    public void encodeContent(BerOutputStream out) {
        out.encodeBoolean();
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.encodeBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.187 -0400", hash_original_method = "E10D3150F01479FE85EBF9E119EE1844", hash_generated_method = "E5F019B44A8D9708611B427F89C6C298")
    public void setEncodingContent(BerOutputStream out) {
        out.length = 1;
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.length = 1;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.188 -0400", hash_original_field = "7BCAFF74B89ECED52EBB0375DE737548", hash_generated_field = "6C4279BEF1658D053A4BB398FB2569EC")

    private static ASN1Boolean ASN1 = new ASN1Boolean();
}

