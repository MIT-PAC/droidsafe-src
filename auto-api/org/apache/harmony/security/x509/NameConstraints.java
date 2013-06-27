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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.215 -0400", hash_original_field = "6BD8EF16E6DBD287528E2D9E158E918B", hash_generated_field = "7C183FAE1C4A852E4C170F871CE896DE")

    private GeneralSubtrees permittedSubtrees;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.223 -0400", hash_original_field = "1ACF560E835C137151C2C43F34A684DB", hash_generated_field = "842C7367D24623D67CDB9CF5EDD53468")

    private GeneralSubtrees excludedSubtrees;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.223 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.223 -0400", hash_original_field = "0B73E26440BFDB0D66AB7EFC48DAC91F", hash_generated_field = "8E1781FAED2BE993CB5C76415843F294")

    private ArrayList<GeneralName>[] permitted_names;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.223 -0400", hash_original_field = "8ECB62E22C5DD78BEDFD4CE561026E24", hash_generated_field = "E0D2B3769B023B270B4E969DD11C5AF9")

    private ArrayList<GeneralName>[] excluded_names;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.228 -0400", hash_original_method = "22A7E7A2EB4ADA3B586F576057F0955D", hash_generated_method = "F543FB6F0B839487209D61EA1650279E")
    public  NameConstraints(GeneralSubtrees permittedSubtrees,
                           GeneralSubtrees excludedSubtrees) {
        {
            List<GeneralSubtree> ps;
            ps = permittedSubtrees.getSubtrees();
            {
                boolean var3E1DBA726FF28934E229E135AA842EA6_582375311 = (ps == null || ps.isEmpty());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("permittedSubtrees are empty");
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            List<GeneralSubtree> es;
            es = excludedSubtrees.getSubtrees();
            {
                boolean var856995C505D9587EAB6B1B961EA39A07_743605025 = (es == null || es.isEmpty());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.228 -0400", hash_original_method = "0B4FF50B5EED3F81B51F891413D3BBDC", hash_generated_method = "A55D61CC58F582DA4534F611CFC65D2F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.234 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "2971F3953153A665B4818CA91724B158")
    @Override
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_832245863 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_832245863;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.280 -0400", hash_original_method = "D5B90ECD7CBCC97B9564754E474A01DA", hash_generated_method = "D99654956636FBBD6B3293B50AC79498")
    private void prepareNames() {
        permitted_names = new ArrayList[9];
        {
            {
                Iterator<GeneralSubtree> var4A89C5007B7E4421B64642BE0339554A_1381329496 = (permittedSubtrees.getSubtrees()).iterator();
                var4A89C5007B7E4421B64642BE0339554A_1381329496.hasNext();
                GeneralSubtree generalSubtree = var4A89C5007B7E4421B64642BE0339554A_1381329496.next();
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
                Iterator<GeneralSubtree> var3D4F5E5636E3D0D1639AF9F96505A272_385667012 = (excludedSubtrees.getSubtrees()).iterator();
                var3D4F5E5636E3D0D1639AF9F96505A272_385667012.hasNext();
                GeneralSubtree generalSubtree = var3D4F5E5636E3D0D1639AF9F96505A272_385667012.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.284 -0400", hash_original_method = "7F050A55683D0AA0C8EC41E810522931", hash_generated_method = "FBB1D95F005DDFC4561617DD9D14E01D")
    private byte[] getExtensionValue(X509Certificate cert, String OID) {
        try 
        {
            byte[] bytes;
            bytes = cert.getExtensionValue(OID);
            byte[] varFE5AE10D423C1009FB60B58A35A1A76C_173188402 = ((byte[]) ASN1OctetString.getInstance().decode(bytes));
        } //End block
        catch (IOException e)
        { }
        addTaint(cert.getTaint());
        addTaint(OID.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_168475726 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_168475726;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.288 -0400", hash_original_method = "29F552B10A233C166AD77E1C4D545B27", hash_generated_method = "54F8B37D9240ADEFA959F1A95F2599D1")
    public boolean isAcceptable(X509Certificate cert) {
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
        boolean varC913719CB293685FA8CC7A51429EA1C0_1305037573 = (isAcceptable(names));
        addTaint(cert.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1383506311 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1383506311;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.327 -0400", hash_original_method = "D894692E4046265C2E05884CCE780235", hash_generated_method = "ED3A8BAFDA85EE765EFAB9104C478CE1")
    public boolean isAcceptable(List<GeneralName> names) {
        {
            prepareNames();
        } //End block
        boolean[] types_presented;
        types_presented = new boolean[9];
        boolean[] permitted_found;
        permitted_found = new boolean[9];
        {
            Iterator<GeneralName> var294D9DCA9D514EFD87D352AAAE97996B_380438988 = (names).iterator();
            var294D9DCA9D514EFD87D352AAAE97996B_380438988.hasNext();
            GeneralName name = var294D9DCA9D514EFD87D352AAAE97996B_380438988.next();
            {
                int type;
                type = name.getTag();
                {
                    {
                        int i;
                        i = 0;
                        boolean var3BD754F49C44E1DB554EBB697585C8AE_1756741354 = (i < excluded_names[type].size());
                        {
                            {
                                boolean var9208CD8ADC84893F0258C5ECF2EF8A7B_1212544085 = (excluded_names[type].get(i).isAcceptable(name));
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    types_presented[type] = true;
                    {
                        int i;
                        i = 0;
                        boolean varF336BC835DEE0F95B686C74C5CCC2137_119656606 = (i < permitted_names[type].size());
                        {
                            {
                                boolean varB45842109D0B75BE944A10B508747846_1513877675 = (permitted_names[type].get(i).isAcceptable(name));
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
        addTaint(names.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_909520942 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_909520942;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.384 -0400", hash_original_method = "54185F2659E074B2203C13418D4687EB", hash_generated_method = "F24E723F696EF0CC89374A8CD2A1214F")
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        sb.append(prefix).append("Name Constraints: [\n");
        {
            sb.append(prefix).append("  Permitted: [\n");
            {
                Iterator<GeneralSubtree> var4A89C5007B7E4421B64642BE0339554A_707282305 = (permittedSubtrees.getSubtrees()).iterator();
                var4A89C5007B7E4421B64642BE0339554A_707282305.hasNext();
                GeneralSubtree generalSubtree = var4A89C5007B7E4421B64642BE0339554A_707282305.next();
                {
                    generalSubtree.dumpValue(sb, prefix + "    ");
                } //End block
            } //End collapsed parenthetic
            sb.append(prefix).append("  ]\n");
        } //End block
        {
            sb.append(prefix).append("  Excluded: [\n");
            {
                Iterator<GeneralSubtree> var3D4F5E5636E3D0D1639AF9F96505A272_1778655808 = (excludedSubtrees.getSubtrees()).iterator();
                var3D4F5E5636E3D0D1639AF9F96505A272_1778655808.hasNext();
                GeneralSubtree generalSubtree = var3D4F5E5636E3D0D1639AF9F96505A272_1778655808.next();
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.388 -0400", hash_original_field = "0F2F0693D95F2402F86C3A5B6E0E575B", hash_generated_field = "B4D47106C6BA5DC8C2956CCE475720F8")

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
}

