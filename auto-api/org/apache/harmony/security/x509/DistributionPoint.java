package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import org.apache.harmony.security.asn1.ASN1Explicit;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

public final class DistributionPoint {
    private DistributionPointName distributionPoint;
    private ReasonFlags reasons;
    private GeneralNames cRLIssuer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.637 -0400", hash_original_method = "4418C7FD449AAB99CCC4CA119AA3884F", hash_generated_method = "6AE14C44F16B89CA25D4E5872E6B17FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DistributionPoint(DistributionPointName distributionPoint,
            ReasonFlags reasons, GeneralNames cRLIssuer) {
        dsTaint.addTaint(cRLIssuer.dsTaint);
        dsTaint.addTaint(reasons.dsTaint);
        dsTaint.addTaint(distributionPoint.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("DistributionPoint MUST NOT consist of only the reasons field");
        } //End block
        // ---------- Original Method ----------
        //if ((reasons != null) && (distributionPoint == null) && (cRLIssuer == null)) {
            //throw new IllegalArgumentException("DistributionPoint MUST NOT consist of only the reasons field");
        //}
        //this.distributionPoint = distributionPoint;
        //this.reasons = reasons;
        //this.cRLIssuer = cRLIssuer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.637 -0400", hash_original_method = "190306EE5A9877A74E1ACB7BA25B44A2", hash_generated_method = "6199BA3F3FBBC6498C6E566F2C9D2CBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dumpValue(StringBuilder sb, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(sb.dsTaint);
        sb.append(prefix);
        sb.append("Distribution Point: [\n");
        {
            distributionPoint.dumpValue(sb, prefix + "  ");
        } //End block
        {
            reasons.dumpValue(sb, prefix + "  ");
        } //End block
        {
            sb.append(prefix);
            sb.append("  CRL Issuer: [\n");
            cRLIssuer.dumpValue(sb, prefix + "    ");
            sb.append(prefix);
            sb.append("  ]\n");
        } //End block
        sb.append(prefix);
        sb.append("]\n");
        // ---------- Original Method ----------
        //sb.append(prefix);
        //sb.append("Distribution Point: [\n");
        //if (distributionPoint != null) {
            //distributionPoint.dumpValue(sb, prefix + "  ");
        //}
        //if (reasons != null) {
            //reasons.dumpValue(sb, prefix + "  ");
        //}
        //if (cRLIssuer != null) {
            //sb.append(prefix);
            //sb.append("  CRL Issuer: [\n");
            //cRLIssuer.dumpValue(sb, prefix + "    ");
            //sb.append(prefix);
            //sb.append("  ]\n");
        //}
        //sb.append(prefix);
        //sb.append("]\n");
    }

    
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
                new ASN1Explicit(0, DistributionPointName.ASN1),
                new ASN1Implicit(1, ReasonFlags.ASN1),
                new ASN1Implicit(2, GeneralNames.ASN1)
            }) {        {
            setOptional(0);
            setOptional(1);
            setOptional(2);
        }
        
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.637 -0400", hash_original_method = "074F2887793442CCAD72B944F0DE7380", hash_generated_method = "7FC4E3697BAA6B3672AE8678A10A3DFC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected Object getDecodedObject(BerInputStream in) throws IOException {
            dsTaint.addTaint(in.dsTaint);
            Object[] values;
            values = (Object[]) in.content;
            Object varCCF14E3CF44B5D3F0B0E4F844072D7A6_1882464037 = (new DistributionPoint((DistributionPointName) values[0],
                    (ReasonFlags) values[1], (GeneralNames) values[2]));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Object[] values = (Object[]) in.content;
            //return new DistributionPoint((DistributionPointName) values[0],
                    //(ReasonFlags) values[1], (GeneralNames) values[2]);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.638 -0400", hash_original_method = "AF8B9866231B884FBF8029737DE63151", hash_generated_method = "6FA3F977BD9810FC72B2824751A0095A")
        @DSModeled(DSC.SAFE)
        @Override
        protected void getValues(Object object, Object[] values) {
            dsTaint.addTaint(values[0].dsTaint);
            dsTaint.addTaint(object.dsTaint);
            DistributionPoint dp;
            dp = (DistributionPoint) object;
            values[0] = dp.distributionPoint;
            values[1] = dp.reasons;
            values[2] = dp.cRLIssuer;
            // ---------- Original Method ----------
            //DistributionPoint dp = (DistributionPoint) object;
            //values[0] = dp.distributionPoint;
            //values[1] = dp.reasons;
            //values[2] = dp.cRLIssuer;
        }

        
}; //Transformed anonymous class
}

