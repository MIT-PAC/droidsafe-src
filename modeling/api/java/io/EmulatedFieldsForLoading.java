package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

class EmulatedFieldsForLoading extends ObjectInputStream.GetField {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.230 -0500", hash_original_field = "9784901087603B86AE4DFFDF75E981BD", hash_generated_field = "BB7D93F7E285B6B6ABC207AB64AE3D33")

    private ObjectStreamClass streamClass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.232 -0500", hash_original_field = "A4096C8B32AAA5FC3ADEB5792BF75E27", hash_generated_field = "B94E58D5D6568A9EC985C6A7207CC5BA")

    private EmulatedFields emulatedFields;

    /**
     * Constructs a new instance of EmulatedFieldsForDumping.
     *
     * @param streamClass
     *            an ObjectStreamClass, defining the class for which to emulate
     *            fields.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.235 -0500", hash_original_method = "3A92EA3385CE026A7E99F46A314647AE", hash_generated_method = "3A92EA3385CE026A7E99F46A314647AE")
    
EmulatedFieldsForLoading(ObjectStreamClass streamClass) {
        this.streamClass = streamClass;
        emulatedFields = new EmulatedFields(streamClass.getLoadFields(), streamClass.fields());
    }

    /**
     * Return a boolean indicating if the field named <code>name</code> has
     * been assigned a value explicitly (false) or if it still holds a default
     * value for the type (true) because it hasn't been assigned to yet.
     *
     * @param name
     *            A String, the name of the field to test
     * @return <code>true</code> if the field holds it default value,
     *         <code>false</code> otherwise.
     *
     * @throws IOException
     *             If an IO error occurs
     * @throws IllegalArgumentException
     *             If the corresponding field can not be found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.238 -0500", hash_original_method = "9CACF5DB880CF5C328FFD8A9BF6477FA", hash_generated_method = "702FB44FFC3FC48B1D46BFDED487000B")
    
@Override
    public boolean defaulted(String name) throws IOException,
            IllegalArgumentException {
        return emulatedFields.defaulted(name);
    }

    /**
     * Return the actual EmulatedFields instance used by the receiver. We have
     * the actual work in a separate class so that the code can be shared. The
     * receiver has to be of a subclass of GetField.
     *
     * @return array of ObjectSlot the receiver represents.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.240 -0500", hash_original_method = "F09D38B717E770EDAB76B08B81548137", hash_generated_method = "F09D38B717E770EDAB76B08B81548137")
    
EmulatedFields emulatedFields() {
        return emulatedFields;
    }

    /**
     * Find and return the byte value of a given field named <code>name</code>
     * in the receiver. If the field has not been assigned any value yet, the
     * default value <code>defaultValue</code> is returned instead.
     *
     * @param name
     *            A String, the name of the field to find
     * @param defaultValue
     *            Return value in case the field has not been assigned to yet.
     * @return the value of the given field if it has been assigned, or the
     *         default value otherwise
     *
     * @throws IOException
     *             If an IO error occurs
     * @throws IllegalArgumentException
     *             If the corresponding field can not be found.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.242 -0500", hash_original_method = "E2EF3BE82D42EA9EDACA51530EC46031", hash_generated_method = "C73E057AE131F882272A1928317FC6D9")
    
@Override
    public byte get(String name, byte defaultValue) throws IOException,
            IllegalArgumentException {
        return emulatedFields.get(name, defaultValue);
    }

    /**
     * Find and return the char value of a given field named <code>name</code>
     * in the receiver. If the field has not been assigned any value yet, the
     * default value <code>defaultValue</code> is returned instead.
     *
     * @param name
     *            A String, the name of the field to find
     * @param defaultValue
     *            Return value in case the field has not been assigned to yet.
     * @return the value of the given field if it has been assigned, or the
     *         default value otherwise
     *
     * @throws IOException
     *             If an IO error occurs
     * @throws IllegalArgumentException
     *             If the corresponding field can not be found.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.244 -0500", hash_original_method = "7F476519C93586AA18DAE834C31099C5", hash_generated_method = "28ACB059C2730002A77E5E9F3227F742")
    
@Override
    public char get(String name, char defaultValue) throws IOException,
            IllegalArgumentException {
        return emulatedFields.get(name, defaultValue);
    }

    /**
     * Find and return the double value of a given field named <code>name</code>
     * in the receiver. If the field has not been assigned any value yet, the
     * default value <code>defaultValue</code> is returned instead.
     *
     * @param name
     *            A String, the name of the field to find
     * @param defaultValue
     *            Return value in case the field has not been assigned to yet.
     * @return the value of the given field if it has been assigned, or the
     *         default value otherwise
     *
     * @throws IOException
     *             If an IO error occurs
     * @throws IllegalArgumentException
     *             If the corresponding field can not be found.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.247 -0500", hash_original_method = "6EEAC0F2FE3228611FBEB2F317C71229", hash_generated_method = "2AD5BC20B97CA52CE762D322BE68A450")
    
@Override
    public double get(String name, double defaultValue) throws IOException,
            IllegalArgumentException {
        return emulatedFields.get(name, defaultValue);
    }

    /**
     * Find and return the float value of a given field named <code>name</code>
     * in the receiver. If the field has not been assigned any value yet, the
     * default value <code>defaultValue</code> is returned instead.
     *
     * @param name
     *            A String, the name of the field to find
     * @param defaultValue
     *            Return value in case the field has not been assigned to yet.
     * @return the value of the given field if it has been assigned, or the
     *         default value otherwise
     *
     * @throws IOException
     *             If an IO error occurs
     * @throws IllegalArgumentException
     *             If the corresponding field can not be found.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.250 -0500", hash_original_method = "656F0985EB6DC9E8197CCDD755BCC8B1", hash_generated_method = "8263214F8C2C38743E3501734D153E24")
    
@Override
    public float get(String name, float defaultValue) throws IOException,
            IllegalArgumentException {
        return emulatedFields.get(name, defaultValue);
    }

    /**
     * Find and return the int value of a given field named <code>name</code>
     * in the receiver. If the field has not been assigned any value yet, the
     * default value <code>defaultValue</code> is returned instead.
     *
     * @param name
     *            A String, the name of the field to find
     * @param defaultValue
     *            Return value in case the field has not been assigned to yet.
     * @return the value of the given field if it has been assigned, or the
     *         default value otherwise
     *
     * @throws IOException
     *             If an IO error occurs
     * @throws IllegalArgumentException
     *             If the corresponding field can not be found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.252 -0500", hash_original_method = "6047986AF632F142A25FB2722F77D86C", hash_generated_method = "51BCD9D2A822F248EA738310020CF787")
    
@Override
    public int get(String name, int defaultValue) throws IOException,
            IllegalArgumentException {
        return emulatedFields.get(name, defaultValue);
    }

    /**
     * Find and return the long value of a given field named <code>name</code>
     * in the receiver. If the field has not been assigned any value yet, the
     * default value <code>defaultValue</code> is returned instead.
     *
     * @param name
     *            A String, the name of the field to find
     * @param defaultValue
     *            Return value in case the field has not been assigned to yet.
     * @return the value of the given field if it has been assigned, or the
     *         default value otherwise
     *
     * @throws IOException
     *             If an IO error occurs
     * @throws IllegalArgumentException
     *             If the corresponding field can not be found.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.255 -0500", hash_original_method = "6EAC14C93DA75CAEC3046B717CAB55B5", hash_generated_method = "4B9AEC8A8577660008782D509546199F")
    
@Override
    public long get(String name, long defaultValue) throws IOException,
            IllegalArgumentException {
        return emulatedFields.get(name, defaultValue);
    }

    /**
     * Find and return the Object value of a given field named <code>name</code>
     * in the receiver. If the field has not been assigned any value yet, the
     * default value <code>defaultValue</code> is returned instead.
     *
     * @param name
     *            A String, the name of the field to find
     * @param defaultValue
     *            Return value in case the field has not been assigned to yet.
     * @return the value of the given field if it has been assigned, or the
     *         default value otherwise
     *
     * @throws IOException
     *             If an IO error occurs
     * @throws IllegalArgumentException
     *             If the corresponding field can not be found.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.257 -0500", hash_original_method = "C001C2593281B8C12D4D30B1599FB136", hash_generated_method = "F18B2509E5879F1EAD77C54A8315DBA0")
    
@Override
    public Object get(String name, Object defaultValue) throws IOException,
            IllegalArgumentException {
        return emulatedFields.get(name, defaultValue);
    }

    /**
     * Find and return the short value of a given field named <code>name</code>
     * in the receiver. If the field has not been assigned any value yet, the
     * default value <code>defaultValue</code> is returned instead.
     *
     * @param name
     *            A String, the name of the field to find
     * @param defaultValue
     *            Return value in case the field has not been assigned to yet.
     * @return the value of the given field if it has been assigned, or the
     *         default value otherwise
     *
     * @throws IOException
     *             If an IO error occurs
     * @throws IllegalArgumentException
     *             If the corresponding field can not be found.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.260 -0500", hash_original_method = "10DCCBE6C4EE0FC6DB857351027C9025", hash_generated_method = "80B96BFD42A288FE90502D275458A613")
    
@Override
    public short get(String name, short defaultValue) throws IOException,
            IllegalArgumentException {
        return emulatedFields.get(name, defaultValue);
    }

    /**
     * Find and return the boolean value of a given field named
     * <code>name</code> in the receiver. If the field has not been assigned
     * any value yet, the default value <code>defaultValue</code> is returned
     * instead.
     *
     * @param name
     *            A String, the name of the field to find
     * @param defaultValue
     *            Return value in case the field has not been assigned to yet.
     * @return the value of the given field if it has been assigned, or the
     *         default value otherwise
     *
     * @throws IOException
     *             If an IO error occurs
     * @throws IllegalArgumentException
     *             If the corresponding field can not be found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.263 -0500", hash_original_method = "076C341B7F018B893749E08DE221153C", hash_generated_method = "77A5D45011BB25BFAA279313D181DFD9")
    
@Override
    public boolean get(String name, boolean defaultValue) throws IOException,
            IllegalArgumentException {
        return emulatedFields.get(name, defaultValue);
    }

    /**
     * Return the class descriptor for which the emulated fields are defined.
     *
     * @return ObjectStreamClass The class descriptor for which the emulated
     *         fields are defined.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.266 -0500", hash_original_method = "C05B1B5B49C9CD804F2B010781383CF8", hash_generated_method = "9D2C070FECF2DCAD0C6647FBD9F938E2")
    
@Override
    public ObjectStreamClass getObjectStreamClass() {
        return streamClass;
    }
    
}

