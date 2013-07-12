package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.201 -0400", hash_original_field = "6BD8EF16E6DBD287528E2D9E158E918B", hash_generated_field = "7C183FAE1C4A852E4C170F871CE896DE")

    private GeneralSubtrees permittedSubtrees;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.201 -0400", hash_original_field = "1ACF560E835C137151C2C43F34A684DB", hash_generated_field = "842C7367D24623D67CDB9CF5EDD53468")

    private GeneralSubtrees excludedSubtrees;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.202 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.202 -0400", hash_original_field = "0B73E26440BFDB0D66AB7EFC48DAC91F", hash_generated_field = "8E1781FAED2BE993CB5C76415843F294")

    private ArrayList<GeneralName>[] permitted_names;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.202 -0400", hash_original_field = "8ECB62E22C5DD78BEDFD4CE561026E24", hash_generated_field = "E0D2B3769B023B270B4E969DD11C5AF9")

    private ArrayList<GeneralName>[] excluded_names;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.202 -0400", hash_original_method = "22A7E7A2EB4ADA3B586F576057F0955D", hash_generated_method = "5E67AD0C86710B6BDFF7ECF61336EC01")
    public  NameConstraints(GeneralSubtrees permittedSubtrees,
                           GeneralSubtrees excludedSubtrees) {
    if(permittedSubtrees != null)        
        {
            List<GeneralSubtree> ps = permittedSubtrees.getSubtrees();
    if(ps == null || ps.isEmpty())            
            {
                IllegalArgumentException varFA3A25D61E91A1A53597FEB6C1C9DCF7_495740387 = new IllegalArgumentException("permittedSubtrees are empty");
                varFA3A25D61E91A1A53597FEB6C1C9DCF7_495740387.addTaint(taint);
                throw varFA3A25D61E91A1A53597FEB6C1C9DCF7_495740387;
            } //End block
        } //End block
    if(excludedSubtrees != null)        
        {
            List<GeneralSubtree> es = excludedSubtrees.getSubtrees();
    if(es == null || es.isEmpty())            
            {
                IllegalArgumentException var69068CFE9E140C713C89A1A82166F086_1575119363 = new IllegalArgumentException("excludedSubtrees are empty");
                var69068CFE9E140C713C89A1A82166F086_1575119363.addTaint(taint);
                throw var69068CFE9E140C713C89A1A82166F086_1575119363;
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.203 -0400", hash_original_method = "0B4FF50B5EED3F81B51F891413D3BBDC", hash_generated_method = "582E2E363AE87AB58D993B6DB1CE1EF6")
    private  NameConstraints(GeneralSubtrees permittedSubtrees,
                            GeneralSubtrees excludedSubtrees, byte[] encoding) {
        this(permittedSubtrees, excludedSubtrees);
        addTaint(excludedSubtrees.getTaint());
        addTaint(permittedSubtrees.getTaint());
        this.encoding = encoding;
        // ---------- Original Method ----------
        //this.encoding = encoding;
    }

    
        public static NameConstraints decode(byte[] encoding) throws IOException {
        return (NameConstraints) ASN1.decode(encoding);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.204 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "D0D28C6D90F4A160D2009557284B30B0")
    @Override
    public byte[] getEncoded() {
    if(encoding == null)        
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] var84BEA1F0FD2CE16F7E562A9F06EF03D3_970264771 = (encoding);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1971545612 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1971545612;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.205 -0400", hash_original_method = "D5B90ECD7CBCC97B9564754E474A01DA", hash_generated_method = "68F2E6CC77406B2CC339C3449F94A293")
    private void prepareNames() {
        permitted_names = new ArrayList[9];
    if(permittedSubtrees != null)        
        {
for(GeneralSubtree generalSubtree : permittedSubtrees.getSubtrees())
            {
                GeneralName name = generalSubtree.getBase();
                int tag = name.getTag();
    if(permitted_names[tag] == null)                
                {
                    permitted_names[tag] = new ArrayList<GeneralName>();
                } //End block
                permitted_names[tag].add(name);
            } //End block
        } //End block
        excluded_names = new ArrayList[9];
    if(excludedSubtrees != null)        
        {
for(GeneralSubtree generalSubtree : excludedSubtrees.getSubtrees())
            {
                GeneralName name = generalSubtree.getBase();
                int tag = name.getTag();
    if(excluded_names[tag] == null)                
                {
                    excluded_names[tag] = new ArrayList<GeneralName>();
                } //End block
                excluded_names[tag].add(name);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.205 -0400", hash_original_method = "7F050A55683D0AA0C8EC41E810522931", hash_generated_method = "4A642D64C3E5A0FD40D454B017C18270")
    private byte[] getExtensionValue(X509Certificate cert, String OID) {
        addTaint(OID.getTaint());
        addTaint(cert.getTaint());
        try 
        {
            byte[] bytes = cert.getExtensionValue(OID);
    if(bytes == null)            
            {
                byte[] var37A6259CC0C1DAE299A7866489DFF0BD_1166175478 = (null);
                                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1027860360 = {getTaintByte()};
                return var2F9C81BC6E497382285CD6B7A7E33DE1_1027860360;
            } //End block
            byte[] varB1B51C0C2868C986EDA7186601141A11_1210915726 = ((byte[]) ASN1OctetString.getInstance().decode(bytes));
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1108913858 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1108913858;
        } //End block
        catch (IOException e)
        {
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_933561017 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1336357495 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1336357495;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.206 -0400", hash_original_method = "29F552B10A233C166AD77E1C4D545B27", hash_generated_method = "72FBB59E399CDAE7206C868527C8A7B6")
    public boolean isAcceptable(X509Certificate cert) {
        addTaint(cert.getTaint());
    if(permitted_names == null)        
        {
            prepareNames();
        } //End block
        byte[] bytes = getExtensionValue(cert, "2.5.29.17");
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
            boolean var68934A3E9455FA72420237EB05902327_699974504 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1997395777 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1997395777;
        } //End block
    if((excluded_names[4] != null) || (permitted_names[4] != null))        
        {
            try 
            {
                names.add(new GeneralName(4,
                        cert.getSubjectX500Principal().getName()));
            } //End block
            catch (IOException e)
            {
            } //End block
        } //End block
        boolean varD0EDB3A4BDF9C87D2708957F42F24AA5_448257179 = (isAcceptable(names));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1786972516 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1786972516;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.207 -0400", hash_original_method = "D894692E4046265C2E05884CCE780235", hash_generated_method = "459029768F05B71D576B887D885B6044")
    public boolean isAcceptable(List<GeneralName> names) {
        addTaint(names.getTaint());
    if(permitted_names == null)        
        {
            prepareNames();
        } //End block
        boolean[] types_presented = new boolean[9];
        boolean[] permitted_found = new boolean[9];
for(GeneralName name : names)
        {
            int type = name.getTag();
    if(excluded_names[type] != null)            
            {
for(int i = 0;i < excluded_names[type].size();i++)
                {
    if(excluded_names[type].get(i).isAcceptable(name))                    
                    {
                        boolean var68934A3E9455FA72420237EB05902327_182083251 = (false);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_162475308 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_162475308;
                    } //End block
                } //End block
            } //End block
    if((permitted_names[type] != null) && (!permitted_found[type]))            
            {
                types_presented[type] = true;
for(int i = 0;i < permitted_names[type].size();i++)
                {
    if(permitted_names[type].get(i).isAcceptable(name))                    
                    {
                        permitted_found[type] = true;
                    } //End block
                } //End block
            } //End block
        } //End block
for(int type = 0;type < 9;type++)
        {
    if(types_presented[type] && !permitted_found[type])            
            {
                boolean var68934A3E9455FA72420237EB05902327_692047408 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1371303874 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1371303874;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_2054305435 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1094585766 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1094585766;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.208 -0400", hash_original_method = "54185F2659E074B2203C13418D4687EB", hash_generated_method = "7767A1292F0845AA0F9EF9DD7A70C32B")
    @Override
    public void dumpValue(StringBuilder sb, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(sb.getTaint());
        sb.append(prefix).append("Name Constraints: [\n");
    if(permittedSubtrees != null)        
        {
            sb.append(prefix).append("  Permitted: [\n");
for(GeneralSubtree generalSubtree : permittedSubtrees.getSubtrees())
            {
                generalSubtree.dumpValue(sb, prefix + "    ");
            } //End block
            sb.append(prefix).append("  ]\n");
        } //End block
    if(excludedSubtrees != null)        
        {
            sb.append(prefix).append("  Excluded: [\n");
for(GeneralSubtree generalSubtree : excludedSubtrees.getSubtrees())
            {
                generalSubtree.dumpValue(sb, prefix + "    ");
            } //End block
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.209 -0400", hash_original_field = "0F2F0693D95F2402F86C3A5B6E0E575B", hash_generated_field = "B4D47106C6BA5DC8C2956CCE475720F8")

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

