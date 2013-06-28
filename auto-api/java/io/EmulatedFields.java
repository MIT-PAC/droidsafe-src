package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

class EmulatedFields {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.702 -0400", hash_original_field = "08BC91839408FD76B328A7D66B1893BD", hash_generated_field = "A5B1B9594264127836B75E232C6A005F")

    private ObjectSlot[] slotsToSerialize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.702 -0400", hash_original_field = "96A364EB816711FA9CF159A2CC04A8A6", hash_generated_field = "BA97D77EB4E493202875178557881AFD")

    private ObjectStreamField[] declaredFields;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.702 -0400", hash_original_method = "0D8BD958281DF75319EA682F9725E83E", hash_generated_method = "C421452236FD69F6E0A639F87D25F961")
    public  EmulatedFields(ObjectStreamField[] fields, ObjectStreamField[] declared) {
        buildSlots(fields);
        declaredFields = declared;
        addTaint(fields[0].getTaint());
        // ---------- Original Method ----------
        //buildSlots(fields);
        //declaredFields = declared;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.702 -0400", hash_original_method = "3EEF58200AED128D87652E78B0B409B1", hash_generated_method = "F0B69E9244648FD0465FE93359D782A7")
    private void buildSlots(ObjectStreamField[] fields) {
        slotsToSerialize = new ObjectSlot[fields.length];
        {
            int i = 0;
            {
                ObjectSlot s = new ObjectSlot();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.703 -0400", hash_original_method = "1C69260A170F4832C171F7666BEC6CDB", hash_generated_method = "551653AC0DD06B3C6F3BDDCD75D78133")
    public boolean defaulted(String name) throws IllegalArgumentException {
        ObjectSlot slot = findSlot(name, null);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("no field '" + name + "'");
        } //End block
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_959887162 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_959887162;
        // ---------- Original Method ----------
        //ObjectSlot slot = findSlot(name, null);
        //if (slot == null) {
            //throw new IllegalArgumentException("no field '" + name + "'");
        //}
        //return slot.defaulted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.704 -0400", hash_original_method = "713D4075A7BFE1E9122D10F9179E2FD5", hash_generated_method = "5EF2428140F6710C531E14BEF9CF6F98")
    private ObjectSlot findSlot(String fieldName, Class<?> fieldType) {
        ObjectSlot varB4EAC82CA7396A68D541C85D26508E83_1029818974 = null; //Variable for return #1
        ObjectSlot varB4EAC82CA7396A68D541C85D26508E83_322758273 = null; //Variable for return #2
        ObjectSlot varB4EAC82CA7396A68D541C85D26508E83_1454493521 = null; //Variable for return #3
        ObjectSlot varB4EAC82CA7396A68D541C85D26508E83_107553956 = null; //Variable for return #4
        ObjectSlot varB4EAC82CA7396A68D541C85D26508E83_1455233887 = null; //Variable for return #5
        boolean isPrimitive = fieldType != null && fieldType.isPrimitive();
        {
            int i = 0;
            {
                ObjectSlot slot = slotsToSerialize[i];
                {
                    boolean varE1A025364B8E6AFC98F7C14114BFC1C9_126251694 = (slot.field.getName().equals(fieldName));
                    {
                        {
                            {
                                boolean var4C117EB57B50631CF75F10A9EF1ED6FE_726087942 = (slot.field.getType() == fieldType);
                                {
                                    varB4EAC82CA7396A68D541C85D26508E83_1029818974 = slot;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_322758273 = slot;
                            } //End block
                            {
                                boolean var9D67CACB84C699C5888544F8AC0456AA_1844589214 = (slot.field.getType().isAssignableFrom(fieldType));
                                {
                                    varB4EAC82CA7396A68D541C85D26508E83_1454493521 = slot;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            {
                int i = 0;
                {
                    ObjectStreamField field = declaredFields[i];
                    {
                        boolean var4191A3F7A9FD9BE075BD7EE74017F350_18388457 = (field.getName().equals(fieldName));
                        {
                            {
                                {
                                    boolean var4666DC710D79C14096A12900C769463C_162001788 = (fieldType == field.getType());
                                    boolean varF815A1EC3DAD8366CF8B57C10E9CB2F4_1372560114 = (fieldType == null ||
                            field.getType().isAssignableFrom(fieldType));
                                } //End flattened ternary
                                {
                                    ObjectSlot slot = new ObjectSlot();
                                    slot.field = field;
                                    slot.defaulted = true;
                                    varB4EAC82CA7396A68D541C85D26508E83_107553956 = slot;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1455233887 = null;
        addTaint(fieldName.getTaint());
        addTaint(fieldType.getTaint());
        ObjectSlot varA7E53CE21691AB073D9660D615818899_1002679001; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1002679001 = varB4EAC82CA7396A68D541C85D26508E83_1029818974;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1002679001 = varB4EAC82CA7396A68D541C85D26508E83_322758273;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1002679001 = varB4EAC82CA7396A68D541C85D26508E83_1454493521;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1002679001 = varB4EAC82CA7396A68D541C85D26508E83_107553956;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1002679001 = varB4EAC82CA7396A68D541C85D26508E83_1455233887;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1002679001.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1002679001;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.706 -0400", hash_original_method = "088986B40FCEDC0703EB00DECCCFDC49", hash_generated_method = "9ECB9619F99758AABB677FE63633353F")
    private ObjectSlot findMandatorySlot(String name, Class<?> type) {
        ObjectSlot varB4EAC82CA7396A68D541C85D26508E83_1750782623 = null; //Variable for return #1
        ObjectSlot slot = findSlot(name, type);
        {
            boolean varCD9D80755B0AC12F3AA5AE1F870832F4_799929929 = (slot == null || (type == null && slot.field.getType().isPrimitive()));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("no field '" + name + "' of type " + type);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1750782623 = slot;
        addTaint(name.getTaint());
        addTaint(type.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1750782623.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1750782623;
        // ---------- Original Method ----------
        //ObjectSlot slot = findSlot(name, type);
        //if (slot == null || (type == null && slot.field.getType().isPrimitive())) {
            //throw new IllegalArgumentException("no field '" + name + "' of type " + type);
        //}
        //return slot;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.707 -0400", hash_original_method = "ACF5260920B1F0F677513369F3D8C323", hash_generated_method = "BBF98EF2B6C7DEDE8ED562BE2752E857")
    public byte get(String name, byte defaultValue) throws IllegalArgumentException {
        ObjectSlot slot = findMandatorySlot(name, byte.class);
        {
            Object varA61D67A1EFD734703A5370EE608C7F9B_1205850679 = (((Byte) slot.fieldValue).byteValue());
        } //End flattened ternary
        addTaint(name.getTaint());
        addTaint(defaultValue);
        byte var40EA57D3EE3C07BF1C102B466E1C3091_1667573036 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1667573036;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, byte.class);
        //return slot.defaulted ? defaultValue : ((Byte) slot.fieldValue).byteValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.707 -0400", hash_original_method = "97CAA651EBA3FEB1DEF47882147E3EE9", hash_generated_method = "3DBC1BC91BE86D00F34A2F0377087BC1")
    public char get(String name, char defaultValue) throws IllegalArgumentException {
        ObjectSlot slot = findMandatorySlot(name, char.class);
        {
            Object varC02FD45F6A7EEB0CF03847D6BA3665B3_1991433762 = (((Character) slot.fieldValue).charValue());
        } //End flattened ternary
        addTaint(name.getTaint());
        addTaint(defaultValue);
        char varA87DEB01C5F539E6BDA34829C8EF2368_810441759 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_810441759;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, char.class);
        //return slot.defaulted ? defaultValue : ((Character) slot.fieldValue).charValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.708 -0400", hash_original_method = "8A61E03E38631E405F30500DFE3A2EED", hash_generated_method = "255C3135C44217D9AD07E20E126E998F")
    public double get(String name, double defaultValue) throws IllegalArgumentException {
        ObjectSlot slot = findMandatorySlot(name, double.class);
        {
            Object varD4B3EFEBFCF331341AF0274F0E7ED13E_538893716 = (((Double) slot.fieldValue).doubleValue());
        } //End flattened ternary
        addTaint(name.getTaint());
        addTaint(defaultValue);
        double varE8CD7DA078A86726031AD64F35F5A6C0_655657617 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_655657617;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, double.class);
        //return slot.defaulted ? defaultValue : ((Double) slot.fieldValue).doubleValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.709 -0400", hash_original_method = "2A99383382827F229576C5D7E3624FBA", hash_generated_method = "9FFC72201229418A41CA42DAE634FAD0")
    public float get(String name, float defaultValue) throws IllegalArgumentException {
        ObjectSlot slot = findMandatorySlot(name, float.class);
        {
            Object varCBC5901392CA9930B5E4BDDE86F34A76_1602940506 = (((Float) slot.fieldValue).floatValue());
        } //End flattened ternary
        addTaint(name.getTaint());
        addTaint(defaultValue);
        float var546ADE640B6EDFBC8A086EF31347E768_5987146 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_5987146;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, float.class);
        //return slot.defaulted ? defaultValue : ((Float) slot.fieldValue).floatValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.709 -0400", hash_original_method = "348173917C5323C10E5D8A71A480A22F", hash_generated_method = "2DC6EFD484F092882437DCDB789E9E52")
    public int get(String name, int defaultValue) throws IllegalArgumentException {
        ObjectSlot slot = findMandatorySlot(name, int.class);
        {
            Object var5D4D37262B4C33E914D6301DF923C625_1233390874 = (((Integer) slot.fieldValue).intValue());
        } //End flattened ternary
        addTaint(name.getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1282472705 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1282472705;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, int.class);
        //return slot.defaulted ? defaultValue : ((Integer) slot.fieldValue).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.710 -0400", hash_original_method = "57601B1EFC99CB5F2500857C9C4A7300", hash_generated_method = "62CA79C5494617344D5F9A6D57A027E3")
    public long get(String name, long defaultValue) throws IllegalArgumentException {
        ObjectSlot slot = findMandatorySlot(name, long.class);
        {
            Object varE5E5BEEA5FBF9B3BFCE247C007AFA58E_1601339011 = (((Long) slot.fieldValue).longValue());
        } //End flattened ternary
        addTaint(name.getTaint());
        addTaint(defaultValue);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1476549988 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1476549988;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, long.class);
        //return slot.defaulted ? defaultValue : ((Long) slot.fieldValue).longValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.710 -0400", hash_original_method = "47E293617D5F89E0481B6C58D6863D6B", hash_generated_method = "FDE2CAFD82A937A6FA6C79247343000E")
    public Object get(String name, Object defaultValue) throws IllegalArgumentException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1215424752 = null; //Variable for return #1
        ObjectSlot slot = findMandatorySlot(name, null);
        varB4EAC82CA7396A68D541C85D26508E83_1215424752 = slot.defaulted ? defaultValue : slot.fieldValue;
        addTaint(name.getTaint());
        addTaint(defaultValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1215424752.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1215424752;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, null);
        //return slot.defaulted ? defaultValue : slot.fieldValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.711 -0400", hash_original_method = "EA3C9F151A3984D516E6CE85AC2BDF4D", hash_generated_method = "8B98D1CB09C618422DAF8EEB7444A34B")
    public short get(String name, short defaultValue) throws IllegalArgumentException {
        ObjectSlot slot = findMandatorySlot(name, short.class);
        {
            Object var13C4CE8E64A9512E0E8EB9D1EA80B5EA_1816831626 = (((Short) slot.fieldValue).shortValue());
        } //End flattened ternary
        addTaint(name.getTaint());
        addTaint(defaultValue);
        short var4F09DAA9D95BCB166A302407A0E0BABE_1257508050 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1257508050;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, short.class);
        //return slot.defaulted ? defaultValue : ((Short) slot.fieldValue).shortValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.711 -0400", hash_original_method = "72E0CD60A94F0F11C444AC99B11C64E2", hash_generated_method = "BA3825E4FB4788A9CDCBDF44E3EE9275")
    public boolean get(String name, boolean defaultValue) throws IllegalArgumentException {
        ObjectSlot slot = findMandatorySlot(name, boolean.class);
        {
            Object varE99D10D0C62C2351E3AF6A6955E4A355_969658329 = (((Boolean) slot.fieldValue).booleanValue());
        } //End flattened ternary
        addTaint(name.getTaint());
        addTaint(defaultValue);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_546244258 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_546244258;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, boolean.class);
        //return slot.defaulted ? defaultValue : ((Boolean) slot.fieldValue).booleanValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.711 -0400", hash_original_method = "64C46ECEF3E0E1E6FE4F0FC120F58D81", hash_generated_method = "D895E2D24F7CA1CAC8C2D57779F3EA2D")
    public void put(String name, byte value) throws IllegalArgumentException {
        ObjectSlot slot = findMandatorySlot(name, byte.class);
        slot.fieldValue = Byte.valueOf(value);
        slot.defaulted = false;
        addTaint(name.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, byte.class);
        //slot.fieldValue = Byte.valueOf(value);
        //slot.defaulted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.712 -0400", hash_original_method = "B195152936A8DE9E766C2D3BFA5BBEA4", hash_generated_method = "DABEBC5C3766CAE6460FB2A041B4D7C8")
    public void put(String name, char value) throws IllegalArgumentException {
        ObjectSlot slot = findMandatorySlot(name, char.class);
        slot.fieldValue = Character.valueOf(value);
        slot.defaulted = false;
        addTaint(name.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, char.class);
        //slot.fieldValue = Character.valueOf(value);
        //slot.defaulted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.712 -0400", hash_original_method = "3D642E33ABBFFAD3AE138739766C10D1", hash_generated_method = "783946189FD3BC012E273C841720E2B7")
    public void put(String name, double value) throws IllegalArgumentException {
        ObjectSlot slot = findMandatorySlot(name, double.class);
        slot.fieldValue = Double.valueOf(value);
        slot.defaulted = false;
        addTaint(name.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, double.class);
        //slot.fieldValue = Double.valueOf(value);
        //slot.defaulted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.712 -0400", hash_original_method = "5C33ECB8D6052895E0E1DA7379AC4A20", hash_generated_method = "3F05C3A5D68F09AD02F77304A0F3D02F")
    public void put(String name, float value) throws IllegalArgumentException {
        ObjectSlot slot = findMandatorySlot(name, float.class);
        slot.fieldValue = Float.valueOf(value);
        slot.defaulted = false;
        addTaint(name.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, float.class);
        //slot.fieldValue = Float.valueOf(value);
        //slot.defaulted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.713 -0400", hash_original_method = "C7B64C133814D04EB5CE7945AB5C3FD6", hash_generated_method = "A8F5983D787613240210CBD61D30AA26")
    public void put(String name, int value) throws IllegalArgumentException {
        ObjectSlot slot = findMandatorySlot(name, int.class);
        slot.fieldValue = Integer.valueOf(value);
        slot.defaulted = false;
        addTaint(name.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, int.class);
        //slot.fieldValue = Integer.valueOf(value);
        //slot.defaulted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.713 -0400", hash_original_method = "4164B16D12FE76E9A5204CEE3F8D4A11", hash_generated_method = "4EC3A2729182B2659AA3F6F4CA4097D3")
    public void put(String name, long value) throws IllegalArgumentException {
        ObjectSlot slot = findMandatorySlot(name, long.class);
        slot.fieldValue = Long.valueOf(value);
        slot.defaulted = false;
        addTaint(name.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, long.class);
        //slot.fieldValue = Long.valueOf(value);
        //slot.defaulted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.713 -0400", hash_original_method = "7164629BD662AF4C210D96FAFCA6D7A8", hash_generated_method = "AD5D57A630FAC0FE7C07EE3BA85F9BFA")
    public void put(String name, Object value) throws IllegalArgumentException {
        Class<?> valueClass = null;
        {
            valueClass = value.getClass();
        } //End block
        ObjectSlot slot = findMandatorySlot(name, valueClass);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.714 -0400", hash_original_method = "741DDC8469BC0231E1B51BB2B8F8F75A", hash_generated_method = "7B269518E697BDC58B56A855E1612C9A")
    public void put(String name, short value) throws IllegalArgumentException {
        ObjectSlot slot = findMandatorySlot(name, short.class);
        slot.fieldValue = Short.valueOf(value);
        slot.defaulted = false;
        addTaint(name.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, short.class);
        //slot.fieldValue = Short.valueOf(value);
        //slot.defaulted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.714 -0400", hash_original_method = "98E17CB3A991625B145B89A797910B92", hash_generated_method = "111F763B0853D894FFCAF79F25078BFE")
    public void put(String name, boolean value) throws IllegalArgumentException {
        ObjectSlot slot = findMandatorySlot(name, boolean.class);
        slot.fieldValue = Boolean.valueOf(value);
        slot.defaulted = false;
        addTaint(name.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, boolean.class);
        //slot.fieldValue = Boolean.valueOf(value);
        //slot.defaulted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.715 -0400", hash_original_method = "FD5D2C58D86BF6903270C5515850C93F", hash_generated_method = "A65295C1671A16E8714CA47251484A95")
    public ObjectSlot[] slots() {
        ObjectSlot[] varB4EAC82CA7396A68D541C85D26508E83_1725316473 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1725316473 = slotsToSerialize;
        varB4EAC82CA7396A68D541C85D26508E83_1725316473.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1725316473;
        // ---------- Original Method ----------
        //return slotsToSerialize;
    }

    
    static class ObjectSlot {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.715 -0400", hash_original_field = "06E3D36FA30CEA095545139854AD1FB9", hash_generated_field = "666B1AF45B3BB88D7A1E85239BC45DDE")

        ObjectStreamField field;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.715 -0400", hash_original_field = "319E2726BCC98302437312A8EBFE9DEB", hash_generated_field = "5E1F8EDBBFF3A4D528D4DA8B4EA5155F")

        Object fieldValue;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.715 -0400", hash_original_field = "0187220743CFC423830C110BC0022C97", hash_generated_field = "65016E670BD52C6342444B4F71434A83")

        boolean defaulted = true;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.715 -0400", hash_original_method = "57E475AF330CFB18924297ADFA41ECEA", hash_generated_method = "57E475AF330CFB18924297ADFA41ECEA")
        public ObjectSlot ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.715 -0400", hash_original_method = "59E78F3DAFAB25C124D589BA3544A531", hash_generated_method = "E62FB00B2BBF91C2C3B063DE6BA0ECBE")
        public ObjectStreamField getField() {
            ObjectStreamField varB4EAC82CA7396A68D541C85D26508E83_17275482 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_17275482 = field;
            varB4EAC82CA7396A68D541C85D26508E83_17275482.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_17275482;
            // ---------- Original Method ----------
            //return field;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.716 -0400", hash_original_method = "31B3B47C28245F569D31AEBE619B4C79", hash_generated_method = "992A2180879847408FDD39688E3A34A5")
        public Object getFieldValue() {
            Object varB4EAC82CA7396A68D541C85D26508E83_820494331 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_820494331 = fieldValue;
            varB4EAC82CA7396A68D541C85D26508E83_820494331.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_820494331;
            // ---------- Original Method ----------
            //return fieldValue;
        }

        
    }


    
}

