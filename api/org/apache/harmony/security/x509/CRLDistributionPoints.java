package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;






public final class CRLDistributionPoints extends ExtensionValue {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:08.624 -0500", hash_original_method = "33FB7D6A2B0A75BE58C7076DC6C11F96", hash_generated_method = "FEBE709455336C78CBFB07C9D9F02301")
    public static CRLDistributionPoints decode(byte[] encoding) throws IOException {
        return (CRLDistributionPoints) ASN1.decode(encoding);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.859 -0400", hash_original_field = "62B1FBBD0D0E4A202BE41C11512F1F03", hash_generated_field = "102F29B1A82B7676F643B080296B8FC7")

    public static final ASN1Type ASN1 = new ASN1SequenceOf(DistributionPoint.ASN1) {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:08.626 -0500", hash_original_method = "D06E1CE033BD087162B8506B4922D4AC", hash_generated_method = "470333ADE22DE7B78F332B0556E471B4")
        @Override
public Object getDecodedObject(BerInputStream in) {
            return new CRLDistributionPoints((List<DistributionPoint>) in.content, in.getEncoded());
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:08.627 -0500", hash_original_method = "1B1D9906279467E5EA238A1FED425544", hash_generated_method = "09327B39B48E83579DE00714D3580663")
        @Override
public Collection<?> getValues(Object object) {
            CRLDistributionPoints dps = (CRLDistributionPoints) object;
            return dps.distributionPoints;
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:08.621 -0500", hash_original_field = "FDCE688D9BF0B525AAFD5656E5B36EF0", hash_generated_field = "A33A9FF005559B338B382EC4C32F0F90")

    private List<DistributionPoint> distributionPoints;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:08.621 -0500", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:08.623 -0500", hash_original_method = "A85C2ECCECA3DBD03B41866807FEA9E1", hash_generated_method = "C9079961F3DACEB65C3DDD9A62D25946")
    private CRLDistributionPoints(List<DistributionPoint> distributionPoints, byte[] encoding) {
        if ((distributionPoints == null) || (distributionPoints.size() == 0)) {
            throw new IllegalArgumentException("distributionPoints are empty");
        }
        this.distributionPoints = distributionPoints;
        this.encoding = encoding;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:08.623 -0500", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "552F71A862C62513AAC32037F4D2FC1B")
    @Override
public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1.encode(this);
        }
        return encoding;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:08.625 -0500", hash_original_method = "B23CB95A086DE744F33B5369D34A5985", hash_generated_method = "B70AD256691B633712529D48D0DBEFA7")
    @Override
public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("CRL Distribution Points: [\n");
        int number = 0;
        for (DistributionPoint distributionPoint : distributionPoints) {
            sb.append(prefix).append("  [").append(++number).append("]\n");
            distributionPoint.dumpValue(sb, prefix + "  ");
        }
        sb.append(prefix).append("]\n");
    }
}

