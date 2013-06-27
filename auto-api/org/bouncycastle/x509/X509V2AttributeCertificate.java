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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.233 -0400", hash_original_field = "B6BA9FA6EA18201BF39EA635ECCA9F13", hash_generated_field = "AFD6C6D10463457A355EBA6B8E3CE0C1")

    private AttributeCertificate cert;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.234 -0400", hash_original_field = "CF2C84750B842AAA309ECBA4D79FF935", hash_generated_field = "E3E827D7CD2761B5AB55619FED686D61")

    private Date notBefore;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.234 -0400", hash_original_field = "21F1BA3A4A4A624D712B87C23B2FD95A", hash_generated_field = "9EC5214487C0E45ED3A209D46FF5E8A8")

    private Date notAfter;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.234 -0400", hash_original_method = "511310A6550A73E5129DCD139E553E6F", hash_generated_method = "9D241BD538D3E85FC626B5E474C72E96")
    public  X509V2AttributeCertificate(
        InputStream encIn) throws IOException {
        this(getObject(encIn));
        addTaint(encIn.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.234 -0400", hash_original_method = "B127BB0A829E4BFD3E32578437EC0EFB", hash_generated_method = "E92DBB19F0205A89A7C109AE87861EB8")
    public  X509V2AttributeCertificate(
        byte[]  encoded) throws IOException {
        this(new ByteArrayInputStream(encoded));
        addTaint(encoded[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.235 -0400", hash_original_method = "FF0916A499ED21133E7F47C29CF6DD83", hash_generated_method = "85374A83E60650397C2B972244A25E21")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.237 -0400", hash_original_method = "5FE4A45F92CB5E44CD6499FACBF2EDEC", hash_generated_method = "7F869A03D57C3D68BCF4D0A61C5C017F")
    public int getVersion() {
        int var43188AF0ED861B053ED9493C9D018178_259619118 = (cert.getAcinfo().getVersion().getValue().intValue() + 1);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1614506405 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1614506405;
        // ---------- Original Method ----------
        //return cert.getAcinfo().getVersion().getValue().intValue() + 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.240 -0400", hash_original_method = "6D79F8D94B9C23855CFDC1454EEDA264", hash_generated_method = "1B3A935288486528F5D96F6A266FF948")
    public BigInteger getSerialNumber() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_719771915 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_719771915 = cert.getAcinfo().getSerialNumber().getValue();
        varB4EAC82CA7396A68D541C85D26508E83_719771915.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_719771915;
        // ---------- Original Method ----------
        //return cert.getAcinfo().getSerialNumber().getValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.240 -0400", hash_original_method = "020DE1897FEFE364249BEA87F131F85A", hash_generated_method = "0C5661B52BAEE11557B98601FFAC2845")
    public AttributeCertificateHolder getHolder() {
        AttributeCertificateHolder varB4EAC82CA7396A68D541C85D26508E83_2025329753 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2025329753 = new AttributeCertificateHolder((ASN1Sequence)cert.getAcinfo().getHolder().toASN1Object());
        varB4EAC82CA7396A68D541C85D26508E83_2025329753.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2025329753;
        // ---------- Original Method ----------
        //return new AttributeCertificateHolder((ASN1Sequence)cert.getAcinfo().getHolder().toASN1Object());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.241 -0400", hash_original_method = "BBF141CF5A1E02D76A470DA06D7E0741", hash_generated_method = "19A3E65AFF4FCC51C061FE2A820FB9FF")
    public AttributeCertificateIssuer getIssuer() {
        AttributeCertificateIssuer varB4EAC82CA7396A68D541C85D26508E83_2005419432 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2005419432 = new AttributeCertificateIssuer(cert.getAcinfo().getIssuer());
        varB4EAC82CA7396A68D541C85D26508E83_2005419432.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2005419432;
        // ---------- Original Method ----------
        //return new AttributeCertificateIssuer(cert.getAcinfo().getIssuer());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.241 -0400", hash_original_method = "CB2A2B3C356F1AD47950BB2253ACA4BD", hash_generated_method = "3EC06F2D13BA03B47A8D5AC0EBEA7A8A")
    public Date getNotBefore() {
        Date varB4EAC82CA7396A68D541C85D26508E83_366601132 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_366601132 = notBefore;
        varB4EAC82CA7396A68D541C85D26508E83_366601132.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_366601132;
        // ---------- Original Method ----------
        //return notBefore;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.242 -0400", hash_original_method = "9EADF7E1E76408811693CE379F621727", hash_generated_method = "44C8E7E50E6F5C88C155B35A2B8B7A56")
    public Date getNotAfter() {
        Date varB4EAC82CA7396A68D541C85D26508E83_680329228 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_680329228 = notAfter;
        varB4EAC82CA7396A68D541C85D26508E83_680329228.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_680329228;
        // ---------- Original Method ----------
        //return notAfter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.259 -0400", hash_original_method = "9BC89181E6C1277EBE257648E61E1A79", hash_generated_method = "F4570CEACEC0FF5FEBACB3896E332E12")
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
        boolean[] var503EB2F420079C4024483971CE5EDEA8_140135710 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_140135710;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.259 -0400", hash_original_method = "21EA5C7301B68DB7B0091D4882BC7F7A", hash_generated_method = "3AF3691FECB84D9AA63CDDD8C60E66DF")
    public void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
        this.checkValidity(new Date());
        // ---------- Original Method ----------
        //this.checkValidity(new Date());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.260 -0400", hash_original_method = "C7ABADDDE42159C03B4715171CE7A75D", hash_generated_method = "FD5A30BEA7C606FE98B28283D9DDDBBC")
    public void checkValidity(
        Date    date) throws CertificateExpiredException, CertificateNotYetValidException {
        {
            boolean var938055BAB3BA3D99176A733B2B72FD0A_456350949 = (date.after(this.getNotAfter()));
            {
                if (DroidSafeAndroidRuntime.control) throw new CertificateExpiredException("certificate expired on " + this.getNotAfter());
            } //End block
        } //End collapsed parenthetic
        {
            boolean var9E5357C476E1D269B0818F407DABDB7B_518385368 = (date.before(this.getNotBefore()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.264 -0400", hash_original_method = "12695EBC2BF1A0C9FFF47E032B23EFDD", hash_generated_method = "BF23712F23FB7EF0389AA14C540EC2FE")
    public byte[] getSignature() {
        byte[] varA590625ED1805BA8DD8751D4EA289962_1674183967 = (cert.getSignatureValue().getBytes());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_736263986 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_736263986;
        // ---------- Original Method ----------
        //return cert.getSignatureValue().getBytes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.265 -0400", hash_original_method = "00EE60C525B48F0703DB78FF90B15573", hash_generated_method = "33D2E477A7128C171C01088FE1E56ACB")
    public final void verify(
            PublicKey   key,
            String      provider) throws CertificateException, NoSuchAlgorithmException,
            InvalidKeyException, NoSuchProviderException, SignatureException {
        Signature signature;
        signature = null;
        {
            boolean var19446C785F6DBF82763E5AF35CF35767_1155114042 = (!cert.getSignatureAlgorithm().equals(cert.getAcinfo().getSignature()));
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
            boolean varC2CE6383A33B34726D848A5B5FF1E5AA_695316383 = (!signature.verify(this.getSignature()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.266 -0400", hash_original_method = "C092EBBC5365A2A25EF301186F9FC908", hash_generated_method = "02DE864055764BA557DB7DC39EABD163")
    public byte[] getEncoded() throws IOException {
        byte[] var23DA858403631F55A5468B58A8F35F7A_1402675983 = (cert.getEncoded());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_199927373 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_199927373;
        // ---------- Original Method ----------
        //return cert.getEncoded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.266 -0400", hash_original_method = "174EB6531B05B4A912F07FC1EA279D8F", hash_generated_method = "E4042600A8658528819CDBEBF15495E1")
    public byte[] getExtensionValue(String oid) {
        X509Extensions extensions;
        extensions = cert.getAcinfo().getExtensions();
        {
            X509Extension ext;
            ext = extensions.getExtension(new DERObjectIdentifier(oid));
            {
                try 
                {
                    byte[] var2207C2F4DEA9B59FFC3AA697A89C9510_1423615076 = (ext.getValue().getEncoded(ASN1Encodable.DER));
                } //End block
                catch (Exception e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException("error encoding " + e.toString());
                } //End block
            } //End block
        } //End block
        addTaint(oid.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1746801456 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1746801456;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.270 -0400", hash_original_method = "EEE6D6FB39ABCE0441C4E0B5FB99D1CC", hash_generated_method = "A9A46CBEB70B574F8F0E67CCAAAE56C1")
    private Set getExtensionOIDs(
        boolean critical) {
        Set varB4EAC82CA7396A68D541C85D26508E83_964866142 = null; //Variable for return #1
        Set varB4EAC82CA7396A68D541C85D26508E83_326369925 = null; //Variable for return #2
        X509Extensions extensions;
        extensions = cert.getAcinfo().getExtensions();
        {
            Set set;
            set = new HashSet();
            Enumeration e;
            e = extensions.oids();
            {
                boolean varE6301E07393E7C92A45A62612E875EEF_1695789117 = (e.hasMoreElements());
                {
                    DERObjectIdentifier oid;
                    oid = (DERObjectIdentifier)e.nextElement();
                    X509Extension ext;
                    ext = extensions.getExtension(oid);
                    {
                        boolean var25B4D70B251BC642691C6F1F019085E5_1252144129 = (ext.isCritical() == critical);
                        {
                            set.add(oid.getId());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_964866142 = set;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_326369925 = null;
        addTaint(critical);
        Set varA7E53CE21691AB073D9660D615818899_1561585199; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1561585199 = varB4EAC82CA7396A68D541C85D26508E83_964866142;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1561585199 = varB4EAC82CA7396A68D541C85D26508E83_326369925;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1561585199.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1561585199;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.276 -0400", hash_original_method = "5436A1880A3E8EACEF801692C5DC1E5D", hash_generated_method = "1D28F4412339B820A08964B9370C36D1")
    public Set getNonCriticalExtensionOIDs() {
        Set varB4EAC82CA7396A68D541C85D26508E83_527210681 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_527210681 = getExtensionOIDs(false);
        varB4EAC82CA7396A68D541C85D26508E83_527210681.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_527210681;
        // ---------- Original Method ----------
        //return getExtensionOIDs(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.276 -0400", hash_original_method = "95A4F309A27080538E4E315B4E15DBCF", hash_generated_method = "01E26AD4AEFEABDCC376AF7AA6F740FB")
    public Set getCriticalExtensionOIDs() {
        Set varB4EAC82CA7396A68D541C85D26508E83_2106934180 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2106934180 = getExtensionOIDs(true);
        varB4EAC82CA7396A68D541C85D26508E83_2106934180.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2106934180;
        // ---------- Original Method ----------
        //return getExtensionOIDs(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.276 -0400", hash_original_method = "DC43BBF9B96B5410825BE22446F9B294", hash_generated_method = "9EDD1AB59DA9974BA9D196682CA5FDA2")
    public boolean hasUnsupportedCriticalExtension() {
        Set extensions;
        extensions = getCriticalExtensionOIDs();
        boolean var4952DC1337533857B4886D4294445F8B_299870167 = (extensions != null && !extensions.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1510545548 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1510545548;
        // ---------- Original Method ----------
        //Set  extensions = getCriticalExtensionOIDs();
        //return extensions != null && !extensions.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.277 -0400", hash_original_method = "D9A39E0FBB510DE2D7B256831A61B9D2", hash_generated_method = "3576A8CA817239B140560EBEB4303928")
    public X509Attribute[] getAttributes() {
        X509Attribute[] varB4EAC82CA7396A68D541C85D26508E83_153210821 = null; //Variable for return #1
        ASN1Sequence seq;
        seq = cert.getAcinfo().getAttributes();
        X509Attribute[] attrs;
        attrs = new X509Attribute[seq.size()];
        {
            int i;
            i = 0;
            boolean varA93A8909C6B18B3F6367766A0DBBDCF3_76960332 = (i != seq.size());
            {
                attrs[i] = new X509Attribute((ASN1Encodable)seq.getObjectAt(i));
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_153210821 = attrs;
        varB4EAC82CA7396A68D541C85D26508E83_153210821.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_153210821;
        // ---------- Original Method ----------
        //ASN1Sequence    seq = cert.getAcinfo().getAttributes();
        //X509Attribute[] attrs = new X509Attribute[seq.size()];
        //for (int i = 0; i != seq.size(); i++)
        //{
            //attrs[i] = new X509Attribute((ASN1Encodable)seq.getObjectAt(i));
        //}
        //return attrs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.278 -0400", hash_original_method = "1BDF84262F391CC05FF0C51BDEDDB7BE", hash_generated_method = "0DED1DD8B494BA148E877C70A2093C00")
    public X509Attribute[] getAttributes(String oid) {
        X509Attribute[] varB4EAC82CA7396A68D541C85D26508E83_1005129438 = null; //Variable for return #1
        X509Attribute[] varB4EAC82CA7396A68D541C85D26508E83_75817638 = null; //Variable for return #2
        ASN1Sequence seq;
        seq = cert.getAcinfo().getAttributes();
        List list;
        list = new ArrayList();
        {
            int i;
            i = 0;
            boolean varA93A8909C6B18B3F6367766A0DBBDCF3_1672718249 = (i != seq.size());
            {
                X509Attribute attr;
                attr = new X509Attribute((ASN1Encodable)seq.getObjectAt(i));
                {
                    boolean var2F5F55D4013D954821849A0E6919F562_2110316092 = (attr.getOID().equals(oid));
                    {
                        list.add(attr);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var8D5789A37F50667ED0EB03D7F7D9B0AE_1134757748 = (list.size() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1005129438 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_75817638 = (X509Attribute[])list.toArray(new X509Attribute[list.size()]);
        addTaint(oid.getTaint());
        X509Attribute[] varA7E53CE21691AB073D9660D615818899_1170332616; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1170332616 = varB4EAC82CA7396A68D541C85D26508E83_1005129438;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1170332616 = varB4EAC82CA7396A68D541C85D26508E83_75817638;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1170332616.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1170332616;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.298 -0400", hash_original_method = "60181B32C72761B75B31B405BBC4804E", hash_generated_method = "109DE2121BFA75BEFDBACDC12C027239")
    public boolean equals(
        Object o) {
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_1331446599 = (o == this);
        } //End collapsed parenthetic
        X509AttributeCertificate other;
        other = (X509AttributeCertificate)o;
        try 
        {
            byte[] b1;
            b1 = this.getEncoded();
            byte[] b2;
            b2 = other.getEncoded();
            boolean varF556B23283157278437840C590049CEF_1599761255 = (Arrays.areEqual(b1, b2));
        } //End block
        catch (IOException e)
        { }
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_254589493 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_254589493;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.298 -0400", hash_original_method = "C5506CF7B2024CB4E09A9FBA2D111DDF", hash_generated_method = "51C65F6D8971FE639936C8FCB21E9793")
    public int hashCode() {
        try 
        {
            int varF50CBEEE6EAE5D8CC5480F703A4578C5_586300608 = (Arrays.hashCode(this.getEncoded()));
        } //End block
        catch (IOException e)
        { }
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_687879573 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_687879573;
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

