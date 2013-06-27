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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.082 -0400", hash_original_field = "02CBE457FB1B22631E594CE79672D2F1", hash_generated_field = "EC96049C106D95C970CBF94E8CE21744")

    private Class<?> declaringClass;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.082 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "73346820208B59684010E2508B329B0F")

    private Class<?> type;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.082 -0400", hash_original_field = "139EF988BED08F19F731C4392AB5A3AF", hash_generated_field = "DF8CDE4E2FC6AAB2D60A934C2A3F8E04")

    private Type genericType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.082 -0400", hash_original_field = "95A2153C74405BE971B467AB79B769A0", hash_generated_field = "89FDBAE6DE2AE55271071C78F774F101")

    private volatile boolean genericTypesAreInitialized = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.082 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.082 -0400", hash_original_field = "5E97994ED38A2B2F984F3B2B75012BF8", hash_generated_field = "6B06F56F1EB868ADA8CFFD63973A7E09")

    private int slot;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.082 -0400", hash_original_method = "18020B40E6468EB970BF7E1035466368", hash_generated_method = "6011D4149198435BF913A3023A4F29C3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.088 -0400", hash_original_method = "5600995DFD2A0F6D5A6AA1A0A4EAB766", hash_generated_method = "2E9BFB4D6DAB6C08310A7C3C788C3ADD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.090 -0400", hash_original_method = "5029B4C059F978BE158986B034FE3005", hash_generated_method = "3E63307BA266E148A747BE2B78618331")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.103 -0400", hash_original_method = "1CDF5107AC443AA5F8C2E1DA9DF559A0", hash_generated_method = "B898CEDBED4EA85CCE175B6691C6A4E7")
    @Override
     String getSignatureAttribute() {
        String varB4EAC82CA7396A68D541C85D26508E83_1081225273 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_170868708 = null; //Variable for return #2
        Object[] annotation;
        annotation = getSignatureAnnotation(declaringClass, slot);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1081225273 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_170868708 = StringUtils.combineStrings(annotation);
        String varA7E53CE21691AB073D9660D615818899_519265888; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_519265888 = varB4EAC82CA7396A68D541C85D26508E83_1081225273;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_519265888 = varB4EAC82CA7396A68D541C85D26508E83_170868708;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_519265888.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_519265888;
        // ---------- Original Method ----------
        //Object[] annotation = getSignatureAnnotation(declaringClass, slot);
        //if (annotation == null) {
            //return null;
        //}
        //return StringUtils.combineStrings(annotation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.103 -0400", hash_original_method = "5161131687230E0D7EE89383FDDF9117", hash_generated_method = "F1BBACEA836E9C65FE0E5D9A22FF7006")
    private Object[] getSignatureAnnotation(Class declaringClass, int slot) {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.107 -0400", hash_original_method = "FC3424D2079ACBF27BEC7269ECB48C94", hash_generated_method = "177BC0F3E8D088241C1234797DDA8F4C")
    public boolean isSynthetic() {
        int flags;
        flags = getFieldModifiers(declaringClass, slot);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_527381040 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_527381040;
        // ---------- Original Method ----------
        //int flags = getFieldModifiers(declaringClass, slot);
        //return (flags & Modifier.SYNTHETIC) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.108 -0400", hash_original_method = "E96960960A41CE3DD754F7ED4B73683A", hash_generated_method = "3CDD1848F09ABD867F7AF2F062CA948F")
    public String toGenericString() {
        String varB4EAC82CA7396A68D541C85D26508E83_943009448 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_943009448 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_943009448.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_943009448;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.108 -0400", hash_original_method = "2827C86400F787FBBD0EA58BB5706D02", hash_generated_method = "6A106D072BBB217C2F99460A45DA83DF")
    public boolean isEnumConstant() {
        int flags;
        flags = getFieldModifiers(declaringClass, slot);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2139329211 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2139329211;
        // ---------- Original Method ----------
        //int flags = getFieldModifiers(declaringClass, slot);
        //return (flags & Modifier.ENUM) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.109 -0400", hash_original_method = "963F10B2A4697E7A9ECC1BB94066D74F", hash_generated_method = "CF09567651E751313815DCDFF9AD7D8C")
    public Type getGenericType() {
        Type varB4EAC82CA7396A68D541C85D26508E83_913077256 = null; //Variable for return #1
        initGenericType();
        varB4EAC82CA7396A68D541C85D26508E83_913077256 = Types.getType(genericType);
        varB4EAC82CA7396A68D541C85D26508E83_913077256.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_913077256;
        // ---------- Original Method ----------
        //initGenericType();
        //return Types.getType(genericType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.109 -0400", hash_original_method = "4122EC91CDDE6FFD9DA08F5ADAF8DB5D", hash_generated_method = "43CC4B1952C2ABFBEAAF838458A9EBB9")
    @Override
    public Annotation[] getDeclaredAnnotations() {
        Annotation[] varB4EAC82CA7396A68D541C85D26508E83_543285921 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_543285921 = getDeclaredAnnotations(declaringClass, slot);
        varB4EAC82CA7396A68D541C85D26508E83_543285921.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_543285921;
        // ---------- Original Method ----------
        //return getDeclaredAnnotations(declaringClass, slot);
    }

    
        private static Annotation[] getDeclaredAnnotations(Class declaringClass, int slot) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.110 -0400", hash_original_method = "C04F97610183E33B13FB9B4273375B6D", hash_generated_method = "BB5B4024407E2ECDA1E085F30E868EEB")
    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        A varB4EAC82CA7396A68D541C85D26508E83_1967677718 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("annotationType == null");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1967677718 = getAnnotation(declaringClass, slot, annotationType);
        addTaint(annotationType.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1967677718.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1967677718;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.118 -0400", hash_original_method = "D8B142EB73E138FF5927E6AE1DAD56D2", hash_generated_method = "BF90C9BFBCB39100883DF727CE1D12E1")
    @Override
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("annotationType == null");
        } //End block
        boolean varB3780DB5BBCCEE48C62CDF997A07D42D_76648752 = (isAnnotationPresent(declaringClass, slot, annotationType));
        addTaint(annotationType.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_94051702 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_94051702;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.131 -0400", hash_original_method = "955F27DFEC9F7B5FBB7D8BD5BE41A050", hash_generated_method = "39F81266EC6567B2348E3F99B58D691C")
    @Override
    public boolean equals(Object object) {
        boolean varDCACFE8832290BDBC09105E7C6859538_258145247 = (object instanceof Field && toString().equals(object.toString()));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_172604825 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_172604825;
        // ---------- Original Method ----------
        //return object instanceof Field && toString().equals(object.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.131 -0400", hash_original_method = "7AE3BC00249CC99885BB0445C93FB18A", hash_generated_method = "B5C4F0CFF9B1D6980716ADD4F2A18514")
    public Object get(Object object) throws IllegalAccessException, IllegalArgumentException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1865556776 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1865556776 = getField(object, declaringClass, type, slot, flag);
        addTaint(object.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1865556776.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1865556776;
        // ---------- Original Method ----------
        //return getField(object, declaringClass, type, slot, flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.132 -0400", hash_original_method = "27492232D5FCC61236B83BF948F6F104", hash_generated_method = "CE580143744041E08E101FC80B353C25")
    public boolean getBoolean(Object object) throws IllegalAccessException,
            IllegalArgumentException {
        boolean var9DA284626B9970789966B6A4F6E5FB32_608202898 = (getZField(object, declaringClass, type, slot, flag, TYPE_BOOLEAN));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1421328246 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1421328246;
        // ---------- Original Method ----------
        //return getZField(object, declaringClass, type, slot, flag, TYPE_BOOLEAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.132 -0400", hash_original_method = "638C7C4918F4FDF5130555C74F583890", hash_generated_method = "AFB926EB2CD10BD32B7797249D6A3FDA")
    public byte getByte(Object object) throws IllegalAccessException, IllegalArgumentException {
        byte varA215D52F81AAE6605102E4D98BCBBCB4_904035622 = (getBField(object, declaringClass, type, slot, flag, TYPE_BYTE));
        addTaint(object.getTaint());
        byte var40EA57D3EE3C07BF1C102B466E1C3091_143596201 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_143596201;
        // ---------- Original Method ----------
        //return getBField(object, declaringClass, type, slot, flag, TYPE_BYTE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.132 -0400", hash_original_method = "6648A25494EBFE26376F66DF9331BADB", hash_generated_method = "DA41F23DE5121C4EE5D17C67F2824C87")
    public char getChar(Object object) throws IllegalAccessException, IllegalArgumentException {
        char var955F981595FD17AB1396A3EADA1E0C15_1967634647 = (getCField(object, declaringClass, type, slot, flag, TYPE_CHAR));
        addTaint(object.getTaint());
        char varA87DEB01C5F539E6BDA34829C8EF2368_434206697 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_434206697;
        // ---------- Original Method ----------
        //return getCField(object, declaringClass, type, slot, flag, TYPE_CHAR);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.133 -0400", hash_original_method = "747BEFE9985C4AF4EE3D5630B62185EA", hash_generated_method = "F03599A3C581FD39C62D0CBF772720DD")
    public Class<?> getDeclaringClass() {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_2051744877 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2051744877 = declaringClass;
        varB4EAC82CA7396A68D541C85D26508E83_2051744877.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2051744877;
        // ---------- Original Method ----------
        //return declaringClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.133 -0400", hash_original_method = "B22A8667913C0820CACD3D8F78E3B803", hash_generated_method = "9C7AF175A8877B7A3BD51636EA18F7D7")
    public double getDouble(Object object) throws IllegalAccessException, IllegalArgumentException {
        double varAE2581BDD0AD43AE217DFFB84BBB208E_10728496 = (getDField(object, declaringClass, type, slot, flag, TYPE_DOUBLE));
        addTaint(object.getTaint());
        double varE8CD7DA078A86726031AD64F35F5A6C0_1573132882 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1573132882;
        // ---------- Original Method ----------
        //return getDField(object, declaringClass, type, slot, flag, TYPE_DOUBLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.137 -0400", hash_original_method = "BFF553DA1989441891013747E355F341", hash_generated_method = "5F12AB905CB57FE58A51ED63CEA7594A")
    public float getFloat(Object object) throws IllegalAccessException, IllegalArgumentException {
        float var1A5038016F232945D7BD627195B26E7D_158802794 = (getFField(object, declaringClass, type, slot, flag, TYPE_FLOAT));
        addTaint(object.getTaint());
        float var546ADE640B6EDFBC8A086EF31347E768_1523858882 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1523858882;
        // ---------- Original Method ----------
        //return getFField(object, declaringClass, type, slot, flag, TYPE_FLOAT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.138 -0400", hash_original_method = "5CB83BC53ADA020FA0FD37C15AAD9E62", hash_generated_method = "E03296A0D2FE2F79F4E9E11AD26C961E")
    public int getInt(Object object) throws IllegalAccessException, IllegalArgumentException {
        int var5F795D86675AD53A1B7ACF3414BE7AF6_215669234 = (getIField(object, declaringClass, type, slot, flag, TYPE_INTEGER));
        addTaint(object.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1909337772 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1909337772;
        // ---------- Original Method ----------
        //return getIField(object, declaringClass, type, slot, flag, TYPE_INTEGER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.138 -0400", hash_original_method = "005A2557A921AA55BF8BDBCBDC639BE4", hash_generated_method = "A3FA9E8C7601AFA4D2D32A2DECBAD288")
    public long getLong(Object object) throws IllegalAccessException, IllegalArgumentException {
        long var250CDA2AC47DDC6DF64D4C553373D869_1602694019 = (getJField(object, declaringClass, type, slot, flag, TYPE_LONG));
        addTaint(object.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_644560377 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_644560377;
        // ---------- Original Method ----------
        //return getJField(object, declaringClass, type, slot, flag, TYPE_LONG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.138 -0400", hash_original_method = "5A676A538E8952F6729F0D8423178A33", hash_generated_method = "1A4A233F83EDDCB285BE019CE14C3F2F")
    public int getModifiers() {
        int var49B847D353C589D7A33E0861E95832A8_732157830 = (getFieldModifiers(declaringClass, slot));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_842601049 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_842601049;
        // ---------- Original Method ----------
        //return getFieldModifiers(declaringClass, slot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.145 -0400", hash_original_method = "9D513D500FBFD57DB21A924D9A85826A", hash_generated_method = "E1F3AC5FB4E3C6866D70D59B40C6144B")
    private int getFieldModifiers(Class<?> declaringClass, int slot) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1459923015 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1459923015;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.150 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "B70AFB9E39FC456E9F528C63BA846F5D")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1701245337 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1701245337 = name;
        varB4EAC82CA7396A68D541C85D26508E83_1701245337.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1701245337;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.150 -0400", hash_original_method = "0DDA5605A2464ED398902817D939E3F2", hash_generated_method = "45919B222DD837FF87EF6BAC3286A79B")
    public short getShort(Object object) throws IllegalAccessException, IllegalArgumentException {
        short var71629059FF106ED311F07E4A99F9E53D_1390708149 = (getSField(object, declaringClass, type, slot, flag, TYPE_SHORT));
        addTaint(object.getTaint());
        short var4F09DAA9D95BCB166A302407A0E0BABE_657627959 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_657627959;
        // ---------- Original Method ----------
        //return getSField(object, declaringClass, type, slot, flag, TYPE_SHORT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.158 -0400", hash_original_method = "994767CE6492BCD5B50ECB089389E539", hash_generated_method = "91B53DB799E70E70682480D3D79A57D6")
    @SuppressWarnings("unused")
    private String getSignature() {
        String varB4EAC82CA7396A68D541C85D26508E83_1232383228 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1232383228 = getSignature(type);
        varB4EAC82CA7396A68D541C85D26508E83_1232383228.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1232383228;
        // ---------- Original Method ----------
        //return getSignature(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.159 -0400", hash_original_method = "21C93A7CC51FD6114C8D944747F943F4", hash_generated_method = "7972F9EE6EB8A7D9850230AF36FB87FF")
    public Class<?> getType() {
        Class<?> varB4EAC82CA7396A68D541C85D26508E83_820426815 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_820426815 = type;
        varB4EAC82CA7396A68D541C85D26508E83_820426815.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_820426815;
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.159 -0400", hash_original_method = "7C0B16AD34D2790FBD73D96D003DD91D", hash_generated_method = "A9024A9BFDB673DEE2A20045C62898EC")
    @Override
    public int hashCode() {
        int varFE991B9610FD8386F23C23BA9DCC53AC_300742545 = (name.hashCode() ^ getDeclaringClass().getName().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1322830205 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1322830205;
        // ---------- Original Method ----------
        //return name.hashCode() ^ getDeclaringClass().getName().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.159 -0400", hash_original_method = "6D24AA0F6B01F01D922DBBA93FD91F81", hash_generated_method = "BE8D86CDF9D6D7515528CA02A2DF2402")
    public void set(Object object, Object value) throws IllegalAccessException,
            IllegalArgumentException {
        setField(object, declaringClass, type, slot, flag, value);
        addTaint(object.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //setField(object, declaringClass, type, slot, flag, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.167 -0400", hash_original_method = "25FFB4639E444F2A9FD12AF0E909B7A5", hash_generated_method = "F7C67AF7E674AED306123873A7EC9976")
    public void setBoolean(Object object, boolean value) throws IllegalAccessException,
            IllegalArgumentException {
        setZField(object, declaringClass, type, slot, flag, TYPE_BOOLEAN, value);
        addTaint(object.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //setZField(object, declaringClass, type, slot, flag, TYPE_BOOLEAN, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.168 -0400", hash_original_method = "AD912B9A4F5D11756FF2F9AE3FC4D6E6", hash_generated_method = "78C069FBF1B31A73A7EE47D898A2CC4E")
    public void setByte(Object object, byte value) throws IllegalAccessException,
            IllegalArgumentException {
        setBField(object, declaringClass, type, slot, flag, TYPE_BYTE, value);
        addTaint(object.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //setBField(object, declaringClass, type, slot, flag, TYPE_BYTE, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.168 -0400", hash_original_method = "97D79EA86FEBB11A4E8B5CD3EFF3DEF5", hash_generated_method = "232046BF1BDA63993FE262C113EB4221")
    public void setChar(Object object, char value) throws IllegalAccessException,
            IllegalArgumentException {
        setCField(object, declaringClass, type, slot, flag, TYPE_CHAR, value);
        addTaint(object.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //setCField(object, declaringClass, type, slot, flag, TYPE_CHAR, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.168 -0400", hash_original_method = "5E12E36ACBA66ADB7DF4FF63170F60C3", hash_generated_method = "A577B73AE70371742336A7B6B41D0248")
    public void setDouble(Object object, double value) throws IllegalAccessException,
            IllegalArgumentException {
        setDField(object, declaringClass, type, slot, flag, TYPE_DOUBLE, value);
        addTaint(object.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //setDField(object, declaringClass, type, slot, flag, TYPE_DOUBLE, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.172 -0400", hash_original_method = "4860783C5B567E2FC646E7FC5AE81E3C", hash_generated_method = "72DD4D48FE8B6BAD52414698FE9819AD")
    public void setFloat(Object object, float value) throws IllegalAccessException,
            IllegalArgumentException {
        setFField(object, declaringClass, type, slot, flag, TYPE_FLOAT, value);
        addTaint(object.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //setFField(object, declaringClass, type, slot, flag, TYPE_FLOAT, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.173 -0400", hash_original_method = "DA13B1330D08A636280F51E51FF711B2", hash_generated_method = "5B8EAC3DCB5F4D694C05F075179601B1")
    public void setInt(Object object, int value) throws IllegalAccessException,
            IllegalArgumentException {
        setIField(object, declaringClass, type, slot, flag, TYPE_INTEGER, value);
        addTaint(object.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //setIField(object, declaringClass, type, slot, flag, TYPE_INTEGER, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.173 -0400", hash_original_method = "F703AA23CA1EF460C68B245887B2C6B7", hash_generated_method = "B58E64C98DF865546B71401208F968AD")
    public void setLong(Object object, long value) throws IllegalAccessException,
            IllegalArgumentException {
        setJField(object, declaringClass, type, slot, flag, TYPE_LONG, value);
        addTaint(object.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //setJField(object, declaringClass, type, slot, flag, TYPE_LONG, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.173 -0400", hash_original_method = "DEE843BD220F8992FC80A23844FC7C06", hash_generated_method = "D1C849BC6F8A0BC5AEE64282749CC834")
    public void setShort(Object object, short value) throws IllegalAccessException,
            IllegalArgumentException {
        setSField(object, declaringClass, type, slot, flag, TYPE_SHORT, value);
        addTaint(object.getTaint());
        addTaint(value);
        // ---------- Original Method ----------
        //setSField(object, declaringClass, type, slot, flag, TYPE_SHORT, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.180 -0400", hash_original_method = "2B14553F8A926216EE23C791DBC737FD", hash_generated_method = "47F5CAB6DE127884098E0FF9A6A3F107")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_605902959 = null; //Variable for return #1
        StringBuilder result;
        result = new StringBuilder(Modifier.toString(getModifiers()));
        {
            boolean varFD23457D7925EE9ADC9C1D678FE17210_1119488125 = (result.length() != 0);
            {
                result.append(' ');
            } //End block
        } //End collapsed parenthetic
        appendArrayType(result, type);
        result.append(' ');
        result.append(declaringClass.getName());
        result.append('.');
        result.append(name);
        varB4EAC82CA7396A68D541C85D26508E83_605902959 = result.toString();
        varB4EAC82CA7396A68D541C85D26508E83_605902959.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_605902959;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.181 -0400", hash_original_method = "2E771D0497C584665EAFE5039BCB9B58", hash_generated_method = "5DD6344BFC9E3A8D7857167F9BE20F54")
    private Object getField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck) throws IllegalAccessException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.181 -0400", hash_original_method = "E4CBB65FF20F2B42AAAA5852C9FC84C9", hash_generated_method = "B613714108F82063BC1563F236A574A4")
    private double getDField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        double varE8CD7DA078A86726031AD64F35F5A6C0_1151243159 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1151243159;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.181 -0400", hash_original_method = "9B86AA05444EF83A8159E0D0E3B46582", hash_generated_method = "C52094EDE536A6B2D6F70C015568977F")
    private int getIField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1971757649 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1971757649;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.188 -0400", hash_original_method = "1F116F930DBB16C5DB58ABA31954B7AA", hash_generated_method = "B9AE83EC392BCD9C2A45FEF3EE389D5F")
    private long getJField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1731967171 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1731967171;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.192 -0400", hash_original_method = "50BE3A9E4BA3ACB6450AF3382B17C97D", hash_generated_method = "5C33901191B23E4BBB4976B782D5EFEF")
    private boolean getZField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1453896756 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1453896756;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.192 -0400", hash_original_method = "94E059571B5D65D86B6231E7D36BF7FA", hash_generated_method = "67E6C7282704B28982FDCC84C63BD98A")
    private float getFField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        float var546ADE640B6EDFBC8A086EF31347E768_846781353 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_846781353;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.192 -0400", hash_original_method = "9A55E198BD753BB34F159FBC2807D96E", hash_generated_method = "36FBFF99A39045213701A04061895A38")
    private char getCField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        char varA87DEB01C5F539E6BDA34829C8EF2368_2048050194 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_2048050194;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.193 -0400", hash_original_method = "9FE268B454DA8902066BFF2BFC132935", hash_generated_method = "97E51B05234EAF50844BA996692F4045")
    private short getSField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        short var4F09DAA9D95BCB166A302407A0E0BABE_1577757247 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1577757247;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.193 -0400", hash_original_method = "B020FC56F3182544B11E7C259C9C5B21", hash_generated_method = "B419FD2EF7C6F501148BD86DFEE7A74D")
    private byte getBField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        byte var40EA57D3EE3C07BF1C102B466E1C3091_525897750 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_525897750;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.193 -0400", hash_original_method = "D9AA799947323C8F653B1139DF380855", hash_generated_method = "C408ADE9BAD371E4961776A5655ECA1D")
    private void setField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, Object value) throws IllegalAccessException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.197 -0400", hash_original_method = "3CCE00B68111CAA3AA20979F21B904D8", hash_generated_method = "3179919531A6B77C3D15EE892C5A42ED")
    private void setDField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, double v) throws IllegalAccessException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.197 -0400", hash_original_method = "32CBAB454E52D8BFC71D6AB87E7BF1FE", hash_generated_method = "0AD27F9AC1D9709615BF81BE0EC00C6F")
    private void setIField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, int i) throws IllegalAccessException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.201 -0400", hash_original_method = "7CE46D8AB646DF2CA9A88ACDCE998029", hash_generated_method = "6C698AE9F78C7DE632773059C8D4BC97")
    private void setJField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, long j) throws IllegalAccessException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.205 -0400", hash_original_method = "E80188BF0543922F0F2BDA0A103D17F5", hash_generated_method = "72E8231E78B1D9BCE0F14C1F2F070F7A")
    private void setZField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, boolean z) throws IllegalAccessException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.206 -0400", hash_original_method = "570BC71D32CB4741615EF7701079ED2D", hash_generated_method = "8275ADFFBEC551D7D79BD7EB97FC5146")
    private void setFField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, float f) throws IllegalAccessException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.206 -0400", hash_original_method = "ACD0A6EABB934CC5EEECCAB72AA01730", hash_generated_method = "13FE5F042DD294402F9D22C992CA140C")
    private void setCField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, char c) throws IllegalAccessException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.207 -0400", hash_original_method = "2A0F6C37A6B68BD24BAC15A31879F06F", hash_generated_method = "4F3A9A2CC7778961778A3052697CE1D8")
    private void setSField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, short s) throws IllegalAccessException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.220 -0400", hash_original_method = "4D8B3646C0E699793861ED8487ADC739", hash_generated_method = "D5189C3BB7F03AFCF5839741EE6876A2")
    private void setBField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, byte b) throws IllegalAccessException {
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.220 -0400", hash_original_field = "53D2DF7F6A0025522B6A62D7BCCD362B", hash_generated_field = "FE1CC35DA4EB56C9880DCB488708D9CB")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.220 -0400", hash_original_field = "6F4F342B95B25A4C75EC3E906175F9FD", hash_generated_field = "854E423516AC00CD7F68F33C441142BE")

    private static char TYPE_BOOLEAN = 'Z';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.220 -0400", hash_original_field = "CB54D6511967B2F9F10D18E7AE656028", hash_generated_field = "6963B78C7709307B58AEFB45FAC2F0FC")

    private static char TYPE_BYTE = 'B';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.220 -0400", hash_original_field = "34382A0DD8E04475FFB7D187E09259D6", hash_generated_field = "8375B00C4DCB22E45D79A483582D6C29")

    private static char TYPE_CHAR = 'C';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.220 -0400", hash_original_field = "F7285E854CB9D5C401C99397EC300E2B", hash_generated_field = "A1A396514DF919E44547DD6F64742FCF")

    private static char TYPE_SHORT = 'S';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.220 -0400", hash_original_field = "F5EA8F78848770C9380A10B6B2C08236", hash_generated_field = "7A177DC8A52CEB1AA117FDA9C0E509BF")

    private static char TYPE_INTEGER = 'I';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.220 -0400", hash_original_field = "0AAA1EAB141AB209D9DC474506C791E0", hash_generated_field = "BB7E40C7AAC25006D5BBDE517A05EE24")

    private static char TYPE_FLOAT = 'F';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.220 -0400", hash_original_field = "34CD4E4AEA6F2DABC807608E9C9FC0EB", hash_generated_field = "CE7BCC1726DDCA50A58FB07DB35BBB9E")

    private static char TYPE_LONG = 'J';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.220 -0400", hash_original_field = "4C504F7A87B64968003D68D095C746E2", hash_generated_field = "CF448DB2C205AEA53249EFA309198635")

    private static char TYPE_DOUBLE = 'D';
}

