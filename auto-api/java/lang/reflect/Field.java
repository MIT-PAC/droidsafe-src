package java.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.lang.annotation.Annotation;
import java.util.Comparator;
import org.apache.harmony.kernel.vm.StringUtils;
import org.apache.harmony.luni.lang.reflect.GenericSignatureParser;
import org.apache.harmony.luni.lang.reflect.Types;

public final class Field extends AccessibleObject implements Member {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.117 -0400", hash_original_field = "02CBE457FB1B22631E594CE79672D2F1", hash_generated_field = "EC96049C106D95C970CBF94E8CE21744")

    private Class<?> declaringClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.117 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "73346820208B59684010E2508B329B0F")

    private Class<?> type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.117 -0400", hash_original_field = "139EF988BED08F19F731C4392AB5A3AF", hash_generated_field = "DF8CDE4E2FC6AAB2D60A934C2A3F8E04")

    private Type genericType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.117 -0400", hash_original_field = "95A2153C74405BE971B467AB79B769A0", hash_generated_field = "89FDBAE6DE2AE55271071C78F774F101")

    private volatile boolean genericTypesAreInitialized = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.117 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.117 -0400", hash_original_field = "5E97994ED38A2B2F984F3B2B75012BF8", hash_generated_field = "6B06F56F1EB868ADA8CFFD63973A7E09")

    private int slot;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.118 -0400", hash_original_method = "18020B40E6468EB970BF7E1035466368", hash_generated_method = "6011D4149198435BF913A3023A4F29C3")
      Field(Field orig) {
        this(orig.declaringClass, orig.type, orig.name, orig.slot);
        {
            this.flag = true;
        } //End block
        addTaint(orig.getTaint());
        // ---------- Original Method ----------
        //if (orig.flag) {
            //this.flag = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.118 -0400", hash_original_method = "5600995DFD2A0F6D5A6AA1A0A4EAB766", hash_generated_method = "2E9BFB4D6DAB6C08310A7C3C788C3ADD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.119 -0400", hash_original_method = "5029B4C059F978BE158986B034FE3005", hash_generated_method = "3E63307BA266E148A747BE2B78618331")
    private synchronized void initGenericType() {
        {
            String signatureAttribute;
            signatureAttribute = getSignatureAttribute();
            GenericSignatureParser parser;
            parser = new GenericSignatureParser(
                    declaringClass.getClassLoader());
            parser.parseForField(this.declaringClass, signatureAttribute);
            genericType = parser.fieldType;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.137 -0400", hash_original_method = "1CDF5107AC443AA5F8C2E1DA9DF559A0", hash_generated_method = "A25805B699471E77FFBD44986B715B2E")
    @Override
     String getSignatureAttribute() {
        String varB4EAC82CA7396A68D541C85D26508E83_423499647 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1936217622 = null; //Variable for return #2
        Object[] annotation;
        annotation = getSignatureAnnotation(declaringClass, slot);
        {
            varB4EAC82CA7396A68D541C85D26508E83_423499647 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1936217622 = StringUtils.combineStrings(annotation);
        String varA7E53CE21691AB073D9660D615818899_1671415023; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1671415023 = varB4EAC82CA7396A68D541C85D26508E83_423499647;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1671415023 = varB4EAC82CA7396A68D541C85D26508E83_1936217622;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1671415023.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1671415023;
        // ---------- Original Method ----------
        //Object[] annotation = getSignatureAnnotation(declaringClass, slot);
        //if (annotation == null) {
            //return null;
        //}
        //return StringUtils.combineStrings(annotation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.137 -0400", hash_original_method = "5161131687230E0D7EE89383FDDF9117", hash_generated_method = "F1BBACEA836E9C65FE0E5D9A22FF7006")
    private Object[] getSignatureAnnotation(Class declaringClass, int slot) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.137 -0400", hash_original_method = "FC3424D2079ACBF27BEC7269ECB48C94", hash_generated_method = "E770C51BFE01124BE6D809A73693A4E8")
    public boolean isSynthetic() {
        int flags;
        flags = getFieldModifiers(declaringClass, slot);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1059288852 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1059288852;
        // ---------- Original Method ----------
        //int flags = getFieldModifiers(declaringClass, slot);
        //return (flags & Modifier.SYNTHETIC) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.138 -0400", hash_original_method = "E96960960A41CE3DD754F7ED4B73683A", hash_generated_method = "06B036C9E75C76ACEB9E9D5AE30296E4")
    public String toGenericString() {
        String varB4EAC82CA7396A68D541C85D26508E83_881316370 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder(80);
        int modifier;
        modifier = getModifiers();
        {
            sb.append(Modifier.toString(modifier)).append(' ');
        } //End block
        appendGenericType(sb, getGenericType());
        sb.append(' ');
        sb.append(getDeclaringClass().getName()).append('.').append(getName());
        varB4EAC82CA7396A68D541C85D26508E83_881316370 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_881316370.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_881316370;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.138 -0400", hash_original_method = "2827C86400F787FBBD0EA58BB5706D02", hash_generated_method = "504E82A3B04B815C72D5C0ED1D66907A")
    public boolean isEnumConstant() {
        int flags;
        flags = getFieldModifiers(declaringClass, slot);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1310234721 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1310234721;
        // ---------- Original Method ----------
        //int flags = getFieldModifiers(declaringClass, slot);
        //return (flags & Modifier.ENUM) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.139 -0400", hash_original_method = "963F10B2A4697E7A9ECC1BB94066D74F", hash_generated_method = "1F560345482A0F9E1FDBCB66334A6A74")
    public Type getGenericType() {
        Type varB4EAC82CA7396A68D541C85D26508E83_1874197467 = null; //Variable for return #1
        initGenericType();
        varB4EAC82CA7396A68D541C85D26508E83_1874197467 = Types.getType(genericType);
        varB4EAC82CA7396A68D541C85D26508E83_1874197467.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1874197467;
        // ---------- Original Method ----------
        //initGenericType();
        //return Types.getType(genericType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.139 -0400", hash_original_method = "4122EC91CDDE6FFD9DA08F5ADAF8DB5D", hash_generated_method = "BB90971E43EEE60F091498027405E9BB")
    @Override
    public Annotation[] getDeclaredAnnotations() {
        Annotation[] varB4EAC82CA7396A68D541C85D26508E83_1455393317 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1455393317 = getDeclaredAnnotations(declaringClass, slot);
        varB4EAC82CA7396A68D541C85D26508E83_1455393317.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1455393317;
        // ---------- Original Method ----------
        //return getDeclaredAnnotations(declaringClass, slot);
    }

    
        private static Annotation[] getDeclaredAnnotations(Class declaringClass, int slot) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.149 -0400", hash_original_method = "C04F97610183E33B13FB9B4273375B6D", hash_generated_method = "885E4CEC4F60B862174828D6AE3D69D1")
    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        A varB4EAC82CA7396A68D541C85D26508E83_821483311 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("annotationType == null");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_821483311 = getAnnotation(declaringClass, slot, annotationType);
        addTaint(annotationType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_821483311.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_821483311;
        // ---------- Original Method ----------
        //if (annotationType == null) {
            //throw new NullPointerException("annotationType == null");
        //}
        //return getAnnotation(declaringClass, slot, annotationType);
    }

    
        private static <A extends Annotation> A getAnnotation(
            Class<?> declaringClass, int slot, Class<A> annotationType) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.156 -0400", hash_original_method = "D8B142EB73E138FF5927E6AE1DAD56D2", hash_generated_method = "0F7E44787D2DD0F940F697119D09AE91")
    @Override
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("annotationType == null");
        } //End block
        boolean varB3780DB5BBCCEE48C62CDF997A07D42D_1570411642 = (isAnnotationPresent(declaringClass, slot, annotationType));
        addTaint(annotationType.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1210556756 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1210556756;
        // ---------- Original Method ----------
        //if (annotationType == null) {
            //throw new NullPointerException("annotationType == null");
        //}
        //return isAnnotationPresent(declaringClass, slot, annotationType);
    }

    
        private static boolean isAnnotationPresent(
            Class<?> declaringClass, int slot, Class<? extends Annotation> annotationType) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.157 -0400", hash_original_method = "955F27DFEC9F7B5FBB7D8BD5BE41A050", hash_generated_method = "F92C30F679337ADB35E2656CBB5DB63E")
    @Override
    public boolean equals(Object object) {
        boolean varDCACFE8832290BDBC09105E7C6859538_949539568 = (object instanceof Field && toString().equals(object.toString()));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_311403293 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_311403293;
        // ---------- Original Method ----------
        //return object instanceof Field && toString().equals(object.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.157 -0400", hash_original_method = "7AE3BC00249CC99885BB0445C93FB18A", hash_generated_method = "190BD5DFE87FC789BBD6A0D90D6D9458")
    public Object get(Object object) throws IllegalAccessException, IllegalArgumentException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1590937563 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1590937563 = getField(object, declaringClass, type, slot, flag);
        addTaint(object.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1590937563.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1590937563;
        // ---------- Original Method ----------
        //return getField(object, declaringClass, type, slot, flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.157 -0400", hash_original_method = "27492232D5FCC61236B83BF948F6F104", hash_generated_method = "33AA6527BDCBBA24E961F6A8DC1DA6DF")
    public boolean getBoolean(Object object) throws IllegalAccessException,
            IllegalArgumentException {
        boolean var9DA284626B9970789966B6A4F6E5FB32_55383938 = (getZField(object, declaringClass, type, slot, flag, TYPE_BOOLEAN));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_664709350 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_664709350;
        // ---------- Original Method ----------
        //return getZField(object, declaringClass, type, slot, flag, TYPE_BOOLEAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.168 -0400", hash_original_method = "638C7C4918F4FDF5130555C74F583890", hash_generated_method = "6D69A2E99BCFF28D74DDEFCFDA6A01C7")
    public byte getByte(Object object) throws IllegalAccessException, IllegalArgumentException {
        byte varA215D52F81AAE6605102E4D98BCBBCB4_963894481 = (getBField(object, declaringClass, type, slot, flag, TYPE_BYTE));
        addTaint(object.getTaint());
        byte var40EA57D3EE3C07BF1C102B466E1C3091_1238726490 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1238726490;
        // ---------- Original Method ----------
        //return getBField(object, declaringClass, type, slot, flag, TYPE_BYTE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.170 -0400", hash_original_method = "6648A25494EBFE26376F66DF9331BADB", hash_generated_method = "B3426CFB70F812CA4A3E63EB177C4965")
    public char getChar(Object object) throws IllegalAccessException, IllegalArgumentException {
        char var955F981595FD17AB1396A3EADA1E0C15_1088851011 = (getCField(object, declaringClass, type, slot, flag, TYPE_CHAR));
        addTaint(object.getTaint());
        char varA87DEB01C5F539E6BDA34829C8EF2368_353919351 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_353919351;
        // ---------- Original Method ----------
        //return getCField(object, declaringClass, type, slot, flag, TYPE_CHAR);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.170 -0400", hash_original_method = "747BEFE9985C4AF4EE3D5630B62185EA", hash_generated_method = "55284650AB0215DC5C1139129F150A0D")
    public Class<?> getDeclaringClass() {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_1335326361 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1335326361 = declaringClass;
        varB4EAC82CA7396A68D541C85D26508E83_1335326361.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1335326361;
        // ---------- Original Method ----------
        //return declaringClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.171 -0400", hash_original_method = "B22A8667913C0820CACD3D8F78E3B803", hash_generated_method = "ADABA9BFF04531055170FB4747D02A27")
    public double getDouble(Object object) throws IllegalAccessException, IllegalArgumentException {
        double varAE2581BDD0AD43AE217DFFB84BBB208E_1464753680 = (getDField(object, declaringClass, type, slot, flag, TYPE_DOUBLE));
        addTaint(object.getTaint());
        double varE8CD7DA078A86726031AD64F35F5A6C0_1465204010 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1465204010;
        // ---------- Original Method ----------
        //return getDField(object, declaringClass, type, slot, flag, TYPE_DOUBLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.186 -0400", hash_original_method = "BFF553DA1989441891013747E355F341", hash_generated_method = "42639483710ED83037A34B7464D706D4")
    public float getFloat(Object object) throws IllegalAccessException, IllegalArgumentException {
        float var1A5038016F232945D7BD627195B26E7D_1680760312 = (getFField(object, declaringClass, type, slot, flag, TYPE_FLOAT));
        addTaint(object.getTaint());
        float var546ADE640B6EDFBC8A086EF31347E768_1284004486 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1284004486;
        // ---------- Original Method ----------
        //return getFField(object, declaringClass, type, slot, flag, TYPE_FLOAT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.187 -0400", hash_original_method = "5CB83BC53ADA020FA0FD37C15AAD9E62", hash_generated_method = "74EAA29127238F5CB06A1E1304491F35")
    public int getInt(Object object) throws IllegalAccessException, IllegalArgumentException {
        int var5F795D86675AD53A1B7ACF3414BE7AF6_1188491772 = (getIField(object, declaringClass, type, slot, flag, TYPE_INTEGER));
        addTaint(object.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_524313754 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_524313754;
        // ---------- Original Method ----------
        //return getIField(object, declaringClass, type, slot, flag, TYPE_INTEGER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.205 -0400", hash_original_method = "005A2557A921AA55BF8BDBCBDC639BE4", hash_generated_method = "59DB1105E1E343D690C33D646B7624E8")
    public long getLong(Object object) throws IllegalAccessException, IllegalArgumentException {
        long var250CDA2AC47DDC6DF64D4C553373D869_2145978900 = (getJField(object, declaringClass, type, slot, flag, TYPE_LONG));
        addTaint(object.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1044685 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1044685;
        // ---------- Original Method ----------
        //return getJField(object, declaringClass, type, slot, flag, TYPE_LONG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.205 -0400", hash_original_method = "5A676A538E8952F6729F0D8423178A33", hash_generated_method = "3C4061686EDB65C1C228305E4F91A216")
    public int getModifiers() {
        int var49B847D353C589D7A33E0861E95832A8_506876576 = (getFieldModifiers(declaringClass, slot));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1371443420 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1371443420;
        // ---------- Original Method ----------
        //return getFieldModifiers(declaringClass, slot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.206 -0400", hash_original_method = "9D513D500FBFD57DB21A924D9A85826A", hash_generated_method = "F165BF044930895551BEEBADDF553A4A")
    private int getFieldModifiers(Class<?> declaringClass, int slot) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_287085778 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_287085778;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.206 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "A9F05B899391DAD8C60C108DB6AFC2B2")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_456809093 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_456809093 = name;
        varB4EAC82CA7396A68D541C85D26508E83_456809093.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_456809093;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.207 -0400", hash_original_method = "0DDA5605A2464ED398902817D939E3F2", hash_generated_method = "9A93E243EBF39B97A58BD695CB4A5E9F")
    public short getShort(Object object) throws IllegalAccessException, IllegalArgumentException {
        short var71629059FF106ED311F07E4A99F9E53D_1363560289 = (getSField(object, declaringClass, type, slot, flag, TYPE_SHORT));
        addTaint(object.getTaint());
        short var4F09DAA9D95BCB166A302407A0E0BABE_1938187643 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1938187643;
        // ---------- Original Method ----------
        //return getSField(object, declaringClass, type, slot, flag, TYPE_SHORT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.208 -0400", hash_original_method = "994767CE6492BCD5B50ECB089389E539", hash_generated_method = "88D2834214A6517298E8F9644430EAC9")
    @SuppressWarnings("unused")
    private String getSignature() {
        String varB4EAC82CA7396A68D541C85D26508E83_141654471 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_141654471 = getSignature(type);
        varB4EAC82CA7396A68D541C85D26508E83_141654471.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_141654471;
        // ---------- Original Method ----------
        //return getSignature(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.211 -0400", hash_original_method = "21C93A7CC51FD6114C8D944747F943F4", hash_generated_method = "43292D6808A010196F417027A9B6CEA9")
    public Class<?> getType() {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_301042888 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_301042888 = type;
        varB4EAC82CA7396A68D541C85D26508E83_301042888.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_301042888;
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.225 -0400", hash_original_method = "7C0B16AD34D2790FBD73D96D003DD91D", hash_generated_method = "6F267493525B0115E1BF111CBF8D4732")
    @Override
    public int hashCode() {
        int varFE991B9610FD8386F23C23BA9DCC53AC_1812094868 = (name.hashCode() ^ getDeclaringClass().getName().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_402456267 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_402456267;
        // ---------- Original Method ----------
        //return name.hashCode() ^ getDeclaringClass().getName().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.225 -0400", hash_original_method = "6D24AA0F6B01F01D922DBBA93FD91F81", hash_generated_method = "BE8D86CDF9D6D7515528CA02A2DF2402")
    public void set(Object object, Object value) throws IllegalAccessException,
            IllegalArgumentException {
        setField(object, declaringClass, type, slot, flag, value);
        addTaint(object.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //setField(object, declaringClass, type, slot, flag, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.225 -0400", hash_original_method = "25FFB4639E444F2A9FD12AF0E909B7A5", hash_generated_method = "F7C67AF7E674AED306123873A7EC9976")
    public void setBoolean(Object object, boolean value) throws IllegalAccessException,
            IllegalArgumentException {
        setZField(object, declaringClass, type, slot, flag, TYPE_BOOLEAN, value);
        addTaint(object.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //setZField(object, declaringClass, type, slot, flag, TYPE_BOOLEAN, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.226 -0400", hash_original_method = "AD912B9A4F5D11756FF2F9AE3FC4D6E6", hash_generated_method = "78C069FBF1B31A73A7EE47D898A2CC4E")
    public void setByte(Object object, byte value) throws IllegalAccessException,
            IllegalArgumentException {
        setBField(object, declaringClass, type, slot, flag, TYPE_BYTE, value);
        addTaint(object.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //setBField(object, declaringClass, type, slot, flag, TYPE_BYTE, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.226 -0400", hash_original_method = "97D79EA86FEBB11A4E8B5CD3EFF3DEF5", hash_generated_method = "232046BF1BDA63993FE262C113EB4221")
    public void setChar(Object object, char value) throws IllegalAccessException,
            IllegalArgumentException {
        setCField(object, declaringClass, type, slot, flag, TYPE_CHAR, value);
        addTaint(object.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //setCField(object, declaringClass, type, slot, flag, TYPE_CHAR, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.226 -0400", hash_original_method = "5E12E36ACBA66ADB7DF4FF63170F60C3", hash_generated_method = "A577B73AE70371742336A7B6B41D0248")
    public void setDouble(Object object, double value) throws IllegalAccessException,
            IllegalArgumentException {
        setDField(object, declaringClass, type, slot, flag, TYPE_DOUBLE, value);
        addTaint(object.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //setDField(object, declaringClass, type, slot, flag, TYPE_DOUBLE, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.232 -0400", hash_original_method = "4860783C5B567E2FC646E7FC5AE81E3C", hash_generated_method = "72DD4D48FE8B6BAD52414698FE9819AD")
    public void setFloat(Object object, float value) throws IllegalAccessException,
            IllegalArgumentException {
        setFField(object, declaringClass, type, slot, flag, TYPE_FLOAT, value);
        addTaint(object.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //setFField(object, declaringClass, type, slot, flag, TYPE_FLOAT, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.232 -0400", hash_original_method = "DA13B1330D08A636280F51E51FF711B2", hash_generated_method = "5B8EAC3DCB5F4D694C05F075179601B1")
    public void setInt(Object object, int value) throws IllegalAccessException,
            IllegalArgumentException {
        setIField(object, declaringClass, type, slot, flag, TYPE_INTEGER, value);
        addTaint(object.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //setIField(object, declaringClass, type, slot, flag, TYPE_INTEGER, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.232 -0400", hash_original_method = "F703AA23CA1EF460C68B245887B2C6B7", hash_generated_method = "B58E64C98DF865546B71401208F968AD")
    public void setLong(Object object, long value) throws IllegalAccessException,
            IllegalArgumentException {
        setJField(object, declaringClass, type, slot, flag, TYPE_LONG, value);
        addTaint(object.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //setJField(object, declaringClass, type, slot, flag, TYPE_LONG, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.233 -0400", hash_original_method = "DEE843BD220F8992FC80A23844FC7C06", hash_generated_method = "D1C849BC6F8A0BC5AEE64282749CC834")
    public void setShort(Object object, short value) throws IllegalAccessException,
            IllegalArgumentException {
        setSField(object, declaringClass, type, slot, flag, TYPE_SHORT, value);
        addTaint(object.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //setSField(object, declaringClass, type, slot, flag, TYPE_SHORT, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.251 -0400", hash_original_method = "2B14553F8A926216EE23C791DBC737FD", hash_generated_method = "3D43DFE4D89F0F39FD1163932A9169B5")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_747357489 = null; //Variable for return #1
        StringBuilder result;
        result = new StringBuilder(Modifier.toString(getModifiers()));
        {
            boolean varFD23457D7925EE9ADC9C1D678FE17210_1122179727 = (result.length() != 0);
            {
                result.append(' ');
            } //End block
        } //End collapsed parenthetic
        appendArrayType(result, type);
        result.append(' ');
        result.append(declaringClass.getName());
        result.append('.');
        result.append(name);
        varB4EAC82CA7396A68D541C85D26508E83_747357489 = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_747357489.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_747357489;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.254 -0400", hash_original_method = "2E771D0497C584665EAFE5039BCB9B58", hash_generated_method = "5DD6344BFC9E3A8D7857167F9BE20F54")
    private Object getField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck) throws IllegalAccessException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.254 -0400", hash_original_method = "E4CBB65FF20F2B42AAAA5852C9FC84C9", hash_generated_method = "6245DF03875F23AC82E97DA87A07FDDF")
    private double getDField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        double varE8CD7DA078A86726031AD64F35F5A6C0_445463428 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_445463428;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.255 -0400", hash_original_method = "9B86AA05444EF83A8159E0D0E3B46582", hash_generated_method = "E2B46B387B6616B6AC0B8C15B5AFCED0")
    private int getIField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_670061935 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_670061935;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.255 -0400", hash_original_method = "1F116F930DBB16C5DB58ABA31954B7AA", hash_generated_method = "E676896E4C92A049C60F4007BE82DEDC")
    private long getJField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_854847865 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_854847865;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.255 -0400", hash_original_method = "50BE3A9E4BA3ACB6450AF3382B17C97D", hash_generated_method = "8514263AE91300BE68541D9257256C3A")
    private boolean getZField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_154105000 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_154105000;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.255 -0400", hash_original_method = "94E059571B5D65D86B6231E7D36BF7FA", hash_generated_method = "F5A641EF1EA8F3E6BB303C90CFA8606D")
    private float getFField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        float var546ADE640B6EDFBC8A086EF31347E768_579694638 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_579694638;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.256 -0400", hash_original_method = "9A55E198BD753BB34F159FBC2807D96E", hash_generated_method = "ADB436AC9DDC6E9844C8CC11E56522C8")
    private char getCField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        char varA87DEB01C5F539E6BDA34829C8EF2368_1615576151 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1615576151;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.256 -0400", hash_original_method = "9FE268B454DA8902066BFF2BFC132935", hash_generated_method = "B35278B345205D08713C9AC194849222")
    private short getSField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        short var4F09DAA9D95BCB166A302407A0E0BABE_1414140684 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1414140684;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.256 -0400", hash_original_method = "B020FC56F3182544B11E7C259C9C5B21", hash_generated_method = "06B6BB896AFD7939C7A4D4AAC6689B6D")
    private byte getBField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        byte var40EA57D3EE3C07BF1C102B466E1C3091_723077289 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_723077289;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.256 -0400", hash_original_method = "D9AA799947323C8F653B1139DF380855", hash_generated_method = "C408ADE9BAD371E4961776A5655ECA1D")
    private void setField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, Object value) throws IllegalAccessException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.271 -0400", hash_original_method = "3CCE00B68111CAA3AA20979F21B904D8", hash_generated_method = "3179919531A6B77C3D15EE892C5A42ED")
    private void setDField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, double v) throws IllegalAccessException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.272 -0400", hash_original_method = "32CBAB454E52D8BFC71D6AB87E7BF1FE", hash_generated_method = "0AD27F9AC1D9709615BF81BE0EC00C6F")
    private void setIField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, int i) throws IllegalAccessException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.272 -0400", hash_original_method = "7CE46D8AB646DF2CA9A88ACDCE998029", hash_generated_method = "6C698AE9F78C7DE632773059C8D4BC97")
    private void setJField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, long j) throws IllegalAccessException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.273 -0400", hash_original_method = "E80188BF0543922F0F2BDA0A103D17F5", hash_generated_method = "72E8231E78B1D9BCE0F14C1F2F070F7A")
    private void setZField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, boolean z) throws IllegalAccessException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.274 -0400", hash_original_method = "570BC71D32CB4741615EF7701079ED2D", hash_generated_method = "8275ADFFBEC551D7D79BD7EB97FC5146")
    private void setFField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, float f) throws IllegalAccessException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.274 -0400", hash_original_method = "ACD0A6EABB934CC5EEECCAB72AA01730", hash_generated_method = "13FE5F042DD294402F9D22C992CA140C")
    private void setCField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, char c) throws IllegalAccessException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.274 -0400", hash_original_method = "2A0F6C37A6B68BD24BAC15A31879F06F", hash_generated_method = "4F3A9A2CC7778961778A3052697CE1D8")
    private void setSField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, short s) throws IllegalAccessException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.274 -0400", hash_original_method = "4D8B3646C0E699793861ED8487ADC739", hash_generated_method = "D5189C3BB7F03AFCF5839741EE6876A2")
    private void setBField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, byte b) throws IllegalAccessException {
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.274 -0400", hash_original_field = "53D2DF7F6A0025522B6A62D7BCCD362B", hash_generated_field = "FE1CC35DA4EB56C9880DCB488708D9CB")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.275 -0400", hash_original_field = "6F4F342B95B25A4C75EC3E906175F9FD", hash_generated_field = "854E423516AC00CD7F68F33C441142BE")

    private static char TYPE_BOOLEAN = 'Z';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.275 -0400", hash_original_field = "CB54D6511967B2F9F10D18E7AE656028", hash_generated_field = "6963B78C7709307B58AEFB45FAC2F0FC")

    private static char TYPE_BYTE = 'B';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.275 -0400", hash_original_field = "34382A0DD8E04475FFB7D187E09259D6", hash_generated_field = "8375B00C4DCB22E45D79A483582D6C29")

    private static char TYPE_CHAR = 'C';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.275 -0400", hash_original_field = "F7285E854CB9D5C401C99397EC300E2B", hash_generated_field = "A1A396514DF919E44547DD6F64742FCF")

    private static char TYPE_SHORT = 'S';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.275 -0400", hash_original_field = "F5EA8F78848770C9380A10B6B2C08236", hash_generated_field = "7A177DC8A52CEB1AA117FDA9C0E509BF")

    private static char TYPE_INTEGER = 'I';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.275 -0400", hash_original_field = "0AAA1EAB141AB209D9DC474506C791E0", hash_generated_field = "BB7E40C7AAC25006D5BBDE517A05EE24")

    private static char TYPE_FLOAT = 'F';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.275 -0400", hash_original_field = "34CD4E4AEA6F2DABC807608E9C9FC0EB", hash_generated_field = "CE7BCC1726DDCA50A58FB07DB35BBB9E")

    private static char TYPE_LONG = 'J';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.275 -0400", hash_original_field = "4C504F7A87B64968003D68D095C746E2", hash_generated_field = "CF448DB2C205AEA53249EFA309198635")

    private static char TYPE_DOUBLE = 'D';
}

