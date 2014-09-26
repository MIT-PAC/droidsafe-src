package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class ClipDescription implements Parcelable {

    /**
     * Helper to compare two MIME types, where one may be a pattern.
     * @param concreteType A fully-specified MIME type.
     * @param desiredType A desired MIME type that may be a pattern such as *\/*.
     * @return Returns true if the two MIME types match.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.190 -0500", hash_original_method = "D4A0CDCFA2584BBC2247DBCF532082CA", hash_generated_method = "4980F5671337308B811DE589FFF6DD54")
    
public static boolean compareMimeTypes(String concreteType, String desiredType) {
        final int typeLength = desiredType.length();
        if (typeLength == 3 && desiredType.equals("*/*")) {
            return true;
        }

        final int slashpos = desiredType.indexOf('/');
        if (slashpos > 0) {
            if (typeLength == slashpos+2 && desiredType.charAt(slashpos+1) == '*') {
                if (desiredType.regionMatches(0, concreteType, 0, slashpos+1)) {
                    return true;
                }
            } else if (desiredType.equals(concreteType)) {
                return true;
            }
        }

        return false;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.173 -0500", hash_original_field = "F0FD85A6A263EC6B3202FB67B9E691C8", hash_generated_field = "0280346FADEE4FC6A00ED7FC060F7D11")

    public static final String MIMETYPE_TEXT_PLAIN = "text/plain";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.175 -0500", hash_original_field = "47257536086AB361C2B684A577047247", hash_generated_field = "9EDF462464DC7CDE9C0F955DDDA0B280")

    public static final String MIMETYPE_TEXT_URILIST = "text/uri-list";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.178 -0500", hash_original_field = "913F8908D33271FF39173EAFEABCB6C1", hash_generated_field = "9937E31EA61FC826C35F356444BF63A7")

    public static final String MIMETYPE_TEXT_INTENT = "text/vnd.android.intent";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.601 -0400", hash_original_field = "EE46FC7A8710E19EB643FEE455FA4E3F", hash_generated_field = "FAFA5E398B2BAE20941CFC963489A38D")

    public static final Parcelable.Creator<ClipDescription> CREATOR =
        new Parcelable.Creator<ClipDescription>() {

            @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.213 -0500", hash_original_method = "85E642226A89613A0CF91353EFBEB228", hash_generated_method = "727085DD534D5DB4FF214F8174187B0E")
        
public ClipDescription createFromParcel(Parcel source) {
                return new ClipDescription(source);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.215 -0500", hash_original_method = "AC410D16DBC5B2C89980F31171589F7A", hash_generated_method = "6066C9E18D33991A511B0F36BBEE8728")
        
public ClipDescription[] newArray(int size) {
                return new ClipDescription[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.180 -0500", hash_original_field = "3688992A2E5C86A7BA94DE38FB1043D1", hash_generated_field = "3688992A2E5C86A7BA94DE38FB1043D1")

     CharSequence mLabel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.182 -0500", hash_original_field = "97CE940966C9ECB62D16CE8136A149A4", hash_generated_field = "97CE940966C9ECB62D16CE8136A149A4")

     String[] mMimeTypes;

    /**
     * Create a new clip.
     *
     * @param label Label to show to the user describing this clip.
     * @param mimeTypes An array of MIME types this data is available as.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.184 -0500", hash_original_method = "6E07A97519B37D56809D89D2D092EC92", hash_generated_method = "4C4366288DEF345A91E542571D2139C1")
    
public ClipDescription(CharSequence label, String[] mimeTypes) {
        if (mimeTypes == null) {
            throw new NullPointerException("mimeTypes is null");
        }
        mLabel = label;
        mMimeTypes = mimeTypes;
    }

    /**
     * Create a copy of a ClipDescription.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.187 -0500", hash_original_method = "A0387A443FBD0EC599BEE38B5BCEEEFE", hash_generated_method = "5C2161AC971639E52DE7C8DCE4B7E498")
    
public ClipDescription(ClipDescription o) {
        mLabel = o.mLabel;
        mMimeTypes = o.mMimeTypes;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.210 -0500", hash_original_method = "2082AA3F6A7022812C6D8548A4E1BDA1", hash_generated_method = "2082AA3F6A7022812C6D8548A4E1BDA1")
    
ClipDescription(Parcel in) {
        mLabel = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
        mMimeTypes = in.createStringArray();
    }

    /**
     * Return the label for this clip.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.192 -0500", hash_original_method = "4A1E1E1996A16BAAC783C4D4608DA412", hash_generated_method = "BF2D8CE2895BA065BC033E2D2EA0072E")
    
public CharSequence getLabel() {
        return mLabel;
    }

    /**
     * Check whether the clip description contains the given MIME type.
     *
     * @param mimeType The desired MIME type.  May be a pattern.
     * @return Returns true if one of the MIME types in the clip description
     * matches the desired MIME type, else false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.194 -0500", hash_original_method = "C012E24E08CF652349C6D573E660029C", hash_generated_method = "8DF0AA288D0153FB277CC9AFFA6D62D9")
    
public boolean hasMimeType(String mimeType) {
        for (int i=0; i<mMimeTypes.length; i++) {
            if (compareMimeTypes(mMimeTypes[i], mimeType)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Filter the clip description MIME types by the given MIME type.  Returns
     * all MIME types in the clip that match the given MIME type.
     *
     * @param mimeType The desired MIME type.  May be a pattern.
     * @return Returns an array of all matching MIME types.  If there are no
     * matching MIME types, null is returned.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.196 -0500", hash_original_method = "184F6EBE579A57B9FFCBCC2BBB07DD57", hash_generated_method = "6BFEB59CA3578424BEA44BFF5CA3D61D")
    
public String[] filterMimeTypes(String mimeType) {
        ArrayList<String> array = null;
        for (int i=0; i<mMimeTypes.length; i++) {
            if (compareMimeTypes(mMimeTypes[i], mimeType)) {
                if (array == null) {
                    array = new ArrayList<String>();
                }
                array.add(mMimeTypes[i]);
            }
        }
        if (array == null) {
            return null;
        }
        String[] rawArray = new String[array.size()];
        array.toArray(rawArray);
        return rawArray;
    }

    /**
     * Return the number of MIME types the clip is available in.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.198 -0500", hash_original_method = "B31C73D49DA2B2DFF06E53A9680B864B", hash_generated_method = "7647028CBCA068544A0E30BFAF13D352")
    
public int getMimeTypeCount() {
        return mMimeTypes.length;
    }

    /**
     * Return one of the possible clip MIME types.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.201 -0500", hash_original_method = "764DD8C2717756748E8339CB8965B38B", hash_generated_method = "8A577E5623639225128CB346AD7975B8")
    
public String getMimeType(int index) {
        return mMimeTypes[index];
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.203 -0500", hash_original_method = "EB798FB270DF414D0A3DC9E08213FD60", hash_generated_method = "38EDA6817F1AF221CF63507E520ECE55")
    
public void validate() {
        if (mMimeTypes == null) {
            throw new NullPointerException("null mime types");
        }
        if (mMimeTypes.length <= 0) {
            throw new IllegalArgumentException("must have at least 1 mime type");
        }
        for (int i=0; i<mMimeTypes.length; i++) {
            if (mMimeTypes[i] == null) {
                throw new NullPointerException("mime type at " + i + " is null");
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.205 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:39.208 -0500", hash_original_method = "B91E92C4C4B5B9EF26722F0E8D4A5B80", hash_generated_method = "25810F0526BB75DA5FFC2F84BC3E4C45")
    
@Override
    public void writeToParcel(Parcel dest, int flags) {
        TextUtils.writeToParcel(mLabel, dest, flags);
        dest.writeStringArray(mMimeTypes);
    }
    // orphaned legacy method
    public ClipDescription createFromParcel(Parcel source) {
                return new ClipDescription(source);
            }
    
    // orphaned legacy method
    public ClipDescription[] newArray(int size) {
                return new ClipDescription[size];
            }
    
}

