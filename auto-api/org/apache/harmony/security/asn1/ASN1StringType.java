package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.nio.charset.Charsets;

public abstract class ASN1StringType extends ASN1Type {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.635 -0400", hash_original_method = "7B031F7F0A5A04AD815BCBD7B272BFA2", hash_generated_method = "EED0B08A3072E00A1C057D9E3E25354D")
    public  ASN1StringType(int tagNumber) {
        super(tagNumber);
        addTaint(tagNumber);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.635 -0400", hash_original_method = "C1B77E79BF2CF152F3FF34DFE43DC50B", hash_generated_method = "644B49580AD97DFF1FA54F3610DA73BE")
    public final boolean checkTag(int identifier) {
        addTaint(identifier);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1181865313 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1181865313;
        // ---------- Original Method ----------
        //return this.id == identifier || this.constrId == identifier;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.636 -0400", hash_original_method = "3BFD309C154715F9457C75DB61750061", hash_generated_method = "D727A4A0E845A601D3847A6683EE5DC8")
    public Object decode(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1372041661 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1880004247 = null; //Variable for return #2
        in.readString(this);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1372041661 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1880004247 = getDecodedObject(in);
        addTaint(in.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_80825376; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_80825376 = varB4EAC82CA7396A68D541C85D26508E83_1372041661;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_80825376 = varB4EAC82CA7396A68D541C85D26508E83_1880004247;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_80825376.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_80825376;
        // ---------- Original Method ----------
        //in.readString(this);
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @Override public Object getDecodedObject(BerInputStream in) throws IOException {
            return new String(in.buffer, in.contentOffset, in.length, Charsets.UTF_8);
        }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.638 -0400", hash_original_method = "56680739FC748952853149E66560E94E", hash_generated_method = "25D1D9CE9976FB742A46C9A1FF96788B")
    public void encodeASN(BerOutputStream out) {
        out.encodeTag(id);
        encodeContent(out);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.encodeTag(id);
        //encodeContent(out);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.639 -0400", hash_original_method = "10029CCA141FCEE9BD14EC9FEEE7A0BB", hash_generated_method = "BF1523BCD7C591CB8E3B26A4047B3327")
    public void encodeContent(BerOutputStream out) {
        out.encodeString();
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.encodeString();
    }

    
    @Override public void setEncodingContent(BerOutputStream out) {
            byte[] bytes = ((String) out.content).getBytes(Charsets.UTF_8);
            out.content = bytes;
            out.length = bytes.length;
        }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.641 -0400", hash_original_field = "5123EB3DCB4203BDB64AB4DA28CAA061", hash_generated_field = "817C8B855F78C4F2BF6AE15E81C57C0A")

    public static final ASN1StringType BMPSTRING = new ASN1StringType(
            TAG_BMPSTRING) {
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.641 -0400", hash_original_field = "B0394A593BEAFA22BB69BD3737C9E0F9", hash_generated_field = "46FCF84077C5B6BDE8192C5E63FCFA67")

    public static final ASN1StringType IA5STRING = new ASN1StringType(
            TAG_IA5STRING) {
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.641 -0400", hash_original_field = "332C5D5A7718ED13E94CEF3F29D60C9F", hash_generated_field = "66D25C1EA76D6D409D30D03BF74F1CFE")

    public static final ASN1StringType GENERALSTRING = new ASN1StringType(
            TAG_GENERALSTRING) {
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.641 -0400", hash_original_field = "038D3B37F97780B1F5E4200605C84B71", hash_generated_field = "B89ED27D3783F77EA167D653EB03C9B5")

    public static final ASN1StringType PRINTABLESTRING = new ASN1StringType(
            TAG_PRINTABLESTRING) {
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.641 -0400", hash_original_field = "908B5097AF93F3FD9FF5E7C96811B058", hash_generated_field = "B293D72E13A2C763BCC69EF45A60C3AE")

    public static final ASN1StringType TELETEXSTRING = new ASN1StringType(
            TAG_TELETEXSTRING) {
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.641 -0400", hash_original_field = "F48B3E5329D1CE25AE1227491F4BFD57", hash_generated_field = "B02FC64488CFAC76F7DB04EA74E308B7")

    public static final ASN1StringType UNIVERSALSTRING = new ASN1StringType(
            TAG_UNIVERSALSTRING) {
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.642 -0400", hash_original_field = "4C261A036B603BB0A966CDA0E25AA46C", hash_generated_field = "8325E7625E0332A172357D8E029897AE")

    public static final ASN1StringType UTF8STRING = new ASN1StringType(TAG_UTF8STRING) {
        @Override public Object getDecodedObject(BerInputStream in) throws IOException {
            return new String(in.buffer, in.contentOffset, in.length, Charsets.UTF_8);
        }

        @Override public void setEncodingContent(BerOutputStream out) {
            byte[] bytes = ((String) out.content).getBytes(Charsets.UTF_8);
            out.content = bytes;
            out.length = bytes.length;
        }
    };
}

