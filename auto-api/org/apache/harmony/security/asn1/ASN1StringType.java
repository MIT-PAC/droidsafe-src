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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.002 -0400", hash_original_method = "7B031F7F0A5A04AD815BCBD7B272BFA2", hash_generated_method = "CB864DFF6C14614FC0CD7476F8C93056")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ASN1StringType(int tagNumber) {
        super(tagNumber);
        dsTaint.addTaint(tagNumber);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.002 -0400", hash_original_method = "C1B77E79BF2CF152F3FF34DFE43DC50B", hash_generated_method = "FDF6E2966579ED2C73F7ACFDF463DE81")
    @DSModeled(DSC.SAFE)
    public final boolean checkTag(int identifier) {
        dsTaint.addTaint(identifier);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.id == identifier || this.constrId == identifier;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.002 -0400", hash_original_method = "3BFD309C154715F9457C75DB61750061", hash_generated_method = "52266F117558FD2D2ED762BCAF317088")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object decode(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        in.readString(this);
        Object var883E4A51D9FE1FCA5622395E00C94DE9_1090132987 = (getDecodedObject(in));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //in.readString(this);
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.002 -0400", hash_original_method = "2F8FDB092DEF849FEC2EBC30268CC3AE", hash_generated_method = "35F75A9B678C299FD0FDD547512E2790")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getDecodedObject(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        Object var05175E33F479FA90A2C04E427CB301AB_1131531610 = (new String(in.buffer, in.contentOffset, in.length, Charsets.ISO_8859_1));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new String(in.buffer, in.contentOffset, in.length, Charsets.ISO_8859_1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.003 -0400", hash_original_method = "56680739FC748952853149E66560E94E", hash_generated_method = "513EDBA3166614A51C3201B35752465F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void encodeASN(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.encodeTag(id);
        encodeContent(out);
        // ---------- Original Method ----------
        //out.encodeTag(id);
        //encodeContent(out);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.003 -0400", hash_original_method = "10029CCA141FCEE9BD14EC9FEEE7A0BB", hash_generated_method = "59ABDD72FBC56361DB352C3387988B2F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void encodeContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.encodeString();
        // ---------- Original Method ----------
        //out.encodeString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.003 -0400", hash_original_method = "138CA2E3F6E6A00430513A77732291AD", hash_generated_method = "40E9E6D9C64EBFB6B0728FDBF37E0F8B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setEncodingContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        byte[] bytes;
        bytes = ((String) out.content).getBytes(Charsets.UTF_8);
        out.content = bytes;
        out.length = bytes.length;
        // ---------- Original Method ----------
        //byte[] bytes = ((String) out.content).getBytes(Charsets.UTF_8);
        //out.content = bytes;
        //out.length = bytes.length;
    }

    
    public static final ASN1StringType BMPSTRING = new ASN1StringType(
            TAG_BMPSTRING) {        
}; //Transformed anonymous class
    public static final ASN1StringType IA5STRING = new ASN1StringType(
            TAG_IA5STRING) {        
}; //Transformed anonymous class
    public static final ASN1StringType GENERALSTRING = new ASN1StringType(
            TAG_GENERALSTRING) {        
}; //Transformed anonymous class
    public static final ASN1StringType PRINTABLESTRING = new ASN1StringType(
            TAG_PRINTABLESTRING) {        
}; //Transformed anonymous class
    public static final ASN1StringType TELETEXSTRING = new ASN1StringType(
            TAG_TELETEXSTRING) {        
}; //Transformed anonymous class
    public static final ASN1StringType UNIVERSALSTRING = new ASN1StringType(
            TAG_UNIVERSALSTRING) {        
}; //Transformed anonymous class
    public static final ASN1StringType UTF8STRING = new ASN1StringType(TAG_UTF8STRING) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.003 -0400", hash_original_method = "8F8B3D16DE176F56B0B78AD50FD6AF2B", hash_generated_method = "453D429A9A09DB5FB5858A95F6C6ED22")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object getDecodedObject(BerInputStream in) throws IOException {
            dsTaint.addTaint(in.dsTaint);
            Object var168CAA2C18C31D670F478C9E72C25952_1803198046 = (new String(in.buffer, in.contentOffset, in.length, Charsets.UTF_8));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new String(in.buffer, in.contentOffset, in.length, Charsets.UTF_8);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.003 -0400", hash_original_method = "138CA2E3F6E6A00430513A77732291AD", hash_generated_method = "071D135C08718E3A3138BF253026F0CF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void setEncodingContent(BerOutputStream out) {
            dsTaint.addTaint(out.dsTaint);
            byte[] bytes;
            bytes = ((String) out.content).getBytes(Charsets.UTF_8);
            out.content = bytes;
            out.length = bytes.length;
            // ---------- Original Method ----------
            //byte[] bytes = ((String) out.content).getBytes(Charsets.UTF_8);
            //out.content = bytes;
            //out.length = bytes.length;
        }

        
}; //Transformed anonymous class
}

