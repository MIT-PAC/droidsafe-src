package java.lang.reflect;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class Modifier {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:26.976 -0400", hash_original_method = "E43AF8EB2B9E0BF3650B46095E57E1B5", hash_generated_method = "5DB3FAFCCB5E5D8BE953CABAA657E0F9")
    @DSModeled(DSC.SAFE)
    public Modifier() {
        // ---------- Original Method ----------
    }

    
        public static int classModifiers() {
        return PUBLIC | PROTECTED | PRIVATE | ABSTRACT | STATIC | FINAL | STRICT;
    }

    
        public static int constructorModifiers() {
        return PUBLIC | PROTECTED | PRIVATE;
    }

    
        public static int fieldModifiers() {
        return PUBLIC | PROTECTED | PRIVATE | STATIC | FINAL | TRANSIENT | VOLATILE;
    }

    
        public static int interfaceModifiers() {
        return PUBLIC | PROTECTED | PRIVATE | ABSTRACT | STATIC | STRICT;
    }

    
        public static int methodModifiers() {
        return PUBLIC | PROTECTED | PRIVATE | ABSTRACT | STATIC | FINAL | SYNCHRONIZED | NATIVE | STRICT;
    }

    
        public static boolean isAbstract(int modifiers) {
        return ((modifiers & ABSTRACT) != 0);
    }

    
        public static boolean isFinal(int modifiers) {
        return ((modifiers & FINAL) != 0);
    }

    
        public static boolean isInterface(int modifiers) {
        return ((modifiers & INTERFACE) != 0);
    }

    
        public static boolean isNative(int modifiers) {
        return ((modifiers & NATIVE) != 0);
    }

    
        public static boolean isPrivate(int modifiers) {
        return ((modifiers & PRIVATE) != 0);
    }

    
        public static boolean isProtected(int modifiers) {
        return ((modifiers & PROTECTED) != 0);
    }

    
        public static boolean isPublic(int modifiers) {
        return ((modifiers & PUBLIC) != 0);
    }

    
        public static boolean isStatic(int modifiers) {
        return ((modifiers & STATIC) != 0);
    }

    
        public static boolean isStrict(int modifiers) {
        return ((modifiers & STRICT) != 0);
    }

    
        public static boolean isSynchronized(int modifiers) {
        return ((modifiers & SYNCHRONIZED) != 0);
    }

    
        public static boolean isTransient(int modifiers) {
        return ((modifiers & TRANSIENT) != 0);
    }

    
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
}

