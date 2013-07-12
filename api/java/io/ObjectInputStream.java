package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.182 -0400", hash_original_field = "559F34BD1B83DCCF42BD97118C30004D", hash_generated_field = "9C428AEC470C7B513A34BE33B758C61C")

    private InputStream emptyStream = new ByteArrayInputStream(EmptyArray.BYTE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.183 -0400", hash_original_field = "5A8A6215AD70C3096643367A265101CD", hash_generated_field = "C282E9AAC2D48EC47E345831218585FA")

    private boolean hasPushbackTC;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.183 -0400", hash_original_field = "E07029C787F995347976B5426FA51D79", hash_generated_field = "64B94603DBAD0B26BD5AE2F7439ED35E")

    private byte pushbackTC;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.183 -0400", hash_original_field = "993B80B15181215612E5959DB832BFAF", hash_generated_field = "123C8BF62BBC79B951F58B358976C3FF")

    private int nestedLevels;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.184 -0400", hash_original_field = "CB52CB1EDBEC59BDE75BA590938374FC", hash_generated_field = "FBF49E90A1B9879AE660F9886E842C8C")

    private int nextHandle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.184 -0400", hash_original_field = "A43C1B0AA53A0C908810C06AB1FF3967", hash_generated_field = "32FD79F94203B3CB4FB10D6979B3AE55")

    private DataInputStream input;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.184 -0400", hash_original_field = "8AFA05430C7155E00832EE4E25A1E3C4", hash_generated_field = "76093EED1B475C4F1E4C622B52BC7AC9")

    private DataInputStream primitiveTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.184 -0400", hash_original_field = "6AA631A1CF88716882035C982A3A5C5A", hash_generated_field = "28C1B2E39A3350A755888FD0A4428279")

    private InputStream primitiveData = emptyStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.185 -0400", hash_original_field = "814324F3D01F90BE0344B032BCDAEB46", hash_generated_field = "3240649A9311294AE1E098CB8F2A005F")

    private boolean enableResolve;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.185 -0400", hash_original_field = "324CFF805C6D6B99EE7C6FE654D64D06", hash_generated_field = "F79B8A3B52A523F03D688BC47873D2F6")

    private ArrayList<Object> objectsRead;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.185 -0400", hash_original_field = "895D2E18F5D2EA8F00F48DF2FB178E4D", hash_generated_field = "76736C274255A46E2AEB2CE593A1B428")

    private Object currentObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.186 -0400", hash_original_field = "457C5912366BE090D6A2931DE14CDA9E", hash_generated_field = "7035F4B44BC3AE389D42445F7A5655AC")

    private ObjectStreamClass currentClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.186 -0400", hash_original_field = "A81AAA0781C265056D03A0138CF839B3", hash_generated_field = "4E53F0CFC72A51A3B3CAAC6447A9F3B4")

    private InputValidationDesc[] validations;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.186 -0400", hash_original_field = "35C5D5BAEC9DA39A210149CA5A667705", hash_generated_field = "3690401F10D38FF2C8AB1C19B641B107")

    private boolean subclassOverridingImplementation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.187 -0400", hash_original_field = "0630628FEFA32E6BCF95C8130059DD84", hash_generated_field = "7E360A145DF451DC0144E812BE96A034")

    private ClassLoader callerClassLoader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.187 -0400", hash_original_field = "AFDD2451F1D1759C785DD591BC1506D8", hash_generated_field = "2DA36CFD381BE4CC041D9D9E401B490D")

    private boolean mustResolve = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.188 -0400", hash_original_field = "3A717ED2456CACB3BC0F8AE8881EF3AA", hash_generated_field = "2B0CB3B967646FBC95A533438216C0DF")

    private int descriptorHandle = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.188 -0400", hash_original_field = "C1487B64EE4D02CA5ED52EFDAA9A2E96", hash_generated_field = "FAF1B21A627FAB868C99C514185244A6")

    private HashMap<Class<?>, List<Class<?>>> cachedSuperclasses = new HashMap<Class<?>, List<Class<?>>>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.189 -0400", hash_original_method = "124623F0922D5D71F912D224AEC5FA85", hash_generated_method = "ACAF350C98F97636B8BC13996275E1E2")
    protected  ObjectInputStream() throws IOException {
        this.subclassOverridingImplementation = true;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.191 -0400", hash_original_method = "15BB4AD74FE576D95ABFC0E40CC8A986", hash_generated_method = "703A8C3897973881276857A3F1438BAC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.192 -0400", hash_original_method = "CEC952E1AEB3FC5761C4573EC7C87AAE", hash_generated_method = "20540CA8B0B5F47282297BB76EDAF16B")
    @Override
    public int available() throws IOException {
        checkReadPrimitiveTypes();
        int var41A4F3BC0C0791EEB464592BA2FDF983_60376685 = (primitiveData.available());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_749311172 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_749311172;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.195 -0400", hash_original_method = "5DD662298FB99DC11E3F5A1BB4812CC0", hash_generated_method = "B113C7EEBC64D7680294029D58A2F8E6")
    private void checkReadPrimitiveTypes() throws IOException {
    if(primitiveData == input || primitiveData.available() > 0)        
        {
            return;
        } 
        do {
            {
                int next = 0;
    if(hasPushbackTC)                
                {
                    hasPushbackTC = false;
                } 
                else
                {
                    next = input.read();
                    pushbackTC = (byte) next;
                } 
switch(pushbackTC){
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
    if(next != -1)                
                {
                    pushbackTC();
                } 
                return;
}
            } 
} while (true);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.196 -0400", hash_original_method = "4ECD43BBA7F31E748521530C375A35B5", hash_generated_method = "EBCAB811F86091C4F8C851B059031D05")
    @Override
    public void close() throws IOException {
        input.close();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.197 -0400", hash_original_method = "6463B95302326251A8E319007FB9B6A5", hash_generated_method = "C2A4CF07DA31E4C115DF2562D4C757A7")
    public void defaultReadObject() throws IOException, ClassNotFoundException,
            NotActiveException {
    if(currentObject != null || !mustResolve)        
        {
            readFieldValues(currentObject, currentClass);
        } 
        else
        {
            NotActiveException varFD1AAF3605EC866A6A8BBEC842DA8C8A_1647840646 = new NotActiveException();
            varFD1AAF3605EC866A6A8BBEC842DA8C8A_1647840646.addTaint(taint);
            throw varFD1AAF3605EC866A6A8BBEC842DA8C8A_1647840646;
        } 
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.199 -0400", hash_original_method = "970A975ADDA1CD42A4A6880D40629922", hash_generated_method = "92C9F579BCFAD2F150DB382D4482E6E9")
    protected boolean enableResolveObject(boolean enable) {
        boolean originalValue = enableResolve;
        enableResolve = enable;
        boolean var48A7AAFD2093A2CFD7C2A6E0C39C3B3C_977180267 = (originalValue);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1143036858 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1143036858;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.204 -0400", hash_original_method = "BEEE4D4B01DB5401D5A386ECF8653C53", hash_generated_method = "E0CB1BA0F4F485CD378C13FC5973E6A7")
    private int nextHandle() {
        int varFF113B7ACD957FCEBD61C4FF9210CB16_1925809842 = (nextHandle++);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_691212053 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_691212053;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.209 -0400", hash_original_method = "EA84EB3C5ACC30FA1515ABE6938E6E9B", hash_generated_method = "29EEF9BE7A087056CD67A9DCE56ED140")
    private byte nextTC() throws IOException {
    if(hasPushbackTC)        
        {
            hasPushbackTC = false;
        } 
        else
        {
            pushbackTC = input.readByte();
        } 
        byte varE07029C787F995347976B5426FA51D79_840000467 = (pushbackTC);
                byte var40EA57D3EE3C07BF1C102B466E1C3091_721192384 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_721192384;
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.211 -0400", hash_original_method = "056AB6ECFECE1087CD6299233C3046CF", hash_generated_method = "1AA917BD8C0785A0A281D56B178CD348")
    private void pushbackTC() {
        hasPushbackTC = true;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.212 -0400", hash_original_method = "87E37984C9E76D351365EC77DA0248F5", hash_generated_method = "71623895788BC19087F9311547BD91D1")
    @Override
    public int read() throws IOException {
        checkReadPrimitiveTypes();
        int varD04DFE2746884E9CD8527C180BCA3864_2109835694 = (primitiveData.read());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_90477937 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_90477937;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.215 -0400", hash_original_method = "7E3B2630C90BBA61B0E7CD83B04481D2", hash_generated_method = "6E602F9E034C6F1A2900723EA3033402")
    @Override
    public int read(byte[] buffer, int offset, int length) throws IOException {
        addTaint(length);
        addTaint(offset);
        addTaint(buffer[0]);
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
    if(length == 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1540121192 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_910855171 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_910855171;
        } 
        checkReadPrimitiveTypes();
        int var794DFA0474D62B0CDAB50D94A5957122_108075844 = (primitiveData.read(buffer, offset, length));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_616755615 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_616755615;
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.218 -0400", hash_original_method = "35383BB5231F8136A4FECB09DEC2FE93", hash_generated_method = "479F76A7A005C2E82FC33E36975EEDE9")
    private byte[] readBlockData() throws IOException {
        byte[] result = new byte[input.readByte() & 0xff];
        input.readFully(result);
        byte[] varB4A88417B3D0170D754C647C30B7216A_508885052 = (result);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_396566963 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_396566963;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.220 -0400", hash_original_method = "478D7B43D09CD1BAF3CA95670FAE291A", hash_generated_method = "E5027CC8A7C598414CFD1ED29C125CA0")
    private byte[] readBlockDataLong() throws IOException {
        byte[] result = new byte[input.readInt()];
        input.readFully(result);
        byte[] varB4A88417B3D0170D754C647C30B7216A_1123106970 = (result);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_424507247 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_424507247;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.221 -0400", hash_original_method = "43182B65F59B21B8425D068A4900EB3A", hash_generated_method = "3F860B2343425C56E8724EF2FAFC2F4D")
    public boolean readBoolean() throws IOException {
        boolean varF35D2E687280B7E8B6B9F81EE2DFA149_276906839 = (primitiveTypes.readBoolean());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_315525230 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_315525230;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.223 -0400", hash_original_method = "F1C938A529B536DE0EA7C0848AC19388", hash_generated_method = "68BAA933E4D0135F1D00D8C94D9AC23D")
    public byte readByte() throws IOException {
        byte var67C1EA294D5E8AAFD4909D340B2DB1E4_35052278 = (primitiveTypes.readByte());
                byte var40EA57D3EE3C07BF1C102B466E1C3091_56624810 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_56624810;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.225 -0400", hash_original_method = "08C7569945A67E2D251F3B449209E666", hash_generated_method = "53D3C8EE6D62359AB5A4C4A0A43382E5")
    public char readChar() throws IOException {
        char var1A38B429BDAAAC24B2A6F0D286767462_1864781179 = (primitiveTypes.readChar());
                char varA87DEB01C5F539E6BDA34829C8EF2368_1939575428 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1939575428;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.230 -0400", hash_original_method = "7E3D613702E21574BA96B289FBA102EA", hash_generated_method = "E3E23E13C273441801D498E9BCAF5FD3")
    private void discardData() throws ClassNotFoundException, IOException {
        primitiveData = emptyStream;
        boolean resolve = mustResolve;
        mustResolve = false;
        do {
            {
                byte tc = nextTC();
    if(tc == TC_ENDBLOCKDATA)                
                {
                    mustResolve = resolve;
                    return;
                } 
                readContent(tc);
            } 
} while (true);
        
        
        
        
        
            
            
                
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.252 -0400", hash_original_method = "8425AE4559FEB283CFFC129B3DDD377F", hash_generated_method = "A3BD622941AAA021E2DCA0850EFD9340")
    private ObjectStreamClass readClassDesc() throws ClassNotFoundException, IOException {
        byte tc = nextTC();
switch(tc){
        case TC_CLASSDESC:
ObjectStreamClass varCF7F61C10F02C651E05B883D30B98921_445966599 =         readNewClassDesc(false);
        varCF7F61C10F02C651E05B883D30B98921_445966599.addTaint(taint);
        return varCF7F61C10F02C651E05B883D30B98921_445966599;
        case TC_PROXYCLASSDESC:
        Class<?> proxyClass = readNewProxyClassDesc();
        ObjectStreamClass streamClass = ObjectStreamClass.lookup(proxyClass);
        streamClass.setLoadFields(ObjectStreamClass.NO_FIELDS);
        registerObjectRead(streamClass, nextHandle(), false);
        checkedSetSuperClassDesc(streamClass, readClassDesc());
ObjectStreamClass varB15C7012F89088D5E62C8E84F0D75364_619919125 =         streamClass;
        varB15C7012F89088D5E62C8E84F0D75364_619919125.addTaint(taint);
        return varB15C7012F89088D5E62C8E84F0D75364_619919125;
        case TC_REFERENCE:
ObjectStreamClass var45BA89463163BB71DA22DB941DEC608E_523634120 =         (ObjectStreamClass) readCyclicReference();
        var45BA89463163BB71DA22DB941DEC608E_523634120.addTaint(taint);
        return var45BA89463163BB71DA22DB941DEC608E_523634120;
        case TC_NULL:
ObjectStreamClass var540C13E9E156B687226421B24F2DF178_1026716682 =         null;
        var540C13E9E156B687226421B24F2DF178_1026716682.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1026716682;
        default:
        java.io.StreamCorruptedException varA1F85B50BF8446E6D14D510BCDD729EB_1737253487 = corruptStream(tc);
        varA1F85B50BF8446E6D14D510BCDD729EB_1737253487.addTaint(taint);
        throw varA1F85B50BF8446E6D14D510BCDD729EB_1737253487;
}
        
        
        
            
                
            
                
                
                
                
                
                
            
                
            
                
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.255 -0400", hash_original_method = "D1B003D7ABBBCEF0B15D64544C91AEEF", hash_generated_method = "441A77EE4AD6E2A654E053FDEBE7BEFE")
    private StreamCorruptedException corruptStream(byte tc) throws StreamCorruptedException {
        addTaint(tc);
        StreamCorruptedException var0471ACC505E72FE25CC45B1924A74A13_746702887 = new StreamCorruptedException("Wrong format: " + Integer.toHexString(tc & 0xff));
        var0471ACC505E72FE25CC45B1924A74A13_746702887.addTaint(taint);
        throw var0471ACC505E72FE25CC45B1924A74A13_746702887;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.282 -0400", hash_original_method = "EBF146E3B3C2508DCA0D721582A75609", hash_generated_method = "AB4DC96798102186E9674DA5731A4821")
    private Object readContent(byte tc) throws ClassNotFoundException,
            IOException {
        addTaint(tc);
switch(tc){
        case TC_BLOCKDATA:
Object var43CB2D2F0DC9F9E7FE6815C35473E82C_1364801766 =         readBlockData();
        var43CB2D2F0DC9F9E7FE6815C35473E82C_1364801766.addTaint(taint);
        return var43CB2D2F0DC9F9E7FE6815C35473E82C_1364801766;
        case TC_BLOCKDATALONG:
Object varEC9A5C7E15069F19E88B8CDB3E213D22_11464974 =         readBlockDataLong();
        varEC9A5C7E15069F19E88B8CDB3E213D22_11464974.addTaint(taint);
        return varEC9A5C7E15069F19E88B8CDB3E213D22_11464974;
        case TC_CLASS:
Object var4646CBA7D98975B6A0A5E8BAEE19B439_1555407812 =         readNewClass(false);
        var4646CBA7D98975B6A0A5E8BAEE19B439_1555407812.addTaint(taint);
        return var4646CBA7D98975B6A0A5E8BAEE19B439_1555407812;
        case TC_CLASSDESC:
Object varCF7F61C10F02C651E05B883D30B98921_351547260 =         readNewClassDesc(false);
        varCF7F61C10F02C651E05B883D30B98921_351547260.addTaint(taint);
        return varCF7F61C10F02C651E05B883D30B98921_351547260;
        case TC_ARRAY:
Object var03139D67A4693412A22B6F837A4BA5EC_441920469 =         readNewArray(false);
        var03139D67A4693412A22B6F837A4BA5EC_441920469.addTaint(taint);
        return var03139D67A4693412A22B6F837A4BA5EC_441920469;
        case TC_OBJECT:
Object var2C4B5CF99C7ACE03D796FDF9B77EB761_256874856 =         readNewObject(false);
        var2C4B5CF99C7ACE03D796FDF9B77EB761_256874856.addTaint(taint);
        return var2C4B5CF99C7ACE03D796FDF9B77EB761_256874856;
        case TC_STRING:
Object varF34385A2E461922D13908D6E4EEB6162_619096315 =         readNewString(false);
        varF34385A2E461922D13908D6E4EEB6162_619096315.addTaint(taint);
        return varF34385A2E461922D13908D6E4EEB6162_619096315;
        case TC_LONGSTRING:
Object var67CF6CDB5339B77E74CF012E62385BE0_1715202369 =         readNewLongString(false);
        var67CF6CDB5339B77E74CF012E62385BE0_1715202369.addTaint(taint);
        return var67CF6CDB5339B77E74CF012E62385BE0_1715202369;
        case TC_REFERENCE:
Object var0BF3707675556B4FE0EF8CB26EC6C54B_1541032382 =         readCyclicReference();
        var0BF3707675556B4FE0EF8CB26EC6C54B_1541032382.addTaint(taint);
        return var0BF3707675556B4FE0EF8CB26EC6C54B_1541032382;
        case TC_NULL:
Object var540C13E9E156B687226421B24F2DF178_1290113469 =         null;
        var540C13E9E156B687226421B24F2DF178_1290113469.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1290113469;
        case TC_EXCEPTION:
        Exception exc = readException();
        WriteAbortedException var2F060354FC02BC4D8A492774E83099BD_1093936482 = new WriteAbortedException("Read an exception", exc);
        var2F060354FC02BC4D8A492774E83099BD_1093936482.addTaint(taint);
        throw var2F060354FC02BC4D8A492774E83099BD_1093936482;
        case TC_RESET:
        resetState();
Object var540C13E9E156B687226421B24F2DF178_708464855 =         null;
        var540C13E9E156B687226421B24F2DF178_708464855.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_708464855;
        default:
        java.io.StreamCorruptedException varA1F85B50BF8446E6D14D510BCDD729EB_1357880957 = corruptStream(tc);
        varA1F85B50BF8446E6D14D510BCDD729EB_1357880957.addTaint(taint);
        throw varA1F85B50BF8446E6D14D510BCDD729EB_1357880957;
}
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.314 -0400", hash_original_method = "C964F7473D297E2F3A28B1C55493EBEA", hash_generated_method = "B8B642EFDCD64763B214FFB7AEB764C0")
    private Object readNonPrimitiveContent(boolean unshared) throws ClassNotFoundException, IOException {
        addTaint(unshared);
        checkReadPrimitiveTypes();
    if(primitiveData.available() > 0)        
        {
            OptionalDataException e = new OptionalDataException();
            e.length = primitiveData.available();
            e.addTaint(taint);
            throw e;
        } 
        do {
            {
                byte tc = nextTC();
switch(tc){
                case TC_CLASS:
Object var145A039A3C690A9E8FC4A3FB7BFD0A17_1450922038 =                 readNewClass(unshared);
                var145A039A3C690A9E8FC4A3FB7BFD0A17_1450922038.addTaint(taint);
                return var145A039A3C690A9E8FC4A3FB7BFD0A17_1450922038;
                case TC_CLASSDESC:
Object varB5579989F181BBC1FE2F31A8753136D7_972931555 =                 readNewClassDesc(unshared);
                varB5579989F181BBC1FE2F31A8753136D7_972931555.addTaint(taint);
                return varB5579989F181BBC1FE2F31A8753136D7_972931555;
                case TC_ARRAY:
Object varB3470F4BCFD222571EBE4750011FF3C8_1938903551 =                 readNewArray(unshared);
                varB3470F4BCFD222571EBE4750011FF3C8_1938903551.addTaint(taint);
                return varB3470F4BCFD222571EBE4750011FF3C8_1938903551;
                case TC_OBJECT:
Object var0E999F4AE2CE265FD473F4C0201BFE56_918076887 =                 readNewObject(unshared);
                var0E999F4AE2CE265FD473F4C0201BFE56_918076887.addTaint(taint);
                return var0E999F4AE2CE265FD473F4C0201BFE56_918076887;
                case TC_STRING:
Object varDD643C684E598AF8988E057D3CFCECB8_9452220 =                 readNewString(unshared);
                varDD643C684E598AF8988E057D3CFCECB8_9452220.addTaint(taint);
                return varDD643C684E598AF8988E057D3CFCECB8_9452220;
                case TC_LONGSTRING:
Object var6AC1359F4772D672933436D4D0A54361_1353284003 =                 readNewLongString(unshared);
                var6AC1359F4772D672933436D4D0A54361_1353284003.addTaint(taint);
                return var6AC1359F4772D672933436D4D0A54361_1353284003;
                case TC_ENUM:
Object var567126F916CFF7C51C75D14E86B2324F_2061838413 =                 readEnum(unshared);
                var567126F916CFF7C51C75D14E86B2324F_2061838413.addTaint(taint);
                return var567126F916CFF7C51C75D14E86B2324F_2061838413;
                case TC_REFERENCE:
    if(unshared)                
                {
                    readNewHandle();
                    InvalidObjectException varB03B1E7AB6C2FC12286EAFC18E1E860F_77725556 = new InvalidObjectException("Unshared read of back reference");
                    varB03B1E7AB6C2FC12286EAFC18E1E860F_77725556.addTaint(taint);
                    throw varB03B1E7AB6C2FC12286EAFC18E1E860F_77725556;
                } 
Object var0BF3707675556B4FE0EF8CB26EC6C54B_1835626800 =                 readCyclicReference();
                var0BF3707675556B4FE0EF8CB26EC6C54B_1835626800.addTaint(taint);
                return var0BF3707675556B4FE0EF8CB26EC6C54B_1835626800;
                case TC_NULL:
Object var540C13E9E156B687226421B24F2DF178_561796559 =                 null;
                var540C13E9E156B687226421B24F2DF178_561796559.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_561796559;
                case TC_EXCEPTION:
                Exception exc = readException();
                WriteAbortedException var2F060354FC02BC4D8A492774E83099BD_516082414 = new WriteAbortedException("Read an exception", exc);
                var2F060354FC02BC4D8A492774E83099BD_516082414.addTaint(taint);
                throw var2F060354FC02BC4D8A492774E83099BD_516082414;
                case TC_RESET:
                resetState();
                break;
                case TC_ENDBLOCKDATA:
                pushbackTC();
                OptionalDataException e = new OptionalDataException();
                e.eof = true;
                e.addTaint(taint);
                throw e;
                default:
                java.io.StreamCorruptedException varA1F85B50BF8446E6D14D510BCDD729EB_156407358 = corruptStream(tc);
                varA1F85B50BF8446E6D14D510BCDD729EB_156407358.addTaint(taint);
                throw varA1F85B50BF8446E6D14D510BCDD729EB_156407358;
}
            } 
} while (true);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.316 -0400", hash_original_method = "821B45232EA8F88246A504603C8240EF", hash_generated_method = "622FBEEFA1B244B8D7F26DDF226B4B29")
    private Object readCyclicReference() throws InvalidObjectException, IOException {
Object varB1538074715E5E5A847ABEB7ED0A3C23_804825988 =         registeredObjectRead(readNewHandle());
        varB1538074715E5E5A847ABEB7ED0A3C23_804825988.addTaint(taint);
        return varB1538074715E5E5A847ABEB7ED0A3C23_804825988;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.318 -0400", hash_original_method = "7C91F28BD77A4ED641420E614D9FCB15", hash_generated_method = "DBA9F002DB415AA63103C6013E79344A")
    public double readDouble() throws IOException {
        double var13DB878FE5FD515296AAFEC61E2A5FB3_1635667629 = (primitiveTypes.readDouble());
                double varE8CD7DA078A86726031AD64F35F5A6C0_1431587460 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1431587460;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.319 -0400", hash_original_method = "BA11A34B6A0BFC2FA522B0508C6E225C", hash_generated_method = "FE69D5A8DC8DD7B910550F8AE354EF61")
    private Exception readException() throws WriteAbortedException,
            OptionalDataException, ClassNotFoundException, IOException {
        resetSeenObjects();
        Exception exc = (Exception) readObject();
        resetSeenObjects();
Exception varA75BAC093E1427C564E637F02D38B691_1906199989 =         exc;
        varA75BAC093E1427C564E637F02D38B691_1906199989.addTaint(taint);
        return varA75BAC093E1427C564E637F02D38B691_1906199989;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.322 -0400", hash_original_method = "FA3DFED5FC7EE2104F3E818CA56DCFE9", hash_generated_method = "954054B850E3350F0F222DECEBACAF1D")
    private void readFieldDescriptors(ObjectStreamClass cDesc) throws ClassNotFoundException, IOException {
        addTaint(cDesc.getTaint());
        short numFields = input.readShort();
        ObjectStreamField[] fields = new ObjectStreamField[numFields];
        cDesc.setLoadFields(fields);
for(short i = 0;i < numFields;i++)
        {
            char typecode = (char) input.readByte();
            String fieldName = input.readUTF();
            boolean isPrimType = ObjectStreamClass.isPrimitiveType(typecode);
            String classSig;
    if(isPrimType)            
            {
                classSig = String.valueOf(typecode);
            } 
            else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.328 -0400", hash_original_method = "35D23573908F6AA48B37BF1647A74D3F", hash_generated_method = "8FA06DC935414413F10A02C6AA2AACC7")
    public GetField readFields() throws IOException, ClassNotFoundException, NotActiveException {
    if(currentObject == null)        
        {
            NotActiveException varFD1AAF3605EC866A6A8BBEC842DA8C8A_21513739 = new NotActiveException();
            varFD1AAF3605EC866A6A8BBEC842DA8C8A_21513739.addTaint(taint);
            throw varFD1AAF3605EC866A6A8BBEC842DA8C8A_21513739;
        } 
        EmulatedFieldsForLoading result = new EmulatedFieldsForLoading(currentClass);
        readFieldValues(result);
GetField varDC838461EE2FA0CA4C9BBB70A15456B0_1865133947 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1865133947.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1865133947;
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.337 -0400", hash_original_method = "8289C081F35F5F257A7DE20983B5F39B", hash_generated_method = "522EC1D03FCCB1B3E4E1C427DAED12F0")
    private void readFieldValues(EmulatedFieldsForLoading emulatedFields) throws OptionalDataException, InvalidClassException, IOException {
        addTaint(emulatedFields.getTaint());
        EmulatedFields.ObjectSlot[] slots = emulatedFields.emulatedFields().slots();
for(ObjectSlot element : slots)
        {
            element.defaulted = false;
            Class<?> type = element.field.getType();
    if(type == int.class)            
            {
                element.fieldValue = input.readInt();
            } 
            else
    if(type == byte.class)            
            {
                element.fieldValue = input.readByte();
            } 
            else
    if(type == char.class)            
            {
                element.fieldValue = input.readChar();
            } 
            else
    if(type == short.class)            
            {
                element.fieldValue = input.readShort();
            } 
            else
    if(type == boolean.class)            
            {
                element.fieldValue = input.readBoolean();
            } 
            else
    if(type == long.class)            
            {
                element.fieldValue = input.readLong();
            } 
            else
    if(type == float.class)            
            {
                element.fieldValue = input.readFloat();
            } 
            else
    if(type == double.class)            
            {
                element.fieldValue = input.readDouble();
            } 
            else
            {
                try 
                {
                    element.fieldValue = readObject();
                } 
                catch (ClassNotFoundException cnf)
                {
                    InvalidClassException varBA9D7153552A6E4211042728FA0F0503_806024067 = new InvalidClassException(cnf.toString());
                    varBA9D7153552A6E4211042728FA0F0503_806024067.addTaint(taint);
                    throw varBA9D7153552A6E4211042728FA0F0503_806024067;
                } 
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.343 -0400", hash_original_method = "3FF4AC35875B69602347D8B467CAEB0A", hash_generated_method = "702651E00D406C1851E62C3324BB88D8")
    private void readFieldValues(Object obj, ObjectStreamClass classDesc) throws OptionalDataException, ClassNotFoundException, IOException {
        addTaint(classDesc.getTaint());
        addTaint(obj.getTaint());
        ObjectStreamField[] fields = classDesc.getLoadFields();
        fields = (fields == null) ? ObjectStreamClass.NO_FIELDS : fields;
        Class<?> declaringClass = classDesc.forClass();
    if(declaringClass == null && mustResolve)        
        {
            ClassNotFoundException var3ED5BA2CAAB610C07192C5A85172915A_1646554731 = new ClassNotFoundException(classDesc.getName());
            var3ED5BA2CAAB610C07192C5A85172915A_1646554731.addTaint(taint);
            throw var3ED5BA2CAAB610C07192C5A85172915A_1646554731;
        } 
for(ObjectStreamField fieldDesc : fields)
        {
            Field field = classDesc.getReflectionField(fieldDesc);
            try 
            {
                Class<?> type = fieldDesc.getTypeInternal();
    if(type == byte.class)                
                {
                    byte b = input.readByte();
    if(field != null)                    
                    {
                        field.setByte(obj, b);
                    } 
                } 
                else
    if(type == char.class)                
                {
                    char c = input.readChar();
    if(field != null)                    
                    {
                        field.setChar(obj, c);
                    } 
                } 
                else
    if(type == double.class)                
                {
                    double d = input.readDouble();
    if(field != null)                    
                    {
                        field.setDouble(obj, d);
                    } 
                } 
                else
    if(type == float.class)                
                {
                    float f = input.readFloat();
    if(field != null)                    
                    {
                        field.setFloat(obj, f);
                    } 
                } 
                else
    if(type == int.class)                
                {
                    int i = input.readInt();
    if(field != null)                    
                    {
                        field.setInt(obj, i);
                    } 
                } 
                else
    if(type == long.class)                
                {
                    long j = input.readLong();
    if(field != null)                    
                    {
                        field.setLong(obj, j);
                    } 
                } 
                else
    if(type == short.class)                
                {
                    short s = input.readShort();
    if(field != null)                    
                    {
                        field.setShort(obj, s);
                    } 
                } 
                else
    if(type == boolean.class)                
                {
                    boolean z = input.readBoolean();
    if(field != null)                    
                    {
                        field.setBoolean(obj, z);
                    } 
                } 
                else
                {
                    Object toSet = fieldDesc.isUnshared() ? readUnshared() : readObject();
    if(toSet != null)                    
                    {
                        String fieldName = fieldDesc.getName();
                        ObjectStreamField localFieldDesc = classDesc.getField(fieldName);
                        Class<?> fieldType = localFieldDesc.getTypeInternal();
                        Class<?> valueType = toSet.getClass();
    if(!fieldType.isAssignableFrom(valueType))                        
                        {
                            ClassCastException var8709C55D8E8D81887E10913DE8AB2867_51361393 = new ClassCastException(classDesc.getName() + "." + fieldName + " - " + fieldType + " not compatible with " + valueType);
                            var8709C55D8E8D81887E10913DE8AB2867_51361393.addTaint(taint);
                            throw var8709C55D8E8D81887E10913DE8AB2867_51361393;
                        } 
    if(field != null)                        
                        {
                            field.set(obj, toSet);
                        } 
                    } 
                } 
            } 
            catch (IllegalAccessException iae)
            {
                AssertionError varB7184EDFD8CA9CD0B66958C2AD057E9E_759271722 = new AssertionError(iae);
                varB7184EDFD8CA9CD0B66958C2AD057E9E_759271722.addTaint(taint);
                throw varB7184EDFD8CA9CD0B66958C2AD057E9E_759271722;
            } 
            catch (NoSuchFieldError ignored)
            {
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.349 -0400", hash_original_method = "E7BFAC98C28E1C1B49BD33FC0E76EA53", hash_generated_method = "04D66E8BF1D7C920E563E7376F0C16D0")
    public float readFloat() throws IOException {
        float var23384172A845DD5A2C5BBE3AD6F05EED_869561621 = (primitiveTypes.readFloat());
                float var546ADE640B6EDFBC8A086EF31347E768_45753717 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_45753717;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.351 -0400", hash_original_method = "917418BB5C848A4690F4E96972002BAD", hash_generated_method = "29573BEC4ED9B3CA1C7F76B5436712E4")
    public void readFully(byte[] dst) throws IOException {
        addTaint(dst[0]);
        primitiveTypes.readFully(dst);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.354 -0400", hash_original_method = "046EB506BDA13B9ED79306898615169A", hash_generated_method = "9E14F09FB2D95B59FC09DA5B851EC42A")
    public void readFully(byte[] dst, int offset, int byteCount) throws IOException {
        addTaint(byteCount);
        addTaint(offset);
        addTaint(dst[0]);
        primitiveTypes.readFully(dst, offset, byteCount);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.361 -0400", hash_original_method = "D8B45244A94A62B53D8A8E2E7C864422", hash_generated_method = "459B2660AF2DFF91A13DD061D8EAE0AF")
    private void readHierarchy(Object object, ObjectStreamClass classDesc) throws IOException, ClassNotFoundException, NotActiveException {
        addTaint(classDesc.getTaint());
        addTaint(object.getTaint());
    if(object == null && mustResolve)        
        {
            NotActiveException varFD1AAF3605EC866A6A8BBEC842DA8C8A_2054963057 = new NotActiveException();
            varFD1AAF3605EC866A6A8BBEC842DA8C8A_2054963057.addTaint(taint);
            throw varFD1AAF3605EC866A6A8BBEC842DA8C8A_2054963057;
        } 
        List<ObjectStreamClass> streamClassList = classDesc.getHierarchy();
    if(object == null)        
        {
for(ObjectStreamClass objectStreamClass : streamClassList)
            {
                readObjectForClass(null, objectStreamClass);
            } 
        } 
        else
        {
            List<Class<?>> superclasses = cachedSuperclasses.get(object.getClass());
    if(superclasses == null)            
            {
                superclasses = cacheSuperclassesFor(object.getClass());
            } 
            int lastIndex = 0;
for(int i = 0, end = superclasses.size();i < end;++i)
            {
                Class<?> superclass = superclasses.get(i);
                int index = findStreamSuperclass(superclass, streamClassList, lastIndex);
    if(index == -1)                
                {
                    readObjectNoData(object, superclass,
                            ObjectStreamClass.lookupStreamClass(superclass));
                } 
                else
                {
for(int j = lastIndex;j <= index;j++)
                    {
                        readObjectForClass(object, streamClassList.get(j));
                    } 
                    lastIndex = index + 1;
                } 
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.365 -0400", hash_original_method = "F09DF984FD463C1BCDA606260FD08FFE", hash_generated_method = "9D34DB9BCA2A62D3EF97B2E48532B3DB")
    private List<Class<?>> cacheSuperclassesFor(Class<?> c) {
        addTaint(c.getTaint());
        ArrayList<Class<?>> result = new ArrayList<Class<?>>();
        Class<?> nextClass = c;
        while
(nextClass != null)        
        {
            Class<?> testClass = nextClass.getSuperclass();
    if(testClass != null)            
            {
                result.add(0, nextClass);
            } 
            nextClass = testClass;
        } 
        cachedSuperclasses.put(c, result);
List<Class<?>> varDC838461EE2FA0CA4C9BBB70A15456B0_2078379459 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_2078379459.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_2078379459;
        
        
        
        
            
            
                
            
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.370 -0400", hash_original_method = "30EFDC31EF83C1843078545357CDA4A5", hash_generated_method = "CFC3FE02E3351588A7C6ED874780A0CE")
    private int findStreamSuperclass(Class<?> cl, List<ObjectStreamClass> classList, int lastIndex) {
        addTaint(lastIndex);
        addTaint(classList.getTaint());
        addTaint(cl.getTaint());
for(int i = lastIndex, end = classList.size();i < end;i++)
        {
            ObjectStreamClass objCl = classList.get(i);
            String forName = objCl.forClass().getName();
    if(objCl.getName().equals(forName))            
            {
    if(cl.getName().equals(objCl.getName()))                
                {
                    int var865C0C0B4AB0E063E5CAA3387C1A8741_2046936068 = (i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1657564248 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1657564248;
                } 
            } 
            else
            {
    if(cl.getName().equals(forName))                
                {
                    int var865C0C0B4AB0E063E5CAA3387C1A8741_1301525389 = (i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_948791884 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_948791884;
                } 
            } 
        } 
        int var6BB61E3B7BCE0931DA574D19D1D82C88_1527044594 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_806234401 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_806234401;
        
        
            
            
            
                
                    
                
            
                
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.374 -0400", hash_original_method = "868BCCA0967481794CFA1D8D3E56D3E6", hash_generated_method = "A051A4C4C1CC439ABFBAB4EB6EABB9B1")
    private void readObjectNoData(Object object, Class<?> cl, ObjectStreamClass classDesc) throws ObjectStreamException {
        addTaint(classDesc.getTaint());
        addTaint(cl.getTaint());
        addTaint(object.getTaint());
    if(!classDesc.isSerializable())        
        {
            return;
        } 
    if(classDesc.hasMethodReadObjectNoData())        
        {
            final Method readMethod = classDesc.getMethodReadObjectNoData();
            try 
            {
                readMethod.invoke(object);
            } 
            catch (InvocationTargetException e)
            {
                Throwable ex = e.getTargetException();
    if(ex instanceof RuntimeException)                
                {
                    RuntimeException varF0C2DBE52270DD4B45A7073A4B8A4F8C_1031342186 = (RuntimeException) ex;
                    varF0C2DBE52270DD4B45A7073A4B8A4F8C_1031342186.addTaint(taint);
                    throw varF0C2DBE52270DD4B45A7073A4B8A4F8C_1031342186;
                } 
                else
    if(ex instanceof Error)                
                {
                    Error var5088E1E74327DBB15F7148041BB4E6E0_766730621 = (Error) ex;
                    var5088E1E74327DBB15F7148041BB4E6E0_766730621.addTaint(taint);
                    throw var5088E1E74327DBB15F7148041BB4E6E0_766730621;
                } 
                ObjectStreamException varF05FB6CDAAC97D6EABE45A43B6059660_1006002097 = (ObjectStreamException) ex;
                varF05FB6CDAAC97D6EABE45A43B6059660_1006002097.addTaint(taint);
                throw varF05FB6CDAAC97D6EABE45A43B6059660_1006002097;
            } 
            catch (IllegalAccessException e)
            {
                RuntimeException var7731B7FAF9DB516E410EE38D728795B2_1653937618 = new RuntimeException(e.toString());
                var7731B7FAF9DB516E410EE38D728795B2_1653937618.addTaint(taint);
                throw var7731B7FAF9DB516E410EE38D728795B2_1653937618;
            } 
        } 
        
        
            
        
        
            
            
                
            
                
                
                    
                
                    
                
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.384 -0400", hash_original_method = "6119E962BBCC069017D862716C24BEC0", hash_generated_method = "3E0CC3E11957EA19E1FE6D9FA6C788BC")
    private void readObjectForClass(Object object, ObjectStreamClass classDesc) throws IOException, ClassNotFoundException, NotActiveException {
        currentObject = object;
        currentClass = classDesc;
        boolean hadWriteMethod = (classDesc.getFlags() & SC_WRITE_METHOD) != 0;
        Class<?> targetClass = classDesc.forClass();
        Method readMethod;
    if(targetClass == null || !mustResolve)        
        {
            readMethod = null;
        } 
        else
        {
            readMethod = classDesc.getMethodReadObject();
        } 
        try 
        {
    if(readMethod != null)            
            {
                readMethod.setAccessible(true);
                try 
                {
                    readMethod.invoke(object, this);
                } 
                catch (InvocationTargetException e)
                {
                    Throwable ex = e.getTargetException();
    if(ex instanceof ClassNotFoundException)                    
                    {
                        ClassNotFoundException var474CB282B0D1099512876AF1EC1931B2_262931031 = (ClassNotFoundException) ex;
                        var474CB282B0D1099512876AF1EC1931B2_262931031.addTaint(taint);
                        throw var474CB282B0D1099512876AF1EC1931B2_262931031;
                    } 
                    else
    if(ex instanceof RuntimeException)                    
                    {
                        RuntimeException varF0C2DBE52270DD4B45A7073A4B8A4F8C_640557982 = (RuntimeException) ex;
                        varF0C2DBE52270DD4B45A7073A4B8A4F8C_640557982.addTaint(taint);
                        throw varF0C2DBE52270DD4B45A7073A4B8A4F8C_640557982;
                    } 
                    else
    if(ex instanceof Error)                    
                    {
                        Error var5088E1E74327DBB15F7148041BB4E6E0_562910986 = (Error) ex;
                        var5088E1E74327DBB15F7148041BB4E6E0_562910986.addTaint(taint);
                        throw var5088E1E74327DBB15F7148041BB4E6E0_562910986;
                    } 
                    IOException var3F32687BA78654886C8AE6DEBD282711_1198018839 = (IOException) ex;
                    var3F32687BA78654886C8AE6DEBD282711_1198018839.addTaint(taint);
                    throw var3F32687BA78654886C8AE6DEBD282711_1198018839;
                } 
                catch (IllegalAccessException e)
                {
                    RuntimeException var7731B7FAF9DB516E410EE38D728795B2_150956235 = new RuntimeException(e.toString());
                    var7731B7FAF9DB516E410EE38D728795B2_150956235.addTaint(taint);
                    throw var7731B7FAF9DB516E410EE38D728795B2_150956235;
                } 
            } 
            else
            {
                defaultReadObject();
            } 
    if(hadWriteMethod)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.389 -0400", hash_original_method = "D31E8D2825D4043295F3D0C685B93717", hash_generated_method = "D4590C000BE1F52CB8EDA4B690872D01")
    public int readInt() throws IOException {
        int varB2A6B1B74BD03F0DD15140B729D58103_786786271 = (primitiveTypes.readInt());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_875303502 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_875303502;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.391 -0400", hash_original_method = "90EA71A98921C4D093F2F0BA4DDBE95D", hash_generated_method = "5B48FE6CFEEE75F7AC32D03589FE4156")
    @Deprecated
    public String readLine() throws IOException {
String varAB96D771FB7A20F126379CBD285B2198_493911637 =         primitiveTypes.readLine();
        varAB96D771FB7A20F126379CBD285B2198_493911637.addTaint(taint);
        return varAB96D771FB7A20F126379CBD285B2198_493911637;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.392 -0400", hash_original_method = "70C9FFE9F08A2EBCF32FC4C20D730AD7", hash_generated_method = "364CEBE7C27C0E16991BCEDC7811C917")
    public long readLong() throws IOException {
        long var717B0A39DD043419AB5C092C0E238E2A_746868560 = (primitiveTypes.readLong());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_653312992 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_653312992;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.467 -0400", hash_original_method = "6C628531F4475FFAEEB816E877548000", hash_generated_method = "FBE4571FF54D4964BB17601C98F5C390")
    private Object readNewArray(boolean unshared) throws OptionalDataException,
            ClassNotFoundException, IOException {
        addTaint(unshared);
        ObjectStreamClass classDesc = readClassDesc();
    if(classDesc == null)        
        {
            java.io.InvalidClassException varF0B669FE625FDCD2C0B7AFC2BF75622C_281866769 = missingClassDescriptor();
            varF0B669FE625FDCD2C0B7AFC2BF75622C_281866769.addTaint(taint);
            throw varF0B669FE625FDCD2C0B7AFC2BF75622C_281866769;
        } 
        int newHandle = nextHandle();
        int size = input.readInt();
        Class<?> arrayClass = classDesc.forClass();
        Class<?> componentType = arrayClass.getComponentType();
        Object result = Array.newInstance(componentType, size);
        registerObjectRead(result, newHandle, unshared);
    if(componentType.isPrimitive())        
        {
    if(componentType == int.class)            
            {
                int[] intArray = (int[]) result;
for(int i = 0;i < size;i++)
                {
                    intArray[i] = input.readInt();
                } 
            } 
            else
    if(componentType == byte.class)            
            {
                byte[] byteArray = (byte[]) result;
                input.readFully(byteArray, 0, size);
            } 
            else
    if(componentType == char.class)            
            {
                char[] charArray = (char[]) result;
for(int i = 0;i < size;i++)
                {
                    charArray[i] = input.readChar();
                } 
            } 
            else
    if(componentType == short.class)            
            {
                short[] shortArray = (short[]) result;
for(int i = 0;i < size;i++)
                {
                    shortArray[i] = input.readShort();
                } 
            } 
            else
    if(componentType == boolean.class)            
            {
                boolean[] booleanArray = (boolean[]) result;
for(int i = 0;i < size;i++)
                {
                    booleanArray[i] = input.readBoolean();
                } 
            } 
            else
    if(componentType == long.class)            
            {
                long[] longArray = (long[]) result;
for(int i = 0;i < size;i++)
                {
                    longArray[i] = input.readLong();
                } 
            } 
            else
    if(componentType == float.class)            
            {
                float[] floatArray = (float[]) result;
for(int i = 0;i < size;i++)
                {
                    floatArray[i] = input.readFloat();
                } 
            } 
            else
    if(componentType == double.class)            
            {
                double[] doubleArray = (double[]) result;
for(int i = 0;i < size;i++)
                {
                    doubleArray[i] = input.readDouble();
                } 
            } 
            else
            {
                ClassNotFoundException var2957F23825B6E9F97EDD184390727BF1_22304748 = new ClassNotFoundException("Wrong base type in " + classDesc.getName());
                var2957F23825B6E9F97EDD184390727BF1_22304748.addTaint(taint);
                throw var2957F23825B6E9F97EDD184390727BF1_22304748;
            } 
        } 
        else
        {
            Object[] objectArray = (Object[]) result;
for(int i = 0;i < size;i++)
            {
                objectArray[i] = readObject();
            } 
        } 
    if(enableResolve)        
        {
            result = resolveObject(result);
            registerObjectRead(result, newHandle, false);
        } 
Object varDC838461EE2FA0CA4C9BBB70A15456B0_1971706564 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1971706564.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1971706564;
        
        
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
        } 
        Class<?> localClass = classDesc.forClass();
    if(localClass != null)        
        {
            registerObjectRead(localClass, nextHandle(), unshared);
        } 
Class<?> var0C65C20E72071ADD9DC54213330F27FA_1943451547 =         localClass;
        var0C65C20E72071ADD9DC54213330F27FA_1943451547.addTaint(taint);
        return var0C65C20E72071ADD9DC54213330F27FA_1943451547;
        
        
        
            
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.522 -0400", hash_original_method = "D16FAEE9BB99888884BA2510B9D0161D", hash_generated_method = "A9B271153FD94D6224E55747AD4464C1")
    private ObjectStreamClass readEnumDesc() throws IOException,
            ClassNotFoundException {
        byte tc = nextTC();
switch(tc){
        case TC_CLASSDESC:
ObjectStreamClass varCB78B39216098386AB1BB2A6AB28781B_1140976290 =         readEnumDescInternal();
        varCB78B39216098386AB1BB2A6AB28781B_1140976290.addTaint(taint);
        return varCB78B39216098386AB1BB2A6AB28781B_1140976290;
        case TC_REFERENCE:
ObjectStreamClass var45BA89463163BB71DA22DB941DEC608E_1156415609 =         (ObjectStreamClass) readCyclicReference();
        var45BA89463163BB71DA22DB941DEC608E_1156415609.addTaint(taint);
        return var45BA89463163BB71DA22DB941DEC608E_1156415609;
        case TC_NULL:
ObjectStreamClass var540C13E9E156B687226421B24F2DF178_1585832258 =         null;
        var540C13E9E156B687226421B24F2DF178_1585832258.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1585832258;
        default:
        java.io.StreamCorruptedException varA1F85B50BF8446E6D14D510BCDD729EB_808957013 = corruptStream(tc);
        varA1F85B50BF8446E6D14D510BCDD729EB_808957013.addTaint(taint);
        throw varA1F85B50BF8446E6D14D510BCDD729EB_808957013;
}
        
        
        
            
                
            
                
            
                
            
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.528 -0400", hash_original_method = "58EE21B582EE01373F973D50B42B8A60", hash_generated_method = "6C489D95C2DE534C9609501224200ECF")
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
        discardData();
        ObjectStreamClass superClass = readClassDesc();
        checkedSetSuperClassDesc(classDesc, superClass);
    if(0L != classDesc.getSerialVersionUID() || 0L != superClass.getSerialVersionUID())        
        {
            InvalidClassException varD7E851C67BA27BF8BF633C6ABC13EF43_714955555 = new InvalidClassException(superClass.getName(),
                    "Incompatible class (SUID): " + superClass + " but expected " + superClass);
            varD7E851C67BA27BF8BF633C6ABC13EF43_714955555.addTaint(taint);
            throw varD7E851C67BA27BF8BF633C6ABC13EF43_714955555;
        } 
        byte tc = nextTC();
    if(tc == TC_ENDBLOCKDATA)        
        {
            superClass.setSuperclass(readClassDesc());
        } 
        else
        {
            pushbackTC();
        } 
ObjectStreamClass var3497C6F192F17384DEAA3543897C005A_1377500344 =         classDesc;
        var3497C6F192F17384DEAA3543897C005A_1377500344.addTaint(taint);
        return var3497C6F192F17384DEAA3543897C005A_1377500344;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.563 -0400", hash_original_method = "0BB1D7ADA0D4FC987B96FE9D538B84F1", hash_generated_method = "99918EF6E862BF1DCFC6C9F043F48966")
    @SuppressWarnings("unchecked")
    private Object readEnum(boolean unshared) throws OptionalDataException,
            ClassNotFoundException, IOException {
        addTaint(unshared);
        ObjectStreamClass classDesc = readEnumDesc();
        int newHandle = nextHandle();
        String name;
        byte tc = nextTC();
switch(tc){
        case TC_REFERENCE:
    if(unshared)        
        {
            readNewHandle();
            InvalidObjectException varB03B1E7AB6C2FC12286EAFC18E1E860F_437281712 = new InvalidObjectException("Unshared read of back reference");
            varB03B1E7AB6C2FC12286EAFC18E1E860F_437281712.addTaint(taint);
            throw varB03B1E7AB6C2FC12286EAFC18E1E860F_437281712;
        } 
        name = (String) readCyclicReference();
        break;
        case TC_STRING:
        name = (String) readNewString(unshared);
        break;
        default:
        java.io.StreamCorruptedException varA1F85B50BF8446E6D14D510BCDD729EB_451356912 = corruptStream(tc);
        varA1F85B50BF8446E6D14D510BCDD729EB_451356912.addTaint(taint);
        throw varA1F85B50BF8446E6D14D510BCDD729EB_451356912;
}        Enum<?> result = Enum.valueOf((Class) classDesc.forClass(), name);
        registerObjectRead(result, newHandle, unshared);
Object varDC838461EE2FA0CA4C9BBB70A15456B0_614979210 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_614979210.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_614979210;
        
        
        
        
        
        
            
                
                    
                    
                
                
                
            
                
                
            
                
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.567 -0400", hash_original_method = "85A17F1C0F9F03F0EE48936822125550", hash_generated_method = "69E0648E502AA2C68C2CCE99442603F0")
    private ObjectStreamClass readNewClassDesc(boolean unshared) throws ClassNotFoundException, IOException {
        addTaint(unshared);
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
    if(mustResolve)            
            {
                e.addTaint(taint);
                throw e;
            } 
        } 
        ObjectStreamField[] fields = newClassDesc.getLoadFields();
        fields = (fields == null) ? ObjectStreamClass.NO_FIELDS : fields;
        ClassLoader loader = newClassDesc.forClass() == null ? callerClassLoader
                : newClassDesc.forClass().getClassLoader();
for(ObjectStreamField element : fields)
        {
            element.resolve(loader);
        } 
        discardData();
        checkedSetSuperClassDesc(newClassDesc, readClassDesc());
ObjectStreamClass var9298ABC4754D010280EDCD1628E45333_1469953491 =         newClassDesc;
        var9298ABC4754D010280EDCD1628E45333_1469953491.addTaint(taint);
        return var9298ABC4754D010280EDCD1628E45333_1469953491;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.571 -0400", hash_original_method = "9592596F093477979EA31311F339CD7D", hash_generated_method = "0B1927ECDBD1ACD7AA36FB9C0657E69D")
    private Class<?> readNewProxyClassDesc() throws ClassNotFoundException,
            IOException {
        int count = input.readInt();
        String[] interfaceNames = new String[count];
for(int i = 0;i < count;i++)
        {
            interfaceNames[i] = input.readUTF();
        } 
        Class<?> proxy = resolveProxyClass(interfaceNames);
        discardData();
Class<?> var60FC9F22F7E863EBFD33B2ADB8462743_170030233 =         proxy;
        var60FC9F22F7E863EBFD33B2ADB8462743_170030233.addTaint(taint);
        return var60FC9F22F7E863EBFD33B2ADB8462743_170030233;
        
        
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.574 -0400", hash_original_method = "97948A412F94E7F820143192C44DB303", hash_generated_method = "5D59452F757D567F0C15573B797D652E")
    protected ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
        ObjectStreamClass newClassDesc = new ObjectStreamClass();
        String name = input.readUTF();
    if(name.length() == 0)        
        {
            IOException var7AF2F174A0D0CD24060446F4A5468977_145550178 = new IOException("The stream is corrupted");
            var7AF2F174A0D0CD24060446F4A5468977_145550178.addTaint(taint);
            throw var7AF2F174A0D0CD24060446F4A5468977_145550178;
        } 
        newClassDesc.setName(name);
        newClassDesc.setSerialVersionUID(input.readLong());
        newClassDesc.setFlags(input.readByte());
    if(descriptorHandle == -1)        
        {
            descriptorHandle = nextHandle();
        } 
        registerObjectRead(newClassDesc, descriptorHandle, false);
        readFieldDescriptors(newClassDesc);
ObjectStreamClass var9298ABC4754D010280EDCD1628E45333_1635727730 =         newClassDesc;
        var9298ABC4754D010280EDCD1628E45333_1635727730.addTaint(taint);
        return var9298ABC4754D010280EDCD1628E45333_1635727730;
        
        
        
        
            
        
        
        
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.578 -0400", hash_original_method = "C938C68924527CB04F806429B3BE928F", hash_generated_method = "530504568EB4654E18272DCEE552CE22")
    protected Class<?> resolveProxyClass(String[] interfaceNames) throws IOException, ClassNotFoundException {
        addTaint(interfaceNames[0].getTaint());
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class<?>[] interfaces = new Class<?>[interfaceNames.length];
for(int i = 0;i < interfaceNames.length;i++)
        {
            interfaces[i] = Class.forName(interfaceNames[i], false, loader);
        } 
        try 
        {
Class<?> var1585BFE2B902F61A3216AC5F3A95D704_170736041 =             Proxy.getProxyClass(loader, interfaces);
            var1585BFE2B902F61A3216AC5F3A95D704_170736041.addTaint(taint);
            return var1585BFE2B902F61A3216AC5F3A95D704_170736041;
        } 
        catch (IllegalArgumentException e)
        {
            ClassNotFoundException var2D2F079A9C09E5E985932CCAFE8C1A20_326399434 = new ClassNotFoundException(e.toString(), e);
            var2D2F079A9C09E5E985932CCAFE8C1A20_326399434.addTaint(taint);
            throw var2D2F079A9C09E5E985932CCAFE8C1A20_326399434;
        } 
        
        
        
        
            
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.583 -0400", hash_original_method = "11D3D467DA55FCE7098C1D9AB901525D", hash_generated_method = "B8F8571644FA509F85F8A03AE85F91A9")
    private int readNewHandle() throws IOException {
        int var45B24B25F8387CAC67C3944D89F2BC52_491516509 = (input.readInt());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2029939649 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2029939649;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.658 -0400", hash_original_method = "B0A36455F033DD06E1C6357D1966CB2A", hash_generated_method = "629C0BE4B63F55A17975BC0794D6CE69")
    private Object readNewObject(boolean unshared) throws OptionalDataException, ClassNotFoundException, IOException {
        addTaint(unshared);
        ObjectStreamClass classDesc = readClassDesc();
    if(classDesc == null)        
        {
            java.io.InvalidClassException varF0B669FE625FDCD2C0B7AFC2BF75622C_1776064398 = missingClassDescriptor();
            varF0B669FE625FDCD2C0B7AFC2BF75622C_1776064398.addTaint(taint);
            throw varF0B669FE625FDCD2C0B7AFC2BF75622C_1776064398;
        } 
        int newHandle = nextHandle();
        Class<?> objectClass = classDesc.forClass();
        Object result = null;
        Object registeredResult = null;
    if(objectClass != null)        
        {
            result = classDesc.newInstance(objectClass);
            registerObjectRead(result, newHandle, unshared);
            registeredResult = result;
        } 
        else
        {
            result = null;
        } 
        try 
        {
            currentObject = result;
            currentClass = classDesc;
            boolean wasExternalizable = (classDesc.getFlags() & SC_EXTERNALIZABLE) != 0;
    if(wasExternalizable)            
            {
                boolean blockData = (classDesc.getFlags() & SC_BLOCK_DATA) != 0;
    if(!blockData)                
                {
                    primitiveData = input;
                } 
    if(mustResolve)                
                {
                    Externalizable extern = (Externalizable) result;
                    extern.readExternal(this);
                } 
    if(blockData)                
                {
                    discardData();
                } 
                else
                {
                    primitiveData = emptyStream;
                } 
            } 
            else
            {
                readHierarchy(result, classDesc);
            } 
        } 
        finally 
        {
            currentObject = null;
            currentClass = null;
        } 
    if(objectClass != null)        
        {
    if(classDesc.hasMethodReadResolve())            
            {
                Method methodReadResolve = classDesc.getMethodReadResolve();
                try 
                {
                    result = methodReadResolve.invoke(result, (Object[]) null);
                } 
                catch (IllegalAccessException ignored)
                {
                } 
                catch (InvocationTargetException ite)
                {
                    Throwable target = ite.getTargetException();
    if(target instanceof ObjectStreamException)                    
                    {
                        ObjectStreamException var7968BE7E0F10658162994A62439F18E4_1603558968 = (ObjectStreamException) target;
                        var7968BE7E0F10658162994A62439F18E4_1603558968.addTaint(taint);
                        throw var7968BE7E0F10658162994A62439F18E4_1603558968;
                    } 
                    else
    if(target instanceof Error)                    
                    {
                        Error var157858306DB5AEA134A18315E8F156FF_324977222 = (Error) target;
                        var157858306DB5AEA134A18315E8F156FF_324977222.addTaint(taint);
                        throw var157858306DB5AEA134A18315E8F156FF_324977222;
                    } 
                    else
                    {
                        RuntimeException varB680FC198DAE9443D5ED144016D19687_63925393 = (RuntimeException) target;
                        varB680FC198DAE9443D5ED144016D19687_63925393.addTaint(taint);
                        throw varB680FC198DAE9443D5ED144016D19687_63925393;
                    } 
                } 
            } 
        } 
    if(result != null && enableResolve)        
        {
            result = resolveObject(result);
        } 
    if(registeredResult != result)        
        {
            registerObjectRead(result, newHandle, unshared);
        } 
Object varDC838461EE2FA0CA4C9BBB70A15456B0_1605449150 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1605449150.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1605449150;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.660 -0400", hash_original_method = "C5243F456C3574095BC1BB7FC2411373", hash_generated_method = "7FC9790A9394E01AC754D5CEAC906B2C")
    private InvalidClassException missingClassDescriptor() throws InvalidClassException {
        InvalidClassException var16AEF1A56FF02F021CBAE9B5E423406F_237992908 = new InvalidClassException("Read null attempting to read class descriptor for object");
        var16AEF1A56FF02F021CBAE9B5E423406F_237992908.addTaint(taint);
        throw var16AEF1A56FF02F021CBAE9B5E423406F_237992908;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.660 -0400", hash_original_method = "CF984AE9FCCB80A5CA5459E50D42D99D", hash_generated_method = "677EFBCE1986D310326471DC2F28201E")
    private Object readNewString(boolean unshared) throws IOException {
        addTaint(unshared);
        Object result = input.readUTF();
    if(enableResolve)        
        {
            result = resolveObject(result);
        } 
        registerObjectRead(result, nextHandle(), unshared);
Object varDC838461EE2FA0CA4C9BBB70A15456B0_1598160950 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1598160950.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1598160950;
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.661 -0400", hash_original_method = "E3603577D9590FDF3626C23DB61D460D", hash_generated_method = "E83F804BEB0BC02AD977AD6A487360B9")
    private Object readNewLongString(boolean unshared) throws IOException {
        addTaint(unshared);
        long length = input.readLong();
        Object result = input.decodeUTF((int) length);
    if(enableResolve)        
        {
            result = resolveObject(result);
        } 
        registerObjectRead(result, nextHandle(), unshared);
Object varDC838461EE2FA0CA4C9BBB70A15456B0_1285582647 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1285582647.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1285582647;
        
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.662 -0400", hash_original_method = "D5CBFBA6D0DD1CCB325BD55A2992CB88", hash_generated_method = "87DEFB869D345D489EB423CF46B446C4")
    public final Object readObject() throws OptionalDataException,
            ClassNotFoundException, IOException {
Object varDE3D5D991D2299B852D7A4547F832BEB_1160337992 =         readObject(false);
        varDE3D5D991D2299B852D7A4547F832BEB_1160337992.addTaint(taint);
        return varDE3D5D991D2299B852D7A4547F832BEB_1160337992;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.663 -0400", hash_original_method = "B5062D634E2B9403462F68486501694A", hash_generated_method = "D2937CBA6843E1D36593CC83D99AD62C")
    public Object readUnshared() throws IOException, ClassNotFoundException {
Object var3EEAD4513E01D30FA2721A4D9868715E_51013203 =         readObject(true);
        var3EEAD4513E01D30FA2721A4D9868715E_51013203.addTaint(taint);
        return var3EEAD4513E01D30FA2721A4D9868715E_51013203;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.665 -0400", hash_original_method = "E655B580AAC2F65ED2F044289942F1C0", hash_generated_method = "119B4E7DA647011501A23DA0036708DE")
    private Object readObject(boolean unshared) throws OptionalDataException,
            ClassNotFoundException, IOException {
        addTaint(unshared);
        boolean restoreInput = (primitiveData == input);
    if(restoreInput)        
        {
            primitiveData = emptyStream;
        } 
    if(subclassOverridingImplementation && !unshared)        
        {
Object varC632220F2A11923B21DDE438738503BF_1633249301 =             readObjectOverride();
            varC632220F2A11923B21DDE438738503BF_1633249301.addTaint(taint);
            return varC632220F2A11923B21DDE438738503BF_1633249301;
        } 
        Object result;
        try 
        {
    if(++nestedLevels == 1)            
            {
                callerClassLoader = getClosestUserClassLoader();
            } 
            result = readNonPrimitiveContent(unshared);
    if(restoreInput)            
            {
                primitiveData = input;
            } 
        } 
        finally 
        {
    if(--nestedLevels == 0)            
            {
                callerClassLoader = null;
            } 
        } 
    if(nestedLevels == 0 && validations != null)        
        {
            try 
            {
for(InputValidationDesc element : validations)
                {
                    element.validator.validateObject();
                } 
            } 
            finally 
            {
                validations = null;
            } 
        } 
Object varDC838461EE2FA0CA4C9BBB70A15456B0_993904 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_993904.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_993904;
        
        
    }

    
        @DSModeled(DSC.BAN)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.667 -0400", hash_original_method = "F453836DFC9EEC175FFF65A0C41AF32F", hash_generated_method = "A5F1E5196103AA24AE0475D9F2FAE21E")
    protected Object readObjectOverride() throws OptionalDataException,
            ClassNotFoundException, IOException {
    if(input == null)        
        {
Object var540C13E9E156B687226421B24F2DF178_1720163364 =             null;
            var540C13E9E156B687226421B24F2DF178_1720163364.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1720163364;
        } 
        IOException var1508E3FDF27FD56D4E1051DB16DE1816_1845282129 = new IOException();
        var1508E3FDF27FD56D4E1051DB16DE1816_1845282129.addTaint(taint);
        throw var1508E3FDF27FD56D4E1051DB16DE1816_1845282129;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.669 -0400", hash_original_method = "E1F1666A9CC2BCC43C42662EA935D779", hash_generated_method = "6C3BB2281B64A098A3BE622CCC1C208E")
    public short readShort() throws IOException {
        short varD72B35297BEA6797ABBE906C16AED5CF_911417936 = (primitiveTypes.readShort());
                short var4F09DAA9D95BCB166A302407A0E0BABE_1313241388 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1313241388;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.670 -0400", hash_original_method = "2E049C52CD4079E3EDC13878B612AD59", hash_generated_method = "90B2129EA1611EDC7A0F0B2222EAB174")
    protected void readStreamHeader() throws IOException,
            StreamCorruptedException {
    if(input.readShort() == STREAM_MAGIC
                && input.readShort() == STREAM_VERSION)        
        {
            return;
        } 
        StreamCorruptedException varF5F96E25EF189AC41EAEE81D0E0B6F98_436315210 = new StreamCorruptedException();
        varF5F96E25EF189AC41EAEE81D0E0B6F98_436315210.addTaint(taint);
        throw varF5F96E25EF189AC41EAEE81D0E0B6F98_436315210;
        
        
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.671 -0400", hash_original_method = "50996F70792020DA658FB7FFCF1EF910", hash_generated_method = "E586258BF08C29B122EDDA29120F5D68")
    public int readUnsignedByte() throws IOException {
        int varE8E02E272FCA8E719DC246906D578BBA_1387198514 = (primitiveTypes.readUnsignedByte());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2071136877 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2071136877;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.673 -0400", hash_original_method = "ABA376385639B6CB8F725C68F1CED979", hash_generated_method = "DD7823C505FD94A82A9EA000F7103068")
    public int readUnsignedShort() throws IOException {
        int varC84B1E38C1B4325F10B497EE61484BA2_1665646222 = (primitiveTypes.readUnsignedShort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_248693408 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_248693408;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.675 -0400", hash_original_method = "B2994D3A3B821949D517613320FA5065", hash_generated_method = "D8AE35E5E3CDB9B8D19E2EE0431340AB")
    public String readUTF() throws IOException {
String var515CD0E98173FF2E73E38B6282E10FCE_276373847 =         primitiveTypes.readUTF();
        var515CD0E98173FF2E73E38B6282E10FCE_276373847.addTaint(taint);
        return var515CD0E98173FF2E73E38B6282E10FCE_276373847;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.682 -0400", hash_original_method = "10F65D1907C5AA72A1571FB08139A1C8", hash_generated_method = "80B38C6FFC627DD70884901AF081AFAB")
    private Object registeredObjectRead(int handle) throws InvalidObjectException {
        addTaint(handle);
        Object res = objectsRead.get(handle - ObjectStreamConstants.baseWireHandle);
    if(res == UNSHARED_OBJ)        
        {
            InvalidObjectException var13587A8E5C284E5D92F27437313A6A97_120372134 = new InvalidObjectException("Cannot read back reference to unshared object");
            var13587A8E5C284E5D92F27437313A6A97_120372134.addTaint(taint);
            throw var13587A8E5C284E5D92F27437313A6A97_120372134;
        } 
Object varB5053E025797B3BF768F5C37934C244D_1460660275 =         res;
        varB5053E025797B3BF768F5C37934C244D_1460660275.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_1460660275;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.683 -0400", hash_original_method = "9C8641A932863D3A6F3FA22233749F54", hash_generated_method = "4AF7A2152D423A8D8591669DAB8316B2")
    private void registerObjectRead(Object obj, int handle, boolean unshared) throws IOException {
        addTaint(unshared);
        addTaint(handle);
        addTaint(obj.getTaint());
    if(unshared)        
        {
            obj = UNSHARED_OBJ;
        } 
        int index = handle - ObjectStreamConstants.baseWireHandle;
        int size = objectsRead.size();
        while
(index > size)        
        {
            objectsRead.add(null);
            ++size;
        } 
    if(index == size)        
        {
            objectsRead.add(obj);
        } 
        else
        {
            objectsRead.set(index, obj);
        } 
        
        
            
        
        
        
        
            
            
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.686 -0400", hash_original_method = "3EFB39BBE791BF6ED902F9D8BC5F60E3", hash_generated_method = "FD9F0C113B1F48C9A3AEA7A4138ACDF1")
    public synchronized void registerValidation(ObjectInputValidation object,
            int priority) throws NotActiveException, InvalidObjectException {
        
        addTaint(priority);
        addTaint(object.getTaint());
        Object instanceBeingRead = this.currentObject;
    if(instanceBeingRead == null && nestedLevels == 0)        
        {
            NotActiveException varFD1AAF3605EC866A6A8BBEC842DA8C8A_1943585977 = new NotActiveException();
            varFD1AAF3605EC866A6A8BBEC842DA8C8A_1943585977.addTaint(taint);
            throw varFD1AAF3605EC866A6A8BBEC842DA8C8A_1943585977;
        } 
    if(object == null)        
        {
            InvalidObjectException var62544DC45AC18E0A4AD21936CBBDE9CA_644016707 = new InvalidObjectException("Callback object cannot be null");
            var62544DC45AC18E0A4AD21936CBBDE9CA_644016707.addTaint(taint);
            throw var62544DC45AC18E0A4AD21936CBBDE9CA_644016707;
        } 
        InputValidationDesc desc = new InputValidationDesc();
        desc.validator = object;
        desc.priority = priority;
    if(validations == null)        
        {
            validations = new InputValidationDesc[1];
            validations[0] = desc;
        } 
        else
        {
            int i = 0;
for(;i < validations.length;i++)
            {
                InputValidationDesc validation = validations[i];
    if(priority >= validation.priority)                
                {
                    break;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.689 -0400", hash_original_method = "7A01BA94C22B82138AACA44C7BC92DD9", hash_generated_method = "0C73C6216D604266ED6256169E691209")
    private void resetSeenObjects() {
        objectsRead = new ArrayList<Object>();
        nextHandle = baseWireHandle;
        primitiveData = emptyStream;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.690 -0400", hash_original_method = "356E50ACB0709EF4643021948AB5F291", hash_generated_method = "EC3D0E77128D57B1D4D0ED283DC54BAE")
    private void resetState() {
        resetSeenObjects();
        hasPushbackTC = false;
        pushbackTC = 0;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.692 -0400", hash_original_method = "38B51F7C504D6211D87B81513F39C956", hash_generated_method = "36C9A41736E3443AC895546127246AE2")
    protected Class<?> resolveClass(ObjectStreamClass osClass) throws IOException, ClassNotFoundException {
        addTaint(osClass.getTaint());
        Class<?> cls = osClass.forClass();
    if(cls == null)        
        {
            String className = osClass.getName();
            cls = PRIMITIVE_CLASSES.get(className);
    if(cls == null)            
            {
                cls = Class.forName(className, true, callerClassLoader);
            } 
        } 
Class<?> var51801364268DFB5B1361AB761C7278F7_1266242235 =         cls;
        var51801364268DFB5B1361AB761C7278F7_1266242235.addTaint(taint);
        return var51801364268DFB5B1361AB761C7278F7_1266242235;
        
        
        
            
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.693 -0400", hash_original_method = "8BE1D9D2C1A8227AC3DEAA12C63F6442", hash_generated_method = "E2DCBACF2FF8DD3F8B28365E4304CBE5")
    protected Object resolveObject(Object object) throws IOException {
        addTaint(object.getTaint());
Object var6F3B27511D98F0E852A24482F031265F_1605954093 =         object;
        var6F3B27511D98F0E852A24482F031265F_1605954093.addTaint(taint);
        return var6F3B27511D98F0E852A24482F031265F_1605954093;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.694 -0400", hash_original_method = "C18A3B861F9E4DC00DB6D8F86113E96E", hash_generated_method = "CC48409333FC3956E753F32EA2F92C85")
    public int skipBytes(int length) throws IOException {
        addTaint(length);
    if(input == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1290241081 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1290241081.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1290241081;
        } 
        int offset = 0;
        while
(offset < length)        
        {
            checkReadPrimitiveTypes();
            long skipped = primitiveData.skip(length - offset);
    if(skipped == 0)            
            {
                int var7A86C157EE9713C34FBD7A1EE40F0C5A_1108169386 = (offset);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1931020028 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1931020028;
            } 
            offset += (int) skipped;
        } 
        int var2FA47F7C65FEC19CC163B195725E3844_186938342 = (length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_334003363 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_334003363;
        
        
            
        
        
        
            
            
            
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.696 -0400", hash_original_method = "F18AA842F3AF8655FE4F963E8A31A757", hash_generated_method = "B06C332FAA8C48155D45B17BCB8853E8")
    private void verifyAndInit(ObjectStreamClass loadedStreamClass) throws InvalidClassException {
        addTaint(loadedStreamClass.getTaint());
        Class<?> localClass = loadedStreamClass.forClass();
        ObjectStreamClass localStreamClass = ObjectStreamClass
                .lookupStreamClass(localClass);
    if(loadedStreamClass.getSerialVersionUID() != localStreamClass
                .getSerialVersionUID())        
        {
            InvalidClassException var0EDFE5275719243EF3AEA6E8E1A53E31_46725115 = new InvalidClassException(loadedStreamClass.getName(),
                    "Incompatible class (SUID): " + loadedStreamClass +
                            " but expected " + localStreamClass);
            var0EDFE5275719243EF3AEA6E8E1A53E31_46725115.addTaint(taint);
            throw var0EDFE5275719243EF3AEA6E8E1A53E31_46725115;
        } 
        String loadedClassBaseName = getBaseName(loadedStreamClass.getName());
        String localClassBaseName = getBaseName(localStreamClass.getName());
    if(!loadedClassBaseName.equals(localClassBaseName))        
        {
            InvalidClassException var88E1F7CF7D103E08A757AC94DAB05723_2102555451 = new InvalidClassException(loadedStreamClass.getName(),
                    String.format("Incompatible class (base name): %s but expected %s",
                            loadedClassBaseName, localClassBaseName));
            var88E1F7CF7D103E08A757AC94DAB05723_2102555451.addTaint(taint);
            throw var88E1F7CF7D103E08A757AC94DAB05723_2102555451;
        } 
        loadedStreamClass.initPrivateFields(localStreamClass);
        
        
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.699 -0400", hash_original_field = "8D6C391E7CB39133C91B73281A24F21F", hash_generated_field = "59BAC1D70D65173C0176BF76148E5AB7")

        ObjectInputValidation validator;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.700 -0400", hash_original_field = "B988295C268025B49DFB3DF26171DDC3", hash_generated_field = "4AD9F2E37B35E313CD211FBAFDADA238")

        int priority;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.700 -0400", hash_original_method = "9B1F2C1B15D11C4CFF789483FB2B6658", hash_generated_method = "9B1F2C1B15D11C4CFF789483FB2B6658")
        public InputValidationDesc ()
        {
            
        }


    }


    
    public abstract static class GetField {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.701 -0400", hash_original_method = "3E66EA4913058A142DD3D4DCDDDF2758", hash_generated_method = "3E66EA4913058A142DD3D4DCDDDF2758")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.711 -0400", hash_original_field = "84E5CE7FC519663BA115DBD4D0C5A535", hash_generated_field = "AB31E5C2BA954217EF88CD850CFC8C65")

    private static final Object UNSHARED_OBJ = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.712 -0400", hash_original_field = "42768E4035EB7085BBD39A4E45389BDC", hash_generated_field = "CF28BF30867E0E1F6DF3B872782F2ED3")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.713 -0400", hash_original_field = "E29C7DCEE0BF15C29DD3EA56FC9F2AF1", hash_generated_field = "0BEDBBB2B96D03A03BECE92D911B88AD")

    private static final ClassLoader bootstrapLoader = Object.class.getClassLoader();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:41.714 -0400", hash_original_field = "89EBE3ECF326D242BB3DB8E1D4A3021B", hash_generated_field = "F543C6A7F69C1743531D486F7F24DDAE")

    private static final ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
}

