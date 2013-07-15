package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.util.Arrays;
import org.apache.harmony.security.asn1.ASN1Boolean;
import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.asn1.ASN1Oid;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.ObjectIdentifier;
import org.apache.harmony.security.utils.Array;

public final class Extension {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.910 -0400", hash_original_field = "81A958EC06A2C622709F6D43796C0CC6", hash_generated_field = "8FF788D802F19156A5C417E4A45E7E12")

    private int[] extnID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.910 -0400", hash_original_field = "C11702F8B721F2CD8532E5E9274B9E88", hash_generated_field = "1083E6F765C894CB0636109B4BF9EBDC")

    private String extnID_str;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.910 -0400", hash_original_field = "7E85BCB66FB9A809D5AB4F62A8B8BEA8", hash_generated_field = "A48F124796E85FB5FCAB8EC4B6BBE7D0")

    private boolean critical;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.910 -0400", hash_original_field = "C508F11B9788D23F670969FC1FC8CE29", hash_generated_field = "20FC9E7634FE8CC649C67A24E78428BB")

    private byte[] extnValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.910 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.910 -0400", hash_original_field = "F35A92C45027DF54487736F7C73F35E4", hash_generated_field = "E823D869E9BDEB05E84E11DD9C5D645B")

    private byte[] rawExtnValue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.911 -0400", hash_original_field = "9D14BBAB97C8DBDEE261B5A3F5FA625E", hash_generated_field = "438348B11B927145AC75EBC3AE4EBA57")

    protected ExtensionValue extnValueObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.911 -0400", hash_original_field = "C0F64CDD095C698E0A8A22FA4E7E76FA", hash_generated_field = "49181044EA66271CEFB24754874F9828")

