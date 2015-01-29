package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;

public final class StackTraceElement implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:20.863 -0500", hash_original_field = "68BFF6955FDB892FD8456F4D83C847D1", hash_generated_field = "26C66B155644317B8367FDF23AF4DB9B")

    private static final long serialVersionUID = 6992337162326171013L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:20.866 -0500", hash_original_field = "3387D12AD9C393627295CAC355C106AA", hash_generated_field = "044B734A1D0D1997F7880A1DDED8AFF6")

    private static final int NATIVE_LINE_NUMBER = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:20.868 -0500", hash_original_field = "EDEEDC9CF5DB299DE0AADD712B8BE51C", hash_generated_field = "EDEEDC9CF5DB299DE0AADD712B8BE51C")

    String declaringClass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:20.870 -0500", hash_original_field = "1E5D18395D934B5D254686548A645BA9", hash_generated_field = "1E5D18395D934B5D254686548A645BA9")

    String methodName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:20.873 -0500", hash_original_field = "90A7C14E9FDE747EFC2F1C95E470FF1A", hash_generated_field = "90A7C14E9FDE747EFC2F1C95E470FF1A")

    String fileName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:20.875 -0500", hash_original_field = "330B2760AA91CE77EFBAED3976D7655C", hash_generated_field = "330B2760AA91CE77EFBAED3976D7655C")

    int lineNumber;

    /**
     * Constructs a new {@code StackTraceElement} for a specified execution
     * point.
     *
     * @param cls
     *            the fully qualified name of the class where execution is at.
     * @param method
     *            the name of the method where execution is at.
     * @param file
     *            The name of the file where execution is at or {@code null}.
     * @param line
     *            the line of the file where execution is at, a negative number
     *            if unknown or {@code -2} if the execution is in a native
     *            method.
     * @throws NullPointerException
     *             if {@code cls} or {@code method} is {@code null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:20.878 -0500", hash_original_method = "DB2419D651C8F74CAA343D4DD61F23E8", hash_generated_method = "615FA1AFA3F4B97E7D05F8DBB57833F3")
    
public StackTraceElement(String cls, String method, String file, int line) {
        if (cls == null || method == null) {
            throw new NullPointerException();
        }
        declaringClass = cls;
        methodName = method;
        fileName = file;
        lineNumber = line;
    }
    
    @DSSafe(DSCat.SAFE_LIST) 
    @DSComment("From safe class list")
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:46.462 -0400", hash_original_method = "DC3E276578F22895683C0979CF7614B3", hash_generated_method = "069C2D8BCA6C8CA3D907F0C7C60A9CFB")
	public  StackTraceElement() {
        // ---------- Original Method ----------
    }

    /**
     * Compares this instance with the specified object and indicates if they
     * are equal. In order to be equal, the following conditions must be
     * fulfilled:
     * <ul>
     * <li>{@code obj} must be a stack trace element,</li>
     * <li>the method names of this stack trace element and of {@code obj} must
     * not be {@code null},</li>
     * <li>the class, method and file names as well as the line number of this
     * stack trace element and of {@code obj} must be equal.</li>
     * </ul>
     *
     * @param obj
     *            the object to compare this instance with.
     * @return {@code true} if the specified object is equal to this
     *         {@code StackTraceElement}; {@code false} otherwise.
     * @see #hashCode
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:20.885 -0500", hash_original_method = "7AAA9568018A0DD8A42BBFC0DF2D8ABE", hash_generated_method = "646E4E325280E4AC3712BC83C69CC404")
    
@Override
    public boolean equals(Object obj) {
        if (!(obj instanceof StackTraceElement)) {
            return false;
        }
        StackTraceElement castObj = (StackTraceElement) obj;

        /*
         * Unknown methods are never equal to anything (not strictly to spec,
         * but spec does not allow null method/class names)
         */
        if ((methodName == null) || (castObj.methodName == null)) {
            return false;
        }

        if (!getMethodName().equals(castObj.getMethodName())) {
            return false;
        }
        if (!getClassName().equals(castObj.getClassName())) {
            return false;
        }
        String localFileName = getFileName();
        if (localFileName == null) {
            if (castObj.getFileName() != null) {
                return false;
            }
        } else {
            if (!localFileName.equals(castObj.getFileName())) {
                return false;
            }
        }
        if (getLineNumber() != castObj.getLineNumber()) {
            return false;
        }

        return true;
    }

    /**
     * Returns the fully qualified name of the class belonging to this
     * {@code StackTraceElement}.
     *
     * @return the fully qualified type name of the class
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:20.887 -0500", hash_original_method = "BE14A042BD1289020FF0D183A63A0F88", hash_generated_method = "515F10678B5E0C1375183D39EA13494A")
    
public String getClassName() {
        return (declaringClass == null) ? "<unknown class>" : declaringClass;
    }

    /**
     * Returns the name of the Java source file containing class belonging to
     * this {@code StackTraceElement}.
     *
     * @return the name of the file, or {@code null} if this information is not
     *         available.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:20.890 -0500", hash_original_method = "0038085273B4122A69DA20E0B00D2EF2", hash_generated_method = "4A6B215A61D7F266A13F22833A21DA8B")
    
public String getFileName() {
        return fileName;
    }

    /**
     * Returns the line number in the source for the class belonging to this
     * {@code StackTraceElement}.
     *
     * @return the line number, or a negative number if this information is not
     *         available.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:20.892 -0500", hash_original_method = "0B737233CC5342C14C595BEE1A87604B", hash_generated_method = "CF4B4A3CBEDDB2EC6C0EA97DADAE4C2D")
    
public int getLineNumber() {
        return lineNumber;
    }

    /**
     * Returns the name of the method belonging to this {@code
     * StackTraceElement}.
     *
     * @return the name of the method, or "<unknown method>" if this information
     *         is not available.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:20.895 -0500", hash_original_method = "B15DF5174FD0E5C814CD72B1EE2ECDA2", hash_generated_method = "D7274D8666EBE92A154778213D7C33F4")
    
public String getMethodName() {
        return (methodName == null) ? "<unknown method>" : methodName;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:20.897 -0500", hash_original_method = "4C3BE92C911A1E7C2FB757777265DE77", hash_generated_method = "1AB62DF0280440DAA5E83C1F594822E3")
    
@Override
    public int hashCode() {
        /*
         * Either both methodName and declaringClass are null, or neither are
         * null.
         */
        if (methodName == null) {
            // all unknown methods hash the same
            return 0;
        }
        // declaringClass never null if methodName is non-null
        return methodName.hashCode() ^ declaringClass.hashCode();
    }

    /**
     * Indicates if the method name returned by {@link #getMethodName()} is
     * implemented as a native method.
     *
     * @return {@code true} if the method in which this stack trace element is
     *         executing is a native method; {@code false} otherwise.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:20.900 -0500", hash_original_method = "9234CE459C30A5F4896C026CB51E3A9C", hash_generated_method = "AF9C5ABF854DFC57A5D4E6FB50B0F17A")
    
public boolean isNativeMethod() {
        return ((lineNumber + NATIVE_LINE_NUMBER) == 1);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:20.903 -0500", hash_original_method = "6555BB21F7D49ABF8ADE43CA311A7DFA", hash_generated_method = "CDFE8E2F9ED097F72933396ED7533C74")
    
@Override
    public String toString() {
        StringBuilder buf = new StringBuilder(80);

        buf.append(getClassName());
        buf.append('.');
        buf.append(getMethodName());

        if (isNativeMethod()) {
            buf.append("(Native Method)");
        } else {
            String fName = getFileName();

            if (fName == null) {
                buf.append("(Unknown Source)");
            } else {
                int lineNum = getLineNumber();

                buf.append('(');
                buf.append(fName);
                if (lineNum >= 0) {
                    buf.append(':');
                    buf.append(lineNum);
                }
                buf.append(')');
            }
        }
        return buf.toString();
    }
}

