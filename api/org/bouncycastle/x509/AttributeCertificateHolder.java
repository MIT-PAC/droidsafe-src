package org.bouncycastle.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.cert.CertSelector;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.Holder;
import org.bouncycastle.asn1.x509.IssuerSerial;
import org.bouncycastle.asn1.x509.ObjectDigestInfo;
import org.bouncycastle.jce.PrincipalUtil;
import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Selector;

public class AttributeCertificateHolder implements CertSelector, Selector {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.691 -0400", hash_original_field = "A403F79916FA151CDCC745626E69FED2", hash_generated_field = "81EEF30676831ECD3948BE1C9E69FB41")

    Holder holder;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.692 -0400", hash_original_method = "5CADDEA19B83B0D9A5BBB8113D1E397F", hash_generated_method = "F59428356E32C4723CDCA0BF11B8E6A2")
      AttributeCertificateHolder(ASN1Sequence seq) {
        holder = Holder.getInstance(seq);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.692 -0400", hash_original_method = "36C6FF42848B06325DA653927B354FB6", hash_generated_method = "F8BAA13337AB237B2C07C3B22FEF3CB7")
    public  AttributeCertificateHolder(X509Principal issuerName,
        BigInteger serialNumber) {
        holder = new org.bouncycastle.asn1.x509.Holder(new IssuerSerial(
            new GeneralNames(new DERSequence(new GeneralName(issuerName))),
            new DERInteger(serialNumber)));
        
        
            
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.693 -0400", hash_original_method = "AB8EF4A9C8EF2BF3AB56D333BEC2C930", hash_generated_method = "70E29F8EED6A8FAE6CB14934E79D64B6")
    public  AttributeCertificateHolder(X500Principal issuerName,
        BigInteger serialNumber) {
        this(X509Util.convertPrincipal(issuerName), serialNumber);
        addTaint(serialNumber.getTaint());
        addTaint(issuerName.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.694 -0400", hash_original_method = "38A3680A490D691786DB1D5D606419F8", hash_generated_method = "134F8A5D4C2F4C93D5177491FE967AD8")
    public  AttributeCertificateHolder(X509Certificate cert) throws CertificateParsingException {
        X509Principal name;
        try 
        {
            name = PrincipalUtil.getIssuerX509Principal(cert);
        } 
        catch (Exception e)
        {
            CertificateParsingException var9ECFF51269413FFE65CC631CA16E3743_1361879655 = new CertificateParsingException(e.getMessage());
            var9ECFF51269413FFE65CC631CA16E3743_1361879655.addTaint(taint);
            throw var9ECFF51269413FFE65CC631CA16E3743_1361879655;
        } 
        holder = new Holder(new IssuerSerial(generateGeneralNames(name),
            new DERInteger(cert.getSerialNumber())));
        
        
        
        
            
        
        
        
            
        
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.694 -0400", hash_original_method = "BB3F8ED7A12081786FFA678549853DD7", hash_generated_method = "9DAC6696A4355E038108E0ADFA13A2E4")
    public  AttributeCertificateHolder(X509Principal principal) {
        holder = new Holder(generateGeneralNames(principal));
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.694 -0400", hash_original_method = "8754A1CB9EC37CB6374A9BB4689D9463", hash_generated_method = "887D0050DF99D6E04954A122736E8C21")
    public  AttributeCertificateHolder(X500Principal principal) {
        this(X509Util.convertPrincipal(principal));
        addTaint(principal.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.695 -0400", hash_original_method = "058E2AA05CCDB81429F1E94E1527F7B6", hash_generated_method = "55B74FCEB90EE5EEEC66BDDDFBED7FE8")
    public  AttributeCertificateHolder(int digestedObjectType,
        String digestAlgorithm, String otherObjectTypeID, byte[] objectDigest) {
        holder = new Holder(new ObjectDigestInfo(digestedObjectType,
            otherObjectTypeID, new AlgorithmIdentifier(digestAlgorithm), Arrays
                .clone(objectDigest)));
        
        
            
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.696 -0400", hash_original_method = "5DC58025DAD5ABD5E5609ED391A96DAB", hash_generated_method = "104D66B114ECAA8A9BAAEFB951CFADA8")
    public int getDigestedObjectType() {
    if(holder.getObjectDigestInfo() != null)        
        {
            int var98CEC5CB54B9CF5CAAAC5B29AAE60F6B_234959053 = (holder.getObjectDigestInfo().getDigestedObjectType()
                .getValue().intValue());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_223394139 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_223394139;
        } 
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1554195087 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2124159369 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2124159369;
        
        
        
            
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.696 -0400", hash_original_method = "44CC065F66E7FDD5B9E2538C14A00A59", hash_generated_method = "92109833865D9AF1F9E266A2C42D7151")
    public String getDigestAlgorithm() {
    if(holder.getObjectDigestInfo() != null)        
        {
String var1E93A44C0555128AC5428CFBAFC67BD1_1564668630 =             holder.getObjectDigestInfo().getDigestAlgorithm().getObjectId()
                .getId();
            var1E93A44C0555128AC5428CFBAFC67BD1_1564668630.addTaint(taint);
            return var1E93A44C0555128AC5428CFBAFC67BD1_1564668630;
        } 
String var540C13E9E156B687226421B24F2DF178_673344529 =         null;
        var540C13E9E156B687226421B24F2DF178_673344529.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_673344529;
        
        
        
            
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.696 -0400", hash_original_method = "4B9D866BC14850DF9DC3D05B3C536D79", hash_generated_method = "EA30F57856D5C9BE51916C81969AEC7D")
    public byte[] getObjectDigest() {
    if(holder.getObjectDigestInfo() != null)        
        {
            byte[] varF3A3B800A0376B2AA79672C6DAF118C8_1217029667 = (holder.getObjectDigestInfo().getObjectDigest().getBytes());
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_212897879 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_212897879;
        } 
        byte[] var37A6259CC0C1DAE299A7866489DFF0BD_354060188 = (null);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_387382900 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_387382900;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.697 -0400", hash_original_method = "D91C38C78BDA175ED1B06895DD027E8A", hash_generated_method = "8C26A15C0F3D089002960D6C4F2114D2")
    public String getOtherObjectTypeID() {
    if(holder.getObjectDigestInfo() != null)        
        {
            holder.getObjectDigestInfo().getOtherObjectTypeID().getId();
        } 
String var540C13E9E156B687226421B24F2DF178_369608407 =         null;
        var540C13E9E156B687226421B24F2DF178_369608407.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_369608407;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.697 -0400", hash_original_method = "813AC8AE1843F5B7087E11CB016E8403", hash_generated_method = "71B14FCC6D1C216CF107F0D5826BCCD5")
    private GeneralNames generateGeneralNames(X509Principal principal) {
        addTaint(principal.getTaint());
GeneralNames var94B0934CB17A73A5ED7AD1B3F1523ADC_1708545973 =         new GeneralNames(new DERSequence(new GeneralName(principal)));
        var94B0934CB17A73A5ED7AD1B3F1523ADC_1708545973.addTaint(taint);
        return var94B0934CB17A73A5ED7AD1B3F1523ADC_1708545973;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.698 -0400", hash_original_method = "938EE7D821BB407EF13AE79847029298", hash_generated_method = "D276BFDCB8A8DA424FE304FA22BFEC34")
    private boolean matchesDN(X509Principal subject, GeneralNames targets) {
        addTaint(targets.getTaint());
        addTaint(subject.getTaint());
        GeneralName[] names = targets.getNames();
for(int i = 0;i != names.length;i++)
        {
            GeneralName gn = names[i];
    if(gn.getTagNo() == GeneralName.directoryName)            
            {
                try 
                {
    if(new X509Principal(((ASN1Encodable)gn.getName())
                        .getEncoded()).equals(subject))                    
                    {
                        boolean varB326B5062B2F0E69046810717534CB09_1468135142 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_18286793 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_18286793;
                    } 
                } 
                catch (IOException e)
                {
                } 
            } 
        } 
        boolean var68934A3E9455FA72420237EB05902327_2077357230 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1961331064 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1961331064;
        
        
        
        
            
            
            
                
                
                    
                        
                    
                        
                    
                
                
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.699 -0400", hash_original_method = "7552EC21B75F1C8319E3B7352977E9CE", hash_generated_method = "5CFB3660352EA60D0198C3ADB2BA3677")
    private Object[] getNames(GeneralName[] names) {
        addTaint(names[0].getTaint());
        List l = new ArrayList(names.length);
for(int i = 0;i != names.length;i++)
        {
    if(names[i].getTagNo() == GeneralName.directoryName)            
            {
                try 
                {
                    l.add(new X500Principal(
                        ((ASN1Encodable)names[i].getName()).getEncoded()));
                } 
                catch (IOException e)
                {
                    RuntimeException var4980AE888B424D26E0A3FAF1A1097229_868360563 = new RuntimeException("badly formed Name object");
                    var4980AE888B424D26E0A3FAF1A1097229_868360563.addTaint(taint);
                    throw var4980AE888B424D26E0A3FAF1A1097229_868360563;
                } 
            } 
        } 
Object[] var6C26F6EC1F7A67F950053C95FE24CCE6_748838728 =         l.toArray(new Object[l.size()]);
        var6C26F6EC1F7A67F950053C95FE24CCE6_748838728.addTaint(taint);
        return var6C26F6EC1F7A67F950053C95FE24CCE6_748838728;
        
        
        
        
            
            
                
                
                    
                        
                
                
                
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.700 -0400", hash_original_method = "2BE9B6F72BB32A06F2A43AB8DF17A2B5", hash_generated_method = "50031386BEAFDBFF773A38AA5D99521B")
    private Principal[] getPrincipals(GeneralNames names) {
        addTaint(names.getTaint());
        Object[] p = this.getNames(names.getNames());
        List l = new ArrayList();
for(int i = 0;i != p.length;i++)
        {
    if(p[i] instanceof Principal)            
            {
                l.add(p[i]);
            } 
        } 
Principal[] var2BC6CB15026C258E2509F6CFCF0FEAB1_1534865581 =         (Principal[])l.toArray(new Principal[l.size()]);
        var2BC6CB15026C258E2509F6CFCF0FEAB1_1534865581.addTaint(taint);
        return var2BC6CB15026C258E2509F6CFCF0FEAB1_1534865581;
        
        
        
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.700 -0400", hash_original_method = "DB0C376D8871308D29988D3B3AAF17FC", hash_generated_method = "27D1DE60F583AA5FD07771ABC4807298")
    public Principal[] getEntityNames() {
    if(holder.getEntityName() != null)        
        {
Principal[] varDFC31D129B04B241822A136DF77C702E_588986198 =             getPrincipals(holder.getEntityName());
            varDFC31D129B04B241822A136DF77C702E_588986198.addTaint(taint);
            return varDFC31D129B04B241822A136DF77C702E_588986198;
        } 
Principal[] var540C13E9E156B687226421B24F2DF178_638473698 =         null;
        var540C13E9E156B687226421B24F2DF178_638473698.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_638473698;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.701 -0400", hash_original_method = "4F5AD36C2F60574BEE36BBEC8A3F8872", hash_generated_method = "03923C5B7495F8413182980DCDEA353B")
    public Principal[] getIssuer() {
    if(holder.getBaseCertificateID() != null)        
        {
Principal[] varAA7DA35A79C7F874F57357A5F83F9BF0_290319604 =             getPrincipals(holder.getBaseCertificateID().getIssuer());
            varAA7DA35A79C7F874F57357A5F83F9BF0_290319604.addTaint(taint);
            return varAA7DA35A79C7F874F57357A5F83F9BF0_290319604;
        } 
Principal[] var540C13E9E156B687226421B24F2DF178_1415697148 =         null;
        var540C13E9E156B687226421B24F2DF178_1415697148.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1415697148;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.702 -0400", hash_original_method = "6708CF3972ED2FC7BE75744CEC7FD162", hash_generated_method = "AAB09BE0208F21FA49E10D4719178EED")
    public BigInteger getSerialNumber() {
    if(holder.getBaseCertificateID() != null)        
        {
BigInteger var0366267DB5B10F5EB62E9812B64E09EA_2058023305 =             holder.getBaseCertificateID().getSerial().getValue();
            var0366267DB5B10F5EB62E9812B64E09EA_2058023305.addTaint(taint);
            return var0366267DB5B10F5EB62E9812B64E09EA_2058023305;
        } 
BigInteger var540C13E9E156B687226421B24F2DF178_246015968 =         null;
        var540C13E9E156B687226421B24F2DF178_246015968.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_246015968;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.702 -0400", hash_original_method = "53037C58AFDDBA87577A0806677CF7E3", hash_generated_method = "89E8A8CA341175729ABA152C20B93C32")
    public Object clone() {
Object varEAE8D4E202CC08FFA1C38E04DB4DFE1D_158016558 =         new AttributeCertificateHolder((ASN1Sequence)holder
            .toASN1Object());
        varEAE8D4E202CC08FFA1C38E04DB4DFE1D_158016558.addTaint(taint);
        return varEAE8D4E202CC08FFA1C38E04DB4DFE1D_158016558;
        
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.705 -0400", hash_original_method = "656B19C882F86A200CE16DF3E12BB617", hash_generated_method = "821EE4CBCF68B119D67782D19D71D81C")
    public boolean match(Certificate cert) {
        addTaint(cert.getTaint());
    if(!(cert instanceof X509Certificate))        
        {
            boolean var68934A3E9455FA72420237EB05902327_284443876 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_939619416 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_939619416;
        } 
        X509Certificate x509Cert = (X509Certificate)cert;
        try 
        {
    if(holder.getBaseCertificateID() != null)            
            {
                boolean varC0DE036F21A6D0715FDF8D49DE39C36F_1492390677 = (holder.getBaseCertificateID().getSerial().getValue().equals(x509Cert.getSerialNumber())
                    && matchesDN(PrincipalUtil.getIssuerX509Principal(x509Cert), holder.getBaseCertificateID().getIssuer()));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_188768711 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_188768711;
            } 
    if(holder.getEntityName() != null)            
            {
    if(matchesDN(PrincipalUtil.getSubjectX509Principal(x509Cert),
                    holder.getEntityName()))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1194184291 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_446434802 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_446434802;
                } 
            } 
    if(holder.getObjectDigestInfo() != null)            
            {
                MessageDigest md = null;
                try 
                {
                    md = MessageDigest.getInstance(getDigestAlgorithm(), "BC");
                } 
                catch (Exception e)
                {
                    boolean var68934A3E9455FA72420237EB05902327_820545150 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_87383130 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_87383130;
                } 
switch(getDigestedObjectType()){
                case ObjectDigestInfo.publicKey:
                md.update(cert.getPublicKey().getEncoded());
                break;
                case ObjectDigestInfo.publicKeyCert:
                md.update(cert.getEncoded());
                break;
}    if(!Arrays.areEqual(md.digest(), getObjectDigest()))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_50683863 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1510664934 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1510664934;
                } 
            } 
        } 
        catch (CertificateEncodingException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_1139233531 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_651430038 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_651430038;
        } 
        boolean var68934A3E9455FA72420237EB05902327_1625128531 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1968431062 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1968431062;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.706 -0400", hash_original_method = "DF0F926A4C6973AE80CA99906EB348D1", hash_generated_method = "E1720E527F197F107AFE0CC05EAC210E")
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
    if(obj == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_553527670 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1384452140 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1384452140;
        } 
    if(!(obj instanceof AttributeCertificateHolder))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1606772836 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1402814433 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1402814433;
        } 
        AttributeCertificateHolder other = (AttributeCertificateHolder)obj;
        boolean var375AF02C41746B5375B2A9E0F63FA517_211672079 = (this.holder.equals(other.holder));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_32474670 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_32474670;
        
        
        
            
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.706 -0400", hash_original_method = "D89AAACD9C01672ED8F506F3741EB875", hash_generated_method = "EEBC239B5EE953C48B83F7327C916369")
    public int hashCode() {
        int varAB1C3240F0D80F83C6A8B97E9553840F_552191530 = (this.holder.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_865626233 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_865626233;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.706 -0400", hash_original_method = "A87301CDB1806806ACAD029929062C9D", hash_generated_method = "77698D29469AC1906D0DBB4E8C354BE7")
    public boolean match(Object obj) {
        addTaint(obj.getTaint());
    if(!(obj instanceof X509Certificate))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1541494594 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1070462778 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1070462778;
        } 
        boolean varADA7754756F13D45E6E9A386DF7AABD4_1408479160 = (match((Certificate)obj));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1526541484 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1526541484;
        
        
        
            
        
        
    }

    
}

