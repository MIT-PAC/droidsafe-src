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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.234 -0400", hash_original_field = "6BD8EF16E6DBD287528E2D9E158E918B", hash_generated_field = "7C183FAE1C4A852E4C170F871CE896DE")

    private GeneralSubtrees permittedSubtrees;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.234 -0400", hash_original_field = "1ACF560E835C137151C2C43F34A684DB", hash_generated_field = "842C7367D24623D67CDB9CF5EDD53468")

    private GeneralSubtrees excludedSubtrees;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.234 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.234 -0400", hash_original_field = "0B73E26440BFDB0D66AB7EFC48DAC91F", hash_generated_field = "8E1781FAED2BE993CB5C76415843F294")

    private ArrayList<GeneralName>[] permitted_names;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.234 -0400", hash_original_field = "8ECB62E22C5DD78BEDFD4CE561026E24", hash_generated_field = "E0D2B3769B023B270B4E969DD11C5AF9")

    private ArrayList<GeneralName>[] excluded_names;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.234 -0400", hash_original_method = "22A7E7A2EB4ADA3B586F576057F0955D", hash_generated_method = "D042E377306DB7297AC77D200312377B")
    public  NameConstraints(GeneralSubtrees permittedSubtrees,
                           GeneralSubtrees excludedSubtrees) {
        {
            List<GeneralSubtree> ps = permittedSubtrees.getSubtrees();
            {
                boolean var3E1DBA726FF28934E229E135AA842EA6_1774313819 = (ps == null || ps.isEmpty());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("permittedSubtrees are empty");
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            List<GeneralSubtree> es = excludedSubtrees.getSubtrees();
            {
                boolean var856995C505D9587EAB6B1B961EA39A07_986487143 = (es == null || es.isEmpty());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("excludedSubtrees are empty");
                } //End block
            } //End collapsed parenthetic
        } //End block
        this.permittedSubtrees = permittedSubtrees;
        this.excludedSubtrees = excludedSubtrees;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.235 -0400", hash_original_method = "0B4FF50B5EED3F81B51F891413D3BBDC", hash_generated_method = "A55D61CC58F582DA4534F611CFC65D2F")
    private  NameConstraints(GeneralSubtrees permittedSubtrees,
                            GeneralSubtrees excludedSubtrees, byte[] encoding) {
        this(permittedSubtrees, excludedSubtrees);
        this.encoding = encoding;
        addTaint(permittedSubtrees.getTaint());
        addTaint(excludedSubtrees.getTaint());
        // ---------- Original Method ----------
        //this.encoding = encoding;
    }

    
    public static NameConstraints decode(byte[] encoding) throws IOException {
        return (NameConstraints) ASN1.decode(encoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.235 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "A6A29F10A7CA6BD7645089F0D84EBFBE")
    @Override
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_416998107 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_416998107;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.241 -0400", hash_original_method = "D5B90ECD7CBCC97B9564754E474A01DA", hash_generated_method = "D338ACD921A60E1D208C9A24A97615C0")
    private void prepareNames() {
        permitted_names = new ArrayList[9];
        {
            {
                Iterator<GeneralSubtree> var4A89C5007B7E4421B64642BE0339554A_325447135 = (permittedSubtrees.getSubtrees()).iterator();
                var4A89C5007B7E4421B64642BE0339554A_325447135.hasNext();
                GeneralSubtree generalSubtree = var4A89C5007B7E4421B64642BE0339554A_325447135.next();
                {
                    GeneralName name = generalSubtree.getBase();
                    int tag = name.getTag();
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
                Iterator<GeneralSubtree> var3D4F5E5636E3D0D1639AF9F96505A272_1174602736 = (excludedSubtrees.getSubtrees()).iterator();
                var3D4F5E5636E3D0D1639AF9F96505A272_1174602736.hasNext();
                GeneralSubtree generalSubtree = var3D4F5E5636E3D0D1639AF9F96505A272_1174602736.next();
                {
                    GeneralName name = generalSubtree.getBase();
                    int tag = name.getTag();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.242 -0400", hash_original_method = "7F050A55683D0AA0C8EC41E810522931", hash_generated_method = "CECEEFA8BAE4573D4D5930D03A39B26E")
    private byte[] getExtensionValue(X509Certificate cert, String OID) {
        try 
        {
            byte[] bytes = cert.getExtensionValue(OID);
            byte[] varFE5AE10D423C1009FB60B58A35A1A76C_214847348 = ((byte[]) ASN1OctetString.getInstance().decode(bytes));
        } //End block
        catch (IOException e)
        { }
        addTaint(cert.getTaint());
        addTaint(OID.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1052879452 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1052879452;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.242 -0400", hash_original_method = "29F552B10A233C166AD77E1C4D545B27", hash_generated_method = "6DA2DAA39B2C602213C1AB0F2145C512")
    public boolean isAcceptable(X509Certificate cert) {
        {
            prepareNames();
        } //End block
        byte[] bytes = getExtensionValue(cert, "2.5.29.17");
        List<GeneralName> names = null;
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
        boolean varC913719CB293685FA8CC7A51429EA1C0_388623678 = (isAcceptable(names));
        addTaint(cert.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_963199771 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_963199771;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.249 -0400", hash_original_method = "D894692E4046265C2E05884CCE780235", hash_generated_method = "F65B66DC7322C33E79E2B38E98ED7FE7")
    public boolean isAcceptable(List<GeneralName> names) {
        {
            prepareNames();
        } //End block
        boolean[] types_presented = new boolean[9];
        boolean[] permitted_found = new boolean[9];
        {
            Iterator<GeneralName> var294D9DCA9D514EFD87D352AAAE97996B_748933816 = (names).iterator();
            var294D9DCA9D514EFD87D352AAAE97996B_748933816.hasNext();
            GeneralName name = var294D9DCA9D514EFD87D352AAAE97996B_748933816.next();
            {
                int type = name.getTag();
                {
                    {
                        int i = 0;
                        boolean var3BD754F49C44E1DB554EBB697585C8AE_719274088 = (i < excluded_names[type].size());
                        {
                            {
                                boolean var9208CD8ADC84893F0258C5ECF2EF8A7B_1420557350 = (excluded_names[type].get(i).isAcceptable(name));
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    types_presented[type] = true;
                    {
                        int i = 0;
                        boolean varF336BC835DEE0F95B686C74C5CCC2137_399688395 = (i < permitted_names[type].size());
                        {
                            {
                                boolean varB45842109D0B75BE944A10B508747846_450680078 = (permitted_names[type].get(i).isAcceptable(name));
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
            int type = 0;
        } //End collapsed parenthetic
        addTaint(names.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1728650413 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1728650413;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.255 -0400", hash_original_method = "54185F2659E074B2203C13418D4687EB", hash_generated_method = "D9877C5BFF1F4B08CBB5EF0192243FF6")
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("Name Constraints: [\n");
        {
            sb.append(prefix).append("  Permitted: [\n");
            {
                Iterator<GeneralSubtree> var4A89C5007B7E4421B64642BE0339554A_1150129442 = (permittedSubtrees.getSubtrees()).iterator();
                var4A89C5007B7E4421B64642BE0339554A_1150129442.hasNext();
                GeneralSubtree generalSubtree = var4A89C5007B7E4421B64642BE0339554A_1150129442.next();
                {
                    generalSubtree.dumpValue(sb, prefix + "    ");
                } //End block
            } //End collapsed parenthetic
            sb.append(prefix).append("  ]\n");
        } //End block
        {
            sb.append(prefix).append("  Excluded: [\n");
            {
                Iterator<GeneralSubtree> var3D4F5E5636E3D0D1639AF9F96505A272_1476811334 = (excludedSubtrees.getSubtrees()).iterator();
                var3D4F5E5636E3D0D1639AF9F96505A272_1476811334.hasNext();
                GeneralSubtree generalSubtree = var3D4F5E5636E3D0D1639AF9F96505A272_1476811334.next();
                {
                    generalSubtree.dumpValue(sb, prefix + "    ");
                } //End block
            } //End collapsed parenthetic
            sb.append(prefix).append("  ]\n");
        } //End block
        sb.append('\n').append(prefix).append("]\n");
        addTaint(sb.getTaint());
        addTaint(prefix.getTaint());
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.255 -0400", hash_original_field = "0F2F0693D95F2402F86C3A5B6E0E575B", hash_generated_field = "B4D47106C6BA5DC8C2956CCE475720F8")

    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            new ASN1Implicit(0, GeneralSubtrees.ASN1),
            new ASN1Implicit(1, GeneralSubtrees.ASN1) }) {
        {
            setOptional(0);
            setOptional(1);
        }

        @Override protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;
            return new NameConstraints(
                    (GeneralSubtrees) values[0],
                    (GeneralSubtrees) values[1],
                    in.getEncoded());
        }

        @Override protected void getValues(Object object, Object[] values) {
            NameConstraints nc = (NameConstraints) object;
            values[0] = nc.permittedSubtrees;
            values[1] = nc.excludedSubtrees;
        }
    };
    /*
    // orphaned legacy method
    @Override protected void getValues(Object object, Object[] values) {
            NameConstraints nc = (NameConstraints) object;
            values[0] = nc.permittedSubtrees;
            values[1] = nc.excludedSubtrees;
        }
    
    // orphaned legacy method
    @Override protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;
            return new NameConstraints(
                    (GeneralSubtrees) values[0],
                    (GeneralSubtrees) values[1],
                    in.getEncoded());
        }
    
    */
}

