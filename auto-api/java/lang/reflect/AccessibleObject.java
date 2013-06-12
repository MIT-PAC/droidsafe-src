package java.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.annotation.Annotation;
import java.util.Hashtable;
import org.apache.harmony.kernel.vm.StringUtils;

public class AccessibleObject implements AnnotatedElement {
    boolean flag = false;
    static Hashtable<String, String> trans;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:08.238 -0400", hash_original_method = "79E776845C9774BB9614D2D0955EABCF", hash_generated_method = "798072FD9EE50D53DEA8C70295EC5904")
    @DSModeled(DSC.SAFE)
    protected AccessibleObject() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:08.249 -0400", hash_original_method = "670F990BF0D6A92A8F1AA8AC7F02D156", hash_generated_method = "68DE20ABD356D6F8D1ADEEEC1DD849F0")
    public static void setAccessible(AccessibleObject[] objects, boolean flag) {
        synchronized(AccessibleObject.class) {
            for (AccessibleObject object : objects) {
                object.flag = flag;
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:08.261 -0400", hash_original_method = "66D52F3844786BE4BB43647AC248F3A6", hash_generated_method = "23F39C54B5C743D51BC1727E5852962B")
    @DSModeled(DSC.SAFE)
    public boolean isAccessible() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:08.272 -0400", hash_original_method = "1000999C704703264C7A249C905DEAE6", hash_generated_method = "5AD99D4E051529026DEDFDAEA6B12B53")
    @DSModeled(DSC.SAFE)
    public void setAccessible(boolean flag) {
        dsTaint.addTaint(flag);
        // ---------- Original Method ----------
        //this.flag = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:08.283 -0400", hash_original_method = "8CC5FFC4D6878043D8F48CA01CEE9F83", hash_generated_method = "AF74B7A01D0C126E63B187A63935566C")
    @DSModeled(DSC.SAFE)
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(annotationType.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:08.306 -0400", hash_original_method = "0B7DCEEC0F2643B54E5B168F87B9CE3A", hash_generated_method = "77D8683201654F313967937DF78066EA")
    @DSModeled(DSC.SAFE)
    public Annotation[] getDeclaredAnnotations() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return (Annotation[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:08.316 -0400", hash_original_method = "CDE5472758ACF6CE75A2FF7BF6EF0F38", hash_generated_method = "312C258A51606F98231A278A7A2377DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Annotation[] getAnnotations() {
        Annotation[] var6F456C0B69D88C448B47E971C1CEA786_1974196767 = (getDeclaredAnnotations());
        return (Annotation[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getDeclaredAnnotations();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:08.325 -0400", hash_original_method = "E854D6B6A4F110252592FEF88B9AB0AA", hash_generated_method = "DBFF9CA2C660F4D6CBF912D46A35EB25")
    @DSModeled(DSC.SAFE)
    public <T extends Annotation> T getAnnotation(Class<T> annotationType) {
        dsTaint.addTaint(annotationType.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return (T)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:08.355 -0400", hash_original_method = "AFCD123A6E616CB6E7A6F8CAEE33C533", hash_generated_method = "FF53E7DD650E75D0C00BF6BCAC360CD3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     String getSignature(Class<?> clazz) {
        dsTaint.addTaint(clazz.dsTaint);
        String result;
        result = "";
        String nextType;
        nextType = clazz.getName();
        {
            boolean varB0CECCA2B4D7E05F335BC1240FF8707E_304090673 = (trans.containsKey(nextType));
            {
                result = trans.get(nextType);
            } //End block
            {
                {
                    boolean var89033C011C3D70F45494D634C893FFF8_1138884100 = (clazz.isArray());
                    {
                        result = "[" + getSignature(clazz.getComponentType());
                    } //End block
                    {
                        result = "L" + nextType + ";";
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //String result = "";
        //String nextType = clazz.getName();
        //if(trans.containsKey(nextType)) {
            //result = trans.get(nextType);
        //} else {
            //if(clazz.isArray()) {
                //result = "[" + getSignature(clazz.getComponentType());
            //} else {
                //result = "L" + nextType + ";";
            //}
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:08.391 -0400", hash_original_method = "538B7B8EC3794D6F6E22215297E953DA", hash_generated_method = "46C81A2D6A0993484A38CE977A910E06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     String toString(Class<?>[] types) {
        dsTaint.addTaint(types[0].dsTaint);
        StringBuilder result;
        result = new StringBuilder();
        {
            result.append(types[0].getName());
            {
                int i;
                i = 1;
                {
                    result.append(',');
                    result.append(types[i].getName());
                } //End block
            } //End collapsed parenthetic
        } //End block
        String varEA70154FDA28CC59402440C6317B57EF_83019752 = (result.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder();
        //if (types.length != 0) {
            //result.append(types[0].getName());
            //for (int i = 1; i < types.length; i++) {
                //result.append(',');
                //result.append(types[i].getName());
            //}
        //}
        //return result.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:08.402 -0400", hash_original_method = "595C9CE9F234EEA7E3334962F2566B38", hash_generated_method = "CC7EDD29668748A42B84CF43B980ABC1")
    @DSModeled(DSC.SAFE)
     String getSignatureAttribute() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:08.411 -0400", hash_original_method = "0EA85850CAF8D26BF10D52C824A0CA19", hash_generated_method = "48B4ABE2E7323E428D11CA7F6309669D")
    static String getClassSignatureAttribute(Class clazz) {
        Object[] annotation = getClassSignatureAnnotation(clazz);
        if (annotation == null) {
            return null;
        }
        return StringUtils.combineStrings(annotation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:08.416 -0400", hash_original_method = "67C020D23655E4A7F13FE58E656E68A1", hash_generated_method = "6F08FE928889572CD3740180BC0EB8D7")
    private static Object[] getClassSignatureAnnotation(Class clazz) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    	return new Object[]{clazz.dsTaint};
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:08.433 -0400", hash_original_method = "96346F5FDCAEE775233825443F323528", hash_generated_method = "857A7173B28402E64BB5F4ABF8369562")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void appendArrayType(StringBuilder sb, Class<?> obj) {
        dsTaint.addTaint(sb.dsTaint);
        dsTaint.addTaint(obj.dsTaint);
        int dimensions;
        dimensions = 0;
        {
            boolean var9993E8A418BE8C4A6D5358EC116C939A_263618280 = (obj.isArray());
            {
                obj = obj.getComponentType();
                dimensions++;
            } //End block
        } //End collapsed parenthetic
        sb.append(obj.getName());
        {
            int d;
            d = 0;
            {
                sb.append("[]");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //int dimensions = 0;
        //while (obj.isArray()) {
            //obj = obj.getComponentType();
            //dimensions++;
        //}
        //sb.append(obj.getName());
        //for (int d = 0; d < dimensions; d++) {
            //sb.append("[]");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:08.455 -0400", hash_original_method = "4331049DB20FE3D320265414E1BB6DD1", hash_generated_method = "4658A0EEA19F9F8EF0996D0C93C80762")
    @DSModeled(DSC.SAFE)
     void appendArrayGenericType(StringBuilder sb, Type[] types) {
        dsTaint.addTaint(sb.dsTaint);
        dsTaint.addTaint(types[0].dsTaint);
        {
            appendGenericType(sb, types[0]);
            {
                int i;
                i = 1;
                {
                    sb.append(',');
                    appendGenericType(sb, types[i]);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (types.length > 0) {
            //appendGenericType(sb, types[0]);
            //for (int i = 1; i < types.length; i++) {
                //sb.append(',');
                //appendGenericType(sb, types[i]);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:56:08.512 -0400", hash_original_method = "8E82FAA48BB361A9859A3C64A69CEBFA", hash_generated_method = "7A19465B09D96444C1F0374FD0746494")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void appendGenericType(StringBuilder sb, Type obj) {
        dsTaint.addTaint(sb.dsTaint);
        dsTaint.addTaint(obj.dsTaint);
        {
            sb.append(((TypeVariable)obj).getName());
        } //End block
        {
            sb.append(obj.toString());
        } //End block
        {
            Type simplified;
            simplified = ((GenericArrayType)obj).getGenericComponentType();
            appendGenericType(sb, simplified);
            sb.append("[]");
        } //End block
        {
            Class c;
            c = ((Class<?>)obj);
            {
                boolean var265EAD67919E0878EDE760B91A2663FE_1027909181 = (c.isArray());
                {
                    String as[];
                    as = c.getName().split("\\[");
                    int len;
                    len = as.length-1;
                    {
                        boolean var4E04E651982B5C19A261D19073E7D31F_300962005 = (as[len].length() > 1);
                        {
                            sb.append(as[len].substring(1, as[len].length()-1));
                        } //End block
                        {
                            char ch;
                            ch = as[len].charAt(0);
                            sb.append("int");
                            sb.append("byte");
                            sb.append("long");
                            sb.append("float");
                            sb.append("double");
                            sb.append("short");
                            sb.append("char");
                            sb.append("boolean");
                            sb.append("void");
                        } //End block
                    } //End collapsed parenthetic
                    {
                        int i;
                        i = 0;
                        {
                            sb.append("[]");
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    sb.append(c.getName());
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    static {
        trans = new Hashtable<String, String>(9);
        trans.put("byte", "B");
        trans.put("char", "C");
        trans.put("short", "S");
        trans.put("int", "I");
        trans.put("long", "J");
        trans.put("float", "F");
        trans.put("double", "D");
        trans.put("void", "V");
        trans.put("boolean", "Z");
    }
    
}


