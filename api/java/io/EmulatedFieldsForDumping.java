package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





class EmulatedFieldsForDumping extends ObjectOutputStream.PutField {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.391 -0500", hash_original_field = "4A739C08808C5C928B9834A591DB34F0", hash_generated_field = "5423796031E51D6FB469318D4F31ADED")

    private  ObjectOutputStream oos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.393 -0500", hash_original_field = "A4096C8B32AAA5FC3ADEB5792BF75E27", hash_generated_field = "B94E58D5D6568A9EC985C6A7207CC5BA")

    private EmulatedFields emulatedFields;

    /**
     * Constructs a new instance of EmulatedFieldsForDumping.
     *
     * @param streamClass
     *            a ObjectStreamClass, which describe the fields to be emulated
     *            (names, types, etc).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.396 -0500", hash_original_method = "D64C2A148CFECC0338F81243CC161580", hash_generated_method = "D64C2A148CFECC0338F81243CC161580")
    
EmulatedFieldsForDumping(ObjectOutputStream oos, ObjectStreamClass streamClass) {
        this.oos = oos;
        this.emulatedFields = new EmulatedFields(streamClass.fields(), (ObjectStreamField[]) null);
    }

    /**
     * Return the actual EmulatedFields instance used by the receiver. We have
     * the actual work in a separate class so that the code can be shared. The
     * receiver has to be of a subclass of PutField.
     *
     * @return array of ObjectSlot the receiver represents.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.398 -0500", hash_original_method = "F09D38B717E770EDAB76B08B81548137", hash_generated_method = "F09D38B717E770EDAB76B08B81548137")
    
EmulatedFields emulatedFields() {
        return emulatedFields;
    }

    /**
     * Find and set the byte value of a given field named <code>name</code> in
     * the receiver.
     *
     * @param name
     *            A String, the name of the field to set
     * @param value
     *            New value for the field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.400 -0500", hash_original_method = "BEEEBC5D4806AB4D59848CAB89CBF72F", hash_generated_method = "198A31971150A22083A9CA76595D1221")
    
@Override
    public void put(String name, byte value) {
        emulatedFields.put(name, value);
    }

    /**
     * Find and set the char value of a given field named <code>name</code> in
     * the receiver.
     *
     * @param name
     *            A String, the name of the field to set
     * @param value
     *            New value for the field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.403 -0500", hash_original_method = "19C83E4EF6515D56E4873B39EA152436", hash_generated_method = "D5D9B81CB4D09B5832746306331C8117")
    
@Override
    public void put(String name, char value) {
        emulatedFields.put(name, value);
    }

    /**
     * Find and set the double value of a given field named <code>name</code>
     * in the receiver.
     *
     * @param name
     *            A String, the name of the field to set
     * @param value
     *            New value for the field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.406 -0500", hash_original_method = "AC456BDE0EE43978AFAB7EF96C2FFCE8", hash_generated_method = "71C955E2605880817A43E46E9C624B08")
    
@Override
    public void put(String name, double value) {
        emulatedFields.put(name, value);
    }

    /**
     * Find and set the float value of a given field named <code>name</code>
     * in the receiver.
     *
     * @param name
     *            A String, the name of the field to set
     * @param value
     *            New value for the field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.408 -0500", hash_original_method = "821340AFE72172F29B54D2C504849DA8", hash_generated_method = "10E01ABCDA8BF240954901B8EE6E120F")
    
@Override
    public void put(String name, float value) {
        emulatedFields.put(name, value);
    }

    /**
     * Find and set the int value of a given field named <code>name</code> in
     * the receiver.
     *
     * @param name
     *            A String, the name of the field to set
     * @param value
     *            New value for the field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.411 -0500", hash_original_method = "63AD54FC39DDE8BE3BBE5131906AC91A", hash_generated_method = "8FEBD7F0FD6B5B81CFD174CB6858AB6D")
    
@Override
    public void put(String name, int value) {
        emulatedFields.put(name, value);
    }

    /**
     * Find and set the long value of a given field named <code>name</code> in
     * the receiver.
     *
     * @param name
     *            A String, the name of the field to set
     * @param value
     *            New value for the field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.413 -0500", hash_original_method = "7C91E467656A70134D915DC378A85E85", hash_generated_method = "97A13C6E13CC458A400E21741040D166")
    
@Override
    public void put(String name, long value) {
        emulatedFields.put(name, value);
    }

    /**
     * Find and set the Object value of a given field named <code>name</code>
     * in the receiver.
     *
     * @param name
     *            A String, the name of the field to set
     * @param value
     *            New value for the field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.416 -0500", hash_original_method = "B27C87FCD55A2BEDEC6F0B351B72701B", hash_generated_method = "694EDD3C37321D8FD47F2FE108FF2D7A")
    
@Override
    public void put(String name, Object value) {
        emulatedFields.put(name, value);
    }

    /**
     * Find and set the short value of a given field named <code>name</code>
     * in the receiver.
     *
     * @param name
     *            A String, the name of the field to set
     * @param value
     *            New value for the field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.418 -0500", hash_original_method = "8872C66D19E491C8A24E1F3793E76CF5", hash_generated_method = "CD09FE4DC07B71735E833151673F9B1F")
    
@Override
    public void put(String name, short value) {
        emulatedFields.put(name, value);
    }

    /**
     * Find and set the boolean value of a given field named <code>name</code>
     * in the receiver.
     *
     * @param name
     *            A String, the name of the field to set
     * @param value
     *            New value for the field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.420 -0500", hash_original_method = "7776E04A4027209B01392EB6C3502FA8", hash_generated_method = "E6D266A43FA0FAD230541ED94B8906A6")
    
@Override
    public void put(String name, boolean value) {
        emulatedFields.put(name, value);
    }

    /**
     * Write the field values to the specified ObjectOutput.
     *
     * @param output
     *            the ObjectOutput
     *
     * @throws IOException
     *             If an IO exception happened when writing the field values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:47.425 -0500", hash_original_method = "AB29CC034AE7D29F14B7C45BD47F3CB4", hash_generated_method = "B59D1AD960FA4F98A51110DB906B3FDC")
    
@Override
    @Deprecated
    public void write(ObjectOutput output) throws IOException {
        if (!output.equals(oos)) {
            throw new IllegalArgumentException("Attempting to write to a different stream than the one that created this PutField");
        }
        for (EmulatedFields.ObjectSlot slot : emulatedFields.slots()) {
            Object fieldValue = slot.getFieldValue();
            Class<?> type = slot.getField().getType();
            if (type == int.class) {
                output.writeInt(fieldValue != null ? ((Integer) fieldValue).intValue() : 0);
            } else if (type == byte.class) {
                output.writeByte(fieldValue != null ? ((Byte) fieldValue).byteValue() : 0);
            } else if (type == char.class) {
                output.writeChar(fieldValue != null ? ((Character) fieldValue).charValue() : 0);
            } else if (type == short.class) {
                output.writeShort(fieldValue != null ? ((Short) fieldValue).shortValue() : 0);
            } else if (type == boolean.class) {
                output.writeBoolean(fieldValue != null ? ((Boolean) fieldValue).booleanValue() : false);
            } else if (type == long.class) {
                output.writeLong(fieldValue != null ? ((Long) fieldValue).longValue() : 0);
            } else if (type == float.class) {
                output.writeFloat(fieldValue != null ? ((Float) fieldValue).floatValue() : 0);
            } else if (type == double.class) {
                output.writeDouble(fieldValue != null ? ((Double) fieldValue).doubleValue() : 0);
            } else {
                // Either array or Object
                output.writeObject(fieldValue);
            }
        }
    }

    
}

