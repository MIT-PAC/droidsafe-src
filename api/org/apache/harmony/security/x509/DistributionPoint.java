package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import org.apache.harmony.security.asn1.ASN1Explicit;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;






public final class DistributionPoint {

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.056 -0400", hash_original_field = "D0D4FB4612A1D50FBE270F1BA985DAFD", hash_generated_field = "8675B31B16460D164F08080CE00E38A4")

    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
                new ASN1Explicit(0, DistributionPointName.ASN1),
                new ASN1Implicit(1, ReasonFlags.ASN1),
                new ASN1Implicit(2, GeneralNames.ASN1)
            }) {
        {
            setOptional(0);
            setOptional(1);
            setOptional(2);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.106 -0500", hash_original_method = "074F2887793442CCAD72B944F0DE7380", hash_generated_method = "BF35355F573F820D12174E439F03035F")
        
@Override protected Object getDecodedObject(BerInputStream in) throws IOException {
            Object[] values = (Object[]) in.content;
            return new DistributionPoint((DistributionPointName) values[0],
                    (ReasonFlags) values[1], (GeneralNames) values[2]);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.109 -0500", hash_original_method = "AF8B9866231B884FBF8029737DE63151", hash_generated_method = "2977FC4142F590FFC89E6EA9F5630603")
        
@Override protected void getValues(Object object, Object[] values) {
            DistributionPoint dp = (DistributionPoint) object;
            values[0] = dp.distributionPoint;
            values[1] = dp.reasons;
            values[2] = dp.cRLIssuer;
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.092 -0500", hash_original_field = "0C84BAD625229025752DA12A1FFF0D16", hash_generated_field = "C80BD58F96027F5568A9D89DFE20A460")

    private  DistributionPointName distributionPoint;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.095 -0500", hash_original_field = "D834928727C5680AF51B3D1B8C76113F", hash_generated_field = "15CAF0231E353E577B26AEBC9840E3A7")

    private  ReasonFlags reasons;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.097 -0500", hash_original_field = "29AF8450C39557CD3F0142458CACE979", hash_generated_field = "80F03F282731D31274AB80FABF52B38E")

    private  GeneralNames cRLIssuer;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.100 -0500", hash_original_method = "4418C7FD449AAB99CCC4CA119AA3884F", hash_generated_method = "EE322F85ADBA7D255068977B1CFE8F3D")
    
public DistributionPoint(DistributionPointName distributionPoint,
            ReasonFlags reasons, GeneralNames cRLIssuer) {
        if ((reasons != null) && (distributionPoint == null) && (cRLIssuer == null)) {
            throw new IllegalArgumentException("DistributionPoint MUST NOT consist of only the reasons field");
        }
        this.distributionPoint = distributionPoint;
        this.reasons = reasons;
        this.cRLIssuer = cRLIssuer;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.103 -0500", hash_original_method = "190306EE5A9877A74E1ACB7BA25B44A2", hash_generated_method = "7363A89488A26AAF143654B3CEAA3411")
    
public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix);
        sb.append("Distribution Point: [\n");
        if (distributionPoint != null) {
            distributionPoint.dumpValue(sb, prefix + "  ");
        }
        if (reasons != null) {
            reasons.dumpValue(sb, prefix + "  ");
        }
        if (cRLIssuer != null) {
            sb.append(prefix);
            sb.append("  CRL Issuer: [\n");
            cRLIssuer.dumpValue(sb, prefix + "    ");
            sb.append(prefix);
            sb.append("  ]\n");
        }
        sb.append(prefix);
        sb.append("]\n");
    }
}

