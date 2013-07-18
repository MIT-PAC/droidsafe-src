package org.bouncycastle.x509;

// Droidsafe Imports
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.x509.AttributeCertificate;
import org.bouncycastle.asn1.x509.X509Extension;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.util.Arrays;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class X509V2AttributeCertificate implements X509AttributeCertificate {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.652 -0400", hash_original_field = "B6BA9FA6EA18201BF39EA635ECCA9F13", hash_generated_field = "AFD6C6D10463457A355EBA6B8E3CE0C1")

    private AttributeCertificate cert;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.652 -0400", hash_original_field = "CF2C84750B842AAA309ECBA4D79FF935", hash_generated_field = "E3E827D7CD2761B5AB55619FED686D61")

    private Date notBefore;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.652 -0400", hash_original_field = "21F1BA3A4A4A624D712B87C23B2FD95A", hash_generated_field = "9EC5214487C0E45ED3A209D46FF5E8A8")

    private Date notAfter;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.652 -0400", hash_original_method = "511310A6550A73E5129DCD139E553E6F", hash_generated_method = "9D241BD538D3E85FC626B5E474C72E96")
    public  X509V2AttributeCertificate(
        InputStream encIn) throws IOException {
        this(getObject(encIn));
        addTaint(encIn.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.653 -0400", hash_original_method = "B127BB0A829E4BFD3E32578437EC0EFB", hash_generated_method = "E92DBB19F0205A89A7C109AE87861EB8")
    public  X509V2AttributeCertificate(
        byte[]  encoded) throws IOException {
        this(new ByteArrayInputStream(encoded));
        addTaint(encoded[0]);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.654 -0400", hash_original_method = "FF0916A499ED21133E7F47C29CF6DD83", hash_generated_method = "E03C5E6C65ACBB6513A12AAF6C67AA95")
      X509V2AttributeCertificate(
        AttributeCertificate    cert) throws IOException {
        this.cert = cert;
        try 
        {
            this.notAfter = cert.getAcinfo().getAttrCertValidityPeriod().getNotAfterTime().getDate();
            this.notBefore = cert.getAcinfo().getAttrCertValidityPeriod().getNotBeforeTime().getDate();
        } //End block
        catch (ParseException e)
        {
            IOException varC1BA3209BAE5B8CA7BFDF119BC403478_1409267006 = new IOException("invalid data structure in certificate!");
            varC1BA3209BAE5B8CA7BFDF119BC403478_1409267006.addTaint(taint);
            throw varC1BA3209BAE5B8CA7BFDF119BC403478_1409267006;
        } //End block
        // ---------- Original Method ----------
        //this.cert = cert;
        //try
        //{
            //this.notAfter = cert.getAcinfo().getAttrCertValidityPeriod().getNotAfterTime().getDate();
            //this.notBefore = cert.getAcinfo().getAttrCertValidityPeriod().getNotBeforeTime().getDate();
        //}
        //catch (ParseException e)
        //{
            //throw new IOException("invalid data structure in certificate!");
        //}
    }

    
    private static AttributeCertificate getObject(InputStream in) throws IOException {
        try
        {
            return AttributeCertificate.getInstance(new ASN1InputStream(in).readObject());
        }
        catch (IOException e)
        {
            throw e;
        }
        catch (Exception e)
        {
            throw new IOException("exception decoding certificate structure: " + e.toString());
        }
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.655 -0400", hash_original_method = "5FE4A45F92CB5E44CD6499FACBF2EDEC", hash_generated_method = "41F367D8F0B40C4B77CF30CF71D95B39")
    public int getVersion() {
        int var4E8B66C4A10620033DD79EF2C68C3083_972439837 = (cert.getAcinfo().getVersion().getValue().intValue() + 1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1532881901 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1532881901;
        // ---------- Original Method ----------
        //return cert.getAcinfo().getVersion().getValue().intValue() + 1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.656 -0400", hash_original_method = "6D79F8D94B9C23855CFDC1454EEDA264", hash_generated_method = "66A806831BD41307E762BBB94EC07EC8")
    public BigInteger getSerialNumber() {
BigInteger var43AC8A4565A41B5EB17BDD5D5A0D5BAE_1923612221 =         cert.getAcinfo().getSerialNumber().getValue();
        var43AC8A4565A41B5EB17BDD5D5A0D5BAE_1923612221.addTaint(taint);
        return var43AC8A4565A41B5EB17BDD5D5A0D5BAE_1923612221;
        // ---------- Original Method ----------
        //return cert.getAcinfo().getSerialNumber().getValue();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.656 -0400", hash_original_method = "020DE1897FEFE364249BEA87F131F85A", hash_generated_method = "052255B3C868B507C79E71E3BE3C7491")
    public AttributeCertificateHolder getHolder() {
AttributeCertificateHolder var336F45E28D4701CDE944B493291DA9B6_8311050 =         new AttributeCertificateHolder((ASN1Sequence)cert.getAcinfo().getHolder().toASN1Object());
        var336F45E28D4701CDE944B493291DA9B6_8311050.addTaint(taint);
        return var336F45E28D4701CDE944B493291DA9B6_8311050;
        // ---------- Original Method ----------
        //return new AttributeCertificateHolder((ASN1Sequence)cert.getAcinfo().getHolder().toASN1Object());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.657 -0400", hash_original_method = "BBF141CF5A1E02D76A470DA06D7E0741", hash_generated_method = "BC3B69C04D8800A353FEA7BC1E04EBDA")
    public AttributeCertificateIssuer getIssuer() {
AttributeCertificateIssuer var72990C4D367DCACD011502DE16918243_1308892206 =         new AttributeCertificateIssuer(cert.getAcinfo().getIssuer());
        var72990C4D367DCACD011502DE16918243_1308892206.addTaint(taint);
        return var72990C4D367DCACD011502DE16918243_1308892206;
        // ---------- Original Method ----------
        //return new AttributeCertificateIssuer(cert.getAcinfo().getIssuer());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.657 -0400", hash_original_method = "CB2A2B3C356F1AD47950BB2253ACA4BD", hash_generated_method = "42CDE27BC0BA24EC2BB48801B028924A")
    public Date getNotBefore() {
Date varA538B0CD17616FA44CA9B918B38CAEAC_934318256 =         notBefore;
        varA538B0CD17616FA44CA9B918B38CAEAC_934318256.addTaint(taint);
        return varA538B0CD17616FA44CA9B918B38CAEAC_934318256;
        // ---------- Original Method ----------
        //return notBefore;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.658 -0400", hash_original_method = "9EADF7E1E76408811693CE379F621727", hash_generated_method = "BCC12D32A2648126DAFF5AB9E3ECD1B9")
    public Date getNotAfter() {
Date varE84253AB2AD08AA2E1E3A8582D622350_280475916 =         notAfter;
        varE84253AB2AD08AA2E1E3A8582D622350_280475916.addTaint(taint);
        return varE84253AB2AD08AA2E1E3A8582D622350_280475916;
        // ---------- Original Method ----------
        //return notAfter;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.658 -0400", hash_original_method = "9BC89181E6C1277EBE257648E61E1A79", hash_generated_method = "72B6C64FF65B095BF430A08B45B67296")
    public boolean[] getIssuerUniqueID() {
        DERBitString id = cert.getAcinfo().getIssuerUniqueID();
        if(id != null)        
        {
            byte[] bytes = id.getBytes();
            boolean[] boolId = new boolean[bytes.length * 8 - id.getPadBits()];
for(int i = 0;i != boolId.length;i++)
            {
                boolId[i] = (bytes[i / 8] & (0x80 >>> (i % 8))) != 0;
            } //End block
            boolean[] var4A5DB2081F0F1D8AF8488C7FB77CEE4C_2106616749 = (boolId);
                        boolean[] var503EB2F420079C4024483971CE5EDEA8_1234329250 = {getTaintBoolean()};
            return var503EB2F420079C4024483971CE5EDEA8_1234329250;
        } //End block
        boolean[] var37A6259CC0C1DAE299A7866489DFF0BD_371384625 = (null);
                boolean[] var503EB2F420079C4024483971CE5EDEA8_1458921655 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_1458921655;
        // ---------- Original Method ----------
        //DERBitString    id = cert.getAcinfo().getIssuerUniqueID();
        //if (id != null)
        //{
            //byte[]          bytes = id.getBytes();
            //boolean[]       boolId = new boolean[bytes.length * 8 - id.getPadBits()];
            //for (int i = 0; i != boolId.length; i++)
            //{
                //boolId[i] = (bytes[i / 8] & (0x80 >>> (i % 8))) != 0;
            //}
            //return boolId;
        //}
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.659 -0400", hash_original_method = "21EA5C7301B68DB7B0091D4882BC7F7A", hash_generated_method = "3AF3691FECB84D9AA63CDDD8C60E66DF")
    public void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
        this.checkValidity(new Date());
        // ---------- Original Method ----------
        //this.checkValidity(new Date());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.659 -0400", hash_original_method = "C7ABADDDE42159C03B4715171CE7A75D", hash_generated_method = "E75834752AB2F309417332E87CE0185B")
    public void checkValidity(
        Date    date) throws CertificateExpiredException, CertificateNotYetValidException {
        addTaint(date.getTaint());
        if(date.after(this.getNotAfter()))        
        {
            CertificateExpiredException var8321D7DDF755530E28A48CBE0206DFA2_35801519 = new CertificateExpiredException("certificate expired on " + this.getNotAfter());
            var8321D7DDF755530E28A48CBE0206DFA2_35801519.addTaint(taint);
            throw var8321D7DDF755530E28A48CBE0206DFA2_35801519;
        } //End block
        if(date.before(this.getNotBefore()))        
        {
            CertificateNotYetValidException varBAB6E1077747042EEC7FE0920CF70711_784838747 = new CertificateNotYetValidException("certificate not valid till " + this.getNotBefore());
            varBAB6E1077747042EEC7FE0920CF70711_784838747.addTaint(taint);
            throw varBAB6E1077747042EEC7FE0920CF70711_784838747;
        } //End block
        // ---------- Original Method ----------
        //if (date.after(this.getNotAfter()))
        //{
            //throw new CertificateExpiredException("certificate expired on " + this.getNotAfter());
        //}
        //if (date.before(this.getNotBefore()))
        //{
            //throw new CertificateNotYetValidException("certificate not valid till " + this.getNotBefore());
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.660 -0400", hash_original_method = "12695EBC2BF1A0C9FFF47E032B23EFDD", hash_generated_method = "C98FE6B9DB57E01C6001445331E6C6CC")
    public byte[] getSignature() {
        byte[] varDC30B2104BFC33C4C4BCAE06CE1BCD2C_1345228150 = (cert.getSignatureValue().getBytes());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1671690825 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1671690825;
        // ---------- Original Method ----------
        //return cert.getSignatureValue().getBytes();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.660 -0400", hash_original_method = "00EE60C525B48F0703DB78FF90B15573", hash_generated_method = "94C2E7827CBC84A034C251CEBBB24018")
    public final void verify(
            PublicKey   key,
            String      provider) throws CertificateException, NoSuchAlgorithmException,
            InvalidKeyException, NoSuchProviderException, SignatureException {
        addTaint(provider.getTaint());
        addTaint(key.getTaint());
        Signature signature = null;
        if(!cert.getSignatureAlgorithm().equals(cert.getAcinfo().getSignature()))        
        {
            CertificateException varBE7597EE386BCF698BCD948E855CA179_2007610407 = new CertificateException("Signature algorithm in certificate info not same as outer certificate");
            varBE7597EE386BCF698BCD948E855CA179_2007610407.addTaint(taint);
            throw varBE7597EE386BCF698BCD948E855CA179_2007610407;
        } //End block
        signature = Signature.getInstance(cert.getSignatureAlgorithm().getObjectId().getId(), provider);
        signature.initVerify(key);
        try 
        {
            signature.update(cert.getAcinfo().getEncoded());
        } //End block
        catch (IOException e)
        {
            SignatureException var230E7A8376E426DA6302BD52234F94AB_1348448103 = new SignatureException("Exception encoding certificate info object");
            var230E7A8376E426DA6302BD52234F94AB_1348448103.addTaint(taint);
            throw var230E7A8376E426DA6302BD52234F94AB_1348448103;
        } //End block
        if(!signature.verify(this.getSignature()))        
        {
            InvalidKeyException var790C5BE5F1B136693BEA538FF203D7A7_283821437 = new InvalidKeyException("Public key presented not for certificate signature");
            var790C5BE5F1B136693BEA538FF203D7A7_283821437.addTaint(taint);
            throw var790C5BE5F1B136693BEA538FF203D7A7_283821437;
        } //End block
        // ---------- Original Method ----------
        //Signature   signature = null;
        //if (!cert.getSignatureAlgorithm().equals(cert.getAcinfo().getSignature()))
        //{
            //throw new CertificateException("Signature algorithm in certificate info not same as outer certificate");
        //}
        //signature = Signature.getInstance(cert.getSignatureAlgorithm().getObjectId().getId(), provider);
        //signature.initVerify(key);
        //try
        //{
            //signature.update(cert.getAcinfo().getEncoded());
        //}
        //catch (IOException e)
        //{
            //throw new SignatureException("Exception encoding certificate info object");
        //}
        //if (!signature.verify(this.getSignature()))
        //{
            //throw new InvalidKeyException("Public key presented not for certificate signature");
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.661 -0400", hash_original_method = "C092EBBC5365A2A25EF301186F9FC908", hash_generated_method = "5BD124F61C7F09BAF41A52F4B21B5510")
    public byte[] getEncoded() throws IOException {
        byte[] var278DC746E248A5EB445BFA5A005B6DAD_14714148 = (cert.getEncoded());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1077257346 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1077257346;
        // ---------- Original Method ----------
        //return cert.getEncoded();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.661 -0400", hash_original_method = "174EB6531B05B4A912F07FC1EA279D8F", hash_generated_method = "EE366FAACDDD4CE52AE40C5F5CB5E225")
    public byte[] getExtensionValue(String oid) {
        addTaint(oid.getTaint());
        X509Extensions extensions = cert.getAcinfo().getExtensions();
        if(extensions != null)        
        {
            X509Extension ext = extensions.getExtension(new DERObjectIdentifier(oid));
            if(ext != null)            
            {
                try 
                {
                    byte[] var1216C1E23457BA62F2C4037C70A6B09D_166619975 = (ext.getValue().getEncoded(ASN1Encodable.DER));
                                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2134705395 = {getTaintByte()};
                    return var2F9C81BC6E497382285CD6B7A7E33DE1_2134705395;
                } //End block
                catch (Exception e)
                {
                    RuntimeException var39301DABEFF44FB16DD446A44E6DB328_1642734720 = new RuntimeException("error encoding " + e.toString());
                    var39301DABEFF44FB16DD446A44E6DB328_1642734720.addTaint(taint);
                    throw var39301DABEFF44FB16DD446A44E6DB328_1642734720;
                } //End block
            } //End block
        } //End block
        byte[] var37A6259CC0C1DAE299A7866489DFF0BD_1418869184 = (null);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1477162995 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1477162995;
        // ---------- Original Method ----------
        //X509Extensions  extensions = cert.getAcinfo().getExtensions();
        //if (extensions != null)
        //{
            //X509Extension   ext = extensions.getExtension(new DERObjectIdentifier(oid));
            //if (ext != null)
            //{
                //try
                //{
                    //return ext.getValue().getEncoded(ASN1Encodable.DER);
                //}
                //catch (Exception e)
                //{
                    //throw new RuntimeException("error encoding " + e.toString());
                //}
            //}
        //}
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.662 -0400", hash_original_method = "EEE6D6FB39ABCE0441C4E0B5FB99D1CC", hash_generated_method = "4EED2854F3979345702525A7EAE0A55E")
    private Set getExtensionOIDs(
        boolean critical) {
        addTaint(critical);
        X509Extensions extensions = cert.getAcinfo().getExtensions();
        if(extensions != null)        
        {
            Set set = new HashSet();
            Enumeration e = extensions.oids();
            while
(e.hasMoreElements())            
            {
                DERObjectIdentifier oid = (DERObjectIdentifier)e.nextElement();
                X509Extension ext = extensions.getExtension(oid);
                if(ext.isCritical() == critical)                
                {
                    set.add(oid.getId());
                } //End block
            } //End block
Set varD2D4612E029977363A9BBEBD4F0339C0_1636828454 =             set;
            varD2D4612E029977363A9BBEBD4F0339C0_1636828454.addTaint(taint);
            return varD2D4612E029977363A9BBEBD4F0339C0_1636828454;
        } //End block
Set var540C13E9E156B687226421B24F2DF178_831078145 =         null;
        var540C13E9E156B687226421B24F2DF178_831078145.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_831078145;
        // ---------- Original Method ----------
        //X509Extensions  extensions = cert.getAcinfo().getExtensions();
        //if (extensions != null)
        //{
            //Set             set = new HashSet();
            //Enumeration     e = extensions.oids();
            //while (e.hasMoreElements())
            //{
                //DERObjectIdentifier oid = (DERObjectIdentifier)e.nextElement();
                //X509Extension       ext = extensions.getExtension(oid);
                //if (ext.isCritical() == critical)
                //{
                    //set.add(oid.getId());
                //}
            //}
            //return set;
        //}
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.662 -0400", hash_original_method = "5436A1880A3E8EACEF801692C5DC1E5D", hash_generated_method = "CAD383B70B1EBE7AF752E8F45DFD736A")
    public Set getNonCriticalExtensionOIDs() {
Set varDAA631B96E7028A88F1555BCE067AB3B_1962773462 =         getExtensionOIDs(false);
        varDAA631B96E7028A88F1555BCE067AB3B_1962773462.addTaint(taint);
        return varDAA631B96E7028A88F1555BCE067AB3B_1962773462;
        // ---------- Original Method ----------
        //return getExtensionOIDs(false);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.663 -0400", hash_original_method = "95A4F309A27080538E4E315B4E15DBCF", hash_generated_method = "D28A81C1337BC08107C34C5F4B6AF6BF")
    public Set getCriticalExtensionOIDs() {
Set var61C7CCCBDE12C3C494EB17A5AF30EFF5_558807045 =         getExtensionOIDs(true);
        var61C7CCCBDE12C3C494EB17A5AF30EFF5_558807045.addTaint(taint);
        return var61C7CCCBDE12C3C494EB17A5AF30EFF5_558807045;
        // ---------- Original Method ----------
        //return getExtensionOIDs(true);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.663 -0400", hash_original_method = "DC43BBF9B96B5410825BE22446F9B294", hash_generated_method = "7899F9608643AF6D007101C60E8F28CD")
    public boolean hasUnsupportedCriticalExtension() {
        Set extensions = getCriticalExtensionOIDs();
        boolean var0DDBD6B5C2CA09291C57708CABDB7901_217280736 = (extensions != null && !extensions.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1101800602 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1101800602;
        // ---------- Original Method ----------
        //Set  extensions = getCriticalExtensionOIDs();
        //return extensions != null && !extensions.isEmpty();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.663 -0400", hash_original_method = "D9A39E0FBB510DE2D7B256831A61B9D2", hash_generated_method = "2EDBB5B5377300F53AC68DF6A99FF9EF")
    public X509Attribute[] getAttributes() {
        ASN1Sequence seq = cert.getAcinfo().getAttributes();
        X509Attribute[] attrs = new X509Attribute[seq.size()];
for(int i = 0;i != seq.size();i++)
        {
            attrs[i] = new X509Attribute((ASN1Encodable)seq.getObjectAt(i));
        } //End block
X509Attribute[] varBFF3B3B688186C8D554F24EB09DDFCD8_1829332279 =         attrs;
        varBFF3B3B688186C8D554F24EB09DDFCD8_1829332279.addTaint(taint);
        return varBFF3B3B688186C8D554F24EB09DDFCD8_1829332279;
        // ---------- Original Method ----------
        //ASN1Sequence    seq = cert.getAcinfo().getAttributes();
        //X509Attribute[] attrs = new X509Attribute[seq.size()];
        //for (int i = 0; i != seq.size(); i++)
        //{
            //attrs[i] = new X509Attribute((ASN1Encodable)seq.getObjectAt(i));
        //}
        //return attrs;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.664 -0400", hash_original_method = "1BDF84262F391CC05FF0C51BDEDDB7BE", hash_generated_method = "1147D3A19F3F2B0B92FBAF12AA071E00")
    public X509Attribute[] getAttributes(String oid) {
        addTaint(oid.getTaint());
        ASN1Sequence seq = cert.getAcinfo().getAttributes();
        List list = new ArrayList();
for(int i = 0;i != seq.size();i++)
        {
            X509Attribute attr = new X509Attribute((ASN1Encodable)seq.getObjectAt(i));
            if(attr.getOID().equals(oid))            
            {
                list.add(attr);
            } //End block
        } //End block
        if(list.size() == 0)        
        {
X509Attribute[] var540C13E9E156B687226421B24F2DF178_536224581 =             null;
            var540C13E9E156B687226421B24F2DF178_536224581.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_536224581;
        } //End block
X509Attribute[] var63F2E0457D22DCF73C216E8E61B0DF27_2099267490 =         (X509Attribute[])list.toArray(new X509Attribute[list.size()]);
        var63F2E0457D22DCF73C216E8E61B0DF27_2099267490.addTaint(taint);
        return var63F2E0457D22DCF73C216E8E61B0DF27_2099267490;
        // ---------- Original Method ----------
        //ASN1Sequence    seq = cert.getAcinfo().getAttributes();
        //List            list = new ArrayList();
        //for (int i = 0; i != seq.size(); i++)
        //{
            //X509Attribute attr = new X509Attribute((ASN1Encodable)seq.getObjectAt(i));
            //if (attr.getOID().equals(oid))
            //{
                //list.add(attr);
            //}
        //}
        //if (list.size() == 0)
        //{
            //return null;
        //}
        //return (X509Attribute[])list.toArray(new X509Attribute[list.size()]);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.664 -0400", hash_original_method = "60181B32C72761B75B31B405BBC4804E", hash_generated_method = "83AB4E2C67C48CF3B9DE5E70E2F02F34")
    public boolean equals(
        Object o) {
        addTaint(o.getTaint());
        if(o == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_365567639 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1139832736 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1139832736;
        } //End block
        if(!(o instanceof X509AttributeCertificate))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1317800848 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_98028075 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_98028075;
        } //End block
        X509AttributeCertificate other = (X509AttributeCertificate)o;
        try 
        {
            byte[] b1 = this.getEncoded();
            byte[] b2 = other.getEncoded();
            boolean varA9253B57462EB0F87337AB10E45046ED_746320998 = (Arrays.areEqual(b1, b2));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_303681806 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_303681806;
        } //End block
        catch (IOException e)
        {
            boolean var68934A3E9455FA72420237EB05902327_482359790 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1201052095 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1201052095;
        } //End block
        // ---------- Original Method ----------
        //if (o == this)
        //{
            //return true;
        //}
        //if (!(o instanceof X509AttributeCertificate))
        //{
            //return false;
        //}
        //X509AttributeCertificate other = (X509AttributeCertificate)o;
        //try
        //{
            //byte[] b1 = this.getEncoded();
            //byte[] b2 = other.getEncoded();
            //return Arrays.areEqual(b1, b2);
        //}
        //catch (IOException e)
        //{
            //return false;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.664 -0400", hash_original_method = "C5506CF7B2024CB4E09A9FBA2D111DDF", hash_generated_method = "C2220DF6A682B03446ABCAB55E261D94")
    public int hashCode() {
        try 
        {
            int varF6784AEA8779C25BE2814C07943D9778_586445096 = (Arrays.hashCode(this.getEncoded()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_863196624 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_863196624;
        } //End block
        catch (IOException e)
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_643285766 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1975851696 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1975851696;
        } //End block
        // ---------- Original Method ----------
        //try
        //{
            //return Arrays.hashCode(this.getEncoded());
        //}
        //catch (IOException e)
        //{
            //return 0;
        //}
    }

    
}

