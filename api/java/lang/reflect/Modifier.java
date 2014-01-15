package java.lang.reflect;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class Modifier {

    /**
     * Returns a mask of all the modifiers that may be applied to classes.
     * @since 1.7
     * @hide 1.7
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.583 -0500", hash_original_method = "9A1D75666406C8990BC1AA416CDF9558", hash_generated_method = "F777E5D4D97E11C071201352C1E45DFB")
    
public static int classModifiers() {
        return PUBLIC | PROTECTED | PRIVATE | ABSTRACT | STATIC | FINAL | STRICT;
    }

    /**
     * Returns a mask of all the modifiers that may be applied to constructors.
     * @since 1.7
     * @hide 1.7
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.585 -0500", hash_original_method = "079A7BE4CCCC6D24274EBBE71E4E293F", hash_generated_method = "C4BC556D8102AA6F2CEA0D7D33598DDD")
    
public static int constructorModifiers() {
        return PUBLIC | PROTECTED | PRIVATE;
    }

    /**
     * Returns a mask of all the modifiers that may be applied to fields.
     * @since 1.7
     * @hide 1.7
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.588 -0500", hash_original_method = "1F172CA874B907B93E2E0AF285D5B96B", hash_generated_method = "BB1B8FA31CDDD250DF4D1FA38CFBDE2B")
    
public static int fieldModifiers() {
        return PUBLIC | PROTECTED | PRIVATE | STATIC | FINAL | TRANSIENT | VOLATILE;
    }

    /**
     * Returns a mask of all the modifiers that may be applied to interfaces.
     * @since 1.7
     * @hide 1.7
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.590 -0500", hash_original_method = "BDF3AD667A71B37AE55F3E2E0F794D61", hash_generated_method = "B0634B256FEDF3B0793C38EB1552F5F9")
    
public static int interfaceModifiers() {
        return PUBLIC | PROTECTED | PRIVATE | ABSTRACT | STATIC | STRICT;
    }

    /**
     * Returns a mask of all the modifiers that may be applied to methods.
     * @since 1.7
     * @hide 1.7
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.593 -0500", hash_original_method = "D6937D25AC81F70361EFC7EFF460134D", hash_generated_method = "8C79D4DC8FD24AF9B584EBCBB601BCB5")
    
public static int methodModifiers() {
        return PUBLIC | PROTECTED | PRIVATE | ABSTRACT | STATIC | FINAL | SYNCHRONIZED | NATIVE | STRICT;
    }

    /**
     * Indicates whether or not the specified modifiers contain the {@code
     * abstract} modifier.
     *
     * @param modifiers
     *            the modifiers to test
     * @return {@code true} if the specified modifiers contain the {@code
     *         abstract} modifier, {@code false} otherwise
     */
    @DSComment("Java language reflection")
    @DSBan(DSCat.REFLECTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.596 -0500", hash_original_method = "4393F5C84F1A6C20484EB804711F0AF9", hash_generated_method = "3CF1C591AE7F3113A85B2A4E0D9D09C9")
    
public static boolean isAbstract(int modifiers) {
        return ((modifiers & ABSTRACT) != 0);
    }

    /**
     * Indicates whether or not the specified modifiers contain the {@code
     * final} modifier.
     *
     * @param modifiers
     *            the modifiers to test
     * @return {@code true} if the specified modifiers contain the {@code
     *         final} modifier, {@code false} otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.598 -0500", hash_original_method = "CBF7AC275E896CAF05907BF83162C1F9", hash_generated_method = "2F28EE34F8D175F67B3F0E2B79741BE8")
    
public static boolean isFinal(int modifiers) {
        return ((modifiers & FINAL) != 0);
    }

    /**
     * Indicates whether or not the specified modifiers contain the {@code
     * interface} modifier.
     *
     * @param modifiers
     *            the modifiers to test
     * @return {@code true} if the specified modifiers contain the {@code
     *         interface} modifier, {@code false} otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.601 -0500", hash_original_method = "6989910559795EB48195A46B3188D519", hash_generated_method = "8B5865805C5F5F9CA6531F51EA172A4C")
    
public static boolean isInterface(int modifiers) {
        return ((modifiers & INTERFACE) != 0);
    }

    /**
     * Indicates whether or not the specified modifiers contain the {@code
     * native} modifier.
     *
     * @param modifiers
     *            the modifiers to test
     * @return {@code true} if the specified modifiers contain the {@code
     *         native} modifier, {@code false} otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.603 -0500", hash_original_method = "DA6BEE0F153DB8F35550AFD9CB07FE76", hash_generated_method = "B21F0FD66FA20515D3A05AAD7CB0A45C")
    
public static boolean isNative(int modifiers) {
        return ((modifiers & NATIVE) != 0);
    }

    /**
     * Indicates whether or not the specified modifiers contain the {@code
     * private} modifier.
     *
     * @param modifiers
     *            the modifiers to test
     * @return {@code true} if the specified modifiers contain the {@code
     *         private} modifier, {@code false} otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.606 -0500", hash_original_method = "C23CD0C026CEBAE83AF0F37DEB3B9BE7", hash_generated_method = "66C3354DF6123C83C6A6B80B6AFD7803")
    
public static boolean isPrivate(int modifiers) {
        return ((modifiers & PRIVATE) != 0);
    }

    /**
     * Indicates whether or not the specified modifiers contain the {@code
     * protected} modifier.
     *
     * @param modifiers
     *            the modifiers to test
     * @return {@code true} if the specified modifiers contain the {@code
     *         protected} modifier, {@code false} otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.608 -0500", hash_original_method = "34F3755D4F3C080FEB39C242B465057F", hash_generated_method = "4AD66D8FB2A0CB5DE3FB088B823E1A30")
    
public static boolean isProtected(int modifiers) {
        return ((modifiers & PROTECTED) != 0);
    }

    /**
     * Indicates whether or not the specified modifiers contain the {@code
     * public} modifier.
     *
     * @param modifiers
     *            the modifiers to test
     * @return {@code true} if the specified modifiers contain the {@code
     *         public} modifier, {@code false} otherwise
     */
    @DSComment("Java language reflection")
    @DSBan(DSCat.REFLECTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.611 -0500", hash_original_method = "F32A5C6A60F6D3AE4E2798FB3C917182", hash_generated_method = "17A09D042FE469EEA8A7D832BFCD0E80")
    
public static boolean isPublic(int modifiers) {
        return ((modifiers & PUBLIC) != 0);
    }

    /**
     * Indicates whether or not the specified modifiers contain the {@code
     * static} modifier.
     *
     * @param modifiers
     *            the modifiers to test
     * @return {@code true} if the specified modifiers contain the {@code
     *         static} modifier, {@code false} otherwise
     */
    @DSComment("Java language reflection")
    @DSBan(DSCat.REFLECTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.613 -0500", hash_original_method = "F73282A82DE53F4E8602A983F3FBD929", hash_generated_method = "4F839491C85D91B0C9553754D6711D11")
    
public static boolean isStatic(int modifiers) {
        return ((modifiers & STATIC) != 0);
    }

    /**
     * Indicates whether or not the specified modifiers contain the {@code
     * strict} modifier.
     *
     * @param modifiers
     *            the modifiers to test
     * @return {@code true} if the specified modifiers contain the {@code
     *         strict} modifier, {@code false} otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.616 -0500", hash_original_method = "69B63C272419F112013D47037EF5FF0C", hash_generated_method = "DEAEEA89B99839FC0BF1C8CB2C51928A")
    
public static boolean isStrict(int modifiers) {
        return ((modifiers & STRICT) != 0);
    }

    /**
     * Indicates whether or not the specified modifiers contain the {@code
     * synchronized} modifier.
     *
     * @param modifiers
     *            the modifiers to test
     * @return {@code true} if the specified modifiers contain the {@code
     *         synchronized} modifier, {@code false} otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.619 -0500", hash_original_method = "49E2E5B1428F9F4298859885B6785735", hash_generated_method = "4D461F8AB64D65327C584ABB44CC0B52")
    
public static boolean isSynchronized(int modifiers) {
        return ((modifiers & SYNCHRONIZED) != 0);
    }

    /**
     * Indicates whether or not the specified modifiers contain the {@code
     * transient} modifier.
     *
     * @param modifiers
     *            the modifiers to test
     * @return {@code true} if the specified modifiers contain the {@code
     *         transient} modifier, {@code false} otherwise
     */
    @DSComment("Java language reflection")
    @DSBan(DSCat.REFLECTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.621 -0500", hash_original_method = "57209F613683B2F4AD04C6D317C5C05F", hash_generated_method = "43B1846810DDC077F366CAA38168D506")
    
public static boolean isTransient(int modifiers) {
        return ((modifiers & TRANSIENT) != 0);
    }

    /**
     * Indicates whether or not the specified modifiers contain the {@code
     * volatile} modifier.
     *
     * @param modifiers
     *            the modifiers to test
     * @return {@code true} if the specified modifiers contain the {@code
     *         volatile} modifier, {@code false} otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.624 -0500", hash_original_method = "B0E5F2B6D36D4B1865726F3E3779D240", hash_generated_method = "7A46AE2CCC9985861E307F94713AFCE5")
    
public static boolean isVolatile(int modifiers) {
        return ((modifiers & VOLATILE) != 0);
    }

    /**
     * Returns a string containing the string representation of all modifiers
     * present in the specified modifiers. Modifiers appear in the order
     * specified by the Java Language Specification:
     *
     * {@code public private protected abstract static final transient volatile native synchronized interface strict}
     *
     * @param modifiers
     *            the modifiers to print
     * @return a printable representation of the modifiers
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.628 -0500", hash_original_method = "86B8B01EEA81FA63F3947FFBD2326404", hash_generated_method = "E7DBA0DB8CF57DD44BBBDDD71B32A7BA")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.535 -0500", hash_original_field = "57C9C66ECE17B3AA350365878DDB3F8A", hash_generated_field = "4E113119E95225010757D80E6712B6AF")

    public static final int PUBLIC = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.538 -0500", hash_original_field = "005D948A149930A7C8564A58527A2303", hash_generated_field = "3FB12B7F650E2C8217C3C961A0CC4708")

    public static final int PRIVATE = 0x2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.540 -0500", hash_original_field = "1C759BF114DBB3579D6E973771D7CB51", hash_generated_field = "F883B39C82B5CE479BCFC431FF6580EA")

    public static final int PROTECTED = 0x4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.543 -0500", hash_original_field = "F0B88129C4C6116B20D8457E6C107BF9", hash_generated_field = "7C54A1759B1B118FBD9534DED08E0232")

    public static final int STATIC = 0x8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.546 -0500", hash_original_field = "A87113BA933FFA4CCFFE27E4704B399D", hash_generated_field = "4130814883E587EF948CBF3F5B1A0D5F")

    public static final int FINAL = 0x10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.549 -0500", hash_original_field = "79230C389EAB9F86B9EB553B32D281B2", hash_generated_field = "C002D7F6BE91545B3ADDD289A4B580A6")

    public static final int SYNCHRONIZED = 0x20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.551 -0500", hash_original_field = "A96974705DA2C55C82F916841AEC5366", hash_generated_field = "2D3E3BDF8D69CC8F32E16218F6CB2591")

    public static final int VOLATILE = 0x40;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.554 -0500", hash_original_field = "A8173F929954FCEA52C38577996326AF", hash_generated_field = "A566A44B499800E310E5871EDAFD61C4")

    public static final int TRANSIENT = 0x80;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.557 -0500", hash_original_field = "18B8A4D228E64D95FDE0AF3E85B3C614", hash_generated_field = "9003BF3387ED11A1151FFE2D4F2389A3")

    public static final int NATIVE = 0x100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.559 -0500", hash_original_field = "66F94E0287642B4B4BE45FC873B2CBD1", hash_generated_field = "DB1EB3828A926E56B96E77FCB680C947")

    public static final int INTERFACE = 0x200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.562 -0500", hash_original_field = "5B2A1AA513B16AE27D9D62B523A7732D", hash_generated_field = "569F06DF1E8C8BD44740957D205789AE")

    public static final int ABSTRACT = 0x400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.564 -0500", hash_original_field = "38CDFB3C52F2C5FF588C0A0294D22E9E", hash_generated_field = "54018FE4222A09AC5434054484AAA55A")

    public static final int STRICT = 0x800;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.567 -0500", hash_original_field = "716AE60EB86EEE3DFF32D6A83E24DA8A", hash_generated_field = "7E271FB22FEE4DCDD6ADC0948CE1AF2F")

    static final int BRIDGE = 0x40;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.569 -0500", hash_original_field = "9B810AD6F12FF86CC24642D5BDEDE96E", hash_generated_field = "6D6FEFEBFBA3A07606D9A0FE2D3164F4")

    static final int VARARGS = 0x80;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.572 -0500", hash_original_field = "F1FF292D2C8E0F83E85874578AF0CB71", hash_generated_field = "38828713573E11AB3F4DEBAF0823E500")

    static final int SYNTHETIC = 0x1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.575 -0500", hash_original_field = "D76A26FE61302C8C86A0C69E0C2CB435", hash_generated_field = "20555738D31EC19F3DFAE3E6C8C1F355")

    static final int ANNOTATION = 0x2000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.578 -0500", hash_original_field = "0864BD8018E11B4EB27219D562A94ECF", hash_generated_field = "BB2F637D890B852567DDEF14CF0D700C")

    static final int ENUM = 0x4000;

    /**
     * Constructs a new {@code Modifier} instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.580 -0500", hash_original_method = "E43AF8EB2B9E0BF3650B46095E57E1B5", hash_generated_method = "67486C5FCC0D9F62E4BC64BD644C1963")
    
public Modifier() {
    }
}

