package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

public final class ComponentName implements Parcelable, Cloneable, Comparable<ComponentName> {
    
    /**
     * Recover a ComponentName from a String that was previously created with
     * {@link #flattenToString()}.  It splits the string at the first '/',
     * taking the part before as the package name and the part after as the
     * class name.  As a special convenience (to use, for example, when
     * parsing component names on the command line), if the '/' is immediately
     * followed by a '.' then the final class name will be the concatenation
     * of the package name with the string following the '/'.  Thus
     * "com.foo/.Blah" becomes package="com.foo" class="com.foo.Blah".
     * 
     * @param str The String that was returned by flattenToString().
     * @return Returns a new ComponentName containing the package and class
     * names that were encoded in <var>str</var>
     * 
     * @see #flattenToString()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.585 -0500", hash_original_method = "D4E8AB1939E332222FA82C6706402E5E", hash_generated_method = "AC1ABC1EAD9359F8606C0A629E68E2FF")
    
public static ComponentName unflattenFromString(String str) {
        int sep = str.indexOf('/');
        if (sep < 0 || (sep+1) >= str.length()) {
            return null;
        }
        String pkg = str.substring(0, sep);
        String cls = str.substring(sep+1);
        if (cls.length() > 0 && cls.charAt(0) == '.') {
            cls = pkg + cls;
        }
        return new ComponentName(pkg, cls);
    }

    /**
     * Write a ComponentName to a Parcel, handling null pointers.  Must be
     * read with {@link #readFromParcel(Parcel)}.
     * 
     * @param c The ComponentName to be written.
     * @param out The Parcel in which the ComponentName will be placed.
     * 
     * @see #readFromParcel(Parcel)
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.603 -0500", hash_original_method = "9548AC220202FFEF37F66BD7413BDD60", hash_generated_method = "8DD7C14E921C218432A74389513A08DC")
    
public static void writeToParcel(ComponentName c, Parcel out) {
        if (c != null) {
            c.writeToParcel(out, 0);
        } else {
            out.writeString(null);
        }
    }
    
    /**
     * Read a ComponentName from a Parcel that was previously written
     * with {@link #writeToParcel(ComponentName, Parcel)}, returning either
     * a null or new object as appropriate.
     * 
     * @param in The Parcel from which to read the ComponentName
     * @return Returns a new ComponentName matching the previously written
     * object, or null if a null had been written.
     * 
     * @see #writeToParcel(ComponentName, Parcel)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.605 -0500", hash_original_method = "6EAB545510B30AF94F1868FF1E5E1EEA", hash_generated_method = "547AE93556C371FCD245DF3F0C522778")
    
public static ComponentName readFromParcel(Parcel in) {
        String pkg = in.readString();
        return pkg != null ? new ComponentName(pkg, in) : null;
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.681 -0400", hash_original_field = "8E5A903B6B4C2E2ACAA815E1E466E4D8", hash_generated_field = "B1DC8C107C69903EE7EB8EF6D1247DBB")

    public static final Parcelable.Creator<ComponentName> CREATOR
            = new Parcelable.Creator<ComponentName>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.608 -0500", hash_original_method = "B8B6FA6877F2BC7297214F94718448AF", hash_generated_method = "3AD55BA83A24855DAF688CEA2E3B818C")
        
public ComponentName createFromParcel(Parcel in) {
            return new ComponentName(in);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.610 -0500", hash_original_method = "E4EFBA185D141B45B652C08AB65870BB", hash_generated_method = "1813D8C1DC6C990103A164A942F95332")
        
public ComponentName[] newArray(int size) {
            return new ComponentName[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.560 -0500", hash_original_field = "024AAB9E2577CC3DE3304162F102B92C", hash_generated_field = "D6E102019562022F9DE7C9915C7FD917")

    @DSVAModeled
    private  String mPackage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.562 -0500", hash_original_field = "7B9BED5A2E35C35D1D3CD4CF0C575024", hash_generated_field = "5E2CA74CC8E570ED6932C7E63B69D503")

    @DSVAModeled
    private  String mClass;

    /**
     * Create a new component identifier.
     * 
     * @param pkg The name of the package that the component exists in.  Can
     * not be null.
     * @param cls The name of the class inside of <var>pkg</var> that
     * implements the component.  Can not be null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.564 -0500", hash_original_method = "1714B1C8173E376D41E514F902D33E99", hash_generated_method = "1BA84BE4467588AE2A03CD87E288D467")
    
public ComponentName(String pkg, String cls) {
        if (pkg == null) throw new NullPointerException("package name is null");
        if (cls == null) throw new NullPointerException("class name is null");
        mPackage = pkg;
        mClass = cls;
    }

    /**
     * Create a new component identifier from a Context and class name.
     * 
     * @param pkg A Context for the package implementing the component,
     * from which the actual package name will be retrieved.
     * @param cls The name of the class inside of <var>pkg</var> that
     * implements the component.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.567 -0500", hash_original_method = "36F25878FE380B4CEA8E7C4B89DDFC1A", hash_generated_method = "366843CDEB60ED07212DE3CF20310076")
    
public ComponentName(Context pkg, String cls) {
        if (cls == null) throw new NullPointerException("class name is null");
        mPackage = pkg.getPackageName();
        mClass = cls;
    }

    /**
     * Create a new component identifier from a Context and Class object.
     * 
     * @param pkg A Context for the package implementing the component, from
     * which the actual package name will be retrieved.
     * @param cls The Class object of the desired component, from which the
     * actual class name will be retrieved.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.570 -0500", hash_original_method = "8AE00F6D12874A3382D28F364D43BAC6", hash_generated_method = "D7EF4C8D4676CF4464A0EC53BF75F826")
    
public ComponentName(Context pkg, Class<?> cls) {
        mPackage = pkg.getPackageName();
        mClass = cls.getName();
    }

    /**
     * Instantiate a new ComponentName from the data in a Parcel that was
     * previously written with {@link #writeToParcel(Parcel, int)}.  Note that you
     * must not use this with data written by
     * {@link #writeToParcel(ComponentName, Parcel)} since it is not possible
     * to handle a null ComponentObject here.
     * 
     * @param in The Parcel containing the previously written ComponentName,
     * positioned at the location in the buffer where it was written.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.615 -0500", hash_original_method = "85979238AB87BCF4845F6771314A5B1D", hash_generated_method = "ECB047062E247841A22DE82929CCAD76")
    
public ComponentName(Parcel in) {
        mPackage = in.readString();
        if (mPackage == null) throw new NullPointerException(
                "package name is null");
        mClass = in.readString();
        if (mClass == null) throw new NullPointerException(
                "class name is null");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.617 -0500", hash_original_method = "5EFEBE9DDFB777526DBE0E9A79DAA5EE", hash_generated_method = "FD372FFF984FE9C8200778E7FDFB7A0F")
    
private ComponentName(String pkg, Parcel in) {
        mPackage = pkg;
        mClass = in.readString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.572 -0500", hash_original_method = "0C586E8D4837845118D5ECAFE1DD23B0", hash_generated_method = "1E1751FEB922C25B1069279909E78522")
    
public ComponentName clone() {
        return new ComponentName(mPackage, mClass);
    }

    /**
     * Return the package name of this component.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.574 -0500", hash_original_method = "89B4378559F402BEFD7FD434E355C3B4", hash_generated_method = "63FE5FEFF39BF20BDF4A467B3EECCD22")
    
public String getPackageName() {
        return mPackage;
    }
    
    /**
     * Return the class name of this component.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.576 -0500", hash_original_method = "ABD4E1FA4C56F78B933D2E76ACF407D1", hash_generated_method = "7FDE699C4ACD1575C4F6A08F82280495")
    
public String getClassName() {
        return mClass;
    }
    
    /**
     * Return the class name, either fully qualified or in a shortened form
     * (with a leading '.') if it is a suffix of the package.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.578 -0500", hash_original_method = "1928B7DE815A138E651EC762B534B9EC", hash_generated_method = "26B2622A08D890C423EE473583404F0A")
    
public String getShortClassName() {
        if (mClass.startsWith(mPackage)) {
            int PN = mPackage.length();
            int CN = mClass.length();
            if (CN > PN && mClass.charAt(PN) == '.') {
                return mClass.substring(PN, CN);
            }
        }
        return mClass;
    }
    
    /**
     * Return a String that unambiguously describes both the package and
     * class names contained in the ComponentName.  You can later recover
     * the ComponentName from this string through
     * {@link #unflattenFromString(String)}.
     * 
     * @return Returns a new String holding the package and class names.  This
     * is represented as the package name, concatenated with a '/' and then the
     * class name.
     * 
     * @see #unflattenFromString(String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.580 -0500", hash_original_method = "390AD2AD67B7039AADEA1F7D4A32A2A2", hash_generated_method = "4019EF7A1B25ACA97EDCBE9719C78F18")
    
public String flattenToString() {
        return mPackage + "/" + mClass;
    }
    
    /**
     * The same as {@link #flattenToString()}, but abbreviates the class
     * name if it is a suffix of the package.  The result can still be used
     * with {@link #unflattenFromString(String)}.
     * 
     * @return Returns a new String holding the package and class names.  This
     * is represented as the package name, concatenated with a '/' and then the
     * class name.
     * 
     * @see #unflattenFromString(String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.582 -0500", hash_original_method = "CF7AA080F36C0EC07816037C2C3C9C55", hash_generated_method = "F0DF23288E549138FDBC94AFBDDCFECE")
    
public String flattenToShortString() {
        return mPackage + "/" + getShortClassName();
    }
    
    /**
     * Return string representation of this class without the class's name
     * as a prefix.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.587 -0500", hash_original_method = "7CD87B9188FFFCA76A5FF9BDC65CF37F", hash_generated_method = "9D36B23A9DD5456E4D487349E266FDAC")
    
public String toShortString() {
        return "{" + mPackage + "/" + mClass + "}";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.589 -0500", hash_original_method = "54FBA5D02AAB0DA35DA4E57242A769F6", hash_generated_method = "B45A9F5921B47BCB522C8F1942BF77FE")
    
@Override
    public String toString() {
        return "ComponentInfo{" + mPackage + "/" + mClass + "}";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.593 -0500", hash_original_method = "221E549665728B04A91E5C9A58326754", hash_generated_method = "D8F5E18DA105D11037667BE5EBF7E454")
    
@Override
    public boolean equals(Object obj) {
        try {
            if (obj != null) {
                ComponentName other = (ComponentName)obj;
                // Note: no null checks, because mPackage and mClass can
                // never be null.
                return mPackage.equals(other.mPackage)
                        && mClass.equals(other.mClass);
            }
        } catch (ClassCastException e) {
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.595 -0500", hash_original_method = "0BD278EA5D55E08CD4E56E53F182D0C7", hash_generated_method = "34C328E874FC615A2187ED5A2CE1B584")
    
@Override
    public int hashCode() {
        return mPackage.hashCode() + mClass.hashCode();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.597 -0500", hash_original_method = "DB0D439501C0EAB456A0FFDB0A59DF6E", hash_generated_method = "75E7AEFE936AA2B0DB1CC1423936B3E9")
    
public int compareTo(ComponentName that) {
        int v;
        v = this.mPackage.compareTo(that.mPackage);
        if (v != 0) {
            return v;
        }
        return this.mClass.compareTo(that.mClass);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.599 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:07.601 -0500", hash_original_method = "04D15992D5C44ACF00A97C758C27E164", hash_generated_method = "D5ABCC5820C52A2A30E43E14406B7C03")
    
public void writeToParcel(Parcel out, int flags) {
        out.writeString(mPackage);
        out.writeString(mClass);
    }
    // orphaned legacy method
    public ComponentName createFromParcel(Parcel in) {
            return new ComponentName(in);
        }
    
    // orphaned legacy method
    public ComponentName[] newArray(int size) {
            return new ComponentName[size];
        }
    
}

