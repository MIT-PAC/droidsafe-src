package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

class EmulatedFields {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.668 -0400", hash_original_field = "08BC91839408FD76B328A7D66B1893BD", hash_generated_field = "A5B1B9594264127836B75E232C6A005F")

    private ObjectSlot[] slotsToSerialize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.668 -0400", hash_original_field = "96A364EB816711FA9CF159A2CC04A8A6", hash_generated_field = "BA97D77EB4E493202875178557881AFD")

    private ObjectStreamField[] declaredFields;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.669 -0400", hash_original_method = "0D8BD958281DF75319EA682F9725E83E", hash_generated_method = "0F804F44801AA3E5A0684B5A9D4837D9")
    public  EmulatedFields(ObjectStreamField[] fields, ObjectStreamField[] declared) {
        addTaint(fields[0].getTaint());
        buildSlots(fields);
        declaredFields = declared;
        // ---------- Original Method ----------
        //buildSlots(fields);
        //declaredFields = declared;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.670 -0400", hash_original_method = "3EEF58200AED128D87652E78B0B409B1", hash_generated_method = "131CBFC1EF81FAE1AEA746B87ED0707C")
    private void buildSlots(ObjectStreamField[] fields) {
        slotsToSerialize = new ObjectSlot[fields.length];
for(int i = 0;i < fields.length;i++)
        {
            ObjectSlot s = new ObjectSlot();
            slotsToSerialize[i] = s;
            s.field = fields[i];
        } //End block
        // ---------- Original Method ----------
        //slotsToSerialize = new ObjectSlot[fields.length];
        //for (int i = 0; i < fields.length; i++) {
            //ObjectSlot s = new ObjectSlot();
            //slotsToSerialize[i] = s;
            //s.field = fields[i];
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.670 -0400", hash_original_method = "1C69260A170F4832C171F7666BEC6CDB", hash_generated_method = "5AF245349A6A487BB7C76478EC914244")
    public boolean defaulted(String name) throws IllegalArgumentException {
        addTaint(name.getTaint());
        ObjectSlot slot = findSlot(name, null);
        if(slot == null)        
        {
            IllegalArgumentException var266A5B958E32404FEB0F90FEA16B41BC_613220849 = new IllegalArgumentException("no field '" + name + "'");
            var266A5B958E32404FEB0F90FEA16B41BC_613220849.addTaint(taint);
            throw var266A5B958E32404FEB0F90FEA16B41BC_613220849;
        } //End block
        boolean varCF67B36A00C2480A4BC9F654704FBB20_1369729074 = (slot.defaulted);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1342292881 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1342292881;
        // ---------- Original Method ----------
        //ObjectSlot slot = findSlot(name, null);
        //if (slot == null) {
            //throw new IllegalArgumentException("no field '" + name + "'");
        //}
        //return slot.defaulted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.672 -0400", hash_original_method = "713D4075A7BFE1E9122D10F9179E2FD5", hash_generated_method = "2F55600566B109B65C8856341C9A4A49")
    private ObjectSlot findSlot(String fieldName, Class<?> fieldType) {
        addTaint(fieldType.getTaint());
        addTaint(fieldName.getTaint());
        boolean isPrimitive = fieldType != null && fieldType.isPrimitive();
for(int i = 0;i < slotsToSerialize.length;i++)
        {
            ObjectSlot slot = slotsToSerialize[i];
            if(slot.field.getName().equals(fieldName))            
            {
                if(isPrimitive)                
                {
                    if(slot.field.getType() == fieldType)                    
                    {
ObjectSlot varA75FD01756DA9A5E923BE95AEE2FE369_583325808 =                         slot;
                        varA75FD01756DA9A5E923BE95AEE2FE369_583325808.addTaint(taint);
                        return varA75FD01756DA9A5E923BE95AEE2FE369_583325808;
                    } //End block
                } //End block
                else
                {
                    if(fieldType == null)                    
                    {
ObjectSlot varA75FD01756DA9A5E923BE95AEE2FE369_497273079 =                         slot;
                        varA75FD01756DA9A5E923BE95AEE2FE369_497273079.addTaint(taint);
                        return varA75FD01756DA9A5E923BE95AEE2FE369_497273079;
                    } //End block
                    if(slot.field.getType().isAssignableFrom(fieldType))                    
                    {
ObjectSlot varA75FD01756DA9A5E923BE95AEE2FE369_34870730 =                         slot;
                        varA75FD01756DA9A5E923BE95AEE2FE369_34870730.addTaint(taint);
                        return varA75FD01756DA9A5E923BE95AEE2FE369_34870730;
                    } //End block
                } //End block
            } //End block
        } //End block
        if(declaredFields != null)        
        {
for(int i = 0;i < declaredFields.length;i++)
            {
                ObjectStreamField field = declaredFields[i];
                if(field.getName().equals(fieldName))                
                {
                    if(isPrimitive ? fieldType == field.getType() : fieldType == null ||
                            field.getType().isAssignableFrom(fieldType))                    
                    {
                        ObjectSlot slot = new ObjectSlot();
                        slot.field = field;
                        slot.defaulted = true;
ObjectSlot varA75FD01756DA9A5E923BE95AEE2FE369_653022309 =                         slot;
                        varA75FD01756DA9A5E923BE95AEE2FE369_653022309.addTaint(taint);
                        return varA75FD01756DA9A5E923BE95AEE2FE369_653022309;
                    } //End block
                } //End block
            } //End block
        } //End block
ObjectSlot var540C13E9E156B687226421B24F2DF178_756942416 =         null;
        var540C13E9E156B687226421B24F2DF178_756942416.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_756942416;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.673 -0400", hash_original_method = "088986B40FCEDC0703EB00DECCCFDC49", hash_generated_method = "C7B68ECC315EDBA893A484BCCE7C9F30")
    private ObjectSlot findMandatorySlot(String name, Class<?> type) {
        addTaint(type.getTaint());
        addTaint(name.getTaint());
        ObjectSlot slot = findSlot(name, type);
        if(slot == null || (type == null && slot.field.getType().isPrimitive()))        
        {
            IllegalArgumentException varD7878EE2158883478A72E59B7F02CD3F_1200639461 = new IllegalArgumentException("no field '" + name + "' of type " + type);
            varD7878EE2158883478A72E59B7F02CD3F_1200639461.addTaint(taint);
            throw varD7878EE2158883478A72E59B7F02CD3F_1200639461;
        } //End block
ObjectSlot varA75FD01756DA9A5E923BE95AEE2FE369_1950914370 =         slot;
        varA75FD01756DA9A5E923BE95AEE2FE369_1950914370.addTaint(taint);
        return varA75FD01756DA9A5E923BE95AEE2FE369_1950914370;
        // ---------- Original Method ----------
        //ObjectSlot slot = findSlot(name, type);
        //if (slot == null || (type == null && slot.field.getType().isPrimitive())) {
            //throw new IllegalArgumentException("no field '" + name + "' of type " + type);
        //}
        //return slot;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.673 -0400", hash_original_method = "ACF5260920B1F0F677513369F3D8C323", hash_generated_method = "78B349251889181A4D2FB0FCC7725854")
    public byte get(String name, byte defaultValue) throws IllegalArgumentException {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        ObjectSlot slot = findMandatorySlot(name, byte.class);
        byte var1D281A78AD32B82A51CC04AF6274114A_360692859 = (slot.defaulted ? defaultValue : ((Byte) slot.fieldValue).byteValue());
                byte var40EA57D3EE3C07BF1C102B466E1C3091_1522331341 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1522331341;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, byte.class);
        //return slot.defaulted ? defaultValue : ((Byte) slot.fieldValue).byteValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.674 -0400", hash_original_method = "97CAA651EBA3FEB1DEF47882147E3EE9", hash_generated_method = "02AEE23BF390E2ABAA9D649F4A8C1B8D")
    public char get(String name, char defaultValue) throws IllegalArgumentException {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        ObjectSlot slot = findMandatorySlot(name, char.class);
        char varB58266EE075128F3D1257F8A548D9C48_1828627596 = (slot.defaulted ? defaultValue : ((Character) slot.fieldValue).charValue());
                char varA87DEB01C5F539E6BDA34829C8EF2368_647504901 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_647504901;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, char.class);
        //return slot.defaulted ? defaultValue : ((Character) slot.fieldValue).charValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.674 -0400", hash_original_method = "8A61E03E38631E405F30500DFE3A2EED", hash_generated_method = "0F088AC9C298CE5748FC94C7703AAE3A")
    public double get(String name, double defaultValue) throws IllegalArgumentException {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        ObjectSlot slot = findMandatorySlot(name, double.class);
        double varF588637FF811446962953644BED4129E_1113838239 = (slot.defaulted ? defaultValue : ((Double) slot.fieldValue).doubleValue());
                double varE8CD7DA078A86726031AD64F35F5A6C0_83310813 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_83310813;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, double.class);
        //return slot.defaulted ? defaultValue : ((Double) slot.fieldValue).doubleValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.675 -0400", hash_original_method = "2A99383382827F229576C5D7E3624FBA", hash_generated_method = "4C82FDDAF624159BF744BF5CFD82FFEE")
    public float get(String name, float defaultValue) throws IllegalArgumentException {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        ObjectSlot slot = findMandatorySlot(name, float.class);
        float var44D5397B0A068E142893A86C6CDD3289_1608306407 = (slot.defaulted ? defaultValue : ((Float) slot.fieldValue).floatValue());
                float var546ADE640B6EDFBC8A086EF31347E768_990860245 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_990860245;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, float.class);
        //return slot.defaulted ? defaultValue : ((Float) slot.fieldValue).floatValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.675 -0400", hash_original_method = "348173917C5323C10E5D8A71A480A22F", hash_generated_method = "145B66C4EB45865DD1EC187713647779")
    public int get(String name, int defaultValue) throws IllegalArgumentException {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        ObjectSlot slot = findMandatorySlot(name, int.class);
        int varB53885FAFCA9992C3A3559F66DF73055_1057712351 = (slot.defaulted ? defaultValue : ((Integer) slot.fieldValue).intValue());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_587790128 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_587790128;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, int.class);
        //return slot.defaulted ? defaultValue : ((Integer) slot.fieldValue).intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.676 -0400", hash_original_method = "57601B1EFC99CB5F2500857C9C4A7300", hash_generated_method = "9567A0CE0873637CE2FF1E30913AADA4")
    public long get(String name, long defaultValue) throws IllegalArgumentException {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        ObjectSlot slot = findMandatorySlot(name, long.class);
        long varAEB0AA055AE72774FF7575974581D595_554306689 = (slot.defaulted ? defaultValue : ((Long) slot.fieldValue).longValue());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_722392371 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_722392371;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, long.class);
        //return slot.defaulted ? defaultValue : ((Long) slot.fieldValue).longValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.676 -0400", hash_original_method = "47E293617D5F89E0481B6C58D6863D6B", hash_generated_method = "8CF65B0B7FA0171EE7EFDA00DB54F1C1")
    public Object get(String name, Object defaultValue) throws IllegalArgumentException {
        addTaint(defaultValue.getTaint());
        addTaint(name.getTaint());
        ObjectSlot slot = findMandatorySlot(name, null);
Object var8ECED27106AD5F69545F8A5CA74D01DD_1233947472 =         slot.defaulted ? defaultValue : slot.fieldValue;
        var8ECED27106AD5F69545F8A5CA74D01DD_1233947472.addTaint(taint);
        return var8ECED27106AD5F69545F8A5CA74D01DD_1233947472;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, null);
        //return slot.defaulted ? defaultValue : slot.fieldValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.676 -0400", hash_original_method = "EA3C9F151A3984D516E6CE85AC2BDF4D", hash_generated_method = "88080F553279F17239944B97225859A1")
    public short get(String name, short defaultValue) throws IllegalArgumentException {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        ObjectSlot slot = findMandatorySlot(name, short.class);
        short varD4C7E28BA5A724D1379C6EE44DB8BF96_1816528502 = (slot.defaulted ? defaultValue : ((Short) slot.fieldValue).shortValue());
                short var4F09DAA9D95BCB166A302407A0E0BABE_2114045846 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_2114045846;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, short.class);
        //return slot.defaulted ? defaultValue : ((Short) slot.fieldValue).shortValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.677 -0400", hash_original_method = "72E0CD60A94F0F11C444AC99B11C64E2", hash_generated_method = "34AEF86E7303724427B49A46A0D7E4BC")
    public boolean get(String name, boolean defaultValue) throws IllegalArgumentException {
        addTaint(defaultValue);
        addTaint(name.getTaint());
        ObjectSlot slot = findMandatorySlot(name, boolean.class);
        boolean var42197F4542ADF97A086473B57E49CC07_135923173 = (slot.defaulted ? defaultValue : ((Boolean) slot.fieldValue).booleanValue());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_74927613 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_74927613;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, boolean.class);
        //return slot.defaulted ? defaultValue : ((Boolean) slot.fieldValue).booleanValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.677 -0400", hash_original_method = "64C46ECEF3E0E1E6FE4F0FC120F58D81", hash_generated_method = "CE0109AE221D589540B32A4B417AC1C5")
    public void put(String name, byte value) throws IllegalArgumentException {
        addTaint(value);
        addTaint(name.getTaint());
        ObjectSlot slot = findMandatorySlot(name, byte.class);
        slot.fieldValue = Byte.valueOf(value);
        slot.defaulted = false;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, byte.class);
        //slot.fieldValue = Byte.valueOf(value);
        //slot.defaulted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.678 -0400", hash_original_method = "B195152936A8DE9E766C2D3BFA5BBEA4", hash_generated_method = "E818A9BB9C5F19267F44D6B182186167")
    public void put(String name, char value) throws IllegalArgumentException {
        addTaint(value);
        addTaint(name.getTaint());
        ObjectSlot slot = findMandatorySlot(name, char.class);
        slot.fieldValue = Character.valueOf(value);
        slot.defaulted = false;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, char.class);
        //slot.fieldValue = Character.valueOf(value);
        //slot.defaulted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.679 -0400", hash_original_method = "3D642E33ABBFFAD3AE138739766C10D1", hash_generated_method = "19CCE813D5D6A99714E525618F4DA35F")
    public void put(String name, double value) throws IllegalArgumentException {
        addTaint(value);
        addTaint(name.getTaint());
        ObjectSlot slot = findMandatorySlot(name, double.class);
        slot.fieldValue = Double.valueOf(value);
        slot.defaulted = false;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, double.class);
        //slot.fieldValue = Double.valueOf(value);
        //slot.defaulted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.679 -0400", hash_original_method = "5C33ECB8D6052895E0E1DA7379AC4A20", hash_generated_method = "EEFFF9B1D2199D096E805678367220E3")
    public void put(String name, float value) throws IllegalArgumentException {
        addTaint(value);
        addTaint(name.getTaint());
        ObjectSlot slot = findMandatorySlot(name, float.class);
        slot.fieldValue = Float.valueOf(value);
        slot.defaulted = false;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, float.class);
        //slot.fieldValue = Float.valueOf(value);
        //slot.defaulted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.680 -0400", hash_original_method = "C7B64C133814D04EB5CE7945AB5C3FD6", hash_generated_method = "01A5F6CFF06B8BE71BE0DE1F63DCEEDF")
    public void put(String name, int value) throws IllegalArgumentException {
        addTaint(value);
        addTaint(name.getTaint());
        ObjectSlot slot = findMandatorySlot(name, int.class);
        slot.fieldValue = Integer.valueOf(value);
        slot.defaulted = false;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, int.class);
        //slot.fieldValue = Integer.valueOf(value);
        //slot.defaulted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.680 -0400", hash_original_method = "4164B16D12FE76E9A5204CEE3F8D4A11", hash_generated_method = "B6876F79EA66A943DC9166C43744754E")
    public void put(String name, long value) throws IllegalArgumentException {
        addTaint(value);
        addTaint(name.getTaint());
        ObjectSlot slot = findMandatorySlot(name, long.class);
        slot.fieldValue = Long.valueOf(value);
        slot.defaulted = false;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, long.class);
        //slot.fieldValue = Long.valueOf(value);
        //slot.defaulted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.680 -0400", hash_original_method = "7164629BD662AF4C210D96FAFCA6D7A8", hash_generated_method = "7DD111F5DA5A944705FC1146E5177B17")
    public void put(String name, Object value) throws IllegalArgumentException {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        Class<?> valueClass = null;
        if(value != null)        
        {
            valueClass = value.getClass();
        } //End block
        ObjectSlot slot = findMandatorySlot(name, valueClass);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.680 -0400", hash_original_method = "741DDC8469BC0231E1B51BB2B8F8F75A", hash_generated_method = "5D55DFB7639495C2883D181E9C62E5EB")
    public void put(String name, short value) throws IllegalArgumentException {
        addTaint(value);
        addTaint(name.getTaint());
        ObjectSlot slot = findMandatorySlot(name, short.class);
        slot.fieldValue = Short.valueOf(value);
        slot.defaulted = false;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, short.class);
        //slot.fieldValue = Short.valueOf(value);
        //slot.defaulted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.681 -0400", hash_original_method = "98E17CB3A991625B145B89A797910B92", hash_generated_method = "0D87E99CAC0110694E5AF3851E9AB135")
    public void put(String name, boolean value) throws IllegalArgumentException {
        addTaint(value);
        addTaint(name.getTaint());
        ObjectSlot slot = findMandatorySlot(name, boolean.class);
        slot.fieldValue = Boolean.valueOf(value);
        slot.defaulted = false;
        // ---------- Original Method ----------
        //ObjectSlot slot = findMandatorySlot(name, boolean.class);
        //slot.fieldValue = Boolean.valueOf(value);
        //slot.defaulted = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.681 -0400", hash_original_method = "FD5D2C58D86BF6903270C5515850C93F", hash_generated_method = "D6AB44AD12F9D87204DB1F4B40CE13E8")
    public ObjectSlot[] slots() {
ObjectSlot[] varBC44ACCD034244AA8201EA5D1A2C18F9_1852864590 =         slotsToSerialize;
        varBC44ACCD034244AA8201EA5D1A2C18F9_1852864590.addTaint(taint);
        return varBC44ACCD034244AA8201EA5D1A2C18F9_1852864590;
        // ---------- Original Method ----------
        //return slotsToSerialize;
    }

    
    static class ObjectSlot {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.681 -0400", hash_original_field = "06E3D36FA30CEA095545139854AD1FB9", hash_generated_field = "666B1AF45B3BB88D7A1E85239BC45DDE")

        ObjectStreamField field;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.681 -0400", hash_original_field = "319E2726BCC98302437312A8EBFE9DEB", hash_generated_field = "5E1F8EDBBFF3A4D528D4DA8B4EA5155F")

        Object fieldValue;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.681 -0400", hash_original_field = "0187220743CFC423830C110BC0022C97", hash_generated_field = "65016E670BD52C6342444B4F71434A83")

        boolean defaulted = true;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.681 -0400", hash_original_method = "57E475AF330CFB18924297ADFA41ECEA", hash_generated_method = "57E475AF330CFB18924297ADFA41ECEA")
        public ObjectSlot ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.681 -0400", hash_original_method = "59E78F3DAFAB25C124D589BA3544A531", hash_generated_method = "21A1D82AA3EE25DBB436960A1187114F")
        public ObjectStreamField getField() {
ObjectStreamField varFD00DDA829A3FEC584386A3762542DE0_1294118050 =             field;
            varFD00DDA829A3FEC584386A3762542DE0_1294118050.addTaint(taint);
            return varFD00DDA829A3FEC584386A3762542DE0_1294118050;
            // ---------- Original Method ----------
            //return field;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.681 -0400", hash_original_method = "31B3B47C28245F569D31AEBE619B4C79", hash_generated_method = "CDEF517EAE4E4746AD9EF6A622A4AC1D")
        public Object getFieldValue() {
Object var4E4D2A3682724C167ABDF0C5A29E0CEB_1389380374 =             fieldValue;
            var4E4D2A3682724C167ABDF0C5A29E0CEB_1389380374.addTaint(taint);
            return var4E4D2A3682724C167ABDF0C5A29E0CEB_1389380374;
            // ---------- Original Method ----------
            //return fieldValue;
        }

        
    }


    
}

