package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

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
    private static final Class<?>[] WRITE_UNSHARED_PARAM_TYPES = new Class[] { Object.class };
    private static final byte NOT_SC_BLOCK_DATA = (byte) (SC_BLOCK_DATA ^ 0xFF);
    private int nestedLevels;
    private DataOutputStream output;
    private boolean enableReplace;
    private DataOutputStream primitiveTypes;
    private ByteArrayOutputStream primitiveTypesBuffer;
    private SerializationHandleMap objectsWritten;
    private int currentHandle;
    private Object currentObject;
    private ObjectStreamClass currentClass;
    private int protocolVersion;
    private StreamCorruptedException nestedException;
    private EmulatedFieldsForDumping currentPutField;
    private boolean subclassOverridingImplementation;
    private final ObjectStreamClass proxyClassDesc = ObjectStreamClass.lookup(Proxy.class);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.561 -0400", hash_original_method = "EA89A37EA944EE797F4A4E71C06BB807", hash_generated_method = "28D9F976BBD74372DF4D65711D91066A")
    @DSModeled(DSC.SAFE)
    protected ObjectOutputStream() throws IOException {
        this.subclassOverridingImplementation = true;
        // ---------- Original Method ----------
        //this.subclassOverridingImplementation = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.562 -0400", hash_original_method = "C3742BF53888E5C7E36BAC1682B0BA91", hash_generated_method = "0EC2A60F81CB64DB887AA3E1AFE01FE6")
    @DSModeled(DSC.SAFE)
    public ObjectOutputStream(OutputStream output) throws IOException {
        dsTaint.addTaint(output.dsTaint);
        this.output = (output instanceof DataOutputStream) ? (DataOutputStream) output
                : new DataOutputStream(output);
        this.enableReplace = false;
        this.protocolVersion = PROTOCOL_VERSION_2;
        this.subclassOverridingImplementation = false;
        resetState();
        this.nestedException = new StreamCorruptedException();
        primitiveTypes = this.output;
        writeStreamHeader();
        primitiveTypes = null;
        // ---------- Original Method ----------
        //this.output = (output instanceof DataOutputStream) ? (DataOutputStream) output
                //: new DataOutputStream(output);
        //this.enableReplace = false;
        //this.protocolVersion = PROTOCOL_VERSION_2;
        //this.subclassOverridingImplementation = false;
        //resetState();
        //this.nestedException = new StreamCorruptedException();
        //primitiveTypes = this.output;
        //writeStreamHeader();
        //primitiveTypes = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.562 -0400", hash_original_method = "2EE844E85177CE8B8519EE788449061C", hash_generated_method = "9F15EC542E7C8C1609E051166AD580EB")
    @DSModeled(DSC.SAFE)
    protected void annotateClass(Class<?> aClass) throws IOException {
        dsTaint.addTaint(aClass.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.562 -0400", hash_original_method = "6D36FCC856EE4705ED65F6105201ADD2", hash_generated_method = "7E7CD3255D4BC741BAB7C4D24F63BC42")
    @DSModeled(DSC.SAFE)
    protected void annotateProxyClass(Class<?> aClass) throws IOException {
        dsTaint.addTaint(aClass.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.562 -0400", hash_original_method = "73D4A72122980F7DB50B81D978D62054", hash_generated_method = "81BF360A980B0FAC42E0D692E2F69D0A")
    @DSModeled(DSC.SAFE)
    private void checkWritePrimitiveTypes() {
        {
            primitiveTypesBuffer = new ByteArrayOutputStream(128);
            primitiveTypes = new DataOutputStream(primitiveTypesBuffer);
        } //End block
        // ---------- Original Method ----------
        //if (primitiveTypes == null) {
            //primitiveTypesBuffer = new ByteArrayOutputStream(128);
            //primitiveTypes = new DataOutputStream(primitiveTypesBuffer);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.562 -0400", hash_original_method = "29115934C3EAEF8AC600D579304D0581", hash_generated_method = "5C5C7A9C68CE27D1567BA1BAED9F4C12")
    @DSModeled(DSC.SAFE)
    @Override
    public void close() throws IOException {
        flush();
        output.close();
        // ---------- Original Method ----------
        //flush();
        //output.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.562 -0400", hash_original_method = "75FABBE0CA8F03B34490087B8F17BDC1", hash_generated_method = "AFE56A5CC3CDC5E084028D26DB66659D")
    @DSModeled(DSC.SAFE)
    private void computePutField() {
        currentPutField = new EmulatedFieldsForDumping(this, currentClass);
        // ---------- Original Method ----------
        //currentPutField = new EmulatedFieldsForDumping(this, currentClass);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.562 -0400", hash_original_method = "F6C293AC5437F7F079C554EABDD8D443", hash_generated_method = "AE63D5AF067E40673D9DAF929E4AE554")
    @DSModeled(DSC.SAFE)
    public void defaultWriteObject() throws IOException {
        {
        	if (DroidSafeAndroidRuntime.control) throw new NotActiveException();
        } //End block
        writeFieldValues(currentObject, currentClass);
        // ---------- Original Method ----------
        //if (currentObject == null) {
            //throw new NotActiveException();
        //}
        //writeFieldValues(currentObject, currentClass);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.562 -0400", hash_original_method = "A89FD6C60365B1028CEBCCFC3106EF9A", hash_generated_method = "A81F469F925FAD6D1CF1FC2B24328CC6")
    @DSModeled(DSC.SAFE)
    protected void drain() throws IOException {
        int offset;
        offset = 0;
        byte[] written;
        written = primitiveTypesBuffer.toByteArray();
        {
            int toWrite;
            toWrite = 1024;
            toWrite = written.length - offset;
            {
                output.writeByte(TC_BLOCKDATA);
                output.writeByte((byte) toWrite);
            } //End block
            {
                output.writeByte(TC_BLOCKDATALONG);
                output.writeInt(toWrite);
            } //End block
            output.write(written, offset, toWrite);
            offset += toWrite;
        } //End block
        primitiveTypes = null;
        primitiveTypesBuffer = null;
        // ---------- Original Method ----------
        //if (primitiveTypes == null || primitiveTypesBuffer == null) {
            //return;
        //}
        //int offset = 0;
        //byte[] written = primitiveTypesBuffer.toByteArray();
        //while (offset < written.length) {
            //int toWrite = written.length - offset > 1024 ? 1024
                    //: written.length - offset;
            //if (toWrite < 256) {
                //output.writeByte(TC_BLOCKDATA);
                //output.writeByte((byte) toWrite);
            //} else {
                //output.writeByte(TC_BLOCKDATALONG);
                //output.writeInt(toWrite);
            //}
            //output.write(written, offset, toWrite);
            //offset += toWrite;
        //}
        //primitiveTypes = null;
        //primitiveTypesBuffer = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.562 -0400", hash_original_method = "3C81D15CCFEF1BE19C0E53EB7F3B0380", hash_generated_method = "00E58AEDC70BB67FD3FBFFFD04C7FFDA")
    @DSModeled(DSC.SAFE)
    private int dumpCycle(Object obj) throws IOException {
        dsTaint.addTaint(obj.dsTaint);
        int handle;
        handle = objectsWritten.get(obj);
        {
            writeCyclicReference(handle);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int handle = objectsWritten.get(obj);
        //if (handle != -1) {
            //writeCyclicReference(handle);
            //return handle;
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.562 -0400", hash_original_method = "7186A696463687F53D4FA37D2BB9631D", hash_generated_method = "5A693CBC6796BD3EE350FA7C4D57BEB2")
    @DSModeled(DSC.SAFE)
    protected boolean enableReplaceObject(boolean enable) {
        dsTaint.addTaint(enable);
        boolean originalValue;
        originalValue = enableReplace;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean originalValue = enableReplace;
        //enableReplace = enable;
        //return originalValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.562 -0400", hash_original_method = "117A95892DAF31A0926F2E917E5208CF", hash_generated_method = "DFBB87C04D83FE129BE26EEC975364E9")
    @DSModeled(DSC.SAFE)
    @Override
    public void flush() throws IOException {
        drain();
        output.flush();
        // ---------- Original Method ----------
        //drain();
        //output.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.562 -0400", hash_original_method = "63EAAB97CFDD856D65D1CFD6010F5BA7", hash_generated_method = "AADE721D96F0CA7D31A8F670F52E327C")
    private static Object getFieldL(Object instance, Class<?> declaringClass, String fieldName, String fieldTypeName) {
    	return new Object();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.562 -0400", hash_original_method = "3E8C44E06770B18C136965DDB10C163B", hash_generated_method = "46F0B1ED399712F523D0ED50915DD399")
    @DSModeled(DSC.SAFE)
    private int nextHandle() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return currentHandle++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.563 -0400", hash_original_method = "4F3CF2DA9583C39D0A0D02BEFFFE8C29", hash_generated_method = "094C6021821EB57C3922F311F4E870FA")
    @DSModeled(DSC.SAFE)
    public PutField putFields() throws IOException {
        {
        	if (DroidSafeAndroidRuntime.control) throw new NotActiveException();
        } //End block
        {
            computePutField();
        } //End block
        return (PutField)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (currentObject == null) {
            //throw new NotActiveException();
        //}
        //if (currentPutField == null) {
            //computePutField();
        //}
        //return currentPutField;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.563 -0400", hash_original_method = "6CA6FC4D83D22ECC70837B9572B0E8EA", hash_generated_method = "0860FB3A1130C684603862E858BCCC93")
    @DSModeled(DSC.SAFE)
    private int registerObjectWritten(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        int handle;
        handle = nextHandle();
        objectsWritten.put(obj, handle);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int handle = nextHandle();
        //objectsWritten.put(obj, handle);
        //return handle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.563 -0400", hash_original_method = "37FD060D4B2DB7C3EC8F52EA51C77D72", hash_generated_method = "B16AD46543449AB059991D9F2B07111E")
    @DSModeled(DSC.SAFE)
    private void removeUnsharedReference(Object obj, int previousHandle) {
        dsTaint.addTaint(previousHandle);
        dsTaint.addTaint(obj.dsTaint);
        {
            objectsWritten.put(obj, previousHandle);
        } //End block
        {
            objectsWritten.remove(obj);
        } //End block
        // ---------- Original Method ----------
        //if (previousHandle != -1) {
            //objectsWritten.put(obj, previousHandle);
        //} else {
            //objectsWritten.remove(obj);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.563 -0400", hash_original_method = "C1DF94E02684AF79BBD267850463E92A", hash_generated_method = "61F7283440B02CEBCB285962A3F6B711")
    @DSModeled(DSC.SAFE)
    protected Object replaceObject(Object object) throws IOException {
        dsTaint.addTaint(object.dsTaint);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return object;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.563 -0400", hash_original_method = "4FDA9D292F9CB60FE54E9147043F29DF", hash_generated_method = "FCD8B4CB8DC70E7E49065B7B1E592524")
    @DSModeled(DSC.SAFE)
    public void reset() throws IOException {
        drain();
        output.writeByte(TC_RESET);
        resetState();
        // ---------- Original Method ----------
        //drain();
        //output.writeByte(TC_RESET);
        //resetState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.563 -0400", hash_original_method = "CB42E7CB8763CADF528182B203F4731A", hash_generated_method = "9240EE410EF9214A9540B9805186C336")
    @DSModeled(DSC.SAFE)
    private void resetSeenObjects() {
        objectsWritten = new SerializationHandleMap();
        currentHandle = baseWireHandle;
        // ---------- Original Method ----------
        //objectsWritten = new SerializationHandleMap();
        //currentHandle = baseWireHandle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.563 -0400", hash_original_method = "27ED7D7B38D4C22EF7056E4BAF81440E", hash_generated_method = "3D9AA508D5B54872CD0DE39F21F0E4DE")
    @DSModeled(DSC.SAFE)
    private void resetState() {
        resetSeenObjects();
        nestedLevels = 0;
        // ---------- Original Method ----------
        //resetSeenObjects();
        //nestedLevels = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.563 -0400", hash_original_method = "899849124785B3DAA2410A481AC243A4", hash_generated_method = "79F331F352D227706E39292BA49FCF78")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void useProtocolVersion(int version) throws IOException {
        dsTaint.addTaint(version);
        {
            boolean varECECE5172FBA187AE03F784B354A8EDD_1021797053 = (!objectsWritten.isEmpty());
            {
            	if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Cannot set protocol version when stream in use");
            } //End block
        } //End collapsed parenthetic
        {
            throw new IllegalArgumentException("Unknown protocol: " + version);
        } //End block
        // ---------- Original Method ----------
        //if (!objectsWritten.isEmpty()) {
            //throw new IllegalStateException("Cannot set protocol version when stream in use");
        //}
        //if (version != ObjectStreamConstants.PROTOCOL_VERSION_1
                //&& version != ObjectStreamConstants.PROTOCOL_VERSION_2) {
            //throw new IllegalArgumentException("Unknown protocol: " + version);
        //}
        //protocolVersion = version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.563 -0400", hash_original_method = "4335176A8BF0CB76C8983C14BE755AB0", hash_generated_method = "D735159BBAFE22F34FFB6BAB1DA63C20")
    @DSModeled(DSC.SAFE)
    @Override
    public void write(byte[] buffer, int offset, int length) throws IOException {
        dsTaint.addTaint(buffer);
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        checkWritePrimitiveTypes();
        primitiveTypes.write(buffer, offset, length);
        // ---------- Original Method ----------
        //checkWritePrimitiveTypes();
        //primitiveTypes.write(buffer, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.563 -0400", hash_original_method = "890E7ADC76A0934752F791BA928637BD", hash_generated_method = "BABC629B30EC89F77A51F657ACFE8EA7")
    @DSModeled(DSC.SAFE)
    @Override
    public void write(int value) throws IOException {
        dsTaint.addTaint(value);
        checkWritePrimitiveTypes();
        primitiveTypes.write(value);
        // ---------- Original Method ----------
        //checkWritePrimitiveTypes();
        //primitiveTypes.write(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.563 -0400", hash_original_method = "253E21281D84BB4AEC7BC00A39E22928", hash_generated_method = "5758DBA3FD3C71E9403123C41D8E89D0")
    @DSModeled(DSC.SAFE)
    public void writeBoolean(boolean value) throws IOException {
        dsTaint.addTaint(value);
        checkWritePrimitiveTypes();
        primitiveTypes.writeBoolean(value);
        // ---------- Original Method ----------
        //checkWritePrimitiveTypes();
        //primitiveTypes.writeBoolean(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.563 -0400", hash_original_method = "DCBF5513EE5F9BB37CF570D282A66C5E", hash_generated_method = "E0A22491D093538D06197DEB782A470D")
    @DSModeled(DSC.SAFE)
    public void writeByte(int value) throws IOException {
        dsTaint.addTaint(value);
        checkWritePrimitiveTypes();
        primitiveTypes.writeByte(value);
        // ---------- Original Method ----------
        //checkWritePrimitiveTypes();
        //primitiveTypes.writeByte(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.563 -0400", hash_original_method = "2FD9E25E34EBC831C98FBB1774A09056", hash_generated_method = "894C8B0734349C5374154AA0EEEDBF61")
    @DSModeled(DSC.SAFE)
    public void writeBytes(String value) throws IOException {
        dsTaint.addTaint(value);
        checkWritePrimitiveTypes();
        primitiveTypes.writeBytes(value);
        // ---------- Original Method ----------
        //checkWritePrimitiveTypes();
        //primitiveTypes.writeBytes(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.563 -0400", hash_original_method = "A70BC61472A0A40B7DA1B300459E269C", hash_generated_method = "302A78A4E6F70BC03E528F8EDEF6C438")
    @DSModeled(DSC.SAFE)
    public void writeChar(int value) throws IOException {
        dsTaint.addTaint(value);
        checkWritePrimitiveTypes();
        primitiveTypes.writeChar(value);
        // ---------- Original Method ----------
        //checkWritePrimitiveTypes();
        //primitiveTypes.writeChar(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.563 -0400", hash_original_method = "2819E1113D5EFA42F2CF8A185C5FE232", hash_generated_method = "8B08FB98486C9AC8F0F0D4B0775FCFBE")
    @DSModeled(DSC.SAFE)
    public void writeChars(String value) throws IOException {
        dsTaint.addTaint(value);
        checkWritePrimitiveTypes();
        primitiveTypes.writeChars(value);
        // ---------- Original Method ----------
        //checkWritePrimitiveTypes();
        //primitiveTypes.writeChars(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.564 -0400", hash_original_method = "D6DF6A35D187C3B8A220F04225A24DB7", hash_generated_method = "C58079290F59B68D06F1E2BD18853D15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int writeClassDesc(ObjectStreamClass classDesc, boolean unshared) throws IOException {
        dsTaint.addTaint(unshared);
        dsTaint.addTaint(classDesc.dsTaint);
        {
            writeNull();
        } //End block
        int handle;
        handle = -1;
        {
            handle = dumpCycle(classDesc);
        } //End block
        {
            Class<?> classToWrite;
            classToWrite = classDesc.forClass();
            int previousHandle;
            previousHandle = -1;
            {
                previousHandle = objectsWritten.get(classDesc);
            } //End block
            handle = registerObjectWritten(classDesc);
            {
                boolean var7E6F01091A347CE0B7E67A74C6AFA496_225991177 = (classDesc.isProxy());
                {
                    output.writeByte(TC_PROXYCLASSDESC);
                    Class<?>[] interfaces;
                    interfaces = classToWrite.getInterfaces();
                    output.writeInt(interfaces.length);
                    {
                        int i;
                        i = 0;
                        {
                            output.writeUTF(interfaces[i].getName());
                        } //End block
                    } //End collapsed parenthetic
                    annotateProxyClass(classToWrite);
                    output.writeByte(TC_ENDBLOCKDATA);
                    writeClassDesc(proxyClassDesc, false);
                    {
                        removeUnsharedReference(classDesc, previousHandle);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            output.writeByte(TC_CLASSDESC);
            {
                writeNewClassDesc(classDesc);
            } //End block
            {
                primitiveTypes = output;
                writeClassDescriptor(classDesc);
                primitiveTypes = null;
            } //End block
            annotateClass(classToWrite);
            drain();
            output.writeByte(TC_ENDBLOCKDATA);
            writeClassDesc(classDesc.getSuperclass(), unshared);
            {
                removeUnsharedReference(classDesc, previousHandle);
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.564 -0400", hash_original_method = "6CD4D6A26A6EE5C2333CE9BAD2D29100", hash_generated_method = "334E7AA9D81036A4D64AF9595BD414B8")
    @DSModeled(DSC.SAFE)
    private void writeCyclicReference(int handle) throws IOException {
        dsTaint.addTaint(handle);
        output.writeByte(TC_REFERENCE);
        output.writeInt(handle);
        // ---------- Original Method ----------
        //output.writeByte(TC_REFERENCE);
        //output.writeInt(handle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.564 -0400", hash_original_method = "02DC35912BAFF16550D8FBDB82DDCD50", hash_generated_method = "9EE486AD2CA9B2FC3009280C25133401")
    @DSModeled(DSC.SAFE)
    public void writeDouble(double value) throws IOException {
        dsTaint.addTaint(value);
        checkWritePrimitiveTypes();
        primitiveTypes.writeDouble(value);
        // ---------- Original Method ----------
        //checkWritePrimitiveTypes();
        //primitiveTypes.writeDouble(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.564 -0400", hash_original_method = "8DAE1373FC5F31DAE45B98A018C14CB9", hash_generated_method = "3338D6C51FCC322B755EDAD7A1C08BCC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeFieldDescriptors(ObjectStreamClass classDesc, boolean externalizable) throws IOException {
        dsTaint.addTaint(externalizable);
        dsTaint.addTaint(classDesc.dsTaint);
        Class<?> loadedClass;
        loadedClass = classDesc.forClass();
        ObjectStreamField[] fields;
        fields = null;
        int fieldCount;
        fieldCount = 0;
        {
            fields = classDesc.fields();
            fieldCount = fields.length;
        } //End block
        output.writeShort(fieldCount);
        {
            int i;
            i = 0;
            {
                ObjectStreamField f;
                f = fields[i];
                boolean wasPrimitive;
                wasPrimitive = f.writeField(output);
                {
                    writeObject(f.getTypeString());
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Class<?> loadedClass = classDesc.forClass();
        //ObjectStreamField[] fields = null;
        //int fieldCount = 0;
        //if (!externalizable && loadedClass != ObjectStreamClass.STRINGCLASS) {
            //fields = classDesc.fields();
            //fieldCount = fields.length;
        //}
        //output.writeShort(fieldCount);
        //for (int i = 0; i < fieldCount; i++) {
            //ObjectStreamField f = fields[i];
            //boolean wasPrimitive = f.writeField(output);
            //if (!wasPrimitive) {
                //writeObject(f.getTypeString());
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.564 -0400", hash_original_method = "851EC9DCB527C64AF85B9AAA86ABFF43", hash_generated_method = "8E2461BFB116DC8EAD354E2607699D82")
    @DSModeled(DSC.SAFE)
    public void writeFields() throws IOException {
        {
        	if (DroidSafeAndroidRuntime.control) throw new NotActiveException();
        } //End block
        writeFieldValues(currentPutField);
        // ---------- Original Method ----------
        //if (currentPutField == null) {
            //throw new NotActiveException();
        //}
        //writeFieldValues(currentPutField);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.564 -0400", hash_original_method = "97B3D4C0A2A3E17C88F2E6B51B15BF4C", hash_generated_method = "3156A2B77F468DD1676A1EF50C544DA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeFieldValues(EmulatedFieldsForDumping emulatedFields) throws IOException {
        dsTaint.addTaint(emulatedFields.dsTaint);
        EmulatedFields accessibleSimulatedFields;
        accessibleSimulatedFields = emulatedFields.emulatedFields();
        {
            EmulatedFields.ObjectSlot slot = accessibleSimulatedFields.slots()[0];
            {
                Object fieldValue;
                fieldValue = slot.getFieldValue();
                Class<?> type;
                type = slot.getField().getType();
                {
                    output.writeInt(fieldValue != null ? ((Integer) fieldValue).intValue() : 0);
                } //End block
                {
                    output.writeByte(fieldValue != null ? ((Byte) fieldValue).byteValue() : 0);
                } //End block
                {
                    output.writeChar(fieldValue != null ? ((Character) fieldValue).charValue() : 0);
                } //End block
                {
                    output.writeShort(fieldValue != null ? ((Short) fieldValue).shortValue() : 0);
                } //End block
                {
                    output.writeBoolean(fieldValue != null ? ((Boolean) fieldValue).booleanValue() : false);
                } //End block
                {
                    output.writeLong(fieldValue != null ? ((Long) fieldValue).longValue() : 0);
                } //End block
                {
                    output.writeFloat(fieldValue != null ? ((Float) fieldValue).floatValue() : 0);
                } //End block
                {
                    output.writeDouble(fieldValue != null ? ((Double) fieldValue).doubleValue() : 0);
                } //End block
                {
                    writeObject(fieldValue);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.565 -0400", hash_original_method = "3B2F054C3660B4FEDDE0689C3B0D847B", hash_generated_method = "B05924179D37C18661DF9E6971950B12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeFieldValues(Object obj, ObjectStreamClass classDesc) throws IOException {
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(classDesc.dsTaint);
        {
            ObjectStreamField fieldDesc = classDesc.fields()[0];
            {
                try 
                {
                    Class<?> type;
                    type = fieldDesc.getTypeInternal();
                    Field field;
                    field = classDesc.getReflectionField(fieldDesc);
                    {
                    	if (DroidSafeAndroidRuntime.control) throw new InvalidClassException(classDesc.getName() + " doesn't have a field " + fieldDesc.getName() + " of type " + type);
                    } //End block
                    {
                        output.writeByte(field.getByte(obj));
                    } //End block
                    {
                        output.writeChar(field.getChar(obj));
                    } //End block
                    {
                        output.writeDouble(field.getDouble(obj));
                    } //End block
                    {
                        output.writeFloat(field.getFloat(obj));
                    } //End block
                    {
                        output.writeInt(field.getInt(obj));
                    } //End block
                    {
                        output.writeLong(field.getLong(obj));
                    } //End block
                    {
                        output.writeShort(field.getShort(obj));
                    } //End block
                    {
                        output.writeBoolean(field.getBoolean(obj));
                    } //End block
                    {
                        Object objField;
                        objField = field.get(obj);
                        {
                            boolean varAE9A15FF7D7FA17920F64E5223326273_815479222 = (fieldDesc.isUnshared());
                            {
                                writeUnshared(objField);
                            } //End block
                            {
                                writeObject(objField);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
                catch (IllegalAccessException iae)
                {
                    throw new AssertionError(iae);
                } //End block
                catch (NoSuchFieldError nsf)
                {
                    throw new InvalidClassException(classDesc.getName());
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.565 -0400", hash_original_method = "2F0CF28A5E4A8655D2779BA683FB03E5", hash_generated_method = "884DD8F6C05D4FC3C26033F9F9F467D1")
    @DSModeled(DSC.SAFE)
    public void writeFloat(float value) throws IOException {
        dsTaint.addTaint(value);
        checkWritePrimitiveTypes();
        primitiveTypes.writeFloat(value);
        // ---------- Original Method ----------
        //checkWritePrimitiveTypes();
        //primitiveTypes.writeFloat(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.565 -0400", hash_original_method = "6C93D0A9BF9141DB46D3843027575223", hash_generated_method = "9B49E11DB763FD2A1E46980F1B3B6F49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeHierarchy(Object object, ObjectStreamClass classDesc) throws IOException, NotActiveException {
        dsTaint.addTaint(object.dsTaint);
        dsTaint.addTaint(classDesc.dsTaint);
        {
        	if (DroidSafeAndroidRuntime.control) throw new NotActiveException();
        } //End block
        List<ObjectStreamClass> hierarchy;
        hierarchy = classDesc.getHierarchy();
        {
            int i, end;
            i = 0;
            end = hierarchy.size();
            {
                ObjectStreamClass osc;
                osc = hierarchy.get(i);
                currentClass = osc;
                try 
                {
                    boolean executed;
                    executed = false;
                    {
                        boolean varC81C7967814EA5E627DC6F37ACE592C1_1290543148 = (osc.hasMethodWriteObject());
                        {
                            final Method method;
                            method = osc.getMethodWriteObject();
                            try 
                            {
                                method.invoke(object, new Object[] { this });
                                executed = true;
                            } //End block
                            catch (InvocationTargetException e)
                            {
                                Throwable ex;
                                ex = e.getTargetException();
                                {
                                	if (DroidSafeAndroidRuntime.control) throw (RuntimeException) ex;
                                } //End block
                                {
                                	if (DroidSafeAndroidRuntime.control) throw (Error) ex;
                                } //End block
                                throw (IOException) ex;
                            } //End block
                            catch (IllegalAccessException e)
                            {
                                throw new RuntimeException(e.toString());
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                    {
                        drain();
                        output.writeByte(TC_ENDBLOCKDATA);
                    } //End block
                    {
                        defaultWriteObject();
                    } //End block
                } //End block
                finally 
                {
                    currentObject = null;
                    currentClass = null;
                    currentPutField = null;
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.565 -0400", hash_original_method = "4D560E72502C61E130F3258421731401", hash_generated_method = "9D0073C975D92CA23D7B20F4A4F59AA9")
    @DSModeled(DSC.SAFE)
    public void writeInt(int value) throws IOException {
        dsTaint.addTaint(value);
        checkWritePrimitiveTypes();
        primitiveTypes.writeInt(value);
        // ---------- Original Method ----------
        //checkWritePrimitiveTypes();
        //primitiveTypes.writeInt(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.565 -0400", hash_original_method = "1C4CA2BE4C70907161A2CF485CB22A3E", hash_generated_method = "6BB73FA4E88063C618FF25A8846EF40C")
    @DSModeled(DSC.SAFE)
    public void writeLong(long value) throws IOException {
        dsTaint.addTaint(value);
        checkWritePrimitiveTypes();
        primitiveTypes.writeLong(value);
        // ---------- Original Method ----------
        //checkWritePrimitiveTypes();
        //primitiveTypes.writeLong(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.566 -0400", hash_original_method = "6EA4BE49540BA12319B9F5CA997917E6", hash_generated_method = "2A0D8BD53FF5D7615E1B413D0B413313")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int writeNewArray(Object array, Class<?> arrayClass, ObjectStreamClass arrayClDesc,
            Class<?> componentType, boolean unshared) throws IOException {
        dsTaint.addTaint(unshared);
        dsTaint.addTaint(arrayClass.dsTaint);
        dsTaint.addTaint(componentType.dsTaint);
        dsTaint.addTaint(array.dsTaint);
        dsTaint.addTaint(arrayClDesc.dsTaint);
        output.writeByte(TC_ARRAY);
        writeClassDesc(arrayClDesc, false);
        int handle;
        handle = nextHandle();
        {
            objectsWritten.put(array, handle);
        } //End block
        {
            boolean varD34D6340EB041A4E3567A6A53D064A1F_1884358598 = (componentType.isPrimitive());
            {
                {
                    int[] intArray;
                    intArray = (int[]) array;
                    output.writeInt(intArray.length);
                    {
                        int i;
                        i = 0;
                        {
                            output.writeInt(intArray[i]);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    byte[] byteArray;
                    byteArray = (byte[]) array;
                    output.writeInt(byteArray.length);
                    output.write(byteArray, 0, byteArray.length);
                } //End block
                {
                    char[] charArray;
                    charArray = (char[]) array;
                    output.writeInt(charArray.length);
                    {
                        int i;
                        i = 0;
                        {
                            output.writeChar(charArray[i]);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    short[] shortArray;
                    shortArray = (short[]) array;
                    output.writeInt(shortArray.length);
                    {
                        int i;
                        i = 0;
                        {
                            output.writeShort(shortArray[i]);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean[] booleanArray;
                    booleanArray = (boolean[]) array;
                    output.writeInt(booleanArray.length);
                    {
                        int i;
                        i = 0;
                        {
                            output.writeBoolean(booleanArray[i]);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    long[] longArray;
                    longArray = (long[]) array;
                    output.writeInt(longArray.length);
                    {
                        int i;
                        i = 0;
                        {
                            output.writeLong(longArray[i]);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    float[] floatArray;
                    floatArray = (float[]) array;
                    output.writeInt(floatArray.length);
                    {
                        int i;
                        i = 0;
                        {
                            output.writeFloat(floatArray[i]);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    double[] doubleArray;
                    doubleArray = (double[]) array;
                    output.writeInt(doubleArray.length);
                    {
                        int i;
                        i = 0;
                        {
                            output.writeDouble(doubleArray[i]);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                	if (DroidSafeAndroidRuntime.control) throw new InvalidClassException("Wrong base type in " + arrayClass.getName());
                } //End block
            } //End block
            {
                Object[] objectArray;
                objectArray = (Object[]) array;
                output.writeInt(objectArray.length);
                {
                    int i;
                    i = 0;
                    {
                        writeObject(objectArray[i]);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.566 -0400", hash_original_method = "EFEEB16087FF4E0EE92685A5C26C0D2A", hash_generated_method = "BB6F866EC13C05A2AC7426E349751EB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int writeNewClass(Class<?> object, boolean unshared) throws IOException {
        dsTaint.addTaint(unshared);
        dsTaint.addTaint(object.dsTaint);
        output.writeByte(TC_CLASS);
        ObjectStreamClass clDesc;
        clDesc = ObjectStreamClass.lookupStreamClass(object);
        {
            boolean varD01EB260C610473CC8B605C36295CA40_1704877637 = (clDesc.isEnum());
            {
                writeEnumDesc(object, clDesc, unshared);
            } //End block
            {
                writeClassDesc(clDesc, unshared);
            } //End block
        } //End collapsed parenthetic
        int handle;
        handle = nextHandle();
        {
            objectsWritten.put(object, handle);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //output.writeByte(TC_CLASS);
        //ObjectStreamClass clDesc = ObjectStreamClass.lookupStreamClass(object);
        //if (clDesc.isEnum()) {
            //writeEnumDesc(object, clDesc, unshared);
        //} else {
            //writeClassDesc(clDesc, unshared);
        //}
        //int handle = nextHandle();
        //if (!unshared) {
            //objectsWritten.put(object, handle);
        //}
        //return handle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.566 -0400", hash_original_method = "8ED9B25450E87C39655806C7FB3946F8", hash_generated_method = "9076AA6CFB7ACFF575A7BA4A6F40950C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeNewClassDesc(ObjectStreamClass classDesc) throws IOException {
        dsTaint.addTaint(classDesc.dsTaint);
        output.writeUTF(classDesc.getName());
        output.writeLong(classDesc.getSerialVersionUID());
        byte flags;
        flags = classDesc.getFlags();
        boolean externalizable;
        externalizable = classDesc.isExternalizable();
        {
            {
                flags &= NOT_SC_BLOCK_DATA;
            } //End block
            {
                flags |= SC_BLOCK_DATA;
            } //End block
        } //End block
        output.writeByte(flags);
        {
            boolean varD2666245420C5C05B9069DAD5D6B9EEB_1011851564 = ((SC_ENUM | SC_SERIALIZABLE) != classDesc.getFlags());
            {
                writeFieldDescriptors(classDesc, externalizable);
            } //End block
            {
                output.writeShort(0);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //output.writeUTF(classDesc.getName());
        //output.writeLong(classDesc.getSerialVersionUID());
        //byte flags = classDesc.getFlags();
        //boolean externalizable = classDesc.isExternalizable();
        //if (externalizable) {
            //if (protocolVersion == PROTOCOL_VERSION_1) {
                //flags &= NOT_SC_BLOCK_DATA;
            //} else {
                //flags |= SC_BLOCK_DATA;
            //}
        //}
        //output.writeByte(flags);
        //if ((SC_ENUM | SC_SERIALIZABLE) != classDesc.getFlags()) {
            //writeFieldDescriptors(classDesc, externalizable);
        //} else {
            //output.writeShort(0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.566 -0400", hash_original_method = "641338D73905B8D6D3FE171A8894AADC", hash_generated_method = "69E0920682E92156931B1B4262DC81AC")
    @DSModeled(DSC.SAFE)
    protected void writeClassDescriptor(ObjectStreamClass classDesc) throws IOException {
        dsTaint.addTaint(classDesc.dsTaint);
        writeNewClassDesc(classDesc);
        // ---------- Original Method ----------
        //writeNewClassDesc(classDesc);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.566 -0400", hash_original_method = "E088B51B3D25E92C7A08790C12EA9546", hash_generated_method = "0F497FAE009A151247C45844E04DD3CB")
    @DSModeled(DSC.SAFE)
    private void writeNewException(Exception ex) throws IOException {
        dsTaint.addTaint(ex.dsTaint);
        output.writeByte(TC_EXCEPTION);
        resetSeenObjects();
        writeObjectInternal(ex, false, false, false);
        resetSeenObjects();
        // ---------- Original Method ----------
        //output.writeByte(TC_EXCEPTION);
        //resetSeenObjects();
        //writeObjectInternal(ex, false, false, false);
        //resetSeenObjects();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.567 -0400", hash_original_method = "AD17E67664AB2CFE5D575A9D2DBC90D0", hash_generated_method = "C1FD412B396E51E5F223D6805E6B9202")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int writeNewObject(Object object, Class<?> theClass, ObjectStreamClass clDesc,
            boolean unshared) throws IOException {
        dsTaint.addTaint(unshared);
        dsTaint.addTaint(theClass.dsTaint);
        dsTaint.addTaint(object.dsTaint);
        dsTaint.addTaint(clDesc.dsTaint);
        EmulatedFieldsForDumping originalCurrentPutField;
        originalCurrentPutField = currentPutField;
        currentPutField = null;
        boolean externalizable;
        externalizable = clDesc.isExternalizable();
        boolean serializable;
        serializable = clDesc.isSerializable();
        {
        	if (DroidSafeAndroidRuntime.control) throw new NotSerializableException(theClass.getName());
        } //End block
        output.writeByte(TC_OBJECT);
        writeClassDesc(clDesc, false);
        int previousHandle;
        previousHandle = -1;
        {
            previousHandle = objectsWritten.get(object);
        } //End block
        int handle;
        handle = registerObjectWritten(object);
        try 
        {
            {
                boolean noBlockData;
                noBlockData = protocolVersion == PROTOCOL_VERSION_1;
                {
                    primitiveTypes = output;
                } //End block
                ((Externalizable) object).writeExternal(this);
                {
                    primitiveTypes = null;
                } //End block
                {
                    drain();
                    output.writeByte(TC_ENDBLOCKDATA);
                } //End block
            } //End block
            {
                writeHierarchy(object, currentClass);
            } //End block
        } //End block
        finally 
        {
            {
                removeUnsharedReference(object, previousHandle);
            } //End block
            currentObject = null;
            currentClass = null;
            currentPutField = originalCurrentPutField;
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.567 -0400", hash_original_method = "BE97C7FA5FB694719D79A72C051D442C", hash_generated_method = "62859178FC207D21BD79E23B538D32F4")
    @DSModeled(DSC.SAFE)
    private int writeNewString(String object, boolean unshared) throws IOException {
        dsTaint.addTaint(unshared);
        dsTaint.addTaint(object);
        long count;
        count = ModifiedUtf8.countBytes(object, false);
        byte[] buffer;
        int offset;
        offset = 0;
        {
            buffer = new byte[1 + SizeOf.SHORT + (int) count];
            buffer[offset++] = TC_STRING;
            Memory.pokeShort(buffer, offset, (short) count, ByteOrder.BIG_ENDIAN);
            offset += SizeOf.SHORT;
        } //End block
        {
            buffer = new byte[1 + SizeOf.LONG + (int) count];
            buffer[offset++] = TC_LONGSTRING;
            Memory.pokeLong(buffer, offset, count, ByteOrder.BIG_ENDIAN);
            offset += SizeOf.LONG;
        } //End block
        ModifiedUtf8.encode(buffer, offset, object);
        output.write(buffer, 0, buffer.length);
        int handle;
        handle = nextHandle();
        {
            objectsWritten.put(object, handle);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.567 -0400", hash_original_method = "631D52D34CFE4ABBA41E943E2B7FB044", hash_generated_method = "DCBE1AB9C78A23332AB9B08E9F0011F8")
    @DSModeled(DSC.SAFE)
    private void writeNull() throws IOException {
        output.writeByte(TC_NULL);
        // ---------- Original Method ----------
        //output.writeByte(TC_NULL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.567 -0400", hash_original_method = "D65EE5B0FE82553B53FE321A403242DE", hash_generated_method = "255F465A8B143ED2F4C403428C376E50")
    @DSModeled(DSC.SAFE)
    public final void writeObject(Object object) throws IOException {
        dsTaint.addTaint(object.dsTaint);
        writeObject(object, false);
        // ---------- Original Method ----------
        //writeObject(object, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.567 -0400", hash_original_method = "21591331F2C6632F1308070B9A9FAC52", hash_generated_method = "51A579B46ABF3B15488775947B8A96BA")
    @DSModeled(DSC.SAFE)
    public void writeUnshared(Object object) throws IOException {
        dsTaint.addTaint(object.dsTaint);
        writeObject(object, true);
        // ---------- Original Method ----------
        //writeObject(object, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.567 -0400", hash_original_method = "6135D4458B19CC3120CAE3855FF2BEA8", hash_generated_method = "6DE4FF73F86CD83968C7F7AC6725885C")
    @DSModeled(DSC.SAFE)
    private void writeObject(Object object, boolean unshared) throws IOException {
        dsTaint.addTaint(unshared);
        dsTaint.addTaint(object.dsTaint);
        boolean setOutput;
        setOutput = (primitiveTypes == output);
        {
            primitiveTypes = null;
        } //End block
        {
            writeObjectOverride(object);
        } //End block
        try 
        {
            drain();
            writeObjectInternal(object, unshared, true, true);
            {
                primitiveTypes = output;
            } //End block
        } //End block
        catch (IOException ioEx1)
        {
            {
                try 
                {
                    writeNewException(ioEx1);
                } //End block
                catch (IOException ioEx2)
                {
                    nestedException.fillInStackTrace();
                    throw nestedException;
                } //End block
            } //End block
            throw ioEx1;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.568 -0400", hash_original_method = "AD80A9CFC14D0263A7F0CECDD085D8B1", hash_generated_method = "10C3A005EB5C4255FD850AAC66F9712B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int writeObjectInternal(Object object, boolean unshared,
            boolean computeClassBasedReplacement,
            boolean computeStreamReplacement) throws IOException {
        dsTaint.addTaint(computeClassBasedReplacement);
        dsTaint.addTaint(unshared);
        dsTaint.addTaint(computeStreamReplacement);
        dsTaint.addTaint(object.dsTaint);
        {
            writeNull();
        } //End block
        int handle;
        handle = -1;
        {
            handle = dumpCycle(object);
        } //End block
        Class<?> objClass;
        objClass = object.getClass();
        ObjectStreamClass clDesc;
        clDesc = ObjectStreamClass.lookupStreamClass(objClass);
        nestedLevels++;
        try 
        {
            {
                {
                    int var03DC2DFE7C02913FC1673669D906BC5B_684605504 = (writeNewClass((Class<?>) object, unshared));
                } //End block
                {
                    int varC3CC10F969943AFBE108A1A268D705C6_223648138 = (writeClassDesc((ObjectStreamClass) object, unshared));
                } //End block
            } //End block
            {
                boolean varE7B8CBB4833F9EF50D3F1D3538BBECE2_537001462 = (clDesc.isSerializable() && computeClassBasedReplacement);
                {
                    {
                        boolean var775B98B4F037E7450FEE06BFB5F0FF67_800191390 = (clDesc.hasMethodWriteReplace());
                        {
                            Method methodWriteReplace;
                            methodWriteReplace = clDesc.getMethodWriteReplace();
                            Object replObj;
                            replObj = null;
                            try 
                            {
                                replObj = methodWriteReplace.invoke(object, (Object[]) null);
                            } //End block
                            catch (IllegalAccessException iae)
                            {
                                replObj = object;
                            } //End block
                            catch (InvocationTargetException ite)
                            {
                                Throwable target;
                                target = ite.getTargetException();
                                {
                                	if (DroidSafeAndroidRuntime.control) throw (ObjectStreamException) target;
                                } //End block
                                {
                                	if (DroidSafeAndroidRuntime.control) throw (Error) target;
                                } //End block
                                {
                                    throw (RuntimeException) target;
                                } //End block
                            } //End block
                            {
                                int replacementHandle;
                                replacementHandle = writeObjectInternal(replObj, false, false,
                                computeStreamReplacement);
                                {
                                    objectsWritten.put(object, replacementHandle);
                                } //End block
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                Object streamReplacement;
                streamReplacement = replaceObject(object);
                {
                    int replacementHandle;
                    replacementHandle = writeObjectInternal(streamReplacement, false,
                            computeClassBasedReplacement, false);
                    {
                        objectsWritten.put(object, replacementHandle);
                    } //End block
                } //End block
            } //End block
            {
                int var30E337308724EA8CCF56A35FC82C48E6_1166962196 = (writeNewClass((Class<?>) object, unshared));
            } //End block
            {
                int var12A6A291982902D131DB19435711486F_1413036297 = (writeClassDesc((ObjectStreamClass) object, unshared));
            } //End block
            {
                int var24B3BD556387DC2DB7B550896DF9293E_320014425 = (writeNewString((String) object, unshared));
            } //End block
            {
                boolean var92CA3307B5A88FA2FAC13D4420EE399B_1942575042 = (objClass.isArray());
                {
                    int var97B764340470006881D0F8E43EBC80EC_1484715709 = (writeNewArray(object, objClass, clDesc, objClass
                        .getComponentType(), unshared));
                } //End block
            } //End collapsed parenthetic
            {
                int var8BF421970748AAD570ED2D8E1AD55579_705468728 = (writeNewEnum(object, objClass, unshared));
            } //End block
            int varF6E2A31952361B4B8D8105420C69D40C_1448269917 = (writeNewObject(object, objClass, clDesc, unshared));
        } //End block
        finally 
        {
            nestedLevels--;
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.568 -0400", hash_original_method = "23E7E12F7C58661823B132165D2AB697", hash_generated_method = "4D05F9806265172AC5E4058C98049BF3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ObjectStreamClass writeEnumDesc(Class<?> theClass, ObjectStreamClass classDesc, boolean unshared) throws IOException {
        dsTaint.addTaint(unshared);
        dsTaint.addTaint(theClass.dsTaint);
        dsTaint.addTaint(classDesc.dsTaint);
        classDesc.setFlags((byte) (SC_SERIALIZABLE | SC_ENUM));
        int previousHandle;
        previousHandle = -1;
        {
            previousHandle = objectsWritten.get(classDesc);
        } //End block
        int handle;
        handle = -1;
        {
            handle = dumpCycle(classDesc);
        } //End block
        {
            Class<?> classToWrite;
            classToWrite = classDesc.forClass();
            registerObjectWritten(classDesc);
            output.writeByte(TC_CLASSDESC);
            {
                writeNewClassDesc(classDesc);
            } //End block
            {
                primitiveTypes = output;
                writeClassDescriptor(classDesc);
                primitiveTypes = null;
            } //End block
            annotateClass(classToWrite);
            drain();
            output.writeByte(TC_ENDBLOCKDATA);
            ObjectStreamClass superClassDesc;
            superClassDesc = classDesc.getSuperclass();
            {
                superClassDesc.setFlags((byte) (SC_SERIALIZABLE | SC_ENUM));
                writeEnumDesc(superClassDesc.forClass(), superClassDesc, unshared);
            } //End block
            {
                output.writeByte(TC_NULL);
            } //End block
            {
                removeUnsharedReference(classDesc, previousHandle);
            } //End block
        } //End block
        return (ObjectStreamClass)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.568 -0400", hash_original_method = "C81760408EA928607A5B6FF41AD80929", hash_generated_method = "B375F001B3282FD547C908FDDEE15FD5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int writeNewEnum(Object object, Class<?> theClass, boolean unshared) throws IOException {
        dsTaint.addTaint(unshared);
        dsTaint.addTaint(theClass.dsTaint);
        dsTaint.addTaint(object.dsTaint);
        EmulatedFieldsForDumping originalCurrentPutField;
        originalCurrentPutField = currentPutField;
        currentPutField = null;
        output.writeByte(TC_ENUM);
        {
            boolean var1DBE53BAB18403D4198EAFD70D767A2A_1694103041 = (theClass != null && !theClass.isEnum());
            {
                theClass = theClass.getSuperclass();
            } //End block
        } //End collapsed parenthetic
        ObjectStreamClass classDesc;
        classDesc = ObjectStreamClass.lookup(theClass);
        writeEnumDesc(theClass, classDesc, unshared);
        int previousHandle;
        previousHandle = -1;
        {
            previousHandle = objectsWritten.get(object);
        } //End block
        int handle;
        handle = registerObjectWritten(object);
        ObjectStreamField[] fields;
        fields = classDesc.getSuperclass().fields();
        {
            Field field;
            field = classDesc.getSuperclass().getReflectionField(fields[1]);
            {
            	if (DroidSafeAndroidRuntime.control) throw new NoSuchFieldError();
            } //End block
            try 
            {
                String str;
                str = (String) field.get(object);
                int strHandle;
                strHandle = -1;
                {
                    strHandle = dumpCycle(str);
                } //End block
                {
                    writeNewString(str, unshared);
                } //End block
            } //End block
            catch (IllegalAccessException iae)
            {
                throw new AssertionError(iae);
            } //End block
        } //End block
        {
            removeUnsharedReference(object, previousHandle);
        } //End block
        currentPutField = originalCurrentPutField;
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.569 -0400", hash_original_method = "10EDB7023EA5060FBBA4CCA483056F88", hash_generated_method = "37228B6F6DC9BFF2ED6D7B3F8048479D")
    @DSModeled(DSC.SAFE)
    protected void writeObjectOverride(Object object) throws IOException {
        dsTaint.addTaint(object.dsTaint);
        {
            throw new IOException();
        } //End block
        // ---------- Original Method ----------
        //if (!subclassOverridingImplementation) {
            //throw new IOException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.569 -0400", hash_original_method = "F969E0C742AA855339F3D16852D29508", hash_generated_method = "1DF2AC8B267611536F6A0388EAE00862")
    @DSModeled(DSC.SAFE)
    public void writeShort(int value) throws IOException {
        dsTaint.addTaint(value);
        checkWritePrimitiveTypes();
        primitiveTypes.writeShort(value);
        // ---------- Original Method ----------
        //checkWritePrimitiveTypes();
        //primitiveTypes.writeShort(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.569 -0400", hash_original_method = "EEF09F25018D316A37E59FEE3B6D335C", hash_generated_method = "B2FB46082C631C391407546106CCD545")
    @DSModeled(DSC.SAFE)
    protected void writeStreamHeader() throws IOException {
        output.writeShort(STREAM_MAGIC);
        output.writeShort(STREAM_VERSION);
        // ---------- Original Method ----------
        //output.writeShort(STREAM_MAGIC);
        //output.writeShort(STREAM_VERSION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.569 -0400", hash_original_method = "BDFE9F98A4288C3F1994A443E4A70C5E", hash_generated_method = "6EDEC7368226536DC23580FFAAA4092A")
    @DSModeled(DSC.SAFE)
    public void writeUTF(String value) throws IOException {
        dsTaint.addTaint(value);
        checkWritePrimitiveTypes();
        primitiveTypes.writeUTF(value);
        // ---------- Original Method ----------
        //checkWritePrimitiveTypes();
        //primitiveTypes.writeUTF(value);
    }

    
    public static abstract class PutField {
        
        public abstract void put(String name, boolean value);

        
        public abstract void put(String name, char value);

        
        public abstract void put(String name, byte value);

        
        public abstract void put(String name, short value);

        
        public abstract void put(String name, int value);

        
        public abstract void put(String name, long value);

        
        public abstract void put(String name, float value);

        
        public abstract void put(String name, double value);

        
        public abstract void put(String name, Object value);

        
                @Deprecated
public abstract void write(ObjectOutput out) throws IOException;

        
    }


    
}


