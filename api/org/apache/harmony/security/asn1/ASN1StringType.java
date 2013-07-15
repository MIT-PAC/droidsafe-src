package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.nio.charset.Charsets;

public abstract class ASN1StringType extends ASN1Type {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.695 -0400", hash_original_method = "7B031F7F0A5A04AD815BCBD7B272BFA2", hash_generated_method = "EED0B08A3072E00A1C057D9E3E25354D")
    public  ASN1StringType(int tagNumber) {
        super(tagNumber);
        addTaint(tagNumber);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.696 -0400", hash_original_method = "C1B77E79BF2CF152F3FF34DFE43DC50B", hash_generated_method = "4CB59457D440CBA4932E82CA75C42629")
    public final boolean checkTag(int identifier) {
        addTaint(identifier);
        boolean var9A8EAB5521C15441F9869C70002988EF_379199909 = (this.id == identifier || this.constrId == identifier);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1383139625 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1383139625;
        // ---------- Original Method ----------
        //return this.id == identifier || this.constrId == identifier;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.696 -0400", hash_original_method = "3BFD309C154715F9457C75DB61750061", hash_generated_method = "FFB0B882C1FE60C9C3810F1EA049467C")
    public Object decode(BerInputStream in) throws IOException {
        addTaint(in.getTaint());
        in.readString(this);
    if(in.isVerify)        
        {
Object var540C13E9E156B687226421B24F2DF178_1058580428 =             null;
            var540C13E9E156B687226421B24F2DF178_1058580428.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1058580428;
        } //End block
Object var6AD043AF0280111F31D0D60A6CD70863_444765436 =         getDecodedObject(in);
        var6AD043AF0280111F31D0D60A6CD70863_444765436.addTaint(taint);
        return var6AD043AF0280111F31D0D60A6CD70863_444765436;
        // ---------- Original Method ----------
        //in.readString(this);
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.696 -0400", hash_original_method = "2F8FDB092DEF849FEC2EBC30268CC3AE", hash_generated_method = "786B4B053A814BC017079E7DE9F35258")
    public Object getDecodedObject(BerInputStream in) throws IOException {
        addTaint(in.getTaint());
Object var83BCE5B133191D7D26A24E29D20910C3_1343261993 =         new String(in.buffer, in.contentOffset, in.length, Charsets.ISO_8859_1);
        var83BCE5B133191D7D26A24E29D20910C3_1343261993.addTaint(taint);
        return var83BCE5B133191D7D26A24E29D20910C3_1343261993;
        // ---------- Original Method ----------
        //return new String(in.buffer, in.contentOffset, in.length, Charsets.ISO_8859_1);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.697 -0400", hash_original_method = "56680739FC748952853149E66560E94E", hash_generated_method = "48F131D00A1E1D9FE33198C4F5017853")
    public void encodeASN(BerOutputStream out) {
        addTaint(out.getTaint());
        out.encodeTag(id);
        encodeContent(out);
        // ---------- Original Method ----------
        //out.encodeTag(id);
        //encodeContent(out);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.697 -0400", hash_original_method = "10029CCA141FCEE9BD14EC9FEEE7A0BB", hash_generated_method = "5091649F00D157E3102BCEC361AA8E5E")
    public void encodeContent(BerOutputStream out) {
        addTaint(out.getTaint());
        out.encodeString();
        // ---------- Original Method ----------
        //out.encodeString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.697 -0400", hash_original_method = "138CA2E3F6E6A00430513A77732291AD", hash_generated_method = "BFBE76DFFA47FA40E7E1BFB51B23707F")
    public void setEncodingContent(BerOutputStream out) {
        addTaint(out.getTaint());
        byte[] bytes = ((String) out.content).getBytes(Charsets.UTF_8);
        out.content = bytes;
        out.length = bytes.length;
        // ---------- Original Method ----------
        //byte[] bytes = ((String) out.content).getBytes(Charsets.UTF_8);
        //out.content = bytes;
        //out.length = bytes.length;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.698 -0400", hash_original_field = "5123EB3DCB4203BDB64AB4DA28CAA061", hash_generated_field = "817C8B855F78C4F2BF6AE15E81C57C0A")

    public static final ASN1StringType BMPSTRING = new ASN1StringType(
            TAG_BMPSTRING) {
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.698 -0400", hash_original_field = "B0394A593BEAFA22BB69BD3737C9E0F9", hash_generated_field = "46FCF84077C5B6BDE8192C5E63FCFA67")

    public static final ASN1StringType IA5STRING = new ASN1StringType(
            TAG_IA5STRING) {
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.698 -0400", hash_original_field = "332C5D5A7718ED13E94CEF3F29D60C9F", hash_generated_field = "66D25C1EA76D6D409D30D03BF74F1CFE")

    public static final ASN1StringType GENERALSTRING = new ASN1StringType(
            TAG_GENERALSTRING) {
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.698 -0400", hash_original_field = "038D3B37F97780B1F5E4200605C84B71", hash_generated_field = "B89ED27D3783F77EA167D653EB03C9B5")

    public static final ASN1StringType PRINTABLESTRING = new ASN1StringType(
            TAG_PRINTABLESTRING) {
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.698 -0400", hash_original_field = "908B5097AF93F3FD9FF5E7C96811B058", hash_generated_field = "B293D72E13A2C763BCC69EF45A60C3AE")

    public static final ASN1StringType TELETEXSTRING = new ASN1StringType(
            TAG_TELETEXSTRING) {
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.698 -0400", hash_original_field = "F48B3E5329D1CE25AE1227491F4BFD57", hash_generated_field = "B02FC64488CFAC76F7DB04EA74E308B7")

    public static final ASN1StringType UNIVERSALSTRING = new ASN1StringType(
            TAG_UNIVERSALSTRING) {
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.642 -0400", hash_original_field = "4C261A036B603BB0A966CDA0E25AA46C", hash_generated_field = "8325E7625E0332A172357D8E029897AE")

    public static final ASN1StringType UTF8STRING = new ASN1StringType(TAG_UTF8STRING) {
        @DSModeled(DSC.SAFE)
    @Override public Object getDecodedObject(BerInputStream in) throws IOException {
            return new String(in.buffer, in.contentOffset, in.length, Charsets.UTF_8);
        }

        @DSModeled(DSC.SAFE)
    @Override public void setEncodingContent(BerOutputStream out) {
            byte[] bytes = ((String) out.content).getBytes(Charsets.UTF_8);
            out.content = bytes;
            out.length = bytes.length;
        }
    };
}

