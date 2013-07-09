package gov.nist.core;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.concurrent.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class NameValueList implements Serializable, Cloneable, Map<String,NameValue> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.805 -0400", hash_original_field = "1792643415A657BEEC20CC7ECBCCD4B1", hash_generated_field = "EB935C097CDD69EAB431C97FAA415189")

    private Map<String,NameValue> hmap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.805 -0400", hash_original_field = "A0F0BC95016C862498BBAD29D1F4D9D4", hash_generated_field = "A55DB8D30D61AD070DC11E077713D1B8")

    private String separator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.806 -0400", hash_original_method = "E8FF7D679153D33DE114891B4F9D5A45", hash_generated_method = "336BD0E12DEBE109B27311EE1406982B")
    public  NameValueList() {
        this.separator = ";";
        this.hmap = new LinkedHashMap<String,NameValue>();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.806 -0400", hash_original_method = "31A624E97D000A93AA89FEF53FE9BAB4", hash_generated_method = "227D445ACEA08A641066B5EDF61823FD")
    public  NameValueList(boolean sync) {
        this.separator = ";";
        this.hmap = new ConcurrentHashMap<String,NameValue>();
        this.hmap = new LinkedHashMap<String,NameValue>();
        addTaint(sync);
        
        
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.806 -0400", hash_original_method = "45084252F3EC1C5D752F2E607BC4F59B", hash_generated_method = "87C291B29969431F03CD87D5C89B7360")
    public void setSeparator(String separator) {
        this.separator = separator;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.807 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "E208F85095CAF8BD39B23A332AAB4812")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_998562786 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_998562786 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_998562786.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_998562786;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.807 -0400", hash_original_method = "865D14C9D79B396183E2E3DA24E39568", hash_generated_method = "AE4C0EAE8BE44640AF0851B6EE3E8798")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1650071917 = null; 
        {
            boolean varE7AB5FCEA0FCF62ECE76D28899186A7A_1590874391 = (!hmap.isEmpty());
            {
                Iterator<NameValue> iterator = hmap.values().iterator();
                {
                    boolean varA524DEFD7CC0C913305DE8790C40B8FE_1187072182 = (iterator.hasNext());
                    {
                        {
                            Object obj = iterator.next();
                            {
                                GenericObject gobj = (GenericObject) obj;
                                gobj.encode(buffer);
                            } 
                            {
                                buffer.append(obj.toString());
                            } 
                            {
                                boolean varBA94060EAB38FC283ECB954DF4224C1E_91484606 = (iterator.hasNext());
                                buffer.append(separator);
                            } 
                        } 
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1650071917 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1650071917.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1650071917;
        
        
            
            
                
                    
                    
                        
                        
                    
                        
                    
                    
                        
                    
                        
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.808 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "6FDC325E21726404F461B7D67F0DC379")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_306619450 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_306619450 = this.encode();
        varB4EAC82CA7396A68D541C85D26508E83_306619450.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_306619450;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.808 -0400", hash_original_method = "541832A041A683842702BE4F440BB6F9", hash_generated_method = "8ECA9C99C953CFD721E8D0E0C290D068")
    public void set(NameValue nv) {
        this.hmap.put(nv.getName().toLowerCase(), nv);
        addTaint(nv.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.808 -0400", hash_original_method = "728B9B3DC246366575180118914F1A29", hash_generated_method = "9CE5EB5DADB211B83468624082C2D42B")
    public void set(String name, Object value) {
        NameValue nameValue = new NameValue(name, value);
        hmap.put(name.toLowerCase(), nameValue);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.809 -0400", hash_original_method = "91A5AF22400C8AC862CBF8DA0CDC612B", hash_generated_method = "6EF2AEF28F4F1E080F4518C033881641")
    public boolean equals(Object otherObject) {
        {
            boolean var5483DA14562500B9B202946E175C6ADB_1111181837 = (!otherObject.getClass().equals(this.getClass()));
        } 
        NameValueList other = (NameValueList) otherObject;
        {
            boolean var2B94E0DAC2F3B2F020FEBCC7091FA58F_1303249960 = (hmap.size() != other.hmap.size());
        } 
        Iterator<String> li = this.hmap.keySet().iterator();
        {
            boolean varBC3D864DE8830EFC1098D2C2F456529D_2043461195 = (li.hasNext());
            {
                String key = (String) li.next();
                NameValue nv1 = this.getNameValue(key);
                NameValue nv2 = (NameValue) other.hmap.get(key);
                {
                    boolean varC317F8E9B63A112DB5D5B271C8C64DB8_1736590178 = (!nv2.equals(nv1));
                } 
            } 
        } 
        addTaint(otherObject.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1699471907 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1699471907;
        
        
            
        
        
            
        
        
        
            
        
        
        
            
            
            
            
                
            
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.810 -0400", hash_original_method = "DE074F80660571F2D9A0EA59E951198A", hash_generated_method = "694F50C670999AD39662C87751268433")
    public Object getValue(String name) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1921163386 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1922112197 = null; 
        NameValue nv = this.getNameValue(name.toLowerCase());
        varB4EAC82CA7396A68D541C85D26508E83_1921163386 = nv.getValueAsObject();
        varB4EAC82CA7396A68D541C85D26508E83_1922112197 = null;
        addTaint(name.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_1799387597; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1799387597 = varB4EAC82CA7396A68D541C85D26508E83_1921163386;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1799387597 = varB4EAC82CA7396A68D541C85D26508E83_1922112197;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1799387597.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1799387597;
        
        
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.812 -0400", hash_original_method = "5A90B099A8628E34F647DE9E37BC52D0", hash_generated_method = "080096094EB78721691665C680F6CFA1")
    public NameValue getNameValue(String name) {
        NameValue varB4EAC82CA7396A68D541C85D26508E83_1919694719 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1919694719 = (NameValue) this.hmap.get(name.toLowerCase());
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1919694719.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1919694719;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.814 -0400", hash_original_method = "DB40CF4190456B2BE2224926B4D8156A", hash_generated_method = "AE8723E0899EE740776D8043DC7A6813")
    public boolean hasNameValue(String name) {
        boolean var95354E3F5489DEAD152E96DDFED142A2_945550649 = (hmap.containsKey(name.toLowerCase()));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_520217407 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_520217407;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.815 -0400", hash_original_method = "91B0980C21C7F267937CEFAA60D652AB", hash_generated_method = "44632B48D74015EB936E290F3277159D")
    public boolean delete(String name) {
        String lcName = name.toLowerCase();
        {
            boolean var148E369A265566D6BF02ACD75EFF4274_254819571 = (this.hmap.containsKey(lcName));
            {
                this.hmap.remove(lcName);
            } 
        } 
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_961815429 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_961815429;
        
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.817 -0400", hash_original_method = "6F9503A91BCD71FF680044D2BE3EB547", hash_generated_method = "1A97E0EB585703280F8FB798E009D6DC")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_741323637 = null; 
        NameValueList retval = new NameValueList();
        retval.setSeparator(this.separator);
        Iterator<NameValue> it = this.hmap.values().iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_2036168009 = (it.hasNext());
            {
                retval.set((NameValue) ((NameValue) it.next()).clone());
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_741323637 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_741323637.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_741323637;
        
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.818 -0400", hash_original_method = "3E6F4B689378892245F121C3B2A70863", hash_generated_method = "CC38C45DB1C835B3EA8D3776C189C3BD")
    public int size() {
        int varAD074C75E3799B7E0759F76B31D68F7C_352585676 = (this.hmap.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1601540335 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1601540335;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.818 -0400", hash_original_method = "9CD772E1CB5E6BE1ED1982B78A84FA1B", hash_generated_method = "10F2BC171194CC58BEB889DFC5258C4E")
    public boolean isEmpty() {
        boolean var39B0CF3B25DAF9AA86C553FF8CBBE59D_1515398031 = (hmap.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1707363290 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1707363290;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.819 -0400", hash_original_method = "F37BBAD929816040B3EA007E6DF28502", hash_generated_method = "1110E59F4C72A84E7AF80FAE82771A8D")
    public Iterator<NameValue> iterator() {
        Iterator<NameValue> varB4EAC82CA7396A68D541C85D26508E83_1968876876 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1968876876 = this.hmap.values().iterator();
        varB4EAC82CA7396A68D541C85D26508E83_1968876876.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1968876876;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.820 -0400", hash_original_method = "7A59F5DB1186413E79C951C76908BFDC", hash_generated_method = "4E3A6F27682FAE382AD3E25B8353F28A")
    public Iterator<String> getNames() {
        Iterator<String> varB4EAC82CA7396A68D541C85D26508E83_1679445920 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1679445920 = this.hmap.keySet().iterator();
        varB4EAC82CA7396A68D541C85D26508E83_1679445920.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1679445920;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.822 -0400", hash_original_method = "6D3851F46197204C176DAB6DC4EAB5DB", hash_generated_method = "116F054C3B40784D9F293D8514B191DD")
    public String getParameter(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_1269110096 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_427069233 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_468983599 = null; 
        Object val = this.getValue(name);
        varB4EAC82CA7396A68D541C85D26508E83_1269110096 = null;
        varB4EAC82CA7396A68D541C85D26508E83_427069233 = ((GenericObject) val).encode();
        varB4EAC82CA7396A68D541C85D26508E83_468983599 = val.toString();
        addTaint(name.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1789966528; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1789966528 = varB4EAC82CA7396A68D541C85D26508E83_1269110096;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1789966528 = varB4EAC82CA7396A68D541C85D26508E83_427069233;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1789966528 = varB4EAC82CA7396A68D541C85D26508E83_468983599;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1789966528.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1789966528;
        
        
        
            
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.823 -0400", hash_original_method = "980179408BF501109227F08D5C9216B1", hash_generated_method = "D57897A75D7D199B0F1407488666631F")
    public void clear() {
        this.hmap.clear();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.823 -0400", hash_original_method = "2E0F75BA6AFD5C18A55AE3B632F0C375", hash_generated_method = "073C979856D378CEF0335FDABEC04087")
    public boolean containsKey(Object key) {
        boolean varA98C33CD2477BB9F9D0B2159708FBF49_1948191376 = (this.hmap.containsKey(key.toString().toLowerCase()));
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1633975810 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1633975810;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.824 -0400", hash_original_method = "A6EA0419C0087EA83C0DBCC271DA2735", hash_generated_method = "7FDD01DA1A2DAED0CC25E94EB008E8A3")
    public boolean containsValue(Object value) {
        boolean var315CB0777C99FCEC46C74AF0C2970AA7_475669539 = (this.hmap.containsValue(value));
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1594787517 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1594787517;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.825 -0400", hash_original_method = "B4FF19B42F00873A6D908667D4FF7E33", hash_generated_method = "F52AE0D0BAAC9365CA0EC0E5CF5D4490")
    public Set<java.util.Map.Entry<String, NameValue>> entrySet() {
        Set<java.util.Map.Entry<String, NameValue>> varB4EAC82CA7396A68D541C85D26508E83_1214793975 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1214793975 = this.hmap.entrySet();
        varB4EAC82CA7396A68D541C85D26508E83_1214793975.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1214793975;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.825 -0400", hash_original_method = "EA67EE9A45F5352AADEB9693E72F1050", hash_generated_method = "110B722F01DC40CC9A9B5D179CDF4BB7")
    public NameValue get(Object key) {
        NameValue varB4EAC82CA7396A68D541C85D26508E83_936061180 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_936061180 = this.hmap.get(key.toString().toLowerCase());
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_936061180.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_936061180;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.826 -0400", hash_original_method = "EB227B4CB4A434E80044A70A11CCF2F7", hash_generated_method = "2BB23238BFDE10439B87A7185618B091")
    public Set<String> keySet() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_982585140 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_982585140 = this.hmap.keySet();
        varB4EAC82CA7396A68D541C85D26508E83_982585140.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_982585140;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.826 -0400", hash_original_method = "35750F73219F56C1FC4F989AFDC72835", hash_generated_method = "5881D06B5B7373435473C78C056D00EF")
    public NameValue put(String name, NameValue nameValue) {
        NameValue varB4EAC82CA7396A68D541C85D26508E83_654934114 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_654934114 = this.hmap.put(name, nameValue);
        addTaint(name.getTaint());
        addTaint(nameValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_654934114.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_654934114;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.827 -0400", hash_original_method = "E36B216223163EA26215959E10A918CA", hash_generated_method = "98A6D3DF2D66B7EDC8DB77F3BEEC0851")
    public void putAll(Map<? extends String, ? extends NameValue> map) {
        this.hmap.putAll(map);
        addTaint(map.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.827 -0400", hash_original_method = "790110009BF426B36394178253C0659C", hash_generated_method = "CBBCF7361988F160AFB8489906BEA06D")
    public NameValue remove(Object key) {
        NameValue varB4EAC82CA7396A68D541C85D26508E83_1315686717 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1315686717 = this.hmap.remove(key.toString().toLowerCase());
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1315686717.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1315686717;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.827 -0400", hash_original_method = "979875D580378EC87CDE1564DB1000BC", hash_generated_method = "52D4E46FE745F31A65DC24F846531AC5")
    public Collection<NameValue> values() {
        Collection<NameValue> varB4EAC82CA7396A68D541C85D26508E83_801268697 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_801268697 = this.hmap.values();
        varB4EAC82CA7396A68D541C85D26508E83_801268697.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_801268697;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.828 -0400", hash_original_method = "2A0022C30F51CA39DC1594F13A7B2530", hash_generated_method = "A25A246C6E7FB72D2A4CD6F16B8FE9F8")
    @Override
    public int hashCode() {
        int var70DE47DDDCE2E5DB9367AADB33D33681_788625152 = (this.hmap.keySet().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_45748395 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_45748395;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.828 -0400", hash_original_field = "E5D78D1B5C3BACA3AFF8BA02AB02159E", hash_generated_field = "6139D38F46B665D29EA8807167945764")

    private static final long serialVersionUID = -6998271876574260243L;
}

