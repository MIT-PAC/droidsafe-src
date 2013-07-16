package java.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.lang.annotation.Annotation;
import java.util.Comparator;
import org.apache.harmony.kernel.vm.StringUtils;
import org.apache.harmony.luni.lang.reflect.GenericSignatureParser;
import org.apache.harmony.luni.lang.reflect.Types;

public final class Field extends AccessibleObject implements Member {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.007 -0400", hash_original_field = "02CBE457FB1B22631E594CE79672D2F1", hash_generated_field = "EC96049C106D95C970CBF94E8CE21744")

    private Class<?> declaringClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.007 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "73346820208B59684010E2508B329B0F")

    private Class<?> type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.007 -0400", hash_original_field = "139EF988BED08F19F731C4392AB5A3AF", hash_generated_field = "DF8CDE4E2FC6AAB2D60A934C2A3F8E04")

    private Type genericType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.007 -0400", hash_original_field = "95A2153C74405BE971B467AB79B769A0", hash_generated_field = "89FDBAE6DE2AE55271071C78F774F101")

    private volatile boolean genericTypesAreInitialized = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.007 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.007 -0400", hash_original_field = "5E97994ED38A2B2F984F3B2B75012BF8", hash_generated_field = "6B06F56F1EB868ADA8CFFD63973A7E09")

    private int slot;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.007 -0400", hash_original_method = "18020B40E6468EB970BF7E1035466368", hash_generated_method = "056CC8AA5B0A121050D652E4EFA901DD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.008 -0400", hash_original_method = "5600995DFD2A0F6D5A6AA1A0A4EAB766", hash_generated_method = "2E9BFB4D6DAB6C08310A7C3C788C3ADD")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.008 -0400", hash_original_method = "5029B4C059F978BE158986B034FE3005", hash_generated_method = "7599278F3A909698F9008CA14287B9C3")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.008 -0400", hash_original_method = "1CDF5107AC443AA5F8C2E1DA9DF559A0", hash_generated_method = "26B88D48A365618B7EFBE1B108F56745")
    @Override
     String getSignatureAttribute() {
        Object[] annotation = getSignatureAnnotation(declaringClass, slot);
    if(annotation == null)        
        {
String var540C13E9E156B687226421B24F2DF178_798796913 =             null;
            var540C13E9E156B687226421B24F2DF178_798796913.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_798796913;
        } //End block
String var2F8E51633C4B934C6A6871930033C26B_1631289780 =         StringUtils.combineStrings(annotation);
        var2F8E51633C4B934C6A6871930033C26B_1631289780.addTaint(taint);
        return var2F8E51633C4B934C6A6871930033C26B_1631289780;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.009 -0400", hash_original_method = "FC3424D2079ACBF27BEC7269ECB48C94", hash_generated_method = "AABDD5E3ED2B2B56EA2598985ECDC454")
    public boolean isSynthetic() {
        int flags = getFieldModifiers(declaringClass, slot);
        boolean varFADE1C997A9FC78A7EDD7EA957F18741_488305355 = ((flags & Modifier.SYNTHETIC) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_157480526 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_157480526;
        // ---------- Original Method ----------
        //int flags = getFieldModifiers(declaringClass, slot);
        //return (flags & Modifier.SYNTHETIC) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.009 -0400", hash_original_method = "E96960960A41CE3DD754F7ED4B73683A", hash_generated_method = "5994E411746167F611AB23A3A5578B4F")
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
String var2460B846747F8B22185AD8BE722266A5_2091115217 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_2091115217.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_2091115217;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.010 -0400", hash_original_method = "2827C86400F787FBBD0EA58BB5706D02", hash_generated_method = "F02B7B5DFE2BC458F08B8AFD55B8CB68")
    public boolean isEnumConstant() {
        int flags = getFieldModifiers(declaringClass, slot);
        boolean var9FA5853F59B901E598FD548D3E283FC3_1340309880 = ((flags & Modifier.ENUM) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1941755114 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1941755114;
        // ---------- Original Method ----------
        //int flags = getFieldModifiers(declaringClass, slot);
        //return (flags & Modifier.ENUM) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.010 -0400", hash_original_method = "963F10B2A4697E7A9ECC1BB94066D74F", hash_generated_method = "6727DA5211BAC7A0F9B884080E9CA2A0")
    public Type getGenericType() {
        initGenericType();
Type var3CE4A4E61FC97920A085126FE74A2E59_1683467774 =         Types.getType(genericType);
        var3CE4A4E61FC97920A085126FE74A2E59_1683467774.addTaint(taint);
        return var3CE4A4E61FC97920A085126FE74A2E59_1683467774;
        // ---------- Original Method ----------
        //initGenericType();
        //return Types.getType(genericType);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.010 -0400", hash_original_method = "4122EC91CDDE6FFD9DA08F5ADAF8DB5D", hash_generated_method = "8F323C1E88974B4F856A628E785D0CA3")
    @Override
    public Annotation[] getDeclaredAnnotations() {
Annotation[] varD68AC863F3425367D397905DE25428DB_176931204 =         getDeclaredAnnotations(declaringClass, slot);
        varD68AC863F3425367D397905DE25428DB_176931204.addTaint(taint);
        return varD68AC863F3425367D397905DE25428DB_176931204;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.010 -0400", hash_original_method = "C04F97610183E33B13FB9B4273375B6D", hash_generated_method = "D92EC240660BEE1945E1008CE4EC5D78")
    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        addTaint(annotationType.getTaint());
    if(annotationType == null)        
        {
            NullPointerException varD3565833EFC12BC5822ABFE94D257EDE_1625743228 = new NullPointerException("annotationType == null");
            varD3565833EFC12BC5822ABFE94D257EDE_1625743228.addTaint(taint);
            throw varD3565833EFC12BC5822ABFE94D257EDE_1625743228;
        } //End block
A varD37D33C5EE02B81A7F8EF45A88B88039_1817856320 =         getAnnotation(declaringClass, slot, annotationType);
        varD37D33C5EE02B81A7F8EF45A88B88039_1817856320.addTaint(taint);
        return varD37D33C5EE02B81A7F8EF45A88B88039_1817856320;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.011 -0400", hash_original_method = "D8B142EB73E138FF5927E6AE1DAD56D2", hash_generated_method = "532EEF45A6A619C93B274B958CD22D7E")
    @Override
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        addTaint(annotationType.getTaint());
    if(annotationType == null)        
        {
            NullPointerException varD3565833EFC12BC5822ABFE94D257EDE_437021850 = new NullPointerException("annotationType == null");
            varD3565833EFC12BC5822ABFE94D257EDE_437021850.addTaint(taint);
            throw varD3565833EFC12BC5822ABFE94D257EDE_437021850;
        } //End block
        boolean var000A6E1BC96B3549B82B47E3D3F09F9E_1890952300 = (isAnnotationPresent(declaringClass, slot, annotationType));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_227241673 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_227241673;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.011 -0400", hash_original_method = "955F27DFEC9F7B5FBB7D8BD5BE41A050", hash_generated_method = "98294407DE36E9445CA266865E0449B4")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        boolean varE519BF50CC7591FF34EF5E2F19AB7CAD_524900703 = (object instanceof Field && toString().equals(object.toString()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_123229793 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_123229793;
        // ---------- Original Method ----------
        //return object instanceof Field && toString().equals(object.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.012 -0400", hash_original_method = "7AE3BC00249CC99885BB0445C93FB18A", hash_generated_method = "105E09828A781127A1C08AA5F69B6E8C")
    public Object get(Object object) throws IllegalAccessException, IllegalArgumentException {
        addTaint(object.getTaint());
Object var7995FC01A88811E5E97CF2E73643495D_1762663083 =         getField(object, declaringClass, type, slot, flag);
        var7995FC01A88811E5E97CF2E73643495D_1762663083.addTaint(taint);
        return var7995FC01A88811E5E97CF2E73643495D_1762663083;
        // ---------- Original Method ----------
        //return getField(object, declaringClass, type, slot, flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.012 -0400", hash_original_method = "27492232D5FCC61236B83BF948F6F104", hash_generated_method = "D06D1118E96CE2C5AF0D66E743089EDD")
    public boolean getBoolean(Object object) throws IllegalAccessException,
            IllegalArgumentException {
        addTaint(object.getTaint());
        boolean varA34B9D25372271D3D678C969755AA0F6_1625761683 = (getZField(object, declaringClass, type, slot, flag, TYPE_BOOLEAN));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_658652909 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_658652909;
        // ---------- Original Method ----------
        //return getZField(object, declaringClass, type, slot, flag, TYPE_BOOLEAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.012 -0400", hash_original_method = "638C7C4918F4FDF5130555C74F583890", hash_generated_method = "8E046601E61079E2680B3498FA7301D4")
    public byte getByte(Object object) throws IllegalAccessException, IllegalArgumentException {
        addTaint(object.getTaint());
        byte varF56DDD897B433F06B3CD7D819B779FA0_1909283705 = (getBField(object, declaringClass, type, slot, flag, TYPE_BYTE));
                byte var40EA57D3EE3C07BF1C102B466E1C3091_904487106 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_904487106;
        // ---------- Original Method ----------
        //return getBField(object, declaringClass, type, slot, flag, TYPE_BYTE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.012 -0400", hash_original_method = "6648A25494EBFE26376F66DF9331BADB", hash_generated_method = "066BA876FF3D8C6FAA431CD1EAD6178D")
    public char getChar(Object object) throws IllegalAccessException, IllegalArgumentException {
        addTaint(object.getTaint());
        char var7D1877BFABCFCBDBFCBBD77F78E5CB81_1800542816 = (getCField(object, declaringClass, type, slot, flag, TYPE_CHAR));
                char varA87DEB01C5F539E6BDA34829C8EF2368_1598139629 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1598139629;
        // ---------- Original Method ----------
        //return getCField(object, declaringClass, type, slot, flag, TYPE_CHAR);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.013 -0400", hash_original_method = "747BEFE9985C4AF4EE3D5630B62185EA", hash_generated_method = "75D320126676CA42CC3C057EA3A417C1")
    public Class<?> getDeclaringClass() {
Class<?> var55840ACAE88F5536515BB8E6ADD923C6_583261595 =         declaringClass;
        var55840ACAE88F5536515BB8E6ADD923C6_583261595.addTaint(taint);
        return var55840ACAE88F5536515BB8E6ADD923C6_583261595;
        // ---------- Original Method ----------
        //return declaringClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.013 -0400", hash_original_method = "B22A8667913C0820CACD3D8F78E3B803", hash_generated_method = "8518569992D17F5C392F0F92824C8C30")
    public double getDouble(Object object) throws IllegalAccessException, IllegalArgumentException {
        addTaint(object.getTaint());
        double var2DCB9D3247409ACAE9B6D0BC10E539BE_701209419 = (getDField(object, declaringClass, type, slot, flag, TYPE_DOUBLE));
                double varE8CD7DA078A86726031AD64F35F5A6C0_567575389 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_567575389;
        // ---------- Original Method ----------
        //return getDField(object, declaringClass, type, slot, flag, TYPE_DOUBLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.013 -0400", hash_original_method = "BFF553DA1989441891013747E355F341", hash_generated_method = "B1C05894916F5D83279789B326377438")
    public float getFloat(Object object) throws IllegalAccessException, IllegalArgumentException {
        addTaint(object.getTaint());
        float var5B76F495DEAEC526BE2C15B6755CCDFF_271275649 = (getFField(object, declaringClass, type, slot, flag, TYPE_FLOAT));
                float var546ADE640B6EDFBC8A086EF31347E768_1434687461 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1434687461;
        // ---------- Original Method ----------
        //return getFField(object, declaringClass, type, slot, flag, TYPE_FLOAT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.013 -0400", hash_original_method = "5CB83BC53ADA020FA0FD37C15AAD9E62", hash_generated_method = "D507A545D76D0D9A5B8FBA2D48CF4AA6")
    public int getInt(Object object) throws IllegalAccessException, IllegalArgumentException {
        addTaint(object.getTaint());
        int var50B3C28304687A6D79FE383AFD7E84A3_234161266 = (getIField(object, declaringClass, type, slot, flag, TYPE_INTEGER));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1200333347 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1200333347;
        // ---------- Original Method ----------
        //return getIField(object, declaringClass, type, slot, flag, TYPE_INTEGER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.014 -0400", hash_original_method = "005A2557A921AA55BF8BDBCBDC639BE4", hash_generated_method = "DB7C5139EB4D93AF1C2352E52F831747")
    public long getLong(Object object) throws IllegalAccessException, IllegalArgumentException {
        addTaint(object.getTaint());
        long var8CCAE232F40D54FA1F4064F5546025DF_2036307903 = (getJField(object, declaringClass, type, slot, flag, TYPE_LONG));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_357085621 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_357085621;
        // ---------- Original Method ----------
        //return getJField(object, declaringClass, type, slot, flag, TYPE_LONG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.014 -0400", hash_original_method = "5A676A538E8952F6729F0D8423178A33", hash_generated_method = "9EF910C8F1C33D5CBC4DFAB016544931")
    public int getModifiers() {
        int var5A21DFF9A4E45BEE9AF69069B6808DEF_1592304001 = (getFieldModifiers(declaringClass, slot));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_141517917 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_141517917;
        // ---------- Original Method ----------
        //return getFieldModifiers(declaringClass, slot);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.014 -0400", hash_original_method = "9D513D500FBFD57DB21A924D9A85826A", hash_generated_method = "2D4CCB3D5B850157727B5FBABC0A1406")
    private int getFieldModifiers(Class<?> declaringClass, int slot) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1384427873 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1384427873;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.014 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "6D95AD644A60D765042E3B90076F8052")
    public String getName() {
String varB017984728AC60AD1F0BF8734F33F15C_117178215 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_117178215.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_117178215;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.015 -0400", hash_original_method = "0DDA5605A2464ED398902817D939E3F2", hash_generated_method = "7A0A0E4566D06F8215BD6EC5E96E565D")
    public short getShort(Object object) throws IllegalAccessException, IllegalArgumentException {
        addTaint(object.getTaint());
        short varC70CFA5FC6A1C471897DA0AAF3879A0D_730077409 = (getSField(object, declaringClass, type, slot, flag, TYPE_SHORT));
                short var4F09DAA9D95BCB166A302407A0E0BABE_785020350 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_785020350;
        // ---------- Original Method ----------
        //return getSField(object, declaringClass, type, slot, flag, TYPE_SHORT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.015 -0400", hash_original_method = "994767CE6492BCD5B50ECB089389E539", hash_generated_method = "AC95E681B97DBA1858EB243BD9A26F3F")
    @SuppressWarnings("unused")
    private String getSignature() {
String var669825FFD7E3ACD0942E1A8D9403D236_1624017032 =         getSignature(type);
        var669825FFD7E3ACD0942E1A8D9403D236_1624017032.addTaint(taint);
        return var669825FFD7E3ACD0942E1A8D9403D236_1624017032;
        // ---------- Original Method ----------
        //return getSignature(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.015 -0400", hash_original_method = "21C93A7CC51FD6114C8D944747F943F4", hash_generated_method = "38545DFFE05EF9DC53AEEBD27753A6AA")
    public Class<?> getType() {
Class<?> varC5B9F25B4EEAD3E8E2C33F9429204397_236706599 =         type;
        varC5B9F25B4EEAD3E8E2C33F9429204397_236706599.addTaint(taint);
        return varC5B9F25B4EEAD3E8E2C33F9429204397_236706599;
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.015 -0400", hash_original_method = "7C0B16AD34D2790FBD73D96D003DD91D", hash_generated_method = "157C01294D326F74F351C29DA4BA4CCC")
    @Override
    public int hashCode() {
        int var3A37DE6E508D6672DE4E48080720192A_432365909 = (name.hashCode() ^ getDeclaringClass().getName().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1124190803 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1124190803;
        // ---------- Original Method ----------
        //return name.hashCode() ^ getDeclaringClass().getName().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.016 -0400", hash_original_method = "6D24AA0F6B01F01D922DBBA93FD91F81", hash_generated_method = "62C72115E0B338F718DA287637B5771C")
    public void set(Object object, Object value) throws IllegalAccessException,
            IllegalArgumentException {
        addTaint(value.getTaint());
        addTaint(object.getTaint());
        setField(object, declaringClass, type, slot, flag, value);
        // ---------- Original Method ----------
        //setField(object, declaringClass, type, slot, flag, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.016 -0400", hash_original_method = "25FFB4639E444F2A9FD12AF0E909B7A5", hash_generated_method = "694F415475AE6488899623BA671E185D")
    public void setBoolean(Object object, boolean value) throws IllegalAccessException,
            IllegalArgumentException {
        addTaint(value);
        addTaint(object.getTaint());
        setZField(object, declaringClass, type, slot, flag, TYPE_BOOLEAN, value);
        // ---------- Original Method ----------
        //setZField(object, declaringClass, type, slot, flag, TYPE_BOOLEAN, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.016 -0400", hash_original_method = "AD912B9A4F5D11756FF2F9AE3FC4D6E6", hash_generated_method = "6C2DFB2557346BA99AD390D5490279E8")
    public void setByte(Object object, byte value) throws IllegalAccessException,
            IllegalArgumentException {
        addTaint(value);
        addTaint(object.getTaint());
        setBField(object, declaringClass, type, slot, flag, TYPE_BYTE, value);
        // ---------- Original Method ----------
        //setBField(object, declaringClass, type, slot, flag, TYPE_BYTE, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.016 -0400", hash_original_method = "97D79EA86FEBB11A4E8B5CD3EFF3DEF5", hash_generated_method = "220C753A236F2D5E328E01C8A007433F")
    public void setChar(Object object, char value) throws IllegalAccessException,
            IllegalArgumentException {
        addTaint(value);
        addTaint(object.getTaint());
        setCField(object, declaringClass, type, slot, flag, TYPE_CHAR, value);
        // ---------- Original Method ----------
        //setCField(object, declaringClass, type, slot, flag, TYPE_CHAR, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.017 -0400", hash_original_method = "5E12E36ACBA66ADB7DF4FF63170F60C3", hash_generated_method = "91A53C2E4CC1BA6AC18E1590358CEC5A")
    public void setDouble(Object object, double value) throws IllegalAccessException,
            IllegalArgumentException {
        addTaint(value);
        addTaint(object.getTaint());
        setDField(object, declaringClass, type, slot, flag, TYPE_DOUBLE, value);
        // ---------- Original Method ----------
        //setDField(object, declaringClass, type, slot, flag, TYPE_DOUBLE, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.017 -0400", hash_original_method = "4860783C5B567E2FC646E7FC5AE81E3C", hash_generated_method = "13D35F9A5856724054ACB3945D3A874F")
    public void setFloat(Object object, float value) throws IllegalAccessException,
            IllegalArgumentException {
        addTaint(value);
        addTaint(object.getTaint());
        setFField(object, declaringClass, type, slot, flag, TYPE_FLOAT, value);
        // ---------- Original Method ----------
        //setFField(object, declaringClass, type, slot, flag, TYPE_FLOAT, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.017 -0400", hash_original_method = "DA13B1330D08A636280F51E51FF711B2", hash_generated_method = "E01C13D06D78006386ED59C5C3B8EADD")
    public void setInt(Object object, int value) throws IllegalAccessException,
            IllegalArgumentException {
        addTaint(value);
        addTaint(object.getTaint());
        setIField(object, declaringClass, type, slot, flag, TYPE_INTEGER, value);
        // ---------- Original Method ----------
        //setIField(object, declaringClass, type, slot, flag, TYPE_INTEGER, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.018 -0400", hash_original_method = "F703AA23CA1EF460C68B245887B2C6B7", hash_generated_method = "10464828688C5DE538720D33A95AD3B2")
    public void setLong(Object object, long value) throws IllegalAccessException,
            IllegalArgumentException {
        addTaint(value);
        addTaint(object.getTaint());
        setJField(object, declaringClass, type, slot, flag, TYPE_LONG, value);
        // ---------- Original Method ----------
        //setJField(object, declaringClass, type, slot, flag, TYPE_LONG, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.018 -0400", hash_original_method = "DEE843BD220F8992FC80A23844FC7C06", hash_generated_method = "AAD2487A62A8B9DAEB8ADEF82CB3C0A7")
    public void setShort(Object object, short value) throws IllegalAccessException,
            IllegalArgumentException {
        addTaint(value);
        addTaint(object.getTaint());
        setSField(object, declaringClass, type, slot, flag, TYPE_SHORT, value);
        // ---------- Original Method ----------
        //setSField(object, declaringClass, type, slot, flag, TYPE_SHORT, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.018 -0400", hash_original_method = "2B14553F8A926216EE23C791DBC737FD", hash_generated_method = "FE23DD857BABB954A939B365112F45C3")
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
String varE65B3A02759122992CB82C0E651AD408_698562485 =         result.toString();
        varE65B3A02759122992CB82C0E651AD408_698562485.addTaint(taint);
        return varE65B3A02759122992CB82C0E651AD408_698562485;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.019 -0400", hash_original_method = "E4CBB65FF20F2B42AAAA5852C9FC84C9", hash_generated_method = "1A06E6EE6A85DF7A1A8E4C74248B7B2B")
    private double getDField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        double varE8CD7DA078A86726031AD64F35F5A6C0_360427045 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_360427045;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.019 -0400", hash_original_method = "9B86AA05444EF83A8159E0D0E3B46582", hash_generated_method = "A96092923272B9F9D251508CB48E99B8")
    private int getIField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1657170305 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1657170305;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.019 -0400", hash_original_method = "1F116F930DBB16C5DB58ABA31954B7AA", hash_generated_method = "C586DBFF7DAD6387B2746D84B5162210")
    private long getJField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1152506248 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1152506248;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.019 -0400", hash_original_method = "50BE3A9E4BA3ACB6450AF3382B17C97D", hash_generated_method = "7B9C5C626085667F1B590360FF223AC4")
    private boolean getZField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_388117575 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_388117575;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.020 -0400", hash_original_method = "94E059571B5D65D86B6231E7D36BF7FA", hash_generated_method = "7EA505566A1D1450CF0460C2A2EBD404")
    private float getFField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        float var546ADE640B6EDFBC8A086EF31347E768_1342580420 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1342580420;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.020 -0400", hash_original_method = "9A55E198BD753BB34F159FBC2807D96E", hash_generated_method = "567F3DBB966E11DC69DAE552BA6CB5C9")
    private char getCField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        char varA87DEB01C5F539E6BDA34829C8EF2368_1454047596 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1454047596;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.020 -0400", hash_original_method = "9FE268B454DA8902066BFF2BFC132935", hash_generated_method = "5BE51FE21007E495DE94352B47A2AD61")
    private short getSField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        short var4F09DAA9D95BCB166A302407A0E0BABE_1097046534 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1097046534;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.021 -0400", hash_original_method = "B020FC56F3182544B11E7C259C9C5B21", hash_generated_method = "6F20E0A340F1DD81BE3D17D1F519D252")
    private byte getBField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        byte var40EA57D3EE3C07BF1C102B466E1C3091_1534898483 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1534898483;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.021 -0400", hash_original_method = "D9AA799947323C8F653B1139DF380855", hash_generated_method = "C408ADE9BAD371E4961776A5655ECA1D")
    private void setField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, Object value) throws IllegalAccessException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.021 -0400", hash_original_method = "3CCE00B68111CAA3AA20979F21B904D8", hash_generated_method = "3179919531A6B77C3D15EE892C5A42ED")
    private void setDField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, double v) throws IllegalAccessException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.021 -0400", hash_original_method = "32CBAB454E52D8BFC71D6AB87E7BF1FE", hash_generated_method = "0AD27F9AC1D9709615BF81BE0EC00C6F")
    private void setIField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, int i) throws IllegalAccessException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.022 -0400", hash_original_method = "7CE46D8AB646DF2CA9A88ACDCE998029", hash_generated_method = "6C698AE9F78C7DE632773059C8D4BC97")
    private void setJField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, long j) throws IllegalAccessException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.022 -0400", hash_original_method = "E80188BF0543922F0F2BDA0A103D17F5", hash_generated_method = "72E8231E78B1D9BCE0F14C1F2F070F7A")
    private void setZField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, boolean z) throws IllegalAccessException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.022 -0400", hash_original_method = "570BC71D32CB4741615EF7701079ED2D", hash_generated_method = "8275ADFFBEC551D7D79BD7EB97FC5146")
    private void setFField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, float f) throws IllegalAccessException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.022 -0400", hash_original_method = "ACD0A6EABB934CC5EEECCAB72AA01730", hash_generated_method = "13FE5F042DD294402F9D22C992CA140C")
    private void setCField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, char c) throws IllegalAccessException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.023 -0400", hash_original_method = "2A0F6C37A6B68BD24BAC15A31879F06F", hash_generated_method = "4F3A9A2CC7778961778A3052697CE1D8")
    private void setSField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, short s) throws IllegalAccessException {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.023 -0400", hash_original_method = "4D8B3646C0E699793861ED8487ADC739", hash_generated_method = "D5189C3BB7F03AFCF5839741EE6876A2")
    private void setBField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, byte b) throws IllegalAccessException {
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.023 -0400", hash_original_field = "53D2DF7F6A0025522B6A62D7BCCD362B", hash_generated_field = "FE1CC35DA4EB56C9880DCB488708D9CB")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.023 -0400", hash_original_field = "6F4F342B95B25A4C75EC3E906175F9FD", hash_generated_field = "0B71E07F68242E0883FB03EAE37B4026")

    private static final char TYPE_BOOLEAN = 'Z';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.023 -0400", hash_original_field = "CB54D6511967B2F9F10D18E7AE656028", hash_generated_field = "A2F4D86DAE2B010C8D5C08013F0683CA")

    private static final char TYPE_BYTE = 'B';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.024 -0400", hash_original_field = "34382A0DD8E04475FFB7D187E09259D6", hash_generated_field = "AAD9FB3C86B29282B83CDD80DE09CFA0")

    private static final char TYPE_CHAR = 'C';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.024 -0400", hash_original_field = "F7285E854CB9D5C401C99397EC300E2B", hash_generated_field = "EFF96E3ED8672BC1006A65B4ACD711D8")

    private static final char TYPE_SHORT = 'S';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.024 -0400", hash_original_field = "F5EA8F78848770C9380A10B6B2C08236", hash_generated_field = "6F52E15DB27ACBF8AF1261D87ACDC04B")

    private static final char TYPE_INTEGER = 'I';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.024 -0400", hash_original_field = "0AAA1EAB141AB209D9DC474506C791E0", hash_generated_field = "7E3646905DF597FA341E03A9809EDF6C")

    private static final char TYPE_FLOAT = 'F';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.024 -0400", hash_original_field = "34CD4E4AEA6F2DABC807608E9C9FC0EB", hash_generated_field = "4C7FC2EC3A51877374490391181D6419")

    private static final char TYPE_LONG = 'J';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:48.024 -0400", hash_original_field = "4C504F7A87B64968003D68D095C746E2", hash_generated_field = "1C723C993774EE671598C52201355866")

    private static final char TYPE_DOUBLE = 'D';
    // orphaned legacy method
    public Field() {
    	
    }
    
}

