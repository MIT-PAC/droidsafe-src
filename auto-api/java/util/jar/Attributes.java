package java.util.jar;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class Attributes implements Cloneable, Map<Object, Object> {
    protected Map<Object, Object> map;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.456 -0400", hash_original_method = "CDEB7A2340880305C142690108AEFF5F", hash_generated_method = "17D577309293B091F10D2EFA459A3BD1")
    @DSModeled(DSC.SAFE)
    public Attributes() {
        map = new HashMap<Object, Object>();
        // ---------- Original Method ----------
        //map = new HashMap<Object, Object>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.456 -0400", hash_original_method = "F8717927CC90D5B5AE946AC3A31B19F4", hash_generated_method = "4AA40EE957EAEDB8900DDCC26EDF3A5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public Attributes(Attributes attrib) {
        dsTaint.addTaint(attrib.dsTaint);
        map = (Map<Object, Object>) ((HashMap) attrib.map).clone();
        // ---------- Original Method ----------
        //map = (Map<Object, Object>) ((HashMap) attrib.map).clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.456 -0400", hash_original_method = "C0A84EEFF5C41531DA971DB0633F74FC", hash_generated_method = "CC91B340545ECE653C4A84D6AB9C3DF3")
    @DSModeled(DSC.SAFE)
    public Attributes(int size) {
        dsTaint.addTaint(size);
        map = new HashMap<Object, Object>(size);
        // ---------- Original Method ----------
        //map = new HashMap<Object, Object>(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.456 -0400", hash_original_method = "00A8C0F9832A2FA4DDA896013D523229", hash_generated_method = "1FC6C2B09DAE471FABEE5DB06462B906")
    @DSModeled(DSC.SAFE)
    public void clear() {
        map.clear();
        // ---------- Original Method ----------
        //map.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.456 -0400", hash_original_method = "51FDEF8A21E6EA5E0FB4715F8113FE74", hash_generated_method = "09C17F4C712700713364825422C32FC6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsKey(Object key) {
        dsTaint.addTaint(key.dsTaint);
        boolean var56EC89656FCA0EA2E21B790CBA0BA5A2_480548994 = (map.containsKey(key));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return map.containsKey(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.456 -0400", hash_original_method = "E6B0C93317C0E9F78301AFF4874F2620", hash_generated_method = "B09C73C7F90D165DC5DB1C29C8D126FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsValue(Object value) {
        dsTaint.addTaint(value.dsTaint);
        boolean var8DBC5B9FE37AD1D935F8723487462395_1571303502 = (map.containsValue(value));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return map.containsValue(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.456 -0400", hash_original_method = "2E4A8A9DC4043DAAC1C8FCCBA69D6A6B", hash_generated_method = "96511BE3D492D7BF34DB261D9DC3E8CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<Map.Entry<Object, Object>> entrySet() {
        Set<Map.Entry<Object, Object>> var84DA32A5A57D791E799D00532065D1DC_1718884068 = (map.entrySet());
        return (Set<Map.Entry<Object, Object>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return map.entrySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.456 -0400", hash_original_method = "C22494F044E1A5B9985D58D15AE531DA", hash_generated_method = "3095993587990189C853EFC688B62767")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object get(Object key) {
        dsTaint.addTaint(key.dsTaint);
        Object var24A27D2286C1D17B4AB70798C0BC1C16_366621472 = (map.get(key));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return map.get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.456 -0400", hash_original_method = "193F4487BCC4A9B88FB28866363E7ABF", hash_generated_method = "6511EA754D82483D1EC25BCCC2F66AD6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEmpty() {
        boolean var59C8754218A5378301A7B2210B450A8A_2015676999 = (map.isEmpty());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return map.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.456 -0400", hash_original_method = "F488EE4006E1366E830BF13438F76FA9", hash_generated_method = "0C34B5B45366977F1A3DF687557CD224")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<Object> keySet() {
        Set<Object> var2BA9CB4917300077B87319058D330CAA_714125424 = (map.keySet());
        return (Set<Object>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return map.keySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.456 -0400", hash_original_method = "3E157C761E601D752826F2BACE4084FB", hash_generated_method = "B6C1E4A1C1BF70D904CDFAAA99ED3C2C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("cast")
    public Object put(Object key, Object value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        Object varE58A2B9C52CD3FAFF4468091B17D14AB_673217587 = (map.put((Name) key, (String) value));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return map.put((Name) key, (String) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.456 -0400", hash_original_method = "2F4F3A55CE715E104E0F5EF4690E41E2", hash_generated_method = "52BFF2CFCE7DD3AD12A2FAE858539BA8")
    @DSModeled(DSC.SAFE)
    public void putAll(Map<?, ?> attrib) {
        dsTaint.addTaint(attrib.dsTaint);
        {
            throw new ClassCastException(attrib.getClass().getName() + " not an Attributes");
        } //End block
        this.map.putAll(attrib);
        // ---------- Original Method ----------
        //if (attrib == null || !(attrib instanceof Attributes)) {
            //throw new ClassCastException(attrib.getClass().getName() + " not an Attributes");
        //}
        //this.map.putAll(attrib);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.456 -0400", hash_original_method = "10CAD66DFB71B02C0F278FCC3305EF24", hash_generated_method = "A6716269A0FDA7B65A089CB86D72D24C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object remove(Object key) {
        dsTaint.addTaint(key.dsTaint);
        Object var8B97B65E44C2FA9E70FEA56ECDEE63A2_690021967 = (map.remove(key));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return map.remove(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.456 -0400", hash_original_method = "BF2CB7E40375B078820B7350C838FBD6", hash_generated_method = "DFB08033AF8D6C7BF2337F852D94AB18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int size() {
        int var4DE0F18707A7B4B11DB3EB19AE8B9E3C_731854914 = (map.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return map.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.456 -0400", hash_original_method = "F211D00F0E74ECC7AD7311207A5002DA", hash_generated_method = "FE0DDBD4B96D9F84DF05BD1CF4BF6D03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection<Object> values() {
        Collection<Object> var0B34F03CED6C6C56BA989625D11A2671_16377836 = (map.values());
        return (Collection<Object>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return map.values();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.457 -0400", hash_original_method = "732187D1BBCF1409FB005BFCCDAC70B4", hash_generated_method = "B223F2D0697E2FCB913E3F3A07FAFA5C")
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
            throw new AssertionError(e);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.457 -0400", hash_original_method = "A7A7EF5A89DF679FD5CBA963DA8911B6", hash_generated_method = "2A7B55A8BAF2B7656BBC3A37F0CE626C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var47D635E353BD8FF2F8AAE3D8F795E188_1715154474 = (map.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return map.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.457 -0400", hash_original_method = "E46FF1DB18EE293123D8E2B07FF4B8E9", hash_generated_method = "4359C96467F4B1B053F7AD17873F02AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        {
            boolean var57993C5006C5AA4D9515F39FCF252F33_1722087182 = (map.equals(((Attributes) obj).map));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.457 -0400", hash_original_method = "738755F264DB023D14F89BE9B353A481", hash_generated_method = "B75E7B41821915BA097F98585E7C41E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getValue(Attributes.Name name) {
        dsTaint.addTaint(name.dsTaint);
        String var169E043417B1FA4D3BB8B44F6E78DA71_209016239 = ((String) map.get(name));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (String) map.get(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.457 -0400", hash_original_method = "3C8D5071480DE8B5CA7E078D035D576F", hash_generated_method = "2BF8457E68F8A6A13E6DEE70DBB859A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getValue(String name) {
        dsTaint.addTaint(name);
        String var8680BA1325C309A3D2F9C1722A3B9E97_1737317536 = ((String) map.get(new Attributes.Name(name)));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (String) map.get(new Attributes.Name(name));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.457 -0400", hash_original_method = "6F8FF0BC58E7762A3A8A85D431B8F527", hash_generated_method = "994A62C85664E180BE9C86AE9B52C89C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String putValue(String name, String val) {
        dsTaint.addTaint(val);
        dsTaint.addTaint(name);
        String var78D0EFCBBAD8C3AF5D000D4C8D22D937_1753485648 = ((String) map.put(new Attributes.Name(name), val));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (String) map.put(new Attributes.Name(name), val);
    }

    
    public static class Name {
        private final String name;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.457 -0400", hash_original_method = "2C39DBA2C28891B792407C3858FAD7FB", hash_generated_method = "853BACC19EF254B7E3FC05AAE870D060")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Name(String name) {
            dsTaint.addTaint(name);
            {
                boolean var3039A75A9646F316597EFD01ED473C47_28024924 = (name.isEmpty() || name.length() > Manifest.LINE_LENGTH_LIMIT - 2);
                {
                    throw new IllegalArgumentException(name);
                } //End block
            } //End collapsed parenthetic
            {
                int i;
                i = 0;
                boolean var1F2EC7F747FAC8CE2816F0A3129E8B5A_2134861611 = (i < name.length());
                {
                    char ch;
                    ch = name.charAt(i);
                    {
                        throw new IllegalArgumentException(name);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.457 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "7648E8371A667C3DD3DBD4EB30F68680")
        @DSModeled(DSC.SAFE)
         String getName() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return name;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.457 -0400", hash_original_method = "44A371BEEBBEF1D1024A1D234C6B6AC2", hash_generated_method = "BEC23C41F4DDAA973EE2A05E726C7853")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object object) {
            dsTaint.addTaint(object.dsTaint);
            boolean varF196A190D6309E1ED2D9525863B835DA_1796896719 = (object instanceof Name
                    && ((Name) object).name.equalsIgnoreCase(name));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return object instanceof Name
                    //&& ((Name) object).name.equalsIgnoreCase(name);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.457 -0400", hash_original_method = "9402BF4C103D69D49EBD5DEF399C9512", hash_generated_method = "108D738F4735BB40F3C770BC23B6CDC7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int hashCode() {
            int var1240F838C135D2DA5C9C4C723AEA7518_662770575 = (name.toLowerCase(Locale.US).hashCode());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return name.toLowerCase(Locale.US).hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.457 -0400", hash_original_method = "0EB66BA5E965B83E191719250E0A82FF", hash_generated_method = "61033FF7128FD0D2C124C7BC4289F7A2")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return name;
        }

        
    }


    
}


