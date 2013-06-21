package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

public class ClipDescription implements Parcelable {
    CharSequence mLabel;
    String[] mMimeTypes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.047 -0400", hash_original_method = "6E07A97519B37D56809D89D2D092EC92", hash_generated_method = "1D08E752AE067991AEB5B7D0C7A61235")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ClipDescription(CharSequence label, String[] mimeTypes) {
        dsTaint.addTaint(label);
        dsTaint.addTaint(mimeTypes[0]);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("mimeTypes is null");
        } //End block
        // ---------- Original Method ----------
        //if (mimeTypes == null) {
            //throw new NullPointerException("mimeTypes is null");
        //}
        //mLabel = label;
        //mMimeTypes = mimeTypes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.048 -0400", hash_original_method = "A0387A443FBD0EC599BEE38B5BCEEEFE", hash_generated_method = "9D452B706CD71C98BE0ECC9C735A495D")
    @DSModeled(DSC.SAFE)
    public ClipDescription(ClipDescription o) {
        dsTaint.addTaint(o.dsTaint);
        mLabel = o.mLabel;
        mMimeTypes = o.mMimeTypes;
        // ---------- Original Method ----------
        //mLabel = o.mLabel;
        //mMimeTypes = o.mMimeTypes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.048 -0400", hash_original_method = "2082AA3F6A7022812C6D8548A4E1BDA1", hash_generated_method = "A3B20E0071BDFF32BF0F2468C0806A71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ClipDescription(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        mLabel = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
        mMimeTypes = in.createStringArray();
        // ---------- Original Method ----------
        //mLabel = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
        //mMimeTypes = in.createStringArray();
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.049 -0400", hash_original_method = "4A1E1E1996A16BAAC783C4D4608DA412", hash_generated_method = "3F4CEAAC80A4B62C4184CCA717B673A4")
    @DSModeled(DSC.SAFE)
    public CharSequence getLabel() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mLabel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.049 -0400", hash_original_method = "C012E24E08CF652349C6D573E660029C", hash_generated_method = "EA801494784B94DADA0811875D44A0FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasMimeType(String mimeType) {
        dsTaint.addTaint(mimeType);
        {
            int i;
            i = 0;
            {
                {
                    boolean var4F3B3F3F292135E17FCA0BE3EA42B11D_204016574 = (compareMimeTypes(mMimeTypes[i], mimeType));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //for (int i=0; i<mMimeTypes.length; i++) {
            //if (compareMimeTypes(mMimeTypes[i], mimeType)) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.050 -0400", hash_original_method = "184F6EBE579A57B9FFCBCC2BBB07DD57", hash_generated_method = "91AEA6AAFB9EA19D21E8F1C4219640C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] filterMimeTypes(String mimeType) {
        dsTaint.addTaint(mimeType);
        ArrayList<String> array;
        array = null;
        {
            int i;
            i = 0;
            {
                {
                    boolean var4F3B3F3F292135E17FCA0BE3EA42B11D_1951740220 = (compareMimeTypes(mMimeTypes[i], mimeType));
                    {
                        {
                            array = new ArrayList<String>();
                        } //End block
                        array.add(mMimeTypes[i]);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        String[] rawArray;
        rawArray = new String[array.size()];
        array.toArray(rawArray);
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //ArrayList<String> array = null;
        //for (int i=0; i<mMimeTypes.length; i++) {
            //if (compareMimeTypes(mMimeTypes[i], mimeType)) {
                //if (array == null) {
                    //array = new ArrayList<String>();
                //}
                //array.add(mMimeTypes[i]);
            //}
        //}
        //if (array == null) {
            //return null;
        //}
        //String[] rawArray = new String[array.size()];
        //array.toArray(rawArray);
        //return rawArray;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.050 -0400", hash_original_method = "B31C73D49DA2B2DFF06E53A9680B864B", hash_generated_method = "2E716DE106D58D60EB047F7A0D2D3886")
    @DSModeled(DSC.SAFE)
    public int getMimeTypeCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMimeTypes.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.050 -0400", hash_original_method = "764DD8C2717756748E8339CB8965B38B", hash_generated_method = "65BBDAC8CC3A803A43888975D446133E")
    @DSModeled(DSC.SAFE)
    public String getMimeType(int index) {
        dsTaint.addTaint(index);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mMimeTypes[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.051 -0400", hash_original_method = "EB798FB270DF414D0A3DC9E08213FD60", hash_generated_method = "A33F839E0525F6522154BE7F2A5856D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void validate() {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null mime types");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("must have at least 1 mime type");
        } //End block
        {
            int i;
            i = 0;
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException("mime type at " + i + " is null");
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mMimeTypes == null) {
            //throw new NullPointerException("null mime types");
        //}
        //if (mMimeTypes.length <= 0) {
            //throw new IllegalArgumentException("must have at least 1 mime type");
        //}
        //for (int i=0; i<mMimeTypes.length; i++) {
            //if (mMimeTypes[i] == null) {
                //throw new NullPointerException("mime type at " + i + " is null");
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.051 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0DB50BC0CCE4711867E95DEC1B2117C7")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.052 -0400", hash_original_method = "B91E92C4C4B5B9EF26722F0E8D4A5B80", hash_generated_method = "876DF77DA9D126C816932086BE1F7543")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        TextUtils.writeToParcel(mLabel, dest, flags);
        dest.writeStringArray(mMimeTypes);
        // ---------- Original Method ----------
        //TextUtils.writeToParcel(mLabel, dest, flags);
        //dest.writeStringArray(mMimeTypes);
    }

    
    public static final String MIMETYPE_TEXT_PLAIN = "text/plain";
    public static final String MIMETYPE_TEXT_URILIST = "text/uri-list";
    public static final String MIMETYPE_TEXT_INTENT = "text/vnd.android.intent";
    public static final Parcelable.Creator<ClipDescription> CREATOR = new Parcelable.Creator<ClipDescription>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.053 -0400", hash_original_method = "85E642226A89613A0CF91353EFBEB228", hash_generated_method = "7E3DCAF89DC98C9ED9371E075BDB859B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ClipDescription createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            ClipDescription varF4502EBD0D1B0F6DF3891C7AA7394C61_33231287 = (new ClipDescription(source));
            return (ClipDescription)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ClipDescription(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:40.054 -0400", hash_original_method = "AC410D16DBC5B2C89980F31171589F7A", hash_generated_method = "339D447F6F3101101156F06C44B97D74")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ClipDescription[] newArray(int size) {
            dsTaint.addTaint(size);
            ClipDescription[] varA7A0983A65EC96A4FD55F78F53CA8708_234095546 = (new ClipDescription[size]);
            return (ClipDescription[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ClipDescription[size];
        }

        
}; //Transformed anonymous class
}

