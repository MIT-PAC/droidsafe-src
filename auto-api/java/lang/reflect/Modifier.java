package java.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class Modifier {
    public static final int PUBLIC = 0x1;
    public static final int PRIVATE = 0x2;
    public static final int PROTECTED = 0x4;
    public static final int STATIC = 0x8;
    public static final int FINAL = 0x10;
    public static final int SYNCHRONIZED = 0x20;
    public static final int VOLATILE = 0x40;
    public static final int TRANSIENT = 0x80;
    public static final int NATIVE = 0x100;
    public static final int INTERFACE = 0x200;
    public static final int ABSTRACT = 0x400;
    public static final int STRICT = 0x800;
    static final int BRIDGE = 0x40;
    static final int VARARGS = 0x80;
    static final int SYNTHETIC = 0x1000;
    static final int ANNOTATION = 0x2000;
    static final int ENUM = 0x4000;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.864 -0400", hash_original_method = "E43AF8EB2B9E0BF3650B46095E57E1B5", hash_generated_method = "0852A22CA8BB0799285A2C3FC4A9F19B")
    @DSModeled(DSC.SAFE)
    public Modifier() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.864 -0400", hash_original_method = "9A1D75666406C8990BC1AA416CDF9558", hash_generated_method = "F777E5D4D97E11C071201352C1E45DFB")
    public static int classModifiers() {
        return PUBLIC | PROTECTED | PRIVATE | ABSTRACT | STATIC | FINAL | STRICT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.864 -0400", hash_original_method = "079A7BE4CCCC6D24274EBBE71E4E293F", hash_generated_method = "C4BC556D8102AA6F2CEA0D7D33598DDD")
    public static int constructorModifiers() {
        return PUBLIC | PROTECTED | PRIVATE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.864 -0400", hash_original_method = "1F172CA874B907B93E2E0AF285D5B96B", hash_generated_method = "BB1B8FA31CDDD250DF4D1FA38CFBDE2B")
    public static int fieldModifiers() {
        return PUBLIC | PROTECTED | PRIVATE | STATIC | FINAL | TRANSIENT | VOLATILE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.864 -0400", hash_original_method = "BDF3AD667A71B37AE55F3E2E0F794D61", hash_generated_method = "B0634B256FEDF3B0793C38EB1552F5F9")
    public static int interfaceModifiers() {
        return PUBLIC | PROTECTED | PRIVATE | ABSTRACT | STATIC | STRICT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.864 -0400", hash_original_method = "D6937D25AC81F70361EFC7EFF460134D", hash_generated_method = "8C79D4DC8FD24AF9B584EBCBB601BCB5")
    public static int methodModifiers() {
        return PUBLIC | PROTECTED | PRIVATE | ABSTRACT | STATIC | FINAL | SYNCHRONIZED | NATIVE | STRICT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.864 -0400", hash_original_method = "4393F5C84F1A6C20484EB804711F0AF9", hash_generated_method = "3CF1C591AE7F3113A85B2A4E0D9D09C9")
    public static boolean isAbstract(int modifiers) {
        return ((modifiers & ABSTRACT) != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.864 -0400", hash_original_method = "CBF7AC275E896CAF05907BF83162C1F9", hash_generated_method = "2F28EE34F8D175F67B3F0E2B79741BE8")
    public static boolean isFinal(int modifiers) {
        return ((modifiers & FINAL) != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.864 -0400", hash_original_method = "6989910559795EB48195A46B3188D519", hash_generated_method = "8B5865805C5F5F9CA6531F51EA172A4C")
    public static boolean isInterface(int modifiers) {
        return ((modifiers & INTERFACE) != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.864 -0400", hash_original_method = "DA6BEE0F153DB8F35550AFD9CB07FE76", hash_generated_method = "B21F0FD66FA20515D3A05AAD7CB0A45C")
    public static boolean isNative(int modifiers) {
        return ((modifiers & NATIVE) != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.865 -0400", hash_original_method = "C23CD0C026CEBAE83AF0F37DEB3B9BE7", hash_generated_method = "66C3354DF6123C83C6A6B80B6AFD7803")
    public static boolean isPrivate(int modifiers) {
        return ((modifiers & PRIVATE) != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.865 -0400", hash_original_method = "34F3755D4F3C080FEB39C242B465057F", hash_generated_method = "4AD66D8FB2A0CB5DE3FB088B823E1A30")
    public static boolean isProtected(int modifiers) {
        return ((modifiers & PROTECTED) != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.865 -0400", hash_original_method = "F32A5C6A60F6D3AE4E2798FB3C917182", hash_generated_method = "17A09D042FE469EEA8A7D832BFCD0E80")
    public static boolean isPublic(int modifiers) {
        return ((modifiers & PUBLIC) != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.865 -0400", hash_original_method = "F73282A82DE53F4E8602A983F3FBD929", hash_generated_method = "4F839491C85D91B0C9553754D6711D11")
    public static boolean isStatic(int modifiers) {
        return ((modifiers & STATIC) != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.865 -0400", hash_original_method = "69B63C272419F112013D47037EF5FF0C", hash_generated_method = "DEAEEA89B99839FC0BF1C8CB2C51928A")
    public static boolean isStrict(int modifiers) {
        return ((modifiers & STRICT) != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.865 -0400", hash_original_method = "49E2E5B1428F9F4298859885B6785735", hash_generated_method = "4D461F8AB64D65327C584ABB44CC0B52")
    public static boolean isSynchronized(int modifiers) {
        return ((modifiers & SYNCHRONIZED) != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.865 -0400", hash_original_method = "57209F613683B2F4AD04C6D317C5C05F", hash_generated_method = "43B1846810DDC077F366CAA38168D506")
    public static boolean isTransient(int modifiers) {
        return ((modifiers & TRANSIENT) != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.865 -0400", hash_original_method = "B0E5F2B6D36D4B1865726F3E3779D240", hash_generated_method = "7A46AE2CCC9985861E307F94713AFCE5")
    public static boolean isVolatile(int modifiers) {
        return ((modifiers & VOLATILE) != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.865 -0400", hash_original_method = "86B8B01EEA81FA63F3947FFBD2326404", hash_generated_method = "E7DBA0DB8CF57DD44BBBDDD71B32A7BA")
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

    
}


