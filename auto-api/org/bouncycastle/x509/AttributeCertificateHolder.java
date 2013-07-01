package org.bouncycastle.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.455 -0400", hash_original_field = "A403F79916FA151CDCC745626E69FED2", hash_generated_field = "81EEF30676831ECD3948BE1C9E69FB41")

    Holder holder;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.456 -0400", hash_original_method = "5CADDEA19B83B0D9A5BBB8113D1E397F", hash_generated_method = "F59428356E32C4723CDCA0BF11B8E6A2")
      AttributeCertificateHolder(ASN1Sequence seq) {
        holder = Holder.getInstance(seq);
        // ---------- Original Method ----------
        //holder = Holder.getInstance(seq);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.456 -0400", hash_original_method = "36C6FF42848B06325DA653927B354FB6", hash_generated_method = "F8BAA13337AB237B2C07C3B22FEF3CB7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.456 -0400", hash_original_method = "AB8EF4A9C8EF2BF3AB56D333BEC2C930", hash_generated_method = "A5D725EEDD1630375670810031A27BC4")
    public  AttributeCertificateHolder(X500Principal issuerName,
        BigInteger serialNumber) {
        this(X509Util.convertPrincipal(issuerName), serialNumber);
        addTaint(issuerName.getTaint());
        addTaint(serialNumber.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.457 -0400", hash_original_method = "38A3680A490D691786DB1D5D606419F8", hash_generated_method = "CD162A3427ED91224E167F632B6282E5")
    public  AttributeCertificateHolder(X509Certificate cert) throws CertificateParsingException {
        X509Principal name;
        try 
        {
            name = PrincipalUtil.getIssuerX509Principal(cert);
        } //End block
        catch (Exception e)
        {
        	throw new CertificateParsingException(e.getMessage());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.457 -0400", hash_original_method = "BB3F8ED7A12081786FFA678549853DD7", hash_generated_method = "9DAC6696A4355E038108E0ADFA13A2E4")
    public  AttributeCertificateHolder(X509Principal principal) {
        holder = new Holder(generateGeneralNames(principal));
        // ---------- Original Method ----------
        //holder = new Holder(generateGeneralNames(principal));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.457 -0400", hash_original_method = "8754A1CB9EC37CB6374A9BB4689D9463", hash_generated_method = "887D0050DF99D6E04954A122736E8C21")
    public  AttributeCertificateHolder(X500Principal principal) {
        this(X509Util.convertPrincipal(principal));
        addTaint(principal.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.457 -0400", hash_original_method = "058E2AA05CCDB81429F1E94E1527F7B6", hash_generated_method = "55B74FCEB90EE5EEEC66BDDDFBED7FE8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.458 -0400", hash_original_method = "5DC58025DAD5ABD5E5609ED391A96DAB", hash_generated_method = "7F3460B43FA7040946C771F108AA1074")
    public int getDigestedObjectType() {
        {
            boolean var67FBE00BCEDE85B76D609F8E7707FEB3_534951988 = (holder.getObjectDigestInfo() != null);
            {
                int varC8A3E13F39776207B82715F8E3EEAE05_1767099738 = (holder.getObjectDigestInfo().getDigestedObjectType()
                .getValue().intValue());
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_425817312 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_425817312;
        // ---------- Original Method ----------
        //if (holder.getObjectDigestInfo() != null)
        //{
            //return holder.getObjectDigestInfo().getDigestedObjectType()
                //.getValue().intValue();
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.459 -0400", hash_original_method = "44CC065F66E7FDD5B9E2538C14A00A59", hash_generated_method = "5BB289DDEDFC892D3267A5E753B4D5F4")
    public String getDigestAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_1297711486 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1212252257 = null; //Variable for return #2
        {
            boolean var67FBE00BCEDE85B76D609F8E7707FEB3_1263394291 = (holder.getObjectDigestInfo() != null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1297711486 = holder.getObjectDigestInfo().getDigestAlgorithm().getObjectId()
                .getId();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1212252257 = null;
        String varA7E53CE21691AB073D9660D615818899_1124763653; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1124763653 = varB4EAC82CA7396A68D541C85D26508E83_1297711486;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1124763653 = varB4EAC82CA7396A68D541C85D26508E83_1212252257;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1124763653.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1124763653;
        // ---------- Original Method ----------
        //if (holder.getObjectDigestInfo() != null)
        //{
            //return holder.getObjectDigestInfo().getDigestAlgorithm().getObjectId()
                //.getId();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.459 -0400", hash_original_method = "4B9D866BC14850DF9DC3D05B3C536D79", hash_generated_method = "CF093F74E9DBEE484DCF3A0C9D7BA543")
    public byte[] getObjectDigest() {
        {
            boolean var67FBE00BCEDE85B76D609F8E7707FEB3_1268144454 = (holder.getObjectDigestInfo() != null);
            {
                byte[] var4554620765784B592F5555B759A81D8A_1930102688 = (holder.getObjectDigestInfo().getObjectDigest().getBytes());
            } //End block
        } //End collapsed parenthetic
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1002251071 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1002251071;
        // ---------- Original Method ----------
        //if (holder.getObjectDigestInfo() != null)
        //{
            //return holder.getObjectDigestInfo().getObjectDigest().getBytes();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.460 -0400", hash_original_method = "D91C38C78BDA175ED1B06895DD027E8A", hash_generated_method = "D85A1E75DFDF86AC9A850069A62AC780")
    public String getOtherObjectTypeID() {
        String varB4EAC82CA7396A68D541C85D26508E83_1111951530 = null; //Variable for return #1
        {
            boolean var67FBE00BCEDE85B76D609F8E7707FEB3_1447613064 = (holder.getObjectDigestInfo() != null);
            {
                holder.getObjectDigestInfo().getOtherObjectTypeID().getId();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1111951530 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1111951530.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1111951530;
        // ---------- Original Method ----------
        //if (holder.getObjectDigestInfo() != null)
        //{
            //holder.getObjectDigestInfo().getOtherObjectTypeID().getId();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.461 -0400", hash_original_method = "813AC8AE1843F5B7087E11CB016E8403", hash_generated_method = "A6489C5C9B0F6AA845DD2F966D184AFF")
    private GeneralNames generateGeneralNames(X509Principal principal) {
        GeneralNames varB4EAC82CA7396A68D541C85D26508E83_933969939 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_933969939 = new GeneralNames(new DERSequence(new GeneralName(principal)));
        addTaint(principal.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_933969939.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_933969939;
        // ---------- Original Method ----------
        //return new GeneralNames(new DERSequence(new GeneralName(principal)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.461 -0400", hash_original_method = "938EE7D821BB407EF13AE79847029298", hash_generated_method = "C1551E2ABB5788C2AB3F3AA1638AB03C")
    private boolean matchesDN(X509Principal subject, GeneralNames targets) {
        GeneralName[] names = targets.getNames();
        {
            int i = 0;
            {
                GeneralName gn = names[i];
                {
                    boolean varA8A9F7FA995044FDF9256505CA308CC1_178800010 = (gn.getTagNo() == GeneralName.directoryName);
                    {
                        try 
                        {
                            {
                                boolean varAE8E2DCE8F2E51411D749311B36CB149_574674507 = (new X509Principal(((ASN1Encodable)gn.getName())
                        .getEncoded()).equals(subject));
                            } //End collapsed parenthetic
                        } //End block
                        catch (IOException e)
                        { }
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(subject.getTaint());
        addTaint(targets.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_95372928 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_95372928;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.462 -0400", hash_original_method = "7552EC21B75F1C8319E3B7352977E9CE", hash_generated_method = "786E9C03C40B5F4FD6BA22C94ABDA37D")
    private Object[] getNames(GeneralName[] names) {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_296625136 = null; //Variable for return #1
        List l = new ArrayList(names.length);
        {
            int i = 0;
            {
                {
                    boolean var6E81B5710B8121FC654755546F549F39_93534574 = (names[i].getTagNo() == GeneralName.directoryName);
                    {
                        try 
                        {
                            l.add(new X500Principal(
                        ((ASN1Encodable)names[i].getName()).getEncoded()));
                        } //End block
                        catch (IOException e)
                        {
                            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("badly formed Name object");
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_296625136 = l.toArray(new Object[l.size()]);
        addTaint(names[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_296625136.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_296625136;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.463 -0400", hash_original_method = "2BE9B6F72BB32A06F2A43AB8DF17A2B5", hash_generated_method = "74D80C3E399ADB3D379EB363FE588CFA")
    private Principal[] getPrincipals(GeneralNames names) {
        Principal[] varB4EAC82CA7396A68D541C85D26508E83_1184444716 = null; //Variable for return #1
        Object[] p = this.getNames(names.getNames());
        List l = new ArrayList();
        {
            int i = 0;
            {
                {
                    l.add(p[i]);
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1184444716 = (Principal[])l.toArray(new Principal[l.size()]);
        addTaint(names.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1184444716.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1184444716;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.464 -0400", hash_original_method = "DB0C376D8871308D29988D3B3AAF17FC", hash_generated_method = "43C91F0A0E19E5B8D68258958E340496")
    public Principal[] getEntityNames() {
        Principal[] varB4EAC82CA7396A68D541C85D26508E83_2023638571 = null; //Variable for return #1
        Principal[] varB4EAC82CA7396A68D541C85D26508E83_1553771000 = null; //Variable for return #2
        {
            boolean var7D8EA0A0A35E3CD3453BBE8B1FA89E85_1734542484 = (holder.getEntityName() != null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_2023638571 = getPrincipals(holder.getEntityName());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1553771000 = null;
        Principal[] varA7E53CE21691AB073D9660D615818899_645143676; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_645143676 = varB4EAC82CA7396A68D541C85D26508E83_2023638571;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_645143676 = varB4EAC82CA7396A68D541C85D26508E83_1553771000;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_645143676.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_645143676;
        // ---------- Original Method ----------
        //if (holder.getEntityName() != null)
        //{
            //return getPrincipals(holder.getEntityName());
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.464 -0400", hash_original_method = "4F5AD36C2F60574BEE36BBEC8A3F8872", hash_generated_method = "51B2621CD3093CFEA2AD869A228A6B9C")
    public Principal[] getIssuer() {
        Principal[] varB4EAC82CA7396A68D541C85D26508E83_1584317957 = null; //Variable for return #1
        Principal[] varB4EAC82CA7396A68D541C85D26508E83_539424763 = null; //Variable for return #2
        {
            boolean var4D503B20E9F1E891648F31D6F77A7D68_1460963497 = (holder.getBaseCertificateID() != null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1584317957 = getPrincipals(holder.getBaseCertificateID().getIssuer());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_539424763 = null;
        Principal[] varA7E53CE21691AB073D9660D615818899_1953485125; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1953485125 = varB4EAC82CA7396A68D541C85D26508E83_1584317957;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1953485125 = varB4EAC82CA7396A68D541C85D26508E83_539424763;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1953485125.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1953485125;
        // ---------- Original Method ----------
        //if (holder.getBaseCertificateID() != null)
        //{
            //return getPrincipals(holder.getBaseCertificateID().getIssuer());
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.465 -0400", hash_original_method = "6708CF3972ED2FC7BE75744CEC7FD162", hash_generated_method = "97A9CB8A94C06819CC89D169D078E1F8")
    public BigInteger getSerialNumber() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_976870258 = null; //Variable for return #1
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_2029096477 = null; //Variable for return #2
        {
            boolean var4D503B20E9F1E891648F31D6F77A7D68_1839977534 = (holder.getBaseCertificateID() != null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_976870258 = holder.getBaseCertificateID().getSerial().getValue();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2029096477 = null;
        BigInteger varA7E53CE21691AB073D9660D615818899_1073872025; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1073872025 = varB4EAC82CA7396A68D541C85D26508E83_976870258;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1073872025 = varB4EAC82CA7396A68D541C85D26508E83_2029096477;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1073872025.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1073872025;
        // ---------- Original Method ----------
        //if (holder.getBaseCertificateID() != null)
        //{
            //return holder.getBaseCertificateID().getSerial().getValue();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.465 -0400", hash_original_method = "53037C58AFDDBA87577A0806677CF7E3", hash_generated_method = "88793AFB6CAB0AB4945A87BB65ED45B5")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_2070305650 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2070305650 = new AttributeCertificateHolder((ASN1Sequence)holder
            .toASN1Object());
        varB4EAC82CA7396A68D541C85D26508E83_2070305650.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2070305650;
        // ---------- Original Method ----------
        //return new AttributeCertificateHolder((ASN1Sequence)holder
            //.toASN1Object());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.466 -0400", hash_original_method = "656B19C882F86A200CE16DF3E12BB617", hash_generated_method = "3CDA128DDF59965927E7B500BC2A885D")
    public boolean match(Certificate cert) {
        X509Certificate x509Cert = (X509Certificate)cert;
        try 
        {
            {
                boolean varCD8D9929CB9B612AC7C5C247AD950045_705111161 = (holder.getBaseCertificateID() != null);
                {
                    boolean var713777CC943D49F059C6C78D02395635_733033235 = (holder.getBaseCertificateID().getSerial().getValue().equals(x509Cert.getSerialNumber())
                    && matchesDN(PrincipalUtil.getIssuerX509Principal(x509Cert), holder.getBaseCertificateID().getIssuer()));
                } //End block
            } //End collapsed parenthetic
            {
                boolean var043C375B7D24C609D43FA6271095CEFB_1548866293 = (holder.getEntityName() != null);
                {
                    {
                        boolean var4D1B566F96AD58A0EE5947F6B61F7E42_232253638 = (matchesDN(PrincipalUtil.getSubjectX509Principal(x509Cert),
                    holder.getEntityName()));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                boolean varE28D38A0601AF1BEE6077916DC0BEFA3_1127886238 = (holder.getObjectDigestInfo() != null);
                {
                    MessageDigest md = null;
                    try 
                    {
                        md = MessageDigest.getInstance(getDigestAlgorithm(), "BC");
                    } //End block
                    catch (Exception e)
                    { }
                    {
                        Object varD5350823B00B5CB81B7522CFE2E2FE95_2123039651 = (getDigestedObjectType());
                        //Begin case ObjectDigestInfo.publicKey 
                        md.update(cert.getPublicKey().getEncoded());
                        //End case ObjectDigestInfo.publicKey 
                        //Begin case ObjectDigestInfo.publicKeyCert 
                        md.update(cert.getEncoded());
                        //End case ObjectDigestInfo.publicKeyCert 
                    } //End collapsed parenthetic
                    {
                        boolean var063ABA0AB7E01A47DB85617EFD3BEDD2_1160848225 = (!Arrays.areEqual(md.digest(), getObjectDigest()));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (CertificateEncodingException e)
        { }
        addTaint(cert.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_51053619 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_51053619;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.466 -0400", hash_original_method = "DF0F926A4C6973AE80CA99906EB348D1", hash_generated_method = "DC290E3216BA0EF193FC4FBE67072171")
    public boolean equals(Object obj) {
        {
            boolean var8D1D3E5F4C020ED4FA594AED365B4BD8_1710278076 = (obj == this);
        } //End collapsed parenthetic
        AttributeCertificateHolder other = (AttributeCertificateHolder)obj;
        boolean var7A46D2D7A8ED9209E5177C4CFD1D3DF7_1702211827 = (this.holder.equals(other.holder));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1984166535 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1984166535;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.467 -0400", hash_original_method = "D89AAACD9C01672ED8F506F3741EB875", hash_generated_method = "C320853BC2088E4581CB0008C1F825B1")
    public int hashCode() {
        int varB18BEF20D6AF90260E4F0B17CC2FB081_942189754 = (this.holder.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_434948928 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_434948928;
        // ---------- Original Method ----------
        //return this.holder.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.467 -0400", hash_original_method = "A87301CDB1806806ACAD029929062C9D", hash_generated_method = "122F3F401C074E223627D20F69797FA7")
    public boolean match(Object obj) {
        boolean var05F15056D8F2045991D944D9B27E1F9C_577629784 = (match((Certificate)obj));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_391469765 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_391469765;
        // ---------- Original Method ----------
        //if (!(obj instanceof X509Certificate))
        //{
            //return false;
        //}
        //return match((Certificate)obj);
    }

    
}

