package org.bouncycastle.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.158 -0400", hash_original_field = "B6BA9FA6EA18201BF39EA635ECCA9F13", hash_generated_field = "AFD6C6D10463457A355EBA6B8E3CE0C1")

    private AttributeCertificate cert;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.159 -0400", hash_original_field = "CF2C84750B842AAA309ECBA4D79FF935", hash_generated_field = "E3E827D7CD2761B5AB55619FED686D61")

    private Date notBefore;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.159 -0400", hash_original_field = "21F1BA3A4A4A624D712B87C23B2FD95A", hash_generated_field = "9EC5214487C0E45ED3A209D46FF5E8A8")

    private Date notAfter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.177 -0400", hash_original_method = "511310A6550A73E5129DCD139E553E6F", hash_generated_method = "9D241BD538D3E85FC626B5E474C72E96")
    public  X509V2AttributeCertificate(
        InputStream encIn) throws IOException {
        this(getObject(encIn));
        addTaint(encIn.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.177 -0400", hash_original_method = "B127BB0A829E4BFD3E32578437EC0EFB", hash_generated_method = "E92DBB19F0205A89A7C109AE87861EB8")
    public  X509V2AttributeCertificate(
        byte[]  encoded) throws IOException {
        this(new ByteArrayInputStream(encoded));
        addTaint(encoded[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.178 -0400", hash_original_method = "FF0916A499ED21133E7F47C29CF6DD83", hash_generated_method = "85374A83E60650397C2B972244A25E21")
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
            if (DroidSafeAndroidRuntime.control) throw new IOException("invalid data structure in certificate!");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.178 -0400", hash_original_method = "5FE4A45F92CB5E44CD6499FACBF2EDEC", hash_generated_method = "6B07889CE77E7376E87D26A1952699CF")
    public int getVersion() {
        int var43188AF0ED861B053ED9493C9D018178_326390864 = (cert.getAcinfo().getVersion().getValue().intValue() + 1);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1450756346 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1450756346;
        // ---------- Original Method ----------
        //return cert.getAcinfo().getVersion().getValue().intValue() + 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.182 -0400", hash_original_method = "6D79F8D94B9C23855CFDC1454EEDA264", hash_generated_method = "9757DC4988CD25F62B9F35BCF1EC21C6")
    public BigInteger getSerialNumber() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1125315522 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1125315522 = cert.getAcinfo().getSerialNumber().getValue();
        varB4EAC82CA7396A68D541C85D26508E83_1125315522.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1125315522;
        // ---------- Original Method ----------
        //return cert.getAcinfo().getSerialNumber().getValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.183 -0400", hash_original_method = "020DE1897FEFE364249BEA87F131F85A", hash_generated_method = "78AD0944284C830696FEC0834E89186D")
    public AttributeCertificateHolder getHolder() {
        AttributeCertificateHolder varB4EAC82CA7396A68D541C85D26508E83_1863782578 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1863782578 = new AttributeCertificateHolder((ASN1Sequence)cert.getAcinfo().getHolder().toASN1Object());
        varB4EAC82CA7396A68D541C85D26508E83_1863782578.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1863782578;
        // ---------- Original Method ----------
        //return new AttributeCertificateHolder((ASN1Sequence)cert.getAcinfo().getHolder().toASN1Object());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.183 -0400", hash_original_method = "BBF141CF5A1E02D76A470DA06D7E0741", hash_generated_method = "B65ECF6D8A90A2F73DA5A50E866B4278")
    public AttributeCertificateIssuer getIssuer() {
        AttributeCertificateIssuer varB4EAC82CA7396A68D541C85D26508E83_1859364175 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1859364175 = new AttributeCertificateIssuer(cert.getAcinfo().getIssuer());
        varB4EAC82CA7396A68D541C85D26508E83_1859364175.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1859364175;
        // ---------- Original Method ----------
        //return new AttributeCertificateIssuer(cert.getAcinfo().getIssuer());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.184 -0400", hash_original_method = "CB2A2B3C356F1AD47950BB2253ACA4BD", hash_generated_method = "E1E2BD855EC3336EFD081DA98DE6C70A")
    public Date getNotBefore() {
        Date varB4EAC82CA7396A68D541C85D26508E83_1337396615 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1337396615 = notBefore;
        varB4EAC82CA7396A68D541C85D26508E83_1337396615.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1337396615;
        // ---------- Original Method ----------
        //return notBefore;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.194 -0400", hash_original_method = "9EADF7E1E76408811693CE379F621727", hash_generated_method = "D2AEBFFA8A9F0CE9157259126977FFDC")
    public Date getNotAfter() {
        Date varB4EAC82CA7396A68D541C85D26508E83_1291320831 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1291320831 = notAfter;
        varB4EAC82CA7396A68D541C85D26508E83_1291320831.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1291320831;
        // ---------- Original Method ----------
        //return notAfter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.195 -0400", hash_original_method = "9BC89181E6C1277EBE257648E61E1A79", hash_generated_method = "5519A58F43A8159F8EBB5B664B5727CB")
    public boolean[] getIssuerUniqueID() {
        DERBitString id;
        id = cert.getAcinfo().getIssuerUniqueID();
        {
            byte[] bytes;
            bytes = id.getBytes();
            boolean[] boolId;
            boolId = new boolean[bytes.length * 8 - id.getPadBits()];
            {
                int i;
                i = 0;
                {
                    boolId[i] = (bytes[i / 8] & (0x80 >>> (i % 8))) != 0;
                } //End block
            } //End collapsed parenthetic
        } //End block
        boolean[] var503EB2F420079C4024483971CE5EDEA8_72681411 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_72681411;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.197 -0400", hash_original_method = "21EA5C7301B68DB7B0091D4882BC7F7A", hash_generated_method = "3AF3691FECB84D9AA63CDDD8C60E66DF")
    public void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
        this.checkValidity(new Date());
        // ---------- Original Method ----------
        //this.checkValidity(new Date());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.198 -0400", hash_original_method = "C7ABADDDE42159C03B4715171CE7A75D", hash_generated_method = "A347A9AAB12505D78F425F35A31B3A1F")
    public void checkValidity(
        Date    date) throws CertificateExpiredException, CertificateNotYetValidException {
        {
            boolean var938055BAB3BA3D99176A733B2B72FD0A_1300530342 = (date.after(this.getNotAfter()));
            {
                if (DroidSafeAndroidRuntime.control) throw new CertificateExpiredException("certificate expired on " + this.getNotAfter());
            } //End block
        } //End collapsed parenthetic
        {
            boolean var9E5357C476E1D269B0818F407DABDB7B_1529345004 = (date.before(this.getNotBefore()));
            {
                if (DroidSafeAndroidRuntime.control) throw new CertificateNotYetValidException("certificate not valid till " + this.getNotBefore());
            } //End block
        } //End collapsed parenthetic
        addTaint(date.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.201 -0400", hash_original_method = "12695EBC2BF1A0C9FFF47E032B23EFDD", hash_generated_method = "FB2BA69C3630E55A71E12C40D01A8D3F")
    public byte[] getSignature() {
        byte[] varA590625ED1805BA8DD8751D4EA289962_419061476 = (cert.getSignatureValue().getBytes());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1532966604 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1532966604;
        // ---------- Original Method ----------
        //return cert.getSignatureValue().getBytes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.213 -0400", hash_original_method = "00EE60C525B48F0703DB78FF90B15573", hash_generated_method = "7837E6889E9D40F2C0A52E580E2E19B6")
    public final void verify(
            PublicKey   key,
            String      provider) throws CertificateException, NoSuchAlgorithmException,
            InvalidKeyException, NoSuchProviderException, SignatureException {
        Signature signature;
        signature = null;
        {
            boolean var19446C785F6DBF82763E5AF35CF35767_1213192392 = (!cert.getSignatureAlgorithm().equals(cert.getAcinfo().getSignature()));
            {
                if (DroidSafeAndroidRuntime.control) throw new CertificateException("Signature algorithm in certificate info not same as outer certificate");
            } //End block
        } //End collapsed parenthetic
        signature = Signature.getInstance(cert.getSignatureAlgorithm().getObjectId().getId(), provider);
        signature.initVerify(key);
        try 
        {
            signature.update(cert.getAcinfo().getEncoded());
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SignatureException("Exception encoding certificate info object");
        } //End block
        {
            boolean varC2CE6383A33B34726D848A5B5FF1E5AA_1801330969 = (!signature.verify(this.getSignature()));
            {
                if (DroidSafeAndroidRuntime.control) throw new InvalidKeyException("Public key presented not for certificate signature");
            } //End block
        } //End collapsed parenthetic
        addTaint(key.getTaint());
        addTaint(provider.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.214 -0400", hash_original_method = "C092EBBC5365A2A25EF301186F9FC908", hash_generated_method = "D3D6DD04C924D90F9A918E33E912479A")
    public byte[] getEncoded() throws IOException {
        byte[] var23DA858403631F55A5468B58A8F35F7A_1625222367 = (cert.getEncoded());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_261341462 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_261341462;
        // ---------- Original Method ----------
        //return cert.getEncoded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.214 -0400", hash_original_method = "174EB6531B05B4A912F07FC1EA279D8F", hash_generated_method = "73D69FBCD476C00467EA093B397D1AA3")
    public byte[] getExtensionValue(String oid) {
        X509Extensions extensions;
        extensions = cert.getAcinfo().getExtensions();
        {
            X509Extension ext;
            ext = extensions.getExtension(new DERObjectIdentifier(oid));
            {
                try 
                {
                    byte[] var2207C2F4DEA9B59FFC3AA697A89C9510_1833412251 = (ext.getValue().getEncoded(ASN1Encodable.DER));
                } //End block
                catch (Exception e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException("error encoding " + e.toString());
                } //End block
            } //End block
        } //End block
        addTaint(oid.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1491581215 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1491581215;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.219 -0400", hash_original_method = "EEE6D6FB39ABCE0441C4E0B5FB99D1CC", hash_generated_method = "8B5741DB8707D07EEF16F23E53AB56B7")
    private Set getExtensionOIDs(
        boolean critical) {
        Set varB4EAC82CA7396A68D541C85D26508E83_1481810075 = null; //Variable for return #1
        Set varB4EAC82CA7396A68D541C85D26508E83_30625750 = null; //Variable for return #2
        X509Extensions extensions;
        extensions = cert.getAcinfo().getExtensions();
        {
            Set set;
            set = new HashSet();
            Enumeration e;
            e = extensions.oids();
            {
                boolean varE6301E07393E7C92A45A62612E875EEF_570255613 = (e.hasMoreElements());
                {
                    DERObjectIdentifier oid;
                    oid = (DERObjectIdentifier)e.nextElement();
                    X509Extension ext;
                    ext = extensions.getExtension(oid);
                    {
                        boolean var25B4D70B251BC642691C6F1F019085E5_791044458 = (ext.isCritical() == critical);
                        {
                            set.add(oid.getId());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1481810075 = set;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_30625750 = null;
        addTaint(critical);
        Set varA7E53CE21691AB073D9660D615818899_649050184; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_649050184 = varB4EAC82CA7396A68D541C85D26508E83_1481810075;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_649050184 = varB4EAC82CA7396A68D541C85D26508E83_30625750;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_649050184.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_649050184;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.222 -0400", hash_original_method = "5436A1880A3E8EACEF801692C5DC1E5D", hash_generated_method = "14939577FCB3AA04E0A87DDDF7B6495A")
    public Set getNonCriticalExtensionOIDs() {
        Set varB4EAC82CA7396A68D541C85D26508E83_588984235 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_588984235 = getExtensionOIDs(false);
        varB4EAC82CA7396A68D541C85D26508E83_588984235.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_588984235;
        // ---------- Original Method ----------
        //return getExtensionOIDs(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.223 -0400", hash_original_method = "95A4F309A27080538E4E315B4E15DBCF", hash_generated_method = "A264C67394FD8C24BF56FA0F7695200A")
    public Set getCriticalExtensionOIDs() {
        Set varB4EAC82CA7396A68D541C85D26508E83_1050867165 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1050867165 = getExtensionOIDs(true);
        varB4EAC82CA7396A68D541C85D26508E83_1050867165.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1050867165;
        // ---------- Original Method ----------
        //return getExtensionOIDs(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.227 -0400", hash_original_method = "DC43BBF9B96B5410825BE22446F9B294", hash_generated_method = "10E5707BB718AC0B73F5610BBC3190F0")
    public boolean hasUnsupportedCriticalExtension() {
        Set extensions;
        extensions = getCriticalExtensionOIDs();
        boolean var4952DC1337533857B4886D4294445F8B_81604148 = (extensions != null && !extensions.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2047337855 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2047337855;
        // ---------- Original Method ----------
        //Set  extensions = getCriticalExtensionOIDs();
        //return extensions != null && !extensions.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.227 -0400", hash_original_method = "D9A39E0FBB510DE2D7B256831A61B9D2", hash_generated_method = "6648174BC0C44936D9B9BA39B5305E15")
    public X509Attribute[] getAttributes() {
        X509Attribute[] varB4EAC82CA7396A68D541C85D26508E83_1508772416 = null; //Variable for return #1
        ASN1Sequence seq;
        seq = cert.getAcinfo().getAttributes();
        X509Attribute[] attrs;
        attrs = new X509Attribute[seq.size()];
        {
            int i;
            i = 0;
            boolean varA93A8909C6B18B3F6367766A0DBBDCF3_665358175 = (i != seq.size());
            {
                attrs[i] = new X509Attribute((ASN1Encodable)seq.getObjectAt(i));
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1508772416 = attrs;
        varB4EAC82CA7396A68D541C85D26508E83_1508772416.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1508772416;
        // ---------- Original Method ----------
        //ASN1Sequence    seq = cert.getAcinfo().getAttributes();
        //X509Attribute[] attrs = new X509Attribute[seq.size()];
        //for (int i = 0; i != seq.size(); i++)
        //{
            //attrs[i] = new X509Attribute((ASN1Encodable)seq.getObjectAt(i));
        //}
        //return attrs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.228 -0400", hash_original_method = "1BDF84262F391CC05FF0C51BDEDDB7BE", hash_generated_method = "B6CF4950D5976B3149EFDB104B4D0735")
    public X509Attribute[] getAttributes(String oid) {
        X509Attribute[] varB4EAC82CA7396A68D541C85D26508E83_762854786 = null; //Variable for return #1
        X509Attribute[] varB4EAC82CA7396A68D541C85D26508E83_516618024 = null; //Variable for return #2
        ASN1Sequence seq;
        seq = cert.getAcinfo().getAttributes();
        List list;
        list = new ArrayList();
        {
            int i;
            i = 0;
            boolean varA93A8909C6B18B3F6367766A0DBBDCF3_1953206985 = (i != seq.size());
            {
                X509Attribute attr;
                attr = new X509Attribute((ASN1Encodable)seq.getObjectAt(i));
                {
                    boolean var2F5F55D4013D954821849A0E6919F562_1649926816 = (attr.getOID().equals(oid));
                    {
                        list.add(attr);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var8D5789A37F50667ED0EB03D7F7D9B0AE_1039066755 = (list.size() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_762854786 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_516618024 = (X509Attribute[])list.toArray(new X509Attribute[list.size()]);
        addTaint(oid.getTaint());
        X509Attribute[] varA7E53CE21691AB073D9660D615818899_277557711; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_277557711 = varB4EAC82CA7396A68D541C85D26508E83_762854786;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_277557711 = varB4EAC82CA7396A68D541C85D26508E83_516618024;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_277557711.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_277557711;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.229 -0400", hash_original_method = "60181B32C72761B75B31B405BBC4804E", hash_generated_method = "694A1E4142591B1C8697737607EAB451")
    public boolean equals(
        Object o) {
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_1546021772 = (o == this);
        } //End collapsed parenthetic
        X509AttributeCertificate other;
        other = (X509AttributeCertificate)o;
        try 
        {
            byte[] b1;
            b1 = this.getEncoded();
            byte[] b2;
            b2 = other.getEncoded();
            boolean varF556B23283157278437840C590049CEF_386145830 = (Arrays.areEqual(b1, b2));
        } //End block
        catch (IOException e)
        { }
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2083618988 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2083618988;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.232 -0400", hash_original_method = "C5506CF7B2024CB4E09A9FBA2D111DDF", hash_generated_method = "8368A54119B387CF5A6D49156A981E3C")
    public int hashCode() {
        try 
        {
            int varF50CBEEE6EAE5D8CC5480F703A4578C5_1006272752 = (Arrays.hashCode(this.getEncoded()));
        } //End block
        catch (IOException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1451841447 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1451841447;
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

