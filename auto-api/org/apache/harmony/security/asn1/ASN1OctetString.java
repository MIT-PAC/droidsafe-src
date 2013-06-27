package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.util.Arrays;

public class ASN1OctetString extends ASN1StringType {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.361 -0400", hash_original_method = "FE8C061A61754FEAD4E80D2F91CDD232", hash_generated_method = "D6ED9BA2FC4CE32BD81039A4C8CEA95C")
    public  ASN1OctetString() {
        super(TAG_OCTETSTRING);
        // ---------- Original Method ----------
    }

    
        public static ASN1OctetString getInstance() {
        return ASN1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.362 -0400", hash_original_method = "28376DFC29A2213C4817BE9D28454968", hash_generated_method = "1FA94004AC25EE87400AAEF4AFD8E652")
    @Override
    public Object decode(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_410953402 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1907822564 = null; //Variable for return #2
        in.readOctetString();
        {
            varB4EAC82CA7396A68D541C85D26508E83_410953402 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1907822564 = getDecodedObject(in);
        addTaint(in.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_433910558; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_433910558 = varB4EAC82CA7396A68D541C85D26508E83_410953402;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_433910558 = varB4EAC82CA7396A68D541C85D26508E83_1907822564;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_433910558.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_433910558;
        // ---------- Original Method ----------
        //in.readOctetString();
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.362 -0400", hash_original_method = "82D4C6A7EA2B5E6BF0228FD44BF29A31", hash_generated_method = "7256C09D4C55C886AC5DA57CEB28AB37")
    @Override
    public Object getDecodedObject(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_73808719 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_73808719 = Arrays.copyOfRange(in.buffer, in.contentOffset, in.contentOffset + in.length);
        addTaint(in.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_73808719.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_73808719;
        // ---------- Original Method ----------
        //return Arrays.copyOfRange(in.buffer, in.contentOffset, in.contentOffset + in.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.362 -0400", hash_original_method = "612A16573B17613AF81AE7469C8D7FB4", hash_generated_method = "7710C605F6B7AC9571C65835E736DE71")
    @Override
    public void encodeContent(BerOutputStream out) {
        out.encodeOctetString();
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.encodeOctetString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.363 -0400", hash_original_method = "9FE1E04620BBFE07A0C8F71EADD10582", hash_generated_method = "E76CC36EECA306EE3B96C1FF22DE2414")
    @Override
    public void setEncodingContent(BerOutputStream out) {
        out.length = ((byte[]) out.content).length;
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.length = ((byte[]) out.content).length;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.363 -0400", hash_original_field = "25107E945D1756F345B685F812B017DB", hash_generated_field = "E718611209CE04AA7D01CC5C940EC79C")

    private static ASN1OctetString ASN1 = new ASN1OctetString();
}

