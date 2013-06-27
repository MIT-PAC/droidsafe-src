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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.053 -0400", hash_original_field = "A403F79916FA151CDCC745626E69FED2", hash_generated_field = "81EEF30676831ECD3948BE1C9E69FB41")

    Holder holder;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.061 -0400", hash_original_method = "5CADDEA19B83B0D9A5BBB8113D1E397F", hash_generated_method = "F59428356E32C4723CDCA0BF11B8E6A2")
      AttributeCertificateHolder(ASN1Sequence seq) {
        holder = Holder.getInstance(seq);
        // ---------- Original Method ----------
        //holder = Holder.getInstance(seq);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.063 -0400", hash_original_method = "36C6FF42848B06325DA653927B354FB6", hash_generated_method = "F8BAA13337AB237B2C07C3B22FEF3CB7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.064 -0400", hash_original_method = "AB8EF4A9C8EF2BF3AB56D333BEC2C930", hash_generated_method = "A5D725EEDD1630375670810031A27BC4")
    public  AttributeCertificateHolder(X500Principal issuerName,
        BigInteger serialNumber) {
        this(X509Util.convertPrincipal(issuerName), serialNumber);
        addTaint(issuerName.getTaint());
        addTaint(serialNumber.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.064 -0400", hash_original_method = "38A3680A490D691786DB1D5D606419F8", hash_generated_method = "CD162A3427ED91224E167F632B6282E5")
    public  AttributeCertificateHolder(X509Certificate cert) throws CertificateParsingException {
        X509Principal name;
        try 
        {
            name = PrincipalUtil.getIssuerX509Principal(cert);
        } //End block
        catch (Exception e)
        {
            if (DroidSafeAndroidRuntime.control) throw new CertificateParsingException(e.getMessage());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.064 -0400", hash_original_method = "BB3F8ED7A12081786FFA678549853DD7", hash_generated_method = "9DAC6696A4355E038108E0ADFA13A2E4")
    public  AttributeCertificateHolder(X509Principal principal) {
        holder = new Holder(generateGeneralNames(principal));
        // ---------- Original Method ----------
        //holder = new Holder(generateGeneralNames(principal));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.065 -0400", hash_original_method = "8754A1CB9EC37CB6374A9BB4689D9463", hash_generated_method = "887D0050DF99D6E04954A122736E8C21")
    public  AttributeCertificateHolder(X500Principal principal) {
        this(X509Util.convertPrincipal(principal));
        addTaint(principal.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.065 -0400", hash_original_method = "058E2AA05CCDB81429F1E94E1527F7B6", hash_generated_method = "55B74FCEB90EE5EEEC66BDDDFBED7FE8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.072 -0400", hash_original_method = "5DC58025DAD5ABD5E5609ED391A96DAB", hash_generated_method = "F8C4F7CE16CBE953D10146B985A360E1")
    public int getDigestedObjectType() {
        {
            boolean var67FBE00BCEDE85B76D609F8E7707FEB3_2131608802 = (holder.getObjectDigestInfo() != null);
            {
                int varC8A3E13F39776207B82715F8E3EEAE05_1464016099 = (holder.getObjectDigestInfo().getDigestedObjectType()
                .getValue().intValue());
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_690485261 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_690485261;
        // ---------- Original Method ----------
        //if (holder.getObjectDigestInfo() != null)
        //{
            //return holder.getObjectDigestInfo().getDigestedObjectType()
                //.getValue().intValue();
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.080 -0400", hash_original_method = "44CC065F66E7FDD5B9E2538C14A00A59", hash_generated_method = "575FA66CAC71AF72DFA27DB788734295")
    public String getDigestAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_1050924580 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_436039161 = null; //Variable for return #2
        {
            boolean var67FBE00BCEDE85B76D609F8E7707FEB3_1450218399 = (holder.getObjectDigestInfo() != null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1050924580 = holder.getObjectDigestInfo().getDigestAlgorithm().getObjectId()
                .getId();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_436039161 = null;
        String varA7E53CE21691AB073D9660D615818899_751493287; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_751493287 = varB4EAC82CA7396A68D541C85D26508E83_1050924580;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_751493287 = varB4EAC82CA7396A68D541C85D26508E83_436039161;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_751493287.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_751493287;
        // ---------- Original Method ----------
        //if (holder.getObjectDigestInfo() != null)
        //{
            //return holder.getObjectDigestInfo().getDigestAlgorithm().getObjectId()
                //.getId();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.082 -0400", hash_original_method = "4B9D866BC14850DF9DC3D05B3C536D79", hash_generated_method = "1F9DF48645070A5FD552CBA5B75A1725")
    public byte[] getObjectDigest() {
        {
            boolean var67FBE00BCEDE85B76D609F8E7707FEB3_252185583 = (holder.getObjectDigestInfo() != null);
            {
                byte[] var4554620765784B592F5555B759A81D8A_1718375067 = (holder.getObjectDigestInfo().getObjectDigest().getBytes());
            } //End block
        } //End collapsed parenthetic
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_142705948 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_142705948;
        // ---------- Original Method ----------
        //if (holder.getObjectDigestInfo() != null)
        //{
            //return holder.getObjectDigestInfo().getObjectDigest().getBytes();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.083 -0400", hash_original_method = "D91C38C78BDA175ED1B06895DD027E8A", hash_generated_method = "C88C2A17CFF4BDF3326C8BDD0B2318F9")
    public String getOtherObjectTypeID() {
        String varB4EAC82CA7396A68D541C85D26508E83_185470621 = null; //Variable for return #1
        {
            boolean var67FBE00BCEDE85B76D609F8E7707FEB3_568498400 = (holder.getObjectDigestInfo() != null);
            {
                holder.getObjectDigestInfo().getOtherObjectTypeID().getId();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_185470621 = null;
        varB4EAC82CA7396A68D541C85D26508E83_185470621.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_185470621;
        // ---------- Original Method ----------
        //if (holder.getObjectDigestInfo() != null)
        //{
            //holder.getObjectDigestInfo().getOtherObjectTypeID().getId();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.084 -0400", hash_original_method = "813AC8AE1843F5B7087E11CB016E8403", hash_generated_method = "F38988EB62909A9C40E29659FE89638E")
    private GeneralNames generateGeneralNames(X509Principal principal) {
        GeneralNames varB4EAC82CA7396A68D541C85D26508E83_1077680902 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1077680902 = new GeneralNames(new DERSequence(new GeneralName(principal)));
        addTaint(principal.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1077680902.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1077680902;
        // ---------- Original Method ----------
        //return new GeneralNames(new DERSequence(new GeneralName(principal)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.084 -0400", hash_original_method = "938EE7D821BB407EF13AE79847029298", hash_generated_method = "3C64D24DDD8C8668349D25B8C9AE7E91")
    private boolean matchesDN(X509Principal subject, GeneralNames targets) {
        GeneralName[] names;
        names = targets.getNames();
        {
            int i;
            i = 0;
            {
                GeneralName gn;
                gn = names[i];
                {
                    boolean varA8A9F7FA995044FDF9256505CA308CC1_1633534422 = (gn.getTagNo() == GeneralName.directoryName);
                    {
                        try 
                        {
                            {
                                boolean varAE8E2DCE8F2E51411D749311B36CB149_883136784 = (new X509Principal(((ASN1Encodable)gn.getName())
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1363940395 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1363940395;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.120 -0400", hash_original_method = "7552EC21B75F1C8319E3B7352977E9CE", hash_generated_method = "D0E1D0562C0287B2D046CF068E483319")
    private Object[] getNames(GeneralName[] names) {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_1362118462 = null; //Variable for return #1
        List l;
        l = new ArrayList(names.length);
        {
            int i;
            i = 0;
            {
                {
                    boolean var6E81B5710B8121FC654755546F549F39_621577108 = (names[i].getTagNo() == GeneralName.directoryName);
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
        varB4EAC82CA7396A68D541C85D26508E83_1362118462 = l.toArray(new Object[l.size()]);
        addTaint(names[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1362118462.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1362118462;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.121 -0400", hash_original_method = "2BE9B6F72BB32A06F2A43AB8DF17A2B5", hash_generated_method = "6C42850243B3A17FD425CA03662A44B9")
    private Principal[] getPrincipals(GeneralNames names) {
        Principal[] varB4EAC82CA7396A68D541C85D26508E83_418706278 = null; //Variable for return #1
        Object[] p;
        p = this.getNames(names.getNames());
        List l;
        l = new ArrayList();
        {
            int i;
            i = 0;
            {
                {
                    l.add(p[i]);
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_418706278 = (Principal[])l.toArray(new Principal[l.size()]);
        addTaint(names.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_418706278.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_418706278;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.122 -0400", hash_original_method = "DB0C376D8871308D29988D3B3AAF17FC", hash_generated_method = "FA274F639A63A4E7887017D1D465396C")
    public Principal[] getEntityNames() {
        Principal[] varB4EAC82CA7396A68D541C85D26508E83_1599442758 = null; //Variable for return #1
        Principal[] varB4EAC82CA7396A68D541C85D26508E83_931976997 = null; //Variable for return #2
        {
            boolean var7D8EA0A0A35E3CD3453BBE8B1FA89E85_628143331 = (holder.getEntityName() != null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1599442758 = getPrincipals(holder.getEntityName());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_931976997 = null;
        Principal[] varA7E53CE21691AB073D9660D615818899_1430377798; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1430377798 = varB4EAC82CA7396A68D541C85D26508E83_1599442758;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1430377798 = varB4EAC82CA7396A68D541C85D26508E83_931976997;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1430377798.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1430377798;
        // ---------- Original Method ----------
        //if (holder.getEntityName() != null)
        //{
            //return getPrincipals(holder.getEntityName());
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.123 -0400", hash_original_method = "4F5AD36C2F60574BEE36BBEC8A3F8872", hash_generated_method = "4362FF9FD03356C48739AFF0B3193E61")
    public Principal[] getIssuer() {
        Principal[] varB4EAC82CA7396A68D541C85D26508E83_241056168 = null; //Variable for return #1
        Principal[] varB4EAC82CA7396A68D541C85D26508E83_1524104845 = null; //Variable for return #2
        {
            boolean var4D503B20E9F1E891648F31D6F77A7D68_506078418 = (holder.getBaseCertificateID() != null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_241056168 = getPrincipals(holder.getBaseCertificateID().getIssuer());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1524104845 = null;
        Principal[] varA7E53CE21691AB073D9660D615818899_1512949694; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1512949694 = varB4EAC82CA7396A68D541C85D26508E83_241056168;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1512949694 = varB4EAC82CA7396A68D541C85D26508E83_1524104845;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1512949694.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1512949694;
        // ---------- Original Method ----------
        //if (holder.getBaseCertificateID() != null)
        //{
            //return getPrincipals(holder.getBaseCertificateID().getIssuer());
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.126 -0400", hash_original_method = "6708CF3972ED2FC7BE75744CEC7FD162", hash_generated_method = "A618F198F3FCC23521CE5FB9C58B4E0D")
    public BigInteger getSerialNumber() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_732525202 = null; //Variable for return #1
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1196206729 = null; //Variable for return #2
        {
            boolean var4D503B20E9F1E891648F31D6F77A7D68_2036811705 = (holder.getBaseCertificateID() != null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_732525202 = holder.getBaseCertificateID().getSerial().getValue();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1196206729 = null;
        BigInteger varA7E53CE21691AB073D9660D615818899_402055193; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_402055193 = varB4EAC82CA7396A68D541C85D26508E83_732525202;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_402055193 = varB4EAC82CA7396A68D541C85D26508E83_1196206729;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_402055193.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_402055193;
        // ---------- Original Method ----------
        //if (holder.getBaseCertificateID() != null)
        //{
            //return holder.getBaseCertificateID().getSerial().getValue();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.127 -0400", hash_original_method = "53037C58AFDDBA87577A0806677CF7E3", hash_generated_method = "7AA9CA0877862ABF742F0EC8C883332A")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_500687198 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_500687198 = new AttributeCertificateHolder((ASN1Sequence)holder
            .toASN1Object());
        varB4EAC82CA7396A68D541C85D26508E83_500687198.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_500687198;
        // ---------- Original Method ----------
        //return new AttributeCertificateHolder((ASN1Sequence)holder
            //.toASN1Object());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.139 -0400", hash_original_method = "656B19C882F86A200CE16DF3E12BB617", hash_generated_method = "B744FC360B4FC9AF98D902DF56388208")
    public boolean match(Certificate cert) {
        X509Certificate x509Cert;
        x509Cert = (X509Certificate)cert;
        try 
        {
            {
                boolean varCD8D9929CB9B612AC7C5C247AD950045_398740652 = (holder.getBaseCertificateID() != null);
                {
                    boolean var713777CC943D49F059C6C78D02395635_967764877 = (holder.getBaseCertificateID().getSerial().getValue().equals(x509Cert.getSerialNumber())
                    && matchesDN(PrincipalUtil.getIssuerX509Principal(x509Cert), holder.getBaseCertificateID().getIssuer()));
                } //End block
            } //End collapsed parenthetic
            {
                boolean var043C375B7D24C609D43FA6271095CEFB_75307199 = (holder.getEntityName() != null);
                {
                    {
                        boolean var4D1B566F96AD58A0EE5947F6B61F7E42_598477706 = (matchesDN(PrincipalUtil.getSubjectX509Principal(x509Cert),
                    holder.getEntityName()));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                boolean varE28D38A0601AF1BEE6077916DC0BEFA3_405178763 = (holder.getObjectDigestInfo() != null);
                {
                    MessageDigest md;
                    md = null;
                    try 
                    {
                        md = MessageDigest.getInstance(getDigestAlgorithm(), "BC");
                    } //End block
                    catch (Exception e)
                    { }
                    {
                        Object varD5350823B00B5CB81B7522CFE2E2FE95_1037658342 = (getDigestedObjectType());
                        //Begin case ObjectDigestInfo.publicKey 
                        md.update(cert.getPublicKey().getEncoded());
                        //End case ObjectDigestInfo.publicKey 
                        //Begin case ObjectDigestInfo.publicKeyCert 
                        md.update(cert.getEncoded());
                        //End case ObjectDigestInfo.publicKeyCert 
                    } //End collapsed parenthetic
                    {
                        boolean var063ABA0AB7E01A47DB85617EFD3BEDD2_1155516408 = (!Arrays.areEqual(md.digest(), getObjectDigest()));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (CertificateEncodingException e)
        { }
        addTaint(cert.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_164003867 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_164003867;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.143 -0400", hash_original_method = "DF0F926A4C6973AE80CA99906EB348D1", hash_generated_method = "A0727B0B2F8B9DC7E1CE90F1AB0FA0BB")
    public boolean equals(Object obj) {
        {
            boolean var8D1D3E5F4C020ED4FA594AED365B4BD8_1910123273 = (obj == this);
        } //End collapsed parenthetic
        AttributeCertificateHolder other;
        other = (AttributeCertificateHolder)obj;
        boolean var7A46D2D7A8ED9209E5177C4CFD1D3DF7_1626343964 = (this.holder.equals(other.holder));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2045637620 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2045637620;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.145 -0400", hash_original_method = "D89AAACD9C01672ED8F506F3741EB875", hash_generated_method = "4923421ECC0250EC8B6DBF579D47BDF7")
    public int hashCode() {
        int varB18BEF20D6AF90260E4F0B17CC2FB081_1225818128 = (this.holder.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1897268821 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1897268821;
        // ---------- Original Method ----------
        //return this.holder.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.152 -0400", hash_original_method = "A87301CDB1806806ACAD029929062C9D", hash_generated_method = "29D0D2D6D0468701813E04D4BCB70453")
    public boolean match(Object obj) {
        boolean var05F15056D8F2045991D944D9B27E1F9C_210024342 = (match((Certificate)obj));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1257912427 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1257912427;
        // ---------- Original Method ----------
        //if (!(obj instanceof X509Certificate))
        //{
            //return false;
        //}
        //return match((Certificate)obj);
    }

    
}

