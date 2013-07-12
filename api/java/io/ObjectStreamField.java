package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Comparator;

public class ObjectStreamField implements Comparable<Object> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.456 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.458 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "E8909FCC8837B5FE7A3CBA40C0098CCB")

    private Object type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.460 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "B7E810BF01B52122CB927525A0CA4721")

    int offset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.461 -0400", hash_original_field = "EB43610BFF4BF58AA2AF0BA56299D57A", hash_generated_field = "A6469B3C05A6E61AD188C77E4C87AFA0")

    private String typeString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.463 -0400", hash_original_field = "962FA027E49514EF42DADB2095E8C618", hash_generated_field = "1925D0B4ADBD655AA714AC16DE1F0973")

    private boolean unshared;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.464 -0400", hash_original_field = "08F60B1F77A7ECFDC92540AF3E6C2887", hash_generated_field = "B10B376FF3C60E9314732C46A8CA6340")

    private boolean isDeserialized;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.465 -0400", hash_original_method = "0D657EDEC08CB18117CF62EC578D6020", hash_generated_method = "0413E92610E7EAD9E6C0B865D0B5458E")
    public  ObjectStreamField(String name, Class<?> cl) {
    if(name == null || cl == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_742662848 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_742662848.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_742662848;
        } //End block
        this.name = name;
        this.type = new WeakReference<Class<?>>(cl);
        // ---------- Original Method ----------
        //if (name == null || cl == null) {
            //throw new NullPointerException();
        //}
        //this.name = name;
        //this.type = new WeakReference<Class<?>>(cl);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.467 -0400", hash_original_method = "B329D182B18083287B5598787B9BCF42", hash_generated_method = "158583491F477B63A8808916EB504465")
    public  ObjectStreamField(String name, Class<?> cl, boolean unshared) {
    if(name == null || cl == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1677059018 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1677059018.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1677059018;
        } //End block
        this.name = name;
        this.type = (cl.getClassLoader() == null) ? cl : new WeakReference<Class<?>>(cl);
        this.unshared = unshared;
        // ---------- Original Method ----------
        //if (name == null || cl == null) {
            //throw new NullPointerException();
        //}
        //this.name = name;
        //this.type = (cl.getClassLoader() == null) ? cl : new WeakReference<Class<?>>(cl);
        //this.unshared = unshared;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.468 -0400", hash_original_method = "7045B1DBF21073AA43E994CE221E4094", hash_generated_method = "08FAD1B52FAA1A6A8F4C18859E6D7A5D")
      ObjectStreamField(String signature, String name) {
    if(name == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_957725000 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_957725000.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_957725000;
        } //End block
        this.name = name;
        this.typeString = signature.replace('.', '/').intern();
        defaultResolve();
        this.isDeserialized = true;
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new NullPointerException();
        //}
        //this.name = name;
        //this.typeString = signature.replace('.', '/').intern();
        //defaultResolve();
        //this.isDeserialized = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.469 -0400", hash_original_method = "11ADA6ED2A991966CB49663045730556", hash_generated_method = "E712A7F3D44F13A42932E442CC333DF9")
    public int compareTo(Object o) {
        addTaint(o.getTaint());
        ObjectStreamField f = (ObjectStreamField) o;
        boolean thisPrimitive = this.isPrimitive();
        boolean fPrimitive = f.isPrimitive();
    if(thisPrimitive != fPrimitive)        
        {
            int varDAB1FF22EBF07ADC6E4F9CF0E5A2D91D_1590867044 = (thisPrimitive ? -1 : 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1935506350 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1935506350;
        } //End block
        int var26898C4A1F7593B62E9891383065F061_1485826501 = (this.getName().compareTo(f.getName()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_214615974 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_214615974;
        // ---------- Original Method ----------
        //ObjectStreamField f = (ObjectStreamField) o;
        //boolean thisPrimitive = this.isPrimitive();
        //boolean fPrimitive = f.isPrimitive();
        //if (thisPrimitive != fPrimitive) {
            //return thisPrimitive ? -1 : 1;
        //}
        //return this.getName().compareTo(f.getName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.470 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "71472DEA8BBFB3F86500262FE3A8EA81")
    public String getName() {
String varB017984728AC60AD1F0BF8734F33F15C_421061607 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_421061607.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_421061607;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.470 -0400", hash_original_method = "ACEB13DAA855070296BA592FB1ADADA1", hash_generated_method = "0C5899BEC78978E01AD0225BEE47FDDE")
    public int getOffset() {
        int var7A86C157EE9713C34FBD7A1EE40F0C5A_570423487 = (offset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1829780450 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1829780450;
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.471 -0400", hash_original_method = "FF08482EB56AA685DDAE41A39E334998", hash_generated_method = "36F1B67A40911402B4A6EA25591207BF")
     Class<?> getTypeInternal() {
    if(type instanceof WeakReference)        
        {
Class<?> var20EC7C7A75D568B19BB2D841DD2CBD17_293541118 =             (Class<?>) ((WeakReference<?>) type).get();
            var20EC7C7A75D568B19BB2D841DD2CBD17_293541118.addTaint(taint);
            return var20EC7C7A75D568B19BB2D841DD2CBD17_293541118;
        } //End block
Class<?> var4585A728AFBCEE57D35F6001ECD82EAF_1408559426 =         (Class<?>) type;
        var4585A728AFBCEE57D35F6001ECD82EAF_1408559426.addTaint(taint);
        return var4585A728AFBCEE57D35F6001ECD82EAF_1408559426;
        // ---------- Original Method ----------
        //if (type instanceof WeakReference) {
            //return (Class<?>) ((WeakReference<?>) type).get();
        //}
        //return (Class<?>) type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.472 -0400", hash_original_method = "9634509EF2A12286AE62950CEFC0E304", hash_generated_method = "ECA58AC24FE4FDEE3880375B09DA4C02")
    public Class<?> getType() {
        Class<?> cl = getTypeInternal();
    if(isDeserialized && !cl.isPrimitive())        
        {
Class<?> var3D4686B2FADA55BD47A8E0853700CA45_1210726760 =             Object.class;
            var3D4686B2FADA55BD47A8E0853700CA45_1210726760.addTaint(taint);
            return var3D4686B2FADA55BD47A8E0853700CA45_1210726760;
        } //End block
Class<?> var8C6A66A89969D061B1ECE468EDE00B0A_96135295 =         cl;
        var8C6A66A89969D061B1ECE468EDE00B0A_96135295.addTaint(taint);
        return var8C6A66A89969D061B1ECE468EDE00B0A_96135295;
        // ---------- Original Method ----------
        //Class<?> cl = getTypeInternal();
        //if (isDeserialized && !cl.isPrimitive()) {
            //return Object.class;
        //}
        //return cl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.473 -0400", hash_original_method = "6C03FA17A8A9EDC07915A4F462B31BC8", hash_generated_method = "1BA177B37B8576BE87F07B69341E0EEC")
    public char getTypeCode() {
        char var43EFEAF95577F8DDC10B9CD1AB86DD46_363601031 = (typeCodeOf(getTypeInternal()));
                char varA87DEB01C5F539E6BDA34829C8EF2368_607056503 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_607056503;
        // ---------- Original Method ----------
        //return typeCodeOf(getTypeInternal());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.476 -0400", hash_original_method = "1261A37E9B201158D41DADA58D3D498E", hash_generated_method = "8227035B8FC767C743BC9054B5E32C1D")
    private char typeCodeOf(Class<?> type) {
        addTaint(type.getTaint());
    if(type == int.class)        
        {
            char var3F823ADCFD48AD4956FF832E927AE9D8_1190526674 = ('I');
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1565230201 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1565230201;
        } //End block
        else
    if(type == byte.class)        
        {
            char varAE87D173F10578174F8EC1A3EB2EFDD4_761316158 = ('B');
                        char varA87DEB01C5F539E6BDA34829C8EF2368_954616547 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_954616547;
        } //End block
        else
    if(type == char.class)        
        {
            char var4E8F5B084D1D2D0DBB92E85D8098FC1F_677737371 = ('C');
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1920601754 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1920601754;
        } //End block
        else
    if(type == short.class)        
        {
            char var21B05C586D183CDACD570B1765EA75F2_1833330907 = ('S');
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1893477095 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1893477095;
        } //End block
        else
    if(type == boolean.class)        
        {
            char var3472269E25D3B2573CD87D44EBA875D9_41391406 = ('Z');
                        char varA87DEB01C5F539E6BDA34829C8EF2368_166918206 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_166918206;
        } //End block
        else
    if(type == long.class)        
        {
            char var1D71EF54F324EB9089AFB895C47C382F_2059127675 = ('J');
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1940479434 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1940479434;
        } //End block
        else
    if(type == float.class)        
        {
            char varCA2BFEC9449E8D4AFE6AB5497D6B4144_1023595500 = ('F');
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1978600445 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1978600445;
        } //End block
        else
    if(type == double.class)        
        {
            char var943CFAB3F15FA8B743A942EBDD8CBF49_872285037 = ('D');
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1175314910 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1175314910;
        } //End block
        else
    if(type.isArray())        
        {
            char varAC425FCC80C8FDC2F15CB0BCE227ABB0_532115780 = ('[');
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1351357944 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1351357944;
        } //End block
        else
        {
            char var90914D7B476BD5CC07F17FD4CF48E49C_131643843 = ('L');
                        char varA87DEB01C5F539E6BDA34829C8EF2368_237508896 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_237508896;
        } //End block
        // ---------- Original Method ----------
        //if (type == int.class) {
            //return 'I';
        //} else if (type == byte.class) {
            //return 'B';
        //} else if (type == char.class) {
            //return 'C';
        //} else if (type == short.class) {
            //return 'S';
        //} else if (type == boolean.class) {
            //return 'Z';
        //} else if (type == long.class) {
            //return 'J';
        //} else if (type == float.class) {
            //return 'F';
        //} else if (type == double.class) {
            //return 'D';
        //} else if (type.isArray()) {
            //return '[';
        //} else {
            //return 'L';
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.477 -0400", hash_original_method = "AF834EA72E67DF4239AA5209B5DE5F81", hash_generated_method = "8024FAA79577FDA6BC5251521E3B60BA")
    public String getTypeString() {
    if(isPrimitive())        
        {
String var540C13E9E156B687226421B24F2DF178_1226915314 =             null;
            var540C13E9E156B687226421B24F2DF178_1226915314.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1226915314;
        } //End block
    if(typeString == null)        
        {
            Class<?> t = getTypeInternal();
            String typeName = t.getName().replace('.', '/');
            String str = (t.isArray()) ? typeName : ("L" + typeName + ';');
            typeString = str.intern();
        } //End block
String var7A85238CD32275F0BFF675D89BABBB30_1821854435 =         typeString;
        var7A85238CD32275F0BFF675D89BABBB30_1821854435.addTaint(taint);
        return var7A85238CD32275F0BFF675D89BABBB30_1821854435;
        // ---------- Original Method ----------
        //if (isPrimitive()) {
            //return null;
        //}
        //if (typeString == null) {
            //Class<?> t = getTypeInternal();
            //String typeName = t.getName().replace('.', '/');
            //String str = (t.isArray()) ? typeName : ("L" + typeName + ';');
            //typeString = str.intern();
        //}
        //return typeString;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.478 -0400", hash_original_method = "109BC8E5B51BF330504215C17ADD6478", hash_generated_method = "DCF3C21E792B348A59544CFB58553D57")
    public boolean isPrimitive() {
        Class<?> t = getTypeInternal();
        boolean var6BE37865E76F958F60A690B6B4337DD8_1599620195 = (t != null && t.isPrimitive());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1714303324 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1714303324;
        // ---------- Original Method ----------
        //Class<?> t = getTypeInternal();
        //return t != null && t.isPrimitive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.479 -0400", hash_original_method = "6EE925571D11CA9854483CD43D60AA5F", hash_generated_method = "C63725AE05CCBE83A81535148356DD0A")
     boolean writeField(DataOutputStream out) throws IOException {
        addTaint(out.getTaint());
        Class<?> t = getTypeInternal();
        out.writeByte(typeCodeOf(t));
        out.writeUTF(name);
        boolean var62582580B8D28C6B494EDCFB63E1761A_1226182952 = ((t != null && t.isPrimitive()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_21412047 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_21412047;
        // ---------- Original Method ----------
        //Class<?> t = getTypeInternal();
        //out.writeByte(typeCodeOf(t));
        //out.writeUTF(name);
        //return (t != null && t.isPrimitive());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.480 -0400", hash_original_method = "7A66A074CFBB1A834E24DFB5B3A643D5", hash_generated_method = "4305F7EB15B8D74A66017D2CC764F457")
    protected void setOffset(int newValue) {
        this.offset = newValue;
        // ---------- Original Method ----------
        //this.offset = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.480 -0400", hash_original_method = "ABFAE4540EC552EECBD4679559074925", hash_generated_method = "1758E5707771F956DA346AB726383FC4")
    @Override
    public String toString() {
String var1C1258DA98EFE38BC9C2501509B2FF42_2049635888 =         this.getClass().getName() + '(' + getName() + ':' + getTypeInternal() + ')';
        var1C1258DA98EFE38BC9C2501509B2FF42_2049635888.addTaint(taint);
        return var1C1258DA98EFE38BC9C2501509B2FF42_2049635888;
        // ---------- Original Method ----------
        //return this.getClass().getName() + '(' + getName() + ':' + getTypeInternal() + ')';
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.481 -0400", hash_original_method = "48E3281BF72BF66E5E96F9E4056E97FC", hash_generated_method = "32D00F1C806E34AAC93FBAF8E3FC5E7F")
     void resolve(ClassLoader loader) {
        addTaint(loader.getTaint());
    if(typeString == null && isPrimitive())        
        {
            typeString = String.valueOf(getTypeCode());
        } //End block
    if(typeString.length() == 1)        
        {
    if(defaultResolve())            
            {
                return;
            } //End block
        } //End block
        String className = typeString.replace('/', '.');
    if(className.charAt(0) == 'L')        
        {
            className = className.substring(1, className.length() - 1);
        } //End block
        try 
        {
            Class<?> cl = Class.forName(className, false, loader);
            type = (cl.getClassLoader() == null) ? cl : new WeakReference<Class<?>>(cl);
        } //End block
        catch (ClassNotFoundException e)
        {
        } //End block
        // ---------- Original Method ----------
        //if (typeString == null && isPrimitive()) {
            //typeString = String.valueOf(getTypeCode());
        //}
        //if (typeString.length() == 1) {
            //if (defaultResolve()) {
                //return;
            //}
        //}
        //String className = typeString.replace('/', '.');
        //if (className.charAt(0) == 'L') {
            //className = className.substring(1, className.length() - 1);
        //}
        //try {
            //Class<?> cl = Class.forName(className, false, loader);
            //type = (cl.getClassLoader() == null) ? cl : new WeakReference<Class<?>>(cl);
        //} catch (ClassNotFoundException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.482 -0400", hash_original_method = "F21E97E0131CF96F90294027D325F2F1", hash_generated_method = "1F1D1D5FC1A5232F1FDC2C13607BCE84")
    public boolean isUnshared() {
        boolean var962FA027E49514EF42DADB2095E8C618_1996297201 = (unshared);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1981158996 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1981158996;
        // ---------- Original Method ----------
        //return unshared;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.484 -0400", hash_original_method = "68701E3ED15FAA74732CE575E0F04E5E", hash_generated_method = "78989AD0A169EB11A9E371D43CF1C2E1")
     void setUnshared(boolean unshared) {
        this.unshared = unshared;
        // ---------- Original Method ----------
        //this.unshared = unshared;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:42.487 -0400", hash_original_method = "E1E63B3BD3E5801BD481EB78C5FBD93C", hash_generated_method = "18F7E0E0AE0304B882431B7452573371")
    private boolean defaultResolve() {
switch(typeString.charAt(0)){
        case 'I':
        type = int.class;
        boolean varB326B5062B2F0E69046810717534CB09_567462900 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1697818521 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1697818521;
        case 'B':
        type = byte.class;
        boolean varB326B5062B2F0E69046810717534CB09_811219881 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1301397993 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1301397993;
        case 'C':
        type = char.class;
        boolean varB326B5062B2F0E69046810717534CB09_812530509 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1664766052 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1664766052;
        case 'S':
        type = short.class;
        boolean varB326B5062B2F0E69046810717534CB09_266089517 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_139252051 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_139252051;
        case 'Z':
        type = boolean.class;
        boolean varB326B5062B2F0E69046810717534CB09_2031309698 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1399173594 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1399173594;
        case 'J':
        type = long.class;
        boolean varB326B5062B2F0E69046810717534CB09_1205352705 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_126757887 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_126757887;
        case 'F':
        type = float.class;
        boolean varB326B5062B2F0E69046810717534CB09_1504101458 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1522263310 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1522263310;
        case 'D':
        type = double.class;
        boolean varB326B5062B2F0E69046810717534CB09_94765224 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1575366339 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1575366339;
        default:
        type = Object.class;
        boolean var68934A3E9455FA72420237EB05902327_1022953789 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1202804390 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1202804390;
}
        // ---------- Original Method ----------
        //switch (typeString.charAt(0)) {
        //case 'I':
            //type = int.class;
            //return true;
        //case 'B':
            //type = byte.class;
            //return true;
        //case 'C':
            //type = char.class;
            //return true;
        //case 'S':
            //type = short.class;
            //return true;
        //case 'Z':
            //type = boolean.class;
            //return true;
        //case 'J':
            //type = long.class;
            //return true;
        //case 'F':
            //type = float.class;
            //return true;
        //case 'D':
            //type = double.class;
            //return true;
        //default:
            //type = Object.class;
            //return false;
        //}
    }

    
}

