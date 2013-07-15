package java.util.jar;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class Attributes implements Cloneable, Map<Object, Object> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.976 -0400", hash_original_field = "1D78DC8ED51214E518B5114FE24490AE", hash_generated_field = "469DC0A3DDAB50D1A339FF08EE199F5C")

    protected Map<Object, Object> map;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.976 -0400", hash_original_method = "CDEB7A2340880305C142690108AEFF5F", hash_generated_method = "9872D14EC462B5E29026E6B7277BD8A7")
    public  Attributes() {
        map = new HashMap<Object, Object>();
        // ---------- Original Method ----------
        //map = new HashMap<Object, Object>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.977 -0400", hash_original_method = "F8717927CC90D5B5AE946AC3A31B19F4", hash_generated_method = "FBDA935B9A3831C52372D161FF350F6C")
    @SuppressWarnings("unchecked")
    public  Attributes(Attributes attrib) {
        map = (Map<Object, Object>) ((HashMap) attrib.map).clone();
        // ---------- Original Method ----------
        //map = (Map<Object, Object>) ((HashMap) attrib.map).clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.977 -0400", hash_original_method = "C0A84EEFF5C41531DA971DB0633F74FC", hash_generated_method = "792E69047F9763844FF159A7272D0CD4")
    public  Attributes(int size) {
        map = new HashMap<Object, Object>(size);
        // ---------- Original Method ----------
        //map = new HashMap<Object, Object>(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.978 -0400", hash_original_method = "00A8C0F9832A2FA4DDA896013D523229", hash_generated_method = "2A83EDB450FE64133FB4489A062A886E")
    public void clear() {
        map.clear();
        // ---------- Original Method ----------
        //map.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.978 -0400", hash_original_method = "51FDEF8A21E6EA5E0FB4715F8113FE74", hash_generated_method = "D031E4AC2985137BA26216373D5679CB")
    public boolean containsKey(Object key) {
        addTaint(key.getTaint());
        boolean var1F5C7C829096E4FDB1A63A2E9D4DD6A2_641446783 = (map.containsKey(key));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_785585422 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_785585422;
        // ---------- Original Method ----------
        //return map.containsKey(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.978 -0400", hash_original_method = "E6B0C93317C0E9F78301AFF4874F2620", hash_generated_method = "470A0B37DB116BDDA8A3A03FC7A765F5")
    public boolean containsValue(Object value) {
        addTaint(value.getTaint());
        boolean var439CD853F6BCC3FF03C1D84B0BD65A51_1361733360 = (map.containsValue(value));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1398453455 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1398453455;
        // ---------- Original Method ----------
        //return map.containsValue(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.979 -0400", hash_original_method = "2E4A8A9DC4043DAAC1C8FCCBA69D6A6B", hash_generated_method = "5105229ABFFB4C518091385B2837D51B")
    public Set<Map.Entry<Object, Object>> entrySet() {
Set<Map.Entry<Object, Object>> varD70A818A9C24919C79B0A6854ED78BA4_374034933 =         map.entrySet();
        varD70A818A9C24919C79B0A6854ED78BA4_374034933.addTaint(taint);
        return varD70A818A9C24919C79B0A6854ED78BA4_374034933;
        // ---------- Original Method ----------
        //return map.entrySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.979 -0400", hash_original_method = "C22494F044E1A5B9985D58D15AE531DA", hash_generated_method = "8AF3F7B82BEB04400184CE32E5850974")
    public Object get(Object key) {
        addTaint(key.getTaint());
Object var97156AACD411ADC83FECC30C065B5B0C_1624539141 =         map.get(key);
        var97156AACD411ADC83FECC30C065B5B0C_1624539141.addTaint(taint);
        return var97156AACD411ADC83FECC30C065B5B0C_1624539141;
        // ---------- Original Method ----------
        //return map.get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.979 -0400", hash_original_method = "193F4487BCC4A9B88FB28866363E7ABF", hash_generated_method = "8BD63C054B055E0EBC15C3DE64B56006")
    public boolean isEmpty() {
        boolean varAF143B23ABB0913809523AA7F6DBE946_481427968 = (map.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1634444808 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1634444808;
        // ---------- Original Method ----------
        //return map.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.980 -0400", hash_original_method = "F488EE4006E1366E830BF13438F76FA9", hash_generated_method = "110CF756342B6380179DB7276A8C6494")
    public Set<Object> keySet() {
Set<Object> varD036BF304D6CB28B6C4DC52E35289E2B_1198901156 =         map.keySet();
        varD036BF304D6CB28B6C4DC52E35289E2B_1198901156.addTaint(taint);
        return varD036BF304D6CB28B6C4DC52E35289E2B_1198901156;
        // ---------- Original Method ----------
        //return map.keySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.980 -0400", hash_original_method = "3E157C761E601D752826F2BACE4084FB", hash_generated_method = "B79C47C6F7118B347BBD80BFF17C1612")
    @SuppressWarnings("cast")
    public Object put(Object key, Object value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
Object var540AD09702F21E0DC7D07F749BDCE47C_1465618467 =         map.put((Name) key, (String) value);
        var540AD09702F21E0DC7D07F749BDCE47C_1465618467.addTaint(taint);
        return var540AD09702F21E0DC7D07F749BDCE47C_1465618467;
        // ---------- Original Method ----------
        //return map.put((Name) key, (String) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.980 -0400", hash_original_method = "2F4F3A55CE715E104E0F5EF4690E41E2", hash_generated_method = "0AB02A49ED72060AECE5D24A0B3CB4DA")
    public void putAll(Map<?, ?> attrib) {
        addTaint(attrib.getTaint());
    if(attrib == null || !(attrib instanceof Attributes))        
        {
            ClassCastException var45476E68D56EDA2334E90E6F67317EA0_1357616304 = new ClassCastException(attrib.getClass().getName() + " not an Attributes");
            var45476E68D56EDA2334E90E6F67317EA0_1357616304.addTaint(taint);
            throw var45476E68D56EDA2334E90E6F67317EA0_1357616304;
        } //End block
        this.map.putAll(attrib);
        // ---------- Original Method ----------
        //if (attrib == null || !(attrib instanceof Attributes)) {
            //throw new ClassCastException(attrib.getClass().getName() + " not an Attributes");
        //}
        //this.map.putAll(attrib);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.981 -0400", hash_original_method = "10CAD66DFB71B02C0F278FCC3305EF24", hash_generated_method = "4C09B273857912A2888320C5C62C8DEC")
    public Object remove(Object key) {
        addTaint(key.getTaint());
Object var680816A9C90635BE8F543A56792CAAE8_444679436 =         map.remove(key);
        var680816A9C90635BE8F543A56792CAAE8_444679436.addTaint(taint);
        return var680816A9C90635BE8F543A56792CAAE8_444679436;
        // ---------- Original Method ----------
        //return map.remove(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.981 -0400", hash_original_method = "BF2CB7E40375B078820B7350C838FBD6", hash_generated_method = "B33BF96C615B0B05AC6EED9AE537D8D0")
    public int size() {
        int var9EF85AA9C38E3AED298A540215786760_847190333 = (map.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1235701007 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1235701007;
        // ---------- Original Method ----------
        //return map.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.981 -0400", hash_original_method = "F211D00F0E74ECC7AD7311207A5002DA", hash_generated_method = "7370FCA85EABDBA9225D88B123C31C87")
    public Collection<Object> values() {
Collection<Object> varB1189193566E908C8B007DC3A156A222_948257271 =         map.values();
        varB1189193566E908C8B007DC3A156A222_948257271.addTaint(taint);
        return varB1189193566E908C8B007DC3A156A222_948257271;
        // ---------- Original Method ----------
        //return map.values();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.982 -0400", hash_original_method = "732187D1BBCF1409FB005BFCCDAC70B4", hash_generated_method = "9E3E3B87D73D0FD9570D6A148ECFCB66")
    @SuppressWarnings("unchecked")
    @Override
    public Object clone() {
        Attributes clone;
        try 
        {
            clone = (Attributes) super.clone();
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_828646234 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_828646234.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_828646234;
        } //End block
        clone.map = (Map<Object, Object>) ((HashMap) map).clone();
Object var3DE52045BFD3C1BF3742F994ED6139AD_393187343 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_393187343.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_393187343;
        // ---------- Original Method ----------
        //Attributes clone;
        //try {
            //clone = (Attributes) super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
        //clone.map = (Map<Object, Object>) ((HashMap) map).clone();
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.982 -0400", hash_original_method = "A7A7EF5A89DF679FD5CBA963DA8911B6", hash_generated_method = "6228902A6060284AF562EF9FBC46E41A")
    @Override
    public int hashCode() {
        int varC94DBB9331A8D72EEBD79AF259A34547_864114804 = (map.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2069273778 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2069273778;
        // ---------- Original Method ----------
        //return map.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.983 -0400", hash_original_method = "E46FF1DB18EE293123D8E2B07FF4B8E9", hash_generated_method = "7B8F9C02BACCCE53DA8F72E82EF7033C")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
    if(this == obj)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1626155083 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1995352730 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1995352730;
        } //End block
    if(obj instanceof Attributes)        
        {
            boolean varC01685827E78F37873C34261BC3E68F6_170287705 = (map.equals(((Attributes) obj).map));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_546854896 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_546854896;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1810933260 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_952130850 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_952130850;
        // ---------- Original Method ----------
        //if (this == obj) {
            //return true;
        //}
        //if (obj instanceof Attributes) {
            //return map.equals(((Attributes) obj).map);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.983 -0400", hash_original_method = "738755F264DB023D14F89BE9B353A481", hash_generated_method = "FC59F29924154A507E4418945F06A8C2")
    public String getValue(Attributes.Name name) {
        addTaint(name.getTaint());
String var2E56F82900FE3F9ECDBE35DB44E1DAF4_1184693168 =         (String) map.get(name);
        var2E56F82900FE3F9ECDBE35DB44E1DAF4_1184693168.addTaint(taint);
        return var2E56F82900FE3F9ECDBE35DB44E1DAF4_1184693168;
        // ---------- Original Method ----------
        //return (String) map.get(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.983 -0400", hash_original_method = "3C8D5071480DE8B5CA7E078D035D576F", hash_generated_method = "68F08081C819221F717D55E0A564DD27")
    public String getValue(String name) {
        addTaint(name.getTaint());
String varE63798A4C2D0AE7AF0DFDFCE98FBDD8C_172514769 =         (String) map.get(new Attributes.Name(name));
        varE63798A4C2D0AE7AF0DFDFCE98FBDD8C_172514769.addTaint(taint);
        return varE63798A4C2D0AE7AF0DFDFCE98FBDD8C_172514769;
        // ---------- Original Method ----------
        //return (String) map.get(new Attributes.Name(name));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.984 -0400", hash_original_method = "6F8FF0BC58E7762A3A8A85D431B8F527", hash_generated_method = "3A5C7889015EDE58491CBA4449BFF86C")
    public String putValue(String name, String val) {
        addTaint(val.getTaint());
        addTaint(name.getTaint());
String var47CC551B40DEE7AD31FE1F527336EAD6_1246735726 =         (String) map.put(new Attributes.Name(name), val);
        var47CC551B40DEE7AD31FE1F527336EAD6_1246735726.addTaint(taint);
        return var47CC551B40DEE7AD31FE1F527336EAD6_1246735726;
        // ---------- Original Method ----------
        //return (String) map.put(new Attributes.Name(name), val);
    }

    
    public static class Name {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.984 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

        private String name;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.985 -0400", hash_original_method = "2C39DBA2C28891B792407C3858FAD7FB", hash_generated_method = "5F9DCEF9E26C61F6FFB0E8B08C0B73EE")
        public  Name(String name) {
    if(name.isEmpty() || name.length() > Manifest.LINE_LENGTH_LIMIT - 2)            
            {
                IllegalArgumentException varBF6A5C454ED01F0F986515C3E9A9CEA3_1944632968 = new IllegalArgumentException(name);
                varBF6A5C454ED01F0F986515C3E9A9CEA3_1944632968.addTaint(taint);
                throw varBF6A5C454ED01F0F986515C3E9A9CEA3_1944632968;
            } //End block
for(int i = 0;i < name.length();i++)
            {
                char ch = name.charAt(i);
    if(!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')
                        || ch == '_' || ch == '-' || (ch >= '0' && ch <= '9')))                
                {
                    IllegalArgumentException varBF6A5C454ED01F0F986515C3E9A9CEA3_1753933219 = new IllegalArgumentException(name);
                    varBF6A5C454ED01F0F986515C3E9A9CEA3_1753933219.addTaint(taint);
                    throw varBF6A5C454ED01F0F986515C3E9A9CEA3_1753933219;
                } //End block
            } //End block
            this.name = name;
            // ---------- Original Method ----------
            //if (name.isEmpty() || name.length() > Manifest.LINE_LENGTH_LIMIT - 2) {
                //throw new IllegalArgumentException(name);
            //}
            //for (int i = 0; i < name.length(); i++) {
                //char ch = name.charAt(i);
                //if (!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')
                        //|| ch == '_' || ch == '-' || (ch >= '0' && ch <= '9'))) {
                    //throw new IllegalArgumentException(name);
                //}
            //}
            //this.name = name;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.985 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "5DC7C4088C2F6AE81FC657856330A788")
         String getName() {
String varB017984728AC60AD1F0BF8734F33F15C_99850503 =             name;
            varB017984728AC60AD1F0BF8734F33F15C_99850503.addTaint(taint);
            return varB017984728AC60AD1F0BF8734F33F15C_99850503;
            // ---------- Original Method ----------
            //return name;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.986 -0400", hash_original_method = "44A371BEEBBEF1D1024A1D234C6B6AC2", hash_generated_method = "187C38485E75C9E1CD728D1AC091F34E")
        @Override
        public boolean equals(Object object) {
            addTaint(object.getTaint());
            boolean var0B0C83673CD6DA72C387BCCCD437C33E_1985328390 = (object instanceof Name
                    && ((Name) object).name.equalsIgnoreCase(name));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_60182106 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_60182106;
            // ---------- Original Method ----------
            //return object instanceof Name
                    //&& ((Name) object).name.equalsIgnoreCase(name);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.986 -0400", hash_original_method = "9402BF4C103D69D49EBD5DEF399C9512", hash_generated_method = "E402ADAC854BDDD765634B2E0671A452")
        @Override
        public int hashCode() {
            int var910918074D2BC8F23BE146DE9B492887_822733114 = (name.toLowerCase(Locale.US).hashCode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_168225158 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_168225158;
            // ---------- Original Method ----------
            //return name.toLowerCase(Locale.US).hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.986 -0400", hash_original_method = "0EB66BA5E965B83E191719250E0A82FF", hash_generated_method = "666D54482FC6F4AAA4E6118357DD1B62")
        @Override
        public String toString() {
String varB017984728AC60AD1F0BF8734F33F15C_1454374584 =             name;
            varB017984728AC60AD1F0BF8734F33F15C_1454374584.addTaint(taint);
            return varB017984728AC60AD1F0BF8734F33F15C_1454374584;
            // ---------- Original Method ----------
            //return name;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.987 -0400", hash_original_field = "7BAFCE84B42A5DA731B6634CC5FFAA45", hash_generated_field = "0B9661DEBA6285ADE4666B79ED38B94B")

        public static final Name CLASS_PATH = new Name("Class-Path");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.987 -0400", hash_original_field = "979A4FE6383FAD6E47B386693779A210", hash_generated_field = "C6B4E6E9D8E48CDF5401ED1A54EC60FF")

        public static final Name MANIFEST_VERSION = new Name("Manifest-Version");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.987 -0400", hash_original_field = "71B9F9ED4173CDF4D0BD9346348BDB4C", hash_generated_field = "5BAA3B0F29B5D6B421C14C179438EFAB")

        public static final Name MAIN_CLASS = new Name("Main-Class");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.987 -0400", hash_original_field = "9EDA43684D8154E3F290DF07AB8508DC", hash_generated_field = "F2F620E8615802A3D89525207F39FBA8")

        public static final Name SIGNATURE_VERSION = new Name("Signature-Version");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.987 -0400", hash_original_field = "5AC651DCF0FF8BA1281471C3D56B1415", hash_generated_field = "D2DC98BAC7E8C22DC2E0EB2EFB820BE5")

        public static final Name CONTENT_TYPE = new Name("Content-Type");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.987 -0400", hash_original_field = "B307531EFBF862D6D2682AF1C5A81B78", hash_generated_field = "169C8F071E808A4124C933174D669007")

        public static final Name SEALED = new Name("Sealed");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.987 -0400", hash_original_field = "1CD7EAEF9F246BA6BCCEADEF2F9C8766", hash_generated_field = "A498C8F3B78053FB6A1D636DAD36FB03")

        public static final Name IMPLEMENTATION_TITLE = new Name("Implementation-Title");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.987 -0400", hash_original_field = "A4E6C113BB6D25458D812355FF1A4C4A", hash_generated_field = "AD20B256C1BFBFD0F01D0028288CAF35")

        public static final Name IMPLEMENTATION_VERSION = new Name("Implementation-Version");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.987 -0400", hash_original_field = "6C66A20FFAB6248B227EB5D0C059805D", hash_generated_field = "E36624A10BCF264F61DB3BBAFEA8FAD3")

        public static final Name IMPLEMENTATION_VENDOR = new Name("Implementation-Vendor");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.987 -0400", hash_original_field = "F07DD5E93416746950BC3A6C6F9F0446", hash_generated_field = "0099497E1C8577AF9FD31121C605C0DB")

        public static final Name SPECIFICATION_TITLE = new Name("Specification-Title");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.988 -0400", hash_original_field = "8F09F8080841D34B1C08F220D0EBA899", hash_generated_field = "6E7EB82C13C6F355851BCE9E50066EC5")

        public static final Name SPECIFICATION_VERSION = new Name("Specification-Version");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.988 -0400", hash_original_field = "EA39AE042F589F51CCA4794589F3F170", hash_generated_field = "EC321A620C6EF412E9F78378365830E5")

        public static final Name SPECIFICATION_VENDOR = new Name("Specification-Vendor");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.988 -0400", hash_original_field = "2407C373B3B745E609B94CDACECAEB31", hash_generated_field = "535B108D1755EC0284B833516A31C73B")

        public static final Name EXTENSION_LIST = new Name("Extension-List");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.988 -0400", hash_original_field = "0A61EA13F72B31A90029E62ECE5D39B3", hash_generated_field = "1B0256904EB520257211ED0319800FD9")

        public static final Name EXTENSION_NAME = new Name("Extension-Name");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.988 -0400", hash_original_field = "03D3DEE73E8B2BD18864FA441ABA9BB5", hash_generated_field = "BB57E13BBE8FADAE2833B96A25E9146B")

        public static final Name EXTENSION_INSTALLATION = new Name("Extension-Installation");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.988 -0400", hash_original_field = "A5231F0A367505C09E7F334CD1536B6C", hash_generated_field = "6100F359EAE657374D589152BD7E0AF2")

        public static final Name IMPLEMENTATION_VENDOR_ID = new Name("Implementation-Vendor-Id");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.988 -0400", hash_original_field = "C110DD9C1B0052E3AB8C5F5C3FF10029", hash_generated_field = "BAFF34A6F6A91D8E54DEE7BBC19A4C8F")

        public static final Name IMPLEMENTATION_URL = new Name("Implementation-URL");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:08.988 -0400", hash_original_field = "741BE91B9B217CFDA1740B6B5815CD02", hash_generated_field = "8391009D03BD383CE126AB69E7C8D390")

        static final Name NAME = new Name("Name");
    }


    
}

