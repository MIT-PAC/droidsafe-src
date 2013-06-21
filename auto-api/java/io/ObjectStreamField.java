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
    private String name;
    private Object type;
    int offset;
    private String typeString;
    private boolean unshared;
    private boolean isDeserialized;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.174 -0400", hash_original_method = "0D657EDEC08CB18117CF62EC578D6020", hash_generated_method = "76C8C8E8C662BB165F33BA5CAAF503B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ObjectStreamField(String name, Class<?> cl) {
        dsTaint.addTaint(cl.dsTaint);
        dsTaint.addTaint(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        this.type = new WeakReference<Class<?>>(cl);
        // ---------- Original Method ----------
        //if (name == null || cl == null) {
            //throw new NullPointerException();
        //}
        //this.name = name;
        //this.type = new WeakReference<Class<?>>(cl);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.174 -0400", hash_original_method = "B329D182B18083287B5598787B9BCF42", hash_generated_method = "7577A693E9CD49E81E6606C196520D13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ObjectStreamField(String name, Class<?> cl, boolean unshared) {
        dsTaint.addTaint(unshared);
        dsTaint.addTaint(cl.dsTaint);
        dsTaint.addTaint(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.174 -0400", hash_original_method = "7045B1DBF21073AA43E994CE221E4094", hash_generated_method = "AB8D0C7D7EFED6319A3EC0C1F1639939")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ObjectStreamField(String signature, String name) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(signature);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.174 -0400", hash_original_method = "11ADA6ED2A991966CB49663045730556", hash_generated_method = "F3859BD90106E455E698C7CCEB911128")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int compareTo(Object o) {
        dsTaint.addTaint(o.dsTaint);
        ObjectStreamField f;
        f = (ObjectStreamField) o;
        boolean thisPrimitive;
        thisPrimitive = this.isPrimitive();
        boolean fPrimitive;
        fPrimitive = f.isPrimitive();
        int var2F3A4BA37EC730562BE97B6E5BC529E7_2091651151 = (this.getName().compareTo(f.getName()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.175 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "3573899E99121C9CFE87F9DDAEE36810")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.175 -0400", hash_original_method = "ACEB13DAA855070296BA592FB1ADADA1", hash_generated_method = "1CDEFA10A2F1E723CA8578AEEBEAF140")
    @DSModeled(DSC.SAFE)
    public int getOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return offset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.175 -0400", hash_original_method = "FF08482EB56AA685DDAE41A39E334998", hash_generated_method = "C94C8FC565C2438664AC02C9DDA2820A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Class<?> getTypeInternal() {
        {
            Class<?> var37E922112FD164FAA1FD46A51C3D9839_1088125844 = ((Class<?>) ((WeakReference<?>) type).get());
        } //End block
        return (Class<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (type instanceof WeakReference) {
            //return (Class<?>) ((WeakReference<?>) type).get();
        //}
        //return (Class<?>) type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.175 -0400", hash_original_method = "9634509EF2A12286AE62950CEFC0E304", hash_generated_method = "71D1A30A6F33B0CA88247797DA5511A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Class<?> getType() {
        Class<?> cl;
        cl = getTypeInternal();
        {
            boolean varA3679B8742DABFD077DA559AF7FB1A74_2103091614 = (isDeserialized && !cl.isPrimitive());
        } //End collapsed parenthetic
        return (Class<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Class<?> cl = getTypeInternal();
        //if (isDeserialized && !cl.isPrimitive()) {
            //return Object.class;
        //}
        //return cl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.175 -0400", hash_original_method = "6C03FA17A8A9EDC07915A4F462B31BC8", hash_generated_method = "CEBD9D10D97CF6DB17DAE228AA7C2780")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char getTypeCode() {
        char var1177AA956C7DA25FE5A8F4F00F47BA9F_258494311 = (typeCodeOf(getTypeInternal()));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return typeCodeOf(getTypeInternal());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.176 -0400", hash_original_method = "1261A37E9B201158D41DADA58D3D498E", hash_generated_method = "B23AD0B49926D4CB214178D07210AC1F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private char typeCodeOf(Class<?> type) {
        dsTaint.addTaint(type.dsTaint);
        {
            boolean var6A7B33E76BE12D29FD67A26D06CDE611_1921135690 = (type.isArray());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.176 -0400", hash_original_method = "AF834EA72E67DF4239AA5209B5DE5F81", hash_generated_method = "2A3C704526AA8D1BC3EBE857BA6905DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getTypeString() {
        {
            boolean var66A0FD8833FB78ABA18BF193F91E7A7D_1296373164 = (isPrimitive());
        } //End collapsed parenthetic
        {
            Class<?> t;
            t = getTypeInternal();
            String typeName;
            typeName = t.getName().replace('.', '/');
            String str;
            boolean var5E131F98AD76D0BF9AAD526EFBF40306_1414541865 = ((t.isArray()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.177 -0400", hash_original_method = "109BC8E5B51BF330504215C17ADD6478", hash_generated_method = "C41ED3716CE5C3D5F5609997760755C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isPrimitive() {
        Class<?> t;
        t = getTypeInternal();
        boolean varB421F220FEF97A3E096A81B170604319_316168574 = (t != null && t.isPrimitive());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Class<?> t = getTypeInternal();
        //return t != null && t.isPrimitive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.178 -0400", hash_original_method = "6EE925571D11CA9854483CD43D60AA5F", hash_generated_method = "4F53FA17AD217152127849F3CE604498")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean writeField(DataOutputStream out) throws IOException {
        dsTaint.addTaint(out.dsTaint);
        Class<?> t;
        t = getTypeInternal();
        out.writeByte(typeCodeOf(t));
        out.writeUTF(name);
        boolean var7719FC2E2C2407A9C763B64F0A563F59_1282092050 = ((t != null && t.isPrimitive()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Class<?> t = getTypeInternal();
        //out.writeByte(typeCodeOf(t));
        //out.writeUTF(name);
        //return (t != null && t.isPrimitive());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.179 -0400", hash_original_method = "7A66A074CFBB1A834E24DFB5B3A643D5", hash_generated_method = "040E9C91814A135377B6660D063F9782")
    @DSModeled(DSC.SAFE)
    protected void setOffset(int newValue) {
        dsTaint.addTaint(newValue);
        // ---------- Original Method ----------
        //this.offset = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.180 -0400", hash_original_method = "ABFAE4540EC552EECBD4679559074925", hash_generated_method = "79F796336F8C70817DC40B5538E67657")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var350C8D1821DF5F14E3D06B2B85E30460_770266124 = (this.getClass().getName() + '(' + getName() + ':' + getTypeInternal() + ')');
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.getClass().getName() + '(' + getName() + ':' + getTypeInternal() + ')';
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.180 -0400", hash_original_method = "48E3281BF72BF66E5E96F9E4056E97FC", hash_generated_method = "99E4DD30AFF04B2A58F37B266252A7B5")
    @DSModeled(DSC.BAN)
     void resolve(ClassLoader loader) {
        dsTaint.addTaint(loader.dsTaint);
        {
            boolean var2D678C45C1F58BEAC668B5F88029903B_975236689 = (typeString == null && isPrimitive());
            {
                typeString = String.valueOf(getTypeCode());
            } //End block
        } //End collapsed parenthetic
        {
            boolean varF774A382C8A76B03DD267611340345A4_159472398 = (typeString.length() == 1);
            {
                {
                    boolean var38E4603B2800FF20134BFF86D9CC31CE_1578071680 = (defaultResolve());
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        String className;
        className = typeString.replace('/', '.');
        {
            boolean var4A650C5F977360D4DD17F8170EBAC5FA_134102706 = (className.charAt(0) == 'L');
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.180 -0400", hash_original_method = "F21E97E0131CF96F90294027D325F2F1", hash_generated_method = "775E7D1A33FD3999AB99DC2AB2F01C1A")
    @DSModeled(DSC.SAFE)
    public boolean isUnshared() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return unshared;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.181 -0400", hash_original_method = "68701E3ED15FAA74732CE575E0F04E5E", hash_generated_method = "79D0B20E282E78FAEDC658F874CE354E")
    @DSModeled(DSC.SAFE)
     void setUnshared(boolean unshared) {
        dsTaint.addTaint(unshared);
        // ---------- Original Method ----------
        //this.unshared = unshared;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.181 -0400", hash_original_method = "E1E63B3BD3E5801BD481EB78C5FBD93C", hash_generated_method = "DA181FC0B521A1E498261D322078E4F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean defaultResolve() {
        {
            Object varA76659841820C1031EE708C4EE618FAA_1815962706 = (typeString.charAt(0));
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

