package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Comparator;

public class ObjectStreamField implements Comparable<Object> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.711 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.711 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "E8909FCC8837B5FE7A3CBA40C0098CCB")

    private Object type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.711 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "B7E810BF01B52122CB927525A0CA4721")

    int offset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.711 -0400", hash_original_field = "EB43610BFF4BF58AA2AF0BA56299D57A", hash_generated_field = "A6469B3C05A6E61AD188C77E4C87AFA0")

    private String typeString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.711 -0400", hash_original_field = "962FA027E49514EF42DADB2095E8C618", hash_generated_field = "1925D0B4ADBD655AA714AC16DE1F0973")

    private boolean unshared;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.711 -0400", hash_original_field = "08F60B1F77A7ECFDC92540AF3E6C2887", hash_generated_field = "B10B376FF3C60E9314732C46A8CA6340")

    private boolean isDeserialized;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.711 -0400", hash_original_method = "0D657EDEC08CB18117CF62EC578D6020", hash_generated_method = "7D64C1E5079C1595A78499F1CD7D2B04")
    public  ObjectStreamField(String name, Class<?> cl) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        this.name = name;
        this.type = new WeakReference<Class<?>>(cl);
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.712 -0400", hash_original_method = "B329D182B18083287B5598787B9BCF42", hash_generated_method = "549592D84BBC9126454BFC055E2D972B")
    public  ObjectStreamField(String name, Class<?> cl, boolean unshared) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        this.name = name;
        this.type = (cl.getClassLoader() == null) ? cl : new WeakReference<Class<?>>(cl);
        this.unshared = unshared;
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.712 -0400", hash_original_method = "7045B1DBF21073AA43E994CE221E4094", hash_generated_method = "F2CB169C8FF966E2B41881A277E9476A")
      ObjectStreamField(String signature, String name) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        this.name = name;
        this.typeString = signature.replace('.', '/').intern();
        defaultResolve();
        this.isDeserialized = true;
        
        
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.712 -0400", hash_original_method = "11ADA6ED2A991966CB49663045730556", hash_generated_method = "10E4455E7BCD23DB94205A7989BBDDD6")
    public int compareTo(Object o) {
        ObjectStreamField f = (ObjectStreamField) o;
        boolean thisPrimitive = this.isPrimitive();
        boolean fPrimitive = f.isPrimitive();
        int var2F3A4BA37EC730562BE97B6E5BC529E7_1247852513 = (this.getName().compareTo(f.getName()));
        addTaint(o.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_261182770 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_261182770;
        
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.713 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "80B736505AFF6165C2DFF2471BF64D02")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_457026815 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_457026815 = name;
        varB4EAC82CA7396A68D541C85D26508E83_457026815.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_457026815;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.713 -0400", hash_original_method = "ACEB13DAA855070296BA592FB1ADADA1", hash_generated_method = "CB4FFBDD544804541029D12450902735")
    public int getOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_92631546 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_92631546;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.713 -0400", hash_original_method = "FF08482EB56AA685DDAE41A39E334998", hash_generated_method = "54A902482B1D65CF658A03E994620214")
     Class<?> getTypeInternal() {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_505529498 = null; 
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1347182238 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_505529498 = (Class<?>) ((WeakReference<?>) type).get();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1347182238 = (Class<?>) type;
        Class<?> varA7E53CE21691AB073D9660D615818899_827801887; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_827801887 = varB4EAC82CA7396A68D541C85D26508E83_505529498;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_827801887 = varB4EAC82CA7396A68D541C85D26508E83_1347182238;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_827801887.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_827801887;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.714 -0400", hash_original_method = "9634509EF2A12286AE62950CEFC0E304", hash_generated_method = "FD4BA908DEE45D14261D2E88E15250D2")
    public Class<?> getType() {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_753270977 = null; 
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_2112817150 = null; 
        Class<?> cl = getTypeInternal();
        {
            boolean varA3679B8742DABFD077DA559AF7FB1A74_1995047252 = (isDeserialized && !cl.isPrimitive());
            {
                varB4EAC82CA7396A68D541C85D26508E83_753270977 = Object.class;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2112817150 = cl;
        Class<?> varA7E53CE21691AB073D9660D615818899_1553593780; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1553593780 = varB4EAC82CA7396A68D541C85D26508E83_753270977;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1553593780 = varB4EAC82CA7396A68D541C85D26508E83_2112817150;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1553593780.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1553593780;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.714 -0400", hash_original_method = "6C03FA17A8A9EDC07915A4F462B31BC8", hash_generated_method = "1BB302971B1F1DE55770CAF3ABB66869")
    public char getTypeCode() {
        char var1177AA956C7DA25FE5A8F4F00F47BA9F_413668903 = (typeCodeOf(getTypeInternal()));
        char varA87DEB01C5F539E6BDA34829C8EF2368_306091225 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_306091225;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.714 -0400", hash_original_method = "1261A37E9B201158D41DADA58D3D498E", hash_generated_method = "87A6DCB1B814FDD371B98BB15AC40742")
    private char typeCodeOf(Class<?> type) {
        {
            boolean var6A7B33E76BE12D29FD67A26D06CDE611_1815547267 = (type.isArray());
        } 
        addTaint(type.getTaint());
        char varA87DEB01C5F539E6BDA34829C8EF2368_47308324 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_47308324;
        
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.715 -0400", hash_original_method = "AF834EA72E67DF4239AA5209B5DE5F81", hash_generated_method = "0629BA04FB440A129537B2BB70354538")
    public String getTypeString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1840272799 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_710056847 = null; 
        {
            boolean var66A0FD8833FB78ABA18BF193F91E7A7D_95717526 = (isPrimitive());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1840272799 = null;
            } 
        } 
        {
            Class<?> t = getTypeInternal();
            String typeName = t.getName().replace('.', '/');
            String str;
            boolean var5E131F98AD76D0BF9AAD526EFBF40306_1257097456 = ((t.isArray()));
            str = typeName;
            str = ("L" + typeName + ';');
            typeString = str.intern();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_710056847 = typeString;
        String varA7E53CE21691AB073D9660D615818899_1127317436; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1127317436 = varB4EAC82CA7396A68D541C85D26508E83_1840272799;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1127317436 = varB4EAC82CA7396A68D541C85D26508E83_710056847;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1127317436.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1127317436;
        
        
            
        
        
            
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.715 -0400", hash_original_method = "109BC8E5B51BF330504215C17ADD6478", hash_generated_method = "01F38ECA1256101C90E9B64C7C1869B4")
    public boolean isPrimitive() {
        Class<?> t = getTypeInternal();
        boolean varB421F220FEF97A3E096A81B170604319_759406644 = (t != null && t.isPrimitive());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1741715923 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1741715923;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.715 -0400", hash_original_method = "6EE925571D11CA9854483CD43D60AA5F", hash_generated_method = "40A5FC2C95252DFA8F3D5E2ACA389574")
     boolean writeField(DataOutputStream out) throws IOException {
        Class<?> t = getTypeInternal();
        out.writeByte(typeCodeOf(t));
        out.writeUTF(name);
        boolean var7719FC2E2C2407A9C763B64F0A563F59_820229737 = ((t != null && t.isPrimitive()));
        addTaint(out.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_433270415 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_433270415;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.715 -0400", hash_original_method = "7A66A074CFBB1A834E24DFB5B3A643D5", hash_generated_method = "4305F7EB15B8D74A66017D2CC764F457")
    protected void setOffset(int newValue) {
        this.offset = newValue;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.716 -0400", hash_original_method = "ABFAE4540EC552EECBD4679559074925", hash_generated_method = "91D32CC8302BE6182F6C4F008D5AEB3C")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1534638664 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1534638664 = this.getClass().getName() + '(' + getName() + ':' + getTypeInternal() + ')';
        varB4EAC82CA7396A68D541C85D26508E83_1534638664.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1534638664;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.716 -0400", hash_original_method = "48E3281BF72BF66E5E96F9E4056E97FC", hash_generated_method = "F705BBFB1F57D2094A6BD64D825A3094")
     void resolve(ClassLoader loader) {
        {
            boolean var2D678C45C1F58BEAC668B5F88029903B_2110468829 = (typeString == null && isPrimitive());
            {
                typeString = String.valueOf(getTypeCode());
            } 
        } 
        {
            boolean varF774A382C8A76B03DD267611340345A4_465689028 = (typeString.length() == 1);
            {
                {
                    boolean var38E4603B2800FF20134BFF86D9CC31CE_1977813280 = (defaultResolve());
                } 
            } 
        } 
        String className = typeString.replace('/', '.');
        {
            boolean var4A650C5F977360D4DD17F8170EBAC5FA_1611472087 = (className.charAt(0) == 'L');
            {
                className = className.substring(1, className.length() - 1);
            } 
        } 
        try 
        {
            Class<?> cl = Class.forName(className, false, loader);
            type = (cl.getClassLoader() == null) ? cl : new WeakReference<Class<?>>(cl);
        } 
        catch (ClassNotFoundException e)
        { }
        addTaint(loader.getTaint());
        
        
            
        
        
            
                
            
        
        
        
            
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.717 -0400", hash_original_method = "F21E97E0131CF96F90294027D325F2F1", hash_generated_method = "A62862AE56F07593181F21E5923DDC1A")
    public boolean isUnshared() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2098507411 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2098507411;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.717 -0400", hash_original_method = "68701E3ED15FAA74732CE575E0F04E5E", hash_generated_method = "78989AD0A169EB11A9E371D43CF1C2E1")
     void setUnshared(boolean unshared) {
        this.unshared = unshared;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.717 -0400", hash_original_method = "E1E63B3BD3E5801BD481EB78C5FBD93C", hash_generated_method = "E7C3BC168A8D66E802C09B385D51A360")
    private boolean defaultResolve() {
        {
            Object varA76659841820C1031EE708C4EE618FAA_2146922688 = (typeString.charAt(0));
            
            type = int.class;
            
            
            type = byte.class;
            
            
            type = char.class;
            
            
            type = short.class;
            
            
            type = boolean.class;
            
            
            type = long.class;
            
            
            type = float.class;
            
            
            type = double.class;
            
            
            type = Object.class;
            
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_429768701 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_429768701;
        
        
        
            
            
        
            
            
        
            
            
        
            
            
        
            
            
        
            
            
        
            
            
        
            
            
        
            
            
        
    }

    
}

