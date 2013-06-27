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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.669 -0400", hash_original_field = "2AC737D240FC746CEF37129B7569F08E", hash_generated_field = "F93AA8349A2FA92AE6135244F491401E")

    private List<Extension> extensions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.669 -0400", hash_original_field = "7E85BCB66FB9A809D5AB4F62A8B8BEA8", hash_generated_field = "8AE6968FB7018EBEDA25C054995E291B")

    private Set<String> critical;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.669 -0400", hash_original_field = "ACC02843792BA46B7A7EB0B1788A22C6", hash_generated_field = "6827F144A18995AA402D9FA96B7DCC8C")

    private Set<String> noncritical;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.669 -0400", hash_original_field = "416ECF4BA061CEB2F9353023282FCF57", hash_generated_field = "7B4E2AB69860A448C1B3D04CF6B0EB86")

    private boolean hasUnsupported;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.669 -0400", hash_original_field = "38BC3F68B4757D145BD31C0F88C48214", hash_generated_field = "3CBB0703D1DDEAD49B98A4F5CB8F1949")

    private HashMap<String, Extension> oidMap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.669 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.670 -0400", hash_original_method = "4F6254C867328A153FDD5BD23453E816", hash_generated_method = "8D1DB2771425E2517B9F7DC7528BABC1")
    public  Extensions() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.671 -0400", hash_original_method = "89146A86DD080B3422EC5033031F1DF4", hash_generated_method = "EBF9C74A91F031E9B43BDAD943D3244E")
    public  Extensions(List<Extension> extensions) {
        this.extensions = extensions;
        // ---------- Original Method ----------
        //this.extensions = extensions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.671 -0400", hash_original_method = "B4520EB3CA6AF47BBFFA43544D7C2D00", hash_generated_method = "DC3FC40B75FFCBBC57FB15435337CD77")
    public int size() {
        {
            Object var25C8BD0175A5F6C233FBF28199D5859F_282310586 = (extensions.size());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2092632839 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2092632839;
        // ---------- Original Method ----------
        //return (extensions == null) ? 0 : extensions.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.676 -0400", hash_original_method = "6A8A6C791C17F1564EF710302C5F6E38", hash_generated_method = "C3411162CDB79CE3A3C8A0D8FB04E881")
    public Set<String> getCriticalExtensions() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1305637725 = null; //Variable for return #1
        {
            makeOidsLists();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1305637725 = critical;
        varB4EAC82CA7396A68D541C85D26508E83_1305637725.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1305637725;
        // ---------- Original Method ----------
        //if (critical == null) {
            //makeOidsLists();
        //}
        //return critical;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.677 -0400", hash_original_method = "A9814A684588F34F98E6563F2443DAA6", hash_generated_method = "A4EA15BD02DA14519594C053E2B0ECDC")
    public Set<String> getNonCriticalExtensions() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1686655735 = null; //Variable for return #1
        {
            makeOidsLists();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1686655735 = noncritical;
        varB4EAC82CA7396A68D541C85D26508E83_1686655735.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1686655735;
        // ---------- Original Method ----------
        //if (noncritical == null) {
            //makeOidsLists();
        //}
        //return noncritical;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.677 -0400", hash_original_method = "CA1C7754653BDDEC58CFB11BB71C11DB", hash_generated_method = "616DD46F8C1325C47505BED47A31B470")
    public boolean hasUnsupportedCritical() {
        {
            makeOidsLists();
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_244045990 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_244045990;
        // ---------- Original Method ----------
        //if (critical == null) {
            //makeOidsLists();
        //}
        //return hasUnsupported;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.713 -0400", hash_original_method = "F144B02FA833AD81E1DCC6E0D8E9952F", hash_generated_method = "53B00803DC7D00A350FD75297E6CD2DE")
    private void makeOidsLists() {
        int size;
        size = extensions.size();
        critical = new HashSet<String>(size);
        noncritical = new HashSet<String>(size);
        {
            Iterator<Extension> var8FD9017ABC8765E97936874D90CDB6D8_314386646 = (extensions).iterator();
            var8FD9017ABC8765E97936874D90CDB6D8_314386646.hasNext();
            Extension extension = var8FD9017ABC8765E97936874D90CDB6D8_314386646.next();
            {
                String oid;
                oid = extension.getExtnID();
                {
                    boolean var890C8545AA65378EB03A21B27E363703_420427281 = (extension.getCritical());
                    {
                        {
                            boolean var055078D0CE1FA9550F7F9B8CC0B361FD_1660131416 = (!SUPPORTED_CRITICAL.contains(oid));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.739 -0400", hash_original_method = "44703E9781E0014C266798D0DB277AFC", hash_generated_method = "FF167E740F0F436BD7753D220F3A0BC5")
    public Extension getExtensionByOID(String oid) {
        Extension varB4EAC82CA7396A68D541C85D26508E83_754520117 = null; //Variable for return #1
        Extension varB4EAC82CA7396A68D541C85D26508E83_1150789021 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_754520117 = null;
        } //End block
        {
            oidMap = new HashMap<String, Extension>();
            {
                Iterator<Extension> var8FD9017ABC8765E97936874D90CDB6D8_1595186165 = (extensions).iterator();
                var8FD9017ABC8765E97936874D90CDB6D8_1595186165.hasNext();
                Extension extension = var8FD9017ABC8765E97936874D90CDB6D8_1595186165.next();
                {
                    oidMap.put(extension.getExtnID(), extension);
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1150789021 = oidMap.get(oid);
        addTaint(oid.getTaint());
        Extension varA7E53CE21691AB073D9660D615818899_745841542; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_745841542 = varB4EAC82CA7396A68D541C85D26508E83_754520117;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_745841542 = varB4EAC82CA7396A68D541C85D26508E83_1150789021;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_745841542.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_745841542;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.745 -0400", hash_original_method = "67C71F044BBB9B405BEFA4564A602892", hash_generated_method = "6224CD539CFF7222DBE2D04CC0FD7722")
    public boolean[] valueOfKeyUsage() {
        Extension extension;
        extension = getExtensionByOID("2.5.29.15");
        KeyUsage kUsage;
        {
            boolean varF3595B2B157720F192ED02C0BBBDFB37_733754152 = ((extension == null) || ((kUsage = extension.getKeyUsageValue()) == null));
        } //End collapsed parenthetic
        boolean[] var511ABEB91310283286824915011853D8_477531361 = (kUsage.getKeyUsage());
        boolean[] var503EB2F420079C4024483971CE5EDEA8_1318476279 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_1318476279;
        // ---------- Original Method ----------
        //Extension extension = getExtensionByOID("2.5.29.15");
        //KeyUsage kUsage;
        //if ((extension == null) || ((kUsage = extension.getKeyUsageValue()) == null)) {
            //return null;
        //}
        //return kUsage.getKeyUsage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.746 -0400", hash_original_method = "84A63CE35CC08D6818168132AFB51A65", hash_generated_method = "D76176FF0C67303966D28239B5993C40")
    public List<String> valueOfExtendedKeyUsage() throws IOException {
        List<String> varB4EAC82CA7396A68D541C85D26508E83_1387045911 = null; //Variable for return #1
        List<String> varB4EAC82CA7396A68D541C85D26508E83_191249142 = null; //Variable for return #2
        Extension extension;
        extension = getExtensionByOID("2.5.29.37");
        {
            varB4EAC82CA7396A68D541C85D26508E83_1387045911 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_191249142 = ((ExtendedKeyUsage) extension.getDecodedExtensionValue()).getExtendedKeyUsage();
        List<String> varA7E53CE21691AB073D9660D615818899_1824739202; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1824739202 = varB4EAC82CA7396A68D541C85D26508E83_1387045911;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1824739202 = varB4EAC82CA7396A68D541C85D26508E83_191249142;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1824739202.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1824739202;
        // ---------- Original Method ----------
        //Extension extension = getExtensionByOID("2.5.29.37");
        //if (extension == null) {
            //return null;
        //}
        //return ((ExtendedKeyUsage) extension.getDecodedExtensionValue()).getExtendedKeyUsage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.746 -0400", hash_original_method = "CD9DAABD8089C73414664CD384AA791C", hash_generated_method = "CFA3BAEAF38A0177C81C7AE3A1578665")
    public int valueOfBasicConstrains() {
        Extension extension;
        extension = getExtensionByOID("2.5.29.19");
        BasicConstraints bc;
        {
            boolean varD6D8B93AD6192498EF11D9085C76974A_25419333 = ((extension == null) || ((bc = extension.getBasicConstraintsValue()) == null));
        } //End collapsed parenthetic
        int varD9665725528058AFF959C1C75668237D_1506666314 = (bc.getPathLenConstraint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2055413006 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2055413006;
        // ---------- Original Method ----------
        //Extension extension = getExtensionByOID("2.5.29.19");
        //BasicConstraints bc;
        //if ((extension == null) || ((bc = extension.getBasicConstraintsValue()) == null)) {
            //return Integer.MAX_VALUE;
        //}
        //return bc.getPathLenConstraint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.755 -0400", hash_original_method = "05742F8CFC468BD801B4E723F95A84AD", hash_generated_method = "1D0DD9A8984FB374CEDF35E5CDF89E9F")
    public Collection<List<?>> valueOfSubjectAlternativeName() throws IOException {
        Collection<List<?>> varB4EAC82CA7396A68D541C85D26508E83_594145504 = null; //Variable for return #1
        Collection<List<?>> varB4EAC82CA7396A68D541C85D26508E83_1551494030 = null; //Variable for return #2
        Extension extension;
        extension = getExtensionByOID("2.5.29.17");
        {
            varB4EAC82CA7396A68D541C85D26508E83_594145504 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1551494030 = ((GeneralNames) GeneralNames.ASN1.decode(extension.getExtnValue())).getPairsList();
        Collection<List<?>> varA7E53CE21691AB073D9660D615818899_127374694; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_127374694 = varB4EAC82CA7396A68D541C85D26508E83_594145504;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_127374694 = varB4EAC82CA7396A68D541C85D26508E83_1551494030;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_127374694.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_127374694;
        // ---------- Original Method ----------
        //Extension extension = getExtensionByOID("2.5.29.17");
        //if (extension == null) {
            //return null;
        //}
        //return ((GeneralNames) GeneralNames.ASN1.decode(extension.getExtnValue())).getPairsList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.756 -0400", hash_original_method = "03BB26B095671170BC4A5910FD38473D", hash_generated_method = "2962F67267E65FB31CDFA630CD6744F7")
    public Collection<List<?>> valueOfIssuerAlternativeName() throws IOException {
        Collection<List<?>> varB4EAC82CA7396A68D541C85D26508E83_408053569 = null; //Variable for return #1
        Collection<List<?>> varB4EAC82CA7396A68D541C85D26508E83_1516996817 = null; //Variable for return #2
        Extension extension;
        extension = getExtensionByOID("2.5.29.18");
        {
            varB4EAC82CA7396A68D541C85D26508E83_408053569 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1516996817 = ((GeneralNames) GeneralNames.ASN1.decode(extension.getExtnValue())).getPairsList();
        Collection<List<?>> varA7E53CE21691AB073D9660D615818899_1533586525; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1533586525 = varB4EAC82CA7396A68D541C85D26508E83_408053569;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1533586525 = varB4EAC82CA7396A68D541C85D26508E83_1516996817;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1533586525.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1533586525;
        // ---------- Original Method ----------
        //Extension extension = getExtensionByOID("2.5.29.18");
        //if (extension == null) {
            //return null;
        //}
        //return ((GeneralNames) GeneralNames.ASN1.decode(extension.getExtnValue())).getPairsList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.757 -0400", hash_original_method = "7B080EDEBF008BF89BEA15CA32B37546", hash_generated_method = "9FF2E1119370A19979DB4E31F1CA63EC")
    public X500Principal valueOfCertificateIssuerExtension() throws IOException {
        X500Principal varB4EAC82CA7396A68D541C85D26508E83_2114835991 = null; //Variable for return #1
        X500Principal varB4EAC82CA7396A68D541C85D26508E83_1895423727 = null; //Variable for return #2
        Extension extension;
        extension = getExtensionByOID("2.5.29.29");
        {
            varB4EAC82CA7396A68D541C85D26508E83_2114835991 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1895423727 = ((CertificateIssuer) extension.getDecodedExtensionValue()).getIssuer();
        X500Principal varA7E53CE21691AB073D9660D615818899_307069929; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_307069929 = varB4EAC82CA7396A68D541C85D26508E83_2114835991;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_307069929 = varB4EAC82CA7396A68D541C85D26508E83_1895423727;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_307069929.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_307069929;
        // ---------- Original Method ----------
        //Extension extension = getExtensionByOID("2.5.29.29");
        //if (extension == null) {
            //return null;
        //}
        //return ((CertificateIssuer) extension.getDecodedExtensionValue()).getIssuer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.757 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "DE264BDF1B3A8804D082FBDC2FEA8A76")
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1190154048 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1190154048;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.771 -0400", hash_original_method = "C22B11DD1D34238E2A26C4258C487EE2", hash_generated_method = "DB06DCCFC14E9F511A8EEF372C08735A")
    @Override
    public boolean equals(Object other) {
        Extensions that;
        that = (Extensions) other;
        {
            boolean var4B189EE36D32785294CD88DE4E2158BD_71496492 = ((this.extensions == null || this.extensions.isEmpty()));
            Object varCF104E9947E7F26A470B65D4A312A36F_1705964905 = ((that.extensions == null || that.extensions.isEmpty()));
            Object var7022CED6C445A8636D66A199E61288B0_681813451 = ((this.extensions.equals(that.extensions)));
        } //End flattened ternary
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1234159223 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1234159223;
        // ---------- Original Method ----------
        //if (!(other instanceof Extensions)) {
            //return false;
        //}
        //Extensions that = (Extensions) other;
        //return (this.extensions == null || this.extensions.isEmpty())
                    //? (that.extensions == null || that.extensions.isEmpty())
                    //: (this.extensions.equals(that.extensions));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.774 -0400", hash_original_method = "4C94C64ABE7312C3D3BBBB76E6D36C32", hash_generated_method = "9EB3049275E073B9132540BC546B5573")
    @Override
    public int hashCode() {
        int hashCode;
        hashCode = 0;
        {
            hashCode = extensions.hashCode();
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_746953189 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_746953189;
        // ---------- Original Method ----------
        //int hashCode = 0;
        //if (extensions != null) {
            //hashCode = extensions.hashCode();
        //}
        //return hashCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.815 -0400", hash_original_method = "F4C0EB00BC61B6C3C716F9B41C861C66", hash_generated_method = "B8F2FEB27C21385A9930AEEEFF8B5206")
    public void dumpValue(StringBuilder sb, String prefix) {
        int num;
        num = 1;
        {
            Iterator<Extension> var64800BC157F0004EFD25CD350D992D15_836861797 = (extensions).iterator();
            var64800BC157F0004EFD25CD350D992D15_836861797.hasNext();
            Extension extension = var64800BC157F0004EFD25CD350D992D15_836861797.next();
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.815 -0400", hash_original_field = "F5223D36B00E0FFCDDF9B2B995079CF2", hash_generated_field = "2D002C30AF2816E4CD220F420C40FBAD")

    private static List SUPPORTED_CRITICAL = Arrays.asList(
            "2.5.29.15", "2.5.29.19", "2.5.29.32", "2.5.29.17",
            "2.5.29.30", "2.5.29.36", "2.5.29.37", "2.5.29.54");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.815 -0400", hash_original_field = "9F138981CD4E842F83065885738EAA09", hash_generated_field = "325D4B839B8846AF06D5B6C75FEBE62A")

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

