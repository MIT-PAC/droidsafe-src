package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Comparator;

public class ObjectStreamField implements Comparable<Object> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.026 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.027 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "E8909FCC8837B5FE7A3CBA40C0098CCB")

    private Object type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.027 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "B7E810BF01B52122CB927525A0CA4721")

    int offset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.027 -0400", hash_original_field = "EB43610BFF4BF58AA2AF0BA56299D57A", hash_generated_field = "A6469B3C05A6E61AD188C77E4C87AFA0")

    private String typeString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.027 -0400", hash_original_field = "962FA027E49514EF42DADB2095E8C618", hash_generated_field = "1925D0B4ADBD655AA714AC16DE1F0973")

    private boolean unshared;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.027 -0400", hash_original_field = "08F60B1F77A7ECFDC92540AF3E6C2887", hash_generated_field = "B10B376FF3C60E9314732C46A8CA6340")

    private boolean isDeserialized;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.029 -0400", hash_original_method = "0D657EDEC08CB18117CF62EC578D6020", hash_generated_method = "B5082F638F28D4801D71017A6576F64D")
    public  ObjectStreamField(String name, Class<?> cl) {
        if(name == null || cl == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1073190857 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1073190857.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1073190857;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.031 -0400", hash_original_method = "B329D182B18083287B5598787B9BCF42", hash_generated_method = "16D648D0910B0887A64330CF1D6956C5")
    public  ObjectStreamField(String name, Class<?> cl, boolean unshared) {
        if(name == null || cl == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1810436038 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1810436038.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1810436038;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.033 -0400", hash_original_method = "7045B1DBF21073AA43E994CE221E4094", hash_generated_method = "B0D15FC28A0BC93EBA154D9D9D7E9977")
      ObjectStreamField(String signature, String name) {
        if(name == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_997128325 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_997128325.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_997128325;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.034 -0400", hash_original_method = "11ADA6ED2A991966CB49663045730556", hash_generated_method = "5B2A842235861802FFF76D448FA31C6A")
    public int compareTo(Object o) {
        addTaint(o.getTaint());
        ObjectStreamField f = (ObjectStreamField) o;
        boolean thisPrimitive = this.isPrimitive();
        boolean fPrimitive = f.isPrimitive();
        if(thisPrimitive != fPrimitive)        
        {
            int varDAB1FF22EBF07ADC6E4F9CF0E5A2D91D_2094624898 = (thisPrimitive ? -1 : 1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_844031943 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_844031943;
        } //End block
        int var26898C4A1F7593B62E9891383065F061_378566847 = (this.getName().compareTo(f.getName()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1650813353 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1650813353;
        // ---------- Original Method ----------
        //ObjectStreamField f = (ObjectStreamField) o;
        //boolean thisPrimitive = this.isPrimitive();
        //boolean fPrimitive = f.isPrimitive();
        //if (thisPrimitive != fPrimitive) {
            //return thisPrimitive ? -1 : 1;
        //}
        //return this.getName().compareTo(f.getName());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.035 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "CB679EE71C7C00C20C3550E26037057B")
    public String getName() {
String varB017984728AC60AD1F0BF8734F33F15C_847600741 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_847600741.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_847600741;
        // ---------- Original Method ----------
        //return name;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.036 -0400", hash_original_method = "ACEB13DAA855070296BA592FB1ADADA1", hash_generated_method = "DB3BF23749316841F110D00396ADE685")
    public int getOffset() {
        int var7A86C157EE9713C34FBD7A1EE40F0C5A_352597172 = (offset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_739649758 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_739649758;
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.036 -0400", hash_original_method = "FF08482EB56AA685DDAE41A39E334998", hash_generated_method = "C9F675B7C0DC46D14033611BF61255CA")
     Class<?> getTypeInternal() {
        if(type instanceof WeakReference)        
        {
Class<?> var20EC7C7A75D568B19BB2D841DD2CBD17_658134568 =             (Class<?>) ((WeakReference<?>) type).get();
            var20EC7C7A75D568B19BB2D841DD2CBD17_658134568.addTaint(taint);
            return var20EC7C7A75D568B19BB2D841DD2CBD17_658134568;
        } //End block
Class<?> var4585A728AFBCEE57D35F6001ECD82EAF_387279886 =         (Class<?>) type;
        var4585A728AFBCEE57D35F6001ECD82EAF_387279886.addTaint(taint);
        return var4585A728AFBCEE57D35F6001ECD82EAF_387279886;
        // ---------- Original Method ----------
        //if (type instanceof WeakReference) {
            //return (Class<?>) ((WeakReference<?>) type).get();
        //}
        //return (Class<?>) type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.037 -0400", hash_original_method = "9634509EF2A12286AE62950CEFC0E304", hash_generated_method = "8C2C3C0868982E2E2CC3E4CDF5F21CEC")
    public Class<?> getType() {
        Class<?> cl = getTypeInternal();
        if(isDeserialized && !cl.isPrimitive())        
        {
Class<?> var3D4686B2FADA55BD47A8E0853700CA45_612848129 =             Object.class;
            var3D4686B2FADA55BD47A8E0853700CA45_612848129.addTaint(taint);
            return var3D4686B2FADA55BD47A8E0853700CA45_612848129;
        } //End block
Class<?> var8C6A66A89969D061B1ECE468EDE00B0A_604514584 =         cl;
        var8C6A66A89969D061B1ECE468EDE00B0A_604514584.addTaint(taint);
        return var8C6A66A89969D061B1ECE468EDE00B0A_604514584;
        // ---------- Original Method ----------
        //Class<?> cl = getTypeInternal();
        //if (isDeserialized && !cl.isPrimitive()) {
            //return Object.class;
        //}
        //return cl;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.038 -0400", hash_original_method = "6C03FA17A8A9EDC07915A4F462B31BC8", hash_generated_method = "101A2152B9D54559C66966B83B91EA2E")
    public char getTypeCode() {
        char var43EFEAF95577F8DDC10B9CD1AB86DD46_1683848314 = (typeCodeOf(getTypeInternal()));
                char varA87DEB01C5F539E6BDA34829C8EF2368_885224120 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_885224120;
        // ---------- Original Method ----------
        //return typeCodeOf(getTypeInternal());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.039 -0400", hash_original_method = "1261A37E9B201158D41DADA58D3D498E", hash_generated_method = "E387E4BFC1F9BB28A1A022B9229436AB")
    private char typeCodeOf(Class<?> type) {
        addTaint(type.getTaint());
        if(type == int.class)        
        {
            char var3F823ADCFD48AD4956FF832E927AE9D8_1592329233 = ('I');
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1207193371 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1207193371;
        } //End block
        else
        if(type == byte.class)        
        {
            char varAE87D173F10578174F8EC1A3EB2EFDD4_1747779624 = ('B');
                        char varA87DEB01C5F539E6BDA34829C8EF2368_755074987 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_755074987;
        } //End block
        else
        if(type == char.class)        
        {
            char var4E8F5B084D1D2D0DBB92E85D8098FC1F_727418170 = ('C');
                        char varA87DEB01C5F539E6BDA34829C8EF2368_846849242 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_846849242;
        } //End block
        else
        if(type == short.class)        
        {
            char var21B05C586D183CDACD570B1765EA75F2_264855759 = ('S');
                        char varA87DEB01C5F539E6BDA34829C8EF2368_318720588 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_318720588;
        } //End block
        else
        if(type == boolean.class)        
        {
            char var3472269E25D3B2573CD87D44EBA875D9_616275293 = ('Z');
                        char varA87DEB01C5F539E6BDA34829C8EF2368_212876216 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_212876216;
        } //End block
        else
        if(type == long.class)        
        {
            char var1D71EF54F324EB9089AFB895C47C382F_3208263 = ('J');
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1860607969 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1860607969;
        } //End block
        else
        if(type == float.class)        
        {
            char varCA2BFEC9449E8D4AFE6AB5497D6B4144_1751243685 = ('F');
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1716917405 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1716917405;
        } //End block
        else
        if(type == double.class)        
        {
            char var943CFAB3F15FA8B743A942EBDD8CBF49_972039913 = ('D');
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1117832651 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1117832651;
        } //End block
        else
        if(type.isArray())        
        {
            char varAC425FCC80C8FDC2F15CB0BCE227ABB0_571168959 = ('[');
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1670761587 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1670761587;
        } //End block
        else
        {
            char var90914D7B476BD5CC07F17FD4CF48E49C_1997987497 = ('L');
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1098081319 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1098081319;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.042 -0400", hash_original_method = "AF834EA72E67DF4239AA5209B5DE5F81", hash_generated_method = "DED98FD3B8F3FC13CFA6E80649196C4E")
    public String getTypeString() {
        if(isPrimitive())        
        {
String var540C13E9E156B687226421B24F2DF178_559114191 =             null;
            var540C13E9E156B687226421B24F2DF178_559114191.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_559114191;
        } //End block
        if(typeString == null)        
        {
            Class<?> t = getTypeInternal();
            String typeName = t.getName().replace('.', '/');
            String str = (t.isArray()) ? typeName : ("L" + typeName + ';');
            typeString = str.intern();
        } //End block
String var7A85238CD32275F0BFF675D89BABBB30_1936400749 =         typeString;
        var7A85238CD32275F0BFF675D89BABBB30_1936400749.addTaint(taint);
        return var7A85238CD32275F0BFF675D89BABBB30_1936400749;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.042 -0400", hash_original_method = "109BC8E5B51BF330504215C17ADD6478", hash_generated_method = "894F03AB582E7C9C23F3EF8D11181464")
    public boolean isPrimitive() {
        Class<?> t = getTypeInternal();
        boolean var6BE37865E76F958F60A690B6B4337DD8_564034193 = (t != null && t.isPrimitive());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_58666092 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_58666092;
        // ---------- Original Method ----------
        //Class<?> t = getTypeInternal();
        //return t != null && t.isPrimitive();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.043 -0400", hash_original_method = "6EE925571D11CA9854483CD43D60AA5F", hash_generated_method = "6CE2C3D76D54545430252DA43CEBBD9D")
     boolean writeField(DataOutputStream out) throws IOException {
        addTaint(out.getTaint());
        Class<?> t = getTypeInternal();
        out.writeByte(typeCodeOf(t));
        out.writeUTF(name);
        boolean var62582580B8D28C6B494EDCFB63E1761A_1969614575 = ((t != null && t.isPrimitive()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1808715152 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1808715152;
        // ---------- Original Method ----------
        //Class<?> t = getTypeInternal();
        //out.writeByte(typeCodeOf(t));
        //out.writeUTF(name);
        //return (t != null && t.isPrimitive());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.044 -0400", hash_original_method = "7A66A074CFBB1A834E24DFB5B3A643D5", hash_generated_method = "4305F7EB15B8D74A66017D2CC764F457")
    protected void setOffset(int newValue) {
        this.offset = newValue;
        // ---------- Original Method ----------
        //this.offset = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.044 -0400", hash_original_method = "ABFAE4540EC552EECBD4679559074925", hash_generated_method = "729452E04410EF1341705206AEFB0C8E")
    @Override
    public String toString() {
String var1C1258DA98EFE38BC9C2501509B2FF42_1396833457 =         this.getClass().getName() + '(' + getName() + ':' + getTypeInternal() + ')';
        var1C1258DA98EFE38BC9C2501509B2FF42_1396833457.addTaint(taint);
        return var1C1258DA98EFE38BC9C2501509B2FF42_1396833457;
        // ---------- Original Method ----------
        //return this.getClass().getName() + '(' + getName() + ':' + getTypeInternal() + ')';
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.046 -0400", hash_original_method = "48E3281BF72BF66E5E96F9E4056E97FC", hash_generated_method = "32D00F1C806E34AAC93FBAF8E3FC5E7F")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.047 -0400", hash_original_method = "F21E97E0131CF96F90294027D325F2F1", hash_generated_method = "6DA2C0FF951973794F45AFA8E80CEDDC")
    public boolean isUnshared() {
        boolean var962FA027E49514EF42DADB2095E8C618_386544896 = (unshared);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1344498443 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1344498443;
        // ---------- Original Method ----------
        //return unshared;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.047 -0400", hash_original_method = "68701E3ED15FAA74732CE575E0F04E5E", hash_generated_method = "78989AD0A169EB11A9E371D43CF1C2E1")
     void setUnshared(boolean unshared) {
        this.unshared = unshared;
        // ---------- Original Method ----------
        //this.unshared = unshared;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.050 -0400", hash_original_method = "E1E63B3BD3E5801BD481EB78C5FBD93C", hash_generated_method = "C57749E9582E90DD8B6D271668D58018")
    private boolean defaultResolve() {
switch(typeString.charAt(0)){
        case 'I':
        type = int.class;
        boolean varB326B5062B2F0E69046810717534CB09_1094709424 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_411584689 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_411584689;
        case 'B':
        type = byte.class;
        boolean varB326B5062B2F0E69046810717534CB09_1642332233 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_639173556 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_639173556;
        case 'C':
        type = char.class;
        boolean varB326B5062B2F0E69046810717534CB09_1287463850 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1634682813 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1634682813;
        case 'S':
        type = short.class;
        boolean varB326B5062B2F0E69046810717534CB09_1353557721 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_775583694 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_775583694;
        case 'Z':
        type = boolean.class;
        boolean varB326B5062B2F0E69046810717534CB09_563534339 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_583711792 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_583711792;
        case 'J':
        type = long.class;
        boolean varB326B5062B2F0E69046810717534CB09_995839560 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1351133663 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1351133663;
        case 'F':
        type = float.class;
        boolean varB326B5062B2F0E69046810717534CB09_1071091712 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1238173039 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1238173039;
        case 'D':
        type = double.class;
        boolean varB326B5062B2F0E69046810717534CB09_1260689732 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_664471474 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_664471474;
        default:
        type = Object.class;
        boolean var68934A3E9455FA72420237EB05902327_677843738 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_411032868 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_411032868;
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

