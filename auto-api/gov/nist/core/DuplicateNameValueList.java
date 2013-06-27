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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.917 -0400", hash_original_field = "EDE63C75EB75F5125C1E2C2C268E165A", hash_generated_field = "6BB90EA38890EB2F7E772ABE1764102D")

    private MultiValueMapImpl<NameValue> nameValueMap = new MultiValueMapImpl<NameValue>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.917 -0400", hash_original_field = "A0F0BC95016C862498BBAD29D1F4D9D4", hash_generated_field = "A55DB8D30D61AD070DC11E077713D1B8")

    private String separator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.917 -0400", hash_original_method = "20742916A9CB1D797182F33AF39D95AA", hash_generated_method = "477020C756F336130B9566E280E5FF72")
    public  DuplicateNameValueList() {
        this.separator = ";";
        // ---------- Original Method ----------
        //this.separator = ";";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.917 -0400", hash_original_method = "45084252F3EC1C5D752F2E607BC4F59B", hash_generated_method = "87C291B29969431F03CD87D5C89B7360")
    public void setSeparator(String separator) {
        this.separator = separator;
        // ---------- Original Method ----------
        //this.separator = separator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.918 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "EA3C71B1A6CD9BB7AC3363178925DFB3")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1176304274 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1176304274 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1176304274.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1176304274;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.924 -0400", hash_original_method = "D3346716394F96A19B31E823716035B3", hash_generated_method = "734C61B44FEAE1C7C113CE5F3DBD4E50")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1920393594 = null; //Variable for return #1
        {
            boolean var9A2B0B8BC7E8C542F9A2F042622944F1_1395969828 = (!nameValueMap.isEmpty());
            {
                Iterator<NameValue> iterator;
                iterator = nameValueMap.values().iterator();
                {
                    boolean varA524DEFD7CC0C913305DE8790C40B8FE_430212914 = (iterator.hasNext());
                    {
                        {
                            Object obj;
                            obj = iterator.next();
                            {
                                GenericObject gobj;
                                gobj = (GenericObject) obj;
                                gobj.encode(buffer);
                            } //End block
                            {
                                buffer.append(obj.toString());
                            } //End block
                            {
                                boolean varBA94060EAB38FC283ECB954DF4224C1E_1434951614 = (iterator.hasNext());
                                buffer.append(separator);
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1920393594 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1920393594.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1920393594;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.925 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "54F3B69F83D64C91548F75691045D74C")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_290639496 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_290639496 = this.encode();
        varB4EAC82CA7396A68D541C85D26508E83_290639496.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_290639496;
        // ---------- Original Method ----------
        //return this.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.925 -0400", hash_original_method = "D5C6BB3BFBC83A4D51FBDE2E52B7ACF4", hash_generated_method = "C240572BC972034EFDCFCB2D655B1C01")
    public void set(NameValue nv) {
        this.nameValueMap.put(nv.getName().toLowerCase(), nv);
        addTaint(nv.getTaint());
        // ---------- Original Method ----------
        //this.nameValueMap.put(nv.getName().toLowerCase(), nv);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.926 -0400", hash_original_method = "89FDC30721EFC0C6F270B8D9CF8001D0", hash_generated_method = "2B892F8B4A6BCCDD9A9A677F6FFC9B88")
    public void set(String name, Object value) {
        NameValue nameValue;
        nameValue = new NameValue(name, value);
        nameValueMap.put(name.toLowerCase(), nameValue);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //NameValue nameValue = new NameValue(name, value);
        //nameValueMap.put(name.toLowerCase(), nameValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.926 -0400", hash_original_method = "E566E8F19B44FC1FECCBFF06B810AB67", hash_generated_method = "2EE0E8E84C70572E00F49E834059C423")
    public boolean equals(Object otherObject) {
        {
            boolean var5483DA14562500B9B202946E175C6ADB_992532826 = (!otherObject.getClass().equals(this.getClass()));
        } //End collapsed parenthetic
        DuplicateNameValueList other;
        other = (DuplicateNameValueList) otherObject;
        {
            boolean var3377FD12E0376A7894E3A00A0F5816D2_350478560 = (nameValueMap.size() != other.nameValueMap.size());
        } //End collapsed parenthetic
        Iterator<String> li;
        li = this.nameValueMap.keySet().iterator();
        {
            boolean varBC3D864DE8830EFC1098D2C2F456529D_1061955980 = (li.hasNext());
            {
                String key;
                key = (String) li.next();
                Collection nv1;
                nv1 = this.getNameValue(key);
                Collection nv2;
                nv2 = (Collection) other.nameValueMap.get(key);
                {
                    boolean varC317F8E9B63A112DB5D5B271C8C64DB8_775854651 = (!nv2.equals(nv1));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(otherObject.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_625081094 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_625081094;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.935 -0400", hash_original_method = "C612873C096C9BEC2FEAD8B66B09FEED", hash_generated_method = "4B8196AC780D61740FDAC2AA3E5FD665")
    public Object getValue(String name) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1982987703 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1698193519 = null; //Variable for return #2
        Collection nv;
        nv = this.getNameValue(name.toLowerCase());
        varB4EAC82CA7396A68D541C85D26508E83_1982987703 = nv;
        varB4EAC82CA7396A68D541C85D26508E83_1698193519 = null;
        addTaint(name.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_713107232; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_713107232 = varB4EAC82CA7396A68D541C85D26508E83_1982987703;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_713107232 = varB4EAC82CA7396A68D541C85D26508E83_1698193519;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_713107232.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_713107232;
        // ---------- Original Method ----------
        //Collection nv = this.getNameValue(name.toLowerCase());
        //if (nv != null)
            //return nv;
        //else
            //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.935 -0400", hash_original_method = "3B6BB1718C2A9A54E5BA1FF364B56717", hash_generated_method = "2D80BF2F2429B3094FF1337957C8C325")
    public Collection getNameValue(String name) {
        Collection varB4EAC82CA7396A68D541C85D26508E83_2137037874 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2137037874 = (Collection) this.nameValueMap.get(name.toLowerCase());
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2137037874.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2137037874;
        // ---------- Original Method ----------
        //return (Collection) this.nameValueMap.get(name.toLowerCase());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.936 -0400", hash_original_method = "D5BB760FEF0605F784761761BB05E75A", hash_generated_method = "8B28975F2AC4333693DC295D428E2F19")
    public boolean hasNameValue(String name) {
        boolean var58F8D08D56691EC4704D71691293BECD_1391674777 = (nameValueMap.containsKey(name.toLowerCase()));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1044081855 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1044081855;
        // ---------- Original Method ----------
        //return nameValueMap.containsKey(name.toLowerCase());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.936 -0400", hash_original_method = "DB3F0BFFB6CE4D49FE300461E52C77CC", hash_generated_method = "119B2E94FB5CEC5033D1C74C3EF736B3")
    public boolean delete(String name) {
        String lcName;
        lcName = name.toLowerCase();
        {
            boolean var425ED28131C9C07CDAFF29CB32B1F16C_786314898 = (this.nameValueMap.containsKey(lcName));
            {
                this.nameValueMap.remove(lcName);
            } //End block
        } //End collapsed parenthetic
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1109258962 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1109258962;
        // ---------- Original Method ----------
        //String lcName = name.toLowerCase();
        //if (this.nameValueMap.containsKey(lcName)) {
            //this.nameValueMap.remove(lcName);
            //return true;
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.937 -0400", hash_original_method = "19FF4230E4AD609C94D0ED393241A96C", hash_generated_method = "9F49C6901ADE21F161F228CD15F354E9")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_782453742 = null; //Variable for return #1
        DuplicateNameValueList retval;
        retval = new DuplicateNameValueList();
        retval.setSeparator(this.separator);
        Iterator<NameValue> it;
        it = this.nameValueMap.values().iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_2011901055 = (it.hasNext());
            {
                retval.set((NameValue) ((NameValue) it.next()).clone());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_782453742 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_782453742.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_782453742;
        // ---------- Original Method ----------
        //DuplicateNameValueList retval = new DuplicateNameValueList();
        //retval.setSeparator(this.separator);
        //Iterator<NameValue> it = this.nameValueMap.values().iterator();
        //while (it.hasNext()) {
            //retval.set((NameValue) ((NameValue) it.next()).clone());
        //}
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.937 -0400", hash_original_method = "FD05C240A769227CDB628211DF5EC32E", hash_generated_method = "D8C7F91E4B0341200947408BC76FB243")
    public Iterator<NameValue> iterator() {
        Iterator<NameValue> varB4EAC82CA7396A68D541C85D26508E83_334075929 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_334075929 = this.nameValueMap.values().iterator();
        varB4EAC82CA7396A68D541C85D26508E83_334075929.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_334075929;
        // ---------- Original Method ----------
        //return this.nameValueMap.values().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.954 -0400", hash_original_method = "3A38488A38C81B5FE756BBBB95D22DE2", hash_generated_method = "F922C0B65E115C61A2AFD9FE2EB500BE")
    public Iterator<String> getNames() {
        Iterator<String> varB4EAC82CA7396A68D541C85D26508E83_1014275293 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1014275293 = this.nameValueMap.keySet().iterator();
        varB4EAC82CA7396A68D541C85D26508E83_1014275293.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1014275293;
        // ---------- Original Method ----------
        //return this.nameValueMap.keySet().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.954 -0400", hash_original_method = "6D3851F46197204C176DAB6DC4EAB5DB", hash_generated_method = "42ED45C7ACF3162C5DDB5BCEF6E85E3D")
    public String getParameter(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_2121293545 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_197185532 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_531071357 = null; //Variable for return #3
        Object val;
        val = this.getValue(name);
        varB4EAC82CA7396A68D541C85D26508E83_2121293545 = null;
        varB4EAC82CA7396A68D541C85D26508E83_197185532 = ((GenericObject) val).encode();
        varB4EAC82CA7396A68D541C85D26508E83_531071357 = val.toString();
        addTaint(name.getTaint());
        String varA7E53CE21691AB073D9660D615818899_740477373; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_740477373 = varB4EAC82CA7396A68D541C85D26508E83_2121293545;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_740477373 = varB4EAC82CA7396A68D541C85D26508E83_197185532;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_740477373 = varB4EAC82CA7396A68D541C85D26508E83_531071357;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_740477373.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_740477373;
        // ---------- Original Method ----------
        //Object val = this.getValue(name);
        //if (val == null)
            //return null;
        //if (val instanceof GenericObject)
            //return ((GenericObject) val).encode();
        //else
            //return val.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.954 -0400", hash_original_method = "B40C6D0DEDA13F85BB68C572A20E397F", hash_generated_method = "0E3C4AF8B49E5DCB08329C4AB11AFFF8")
    public void clear() {
        nameValueMap.clear();
        // ---------- Original Method ----------
        //nameValueMap.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.955 -0400", hash_original_method = "A87A9771E4444067F01FCF3F6D8B907E", hash_generated_method = "925888DC684792654632A50CEFF255AA")
    public boolean isEmpty() {
        boolean var6AD78D709A92BC023CA0717C8CCD300F_102411753 = (this.nameValueMap.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1402075414 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1402075414;
        // ---------- Original Method ----------
        //return this.nameValueMap.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.955 -0400", hash_original_method = "3AC71B082E8AAC37EBD928C6A35A39AB", hash_generated_method = "46182AF404B67C4B32A13804209E59AD")
    public NameValue put(String key, NameValue value) {
        NameValue varB4EAC82CA7396A68D541C85D26508E83_1280943029 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1280943029 = (NameValue) this.nameValueMap.put(key, value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1280943029.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1280943029;
        // ---------- Original Method ----------
        //return (NameValue) this.nameValueMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.956 -0400", hash_original_method = "1975EE5F7D7766619160CC0D9D0851BB", hash_generated_method = "2B98AFB9377F40BBE31FFC6AD7660189")
    public NameValue remove(Object key) {
        NameValue varB4EAC82CA7396A68D541C85D26508E83_1018591557 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1018591557 = (NameValue) this.nameValueMap.remove(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1018591557.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1018591557;
        // ---------- Original Method ----------
        //return (NameValue) this.nameValueMap.remove(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.956 -0400", hash_original_method = "7BBCC8968D761DFCA7152F0BE4E82809", hash_generated_method = "88E15A391D3377FBE76185646D467D00")
    public int size() {
        int varC12A53D5CDA47B5DE9AE383AE2221614_1907810463 = (this.nameValueMap.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_31673148 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_31673148;
        // ---------- Original Method ----------
        //return this.nameValueMap.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.957 -0400", hash_original_method = "F30302CB3EB3055DF74F33593B8201EA", hash_generated_method = "530831F60AEDCE16BA0DC77935970CED")
    public Collection<NameValue> values() {
        Collection<NameValue> varB4EAC82CA7396A68D541C85D26508E83_3581466 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_3581466 = this.nameValueMap.values();
        varB4EAC82CA7396A68D541C85D26508E83_3581466.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_3581466;
        // ---------- Original Method ----------
        //return this.nameValueMap.values();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.957 -0400", hash_original_method = "4C24AE5D2C44E17C467B047C84E46484", hash_generated_method = "7097D274F0A89334AD5AE33508E42383")
    public int hashCode() {
        int varDB7BD910A91A2A8A0D9C3217268AAA10_773580698 = (this.nameValueMap.keySet().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_724735922 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_724735922;
        // ---------- Original Method ----------
        //return this.nameValueMap.keySet().hashCode();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.957 -0400", hash_original_field = "0ED15C20152326822E26443FE975E5C6", hash_generated_field = "C684609292D03FBC22E487AEA486AA16")

    private static long serialVersionUID = -5611332957903796952L;
}

