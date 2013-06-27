package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public final class ASN1Boolean extends ASN1Primitive {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.074 -0400", hash_original_method = "FD99504F4E1A7A3268A56063556CF13F", hash_generated_method = "02BFB4CEBA233BD3B2DAAA4AB6F0DE78")
    public  ASN1Boolean() {
        super(TAG_BOOLEAN);
        // ---------- Original Method ----------
    }

    
        public static ASN1Boolean getInstance() {
        return ASN1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.074 -0400", hash_original_method = "4CABEEE4334687B876309AFB865CC60D", hash_generated_method = "AA07DD0336C27D60564264B9A8AC71F1")
    public Object decode(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1686967538 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1010283142 = null; //Variable for return #2
        in.readBoolean();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1686967538 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1010283142 = getDecodedObject(in);
        addTaint(in.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_1301440720; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1301440720 = varB4EAC82CA7396A68D541C85D26508E83_1686967538;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1301440720 = varB4EAC82CA7396A68D541C85D26508E83_1010283142;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1301440720.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1301440720;
        // ---------- Original Method ----------
        //in.readBoolean();
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.075 -0400", hash_original_method = "61E80FB6E60B72FAF41ECC8283C8390E", hash_generated_method = "1672B580F440B8A0F1CD0A90DF72682E")
    @Override
    public Object getDecodedObject(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1802446190 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_2085872190 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1802446190 = Boolean.FALSE;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2085872190 = Boolean.TRUE;
        addTaint(in.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_2031458398; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2031458398 = varB4EAC82CA7396A68D541C85D26508E83_1802446190;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2031458398 = varB4EAC82CA7396A68D541C85D26508E83_2085872190;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2031458398.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2031458398;
        // ---------- Original Method ----------
        //if (in.buffer[in.contentOffset] == 0) {
            //return Boolean.FALSE;
        //}
        //return Boolean.TRUE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.076 -0400", hash_original_method = "6CB7A1753C32BDECF173E6F0AF328B6D", hash_generated_method = "683299BC050C2E06B18C4827F7AB4A6F")
    public void encodeContent(BerOutputStream out) {
        out.encodeBoolean();
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.encodeBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.076 -0400", hash_original_method = "E10D3150F01479FE85EBF9E119EE1844", hash_generated_method = "E5F019B44A8D9708611B427F89C6C298")
    public void setEncodingContent(BerOutputStream out) {
        out.length = 1;
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.length = 1;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.076 -0400", hash_original_field = "7BCAFF74B89ECED52EBB0375DE737548", hash_generated_field = "6C4279BEF1658D053A4BB398FB2569EC")

    private static ASN1Boolean ASN1 = new ASN1Boolean();
}

