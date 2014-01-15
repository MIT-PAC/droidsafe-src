package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.EmulatedFields.ObjectSlot;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import libcore.util.EmptyArray;
import dalvik.system.VMStack;

public class ObjectInputStream extends InputStream implements ObjectInput, ObjectStreamConstants {

    /*
     * Format the class signature for ObjectStreamField, for example,
     * "[L[Ljava.lang.String;;" is converted to "[Ljava.lang.String;"
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.393 -0500", hash_original_method = "74747FD805E3D37BE3EFCD383C26D2DE", hash_generated_method = "B7968BBB2631E48A86888FD83216759B")
    
private static String formatClassSig(String classSig) {
        int start = 0;
        int end = classSig.length();

        if (end <= 0) {
            return classSig;
        }

        while (classSig.startsWith("[L", start)
                && classSig.charAt(end - 1) == ';') {
            start += 2;
            end--;
        }

        if (start > 0) {
            start -= 2;
            end++;
            return classSig.substring(start, end);
        }
        return classSig;
    }

    /**
     * Searches up the call stack to find the closest user-defined class loader.
     *
     * @return a user-defined class loader or null if one isn't found
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.490 -0500", hash_original_method = "D98B125FAAAD460E85A5D4A1FF301F64", hash_generated_method = "54386ACCAF7F85B9F2AC0743DD29A7FA")
    
private static ClassLoader getClosestUserClassLoader() {
        Class<?>[] stackClasses = VMStack.getClasses(-1);
        for (Class<?> stackClass : stackClasses) {
            ClassLoader loader = stackClass.getClassLoader();
            if (loader != null && loader != bootstrapLoader
                    && loader != systemLoader) {
                return loader;
            }
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.532 -0500", hash_original_method = "A0CE91BAC510F89CA68326A2D2BB846C", hash_generated_method = "2479985A4CC7F0155BD9D55EE6E99528")
    
private static String getBaseName(String fullName) {
        int k = fullName.lastIndexOf('.');

        if (k == -1 || k == (fullName.length() - 1)) {
            return fullName;
        }
        return fullName.substring(k + 1);
    }

    // Avoid recursive defining.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.534 -0500", hash_original_method = "8C220D66FEC4AEA02D44FBB23E305EE3", hash_generated_method = "6DFE137859E2431723804AFE073FB1DE")
    
private static void checkedSetSuperClassDesc(ObjectStreamClass desc,
            ObjectStreamClass superDesc) throws StreamCorruptedException {
        if (desc.equals(superDesc)) {
            throw new StreamCorruptedException();
        }
        desc.setSuperclass(superDesc);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.234 -0500", hash_original_field = "6D730F6C93DD7C2A4416622471570C96", hash_generated_field = "AB31E5C2BA954217EF88CD850CFC8C65")

    private static final Object UNSHARED_OBJ = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.280 -0500", hash_original_field = "FE8976417DE122742F6154062700C66D", hash_generated_field = "CF28BF30867E0E1F6DF3B872782F2ED3")

    private static final HashMap<String, Class<?>> PRIMITIVE_CLASSES = new HashMap<String, Class<?>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.485 -0500", hash_original_field = "F6BDD796BE242EFC698CF31581CE3475", hash_generated_field = "0BEDBBB2B96D03A03BECE92D911B88AD")

    private static final ClassLoader bootstrapLoader = Object.class.getClassLoader();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.487 -0500", hash_original_field = "EDE7D16B6228C961BDDBC273761A5AA8", hash_generated_field = "F543C6A7F69C1743531D486F7F24DDAE")

    private static final ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.231 -0500", hash_original_field = "E62CAED11D7D8CF4B05AAD238023950F", hash_generated_field = "9C428AEC470C7B513A34BE33B758C61C")

    private InputStream emptyStream = new ByteArrayInputStream(EmptyArray.BYTE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.236 -0500", hash_original_field = "E167A7F62CFB444503F5A4090BE02FFF", hash_generated_field = "21053CAF26FBF453351AB50E87AD2F52")

    // If the receiver has already read & not consumed a TC code
    private boolean hasPushbackTC;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.239 -0500", hash_original_field = "EA9FB30488BAC67D6E4297122C556C9C", hash_generated_field = "64B94603DBAD0B26BD5AE2F7439ED35E")

    private byte pushbackTC;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.241 -0500", hash_original_field = "71CE55750109EBB73E2456BE80AD82FD", hash_generated_field = "44C2A739F9FCE8EE18F01DB1FDB107D0")

    // the graph then reset it
    private int nestedLevels;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.243 -0500", hash_original_field = "8EAE359836FD9C95146A7ACCFACC06F6", hash_generated_field = "FBF49E90A1B9879AE660F9886E842C8C")

    private int nextHandle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.245 -0500", hash_original_field = "3641E961F2BB6244F8DF80F5DABB83F8", hash_generated_field = "32FD79F94203B3CB4FB10D6979B3AE55")

    private DataInputStream input;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.248 -0500", hash_original_field = "EADF9873A621801BEB71FA3A72516E46", hash_generated_field = "76093EED1B475C4F1E4C622B52BC7AC9")

    private DataInputStream primitiveTypes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.257 -0500", hash_original_field = "7FC6BD45EE99872A38AC6728297A8EB8", hash_generated_field = "28C1B2E39A3350A755888FD0A4428279")

    private InputStream primitiveData = emptyStream;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.259 -0500", hash_original_field = "694288FE215894999B301241015E73FA", hash_generated_field = "3240649A9311294AE1E098CB8F2A005F")

    private boolean enableResolve;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.261 -0500", hash_original_field = "007AD87C238909370A0C3868A6EE305B", hash_generated_field = "F79B8A3B52A523F03D688BC47873D2F6")

    private ArrayList<Object> objectsRead;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.263 -0500", hash_original_field = "42C03588FC817F62832A17907DDFD79F", hash_generated_field = "76736C274255A46E2AEB2CE593A1B428")

    private Object currentObject;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.266 -0500", hash_original_field = "6A61A63E4AD81B568463523E7D82D010", hash_generated_field = "7035F4B44BC3AE389D42445F7A5655AC")

    private ObjectStreamClass currentClass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.268 -0500", hash_original_field = "9DBCB1BDE21CB3EB5B946E72A3DBCDDE", hash_generated_field = "8C4317C196DED1BA406C6024DBBD377D")

    // type below.
    private InputValidationDesc[] validations;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.270 -0500", hash_original_field = "78AB9CCAB960E71CE119A2107AA96FD8", hash_generated_field = "3690401F10D38FF2C8AB1C19B641B107")

    private boolean subclassOverridingImplementation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.273 -0500", hash_original_field = "25FA2295C82613B967D606F7A8966571", hash_generated_field = "7E360A145DF451DC0144E812BE96A034")

    private ClassLoader callerClassLoader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.275 -0500", hash_original_field = "3D27A2E7EE078ED74F5C11ADF2584325", hash_generated_field = "2DA36CFD381BE4CC041D9D9E401B490D")

    private boolean mustResolve = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.277 -0500", hash_original_field = "A1A6EA6A1090FA50C53B4B7BD5146323", hash_generated_field = "2B0CB3B967646FBC95A533438216C0DF")

    private int descriptorHandle = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.416 -0500", hash_original_field = "5E938BD559A969212B32A397E001B937", hash_generated_field = "FAF1B21A627FAB868C99C514185244A6")

    private HashMap<Class<?>, List<Class<?>>> cachedSuperclasses = new HashMap<Class<?>, List<Class<?>>>();

    /**
     * Constructs a new ObjectInputStream. This default constructor can be used
     * by subclasses that do not want to use the public constructor if it
     * allocates unneeded data.
     *
     * @throws IOException
     *             if an error occurs when creating this stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.324 -0500", hash_original_method = "124623F0922D5D71F912D224AEC5FA85", hash_generated_method = "3440EFA570D2A028974AE6B06CE67786")
    
protected ObjectInputStream() throws IOException {
        // WARNING - we should throw IOException if not called from a subclass
        // according to the JavaDoc. Add the test.
        this.subclassOverridingImplementation = true;
    }

    /**
     * Constructs a new ObjectInputStream that reads from the InputStream
     * {@code input}.
     *
     * @param input
     *            the non-null source InputStream to filter reads on.
     * @throws IOException
     *             if an error occurs while reading the stream header.
     * @throws StreamCorruptedException
     *             if the source stream does not contain serialized objects that
     *             can be read.
     */
    @DSComment("Spec is marked when opening raw stream")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.328 -0500", hash_original_method = "15BB4AD74FE576D95ABFC0E40CC8A986", hash_generated_method = "51A8016FADCEFC89A5C92227CB583F45")
    
public ObjectInputStream(InputStream input) throws StreamCorruptedException, IOException {
        this.input = (input instanceof DataInputStream)
                ? (DataInputStream) input : new DataInputStream(input);
        primitiveTypes = new DataInputStream(this);
        enableResolve = false;
        this.subclassOverridingImplementation = false;
        resetState();
        nestedLevels = 0;
        // So read...() methods can be used by
        // subclasses during readStreamHeader()
        primitiveData = this.input;
        // Has to be done here according to the specification
        readStreamHeader();
        primitiveData = emptyStream;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.330 -0500", hash_original_method = "CEC952E1AEB3FC5761C4573EC7C87AAE", hash_generated_method = "CE199C5C58FE7687429E6A57CA1A8BB4")
    
@Override
    public int available() throws IOException {
        // returns 0 if next data is an object, or N if reading primitive types
        checkReadPrimitiveTypes();
        return primitiveData.available();
    }

    /**
     * Checks to if it is ok to read primitive types from this stream at
     * this point. One is not supposed to read primitive types when about to
     * read an object, for example, so an exception has to be thrown.
     *
     * @throws IOException
     *             If any IO problem occurred when trying to read primitive type
     *             or if it is illegal to read primitive types
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.333 -0500", hash_original_method = "5DD662298FB99DC11E3F5A1BB4812CC0", hash_generated_method = "C3EF6120899F63F2851F20098D8AAECC")
    
private void checkReadPrimitiveTypes() throws IOException {
        // If we still have primitive data, it is ok to read primitive data
        if (primitiveData == input || primitiveData.available() > 0) {
            return;
        }

        // If we got here either we had no Stream previously created or
        // we no longer have data in that one, so get more bytes
        do {
            int next = 0;
            if (hasPushbackTC) {
                hasPushbackTC = false;
            } else {
                next = input.read();
                pushbackTC = (byte) next;
            }
            switch (pushbackTC) {
                case TC_BLOCKDATA:
                    primitiveData = new ByteArrayInputStream(readBlockData());
                    return;
                case TC_BLOCKDATALONG:
                    primitiveData = new ByteArrayInputStream(readBlockDataLong());
                    return;
                case TC_RESET:
                    resetState();
                    break;
                default:
                    if (next != -1) {
                        pushbackTC();
                    }
                    return;
            }
            // Only TC_RESET falls through
        } while (true);
    }

    /**
     * Closes this stream. This implementation closes the source stream.
     *
     * @throws IOException
     *             if an error occurs while closing this stream.
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.335 -0500", hash_original_method = "4ECD43BBA7F31E748521530C375A35B5", hash_generated_method = "B1EA37F74AB1267A6B6A64C04E41DD04")
    
@Override
    public void close() throws IOException {
        input.close();
    }

    /**
     * Default method to read objects from this stream. Serializable fields
     * defined in the object's class and superclasses are read from the source
     * stream.
     *
     * @throws ClassNotFoundException
     *             if the object's class cannot be found.
     * @throws IOException
     *             if an I/O error occurs while reading the object data.
     * @throws NotActiveException
     *             if this method is not called from {@code readObject()}.
     * @see ObjectOutputStream#defaultWriteObject
     */
    @DSComment("I/O load/store")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.338 -0500", hash_original_method = "6463B95302326251A8E319007FB9B6A5", hash_generated_method = "42B11E4D034DE9D234002248F992250B")
    
public void defaultReadObject() throws IOException, ClassNotFoundException,
            NotActiveException {
        if (currentObject != null || !mustResolve) {
            readFieldValues(currentObject, currentClass);
        } else {
            throw new NotActiveException();
        }
    }

    /**
     * Enables object replacement for this stream. By default this is not
     * enabled. Only trusted subclasses (loaded with system class loader) are
     * allowed to change this status.
     *
     * @param enable
     *            {@code true} to enable object replacement; {@code false} to
     *            disable it.
     * @return the previous setting.
     * @see #resolveObject
     * @see ObjectOutputStream#enableReplaceObject
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.341 -0500", hash_original_method = "970A975ADDA1CD42A4A6880D40629922", hash_generated_method = "7840174AABAA1247E8931B1165341544")
    
protected boolean enableResolveObject(boolean enable) {
        boolean originalValue = enableResolve;
        enableResolve = enable;
        return originalValue;
    }

    /**
     * Return the next {@code int} handle to be used to indicate cyclic
     * references being loaded from the stream.
     *
     * @return the next handle to represent the next cyclic reference
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.343 -0500", hash_original_method = "BEEE4D4B01DB5401D5A386ECF8653C53", hash_generated_method = "1FEAC46397CA5C5CC1B3C18072FEC1ED")
    
private int nextHandle() {
        return nextHandle++;
    }

    /**
     * Return the next token code (TC) from the receiver, which indicates what
     * kind of object follows
     *
     * @return the next TC from the receiver
     *
     * @throws IOException
     *             If an IO error occurs
     *
     * @see ObjectStreamConstants
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.345 -0500", hash_original_method = "EA84EB3C5ACC30FA1515ABE6938E6E9B", hash_generated_method = "3375AA35A03A36642F4172B23EE6E242")
    
private byte nextTC() throws IOException {
        if (hasPushbackTC) {
            hasPushbackTC = false; // We are consuming it
        } else {
            // Just in case a later call decides to really push it back,
            // we don't require the caller to pass it as parameter
            pushbackTC = input.readByte();
        }
        return pushbackTC;
    }

    /**
     * Pushes back the last TC code read
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.347 -0500", hash_original_method = "056AB6ECFECE1087CD6299233C3046CF", hash_generated_method = "292BC4244431736EA7AF14D030043B8C")
    
private void pushbackTC() {
        hasPushbackTC = true;
    }

    /**
     * Reads a single byte from the source stream and returns it as an integer
     * in the range from 0 to 255. Returns -1 if the end of the source stream
     * has been reached. Blocks if no input is available.
     *
     * @return the byte read or -1 if the end of the source stream has been
     *         reached.
     * @throws IOException
     *             if an error occurs while reading from this stream.
     */
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.350 -0500", hash_original_method = "87E37984C9E76D351365EC77DA0248F5", hash_generated_method = "628E188E690827B74EB56F54AB76B4A3")
    
@Override
    public int read() throws IOException {
        checkReadPrimitiveTypes();
        return primitiveData.read();
    }

    /**
     * Reads at most {@code length} bytes from the source stream and stores them
     * in byte array {@code buffer} starting at offset {@code count}. Blocks
     * until {@code count} bytes have been read, the end of the source stream is
     * detected or an exception is thrown.
     *
     * @param buffer
     *            the array in which to store the bytes read.
     * @param offset
     *            the initial position in {@code buffer} to store the bytes
     *            read from the source stream.
     * @param length
     *            the maximum number of bytes to store in {@code buffer}.
     * @return the number of bytes read or -1 if the end of the source input
     *         stream has been reached.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code length < 0}, or if
     *             {@code offset + length} is greater than the length of
     *             {@code buffer}.
     * @throws IOException
     *             if an error occurs while reading from this stream.
     * @throws NullPointerException
     *             if {@code buffer} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.352 -0500", hash_original_method = "7E3B2630C90BBA61B0E7CD83B04481D2", hash_generated_method = "17C0B89F710648736C76E8163CC98F55")
    
@Override
    public int read(byte[] buffer, int offset, int length) throws IOException {
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
        if (length == 0) {
            return 0;
        }
        checkReadPrimitiveTypes();
        return primitiveData.read(buffer, offset, length);
    }

    /**
     * Reads and returns an array of raw bytes with primitive data. The array
     * will have up to 255 bytes. The primitive data will be in the format
     * described by {@code DataOutputStream}.
     *
     * @return The primitive data read, as raw bytes
     *
     * @throws IOException
     *             If an IO exception happened when reading the primitive data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.355 -0500", hash_original_method = "35383BB5231F8136A4FECB09DEC2FE93", hash_generated_method = "1C03820D8116427A920F9A19EFAFA7E1")
    
private byte[] readBlockData() throws IOException {
        byte[] result = new byte[input.readByte() & 0xff];
        input.readFully(result);
        return result;
    }

    /**
     * Reads and returns an array of raw bytes with primitive data. The array
     * will have more than 255 bytes. The primitive data will be in the format
     * described by {@code DataOutputStream}.
     *
     * @return The primitive data read, as raw bytes
     *
     * @throws IOException
     *             If an IO exception happened when reading the primitive data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.358 -0500", hash_original_method = "478D7B43D09CD1BAF3CA95670FAE291A", hash_generated_method = "E5D46E2A85AA403CC816C040B9832E4C")
    
private byte[] readBlockDataLong() throws IOException {
        byte[] result = new byte[input.readInt()];
        input.readFully(result);
        return result;
    }

    /**
     * Reads a boolean from the source stream.
     *
     * @return the boolean value read from the source stream.
     * @throws EOFException
     *             if the end of the input is reached before the read
     *             request can be satisfied.
     * @throws IOException
     *             if an error occurs while reading from the source stream.
     */
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.360 -0500", hash_original_method = "43182B65F59B21B8425D068A4900EB3A", hash_generated_method = "56A81332F158117C3BDA56D23B5D1F78")
    
public boolean readBoolean() throws IOException {
        return primitiveTypes.readBoolean();
    }

    /**
     * Reads a byte (8 bit) from the source stream.
     *
     * @return the byte value read from the source stream.
     * @throws EOFException
     *             if the end of the input is reached before the read
     *             request can be satisfied.
     * @throws IOException
     *             if an error occurs while reading from the source stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.362 -0500", hash_original_method = "F1C938A529B536DE0EA7C0848AC19388", hash_generated_method = "8AF10F987D87488CD22BBBC1A94EBAB2")
    
public byte readByte() throws IOException {
        return primitiveTypes.readByte();
    }

    /**
     * Reads a character (16 bit) from the source stream.
     *
     * @return the char value read from the source stream.
     * @throws EOFException
     *             if the end of the input is reached before the read
     *             request can be satisfied.
     * @throws IOException
     *             if an error occurs while reading from the source stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.365 -0500", hash_original_method = "08C7569945A67E2D251F3B449209E666", hash_generated_method = "26188AAC2A9765FB27045F28907DF948")
    
public char readChar() throws IOException {
        return primitiveTypes.readChar();
    }

    /**
     * Reads and discards block data and objects until TC_ENDBLOCKDATA is found.
     *
     * @throws IOException
     *             If an IO exception happened when reading the optional class
     *             annotation.
     * @throws ClassNotFoundException
     *             If the class corresponding to the class descriptor could not
     *             be found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.367 -0500", hash_original_method = "7E3D613702E21574BA96B289FBA102EA", hash_generated_method = "954EF7F370EC2E4439CDEDE6D258AFFC")
    
private void discardData() throws ClassNotFoundException, IOException {
        primitiveData = emptyStream;
        boolean resolve = mustResolve;
        mustResolve = false;
        do {
            byte tc = nextTC();
            if (tc == TC_ENDBLOCKDATA) {
                mustResolve = resolve;
                return; // End of annotation
            }
            readContent(tc);
        } while (true);
    }

    /**
     * Reads a class descriptor (an {@code ObjectStreamClass}) from the
     * stream.
     *
     * @return the class descriptor read from the stream
     *
     * @throws IOException
     *             If an IO exception happened when reading the class
     *             descriptor.
     * @throws ClassNotFoundException
     *             If the class corresponding to the class descriptor could not
     *             be found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.371 -0500", hash_original_method = "8425AE4559FEB283CFFC129B3DDD377F", hash_generated_method = "0EB62CC4CA8F6E6E6BCDEED50D4D1300")
    
private ObjectStreamClass readClassDesc() throws ClassNotFoundException, IOException {
        byte tc = nextTC();
        switch (tc) {
            case TC_CLASSDESC:
                return readNewClassDesc(false);
            case TC_PROXYCLASSDESC:
                Class<?> proxyClass = readNewProxyClassDesc();
                ObjectStreamClass streamClass = ObjectStreamClass.lookup(proxyClass);
                streamClass.setLoadFields(ObjectStreamClass.NO_FIELDS);
                registerObjectRead(streamClass, nextHandle(), false);
                checkedSetSuperClassDesc(streamClass, readClassDesc());
                return streamClass;
            case TC_REFERENCE:
                return (ObjectStreamClass) readCyclicReference();
            case TC_NULL:
                return null;
            default:
                throw corruptStream(tc);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.373 -0500", hash_original_method = "D1B003D7ABBBCEF0B15D64544C91AEEF", hash_generated_method = "0E2F5E06C3A561225FCAABA3D22891C5")
    
private StreamCorruptedException corruptStream(byte tc) throws StreamCorruptedException {
        throw new StreamCorruptedException("Wrong format: " + Integer.toHexString(tc & 0xff));
    }

    /**
     * Reads the content of the receiver based on the previously read token
     * {@code tc}.
     *
     * @param tc
     *            The token code for the next item in the stream
     * @return the object read from the stream
     *
     * @throws IOException
     *             If an IO exception happened when reading the class
     *             descriptor.
     * @throws ClassNotFoundException
     *             If the class corresponding to the object being read could not
     *             be found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.376 -0500", hash_original_method = "EBF146E3B3C2508DCA0D721582A75609", hash_generated_method = "554AFFE0CAC74237F0EE73767931CBF9")
    
private Object readContent(byte tc) throws ClassNotFoundException,
            IOException {
        switch (tc) {
            case TC_BLOCKDATA:
                return readBlockData();
            case TC_BLOCKDATALONG:
                return readBlockDataLong();
            case TC_CLASS:
                return readNewClass(false);
            case TC_CLASSDESC:
                return readNewClassDesc(false);
            case TC_ARRAY:
                return readNewArray(false);
            case TC_OBJECT:
                return readNewObject(false);
            case TC_STRING:
                return readNewString(false);
            case TC_LONGSTRING:
                return readNewLongString(false);
            case TC_REFERENCE:
                return readCyclicReference();
            case TC_NULL:
                return null;
            case TC_EXCEPTION:
                Exception exc = readException();
                throw new WriteAbortedException("Read an exception", exc);
            case TC_RESET:
                resetState();
                return null;
            default:
                throw corruptStream(tc);
        }
    }

    /**
     * Reads the content of the receiver based on the previously read token
     * {@code tc}. Primitive data content is considered an error.
     *
     * @param unshared
     *            read the object unshared
     * @return the object read from the stream
     *
     * @throws IOException
     *             If an IO exception happened when reading the class
     *             descriptor.
     * @throws ClassNotFoundException
     *             If the class corresponding to the object being read could not
     *             be found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.379 -0500", hash_original_method = "C964F7473D297E2F3A28B1C55493EBEA", hash_generated_method = "134B70CC24B5AD5423D8F1D4B64AF289")
    
private Object readNonPrimitiveContent(boolean unshared)
            throws ClassNotFoundException, IOException {
        checkReadPrimitiveTypes();
        if (primitiveData.available() > 0) {
            OptionalDataException e = new OptionalDataException();
            e.length = primitiveData.available();
            throw e;
        }

        do {
            byte tc = nextTC();
            switch (tc) {
                case TC_CLASS:
                    return readNewClass(unshared);
                case TC_CLASSDESC:
                    return readNewClassDesc(unshared);
                case TC_ARRAY:
                    return readNewArray(unshared);
                case TC_OBJECT:
                    return readNewObject(unshared);
                case TC_STRING:
                    return readNewString(unshared);
                case TC_LONGSTRING:
                    return readNewLongString(unshared);
                case TC_ENUM:
                    return readEnum(unshared);
                case TC_REFERENCE:
                    if (unshared) {
                        readNewHandle();
                        throw new InvalidObjectException("Unshared read of back reference");
                    }
                    return readCyclicReference();
                case TC_NULL:
                    return null;
                case TC_EXCEPTION:
                    Exception exc = readException();
                    throw new WriteAbortedException("Read an exception", exc);
                case TC_RESET:
                    resetState();
                    break;
                case TC_ENDBLOCKDATA: // Can occur reading class annotation
                    pushbackTC();
                    OptionalDataException e = new OptionalDataException();
                    e.eof = true;
                    throw e;
                default:
                    throw corruptStream(tc);
            }
            // Only TC_RESET falls through
        } while (true);
    }

    /**
     * Reads the next item from the stream assuming it is a cyclic reference to
     * an object previously read. Return the actual object previously read.
     *
     * @return the object previously read from the stream
     *
     * @throws IOException
     *             If an IO exception happened when reading the class
     *             descriptor.
     * @throws InvalidObjectException
     *             If the cyclic reference is not valid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.381 -0500", hash_original_method = "821B45232EA8F88246A504603C8240EF", hash_generated_method = "A1A38C40A4D574580ED6E4965907783D")
    
private Object readCyclicReference() throws InvalidObjectException, IOException {
        return registeredObjectRead(readNewHandle());
    }

    /**
     * Reads a double (64 bit) from the source stream.
     *
     * @return the double value read from the source stream.
     * @throws EOFException
     *             if the end of the input is reached before the read
     *             request can be satisfied.
     * @throws IOException
     *             if an error occurs while reading from the source stream.
     */
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.383 -0500", hash_original_method = "7C91F28BD77A4ED641420E614D9FCB15", hash_generated_method = "7756E71F951822D28642A19BC06AC8CF")
    
public double readDouble() throws IOException {
        return primitiveTypes.readDouble();
    }

    /**
     * Read the next item assuming it is an exception. The exception is not a
     * regular instance in the object graph, but the exception instance that
     * happened (if any) when dumping the original object graph. The set of seen
     * objects will be reset just before and just after loading this exception
     * object.
     * <p>
     * When exceptions are found normally in the object graph, they are loaded
     * as a regular object, and not by this method. In that case, the set of
     * "known objects" is not reset.
     *
     * @return the exception read
     *
     * @throws IOException
     *             If an IO exception happened when reading the exception
     *             object.
     * @throws ClassNotFoundException
     *             If a class could not be found when reading the object graph
     *             for the exception
     * @throws OptionalDataException
     *             If optional data could not be found when reading the
     *             exception graph
     * @throws WriteAbortedException
     *             If another exception was caused when dumping this exception
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.387 -0500", hash_original_method = "BA11A34B6A0BFC2FA522B0508C6E225C", hash_generated_method = "044317D68DA0BD38805F29B4FD1F0A5F")
    
private Exception readException() throws WriteAbortedException,
            OptionalDataException, ClassNotFoundException, IOException {

        resetSeenObjects();

        // Now we read the Throwable object that was saved
        // WARNING - the grammar says it is a Throwable, but the
        // WriteAbortedException constructor takes an Exception. So, we read an
        // Exception from the stream
        Exception exc = (Exception) readObject();

        // We reset the receiver's state (the grammar has "reset" in normal
        // font)
        resetSeenObjects();
        return exc;
    }

    /**
     * Reads a collection of field descriptors (name, type name, etc) for the
     * class descriptor {@code cDesc} (an {@code ObjectStreamClass})
     *
     * @param cDesc
     *            The class descriptor (an {@code ObjectStreamClass})
     *            for which to write field information
     *
     * @throws IOException
     *             If an IO exception happened when reading the field
     *             descriptors.
     * @throws ClassNotFoundException
     *             If a class for one of the field types could not be found
     *
     * @see #readObject()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.390 -0500", hash_original_method = "FA3DFED5FC7EE2104F3E818CA56DCFE9", hash_generated_method = "E4BD98D5378DA6DDDEC60DE40A7E4B61")
    
private void readFieldDescriptors(ObjectStreamClass cDesc)
            throws ClassNotFoundException, IOException {
        short numFields = input.readShort();
        ObjectStreamField[] fields = new ObjectStreamField[numFields];

        // We set it now, but each element will be inserted in the array further
        // down
        cDesc.setLoadFields(fields);

        // Check ObjectOutputStream.writeFieldDescriptors
        for (short i = 0; i < numFields; i++) {
            char typecode = (char) input.readByte();
            String fieldName = input.readUTF();
            boolean isPrimType = ObjectStreamClass.isPrimitiveType(typecode);
            String classSig;
            if (isPrimType) {
                classSig = String.valueOf(typecode);
            } else {
                // The spec says it is a UTF, but experience shows they dump
                // this String using writeObject (unlike the field name, which
                // is saved with writeUTF).
                // And if resolveObject is enabled, the classSig may be modified
                // so that the original class descriptor cannot be read
                // properly, so it is disabled.
                boolean old = enableResolve;
                try {
                    enableResolve = false;
                    classSig = (String) readObject();
                } finally {
                    enableResolve = old;
                }
            }

            classSig = formatClassSig(classSig);
            ObjectStreamField f = new ObjectStreamField(classSig, fieldName);
            fields[i] = f;
        }
    }

    /**
     * Reads the persistent fields of the object that is currently being read
     * from the source stream. The values read are stored in a GetField object
     * that provides access to the persistent fields. This GetField object is
     * then returned.
     *
     * @return the GetField object from which persistent fields can be accessed
     *         by name.
     * @throws ClassNotFoundException
     *             if the class of an object being deserialized can not be
     *             found.
     * @throws IOException
     *             if an error occurs while reading from this stream.
     * @throws NotActiveException
     *             if this stream is currently not reading an object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.395 -0500", hash_original_method = "35D23573908F6AA48B37BF1647A74D3F", hash_generated_method = "2AFE092A922DE3677B1ACAF5A4F4A9D4")
    
public GetField readFields() throws IOException, ClassNotFoundException, NotActiveException {
        if (currentObject == null) {
            throw new NotActiveException();
        }
        EmulatedFieldsForLoading result = new EmulatedFieldsForLoading(currentClass);
        readFieldValues(result);
        return result;
    }

    /**
     * Reads a collection of field values for the emulated fields
     * {@code emulatedFields}
     *
     * @param emulatedFields
     *            an {@code EmulatedFieldsForLoading}, concrete subclass
     *            of {@code GetField}
     *
     * @throws IOException
     *             If an IO exception happened when reading the field values.
     * @throws InvalidClassException
     *             If an incompatible type is being assigned to an emulated
     *             field.
     * @throws OptionalDataException
     *             If optional data could not be found when reading the
     *             exception graph
     *
     * @see #readFields
     * @see #readObject()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.398 -0500", hash_original_method = "8289C081F35F5F257A7DE20983B5F39B", hash_generated_method = "5D42170528FE8B54CC3E422150BFF631")
    
private void readFieldValues(EmulatedFieldsForLoading emulatedFields)
            throws OptionalDataException, InvalidClassException, IOException {
        EmulatedFields.ObjectSlot[] slots = emulatedFields.emulatedFields().slots();
        for (ObjectSlot element : slots) {
            element.defaulted = false;
            Class<?> type = element.field.getType();
            if (type == int.class) {
                element.fieldValue = input.readInt();
            } else if (type == byte.class) {
                element.fieldValue = input.readByte();
            } else if (type == char.class) {
                element.fieldValue = input.readChar();
            } else if (type == short.class) {
                element.fieldValue = input.readShort();
            } else if (type == boolean.class) {
                element.fieldValue = input.readBoolean();
            } else if (type == long.class) {
                element.fieldValue = input.readLong();
            } else if (type == float.class) {
                element.fieldValue = input.readFloat();
            } else if (type == double.class) {
                element.fieldValue = input.readDouble();
            } else {
                // Either array or Object
                try {
                    element.fieldValue = readObject();
                } catch (ClassNotFoundException cnf) {
                    // WARNING- Not sure this is the right thing to do. Write
                    // test case.
                    throw new InvalidClassException(cnf.toString());
                }
            }
        }
    }

    /**
     * Reads a collection of field values for the class descriptor
     * {@code classDesc} (an {@code ObjectStreamClass}). The
     * values will be used to set instance fields in object {@code obj}.
     * This is the default mechanism, when emulated fields (an
     * {@code GetField}) are not used. Actual values to load are stored
     * directly into the object {@code obj}.
     *
     * @param obj
     *            Instance in which the fields will be set.
     * @param classDesc
     *            A class descriptor (an {@code ObjectStreamClass})
     *            defining which fields should be loaded.
     *
     * @throws IOException
     *             If an IO exception happened when reading the field values.
     * @throws InvalidClassException
     *             If an incompatible type is being assigned to an emulated
     *             field.
     * @throws OptionalDataException
     *             If optional data could not be found when reading the
     *             exception graph
     * @throws ClassNotFoundException
     *             If a class of an object being de-serialized can not be found
     *
     * @see #readFields
     * @see #readObject()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.402 -0500", hash_original_method = "3FF4AC35875B69602347D8B467CAEB0A", hash_generated_method = "B2EA26F1CE3B08981EDE8CC25190A73C")
    
private void readFieldValues(Object obj, ObjectStreamClass classDesc) throws OptionalDataException, ClassNotFoundException, IOException {
        // Now we must read all fields and assign them to the receiver
        ObjectStreamField[] fields = classDesc.getLoadFields();
        fields = (fields == null) ? ObjectStreamClass.NO_FIELDS : fields;
        Class<?> declaringClass = classDesc.forClass();
        if (declaringClass == null && mustResolve) {
            throw new ClassNotFoundException(classDesc.getName());
        }

        for (ObjectStreamField fieldDesc : fields) {
            Field field = classDesc.getReflectionField(fieldDesc);
            // We may not have been able to find the field, but we still need to read the value
            // and do the other checking, so there's no null check on 'field' here.
            try {
                Class<?> type = fieldDesc.getTypeInternal();
                if (type == byte.class) {
                    byte b = input.readByte();
                    if (field != null) {
                        field.setByte(obj, b);
                    }
                } else if (type == char.class) {
                    char c = input.readChar();
                    if (field != null) {
                        field.setChar(obj, c);
                    }
                } else if (type == double.class) {
                    double d = input.readDouble();
                    if (field != null) {
                        field.setDouble(obj, d);
                    }
                } else if (type == float.class) {
                    float f = input.readFloat();
                    if (field != null) {
                        field.setFloat(obj, f);
                    }
                } else if (type == int.class) {
                    int i = input.readInt();
                    if (field != null) {
                        field.setInt(obj, i);
                    }
                } else if (type == long.class) {
                    long j = input.readLong();
                    if (field != null) {
                        field.setLong(obj, j);
                    }
                } else if (type == short.class) {
                    short s = input.readShort();
                    if (field != null) {
                        field.setShort(obj, s);
                    }
                } else if (type == boolean.class) {
                    boolean z = input.readBoolean();
                    if (field != null) {
                        field.setBoolean(obj, z);
                    }
                } else {
                    Object toSet = fieldDesc.isUnshared() ? readUnshared() : readObject();
                    if (toSet != null) {
                        // Get the field type from the local field rather than
                        // from the stream's supplied data. That's the field
                        // we'll be setting, so that's the one that needs to be
                        // validated.
                        String fieldName = fieldDesc.getName();
                        ObjectStreamField localFieldDesc = classDesc.getField(fieldName);
                        Class<?> fieldType = localFieldDesc.getTypeInternal();
                        Class<?> valueType = toSet.getClass();
                        if (!fieldType.isAssignableFrom(valueType)) {
                            throw new ClassCastException(classDesc.getName() + "." + fieldName + " - " + fieldType + " not compatible with " + valueType);
                        }
                        if (field != null) {
                            field.set(obj, toSet);
                        }
                    }
                }
            } catch (IllegalAccessException iae) {
                // ObjectStreamField should have called setAccessible(true).
                throw new AssertionError(iae);
            } catch (NoSuchFieldError ignored) {
            }
        }
    }

    /**
     * Reads a float (32 bit) from the source stream.
     *
     * @return the float value read from the source stream.
     * @throws EOFException
     *             if the end of the input is reached before the read
     *             request can be satisfied.
     * @throws IOException
     *             if an error occurs while reading from the source stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.405 -0500", hash_original_method = "E7BFAC98C28E1C1B49BD33FC0E76EA53", hash_generated_method = "5793794E9B8046275BA3A984375CF554")
    
public float readFloat() throws IOException {
        return primitiveTypes.readFloat();
    }

    /**
     * Reads bytes from the source stream into the byte array {@code dst}.
     * This method will block until {@code dst.length} bytes have been read.
     *
     * @param dst
     *            the array in which to store the bytes read.
     * @throws EOFException
     *             if the end of the input is reached before the read
     *             request can be satisfied.
     * @throws IOException
     *             if an error occurs while reading from the source stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.407 -0500", hash_original_method = "917418BB5C848A4690F4E96972002BAD", hash_generated_method = "6BE355C156BB46B842CB65F73AE99956")
    
public void readFully(byte[] dst) throws IOException {
        primitiveTypes.readFully(dst);
    }

    /**
     * Reads {@code byteCount} bytes from the source stream into the byte array {@code dst}.
     *
     * @param dst
     *            the byte array in which to store the bytes read.
     * @param offset
     *            the initial position in {@code dst} to store the bytes
     *            read from the source stream.
     * @param byteCount
     *            the number of bytes to read.
     * @throws EOFException
     *             if the end of the input is reached before the read
     *             request can be satisfied.
     * @throws IOException
     *             if an error occurs while reading from the source stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.409 -0500", hash_original_method = "046EB506BDA13B9ED79306898615169A", hash_generated_method = "AD228AC0C6066AA186ED24483B5C1CB9")
    
public void readFully(byte[] dst, int offset, int byteCount) throws IOException {
        primitiveTypes.readFully(dst, offset, byteCount);
    }

    /**
     * Walks the hierarchy of classes described by class descriptor
     * {@code classDesc} and reads the field values corresponding to
     * fields declared by the corresponding class descriptor. The instance to
     * store field values into is {@code object}. If the class
     * (corresponding to class descriptor {@code classDesc}) defines
     * private instance method {@code readObject} it will be used to load
     * field values.
     *
     * @param object
     *            Instance into which stored field values loaded.
     * @param classDesc
     *            A class descriptor (an {@code ObjectStreamClass})
     *            defining which fields should be loaded.
     *
     * @throws IOException
     *             If an IO exception happened when reading the field values in
     *             the hierarchy.
     * @throws ClassNotFoundException
     *             If a class for one of the field types could not be found
     * @throws NotActiveException
     *             If {@code defaultReadObject} is called from the wrong
     *             context.
     *
     * @see #defaultReadObject
     * @see #readObject()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.412 -0500", hash_original_method = "D8B45244A94A62B53D8A8E2E7C864422", hash_generated_method = "8879539C1678805FB3904F91EAB1F7B7")
    
private void readHierarchy(Object object, ObjectStreamClass classDesc)
            throws IOException, ClassNotFoundException, NotActiveException {
        if (object == null && mustResolve) {
            throw new NotActiveException();
        }

        List<ObjectStreamClass> streamClassList = classDesc.getHierarchy();
        if (object == null) {
            for (ObjectStreamClass objectStreamClass : streamClassList) {
                readObjectForClass(null, objectStreamClass);
            }
        } else {
            List<Class<?>> superclasses = cachedSuperclasses.get(object.getClass());
            if (superclasses == null) {
                superclasses = cacheSuperclassesFor(object.getClass());
            }

            int lastIndex = 0;
            for (int i = 0, end = superclasses.size(); i < end; ++i) {
                Class<?> superclass = superclasses.get(i);
                int index = findStreamSuperclass(superclass, streamClassList, lastIndex);
                if (index == -1) {
                    readObjectNoData(object, superclass,
                            ObjectStreamClass.lookupStreamClass(superclass));
                } else {
                    for (int j = lastIndex; j <= index; j++) {
                        readObjectForClass(object, streamClassList.get(j));
                    }
                    lastIndex = index + 1;
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.418 -0500", hash_original_method = "F09DF984FD463C1BCDA606260FD08FFE", hash_generated_method = "621E744F459D0340FE873B6CB874F4C5")
    
private List<Class<?>> cacheSuperclassesFor(Class<?> c) {
        ArrayList<Class<?>> result = new ArrayList<Class<?>>();
        Class<?> nextClass = c;
        while (nextClass != null) {
            Class<?> testClass = nextClass.getSuperclass();
            if (testClass != null) {
                result.add(0, nextClass);
            }
            nextClass = testClass;
        }
        cachedSuperclasses.put(c, result);
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.421 -0500", hash_original_method = "30EFDC31EF83C1843078545357CDA4A5", hash_generated_method = "81037B839323F2763E9550797834FB61")
    
private int findStreamSuperclass(Class<?> cl, List<ObjectStreamClass> classList, int lastIndex) {
        for (int i = lastIndex, end = classList.size(); i < end; i++) {
            ObjectStreamClass objCl = classList.get(i);
            String forName = objCl.forClass().getName();

            if (objCl.getName().equals(forName)) {
                if (cl.getName().equals(objCl.getName())) {
                    return i;
                }
            } else {
                // there was a class replacement
                if (cl.getName().equals(forName)) {
                    return i;
                }
            }
        }
        return -1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.423 -0500", hash_original_method = "868BCCA0967481794CFA1D8D3E56D3E6", hash_generated_method = "F375DB5BE6E12A395774B250704BA193")
    
private void readObjectNoData(Object object, Class<?> cl, ObjectStreamClass classDesc)
            throws ObjectStreamException {
        if (!classDesc.isSerializable()) {
            return;
        }
        if (classDesc.hasMethodReadObjectNoData()){
            final Method readMethod = classDesc.getMethodReadObjectNoData();
            try {
                readMethod.invoke(object);
            } catch (InvocationTargetException e) {
                Throwable ex = e.getTargetException();
                if (ex instanceof RuntimeException) {
                    throw (RuntimeException) ex;
                } else if (ex instanceof Error) {
                    throw (Error) ex;
                }
                throw (ObjectStreamException) ex;
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e.toString());
            }
        }

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.426 -0500", hash_original_method = "6119E962BBCC069017D862716C24BEC0", hash_generated_method = "CBBEA02263266C9A5DEAFC076D109545")
    
private void readObjectForClass(Object object, ObjectStreamClass classDesc)
            throws IOException, ClassNotFoundException, NotActiveException {
        // Have to do this before calling defaultReadObject or anything that
        // calls defaultReadObject
        currentObject = object;
        currentClass = classDesc;

        boolean hadWriteMethod = (classDesc.getFlags() & SC_WRITE_METHOD) != 0;
        Class<?> targetClass = classDesc.forClass();

        final Method readMethod;
        if (targetClass == null || !mustResolve) {
            readMethod = null;
        } else {
            readMethod = classDesc.getMethodReadObject();
        }
        try {
            if (readMethod != null) {
                // We have to be able to fetch its value, even if it is private
                readMethod.setAccessible(true);
                try {
                    readMethod.invoke(object, this);
                } catch (InvocationTargetException e) {
                    Throwable ex = e.getTargetException();
                    if (ex instanceof ClassNotFoundException) {
                        throw (ClassNotFoundException) ex;
                    } else if (ex instanceof RuntimeException) {
                        throw (RuntimeException) ex;
                    } else if (ex instanceof Error) {
                        throw (Error) ex;
                    }
                    throw (IOException) ex;
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e.toString());
                }
            } else {
                defaultReadObject();
            }
            if (hadWriteMethod) {
                discardData();
            }
        } finally {
            // Cleanup, needs to run always so that we can later detect invalid
            // calls to defaultReadObject
            currentObject = null; // We did not set this, so we do not need to
            // clean it
            currentClass = null;
        }
    }

    /**
     * Reads an integer (32 bit) from the source stream.
     *
     * @return the integer value read from the source stream.
     * @throws EOFException
     *             if the end of the input is reached before the read
     *             request can be satisfied.
     * @throws IOException
     *             if an error occurs while reading from the source stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.428 -0500", hash_original_method = "D31E8D2825D4043295F3D0C685B93717", hash_generated_method = "E9843F0E9026BCD63DD0DCCFFB3E80A4")
    
public int readInt() throws IOException {
        return primitiveTypes.readInt();
    }

    /**
     * Reads the next line from the source stream. Lines are terminated by
     * {@code '\r'}, {@code '\n'}, {@code "\r\n"} or an {@code EOF}.
     *
     * @return the string read from the source stream.
     * @throws IOException
     *             if an error occurs while reading from the source stream.
     * @deprecated Use {@link BufferedReader}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.431 -0500", hash_original_method = "90EA71A98921C4D093F2F0BA4DDBE95D", hash_generated_method = "973CF80D9439F595F0579FC1679C8BF0")
    
@Deprecated
    public String readLine() throws IOException {
        return primitiveTypes.readLine();
    }

    /**
     * Reads a long (64 bit) from the source stream.
     *
     * @return the long value read from the source stream.
     * @throws EOFException
     *             if the end of the input is reached before the read
     *             request can be satisfied.
     * @throws IOException
     *             if an error occurs while reading from the source stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.433 -0500", hash_original_method = "70C9FFE9F08A2EBCF32FC4C20D730AD7", hash_generated_method = "B01CFE6D9156E407A7419A8C068B709D")
    
public long readLong() throws IOException {
        return primitiveTypes.readLong();
    }

    /**
     * Read a new array from the receiver. It is assumed the array has not been
     * read yet (not a cyclic reference). Return the array read.
     *
     * @param unshared
     *            read the object unshared
     * @return the array read
     *
     * @throws IOException
     *             If an IO exception happened when reading the array.
     * @throws ClassNotFoundException
     *             If a class for one of the objects could not be found
     * @throws OptionalDataException
     *             If optional data could not be found when reading the array.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.438 -0500", hash_original_method = "6C628531F4475FFAEEB816E877548000", hash_generated_method = "C20AEE76421C64D7CA2F6D2B96885C6A")
    
private Object readNewArray(boolean unshared) throws OptionalDataException,
            ClassNotFoundException, IOException {
        ObjectStreamClass classDesc = readClassDesc();

        if (classDesc == null) {
            throw missingClassDescriptor();
        }

        int newHandle = nextHandle();

        // Array size
        int size = input.readInt();
        Class<?> arrayClass = classDesc.forClass();
        Class<?> componentType = arrayClass.getComponentType();
        Object result = Array.newInstance(componentType, size);

        registerObjectRead(result, newHandle, unshared);

        // Now we have code duplication just because Java is typed. We have to
        // read N elements and assign to array positions, but we must typecast
        // the array first, and also call different methods depending on the
        // elements.
        if (componentType.isPrimitive()) {
            if (componentType == int.class) {
                int[] intArray = (int[]) result;
                for (int i = 0; i < size; i++) {
                    intArray[i] = input.readInt();
                }
            } else if (componentType == byte.class) {
                byte[] byteArray = (byte[]) result;
                input.readFully(byteArray, 0, size);
            } else if (componentType == char.class) {
                char[] charArray = (char[]) result;
                for (int i = 0; i < size; i++) {
                    charArray[i] = input.readChar();
                }
            } else if (componentType == short.class) {
                short[] shortArray = (short[]) result;
                for (int i = 0; i < size; i++) {
                    shortArray[i] = input.readShort();
                }
            } else if (componentType == boolean.class) {
                boolean[] booleanArray = (boolean[]) result;
                for (int i = 0; i < size; i++) {
                    booleanArray[i] = input.readBoolean();
                }
            } else if (componentType == long.class) {
                long[] longArray = (long[]) result;
                for (int i = 0; i < size; i++) {
                    longArray[i] = input.readLong();
                }
            } else if (componentType == float.class) {
                float[] floatArray = (float[]) result;
                for (int i = 0; i < size; i++) {
                    floatArray[i] = input.readFloat();
                }
            } else if (componentType == double.class) {
                double[] doubleArray = (double[]) result;
                for (int i = 0; i < size; i++) {
                    doubleArray[i] = input.readDouble();
                }
            } else {
                throw new ClassNotFoundException("Wrong base type in " + classDesc.getName());
            }
        } else {
            // Array of Objects
            Object[] objectArray = (Object[]) result;
            for (int i = 0; i < size; i++) {
                // TODO: This place is the opportunity for enhancement
                //      We can implement writing elements through fast-path,
                //      without setting up the context (see readObject()) for
                //      each element with public API
                objectArray[i] = readObject();
            }
        }
        if (enableResolve) {
            result = resolveObject(result);
            registerObjectRead(result, newHandle, false);
        }
        return result;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.500 -0400", hash_original_method = "5D3FFF38041945ED84D75A0CC474793D", hash_generated_method = "B0166E10435415AFDFFF1FF2042C9E72")
    private Class<?> readNewClass(boolean unshared) throws ClassNotFoundException, IOException {
        addTaint(unshared);
        ObjectStreamClass classDesc = readClassDesc();
    if(classDesc == null)        
        {
            InvalidClassException varF0B669FE625FDCD2C0B7AFC2BF75622C_339873029 = missingClassDescriptor();
            varF0B669FE625FDCD2C0B7AFC2BF75622C_339873029.addTaint(taint);
            throw varF0B669FE625FDCD2C0B7AFC2BF75622C_339873029;
        } //End block
        Class<?> localClass = classDesc.forClass();
    if(localClass != null)        
        {
            registerObjectRead(localClass, nextHandle(), unshared);
        } //End block
Class<?> var0C65C20E72071ADD9DC54213330F27FA_1943451547 =         localClass;
        var0C65C20E72071ADD9DC54213330F27FA_1943451547.addTaint(taint);
        return var0C65C20E72071ADD9DC54213330F27FA_1943451547;
        // ---------- Original Method ----------
        //ObjectStreamClass classDesc = readClassDesc();
        //if (classDesc == null) {
            //throw missingClassDescriptor();
        //}
        //Class<?> localClass = classDesc.forClass();
        //if (localClass != null) {
            //registerObjectRead(localClass, nextHandle(), unshared);
        //}
        //return localClass;
    }

    /*
     * read class type for Enum, note there's difference between enum and normal
     * classes
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.443 -0500", hash_original_method = "D16FAEE9BB99888884BA2510B9D0161D", hash_generated_method = "CEE6890D84ABE2946EDB8766727D4D10")
    
private ObjectStreamClass readEnumDesc() throws IOException,
            ClassNotFoundException {
        byte tc = nextTC();
        switch (tc) {
            case TC_CLASSDESC:
                return readEnumDescInternal();
            case TC_REFERENCE:
                return (ObjectStreamClass) readCyclicReference();
            case TC_NULL:
                return null;
            default:
                throw corruptStream(tc);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.446 -0500", hash_original_method = "58EE21B582EE01373F973D50B42B8A60", hash_generated_method = "7C2D5971BE72A4A5BF0C8F0ED397DF7B")
    
private ObjectStreamClass readEnumDescInternal() throws IOException, ClassNotFoundException {
        ObjectStreamClass classDesc;
        primitiveData = input;
        int oldHandle = descriptorHandle;
        descriptorHandle = nextHandle();
        classDesc = readClassDescriptor();
        registerObjectRead(classDesc, descriptorHandle, false);
        descriptorHandle = oldHandle;
        primitiveData = emptyStream;
        classDesc.setClass(resolveClass(classDesc));
        // Consume unread class annotation data and TC_ENDBLOCKDATA
        discardData();
        ObjectStreamClass superClass = readClassDesc();
        checkedSetSuperClassDesc(classDesc, superClass);
        // Check SUIDs, note all SUID for Enum is 0L
        if (0L != classDesc.getSerialVersionUID() || 0L != superClass.getSerialVersionUID()) {
            throw new InvalidClassException(superClass.getName(),
                    "Incompatible class (SUID): " + superClass + " but expected " + superClass);
        }
        byte tc = nextTC();
        // discard TC_ENDBLOCKDATA after classDesc if any
        if (tc == TC_ENDBLOCKDATA) {
            // read next parent class. For enum, it may be null
            superClass.setSuperclass(readClassDesc());
        } else {
            // not TC_ENDBLOCKDATA, push back for next read
            pushbackTC();
        }
        return classDesc;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.449 -0500", hash_original_method = "0BB1D7ADA0D4FC987B96FE9D538B84F1", hash_generated_method = "3C74295FAF19CB0FD0A294472BF06C2A")
    
@SuppressWarnings("unchecked")// For the Enum.valueOf call
    private Object readEnum(boolean unshared) throws OptionalDataException,
            ClassNotFoundException, IOException {
        // read classdesc for Enum first
        ObjectStreamClass classDesc = readEnumDesc();
        int newHandle = nextHandle();
        // read name after class desc
        String name;
        byte tc = nextTC();
        switch (tc) {
            case TC_REFERENCE:
                if (unshared) {
                    readNewHandle();
                    throw new InvalidObjectException("Unshared read of back reference");
                }
                name = (String) readCyclicReference();
                break;
            case TC_STRING:
                name = (String) readNewString(unshared);
                break;
            default:
                throw corruptStream(tc);
        }

        Enum<?> result = Enum.valueOf((Class) classDesc.forClass(), name);
        registerObjectRead(result, newHandle, unshared);

        return result;
    }

    /**
     * Reads a new class descriptor from the receiver. It is assumed the class
     * descriptor has not been read yet (not a cyclic reference). Return the
     * class descriptor read.
     *
     * @param unshared
     *            read the object unshared
     * @return The {@code ObjectStreamClass} read from the stream.
     *
     * @throws IOException
     *             If an IO exception happened when reading the class
     *             descriptor.
     * @throws ClassNotFoundException
     *             If a class for one of the objects could not be found
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.452 -0500", hash_original_method = "85A17F1C0F9F03F0EE48936822125550", hash_generated_method = "D1BC7B645B2B656BB17B4444AEC2F058")
    
private ObjectStreamClass readNewClassDesc(boolean unshared)
            throws ClassNotFoundException, IOException {
        // So read...() methods can be used by
        // subclasses during readClassDescriptor()
        primitiveData = input;
        int oldHandle = descriptorHandle;
        descriptorHandle = nextHandle();
        ObjectStreamClass newClassDesc = readClassDescriptor();
        registerObjectRead(newClassDesc, descriptorHandle, unshared);
        descriptorHandle = oldHandle;
        primitiveData = emptyStream;

        // We need to map classDesc to class.
        try {
            newClassDesc.setClass(resolveClass(newClassDesc));
            // Check SUIDs & base name of the class
            verifyAndInit(newClassDesc);
        } catch (ClassNotFoundException e) {
            if (mustResolve) {
                throw e;
                // Just continue, the class may not be required
            }
        }

        // Resolve the field signatures using the class loader of the
        // resolved class
        ObjectStreamField[] fields = newClassDesc.getLoadFields();
        fields = (fields == null) ? ObjectStreamClass.NO_FIELDS : fields;
        ClassLoader loader = newClassDesc.forClass() == null ? callerClassLoader
                : newClassDesc.forClass().getClassLoader();
        for (ObjectStreamField element : fields) {
            element.resolve(loader);
        }

        // Consume unread class annotation data and TC_ENDBLOCKDATA
        discardData();
        checkedSetSuperClassDesc(newClassDesc, readClassDesc());
        return newClassDesc;
    }

    /**
     * Reads a new proxy class descriptor from the receiver. It is assumed the
     * proxy class descriptor has not been read yet (not a cyclic reference).
     * Return the proxy class descriptor read.
     *
     * @return The {@code Class} read from the stream.
     *
     * @throws IOException
     *             If an IO exception happened when reading the class
     *             descriptor.
     * @throws ClassNotFoundException
     *             If a class for one of the objects could not be found
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.454 -0500", hash_original_method = "9592596F093477979EA31311F339CD7D", hash_generated_method = "7D4B4EA9EB9808F6B8B6169727E89F38")
    
private Class<?> readNewProxyClassDesc() throws ClassNotFoundException,
            IOException {
        int count = input.readInt();
        String[] interfaceNames = new String[count];
        for (int i = 0; i < count; i++) {
            interfaceNames[i] = input.readUTF();
        }
        Class<?> proxy = resolveProxyClass(interfaceNames);
        // Consume unread class annotation data and TC_ENDBLOCKDATA
        discardData();
        return proxy;
    }

    /**
     * Reads a class descriptor from the source stream.
     *
     * @return the class descriptor read from the source stream.
     * @throws ClassNotFoundException
     *             if a class for one of the objects cannot be found.
     * @throws IOException
     *             if an error occurs while reading from the source stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.457 -0500", hash_original_method = "97948A412F94E7F820143192C44DB303", hash_generated_method = "4135DADA7A11796FDD9F10A5CAAA4C9B")
    
protected ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
        ObjectStreamClass newClassDesc = new ObjectStreamClass();
        String name = input.readUTF();
        if (name.length() == 0) {
            throw new IOException("The stream is corrupted");
        }
        newClassDesc.setName(name);
        newClassDesc.setSerialVersionUID(input.readLong());
        newClassDesc.setFlags(input.readByte());

        /*
         * We must register the class descriptor before reading field
         * descriptors. If called outside of readObject, the descriptorHandle
         * might be unset.
         */
        if (descriptorHandle == -1) {
            descriptorHandle = nextHandle();
        }
        registerObjectRead(newClassDesc, descriptorHandle, false);

        readFieldDescriptors(newClassDesc);
        return newClassDesc;
    }

