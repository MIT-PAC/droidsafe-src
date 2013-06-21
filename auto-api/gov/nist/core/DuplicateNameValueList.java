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
    private MultiValueMapImpl<NameValue> nameValueMap = new MultiValueMapImpl<NameValue>();
    private String separator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.480 -0400", hash_original_method = "20742916A9CB1D797182F33AF39D95AA", hash_generated_method = "477020C756F336130B9566E280E5FF72")
    @DSModeled(DSC.SAFE)
    public DuplicateNameValueList() {
        this.separator = ";";
        // ---------- Original Method ----------
        //this.separator = ";";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.480 -0400", hash_original_method = "45084252F3EC1C5D752F2E607BC4F59B", hash_generated_method = "5B066F79104AEA40FEEB500F34D9A66B")
    @DSModeled(DSC.SAFE)
    public void setSeparator(String separator) {
        dsTaint.addTaint(separator);
        // ---------- Original Method ----------
        //this.separator = separator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.480 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "4310F523141D3B86D96E747EE4E93933")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encode() {
        String varFFB45C40AF627644780ECFF5921CFE15_869346048 = (encode(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.480 -0400", hash_original_method = "D3346716394F96A19B31E823716035B3", hash_generated_method = "45952E91F3943267F7111778BBD7EC18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer encode(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        {
            boolean var9A2B0B8BC7E8C542F9A2F042622944F1_969621666 = (!nameValueMap.isEmpty());
            {
                Iterator<NameValue> iterator;
                iterator = nameValueMap.values().iterator();
                {
                    boolean varA524DEFD7CC0C913305DE8790C40B8FE_421185642 = (iterator.hasNext());
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
                                boolean varBA94060EAB38FC283ECB954DF4224C1E_908958107 = (iterator.hasNext());
                                buffer.append(separator);
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (StringBuffer)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.481 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "8205DC148B3FF2ED409E42CD449C70F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var002E8E97D996E9DD2E7B0E1B0BD6187C_1744109744 = (this.encode());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.481 -0400", hash_original_method = "D5C6BB3BFBC83A4D51FBDE2E52B7ACF4", hash_generated_method = "58C5943E5B8FEEB3C9326009E3DF690D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void set(NameValue nv) {
        dsTaint.addTaint(nv.dsTaint);
        this.nameValueMap.put(nv.getName().toLowerCase(), nv);
        // ---------- Original Method ----------
        //this.nameValueMap.put(nv.getName().toLowerCase(), nv);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.481 -0400", hash_original_method = "89FDC30721EFC0C6F270B8D9CF8001D0", hash_generated_method = "3ABEB8B47DD3C0E560529076D4323CD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void set(String name, Object value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value.dsTaint);
        NameValue nameValue;
        nameValue = new NameValue(name, value);
        nameValueMap.put(name.toLowerCase(), nameValue);
        // ---------- Original Method ----------
        //NameValue nameValue = new NameValue(name, value);
        //nameValueMap.put(name.toLowerCase(), nameValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.482 -0400", hash_original_method = "E566E8F19B44FC1FECCBFF06B810AB67", hash_generated_method = "9AAE2EE49D2EB73CBABF9D00E0F5021A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object otherObject) {
        dsTaint.addTaint(otherObject.dsTaint);
        {
            boolean var5483DA14562500B9B202946E175C6ADB_698904486 = (!otherObject.getClass().equals(this.getClass()));
        } //End collapsed parenthetic
        DuplicateNameValueList other;
        other = (DuplicateNameValueList) otherObject;
        {
            boolean var3377FD12E0376A7894E3A00A0F5816D2_1985772746 = (nameValueMap.size() != other.nameValueMap.size());
        } //End collapsed parenthetic
        Iterator<String> li;
        li = this.nameValueMap.keySet().iterator();
        {
            boolean varBC3D864DE8830EFC1098D2C2F456529D_354227570 = (li.hasNext());
            {
                String key;
                key = (String) li.next();
                Collection nv1;
                nv1 = this.getNameValue(key);
                Collection nv2;
                nv2 = (Collection) other.nameValueMap.get(key);
                {
                    boolean varC317F8E9B63A112DB5D5B271C8C64DB8_1885351036 = (!nv2.equals(nv1));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.482 -0400", hash_original_method = "C612873C096C9BEC2FEAD8B66B09FEED", hash_generated_method = "7A4D9DFAA995DBC9C820DC19D63246CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getValue(String name) {
        dsTaint.addTaint(name);
        Collection nv;
        nv = this.getNameValue(name.toLowerCase());
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Collection nv = this.getNameValue(name.toLowerCase());
        //if (nv != null)
            //return nv;
        //else
            //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.482 -0400", hash_original_method = "3B6BB1718C2A9A54E5BA1FF364B56717", hash_generated_method = "AC94C00DCF4EF9C36CFE9C34EDF701D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection getNameValue(String name) {
        dsTaint.addTaint(name);
        Collection var13F35FC5BCCA2B6CDDCB3B395AC1019A_2031458980 = ((Collection) this.nameValueMap.get(name.toLowerCase()));
        return (Collection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (Collection) this.nameValueMap.get(name.toLowerCase());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.482 -0400", hash_original_method = "D5BB760FEF0605F784761761BB05E75A", hash_generated_method = "62FC62E0DE800F5FD82E0C7BA2C356F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasNameValue(String name) {
        dsTaint.addTaint(name);
        boolean var58F8D08D56691EC4704D71691293BECD_844943768 = (nameValueMap.containsKey(name.toLowerCase()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return nameValueMap.containsKey(name.toLowerCase());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.483 -0400", hash_original_method = "DB3F0BFFB6CE4D49FE300461E52C77CC", hash_generated_method = "6CE6195D3DE0AB96D1EC64729A36409D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean delete(String name) {
        dsTaint.addTaint(name);
        String lcName;
        lcName = name.toLowerCase();
        {
            boolean var425ED28131C9C07CDAFF29CB32B1F16C_2051677118 = (this.nameValueMap.containsKey(lcName));
            {
                this.nameValueMap.remove(lcName);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //String lcName = name.toLowerCase();
        //if (this.nameValueMap.containsKey(lcName)) {
            //this.nameValueMap.remove(lcName);
            //return true;
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.483 -0400", hash_original_method = "19FF4230E4AD609C94D0ED393241A96C", hash_generated_method = "B53044D5F1A7B8612C3DE9F3FEE75513")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        DuplicateNameValueList retval;
        retval = new DuplicateNameValueList();
        retval.setSeparator(this.separator);
        Iterator<NameValue> it;
        it = this.nameValueMap.values().iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_788221962 = (it.hasNext());
            {
                retval.set((NameValue) ((NameValue) it.next()).clone());
            } //End block
        } //End collapsed parenthetic
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //DuplicateNameValueList retval = new DuplicateNameValueList();
        //retval.setSeparator(this.separator);
        //Iterator<NameValue> it = this.nameValueMap.values().iterator();
        //while (it.hasNext()) {
            //retval.set((NameValue) ((NameValue) it.next()).clone());
        //}
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.483 -0400", hash_original_method = "FD05C240A769227CDB628211DF5EC32E", hash_generated_method = "E6C5B18F50DD1216C4F7E8B85F8E5BEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Iterator<NameValue> iterator() {
        Iterator<NameValue> var529BC68CFA9DBB605D8E5726D7299933_258367473 = (this.nameValueMap.values().iterator());
        return (Iterator<NameValue>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.nameValueMap.values().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.483 -0400", hash_original_method = "3A38488A38C81B5FE756BBBB95D22DE2", hash_generated_method = "25DFCCE279EAF0993F9F2825411C674D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Iterator<String> getNames() {
        Iterator<String> var8AE4EE8D3785FD881AFA7668E58FA9D8_1630215433 = (this.nameValueMap.keySet().iterator());
        return (Iterator<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.nameValueMap.keySet().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.484 -0400", hash_original_method = "6D3851F46197204C176DAB6DC4EAB5DB", hash_generated_method = "224D5E7620E07A7991B69B90B5244B4E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getParameter(String name) {
        dsTaint.addTaint(name);
        Object val;
        val = this.getValue(name);
        String var95441B18ED228B9E74BF37F54C5F5827_697981555 = (((GenericObject) val).encode());
        String var1256D27AA7319A7570F46BC6DF2B0099_1419912461 = (val.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Object val = this.getValue(name);
        //if (val == null)
            //return null;
        //if (val instanceof GenericObject)
            //return ((GenericObject) val).encode();
        //else
            //return val.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.484 -0400", hash_original_method = "B40C6D0DEDA13F85BB68C572A20E397F", hash_generated_method = "0E3C4AF8B49E5DCB08329C4AB11AFFF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clear() {
        nameValueMap.clear();
        // ---------- Original Method ----------
        //nameValueMap.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.484 -0400", hash_original_method = "A87A9771E4444067F01FCF3F6D8B907E", hash_generated_method = "15543F23409813FBD09D07FD4846C92A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEmpty() {
        boolean var6AD78D709A92BC023CA0717C8CCD300F_1675452015 = (this.nameValueMap.isEmpty());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.nameValueMap.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.485 -0400", hash_original_method = "3AC71B082E8AAC37EBD928C6A35A39AB", hash_generated_method = "85A0ADB0E092D56792122D286FF964D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NameValue put(String key, NameValue value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key);
        NameValue var7AB4C20CE76B89C9974DA0EA5B389DA8_1745140618 = ((NameValue) this.nameValueMap.put(key, value));
        return (NameValue)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (NameValue) this.nameValueMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.485 -0400", hash_original_method = "1975EE5F7D7766619160CC0D9D0851BB", hash_generated_method = "14F59297B6DFFFC37D65C1E3BB359A28")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NameValue remove(Object key) {
        dsTaint.addTaint(key.dsTaint);
        NameValue var7A295A65103EFC1E00591DC76D685C81_1123357156 = ((NameValue) this.nameValueMap.remove(key));
        return (NameValue)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (NameValue) this.nameValueMap.remove(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.485 -0400", hash_original_method = "7BBCC8968D761DFCA7152F0BE4E82809", hash_generated_method = "E086E0F453F3523F9F216A5C1F1544E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int size() {
        int varC12A53D5CDA47B5DE9AE383AE2221614_321547804 = (this.nameValueMap.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.nameValueMap.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.485 -0400", hash_original_method = "F30302CB3EB3055DF74F33593B8201EA", hash_generated_method = "6A05762821404D0F9546C0DA6EDEE511")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection<NameValue> values() {
        Collection<NameValue> var7425382141F2C91113057E0868098902_1412487072 = (this.nameValueMap.values());
        return (Collection<NameValue>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.nameValueMap.values();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.485 -0400", hash_original_method = "4C24AE5D2C44E17C467B047C84E46484", hash_generated_method = "41538B55D7268FF54BAFA2EFF073920C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int hashCode() {
        int varDB7BD910A91A2A8A0D9C3217268AAA10_1647618243 = (this.nameValueMap.keySet().hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.nameValueMap.keySet().hashCode();
    }

    
    private static final long serialVersionUID = -5611332957903796952L;
}

