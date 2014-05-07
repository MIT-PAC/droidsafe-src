package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.ByteOrder;
import java.nio.charset.ModifiedUtf8;
import java.util.List;

import libcore.io.Memory;
import libcore.io.SizeOf;

public class ObjectOutputStream extends OutputStream implements ObjectOutput, ObjectStreamConstants {
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static Object getFieldL(Object instance, Class<?> declaringClass, String fieldName, String fieldTypeName) {
    	return new Object();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.916 -0500", hash_original_field = "6D678B37997C992735BEA0DA965949BA", hash_generated_field = "EDEC464CFF602399479B5323240F3B9A")

    private static final Class<?>[] WRITE_UNSHARED_PARAM_TYPES = new Class[] { Object.class };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.919 -0500", hash_original_field = "7F7257B6D8C2424391077998CDA8F98C", hash_generated_field = "94B8CE0A3BE191EC240D9518A5C28538")

    private static final byte NOT_SC_BLOCK_DATA = (byte) (SC_BLOCK_DATA ^ 0xFF);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.922 -0500", hash_original_field = "71CE55750109EBB73E2456BE80AD82FD", hash_generated_field = "123C8BF62BBC79B951F58B358976C3FF")

    private int nestedLevels;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.924 -0500", hash_original_field = "2855F0553474A8516BB60C3AB948195B", hash_generated_field = "590E14C0A9F44251F0FB79AFE6C14C40")

    private DataOutputStream output;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.926 -0500", hash_original_field = "EA41DAE3EA3A9463214580744E283D95", hash_generated_field = "F1F4A3D364C39A7A9A580E729A07A6BB")

    private boolean enableReplace;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.929 -0500", hash_original_field = "F50226C4450D15DEB3DAF04AA8DD91E0", hash_generated_field = "6BF0D260FF82B6C05AF71BF5A37B87B5")

    private DataOutputStream primitiveTypes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.931 -0500", hash_original_field = "B345808D8C54A6DE41B064F86D48A94C", hash_generated_field = "C2484DFB497796B6143E78C11005E43D")

    private ByteArrayOutputStream primitiveTypesBuffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.933 -0500", hash_original_field = "6ABD8506E99DA36F288EACCC1D0AEA0D", hash_generated_field = "262F0B6D79DA047EE0A946998A1A0FC4")

    private SerializationHandleMap objectsWritten;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.935 -0500", hash_original_field = "9FE03646F63952E65E01B54C60826991", hash_generated_field = "C5955C97495D41B971B03A33B3C5833F")

    private int currentHandle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.937 -0500", hash_original_field = "42C03588FC817F62832A17907DDFD79F", hash_generated_field = "76736C274255A46E2AEB2CE593A1B428")

    private Object currentObject;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.940 -0500", hash_original_field = "6A61A63E4AD81B568463523E7D82D010", hash_generated_field = "7035F4B44BC3AE389D42445F7A5655AC")

    private ObjectStreamClass currentClass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.942 -0500", hash_original_field = "473298EA5584430267AC431FE5045555", hash_generated_field = "12864838116848C83740597D611280DC")

    private int protocolVersion;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.944 -0500", hash_original_field = "ABFFAED613377BDFDDEDD7269BB487AF", hash_generated_field = "DC52C2D606BFFEEFCE39D0BD7D3DAA23")

    private StreamCorruptedException nestedException;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.946 -0500", hash_original_field = "014E542677EA8E3C6BC341F69FBDBFF6", hash_generated_field = "BAD28CAA59CF68A4E344ADB2A9F8D573")

    private EmulatedFieldsForDumping currentPutField;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.949 -0500", hash_original_field = "78AB9CCAB960E71CE119A2107AA96FD8", hash_generated_field = "3690401F10D38FF2C8AB1C19B641B107")

    private boolean subclassOverridingImplementation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.952 -0500", hash_original_field = "F353EDD7A07A76CACDC598B2AE00874D", hash_generated_field = "A52DE6D705A0478FBD8E858BFAC127CD")

    private final ObjectStreamClass proxyClassDesc = ObjectStreamClass.lookup(Proxy.class);

    /**
     * Constructs a new {@code ObjectOutputStream}. This default constructor can
     * be used by subclasses that do not want to use the public constructor if
     * it allocates unneeded data.
     *
     * @throws IOException
     *             if an error occurs when creating this stream.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.985 -0500", hash_original_method = "EA89A37EA944EE797F4A4E71C06BB807", hash_generated_method = "20201D6142A4F45AD52A1B42A23D1633")
    
protected ObjectOutputStream() throws IOException {
        /*
         * WARNING - we should throw IOException if not called from a subclass
         * according to the JavaDoc. Add the test.
         */
        this.subclassOverridingImplementation = true;
    }

    /**
     * Constructs a new ObjectOutputStream that writes to the OutputStream
     * {@code output}.
     *
     * @param output
     *            the non-null OutputStream to filter writes on.
     *
     * @throws IOException
     *             if an error occurs while writing the object stream
     *             header
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.989 -0500", hash_original_method = "C3742BF53888E5C7E36BAC1682B0BA91", hash_generated_method = "951FD3E615E51932C8B5A8C595B0B848")
    
public ObjectOutputStream(OutputStream output) throws IOException {
        this.output = (output instanceof DataOutputStream) ? (DataOutputStream) output
                : new DataOutputStream(output);
        this.enableReplace = false;
        this.protocolVersion = PROTOCOL_VERSION_2;
        this.subclassOverridingImplementation = false;

        resetState();
        this.nestedException = new StreamCorruptedException();
        // So write...() methods can be used by
        // subclasses during writeStreamHeader()
        primitiveTypes = this.output;
        // Has to be done here according to the specification
        writeStreamHeader();
        primitiveTypes = null;
    }

    /**
     * Writes optional information for class {@code aClass} to the output
     * stream. This optional data can be read when deserializing the class
     * descriptor (ObjectStreamClass) for this class from an input stream. By
     * default, no extra data is saved.
     *
     * @param aClass
     *            the class to annotate.
     * @throws IOException
     *             if an error occurs while writing to the target stream.
     * @see ObjectInputStream#resolveClass(ObjectStreamClass)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.991 -0500", hash_original_method = "2EE844E85177CE8B8519EE788449061C", hash_generated_method = "E662938EE1A3B497D28323D3A8E8F93E")
    
protected void annotateClass(Class<?> aClass) throws IOException {
        // By default no extra info is saved. Subclasses can override
    }

    /**
     * Writes optional information for a proxy class to the target stream. This
     * optional data can be read when deserializing the proxy class from an
     * input stream. By default, no extra data is saved.
     *
     * @param aClass
     *            the proxy class to annotate.
     * @throws IOException
     *             if an error occurs while writing to the target stream.
     * @see ObjectInputStream#resolveProxyClass(String[])
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.994 -0500", hash_original_method = "6D36FCC856EE4705ED65F6105201ADD2", hash_generated_method = "CF16920BE63D675EC370DF7716E85BA2")
    
protected void annotateProxyClass(Class<?> aClass) throws IOException {
        // By default no extra info is saved. Subclasses can override
    }

    /**
     * Do the necessary work to see if the receiver can be used to write
     * primitive types like int, char, etc.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.996 -0500", hash_original_method = "73D4A72122980F7DB50B81D978D62054", hash_generated_method = "2F1C9599127953E750BC0EC19183EDEB")
    
private void checkWritePrimitiveTypes() {
        if (primitiveTypes == null) {
            // If we got here we have no Stream previously created
            // WARNING - if the stream does not grow, this code is wrong
            primitiveTypesBuffer = new ByteArrayOutputStream(128);
            primitiveTypes = new DataOutputStream(primitiveTypesBuffer);
        }
    }

    /**
     * Closes this stream. Any buffered data is flushed. This implementation
     * closes the target stream.
     *
     * @throws IOException
     *             if an error occurs while closing this stream.
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.999 -0500", hash_original_method = "29115934C3EAEF8AC600D579304D0581", hash_generated_method = "8754A565F8570BE362F125849A8954C1")
    
@Override
    public void close() throws IOException {
        // First flush what is needed (primitive data, etc)
        flush();
        output.close();
    }

    /**
     * Computes the collection of emulated fields that users can manipulate to
     * store a representation different than the one declared by the class of
     * the object being dumped.
     *
     * @see #writeFields
     * @see #writeFieldValues(EmulatedFieldsForDumping)
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.001 -0500", hash_original_method = "75FABBE0CA8F03B34490087B8F17BDC1", hash_generated_method = "F678F7495D32EE6D68B575867F8261E9")
    
private void computePutField() {
        currentPutField = new EmulatedFieldsForDumping(this, currentClass);
    }

    /**
     * Default method to write objects to this stream. Serializable fields
     * defined in the object's class and superclasses are written to the output
     * stream.
     *
     * @throws IOException
     *             if an error occurs while writing to the target stream.
     * @throws NotActiveException
     *             if this method is not called from {@code writeObject()}.
     * @see ObjectInputStream#defaultReadObject
     */
    @DSComment("I/O load/store")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.003 -0500", hash_original_method = "F6C293AC5437F7F079C554EABDD8D443", hash_generated_method = "DB15EE34976D43748FFB1795F8CC6575")
    
public void defaultWriteObject() throws IOException {
        if (currentObject == null) {
            throw new NotActiveException();
        }
        writeFieldValues(currentObject, currentClass);
    }

