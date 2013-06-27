package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

class EmulatedFields {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.794 -0400", hash_original_field = "08BC91839408FD76B328A7D66B1893BD", hash_generated_field = "A5B1B9594264127836B75E232C6A005F")

    private ObjectSlot[] slotsToSerialize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.794 -0400", hash_original_field = "96A364EB816711FA9CF159A2CC04A8A6", hash_generated_field = "BA97D77EB4E493202875178557881AFD")

    private ObjectStreamField[] declaredFields;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.801 -0400", hash_original_method = "0D8BD958281DF75319EA682F9725E83E", hash_generated_method = "C421452236FD69F6E0A639F87D25F961")
    public  EmulatedFields(ObjectStreamField[] fields, ObjectStreamField[] declared) {
        buildSlots(fields);
        declaredFields = declared;
        addTaint(fields[0].getTaint());
        // ---------- Original Method ----------
        //buildSlots(fields);
        //declaredFields = declared;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.807 -0400", hash_original_method = "3EEF58200AED128D87652E78B0B409B1", hash_generated_method = "49980286C54B44CD43D854E34C8DAA51")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.808 -0400", hash_original_method = "1C69260A170F4832C171F7666BEC6CDB", hash_generated_method = "AF5CA7699AE3F2CA58EA9EAEF739BC3C")
    public boolean defaulted(String name) throws IllegalArgumentException {
        ObjectSlot slot;
        slot = findSlot(name, null);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("no field '" + name + "'");
        } //End block
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1291401352 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1291401352;
        // ---------- Original Method ----------
        //ObjectSlot slot = findSlot(name, null);
        //if (slot == null) {
            //throw new IllegalArgumentException("no field '" + name + "'");
        //}
        //return slot.defaulted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.815 -0400", hash_original_method = "713D4075A7BFE1E9122D10F9179E2FD5", hash_generated_method = "99DDAF3BACA8C1819FFA02C1E8F9EC1B")
    private ObjectSlot findSlot(String fieldName, Class<?> fieldType) {
        ObjectSlot varB4EAC82CA7396A68D541C85D26508E83_486262212 = null; //Variable for return #1
        ObjectSlot varB4EAC82CA7396A68D541C85D26508E83_2065079858 = null; //Variable for return #2
        ObjectSlot varB4EAC82CA7396A68D541C85D26508E83_1302794963 = null; //Variable for return #3
        ObjectSlot varB4EAC82CA7396A68D541C85D26508E83_1391812927 = null; //Variable for return #4
        ObjectSlot varB4EAC82CA7396A68D541C85D26508E83_2107752856 = null; //Variable for return #5
        boolean isPrimitive;
        isPrimitive = fieldType != null && fieldType.isPrimitive();
        {
            int i;
            i = 0;
            {
                ObjectSlot slot;
                slot = slotsToSerialize[i];
                {
                    boolean varE1A025364B8E6AFC98F7C14114BFC1C9_1257989957 = (slot.field.getName().equals(fieldName));
                    {
                        {
                            {
                                boolean var4C117EB57B50631CF75F10A9EF1ED6FE_1484430878 = (slot.field.getType() == fieldType);
                                {
                                    varB4EAC82CA7396A68D541C85D26508E83_486262212 = slot;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_2065079858 = slot;
                            } //End block
                            {
                                boolean var9D67CACB84C699C5888544F8AC0456AA_916283983 = (slot.field.getType().isAssignableFrom(fieldType));
                                {
                                    varB4EAC82CA7396A68D541C85D26508E83_1302794963 = slot;
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
                        boolean var4191A3F7A9FD9BE075BD7EE74017F350_1357910640 = (field.getName().equals(fieldName));
                        {
                            {
                                {
                                    boolean var4666DC710D79C14096A12900C769463C_1917095215 = (fieldType == field.getType());
                                    boolean varF815A1EC3DAD8366CF8B57C10E9CB2F4_1473531010 = (fieldType == null ||
                            field.getType().isAssignableFrom(fieldType));
                                } //End flattened ternary
                                {
                                    ObjectSlot slot;
                                    slot = new ObjectSlot();
                                    slot.field = field;
                                    slot.defaulted = true;
                                    varB4EAC82CA7396A68D541C85D26508E83_1391812927 = slot;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2107752856 = null;
        addTaint(fieldName.getTaint());
        addTaint(fieldType.getTaint());
        ObjectSlot varA7E53CE21691AB073D9660D615818899_1904385711; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1904385711 = varB4EAC82CA7396A68D541C85D26508E83_486262212;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1904385711 = varB4EAC82CA7396A68D541C85D26508E83_2065079858;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1904385711 = varB4EAC82CA7396A68D541C85D26508E83_1302794963;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1904385711 = varB4EAC82CA7396A68D541C85D26508E83_1391812927;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1904385711 = varB4EAC82CA7396A68D541C85D26508E83_2107752856;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1904385711.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1904385711;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.819 -0400", hash_original_method = "088986B40FCEDC0703EB00DECCCFDC49", hash_generated_method = "0C25BFFB68D8FECFCB6B3FAED14D4EED")
    private ObjectSlot findMandatorySlot(String name, Class<?> type) {
        ObjectSlot varB4EAC82CA7396A68D541C85D26508E83_1270411763 = null; //Variable for return #1
        ObjectSlot slot;
        slot = findSlot(name, type);
        {
            boolean varCD9D80755B0AC12F3AA5AE1F870832F4_403081419 = (slot == null || (type == null && slot.field.getType().isPrimitive()));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("no field '" + name + "' of type " + type);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1270411763 = slot;
        addTaint(name.getTaint());
        addTaint(type.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1270411763.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1270411763;
        // ---------- Original Method ----------
        //ObjectSlot slot = findSlot(name, type);
        //if (slot == null || (type == null && slot.field.getType().isPrimitive())) {
            //throw new IllegalArgumentException("no field '" + name + "' of type " + type);
        //}
        //return slot;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.824 -0400", hash_original_method = "ACF5260920B1F0F677513369F3D8C323", hash_generated_method = "B18B33BBD0C2A414C008E7A46107EF92")
    public byte get(String name, byte defaultValue) throws IllegalArgumentException {
        ObjectSlot slot;
        slot = findMandatorySlot(name, byte.class);
        {
            Object varA61D67A1EFD734703A5370EE608C7F9B_1566412788 = (((Byte) slot.fieldValue).byteValue());
        } //End flattened ternary
        addTaint(name.getTaint());
        addTaint(defaultValue);
        byte var40EA57D3EE3C07BF1C102B466E1C3091_1723447511 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1723447511;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, byte.class);
        //return slot.defaulted ? defaultValue : ((Byte) slot.fieldValue).byteValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.824 -0400", hash_original_method = "97CAA651EBA3FEB1DEF47882147E3EE9", hash_generated_method = "54C9260247785CCA4879841655C61F40")
    public char get(String name, char defaultValue) throws IllegalArgumentException {
        ObjectSlot slot;
        slot = findMandatorySlot(name, char.class);
        {
            Object varC02FD45F6A7EEB0CF03847D6BA3665B3_1175495791 = (((Character) slot.fieldValue).charValue());
        } //End flattened ternary
        addTaint(name.getTaint());
        addTaint(defaultValue);
        char varA87DEB01C5F539E6BDA34829C8EF2368_1602053633 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1602053633;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, char.class);
        //return slot.defaulted ? defaultValue : ((Character) slot.fieldValue).charValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.825 -0400", hash_original_method = "8A61E03E38631E405F30500DFE3A2EED", hash_generated_method = "FC4533C9C45A77C929F5DB62A365DDEB")
    public double get(String name, double defaultValue) throws IllegalArgumentException {
        ObjectSlot slot;
        slot = findMandatorySlot(name, double.class);
        {
            Object varD4B3EFEBFCF331341AF0274F0E7ED13E_561542534 = (((Double) slot.fieldValue).doubleValue());
        } //End flattened ternary
        addTaint(name.getTaint());
        addTaint(defaultValue);
        double varE8CD7DA078A86726031AD64F35F5A6C0_2042145770 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_2042145770;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, double.class);
        //return slot.defaulted ? defaultValue : ((Double) slot.fieldValue).doubleValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.825 -0400", hash_original_method = "2A99383382827F229576C5D7E3624FBA", hash_generated_method = "66609BA807D763682F24655AE5698D1F")
    public float get(String name, float defaultValue) throws IllegalArgumentException {
        ObjectSlot slot;
        slot = findMandatorySlot(name, float.class);
        {
            Object varCBC5901392CA9930B5E4BDDE86F34A76_945265986 = (((Float) slot.fieldValue).floatValue());
        } //End flattened ternary
        addTaint(name.getTaint());
        addTaint(defaultValue);
        float var546ADE640B6EDFBC8A086EF31347E768_1185018500 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1185018500;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, float.class);
        //return slot.defaulted ? defaultValue : ((Float) slot.fieldValue).floatValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.836 -0400", hash_original_method = "348173917C5323C10E5D8A71A480A22F", hash_generated_method = "8C857169E7B668AA51004BBA855A63DB")
    public int get(String name, int defaultValue) throws IllegalArgumentException {
        ObjectSlot slot;
        slot = findMandatorySlot(name, int.class);
        {
            Object var5D4D37262B4C33E914D6301DF923C625_858870385 = (((Integer) slot.fieldValue).intValue());
        } //End flattened ternary
        addTaint(name.getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_465083186 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_465083186;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, int.class);
        //return slot.defaulted ? defaultValue : ((Integer) slot.fieldValue).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.843 -0400", hash_original_method = "57601B1EFC99CB5F2500857C9C4A7300", hash_generated_method = "218E6DD39DC3F16EFBB1D4E4BD5B1A30")
    public long get(String name, long defaultValue) throws IllegalArgumentException {
        ObjectSlot slot;
        slot = findMandatorySlot(name, long.class);
        {
            Object varE5E5BEEA5FBF9B3BFCE247C007AFA58E_114555106 = (((Long) slot.fieldValue).longValue());
        } //End flattened ternary
        addTaint(name.getTaint());
        addTaint(defaultValue);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_936211744 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_936211744;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, long.class);
        //return slot.defaulted ? defaultValue : ((Long) slot.fieldValue).longValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.845 -0400", hash_original_method = "47E293617D5F89E0481B6C58D6863D6B", hash_generated_method = "88A3D29B4278CDE0D05C56C5D7C89944")
    public Object get(String name, Object defaultValue) throws IllegalArgumentException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1260314263 = null; //Variable for return #1
        ObjectSlot slot;
        slot = findMandatorySlot(name, null);
        varB4EAC82CA7396A68D541C85D26508E83_1260314263 = slot.defaulted ? defaultValue : slot.fieldValue;
        addTaint(name.getTaint());
        addTaint(defaultValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1260314263.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1260314263;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, null);
        //return slot.defaulted ? defaultValue : slot.fieldValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.845 -0400", hash_original_method = "EA3C9F151A3984D516E6CE85AC2BDF4D", hash_generated_method = "5CE0332E57BF911C88A7F1390AAE50EF")
    public short get(String name, short defaultValue) throws IllegalArgumentException {
        ObjectSlot slot;
        slot = findMandatorySlot(name, short.class);
        {
            Object var13C4CE8E64A9512E0E8EB9D1EA80B5EA_1544279888 = (((Short) slot.fieldValue).shortValue());
        } //End flattened ternary
        addTaint(name.getTaint());
        addTaint(defaultValue);
        short var4F09DAA9D95BCB166A302407A0E0BABE_820317008 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_820317008;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, short.class);
        //return slot.defaulted ? defaultValue : ((Short) slot.fieldValue).shortValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.850 -0400", hash_original_method = "72E0CD60A94F0F11C444AC99B11C64E2", hash_generated_method = "6FEB984C4A3D0295C7D7C7C85C3F3A7B")
    public boolean get(String name, boolean defaultValue) throws IllegalArgumentException {
        ObjectSlot slot;
        slot = findMandatorySlot(name, boolean.class);
        {
            Object varE99D10D0C62C2351E3AF6A6955E4A355_1413384216 = (((Boolean) slot.fieldValue).booleanValue());
        } //End flattened ternary
        addTaint(name.getTaint());
        addTaint(defaultValue);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1256745455 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1256745455;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, boolean.class);
        //return slot.defaulted ? defaultValue : ((Boolean) slot.fieldValue).booleanValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.851 -0400", hash_original_method = "64C46ECEF3E0E1E6FE4F0FC120F58D81", hash_generated_method = "A7809C7E06B502F4A51334A4C8D0B0BE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.851 -0400", hash_original_method = "B195152936A8DE9E766C2D3BFA5BBEA4", hash_generated_method = "4321B8E4AC6E54AB0E54469E55B82056")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.864 -0400", hash_original_method = "3D642E33ABBFFAD3AE138739766C10D1", hash_generated_method = "67A7FAC947699BB1F42274B460C0BAA1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.865 -0400", hash_original_method = "5C33ECB8D6052895E0E1DA7379AC4A20", hash_generated_method = "FBE90DD4422745ED0C62F6CFE28770E0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.866 -0400", hash_original_method = "C7B64C133814D04EB5CE7945AB5C3FD6", hash_generated_method = "C4A01E85929072706F972CB453AD1F6D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.866 -0400", hash_original_method = "4164B16D12FE76E9A5204CEE3F8D4A11", hash_generated_method = "F7AFCC3ACD6E2206D5AF643381F3BB3B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.867 -0400", hash_original_method = "7164629BD662AF4C210D96FAFCA6D7A8", hash_generated_method = "DC0256AE1C59B801F2EBD9A4D720B01D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.867 -0400", hash_original_method = "741DDC8469BC0231E1B51BB2B8F8F75A", hash_generated_method = "DFF2BB37409D3749D70AA26ECC3C9686")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.867 -0400", hash_original_method = "98E17CB3A991625B145B89A797910B92", hash_generated_method = "61C46BBEC9B5347D9DA2D9E403609B95")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.873 -0400", hash_original_method = "FD5D2C58D86BF6903270C5515850C93F", hash_generated_method = "344CC08EBF249BE7E7C8B80413390CE1")
    public ObjectSlot[] slots() {
        ObjectSlot[] varB4EAC82CA7396A68D541C85D26508E83_636967091 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_636967091 = slotsToSerialize;
        varB4EAC82CA7396A68D541C85D26508E83_636967091.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_636967091;
        // ---------- Original Method ----------
        //return slotsToSerialize;
    }

    
    static class ObjectSlot {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.874 -0400", hash_original_field = "06E3D36FA30CEA095545139854AD1FB9", hash_generated_field = "666B1AF45B3BB88D7A1E85239BC45DDE")

        ObjectStreamField field;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.874 -0400", hash_original_field = "319E2726BCC98302437312A8EBFE9DEB", hash_generated_field = "5E1F8EDBBFF3A4D528D4DA8B4EA5155F")

        Object fieldValue;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.874 -0400", hash_original_field = "0187220743CFC423830C110BC0022C97", hash_generated_field = "65016E670BD52C6342444B4F71434A83")

        boolean defaulted = true;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.874 -0400", hash_original_method = "57E475AF330CFB18924297ADFA41ECEA", hash_generated_method = "57E475AF330CFB18924297ADFA41ECEA")
        public ObjectSlot ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.874 -0400", hash_original_method = "59E78F3DAFAB25C124D589BA3544A531", hash_generated_method = "A3FC6F80BFFF7B91EF55A3520E2803B2")
        public ObjectStreamField getField() {
            ObjectStreamField varB4EAC82CA7396A68D541C85D26508E83_1540853464 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1540853464 = field;
            varB4EAC82CA7396A68D541C85D26508E83_1540853464.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1540853464;
            // ---------- Original Method ----------
            //return field;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.875 -0400", hash_original_method = "31B3B47C28245F569D31AEBE619B4C79", hash_generated_method = "DF03DE946E5F198AC57A9B0773E6BDD7")
        public Object getFieldValue() {
            Object varB4EAC82CA7396A68D541C85D26508E83_645995000 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_645995000 = fieldValue;
            varB4EAC82CA7396A68D541C85D26508E83_645995000.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_645995000;
            // ---------- Original Method ----------
            //return fieldValue;
        }

        
    }


    
}

