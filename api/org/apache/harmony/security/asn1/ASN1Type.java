package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;

public abstract class ASN1Type implements ASN1Constants {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.019 -0500", hash_original_field = "53E65FEF28E32C7EDCD1B07B4F5A0DE3", hash_generated_field = "FA0A3841DE31A9B4AD2F31B3665056D8")

    public  int id;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.021 -0500", hash_original_field = "6C31E4EFA121929ACEC25FDE2929A843", hash_generated_field = "24E4DDF4395B1AE964B45B713C719F1F")

    public  int constrId;

    /**
     * Constructs a primitive, universal ASN.1 type.
     *
     * @param tagNumber - ASN.1 tag number
     * @throws IllegalArgumentException - if tagNumber is invalid
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.023 -0500", hash_original_method = "E753351671CF761070C01803DBBE0A73", hash_generated_method = "DC5DE3B8A7DFBC0B9DD97503F19F10EC")
    
public ASN1Type(int tagNumber) {
        this(CLASS_UNIVERSAL, tagNumber);
    }

    /**
     * Constructs an ASN.1 type.
     *
     * @param tagClass - tag class. MUST be
     *     CLASS_UNIVERSAL, CLASS_APPLICATION, CLASS_CONTEXTSPECIFIC, CLASS_PRIVATE
     * @param tagNumber - ASN.1 tag number.
     * @throws IllegalArgumentException - if tagClass or tagNumber is invalid
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.027 -0500", hash_original_method = "C924F9DEBC46E3FF1C759C2A69F62440", hash_generated_method = "FA5FB88919F35E462043CD8636FC3798")
    
public ASN1Type(int tagClass, int tagNumber) {
        if (tagNumber < 0) {
            throw new IllegalArgumentException("tagNumber < 0");
        }

        if (tagClass != CLASS_UNIVERSAL && tagClass != CLASS_APPLICATION
                && tagClass != CLASS_CONTEXTSPECIFIC
                && tagClass != CLASS_PRIVATE) {
            throw new IllegalArgumentException("invalid tagClass");
        }

        if (tagNumber < 31) {
            // short form
            this.id = tagClass + tagNumber;
        } else {
            // long form
            throw new IllegalArgumentException("tag long form not implemented");
        }
        this.constrId = this.id + PC_CONSTRUCTED;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.029 -0500", hash_original_method = "DD7F9B0A8E4884CD611E54C95FCD3DA3", hash_generated_method = "43CA87A37D26352F3F1C1C1A408EBCFA")
    
public final Object decode(byte[] encoded) throws IOException {
        return decode(new DerInputStream(encoded));
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.032 -0500", hash_original_method = "F94AEF08BB5C9E1C82DE4BF1B9366E55", hash_generated_method = "3DCD0C0AFF46A919107BDD870D07862C")
    
public final Object decode(byte[] encoded, int offset, int encodingLen)
            throws IOException {
        return decode(new DerInputStream(encoded, offset, encodingLen));
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.034 -0500", hash_original_method = "602847E19184C464832C69984B020DF7", hash_generated_method = "611576D661E8D5A1C77855D938480709")
    
public final Object decode(InputStream in) throws IOException {
        return decode(new DerInputStream(in));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.036 -0500", hash_original_method = "CCC5058B0D0F74ECE196C136FC714A4E", hash_generated_method = "6E1C9D4FA9E9C9F1CA534A716CAE0107")
    
public final void verify(byte[] encoded) throws IOException {
        DerInputStream decoder = new DerInputStream(encoded);
        decoder.setVerify();
        decode(decoder);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.039 -0500", hash_original_method = "8A3EDFD20917FC2A32E2E1C169001F91", hash_generated_method = "DF2A815465BF4C4AA5648C4044A93C8F")
    
public final void verify(InputStream in) throws IOException {
        DerInputStream decoder = new DerInputStream(in);
        decoder.setVerify();
        decode(decoder);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.041 -0500", hash_original_method = "53BC043E630E35D0E0B116BF28EF4348", hash_generated_method = "FC8C4208DE2E98C13E7C0E4CA10087C0")
    
public final byte[] encode(Object object) {
        DerOutputStream out = new DerOutputStream(this, object);
        return out.encoded;
    }

    /**
     * Decodes ASN.1 type.
     *
     * @throws IOException if an I/O error occurs or the end of the stream is reached
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.043 -0500", hash_original_method = "2BF9EDF995602912593F2BADCC2FB262", hash_generated_method = "8340A524EAFC4475065CF651D95D0FB0")
    
public abstract Object decode(BerInputStream in) throws IOException;

    /**
     * Tests provided identifier.
     *
     * @param identifier identifier to be verified
     * @return true if identifier is associated with this ASN.1 type
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.046 -0500", hash_original_method = "DB1E45BB7D9010E84CA0E83D419F0F1F", hash_generated_method = "233D7E7C5A8691427B110377CDA61967")
    
public abstract boolean checkTag(int identifier);

    /**
     * Creates decoded object.
     *
     * Derived classes should override this method to provide creation for a
     * selected class of objects during decoding.
     *
     * The default implementation returns an object created by decoding stream.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.049 -0500", hash_original_method = "C98349FCBC509D9B5E2186CE1C87C57F", hash_generated_method = "C4DBDC501064870C85035356B22A192C")
    
protected Object getDecodedObject(BerInputStream in) throws IOException {
        return in.content;
    }

    /**
     * Encodes ASN.1 type.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.051 -0500", hash_original_method = "F5A7290D617A6ED99139305203F0D02F", hash_generated_method = "A375005D7116F42D562C956B10E45037")
    
public abstract void encodeASN(BerOutputStream out);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.053 -0500", hash_original_method = "72AD4F4F20976790C60891D8DD85D9DD", hash_generated_method = "F73F1BB0618D47544CC22166099E9F31")
    
public abstract void encodeContent(BerOutputStream out);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.055 -0500", hash_original_method = "FA26F0316720109DDB7CB4D7ABA99A11", hash_generated_method = "1E9B6C8E331DF817941A77FB3D665F2A")
    
public abstract void setEncodingContent(BerOutputStream out);

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.058 -0500", hash_original_method = "FA7F24CC02CDE7C91DB883C7C7C15F71", hash_generated_method = "67E874CBB6BB6CADA52D130B2754A953")
    
public int getEncodedLength(BerOutputStream out) { //FIXME name
        //tag length
        int len = 1; //FIXME tag length = 1. what about long form?
        //for (; tag > 0; tag = tag >> 8, len++);

        // length length :-)
        len++;
        if (out.length > 127) {

            len++;
            for (int cur = out.length >> 8; cur > 0; len++) {
                cur = cur >> 8;
            }
        }
        len += out.length;

        return len;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:52.060 -0500", hash_original_method = "54C9519AE58EE8A367BF831B5FC731FF", hash_generated_method = "0944A0978714CD338D7E5A13830E66DA")
    
@Override public String toString() {
        // TODO decide whether this method is necessary
        return getClass().getName() + "(tag: 0x" + Integer.toHexString(0xff & this.id) + ")";
    }
    
}

