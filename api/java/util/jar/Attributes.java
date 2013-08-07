package java.util.jar;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;






public class Attributes implements Cloneable, Map<Object, Object> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.649 -0400", hash_original_field = "1D78DC8ED51214E518B5114FE24490AE", hash_generated_field = "469DC0A3DDAB50D1A339FF08EE199F5C")

    protected Map<Object, Object> map;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.650 -0400", hash_original_method = "CDEB7A2340880305C142690108AEFF5F", hash_generated_method = "9872D14EC462B5E29026E6B7277BD8A7")
    public  Attributes() {
        map = new HashMap<Object, Object>();
        // ---------- Original Method ----------
        //map = new HashMap<Object, Object>();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.651 -0400", hash_original_method = "F8717927CC90D5B5AE946AC3A31B19F4", hash_generated_method = "FBDA935B9A3831C52372D161FF350F6C")
    @SuppressWarnings("unchecked")
    public  Attributes(Attributes attrib) {
        map = (Map<Object, Object>) ((HashMap) attrib.map).clone();
        // ---------- Original Method ----------
        //map = (Map<Object, Object>) ((HashMap) attrib.map).clone();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.652 -0400", hash_original_method = "C0A84EEFF5C41531DA971DB0633F74FC", hash_generated_method = "792E69047F9763844FF159A7272D0CD4")
    public  Attributes(int size) {
        map = new HashMap<Object, Object>(size);
        // ---------- Original Method ----------
        //map = new HashMap<Object, Object>(size);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.652 -0400", hash_original_method = "00A8C0F9832A2FA4DDA896013D523229", hash_generated_method = "2A83EDB450FE64133FB4489A062A886E")
    public void clear() {
        map.clear();
        // ---------- Original Method ----------
        //map.clear();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.653 -0400", hash_original_method = "51FDEF8A21E6EA5E0FB4715F8113FE74", hash_generated_method = "63FCDFA29B77A6A6B2E75283F616DD9F")
    public boolean containsKey(Object key) {
        addTaint(key.getTaint());
        boolean var1F5C7C829096E4FDB1A63A2E9D4DD6A2_566812705 = (map.containsKey(key));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_578749272 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_578749272;
        // ---------- Original Method ----------
        //return map.containsKey(key);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.653 -0400", hash_original_method = "E6B0C93317C0E9F78301AFF4874F2620", hash_generated_method = "ECBA0394065A3E84032DF933C80CED72")
    public boolean containsValue(Object value) {
        addTaint(value.getTaint());
        boolean var439CD853F6BCC3FF03C1D84B0BD65A51_490034694 = (map.containsValue(value));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1322533889 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1322533889;
        // ---------- Original Method ----------
        //return map.containsValue(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.654 -0400", hash_original_method = "2E4A8A9DC4043DAAC1C8FCCBA69D6A6B", hash_generated_method = "610053F0AD70D4BAEE4CE09BCEEE3912")
    public Set<Map.Entry<Object, Object>> entrySet() {
Set<Map.Entry<Object, Object>> varD70A818A9C24919C79B0A6854ED78BA4_1217075562 =         map.entrySet();
        varD70A818A9C24919C79B0A6854ED78BA4_1217075562.addTaint(taint);
        return varD70A818A9C24919C79B0A6854ED78BA4_1217075562;
        // ---------- Original Method ----------
        //return map.entrySet();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.654 -0400", hash_original_method = "C22494F044E1A5B9985D58D15AE531DA", hash_generated_method = "4E8761B11250AC8028AF45E07BCEAEF1")
    public Object get(Object key) {
        addTaint(key.getTaint());
Object var97156AACD411ADC83FECC30C065B5B0C_1486760136 =         map.get(key);
        var97156AACD411ADC83FECC30C065B5B0C_1486760136.addTaint(taint);
        return var97156AACD411ADC83FECC30C065B5B0C_1486760136;
        // ---------- Original Method ----------
        //return map.get(key);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.655 -0400", hash_original_method = "193F4487BCC4A9B88FB28866363E7ABF", hash_generated_method = "A88AEB8BCAD82F23C11CF539155105C8")
    public boolean isEmpty() {
        boolean varAF143B23ABB0913809523AA7F6DBE946_1852663471 = (map.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_159190384 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_159190384;
        // ---------- Original Method ----------
        //return map.isEmpty();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.655 -0400", hash_original_method = "F488EE4006E1366E830BF13438F76FA9", hash_generated_method = "DA20EEAB16B6AD814FCB2266B98A9E59")
    public Set<Object> keySet() {
Set<Object> varD036BF304D6CB28B6C4DC52E35289E2B_1985497695 =         map.keySet();
        varD036BF304D6CB28B6C4DC52E35289E2B_1985497695.addTaint(taint);
        return varD036BF304D6CB28B6C4DC52E35289E2B_1985497695;
        // ---------- Original Method ----------
        //return map.keySet();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.655 -0400", hash_original_method = "3E157C761E601D752826F2BACE4084FB", hash_generated_method = "8EECC3871A1E78C1ABB46020F23E7E5A")
    @SuppressWarnings("cast")
    public Object put(Object key, Object value) {
        addTaint(value.getTaint());
        addTaint(key.getTaint());
Object var540AD09702F21E0DC7D07F749BDCE47C_1573375351 =         map.put((Name) key, (String) value);
        var540AD09702F21E0DC7D07F749BDCE47C_1573375351.addTaint(taint);
        return var540AD09702F21E0DC7D07F749BDCE47C_1573375351;
        // ---------- Original Method ----------
        //return map.put((Name) key, (String) value);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.656 -0400", hash_original_method = "2F4F3A55CE715E104E0F5EF4690E41E2", hash_generated_method = "496DE9955B5C2CA408E4B6F2536E2DBB")
    public void putAll(Map<?, ?> attrib) {
        addTaint(attrib.getTaint());
        if(attrib == null || !(attrib instanceof Attributes))        
        {
            ClassCastException var45476E68D56EDA2334E90E6F67317EA0_506884844 = new ClassCastException(attrib.getClass().getName() + " not an Attributes");
            var45476E68D56EDA2334E90E6F67317EA0_506884844.addTaint(taint);
            throw var45476E68D56EDA2334E90E6F67317EA0_506884844;
        } //End block
        this.map.putAll(attrib);
        // ---------- Original Method ----------
        //if (attrib == null || !(attrib instanceof Attributes)) {
            //throw new ClassCastException(attrib.getClass().getName() + " not an Attributes");
        //}
        //this.map.putAll(attrib);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.657 -0400", hash_original_method = "10CAD66DFB71B02C0F278FCC3305EF24", hash_generated_method = "5E2C6DFF5D7868992EFB2908E1115BBB")
    public Object remove(Object key) {
        addTaint(key.getTaint());
Object var680816A9C90635BE8F543A56792CAAE8_905735408 =         map.remove(key);
        var680816A9C90635BE8F543A56792CAAE8_905735408.addTaint(taint);
        return var680816A9C90635BE8F543A56792CAAE8_905735408;
        // ---------- Original Method ----------
        //return map.remove(key);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.657 -0400", hash_original_method = "BF2CB7E40375B078820B7350C838FBD6", hash_generated_method = "96B83BBCF323601F5EB16202941CE6D1")
    public int size() {
        int var9EF85AA9C38E3AED298A540215786760_1771930327 = (map.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_337528176 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_337528176;
        // ---------- Original Method ----------
        //return map.size();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.658 -0400", hash_original_method = "F211D00F0E74ECC7AD7311207A5002DA", hash_generated_method = "2F2043C60F7B8A23AE513A2986EF266A")
    public Collection<Object> values() {
Collection<Object> varB1189193566E908C8B007DC3A156A222_400258177 =         map.values();
        varB1189193566E908C8B007DC3A156A222_400258177.addTaint(taint);
        return varB1189193566E908C8B007DC3A156A222_400258177;
        // ---------- Original Method ----------
        //return map.values();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.659 -0400", hash_original_method = "732187D1BBCF1409FB005BFCCDAC70B4", hash_generated_method = "F6893633807BFC6EB9BCD7AB41DBF67B")
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
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_1859313092 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_1859313092.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_1859313092;
        } //End block
        clone.map = (Map<Object, Object>) ((HashMap) map).clone();
Object var3DE52045BFD3C1BF3742F994ED6139AD_813470351 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_813470351.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_813470351;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.659 -0400", hash_original_method = "A7A7EF5A89DF679FD5CBA963DA8911B6", hash_generated_method = "F2B7FDD4EB6FD7F37E3584A2436F827D")
    @Override
    public int hashCode() {
        int varC94DBB9331A8D72EEBD79AF259A34547_1415119699 = (map.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1555953402 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1555953402;
        // ---------- Original Method ----------
        //return map.hashCode();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.660 -0400", hash_original_method = "E46FF1DB18EE293123D8E2B07FF4B8E9", hash_generated_method = "8BE422C48AB03BE6B70F461209BB8C2B")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
        if(this == obj)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1146718115 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1551993846 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1551993846;
        } //End block
        if(obj instanceof Attributes)        
        {
            boolean varC01685827E78F37873C34261BC3E68F6_366210968 = (map.equals(((Attributes) obj).map));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_574685674 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_574685674;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_520446876 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1162963927 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1162963927;
        // ---------- Original Method ----------
        //if (this == obj) {
            //return true;
        //}
        //if (obj instanceof Attributes) {
            //return map.equals(((Attributes) obj).map);
        //}
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.660 -0400", hash_original_method = "738755F264DB023D14F89BE9B353A481", hash_generated_method = "3BBF3512D7E6B7DE3B3B0B8845F129FB")
    public String getValue(Attributes.Name name) {
        addTaint(name.getTaint());
String var2E56F82900FE3F9ECDBE35DB44E1DAF4_1034077420 =         (String) map.get(name);
        var2E56F82900FE3F9ECDBE35DB44E1DAF4_1034077420.addTaint(taint);
        return var2E56F82900FE3F9ECDBE35DB44E1DAF4_1034077420;
        // ---------- Original Method ----------
        //return (String) map.get(name);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.660 -0400", hash_original_method = "3C8D5071480DE8B5CA7E078D035D576F", hash_generated_method = "DBD7985AFF50C842E5C3753E2F91D0F0")
    public String getValue(String name) {
        addTaint(name.getTaint());
String varE63798A4C2D0AE7AF0DFDFCE98FBDD8C_711137164 =         (String) map.get(new Attributes.Name(name));
        varE63798A4C2D0AE7AF0DFDFCE98FBDD8C_711137164.addTaint(taint);
        return varE63798A4C2D0AE7AF0DFDFCE98FBDD8C_711137164;
        // ---------- Original Method ----------
        //return (String) map.get(new Attributes.Name(name));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.661 -0400", hash_original_method = "6F8FF0BC58E7762A3A8A85D431B8F527", hash_generated_method = "64F94D9577076C3612C83E716812FF0A")
    public String putValue(String name, String val) {
        addTaint(val.getTaint());
        addTaint(name.getTaint());
String var47CC551B40DEE7AD31FE1F527336EAD6_429501642 =         (String) map.put(new Attributes.Name(name), val);
        var47CC551B40DEE7AD31FE1F527336EAD6_429501642.addTaint(taint);
        return var47CC551B40DEE7AD31FE1F527336EAD6_429501642;
        // ---------- Original Method ----------
        //return (String) map.put(new Attributes.Name(name), val);
    }

    
    public static class Name {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.661 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

        private String name;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.662 -0400", hash_original_method = "2C39DBA2C28891B792407C3858FAD7FB", hash_generated_method = "FD89974B369A265093D0B4A802933DED")
        public  Name(String name) {
            if(name.isEmpty() || name.length() > Manifest.LINE_LENGTH_LIMIT - 2)            
            {
                IllegalArgumentException varBF6A5C454ED01F0F986515C3E9A9CEA3_1940327770 = new IllegalArgumentException(name);
                varBF6A5C454ED01F0F986515C3E9A9CEA3_1940327770.addTaint(taint);
                throw varBF6A5C454ED01F0F986515C3E9A9CEA3_1940327770;
            } //End block
for(int i = 0;i < name.length();i++)
            {
                char ch = name.charAt(i);
                if(!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')
                        || ch == '_' || ch == '-' || (ch >= '0' && ch <= '9')))                
                {
                    IllegalArgumentException varBF6A5C454ED01F0F986515C3E9A9CEA3_2008822039 = new IllegalArgumentException(name);
                    varBF6A5C454ED01F0F986515C3E9A9CEA3_2008822039.addTaint(taint);
                    throw varBF6A5C454ED01F0F986515C3E9A9CEA3_2008822039;
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.662 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "DAC848BA5EF8972E7F4E134F35D4B820")
         String getName() {
String varB017984728AC60AD1F0BF8734F33F15C_1324638910 =             name;
            varB017984728AC60AD1F0BF8734F33F15C_1324638910.addTaint(taint);
            return varB017984728AC60AD1F0BF8734F33F15C_1324638910;
            // ---------- Original Method ----------
            //return name;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.662 -0400", hash_original_method = "44A371BEEBBEF1D1024A1D234C6B6AC2", hash_generated_method = "F72F813347ABFF0CA7E9D523B3D8F3E1")
        @Override
        public boolean equals(Object object) {
            addTaint(object.getTaint());
            boolean var0B0C83673CD6DA72C387BCCCD437C33E_2011039192 = (object instanceof Name
                    && ((Name) object).name.equalsIgnoreCase(name));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_21703688 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_21703688;
            // ---------- Original Method ----------
            //return object instanceof Name
                    //&& ((Name) object).name.equalsIgnoreCase(name);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.663 -0400", hash_original_method = "9402BF4C103D69D49EBD5DEF399C9512", hash_generated_method = "E4C40164EB32D2446DDFEE243FEEE8AA")
        @Override
        public int hashCode() {
            int var910918074D2BC8F23BE146DE9B492887_665354635 = (name.toLowerCase(Locale.US).hashCode());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1306250379 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1306250379;
            // ---------- Original Method ----------
            //return name.toLowerCase(Locale.US).hashCode();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.663 -0400", hash_original_method = "0EB66BA5E965B83E191719250E0A82FF", hash_generated_method = "91A1C9EF38197F837E4145DE67F11367")
        @Override
        public String toString() {
String varB017984728AC60AD1F0BF8734F33F15C_1360351339 =             name;
            varB017984728AC60AD1F0BF8734F33F15C_1360351339.addTaint(taint);
            return varB017984728AC60AD1F0BF8734F33F15C_1360351339;
            // ---------- Original Method ----------
            //return name;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.663 -0400", hash_original_field = "7BAFCE84B42A5DA731B6634CC5FFAA45", hash_generated_field = "0B9661DEBA6285ADE4666B79ED38B94B")

        public static final Name CLASS_PATH = new Name("Class-Path");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.663 -0400", hash_original_field = "979A4FE6383FAD6E47B386693779A210", hash_generated_field = "C6B4E6E9D8E48CDF5401ED1A54EC60FF")

        public static final Name MANIFEST_VERSION = new Name("Manifest-Version");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.663 -0400", hash_original_field = "71B9F9ED4173CDF4D0BD9346348BDB4C", hash_generated_field = "5BAA3B0F29B5D6B421C14C179438EFAB")

        public static final Name MAIN_CLASS = new Name("Main-Class");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.664 -0400", hash_original_field = "9EDA43684D8154E3F290DF07AB8508DC", hash_generated_field = "F2F620E8615802A3D89525207F39FBA8")

        public static final Name SIGNATURE_VERSION = new Name("Signature-Version");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.664 -0400", hash_original_field = "5AC651DCF0FF8BA1281471C3D56B1415", hash_generated_field = "D2DC98BAC7E8C22DC2E0EB2EFB820BE5")

        public static final Name CONTENT_TYPE = new Name("Content-Type");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.664 -0400", hash_original_field = "B307531EFBF862D6D2682AF1C5A81B78", hash_generated_field = "169C8F071E808A4124C933174D669007")

        public static final Name SEALED = new Name("Sealed");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.664 -0400", hash_original_field = "1CD7EAEF9F246BA6BCCEADEF2F9C8766", hash_generated_field = "A498C8F3B78053FB6A1D636DAD36FB03")

        public static final Name IMPLEMENTATION_TITLE = new Name("Implementation-Title");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.664 -0400", hash_original_field = "A4E6C113BB6D25458D812355FF1A4C4A", hash_generated_field = "AD20B256C1BFBFD0F01D0028288CAF35")

        public static final Name IMPLEMENTATION_VERSION = new Name("Implementation-Version");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.664 -0400", hash_original_field = "6C66A20FFAB6248B227EB5D0C059805D", hash_generated_field = "E36624A10BCF264F61DB3BBAFEA8FAD3")

        public static final Name IMPLEMENTATION_VENDOR = new Name("Implementation-Vendor");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.664 -0400", hash_original_field = "F07DD5E93416746950BC3A6C6F9F0446", hash_generated_field = "0099497E1C8577AF9FD31121C605C0DB")

        public static final Name SPECIFICATION_TITLE = new Name("Specification-Title");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.664 -0400", hash_original_field = "8F09F8080841D34B1C08F220D0EBA899", hash_generated_field = "6E7EB82C13C6F355851BCE9E50066EC5")

        public static final Name SPECIFICATION_VERSION = new Name("Specification-Version");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.664 -0400", hash_original_field = "EA39AE042F589F51CCA4794589F3F170", hash_generated_field = "EC321A620C6EF412E9F78378365830E5")

        public static final Name SPECIFICATION_VENDOR = new Name("Specification-Vendor");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.664 -0400", hash_original_field = "2407C373B3B745E609B94CDACECAEB31", hash_generated_field = "535B108D1755EC0284B833516A31C73B")

        public static final Name EXTENSION_LIST = new Name("Extension-List");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.664 -0400", hash_original_field = "0A61EA13F72B31A90029E62ECE5D39B3", hash_generated_field = "1B0256904EB520257211ED0319800FD9")

        public static final Name EXTENSION_NAME = new Name("Extension-Name");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.664 -0400", hash_original_field = "03D3DEE73E8B2BD18864FA441ABA9BB5", hash_generated_field = "BB57E13BBE8FADAE2833B96A25E9146B")

        public static final Name EXTENSION_INSTALLATION = new Name("Extension-Installation");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.664 -0400", hash_original_field = "A5231F0A367505C09E7F334CD1536B6C", hash_generated_field = "6100F359EAE657374D589152BD7E0AF2")

        public static final Name IMPLEMENTATION_VENDOR_ID = new Name("Implementation-Vendor-Id");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.664 -0400", hash_original_field = "C110DD9C1B0052E3AB8C5F5C3FF10029", hash_generated_field = "BAFF34A6F6A91D8E54DEE7BBC19A4C8F")

        public static final Name IMPLEMENTATION_URL = new Name("Implementation-URL");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:15.665 -0400", hash_original_field = "741BE91B9B217CFDA1740B6B5815CD02", hash_generated_field = "8391009D03BD383CE126AB69E7C8D390")

        static final Name NAME = new Name("Name");
    }


    
}

