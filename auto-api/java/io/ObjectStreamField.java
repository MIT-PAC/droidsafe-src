package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Comparator;

public class ObjectStreamField implements Comparable<Object> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.295 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.295 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "E8909FCC8837B5FE7A3CBA40C0098CCB")

    private Object type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.295 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "B7E810BF01B52122CB927525A0CA4721")

    int offset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.295 -0400", hash_original_field = "EB43610BFF4BF58AA2AF0BA56299D57A", hash_generated_field = "A6469B3C05A6E61AD188C77E4C87AFA0")

    private String typeString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.295 -0400", hash_original_field = "962FA027E49514EF42DADB2095E8C618", hash_generated_field = "1925D0B4ADBD655AA714AC16DE1F0973")

    private boolean unshared;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.295 -0400", hash_original_field = "08F60B1F77A7ECFDC92540AF3E6C2887", hash_generated_field = "B10B376FF3C60E9314732C46A8CA6340")

    private boolean isDeserialized;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.296 -0400", hash_original_method = "0D657EDEC08CB18117CF62EC578D6020", hash_generated_method = "7D64C1E5079C1595A78499F1CD7D2B04")
    public  ObjectStreamField(String name, Class<?> cl) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.296 -0400", hash_original_method = "B329D182B18083287B5598787B9BCF42", hash_generated_method = "549592D84BBC9126454BFC055E2D972B")
    public  ObjectStreamField(String name, Class<?> cl, boolean unshared) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.297 -0400", hash_original_method = "7045B1DBF21073AA43E994CE221E4094", hash_generated_method = "F2CB169C8FF966E2B41881A277E9476A")
      ObjectStreamField(String signature, String name) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.297 -0400", hash_original_method = "11ADA6ED2A991966CB49663045730556", hash_generated_method = "9F96B15406570A66BCA2BCD6FFF42B83")
    public int compareTo(Object o) {
        ObjectStreamField f;
        f = (ObjectStreamField) o;
        boolean thisPrimitive;
        thisPrimitive = this.isPrimitive();
        boolean fPrimitive;
        fPrimitive = f.isPrimitive();
        int var2F3A4BA37EC730562BE97B6E5BC529E7_1263705233 = (this.getName().compareTo(f.getName()));
        addTaint(o.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1883180105 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1883180105;
        // ---------- Original Method ----------
        //ObjectStreamField f = (ObjectStreamField) o;
        //boolean thisPrimitive = this.isPrimitive();
        //boolean fPrimitive = f.isPrimitive();
        //if (thisPrimitive != fPrimitive) {
            //return thisPrimitive ? -1 : 1;
        //}
        //return this.getName().compareTo(f.getName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.297 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "DBA8CCB806B2411AD171352143FECBF5")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1775239007 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1775239007 = name;
        varB4EAC82CA7396A68D541C85D26508E83_1775239007.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1775239007;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.298 -0400", hash_original_method = "ACEB13DAA855070296BA592FB1ADADA1", hash_generated_method = "BDAA1553ED4A6B9D548E6E511D250DDD")
    public int getOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1558132778 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1558132778;
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.298 -0400", hash_original_method = "FF08482EB56AA685DDAE41A39E334998", hash_generated_method = "475378BF2187E5A44C1C8FF8BEFF7632")
     Class<?> getTypeInternal() {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1903127810 = null; //Variable for return #1
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_2087884946 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1903127810 = (Class<?>) ((WeakReference<?>) type).get();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2087884946 = (Class<?>) type;
        Class<?> varA7E53CE21691AB073D9660D615818899_86374272; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_86374272 = varB4EAC82CA7396A68D541C85D26508E83_1903127810;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_86374272 = varB4EAC82CA7396A68D541C85D26508E83_2087884946;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_86374272.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_86374272;
        // ---------- Original Method ----------
        //if (type instanceof WeakReference) {
            //return (Class<?>) ((WeakReference<?>) type).get();
        //}
        //return (Class<?>) type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.303 -0400", hash_original_method = "9634509EF2A12286AE62950CEFC0E304", hash_generated_method = "8F94326A482747209022D9A1520524F8")
    public Class<?> getType() {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_927641139 = null; //Variable for return #1
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1778933615 = null; //Variable for return #2
        Class<?> cl;
        cl = getTypeInternal();
        {
            boolean varA3679B8742DABFD077DA559AF7FB1A74_607766428 = (isDeserialized && !cl.isPrimitive());
            {
                varB4EAC82CA7396A68D541C85D26508E83_927641139 = Object.class;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1778933615 = cl;
        Class<?> varA7E53CE21691AB073D9660D615818899_362600361; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_362600361 = varB4EAC82CA7396A68D541C85D26508E83_927641139;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_362600361 = varB4EAC82CA7396A68D541C85D26508E83_1778933615;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_362600361.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_362600361;
        // ---------- Original Method ----------
        //Class<?> cl = getTypeInternal();
        //if (isDeserialized && !cl.isPrimitive()) {
            //return Object.class;
        //}
        //return cl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.315 -0400", hash_original_method = "6C03FA17A8A9EDC07915A4F462B31BC8", hash_generated_method = "076EA4312FF2FA3663A927F7E2EF7771")
    public char getTypeCode() {
        char var1177AA956C7DA25FE5A8F4F00F47BA9F_1097995592 = (typeCodeOf(getTypeInternal()));
        char varA87DEB01C5F539E6BDA34829C8EF2368_68402653 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_68402653;
        // ---------- Original Method ----------
        //return typeCodeOf(getTypeInternal());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.316 -0400", hash_original_method = "1261A37E9B201158D41DADA58D3D498E", hash_generated_method = "26999BA9426232FD4D97994BE76459A1")
    private char typeCodeOf(Class<?> type) {
        {
            boolean var6A7B33E76BE12D29FD67A26D06CDE611_331536955 = (type.isArray());
        } //End collapsed parenthetic
        addTaint(type.getTaint());
        char varA87DEB01C5F539E6BDA34829C8EF2368_1915447517 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1915447517;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.316 -0400", hash_original_method = "AF834EA72E67DF4239AA5209B5DE5F81", hash_generated_method = "83FD08A3D62D82C6DFDBDBC30DE463A5")
    public String getTypeString() {
        String varB4EAC82CA7396A68D541C85D26508E83_350456314 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_306500087 = null; //Variable for return #2
        {
            boolean var66A0FD8833FB78ABA18BF193F91E7A7D_304935911 = (isPrimitive());
            {
                varB4EAC82CA7396A68D541C85D26508E83_350456314 = null;
            } //End block
        } //End collapsed parenthetic
        {
            Class<?> t;
            t = getTypeInternal();
            String typeName;
            typeName = t.getName().replace('.', '/');
            String str;
            boolean var5E131F98AD76D0BF9AAD526EFBF40306_796662556 = ((t.isArray()));
            str = typeName;
            str = ("L" + typeName + ';');
            typeString = str.intern();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_306500087 = typeString;
        String varA7E53CE21691AB073D9660D615818899_1203928934; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1203928934 = varB4EAC82CA7396A68D541C85D26508E83_350456314;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1203928934 = varB4EAC82CA7396A68D541C85D26508E83_306500087;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1203928934.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1203928934;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.317 -0400", hash_original_method = "109BC8E5B51BF330504215C17ADD6478", hash_generated_method = "DA7E4E82B77811C0A384C2958B92A260")
    public boolean isPrimitive() {
        Class<?> t;
        t = getTypeInternal();
        boolean varB421F220FEF97A3E096A81B170604319_1507641566 = (t != null && t.isPrimitive());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1018795023 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1018795023;
        // ---------- Original Method ----------
        //Class<?> t = getTypeInternal();
        //return t != null && t.isPrimitive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.317 -0400", hash_original_method = "6EE925571D11CA9854483CD43D60AA5F", hash_generated_method = "7382D403E1F825A2A843B1D7C72C6BEC")
     boolean writeField(DataOutputStream out) throws IOException {
        Class<?> t;
        t = getTypeInternal();
        out.writeByte(typeCodeOf(t));
        out.writeUTF(name);
        boolean var7719FC2E2C2407A9C763B64F0A563F59_501246581 = ((t != null && t.isPrimitive()));
        addTaint(out.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_332831396 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_332831396;
        // ---------- Original Method ----------
        //Class<?> t = getTypeInternal();
        //out.writeByte(typeCodeOf(t));
        //out.writeUTF(name);
        //return (t != null && t.isPrimitive());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.317 -0400", hash_original_method = "7A66A074CFBB1A834E24DFB5B3A643D5", hash_generated_method = "4305F7EB15B8D74A66017D2CC764F457")
    protected void setOffset(int newValue) {
        this.offset = newValue;
        // ---------- Original Method ----------
        //this.offset = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.318 -0400", hash_original_method = "ABFAE4540EC552EECBD4679559074925", hash_generated_method = "22BD2792A8A18ACD473DB4B2EE957B12")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1439618208 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1439618208 = this.getClass().getName() + '(' + getName() + ':' + getTypeInternal() + ')';
        varB4EAC82CA7396A68D541C85D26508E83_1439618208.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1439618208;
        // ---------- Original Method ----------
        //return this.getClass().getName() + '(' + getName() + ':' + getTypeInternal() + ')';
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.322 -0400", hash_original_method = "48E3281BF72BF66E5E96F9E4056E97FC", hash_generated_method = "AF10B8B3AD30554BD7C4F9A30F11DFD5")
     void resolve(ClassLoader loader) {
        {
            boolean var2D678C45C1F58BEAC668B5F88029903B_227035582 = (typeString == null && isPrimitive());
            {
                typeString = String.valueOf(getTypeCode());
            } //End block
        } //End collapsed parenthetic
        {
            boolean varF774A382C8A76B03DD267611340345A4_17201243 = (typeString.length() == 1);
            {
                {
                    boolean var38E4603B2800FF20134BFF86D9CC31CE_843638588 = (defaultResolve());
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        String className;
        className = typeString.replace('/', '.');
        {
            boolean var4A650C5F977360D4DD17F8170EBAC5FA_673523050 = (className.charAt(0) == 'L');
            {
                className = className.substring(1, className.length() - 1);
            } //End block
        } //End collapsed parenthetic
        try 
        {
            Class<?> cl;
            cl = Class.forName(className, false, loader);
            type = (cl.getClassLoader() == null) ? cl : new WeakReference<Class<?>>(cl);
        } //End block
        catch (ClassNotFoundException e)
        { }
        addTaint(loader.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.333 -0400", hash_original_method = "F21E97E0131CF96F90294027D325F2F1", hash_generated_method = "B16D63DCBB1F79D635C6BFB5F93BCCE2")
    public boolean isUnshared() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_50183926 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_50183926;
        // ---------- Original Method ----------
        //return unshared;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.334 -0400", hash_original_method = "68701E3ED15FAA74732CE575E0F04E5E", hash_generated_method = "78989AD0A169EB11A9E371D43CF1C2E1")
     void setUnshared(boolean unshared) {
        this.unshared = unshared;
        // ---------- Original Method ----------
        //this.unshared = unshared;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.335 -0400", hash_original_method = "E1E63B3BD3E5801BD481EB78C5FBD93C", hash_generated_method = "7ABA9481DD8CE013E65A53D8E433F107")
    private boolean defaultResolve() {
        {
            Object varA76659841820C1031EE708C4EE618FAA_1663264863 = (typeString.charAt(0));
            //Begin case 'I' 
            type = int.class;
            //End case 'I' 
            //Begin case 'B' 
            type = byte.class;
            //End case 'B' 
            //Begin case 'C' 
            type = char.class;
            //End case 'C' 
            //Begin case 'S' 
            type = short.class;
            //End case 'S' 
            //Begin case 'Z' 
            type = boolean.class;
            //End case 'Z' 
            //Begin case 'J' 
            type = long.class;
            //End case 'J' 
            //Begin case 'F' 
            type = float.class;
            //End case 'F' 
            //Begin case 'D' 
            type = double.class;
            //End case 'D' 
            //Begin case default 
            type = Object.class;
            //End case default 
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1780746501 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1780746501;
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

