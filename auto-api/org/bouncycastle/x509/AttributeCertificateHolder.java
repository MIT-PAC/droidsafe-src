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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.024 -0400", hash_original_field = "A403F79916FA151CDCC745626E69FED2", hash_generated_field = "81EEF30676831ECD3948BE1C9E69FB41")

    Holder holder;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.025 -0400", hash_original_method = "5CADDEA19B83B0D9A5BBB8113D1E397F", hash_generated_method = "F59428356E32C4723CDCA0BF11B8E6A2")
      AttributeCertificateHolder(ASN1Sequence seq) {
        holder = Holder.getInstance(seq);
        // ---------- Original Method ----------
        //holder = Holder.getInstance(seq);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.036 -0400", hash_original_method = "36C6FF42848B06325DA653927B354FB6", hash_generated_method = "F8BAA13337AB237B2C07C3B22FEF3CB7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.036 -0400", hash_original_method = "AB8EF4A9C8EF2BF3AB56D333BEC2C930", hash_generated_method = "A5D725EEDD1630375670810031A27BC4")
    public  AttributeCertificateHolder(X500Principal issuerName,
        BigInteger serialNumber) {
        this(X509Util.convertPrincipal(issuerName), serialNumber);
        addTaint(issuerName.getTaint());
        addTaint(serialNumber.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.037 -0400", hash_original_method = "38A3680A490D691786DB1D5D606419F8", hash_generated_method = "CD162A3427ED91224E167F632B6282E5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.037 -0400", hash_original_method = "BB3F8ED7A12081786FFA678549853DD7", hash_generated_method = "9DAC6696A4355E038108E0ADFA13A2E4")
    public  AttributeCertificateHolder(X509Principal principal) {
        holder = new Holder(generateGeneralNames(principal));
        // ---------- Original Method ----------
        //holder = new Holder(generateGeneralNames(principal));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.038 -0400", hash_original_method = "8754A1CB9EC37CB6374A9BB4689D9463", hash_generated_method = "887D0050DF99D6E04954A122736E8C21")
    public  AttributeCertificateHolder(X500Principal principal) {
        this(X509Util.convertPrincipal(principal));
        addTaint(principal.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.042 -0400", hash_original_method = "058E2AA05CCDB81429F1E94E1527F7B6", hash_generated_method = "55B74FCEB90EE5EEEC66BDDDFBED7FE8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.043 -0400", hash_original_method = "5DC58025DAD5ABD5E5609ED391A96DAB", hash_generated_method = "F3572E678D61CF1449E02E32C11B4BE4")
    public int getDigestedObjectType() {
        {
            boolean var67FBE00BCEDE85B76D609F8E7707FEB3_398052573 = (holder.getObjectDigestInfo() != null);
            {
                int varC8A3E13F39776207B82715F8E3EEAE05_536047854 = (holder.getObjectDigestInfo().getDigestedObjectType()
                .getValue().intValue());
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_315072644 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_315072644;
        // ---------- Original Method ----------
        //if (holder.getObjectDigestInfo() != null)
        //{
            //return holder.getObjectDigestInfo().getDigestedObjectType()
                //.getValue().intValue();
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.043 -0400", hash_original_method = "44CC065F66E7FDD5B9E2538C14A00A59", hash_generated_method = "1001A5E5FD449D8688B45E1679A47749")
    public String getDigestAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_414644536 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_347863171 = null; //Variable for return #2
        {
            boolean var67FBE00BCEDE85B76D609F8E7707FEB3_1200040290 = (holder.getObjectDigestInfo() != null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_414644536 = holder.getObjectDigestInfo().getDigestAlgorithm().getObjectId()
                .getId();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_347863171 = null;
        String varA7E53CE21691AB073D9660D615818899_1298199273; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1298199273 = varB4EAC82CA7396A68D541C85D26508E83_414644536;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1298199273 = varB4EAC82CA7396A68D541C85D26508E83_347863171;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1298199273.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1298199273;
        // ---------- Original Method ----------
        //if (holder.getObjectDigestInfo() != null)
        //{
            //return holder.getObjectDigestInfo().getDigestAlgorithm().getObjectId()
                //.getId();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.061 -0400", hash_original_method = "4B9D866BC14850DF9DC3D05B3C536D79", hash_generated_method = "649B9CEC709C7AF06ACCB29319E22787")
    public byte[] getObjectDigest() {
        {
            boolean var67FBE00BCEDE85B76D609F8E7707FEB3_1099948011 = (holder.getObjectDigestInfo() != null);
            {
                byte[] var4554620765784B592F5555B759A81D8A_1811382950 = (holder.getObjectDigestInfo().getObjectDigest().getBytes());
            } //End block
        } //End collapsed parenthetic
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_860096045 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_860096045;
        // ---------- Original Method ----------
        //if (holder.getObjectDigestInfo() != null)
        //{
            //return holder.getObjectDigestInfo().getObjectDigest().getBytes();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.061 -0400", hash_original_method = "D91C38C78BDA175ED1B06895DD027E8A", hash_generated_method = "14C0E60A1E7CD50C4FCD2A1A0FC4CF67")
    public String getOtherObjectTypeID() {
        String varB4EAC82CA7396A68D541C85D26508E83_1343662336 = null; //Variable for return #1
        {
            boolean var67FBE00BCEDE85B76D609F8E7707FEB3_1277951000 = (holder.getObjectDigestInfo() != null);
            {
                holder.getObjectDigestInfo().getOtherObjectTypeID().getId();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1343662336 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1343662336.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1343662336;
        // ---------- Original Method ----------
        //if (holder.getObjectDigestInfo() != null)
        //{
            //holder.getObjectDigestInfo().getOtherObjectTypeID().getId();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.062 -0400", hash_original_method = "813AC8AE1843F5B7087E11CB016E8403", hash_generated_method = "2EAA88FAEF6132E8D31569D31F1237D8")
    private GeneralNames generateGeneralNames(X509Principal principal) {
        GeneralNames varB4EAC82CA7396A68D541C85D26508E83_233587776 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_233587776 = new GeneralNames(new DERSequence(new GeneralName(principal)));
        addTaint(principal.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_233587776.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_233587776;
        // ---------- Original Method ----------
        //return new GeneralNames(new DERSequence(new GeneralName(principal)));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.063 -0400", hash_original_method = "938EE7D821BB407EF13AE79847029298", hash_generated_method = "294D7D906D759B2303C5D5E9EBAD3852")
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
                    boolean varA8A9F7FA995044FDF9256505CA308CC1_646840765 = (gn.getTagNo() == GeneralName.directoryName);
                    {
                        try 
                        {
                            {
                                boolean varAE8E2DCE8F2E51411D749311B36CB149_402057173 = (new X509Principal(((ASN1Encodable)gn.getName())
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1870327182 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1870327182;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.064 -0400", hash_original_method = "7552EC21B75F1C8319E3B7352977E9CE", hash_generated_method = "D5BD0543A9FA0E22A5D83A449AA986CA")
    private Object[] getNames(GeneralName[] names) {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_2048047837 = null; //Variable for return #1
        List l;
        l = new ArrayList(names.length);
        {
            int i;
            i = 0;
            {
                {
                    boolean var6E81B5710B8121FC654755546F549F39_1618230506 = (names[i].getTagNo() == GeneralName.directoryName);
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
        varB4EAC82CA7396A68D541C85D26508E83_2048047837 = l.toArray(new Object[l.size()]);
        addTaint(names[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2048047837.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2048047837;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.065 -0400", hash_original_method = "2BE9B6F72BB32A06F2A43AB8DF17A2B5", hash_generated_method = "2258A92F94BD1586FCE18AFA799E960A")
    private Principal[] getPrincipals(GeneralNames names) {
        Principal[] varB4EAC82CA7396A68D541C85D26508E83_1633253025 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1633253025 = (Principal[])l.toArray(new Principal[l.size()]);
        addTaint(names.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1633253025.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1633253025;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.065 -0400", hash_original_method = "DB0C376D8871308D29988D3B3AAF17FC", hash_generated_method = "A8C49CCD02F66922C0081ADF873553B9")
    public Principal[] getEntityNames() {
        Principal[] varB4EAC82CA7396A68D541C85D26508E83_1961529166 = null; //Variable for return #1
        Principal[] varB4EAC82CA7396A68D541C85D26508E83_79891942 = null; //Variable for return #2
        {
            boolean var7D8EA0A0A35E3CD3453BBE8B1FA89E85_1511784503 = (holder.getEntityName() != null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1961529166 = getPrincipals(holder.getEntityName());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_79891942 = null;
        Principal[] varA7E53CE21691AB073D9660D615818899_1070755542; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1070755542 = varB4EAC82CA7396A68D541C85D26508E83_1961529166;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1070755542 = varB4EAC82CA7396A68D541C85D26508E83_79891942;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1070755542.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1070755542;
        // ---------- Original Method ----------
        //if (holder.getEntityName() != null)
        //{
            //return getPrincipals(holder.getEntityName());
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.066 -0400", hash_original_method = "4F5AD36C2F60574BEE36BBEC8A3F8872", hash_generated_method = "DA5477058ACC9A9B755D0CF41F79B1EB")
    public Principal[] getIssuer() {
        Principal[] varB4EAC82CA7396A68D541C85D26508E83_1257686305 = null; //Variable for return #1
        Principal[] varB4EAC82CA7396A68D541C85D26508E83_741563111 = null; //Variable for return #2
        {
            boolean var4D503B20E9F1E891648F31D6F77A7D68_1706543957 = (holder.getBaseCertificateID() != null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1257686305 = getPrincipals(holder.getBaseCertificateID().getIssuer());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_741563111 = null;
        Principal[] varA7E53CE21691AB073D9660D615818899_1157675123; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1157675123 = varB4EAC82CA7396A68D541C85D26508E83_1257686305;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1157675123 = varB4EAC82CA7396A68D541C85D26508E83_741563111;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1157675123.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1157675123;
        // ---------- Original Method ----------
        //if (holder.getBaseCertificateID() != null)
        //{
            //return getPrincipals(holder.getBaseCertificateID().getIssuer());
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.080 -0400", hash_original_method = "6708CF3972ED2FC7BE75744CEC7FD162", hash_generated_method = "D4CE6C287DC80298CB3337934E332E0D")
    public BigInteger getSerialNumber() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_543378685 = null; //Variable for return #1
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1679014610 = null; //Variable for return #2
        {
            boolean var4D503B20E9F1E891648F31D6F77A7D68_421615266 = (holder.getBaseCertificateID() != null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_543378685 = holder.getBaseCertificateID().getSerial().getValue();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1679014610 = null;
        BigInteger varA7E53CE21691AB073D9660D615818899_188351992; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_188351992 = varB4EAC82CA7396A68D541C85D26508E83_543378685;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_188351992 = varB4EAC82CA7396A68D541C85D26508E83_1679014610;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_188351992.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_188351992;
        // ---------- Original Method ----------
        //if (holder.getBaseCertificateID() != null)
        //{
            //return holder.getBaseCertificateID().getSerial().getValue();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.080 -0400", hash_original_method = "53037C58AFDDBA87577A0806677CF7E3", hash_generated_method = "2D3772997B9F37D94D34ADD7BF425F3C")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_711658226 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_711658226 = new AttributeCertificateHolder((ASN1Sequence)holder
            .toASN1Object());
        varB4EAC82CA7396A68D541C85D26508E83_711658226.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_711658226;
        // ---------- Original Method ----------
        //return new AttributeCertificateHolder((ASN1Sequence)holder
            //.toASN1Object());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.081 -0400", hash_original_method = "656B19C882F86A200CE16DF3E12BB617", hash_generated_method = "E4CF07C76B66D86015ECBA258C544233")
    public boolean match(Certificate cert) {
        X509Certificate x509Cert;
        x509Cert = (X509Certificate)cert;
        try 
        {
            {
                boolean varCD8D9929CB9B612AC7C5C247AD950045_629405222 = (holder.getBaseCertificateID() != null);
                {
                    boolean var713777CC943D49F059C6C78D02395635_2119773665 = (holder.getBaseCertificateID().getSerial().getValue().equals(x509Cert.getSerialNumber())
                    && matchesDN(PrincipalUtil.getIssuerX509Principal(x509Cert), holder.getBaseCertificateID().getIssuer()));
                } //End block
            } //End collapsed parenthetic
            {
                boolean var043C375B7D24C609D43FA6271095CEFB_348058559 = (holder.getEntityName() != null);
                {
                    {
                        boolean var4D1B566F96AD58A0EE5947F6B61F7E42_1650916487 = (matchesDN(PrincipalUtil.getSubjectX509Principal(x509Cert),
                    holder.getEntityName()));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                boolean varE28D38A0601AF1BEE6077916DC0BEFA3_1389884402 = (holder.getObjectDigestInfo() != null);
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
                        Object varD5350823B00B5CB81B7522CFE2E2FE95_1161981854 = (getDigestedObjectType());
                        //Begin case ObjectDigestInfo.publicKey 
                        md.update(cert.getPublicKey().getEncoded());
                        //End case ObjectDigestInfo.publicKey 
                        //Begin case ObjectDigestInfo.publicKeyCert 
                        md.update(cert.getEncoded());
                        //End case ObjectDigestInfo.publicKeyCert 
                    } //End collapsed parenthetic
                    {
                        boolean var063ABA0AB7E01A47DB85617EFD3BEDD2_1116741622 = (!Arrays.areEqual(md.digest(), getObjectDigest()));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (CertificateEncodingException e)
        { }
        addTaint(cert.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1930357894 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1930357894;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.082 -0400", hash_original_method = "DF0F926A4C6973AE80CA99906EB348D1", hash_generated_method = "FDCBDBAFC294E23104B74891CE581427")
    public boolean equals(Object obj) {
        {
            boolean var8D1D3E5F4C020ED4FA594AED365B4BD8_1393440594 = (obj == this);
        } //End collapsed parenthetic
        AttributeCertificateHolder other;
        other = (AttributeCertificateHolder)obj;
        boolean var7A46D2D7A8ED9209E5177C4CFD1D3DF7_444112893 = (this.holder.equals(other.holder));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_951128136 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_951128136;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.083 -0400", hash_original_method = "D89AAACD9C01672ED8F506F3741EB875", hash_generated_method = "4B45B36B1BF3D6B17CFB6FFF4E285F0E")
    public int hashCode() {
        int varB18BEF20D6AF90260E4F0B17CC2FB081_1589345773 = (this.holder.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1660341311 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1660341311;
        // ---------- Original Method ----------
        //return this.holder.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.083 -0400", hash_original_method = "A87301CDB1806806ACAD029929062C9D", hash_generated_method = "AD9EA73BE50399FCB9A20134AC178E88")
    public boolean match(Object obj) {
        boolean var05F15056D8F2045991D944D9B27E1F9C_534961853 = (match((Certificate)obj));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1565140387 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1565140387;
        // ---------- Original Method ----------
        //if (!(obj instanceof X509Certificate))
        //{
            //return false;
        //}
        //return match((Certificate)obj);
    }

    
}

