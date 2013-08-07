package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.security.auth.x500.X500Principal;

import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;






public final class Extensions {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.214 -0400", hash_original_field = "2AC737D240FC746CEF37129B7569F08E", hash_generated_field = "F93AA8349A2FA92AE6135244F491401E")

    private List<Extension> extensions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.214 -0400", hash_original_field = "7E85BCB66FB9A809D5AB4F62A8B8BEA8", hash_generated_field = "8AE6968FB7018EBEDA25C054995E291B")

    private Set<String> critical;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.214 -0400", hash_original_field = "ACC02843792BA46B7A7EB0B1788A22C6", hash_generated_field = "6827F144A18995AA402D9FA96B7DCC8C")

    private Set<String> noncritical;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.214 -0400", hash_original_field = "416ECF4BA061CEB2F9353023282FCF57", hash_generated_field = "7B4E2AB69860A448C1B3D04CF6B0EB86")

    private boolean hasUnsupported;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.214 -0400", hash_original_field = "38BC3F68B4757D145BD31C0F88C48214", hash_generated_field = "3CBB0703D1DDEAD49B98A4F5CB8F1949")

    private HashMap<String, Extension> oidMap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.214 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.214 -0400", hash_original_method = "4F6254C867328A153FDD5BD23453E816", hash_generated_method = "8D1DB2771425E2517B9F7DC7528BABC1")
    public  Extensions() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.215 -0400", hash_original_method = "89146A86DD080B3422EC5033031F1DF4", hash_generated_method = "EBF9C74A91F031E9B43BDAD943D3244E")
    public  Extensions(List<Extension> extensions) {
        this.extensions = extensions;
        // ---------- Original Method ----------
        //this.extensions = extensions;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.215 -0400", hash_original_method = "B4520EB3CA6AF47BBFFA43544D7C2D00", hash_generated_method = "3FC152DD2EBCBC449F460E70A9526249")
    public int size() {
        int var1C67B571805D86D4F76721DB00F8E6F4_467565870 = ((extensions == null) ? 0 : extensions.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1374217395 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1374217395;
        // ---------- Original Method ----------
        //return (extensions == null) ? 0 : extensions.size();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.216 -0400", hash_original_method = "6A8A6C791C17F1564EF710302C5F6E38", hash_generated_method = "E443C8D479061B8E51577F8D08052933")
    public Set<String> getCriticalExtensions() {
        if(critical == null)        
        {
            makeOidsLists();
        } //End block
Set<String> varF2B06FFF774E5FA9D519BD0DE855932F_48876986 =         critical;
        varF2B06FFF774E5FA9D519BD0DE855932F_48876986.addTaint(taint);
        return varF2B06FFF774E5FA9D519BD0DE855932F_48876986;
        // ---------- Original Method ----------
        //if (critical == null) {
            //makeOidsLists();
        //}
        //return critical;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.217 -0400", hash_original_method = "A9814A684588F34F98E6563F2443DAA6", hash_generated_method = "F85084F31DB96E1E973991FBB88642A4")
    public Set<String> getNonCriticalExtensions() {
        if(noncritical == null)        
        {
            makeOidsLists();
        } //End block
Set<String> var2FA3366C666BE300428E25FAF64BF989_1570712744 =         noncritical;
        var2FA3366C666BE300428E25FAF64BF989_1570712744.addTaint(taint);
        return var2FA3366C666BE300428E25FAF64BF989_1570712744;
        // ---------- Original Method ----------
        //if (noncritical == null) {
            //makeOidsLists();
        //}
        //return noncritical;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.217 -0400", hash_original_method = "CA1C7754653BDDEC58CFB11BB71C11DB", hash_generated_method = "352EDCCAE035EA03AC70478B11D7248A")
    public boolean hasUnsupportedCritical() {
        if(critical == null)        
        {
            makeOidsLists();
        } //End block
        boolean var416ECF4BA061CEB2F9353023282FCF57_365029524 = (hasUnsupported);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1857204736 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1857204736;
        // ---------- Original Method ----------
        //if (critical == null) {
            //makeOidsLists();
        //}
        //return hasUnsupported;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.218 -0400", hash_original_method = "F144B02FA833AD81E1DCC6E0D8E9952F", hash_generated_method = "FD79ADC27BE331C2CFEDF2658270B663")
    private void makeOidsLists() {
        if(extensions == null)        
        {
            return;
        } //End block
        int size = extensions.size();
        critical = new HashSet<String>(size);
        noncritical = new HashSet<String>(size);
for(Extension extension : extensions)
        {
            String oid = extension.getExtnID();
            if(extension.getCritical())            
            {
                if(!SUPPORTED_CRITICAL.contains(oid))                
                {
                    hasUnsupported = true;
                } //End block
                critical.add(oid);
            } //End block
            else
            {
                noncritical.add(oid);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return;
        //}
        //int size = extensions.size();
        //critical = new HashSet<String>(size);
        //noncritical = new HashSet<String>(size);
        //for (Extension extension : extensions) {
            //String oid = extension.getExtnID();
            //if (extension.getCritical()) {
                //if (!SUPPORTED_CRITICAL.contains(oid)) {
                    //hasUnsupported = true;
                //}
                //critical.add(oid);
            //} else {
                //noncritical.add(oid);
            //}
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.219 -0400", hash_original_method = "44703E9781E0014C266798D0DB277AFC", hash_generated_method = "177B298EDD6698046E3939764F0F66B6")
    public Extension getExtensionByOID(String oid) {
        addTaint(oid.getTaint());
        if(extensions == null)        
        {
Extension var540C13E9E156B687226421B24F2DF178_543920283 =             null;
            var540C13E9E156B687226421B24F2DF178_543920283.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_543920283;
        } //End block
        if(oidMap == null)        
        {
            oidMap = new HashMap<String, Extension>();
for(Extension extension : extensions)
            {
                oidMap.put(extension.getExtnID(), extension);
            } //End block
        } //End block
Extension varD544C9E50790C376615EA57A8A783338_937163666 =         oidMap.get(oid);
        varD544C9E50790C376615EA57A8A783338_937163666.addTaint(taint);
        return varD544C9E50790C376615EA57A8A783338_937163666;
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return null;
        //}
        //if (oidMap == null) {
            //oidMap = new HashMap<String, Extension>();
            //for (Extension extension : extensions) {
                //oidMap.put(extension.getExtnID(), extension);
            //}
        //}
        //return oidMap.get(oid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.220 -0400", hash_original_method = "67C71F044BBB9B405BEFA4564A602892", hash_generated_method = "2C6CCA03FAC8D31B0616FB7E72383950")
    public boolean[] valueOfKeyUsage() {
        Extension extension = getExtensionByOID("2.5.29.15");
        KeyUsage kUsage;
        if((extension == null) || ((kUsage = extension.getKeyUsageValue()) == null))        
        {
            boolean[] var37A6259CC0C1DAE299A7866489DFF0BD_763030038 = (null);
                        boolean[] var503EB2F420079C4024483971CE5EDEA8_1216177922 = {getTaintBoolean()};
            return var503EB2F420079C4024483971CE5EDEA8_1216177922;
        } //End block
        boolean[] var7328FD2E2482780251B3D6D61A71066C_104444009 = (kUsage.getKeyUsage());
                boolean[] var503EB2F420079C4024483971CE5EDEA8_903744520 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_903744520;
        // ---------- Original Method ----------
        //Extension extension = getExtensionByOID("2.5.29.15");
        //KeyUsage kUsage;
        //if ((extension == null) || ((kUsage = extension.getKeyUsageValue()) == null)) {
            //return null;
        //}
        //return kUsage.getKeyUsage();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.220 -0400", hash_original_method = "84A63CE35CC08D6818168132AFB51A65", hash_generated_method = "FD57444A2880EAEBE1694C46786423FC")
    public List<String> valueOfExtendedKeyUsage() throws IOException {
        Extension extension = getExtensionByOID("2.5.29.37");
        if(extension == null)        
        {
List<String> var540C13E9E156B687226421B24F2DF178_845890950 =             null;
            var540C13E9E156B687226421B24F2DF178_845890950.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_845890950;
        } //End block
List<String> varA799009FD1F982F781627366A4256725_1324429892 =         ((ExtendedKeyUsage) extension.getDecodedExtensionValue()).getExtendedKeyUsage();
        varA799009FD1F982F781627366A4256725_1324429892.addTaint(taint);
        return varA799009FD1F982F781627366A4256725_1324429892;
        // ---------- Original Method ----------
        //Extension extension = getExtensionByOID("2.5.29.37");
        //if (extension == null) {
            //return null;
        //}
        //return ((ExtendedKeyUsage) extension.getDecodedExtensionValue()).getExtendedKeyUsage();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.220 -0400", hash_original_method = "CD9DAABD8089C73414664CD384AA791C", hash_generated_method = "8C89D982121B7DD06E8709E334F353BA")
    public int valueOfBasicConstrains() {
        Extension extension = getExtensionByOID("2.5.29.19");
        BasicConstraints bc;
        if((extension == null) || ((bc = extension.getBasicConstraintsValue()) == null))        
        {
            int varE7A95D949116A2DA0F0FA83DC6E76C00_2135483408 = (Integer.MAX_VALUE);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1999600020 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1999600020;
        } //End block
        int var9279A6B93BB93150717B60975425DF2A_405783621 = (bc.getPathLenConstraint());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_900290698 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_900290698;
        // ---------- Original Method ----------
        //Extension extension = getExtensionByOID("2.5.29.19");
        //BasicConstraints bc;
        //if ((extension == null) || ((bc = extension.getBasicConstraintsValue()) == null)) {
            //return Integer.MAX_VALUE;
        //}
        //return bc.getPathLenConstraint();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.221 -0400", hash_original_method = "05742F8CFC468BD801B4E723F95A84AD", hash_generated_method = "D7CCF7FF1DBDEB3AB2E6F50F545702B3")
    public Collection<List<?>> valueOfSubjectAlternativeName() throws IOException {
        Extension extension = getExtensionByOID("2.5.29.17");
        if(extension == null)        
        {
Collection<List<?>> var540C13E9E156B687226421B24F2DF178_2035744085 =             null;
            var540C13E9E156B687226421B24F2DF178_2035744085.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2035744085;
        } //End block
Collection<List<?>> var3C92EC5454C0B0BC8255D151CC79DB75_1625956655 =         ((GeneralNames) GeneralNames.ASN1.decode(extension.getExtnValue())).getPairsList();
        var3C92EC5454C0B0BC8255D151CC79DB75_1625956655.addTaint(taint);
        return var3C92EC5454C0B0BC8255D151CC79DB75_1625956655;
        // ---------- Original Method ----------
        //Extension extension = getExtensionByOID("2.5.29.17");
        //if (extension == null) {
            //return null;
        //}
        //return ((GeneralNames) GeneralNames.ASN1.decode(extension.getExtnValue())).getPairsList();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.221 -0400", hash_original_method = "03BB26B095671170BC4A5910FD38473D", hash_generated_method = "82BA7A05B4390D4574E5709077562420")
    public Collection<List<?>> valueOfIssuerAlternativeName() throws IOException {
        Extension extension = getExtensionByOID("2.5.29.18");
        if(extension == null)        
        {
Collection<List<?>> var540C13E9E156B687226421B24F2DF178_1701284656 =             null;
            var540C13E9E156B687226421B24F2DF178_1701284656.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1701284656;
        } //End block
Collection<List<?>> var3C92EC5454C0B0BC8255D151CC79DB75_659664534 =         ((GeneralNames) GeneralNames.ASN1.decode(extension.getExtnValue())).getPairsList();
        var3C92EC5454C0B0BC8255D151CC79DB75_659664534.addTaint(taint);
        return var3C92EC5454C0B0BC8255D151CC79DB75_659664534;
        // ---------- Original Method ----------
        //Extension extension = getExtensionByOID("2.5.29.18");
        //if (extension == null) {
            //return null;
        //}
        //return ((GeneralNames) GeneralNames.ASN1.decode(extension.getExtnValue())).getPairsList();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.221 -0400", hash_original_method = "7B080EDEBF008BF89BEA15CA32B37546", hash_generated_method = "82115C3E49923B071F4A06FCAFD87311")
    public X500Principal valueOfCertificateIssuerExtension() throws IOException {
        Extension extension = getExtensionByOID("2.5.29.29");
        if(extension == null)        
        {
X500Principal var540C13E9E156B687226421B24F2DF178_486634080 =             null;
            var540C13E9E156B687226421B24F2DF178_486634080.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_486634080;
        } //End block
X500Principal var3B1A9D77F25BB2C1E4F64E96F5CE1A92_282417518 =         ((CertificateIssuer) extension.getDecodedExtensionValue()).getIssuer();
        var3B1A9D77F25BB2C1E4F64E96F5CE1A92_282417518.addTaint(taint);
        return var3B1A9D77F25BB2C1E4F64E96F5CE1A92_282417518;
        // ---------- Original Method ----------
        //Extension extension = getExtensionByOID("2.5.29.29");
        //if (extension == null) {
            //return null;
        //}
        //return ((CertificateIssuer) extension.getDecodedExtensionValue()).getIssuer();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.222 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "8A29A7346C81B197C2308647F73654B8")
    public byte[] getEncoded() {
        if(encoding == null)        
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] var84BEA1F0FD2CE16F7E562A9F06EF03D3_274259121 = (encoding);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1425485179 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1425485179;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.222 -0400", hash_original_method = "C22B11DD1D34238E2A26C4258C487EE2", hash_generated_method = "D3E02C2ACFDA27D3DA1DFD229002AC02")
    @Override
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(!(other instanceof Extensions))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1596392441 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1518305119 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1518305119;
        } //End block
        Extensions that = (Extensions) other;
        boolean var4DE8243C9B86EBEF4722B5E25191E802_2101869603 = ((this.extensions == null || this.extensions.isEmpty())
                    ? (that.extensions == null || that.extensions.isEmpty())
                    : (this.extensions.equals(that.extensions)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_809089912 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_809089912;
        // ---------- Original Method ----------
        //if (!(other instanceof Extensions)) {
            //return false;
        //}
        //Extensions that = (Extensions) other;
        //return (this.extensions == null || this.extensions.isEmpty())
                    //? (that.extensions == null || that.extensions.isEmpty())
                    //: (this.extensions.equals(that.extensions));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.223 -0400", hash_original_method = "4C94C64ABE7312C3D3BBBB76E6D36C32", hash_generated_method = "34F38FA0808BDD290AC4EB694BC57521")
    @Override
    public int hashCode() {
        int hashCode = 0;
        if(extensions != null)        
        {
            hashCode = extensions.hashCode();
        } //End block
        int var550D1CC054A1B23A411DDDA46FD64811_737899443 = (hashCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1563129655 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1563129655;
        // ---------- Original Method ----------
        //int hashCode = 0;
        //if (extensions != null) {
            //hashCode = extensions.hashCode();
        //}
        //return hashCode;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.224 -0400", hash_original_method = "F4C0EB00BC61B6C3C716F9B41C861C66", hash_generated_method = "FC378369D1F8E6B2BB47C41B53A909F6")
    public void dumpValue(StringBuilder sb, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(sb.getTaint());
        if(extensions == null)        
        {
            return;
        } //End block
        int num = 1;
for(Extension extension : extensions)
        {
            sb.append('\n').append(prefix).append('[').append(num++).append("]: ");
            extension.dumpValue(sb, prefix);
        } //End block
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return;
        //}
        //int num = 1;
        //for (Extension extension: extensions) {
            //sb.append('\n').append(prefix).append('[').append(num++).append("]: ");
            //extension.dumpValue(sb, prefix);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.224 -0400", hash_original_field = "F5223D36B00E0FFCDDF9B2B995079CF2", hash_generated_field = "2D002C30AF2816E4CD220F420C40FBAD")

    private static List SUPPORTED_CRITICAL = Arrays.asList(
            "2.5.29.15", "2.5.29.19", "2.5.29.32", "2.5.29.17",
            "2.5.29.30", "2.5.29.36", "2.5.29.37", "2.5.29.54");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.224 -0400", hash_original_field = "9F138981CD4E842F83065885738EAA09", hash_generated_field = "325D4B839B8846AF06D5B6C75FEBE62A")

    public static final ASN1Type ASN1 = new ASN1SequenceOf(Extension.ASN1) {
        @Override public Object getDecodedObject(BerInputStream in) {
            return new Extensions((List<Extension>) in.content);
        }

        @Override public Collection getValues(Object object) {
            Extensions extensions = (Extensions) object;
            return (extensions.extensions == null) ? new ArrayList() : extensions.extensions;
        }
    };
}

