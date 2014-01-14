package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

public final class NameConstraints extends ExtensionValue {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.689 -0500", hash_original_method = "8FB61ACD8CD827383570A2AA532D86A2", hash_generated_method = "D78A5D93A24288B0659C0170186DE635")
    
public static NameConstraints decode(byte[] encoding) throws IOException {
        return (NameConstraints) ASN1.decode(encoding);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.547 -0400", hash_original_field = "0F2F0693D95F2402F86C3A5B6E0E575B", hash_generated_field = "B4D47106C6BA5DC8C2956CCE475720F8")

    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            new ASN1Implicit(0, GeneralSubtrees.ASN1),
            new ASN1Implicit(1, GeneralSubtrees.ASN1) }) {
        {
            setOptional(0);
            setOptional(1);
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.709 -0500", hash_original_method = "615B46BCF08688AF9BAEA542A898E560", hash_generated_method = "C5D66E25BE23E183811BA60FFFF77F65")
        
@Override protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;
            return new NameConstraints(
                    (GeneralSubtrees) values[0],
                    (GeneralSubtrees) values[1],
                    in.getEncoded());
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.712 -0500", hash_original_method = "EC8305ECC6356BE2CBB8F5C68E732D9B", hash_generated_method = "FD7923CE44E59D984A12F92A0D453113")
        
@Override protected void getValues(Object object, Object[] values) {
            NameConstraints nc = (NameConstraints) object;
            values[0] = nc.permittedSubtrees;
            values[1] = nc.excludedSubtrees;
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.672 -0500", hash_original_field = "A0C2D198472595763DD8DFE4EB4C7E30", hash_generated_field = "7C183FAE1C4A852E4C170F871CE896DE")

    private  GeneralSubtrees permittedSubtrees;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.675 -0500", hash_original_field = "309D033E6A705CC5C6CAD1FC1960859C", hash_generated_field = "842C7367D24623D67CDB9CF5EDD53468")

    private  GeneralSubtrees excludedSubtrees;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.677 -0500", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.679 -0500", hash_original_field = "AEEFF51808C2177A9BE613D0564D8141", hash_generated_field = "8E1781FAED2BE993CB5C76415843F294")

    private ArrayList<GeneralName>[] permitted_names;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.681 -0500", hash_original_field = "CEFFB92DCC6D431329E5888981B48D49", hash_generated_field = "E0D2B3769B023B270B4E969DD11C5AF9")

    private ArrayList<GeneralName>[] excluded_names;

    /**
     * Constructs <code>NameConstrains</code> object
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.684 -0500", hash_original_method = "22A7E7A2EB4ADA3B586F576057F0955D", hash_generated_method = "6568B9421DB93C92E67BDD4B90F5EF6A")
    
public NameConstraints(GeneralSubtrees permittedSubtrees,
                           GeneralSubtrees excludedSubtrees) {
        if (permittedSubtrees != null) {
            List<GeneralSubtree> ps = permittedSubtrees.getSubtrees();
            if (ps == null || ps.isEmpty()) {
                throw new IllegalArgumentException("permittedSubtrees are empty");
            }
        }
        if (excludedSubtrees != null) {
            List<GeneralSubtree> es = excludedSubtrees.getSubtrees();
            if (es == null || es.isEmpty()) {
                throw new IllegalArgumentException("excludedSubtrees are empty");
            }
        }
        this.permittedSubtrees = permittedSubtrees;
        this.excludedSubtrees = excludedSubtrees;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.687 -0500", hash_original_method = "0B4FF50B5EED3F81B51F891413D3BBDC", hash_generated_method = "2B50100466BA363732912791603D553D")
    
private NameConstraints(GeneralSubtrees permittedSubtrees,
                            GeneralSubtrees excludedSubtrees, byte[] encoding) {
        this(permittedSubtrees, excludedSubtrees);
        this.encoding = encoding;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.692 -0500", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "552F71A862C62513AAC32037F4D2FC1B")
    
@Override public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1.encode(this);
        }
        return encoding;
    }

    /**
     * Prepare the data structure to speed up the checking process.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.694 -0500", hash_original_method = "D5B90ECD7CBCC97B9564754E474A01DA", hash_generated_method = "4BE7314064592CE045D0CECB1895497B")
    
private void prepareNames() {
        // array of lists with permitted General Names divided by type
        permitted_names = new ArrayList[9];
        if (permittedSubtrees != null) {
            for (GeneralSubtree generalSubtree : permittedSubtrees.getSubtrees()) {
                GeneralName name = generalSubtree.getBase();
                int tag = name.getTag();
                if (permitted_names[tag] == null) {
                    permitted_names[tag] = new ArrayList<GeneralName>();
                }
                permitted_names[tag].add(name);
            }
        }
        // array of lists with excluded General Names divided by type
        excluded_names = new ArrayList[9];
        if (excludedSubtrees != null) {
            for (GeneralSubtree generalSubtree : excludedSubtrees.getSubtrees()) {
                GeneralName name = generalSubtree.getBase();
                int tag = name.getTag();
                if (excluded_names[tag] == null) {
                    excluded_names[tag] = new ArrayList<GeneralName>();
                }
                excluded_names[tag].add(name);
            }
        }
    }

    /**
     * Returns the value of certificate extension
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.697 -0500", hash_original_method = "7F050A55683D0AA0C8EC41E810522931", hash_generated_method = "382D82C3B2C923F88C9BBC99031AA8D4")
    
private byte[] getExtensionValue(X509Certificate cert, String OID) {
        try {
            byte[] bytes = cert.getExtensionValue(OID);
            if (bytes == null) {
                return null;
            }
            return (byte[]) ASN1OctetString.getInstance().decode(bytes);
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Apply the name restrictions specified by this NameConstraints
     * instance to the subject distinguished name and subject alternative
     * names of specified X509Certificate. Restrictions apply only
     * if specified name form is present in the certificate.
     * The restrictions are applied according the RFC 3280
     * (see 4.2.1.11 Name Constraints), excepting that restrictions are applied
     * and to CA certificates, and to certificates which issuer and subject
     * names the same (i.e. method does not check if it CA's certificate or not,
     * or if the names differ or not. This check if it is needed should be done
     * by caller before calling this method).
     * @param   cert X.509 Certificate to be checked.
     * @return  true if the certificate is acceptable according
     *          these NameConstraints restrictions
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.700 -0500", hash_original_method = "29F552B10A233C166AD77E1C4D545B27", hash_generated_method = "A71C97BB0B42D1E0A22118CC9B92D3DA")
    
public boolean isAcceptable(X509Certificate cert) {
        if (permitted_names == null) {
            prepareNames();
        }

        byte[] bytes = getExtensionValue(cert, "2.5.29.17");
        List<GeneralName> names;
        try {
            names = (bytes == null)
                ? new ArrayList<GeneralName>(1) // will check the subject field only
                : ((GeneralNames) GeneralNames.ASN1.decode(bytes)).getNames();
        } catch (IOException e) {
            // the certificate is broken;
            e.printStackTrace();
            return false;
        }
        if ((excluded_names[4] != null) || (permitted_names[4] != null)) {
            try {
                names.add(new GeneralName(4,
                        cert.getSubjectX500Principal().getName()));
            } catch (IOException e) {
                // should never be happened
            }
        }
        return isAcceptable(names);
    }

    /**
     * Check if this list of names is acceptable according to this
     * NameConstraints object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.703 -0500", hash_original_method = "D894692E4046265C2E05884CCE780235", hash_generated_method = "6916F058183D4D399BA9F3CB802F64B9")
    
public boolean isAcceptable(List<GeneralName> names) {
        if (permitted_names == null) {
            prepareNames();
        }

        // check map: shows which types of permitted alternative names are
        // presented in the certificate
        boolean[] types_presented = new boolean[9];
        // check map: shows if permitted name of presented type is found
        // among the certificate's alternative names
        boolean[] permitted_found = new boolean[9];
        for (GeneralName name : names) {
            int type = name.getTag();
            // search the name in excluded names
            if (excluded_names[type] != null) {
                for (int i = 0; i < excluded_names[type].size(); i++) {
                    if (excluded_names[type].get(i).isAcceptable(name)) {
                        return false;
                    }
                }
            }
            // Search the name in permitted names
            // (if we already found the name of such type between the alt
            // names - we do not need to check others)
            if ((permitted_names[type] != null) && (!permitted_found[type])) {
                types_presented[type] = true;
                for (int i = 0; i < permitted_names[type].size(); i++) {
                    if (permitted_names[type].get(i).isAcceptable(name)) {
                        // found one permitted name of such type
                        permitted_found[type] = true;
                    }
                }
            }
        }
        for (int type = 0; type < 9; type++) {
            if (types_presented[type] && !permitted_found[type]) {
                return false;
            }
        }
        return true;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:02.706 -0500", hash_original_method = "54185F2659E074B2203C13418D4687EB", hash_generated_method = "F873D5C44CB543E50861371BEEDAD3F1")
    
@Override public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("Name Constraints: [\n");
        if (permittedSubtrees != null) {
            sb.append(prefix).append("  Permitted: [\n");
            for (GeneralSubtree generalSubtree : permittedSubtrees.getSubtrees()) {
                generalSubtree.dumpValue(sb, prefix + "    ");
            }
            sb.append(prefix).append("  ]\n");
        }
        if (excludedSubtrees != null) {
            sb.append(prefix).append("  Excluded: [\n");
            for (GeneralSubtree generalSubtree : excludedSubtrees.getSubtrees()) {
                generalSubtree.dumpValue(sb, prefix + "    ");
            }
            sb.append(prefix).append("  ]\n");
        }
        sb.append('\n').append(prefix).append("]\n");
    }
}

