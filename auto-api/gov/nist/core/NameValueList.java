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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.762 -0400", hash_original_field = "1792643415A657BEEC20CC7ECBCCD4B1", hash_generated_field = "EB935C097CDD69EAB431C97FAA415189")

    private Map<String,NameValue> hmap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.763 -0400", hash_original_field = "A0F0BC95016C862498BBAD29D1F4D9D4", hash_generated_field = "A55DB8D30D61AD070DC11E077713D1B8")

    private String separator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.768 -0400", hash_original_method = "E8FF7D679153D33DE114891B4F9D5A45", hash_generated_method = "336BD0E12DEBE109B27311EE1406982B")
    public  NameValueList() {
        this.separator = ";";
        this.hmap = new LinkedHashMap<String,NameValue>();
        // ---------- Original Method ----------
        //this.separator = ";";
        //this.hmap = new LinkedHashMap<String,NameValue>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.770 -0400", hash_original_method = "31A624E97D000A93AA89FEF53FE9BAB4", hash_generated_method = "227D445ACEA08A641066B5EDF61823FD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.772 -0400", hash_original_method = "45084252F3EC1C5D752F2E607BC4F59B", hash_generated_method = "87C291B29969431F03CD87D5C89B7360")
    public void setSeparator(String separator) {
        this.separator = separator;
        // ---------- Original Method ----------
        //this.separator = separator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.780 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "261C1BBF6EFF55386F05AC5D185D6F4D")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1037987823 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1037987823 = encode(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1037987823.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1037987823;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.783 -0400", hash_original_method = "865D14C9D79B396183E2E3DA24E39568", hash_generated_method = "84E660D4B2D4026FFFEB8DD2D18889A8")
    public StringBuffer encode(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_519614105 = null; //Variable for return #1
        {
            boolean varE7AB5FCEA0FCF62ECE76D28899186A7A_211662402 = (!hmap.isEmpty());
            {
                Iterator<NameValue> iterator;
                iterator = hmap.values().iterator();
                {
                    boolean varA524DEFD7CC0C913305DE8790C40B8FE_498773876 = (iterator.hasNext());
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
                                boolean varBA94060EAB38FC283ECB954DF4224C1E_204095049 = (iterator.hasNext());
                                buffer.append(separator);
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_519614105 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_519614105.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_519614105;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.793 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "5B17F6601C318589DBD5663BC6AB2A96")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1968779809 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1968779809 = this.encode();
        varB4EAC82CA7396A68D541C85D26508E83_1968779809.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1968779809;
        // ---------- Original Method ----------
        //return this.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.793 -0400", hash_original_method = "541832A041A683842702BE4F440BB6F9", hash_generated_method = "8ECA9C99C953CFD721E8D0E0C290D068")
    public void set(NameValue nv) {
        this.hmap.put(nv.getName().toLowerCase(), nv);
        addTaint(nv.getTaint());
        // ---------- Original Method ----------
        //this.hmap.put(nv.getName().toLowerCase(), nv);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.795 -0400", hash_original_method = "728B9B3DC246366575180118914F1A29", hash_generated_method = "108A1C5034703CBD7B52987156D8CB2B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.796 -0400", hash_original_method = "91A5AF22400C8AC862CBF8DA0CDC612B", hash_generated_method = "6BBB020E6D8C66889AABD60787EE09AE")
    public boolean equals(Object otherObject) {
        {
            boolean var5483DA14562500B9B202946E175C6ADB_1677473319 = (!otherObject.getClass().equals(this.getClass()));
        } //End collapsed parenthetic
        NameValueList other;
        other = (NameValueList) otherObject;
        {
            boolean var2B94E0DAC2F3B2F020FEBCC7091FA58F_170572006 = (hmap.size() != other.hmap.size());
        } //End collapsed parenthetic
        Iterator<String> li;
        li = this.hmap.keySet().iterator();
        {
            boolean varBC3D864DE8830EFC1098D2C2F456529D_2060611057 = (li.hasNext());
            {
                String key;
                key = (String) li.next();
                NameValue nv1;
                nv1 = this.getNameValue(key);
                NameValue nv2;
                nv2 = (NameValue) other.hmap.get(key);
                {
                    boolean varC317F8E9B63A112DB5D5B271C8C64DB8_1937077618 = (!nv2.equals(nv1));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(otherObject.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_16486890 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_16486890;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.796 -0400", hash_original_method = "DE074F80660571F2D9A0EA59E951198A", hash_generated_method = "2FF05BBE4448498A6CDC4DB03F1B3601")
    public Object getValue(String name) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1789699761 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1461530901 = null; //Variable for return #2
        NameValue nv;
        nv = this.getNameValue(name.toLowerCase());
        varB4EAC82CA7396A68D541C85D26508E83_1789699761 = nv.getValueAsObject();
        varB4EAC82CA7396A68D541C85D26508E83_1461530901 = null;
        addTaint(name.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_2026341475; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2026341475 = varB4EAC82CA7396A68D541C85D26508E83_1789699761;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2026341475 = varB4EAC82CA7396A68D541C85D26508E83_1461530901;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2026341475.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2026341475;
        // ---------- Original Method ----------
        //NameValue nv = this.getNameValue(name.toLowerCase());
        //if (nv != null)
            //return nv.getValueAsObject();
        //else
            //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.798 -0400", hash_original_method = "5A90B099A8628E34F647DE9E37BC52D0", hash_generated_method = "06A03E046BA3A71839860A44C3F2E896")
    public NameValue getNameValue(String name) {
        NameValue varB4EAC82CA7396A68D541C85D26508E83_214300145 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_214300145 = (NameValue) this.hmap.get(name.toLowerCase());
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_214300145.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_214300145;
        // ---------- Original Method ----------
        //return (NameValue) this.hmap.get(name.toLowerCase());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.801 -0400", hash_original_method = "DB40CF4190456B2BE2224926B4D8156A", hash_generated_method = "29DD29C34E40C203EBCC054D543F6AE0")
    public boolean hasNameValue(String name) {
        boolean var95354E3F5489DEAD152E96DDFED142A2_932725155 = (hmap.containsKey(name.toLowerCase()));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1551223577 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1551223577;
        // ---------- Original Method ----------
        //return hmap.containsKey(name.toLowerCase());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.801 -0400", hash_original_method = "91B0980C21C7F267937CEFAA60D652AB", hash_generated_method = "F9C6E9C928B66B0013F04C7F240FDEDD")
    public boolean delete(String name) {
        String lcName;
        lcName = name.toLowerCase();
        {
            boolean var148E369A265566D6BF02ACD75EFF4274_122919265 = (this.hmap.containsKey(lcName));
            {
                this.hmap.remove(lcName);
            } //End block
        } //End collapsed parenthetic
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_301220418 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_301220418;
        // ---------- Original Method ----------
        //String lcName = name.toLowerCase();
        //if (this.hmap.containsKey(lcName)) {
            //this.hmap.remove(lcName);
            //return true;
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.803 -0400", hash_original_method = "6F9503A91BCD71FF680044D2BE3EB547", hash_generated_method = "38BE845499D137D6796254EED40B0EA6")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_517987607 = null; //Variable for return #1
        NameValueList retval;
        retval = new NameValueList();
        retval.setSeparator(this.separator);
        Iterator<NameValue> it;
        it = this.hmap.values().iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1489912826 = (it.hasNext());
            {
                retval.set((NameValue) ((NameValue) it.next()).clone());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_517987607 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_517987607.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_517987607;
        // ---------- Original Method ----------
        //NameValueList retval = new NameValueList();
        //retval.setSeparator(this.separator);
        //Iterator<NameValue> it = this.hmap.values().iterator();
        //while (it.hasNext()) {
            //retval.set((NameValue) ((NameValue) it.next()).clone());
        //}
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.803 -0400", hash_original_method = "3E6F4B689378892245F121C3B2A70863", hash_generated_method = "DAFBDA3D2C24458FAB99DB61A70FCC62")
    public int size() {
        int varAD074C75E3799B7E0759F76B31D68F7C_738481073 = (this.hmap.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_398385470 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_398385470;
        // ---------- Original Method ----------
        //return this.hmap.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.803 -0400", hash_original_method = "9CD772E1CB5E6BE1ED1982B78A84FA1B", hash_generated_method = "EEB779338869A6B90698D440FB7E0AF9")
    public boolean isEmpty() {
        boolean var39B0CF3B25DAF9AA86C553FF8CBBE59D_2010875507 = (hmap.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_354794367 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_354794367;
        // ---------- Original Method ----------
        //return hmap.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.814 -0400", hash_original_method = "F37BBAD929816040B3EA007E6DF28502", hash_generated_method = "AB428E5DA80D319E4808EF39876CAEB8")
    public Iterator<NameValue> iterator() {
        Iterator<NameValue> varB4EAC82CA7396A68D541C85D26508E83_854571142 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_854571142 = this.hmap.values().iterator();
        varB4EAC82CA7396A68D541C85D26508E83_854571142.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_854571142;
        // ---------- Original Method ----------
        //return this.hmap.values().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.814 -0400", hash_original_method = "7A59F5DB1186413E79C951C76908BFDC", hash_generated_method = "E2CB6CCD667F57FA9CD9B843A8FF44B7")
    public Iterator<String> getNames() {
        Iterator<String> varB4EAC82CA7396A68D541C85D26508E83_1061391672 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1061391672 = this.hmap.keySet().iterator();
        varB4EAC82CA7396A68D541C85D26508E83_1061391672.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1061391672;
        // ---------- Original Method ----------
        //return this.hmap.keySet().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.815 -0400", hash_original_method = "6D3851F46197204C176DAB6DC4EAB5DB", hash_generated_method = "63B983363C6F12B6296F879B398F4450")
    public String getParameter(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_1953559485 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1830902722 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_10667376 = null; //Variable for return #3
        Object val;
        val = this.getValue(name);
        varB4EAC82CA7396A68D541C85D26508E83_1953559485 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1830902722 = ((GenericObject) val).encode();
        varB4EAC82CA7396A68D541C85D26508E83_10667376 = val.toString();
        addTaint(name.getTaint());
        String varA7E53CE21691AB073D9660D615818899_192330596; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_192330596 = varB4EAC82CA7396A68D541C85D26508E83_1953559485;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_192330596 = varB4EAC82CA7396A68D541C85D26508E83_1830902722;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_192330596 = varB4EAC82CA7396A68D541C85D26508E83_10667376;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_192330596.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_192330596;
        // ---------- Original Method ----------
        //Object val = this.getValue(name);
        //if (val == null)
            //return null;
        //if (val instanceof GenericObject)
            //return ((GenericObject) val).encode();
        //else
            //return val.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.815 -0400", hash_original_method = "980179408BF501109227F08D5C9216B1", hash_generated_method = "D57897A75D7D199B0F1407488666631F")
    public void clear() {
        this.hmap.clear();
        // ---------- Original Method ----------
        //this.hmap.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.816 -0400", hash_original_method = "2E0F75BA6AFD5C18A55AE3B632F0C375", hash_generated_method = "F0F6D058CF62D0A939EC66C8C90A9881")
    public boolean containsKey(Object key) {
        boolean varA98C33CD2477BB9F9D0B2159708FBF49_1732847601 = (this.hmap.containsKey(key.toString().toLowerCase()));
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_258685515 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_258685515;
        // ---------- Original Method ----------
        //return this.hmap.containsKey(key.toString().toLowerCase());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.821 -0400", hash_original_method = "A6EA0419C0087EA83C0DBCC271DA2735", hash_generated_method = "919446443D18770110D49C3205060982")
    public boolean containsValue(Object value) {
        boolean var315CB0777C99FCEC46C74AF0C2970AA7_745667716 = (this.hmap.containsValue(value));
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_758796620 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_758796620;
        // ---------- Original Method ----------
        //return this.hmap.containsValue(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.822 -0400", hash_original_method = "B4FF19B42F00873A6D908667D4FF7E33", hash_generated_method = "249E0381C497A2F32EF2EA16012B8409")
    public Set<java.util.Map.Entry<String, NameValue>> entrySet() {
        Set<java.util.Map.Entry<String, NameValue>> varB4EAC82CA7396A68D541C85D26508E83_36217363 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_36217363 = this.hmap.entrySet();
        varB4EAC82CA7396A68D541C85D26508E83_36217363.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_36217363;
        // ---------- Original Method ----------
        //return this.hmap.entrySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.823 -0400", hash_original_method = "EA67EE9A45F5352AADEB9693E72F1050", hash_generated_method = "8F1056F6924C73938011DDE8D2E29945")
    public NameValue get(Object key) {
        NameValue varB4EAC82CA7396A68D541C85D26508E83_1932223932 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1932223932 = this.hmap.get(key.toString().toLowerCase());
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1932223932.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1932223932;
        // ---------- Original Method ----------
        //return this.hmap.get(key.toString().toLowerCase());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.830 -0400", hash_original_method = "EB227B4CB4A434E80044A70A11CCF2F7", hash_generated_method = "59657900D2EF285EC4BB5F777EFF5749")
    public Set<String> keySet() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1051408263 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1051408263 = this.hmap.keySet();
        varB4EAC82CA7396A68D541C85D26508E83_1051408263.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1051408263;
        // ---------- Original Method ----------
        //return this.hmap.keySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.833 -0400", hash_original_method = "35750F73219F56C1FC4F989AFDC72835", hash_generated_method = "E4CA89F24CACD04FD28981D736FCA33A")
    public NameValue put(String name, NameValue nameValue) {
        NameValue varB4EAC82CA7396A68D541C85D26508E83_407702222 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_407702222 = this.hmap.put(name, nameValue);
        addTaint(name.getTaint());
        addTaint(nameValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_407702222.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_407702222;
        // ---------- Original Method ----------
        //return this.hmap.put(name, nameValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.833 -0400", hash_original_method = "E36B216223163EA26215959E10A918CA", hash_generated_method = "98A6D3DF2D66B7EDC8DB77F3BEEC0851")
    public void putAll(Map<? extends String, ? extends NameValue> map) {
        this.hmap.putAll(map);
        addTaint(map.getTaint());
        // ---------- Original Method ----------
        //this.hmap.putAll(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.834 -0400", hash_original_method = "790110009BF426B36394178253C0659C", hash_generated_method = "B8FB5FC9A3E03628FF9D707AC37866E8")
    public NameValue remove(Object key) {
        NameValue varB4EAC82CA7396A68D541C85D26508E83_1962550291 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1962550291 = this.hmap.remove(key.toString().toLowerCase());
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1962550291.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1962550291;
        // ---------- Original Method ----------
        //return this.hmap.remove(key.toString().toLowerCase());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.842 -0400", hash_original_method = "979875D580378EC87CDE1564DB1000BC", hash_generated_method = "693B9A6AC11CB1B1A9AC08E7429FA869")
    public Collection<NameValue> values() {
        Collection<NameValue> varB4EAC82CA7396A68D541C85D26508E83_901936523 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_901936523 = this.hmap.values();
        varB4EAC82CA7396A68D541C85D26508E83_901936523.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_901936523;
        // ---------- Original Method ----------
        //return this.hmap.values();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.842 -0400", hash_original_method = "2A0022C30F51CA39DC1594F13A7B2530", hash_generated_method = "3E832B04FDE5290D2F8E58EA03F36C27")
    @Override
    public int hashCode() {
        int var70DE47DDDCE2E5DB9367AADB33D33681_915140301 = (this.hmap.keySet().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1791960587 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1791960587;
        // ---------- Original Method ----------
        //return this.hmap.keySet().hashCode();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.842 -0400", hash_original_field = "E5D78D1B5C3BACA3AFF8BA02AB02159E", hash_generated_field = "6B11FE2C5DCA0ECAEBAF973A6A730CE1")

    private static long serialVersionUID = -6998271876574260243L;
}

