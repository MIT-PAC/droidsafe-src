package java.util.jar;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class Attributes implements Cloneable, Map<Object, Object> {
    protected Map<Object, Object> map;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.279 -0400", hash_original_method = "CDEB7A2340880305C142690108AEFF5F", hash_generated_method = "9872D14EC462B5E29026E6B7277BD8A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Attributes() {
        map = new HashMap<Object, Object>();
        // ---------- Original Method ----------
        //map = new HashMap<Object, Object>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.280 -0400", hash_original_method = "F8717927CC90D5B5AE946AC3A31B19F4", hash_generated_method = "3F5265905D4779680DBA946C43165F67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public Attributes(Attributes attrib) {
        dsTaint.addTaint(attrib.dsTaint);
        map = (Map<Object, Object>) ((HashMap) attrib.map).clone();
        // ---------- Original Method ----------
        //map = (Map<Object, Object>) ((HashMap) attrib.map).clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.280 -0400", hash_original_method = "C0A84EEFF5C41531DA971DB0633F74FC", hash_generated_method = "404F84BD576F8F1A215A2C37101EEF5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Attributes(int size) {
        dsTaint.addTaint(size);
        map = new HashMap<Object, Object>(size);
        // ---------- Original Method ----------
        //map = new HashMap<Object, Object>(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.280 -0400", hash_original_method = "00A8C0F9832A2FA4DDA896013D523229", hash_generated_method = "2A83EDB450FE64133FB4489A062A886E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clear() {
        map.clear();
        // ---------- Original Method ----------
        //map.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.280 -0400", hash_original_method = "51FDEF8A21E6EA5E0FB4715F8113FE74", hash_generated_method = "D1EE7A669AAECAB1D33A6DE831F56352")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsKey(Object key) {
        dsTaint.addTaint(key.dsTaint);
        boolean var56EC89656FCA0EA2E21B790CBA0BA5A2_1449579631 = (map.containsKey(key));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return map.containsKey(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.281 -0400", hash_original_method = "E6B0C93317C0E9F78301AFF4874F2620", hash_generated_method = "7E43D0A233168E23EC778D20E4FB7664")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsValue(Object value) {
        dsTaint.addTaint(value.dsTaint);
        boolean var8DBC5B9FE37AD1D935F8723487462395_1269480785 = (map.containsValue(value));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return map.containsValue(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.281 -0400", hash_original_method = "2E4A8A9DC4043DAAC1C8FCCBA69D6A6B", hash_generated_method = "1C00DD03C48A62DE2E45E095EB8F9439")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<Map.Entry<Object, Object>> entrySet() {
        Set<Map.Entry<Object, Object>> var84DA32A5A57D791E799D00532065D1DC_671330643 = (map.entrySet());
        return (Set<Map.Entry<Object, Object>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return map.entrySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.281 -0400", hash_original_method = "C22494F044E1A5B9985D58D15AE531DA", hash_generated_method = "ED67889B4B9066A9CF3783F8E40A1D22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object get(Object key) {
        dsTaint.addTaint(key.dsTaint);
        Object var24A27D2286C1D17B4AB70798C0BC1C16_153995951 = (map.get(key));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return map.get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.281 -0400", hash_original_method = "193F4487BCC4A9B88FB28866363E7ABF", hash_generated_method = "CB6732A3B0678FD755070E927DEB4B82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEmpty() {
        boolean var59C8754218A5378301A7B2210B450A8A_204066149 = (map.isEmpty());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return map.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.281 -0400", hash_original_method = "F488EE4006E1366E830BF13438F76FA9", hash_generated_method = "02558112BD582BD4EE8EEF9C94797D0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<Object> keySet() {
        Set<Object> var2BA9CB4917300077B87319058D330CAA_1426370618 = (map.keySet());
        return (Set<Object>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return map.keySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.281 -0400", hash_original_method = "3E157C761E601D752826F2BACE4084FB", hash_generated_method = "FD74C0609EC3A5CC8A1C526A6ED15E41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("cast")
    public Object put(Object key, Object value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        Object varE58A2B9C52CD3FAFF4468091B17D14AB_1594860315 = (map.put((Name) key, (String) value));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return map.put((Name) key, (String) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.282 -0400", hash_original_method = "2F4F3A55CE715E104E0F5EF4690E41E2", hash_generated_method = "28481080C1ACC5EBC17F20D197D6D2A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void putAll(Map<?, ?> attrib) {
        dsTaint.addTaint(attrib.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new ClassCastException(attrib.getClass().getName() + " not an Attributes");
        } //End block
        this.map.putAll(attrib);
        // ---------- Original Method ----------
        //if (attrib == null || !(attrib instanceof Attributes)) {
            //throw new ClassCastException(attrib.getClass().getName() + " not an Attributes");
        //}
        //this.map.putAll(attrib);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.282 -0400", hash_original_method = "10CAD66DFB71B02C0F278FCC3305EF24", hash_generated_method = "700369FF7176E453C81F36330354C487")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object remove(Object key) {
        dsTaint.addTaint(key.dsTaint);
        Object var8B97B65E44C2FA9E70FEA56ECDEE63A2_1626449150 = (map.remove(key));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return map.remove(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.282 -0400", hash_original_method = "BF2CB7E40375B078820B7350C838FBD6", hash_generated_method = "7B71F0B7113CA82C4EAE633258F887AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int size() {
        int var4DE0F18707A7B4B11DB3EB19AE8B9E3C_2007401811 = (map.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return map.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.282 -0400", hash_original_method = "F211D00F0E74ECC7AD7311207A5002DA", hash_generated_method = "C7AB8CEF15D3049287985FC833D55B58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection<Object> values() {
        Collection<Object> var0B34F03CED6C6C56BA989625D11A2671_1028670146 = (map.values());
        return (Collection<Object>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return map.values();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.283 -0400", hash_original_method = "732187D1BBCF1409FB005BFCCDAC70B4", hash_generated_method = "6C2B68C38C576BD31AE863ECF749C4D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        clone.map = (Map<Object, Object>) ((HashMap) map).clone();
        return (Object)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.283 -0400", hash_original_method = "A7A7EF5A89DF679FD5CBA963DA8911B6", hash_generated_method = "EAF71D009F87855EAE93BF3A7CF32142")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var47D635E353BD8FF2F8AAE3D8F795E188_533496957 = (map.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return map.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.283 -0400", hash_original_method = "E46FF1DB18EE293123D8E2B07FF4B8E9", hash_generated_method = "36E16D8E1FD758ECEDA6905F71887B4B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        {
            boolean var57993C5006C5AA4D9515F39FCF252F33_1614518907 = (map.equals(((Attributes) obj).map));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (this == obj) {
            //return true;
        //}
        //if (obj instanceof Attributes) {
            //return map.equals(((Attributes) obj).map);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.283 -0400", hash_original_method = "738755F264DB023D14F89BE9B353A481", hash_generated_method = "A4F6811126785D62A6D56BFE6F69DDF5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getValue(Attributes.Name name) {
        dsTaint.addTaint(name.dsTaint);
        String var169E043417B1FA4D3BB8B44F6E78DA71_1325177421 = ((String) map.get(name));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (String) map.get(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.283 -0400", hash_original_method = "3C8D5071480DE8B5CA7E078D035D576F", hash_generated_method = "FCA5276A7E87FB1C6FC3D2F1091E7AC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getValue(String name) {
        dsTaint.addTaint(name);
        String var8680BA1325C309A3D2F9C1722A3B9E97_594053828 = ((String) map.get(new Attributes.Name(name)));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (String) map.get(new Attributes.Name(name));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.284 -0400", hash_original_method = "6F8FF0BC58E7762A3A8A85D431B8F527", hash_generated_method = "710DCE09F4F631FE5C21BFE3809509EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String putValue(String name, String val) {
        dsTaint.addTaint(val);
        dsTaint.addTaint(name);
        String var78D0EFCBBAD8C3AF5D000D4C8D22D937_198816495 = ((String) map.put(new Attributes.Name(name), val));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (String) map.put(new Attributes.Name(name), val);
    }

    
    public static class Name {
        private String name;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.284 -0400", hash_original_method = "2C39DBA2C28891B792407C3858FAD7FB", hash_generated_method = "E61FA72AAAB0624CC62774CFFB827E2A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Name(String name) {
            dsTaint.addTaint(name);
            {
                boolean var3039A75A9646F316597EFD01ED473C47_1344440468 = (name.isEmpty() || name.length() > Manifest.LINE_LENGTH_LIMIT - 2);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(name);
                } //End block
            } //End collapsed parenthetic
            {
                int i;
                i = 0;
                boolean var1F2EC7F747FAC8CE2816F0A3129E8B5A_1549487996 = (i < name.length());
                {
                    char ch;
                    ch = name.charAt(i);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(name);
                    } //End block
                } //End block
            } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.284 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "E1E71CF05D8B42ED0C089D1A76AFEE5E")
        @DSModeled(DSC.SAFE)
         String getName() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return name;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.285 -0400", hash_original_method = "44A371BEEBBEF1D1024A1D234C6B6AC2", hash_generated_method = "CD14910B714F2334363BA5EC37412C32")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean varF196A190D6309E1ED2D9525863B835DA_2123332996 = (object instanceof Name
                    && ((Name) object).name.equalsIgnoreCase(name));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return object instanceof Name
                    //&& ((Name) object).name.equalsIgnoreCase(name);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.285 -0400", hash_original_method = "9402BF4C103D69D49EBD5DEF399C9512", hash_generated_method = "EFDF132880B7E35C1E976A5A48189C9A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int var1240F838C135D2DA5C9C4C723AEA7518_1201141954 = (name.toLowerCase(Locale.US).hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return name.toLowerCase(Locale.US).hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.285 -0400", hash_original_method = "0EB66BA5E965B83E191719250E0A82FF", hash_generated_method = "07B6DEDCDA0BCBF94ECA7AFA0C3C49FD")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return name;
        }

        
        public static final Name CLASS_PATH = new Name("Class-Path");
        public static final Name MANIFEST_VERSION = new Name("Manifest-Version");
        public static final Name MAIN_CLASS = new Name("Main-Class");
        public static final Name SIGNATURE_VERSION = new Name("Signature-Version");
        public static final Name CONTENT_TYPE = new Name("Content-Type");
        public static final Name SEALED = new Name("Sealed");
        public static final Name IMPLEMENTATION_TITLE = new Name("Implementation-Title");
        public static final Name IMPLEMENTATION_VERSION = new Name("Implementation-Version");
        public static final Name IMPLEMENTATION_VENDOR = new Name("Implementation-Vendor");
        public static final Name SPECIFICATION_TITLE = new Name("Specification-Title");
        public static final Name SPECIFICATION_VERSION = new Name("Specification-Version");
        public static final Name SPECIFICATION_VENDOR = new Name("Specification-Vendor");
        public static final Name EXTENSION_LIST = new Name("Extension-List");
        public static final Name EXTENSION_NAME = new Name("Extension-Name");
        public static final Name EXTENSION_INSTALLATION = new Name("Extension-Installation");
        public static final Name IMPLEMENTATION_VENDOR_ID = new Name("Implementation-Vendor-Id");
        public static final Name IMPLEMENTATION_URL = new Name("Implementation-URL");
        static final Name NAME = new Name("Name");
    }


    
}

