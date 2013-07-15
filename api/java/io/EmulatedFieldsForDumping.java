package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

class EmulatedFieldsForDumping extends ObjectOutputStream.PutField {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.907 -0400", hash_original_field = "2F09CF6A0C7823B6AADE31761B07AB12", hash_generated_field = "5423796031E51D6FB469318D4F31ADED")

    private ObjectOutputStream oos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.908 -0400", hash_original_field = "F6140DD74E8B37A12ABECC3B9897BAA5", hash_generated_field = "B94E58D5D6568A9EC985C6A7207CC5BA")

    private EmulatedFields emulatedFields;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.911 -0400", hash_original_method = "D64C2A148CFECC0338F81243CC161580", hash_generated_method = "A6106B8CAABE6244A96E60C957ED60C5")
      EmulatedFieldsForDumping(ObjectOutputStream oos, ObjectStreamClass streamClass) {
        this.oos = oos;
        this.emulatedFields = new EmulatedFields(streamClass.fields(), (ObjectStreamField[]) null);
        // ---------- Original Method ----------
        //this.oos = oos;
        //this.emulatedFields = new EmulatedFields(streamClass.fields(), (ObjectStreamField[]) null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.914 -0400", hash_original_method = "F09D38B717E770EDAB76B08B81548137", hash_generated_method = "AD13F6AD6C77A489575DA0F90CDBE4E0")
     EmulatedFields emulatedFields() {
EmulatedFields var18247BC109AF7C66D9FA0EEEECBE3638_581056841 =         emulatedFields;
        var18247BC109AF7C66D9FA0EEEECBE3638_581056841.addTaint(taint);
        return var18247BC109AF7C66D9FA0EEEECBE3638_581056841;
        // ---------- Original Method ----------
        //return emulatedFields;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.916 -0400", hash_original_method = "BEEEBC5D4806AB4D59848CAB89CBF72F", hash_generated_method = "F1DE64433D8D9A5A7E81CCEB3E4B37A8")
    @Override
    public void put(String name, byte value) {
        addTaint(value);
        addTaint(name.getTaint());
        emulatedFields.put(name, value);
        // ---------- Original Method ----------
        //emulatedFields.put(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.919 -0400", hash_original_method = "19C83E4EF6515D56E4873B39EA152436", hash_generated_method = "CF8E610656E622D166A8CC82F7B30165")
    @Override
    public void put(String name, char value) {
        addTaint(value);
        addTaint(name.getTaint());
        emulatedFields.put(name, value);
        // ---------- Original Method ----------
        //emulatedFields.put(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.923 -0400", hash_original_method = "AC456BDE0EE43978AFAB7EF96C2FFCE8", hash_generated_method = "951ADE479111318DD0E02678F6E4C95B")
    @Override
    public void put(String name, double value) {
        addTaint(value);
        addTaint(name.getTaint());
        emulatedFields.put(name, value);
        // ---------- Original Method ----------
        //emulatedFields.put(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.927 -0400", hash_original_method = "821340AFE72172F29B54D2C504849DA8", hash_generated_method = "19680EA42636E3D46362AFC801727BFA")
    @Override
    public void put(String name, float value) {
        addTaint(value);
        addTaint(name.getTaint());
        emulatedFields.put(name, value);
        // ---------- Original Method ----------
        //emulatedFields.put(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.928 -0400", hash_original_method = "63AD54FC39DDE8BE3BBE5131906AC91A", hash_generated_method = "12C86744459D68CD5AB591052AF540A2")
    @Override
    public void put(String name, int value) {
        addTaint(value);
        addTaint(name.getTaint());
        emulatedFields.put(name, value);
        // ---------- Original Method ----------
        //emulatedFields.put(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.930 -0400", hash_original_method = "7C91E467656A70134D915DC378A85E85", hash_generated_method = "EAD52746A21E7CA1B444C098DC2BAA16")
    @Override
    public void put(String name, long value) {
        addTaint(value);
        addTaint(name.getTaint());
        emulatedFields.put(name, value);
        // ---------- Original Method ----------
        //emulatedFields.put(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.932 -0400", hash_original_method = "B27C87FCD55A2BEDEC6F0B351B72701B", hash_generated_method = "6E35C9EEF6F856A14AA699F561321723")
    @Override
    public void put(String name, Object value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        emulatedFields.put(name, value);
        // ---------- Original Method ----------
        //emulatedFields.put(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.934 -0400", hash_original_method = "8872C66D19E491C8A24E1F3793E76CF5", hash_generated_method = "D2F16595EF3EDE5779A9F1794CA525C6")
    @Override
    public void put(String name, short value) {
        addTaint(value);
        addTaint(name.getTaint());
        emulatedFields.put(name, value);
        // ---------- Original Method ----------
        //emulatedFields.put(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.935 -0400", hash_original_method = "7776E04A4027209B01392EB6C3502FA8", hash_generated_method = "7734BF38B428D9DD24ECC34394932F72")
    @Override
    public void put(String name, boolean value) {
        addTaint(value);
        addTaint(name.getTaint());
        emulatedFields.put(name, value);
        // ---------- Original Method ----------
        //emulatedFields.put(name, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.945 -0400", hash_original_method = "AB29CC034AE7D29F14B7C45BD47F3CB4", hash_generated_method = "60C8E2736618C4DC4FE3538D6D876BCB")
    @Override
    @Deprecated
    public void write(ObjectOutput output) throws IOException {
        addTaint(output.getTaint());
    if(!output.equals(oos))        
        {
            IllegalArgumentException var64365E5CD43AE4284E59B03CF8788F85_1546336777 = new IllegalArgumentException("Attempting to write to a different stream than the one that created this PutField");
            var64365E5CD43AE4284E59B03CF8788F85_1546336777.addTaint(taint);
            throw var64365E5CD43AE4284E59B03CF8788F85_1546336777;
        } //End block
for(EmulatedFields.ObjectSlot slot : emulatedFields.slots())
        {
            Object fieldValue = slot.getFieldValue();
            Class<?> type = slot.getField().getType();
    if(type == int.class)            
            {
                output.writeInt(fieldValue != null ? ((Integer) fieldValue).intValue() : 0);
            } //End block
            else
    if(type == byte.class)            
            {
                output.writeByte(fieldValue != null ? ((Byte) fieldValue).byteValue() : 0);
            } //End block
            else
    if(type == char.class)            
            {
                output.writeChar(fieldValue != null ? ((Character) fieldValue).charValue() : 0);
            } //End block
            else
    if(type == short.class)            
            {
                output.writeShort(fieldValue != null ? ((Short) fieldValue).shortValue() : 0);
            } //End block
            else
    if(type == boolean.class)            
            {
                output.writeBoolean(fieldValue != null ? ((Boolean) fieldValue).booleanValue() : false);
            } //End block
            else
    if(type == long.class)            
            {
                output.writeLong(fieldValue != null ? ((Long) fieldValue).longValue() : 0);
            } //End block
            else
    if(type == float.class)            
            {
                output.writeFloat(fieldValue != null ? ((Float) fieldValue).floatValue() : 0);
            } //End block
            else
    if(type == double.class)            
            {
                output.writeDouble(fieldValue != null ? ((Double) fieldValue).doubleValue() : 0);
            } //End block
            else
            {
                output.writeObject(fieldValue);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

