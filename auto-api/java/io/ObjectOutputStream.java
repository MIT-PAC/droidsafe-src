package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.423 -0400", hash_original_field = "993B80B15181215612E5959DB832BFAF", hash_generated_field = "123C8BF62BBC79B951F58B358976C3FF")

    private int nestedLevels;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.423 -0400", hash_original_field = "78E6221F6393D1356681DB398F14CE6D", hash_generated_field = "590E14C0A9F44251F0FB79AFE6C14C40")

    private DataOutputStream output;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.423 -0400", hash_original_field = "03DDC0A152AEFF5D5B68BBDEC321A200", hash_generated_field = "F1F4A3D364C39A7A9A580E729A07A6BB")

    private boolean enableReplace;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.423 -0400", hash_original_field = "8AFA05430C7155E00832EE4E25A1E3C4", hash_generated_field = "6BF0D260FF82B6C05AF71BF5A37B87B5")

    private DataOutputStream primitiveTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.423 -0400", hash_original_field = "7D062238F7FC2C195C068FDEA51EBB31", hash_generated_field = "C2484DFB497796B6143E78C11005E43D")

    private ByteArrayOutputStream primitiveTypesBuffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.423 -0400", hash_original_field = "7E94EA9D58B111BA23AC3FB428F74A83", hash_generated_field = "262F0B6D79DA047EE0A946998A1A0FC4")

    private SerializationHandleMap objectsWritten;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.423 -0400", hash_original_field = "C45E486F5C7342BCA6166748B65C5058", hash_generated_field = "C5955C97495D41B971B03A33B3C5833F")

    private int currentHandle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.423 -0400", hash_original_field = "895D2E18F5D2EA8F00F48DF2FB178E4D", hash_generated_field = "76736C274255A46E2AEB2CE593A1B428")

    private Object currentObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.423 -0400", hash_original_field = "457C5912366BE090D6A2931DE14CDA9E", hash_generated_field = "7035F4B44BC3AE389D42445F7A5655AC")

    private ObjectStreamClass currentClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.423 -0400", hash_original_field = "E5EB1B1AE3E23C45B744E3125FC5B3E7", hash_generated_field = "12864838116848C83740597D611280DC")

    private int protocolVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.423 -0400", hash_original_field = "A5B4A58CBBF31F1191BB3A837E942322", hash_generated_field = "DC52C2D606BFFEEFCE39D0BD7D3DAA23")

    private StreamCorruptedException nestedException;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.423 -0400", hash_original_field = "082319488FBB4C6351DC6A16092AFAF8", hash_generated_field = "BAD28CAA59CF68A4E344ADB2A9F8D573")

    private EmulatedFieldsForDumping currentPutField;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.423 -0400", hash_original_field = "35C5D5BAEC9DA39A210149CA5A667705", hash_generated_field = "3690401F10D38FF2C8AB1C19B641B107")

    private boolean subclassOverridingImplementation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.423 -0400", hash_original_field = "D72F32CD409B6D11024B4617D66F549C", hash_generated_field = "A52DE6D705A0478FBD8E858BFAC127CD")

    private final ObjectStreamClass proxyClassDesc = ObjectStreamClass.lookup(Proxy.class);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.423 -0400", hash_original_method = "EA89A37EA944EE797F4A4E71C06BB807", hash_generated_method = "1DD7286A5E2A9A1C12E3BB1E02964B00")
    protected  ObjectOutputStream() throws IOException {
        this.subclassOverridingImplementation = true;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.424 -0400", hash_original_method = "C3742BF53888E5C7E36BAC1682B0BA91", hash_generated_method = "ADB47BA9803E2B0CD7AB1B1691A42C1B")
    public  ObjectOutputStream(OutputStream output) throws IOException {
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
        
        
                
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.424 -0400", hash_original_method = "2EE844E85177CE8B8519EE788449061C", hash_generated_method = "1E11D11D51E0154BB7749FEDA5280BAF")
    protected void annotateClass(Class<?> aClass) throws IOException {
        addTaint(aClass.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.424 -0400", hash_original_method = "6D36FCC856EE4705ED65F6105201ADD2", hash_generated_method = "A5E98127E91E49198B235D1BD1806995")
    protected void annotateProxyClass(Class<?> aClass) throws IOException {
        addTaint(aClass.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.424 -0400", hash_original_method = "73D4A72122980F7DB50B81D978D62054", hash_generated_method = "440B0A02392E0E8C353DCCF410DD591A")
    private void checkWritePrimitiveTypes() {
        {
            primitiveTypesBuffer = new ByteArrayOutputStream(128);
            primitiveTypes = new DataOutputStream(primitiveTypesBuffer);
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.424 -0400", hash_original_method = "29115934C3EAEF8AC600D579304D0581", hash_generated_method = "F0440CBBA87C0B5AF39639A20DAAA699")
    @Override
    public void close() throws IOException {
        flush();
        output.close();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.425 -0400", hash_original_method = "75FABBE0CA8F03B34490087B8F17BDC1", hash_generated_method = "70B8FCB927EA2A43EC259740055018B9")
    private void computePutField() {
        currentPutField = new EmulatedFieldsForDumping(this, currentClass);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.425 -0400", hash_original_method = "F6C293AC5437F7F079C554EABDD8D443", hash_generated_method = "BA54EEA7181CC8C979E6BBE706AAF303")
    public void defaultWriteObject() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NotActiveException();
        } 
        writeFieldValues(currentObject, currentClass);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.425 -0400", hash_original_method = "A89FD6C60365B1028CEBCCFC3106EF9A", hash_generated_method = "EAAFF412511E06C6797C626CAD20A2C7")
    protected void drain() throws IOException {
        int offset = 0;
        byte[] written = primitiveTypesBuffer.toByteArray();
        {
            int toWrite;
            toWrite = 1024;
            toWrite = written.length - offset;
            {
                output.writeByte(TC_BLOCKDATA);
                output.writeByte((byte) toWrite);
            } 
            {
                output.writeByte(TC_BLOCKDATALONG);
                output.writeInt(toWrite);
            } 
            output.write(written, offset, toWrite);
            offset += toWrite;
        } 
        primitiveTypes = null;
        primitiveTypesBuffer = null;
        
        
            
        
        
        
        
            
                    
            
                
                
            
                
                
            
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.426 -0400", hash_original_method = "3C81D15CCFEF1BE19C0E53EB7F3B0380", hash_generated_method = "AB123CF013CB2D38B448BFA3F16DFB41")
    private int dumpCycle(Object obj) throws IOException {
        int handle = objectsWritten.get(obj);
        {
            writeCyclicReference(handle);
        } 
        addTaint(obj.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_6483747 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_6483747;
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.427 -0400", hash_original_method = "7186A696463687F53D4FA37D2BB9631D", hash_generated_method = "7487A6C91019A1371D9412D151C05E4B")
    protected boolean enableReplaceObject(boolean enable) {
        boolean originalValue = enableReplace;
        enableReplace = enable;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_602912100 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_602912100;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.427 -0400", hash_original_method = "117A95892DAF31A0926F2E917E5208CF", hash_generated_method = "D7617F4AFE8FFDEE4B1014AA8B651BC6")
    @Override
    public void flush() throws IOException {
        drain();
        output.flush();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static Object getFieldL(Object instance, Class<?> declaringClass, String fieldName, String fieldTypeName) {
    	return new Object();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.428 -0400", hash_original_method = "3E8C44E06770B18C136965DDB10C163B", hash_generated_method = "4E83B3BA0B59ECC4CF3489D93F87D3F0")
    private int nextHandle() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2051380425 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2051380425;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.429 -0400", hash_original_method = "4F3CF2DA9583C39D0A0D02BEFFFE8C29", hash_generated_method = "B35BA328C63FC933509E354F0B6C5061")
    public PutField putFields() throws IOException {
        PutField varB4EAC82CA7396A68D541C85D26508E83_916122779 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new NotActiveException();
        } 
        {
            computePutField();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_916122779 = currentPutField;
        varB4EAC82CA7396A68D541C85D26508E83_916122779.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_916122779;
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.429 -0400", hash_original_method = "6CA6FC4D83D22ECC70837B9572B0E8EA", hash_generated_method = "DB667C8C813D278D9EE376C74C717F2F")
    private int registerObjectWritten(Object obj) {
        int handle = nextHandle();
        objectsWritten.put(obj, handle);
        addTaint(obj.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_783940216 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_783940216;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.430 -0400", hash_original_method = "37FD060D4B2DB7C3EC8F52EA51C77D72", hash_generated_method = "107250B359BDEDA96B66919E649C145D")
    private void removeUnsharedReference(Object obj, int previousHandle) {
        {
            objectsWritten.put(obj, previousHandle);
        } 
        {
            objectsWritten.remove(obj);
        } 
        addTaint(obj.getTaint());
        addTaint(previousHandle);
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.430 -0400", hash_original_method = "C1DF94E02684AF79BBD267850463E92A", hash_generated_method = "9032F1673B502F05489A10033FBD6430")
    protected Object replaceObject(Object object) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_578069854 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_578069854 = object;
        addTaint(object.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_578069854.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_578069854;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.430 -0400", hash_original_method = "4FDA9D292F9CB60FE54E9147043F29DF", hash_generated_method = "6D8F2E55E577BC7432D57217289F254D")
    public void reset() throws IOException {
        drain();
        output.writeByte(TC_RESET);
        resetState();
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.430 -0400", hash_original_method = "CB42E7CB8763CADF528182B203F4731A", hash_generated_method = "D96F2EB71665704EA1C136EB6CF94503")
    private void resetSeenObjects() {
        objectsWritten = new SerializationHandleMap();
        currentHandle = baseWireHandle;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.431 -0400", hash_original_method = "27ED7D7B38D4C22EF7056E4BAF81440E", hash_generated_method = "30020D9976D36222FB26C8D68A57D7B1")
    private void resetState() {
        resetSeenObjects();
        nestedLevels = 0;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.431 -0400", hash_original_method = "899849124785B3DAA2410A481AC243A4", hash_generated_method = "6A3EBD5BE5D0446BF970F91147D5C075")
    public void useProtocolVersion(int version) throws IOException {
        {
            boolean varECECE5172FBA187AE03F784B354A8EDD_1970176635 = (!objectsWritten.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Cannot set protocol version when stream in use");
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown protocol: " + version);
        } 
        protocolVersion = version;
        
        
            
        
        
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.431 -0400", hash_original_method = "4335176A8BF0CB76C8983C14BE755AB0", hash_generated_method = "8A0656ED731272D7750E1EFE7AB01C78")
    @Override
    public void write(byte[] buffer, int offset, int length) throws IOException {
        checkWritePrimitiveTypes();
        primitiveTypes.write(buffer, offset, length);
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(length);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.431 -0400", hash_original_method = "890E7ADC76A0934752F791BA928637BD", hash_generated_method = "8D45BE443DD7BFA246A1989B0CB0CB96")
    @Override
    public void write(int value) throws IOException {
        checkWritePrimitiveTypes();
        primitiveTypes.write(value);
        addTaint(value);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.432 -0400", hash_original_method = "253E21281D84BB4AEC7BC00A39E22928", hash_generated_method = "C96ED93015FA9A2B1EA467601506AD79")
    public void writeBoolean(boolean value) throws IOException {
        checkWritePrimitiveTypes();
        primitiveTypes.writeBoolean(value);
        addTaint(value);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.432 -0400", hash_original_method = "DCBF5513EE5F9BB37CF570D282A66C5E", hash_generated_method = "3B478B9AF589177865D89542FD608088")
    public void writeByte(int value) throws IOException {
        checkWritePrimitiveTypes();
        primitiveTypes.writeByte(value);
        addTaint(value);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.432 -0400", hash_original_method = "2FD9E25E34EBC831C98FBB1774A09056", hash_generated_method = "7BC149DA0903F6B94C18F6D4283BEF1E")
    public void writeBytes(String value) throws IOException {
        checkWritePrimitiveTypes();
        primitiveTypes.writeBytes(value);
        addTaint(value.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.432 -0400", hash_original_method = "A70BC61472A0A40B7DA1B300459E269C", hash_generated_method = "8A1B3096D3330315ADF5DA7F302B7D2D")
    public void writeChar(int value) throws IOException {
        checkWritePrimitiveTypes();
        primitiveTypes.writeChar(value);
        addTaint(value);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.433 -0400", hash_original_method = "2819E1113D5EFA42F2CF8A185C5FE232", hash_generated_method = "CE7B1CF5DBFE2C8840DD5EAEE0DCCB45")
    public void writeChars(String value) throws IOException {
        checkWritePrimitiveTypes();
        primitiveTypes.writeChars(value);
        addTaint(value.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.433 -0400", hash_original_method = "D6DF6A35D187C3B8A220F04225A24DB7", hash_generated_method = "41477EE75FDFD4229FE262B10910376D")
    private int writeClassDesc(ObjectStreamClass classDesc, boolean unshared) throws IOException {
        {
            writeNull();
        } 
        int handle = -1;
        {
            handle = dumpCycle(classDesc);
        } 
        {
            Class<?> classToWrite = classDesc.forClass();
            int previousHandle = -1;
            {
                previousHandle = objectsWritten.get(classDesc);
            } 
            handle = registerObjectWritten(classDesc);
            {
                boolean var7E6F01091A347CE0B7E67A74C6AFA496_2004678016 = (classDesc.isProxy());
                {
                    output.writeByte(TC_PROXYCLASSDESC);
                    Class<?>[] interfaces = classToWrite.getInterfaces();
                    output.writeInt(interfaces.length);
                    {
                        int i = 0;
                        {
                            output.writeUTF(interfaces[i].getName());
                        } 
                    } 
                    annotateProxyClass(classToWrite);
                    output.writeByte(TC_ENDBLOCKDATA);
                    writeClassDesc(proxyClassDesc, false);
                    {
                        removeUnsharedReference(classDesc, previousHandle);
                    } 
                } 
            } 
            output.writeByte(TC_CLASSDESC);
            {
                writeNewClassDesc(classDesc);
            } 
            {
                primitiveTypes = output;
                writeClassDescriptor(classDesc);
                primitiveTypes = null;
            } 
            annotateClass(classToWrite);
            drain();
            output.writeByte(TC_ENDBLOCKDATA);
            writeClassDesc(classDesc.getSuperclass(), unshared);
            {
                removeUnsharedReference(classDesc, previousHandle);
            } 
        } 
        addTaint(classDesc.getTaint());
        addTaint(unshared);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1772911366 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1772911366;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.434 -0400", hash_original_method = "6CD4D6A26A6EE5C2333CE9BAD2D29100", hash_generated_method = "0CB1ED2E731809BD4C0FD6D11636328D")
    private void writeCyclicReference(int handle) throws IOException {
        output.writeByte(TC_REFERENCE);
        output.writeInt(handle);
        addTaint(handle);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.434 -0400", hash_original_method = "02DC35912BAFF16550D8FBDB82DDCD50", hash_generated_method = "F60D3BB9151846386F88836D11E516E8")
    public void writeDouble(double value) throws IOException {
        checkWritePrimitiveTypes();
        primitiveTypes.writeDouble(value);
        addTaint(value);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.434 -0400", hash_original_method = "8DAE1373FC5F31DAE45B98A018C14CB9", hash_generated_method = "10098DDFFBB6FA1733F96086D952F3CE")
    private void writeFieldDescriptors(ObjectStreamClass classDesc, boolean externalizable) throws IOException {
        Class<?> loadedClass = classDesc.forClass();
        ObjectStreamField[] fields = null;
        int fieldCount = 0;
        {
            fields = classDesc.fields();
            fieldCount = fields.length;
        } 
        output.writeShort(fieldCount);
        {
            int i = 0;
            {
                ObjectStreamField f = fields[i];
                boolean wasPrimitive = f.writeField(output);
                {
                    writeObject(f.getTypeString());
                } 
            } 
        } 
        addTaint(classDesc.getTaint());
        addTaint(externalizable);
        
        
        
        
        
            
            
        
        
        
            
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.435 -0400", hash_original_method = "851EC9DCB527C64AF85B9AAA86ABFF43", hash_generated_method = "ADEADC943D839639EB48C3082549196B")
    public void writeFields() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NotActiveException();
        } 
        writeFieldValues(currentPutField);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.446 -0400", hash_original_method = "97B3D4C0A2A3E17C88F2E6B51B15BF4C", hash_generated_method = "79AC12ADF58731628BEB39357635DED6")
    private void writeFieldValues(EmulatedFieldsForDumping emulatedFields) throws IOException {
        EmulatedFields accessibleSimulatedFields = emulatedFields.emulatedFields();
        {
            EmulatedFields.ObjectSlot slot = accessibleSimulatedFields.slots()[0];
            {
                Object fieldValue = slot.getFieldValue();
                Class<?> type = slot.getField().getType();
                {
                    output.writeInt(fieldValue != null ? ((Integer) fieldValue).intValue() : 0);
                } 
                {
                    output.writeByte(fieldValue != null ? ((Byte) fieldValue).byteValue() : 0);
                } 
                {
                    output.writeChar(fieldValue != null ? ((Character) fieldValue).charValue() : 0);
                } 
                {
                    output.writeShort(fieldValue != null ? ((Short) fieldValue).shortValue() : 0);
                } 
                {
                    output.writeBoolean(fieldValue != null ? ((Boolean) fieldValue).booleanValue() : false);
                } 
                {
                    output.writeLong(fieldValue != null ? ((Long) fieldValue).longValue() : 0);
                } 
                {
                    output.writeFloat(fieldValue != null ? ((Float) fieldValue).floatValue() : 0);
                } 
                {
                    output.writeDouble(fieldValue != null ? ((Double) fieldValue).doubleValue() : 0);
                } 
                {
                    writeObject(fieldValue);
                } 
            } 
        } 
        addTaint(emulatedFields.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.464 -0400", hash_original_method = "3B2F054C3660B4FEDDE0689C3B0D847B", hash_generated_method = "239789AB888A5EA2B05D4E79E33AFFFD")
    private void writeFieldValues(Object obj, ObjectStreamClass classDesc) throws IOException {
        {
            ObjectStreamField fieldDesc = classDesc.fields()[0];
            {
                try 
                {
                    Class<?> type = fieldDesc.getTypeInternal();
                    Field field = classDesc.getReflectionField(fieldDesc);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new InvalidClassException(classDesc.getName() + " doesn't have a field " + fieldDesc.getName() + " of type " + type);
                    } 
                    {
                        output.writeByte(field.getByte(obj));
                    } 
                    {
                        output.writeChar(field.getChar(obj));
                    } 
                    {
                        output.writeDouble(field.getDouble(obj));
                    } 
                    {
                        output.writeFloat(field.getFloat(obj));
                    } 
                    {
                        output.writeInt(field.getInt(obj));
                    } 
                    {
                        output.writeLong(field.getLong(obj));
                    } 
                    {
                        output.writeShort(field.getShort(obj));
                    } 
                    {
                        output.writeBoolean(field.getBoolean(obj));
                    } 
                    {
                        Object objField = field.get(obj);
                        {
                            boolean varAE9A15FF7D7FA17920F64E5223326273_1896144437 = (fieldDesc.isUnshared());
                            {
                                writeUnshared(objField);
                            } 
                            {
                                writeObject(objField);
                            } 
                        } 
                    } 
                } 
                catch (IllegalAccessException iae)
                {
                    if (DroidSafeAndroidRuntime.control) throw new AssertionError(iae);
                } 
                catch (NoSuchFieldError nsf)
                {
                    if (DroidSafeAndroidRuntime.control) throw new InvalidClassException(classDesc.getName());
                } 
            } 
        } 
        addTaint(obj.getTaint());
        addTaint(classDesc.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.465 -0400", hash_original_method = "2F0CF28A5E4A8655D2779BA683FB03E5", hash_generated_method = "7847E956A28B2AF2BC9FFA7E3B237E43")
    public void writeFloat(float value) throws IOException {
        checkWritePrimitiveTypes();
        primitiveTypes.writeFloat(value);
        addTaint(value);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.466 -0400", hash_original_method = "6C93D0A9BF9141DB46D3843027575223", hash_generated_method = "A85D8013B9FBE0437A82E37318F40835")
    private void writeHierarchy(Object object, ObjectStreamClass classDesc) throws IOException, NotActiveException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NotActiveException();
        } 
        List<ObjectStreamClass> hierarchy = classDesc.getHierarchy();
        {
            int i = 0;
            int end = hierarchy.size();
            {
                ObjectStreamClass osc = hierarchy.get(i);
                currentObject = object;
                currentClass = osc;
                try 
                {
                    boolean executed = false;
                    {
                        boolean varC81C7967814EA5E627DC6F37ACE592C1_1579894335 = (osc.hasMethodWriteObject());
                        {
                            final Method method = osc.getMethodWriteObject();
                            try 
                            {
                                method.invoke(object, new Object[] { this });
                                executed = true;
                            } 
                            catch (InvocationTargetException e)
                            {
                                Throwable ex = e.getTargetException();
                                {
                                    if (DroidSafeAndroidRuntime.control) throw (RuntimeException) ex;
                                } 
                                {
                                    if (DroidSafeAndroidRuntime.control) throw (Error) ex;
                                } 
                                if (DroidSafeAndroidRuntime.control) throw (IOException) ex;
                            } 
                            catch (IllegalAccessException e)
                            {
                                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e.toString());
                            } 
                        } 
                    } 
                    {
                        drain();
                        output.writeByte(TC_ENDBLOCKDATA);
                    } 
                    {
                        defaultWriteObject();
                    } 
                } 
                finally 
                {
                    currentObject = null;
                    currentClass = null;
                    currentPutField = null;
                } 
            } 
        } 
        addTaint(classDesc.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.467 -0400", hash_original_method = "4D560E72502C61E130F3258421731401", hash_generated_method = "CA70AAB6D26944797DD135AF73F689E6")
    public void writeInt(int value) throws IOException {
        checkWritePrimitiveTypes();
        primitiveTypes.writeInt(value);
        addTaint(value);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.467 -0400", hash_original_method = "1C4CA2BE4C70907161A2CF485CB22A3E", hash_generated_method = "D6F182B05D925DB267E732E9E6E8C8EF")
    public void writeLong(long value) throws IOException {
        checkWritePrimitiveTypes();
        primitiveTypes.writeLong(value);
        addTaint(value);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.469 -0400", hash_original_method = "6EA4BE49540BA12319B9F5CA997917E6", hash_generated_method = "DBE497B7C021E434829A697804687C13")
    private int writeNewArray(Object array, Class<?> arrayClass, ObjectStreamClass arrayClDesc,
            Class<?> componentType, boolean unshared) throws IOException {
        output.writeByte(TC_ARRAY);
        writeClassDesc(arrayClDesc, false);
        int handle = nextHandle();
        {
            objectsWritten.put(array, handle);
        } 
        {
            boolean varD34D6340EB041A4E3567A6A53D064A1F_1087728537 = (componentType.isPrimitive());
            {
                {
                    int[] intArray = (int[]) array;
                    output.writeInt(intArray.length);
                    {
                        int i = 0;
                        {
                            output.writeInt(intArray[i]);
                        } 
                    } 
                } 
                {
                    byte[] byteArray = (byte[]) array;
                    output.writeInt(byteArray.length);
                    output.write(byteArray, 0, byteArray.length);
                } 
                {
                    char[] charArray = (char[]) array;
                    output.writeInt(charArray.length);
                    {
                        int i = 0;
                        {
                            output.writeChar(charArray[i]);
                        } 
                    } 
                } 
                {
                    short[] shortArray = (short[]) array;
                    output.writeInt(shortArray.length);
                    {
                        int i = 0;
                        {
                            output.writeShort(shortArray[i]);
                        } 
                    } 
                } 
                {
                    boolean[] booleanArray = (boolean[]) array;
                    output.writeInt(booleanArray.length);
                    {
                        int i = 0;
                        {
                            output.writeBoolean(booleanArray[i]);
                        } 
                    } 
                } 
                {
                    long[] longArray = (long[]) array;
                    output.writeInt(longArray.length);
                    {
                        int i = 0;
                        {
                            output.writeLong(longArray[i]);
                        } 
                    } 
                } 
                {
                    float[] floatArray = (float[]) array;
                    output.writeInt(floatArray.length);
                    {
                        int i = 0;
                        {
                            output.writeFloat(floatArray[i]);
                        } 
                    } 
                } 
                {
                    double[] doubleArray = (double[]) array;
                    output.writeInt(doubleArray.length);
                    {
                        int i = 0;
                        {
                            output.writeDouble(doubleArray[i]);
                        } 
                    } 
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new InvalidClassException("Wrong base type in " + arrayClass.getName());
                } 
            } 
            {
                Object[] objectArray = (Object[]) array;
                output.writeInt(objectArray.length);
                {
                    int i = 0;
                    {
                        writeObject(objectArray[i]);
                    } 
                } 
            } 
        } 
        addTaint(array.getTaint());
        addTaint(arrayClass.getTaint());
        addTaint(arrayClDesc.getTaint());
        addTaint(componentType.getTaint());
        addTaint(unshared);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1646522135 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1646522135;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.470 -0400", hash_original_method = "EFEEB16087FF4E0EE92685A5C26C0D2A", hash_generated_method = "65FCE649128390F4FB2C2C571FFA3C13")
    private int writeNewClass(Class<?> object, boolean unshared) throws IOException {
        output.writeByte(TC_CLASS);
        ObjectStreamClass clDesc = ObjectStreamClass.lookupStreamClass(object);
        {
            boolean varD01EB260C610473CC8B605C36295CA40_703840158 = (clDesc.isEnum());
            {
                writeEnumDesc(object, clDesc, unshared);
            } 
            {
                writeClassDesc(clDesc, unshared);
            } 
        } 
        int handle = nextHandle();
        {
            objectsWritten.put(object, handle);
        } 
        addTaint(object.getTaint());
        addTaint(unshared);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1707220925 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1707220925;
        
        
        
        
            
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.471 -0400", hash_original_method = "8ED9B25450E87C39655806C7FB3946F8", hash_generated_method = "B5C6A1D211A343C5962134D5D6BD0ECD")
    private void writeNewClassDesc(ObjectStreamClass classDesc) throws IOException {
        output.writeUTF(classDesc.getName());
        output.writeLong(classDesc.getSerialVersionUID());
        byte flags = classDesc.getFlags();
        boolean externalizable = classDesc.isExternalizable();
        {
            {
                flags &= NOT_SC_BLOCK_DATA;
            } 
            {
                flags |= SC_BLOCK_DATA;
            } 
        } 
        output.writeByte(flags);
        {
            boolean varD2666245420C5C05B9069DAD5D6B9EEB_400261588 = ((SC_ENUM | SC_SERIALIZABLE) != classDesc.getFlags());
            {
                writeFieldDescriptors(classDesc, externalizable);
            } 
            {
                output.writeShort(0);
            } 
        } 
        addTaint(classDesc.getTaint());
        
        
        
        
        
        
            
                
            
                
            
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.472 -0400", hash_original_method = "641338D73905B8D6D3FE171A8894AADC", hash_generated_method = "608B2DF3FC063B8A1F3510C22F3ECB8E")
    protected void writeClassDescriptor(ObjectStreamClass classDesc) throws IOException {
        writeNewClassDesc(classDesc);
        addTaint(classDesc.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.472 -0400", hash_original_method = "E088B51B3D25E92C7A08790C12EA9546", hash_generated_method = "60B04A95AC7A87D8F8CEB4067FA0C1B8")
    private void writeNewException(Exception ex) throws IOException {
        output.writeByte(TC_EXCEPTION);
        resetSeenObjects();
        writeObjectInternal(ex, false, false, false);
        resetSeenObjects();
        addTaint(ex.getTaint());
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.474 -0400", hash_original_method = "AD17E67664AB2CFE5D575A9D2DBC90D0", hash_generated_method = "ED6BD5C32607B7E32BEE99A2FE491143")
    private int writeNewObject(Object object, Class<?> theClass, ObjectStreamClass clDesc,
            boolean unshared) throws IOException {
        EmulatedFieldsForDumping originalCurrentPutField = currentPutField;
        currentPutField = null;
        boolean externalizable = clDesc.isExternalizable();
        boolean serializable = clDesc.isSerializable();
        {
            if (DroidSafeAndroidRuntime.control) throw new NotSerializableException(theClass.getName());
        } 
        output.writeByte(TC_OBJECT);
        writeClassDesc(clDesc, false);
        int previousHandle = -1;
        {
            previousHandle = objectsWritten.get(object);
        } 
        int handle = registerObjectWritten(object);
        currentObject = object;
        currentClass = clDesc;
        try 
        {
            {
                boolean noBlockData = protocolVersion == PROTOCOL_VERSION_1;
                {
                    primitiveTypes = output;
                } 
                ((Externalizable) object).writeExternal(this);
                {
                    primitiveTypes = null;
                } 
                {
                    drain();
                    output.writeByte(TC_ENDBLOCKDATA);
                } 
            } 
            {
                writeHierarchy(object, currentClass);
            } 
        } 
        finally 
        {
            {
                removeUnsharedReference(object, previousHandle);
            } 
            currentObject = null;
            currentClass = null;
            currentPutField = originalCurrentPutField;
        } 
        addTaint(theClass.getTaint());
        addTaint(unshared);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1999983512 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1999983512;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.474 -0400", hash_original_method = "BE97C7FA5FB694719D79A72C051D442C", hash_generated_method = "526D63E07D47621FD8ADEA259DC28D6E")
    private int writeNewString(String object, boolean unshared) throws IOException {
        long count = ModifiedUtf8.countBytes(object, false);
        byte[] buffer;
        int offset = 0;
        {
            buffer = new byte[1 + SizeOf.SHORT + (int) count];
            buffer[offset++] = TC_STRING;
            Memory.pokeShort(buffer, offset, (short) count, ByteOrder.BIG_ENDIAN);
            offset += SizeOf.SHORT;
        } 
        {
            buffer = new byte[1 + SizeOf.LONG + (int) count];
            buffer[offset++] = TC_LONGSTRING;
            Memory.pokeLong(buffer, offset, count, ByteOrder.BIG_ENDIAN);
            offset += SizeOf.LONG;
        } 
        ModifiedUtf8.encode(buffer, offset, object);
        output.write(buffer, 0, buffer.length);
        int handle = nextHandle();
        {
            objectsWritten.put(object, handle);
        } 
        addTaint(object.getTaint());
        addTaint(unshared);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1263266207 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1263266207;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.475 -0400", hash_original_method = "631D52D34CFE4ABBA41E943E2B7FB044", hash_generated_method = "0225D06056772581205A957FAFF48550")
    private void writeNull() throws IOException {
        output.writeByte(TC_NULL);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.476 -0400", hash_original_method = "D65EE5B0FE82553B53FE321A403242DE", hash_generated_method = "74F7F4EFF238CFAD02D8F176E2BD31C5")
    public final void writeObject(Object object) throws IOException {
        writeObject(object, false);
        addTaint(object.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.477 -0400", hash_original_method = "21591331F2C6632F1308070B9A9FAC52", hash_generated_method = "3B78AD2A900B4F4BBDBFD9BF27DE7527")
    public void writeUnshared(Object object) throws IOException {
        writeObject(object, true);
        addTaint(object.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.477 -0400", hash_original_method = "6135D4458B19CC3120CAE3855FF2BEA8", hash_generated_method = "83D92334D579DCA4BC09375C55428F83")
    private void writeObject(Object object, boolean unshared) throws IOException {
        boolean setOutput = (primitiveTypes == output);
        {
            primitiveTypes = null;
        } 
        {
            writeObjectOverride(object);
        } 
        try 
        {
            drain();
            writeObjectInternal(object, unshared, true, true);
            {
                primitiveTypes = output;
            } 
        } 
        catch (IOException ioEx1)
        {
            {
                try 
                {
                    writeNewException(ioEx1);
                } 
                catch (IOException ioEx2)
                {
                    nestedException.fillInStackTrace();
                    if (DroidSafeAndroidRuntime.control) throw nestedException;
                } 
            } 
            if (DroidSafeAndroidRuntime.control) throw ioEx1;
        } 
        addTaint(object.getTaint());
        addTaint(unshared);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.479 -0400", hash_original_method = "AD80A9CFC14D0263A7F0CECDD085D8B1", hash_generated_method = "AD163083835ACBA1482373711F50430A")
    private int writeObjectInternal(Object object, boolean unshared,
            boolean computeClassBasedReplacement,
            boolean computeStreamReplacement) throws IOException {
        {
            writeNull();
        } 
        int handle = -1;
        {
            handle = dumpCycle(object);
        } 
        Class<?> objClass = object.getClass();
        ObjectStreamClass clDesc = ObjectStreamClass.lookupStreamClass(objClass);
        try 
        {
            {
                {
                    int var03DC2DFE7C02913FC1673669D906BC5B_129626060 = (writeNewClass((Class<?>) object, unshared));
                } 
                {
                    int varC3CC10F969943AFBE108A1A268D705C6_1441287712 = (writeClassDesc((ObjectStreamClass) object, unshared));
                } 
            } 
            {
                boolean varE7B8CBB4833F9EF50D3F1D3538BBECE2_897127300 = (clDesc.isSerializable() && computeClassBasedReplacement);
                {
                    {
                        boolean var775B98B4F037E7450FEE06BFB5F0FF67_971308345 = (clDesc.hasMethodWriteReplace());
                        {
                            Method methodWriteReplace = clDesc.getMethodWriteReplace();
                            Object replObj = null;
                            try 
                            {
                                replObj = methodWriteReplace.invoke(object, (Object[]) null);
                            } 
                            catch (IllegalAccessException iae)
                            {
                                replObj = object;
                            } 
                            catch (InvocationTargetException ite)
                            {
                                Throwable target = ite.getTargetException();
                                {
                                    if (DroidSafeAndroidRuntime.control) throw (ObjectStreamException) target;
                                } 
                                {
                                    if (DroidSafeAndroidRuntime.control) throw (Error) target;
                                } 
                                {
                                    if (DroidSafeAndroidRuntime.control) throw (RuntimeException) target;
                                } 
                            } 
                            {
                                int replacementHandle = writeObjectInternal(replObj, false, false,
                                computeStreamReplacement);
                                {
                                    objectsWritten.put(object, replacementHandle);
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            {
                Object streamReplacement = replaceObject(object);
                {
                    int replacementHandle = writeObjectInternal(streamReplacement, false,
                            computeClassBasedReplacement, false);
                    {
                        objectsWritten.put(object, replacementHandle);
                    } 
                } 
            } 
            {
                int var30E337308724EA8CCF56A35FC82C48E6_1545806539 = (writeNewClass((Class<?>) object, unshared));
            } 
            {
                int var12A6A291982902D131DB19435711486F_1420625493 = (writeClassDesc((ObjectStreamClass) object, unshared));
            } 
            {
                int var24B3BD556387DC2DB7B550896DF9293E_249554004 = (writeNewString((String) object, unshared));
            } 
            {
                boolean var92CA3307B5A88FA2FAC13D4420EE399B_266184891 = (objClass.isArray());
                {
                    int var97B764340470006881D0F8E43EBC80EC_938102809 = (writeNewArray(object, objClass, clDesc, objClass
                        .getComponentType(), unshared));
                } 
            } 
            {
                int var8BF421970748AAD570ED2D8E1AD55579_1310027160 = (writeNewEnum(object, objClass, unshared));
            } 
            int varF6E2A31952361B4B8D8105420C69D40C_2116284671 = (writeNewObject(object, objClass, clDesc, unshared));
        } 
        finally 
        { }
        addTaint(object.getTaint());
        addTaint(unshared);
        addTaint(computeClassBasedReplacement);
        addTaint(computeStreamReplacement);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1133672254 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1133672254;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.480 -0400", hash_original_method = "23E7E12F7C58661823B132165D2AB697", hash_generated_method = "086574C986350366D9BE1D72C3E3AACA")
    private ObjectStreamClass writeEnumDesc(Class<?> theClass, ObjectStreamClass classDesc, boolean unshared) throws IOException {
        ObjectStreamClass varB4EAC82CA7396A68D541C85D26508E83_1460256315 = null; 
        classDesc.setFlags((byte) (SC_SERIALIZABLE | SC_ENUM));
        int previousHandle = -1;
        {
            previousHandle = objectsWritten.get(classDesc);
        } 
        int handle = -1;
        {
            handle = dumpCycle(classDesc);
        } 
        {
            Class<?> classToWrite = classDesc.forClass();
            registerObjectWritten(classDesc);
            output.writeByte(TC_CLASSDESC);
            {
                writeNewClassDesc(classDesc);
            } 
            {
                primitiveTypes = output;
                writeClassDescriptor(classDesc);
                primitiveTypes = null;
            } 
            annotateClass(classToWrite);
            drain();
            output.writeByte(TC_ENDBLOCKDATA);
            ObjectStreamClass superClassDesc = classDesc.getSuperclass();
            {
                superClassDesc.setFlags((byte) (SC_SERIALIZABLE | SC_ENUM));
                writeEnumDesc(superClassDesc.forClass(), superClassDesc, unshared);
            } 
            {
                output.writeByte(TC_NULL);
            } 
            {
                removeUnsharedReference(classDesc, previousHandle);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1460256315 = classDesc;
        addTaint(theClass.getTaint());
        addTaint(classDesc.getTaint());
        addTaint(unshared);
        varB4EAC82CA7396A68D541C85D26508E83_1460256315.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1460256315;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.480 -0400", hash_original_method = "C81760408EA928607A5B6FF41AD80929", hash_generated_method = "B5DB41006CA289ED851C23AD02694CE5")
    private int writeNewEnum(Object object, Class<?> theClass, boolean unshared) throws IOException {
        EmulatedFieldsForDumping originalCurrentPutField = currentPutField;
        currentPutField = null;
        output.writeByte(TC_ENUM);
        {
            boolean var1DBE53BAB18403D4198EAFD70D767A2A_1983736081 = (theClass != null && !theClass.isEnum());
            {
                theClass = theClass.getSuperclass();
            } 
        } 
        ObjectStreamClass classDesc = ObjectStreamClass.lookup(theClass);
        writeEnumDesc(theClass, classDesc, unshared);
        int previousHandle = -1;
        {
            previousHandle = objectsWritten.get(object);
        } 
        int handle = registerObjectWritten(object);
        ObjectStreamField[] fields = classDesc.getSuperclass().fields();
        {
            Field field = classDesc.getSuperclass().getReflectionField(fields[1]);
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchFieldError();
            } 
            try 
            {
                String str = (String) field.get(object);
                int strHandle = -1;
                {
                    strHandle = dumpCycle(str);
                } 
                {
                    writeNewString(str, unshared);
                } 
            } 
            catch (IllegalAccessException iae)
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError(iae);
            } 
        } 
        {
            removeUnsharedReference(object, previousHandle);
        } 
        currentPutField = originalCurrentPutField;
        addTaint(object.getTaint());
        addTaint(theClass.getTaint());
        addTaint(unshared);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1574524044 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1574524044;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.481 -0400", hash_original_method = "10EDB7023EA5060FBBA4CCA483056F88", hash_generated_method = "852551ACD5EBC3A2F468FE9D9D652D72")
    protected void writeObjectOverride(Object object) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException();
        } 
        addTaint(object.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.481 -0400", hash_original_method = "F969E0C742AA855339F3D16852D29508", hash_generated_method = "BE5C985D249C4CE173CA2A3213C373D2")
    public void writeShort(int value) throws IOException {
        checkWritePrimitiveTypes();
        primitiveTypes.writeShort(value);
        addTaint(value);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.481 -0400", hash_original_method = "EEF09F25018D316A37E59FEE3B6D335C", hash_generated_method = "D8A4DBD12CAE08FEEAB12FDF55E7C0A4")
    protected void writeStreamHeader() throws IOException {
        output.writeShort(STREAM_MAGIC);
        output.writeShort(STREAM_VERSION);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.482 -0400", hash_original_method = "BDFE9F98A4288C3F1994A443E4A70C5E", hash_generated_method = "8E9324ED25096749593C2B22C9C69E59")
    public void writeUTF(String value) throws IOException {
        checkWritePrimitiveTypes();
        primitiveTypes.writeUTF(value);
        addTaint(value.getTaint());
        
        
        
    }

    
    public static abstract class PutField {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.482 -0400", hash_original_method = "132782D29A7095A05BCF82A07EC6676D", hash_generated_method = "132782D29A7095A05BCF82A07EC6676D")
        public PutField ()
        {
            
        }


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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.484 -0400", hash_original_field = "6ECD027B3A61FCBD003A2EAA6DF5AF89", hash_generated_field = "EDEC464CFF602399479B5323240F3B9A")

    private static final Class<?>[] WRITE_UNSHARED_PARAM_TYPES = new Class[] { Object.class };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.485 -0400", hash_original_field = "417EE143C8F455BA5CE89255A39DCCAE", hash_generated_field = "94B8CE0A3BE191EC240D9518A5C28538")

    private static final byte NOT_SC_BLOCK_DATA = (byte) (SC_BLOCK_DATA ^ 0xFF);
}

