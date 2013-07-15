package gov.nist.core;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DuplicateNameValueList implements Serializable, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.086 -0400", hash_original_field = "EDE63C75EB75F5125C1E2C2C268E165A", hash_generated_field = "6BB90EA38890EB2F7E772ABE1764102D")

    private MultiValueMapImpl<NameValue> nameValueMap = new MultiValueMapImpl<NameValue>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.087 -0400", hash_original_field = "A0F0BC95016C862498BBAD29D1F4D9D4", hash_generated_field = "A55DB8D30D61AD070DC11E077713D1B8")

    private String separator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.087 -0400", hash_original_method = "20742916A9CB1D797182F33AF39D95AA", hash_generated_method = "477020C756F336130B9566E280E5FF72")
    public  DuplicateNameValueList() {
        this.separator = ";";
        // ---------- Original Method ----------
        //this.separator = ";";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.088 -0400", hash_original_method = "45084252F3EC1C5D752F2E607BC4F59B", hash_generated_method = "87C291B29969431F03CD87D5C89B7360")
    public void setSeparator(String separator) {
        this.separator = separator;
        // ---------- Original Method ----------
        //this.separator = separator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.088 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "89927AF1F8750BDDDC60A3359B3D1667")
    public String encode() {
String var678B6FE61D54E5BD4E109D01C318C133_1639666401 =         encode(new StringBuffer()).toString();
        var678B6FE61D54E5BD4E109D01C318C133_1639666401.addTaint(taint);
        return var678B6FE61D54E5BD4E109D01C318C133_1639666401;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.088 -0400", hash_original_method = "D3346716394F96A19B31E823716035B3", hash_generated_method = "B73C61450FF9F6781971E1ED125D2495")
    public StringBuffer encode(StringBuffer buffer) {
        addTaint(buffer.getTaint());
    if(!nameValueMap.isEmpty())        
        {
            Iterator<NameValue> iterator = nameValueMap.values().iterator();
    if(iterator.hasNext())            
            {
                while
(true)                
                {
                    Object obj = iterator.next();
    if(obj instanceof GenericObject)                    
                    {
                        GenericObject gobj = (GenericObject) obj;
                        gobj.encode(buffer);
                    } //End block
                    else
                    {
                        buffer.append(obj.toString());
                    } //End block
    if(iterator.hasNext())                    
                    buffer.append(separator);
                    else
                    break;
                } //End block
            } //End block
        } //End block
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_1326033841 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_1326033841.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_1326033841;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.089 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "74DB7590E19093693E74C90924C13B03")
    public String toString() {
String varB17575D7C845B2C662583710539AAEBB_995801400 =         this.encode();
        varB17575D7C845B2C662583710539AAEBB_995801400.addTaint(taint);
        return varB17575D7C845B2C662583710539AAEBB_995801400;
        // ---------- Original Method ----------
        //return this.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.089 -0400", hash_original_method = "D5C6BB3BFBC83A4D51FBDE2E52B7ACF4", hash_generated_method = "10189CB13A09D9F760383B02D06B51EA")
    public void set(NameValue nv) {
        addTaint(nv.getTaint());
        this.nameValueMap.put(nv.getName().toLowerCase(), nv);
        // ---------- Original Method ----------
        //this.nameValueMap.put(nv.getName().toLowerCase(), nv);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.090 -0400", hash_original_method = "89FDC30721EFC0C6F270B8D9CF8001D0", hash_generated_method = "D2FA3F14A5FA677D0E42D2F7119F97E4")
    public void set(String name, Object value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        NameValue nameValue = new NameValue(name, value);
        nameValueMap.put(name.toLowerCase(), nameValue);
        // ---------- Original Method ----------
        //NameValue nameValue = new NameValue(name, value);
        //nameValueMap.put(name.toLowerCase(), nameValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.090 -0400", hash_original_method = "E566E8F19B44FC1FECCBFF06B810AB67", hash_generated_method = "37497E8AB6AB68614287511ACD928AC8")
    public boolean equals(Object otherObject) {
        addTaint(otherObject.getTaint());
    if(otherObject == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1464225832 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_55047330 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_55047330;
        } //End block
    if(!otherObject.getClass().equals(this.getClass()))        
        {
            boolean var68934A3E9455FA72420237EB05902327_2069046452 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_759372533 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_759372533;
        } //End block
        DuplicateNameValueList other = (DuplicateNameValueList) otherObject;
    if(nameValueMap.size() != other.nameValueMap.size())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1564093521 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2085885279 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2085885279;
        } //End block
        Iterator<String> li = this.nameValueMap.keySet().iterator();
        while
(li.hasNext())        
        {
            String key = (String) li.next();
            Collection nv1 = this.getNameValue(key);
            Collection nv2 = (Collection) other.nameValueMap.get(key);
    if(nv2 == null)            
            {
            boolean var68934A3E9455FA72420237EB05902327_1852359709 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1440860544 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1440860544;
            }
            else
    if(!nv2.equals(nv1))            
            {
            boolean var68934A3E9455FA72420237EB05902327_5801832 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_451705984 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_451705984;
            }
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_31587616 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1396514825 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1396514825;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.091 -0400", hash_original_method = "C612873C096C9BEC2FEAD8B66B09FEED", hash_generated_method = "F4CB696C5ECB18948492D0F786F0D8E6")
    public Object getValue(String name) {
        addTaint(name.getTaint());
        Collection nv = this.getNameValue(name.toLowerCase());
    if(nv != null)        
        {
Object var8CDC8D1FFB0B29D7089B99B596CC9F85_999811068 =         nv;
        var8CDC8D1FFB0B29D7089B99B596CC9F85_999811068.addTaint(taint);
        return var8CDC8D1FFB0B29D7089B99B596CC9F85_999811068;
        }
        else
        {
Object var540C13E9E156B687226421B24F2DF178_1741587176 =         null;
        var540C13E9E156B687226421B24F2DF178_1741587176.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1741587176;
        }
        // ---------- Original Method ----------
        //Collection nv = this.getNameValue(name.toLowerCase());
        //if (nv != null)
            //return nv;
        //else
            //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.091 -0400", hash_original_method = "3B6BB1718C2A9A54E5BA1FF364B56717", hash_generated_method = "8B647EEC0FF2548153B50D5FC28F50BF")
    public Collection getNameValue(String name) {
        addTaint(name.getTaint());
Collection var455A788153979E96E14570CFD1CFB4E6_1964438657 =         (Collection) this.nameValueMap.get(name.toLowerCase());
        var455A788153979E96E14570CFD1CFB4E6_1964438657.addTaint(taint);
        return var455A788153979E96E14570CFD1CFB4E6_1964438657;
        // ---------- Original Method ----------
        //return (Collection) this.nameValueMap.get(name.toLowerCase());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.091 -0400", hash_original_method = "D5BB760FEF0605F784761761BB05E75A", hash_generated_method = "89115B260690CD37C73AB8B46926620A")
    public boolean hasNameValue(String name) {
        addTaint(name.getTaint());
        boolean var6AD953012EFDFEF4A9A9FD4ED4B74DF1_1340585862 = (nameValueMap.containsKey(name.toLowerCase()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1310186245 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1310186245;
        // ---------- Original Method ----------
        //return nameValueMap.containsKey(name.toLowerCase());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.092 -0400", hash_original_method = "DB3F0BFFB6CE4D49FE300461E52C77CC", hash_generated_method = "E0119504C57FA04F05A4A4F1E558F64E")
    public boolean delete(String name) {
        addTaint(name.getTaint());
        String lcName = name.toLowerCase();
    if(this.nameValueMap.containsKey(lcName))        
        {
            this.nameValueMap.remove(lcName);
            boolean varB326B5062B2F0E69046810717534CB09_1506263980 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1091306120 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1091306120;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_1705889839 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_331208867 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_331208867;
        } //End block
        // ---------- Original Method ----------
        //String lcName = name.toLowerCase();
        //if (this.nameValueMap.containsKey(lcName)) {
            //this.nameValueMap.remove(lcName);
            //return true;
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.092 -0400", hash_original_method = "19FF4230E4AD609C94D0ED393241A96C", hash_generated_method = "6BB786540361C0ED732FCF3F8456603B")
    public Object clone() {
        DuplicateNameValueList retval = new DuplicateNameValueList();
        retval.setSeparator(this.separator);
        Iterator<NameValue> it = this.nameValueMap.values().iterator();
        while
(it.hasNext())        
        {
            retval.set((NameValue) ((NameValue) it.next()).clone());
        } //End block
Object varF9E19AD6135C970F387F77C6F3DE4477_590194642 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_590194642.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_590194642;
        // ---------- Original Method ----------
        //DuplicateNameValueList retval = new DuplicateNameValueList();
        //retval.setSeparator(this.separator);
        //Iterator<NameValue> it = this.nameValueMap.values().iterator();
        //while (it.hasNext()) {
            //retval.set((NameValue) ((NameValue) it.next()).clone());
        //}
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.092 -0400", hash_original_method = "FD05C240A769227CDB628211DF5EC32E", hash_generated_method = "95B962007330A458F36ADD94D954EF24")
    public Iterator<NameValue> iterator() {
Iterator<NameValue> var3CCF030E2580117B40A1C1EF98CF1C47_31807067 =         this.nameValueMap.values().iterator();
        var3CCF030E2580117B40A1C1EF98CF1C47_31807067.addTaint(taint);
        return var3CCF030E2580117B40A1C1EF98CF1C47_31807067;
        // ---------- Original Method ----------
        //return this.nameValueMap.values().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.093 -0400", hash_original_method = "3A38488A38C81B5FE756BBBB95D22DE2", hash_generated_method = "0560F53A39CE4F370F4569A5A3AD6B21")
    public Iterator<String> getNames() {
Iterator<String> varFE962324A4DFB062FF834823E440D647_348847667 =         this.nameValueMap.keySet().iterator();
        varFE962324A4DFB062FF834823E440D647_348847667.addTaint(taint);
        return varFE962324A4DFB062FF834823E440D647_348847667;
        // ---------- Original Method ----------
        //return this.nameValueMap.keySet().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.093 -0400", hash_original_method = "6D3851F46197204C176DAB6DC4EAB5DB", hash_generated_method = "309EBE3C5142B8ABF3D8C9C60A2B7586")
    public String getParameter(String name) {
        addTaint(name.getTaint());
        Object val = this.getValue(name);
    if(val == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1727576977 =         null;
        var540C13E9E156B687226421B24F2DF178_1727576977.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1727576977;
        }
    if(val instanceof GenericObject)        
        {
String varF1B6C72F38290E3B9280610078FC772A_1107440383 =         ((GenericObject) val).encode();
        varF1B6C72F38290E3B9280610078FC772A_1107440383.addTaint(taint);
        return varF1B6C72F38290E3B9280610078FC772A_1107440383;
        }
        else
        {
String var38570108501B3BE2AC163FA564B07985_1878771293 =         val.toString();
        var38570108501B3BE2AC163FA564B07985_1878771293.addTaint(taint);
        return var38570108501B3BE2AC163FA564B07985_1878771293;
        }
        // ---------- Original Method ----------
        //Object val = this.getValue(name);
        //if (val == null)
            //return null;
        //if (val instanceof GenericObject)
            //return ((GenericObject) val).encode();
        //else
            //return val.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.093 -0400", hash_original_method = "B40C6D0DEDA13F85BB68C572A20E397F", hash_generated_method = "0E3C4AF8B49E5DCB08329C4AB11AFFF8")
    public void clear() {
        nameValueMap.clear();
        // ---------- Original Method ----------
        //nameValueMap.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.094 -0400", hash_original_method = "A87A9771E4444067F01FCF3F6D8B907E", hash_generated_method = "9753120E1B7EB5FB5C88BBB3B0C32582")
    public boolean isEmpty() {
        boolean var66EDF94C9474C52F132B65CE8BDE5FAA_1643562667 = (this.nameValueMap.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_366938157 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_366938157;
        // ---------- Original Method ----------
        //return this.nameValueMap.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.094 -0400", hash_original_method = "3AC71B082E8AAC37EBD928C6A35A39AB", hash_generated_method = "3B5E2A70F15F4123325ACF8191C9F255")
    public NameValue put(String key, NameValue value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
NameValue var2B432BD1998424D6C81EB1582E4435AA_1223069233 =         (NameValue) this.nameValueMap.put(key, value);
        var2B432BD1998424D6C81EB1582E4435AA_1223069233.addTaint(taint);
        return var2B432BD1998424D6C81EB1582E4435AA_1223069233;
        // ---------- Original Method ----------
        //return (NameValue) this.nameValueMap.put(key, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.094 -0400", hash_original_method = "1975EE5F7D7766619160CC0D9D0851BB", hash_generated_method = "D24352D078EA751CFBC024E4FF4C28B2")
    public NameValue remove(Object key) {
        addTaint(key.getTaint());
NameValue var6D5B9855993E18BC4C470CBB87EC89C7_1603990612 =         (NameValue) this.nameValueMap.remove(key);
        var6D5B9855993E18BC4C470CBB87EC89C7_1603990612.addTaint(taint);
        return var6D5B9855993E18BC4C470CBB87EC89C7_1603990612;
        // ---------- Original Method ----------
        //return (NameValue) this.nameValueMap.remove(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.095 -0400", hash_original_method = "7BBCC8968D761DFCA7152F0BE4E82809", hash_generated_method = "8ED28A33AAAA0ED27F5EEF20F538405E")
    public int size() {
        int var16870F6CB26CD74A1A54B5A0588DA15C_1588312481 = (this.nameValueMap.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1699856455 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1699856455;
        // ---------- Original Method ----------
        //return this.nameValueMap.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.095 -0400", hash_original_method = "F30302CB3EB3055DF74F33593B8201EA", hash_generated_method = "47BF06F750686BBD85BABCC7A3B78E4B")
    public Collection<NameValue> values() {
Collection<NameValue> var0EAA2656FF6694E38E984612E9842F13_61394045 =         this.nameValueMap.values();
        var0EAA2656FF6694E38E984612E9842F13_61394045.addTaint(taint);
        return var0EAA2656FF6694E38E984612E9842F13_61394045;
        // ---------- Original Method ----------
        //return this.nameValueMap.values();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.095 -0400", hash_original_method = "4C24AE5D2C44E17C467B047C84E46484", hash_generated_method = "3B7BC930026746548C0CCEE84CA66C6A")
    public int hashCode() {
        int varA97A615DC1FDA241FE73BCB450CF12B9_234180803 = (this.nameValueMap.keySet().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1608483611 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1608483611;
        // ---------- Original Method ----------
        //return this.nameValueMap.keySet().hashCode();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.095 -0400", hash_original_field = "0ED15C20152326822E26443FE975E5C6", hash_generated_field = "549B3ABEAD7830A28E925E7D8255A93A")

    private static final long serialVersionUID = -5611332957903796952L;
}