    private boolean valueDecoded = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.912 -0400", hash_original_method = "772675EFC6AAA2D937AD864985824958", hash_generated_method = "50760EB0ED9565090BA8684D8B00AE4E")
    public  Extension(String extnID, boolean critical,
            ExtensionValue extnValueObject) {
        this.extnID_str = extnID;
        this.extnID = ObjectIdentifier.toIntArray(extnID);
        this.critical = critical;
        this.extnValueObject = extnValueObject;
        this.valueDecoded = true;
        this.extnValue = extnValueObject.getEncoded();
        // ---------- Original Method ----------
        //this.extnID_str = extnID;
        //this.extnID = ObjectIdentifier.toIntArray(extnID);
        //this.critical = critical;
        //this.extnValueObject = extnValueObject;
        //this.valueDecoded = true;
        //this.extnValue = extnValueObject.getEncoded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.913 -0400", hash_original_method = "CDEFB016C5499D8DADD8F004F1D30D96", hash_generated_method = "735B7734C17EB3020FD2E48FFAF24114")
    public  Extension(String extnID, boolean critical, byte[] extnValue) {
        this.extnID_str = extnID;
        this.extnID = ObjectIdentifier.toIntArray(extnID);
        this.critical = critical;
        this.extnValue = extnValue;
        // ---------- Original Method ----------
        //this.extnID_str = extnID;
        //this.extnID = ObjectIdentifier.toIntArray(extnID);
        //this.critical = critical;
        //this.extnValue = extnValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.913 -0400", hash_original_method = "345C69C0F4252C8238B8F3F8FD2D0F67", hash_generated_method = "D97F8633F554235658DAFAFD0C28C8C5")
    public  Extension(int[] extnID, boolean critical, byte[] extnValue) {
        this.extnID = extnID;
        this.critical = critical;
        this.extnValue = extnValue;
        // ---------- Original Method ----------
        //this.extnID = extnID;
        //this.critical = critical;
        //this.extnValue = extnValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.914 -0400", hash_original_method = "AB0587524B2C2DEDC0BB33A1419E0149", hash_generated_method = "351C9DFA2A01E311DFC56D35F7B3BDFA")
    public  Extension(String extnID, byte[] extnValue) {
        this(extnID, NON_CRITICAL, extnValue);
        addTaint(extnValue[0]);
        addTaint(extnID.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.914 -0400", hash_original_method = "2B9F71DD37B484A7E5BC50F8CEC81A97", hash_generated_method = "30C90C267E196C5A82BF00559145C2F7")
    public  Extension(int[] extnID, byte[] extnValue) {
        this(extnID, NON_CRITICAL, extnValue);
        addTaint(extnValue[0]);
        addTaint(extnID[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.915 -0400", hash_original_method = "22B9D2F4819411931A16D6B56F128648", hash_generated_method = "10865578CB40C6A017938930366CE1E5")
    private  Extension(int[] extnID, boolean critical, byte[] extnValue,
            byte[] rawExtnValue, byte[] encoding,
            ExtensionValue decodedExtValue) {
        this(extnID, critical, extnValue);
        addTaint(extnValue[0]);
        addTaint(critical);
        addTaint(extnID[0]);
        this.rawExtnValue = rawExtnValue;
        this.encoding = encoding;
        this.extnValueObject = decodedExtValue;
        this.valueDecoded = (decodedExtValue != null);
        // ---------- Original Method ----------
        //this.rawExtnValue = rawExtnValue;
        //this.encoding = encoding;
        //this.extnValueObject = decodedExtValue;
        //this.valueDecoded = (decodedExtValue != null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.915 -0400", hash_original_method = "E60578C52DB7CB76AFDFFD6E54EB94BA", hash_generated_method = "35D9C218769DBB65C67D4D4C3BC8EE1C")
    public String getExtnID() {
    if(extnID_str == null)        
        {
            extnID_str = ObjectIdentifier.toString(extnID);
        } //End block
String var8F66140B46B5973A28748A3D560AEC2C_425624776 =         extnID_str;
        var8F66140B46B5973A28748A3D560AEC2C_425624776.addTaint(taint);
        return var8F66140B46B5973A28748A3D560AEC2C_425624776;
        // ---------- Original Method ----------
        //if (extnID_str == null) {
            //extnID_str = ObjectIdentifier.toString(extnID);
        //}
        //return extnID_str;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.916 -0400", hash_original_method = "369AB9F41A626798BB3BCC89236BACDA", hash_generated_method = "A9935CB87232ADCF8D4A8B88AB6DB888")
    public boolean getCritical() {
        boolean var7E85BCB66FB9A809D5AB4F62A8B8BEA8_203814760 = (critical);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_246115124 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_246115124;
        // ---------- Original Method ----------
        //return critical;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.916 -0400", hash_original_method = "F9C60F4D31E709EEBAC29B8CD2952B48", hash_generated_method = "F39117071267DCACBDC2EEA1AE1103C6")
    public byte[] getExtnValue() {
        byte[] varC508F11B9788D23F670969FC1FC8CE29_815923773 = (extnValue);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1950430189 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1950430189;
        // ---------- Original Method ----------
        //return extnValue;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.916 -0400", hash_original_method = "B972EB2ABEF1534D23452658D280F82C", hash_generated_method = "FBA509D8A71F217EF18753593E2C19E8")
    public byte[] getRawExtnValue() {
    if(rawExtnValue == null)        
        {
            rawExtnValue = ASN1OctetString.getInstance().encode(extnValue);
        } //End block
        byte[] varF35A92C45027DF54487736F7C73F35E4_2072019237 = (rawExtnValue);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_772366261 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_772366261;
        // ---------- Original Method ----------
        //if (rawExtnValue == null) {
            //rawExtnValue = ASN1OctetString.getInstance().encode(extnValue);
        //}
        //return rawExtnValue;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.917 -0400", hash_original_method = "289715FCA6A05E78591BCAEFF536AB92", hash_generated_method = "27979AE4C911D0BDA826E46792562CC2")
    public byte[] getEncoded() {
    if(encoding == null)        
        {
            encoding = Extension.ASN1.encode(this);
        } //End block
        byte[] var84BEA1F0FD2CE16F7E562A9F06EF03D3_1070824693 = (encoding);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1125944736 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1125944736;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = Extension.ASN1.encode(this);
        //}
        //return encoding;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.917 -0400", hash_original_method = "20B333A0BC1DB524B0482115BC352DF4", hash_generated_method = "50123FAEE052007441415B888DFDCA1F")
    @Override
    public boolean equals(Object ext) {
        addTaint(ext.getTaint());
    if(!(ext instanceof Extension))        
        {
            boolean var68934A3E9455FA72420237EB05902327_213798996 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1499721328 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1499721328;
        } //End block
        Extension extension = (Extension) ext;
        boolean varCF22EF80DF17CFD258CBF94C4A747185_687759939 = (Arrays.equals(extnID, extension.extnID)
            && (critical == extension.critical)
            && Arrays.equals(extnValue, extension.extnValue));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1968169715 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1968169715;
        // ---------- Original Method ----------
        //if (!(ext instanceof Extension)) {
            //return false;
        //}
        //Extension extension = (Extension) ext;
        //return Arrays.equals(extnID, extension.extnID)
            //&& (critical == extension.critical)
            //&& Arrays.equals(extnValue, extension.extnValue);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.917 -0400", hash_original_method = "0E35AAFACBBEB06CE332961CEFE27EA0", hash_generated_method = "7EB8C865776424F9658D0F4303ACACF4")
    @Override
    public int hashCode() {
        int var8BA9BE3AACC119495D20501E2854951F_2140622279 = ((Arrays.hashCode(extnID) * 37 + (critical ? 1 : 0)) * 37 + Arrays.hashCode(extnValue));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1265722637 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1265722637;
        // ---------- Original Method ----------
        //return (Arrays.hashCode(extnID) * 37 + (critical ? 1 : 0)) * 37 + Arrays.hashCode(extnValue);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.918 -0400", hash_original_method = "95AE85BA4B02CE08CCFC1E936A7A9C52", hash_generated_method = "EDA626F7FC7F2966E9A9DAD58CB0AE10")
    public ExtensionValue getDecodedExtensionValue() throws IOException {
    if(!valueDecoded)        
        {
            decodeExtensionValue();
        } //End block
ExtensionValue varE7E3C400D255B1408ABF769598DAC171_465097421 =         extnValueObject;
        varE7E3C400D255B1408ABF769598DAC171_465097421.addTaint(taint);
        return varE7E3C400D255B1408ABF769598DAC171_465097421;
        // ---------- Original Method ----------
        //if (!valueDecoded) {
            //decodeExtensionValue();
        //}
        //return extnValueObject;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.918 -0400", hash_original_method = "E99A050D2989B02D8A38B58525424B82", hash_generated_method = "D95B71D2ACF611CC4D2BC24932E8C67E")
    public KeyUsage getKeyUsageValue() {
    if(!valueDecoded)        
        {
            try 
            {
                decodeExtensionValue();
            } //End block
            catch (IOException ignored)
            {
            } //End block
        } //End block
    if(extnValueObject instanceof KeyUsage)        
        {
KeyUsage var339B0CEE2C741BE0BC50E691638847E1_1656744606 =             (KeyUsage) extnValueObject;
            var339B0CEE2C741BE0BC50E691638847E1_1656744606.addTaint(taint);
            return var339B0CEE2C741BE0BC50E691638847E1_1656744606;
        } //End block
        else
        {
KeyUsage var540C13E9E156B687226421B24F2DF178_1988394197 =             null;
            var540C13E9E156B687226421B24F2DF178_1988394197.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1988394197;
        } //End block
        // ---------- Original Method ----------
        //if (!valueDecoded) {
            //try {
                //decodeExtensionValue();
            //} catch (IOException ignored) {
            //}
        //}
        //if (extnValueObject instanceof KeyUsage) {
            //return (KeyUsage) extnValueObject;
        //} else {
            //return null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.918 -0400", hash_original_method = "685788692D49D3921B7D2E066C2897C4", hash_generated_method = "451426EF021766C567A004024721C44C")
    public BasicConstraints getBasicConstraintsValue() {
    if(!valueDecoded)        
        {
            try 
            {
                decodeExtensionValue();
            } //End block
            catch (IOException ignored)
            {
            } //End block
        } //End block
    if(extnValueObject instanceof BasicConstraints)        
        {
BasicConstraints varB29F1FC76B793223076154462902DC23_1070360604 =             (BasicConstraints) extnValueObject;
            varB29F1FC76B793223076154462902DC23_1070360604.addTaint(taint);
            return varB29F1FC76B793223076154462902DC23_1070360604;
        } //End block
        else
        {
BasicConstraints var540C13E9E156B687226421B24F2DF178_640953324 =             null;
            var540C13E9E156B687226421B24F2DF178_640953324.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_640953324;
        } //End block
        // ---------- Original Method ----------
        //if (!valueDecoded) {
            //try {
                //decodeExtensionValue();
            //} catch (IOException ignored) {
            //}
        //}
        //if (extnValueObject instanceof BasicConstraints) {
            //return (BasicConstraints) extnValueObject;
        //} else {
            //return null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.921 -0400", hash_original_method = "9C77FF45155916489182A216F1E7CCEA", hash_generated_method = "2E2617D9F2DDD3E30F07A88E2AC59519")
    private void decodeExtensionValue() throws IOException {
    if(valueDecoded)        
        {
            return;
        } //End block
        valueDecoded = true;
    if(Arrays.equals(extnID, SUBJ_KEY_ID))        
        {
            extnValueObject = SubjectKeyIdentifier.decode(extnValue);
        } //End block
        else
    if(Arrays.equals(extnID, KEY_USAGE))        
        {
            extnValueObject = new KeyUsage(extnValue);
        } //End block
        else
    if(Arrays.equals(extnID, SUBJECT_ALT_NAME))        
        {
            extnValueObject = new AlternativeName(
                    AlternativeName.SUBJECT, extnValue);
        } //End block
        else
    if(Arrays.equals(extnID, ISSUER_ALTERNATIVE_NAME))        
        {
            extnValueObject = new AlternativeName(
                    AlternativeName.SUBJECT, extnValue);
        } //End block
        else
    if(Arrays.equals(extnID, BASIC_CONSTRAINTS))        
        {
            extnValueObject = new BasicConstraints(extnValue);
        } //End block
        else
    if(Arrays.equals(extnID, NAME_CONSTRAINTS))        
        {
            extnValueObject = NameConstraints.decode(extnValue);
        } //End block
        else
    if(Arrays.equals(extnID, CERTIFICATE_POLICIES))        
        {
            extnValueObject = CertificatePolicies.decode(extnValue);
        } //End block
        else
    if(Arrays.equals(extnID, AUTH_KEY_ID))        
        {
            extnValueObject = AuthorityKeyIdentifier.decode(extnValue);
        } //End block
        else
    if(Arrays.equals(extnID, POLICY_CONSTRAINTS))        
        {
            extnValueObject = new PolicyConstraints(extnValue);
        } //End block
        else
    if(Arrays.equals(extnID, EXTENDED_KEY_USAGE))        
        {
            extnValueObject = new ExtendedKeyUsage(extnValue);
        } //End block
        else
    if(Arrays.equals(extnID, INHIBIT_ANY_POLICY))        
        {
            extnValueObject = new InhibitAnyPolicy(extnValue);
        } //End block
        else
    if(Arrays.equals(extnID, CERTIFICATE_ISSUER))        
        {
            extnValueObject = new CertificateIssuer(extnValue);
        } //End block
        else
    if(Arrays.equals(extnID, CRL_DISTR_POINTS))        
        {
            extnValueObject = CRLDistributionPoints.decode(extnValue);
        } //End block
        else
    if(Arrays.equals(extnID, CERTIFICATE_ISSUER))        
        {
            extnValueObject = new ReasonCode(extnValue);
        } //End block
        else
    if(Arrays.equals(extnID, INVALIDITY_DATE))        
        {
            extnValueObject = new InvalidityDate(extnValue);
        } //End block
        else
    if(Arrays.equals(extnID, REASON_CODE))        
        {
            extnValueObject = new ReasonCode(extnValue);
        } //End block
        else
    if(Arrays.equals(extnID, CRL_NUMBER))        
        {
            extnValueObject = new CRLNumber(extnValue);
        } //End block
        else
    if(Arrays.equals(extnID, ISSUING_DISTR_POINTS))        
        {
            extnValueObject = IssuingDistributionPoint.decode(extnValue);
        } //End block
        else
    if(Arrays.equals(extnID, AUTHORITY_INFO_ACCESS))        
        {
            extnValueObject = InfoAccessSyntax.decode(extnValue);
        } //End block
        else
    if(Arrays.equals(extnID, SUBJECT_INFO_ACCESS))        
        {
            extnValueObject = InfoAccessSyntax.decode(extnValue);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.923 -0400", hash_original_method = "42AE8F5966FF1390F79700B69123055B", hash_generated_method = "57D2BC24FB8E6FA5F7FC75B8518FF69E")
    public void dumpValue(StringBuilder sb, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(sb.getTaint());
        sb.append("OID: ").append(getExtnID()).append(", Critical: ").append(critical).append('\n');
    if(!valueDecoded)        
        {
            try 
            {
                decodeExtensionValue();
            } //End block
            catch (IOException ignored)
            {
            } //End block
        } //End block
    if(extnValueObject != null)        
        {
            extnValueObject.dumpValue(sb, prefix);
            return;
        } //End block
        sb.append(prefix);
    if(Arrays.equals(extnID, SUBJ_DIRECTORY_ATTRS))        
        {
            sb.append("Subject Directory Attributes Extension");
        } //End block
        else
    if(Arrays.equals(extnID, SUBJ_KEY_ID))        
        {
            sb.append("Subject Key Identifier Extension");
        } //End block
        else
    if(Arrays.equals(extnID, KEY_USAGE))        
        {
            sb.append("Key Usage Extension");
        } //End block
        else
    if(Arrays.equals(extnID, PRIVATE_KEY_USAGE_PERIOD))        
        {
            sb.append("Private Key Usage Period Extension");
        } //End block
        else
    if(Arrays.equals(extnID, SUBJECT_ALT_NAME))        
        {
            sb.append("Subject Alternative Name Extension");
        } //End block
        else
    if(Arrays.equals(extnID, ISSUER_ALTERNATIVE_NAME))        
        {
            sb.append("Issuer Alternative Name Extension");
        } //End block
        else
    if(Arrays.equals(extnID, BASIC_CONSTRAINTS))        
        {
            sb.append("Basic Constraints Extension");
        } //End block
        else
    if(Arrays.equals(extnID, NAME_CONSTRAINTS))        
        {
            sb.append("Name Constraints Extension");
        } //End block
        else
    if(Arrays.equals(extnID, CRL_DISTR_POINTS))        
        {
            sb.append("CRL Distribution Points Extension");
        } //End block
        else
    if(Arrays.equals(extnID, CERTIFICATE_POLICIES))        
        {
            sb.append("Certificate Policies Extension");
        } //End block
        else
    if(Arrays.equals(extnID, POLICY_MAPPINGS))        
        {
            sb.append("Policy Mappings Extension");
        } //End block
        else
    if(Arrays.equals(extnID, AUTH_KEY_ID))        
        {
            sb.append("Authority Key Identifier Extension");
        } //End block
        else
    if(Arrays.equals(extnID, POLICY_CONSTRAINTS))        
        {
            sb.append("Policy Constraints Extension");
        } //End block
        else
    if(Arrays.equals(extnID, EXTENDED_KEY_USAGE))        
        {
            sb.append("Extended Key Usage Extension");
        } //End block
        else
    if(Arrays.equals(extnID, INHIBIT_ANY_POLICY))        
        {
            sb.append("Inhibit Any-Policy Extension");
        } //End block
        else
    if(Arrays.equals(extnID, AUTHORITY_INFO_ACCESS))        
        {
            sb.append("Authority Information Access Extension");
        } //End block
        else
    if(Arrays.equals(extnID, SUBJECT_INFO_ACCESS))        
        {
            sb.append("Subject Information Access Extension");
        } //End block
        else
    if(Arrays.equals(extnID, INVALIDITY_DATE))        
        {
            sb.append("Invalidity Date Extension");
        } //End block
        else
    if(Arrays.equals(extnID, CRL_NUMBER))        
        {
            sb.append("CRL Number Extension");
        } //End block
        else
    if(Arrays.equals(extnID, REASON_CODE))        
        {
            sb.append("Reason Code Extension");
        } //End block
        else
        {
            sb.append("Unknown Extension");
        } //End block
        sb.append('\n').append(prefix).append("Unparsed Extension Value:\n");
        sb.append(Array.toString(extnValue, prefix));
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.925 -0400", hash_original_field = "9D770FFDDC15870F3D3A340ACD808078", hash_generated_field = "6E31BBAF500C1070EE1FFA080111393F")

    public static final boolean CRITICAL = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.925 -0400", hash_original_field = "61B04E4695AA5F374EEFDAD16E9E0524", hash_generated_field = "57D4ADD3A20722C1472A183BBA626F17")

    public static final boolean NON_CRITICAL = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.925 -0400", hash_original_field = "27AC59456ABCB1CE64FC2C3053748D09", hash_generated_field = "CFFB39566B9AEEC9AB1894E25C5DE3DA")

    static final int[] SUBJ_DIRECTORY_ATTRS = {2, 5, 29, 9};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.925 -0400", hash_original_field = "719C2AB0E2F06E3BD1FF47B05C669C52", hash_generated_field = "12E2A1B5F5C6E6E68AA435B29065A00B")

    static final int[] SUBJ_KEY_ID = {2, 5, 29, 14};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.925 -0400", hash_original_field = "B58C569327B16FBE6BA2EC3275E60A70", hash_generated_field = "0C70346483130DABA174062DEFA137A2")

    static final int[] KEY_USAGE = {2, 5, 29, 15};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.925 -0400", hash_original_field = "11C15EF3E2ED91D6D2AE5ADD3AAB40C0", hash_generated_field = "99B612A5CA31C7372E91E87AF4BCA7CF")

    static final int[] PRIVATE_KEY_USAGE_PERIOD = {2, 5, 29, 16};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.925 -0400", hash_original_field = "763E9AF8FC55F30DD20FEB41EE56E8F5", hash_generated_field = "EDAD333FCA26480E2985EA9905FC2E62")

    static final int[] SUBJECT_ALT_NAME = {2, 5, 29, 17};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.925 -0400", hash_original_field = "6389938383D6D3F2B15BB97818ADA090", hash_generated_field = "E25E2376B509F67CE04E08FE645EDF3A")

    static final int[] ISSUER_ALTERNATIVE_NAME = {2, 5, 29, 18};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.926 -0400", hash_original_field = "E2763B92F43C78EB5AE7CA4C13875A2E", hash_generated_field = "4719361E8A47B688AD0277E34E1EC427")

    static final int[] BASIC_CONSTRAINTS = {2, 5, 29, 19};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.926 -0400", hash_original_field = "2CC72DB0339D067215FFC0B86EBC615B", hash_generated_field = "49AD57F33D760933ED9349263C6F8EAE")

    static final int[] NAME_CONSTRAINTS = {2, 5, 29, 30};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.926 -0400", hash_original_field = "C6D831E4B714E4BEBA10A0311994F721", hash_generated_field = "7A61315B9986A127CC6F2344E095C632")

    static final int[] CRL_DISTR_POINTS = {2, 5, 29, 31};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.926 -0400", hash_original_field = "54E4E62889082A4291C82572415D3FD3", hash_generated_field = "1691E914E66862570393C6E34196E15C")

    static final int[] CERTIFICATE_POLICIES = {2, 5, 29, 32};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.926 -0400", hash_original_field = "92B4E401637FF5C4D11E2E6AA1497575", hash_generated_field = "CE95833AAC25AE706C941911E24707F9")

    static final int[] POLICY_MAPPINGS = {2, 5, 29, 33};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.926 -0400", hash_original_field = "09CD194DEE87CC00E22813CE03AA2189", hash_generated_field = "A324E7513D96D23F13F91F8DFF91B594")

    static final int[] AUTH_KEY_ID = {2, 5, 29, 35};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.926 -0400", hash_original_field = "3A149D04714488EAABB6793BAAC971C7", hash_generated_field = "95538B9ED262D7F125023AC83213D22E")

    static final int[] POLICY_CONSTRAINTS = {2, 5, 29, 36};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.926 -0400", hash_original_field = "A8CB7D09038D802044B2796F8FEC3D21", hash_generated_field = "4359CA80FF8A9D383063F767F62461EA")

    static final int[] EXTENDED_KEY_USAGE = {2, 5, 29, 37};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.926 -0400", hash_original_field = "711DE24A0324604FFC2C892BE38CA12B", hash_generated_field = "47087EB391C3782D2732916FA0F9A8F6")

    static final int[] FRESHEST_CRL = {2, 5, 29, 46};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.926 -0400", hash_original_field = "E584FD6E092027A6F9AE59B800B4BEE1", hash_generated_field = "904578E7AECC101C2C04F1A04DC732B5")

    static final int[] INHIBIT_ANY_POLICY = {2, 5, 29, 54};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.926 -0400", hash_original_field = "F887D8CC4B9E928778BB90E4DD18EC2B", hash_generated_field = "494BD3D519DBA72AF6B11312F94F2233")

    static final int[] AUTHORITY_INFO_ACCESS = {1, 3, 6, 1, 5, 5, 7, 1, 1};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.926 -0400", hash_original_field = "E570A9AB6529D0B74A5004F2E1A61DC9", hash_generated_field = "C976F23CD3B6D6B36515F6F863C6502E")

    static final int[] SUBJECT_INFO_ACCESS = {1, 3, 6, 1, 5, 5, 7, 1, 11};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.926 -0400", hash_original_field = "ADDCB4B21210BC97410BFAB822DE5567", hash_generated_field = "9CED2F6CB0726D71EE80F824234AF7BD")

    static final int[] ISSUING_DISTR_POINT = {2, 5, 29, 28};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.927 -0400", hash_original_field = "A1BE3CEA110171E88491EB6296EC8BCE", hash_generated_field = "966A118EDFE475F73BA36FEA1B1F975C")

    static final int[] CRL_NUMBER = {2, 5, 29, 20};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.927 -0400", hash_original_field = "A5C359B3674964EBA0BAD84A851DDECE", hash_generated_field = "5CDEAF5DBC9CB04A80D24DF838BF2CE2")

    static final int[] CERTIFICATE_ISSUER = {2, 5, 29, 29};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.927 -0400", hash_original_field = "274041C10371CF3BFE121AE51FD7402B", hash_generated_field = "5886D35FDD6D210067E6B9B1BF6BD0F1")

    static final int[] INVALIDITY_DATE = {2, 5, 29, 24};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.927 -0400", hash_original_field = "78516CB1FE0FD6BF662239155F765B89", hash_generated_field = "82525C0AB7C1B69E481DF8A6ADCBB83A")

    static final int[] REASON_CODE = {2, 5, 29, 21};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.927 -0400", hash_original_field = "BC1CA6B2C393BDBE6FD729838874757D", hash_generated_field = "96991C023252842FAC916A47EE9FD09B")

    static final int[] ISSUING_DISTR_POINTS = {2, 5, 29, 28};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.927 -0400", hash_original_field = "162B518F6D507BF8606DF33C2285800B", hash_generated_field = "3978C13F4770C29C9F00A89FB623B39E")

    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            ASN1Oid.getInstance(),
            ASN1Boolean.getInstance(),
            new ASN1OctetString() {
                @Override public Object getDecodedObject(BerInputStream in) throws IOException {
                    
                    
                    return new Object[]
                        {super.getDecodedObject(in), in.getEncoded()};
                }
            }
        }) {
        {
            setDefault(Boolean.FALSE, 1);
        }

        @Override protected Object getDecodedObject(BerInputStream in) throws IOException {
            Object[] values = (Object[]) in.content;

            int[] oid = (int[]) values[0];
            byte[] extnValue = (byte[]) ((Object[]) values[2])[0];
            byte[] rawExtnValue = (byte[]) ((Object[]) values[2])[1];

            ExtensionValue decodedExtValue = null;
            
            if (Arrays.equals(oid, KEY_USAGE)) {
                decodedExtValue = new KeyUsage(extnValue);
            } else if (Arrays.equals(oid, BASIC_CONSTRAINTS)) {
                decodedExtValue = new BasicConstraints(extnValue);
            }

            return new Extension((int[]) values[0], (Boolean) values[1],
                    extnValue, rawExtnValue, in.getEncoded(), decodedExtValue);
        }

        @Override protected void getValues(Object object, Object[] values) {
            Extension ext = (Extension) object;
            values[0] = ext.extnID;
            values[1] = (ext.critical) ? Boolean.TRUE : Boolean.FALSE;
            values[2] = ext.extnValue;
        }
    };
}

