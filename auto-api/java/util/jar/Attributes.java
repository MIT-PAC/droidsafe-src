package java.util.jar;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class Attributes implements Cloneable, Map<Object, Object> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.949 -0400", hash_original_field = "1D78DC8ED51214E518B5114FE24490AE", hash_generated_field = "469DC0A3DDAB50D1A339FF08EE199F5C")

    protected Map<Object, Object> map;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.949 -0400", hash_original_method = "CDEB7A2340880305C142690108AEFF5F", hash_generated_method = "9872D14EC462B5E29026E6B7277BD8A7")
    public  Attributes() {
        map = new HashMap<Object, Object>();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.949 -0400", hash_original_method = "F8717927CC90D5B5AE946AC3A31B19F4", hash_generated_method = "FBDA935B9A3831C52372D161FF350F6C")
    @SuppressWarnings("unchecked")
    public  Attributes(Attributes attrib) {
        map = (Map<Object, Object>) ((HashMap) attrib.map).clone();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.950 -0400", hash_original_method = "C0A84EEFF5C41531DA971DB0633F74FC", hash_generated_method = "792E69047F9763844FF159A7272D0CD4")
    public  Attributes(int size) {
        map = new HashMap<Object, Object>(size);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.950 -0400", hash_original_method = "00A8C0F9832A2FA4DDA896013D523229", hash_generated_method = "2A83EDB450FE64133FB4489A062A886E")
    public void clear() {
        map.clear();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.950 -0400", hash_original_method = "51FDEF8A21E6EA5E0FB4715F8113FE74", hash_generated_method = "B29CEDEC7BA9ED2C68FEBFEB1E34577C")
    public boolean containsKey(Object key) {
        boolean var56EC89656FCA0EA2E21B790CBA0BA5A2_1136795600 = (map.containsKey(key));
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1229852435 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1229852435;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.950 -0400", hash_original_method = "E6B0C93317C0E9F78301AFF4874F2620", hash_generated_method = "E84F1CD524C8246881CD4536959A7D11")
    public boolean containsValue(Object value) {
        boolean var8DBC5B9FE37AD1D935F8723487462395_392262373 = (map.containsValue(value));
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1133495445 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1133495445;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.951 -0400", hash_original_method = "2E4A8A9DC4043DAAC1C8FCCBA69D6A6B", hash_generated_method = "CE93AFC8393DD2FBA925C1EC59A6C68E")
    public Set<Map.Entry<Object, Object>> entrySet() {
        Set<Map.Entry<Object, Object>> varB4EAC82CA7396A68D541C85D26508E83_54956885 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_54956885 = map.entrySet();
        varB4EAC82CA7396A68D541C85D26508E83_54956885.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_54956885;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.952 -0400", hash_original_method = "C22494F044E1A5B9985D58D15AE531DA", hash_generated_method = "4A88F94E2FE0C6A826D42FB5FB63A444")
    public Object get(Object key) {
        Object varB4EAC82CA7396A68D541C85D26508E83_34808636 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_34808636 = map.get(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_34808636.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_34808636;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.953 -0400", hash_original_method = "193F4487BCC4A9B88FB28866363E7ABF", hash_generated_method = "8387870CAF87F40C899FADB22E6FF744")
    public boolean isEmpty() {
        boolean var59C8754218A5378301A7B2210B450A8A_2127870607 = (map.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_416346588 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_416346588;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.954 -0400", hash_original_method = "F488EE4006E1366E830BF13438F76FA9", hash_generated_method = "E883AC9A2DBCC5B035B7E7E1D2E0CFBA")
    public Set<Object> keySet() {
        Set<Object> varB4EAC82CA7396A68D541C85D26508E83_1281065362 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1281065362 = map.keySet();
        varB4EAC82CA7396A68D541C85D26508E83_1281065362.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1281065362;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.954 -0400", hash_original_method = "3E157C761E601D752826F2BACE4084FB", hash_generated_method = "7A7A64CF43017FF1DE3264C261C95CC1")
    @SuppressWarnings("cast")
    public Object put(Object key, Object value) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1583491754 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1583491754 = map.put((Name) key, (String) value);
        addTaint(key.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1583491754.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1583491754;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.955 -0400", hash_original_method = "2F4F3A55CE715E104E0F5EF4690E41E2", hash_generated_method = "EB7B785E39255C18D16493614B07D07D")
    public void putAll(Map<?, ?> attrib) {
        {
            if (DroidSafeAndroidRuntime.control) throw new ClassCastException(attrib.getClass().getName() + " not an Attributes");
        } 
        this.map.putAll(attrib);
        addTaint(attrib.getTaint());
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.955 -0400", hash_original_method = "10CAD66DFB71B02C0F278FCC3305EF24", hash_generated_method = "9A13BD39438D233955CFF9A8BB5DAC1D")
    public Object remove(Object key) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1024764551 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1024764551 = map.remove(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1024764551.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1024764551;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.955 -0400", hash_original_method = "BF2CB7E40375B078820B7350C838FBD6", hash_generated_method = "CC46AAAA2F3135FA1BA0B6CAAD3EB5EE")
    public int size() {
        int var4DE0F18707A7B4B11DB3EB19AE8B9E3C_1879720514 = (map.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_978653936 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_978653936;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.956 -0400", hash_original_method = "F211D00F0E74ECC7AD7311207A5002DA", hash_generated_method = "EECEE62274D017B41753C85FB12B6297")
    public Collection<Object> values() {
        Collection<Object> varB4EAC82CA7396A68D541C85D26508E83_622775936 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_622775936 = map.values();
        varB4EAC82CA7396A68D541C85D26508E83_622775936.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_622775936;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.957 -0400", hash_original_method = "732187D1BBCF1409FB005BFCCDAC70B4", hash_generated_method = "EF7D12ED0272D0CA2FE99EDF28323F3F")
    @SuppressWarnings("unchecked")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_625050353 = null; 
        Attributes clone;
        try 
        {
            clone = (Attributes) super.clone();
        } 
        catch (CloneNotSupportedException e)
        {
        	throw new AssertionError(e);
        } 
        clone.map = (Map<Object, Object>) ((HashMap) map).clone();
        varB4EAC82CA7396A68D541C85D26508E83_625050353 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_625050353.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_625050353;
        
        
        
            
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.957 -0400", hash_original_method = "A7A7EF5A89DF679FD5CBA963DA8911B6", hash_generated_method = "04A4AA5C70E283DFC8497B9407FD9BE9")
    @Override
    public int hashCode() {
        int var47D635E353BD8FF2F8AAE3D8F795E188_1087410027 = (map.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1385624734 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1385624734;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.958 -0400", hash_original_method = "E46FF1DB18EE293123D8E2B07FF4B8E9", hash_generated_method = "B12102380CBCE75F1E013402261086FF")
    @Override
    public boolean equals(Object obj) {
        {
            boolean var57993C5006C5AA4D9515F39FCF252F33_22962580 = (map.equals(((Attributes) obj).map));
        } 
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1873521534 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1873521534;
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.958 -0400", hash_original_method = "738755F264DB023D14F89BE9B353A481", hash_generated_method = "EFD1B7E65655C0F2DC2B29097D910C2F")
    public String getValue(Attributes.Name name) {
        String varB4EAC82CA7396A68D541C85D26508E83_897581703 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_897581703 = (String) map.get(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_897581703.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_897581703;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.959 -0400", hash_original_method = "3C8D5071480DE8B5CA7E078D035D576F", hash_generated_method = "FBC200771584553A6498ADBD1AE34213")
    public String getValue(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_731396785 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_731396785 = (String) map.get(new Attributes.Name(name));
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_731396785.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_731396785;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.959 -0400", hash_original_method = "6F8FF0BC58E7762A3A8A85D431B8F527", hash_generated_method = "F024885E8714B63CAEBB04A913542735")
    public String putValue(String name, String val) {
        String varB4EAC82CA7396A68D541C85D26508E83_205133910 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_205133910 = (String) map.put(new Attributes.Name(name), val);
        addTaint(name.getTaint());
        addTaint(val.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_205133910.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_205133910;
        
        
    }

    
    public static class Name {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.959 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

        private String name;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.960 -0400", hash_original_method = "2C39DBA2C28891B792407C3858FAD7FB", hash_generated_method = "A0CFF9D2CC295E7B928FA57DD5A5B2BE")
        public  Name(String name) {
            {
                boolean var3039A75A9646F316597EFD01ED473C47_1142264785 = (name.isEmpty() || name.length() > Manifest.LINE_LENGTH_LIMIT - 2);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(name);
                } 
            } 
            {
                int i = 0;
                boolean var1F2EC7F747FAC8CE2816F0A3129E8B5A_1616491890 = (i < name.length());
                {
                    char ch = name.charAt(i);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(name);
                    } 
                } 
            } 
            this.name = name;
            
            
                
            
            
                
                
                        
                    
                
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.960 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "3D6C21C880D291F38BE4768AFD0184E7")
         String getName() {
            String varB4EAC82CA7396A68D541C85D26508E83_1885007431 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1885007431 = name;
            varB4EAC82CA7396A68D541C85D26508E83_1885007431.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1885007431;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.961 -0400", hash_original_method = "44A371BEEBBEF1D1024A1D234C6B6AC2", hash_generated_method = "1FB4711CB86683FA3AB976E9DD174C17")
        @Override
        public boolean equals(Object object) {
            boolean varF196A190D6309E1ED2D9525863B835DA_1345376152 = (object instanceof Name
                    && ((Name) object).name.equalsIgnoreCase(name));
            addTaint(object.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1775893882 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1775893882;
            
            
                    
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.961 -0400", hash_original_method = "9402BF4C103D69D49EBD5DEF399C9512", hash_generated_method = "835B65B1AB97B0C3F59717C56721FAC0")
        @Override
        public int hashCode() {
            int var1240F838C135D2DA5C9C4C723AEA7518_994735404 = (name.toLowerCase(Locale.US).hashCode());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_88531768 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_88531768;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.962 -0400", hash_original_method = "0EB66BA5E965B83E191719250E0A82FF", hash_generated_method = "F4E2BFD5349DFBB1D081716F68EC7A69")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_121063200 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_121063200 = name;
            varB4EAC82CA7396A68D541C85D26508E83_121063200.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_121063200;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.962 -0400", hash_original_field = "7BAFCE84B42A5DA731B6634CC5FFAA45", hash_generated_field = "0B9661DEBA6285ADE4666B79ED38B94B")

        public static final Name CLASS_PATH = new Name("Class-Path");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.962 -0400", hash_original_field = "979A4FE6383FAD6E47B386693779A210", hash_generated_field = "C6B4E6E9D8E48CDF5401ED1A54EC60FF")

        public static final Name MANIFEST_VERSION = new Name("Manifest-Version");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.962 -0400", hash_original_field = "71B9F9ED4173CDF4D0BD9346348BDB4C", hash_generated_field = "5BAA3B0F29B5D6B421C14C179438EFAB")

        public static final Name MAIN_CLASS = new Name("Main-Class");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.962 -0400", hash_original_field = "9EDA43684D8154E3F290DF07AB8508DC", hash_generated_field = "F2F620E8615802A3D89525207F39FBA8")

        public static final Name SIGNATURE_VERSION = new Name("Signature-Version");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.962 -0400", hash_original_field = "5AC651DCF0FF8BA1281471C3D56B1415", hash_generated_field = "D2DC98BAC7E8C22DC2E0EB2EFB820BE5")

        public static final Name CONTENT_TYPE = new Name("Content-Type");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.962 -0400", hash_original_field = "B307531EFBF862D6D2682AF1C5A81B78", hash_generated_field = "169C8F071E808A4124C933174D669007")

        public static final Name SEALED = new Name("Sealed");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.962 -0400", hash_original_field = "1CD7EAEF9F246BA6BCCEADEF2F9C8766", hash_generated_field = "A498C8F3B78053FB6A1D636DAD36FB03")

        public static final Name IMPLEMENTATION_TITLE = new Name("Implementation-Title");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.962 -0400", hash_original_field = "A4E6C113BB6D25458D812355FF1A4C4A", hash_generated_field = "AD20B256C1BFBFD0F01D0028288CAF35")

        public static final Name IMPLEMENTATION_VERSION = new Name("Implementation-Version");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.962 -0400", hash_original_field = "6C66A20FFAB6248B227EB5D0C059805D", hash_generated_field = "E36624A10BCF264F61DB3BBAFEA8FAD3")

        public static final Name IMPLEMENTATION_VENDOR = new Name("Implementation-Vendor");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.962 -0400", hash_original_field = "F07DD5E93416746950BC3A6C6F9F0446", hash_generated_field = "0099497E1C8577AF9FD31121C605C0DB")

        public static final Name SPECIFICATION_TITLE = new Name("Specification-Title");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.962 -0400", hash_original_field = "8F09F8080841D34B1C08F220D0EBA899", hash_generated_field = "6E7EB82C13C6F355851BCE9E50066EC5")

        public static final Name SPECIFICATION_VERSION = new Name("Specification-Version");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.962 -0400", hash_original_field = "EA39AE042F589F51CCA4794589F3F170", hash_generated_field = "EC321A620C6EF412E9F78378365830E5")

        public static final Name SPECIFICATION_VENDOR = new Name("Specification-Vendor");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.962 -0400", hash_original_field = "2407C373B3B745E609B94CDACECAEB31", hash_generated_field = "535B108D1755EC0284B833516A31C73B")

        public static final Name EXTENSION_LIST = new Name("Extension-List");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.962 -0400", hash_original_field = "0A61EA13F72B31A90029E62ECE5D39B3", hash_generated_field = "1B0256904EB520257211ED0319800FD9")

        public static final Name EXTENSION_NAME = new Name("Extension-Name");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.962 -0400", hash_original_field = "03D3DEE73E8B2BD18864FA441ABA9BB5", hash_generated_field = "BB57E13BBE8FADAE2833B96A25E9146B")

        public static final Name EXTENSION_INSTALLATION = new Name("Extension-Installation");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.962 -0400", hash_original_field = "A5231F0A367505C09E7F334CD1536B6C", hash_generated_field = "6100F359EAE657374D589152BD7E0AF2")

        public static final Name IMPLEMENTATION_VENDOR_ID = new Name("Implementation-Vendor-Id");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.962 -0400", hash_original_field = "C110DD9C1B0052E3AB8C5F5C3FF10029", hash_generated_field = "BAFF34A6F6A91D8E54DEE7BBC19A4C8F")

        public static final Name IMPLEMENTATION_URL = new Name("Implementation-URL");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:15.962 -0400", hash_original_field = "741BE91B9B217CFDA1740B6B5815CD02", hash_generated_field = "8391009D03BD383CE126AB69E7C8D390")

        static final Name NAME = new Name("Name");
    }


    
}

