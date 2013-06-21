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
    private Map<String,NameValue> hmap;
    private String separator;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.744 -0400", hash_original_method = "E8FF7D679153D33DE114891B4F9D5A45", hash_generated_method = "336BD0E12DEBE109B27311EE1406982B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NameValueList() {
        this.separator = ";";
        this.hmap = new LinkedHashMap<String,NameValue>();
        // ---------- Original Method ----------
        //this.separator = ";";
        //this.hmap = new LinkedHashMap<String,NameValue>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.745 -0400", hash_original_method = "31A624E97D000A93AA89FEF53FE9BAB4", hash_generated_method = "BCCD9788D8BC65DF412441AAD72BF325")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NameValueList(boolean sync) {
        dsTaint.addTaint(sync);
        this.separator = ";";
        this.hmap = new ConcurrentHashMap<String,NameValue>();
        this.hmap = new LinkedHashMap<String,NameValue>();
        // ---------- Original Method ----------
        //this.separator = ";";
        //if (sync)
            //this.hmap = new ConcurrentHashMap<String,NameValue>();
        //else
            //this.hmap = new LinkedHashMap<String,NameValue>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.745 -0400", hash_original_method = "45084252F3EC1C5D752F2E607BC4F59B", hash_generated_method = "5B066F79104AEA40FEEB500F34D9A66B")
    @DSModeled(DSC.SAFE)
    public void setSeparator(String separator) {
        dsTaint.addTaint(separator);
        // ---------- Original Method ----------
        //this.separator = separator;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.745 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "29AF168EFDA1F33C98255A8BF13D9949")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encode() {
        String varFFB45C40AF627644780ECFF5921CFE15_280562280 = (encode(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.746 -0400", hash_original_method = "865D14C9D79B396183E2E3DA24E39568", hash_generated_method = "FCA1C0651A2B81084D217E5140535950")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StringBuffer encode(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        {
            boolean varE7AB5FCEA0FCF62ECE76D28899186A7A_103767332 = (!hmap.isEmpty());
            {
                Iterator<NameValue> iterator;
                iterator = hmap.values().iterator();
                {
                    boolean varA524DEFD7CC0C913305DE8790C40B8FE_1875111868 = (iterator.hasNext());
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
                                boolean varBA94060EAB38FC283ECB954DF4224C1E_384457226 = (iterator.hasNext());
                                buffer.append(separator);
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (StringBuffer)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.746 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "306CE7DEC6C4C2E487830120603FA3D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var002E8E97D996E9DD2E7B0E1B0BD6187C_1086872219 = (this.encode());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.encode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.747 -0400", hash_original_method = "541832A041A683842702BE4F440BB6F9", hash_generated_method = "70B1FD9BBA040205C0934DF287B1459A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void set(NameValue nv) {
        dsTaint.addTaint(nv.dsTaint);
        this.hmap.put(nv.getName().toLowerCase(), nv);
        // ---------- Original Method ----------
        //this.hmap.put(nv.getName().toLowerCase(), nv);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.747 -0400", hash_original_method = "728B9B3DC246366575180118914F1A29", hash_generated_method = "B325A8AEBB0A243738CAF600E62D040B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void set(String name, Object value) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value.dsTaint);
        NameValue nameValue;
        nameValue = new NameValue(name, value);
        hmap.put(name.toLowerCase(), nameValue);
        // ---------- Original Method ----------
        //NameValue nameValue = new NameValue(name, value);
        //hmap.put(name.toLowerCase(), nameValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.747 -0400", hash_original_method = "91A5AF22400C8AC862CBF8DA0CDC612B", hash_generated_method = "4D1D279BC84C2F95FA08597638620BE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object otherObject) {
        dsTaint.addTaint(otherObject.dsTaint);
        {
            boolean var5483DA14562500B9B202946E175C6ADB_1628981899 = (!otherObject.getClass().equals(this.getClass()));
        } //End collapsed parenthetic
        NameValueList other;
        other = (NameValueList) otherObject;
        {
            boolean var2B94E0DAC2F3B2F020FEBCC7091FA58F_1496614488 = (hmap.size() != other.hmap.size());
        } //End collapsed parenthetic
        Iterator<String> li;
        li = this.hmap.keySet().iterator();
        {
            boolean varBC3D864DE8830EFC1098D2C2F456529D_1586249884 = (li.hasNext());
            {
                String key;
                key = (String) li.next();
                NameValue nv1;
                nv1 = this.getNameValue(key);
                NameValue nv2;
                nv2 = (NameValue) other.hmap.get(key);
                {
                    boolean varC317F8E9B63A112DB5D5B271C8C64DB8_1084397751 = (!nv2.equals(nv1));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.748 -0400", hash_original_method = "DE074F80660571F2D9A0EA59E951198A", hash_generated_method = "C89F21914470DE3230E050A01B42A3BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getValue(String name) {
        dsTaint.addTaint(name);
        NameValue nv;
        nv = this.getNameValue(name.toLowerCase());
        Object var06A2096761A1C16FD6FC0A39D6E852ED_679576421 = (nv.getValueAsObject());
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //NameValue nv = this.getNameValue(name.toLowerCase());
        //if (nv != null)
            //return nv.getValueAsObject();
        //else
            //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.748 -0400", hash_original_method = "5A90B099A8628E34F647DE9E37BC52D0", hash_generated_method = "55DD3D63DDCA2447673282D1A8B5682E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NameValue getNameValue(String name) {
        dsTaint.addTaint(name);
        NameValue varC2B90F16D6A58CB7DEC7E990D55B4155_1053047627 = ((NameValue) this.hmap.get(name.toLowerCase()));
        return (NameValue)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (NameValue) this.hmap.get(name.toLowerCase());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.748 -0400", hash_original_method = "DB40CF4190456B2BE2224926B4D8156A", hash_generated_method = "BC59F21CB9E3376ECE0862136663BDFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasNameValue(String name) {
        dsTaint.addTaint(name);
        boolean var95354E3F5489DEAD152E96DDFED142A2_1764408623 = (hmap.containsKey(name.toLowerCase()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return hmap.containsKey(name.toLowerCase());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.748 -0400", hash_original_method = "91B0980C21C7F267937CEFAA60D652AB", hash_generated_method = "1D16DD778DE9A5208DEEE59EB1E163DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean delete(String name) {
        dsTaint.addTaint(name);
        String lcName;
        lcName = name.toLowerCase();
        {
            boolean var148E369A265566D6BF02ACD75EFF4274_665400613 = (this.hmap.containsKey(lcName));
            {
                this.hmap.remove(lcName);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //String lcName = name.toLowerCase();
        //if (this.hmap.containsKey(lcName)) {
            //this.hmap.remove(lcName);
            //return true;
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.749 -0400", hash_original_method = "6F9503A91BCD71FF680044D2BE3EB547", hash_generated_method = "0DC9DFBAD2D57F1422382F74C4C4E5FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        NameValueList retval;
        retval = new NameValueList();
        retval.setSeparator(this.separator);
        Iterator<NameValue> it;
        it = this.hmap.values().iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_525604455 = (it.hasNext());
            {
                retval.set((NameValue) ((NameValue) it.next()).clone());
            } //End block
        } //End collapsed parenthetic
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //NameValueList retval = new NameValueList();
        //retval.setSeparator(this.separator);
        //Iterator<NameValue> it = this.hmap.values().iterator();
        //while (it.hasNext()) {
            //retval.set((NameValue) ((NameValue) it.next()).clone());
        //}
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.749 -0400", hash_original_method = "3E6F4B689378892245F121C3B2A70863", hash_generated_method = "093E67110E36DC67B437CAA76673F213")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int size() {
        int varAD074C75E3799B7E0759F76B31D68F7C_2731986 = (this.hmap.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.hmap.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.749 -0400", hash_original_method = "9CD772E1CB5E6BE1ED1982B78A84FA1B", hash_generated_method = "600BDF614FC30A4A8B21145B2BD16BFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEmpty() {
        boolean var39B0CF3B25DAF9AA86C553FF8CBBE59D_1498969069 = (hmap.isEmpty());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return hmap.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.749 -0400", hash_original_method = "F37BBAD929816040B3EA007E6DF28502", hash_generated_method = "FD76D625F3E3D67B83DC982221F2B9DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Iterator<NameValue> iterator() {
        Iterator<NameValue> varE8699CF1302CC85FC86FDC197E3788A9_1160331180 = (this.hmap.values().iterator());
        return (Iterator<NameValue>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.hmap.values().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.750 -0400", hash_original_method = "7A59F5DB1186413E79C951C76908BFDC", hash_generated_method = "C3CD65D2A59CFAFA6B9EBCE3E6E5ED28")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Iterator<String> getNames() {
        Iterator<String> varE9A4973E862A8E18DA44DCB6EF95C81F_605250097 = (this.hmap.keySet().iterator());
        return (Iterator<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.hmap.keySet().iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.750 -0400", hash_original_method = "6D3851F46197204C176DAB6DC4EAB5DB", hash_generated_method = "2C4C88037A5A3270F64EDA40BC565C55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getParameter(String name) {
        dsTaint.addTaint(name);
        Object val;
        val = this.getValue(name);
        String var95441B18ED228B9E74BF37F54C5F5827_579372903 = (((GenericObject) val).encode());
        String var1256D27AA7319A7570F46BC6DF2B0099_2028005949 = (val.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.750 -0400", hash_original_method = "980179408BF501109227F08D5C9216B1", hash_generated_method = "D57897A75D7D199B0F1407488666631F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clear() {
        this.hmap.clear();
        // ---------- Original Method ----------
        //this.hmap.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.750 -0400", hash_original_method = "2E0F75BA6AFD5C18A55AE3B632F0C375", hash_generated_method = "FFE45278819FB99DE1BC337D4DA3FC48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsKey(Object key) {
        dsTaint.addTaint(key.dsTaint);
        boolean varA98C33CD2477BB9F9D0B2159708FBF49_1765493314 = (this.hmap.containsKey(key.toString().toLowerCase()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.hmap.containsKey(key.toString().toLowerCase());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.751 -0400", hash_original_method = "A6EA0419C0087EA83C0DBCC271DA2735", hash_generated_method = "87A9491E087642EB27D74D7CB2FC2B49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsValue(Object value) {
        dsTaint.addTaint(value.dsTaint);
        boolean var315CB0777C99FCEC46C74AF0C2970AA7_1121608865 = (this.hmap.containsValue(value));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this.hmap.containsValue(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.751 -0400", hash_original_method = "B4FF19B42F00873A6D908667D4FF7E33", hash_generated_method = "3F3B6210D6A02335CE1CC1066171FBD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<java.util.Map.Entry<String, NameValue>> entrySet() {
        Set<java.util.Map.Entry<String, NameValue>> varD2B283E59626CD6B4B43942D7C7BC105_2136836960 = (this.hmap.entrySet());
        return (Set<java.util.Map.Entry<String, NameValue>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.hmap.entrySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.751 -0400", hash_original_method = "EA67EE9A45F5352AADEB9693E72F1050", hash_generated_method = "4D5FE35F9D0AE09ED2D0651CD927B34A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NameValue get(Object key) {
        dsTaint.addTaint(key.dsTaint);
        NameValue varD71CC2524B735F82F0A1A16C516295E6_1160680234 = (this.hmap.get(key.toString().toLowerCase()));
        return (NameValue)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.hmap.get(key.toString().toLowerCase());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.751 -0400", hash_original_method = "EB227B4CB4A434E80044A70A11CCF2F7", hash_generated_method = "03CD866CE941C295C060E0402AD6831E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<String> keySet() {
        Set<String> var4C7FDF55D82E4A4BAE1901B457C11BD6_811116286 = (this.hmap.keySet());
        return (Set<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.hmap.keySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.752 -0400", hash_original_method = "35750F73219F56C1FC4F989AFDC72835", hash_generated_method = "54D31926B943883CC16A00538FA6392F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NameValue put(String name, NameValue nameValue) {
        dsTaint.addTaint(nameValue.dsTaint);
        dsTaint.addTaint(name);
        NameValue var8FADEC2CAD9857A6B5E20D4E05AA1373_670633296 = (this.hmap.put(name, nameValue));
        return (NameValue)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.hmap.put(name, nameValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.752 -0400", hash_original_method = "E36B216223163EA26215959E10A918CA", hash_generated_method = "93C756AFE160015EF08142A49EED95EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void putAll(Map<? extends String, ? extends NameValue> map) {
        dsTaint.addTaint(map.dsTaint);
        this.hmap.putAll(map);
        // ---------- Original Method ----------
        //this.hmap.putAll(map);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.752 -0400", hash_original_method = "790110009BF426B36394178253C0659C", hash_generated_method = "F556EB0BC66304E379ADD3CB562185CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NameValue remove(Object key) {
        dsTaint.addTaint(key.dsTaint);
        NameValue var77E06EF0378816804C1239B93CF1A692_1096643570 = (this.hmap.remove(key.toString().toLowerCase()));
        return (NameValue)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.hmap.remove(key.toString().toLowerCase());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.753 -0400", hash_original_method = "979875D580378EC87CDE1564DB1000BC", hash_generated_method = "507CD22C2952CC3166C0D53237BB8CCD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection<NameValue> values() {
        Collection<NameValue> varBA62B49541E3DCBFFEA803FF48D9EE81_914146294 = (this.hmap.values());
        return (Collection<NameValue>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.hmap.values();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.753 -0400", hash_original_method = "2A0022C30F51CA39DC1594F13A7B2530", hash_generated_method = "01275C47147422975AFFA847FBD8FD02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var70DE47DDDCE2E5DB9367AADB33D33681_2106349427 = (this.hmap.keySet().hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.hmap.keySet().hashCode();
    }

    
    private static final long serialVersionUID = -6998271876574260243L;
}

