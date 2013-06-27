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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.529 -0400", hash_original_field = "559F34BD1B83DCCF42BD97118C30004D", hash_generated_field = "9C428AEC470C7B513A34BE33B758C61C")

    private InputStream emptyStream = new ByteArrayInputStream(EmptyArray.BYTE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.529 -0400", hash_original_field = "5A8A6215AD70C3096643367A265101CD", hash_generated_field = "C282E9AAC2D48EC47E345831218585FA")

    private boolean hasPushbackTC;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.529 -0400", hash_original_field = "E07029C787F995347976B5426FA51D79", hash_generated_field = "64B94603DBAD0B26BD5AE2F7439ED35E")

    private byte pushbackTC;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.529 -0400", hash_original_field = "993B80B15181215612E5959DB832BFAF", hash_generated_field = "123C8BF62BBC79B951F58B358976C3FF")

    private int nestedLevels;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.529 -0400", hash_original_field = "CB52CB1EDBEC59BDE75BA590938374FC", hash_generated_field = "FBF49E90A1B9879AE660F9886E842C8C")

    private int nextHandle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.529 -0400", hash_original_field = "A43C1B0AA53A0C908810C06AB1FF3967", hash_generated_field = "32FD79F94203B3CB4FB10D6979B3AE55")

    private DataInputStream input;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.529 -0400", hash_original_field = "8AFA05430C7155E00832EE4E25A1E3C4", hash_generated_field = "76093EED1B475C4F1E4C622B52BC7AC9")

    private DataInputStream primitiveTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.529 -0400", hash_original_field = "6AA631A1CF88716882035C982A3A5C5A", hash_generated_field = "28C1B2E39A3350A755888FD0A4428279")

    private InputStream primitiveData = emptyStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.529 -0400", hash_original_field = "814324F3D01F90BE0344B032BCDAEB46", hash_generated_field = "3240649A9311294AE1E098CB8F2A005F")

    private boolean enableResolve;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.529 -0400", hash_original_field = "324CFF805C6D6B99EE7C6FE654D64D06", hash_generated_field = "F79B8A3B52A523F03D688BC47873D2F6")

    private ArrayList<Object> objectsRead;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.529 -0400", hash_original_field = "895D2E18F5D2EA8F00F48DF2FB178E4D", hash_generated_field = "76736C274255A46E2AEB2CE593A1B428")

    private Object currentObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.530 -0400", hash_original_field = "457C5912366BE090D6A2931DE14CDA9E", hash_generated_field = "7035F4B44BC3AE389D42445F7A5655AC")

    private ObjectStreamClass currentClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.530 -0400", hash_original_field = "A81AAA0781C265056D03A0138CF839B3", hash_generated_field = "4E53F0CFC72A51A3B3CAAC6447A9F3B4")

    private InputValidationDesc[] validations;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.530 -0400", hash_original_field = "35C5D5BAEC9DA39A210149CA5A667705", hash_generated_field = "3690401F10D38FF2C8AB1C19B641B107")

    private boolean subclassOverridingImplementation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.530 -0400", hash_original_field = "0630628FEFA32E6BCF95C8130059DD84", hash_generated_field = "7E360A145DF451DC0144E812BE96A034")

    private ClassLoader callerClassLoader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.530 -0400", hash_original_field = "AFDD2451F1D1759C785DD591BC1506D8", hash_generated_field = "2DA36CFD381BE4CC041D9D9E401B490D")

    private boolean mustResolve = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.530 -0400", hash_original_field = "3A717ED2456CACB3BC0F8AE8881EF3AA", hash_generated_field = "2B0CB3B967646FBC95A533438216C0DF")

    private int descriptorHandle = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.530 -0400", hash_original_field = "C1487B64EE4D02CA5ED52EFDAA9A2E96", hash_generated_field = "FAF1B21A627FAB868C99C514185244A6")

    private HashMap<Class<?>, List<Class<?>>> cachedSuperclasses = new HashMap<Class<?>, List<Class<?>>>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.530 -0400", hash_original_method = "124623F0922D5D71F912D224AEC5FA85", hash_generated_method = "ACAF350C98F97636B8BC13996275E1E2")
    protected  ObjectInputStream() throws IOException {
        this.subclassOverridingImplementation = true;
        // ---------- Original Method ----------
        //this.subclassOverridingImplementation = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.532 -0400", hash_original_method = "15BB4AD74FE576D95ABFC0E40CC8A986", hash_generated_method = "703A8C3897973881276857A3F1438BAC")
    public  ObjectInputStream(InputStream input) throws StreamCorruptedException, IOException {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.544 -0400", hash_original_method = "CEC952E1AEB3FC5761C4573EC7C87AAE", hash_generated_method = "E0D03FCF5671616235C2511D4518F522")
    @Override
    public int available() throws IOException {
        checkReadPrimitiveTypes();
        int var396FA1B30BCA352A1497967EC8829CF5_1391535002 = (primitiveData.available());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_902538519 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_902538519;
        // ---------- Original Method ----------
        //checkReadPrimitiveTypes();
        //return primitiveData.available();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.545 -0400", hash_original_method = "5DD662298FB99DC11E3F5A1BB4812CC0", hash_generated_method = "B9FDD8044681B06F9D9AD298EC135DCF")
    private void checkReadPrimitiveTypes() throws IOException {
        {
            boolean var429099FA06AFA9946D3FE9CA9E9D4FD2_223469177 = (primitiveData == input || primitiveData.available() > 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.545 -0400", hash_original_method = "4ECD43BBA7F31E748521530C375A35B5", hash_generated_method = "EBCAB811F86091C4F8C851B059031D05")
    @Override
    public void close() throws IOException {
        input.close();
        // ---------- Original Method ----------
        //input.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.545 -0400", hash_original_method = "6463B95302326251A8E319007FB9B6A5", hash_generated_method = "0BE8757C249A1BCDB14AE00D20DDA08A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.546 -0400", hash_original_method = "970A975ADDA1CD42A4A6880D40629922", hash_generated_method = "575CBC8556E2DDCA2C156AA5152C836B")
    protected boolean enableResolveObject(boolean enable) {
        boolean originalValue;
        originalValue = enableResolve;
        enableResolve = enable;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1378714194 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1378714194;
        // ---------- Original Method ----------
        //boolean originalValue = enableResolve;
        //enableResolve = enable;
        //return originalValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.546 -0400", hash_original_method = "BEEE4D4B01DB5401D5A386ECF8653C53", hash_generated_method = "05D145F6AAFC1EFB3898DC8BEAEC144E")
    private int nextHandle() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_308073148 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_308073148;
        // ---------- Original Method ----------
        //return nextHandle++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.546 -0400", hash_original_method = "EA84EB3C5ACC30FA1515ABE6938E6E9B", hash_generated_method = "EBDB70AF3FF1CC40D2F873DABE20365D")
    private byte nextTC() throws IOException {
        {
            hasPushbackTC = false;
        } //End block
        {
            pushbackTC = input.readByte();
        } //End block
        byte var40EA57D3EE3C07BF1C102B466E1C3091_900745123 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_900745123;
        // ---------- Original Method ----------
        //if (hasPushbackTC) {
            //hasPushbackTC = false; 
        //} else {
            //pushbackTC = input.readByte();
        //}
        //return pushbackTC;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.555 -0400", hash_original_method = "056AB6ECFECE1087CD6299233C3046CF", hash_generated_method = "1AA917BD8C0785A0A281D56B178CD348")
    private void pushbackTC() {
        hasPushbackTC = true;
        // ---------- Original Method ----------
        //hasPushbackTC = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.556 -0400", hash_original_method = "87E37984C9E76D351365EC77DA0248F5", hash_generated_method = "6F7A3565F948DE81E76D6B4ECDE05160")
    @Override
    public int read() throws IOException {
        checkReadPrimitiveTypes();
        int varB707721DB93E7A7A4590241126489184_1776947382 = (primitiveData.read());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_230741607 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_230741607;
        // ---------- Original Method ----------
        //checkReadPrimitiveTypes();
        //return primitiveData.read();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.556 -0400", hash_original_method = "7E3B2630C90BBA61B0E7CD83B04481D2", hash_generated_method = "B26E5033D9ABEA0E8C977FE30C2BE902")
    @Override
    public int read(byte[] buffer, int offset, int length) throws IOException {
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
        checkReadPrimitiveTypes();
        int var8656D85F3F24DB8757358C0140B597A3_1886491956 = (primitiveData.read(buffer, offset, length));
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(length);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2102817796 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2102817796;
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buffer.length, offset, length);
        //if (length == 0) {
            //return 0;
        //}
        //checkReadPrimitiveTypes();
        //return primitiveData.read(buffer, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.557 -0400", hash_original_method = "35383BB5231F8136A4FECB09DEC2FE93", hash_generated_method = "969AE8CFE29469A7B58525F07251EA1C")
    private byte[] readBlockData() throws IOException {
        byte[] result;
        result = new byte[input.readByte() & 0xff];
        input.readFully(result);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1226421583 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1226421583;
        // ---------- Original Method ----------
        //byte[] result = new byte[input.readByte() & 0xff];
        //input.readFully(result);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.557 -0400", hash_original_method = "478D7B43D09CD1BAF3CA95670FAE291A", hash_generated_method = "07797A8B62BA448B672610A1764EC83C")
    private byte[] readBlockDataLong() throws IOException {
        byte[] result;
        result = new byte[input.readInt()];
        input.readFully(result);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_91174772 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_91174772;
        // ---------- Original Method ----------
        //byte[] result = new byte[input.readInt()];
        //input.readFully(result);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.557 -0400", hash_original_method = "43182B65F59B21B8425D068A4900EB3A", hash_generated_method = "1736A700FF8AF11E8067AEE644A8C763")
    public boolean readBoolean() throws IOException {
        boolean varDCB0861A4BE9F65D653AD47B971965CF_1701328117 = (primitiveTypes.readBoolean());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1955369022 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1955369022;
        // ---------- Original Method ----------
        //return primitiveTypes.readBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.558 -0400", hash_original_method = "F1C938A529B536DE0EA7C0848AC19388", hash_generated_method = "D3E9056B11AE29C0865BC998CDB41271")
    public byte readByte() throws IOException {
        byte varD0FBD5DD4443B7C0CAB658ACAA09D8C9_174485338 = (primitiveTypes.readByte());
        byte var40EA57D3EE3C07BF1C102B466E1C3091_1072158253 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1072158253;
        // ---------- Original Method ----------
        //return primitiveTypes.readByte();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.558 -0400", hash_original_method = "08C7569945A67E2D251F3B449209E666", hash_generated_method = "ADEEA07FA59EB078EC94C72922652197")
    public char readChar() throws IOException {
        char var4C12272AC58BE571107F61420B43FEF4_616842028 = (primitiveTypes.readChar());
        char varA87DEB01C5F539E6BDA34829C8EF2368_1366099544 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1366099544;
        // ---------- Original Method ----------
        //return primitiveTypes.readChar();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.559 -0400", hash_original_method = "7E3D613702E21574BA96B289FBA102EA", hash_generated_method = "F0DF5597239337EBCBE42420F180D818")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.562 -0400", hash_original_method = "8425AE4559FEB283CFFC129B3DDD377F", hash_generated_method = "AE6EE0E1D38813AC02AB03A9B70F5631")
    private ObjectStreamClass readClassDesc() throws ClassNotFoundException, IOException {
        ObjectStreamClass varB4EAC82CA7396A68D541C85D26508E83_1060373666 = null; //Variable for return #1
        ObjectStreamClass varB4EAC82CA7396A68D541C85D26508E83_1379591046 = null; //Variable for return #2
        ObjectStreamClass varB4EAC82CA7396A68D541C85D26508E83_1995227715 = null; //Variable for return #3
        ObjectStreamClass varB4EAC82CA7396A68D541C85D26508E83_518889757 = null; //Variable for return #4
        byte tc;
        tc = nextTC();
        //Begin case TC_CLASSDESC 
        varB4EAC82CA7396A68D541C85D26508E83_1060373666 = readNewClassDesc(false);
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
        //Begin case TC_PROXYCLASSDESC 
        varB4EAC82CA7396A68D541C85D26508E83_1379591046 = streamClass;
        //End case TC_PROXYCLASSDESC 
        //Begin case TC_REFERENCE 
        varB4EAC82CA7396A68D541C85D26508E83_1995227715 = (ObjectStreamClass) readCyclicReference();
        //End case TC_REFERENCE 
        //Begin case TC_NULL 
        varB4EAC82CA7396A68D541C85D26508E83_518889757 = null;
        //End case TC_NULL 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw corruptStream(tc);
        //End case default 
        ObjectStreamClass varA7E53CE21691AB073D9660D615818899_646385244; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_646385244 = varB4EAC82CA7396A68D541C85D26508E83_1060373666;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_646385244 = varB4EAC82CA7396A68D541C85D26508E83_1379591046;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_646385244 = varB4EAC82CA7396A68D541C85D26508E83_1995227715;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_646385244 = varB4EAC82CA7396A68D541C85D26508E83_518889757;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_646385244.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_646385244;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.563 -0400", hash_original_method = "D1B003D7ABBBCEF0B15D64544C91AEEF", hash_generated_method = "BCE352FED1EFC0F54DEBCF205CFACE1A")
    private StreamCorruptedException corruptStream(byte tc) throws StreamCorruptedException {
        if (DroidSafeAndroidRuntime.control) throw new StreamCorruptedException("Wrong format: " + Integer.toHexString(tc & 0xff));
        addTaint(tc);
        // ---------- Original Method ----------
        //throw new StreamCorruptedException("Wrong format: " + Integer.toHexString(tc & 0xff));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.564 -0400", hash_original_method = "EBF146E3B3C2508DCA0D721582A75609", hash_generated_method = "AA2E584DBEC682B1D93CB1C2DC0A42E7")
    private Object readContent(byte tc) throws ClassNotFoundException,
            IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1811629754 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_30383251 = null; //Variable for return #2
        Object varB4EAC82CA7396A68D541C85D26508E83_1748417273 = null; //Variable for return #3
        Object varB4EAC82CA7396A68D541C85D26508E83_1136586882 = null; //Variable for return #4
        Object varB4EAC82CA7396A68D541C85D26508E83_506513628 = null; //Variable for return #5
        Object varB4EAC82CA7396A68D541C85D26508E83_778741247 = null; //Variable for return #6
        Object varB4EAC82CA7396A68D541C85D26508E83_1737479138 = null; //Variable for return #7
        Object varB4EAC82CA7396A68D541C85D26508E83_1973840883 = null; //Variable for return #8
        Object varB4EAC82CA7396A68D541C85D26508E83_1736930478 = null; //Variable for return #9
        Object varB4EAC82CA7396A68D541C85D26508E83_644353666 = null; //Variable for return #10
        Object varB4EAC82CA7396A68D541C85D26508E83_1582761685 = null; //Variable for return #11
        //Begin case TC_BLOCKDATA 
        varB4EAC82CA7396A68D541C85D26508E83_1811629754 = readBlockData();
        //End case TC_BLOCKDATA 
        //Begin case TC_BLOCKDATALONG 
        varB4EAC82CA7396A68D541C85D26508E83_30383251 = readBlockDataLong();
        //End case TC_BLOCKDATALONG 
        //Begin case TC_CLASS 
        varB4EAC82CA7396A68D541C85D26508E83_1748417273 = readNewClass(false);
        //End case TC_CLASS 
        //Begin case TC_CLASSDESC 
        varB4EAC82CA7396A68D541C85D26508E83_1136586882 = readNewClassDesc(false);
        //End case TC_CLASSDESC 
        //Begin case TC_ARRAY 
        varB4EAC82CA7396A68D541C85D26508E83_506513628 = readNewArray(false);
        //End case TC_ARRAY 
        //Begin case TC_OBJECT 
        varB4EAC82CA7396A68D541C85D26508E83_778741247 = readNewObject(false);
        //End case TC_OBJECT 
        //Begin case TC_STRING 
        varB4EAC82CA7396A68D541C85D26508E83_1737479138 = readNewString(false);
        //End case TC_STRING 
        //Begin case TC_LONGSTRING 
        varB4EAC82CA7396A68D541C85D26508E83_1973840883 = readNewLongString(false);
        //End case TC_LONGSTRING 
        //Begin case TC_REFERENCE 
        varB4EAC82CA7396A68D541C85D26508E83_1736930478 = readCyclicReference();
        //End case TC_REFERENCE 
        //Begin case TC_NULL 
        varB4EAC82CA7396A68D541C85D26508E83_644353666 = null;
        //End case TC_NULL 
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
        //Begin case TC_RESET 
        varB4EAC82CA7396A68D541C85D26508E83_1582761685 = null;
        //End case TC_RESET 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw corruptStream(tc);
        //End case default 
        addTaint(tc);
        Object varA7E53CE21691AB073D9660D615818899_1320576574; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1320576574 = varB4EAC82CA7396A68D541C85D26508E83_1811629754;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1320576574 = varB4EAC82CA7396A68D541C85D26508E83_30383251;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1320576574 = varB4EAC82CA7396A68D541C85D26508E83_1748417273;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1320576574 = varB4EAC82CA7396A68D541C85D26508E83_1136586882;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1320576574 = varB4EAC82CA7396A68D541C85D26508E83_506513628;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1320576574 = varB4EAC82CA7396A68D541C85D26508E83_778741247;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_1320576574 = varB4EAC82CA7396A68D541C85D26508E83_1737479138;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_1320576574 = varB4EAC82CA7396A68D541C85D26508E83_1973840883;
                break;
            case 9: //Assign result for return ordinal #9
                varA7E53CE21691AB073D9660D615818899_1320576574 = varB4EAC82CA7396A68D541C85D26508E83_1736930478;
                break;
            case 10: //Assign result for return ordinal #10
                varA7E53CE21691AB073D9660D615818899_1320576574 = varB4EAC82CA7396A68D541C85D26508E83_644353666;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1320576574 = varB4EAC82CA7396A68D541C85D26508E83_1582761685;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1320576574.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1320576574;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.580 -0400", hash_original_method = "C964F7473D297E2F3A28B1C55493EBEA", hash_generated_method = "9D256768F32E269271072DADCB38BD75")
    private Object readNonPrimitiveContent(boolean unshared) throws ClassNotFoundException, IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_200354500 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1317273588 = null; //Variable for return #2
        Object varB4EAC82CA7396A68D541C85D26508E83_1645787087 = null; //Variable for return #3
        Object varB4EAC82CA7396A68D541C85D26508E83_69823490 = null; //Variable for return #4
        Object varB4EAC82CA7396A68D541C85D26508E83_1346449352 = null; //Variable for return #5
        Object varB4EAC82CA7396A68D541C85D26508E83_1739003203 = null; //Variable for return #6
        Object varB4EAC82CA7396A68D541C85D26508E83_874684430 = null; //Variable for return #7
        Object varB4EAC82CA7396A68D541C85D26508E83_1943665614 = null; //Variable for return #8
        Object varB4EAC82CA7396A68D541C85D26508E83_718448082 = null; //Variable for return #9
        checkReadPrimitiveTypes();
        {
            boolean varFE023E46CC4F9239294D15D3ADCB19E2_441736714 = (primitiveData.available() > 0);
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
            varB4EAC82CA7396A68D541C85D26508E83_200354500 = readNewClass(unshared);
            //End case TC_CLASS 
            //Begin case TC_CLASSDESC 
            varB4EAC82CA7396A68D541C85D26508E83_1317273588 = readNewClassDesc(unshared);
            //End case TC_CLASSDESC 
            //Begin case TC_ARRAY 
            varB4EAC82CA7396A68D541C85D26508E83_1645787087 = readNewArray(unshared);
            //End case TC_ARRAY 
            //Begin case TC_OBJECT 
            varB4EAC82CA7396A68D541C85D26508E83_69823490 = readNewObject(unshared);
            //End case TC_OBJECT 
            //Begin case TC_STRING 
            varB4EAC82CA7396A68D541C85D26508E83_1346449352 = readNewString(unshared);
            //End case TC_STRING 
            //Begin case TC_LONGSTRING 
            varB4EAC82CA7396A68D541C85D26508E83_1739003203 = readNewLongString(unshared);
            //End case TC_LONGSTRING 
            //Begin case TC_ENUM 
            varB4EAC82CA7396A68D541C85D26508E83_874684430 = readEnum(unshared);
            //End case TC_ENUM 
            //Begin case TC_REFERENCE 
            {
                readNewHandle();
                if (DroidSafeAndroidRuntime.control) throw new InvalidObjectException("Unshared read of back reference");
            } //End block
            //End case TC_REFERENCE 
            //Begin case TC_REFERENCE 
            varB4EAC82CA7396A68D541C85D26508E83_1943665614 = readCyclicReference();
            //End case TC_REFERENCE 
            //Begin case TC_NULL 
            varB4EAC82CA7396A68D541C85D26508E83_718448082 = null;
            //End case TC_NULL 
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
        addTaint(unshared);
        Object varA7E53CE21691AB073D9660D615818899_1400917547; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1400917547 = varB4EAC82CA7396A68D541C85D26508E83_200354500;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1400917547 = varB4EAC82CA7396A68D541C85D26508E83_1317273588;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1400917547 = varB4EAC82CA7396A68D541C85D26508E83_1645787087;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1400917547 = varB4EAC82CA7396A68D541C85D26508E83_69823490;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1400917547 = varB4EAC82CA7396A68D541C85D26508E83_1346449352;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1400917547 = varB4EAC82CA7396A68D541C85D26508E83_1739003203;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_1400917547 = varB4EAC82CA7396A68D541C85D26508E83_874684430;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_1400917547 = varB4EAC82CA7396A68D541C85D26508E83_1943665614;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1400917547 = varB4EAC82CA7396A68D541C85D26508E83_718448082;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1400917547.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1400917547;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.581 -0400", hash_original_method = "821B45232EA8F88246A504603C8240EF", hash_generated_method = "6D9F8D59DD1FDBD86182C2A45CB8494A")
    private Object readCyclicReference() throws InvalidObjectException, IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1999878177 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1999878177 = registeredObjectRead(readNewHandle());
        varB4EAC82CA7396A68D541C85D26508E83_1999878177.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1999878177;
        // ---------- Original Method ----------
        //return registeredObjectRead(readNewHandle());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.588 -0400", hash_original_method = "7C91F28BD77A4ED641420E614D9FCB15", hash_generated_method = "B07CF53DA02D48F315893E7983FA4A9C")
    public double readDouble() throws IOException {
        double var42D1EAD188298802018D182CA96F7EC6_835409783 = (primitiveTypes.readDouble());
        double varE8CD7DA078A86726031AD64F35F5A6C0_462968847 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_462968847;
        // ---------- Original Method ----------
        //return primitiveTypes.readDouble();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.588 -0400", hash_original_method = "BA11A34B6A0BFC2FA522B0508C6E225C", hash_generated_method = "4B8B7484012EC4AD840BEF603612F699")
    private Exception readException() throws WriteAbortedException,
            OptionalDataException, ClassNotFoundException, IOException {
        Exception varB4EAC82CA7396A68D541C85D26508E83_1649331507 = null; //Variable for return #1
        resetSeenObjects();
        Exception exc;
        exc = (Exception) readObject();
        resetSeenObjects();
        varB4EAC82CA7396A68D541C85D26508E83_1649331507 = exc;
        varB4EAC82CA7396A68D541C85D26508E83_1649331507.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1649331507;
        // ---------- Original Method ----------
        //resetSeenObjects();
        //Exception exc = (Exception) readObject();
        //resetSeenObjects();
        //return exc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.609 -0400", hash_original_method = "FA3DFED5FC7EE2104F3E818CA56DCFE9", hash_generated_method = "AA6B8B65A25E283C0D373DF2B389A73B")
    private void readFieldDescriptors(ObjectStreamClass cDesc) throws ClassNotFoundException, IOException {
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
        addTaint(cDesc.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.615 -0400", hash_original_method = "35D23573908F6AA48B37BF1647A74D3F", hash_generated_method = "B7C02228C4BCF5992E285B3424C4B56A")
    public GetField readFields() throws IOException, ClassNotFoundException, NotActiveException {
        GetField varB4EAC82CA7396A68D541C85D26508E83_1628445004 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NotActiveException();
        } //End block
        EmulatedFieldsForLoading result;
        result = new EmulatedFieldsForLoading(currentClass);
        readFieldValues(result);
        varB4EAC82CA7396A68D541C85D26508E83_1628445004 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1628445004.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1628445004;
        // ---------- Original Method ----------
        //if (currentObject == null) {
            //throw new NotActiveException();
        //}
        //EmulatedFieldsForLoading result = new EmulatedFieldsForLoading(currentClass);
        //readFieldValues(result);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.664 -0400", hash_original_method = "8289C081F35F5F257A7DE20983B5F39B", hash_generated_method = "C3D0F1CB7B7A2589BB02AAE5592B81E8")
    private void readFieldValues(EmulatedFieldsForLoading emulatedFields) throws OptionalDataException, InvalidClassException, IOException {
        EmulatedFields.ObjectSlot[] slots;
        slots = emulatedFields.emulatedFields().slots();
        {
            Iterator<ObjectSlot> var7E7554D29FC2145668FDB4F812764797_1327397626 = (slots).iterator();
            var7E7554D29FC2145668FDB4F812764797_1327397626.hasNext();
            ObjectSlot element = var7E7554D29FC2145668FDB4F812764797_1327397626.next();
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
        addTaint(emulatedFields.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.999 -0400", hash_original_method = "3FF4AC35875B69602347D8B467CAEB0A", hash_generated_method = "670F598FF81EB21FD146118E56EAC143")
    private void readFieldValues(Object obj, ObjectStreamClass classDesc) throws OptionalDataException, ClassNotFoundException, IOException {
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
                        boolean varC187ADE01525F471F8592C2BAF193B77_568522262 = (fieldDesc.isUnshared());
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
                                boolean var74C1BEDB7218CB2DF56B6BCB99B9FB95_2003682402 = (!fieldType.isAssignableFrom(valueType));
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
        addTaint(obj.getTaint());
        addTaint(classDesc.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.014 -0400", hash_original_method = "E7BFAC98C28E1C1B49BD33FC0E76EA53", hash_generated_method = "7E6A6CF611F505A57377A45B4929BD9C")
    public float readFloat() throws IOException {
        float var7E9E584C6FD2DEB4403B27097B587FBB_1160315485 = (primitiveTypes.readFloat());
        float var546ADE640B6EDFBC8A086EF31347E768_643339097 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_643339097;
        // ---------- Original Method ----------
        //return primitiveTypes.readFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.015 -0400", hash_original_method = "917418BB5C848A4690F4E96972002BAD", hash_generated_method = "A23903FF79BB25ED2104D29A0BF5C32E")
    public void readFully(byte[] dst) throws IOException {
        primitiveTypes.readFully(dst);
        addTaint(dst[0]);
        // ---------- Original Method ----------
        //primitiveTypes.readFully(dst);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.017 -0400", hash_original_method = "046EB506BDA13B9ED79306898615169A", hash_generated_method = "B62F6DDC8F06C9680A410C604CF03422")
    public void readFully(byte[] dst, int offset, int byteCount) throws IOException {
        primitiveTypes.readFully(dst, offset, byteCount);
        addTaint(dst[0]);
        addTaint(offset);
        addTaint(byteCount);
        // ---------- Original Method ----------
        //primitiveTypes.readFully(dst, offset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.075 -0400", hash_original_method = "D8B45244A94A62B53D8A8E2E7C864422", hash_generated_method = "E247604147918506F798229EEBB138E7")
    private void readHierarchy(Object object, ObjectStreamClass classDesc) throws IOException, ClassNotFoundException, NotActiveException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NotActiveException();
        } //End block
        List<ObjectStreamClass> streamClassList;
        streamClassList = classDesc.getHierarchy();
        {
            {
                Iterator<ObjectStreamClass> var053A1EC5A2A31FD005C51939A1546787_1889969151 = (streamClassList).iterator();
                var053A1EC5A2A31FD005C51939A1546787_1889969151.hasNext();
                ObjectStreamClass objectStreamClass = var053A1EC5A2A31FD005C51939A1546787_1889969151.next();
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
        addTaint(object.getTaint());
        addTaint(classDesc.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.080 -0400", hash_original_method = "F09DF984FD463C1BCDA606260FD08FFE", hash_generated_method = "50D2BE20C49FF9F9ED4E33A44B8E8B72")
    private List<Class<?>> cacheSuperclassesFor(Class<?> c) {
        List<Class<?>> varB4EAC82CA7396A68D541C85D26508E83_1091566335 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1091566335 = result;
        addTaint(c.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1091566335.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1091566335;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.082 -0400", hash_original_method = "30EFDC31EF83C1843078545357CDA4A5", hash_generated_method = "EF4C7DD026A7C5808082F4851EDBB6C4")
    private int findStreamSuperclass(Class<?> cl, List<ObjectStreamClass> classList, int lastIndex) {
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
                    boolean var231414704491DDAEEB5B177CB6BDCCB3_1087203590 = (objCl.getName().equals(forName));
                    {
                        {
                            boolean varB1DEEBE6B0B17CA7084086DE8FDC42C2_1782492334 = (cl.getName().equals(objCl.getName()));
                        } //End collapsed parenthetic
                    } //End block
                    {
                        {
                            boolean var7039F19E84FDA9D92190D2C9D5A9C382_1356264721 = (cl.getName().equals(forName));
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(cl.getTaint());
        addTaint(classList.getTaint());
        addTaint(lastIndex);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1567288184 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1567288184;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.083 -0400", hash_original_method = "868BCCA0967481794CFA1D8D3E56D3E6", hash_generated_method = "22FA539F0EE16F11A8A30E1397A9FE73")
    private void readObjectNoData(Object object, Class<?> cl, ObjectStreamClass classDesc) throws ObjectStreamException {
        {
            boolean varC6302AF1FA07AAAD1767E048D3B78E8B_454306661 = (!classDesc.isSerializable());
        } //End collapsed parenthetic
        {
            boolean var6FEFF8B6EB65DC0C85ADA74F8DE4B91F_1360568664 = (classDesc.hasMethodReadObjectNoData());
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
        addTaint(object.getTaint());
        addTaint(cl.getTaint());
        addTaint(classDesc.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.085 -0400", hash_original_method = "6119E962BBCC069017D862716C24BEC0", hash_generated_method = "223650A66F7835A2AB6524CC41BE3E0E")
    private void readObjectForClass(Object object, ObjectStreamClass classDesc) throws IOException, ClassNotFoundException, NotActiveException {
        currentObject = object;
        currentClass = classDesc;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.088 -0400", hash_original_method = "D31E8D2825D4043295F3D0C685B93717", hash_generated_method = "B60732199CEE41065A0009286430FC13")
    public int readInt() throws IOException {
        int varE840EF94E99C72456F8C1D024800AFEF_66868794 = (primitiveTypes.readInt());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1936407267 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1936407267;
        // ---------- Original Method ----------
        //return primitiveTypes.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.088 -0400", hash_original_method = "90EA71A98921C4D093F2F0BA4DDBE95D", hash_generated_method = "B5B43CABBD6CB17113C9F4BB5D7946A5")
    @Deprecated
    public String readLine() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_1980347871 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1980347871 = primitiveTypes.readLine();
        varB4EAC82CA7396A68D541C85D26508E83_1980347871.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1980347871;
        // ---------- Original Method ----------
        //return primitiveTypes.readLine();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.088 -0400", hash_original_method = "70C9FFE9F08A2EBCF32FC4C20D730AD7", hash_generated_method = "0F0A174B9BC7B45F268DCE0720ED5B15")
    public long readLong() throws IOException {
        long var92AA3E55B0DEEBFF8ACE4E90B4B38BFC_1466287145 = (primitiveTypes.readLong());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1250275269 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1250275269;
        // ---------- Original Method ----------
        //return primitiveTypes.readLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.102 -0400", hash_original_method = "6C628531F4475FFAEEB816E877548000", hash_generated_method = "15C9BC590452CE9A086A72AEE8B92F17")
    private Object readNewArray(boolean unshared) throws OptionalDataException,
            ClassNotFoundException, IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_972931307 = null; //Variable for return #1
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
            boolean varD34D6340EB041A4E3567A6A53D064A1F_211609060 = (componentType.isPrimitive());
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
        varB4EAC82CA7396A68D541C85D26508E83_972931307 = result;
        addTaint(unshared);
        varB4EAC82CA7396A68D541C85D26508E83_972931307.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_972931307;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.104 -0400", hash_original_method = "5D3FFF38041945ED84D75A0CC474793D", hash_generated_method = "A63815C9195EC0B8FF5487921094C8B5")
    private Class<?> readNewClass(boolean unshared) throws ClassNotFoundException, IOException {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1897231627 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1897231627 = localClass;
        addTaint(unshared);
        varB4EAC82CA7396A68D541C85D26508E83_1897231627.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1897231627;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.104 -0400", hash_original_method = "D16FAEE9BB99888884BA2510B9D0161D", hash_generated_method = "26A534E4C493029CA02BA38DE2202A09")
    private ObjectStreamClass readEnumDesc() throws IOException,
            ClassNotFoundException {
        ObjectStreamClass varB4EAC82CA7396A68D541C85D26508E83_197554329 = null; //Variable for return #1
        ObjectStreamClass varB4EAC82CA7396A68D541C85D26508E83_426685792 = null; //Variable for return #2
        ObjectStreamClass varB4EAC82CA7396A68D541C85D26508E83_1490238949 = null; //Variable for return #3
        byte tc;
        tc = nextTC();
        //Begin case TC_CLASSDESC 
        varB4EAC82CA7396A68D541C85D26508E83_197554329 = readEnumDescInternal();
        //End case TC_CLASSDESC 
        //Begin case TC_REFERENCE 
        varB4EAC82CA7396A68D541C85D26508E83_426685792 = (ObjectStreamClass) readCyclicReference();
        //End case TC_REFERENCE 
        //Begin case TC_NULL 
        varB4EAC82CA7396A68D541C85D26508E83_1490238949 = null;
        //End case TC_NULL 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw corruptStream(tc);
        //End case default 
        ObjectStreamClass varA7E53CE21691AB073D9660D615818899_976737547; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_976737547 = varB4EAC82CA7396A68D541C85D26508E83_197554329;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_976737547 = varB4EAC82CA7396A68D541C85D26508E83_426685792;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_976737547 = varB4EAC82CA7396A68D541C85D26508E83_1490238949;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_976737547.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_976737547;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.105 -0400", hash_original_method = "58EE21B582EE01373F973D50B42B8A60", hash_generated_method = "09902E79CB60B29D14EFD0075197908C")
    private ObjectStreamClass readEnumDescInternal() throws IOException, ClassNotFoundException {
        ObjectStreamClass varB4EAC82CA7396A68D541C85D26508E83_1513057918 = null; //Variable for return #1
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
            boolean varDEA6609B69DA5649FF02F7EEB3B9D4F7_1539058339 = (0L != classDesc.getSerialVersionUID() || 0L != superClass.getSerialVersionUID());
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
        varB4EAC82CA7396A68D541C85D26508E83_1513057918 = classDesc;
        varB4EAC82CA7396A68D541C85D26508E83_1513057918.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1513057918;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.109 -0400", hash_original_method = "0BB1D7ADA0D4FC987B96FE9D538B84F1", hash_generated_method = "B711AE48CD63EDFB62EC2EA0485CDF44")
    @SuppressWarnings("unchecked")
    private Object readEnum(boolean unshared) throws OptionalDataException,
            ClassNotFoundException, IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_2111764477 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_2111764477 = result;
        addTaint(unshared);
        varB4EAC82CA7396A68D541C85D26508E83_2111764477.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2111764477;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.174 -0400", hash_original_method = "85A17F1C0F9F03F0EE48936822125550", hash_generated_method = "8B443DAD93C7E000DA972F8B07B7FE4B")
    private ObjectStreamClass readNewClassDesc(boolean unshared) throws ClassNotFoundException, IOException {
        ObjectStreamClass varB4EAC82CA7396A68D541C85D26508E83_1492191168 = null; //Variable for return #1
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
        boolean var47BDE074D2A177403E07EAFF053D9C91_723934120 = (newClassDesc.forClass() == null);
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
        varB4EAC82CA7396A68D541C85D26508E83_1492191168 = newClassDesc;
        addTaint(unshared);
        varB4EAC82CA7396A68D541C85D26508E83_1492191168.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1492191168;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.175 -0400", hash_original_method = "9592596F093477979EA31311F339CD7D", hash_generated_method = "543FAFB9885311DFC587DF90B24029B1")
    private Class<?> readNewProxyClassDesc() throws ClassNotFoundException,
            IOException {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1570033793 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1570033793 = proxy;
        varB4EAC82CA7396A68D541C85D26508E83_1570033793.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1570033793;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.184 -0400", hash_original_method = "97948A412F94E7F820143192C44DB303", hash_generated_method = "96CC4AE28A584E49FA4D542F44631B99")
    protected ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
        ObjectStreamClass varB4EAC82CA7396A68D541C85D26508E83_1066811146 = null; //Variable for return #1
        ObjectStreamClass newClassDesc;
        newClassDesc = new ObjectStreamClass();
        String name;
        name = input.readUTF();
        {
            boolean var162A1A174B912EA806BA20275BF238E6_811826136 = (name.length() == 0);
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
        varB4EAC82CA7396A68D541C85D26508E83_1066811146 = newClassDesc;
        varB4EAC82CA7396A68D541C85D26508E83_1066811146.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1066811146;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.191 -0400", hash_original_method = "C938C68924527CB04F806429B3BE928F", hash_generated_method = "1CE9BCE16BD7964A4F6A316587D98727")
    protected Class<?> resolveProxyClass(String[] interfaceNames) throws IOException, ClassNotFoundException {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1207069616 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_1207069616 = Proxy.getProxyClass(loader, interfaces);
        } //End block
        catch (IllegalArgumentException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ClassNotFoundException(e.toString(), e);
        } //End block
        addTaint(interfaceNames[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1207069616.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1207069616;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.191 -0400", hash_original_method = "11D3D467DA55FCE7098C1D9AB901525D", hash_generated_method = "899CECA5A1E7DC02E98E40A849CE157E")
    private int readNewHandle() throws IOException {
        int var4605C3BBD7F83DAEC21E27D6EA87F85C_130009568 = (input.readInt());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_776429138 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_776429138;
        // ---------- Original Method ----------
        //return input.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.207 -0400", hash_original_method = "B0A36455F033DD06E1C6357D1966CB2A", hash_generated_method = "C902FB16ACD8FDE8E87956EBAE315FED")
    private Object readNewObject(boolean unshared) throws OptionalDataException, ClassNotFoundException, IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_668491132 = null; //Variable for return #1
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
                boolean varCAC8AACA1AE8B625201A6DC80248AF34_1038445929 = (classDesc.hasMethodReadResolve());
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
        varB4EAC82CA7396A68D541C85D26508E83_668491132 = result;
        addTaint(unshared);
        varB4EAC82CA7396A68D541C85D26508E83_668491132.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_668491132;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.208 -0400", hash_original_method = "C5243F456C3574095BC1BB7FC2411373", hash_generated_method = "E13724007C99633DF056E9A1FCB41842")
    private InvalidClassException missingClassDescriptor() throws InvalidClassException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidClassException("Read null attempting to read class descriptor for object");
        // ---------- Original Method ----------
        //throw new InvalidClassException("Read null attempting to read class descriptor for object");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.213 -0400", hash_original_method = "CF984AE9FCCB80A5CA5459E50D42D99D", hash_generated_method = "F20AF4B2148810A959DEADCA593B18F4")
    private Object readNewString(boolean unshared) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_143441462 = null; //Variable for return #1
        Object result;
        result = input.readUTF();
        {
            result = resolveObject(result);
        } //End block
        registerObjectRead(result, nextHandle(), unshared);
        varB4EAC82CA7396A68D541C85D26508E83_143441462 = result;
        addTaint(unshared);
        varB4EAC82CA7396A68D541C85D26508E83_143441462.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_143441462;
        // ---------- Original Method ----------
        //Object result = input.readUTF();
        //if (enableResolve) {
            //result = resolveObject(result);
        //}
        //registerObjectRead(result, nextHandle(), unshared);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.214 -0400", hash_original_method = "E3603577D9590FDF3626C23DB61D460D", hash_generated_method = "E475683129A1E3EDB2E26AEF1DC84807")
    private Object readNewLongString(boolean unshared) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1350311233 = null; //Variable for return #1
        long length;
        length = input.readLong();
        Object result;
        result = input.decodeUTF((int) length);
        {
            result = resolveObject(result);
        } //End block
        registerObjectRead(result, nextHandle(), unshared);
        varB4EAC82CA7396A68D541C85D26508E83_1350311233 = result;
        addTaint(unshared);
        varB4EAC82CA7396A68D541C85D26508E83_1350311233.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1350311233;
        // ---------- Original Method ----------
        //long length = input.readLong();
        //Object result = input.decodeUTF((int) length);
        //if (enableResolve) {
            //result = resolveObject(result);
        //}
        //registerObjectRead(result, nextHandle(), unshared);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.218 -0400", hash_original_method = "D5CBFBA6D0DD1CCB325BD55A2992CB88", hash_generated_method = "D3E5FDFDA779643B84721D947D8FA238")
    public final Object readObject() throws OptionalDataException,
            ClassNotFoundException, IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1318039228 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1318039228 = readObject(false);
        varB4EAC82CA7396A68D541C85D26508E83_1318039228.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1318039228;
        // ---------- Original Method ----------
        //return readObject(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.219 -0400", hash_original_method = "B5062D634E2B9403462F68486501694A", hash_generated_method = "56E5DF4A84F399EE2336CEA68C7B256B")
    public Object readUnshared() throws IOException, ClassNotFoundException {
        Object varB4EAC82CA7396A68D541C85D26508E83_2090314676 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2090314676 = readObject(true);
        varB4EAC82CA7396A68D541C85D26508E83_2090314676.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2090314676;
        // ---------- Original Method ----------
        //return readObject(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.338 -0400", hash_original_method = "E655B580AAC2F65ED2F044289942F1C0", hash_generated_method = "BF2F6DD4E7FD4A1C0BD0311D145B56F4")
    private Object readObject(boolean unshared) throws OptionalDataException,
            ClassNotFoundException, IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1857444259 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1545261280 = null; //Variable for return #2
        boolean restoreInput;
        restoreInput = (primitiveData == input);
        {
            primitiveData = emptyStream;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1857444259 = readObjectOverride();
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
        varB4EAC82CA7396A68D541C85D26508E83_1545261280 = result;
        addTaint(unshared);
        Object varA7E53CE21691AB073D9660D615818899_1846783957; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1846783957 = varB4EAC82CA7396A68D541C85D26508E83_1857444259;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1846783957 = varB4EAC82CA7396A68D541C85D26508E83_1545261280;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1846783957.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1846783957;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.350 -0400", hash_original_method = "F453836DFC9EEC175FFF65A0C41AF32F", hash_generated_method = "C378041F9409BE030450E5B895784DF9")
    protected Object readObjectOverride() throws OptionalDataException,
            ClassNotFoundException, IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_309238836 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_309238836 = null;
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new IOException();
        varB4EAC82CA7396A68D541C85D26508E83_309238836.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_309238836;
        // ---------- Original Method ----------
        //if (input == null) {
            //return null;
        //}
        //throw new IOException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.351 -0400", hash_original_method = "E1F1666A9CC2BCC43C42662EA935D779", hash_generated_method = "5C4064A7C033006B6488DC8E70FAF3DA")
    public short readShort() throws IOException {
        short varCDA22C267187CEE310BF77CF189DA7D6_397905916 = (primitiveTypes.readShort());
        short var4F09DAA9D95BCB166A302407A0E0BABE_197130713 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_197130713;
        // ---------- Original Method ----------
        //return primitiveTypes.readShort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.351 -0400", hash_original_method = "2E049C52CD4079E3EDC13878B612AD59", hash_generated_method = "66992AB75E4066F4AB55B47A23244E7A")
    protected void readStreamHeader() throws IOException,
            StreamCorruptedException {
        {
            boolean varC19679871E5EE3ACDCBC6AB5CDD35F45_1023584881 = (input.readShort() == STREAM_MAGIC
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.351 -0400", hash_original_method = "50996F70792020DA658FB7FFCF1EF910", hash_generated_method = "92376468D586499B32BF85DF3E3B545A")
    public int readUnsignedByte() throws IOException {
        int varB7F3DDCB7C33CADCD69A9EA77340018F_776668454 = (primitiveTypes.readUnsignedByte());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_434551666 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_434551666;
        // ---------- Original Method ----------
        //return primitiveTypes.readUnsignedByte();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.352 -0400", hash_original_method = "ABA376385639B6CB8F725C68F1CED979", hash_generated_method = "F24D42903A797EF4E804F77E871FEA04")
    public int readUnsignedShort() throws IOException {
        int var8B6F0F8EF6EFAE22F469847E9560AC03_412873657 = (primitiveTypes.readUnsignedShort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_607690869 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_607690869;
        // ---------- Original Method ----------
        //return primitiveTypes.readUnsignedShort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.373 -0400", hash_original_method = "B2994D3A3B821949D517613320FA5065", hash_generated_method = "D405DD3D32E1A8DFF17DABA09A3CEE3E")
    public String readUTF() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_398536413 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_398536413 = primitiveTypes.readUTF();
        varB4EAC82CA7396A68D541C85D26508E83_398536413.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_398536413;
        // ---------- Original Method ----------
        //return primitiveTypes.readUTF();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.374 -0400", hash_original_method = "10F65D1907C5AA72A1571FB08139A1C8", hash_generated_method = "7FDFD61A88A61D7F85F7B644D55AD563")
    private Object registeredObjectRead(int handle) throws InvalidObjectException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1671497324 = null; //Variable for return #1
        Object res;
        res = objectsRead.get(handle - ObjectStreamConstants.baseWireHandle);
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidObjectException("Cannot read back reference to unshared object");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1671497324 = res;
        addTaint(handle);
        varB4EAC82CA7396A68D541C85D26508E83_1671497324.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1671497324;
        // ---------- Original Method ----------
        //Object res = objectsRead.get(handle - ObjectStreamConstants.baseWireHandle);
        //if (res == UNSHARED_OBJ) {
            //throw new InvalidObjectException("Cannot read back reference to unshared object");
        //}
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.375 -0400", hash_original_method = "9C8641A932863D3A6F3FA22233749F54", hash_generated_method = "290580F9E922A06225EA15A060DC4AE2")
    private void registerObjectRead(Object obj, int handle, boolean unshared) throws IOException {
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
        addTaint(obj.getTaint());
        addTaint(handle);
        addTaint(unshared);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.377 -0400", hash_original_method = "3EFB39BBE791BF6ED902F9D8BC5F60E3", hash_generated_method = "E33B067524C0BE77D739AFA8701AB405")
    public synchronized void registerValidation(ObjectInputValidation object,
            int priority) throws NotActiveException, InvalidObjectException {
        //DSFIXME: CODE0010: Possible callback registration function detected
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
        addTaint(object.getTaint());
        addTaint(priority);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.377 -0400", hash_original_method = "7A01BA94C22B82138AACA44C7BC92DD9", hash_generated_method = "0C73C6216D604266ED6256169E691209")
    private void resetSeenObjects() {
        objectsRead = new ArrayList<Object>();
        nextHandle = baseWireHandle;
        primitiveData = emptyStream;
        // ---------- Original Method ----------
        //objectsRead = new ArrayList<Object>();
        //nextHandle = baseWireHandle;
        //primitiveData = emptyStream;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.394 -0400", hash_original_method = "356E50ACB0709EF4643021948AB5F291", hash_generated_method = "EC3D0E77128D57B1D4D0ED283DC54BAE")
    private void resetState() {
        resetSeenObjects();
        hasPushbackTC = false;
        pushbackTC = 0;
        // ---------- Original Method ----------
        //resetSeenObjects();
        //hasPushbackTC = false;
        //pushbackTC = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.395 -0400", hash_original_method = "38B51F7C504D6211D87B81513F39C956", hash_generated_method = "D167465385007201F20C3855832E3668")
    protected Class<?> resolveClass(ObjectStreamClass osClass) throws IOException, ClassNotFoundException {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_223927070 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_223927070 = cls;
        addTaint(osClass.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_223927070.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_223927070;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.395 -0400", hash_original_method = "8BE1D9D2C1A8227AC3DEAA12C63F6442", hash_generated_method = "7FD4F63E7CA433B84FFDB15AA838AC74")
    protected Object resolveObject(Object object) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_582028395 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_582028395 = object;
        addTaint(object.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_582028395.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_582028395;
        // ---------- Original Method ----------
        //return object;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.396 -0400", hash_original_method = "C18A3B861F9E4DC00DB6D8F86113E96E", hash_generated_method = "8BC7FF8C5E8296457F26A1DBF63CE713")
    public int skipBytes(int length) throws IOException {
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
        addTaint(length);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1284774495 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1284774495;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.397 -0400", hash_original_method = "F18AA842F3AF8655FE4F963E8A31A757", hash_generated_method = "6DCACE9DC5E42ED74806EF0A45546DB8")
    private void verifyAndInit(ObjectStreamClass loadedStreamClass) throws InvalidClassException {
        Class<?> localClass;
        localClass = loadedStreamClass.forClass();
        ObjectStreamClass localStreamClass;
        localStreamClass = ObjectStreamClass
                .lookupStreamClass(localClass);
        {
            boolean var9693CD9966488232124376137EBA8914_761016146 = (loadedStreamClass.getSerialVersionUID() != localStreamClass
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
            boolean varB90E1FD3EA27827ECD4177A803C71953_1126994308 = (!loadedClassBaseName.equals(localClassBaseName));
            {
                if (DroidSafeAndroidRuntime.control) throw new InvalidClassException(loadedStreamClass.getName(),
                    String.format("Incompatible class (base name): %s but expected %s",
                            loadedClassBaseName, localClassBaseName));
            } //End block
        } //End collapsed parenthetic
        loadedStreamClass.initPrivateFields(localStreamClass);
        addTaint(loadedStreamClass.getTaint());
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.397 -0400", hash_original_field = "8D6C391E7CB39133C91B73281A24F21F", hash_generated_field = "59BAC1D70D65173C0176BF76148E5AB7")

        ObjectInputValidation validator;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.397 -0400", hash_original_field = "B988295C268025B49DFB3DF26171DDC3", hash_generated_field = "4AD9F2E37B35E313CD211FBAFDADA238")

        int priority;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.397 -0400", hash_original_method = "9B1F2C1B15D11C4CFF789483FB2B6658", hash_generated_method = "9B1F2C1B15D11C4CFF789483FB2B6658")
        public InputValidationDesc ()
        {
            //Synthesized constructor
        }


    }


    
    public abstract static class GetField {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.398 -0400", hash_original_method = "3E66EA4913058A142DD3D4DCDDDF2758", hash_generated_method = "3E66EA4913058A142DD3D4DCDDDF2758")
        public GetField ()
        {
            //Synthesized constructor
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.413 -0400", hash_original_field = "84E5CE7FC519663BA115DBD4D0C5A535", hash_generated_field = "965C59A7219088EE499F4E5D3258011B")

    private static Object UNSHARED_OBJ = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.413 -0400", hash_original_field = "42768E4035EB7085BBD39A4E45389BDC", hash_generated_field = "D9467926DA728A93C6B38773BA30EEEB")

    private static HashMap<String, Class<?>> PRIMITIVE_CLASSES = new HashMap<String, Class<?>>();
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.413 -0400", hash_original_field = "E29C7DCEE0BF15C29DD3EA56FC9F2AF1", hash_generated_field = "38B5EC938B379EFE160A6D2F66E8B977")

    private static ClassLoader bootstrapLoader = Object.class.getClassLoader();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:39.413 -0400", hash_original_field = "89EBE3ECF326D242BB3DB8E1D4A3021B", hash_generated_field = "A000409979401631E46A2233AD5CBEAC")

    private static ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
}

