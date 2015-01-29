package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import javax.security.auth.x500.X500Principal;

import org.apache.harmony.security.asn1.ASN1Choice;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.x501.Name;

public final class DistributionPointName {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.067 -0400", hash_original_field = "6AB95919FF6969F19A1F57D938CE073E", hash_generated_field = "E1D3EB61AA41EF10FB1A477FAFE3C6A4")

    public static final ASN1Choice ASN1 = new ASN1Choice(new ASN1Type[] {
            new ASN1Implicit(0, GeneralNames.ASN1),
            new ASN1Implicit(1, Name.ASN1_RDN) }) {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.216 -0500", hash_original_method = "4ADD70F157F255200F6C747F7A898124", hash_generated_method = "0E134A55580CAB94899FECC142A80E04")
        
public int getIndex(java.lang.Object object) {
            DistributionPointName dpn = (DistributionPointName) object;
            return (dpn.fullName == null) ? 1 : 0;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.219 -0500", hash_original_method = "B70947C42A22D0E920DBED92C52DD304", hash_generated_method = "978DB3CF9D8D4F4B618C4CD99A928895")
        
@Override protected Object getDecodedObject(BerInputStream in) throws IOException {
            DistributionPointName result = null;
            if (in.choiceIndex == 0) {
                result = new DistributionPointName((GeneralNames) in.content);
            } else {
                // note: ASN.1 decoder will report an error if index
                // is neither 0 or 1
                result = new DistributionPointName((Name) in.content);
            }
            return result;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.222 -0500", hash_original_method = "BCC068DF66100A597C835FC62DF6AFA1", hash_generated_method = "0627774CAAA840FA87FCE90359A4F9C2")
        
public Object getObjectToEncode(Object object) {
            DistributionPointName dpn = (DistributionPointName) object;
            if (dpn.fullName == null) {
                return dpn.nameRelativeToCRLIssuer;
            } else {
                return dpn.fullName;
            }
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.203 -0500", hash_original_field = "9B152F246A4AAFC2DB1D024EF2381C03", hash_generated_field = "061E1717D22D5F90C362F821A43FEE15")

    private  GeneralNames fullName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.205 -0500", hash_original_field = "C1382DF76210C85997F51C82ADECD622", hash_generated_field = "DED85562F3718D1D7502F022A1C659E2")

    private  Name nameRelativeToCRLIssuer;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.208 -0500", hash_original_method = "C8749F3ED2C366A9AA00695E66A37B12", hash_generated_method = "DAD4497D53C94E6128C960E657C96D9D")
    
public DistributionPointName(GeneralNames fullName) {
        this.fullName = fullName;
        this.nameRelativeToCRLIssuer = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.210 -0500", hash_original_method = "1334C14C36DE89EB1519C775A1FE97BC", hash_generated_method = "F44BA730216A8E8C8DD1C25F611BA3D0")
    
public DistributionPointName(Name nameRelativeToCRLIssuer) {
        this.fullName = null;
        this.nameRelativeToCRLIssuer = nameRelativeToCRLIssuer;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:58.213 -0500", hash_original_method = "F96CAEAAF8BF6CA887E583CF87D57244", hash_generated_method = "DCB5BF0C860615A312844CC7823C8602")
    
public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix);
        sb.append("Distribution Point Name: [\n");
        if (fullName != null) {
            fullName.dumpValue(sb, prefix + "  ");
        } else {
            sb.append(prefix);
            sb.append("  ");
            sb.append(nameRelativeToCRLIssuer.getName(X500Principal.RFC2253));
        }
        sb.append(prefix);
        sb.append("]\n");
    }
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

