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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.488 -0400", hash_original_field = "1D78DC8ED51214E518B5114FE24490AE", hash_generated_field = "469DC0A3DDAB50D1A339FF08EE199F5C")

    protected Map<Object, Object> map;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.488 -0400", hash_original_method = "CDEB7A2340880305C142690108AEFF5F", hash_generated_method = "9872D14EC462B5E29026E6B7277BD8A7")
    public  Attributes() {
        map = new HashMap<Object, Object>();
        // ---------- Original Method ----------
        //map = new HashMap<Object, Object>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.489 -0400", hash_original_method = "F8717927CC90D5B5AE946AC3A31B19F4", hash_generated_method = "FBDA935B9A3831C52372D161FF350F6C")
    @SuppressWarnings("unchecked")
    public  Attributes(Attributes attrib) {
        map = (Map<Object, Object>) ((HashMap) attrib.map).clone();
        // ---------- Original Method ----------
        //map = (Map<Object, Object>) ((HashMap) attrib.map).clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.491 -0400", hash_original_method = "C0A84EEFF5C41531DA971DB0633F74FC", hash_generated_method = "792E69047F9763844FF159A7272D0CD4")
    public  Attributes(int size) {
        map = new HashMap<Object, Object>(size);
        // ---------- Original Method ----------
        //map = new HashMap<Object, Object>(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.491 -0400", hash_original_method = "00A8C0F9832A2FA4DDA896013D523229", hash_generated_method = "2A83EDB450FE64133FB4489A062A886E")
    public void clear() {
        map.clear();
        // ---------- Original Method ----------
        //map.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.491 -0400", hash_original_method = "51FDEF8A21E6EA5E0FB4715F8113FE74", hash_generated_method = "ABF8B763BC513D6AD985CC305B63E8D6")
    public boolean containsKey(Object key) {
        boolean var56EC89656FCA0EA2E21B790CBA0BA5A2_1063292739 = (map.containsKey(key));
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_989212183 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_989212183;
        // ---------- Original Method ----------
        //return map.containsKey(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.492 -0400", hash_original_method = "E6B0C93317C0E9F78301AFF4874F2620", hash_generated_method = "8B04E4CC163BEBF2CEDB154AD2C6B684")
    public boolean containsValue(Object value) {
        boolean var8DBC5B9FE37AD1D935F8723487462395_1759262674 = (map.containsValue(value));
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1464105987 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1464105987;
        // ---------- Original Method ----------
        //return map.containsValue(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.492 -0400", hash_original_method = "2E4A8A9DC4043DAAC1C8FCCBA69D6A6B", hash_generated_method = "341D68E4329F186A8C18C163675B2A9B")
    public Set<Map.Entry<Object, Object>> entrySet() {
        Set<Map.Entry<Object, Object>> varB4EAC82CA7396A68D541C85D26508E83_91854301 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_91854301 = map.entrySet();
        varB4EAC82CA7396A68D541C85D26508E83_91854301.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_91854301;
        // ---------- Original Method ----------
        //return map.entrySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.493 -0400", hash_original_method = "C22494F044E1A5B9985D58D15AE531DA", hash_generated_method = "DB476DA0D66FA1F14514DE728B926558")
    public Object get(Object key) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1053818885 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1053818885 = map.get(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1053818885.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1053818885;
        // ---------- Original Method ----------
        //return map.get(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.493 -0400", hash_original_method = "193F4487BCC4A9B88FB28866363E7ABF", hash_generated_method = "C72078512FA22AB339F83A0F11536150")
    public boolean isEmpty() {
        boolean var59C8754218A5378301A7B2210B450A8A_1426349234 = (map.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1022760581 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1022760581;
        // ---------- Original Method ----------
        //return map.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.493 -0400", hash_original_method = "F488EE4006E1366E830BF13438F76FA9", hash_generated_method = "DCBA089EB291A5BC9A6E82CE536C12A8")
    public Set<Object> keySet() {
        Set<Object> varB4EAC82CA7396A68D541C85D26508E83_1822299942 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1822299942 = map.keySet();
        varB4EAC82CA7396A68D541C85D26508E83_1822299942.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1822299942;
        // ---------- Original Method ----------
        //return map.keySet();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.494 -0400", hash_original_method = "3E157C761E601D752826F2BACE4084FB", hash_generated_method = "52E1AE5D67742F3D801B6036D3376F9F")
    @SuppressWarnings("cast")
    public Object put(Object key, Object value) {
        Object varB4EAC82CA7396A68D541C85D26508E83_90000997 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_90000997 = map.put((Name) key, (String) value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_90000997.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_90000997;
        // ---------- Original Method ----------
        //return map.put((Name) key, (String) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.495 -0400", hash_original_method = "2F4F3A55CE715E104E0F5EF4690E41E2", hash_generated_method = "EB7B785E39255C18D16493614B07D07D")
    public void putAll(Map<?, ?> attrib) {
        {
            if (DroidSafeAndroidRuntime.control) throw new ClassCastException(attrib.getClass().getName() + " not an Attributes");
        } //End block
        this.map.putAll(attrib);
        addTaint(attrib.getTaint());
        // ---------- Original Method ----------
        //if (attrib == null || !(attrib instanceof Attributes)) {
            //throw new ClassCastException(attrib.getClass().getName() + " not an Attributes");
        //}
        //this.map.putAll(attrib);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.516 -0400", hash_original_method = "10CAD66DFB71B02C0F278FCC3305EF24", hash_generated_method = "E1F4C46091A89875F8F72BE19EA4A497")
    public Object remove(Object key) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1042319190 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1042319190 = map.remove(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1042319190.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1042319190;
        // ---------- Original Method ----------
        //return map.remove(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.522 -0400", hash_original_method = "BF2CB7E40375B078820B7350C838FBD6", hash_generated_method = "FDE382E3D4B366BCEA11B622F4A0E08A")
    public int size() {
        int var4DE0F18707A7B4B11DB3EB19AE8B9E3C_1220098192 = (map.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2016323826 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2016323826;
        // ---------- Original Method ----------
        //return map.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.522 -0400", hash_original_method = "F211D00F0E74ECC7AD7311207A5002DA", hash_generated_method = "5B9414F6262FE4AFF2E418CBA430C332")
    public Collection<Object> values() {
        Collection<Object> varB4EAC82CA7396A68D541C85D26508E83_1661790757 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1661790757 = map.values();
        varB4EAC82CA7396A68D541C85D26508E83_1661790757.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1661790757;
        // ---------- Original Method ----------
        //return map.values();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.540 -0400", hash_original_method = "732187D1BBCF1409FB005BFCCDAC70B4", hash_generated_method = "79D9E76AC00A124CD94C9F43FFAAB784")
    @SuppressWarnings("unchecked")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1181019942 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1181019942 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_1181019942.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1181019942;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.545 -0400", hash_original_method = "A7A7EF5A89DF679FD5CBA963DA8911B6", hash_generated_method = "BC0782CD66802BDEA6B5C7E09A97FF5C")
    @Override
    public int hashCode() {
        int var47D635E353BD8FF2F8AAE3D8F795E188_674596542 = (map.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_245062870 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_245062870;
        // ---------- Original Method ----------
        //return map.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.545 -0400", hash_original_method = "E46FF1DB18EE293123D8E2B07FF4B8E9", hash_generated_method = "CE814C6C1608B54A02758CAE948F3882")
    @Override
    public boolean equals(Object obj) {
        {
            boolean var57993C5006C5AA4D9515F39FCF252F33_139844498 = (map.equals(((Attributes) obj).map));
        } //End block
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1468833419 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1468833419;
        // ---------- Original Method ----------
        //if (this == obj) {
            //return true;
        //}
        //if (obj instanceof Attributes) {
            //return map.equals(((Attributes) obj).map);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.547 -0400", hash_original_method = "738755F264DB023D14F89BE9B353A481", hash_generated_method = "49E5D9D7C4F22FCFA7CAF3334A202DE4")
    public String getValue(Attributes.Name name) {
        String varB4EAC82CA7396A68D541C85D26508E83_714382048 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_714382048 = (String) map.get(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_714382048.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_714382048;
        // ---------- Original Method ----------
        //return (String) map.get(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.549 -0400", hash_original_method = "3C8D5071480DE8B5CA7E078D035D576F", hash_generated_method = "C7812C46B0E183CCF241215B6023385B")
    public String getValue(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_1692518968 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1692518968 = (String) map.get(new Attributes.Name(name));
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1692518968.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1692518968;
        // ---------- Original Method ----------
        //return (String) map.get(new Attributes.Name(name));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.556 -0400", hash_original_method = "6F8FF0BC58E7762A3A8A85D431B8F527", hash_generated_method = "B87C59F93EC640741FF4DB2B8083CC26")
    public String putValue(String name, String val) {
        String varB4EAC82CA7396A68D541C85D26508E83_385650912 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_385650912 = (String) map.put(new Attributes.Name(name), val);
        addTaint(name.getTaint());
        addTaint(val.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_385650912.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_385650912;
        // ---------- Original Method ----------
        //return (String) map.put(new Attributes.Name(name), val);
    }

    
    public static class Name {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.557 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

        private String name;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.580 -0400", hash_original_method = "2C39DBA2C28891B792407C3858FAD7FB", hash_generated_method = "BCDE51078FAA6869E5E0C25EA0F26A4F")
        public  Name(String name) {
            {
                boolean var3039A75A9646F316597EFD01ED473C47_50645525 = (name.isEmpty() || name.length() > Manifest.LINE_LENGTH_LIMIT - 2);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(name);
                } //End block
            } //End collapsed parenthetic
            {
                int i;
                i = 0;
                boolean var1F2EC7F747FAC8CE2816F0A3129E8B5A_1182981977 = (i < name.length());
                {
                    char ch;
                    ch = name.charAt(i);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(name);
                    } //End block
                } //End block
            } //End collapsed parenthetic
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.581 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "FA7BFED0A6AA6190880D8C4D4F1F012F")
         String getName() {
            String varB4EAC82CA7396A68D541C85D26508E83_954076967 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_954076967 = name;
            varB4EAC82CA7396A68D541C85D26508E83_954076967.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_954076967;
            // ---------- Original Method ----------
            //return name;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.581 -0400", hash_original_method = "44A371BEEBBEF1D1024A1D234C6B6AC2", hash_generated_method = "7BC1FD03719AA4D73CC2FCFAB9B857F0")
        @Override
        public boolean equals(Object object) {
            boolean varF196A190D6309E1ED2D9525863B835DA_888048969 = (object instanceof Name
                    && ((Name) object).name.equalsIgnoreCase(name));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_587667099 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_587667099;
            // ---------- Original Method ----------
            //return object instanceof Name
                    //&& ((Name) object).name.equalsIgnoreCase(name);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.581 -0400", hash_original_method = "9402BF4C103D69D49EBD5DEF399C9512", hash_generated_method = "3A88E18827EA848B71F249BB43200761")
        @Override
        public int hashCode() {
            int var1240F838C135D2DA5C9C4C723AEA7518_1116722475 = (name.toLowerCase(Locale.US).hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_295999018 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_295999018;
            // ---------- Original Method ----------
            //return name.toLowerCase(Locale.US).hashCode();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.586 -0400", hash_original_method = "0EB66BA5E965B83E191719250E0A82FF", hash_generated_method = "8E96E7D08B41CB2641E342970B09444D")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1446364430 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1446364430 = name;
            varB4EAC82CA7396A68D541C85D26508E83_1446364430.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1446364430;
            // ---------- Original Method ----------
            //return name;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.586 -0400", hash_original_field = "7BAFCE84B42A5DA731B6634CC5FFAA45", hash_generated_field = "0B9661DEBA6285ADE4666B79ED38B94B")

        public static final Name CLASS_PATH = new Name("Class-Path");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.586 -0400", hash_original_field = "979A4FE6383FAD6E47B386693779A210", hash_generated_field = "C6B4E6E9D8E48CDF5401ED1A54EC60FF")

        public static final Name MANIFEST_VERSION = new Name("Manifest-Version");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.586 -0400", hash_original_field = "71B9F9ED4173CDF4D0BD9346348BDB4C", hash_generated_field = "5BAA3B0F29B5D6B421C14C179438EFAB")

        public static final Name MAIN_CLASS = new Name("Main-Class");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.586 -0400", hash_original_field = "9EDA43684D8154E3F290DF07AB8508DC", hash_generated_field = "F2F620E8615802A3D89525207F39FBA8")

        public static final Name SIGNATURE_VERSION = new Name("Signature-Version");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.586 -0400", hash_original_field = "5AC651DCF0FF8BA1281471C3D56B1415", hash_generated_field = "D2DC98BAC7E8C22DC2E0EB2EFB820BE5")

        public static final Name CONTENT_TYPE = new Name("Content-Type");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.586 -0400", hash_original_field = "B307531EFBF862D6D2682AF1C5A81B78", hash_generated_field = "169C8F071E808A4124C933174D669007")

        public static final Name SEALED = new Name("Sealed");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.586 -0400", hash_original_field = "1CD7EAEF9F246BA6BCCEADEF2F9C8766", hash_generated_field = "A498C8F3B78053FB6A1D636DAD36FB03")

        public static final Name IMPLEMENTATION_TITLE = new Name("Implementation-Title");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.586 -0400", hash_original_field = "A4E6C113BB6D25458D812355FF1A4C4A", hash_generated_field = "AD20B256C1BFBFD0F01D0028288CAF35")

        public static final Name IMPLEMENTATION_VERSION = new Name("Implementation-Version");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.586 -0400", hash_original_field = "6C66A20FFAB6248B227EB5D0C059805D", hash_generated_field = "E36624A10BCF264F61DB3BBAFEA8FAD3")

        public static final Name IMPLEMENTATION_VENDOR = new Name("Implementation-Vendor");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.586 -0400", hash_original_field = "F07DD5E93416746950BC3A6C6F9F0446", hash_generated_field = "0099497E1C8577AF9FD31121C605C0DB")

        public static final Name SPECIFICATION_TITLE = new Name("Specification-Title");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.586 -0400", hash_original_field = "8F09F8080841D34B1C08F220D0EBA899", hash_generated_field = "6E7EB82C13C6F355851BCE9E50066EC5")

        public static final Name SPECIFICATION_VERSION = new Name("Specification-Version");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.586 -0400", hash_original_field = "EA39AE042F589F51CCA4794589F3F170", hash_generated_field = "EC321A620C6EF412E9F78378365830E5")

        public static final Name SPECIFICATION_VENDOR = new Name("Specification-Vendor");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.586 -0400", hash_original_field = "2407C373B3B745E609B94CDACECAEB31", hash_generated_field = "535B108D1755EC0284B833516A31C73B")

        public static final Name EXTENSION_LIST = new Name("Extension-List");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.586 -0400", hash_original_field = "0A61EA13F72B31A90029E62ECE5D39B3", hash_generated_field = "1B0256904EB520257211ED0319800FD9")

        public static final Name EXTENSION_NAME = new Name("Extension-Name");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.586 -0400", hash_original_field = "03D3DEE73E8B2BD18864FA441ABA9BB5", hash_generated_field = "BB57E13BBE8FADAE2833B96A25E9146B")

        public static final Name EXTENSION_INSTALLATION = new Name("Extension-Installation");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.586 -0400", hash_original_field = "A5231F0A367505C09E7F334CD1536B6C", hash_generated_field = "6100F359EAE657374D589152BD7E0AF2")

        public static final Name IMPLEMENTATION_VENDOR_ID = new Name("Implementation-Vendor-Id");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.586 -0400", hash_original_field = "C110DD9C1B0052E3AB8C5F5C3FF10029", hash_generated_field = "BAFF34A6F6A91D8E54DEE7BBC19A4C8F")

        public static final Name IMPLEMENTATION_URL = new Name("Implementation-URL");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:58.599 -0400", hash_original_field = "741BE91B9B217CFDA1740B6B5815CD02", hash_generated_field = "57D5EC5AF9BDF66C2DC6BA12C0276D2A")

        static Name NAME = new Name("Name");
    }


    
}

