package java.lang.reflect;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.lang.annotation.Annotation;
import java.util.Hashtable;

import org.apache.harmony.kernel.vm.StringUtils;






public class AccessibleObject implements AnnotatedElement {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.851 -0400", hash_original_field = "04B8D6DC602542C7D84E76F57842A90E", hash_generated_field = "D3CD6765000979577B5DA559E9F23C55")

    boolean flag = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.852 -0400", hash_original_method = "79E776845C9774BB9614D2D0955EABCF", hash_generated_method = "846450B6CD756FC6E1311C471B3C4B56")
    protected  AccessibleObject() {
        // ---------- Original Method ----------
    }

    
    public static void setAccessible(AccessibleObject[] objects, boolean flag) {
        synchronized(AccessibleObject.class) {
            for (AccessibleObject object : objects) {
                object.flag = flag;
            }
        }
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.853 -0400", hash_original_method = "66D52F3844786BE4BB43647AC248F3A6", hash_generated_method = "A431CEDB75725BFD4C637410E97E17BA")
    public boolean isAccessible() {
        boolean var327A6C4304AD5938EAF0EFB6CC3E53DC_261453950 = (flag);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2127618920 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2127618920;
        // ---------- Original Method ----------
        //return flag;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.853 -0400", hash_original_method = "1000999C704703264C7A249C905DEAE6", hash_generated_method = "D0859DDEC273DE0EC754854BC0CB46EB")
    public void setAccessible(boolean flag) {
        this.flag = flag;
        // ---------- Original Method ----------
        //this.flag = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.854 -0400", hash_original_method = "8CC5FFC4D6878043D8F48CA01CEE9F83", hash_generated_method = "1600934FB3C06B4EFCA75CF6D9ABC18E")
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        addTaint(annotationType.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1221689440 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1221689440.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1221689440;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.854 -0400", hash_original_method = "0B7DCEEC0F2643B54E5B168F87B9CE3A", hash_generated_method = "866C21F9DC66E2705DDD59B9AC495F42")
    public Annotation[] getDeclaredAnnotations() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_110590247 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_110590247.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_110590247;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.854 -0400", hash_original_method = "CDE5472758ACF6CE75A2FF7BF6EF0F38", hash_generated_method = "8DA0542F1FD48E720A95190061CB7FD4")
    public Annotation[] getAnnotations() {
Annotation[] var47CFE6C4A705F42D2CD6EF6EAC843F8E_396237079 =         getDeclaredAnnotations();
        var47CFE6C4A705F42D2CD6EF6EAC843F8E_396237079.addTaint(taint);
        return var47CFE6C4A705F42D2CD6EF6EAC843F8E_396237079;
        // ---------- Original Method ----------
        //return getDeclaredAnnotations();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.854 -0400", hash_original_method = "E854D6B6A4F110252592FEF88B9AB0AA", hash_generated_method = "3568A964D8BA23EB6D5CB01D72AE6A5D")
    public <T extends Annotation> T getAnnotation(Class<T> annotationType) {
        addTaint(annotationType.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1374839107 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1374839107.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1374839107;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.855 -0400", hash_original_method = "AFCD123A6E616CB6E7A6F8CAEE33C533", hash_generated_method = "63C21D3D052350C47BBA0A6CEC6D7662")
     String getSignature(Class<?> clazz) {
        addTaint(clazz.getTaint());
        String result = "";
        String nextType = clazz.getName();
        if(trans.containsKey(nextType))        
        {
            result = trans.get(nextType);
        } //End block
        else
        {
            if(clazz.isArray())            
            {
                result = "[" + getSignature(clazz.getComponentType());
            } //End block
            else
            {
                result = "L" + nextType + ";";
            } //End block
        } //End block
String varDC838461EE2FA0CA4C9BBB70A15456B0_1779165241 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1779165241.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1779165241;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.857 -0400", hash_original_method = "538B7B8EC3794D6F6E22215297E953DA", hash_generated_method = "D597D722AC3B7DB64B48427AEBF037C0")
     String toString(Class<?>[] types) {
        addTaint(types[0].getTaint());
        StringBuilder result = new StringBuilder();
        if(types.length != 0)        
        {
            result.append(types[0].getName());
for(int i = 1;i < types.length;i++)
            {
                result.append(',');
                result.append(types[i].getName());
            } //End block
        } //End block
String varE65B3A02759122992CB82C0E651AD408_764910252 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_764910252.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_764910252;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.858 -0400", hash_original_method = "595C9CE9F234EEA7E3334962F2566B38", hash_generated_method = "7B004C4FD903D6DE09EEABB79285DA58")
     String getSignatureAttribute() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_455306643 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_455306643.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_455306643;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    static String getClassSignatureAttribute(Class clazz) {
        Object[] annotation = getClassSignatureAnnotation(clazz);
        if (annotation == null) {
            return null;
        }
        return StringUtils.combineStrings(annotation);
    }

    
    @DSModeled(DSC.SAFE)
    private static Object[] getClassSignatureAnnotation(Class clazz) {
		Object[] ret = new Object[0];
		ret[0].addTaint(clazz.taint);
		return ret;
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.859 -0400", hash_original_method = "96346F5FDCAEE775233825443F323528", hash_generated_method = "EE7D264E102222A929FE18E054D1837D")
     void appendArrayType(StringBuilder sb, Class<?> obj) {
        addTaint(obj.getTaint());
        addTaint(sb.getTaint());
        int dimensions = 0;
        while
(obj.isArray())        
        {
            obj = obj.getComponentType();
            dimensions++;
        } //End block
        sb.append(obj.getName());
for(int d = 0;d < dimensions;d++)
        {
            sb.append("[]");
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.860 -0400", hash_original_method = "4331049DB20FE3D320265414E1BB6DD1", hash_generated_method = "DFA6C26E0F406FC1680B7B1A2B75D9CB")
     void appendArrayGenericType(StringBuilder sb, Type[] types) {
        addTaint(types[0].getTaint());
        addTaint(sb.getTaint());
        if(types.length > 0)        
        {
            appendGenericType(sb, types[0]);
for(int i = 1;i < types.length;i++)
            {
                sb.append(',');
                appendGenericType(sb, types[i]);
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.861 -0400", hash_original_method = "8E82FAA48BB361A9859A3C64A69CEBFA", hash_generated_method = "3702F5CF2AAC15B2E8B7485A23159E53")
     void appendGenericType(StringBuilder sb, Type obj) {
        addTaint(obj.getTaint());
        addTaint(sb.getTaint());
        if(obj instanceof TypeVariable)        
        {
            sb.append(((TypeVariable)obj).getName());
        } //End block
        else
        if(obj instanceof ParameterizedType)        
        {
            sb.append(obj.toString());
        } //End block
        else
        if(obj instanceof GenericArrayType)        
        {
            Type simplified = ((GenericArrayType)obj).getGenericComponentType();
            appendGenericType(sb, simplified);
            sb.append("[]");
        } //End block
        else
        if(obj instanceof Class)        
        {
            Class c = ((Class<?>)obj);
            if(c.isArray())            
            {
                String as[] = c.getName().split("\\[");
                int len = as.length-1;
                if(as[len].length() > 1)                
                {
                    sb.append(as[len].substring(1, as[len].length()-1));
                } //End block
                else
                {
                    char ch = as[len].charAt(0);
                    if(ch == 'I')                    
                    sb.append("int");
                    else
                    if(ch == 'B')                    
                    sb.append("byte");
                    else
                    if(ch == 'J')                    
                    sb.append("long");
                    else
                    if(ch == 'F')                    
                    sb.append("float");
                    else
                    if(ch == 'D')                    
                    sb.append("double");
                    else
                    if(ch == 'S')                    
                    sb.append("short");
                    else
                    if(ch == 'C')                    
                    sb.append("char");
                    else
                    if(ch == 'Z')                    
                    sb.append("boolean");
                    else
                    if(ch == 'V')                    
                    sb.append("void");
                } //End block
for(int i = 0;i < len;i++)
                {
                    sb.append("[]");
                } //End block
            } //End block
            else
            {
                sb.append(c.getName());
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:48.862 -0400", hash_original_field = "4738019EF434F24099319565CD5185E5", hash_generated_field = "F7E345322C5DA8049D7465C5406D9B9D")

    static Hashtable<String, String> trans;
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

