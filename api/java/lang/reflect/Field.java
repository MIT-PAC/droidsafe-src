package java.lang.reflect;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.lang.annotation.Annotation;
import java.util.Comparator;

import org.apache.harmony.kernel.vm.StringUtils;
import org.apache.harmony.luni.lang.reflect.GenericSignatureParser;
import org.apache.harmony.luni.lang.reflect.Types;





import droidsafe.helpers.DSUtils;

public final class Field extends AccessibleObject implements Member {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.002 -0400", hash_original_field = "02CBE457FB1B22631E594CE79672D2F1", hash_generated_field = "EC96049C106D95C970CBF94E8CE21744")

    private Class<?> declaringClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.002 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "73346820208B59684010E2508B329B0F")

    private Class<?> type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.002 -0400", hash_original_field = "139EF988BED08F19F731C4392AB5A3AF", hash_generated_field = "DF8CDE4E2FC6AAB2D60A934C2A3F8E04")

    private Type genericType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.002 -0400", hash_original_field = "95A2153C74405BE971B467AB79B769A0", hash_generated_field = "89FDBAE6DE2AE55271071C78F774F101")

    private volatile boolean genericTypesAreInitialized = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.002 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.002 -0400", hash_original_field = "5E97994ED38A2B2F984F3B2B75012BF8", hash_generated_field = "6B06F56F1EB868ADA8CFFD63973A7E09")

    private int slot;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.003 -0400", hash_original_method = "18020B40E6468EB970BF7E1035466368", hash_generated_method = "056CC8AA5B0A121050D652E4EFA901DD")
      Field(Field orig) {
        this(orig.declaringClass, orig.type, orig.name, orig.slot);
        addTaint(orig.getTaint());
        if(orig.flag)        
        {
            this.flag = true;
        } //End block
        // ---------- Original Method ----------
        //if (orig.flag) {
            //this.flag = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.003 -0400", hash_original_method = "5600995DFD2A0F6D5A6AA1A0A4EAB766", hash_generated_method = "2E9BFB4D6DAB6C08310A7C3C788C3ADD")
    private  Field(Class<?> declaringClass, Class<?> type, String name, int slot) {
        this.declaringClass = declaringClass;
        this.type = type;
        this.name = name;
        this.slot = slot;
        // ---------- Original Method ----------
        //this.declaringClass = declaringClass;
        //this.type = type;
        //this.name = name;
        //this.slot = slot;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.004 -0400", hash_original_method = "5029B4C059F978BE158986B034FE3005", hash_generated_method = "7599278F3A909698F9008CA14287B9C3")
    private synchronized void initGenericType() {
        if(!genericTypesAreInitialized)        
        {
            String signatureAttribute = getSignatureAttribute();
            GenericSignatureParser parser = new GenericSignatureParser(
                    declaringClass.getClassLoader());
            parser.parseForField(this.declaringClass, signatureAttribute);
            genericType = parser.fieldType;
            if(genericType == null)            
            {
                genericType = getType();
            } //End block
            genericTypesAreInitialized = true;
        } //End block
        // ---------- Original Method ----------
        //if (!genericTypesAreInitialized) {
            //String signatureAttribute = getSignatureAttribute();
            //GenericSignatureParser parser = new GenericSignatureParser(
                    //declaringClass.getClassLoader());
            //parser.parseForField(this.declaringClass, signatureAttribute);
            //genericType = parser.fieldType;
            //if (genericType == null) {
                //genericType = getType();
            //}
            //genericTypesAreInitialized = true;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.005 -0400", hash_original_method = "1CDF5107AC443AA5F8C2E1DA9DF559A0", hash_generated_method = "FF71FB0B68CE9EF9C15AFC5B33E5A08F")
    @Override
     String getSignatureAttribute() {
        Object[] annotation = getSignatureAnnotation(declaringClass, slot);
        if(annotation == null)        
        {
String var540C13E9E156B687226421B24F2DF178_877177054 =             null;
            var540C13E9E156B687226421B24F2DF178_877177054.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_877177054;
        } //End block
String var2F8E51633C4B934C6A6871930033C26B_1366671226 =         StringUtils.combineStrings(annotation);
        var2F8E51633C4B934C6A6871930033C26B_1366671226.addTaint(taint);
        return var2F8E51633C4B934C6A6871930033C26B_1366671226;
        // ---------- Original Method ----------
        //Object[] annotation = getSignatureAnnotation(declaringClass, slot);
        //if (annotation == null) {
            //return null;
        //}
        //return StringUtils.combineStrings(annotation);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.759 -0400", hash_original_method = "5161131687230E0D7EE89383FDDF9117", hash_generated_method = "F1BBACEA836E9C65FE0E5D9A22FF7006")
    private Object[] getSignatureAnnotation(Class declaringClass, int slot) {
    	addTaint(declaringClass.taint);
    	addTaint(slot);
    	return new Object[0];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.005 -0400", hash_original_method = "FC3424D2079ACBF27BEC7269ECB48C94", hash_generated_method = "858FFC64DB364569AD8C7C04E483CA87")
    public boolean isSynthetic() {
        int flags = getFieldModifiers(declaringClass, slot);
        boolean varFADE1C997A9FC78A7EDD7EA957F18741_1624737362 = ((flags & Modifier.SYNTHETIC) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_76765700 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_76765700;
        // ---------- Original Method ----------
        //int flags = getFieldModifiers(declaringClass, slot);
        //return (flags & Modifier.SYNTHETIC) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.006 -0400", hash_original_method = "E96960960A41CE3DD754F7ED4B73683A", hash_generated_method = "C60A06D975F521900A0F52AC4D3CA8F9")
    public String toGenericString() {
        StringBuilder sb = new StringBuilder(80);
        int modifier = getModifiers();
        if(modifier != 0)        
        {
            sb.append(Modifier.toString(modifier)).append(' ');
        } //End block
        appendGenericType(sb, getGenericType());
        sb.append(' ');
        sb.append(getDeclaringClass().getName()).append('.').append(getName());
String var2460B846747F8B22185AD8BE722266A5_700738073 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_700738073.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_700738073;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(80);
        //int modifier = getModifiers();
        //if (modifier != 0) {
            //sb.append(Modifier.toString(modifier)).append(' ');
        //}
        //appendGenericType(sb, getGenericType());
        //sb.append(' ');
        //sb.append(getDeclaringClass().getName()).append('.').append(getName());
        //return sb.toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.006 -0400", hash_original_method = "2827C86400F787FBBD0EA58BB5706D02", hash_generated_method = "39C08327158DB0D5B6337487E206B3F8")
    public boolean isEnumConstant() {
        int flags = getFieldModifiers(declaringClass, slot);
        boolean var9FA5853F59B901E598FD548D3E283FC3_234142516 = ((flags & Modifier.ENUM) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1327428102 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1327428102;
        // ---------- Original Method ----------
        //int flags = getFieldModifiers(declaringClass, slot);
        //return (flags & Modifier.ENUM) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.007 -0400", hash_original_method = "963F10B2A4697E7A9ECC1BB94066D74F", hash_generated_method = "5D12C0FE3DCA0B0E814C8439618EFF90")
    public Type getGenericType() {
        initGenericType();
Type var3CE4A4E61FC97920A085126FE74A2E59_1879486325 =         Types.getType(genericType);
        var3CE4A4E61FC97920A085126FE74A2E59_1879486325.addTaint(taint);
        return var3CE4A4E61FC97920A085126FE74A2E59_1879486325;
        // ---------- Original Method ----------
        //initGenericType();
        //return Types.getType(genericType);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.007 -0400", hash_original_method = "4122EC91CDDE6FFD9DA08F5ADAF8DB5D", hash_generated_method = "8F2A463A87496E91226E406769CA318E")
    @Override
    public Annotation[] getDeclaredAnnotations() {
Annotation[] varD68AC863F3425367D397905DE25428DB_1513461983 =         getDeclaredAnnotations(declaringClass, slot);
        varD68AC863F3425367D397905DE25428DB_1513461983.addTaint(taint);
        return varD68AC863F3425367D397905DE25428DB_1513461983;
        // ---------- Original Method ----------
        //return getDeclaredAnnotations(declaringClass, slot);
    }

    
    @DSModeled(DSC.SAFE)
    private static Annotation[] getDeclaredAnnotations(Class declaringClass, int slot) {
    	Annotation[] ret = new Annotation[0];
    	ret[0].addTaint(declaringClass.taint);
    	ret[0].addTaint(slot);
    	return ret;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.008 -0400", hash_original_method = "C04F97610183E33B13FB9B4273375B6D", hash_generated_method = "5FA34C6FB9279968DCAA09543A6D1EB0")
    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        addTaint(annotationType.getTaint());
        if(annotationType == null)        
        {
            NullPointerException varD3565833EFC12BC5822ABFE94D257EDE_286909647 = new NullPointerException("annotationType == null");
            varD3565833EFC12BC5822ABFE94D257EDE_286909647.addTaint(taint);
            throw varD3565833EFC12BC5822ABFE94D257EDE_286909647;
        } //End block
A varD37D33C5EE02B81A7F8EF45A88B88039_1884546761 =         getAnnotation(declaringClass, slot, annotationType);
        varD37D33C5EE02B81A7F8EF45A88B88039_1884546761.addTaint(taint);
        return varD37D33C5EE02B81A7F8EF45A88B88039_1884546761;
        // ---------- Original Method ----------
        //if (annotationType == null) {
            //throw new NullPointerException("annotationType == null");
        //}
        //return getAnnotation(declaringClass, slot, annotationType);
    }

    
    @DSModeled(DSC.SAFE)
    private static <A extends Annotation> A getAnnotation(
            Class<?> declaringClass, int slot, Class<A> annotationType) {
    	A ret = (A)new Object();
    	ret.addTaint(declaringClass.taint);
    	ret.addTaint(slot);
    	ret.addTaint(annotationType.taint);
    	return ret;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.008 -0400", hash_original_method = "D8B142EB73E138FF5927E6AE1DAD56D2", hash_generated_method = "3CFEB24D50D7D8F8D5EE820F7B3D94C4")
    @Override
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        addTaint(annotationType.getTaint());
        if(annotationType == null)        
        {
            NullPointerException varD3565833EFC12BC5822ABFE94D257EDE_426027771 = new NullPointerException("annotationType == null");
            varD3565833EFC12BC5822ABFE94D257EDE_426027771.addTaint(taint);
            throw varD3565833EFC12BC5822ABFE94D257EDE_426027771;
        } //End block
        boolean var000A6E1BC96B3549B82B47E3D3F09F9E_30965638 = (isAnnotationPresent(declaringClass, slot, annotationType));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1620306611 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1620306611;
        // ---------- Original Method ----------
        //if (annotationType == null) {
            //throw new NullPointerException("annotationType == null");
        //}
        //return isAnnotationPresent(declaringClass, slot, annotationType);
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean isAnnotationPresent(
            Class<?> declaringClass, int slot, Class<? extends Annotation> annotationType) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1800919321 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1800919321;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.009 -0400", hash_original_method = "955F27DFEC9F7B5FBB7D8BD5BE41A050", hash_generated_method = "76B2C24257BD3B5CB993228A56B7CF82")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        boolean varE519BF50CC7591FF34EF5E2F19AB7CAD_381547378 = (object instanceof Field && toString().equals(object.toString()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1407050619 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1407050619;
        // ---------- Original Method ----------
        //return object instanceof Field && toString().equals(object.toString());
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.010 -0400", hash_original_method = "7AE3BC00249CC99885BB0445C93FB18A", hash_generated_method = "4B7B83C96E7AA37593001CF2DB5E01DC")
    public Object get(Object object) throws IllegalAccessException, IllegalArgumentException {
        addTaint(object.getTaint());
Object var7995FC01A88811E5E97CF2E73643495D_1945262284 =         getField(object, declaringClass, type, slot, flag);
        var7995FC01A88811E5E97CF2E73643495D_1945262284.addTaint(taint);
        return var7995FC01A88811E5E97CF2E73643495D_1945262284;
        // ---------- Original Method ----------
        //return getField(object, declaringClass, type, slot, flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.010 -0400", hash_original_method = "27492232D5FCC61236B83BF948F6F104", hash_generated_method = "75FE70B5817C0425E0D0DBA1768BAA30")
    public boolean getBoolean(Object object) throws IllegalAccessException,
            IllegalArgumentException {
        addTaint(object.getTaint());
        boolean varA34B9D25372271D3D678C969755AA0F6_499271778 = (getZField(object, declaringClass, type, slot, flag, TYPE_BOOLEAN));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1393198634 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1393198634;
        // ---------- Original Method ----------
        //return getZField(object, declaringClass, type, slot, flag, TYPE_BOOLEAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.010 -0400", hash_original_method = "638C7C4918F4FDF5130555C74F583890", hash_generated_method = "3F14B89CD0FE76772E4BC8CFBA38057A")
    public byte getByte(Object object) throws IllegalAccessException, IllegalArgumentException {
        addTaint(object.getTaint());
        byte varF56DDD897B433F06B3CD7D819B779FA0_91587396 = (getBField(object, declaringClass, type, slot, flag, TYPE_BYTE));
                byte var40EA57D3EE3C07BF1C102B466E1C3091_328976226 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_328976226;
        // ---------- Original Method ----------
        //return getBField(object, declaringClass, type, slot, flag, TYPE_BYTE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.010 -0400", hash_original_method = "6648A25494EBFE26376F66DF9331BADB", hash_generated_method = "2FA552AD0E8ABFB7E94D157A51104044")
    public char getChar(Object object) throws IllegalAccessException, IllegalArgumentException {
        addTaint(object.getTaint());
        char var7D1877BFABCFCBDBFCBBD77F78E5CB81_1810849128 = (getCField(object, declaringClass, type, slot, flag, TYPE_CHAR));
                char varA87DEB01C5F539E6BDA34829C8EF2368_1524804409 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1524804409;
        // ---------- Original Method ----------
        //return getCField(object, declaringClass, type, slot, flag, TYPE_CHAR);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.011 -0400", hash_original_method = "747BEFE9985C4AF4EE3D5630B62185EA", hash_generated_method = "4924608B8A7258EA0FAD0A7A640CA95F")
    public Class<?> getDeclaringClass() {
Class<?> var55840ACAE88F5536515BB8E6ADD923C6_391083683 =         declaringClass;
        var55840ACAE88F5536515BB8E6ADD923C6_391083683.addTaint(taint);
        return var55840ACAE88F5536515BB8E6ADD923C6_391083683;
        // ---------- Original Method ----------
        //return declaringClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.011 -0400", hash_original_method = "B22A8667913C0820CACD3D8F78E3B803", hash_generated_method = "686B5CB6AE469F34D8009509FBA3510F")
    public double getDouble(Object object) throws IllegalAccessException, IllegalArgumentException {
        addTaint(object.getTaint());
        double var2DCB9D3247409ACAE9B6D0BC10E539BE_2043269526 = (getDField(object, declaringClass, type, slot, flag, TYPE_DOUBLE));
                double varE8CD7DA078A86726031AD64F35F5A6C0_1234837493 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1234837493;
        // ---------- Original Method ----------
        //return getDField(object, declaringClass, type, slot, flag, TYPE_DOUBLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.011 -0400", hash_original_method = "BFF553DA1989441891013747E355F341", hash_generated_method = "4C91F00844D29DB79AFA5246AC8551B5")
    public float getFloat(Object object) throws IllegalAccessException, IllegalArgumentException {
        addTaint(object.getTaint());
        float var5B76F495DEAEC526BE2C15B6755CCDFF_369035397 = (getFField(object, declaringClass, type, slot, flag, TYPE_FLOAT));
                float var546ADE640B6EDFBC8A086EF31347E768_812567403 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_812567403;
        // ---------- Original Method ----------
        //return getFField(object, declaringClass, type, slot, flag, TYPE_FLOAT);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.012 -0400", hash_original_method = "5CB83BC53ADA020FA0FD37C15AAD9E62", hash_generated_method = "6E585F118CDEFD514651ECA4CC7C6BC0")
    public int getInt(Object object) throws IllegalAccessException, IllegalArgumentException {
        addTaint(object.getTaint());
        int var50B3C28304687A6D79FE383AFD7E84A3_1792544633 = (getIField(object, declaringClass, type, slot, flag, TYPE_INTEGER));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1175566355 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1175566355;
        // ---------- Original Method ----------
        //return getIField(object, declaringClass, type, slot, flag, TYPE_INTEGER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.012 -0400", hash_original_method = "005A2557A921AA55BF8BDBCBDC639BE4", hash_generated_method = "E6C891BD482B211824A9E829A97024B0")
    public long getLong(Object object) throws IllegalAccessException, IllegalArgumentException {
        addTaint(object.getTaint());
        long var8CCAE232F40D54FA1F4064F5546025DF_148098084 = (getJField(object, declaringClass, type, slot, flag, TYPE_LONG));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_592060957 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_592060957;
        // ---------- Original Method ----------
        //return getJField(object, declaringClass, type, slot, flag, TYPE_LONG);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.012 -0400", hash_original_method = "5A676A538E8952F6729F0D8423178A33", hash_generated_method = "985A2FD607479EF30EABA9B14A6A727E")
    public int getModifiers() {
        int var5A21DFF9A4E45BEE9AF69069B6808DEF_1724906113 = (getFieldModifiers(declaringClass, slot));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1131142683 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1131142683;
        // ---------- Original Method ----------
        //return getFieldModifiers(declaringClass, slot);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.013 -0400", hash_original_method = "9D513D500FBFD57DB21A924D9A85826A", hash_generated_method = "01C6E8B3E99D6BC2ADAFE6B5BA729DFA")
    private int getFieldModifiers(Class<?> declaringClass, int slot) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1613064832 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1613064832;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.013 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "02269601D384DAECDBB052B2357FAD5C")
    public String getName() {
String varB017984728AC60AD1F0BF8734F33F15C_1839843716 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_1839843716.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_1839843716;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.013 -0400", hash_original_method = "0DDA5605A2464ED398902817D939E3F2", hash_generated_method = "245A9F0DBA30E3CDA4CAD3794A1252CC")
    public short getShort(Object object) throws IllegalAccessException, IllegalArgumentException {
        addTaint(object.getTaint());
        short varC70CFA5FC6A1C471897DA0AAF3879A0D_1479318731 = (getSField(object, declaringClass, type, slot, flag, TYPE_SHORT));
                short var4F09DAA9D95BCB166A302407A0E0BABE_1134398333 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1134398333;
        // ---------- Original Method ----------
        //return getSField(object, declaringClass, type, slot, flag, TYPE_SHORT);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.013 -0400", hash_original_method = "994767CE6492BCD5B50ECB089389E539", hash_generated_method = "5D7294B8827B49C2CC53AAD3E29B4F41")
    @SuppressWarnings("unused")
    private String getSignature() {
String var669825FFD7E3ACD0942E1A8D9403D236_1352633250 =         getSignature(type);
        var669825FFD7E3ACD0942E1A8D9403D236_1352633250.addTaint(taint);
        return var669825FFD7E3ACD0942E1A8D9403D236_1352633250;
        // ---------- Original Method ----------
        //return getSignature(type);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.014 -0400", hash_original_method = "21C93A7CC51FD6114C8D944747F943F4", hash_generated_method = "8381A3F4730BD5D1DE5470307D1F2092")
    public Class<?> getType() {
Class<?> varC5B9F25B4EEAD3E8E2C33F9429204397_1396214102 =         type;
        varC5B9F25B4EEAD3E8E2C33F9429204397_1396214102.addTaint(taint);
        return varC5B9F25B4EEAD3E8E2C33F9429204397_1396214102;
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.014 -0400", hash_original_method = "7C0B16AD34D2790FBD73D96D003DD91D", hash_generated_method = "D70300403D980EAEE6AAFD01B38D5533")
    @Override
    public int hashCode() {
        int var3A37DE6E508D6672DE4E48080720192A_452460703 = (name.hashCode() ^ getDeclaringClass().getName().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_645519455 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_645519455;
        // ---------- Original Method ----------
        //return name.hashCode() ^ getDeclaringClass().getName().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.014 -0400", hash_original_method = "6D24AA0F6B01F01D922DBBA93FD91F81", hash_generated_method = "62C72115E0B338F718DA287637B5771C")
    public void set(Object object, Object value) throws IllegalAccessException,
            IllegalArgumentException {
        addTaint(value.getTaint());
        addTaint(object.getTaint());
        setField(object, declaringClass, type, slot, flag, value);
        // ---------- Original Method ----------
        //setField(object, declaringClass, type, slot, flag, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.015 -0400", hash_original_method = "25FFB4639E444F2A9FD12AF0E909B7A5", hash_generated_method = "694F415475AE6488899623BA671E185D")
    public void setBoolean(Object object, boolean value) throws IllegalAccessException,
            IllegalArgumentException {
        addTaint(value);
        addTaint(object.getTaint());
        setZField(object, declaringClass, type, slot, flag, TYPE_BOOLEAN, value);
        // ---------- Original Method ----------
        //setZField(object, declaringClass, type, slot, flag, TYPE_BOOLEAN, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.015 -0400", hash_original_method = "AD912B9A4F5D11756FF2F9AE3FC4D6E6", hash_generated_method = "6C2DFB2557346BA99AD390D5490279E8")
    public void setByte(Object object, byte value) throws IllegalAccessException,
            IllegalArgumentException {
        addTaint(value);
        addTaint(object.getTaint());
        setBField(object, declaringClass, type, slot, flag, TYPE_BYTE, value);
        // ---------- Original Method ----------
        //setBField(object, declaringClass, type, slot, flag, TYPE_BYTE, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.015 -0400", hash_original_method = "97D79EA86FEBB11A4E8B5CD3EFF3DEF5", hash_generated_method = "220C753A236F2D5E328E01C8A007433F")
    public void setChar(Object object, char value) throws IllegalAccessException,
            IllegalArgumentException {
        addTaint(value);
        addTaint(object.getTaint());
        setCField(object, declaringClass, type, slot, flag, TYPE_CHAR, value);
        // ---------- Original Method ----------
        //setCField(object, declaringClass, type, slot, flag, TYPE_CHAR, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.016 -0400", hash_original_method = "5E12E36ACBA66ADB7DF4FF63170F60C3", hash_generated_method = "91A53C2E4CC1BA6AC18E1590358CEC5A")
    public void setDouble(Object object, double value) throws IllegalAccessException,
            IllegalArgumentException {
        addTaint(value);
        addTaint(object.getTaint());
        setDField(object, declaringClass, type, slot, flag, TYPE_DOUBLE, value);
        // ---------- Original Method ----------
        //setDField(object, declaringClass, type, slot, flag, TYPE_DOUBLE, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.016 -0400", hash_original_method = "4860783C5B567E2FC646E7FC5AE81E3C", hash_generated_method = "13D35F9A5856724054ACB3945D3A874F")
    public void setFloat(Object object, float value) throws IllegalAccessException,
            IllegalArgumentException {
        addTaint(value);
        addTaint(object.getTaint());
        setFField(object, declaringClass, type, slot, flag, TYPE_FLOAT, value);
        // ---------- Original Method ----------
        //setFField(object, declaringClass, type, slot, flag, TYPE_FLOAT, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.016 -0400", hash_original_method = "DA13B1330D08A636280F51E51FF711B2", hash_generated_method = "E01C13D06D78006386ED59C5C3B8EADD")
    public void setInt(Object object, int value) throws IllegalAccessException,
            IllegalArgumentException {
        addTaint(value);
        addTaint(object.getTaint());
        setIField(object, declaringClass, type, slot, flag, TYPE_INTEGER, value);
        // ---------- Original Method ----------
        //setIField(object, declaringClass, type, slot, flag, TYPE_INTEGER, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.016 -0400", hash_original_method = "F703AA23CA1EF460C68B245887B2C6B7", hash_generated_method = "10464828688C5DE538720D33A95AD3B2")
    public void setLong(Object object, long value) throws IllegalAccessException,
            IllegalArgumentException {
        addTaint(value);
        addTaint(object.getTaint());
        setJField(object, declaringClass, type, slot, flag, TYPE_LONG, value);
        // ---------- Original Method ----------
        //setJField(object, declaringClass, type, slot, flag, TYPE_LONG, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.017 -0400", hash_original_method = "DEE843BD220F8992FC80A23844FC7C06", hash_generated_method = "AAD2487A62A8B9DAEB8ADEF82CB3C0A7")
    public void setShort(Object object, short value) throws IllegalAccessException,
            IllegalArgumentException {
        addTaint(value);
        addTaint(object.getTaint());
        setSField(object, declaringClass, type, slot, flag, TYPE_SHORT, value);
        // ---------- Original Method ----------
        //setSField(object, declaringClass, type, slot, flag, TYPE_SHORT, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.017 -0400", hash_original_method = "2B14553F8A926216EE23C791DBC737FD", hash_generated_method = "A8B180D0D4389FF6202AC5514F1E2626")
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(Modifier.toString(getModifiers()));
        if(result.length() != 0)        
        {
            result.append(' ');
        } //End block
        appendArrayType(result, type);
        result.append(' ');
        result.append(declaringClass.getName());
        result.append('.');
        result.append(name);
String varE65B3A02759122992CB82C0E651AD408_1830058780 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_1830058780.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_1830058780;
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder(Modifier.toString(getModifiers()));
        //if (result.length() != 0) {
            //result.append(' ');
        //}
        //appendArrayType(result, type);
        //result.append(' ');
        //result.append(declaringClass.getName());
        //result.append('.');
        //result.append(name);
        //return result.toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.775 -0400", hash_original_method = "2E771D0497C584665EAFE5039BCB9B58", hash_generated_method = "5DD6344BFC9E3A8D7857167F9BE20F54")
    private Object getField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck) throws IllegalAccessException {
    	addTaint(o.taint);
    	addTaint(declaringClass.taint);
    	addTaint(type.taint);
    	addTaint(slot);
    	addTaint(noAccessCheck);
    	return new Object();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.017 -0400", hash_original_method = "E4CBB65FF20F2B42AAAA5852C9FC84C9", hash_generated_method = "8396E9C14AE0C40D44FDEA76EF7C8432")
    private double getDField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        double varE8CD7DA078A86726031AD64F35F5A6C0_391885593 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_391885593;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.017 -0400", hash_original_method = "9B86AA05444EF83A8159E0D0E3B46582", hash_generated_method = "B4DD82AC20558F71B3B91C2FF3B39B59")
    private int getIField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1990721880 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1990721880;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.018 -0400", hash_original_method = "1F116F930DBB16C5DB58ABA31954B7AA", hash_generated_method = "CE93230546969F87F97D81BF85189217")
    private long getJField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1640411726 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1640411726;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.018 -0400", hash_original_method = "50BE3A9E4BA3ACB6450AF3382B17C97D", hash_generated_method = "DE147589762BFD5D8B62D7EDA9E76E47")
    private boolean getZField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_577319465 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_577319465;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.018 -0400", hash_original_method = "94E059571B5D65D86B6231E7D36BF7FA", hash_generated_method = "920C736415958B73CACD123A446370B1")
    private float getFField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        float var546ADE640B6EDFBC8A086EF31347E768_2104692906 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2104692906;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.018 -0400", hash_original_method = "9A55E198BD753BB34F159FBC2807D96E", hash_generated_method = "C9259410007F71A0FDE3201AA9C7831B")
    private char getCField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        char varA87DEB01C5F539E6BDA34829C8EF2368_2083032636 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_2083032636;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.018 -0400", hash_original_method = "9FE268B454DA8902066BFF2BFC132935", hash_generated_method = "574FFDE696A057BF151A23A111704EEA")
    private short getSField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        short var4F09DAA9D95BCB166A302407A0E0BABE_909753051 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_909753051;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.018 -0400", hash_original_method = "B020FC56F3182544B11E7C259C9C5B21", hash_generated_method = "A1C9B6B6E3D0FE7011DDEA14F6369812")
    private byte getBField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        byte var40EA57D3EE3C07BF1C102B466E1C3091_70606866 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_70606866;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.019 -0400", hash_original_method = "D9AA799947323C8F653B1139DF380855", hash_generated_method = "C408ADE9BAD371E4961776A5655ECA1D")
    private void setField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, Object value) throws IllegalAccessException {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.019 -0400", hash_original_method = "3CCE00B68111CAA3AA20979F21B904D8", hash_generated_method = "3179919531A6B77C3D15EE892C5A42ED")
    private void setDField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, double v) throws IllegalAccessException {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.019 -0400", hash_original_method = "32CBAB454E52D8BFC71D6AB87E7BF1FE", hash_generated_method = "0AD27F9AC1D9709615BF81BE0EC00C6F")
    private void setIField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, int i) throws IllegalAccessException {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.019 -0400", hash_original_method = "7CE46D8AB646DF2CA9A88ACDCE998029", hash_generated_method = "6C698AE9F78C7DE632773059C8D4BC97")
    private void setJField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, long j) throws IllegalAccessException {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.019 -0400", hash_original_method = "E80188BF0543922F0F2BDA0A103D17F5", hash_generated_method = "72E8231E78B1D9BCE0F14C1F2F070F7A")
    private void setZField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, boolean z) throws IllegalAccessException {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.019 -0400", hash_original_method = "570BC71D32CB4741615EF7701079ED2D", hash_generated_method = "8275ADFFBEC551D7D79BD7EB97FC5146")
    private void setFField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, float f) throws IllegalAccessException {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.020 -0400", hash_original_method = "ACD0A6EABB934CC5EEECCAB72AA01730", hash_generated_method = "13FE5F042DD294402F9D22C992CA140C")
    private void setCField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, char c) throws IllegalAccessException {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.020 -0400", hash_original_method = "2A0F6C37A6B68BD24BAC15A31879F06F", hash_generated_method = "4F3A9A2CC7778961778A3052697CE1D8")
    private void setSField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, short s) throws IllegalAccessException {
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.020 -0400", hash_original_method = "4D8B3646C0E699793861ED8487ADC739", hash_generated_method = "D5189C3BB7F03AFCF5839741EE6876A2")
    private void setBField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, byte b) throws IllegalAccessException {
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.020 -0400", hash_original_field = "53D2DF7F6A0025522B6A62D7BCCD362B", hash_generated_field = "FE1CC35DA4EB56C9880DCB488708D9CB")

    public static final Comparator<Field> ORDER_BY_NAME_AND_DECLARING_CLASS
            = new Comparator<Field>() {
        @Override public int compare(Field a, Field b) {
            int comparison = a.name.compareTo(b.name);
            if (comparison != 0) {
                return comparison;
            }

            return a.getDeclaringClass().getName().compareTo(b.getDeclaringClass().getName());
        }
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.020 -0400", hash_original_field = "6F4F342B95B25A4C75EC3E906175F9FD", hash_generated_field = "0B71E07F68242E0883FB03EAE37B4026")

    private static final char TYPE_BOOLEAN = 'Z';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.020 -0400", hash_original_field = "CB54D6511967B2F9F10D18E7AE656028", hash_generated_field = "A2F4D86DAE2B010C8D5C08013F0683CA")

    private static final char TYPE_BYTE = 'B';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.020 -0400", hash_original_field = "34382A0DD8E04475FFB7D187E09259D6", hash_generated_field = "AAD9FB3C86B29282B83CDD80DE09CFA0")

    private static final char TYPE_CHAR = 'C';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.020 -0400", hash_original_field = "F7285E854CB9D5C401C99397EC300E2B", hash_generated_field = "EFF96E3ED8672BC1006A65B4ACD711D8")

    private static final char TYPE_SHORT = 'S';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.020 -0400", hash_original_field = "F5EA8F78848770C9380A10B6B2C08236", hash_generated_field = "6F52E15DB27ACBF8AF1261D87ACDC04B")

    private static final char TYPE_INTEGER = 'I';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.020 -0400", hash_original_field = "0AAA1EAB141AB209D9DC474506C791E0", hash_generated_field = "7E3646905DF597FA341E03A9809EDF6C")

    private static final char TYPE_FLOAT = 'F';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.020 -0400", hash_original_field = "34CD4E4AEA6F2DABC807608E9C9FC0EB", hash_generated_field = "4C7FC2EC3A51877374490391181D6419")

    private static final char TYPE_LONG = 'J';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.020 -0400", hash_original_field = "4C504F7A87B64968003D68D095C746E2", hash_generated_field = "1C723C993774EE671598C52201355866")

    private static final char TYPE_DOUBLE = 'D';
    // orphaned legacy method
    @DSModeled(DSC.BAN)
    public Field() {
    	
    }
    
}