    /**
     * Creates the proxy class that implements the interfaces specified in
     * {@code interfaceNames}.
     *
     * @param interfaceNames
     *            the interfaces used to create the proxy class.
     * @return the proxy class.
     * @throws ClassNotFoundException
     *             if the proxy class or any of the specified interfaces cannot
     *             be created.
     * @throws IOException
     *             if an error occurs while reading from the source stream.
     * @see ObjectOutputStream#annotateProxyClass(Class)
     */
    @DSComment("Refelction/class loader")
    @DSBan(DSCat.REFLECTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.460 -0500", hash_original_method = "C938C68924527CB04F806429B3BE928F", hash_generated_method = "34A903FE2EF819688809BA89B5D6E5E9")
    
protected Class<?> resolveProxyClass(String[] interfaceNames)
            throws IOException, ClassNotFoundException {
        // TODO: This method is opportunity for performance enhancement
        //       We can cache the classloader and recently used interfaces.
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class<?>[] interfaces = new Class<?>[interfaceNames.length];
        for (int i = 0; i < interfaceNames.length; i++) {
            interfaces[i] = Class.forName(interfaceNames[i], false, loader);
        }
        try {
            return Proxy.getProxyClass(loader, interfaces);
        } catch (IllegalArgumentException e) {
            throw new ClassNotFoundException(e.toString(), e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.462 -0500", hash_original_method = "11D3D467DA55FCE7098C1D9AB901525D", hash_generated_method = "C542D506D4CA9C4FADA8DD2EBB335C0E")
    
private int readNewHandle() throws IOException {
        return input.readInt();
    }

    /**
     * Read a new object from the stream. It is assumed the object has not been
     * loaded yet (not a cyclic reference). Return the object read.
     *
     * If the object implements <code>Externalizable</code> its
     * <code>readExternal</code> is called. Otherwise, all fields described by
     * the class hierarchy are loaded. Each class can define how its declared
     * instance fields are loaded by defining a private method
     * <code>readObject</code>
     *
     * @param unshared
     *            read the object unshared
     * @return the object read
     *
     * @throws IOException
     *             If an IO exception happened when reading the object.
     * @throws OptionalDataException
     *             If optional data could not be found when reading the object
     *             graph
     * @throws ClassNotFoundException
     *             If a class for one of the objects could not be found
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.466 -0500", hash_original_method = "B0A36455F033DD06E1C6357D1966CB2A", hash_generated_method = "6E87096403FFD0C264DB56D2CDB9E847")
    
private Object readNewObject(boolean unshared)
            throws OptionalDataException, ClassNotFoundException, IOException {
        ObjectStreamClass classDesc = readClassDesc();

        if (classDesc == null) {
            throw missingClassDescriptor();
        }

        int newHandle = nextHandle();
        Class<?> objectClass = classDesc.forClass();
        Object result = null;
        Object registeredResult = null;
        if (objectClass != null) {
            // Now we know which class to instantiate and which constructor to
            // run. We are allowed to run the constructor.
            result = classDesc.newInstance(objectClass);
            registerObjectRead(result, newHandle, unshared);
            registeredResult = result;
        } else {
            result = null;
        }

        try {
            // This is how we know what to do in defaultReadObject. And it is
            // also used by defaultReadObject to check if it was called from an
            // invalid place. It also allows readExternal to call
            // defaultReadObject and have it work.
            currentObject = result;
            currentClass = classDesc;

            // If Externalizable, just let the object read itself
            // Note that this value comes from the Stream, and in fact it could be
            // that the classes have been changed so that the info below now
            // conflicts with the newer class
            boolean wasExternalizable = (classDesc.getFlags() & SC_EXTERNALIZABLE) != 0;
            if (wasExternalizable) {
                boolean blockData = (classDesc.getFlags() & SC_BLOCK_DATA) != 0;
                if (!blockData) {
                    primitiveData = input;
                }
                if (mustResolve) {
                    Externalizable extern = (Externalizable) result;
                    extern.readExternal(this);
                }
                if (blockData) {
                    // Similar to readHierarchy. Anything not read by
                    // readExternal has to be consumed here
                    discardData();
                } else {
                    primitiveData = emptyStream;
                }
            } else {
                // If we got here, it is Serializable but not Externalizable.
                // Walk the hierarchy reading each class' slots
                readHierarchy(result, classDesc);
            }
        } finally {
            // Cleanup, needs to run always so that we can later detect invalid
            // calls to defaultReadObject
            currentObject = null;
            currentClass = null;
        }

        if (objectClass != null) {

            if (classDesc.hasMethodReadResolve()){
                Method methodReadResolve = classDesc.getMethodReadResolve();
                try {
                    result = methodReadResolve.invoke(result, (Object[]) null);
                } catch (IllegalAccessException ignored) {
                } catch (InvocationTargetException ite) {
                    Throwable target = ite.getTargetException();
                    if (target instanceof ObjectStreamException) {
                        throw (ObjectStreamException) target;
                    } else if (target instanceof Error) {
                        throw (Error) target;
                    } else {
                        throw (RuntimeException) target;
                    }
                }

            }
        }
        // We get here either if class-based replacement was not needed or if it
        // was needed but produced the same object or if it could not be
        // computed.

        // The object to return is the one we instantiated or a replacement for
        // it
        if (result != null && enableResolve) {
            result = resolveObject(result);
        }
        if (registeredResult != result) {
            registerObjectRead(result, newHandle, unshared);
        }
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.468 -0500", hash_original_method = "C5243F456C3574095BC1BB7FC2411373", hash_generated_method = "58C65402BCE95BB61FE726A25D8ADE29")
    
private InvalidClassException missingClassDescriptor() throws InvalidClassException {
        throw new InvalidClassException("Read null attempting to read class descriptor for object");
    }

    /**
     * Read a string encoded in {@link DataInput modified UTF-8} from the
     * receiver. Return the string read.
     *
     * @param unshared
     *            read the object unshared
     * @return the string just read.
     * @throws IOException
     *             If an IO exception happened when reading the String.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.471 -0500", hash_original_method = "CF984AE9FCCB80A5CA5459E50D42D99D", hash_generated_method = "B0125642BC3A5B08BA4F04D4F98FC258")
    
private Object readNewString(boolean unshared) throws IOException {
        Object result = input.readUTF();
        if (enableResolve) {
            result = resolveObject(result);
        }
        registerObjectRead(result, nextHandle(), unshared);

        return result;
    }

    /**
     * Read a new String in UTF format from the receiver. Return the string
     * read.
     *
     * @param unshared
     *            read the object unshared
     * @return the string just read.
     *
     * @throws IOException
     *             If an IO exception happened when reading the String.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.474 -0500", hash_original_method = "E3603577D9590FDF3626C23DB61D460D", hash_generated_method = "4122514E18275DB27149C98C47E4C47C")
    
private Object readNewLongString(boolean unshared) throws IOException {
        long length = input.readLong();
        Object result = input.decodeUTF((int) length);
        if (enableResolve) {
            result = resolveObject(result);
        }
        registerObjectRead(result, nextHandle(), unshared);

        return result;
    }

    /**
     * Reads the next object from the source stream.
     *
     * @return the object read from the source stream.
     * @throws ClassNotFoundException
     *             if the class of one of the objects in the object graph cannot
     *             be found.
     * @throws IOException
     *             if an error occurs while reading from the source stream.
     * @throws OptionalDataException
     *             if primitive data types were found instead of an object.
     * @see ObjectOutputStream#writeObject(Object)
     */
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.477 -0500", hash_original_method = "D5CBFBA6D0DD1CCB325BD55A2992CB88", hash_generated_method = "8B539A099312D41A4AC5038F6E707F3F")
    
public final Object readObject() throws OptionalDataException,
            ClassNotFoundException, IOException {
        return readObject(false);
    }

    /**
     * Reads the next unshared object from the source stream.
     *
     * @return the new object read.
     * @throws ClassNotFoundException
     *             if the class of one of the objects in the object graph cannot
     *             be found.
     * @throws IOException
     *             if an error occurs while reading from the source stream.
     * @see ObjectOutputStream#writeUnshared
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.479 -0500", hash_original_method = "B5062D634E2B9403462F68486501694A", hash_generated_method = "8B3DC90FB0B404E3B29A4C71658BE04A")
    
public Object readUnshared() throws IOException, ClassNotFoundException {
        return readObject(true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.482 -0500", hash_original_method = "E655B580AAC2F65ED2F044289942F1C0", hash_generated_method = "2B8CE588E975D6E5F56A39CA136191B0")
    
private Object readObject(boolean unshared) throws OptionalDataException,
            ClassNotFoundException, IOException {
        boolean restoreInput = (primitiveData == input);
        if (restoreInput) {
            primitiveData = emptyStream;
        }

        // This is the spec'ed behavior in JDK 1.2. Very bizarre way to allow
        // behavior overriding.
        if (subclassOverridingImplementation && !unshared) {
            return readObjectOverride();
        }

        // If we still had primitive types to read, should we discard them
        // (reset the primitiveTypes stream) or leave as is, so that attempts to
        // read primitive types won't read 'past data' ???
        Object result;
        try {
            // We need this so we can tell when we are returning to the
            // original/outside caller
            if (++nestedLevels == 1) {
                // Remember the caller's class loader
                callerClassLoader = getClosestUserClassLoader();
            }

            result = readNonPrimitiveContent(unshared);
            if (restoreInput) {
                primitiveData = input;
            }
        } finally {
            // We need this so we can tell when we are returning to the
            // original/outside caller
            if (--nestedLevels == 0) {
                // We are going to return to the original caller, perform
                // cleanups.
                // No more need to remember the caller's class loader
                callerClassLoader = null;
            }
        }

        // Done reading this object. Is it time to return to the original
        // caller? If so we need to perform validations first.
        if (nestedLevels == 0 && validations != null) {
            // We are going to return to the original caller. If validation is
            // enabled we need to run them now and then cleanup the validation
            // collection
            try {
                for (InputValidationDesc element : validations) {
                    element.validator.validateObject();
                }
            } finally {
                // Validations have to be renewed, since they are only called
                // from readObject
                validations = null;
            }
        }
        return result;
    }

    /**
     * Method to be overridden by subclasses to read the next object from the
     * source stream.
     *
     * @return the object read from the source stream.
     * @throws ClassNotFoundException
     *             if the class of one of the objects in the object graph cannot
     *             be found.
     * @throws IOException
     *             if an error occurs while reading from the source stream.
     * @throws OptionalDataException
     *             if primitive data types were found instead of an object.
     * @see ObjectOutputStream#writeObjectOverride
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.492 -0500", hash_original_method = "F453836DFC9EEC175FFF65A0C41AF32F", hash_generated_method = "199DE7E46C4F11B2922356F432E81D8A")
    
protected Object readObjectOverride() throws OptionalDataException,
            ClassNotFoundException, IOException {
        if (input == null) {
            return null;
        }
        // Subclasses must override.
        throw new IOException();
    }

    /**
     * Reads a short (16 bit) from the source stream.
     *
     * @return the short value read from the source stream.
     * @throws IOException
     *             if an error occurs while reading from the source stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.494 -0500", hash_original_method = "E1F1666A9CC2BCC43C42662EA935D779", hash_generated_method = "EB0585B1D3FEE5ED16B364C5496B7E86")
    
public short readShort() throws IOException {
        return primitiveTypes.readShort();
    }

    /**
     * Reads and validates the ObjectInputStream header from the source stream.
     *
     * @throws IOException
     *             if an error occurs while reading from the source stream.
     * @throws StreamCorruptedException
     *             if the source stream does not contain readable serialized
     *             objects.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.497 -0500", hash_original_method = "2E049C52CD4079E3EDC13878B612AD59", hash_generated_method = "68B5F4A90E91DDABB86C67731C7E1B4B")
    
protected void readStreamHeader() throws IOException,
            StreamCorruptedException {
        if (input.readShort() == STREAM_MAGIC
                && input.readShort() == STREAM_VERSION) {
            return;
        }
        throw new StreamCorruptedException();
    }

    /**
     * Reads an unsigned byte (8 bit) from the source stream.
     *
     * @return the unsigned byte value read from the source stream packaged in
     *         an integer.
     * @throws EOFException
     *             if the end of the input is reached before the read
     *             request can be satisfied.
     * @throws IOException
     *             if an error occurs while reading from the source stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.499 -0500", hash_original_method = "50996F70792020DA658FB7FFCF1EF910", hash_generated_method = "BAF7F2B2ABD5AC131E4AF0C9AEC88B22")
    
public int readUnsignedByte() throws IOException {
        return primitiveTypes.readUnsignedByte();
    }

    /**
     * Reads an unsigned short (16 bit) from the source stream.
     *
     * @return the unsigned short value read from the source stream packaged in
     *         an integer.
     * @throws EOFException
     *             if the end of the input is reached before the read
     *             request can be satisfied.
     * @throws IOException
     *             if an error occurs while reading from the source stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.501 -0500", hash_original_method = "ABA376385639B6CB8F725C68F1CED979", hash_generated_method = "AF49784520D9CEEEF364EC34713765A6")
    
public int readUnsignedShort() throws IOException {
        return primitiveTypes.readUnsignedShort();
    }

    /**
     * Reads a string encoded in {@link DataInput modified UTF-8} from the
     * source stream.
     *
     * @return the string encoded in {@link DataInput modified UTF-8} read from
     *         the source stream.
     * @throws EOFException
     *             if the end of the input is reached before the read
     *             request can be satisfied.
     * @throws IOException
     *             if an error occurs while reading from the source stream.
     */
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.503 -0500", hash_original_method = "B2994D3A3B821949D517613320FA5065", hash_generated_method = "1EE882612647600C4FE16F9494A0E09D")
    
public String readUTF() throws IOException {
        return primitiveTypes.readUTF();
    }

    /**
     * Returns the previously-read object corresponding to the given serialization handle.
     * @throws InvalidObjectException
     *             If there is no previously-read object with this handle
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.506 -0500", hash_original_method = "10F65D1907C5AA72A1571FB08139A1C8", hash_generated_method = "D1662A9B0C44C85497E57C5698D4F000")
    
private Object registeredObjectRead(int handle) throws InvalidObjectException {
        Object res = objectsRead.get(handle - ObjectStreamConstants.baseWireHandle);
        if (res == UNSHARED_OBJ) {
            throw new InvalidObjectException("Cannot read back reference to unshared object");
        }
        return res;
    }

    /**
     * Associates a read object with the its serialization handle.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.510 -0500", hash_original_method = "9C8641A932863D3A6F3FA22233749F54", hash_generated_method = "EFCAC5EF43DF7C55822558422F259D07")
    
private void registerObjectRead(Object obj, int handle, boolean unshared) throws IOException {
        if (unshared) {
            obj = UNSHARED_OBJ;
        }
        int index = handle - ObjectStreamConstants.baseWireHandle;
        int size = objectsRead.size();
        // ObjectOutputStream sometimes wastes a handle. I've compared hex dumps of the RI
        // and it seems like that's a 'feature'. Look for calls to objectsWritten.put that
        // are guarded by !unshared tests.
        while (index > size) {
            objectsRead.add(null);
            ++size;
        }
        if (index == size) {
            objectsRead.add(obj);
        } else {
            objectsRead.set(index, obj);
        }
    }

    /**
     * Registers a callback for post-deserialization validation of objects. It
     * allows to perform additional consistency checks before the {@code
     * readObject()} method of this class returns its result to the caller. This
     * method can only be called from within the {@code readObject()} method of
     * a class that implements "special" deserialization rules. It can be called
     * multiple times. Validation callbacks are then done in order of decreasing
     * priority, defined by {@code priority}.
     *
     * @param object
     *            an object that can validate itself by receiving a callback.
     * @param priority
     *            the validator's priority.
     * @throws InvalidObjectException
     *             if {@code object} is {@code null}.
     * @throws NotActiveException
     *             if this stream is currently not reading objects. In that
     *             case, calling this method is not allowed.
     * @see ObjectInputValidation#validateObject()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.514 -0500", hash_original_method = "3EFB39BBE791BF6ED902F9D8BC5F60E3", hash_generated_method = "35324DD12773F7B8D9A2AF8C6C609AAB")
    
public synchronized void registerValidation(ObjectInputValidation object,
            int priority) throws NotActiveException, InvalidObjectException {
        // Validation can only be registered when inside readObject calls
        Object instanceBeingRead = this.currentObject;

        if (instanceBeingRead == null && nestedLevels == 0) {
            throw new NotActiveException();
        }
        if (object == null) {
            throw new InvalidObjectException("Callback object cannot be null");
        }
        // From now on it is just insertion in a SortedCollection. Since
        // the Java class libraries don't provide that, we have to
        // implement it from scratch here.
        InputValidationDesc desc = new InputValidationDesc();
        desc.validator = object;
        desc.priority = priority;
        // No need for this, validateObject does not take a parameter
        // desc.toValidate = instanceBeingRead;
        if (validations == null) {
            validations = new InputValidationDesc[1];
            validations[0] = desc;
        } else {
            int i = 0;
            for (; i < validations.length; i++) {
                InputValidationDesc validation = validations[i];
                // Sorted, higher priority first.
                if (priority >= validation.priority) {
                    break; // Found the index where to insert
                }
            }
            InputValidationDesc[] oldValidations = validations;
            int currentSize = oldValidations.length;
            validations = new InputValidationDesc[currentSize + 1];
            System.arraycopy(oldValidations, 0, validations, 0, i);
            System.arraycopy(oldValidations, i, validations, i + 1, currentSize
                    - i);
            validations[i] = desc;
        }
    }

    /**
     * Reset the collection of objects already loaded by the receiver.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.516 -0500", hash_original_method = "7A01BA94C22B82138AACA44C7BC92DD9", hash_generated_method = "9637698182A1DE74F963CA0285A84D9E")
    
private void resetSeenObjects() {
        objectsRead = new ArrayList<Object>();
        nextHandle = baseWireHandle;
        primitiveData = emptyStream;
    }

    /**
     * Reset the receiver. The collection of objects already read by the
     * receiver is reset, and internal structures are also reset so that the
     * receiver knows it is in a fresh clean state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.519 -0500", hash_original_method = "356E50ACB0709EF4643021948AB5F291", hash_generated_method = "499511E6C59EC0BAEB750E8738BE3DE7")
    
private void resetState() {
        resetSeenObjects();
        hasPushbackTC = false;
        pushbackTC = 0;
        // nestedLevels = 0;
    }
    
    static class InputValidationDesc {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.284 -0500", hash_original_field = "59BAC1D70D65173C0176BF76148E5AB7", hash_generated_field = "59BAC1D70D65173C0176BF76148E5AB7")

        ObjectInputValidation validator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.286 -0500", hash_original_field = "4AD9F2E37B35E313CD211FBAFDADA238", hash_generated_field = "4AD9F2E37B35E313CD211FBAFDADA238")

        int priority;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.669 -0400", hash_original_method = "9B1F2C1B15D11C4CFF789483FB2B6658", hash_generated_method = "9B1F2C1B15D11C4CFF789483FB2B6658")
        public InputValidationDesc ()
        {
            //Synthesized constructor
        }

    }
    
    public abstract static class GetField {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.669 -0400", hash_original_method = "3E66EA4913058A142DD3D4DCDDDF2758", hash_generated_method = "3E66EA4913058A142DD3D4DCDDDF2758")
        public GetField ()
        {
            //Synthesized constructor
        }
        /**
         * Gets the ObjectStreamClass that describes a field.
         *
         * @return the descriptor class for a serialized field.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.291 -0500", hash_original_method = "B7E1778F8593BF58FDE39FF2FF30A09C", hash_generated_method = "6C622DBCAAB88E7F6ECA3A0771E8E32D")
        
public abstract ObjectStreamClass getObjectStreamClass();

        /**
         * Indicates if the field identified by {@code name} is defaulted. This
         * means that it has no value in this stream.
         *
         * @param name
         *            the name of the field to check.
         * @return {@code true} if the field is defaulted, {@code false}
         *         otherwise.
         * @throws IllegalArgumentException
         *             if {@code name} does not identify a serializable field.
         * @throws IOException
         *             if an error occurs while reading from the source input
         *             stream.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.294 -0500", hash_original_method = "F1E76C74D4B297359C4FDAEA71138684", hash_generated_method = "DC74AF0596963204EE5FA353DFFC8C95")
        
public abstract boolean defaulted(String name) throws IOException,
                IllegalArgumentException;

        /**
         * Gets the value of the boolean field identified by {@code name} from
         * the persistent field.
         *
         * @param name
         *            the name of the field to get.
         * @param defaultValue
         *            the default value that is used if the field does not have
         *            a value when read from the source stream.
         * @return the value of the field identified by {@code name}.
         * @throws IOException
         *             if an error occurs while reading from the source input
         *             stream.
         * @throws IllegalArgumentException
         *             if the type of the field identified by {@code name} is
         *             not {@code boolean}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.297 -0500", hash_original_method = "D72D90B65472FA8825EE585FD8D97385", hash_generated_method = "8D1B8C1CEE2385A4C9F3DD74ED9FF5EF")
        
public abstract boolean get(String name, boolean defaultValue)
                throws IOException, IllegalArgumentException;

        /**
         * Gets the value of the character field identified by {@code name} from
         * the persistent field.
         *
         * @param name
         *            the name of the field to get.
         * @param defaultValue
         *            the default value that is used if the field does not have
         *            a value when read from the source stream.
         * @return the value of the field identified by {@code name}.
         * @throws IOException
         *             if an error occurs while reading from the source input
         *             stream.
         * @throws IllegalArgumentException
         *             if the type of the field identified by {@code name} is
         *             not {@code char}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.299 -0500", hash_original_method = "E155202224603EF6206E6AF14A500B0B", hash_generated_method = "F1AFB87579CC11DFF5E04C4D1FF41A92")
        
public abstract char get(String name, char defaultValue)
                throws IOException, IllegalArgumentException;

        /**
         * Gets the value of the byte field identified by {@code name} from the
         * persistent field.
         *
         * @param name
         *            the name of the field to get.
         * @param defaultValue
         *            the default value that is used if the field does not have
         *            a value when read from the source stream.
         * @return the value of the field identified by {@code name}.
         * @throws IOException
         *             if an error occurs while reading from the source input
         *             stream.
         * @throws IllegalArgumentException
         *             if the type of the field identified by {@code name} is
         *             not {@code byte}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.302 -0500", hash_original_method = "2051EF86255EBDDE5706A869BD42D762", hash_generated_method = "65BCD3067B772175ADE9D10245055D05")
        
public abstract byte get(String name, byte defaultValue)
                throws IOException, IllegalArgumentException;

        /**
         * Gets the value of the short field identified by {@code name} from the
         * persistent field.
         *
         * @param name
         *            the name of the field to get.
         * @param defaultValue
         *            the default value that is used if the field does not have
         *            a value when read from the source stream.
         * @return the value of the field identified by {@code name}.
         * @throws IOException
         *             if an error occurs while reading from the source input
         *             stream.
         * @throws IllegalArgumentException
         *             if the type of the field identified by {@code name} is
         *             not {@code short}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.305 -0500", hash_original_method = "471D592376F4306F4FECBE347E932817", hash_generated_method = "6ABFE5AC80E8872EC2915B1DED475AFF")
        
public abstract short get(String name, short defaultValue)
                throws IOException, IllegalArgumentException;

        /**
         * Gets the value of the integer field identified by {@code name} from
         * the persistent field.
         *
         * @param name
         *            the name of the field to get.
         * @param defaultValue
         *            the default value that is used if the field does not have
         *            a value when read from the source stream.
         * @return the value of the field identified by {@code name}.
         * @throws IOException
         *             if an error occurs while reading from the source input
         *             stream.
         * @throws IllegalArgumentException
         *             if the type of the field identified by {@code name} is
         *             not {@code int}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.307 -0500", hash_original_method = "73A8BECD3164B161A30ECE6C763AD746", hash_generated_method = "A0F02DE73A9246EA04F0AF9AEB0658DE")
        
public abstract int get(String name, int defaultValue)
                throws IOException, IllegalArgumentException;

        /**
         * Gets the value of the long field identified by {@code name} from the
         * persistent field.
         *
         * @param name
         *            the name of the field to get.
         * @param defaultValue
         *            the default value that is used if the field does not have
         *            a value when read from the source stream.
         * @return the value of the field identified by {@code name}.
         * @throws IOException
         *             if an error occurs while reading from the source input
         *             stream.
         * @throws IllegalArgumentException
         *             if the type of the field identified by {@code name} is
         *             not {@code long}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.310 -0500", hash_original_method = "CCA28848BE07DA6EA929BB53A6F26CF9", hash_generated_method = "B3D452B4A97F3A8102A370E6D5B081F9")
        
public abstract long get(String name, long defaultValue)
                throws IOException, IllegalArgumentException;

        /**
         * Gets the value of the float field identified by {@code name} from the
         * persistent field.
         *
         * @param name
         *            the name of the field to get.
         * @param defaultValue
         *            the default value that is used if the field does not have
         *            a value when read from the source stream.
         * @return the value of the field identified by {@code name}.
         * @throws IOException
         *             if an error occurs while reading from the source input
         *             stream.
         * @throws IllegalArgumentException
         *             if the type of the field identified by {@code float} is
         *             not {@code char}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.313 -0500", hash_original_method = "E5BBF24B38F141AC18B8EFC4B2AFEA5E", hash_generated_method = "E5CCDEA7EA2358B61514AEC69B011F92")
        
public abstract float get(String name, float defaultValue)
                throws IOException, IllegalArgumentException;

        /**
         * Gets the value of the double field identified by {@code name} from
         * the persistent field.
         *
         * @param name
         *            the name of the field to get.
         * @param defaultValue
         *            the default value that is used if the field does not have
         *            a value when read from the source stream.
         * @return the value of the field identified by {@code name}.
         * @throws IOException
         *             if an error occurs while reading from the source input
         *             stream.
         * @throws IllegalArgumentException
         *             if the type of the field identified by {@code name} is
         *             not {@code double}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.315 -0500", hash_original_method = "19008D3989B295012C0B95A3F71857C9", hash_generated_method = "114BDC5AA83AC8DCF94B47B065A57844")
        
public abstract double get(String name, double defaultValue)
                throws IOException, IllegalArgumentException;

        /**
         * Gets the value of the object field identified by {@code name} from
         * the persistent field.
         *
         * @param name
         *            the name of the field to get.
         * @param defaultValue
         *            the default value that is used if the field does not have
         *            a value when read from the source stream.
         * @return the value of the field identified by {@code name}.
         * @throws IOException
         *             if an error occurs while reading from the source input
         *             stream.
         * @throws IllegalArgumentException
         *             if the type of the field identified by {@code name} is
         *             not {@code Object}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.318 -0500", hash_original_method = "20F7767B6DCA4E25FBC89E9C4913BEF0", hash_generated_method = "689EF82E856189AF74800B035E5625F7")
        
public abstract Object get(String name, Object defaultValue)
                throws IOException, IllegalArgumentException;
        
    }

    /**
     * Loads the Java class corresponding to the class descriptor {@code
     * osClass} that has just been read from the source stream.
     *
     * @param osClass
     *            an ObjectStreamClass read from the source stream.
     * @return a Class corresponding to the descriptor {@code osClass}.
     * @throws ClassNotFoundException
     *             if the class for an object cannot be found.
     * @throws IOException
     *             if an I/O error occurs while creating the class.
     * @see ObjectOutputStream#annotateClass(Class)
     */
    @DSComment("Refelction/class loader")
    @DSBan(DSCat.REFLECTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.521 -0500", hash_original_method = "38B51F7C504D6211D87B81513F39C956", hash_generated_method = "8BE13CA5FD5F5C0BA8A874380177710B")
    
protected Class<?> resolveClass(ObjectStreamClass osClass)
            throws IOException, ClassNotFoundException {
        // fastpath: obtain cached value
        Class<?> cls = osClass.forClass();
        if (cls == null) {
            // slowpath: resolve the class
            String className = osClass.getName();

            // if it is primitive class, for example, long.class
            cls = PRIMITIVE_CLASSES.get(className);

            if (cls == null) {
                // not primitive class
                // Use the first non-null ClassLoader on the stack. If null, use
                // the system class loader
                cls = Class.forName(className, true, callerClassLoader);
            }
        }
        return cls;
    }

    /**
     * Allows trusted subclasses to substitute the specified original {@code
     * object} with a new object. Object substitution has to be activated first
     * with calling {@code enableResolveObject(true)}. This implementation just
     * returns {@code object}.
     *
     * @param object
     *            the original object for which a replacement may be defined.
     * @return the replacement object for {@code object}.
     * @throws IOException
     *             if any I/O error occurs while creating the replacement
     *             object.
     * @see #enableResolveObject
     * @see ObjectOutputStream#enableReplaceObject
     * @see ObjectOutputStream#replaceObject
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.524 -0500", hash_original_method = "8BE1D9D2C1A8227AC3DEAA12C63F6442", hash_generated_method = "D8D7778E37AE3540E2BF79E3B7FF2928")
    
protected Object resolveObject(Object object) throws IOException {
        // By default no object replacement. Subclasses can override
        return object;
    }
    static {
        PRIMITIVE_CLASSES.put("boolean", boolean.class);
        PRIMITIVE_CLASSES.put("byte", byte.class);
        PRIMITIVE_CLASSES.put("char", char.class);
        PRIMITIVE_CLASSES.put("double", double.class);
        PRIMITIVE_CLASSES.put("float", float.class);
        PRIMITIVE_CLASSES.put("int", int.class);
        PRIMITIVE_CLASSES.put("long", long.class);
        PRIMITIVE_CLASSES.put("short", short.class);
        PRIMITIVE_CLASSES.put("void", void.class);
    }

    /**
     * Skips {@code length} bytes on the source stream. This method should not
     * be used to skip bytes at any arbitrary position, just when reading
     * primitive data types (int, char etc).
     *
     * @param length
     *            the number of bytes to skip.
     * @return the number of bytes actually skipped.
     * @throws IOException
     *             if an error occurs while skipping bytes on the source stream.
     * @throws NullPointerException
     *             if the source stream is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.526 -0500", hash_original_method = "C18A3B861F9E4DC00DB6D8F86113E96E", hash_generated_method = "558D11649F99682EFB8F3D92D5333857")
    
public int skipBytes(int length) throws IOException {
        // To be used with available. Ok to call if reading primitive buffer
        if (input == null) {
            throw new NullPointerException();
        }

        int offset = 0;
        while (offset < length) {
            checkReadPrimitiveTypes();
            long skipped = primitiveData.skip(length - offset);
            if (skipped == 0) {
                return offset;
            }
            offset += (int) skipped;
        }
        return length;
    }

    /**
     * Verify if the SUID & the base name for descriptor
     * <code>loadedStreamClass</code>matches
     * the SUID & the base name of the corresponding loaded class and
     * init private fields.
     *
     * @param loadedStreamClass
     *            An ObjectStreamClass that was loaded from the stream.
     *
     * @throws InvalidClassException
     *             If the SUID of the stream class does not match the VM class
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:43.529 -0500", hash_original_method = "F18AA842F3AF8655FE4F963E8A31A757", hash_generated_method = "C68E7EDA63F6C38BAF24513897F68DD7")
    
private void verifyAndInit(ObjectStreamClass loadedStreamClass)
            throws InvalidClassException {

        Class<?> localClass = loadedStreamClass.forClass();
        ObjectStreamClass localStreamClass = ObjectStreamClass
                .lookupStreamClass(localClass);

        if (loadedStreamClass.getSerialVersionUID() != localStreamClass
                .getSerialVersionUID()) {
            throw new InvalidClassException(loadedStreamClass.getName(),
                    "Incompatible class (SUID): " + loadedStreamClass +
                            " but expected " + localStreamClass);
        }

        String loadedClassBaseName = getBaseName(loadedStreamClass.getName());
        String localClassBaseName = getBaseName(localStreamClass.getName());

        if (!loadedClassBaseName.equals(localClassBaseName)) {
            throw new InvalidClassException(loadedStreamClass.getName(),
                    String.format("Incompatible class (base name): %s but expected %s",
                            loadedClassBaseName, localClassBaseName));
        }

        loadedStreamClass.initPrivateFields(localStreamClass);
    }
}

