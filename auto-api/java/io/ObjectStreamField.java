package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Comparator;

public class ObjectStreamField implements Comparable<Object> {
    private String name;
    private Object type;
    int offset;
    private String typeString;
    private boolean unshared;
    private boolean isDeserialized;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.639 -0400", hash_original_method = "0D657EDEC08CB18117CF62EC578D6020", hash_generated_method = "B49716F96E32EB73C94644AEF316A137")
    @DSModeled(DSC.SAFE)
    public ObjectStreamField(String name, Class<?> cl) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(cl.dsTaint);
        if(DroidSafeAndroidRuntime.control) {
            throw new NullPointerException();
        } //End block
        this.type = new WeakReference<Class<?>>(cl);
        // ---------- Original Method ----------
        //if (name == null || cl == null) {
            //throw new NullPointerException();
        //}
        //this.name = name;
        //this.type = new WeakReference<Class<?>>(cl);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.639 -0400", hash_original_method = "B329D182B18083287B5598787B9BCF42", hash_generated_method = "3BA9A38662468CBA298055BDAD36FA8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ObjectStreamField(String name, Class<?> cl, boolean unshared) {
        dsTaint.addTaint(unshared);
        dsTaint.addTaint(name);
        dsTaint.addTaint(cl.dsTaint);
        if(DroidSafeAndroidRuntime.control) {
            throw new NullPointerException();
        } //End block
        this.type = (cl.getClassLoader() == null) ? cl : new WeakReference<Class<?>>(cl);
        // ---------- Original Method ----------
        //if (name == null || cl == null) {
            //throw new NullPointerException();
        //}
        //this.name = name;
        //this.type = (cl.getClassLoader() == null) ? cl : new WeakReference<Class<?>>(cl);
        //this.unshared = unshared;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.639 -0400", hash_original_method = "7045B1DBF21073AA43E994CE221E4094", hash_generated_method = "EF2D201D44B4AA0A7D455C1CDD9AE3DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ObjectStreamField(String signature, String name) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(signature);
        if(DroidSafeAndroidRuntime.control) {
            throw new NullPointerException();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.639 -0400", hash_original_method = "11ADA6ED2A991966CB49663045730556", hash_generated_method = "FBECAD1C9E0081595773198A59B9B810")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(Object o) {
        dsTaint.addTaint(o.dsTaint);
        ObjectStreamField f;
        f = (ObjectStreamField) o;
        boolean thisPrimitive;
        thisPrimitive = this.isPrimitive();
        boolean fPrimitive;
        fPrimitive = f.isPrimitive();
        int var2F3A4BA37EC730562BE97B6E5BC529E7_1635323262 = (this.getName().compareTo(f.getName()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //ObjectStreamField f = (ObjectStreamField) o;
        //boolean thisPrimitive = this.isPrimitive();
        //boolean fPrimitive = f.isPrimitive();
        //if (thisPrimitive != fPrimitive) {
            //return thisPrimitive ? -1 : 1;
        //}
        //return this.getName().compareTo(f.getName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.640 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "F47755EA38582EE7C3877DD72123E9B0")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.640 -0400", hash_original_method = "ACEB13DAA855070296BA592FB1ADADA1", hash_generated_method = "9E773AA9F80FD5DB16A41977D20928CE")
    @DSModeled(DSC.SAFE)
    public int getOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.640 -0400", hash_original_method = "FF08482EB56AA685DDAE41A39E334998", hash_generated_method = "CB09465C6042733405559184B75E6E59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Class<?> getTypeInternal() {
        {
            Class<?> var37E922112FD164FAA1FD46A51C3D9839_180257155 = ((Class<?>) ((WeakReference<?>) type).get());
        } //End block
        return (Class<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (type instanceof WeakReference) {
            //return (Class<?>) ((WeakReference<?>) type).get();
        //}
        //return (Class<?>) type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.640 -0400", hash_original_method = "9634509EF2A12286AE62950CEFC0E304", hash_generated_method = "CAFE914D9B8F13480FBF7245625133F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Class<?> getType() {
        Class<?> cl;
        cl = getTypeInternal();
        {
            boolean varA3679B8742DABFD077DA559AF7FB1A74_1976497572 = (isDeserialized && !cl.isPrimitive());
        } //End collapsed parenthetic
        return (Class<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Class<?> cl = getTypeInternal();
        //if (isDeserialized && !cl.isPrimitive()) {
            //return Object.class;
        //}
        //return cl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.640 -0400", hash_original_method = "6C03FA17A8A9EDC07915A4F462B31BC8", hash_generated_method = "676AF8AB6E795BB090AA4D3F5D835BA1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char getTypeCode() {
        char var1177AA956C7DA25FE5A8F4F00F47BA9F_1138662721 = (typeCodeOf(getTypeInternal()));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return typeCodeOf(getTypeInternal());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.640 -0400", hash_original_method = "1261A37E9B201158D41DADA58D3D498E", hash_generated_method = "DC4DBE75C683BA1756C9464CE1C6F9CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private char typeCodeOf(Class<?> type) {
        dsTaint.addTaint(type.dsTaint);
        {
            boolean var6A7B33E76BE12D29FD67A26D06CDE611_925085676 = (type.isArray());
        } //End collapsed parenthetic
        return dsTaint.getTaintChar();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.640 -0400", hash_original_method = "AF834EA72E67DF4239AA5209B5DE5F81", hash_generated_method = "C32D6E0A2E40B32E336CF05F5A4950C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getTypeString() {
        {
            boolean var66A0FD8833FB78ABA18BF193F91E7A7D_878076412 = (isPrimitive());
        } //End collapsed parenthetic
        {
            Class<?> t;
            t = getTypeInternal();
            String typeName;
            typeName = t.getName().replace('.', '/');
            String str;
            boolean var5E131F98AD76D0BF9AAD526EFBF40306_174107658 = ((t.isArray()));
            str = typeName;
            str = ("L" + typeName + ';');
            typeString = str.intern();
        } //End block
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.640 -0400", hash_original_method = "109BC8E5B51BF330504215C17ADD6478", hash_generated_method = "9C6D290FDF0769D0F9E96579C99A8C52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isPrimitive() {
        Class<?> t;
        t = getTypeInternal();
        boolean varB421F220FEF97A3E096A81B170604319_930553004 = (t != null && t.isPrimitive());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Class<?> t = getTypeInternal();
        //return t != null && t.isPrimitive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.640 -0400", hash_original_method = "6EE925571D11CA9854483CD43D60AA5F", hash_generated_method = "2E2EE94EFB854BFB38FC5079BFD1E1E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean writeField(DataOutputStream out) throws IOException {
        dsTaint.addTaint(out.dsTaint);
        Class<?> t;
        t = getTypeInternal();
        out.writeByte(typeCodeOf(t));
        out.writeUTF(name);
        boolean var7719FC2E2C2407A9C763B64F0A563F59_1645026793 = ((t != null && t.isPrimitive()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Class<?> t = getTypeInternal();
        //out.writeByte(typeCodeOf(t));
        //out.writeUTF(name);
        //return (t != null && t.isPrimitive());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.640 -0400", hash_original_method = "7A66A074CFBB1A834E24DFB5B3A643D5", hash_generated_method = "C53DC97C18508218E73572194714A4F9")
    @DSModeled(DSC.SAFE)
    protected void setOffset(int newValue) {
        dsTaint.addTaint(newValue);
        // ---------- Original Method ----------
        //this.offset = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.640 -0400", hash_original_method = "ABFAE4540EC552EECBD4679559074925", hash_generated_method = "78C86B61649FA293425243BCAA8AB0D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var350C8D1821DF5F14E3D06B2B85E30460_457094752 = (this.getClass().getName() + '(' + getName() + ':' + getTypeInternal() + ')');
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.getClass().getName() + '(' + getName() + ':' + getTypeInternal() + ')';
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.641 -0400", hash_original_method = "48E3281BF72BF66E5E96F9E4056E97FC", hash_generated_method = "6EF6DE48011E36EC8A4602E00D8241F4")
    @DSModeled(DSC.BAN)
     void resolve(ClassLoader loader) {
        dsTaint.addTaint(loader.dsTaint);
        {
            boolean var2D678C45C1F58BEAC668B5F88029903B_984530567 = (typeString == null && isPrimitive());
            {
                typeString = String.valueOf(getTypeCode());
            } //End block
        } //End collapsed parenthetic
        {
            boolean varF774A382C8A76B03DD267611340345A4_94292211 = (typeString.length() == 1);
            {
                {
                    boolean var38E4603B2800FF20134BFF86D9CC31CE_99762866 = (defaultResolve());
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        String className;
        className = typeString.replace('/', '.');
        {
            boolean var4A650C5F977360D4DD17F8170EBAC5FA_1849174590 = (className.charAt(0) == 'L');
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.641 -0400", hash_original_method = "F21E97E0131CF96F90294027D325F2F1", hash_generated_method = "E6684AA9AD5FC3ECD6ECA35F1206D36B")
    @DSModeled(DSC.SAFE)
    public boolean isUnshared() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return unshared;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.641 -0400", hash_original_method = "68701E3ED15FAA74732CE575E0F04E5E", hash_generated_method = "A3ABCA1D0BAA81E121AD63D685227BDD")
    @DSModeled(DSC.SAFE)
     void setUnshared(boolean unshared) {
        dsTaint.addTaint(unshared);
        // ---------- Original Method ----------
        //this.unshared = unshared;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.641 -0400", hash_original_method = "E1E63B3BD3E5801BD481EB78C5FBD93C", hash_generated_method = "10ED0D928EDA9F92BFB2C0AAB528DE23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean defaultResolve() {
        {
            Object varA76659841820C1031EE708C4EE618FAA_1826891263 = (typeString.charAt(0));
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
        return dsTaint.getTaintBoolean();
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


