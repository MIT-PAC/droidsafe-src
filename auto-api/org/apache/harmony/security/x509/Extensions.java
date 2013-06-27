package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.760 -0400", hash_original_field = "2AC737D240FC746CEF37129B7569F08E", hash_generated_field = "F93AA8349A2FA92AE6135244F491401E")

    private List<Extension> extensions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.760 -0400", hash_original_field = "7E85BCB66FB9A809D5AB4F62A8B8BEA8", hash_generated_field = "8AE6968FB7018EBEDA25C054995E291B")

    private Set<String> critical;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.760 -0400", hash_original_field = "ACC02843792BA46B7A7EB0B1788A22C6", hash_generated_field = "6827F144A18995AA402D9FA96B7DCC8C")

    private Set<String> noncritical;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.760 -0400", hash_original_field = "416ECF4BA061CEB2F9353023282FCF57", hash_generated_field = "7B4E2AB69860A448C1B3D04CF6B0EB86")

    private boolean hasUnsupported;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.760 -0400", hash_original_field = "38BC3F68B4757D145BD31C0F88C48214", hash_generated_field = "3CBB0703D1DDEAD49B98A4F5CB8F1949")

    private HashMap<String, Extension> oidMap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.760 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.760 -0400", hash_original_method = "4F6254C867328A153FDD5BD23453E816", hash_generated_method = "8D1DB2771425E2517B9F7DC7528BABC1")
    public  Extensions() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.760 -0400", hash_original_method = "89146A86DD080B3422EC5033031F1DF4", hash_generated_method = "EBF9C74A91F031E9B43BDAD943D3244E")
    public  Extensions(List<Extension> extensions) {
        this.extensions = extensions;
        // ---------- Original Method ----------
        //this.extensions = extensions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.772 -0400", hash_original_method = "B4520EB3CA6AF47BBFFA43544D7C2D00", hash_generated_method = "29EDC1553B91947BAA9A6F237ADB0570")
    public int size() {
        {
            Object var25C8BD0175A5F6C233FBF28199D5859F_1599804666 = (extensions.size());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1243433489 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1243433489;
        // ---------- Original Method ----------
        //return (extensions == null) ? 0 : extensions.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.773 -0400", hash_original_method = "6A8A6C791C17F1564EF710302C5F6E38", hash_generated_method = "AB05F870A231B5E44E35FB63E53554C3")
    public Set<String> getCriticalExtensions() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_117367994 = null; //Variable for return #1
        {
            makeOidsLists();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_117367994 = critical;
        varB4EAC82CA7396A68D541C85D26508E83_117367994.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_117367994;
        // ---------- Original Method ----------
        //if (critical == null) {
            //makeOidsLists();
        //}
        //return critical;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.773 -0400", hash_original_method = "A9814A684588F34F98E6563F2443DAA6", hash_generated_method = "9A770F74F76928B52B0792CD2D1ED4D9")
    public Set<String> getNonCriticalExtensions() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1278067856 = null; //Variable for return #1
        {
            makeOidsLists();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1278067856 = noncritical;
        varB4EAC82CA7396A68D541C85D26508E83_1278067856.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1278067856;
        // ---------- Original Method ----------
        //if (noncritical == null) {
            //makeOidsLists();
        //}
        //return noncritical;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.774 -0400", hash_original_method = "CA1C7754653BDDEC58CFB11BB71C11DB", hash_generated_method = "BD28B6A209A7A53CED15B8C7CE5037F3")
    public boolean hasUnsupportedCritical() {
        {
            makeOidsLists();
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2023112231 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2023112231;
        // ---------- Original Method ----------
        //if (critical == null) {
            //makeOidsLists();
        //}
        //return hasUnsupported;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.801 -0400", hash_original_method = "F144B02FA833AD81E1DCC6E0D8E9952F", hash_generated_method = "01297637FFB467BB54887341F4BA81BD")
    private void makeOidsLists() {
        int size;
        size = extensions.size();
        critical = new HashSet<String>(size);
        noncritical = new HashSet<String>(size);
        {
            Iterator<Extension> var8FD9017ABC8765E97936874D90CDB6D8_1000922212 = (extensions).iterator();
            var8FD9017ABC8765E97936874D90CDB6D8_1000922212.hasNext();
            Extension extension = var8FD9017ABC8765E97936874D90CDB6D8_1000922212.next();
            {
                String oid;
                oid = extension.getExtnID();
                {
                    boolean var890C8545AA65378EB03A21B27E363703_678820446 = (extension.getCritical());
                    {
                        {
                            boolean var055078D0CE1FA9550F7F9B8CC0B361FD_1215846105 = (!SUPPORTED_CRITICAL.contains(oid));
                            {
                                hasUnsupported = true;
                            } //End block
                        } //End collapsed parenthetic
                        critical.add(oid);
                    } //End block
                    {
                        noncritical.add(oid);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.832 -0400", hash_original_method = "44703E9781E0014C266798D0DB277AFC", hash_generated_method = "5F5D3723B2506E40D3EEC87A14D6FF9D")
    public Extension getExtensionByOID(String oid) {
        Extension varB4EAC82CA7396A68D541C85D26508E83_1358471172 = null; //Variable for return #1
        Extension varB4EAC82CA7396A68D541C85D26508E83_759256632 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1358471172 = null;
        } //End block
        {
            oidMap = new HashMap<String, Extension>();
            {
                Iterator<Extension> var8FD9017ABC8765E97936874D90CDB6D8_1224186790 = (extensions).iterator();
                var8FD9017ABC8765E97936874D90CDB6D8_1224186790.hasNext();
                Extension extension = var8FD9017ABC8765E97936874D90CDB6D8_1224186790.next();
                {
                    oidMap.put(extension.getExtnID(), extension);
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_759256632 = oidMap.get(oid);
        addTaint(oid.getTaint());
        Extension varA7E53CE21691AB073D9660D615818899_386031036; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_386031036 = varB4EAC82CA7396A68D541C85D26508E83_1358471172;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_386031036 = varB4EAC82CA7396A68D541C85D26508E83_759256632;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_386031036.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_386031036;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.832 -0400", hash_original_method = "67C71F044BBB9B405BEFA4564A602892", hash_generated_method = "E7248E3136A0C64FF0457C015CCB1EEF")
    public boolean[] valueOfKeyUsage() {
        Extension extension;
        extension = getExtensionByOID("2.5.29.15");
        KeyUsage kUsage;
        {
            boolean varF3595B2B157720F192ED02C0BBBDFB37_436070044 = ((extension == null) || ((kUsage = extension.getKeyUsageValue()) == null));
        } //End collapsed parenthetic
        boolean[] var511ABEB91310283286824915011853D8_306222891 = (kUsage.getKeyUsage());
        boolean[] var503EB2F420079C4024483971CE5EDEA8_616393910 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_616393910;
        // ---------- Original Method ----------
        //Extension extension = getExtensionByOID("2.5.29.15");
        //KeyUsage kUsage;
        //if ((extension == null) || ((kUsage = extension.getKeyUsageValue()) == null)) {
            //return null;
        //}
        //return kUsage.getKeyUsage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.833 -0400", hash_original_method = "84A63CE35CC08D6818168132AFB51A65", hash_generated_method = "6C0CA0A9DF1F6B4530F0C52C272AEEFD")
    public List<String> valueOfExtendedKeyUsage() throws IOException {
        List<String> varB4EAC82CA7396A68D541C85D26508E83_1741348145 = null; //Variable for return #1
        List<String> varB4EAC82CA7396A68D541C85D26508E83_3959398 = null; //Variable for return #2
        Extension extension;
        extension = getExtensionByOID("2.5.29.37");
        {
            varB4EAC82CA7396A68D541C85D26508E83_1741348145 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_3959398 = ((ExtendedKeyUsage) extension.getDecodedExtensionValue()).getExtendedKeyUsage();
        List<String> varA7E53CE21691AB073D9660D615818899_1328304075; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1328304075 = varB4EAC82CA7396A68D541C85D26508E83_1741348145;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1328304075 = varB4EAC82CA7396A68D541C85D26508E83_3959398;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1328304075.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1328304075;
        // ---------- Original Method ----------
        //Extension extension = getExtensionByOID("2.5.29.37");
        //if (extension == null) {
            //return null;
        //}
        //return ((ExtendedKeyUsage) extension.getDecodedExtensionValue()).getExtendedKeyUsage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.833 -0400", hash_original_method = "CD9DAABD8089C73414664CD384AA791C", hash_generated_method = "53369CB9ACAD2500AD3A4296274BEC7B")
    public int valueOfBasicConstrains() {
        Extension extension;
        extension = getExtensionByOID("2.5.29.19");
        BasicConstraints bc;
        {
            boolean varD6D8B93AD6192498EF11D9085C76974A_979066630 = ((extension == null) || ((bc = extension.getBasicConstraintsValue()) == null));
        } //End collapsed parenthetic
        int varD9665725528058AFF959C1C75668237D_1177771798 = (bc.getPathLenConstraint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2018876452 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2018876452;
        // ---------- Original Method ----------
        //Extension extension = getExtensionByOID("2.5.29.19");
        //BasicConstraints bc;
        //if ((extension == null) || ((bc = extension.getBasicConstraintsValue()) == null)) {
            //return Integer.MAX_VALUE;
        //}
        //return bc.getPathLenConstraint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.846 -0400", hash_original_method = "05742F8CFC468BD801B4E723F95A84AD", hash_generated_method = "F6CA0BE696971CF3F90F2EDF7DD74A16")
    public Collection<List<?>> valueOfSubjectAlternativeName() throws IOException {
        Collection<List<?>> varB4EAC82CA7396A68D541C85D26508E83_459071942 = null; //Variable for return #1
        Collection<List<?>> varB4EAC82CA7396A68D541C85D26508E83_54629154 = null; //Variable for return #2
        Extension extension;
        extension = getExtensionByOID("2.5.29.17");
        {
            varB4EAC82CA7396A68D541C85D26508E83_459071942 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_54629154 = ((GeneralNames) GeneralNames.ASN1.decode(extension.getExtnValue())).getPairsList();
        Collection<List<?>> varA7E53CE21691AB073D9660D615818899_1516833407; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1516833407 = varB4EAC82CA7396A68D541C85D26508E83_459071942;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1516833407 = varB4EAC82CA7396A68D541C85D26508E83_54629154;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1516833407.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1516833407;
        // ---------- Original Method ----------
        //Extension extension = getExtensionByOID("2.5.29.17");
        //if (extension == null) {
            //return null;
        //}
        //return ((GeneralNames) GeneralNames.ASN1.decode(extension.getExtnValue())).getPairsList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.857 -0400", hash_original_method = "03BB26B095671170BC4A5910FD38473D", hash_generated_method = "B00D91128D2278254B9A1B89C5353770")
    public Collection<List<?>> valueOfIssuerAlternativeName() throws IOException {
        Collection<List<?>> varB4EAC82CA7396A68D541C85D26508E83_97027818 = null; //Variable for return #1
        Collection<List<?>> varB4EAC82CA7396A68D541C85D26508E83_624406555 = null; //Variable for return #2
        Extension extension;
        extension = getExtensionByOID("2.5.29.18");
        {
            varB4EAC82CA7396A68D541C85D26508E83_97027818 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_624406555 = ((GeneralNames) GeneralNames.ASN1.decode(extension.getExtnValue())).getPairsList();
        Collection<List<?>> varA7E53CE21691AB073D9660D615818899_981312813; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_981312813 = varB4EAC82CA7396A68D541C85D26508E83_97027818;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_981312813 = varB4EAC82CA7396A68D541C85D26508E83_624406555;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_981312813.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_981312813;
        // ---------- Original Method ----------
        //Extension extension = getExtensionByOID("2.5.29.18");
        //if (extension == null) {
            //return null;
        //}
        //return ((GeneralNames) GeneralNames.ASN1.decode(extension.getExtnValue())).getPairsList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.858 -0400", hash_original_method = "7B080EDEBF008BF89BEA15CA32B37546", hash_generated_method = "BD4156FD0347849CF99556221CD3FAD8")
    public X500Principal valueOfCertificateIssuerExtension() throws IOException {
        X500Principal varB4EAC82CA7396A68D541C85D26508E83_550733259 = null; //Variable for return #1
        X500Principal varB4EAC82CA7396A68D541C85D26508E83_1883384982 = null; //Variable for return #2
        Extension extension;
        extension = getExtensionByOID("2.5.29.29");
        {
            varB4EAC82CA7396A68D541C85D26508E83_550733259 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1883384982 = ((CertificateIssuer) extension.getDecodedExtensionValue()).getIssuer();
        X500Principal varA7E53CE21691AB073D9660D615818899_887300081; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_887300081 = varB4EAC82CA7396A68D541C85D26508E83_550733259;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_887300081 = varB4EAC82CA7396A68D541C85D26508E83_1883384982;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_887300081.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_887300081;
        // ---------- Original Method ----------
        //Extension extension = getExtensionByOID("2.5.29.29");
        //if (extension == null) {
            //return null;
        //}
        //return ((CertificateIssuer) extension.getDecodedExtensionValue()).getIssuer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.859 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "837B082484CD2AF2DA381A04A6EB693E")
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2088048927 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2088048927;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.860 -0400", hash_original_method = "C22B11DD1D34238E2A26C4258C487EE2", hash_generated_method = "E0AF9DCE0AAD523733A272B46F272E60")
    @Override
    public boolean equals(Object other) {
        Extensions that;
        that = (Extensions) other;
        {
            boolean var4B189EE36D32785294CD88DE4E2158BD_1779860829 = ((this.extensions == null || this.extensions.isEmpty()));
            Object varCF104E9947E7F26A470B65D4A312A36F_995261984 = ((that.extensions == null || that.extensions.isEmpty()));
            Object var7022CED6C445A8636D66A199E61288B0_489954843 = ((this.extensions.equals(that.extensions)));
        } //End flattened ternary
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1349157382 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1349157382;
        // ---------- Original Method ----------
        //if (!(other instanceof Extensions)) {
            //return false;
        //}
        //Extensions that = (Extensions) other;
        //return (this.extensions == null || this.extensions.isEmpty())
                    //? (that.extensions == null || that.extensions.isEmpty())
                    //: (this.extensions.equals(that.extensions));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.862 -0400", hash_original_method = "4C94C64ABE7312C3D3BBBB76E6D36C32", hash_generated_method = "9916B77D10DBDA99DA06CD25594F6E40")
    @Override
    public int hashCode() {
        int hashCode;
        hashCode = 0;
        {
            hashCode = extensions.hashCode();
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1037083673 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1037083673;
        // ---------- Original Method ----------
        //int hashCode = 0;
        //if (extensions != null) {
            //hashCode = extensions.hashCode();
        //}
        //return hashCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.903 -0400", hash_original_method = "F4C0EB00BC61B6C3C716F9B41C861C66", hash_generated_method = "E34FCBC59E65FBC59233E6C54FA936EF")
    public void dumpValue(StringBuilder sb, String prefix) {
        int num;
        num = 1;
        {
            Iterator<Extension> var64800BC157F0004EFD25CD350D992D15_1380945272 = (extensions).iterator();
            var64800BC157F0004EFD25CD350D992D15_1380945272.hasNext();
            Extension extension = var64800BC157F0004EFD25CD350D992D15_1380945272.next();
            {
                sb.append('\n').append(prefix).append('[').append(num++).append("]: ");
                extension.dumpValue(sb, prefix);
            } //End block
        } //End collapsed parenthetic
        addTaint(sb.getTaint());
        addTaint(prefix.getTaint());
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.904 -0400", hash_original_field = "F5223D36B00E0FFCDDF9B2B995079CF2", hash_generated_field = "2D002C30AF2816E4CD220F420C40FBAD")

    private static List SUPPORTED_CRITICAL = Arrays.asList(
            "2.5.29.15", "2.5.29.19", "2.5.29.32", "2.5.29.17",
            "2.5.29.30", "2.5.29.36", "2.5.29.37", "2.5.29.54");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.904 -0400", hash_original_field = "9F138981CD4E842F83065885738EAA09", hash_generated_field = "325D4B839B8846AF06D5B6C75FEBE62A")

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

