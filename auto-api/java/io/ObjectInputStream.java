package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.230 -0400", hash_original_field = "559F34BD1B83DCCF42BD97118C30004D", hash_generated_field = "9C428AEC470C7B513A34BE33B758C61C")

    private InputStream emptyStream = new ByteArrayInputStream(EmptyArray.BYTE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.230 -0400", hash_original_field = "5A8A6215AD70C3096643367A265101CD", hash_generated_field = "C282E9AAC2D48EC47E345831218585FA")

    private boolean hasPushbackTC;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.230 -0400", hash_original_field = "E07029C787F995347976B5426FA51D79", hash_generated_field = "64B94603DBAD0B26BD5AE2F7439ED35E")

    private byte pushbackTC;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.230 -0400", hash_original_field = "993B80B15181215612E5959DB832BFAF", hash_generated_field = "123C8BF62BBC79B951F58B358976C3FF")

    private int nestedLevels;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.230 -0400", hash_original_field = "CB52CB1EDBEC59BDE75BA590938374FC", hash_generated_field = "FBF49E90A1B9879AE660F9886E842C8C")

    private int nextHandle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.230 -0400", hash_original_field = "A43C1B0AA53A0C908810C06AB1FF3967", hash_generated_field = "32FD79F94203B3CB4FB10D6979B3AE55")

    private DataInputStream input;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.230 -0400", hash_original_field = "8AFA05430C7155E00832EE4E25A1E3C4", hash_generated_field = "76093EED1B475C4F1E4C622B52BC7AC9")

    private DataInputStream primitiveTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.230 -0400", hash_original_field = "6AA631A1CF88716882035C982A3A5C5A", hash_generated_field = "28C1B2E39A3350A755888FD0A4428279")

    private InputStream primitiveData = emptyStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.230 -0400", hash_original_field = "814324F3D01F90BE0344B032BCDAEB46", hash_generated_field = "3240649A9311294AE1E098CB8F2A005F")

    private boolean enableResolve;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.230 -0400", hash_original_field = "324CFF805C6D6B99EE7C6FE654D64D06", hash_generated_field = "F79B8A3B52A523F03D688BC47873D2F6")

    private ArrayList<Object> objectsRead;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.230 -0400", hash_original_field = "895D2E18F5D2EA8F00F48DF2FB178E4D", hash_generated_field = "76736C274255A46E2AEB2CE593A1B428")

    private Object currentObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.230 -0400", hash_original_field = "457C5912366BE090D6A2931DE14CDA9E", hash_generated_field = "7035F4B44BC3AE389D42445F7A5655AC")

    private ObjectStreamClass currentClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.230 -0400", hash_original_field = "A81AAA0781C265056D03A0138CF839B3", hash_generated_field = "4E53F0CFC72A51A3B3CAAC6447A9F3B4")

    private InputValidationDesc[] validations;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.230 -0400", hash_original_field = "35C5D5BAEC9DA39A210149CA5A667705", hash_generated_field = "3690401F10D38FF2C8AB1C19B641B107")

    private boolean subclassOverridingImplementation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.230 -0400", hash_original_field = "0630628FEFA32E6BCF95C8130059DD84", hash_generated_field = "7E360A145DF451DC0144E812BE96A034")

    private ClassLoader callerClassLoader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.230 -0400", hash_original_field = "AFDD2451F1D1759C785DD591BC1506D8", hash_generated_field = "2DA36CFD381BE4CC041D9D9E401B490D")

    private boolean mustResolve = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.230 -0400", hash_original_field = "3A717ED2456CACB3BC0F8AE8881EF3AA", hash_generated_field = "2B0CB3B967646FBC95A533438216C0DF")

    private int descriptorHandle = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.230 -0400", hash_original_field = "C1487B64EE4D02CA5ED52EFDAA9A2E96", hash_generated_field = "FAF1B21A627FAB868C99C514185244A6")

    private HashMap<Class<?>, List<Class<?>>> cachedSuperclasses = new HashMap<Class<?>, List<Class<?>>>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.231 -0400", hash_original_method = "124623F0922D5D71F912D224AEC5FA85", hash_generated_method = "ACAF350C98F97636B8BC13996275E1E2")
    protected  ObjectInputStream() throws IOException {
        this.subclassOverridingImplementation = true;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.231 -0400", hash_original_method = "15BB4AD74FE576D95ABFC0E40CC8A986", hash_generated_method = "703A8C3897973881276857A3F1438BAC")
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
        
        
                
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.231 -0400", hash_original_method = "CEC952E1AEB3FC5761C4573EC7C87AAE", hash_generated_method = "A06953A21C090AF040EEECDAD728CD02")
    @Override
    public int available() throws IOException {
        checkReadPrimitiveTypes();
        int var396FA1B30BCA352A1497967EC8829CF5_2121698629 = (primitiveData.available());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_191735034 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_191735034;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.232 -0400", hash_original_method = "5DD662298FB99DC11E3F5A1BB4812CC0", hash_generated_method = "04C23ACD5F7395C1C247A500414B0FF4")
    private void checkReadPrimitiveTypes() throws IOException {
        {
            boolean var429099FA06AFA9946D3FE9CA9E9D4FD2_2067233005 = (primitiveData == input || primitiveData.available() > 0);
        } 
        {
            int next = 0;
            {
                hasPushbackTC = false;
            } 
            {
                next = input.read();
                pushbackTC = (byte) next;
            } 
            
            primitiveData = new ByteArrayInputStream(readBlockData());
            
            
            primitiveData = new ByteArrayInputStream(readBlockDataLong());
            
            
            resetState();
            
            
            {
                pushbackTC();
            } 
            
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.232 -0400", hash_original_method = "4ECD43BBA7F31E748521530C375A35B5", hash_generated_method = "EBCAB811F86091C4F8C851B059031D05")
    @Override
    public void close() throws IOException {
        input.close();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.233 -0400", hash_original_method = "6463B95302326251A8E319007FB9B6A5", hash_generated_method = "0BE8757C249A1BCDB14AE00D20DDA08A")
    public void defaultReadObject() throws IOException, ClassNotFoundException,
            NotActiveException {
        {
            readFieldValues(currentObject, currentClass);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new NotActiveException();
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.233 -0400", hash_original_method = "970A975ADDA1CD42A4A6880D40629922", hash_generated_method = "F7A5039DDB0B3B8D6D35A849A3E393A2")
    protected boolean enableResolveObject(boolean enable) {
        boolean originalValue = enableResolve;
        enableResolve = enable;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2011314347 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2011314347;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.234 -0400", hash_original_method = "BEEE4D4B01DB5401D5A386ECF8653C53", hash_generated_method = "A44287D3FB9D1A0DB960AFCD45B85E1C")
    private int nextHandle() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_163298897 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_163298897;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.234 -0400", hash_original_method = "EA84EB3C5ACC30FA1515ABE6938E6E9B", hash_generated_method = "5069112A79F78EAB6B8FB8B8F1266C7D")
    private byte nextTC() throws IOException {
        {
            hasPushbackTC = false;
        } 
        {
            pushbackTC = input.readByte();
        } 
        byte var40EA57D3EE3C07BF1C102B466E1C3091_542203773 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_542203773;
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.234 -0400", hash_original_method = "056AB6ECFECE1087CD6299233C3046CF", hash_generated_method = "1AA917BD8C0785A0A281D56B178CD348")
    private void pushbackTC() {
        hasPushbackTC = true;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.235 -0400", hash_original_method = "87E37984C9E76D351365EC77DA0248F5", hash_generated_method = "8A8B34B757956F39C6B789EAF64FE1F0")
    @Override
    public int read() throws IOException {
        checkReadPrimitiveTypes();
        int varB707721DB93E7A7A4590241126489184_637387797 = (primitiveData.read());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1115116581 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1115116581;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.235 -0400", hash_original_method = "7E3B2630C90BBA61B0E7CD83B04481D2", hash_generated_method = "7E760F9979C1E31C37E5FB411083F10B")
    @Override
    public int read(byte[] buffer, int offset, int length) throws IOException {
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
        checkReadPrimitiveTypes();
        int var8656D85F3F24DB8757358C0140B597A3_2057318223 = (primitiveData.read(buffer, offset, length));
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(length);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_8352778 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_8352778;
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.236 -0400", hash_original_method = "35383BB5231F8136A4FECB09DEC2FE93", hash_generated_method = "207E66CE859F5D04D0AA500DA6889AC7")
    private byte[] readBlockData() throws IOException {
        byte[] result = new byte[input.readByte() & 0xff];
        input.readFully(result);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1899775596 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1899775596;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.236 -0400", hash_original_method = "478D7B43D09CD1BAF3CA95670FAE291A", hash_generated_method = "4DEA759B09A1F13AAD15C9EB72F9B7A7")
    private byte[] readBlockDataLong() throws IOException {
        byte[] result = new byte[input.readInt()];
        input.readFully(result);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1416018147 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1416018147;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.237 -0400", hash_original_method = "43182B65F59B21B8425D068A4900EB3A", hash_generated_method = "BA2715DB0219FDDADA924169128D5F40")
    public boolean readBoolean() throws IOException {
        boolean varDCB0861A4BE9F65D653AD47B971965CF_1860026665 = (primitiveTypes.readBoolean());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1407789895 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1407789895;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.237 -0400", hash_original_method = "F1C938A529B536DE0EA7C0848AC19388", hash_generated_method = "1397770F6FCD3B1C5DB7D24A4E82CA29")
    public byte readByte() throws IOException {
        byte varD0FBD5DD4443B7C0CAB658ACAA09D8C9_36950671 = (primitiveTypes.readByte());
        byte var40EA57D3EE3C07BF1C102B466E1C3091_1542519411 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1542519411;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.238 -0400", hash_original_method = "08C7569945A67E2D251F3B449209E666", hash_generated_method = "5C499827A380CB67FC81EB4319466523")
    public char readChar() throws IOException {
        char var4C12272AC58BE571107F61420B43FEF4_1029802765 = (primitiveTypes.readChar());
        char varA87DEB01C5F539E6BDA34829C8EF2368_2109912812 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_2109912812;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.239 -0400", hash_original_method = "7E3D613702E21574BA96B289FBA102EA", hash_generated_method = "37154474E6166390D51FF614C27171AE")
    private void discardData() throws ClassNotFoundException, IOException {
        primitiveData = emptyStream;
        boolean resolve = mustResolve;
        mustResolve = false;
        {
            byte tc = nextTC();
            {
                mustResolve = resolve;
            } 
            readContent(tc);
        } 
        
        
        
        
        
            
            
                
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.240 -0400", hash_original_method = "8425AE4559FEB283CFFC129B3DDD377F", hash_generated_method = "AB5164EC713826D799848FF34E392175")
    private ObjectStreamClass readClassDesc() throws ClassNotFoundException, IOException {
        ObjectStreamClass varB4EAC82CA7396A68D541C85D26508E83_111824801 = null; 
        ObjectStreamClass varB4EAC82CA7396A68D541C85D26508E83_1322991662 = null; 
        ObjectStreamClass varB4EAC82CA7396A68D541C85D26508E83_1377562798 = null; 
        ObjectStreamClass varB4EAC82CA7396A68D541C85D26508E83_799651984 = null; 
        byte tc = nextTC();
        
        varB4EAC82CA7396A68D541C85D26508E83_111824801 = readNewClassDesc(false);
        
        
        Class<?> proxyClass = readNewProxyClassDesc();
        
        
        ObjectStreamClass streamClass = ObjectStreamClass.lookup(proxyClass);
        
        
        streamClass.setLoadFields(ObjectStreamClass.NO_FIELDS);
        
        
        registerObjectRead(streamClass, nextHandle(), false);
        
        
        checkedSetSuperClassDesc(streamClass, readClassDesc());
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1322991662 = streamClass;
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1377562798 = (ObjectStreamClass) readCyclicReference();
        
        
        varB4EAC82CA7396A68D541C85D26508E83_799651984 = null;
        
        
        if (DroidSafeAndroidRuntime.control) throw corruptStream(tc);
        
        ObjectStreamClass varA7E53CE21691AB073D9660D615818899_1854218654; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1854218654 = varB4EAC82CA7396A68D541C85D26508E83_111824801;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1854218654 = varB4EAC82CA7396A68D541C85D26508E83_1322991662;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1854218654 = varB4EAC82CA7396A68D541C85D26508E83_1377562798;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1854218654 = varB4EAC82CA7396A68D541C85D26508E83_799651984;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1854218654.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1854218654;
        
        
        
            
                
            
                
                
                
                
                
                
            
                
            
                
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.241 -0400", hash_original_method = "D1B003D7ABBBCEF0B15D64544C91AEEF", hash_generated_method = "BCE352FED1EFC0F54DEBCF205CFACE1A")
    private StreamCorruptedException corruptStream(byte tc) throws StreamCorruptedException {
    	addTaint(tc);
    	throw new StreamCorruptedException("Wrong format: " + Integer.toHexString(tc & 0xff));
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.243 -0400", hash_original_method = "EBF146E3B3C2508DCA0D721582A75609", hash_generated_method = "3B4D94A8DDA2EFD483540ACDAE29C239")
    private Object readContent(byte tc) throws ClassNotFoundException,
            IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1098115951 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1058677819 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_2055089698 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1934410508 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1741190322 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_2106522797 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1746466312 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_568162401 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1705188500 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1648342379 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_2113339412 = null; 
        
        varB4EAC82CA7396A68D541C85D26508E83_1098115951 = readBlockData();
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1058677819 = readBlockDataLong();
        
        
        varB4EAC82CA7396A68D541C85D26508E83_2055089698 = readNewClass(false);
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1934410508 = readNewClassDesc(false);
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1741190322 = readNewArray(false);
        
        
        varB4EAC82CA7396A68D541C85D26508E83_2106522797 = readNewObject(false);
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1746466312 = readNewString(false);
        
        
        varB4EAC82CA7396A68D541C85D26508E83_568162401 = readNewLongString(false);
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1705188500 = readCyclicReference();
        
        
        varB4EAC82CA7396A68D541C85D26508E83_1648342379 = null;
        
        
        Exception exc = readException();
        
        
        if (DroidSafeAndroidRuntime.control) throw new WriteAbortedException("Read an exception", exc);
        
        
        resetState();
        
        
        varB4EAC82CA7396A68D541C85D26508E83_2113339412 = null;
        
        
        if (DroidSafeAndroidRuntime.control) throw corruptStream(tc);
        
        addTaint(tc);
        Object varA7E53CE21691AB073D9660D615818899_831329844; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_831329844 = varB4EAC82CA7396A68D541C85D26508E83_1098115951;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_831329844 = varB4EAC82CA7396A68D541C85D26508E83_1058677819;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_831329844 = varB4EAC82CA7396A68D541C85D26508E83_2055089698;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_831329844 = varB4EAC82CA7396A68D541C85D26508E83_1934410508;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_831329844 = varB4EAC82CA7396A68D541C85D26508E83_1741190322;
                break;
            case 6: 
                varA7E53CE21691AB073D9660D615818899_831329844 = varB4EAC82CA7396A68D541C85D26508E83_2106522797;
                break;
            case 7: 
                varA7E53CE21691AB073D9660D615818899_831329844 = varB4EAC82CA7396A68D541C85D26508E83_1746466312;
                break;
            case 8: 
                varA7E53CE21691AB073D9660D615818899_831329844 = varB4EAC82CA7396A68D541C85D26508E83_568162401;
                break;
            case 9: 
                varA7E53CE21691AB073D9660D615818899_831329844 = varB4EAC82CA7396A68D541C85D26508E83_1705188500;
                break;
            case 10: 
                varA7E53CE21691AB073D9660D615818899_831329844 = varB4EAC82CA7396A68D541C85D26508E83_1648342379;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_831329844 = varB4EAC82CA7396A68D541C85D26508E83_2113339412;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_831329844.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_831329844;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.244 -0400", hash_original_method = "C964F7473D297E2F3A28B1C55493EBEA", hash_generated_method = "DEF54E625F133486494CB40ABD870943")
    private Object readNonPrimitiveContent(boolean unshared) throws ClassNotFoundException, IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1421307380 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_2102740057 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_964088171 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_20229062 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_644330335 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1163014872 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1626713104 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_859166331 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_102892479 = null; 
        checkReadPrimitiveTypes();
        {
            boolean varFE023E46CC4F9239294D15D3ADCB19E2_1044550104 = (primitiveData.available() > 0);
            {
                OptionalDataException e = new OptionalDataException();
                e.length = primitiveData.available();
                if (DroidSafeAndroidRuntime.control) throw e;
            } 
        } 
        {
            byte tc = nextTC();
            
            varB4EAC82CA7396A68D541C85D26508E83_1421307380 = readNewClass(unshared);
            
            
            varB4EAC82CA7396A68D541C85D26508E83_2102740057 = readNewClassDesc(unshared);
            
            
            varB4EAC82CA7396A68D541C85D26508E83_964088171 = readNewArray(unshared);
            
            
            varB4EAC82CA7396A68D541C85D26508E83_20229062 = readNewObject(unshared);
            
            
            varB4EAC82CA7396A68D541C85D26508E83_644330335 = readNewString(unshared);
            
            
            varB4EAC82CA7396A68D541C85D26508E83_1163014872 = readNewLongString(unshared);
            
            
            varB4EAC82CA7396A68D541C85D26508E83_1626713104 = readEnum(unshared);
            
            
            {
                readNewHandle();
                if (DroidSafeAndroidRuntime.control) throw new InvalidObjectException("Unshared read of back reference");
            } 
            
            
            varB4EAC82CA7396A68D541C85D26508E83_859166331 = readCyclicReference();
            
            
            varB4EAC82CA7396A68D541C85D26508E83_102892479 = null;
            
            
            Exception exc = readException();
            
            
            if (DroidSafeAndroidRuntime.control) throw new WriteAbortedException("Read an exception", exc);
            
            
            resetState();
            
            
            pushbackTC();
            
            
            OptionalDataException e = new OptionalDataException();
            
            
            e.eof = true;
            
            
            if (DroidSafeAndroidRuntime.control) throw e;
            
            
            if (DroidSafeAndroidRuntime.control) throw corruptStream(tc);
            
        } 
        addTaint(unshared);
        Object varA7E53CE21691AB073D9660D615818899_901490545; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_901490545 = varB4EAC82CA7396A68D541C85D26508E83_1421307380;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_901490545 = varB4EAC82CA7396A68D541C85D26508E83_2102740057;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_901490545 = varB4EAC82CA7396A68D541C85D26508E83_964088171;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_901490545 = varB4EAC82CA7396A68D541C85D26508E83_20229062;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_901490545 = varB4EAC82CA7396A68D541C85D26508E83_644330335;
                break;
            case 6: 
                varA7E53CE21691AB073D9660D615818899_901490545 = varB4EAC82CA7396A68D541C85D26508E83_1163014872;
                break;
            case 7: 
                varA7E53CE21691AB073D9660D615818899_901490545 = varB4EAC82CA7396A68D541C85D26508E83_1626713104;
                break;
            case 8: 
                varA7E53CE21691AB073D9660D615818899_901490545 = varB4EAC82CA7396A68D541C85D26508E83_859166331;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_901490545 = varB4EAC82CA7396A68D541C85D26508E83_102892479;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_901490545.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_901490545;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.245 -0400", hash_original_method = "821B45232EA8F88246A504603C8240EF", hash_generated_method = "609F2B57C73D3BC29519851717037C50")
    private Object readCyclicReference() throws InvalidObjectException, IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_2123405652 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2123405652 = registeredObjectRead(readNewHandle());
        varB4EAC82CA7396A68D541C85D26508E83_2123405652.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2123405652;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.246 -0400", hash_original_method = "7C91F28BD77A4ED641420E614D9FCB15", hash_generated_method = "565273F7278F0D4EA78FD300C8514052")
    public double readDouble() throws IOException {
        double var42D1EAD188298802018D182CA96F7EC6_1347837359 = (primitiveTypes.readDouble());
        double varE8CD7DA078A86726031AD64F35F5A6C0_880220730 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_880220730;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.246 -0400", hash_original_method = "BA11A34B6A0BFC2FA522B0508C6E225C", hash_generated_method = "6CD4A3CF1AF6F48CF68EB36F5C773BB7")
    private Exception readException() throws WriteAbortedException,
            OptionalDataException, ClassNotFoundException, IOException {
        Exception varB4EAC82CA7396A68D541C85D26508E83_894612456 = null; 
        resetSeenObjects();
        Exception exc = (Exception) readObject();
        resetSeenObjects();
        varB4EAC82CA7396A68D541C85D26508E83_894612456 = exc;
        varB4EAC82CA7396A68D541C85D26508E83_894612456.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_894612456;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.248 -0400", hash_original_method = "FA3DFED5FC7EE2104F3E818CA56DCFE9", hash_generated_method = "73B89CEE95FEC04E7B2A4A9B7BF88FB7")
    private void readFieldDescriptors(ObjectStreamClass cDesc) throws ClassNotFoundException, IOException {
        short numFields = input.readShort();
        ObjectStreamField[] fields = new ObjectStreamField[numFields];
        cDesc.setLoadFields(fields);
        {
            short i = 0;
            {
                char typecode = (char) input.readByte();
                String fieldName = input.readUTF();
                boolean isPrimType = ObjectStreamClass.isPrimitiveType(typecode);
                String classSig;
                {
                    classSig = String.valueOf(typecode);
                } 
                {
                    boolean old = enableResolve;
                    try 
                    {
                        enableResolve = false;
                        classSig = (String) readObject();
                    } 
                    finally 
                    {
                        enableResolve = old;
                    } 
                } 
                classSig = formatClassSig(classSig);
                ObjectStreamField f = new ObjectStreamField(classSig, fieldName);
                fields[i] = f;
            } 
        } 
        addTaint(cDesc.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.250 -0400", hash_original_method = "35D23573908F6AA48B37BF1647A74D3F", hash_generated_method = "C687740B12633EBC71FB7478C7F451B0")
    public GetField readFields() throws IOException, ClassNotFoundException, NotActiveException {
        GetField varB4EAC82CA7396A68D541C85D26508E83_478496982 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new NotActiveException();
        } 
        EmulatedFieldsForLoading result = new EmulatedFieldsForLoading(currentClass);
        readFieldValues(result);
        varB4EAC82CA7396A68D541C85D26508E83_478496982 = result;
        varB4EAC82CA7396A68D541C85D26508E83_478496982.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_478496982;
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.258 -0400", hash_original_method = "8289C081F35F5F257A7DE20983B5F39B", hash_generated_method = "440CE6D34FDD7B0A82F7E38543894944")
    private void readFieldValues(EmulatedFieldsForLoading emulatedFields) throws OptionalDataException, InvalidClassException, IOException {
        EmulatedFields.ObjectSlot[] slots = emulatedFields.emulatedFields().slots();
        {
            ObjectSlot element = slots[0];
            {
                element.defaulted = false;
                Class<?> type = element.field.getType();
                {
                    element.fieldValue = input.readInt();
                } 
                {
                    element.fieldValue = input.readByte();
                } 
                {
                    element.fieldValue = input.readChar();
                } 
                {
                    element.fieldValue = input.readShort();
                } 
                {
                    element.fieldValue = input.readBoolean();
                } 
                {
                    element.fieldValue = input.readLong();
                } 
                {
                    element.fieldValue = input.readFloat();
                } 
                {
                    element.fieldValue = input.readDouble();
                } 
                {
                    try 
                    {
                        element.fieldValue = readObject();
                    } 
                    catch (ClassNotFoundException cnf)
                    {
                        if (DroidSafeAndroidRuntime.control) throw new InvalidClassException(cnf.toString());
                    } 
                } 
            } 
        } 
        addTaint(emulatedFields.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.286 -0400", hash_original_method = "3FF4AC35875B69602347D8B467CAEB0A", hash_generated_method = "44DE556CD17176B31440B189BFD44E74")
    private void readFieldValues(Object obj, ObjectStreamClass classDesc) throws OptionalDataException, ClassNotFoundException, IOException {
        ObjectStreamField[] fields = classDesc.getLoadFields();
        fields = (fields == null) ? ObjectStreamClass.NO_FIELDS : fields;
        Class<?> declaringClass = classDesc.forClass();
        {
            if (DroidSafeAndroidRuntime.control) throw new ClassNotFoundException(classDesc.getName());
        } 
        {
            ObjectStreamField fieldDesc = fields[0];
            {
                Field field = classDesc.getReflectionField(fieldDesc);
                try 
                {
                    Class<?> type = fieldDesc.getTypeInternal();
                    {
                        byte b = input.readByte();
                        {
                            field.setByte(obj, b);
                        } 
                    } 
                    {
                        char c = input.readChar();
                        {
                            field.setChar(obj, c);
                        } 
                    } 
                    {
                        double d = input.readDouble();
                        {
                            field.setDouble(obj, d);
                        } 
                    } 
                    {
                        float f = input.readFloat();
                        {
                            field.setFloat(obj, f);
                        } 
                    } 
                    {
                        int i = input.readInt();
                        {
                            field.setInt(obj, i);
                        } 
                    } 
                    {
                        long j = input.readLong();
                        {
                            field.setLong(obj, j);
                        } 
                    } 
                    {
                        short s = input.readShort();
                        {
                            field.setShort(obj, s);
                        } 
                    } 
                    {
                        boolean z = input.readBoolean();
                        {
                            field.setBoolean(obj, z);
                        } 
                    } 
                    {
                        Object toSet;
                        boolean varC187ADE01525F471F8592C2BAF193B77_1424467973 = (fieldDesc.isUnshared());
                        toSet = readUnshared();
                        toSet = readObject();
                        {
                            String fieldName = fieldDesc.getName();
                            ObjectStreamField localFieldDesc = classDesc.getField(fieldName);
                            Class<?> fieldType = localFieldDesc.getTypeInternal();
                            Class<?> valueType = toSet.getClass();
                            {
                                boolean var74C1BEDB7218CB2DF56B6BCB99B9FB95_1436119978 = (!fieldType.isAssignableFrom(valueType));
                                {
                                    if (DroidSafeAndroidRuntime.control) throw new ClassCastException(classDesc.getName() + "." + fieldName + " - " + fieldType + " not compatible with " + valueType);
                                } 
                            } 
                            {
                                field.set(obj, toSet);
                            } 
                        } 
                    } 
                } 
                catch (IllegalAccessException iae)
                {
                    if (DroidSafeAndroidRuntime.control) throw new AssertionError(iae);
                } 
                catch (NoSuchFieldError ignored)
                { }
            } 
        } 
        addTaint(obj.getTaint());
        addTaint(classDesc.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.286 -0400", hash_original_method = "E7BFAC98C28E1C1B49BD33FC0E76EA53", hash_generated_method = "CEACEB946C62D17178B6B7067B5BF735")
    public float readFloat() throws IOException {
        float var7E9E584C6FD2DEB4403B27097B587FBB_928524830 = (primitiveTypes.readFloat());
        float var546ADE640B6EDFBC8A086EF31347E768_2049864340 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2049864340;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.287 -0400", hash_original_method = "917418BB5C848A4690F4E96972002BAD", hash_generated_method = "A23903FF79BB25ED2104D29A0BF5C32E")
    public void readFully(byte[] dst) throws IOException {
        primitiveTypes.readFully(dst);
        addTaint(dst[0]);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.287 -0400", hash_original_method = "046EB506BDA13B9ED79306898615169A", hash_generated_method = "B62F6DDC8F06C9680A410C604CF03422")
    public void readFully(byte[] dst, int offset, int byteCount) throws IOException {
        primitiveTypes.readFully(dst, offset, byteCount);
        addTaint(dst[0]);
        addTaint(offset);
        addTaint(byteCount);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.298 -0400", hash_original_method = "D8B45244A94A62B53D8A8E2E7C864422", hash_generated_method = "A74C4FB47560993CE4CBBC12C722BDD2")
    private void readHierarchy(Object object, ObjectStreamClass classDesc) throws IOException, ClassNotFoundException, NotActiveException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NotActiveException();
        } 
        List<ObjectStreamClass> streamClassList = classDesc.getHierarchy();
        {
            {
                Iterator<ObjectStreamClass> var053A1EC5A2A31FD005C51939A1546787_1439463952 = (streamClassList).iterator();
                var053A1EC5A2A31FD005C51939A1546787_1439463952.hasNext();
                ObjectStreamClass objectStreamClass = var053A1EC5A2A31FD005C51939A1546787_1439463952.next();
                {
                    readObjectForClass(null, objectStreamClass);
                } 
            } 
        } 
        {
            List<Class<?>> superclasses = cachedSuperclasses.get(object.getClass());
            {
                superclasses = cacheSuperclassesFor(object.getClass());
            } 
            int lastIndex = 0;
            {
                int i = 0;
                int end = superclasses.size();
                {
                    Class<?> superclass = superclasses.get(i);
                    int index = findStreamSuperclass(superclass, streamClassList, lastIndex);
                    {
                        readObjectNoData(object, superclass,
                            ObjectStreamClass.lookupStreamClass(superclass));
                    } 
                    {
                        {
                            int j = lastIndex;
                            {
                                readObjectForClass(object, streamClassList.get(j));
                            } 
                        } 
                        lastIndex = index + 1;
                    } 
                } 
            } 
        } 
        addTaint(object.getTaint());
        addTaint(classDesc.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.299 -0400", hash_original_method = "F09DF984FD463C1BCDA606260FD08FFE", hash_generated_method = "8965F032F1B4194DFCBBD871B0B3040F")
    private List<Class<?>> cacheSuperclassesFor(Class<?> c) {
        List<Class<?>> varB4EAC82CA7396A68D541C85D26508E83_198269421 = null; 
        ArrayList<Class<?>> result = new ArrayList<Class<?>>();
        Class<?> nextClass = c;
        {
            Class<?> testClass = nextClass.getSuperclass();
            {
                result.add(0, nextClass);
            } 
            nextClass = testClass;
        } 
        cachedSuperclasses.put(c, result);
        varB4EAC82CA7396A68D541C85D26508E83_198269421 = result;
        addTaint(c.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_198269421.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_198269421;
        
        
        
        
            
            
                
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.299 -0400", hash_original_method = "30EFDC31EF83C1843078545357CDA4A5", hash_generated_method = "A0DBA154561895CBAFEB2D5B121D30BE")
    private int findStreamSuperclass(Class<?> cl, List<ObjectStreamClass> classList, int lastIndex) {
        {
            int i = lastIndex;
            int end = classList.size();
            {
                ObjectStreamClass objCl = classList.get(i);
                String forName = objCl.forClass().getName();
                {
                    boolean var231414704491DDAEEB5B177CB6BDCCB3_108378276 = (objCl.getName().equals(forName));
                    {
                        {
                            boolean varB1DEEBE6B0B17CA7084086DE8FDC42C2_398110273 = (cl.getName().equals(objCl.getName()));
                        } 
                    } 
                    {
                        {
                            boolean var7039F19E84FDA9D92190D2C9D5A9C382_772484898 = (cl.getName().equals(forName));
                        } 
                    } 
                } 
            } 
        } 
        addTaint(cl.getTaint());
        addTaint(classList.getTaint());
        addTaint(lastIndex);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1299164829 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1299164829;
        
        
            
            
            
                
                    
                
            
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.299 -0400", hash_original_method = "868BCCA0967481794CFA1D8D3E56D3E6", hash_generated_method = "5A690800E6BDCDAB22676DD008AD0199")
    private void readObjectNoData(Object object, Class<?> cl, ObjectStreamClass classDesc) throws ObjectStreamException {
        {
            boolean varC6302AF1FA07AAAD1767E048D3B78E8B_517841553 = (!classDesc.isSerializable());
        } 
        {
            boolean var6FEFF8B6EB65DC0C85ADA74F8DE4B91F_1203174625 = (classDesc.hasMethodReadObjectNoData());
            {
                final Method readMethod = classDesc.getMethodReadObjectNoData();
                try 
                {
                    readMethod.invoke(object);
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
                    if (DroidSafeAndroidRuntime.control) throw (ObjectStreamException) ex;
                } 
                catch (IllegalAccessException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e.toString());
                } 
            } 
        } 
        addTaint(object.getTaint());
        addTaint(cl.getTaint());
        addTaint(classDesc.getTaint());
        
        
            
        
        
            
            
                
            
                
                
                    
                
                    
                
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.300 -0400", hash_original_method = "6119E962BBCC069017D862716C24BEC0", hash_generated_method = "207DEA8DB5BC27BFA8148FA0CDD94678")
    private void readObjectForClass(Object object, ObjectStreamClass classDesc) throws IOException, ClassNotFoundException, NotActiveException {
        currentObject = object;
        currentClass = classDesc;
        boolean hadWriteMethod = (classDesc.getFlags() & SC_WRITE_METHOD) != 0;
        Class<?> targetClass = classDesc.forClass();
        Method readMethod;
        {
            readMethod = null;
        } 
        {
            readMethod = classDesc.getMethodReadObject();
        } 
        try 
        {
            {
                readMethod.setAccessible(true);
                try 
                {
                    readMethod.invoke(object, this);
                } 
                catch (InvocationTargetException e)
                {
                    Throwable ex = e.getTargetException();
                    {
                        if (DroidSafeAndroidRuntime.control) throw (ClassNotFoundException) ex;
                    } 
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
            {
                defaultReadObject();
            } 
            {
                discardData();
            } 
        } 
        finally 
        {
            currentObject = null;
            currentClass = null;
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.301 -0400", hash_original_method = "D31E8D2825D4043295F3D0C685B93717", hash_generated_method = "7B591FD14F462A1477BFD45FBBF906B1")
    public int readInt() throws IOException {
        int varE840EF94E99C72456F8C1D024800AFEF_2055225375 = (primitiveTypes.readInt());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_751867230 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_751867230;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.301 -0400", hash_original_method = "90EA71A98921C4D093F2F0BA4DDBE95D", hash_generated_method = "C68BF19668FF6CABBEFDA9E37D2397B7")
    @Deprecated
    public String readLine() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_932616669 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_932616669 = primitiveTypes.readLine();
        varB4EAC82CA7396A68D541C85D26508E83_932616669.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_932616669;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.302 -0400", hash_original_method = "70C9FFE9F08A2EBCF32FC4C20D730AD7", hash_generated_method = "74DA25201EA593BB7740FC5E2C1F26C7")
    public long readLong() throws IOException {
        long var92AA3E55B0DEEBFF8ACE4E90B4B38BFC_1453608383 = (primitiveTypes.readLong());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_91193257 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_91193257;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.303 -0400", hash_original_method = "6C628531F4475FFAEEB816E877548000", hash_generated_method = "5BA69CD6A65F9A61B53BBA1FD3666A32")
    private Object readNewArray(boolean unshared) throws OptionalDataException,
            ClassNotFoundException, IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_244143249 = null; 
        ObjectStreamClass classDesc = readClassDesc();
        {
            if (DroidSafeAndroidRuntime.control) throw missingClassDescriptor();
        } 
        int newHandle = nextHandle();
        int size = input.readInt();
        Class<?> arrayClass = classDesc.forClass();
        Class<?> componentType = arrayClass.getComponentType();
        Object result = Array.newInstance(componentType, size);
        registerObjectRead(result, newHandle, unshared);
        {
            boolean varD34D6340EB041A4E3567A6A53D064A1F_697948790 = (componentType.isPrimitive());
            {
                {
                    int[] intArray = (int[]) result;
                    {
                        int i = 0;
                        {
                            intArray[i] = input.readInt();
                        } 
                    } 
                } 
                {
                    byte[] byteArray = (byte[]) result;
                    input.readFully(byteArray, 0, size);
                } 
                {
                    char[] charArray = (char[]) result;
                    {
                        int i = 0;
                        {
                            charArray[i] = input.readChar();
                        } 
                    } 
                } 
                {
                    short[] shortArray = (short[]) result;
                    {
                        int i = 0;
                        {
                            shortArray[i] = input.readShort();
                        } 
                    } 
                } 
                {
                    boolean[] booleanArray = (boolean[]) result;
                    {
                        int i = 0;
                        {
                            booleanArray[i] = input.readBoolean();
                        } 
                    } 
                } 
                {
                    long[] longArray = (long[]) result;
                    {
                        int i = 0;
                        {
                            longArray[i] = input.readLong();
                        } 
                    } 
                } 
                {
                    float[] floatArray = (float[]) result;
                    {
                        int i = 0;
                        {
                            floatArray[i] = input.readFloat();
                        } 
                    } 
                } 
                {
                    double[] doubleArray = (double[]) result;
                    {
                        int i = 0;
                        {
                            doubleArray[i] = input.readDouble();
                        } 
                    } 
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new ClassNotFoundException("Wrong base type in " + classDesc.getName());
                } 
            } 
            {
                Object[] objectArray = (Object[]) result;
                {
                    int i = 0;
                    {
                        objectArray[i] = readObject();
                    } 
                } 
            } 
        } 
        {
            result = resolveObject(result);
            registerObjectRead(result, newHandle, false);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_244143249 = result;
        addTaint(unshared);
        varB4EAC82CA7396A68D541C85D26508E83_244143249.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_244143249;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.304 -0400", hash_original_method = "5D3FFF38041945ED84D75A0CC474793D", hash_generated_method = "68DF93C43B1153B8F2F7A7B3FAAC55C8")
    private Class<?> readNewClass(boolean unshared) throws ClassNotFoundException, IOException {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_2055360676 = null; 
        ObjectStreamClass classDesc = readClassDesc();
        {
            if (DroidSafeAndroidRuntime.control) throw missingClassDescriptor();
        } 
        Class<?> localClass = classDesc.forClass();
        {
            registerObjectRead(localClass, nextHandle(), unshared);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2055360676 = localClass;
        addTaint(unshared);
        varB4EAC82CA7396A68D541C85D26508E83_2055360676.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2055360676;
        
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.305 -0400", hash_original_method = "D16FAEE9BB99888884BA2510B9D0161D", hash_generated_method = "BE14029D60B15C82D2529BC94E8F1A4D")
    private ObjectStreamClass readEnumDesc() throws IOException,
            ClassNotFoundException {
        ObjectStreamClass varB4EAC82CA7396A68D541C85D26508E83_217979111 = null; 
        ObjectStreamClass varB4EAC82CA7396A68D541C85D26508E83_678832126 = null; 
        ObjectStreamClass varB4EAC82CA7396A68D541C85D26508E83_84249917 = null; 
        byte tc = nextTC();
        
        varB4EAC82CA7396A68D541C85D26508E83_217979111 = readEnumDescInternal();
        
        
        varB4EAC82CA7396A68D541C85D26508E83_678832126 = (ObjectStreamClass) readCyclicReference();
        
        
        varB4EAC82CA7396A68D541C85D26508E83_84249917 = null;
        
        
        if (DroidSafeAndroidRuntime.control) throw corruptStream(tc);
        
        ObjectStreamClass varA7E53CE21691AB073D9660D615818899_74342143; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_74342143 = varB4EAC82CA7396A68D541C85D26508E83_217979111;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_74342143 = varB4EAC82CA7396A68D541C85D26508E83_678832126;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_74342143 = varB4EAC82CA7396A68D541C85D26508E83_84249917;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_74342143.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_74342143;
        
        
        
            
                
            
                
            
                
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.307 -0400", hash_original_method = "58EE21B582EE01373F973D50B42B8A60", hash_generated_method = "095F796323E74A8B5820CAD5EA11FF40")
    private ObjectStreamClass readEnumDescInternal() throws IOException, ClassNotFoundException {
        ObjectStreamClass varB4EAC82CA7396A68D541C85D26508E83_1667145450 = null; 
        ObjectStreamClass classDesc;
        primitiveData = input;
        int oldHandle = descriptorHandle;
        descriptorHandle = nextHandle();
        classDesc = readClassDescriptor();
        registerObjectRead(classDesc, descriptorHandle, false);
        descriptorHandle = oldHandle;
        primitiveData = emptyStream;
        classDesc.setClass(resolveClass(classDesc));
        discardData();
        ObjectStreamClass superClass = readClassDesc();
        checkedSetSuperClassDesc(classDesc, superClass);
        {
            boolean varDEA6609B69DA5649FF02F7EEB3B9D4F7_1451845223 = (0L != classDesc.getSerialVersionUID() || 0L != superClass.getSerialVersionUID());
            {
                if (DroidSafeAndroidRuntime.control) throw new InvalidClassException(superClass.getName(),
                    "Incompatible class (SUID): " + superClass + " but expected " + superClass);
            } 
        } 
        byte tc = nextTC();
        {
            superClass.setSuperclass(readClassDesc());
        } 
        {
            pushbackTC();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1667145450 = classDesc;
        varB4EAC82CA7396A68D541C85D26508E83_1667145450.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1667145450;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.308 -0400", hash_original_method = "0BB1D7ADA0D4FC987B96FE9D538B84F1", hash_generated_method = "EB8B3AF737801F965BB8A28F93763790")
    @SuppressWarnings("unchecked")
    private Object readEnum(boolean unshared) throws OptionalDataException,
            ClassNotFoundException, IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_624566659 = null; 
        ObjectStreamClass classDesc = readEnumDesc();
        int newHandle = nextHandle();
        String name;
        byte tc = nextTC();
        
        {
            readNewHandle();
            if (DroidSafeAndroidRuntime.control) throw new InvalidObjectException("Unshared read of back reference");
        } 
        
        
        name = (String) readCyclicReference();
        
        
        name = (String) readNewString(unshared);
        
        
        if (DroidSafeAndroidRuntime.control) throw corruptStream(tc);
        
        Enum<?> result = Enum.valueOf((Class) classDesc.forClass(), name);
        registerObjectRead(result, newHandle, unshared);
        varB4EAC82CA7396A68D541C85D26508E83_624566659 = result;
        addTaint(unshared);
        varB4EAC82CA7396A68D541C85D26508E83_624566659.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_624566659;
        
        
        
        
        
        
            
                
                    
                    
                
                
                
            
                
                
            
                
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.320 -0400", hash_original_method = "85A17F1C0F9F03F0EE48936822125550", hash_generated_method = "649AC4DDCD299A96FCCFCA13E74F849E")
    private ObjectStreamClass readNewClassDesc(boolean unshared) throws ClassNotFoundException, IOException {
        ObjectStreamClass varB4EAC82CA7396A68D541C85D26508E83_1999873872 = null; 
        primitiveData = input;
        int oldHandle = descriptorHandle;
        descriptorHandle = nextHandle();
        ObjectStreamClass newClassDesc = readClassDescriptor();
        registerObjectRead(newClassDesc, descriptorHandle, unshared);
        descriptorHandle = oldHandle;
        primitiveData = emptyStream;
        try 
        {
            newClassDesc.setClass(resolveClass(newClassDesc));
            verifyAndInit(newClassDesc);
        } 
        catch (ClassNotFoundException e)
        {
            {
                if (DroidSafeAndroidRuntime.control) throw e;
            } 
        } 
        ObjectStreamField[] fields = newClassDesc.getLoadFields();
        fields = (fields == null) ? ObjectStreamClass.NO_FIELDS : fields;
        ClassLoader loader;
        boolean var47BDE074D2A177403E07EAFF053D9C91_45932639 = (newClassDesc.forClass() == null);
        loader = callerClassLoader;
        loader = newClassDesc.forClass().getClassLoader();
        {
            ObjectStreamField element = fields[0];
            {
                element.resolve(loader);
            } 
        } 
        discardData();
        checkedSetSuperClassDesc(newClassDesc, readClassDesc());
        varB4EAC82CA7396A68D541C85D26508E83_1999873872 = newClassDesc;
        addTaint(unshared);
        varB4EAC82CA7396A68D541C85D26508E83_1999873872.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1999873872;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.322 -0400", hash_original_method = "9592596F093477979EA31311F339CD7D", hash_generated_method = "11914C55D44066C86A4A02D8F4FBD432")
    private Class<?> readNewProxyClassDesc() throws ClassNotFoundException,
            IOException {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1266932683 = null; 
        int count = input.readInt();
        String[] interfaceNames = new String[count];
        {
            int i = 0;
            {
                interfaceNames[i] = input.readUTF();
            } 
        } 
        Class<?> proxy = resolveProxyClass(interfaceNames);
        discardData();
        varB4EAC82CA7396A68D541C85D26508E83_1266932683 = proxy;
        varB4EAC82CA7396A68D541C85D26508E83_1266932683.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1266932683;
        
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.324 -0400", hash_original_method = "97948A412F94E7F820143192C44DB303", hash_generated_method = "7D994F5BF979135D7489C86A73F354B2")
    protected ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
        ObjectStreamClass varB4EAC82CA7396A68D541C85D26508E83_1181051785 = null; 
        ObjectStreamClass newClassDesc = new ObjectStreamClass();
        String name = input.readUTF();
        {
            boolean var162A1A174B912EA806BA20275BF238E6_520146380 = (name.length() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("The stream is corrupted");
            } 
        } 
        newClassDesc.setName(name);
        newClassDesc.setSerialVersionUID(input.readLong());
        newClassDesc.setFlags(input.readByte());
        {
            descriptorHandle = nextHandle();
        } 
        registerObjectRead(newClassDesc, descriptorHandle, false);
        readFieldDescriptors(newClassDesc);
        varB4EAC82CA7396A68D541C85D26508E83_1181051785 = newClassDesc;
        varB4EAC82CA7396A68D541C85D26508E83_1181051785.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1181051785;
        
        
        
        
            
        
        
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.325 -0400", hash_original_method = "C938C68924527CB04F806429B3BE928F", hash_generated_method = "E0510BC09CF26A7098341812A979432E")
    protected Class<?> resolveProxyClass(String[] interfaceNames) throws IOException, ClassNotFoundException {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1173558233 = null; 
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class<?>[] interfaces = new Class<?>[interfaceNames.length];
        {
            int i = 0;
            {
                interfaces[i] = Class.forName(interfaceNames[i], false, loader);
            } 
        } 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1173558233 = Proxy.getProxyClass(loader, interfaces);
        } 
        catch (IllegalArgumentException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new ClassNotFoundException(e.toString(), e);
        } 
        addTaint(interfaceNames[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1173558233.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1173558233;
        
        
        
        
            
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.325 -0400", hash_original_method = "11D3D467DA55FCE7098C1D9AB901525D", hash_generated_method = "E8C17528BFBAD650EBF5071750005625")
    private int readNewHandle() throws IOException {
        int var4605C3BBD7F83DAEC21E27D6EA87F85C_1863710000 = (input.readInt());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1548123396 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1548123396;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.328 -0400", hash_original_method = "B0A36455F033DD06E1C6357D1966CB2A", hash_generated_method = "8A4D2C52EB9D2FD8584D0CE96BDFE26B")
    private Object readNewObject(boolean unshared) throws OptionalDataException, ClassNotFoundException, IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_297523985 = null; 
        ObjectStreamClass classDesc = readClassDesc();
        {
            if (DroidSafeAndroidRuntime.control) throw missingClassDescriptor();
        } 
        int newHandle = nextHandle();
        Class<?> objectClass = classDesc.forClass();
        Object result = null;
        Object registeredResult = null;
        {
            result = classDesc.newInstance(objectClass);
            registerObjectRead(result, newHandle, unshared);
            registeredResult = result;
        } 
        {
            result = null;
        } 
        try 
        {
            currentObject = result;
            currentClass = classDesc;
            boolean wasExternalizable = (classDesc.getFlags() & SC_EXTERNALIZABLE) != 0;
            {
                boolean blockData = (classDesc.getFlags() & SC_BLOCK_DATA) != 0;
                {
                    primitiveData = input;
                } 
                {
                    Externalizable extern = (Externalizable) result;
                    extern.readExternal(this);
                } 
                {
                    discardData();
                } 
                {
                    primitiveData = emptyStream;
                } 
            } 
            {
                readHierarchy(result, classDesc);
            } 
        } 
        finally 
        {
            currentObject = null;
            currentClass = null;
        } 
        {
            {
                boolean varCAC8AACA1AE8B625201A6DC80248AF34_1561798935 = (classDesc.hasMethodReadResolve());
                {
                    Method methodReadResolve = classDesc.getMethodReadResolve();
                    try 
                    {
                        result = methodReadResolve.invoke(result, (Object[]) null);
                    } 
                    catch (IllegalAccessException ignored)
                    { }
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
                } 
            } 
        } 
        {
            result = resolveObject(result);
        } 
        {
            registerObjectRead(result, newHandle, unshared);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_297523985 = result;
        addTaint(unshared);
        varB4EAC82CA7396A68D541C85D26508E83_297523985.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_297523985;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.329 -0400", hash_original_method = "C5243F456C3574095BC1BB7FC2411373", hash_generated_method = "E13724007C99633DF056E9A1FCB41842")
    private InvalidClassException missingClassDescriptor() throws InvalidClassException {
        throw new InvalidClassException("Read null attempting to read class descriptor for object");
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.330 -0400", hash_original_method = "CF984AE9FCCB80A5CA5459E50D42D99D", hash_generated_method = "12D9512E0E4447D06A53FB51EEFBFF0B")
    private Object readNewString(boolean unshared) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_61250397 = null; 
        Object result = input.readUTF();
        {
            result = resolveObject(result);
        } 
        registerObjectRead(result, nextHandle(), unshared);
        varB4EAC82CA7396A68D541C85D26508E83_61250397 = result;
        addTaint(unshared);
        varB4EAC82CA7396A68D541C85D26508E83_61250397.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_61250397;
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.330 -0400", hash_original_method = "E3603577D9590FDF3626C23DB61D460D", hash_generated_method = "0BD34FEAC8FB02E545497D7DF8D8F80B")
    private Object readNewLongString(boolean unshared) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_574012397 = null; 
        long length = input.readLong();
        Object result = input.decodeUTF((int) length);
        {
            result = resolveObject(result);
        } 
        registerObjectRead(result, nextHandle(), unshared);
        varB4EAC82CA7396A68D541C85D26508E83_574012397 = result;
        addTaint(unshared);
        varB4EAC82CA7396A68D541C85D26508E83_574012397.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_574012397;
        
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.331 -0400", hash_original_method = "D5CBFBA6D0DD1CCB325BD55A2992CB88", hash_generated_method = "5FDD0DD43F3EA5186FE70E1345BB6F89")
    public final Object readObject() throws OptionalDataException,
            ClassNotFoundException, IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1597610089 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1597610089 = readObject(false);
        varB4EAC82CA7396A68D541C85D26508E83_1597610089.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1597610089;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.331 -0400", hash_original_method = "B5062D634E2B9403462F68486501694A", hash_generated_method = "8A0C2F4423F7C10D0DB3DF419B6BA61F")
    public Object readUnshared() throws IOException, ClassNotFoundException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1280628917 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1280628917 = readObject(true);
        varB4EAC82CA7396A68D541C85D26508E83_1280628917.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1280628917;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.343 -0400", hash_original_method = "E655B580AAC2F65ED2F044289942F1C0", hash_generated_method = "E94B7C3BCAB696E8E1EC3BC1B533D252")
    private Object readObject(boolean unshared) throws OptionalDataException,
            ClassNotFoundException, IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1137802883 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_607114448 = null; 
        boolean restoreInput = (primitiveData == input);
        {
            primitiveData = emptyStream;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1137802883 = readObjectOverride();
        } 
        Object result;
        try 
        {
            {
                callerClassLoader = getClosestUserClassLoader();
            } 
            result = readNonPrimitiveContent(unshared);
            {
                primitiveData = input;
            } 
        } 
        finally 
        {
            {
                callerClassLoader = null;
            } 
        } 
        {
            try 
            {
                {
                    InputValidationDesc element = validations[0];
                    {
                        element.validator.validateObject();
                    } 
                } 
            } 
            finally 
            {
                validations = null;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_607114448 = result;
        addTaint(unshared);
        Object varA7E53CE21691AB073D9660D615818899_1665033739; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1665033739 = varB4EAC82CA7396A68D541C85D26508E83_1137802883;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1665033739 = varB4EAC82CA7396A68D541C85D26508E83_607114448;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1665033739.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1665033739;
        
        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.350 -0400", hash_original_method = "F453836DFC9EEC175FFF65A0C41AF32F", hash_generated_method = "FADDCB284F291A60FA5362D069014C2F")
    protected Object readObjectOverride() throws OptionalDataException,
            ClassNotFoundException, IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_32816429 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_32816429 = null;
        } 
        if (DroidSafeAndroidRuntime.control) throw new IOException();
        varB4EAC82CA7396A68D541C85D26508E83_32816429.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_32816429;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.350 -0400", hash_original_method = "E1F1666A9CC2BCC43C42662EA935D779", hash_generated_method = "E146640591BDFC755B19F95B98F3D2F1")
    public short readShort() throws IOException {
        short varCDA22C267187CEE310BF77CF189DA7D6_869853415 = (primitiveTypes.readShort());
        short var4F09DAA9D95BCB166A302407A0E0BABE_590681727 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_590681727;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.350 -0400", hash_original_method = "2E049C52CD4079E3EDC13878B612AD59", hash_generated_method = "BC33F3EEF5E058600166BF598DA9AFC8")
    protected void readStreamHeader() throws IOException,
            StreamCorruptedException {
        {
            boolean varC19679871E5EE3ACDCBC6AB5CDD35F45_585938297 = (input.readShort() == STREAM_MAGIC
                && input.readShort() == STREAM_VERSION);
        } 
        if (DroidSafeAndroidRuntime.control) throw new StreamCorruptedException();
        
        
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.351 -0400", hash_original_method = "50996F70792020DA658FB7FFCF1EF910", hash_generated_method = "70E8ED691B86641AC891481275BF3FC7")
    public int readUnsignedByte() throws IOException {
        int varB7F3DDCB7C33CADCD69A9EA77340018F_1523849749 = (primitiveTypes.readUnsignedByte());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_811130209 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_811130209;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.351 -0400", hash_original_method = "ABA376385639B6CB8F725C68F1CED979", hash_generated_method = "23ABB588E33C117A5BFCA49FA869E243")
    public int readUnsignedShort() throws IOException {
        int var8B6F0F8EF6EFAE22F469847E9560AC03_220594948 = (primitiveTypes.readUnsignedShort());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_843967582 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_843967582;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.351 -0400", hash_original_method = "B2994D3A3B821949D517613320FA5065", hash_generated_method = "45596BC3B6737E1F79D1076873D26B17")
    public String readUTF() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_1333051863 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1333051863 = primitiveTypes.readUTF();
        varB4EAC82CA7396A68D541C85D26508E83_1333051863.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1333051863;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.352 -0400", hash_original_method = "10F65D1907C5AA72A1571FB08139A1C8", hash_generated_method = "ECD16BF8F1FE2FB3605385FD5ADA7CEC")
    private Object registeredObjectRead(int handle) throws InvalidObjectException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1542016507 = null; 
        Object res = objectsRead.get(handle - ObjectStreamConstants.baseWireHandle);
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidObjectException("Cannot read back reference to unshared object");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1542016507 = res;
        addTaint(handle);
        varB4EAC82CA7396A68D541C85D26508E83_1542016507.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1542016507;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.352 -0400", hash_original_method = "9C8641A932863D3A6F3FA22233749F54", hash_generated_method = "C46313E773B5309398593936B78A3859")
    private void registerObjectRead(Object obj, int handle, boolean unshared) throws IOException {
        {
            obj = UNSHARED_OBJ;
        } 
        int index = handle - ObjectStreamConstants.baseWireHandle;
        int size = objectsRead.size();
        {
            objectsRead.add(null);
        } 
        {
            objectsRead.add(obj);
        } 
        {
            objectsRead.set(index, obj);
        } 
        addTaint(obj.getTaint());
        addTaint(handle);
        addTaint(unshared);
        
        
            
        
        
        
        
            
            
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.353 -0400", hash_original_method = "3EFB39BBE791BF6ED902F9D8BC5F60E3", hash_generated_method = "DBBB684563180CBCEFD508E2F67F804C")
    public synchronized void registerValidation(ObjectInputValidation object,
            int priority) throws NotActiveException, InvalidObjectException {
        
        Object instanceBeingRead = this.currentObject;
        {
            if (DroidSafeAndroidRuntime.control) throw new NotActiveException();
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidObjectException("Callback object cannot be null");
        } 
        InputValidationDesc desc = new InputValidationDesc();
        desc.validator = object;
        desc.priority = priority;
        {
            validations = new InputValidationDesc[1];
            validations[0] = desc;
        } 
        {
            int i = 0;
            {
                InputValidationDesc validation = validations[i];
            } 
            InputValidationDesc[] oldValidations = validations;
            int currentSize = oldValidations.length;
            validations = new InputValidationDesc[currentSize + 1];
            System.arraycopy(oldValidations, 0, validations, 0, i);
            System.arraycopy(oldValidations, i, validations, i + 1, currentSize
                    - i);
            validations[i] = desc;
        } 
        addTaint(object.getTaint());
        addTaint(priority);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.354 -0400", hash_original_method = "7A01BA94C22B82138AACA44C7BC92DD9", hash_generated_method = "0C73C6216D604266ED6256169E691209")
    private void resetSeenObjects() {
        objectsRead = new ArrayList<Object>();
        nextHandle = baseWireHandle;
        primitiveData = emptyStream;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.354 -0400", hash_original_method = "356E50ACB0709EF4643021948AB5F291", hash_generated_method = "EC3D0E77128D57B1D4D0ED283DC54BAE")
    private void resetState() {
        resetSeenObjects();
        hasPushbackTC = false;
        pushbackTC = 0;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.355 -0400", hash_original_method = "38B51F7C504D6211D87B81513F39C956", hash_generated_method = "1F3F6B6D1C3F8AD6F8AF9A715C8807FB")
    protected Class<?> resolveClass(ObjectStreamClass osClass) throws IOException, ClassNotFoundException {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1795877273 = null; 
        Class<?> cls = osClass.forClass();
        {
            String className = osClass.getName();
            cls = PRIMITIVE_CLASSES.get(className);
            {
                cls = Class.forName(className, true, callerClassLoader);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1795877273 = cls;
        addTaint(osClass.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1795877273.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1795877273;
        
        
        
            
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.356 -0400", hash_original_method = "8BE1D9D2C1A8227AC3DEAA12C63F6442", hash_generated_method = "A2FA7910B209C71A00F17B5294F78AF1")
    protected Object resolveObject(Object object) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_982106410 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_982106410 = object;
        addTaint(object.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_982106410.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_982106410;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.357 -0400", hash_original_method = "C18A3B861F9E4DC00DB6D8F86113E96E", hash_generated_method = "4035F376B18EC23DAEF3E62332E40A94")
    public int skipBytes(int length) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        int offset = 0;
        {
            checkReadPrimitiveTypes();
            long skipped = primitiveData.skip(length - offset);
            offset += (int) skipped;
        } 
        addTaint(length);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_185004233 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_185004233;
        
        
            
        
        
        
            
            
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.358 -0400", hash_original_method = "F18AA842F3AF8655FE4F963E8A31A757", hash_generated_method = "95F46B2376B55F79D368DF7ACD6C4650")
    private void verifyAndInit(ObjectStreamClass loadedStreamClass) throws InvalidClassException {
        Class<?> localClass = loadedStreamClass.forClass();
        ObjectStreamClass localStreamClass = ObjectStreamClass
                .lookupStreamClass(localClass);
        {
            boolean var9693CD9966488232124376137EBA8914_808917806 = (loadedStreamClass.getSerialVersionUID() != localStreamClass
                .getSerialVersionUID());
            {
                if (DroidSafeAndroidRuntime.control) throw new InvalidClassException(loadedStreamClass.getName(),
                    "Incompatible class (SUID): " + loadedStreamClass +
                            " but expected " + localStreamClass);
            } 
        } 
        String loadedClassBaseName = getBaseName(loadedStreamClass.getName());
        String localClassBaseName = getBaseName(localStreamClass.getName());
        {
            boolean varB90E1FD3EA27827ECD4177A803C71953_706062523 = (!loadedClassBaseName.equals(localClassBaseName));
            {
                if (DroidSafeAndroidRuntime.control) throw new InvalidClassException(loadedStreamClass.getName(),
                    String.format("Incompatible class (base name): %s but expected %s",
                            loadedClassBaseName, localClassBaseName));
            } 
        } 
        loadedStreamClass.initPrivateFields(localStreamClass);
        addTaint(loadedStreamClass.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static String getBaseName(String fullName) {
        int k = fullName.lastIndexOf('.');
        if (k == -1 || k == (fullName.length() - 1)) {
            return fullName;
        }
        return fullName.substring(k + 1);
    }

    
    @DSModeled(DSC.SAFE)
    private static void checkedSetSuperClassDesc(ObjectStreamClass desc,
            ObjectStreamClass superDesc) throws StreamCorruptedException {
        if (desc.equals(superDesc)) {
            throw new StreamCorruptedException();
        }
        desc.setSuperclass(superDesc);
    }

    
    static class InputValidationDesc {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.359 -0400", hash_original_field = "8D6C391E7CB39133C91B73281A24F21F", hash_generated_field = "59BAC1D70D65173C0176BF76148E5AB7")

        ObjectInputValidation validator;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.359 -0400", hash_original_field = "B988295C268025B49DFB3DF26171DDC3", hash_generated_field = "4AD9F2E37B35E313CD211FBAFDADA238")

        int priority;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.359 -0400", hash_original_method = "9B1F2C1B15D11C4CFF789483FB2B6658", hash_generated_method = "9B1F2C1B15D11C4CFF789483FB2B6658")
        public InputValidationDesc ()
        {
            
        }


    }


    
    public abstract static class GetField {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.360 -0400", hash_original_method = "3E66EA4913058A142DD3D4DCDDDF2758", hash_generated_method = "3E66EA4913058A142DD3D4DCDDDF2758")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.363 -0400", hash_original_field = "84E5CE7FC519663BA115DBD4D0C5A535", hash_generated_field = "AB31E5C2BA954217EF88CD850CFC8C65")

    private static final Object UNSHARED_OBJ = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.363 -0400", hash_original_field = "42768E4035EB7085BBD39A4E45389BDC", hash_generated_field = "CF28BF30867E0E1F6DF3B872782F2ED3")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.363 -0400", hash_original_field = "E29C7DCEE0BF15C29DD3EA56FC9F2AF1", hash_generated_field = "0BEDBBB2B96D03A03BECE92D911B88AD")

    private static final ClassLoader bootstrapLoader = Object.class.getClassLoader();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.363 -0400", hash_original_field = "89EBE3ECF326D242BB3DB8E1D4A3021B", hash_generated_field = "F543C6A7F69C1743531D486F7F24DDAE")

    private static final ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
}

