package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;






public final class ASN1Explicit extends ASN1Constructed {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:05.031 -0500", hash_original_field = "43976773C1CAD6B63CB025EEFB3E3545", hash_generated_field = "AC7D2E3EF11E777F80843D5021489F8A")

    public  ASN1Type type;

    /**
     * Constructs explicitly tagged ASN.1 type
     * with context-specific tag class and specified tag number.
     *
     * @param tagNumber - ASN.1 tag number
     * @param type - ASN.1 type to be tagged
     * @throws IllegalArgumentException - if tagNumber is invalid
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:05.032 -0500", hash_original_method = "B0F7BA820AB1A580DEB9F8D4C1B1D195", hash_generated_method = "74CEF01EFCEB89A48790756BCFEDB2B2")
    public ASN1Explicit(int tagNumber, ASN1Type type) {
        this(CLASS_CONTEXTSPECIFIC, tagNumber, type);
    }

    /**
     * Constructs explicitly tagged ASN.1 type.
     *
     * @param tagClass - ASN.1 tag class.
     * @param tagNumber - ASN.1 tag number
     * @param type - ASN.1 type to be tagged
     * @throws IllegalArgumentException - if tagClass or tagNumber is invalid
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:05.033 -0500", hash_original_method = "3F0FA66BFD46DABED8E86D16322A75CE", hash_generated_method = "701D86AC4DBB869E695FC393A13EE22A")
    public ASN1Explicit(int tagClass, int tagNumber, ASN1Type type) {
        super(tagClass, tagNumber);
        this.type = type;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:05.035 -0500", hash_original_method = "BF5194A9A90A1C345CA0C933EC20C89E", hash_generated_method = "20DB4555C096AC384567D24D9A7E06F0")
    public Object decode(BerInputStream in) throws IOException {
        if (constrId != in.tag) {
            throw new ASN1Exception("ASN.1 explicitly tagged type is expected at [" +
                    in.tagOffset + "]. Expected tag: " + Integer.toHexString(constrId) + ", " +
                    "but encountered tag " + Integer.toHexString(in.tag));
        }
        in.next();

        in.content = type.decode(in);

        if (in.isVerify) {
            return null;
        }
        return getDecodedObject(in);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:05.036 -0500", hash_original_method = "185B9650CC00F76A6008982D1539FA31", hash_generated_method = "889DD71F60A2F60CBE5A637C85F34DE2")
    public void encodeContent(BerOutputStream out) {
        out.encodeExplicit(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:05.037 -0500", hash_original_method = "8EE64F8332C91721514C0E16F4A7E840", hash_generated_method = "4614AFC8BE55D7627A8EF1B4196E26CB")
    public void setEncodingContent(BerOutputStream out) {
        out.getExplicitLength(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:05.038 -0500", hash_original_method = "8627A6334FE9B6784BD6CB87A9255671", hash_generated_method = "4A13F8FDE2FBA31C6A8C0A1F177EFB49")
    @Override
public String toString() {
        return super.toString() + " for type " + type;
    }

    
}

