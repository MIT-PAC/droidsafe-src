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
    private List<Extension> extensions;
    private Set<String> critical;
    private Set<String> noncritical;
    private boolean hasUnsupported;
    private HashMap<String, Extension> oidMap;
    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.708 -0400", hash_original_method = "4F6254C867328A153FDD5BD23453E816", hash_generated_method = "8D1DB2771425E2517B9F7DC7528BABC1")
    @DSModeled(DSC.SAFE)
    public Extensions() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.708 -0400", hash_original_method = "89146A86DD080B3422EC5033031F1DF4", hash_generated_method = "CE2A7BB725E7972D9044A202F6B5C72D")
    @DSModeled(DSC.SAFE)
    public Extensions(List<Extension> extensions) {
        dsTaint.addTaint(extensions.dsTaint);
        // ---------- Original Method ----------
        //this.extensions = extensions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.709 -0400", hash_original_method = "B4520EB3CA6AF47BBFFA43544D7C2D00", hash_generated_method = "DE9F5EBFB8FB022E12AC201066357F6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int size() {
        {
            Object var25C8BD0175A5F6C233FBF28199D5859F_1664082988 = (extensions.size());
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (extensions == null) ? 0 : extensions.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.709 -0400", hash_original_method = "6A8A6C791C17F1564EF710302C5F6E38", hash_generated_method = "44FD82ED76B491D00F31C6FEEFD54014")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<String> getCriticalExtensions() {
        {
            makeOidsLists();
        } //End block
        return (Set<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (critical == null) {
            //makeOidsLists();
        //}
        //return critical;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.709 -0400", hash_original_method = "A9814A684588F34F98E6563F2443DAA6", hash_generated_method = "E30B87031C868CF71C7CAD0F8FC93FB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<String> getNonCriticalExtensions() {
        {
            makeOidsLists();
        } //End block
        return (Set<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (noncritical == null) {
            //makeOidsLists();
        //}
        //return noncritical;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.709 -0400", hash_original_method = "CA1C7754653BDDEC58CFB11BB71C11DB", hash_generated_method = "3491B4ADDB299C0D8DDA697B3A31E26F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasUnsupportedCritical() {
        {
            makeOidsLists();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (critical == null) {
            //makeOidsLists();
        //}
        //return hasUnsupported;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.712 -0400", hash_original_method = "F144B02FA833AD81E1DCC6E0D8E9952F", hash_generated_method = "E82C66464E584FBD5A465BF33E672FC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void makeOidsLists() {
        int size;
        size = extensions.size();
        critical = new HashSet<String>(size);
        noncritical = new HashSet<String>(size);
        {
            Iterator<Extension> var8FD9017ABC8765E97936874D90CDB6D8_2076012604 = (extensions).iterator();
            var8FD9017ABC8765E97936874D90CDB6D8_2076012604.hasNext();
            Extension extension = var8FD9017ABC8765E97936874D90CDB6D8_2076012604.next();
            {
                String oid;
                oid = extension.getExtnID();
                {
                    boolean var890C8545AA65378EB03A21B27E363703_691744959 = (extension.getCritical());
                    {
                        {
                            boolean var055078D0CE1FA9550F7F9B8CC0B361FD_322628821 = (!SUPPORTED_CRITICAL.contains(oid));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.718 -0400", hash_original_method = "44703E9781E0014C266798D0DB277AFC", hash_generated_method = "8054FCA264A184F37952BD1184943645")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Extension getExtensionByOID(String oid) {
        dsTaint.addTaint(oid);
        {
            oidMap = new HashMap<String, Extension>();
            {
                Iterator<Extension> var8FD9017ABC8765E97936874D90CDB6D8_466344828 = (extensions).iterator();
                var8FD9017ABC8765E97936874D90CDB6D8_466344828.hasNext();
                Extension extension = var8FD9017ABC8765E97936874D90CDB6D8_466344828.next();
                {
                    oidMap.put(extension.getExtnID(), extension);
                } //End block
            } //End collapsed parenthetic
        } //End block
        Extension varF5B31709C72D0FC4278DA051D6464B24_1908713730 = (oidMap.get(oid));
        return (Extension)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.718 -0400", hash_original_method = "67C71F044BBB9B405BEFA4564A602892", hash_generated_method = "FF12B09D7E294D567A19A6726A79DDB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean[] valueOfKeyUsage() {
        Extension extension;
        extension = getExtensionByOID("2.5.29.15");
        KeyUsage kUsage;
        {
            boolean varF3595B2B157720F192ED02C0BBBDFB37_644574030 = ((extension == null) || ((kUsage = extension.getKeyUsageValue()) == null));
        } //End collapsed parenthetic
        boolean[] var511ABEB91310283286824915011853D8_1385483717 = (kUsage.getKeyUsage());
        boolean[] retVal = new boolean[1];
        retVal[0] = dsTaint.getTaintBoolean();
        return retVal;
        // ---------- Original Method ----------
        //Extension extension = getExtensionByOID("2.5.29.15");
        //KeyUsage kUsage;
        //if ((extension == null) || ((kUsage = extension.getKeyUsageValue()) == null)) {
            //return null;
        //}
        //return kUsage.getKeyUsage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.719 -0400", hash_original_method = "84A63CE35CC08D6818168132AFB51A65", hash_generated_method = "D3FA17BD7186B4BA6937B21EEE3CD73A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<String> valueOfExtendedKeyUsage() throws IOException {
        Extension extension;
        extension = getExtensionByOID("2.5.29.37");
        List<String> var1F886B5CD82BBAF30F1B1AE575F521D9_257805315 = (((ExtendedKeyUsage) extension.getDecodedExtensionValue()).getExtendedKeyUsage());
        return (List<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Extension extension = getExtensionByOID("2.5.29.37");
        //if (extension == null) {
            //return null;
        //}
        //return ((ExtendedKeyUsage) extension.getDecodedExtensionValue()).getExtendedKeyUsage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.719 -0400", hash_original_method = "CD9DAABD8089C73414664CD384AA791C", hash_generated_method = "98B6B1E30FA150991DB640608FAA6E29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int valueOfBasicConstrains() {
        Extension extension;
        extension = getExtensionByOID("2.5.29.19");
        BasicConstraints bc;
        {
            boolean varD6D8B93AD6192498EF11D9085C76974A_1872427444 = ((extension == null) || ((bc = extension.getBasicConstraintsValue()) == null));
        } //End collapsed parenthetic
        int varD9665725528058AFF959C1C75668237D_973157199 = (bc.getPathLenConstraint());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Extension extension = getExtensionByOID("2.5.29.19");
        //BasicConstraints bc;
        //if ((extension == null) || ((bc = extension.getBasicConstraintsValue()) == null)) {
            //return Integer.MAX_VALUE;
        //}
        //return bc.getPathLenConstraint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.719 -0400", hash_original_method = "05742F8CFC468BD801B4E723F95A84AD", hash_generated_method = "81539FA2C959DA4F1CA6934253E9429A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection<List<?>> valueOfSubjectAlternativeName() throws IOException {
        Extension extension;
        extension = getExtensionByOID("2.5.29.17");
        Collection<List<?>> varFC167D6017DE7EB131561B94156358D1_666510190 = (((GeneralNames) GeneralNames.ASN1.decode(extension.getExtnValue())).getPairsList());
        return (Collection<List<?>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Extension extension = getExtensionByOID("2.5.29.17");
        //if (extension == null) {
            //return null;
        //}
        //return ((GeneralNames) GeneralNames.ASN1.decode(extension.getExtnValue())).getPairsList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.720 -0400", hash_original_method = "03BB26B095671170BC4A5910FD38473D", hash_generated_method = "343C220444BDB0D92C56FC2668770960")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection<List<?>> valueOfIssuerAlternativeName() throws IOException {
        Extension extension;
        extension = getExtensionByOID("2.5.29.18");
        Collection<List<?>> varFC167D6017DE7EB131561B94156358D1_509971823 = (((GeneralNames) GeneralNames.ASN1.decode(extension.getExtnValue())).getPairsList());
        return (Collection<List<?>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Extension extension = getExtensionByOID("2.5.29.18");
        //if (extension == null) {
            //return null;
        //}
        //return ((GeneralNames) GeneralNames.ASN1.decode(extension.getExtnValue())).getPairsList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.720 -0400", hash_original_method = "7B080EDEBF008BF89BEA15CA32B37546", hash_generated_method = "676AD41756D86D846E6AC715ECCAC322")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public X500Principal valueOfCertificateIssuerExtension() throws IOException {
        Extension extension;
        extension = getExtensionByOID("2.5.29.29");
        X500Principal var197B0CE7CDF5D8B4C549B91DCA619FA9_251170622 = (((CertificateIssuer) extension.getDecodedExtensionValue()).getIssuer());
        return (X500Principal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Extension extension = getExtensionByOID("2.5.29.29");
        //if (extension == null) {
            //return null;
        //}
        //return ((CertificateIssuer) extension.getDecodedExtensionValue()).getIssuer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.720 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "94FDBB09C313C97C9EDC6BBF307FBE8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.721 -0400", hash_original_method = "C22B11DD1D34238E2A26C4258C487EE2", hash_generated_method = "35F4051AC703C22AE77A37E17034FAE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        Extensions that;
        that = (Extensions) other;
        {
            boolean var4B189EE36D32785294CD88DE4E2158BD_1214145419 = ((this.extensions == null || this.extensions.isEmpty()));
            Object varCF104E9947E7F26A470B65D4A312A36F_1883878035 = ((that.extensions == null || that.extensions.isEmpty()));
            Object var7022CED6C445A8636D66A199E61288B0_559412781 = ((this.extensions.equals(that.extensions)));
        } //End flattened ternary
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!(other instanceof Extensions)) {
            //return false;
        //}
        //Extensions that = (Extensions) other;
        //return (this.extensions == null || this.extensions.isEmpty())
                    //? (that.extensions == null || that.extensions.isEmpty())
                    //: (this.extensions.equals(that.extensions));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.721 -0400", hash_original_method = "4C94C64ABE7312C3D3BBBB76E6D36C32", hash_generated_method = "18029D4246D2FA06CB724EB853C54656")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int hashCode;
        hashCode = 0;
        {
            hashCode = extensions.hashCode();
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int hashCode = 0;
        //if (extensions != null) {
            //hashCode = extensions.hashCode();
        //}
        //return hashCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.724 -0400", hash_original_method = "F4C0EB00BC61B6C3C716F9B41C861C66", hash_generated_method = "352BE5687144331702598AD637855177")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dumpValue(StringBuilder sb, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(sb.dsTaint);
        int num;
        num = 1;
        {
            Iterator<Extension> var64800BC157F0004EFD25CD350D992D15_1326862871 = (extensions).iterator();
            var64800BC157F0004EFD25CD350D992D15_1326862871.hasNext();
            Extension extension = var64800BC157F0004EFD25CD350D992D15_1326862871.next();
            {
                sb.append('\n').append(prefix).append('[').append(num++).append("]: ");
                extension.dumpValue(sb, prefix);
            } //End block
        } //End collapsed parenthetic
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

    
    private static List SUPPORTED_CRITICAL = Arrays.asList(
            "2.5.29.15", "2.5.29.19", "2.5.29.32", "2.5.29.17",
            "2.5.29.30", "2.5.29.36", "2.5.29.37", "2.5.29.54");
    public static final ASN1Type ASN1 = new ASN1SequenceOf(Extension.ASN1) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.725 -0400", hash_original_method = "399B7E2ADEDD12A1185F1F94F953221A", hash_generated_method = "7B471E6D49CF3E174E4725F98DB8079D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Object getDecodedObject(BerInputStream in) {
            dsTaint.addTaint(in.dsTaint);
            Object varE2EF0F206C13B3454339735A247C92E0_1155837189 = (new Extensions((List<Extension>) in.content));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Extensions((List<Extension>) in.content);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.725 -0400", hash_original_method = "29E9E68732A3D4A733046F4BF43E6588", hash_generated_method = "941A2A5935660A5DC65DC15BE54DA36C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Collection getValues(Object object) {
            dsTaint.addTaint(object.dsTaint);
            Extensions extensions;
            extensions = (Extensions) object;
            {
                Object var2A6E891798CA649DF67AD31FAAEF1AA9_1633337025 = (new ArrayList());
            } //End flattened ternary
            return (Collection)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Extensions extensions = (Extensions) object;
            //return (extensions.extensions == null) ? new ArrayList() : extensions.extensions;
        }

        
}; //Transformed anonymous class
}

