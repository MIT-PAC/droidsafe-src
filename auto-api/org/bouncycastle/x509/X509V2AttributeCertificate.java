package org.bouncycastle.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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

public class X509V2AttributeCertificate implements X509AttributeCertificate {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.588 -0400", hash_original_field = "B6BA9FA6EA18201BF39EA635ECCA9F13", hash_generated_field = "AFD6C6D10463457A355EBA6B8E3CE0C1")

    private AttributeCertificate cert;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.588 -0400", hash_original_field = "CF2C84750B842AAA309ECBA4D79FF935", hash_generated_field = "E3E827D7CD2761B5AB55619FED686D61")

    private Date notBefore;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.588 -0400", hash_original_field = "21F1BA3A4A4A624D712B87C23B2FD95A", hash_generated_field = "9EC5214487C0E45ED3A209D46FF5E8A8")

    private Date notAfter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.589 -0400", hash_original_method = "511310A6550A73E5129DCD139E553E6F", hash_generated_method = "9D241BD538D3E85FC626B5E474C72E96")
    public  X509V2AttributeCertificate(
        InputStream encIn) throws IOException {
        this(getObject(encIn));
        addTaint(encIn.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.589 -0400", hash_original_method = "B127BB0A829E4BFD3E32578437EC0EFB", hash_generated_method = "E92DBB19F0205A89A7C109AE87861EB8")
    public  X509V2AttributeCertificate(
        byte[]  encoded) throws IOException {
        this(new ByteArrayInputStream(encoded));
        addTaint(encoded[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.589 -0400", hash_original_method = "FF0916A499ED21133E7F47C29CF6DD83", hash_generated_method = "85374A83E60650397C2B972244A25E21")
      X509V2AttributeCertificate(
        AttributeCertificate    cert) throws IOException {
        this.cert = cert;
        try 
        {
            this.notAfter = cert.getAcinfo().getAttrCertValidityPeriod().getNotAfterTime().getDate();
            this.notBefore = cert.getAcinfo().getAttrCertValidityPeriod().getNotBeforeTime().getDate();
        } 
        catch (ParseException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("invalid data structure in certificate!");
        } 
        
        
        
        
            
            
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.590 -0400", hash_original_method = "5FE4A45F92CB5E44CD6499FACBF2EDEC", hash_generated_method = "21B4065F6A95606684AC923FE7D525A6")
    public int getVersion() {
        int var43188AF0ED861B053ED9493C9D018178_1450463849 = (cert.getAcinfo().getVersion().getValue().intValue() + 1);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1505279167 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1505279167;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.590 -0400", hash_original_method = "6D79F8D94B9C23855CFDC1454EEDA264", hash_generated_method = "3FE7696328CA9A08D5DF612C33D0F189")
    public BigInteger getSerialNumber() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1338931858 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1338931858 = cert.getAcinfo().getSerialNumber().getValue();
        varB4EAC82CA7396A68D541C85D26508E83_1338931858.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1338931858;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.591 -0400", hash_original_method = "020DE1897FEFE364249BEA87F131F85A", hash_generated_method = "2B5C4E0DA0926CD2D3F81327A903434B")
    public AttributeCertificateHolder getHolder() {
        AttributeCertificateHolder varB4EAC82CA7396A68D541C85D26508E83_1611584300 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1611584300 = new AttributeCertificateHolder((ASN1Sequence)cert.getAcinfo().getHolder().toASN1Object());
        varB4EAC82CA7396A68D541C85D26508E83_1611584300.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1611584300;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.592 -0400", hash_original_method = "BBF141CF5A1E02D76A470DA06D7E0741", hash_generated_method = "E2F7FEB69563AFB9BEB2D15A43434F72")
    public AttributeCertificateIssuer getIssuer() {
        AttributeCertificateIssuer varB4EAC82CA7396A68D541C85D26508E83_368049127 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_368049127 = new AttributeCertificateIssuer(cert.getAcinfo().getIssuer());
        varB4EAC82CA7396A68D541C85D26508E83_368049127.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_368049127;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.592 -0400", hash_original_method = "CB2A2B3C356F1AD47950BB2253ACA4BD", hash_generated_method = "67E5703500D61F17BF1F8BB90A1A7129")
    public Date getNotBefore() {
        Date varB4EAC82CA7396A68D541C85D26508E83_1143907297 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1143907297 = notBefore;
        varB4EAC82CA7396A68D541C85D26508E83_1143907297.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1143907297;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.593 -0400", hash_original_method = "9EADF7E1E76408811693CE379F621727", hash_generated_method = "3C346232A47A5BC1F630DA4217F5050B")
    public Date getNotAfter() {
        Date varB4EAC82CA7396A68D541C85D26508E83_1253085301 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1253085301 = notAfter;
        varB4EAC82CA7396A68D541C85D26508E83_1253085301.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1253085301;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.593 -0400", hash_original_method = "9BC89181E6C1277EBE257648E61E1A79", hash_generated_method = "34408CDB0D159172EE8C3F4805B1A8AC")
    public boolean[] getIssuerUniqueID() {
        DERBitString id = cert.getAcinfo().getIssuerUniqueID();
        {
            byte[] bytes = id.getBytes();
            boolean[] boolId = new boolean[bytes.length * 8 - id.getPadBits()];
            {
                int i = 0;
                {
                    boolId[i] = (bytes[i / 8] & (0x80 >>> (i % 8))) != 0;
                } 
            } 
        } 
        boolean[] var503EB2F420079C4024483971CE5EDEA8_427961568 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_427961568;
        
        
        
        
            
            
            
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.594 -0400", hash_original_method = "21EA5C7301B68DB7B0091D4882BC7F7A", hash_generated_method = "3AF3691FECB84D9AA63CDDD8C60E66DF")
    public void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
        this.checkValidity(new Date());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.594 -0400", hash_original_method = "C7ABADDDE42159C03B4715171CE7A75D", hash_generated_method = "F25FB62A2CC4D63D341991794E3B109D")
    public void checkValidity(
        Date    date) throws CertificateExpiredException, CertificateNotYetValidException {
        {
            boolean var938055BAB3BA3D99176A733B2B72FD0A_948865427 = (date.after(this.getNotAfter()));
            {
                if (DroidSafeAndroidRuntime.control) throw new CertificateExpiredException("certificate expired on " + this.getNotAfter());
            } 
        } 
        {
            boolean var9E5357C476E1D269B0818F407DABDB7B_767268586 = (date.before(this.getNotBefore()));
            {
                if (DroidSafeAndroidRuntime.control) throw new CertificateNotYetValidException("certificate not valid till " + this.getNotBefore());
            } 
        } 
        addTaint(date.getTaint());
        
        
        
            
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.595 -0400", hash_original_method = "12695EBC2BF1A0C9FFF47E032B23EFDD", hash_generated_method = "3952E433F9C905467FDFC797E5AAE730")
    public byte[] getSignature() {
        byte[] varA590625ED1805BA8DD8751D4EA289962_847929739 = (cert.getSignatureValue().getBytes());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_25490241 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_25490241;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.595 -0400", hash_original_method = "00EE60C525B48F0703DB78FF90B15573", hash_generated_method = "EBAC1BB335E08E2D1B53A2551BBB1727")
    public final void verify(
            PublicKey   key,
            String      provider) throws CertificateException, NoSuchAlgorithmException,
            InvalidKeyException, NoSuchProviderException, SignatureException {
        Signature signature = null;
        {
            boolean var19446C785F6DBF82763E5AF35CF35767_608447446 = (!cert.getSignatureAlgorithm().equals(cert.getAcinfo().getSignature()));
            {
                if (DroidSafeAndroidRuntime.control) throw new CertificateException("Signature algorithm in certificate info not same as outer certificate");
            } 
        } 
        signature = Signature.getInstance(cert.getSignatureAlgorithm().getObjectId().getId(), provider);
        signature.initVerify(key);
        try 
        {
            signature.update(cert.getAcinfo().getEncoded());
        } 
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SignatureException("Exception encoding certificate info object");
        } 
        {
            boolean varC2CE6383A33B34726D848A5B5FF1E5AA_43133991 = (!signature.verify(this.getSignature()));
            {
                if (DroidSafeAndroidRuntime.control) throw new InvalidKeyException("Public key presented not for certificate signature");
            } 
        } 
        addTaint(key.getTaint());
        addTaint(provider.getTaint());
        
        
        
        
            
        
        
        
        
        
            
        
        
        
            
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.595 -0400", hash_original_method = "C092EBBC5365A2A25EF301186F9FC908", hash_generated_method = "E1178CE1FA0C6A0FA1FBD380D93D88D0")
    public byte[] getEncoded() throws IOException {
        byte[] var23DA858403631F55A5468B58A8F35F7A_18652245 = (cert.getEncoded());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1036524719 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1036524719;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.596 -0400", hash_original_method = "174EB6531B05B4A912F07FC1EA279D8F", hash_generated_method = "CCFCEAD866D018CD56CE4F7031AF16C2")
    public byte[] getExtensionValue(String oid) {
        X509Extensions extensions = cert.getAcinfo().getExtensions();
        {
            X509Extension ext = extensions.getExtension(new DERObjectIdentifier(oid));
            {
                try 
                {
                    byte[] var2207C2F4DEA9B59FFC3AA697A89C9510_1727732972 = (ext.getValue().getEncoded(ASN1Encodable.DER));
                } 
                catch (Exception e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException("error encoding " + e.toString());
                } 
            } 
        } 
        addTaint(oid.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1756163824 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1756163824;
        
        
        
        
            
            
            
                
                
                    
                
                
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.597 -0400", hash_original_method = "EEE6D6FB39ABCE0441C4E0B5FB99D1CC", hash_generated_method = "5DAE12B32925B7327289E6C21A94DA8F")
    private Set getExtensionOIDs(
        boolean critical) {
        Set varB4EAC82CA7396A68D541C85D26508E83_878641851 = null; 
        Set varB4EAC82CA7396A68D541C85D26508E83_220513866 = null; 
        X509Extensions extensions = cert.getAcinfo().getExtensions();
        {
            Set set = new HashSet();
            Enumeration e = extensions.oids();
            {
                boolean varE6301E07393E7C92A45A62612E875EEF_400950742 = (e.hasMoreElements());
                {
                    DERObjectIdentifier oid = (DERObjectIdentifier)e.nextElement();
                    X509Extension ext = extensions.getExtension(oid);
                    {
                        boolean var25B4D70B251BC642691C6F1F019085E5_1635841314 = (ext.isCritical() == critical);
                        {
                            set.add(oid.getId());
                        } 
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_878641851 = set;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_220513866 = null;
        addTaint(critical);
        Set varA7E53CE21691AB073D9660D615818899_676914863; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_676914863 = varB4EAC82CA7396A68D541C85D26508E83_878641851;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_676914863 = varB4EAC82CA7396A68D541C85D26508E83_220513866;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_676914863.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_676914863;
        
        
        
        
            
            
            
            
                
                
                
                
                    
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.597 -0400", hash_original_method = "5436A1880A3E8EACEF801692C5DC1E5D", hash_generated_method = "DB64C859B20E7B64D3204491526A373B")
    public Set getNonCriticalExtensionOIDs() {
        Set varB4EAC82CA7396A68D541C85D26508E83_685800005 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_685800005 = getExtensionOIDs(false);
        varB4EAC82CA7396A68D541C85D26508E83_685800005.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_685800005;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.598 -0400", hash_original_method = "95A4F309A27080538E4E315B4E15DBCF", hash_generated_method = "DD67AFEF51D22AB8F4847779D3610A5F")
    public Set getCriticalExtensionOIDs() {
        Set varB4EAC82CA7396A68D541C85D26508E83_1409939656 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1409939656 = getExtensionOIDs(true);
        varB4EAC82CA7396A68D541C85D26508E83_1409939656.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1409939656;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.598 -0400", hash_original_method = "DC43BBF9B96B5410825BE22446F9B294", hash_generated_method = "8407FC5D004772BBBFF89CFB690F583B")
    public boolean hasUnsupportedCriticalExtension() {
        Set extensions = getCriticalExtensionOIDs();
        boolean var4952DC1337533857B4886D4294445F8B_1947271721 = (extensions != null && !extensions.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_490270537 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_490270537;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.599 -0400", hash_original_method = "D9A39E0FBB510DE2D7B256831A61B9D2", hash_generated_method = "B31DB988B4D2944248021BF7CC71FAB6")
    public X509Attribute[] getAttributes() {
        X509Attribute[] varB4EAC82CA7396A68D541C85D26508E83_333332376 = null; 
        ASN1Sequence seq = cert.getAcinfo().getAttributes();
        X509Attribute[] attrs = new X509Attribute[seq.size()];
        {
            int i = 0;
            boolean varA93A8909C6B18B3F6367766A0DBBDCF3_144664380 = (i != seq.size());
            {
                attrs[i] = new X509Attribute((ASN1Encodable)seq.getObjectAt(i));
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_333332376 = attrs;
        varB4EAC82CA7396A68D541C85D26508E83_333332376.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_333332376;
        
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.601 -0400", hash_original_method = "1BDF84262F391CC05FF0C51BDEDDB7BE", hash_generated_method = "A725A8501A5D9FCBF01075E66A11904D")
    public X509Attribute[] getAttributes(String oid) {
        X509Attribute[] varB4EAC82CA7396A68D541C85D26508E83_2077534418 = null; 
        X509Attribute[] varB4EAC82CA7396A68D541C85D26508E83_58190585 = null; 
        ASN1Sequence seq = cert.getAcinfo().getAttributes();
        List list = new ArrayList();
        {
            int i = 0;
            boolean varA93A8909C6B18B3F6367766A0DBBDCF3_1127907340 = (i != seq.size());
            {
                X509Attribute attr = new X509Attribute((ASN1Encodable)seq.getObjectAt(i));
                {
                    boolean var2F5F55D4013D954821849A0E6919F562_1879280792 = (attr.getOID().equals(oid));
                    {
                        list.add(attr);
                    } 
                } 
            } 
        } 
        {
            boolean var8D5789A37F50667ED0EB03D7F7D9B0AE_1864917340 = (list.size() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_2077534418 = null;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_58190585 = (X509Attribute[])list.toArray(new X509Attribute[list.size()]);
        addTaint(oid.getTaint());
        X509Attribute[] varA7E53CE21691AB073D9660D615818899_373282932; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_373282932 = varB4EAC82CA7396A68D541C85D26508E83_2077534418;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_373282932 = varB4EAC82CA7396A68D541C85D26508E83_58190585;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_373282932.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_373282932;
        
        
        
        
        
            
            
            
                
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.602 -0400", hash_original_method = "60181B32C72761B75B31B405BBC4804E", hash_generated_method = "FDF372395B7CA538CAF67AF504521D1F")
    public boolean equals(
        Object o) {
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_1676789321 = (o == this);
        } 
        X509AttributeCertificate other = (X509AttributeCertificate)o;
        try 
        {
            byte[] b1 = this.getEncoded();
            byte[] b2 = other.getEncoded();
            boolean varF556B23283157278437840C590049CEF_2082246089 = (Arrays.areEqual(b1, b2));
        } 
        catch (IOException e)
        { }
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1659365706 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1659365706;
        
        
        
            
        
        
        
            
        
        
        
        
            
            
            
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.603 -0400", hash_original_method = "C5506CF7B2024CB4E09A9FBA2D111DDF", hash_generated_method = "18917163FF15B694C2BCC1FF97E6876C")
    public int hashCode() {
        try 
        {
            int varF50CBEEE6EAE5D8CC5480F703A4578C5_1500727611 = (Arrays.hashCode(this.getEncoded()));
        } 
        catch (IOException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_162328877 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_162328877;
        
        
        
            
        
        
        
            
        
    }

    
}

