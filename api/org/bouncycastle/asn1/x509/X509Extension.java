package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.DERBoolean;






public class X509Extension {

    /**
     * Convert the value of the passed in extension to an object
     * @param ext the extension to parse
     * @return the object the value string contains
     * @exception IllegalArgumentException if conversion is not possible
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.052 -0500", hash_original_method = "831A483974845D48E10965F44C1F060B", hash_generated_method = "F087F42F518F1A01AC48210A5AB717A6")
    
public static ASN1Object convertValueToObject(
        X509Extension ext)
        throws IllegalArgumentException
    {
        try
        {
            return ASN1Object.fromByteArray(ext.getValue().getOctets());
        }
        catch (IOException e)
        {
            throw new IllegalArgumentException("can't convert extension: " +  e);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.953 -0500", hash_original_field = "8A4157C419E064E1BDC941DA6379F905", hash_generated_field = "708DFA40D67876201A97B6E4C0D7B9B3")

    public static final ASN1ObjectIdentifier subjectDirectoryAttributes = new ASN1ObjectIdentifier("2.5.29.9");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.955 -0500", hash_original_field = "E4D5A61091C371D685AE5546F5E3A800", hash_generated_field = "7EF2B58EBE68A563E9318543ECE44814")

    public static final ASN1ObjectIdentifier subjectKeyIdentifier = new ASN1ObjectIdentifier("2.5.29.14");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.958 -0500", hash_original_field = "A321CD579217A940B9D9AF1C4C9C1023", hash_generated_field = "E6C8A9B9350511057FE7EED3A1B10B79")

    public static final ASN1ObjectIdentifier keyUsage = new ASN1ObjectIdentifier("2.5.29.15");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.960 -0500", hash_original_field = "EC60F14EF02B1655071B81836019D14A", hash_generated_field = "8438BD19FC683ED610A38D1C42A21613")

    public static final ASN1ObjectIdentifier privateKeyUsagePeriod = new ASN1ObjectIdentifier("2.5.29.16");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.962 -0500", hash_original_field = "D0E2901431FFD96B23E56DCD8B05889E", hash_generated_field = "574ABA704AEE482E837956505300CBE7")

    public static final ASN1ObjectIdentifier subjectAlternativeName = new ASN1ObjectIdentifier("2.5.29.17");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.965 -0500", hash_original_field = "080D15F782656B32100CFE2CC6C18C90", hash_generated_field = "C9BC2A4363464C5763810C5B85B8ADD6")

    public static final ASN1ObjectIdentifier issuerAlternativeName = new ASN1ObjectIdentifier("2.5.29.18");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.968 -0500", hash_original_field = "70F9FBABB3894CC1691D1FAEF501E5AD", hash_generated_field = "651ABE96DD81EBFC64F16DE0B8085AA0")

    public static final ASN1ObjectIdentifier basicConstraints = new ASN1ObjectIdentifier("2.5.29.19");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.971 -0500", hash_original_field = "5445C0B805AEAC77415BF07A192592E3", hash_generated_field = "6FBB03B5278D0AC68DD840F6FDD69007")

    public static final ASN1ObjectIdentifier cRLNumber = new ASN1ObjectIdentifier("2.5.29.20");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.973 -0500", hash_original_field = "346204A44A466559D2D64281B55CE0EB", hash_generated_field = "F64559B4AE200EEFED3FC1382CFEB209")

    public static final ASN1ObjectIdentifier reasonCode = new ASN1ObjectIdentifier("2.5.29.21");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.976 -0500", hash_original_field = "3F85E202C9B7F1C641D216A1263DC8B3", hash_generated_field = "C6E01E4782E3142A2062DD391E8993A9")

    public static final ASN1ObjectIdentifier instructionCode = new ASN1ObjectIdentifier("2.5.29.23");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.978 -0500", hash_original_field = "7EC5C7F6040DB3E9FF295D6981B169CC", hash_generated_field = "B4BA38A588FE1FBECE2CB39CB9A04577")

    public static final ASN1ObjectIdentifier invalidityDate = new ASN1ObjectIdentifier("2.5.29.24");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.981 -0500", hash_original_field = "5CEE7B84035CF57179DA2361C146DFD6", hash_generated_field = "2D1750D4B0CAFC468BD87242F3B4EDC8")

    public static final ASN1ObjectIdentifier deltaCRLIndicator = new ASN1ObjectIdentifier("2.5.29.27");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.983 -0500", hash_original_field = "A070D2311EF8E9FE2B5B5309C325E628", hash_generated_field = "7D8838AD48B9DB0ED011924AC9A8BE36")

    public static final ASN1ObjectIdentifier issuingDistributionPoint = new ASN1ObjectIdentifier("2.5.29.28");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.986 -0500", hash_original_field = "B35CD69BCD38F562BA502686499E4E8D", hash_generated_field = "54217842FF3BD80C9640021FCABC3E01")

    public static final ASN1ObjectIdentifier certificateIssuer = new ASN1ObjectIdentifier("2.5.29.29");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.988 -0500", hash_original_field = "852FBA3B2474EBEC90C0254C390313C5", hash_generated_field = "B97A0323DB70CC9B24E0CFE2E80EBB05")

    public static final ASN1ObjectIdentifier nameConstraints = new ASN1ObjectIdentifier("2.5.29.30");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.991 -0500", hash_original_field = "AF0C365E0ABD1D9EDD567ECFBDDFA3FF", hash_generated_field = "1A54D0E4D2CFD348B42EE00A4FB57439")

    public static final ASN1ObjectIdentifier cRLDistributionPoints = new ASN1ObjectIdentifier("2.5.29.31");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.993 -0500", hash_original_field = "AAAC11E1EAC95C2D3FE4C5F6C4136CD1", hash_generated_field = "B2719714B4710DE7BDCCF54D738CF40E")

    public static final ASN1ObjectIdentifier certificatePolicies = new ASN1ObjectIdentifier("2.5.29.32");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.996 -0500", hash_original_field = "326B90DBC4FB8CC15C593FDCCFC4632C", hash_generated_field = "CB99E891E129F0D41957D78E39E9930C")

    public static final ASN1ObjectIdentifier policyMappings = new ASN1ObjectIdentifier("2.5.29.33");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.998 -0500", hash_original_field = "5D0110E1534884EC5C0CF3781B1CDFE2", hash_generated_field = "6B58B8730C3C0FACBB5B129C79537F7E")

    public static final ASN1ObjectIdentifier authorityKeyIdentifier = new ASN1ObjectIdentifier("2.5.29.35");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.001 -0500", hash_original_field = "8D6B6A6E36BBB92440F6E44FC015346C", hash_generated_field = "91653110871D92CD4746D51E7CC61179")

    public static final ASN1ObjectIdentifier policyConstraints = new ASN1ObjectIdentifier("2.5.29.36");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.004 -0500", hash_original_field = "E9FAAE496F99256C88DF76D01B4AAE67", hash_generated_field = "ED46B480A0348A8A5E8BE4BF483EE6BE")

    public static final ASN1ObjectIdentifier extendedKeyUsage = new ASN1ObjectIdentifier("2.5.29.37");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.006 -0500", hash_original_field = "23BFEF495E941B2165DD456A87C604BA", hash_generated_field = "7A2F0259BAA32DDCEBE7AAF541831ED6")

    public static final ASN1ObjectIdentifier freshestCRL = new ASN1ObjectIdentifier("2.5.29.46");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.008 -0500", hash_original_field = "8A61D6BB652035E28432CEEC159128DF", hash_generated_field = "D0F2FC6E035F2D89ED4F5A11FEC0BCB3")

    public static final ASN1ObjectIdentifier inhibitAnyPolicy = new ASN1ObjectIdentifier("2.5.29.54");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.011 -0500", hash_original_field = "A04E87F13B6C3C9C8F67020C7AE27856", hash_generated_field = "2A35D1B4B58A71E78E3D07DE0A3E377F")

    public static final ASN1ObjectIdentifier authorityInfoAccess = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.1");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.014 -0500", hash_original_field = "D9F098C08BC88D4B8D877A23D4B52F7E", hash_generated_field = "B65B7E6D574103E583D2733DFBEF61AE")

    public static final ASN1ObjectIdentifier subjectInfoAccess = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.11");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.016 -0500", hash_original_field = "3FE640A17873487F66395B3FD1B47092", hash_generated_field = "5A2C0DE36D3C06D3894D5D9EA2A0E806")

    public static final ASN1ObjectIdentifier logoType = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.12");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.019 -0500", hash_original_field = "0418B39B1AA67502D870EFF34FFDC77D", hash_generated_field = "64D1E07E82B12E9D2CFD23523058D1BB")

    public static final ASN1ObjectIdentifier biometricInfo = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.2");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.021 -0500", hash_original_field = "890788F611B9E4E73E201A4C49527820", hash_generated_field = "BC97CB413BFD9DB1650E0C25392A8558")

    public static final ASN1ObjectIdentifier qCStatements = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.3");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.024 -0500", hash_original_field = "AC9DBC9E905E6BE019E59FF167CDF64E", hash_generated_field = "9D60EDAC7FA677444110BAAB862A73E7")

    public static final ASN1ObjectIdentifier auditIdentity = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.4");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.027 -0500", hash_original_field = "C56820279F730C68471ED7768BB561D0", hash_generated_field = "C1A9128EBDFB37685DA44E2F68616BE5")

    public static final ASN1ObjectIdentifier noRevAvail = new ASN1ObjectIdentifier("2.5.29.56");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.029 -0500", hash_original_field = "9197802B43E36A6FE8CAAE9C94E095FF", hash_generated_field = "6B8526FB71E7ACA0F6D598172BC2DC1D")

    public static final ASN1ObjectIdentifier targetInformation = new ASN1ObjectIdentifier("2.5.29.55");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.031 -0500", hash_original_field = "1F76041313F1C10961473CD0339FD9F7", hash_generated_field = "1F76041313F1C10961473CD0339FD9F7")

        
    boolean             critical;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.033 -0500", hash_original_field = "5DEA83DCEFEBCFCA3C7CDEF67511142C", hash_generated_field = "5DEA83DCEFEBCFCA3C7CDEF67511142C")

    ASN1OctetString      value;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.036 -0500", hash_original_method = "6C4CE5090B82D2BBA22095A3F4EA5D32", hash_generated_method = "321B13963BA4CD750136E03A01BEEDB1")
    
public X509Extension(
        DERBoolean              critical,
        ASN1OctetString         value)
    {
        this.critical = critical.isTrue();
        this.value = value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.039 -0500", hash_original_method = "F07A2761AE08F0A017E88726FB4327E2", hash_generated_method = "BE22B17818D9315D5351E20FCF918E49")
    
public X509Extension(
        boolean                 critical,
        ASN1OctetString         value)
    {
        this.critical = critical;
        this.value = value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.041 -0500", hash_original_method = "99E720A5A58C8C8AC266D5DB5489BE5B", hash_generated_method = "43426F12A2934B3CAFCEAC3BAE9EEFE1")
    
public boolean isCritical()
    {
        return critical;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.043 -0500", hash_original_method = "EB9162E88B2ECD208428A8DA5B61CEE8", hash_generated_method = "930182EE611BDAD6E0064D4CAE99D604")
    
public ASN1OctetString getValue()
    {
        return value;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.045 -0500", hash_original_method = "1593618AA769EDEFE49746B8725FB3A3", hash_generated_method = "BCFED7DC25469237FB976274109A2CEF")
    
public ASN1Encodable getParsedValue()
    {
        return convertValueToObject(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.047 -0500", hash_original_method = "F51FC5FDE8514BA4D7895E2CA6F69CED", hash_generated_method = "6C1BE34F3476E34C36231E5B793DE21C")
    
public int hashCode()
    {
        if (this.isCritical())
        {
            return this.getValue().hashCode();
        }

        
        return ~this.getValue().hashCode();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:22.049 -0500", hash_original_method = "63E75CEC65A75841B4924B9C6901B009", hash_generated_method = "CADC4917F3BD2C1F186F433235F59E96")
    
public boolean equals(
        Object  o)
    {
        if (!(o instanceof X509Extension))
        {
            return false;
        }

        X509Extension   other = (X509Extension)o;

        return other.getValue().equals(this.getValue())
            && (other.isCritical() == this.isCritical());
    }
}

