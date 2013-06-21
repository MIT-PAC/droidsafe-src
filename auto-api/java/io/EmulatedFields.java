package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

class EmulatedFields {
    private ObjectSlot[] slotsToSerialize;
    private ObjectStreamField[] declaredFields;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.502 -0400", hash_original_method = "0D8BD958281DF75319EA682F9725E83E", hash_generated_method = "AFB74EB99F742C7EB68C0CB908B518F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public EmulatedFields(ObjectStreamField[] fields, ObjectStreamField[] declared) {
        dsTaint.addTaint(declared[0].dsTaint);
        dsTaint.addTaint(fields[0].dsTaint);
        buildSlots(fields);
        // ---------- Original Method ----------
        //buildSlots(fields);
        //declaredFields = declared;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.503 -0400", hash_original_method = "3EEF58200AED128D87652E78B0B409B1", hash_generated_method = "93F374E8A3C0108FFA7E49AE11790438")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void buildSlots(ObjectStreamField[] fields) {
        dsTaint.addTaint(fields[0].dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.504 -0400", hash_original_method = "1C69260A170F4832C171F7666BEC6CDB", hash_generated_method = "7A5F70463380248998B8E0419386DBAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean defaulted(String name) throws IllegalArgumentException {
        dsTaint.addTaint(name);
        ObjectSlot slot;
        slot = findSlot(name, null);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("no field '" + name + "'");
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //ObjectSlot slot = findSlot(name, null);
        //if (slot == null) {
            //throw new IllegalArgumentException("no field '" + name + "'");
        //}
        //return slot.defaulted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.504 -0400", hash_original_method = "713D4075A7BFE1E9122D10F9179E2FD5", hash_generated_method = "B0BEC227B43C8BA17BBB808DE16D92BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ObjectSlot findSlot(String fieldName, Class<?> fieldType) {
        dsTaint.addTaint(fieldType.dsTaint);
        dsTaint.addTaint(fieldName);
        boolean isPrimitive;
        isPrimitive = fieldType != null && fieldType.isPrimitive();
        {
            int i;
            i = 0;
            {
                ObjectSlot slot;
                slot = slotsToSerialize[i];
                {
                    boolean varE1A025364B8E6AFC98F7C14114BFC1C9_18520566 = (slot.field.getName().equals(fieldName));
                    {
                        {
                            {
                                boolean var4C117EB57B50631CF75F10A9EF1ED6FE_1477535666 = (slot.field.getType() == fieldType);
                            } //End collapsed parenthetic
                        } //End block
                        {
                            {
                                boolean var9D67CACB84C699C5888544F8AC0456AA_1794247101 = (slot.field.getType().isAssignableFrom(fieldType));
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
                        boolean var4191A3F7A9FD9BE075BD7EE74017F350_238565685 = (field.getName().equals(fieldName));
                        {
                            {
                                {
                                    boolean var4666DC710D79C14096A12900C769463C_1714158413 = (fieldType == field.getType());
                                    boolean varF815A1EC3DAD8366CF8B57C10E9CB2F4_1749076580 = (fieldType == null ||
                            field.getType().isAssignableFrom(fieldType));
                                } //End flattened ternary
                                {
                                    ObjectSlot slot;
                                    slot = new ObjectSlot();
                                    slot.field = field;
                                    slot.defaulted = true;
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (ObjectSlot)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.505 -0400", hash_original_method = "088986B40FCEDC0703EB00DECCCFDC49", hash_generated_method = "0A46F99438872D2289C1CC787B256B95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ObjectSlot findMandatorySlot(String name, Class<?> type) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(type.dsTaint);
        ObjectSlot slot;
        slot = findSlot(name, type);
        {
            boolean varCD9D80755B0AC12F3AA5AE1F870832F4_1756003299 = (slot == null || (type == null && slot.field.getType().isPrimitive()));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("no field '" + name + "' of type " + type);
            } //End block
        } //End collapsed parenthetic
        return (ObjectSlot)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ObjectSlot slot = findSlot(name, type);
        //if (slot == null || (type == null && slot.field.getType().isPrimitive())) {
            //throw new IllegalArgumentException("no field '" + name + "' of type " + type);
        //}
        //return slot;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.505 -0400", hash_original_method = "ACF5260920B1F0F677513369F3D8C323", hash_generated_method = "9823B230E7582396AA9C474E8D7DC85D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte get(String name, byte defaultValue) throws IllegalArgumentException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue);
        ObjectSlot slot;
        slot = findMandatorySlot(name, byte.class);
        {
            Object varA61D67A1EFD734703A5370EE608C7F9B_220925257 = (((Byte) slot.fieldValue).byteValue());
        } //End flattened ternary
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, byte.class);
        //return slot.defaulted ? defaultValue : ((Byte) slot.fieldValue).byteValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.505 -0400", hash_original_method = "97CAA651EBA3FEB1DEF47882147E3EE9", hash_generated_method = "AACFDC75A5AA6F1A40CAF7A2F10A83E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char get(String name, char defaultValue) throws IllegalArgumentException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue);
        ObjectSlot slot;
        slot = findMandatorySlot(name, char.class);
        {
            Object varC02FD45F6A7EEB0CF03847D6BA3665B3_104893237 = (((Character) slot.fieldValue).charValue());
        } //End flattened ternary
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, char.class);
        //return slot.defaulted ? defaultValue : ((Character) slot.fieldValue).charValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.506 -0400", hash_original_method = "8A61E03E38631E405F30500DFE3A2EED", hash_generated_method = "F61DF1FCF8360F8053D4E5AE9E1648C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public double get(String name, double defaultValue) throws IllegalArgumentException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue);
        ObjectSlot slot;
        slot = findMandatorySlot(name, double.class);
        {
            Object varD4B3EFEBFCF331341AF0274F0E7ED13E_273841954 = (((Double) slot.fieldValue).doubleValue());
        } //End flattened ternary
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, double.class);
        //return slot.defaulted ? defaultValue : ((Double) slot.fieldValue).doubleValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.506 -0400", hash_original_method = "2A99383382827F229576C5D7E3624FBA", hash_generated_method = "F01EA98197027DE64566CB7E889996A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float get(String name, float defaultValue) throws IllegalArgumentException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue);
        ObjectSlot slot;
        slot = findMandatorySlot(name, float.class);
        {
            Object varCBC5901392CA9930B5E4BDDE86F34A76_1319575417 = (((Float) slot.fieldValue).floatValue());
        } //End flattened ternary
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, float.class);
        //return slot.defaulted ? defaultValue : ((Float) slot.fieldValue).floatValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.506 -0400", hash_original_method = "348173917C5323C10E5D8A71A480A22F", hash_generated_method = "A7DE0FC37C47176A61541E4218C7F045")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int get(String name, int defaultValue) throws IllegalArgumentException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue);
        ObjectSlot slot;
        slot = findMandatorySlot(name, int.class);
        {
            Object var5D4D37262B4C33E914D6301DF923C625_1181746698 = (((Integer) slot.fieldValue).intValue());
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, int.class);
        //return slot.defaulted ? defaultValue : ((Integer) slot.fieldValue).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.507 -0400", hash_original_method = "57601B1EFC99CB5F2500857C9C4A7300", hash_generated_method = "F43B01A4DC4522C3EF9AB4AA2C3CA419")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long get(String name, long defaultValue) throws IllegalArgumentException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue);
        ObjectSlot slot;
        slot = findMandatorySlot(name, long.class);
        {
            Object varE5E5BEEA5FBF9B3BFCE247C007AFA58E_1665433917 = (((Long) slot.fieldValue).longValue());
        } //End flattened ternary
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, long.class);
        //return slot.defaulted ? defaultValue : ((Long) slot.fieldValue).longValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.507 -0400", hash_original_method = "47E293617D5F89E0481B6C58D6863D6B", hash_generated_method = "443948207EFC076C7CC47F8539B4D190")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object get(String name, Object defaultValue) throws IllegalArgumentException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue.dsTaint);
        ObjectSlot slot;
        slot = findMandatorySlot(name, null);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, null);
        //return slot.defaulted ? defaultValue : slot.fieldValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.507 -0400", hash_original_method = "EA3C9F151A3984D516E6CE85AC2BDF4D", hash_generated_method = "5A7F9378709D4BEC1407764DC19797D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public short get(String name, short defaultValue) throws IllegalArgumentException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue);
        ObjectSlot slot;
        slot = findMandatorySlot(name, short.class);
        {
            Object var13C4CE8E64A9512E0E8EB9D1EA80B5EA_671633433 = (((Short) slot.fieldValue).shortValue());
        } //End flattened ternary
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, short.class);
        //return slot.defaulted ? defaultValue : ((Short) slot.fieldValue).shortValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.508 -0400", hash_original_method = "72E0CD60A94F0F11C444AC99B11C64E2", hash_generated_method = "A47B1EF28009503B62116225E2E31D87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean get(String name, boolean defaultValue) throws IllegalArgumentException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(defaultValue);
        ObjectSlot slot;
        slot = findMandatorySlot(name, boolean.class);
        {
            Object varE99D10D0C62C2351E3AF6A6955E4A355_1930665059 = (((Boolean) slot.fieldValue).booleanValue());
        } //End flattened ternary
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, boolean.class);
        //return slot.defaulted ? defaultValue : ((Boolean) slot.fieldValue).booleanValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.508 -0400", hash_original_method = "64C46ECEF3E0E1E6FE4F0FC120F58D81", hash_generated_method = "08BBAF72A353CEFB86BFC8A9B3ACEA08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void put(String name, byte value) throws IllegalArgumentException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        ObjectSlot slot;
        slot = findMandatorySlot(name, byte.class);
        slot.fieldValue = Byte.valueOf(value);
        slot.defaulted = false;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, byte.class);
        //slot.fieldValue = Byte.valueOf(value);
        //slot.defaulted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.508 -0400", hash_original_method = "B195152936A8DE9E766C2D3BFA5BBEA4", hash_generated_method = "7731230FF46AC398983AD99008454513")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void put(String name, char value) throws IllegalArgumentException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        ObjectSlot slot;
        slot = findMandatorySlot(name, char.class);
        slot.fieldValue = Character.valueOf(value);
        slot.defaulted = false;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, char.class);
        //slot.fieldValue = Character.valueOf(value);
        //slot.defaulted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.508 -0400", hash_original_method = "3D642E33ABBFFAD3AE138739766C10D1", hash_generated_method = "8DFF525EA6EB5A0FAAA9F2920600DE6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void put(String name, double value) throws IllegalArgumentException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        ObjectSlot slot;
        slot = findMandatorySlot(name, double.class);
        slot.fieldValue = Double.valueOf(value);
        slot.defaulted = false;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, double.class);
        //slot.fieldValue = Double.valueOf(value);
        //slot.defaulted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.508 -0400", hash_original_method = "5C33ECB8D6052895E0E1DA7379AC4A20", hash_generated_method = "6C4C017A121D14E07627BBA6C81127A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void put(String name, float value) throws IllegalArgumentException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        ObjectSlot slot;
        slot = findMandatorySlot(name, float.class);
        slot.fieldValue = Float.valueOf(value);
        slot.defaulted = false;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, float.class);
        //slot.fieldValue = Float.valueOf(value);
        //slot.defaulted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.509 -0400", hash_original_method = "C7B64C133814D04EB5CE7945AB5C3FD6", hash_generated_method = "95B8A49302EAD48109DB111CFD3B9AD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void put(String name, int value) throws IllegalArgumentException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        ObjectSlot slot;
        slot = findMandatorySlot(name, int.class);
        slot.fieldValue = Integer.valueOf(value);
        slot.defaulted = false;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, int.class);
        //slot.fieldValue = Integer.valueOf(value);
        //slot.defaulted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.509 -0400", hash_original_method = "4164B16D12FE76E9A5204CEE3F8D4A11", hash_generated_method = "DA5955C7FBE33AD5CB4B83FBFBECD1A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void put(String name, long value) throws IllegalArgumentException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        ObjectSlot slot;
        slot = findMandatorySlot(name, long.class);
        slot.fieldValue = Long.valueOf(value);
        slot.defaulted = false;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, long.class);
        //slot.fieldValue = Long.valueOf(value);
        //slot.defaulted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.509 -0400", hash_original_method = "7164629BD662AF4C210D96FAFCA6D7A8", hash_generated_method = "74E574DED5AC2A9D74368A43CCADCA99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void put(String name, Object value) throws IllegalArgumentException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value.dsTaint);
        Class<?> valueClass;
        valueClass = null;
        {
            valueClass = value.getClass();
        } //End block
        ObjectSlot slot;
        slot = findMandatorySlot(name, valueClass);
        slot.fieldValue = value;
        slot.defaulted = false;
        // ---------- Original Method ----------
        //Class<?> valueClass = null;
        //if (value != null) {
            //valueClass = value.getClass();
        //}
        //ObjectSlot slot = findMandatorySlot(name, valueClass);
        //slot.fieldValue = value;
        //slot.defaulted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.509 -0400", hash_original_method = "741DDC8469BC0231E1B51BB2B8F8F75A", hash_generated_method = "B4619C2BE1CAC247AE6BE920499FDCDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void put(String name, short value) throws IllegalArgumentException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        ObjectSlot slot;
        slot = findMandatorySlot(name, short.class);
        slot.fieldValue = Short.valueOf(value);
        slot.defaulted = false;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, short.class);
        //slot.fieldValue = Short.valueOf(value);
        //slot.defaulted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.510 -0400", hash_original_method = "98E17CB3A991625B145B89A797910B92", hash_generated_method = "BE91319203BEC2227332DE5CF7D6E61F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void put(String name, boolean value) throws IllegalArgumentException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        ObjectSlot slot;
        slot = findMandatorySlot(name, boolean.class);
        slot.fieldValue = Boolean.valueOf(value);
        slot.defaulted = false;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, boolean.class);
        //slot.fieldValue = Boolean.valueOf(value);
        //slot.defaulted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.510 -0400", hash_original_method = "FD5D2C58D86BF6903270C5515850C93F", hash_generated_method = "39CA957D34A0C2C9D0A923ACEB8242CA")
    @DSModeled(DSC.SAFE)
    public ObjectSlot[] slots() {
        return (ObjectSlot[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return slotsToSerialize;
    }

    
    static class ObjectSlot {
        ObjectStreamField field;
        Object fieldValue;
        boolean defaulted = true;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.510 -0400", hash_original_method = "800B070C11F89355C4A9ACF30E8ECC98", hash_generated_method = "800B070C11F89355C4A9ACF30E8ECC98")
                public ObjectSlot ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.510 -0400", hash_original_method = "59E78F3DAFAB25C124D589BA3544A531", hash_generated_method = "BA49204EFB3FDACB1664E271D47ED09D")
        @DSModeled(DSC.SAFE)
        public ObjectStreamField getField() {
            return (ObjectStreamField)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return field;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.510 -0400", hash_original_method = "31B3B47C28245F569D31AEBE619B4C79", hash_generated_method = "BFCB45644A1943A146D22CF016E0891D")
        @DSModeled(DSC.SAFE)
        public Object getFieldValue() {
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return fieldValue;
        }

        
    }


    
}

