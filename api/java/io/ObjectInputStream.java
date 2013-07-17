package java.io;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.281 -0400", hash_original_field = "559F34BD1B83DCCF42BD97118C30004D", hash_generated_field = "9C428AEC470C7B513A34BE33B758C61C")

    private InputStream emptyStream = new ByteArrayInputStream(EmptyArray.BYTE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.281 -0400", hash_original_field = "5A8A6215AD70C3096643367A265101CD", hash_generated_field = "C282E9AAC2D48EC47E345831218585FA")

    private boolean hasPushbackTC;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.281 -0400", hash_original_field = "E07029C787F995347976B5426FA51D79", hash_generated_field = "64B94603DBAD0B26BD5AE2F7439ED35E")

    private byte pushbackTC;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.281 -0400", hash_original_field = "993B80B15181215612E5959DB832BFAF", hash_generated_field = "123C8BF62BBC79B951F58B358976C3FF")

    private int nestedLevels;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.281 -0400", hash_original_field = "CB52CB1EDBEC59BDE75BA590938374FC", hash_generated_field = "FBF49E90A1B9879AE660F9886E842C8C")

    private int nextHandle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.281 -0400", hash_original_field = "A43C1B0AA53A0C908810C06AB1FF3967", hash_generated_field = "32FD79F94203B3CB4FB10D6979B3AE55")

    private DataInputStream input;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.281 -0400", hash_original_field = "8AFA05430C7155E00832EE4E25A1E3C4", hash_generated_field = "76093EED1B475C4F1E4C622B52BC7AC9")

    private DataInputStream primitiveTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.282 -0400", hash_original_field = "6AA631A1CF88716882035C982A3A5C5A", hash_generated_field = "28C1B2E39A3350A755888FD0A4428279")

    private InputStream primitiveData = emptyStream;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.282 -0400", hash_original_field = "814324F3D01F90BE0344B032BCDAEB46", hash_generated_field = "3240649A9311294AE1E098CB8F2A005F")

    private boolean enableResolve;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.282 -0400", hash_original_field = "324CFF805C6D6B99EE7C6FE654D64D06", hash_generated_field = "F79B8A3B52A523F03D688BC47873D2F6")

    private ArrayList<Object> objectsRead;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.282 -0400", hash_original_field = "895D2E18F5D2EA8F00F48DF2FB178E4D", hash_generated_field = "76736C274255A46E2AEB2CE593A1B428")

    private Object currentObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.282 -0400", hash_original_field = "457C5912366BE090D6A2931DE14CDA9E", hash_generated_field = "7035F4B44BC3AE389D42445F7A5655AC")

    private ObjectStreamClass currentClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.282 -0400", hash_original_field = "A81AAA0781C265056D03A0138CF839B3", hash_generated_field = "4E53F0CFC72A51A3B3CAAC6447A9F3B4")

    private InputValidationDesc[] validations;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.282 -0400", hash_original_field = "35C5D5BAEC9DA39A210149CA5A667705", hash_generated_field = "3690401F10D38FF2C8AB1C19B641B107")

    private boolean subclassOverridingImplementation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.282 -0400", hash_original_field = "0630628FEFA32E6BCF95C8130059DD84", hash_generated_field = "7E360A145DF451DC0144E812BE96A034")

    private ClassLoader callerClassLoader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.282 -0400", hash_original_field = "AFDD2451F1D1759C785DD591BC1506D8", hash_generated_field = "2DA36CFD381BE4CC041D9D9E401B490D")

    private boolean mustResolve = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.282 -0400", hash_original_field = "3A717ED2456CACB3BC0F8AE8881EF3AA", hash_generated_field = "2B0CB3B967646FBC95A533438216C0DF")

    private int descriptorHandle = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.282 -0400", hash_original_field = "C1487B64EE4D02CA5ED52EFDAA9A2E96", hash_generated_field = "FAF1B21A627FAB868C99C514185244A6")

    private HashMap<Class<?>, List<Class<?>>> cachedSuperclasses = new HashMap<Class<?>, List<Class<?>>>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.282 -0400", hash_original_method = "124623F0922D5D71F912D224AEC5FA85", hash_generated_method = "ACAF350C98F97636B8BC13996275E1E2")
    protected  ObjectInputStream() throws IOException {
        this.subclassOverridingImplementation = true;
        // ---------- Original Method ----------
        //this.subclassOverridingImplementation = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.283 -0400", hash_original_method = "15BB4AD74FE576D95ABFC0E40CC8A986", hash_generated_method = "703A8C3897973881276857A3F1438BAC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.284 -0400", hash_original_method = "CEC952E1AEB3FC5761C4573EC7C87AAE", hash_generated_method = "3D007A236F7D43756C8203C9536655D6")
    @Override
    public int available() throws IOException {
        checkReadPrimitiveTypes();
        int var41A4F3BC0C0791EEB464592BA2FDF983_731215324 = (primitiveData.available());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1977062864 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1977062864;
        // ---------- Original Method ----------
        //checkReadPrimitiveTypes();
        //return primitiveData.available();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.284 -0400", hash_original_method = "5DD662298FB99DC11E3F5A1BB4812CC0", hash_generated_method = "B113C7EEBC64D7680294029D58A2F8E6")
    private void checkReadPrimitiveTypes() throws IOException {
        if(primitiveData == input || primitiveData.available() > 0)        
        {
            return;
        } //End block
        do {
            {
                int next = 0;
                if(hasPushbackTC)                
                {
                    hasPushbackTC = false;
                } //End block
                else
                {
                    next = input.read();
                    pushbackTC = (byte) next;
                } //End block
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
                } //End block
                return;
}
            } //End block
} while (true);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.285 -0400", hash_original_method = "4ECD43BBA7F31E748521530C375A35B5", hash_generated_method = "EBCAB811F86091C4F8C851B059031D05")
    @Override
    public void close() throws IOException {
        input.close();
        // ---------- Original Method ----------
        //input.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.285 -0400", hash_original_method = "6463B95302326251A8E319007FB9B6A5", hash_generated_method = "6A51DA8BB8A9CB9ECA24CB4C9A44D706")
    public void defaultReadObject() throws IOException, ClassNotFoundException,
            NotActiveException {
        if(currentObject != null || !mustResolve)        
        {
            readFieldValues(currentObject, currentClass);
        } //End block
        else
        {
            NotActiveException varFD1AAF3605EC866A6A8BBEC842DA8C8A_1655241483 = new NotActiveException();
            varFD1AAF3605EC866A6A8BBEC842DA8C8A_1655241483.addTaint(taint);
            throw varFD1AAF3605EC866A6A8BBEC842DA8C8A_1655241483;
        } //End block
        // ---------- Original Method ----------
        //if (currentObject != null || !mustResolve) {
            //readFieldValues(currentObject, currentClass);
        //} else {
            //throw new NotActiveException();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.286 -0400", hash_original_method = "970A975ADDA1CD42A4A6880D40629922", hash_generated_method = "62BF9D07D9BB89FB61F1951FECC84BE8")
    protected boolean enableResolveObject(boolean enable) {
        boolean originalValue = enableResolve;
        enableResolve = enable;
        boolean var48A7AAFD2093A2CFD7C2A6E0C39C3B3C_1554318908 = (originalValue);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_498779655 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_498779655;
        // ---------- Original Method ----------
        //boolean originalValue = enableResolve;
        //enableResolve = enable;
        //return originalValue;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.286 -0400", hash_original_method = "BEEE4D4B01DB5401D5A386ECF8653C53", hash_generated_method = "5664ADB589C4D84A26404032CBC22D3F")
    private int nextHandle() {
        int varFF113B7ACD957FCEBD61C4FF9210CB16_466645156 = (nextHandle++);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_502382268 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_502382268;
        // ---------- Original Method ----------
        //return nextHandle++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.287 -0400", hash_original_method = "EA84EB3C5ACC30FA1515ABE6938E6E9B", hash_generated_method = "1028F9E5A7F9819068BBB5D9EAB8C291")
    private byte nextTC() throws IOException {
        if(hasPushbackTC)        
        {
            hasPushbackTC = false;
        } //End block
        else
        {
            pushbackTC = input.readByte();
        } //End block
        byte varE07029C787F995347976B5426FA51D79_199045906 = (pushbackTC);
                byte var40EA57D3EE3C07BF1C102B466E1C3091_493535874 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_493535874;
        // ---------- Original Method ----------
        //if (hasPushbackTC) {
            //hasPushbackTC = false; 
        //} else {
            //pushbackTC = input.readByte();
        //}
        //return pushbackTC;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.287 -0400", hash_original_method = "056AB6ECFECE1087CD6299233C3046CF", hash_generated_method = "1AA917BD8C0785A0A281D56B178CD348")
    private void pushbackTC() {
        hasPushbackTC = true;
        // ---------- Original Method ----------
        //hasPushbackTC = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.287 -0400", hash_original_method = "87E37984C9E76D351365EC77DA0248F5", hash_generated_method = "A47FC69AB3863B9149B02185F9600094")
    @Override
    public int read() throws IOException {
        checkReadPrimitiveTypes();
        int varD04DFE2746884E9CD8527C180BCA3864_1156086997 = (primitiveData.read());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_281106305 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_281106305;
        // ---------- Original Method ----------
        //checkReadPrimitiveTypes();
        //return primitiveData.read();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.288 -0400", hash_original_method = "7E3B2630C90BBA61B0E7CD83B04481D2", hash_generated_method = "E8C43ED657D2C8205542DA96371C8E50")
    @Override
    public int read(byte[] buffer, int offset, int length) throws IOException {
        addTaint(length);
        addTaint(offset);
        addTaint(buffer[0]);
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
        if(length == 0)        
        {
            int varCFCD208495D565EF66E7DFF9F98764DA_1945585308 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_105665766 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_105665766;
        } //End block
        checkReadPrimitiveTypes();
        int var794DFA0474D62B0CDAB50D94A5957122_1328680562 = (primitiveData.read(buffer, offset, length));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2118396831 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2118396831;
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buffer.length, offset, length);
        //if (length == 0) {
            //return 0;
        //}
        //checkReadPrimitiveTypes();
        //return primitiveData.read(buffer, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.288 -0400", hash_original_method = "35383BB5231F8136A4FECB09DEC2FE93", hash_generated_method = "0708F1F8882344BD9D796598DEC8330E")
    private byte[] readBlockData() throws IOException {
        byte[] result = new byte[input.readByte() & 0xff];
        input.readFully(result);
        byte[] varB4A88417B3D0170D754C647C30B7216A_1212575997 = (result);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_752504486 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_752504486;
        // ---------- Original Method ----------
        //byte[] result = new byte[input.readByte() & 0xff];
        //input.readFully(result);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.288 -0400", hash_original_method = "478D7B43D09CD1BAF3CA95670FAE291A", hash_generated_method = "B11B1878BD8417A627B5BADC049DD479")
    private byte[] readBlockDataLong() throws IOException {
        byte[] result = new byte[input.readInt()];
        input.readFully(result);
        byte[] varB4A88417B3D0170D754C647C30B7216A_223336090 = (result);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1537776122 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1537776122;
        // ---------- Original Method ----------
        //byte[] result = new byte[input.readInt()];
        //input.readFully(result);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.289 -0400", hash_original_method = "43182B65F59B21B8425D068A4900EB3A", hash_generated_method = "DA62C2B67C2A2F6A5F15144E8EC45078")
    public boolean readBoolean() throws IOException {
        boolean varF35D2E687280B7E8B6B9F81EE2DFA149_2056854443 = (primitiveTypes.readBoolean());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_989051469 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_989051469;
        // ---------- Original Method ----------
        //return primitiveTypes.readBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.289 -0400", hash_original_method = "F1C938A529B536DE0EA7C0848AC19388", hash_generated_method = "C7D26A2AD7EFAD04C2881E8CE378265D")
    public byte readByte() throws IOException {
        byte var67C1EA294D5E8AAFD4909D340B2DB1E4_1823239707 = (primitiveTypes.readByte());
                byte var40EA57D3EE3C07BF1C102B466E1C3091_111444231 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_111444231;
        // ---------- Original Method ----------
        //return primitiveTypes.readByte();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.289 -0400", hash_original_method = "08C7569945A67E2D251F3B449209E666", hash_generated_method = "BF48AD62C66DF088B9C44AA8EBC09C59")
    public char readChar() throws IOException {
        char var1A38B429BDAAAC24B2A6F0D286767462_2014786320 = (primitiveTypes.readChar());
                char varA87DEB01C5F539E6BDA34829C8EF2368_1277735779 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1277735779;
        // ---------- Original Method ----------
        //return primitiveTypes.readChar();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.290 -0400", hash_original_method = "7E3D613702E21574BA96B289FBA102EA", hash_generated_method = "E3E23E13C273441801D498E9BCAF5FD3")
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
                } //End block
                readContent(tc);
            } //End block
} while (true);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.299 -0400", hash_original_method = "8425AE4559FEB283CFFC129B3DDD377F", hash_generated_method = "9FFF855BB0535781DEA5B5EF502AC4B6")
    private ObjectStreamClass readClassDesc() throws ClassNotFoundException, IOException {
        byte tc = nextTC();
switch(tc){
        case TC_CLASSDESC:
ObjectStreamClass varCF7F61C10F02C651E05B883D30B98921_707760838 =         readNewClassDesc(false);
        varCF7F61C10F02C651E05B883D30B98921_707760838.addTaint(taint);
        return varCF7F61C10F02C651E05B883D30B98921_707760838;
        case TC_PROXYCLASSDESC:
        Class<?> proxyClass = readNewProxyClassDesc();
        ObjectStreamClass streamClass = ObjectStreamClass.lookup(proxyClass);
        streamClass.setLoadFields(ObjectStreamClass.NO_FIELDS);
        registerObjectRead(streamClass, nextHandle(), false);
        checkedSetSuperClassDesc(streamClass, readClassDesc());
ObjectStreamClass varB15C7012F89088D5E62C8E84F0D75364_532594477 =         streamClass;
        varB15C7012F89088D5E62C8E84F0D75364_532594477.addTaint(taint);
        return varB15C7012F89088D5E62C8E84F0D75364_532594477;
        case TC_REFERENCE:
ObjectStreamClass var45BA89463163BB71DA22DB941DEC608E_1713167444 =         (ObjectStreamClass) readCyclicReference();
        var45BA89463163BB71DA22DB941DEC608E_1713167444.addTaint(taint);
        return var45BA89463163BB71DA22DB941DEC608E_1713167444;
        case TC_NULL:
ObjectStreamClass var540C13E9E156B687226421B24F2DF178_824594287 =         null;
        var540C13E9E156B687226421B24F2DF178_824594287.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_824594287;
        default:
        java.io.StreamCorruptedException varA1F85B50BF8446E6D14D510BCDD729EB_94855690 = corruptStream(tc);
        varA1F85B50BF8446E6D14D510BCDD729EB_94855690.addTaint(taint);
        throw varA1F85B50BF8446E6D14D510BCDD729EB_94855690;
}
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.300 -0400", hash_original_method = "D1B003D7ABBBCEF0B15D64544C91AEEF", hash_generated_method = "06DD5852279911C945F0F1F993707816")
    private StreamCorruptedException corruptStream(byte tc) throws StreamCorruptedException {
        addTaint(tc);
        StreamCorruptedException var0471ACC505E72FE25CC45B1924A74A13_1097639496 = new StreamCorruptedException("Wrong format: " + Integer.toHexString(tc & 0xff));
        var0471ACC505E72FE25CC45B1924A74A13_1097639496.addTaint(taint);
        throw var0471ACC505E72FE25CC45B1924A74A13_1097639496;
        // ---------- Original Method ----------
        //throw new StreamCorruptedException("Wrong format: " + Integer.toHexString(tc & 0xff));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.314 -0400", hash_original_method = "EBF146E3B3C2508DCA0D721582A75609", hash_generated_method = "38158270015AB92C2B11B41C23545D62")
    private Object readContent(byte tc) throws ClassNotFoundException,
            IOException {
        addTaint(tc);
switch(tc){
        case TC_BLOCKDATA:
Object var43CB2D2F0DC9F9E7FE6815C35473E82C_779917749 =         readBlockData();
        var43CB2D2F0DC9F9E7FE6815C35473E82C_779917749.addTaint(taint);
        return var43CB2D2F0DC9F9E7FE6815C35473E82C_779917749;
        case TC_BLOCKDATALONG:
Object varEC9A5C7E15069F19E88B8CDB3E213D22_365509319 =         readBlockDataLong();
        varEC9A5C7E15069F19E88B8CDB3E213D22_365509319.addTaint(taint);
        return varEC9A5C7E15069F19E88B8CDB3E213D22_365509319;
        case TC_CLASS:
Object var4646CBA7D98975B6A0A5E8BAEE19B439_1961711617 =         readNewClass(false);
        var4646CBA7D98975B6A0A5E8BAEE19B439_1961711617.addTaint(taint);
        return var4646CBA7D98975B6A0A5E8BAEE19B439_1961711617;
        case TC_CLASSDESC:
Object varCF7F61C10F02C651E05B883D30B98921_1150370278 =         readNewClassDesc(false);
        varCF7F61C10F02C651E05B883D30B98921_1150370278.addTaint(taint);
        return varCF7F61C10F02C651E05B883D30B98921_1150370278;
        case TC_ARRAY:
Object var03139D67A4693412A22B6F837A4BA5EC_2107456083 =         readNewArray(false);
        var03139D67A4693412A22B6F837A4BA5EC_2107456083.addTaint(taint);
        return var03139D67A4693412A22B6F837A4BA5EC_2107456083;
        case TC_OBJECT:
Object var2C4B5CF99C7ACE03D796FDF9B77EB761_1472926743 =         readNewObject(false);
        var2C4B5CF99C7ACE03D796FDF9B77EB761_1472926743.addTaint(taint);
        return var2C4B5CF99C7ACE03D796FDF9B77EB761_1472926743;
        case TC_STRING:
Object varF34385A2E461922D13908D6E4EEB6162_181091129 =         readNewString(false);
        varF34385A2E461922D13908D6E4EEB6162_181091129.addTaint(taint);
        return varF34385A2E461922D13908D6E4EEB6162_181091129;
        case TC_LONGSTRING:
Object var67CF6CDB5339B77E74CF012E62385BE0_593055795 =         readNewLongString(false);
        var67CF6CDB5339B77E74CF012E62385BE0_593055795.addTaint(taint);
        return var67CF6CDB5339B77E74CF012E62385BE0_593055795;
        case TC_REFERENCE:
Object var0BF3707675556B4FE0EF8CB26EC6C54B_406439212 =         readCyclicReference();
        var0BF3707675556B4FE0EF8CB26EC6C54B_406439212.addTaint(taint);
        return var0BF3707675556B4FE0EF8CB26EC6C54B_406439212;
        case TC_NULL:
Object var540C13E9E156B687226421B24F2DF178_1080040589 =         null;
        var540C13E9E156B687226421B24F2DF178_1080040589.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1080040589;
        case TC_EXCEPTION:
        Exception exc = readException();
        WriteAbortedException var2F060354FC02BC4D8A492774E83099BD_1851920815 = new WriteAbortedException("Read an exception", exc);
        var2F060354FC02BC4D8A492774E83099BD_1851920815.addTaint(taint);
        throw var2F060354FC02BC4D8A492774E83099BD_1851920815;
        case TC_RESET:
        resetState();
Object var540C13E9E156B687226421B24F2DF178_1890684022 =         null;
        var540C13E9E156B687226421B24F2DF178_1890684022.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1890684022;
        default:
        java.io.StreamCorruptedException varA1F85B50BF8446E6D14D510BCDD729EB_1748060076 = corruptStream(tc);
        varA1F85B50BF8446E6D14D510BCDD729EB_1748060076.addTaint(taint);
        throw varA1F85B50BF8446E6D14D510BCDD729EB_1748060076;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.341 -0400", hash_original_method = "C964F7473D297E2F3A28B1C55493EBEA", hash_generated_method = "1FE04C20382DE23A5651382C4F7B9266")
    private Object readNonPrimitiveContent(boolean unshared) throws ClassNotFoundException, IOException {
        addTaint(unshared);
        checkReadPrimitiveTypes();
        if(primitiveData.available() > 0)        
        {
            OptionalDataException e = new OptionalDataException();
            e.length = primitiveData.available();
            e.addTaint(taint);
            throw e;
        } //End block
        do {
            {
                byte tc = nextTC();
switch(tc){
                case TC_CLASS:
Object var145A039A3C690A9E8FC4A3FB7BFD0A17_1633033774 =                 readNewClass(unshared);
                var145A039A3C690A9E8FC4A3FB7BFD0A17_1633033774.addTaint(taint);
                return var145A039A3C690A9E8FC4A3FB7BFD0A17_1633033774;
                case TC_CLASSDESC:
Object varB5579989F181BBC1FE2F31A8753136D7_754402764 =                 readNewClassDesc(unshared);
                varB5579989F181BBC1FE2F31A8753136D7_754402764.addTaint(taint);
                return varB5579989F181BBC1FE2F31A8753136D7_754402764;
                case TC_ARRAY:
Object varB3470F4BCFD222571EBE4750011FF3C8_1240177833 =                 readNewArray(unshared);
                varB3470F4BCFD222571EBE4750011FF3C8_1240177833.addTaint(taint);
                return varB3470F4BCFD222571EBE4750011FF3C8_1240177833;
                case TC_OBJECT:
Object var0E999F4AE2CE265FD473F4C0201BFE56_848155097 =                 readNewObject(unshared);
                var0E999F4AE2CE265FD473F4C0201BFE56_848155097.addTaint(taint);
                return var0E999F4AE2CE265FD473F4C0201BFE56_848155097;
                case TC_STRING:
Object varDD643C684E598AF8988E057D3CFCECB8_1803143648 =                 readNewString(unshared);
                varDD643C684E598AF8988E057D3CFCECB8_1803143648.addTaint(taint);
                return varDD643C684E598AF8988E057D3CFCECB8_1803143648;
                case TC_LONGSTRING:
Object var6AC1359F4772D672933436D4D0A54361_780162610 =                 readNewLongString(unshared);
                var6AC1359F4772D672933436D4D0A54361_780162610.addTaint(taint);
                return var6AC1359F4772D672933436D4D0A54361_780162610;
                case TC_ENUM:
Object var567126F916CFF7C51C75D14E86B2324F_1537633360 =                 readEnum(unshared);
                var567126F916CFF7C51C75D14E86B2324F_1537633360.addTaint(taint);
                return var567126F916CFF7C51C75D14E86B2324F_1537633360;
                case TC_REFERENCE:
                if(unshared)                
                {
                    readNewHandle();
                    InvalidObjectException varB03B1E7AB6C2FC12286EAFC18E1E860F_998138413 = new InvalidObjectException("Unshared read of back reference");
                    varB03B1E7AB6C2FC12286EAFC18E1E860F_998138413.addTaint(taint);
                    throw varB03B1E7AB6C2FC12286EAFC18E1E860F_998138413;
                } //End block
Object var0BF3707675556B4FE0EF8CB26EC6C54B_784169454 =                 readCyclicReference();
                var0BF3707675556B4FE0EF8CB26EC6C54B_784169454.addTaint(taint);
                return var0BF3707675556B4FE0EF8CB26EC6C54B_784169454;
                case TC_NULL:
Object var540C13E9E156B687226421B24F2DF178_1152078901 =                 null;
                var540C13E9E156B687226421B24F2DF178_1152078901.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1152078901;
                case TC_EXCEPTION:
                Exception exc = readException();
                WriteAbortedException var2F060354FC02BC4D8A492774E83099BD_1667876726 = new WriteAbortedException("Read an exception", exc);
                var2F060354FC02BC4D8A492774E83099BD_1667876726.addTaint(taint);
                throw var2F060354FC02BC4D8A492774E83099BD_1667876726;
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
                java.io.StreamCorruptedException varA1F85B50BF8446E6D14D510BCDD729EB_1163829880 = corruptStream(tc);
                varA1F85B50BF8446E6D14D510BCDD729EB_1163829880.addTaint(taint);
                throw varA1F85B50BF8446E6D14D510BCDD729EB_1163829880;
}
            } //End block
} while (true);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.345 -0400", hash_original_method = "821B45232EA8F88246A504603C8240EF", hash_generated_method = "BCD9716779A8FD2B944FEC6192B275A8")
    private Object readCyclicReference() throws InvalidObjectException, IOException {
Object varB1538074715E5E5A847ABEB7ED0A3C23_998195212 =         registeredObjectRead(readNewHandle());
        varB1538074715E5E5A847ABEB7ED0A3C23_998195212.addTaint(taint);
        return varB1538074715E5E5A847ABEB7ED0A3C23_998195212;
        // ---------- Original Method ----------
        //return registeredObjectRead(readNewHandle());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.347 -0400", hash_original_method = "7C91F28BD77A4ED641420E614D9FCB15", hash_generated_method = "68AA9A92E1E82FFBB433FE7F998F417D")
    public double readDouble() throws IOException {
        double var13DB878FE5FD515296AAFEC61E2A5FB3_1677968075 = (primitiveTypes.readDouble());
                double varE8CD7DA078A86726031AD64F35F5A6C0_763085438 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_763085438;
        // ---------- Original Method ----------
        //return primitiveTypes.readDouble();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.349 -0400", hash_original_method = "BA11A34B6A0BFC2FA522B0508C6E225C", hash_generated_method = "09BF490ACDE15780CB454326263DF90B")
    private Exception readException() throws WriteAbortedException,
            OptionalDataException, ClassNotFoundException, IOException {
        resetSeenObjects();
        Exception exc = (Exception) readObject();
        resetSeenObjects();
Exception varA75BAC093E1427C564E637F02D38B691_845319692 =         exc;
        varA75BAC093E1427C564E637F02D38B691_845319692.addTaint(taint);
        return varA75BAC093E1427C564E637F02D38B691_845319692;
        // ---------- Original Method ----------
        //resetSeenObjects();
        //Exception exc = (Exception) readObject();
        //resetSeenObjects();
        //return exc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.352 -0400", hash_original_method = "FA3DFED5FC7EE2104F3E818CA56DCFE9", hash_generated_method = "954054B850E3350F0F222DECEBACAF1D")
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
            } //End block
            else
            {
                boolean old = enableResolve;
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
            ObjectStreamField f = new ObjectStreamField(classSig, fieldName);
            fields[i] = f;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.354 -0400", hash_original_method = "35D23573908F6AA48B37BF1647A74D3F", hash_generated_method = "7F8FDF3BA4FC60A408AB17A6F65B0A7F")
    public GetField readFields() throws IOException, ClassNotFoundException, NotActiveException {
        if(currentObject == null)        
        {
            NotActiveException varFD1AAF3605EC866A6A8BBEC842DA8C8A_757718251 = new NotActiveException();
            varFD1AAF3605EC866A6A8BBEC842DA8C8A_757718251.addTaint(taint);
            throw varFD1AAF3605EC866A6A8BBEC842DA8C8A_757718251;
        } //End block
        EmulatedFieldsForLoading result = new EmulatedFieldsForLoading(currentClass);
        readFieldValues(result);
GetField varDC838461EE2FA0CA4C9BBB70A15456B0_960893263 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_960893263.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_960893263;
        // ---------- Original Method ----------
        //if (currentObject == null) {
            //throw new NotActiveException();
        //}
        //EmulatedFieldsForLoading result = new EmulatedFieldsForLoading(currentClass);
        //readFieldValues(result);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.356 -0400", hash_original_method = "8289C081F35F5F257A7DE20983B5F39B", hash_generated_method = "4C1B3169ABCEED6C12D35BA3FB9FDC8E")
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
            } //End block
            else
            if(type == byte.class)            
            {
                element.fieldValue = input.readByte();
            } //End block
            else
            if(type == char.class)            
            {
                element.fieldValue = input.readChar();
            } //End block
            else
            if(type == short.class)            
            {
                element.fieldValue = input.readShort();
            } //End block
            else
            if(type == boolean.class)            
            {
                element.fieldValue = input.readBoolean();
            } //End block
            else
            if(type == long.class)            
            {
                element.fieldValue = input.readLong();
            } //End block
            else
            if(type == float.class)            
            {
                element.fieldValue = input.readFloat();
            } //End block
            else
            if(type == double.class)            
            {
                element.fieldValue = input.readDouble();
            } //End block
            else
            {
                try 
                {
                    element.fieldValue = readObject();
                } //End block
                catch (ClassNotFoundException cnf)
                {
                    InvalidClassException varBA9D7153552A6E4211042728FA0F0503_226089921 = new InvalidClassException(cnf.toString());
                    varBA9D7153552A6E4211042728FA0F0503_226089921.addTaint(taint);
                    throw varBA9D7153552A6E4211042728FA0F0503_226089921;
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.357 -0400", hash_original_method = "3FF4AC35875B69602347D8B467CAEB0A", hash_generated_method = "CD720808F3D5672EBE9A666DA47AC6B4")
    private void readFieldValues(Object obj, ObjectStreamClass classDesc) throws OptionalDataException, ClassNotFoundException, IOException {
        addTaint(classDesc.getTaint());
        addTaint(obj.getTaint());
        ObjectStreamField[] fields = classDesc.getLoadFields();
        fields = (fields == null) ? ObjectStreamClass.NO_FIELDS : fields;
        Class<?> declaringClass = classDesc.forClass();
        if(declaringClass == null && mustResolve)        
        {
            ClassNotFoundException var3ED5BA2CAAB610C07192C5A85172915A_1926946313 = new ClassNotFoundException(classDesc.getName());
            var3ED5BA2CAAB610C07192C5A85172915A_1926946313.addTaint(taint);
            throw var3ED5BA2CAAB610C07192C5A85172915A_1926946313;
        } //End block
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
                    } //End block
                } //End block
                else
                if(type == char.class)                
                {
                    char c = input.readChar();
                    if(field != null)                    
                    {
                        field.setChar(obj, c);
                    } //End block
                } //End block
                else
                if(type == double.class)                
                {
                    double d = input.readDouble();
                    if(field != null)                    
                    {
                        field.setDouble(obj, d);
                    } //End block
                } //End block
                else
                if(type == float.class)                
                {
                    float f = input.readFloat();
                    if(field != null)                    
                    {
                        field.setFloat(obj, f);
                    } //End block
                } //End block
                else
                if(type == int.class)                
                {
                    int i = input.readInt();
                    if(field != null)                    
                    {
                        field.setInt(obj, i);
                    } //End block
                } //End block
                else
                if(type == long.class)                
                {
                    long j = input.readLong();
                    if(field != null)                    
                    {
                        field.setLong(obj, j);
                    } //End block
                } //End block
                else
                if(type == short.class)                
                {
                    short s = input.readShort();
                    if(field != null)                    
                    {
                        field.setShort(obj, s);
                    } //End block
                } //End block
                else
                if(type == boolean.class)                
                {
                    boolean z = input.readBoolean();
                    if(field != null)                    
                    {
                        field.setBoolean(obj, z);
                    } //End block
                } //End block
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
                            ClassCastException var8709C55D8E8D81887E10913DE8AB2867_1430421657 = new ClassCastException(classDesc.getName() + "." + fieldName + " - " + fieldType + " not compatible with " + valueType);
                            var8709C55D8E8D81887E10913DE8AB2867_1430421657.addTaint(taint);
                            throw var8709C55D8E8D81887E10913DE8AB2867_1430421657;
                        } //End block
                        if(field != null)                        
                        {
                            field.set(obj, toSet);
                        } //End block
                    } //End block
                } //End block
            } //End block
            catch (IllegalAccessException iae)
            {
                AssertionError varB7184EDFD8CA9CD0B66958C2AD057E9E_1281249795 = new AssertionError(iae);
                varB7184EDFD8CA9CD0B66958C2AD057E9E_1281249795.addTaint(taint);
                throw varB7184EDFD8CA9CD0B66958C2AD057E9E_1281249795;
            } //End block
            catch (NoSuchFieldError ignored)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.357 -0400", hash_original_method = "E7BFAC98C28E1C1B49BD33FC0E76EA53", hash_generated_method = "15CF857CD5BCFB8C6B691F8EC5021F34")
    public float readFloat() throws IOException {
        float var23384172A845DD5A2C5BBE3AD6F05EED_1243789768 = (primitiveTypes.readFloat());
                float var546ADE640B6EDFBC8A086EF31347E768_1227239773 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1227239773;
        // ---------- Original Method ----------
        //return primitiveTypes.readFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.358 -0400", hash_original_method = "917418BB5C848A4690F4E96972002BAD", hash_generated_method = "29573BEC4ED9B3CA1C7F76B5436712E4")
    public void readFully(byte[] dst) throws IOException {
        addTaint(dst[0]);
        primitiveTypes.readFully(dst);
        // ---------- Original Method ----------
        //primitiveTypes.readFully(dst);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.358 -0400", hash_original_method = "046EB506BDA13B9ED79306898615169A", hash_generated_method = "9E14F09FB2D95B59FC09DA5B851EC42A")
    public void readFully(byte[] dst, int offset, int byteCount) throws IOException {
        addTaint(byteCount);
        addTaint(offset);
        addTaint(dst[0]);
        primitiveTypes.readFully(dst, offset, byteCount);
        // ---------- Original Method ----------
        //primitiveTypes.readFully(dst, offset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.358 -0400", hash_original_method = "D8B45244A94A62B53D8A8E2E7C864422", hash_generated_method = "268E2F6D89C81B31668D5140ABE55C94")
    private void readHierarchy(Object object, ObjectStreamClass classDesc) throws IOException, ClassNotFoundException, NotActiveException {
        addTaint(classDesc.getTaint());
        addTaint(object.getTaint());
        if(object == null && mustResolve)        
        {
            NotActiveException varFD1AAF3605EC866A6A8BBEC842DA8C8A_1413193926 = new NotActiveException();
            varFD1AAF3605EC866A6A8BBEC842DA8C8A_1413193926.addTaint(taint);
            throw varFD1AAF3605EC866A6A8BBEC842DA8C8A_1413193926;
        } //End block
        List<ObjectStreamClass> streamClassList = classDesc.getHierarchy();
        if(object == null)        
        {
for(ObjectStreamClass objectStreamClass : streamClassList)
            {
                readObjectForClass(null, objectStreamClass);
            } //End block
        } //End block
        else
        {
            List<Class<?>> superclasses = cachedSuperclasses.get(object.getClass());
            if(superclasses == null)            
            {
                superclasses = cacheSuperclassesFor(object.getClass());
            } //End block
            int lastIndex = 0;
for(int i = 0, end = superclasses.size();i < end;++i)
            {
                Class<?> superclass = superclasses.get(i);
                int index = findStreamSuperclass(superclass, streamClassList, lastIndex);
                if(index == -1)                
                {
                    readObjectNoData(object, superclass,
                            ObjectStreamClass.lookupStreamClass(superclass));
                } //End block
                else
                {
for(int j = lastIndex;j <= index;j++)
                    {
                        readObjectForClass(object, streamClassList.get(j));
                    } //End block
                    lastIndex = index + 1;
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.359 -0400", hash_original_method = "F09DF984FD463C1BCDA606260FD08FFE", hash_generated_method = "1B5E2771DD87C5ED75605F036A9C99E3")
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
            } //End block
            nextClass = testClass;
        } //End block
        cachedSuperclasses.put(c, result);
List<Class<?>> varDC838461EE2FA0CA4C9BBB70A15456B0_1501103332 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1501103332.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1501103332;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.359 -0400", hash_original_method = "30EFDC31EF83C1843078545357CDA4A5", hash_generated_method = "56151D23144F6BF2DF8A279147C1FCDB")
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
                    int var865C0C0B4AB0E063E5CAA3387C1A8741_1934359746 = (i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1896776371 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1896776371;
                } //End block
            } //End block
            else
            {
                if(cl.getName().equals(forName))                
                {
                    int var865C0C0B4AB0E063E5CAA3387C1A8741_1555374465 = (i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1905632492 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1905632492;
                } //End block
            } //End block
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_719730364 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1963056625 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1963056625;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.360 -0400", hash_original_method = "868BCCA0967481794CFA1D8D3E56D3E6", hash_generated_method = "AA3715F94FD958C4A31B9D2CF84AF57A")
    private void readObjectNoData(Object object, Class<?> cl, ObjectStreamClass classDesc) throws ObjectStreamException {
        addTaint(classDesc.getTaint());
        addTaint(cl.getTaint());
        addTaint(object.getTaint());
        if(!classDesc.isSerializable())        
        {
            return;
        } //End block
        if(classDesc.hasMethodReadObjectNoData())        
        {
            final Method readMethod = classDesc.getMethodReadObjectNoData();
            try 
            {
                readMethod.invoke(object);
            } //End block
            catch (InvocationTargetException e)
            {
                Throwable ex = e.getTargetException();
                if(ex instanceof RuntimeException)                
                {
                    RuntimeException varF0C2DBE52270DD4B45A7073A4B8A4F8C_2020341107 = (RuntimeException) ex;
                    varF0C2DBE52270DD4B45A7073A4B8A4F8C_2020341107.addTaint(taint);
                    throw varF0C2DBE52270DD4B45A7073A4B8A4F8C_2020341107;
                } //End block
                else
                if(ex instanceof Error)                
                {
                    Error var5088E1E74327DBB15F7148041BB4E6E0_773281370 = (Error) ex;
                    var5088E1E74327DBB15F7148041BB4E6E0_773281370.addTaint(taint);
                    throw var5088E1E74327DBB15F7148041BB4E6E0_773281370;
                } //End block
                ObjectStreamException varF05FB6CDAAC97D6EABE45A43B6059660_306407276 = (ObjectStreamException) ex;
                varF05FB6CDAAC97D6EABE45A43B6059660_306407276.addTaint(taint);
                throw varF05FB6CDAAC97D6EABE45A43B6059660_306407276;
            } //End block
            catch (IllegalAccessException e)
            {
                RuntimeException var7731B7FAF9DB516E410EE38D728795B2_360249920 = new RuntimeException(e.toString());
                var7731B7FAF9DB516E410EE38D728795B2_360249920.addTaint(taint);
                throw var7731B7FAF9DB516E410EE38D728795B2_360249920;
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.360 -0400", hash_original_method = "6119E962BBCC069017D862716C24BEC0", hash_generated_method = "9FA6EE5C92973298DBD9DD9E512142A8")
    private void readObjectForClass(Object object, ObjectStreamClass classDesc) throws IOException, ClassNotFoundException, NotActiveException {
        currentObject = object;
        currentClass = classDesc;
        boolean hadWriteMethod = (classDesc.getFlags() & SC_WRITE_METHOD) != 0;
        Class<?> targetClass = classDesc.forClass();
        Method readMethod;
        if(targetClass == null || !mustResolve)        
        {
            readMethod = null;
        } //End block
        else
        {
            readMethod = classDesc.getMethodReadObject();
        } //End block
        try 
        {
            if(readMethod != null)            
            {
                readMethod.setAccessible(true);
                try 
                {
                    readMethod.invoke(object, this);
                } //End block
                catch (InvocationTargetException e)
                {
                    Throwable ex = e.getTargetException();
                    if(ex instanceof ClassNotFoundException)                    
                    {
                        ClassNotFoundException var474CB282B0D1099512876AF1EC1931B2_923383022 = (ClassNotFoundException) ex;
                        var474CB282B0D1099512876AF1EC1931B2_923383022.addTaint(taint);
                        throw var474CB282B0D1099512876AF1EC1931B2_923383022;
                    } //End block
                    else
                    if(ex instanceof RuntimeException)                    
                    {
                        RuntimeException varF0C2DBE52270DD4B45A7073A4B8A4F8C_1056117812 = (RuntimeException) ex;
                        varF0C2DBE52270DD4B45A7073A4B8A4F8C_1056117812.addTaint(taint);
                        throw varF0C2DBE52270DD4B45A7073A4B8A4F8C_1056117812;
                    } //End block
                    else
                    if(ex instanceof Error)                    
                    {
                        Error var5088E1E74327DBB15F7148041BB4E6E0_2013742824 = (Error) ex;
                        var5088E1E74327DBB15F7148041BB4E6E0_2013742824.addTaint(taint);
                        throw var5088E1E74327DBB15F7148041BB4E6E0_2013742824;
                    } //End block
                    IOException var3F32687BA78654886C8AE6DEBD282711_1147345952 = (IOException) ex;
                    var3F32687BA78654886C8AE6DEBD282711_1147345952.addTaint(taint);
                    throw var3F32687BA78654886C8AE6DEBD282711_1147345952;
                } //End block
                catch (IllegalAccessException e)
                {
                    RuntimeException var7731B7FAF9DB516E410EE38D728795B2_1963173212 = new RuntimeException(e.toString());
                    var7731B7FAF9DB516E410EE38D728795B2_1963173212.addTaint(taint);
                    throw var7731B7FAF9DB516E410EE38D728795B2_1963173212;
                } //End block
            } //End block
            else
            {
                defaultReadObject();
            } //End block
            if(hadWriteMethod)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.360 -0400", hash_original_method = "D31E8D2825D4043295F3D0C685B93717", hash_generated_method = "3757BEB0BE7D9D1F148BE5FF300BB692")
    public int readInt() throws IOException {
        int varB2A6B1B74BD03F0DD15140B729D58103_140123594 = (primitiveTypes.readInt());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_197076497 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_197076497;
        // ---------- Original Method ----------
        //return primitiveTypes.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.361 -0400", hash_original_method = "90EA71A98921C4D093F2F0BA4DDBE95D", hash_generated_method = "08D78F449192453C0CC529C1969C975F")
    @Deprecated
    public String readLine() throws IOException {
String varAB96D771FB7A20F126379CBD285B2198_2063756374 =         primitiveTypes.readLine();
        varAB96D771FB7A20F126379CBD285B2198_2063756374.addTaint(taint);
        return varAB96D771FB7A20F126379CBD285B2198_2063756374;
        // ---------- Original Method ----------
        //return primitiveTypes.readLine();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.361 -0400", hash_original_method = "70C9FFE9F08A2EBCF32FC4C20D730AD7", hash_generated_method = "048B89DD7977465DFA88F59534F3CD3B")
    public long readLong() throws IOException {
        long var717B0A39DD043419AB5C092C0E238E2A_588439243 = (primitiveTypes.readLong());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_274906834 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_274906834;
        // ---------- Original Method ----------
        //return primitiveTypes.readLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.430 -0400", hash_original_method = "6C628531F4475FFAEEB816E877548000", hash_generated_method = "776175C4CEDD7C8F532A318556D131C5")
    private Object readNewArray(boolean unshared) throws OptionalDataException,
            ClassNotFoundException, IOException {
        addTaint(unshared);
        ObjectStreamClass classDesc = readClassDesc();
        if(classDesc == null)        
        {
            java.io.InvalidClassException varF0B669FE625FDCD2C0B7AFC2BF75622C_997922490 = missingClassDescriptor();
            varF0B669FE625FDCD2C0B7AFC2BF75622C_997922490.addTaint(taint);
            throw varF0B669FE625FDCD2C0B7AFC2BF75622C_997922490;
        } //End block
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
                } //End block
            } //End block
            else
            if(componentType == byte.class)            
            {
                byte[] byteArray = (byte[]) result;
                input.readFully(byteArray, 0, size);
            } //End block
            else
            if(componentType == char.class)            
            {
                char[] charArray = (char[]) result;
for(int i = 0;i < size;i++)
                {
                    charArray[i] = input.readChar();
                } //End block
            } //End block
            else
            if(componentType == short.class)            
            {
                short[] shortArray = (short[]) result;
for(int i = 0;i < size;i++)
                {
                    shortArray[i] = input.readShort();
                } //End block
            } //End block
            else
            if(componentType == boolean.class)            
            {
                boolean[] booleanArray = (boolean[]) result;
for(int i = 0;i < size;i++)
                {
                    booleanArray[i] = input.readBoolean();
                } //End block
            } //End block
            else
            if(componentType == long.class)            
            {
                long[] longArray = (long[]) result;
for(int i = 0;i < size;i++)
                {
                    longArray[i] = input.readLong();
                } //End block
            } //End block
            else
            if(componentType == float.class)            
            {
                float[] floatArray = (float[]) result;
for(int i = 0;i < size;i++)
                {
                    floatArray[i] = input.readFloat();
                } //End block
            } //End block
            else
            if(componentType == double.class)            
            {
                double[] doubleArray = (double[]) result;
for(int i = 0;i < size;i++)
                {
                    doubleArray[i] = input.readDouble();
                } //End block
            } //End block
            else
            {
                ClassNotFoundException var2957F23825B6E9F97EDD184390727BF1_1039876069 = new ClassNotFoundException("Wrong base type in " + classDesc.getName());
                var2957F23825B6E9F97EDD184390727BF1_1039876069.addTaint(taint);
                throw var2957F23825B6E9F97EDD184390727BF1_1039876069;
            } //End block
        } //End block
        else
        {
            Object[] objectArray = (Object[]) result;
for(int i = 0;i < size;i++)
            {
                objectArray[i] = readObject();
            } //End block
        } //End block
        if(enableResolve)        
        {
            result = resolveObject(result);
            registerObjectRead(result, newHandle, false);
        } //End block
Object varDC838461EE2FA0CA4C9BBB70A15456B0_677661476 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_677661476.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_677661476;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.514 -0400", hash_original_method = "D16FAEE9BB99888884BA2510B9D0161D", hash_generated_method = "47DFB6C33A022CCB44F40932D1BDAAEB")
    private ObjectStreamClass readEnumDesc() throws IOException,
            ClassNotFoundException {
        byte tc = nextTC();
switch(tc){
        case TC_CLASSDESC:
ObjectStreamClass varCB78B39216098386AB1BB2A6AB28781B_1524902662 =         readEnumDescInternal();
        varCB78B39216098386AB1BB2A6AB28781B_1524902662.addTaint(taint);
        return varCB78B39216098386AB1BB2A6AB28781B_1524902662;
        case TC_REFERENCE:
ObjectStreamClass var45BA89463163BB71DA22DB941DEC608E_1018908713 =         (ObjectStreamClass) readCyclicReference();
        var45BA89463163BB71DA22DB941DEC608E_1018908713.addTaint(taint);
        return var45BA89463163BB71DA22DB941DEC608E_1018908713;
        case TC_NULL:
ObjectStreamClass var540C13E9E156B687226421B24F2DF178_838859248 =         null;
        var540C13E9E156B687226421B24F2DF178_838859248.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_838859248;
        default:
        java.io.StreamCorruptedException varA1F85B50BF8446E6D14D510BCDD729EB_1485277405 = corruptStream(tc);
        varA1F85B50BF8446E6D14D510BCDD729EB_1485277405.addTaint(taint);
        throw varA1F85B50BF8446E6D14D510BCDD729EB_1485277405;
}
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.516 -0400", hash_original_method = "58EE21B582EE01373F973D50B42B8A60", hash_generated_method = "88FCD3774847ED7BA33FA84A44776C3A")
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
            InvalidClassException varD7E851C67BA27BF8BF633C6ABC13EF43_532334725 = new InvalidClassException(superClass.getName(),
                    "Incompatible class (SUID): " + superClass + " but expected " + superClass);
            varD7E851C67BA27BF8BF633C6ABC13EF43_532334725.addTaint(taint);
            throw varD7E851C67BA27BF8BF633C6ABC13EF43_532334725;
        } //End block
        byte tc = nextTC();
        if(tc == TC_ENDBLOCKDATA)        
        {
            superClass.setSuperclass(readClassDesc());
        } //End block
        else
        {
            pushbackTC();
        } //End block
ObjectStreamClass var3497C6F192F17384DEAA3543897C005A_1658610387 =         classDesc;
        var3497C6F192F17384DEAA3543897C005A_1658610387.addTaint(taint);
        return var3497C6F192F17384DEAA3543897C005A_1658610387;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.567 -0400", hash_original_method = "0BB1D7ADA0D4FC987B96FE9D538B84F1", hash_generated_method = "1E962EECA6384D7C1635B4636E2B0076")
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
            InvalidObjectException varB03B1E7AB6C2FC12286EAFC18E1E860F_1718383039 = new InvalidObjectException("Unshared read of back reference");
            varB03B1E7AB6C2FC12286EAFC18E1E860F_1718383039.addTaint(taint);
            throw varB03B1E7AB6C2FC12286EAFC18E1E860F_1718383039;
        } //End block
        name = (String) readCyclicReference();
        break;
        case TC_STRING:
        name = (String) readNewString(unshared);
        break;
        default:
        java.io.StreamCorruptedException varA1F85B50BF8446E6D14D510BCDD729EB_519314346 = corruptStream(tc);
        varA1F85B50BF8446E6D14D510BCDD729EB_519314346.addTaint(taint);
        throw varA1F85B50BF8446E6D14D510BCDD729EB_519314346;
}        Enum<?> result = Enum.valueOf((Class) classDesc.forClass(), name);
        registerObjectRead(result, newHandle, unshared);
Object varDC838461EE2FA0CA4C9BBB70A15456B0_1975718993 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1975718993.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1975718993;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.574 -0400", hash_original_method = "85A17F1C0F9F03F0EE48936822125550", hash_generated_method = "04348EB9BC5CC8856965A6E34383804E")
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
        } //End block
        catch (ClassNotFoundException e)
        {
            if(mustResolve)            
            {
                e.addTaint(taint);
                throw e;
            } //End block
        } //End block
        ObjectStreamField[] fields = newClassDesc.getLoadFields();
        fields = (fields == null) ? ObjectStreamClass.NO_FIELDS : fields;
        ClassLoader loader = newClassDesc.forClass() == null ? callerClassLoader
                : newClassDesc.forClass().getClassLoader();
for(ObjectStreamField element : fields)
        {
            element.resolve(loader);
        } //End block
        discardData();
        checkedSetSuperClassDesc(newClassDesc, readClassDesc());
ObjectStreamClass var9298ABC4754D010280EDCD1628E45333_117040900 =         newClassDesc;
        var9298ABC4754D010280EDCD1628E45333_117040900.addTaint(taint);
        return var9298ABC4754D010280EDCD1628E45333_117040900;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.577 -0400", hash_original_method = "9592596F093477979EA31311F339CD7D", hash_generated_method = "1AACF34E3DFB1CBF4D7900EAF0029705")
    private Class<?> readNewProxyClassDesc() throws ClassNotFoundException,
            IOException {
        int count = input.readInt();
        String[] interfaceNames = new String[count];
for(int i = 0;i < count;i++)
        {
            interfaceNames[i] = input.readUTF();
        } //End block
        Class<?> proxy = resolveProxyClass(interfaceNames);
        discardData();
Class<?> var60FC9F22F7E863EBFD33B2ADB8462743_459709445 =         proxy;
        var60FC9F22F7E863EBFD33B2ADB8462743_459709445.addTaint(taint);
        return var60FC9F22F7E863EBFD33B2ADB8462743_459709445;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.583 -0400", hash_original_method = "97948A412F94E7F820143192C44DB303", hash_generated_method = "7B2D2C884204BD49F9A8421CC043D9F0")
    protected ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
        ObjectStreamClass newClassDesc = new ObjectStreamClass();
        String name = input.readUTF();
        if(name.length() == 0)        
        {
            IOException var7AF2F174A0D0CD24060446F4A5468977_1777668732 = new IOException("The stream is corrupted");
            var7AF2F174A0D0CD24060446F4A5468977_1777668732.addTaint(taint);
            throw var7AF2F174A0D0CD24060446F4A5468977_1777668732;
        } //End block
        newClassDesc.setName(name);
        newClassDesc.setSerialVersionUID(input.readLong());
        newClassDesc.setFlags(input.readByte());
        if(descriptorHandle == -1)        
        {
            descriptorHandle = nextHandle();
        } //End block
        registerObjectRead(newClassDesc, descriptorHandle, false);
        readFieldDescriptors(newClassDesc);
ObjectStreamClass var9298ABC4754D010280EDCD1628E45333_1275811564 =         newClassDesc;
        var9298ABC4754D010280EDCD1628E45333_1275811564.addTaint(taint);
        return var9298ABC4754D010280EDCD1628E45333_1275811564;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.586 -0400", hash_original_method = "C938C68924527CB04F806429B3BE928F", hash_generated_method = "8C75DB7E98D9EC09D0370998B6144E9F")
    protected Class<?> resolveProxyClass(String[] interfaceNames) throws IOException, ClassNotFoundException {
        addTaint(interfaceNames[0].getTaint());
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class<?>[] interfaces = new Class<?>[interfaceNames.length];
for(int i = 0;i < interfaceNames.length;i++)
        {
            interfaces[i] = Class.forName(interfaceNames[i], false, loader);
        } //End block
        try 
        {
Class<?> var1585BFE2B902F61A3216AC5F3A95D704_507670344 =             Proxy.getProxyClass(loader, interfaces);
            var1585BFE2B902F61A3216AC5F3A95D704_507670344.addTaint(taint);
            return var1585BFE2B902F61A3216AC5F3A95D704_507670344;
        } //End block
        catch (IllegalArgumentException e)
        {
            ClassNotFoundException var2D2F079A9C09E5E985932CCAFE8C1A20_8048501 = new ClassNotFoundException(e.toString(), e);
            var2D2F079A9C09E5E985932CCAFE8C1A20_8048501.addTaint(taint);
            throw var2D2F079A9C09E5E985932CCAFE8C1A20_8048501;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.591 -0400", hash_original_method = "11D3D467DA55FCE7098C1D9AB901525D", hash_generated_method = "D052593DDC3A09A6C365B5FA4370EACA")
    private int readNewHandle() throws IOException {
        int var45B24B25F8387CAC67C3944D89F2BC52_438608799 = (input.readInt());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_69359263 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_69359263;
        // ---------- Original Method ----------
        //return input.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.656 -0400", hash_original_method = "B0A36455F033DD06E1C6357D1966CB2A", hash_generated_method = "C5FB2ECAD0D4E124CEEB2930E7CB505B")
    private Object readNewObject(boolean unshared) throws OptionalDataException, ClassNotFoundException, IOException {
        addTaint(unshared);
        ObjectStreamClass classDesc = readClassDesc();
        if(classDesc == null)        
        {
            java.io.InvalidClassException varF0B669FE625FDCD2C0B7AFC2BF75622C_977676301 = missingClassDescriptor();
            varF0B669FE625FDCD2C0B7AFC2BF75622C_977676301.addTaint(taint);
            throw varF0B669FE625FDCD2C0B7AFC2BF75622C_977676301;
        } //End block
        int newHandle = nextHandle();
        Class<?> objectClass = classDesc.forClass();
        Object result = null;
        Object registeredResult = null;
        if(objectClass != null)        
        {
            result = classDesc.newInstance(objectClass);
            registerObjectRead(result, newHandle, unshared);
            registeredResult = result;
        } //End block
        else
        {
            result = null;
        } //End block
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
                } //End block
                if(mustResolve)                
                {
                    Externalizable extern = (Externalizable) result;
                    extern.readExternal(this);
                } //End block
                if(blockData)                
                {
                    discardData();
                } //End block
                else
                {
                    primitiveData = emptyStream;
                } //End block
            } //End block
            else
            {
                readHierarchy(result, classDesc);
            } //End block
        } //End block
        finally 
        {
            currentObject = null;
            currentClass = null;
        } //End block
        if(objectClass != null)        
        {
            if(classDesc.hasMethodReadResolve())            
            {
                Method methodReadResolve = classDesc.getMethodReadResolve();
                try 
                {
                    result = methodReadResolve.invoke(result, (Object[]) null);
                } //End block
                catch (IllegalAccessException ignored)
                {
                } //End block
                catch (InvocationTargetException ite)
                {
                    Throwable target = ite.getTargetException();
                    if(target instanceof ObjectStreamException)                    
                    {
                        ObjectStreamException var7968BE7E0F10658162994A62439F18E4_520590965 = (ObjectStreamException) target;
                        var7968BE7E0F10658162994A62439F18E4_520590965.addTaint(taint);
                        throw var7968BE7E0F10658162994A62439F18E4_520590965;
                    } //End block
                    else
                    if(target instanceof Error)                    
                    {
                        Error var157858306DB5AEA134A18315E8F156FF_1810370023 = (Error) target;
                        var157858306DB5AEA134A18315E8F156FF_1810370023.addTaint(taint);
                        throw var157858306DB5AEA134A18315E8F156FF_1810370023;
                    } //End block
                    else
                    {
                        RuntimeException varB680FC198DAE9443D5ED144016D19687_2948914 = (RuntimeException) target;
                        varB680FC198DAE9443D5ED144016D19687_2948914.addTaint(taint);
                        throw varB680FC198DAE9443D5ED144016D19687_2948914;
                    } //End block
                } //End block
            } //End block
        } //End block
        if(result != null && enableResolve)        
        {
            result = resolveObject(result);
        } //End block
        if(registeredResult != result)        
        {
            registerObjectRead(result, newHandle, unshared);
        } //End block
Object varDC838461EE2FA0CA4C9BBB70A15456B0_265654378 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_265654378.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_265654378;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.658 -0400", hash_original_method = "C5243F456C3574095BC1BB7FC2411373", hash_generated_method = "B05D8469D8148D5DE94270BDEC0F7DF8")
    private InvalidClassException missingClassDescriptor() throws InvalidClassException {
        InvalidClassException var16AEF1A56FF02F021CBAE9B5E423406F_713666397 = new InvalidClassException("Read null attempting to read class descriptor for object");
        var16AEF1A56FF02F021CBAE9B5E423406F_713666397.addTaint(taint);
        throw var16AEF1A56FF02F021CBAE9B5E423406F_713666397;
        // ---------- Original Method ----------
        //throw new InvalidClassException("Read null attempting to read class descriptor for object");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.658 -0400", hash_original_method = "CF984AE9FCCB80A5CA5459E50D42D99D", hash_generated_method = "F686BCBCC0C0F11182208F0CA3AE30FB")
    private Object readNewString(boolean unshared) throws IOException {
        addTaint(unshared);
        Object result = input.readUTF();
        if(enableResolve)        
        {
            result = resolveObject(result);
        } //End block
        registerObjectRead(result, nextHandle(), unshared);
Object varDC838461EE2FA0CA4C9BBB70A15456B0_920957768 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_920957768.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_920957768;
        // ---------- Original Method ----------
        //Object result = input.readUTF();
        //if (enableResolve) {
            //result = resolveObject(result);
        //}
        //registerObjectRead(result, nextHandle(), unshared);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.659 -0400", hash_original_method = "E3603577D9590FDF3626C23DB61D460D", hash_generated_method = "4A8B8406899E134C1A27B0441B7D2DEA")
    private Object readNewLongString(boolean unshared) throws IOException {
        addTaint(unshared);
        long length = input.readLong();
        Object result = input.decodeUTF((int) length);
        if(enableResolve)        
        {
            result = resolveObject(result);
        } //End block
        registerObjectRead(result, nextHandle(), unshared);
Object varDC838461EE2FA0CA4C9BBB70A15456B0_999201609 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_999201609.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_999201609;
        // ---------- Original Method ----------
        //long length = input.readLong();
        //Object result = input.decodeUTF((int) length);
        //if (enableResolve) {
            //result = resolveObject(result);
        //}
        //registerObjectRead(result, nextHandle(), unshared);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.659 -0400", hash_original_method = "D5CBFBA6D0DD1CCB325BD55A2992CB88", hash_generated_method = "6B73E668067C3C2ED55AD0298F8FF2AC")
    public final Object readObject() throws OptionalDataException,
            ClassNotFoundException, IOException {
Object varDE3D5D991D2299B852D7A4547F832BEB_1837320613 =         readObject(false);
        varDE3D5D991D2299B852D7A4547F832BEB_1837320613.addTaint(taint);
        return varDE3D5D991D2299B852D7A4547F832BEB_1837320613;
        // ---------- Original Method ----------
        //return readObject(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.660 -0400", hash_original_method = "B5062D634E2B9403462F68486501694A", hash_generated_method = "CB2F73F97CBF4A8C4DA9580D1F569695")
    public Object readUnshared() throws IOException, ClassNotFoundException {
Object var3EEAD4513E01D30FA2721A4D9868715E_465192769 =         readObject(true);
        var3EEAD4513E01D30FA2721A4D9868715E_465192769.addTaint(taint);
        return var3EEAD4513E01D30FA2721A4D9868715E_465192769;
        // ---------- Original Method ----------
        //return readObject(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.661 -0400", hash_original_method = "E655B580AAC2F65ED2F044289942F1C0", hash_generated_method = "6026BF4FA2FAA3B0EF3736697FDCE11B")
    private Object readObject(boolean unshared) throws OptionalDataException,
            ClassNotFoundException, IOException {
        addTaint(unshared);
        boolean restoreInput = (primitiveData == input);
        if(restoreInput)        
        {
            primitiveData = emptyStream;
        } //End block
        if(subclassOverridingImplementation && !unshared)        
        {
Object varC632220F2A11923B21DDE438738503BF_1577802240 =             readObjectOverride();
            varC632220F2A11923B21DDE438738503BF_1577802240.addTaint(taint);
            return varC632220F2A11923B21DDE438738503BF_1577802240;
        } //End block
        Object result;
        try 
        {
            if(++nestedLevels == 1)            
            {
                callerClassLoader = getClosestUserClassLoader();
            } //End block
            result = readNonPrimitiveContent(unshared);
            if(restoreInput)            
            {
                primitiveData = input;
            } //End block
        } //End block
        finally 
        {
            if(--nestedLevels == 0)            
            {
                callerClassLoader = null;
            } //End block
        } //End block
        if(nestedLevels == 0 && validations != null)        
        {
            try 
            {
for(InputValidationDesc element : validations)
                {
                    element.validator.validateObject();
                } //End block
            } //End block
            finally 
            {
                validations = null;
            } //End block
        } //End block
Object varDC838461EE2FA0CA4C9BBB70A15456B0_1267479013 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1267479013.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1267479013;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.662 -0400", hash_original_method = "F453836DFC9EEC175FFF65A0C41AF32F", hash_generated_method = "BC5A5FDE5C823D780A0A448B3FF85940")
    protected Object readObjectOverride() throws OptionalDataException,
            ClassNotFoundException, IOException {
        if(input == null)        
        {
Object var540C13E9E156B687226421B24F2DF178_1630271412 =             null;
            var540C13E9E156B687226421B24F2DF178_1630271412.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1630271412;
        } //End block
        IOException var1508E3FDF27FD56D4E1051DB16DE1816_707703652 = new IOException();
        var1508E3FDF27FD56D4E1051DB16DE1816_707703652.addTaint(taint);
        throw var1508E3FDF27FD56D4E1051DB16DE1816_707703652;
        // ---------- Original Method ----------
        //if (input == null) {
            //return null;
        //}
        //throw new IOException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.663 -0400", hash_original_method = "E1F1666A9CC2BCC43C42662EA935D779", hash_generated_method = "AD4DF43646E168B9ACBF0F85D76A1EC3")
    public short readShort() throws IOException {
        short varD72B35297BEA6797ABBE906C16AED5CF_1460792846 = (primitiveTypes.readShort());
                short var4F09DAA9D95BCB166A302407A0E0BABE_1429783145 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1429783145;
        // ---------- Original Method ----------
        //return primitiveTypes.readShort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.663 -0400", hash_original_method = "2E049C52CD4079E3EDC13878B612AD59", hash_generated_method = "3F59C2340FE1183E88A66E86337D3310")
    protected void readStreamHeader() throws IOException,
            StreamCorruptedException {
        if(input.readShort() == STREAM_MAGIC
                && input.readShort() == STREAM_VERSION)        
        {
            return;
        } //End block
        StreamCorruptedException varF5F96E25EF189AC41EAEE81D0E0B6F98_1605448550 = new StreamCorruptedException();
        varF5F96E25EF189AC41EAEE81D0E0B6F98_1605448550.addTaint(taint);
        throw varF5F96E25EF189AC41EAEE81D0E0B6F98_1605448550;
        // ---------- Original Method ----------
        //if (input.readShort() == STREAM_MAGIC
                //&& input.readShort() == STREAM_VERSION) {
            //return;
        //}
        //throw new StreamCorruptedException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.663 -0400", hash_original_method = "50996F70792020DA658FB7FFCF1EF910", hash_generated_method = "9479B0391DD051867915DDE07C32FD33")
    public int readUnsignedByte() throws IOException {
        int varE8E02E272FCA8E719DC246906D578BBA_599019472 = (primitiveTypes.readUnsignedByte());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1181700520 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1181700520;
        // ---------- Original Method ----------
        //return primitiveTypes.readUnsignedByte();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.663 -0400", hash_original_method = "ABA376385639B6CB8F725C68F1CED979", hash_generated_method = "46ACBB3F677468623AC7605AFD012299")
    public int readUnsignedShort() throws IOException {
        int varC84B1E38C1B4325F10B497EE61484BA2_1625878048 = (primitiveTypes.readUnsignedShort());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1309402468 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1309402468;
        // ---------- Original Method ----------
        //return primitiveTypes.readUnsignedShort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.664 -0400", hash_original_method = "B2994D3A3B821949D517613320FA5065", hash_generated_method = "C7FAB9F6C17DBC6D86615CB967CD1FFD")
    public String readUTF() throws IOException {
String var515CD0E98173FF2E73E38B6282E10FCE_1488120372 =         primitiveTypes.readUTF();
        var515CD0E98173FF2E73E38B6282E10FCE_1488120372.addTaint(taint);
        return var515CD0E98173FF2E73E38B6282E10FCE_1488120372;
        // ---------- Original Method ----------
        //return primitiveTypes.readUTF();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.664 -0400", hash_original_method = "10F65D1907C5AA72A1571FB08139A1C8", hash_generated_method = "9018A450E36A5EB2B0332AC4D1D6FEA2")
    private Object registeredObjectRead(int handle) throws InvalidObjectException {
        addTaint(handle);
        Object res = objectsRead.get(handle - ObjectStreamConstants.baseWireHandle);
        if(res == UNSHARED_OBJ)        
        {
            InvalidObjectException var13587A8E5C284E5D92F27437313A6A97_346623841 = new InvalidObjectException("Cannot read back reference to unshared object");
            var13587A8E5C284E5D92F27437313A6A97_346623841.addTaint(taint);
            throw var13587A8E5C284E5D92F27437313A6A97_346623841;
        } //End block
Object varB5053E025797B3BF768F5C37934C244D_456531465 =         res;
        varB5053E025797B3BF768F5C37934C244D_456531465.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_456531465;
        // ---------- Original Method ----------
        //Object res = objectsRead.get(handle - ObjectStreamConstants.baseWireHandle);
        //if (res == UNSHARED_OBJ) {
            //throw new InvalidObjectException("Cannot read back reference to unshared object");
        //}
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.664 -0400", hash_original_method = "9C8641A932863D3A6F3FA22233749F54", hash_generated_method = "4AF7A2152D423A8D8591669DAB8316B2")
    private void registerObjectRead(Object obj, int handle, boolean unshared) throws IOException {
        addTaint(unshared);
        addTaint(handle);
        addTaint(obj.getTaint());
        if(unshared)        
        {
            obj = UNSHARED_OBJ;
        } //End block
        int index = handle - ObjectStreamConstants.baseWireHandle;
        int size = objectsRead.size();
        while
(index > size)        
        {
            objectsRead.add(null);
            ++size;
        } //End block
        if(index == size)        
        {
            objectsRead.add(obj);
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.665 -0400", hash_original_method = "3EFB39BBE791BF6ED902F9D8BC5F60E3", hash_generated_method = "1A84DCD1F0FCB416EB455792BE4E86DD")
    public synchronized void registerValidation(ObjectInputValidation object,
            int priority) throws NotActiveException, InvalidObjectException {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(priority);
        addTaint(object.getTaint());
        Object instanceBeingRead = this.currentObject;
        if(instanceBeingRead == null && nestedLevels == 0)        
        {
            NotActiveException varFD1AAF3605EC866A6A8BBEC842DA8C8A_555699596 = new NotActiveException();
            varFD1AAF3605EC866A6A8BBEC842DA8C8A_555699596.addTaint(taint);
            throw varFD1AAF3605EC866A6A8BBEC842DA8C8A_555699596;
        } //End block
        if(object == null)        
        {
            InvalidObjectException var62544DC45AC18E0A4AD21936CBBDE9CA_26829939 = new InvalidObjectException("Callback object cannot be null");
            var62544DC45AC18E0A4AD21936CBBDE9CA_26829939.addTaint(taint);
            throw var62544DC45AC18E0A4AD21936CBBDE9CA_26829939;
        } //End block
        InputValidationDesc desc = new InputValidationDesc();
        desc.validator = object;
        desc.priority = priority;
        if(validations == null)        
        {
            validations = new InputValidationDesc[1];
            validations[0] = desc;
        } //End block
        else
        {
            int i = 0;
for(;i < validations.length;i++)
            {
                InputValidationDesc validation = validations[i];
                if(priority >= validation.priority)                
                {
                    break;
                } //End block
            } //End block
            InputValidationDesc[] oldValidations = validations;
            int currentSize = oldValidations.length;
            validations = new InputValidationDesc[currentSize + 1];
            System.arraycopy(oldValidations, 0, validations, 0, i);
            System.arraycopy(oldValidations, i, validations, i + 1, currentSize
                    - i);
            validations[i] = desc;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.666 -0400", hash_original_method = "7A01BA94C22B82138AACA44C7BC92DD9", hash_generated_method = "0C73C6216D604266ED6256169E691209")
    private void resetSeenObjects() {
        objectsRead = new ArrayList<Object>();
        nextHandle = baseWireHandle;
        primitiveData = emptyStream;
        // ---------- Original Method ----------
        //objectsRead = new ArrayList<Object>();
        //nextHandle = baseWireHandle;
        //primitiveData = emptyStream;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.666 -0400", hash_original_method = "356E50ACB0709EF4643021948AB5F291", hash_generated_method = "EC3D0E77128D57B1D4D0ED283DC54BAE")
    private void resetState() {
        resetSeenObjects();
        hasPushbackTC = false;
        pushbackTC = 0;
        // ---------- Original Method ----------
        //resetSeenObjects();
        //hasPushbackTC = false;
        //pushbackTC = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.667 -0400", hash_original_method = "38B51F7C504D6211D87B81513F39C956", hash_generated_method = "7F1CA949F02A0DBE692FF3131A9B226C")
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
            } //End block
        } //End block
Class<?> var51801364268DFB5B1361AB761C7278F7_1697790941 =         cls;
        var51801364268DFB5B1361AB761C7278F7_1697790941.addTaint(taint);
        return var51801364268DFB5B1361AB761C7278F7_1697790941;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.667 -0400", hash_original_method = "8BE1D9D2C1A8227AC3DEAA12C63F6442", hash_generated_method = "FA0822F8226C0D38C8AF7C6FFFC21CD3")
    protected Object resolveObject(Object object) throws IOException {
        addTaint(object.getTaint());
Object var6F3B27511D98F0E852A24482F031265F_539894577 =         object;
        var6F3B27511D98F0E852A24482F031265F_539894577.addTaint(taint);
        return var6F3B27511D98F0E852A24482F031265F_539894577;
        // ---------- Original Method ----------
        //return object;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.668 -0400", hash_original_method = "C18A3B861F9E4DC00DB6D8F86113E96E", hash_generated_method = "A239D9D884F98C24CAD76A2ED06C8B65")
    public int skipBytes(int length) throws IOException {
        addTaint(length);
        if(input == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_273199723 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_273199723.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_273199723;
        } //End block
        int offset = 0;
        while
(offset < length)        
        {
            checkReadPrimitiveTypes();
            long skipped = primitiveData.skip(length - offset);
            if(skipped == 0)            
            {
                int var7A86C157EE9713C34FBD7A1EE40F0C5A_317360045 = (offset);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1674976021 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1674976021;
            } //End block
            offset += (int) skipped;
        } //End block
        int var2FA47F7C65FEC19CC163B195725E3844_2056889831 = (length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_79059435 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_79059435;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.668 -0400", hash_original_method = "F18AA842F3AF8655FE4F963E8A31A757", hash_generated_method = "3E6FCDB61FFC5FD3C7994444D4FC712B")
    private void verifyAndInit(ObjectStreamClass loadedStreamClass) throws InvalidClassException {
        addTaint(loadedStreamClass.getTaint());
        Class<?> localClass = loadedStreamClass.forClass();
        ObjectStreamClass localStreamClass = ObjectStreamClass
                .lookupStreamClass(localClass);
        if(loadedStreamClass.getSerialVersionUID() != localStreamClass
                .getSerialVersionUID())        
        {
            InvalidClassException var0EDFE5275719243EF3AEA6E8E1A53E31_1371462349 = new InvalidClassException(loadedStreamClass.getName(),
                    "Incompatible class (SUID): " + loadedStreamClass +
                            " but expected " + localStreamClass);
            var0EDFE5275719243EF3AEA6E8E1A53E31_1371462349.addTaint(taint);
            throw var0EDFE5275719243EF3AEA6E8E1A53E31_1371462349;
        } //End block
        String loadedClassBaseName = getBaseName(loadedStreamClass.getName());
        String localClassBaseName = getBaseName(localStreamClass.getName());
        if(!loadedClassBaseName.equals(localClassBaseName))        
        {
            InvalidClassException var88E1F7CF7D103E08A757AC94DAB05723_1623626433 = new InvalidClassException(loadedStreamClass.getName(),
                    String.format("Incompatible class (base name): %s but expected %s",
                            loadedClassBaseName, localClassBaseName));
            var88E1F7CF7D103E08A757AC94DAB05723_1623626433.addTaint(taint);
            throw var88E1F7CF7D103E08A757AC94DAB05723_1623626433;
        } //End block
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.669 -0400", hash_original_field = "8D6C391E7CB39133C91B73281A24F21F", hash_generated_field = "59BAC1D70D65173C0176BF76148E5AB7")

        ObjectInputValidation validator;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.669 -0400", hash_original_field = "B988295C268025B49DFB3DF26171DDC3", hash_generated_field = "4AD9F2E37B35E313CD211FBAFDADA238")

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


        @DSModeled(DSC.SAFE)
        public abstract ObjectStreamClass getObjectStreamClass();

        
        @DSModeled(DSC.SAFE)
        public abstract boolean defaulted(String name) throws IOException,
                IllegalArgumentException;

        
        @DSModeled(DSC.SAFE)
        public abstract boolean get(String name, boolean defaultValue)
                throws IOException, IllegalArgumentException;

        
        @DSModeled(DSC.SAFE)
        public abstract char get(String name, char defaultValue)
                throws IOException, IllegalArgumentException;

        
        @DSModeled(DSC.SAFE)
        public abstract byte get(String name, byte defaultValue)
                throws IOException, IllegalArgumentException;

        
        @DSModeled(DSC.SAFE)
        public abstract short get(String name, short defaultValue)
                throws IOException, IllegalArgumentException;

        
        @DSModeled(DSC.SAFE)
        public abstract int get(String name, int defaultValue)
                throws IOException, IllegalArgumentException;

        
        @DSModeled(DSC.SAFE)
        public abstract long get(String name, long defaultValue)
                throws IOException, IllegalArgumentException;

        
        @DSModeled(DSC.SAFE)
        public abstract float get(String name, float defaultValue)
                throws IOException, IllegalArgumentException;

        
        @DSModeled(DSC.SAFE)
        public abstract double get(String name, double defaultValue)
                throws IOException, IllegalArgumentException;

        
        @DSModeled(DSC.SAFE)
        public abstract Object get(String name, Object defaultValue)
                throws IOException, IllegalArgumentException;

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.671 -0400", hash_original_field = "84E5CE7FC519663BA115DBD4D0C5A535", hash_generated_field = "AB31E5C2BA954217EF88CD850CFC8C65")

    private static final Object UNSHARED_OBJ = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.671 -0400", hash_original_field = "42768E4035EB7085BBD39A4E45389BDC", hash_generated_field = "CF28BF30867E0E1F6DF3B872782F2ED3")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.672 -0400", hash_original_field = "E29C7DCEE0BF15C29DD3EA56FC9F2AF1", hash_generated_field = "0BEDBBB2B96D03A03BECE92D911B88AD")

    private static final ClassLoader bootstrapLoader = Object.class.getClassLoader();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.672 -0400", hash_original_field = "89EBE3ECF326D242BB3DB8E1D4A3021B", hash_generated_field = "F543C6A7F69C1743531D486F7F24DDAE")

    private static final ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
}

