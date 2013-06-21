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
    private List<DistributionPoint> distributionPoints;
    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.554 -0400", hash_original_method = "A85C2ECCECA3DBD03B41866807FEA9E1", hash_generated_method = "D876D287D9CFB25A252CA45C8BB42729")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CRLDistributionPoints(List<DistributionPoint> distributionPoints, byte[] encoding) {
        dsTaint.addTaint(encoding[0]);
        dsTaint.addTaint(distributionPoints.dsTaint);
        {
            boolean var4EEDCA0E173D416128A376D7BD123B90_1301632339 = ((distributionPoints == null) || (distributionPoints.size() == 0));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("distributionPoints are empty");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if ((distributionPoints == null) || (distributionPoints.size() == 0)) {
            //throw new IllegalArgumentException("distributionPoints are empty");
        //}
        //this.distributionPoints = distributionPoints;
        //this.encoding = encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.555 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "07B62BEE8032AB4E194FDF661E084439")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
        public static CRLDistributionPoints decode(byte[] encoding) throws IOException {
        return (CRLDistributionPoints) ASN1.decode(encoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.558 -0400", hash_original_method = "B23CB95A086DE744F33B5369D34A5985", hash_generated_method = "A4C697E915252094F759B8747F97F32C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(sb.dsTaint);
        sb.append(prefix).append("CRL Distribution Points: [\n");
        int number;
        number = 0;
        {
            Iterator<DistributionPoint> varAF1679FF82274DCE7918A81003D45FEE_416677659 = (distributionPoints).iterator();
            varAF1679FF82274DCE7918A81003D45FEE_416677659.hasNext();
            DistributionPoint distributionPoint = varAF1679FF82274DCE7918A81003D45FEE_416677659.next();
            {
                sb.append(prefix).append("  [").append(++number).append("]\n");
                distributionPoint.dumpValue(sb, prefix + "  ");
            } //End block
        } //End collapsed parenthetic
        sb.append(prefix).append("]\n");
        // ---------- Original Method ----------
        //sb.append(prefix).append("CRL Distribution Points: [\n");
        //int number = 0;
        //for (DistributionPoint distributionPoint : distributionPoints) {
            //sb.append(prefix).append("  [").append(++number).append("]\n");
            //distributionPoint.dumpValue(sb, prefix + "  ");
        //}
        //sb.append(prefix).append("]\n");
    }

    
    public static final ASN1Type ASN1 = new ASN1SequenceOf(DistributionPoint.ASN1) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.558 -0400", hash_original_method = "D06E1CE033BD087162B8506B4922D4AC", hash_generated_method = "97C8ACDB6F59C0D6EC44F240633ECAE1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object getDecodedObject(BerInputStream in) {
            dsTaint.addTaint(in.dsTaint);
            Object var78D1E044DBD106DC1E735F2BC6ABF77E_396541583 = (new CRLDistributionPoints((List<DistributionPoint>) in.content, in.getEncoded()));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CRLDistributionPoints((List<DistributionPoint>) in.content, in.getEncoded());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.559 -0400", hash_original_method = "1B1D9906279467E5EA238A1FED425544", hash_generated_method = "864004F84F4263752E1740E8592203A9")
        @DSModeled(DSC.SAFE)
        @Override
        public Collection<?> getValues(Object object) {
            dsTaint.addTaint(object.dsTaint);
            CRLDistributionPoints dps;
            dps = (CRLDistributionPoints) object;
            return (Collection<?>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //CRLDistributionPoints dps = (CRLDistributionPoints) object;
            //return dps.distributionPoints;
        }

        
}; //Transformed anonymous class
}

