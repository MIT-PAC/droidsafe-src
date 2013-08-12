package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.ObjectIdentifier;






public final class AccessDescription {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.764 -0400", hash_original_field = "EFF2DC7FD3790EE08D45FB31BBFAC94C", hash_generated_field = "248BF95BB7065D90F1AFE45C45CFFDF8")

    private String accessMethod;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.765 -0400", hash_original_field = "18F94A753109C9CBA06E02833A786B81", hash_generated_field = "B893404BBB8A0BF472D8CE3A64890544")

    private GeneralName accessLocation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.765 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.766 -0400", hash_original_method = "FB49FC0C1C39F6A3E5A7CF2545478BA4", hash_generated_method = "2DC2B4F5F853BD382B1E8F46D351C1FF")
    private  AccessDescription(String accessMethod, GeneralName accessLocation, byte[] encoding) {
        this.accessMethod = accessMethod;
        this.accessLocation = accessLocation;
        this.encoding = encoding;
        // ---------- Original Method ----------
        //this.accessMethod = accessMethod;
        //this.accessLocation = accessLocation;
        //this.encoding = encoding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.766 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "FCA4D426AB06D8E9C5597FB2E1DB66F9")
    public byte[] getEncoded() {
        if(encoding == null)        
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] var84BEA1F0FD2CE16F7E562A9F06EF03D3_1274336689 = (encoding);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2116432882 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2116432882;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.767 -0400", hash_original_method = "4D59D0B3E432FF02219BDDB6D479EFFA", hash_generated_method = "4AFB9D4E6124FBAAF7C75769743AF2D4")
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("\n-- AccessDescription:");
        res.append("\naccessMethod:  ");
        res.append(accessMethod);
        res.append("\naccessLocation:  ");
        res.append(accessLocation);
        res.append("\n-- AccessDescription END\n");
String varEC7EB75EF3C7FA633C54FC66A0358174_1188307960 =         res.toString();
        varEC7EB75EF3C7FA633C54FC66A0358174_1188307960.addTaint(taint);
        return varEC7EB75EF3C7FA633C54FC66A0358174_1188307960;
        // ---------- Original Method ----------
        //StringBuilder res = new StringBuilder();
        //res.append("\n-- AccessDescription:");
        //res.append("\naccessMethod:  ");
        //res.append(accessMethod);
        //res.append("\naccessLocation:  ");
        //res.append(accessLocation);
        //res.append("\n-- AccessDescription END\n");
        //return res.toString();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.767 -0400", hash_original_field = "0862F44506F85070A10D10975AA6FE0E", hash_generated_field = "FF02B80E4F6E40830B394661F3CF20D9")

    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            ASN1Oid.getInstance(),
            GeneralName.ASN1 }) {

        @DSModeled(DSC.BAN)
        @Override protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;
            return new AccessDescription(
                    ObjectIdentifier.toString((int[]) values[0]),
                    (GeneralName) values[1], in.getEncoded());
        }

        @DSModeled(DSC.SAFE)
        @Override protected void getValues(Object object, Object[] values) {
            AccessDescription ad = (AccessDescription) object;
            values[0] = ObjectIdentifier.toIntArray(ad.accessMethod);
            values[1] = ad.accessLocation;
        }
    };
}

