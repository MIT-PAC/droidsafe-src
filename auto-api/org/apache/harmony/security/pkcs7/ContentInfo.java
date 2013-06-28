package org.apache.harmony.security.pkcs7;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.003 -0400", hash_original_field = "130F43112BB8A7A7790EBFC08EE9D6AF", hash_generated_field = "282BA3ECCB824558DBD68D7EB102F89D")

    private int[] oid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.003 -0400", hash_original_field = "9A0364B9E99BB480DD25E1F0284C8555", hash_generated_field = "ACC0ED8FE681AE1F8700C32DE8F586D0")

    private Object content;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.003 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.003 -0400", hash_original_method = "A1561DFF6C4CF564DBA671C7F4145BEE", hash_generated_method = "9710DC774A2005F19FDD1CDA7D15121F")
    private  ContentInfo(int[] oid, Object content, byte[] encoding) {
        this.oid = oid;
        this.content = content;
        this.encoding = encoding;
        // ---------- Original Method ----------
        //this.oid = oid;
        //this.content = content;
        //this.encoding = encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.004 -0400", hash_original_method = "FEA779456A4B7718EE7D788C42FE9ED3", hash_generated_method = "F02B91CD87855DE2C1233A458FA29311")
    public SignedData getSignedData() {
        SignedData varB4EAC82CA7396A68D541C85D26508E83_1639199186 = null; //Variable for return #1
        SignedData varB4EAC82CA7396A68D541C85D26508E83_1325025734 = null; //Variable for return #2
        {
            boolean var39A0E72567E8CA5BEA10BAB9AB37B8BD_168584930 = (Arrays.equals(oid, SIGNED_DATA));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1639199186 = (SignedData)content;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1325025734 = null;
        SignedData varA7E53CE21691AB073D9660D615818899_96937152; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_96937152 = varB4EAC82CA7396A68D541C85D26508E83_1639199186;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_96937152 = varB4EAC82CA7396A68D541C85D26508E83_1325025734;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_96937152.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_96937152;
        // ---------- Original Method ----------
        //if (Arrays.equals(oid, SIGNED_DATA)) {
            //return (SignedData)content;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.004 -0400", hash_original_method = "7EF6AE96CD0AADFF5C056ACE9B248CB2", hash_generated_method = "AAF59A4502F1C29327C2A83DA655190C")
    public Object getContent() {
        Object varB4EAC82CA7396A68D541C85D26508E83_246558695 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_246558695 = content;
        varB4EAC82CA7396A68D541C85D26508E83_246558695.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_246558695;
        // ---------- Original Method ----------
        //return content;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.004 -0400", hash_original_method = "47E7DB6049BFBF7F7143C81AA2952707", hash_generated_method = "3C5CAC81A0F918752C5C0157F5A29B7C")
    public int[] getContentType() {
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_128525407 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_128525407;
        // ---------- Original Method ----------
        //return oid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.005 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "96DF9229AC5F8417C17ECC7DC3BBC285")
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_841856256 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_841856256;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.010 -0400", hash_original_method = "E27EF60D80B9BCE694BEF49083131D32", hash_generated_method = "1621184D048F8043768DAFD096AAD7AD")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_972011803 = null; //Variable for return #1
        StringBuilder res = new StringBuilder();
        res.append("==== ContentInfo:");
        res.append("\n== ContentType (OID): ");
        {
            int i = oid[0];
            {
                res.append(i);
                res.append(' ');
            } //End block
        } //End collapsed parenthetic
        res.append("\n== Content: ");
        {
            res.append("\n");
            res.append(content.toString());
        } //End block
        res.append("\n== Content End");
        res.append("\n==== ContentInfo End\n");
        varB4EAC82CA7396A68D541C85D26508E83_972011803 = res.toString();
        varB4EAC82CA7396A68D541C85D26508E83_972011803.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_972011803;
        // ---------- Original Method ----------
        //StringBuilder res = new StringBuilder();
        //res.append("==== ContentInfo:");
        //res.append("\n== ContentType (OID): ");
        //for (int i : oid) {
            //res.append(i);
            //res.append(' ');
        //}
        //res.append("\n== Content: ");
        //if (content != null) {
            //res.append("\n");
            //res.append(content.toString());
        //}
        //res.append("\n== Content End");
        //res.append("\n==== ContentInfo End\n");
        //return res.toString();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.010 -0400", hash_original_field = "EC0B0867ECF016032CB3911730FBEC9A", hash_generated_field = "8428484335EE13FC1A9C1DBD7FDC9ECA")

    public static final int[] DATA = new int[] {1, 2, 840, 113549, 1, 7, 1};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.010 -0400", hash_original_field = "B251F00B738E5A8881347B5C1C958A0C", hash_generated_field = "FA9C6531E77BBE821FE5DE965089B375")

    public static final int[] SIGNED_DATA = new int[] {1, 2, 840, 113549, 1, 7, 2};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.010 -0400", hash_original_field = "43396B3BE64AAC4ADEFCE307B0DFAA0C", hash_generated_field = "24F7B5F6BDB9FBC78DB44F121268E140")

    public static final int[] ENVELOPED_DATA = new int[] {1, 2, 840, 113549, 1, 7, 3};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.010 -0400", hash_original_field = "2A77812730AB5F116058C7041138617B", hash_generated_field = "38ED391A43FCCD8D6A3947862294E2EC")

    public static final int[] SIGNED_AND_ENVELOPED_DATA = new int[] {1, 2, 840, 113549, 1, 7, 4};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.010 -0400", hash_original_field = "7BC9A46C38EDFFBD6DAE766D090376AD", hash_generated_field = "4AD29642C1C078CDFAC13F47A3E7D115")

    public static final int[] DIGESTED_DATA = new int[] {1, 2, 840, 113549, 1, 7, 5};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.010 -0400", hash_original_field = "65669469762ABBDD8810B8D46F8790D0", hash_generated_field = "B1F89B25721EB22E3FF5E0B6E95B1CC0")

    public static final int[] ENCRYPTED_DATA = new int[] {1, 2, 840, 113549, 1, 7, 6};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.011 -0400", hash_original_field = "651ACAACA5E1FB5842E2299B54939FE0", hash_generated_field = "F23B93D964AE7E1B216DBFAE49082621")

    public static final ASN1Sequence ASN1 =
        new ASN1Sequence(new ASN1Type[] {
                ASN1Oid.getInstance(),
                new ASN1Explicit(0, ASN1Any.getInstance())
                })  {
        {
            setOptional(1); 
        }

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
    // orphaned legacy method
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
    
    // orphaned legacy method
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
    
}

