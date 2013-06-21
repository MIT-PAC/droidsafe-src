package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;

public final class NameConstraints extends ExtensionValue {
    private GeneralSubtrees permittedSubtrees;
    private GeneralSubtrees excludedSubtrees;
    private byte[] encoding;
    private ArrayList<GeneralName>[] permitted_names;
    private ArrayList<GeneralName>[] excluded_names;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.865 -0400", hash_original_method = "22A7E7A2EB4ADA3B586F576057F0955D", hash_generated_method = "66934B52ADD778381D103B169F0B24CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NameConstraints(GeneralSubtrees permittedSubtrees,
                           GeneralSubtrees excludedSubtrees) {
        dsTaint.addTaint(permittedSubtrees.dsTaint);
        dsTaint.addTaint(excludedSubtrees.dsTaint);
        {
            List<GeneralSubtree> ps;
            ps = permittedSubtrees.getSubtrees();
            {
                boolean var3E1DBA726FF28934E229E135AA842EA6_1600310941 = (ps == null || ps.isEmpty());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("permittedSubtrees are empty");
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            List<GeneralSubtree> es;
            es = excludedSubtrees.getSubtrees();
            {
                boolean var856995C505D9587EAB6B1B961EA39A07_732406839 = (es == null || es.isEmpty());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("excludedSubtrees are empty");
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (permittedSubtrees != null) {
            //List<GeneralSubtree> ps = permittedSubtrees.getSubtrees();
            //if (ps == null || ps.isEmpty()) {
                //throw new IllegalArgumentException("permittedSubtrees are empty");
            //}
        //}
        //if (excludedSubtrees != null) {
            //List<GeneralSubtree> es = excludedSubtrees.getSubtrees();
            //if (es == null || es.isEmpty()) {
                //throw new IllegalArgumentException("excludedSubtrees are empty");
            //}
        //}
        //this.permittedSubtrees = permittedSubtrees;
        //this.excludedSubtrees = excludedSubtrees;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.866 -0400", hash_original_method = "0B4FF50B5EED3F81B51F891413D3BBDC", hash_generated_method = "EACD67514D9045FEFB43EA8EE6F20161")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private NameConstraints(GeneralSubtrees permittedSubtrees,
                            GeneralSubtrees excludedSubtrees, byte[] encoding) {
        this(permittedSubtrees, excludedSubtrees);
        dsTaint.addTaint(permittedSubtrees.dsTaint);
        dsTaint.addTaint(encoding[0]);
        dsTaint.addTaint(excludedSubtrees.dsTaint);
        // ---------- Original Method ----------
        //this.encoding = encoding;
    }

    
        public static NameConstraints decode(byte[] encoding) throws IOException {
        return (NameConstraints) ASN1.decode(encoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.866 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "07B62BEE8032AB4E194FDF661E084439")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.871 -0400", hash_original_method = "D5B90ECD7CBCC97B9564754E474A01DA", hash_generated_method = "2A9E6CBC02C14346AF4EED27272A771A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void prepareNames() {
        permitted_names = new ArrayList[9];
        {
            {
                Iterator<GeneralSubtree> var4A89C5007B7E4421B64642BE0339554A_97074409 = (permittedSubtrees.getSubtrees()).iterator();
                var4A89C5007B7E4421B64642BE0339554A_97074409.hasNext();
                GeneralSubtree generalSubtree = var4A89C5007B7E4421B64642BE0339554A_97074409.next();
                {
                    GeneralName name;
                    name = generalSubtree.getBase();
                    int tag;
                    tag = name.getTag();
                    {
                        permitted_names[tag] = new ArrayList<GeneralName>();
                    } //End block
                    permitted_names[tag].add(name);
                } //End block
            } //End collapsed parenthetic
        } //End block
        excluded_names = new ArrayList[9];
        {
            {
                Iterator<GeneralSubtree> var3D4F5E5636E3D0D1639AF9F96505A272_628549125 = (excludedSubtrees.getSubtrees()).iterator();
                var3D4F5E5636E3D0D1639AF9F96505A272_628549125.hasNext();
                GeneralSubtree generalSubtree = var3D4F5E5636E3D0D1639AF9F96505A272_628549125.next();
                {
                    GeneralName name;
                    name = generalSubtree.getBase();
                    int tag;
                    tag = name.getTag();
                    {
                        excluded_names[tag] = new ArrayList<GeneralName>();
                    } //End block
                    excluded_names[tag].add(name);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.871 -0400", hash_original_method = "7F050A55683D0AA0C8EC41E810522931", hash_generated_method = "64F0001DFB61691A83E36387FDC5FAFF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private byte[] getExtensionValue(X509Certificate cert, String OID) {
        dsTaint.addTaint(OID);
        dsTaint.addTaint(cert.dsTaint);
        try 
        {
            byte[] bytes;
            bytes = cert.getExtensionValue(OID);
            byte[] varFE5AE10D423C1009FB60B58A35A1A76C_1121429994 = ((byte[]) ASN1OctetString.getInstance().decode(bytes));
        } //End block
        catch (IOException e)
        { }
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //try {
            //byte[] bytes = cert.getExtensionValue(OID);
            //if (bytes == null) {
                //return null;
            //}
            //return (byte[]) ASN1OctetString.getInstance().decode(bytes);
        //} catch (IOException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.872 -0400", hash_original_method = "29F552B10A233C166AD77E1C4D545B27", hash_generated_method = "10C114E59B669E04061FF36EE1E7AB1A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isAcceptable(X509Certificate cert) {
        dsTaint.addTaint(cert.dsTaint);
        {
            prepareNames();
        } //End block
        byte[] bytes;
        bytes = getExtensionValue(cert, "2.5.29.17");
        List<GeneralName> names;
        try 
        {
            names = (bytes == null)
                ? new ArrayList<GeneralName>(1) 
                : ((GeneralNames) GeneralNames.ASN1.decode(bytes)).getNames();
        } //End block
        catch (IOException e)
        {
            e.printStackTrace();
        } //End block
        {
            try 
            {
                names.add(new GeneralName(4,
                        cert.getSubjectX500Principal().getName()));
            } //End block
            catch (IOException e)
            { }
        } //End block
        boolean varC913719CB293685FA8CC7A51429EA1C0_2050200631 = (isAcceptable(names));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (permitted_names == null) {
            //prepareNames();
        //}
        //byte[] bytes = getExtensionValue(cert, "2.5.29.17");
        //List<GeneralName> names;
        //try {
            //names = (bytes == null)
                //? new ArrayList<GeneralName>(1) 
                //: ((GeneralNames) GeneralNames.ASN1.decode(bytes)).getNames();
        //} catch (IOException e) {
            //e.printStackTrace();
            //return false;
        //}
        //if ((excluded_names[4] != null) || (permitted_names[4] != null)) {
            //try {
                //names.add(new GeneralName(4,
                        //cert.getSubjectX500Principal().getName()));
            //} catch (IOException e) {
            //}
        //}
        //return isAcceptable(names);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.880 -0400", hash_original_method = "D894692E4046265C2E05884CCE780235", hash_generated_method = "9C62F49F1998B9B0F1164991036805D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isAcceptable(List<GeneralName> names) {
        dsTaint.addTaint(names.dsTaint);
        {
            prepareNames();
        } //End block
        boolean[] types_presented;
        types_presented = new boolean[9];
        boolean[] permitted_found;
        permitted_found = new boolean[9];
        {
            Iterator<GeneralName> var294D9DCA9D514EFD87D352AAAE97996B_734779231 = (names).iterator();
            var294D9DCA9D514EFD87D352AAAE97996B_734779231.hasNext();
            GeneralName name = var294D9DCA9D514EFD87D352AAAE97996B_734779231.next();
            {
                int type;
                type = name.getTag();
                {
                    {
                        int i;
                        i = 0;
                        boolean var3BD754F49C44E1DB554EBB697585C8AE_1332034034 = (i < excluded_names[type].size());
                        {
                            {
                                boolean var9208CD8ADC84893F0258C5ECF2EF8A7B_1864367316 = (excluded_names[type].get(i).isAcceptable(name));
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    types_presented[type] = true;
                    {
                        int i;
                        i = 0;
                        boolean varF336BC835DEE0F95B686C74C5CCC2137_634555267 = (i < permitted_names[type].size());
                        {
                            {
                                boolean varB45842109D0B75BE944A10B508747846_1243148118 = (permitted_names[type].get(i).isAcceptable(name));
                                {
                                    permitted_found[type] = true;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            int type;
            type = 0;
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.886 -0400", hash_original_method = "54185F2659E074B2203C13418D4687EB", hash_generated_method = "6E282A911F86FB8FDA9A16E569A7E9DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(sb.dsTaint);
        sb.append(prefix).append("Name Constraints: [\n");
        {
            sb.append(prefix).append("  Permitted: [\n");
            {
                Iterator<GeneralSubtree> var4A89C5007B7E4421B64642BE0339554A_1554525849 = (permittedSubtrees.getSubtrees()).iterator();
                var4A89C5007B7E4421B64642BE0339554A_1554525849.hasNext();
                GeneralSubtree generalSubtree = var4A89C5007B7E4421B64642BE0339554A_1554525849.next();
                {
                    generalSubtree.dumpValue(sb, prefix + "    ");
                } //End block
            } //End collapsed parenthetic
            sb.append(prefix).append("  ]\n");
        } //End block
        {
            sb.append(prefix).append("  Excluded: [\n");
            {
                Iterator<GeneralSubtree> var3D4F5E5636E3D0D1639AF9F96505A272_307054593 = (excludedSubtrees.getSubtrees()).iterator();
                var3D4F5E5636E3D0D1639AF9F96505A272_307054593.hasNext();
                GeneralSubtree generalSubtree = var3D4F5E5636E3D0D1639AF9F96505A272_307054593.next();
                {
                    generalSubtree.dumpValue(sb, prefix + "    ");
                } //End block
            } //End collapsed parenthetic
            sb.append(prefix).append("  ]\n");
        } //End block
        sb.append('\n').append(prefix).append("]\n");
        // ---------- Original Method ----------
        //sb.append(prefix).append("Name Constraints: [\n");
        //if (permittedSubtrees != null) {
            //sb.append(prefix).append("  Permitted: [\n");
            //for (GeneralSubtree generalSubtree : permittedSubtrees.getSubtrees()) {
                //generalSubtree.dumpValue(sb, prefix + "    ");
            //}
            //sb.append(prefix).append("  ]\n");
        //}
        //if (excludedSubtrees != null) {
            //sb.append(prefix).append("  Excluded: [\n");
            //for (GeneralSubtree generalSubtree : excludedSubtrees.getSubtrees()) {
                //generalSubtree.dumpValue(sb, prefix + "    ");
            //}
            //sb.append(prefix).append("  ]\n");
        //}
        //sb.append('\n').append(prefix).append("]\n");
    }

    
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            new ASN1Implicit(0, GeneralSubtrees.ASN1),
            new ASN1Implicit(1, GeneralSubtrees.ASN1) }) {        {
            setOptional(0);
            setOptional(1);
        }
        
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.886 -0400", hash_original_method = "615B46BCF08688AF9BAEA542A898E560", hash_generated_method = "A28CDEA8A5E41146A03595E6A4ACBF66")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected Object getDecodedObject(BerInputStream in) {
            dsTaint.addTaint(in.dsTaint);
            Object[] values;
            values = (Object[]) in.content;
            Object var6746F8AC8E4F447788B59BCD126B5DE1_1765930437 = (new NameConstraints(
                    (GeneralSubtrees) values[0],
                    (GeneralSubtrees) values[1],
                    in.getEncoded()));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Object[] values = (Object[]) in.content;
            //return new NameConstraints(
                    //(GeneralSubtrees) values[0],
                    //(GeneralSubtrees) values[1],
                    //in.getEncoded());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.887 -0400", hash_original_method = "EC8305ECC6356BE2CBB8F5C68E732D9B", hash_generated_method = "0C608D29EDE2D5DD19008186F1CB23BC")
        @DSModeled(DSC.SAFE)
        @Override
        protected void getValues(Object object, Object[] values) {
            dsTaint.addTaint(values[0].dsTaint);
            dsTaint.addTaint(object.dsTaint);
            NameConstraints nc;
            nc = (NameConstraints) object;
            values[0] = nc.permittedSubtrees;
            values[1] = nc.excludedSubtrees;
            // ---------- Original Method ----------
            //NameConstraints nc = (NameConstraints) object;
            //values[0] = nc.permittedSubtrees;
            //values[1] = nc.excludedSubtrees;
        }

        
}; //Transformed anonymous class
}

