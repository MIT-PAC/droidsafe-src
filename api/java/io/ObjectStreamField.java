package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.ref.WeakReference;






public class ObjectStreamField implements Comparable<Object> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:34.022 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:34.023 -0500", hash_original_field = "5C9CBF7A7CBB34C043F2F273AD90299D", hash_generated_field = "E8909FCC8837B5FE7A3CBA40C0098CCB")

    private Object type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:34.024 -0500", hash_original_field = "B7E810BF01B52122CB927525A0CA4721", hash_generated_field = "B7E810BF01B52122CB927525A0CA4721")

    int offset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:34.024 -0500", hash_original_field = "0FC3A976B5B86B3C6BD383EC1B291C83", hash_generated_field = "A6469B3C05A6E61AD188C77E4C87AFA0")

    private String typeString;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:34.025 -0500", hash_original_field = "2148EF25429F0A769B21F87169D2187F", hash_generated_field = "1925D0B4ADBD655AA714AC16DE1F0973")


    private boolean unshared;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:34.026 -0500", hash_original_field = "919B3BD1453766B88BBD276CC2C58C43", hash_generated_field = "B10B376FF3C60E9314732C46A8CA6340")


    private boolean isDeserialized;

    /**
     * Constructs an ObjectStreamField with the specified name and type.
     *
     * @param name
     *            the name of the field.
     * @param cl
     *            the type of the field.
     * @throws NullPointerException
     *             if {@code name} or {@code cl} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:34.027 -0500", hash_original_method = "0D657EDEC08CB18117CF62EC578D6020", hash_generated_method = "94D5650B1B5A26667C8140497A0F1482")
    public ObjectStreamField(String name, Class<?> cl) {
        if (name == null || cl == null) {
            throw new NullPointerException();
        }
        this.name = name;
        this.type = new WeakReference<Class<?>>(cl);
    }

    /**
     * Constructs an ObjectStreamField with the specified name, type and the
     * indication if it is unshared.
     *
     * @param name
     *            the name of the field.
     * @param cl
     *            the type of the field.
     * @param unshared
     *            {@code true} if the field is written and read unshared;
     *            {@code false} otherwise.
     * @throws NullPointerException
     *             if {@code name} or {@code cl} is {@code null}.
     * @see ObjectOutputStream#writeUnshared(Object)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:34.028 -0500", hash_original_method = "B329D182B18083287B5598787B9BCF42", hash_generated_method = "A7F986AAFF1A023FCBE2AE3AEBD1EFF0")
    public ObjectStreamField(String name, Class<?> cl, boolean unshared) {
        if (name == null || cl == null) {
            throw new NullPointerException();
        }
        this.name = name;
        this.type = (cl.getClassLoader() == null) ? cl : new WeakReference<Class<?>>(cl);
        this.unshared = unshared;
    }

    /**
     * Constructs an ObjectStreamField with the given name and the given type.
     * The type may be null.
     *
     * @param signature
     *            A String representing the type of the field
     * @param name
     *            a String, the name of the field, or null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:34.029 -0500", hash_original_method = "7045B1DBF21073AA43E994CE221E4094", hash_generated_method = "7045B1DBF21073AA43E994CE221E4094")
    ObjectStreamField(String signature, String name) {
        if (name == null) {
            throw new NullPointerException();
        }
        this.name = name;
        this.typeString = signature.replace('.', '/').intern();
        defaultResolve();
        this.isDeserialized = true;
    }

    /**
     * Compares this field descriptor to the specified one. Checks first if one
     * of the compared fields has a primitive type and the other one not. If so,
     * the field with the primitive type is considered to be "smaller". If both
     * fields are equal, their names are compared.
     *
     * @param o
     *            the object to compare with.
     * @return -1 if this field is "smaller" than field {@code o}, 0 if both
     *         fields are equal; 1 if this field is "greater" than field {@code
     *         o}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:34.030 -0500", hash_original_method = "11ADA6ED2A991966CB49663045730556", hash_generated_method = "8EE1CF0F7DD5C3FC6C7691B1A914AA34")
    public int compareTo(Object o) {
        ObjectStreamField f = (ObjectStreamField) o;
        boolean thisPrimitive = this.isPrimitive();
        boolean fPrimitive = f.isPrimitive();

        // If one is primitive and the other isn't, we have enough info to
        // compare
        if (thisPrimitive != fPrimitive) {
            return thisPrimitive ? -1 : 1;
        }

        // Either both primitives or both not primitives. Compare based on name.
        return this.getName().compareTo(f.getName());
    }

    /**
     * Gets the name of this field.
     *
     * @return the field's name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:34.031 -0500", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "50860709F8CC9FE19B604881E59FBA54")
    public String getName() {
        return name;
    }

    /**
     * Gets the offset of this field in the object.
     *
     * @return this field's offset.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:34.032 -0500", hash_original_method = "ACEB13DAA855070296BA592FB1ADADA1", hash_generated_method = "270B62274502DD6D664C5F8775886061")
    public int getOffset() {
        return offset;
    }

    /**
     * Return the type of the field the receiver represents, this is an internal
     * method
     *
     * @return A Class object representing the type of the field
     */
    // Changed from private to default visibility for usage in ObjectStreamClass
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:34.032 -0500", hash_original_method = "FF08482EB56AA685DDAE41A39E334998", hash_generated_method = "FF08482EB56AA685DDAE41A39E334998")
    Class<?> getTypeInternal() {
        if (type instanceof WeakReference) {
            return (Class<?>) ((WeakReference<?>) type).get();
        }
        return (Class<?>) type;
    }

    /**
     * Gets the type of this field.
     *
     * @return a {@code Class} object representing the type of the field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:34.033 -0500", hash_original_method = "9634509EF2A12286AE62950CEFC0E304", hash_generated_method = "82D243212D47306A7AC7BAAF5532CDBE")
    public Class<?> getType() {
        Class<?> cl = getTypeInternal();
        if (isDeserialized && !cl.isPrimitive()) {
            return Object.class;
        }
        return cl;
    }

    /**
     * Gets a character code for the type of this field. The following codes are
     * used:
     *
     * <pre>
     * B     byte
     * C     char
     * D     double
     * F     float
     * I     int
     * J     long
     * L     class or interface
     * S     short
     * Z     boolean
     * [     array
     * </pre>
     *
     * @return the field's type code.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:34.034 -0500", hash_original_method = "6C03FA17A8A9EDC07915A4F462B31BC8", hash_generated_method = "79EF9B37AC1424BDB4A7FB22D5F396BA")
    public char getTypeCode() {
        return typeCodeOf(getTypeInternal());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:34.035 -0500", hash_original_method = "1261A37E9B201158D41DADA58D3D498E", hash_generated_method = "9AE235E0A3E2AA8A3A48ED009224B75D")
    private char typeCodeOf(Class<?> type) {
        if (type == int.class) {
            return 'I';
        } else if (type == byte.class) {
            return 'B';
        } else if (type == char.class) {
            return 'C';
        } else if (type == short.class) {
            return 'S';
        } else if (type == boolean.class) {
            return 'Z';
        } else if (type == long.class) {
            return 'J';
        } else if (type == float.class) {
            return 'F';
        } else if (type == double.class) {
            return 'D';
        } else if (type.isArray()) {
            return '[';
        } else {
            return 'L';
        }
    }

    /**
     * Gets the type signature used by the VM to represent the type of this
     * field.
     *
     * @return the signature of this field's class or {@code null} if this
     *         field's type is primitive.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:34.036 -0500", hash_original_method = "AF834EA72E67DF4239AA5209B5DE5F81", hash_generated_method = "1C6D01020ED07C1AF4E4BDBCF0B8E26B")
    public String getTypeString() {
        if (isPrimitive()) {
            return null;
        }
        if (typeString == null) {
            Class<?> t = getTypeInternal();
            String typeName = t.getName().replace('.', '/');
            String str = (t.isArray()) ? typeName : ("L" + typeName + ';');
            typeString = str.intern();
        }
        return typeString;
    }

    /**
     * Indicates whether this field's type is a primitive type.
     *
     * @return {@code true} if this field's type is primitive; {@code false} if
     *         the type of this field is a regular class.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:34.037 -0500", hash_original_method = "109BC8E5B51BF330504215C17ADD6478", hash_generated_method = "5F7CEF0AAF5A05130189ED26FA7DD2B8")
    public boolean isPrimitive() {
        Class<?> t = getTypeInternal();
        return t != null && t.isPrimitive();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:34.038 -0500", hash_original_method = "6EE925571D11CA9854483CD43D60AA5F", hash_generated_method = "6EE925571D11CA9854483CD43D60AA5F")
    boolean writeField(DataOutputStream out) throws IOException {
        Class<?> t = getTypeInternal();
        out.writeByte(typeCodeOf(t));
        out.writeUTF(name);
        return (t != null && t.isPrimitive());
    }

    /**
     * Sets this field's offset in the object.
     *
     * @param newValue
     *            the field's new offset.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:34.038 -0500", hash_original_method = "7A66A074CFBB1A834E24DFB5B3A643D5", hash_generated_method = "4CB62E90C2E26EF894F00B8F47C664A8")
    protected void setOffset(int newValue) {
        this.offset = newValue;
    }

    /**
     * Returns a string containing a concise, human-readable description of this
     * field descriptor.
     *
     * @return a printable representation of this descriptor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:34.039 -0500", hash_original_method = "ABFAE4540EC552EECBD4679559074925", hash_generated_method = "EC935FFC09D2ED871BD2D5B3E5767FE7")
    @Override
public String toString() {
        return this.getClass().getName() + '(' + getName() + ':' + getTypeInternal() + ')';
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:34.040 -0500", hash_original_method = "48E3281BF72BF66E5E96F9E4056E97FC", hash_generated_method = "C3A4214F218453FC713B9A09D068FA34")
    void resolve(ClassLoader loader) {
        if (typeString == null && isPrimitive()) {
            // primitive type declared in a serializable class
            typeString = String.valueOf(getTypeCode());
        }

        if (typeString.length() == 1) {
            if (defaultResolve()) {
                return;
            }
        }

        String className = typeString.replace('/', '.');
        if (className.charAt(0) == 'L') {
            // remove L and ;
            className = className.substring(1, className.length() - 1);
        }
        try {
            Class<?> cl = Class.forName(className, false, loader);
            type = (cl.getClassLoader() == null) ? cl : new WeakReference<Class<?>>(cl);
        } catch (ClassNotFoundException e) {
            // Ignored
        }
    }

    /**
     * Indicates whether this field is unshared.
     *
     * @return {@code true} if this field is unshared, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:34.041 -0500", hash_original_method = "F21E97E0131CF96F90294027D325F2F1", hash_generated_method = "6C0974834F4ED5E3334D2C54E96A4062")
    public boolean isUnshared() {
        return unshared;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:34.042 -0500", hash_original_method = "68701E3ED15FAA74732CE575E0F04E5E", hash_generated_method = "68701E3ED15FAA74732CE575E0F04E5E")
    void setUnshared(boolean unshared) {
        this.unshared = unshared;
    }

    /**
     * Resolves typeString into type. Returns true if the type is primitive
     * and false otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:34.043 -0500", hash_original_method = "E1E63B3BD3E5801BD481EB78C5FBD93C", hash_generated_method = "4CC7DBA3774EC020B36C17E82CD9EC8C")
    private boolean defaultResolve() {
        switch (typeString.charAt(0)) {
        case 'I':
            type = int.class;
            return true;
        case 'B':
            type = byte.class;
            return true;
        case 'C':
            type = char.class;
            return true;
        case 'S':
            type = short.class;
            return true;
        case 'Z':
            type = boolean.class;
            return true;
        case 'J':
            type = long.class;
            return true;
        case 'F':
            type = float.class;
            return true;
        case 'D':
            type = double.class;
            return true;
        default:
            type = Object.class;
            return false;
        }
    }

    
}

