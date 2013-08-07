package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;

import javax.security.auth.x500.X500Principal;

import org.apache.harmony.security.asn1.ASN1Choice;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.x501.Name;






public final class DistributionPointName {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.064 -0400", hash_original_field = "A0FBF479272CD38C220FBF726678D8D6", hash_generated_field = "061E1717D22D5F90C362F821A43FEE15")

    private GeneralNames fullName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.064 -0400", hash_original_field = "4206014622C8405215B7086E2746FCFB", hash_generated_field = "DED85562F3718D1D7502F022A1C659E2")

    private Name nameRelativeToCRLIssuer;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.065 -0400", hash_original_method = "C8749F3ED2C366A9AA00695E66A37B12", hash_generated_method = "1B48298FDCF9464F19CF22C34C0AFDA7")
    public  DistributionPointName(GeneralNames fullName) {
        this.fullName = fullName;
        this.nameRelativeToCRLIssuer = null;
        // ---------- Original Method ----------
        //this.fullName = fullName;
        //this.nameRelativeToCRLIssuer = null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.066 -0400", hash_original_method = "1334C14C36DE89EB1519C775A1FE97BC", hash_generated_method = "97CE1DD7E87A43A8C11B166000B40E4F")
    public  DistributionPointName(Name nameRelativeToCRLIssuer) {
        this.fullName = null;
        this.nameRelativeToCRLIssuer = nameRelativeToCRLIssuer;
        // ---------- Original Method ----------
        //this.fullName = null;
        //this.nameRelativeToCRLIssuer = nameRelativeToCRLIssuer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.067 -0400", hash_original_method = "F96CAEAAF8BF6CA887E583CF87D57244", hash_generated_method = "6EAC9FA76003CD923B56DCABF994AAC2")
    public void dumpValue(StringBuilder sb, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(sb.getTaint());
        sb.append(prefix);
        sb.append("Distribution Point Name: [\n");
        if(fullName != null)        
        {
            fullName.dumpValue(sb, prefix + "  ");
        } //End block
        else
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.067 -0400", hash_original_field = "6AB95919FF6969F19A1F57D938CE073E", hash_generated_field = "E1D3EB61AA41EF10FB1A477FAFE3C6A4")

    public static final ASN1Choice ASN1 = new ASN1Choice(new ASN1Type[] {
            new ASN1Implicit(0, GeneralNames.ASN1),
            new ASN1Implicit(1, Name.ASN1_RDN) }) {

        public int getIndex(java.lang.Object object) {
            DistributionPointName dpn = (DistributionPointName) object;
            return (dpn.fullName == null) ? 1 : 0;
        }

        @Override protected Object getDecodedObject(BerInputStream in) throws IOException {
            DistributionPointName result = null;
            if (in.choiceIndex == 0) {
                result = new DistributionPointName((GeneralNames) in.content);
            } else {
                
                
                result = new DistributionPointName((Name) in.content);
            }
            return result;
        }

        public Object getObjectToEncode(Object object) {
            DistributionPointName dpn = (DistributionPointName) object;
            if (dpn.fullName == null) {
                return dpn.nameRelativeToCRLIssuer;
            } else {
                return dpn.fullName;
            }
        }
    };
    // orphaned legacy method
    public int getIndex(java.lang.Object object) {
            DistributionPointName dpn = (DistributionPointName) object;
            return (dpn.fullName == null) ? 1 : 0;
        }
    
    // orphaned legacy method
    public Object getObjectToEncode(Object object) {
            DistributionPointName dpn = (DistributionPointName) object;
            if (dpn.fullName == null) {
                return dpn.nameRelativeToCRLIssuer;
            } else {
                return dpn.fullName;
            }
        }
    
}

