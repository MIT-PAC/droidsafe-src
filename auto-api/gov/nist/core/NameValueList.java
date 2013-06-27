package gov.nist.core;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.354 -0400", hash_original_field = "1792643415A657BEEC20CC7ECBCCD4B1", hash_generated_field = "EB935C097CDD69EAB431C97FAA415189")

    private Map<String,NameValue> hmap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.354 -0400", hash_original_field = "A0F0BC95016C862498BBAD29D1F4D9D4", hash_generated_field = "A55DB8D30D61AD070DC11E077713D1B8")

    private String separator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.355 -0400", hash_original_method = "E8FF7D679153D33DE114891B4F9D5A45", hash_generated_method = "336BD0E12DEBE109B27311EE1406982B")
    public  NameValueList() {
        this.separator = ";";
        this.hmap = new LinkedHashMap<String,NameValue>();
        // ---------- Original Method ----------
        //this.separator = ";";
        //this.hmap = new LinkedHashMap<String,NameValue>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.355 -0400", hash_original_method = "31A624E97D000A93AA89FEF53FE9BAB4", hash_generated_method = "227D445ACEA08A641066B5EDF61823FD")
    public  NameValueList(boolean sync) {
        this.separator = ";";
        this.hmap = new ConcurrentHashMap<String,NameValue>();
        this.hmap = new LinkedHashMap<String,NameValue>();
        addTaint(sync);
        // ---------- Original Method ----------
        //this.separator = ";";
        //if (sync)
            //this.hmap = new ConcurrentHashMap<String,NameValue>();
        //else
            //this.hmap = new LinkedHashMap<String,NameValue>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.357 -0400", hash_original_method = "45084252F3EC1C5D752F2E607BC4F59B", hash_generated_method = "87C291B29969431F03CD87D5C89B7360")
    public void setSeparator(String separator) {
        this.separator = separator;
        // ---------- Original Method ----------
        //this.separator = separator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.357 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "CEAF1E92B524A5248A2B243925122807")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1670931958 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1670931958 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1670931958.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1670931958;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.383 -0400", hash_original_method = "865D14C9D79B396183E2E3DA24E39568", hash_generated_method = "9CC29C8FC08EC3BCEC34FF180A56F017")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1305906356 = null; //Variable for return #1
        {
            boolean varE7AB5FCEA0FCF62ECE76D28899186A7A_506433964 = (!hmap.isEmpty());
            {
                Iterator<NameValue> iterator;
                iterator = hmap.values().iterator();
                {
                    boolean varA524DEFD7CC0C913305DE8790C40B8FE_1168291839 = (iterator.hasNext());
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
                                boolean varBA94060EAB38FC283ECB954DF4224C1E_1519228298 = (iterator.hasNext());
                                buffer.append(separator);
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1305906356 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1305906356.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1305906356;
        // ---------- Original Method ----------
        //if (!hmap.isEmpty()) {
            //Iterator<NameValue> iterator = hmap.values().iterator();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.384 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "9DFC56DF101E783E16218211253245BE")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_806350536 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_806350536 = this.encode();
        varB4EAC82CA7396A68D541C85D26508E83_806350536.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_806350536;
        // ---------- Original Method ----------
        //return this.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.384 -0400", hash_original_method = "541832A041A683842702BE4F440BB6F9", hash_generated_method = "8ECA9C99C953CFD721E8D0E0C290D068")
    public void set(NameValue nv) {
        this.hmap.put(nv.getName().toLowerCase(), nv);
        addTaint(nv.getTaint());
        // ---------- Original Method ----------
        //this.hmap.put(nv.getName().toLowerCase(), nv);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.384 -0400", hash_original_method = "728B9B3DC246366575180118914F1A29", hash_generated_method = "108A1C5034703CBD7B52987156D8CB2B")
    public void set(String name, Object value) {
        NameValue nameValue;
        nameValue = new NameValue(name, value);
        hmap.put(name.toLowerCase(), nameValue);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //NameValue nameValue = new NameValue(name, value);
        //hmap.put(name.toLowerCase(), nameValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.401 -0400", hash_original_method = "91A5AF22400C8AC862CBF8DA0CDC612B", hash_generated_method = "B6642CAC1BD38E8CF458F75CF9BF3510")
    public boolean equals(Object otherObject) {
        {
            boolean var5483DA14562500B9B202946E175C6ADB_356570186 = (!otherObject.getClass().equals(this.getClass()));
        } //End collapsed parenthetic
        NameValueList other;
        other = (NameValueList) otherObject;
        {
            boolean var2B94E0DAC2F3B2F020FEBCC7091FA58F_1252373934 = (hmap.size() != other.hmap.size());
        } //End collapsed parenthetic
        Iterator<String> li;
        li = this.hmap.keySet().iterator();
        {
            boolean varBC3D864DE8830EFC1098D2C2F456529D_296076482 = (li.hasNext());
            {
                String key;
                key = (String) li.next();
                NameValue nv1;
                nv1 = this.getNameValue(key);
                NameValue nv2;
                nv2 = (NameValue) other.hmap.get(key);
                {
                    boolean varC317F8E9B63A112DB5D5B271C8C64DB8_911452915 = (!nv2.equals(nv1));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(otherObject.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_580644615 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_580644615;
        // ---------- Original Method ----------
        //if ( otherObject == null ) {
            //return false;
        //}
        //if (!otherObject.getClass().equals(this.getClass())) {
            //return false;
        //}
        //NameValueList other = (NameValueList) otherObject;
        //if (hmap.size() != other.hmap.size()) {
            //return false;
        //}
        //Iterator<String> li = this.hmap.keySet().iterator();
        //while (li.hasNext()) {
            //String key = (String) li.next();
            //NameValue nv1 = this.getNameValue(key);
            //NameValue nv2 = (NameValue) other.hmap.get(key);
            //if (nv2 == null)
                //return false;
            //else if (!nv2.equals(nv1))
                //return false;
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.402 -0400", hash_original_method = "DE074F80660571F2D9A0EA59E951198A", hash_generated_method = "147F0A6D5B54A57E747F1CB45C41B012")
    public Object getValue(String name) {
        Object varB4EAC82CA7396A68D541C85D26508E83_994298145 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1162791961 = null; //Variable for return #2
        NameValue nv;
        nv = this.getNameValue(name.toLowerCase());
        varB4EAC82CA7396A68D541C85D26508E83_994298145 = nv.getValueAsObject();
        varB4EAC82CA7396A68D541C85D26508E83_1162791961 = null;
        addTaint(name.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_1284443421; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1284443421 = varB4EAC82CA7396A68D541C85D26508E83_994298145;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1284443421 = varB4EAC82CA7396A68D541C85D26508E83_1162791961;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1284443421.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1284443421;
        // ---------- Original Method ----------
        //NameValue nv = this.getNameValue(name.toLowerCase());
        //if (nv != null)
            //return nv.getValueAsObject();
        //else
            //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.403 -0400", hash_original_method = "5A90B099A8628E34F647DE9E37BC52D0", hash_generated_method = "1688E34C0097D92B50615B92E4C8B08A")
    public NameValue getNameValue(String name) {
        NameValue varB4EAC82CA7396A68D541C85D26508E83_1307893690 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1307893690 = (NameValue) this.hmap.get(name.toLowerCase());
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1307893690.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1307893690;
        // ---------- Original Method ----------
        //return (NameValue) this.hmap.get(name.toLowerCase());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.403 -0400", hash_original_method = "DB40CF4190456B2BE2224926B4D8156A", hash_generated_method = "44963442F20E1CC068D2A05D58C3CA34")
    public boolean hasNameValue(String name) {
        boolean var95354E3F5489DEAD152E96DDFED142A2_1826522139 = (hmap.containsKey(name.toLowerCase()));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1773058036 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1773058036;
        // ---------- Original Method ----------
        //return hmap.containsKey(name.toLowerCase());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.403 -0400", hash_original_method = "91B0980C21C7F267937CEFAA60D652AB", hash_generated_method = "38102E9FD1053CACE77240E5504B1261")
    public boolean delete(String name) {
        String lcName;
        lcName = name.toLowerCase();
        {
            boolean var148E369A265566D6BF02ACD75EFF4274_989805604 = (this.hmap.containsKey(lcName));
            {
                this.hmap.remove(lcName);
            } //End block
        } //End collapsed parenthetic
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_365924089 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_365924089;
        // ---------- Original Method ----------
        //String lcName = name.toLowerCase();
        //if (this.hmap.containsKey(lcName)) {
            //this.hmap.remove(lcName);
            //return true;
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.427 -0400", hash_original_method = "6F9503A91BCD71FF680044D2BE3EB547", hash_generated_method = "3201224B7FA780B6512723AF00DE4ABA")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_572810573 = null; //Variable for return #1
        NameValueList retval;
        retval = new NameValueList();
        retval.setSeparator(this.separator);
        Iterator<NameValue> it;
        it = this.hmap.values().iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_777147390 = (it.hasNext());
            {
                retval.set((NameValue) ((NameValue) it.next()).clone());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_572810573 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_572810573.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_572810573;
        // ---------- Original Method ----------
        //NameValueList retval = new NameValueList();
        //retval.setSeparator(this.separator);
        //Iterator<NameValue> it = this.hmap.values().iterator();
        //while (it.hasNext()) {
            //retval.set((NameValue) ((NameValue) it.next()).clone());
        //}
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.427 -0400", hash_original_method = "3E6F4B689378892245F121C3B2A70863", hash_generated_method = "9E6206280AA16538A0BD07DE137DC655")
    public int size() {
        int varAD074C75E3799B7E0759F76B31D68F7C_1697836094 = (this.hmap.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1097165625 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1097165625;
        // ---------- Original Method ----------
        //return this.hmap.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.427 -0400", hash_original_method = "9CD772E1CB5E6BE1ED1982B78A84FA1B", hash_generated_method = "E811129E01B38E88210A807A8834E397")
    public boolean isEmpty() {
        boolean var39B0CF3B25DAF9AA86C553FF8CBBE59D_71330331 = (hmap.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_296514561 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_296514561;
        // ---------- Original Method ----------
        //return hmap.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.428 -0400", hash_original_method = "F37BBAD929816040B3EA007E6DF28502", hash_generated_method = "FD7CB6253643B30C6066E48551FC7B46")
    public Iterator<NameValue> iterator() {
        Iterator<NameValue> varB4EAC82CA7396A68D541C85D26508E83_1873998942 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1873998942 = this.hmap.values().iterator();
        varB4EAC82CA7396A68D541C85D26508E83_1873998942.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1873998942;
        // ---------- Original Method ----------
        //return this.hmap.values().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.428 -0400", hash_original_method = "7A59F5DB1186413E79C951C76908BFDC", hash_generated_method = "447A00677B2372514E3AE6303CABC7CE")
    public Iterator<String> getNames() {
        Iterator<String> varB4EAC82CA7396A68D541C85D26508E83_91060287 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_91060287 = this.hmap.keySet().iterator();
        varB4EAC82CA7396A68D541C85D26508E83_91060287.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_91060287;
        // ---------- Original Method ----------
        //return this.hmap.keySet().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.443 -0400", hash_original_method = "6D3851F46197204C176DAB6DC4EAB5DB", hash_generated_method = "4C655496E6CEF5F6787851A1414D17E4")
    public String getParameter(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_1668653896 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_596291643 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_410993426 = null; //Variable for return #3
        Object val;
        val = this.getValue(name);
        varB4EAC82CA7396A68D541C85D26508E83_1668653896 = null;
        varB4EAC82CA7396A68D541C85D26508E83_596291643 = ((GenericObject) val).encode();
        varB4EAC82CA7396A68D541C85D26508E83_410993426 = val.toString();
        addTaint(name.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1665806755; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1665806755 = varB4EAC82CA7396A68D541C85D26508E83_1668653896;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1665806755 = varB4EAC82CA7396A68D541C85D26508E83_596291643;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1665806755 = varB4EAC82CA7396A68D541C85D26508E83_410993426;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1665806755.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1665806755;
        // ---------- Original Method ----------
        //Object val = this.getValue(name);
        //if (val == null)
            //return null;
        //if (val instanceof GenericObject)
            //return ((GenericObject) val).encode();
        //else
            //return val.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.444 -0400", hash_original_method = "980179408BF501109227F08D5C9216B1", hash_generated_method = "D57897A75D7D199B0F1407488666631F")
    public void clear() {
        this.hmap.clear();
        // ---------- Original Method ----------
        //this.hmap.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.444 -0400", hash_original_method = "2E0F75BA6AFD5C18A55AE3B632F0C375", hash_generated_method = "3D81A49CC5138A9BAD57AE3D59300AE3")
    public boolean containsKey(Object key) {
        boolean varA98C33CD2477BB9F9D0B2159708FBF49_1404660550 = (this.hmap.containsKey(key.toString().toLowerCase()));
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1276246173 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1276246173;
        // ---------- Original Method ----------
        //return this.hmap.containsKey(key.toString().toLowerCase());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.444 -0400", hash_original_method = "A6EA0419C0087EA83C0DBCC271DA2735", hash_generated_method = "F1C09FD4F0F3888B755C9EA8D4E5757E")
    public boolean containsValue(Object value) {
        boolean var315CB0777C99FCEC46C74AF0C2970AA7_795082038 = (this.hmap.containsValue(value));
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_224616053 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_224616053;
        // ---------- Original Method ----------
        //return this.hmap.containsValue(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.445 -0400", hash_original_method = "B4FF19B42F00873A6D908667D4FF7E33", hash_generated_method = "A2BF09F38A7AD35C50BD2E7D558B6747")
    public Set<java.util.Map.Entry<String, NameValue>> entrySet() {
        Set<java.util.Map.Entry<String, NameValue>> varB4EAC82CA7396A68D541C85D26508E83_63420839 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_63420839 = this.hmap.entrySet();
        varB4EAC82CA7396A68D541C85D26508E83_63420839.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_63420839;
        // ---------- Original Method ----------
        //return this.hmap.entrySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.459 -0400", hash_original_method = "EA67EE9A45F5352AADEB9693E72F1050", hash_generated_method = "2CCFF4673B1DF7BF7336F1E7A74BBB53")
    public NameValue get(Object key) {
        NameValue varB4EAC82CA7396A68D541C85D26508E83_1015350775 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1015350775 = this.hmap.get(key.toString().toLowerCase());
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1015350775.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1015350775;
        // ---------- Original Method ----------
        //return this.hmap.get(key.toString().toLowerCase());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.460 -0400", hash_original_method = "EB227B4CB4A434E80044A70A11CCF2F7", hash_generated_method = "749E1100BB1AB760F4FB091CD4195EF1")
    public Set<String> keySet() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1660381489 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1660381489 = this.hmap.keySet();
        varB4EAC82CA7396A68D541C85D26508E83_1660381489.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1660381489;
        // ---------- Original Method ----------
        //return this.hmap.keySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.460 -0400", hash_original_method = "35750F73219F56C1FC4F989AFDC72835", hash_generated_method = "C2FB322C2CC87BD57BBD09000AE6A36E")
    public NameValue put(String name, NameValue nameValue) {
        NameValue varB4EAC82CA7396A68D541C85D26508E83_1177449900 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1177449900 = this.hmap.put(name, nameValue);
        addTaint(name.getTaint());
        addTaint(nameValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1177449900.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1177449900;
        // ---------- Original Method ----------
        //return this.hmap.put(name, nameValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.460 -0400", hash_original_method = "E36B216223163EA26215959E10A918CA", hash_generated_method = "98A6D3DF2D66B7EDC8DB77F3BEEC0851")
    public void putAll(Map<? extends String, ? extends NameValue> map) {
        this.hmap.putAll(map);
        addTaint(map.getTaint());
        // ---------- Original Method ----------
        //this.hmap.putAll(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.473 -0400", hash_original_method = "790110009BF426B36394178253C0659C", hash_generated_method = "82A24B847656260F1939E897F9939F72")
    public NameValue remove(Object key) {
        NameValue varB4EAC82CA7396A68D541C85D26508E83_1038700840 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1038700840 = this.hmap.remove(key.toString().toLowerCase());
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1038700840.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1038700840;
        // ---------- Original Method ----------
        //return this.hmap.remove(key.toString().toLowerCase());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.473 -0400", hash_original_method = "979875D580378EC87CDE1564DB1000BC", hash_generated_method = "C643F51F95DD790A5004DB45676F2616")
    public Collection<NameValue> values() {
        Collection<NameValue> varB4EAC82CA7396A68D541C85D26508E83_1008205694 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1008205694 = this.hmap.values();
        varB4EAC82CA7396A68D541C85D26508E83_1008205694.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1008205694;
        // ---------- Original Method ----------
        //return this.hmap.values();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.474 -0400", hash_original_method = "2A0022C30F51CA39DC1594F13A7B2530", hash_generated_method = "60E919AF869EBADC355314EE34508BAB")
    @Override
    public int hashCode() {
        int var70DE47DDDCE2E5DB9367AADB33D33681_1403925077 = (this.hmap.keySet().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_516664371 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_516664371;
        // ---------- Original Method ----------
        //return this.hmap.keySet().hashCode();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:28.474 -0400", hash_original_field = "E5D78D1B5C3BACA3AFF8BA02AB02159E", hash_generated_field = "6B11FE2C5DCA0ECAEBAF973A6A730CE1")

    private static long serialVersionUID = -6998271876574260243L;
}