    /**
     * Writes buffered data to the target stream. This is similar to {@code
     * flush} but the flush is not propagated to the target stream.
     *
     * @throws IOException
     *             if an error occurs while writing to the target stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.006 -0500", hash_original_method = "A89FD6C60365B1028CEBCCFC3106EF9A", hash_generated_method = "CD210D47F9432627FD5EBAF140E81828")
    
protected void drain() throws IOException {
        if (primitiveTypes == null || primitiveTypesBuffer == null) {
            return;
        }

        // If we got here we have a Stream previously created
        int offset = 0;
        byte[] written = primitiveTypesBuffer.toByteArray();
        // Normalize the primitive data
        while (offset < written.length) {
            int toWrite = written.length - offset > 1024 ? 1024
                    : written.length - offset;
            if (toWrite < 256) {
                output.writeByte(TC_BLOCKDATA);
                output.writeByte((byte) toWrite);
            } else {
                output.writeByte(TC_BLOCKDATALONG);
                output.writeInt(toWrite);
            }

            // write primitive types we had and the marker of end-of-buffer
            output.write(written, offset, toWrite);
            offset += toWrite;
        }

        // and now we're clean to a state where we can write an object
        primitiveTypes = null;
        primitiveTypesBuffer = null;
    }

    /**
     * Dumps the parameter {@code obj} only if it is {@code null}
     * or an object that has already been dumped previously.
     *
     * @param obj
     *            Object to check if an instance previously dumped by this
     *            stream.
     * @return -1 if it is an instance which has not been dumped yet (and this
     *         method does nothing). The handle if {@code obj} is an
     *         instance which has been dumped already.
     *
     * @throws IOException
     *             If an error occurs attempting to save {@code null} or
     *             a cyclic reference.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.008 -0500", hash_original_method = "3C81D15CCFEF1BE19C0E53EB7F3B0380", hash_generated_method = "E76FEAE3E540063408EA71EE3DC4EE79")
    
private int dumpCycle(Object obj) throws IOException {
        // If the object has been saved already, save its handle only
        int handle = objectsWritten.get(obj);
        if (handle != -1) {
            writeCyclicReference(handle);
            return handle;
        }
        return -1;
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
     * @see #replaceObject
     * @see ObjectInputStream#enableResolveObject
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.011 -0500", hash_original_method = "7186A696463687F53D4FA37D2BB9631D", hash_generated_method = "C364514C3E192BD94155F54CC0692460")
    
protected boolean enableReplaceObject(boolean enable) {
        boolean originalValue = enableReplace;
        enableReplace = enable;
        return originalValue;
    }

    /**
     * Writes buffered data to the target stream and calls the {@code flush}
     * method of the target stream.
     *
     * @throws IOException
     *             if an error occurs while writing to or flushing the output
     *             stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.013 -0500", hash_original_method = "117A95892DAF31A0926F2E917E5208CF", hash_generated_method = "133BE7A601CE39FEA947C8DB1F698213")
    
@Override
    public void flush() throws IOException {
        drain();
        output.flush();
    }

    /**
     * Return the next handle to be used to indicate cyclic
     * references being saved to the stream.
     *
     * @return the next handle to represent the next cyclic reference
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.021 -0500", hash_original_method = "3E8C44E06770B18C136965DDB10C163B", hash_generated_method = "ADE9A862360E55137AC5DB20D13240EE")
    
private int nextHandle() {
        return currentHandle++;
    }

    /**
     * Gets this stream's {@code PutField} object. This object provides access
     * to the persistent fields that are eventually written to the output
     * stream. It is used to transfer the values from the fields of the object
     * that is currently being written to the persistent fields.
     *
     * @return the PutField object from which persistent fields can be accessed
     *         by name.
     * @throws IOException
     *             if an I/O error occurs.
     * @throws NotActiveException
     *             if this method is not called from {@code writeObject()}.
     * @see ObjectInputStream#defaultReadObject
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.023 -0500", hash_original_method = "4F3CF2DA9583C39D0A0D02BEFFFE8C29", hash_generated_method = "5B804A30B4756F7E9BAADCADFCEC7BC4")
    
public PutField putFields() throws IOException {
        if (currentObject == null) {
            throw new NotActiveException();
        }
        if (currentPutField == null) {
            computePutField();
        }
        return currentPutField;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.025 -0500", hash_original_method = "6CA6FC4D83D22ECC70837B9572B0E8EA", hash_generated_method = "595E1CC0C74AE5C25102927A0B177589")
    
private int registerObjectWritten(Object obj) {
        int handle = nextHandle();
        objectsWritten.put(obj, handle);
        return handle;
    }

    /**
     * Remove the unshared object from the table, and restore any previous
     * handle.
     *
     * @param obj
     *            Non-null object being dumped.
     * @param previousHandle
     *            The handle of the previous identical object dumped
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.028 -0500", hash_original_method = "37FD060D4B2DB7C3EC8F52EA51C77D72", hash_generated_method = "F3EEDD6F59E86AC74EA08641023D1986")
    
private void removeUnsharedReference(Object obj, int previousHandle) {
        if (previousHandle != -1) {
            objectsWritten.put(obj, previousHandle);
        } else {
            objectsWritten.remove(obj);
        }
    }

    /**
     * Allows trusted subclasses to substitute the specified original {@code
     * object} with a new object. Object substitution has to be activated first
     * with calling {@code enableReplaceObject(true)}. This implementation just
     * returns {@code object}.
     *
     * @param object
     *            the original object for which a replacement may be defined.
     * @return the replacement object for {@code object}.
     * @throws IOException
     *             if any I/O error occurs while creating the replacement
     *             object.
     * @see #enableReplaceObject
     * @see ObjectInputStream#enableResolveObject
     * @see ObjectInputStream#resolveObject
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.030 -0500", hash_original_method = "C1DF94E02684AF79BBD267850463E92A", hash_generated_method = "11919EBF1AC3EF3451B4D3A963F1C4FE")
    
protected Object replaceObject(Object object) throws IOException {
        // By default no object replacement. Subclasses can override
        return object;
    }

    /**
     * Resets the state of this stream. A marker is written to the stream, so
     * that the corresponding input stream will also perform a reset at the same
     * point. Objects previously written are no longer remembered, so they will
     * be written again (instead of a cyclical reference) if found in the object
     * graph.
     *
     * @throws IOException
     *             if {@code reset()} is called during the serialization of an
     *             object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.033 -0500", hash_original_method = "4FDA9D292F9CB60FE54E9147043F29DF", hash_generated_method = "4431441FA79FA4403373900DAB21D756")
    
public void reset() throws IOException {
        // First we flush what we have
        drain();
        /*
         * And dump a reset marker, so that the ObjectInputStream can reset
         * itself at the same point
         */
        output.writeByte(TC_RESET);
        // Now we reset ourselves
        resetState();
    }

    /**
     * Reset the collection of objects already dumped by the receiver. If the
     * objects are found again in the object graph, the receiver will dump them
     * again, instead of a handle (cyclic reference).
     *
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.035 -0500", hash_original_method = "CB42E7CB8763CADF528182B203F4731A", hash_generated_method = "8A4CBC2C2D0258B0B956D5B7564FC1A5")
    
private void resetSeenObjects() {
        objectsWritten = new SerializationHandleMap();
        currentHandle = baseWireHandle;
    }

    /**
     * Reset the receiver. The collection of objects already dumped by the
     * receiver is reset, and internal structures are also reset so that the
     * receiver knows it is in a fresh clean state.
     *
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.037 -0500", hash_original_method = "27ED7D7B38D4C22EF7056E4BAF81440E", hash_generated_method = "401F5A1166683BAD2648FE717213E059")
    
private void resetState() {
        resetSeenObjects();
        nestedLevels = 0;
    }

    /**
     * Sets the specified protocol version to be used by this stream.
     *
     * @param version
     *            the protocol version to be used. Use a {@code
     *            PROTOCOL_VERSION_x} constant from {@code
     *            java.io.ObjectStreamConstants}.
     * @throws IllegalArgumentException
     *             if an invalid {@code version} is specified.
     * @throws IOException
     *             if an I/O error occurs.
     * @see ObjectStreamConstants#PROTOCOL_VERSION_1
     * @see ObjectStreamConstants#PROTOCOL_VERSION_2
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.040 -0500", hash_original_method = "899849124785B3DAA2410A481AC243A4", hash_generated_method = "57E7E1D77037A30D6DDD99D7DF680B7A")
    
public void useProtocolVersion(int version) throws IOException {
        if (!objectsWritten.isEmpty()) {
            throw new IllegalStateException("Cannot set protocol version when stream in use");
        }
        if (version != ObjectStreamConstants.PROTOCOL_VERSION_1
                && version != ObjectStreamConstants.PROTOCOL_VERSION_2) {
            throw new IllegalArgumentException("Unknown protocol: " + version);
        }
        protocolVersion = version;
    }

    /**
     * Writes {@code count} bytes from the byte array {@code buffer} starting at
     * offset {@code index} to the target stream. Blocks until all bytes are
     * written.
     *
     * @param buffer
     *            the buffer to write.
     * @param offset
     *            the index of the first byte in {@code buffer} to write.
     * @param length
     *            the number of bytes from {@code buffer} to write to the output
     *            stream.
     * @throws IOException
     *             if an error occurs while writing to the target stream.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.043 -0500", hash_original_method = "4335176A8BF0CB76C8983C14BE755AB0", hash_generated_method = "2396E7855518FCB39100A578F5EF0B6D")
    
@Override
    public void write(byte[] buffer, int offset, int length) throws IOException {
        checkWritePrimitiveTypes();
        primitiveTypes.write(buffer, offset, length);
    }

    /**
     * Writes a single byte to the target stream. Only the least significant
     * byte of the integer {@code value} is written to the stream. Blocks until
     * the byte is actually written.
     *
     * @param value
     *            the byte to write.
     * @throws IOException
     *             if an error occurs while writing to the target stream.
     */
    @DSComment("Activity on IO class")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSink(DSSinkKind.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.045 -0500", hash_original_method = "890E7ADC76A0934752F791BA928637BD", hash_generated_method = "76EC2FE8B111D6EFD0C5161A9F8E6AE5")
    
@Override
    public void write(int value) throws IOException {
        checkWritePrimitiveTypes();
        primitiveTypes.write(value);
    }

    /**
     * Writes a boolean to the target stream.
     *
     * @param value
     *            the boolean value to write to the target stream.
     * @throws IOException
     *             if an error occurs while writing to the target stream.
     */
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.047 -0500", hash_original_method = "253E21281D84BB4AEC7BC00A39E22928", hash_generated_method = "029F21A115C14D88BF09E962FA8E82B1")
    
public void writeBoolean(boolean value) throws IOException {
        checkWritePrimitiveTypes();
        primitiveTypes.writeBoolean(value);
    }

    /**
     * Writes a byte (8 bit) to the target stream.
     *
     * @param value
     *            the byte to write to the target stream.
     * @throws IOException
     *             if an error occurs while writing to the target stream.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.049 -0500", hash_original_method = "DCBF5513EE5F9BB37CF570D282A66C5E", hash_generated_method = "B50D824F31325598242CF2A68080FEDA")
    
public void writeByte(int value) throws IOException {
        checkWritePrimitiveTypes();
        primitiveTypes.writeByte(value);
    }

    /**
     * Writes the string {@code value} as a sequence of bytes to the target
     * stream. Only the least significant byte of each character in the string
     * is written.
     *
     * @param value
     *            the string to write to the target stream.
     * @throws IOException
     *             if an error occurs while writing to the target stream.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.052 -0500", hash_original_method = "2FD9E25E34EBC831C98FBB1774A09056", hash_generated_method = "3FC5B8F8F72A713B2C0960DBC8B0282B")
    
public void writeBytes(String value) throws IOException {
        checkWritePrimitiveTypes();
        primitiveTypes.writeBytes(value);
    }

    /**
     * Writes a character (16 bit) to the target stream.
     *
     * @param value
     *            the character to write to the target stream.
     * @throws IOException
     *             if an error occurs while writing to the target stream.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.054 -0500", hash_original_method = "A70BC61472A0A40B7DA1B300459E269C", hash_generated_method = "3194C3B1826DCE69B6DA63887D9F90F5")
    
public void writeChar(int value) throws IOException {
        checkWritePrimitiveTypes();
        primitiveTypes.writeChar(value);
    }

    /**
     * Writes the string {@code value} as a sequence of characters to the target
     * stream.
     *
     * @param value
     *            the string to write to the target stream.
     * @throws IOException
     *             if an error occurs while writing to the target stream.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.057 -0500", hash_original_method = "2819E1113D5EFA42F2CF8A185C5FE232", hash_generated_method = "B8C53EDFE2427B81C0D7CC5F8B84A55F")
    
public void writeChars(String value) throws IOException {
        checkWritePrimitiveTypes();
        primitiveTypes.writeChars(value);
    }

    /**
     * Write a class descriptor {@code classDesc} (an
     * {@code ObjectStreamClass}) to the stream.
     *
     * @param classDesc
     *            The class descriptor (an {@code ObjectStreamClass}) to
     *            be dumped
     * @param unshared
     *            Write the object unshared
     * @return the handle assigned to the class descriptor
     *
     * @throws IOException
     *             If an IO exception happened when writing the class
     *             descriptor.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.061 -0500", hash_original_method = "D6DF6A35D187C3B8A220F04225A24DB7", hash_generated_method = "799C91B9EC343E3F85239B2925693FE3")
    
private int writeClassDesc(ObjectStreamClass classDesc, boolean unshared) throws IOException {
        if (classDesc == null) {
            writeNull();
            return -1;
        }
        int handle = -1;
        if (!unshared) {
            handle = dumpCycle(classDesc);
        }
        if (handle == -1) {
            Class<?> classToWrite = classDesc.forClass();
            int previousHandle = -1;
            if (unshared) {
                previousHandle = objectsWritten.get(classDesc);
            }
            // If we got here, it is a new (non-null) classDesc that will have
            // to be registered as well
            handle = registerObjectWritten(classDesc);

            if (classDesc.isProxy()) {
                output.writeByte(TC_PROXYCLASSDESC);
                Class<?>[] interfaces = classToWrite.getInterfaces();
                output.writeInt(interfaces.length);
                for (int i = 0; i < interfaces.length; i++) {
                    output.writeUTF(interfaces[i].getName());
                }
                annotateProxyClass(classToWrite);
                output.writeByte(TC_ENDBLOCKDATA);
                writeClassDesc(proxyClassDesc, false);
                if (unshared) {
                    // remove reference to unshared object
                    removeUnsharedReference(classDesc, previousHandle);
                }
                return handle;
            }

            output.writeByte(TC_CLASSDESC);
            if (protocolVersion == PROTOCOL_VERSION_1) {
                writeNewClassDesc(classDesc);
            } else {
                // So write...() methods can be used by
                // subclasses during writeClassDescriptor()
                primitiveTypes = output;
                writeClassDescriptor(classDesc);
                primitiveTypes = null;
            }
            // Extra class info (optional)
            annotateClass(classToWrite);
            drain(); // flush primitive types in the annotation
            output.writeByte(TC_ENDBLOCKDATA);
            writeClassDesc(classDesc.getSuperclass(), unshared);
            if (unshared) {
                // remove reference to unshared object
                removeUnsharedReference(classDesc, previousHandle);
            }
        }
        return handle;
    }

    /**
     * Writes a handle representing a cyclic reference (object previously
     * dumped).
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.063 -0500", hash_original_method = "6CD4D6A26A6EE5C2333CE9BAD2D29100", hash_generated_method = "681B800BE2C4C367C7E7CFF772D1CB6D")
    
private void writeCyclicReference(int handle) throws IOException {
        output.writeByte(TC_REFERENCE);
        output.writeInt(handle);
    }

    /**
     * Writes a double (64 bit) to the target stream.
     *
     * @param value
     *            the double to write to the target stream.
     * @throws IOException
     *             if an error occurs while writing to the target stream.
     */
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.065 -0500", hash_original_method = "02DC35912BAFF16550D8FBDB82DDCD50", hash_generated_method = "B0839B5ACE77F3E590FC761BCFCBBA2A")
    
public void writeDouble(double value) throws IOException {
        checkWritePrimitiveTypes();
        primitiveTypes.writeDouble(value);
    }

    /**
     * Writes a collection of field descriptors (name, type name, etc) for the
     * class descriptor {@code classDesc} (an
     * {@code ObjectStreamClass})
     *
     * @param classDesc
     *            The class descriptor (an {@code ObjectStreamClass})
     *            for which to write field information
     * @param externalizable
     *            true if the descriptors are externalizable
     *
     * @throws IOException
     *             If an IO exception happened when writing the field
     *             descriptors.
     *
     * @see #writeObject(Object)
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.068 -0500", hash_original_method = "8DAE1373FC5F31DAE45B98A018C14CB9", hash_generated_method = "EA2E9DCCE3A72EA51BE3270C308A06E7")
    
private void writeFieldDescriptors(ObjectStreamClass classDesc, boolean externalizable) throws IOException {
        Class<?> loadedClass = classDesc.forClass();
        ObjectStreamField[] fields = null;
        int fieldCount = 0;

        // The fields of String are not needed since Strings are treated as
        // primitive types
        if (!externalizable && loadedClass != ObjectStreamClass.STRINGCLASS) {
            fields = classDesc.fields();
            fieldCount = fields.length;
        }

        // Field count
        output.writeShort(fieldCount);
        // Field names
        for (int i = 0; i < fieldCount; i++) {
            ObjectStreamField f = fields[i];
            boolean wasPrimitive = f.writeField(output);
            if (!wasPrimitive) {
                writeObject(f.getTypeString());
            }
        }
    }

    /**
     * Writes the fields of the object currently being written to the target
     * stream. The field values are buffered in the currently active {@code
     * PutField} object, which can be accessed by calling {@code putFields()}.
     *
     * @throws IOException
     *             if an error occurs while writing to the target stream.
     * @throws NotActiveException
     *             if there are no fields to write to the target stream.
     * @see #putFields
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.071 -0500", hash_original_method = "851EC9DCB527C64AF85B9AAA86ABFF43", hash_generated_method = "7F9F322E1A455C229D38CE3200B4237A")
    
public void writeFields() throws IOException {
        // Has to have fields to write
        if (currentPutField == null) {
            throw new NotActiveException();
        }
        writeFieldValues(currentPutField);
    }

    /**
     * Writes a collection of field values for the emulated fields
     * {@code emulatedFields}
     *
     * @param emulatedFields
     *            an {@code EmulatedFieldsForDumping}, concrete subclass
     *            of {@code PutField}
     *
     * @throws IOException
     *             If an IO exception happened when writing the field values.
     *
     * @see #writeFields
     * @see #writeObject(Object)
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.074 -0500", hash_original_method = "97B3D4C0A2A3E17C88F2E6B51B15BF4C", hash_generated_method = "5FCEBC6175574B4F2FE309D23F646844")
    
private void writeFieldValues(EmulatedFieldsForDumping emulatedFields) throws IOException {
        // Access internal fields which we can set/get. Users can't do this.
        EmulatedFields accessibleSimulatedFields = emulatedFields.emulatedFields();
        for (EmulatedFields.ObjectSlot slot : accessibleSimulatedFields.slots()) {
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
                writeObject(fieldValue);
            }
        }
    }

    /**
     * Writes a collection of field values for the fields described by class
     * descriptor {@code classDesc} (an {@code ObjectStreamClass}).
     * This is the default mechanism, when emulated fields (an
     * {@code PutField}) are not used. Actual values to dump are fetched
     * directly from object {@code obj}.
     *
     * @param obj
     *            Instance from which to fetch field values to dump.
     * @param classDesc
     *            A class descriptor (an {@code ObjectStreamClass})
     *            defining which fields should be dumped.
     *
     * @throws IOException
     *             If an IO exception happened when writing the field values.
     *
     * @see #writeObject(Object)
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.077 -0500", hash_original_method = "3B2F054C3660B4FEDDE0689C3B0D847B", hash_generated_method = "F2C9D62B715F9CBA4A4AD1678D135095")
    
private void writeFieldValues(Object obj, ObjectStreamClass classDesc) throws IOException {
        for (ObjectStreamField fieldDesc : classDesc.fields()) {
            try {
                Class<?> type = fieldDesc.getTypeInternal();
                Field field = classDesc.getReflectionField(fieldDesc);
                if (field == null) {
                    throw new InvalidClassException(classDesc.getName() + " doesn't have a field " + fieldDesc.getName() + " of type " + type);
                }
                if (type == byte.class) {
                    output.writeByte(field.getByte(obj));
                } else if (type == char.class) {
                    output.writeChar(field.getChar(obj));
                } else if (type == double.class) {
                    output.writeDouble(field.getDouble(obj));
                } else if (type == float.class) {
                    output.writeFloat(field.getFloat(obj));
                } else if (type == int.class) {
                    output.writeInt(field.getInt(obj));
                } else if (type == long.class) {
                    output.writeLong(field.getLong(obj));
                } else if (type == short.class) {
                    output.writeShort(field.getShort(obj));
                } else if (type == boolean.class) {
                    output.writeBoolean(field.getBoolean(obj));
                } else {
                    // Reference types (including arrays).
                    Object objField = field.get(obj);
                    if (fieldDesc.isUnshared()) {
                        writeUnshared(objField);
                    } else {
                        writeObject(objField);
                    }
                }
            } catch (IllegalAccessException iae) {
                // ObjectStreamField should have called setAccessible(true).
                throw new AssertionError(iae);
            } catch (NoSuchFieldError nsf) {
                // The user defined serialPersistentFields but did not provide
                // the glue to transfer values in writeObject, so we ended up using
                // the default mechanism but failed to set the emulated field.
                throw new InvalidClassException(classDesc.getName());
            }
        }
    }

    /**
     * Writes a float (32 bit) to the target stream.
     *
     * @param value
     *            the float to write to the target stream.
     * @throws IOException
     *             if an error occurs while writing to the target stream.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.080 -0500", hash_original_method = "2F0CF28A5E4A8655D2779BA683FB03E5", hash_generated_method = "97206FF0F5149E705B689D6DF50FE57D")
    
public void writeFloat(float value) throws IOException {
        checkWritePrimitiveTypes();
        primitiveTypes.writeFloat(value);
    }

    /**
     * Walks the hierarchy of classes described by class descriptor
     * {@code classDesc} and writes the field values corresponding to
     * fields declared by the corresponding class descriptor. The instance to
     * fetch field values from is {@code object}. If the class
     * (corresponding to class descriptor {@code classDesc}) defines
     * private instance method {@code writeObject} it will be used to
     * dump field values.
     *
     * @param object
     *            Instance from which to fetch field values to dump.
     * @param classDesc
     *            A class descriptor (an {@code ObjectStreamClass})
     *            defining which fields should be dumped.
     *
     * @throws IOException
     *             If an IO exception happened when writing the field values in
     *             the hierarchy.
     * @throws NotActiveException
     *             If the given object is not active
     *
     * @see #defaultWriteObject
     * @see #writeObject(Object)
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.084 -0500", hash_original_method = "6C93D0A9BF9141DB46D3843027575223", hash_generated_method = "74E4CF17C29E0267418363D1DF49854B")
    
private void writeHierarchy(Object object, ObjectStreamClass classDesc)
            throws IOException, NotActiveException {
        if (object == null) {
            throw new NotActiveException();
        }

        // Fields are written from class closest to Object to leaf class
        // (down the chain)
        List<ObjectStreamClass> hierarchy = classDesc.getHierarchy();
        for (int i = 0, end = hierarchy.size(); i < end; ++i) {
            ObjectStreamClass osc = hierarchy.get(i);
            // Have to do this before calling defaultWriteObject or anything
            // that calls defaultWriteObject
            currentObject = object;
            currentClass = osc;

            // See if the object has a writeObject method. If so, run it
            try {
                boolean executed = false;
                if (osc.hasMethodWriteObject()) {
                    final Method method = osc.getMethodWriteObject();
                    try {
                        method.invoke(object, new Object[] { this });
                        executed = true;
                    } catch (InvocationTargetException e) {
                        Throwable ex = e.getTargetException();
                        if (ex instanceof RuntimeException) {
                            throw (RuntimeException) ex;
                        } else if (ex instanceof Error) {
                            throw (Error) ex;
                        }
                        throw (IOException) ex;
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e.toString());
                    }
                }

                if (executed) {
                    drain();
                    output.writeByte(TC_ENDBLOCKDATA);
                } else {
                    // If the object did not have a writeMethod, call
                    // defaultWriteObject
                    defaultWriteObject();
                }
            } finally {
                // Cleanup, needs to run always so that we can later detect
                // invalid calls to defaultWriteObject
                currentObject = null;
                currentClass = null;
                currentPutField = null;
            }
        }
    }

    /**
     * Writes an integer (32 bit) to the target stream.
     *
     * @param value
     *            the integer to write to the target stream.
     * @throws IOException
     *             if an error occurs while writing to the target stream.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.086 -0500", hash_original_method = "4D560E72502C61E130F3258421731401", hash_generated_method = "DB98D19071CCC9064BAB18D4DCD03CE1")
    
public void writeInt(int value) throws IOException {
        checkWritePrimitiveTypes();
        primitiveTypes.writeInt(value);
    }

    /**
     * Writes a long (64 bit) to the target stream.
     *
     * @param value
     *            the long to write to the target stream.
     * @throws IOException
     *             if an error occurs while writing to the target stream.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.089 -0500", hash_original_method = "1C4CA2BE4C70907161A2CF485CB22A3E", hash_generated_method = "159023B26ABF7EB4239CF31CE78EA5AF")
    
public void writeLong(long value) throws IOException {
        checkWritePrimitiveTypes();
        primitiveTypes.writeLong(value);
    }

    /**
     * Write array {@code array} of class {@code arrayClass} with
     * component type {@code componentType} into the receiver. It is
     * assumed the array has not been dumped yet. Returns
     * the handle for this object (array) which is dumped here.
     *
     * @param array
     *            The array object to dump
     * @param arrayClass
     *            A {@code java.lang.Class} representing the class of the
     *            array
     * @param componentType
     *            A {@code java.lang.Class} representing the array
     *            component type
     * @return the handle assigned to the array
     *
     * @throws IOException
     *             If an IO exception happened when writing the array.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.092 -0500", hash_original_method = "6EA4BE49540BA12319B9F5CA997917E6", hash_generated_method = "D80E359BDEF962005DD25D09A9598208")
    
private int writeNewArray(Object array, Class<?> arrayClass, ObjectStreamClass arrayClDesc,
            Class<?> componentType, boolean unshared) throws IOException {
        output.writeByte(TC_ARRAY);
        writeClassDesc(arrayClDesc, false);

        int handle = nextHandle();
        if (!unshared) {
            objectsWritten.put(array, handle);
        }

        // Now we have code duplication just because Java is typed. We have to
        // write N elements and assign to array positions, but we must typecast
        // the array first, and also call different methods depending on the
        // elements.

        if (componentType.isPrimitive()) {
            if (componentType == int.class) {
                int[] intArray = (int[]) array;
                output.writeInt(intArray.length);
                for (int i = 0; i < intArray.length; i++) {
                    output.writeInt(intArray[i]);
                }
            } else if (componentType == byte.class) {
                byte[] byteArray = (byte[]) array;
                output.writeInt(byteArray.length);
                output.write(byteArray, 0, byteArray.length);
            } else if (componentType == char.class) {
                char[] charArray = (char[]) array;
                output.writeInt(charArray.length);
                for (int i = 0; i < charArray.length; i++) {
                    output.writeChar(charArray[i]);
                }
            } else if (componentType == short.class) {
                short[] shortArray = (short[]) array;
                output.writeInt(shortArray.length);
                for (int i = 0; i < shortArray.length; i++) {
                    output.writeShort(shortArray[i]);
                }
            } else if (componentType == boolean.class) {
                boolean[] booleanArray = (boolean[]) array;
                output.writeInt(booleanArray.length);
                for (int i = 0; i < booleanArray.length; i++) {
                    output.writeBoolean(booleanArray[i]);
                }
            } else if (componentType == long.class) {
                long[] longArray = (long[]) array;
                output.writeInt(longArray.length);
                for (int i = 0; i < longArray.length; i++) {
                    output.writeLong(longArray[i]);
                }
            } else if (componentType == float.class) {
                float[] floatArray = (float[]) array;
                output.writeInt(floatArray.length);
                for (int i = 0; i < floatArray.length; i++) {
                    output.writeFloat(floatArray[i]);
                }
            } else if (componentType == double.class) {
                double[] doubleArray = (double[]) array;
                output.writeInt(doubleArray.length);
                for (int i = 0; i < doubleArray.length; i++) {
                    output.writeDouble(doubleArray[i]);
                }
            } else {
                throw new InvalidClassException("Wrong base type in " + arrayClass.getName());
            }
        } else {
            // Array of Objects
            Object[] objectArray = (Object[]) array;
            output.writeInt(objectArray.length);
            for (int i = 0; i < objectArray.length; i++) {
                // TODO: This place is the opportunity for enhancement
                //      We can implement writing elements through fast-path,
                //      without setting up the context (see writeObject()) for
                //      each element with public API
                writeObject(objectArray[i]);
            }
        }
        return handle;
    }

    /**
     * Write class {@code object} into the receiver. It is assumed the
     * class has not been dumped yet. Classes are not really dumped, but a class
     * descriptor ({@code ObjectStreamClass}) that corresponds to them.
     * Returns the handle for this object (class) which is dumped here.
     *
     * @param object
     *            The {@code java.lang.Class} object to dump
     * @return the handle assigned to the class being dumped
     *
     * @throws IOException
     *             If an IO exception happened when writing the class.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.095 -0500", hash_original_method = "EFEEB16087FF4E0EE92685A5C26C0D2A", hash_generated_method = "11AD60B7E0E9DA9AF48A09450772E69D")
    
private int writeNewClass(Class<?> object, boolean unshared) throws IOException {
        output.writeByte(TC_CLASS);

        // Instances of java.lang.Class are always Serializable, even if their
        // instances aren't (e.g. java.lang.Object.class).
        // We cannot call lookup because it returns null if the parameter
        // represents instances that cannot be serialized, and that is not what
        // we want.
        ObjectStreamClass clDesc = ObjectStreamClass.lookupStreamClass(object);

        // The handle for the classDesc is NOT the handle for the class object
        // being dumped. We must allocate a new handle and return it.
        if (clDesc.isEnum()) {
            writeEnumDesc(object, clDesc, unshared);
        } else {
            writeClassDesc(clDesc, unshared);
        }

        int handle = nextHandle();
        if (!unshared) {
            objectsWritten.put(object, handle);
        }

        return handle;
    }

    /**
     * Write class descriptor {@code classDesc} into the receiver. It is
     * assumed the class descriptor has not been dumped yet. The class
     * descriptors for the superclass chain will be dumped as well. Returns
     * the handle for this object (class descriptor) which is dumped here.
     *
     * @param classDesc
     *            The {@code ObjectStreamClass} object to dump
     *
     * @throws IOException
     *             If an IO exception happened when writing the class
     *             descriptor.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.098 -0500", hash_original_method = "8ED9B25450E87C39655806C7FB3946F8", hash_generated_method = "185422283A198BA0E9DC523EDB86FDE1")
    
private void writeNewClassDesc(ObjectStreamClass classDesc)
            throws IOException {
        output.writeUTF(classDesc.getName());
        output.writeLong(classDesc.getSerialVersionUID());
        byte flags = classDesc.getFlags();

        boolean externalizable = classDesc.isExternalizable();

        if (externalizable) {
            if (protocolVersion == PROTOCOL_VERSION_1) {
                flags &= NOT_SC_BLOCK_DATA;
            } else {
                // Change for 1.2. Objects can be saved in old format
                // (PROTOCOL_VERSION_1) or in the 1.2 format (PROTOCOL_VERSION_2).
                flags |= SC_BLOCK_DATA;
            }
        }
        output.writeByte(flags);
        if ((SC_ENUM | SC_SERIALIZABLE) != classDesc.getFlags()) {
            writeFieldDescriptors(classDesc, externalizable);
        } else {
            // enum write no fields
            output.writeShort(0);
        }
    }

    /**
     * Writes a class descriptor to the target stream.
     *
     * @param classDesc
     *            the class descriptor to write to the target stream.
     * @throws IOException
     *             if an error occurs while writing to the target stream.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.101 -0500", hash_original_method = "641338D73905B8D6D3FE171A8894AADC", hash_generated_method = "9B1C0A79BFA0C4084EB7D72A72E7C5EC")
    
protected void writeClassDescriptor(ObjectStreamClass classDesc)
            throws IOException {
        writeNewClassDesc(classDesc);
    }

    /**
     * Write exception {@code ex} into the receiver. It is assumed the
     * exception has not been dumped yet. Returns
     * the handle for this object (exception) which is dumped here.
     * This is used to dump the exception instance that happened (if any) when
     * dumping the original object graph. The set of seen objects will be reset
     * just before and just after dumping this exception object.
     *
     * When exceptions are found normally in the object graph, they are dumped
     * as a regular object, and not by this method. In that case, the set of
     * "known objects" is not reset.
     *
     * @param ex
     *            Exception object to dump
     *
     * @throws IOException
     *             If an IO exception happened when writing the exception
     *             object.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.103 -0500", hash_original_method = "E088B51B3D25E92C7A08790C12EA9546", hash_generated_method = "54C1A98814C60E8C5F754CD30EED532C")
    
private void writeNewException(Exception ex) throws IOException {
        output.writeByte(TC_EXCEPTION);
        resetSeenObjects();
        writeObjectInternal(ex, false, false, false); // No replacements
        resetSeenObjects();
    }

    /**
     * Write object {@code object} of class {@code theClass} into
     * the receiver. It is assumed the object has not been dumped yet.
     * Return the handle for this object which
     * is dumped here.
     *
     * If the object implements {@code Externalizable} its
     * {@code writeExternal} is called. Otherwise, all fields described
     * by the class hierarchy is dumped. Each class can define how its declared
     * instance fields are dumped by defining a private method
     * {@code writeObject}
     *
     * @param object
     *            The object to dump
     * @param theClass
     *            A {@code java.lang.Class} representing the class of the
     *            object
     * @param unshared
     *            Write the object unshared
     * @return the handle assigned to the object
     *
     * @throws IOException
     *             If an IO exception happened when writing the object.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.106 -0500", hash_original_method = "AD17E67664AB2CFE5D575A9D2DBC90D0", hash_generated_method = "6C44F521E14CD6D680627A624B1A6196")
    
private int writeNewObject(Object object, Class<?> theClass, ObjectStreamClass clDesc,
            boolean unshared) throws IOException {
        // Not String, not null, not array, not cyclic reference

        EmulatedFieldsForDumping originalCurrentPutField = currentPutField; // save
        currentPutField = null; // null it, to make sure one will be computed if
        // needed

        boolean externalizable = clDesc.isExternalizable();
        boolean serializable = clDesc.isSerializable();
        if (!externalizable && !serializable) {
            // Object is neither externalizable nor serializable. Error
            throw new NotSerializableException(theClass.getName());
        }

        // Either serializable or externalizable, now we can save info
        output.writeByte(TC_OBJECT);
        writeClassDesc(clDesc, false);
        int previousHandle = -1;
        if (unshared) {
            previousHandle = objectsWritten.get(object);
        }

        int handle = registerObjectWritten(object);

        // This is how we know what to do in defaultWriteObject. And it is also
        // used by defaultWriteObject to check if it was called from an invalid
        // place.
        // It allows writeExternal to call defaultWriteObject and have it work.
        currentObject = object;
        currentClass = clDesc;
        try {
            if (externalizable) {
                boolean noBlockData = protocolVersion == PROTOCOL_VERSION_1;
                if (noBlockData) {
                    primitiveTypes = output;
                }
                // Object is externalizable, just call its own method
                ((Externalizable) object).writeExternal(this);
                if (noBlockData) {
                    primitiveTypes = null;
                } else {
                    // Similar to the code in writeHierarchy when object
                    // implements writeObject.
                    // Any primitive data has to be flushed and a tag must be
                    // written
                    drain();
                    output.writeByte(TC_ENDBLOCKDATA);
                }
            } else { // If it got here, it has to be Serializable
                // Object is serializable. Walk the class chain writing the
                // fields
                writeHierarchy(object, currentClass);
            }
        } finally {
            // Cleanup, needs to run always so that we can later detect invalid
            // calls to defaultWriteObject
            if (unshared) {
                // remove reference to unshared object
                removeUnsharedReference(object, previousHandle);
            }
            currentObject = null;
            currentClass = null;
            currentPutField = originalCurrentPutField;
        }

        return handle;
    }

    /**
     * Write String {@code object} into the receiver. It is assumed the
     * String has not been dumped yet. Returns the handle for this object (String) which is dumped here.
     * Strings are saved encoded with {@link DataInput modified UTF-8}.
     *
     * @param object
     *            the string to dump.
     * @return the handle assigned to the String being dumped
     *
     * @throws IOException
     *             If an IO exception happened when writing the String.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.109 -0500", hash_original_method = "BE97C7FA5FB694719D79A72C051D442C", hash_generated_method = "CD49258FB0912708F891AF64058A753C")
    
private int writeNewString(String object, boolean unshared) throws IOException {
        long count = ModifiedUtf8.countBytes(object, false);
        byte[] buffer;
        int offset = 0;
        if (count <= 0xffff) {
            buffer = new byte[1 + SizeOf.SHORT + (int) count];
            buffer[offset++] = TC_STRING;
            Memory.pokeShort(buffer, offset, (short) count, ByteOrder.BIG_ENDIAN);
            offset += SizeOf.SHORT;
        } else {
            buffer = new byte[1 + SizeOf.LONG + (int) count];
            buffer[offset++] = TC_LONGSTRING;
            Memory.pokeLong(buffer, offset, count, ByteOrder.BIG_ENDIAN);
            offset += SizeOf.LONG;
        }
        ModifiedUtf8.encode(buffer, offset, object);
        output.write(buffer, 0, buffer.length);

        int handle = nextHandle();
        if (!unshared) {
            objectsWritten.put(object, handle);
        }

        return handle;
    }

    /**
     * Write a special tag that indicates the value {@code null} into the
     * receiver.
     *
     * @throws IOException
     *             If an IO exception happened when writing the tag for
     *             {@code null}.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.112 -0500", hash_original_method = "631D52D34CFE4ABBA41E943E2B7FB044", hash_generated_method = "60BC8CB03B87340E315CB362518E95AD")
    
private void writeNull() throws IOException {
        output.writeByte(TC_NULL);
    }

    /**
     * Writes an object to the target stream.
     *
     * @param object
     *            the object to write to the target stream.
     * @throws IOException
     *             if an error occurs while writing to the target stream.
     * @see ObjectInputStream#readObject()
     */
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.115 -0500", hash_original_method = "D65EE5B0FE82553B53FE321A403242DE", hash_generated_method = "0F7F1300E84E4CF37EC57773C07CEC2E")
    
public final void writeObject(Object object) throws IOException {
        writeObject(object, false);
    }

    /**
     * Writes an unshared object to the target stream. This method is identical
     * to {@code writeObject}, except that it always writes a new object to the
     * stream versus the use of back-referencing for identical objects by
     * {@code writeObject}.
     *
     * @param object
     *            the object to write to the target stream.
     * @throws IOException
     *             if an error occurs while writing to the target stream.
     * @see ObjectInputStream#readUnshared()
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.117 -0500", hash_original_method = "21591331F2C6632F1308070B9A9FAC52", hash_generated_method = "6217E9B52C34975907A5890969EFD0B0")
    
public void writeUnshared(Object object) throws IOException {
        writeObject(object, true);
    }

    @DSSink({DSSinkKind.IO})
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.120 -0500", hash_original_method = "6135D4458B19CC3120CAE3855FF2BEA8", hash_generated_method = "E5BDC9807B0FDC2792FD9C88BAFE44FB")
    
private void writeObject(Object object, boolean unshared) throws IOException {
        boolean setOutput = (primitiveTypes == output);
        if (setOutput) {
            primitiveTypes = null;
        }
        // This is the specified behavior in JDK 1.2. Very bizarre way to allow
        // behavior overriding.
        if (subclassOverridingImplementation && !unshared) {
            writeObjectOverride(object);
            return;
        }

        try {
            // First we need to flush primitive types if they were written
            drain();
            // Actual work, and class-based replacement should be computed
            // if needed.
            writeObjectInternal(object, unshared, true, true);
            if (setOutput) {
                primitiveTypes = output;
            }
        } catch (IOException ioEx1) {
            // This will make it pass through until the top caller. It also
            // lets it pass through the nested exception.
            if (nestedLevels == 0 && ioEx1 != nestedException) {
                try {
                    writeNewException(ioEx1);
                } catch (IOException ioEx2) {
                    nestedException.fillInStackTrace();
                    throw nestedException;
                }
            }
            throw ioEx1; // and then we propagate the original exception
        }
    }

    /**
     * Write object {@code object} into the receiver's underlying stream.
     *
     * @param object
     *            The object to write
     * @param unshared
     *            Write the object unshared
     * @param computeClassBasedReplacement
     *            A boolean indicating if class-based replacement should be
     *            computed (if supported) for the object.
     * @param computeStreamReplacement
     *            A boolean indicating if stream-based replacement should be
     *            computed (if supported) for the object.
     * @return the handle assigned to the final object being dumped
     *
     * @throws IOException
     *             If an IO exception happened when writing the object
     *
     * @see ObjectInputStream#readObject()
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.124 -0500", hash_original_method = "AD80A9CFC14D0263A7F0CECDD085D8B1", hash_generated_method = "B4039A8ED683CBCBCE97D37B81B712C7")
    
private int writeObjectInternal(Object object, boolean unshared,
            boolean computeClassBasedReplacement,
            boolean computeStreamReplacement) throws IOException {

        if (object == null) {
            writeNull();
            return -1;
        }
        int handle = -1;
        if (!unshared) {
            handle = dumpCycle(object);
            if (handle != -1) {
                return handle; // cyclic reference
            }
        }

        // Non-null object, first time seen...
        Class<?> objClass = object.getClass();
        ObjectStreamClass clDesc = ObjectStreamClass.lookupStreamClass(objClass);

        nestedLevels++;
        try {

            if (!(enableReplace && computeStreamReplacement)) {
                // Is it a Class ?
                if (objClass == ObjectStreamClass.CLASSCLASS) {
                    return writeNewClass((Class<?>) object, unshared);
                }
                // Is it an ObjectStreamClass ?
                if (objClass == ObjectStreamClass.OBJECTSTREAMCLASSCLASS) {
                    return writeClassDesc((ObjectStreamClass) object, unshared);
                }
            }

            if (clDesc.isSerializable() && computeClassBasedReplacement) {
                if (clDesc.hasMethodWriteReplace()){
                    Method methodWriteReplace = clDesc.getMethodWriteReplace();
                    Object replObj = null;
                    try {
                        replObj = methodWriteReplace.invoke(object, (Object[]) null);
                    } catch (IllegalAccessException iae) {
                        replObj = object;
                    } catch (InvocationTargetException ite) {
                        // WARNING - Not sure this is the right thing to do
                        // if we can't run the method
                        Throwable target = ite.getTargetException();
                        if (target instanceof ObjectStreamException) {
                            throw (ObjectStreamException) target;
                        } else if (target instanceof Error) {
                            throw (Error) target;
                        } else {
                            throw (RuntimeException) target;
                        }
                    }
                    if (replObj != object) {
                        // All over, class-based replacement off this time.
                        int replacementHandle = writeObjectInternal(replObj, false, false,
                                computeStreamReplacement);
                        // Make the original object also map to the same
                        // handle.
                        if (replacementHandle != -1) {
                            objectsWritten.put(object, replacementHandle);
                        }
                        return replacementHandle;
                    }
                }

            }

            // We get here either if class-based replacement was not needed or
            // if it was needed but produced the same object or if it could not
            // be computed.
            if (enableReplace && computeStreamReplacement) {
                // Now we compute the stream-defined replacement.
                Object streamReplacement = replaceObject(object);
                if (streamReplacement != object) {
                    // All over, class-based replacement off this time.
                    int replacementHandle = writeObjectInternal(streamReplacement, false,
                            computeClassBasedReplacement, false);
                    // Make the original object also map to the same handle.
                    if (replacementHandle != -1) {
                        objectsWritten.put(object, replacementHandle);
                    }
                    return replacementHandle;
                }
            }

            // We get here if stream-based replacement produced the same object

            // Is it a Class ?
            if (objClass == ObjectStreamClass.CLASSCLASS) {
                return writeNewClass((Class<?>) object, unshared);
            }

            // Is it an ObjectStreamClass ?
            if (objClass == ObjectStreamClass.OBJECTSTREAMCLASSCLASS) {
                return writeClassDesc((ObjectStreamClass) object, unshared);
            }

            // Is it a String ? (instanceof, but == is faster)
            if (objClass == ObjectStreamClass.STRINGCLASS) {
                return writeNewString((String) object, unshared);
            }

            // Is it an Array ?
            if (objClass.isArray()) {
                return writeNewArray(object, objClass, clDesc, objClass
                        .getComponentType(), unshared);
            }

            if (object instanceof Enum) {
                return writeNewEnum(object, objClass, unshared);
            }

            // Not a String or Class or Array. Default procedure.
            return writeNewObject(object, objClass, clDesc, unshared);
        } finally {
            nestedLevels--;
        }
    }

    // write for Enum Class Desc only, which is different from other classes
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.127 -0500", hash_original_method = "23E7E12F7C58661823B132165D2AB697", hash_generated_method = "71F95F71B6017D2395370C5D48C61E5F")
    
private ObjectStreamClass writeEnumDesc(Class<?> theClass, ObjectStreamClass classDesc, boolean unshared)
            throws IOException {
        // write classDesc, classDesc for enum is different

        // set flag for enum, the flag is (SC_SERIALIZABLE | SC_ENUM)
        classDesc.setFlags((byte) (SC_SERIALIZABLE | SC_ENUM));
        int previousHandle = -1;
        if (unshared) {
            previousHandle = objectsWritten.get(classDesc);
        }
        int handle = -1;
        if (!unshared) {
            handle = dumpCycle(classDesc);
        }
        if (handle == -1) {
            Class<?> classToWrite = classDesc.forClass();
            // If we got here, it is a new (non-null) classDesc that will have
            // to be registered as well
            registerObjectWritten(classDesc);

            output.writeByte(TC_CLASSDESC);
            if (protocolVersion == PROTOCOL_VERSION_1) {
                writeNewClassDesc(classDesc);
            } else {
                // So write...() methods can be used by
                // subclasses during writeClassDescriptor()
                primitiveTypes = output;
                writeClassDescriptor(classDesc);
                primitiveTypes = null;
            }
            // Extra class info (optional)
            annotateClass(classToWrite);
            drain(); // flush primitive types in the annotation
            output.writeByte(TC_ENDBLOCKDATA);
            // write super class
            ObjectStreamClass superClassDesc = classDesc.getSuperclass();
            if (superClassDesc != null) {
                // super class is also enum
                superClassDesc.setFlags((byte) (SC_SERIALIZABLE | SC_ENUM));
                writeEnumDesc(superClassDesc.forClass(), superClassDesc, unshared);
            } else {
                output.writeByte(TC_NULL);
            }
            if (unshared) {
                // remove reference to unshared object
                removeUnsharedReference(classDesc, previousHandle);
            }
        }
        return classDesc;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.130 -0500", hash_original_method = "C81760408EA928607A5B6FF41AD80929", hash_generated_method = "A85A7B2AA6A35C622237528541F0FF2D")
    
private int writeNewEnum(Object object, Class<?> theClass, boolean unshared) throws IOException {
        // write new Enum
        EmulatedFieldsForDumping originalCurrentPutField = currentPutField; // save
        // null it, to make sure one will be computed if needed
        currentPutField = null;

        output.writeByte(TC_ENUM);
        while (theClass != null && !theClass.isEnum()) {
            // write enum only
            theClass = theClass.getSuperclass();
        }
        ObjectStreamClass classDesc = ObjectStreamClass.lookup(theClass);
        writeEnumDesc(theClass, classDesc, unshared);

        int previousHandle = -1;
        if (unshared) {
            previousHandle = objectsWritten.get(object);
        }
        int handle = registerObjectWritten(object);

        ObjectStreamField[] fields = classDesc.getSuperclass().fields();
        // Only write field "name" for enum class, which is the second field of
        // enum, that is fields[1]. Ignore all non-fields and fields.length < 2
        if (fields != null && fields.length > 1) {
            Field field = classDesc.getSuperclass().getReflectionField(fields[1]);
            if (field == null) {
                throw new NoSuchFieldError();
            }
            try {
                String str = (String) field.get(object);
                int strHandle = -1;
                if (!unshared) {
                    strHandle = dumpCycle(str);
                }
                if (strHandle == -1) {
                    writeNewString(str, unshared);
                }
            } catch (IllegalAccessException iae) {
                throw new AssertionError(iae);
            }
        }

        if (unshared) {
            // remove reference to unshared object
            removeUnsharedReference(object, previousHandle);
        }
        currentPutField = originalCurrentPutField;
        return handle;
    }

    /**
     * Method to be overridden by subclasses to write {@code object} to the
     * target stream.
     *
     * @param object
     *            the object to write to the target stream.
     * @throws IOException
     *             if an error occurs while writing to the target stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.133 -0500", hash_original_method = "10EDB7023EA5060FBBA4CCA483056F88", hash_generated_method = "F09E759431A35BEADD68CCE30669D906")
    
protected void writeObjectOverride(Object object) throws IOException {
        if (!subclassOverridingImplementation) {
            // Subclasses must override.
            throw new IOException();
        }
    }

    /**
     * Writes a short (16 bit) to the target stream.
     *
     * @param value
     *            the short to write to the target stream.
     * @throws IOException
     *             if an error occurs while writing to the target stream.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.136 -0500", hash_original_method = "F969E0C742AA855339F3D16852D29508", hash_generated_method = "56ACD159CD8C7DEAAF4C2A7416345641")
    
public void writeShort(int value) throws IOException {
        checkWritePrimitiveTypes();
        primitiveTypes.writeShort(value);
    }
    
    public static abstract class PutField {
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.795 -0400", hash_original_method = "132782D29A7095A05BCF82A07EC6676D", hash_generated_method = "132782D29A7095A05BCF82A07EC6676D")
        public PutField ()
        {
            //Synthesized constructor
        }
        /**
         * Puts the value of the boolean field identified by {@code name} to the
         * persistent field.
         *
         * @param name
         *            the name of the field to serialize.
         * @param value
         *            the value that is put to the persistent field.
         */
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.956 -0500", hash_original_method = "667143831AF06F72EDD5FEF1B82AC2BB", hash_generated_method = "713E518839A493B91F7EDF964973EB24")
        
public abstract void put(String name, boolean value);

        /**
         * Puts the value of the character field identified by {@code name} to
         * the persistent field.
         *
         * @param name
         *            the name of the field to serialize.
         * @param value
         *            the value that is put to the persistent field.
         */
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.958 -0500", hash_original_method = "7C6DB3901C2EC32B7D3F76BEC36ED2FA", hash_generated_method = "6B8CF0C48B409FCE4E2F599DD0AF969F")
        
public abstract void put(String name, char value);

        /**
         * Puts the value of the byte field identified by {@code name} to the
         * persistent field.
         *
         * @param name
         *            the name of the field to serialize.
         * @param value
         *            the value that is put to the persistent field.
         */
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.960 -0500", hash_original_method = "8267BB8AA842B0888237742FBD358BBF", hash_generated_method = "36791ADD60CED0BCFCF9E7B51BBAB22F")
        
public abstract void put(String name, byte value);

        /**
         * Puts the value of the short field identified by {@code name} to the
         * persistent field.
         *
         * @param name
         *            the name of the field to serialize.
         * @param value
         *            the value that is put to the persistent field.
         */
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.963 -0500", hash_original_method = "CBA96376FB419B0B0C65E2B95E9ED63A", hash_generated_method = "B523A6857C1D11FF3ECE97FCA157FF18")
        
public abstract void put(String name, short value);

        /**
         * Puts the value of the integer field identified by {@code name} to the
         * persistent field.
         *
         * @param name
         *            the name of the field to serialize.
         * @param value
         *            the value that is put to the persistent field.
         */
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.966 -0500", hash_original_method = "9B9614BEA4B72B476E99C6FF027511F4", hash_generated_method = "BACEC47DF65202FAFDEF28015B83D8E2")
        
public abstract void put(String name, int value);

        /**
         * Puts the value of the long field identified by {@code name} to the
         * persistent field.
         *
         * @param name
         *            the name of the field to serialize.
         * @param value
         *            the value that is put to the persistent field.
         */
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.969 -0500", hash_original_method = "9C30C7EB94A4F8FEC087934271AC1B02", hash_generated_method = "A3C8081D274479A5E2B870C629090ABA")
        
public abstract void put(String name, long value);

        /**
         * Puts the value of the float field identified by {@code name} to the
         * persistent field.
         *
         * @param name
         *            the name of the field to serialize.
         * @param value
         *            the value that is put to the persistent field.
         */
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.972 -0500", hash_original_method = "A8619D52CECE8ED9E2E87EBF2865ADF7", hash_generated_method = "26D9F3CC2BD44ABFFAAB294B70B8319E")
        
public abstract void put(String name, float value);

        /**
         * Puts the value of the double field identified by {@code name} to the
         * persistent field.
         *
         * @param name
         *            the name of the field to serialize.
         * @param value
         *            the value that is put to the persistent field.
         */
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.974 -0500", hash_original_method = "6F29A03593273294969378EA099D54B1", hash_generated_method = "FA11B36702B36D0E536255B4F480FE89")
        
public abstract void put(String name, double value);

        /**
         * Puts the value of the Object field identified by {@code name} to the
         * persistent field.
         *
         * @param name
         *            the name of the field to serialize.
         * @param value
         *            the value that is put to the persistent field.
         */
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.977 -0500", hash_original_method = "87DAE3A3EEF2A5E508B82EA320203B18", hash_generated_method = "48D7FFE896B7A024B642F064C15A106B")
        
public abstract void put(String name, Object value);

        /**
         * Writes the fields to the target stream {@code out}.
         *
         * @param out
         *            the target stream
         * @throws IOException
         *             if an error occurs while writing to the target stream.
         * @deprecated This method is unsafe and may corrupt the target stream.
         *             Use ObjectOutputStream#writeFields() instead.
         */
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:45.980 -0500", hash_original_method = "57B108A1D82DAA665AF8E2E4B6F1A1B0", hash_generated_method = "9159849DB36EB4CE7059124897145AE6")
        
@Deprecated
        public abstract void write(ObjectOutput out) throws IOException;
        
    }

    /**
     * Writes the {@link ObjectOutputStream} header to the target stream.
     *
     * @throws IOException
     *             if an error occurs while writing to the target stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.138 -0500", hash_original_method = "EEF09F25018D316A37E59FEE3B6D335C", hash_generated_method = "4788FB538C94DF0CCBF16128BC4FDA78")
    
protected void writeStreamHeader() throws IOException {
        output.writeShort(STREAM_MAGIC);
        output.writeShort(STREAM_VERSION);
    }

    /**
     * Writes a string encoded with {@link DataInput modified UTF-8} to the
     * target stream.
     *
     * @param value
     *            the string to write to the target stream.
     * @throws IOException
     *             if an error occurs while writing to the target stream.
     */
    @DSComment("Activity on IO class")
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:46.141 -0500", hash_original_method = "BDFE9F98A4288C3F1994A443E4A70C5E", hash_generated_method = "CA676E9C31D6BA3A4A1446EAAB71FA96")
    
public void writeUTF(String value) throws IOException {
        checkWritePrimitiveTypes();
        primitiveTypes.writeUTF(value);
    }
}

