package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.util.Arrays;

public final class ASN1Enumerated extends ASN1Primitive {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.169 -0400", hash_original_method = "AA03F41F75612EB5366E32BDDDAEA1AC", hash_generated_method = "11C6DEF098A19B58952BF9C0E3E54B4B")
    public  ASN1Enumerated() {
        super(TAG_ENUM);
        // ---------- Original Method ----------
    }

    
        public static ASN1Enumerated getInstance() {
        return ASN1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.170 -0400", hash_original_method = "810B1EC4B5D81C8B87770AF406E0EFF5", hash_generated_method = "A296D653A15698FB6197B994A6207FF4")
    public Object decode(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1495318494 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_994223671 = null; //Variable for return #2
        in.readEnumerated();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1495318494 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_994223671 = getDecodedObject(in);
        addTaint(in.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_1777425014; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1777425014 = varB4EAC82CA7396A68D541C85D26508E83_1495318494;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1777425014 = varB4EAC82CA7396A68D541C85D26508E83_994223671;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1777425014.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1777425014;
        // ---------- Original Method ----------
        //in.readEnumerated();
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.170 -0400", hash_original_method = "82D4C6A7EA2B5E6BF0228FD44BF29A31", hash_generated_method = "F649F0BFBD685C6F8C6A19E99C60E148")
    public Object getDecodedObject(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_407576813 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_407576813 = Arrays.copyOfRange(in.buffer, in.contentOffset, in.contentOffset + in.length);
        addTaint(in.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_407576813.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_407576813;
        // ---------- Original Method ----------
        //return Arrays.copyOfRange(in.buffer, in.contentOffset, in.contentOffset + in.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.177 -0400", hash_original_method = "8972E72D5FACAB6282BB97DA2EB5021B", hash_generated_method = "BAA11C0A71C0484BDDB971998BB29CEF")
    public void encodeContent(BerOutputStream out) {
        out.encodeInteger();
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.encodeInteger();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.177 -0400", hash_original_method = "9FE1E04620BBFE07A0C8F71EADD10582", hash_generated_method = "28412896F17AF4B874C6F607DA4D2993")
    public void setEncodingContent(BerOutputStream out) {
        out.length = ((byte[]) out.content).length;
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.length = ((byte[]) out.content).length;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.178 -0400", hash_original_field = "19E9747C25CFD9985C0EA6DB9F3FBE5D", hash_generated_field = "110F740FCA0291079D8839677A904C42")

    private static ASN1Enumerated ASN1 = new ASN1Enumerated();
}

