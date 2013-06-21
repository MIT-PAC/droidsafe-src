package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private HashMap<Class<?>, List<Class<?>>> cachedSuperclasses = new HashMap<Class<?>, List<Class<?>>>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.891 -0400", hash_original_method = "124623F0922D5D71F912D224AEC5FA85", hash_generated_method = "ACAF350C98F97636B8BC13996275E1E2")
    @DSModeled(DSC.SAFE)
    protected ObjectInputStream() throws IOException {
        this.subclassOverridingImplementation = true;
        // ---------- Original Method ----------
        //this.subclassOverridingImplementation = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.891 -0400", hash_original_method = "15BB4AD74FE576D95ABFC0E40CC8A986", hash_generated_method = "5859DD68A41756EFF57760D7EA6100E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.892 -0400", hash_original_method = "CEC952E1AEB3FC5761C4573EC7C87AAE", hash_generated_method = "D2EEB7D1FDFC2B639527AE3F5017367B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int available() throws IOException {
        checkReadPrimitiveTypes();
        int var396FA1B30BCA352A1497967EC8829CF5_1772343956 = (primitiveData.available());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkReadPrimitiveTypes();
        //return primitiveData.available();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.892 -0400", hash_original_method = "5DD662298FB99DC11E3F5A1BB4812CC0", hash_generated_method = "9AD9D9F95F743D41B5F768D7CA0ADA0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkReadPrimitiveTypes() throws IOException {
        {
            boolean var429099FA06AFA9946D3FE9CA9E9D4FD2_1045908565 = (primitiveData == input || primitiveData.available() > 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.892 -0400", hash_original_method = "4ECD43BBA7F31E748521530C375A35B5", hash_generated_method = "EBCAB811F86091C4F8C851B059031D05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void close() throws IOException {
        input.close();
        // ---------- Original Method ----------
        //input.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.892 -0400", hash_original_method = "6463B95302326251A8E319007FB9B6A5", hash_generated_method = "0BE8757C249A1BCDB14AE00D20DDA08A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void defaultReadObject() throws IOException, ClassNotFoundException,
            NotActiveException {
        {
            readFieldValues(currentObject, currentClass);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NotActiveException();
        } //End block
        // ---------- Original Method ----------
        //if (currentObject != null || !mustResolve) {
            //readFieldValues(currentObject, currentClass);
        //} else {
            //throw new NotActiveException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.893 -0400", hash_original_method = "970A975ADDA1CD42A4A6880D40629922", hash_generated_method = "4719D921BBC87C7C06863EAEDBB3B664")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.893 -0400", hash_original_method = "BEEE4D4B01DB5401D5A386ECF8653C53", hash_generated_method = "88A37F645F724DAE42A3A60270D6B7F8")
    @DSModeled(DSC.SAFE)
    private int nextHandle() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return nextHandle++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.893 -0400", hash_original_method = "EA84EB3C5ACC30FA1515ABE6938E6E9B", hash_generated_method = "4F4D851790ECD6D9FAA46F38DAF965D0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.893 -0400", hash_original_method = "056AB6ECFECE1087CD6299233C3046CF", hash_generated_method = "1AA917BD8C0785A0A281D56B178CD348")
    @DSModeled(DSC.SAFE)
    private void pushbackTC() {
        hasPushbackTC = true;
        // ---------- Original Method ----------
        //hasPushbackTC = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.893 -0400", hash_original_method = "87E37984C9E76D351365EC77DA0248F5", hash_generated_method = "B41082AEDB59A2DE0857C63A3AD9B0E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read() throws IOException {
        checkReadPrimitiveTypes();
        int varB707721DB93E7A7A4590241126489184_767087179 = (primitiveData.read());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //checkReadPrimitiveTypes();
        //return primitiveData.read();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.893 -0400", hash_original_method = "7E3B2630C90BBA61B0E7CD83B04481D2", hash_generated_method = "B111CADC959CCD4AD840F0E3343C236E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read(byte[] buffer, int offset, int length) throws IOException {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
        checkReadPrimitiveTypes();
        int var8656D85F3F24DB8757358C0140B597A3_2063691264 = (primitiveData.read(buffer, offset, length));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buffer.length, offset, length);
        //if (length == 0) {
            //return 0;
        //}
        //checkReadPrimitiveTypes();
        //return primitiveData.read(buffer, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.894 -0400", hash_original_method = "35383BB5231F8136A4FECB09DEC2FE93", hash_generated_method = "457567CDFB4E2320243C61131AB18106")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.894 -0400", hash_original_method = "478D7B43D09CD1BAF3CA95670FAE291A", hash_generated_method = "02A0175D98885CC229059EBA5002B1DF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.894 -0400", hash_original_method = "43182B65F59B21B8425D068A4900EB3A", hash_generated_method = "43DDA9334636ECCD37BB61A4D238113F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean readBoolean() throws IOException {
        boolean varDCB0861A4BE9F65D653AD47B971965CF_1829119875 = (primitiveTypes.readBoolean());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return primitiveTypes.readBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.894 -0400", hash_original_method = "F1C938A529B536DE0EA7C0848AC19388", hash_generated_method = "BCBB92CD53D34E5E8307CAD9AA1E1E23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte readByte() throws IOException {
        byte varD0FBD5DD4443B7C0CAB658ACAA09D8C9_1439432234 = (primitiveTypes.readByte());
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //return primitiveTypes.readByte();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.894 -0400", hash_original_method = "08C7569945A67E2D251F3B449209E666", hash_generated_method = "8EBE3B5C65C7156BB035CB13DB5D7E87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char readChar() throws IOException {
        char var4C12272AC58BE571107F61420B43FEF4_70914499 = (primitiveTypes.readChar());
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return primitiveTypes.readChar();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.895 -0400", hash_original_method = "7E3D613702E21574BA96B289FBA102EA", hash_generated_method = "F0DF5597239337EBCBE42420F180D818")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.895 -0400", hash_original_method = "8425AE4559FEB283CFFC129B3DDD377F", hash_generated_method = "932CC97BFC0BF9BA3F7BF548C74E70E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ObjectStreamClass readClassDesc() throws ClassNotFoundException, IOException {
        byte tc;
        tc = nextTC();
        //Begin case TC_CLASSDESC 
        ObjectStreamClass varEFE5DAF34662ADD354013A8B24D89885_1335751117 = (readNewClassDesc(false));
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
        ObjectStreamClass var41AE2590E5AE43F9C604C548CB534E0B_1106160984 = ((ObjectStreamClass) readCyclicReference());
        //End case TC_REFERENCE 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw corruptStream(tc);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.895 -0400", hash_original_method = "D1B003D7ABBBCEF0B15D64544C91AEEF", hash_generated_method = "B188CA5EBC8DD4BC58B05E2032594905")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private StreamCorruptedException corruptStream(byte tc) throws StreamCorruptedException {
        dsTaint.addTaint(tc);
        if (DroidSafeAndroidRuntime.control) throw new StreamCorruptedException("Wrong format: " + Integer.toHexString(tc & 0xff));
        return (StreamCorruptedException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new StreamCorruptedException("Wrong format: " + Integer.toHexString(tc & 0xff));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.895 -0400", hash_original_method = "EBF146E3B3C2508DCA0D721582A75609", hash_generated_method = "15C4AA69224C0C4929915F2864FD3AB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object readContent(byte tc) throws ClassNotFoundException,
            IOException {
        dsTaint.addTaint(tc);
        //Begin case TC_BLOCKDATA 
        Object var2D12826159AEA92DEDAB1E290EBAB0E0_426164590 = (readBlockData());
        //End case TC_BLOCKDATA 
        //Begin case TC_BLOCKDATALONG 
        Object var0E4BE706F5AAE349E365D5FADA7500E7_1338013807 = (readBlockDataLong());
        //End case TC_BLOCKDATALONG 
        //Begin case TC_CLASS 
        Object var896F24146F9E998E533B4BBD140D2CD1_1606197032 = (readNewClass(false));
        //End case TC_CLASS 
        //Begin case TC_CLASSDESC 
        Object varEFE5DAF34662ADD354013A8B24D89885_1242916614 = (readNewClassDesc(false));
        //End case TC_CLASSDESC 
        //Begin case TC_ARRAY 
        Object var39403445DD2FA137B6509AE62C4B742B_1839033853 = (readNewArray(false));
        //End case TC_ARRAY 
        //Begin case TC_OBJECT 
        Object var35E1AE74C4F222DE939E4F4F98D0C24E_222436422 = (readNewObject(false));
        //End case TC_OBJECT 
        //Begin case TC_STRING 
        Object var31B7CEA5C9493591BB0A68C37D5F5B9D_484764899 = (readNewString(false));
        //End case TC_STRING 
        //Begin case TC_LONGSTRING 
        Object varDB6876173628E83ADE7BF242BAF73ECE_849773452 = (readNewLongString(false));
        //End case TC_LONGSTRING 
        //Begin case TC_REFERENCE 
        Object varC9F339D32D92744C9163A6AA959A489C_929487019 = (readCyclicReference());
        //End case TC_REFERENCE 
        //Begin case TC_EXCEPTION 
        Exception exc;
        exc = readException();
        //End case TC_EXCEPTION 
        //Begin case TC_EXCEPTION 
        if (DroidSafeAndroidRuntime.control) throw new WriteAbortedException("Read an exception", exc);
        //End case TC_EXCEPTION 
        //Begin case TC_RESET 
        resetState();
        //End case TC_RESET 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw corruptStream(tc);
        //End case default 
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.896 -0400", hash_original_method = "C964F7473D297E2F3A28B1C55493EBEA", hash_generated_method = "AE24088ADEFDAE9877F6A7532E25D0F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object readNonPrimitiveContent(boolean unshared) throws ClassNotFoundException, IOException {
        dsTaint.addTaint(unshared);
        checkReadPrimitiveTypes();
        {
            boolean varFE023E46CC4F9239294D15D3ADCB19E2_1051435556 = (primitiveData.available() > 0);
            {
                OptionalDataException e;
                e = new OptionalDataException();
                e.length = primitiveData.available();
                if (DroidSafeAndroidRuntime.control) throw e;
            } //End block
        } //End collapsed parenthetic
        {
            byte tc;
            tc = nextTC();
            //Begin case TC_CLASS 
            Object varB3FB1D39699E6D2A442B5D236B57E977_709435476 = (readNewClass(unshared));
            //End case TC_CLASS 
            //Begin case TC_CLASSDESC 
            Object varDC57314283A93F6AAD1AC02CF35AE81E_1960828830 = (readNewClassDesc(unshared));
            //End case TC_CLASSDESC 
            //Begin case TC_ARRAY 
            Object var9A06C91A900F304B8C4AD583BAF3F655_2091774953 = (readNewArray(unshared));
            //End case TC_ARRAY 
            //Begin case TC_OBJECT 
            Object var7739C6CE4DB43D1D0CF968D28B122F01_162473040 = (readNewObject(unshared));
            //End case TC_OBJECT 
            //Begin case TC_STRING 
            Object varD19DC5B860F0E4F45A456286338A5DF3_289464249 = (readNewString(unshared));
            //End case TC_STRING 
            //Begin case TC_LONGSTRING 
            Object varB631EAE4A3B125D54449113B508423A0_25207419 = (readNewLongString(unshared));
            //End case TC_LONGSTRING 
            //Begin case TC_ENUM 
            Object var86DB4B9F76426BBD3FC17213342B35DA_1619997017 = (readEnum(unshared));
            //End case TC_ENUM 
            //Begin case TC_REFERENCE 
            {
                readNewHandle();
                if (DroidSafeAndroidRuntime.control) throw new InvalidObjectException("Unshared read of back reference");
            } //End block
            //End case TC_REFERENCE 
            //Begin case TC_REFERENCE 
            Object var271BCD20D7158D56AC0028AF6D4342B2_1153311689 = (readCyclicReference());
            //End case TC_REFERENCE 
            //Begin case TC_EXCEPTION 
            Exception exc;
            exc = readException();
            //End case TC_EXCEPTION 
            //Begin case TC_EXCEPTION 
            if (DroidSafeAndroidRuntime.control) throw new WriteAbortedException("Read an exception", exc);
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
            if (DroidSafeAndroidRuntime.control) throw e;
            //End case TC_ENDBLOCKDATA 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw corruptStream(tc);
            //End case default 
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.896 -0400", hash_original_method = "821B45232EA8F88246A504603C8240EF", hash_generated_method = "9E7BFDD98B55FCA4ED0DEBF02902D36A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object readCyclicReference() throws InvalidObjectException, IOException {
        Object var7B9D59D1124BEAE11BB1E4097F27FDBF_1599614273 = (registeredObjectRead(readNewHandle()));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return registeredObjectRead(readNewHandle());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.896 -0400", hash_original_method = "7C91F28BD77A4ED641420E614D9FCB15", hash_generated_method = "83910CB724C1A9EC3E989A4A752489BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public double readDouble() throws IOException {
        double var42D1EAD188298802018D182CA96F7EC6_595273365 = (primitiveTypes.readDouble());
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return primitiveTypes.readDouble();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.896 -0400", hash_original_method = "BA11A34B6A0BFC2FA522B0508C6E225C", hash_generated_method = "4113361DE562D161CA61697F3421756E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.897 -0400", hash_original_method = "FA3DFED5FC7EE2104F3E818CA56DCFE9", hash_generated_method = "AABC338AEAF60C71D245652E6426C1D7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.897 -0400", hash_original_method = "35D23573908F6AA48B37BF1647A74D3F", hash_generated_method = "79189FBE2EC6B4160BEE3DF3ECD5A3AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public GetField readFields() throws IOException, ClassNotFoundException, NotActiveException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NotActiveException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.905 -0400", hash_original_method = "8289C081F35F5F257A7DE20983B5F39B", hash_generated_method = "4E49A4B52E19B6805074C7CCD683C66F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readFieldValues(EmulatedFieldsForLoading emulatedFields) throws OptionalDataException, InvalidClassException, IOException {
        dsTaint.addTaint(emulatedFields.dsTaint);
        EmulatedFields.ObjectSlot[] slots;
        slots = emulatedFields.emulatedFields().slots();
        {
            ObjectSlot element = slots[0];
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
                        if (DroidSafeAndroidRuntime.control) throw new InvalidClassException(cnf.toString());
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.933 -0400", hash_original_method = "3FF4AC35875B69602347D8B467CAEB0A", hash_generated_method = "13E826FCE5412200B79A8346D1BC8C9E")
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
            if (DroidSafeAndroidRuntime.control) throw new ClassNotFoundException(classDesc.getName());
        } //End block
        {
            ObjectStreamField fieldDesc = fields[0];
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
                        boolean varC187ADE01525F471F8592C2BAF193B77_1207903987 = (fieldDesc.isUnshared());
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
                                boolean var74C1BEDB7218CB2DF56B6BCB99B9FB95_989738776 = (!fieldType.isAssignableFrom(valueType));
                                {
                                    if (DroidSafeAndroidRuntime.control) throw new ClassCastException(classDesc.getName() + "." + fieldName + " - " + fieldType + " not compatible with " + valueType);
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
                    if (DroidSafeAndroidRuntime.control) throw new AssertionError(iae);
                } //End block
                catch (NoSuchFieldError ignored)
                { }
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.934 -0400", hash_original_method = "E7BFAC98C28E1C1B49BD33FC0E76EA53", hash_generated_method = "34AB1929CD53D46ECA9E76B82C32A255")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float readFloat() throws IOException {
        float var7E9E584C6FD2DEB4403B27097B587FBB_2129196046 = (primitiveTypes.readFloat());
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return primitiveTypes.readFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.934 -0400", hash_original_method = "917418BB5C848A4690F4E96972002BAD", hash_generated_method = "FE0248609769A9CEAF3E2BA9BA42EE8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void readFully(byte[] dst) throws IOException {
        dsTaint.addTaint(dst[0]);
        primitiveTypes.readFully(dst);
        // ---------- Original Method ----------
        //primitiveTypes.readFully(dst);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.935 -0400", hash_original_method = "046EB506BDA13B9ED79306898615169A", hash_generated_method = "E7E5E45EB15804422C2B636EFAD0AC08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void readFully(byte[] dst, int offset, int byteCount) throws IOException {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(dst[0]);
        dsTaint.addTaint(offset);
        primitiveTypes.readFully(dst, offset, byteCount);
        // ---------- Original Method ----------
        //primitiveTypes.readFully(dst, offset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.948 -0400", hash_original_method = "D8B45244A94A62B53D8A8E2E7C864422", hash_generated_method = "1B04895DAE14BA02B08A706C0314EEF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readHierarchy(Object object, ObjectStreamClass classDesc) throws IOException, ClassNotFoundException, NotActiveException {
        dsTaint.addTaint(object.dsTaint);
        dsTaint.addTaint(classDesc.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NotActiveException();
        } //End block
        List<ObjectStreamClass> streamClassList;
        streamClassList = classDesc.getHierarchy();
        {
            {
                Iterator<ObjectStreamClass> var053A1EC5A2A31FD005C51939A1546787_1143324691 = (streamClassList).iterator();
                var053A1EC5A2A31FD005C51939A1546787_1143324691.hasNext();
                ObjectStreamClass objectStreamClass = var053A1EC5A2A31FD005C51939A1546787_1143324691.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.948 -0400", hash_original_method = "F09DF984FD463C1BCDA606260FD08FFE", hash_generated_method = "D45C9E5182EAEE2D220AE4EF6C6971F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.949 -0400", hash_original_method = "30EFDC31EF83C1843078545357CDA4A5", hash_generated_method = "26EA48F85C3D0320AD042C573DEF4D6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int findStreamSuperclass(Class<?> cl, List<ObjectStreamClass> classList, int lastIndex) {
        dsTaint.addTaint(lastIndex);
        dsTaint.addTaint(classList.dsTaint);
        dsTaint.addTaint(cl.dsTaint);
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
                    boolean var231414704491DDAEEB5B177CB6BDCCB3_605289351 = (objCl.getName().equals(forName));
                    {
                        {
                            boolean varB1DEEBE6B0B17CA7084086DE8FDC42C2_1055769261 = (cl.getName().equals(objCl.getName()));
                        } //End collapsed parenthetic
                    } //End block
                    {
                        {
                            boolean var7039F19E84FDA9D92190D2C9D5A9C382_1297871157 = (cl.getName().equals(forName));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.949 -0400", hash_original_method = "868BCCA0967481794CFA1D8D3E56D3E6", hash_generated_method = "0670C43F6066BE60E60C7AFDF58E925A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObjectNoData(Object object, Class<?> cl, ObjectStreamClass classDesc) throws ObjectStreamException {
        dsTaint.addTaint(cl.dsTaint);
        dsTaint.addTaint(object.dsTaint);
        dsTaint.addTaint(classDesc.dsTaint);
        {
            boolean varC6302AF1FA07AAAD1767E048D3B78E8B_1668583668 = (!classDesc.isSerializable());
        } //End collapsed parenthetic
        {
            boolean var6FEFF8B6EB65DC0C85ADA74F8DE4B91F_1950980804 = (classDesc.hasMethodReadObjectNoData());
            {
                Method readMethod;
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
                        if (DroidSafeAndroidRuntime.control) throw (RuntimeException) ex;
                    } //End block
                    {
                        if (DroidSafeAndroidRuntime.control) throw (Error) ex;
                    } //End block
                    if (DroidSafeAndroidRuntime.control) throw (ObjectStreamException) ex;
                } //End block
                catch (IllegalAccessException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.950 -0400", hash_original_method = "6119E962BBCC069017D862716C24BEC0", hash_generated_method = "BE4B8CF7E1F150A88268DD52EF84DEA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObjectForClass(Object object, ObjectStreamClass classDesc) throws IOException, ClassNotFoundException, NotActiveException {
        dsTaint.addTaint(object.dsTaint);
        dsTaint.addTaint(classDesc.dsTaint);
        boolean hadWriteMethod;
        hadWriteMethod = (classDesc.getFlags() & SC_WRITE_METHOD) != 0;
        Class<?> targetClass;
        targetClass = classDesc.forClass();
        Method readMethod;
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
                        if (DroidSafeAndroidRuntime.control) throw (ClassNotFoundException) ex;
                    } //End block
                    {
                        if (DroidSafeAndroidRuntime.control) throw (RuntimeException) ex;
                    } //End block
                    {
                        if (DroidSafeAndroidRuntime.control) throw (Error) ex;
                    } //End block
                    if (DroidSafeAndroidRuntime.control) throw (IOException) ex;
                } //End block
                catch (IllegalAccessException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.950 -0400", hash_original_method = "D31E8D2825D4043295F3D0C685B93717", hash_generated_method = "0B1669D53FBC8C016F124C164E837216")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int readInt() throws IOException {
        int varE840EF94E99C72456F8C1D024800AFEF_259518879 = (primitiveTypes.readInt());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return primitiveTypes.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.950 -0400", hash_original_method = "90EA71A98921C4D093F2F0BA4DDBE95D", hash_generated_method = "CD261EC6FBA98D147CAC9129AEA78E17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public String readLine() throws IOException {
        String var76C98081C14306C47F719AC41BB40770_1545718228 = (primitiveTypes.readLine());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return primitiveTypes.readLine();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.950 -0400", hash_original_method = "70C9FFE9F08A2EBCF32FC4C20D730AD7", hash_generated_method = "05F708D7FF95789CD2D6C381F57EE4C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long readLong() throws IOException {
        long var92AA3E55B0DEEBFF8ACE4E90B4B38BFC_2085502898 = (primitiveTypes.readLong());
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return primitiveTypes.readLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.951 -0400", hash_original_method = "6C628531F4475FFAEEB816E877548000", hash_generated_method = "7DF8AD730121C750D9B6AED734587CE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object readNewArray(boolean unshared) throws OptionalDataException,
            ClassNotFoundException, IOException {
        dsTaint.addTaint(unshared);
        ObjectStreamClass classDesc;
        classDesc = readClassDesc();
        {
            if (DroidSafeAndroidRuntime.control) throw missingClassDescriptor();
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
            boolean varD34D6340EB041A4E3567A6A53D064A1F_921146164 = (componentType.isPrimitive());
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
                    if (DroidSafeAndroidRuntime.control) throw new ClassNotFoundException("Wrong base type in " + classDesc.getName());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.952 -0400", hash_original_method = "5D3FFF38041945ED84D75A0CC474793D", hash_generated_method = "3A005CB523627DA5301F4AE3D7A494A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Class<?> readNewClass(boolean unshared) throws ClassNotFoundException, IOException {
        dsTaint.addTaint(unshared);
        ObjectStreamClass classDesc;
        classDesc = readClassDesc();
        {
            if (DroidSafeAndroidRuntime.control) throw missingClassDescriptor();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.952 -0400", hash_original_method = "D16FAEE9BB99888884BA2510B9D0161D", hash_generated_method = "BA37B07E85984B74074927C569E020FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ObjectStreamClass readEnumDesc() throws IOException,
            ClassNotFoundException {
        byte tc;
        tc = nextTC();
        //Begin case TC_CLASSDESC 
        ObjectStreamClass var70012381CDB5550C6DE4D9227432C12B_720096454 = (readEnumDescInternal());
        //End case TC_CLASSDESC 
        //Begin case TC_REFERENCE 
        ObjectStreamClass var41AE2590E5AE43F9C604C548CB534E0B_2140356746 = ((ObjectStreamClass) readCyclicReference());
        //End case TC_REFERENCE 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw corruptStream(tc);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.953 -0400", hash_original_method = "58EE21B582EE01373F973D50B42B8A60", hash_generated_method = "EE2CCBF4BEFC076066A23CC82F281333")
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
            boolean varDEA6609B69DA5649FF02F7EEB3B9D4F7_1964011942 = (0L != classDesc.getSerialVersionUID() || 0L != superClass.getSerialVersionUID());
            {
                if (DroidSafeAndroidRuntime.control) throw new InvalidClassException(superClass.getName(),
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.953 -0400", hash_original_method = "0BB1D7ADA0D4FC987B96FE9D538B84F1", hash_generated_method = "80203320C4A819C88AAAF37FC8059EF7")
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
            if (DroidSafeAndroidRuntime.control) throw new InvalidObjectException("Unshared read of back reference");
        } //End block
        //End case TC_REFERENCE 
        //Begin case TC_REFERENCE 
        name = (String) readCyclicReference();
        //End case TC_REFERENCE 
        //Begin case TC_STRING 
        name = (String) readNewString(unshared);
        //End case TC_STRING 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw corruptStream(tc);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.960 -0400", hash_original_method = "85A17F1C0F9F03F0EE48936822125550", hash_generated_method = "D267A76AD5C31B6C09F634E60FAA1EC7")
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
                if (DroidSafeAndroidRuntime.control) throw e;
            } //End block
        } //End block
        ObjectStreamField[] fields;
        fields = newClassDesc.getLoadFields();
        fields = (fields == null) ? ObjectStreamClass.NO_FIELDS : fields;
        ClassLoader loader;
        boolean var47BDE074D2A177403E07EAFF053D9C91_1010465471 = (newClassDesc.forClass() == null);
        loader = callerClassLoader;
        loader = newClassDesc.forClass().getClassLoader();
        {
            ObjectStreamField element = fields[0];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.960 -0400", hash_original_method = "9592596F093477979EA31311F339CD7D", hash_generated_method = "9759A70BA13E70E6B76298AA0C62B224")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.961 -0400", hash_original_method = "97948A412F94E7F820143192C44DB303", hash_generated_method = "61A338B00F2943D4C0674BBF3207B8C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
        ObjectStreamClass newClassDesc;
        newClassDesc = new ObjectStreamClass();
        String name;
        name = input.readUTF();
        {
            boolean var162A1A174B912EA806BA20275BF238E6_1764142492 = (name.length() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("The stream is corrupted");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.961 -0400", hash_original_method = "C938C68924527CB04F806429B3BE928F", hash_generated_method = "CE8A34E92B39534A5057F31C6AFA1E9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Class<?> resolveProxyClass(String[] interfaceNames) throws IOException, ClassNotFoundException {
        dsTaint.addTaint(interfaceNames[0]);
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
            Class<?> varDF634AB46FA6B6D516C20C557D2F5A52_1124715246 = (Proxy.getProxyClass(loader, interfaces));
        } //End block
        catch (IllegalArgumentException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ClassNotFoundException(e.toString(), e);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.961 -0400", hash_original_method = "11D3D467DA55FCE7098C1D9AB901525D", hash_generated_method = "B8637BBD6CC094CB6EFDC4BCAD53C146")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int readNewHandle() throws IOException {
        int var4605C3BBD7F83DAEC21E27D6EA87F85C_150157867 = (input.readInt());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return input.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.962 -0400", hash_original_method = "B0A36455F033DD06E1C6357D1966CB2A", hash_generated_method = "F381FE6B4A85A0AD7A0AC10D1B1D9218")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object readNewObject(boolean unshared) throws OptionalDataException, ClassNotFoundException, IOException {
        dsTaint.addTaint(unshared);
        ObjectStreamClass classDesc;
        classDesc = readClassDesc();
        {
            if (DroidSafeAndroidRuntime.control) throw missingClassDescriptor();
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
                boolean varCAC8AACA1AE8B625201A6DC80248AF34_171782297 = (classDesc.hasMethodReadResolve());
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
                            if (DroidSafeAndroidRuntime.control) throw (ObjectStreamException) target;
                        } //End block
                        {
                            if (DroidSafeAndroidRuntime.control) throw (Error) target;
                        } //End block
                        {
                            if (DroidSafeAndroidRuntime.control) throw (RuntimeException) target;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.962 -0400", hash_original_method = "C5243F456C3574095BC1BB7FC2411373", hash_generated_method = "8CE0CCE5FA47F71CDFC8D1BDFEB826B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private InvalidClassException missingClassDescriptor() throws InvalidClassException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidClassException("Read null attempting to read class descriptor for object");
        return (InvalidClassException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new InvalidClassException("Read null attempting to read class descriptor for object");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.963 -0400", hash_original_method = "CF984AE9FCCB80A5CA5459E50D42D99D", hash_generated_method = "7084FFDBD62382B17D425C0A396DF5DE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.963 -0400", hash_original_method = "E3603577D9590FDF3626C23DB61D460D", hash_generated_method = "288A10116BB983777A04D406B8AFC265")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.963 -0400", hash_original_method = "D5CBFBA6D0DD1CCB325BD55A2992CB88", hash_generated_method = "A51E98D7916C47F8A4D62D2EF84D4B0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Object readObject() throws OptionalDataException,
            ClassNotFoundException, IOException {
        Object var63B7A6B4D2A2E42961D4AD40E7A10DDC_338644939 = (readObject(false));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return readObject(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.963 -0400", hash_original_method = "B5062D634E2B9403462F68486501694A", hash_generated_method = "DE69D2660652F641A2D0834BF347FE65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object readUnshared() throws IOException, ClassNotFoundException {
        Object varED54F4B5F2B71159C493DEF7611AC7E7_1882651622 = (readObject(true));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return readObject(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.973 -0400", hash_original_method = "E655B580AAC2F65ED2F044289942F1C0", hash_generated_method = "D228B6AA10320E6A9035C450A5DCAC44")
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
            Object var90933ED2D456AE6BAC250EBABAD4F89B_2043290586 = (readObjectOverride());
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
                    InputValidationDesc element = validations[0];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.974 -0400", hash_original_method = "F453836DFC9EEC175FFF65A0C41AF32F", hash_generated_method = "C413EB1DB29FBF4FD2CC99AE0CC932C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Object readObjectOverride() throws OptionalDataException,
            ClassNotFoundException, IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (input == null) {
            //return null;
        //}
        //throw new IOException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.974 -0400", hash_original_method = "E1F1666A9CC2BCC43C42662EA935D779", hash_generated_method = "53C58441EF024C89B25FBE2FD8475C10")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public short readShort() throws IOException {
        short varCDA22C267187CEE310BF77CF189DA7D6_775285119 = (primitiveTypes.readShort());
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return primitiveTypes.readShort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.974 -0400", hash_original_method = "2E049C52CD4079E3EDC13878B612AD59", hash_generated_method = "6D1F2F25542F7BB14858A17C48CFA321")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void readStreamHeader() throws IOException,
            StreamCorruptedException {
        {
            boolean varC19679871E5EE3ACDCBC6AB5CDD35F45_427283619 = (input.readShort() == STREAM_MAGIC
                && input.readShort() == STREAM_VERSION);
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new StreamCorruptedException();
        // ---------- Original Method ----------
        //if (input.readShort() == STREAM_MAGIC
                //&& input.readShort() == STREAM_VERSION) {
            //return;
        //}
        //throw new StreamCorruptedException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.974 -0400", hash_original_method = "50996F70792020DA658FB7FFCF1EF910", hash_generated_method = "7773B649DEA90E0F13CD30944AD721C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int readUnsignedByte() throws IOException {
        int varB7F3DDCB7C33CADCD69A9EA77340018F_975603938 = (primitiveTypes.readUnsignedByte());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return primitiveTypes.readUnsignedByte();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.974 -0400", hash_original_method = "ABA376385639B6CB8F725C68F1CED979", hash_generated_method = "33D8EECCAF724752DACE54B56D25CDF3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int readUnsignedShort() throws IOException {
        int var8B6F0F8EF6EFAE22F469847E9560AC03_1454866963 = (primitiveTypes.readUnsignedShort());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return primitiveTypes.readUnsignedShort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.975 -0400", hash_original_method = "B2994D3A3B821949D517613320FA5065", hash_generated_method = "3057B69FCB2144379BA3D5A980811480")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String readUTF() throws IOException {
        String var28664681DF1DE10C21CC89E508B3FF93_890420381 = (primitiveTypes.readUTF());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return primitiveTypes.readUTF();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.975 -0400", hash_original_method = "10F65D1907C5AA72A1571FB08139A1C8", hash_generated_method = "44CD92EB46372D780979F458AC1AA545")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object registeredObjectRead(int handle) throws InvalidObjectException {
        dsTaint.addTaint(handle);
        Object res;
        res = objectsRead.get(handle - ObjectStreamConstants.baseWireHandle);
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidObjectException("Cannot read back reference to unshared object");
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object res = objectsRead.get(handle - ObjectStreamConstants.baseWireHandle);
        //if (res == UNSHARED_OBJ) {
            //throw new InvalidObjectException("Cannot read back reference to unshared object");
        //}
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.975 -0400", hash_original_method = "9C8641A932863D3A6F3FA22233749F54", hash_generated_method = "DD51FB5C91BE0BF5D831D3A2FA7FFF0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.975 -0400", hash_original_method = "3EFB39BBE791BF6ED902F9D8BC5F60E3", hash_generated_method = "C45262BCBEA90A6062899D7DCF794B4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void registerValidation(ObjectInputValidation object,
            int priority) throws NotActiveException, InvalidObjectException {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(priority);
        dsTaint.addTaint(object.dsTaint);
        Object instanceBeingRead;
        instanceBeingRead = this.currentObject;
        {
            if (DroidSafeAndroidRuntime.control) throw new NotActiveException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidObjectException("Callback object cannot be null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.976 -0400", hash_original_method = "7A01BA94C22B82138AACA44C7BC92DD9", hash_generated_method = "0C73C6216D604266ED6256169E691209")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void resetSeenObjects() {
        objectsRead = new ArrayList<Object>();
        nextHandle = baseWireHandle;
        primitiveData = emptyStream;
        // ---------- Original Method ----------
        //objectsRead = new ArrayList<Object>();
        //nextHandle = baseWireHandle;
        //primitiveData = emptyStream;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.976 -0400", hash_original_method = "356E50ACB0709EF4643021948AB5F291", hash_generated_method = "EC3D0E77128D57B1D4D0ED283DC54BAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void resetState() {
        resetSeenObjects();
        hasPushbackTC = false;
        pushbackTC = 0;
        // ---------- Original Method ----------
        //resetSeenObjects();
        //hasPushbackTC = false;
        //pushbackTC = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.976 -0400", hash_original_method = "38B51F7C504D6211D87B81513F39C956", hash_generated_method = "915E21F1E9ED040BDF9B8923805E3422")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.976 -0400", hash_original_method = "8BE1D9D2C1A8227AC3DEAA12C63F6442", hash_generated_method = "A6B4EE90B8EA812C887A314241170751")
    @DSModeled(DSC.SAFE)
    protected Object resolveObject(Object object) throws IOException {
        dsTaint.addTaint(object.dsTaint);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return object;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.977 -0400", hash_original_method = "C18A3B861F9E4DC00DB6D8F86113E96E", hash_generated_method = "104A9A679F9317AC95197E5D2D3C29CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int skipBytes(int length) throws IOException {
        dsTaint.addTaint(length);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.977 -0400", hash_original_method = "F18AA842F3AF8655FE4F963E8A31A757", hash_generated_method = "AA6201DCDC88E5CC73D5E64261794E5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void verifyAndInit(ObjectStreamClass loadedStreamClass) throws InvalidClassException {
        dsTaint.addTaint(loadedStreamClass.dsTaint);
        Class<?> localClass;
        localClass = loadedStreamClass.forClass();
        ObjectStreamClass localStreamClass;
        localStreamClass = ObjectStreamClass
                .lookupStreamClass(localClass);
        {
            boolean var9693CD9966488232124376137EBA8914_581480195 = (loadedStreamClass.getSerialVersionUID() != localStreamClass
                .getSerialVersionUID());
            {
                if (DroidSafeAndroidRuntime.control) throw new InvalidClassException(loadedStreamClass.getName(),
                    "Incompatible class (SUID): " + loadedStreamClass +
                            " but expected " + localStreamClass);
            } //End block
        } //End collapsed parenthetic
        String loadedClassBaseName;
        loadedClassBaseName = getBaseName(loadedStreamClass.getName());
        String localClassBaseName;
        localClassBaseName = getBaseName(localStreamClass.getName());
        {
            boolean varB90E1FD3EA27827ECD4177A803C71953_47389849 = (!loadedClassBaseName.equals(localClassBaseName));
            {
                if (DroidSafeAndroidRuntime.control) throw new InvalidClassException(loadedStreamClass.getName(),
                    String.format("Incompatible class (base name): %s but expected %s",
                            loadedClassBaseName, localClassBaseName));
            } //End block
        } //End collapsed parenthetic
        loadedStreamClass.initPrivateFields(localStreamClass);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static String getBaseName(String fullName) {
        int k = fullName.lastIndexOf('.');
        if (k == -1 || k == (fullName.length() - 1)) {
            return fullName;
        }
        return fullName.substring(k + 1);
    }

    
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.977 -0400", hash_original_method = "475896F7636AFE10919419ADA1EDEB89", hash_generated_method = "475896F7636AFE10919419ADA1EDEB89")
                public InputValidationDesc ()
        {
        }


    }


    
    public abstract static class GetField {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.977 -0400", hash_original_method = "9818772E414737EA101F7A6025FB3A8D", hash_generated_method = "9818772E414737EA101F7A6025FB3A8D")
                public GetField ()
        {
        }


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


    
    private static final Object UNSHARED_OBJ = new Object();
    private static final HashMap<String, Class<?>> PRIMITIVE_CLASSES = new HashMap<String, Class<?>>();
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
    
    private static final ClassLoader bootstrapLoader = Object.class.getClassLoader();
    private static final ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
}

