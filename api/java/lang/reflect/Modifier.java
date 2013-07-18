package java.lang.reflect;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class Modifier {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.139 -0400", hash_original_method = "E43AF8EB2B9E0BF3650B46095E57E1B5", hash_generated_method = "5DB3FAFCCB5E5D8BE953CABAA657E0F9")
    public  Modifier() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public static int classModifiers() {
        return PUBLIC | PROTECTED | PRIVATE | ABSTRACT | STATIC | FINAL | STRICT;
    }

    
    @DSModeled(DSC.SAFE)
    public static int constructorModifiers() {
        return PUBLIC | PROTECTED | PRIVATE;
    }

    
    @DSModeled(DSC.SAFE)
    public static int fieldModifiers() {
        return PUBLIC | PROTECTED | PRIVATE | STATIC | FINAL | TRANSIENT | VOLATILE;
    }

    
    @DSModeled(DSC.SAFE)
    public static int interfaceModifiers() {
        return PUBLIC | PROTECTED | PRIVATE | ABSTRACT | STATIC | STRICT;
    }

    
    @DSModeled(DSC.SAFE)
    public static int methodModifiers() {
        return PUBLIC | PROTECTED | PRIVATE | ABSTRACT | STATIC | FINAL | SYNCHRONIZED | NATIVE | STRICT;
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isAbstract(int modifiers) {
        return ((modifiers & ABSTRACT) != 0);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isFinal(int modifiers) {
        return ((modifiers & FINAL) != 0);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isInterface(int modifiers) {
        return ((modifiers & INTERFACE) != 0);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isNative(int modifiers) {
        return ((modifiers & NATIVE) != 0);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isPrivate(int modifiers) {
        return ((modifiers & PRIVATE) != 0);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isProtected(int modifiers) {
        return ((modifiers & PROTECTED) != 0);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isPublic(int modifiers) {
        return ((modifiers & PUBLIC) != 0);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isStatic(int modifiers) {
        return ((modifiers & STATIC) != 0);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isStrict(int modifiers) {
        return ((modifiers & STRICT) != 0);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isSynchronized(int modifiers) {
        return ((modifiers & SYNCHRONIZED) != 0);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isTransient(int modifiers) {
        return ((modifiers & TRANSIENT) != 0);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isVolatile(int modifiers) {
        return ((modifiers & VOLATILE) != 0);
    }

    
    public static java.lang.String toString(int modifiers) {
        StringBuilder buf = new StringBuilder();
        if (isPublic(modifiers)) {
            buf.append("public ");
        }
        if (isProtected(modifiers)) {
            buf.append("protected ");
        }
        if (isPrivate(modifiers)) {
            buf.append("private ");
        }
        if (isAbstract(modifiers)) {
            buf.append("abstract ");
        }
        if (isStatic(modifiers)) {
            buf.append("static ");
        }
        if (isFinal(modifiers)) {
            buf.append("final ");
        }
        if (isTransient(modifiers)) {
            buf.append("transient ");
        }
        if (isVolatile(modifiers)) {
            buf.append("volatile ");
        }
        if (isSynchronized(modifiers)) {
            buf.append("synchronized ");
        }
        if (isNative(modifiers)) {
            buf.append("native ");
        }
        if (isStrict(modifiers)) {
            buf.append("strictfp ");
        }
        if (isInterface(modifiers)) {
            buf.append("interface ");
        }
        if (buf.length() == 0) {
            return "";
        }
        buf.setLength(buf.length() - 1);
        return buf.toString();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.143 -0400", hash_original_field = "BED3AD36020DFC957BC2F21FBAAB9F45", hash_generated_field = "4E113119E95225010757D80E6712B6AF")

    public static final int PUBLIC = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.143 -0400", hash_original_field = "C061FAEF73F4F642844CE0FAEBC4513E", hash_generated_field = "3FB12B7F650E2C8217C3C961A0CC4708")

    public static final int PRIVATE = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.143 -0400", hash_original_field = "6682D8A6CFE992F47E0FF9CFF4FF04DA", hash_generated_field = "F883B39C82B5CE479BCFC431FF6580EA")

    public static final int PROTECTED = 0x4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.143 -0400", hash_original_field = "384727F960460065A81B5167B54E6DEA", hash_generated_field = "7C54A1759B1B118FBD9534DED08E0232")

    public static final int STATIC = 0x8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.143 -0400", hash_original_field = "DEACD48B8A8D29E55403CB37734384A2", hash_generated_field = "4130814883E587EF948CBF3F5B1A0D5F")

    public static final int FINAL = 0x10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.144 -0400", hash_original_field = "6703209CE93B6522F48C4F82E1C3C5CD", hash_generated_field = "C002D7F6BE91545B3ADDD289A4B580A6")

    public static final int SYNCHRONIZED = 0x20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.144 -0400", hash_original_field = "484591D9BBF59FF07243DF155983AEA9", hash_generated_field = "2D3E3BDF8D69CC8F32E16218F6CB2591")

    public static final int VOLATILE = 0x40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.144 -0400", hash_original_field = "713057DA0EBFBFCA1D3827C769DC25BB", hash_generated_field = "A566A44B499800E310E5871EDAFD61C4")

    public static final int TRANSIENT = 0x80;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.144 -0400", hash_original_field = "FED40E09ADEEDA210D8C9423F34AF572", hash_generated_field = "9003BF3387ED11A1151FFE2D4F2389A3")

    public static final int NATIVE = 0x100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.144 -0400", hash_original_field = "9A6BF5B9089C5389C978E07FBE170981", hash_generated_field = "DB1EB3828A926E56B96E77FCB680C947")

    public static final int INTERFACE = 0x200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.144 -0400", hash_original_field = "7BC111CB72A9AB99C089AB09AC8EC3E7", hash_generated_field = "569F06DF1E8C8BD44740957D205789AE")

    public static final int ABSTRACT = 0x400;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.144 -0400", hash_original_field = "65A1AD456CD8A912343DE83480919182", hash_generated_field = "54018FE4222A09AC5434054484AAA55A")

    public static final int STRICT = 0x800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.144 -0400", hash_original_field = "BC96106AF9C1B04426B8892917624BA6", hash_generated_field = "7E271FB22FEE4DCDD6ADC0948CE1AF2F")

    static final int BRIDGE = 0x40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.144 -0400", hash_original_field = "2D541EF687F73B1E2DE1986D77BAC51D", hash_generated_field = "6D6FEFEBFBA3A07606D9A0FE2D3164F4")

    static final int VARARGS = 0x80;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.144 -0400", hash_original_field = "31659C22843B02D3DC1970561A2D9172", hash_generated_field = "38828713573E11AB3F4DEBAF0823E500")

    static final int SYNTHETIC = 0x1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.144 -0400", hash_original_field = "EF8DBF8C2A1BE69E3B38D50E25C937E7", hash_generated_field = "20555738D31EC19F3DFAE3E6C8C1F355")

    static final int ANNOTATION = 0x2000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.144 -0400", hash_original_field = "D1A1D40B706A1840938C6422DA065D5B", hash_generated_field = "BB2F637D890B852567DDEF14CF0D700C")

    static final int ENUM = 0x4000;
}

