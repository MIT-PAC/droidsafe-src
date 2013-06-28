package gov.nist.core;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DuplicateNameValueList implements Serializable, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.245 -0400", hash_original_field = "EDE63C75EB75F5125C1E2C2C268E165A", hash_generated_field = "6BB90EA38890EB2F7E772ABE1764102D")

    private MultiValueMapImpl<NameValue> nameValueMap = new MultiValueMapImpl<NameValue>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.245 -0400", hash_original_field = "A0F0BC95016C862498BBAD29D1F4D9D4", hash_generated_field = "A55DB8D30D61AD070DC11E077713D1B8")

    private String separator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.245 -0400", hash_original_method = "20742916A9CB1D797182F33AF39D95AA", hash_generated_method = "477020C756F336130B9566E280E5FF72")
    public  DuplicateNameValueList() {
        this.separator = ";";
        // ---------- Original Method ----------
        //this.separator = ";";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.245 -0400", hash_original_method = "45084252F3EC1C5D752F2E607BC4F59B", hash_generated_method = "87C291B29969431F03CD87D5C89B7360")
    public void setSeparator(String separator) {
        this.separator = separator;
        // ---------- Original Method ----------
        //this.separator = separator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.246 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "7F109282B1D07DD1E1B8BE0CCCCEB402")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_592361597 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_592361597 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_592361597.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_592361597;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.246 -0400", hash_original_method = "D3346716394F96A19B31E823716035B3", hash_generated_method = "07B7083688C8D4EB7D7B6146D4422E25")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1118603300 = null; //Variable for return #1
        {
            boolean var9A2B0B8BC7E8C542F9A2F042622944F1_1546399431 = (!nameValueMap.isEmpty());
            {
                Iterator<NameValue> iterator = nameValueMap.values().iterator();
                {
                    boolean varA524DEFD7CC0C913305DE8790C40B8FE_100741169 = (iterator.hasNext());
                    {
                        {
                            Object obj = iterator.next();
                            {
                                GenericObject gobj = (GenericObject) obj;
                                gobj.encode(buffer);
                            } //End block
                            {
                                buffer.append(obj.toString());
                            } //End block
                            {
                                boolean varBA94060EAB38FC283ECB954DF4224C1E_1924176060 = (iterator.hasNext());
                                buffer.append(separator);
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1118603300 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1118603300.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1118603300;
        // ---------- Original Method ----------
        //if (!nameValueMap.isEmpty()) {
            //Iterator<NameValue> iterator = nameValueMap.values().iterator();
            //if (iterator.hasNext()) {
                //while (true) {
                    //Object obj = iterator.next();
                    //if (obj instanceof GenericObject) {
                        //GenericObject gobj = (GenericObject) obj;
                        //gobj.encode(buffer);
                    //} else {
                        //buffer.append(obj.toString());
                    //}
                    //if (iterator.hasNext())
                        //buffer.append(separator);
                    //else
                        //break;
                //}
            //}
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.247 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "A08DAC47FD03185C550AED082971CACB")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_622500027 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_622500027 = this.encode();
        varB4EAC82CA7396A68D541C85D26508E83_622500027.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_622500027;
        // ---------- Original Method ----------
        //return this.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.247 -0400", hash_original_method = "D5C6BB3BFBC83A4D51FBDE2E52B7ACF4", hash_generated_method = "C240572BC972034EFDCFCB2D655B1C01")
    public void set(NameValue nv) {
        this.nameValueMap.put(nv.getName().toLowerCase(), nv);
        addTaint(nv.getTaint());
        // ---------- Original Method ----------
        //this.nameValueMap.put(nv.getName().toLowerCase(), nv);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.247 -0400", hash_original_method = "89FDC30721EFC0C6F270B8D9CF8001D0", hash_generated_method = "EA2F599A55AD6ECBD8774C763BD9ECFA")
    public void set(String name, Object value) {
        NameValue nameValue = new NameValue(name, value);
        nameValueMap.put(name.toLowerCase(), nameValue);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //NameValue nameValue = new NameValue(name, value);
        //nameValueMap.put(name.toLowerCase(), nameValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.248 -0400", hash_original_method = "E566E8F19B44FC1FECCBFF06B810AB67", hash_generated_method = "8DEF48B7110C92D446DE4D78992E0C3C")
    public boolean equals(Object otherObject) {
        {
            boolean var5483DA14562500B9B202946E175C6ADB_1475148348 = (!otherObject.getClass().equals(this.getClass()));
        } //End collapsed parenthetic
        DuplicateNameValueList other = (DuplicateNameValueList) otherObject;
        {
            boolean var3377FD12E0376A7894E3A00A0F5816D2_1283041766 = (nameValueMap.size() != other.nameValueMap.size());
        } //End collapsed parenthetic
        Iterator<String> li = this.nameValueMap.keySet().iterator();
        {
            boolean varBC3D864DE8830EFC1098D2C2F456529D_1032981849 = (li.hasNext());
            {
                String key = (String) li.next();
                Collection nv1 = this.getNameValue(key);
                Collection nv2 = (Collection) other.nameValueMap.get(key);
                {
                    boolean varC317F8E9B63A112DB5D5B271C8C64DB8_1917703872 = (!nv2.equals(nv1));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(otherObject.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_108809851 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_108809851;
        // ---------- Original Method ----------
        //if ( otherObject == null ) {
            //return false;
        //}
        //if (!otherObject.getClass().equals(this.getClass())) {
            //return false;
        //}
        //DuplicateNameValueList other = (DuplicateNameValueList) otherObject;
        //if (nameValueMap.size() != other.nameValueMap.size()) {
            //return false;
        //}
        //Iterator<String> li = this.nameValueMap.keySet().iterator();
        //while (li.hasNext()) {
            //String key = (String) li.next();
            //Collection nv1 = this.getNameValue(key);
            //Collection nv2 = (Collection) other.nameValueMap.get(key);
            //if (nv2 == null)
                //return false;
            //else if (!nv2.equals(nv1))
                //return false;
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.249 -0400", hash_original_method = "C612873C096C9BEC2FEAD8B66B09FEED", hash_generated_method = "AC79A9B246D8FB3995774F061A6DB5EE")
    public Object getValue(String name) {
        Object varB4EAC82CA7396A68D541C85D26508E83_189946515 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1817859549 = null; //Variable for return #2
        Collection nv = this.getNameValue(name.toLowerCase());
        varB4EAC82CA7396A68D541C85D26508E83_189946515 = nv;
        varB4EAC82CA7396A68D541C85D26508E83_1817859549 = null;
        addTaint(name.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_1991037639; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1991037639 = varB4EAC82CA7396A68D541C85D26508E83_189946515;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1991037639 = varB4EAC82CA7396A68D541C85D26508E83_1817859549;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1991037639.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1991037639;
        // ---------- Original Method ----------
        //Collection nv = this.getNameValue(name.toLowerCase());
        //if (nv != null)
            //return nv;
        //else
            //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.250 -0400", hash_original_method = "3B6BB1718C2A9A54E5BA1FF364B56717", hash_generated_method = "96307A75DF75DF26C019FD09E401C447")
    public Collection getNameValue(String name) {
        Collection varB4EAC82CA7396A68D541C85D26508E83_1284347450 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1284347450 = (Collection) this.nameValueMap.get(name.toLowerCase());
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1284347450.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1284347450;
        // ---------- Original Method ----------
        //return (Collection) this.nameValueMap.get(name.toLowerCase());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.250 -0400", hash_original_method = "D5BB760FEF0605F784761761BB05E75A", hash_generated_method = "8827511FF754EADAB87AF523D244E1F5")
    public boolean hasNameValue(String name) {
        boolean var58F8D08D56691EC4704D71691293BECD_620341477 = (nameValueMap.containsKey(name.toLowerCase()));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1029966100 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1029966100;
        // ---------- Original Method ----------
        //return nameValueMap.containsKey(name.toLowerCase());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.251 -0400", hash_original_method = "DB3F0BFFB6CE4D49FE300461E52C77CC", hash_generated_method = "4F9D5F75415A49272429CC0B8BD665DF")
    public boolean delete(String name) {
        String lcName = name.toLowerCase();
        {
            boolean var425ED28131C9C07CDAFF29CB32B1F16C_1829206212 = (this.nameValueMap.containsKey(lcName));
            {
                this.nameValueMap.remove(lcName);
            } //End block
        } //End collapsed parenthetic
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1690801090 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1690801090;
        // ---------- Original Method ----------
        //String lcName = name.toLowerCase();
        //if (this.nameValueMap.containsKey(lcName)) {
            //this.nameValueMap.remove(lcName);
            //return true;
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.251 -0400", hash_original_method = "19FF4230E4AD609C94D0ED393241A96C", hash_generated_method = "42789E539E276CC8199B1F19364287C7")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1947899411 = null; //Variable for return #1
        DuplicateNameValueList retval = new DuplicateNameValueList();
        retval.setSeparator(this.separator);
        Iterator<NameValue> it = this.nameValueMap.values().iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_2087390091 = (it.hasNext());
            {
                retval.set((NameValue) ((NameValue) it.next()).clone());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1947899411 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1947899411.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1947899411;
        // ---------- Original Method ----------
        //DuplicateNameValueList retval = new DuplicateNameValueList();
        //retval.setSeparator(this.separator);
        //Iterator<NameValue> it = this.nameValueMap.values().iterator();
        //while (it.hasNext()) {
            //retval.set((NameValue) ((NameValue) it.next()).clone());
        //}
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.252 -0400", hash_original_method = "FD05C240A769227CDB628211DF5EC32E", hash_generated_method = "F805144AC7819AD8BE673467246F94E0")
    public Iterator<NameValue> iterator() {
        Iterator<NameValue> varB4EAC82CA7396A68D541C85D26508E83_2081616208 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2081616208 = this.nameValueMap.values().iterator();
        varB4EAC82CA7396A68D541C85D26508E83_2081616208.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2081616208;
        // ---------- Original Method ----------
        //return this.nameValueMap.values().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.252 -0400", hash_original_method = "3A38488A38C81B5FE756BBBB95D22DE2", hash_generated_method = "57B96C74B1EFB2F5464706A795DE9B4A")
    public Iterator<String> getNames() {
        Iterator<String> varB4EAC82CA7396A68D541C85D26508E83_564994901 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_564994901 = this.nameValueMap.keySet().iterator();
        varB4EAC82CA7396A68D541C85D26508E83_564994901.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_564994901;
        // ---------- Original Method ----------
        //return this.nameValueMap.keySet().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.253 -0400", hash_original_method = "6D3851F46197204C176DAB6DC4EAB5DB", hash_generated_method = "E7BD486483DDDE8523B993754DD78AE4")
    public String getParameter(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_1100246045 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_247692387 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_2060979297 = null; //Variable for return #3
        Object val = this.getValue(name);
        varB4EAC82CA7396A68D541C85D26508E83_1100246045 = null;
        varB4EAC82CA7396A68D541C85D26508E83_247692387 = ((GenericObject) val).encode();
        varB4EAC82CA7396A68D541C85D26508E83_2060979297 = val.toString();
        addTaint(name.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1628523623; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1628523623 = varB4EAC82CA7396A68D541C85D26508E83_1100246045;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1628523623 = varB4EAC82CA7396A68D541C85D26508E83_247692387;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1628523623 = varB4EAC82CA7396A68D541C85D26508E83_2060979297;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1628523623.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1628523623;
        // ---------- Original Method ----------
        //Object val = this.getValue(name);
        //if (val == null)
            //return null;
        //if (val instanceof GenericObject)
            //return ((GenericObject) val).encode();
        //else
            //return val.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.254 -0400", hash_original_method = "B40C6D0DEDA13F85BB68C572A20E397F", hash_generated_method = "0E3C4AF8B49E5DCB08329C4AB11AFFF8")
    public void clear() {
        nameValueMap.clear();
        // ---------- Original Method ----------
        //nameValueMap.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.254 -0400", hash_original_method = "A87A9771E4444067F01FCF3F6D8B907E", hash_generated_method = "DCB9D9F7BB443BF1617D9B6B603D9E05")
    public boolean isEmpty() {
        boolean var6AD78D709A92BC023CA0717C8CCD300F_1513713015 = (this.nameValueMap.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_432172906 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_432172906;
        // ---------- Original Method ----------
        //return this.nameValueMap.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.254 -0400", hash_original_method = "3AC71B082E8AAC37EBD928C6A35A39AB", hash_generated_method = "3D4FF3460164442BE81DBB3C488E0D8F")
    public NameValue put(String key, NameValue value) {
        NameValue varB4EAC82CA7396A68D541C85D26508E83_1320982917 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1320982917 = (NameValue) this.nameValueMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1320982917.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1320982917;
        // ---------- Original Method ----------
        //return (NameValue) this.nameValueMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.255 -0400", hash_original_method = "1975EE5F7D7766619160CC0D9D0851BB", hash_generated_method = "051EB299D7FC67F78411247DF124DA2D")
    public NameValue remove(Object key) {
        NameValue varB4EAC82CA7396A68D541C85D26508E83_280885843 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_280885843 = (NameValue) this.nameValueMap.remove(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_280885843.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_280885843;
        // ---------- Original Method ----------
        //return (NameValue) this.nameValueMap.remove(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.256 -0400", hash_original_method = "7BBCC8968D761DFCA7152F0BE4E82809", hash_generated_method = "4598B29CCC74C9919FBCAF1E2E6A868C")
    public int size() {
        int varC12A53D5CDA47B5DE9AE383AE2221614_760844823 = (this.nameValueMap.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_82877492 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_82877492;
        // ---------- Original Method ----------
        //return this.nameValueMap.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.257 -0400", hash_original_method = "F30302CB3EB3055DF74F33593B8201EA", hash_generated_method = "A9258CDD9979FEC8BEE40FFCE70B1778")
    public Collection<NameValue> values() {
        Collection<NameValue> varB4EAC82CA7396A68D541C85D26508E83_1104459707 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1104459707 = this.nameValueMap.values();
        varB4EAC82CA7396A68D541C85D26508E83_1104459707.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1104459707;
        // ---------- Original Method ----------
        //return this.nameValueMap.values();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.257 -0400", hash_original_method = "4C24AE5D2C44E17C467B047C84E46484", hash_generated_method = "2F6904854CD6364F45CC0B01AF51899C")
    public int hashCode() {
        int varDB7BD910A91A2A8A0D9C3217268AAA10_700822722 = (this.nameValueMap.keySet().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1465799225 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1465799225;
        // ---------- Original Method ----------
        //return this.nameValueMap.keySet().hashCode();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.257 -0400", hash_original_field = "0ED15C20152326822E26443FE975E5C6", hash_generated_field = "549B3ABEAD7830A28E925E7D8255A93A")

    private static final long serialVersionUID = -5611332957903796952L;
}

