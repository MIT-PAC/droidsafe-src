package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;

public final class ASN1Implicit extends ASN1Type {
    private static final int TAGGING_PRIMITIVE = 0;
    private static final int TAGGING_CONSTRUCTED = 1;
    private static final int TAGGING_STRING = 2;
    private final ASN1Type type;
    private final int taggingType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.636 -0400", hash_original_method = "885EAD88CE0EDAA6AE8B231FCD302B70", hash_generated_method = "A45C3A512B30C30452FE31A64A3A9BA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ASN1Implicit(int tagNumber, ASN1Type type) {
        super(CLASS_CONTEXTSPECIFIC, tagNumber);
        dsTaint.addTaint(tagNumber);
        dsTaint.addTaint(type.dsTaint);
        {
            throw new IllegalArgumentException("Implicit tagging can not be used for ASN.1 ANY or CHOICE type");
        } //End block
        {
            boolean var7D16F4D21FCDA7B88995592766A30F11_1054940596 = (type.checkTag(type.id));
            {
                {
                    boolean var198894DB5720C5DF4565C2CB8C2924C0_1185645351 = (type.checkTag(type.constrId));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.636 -0400", hash_original_method = "D92B272BF30997E81DA1469852FE3C4F", hash_generated_method = "1E4AECED97C6C0AF239541339155B5D5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.637 -0400", hash_original_method = "7AB778F30F3F4E1DD4EDD8138709F383", hash_generated_method = "C4A26B5EE4834EA21303993D6AF24CEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object decode(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        {
            boolean var766EA6E7D31783D8197180D70708A15A_1747435192 = (!checkTag(in.tag));
            {
                throw new ASN1Exception("ASN.1 implicitly tagged type expected at " +
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
        Object var883E4A51D9FE1FCA5622395E00C94DE9_1139964896 = (getDecodedObject(in));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.637 -0400", hash_original_method = "5EC2F9C60EB654B91B6E1D4F997368F9", hash_generated_method = "F146BD007AB8080BB49BD9A3A144898C")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.637 -0400", hash_original_method = "774C00840199094903FD771E0305B5DA", hash_generated_method = "B810D6790A1B5575A976FA0595AE5D34")
    @DSModeled(DSC.SAFE)
    public void encodeContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        type.encodeContent(out);
        // ---------- Original Method ----------
        //type.encodeContent(out);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.637 -0400", hash_original_method = "142D84AECEAB554A6A5BF2DED12EF71F", hash_generated_method = "28B38CE23984A2CF3EDF740F85F51CEF")
    @DSModeled(DSC.SAFE)
    public void setEncodingContent(BerOutputStream out) {
        dsTaint.addTaint(out.dsTaint);
        type.setEncodingContent(out);
        // ---------- Original Method ----------
        //type.setEncodingContent(out);
    }

    
}


