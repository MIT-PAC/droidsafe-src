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
    private Class<?> declaringClass;
    private Class<?> type;
    private Type genericType;
    private volatile boolean genericTypesAreInitialized = false;
    private String name;
    private int slot;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.863 -0400", hash_original_method = "18020B40E6468EB970BF7E1035466368", hash_generated_method = "96B4E08B912325CBF3080AE2DD0148DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Field(Field orig) {
        this(orig.declaringClass, orig.type, orig.name, orig.slot);
        dsTaint.addTaint(orig.dsTaint);
        {
            this.flag = true;
        } //End block
        // ---------- Original Method ----------
        //if (orig.flag) {
            //this.flag = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.863 -0400", hash_original_method = "5600995DFD2A0F6D5A6AA1A0A4EAB766", hash_generated_method = "B09BBC8BC198A7B9DBE365EB0B9B9E7C")
    @DSModeled(DSC.SAFE)
    private Field(Class<?> declaringClass, Class<?> type, String name, int slot) {
        dsTaint.addTaint(declaringClass.dsTaint);
        dsTaint.addTaint(name);
        dsTaint.addTaint(slot);
        dsTaint.addTaint(type.dsTaint);
        // ---------- Original Method ----------
        //this.declaringClass = declaringClass;
        //this.type = type;
        //this.name = name;
        //this.slot = slot;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.863 -0400", hash_original_method = "5029B4C059F978BE158986B034FE3005", hash_generated_method = "3E63307BA266E148A747BE2B78618331")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.864 -0400", hash_original_method = "1CDF5107AC443AA5F8C2E1DA9DF559A0", hash_generated_method = "395B3EECC62041291A995E27CDA4BB45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     String getSignatureAttribute() {
        Object[] annotation;
        annotation = getSignatureAnnotation(declaringClass, slot);
        String var33705CFE2485E284459211E6CFE410F3_139277998 = (StringUtils.combineStrings(annotation));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Object[] annotation = getSignatureAnnotation(declaringClass, slot);
        //if (annotation == null) {
            //return null;
        //}
        //return StringUtils.combineStrings(annotation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.864 -0400", hash_original_method = "5161131687230E0D7EE89383FDDF9117", hash_generated_method = "9F3082987B1E34D7A95BB1BD4A043BF7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object[] getSignatureAnnotation(Class declaringClass, int slot) {
        dsTaint.addTaint(declaringClass.dsTaint);
        dsTaint.addTaint(slot);
        return (Object[])dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.864 -0400", hash_original_method = "FC3424D2079ACBF27BEC7269ECB48C94", hash_generated_method = "476F9D10EED74B9317FEAF86485EEEA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isSynthetic() {
        int flags;
        flags = getFieldModifiers(declaringClass, slot);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int flags = getFieldModifiers(declaringClass, slot);
        //return (flags & Modifier.SYNTHETIC) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.865 -0400", hash_original_method = "E96960960A41CE3DD754F7ED4B73683A", hash_generated_method = "0BAB2CC56145CDE07575E182F721177F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toGenericString() {
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
        String var806458D832AB974D230FEE4CBBDBD390_1520216629 = (sb.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.865 -0400", hash_original_method = "2827C86400F787FBBD0EA58BB5706D02", hash_generated_method = "85CE035D1808F8DAB7D89987F0C38364")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEnumConstant() {
        int flags;
        flags = getFieldModifiers(declaringClass, slot);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int flags = getFieldModifiers(declaringClass, slot);
        //return (flags & Modifier.ENUM) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.865 -0400", hash_original_method = "963F10B2A4697E7A9ECC1BB94066D74F", hash_generated_method = "5604876823A725505855E27C528DA65E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Type getGenericType() {
        initGenericType();
        Type var170E1EA7DEAB06104AE30D989C517A53_1903210049 = (Types.getType(genericType));
        return (Type)dsTaint.getTaint();
        // ---------- Original Method ----------
        //initGenericType();
        //return Types.getType(genericType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.873 -0400", hash_original_method = "4122EC91CDDE6FFD9DA08F5ADAF8DB5D", hash_generated_method = "68E5E828E59BB716A7F75C1FAA61D7B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Annotation[] getDeclaredAnnotations() {
        Annotation[] varC17A9D109C2F23B123FCE14BCDF22667_1251558166 = (getDeclaredAnnotations(declaringClass, slot));
        return (Annotation[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getDeclaredAnnotations(declaringClass, slot);
    }

    
        private static Annotation[] getDeclaredAnnotations(Class declaringClass, int slot) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.874 -0400", hash_original_method = "C04F97610183E33B13FB9B4273375B6D", hash_generated_method = "E0BC1716C856BC8AB95C10DC43BE50F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
        dsTaint.addTaint(annotationType.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("annotationType == null");
        } //End block
        A var5916D8A05D9FACE17C9DF14466E6D186_782895509 = (getAnnotation(declaringClass, slot, annotationType));
        return (A)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.874 -0400", hash_original_method = "D8B142EB73E138FF5927E6AE1DAD56D2", hash_generated_method = "BC32B0C86B3929FB1994DFB6B20293E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationType) {
        dsTaint.addTaint(annotationType.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("annotationType == null");
        } //End block
        boolean varB3780DB5BBCCEE48C62CDF997A07D42D_374290692 = (isAnnotationPresent(declaringClass, slot, annotationType));
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.875 -0400", hash_original_method = "955F27DFEC9F7B5FBB7D8BD5BE41A050", hash_generated_method = "C9D5651199FF15CE3046830609A2496E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        boolean varDCACFE8832290BDBC09105E7C6859538_1411545707 = (object instanceof Field && toString().equals(object.toString()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return object instanceof Field && toString().equals(object.toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.875 -0400", hash_original_method = "7AE3BC00249CC99885BB0445C93FB18A", hash_generated_method = "9BF122FE6BFA721E0B809546631E2037")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object get(Object object) throws IllegalAccessException, IllegalArgumentException {
        dsTaint.addTaint(object.dsTaint);
        Object varD28C1EFCF24C94C02D24865CE6F475EE_2104794295 = (getField(object, declaringClass, type, slot, flag));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getField(object, declaringClass, type, slot, flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.875 -0400", hash_original_method = "27492232D5FCC61236B83BF948F6F104", hash_generated_method = "BE400D5DA07C466FA62D63C6D6973E96")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getBoolean(Object object) throws IllegalAccessException,
            IllegalArgumentException {
        dsTaint.addTaint(object.dsTaint);
        boolean var9DA284626B9970789966B6A4F6E5FB32_1619074660 = (getZField(object, declaringClass, type, slot, flag, TYPE_BOOLEAN));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getZField(object, declaringClass, type, slot, flag, TYPE_BOOLEAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.875 -0400", hash_original_method = "638C7C4918F4FDF5130555C74F583890", hash_generated_method = "67A47AF0872AAC4DE9B3105272C3AD7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte getByte(Object object) throws IllegalAccessException, IllegalArgumentException {
        dsTaint.addTaint(object.dsTaint);
        byte varA215D52F81AAE6605102E4D98BCBBCB4_1185905394 = (getBField(object, declaringClass, type, slot, flag, TYPE_BYTE));
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //return getBField(object, declaringClass, type, slot, flag, TYPE_BYTE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.875 -0400", hash_original_method = "6648A25494EBFE26376F66DF9331BADB", hash_generated_method = "8E730AD81701CED84D054C666B966108")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public char getChar(Object object) throws IllegalAccessException, IllegalArgumentException {
        dsTaint.addTaint(object.dsTaint);
        char var955F981595FD17AB1396A3EADA1E0C15_1447227673 = (getCField(object, declaringClass, type, slot, flag, TYPE_CHAR));
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return getCField(object, declaringClass, type, slot, flag, TYPE_CHAR);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.875 -0400", hash_original_method = "747BEFE9985C4AF4EE3D5630B62185EA", hash_generated_method = "3640F7B34AFA7FCA661FE004002AD79B")
    @DSModeled(DSC.SAFE)
    public Class<?> getDeclaringClass() {
        return (Class<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return declaringClass;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.876 -0400", hash_original_method = "B22A8667913C0820CACD3D8F78E3B803", hash_generated_method = "F5A86658E3413A65090F9C78D212021F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public double getDouble(Object object) throws IllegalAccessException, IllegalArgumentException {
        dsTaint.addTaint(object.dsTaint);
        double varAE2581BDD0AD43AE217DFFB84BBB208E_1123046340 = (getDField(object, declaringClass, type, slot, flag, TYPE_DOUBLE));
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return getDField(object, declaringClass, type, slot, flag, TYPE_DOUBLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.876 -0400", hash_original_method = "BFF553DA1989441891013747E355F341", hash_generated_method = "9ED9DC4D9A45A95AD630F0577AB5E704")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getFloat(Object object) throws IllegalAccessException, IllegalArgumentException {
        dsTaint.addTaint(object.dsTaint);
        float var1A5038016F232945D7BD627195B26E7D_366019334 = (getFField(object, declaringClass, type, slot, flag, TYPE_FLOAT));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return getFField(object, declaringClass, type, slot, flag, TYPE_FLOAT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.876 -0400", hash_original_method = "5CB83BC53ADA020FA0FD37C15AAD9E62", hash_generated_method = "2B8F8356959520A47EC305D59ADBCCBA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getInt(Object object) throws IllegalAccessException, IllegalArgumentException {
        dsTaint.addTaint(object.dsTaint);
        int var5F795D86675AD53A1B7ACF3414BE7AF6_850324457 = (getIField(object, declaringClass, type, slot, flag, TYPE_INTEGER));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getIField(object, declaringClass, type, slot, flag, TYPE_INTEGER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.876 -0400", hash_original_method = "005A2557A921AA55BF8BDBCBDC639BE4", hash_generated_method = "9E3C4C7B24D0C2FF2A2DFA1F83474C34")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getLong(Object object) throws IllegalAccessException, IllegalArgumentException {
        dsTaint.addTaint(object.dsTaint);
        long var250CDA2AC47DDC6DF64D4C553373D869_1031315246 = (getJField(object, declaringClass, type, slot, flag, TYPE_LONG));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return getJField(object, declaringClass, type, slot, flag, TYPE_LONG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.876 -0400", hash_original_method = "5A676A538E8952F6729F0D8423178A33", hash_generated_method = "E7D02F74BA6F741ECFADDAC1D393C5AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getModifiers() {
        int var49B847D353C589D7A33E0861E95832A8_2100100504 = (getFieldModifiers(declaringClass, slot));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getFieldModifiers(declaringClass, slot);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.876 -0400", hash_original_method = "9D513D500FBFD57DB21A924D9A85826A", hash_generated_method = "D321C450CA1BB4F6F4689301D9EECF9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getFieldModifiers(Class<?> declaringClass, int slot) {
        dsTaint.addTaint(declaringClass.dsTaint);
        dsTaint.addTaint(slot);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.877 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "3573899E99121C9CFE87F9DDAEE36810")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.877 -0400", hash_original_method = "0DDA5605A2464ED398902817D939E3F2", hash_generated_method = "6DDAFDAE59A62E2810F26F669518FF3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public short getShort(Object object) throws IllegalAccessException, IllegalArgumentException {
        dsTaint.addTaint(object.dsTaint);
        short var71629059FF106ED311F07E4A99F9E53D_1703340800 = (getSField(object, declaringClass, type, slot, flag, TYPE_SHORT));
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return getSField(object, declaringClass, type, slot, flag, TYPE_SHORT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.877 -0400", hash_original_method = "994767CE6492BCD5B50ECB089389E539", hash_generated_method = "AE39B82CED9116FEB66A6F810732B681")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unused")
    private String getSignature() {
        String var5FC76005A19E0B56E0F03F4B344A7764_464492555 = (getSignature(type));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getSignature(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.877 -0400", hash_original_method = "21C93A7CC51FD6114C8D944747F943F4", hash_generated_method = "E67F082D6A1782ACA82C21A92FFD9FA6")
    @DSModeled(DSC.SAFE)
    public Class<?> getType() {
        return (Class<?>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.877 -0400", hash_original_method = "7C0B16AD34D2790FBD73D96D003DD91D", hash_generated_method = "CB01CA0FEEFB37AA9724178D8F3A3183")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int varFE991B9610FD8386F23C23BA9DCC53AC_489015084 = (name.hashCode() ^ getDeclaringClass().getName().hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return name.hashCode() ^ getDeclaringClass().getName().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.877 -0400", hash_original_method = "6D24AA0F6B01F01D922DBBA93FD91F81", hash_generated_method = "611B391D089360FEF1B73EA4EA1D9994")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void set(Object object, Object value) throws IllegalAccessException,
            IllegalArgumentException {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(object.dsTaint);
        setField(object, declaringClass, type, slot, flag, value);
        // ---------- Original Method ----------
        //setField(object, declaringClass, type, slot, flag, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.878 -0400", hash_original_method = "25FFB4639E444F2A9FD12AF0E909B7A5", hash_generated_method = "6486459DDB03C089EADB7443B8880582")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setBoolean(Object object, boolean value) throws IllegalAccessException,
            IllegalArgumentException {
        dsTaint.addTaint(value);
        dsTaint.addTaint(object.dsTaint);
        setZField(object, declaringClass, type, slot, flag, TYPE_BOOLEAN, value);
        // ---------- Original Method ----------
        //setZField(object, declaringClass, type, slot, flag, TYPE_BOOLEAN, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.878 -0400", hash_original_method = "AD912B9A4F5D11756FF2F9AE3FC4D6E6", hash_generated_method = "3F12051F29B323D82A435FE550287C79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setByte(Object object, byte value) throws IllegalAccessException,
            IllegalArgumentException {
        dsTaint.addTaint(value);
        dsTaint.addTaint(object.dsTaint);
        setBField(object, declaringClass, type, slot, flag, TYPE_BYTE, value);
        // ---------- Original Method ----------
        //setBField(object, declaringClass, type, slot, flag, TYPE_BYTE, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.878 -0400", hash_original_method = "97D79EA86FEBB11A4E8B5CD3EFF3DEF5", hash_generated_method = "FBCFE6EE7AAE238874FC59B358ECB5BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setChar(Object object, char value) throws IllegalAccessException,
            IllegalArgumentException {
        dsTaint.addTaint(value);
        dsTaint.addTaint(object.dsTaint);
        setCField(object, declaringClass, type, slot, flag, TYPE_CHAR, value);
        // ---------- Original Method ----------
        //setCField(object, declaringClass, type, slot, flag, TYPE_CHAR, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.878 -0400", hash_original_method = "5E12E36ACBA66ADB7DF4FF63170F60C3", hash_generated_method = "D1DEA5A8A8DEC37BEA3DE076BA3DD992")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDouble(Object object, double value) throws IllegalAccessException,
            IllegalArgumentException {
        dsTaint.addTaint(value);
        dsTaint.addTaint(object.dsTaint);
        setDField(object, declaringClass, type, slot, flag, TYPE_DOUBLE, value);
        // ---------- Original Method ----------
        //setDField(object, declaringClass, type, slot, flag, TYPE_DOUBLE, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.878 -0400", hash_original_method = "4860783C5B567E2FC646E7FC5AE81E3C", hash_generated_method = "8237F12555F65F5412B297B877030963")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFloat(Object object, float value) throws IllegalAccessException,
            IllegalArgumentException {
        dsTaint.addTaint(value);
        dsTaint.addTaint(object.dsTaint);
        setFField(object, declaringClass, type, slot, flag, TYPE_FLOAT, value);
        // ---------- Original Method ----------
        //setFField(object, declaringClass, type, slot, flag, TYPE_FLOAT, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.878 -0400", hash_original_method = "DA13B1330D08A636280F51E51FF711B2", hash_generated_method = "473D62FDFE15B9DD4117D18981C73024")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setInt(Object object, int value) throws IllegalAccessException,
            IllegalArgumentException {
        dsTaint.addTaint(value);
        dsTaint.addTaint(object.dsTaint);
        setIField(object, declaringClass, type, slot, flag, TYPE_INTEGER, value);
        // ---------- Original Method ----------
        //setIField(object, declaringClass, type, slot, flag, TYPE_INTEGER, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.879 -0400", hash_original_method = "F703AA23CA1EF460C68B245887B2C6B7", hash_generated_method = "C19AE533E7077F2CED9F01ECE354089A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setLong(Object object, long value) throws IllegalAccessException,
            IllegalArgumentException {
        dsTaint.addTaint(value);
        dsTaint.addTaint(object.dsTaint);
        setJField(object, declaringClass, type, slot, flag, TYPE_LONG, value);
        // ---------- Original Method ----------
        //setJField(object, declaringClass, type, slot, flag, TYPE_LONG, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.879 -0400", hash_original_method = "DEE843BD220F8992FC80A23844FC7C06", hash_generated_method = "9C1425ECABB20B7C93B6142BF6794D3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setShort(Object object, short value) throws IllegalAccessException,
            IllegalArgumentException {
        dsTaint.addTaint(value);
        dsTaint.addTaint(object.dsTaint);
        setSField(object, declaringClass, type, slot, flag, TYPE_SHORT, value);
        // ---------- Original Method ----------
        //setSField(object, declaringClass, type, slot, flag, TYPE_SHORT, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.879 -0400", hash_original_method = "2B14553F8A926216EE23C791DBC737FD", hash_generated_method = "A86C65F9CFB7DC1DE03B6363983915DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder result;
        result = new StringBuilder(Modifier.toString(getModifiers()));
        {
            boolean varFD23457D7925EE9ADC9C1D678FE17210_1552851905 = (result.length() != 0);
            {
                result.append(' ');
            } //End block
        } //End collapsed parenthetic
        appendArrayType(result, type);
        result.append(' ');
        result.append(declaringClass.getName());
        result.append('.');
        result.append(name);
        String varEA70154FDA28CC59402440C6317B57EF_144386466 = (result.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.879 -0400", hash_original_method = "2E771D0497C584665EAFE5039BCB9B58", hash_generated_method = "162A0F11B121D3FC911B762EE47B614C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object getField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck) throws IllegalAccessException {
        dsTaint.addTaint(noAccessCheck);
        dsTaint.addTaint(declaringClass.dsTaint);
        dsTaint.addTaint(o.dsTaint);
        dsTaint.addTaint(slot);
        dsTaint.addTaint(type.dsTaint);
        return (Object)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.879 -0400", hash_original_method = "E4CBB65FF20F2B42AAAA5852C9FC84C9", hash_generated_method = "29EFAF1ABBF4A22CA0AE46CCD0B7F837")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private double getDField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        dsTaint.addTaint(noAccessCheck);
        dsTaint.addTaint(declaringClass.dsTaint);
        dsTaint.addTaint(descriptor);
        dsTaint.addTaint(o.dsTaint);
        dsTaint.addTaint(slot);
        dsTaint.addTaint(type.dsTaint);
        return dsTaint.getTaintDouble();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.880 -0400", hash_original_method = "9B86AA05444EF83A8159E0D0E3B46582", hash_generated_method = "799ADF5435DFA6A9F1BCE807911DDD36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getIField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        dsTaint.addTaint(noAccessCheck);
        dsTaint.addTaint(declaringClass.dsTaint);
        dsTaint.addTaint(descriptor);
        dsTaint.addTaint(o.dsTaint);
        dsTaint.addTaint(slot);
        dsTaint.addTaint(type.dsTaint);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.880 -0400", hash_original_method = "1F116F930DBB16C5DB58ABA31954B7AA", hash_generated_method = "807FFABC6440CF68593CEF419DB2D41E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private long getJField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        dsTaint.addTaint(noAccessCheck);
        dsTaint.addTaint(declaringClass.dsTaint);
        dsTaint.addTaint(descriptor);
        dsTaint.addTaint(o.dsTaint);
        dsTaint.addTaint(slot);
        dsTaint.addTaint(type.dsTaint);
        return dsTaint.getTaintLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.880 -0400", hash_original_method = "50BE3A9E4BA3ACB6450AF3382B17C97D", hash_generated_method = "BC1DD0C0F95EB2EFA8F93A4B7554C4F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean getZField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        dsTaint.addTaint(noAccessCheck);
        dsTaint.addTaint(declaringClass.dsTaint);
        dsTaint.addTaint(descriptor);
        dsTaint.addTaint(o.dsTaint);
        dsTaint.addTaint(slot);
        dsTaint.addTaint(type.dsTaint);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.880 -0400", hash_original_method = "94E059571B5D65D86B6231E7D36BF7FA", hash_generated_method = "D00290C332B9069A4D645EEF3ECB4CBA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private float getFField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        dsTaint.addTaint(noAccessCheck);
        dsTaint.addTaint(declaringClass.dsTaint);
        dsTaint.addTaint(descriptor);
        dsTaint.addTaint(o.dsTaint);
        dsTaint.addTaint(slot);
        dsTaint.addTaint(type.dsTaint);
        return dsTaint.getTaintFloat();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.880 -0400", hash_original_method = "9A55E198BD753BB34F159FBC2807D96E", hash_generated_method = "4F2B4B0ABA84E0C13D6E9AB50823227A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private char getCField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        dsTaint.addTaint(noAccessCheck);
        dsTaint.addTaint(declaringClass.dsTaint);
        dsTaint.addTaint(descriptor);
        dsTaint.addTaint(o.dsTaint);
        dsTaint.addTaint(slot);
        dsTaint.addTaint(type.dsTaint);
        return dsTaint.getTaintChar();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.880 -0400", hash_original_method = "9FE268B454DA8902066BFF2BFC132935", hash_generated_method = "46DDC3DC4D256402CA0E154DE1F1F1E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private short getSField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        dsTaint.addTaint(noAccessCheck);
        dsTaint.addTaint(declaringClass.dsTaint);
        dsTaint.addTaint(descriptor);
        dsTaint.addTaint(o.dsTaint);
        dsTaint.addTaint(slot);
        dsTaint.addTaint(type.dsTaint);
        return dsTaint.getTaintShort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.881 -0400", hash_original_method = "B020FC56F3182544B11E7C259C9C5B21", hash_generated_method = "04F891AC6FA8D84D9017D182FC417030")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private byte getBField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor) throws IllegalAccessException {
        dsTaint.addTaint(noAccessCheck);
        dsTaint.addTaint(declaringClass.dsTaint);
        dsTaint.addTaint(descriptor);
        dsTaint.addTaint(o.dsTaint);
        dsTaint.addTaint(slot);
        dsTaint.addTaint(type.dsTaint);
        return dsTaint.getTaintByte();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.881 -0400", hash_original_method = "D9AA799947323C8F653B1139DF380855", hash_generated_method = "4BD15B8792591FDBB160D352EB4E3A5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, Object value) throws IllegalAccessException {
        dsTaint.addTaint(noAccessCheck);
        dsTaint.addTaint(declaringClass.dsTaint);
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(o.dsTaint);
        dsTaint.addTaint(slot);
        dsTaint.addTaint(type.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.881 -0400", hash_original_method = "3CCE00B68111CAA3AA20979F21B904D8", hash_generated_method = "CA650A31DC5B91BD6E1A2DA4D3C27221")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setDField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, double v) throws IllegalAccessException {
        dsTaint.addTaint(noAccessCheck);
        dsTaint.addTaint(v);
        dsTaint.addTaint(declaringClass.dsTaint);
        dsTaint.addTaint(descriptor);
        dsTaint.addTaint(o.dsTaint);
        dsTaint.addTaint(slot);
        dsTaint.addTaint(type.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.881 -0400", hash_original_method = "32CBAB454E52D8BFC71D6AB87E7BF1FE", hash_generated_method = "0F4AF1D674CFCD43230367BB0D4434F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setIField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, int i) throws IllegalAccessException {
        dsTaint.addTaint(noAccessCheck);
        dsTaint.addTaint(declaringClass.dsTaint);
        dsTaint.addTaint(descriptor);
        dsTaint.addTaint(o.dsTaint);
        dsTaint.addTaint(slot);
        dsTaint.addTaint(type.dsTaint);
        dsTaint.addTaint(i);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.881 -0400", hash_original_method = "7CE46D8AB646DF2CA9A88ACDCE998029", hash_generated_method = "0F74ABB81E5EBD82DED8BE057CB28946")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setJField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, long j) throws IllegalAccessException {
        dsTaint.addTaint(noAccessCheck);
        dsTaint.addTaint(declaringClass.dsTaint);
        dsTaint.addTaint(descriptor);
        dsTaint.addTaint(o.dsTaint);
        dsTaint.addTaint(j);
        dsTaint.addTaint(slot);
        dsTaint.addTaint(type.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.881 -0400", hash_original_method = "E80188BF0543922F0F2BDA0A103D17F5", hash_generated_method = "E4D4465920EB2AD3452C2B677E39A196")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setZField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, boolean z) throws IllegalAccessException {
        dsTaint.addTaint(noAccessCheck);
        dsTaint.addTaint(declaringClass.dsTaint);
        dsTaint.addTaint(descriptor);
        dsTaint.addTaint(o.dsTaint);
        dsTaint.addTaint(slot);
        dsTaint.addTaint(type.dsTaint);
        dsTaint.addTaint(z);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.882 -0400", hash_original_method = "570BC71D32CB4741615EF7701079ED2D", hash_generated_method = "E2059D26CC71A5F23A8D352AEF475257")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setFField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, float f) throws IllegalAccessException {
        dsTaint.addTaint(f);
        dsTaint.addTaint(noAccessCheck);
        dsTaint.addTaint(declaringClass.dsTaint);
        dsTaint.addTaint(descriptor);
        dsTaint.addTaint(o.dsTaint);
        dsTaint.addTaint(slot);
        dsTaint.addTaint(type.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.889 -0400", hash_original_method = "ACD0A6EABB934CC5EEECCAB72AA01730", hash_generated_method = "70A8E90B2BBEA0A7E0A4A5908570AF87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setCField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, char c) throws IllegalAccessException {
        dsTaint.addTaint(noAccessCheck);
        dsTaint.addTaint(declaringClass.dsTaint);
        dsTaint.addTaint(c);
        dsTaint.addTaint(descriptor);
        dsTaint.addTaint(o.dsTaint);
        dsTaint.addTaint(slot);
        dsTaint.addTaint(type.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.890 -0400", hash_original_method = "2A0F6C37A6B68BD24BAC15A31879F06F", hash_generated_method = "7A5F14B93055BBFDB04DA2235592A212")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setSField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, short s) throws IllegalAccessException {
        dsTaint.addTaint(noAccessCheck);
        dsTaint.addTaint(s);
        dsTaint.addTaint(declaringClass.dsTaint);
        dsTaint.addTaint(descriptor);
        dsTaint.addTaint(o.dsTaint);
        dsTaint.addTaint(slot);
        dsTaint.addTaint(type.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.890 -0400", hash_original_method = "4D8B3646C0E699793861ED8487ADC739", hash_generated_method = "C6A1D758429405EB97702487D9C84949")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setBField(Object o, Class<?> declaringClass, Class<?> type, int slot,
            boolean noAccessCheck, char descriptor, byte b) throws IllegalAccessException {
        dsTaint.addTaint(noAccessCheck);
        dsTaint.addTaint(b);
        dsTaint.addTaint(declaringClass.dsTaint);
        dsTaint.addTaint(descriptor);
        dsTaint.addTaint(o.dsTaint);
        dsTaint.addTaint(slot);
        dsTaint.addTaint(type.dsTaint);
    }

    
    public static final Comparator<Field> ORDER_BY_NAME_AND_DECLARING_CLASS = new Comparator<Field>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.890 -0400", hash_original_method = "5733993CE756EF2C84207962A0640F37", hash_generated_method = "C263CDC324A894791F3272F4F670D0CE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int compare(Field a, Field b) {
            dsTaint.addTaint(b.dsTaint);
            dsTaint.addTaint(a.dsTaint);
            int comparison;
            comparison = a.name.compareTo(b.name);
            int var66A8D12774D081FD738A277749969762_719686308 = (a.getDeclaringClass().getName().compareTo(b.getDeclaringClass().getName()));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int comparison = a.name.compareTo(b.name);
            //if (comparison != 0) {
                //return comparison;
            //}
            //return a.getDeclaringClass().getName().compareTo(b.getDeclaringClass().getName());
        }

        
}; //Transformed anonymous class
    private static final char TYPE_BOOLEAN = 'Z';
    private static final char TYPE_BYTE = 'B';
    private static final char TYPE_CHAR = 'C';
    private static final char TYPE_SHORT = 'S';
    private static final char TYPE_INTEGER = 'I';
    private static final char TYPE_FLOAT = 'F';
    private static final char TYPE_LONG = 'J';
    private static final char TYPE_DOUBLE = 'D';
}

