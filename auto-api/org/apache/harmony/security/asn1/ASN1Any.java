package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public final class ASN1Any extends ASN1Type {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.045 -0400", hash_original_method = "DC9940F4B091FD322F1F3A80DE5DA9F7", hash_generated_method = "4BC9F36E0DA8D5C47FBAC49DEA0BD42A")
    public  ASN1Any() {
        super(TAG_ANY);
        // ---------- Original Method ----------
    }

    
        public static ASN1Any getInstance() {
        return ASN1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.046 -0400", hash_original_method = "0A9787140DA63C802B73071FD0FF80EC", hash_generated_method = "F10F83F2C7AE966389BAA4DDFE18A09E")
    public final boolean checkTag(int identifier) {
        addTaint(identifier);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_423157743 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_423157743;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.046 -0400", hash_original_method = "F8B6556748DA568C4BCDCD3BC4853721", hash_generated_method = "ACE0FF31537B88BBBFAA3F943E9A25C5")
    public Object decode(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_2016222916 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1613732803 = null; //Variable for return #2
        in.readContent();
        {
            varB4EAC82CA7396A68D541C85D26508E83_2016222916 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1613732803 = getDecodedObject(in);
        addTaint(in.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_1730003066; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1730003066 = varB4EAC82CA7396A68D541C85D26508E83_2016222916;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1730003066 = varB4EAC82CA7396A68D541C85D26508E83_1613732803;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1730003066.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1730003066;
        // ---------- Original Method ----------
        //in.readContent();
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.054 -0400", hash_original_method = "7A8EAE0B0D15C25D8FE798817C72F0C1", hash_generated_method = "F26DE832AB53F63352E137ABACD910B1")
    public Object getDecodedObject(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1353483349 = null; //Variable for return #1
        byte[] bytesEncoded;
        bytesEncoded = new byte[in.offset - in.tagOffset];
        System.arraycopy(in.buffer, in.tagOffset, bytesEncoded, 0,
                bytesEncoded.length);
        varB4EAC82CA7396A68D541C85D26508E83_1353483349 = bytesEncoded;
        addTaint(in.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1353483349.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1353483349;
        // ---------- Original Method ----------
        //byte[] bytesEncoded = new byte[in.offset - in.tagOffset];
        //System.arraycopy(in.buffer, in.tagOffset, bytesEncoded, 0,
                //bytesEncoded.length);
        //return bytesEncoded;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.055 -0400", hash_original_method = "7511C9B0E36E939B1775FC9EA0F02F20", hash_generated_method = "A8E9C457ADBC773C8E6B07ACE83BB161")
    public void encodeASN(BerOutputStream out) {
        out.encodeANY();
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.encodeANY();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.055 -0400", hash_original_method = "E4481BCA62553D7934DD52F370937ED4", hash_generated_method = "0E2C909D3F4634D5C1DDBFD77A5BB9EC")
    public void encodeContent(BerOutputStream out) {
        out.encodeANY();
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.encodeANY();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.055 -0400", hash_original_method = "9FE1E04620BBFE07A0C8F71EADD10582", hash_generated_method = "28412896F17AF4B874C6F607DA4D2993")
    public void setEncodingContent(BerOutputStream out) {
        out.length = ((byte[]) out.content).length;
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.length = ((byte[]) out.content).length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.056 -0400", hash_original_method = "4E35D9A00930BDC0DD7D3944E7329986", hash_generated_method = "0D2F523150EF0439D0D5F1BCCCFEFD49")
    public int getEncodedLength(BerOutputStream out) {
        addTaint(out.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1583622975 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1583622975;
        // ---------- Original Method ----------
        //return out.length;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:08.056 -0400", hash_original_field = "0236CB100B50FFA118DD93153CCD6AB1", hash_generated_field = "5FA7E6D97C85CDD63B1BFB45A1D0AD17")

    private static ASN1Any ASN1 = new ASN1Any();
}

