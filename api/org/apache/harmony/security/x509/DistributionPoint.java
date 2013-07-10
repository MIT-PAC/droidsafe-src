package org.apache.harmony.security.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import org.apache.harmony.security.asn1.ASN1Explicit;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

public final class DistributionPoint {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.814 -0400", hash_original_field = "D5E154C7A3634B6FC49AD3EE6A58CF84", hash_generated_field = "C80BD58F96027F5568A9D89DFE20A460")

    private DistributionPointName distributionPoint;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.814 -0400", hash_original_field = "4B6D4444B98D2F9EC20B3454F769C35F", hash_generated_field = "15CAF0231E353E577B26AEBC9840E3A7")

    private ReasonFlags reasons;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.814 -0400", hash_original_field = "4C60171FBC5640C7E45D0157BC73C382", hash_generated_field = "80F03F282731D31274AB80FABF52B38E")

    private GeneralNames cRLIssuer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.815 -0400", hash_original_method = "4418C7FD449AAB99CCC4CA119AA3884F", hash_generated_method = "9D38ADB21D9F1BD025805093FB948AAC")
    public  DistributionPoint(DistributionPointName distributionPoint,
            ReasonFlags reasons, GeneralNames cRLIssuer) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("DistributionPoint MUST NOT consist of only the reasons field");
        } 
        this.distributionPoint = distributionPoint;
        this.reasons = reasons;
        this.cRLIssuer = cRLIssuer;
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.815 -0400", hash_original_method = "190306EE5A9877A74E1ACB7BA25B44A2", hash_generated_method = "353A9694B0FAC3DC05887072FF6CE14C")
    public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix);
        sb.append("Distribution Point: [\n");
        {
            distributionPoint.dumpValue(sb, prefix + "  ");
        } 
        {
            reasons.dumpValue(sb, prefix + "  ");
        } 
        {
            sb.append(prefix);
            sb.append("  CRL Issuer: [\n");
            cRLIssuer.dumpValue(sb, prefix + "    ");
            sb.append(prefix);
            sb.append("  ]\n");
        } 
        sb.append(prefix);
        sb.append("]\n");
        addTaint(sb.getTaint());
        addTaint(prefix.getTaint());
        
        
        
        
            
        
        
            
        
        
            
            
            
            
            
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.815 -0400", hash_original_field = "D0D4FB4612A1D50FBE270F1BA985DAFD", hash_generated_field = "8675B31B16460D164F08080CE00E38A4")

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

        @Override protected Object getDecodedObject(BerInputStream in) throws IOException {
            Object[] values = (Object[]) in.content;
            return new DistributionPoint((DistributionPointName) values[0],
                    (ReasonFlags) values[1], (GeneralNames) values[2]);
        }

        @Override protected void getValues(Object object, Object[] values) {
            DistributionPoint dp = (DistributionPoint) object;
            values[0] = dp.distributionPoint;
            values[1] = dp.reasons;
            values[2] = dp.cRLIssuer;
        }
    };
    
}

