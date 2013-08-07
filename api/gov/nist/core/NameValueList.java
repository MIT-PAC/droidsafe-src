package gov.nist.core;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;






public class NameValueList implements Serializable, Cloneable, Map<String,NameValue> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.657 -0400", hash_original_field = "1792643415A657BEEC20CC7ECBCCD4B1", hash_generated_field = "EB935C097CDD69EAB431C97FAA415189")

    private Map<String,NameValue> hmap;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.657 -0400", hash_original_field = "A0F0BC95016C862498BBAD29D1F4D9D4", hash_generated_field = "A55DB8D30D61AD070DC11E077713D1B8")

    private String separator;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.658 -0400", hash_original_method = "E8FF7D679153D33DE114891B4F9D5A45", hash_generated_method = "336BD0E12DEBE109B27311EE1406982B")
    public  NameValueList() {
        this.separator = ";";
        this.hmap = new LinkedHashMap<String,NameValue>();
        // ---------- Original Method ----------
        //this.separator = ";";
        //this.hmap = new LinkedHashMap<String,NameValue>();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.660 -0400", hash_original_method = "31A624E97D000A93AA89FEF53FE9BAB4", hash_generated_method = "5B93D3F26384022AFCBB9E398E15D02D")
    public  NameValueList(boolean sync) {
        addTaint(sync);
        this.separator = ";";
        if(sync)        
        this.hmap = new ConcurrentHashMap<String,NameValue>();
        else
        this.hmap = new LinkedHashMap<String,NameValue>();
        // ---------- Original Method ----------
        //this.separator = ";";
        //if (sync)
            //this.hmap = new ConcurrentHashMap<String,NameValue>();
        //else
            //this.hmap = new LinkedHashMap<String,NameValue>();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.661 -0400", hash_original_method = "45084252F3EC1C5D752F2E607BC4F59B", hash_generated_method = "87C291B29969431F03CD87D5C89B7360")
    public void setSeparator(String separator) {
        this.separator = separator;
        // ---------- Original Method ----------
        //this.separator = separator;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.661 -0400", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "CB8C53FC7F715F8CA3044E77D41E159A")
    public String encode() {
String var678B6FE61D54E5BD4E109D01C318C133_1326207239 =         encode(new StringBuffer()).toString();
        var678B6FE61D54E5BD4E109D01C318C133_1326207239.addTaint(taint);
        return var678B6FE61D54E5BD4E109D01C318C133_1326207239;
        // ---------- Original Method ----------
        //return encode(new StringBuffer()).toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.662 -0400", hash_original_method = "865D14C9D79B396183E2E3DA24E39568", hash_generated_method = "551D3F184F45135FB1A114EDFBEABB5E")
    public StringBuffer encode(StringBuffer buffer) {
        addTaint(buffer.getTaint());
        if(!hmap.isEmpty())        
        {
            Iterator<NameValue> iterator = hmap.values().iterator();
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
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_1375962004 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_1375962004.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_1375962004;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.663 -0400", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "FE0233DE656DB35739E7B4E017D1DA12")
    public String toString() {
String varB17575D7C845B2C662583710539AAEBB_385451685 =         this.encode();
        varB17575D7C845B2C662583710539AAEBB_385451685.addTaint(taint);
        return varB17575D7C845B2C662583710539AAEBB_385451685;
        // ---------- Original Method ----------
        //return this.encode();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.664 -0400", hash_original_method = "541832A041A683842702BE4F440BB6F9", hash_generated_method = "A1590A8E15EAA44745904AC4280A88F2")
    public void set(NameValue nv) {
        addTaint(nv.getTaint());
        this.hmap.put(nv.getName().toLowerCase(), nv);
        // ---------- Original Method ----------
        //this.hmap.put(nv.getName().toLowerCase(), nv);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.664 -0400", hash_original_method = "728B9B3DC246366575180118914F1A29", hash_generated_method = "E6B6A91D3744F3FE5DAF8C7D21A3BF57")
    public void set(String name, Object value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        NameValue nameValue = new NameValue(name, value);
        hmap.put(name.toLowerCase(), nameValue);
        // ---------- Original Method ----------
        //NameValue nameValue = new NameValue(name, value);
        //hmap.put(name.toLowerCase(), nameValue);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.665 -0400", hash_original_method = "91A5AF22400C8AC862CBF8DA0CDC612B", hash_generated_method = "17521A8AE82B7C9625A97F290669CA15")
    public boolean equals(Object otherObject) {
        addTaint(otherObject.getTaint());
        if(otherObject == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_2035276017 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1861904753 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1861904753;
        } //End block
        if(!otherObject.getClass().equals(this.getClass()))        
        {
            boolean var68934A3E9455FA72420237EB05902327_832546337 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_857919102 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_857919102;
        } //End block
        NameValueList other = (NameValueList) otherObject;
        if(hmap.size() != other.hmap.size())        
        {
            boolean var68934A3E9455FA72420237EB05902327_5515293 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_159379871 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_159379871;
        } //End block
        Iterator<String> li = this.hmap.keySet().iterator();
        while
(li.hasNext())        
        {
            String key = (String) li.next();
            NameValue nv1 = this.getNameValue(key);
            NameValue nv2 = (NameValue) other.hmap.get(key);
            if(nv2 == null)            
            {
            boolean var68934A3E9455FA72420237EB05902327_872321826 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1817480038 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1817480038;
            }
            else
            if(!nv2.equals(nv1))            
            {
            boolean var68934A3E9455FA72420237EB05902327_827061256 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1267723474 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1267723474;
            }
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_199513025 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1531088330 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1531088330;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.666 -0400", hash_original_method = "DE074F80660571F2D9A0EA59E951198A", hash_generated_method = "61AAA1B822C2E4A60F06007182E4D72C")
    public Object getValue(String name) {
        addTaint(name.getTaint());
        NameValue nv = this.getNameValue(name.toLowerCase());
        if(nv != null)        
        {
Object varB5591935C8DF868E19E20B421BC76F60_1921250720 =         nv.getValueAsObject();
        varB5591935C8DF868E19E20B421BC76F60_1921250720.addTaint(taint);
        return varB5591935C8DF868E19E20B421BC76F60_1921250720;
        }
        else
        {
Object var540C13E9E156B687226421B24F2DF178_1036289483 =         null;
        var540C13E9E156B687226421B24F2DF178_1036289483.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1036289483;
        }
        // ---------- Original Method ----------
        //NameValue nv = this.getNameValue(name.toLowerCase());
        //if (nv != null)
            //return nv.getValueAsObject();
        //else
            //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.666 -0400", hash_original_method = "5A90B099A8628E34F647DE9E37BC52D0", hash_generated_method = "668D478C1DDC226C58B165FC82B7748B")
    public NameValue getNameValue(String name) {
        addTaint(name.getTaint());
NameValue varAB88A7A43A8A5718EBE4AE7B1A981832_7948541 =         (NameValue) this.hmap.get(name.toLowerCase());
        varAB88A7A43A8A5718EBE4AE7B1A981832_7948541.addTaint(taint);
        return varAB88A7A43A8A5718EBE4AE7B1A981832_7948541;
        // ---------- Original Method ----------
        //return (NameValue) this.hmap.get(name.toLowerCase());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.667 -0400", hash_original_method = "DB40CF4190456B2BE2224926B4D8156A", hash_generated_method = "31A49EF695A38FA0C1EF11F9854FD946")
    public boolean hasNameValue(String name) {
        addTaint(name.getTaint());
        boolean var9BC1BC37B2E2975078324B227482D882_139617195 = (hmap.containsKey(name.toLowerCase()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1579244677 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1579244677;
        // ---------- Original Method ----------
        //return hmap.containsKey(name.toLowerCase());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.667 -0400", hash_original_method = "91B0980C21C7F267937CEFAA60D652AB", hash_generated_method = "AB4A6D6C8126D9D10EF52E7604507431")
    public boolean delete(String name) {
        addTaint(name.getTaint());
        String lcName = name.toLowerCase();
        if(this.hmap.containsKey(lcName))        
        {
            this.hmap.remove(lcName);
            boolean varB326B5062B2F0E69046810717534CB09_1908228951 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1988580433 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1988580433;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_1987036735 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1406569920 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1406569920;
        } //End block
        // ---------- Original Method ----------
        //String lcName = name.toLowerCase();
        //if (this.hmap.containsKey(lcName)) {
            //this.hmap.remove(lcName);
            //return true;
        //} else {
            //return false;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.668 -0400", hash_original_method = "6F9503A91BCD71FF680044D2BE3EB547", hash_generated_method = "A309E76EA4DF803B544B1ABC0D986F59")
    public Object clone() {
        NameValueList retval = new NameValueList();
        retval.setSeparator(this.separator);
        Iterator<NameValue> it = this.hmap.values().iterator();
        while
(it.hasNext())        
        {
            retval.set((NameValue) ((NameValue) it.next()).clone());
        } //End block
Object varF9E19AD6135C970F387F77C6F3DE4477_1109663127 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1109663127.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1109663127;
        // ---------- Original Method ----------
        //NameValueList retval = new NameValueList();
        //retval.setSeparator(this.separator);
        //Iterator<NameValue> it = this.hmap.values().iterator();
        //while (it.hasNext()) {
            //retval.set((NameValue) ((NameValue) it.next()).clone());
        //}
        //return retval;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.668 -0400", hash_original_method = "3E6F4B689378892245F121C3B2A70863", hash_generated_method = "E400117CC5E8C5DAE18CAFAFB3302050")
    public int size() {
        int var5C080DFB1F7C37C11D63F9E5BE1CABE3_1678537758 = (this.hmap.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_567008988 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_567008988;
        // ---------- Original Method ----------
        //return this.hmap.size();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.668 -0400", hash_original_method = "9CD772E1CB5E6BE1ED1982B78A84FA1B", hash_generated_method = "D76EDC376D5C610C5F41AB1E93DC955B")
    public boolean isEmpty() {
        boolean var66785E87EFFF0C84CDD6840CEEEBB700_2065255100 = (hmap.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_434611067 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_434611067;
        // ---------- Original Method ----------
        //return hmap.isEmpty();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.668 -0400", hash_original_method = "F37BBAD929816040B3EA007E6DF28502", hash_generated_method = "06DA3812E8CA69E73524E4C4B6DDA065")
    public Iterator<NameValue> iterator() {
Iterator<NameValue> var24E21943B27D8F8458369C57F31CBCFF_1219053009 =         this.hmap.values().iterator();
        var24E21943B27D8F8458369C57F31CBCFF_1219053009.addTaint(taint);
        return var24E21943B27D8F8458369C57F31CBCFF_1219053009;
        // ---------- Original Method ----------
        //return this.hmap.values().iterator();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.669 -0400", hash_original_method = "7A59F5DB1186413E79C951C76908BFDC", hash_generated_method = "03E8C9039E8E503B5568B731F5D27674")
    public Iterator<String> getNames() {
Iterator<String> var37942BC41313EC22A50120AB8441BF68_1127783773 =         this.hmap.keySet().iterator();
        var37942BC41313EC22A50120AB8441BF68_1127783773.addTaint(taint);
        return var37942BC41313EC22A50120AB8441BF68_1127783773;
        // ---------- Original Method ----------
        //return this.hmap.keySet().iterator();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.669 -0400", hash_original_method = "6D3851F46197204C176DAB6DC4EAB5DB", hash_generated_method = "7222076D61CC6E2D6DF120038A11AB98")
    public String getParameter(String name) {
        addTaint(name.getTaint());
        Object val = this.getValue(name);
        if(val == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1173563302 =         null;
        var540C13E9E156B687226421B24F2DF178_1173563302.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1173563302;
        }
        if(val instanceof GenericObject)        
        {
String varF1B6C72F38290E3B9280610078FC772A_1567912149 =         ((GenericObject) val).encode();
        varF1B6C72F38290E3B9280610078FC772A_1567912149.addTaint(taint);
        return varF1B6C72F38290E3B9280610078FC772A_1567912149;
        }
        else
        {
String var38570108501B3BE2AC163FA564B07985_734500136 =         val.toString();
        var38570108501B3BE2AC163FA564B07985_734500136.addTaint(taint);
        return var38570108501B3BE2AC163FA564B07985_734500136;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.669 -0400", hash_original_method = "980179408BF501109227F08D5C9216B1", hash_generated_method = "D57897A75D7D199B0F1407488666631F")
    public void clear() {
        this.hmap.clear();
        // ---------- Original Method ----------
        //this.hmap.clear();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.670 -0400", hash_original_method = "2E0F75BA6AFD5C18A55AE3B632F0C375", hash_generated_method = "2B267254CAFC361E43E489F9A78323C9")
    public boolean containsKey(Object key) {
        addTaint(key.getTaint());
        boolean varE76BB5BD71EE51A24CB9239D7A26B487_1866521671 = (this.hmap.containsKey(key.toString().toLowerCase()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1466912155 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1466912155;
        // ---------- Original Method ----------
        //return this.hmap.containsKey(key.toString().toLowerCase());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.670 -0400", hash_original_method = "A6EA0419C0087EA83C0DBCC271DA2735", hash_generated_method = "7BAA4A6EA5238F308CAB502EA3B14099")
    public boolean containsValue(Object value) {
        addTaint(value.getTaint());
        boolean varD11974EADD54FCEDC38C97178D938FC9_394692822 = (this.hmap.containsValue(value));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1671991644 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1671991644;
        // ---------- Original Method ----------
        //return this.hmap.containsValue(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.670 -0400", hash_original_method = "B4FF19B42F00873A6D908667D4FF7E33", hash_generated_method = "BA3B0349FA1CB352CD6BDAF8F6908BD5")
    public Set<java.util.Map.Entry<String, NameValue>> entrySet() {
Set<java.util.Map.Entry<String, NameValue>> var83C0E9D0E149D5A5F81D10ABAD1DFC9A_1851721480 =         this.hmap.entrySet();
        var83C0E9D0E149D5A5F81D10ABAD1DFC9A_1851721480.addTaint(taint);
        return var83C0E9D0E149D5A5F81D10ABAD1DFC9A_1851721480;
        // ---------- Original Method ----------
        //return this.hmap.entrySet();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.671 -0400", hash_original_method = "EA67EE9A45F5352AADEB9693E72F1050", hash_generated_method = "6725B4987149924818A6F16E427818BD")
    public NameValue get(Object key) {
        addTaint(key.getTaint());
NameValue varB9E8C1F6EBBA90CE14654029AF6602EF_510203829 =         this.hmap.get(key.toString().toLowerCase());
        varB9E8C1F6EBBA90CE14654029AF6602EF_510203829.addTaint(taint);
        return varB9E8C1F6EBBA90CE14654029AF6602EF_510203829;
        // ---------- Original Method ----------
        //return this.hmap.get(key.toString().toLowerCase());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.671 -0400", hash_original_method = "EB227B4CB4A434E80044A70A11CCF2F7", hash_generated_method = "60845E3AAE81DDDC9C58F142A271EDE7")
    public Set<String> keySet() {
Set<String> varCA9D852D27AF4E6EECBB3A911792EB77_371865029 =         this.hmap.keySet();
        varCA9D852D27AF4E6EECBB3A911792EB77_371865029.addTaint(taint);
        return varCA9D852D27AF4E6EECBB3A911792EB77_371865029;
        // ---------- Original Method ----------
        //return this.hmap.keySet();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.671 -0400", hash_original_method = "35750F73219F56C1FC4F989AFDC72835", hash_generated_method = "33BC90D172399DFA982E465FD143D51F")
    public NameValue put(String name, NameValue nameValue) {
        addTaint(nameValue.getTaint());
        addTaint(name.getTaint());
NameValue varFAB6ABD39F93D785C563AA57903DA56F_495477379 =         this.hmap.put(name, nameValue);
        varFAB6ABD39F93D785C563AA57903DA56F_495477379.addTaint(taint);
        return varFAB6ABD39F93D785C563AA57903DA56F_495477379;
        // ---------- Original Method ----------
        //return this.hmap.put(name, nameValue);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.671 -0400", hash_original_method = "E36B216223163EA26215959E10A918CA", hash_generated_method = "F216408185EC6C2950CC8DE5BD2EA275")
    public void putAll(Map<? extends String, ? extends NameValue> map) {
        addTaint(map.getTaint());
        this.hmap.putAll(map);
        // ---------- Original Method ----------
        //this.hmap.putAll(map);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.672 -0400", hash_original_method = "790110009BF426B36394178253C0659C", hash_generated_method = "63E7E6A27696CA9D084312EEB3CFA062")
    public NameValue remove(Object key) {
        addTaint(key.getTaint());
NameValue var043B63D84DF0113B7460663124CEE052_1545552453 =         this.hmap.remove(key.toString().toLowerCase());
        var043B63D84DF0113B7460663124CEE052_1545552453.addTaint(taint);
        return var043B63D84DF0113B7460663124CEE052_1545552453;
        // ---------- Original Method ----------
        //return this.hmap.remove(key.toString().toLowerCase());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.672 -0400", hash_original_method = "979875D580378EC87CDE1564DB1000BC", hash_generated_method = "FDE8D741EA8ED81C9B1757FF6DED42E2")
    public Collection<NameValue> values() {
Collection<NameValue> varF1AB8357887451321CB52525579A2F99_1827517661 =         this.hmap.values();
        varF1AB8357887451321CB52525579A2F99_1827517661.addTaint(taint);
        return varF1AB8357887451321CB52525579A2F99_1827517661;
        // ---------- Original Method ----------
        //return this.hmap.values();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.672 -0400", hash_original_method = "2A0022C30F51CA39DC1594F13A7B2530", hash_generated_method = "0A044468C3226381278F931E5EB22375")
    @Override
    public int hashCode() {
        int var9042434EC99FF07EA1A07CF6E01AE048_1769214220 = (this.hmap.keySet().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_979685067 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_979685067;
        // ---------- Original Method ----------
        //return this.hmap.keySet().hashCode();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:30.672 -0400", hash_original_field = "E5D78D1B5C3BACA3AFF8BA02AB02159E", hash_generated_field = "6139D38F46B665D29EA8807167945764")

    private static final long serialVersionUID = -6998271876574260243L;
}

