package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

public final class ASN1Any extends ASN1Type {

    /**
     * Returns ASN.1 ANY type default implementation
     *
     * The default implementation works with full encoding
     * that is represented as raw byte array.
     *
     * @return ASN.1 ANY type default implementation
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:51.217 -0500", hash_original_method = "72EDD098C295AB4E95999AD610D0BDCD", hash_generated_method = "BFB854D83DA446B398DD7AAA04879B61")
    
public static ASN1Any getInstance() {
        return ASN1;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:51.212 -0500", hash_original_field = "EDEB995B616AD39AD8C36D4BEDE2A577", hash_generated_field = "C58706DC2D33CE9466BC907D05FF43CF")

    private static final ASN1Any ASN1= new ASN1Any();

    /**
     * Constructs ASN.1 ANY type
     *
     * The constructor is provided for inheritance purposes
     * when there is a need to create a custom ASN.1 ANY type.
     * To get a default implementation it is recommended to use
     * getInstance() method.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:51.215 -0500", hash_original_method = "DC9940F4B091FD322F1F3A80DE5DA9F7", hash_generated_method = "DB9067BFFCD040D7590D1C209BF6EF7C")
    
public ASN1Any() {
        super(TAG_ANY); // has not tag number
    }

    /**
     * Tests provided identifier.
     *
     * @param identifier - identifier to be verified
     * @return - true
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:51.219 -0500", hash_original_method = "0A9787140DA63C802B73071FD0FF80EC", hash_generated_method = "849DA9BB92119DAC4BE7B4C2E0D80925")
    
public final boolean checkTag(int identifier) {
        return true; //all tags are OK
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:51.222 -0500", hash_original_method = "F8B6556748DA568C4BCDCD3BC4853721", hash_generated_method = "D3F7EC2EAF01CD33AEB1A20AEACF2B3D")
    
public Object decode(BerInputStream in) throws IOException {
        // only read content, doesn't check it
        in.readContent();

        if (in.isVerify) {
            return null;
        }
        return getDecodedObject(in);
    }

    /**
     * Extracts array of bytes that represents full encoding from BER input
     * stream.
     *
     * @param in BER input stream
     * @return array of bytes
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:51.224 -0500", hash_original_method = "7A8EAE0B0D15C25D8FE798817C72F0C1", hash_generated_method = "4CC008AE1262E230724FFD12B09E1197")
    
public Object getDecodedObject(BerInputStream in) throws IOException {
        byte[] bytesEncoded = new byte[in.offset - in.tagOffset];
        System.arraycopy(in.buffer, in.tagOffset, bytesEncoded, 0,
                bytesEncoded.length);
        return bytesEncoded;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:51.226 -0500", hash_original_method = "7511C9B0E36E939B1775FC9EA0F02F20", hash_generated_method = "8890A5AF8EB7CD856712E5560958DC84")
    
public void encodeASN(BerOutputStream out) {
        out.encodeANY();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:51.228 -0500", hash_original_method = "E4481BCA62553D7934DD52F370937ED4", hash_generated_method = "897B4C3279A668EB3A6A4D2B661AB65B")
    
public void encodeContent(BerOutputStream out) {
        out.encodeANY();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:51.231 -0500", hash_original_method = "9FE1E04620BBFE07A0C8F71EADD10582", hash_generated_method = "74427AC68000019C393865D49DAE53B9")
    
public void setEncodingContent(BerOutputStream out) {
        out.length = ((byte[]) out.content).length;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:51.233 -0500", hash_original_method = "4E35D9A00930BDC0DD7D3944E7329986", hash_generated_method = "9E073544271BA4933CFD9922B4805DB6")
    
public int getEncodedLength(BerOutputStream out) {
        return out.length;
    }
}

