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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.323 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.323 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "E8909FCC8837B5FE7A3CBA40C0098CCB")

    private Object type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.323 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "B7E810BF01B52122CB927525A0CA4721")

    int offset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.323 -0400", hash_original_field = "EB43610BFF4BF58AA2AF0BA56299D57A", hash_generated_field = "A6469B3C05A6E61AD188C77E4C87AFA0")

    private String typeString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.323 -0400", hash_original_field = "962FA027E49514EF42DADB2095E8C618", hash_generated_field = "1925D0B4ADBD655AA714AC16DE1F0973")

    private boolean unshared;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.323 -0400", hash_original_field = "08F60B1F77A7ECFDC92540AF3E6C2887", hash_generated_field = "B10B376FF3C60E9314732C46A8CA6340")

    private boolean isDeserialized;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.334 -0400", hash_original_method = "0D657EDEC08CB18117CF62EC578D6020", hash_generated_method = "7D64C1E5079C1595A78499F1CD7D2B04")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.334 -0400", hash_original_method = "B329D182B18083287B5598787B9BCF42", hash_generated_method = "549592D84BBC9126454BFC055E2D972B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.335 -0400", hash_original_method = "7045B1DBF21073AA43E994CE221E4094", hash_generated_method = "F2CB169C8FF966E2B41881A277E9476A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.335 -0400", hash_original_method = "11ADA6ED2A991966CB49663045730556", hash_generated_method = "D39F941F2698A02F72AE1E6291875393")
    public int compareTo(Object o) {
        ObjectStreamField f;
        f = (ObjectStreamField) o;
        boolean thisPrimitive;
        thisPrimitive = this.isPrimitive();
        boolean fPrimitive;
        fPrimitive = f.isPrimitive();
        int var2F3A4BA37EC730562BE97B6E5BC529E7_1798647187 = (this.getName().compareTo(f.getName()));
        addTaint(o.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1395140374 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1395140374;
        // ---------- Original Method ----------
        //ObjectStreamField f = (ObjectStreamField) o;
        //boolean thisPrimitive = this.isPrimitive();
        //boolean fPrimitive = f.isPrimitive();
        //if (thisPrimitive != fPrimitive) {
            //return thisPrimitive ? -1 : 1;
        //}
        //return this.getName().compareTo(f.getName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.337 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "C437D6C6D7EE197ED367CB7C66E0BE76")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_614779955 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_614779955 = name;
        varB4EAC82CA7396A68D541C85D26508E83_614779955.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_614779955;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.339 -0400", hash_original_method = "ACEB13DAA855070296BA592FB1ADADA1", hash_generated_method = "C993D4BC95B1D238895E5B7A60ECE1CE")
    public int getOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_720843548 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_720843548;
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.350 -0400", hash_original_method = "FF08482EB56AA685DDAE41A39E334998", hash_generated_method = "92A6504197574C0743832836E16ACA19")
     Class<?> getTypeInternal() {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1974857319 = null; //Variable for return #1
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1028151975 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1974857319 = (Class<?>) ((WeakReference<?>) type).get();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1028151975 = (Class<?>) type;
        Class<?> varA7E53CE21691AB073D9660D615818899_32222189; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_32222189 = varB4EAC82CA7396A68D541C85D26508E83_1974857319;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_32222189 = varB4EAC82CA7396A68D541C85D26508E83_1028151975;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_32222189.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_32222189;
        // ---------- Original Method ----------
        //if (type instanceof WeakReference) {
            //return (Class<?>) ((WeakReference<?>) type).get();
        //}
        //return (Class<?>) type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.351 -0400", hash_original_method = "9634509EF2A12286AE62950CEFC0E304", hash_generated_method = "6AED51BD17944843FBC8C6951CBD8ED4")
    public Class<?> getType() {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_462983083 = null; //Variable for return #1
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1014314115 = null; //Variable for return #2
        Class<?> cl;
        cl = getTypeInternal();
        {
            boolean varA3679B8742DABFD077DA559AF7FB1A74_537153829 = (isDeserialized && !cl.isPrimitive());
            {
                varB4EAC82CA7396A68D541C85D26508E83_462983083 = Object.class;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1014314115 = cl;
        Class<?> varA7E53CE21691AB073D9660D615818899_1919192406; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1919192406 = varB4EAC82CA7396A68D541C85D26508E83_462983083;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1919192406 = varB4EAC82CA7396A68D541C85D26508E83_1014314115;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1919192406.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1919192406;
        // ---------- Original Method ----------
        //Class<?> cl = getTypeInternal();
        //if (isDeserialized && !cl.isPrimitive()) {
            //return Object.class;
        //}
        //return cl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.352 -0400", hash_original_method = "6C03FA17A8A9EDC07915A4F462B31BC8", hash_generated_method = "5F2BD0F1EAB1D29CBA2C3FA2F6B21B08")
    public char getTypeCode() {
        char var1177AA956C7DA25FE5A8F4F00F47BA9F_351801439 = (typeCodeOf(getTypeInternal()));
        char varA87DEB01C5F539E6BDA34829C8EF2368_258473843 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_258473843;
        // ---------- Original Method ----------
        //return typeCodeOf(getTypeInternal());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.353 -0400", hash_original_method = "1261A37E9B201158D41DADA58D3D498E", hash_generated_method = "A3CA31264265269A1779E38D27F20C42")
    private char typeCodeOf(Class<?> type) {
        {
            boolean var6A7B33E76BE12D29FD67A26D06CDE611_862670117 = (type.isArray());
        } //End collapsed parenthetic
        addTaint(type.getTaint());
        char varA87DEB01C5F539E6BDA34829C8EF2368_960712388 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_960712388;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.357 -0400", hash_original_method = "AF834EA72E67DF4239AA5209B5DE5F81", hash_generated_method = "0CCD79207D645F51484A56151661A38E")
    public String getTypeString() {
        String varB4EAC82CA7396A68D541C85D26508E83_835943844 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1864443428 = null; //Variable for return #2
        {
            boolean var66A0FD8833FB78ABA18BF193F91E7A7D_1114788796 = (isPrimitive());
            {
                varB4EAC82CA7396A68D541C85D26508E83_835943844 = null;
            } //End block
        } //End collapsed parenthetic
        {
            Class<?> t;
            t = getTypeInternal();
            String typeName;
            typeName = t.getName().replace('.', '/');
            String str;
            boolean var5E131F98AD76D0BF9AAD526EFBF40306_1831694766 = ((t.isArray()));
            str = typeName;
            str = ("L" + typeName + ';');
            typeString = str.intern();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1864443428 = typeString;
        String varA7E53CE21691AB073D9660D615818899_824212785; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_824212785 = varB4EAC82CA7396A68D541C85D26508E83_835943844;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_824212785 = varB4EAC82CA7396A68D541C85D26508E83_1864443428;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_824212785.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_824212785;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.358 -0400", hash_original_method = "109BC8E5B51BF330504215C17ADD6478", hash_generated_method = "B0E8CC37088DCA17988C5A2972B20FCA")
    public boolean isPrimitive() {
        Class<?> t;
        t = getTypeInternal();
        boolean varB421F220FEF97A3E096A81B170604319_1232282104 = (t != null && t.isPrimitive());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1626622214 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1626622214;
        // ---------- Original Method ----------
        //Class<?> t = getTypeInternal();
        //return t != null && t.isPrimitive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.366 -0400", hash_original_method = "6EE925571D11CA9854483CD43D60AA5F", hash_generated_method = "A87E1A45024312DFAA5284056E00B4D1")
     boolean writeField(DataOutputStream out) throws IOException {
        Class<?> t;
        t = getTypeInternal();
        out.writeByte(typeCodeOf(t));
        out.writeUTF(name);
        boolean var7719FC2E2C2407A9C763B64F0A563F59_1737672711 = ((t != null && t.isPrimitive()));
        addTaint(out.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1995531182 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1995531182;
        // ---------- Original Method ----------
        //Class<?> t = getTypeInternal();
        //out.writeByte(typeCodeOf(t));
        //out.writeUTF(name);
        //return (t != null && t.isPrimitive());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.367 -0400", hash_original_method = "7A66A074CFBB1A834E24DFB5B3A643D5", hash_generated_method = "4305F7EB15B8D74A66017D2CC764F457")
    protected void setOffset(int newValue) {
        this.offset = newValue;
        // ---------- Original Method ----------
        //this.offset = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.372 -0400", hash_original_method = "ABFAE4540EC552EECBD4679559074925", hash_generated_method = "DAC93AD45BDB0CCCFE5689F40E4C0238")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1890776125 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1890776125 = this.getClass().getName() + '(' + getName() + ':' + getTypeInternal() + ')';
        varB4EAC82CA7396A68D541C85D26508E83_1890776125.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1890776125;
        // ---------- Original Method ----------
        //return this.getClass().getName() + '(' + getName() + ':' + getTypeInternal() + ')';
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.373 -0400", hash_original_method = "48E3281BF72BF66E5E96F9E4056E97FC", hash_generated_method = "05CBC22957A42ACE5E23F3F7CDDA4EDF")
     void resolve(ClassLoader loader) {
        {
            boolean var2D678C45C1F58BEAC668B5F88029903B_472815951 = (typeString == null && isPrimitive());
            {
                typeString = String.valueOf(getTypeCode());
            } //End block
        } //End collapsed parenthetic
        {
            boolean varF774A382C8A76B03DD267611340345A4_701354792 = (typeString.length() == 1);
            {
                {
                    boolean var38E4603B2800FF20134BFF86D9CC31CE_285921298 = (defaultResolve());
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        String className;
        className = typeString.replace('/', '.');
        {
            boolean var4A650C5F977360D4DD17F8170EBAC5FA_2030015651 = (className.charAt(0) == 'L');
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.373 -0400", hash_original_method = "F21E97E0131CF96F90294027D325F2F1", hash_generated_method = "B41E02648B84F64CEB2393B21A3C4F4B")
    public boolean isUnshared() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1150968730 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1150968730;
        // ---------- Original Method ----------
        //return unshared;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.374 -0400", hash_original_method = "68701E3ED15FAA74732CE575E0F04E5E", hash_generated_method = "78989AD0A169EB11A9E371D43CF1C2E1")
     void setUnshared(boolean unshared) {
        this.unshared = unshared;
        // ---------- Original Method ----------
        //this.unshared = unshared;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.384 -0400", hash_original_method = "E1E63B3BD3E5801BD481EB78C5FBD93C", hash_generated_method = "1324210E7CD0C388386530A17842FDEE")
    private boolean defaultResolve() {
        {
            Object varA76659841820C1031EE708C4EE618FAA_1073987285 = (typeString.charAt(0));
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1337840938 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1337840938;
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

