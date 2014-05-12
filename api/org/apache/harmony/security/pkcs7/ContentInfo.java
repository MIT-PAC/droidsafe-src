package org.apache.harmony.security.pkcs7;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.Arrays;

import org.apache.harmony.security.asn1.ASN1Any;
import org.apache.harmony.security.asn1.ASN1Explicit;
import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

public final class ContentInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.576 -0500", hash_original_field = "A740757F63DAE1BC79955CF4744AA68C", hash_generated_field = "8428484335EE13FC1A9C1DBD7FDC9ECA")

    public static final int[] DATA = new int[] {1, 2, 840, 113549, 1, 7, 1};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.579 -0500", hash_original_field = "A0430CA8BDE4B6222BA5C1C17536315B", hash_generated_field = "FA9C6531E77BBE821FE5DE965089B375")

    public static final int[] SIGNED_DATA = new int[] {1, 2, 840, 113549, 1, 7, 2};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.581 -0500", hash_original_field = "FE83576023A655BB7B91451C8766914E", hash_generated_field = "24F7B5F6BDB9FBC78DB44F121268E140")

    public static final int[] ENVELOPED_DATA = new int[] {1, 2, 840, 113549, 1, 7, 3};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.584 -0500", hash_original_field = "75889A597ED1F95DBB960B76616BCD05", hash_generated_field = "38ED391A43FCCD8D6A3947862294E2EC")

    public static final int[] SIGNED_AND_ENVELOPED_DATA = new int[] {1, 2, 840, 113549, 1, 7, 4};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.586 -0500", hash_original_field = "188252CFA161BB38DACA0D7371C075DD", hash_generated_field = "4AD29642C1C078CDFAC13F47A3E7D115")

    public static final int[] DIGESTED_DATA = new int[] {1, 2, 840, 113549, 1, 7, 5};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.589 -0500", hash_original_field = "965E5CBECE2B8C88929B8A3226518570", hash_generated_field = "B1F89B25721EB22E3FF5E0B6E95B1CC0")

    public static final int[] ENCRYPTED_DATA = new int[] {1, 2, 840, 113549, 1, 7, 6};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.066 -0400", hash_original_field = "651ACAACA5E1FB5842E2299B54939FE0", hash_generated_field = "F23B93D964AE7E1B216DBFAE49082621")

    public static final ASN1Sequence ASN1 =
        new ASN1Sequence(new ASN1Type[] {
                ASN1Oid.getInstance(),
                new ASN1Explicit(0, ASN1Any.getInstance())
                })  {
        {
            setOptional(1); 
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.614 -0500", hash_original_method = "DE814BC7A3ADD369EC16BC4834AE1E64", hash_generated_method = "C113660524562970263E40508076D8FD")
        
@Override protected void getValues(Object object, Object[] values) {
            ContentInfo ci = (ContentInfo) object;
            values[0] = ci.oid;
            if (ci.content != null) {
                if (Arrays.equals(ci.oid, DATA)) {
                    if (ci.content != null) {
                        values[1] =
                            ASN1OctetString.getInstance().encode(ci.content);
                    }
                } else if (ci.content instanceof SignedData) {
                    values[1] = SignedData.ASN1.encode(ci.content);
                } else {
                    values[1] = ci.content;
                }
            }
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.617 -0500", hash_original_method = "C3EAC210669809D55F8F3014F8B268F8", hash_generated_method = "A186560C4C0ECEAFDA415CBD4E13E808")
        
@Override protected Object getDecodedObject(BerInputStream in) throws IOException {
            Object[] values = (Object[]) in.content;
            int[] oid = (int[]) values[0];
            if (Arrays.equals(oid, DATA)) {
                if (values[1] != null) {
                    return new ContentInfo(oid,
                            ASN1OctetString.getInstance().decode((byte[])values[1]),
                            in.getEncoded());
                }  else {
                    return new ContentInfo((int[])values[0], null,
                            in.getEncoded());
                }
            }
            if (Arrays.equals(oid, SIGNED_DATA)) {
                return new ContentInfo((int[])values[0],
                        SignedData.ASN1.decode((byte[])values[1]),
                        in.getEncoded());
            }
            return new ContentInfo((int[]) values[0], values[1], in.getEncoded());
        }
   };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.591 -0500", hash_original_field = "82C0B35B7B0E7EF1298A50C60DFA28D7", hash_generated_field = "282BA3ECCB824558DBD68D7EB102F89D")

    private  int[] oid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.593 -0500", hash_original_field = "D0B8E49E3D027D4128A52EE40E051281", hash_generated_field = "ACC0ED8FE681AE1F8700C32DE8F586D0")

    private  Object content;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.595 -0500", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.597 -0500", hash_original_method = "A1561DFF6C4CF564DBA671C7F4145BEE", hash_generated_method = "2D53BFCD606E91A649F4EFE52FC690F4")
    
private ContentInfo(int[] oid, Object content, byte[] encoding) {
        this.oid = oid;
        this.content = content;
        this.encoding = encoding;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.600 -0500", hash_original_method = "FEA779456A4B7718EE7D788C42FE9ED3", hash_generated_method = "027A8128D24ED86408795831DEADE1B2")
    
public SignedData getSignedData() {
        if (Arrays.equals(oid, SIGNED_DATA)) {
            return (SignedData)content;
        }
        return null;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.602 -0500", hash_original_method = "7EF6AE96CD0AADFF5C056ACE9B248CB2", hash_generated_method = "B9A49F5825DE0C7B86F8CB4D24962550")
    
public Object getContent() {
        return content;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.604 -0500", hash_original_method = "47E7DB6049BFBF7F7143C81AA2952707", hash_generated_method = "A78E53B54C978319513CDD9DE2099370")
    
public int[] getContentType() {
        return oid;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.607 -0500", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "B5771FB56FBD9A4A3EB8F14B7F0CC2FE")
    
public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1.encode(this);
        }
        // Note: this is internal object and can not be accessible from
        // public API, so encoding is not copied. The classes which use
        // this class should copy encoding before passing it out.
        return encoding;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:53.610 -0500", hash_original_method = "E27EF60D80B9BCE694BEF49083131D32", hash_generated_method = "ABA044D621D95AEC10AD8F5CAAB28A90")
    
@Override public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("==== ContentInfo:");
        res.append("\n== ContentType (OID): ");
        for (int i : oid) {
            res.append(i);
            res.append(' ');
        }
        res.append("\n== Content: ");
        if (content != null) {
            res.append("\n");
            res.append(content.toString());
        }
        res.append("\n== Content End");
        res.append("\n==== ContentInfo End\n");
        return res.toString();
    }
}

