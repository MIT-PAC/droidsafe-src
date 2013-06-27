package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.DERBoolean;

public class X509Extension {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.228 -0400", hash_original_field = "7E85BCB66FB9A809D5AB4F62A8B8BEA8", hash_generated_field = "1F76041313F1C10961473CD0339FD9F7")

    boolean critical;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.228 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "5DEA83DCEFEBCFCA3C7CDEF67511142C")

    ASN1OctetString value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.228 -0400", hash_original_method = "6C4CE5090B82D2BBA22095A3F4EA5D32", hash_generated_method = "DEBE1CFA4604C6B61DD9B6C136F8E2C6")
    public  X509Extension(
        DERBoolean              critical,
        ASN1OctetString         value) {
        this.critical = critical.isTrue();
        this.value = value;
        // ---------- Original Method ----------
        //this.critical = critical.isTrue();
        //this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.228 -0400", hash_original_method = "F07A2761AE08F0A017E88726FB4327E2", hash_generated_method = "1932F9A473D856E5303B496CB5EBCCCC")
    public  X509Extension(
        boolean                 critical,
        ASN1OctetString         value) {
        this.critical = critical;
        this.value = value;
        // ---------- Original Method ----------
        //this.critical = critical;
        //this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.234 -0400", hash_original_method = "99E720A5A58C8C8AC266D5DB5489BE5B", hash_generated_method = "128BE00C5A271519DA7F28FE0606E348")
    public boolean isCritical() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1510946641 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1510946641;
        // ---------- Original Method ----------
        //return critical;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.239 -0400", hash_original_method = "EB9162E88B2ECD208428A8DA5B61CEE8", hash_generated_method = "E23513C5732323D4CF831AC1F382CA2B")
    public ASN1OctetString getValue() {
        ASN1OctetString varB4EAC82CA7396A68D541C85D26508E83_1468671932 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1468671932 = value;
        varB4EAC82CA7396A68D541C85D26508E83_1468671932.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1468671932;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.242 -0400", hash_original_method = "1593618AA769EDEFE49746B8725FB3A3", hash_generated_method = "C4D21B39BB8FB18E13728ABA162BC9F3")
    public ASN1Encodable getParsedValue() {
        ASN1Encodable varB4EAC82CA7396A68D541C85D26508E83_570764429 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_570764429 = convertValueToObject(this);
        varB4EAC82CA7396A68D541C85D26508E83_570764429.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_570764429;
        // ---------- Original Method ----------
        //return convertValueToObject(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.242 -0400", hash_original_method = "F51FC5FDE8514BA4D7895E2CA6F69CED", hash_generated_method = "2F6A94511C97FA787A5B371C00759284")
    public int hashCode() {
        {
            boolean var6AE77A2063D5859194080BD59BDF9199_499063587 = (this.isCritical());
            {
                int varE11CF5FC359D7CD25833B4D5D6E451F2_1410802474 = (this.getValue().hashCode());
            } //End block
        } //End collapsed parenthetic
        int var0B2BFDD10921CAA96F647C07149C5FD9_1069803396 = (~this.getValue().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1424685299 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1424685299;
        // ---------- Original Method ----------
        //if (this.isCritical())
        //{
            //return this.getValue().hashCode();
        //}
        //return ~this.getValue().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.243 -0400", hash_original_method = "63E75CEC65A75841B4924B9C6901B009", hash_generated_method = "130FD3B96CE1DC0514B49C7DDD35F08D")
    public boolean equals(
        Object  o) {
        X509Extension other;
        other = (X509Extension)o;
        boolean var172180D06513EF64C163BFA702800218_1975439285 = (other.getValue().equals(this.getValue())
            && (other.isCritical() == this.isCritical()));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1865919254 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1865919254;
        // ---------- Original Method ----------
        //if (!(o instanceof X509Extension))
        //{
            //return false;
        //}
        //X509Extension   other = (X509Extension)o;
        //return other.getValue().equals(this.getValue())
            //&& (other.isCritical() == this.isCritical());
    }

    
        public static ASN1Object convertValueToObject(
        X509Extension ext) throws IllegalArgumentException {
        try
        {
            return ASN1Object.fromByteArray(ext.getValue().getOctets());
        }
        catch (IOException e)
        {
            throw new IllegalArgumentException("can't convert extension: " +  e);
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.243 -0400", hash_original_field = "5D62D9C4F80A2268673C4B4EEF5D21B0", hash_generated_field = "708DFA40D67876201A97B6E4C0D7B9B3")

    public static final ASN1ObjectIdentifier subjectDirectoryAttributes = new ASN1ObjectIdentifier("2.5.29.9");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.243 -0400", hash_original_field = "E660A2E90A33607F081348A21DCEE839", hash_generated_field = "7EF2B58EBE68A563E9318543ECE44814")

    public static final ASN1ObjectIdentifier subjectKeyIdentifier = new ASN1ObjectIdentifier("2.5.29.14");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.243 -0400", hash_original_field = "7CE68220EDB99F46CE434182C058429A", hash_generated_field = "E6C8A9B9350511057FE7EED3A1B10B79")

    public static final ASN1ObjectIdentifier keyUsage = new ASN1ObjectIdentifier("2.5.29.15");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.243 -0400", hash_original_field = "78D18FA75315708A1258C280B615B1B2", hash_generated_field = "8438BD19FC683ED610A38D1C42A21613")

    public static final ASN1ObjectIdentifier privateKeyUsagePeriod = new ASN1ObjectIdentifier("2.5.29.16");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.243 -0400", hash_original_field = "28666AA39BB5B66FE4ECF7257965C570", hash_generated_field = "574ABA704AEE482E837956505300CBE7")

    public static final ASN1ObjectIdentifier subjectAlternativeName = new ASN1ObjectIdentifier("2.5.29.17");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.243 -0400", hash_original_field = "6F13CA235A4499AD07E0A159A0ED9B43", hash_generated_field = "C9BC2A4363464C5763810C5B85B8ADD6")

    public static final ASN1ObjectIdentifier issuerAlternativeName = new ASN1ObjectIdentifier("2.5.29.18");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.243 -0400", hash_original_field = "36602CF7C25AC5625CE39D732C3BE15C", hash_generated_field = "651ABE96DD81EBFC64F16DE0B8085AA0")

    public static final ASN1ObjectIdentifier basicConstraints = new ASN1ObjectIdentifier("2.5.29.19");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.243 -0400", hash_original_field = "19436BC00251107F39AB5537A9B3305F", hash_generated_field = "6FBB03B5278D0AC68DD840F6FDD69007")

    public static final ASN1ObjectIdentifier cRLNumber = new ASN1ObjectIdentifier("2.5.29.20");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.243 -0400", hash_original_field = "BA3D49D178563C15A0141658062CFA0A", hash_generated_field = "F64559B4AE200EEFED3FC1382CFEB209")

    public static final ASN1ObjectIdentifier reasonCode = new ASN1ObjectIdentifier("2.5.29.21");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.243 -0400", hash_original_field = "EF01CFA216B5A2630595E86516B305C7", hash_generated_field = "C6E01E4782E3142A2062DD391E8993A9")

    public static final ASN1ObjectIdentifier instructionCode = new ASN1ObjectIdentifier("2.5.29.23");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.243 -0400", hash_original_field = "A5F21485526C326FEE8FBDFE7E6FE136", hash_generated_field = "B4BA38A588FE1FBECE2CB39CB9A04577")

    public static final ASN1ObjectIdentifier invalidityDate = new ASN1ObjectIdentifier("2.5.29.24");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.243 -0400", hash_original_field = "E34DC6775487279427D4C6FD5DC4C091", hash_generated_field = "2D1750D4B0CAFC468BD87242F3B4EDC8")

    public static final ASN1ObjectIdentifier deltaCRLIndicator = new ASN1ObjectIdentifier("2.5.29.27");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.244 -0400", hash_original_field = "9853AABA82458669AAE5D3F178901CBC", hash_generated_field = "7D8838AD48B9DB0ED011924AC9A8BE36")

    public static final ASN1ObjectIdentifier issuingDistributionPoint = new ASN1ObjectIdentifier("2.5.29.28");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.244 -0400", hash_original_field = "9FA9CC74AF3BFF87D212778A0988E0BB", hash_generated_field = "54217842FF3BD80C9640021FCABC3E01")

    public static final ASN1ObjectIdentifier certificateIssuer = new ASN1ObjectIdentifier("2.5.29.29");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.244 -0400", hash_original_field = "10649A3474BD209A5F5156A79EDBAD12", hash_generated_field = "B97A0323DB70CC9B24E0CFE2E80EBB05")

    public static final ASN1ObjectIdentifier nameConstraints = new ASN1ObjectIdentifier("2.5.29.30");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.244 -0400", hash_original_field = "1779B336D9EBE4C8E801558481A53B50", hash_generated_field = "1A54D0E4D2CFD348B42EE00A4FB57439")

    public static final ASN1ObjectIdentifier cRLDistributionPoints = new ASN1ObjectIdentifier("2.5.29.31");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.244 -0400", hash_original_field = "6713F2DECFD374A163B9ACB05674EE1E", hash_generated_field = "B2719714B4710DE7BDCCF54D738CF40E")

    public static final ASN1ObjectIdentifier certificatePolicies = new ASN1ObjectIdentifier("2.5.29.32");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.244 -0400", hash_original_field = "25173707804CD1E021E4BBB64E68BB86", hash_generated_field = "CB99E891E129F0D41957D78E39E9930C")

    public static final ASN1ObjectIdentifier policyMappings = new ASN1ObjectIdentifier("2.5.29.33");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.244 -0400", hash_original_field = "31931F2839CE7BE8DD8AA35C9D81D9F1", hash_generated_field = "6B58B8730C3C0FACBB5B129C79537F7E")

    public static final ASN1ObjectIdentifier authorityKeyIdentifier = new ASN1ObjectIdentifier("2.5.29.35");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.244 -0400", hash_original_field = "47CDFD2AB58474FD158889CD77261EDB", hash_generated_field = "91653110871D92CD4746D51E7CC61179")

    public static final ASN1ObjectIdentifier policyConstraints = new ASN1ObjectIdentifier("2.5.29.36");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.244 -0400", hash_original_field = "11757B90BD32C4CF3B16A1FEFD070390", hash_generated_field = "ED46B480A0348A8A5E8BE4BF483EE6BE")

    public static final ASN1ObjectIdentifier extendedKeyUsage = new ASN1ObjectIdentifier("2.5.29.37");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.244 -0400", hash_original_field = "21141D1FFF3E15E0C92A267C30F492E3", hash_generated_field = "7A2F0259BAA32DDCEBE7AAF541831ED6")

    public static final ASN1ObjectIdentifier freshestCRL = new ASN1ObjectIdentifier("2.5.29.46");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.244 -0400", hash_original_field = "D1E278EECD1F94FBF15F0E2550951739", hash_generated_field = "D0F2FC6E035F2D89ED4F5A11FEC0BCB3")

    public static final ASN1ObjectIdentifier inhibitAnyPolicy = new ASN1ObjectIdentifier("2.5.29.54");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.244 -0400", hash_original_field = "7BE455EF1A2F784D672595289FC6ECA4", hash_generated_field = "2A35D1B4B58A71E78E3D07DE0A3E377F")

    public static final ASN1ObjectIdentifier authorityInfoAccess = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.1");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.244 -0400", hash_original_field = "7B76E9FF8493911A50655F1705114F31", hash_generated_field = "B65B7E6D574103E583D2733DFBEF61AE")

    public static final ASN1ObjectIdentifier subjectInfoAccess = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.11");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.244 -0400", hash_original_field = "DF2395E17EE1BD398ED164F6B9AF1F7B", hash_generated_field = "5A2C0DE36D3C06D3894D5D9EA2A0E806")

    public static final ASN1ObjectIdentifier logoType = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.12");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.244 -0400", hash_original_field = "AFC3C36D02FFC2F0EC876C4C06F37ABD", hash_generated_field = "64D1E07E82B12E9D2CFD23523058D1BB")

    public static final ASN1ObjectIdentifier biometricInfo = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.2");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.244 -0400", hash_original_field = "1FD5BBFB65110FFCA22590706077820E", hash_generated_field = "BC97CB413BFD9DB1650E0C25392A8558")

    public static final ASN1ObjectIdentifier qCStatements = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.3");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.244 -0400", hash_original_field = "FCA5A70E039CFC6848CAF8AD8D8F07B1", hash_generated_field = "9D60EDAC7FA677444110BAAB862A73E7")

    public static final ASN1ObjectIdentifier auditIdentity = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.4");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.244 -0400", hash_original_field = "291CB398D5EF7BAF2E1CAD8BCC872ECF", hash_generated_field = "C1A9128EBDFB37685DA44E2F68616BE5")

    public static final ASN1ObjectIdentifier noRevAvail = new ASN1ObjectIdentifier("2.5.29.56");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.244 -0400", hash_original_field = "B3E2382946716DFF5A2A83E898C9F072", hash_generated_field = "6B8526FB71E7ACA0F6D598172BC2DC1D")

    public static final ASN1ObjectIdentifier targetInformation = new ASN1ObjectIdentifier("2.5.29.55");
}

