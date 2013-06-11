package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static List SUPPORTED_CRITICAL = Arrays.asList(
            "2.5.29.15", "2.5.29.19", "2.5.29.32", "2.5.29.17",
            "2.5.29.30", "2.5.29.36", "2.5.29.37", "2.5.29.54");
    private List<Extension> extensions;
    private Set<String> critical;
    private Set<String> noncritical;
    private boolean hasUnsupported;
    private HashMap<String, Extension> oidMap;
    private byte[] encoding;
    public static final ASN1Type ASN1 = new ASN1SequenceOf(Extension.ASN1) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.927 -0400", hash_original_method = "399B7E2ADEDD12A1185F1F94F953221A", hash_generated_method = "B173D8A963349A522D05D0355E516A5D")
        @DSModeled(DSC.SAFE)
        @Override
        public Object getDecodedObject(BerInputStream in) {
            dsTaint.addTaint(in.dsTaint);
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new Extensions((List<Extension>) in.content);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.927 -0400", hash_original_method = "29E9E68732A3D4A733046F4BF43E6588", hash_generated_method = "35C88BC07639444E881903AE9458C6B7")
        @DSModeled(DSC.SAFE)
        @Override
        public Collection getValues(Object object) {
            dsTaint.addTaint(object.dsTaint);
            Extensions extensions;
            extensions = (Extensions) object;
            return (Collection)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Extensions extensions = (Extensions) object;
            //return (extensions.extensions == null) ? new ArrayList() : extensions.extensions;
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.927 -0400", hash_original_method = "4F6254C867328A153FDD5BD23453E816", hash_generated_method = "2A98E4A575C97D004020EF0DBF1D6D93")
    @DSModeled(DSC.SAFE)
    public Extensions() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.927 -0400", hash_original_method = "89146A86DD080B3422EC5033031F1DF4", hash_generated_method = "9B39BB6417DEDCD38A8078092EEA041C")
    @DSModeled(DSC.SAFE)
    public Extensions(List<Extension> extensions) {
        dsTaint.addTaint(extensions.dsTaint);
        // ---------- Original Method ----------
        //this.extensions = extensions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.927 -0400", hash_original_method = "B4520EB3CA6AF47BBFFA43544D7C2D00", hash_generated_method = "0BC3A3D0DBC75A3E56E63406E248C0BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int size() {
        {
            Object var25C8BD0175A5F6C233FBF28199D5859F_1380528011 = (extensions.size());
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (extensions == null) ? 0 : extensions.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.927 -0400", hash_original_method = "6A8A6C791C17F1564EF710302C5F6E38", hash_generated_method = "7613B6A79DF1F202850A917317C18015")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.928 -0400", hash_original_method = "A9814A684588F34F98E6563F2443DAA6", hash_generated_method = "696FA1747438CBD4636CE31D84416CD5")
    @DSModeled(DSC.SAFE)
    public Set<String> getNonCriticalExtensions() {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.928 -0400", hash_original_method = "CA1C7754653BDDEC58CFB11BB71C11DB", hash_generated_method = "12BD6945A852932EB28712DC21B580AD")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.928 -0400", hash_original_method = "F144B02FA833AD81E1DCC6E0D8E9952F", hash_generated_method = "F32EF6A93B9782E55002F1076C909B7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void makeOidsLists() {
        int size;
        size = extensions.size();
        critical = new HashSet<String>(size);
        noncritical = new HashSet<String>(size);
        {
            Iterator<Extension> seatecAstronomy42 = extensions.iterator();
            seatecAstronomy42.hasNext();
            Extension extension = seatecAstronomy42.next();
            {
                String oid;
                oid = extension.getExtnID();
                {
                    boolean var890C8545AA65378EB03A21B27E363703_1791803435 = (extension.getCritical());
                    {
                        {
                            boolean var055078D0CE1FA9550F7F9B8CC0B361FD_2082435055 = (!SUPPORTED_CRITICAL.contains(oid));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.928 -0400", hash_original_method = "44703E9781E0014C266798D0DB277AFC", hash_generated_method = "A3B5CF0C2E7016AB05A52D9E1DC6F29D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Extension getExtensionByOID(String oid) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(oid);
        {
            oidMap = new HashMap<String, Extension>();
            {
                Iterator<Extension> seatecAstronomy42 = extensions.iterator();
                seatecAstronomy42.hasNext();
                Extension extension = seatecAstronomy42.next();
                {
                    oidMap.put(extension.getExtnID(), extension);
                } //End block
            } //End collapsed parenthetic
        } //End block
        Extension varF5B31709C72D0FC4278DA051D6464B24_306392494 = (oidMap.get(oid));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.928 -0400", hash_original_method = "67C71F044BBB9B405BEFA4564A602892", hash_generated_method = "0695FECAF5415BD99A41D9F0F3B5E60F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean[] valueOfKeyUsage() {
        Extension extension;
        extension = getExtensionByOID("2.5.29.15");
        KeyUsage kUsage;
        {
            boolean varF3595B2B157720F192ED02C0BBBDFB37_692976171 = ((extension == null) || ((kUsage = extension.getKeyUsageValue()) == null));
        } //End collapsed parenthetic
        boolean[] var511ABEB91310283286824915011853D8_1061069753 = (kUsage.getKeyUsage());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.928 -0400", hash_original_method = "84A63CE35CC08D6818168132AFB51A65", hash_generated_method = "2514CA17E88F53C5D36C0920AD019F1A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<String> valueOfExtendedKeyUsage() throws IOException {
        Extension extension;
        extension = getExtensionByOID("2.5.29.37");
        List<String> var1F886B5CD82BBAF30F1B1AE575F521D9_1956652591 = (((ExtendedKeyUsage) extension.getDecodedExtensionValue()).getExtendedKeyUsage());
        return (List<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Extension extension = getExtensionByOID("2.5.29.37");
        //if (extension == null) {
            //return null;
        //}
        //return ((ExtendedKeyUsage) extension.getDecodedExtensionValue()).getExtendedKeyUsage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.928 -0400", hash_original_method = "CD9DAABD8089C73414664CD384AA791C", hash_generated_method = "2B6A038DAD4CBA29F2425BBD290CE854")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int valueOfBasicConstrains() {
        Extension extension;
        extension = getExtensionByOID("2.5.29.19");
        BasicConstraints bc;
        {
            boolean varD6D8B93AD6192498EF11D9085C76974A_202596419 = ((extension == null) || ((bc = extension.getBasicConstraintsValue()) == null));
        } //End collapsed parenthetic
        int varD9665725528058AFF959C1C75668237D_986233221 = (bc.getPathLenConstraint());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Extension extension = getExtensionByOID("2.5.29.19");
        //BasicConstraints bc;
        //if ((extension == null) || ((bc = extension.getBasicConstraintsValue()) == null)) {
            //return Integer.MAX_VALUE;
        //}
        //return bc.getPathLenConstraint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.928 -0400", hash_original_method = "05742F8CFC468BD801B4E723F95A84AD", hash_generated_method = "28B9D0625F860C89ADEDD51B9D3A5502")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection<List<?>> valueOfSubjectAlternativeName() throws IOException {
        Extension extension;
        extension = getExtensionByOID("2.5.29.17");
        Collection<List<?>> varFC167D6017DE7EB131561B94156358D1_538527990 = (((GeneralNames) GeneralNames.ASN1.decode(extension.getExtnValue())).getPairsList());
        return (Collection<List<?>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Extension extension = getExtensionByOID("2.5.29.17");
        //if (extension == null) {
            //return null;
        //}
        //return ((GeneralNames) GeneralNames.ASN1.decode(extension.getExtnValue())).getPairsList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.928 -0400", hash_original_method = "03BB26B095671170BC4A5910FD38473D", hash_generated_method = "513A38CAA162E0BB1F682597676FE23D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection<List<?>> valueOfIssuerAlternativeName() throws IOException {
        Extension extension;
        extension = getExtensionByOID("2.5.29.18");
        Collection<List<?>> varFC167D6017DE7EB131561B94156358D1_891552440 = (((GeneralNames) GeneralNames.ASN1.decode(extension.getExtnValue())).getPairsList());
        return (Collection<List<?>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Extension extension = getExtensionByOID("2.5.29.18");
        //if (extension == null) {
            //return null;
        //}
        //return ((GeneralNames) GeneralNames.ASN1.decode(extension.getExtnValue())).getPairsList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.929 -0400", hash_original_method = "7B080EDEBF008BF89BEA15CA32B37546", hash_generated_method = "44EC41388B897CE0A68E8BB91C67825F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public X500Principal valueOfCertificateIssuerExtension() throws IOException {
        Extension extension;
        extension = getExtensionByOID("2.5.29.29");
        X500Principal var197B0CE7CDF5D8B4C549B91DCA619FA9_808311653 = (((CertificateIssuer) extension.getDecodedExtensionValue()).getIssuer());
        return (X500Principal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Extension extension = getExtensionByOID("2.5.29.29");
        //if (extension == null) {
            //return null;
        //}
        //return ((CertificateIssuer) extension.getDecodedExtensionValue()).getIssuer();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.929 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "789A9934736C48653FD65A6445A80FAF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.929 -0400", hash_original_method = "C22B11DD1D34238E2A26C4258C487EE2", hash_generated_method = "AD9A8C1F312BB11C7D2770E8F35D141A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        Extensions that;
        that = (Extensions) other;
        {
            boolean var4B189EE36D32785294CD88DE4E2158BD_1148878094 = ((this.extensions == null || this.extensions.isEmpty()));
            Object varCF104E9947E7F26A470B65D4A312A36F_249913131 = ((that.extensions == null || that.extensions.isEmpty()));
            Object var7022CED6C445A8636D66A199E61288B0_2069219713 = ((this.extensions.equals(that.extensions)));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.929 -0400", hash_original_method = "4C94C64ABE7312C3D3BBBB76E6D36C32", hash_generated_method = "B3DC9BB6B550CB1E49C5A17D535D0316")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.929 -0400", hash_original_method = "F4C0EB00BC61B6C3C716F9B41C861C66", hash_generated_method = "C8172D8BFFCB5D92D3507E7CF756BC98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dumpValue(StringBuilder sb, String prefix) {
        dsTaint.addTaint(sb.dsTaint);
        dsTaint.addTaint(prefix);
        int num;
        num = 1;
        {
            Iterator<Extension> seatecAstronomy42 = extensions.iterator();
            seatecAstronomy42.hasNext();
            Extension extension = seatecAstronomy42.next();
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

    
}


