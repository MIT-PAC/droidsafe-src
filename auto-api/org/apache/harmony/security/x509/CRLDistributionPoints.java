package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

public final class CRLDistributionPoints extends ExtensionValue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.648 -0400", hash_original_field = "D9F0A7743229E8FD18F6BB254ADBE7DC", hash_generated_field = "A33A9FF005559B338B382EC4C32F0F90")

    private List<DistributionPoint> distributionPoints;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.648 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.648 -0400", hash_original_method = "A85C2ECCECA3DBD03B41866807FEA9E1", hash_generated_method = "5CF000876D127007D355FB736FF89A8B")
    private  CRLDistributionPoints(List<DistributionPoint> distributionPoints, byte[] encoding) {
        {
            boolean var4EEDCA0E173D416128A376D7BD123B90_724139566 = ((distributionPoints == null) || (distributionPoints.size() == 0));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("distributionPoints are empty");
            } //End block
        } //End collapsed parenthetic
        this.distributionPoints = distributionPoints;
        this.encoding = encoding;
        // ---------- Original Method ----------
        //if ((distributionPoints == null) || (distributionPoints.size() == 0)) {
            //throw new IllegalArgumentException("distributionPoints are empty");
        //}
        //this.distributionPoints = distributionPoints;
        //this.encoding = encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.649 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "5E6171C5BB7073F0EF5DE547E7A4D62F")
    @Override
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1647242937 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1647242937;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
    public static CRLDistributionPoints decode(byte[] encoding) throws IOException {
        return (CRLDistributionPoints) ASN1.decode(encoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.654 -0400", hash_original_method = "B23CB95A086DE744F33B5369D34A5985", hash_generated_method = "F2C3088DB91C7DF1F3029A15FB97BD64")
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("CRL Distribution Points: [\n");
        int number = 0;
        {
            Iterator<DistributionPoint> varAF1679FF82274DCE7918A81003D45FEE_242544666 = (distributionPoints).iterator();
            varAF1679FF82274DCE7918A81003D45FEE_242544666.hasNext();
            DistributionPoint distributionPoint = varAF1679FF82274DCE7918A81003D45FEE_242544666.next();
            {
                sb.append(prefix).append("  [").append(++number).append("]\n");
                distributionPoint.dumpValue(sb, prefix + "  ");
            } //End block
        } //End collapsed parenthetic
        sb.append(prefix).append("]\n");
        addTaint(sb.getTaint());
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
        //sb.append(prefix).append("CRL Distribution Points: [\n");
        //int number = 0;
        //for (DistributionPoint distributionPoint : distributionPoints) {
            //sb.append(prefix).append("  [").append(++number).append("]\n");
            //distributionPoint.dumpValue(sb, prefix + "  ");
        //}
        //sb.append(prefix).append("]\n");
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.654 -0400", hash_original_field = "62B1FBBD0D0E4A202BE41C11512F1F03", hash_generated_field = "102F29B1A82B7676F643B080296B8FC7")

    public static final ASN1Type ASN1 = new ASN1SequenceOf(DistributionPoint.ASN1) {
        @Override public Object getDecodedObject(BerInputStream in) {
            return new CRLDistributionPoints((List<DistributionPoint>) in.content, in.getEncoded());
        }

        @Override public Collection<?> getValues(Object object) {
            CRLDistributionPoints dps = (CRLDistributionPoints) object;
            return dps.distributionPoints;
        }
    };
    /*
    // orphaned legacy method
    @Override public Collection<?> getValues(Object object) {
            CRLDistributionPoints dps = (CRLDistributionPoints) object;
            return dps.distributionPoints;
        }
    
    // orphaned legacy method
    @Override public Object getDecodedObject(BerInputStream in) {
            return new CRLDistributionPoints((List<DistributionPoint>) in.content, in.getEncoded());
        }
    
    */
}

