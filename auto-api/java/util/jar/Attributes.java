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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:19:49.637 -0400", hash_original_method = "CDEB7A2340880305C142690108AEFF5F", hash_generated_method = "17D577309293B091F10D2EFA459A3BD1")
    @DSModeled(DSC.SAFE)
    public Attributes() {
        map = new HashMap<Object, Object>();
        // ---------- Original Method ----------
        //map = new HashMap<Object, Object>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:19:49.654 -0400", hash_original_method = "F8717927CC90D5B5AE946AC3A31B19F4", hash_generated_method = "4AA40EE957EAEDB8900DDCC26EDF3A5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public Attributes(Attributes attrib) {
        dsTaint.addTaint(attrib.dsTaint);
        map = (Map<Object, Object>) ((HashMap) attrib.map).clone();
        // ---------- Original Method ----------
        //map = (Map<Object, Object>) ((HashMap) attrib.map).clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:19:49.663 -0400", hash_original_method = "C0A84EEFF5C41531DA971DB0633F74FC", hash_generated_method = "CC91B340545ECE653C4A84D6AB9C3DF3")
    @DSModeled(DSC.SAFE)
    public Attributes(int size) {
        dsTaint.addTaint(size);
        map = new HashMap<Object, Object>(size);
        // ---------- Original Method ----------
        //map = new HashMap<Object, Object>(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:19:49.675 -0400", hash_original_method = "00A8C0F9832A2FA4DDA896013D523229", hash_generated_method = "1FC6C2B09DAE471FABEE5DB06462B906")
    @DSModeled(DSC.SAFE)
    public void clear() {
        map.clear();
        // ---------- Original Method ----------
        //map.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:19:49.686 -0400", hash_original_method = "51FDEF8A21E6EA5E0FB4715F8113FE74", hash_generated_method = "360A8351E596294B807CACDE8E20AF66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsKey(Object key) {
        dsTaint.addTaint(key.dsTaint);
        boolean var56EC89656FCA0EA2E21B790CBA0BA5A2_116802947 = (map.containsKey(key));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return map.containsKey(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:19:49.713 -0400", hash_original_method = "E6B0C93317C0E9F78301AFF4874F2620", hash_generated_method = "0987EF293974B22B92994328BE0DF492")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsValue(Object value) {
        dsTaint.addTaint(value.dsTaint);
        boolean var8DBC5B9FE37AD1D935F8723487462395_1307727054 = (map.containsValue(value));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return map.containsValue(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:19:49.725 -0400", hash_original_method = "2E4A8A9DC4043DAAC1C8FCCBA69D6A6B", hash_generated_method = "CB6DA9B173C64DFA424369B02420325F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<Map.Entry<Object, Object>> entrySet() {
        Set<Map.Entry<Object, Object>> var84DA32A5A57D791E799D00532065D1DC_1873639274 = (map.entrySet());
        return (Set<Map.Entry<Object, Object>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return map.entrySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:19:49.733 -0400", hash_original_method = "C22494F044E1A5B9985D58D15AE531DA", hash_generated_method = "BF02D2B7372429AD170D90E13B0EFA94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object get(Object key) {
        dsTaint.addTaint(key.dsTaint);
        Object var24A27D2286C1D17B4AB70798C0BC1C16_1042298860 = (map.get(key));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return map.get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:19:49.745 -0400", hash_original_method = "193F4487BCC4A9B88FB28866363E7ABF", hash_generated_method = "18FD54DE7B530C34A08148774A1137F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEmpty() {
        boolean var59C8754218A5378301A7B2210B450A8A_2016596093 = (map.isEmpty());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return map.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:19:49.757 -0400", hash_original_method = "F488EE4006E1366E830BF13438F76FA9", hash_generated_method = "3FA2C8B54444D1CCA8D84425FD0F3770")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<Object> keySet() {
        Set<Object> var2BA9CB4917300077B87319058D330CAA_950946070 = (map.keySet());
        return (Set<Object>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return map.keySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:19:49.766 -0400", hash_original_method = "3E157C761E601D752826F2BACE4084FB", hash_generated_method = "081EF7A82C60E6B816ACDBB4A1367A7B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("cast")
    public Object put(Object key, Object value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        Object varE58A2B9C52CD3FAFF4468091B17D14AB_1725010130 = (map.put((Name) key, (String) value));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return map.put((Name) key, (String) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:19:49.775 -0400", hash_original_method = "2F4F3A55CE715E104E0F5EF4690E41E2", hash_generated_method = "E85C79055FA760B6B58007BE7E44FCFA")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:19:49.790 -0400", hash_original_method = "10CAD66DFB71B02C0F278FCC3305EF24", hash_generated_method = "9456BBD2A5CFACA9E1ACF5CBAAF133E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object remove(Object key) {
        dsTaint.addTaint(key.dsTaint);
        Object var8B97B65E44C2FA9E70FEA56ECDEE63A2_945692157 = (map.remove(key));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return map.remove(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:19:49.799 -0400", hash_original_method = "BF2CB7E40375B078820B7350C838FBD6", hash_generated_method = "C2C5976192AB6D5D076A08D3D6D2479A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int size() {
        int var4DE0F18707A7B4B11DB3EB19AE8B9E3C_26555636 = (map.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return map.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:19:49.806 -0400", hash_original_method = "F211D00F0E74ECC7AD7311207A5002DA", hash_generated_method = "D3934F1B6A59CF104CE638A20276BD35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection<Object> values() {
        Collection<Object> var0B34F03CED6C6C56BA989625D11A2671_232369435 = (map.values());
        return (Collection<Object>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return map.values();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:19:49.811 -0400", hash_original_method = "732187D1BBCF1409FB005BFCCDAC70B4", hash_generated_method = "C6EA3F3C8B43F89072C63211AD3765CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    @Override
    public Object clone() {
        Attributes clone;
        try 
        {
            clone = (Attributes) super.clone();
            clone.map = (Map<Object, Object>) ((HashMap) map).clone();
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:19:49.814 -0400", hash_original_method = "A7A7EF5A89DF679FD5CBA963DA8911B6", hash_generated_method = "8CBAD09293BD2A2AD59BDB0C9AF9F02B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var47D635E353BD8FF2F8AAE3D8F795E188_304904552 = (map.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return map.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:19:49.820 -0400", hash_original_method = "E46FF1DB18EE293123D8E2B07FF4B8E9", hash_generated_method = "3491A1F876C9CA5DB4855891BDCB7C2B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        {
            boolean var57993C5006C5AA4D9515F39FCF252F33_73779987 = (map.equals(((Attributes) obj).map));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:19:49.833 -0400", hash_original_method = "738755F264DB023D14F89BE9B353A481", hash_generated_method = "5E88657B17CF7515C6672D46C2BC8EB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getValue(Attributes.Name name) {
        dsTaint.addTaint(name.dsTaint);
        String var169E043417B1FA4D3BB8B44F6E78DA71_637572988 = ((String) map.get(name));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (String) map.get(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:19:49.845 -0400", hash_original_method = "3C8D5071480DE8B5CA7E078D035D576F", hash_generated_method = "88679E5D6827CDFC7793FE33B65F72CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getValue(String name) {
        dsTaint.addTaint(name);
        String var8680BA1325C309A3D2F9C1722A3B9E97_712222622 = ((String) map.get(new Attributes.Name(name)));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (String) map.get(new Attributes.Name(name));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:19:49.853 -0400", hash_original_method = "6F8FF0BC58E7762A3A8A85D431B8F527", hash_generated_method = "091C7F5B92C66EBC409C00FC5807B277")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String putValue(String name, String val) {
        dsTaint.addTaint(val);
        dsTaint.addTaint(name);
        String var78D0EFCBBAD8C3AF5D000D4C8D22D937_1191527040 = ((String) map.put(new Attributes.Name(name), val));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (String) map.put(new Attributes.Name(name), val);
    }

    
    public static class Name {
        private String name;
        public static Name CLASS_PATH = new Name("Class-Path");
        public static Name MANIFEST_VERSION = new Name("Manifest-Version");
        public static Name MAIN_CLASS = new Name("Main-Class");
        public static Name SIGNATURE_VERSION = new Name("Signature-Version");
        public static Name CONTENT_TYPE = new Name("Content-Type");
        public static Name SEALED = new Name("Sealed");
        public static Name IMPLEMENTATION_TITLE = new Name("Implementation-Title");
        public static Name IMPLEMENTATION_VERSION = new Name("Implementation-Version");
        public static Name IMPLEMENTATION_VENDOR = new Name("Implementation-Vendor");
        public static Name SPECIFICATION_TITLE = new Name("Specification-Title");
        public static Name SPECIFICATION_VERSION = new Name("Specification-Version");
        public static Name SPECIFICATION_VENDOR = new Name("Specification-Vendor");
        public static Name EXTENSION_LIST = new Name("Extension-List");
        public static Name EXTENSION_NAME = new Name("Extension-Name");
        public static Name EXTENSION_INSTALLATION = new Name("Extension-Installation");
        public static Name IMPLEMENTATION_VENDOR_ID = new Name("Implementation-Vendor-Id");
        public static Name IMPLEMENTATION_URL = new Name("Implementation-URL");
        static Name NAME = new Name("Name");
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:19:49.873 -0400", hash_original_method = "2C39DBA2C28891B792407C3858FAD7FB", hash_generated_method = "9DDDB51EFC2C59C2DA01EADFAF5C3EA8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Name(String name) {
            dsTaint.addTaint(name);
            {
                boolean var3039A75A9646F316597EFD01ED473C47_1352037904 = (name.isEmpty() || name.length() > Manifest.LINE_LENGTH_LIMIT - 2);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(name);
                } //End block
            } //End collapsed parenthetic
            {
                int i;
                i = 0;
                boolean var1F2EC7F747FAC8CE2816F0A3129E8B5A_1452895416 = (i < name.length());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:19:49.886 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "7648E8371A667C3DD3DBD4EB30F68680")
        @DSModeled(DSC.SAFE)
         String getName() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return name;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:19:49.894 -0400", hash_original_method = "44A371BEEBBEF1D1024A1D234C6B6AC2", hash_generated_method = "AE1A98856FC8FA860970D968EDBE8BB9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean varF196A190D6309E1ED2D9525863B835DA_1735249875 = (object instanceof Name
                    && ((Name) object).name.equalsIgnoreCase(name));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return object instanceof Name
                    //&& ((Name) object).name.equalsIgnoreCase(name);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:19:49.901 -0400", hash_original_method = "9402BF4C103D69D49EBD5DEF399C9512", hash_generated_method = "908B7C89379477822412DAD849F56D93")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int var1240F838C135D2DA5C9C4C723AEA7518_857283369 = (name.toLowerCase(Locale.US).hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return name.toLowerCase(Locale.US).hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:19:49.909 -0400", hash_original_method = "0EB66BA5E965B83E191719250E0A82FF", hash_generated_method = "61033FF7128FD0D2C124C7BC4289F7A2")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return name;
        }

        
    }


    
}


