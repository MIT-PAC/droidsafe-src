package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.nio.charset.Charsets;

public abstract class ASN1StringType extends ASN1Type {
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.655 -0400", hash_original_method = "8F8B3D16DE176F56B0B78AD50FD6AF2B", hash_generated_method = "D816265F1AC62068825CDB87B9C24181")
        @DSModeled(DSC.SAFE)
        @Override
        public Object getDecodedObject(BerInputStream in) throws IOException {
            dsTaint.addTaint(in.dsTaint);
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new String(in.buffer, in.contentOffset, in.length, Charsets.UTF_8);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.655 -0400", hash_original_method = "138CA2E3F6E6A00430513A77732291AD", hash_generated_method = "6711BBEA7972B35C0515E496817B97C9")
        @DSModeled(DSC.SAFE)
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.655 -0400", hash_original_method = "7B031F7F0A5A04AD815BCBD7B272BFA2", hash_generated_method = "CE830177B2D5D8D273B937CCBCDEE8D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ASN1StringType(int tagNumber) {
        super(tagNumber);
        dsTaint.addTaint(tagNumber);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.655 -0400", hash_original_method = "C1B77E79BF2CF152F3FF34DFE43DC50B", hash_generated_method = "08646ED664D497369D321E80792C3F18")
    @DSModeled(DSC.SAFE)
    public final boolean checkTag(int identifier) {
        dsTaint.addTaint(identifier);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.id == identifier || this.constrId == identifier;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.655 -0400", hash_original_method = "3BFD309C154715F9457C75DB61750061", hash_generated_method = "3B4DA194A11B61F0028D782B200E8571")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object decode(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        in.readString(this);
        Object var883E4A51D9FE1FCA5622395E00C94DE9_2124393596 = (getDecodedObject(in));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //in.readString(this);
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.655 -0400", hash_original_method = "2F8FDB092DEF849FEC2EBC30268CC3AE", hash_generated_method = "7064A82FAA1D78A2BC0CDF659EFDF201")
    @DSModeled(DSC.SAFE)
    public Object getDecodedObject(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new String(in.buffer, in.contentOffset, in.length, Charsets.ISO_8859_1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.655 -0400", hash_original_method = "56680739FC748952853149E66560E94E", hash_generated_method = "E0B7C57DFF93BF42843AE9D6BE678E03")
    @DSModeled(DSC.SAFE)
    public void encodeASN(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.encodeTag(id);
        encodeContent(out);
        // ---------- Original Method ----------
        //out.encodeTag(id);
        //encodeContent(out);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.655 -0400", hash_original_method = "10029CCA141FCEE9BD14EC9FEEE7A0BB", hash_generated_method = "71B2933C9BAA3F1F9650FD4B56E48A19")
    @DSModeled(DSC.SAFE)
    public void encodeContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        out.encodeString();
        // ---------- Original Method ----------
        //out.encodeString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.655 -0400", hash_original_method = "138CA2E3F6E6A00430513A77732291AD", hash_generated_method = "51A1EC822DC6A22E2EF08B9FD19E9882")
    @DSModeled(DSC.SAFE)
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

    
}


