package org.bouncycastle.x509;

// Droidsafe Imports
import droidsafe.annotations.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.505 -0400", hash_original_field = "A403F79916FA151CDCC745626E69FED2", hash_generated_field = "81EEF30676831ECD3948BE1C9E69FB41")

    Holder holder;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.506 -0400", hash_original_method = "5CADDEA19B83B0D9A5BBB8113D1E397F", hash_generated_method = "F59428356E32C4723CDCA0BF11B8E6A2")
      AttributeCertificateHolder(ASN1Sequence seq) {
        holder = Holder.getInstance(seq);
        // ---------- Original Method ----------
        //holder = Holder.getInstance(seq);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.507 -0400", hash_original_method = "36C6FF42848B06325DA653927B354FB6", hash_generated_method = "F8BAA13337AB237B2C07C3B22FEF3CB7")
    public  AttributeCertificateHolder(X509Principal issuerName,
        BigInteger serialNumber) {
        holder = new org.bouncycastle.asn1.x509.Holder(new IssuerSerial(
            new GeneralNames(new DERSequence(new GeneralName(issuerName))),
            new DERInteger(serialNumber)));
        // ---------- Original Method ----------
        //holder = new org.bouncycastle.asn1.x509.Holder(new IssuerSerial(
            //new GeneralNames(new DERSequence(new GeneralName(issuerName))),
            //new DERInteger(serialNumber)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.507 -0400", hash_original_method = "AB8EF4A9C8EF2BF3AB56D333BEC2C930", hash_generated_method = "70E29F8EED6A8FAE6CB14934E79D64B6")
    public  AttributeCertificateHolder(X500Principal issuerName,
        BigInteger serialNumber) {
        this(X509Util.convertPrincipal(issuerName), serialNumber);
        addTaint(serialNumber.getTaint());
        addTaint(issuerName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.508 -0400", hash_original_method = "38A3680A490D691786DB1D5D606419F8", hash_generated_method = "BD9DFE557F4C8F9FF679E486C262A7AF")
    public  AttributeCertificateHolder(X509Certificate cert) throws CertificateParsingException {
        X509Principal name;
        try 
        {
            name = PrincipalUtil.getIssuerX509Principal(cert);
        } //End block
        catch (Exception e)
        {
            CertificateParsingException var9ECFF51269413FFE65CC631CA16E3743_403874177 = new CertificateParsingException(e.getMessage());
            var9ECFF51269413FFE65CC631CA16E3743_403874177.addTaint(taint);
            throw var9ECFF51269413FFE65CC631CA16E3743_403874177;
        } //End block
        holder = new Holder(new IssuerSerial(generateGeneralNames(name),
            new DERInteger(cert.getSerialNumber())));
        // ---------- Original Method ----------
        //X509Principal name;
        //try
        //{
            //name = PrincipalUtil.getIssuerX509Principal(cert);
        //}
        //catch (Exception e)
        //{
            //throw new CertificateParsingException(e.getMessage());
        //}
        //holder = new Holder(new IssuerSerial(generateGeneralNames(name),
            //new DERInteger(cert.getSerialNumber())));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.508 -0400", hash_original_method = "BB3F8ED7A12081786FFA678549853DD7", hash_generated_method = "9DAC6696A4355E038108E0ADFA13A2E4")
    public  AttributeCertificateHolder(X509Principal principal) {
        holder = new Holder(generateGeneralNames(principal));
        // ---------- Original Method ----------
        //holder = new Holder(generateGeneralNames(principal));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.508 -0400", hash_original_method = "8754A1CB9EC37CB6374A9BB4689D9463", hash_generated_method = "887D0050DF99D6E04954A122736E8C21")
    public  AttributeCertificateHolder(X500Principal principal) {
        this(X509Util.convertPrincipal(principal));
        addTaint(principal.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.509 -0400", hash_original_method = "058E2AA05CCDB81429F1E94E1527F7B6", hash_generated_method = "55B74FCEB90EE5EEEC66BDDDFBED7FE8")
    public  AttributeCertificateHolder(int digestedObjectType,
        String digestAlgorithm, String otherObjectTypeID, byte[] objectDigest) {
        holder = new Holder(new ObjectDigestInfo(digestedObjectType,
            otherObjectTypeID, new AlgorithmIdentifier(digestAlgorithm), Arrays
                .clone(objectDigest)));
        // ---------- Original Method ----------
        //holder = new Holder(new ObjectDigestInfo(digestedObjectType,
            //otherObjectTypeID, new AlgorithmIdentifier(digestAlgorithm), Arrays
                //.clone(objectDigest)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.509 -0400", hash_original_method = "5DC58025DAD5ABD5E5609ED391A96DAB", hash_generated_method = "9848D7B716DEEE0EE97BCEEBA001375E")
    public int getDigestedObjectType() {
        if(holder.getObjectDigestInfo() != null)        
        {
            int var98CEC5CB54B9CF5CAAAC5B29AAE60F6B_1077228626 = (holder.getObjectDigestInfo().getDigestedObjectType()
                .getValue().intValue());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1038589453 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1038589453;
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_2037983782 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_898181888 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_898181888;
        // ---------- Original Method ----------
        //if (holder.getObjectDigestInfo() != null)
        //{
            //return holder.getObjectDigestInfo().getDigestedObjectType()
                //.getValue().intValue();
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.510 -0400", hash_original_method = "44CC065F66E7FDD5B9E2538C14A00A59", hash_generated_method = "0C619CFC4FE8199AE5E317598253AA21")
    public String getDigestAlgorithm() {
        if(holder.getObjectDigestInfo() != null)        
        {
String var1E93A44C0555128AC5428CFBAFC67BD1_1087666713 =             holder.getObjectDigestInfo().getDigestAlgorithm().getObjectId()
                .getId();
            var1E93A44C0555128AC5428CFBAFC67BD1_1087666713.addTaint(taint);
            return var1E93A44C0555128AC5428CFBAFC67BD1_1087666713;
        } //End block
String var540C13E9E156B687226421B24F2DF178_854810999 =         null;
        var540C13E9E156B687226421B24F2DF178_854810999.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_854810999;
        // ---------- Original Method ----------
        //if (holder.getObjectDigestInfo() != null)
        //{
            //return holder.getObjectDigestInfo().getDigestAlgorithm().getObjectId()
                //.getId();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.510 -0400", hash_original_method = "4B9D866BC14850DF9DC3D05B3C536D79", hash_generated_method = "1C54D80950BA85AB9D704DF2A70F45A5")
    public byte[] getObjectDigest() {
        if(holder.getObjectDigestInfo() != null)        
        {
            byte[] varF3A3B800A0376B2AA79672C6DAF118C8_1070759998 = (holder.getObjectDigestInfo().getObjectDigest().getBytes());
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_504689467 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_504689467;
        } //End block
        byte[] var37A6259CC0C1DAE299A7866489DFF0BD_1645825770 = (null);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_568885108 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_568885108;
        // ---------- Original Method ----------
        //if (holder.getObjectDigestInfo() != null)
        //{
            //return holder.getObjectDigestInfo().getObjectDigest().getBytes();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.510 -0400", hash_original_method = "D91C38C78BDA175ED1B06895DD027E8A", hash_generated_method = "79D1EA989203DB1181EAB0596F52C7AC")
    public String getOtherObjectTypeID() {
        if(holder.getObjectDigestInfo() != null)        
        {
            holder.getObjectDigestInfo().getOtherObjectTypeID().getId();
        } //End block
String var540C13E9E156B687226421B24F2DF178_175141312 =         null;
        var540C13E9E156B687226421B24F2DF178_175141312.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_175141312;
        // ---------- Original Method ----------
        //if (holder.getObjectDigestInfo() != null)
        //{
            //holder.getObjectDigestInfo().getOtherObjectTypeID().getId();
        //}
        //return null;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.511 -0400", hash_original_method = "813AC8AE1843F5B7087E11CB016E8403", hash_generated_method = "AB618BE93A2853BC7E977047C425E02D")
    private GeneralNames generateGeneralNames(X509Principal principal) {
        addTaint(principal.getTaint());
GeneralNames var94B0934CB17A73A5ED7AD1B3F1523ADC_118188333 =         new GeneralNames(new DERSequence(new GeneralName(principal)));
        var94B0934CB17A73A5ED7AD1B3F1523ADC_118188333.addTaint(taint);
        return var94B0934CB17A73A5ED7AD1B3F1523ADC_118188333;
        // ---------- Original Method ----------
        //return new GeneralNames(new DERSequence(new GeneralName(principal)));
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.511 -0400", hash_original_method = "938EE7D821BB407EF13AE79847029298", hash_generated_method = "C070FC1AD0B3FBCB564245F06E60604D")
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
                        boolean varB326B5062B2F0E69046810717534CB09_472910182 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1154536374 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1154536374;
                    } //End block
                } //End block
                catch (IOException e)
                {
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_803364815 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_630910780 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_630910780;
        // ---------- Original Method ----------
        //GeneralName[] names = targets.getNames();
        //for (int i = 0; i != names.length; i++)
        //{
            //GeneralName gn = names[i];
            //if (gn.getTagNo() == GeneralName.directoryName)
            //{
                //try
                //{
                    //if (new X509Principal(((ASN1Encodable)gn.getName())
                        //.getEncoded()).equals(subject))
                    //{
                        //return true;
                    //}
                //}
                //catch (IOException e)
                //{
                //}
            //}
        //}
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.512 -0400", hash_original_method = "7552EC21B75F1C8319E3B7352977E9CE", hash_generated_method = "990F264A40A2AF0261158E97C4D5AC76")
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
                } //End block
                catch (IOException e)
                {
                    RuntimeException var4980AE888B424D26E0A3FAF1A1097229_1081086696 = new RuntimeException("badly formed Name object");
                    var4980AE888B424D26E0A3FAF1A1097229_1081086696.addTaint(taint);
                    throw var4980AE888B424D26E0A3FAF1A1097229_1081086696;
                } //End block
            } //End block
        } //End block
Object[] var6C26F6EC1F7A67F950053C95FE24CCE6_1861599678 =         l.toArray(new Object[l.size()]);
        var6C26F6EC1F7A67F950053C95FE24CCE6_1861599678.addTaint(taint);
        return var6C26F6EC1F7A67F950053C95FE24CCE6_1861599678;
        // ---------- Original Method ----------
        //List l = new ArrayList(names.length);
        //for (int i = 0; i != names.length; i++)
        //{
            //if (names[i].getTagNo() == GeneralName.directoryName)
            //{
                //try
                //{
                    //l.add(new X500Principal(
                        //((ASN1Encodable)names[i].getName()).getEncoded()));
                //}
                //catch (IOException e)
                //{
                    //throw new RuntimeException("badly formed Name object");
                //}
            //}
        //}
        //return l.toArray(new Object[l.size()]);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.513 -0400", hash_original_method = "2BE9B6F72BB32A06F2A43AB8DF17A2B5", hash_generated_method = "50296D2C1F9ACBB42A89F9A50CEA2511")
    private Principal[] getPrincipals(GeneralNames names) {
        addTaint(names.getTaint());
        Object[] p = this.getNames(names.getNames());
        List l = new ArrayList();
for(int i = 0;i != p.length;i++)
        {
            if(p[i] instanceof Principal)            
            {
                l.add(p[i]);
            } //End block
        } //End block
Principal[] var2BC6CB15026C258E2509F6CFCF0FEAB1_1514026092 =         (Principal[])l.toArray(new Principal[l.size()]);
        var2BC6CB15026C258E2509F6CFCF0FEAB1_1514026092.addTaint(taint);
        return var2BC6CB15026C258E2509F6CFCF0FEAB1_1514026092;
        // ---------- Original Method ----------
        //Object[] p = this.getNames(names.getNames());
        //List l = new ArrayList();
        //for (int i = 0; i != p.length; i++)
        //{
            //if (p[i] instanceof Principal)
            //{
                //l.add(p[i]);
            //}
        //}
        //return (Principal[])l.toArray(new Principal[l.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.514 -0400", hash_original_method = "DB0C376D8871308D29988D3B3AAF17FC", hash_generated_method = "D1F953FA55DCB998E3767D1F99EB0A71")
    public Principal[] getEntityNames() {
        if(holder.getEntityName() != null)        
        {
Principal[] varDFC31D129B04B241822A136DF77C702E_772523363 =             getPrincipals(holder.getEntityName());
            varDFC31D129B04B241822A136DF77C702E_772523363.addTaint(taint);
            return varDFC31D129B04B241822A136DF77C702E_772523363;
        } //End block
Principal[] var540C13E9E156B687226421B24F2DF178_629255105 =         null;
        var540C13E9E156B687226421B24F2DF178_629255105.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_629255105;
        // ---------- Original Method ----------
        //if (holder.getEntityName() != null)
        //{
            //return getPrincipals(holder.getEntityName());
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.514 -0400", hash_original_method = "4F5AD36C2F60574BEE36BBEC8A3F8872", hash_generated_method = "FAAFCAF46E55042A1D25A070D6D57612")
    public Principal[] getIssuer() {
        if(holder.getBaseCertificateID() != null)        
        {
Principal[] varAA7DA35A79C7F874F57357A5F83F9BF0_1844065138 =             getPrincipals(holder.getBaseCertificateID().getIssuer());
            varAA7DA35A79C7F874F57357A5F83F9BF0_1844065138.addTaint(taint);
            return varAA7DA35A79C7F874F57357A5F83F9BF0_1844065138;
        } //End block
Principal[] var540C13E9E156B687226421B24F2DF178_259250998 =         null;
        var540C13E9E156B687226421B24F2DF178_259250998.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_259250998;
        // ---------- Original Method ----------
        //if (holder.getBaseCertificateID() != null)
        //{
            //return getPrincipals(holder.getBaseCertificateID().getIssuer());
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.515 -0400", hash_original_method = "6708CF3972ED2FC7BE75744CEC7FD162", hash_generated_method = "79686F6B3DBE1BC84A54B1AF7B1E2BBC")
    public BigInteger getSerialNumber() {
        if(holder.getBaseCertificateID() != null)        
        {
BigInteger var0366267DB5B10F5EB62E9812B64E09EA_1120185350 =             holder.getBaseCertificateID().getSerial().getValue();
            var0366267DB5B10F5EB62E9812B64E09EA_1120185350.addTaint(taint);
            return var0366267DB5B10F5EB62E9812B64E09EA_1120185350;
        } //End block
BigInteger var540C13E9E156B687226421B24F2DF178_1461272040 =         null;
        var540C13E9E156B687226421B24F2DF178_1461272040.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1461272040;
        // ---------- Original Method ----------
        //if (holder.getBaseCertificateID() != null)
        //{
            //return holder.getBaseCertificateID().getSerial().getValue();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.515 -0400", hash_original_method = "53037C58AFDDBA87577A0806677CF7E3", hash_generated_method = "039C3941169B65BEF4AC179A9735AF7E")
    public Object clone() {
Object varEAE8D4E202CC08FFA1C38E04DB4DFE1D_268844548 =         new AttributeCertificateHolder((ASN1Sequence)holder
            .toASN1Object());
        varEAE8D4E202CC08FFA1C38E04DB4DFE1D_268844548.addTaint(taint);
        return varEAE8D4E202CC08FFA1C38E04DB4DFE1D_268844548;
        // ---------- Original Method ----------
        //return new AttributeCertificateHolder((ASN1Sequence)holder
            //.toASN1Object());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.516 -0400", hash_original_method = "656B19C882F86A200CE16DF3E12BB617", hash_generated_method = "0C83DC3EA73ED73ADD7FB461B07A738F")
    public boolean match(Certificate cert) {
        addTaint(cert.getTaint());
        if(!(cert instanceof X509Certificate))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1559146288 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1520718 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1520718;
        } //End block
        X509Certificate x509Cert = (X509Certificate)cert;
        try 
        {
            if(holder.getBaseCertificateID() != null)            
            {
                boolean varC0DE036F21A6D0715FDF8D49DE39C36F_162431215 = (holder.getBaseCertificateID().getSerial().getValue().equals(x509Cert.getSerialNumber())
                    && matchesDN(PrincipalUtil.getIssuerX509Principal(x509Cert), holder.getBaseCertificateID().getIssuer()));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_85985178 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_85985178;
            } //End block
            if(holder.getEntityName() != null)            
            {
                if(matchesDN(PrincipalUtil.getSubjectX509Principal(x509Cert),
                    holder.getEntityName()))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1579261331 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1352911891 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1352911891;
                } //End block
            } //End block
            if(holder.getObjectDigestInfo() != null)            
            {
                MessageDigest md = null;
                try 
                {
                    md = MessageDigest.getInstance(getDigestAlgorithm(), "BC");
                } //End block
                catch (Exception e)
                {
                    boolean var68934A3E9455FA72420237EB05902327_1135371818 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2111088991 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2111088991;
                } //End block
switch(getDigestedObjectType()){
                case ObjectDigestInfo.publicKey:
                md.update(cert.getPublicKey().getEncoded());
                break;
                case ObjectDigestInfo.publicKeyCert:
                md.update(cert.getEncoded());
                break;
}                if(!Arrays.areEqual(md.digest(), getObjectDigest()))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1339093279 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1583011999 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1583011999;
                } //End block
            } //End block
        } //End block
        catch (CertificateEncodingException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_306504452 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1910594878 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1910594878;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_643034558 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2095721419 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2095721419;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.517 -0400", hash_original_method = "DF0F926A4C6973AE80CA99906EB348D1", hash_generated_method = "AC7BF76D1C488C30E470D4644D149749")
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
        if(obj == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1282072012 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2014387271 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2014387271;
        } //End block
        if(!(obj instanceof AttributeCertificateHolder))        
        {
            boolean var68934A3E9455FA72420237EB05902327_2102796826 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_221530581 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_221530581;
        } //End block
        AttributeCertificateHolder other = (AttributeCertificateHolder)obj;
        boolean var375AF02C41746B5375B2A9E0F63FA517_762174629 = (this.holder.equals(other.holder));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1985747245 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1985747245;
        // ---------- Original Method ----------
        //if (obj == this)
        //{
            //return true;
        //}
        //if (!(obj instanceof AttributeCertificateHolder))
        //{
            //return false;
        //}
        //AttributeCertificateHolder other = (AttributeCertificateHolder)obj;
        //return this.holder.equals(other.holder);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.517 -0400", hash_original_method = "D89AAACD9C01672ED8F506F3741EB875", hash_generated_method = "FCE5BA8A6FF1BE9D86FFC196C7733CAA")
    public int hashCode() {
        int varAB1C3240F0D80F83C6A8B97E9553840F_1419678111 = (this.holder.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_803044985 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_803044985;
        // ---------- Original Method ----------
        //return this.holder.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.517 -0400", hash_original_method = "A87301CDB1806806ACAD029929062C9D", hash_generated_method = "5C845978DCE6217FE3C82E29CBDB278A")
    public boolean match(Object obj) {
        addTaint(obj.getTaint());
        if(!(obj instanceof X509Certificate))        
        {
            boolean var68934A3E9455FA72420237EB05902327_234858381 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_574947288 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_574947288;
        } //End block
        boolean varADA7754756F13D45E6E9A386DF7AABD4_1724859659 = (match((Certificate)obj));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1069408920 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1069408920;
        // ---------- Original Method ----------
        //if (!(obj instanceof X509Certificate))
        //{
            //return false;
        //}
        //return match((Certificate)obj);
    }

    
}

