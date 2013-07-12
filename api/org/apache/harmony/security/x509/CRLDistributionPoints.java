package org.apache.harmony.security.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

public final class CRLDistributionPoints extends ExtensionValue {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.711 -0400", hash_original_field = "D9F0A7743229E8FD18F6BB254ADBE7DC", hash_generated_field = "A33A9FF005559B338B382EC4C32F0F90")

    private List<DistributionPoint> distributionPoints;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.711 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.712 -0400", hash_original_method = "A85C2ECCECA3DBD03B41866807FEA9E1", hash_generated_method = "737164BFE82D613EA11657A734A4D50F")
    private  CRLDistributionPoints(List<DistributionPoint> distributionPoints, byte[] encoding) {
    if((distributionPoints == null) || (distributionPoints.size() == 0))        
        {
            IllegalArgumentException var1B9AD9E6F5E79754D67F06E5D8208F1D_29090467 = new IllegalArgumentException("distributionPoints are empty");
            var1B9AD9E6F5E79754D67F06E5D8208F1D_29090467.addTaint(taint);
            throw var1B9AD9E6F5E79754D67F06E5D8208F1D_29090467;
        } 
        this.distributionPoints = distributionPoints;
        this.encoding = encoding;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.712 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "AF8B399C2358A249AEF447C3C2E54D54")
    @Override
    public byte[] getEncoded() {
    if(encoding == null)        
        {
            encoding = ASN1.encode(this);
        } 
        byte[] var84BEA1F0FD2CE16F7E562A9F06EF03D3_961307500 = (encoding);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1378213013 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1378213013;
        
        
            
        
        
    }

    
        @DSModeled(DSC.SAFE)
    public static CRLDistributionPoints decode(byte[] encoding) throws IOException {
        return (CRLDistributionPoints) ASN1.decode(encoding);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.712 -0400", hash_original_method = "B23CB95A086DE744F33B5369D34A5985", hash_generated_method = "6058F2EA7A2DC16CC83419DF3C0D4730")
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(sb.getTaint());
        sb.append(prefix).append("CRL Distribution Points: [\n");
        int number = 0;
for(DistributionPoint distributionPoint : distributionPoints)
        {
            sb.append(prefix).append("  [").append(++number).append("]\n");
            distributionPoint.dumpValue(sb, prefix + "  ");
        } 
        sb.append(prefix).append("]\n");
        
        
        
        
            
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.712 -0400", hash_original_field = "62B1FBBD0D0E4A202BE41C11512F1F03", hash_generated_field = "102F29B1A82B7676F643B080296B8FC7")

    public static final ASN1Type ASN1 = new ASN1SequenceOf(DistributionPoint.ASN1) {
        @Override public Object getDecodedObject(BerInputStream in) {
            return new CRLDistributionPoints((List<DistributionPoint>) in.content, in.getEncoded());
        }

        @Override public Collection<?> getValues(Object object) {
            CRLDistributionPoints dps = (CRLDistributionPoints) object;
            return dps.distributionPoints;
        }
    };
}

