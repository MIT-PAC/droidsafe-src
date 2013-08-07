package java.io;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.760 -0400", hash_original_field = "993B80B15181215612E5959DB832BFAF", hash_generated_field = "123C8BF62BBC79B951F58B358976C3FF")

    private int nestedLevels;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.760 -0400", hash_original_field = "78E6221F6393D1356681DB398F14CE6D", hash_generated_field = "590E14C0A9F44251F0FB79AFE6C14C40")

    private DataOutputStream output;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.760 -0400", hash_original_field = "03DDC0A152AEFF5D5B68BBDEC321A200", hash_generated_field = "F1F4A3D364C39A7A9A580E729A07A6BB")

    private boolean enableReplace;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.760 -0400", hash_original_field = "8AFA05430C7155E00832EE4E25A1E3C4", hash_generated_field = "6BF0D260FF82B6C05AF71BF5A37B87B5")

    private DataOutputStream primitiveTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.761 -0400", hash_original_field = "7D062238F7FC2C195C068FDEA51EBB31", hash_generated_field = "C2484DFB497796B6143E78C11005E43D")

    private ByteArrayOutputStream primitiveTypesBuffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.761 -0400", hash_original_field = "7E94EA9D58B111BA23AC3FB428F74A83", hash_generated_field = "262F0B6D79DA047EE0A946998A1A0FC4")

    private SerializationHandleMap objectsWritten;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.761 -0400", hash_original_field = "C45E486F5C7342BCA6166748B65C5058", hash_generated_field = "C5955C97495D41B971B03A33B3C5833F")

    private int currentHandle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.761 -0400", hash_original_field = "895D2E18F5D2EA8F00F48DF2FB178E4D", hash_generated_field = "76736C274255A46E2AEB2CE593A1B428")

    private Object currentObject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.761 -0400", hash_original_field = "457C5912366BE090D6A2931DE14CDA9E", hash_generated_field = "7035F4B44BC3AE389D42445F7A5655AC")

    private ObjectStreamClass currentClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.761 -0400", hash_original_field = "E5EB1B1AE3E23C45B744E3125FC5B3E7", hash_generated_field = "12864838116848C83740597D611280DC")

    private int protocolVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.761 -0400", hash_original_field = "A5B4A58CBBF31F1191BB3A837E942322", hash_generated_field = "DC52C2D606BFFEEFCE39D0BD7D3DAA23")

    private StreamCorruptedException nestedException;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.761 -0400", hash_original_field = "082319488FBB4C6351DC6A16092AFAF8", hash_generated_field = "BAD28CAA59CF68A4E344ADB2A9F8D573")

    private EmulatedFieldsForDumping currentPutField;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.762 -0400", hash_original_field = "35C5D5BAEC9DA39A210149CA5A667705", hash_generated_field = "3690401F10D38FF2C8AB1C19B641B107")

    private boolean subclassOverridingImplementation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.762 -0400", hash_original_field = "D72F32CD409B6D11024B4617D66F549C", hash_generated_field = "A52DE6D705A0478FBD8E858BFAC127CD")

    private final ObjectStreamClass proxyClassDesc = ObjectStreamClass.lookup(Proxy.class);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.762 -0400", hash_original_method = "EA89A37EA944EE797F4A4E71C06BB807", hash_generated_method = "1DD7286A5E2A9A1C12E3BB1E02964B00")
    protected  ObjectOutputStream() throws IOException {
        this.subclassOverridingImplementation = true;
        // ---------- Original Method ----------
        //this.subclassOverridingImplementation = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.764 -0400", hash_original_method = "C3742BF53888E5C7E36BAC1682B0BA91", hash_generated_method = "ADB47BA9803E2B0CD7AB1B1691A42C1B")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.765 -0400", hash_original_method = "2EE844E85177CE8B8519EE788449061C", hash_generated_method = "1E11D11D51E0154BB7749FEDA5280BAF")
    protected void annotateClass(Class<?> aClass) throws IOException {
        addTaint(aClass.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.766 -0400", hash_original_method = "6D36FCC856EE4705ED65F6105201ADD2", hash_generated_method = "A5E98127E91E49198B235D1BD1806995")
    protected void annotateProxyClass(Class<?> aClass) throws IOException {
        addTaint(aClass.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.767 -0400", hash_original_method = "73D4A72122980F7DB50B81D978D62054", hash_generated_method = "7BC88DA2FC424BF1D3283579C5461406")
    private void checkWritePrimitiveTypes() {
        if(primitiveTypes == null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.767 -0400", hash_original_method = "29115934C3EAEF8AC600D579304D0581", hash_generated_method = "F0440CBBA87C0B5AF39639A20DAAA699")
    @Override
    public void close() throws IOException {
        flush();
        output.close();
        // ---------- Original Method ----------
        //flush();
        //output.close();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.768 -0400", hash_original_method = "75FABBE0CA8F03B34490087B8F17BDC1", hash_generated_method = "70B8FCB927EA2A43EC259740055018B9")
    private void computePutField() {
        currentPutField = new EmulatedFieldsForDumping(this, currentClass);
        // ---------- Original Method ----------
        //currentPutField = new EmulatedFieldsForDumping(this, currentClass);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.768 -0400", hash_original_method = "F6C293AC5437F7F079C554EABDD8D443", hash_generated_method = "6927D2675696649F5EF2245ED8AAE2F7")
    public void defaultWriteObject() throws IOException {
        if(currentObject == null)        
        {
            NotActiveException varFD1AAF3605EC866A6A8BBEC842DA8C8A_563783792 = new NotActiveException();
            varFD1AAF3605EC866A6A8BBEC842DA8C8A_563783792.addTaint(taint);
            throw varFD1AAF3605EC866A6A8BBEC842DA8C8A_563783792;
        } //End block
        writeFieldValues(currentObject, currentClass);
        // ---------- Original Method ----------
        //if (currentObject == null) {
            //throw new NotActiveException();
        //}
        //writeFieldValues(currentObject, currentClass);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.769 -0400", hash_original_method = "A89FD6C60365B1028CEBCCFC3106EF9A", hash_generated_method = "F0301CB4FE39D1E484CDC34733E39ADA")
    protected void drain() throws IOException {
        if(primitiveTypes == null || primitiveTypesBuffer == null)        
        {
            return;
        } //End block
        int offset = 0;
        byte[] written = primitiveTypesBuffer.toByteArray();
        while
(offset < written.length)        
        {
            int toWrite = written.length - offset > 1024 ? 1024
                    : written.length - offset;
            if(toWrite < 256)            
            {
                output.writeByte(TC_BLOCKDATA);
                output.writeByte((byte) toWrite);
            } //End block
            else
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.770 -0400", hash_original_method = "3C81D15CCFEF1BE19C0E53EB7F3B0380", hash_generated_method = "26E3F3C561B434FE5EBC64F1985E7065")
    private int dumpCycle(Object obj) throws IOException {
        addTaint(obj.getTaint());
        int handle = objectsWritten.get(obj);
        if(handle != -1)        
        {
            writeCyclicReference(handle);
            int varE1260894F59EEAE98C8440899DE4DF8D_2006732928 = (handle);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1915541930 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1915541930;
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_736226697 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_294096962 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_294096962;
        // ---------- Original Method ----------
        //int handle = objectsWritten.get(obj);
        //if (handle != -1) {
            //writeCyclicReference(handle);
            //return handle;
        //}
        //return -1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.772 -0400", hash_original_method = "7186A696463687F53D4FA37D2BB9631D", hash_generated_method = "30089637E835C679592FC9FE5C80DFE0")
    protected boolean enableReplaceObject(boolean enable) {
        boolean originalValue = enableReplace;
        enableReplace = enable;
        boolean var48A7AAFD2093A2CFD7C2A6E0C39C3B3C_1429996120 = (originalValue);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1165492704 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1165492704;
        // ---------- Original Method ----------
        //boolean originalValue = enableReplace;
        //enableReplace = enable;
        //return originalValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.772 -0400", hash_original_method = "117A95892DAF31A0926F2E917E5208CF", hash_generated_method = "D7617F4AFE8FFDEE4B1014AA8B651BC6")
    @Override
    public void flush() throws IOException {
        drain();
        output.flush();
        // ---------- Original Method ----------
        //drain();
        //output.flush();
    }

    
    @DSModeled(DSC.SAFE)
    private static Object getFieldL(Object instance, Class<?> declaringClass, String fieldName, String fieldTypeName) {
    	return new Object();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.773 -0400", hash_original_method = "3E8C44E06770B18C136965DDB10C163B", hash_generated_method = "3595F9A93971D02E7A7E60F2C362E8EE")
    private int nextHandle() {
        int var57D4F29AF80AE42B0D9EED2C0C55E152_1159074498 = (currentHandle++);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1799828601 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1799828601;
        // ---------- Original Method ----------
        //return currentHandle++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.774 -0400", hash_original_method = "4F3CF2DA9583C39D0A0D02BEFFFE8C29", hash_generated_method = "EA9662FC7D7895A2EDC533E135AEEE16")
    public PutField putFields() throws IOException {
        if(currentObject == null)        
        {
            NotActiveException varFD1AAF3605EC866A6A8BBEC842DA8C8A_1664070608 = new NotActiveException();
            varFD1AAF3605EC866A6A8BBEC842DA8C8A_1664070608.addTaint(taint);
            throw varFD1AAF3605EC866A6A8BBEC842DA8C8A_1664070608;
        } //End block
        if(currentPutField == null)        
        {
            computePutField();
        } //End block
PutField var86DE5DDDFAC8CCFE25956F12D10EF898_1161408148 =         currentPutField;
        var86DE5DDDFAC8CCFE25956F12D10EF898_1161408148.addTaint(taint);
        return var86DE5DDDFAC8CCFE25956F12D10EF898_1161408148;
        // ---------- Original Method ----------
        //if (currentObject == null) {
            //throw new NotActiveException();
        //}
        //if (currentPutField == null) {
            //computePutField();
        //}
        //return currentPutField;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.775 -0400", hash_original_method = "6CA6FC4D83D22ECC70837B9572B0E8EA", hash_generated_method = "F8F78FE3E2E464D3F20AB12E24658D47")
    private int registerObjectWritten(Object obj) {
        addTaint(obj.getTaint());
        int handle = nextHandle();
        objectsWritten.put(obj, handle);
        int varE1260894F59EEAE98C8440899DE4DF8D_698151480 = (handle);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1213771542 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1213771542;
        // ---------- Original Method ----------
        //int handle = nextHandle();
        //objectsWritten.put(obj, handle);
        //return handle;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.776 -0400", hash_original_method = "37FD060D4B2DB7C3EC8F52EA51C77D72", hash_generated_method = "449FCBF04421F43CC8015189B431E28B")
    private void removeUnsharedReference(Object obj, int previousHandle) {
        addTaint(previousHandle);
        addTaint(obj.getTaint());
        if(previousHandle != -1)        
        {
            objectsWritten.put(obj, previousHandle);
        } //End block
        else
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.776 -0400", hash_original_method = "C1DF94E02684AF79BBD267850463E92A", hash_generated_method = "CE0D5F450A67660DF4AC5744A26C6E27")
    protected Object replaceObject(Object object) throws IOException {
        addTaint(object.getTaint());
Object var6F3B27511D98F0E852A24482F031265F_1391424214 =         object;
        var6F3B27511D98F0E852A24482F031265F_1391424214.addTaint(taint);
        return var6F3B27511D98F0E852A24482F031265F_1391424214;
        // ---------- Original Method ----------
        //return object;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.777 -0400", hash_original_method = "4FDA9D292F9CB60FE54E9147043F29DF", hash_generated_method = "6D8F2E55E577BC7432D57217289F254D")
    public void reset() throws IOException {
        drain();
        output.writeByte(TC_RESET);
        resetState();
        // ---------- Original Method ----------
        //drain();
        //output.writeByte(TC_RESET);
        //resetState();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.777 -0400", hash_original_method = "CB42E7CB8763CADF528182B203F4731A", hash_generated_method = "D96F2EB71665704EA1C136EB6CF94503")
    private void resetSeenObjects() {
        objectsWritten = new SerializationHandleMap();
        currentHandle = baseWireHandle;
        // ---------- Original Method ----------
        //objectsWritten = new SerializationHandleMap();
        //currentHandle = baseWireHandle;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.778 -0400", hash_original_method = "27ED7D7B38D4C22EF7056E4BAF81440E", hash_generated_method = "30020D9976D36222FB26C8D68A57D7B1")
    private void resetState() {
        resetSeenObjects();
        nestedLevels = 0;
        // ---------- Original Method ----------
        //resetSeenObjects();
        //nestedLevels = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.778 -0400", hash_original_method = "899849124785B3DAA2410A481AC243A4", hash_generated_method = "2B86BD4EDF8C16B449F65326D394EC16")
    public void useProtocolVersion(int version) throws IOException {
        if(!objectsWritten.isEmpty())        
        {
            IllegalStateException var7765E315ADDC37C4D0C8D1926655B5BC_1946578166 = new IllegalStateException("Cannot set protocol version when stream in use");
            var7765E315ADDC37C4D0C8D1926655B5BC_1946578166.addTaint(taint);
            throw var7765E315ADDC37C4D0C8D1926655B5BC_1946578166;
        } //End block
        if(version != ObjectStreamConstants.PROTOCOL_VERSION_1
                && version != ObjectStreamConstants.PROTOCOL_VERSION_2)        
        {
            IllegalArgumentException var2C2330824CE6FC7D74FD680FF519F2ED_1275041747 = new IllegalArgumentException("Unknown protocol: " + version);
            var2C2330824CE6FC7D74FD680FF519F2ED_1275041747.addTaint(taint);
            throw var2C2330824CE6FC7D74FD680FF519F2ED_1275041747;
        } //End block
        protocolVersion = version;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.779 -0400", hash_original_method = "4335176A8BF0CB76C8983C14BE755AB0", hash_generated_method = "9B4CDDCA0882D4C6970F115215C97727")
    @Override
    public void write(byte[] buffer, int offset, int length) throws IOException {
        addTaint(length);
        addTaint(offset);
        addTaint(buffer[0]);
        checkWritePrimitiveTypes();
        primitiveTypes.write(buffer, offset, length);
        // ---------- Original Method ----------
        //checkWritePrimitiveTypes();
        //primitiveTypes.write(buffer, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.779 -0400", hash_original_method = "890E7ADC76A0934752F791BA928637BD", hash_generated_method = "5B96B782E8FCDD76A317B7BD628AB59A")
    @Override
    public void write(int value) throws IOException {
        addTaint(value);
        checkWritePrimitiveTypes();
        primitiveTypes.write(value);
        // ---------- Original Method ----------
        //checkWritePrimitiveTypes();
        //primitiveTypes.write(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.780 -0400", hash_original_method = "253E21281D84BB4AEC7BC00A39E22928", hash_generated_method = "8CAC5304C0CDBD84D1BCBA7169694EB2")
    public void writeBoolean(boolean value) throws IOException {
        addTaint(value);
        checkWritePrimitiveTypes();
        primitiveTypes.writeBoolean(value);
        // ---------- Original Method ----------
        //checkWritePrimitiveTypes();
        //primitiveTypes.writeBoolean(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.780 -0400", hash_original_method = "DCBF5513EE5F9BB37CF570D282A66C5E", hash_generated_method = "69409C00C521E6C82339F7718DEBB028")
    public void writeByte(int value) throws IOException {
        addTaint(value);
        checkWritePrimitiveTypes();
        primitiveTypes.writeByte(value);
        // ---------- Original Method ----------
        //checkWritePrimitiveTypes();
        //primitiveTypes.writeByte(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.781 -0400", hash_original_method = "2FD9E25E34EBC831C98FBB1774A09056", hash_generated_method = "5D30D16BFF32CE724391E85ACF5F7FEA")
    public void writeBytes(String value) throws IOException {
        addTaint(value.getTaint());
        checkWritePrimitiveTypes();
        primitiveTypes.writeBytes(value);
        // ---------- Original Method ----------
        //checkWritePrimitiveTypes();
        //primitiveTypes.writeBytes(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.781 -0400", hash_original_method = "A70BC61472A0A40B7DA1B300459E269C", hash_generated_method = "B7D05BD58607411C8B50732D83B6DD20")
    public void writeChar(int value) throws IOException {
        addTaint(value);
        checkWritePrimitiveTypes();
        primitiveTypes.writeChar(value);
        // ---------- Original Method ----------
        //checkWritePrimitiveTypes();
        //primitiveTypes.writeChar(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.782 -0400", hash_original_method = "2819E1113D5EFA42F2CF8A185C5FE232", hash_generated_method = "06F7BFDC7C6E8E72DE6A17282CE7AA7F")
    public void writeChars(String value) throws IOException {
        addTaint(value.getTaint());
        checkWritePrimitiveTypes();
        primitiveTypes.writeChars(value);
        // ---------- Original Method ----------
        //checkWritePrimitiveTypes();
        //primitiveTypes.writeChars(value);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.783 -0400", hash_original_method = "D6DF6A35D187C3B8A220F04225A24DB7", hash_generated_method = "88E788A159A39C741F5EBA7ACBCDAA49")
    private int writeClassDesc(ObjectStreamClass classDesc, boolean unshared) throws IOException {
        addTaint(unshared);
        addTaint(classDesc.getTaint());
        if(classDesc == null)        
        {
            writeNull();
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1447167913 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_147139965 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_147139965;
        } //End block
        int handle = -1;
        if(!unshared)        
        {
            handle = dumpCycle(classDesc);
        } //End block
        if(handle == -1)        
        {
            Class<?> classToWrite = classDesc.forClass();
            int previousHandle = -1;
            if(unshared)            
            {
                previousHandle = objectsWritten.get(classDesc);
            } //End block
            handle = registerObjectWritten(classDesc);
            if(classDesc.isProxy())            
            {
                output.writeByte(TC_PROXYCLASSDESC);
                Class<?>[] interfaces = classToWrite.getInterfaces();
                output.writeInt(interfaces.length);
for(int i = 0;i < interfaces.length;i++)
                {
                    output.writeUTF(interfaces[i].getName());
                } //End block
                annotateProxyClass(classToWrite);
                output.writeByte(TC_ENDBLOCKDATA);
                writeClassDesc(proxyClassDesc, false);
                if(unshared)                
                {
                    removeUnsharedReference(classDesc, previousHandle);
                } //End block
                int varE1260894F59EEAE98C8440899DE4DF8D_1061393487 = (handle);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1673014709 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1673014709;
            } //End block
            output.writeByte(TC_CLASSDESC);
            if(protocolVersion == PROTOCOL_VERSION_1)            
            {
                writeNewClassDesc(classDesc);
            } //End block
            else
            {
                primitiveTypes = output;
                writeClassDescriptor(classDesc);
                primitiveTypes = null;
            } //End block
            annotateClass(classToWrite);
            drain();
            output.writeByte(TC_ENDBLOCKDATA);
            writeClassDesc(classDesc.getSuperclass(), unshared);
            if(unshared)            
            {
                removeUnsharedReference(classDesc, previousHandle);
            } //End block
        } //End block
        int varE1260894F59EEAE98C8440899DE4DF8D_687053042 = (handle);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1238238996 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1238238996;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.784 -0400", hash_original_method = "6CD4D6A26A6EE5C2333CE9BAD2D29100", hash_generated_method = "95932DEC37E9EB8E67965C46571549F3")
    private void writeCyclicReference(int handle) throws IOException {
        addTaint(handle);
        output.writeByte(TC_REFERENCE);
        output.writeInt(handle);
        // ---------- Original Method ----------
        //output.writeByte(TC_REFERENCE);
        //output.writeInt(handle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.784 -0400", hash_original_method = "02DC35912BAFF16550D8FBDB82DDCD50", hash_generated_method = "22166A12BB1098C29D619E1302902915")
    public void writeDouble(double value) throws IOException {
        addTaint(value);
        checkWritePrimitiveTypes();
        primitiveTypes.writeDouble(value);
        // ---------- Original Method ----------
        //checkWritePrimitiveTypes();
        //primitiveTypes.writeDouble(value);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.784 -0400", hash_original_method = "8DAE1373FC5F31DAE45B98A018C14CB9", hash_generated_method = "83370FA3FAC58C780CD8C898245E1317")
    private void writeFieldDescriptors(ObjectStreamClass classDesc, boolean externalizable) throws IOException {
        addTaint(externalizable);
        addTaint(classDesc.getTaint());
        Class<?> loadedClass = classDesc.forClass();
        ObjectStreamField[] fields = null;
        int fieldCount = 0;
        if(!externalizable && loadedClass != ObjectStreamClass.STRINGCLASS)        
        {
            fields = classDesc.fields();
            fieldCount = fields.length;
        } //End block
        output.writeShort(fieldCount);
for(int i = 0;i < fieldCount;i++)
        {
            ObjectStreamField f = fields[i];
            boolean wasPrimitive = f.writeField(output);
            if(!wasPrimitive)            
            {
                writeObject(f.getTypeString());
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.784 -0400", hash_original_method = "851EC9DCB527C64AF85B9AAA86ABFF43", hash_generated_method = "58ADED738C75D67503016246780F0D1A")
    public void writeFields() throws IOException {
        if(currentPutField == null)        
        {
            NotActiveException varFD1AAF3605EC866A6A8BBEC842DA8C8A_1830674043 = new NotActiveException();
            varFD1AAF3605EC866A6A8BBEC842DA8C8A_1830674043.addTaint(taint);
            throw varFD1AAF3605EC866A6A8BBEC842DA8C8A_1830674043;
        } //End block
        writeFieldValues(currentPutField);
        // ---------- Original Method ----------
        //if (currentPutField == null) {
            //throw new NotActiveException();
        //}
        //writeFieldValues(currentPutField);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.785 -0400", hash_original_method = "97B3D4C0A2A3E17C88F2E6B51B15BF4C", hash_generated_method = "0D204E9E8DCFA57167B1A3D05ECB74F1")
    private void writeFieldValues(EmulatedFieldsForDumping emulatedFields) throws IOException {
        addTaint(emulatedFields.getTaint());
        EmulatedFields accessibleSimulatedFields = emulatedFields.emulatedFields();
for(EmulatedFields.ObjectSlot slot : accessibleSimulatedFields.slots())
        {
            Object fieldValue = slot.getFieldValue();
            Class<?> type = slot.getField().getType();
            if(type == int.class)            
            {
                output.writeInt(fieldValue != null ? ((Integer) fieldValue).intValue() : 0);
            } //End block
            else
            if(type == byte.class)            
            {
                output.writeByte(fieldValue != null ? ((Byte) fieldValue).byteValue() : 0);
            } //End block
            else
            if(type == char.class)            
            {
                output.writeChar(fieldValue != null ? ((Character) fieldValue).charValue() : 0);
            } //End block
            else
            if(type == short.class)            
            {
                output.writeShort(fieldValue != null ? ((Short) fieldValue).shortValue() : 0);
            } //End block
            else
            if(type == boolean.class)            
            {
                output.writeBoolean(fieldValue != null ? ((Boolean) fieldValue).booleanValue() : false);
            } //End block
            else
            if(type == long.class)            
            {
                output.writeLong(fieldValue != null ? ((Long) fieldValue).longValue() : 0);
            } //End block
            else
            if(type == float.class)            
            {
                output.writeFloat(fieldValue != null ? ((Float) fieldValue).floatValue() : 0);
            } //End block
            else
            if(type == double.class)            
            {
                output.writeDouble(fieldValue != null ? ((Double) fieldValue).doubleValue() : 0);
            } //End block
            else
            {
                writeObject(fieldValue);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.787 -0400", hash_original_method = "3B2F054C3660B4FEDDE0689C3B0D847B", hash_generated_method = "63B4A0801ADC8F515E61BAC2ECFEFB72")
    private void writeFieldValues(Object obj, ObjectStreamClass classDesc) throws IOException {
        addTaint(classDesc.getTaint());
        addTaint(obj.getTaint());
for(ObjectStreamField fieldDesc : classDesc.fields())
        {
            try 
            {
                Class<?> type = fieldDesc.getTypeInternal();
                Field field = classDesc.getReflectionField(fieldDesc);
                if(field == null)                
                {
                    InvalidClassException var959A4CD6DB4B9D4C61265A5D57384767_2106801819 = new InvalidClassException(classDesc.getName() + " doesn't have a field " + fieldDesc.getName() + " of type " + type);
                    var959A4CD6DB4B9D4C61265A5D57384767_2106801819.addTaint(taint);
                    throw var959A4CD6DB4B9D4C61265A5D57384767_2106801819;
                } //End block
                if(type == byte.class)                
                {
                    output.writeByte(field.getByte(obj));
                } //End block
                else
                if(type == char.class)                
                {
                    output.writeChar(field.getChar(obj));
                } //End block
                else
                if(type == double.class)                
                {
                    output.writeDouble(field.getDouble(obj));
                } //End block
                else
                if(type == float.class)                
                {
                    output.writeFloat(field.getFloat(obj));
                } //End block
                else
                if(type == int.class)                
                {
                    output.writeInt(field.getInt(obj));
                } //End block
                else
                if(type == long.class)                
                {
                    output.writeLong(field.getLong(obj));
                } //End block
                else
                if(type == short.class)                
                {
                    output.writeShort(field.getShort(obj));
                } //End block
                else
                if(type == boolean.class)                
                {
                    output.writeBoolean(field.getBoolean(obj));
                } //End block
                else
                {
                    Object objField = field.get(obj);
                    if(fieldDesc.isUnshared())                    
                    {
                        writeUnshared(objField);
                    } //End block
                    else
                    {
                        writeObject(objField);
                    } //End block
                } //End block
            } //End block
            catch (IllegalAccessException iae)
            {
                AssertionError varB7184EDFD8CA9CD0B66958C2AD057E9E_1873335388 = new AssertionError(iae);
                varB7184EDFD8CA9CD0B66958C2AD057E9E_1873335388.addTaint(taint);
                throw varB7184EDFD8CA9CD0B66958C2AD057E9E_1873335388;
            } //End block
            catch (NoSuchFieldError nsf)
            {
                InvalidClassException var6031130457F46DBF90EF9BC7665E3732_65246746 = new InvalidClassException(classDesc.getName());
                var6031130457F46DBF90EF9BC7665E3732_65246746.addTaint(taint);
                throw var6031130457F46DBF90EF9BC7665E3732_65246746;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.788 -0400", hash_original_method = "2F0CF28A5E4A8655D2779BA683FB03E5", hash_generated_method = "C9E52F02DF487292E2BDCFC805813F24")
    public void writeFloat(float value) throws IOException {
        addTaint(value);
        checkWritePrimitiveTypes();
        primitiveTypes.writeFloat(value);
        // ---------- Original Method ----------
        //checkWritePrimitiveTypes();
        //primitiveTypes.writeFloat(value);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.789 -0400", hash_original_method = "6C93D0A9BF9141DB46D3843027575223", hash_generated_method = "1D2F86038B2B923A7159945B7E30DB03")
    private void writeHierarchy(Object object, ObjectStreamClass classDesc) throws IOException, NotActiveException {
        addTaint(classDesc.getTaint());
        if(object == null)        
        {
            NotActiveException varFD1AAF3605EC866A6A8BBEC842DA8C8A_186555574 = new NotActiveException();
            varFD1AAF3605EC866A6A8BBEC842DA8C8A_186555574.addTaint(taint);
            throw varFD1AAF3605EC866A6A8BBEC842DA8C8A_186555574;
        } //End block
        List<ObjectStreamClass> hierarchy = classDesc.getHierarchy();
for(int i = 0, end = hierarchy.size();i < end;++i)
        {
            ObjectStreamClass osc = hierarchy.get(i);
            currentObject = object;
            currentClass = osc;
            try 
            {
                boolean executed = false;
                if(osc.hasMethodWriteObject())                
                {
                    final Method method = osc.getMethodWriteObject();
                    try 
                    {
                        method.invoke(object, new Object[] { this });
                        executed = true;
                    } //End block
                    catch (InvocationTargetException e)
                    {
                        Throwable ex = e.getTargetException();
                        if(ex instanceof RuntimeException)                        
                        {
                            RuntimeException varF0C2DBE52270DD4B45A7073A4B8A4F8C_1150344774 = (RuntimeException) ex;
                            varF0C2DBE52270DD4B45A7073A4B8A4F8C_1150344774.addTaint(taint);
                            throw varF0C2DBE52270DD4B45A7073A4B8A4F8C_1150344774;
                        } //End block
                        else
                        if(ex instanceof Error)                        
                        {
                            Error var5088E1E74327DBB15F7148041BB4E6E0_393181549 = (Error) ex;
                            var5088E1E74327DBB15F7148041BB4E6E0_393181549.addTaint(taint);
                            throw var5088E1E74327DBB15F7148041BB4E6E0_393181549;
                        } //End block
                        IOException var3F32687BA78654886C8AE6DEBD282711_18919715 = (IOException) ex;
                        var3F32687BA78654886C8AE6DEBD282711_18919715.addTaint(taint);
                        throw var3F32687BA78654886C8AE6DEBD282711_18919715;
                    } //End block
                    catch (IllegalAccessException e)
                    {
                        RuntimeException var7731B7FAF9DB516E410EE38D728795B2_848361959 = new RuntimeException(e.toString());
                        var7731B7FAF9DB516E410EE38D728795B2_848361959.addTaint(taint);
                        throw var7731B7FAF9DB516E410EE38D728795B2_848361959;
                    } //End block
                } //End block
                if(executed)                
                {
                    drain();
                    output.writeByte(TC_ENDBLOCKDATA);
                } //End block
                else
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.789 -0400", hash_original_method = "4D560E72502C61E130F3258421731401", hash_generated_method = "22EAF1C15ECB615519CEB9A162DD980D")
    public void writeInt(int value) throws IOException {
        addTaint(value);
        checkWritePrimitiveTypes();
        primitiveTypes.writeInt(value);
        // ---------- Original Method ----------
        //checkWritePrimitiveTypes();
        //primitiveTypes.writeInt(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.789 -0400", hash_original_method = "1C4CA2BE4C70907161A2CF485CB22A3E", hash_generated_method = "9A388AA854DE83D2410EC71D7F756A5C")
    public void writeLong(long value) throws IOException {
        addTaint(value);
        checkWritePrimitiveTypes();
        primitiveTypes.writeLong(value);
        // ---------- Original Method ----------
        //checkWritePrimitiveTypes();
        //primitiveTypes.writeLong(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.790 -0400", hash_original_method = "6EA4BE49540BA12319B9F5CA997917E6", hash_generated_method = "5DF56850713322E102AC5F27C9EB26CD")
    private int writeNewArray(Object array, Class<?> arrayClass, ObjectStreamClass arrayClDesc,
            Class<?> componentType, boolean unshared) throws IOException {
        addTaint(unshared);
        addTaint(componentType.getTaint());
        addTaint(arrayClDesc.getTaint());
        addTaint(arrayClass.getTaint());
        addTaint(array.getTaint());
        output.writeByte(TC_ARRAY);
        writeClassDesc(arrayClDesc, false);
        int handle = nextHandle();
        if(!unshared)        
        {
            objectsWritten.put(array, handle);
        } //End block
        if(componentType.isPrimitive())        
        {
            if(componentType == int.class)            
            {
                int[] intArray = (int[]) array;
                output.writeInt(intArray.length);
for(int i = 0;i < intArray.length;i++)
                {
                    output.writeInt(intArray[i]);
                } //End block
            } //End block
            else
            if(componentType == byte.class)            
            {
                byte[] byteArray = (byte[]) array;
                output.writeInt(byteArray.length);
                output.write(byteArray, 0, byteArray.length);
            } //End block
            else
            if(componentType == char.class)            
            {
                char[] charArray = (char[]) array;
                output.writeInt(charArray.length);
for(int i = 0;i < charArray.length;i++)
                {
                    output.writeChar(charArray[i]);
                } //End block
            } //End block
            else
            if(componentType == short.class)            
            {
                short[] shortArray = (short[]) array;
                output.writeInt(shortArray.length);
for(int i = 0;i < shortArray.length;i++)
                {
                    output.writeShort(shortArray[i]);
                } //End block
            } //End block
            else
            if(componentType == boolean.class)            
            {
                boolean[] booleanArray = (boolean[]) array;
                output.writeInt(booleanArray.length);
for(int i = 0;i < booleanArray.length;i++)
                {
                    output.writeBoolean(booleanArray[i]);
                } //End block
            } //End block
            else
            if(componentType == long.class)            
            {
                long[] longArray = (long[]) array;
                output.writeInt(longArray.length);
for(int i = 0;i < longArray.length;i++)
                {
                    output.writeLong(longArray[i]);
                } //End block
            } //End block
            else
            if(componentType == float.class)            
            {
                float[] floatArray = (float[]) array;
                output.writeInt(floatArray.length);
for(int i = 0;i < floatArray.length;i++)
                {
                    output.writeFloat(floatArray[i]);
                } //End block
            } //End block
            else
            if(componentType == double.class)            
            {
                double[] doubleArray = (double[]) array;
                output.writeInt(doubleArray.length);
for(int i = 0;i < doubleArray.length;i++)
                {
                    output.writeDouble(doubleArray[i]);
                } //End block
            } //End block
            else
            {
                InvalidClassException var31A50C63276484733643EAF66E9F6D21_268315908 = new InvalidClassException("Wrong base type in " + arrayClass.getName());
                var31A50C63276484733643EAF66E9F6D21_268315908.addTaint(taint);
                throw var31A50C63276484733643EAF66E9F6D21_268315908;
            } //End block
        } //End block
        else
        {
            Object[] objectArray = (Object[]) array;
            output.writeInt(objectArray.length);
for(int i = 0;i < objectArray.length;i++)
            {
                writeObject(objectArray[i]);
            } //End block
        } //End block
        int varE1260894F59EEAE98C8440899DE4DF8D_2017567694 = (handle);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1102297039 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1102297039;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.790 -0400", hash_original_method = "EFEEB16087FF4E0EE92685A5C26C0D2A", hash_generated_method = "0571C594D3FC2D341143FC22529C4222")
    private int writeNewClass(Class<?> object, boolean unshared) throws IOException {
        addTaint(unshared);
        addTaint(object.getTaint());
        output.writeByte(TC_CLASS);
        ObjectStreamClass clDesc = ObjectStreamClass.lookupStreamClass(object);
        if(clDesc.isEnum())        
        {
            writeEnumDesc(object, clDesc, unshared);
        } //End block
        else
        {
            writeClassDesc(clDesc, unshared);
        } //End block
        int handle = nextHandle();
        if(!unshared)        
        {
            objectsWritten.put(object, handle);
        } //End block
        int varE1260894F59EEAE98C8440899DE4DF8D_205648497 = (handle);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1060001275 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1060001275;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.791 -0400", hash_original_method = "8ED9B25450E87C39655806C7FB3946F8", hash_generated_method = "AB9F3019B7C45D1620521BB9B40BEE0A")
    private void writeNewClassDesc(ObjectStreamClass classDesc) throws IOException {
        addTaint(classDesc.getTaint());
        output.writeUTF(classDesc.getName());
        output.writeLong(classDesc.getSerialVersionUID());
        byte flags = classDesc.getFlags();
        boolean externalizable = classDesc.isExternalizable();
        if(externalizable)        
        {
            if(protocolVersion == PROTOCOL_VERSION_1)            
            {
                flags &= NOT_SC_BLOCK_DATA;
            } //End block
            else
            {
                flags |= SC_BLOCK_DATA;
            } //End block
        } //End block
        output.writeByte(flags);
        if((SC_ENUM | SC_SERIALIZABLE) != classDesc.getFlags())        
        {
            writeFieldDescriptors(classDesc, externalizable);
        } //End block
        else
        {
            output.writeShort(0);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.791 -0400", hash_original_method = "641338D73905B8D6D3FE171A8894AADC", hash_generated_method = "48A87AE7A333B9B38CA2F6B25437DF67")
    protected void writeClassDescriptor(ObjectStreamClass classDesc) throws IOException {
        addTaint(classDesc.getTaint());
        writeNewClassDesc(classDesc);
        // ---------- Original Method ----------
        //writeNewClassDesc(classDesc);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.791 -0400", hash_original_method = "E088B51B3D25E92C7A08790C12EA9546", hash_generated_method = "3A70A7ADA906D718086371ED05AE76DF")
    private void writeNewException(Exception ex) throws IOException {
        addTaint(ex.getTaint());
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.791 -0400", hash_original_method = "AD17E67664AB2CFE5D575A9D2DBC90D0", hash_generated_method = "C8CC1C5366BA1DC39CC7C85914EC2D6C")
    private int writeNewObject(Object object, Class<?> theClass, ObjectStreamClass clDesc,
            boolean unshared) throws IOException {
        addTaint(unshared);
        addTaint(theClass.getTaint());
        EmulatedFieldsForDumping originalCurrentPutField = currentPutField;
        currentPutField = null;
        boolean externalizable = clDesc.isExternalizable();
        boolean serializable = clDesc.isSerializable();
        if(!externalizable && !serializable)        
        {
            NotSerializableException var7C81718231C8BB08A8EA8FE49949E64F_1246244255 = new NotSerializableException(theClass.getName());
            var7C81718231C8BB08A8EA8FE49949E64F_1246244255.addTaint(taint);
            throw var7C81718231C8BB08A8EA8FE49949E64F_1246244255;
        } //End block
        output.writeByte(TC_OBJECT);
        writeClassDesc(clDesc, false);
        int previousHandle = -1;
        if(unshared)        
        {
            previousHandle = objectsWritten.get(object);
        } //End block
        int handle = registerObjectWritten(object);
        currentObject = object;
        currentClass = clDesc;
        try 
        {
            if(externalizable)            
            {
                boolean noBlockData = protocolVersion == PROTOCOL_VERSION_1;
                if(noBlockData)                
                {
                    primitiveTypes = output;
                } //End block
                ((Externalizable) object).writeExternal(this);
                if(noBlockData)                
                {
                    primitiveTypes = null;
                } //End block
                else
                {
                    drain();
                    output.writeByte(TC_ENDBLOCKDATA);
                } //End block
            } //End block
            else
            {
                writeHierarchy(object, currentClass);
            } //End block
        } //End block
        finally 
        {
            if(unshared)            
            {
                removeUnsharedReference(object, previousHandle);
            } //End block
            currentObject = null;
            currentClass = null;
            currentPutField = originalCurrentPutField;
        } //End block
        int varE1260894F59EEAE98C8440899DE4DF8D_1063503214 = (handle);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1482067550 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1482067550;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.792 -0400", hash_original_method = "BE97C7FA5FB694719D79A72C051D442C", hash_generated_method = "5115D9EBD9107B1D18C7076D7D9C275F")
    private int writeNewString(String object, boolean unshared) throws IOException {
        addTaint(unshared);
        addTaint(object.getTaint());
        long count = ModifiedUtf8.countBytes(object, false);
        byte[] buffer;
        int offset = 0;
        if(count <= 0xffff)        
        {
            buffer = new byte[1 + SizeOf.SHORT + (int) count];
            buffer[offset++] = TC_STRING;
            Memory.pokeShort(buffer, offset, (short) count, ByteOrder.BIG_ENDIAN);
            offset += SizeOf.SHORT;
        } //End block
        else
        {
            buffer = new byte[1 + SizeOf.LONG + (int) count];
            buffer[offset++] = TC_LONGSTRING;
            Memory.pokeLong(buffer, offset, count, ByteOrder.BIG_ENDIAN);
            offset += SizeOf.LONG;
        } //End block
        ModifiedUtf8.encode(buffer, offset, object);
        output.write(buffer, 0, buffer.length);
        int handle = nextHandle();
        if(!unshared)        
        {
            objectsWritten.put(object, handle);
        } //End block
        int varE1260894F59EEAE98C8440899DE4DF8D_1782451051 = (handle);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_537978146 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_537978146;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.792 -0400", hash_original_method = "631D52D34CFE4ABBA41E943E2B7FB044", hash_generated_method = "0225D06056772581205A957FAFF48550")
    private void writeNull() throws IOException {
        output.writeByte(TC_NULL);
        // ---------- Original Method ----------
        //output.writeByte(TC_NULL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.792 -0400", hash_original_method = "D65EE5B0FE82553B53FE321A403242DE", hash_generated_method = "1AD8F0335DD7B10E7BCF51E59808E29D")
    public final void writeObject(Object object) throws IOException {
        addTaint(object.getTaint());
        writeObject(object, false);
        // ---------- Original Method ----------
        //writeObject(object, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.792 -0400", hash_original_method = "21591331F2C6632F1308070B9A9FAC52", hash_generated_method = "A30260E62FC06953F362FEAD59CCD637")
    public void writeUnshared(Object object) throws IOException {
        addTaint(object.getTaint());
        writeObject(object, true);
        // ---------- Original Method ----------
        //writeObject(object, true);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.792 -0400", hash_original_method = "6135D4458B19CC3120CAE3855FF2BEA8", hash_generated_method = "AA56E97F8AD12B32C5AA1D70EC9AA65F")
    private void writeObject(Object object, boolean unshared) throws IOException {
        addTaint(unshared);
        addTaint(object.getTaint());
        boolean setOutput = (primitiveTypes == output);
        if(setOutput)        
        {
            primitiveTypes = null;
        } //End block
        if(subclassOverridingImplementation && !unshared)        
        {
            writeObjectOverride(object);
            return;
        } //End block
        try 
        {
            drain();
            writeObjectInternal(object, unshared, true, true);
            if(setOutput)            
            {
                primitiveTypes = output;
            } //End block
        } //End block
        catch (IOException ioEx1)
        {
            if(nestedLevels == 0 && ioEx1 != nestedException)            
            {
                try 
                {
                    writeNewException(ioEx1);
                } //End block
                catch (IOException ioEx2)
                {
                    nestedException.fillInStackTrace();
                    nestedException.addTaint(taint);
                    throw nestedException;
                } //End block
            } //End block
            ioEx1.addTaint(taint);
            throw ioEx1;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.793 -0400", hash_original_method = "AD80A9CFC14D0263A7F0CECDD085D8B1", hash_generated_method = "AAAFA6AE28AC502B6ADB474FF59AEAE7")
    private int writeObjectInternal(Object object, boolean unshared,
            boolean computeClassBasedReplacement,
            boolean computeStreamReplacement) throws IOException {
        addTaint(computeStreamReplacement);
        addTaint(computeClassBasedReplacement);
        addTaint(unshared);
        addTaint(object.getTaint());
        if(object == null)        
        {
            writeNull();
            int var6BB61E3B7BCE0931DA574D19D1D82C88_372862621 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1162440869 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1162440869;
        } //End block
        int handle = -1;
        if(!unshared)        
        {
            handle = dumpCycle(object);
            if(handle != -1)            
            {
                int varE1260894F59EEAE98C8440899DE4DF8D_3388104 = (handle);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1222682243 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1222682243;
            } //End block
        } //End block
        Class<?> objClass = object.getClass();
        ObjectStreamClass clDesc = ObjectStreamClass.lookupStreamClass(objClass);
        nestedLevels++;
        try 
        {
            if(!(enableReplace && computeStreamReplacement))            
            {
                if(objClass == ObjectStreamClass.CLASSCLASS)                
                {
                    int var4DDDD2A9D839C023FF5D7863CEC16017_1759804284 = (writeNewClass((Class<?>) object, unshared));
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_113386358 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_113386358;
                } //End block
                if(objClass == ObjectStreamClass.OBJECTSTREAMCLASSCLASS)                
                {
                    int varFB47DAE28E69ABC0CD3D17E0B162FB25_1317407664 = (writeClassDesc((ObjectStreamClass) object, unshared));
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1906671136 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1906671136;
                } //End block
            } //End block
            if(clDesc.isSerializable() && computeClassBasedReplacement)            
            {
                if(clDesc.hasMethodWriteReplace())                
                {
                    Method methodWriteReplace = clDesc.getMethodWriteReplace();
                    Object replObj = null;
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
                        Throwable target = ite.getTargetException();
                        if(target instanceof ObjectStreamException)                        
                        {
                            ObjectStreamException var7968BE7E0F10658162994A62439F18E4_1708248493 = (ObjectStreamException) target;
                            var7968BE7E0F10658162994A62439F18E4_1708248493.addTaint(taint);
                            throw var7968BE7E0F10658162994A62439F18E4_1708248493;
                        } //End block
                        else
                        if(target instanceof Error)                        
                        {
                            Error var157858306DB5AEA134A18315E8F156FF_1325197278 = (Error) target;
                            var157858306DB5AEA134A18315E8F156FF_1325197278.addTaint(taint);
                            throw var157858306DB5AEA134A18315E8F156FF_1325197278;
                        } //End block
                        else
                        {
                            RuntimeException varB680FC198DAE9443D5ED144016D19687_1966780605 = (RuntimeException) target;
                            varB680FC198DAE9443D5ED144016D19687_1966780605.addTaint(taint);
                            throw varB680FC198DAE9443D5ED144016D19687_1966780605;
                        } //End block
                    } //End block
                    if(replObj != object)                    
                    {
                        int replacementHandle = writeObjectInternal(replObj, false, false,
                                computeStreamReplacement);
                        if(replacementHandle != -1)                        
                        {
                            objectsWritten.put(object, replacementHandle);
                        } //End block
                        int var92E2DDBCA159ED83C83F92EBEC895F66_302797260 = (replacementHandle);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_60165917 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_60165917;
                    } //End block
                } //End block
            } //End block
            if(enableReplace && computeStreamReplacement)            
            {
                Object streamReplacement = replaceObject(object);
                if(streamReplacement != object)                
                {
                    int replacementHandle = writeObjectInternal(streamReplacement, false,
                            computeClassBasedReplacement, false);
                    if(replacementHandle != -1)                    
                    {
                        objectsWritten.put(object, replacementHandle);
                    } //End block
                    int var92E2DDBCA159ED83C83F92EBEC895F66_1952649074 = (replacementHandle);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1925417582 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1925417582;
                } //End block
            } //End block
            if(objClass == ObjectStreamClass.CLASSCLASS)            
            {
                int var4DDDD2A9D839C023FF5D7863CEC16017_114534949 = (writeNewClass((Class<?>) object, unshared));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1325407067 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1325407067;
            } //End block
            if(objClass == ObjectStreamClass.OBJECTSTREAMCLASSCLASS)            
            {
                int varFB47DAE28E69ABC0CD3D17E0B162FB25_1864867655 = (writeClassDesc((ObjectStreamClass) object, unshared));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_852445168 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_852445168;
            } //End block
            if(objClass == ObjectStreamClass.STRINGCLASS)            
            {
                int var7817154C4162151E286AFFAE200EC8DC_2053387708 = (writeNewString((String) object, unshared));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_209861816 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_209861816;
            } //End block
            if(objClass.isArray())            
            {
                int varE50077A30B088EB72E473B4A7FC00436_165236733 = (writeNewArray(object, objClass, clDesc, objClass
                        .getComponentType(), unshared));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_322687568 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_322687568;
            } //End block
            if(object instanceof Enum)            
            {
                int var9CF8D76DED57E85003BF1A8A08613F7A_1361994538 = (writeNewEnum(object, objClass, unshared));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2103101972 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2103101972;
            } //End block
            int varA30A25D20B7BEAF6A7017491C020256A_1241270932 = (writeNewObject(object, objClass, clDesc, unshared));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1356275985 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1356275985;
        } //End block
        finally 
        {
            nestedLevels--;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.794 -0400", hash_original_method = "23E7E12F7C58661823B132165D2AB697", hash_generated_method = "9765A16246E28A7933336DC7ACBFFB56")
    private ObjectStreamClass writeEnumDesc(Class<?> theClass, ObjectStreamClass classDesc, boolean unshared) throws IOException {
        addTaint(unshared);
        addTaint(classDesc.getTaint());
        addTaint(theClass.getTaint());
        classDesc.setFlags((byte) (SC_SERIALIZABLE | SC_ENUM));
        int previousHandle = -1;
        if(unshared)        
        {
            previousHandle = objectsWritten.get(classDesc);
        } //End block
        int handle = -1;
        if(!unshared)        
        {
            handle = dumpCycle(classDesc);
        } //End block
        if(handle == -1)        
        {
            Class<?> classToWrite = classDesc.forClass();
            registerObjectWritten(classDesc);
            output.writeByte(TC_CLASSDESC);
            if(protocolVersion == PROTOCOL_VERSION_1)            
            {
                writeNewClassDesc(classDesc);
            } //End block
            else
            {
                primitiveTypes = output;
                writeClassDescriptor(classDesc);
                primitiveTypes = null;
            } //End block
            annotateClass(classToWrite);
            drain();
            output.writeByte(TC_ENDBLOCKDATA);
            ObjectStreamClass superClassDesc = classDesc.getSuperclass();
            if(superClassDesc != null)            
            {
                superClassDesc.setFlags((byte) (SC_SERIALIZABLE | SC_ENUM));
                writeEnumDesc(superClassDesc.forClass(), superClassDesc, unshared);
            } //End block
            else
            {
                output.writeByte(TC_NULL);
            } //End block
            if(unshared)            
            {
                removeUnsharedReference(classDesc, previousHandle);
            } //End block
        } //End block
ObjectStreamClass var3497C6F192F17384DEAA3543897C005A_1952026876 =         classDesc;
        var3497C6F192F17384DEAA3543897C005A_1952026876.addTaint(taint);
        return var3497C6F192F17384DEAA3543897C005A_1952026876;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.794 -0400", hash_original_method = "C81760408EA928607A5B6FF41AD80929", hash_generated_method = "7BB329F33B0EBA9E51FB8190C30BB015")
    private int writeNewEnum(Object object, Class<?> theClass, boolean unshared) throws IOException {
        addTaint(unshared);
        addTaint(theClass.getTaint());
        addTaint(object.getTaint());
        EmulatedFieldsForDumping originalCurrentPutField = currentPutField;
        currentPutField = null;
        output.writeByte(TC_ENUM);
        while
(theClass != null && !theClass.isEnum())        
        {
            theClass = theClass.getSuperclass();
        } //End block
        ObjectStreamClass classDesc = ObjectStreamClass.lookup(theClass);
        writeEnumDesc(theClass, classDesc, unshared);
        int previousHandle = -1;
        if(unshared)        
        {
            previousHandle = objectsWritten.get(object);
        } //End block
        int handle = registerObjectWritten(object);
        ObjectStreamField[] fields = classDesc.getSuperclass().fields();
        if(fields != null && fields.length > 1)        
        {
            Field field = classDesc.getSuperclass().getReflectionField(fields[1]);
            if(field == null)            
            {
                NoSuchFieldError var82A9A823976A9F4E5F2C2C27BF246445_2064834016 = new NoSuchFieldError();
                var82A9A823976A9F4E5F2C2C27BF246445_2064834016.addTaint(taint);
                throw var82A9A823976A9F4E5F2C2C27BF246445_2064834016;
            } //End block
            try 
            {
                String str = (String) field.get(object);
                int strHandle = -1;
                if(!unshared)                
                {
                    strHandle = dumpCycle(str);
                } //End block
                if(strHandle == -1)                
                {
                    writeNewString(str, unshared);
                } //End block
            } //End block
            catch (IllegalAccessException iae)
            {
                AssertionError varB7184EDFD8CA9CD0B66958C2AD057E9E_1411709091 = new AssertionError(iae);
                varB7184EDFD8CA9CD0B66958C2AD057E9E_1411709091.addTaint(taint);
                throw varB7184EDFD8CA9CD0B66958C2AD057E9E_1411709091;
            } //End block
        } //End block
        if(unshared)        
        {
            removeUnsharedReference(object, previousHandle);
        } //End block
        currentPutField = originalCurrentPutField;
        int varE1260894F59EEAE98C8440899DE4DF8D_817161507 = (handle);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_73108012 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_73108012;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.794 -0400", hash_original_method = "10EDB7023EA5060FBBA4CCA483056F88", hash_generated_method = "1C605B5513B52CA15BE4741CD0F7E92E")
    protected void writeObjectOverride(Object object) throws IOException {
        addTaint(object.getTaint());
        if(!subclassOverridingImplementation)        
        {
            IOException var1508E3FDF27FD56D4E1051DB16DE1816_1077741140 = new IOException();
            var1508E3FDF27FD56D4E1051DB16DE1816_1077741140.addTaint(taint);
            throw var1508E3FDF27FD56D4E1051DB16DE1816_1077741140;
        } //End block
        // ---------- Original Method ----------
        //if (!subclassOverridingImplementation) {
            //throw new IOException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.795 -0400", hash_original_method = "F969E0C742AA855339F3D16852D29508", hash_generated_method = "5D7B85EAD6ACC1E36FC30B56513B933F")
    public void writeShort(int value) throws IOException {
        addTaint(value);
        checkWritePrimitiveTypes();
        primitiveTypes.writeShort(value);
        // ---------- Original Method ----------
        //checkWritePrimitiveTypes();
        //primitiveTypes.writeShort(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.795 -0400", hash_original_method = "EEF09F25018D316A37E59FEE3B6D335C", hash_generated_method = "D8A4DBD12CAE08FEEAB12FDF55E7C0A4")
    protected void writeStreamHeader() throws IOException {
        output.writeShort(STREAM_MAGIC);
        output.writeShort(STREAM_VERSION);
        // ---------- Original Method ----------
        //output.writeShort(STREAM_MAGIC);
        //output.writeShort(STREAM_VERSION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.795 -0400", hash_original_method = "BDFE9F98A4288C3F1994A443E4A70C5E", hash_generated_method = "43C0401506821F4A7C1662CF4F916CE0")
    public void writeUTF(String value) throws IOException {
        addTaint(value.getTaint());
        checkWritePrimitiveTypes();
        primitiveTypes.writeUTF(value);
        // ---------- Original Method ----------
        //checkWritePrimitiveTypes();
        //primitiveTypes.writeUTF(value);
    }

    
    public static abstract class PutField {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.795 -0400", hash_original_method = "132782D29A7095A05BCF82A07EC6676D", hash_generated_method = "132782D29A7095A05BCF82A07EC6676D")
        public PutField ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        public abstract void put(String name, boolean value);

        
        @DSModeled(DSC.SAFE)
        public abstract void put(String name, char value);

        
        @DSModeled(DSC.SAFE)
        public abstract void put(String name, byte value);

        
        @DSModeled(DSC.SAFE)
        public abstract void put(String name, short value);

        
        @DSModeled(DSC.SAFE)
        public abstract void put(String name, int value);

        
        @DSModeled(DSC.SAFE)
        public abstract void put(String name, long value);

        
        @DSModeled(DSC.SAFE)
        public abstract void put(String name, float value);

        
        @DSModeled(DSC.SAFE)
        public abstract void put(String name, double value);

        
        @DSModeled(DSC.SAFE)
        public abstract void put(String name, Object value);

        
        @DSModeled(DSC.SAFE)
        @Deprecated
public abstract void write(ObjectOutput out) throws IOException;

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.796 -0400", hash_original_field = "6ECD027B3A61FCBD003A2EAA6DF5AF89", hash_generated_field = "EDEC464CFF602399479B5323240F3B9A")

    private static final Class<?>[] WRITE_UNSHARED_PARAM_TYPES = new Class[] { Object.class };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.796 -0400", hash_original_field = "417EE143C8F455BA5CE89255A39DCCAE", hash_generated_field = "94B8CE0A3BE191EC240D9518A5C28538")

    private static final byte NOT_SC_BLOCK_DATA = (byte) (SC_BLOCK_DATA ^ 0xFF);
}

