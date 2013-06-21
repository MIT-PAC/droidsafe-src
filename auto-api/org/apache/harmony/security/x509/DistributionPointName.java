package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import javax.security.auth.x500.X500Principal;
import org.apache.harmony.security.asn1.ASN1Choice;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.x501.Name;

public final class DistributionPointName {
    private GeneralNames fullName;
    private Name nameRelativeToCRLIssuer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.640 -0400", hash_original_method = "C8749F3ED2C366A9AA00695E66A37B12", hash_generated_method = "5E89203CEDB0DE2E37A9093884EDB15B")
    @DSModeled(DSC.SAFE)
    public DistributionPointName(GeneralNames fullName) {
        dsTaint.addTaint(fullName.dsTaint);
        this.nameRelativeToCRLIssuer = null;
        // ---------- Original Method ----------
        //this.fullName = fullName;
        //this.nameRelativeToCRLIssuer = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.640 -0400", hash_original_method = "1334C14C36DE89EB1519C775A1FE97BC", hash_generated_method = "49BF4CCF7F677B5C77F37B4172516C9D")
    @DSModeled(DSC.SAFE)
    public DistributionPointName(Name nameRelativeToCRLIssuer) {
        dsTaint.addTaint(nameRelativeToCRLIssuer.dsTaint);
        this.fullName = null;
        // ---------- Original Method ----------
        //this.fullName = null;
        //this.nameRelativeToCRLIssuer = nameRelativeToCRLIssuer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.640 -0400", hash_original_method = "F96CAEAAF8BF6CA887E583CF87D57244", hash_generated_method = "EF9A9633481D23D3CEEFB223FA2CA8C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dumpValue(StringBuilder sb, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(sb.dsTaint);
        sb.append(prefix);
        sb.append("Distribution Point Name: [\n");
        {
            fullName.dumpValue(sb, prefix + "  ");
        } //End block
        {
            sb.append(prefix);
            sb.append("  ");
            sb.append(nameRelativeToCRLIssuer.getName(X500Principal.RFC2253));
        } //End block
        sb.append(prefix);
        sb.append("]\n");
        // ---------- Original Method ----------
        //sb.append(prefix);
        //sb.append("Distribution Point Name: [\n");
        //if (fullName != null) {
            //fullName.dumpValue(sb, prefix + "  ");
        //} else {
            //sb.append(prefix);
            //sb.append("  ");
            //sb.append(nameRelativeToCRLIssuer.getName(X500Principal.RFC2253));
        //}
        //sb.append(prefix);
        //sb.append("]\n");
    }

    
    public static final ASN1Choice ASN1 = new ASN1Choice(new ASN1Type[] {
            new ASN1Implicit(0, GeneralNames.ASN1),
            new ASN1Implicit(1, Name.ASN1_RDN) }) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.640 -0400", hash_original_method = "4ADD70F157F255200F6C747F7A898124", hash_generated_method = "87E61C53ACC5A56D77531651D6EA96C2")
        @DSModeled(DSC.SAFE)
        public int getIndex(java.lang.Object object) {
            dsTaint.addTaint(object.dsTaint);
            DistributionPointName dpn;
            dpn = (DistributionPointName) object;
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //DistributionPointName dpn = (DistributionPointName) object;
            //return (dpn.fullName == null) ? 1 : 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.640 -0400", hash_original_method = "B70947C42A22D0E920DBED92C52DD304", hash_generated_method = "C3FB12004B3BA50546A6E27AB43B2CB9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected Object getDecodedObject(BerInputStream in) throws IOException {
            dsTaint.addTaint(in.dsTaint);
            DistributionPointName result;
            result = null;
            {
                result = new DistributionPointName((GeneralNames) in.content);
            } //End block
            {
                result = new DistributionPointName((Name) in.content);
            } //End block
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //DistributionPointName result = null;
            //if (in.choiceIndex == 0) {
                //result = new DistributionPointName((GeneralNames) in.content);
            //} else {
                //result = new DistributionPointName((Name) in.content);
            //}
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.641 -0400", hash_original_method = "BCC068DF66100A597C835FC62DF6AFA1", hash_generated_method = "3016F5FB6649B0A757E3B009B68A2B20")
        @DSModeled(DSC.SAFE)
        public Object getObjectToEncode(Object object) {
            dsTaint.addTaint(object.dsTaint);
            DistributionPointName dpn;
            dpn = (DistributionPointName) object;
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //DistributionPointName dpn = (DistributionPointName) object;
            //if (dpn.fullName == null) {
                //return dpn.nameRelativeToCRLIssuer;
            //} else {
                //return dpn.fullName;
            //}
        }

        
}; //Transformed anonymous class
}

