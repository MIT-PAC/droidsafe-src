package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;






public final class ASN1Implicit extends ASN1Type {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:04.942 -0500", hash_original_field = "4AD535DC1B971D46F1B734137C7FE502", hash_generated_field = "FC708BB1AC854A91B7DCE6A8ABC2B9F8")

    private static final int TAGGING_PRIMITIVE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:04.943 -0500", hash_original_field = "CDAFF6D79D753F296F77E65550486011", hash_generated_field = "C4E8C04A9E28482ED140EBA565FF4791")

    private static final int TAGGING_CONSTRUCTED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:04.944 -0500", hash_original_field = "8490520834E633B0125E704BE97937E4", hash_generated_field = "198AE5437257AB4D73B54A6904A66837")

    private static final int TAGGING_STRING = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:04.945 -0500", hash_original_field = "43976773C1CAD6B63CB025EEFB3E3545", hash_generated_field = "97A5429C38872EFB5A45FC680B4DDEE1")

    private  ASN1Type type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:04.946 -0500", hash_original_field = "D32D1E58ADBAE3AA959F42184855E602", hash_generated_field = "5F27CEAB9F1A8FD006A951F92DDD6657")

    private  int taggingType;

    /**
     * Constructs implicitly tagged ASN.1 type
     * with context-specific tag class and specified tag number.
     *
     * @param tagNumber - ASN.1 tag number
     * @param type - ASN.1 type to be tagged
     * @throws IllegalArgumentException - if tagNumber or type is invalid
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:04.947 -0500", hash_original_method = "885EAD88CE0EDAA6AE8B231FCD302B70", hash_generated_method = "8D3182E73E386621BF2B58B3777AA340")
    public ASN1Implicit(int tagNumber, ASN1Type type) {
        super(CLASS_CONTEXTSPECIFIC, tagNumber);

        if ((type instanceof ASN1Choice) || (type instanceof ASN1Any)) {
            // According to X.680:
            // 'The IMPLICIT alternative shall not be used if the type
            // defined by "Type" is an untagged choice type or an
            // untagged open type'
            throw new IllegalArgumentException("Implicit tagging can not be used for ASN.1 ANY or CHOICE type");
        }

        this.type = type;

        if (type.checkTag(type.id)) {
            if (type.checkTag(type.constrId)) {
                // the base encoding can be primitive ot constructed
                // use both encodings
                taggingType = TAGGING_STRING;
            } else {
                // if the base encoding is primitive use primitive encoding
                taggingType = TAGGING_PRIMITIVE;
            }
        } else {
            // if the base encoding is constructed use constructed encoding
            taggingType = TAGGING_CONSTRUCTED;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:04.948 -0500", hash_original_method = "D92B272BF30997E81DA1469852FE3C4F", hash_generated_method = "CB7EC76978F4045220BAD2898C4C5DD5")
    public final boolean checkTag(int identifier) {
        switch (taggingType) {
        case TAGGING_PRIMITIVE:
            return id == identifier;
        case TAGGING_CONSTRUCTED:
            return constrId == identifier;
        default: // TAGGING_STRING
            return id == identifier || constrId == identifier;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:04.949 -0500", hash_original_method = "7AB778F30F3F4E1DD4EDD8138709F383", hash_generated_method = "8FF8EBA8C8218FDFE42B37B021066576")
    public Object decode(BerInputStream in) throws IOException {
        if (!checkTag(in.tag)) {
            // FIXME need look for tagging type
            throw new ASN1Exception("ASN.1 implicitly tagged type expected at " +
                    "[" + in.tagOffset + "]. Expected tag: " + Integer.toHexString(id) + ", " +
                    "but got " + Integer.toHexString(in.tag));
        }

        // substitute identifier for further decoding
        if (id == in.tag) {
            in.tag = type.id;
        } else {
            in.tag = type.constrId;
        }
        in.content = type.decode(in);

        if (in.isVerify) {
            return null;
        }
        return getDecodedObject(in);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:04.950 -0500", hash_original_method = "5EC2F9C60EB654B91B6E1D4F997368F9", hash_generated_method = "3DE35388263CB8572C0129A460F8A7AE")
    public void encodeASN(BerOutputStream out) {
        //FIXME need another way for specifying identifier to be encoded
        if (taggingType == TAGGING_CONSTRUCTED) {
            out.encodeTag(constrId);
        } else {
            out.encodeTag(id);
        }
        encodeContent(out);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:04.951 -0500", hash_original_method = "774C00840199094903FD771E0305B5DA", hash_generated_method = "9BF82B7909E7896809B0D2F7CAF5EF6B")
    public void encodeContent(BerOutputStream out) {
        type.encodeContent(out);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:04.951 -0500", hash_original_method = "142D84AECEAB554A6A5BF2DED12EF71F", hash_generated_method = "704B1343F6E9513417C3E1D1943893AB")
    public void setEncodingContent(BerOutputStream out) {
        type.setEncodingContent(out);
    }
}

