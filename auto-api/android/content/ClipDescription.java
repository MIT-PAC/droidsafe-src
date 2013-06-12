package android.content;

// Droidsafe Imports
import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.runtime.DroidSafeAndroidRuntime;
// import Iterator to deal with enhanced for loop translation

public class ClipDescription implements Parcelable {
    public static final String MIMETYPE_TEXT_PLAIN = "text/plain";
    public static final String MIMETYPE_TEXT_URILIST = "text/uri-list";
    public static final String MIMETYPE_TEXT_INTENT = "text/vnd.android.intent";
    final CharSequence mLabel;
    final String[] mMimeTypes;
    public static final Parcelable.Creator<ClipDescription> CREATOR = new Parcelable.Creator<ClipDescription>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.246 -0400", hash_original_method = "85E642226A89613A0CF91353EFBEB228", hash_generated_method = "4D6463D393AAAEDE5ED7D843DC9F0860")
        @DSModeled(DSC.SAFE)
        public ClipDescription createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            return (ClipDescription)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ClipDescription(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.246 -0400", hash_original_method = "AC410D16DBC5B2C89980F31171589F7A", hash_generated_method = "6D59A7EFBBB89F9DC6F91C61350A9566")
        @DSModeled(DSC.SAFE)
        public ClipDescription[] newArray(int size) {
            dsTaint.addTaint(size);
            return (ClipDescription[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ClipDescription[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.246 -0400", hash_original_method = "6E07A97519B37D56809D89D2D092EC92", hash_generated_method = "907D0ADD12AA487F2FA96EB772774E29")
    @DSModeled(DSC.SAFE)
    public ClipDescription(CharSequence label, String[] mimeTypes) {
        dsTaint.addTaint(label);
        dsTaint.addTaint(mimeTypes);
        {
            throw new NullPointerException("mimeTypes is null");
        } //End block
        // ---------- Original Method ----------
        //if (mimeTypes == null) {
            //throw new NullPointerException("mimeTypes is null");
        //}
        //mLabel = label;
        //mMimeTypes = mimeTypes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.246 -0400", hash_original_method = "A0387A443FBD0EC599BEE38B5BCEEEFE", hash_generated_method = "F0054219F759F11BD18BFF306C0F51AB")
    @DSModeled(DSC.SAFE)
    public ClipDescription(ClipDescription o) {
        dsTaint.addTaint(o.dsTaint);
        mLabel = o.mLabel;
        mMimeTypes = o.mMimeTypes;
        // ---------- Original Method ----------
        //mLabel = o.mLabel;
        //mMimeTypes = o.mMimeTypes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.247 -0400", hash_original_method = "2082AA3F6A7022812C6D8548A4E1BDA1", hash_generated_method = "EBACB6F46B62F89431FDB97A40AECAD3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ClipDescription(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        mLabel = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
        mMimeTypes = in.createStringArray();
        // ---------- Original Method ----------
        //mLabel = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
        //mMimeTypes = in.createStringArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.247 -0400", hash_original_method = "D4A0CDCFA2584BBC2247DBCF532082CA", hash_generated_method = "4980F5671337308B811DE589FFF6DD54")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.247 -0400", hash_original_method = "4A1E1E1996A16BAAC783C4D4608DA412", hash_generated_method = "89416D521A5944D040EB08BCF518263B")
    @DSModeled(DSC.SAFE)
    public CharSequence getLabel() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mLabel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.247 -0400", hash_original_method = "C012E24E08CF652349C6D573E660029C", hash_generated_method = "BFDBE13A2EAB99CABEC9FFDDE82E52AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasMimeType(String mimeType) {
        dsTaint.addTaint(mimeType);
        {
            int i;
            i = 0;
            {
                {
                    boolean var4F3B3F3F292135E17FCA0BE3EA42B11D_760070395 = (compareMimeTypes(mMimeTypes[i], mimeType));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.248 -0400", hash_original_method = "184F6EBE579A57B9FFCBCC2BBB07DD57", hash_generated_method = "DE687F4911D195D5A196D864AFADD435")
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
                    boolean var4F3B3F3F292135E17FCA0BE3EA42B11D_237980047 = (compareMimeTypes(mMimeTypes[i], mimeType));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.248 -0400", hash_original_method = "B31C73D49DA2B2DFF06E53A9680B864B", hash_generated_method = "7C53300EAD556D349B95BACDCCCBE987")
    @DSModeled(DSC.SAFE)
    public int getMimeTypeCount() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMimeTypes.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.248 -0400", hash_original_method = "764DD8C2717756748E8339CB8965B38B", hash_generated_method = "33573DB091C1C4D0B7E91F6E8C617762")
    @DSModeled(DSC.SAFE)
    public String getMimeType(int index) {
        dsTaint.addTaint(index);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mMimeTypes[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.249 -0400", hash_original_method = "EB798FB270DF414D0A3DC9E08213FD60", hash_generated_method = "A370FA3B736BD2D7115046464E76FBAC")
    @DSModeled(DSC.SAFE)
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
                    throw new NullPointerException("mime type at " + i + " is null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.249 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "826038BB7EBD5D3C24D01F025676D20A")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.249 -0400", hash_original_method = "B91E92C4C4B5B9EF26722F0E8D4A5B80", hash_generated_method = "83F0D54CE6CBCF0790EC2ED77010D3EB")
    @DSModeled(DSC.SAFE)
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        TextUtils.writeToParcel(mLabel, dest, flags);
        dest.writeStringArray(mMimeTypes);
        // ---------- Original Method ----------
        //TextUtils.writeToParcel(mLabel, dest, flags);
        //dest.writeStringArray(mMimeTypes);
    }

    
}


