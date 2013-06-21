package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public final class ASN1Implicit extends ASN1Type {
    private ASN1Type type;
    private int taggingType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.969 -0400", hash_original_method = "885EAD88CE0EDAA6AE8B231FCD302B70", hash_generated_method = "E5FFBD89E626BCC3D1AA11D96079EA3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ASN1Implicit(int tagNumber, ASN1Type type) {
        super(CLASS_CONTEXTSPECIFIC, tagNumber);
        dsTaint.addTaint(tagNumber);
        dsTaint.addTaint(type.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Implicit tagging can not be used for ASN.1 ANY or CHOICE type");
        } //End block
        {
            boolean var7D16F4D21FCDA7B88995592766A30F11_1382721343 = (type.checkTag(type.id));
            {
                {
                    boolean var198894DB5720C5DF4565C2CB8C2924C0_417624406 = (type.checkTag(type.constrId));
                    {
                        taggingType = TAGGING_STRING;
                    } //End block
                    {
                        taggingType = TAGGING_PRIMITIVE;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                taggingType = TAGGING_CONSTRUCTED;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if ((type instanceof ASN1Choice) || (type instanceof ASN1Any)) {
            //throw new IllegalArgumentException("Implicit tagging can not be used for ASN.1 ANY or CHOICE type");
        //}
        //this.type = type;
        //if (type.checkTag(type.id)) {
            //if (type.checkTag(type.constrId)) {
                //taggingType = TAGGING_STRING;
            //} else {
                //taggingType = TAGGING_PRIMITIVE;
            //}
        //} else {
            //taggingType = TAGGING_CONSTRUCTED;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.970 -0400", hash_original_method = "D92B272BF30997E81DA1469852FE3C4F", hash_generated_method = "93006607416BF43D83741F941BF10D08")
    @DSModeled(DSC.SAFE)
    public final boolean checkTag(int identifier) {
        dsTaint.addTaint(identifier);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //switch (taggingType) {
        //case TAGGING_PRIMITIVE:
            //return id == identifier;
        //case TAGGING_CONSTRUCTED:
            //return constrId == identifier;
        //default: 
            //return id == identifier || constrId == identifier;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.970 -0400", hash_original_method = "7AB778F30F3F4E1DD4EDD8138709F383", hash_generated_method = "56A0EED7FC856A8ECA0FFD60CAEF7CB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object decode(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        {
            boolean var766EA6E7D31783D8197180D70708A15A_941971655 = (!checkTag(in.tag));
            {
                if (DroidSafeAndroidRuntime.control) throw new ASN1Exception("ASN.1 implicitly tagged type expected at " +
                    "[" + in.tagOffset + "]. Expected tag: " + Integer.toHexString(id) + ", " +
                    "but got " + Integer.toHexString(in.tag));
            } //End block
        } //End collapsed parenthetic
        {
            in.tag = type.id;
        } //End block
        {
            in.tag = type.constrId;
        } //End block
        in.content = type.decode(in);
        Object var883E4A51D9FE1FCA5622395E00C94DE9_932625733 = (getDecodedObject(in));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!checkTag(in.tag)) {
            //throw new ASN1Exception("ASN.1 implicitly tagged type expected at " +
                    //"[" + in.tagOffset + "]. Expected tag: " + Integer.toHexString(id) + ", " +
                    //"but got " + Integer.toHexString(in.tag));
        //}
        //if (id == in.tag) {
            //in.tag = type.id;
        //} else {
            //in.tag = type.constrId;
        //}
        //in.content = type.decode(in);
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.970 -0400", hash_original_method = "5EC2F9C60EB654B91B6E1D4F997368F9", hash_generated_method = "FADC12A7FCD6F7C0CB82E483A4804F50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void encodeASN(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        {
            out.encodeTag(constrId);
        } //End block
        {
            out.encodeTag(id);
        } //End block
        encodeContent(out);
        // ---------- Original Method ----------
        //if (taggingType == TAGGING_CONSTRUCTED) {
            //out.encodeTag(constrId);
        //} else {
            //out.encodeTag(id);
        //}
        //encodeContent(out);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.970 -0400", hash_original_method = "774C00840199094903FD771E0305B5DA", hash_generated_method = "14C788C79BC139879EF406166B7164F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void encodeContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        type.encodeContent(out);
        // ---------- Original Method ----------
        //type.encodeContent(out);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:39.971 -0400", hash_original_method = "142D84AECEAB554A6A5BF2DED12EF71F", hash_generated_method = "7B62B916A39DA9CF55A566FC7EE90EA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setEncodingContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        type.setEncodingContent(out);
        // ---------- Original Method ----------
        //type.setEncodingContent(out);
    }

    
    private static final int TAGGING_PRIMITIVE = 0;
    private static final int TAGGING_CONSTRUCTED = 1;
    private static final int TAGGING_STRING = 2;
}

