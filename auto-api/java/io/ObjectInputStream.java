package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import dalvik.system.VMStack;
import java.io.EmulatedFields.ObjectSlot;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import libcore.util.EmptyArray;

public class ObjectInputStream extends InputStream implements ObjectInput, ObjectStreamConstants {
    private InputStream emptyStream = new ByteArrayInputStream(EmptyArray.BYTE);
    private static final Object UNSHARED_OBJ = new Object();
    private boolean hasPushbackTC;
    private byte pushbackTC;
    private int nestedLevels;
    private int nextHandle;
    private DataInputStream input;
    private DataInputStream primitiveTypes;
    private InputStream primitiveData = emptyStream;
    private boolean enableResolve;
    private ArrayList<Object> objectsRead;
    private Object currentObject;
    private ObjectStreamClass currentClass;
    private InputValidationDesc[] validations;
    private boolean subclassOverridingImplementation;
    private ClassLoader callerClassLoader;
    private boolean mustResolve = true;
    private int descriptorHandle = -1;
    private static final HashMap<String, Class<?>> PRIMITIVE_CLASSES = new HashMap<String, Class<?>>();
    private HashMap<Class<?>, List<Class<?>>> cachedSuperclasses = new HashMap<Class<?>, List<Class<?>>>();
    private static final ClassLoader bootstrapLoader = Object.class.getClassLoader();
    private static final ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.527 -0400", hash_original_method = "124623F0922D5D71F912D224AEC5FA85", hash_generated_method = "580FB02BDE561CAF88E4A1C492646B82")
    @DSModeled(DSC.SAFE)
    protected ObjectInputStream() throws IOException {
        this.subclassOverridingImplementation = true;
        // ---------- Original Method ----------
        //this.subclassOverridingImplementation = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.527 -0400", hash_original_method = "15BB4AD74FE576D95ABFC0E40CC8A986", hash_generated_method = "348AF3BE25F271EA0F0BE2A12C71895B")
    @DSModeled(DSC.SAFE)
    public ObjectInputStream(InputStream input) throws StreamCorruptedException, IOException {
        dsTaint.addTaint(input.dsTaint);
        this.input = (input instanceof DataInputStream)
                ? (DataInputStream) input : new DataInputStream(input);
        primitiveTypes = new DataInputStream(this);
        enableResolve = false;
        this.subclassOverridingImplementation = false;
        resetState();
        nestedLevels = 0;
        primitiveData = this.input;
        readStreamHeader();
        primitiveData = emptyStream;
        // ---------- Original Method ----------
        //this.input = (input instanceof DataInputStream)
                //? (DataInputStream) input : new DataInputStream(input);
        //primitiveTypes = new DataInputStream(this);
        //enableResolve = false;
        //this.subclassOverridingImplementation = false;
        //resetState();
        //nestedLevels = 0;
        //primitiveData = this.input;
        //readStreamHeader();
        //primitiveData = emptyStream;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.527 -0400", hash_original_method = "CEC952E1AEB3FC5761C4573EC7C87AAE", hash_generated_method = "6C3F1FCD7C9B40DF330728CDB7A78210")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int available() throws IOException {
        checkReadPrimitiveTypes();
        int var396FA1B30BCA352A1497967EC8829CF5_2110343074 = (primitiveData.available());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkReadPrimitiveTypes();
        //return primitiveData.available();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.527 -0400", hash_original_method = "5DD662298FB99DC11E3F5A1BB4812CC0", hash_generated_method = "A4626B2C1046B53F2F48568C47EC77C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkReadPrimitiveTypes() throws IOException {
        {
            boolean var429099FA06AFA9946D3FE9CA9E9D4FD2_1642359096 = (primitiveData == input || primitiveData.available() > 0);
        } //End collapsed parenthetic
        {
            int next;
            next = 0;
            {
                hasPushbackTC = false;
            } //End block
            {
                next = input.read();
                pushbackTC = (byte) next;
            } //End block
            //Begin case TC_BLOCKDATA 
            primitiveData = new ByteArrayInputStream(readBlockData());
            //End case TC_BLOCKDATA 
            //Begin case TC_BLOCKDATALONG 
            primitiveData = new ByteArrayInputStream(readBlockDataLong());
            //End case TC_BLOCKDATALONG 
            //Begin case TC_RESET 
            resetState();
            //End case TC_RESET 
            //Begin case default 
            {
                pushbackTC();
            } //End block
            //End case default 
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.527 -0400", hash_original_method = "4ECD43BBA7F31E748521530C375A35B5", hash_generated_method = "969BE41D64C6D1C88EE32C1CD63846EA")
    @DSModeled(DSC.SAFE)
    @Override
    public void close() throws IOException {
        input.close();
        // ---------- Original Method ----------
        //input.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.527 -0400", hash_original_method = "6463B95302326251A8E319007FB9B6A5", hash_generated_method = "80748E3DB52F976FDE27B19B5D3E059B")
    @DSModeled(DSC.SAFE)
    public void defaultReadObject() throws IOException, ClassNotFoundException,
            NotActiveException {
        {
            readFieldValues(currentObject, currentClass);
        } //End block
        {
            throw new NotActiveException();
        } //End block
        // ---------- Original Method ----------
        //if (currentObject != null || !mustResolve) {
            //readFieldValues(currentObject, currentClass);
        //} else {
            //throw new NotActiveException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.527 -0400", hash_original_method = "970A975ADDA1CD42A4A6880D40629922", hash_generated_method = "09C1359D7285050352D638BC0F434722")
    @DSModeled(DSC.SAFE)
    protected boolean enableResolveObject(boolean enable) {
        dsTaint.addTaint(enable);
        boolean originalValue;
        originalValue = enableResolve;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean originalValue = enableResolve;
        //enableResolve = enable;
        //return originalValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.528 -0400", hash_original_method = "BEEE4D4B01DB5401D5A386ECF8653C53", hash_generated_method = "FC729AA28482ADBB0428C7098120C9CB")
    @DSModeled(DSC.SAFE)
    private int nextHandle() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nextHandle++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.528 -0400", hash_original_method = "EA84EB3C5ACC30FA1515ABE6938E6E9B", hash_generated_method = "576C8885F3FD225B564625D8A1FF8F2C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private byte nextTC() throws IOException {
        {
            hasPushbackTC = false;
        } //End block
        {
            pushbackTC = input.readByte();
        } //End block
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //if (hasPushbackTC) {
            //hasPushbackTC = false; 
        //} else {
            //pushbackTC = input.readByte();
        //}
        //return pushbackTC;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.528 -0400", hash_original_method = "056AB6ECFECE1087CD6299233C3046CF", hash_generated_method = "0EDDAD9C25969089563460E00DFD8F2B")
    @DSModeled(DSC.SAFE)
    private void pushbackTC() {
        hasPushbackTC = true;
        // ---------- Original Method ----------
        //hasPushbackTC = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.528 -0400", hash_original_method = "87E37984C9E76D351365EC77DA0248F5", hash_generated_method = "4A8694A1CAAE3E55F2CF021E0C567500")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read() throws IOException {
        checkReadPrimitiveTypes();
        int varB707721DB93E7A7A4590241126489184_377098901 = (primitiveData.read());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkReadPrimitiveTypes();
        //return primitiveData.read();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.528 -0400", hash_original_method = "7E3B2630C90BBA61B0E7CD83B04481D2", hash_generated_method = "93C500DB4C1498456A1381560EBC6BA1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read(byte[] buffer, int offset, int length) throws IOException {
        dsTaint.addTaint(buffer);
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
        checkReadPrimitiveTypes();
        int var8656D85F3F24DB8757358C0140B597A3_1478540443 = (primitiveData.read(buffer, offset, length));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buffer.length, offset, length);
        //if (length == 0) {
            //return 0;
        //}
        //checkReadPrimitiveTypes();
        //return primitiveData.read(buffer, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.528 -0400", hash_original_method = "35383BB5231F8136A4FECB09DEC2FE93", hash_generated_method = "4C8B315789A2652F9499DA26F6D441C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private byte[] readBlockData() throws IOException {
        byte[] result;
        result = new byte[input.readByte() & 0xff];
        input.readFully(result);
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //byte[] result = new byte[input.readByte() & 0xff];
        //input.readFully(result);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.528 -0400", hash_original_method = "478D7B43D09CD1BAF3CA95670FAE291A", hash_generated_method = "4B23C197A41210CA1352749C7DD069BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private byte[] readBlockDataLong() throws IOException {
        byte[] result;
        result = new byte[input.readInt()];
        input.readFully(result);
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //byte[] result = new byte[input.readInt()];
        //input.readFully(result);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.528 -0400", hash_original_method = "43182B65F59B21B8425D068A4900EB3A", hash_generated_method = "ACDEB7958B21EB7806762285C6562DAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean readBoolean() throws IOException {
        boolean varDCB0861A4BE9F65D653AD47B971965CF_1783640362 = (primitiveTypes.readBoolean());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return primitiveTypes.readBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.528 -0400", hash_original_method = "F1C938A529B536DE0EA7C0848AC19388", hash_generated_method = "C36C968A1AEBB96635D840FB11E6ACEF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte readByte() throws IOException {
        byte varD0FBD5DD4443B7C0CAB658ACAA09D8C9_942804577 = (primitiveTypes.readByte());
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //return primitiveTypes.readByte();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.528 -0400", hash_original_method = "08C7569945A67E2D251F3B449209E666", hash_generated_method = "B925E400E9C089E1AB8B42D650AEB36D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char readChar() throws IOException {
        char var4C12272AC58BE571107F61420B43FEF4_745351042 = (primitiveTypes.readChar());
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return primitiveTypes.readChar();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.528 -0400", hash_original_method = "7E3D613702E21574BA96B289FBA102EA", hash_generated_method = "4F92B451E966EF2ED75024BC7BF1A1ED")
    @DSModeled(DSC.SAFE)
    private void discardData() throws ClassNotFoundException, IOException {
        primitiveData = emptyStream;
        boolean resolve;
        resolve = mustResolve;
        mustResolve = false;
        {
            byte tc;
            tc = nextTC();
            {
                mustResolve = resolve;
            } //End block
            readContent(tc);
        } //End block
        // ---------- Original Method ----------
        //primitiveData = emptyStream;
        //boolean resolve = mustResolve;
        //mustResolve = false;
        //do {
            //byte tc = nextTC();
            //if (tc == TC_ENDBLOCKDATA) {
                //mustResolve = resolve;
                //return; 
            //}
            //readContent(tc);
        //} while (true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.528 -0400", hash_original_method = "8425AE4559FEB283CFFC129B3DDD377F", hash_generated_method = "688C677927B3ECCA787FD48BA1B26ABA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ObjectStreamClass readClassDesc() throws ClassNotFoundException, IOException {
        byte tc;
        tc = nextTC();
        //Begin case TC_CLASSDESC 
        ObjectStreamClass varEFE5DAF34662ADD354013A8B24D89885_1414172464 = (readNewClassDesc(false));
        //End case TC_CLASSDESC 
        //Begin case TC_PROXYCLASSDESC 
        Class<?> proxyClass;
        proxyClass = readNewProxyClassDesc();
        //End case TC_PROXYCLASSDESC 
        //Begin case TC_PROXYCLASSDESC 
        ObjectStreamClass streamClass;
        streamClass = ObjectStreamClass.lookup(proxyClass);
        //End case TC_PROXYCLASSDESC 
        //Begin case TC_PROXYCLASSDESC 
        streamClass.setLoadFields(ObjectStreamClass.NO_FIELDS);
        //End case TC_PROXYCLASSDESC 
        //Begin case TC_PROXYCLASSDESC 
        registerObjectRead(streamClass, nextHandle(), false);
        //End case TC_PROXYCLASSDESC 
        //Begin case TC_PROXYCLASSDESC 
        checkedSetSuperClassDesc(streamClass, readClassDesc());
        //End case TC_PROXYCLASSDESC 
        //Begin case TC_REFERENCE 
        ObjectStreamClass var41AE2590E5AE43F9C604C548CB534E0B_633847085 = ((ObjectStreamClass) readCyclicReference());
        //End case TC_REFERENCE 
        //Begin case default 
        throw corruptStream(tc);
        //End case default 
        return (ObjectStreamClass)dsTaint.getTaint();
        // ---------- Original Method ----------
        //byte tc = nextTC();
        //switch (tc) {
            //case TC_CLASSDESC:
                //return readNewClassDesc(false);
            //case TC_PROXYCLASSDESC:
                //Class<?> proxyClass = readNewProxyClassDesc();
                //ObjectStreamClass streamClass = ObjectStreamClass.lookup(proxyClass);
                //streamClass.setLoadFields(ObjectStreamClass.NO_FIELDS);
                //registerObjectRead(streamClass, nextHandle(), false);
                //checkedSetSuperClassDesc(streamClass, readClassDesc());
                //return streamClass;
            //case TC_REFERENCE:
                //return (ObjectStreamClass) readCyclicReference();
            //case TC_NULL:
                //return null;
            //default:
                //throw corruptStream(tc);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.528 -0400", hash_original_method = "D1B003D7ABBBCEF0B15D64544C91AEEF", hash_generated_method = "2A661B393E00EF57C2EE8A29D09AE083")
    @DSModeled(DSC.SAFE)
    private StreamCorruptedException corruptStream(byte tc) throws StreamCorruptedException {
        dsTaint.addTaint(tc);
        throw new StreamCorruptedException("Wrong format: " + Integer.toHexString(tc & 0xff));
        return (StreamCorruptedException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new StreamCorruptedException("Wrong format: " + Integer.toHexString(tc & 0xff));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.529 -0400", hash_original_method = "EBF146E3B3C2508DCA0D721582A75609", hash_generated_method = "89F88D2B872D39C3EBB04F30BEC1C98F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object readContent(byte tc) throws ClassNotFoundException,
            IOException {
        dsTaint.addTaint(tc);
        //Begin case TC_BLOCKDATA 
        Object var2D12826159AEA92DEDAB1E290EBAB0E0_1587613598 = (readBlockData());
        //End case TC_BLOCKDATA 
        //Begin case TC_BLOCKDATALONG 
        Object var0E4BE706F5AAE349E365D5FADA7500E7_583148251 = (readBlockDataLong());
        //End case TC_BLOCKDATALONG 
        //Begin case TC_CLASS 
        Object var896F24146F9E998E533B4BBD140D2CD1_1359872750 = (readNewClass(false));
        //End case TC_CLASS 
        //Begin case TC_CLASSDESC 
        Object varEFE5DAF34662ADD354013A8B24D89885_771399253 = (readNewClassDesc(false));
        //End case TC_CLASSDESC 
        //Begin case TC_ARRAY 
        Object var39403445DD2FA137B6509AE62C4B742B_1724462582 = (readNewArray(false));
        //End case TC_ARRAY 
        //Begin case TC_OBJECT 
        Object var35E1AE74C4F222DE939E4F4F98D0C24E_828308208 = (readNewObject(false));
        //End case TC_OBJECT 
        //Begin case TC_STRING 
        Object var31B7CEA5C9493591BB0A68C37D5F5B9D_989473548 = (readNewString(false));
        //End case TC_STRING 
        //Begin case TC_LONGSTRING 
        Object varDB6876173628E83ADE7BF242BAF73ECE_381684067 = (readNewLongString(false));
        //End case TC_LONGSTRING 
        //Begin case TC_REFERENCE 
        Object varC9F339D32D92744C9163A6AA959A489C_1393630131 = (readCyclicReference());
        //End case TC_REFERENCE 
        //Begin case TC_EXCEPTION 
        Exception exc;
        exc = readException();
        //End case TC_EXCEPTION 
        //Begin case TC_EXCEPTION 
        throw new WriteAbortedException("Read an exception", exc);
        //End case TC_EXCEPTION 
        //Begin case TC_RESET 
        resetState();
        //End case TC_RESET 
        //Begin case default 
        throw corruptStream(tc);
        //End case default 
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.529 -0400", hash_original_method = "C964F7473D297E2F3A28B1C55493EBEA", hash_generated_method = "4F5B73B61F111A7AFD8A2B4D4E276D3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object readNonPrimitiveContent(boolean unshared) throws ClassNotFoundException, IOException {
        dsTaint.addTaint(unshared);
        checkReadPrimitiveTypes();
        {
            boolean varFE023E46CC4F9239294D15D3ADCB19E2_1838918555 = (primitiveData.available() > 0);
            {
                OptionalDataException e;
                e = new OptionalDataException();
                e.length = primitiveData.available();
                throw e;
            } //End block
        } //End collapsed parenthetic
        {
            byte tc;
            tc = nextTC();
            //Begin case TC_CLASS 
            Object varB3FB1D39699E6D2A442B5D236B57E977_1053464533 = (readNewClass(unshared));
            //End case TC_CLASS 
            //Begin case TC_CLASSDESC 
            Object varDC57314283A93F6AAD1AC02CF35AE81E_1654647055 = (readNewClassDesc(unshared));
            //End case TC_CLASSDESC 
            //Begin case TC_ARRAY 
            Object var9A06C91A900F304B8C4AD583BAF3F655_360131270 = (readNewArray(unshared));
            //End case TC_ARRAY 
            //Begin case TC_OBJECT 
            Object var7739C6CE4DB43D1D0CF968D28B122F01_1600035209 = (readNewObject(unshared));
            //End case TC_OBJECT 
            //Begin case TC_STRING 
            Object varD19DC5B860F0E4F45A456286338A5DF3_1399532644 = (readNewString(unshared));
            //End case TC_STRING 
            //Begin case TC_LONGSTRING 
            Object varB631EAE4A3B125D54449113B508423A0_1826996041 = (readNewLongString(unshared));
            //End case TC_LONGSTRING 
            //Begin case TC_ENUM 
            Object var86DB4B9F76426BBD3FC17213342B35DA_1683662563 = (readEnum(unshared));
            //End case TC_ENUM 
            //Begin case TC_REFERENCE 
            {
                readNewHandle();
                throw new InvalidObjectException("Unshared read of back reference");
            } //End block
            //End case TC_REFERENCE 
            //Begin case TC_REFERENCE 
            Object var271BCD20D7158D56AC0028AF6D4342B2_1823750736 = (readCyclicReference());
            //End case TC_REFERENCE 
            //Begin case TC_EXCEPTION 
            Exception exc;
            exc = readException();
            //End case TC_EXCEPTION 
            //Begin case TC_EXCEPTION 
            throw new WriteAbortedException("Read an exception", exc);
            //End case TC_EXCEPTION 
            //Begin case TC_RESET 
            resetState();
            //End case TC_RESET 
            //Begin case TC_ENDBLOCKDATA 
            pushbackTC();
            //End case TC_ENDBLOCKDATA 
            //Begin case TC_ENDBLOCKDATA 
            OptionalDataException e;
            e = new OptionalDataException();
            //End case TC_ENDBLOCKDATA 
            //Begin case TC_ENDBLOCKDATA 
            e.eof = true;
            //End case TC_ENDBLOCKDATA 
            //Begin case TC_ENDBLOCKDATA 
            throw e;
            //End case TC_ENDBLOCKDATA 
            //Begin case default 
            throw corruptStream(tc);
            //End case default 
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.529 -0400", hash_original_method = "821B45232EA8F88246A504603C8240EF", hash_generated_method = "634FCA21733B42A0A611D08D44BF69D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object readCyclicReference() throws InvalidObjectException, IOException {
        Object var7B9D59D1124BEAE11BB1E4097F27FDBF_771668391 = (registeredObjectRead(readNewHandle()));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return registeredObjectRead(readNewHandle());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.529 -0400", hash_original_method = "7C91F28BD77A4ED641420E614D9FCB15", hash_generated_method = "072919673264B2C18B71C11F500FE143")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public double readDouble() throws IOException {
        double var42D1EAD188298802018D182CA96F7EC6_2084564745 = (primitiveTypes.readDouble());
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return primitiveTypes.readDouble();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.529 -0400", hash_original_method = "BA11A34B6A0BFC2FA522B0508C6E225C", hash_generated_method = "236996CEB5F2254AE9FDC00F87A57A8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Exception readException() throws WriteAbortedException,
            OptionalDataException, ClassNotFoundException, IOException {
        resetSeenObjects();
        Exception exc;
        exc = (Exception) readObject();
        resetSeenObjects();
        return (Exception)dsTaint.getTaint();
        // ---------- Original Method ----------
        //resetSeenObjects();
        //Exception exc = (Exception) readObject();
        //resetSeenObjects();
        //return exc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.530 -0400", hash_original_method = "FA3DFED5FC7EE2104F3E818CA56DCFE9", hash_generated_method = "A095DA0EDAED68021DFE76FBA4663181")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readFieldDescriptors(ObjectStreamClass cDesc) throws ClassNotFoundException, IOException {
        dsTaint.addTaint(cDesc.dsTaint);
        short numFields;
        numFields = input.readShort();
        ObjectStreamField[] fields;
        fields = new ObjectStreamField[numFields];
        cDesc.setLoadFields(fields);
        {
            short i;
            i = 0;
            {
                char typecode;
                typecode = (char) input.readByte();
                String fieldName;
                fieldName = input.readUTF();
                boolean isPrimType;
                isPrimType = ObjectStreamClass.isPrimitiveType(typecode);
                String classSig;
                {
                    classSig = String.valueOf(typecode);
                } //End block
                {
                    boolean old;
                    old = enableResolve;
                    try 
                    {
                        enableResolve = false;
                        classSig = (String) readObject();
                    } //End block
                    finally 
                    {
                        enableResolve = old;
                    } //End block
                } //End block
                classSig = formatClassSig(classSig);
                ObjectStreamField f;
                f = new ObjectStreamField(classSig, fieldName);
                fields[i] = f;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.530 -0400", hash_original_method = "74747FD805E3D37BE3EFCD383C26D2DE", hash_generated_method = "B7968BBB2631E48A86888FD83216759B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.530 -0400", hash_original_method = "35D23573908F6AA48B37BF1647A74D3F", hash_generated_method = "3383AEE93AD3FD278F02C584C98E4653")
    @DSModeled(DSC.SAFE)
    public GetField readFields() throws IOException, ClassNotFoundException, NotActiveException {
        {
            throw new NotActiveException();
        } //End block
        EmulatedFieldsForLoading result;
        result = new EmulatedFieldsForLoading(currentClass);
        readFieldValues(result);
        return (GetField)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (currentObject == null) {
            //throw new NotActiveException();
        //}
        //EmulatedFieldsForLoading result = new EmulatedFieldsForLoading(currentClass);
        //readFieldValues(result);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.530 -0400", hash_original_method = "8289C081F35F5F257A7DE20983B5F39B", hash_generated_method = "438C110AC1FE33DCA1A955E73126387F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readFieldValues(EmulatedFieldsForLoading emulatedFields) throws OptionalDataException, InvalidClassException, IOException {
        dsTaint.addTaint(emulatedFields.dsTaint);
        EmulatedFields.ObjectSlot[] slots;
        slots = emulatedFields.emulatedFields().slots();
        {
            Iterator<ObjectSlot> seatecAstronomy42 = slots.iterator();
            seatecAstronomy42.hasNext();
            ObjectSlot element = seatecAstronomy42.next();
            {
                element.defaulted = false;
                Class<?> type;
                type = element.field.getType();
                {
                    element.fieldValue = input.readInt();
                } //End block
                {
                    element.fieldValue = input.readByte();
                } //End block
                {
                    element.fieldValue = input.readChar();
                } //End block
                {
                    element.fieldValue = input.readShort();
                } //End block
                {
                    element.fieldValue = input.readBoolean();
                } //End block
                {
                    element.fieldValue = input.readLong();
                } //End block
                {
                    element.fieldValue = input.readFloat();
                } //End block
                {
                    element.fieldValue = input.readDouble();
                } //End block
                {
                    try 
                    {
                        element.fieldValue = readObject();
                    } //End block
                    catch (ClassNotFoundException cnf)
                    {
                        throw new InvalidClassException(cnf.toString());
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.531 -0400", hash_original_method = "3FF4AC35875B69602347D8B467CAEB0A", hash_generated_method = "135559CD85F74F7E66AEBC0EC2AC1800")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readFieldValues(Object obj, ObjectStreamClass classDesc) throws OptionalDataException, ClassNotFoundException, IOException {
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(classDesc.dsTaint);
        ObjectStreamField[] fields;
        fields = classDesc.getLoadFields();
        fields = (fields == null) ? ObjectStreamClass.NO_FIELDS : fields;
        Class<?> declaringClass;
        declaringClass = classDesc.forClass();
        {
            throw new ClassNotFoundException(classDesc.getName());
        } //End block
        {
            Iterator<ObjectStreamField> seatecAstronomy42 = fields.iterator();
            seatecAstronomy42.hasNext();
            ObjectStreamField fieldDesc = seatecAstronomy42.next();
            {
                Field field;
                field = classDesc.getReflectionField(fieldDesc);
                try 
                {
                    Class<?> type;
                    type = fieldDesc.getTypeInternal();
                    {
                        byte b;
                        b = input.readByte();
                        {
                            field.setByte(obj, b);
                        } //End block
                    } //End block
                    {
                        char c;
                        c = input.readChar();
                        {
                            field.setChar(obj, c);
                        } //End block
                    } //End block
                    {
                        double d;
                        d = input.readDouble();
                        {
                            field.setDouble(obj, d);
                        } //End block
                    } //End block
                    {
                        float f;
                        f = input.readFloat();
                        {
                            field.setFloat(obj, f);
                        } //End block
                    } //End block
                    {
                        int i;
                        i = input.readInt();
                        {
                            field.setInt(obj, i);
                        } //End block
                    } //End block
                    {
                        long j;
                        j = input.readLong();
                        {
                            field.setLong(obj, j);
                        } //End block
                    } //End block
                    {
                        short s;
                        s = input.readShort();
                        {
                            field.setShort(obj, s);
                        } //End block
                    } //End block
                    {
                        boolean z;
                        z = input.readBoolean();
                        {
                            field.setBoolean(obj, z);
                        } //End block
                    } //End block
                    {
                        Object toSet;
                        boolean varC187ADE01525F471F8592C2BAF193B77_2074318986 = (fieldDesc.isUnshared());
                        toSet = readUnshared();
                        toSet = readObject();
                        {
                            String fieldName;
                            fieldName = fieldDesc.getName();
                            ObjectStreamField localFieldDesc;
                            localFieldDesc = classDesc.getField(fieldName);
                            Class<?> fieldType;
                            fieldType = localFieldDesc.getTypeInternal();
                            Class<?> valueType;
                            valueType = toSet.getClass();
                            {
                                boolean var74C1BEDB7218CB2DF56B6BCB99B9FB95_1394351796 = (!fieldType.isAssignableFrom(valueType));
                                {
                                    throw new ClassCastException(classDesc.getName() + "." + fieldName + " - " + fieldType + " not compatible with " + valueType);
                                } //End block
                            } //End collapsed parenthetic
                            {
                                field.set(obj, toSet);
                            } //End block
                        } //End block
                    } //End block
                } //End block
                catch (IllegalAccessException iae)
                {
                    throw new AssertionError(iae);
                } //End block
                catch (NoSuchFieldError ignored)
                { }
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.531 -0400", hash_original_method = "E7BFAC98C28E1C1B49BD33FC0E76EA53", hash_generated_method = "52F3E8918FF0024B6565E9CF524B9588")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float readFloat() throws IOException {
        float var7E9E584C6FD2DEB4403B27097B587FBB_2060043731 = (primitiveTypes.readFloat());
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return primitiveTypes.readFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.531 -0400", hash_original_method = "917418BB5C848A4690F4E96972002BAD", hash_generated_method = "EE8B23B6F6DAE84C13AFB8256679829D")
    @DSModeled(DSC.SAFE)
    public void readFully(byte[] dst) throws IOException {
        dsTaint.addTaint(dst);
        primitiveTypes.readFully(dst);
        // ---------- Original Method ----------
        //primitiveTypes.readFully(dst);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.531 -0400", hash_original_method = "046EB506BDA13B9ED79306898615169A", hash_generated_method = "3D0236F7F97FDBBF3A5A2BFDC4B51347")
    @DSModeled(DSC.SAFE)
    public void readFully(byte[] dst, int offset, int byteCount) throws IOException {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(dst);
        dsTaint.addTaint(offset);
        primitiveTypes.readFully(dst, offset, byteCount);
        // ---------- Original Method ----------
        //primitiveTypes.readFully(dst, offset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.531 -0400", hash_original_method = "D8B45244A94A62B53D8A8E2E7C864422", hash_generated_method = "150B2D85E3EF32E6B7C562C54C264184")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readHierarchy(Object object, ObjectStreamClass classDesc) throws IOException, ClassNotFoundException, NotActiveException {
        dsTaint.addTaint(object.dsTaint);
        dsTaint.addTaint(classDesc.dsTaint);
        {
            throw new NotActiveException();
        } //End block
        List<ObjectStreamClass> streamClassList;
        streamClassList = classDesc.getHierarchy();
        {
            {
                Iterator<ObjectStreamClass> seatecAstronomy42 = streamClassList.iterator();
                seatecAstronomy42.hasNext();
                ObjectStreamClass objectStreamClass = seatecAstronomy42.next();
                {
                    readObjectForClass(null, objectStreamClass);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            List<Class<?>> superclasses;
            superclasses = cachedSuperclasses.get(object.getClass());
            {
                superclasses = cacheSuperclassesFor(object.getClass());
            } //End block
            int lastIndex;
            lastIndex = 0;
            {
                int i, end;
                i = 0;
                end = superclasses.size();
                {
                    Class<?> superclass;
                    superclass = superclasses.get(i);
                    int index;
                    index = findStreamSuperclass(superclass, streamClassList, lastIndex);
                    {
                        readObjectNoData(object, superclass,
                            ObjectStreamClass.lookupStreamClass(superclass));
                    } //End block
                    {
                        {
                            int j;
                            j = lastIndex;
                            {
                                readObjectForClass(object, streamClassList.get(j));
                            } //End block
                        } //End collapsed parenthetic
                        lastIndex = index + 1;
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.531 -0400", hash_original_method = "F09DF984FD463C1BCDA606260FD08FFE", hash_generated_method = "4DB0933BC40DA53031E06B7AAA75C7F6")
    @DSModeled(DSC.SAFE)
    private List<Class<?>> cacheSuperclassesFor(Class<?> c) {
        dsTaint.addTaint(c.dsTaint);
        ArrayList<Class<?>> result;
        result = new ArrayList<Class<?>>();
        Class<?> nextClass;
        nextClass = c;
        {
            Class<?> testClass;
            testClass = nextClass.getSuperclass();
            {
                result.add(0, nextClass);
            } //End block
            nextClass = testClass;
        } //End block
        cachedSuperclasses.put(c, result);
        return (List<Class<?>>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ArrayList<Class<?>> result = new ArrayList<Class<?>>();
        //Class<?> nextClass = c;
        //while (nextClass != null) {
            //Class<?> testClass = nextClass.getSuperclass();
            //if (testClass != null) {
                //result.add(0, nextClass);
            //}
            //nextClass = testClass;
        //}
        //cachedSuperclasses.put(c, result);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.531 -0400", hash_original_method = "30EFDC31EF83C1843078545357CDA4A5", hash_generated_method = "C31B6B3D461AD66448930F6EC0B568CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int findStreamSuperclass(Class<?> cl, List<ObjectStreamClass> classList, int lastIndex) {
        dsTaint.addTaint(lastIndex);
        dsTaint.addTaint(cl.dsTaint);
        dsTaint.addTaint(classList.dsTaint);
        {
            int i, end;
            i = lastIndex;
            end = classList.size();
            {
                ObjectStreamClass objCl;
                objCl = classList.get(i);
                String forName;
                forName = objCl.forClass().getName();
                {
                    boolean var231414704491DDAEEB5B177CB6BDCCB3_1439966557 = (objCl.getName().equals(forName));
                    {
                        {
                            boolean varB1DEEBE6B0B17CA7084086DE8FDC42C2_1321627618 = (cl.getName().equals(objCl.getName()));
                        } //End collapsed parenthetic
                    } //End block
                    {
                        {
                            boolean var7039F19E84FDA9D92190D2C9D5A9C382_514260538 = (cl.getName().equals(forName));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //for (int i = lastIndex, end = classList.size(); i < end; i++) {
            //ObjectStreamClass objCl = classList.get(i);
            //String forName = objCl.forClass().getName();
            //if (objCl.getName().equals(forName)) {
                //if (cl.getName().equals(objCl.getName())) {
                    //return i;
                //}
            //} else {
                //if (cl.getName().equals(forName)) {
                    //return i;
                //}
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.532 -0400", hash_original_method = "868BCCA0967481794CFA1D8D3E56D3E6", hash_generated_method = "F1A4753553B61FC69A66F689B1B8FB89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObjectNoData(Object object, Class<?> cl, ObjectStreamClass classDesc) throws ObjectStreamException {
        dsTaint.addTaint(cl.dsTaint);
        dsTaint.addTaint(object.dsTaint);
        dsTaint.addTaint(classDesc.dsTaint);
        {
            boolean varC6302AF1FA07AAAD1767E048D3B78E8B_844828651 = (!classDesc.isSerializable());
        } //End collapsed parenthetic
        {
            boolean var6FEFF8B6EB65DC0C85ADA74F8DE4B91F_1415100759 = (classDesc.hasMethodReadObjectNoData());
            {
                final Method readMethod;
                readMethod = classDesc.getMethodReadObjectNoData();
                try 
                {
                    readMethod.invoke(object);
                } //End block
                catch (InvocationTargetException e)
                {
                    Throwable ex;
                    ex = e.getTargetException();
                    {
                        throw (RuntimeException) ex;
                    } //End block
                    {
                        throw (Error) ex;
                    } //End block
                    throw (ObjectStreamException) ex;
                } //End block
                catch (IllegalAccessException e)
                {
                    throw new RuntimeException(e.toString());
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!classDesc.isSerializable()) {
            //return;
        //}
        //if (classDesc.hasMethodReadObjectNoData()){
            //final Method readMethod = classDesc.getMethodReadObjectNoData();
            //try {
                //readMethod.invoke(object);
            //} catch (InvocationTargetException e) {
                //Throwable ex = e.getTargetException();
                //if (ex instanceof RuntimeException) {
                    //throw (RuntimeException) ex;
                //} else if (ex instanceof Error) {
                    //throw (Error) ex;
                //}
                //throw (ObjectStreamException) ex;
            //} catch (IllegalAccessException e) {
                //throw new RuntimeException(e.toString());
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.532 -0400", hash_original_method = "6119E962BBCC069017D862716C24BEC0", hash_generated_method = "A6EB1CBFF8EB56A228AAF7B993655A0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObjectForClass(Object object, ObjectStreamClass classDesc) throws IOException, ClassNotFoundException, NotActiveException {
        dsTaint.addTaint(object.dsTaint);
        dsTaint.addTaint(classDesc.dsTaint);
        boolean hadWriteMethod;
        hadWriteMethod = (classDesc.getFlags() & SC_WRITE_METHOD) != 0;
        Class<?> targetClass;
        targetClass = classDesc.forClass();
        final Method readMethod;
        {
            readMethod = null;
        } //End block
        {
            readMethod = classDesc.getMethodReadObject();
        } //End block
        try 
        {
            {
                readMethod.setAccessible(true);
                try 
                {
                    readMethod.invoke(object, this);
                } //End block
                catch (InvocationTargetException e)
                {
                    Throwable ex;
                    ex = e.getTargetException();
                    {
                        throw (ClassNotFoundException) ex;
                    } //End block
                    {
                        throw (RuntimeException) ex;
                    } //End block
                    {
                        throw (Error) ex;
                    } //End block
                    throw (IOException) ex;
                } //End block
                catch (IllegalAccessException e)
                {
                    throw new RuntimeException(e.toString());
                } //End block
            } //End block
            {
                defaultReadObject();
            } //End block
            {
                discardData();
            } //End block
        } //End block
        finally 
        {
            currentObject = null;
            currentClass = null;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.532 -0400", hash_original_method = "D31E8D2825D4043295F3D0C685B93717", hash_generated_method = "DED4964842C5C28972B344165344F125")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int readInt() throws IOException {
        int varE840EF94E99C72456F8C1D024800AFEF_558572453 = (primitiveTypes.readInt());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return primitiveTypes.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.532 -0400", hash_original_method = "90EA71A98921C4D093F2F0BA4DDBE95D", hash_generated_method = "5C3506141F627E5E0471E57DB1572C7A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public String readLine() throws IOException {
        String var76C98081C14306C47F719AC41BB40770_148908438 = (primitiveTypes.readLine());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return primitiveTypes.readLine();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.532 -0400", hash_original_method = "70C9FFE9F08A2EBCF32FC4C20D730AD7", hash_generated_method = "5D147CCC29CA985A9A2D9C9D48EEB85B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long readLong() throws IOException {
        long var92AA3E55B0DEEBFF8ACE4E90B4B38BFC_330282450 = (primitiveTypes.readLong());
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return primitiveTypes.readLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.533 -0400", hash_original_method = "6C628531F4475FFAEEB816E877548000", hash_generated_method = "04D7F486D9DE3939CB2E42B1A6DAAE5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object readNewArray(boolean unshared) throws OptionalDataException,
            ClassNotFoundException, IOException {
        dsTaint.addTaint(unshared);
        ObjectStreamClass classDesc;
        classDesc = readClassDesc();
        {
            throw missingClassDescriptor();
        } //End block
        int newHandle;
        newHandle = nextHandle();
        int size;
        size = input.readInt();
        Class<?> arrayClass;
        arrayClass = classDesc.forClass();
        Class<?> componentType;
        componentType = arrayClass.getComponentType();
        Object result;
        result = Array.newInstance(componentType, size);
        registerObjectRead(result, newHandle, unshared);
        {
            boolean varD34D6340EB041A4E3567A6A53D064A1F_685397736 = (componentType.isPrimitive());
            {
                {
                    int[] intArray;
                    intArray = (int[]) result;
                    {
                        int i;
                        i = 0;
                        {
                            intArray[i] = input.readInt();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    byte[] byteArray;
                    byteArray = (byte[]) result;
                    input.readFully(byteArray, 0, size);
                } //End block
                {
                    char[] charArray;
                    charArray = (char[]) result;
                    {
                        int i;
                        i = 0;
                        {
                            charArray[i] = input.readChar();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    short[] shortArray;
                    shortArray = (short[]) result;
                    {
                        int i;
                        i = 0;
                        {
                            shortArray[i] = input.readShort();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    boolean[] booleanArray;
                    booleanArray = (boolean[]) result;
                    {
                        int i;
                        i = 0;
                        {
                            booleanArray[i] = input.readBoolean();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    long[] longArray;
                    longArray = (long[]) result;
                    {
                        int i;
                        i = 0;
                        {
                            longArray[i] = input.readLong();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    float[] floatArray;
                    floatArray = (float[]) result;
                    {
                        int i;
                        i = 0;
                        {
                            floatArray[i] = input.readFloat();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    double[] doubleArray;
                    doubleArray = (double[]) result;
                    {
                        int i;
                        i = 0;
                        {
                            doubleArray[i] = input.readDouble();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    throw new ClassNotFoundException("Wrong base type in " + classDesc.getName());
                } //End block
            } //End block
            {
                Object[] objectArray;
                objectArray = (Object[]) result;
                {
                    int i;
                    i = 0;
                    {
                        objectArray[i] = readObject();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            result = resolveObject(result);
            registerObjectRead(result, newHandle, false);
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.533 -0400", hash_original_method = "5D3FFF38041945ED84D75A0CC474793D", hash_generated_method = "B726D9710FD5D6B3A9A804BD778BD148")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Class<?> readNewClass(boolean unshared) throws ClassNotFoundException, IOException {
        dsTaint.addTaint(unshared);
        ObjectStreamClass classDesc;
        classDesc = readClassDesc();
        {
            throw missingClassDescriptor();
        } //End block
        Class<?> localClass;
        localClass = classDesc.forClass();
        {
            registerObjectRead(localClass, nextHandle(), unshared);
        } //End block
        return (Class<?>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.533 -0400", hash_original_method = "D16FAEE9BB99888884BA2510B9D0161D", hash_generated_method = "74801AC6B9ED5134400EC8B06674066F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ObjectStreamClass readEnumDesc() throws IOException,
            ClassNotFoundException {
        byte tc;
        tc = nextTC();
        //Begin case TC_CLASSDESC 
        ObjectStreamClass var70012381CDB5550C6DE4D9227432C12B_904105339 = (readEnumDescInternal());
        //End case TC_CLASSDESC 
        //Begin case TC_REFERENCE 
        ObjectStreamClass var41AE2590E5AE43F9C604C548CB534E0B_942217908 = ((ObjectStreamClass) readCyclicReference());
        //End case TC_REFERENCE 
        //Begin case default 
        throw corruptStream(tc);
        //End case default 
        return (ObjectStreamClass)dsTaint.getTaint();
        // ---------- Original Method ----------
        //byte tc = nextTC();
        //switch (tc) {
            //case TC_CLASSDESC:
                //return readEnumDescInternal();
            //case TC_REFERENCE:
                //return (ObjectStreamClass) readCyclicReference();
            //case TC_NULL:
                //return null;
            //default:
                //throw corruptStream(tc);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.533 -0400", hash_original_method = "58EE21B582EE01373F973D50B42B8A60", hash_generated_method = "37A9B3F6E9B97CB8A129C3696F305CFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ObjectStreamClass readEnumDescInternal() throws IOException, ClassNotFoundException {
        ObjectStreamClass classDesc;
        primitiveData = input;
        int oldHandle;
        oldHandle = descriptorHandle;
        descriptorHandle = nextHandle();
        classDesc = readClassDescriptor();
        registerObjectRead(classDesc, descriptorHandle, false);
        descriptorHandle = oldHandle;
        primitiveData = emptyStream;
        classDesc.setClass(resolveClass(classDesc));
        discardData();
        ObjectStreamClass superClass;
        superClass = readClassDesc();
        checkedSetSuperClassDesc(classDesc, superClass);
        {
            boolean varDEA6609B69DA5649FF02F7EEB3B9D4F7_1280373270 = (0L != classDesc.getSerialVersionUID() || 0L != superClass.getSerialVersionUID());
            {
                throw new InvalidClassException(superClass.getName(),
                    "Incompatible class (SUID): " + superClass + " but expected " + superClass);
            } //End block
        } //End collapsed parenthetic
        byte tc;
        tc = nextTC();
        {
            superClass.setSuperclass(readClassDesc());
        } //End block
        {
            pushbackTC();
        } //End block
        return (ObjectStreamClass)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.533 -0400", hash_original_method = "0BB1D7ADA0D4FC987B96FE9D538B84F1", hash_generated_method = "D0D82780F0FBD6E168978CDD60B60B16")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    private Object readEnum(boolean unshared) throws OptionalDataException,
            ClassNotFoundException, IOException {
        dsTaint.addTaint(unshared);
        ObjectStreamClass classDesc;
        classDesc = readEnumDesc();
        int newHandle;
        newHandle = nextHandle();
        String name;
        byte tc;
        tc = nextTC();
        //Begin case TC_REFERENCE 
        {
            readNewHandle();
            throw new InvalidObjectException("Unshared read of back reference");
        } //End block
        //End case TC_REFERENCE 
        //Begin case TC_REFERENCE 
        name = (String) readCyclicReference();
        //End case TC_REFERENCE 
        //Begin case TC_STRING 
        name = (String) readNewString(unshared);
        //End case TC_STRING 
        //Begin case default 
        throw corruptStream(tc);
        //End case default 
        Enum<?> result;
        result = Enum.valueOf((Class) classDesc.forClass(), name);
        registerObjectRead(result, newHandle, unshared);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ObjectStreamClass classDesc = readEnumDesc();
        //int newHandle = nextHandle();
        //String name;
        //byte tc = nextTC();
        //switch (tc) {
            //case TC_REFERENCE:
                //if (unshared) {
                    //readNewHandle();
                    //throw new InvalidObjectException("Unshared read of back reference");
                //}
                //name = (String) readCyclicReference();
                //break;
            //case TC_STRING:
                //name = (String) readNewString(unshared);
                //break;
            //default:
                //throw corruptStream(tc);
        //}
        //Enum<?> result = Enum.valueOf((Class) classDesc.forClass(), name);
        //registerObjectRead(result, newHandle, unshared);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.534 -0400", hash_original_method = "85A17F1C0F9F03F0EE48936822125550", hash_generated_method = "9909AB5046D0E6201F4804219B09E364")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ObjectStreamClass readNewClassDesc(boolean unshared) throws ClassNotFoundException, IOException {
        dsTaint.addTaint(unshared);
        primitiveData = input;
        int oldHandle;
        oldHandle = descriptorHandle;
        descriptorHandle = nextHandle();
        ObjectStreamClass newClassDesc;
        newClassDesc = readClassDescriptor();
        registerObjectRead(newClassDesc, descriptorHandle, unshared);
        descriptorHandle = oldHandle;
        primitiveData = emptyStream;
        try 
        {
            newClassDesc.setClass(resolveClass(newClassDesc));
            verifyAndInit(newClassDesc);
        } //End block
        catch (ClassNotFoundException e)
        {
            {
                throw e;
            } //End block
        } //End block
        ObjectStreamField[] fields;
        fields = newClassDesc.getLoadFields();
        fields = (fields == null) ? ObjectStreamClass.NO_FIELDS : fields;
        ClassLoader loader;
        boolean var47BDE074D2A177403E07EAFF053D9C91_502597217 = (newClassDesc.forClass() == null);
        loader = callerClassLoader;
        loader = newClassDesc.forClass().getClassLoader();
        {
            Iterator<ObjectStreamField> seatecAstronomy42 = fields.iterator();
            seatecAstronomy42.hasNext();
            ObjectStreamField element = seatecAstronomy42.next();
            {
                element.resolve(loader);
            } //End block
        } //End collapsed parenthetic
        discardData();
        checkedSetSuperClassDesc(newClassDesc, readClassDesc());
        return (ObjectStreamClass)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.534 -0400", hash_original_method = "9592596F093477979EA31311F339CD7D", hash_generated_method = "1E150A2DC21DBEDE923C2BC00C293485")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Class<?> readNewProxyClassDesc() throws ClassNotFoundException,
            IOException {
        int count;
        count = input.readInt();
        String[] interfaceNames;
        interfaceNames = new String[count];
        {
            int i;
            i = 0;
            {
                interfaceNames[i] = input.readUTF();
            } //End block
        } //End collapsed parenthetic
        Class<?> proxy;
        proxy = resolveProxyClass(interfaceNames);
        discardData();
        return (Class<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int count = input.readInt();
        //String[] interfaceNames = new String[count];
        //for (int i = 0; i < count; i++) {
            //interfaceNames[i] = input.readUTF();
        //}
        //Class<?> proxy = resolveProxyClass(interfaceNames);
        //discardData();
        //return proxy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.534 -0400", hash_original_method = "97948A412F94E7F820143192C44DB303", hash_generated_method = "BEF10908E102BBEFF07E29B9D8B47D61")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
        ObjectStreamClass newClassDesc;
        newClassDesc = new ObjectStreamClass();
        String name;
        name = input.readUTF();
        {
            boolean var162A1A174B912EA806BA20275BF238E6_2070245887 = (name.length() == 0);
            {
                throw new IOException("The stream is corrupted");
            } //End block
        } //End collapsed parenthetic
        newClassDesc.setName(name);
        newClassDesc.setSerialVersionUID(input.readLong());
        newClassDesc.setFlags(input.readByte());
        {
            descriptorHandle = nextHandle();
        } //End block
        registerObjectRead(newClassDesc, descriptorHandle, false);
        readFieldDescriptors(newClassDesc);
        return (ObjectStreamClass)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ObjectStreamClass newClassDesc = new ObjectStreamClass();
        //String name = input.readUTF();
        //if (name.length() == 0) {
            //throw new IOException("The stream is corrupted");
        //}
        //newClassDesc.setName(name);
        //newClassDesc.setSerialVersionUID(input.readLong());
        //newClassDesc.setFlags(input.readByte());
        //if (descriptorHandle == -1) {
            //descriptorHandle = nextHandle();
        //}
        //registerObjectRead(newClassDesc, descriptorHandle, false);
        //readFieldDescriptors(newClassDesc);
        //return newClassDesc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.534 -0400", hash_original_method = "C938C68924527CB04F806429B3BE928F", hash_generated_method = "DE26D46EE53E80F863B0312F6F6343C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Class<?> resolveProxyClass(String[] interfaceNames) throws IOException, ClassNotFoundException {
        dsTaint.addTaint(interfaceNames);
        ClassLoader loader;
        loader = ClassLoader.getSystemClassLoader();
        Class<?>[] interfaces;
        interfaces = new Class<?>[interfaceNames.length];
        {
            int i;
            i = 0;
            {
                interfaces[i] = Class.forName(interfaceNames[i], false, loader);
            } //End block
        } //End collapsed parenthetic
        try 
        {
            Class<?> varDF634AB46FA6B6D516C20C557D2F5A52_342123424 = (Proxy.getProxyClass(loader, interfaces));
        } //End block
        catch (IllegalArgumentException e)
        {
            throw new ClassNotFoundException(e.toString(), e);
        } //End block
        return (Class<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ClassLoader loader = ClassLoader.getSystemClassLoader();
        //Class<?>[] interfaces = new Class<?>[interfaceNames.length];
        //for (int i = 0; i < interfaceNames.length; i++) {
            //interfaces[i] = Class.forName(interfaceNames[i], false, loader);
        //}
        //try {
            //return Proxy.getProxyClass(loader, interfaces);
        //} catch (IllegalArgumentException e) {
            //throw new ClassNotFoundException(e.toString(), e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.534 -0400", hash_original_method = "11D3D467DA55FCE7098C1D9AB901525D", hash_generated_method = "1F71C79F49BA37CDE2B631EC4554F073")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int readNewHandle() throws IOException {
        int var4605C3BBD7F83DAEC21E27D6EA87F85C_902944893 = (input.readInt());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return input.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.535 -0400", hash_original_method = "B0A36455F033DD06E1C6357D1966CB2A", hash_generated_method = "E714EC919C3AAFE25C5B1A0A391645DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object readNewObject(boolean unshared) throws OptionalDataException, ClassNotFoundException, IOException {
        dsTaint.addTaint(unshared);
        ObjectStreamClass classDesc;
        classDesc = readClassDesc();
        {
            throw missingClassDescriptor();
        } //End block
        int newHandle;
        newHandle = nextHandle();
        Class<?> objectClass;
        objectClass = classDesc.forClass();
        Object result;
        result = null;
        Object registeredResult;
        registeredResult = null;
        {
            result = classDesc.newInstance(objectClass);
            registerObjectRead(result, newHandle, unshared);
            registeredResult = result;
        } //End block
        {
            result = null;
        } //End block
        try 
        {
            currentObject = result;
            currentClass = classDesc;
            boolean wasExternalizable;
            wasExternalizable = (classDesc.getFlags() & SC_EXTERNALIZABLE) != 0;
            {
                boolean blockData;
                blockData = (classDesc.getFlags() & SC_BLOCK_DATA) != 0;
                {
                    primitiveData = input;
                } //End block
                {
                    Externalizable extern;
                    extern = (Externalizable) result;
                    extern.readExternal(this);
                } //End block
                {
                    discardData();
                } //End block
                {
                    primitiveData = emptyStream;
                } //End block
            } //End block
            {
                readHierarchy(result, classDesc);
            } //End block
        } //End block
        finally 
        {
            currentObject = null;
            currentClass = null;
        } //End block
        {
            {
                boolean varCAC8AACA1AE8B625201A6DC80248AF34_781353480 = (classDesc.hasMethodReadResolve());
                {
                    Method methodReadResolve;
                    methodReadResolve = classDesc.getMethodReadResolve();
                    try 
                    {
                        result = methodReadResolve.invoke(result, (Object[]) null);
                    } //End block
                    catch (IllegalAccessException ignored)
                    { }
                    catch (InvocationTargetException ite)
                    {
                        Throwable target;
                        target = ite.getTargetException();
                        {
                            throw (ObjectStreamException) target;
                        } //End block
                        {
                            throw (Error) target;
                        } //End block
                        {
                            throw (RuntimeException) target;
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            result = resolveObject(result);
        } //End block
        {
            registerObjectRead(result, newHandle, unshared);
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.535 -0400", hash_original_method = "C5243F456C3574095BC1BB7FC2411373", hash_generated_method = "A01258B38BE2AC8CA972C4F773C1315B")
    @DSModeled(DSC.SAFE)
    private InvalidClassException missingClassDescriptor() throws InvalidClassException {
        throw new InvalidClassException("Read null attempting to read class descriptor for object");
        return (InvalidClassException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new InvalidClassException("Read null attempting to read class descriptor for object");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.535 -0400", hash_original_method = "CF984AE9FCCB80A5CA5459E50D42D99D", hash_generated_method = "41FDE22D75422902472F4B70E964219E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object readNewString(boolean unshared) throws IOException {
        dsTaint.addTaint(unshared);
        Object result;
        result = input.readUTF();
        {
            result = resolveObject(result);
        } //End block
        registerObjectRead(result, nextHandle(), unshared);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object result = input.readUTF();
        //if (enableResolve) {
            //result = resolveObject(result);
        //}
        //registerObjectRead(result, nextHandle(), unshared);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.535 -0400", hash_original_method = "E3603577D9590FDF3626C23DB61D460D", hash_generated_method = "BF98EE1D3C907B07FC3D2F74A93D5BDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object readNewLongString(boolean unshared) throws IOException {
        dsTaint.addTaint(unshared);
        long length;
        length = input.readLong();
        Object result;
        result = input.decodeUTF((int) length);
        {
            result = resolveObject(result);
        } //End block
        registerObjectRead(result, nextHandle(), unshared);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //long length = input.readLong();
        //Object result = input.decodeUTF((int) length);
        //if (enableResolve) {
            //result = resolveObject(result);
        //}
        //registerObjectRead(result, nextHandle(), unshared);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.535 -0400", hash_original_method = "D5CBFBA6D0DD1CCB325BD55A2992CB88", hash_generated_method = "19EFE782D2E1259C627BF20C633A6DE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Object readObject() throws OptionalDataException,
            ClassNotFoundException, IOException {
        Object var63B7A6B4D2A2E42961D4AD40E7A10DDC_1363824468 = (readObject(false));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return readObject(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.535 -0400", hash_original_method = "B5062D634E2B9403462F68486501694A", hash_generated_method = "DF643719CC0AF88F9FE4E6327596ACE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object readUnshared() throws IOException, ClassNotFoundException {
        Object varED54F4B5F2B71159C493DEF7611AC7E7_1309569353 = (readObject(true));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return readObject(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.535 -0400", hash_original_method = "E655B580AAC2F65ED2F044289942F1C0", hash_generated_method = "ADBC287E74D3DC0E31F4A2549D2B6B22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object readObject(boolean unshared) throws OptionalDataException,
            ClassNotFoundException, IOException {
        dsTaint.addTaint(unshared);
        boolean restoreInput;
        restoreInput = (primitiveData == input);
        {
            primitiveData = emptyStream;
        } //End block
        {
            Object var90933ED2D456AE6BAC250EBABAD4F89B_96273184 = (readObjectOverride());
        } //End block
        Object result;
        try 
        {
            {
                callerClassLoader = getClosestUserClassLoader();
            } //End block
            result = readNonPrimitiveContent(unshared);
            {
                primitiveData = input;
            } //End block
        } //End block
        finally 
        {
            {
                callerClassLoader = null;
            } //End block
        } //End block
        {
            try 
            {
                {
                    Iterator<InputValidationDesc> seatecAstronomy42 = validations.iterator();
                    seatecAstronomy42.hasNext();
                    InputValidationDesc element = seatecAstronomy42.next();
                    {
                        element.validator.validateObject();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            finally 
            {
                validations = null;
            } //End block
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.535 -0400", hash_original_method = "D98B125FAAAD460E85A5D4A1FF301F64", hash_generated_method = "54386ACCAF7F85B9F2AC0743DD29A7FA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.535 -0400", hash_original_method = "F453836DFC9EEC175FFF65A0C41AF32F", hash_generated_method = "79B6E08D7215FE60C94D97E982BE1F13")
    @DSModeled(DSC.SAFE)
    protected Object readObjectOverride() throws OptionalDataException,
            ClassNotFoundException, IOException {
        throw new IOException();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (input == null) {
            //return null;
        //}
        //throw new IOException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.535 -0400", hash_original_method = "E1F1666A9CC2BCC43C42662EA935D779", hash_generated_method = "3FC82FF90DD0DB46241219C322C3A7D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public short readShort() throws IOException {
        short varCDA22C267187CEE310BF77CF189DA7D6_1011815479 = (primitiveTypes.readShort());
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return primitiveTypes.readShort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.536 -0400", hash_original_method = "2E049C52CD4079E3EDC13878B612AD59", hash_generated_method = "E83C97B43BFC78638F784576D226637C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void readStreamHeader() throws IOException,
            StreamCorruptedException {
        {
            boolean varC19679871E5EE3ACDCBC6AB5CDD35F45_1875336098 = (input.readShort() == STREAM_MAGIC
                && input.readShort() == STREAM_VERSION);
        } //End collapsed parenthetic
        throw new StreamCorruptedException();
        // ---------- Original Method ----------
        //if (input.readShort() == STREAM_MAGIC
                //&& input.readShort() == STREAM_VERSION) {
            //return;
        //}
        //throw new StreamCorruptedException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.536 -0400", hash_original_method = "50996F70792020DA658FB7FFCF1EF910", hash_generated_method = "663F053059A8B382F606EBA40D6A67BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int readUnsignedByte() throws IOException {
        int varB7F3DDCB7C33CADCD69A9EA77340018F_403703294 = (primitiveTypes.readUnsignedByte());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return primitiveTypes.readUnsignedByte();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.536 -0400", hash_original_method = "ABA376385639B6CB8F725C68F1CED979", hash_generated_method = "37F6ED259158E09227BC12F8C91B858E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int readUnsignedShort() throws IOException {
        int var8B6F0F8EF6EFAE22F469847E9560AC03_1671280357 = (primitiveTypes.readUnsignedShort());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return primitiveTypes.readUnsignedShort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.536 -0400", hash_original_method = "B2994D3A3B821949D517613320FA5065", hash_generated_method = "9539838B09BB16947DB15556B0ACF13C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String readUTF() throws IOException {
        String var28664681DF1DE10C21CC89E508B3FF93_1530120651 = (primitiveTypes.readUTF());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return primitiveTypes.readUTF();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.536 -0400", hash_original_method = "10F65D1907C5AA72A1571FB08139A1C8", hash_generated_method = "3F337130D9598F2D7389D7A95042573D")
    @DSModeled(DSC.SAFE)
    private Object registeredObjectRead(int handle) throws InvalidObjectException {
        dsTaint.addTaint(handle);
        Object res;
        res = objectsRead.get(handle - ObjectStreamConstants.baseWireHandle);
        {
            throw new InvalidObjectException("Cannot read back reference to unshared object");
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object res = objectsRead.get(handle - ObjectStreamConstants.baseWireHandle);
        //if (res == UNSHARED_OBJ) {
            //throw new InvalidObjectException("Cannot read back reference to unshared object");
        //}
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.536 -0400", hash_original_method = "9C8641A932863D3A6F3FA22233749F54", hash_generated_method = "E64C0210B9D6A40907C12D8974A2F847")
    @DSModeled(DSC.SAFE)
    private void registerObjectRead(Object obj, int handle, boolean unshared) throws IOException {
        dsTaint.addTaint(handle);
        dsTaint.addTaint(unshared);
        dsTaint.addTaint(obj.dsTaint);
        {
            obj = UNSHARED_OBJ;
        } //End block
        int index;
        index = handle - ObjectStreamConstants.baseWireHandle;
        int size;
        size = objectsRead.size();
        {
            objectsRead.add(null);
            ++size;
        } //End block
        {
            objectsRead.add(obj);
        } //End block
        {
            objectsRead.set(index, obj);
        } //End block
        // ---------- Original Method ----------
        //if (unshared) {
            //obj = UNSHARED_OBJ;
        //}
        //int index = handle - ObjectStreamConstants.baseWireHandle;
        //int size = objectsRead.size();
        //while (index > size) {
            //objectsRead.add(null);
            //++size;
        //}
        //if (index == size) {
            //objectsRead.add(obj);
        //} else {
            //objectsRead.set(index, obj);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.536 -0400", hash_original_method = "3EFB39BBE791BF6ED902F9D8BC5F60E3", hash_generated_method = "A25A56F5A2E03BAA8EB8B4D6014EA8C1")
    @DSModeled(DSC.SAFE)
    public synchronized void registerValidation(ObjectInputValidation object,
            int priority) throws NotActiveException, InvalidObjectException {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(priority);
        dsTaint.addTaint(object.dsTaint);
        Object instanceBeingRead;
        instanceBeingRead = this.currentObject;
        {
            throw new NotActiveException();
        } //End block
        {
            throw new InvalidObjectException("Callback object cannot be null");
        } //End block
        InputValidationDesc desc;
        desc = new InputValidationDesc();
        desc.validator = object;
        desc.priority = priority;
        {
            validations = new InputValidationDesc[1];
            validations[0] = desc;
        } //End block
        {
            int i;
            i = 0;
            {
                InputValidationDesc validation;
                validation = validations[i];
            } //End block
            InputValidationDesc[] oldValidations;
            oldValidations = validations;
            int currentSize;
            currentSize = oldValidations.length;
            validations = new InputValidationDesc[currentSize + 1];
            System.arraycopy(oldValidations, 0, validations, 0, i);
            System.arraycopy(oldValidations, i, validations, i + 1, currentSize
                    - i);
            validations[i] = desc;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.536 -0400", hash_original_method = "7A01BA94C22B82138AACA44C7BC92DD9", hash_generated_method = "AB9C89902B002B9582C5EEBFF0F4EEDE")
    @DSModeled(DSC.SAFE)
    private void resetSeenObjects() {
        objectsRead = new ArrayList<Object>();
        nextHandle = baseWireHandle;
        primitiveData = emptyStream;
        // ---------- Original Method ----------
        //objectsRead = new ArrayList<Object>();
        //nextHandle = baseWireHandle;
        //primitiveData = emptyStream;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.536 -0400", hash_original_method = "356E50ACB0709EF4643021948AB5F291", hash_generated_method = "A78514150CEFC3944AE08993A8C5556E")
    @DSModeled(DSC.SAFE)
    private void resetState() {
        resetSeenObjects();
        hasPushbackTC = false;
        pushbackTC = 0;
        // ---------- Original Method ----------
        //resetSeenObjects();
        //hasPushbackTC = false;
        //pushbackTC = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.536 -0400", hash_original_method = "38B51F7C504D6211D87B81513F39C956", hash_generated_method = "8E0AE78200870B95DA625D4846576D5D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Class<?> resolveClass(ObjectStreamClass osClass) throws IOException, ClassNotFoundException {
        dsTaint.addTaint(osClass.dsTaint);
        Class<?> cls;
        cls = osClass.forClass();
        {
            String className;
            className = osClass.getName();
            cls = PRIMITIVE_CLASSES.get(className);
            {
                cls = Class.forName(className, true, callerClassLoader);
            } //End block
        } //End block
        return (Class<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Class<?> cls = osClass.forClass();
        //if (cls == null) {
            //String className = osClass.getName();
            //cls = PRIMITIVE_CLASSES.get(className);
            //if (cls == null) {
                //cls = Class.forName(className, true, callerClassLoader);
            //}
        //}
        //return cls;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.537 -0400", hash_original_method = "8BE1D9D2C1A8227AC3DEAA12C63F6442", hash_generated_method = "A37EAF623AD68BDBBCA280D94EC9C93C")
    @DSModeled(DSC.SAFE)
    protected Object resolveObject(Object object) throws IOException {
        dsTaint.addTaint(object.dsTaint);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return object;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.537 -0400", hash_original_method = "C18A3B861F9E4DC00DB6D8F86113E96E", hash_generated_method = "E2F312E645A27E993E69A1672C4C7DD4")
    @DSModeled(DSC.SAFE)
    public int skipBytes(int length) throws IOException {
        dsTaint.addTaint(length);
        {
            throw new NullPointerException();
        } //End block
        int offset;
        offset = 0;
        {
            checkReadPrimitiveTypes();
            long skipped;
            skipped = primitiveData.skip(length - offset);
            offset += (int) skipped;
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (input == null) {
            //throw new NullPointerException();
        //}
        //int offset = 0;
        //while (offset < length) {
            //checkReadPrimitiveTypes();
            //long skipped = primitiveData.skip(length - offset);
            //if (skipped == 0) {
                //return offset;
            //}
            //offset += (int) skipped;
        //}
        //return length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.537 -0400", hash_original_method = "F18AA842F3AF8655FE4F963E8A31A757", hash_generated_method = "FA27FBF9D9D609DBE06EB23F6CD3BA11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void verifyAndInit(ObjectStreamClass loadedStreamClass) throws InvalidClassException {
        dsTaint.addTaint(loadedStreamClass.dsTaint);
        Class<?> localClass;
        localClass = loadedStreamClass.forClass();
        ObjectStreamClass localStreamClass;
        localStreamClass = ObjectStreamClass
                .lookupStreamClass(localClass);
        {
            boolean var9693CD9966488232124376137EBA8914_1357287650 = (loadedStreamClass.getSerialVersionUID() != localStreamClass
                .getSerialVersionUID());
            {
                throw new InvalidClassException(loadedStreamClass.getName(),
                    "Incompatible class (SUID): " + loadedStreamClass +
                            " but expected " + localStreamClass);
            } //End block
        } //End collapsed parenthetic
        String loadedClassBaseName;
        loadedClassBaseName = getBaseName(loadedStreamClass.getName());
        String localClassBaseName;
        localClassBaseName = getBaseName(localStreamClass.getName());
        {
            boolean varB90E1FD3EA27827ECD4177A803C71953_300321877 = (!loadedClassBaseName.equals(localClassBaseName));
            {
                throw new InvalidClassException(loadedStreamClass.getName(),
                    String.format("Incompatible class (base name): %s but expected %s",
                            loadedClassBaseName, localClassBaseName));
            } //End block
        } //End collapsed parenthetic
        loadedStreamClass.initPrivateFields(localStreamClass);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.537 -0400", hash_original_method = "A0CE91BAC510F89CA68326A2D2BB846C", hash_generated_method = "2479985A4CC7F0155BD9D55EE6E99528")
    private static String getBaseName(String fullName) {
        int k = fullName.lastIndexOf('.');
        if (k == -1 || k == (fullName.length() - 1)) {
            return fullName;
        }
        return fullName.substring(k + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.537 -0400", hash_original_method = "8C220D66FEC4AEA02D44FBB23E305EE3", hash_generated_method = "6DFE137859E2431723804AFE073FB1DE")
    private static void checkedSetSuperClassDesc(ObjectStreamClass desc,
            ObjectStreamClass superDesc) throws StreamCorruptedException {
        if (desc.equals(superDesc)) {
            throw new StreamCorruptedException();
        }
        desc.setSuperclass(superDesc);
    }

    
    static class InputValidationDesc {
        ObjectInputValidation validator;
        int priority;
        
    }


    
    public abstract static class GetField {
        
        public abstract ObjectStreamClass getObjectStreamClass();

        
        public abstract boolean defaulted(String name) throws IOException,
                IllegalArgumentException;

        
        public abstract boolean get(String name, boolean defaultValue)
                throws IOException, IllegalArgumentException;

        
        public abstract char get(String name, char defaultValue)
                throws IOException, IllegalArgumentException;

        
        public abstract byte get(String name, byte defaultValue)
                throws IOException, IllegalArgumentException;

        
        public abstract short get(String name, short defaultValue)
                throws IOException, IllegalArgumentException;

        
        public abstract int get(String name, int defaultValue)
                throws IOException, IllegalArgumentException;

        
        public abstract long get(String name, long defaultValue)
                throws IOException, IllegalArgumentException;

        
        public abstract float get(String name, float defaultValue)
                throws IOException, IllegalArgumentException;

        
        public abstract double get(String name, double defaultValue)
                throws IOException, IllegalArgumentException;

        
        public abstract Object get(String name, Object defaultValue)
                throws IOException, IllegalArgumentException;

        
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
    
}


