package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

class EmulatedFields {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.868 -0400", hash_original_field = "08BC91839408FD76B328A7D66B1893BD", hash_generated_field = "A5B1B9594264127836B75E232C6A005F")

    private ObjectSlot[] slotsToSerialize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.870 -0400", hash_original_field = "96A364EB816711FA9CF159A2CC04A8A6", hash_generated_field = "BA97D77EB4E493202875178557881AFD")

    private ObjectStreamField[] declaredFields;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.871 -0400", hash_original_method = "0D8BD958281DF75319EA682F9725E83E", hash_generated_method = "C421452236FD69F6E0A639F87D25F961")
    public  EmulatedFields(ObjectStreamField[] fields, ObjectStreamField[] declared) {
        buildSlots(fields);
        declaredFields = declared;
        addTaint(fields[0].getTaint());
        // ---------- Original Method ----------
        //buildSlots(fields);
        //declaredFields = declared;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.882 -0400", hash_original_method = "3EEF58200AED128D87652E78B0B409B1", hash_generated_method = "49980286C54B44CD43D854E34C8DAA51")
    private void buildSlots(ObjectStreamField[] fields) {
        slotsToSerialize = new ObjectSlot[fields.length];
        {
            int i;
            i = 0;
            {
                ObjectSlot s;
                s = new ObjectSlot();
                slotsToSerialize[i] = s;
                s.field = fields[i];
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //slotsToSerialize = new ObjectSlot[fields.length];
        //for (int i = 0; i < fields.length; i++) {
            //ObjectSlot s = new ObjectSlot();
            //slotsToSerialize[i] = s;
            //s.field = fields[i];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.883 -0400", hash_original_method = "1C69260A170F4832C171F7666BEC6CDB", hash_generated_method = "9E7F0A7A82BF23F2C45DDF0545EBD78B")
    public boolean defaulted(String name) throws IllegalArgumentException {
        ObjectSlot slot;
        slot = findSlot(name, null);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("no field '" + name + "'");
        } //End block
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1956684927 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1956684927;
        // ---------- Original Method ----------
        //ObjectSlot slot = findSlot(name, null);
        //if (slot == null) {
            //throw new IllegalArgumentException("no field '" + name + "'");
        //}
        //return slot.defaulted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.898 -0400", hash_original_method = "713D4075A7BFE1E9122D10F9179E2FD5", hash_generated_method = "08C4F086489B35DC9162EC43895D391C")
    private ObjectSlot findSlot(String fieldName, Class<?> fieldType) {
        ObjectSlot varB4EAC82CA7396A68D541C85D26508E83_701344461 = null; //Variable for return #1
        ObjectSlot varB4EAC82CA7396A68D541C85D26508E83_1214208962 = null; //Variable for return #2
        ObjectSlot varB4EAC82CA7396A68D541C85D26508E83_1355254335 = null; //Variable for return #3
        ObjectSlot varB4EAC82CA7396A68D541C85D26508E83_473700752 = null; //Variable for return #4
        ObjectSlot varB4EAC82CA7396A68D541C85D26508E83_1168471275 = null; //Variable for return #5
        boolean isPrimitive;
        isPrimitive = fieldType != null && fieldType.isPrimitive();
        {
            int i;
            i = 0;
            {
                ObjectSlot slot;
                slot = slotsToSerialize[i];
                {
                    boolean varE1A025364B8E6AFC98F7C14114BFC1C9_1146218313 = (slot.field.getName().equals(fieldName));
                    {
                        {
                            {
                                boolean var4C117EB57B50631CF75F10A9EF1ED6FE_322342143 = (slot.field.getType() == fieldType);
                                {
                                    varB4EAC82CA7396A68D541C85D26508E83_701344461 = slot;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_1214208962 = slot;
                            } //End block
                            {
                                boolean var9D67CACB84C699C5888544F8AC0456AA_1112928199 = (slot.field.getType().isAssignableFrom(fieldType));
                                {
                                    varB4EAC82CA7396A68D541C85D26508E83_1355254335 = slot;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            {
                int i;
                i = 0;
                {
                    ObjectStreamField field;
                    field = declaredFields[i];
                    {
                        boolean var4191A3F7A9FD9BE075BD7EE74017F350_505638825 = (field.getName().equals(fieldName));
                        {
                            {
                                {
                                    boolean var4666DC710D79C14096A12900C769463C_1402150865 = (fieldType == field.getType());
                                    boolean varF815A1EC3DAD8366CF8B57C10E9CB2F4_694223603 = (fieldType == null ||
                            field.getType().isAssignableFrom(fieldType));
                                } //End flattened ternary
                                {
                                    ObjectSlot slot;
                                    slot = new ObjectSlot();
                                    slot.field = field;
                                    slot.defaulted = true;
                                    varB4EAC82CA7396A68D541C85D26508E83_473700752 = slot;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1168471275 = null;
        addTaint(fieldName.getTaint());
        addTaint(fieldType.getTaint());
        ObjectSlot varA7E53CE21691AB073D9660D615818899_621129205; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_621129205 = varB4EAC82CA7396A68D541C85D26508E83_701344461;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_621129205 = varB4EAC82CA7396A68D541C85D26508E83_1214208962;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_621129205 = varB4EAC82CA7396A68D541C85D26508E83_1355254335;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_621129205 = varB4EAC82CA7396A68D541C85D26508E83_473700752;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_621129205 = varB4EAC82CA7396A68D541C85D26508E83_1168471275;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_621129205.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_621129205;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.899 -0400", hash_original_method = "088986B40FCEDC0703EB00DECCCFDC49", hash_generated_method = "6BDA9C67A258A19CE7E1B2D4BBBA1AF4")
    private ObjectSlot findMandatorySlot(String name, Class<?> type) {
        ObjectSlot varB4EAC82CA7396A68D541C85D26508E83_1733695848 = null; //Variable for return #1
        ObjectSlot slot;
        slot = findSlot(name, type);
        {
            boolean varCD9D80755B0AC12F3AA5AE1F870832F4_1642761530 = (slot == null || (type == null && slot.field.getType().isPrimitive()));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("no field '" + name + "' of type " + type);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1733695848 = slot;
        addTaint(name.getTaint());
        addTaint(type.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1733695848.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1733695848;
        // ---------- Original Method ----------
        //ObjectSlot slot = findSlot(name, type);
        //if (slot == null || (type == null && slot.field.getType().isPrimitive())) {
            //throw new IllegalArgumentException("no field '" + name + "' of type " + type);
        //}
        //return slot;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.901 -0400", hash_original_method = "ACF5260920B1F0F677513369F3D8C323", hash_generated_method = "89F6C91C9EA012572220E9D5753C137A")
    public byte get(String name, byte defaultValue) throws IllegalArgumentException {
        ObjectSlot slot;
        slot = findMandatorySlot(name, byte.class);
        {
            Object varA61D67A1EFD734703A5370EE608C7F9B_669182189 = (((Byte) slot.fieldValue).byteValue());
        } //End flattened ternary
        addTaint(name.getTaint());
        addTaint(defaultValue);
        byte var40EA57D3EE3C07BF1C102B466E1C3091_750210290 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_750210290;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, byte.class);
        //return slot.defaulted ? defaultValue : ((Byte) slot.fieldValue).byteValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.915 -0400", hash_original_method = "97CAA651EBA3FEB1DEF47882147E3EE9", hash_generated_method = "AFE4C14920A746AFC25DA5A77D91B8B2")
    public char get(String name, char defaultValue) throws IllegalArgumentException {
        ObjectSlot slot;
        slot = findMandatorySlot(name, char.class);
        {
            Object varC02FD45F6A7EEB0CF03847D6BA3665B3_721124556 = (((Character) slot.fieldValue).charValue());
        } //End flattened ternary
        addTaint(name.getTaint());
        addTaint(defaultValue);
        char varA87DEB01C5F539E6BDA34829C8EF2368_1952904222 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1952904222;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, char.class);
        //return slot.defaulted ? defaultValue : ((Character) slot.fieldValue).charValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.915 -0400", hash_original_method = "8A61E03E38631E405F30500DFE3A2EED", hash_generated_method = "3B35216F08658215B74B6D23128853CA")
    public double get(String name, double defaultValue) throws IllegalArgumentException {
        ObjectSlot slot;
        slot = findMandatorySlot(name, double.class);
        {
            Object varD4B3EFEBFCF331341AF0274F0E7ED13E_1037248344 = (((Double) slot.fieldValue).doubleValue());
        } //End flattened ternary
        addTaint(name.getTaint());
        addTaint(defaultValue);
        double varE8CD7DA078A86726031AD64F35F5A6C0_2132145088 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_2132145088;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, double.class);
        //return slot.defaulted ? defaultValue : ((Double) slot.fieldValue).doubleValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.916 -0400", hash_original_method = "2A99383382827F229576C5D7E3624FBA", hash_generated_method = "33A626C6971479CC603D97735DC8AB76")
    public float get(String name, float defaultValue) throws IllegalArgumentException {
        ObjectSlot slot;
        slot = findMandatorySlot(name, float.class);
        {
            Object varCBC5901392CA9930B5E4BDDE86F34A76_166628233 = (((Float) slot.fieldValue).floatValue());
        } //End flattened ternary
        addTaint(name.getTaint());
        addTaint(defaultValue);
        float var546ADE640B6EDFBC8A086EF31347E768_244569914 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_244569914;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, float.class);
        //return slot.defaulted ? defaultValue : ((Float) slot.fieldValue).floatValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.922 -0400", hash_original_method = "348173917C5323C10E5D8A71A480A22F", hash_generated_method = "ACBF205B7335FF75F91647A8FD80D426")
    public int get(String name, int defaultValue) throws IllegalArgumentException {
        ObjectSlot slot;
        slot = findMandatorySlot(name, int.class);
        {
            Object var5D4D37262B4C33E914D6301DF923C625_1884398962 = (((Integer) slot.fieldValue).intValue());
        } //End flattened ternary
        addTaint(name.getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1925983111 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1925983111;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, int.class);
        //return slot.defaulted ? defaultValue : ((Integer) slot.fieldValue).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.931 -0400", hash_original_method = "57601B1EFC99CB5F2500857C9C4A7300", hash_generated_method = "C79A4C629396613BDE218A82FBF9C1EA")
    public long get(String name, long defaultValue) throws IllegalArgumentException {
        ObjectSlot slot;
        slot = findMandatorySlot(name, long.class);
        {
            Object varE5E5BEEA5FBF9B3BFCE247C007AFA58E_1501618584 = (((Long) slot.fieldValue).longValue());
        } //End flattened ternary
        addTaint(name.getTaint());
        addTaint(defaultValue);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_330006407 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_330006407;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, long.class);
        //return slot.defaulted ? defaultValue : ((Long) slot.fieldValue).longValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.931 -0400", hash_original_method = "47E293617D5F89E0481B6C58D6863D6B", hash_generated_method = "4917143C01BD74974322DD84F9961727")
    public Object get(String name, Object defaultValue) throws IllegalArgumentException {
        Object varB4EAC82CA7396A68D541C85D26508E83_391322650 = null; //Variable for return #1
        ObjectSlot slot;
        slot = findMandatorySlot(name, null);
        varB4EAC82CA7396A68D541C85D26508E83_391322650 = slot.defaulted ? defaultValue : slot.fieldValue;
        addTaint(name.getTaint());
        addTaint(defaultValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_391322650.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_391322650;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, null);
        //return slot.defaulted ? defaultValue : slot.fieldValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.941 -0400", hash_original_method = "EA3C9F151A3984D516E6CE85AC2BDF4D", hash_generated_method = "53DA75C655AC9B7C7F0C457ABBE0BB7B")
    public short get(String name, short defaultValue) throws IllegalArgumentException {
        ObjectSlot slot;
        slot = findMandatorySlot(name, short.class);
        {
            Object var13C4CE8E64A9512E0E8EB9D1EA80B5EA_302180214 = (((Short) slot.fieldValue).shortValue());
        } //End flattened ternary
        addTaint(name.getTaint());
        addTaint(defaultValue);
        short var4F09DAA9D95BCB166A302407A0E0BABE_1176251251 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1176251251;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, short.class);
        //return slot.defaulted ? defaultValue : ((Short) slot.fieldValue).shortValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.941 -0400", hash_original_method = "72E0CD60A94F0F11C444AC99B11C64E2", hash_generated_method = "9A7FD259BB36E26639557F2EDF337295")
    public boolean get(String name, boolean defaultValue) throws IllegalArgumentException {
        ObjectSlot slot;
        slot = findMandatorySlot(name, boolean.class);
        {
            Object varE99D10D0C62C2351E3AF6A6955E4A355_569501655 = (((Boolean) slot.fieldValue).booleanValue());
        } //End flattened ternary
        addTaint(name.getTaint());
        addTaint(defaultValue);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_639993193 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_639993193;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, boolean.class);
        //return slot.defaulted ? defaultValue : ((Boolean) slot.fieldValue).booleanValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.942 -0400", hash_original_method = "64C46ECEF3E0E1E6FE4F0FC120F58D81", hash_generated_method = "A7809C7E06B502F4A51334A4C8D0B0BE")
    public void put(String name, byte value) throws IllegalArgumentException {
        ObjectSlot slot;
        slot = findMandatorySlot(name, byte.class);
        slot.fieldValue = Byte.valueOf(value);
        slot.defaulted = false;
        addTaint(name.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, byte.class);
        //slot.fieldValue = Byte.valueOf(value);
        //slot.defaulted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.942 -0400", hash_original_method = "B195152936A8DE9E766C2D3BFA5BBEA4", hash_generated_method = "4321B8E4AC6E54AB0E54469E55B82056")
    public void put(String name, char value) throws IllegalArgumentException {
        ObjectSlot slot;
        slot = findMandatorySlot(name, char.class);
        slot.fieldValue = Character.valueOf(value);
        slot.defaulted = false;
        addTaint(name.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, char.class);
        //slot.fieldValue = Character.valueOf(value);
        //slot.defaulted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.942 -0400", hash_original_method = "3D642E33ABBFFAD3AE138739766C10D1", hash_generated_method = "67A7FAC947699BB1F42274B460C0BAA1")
    public void put(String name, double value) throws IllegalArgumentException {
        ObjectSlot slot;
        slot = findMandatorySlot(name, double.class);
        slot.fieldValue = Double.valueOf(value);
        slot.defaulted = false;
        addTaint(name.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, double.class);
        //slot.fieldValue = Double.valueOf(value);
        //slot.defaulted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.943 -0400", hash_original_method = "5C33ECB8D6052895E0E1DA7379AC4A20", hash_generated_method = "FBE90DD4422745ED0C62F6CFE28770E0")
    public void put(String name, float value) throws IllegalArgumentException {
        ObjectSlot slot;
        slot = findMandatorySlot(name, float.class);
        slot.fieldValue = Float.valueOf(value);
        slot.defaulted = false;
        addTaint(name.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, float.class);
        //slot.fieldValue = Float.valueOf(value);
        //slot.defaulted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.953 -0400", hash_original_method = "C7B64C133814D04EB5CE7945AB5C3FD6", hash_generated_method = "C4A01E85929072706F972CB453AD1F6D")
    public void put(String name, int value) throws IllegalArgumentException {
        ObjectSlot slot;
        slot = findMandatorySlot(name, int.class);
        slot.fieldValue = Integer.valueOf(value);
        slot.defaulted = false;
        addTaint(name.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, int.class);
        //slot.fieldValue = Integer.valueOf(value);
        //slot.defaulted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.954 -0400", hash_original_method = "4164B16D12FE76E9A5204CEE3F8D4A11", hash_generated_method = "F7AFCC3ACD6E2206D5AF643381F3BB3B")
    public void put(String name, long value) throws IllegalArgumentException {
        ObjectSlot slot;
        slot = findMandatorySlot(name, long.class);
        slot.fieldValue = Long.valueOf(value);
        slot.defaulted = false;
        addTaint(name.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, long.class);
        //slot.fieldValue = Long.valueOf(value);
        //slot.defaulted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.954 -0400", hash_original_method = "7164629BD662AF4C210D96FAFCA6D7A8", hash_generated_method = "DC0256AE1C59B801F2EBD9A4D720B01D")
    public void put(String name, Object value) throws IllegalArgumentException {
        Class<?> valueClass;
        valueClass = null;
        {
            valueClass = value.getClass();
        } //End block
        ObjectSlot slot;
        slot = findMandatorySlot(name, valueClass);
        slot.fieldValue = value;
        slot.defaulted = false;
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //Class<?> valueClass = null;
        //if (value != null) {
            //valueClass = value.getClass();
        //}
        //ObjectSlot slot = findMandatorySlot(name, valueClass);
        //slot.fieldValue = value;
        //slot.defaulted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.955 -0400", hash_original_method = "741DDC8469BC0231E1B51BB2B8F8F75A", hash_generated_method = "DFF2BB37409D3749D70AA26ECC3C9686")
    public void put(String name, short value) throws IllegalArgumentException {
        ObjectSlot slot;
        slot = findMandatorySlot(name, short.class);
        slot.fieldValue = Short.valueOf(value);
        slot.defaulted = false;
        addTaint(name.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, short.class);
        //slot.fieldValue = Short.valueOf(value);
        //slot.defaulted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.955 -0400", hash_original_method = "98E17CB3A991625B145B89A797910B92", hash_generated_method = "61C46BBEC9B5347D9DA2D9E403609B95")
    public void put(String name, boolean value) throws IllegalArgumentException {
        ObjectSlot slot;
        slot = findMandatorySlot(name, boolean.class);
        slot.fieldValue = Boolean.valueOf(value);
        slot.defaulted = false;
        addTaint(name.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, boolean.class);
        //slot.fieldValue = Boolean.valueOf(value);
        //slot.defaulted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.956 -0400", hash_original_method = "FD5D2C58D86BF6903270C5515850C93F", hash_generated_method = "F1AB2E7B50C63FB4C9CD5FBB9424A713")
    public ObjectSlot[] slots() {
        ObjectSlot[] varB4EAC82CA7396A68D541C85D26508E83_1241741175 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1241741175 = slotsToSerialize;
        varB4EAC82CA7396A68D541C85D26508E83_1241741175.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1241741175;
        // ---------- Original Method ----------
        //return slotsToSerialize;
    }

    
    static class ObjectSlot {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.956 -0400", hash_original_field = "06E3D36FA30CEA095545139854AD1FB9", hash_generated_field = "666B1AF45B3BB88D7A1E85239BC45DDE")

        ObjectStreamField field;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.956 -0400", hash_original_field = "319E2726BCC98302437312A8EBFE9DEB", hash_generated_field = "5E1F8EDBBFF3A4D528D4DA8B4EA5155F")

        Object fieldValue;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.956 -0400", hash_original_field = "0187220743CFC423830C110BC0022C97", hash_generated_field = "65016E670BD52C6342444B4F71434A83")

        boolean defaulted = true;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.956 -0400", hash_original_method = "57E475AF330CFB18924297ADFA41ECEA", hash_generated_method = "57E475AF330CFB18924297ADFA41ECEA")
        public ObjectSlot ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.971 -0400", hash_original_method = "59E78F3DAFAB25C124D589BA3544A531", hash_generated_method = "2237E194DD0C56CE8655D9C4A57F00AA")
        public ObjectStreamField getField() {
            ObjectStreamField varB4EAC82CA7396A68D541C85D26508E83_1457101980 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1457101980 = field;
            varB4EAC82CA7396A68D541C85D26508E83_1457101980.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1457101980;
            // ---------- Original Method ----------
            //return field;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.974 -0400", hash_original_method = "31B3B47C28245F569D31AEBE619B4C79", hash_generated_method = "F6ED2C633F221B31EEF03C0B80AA6EBF")
        public Object getFieldValue() {
            Object varB4EAC82CA7396A68D541C85D26508E83_997639138 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_997639138 = fieldValue;
            varB4EAC82CA7396A68D541C85D26508E83_997639138.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_997639138;
            // ---------- Original Method ----------
            //return fieldValue;
        }

        
    }


    
}

