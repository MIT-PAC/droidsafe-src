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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.126 -0400", hash_original_field = "D9334C2D55F77CE82F97CD28EFAAD24C", hash_generated_field = "3688992A2E5C86A7BA94DE38FB1043D1")

    CharSequence mLabel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.127 -0400", hash_original_field = "5EE137557DDDE05463217DB32F89FE92", hash_generated_field = "97CE940966C9ECB62D16CE8136A149A4")

    String[] mMimeTypes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.137 -0400", hash_original_method = "6E07A97519B37D56809D89D2D092EC92", hash_generated_method = "1BBAF3131430A4114DD88F8787A0B845")
    public  ClipDescription(CharSequence label, String[] mimeTypes) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("mimeTypes is null");
        } //End block
        mLabel = label;
        mMimeTypes = mimeTypes;
        // ---------- Original Method ----------
        //if (mimeTypes == null) {
            //throw new NullPointerException("mimeTypes is null");
        //}
        //mLabel = label;
        //mMimeTypes = mimeTypes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.139 -0400", hash_original_method = "A0387A443FBD0EC599BEE38B5BCEEEFE", hash_generated_method = "500EE76E612CA9247BDBAF4FBA4E3A0E")
    public  ClipDescription(ClipDescription o) {
        mLabel = o.mLabel;
        mMimeTypes = o.mMimeTypes;
        // ---------- Original Method ----------
        //mLabel = o.mLabel;
        //mMimeTypes = o.mMimeTypes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.152 -0400", hash_original_method = "2082AA3F6A7022812C6D8548A4E1BDA1", hash_generated_method = "DC7613E13E0DBB147B4733FF183442DB")
      ClipDescription(Parcel in) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.167 -0400", hash_original_method = "4A1E1E1996A16BAAC783C4D4608DA412", hash_generated_method = "BB8FBFEDA50B40E4B4215005E164735C")
    public CharSequence getLabel() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1093066328 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1093066328 = mLabel;
        varB4EAC82CA7396A68D541C85D26508E83_1093066328.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1093066328;
        // ---------- Original Method ----------
        //return mLabel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.168 -0400", hash_original_method = "C012E24E08CF652349C6D573E660029C", hash_generated_method = "39654FA10800F2FC1AFCD560C0106E5A")
    public boolean hasMimeType(String mimeType) {
        {
            int i;
            i = 0;
            {
                {
                    boolean var4F3B3F3F292135E17FCA0BE3EA42B11D_975200346 = (compareMimeTypes(mMimeTypes[i], mimeType));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(mimeType.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_862393958 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_862393958;
        // ---------- Original Method ----------
        //for (int i=0; i<mMimeTypes.length; i++) {
            //if (compareMimeTypes(mMimeTypes[i], mimeType)) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.203 -0400", hash_original_method = "184F6EBE579A57B9FFCBCC2BBB07DD57", hash_generated_method = "4D59B254A64D2EA81D807D2F9B2A0998")
    public String[] filterMimeTypes(String mimeType) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1147675053 = null; //Variable for return #1
        String[] varB4EAC82CA7396A68D541C85D26508E83_893327781 = null; //Variable for return #2
        ArrayList<String> array;
        array = null;
        {
            int i;
            i = 0;
            {
                {
                    boolean var4F3B3F3F292135E17FCA0BE3EA42B11D_1471641333 = (compareMimeTypes(mMimeTypes[i], mimeType));
                    {
                        {
                            array = new ArrayList<String>();
                        } //End block
                        array.add(mMimeTypes[i]);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            varB4EAC82CA7396A68D541C85D26508E83_1147675053 = null;
        } //End block
        String[] rawArray;
        rawArray = new String[array.size()];
        array.toArray(rawArray);
        varB4EAC82CA7396A68D541C85D26508E83_893327781 = rawArray;
        addTaint(mimeType.getTaint());
        String[] varA7E53CE21691AB073D9660D615818899_1978025472; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1978025472 = varB4EAC82CA7396A68D541C85D26508E83_1147675053;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1978025472 = varB4EAC82CA7396A68D541C85D26508E83_893327781;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1978025472.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1978025472;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.204 -0400", hash_original_method = "B31C73D49DA2B2DFF06E53A9680B864B", hash_generated_method = "49AEC7DB65917CBC1166A8A8962C960D")
    public int getMimeTypeCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_23103984 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_23103984;
        // ---------- Original Method ----------
        //return mMimeTypes.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.220 -0400", hash_original_method = "764DD8C2717756748E8339CB8965B38B", hash_generated_method = "12DA586E64F38284E1831CC9A3704A86")
    public String getMimeType(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_411575061 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_411575061 = mMimeTypes[index];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_411575061.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_411575061;
        // ---------- Original Method ----------
        //return mMimeTypes[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.221 -0400", hash_original_method = "EB798FB270DF414D0A3DC9E08213FD60", hash_generated_method = "A33F839E0525F6522154BE7F2A5856D7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.222 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "EC49DC97EA7B12FA493A583ACE207473")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_283656816 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_283656816;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.223 -0400", hash_original_method = "B91E92C4C4B5B9EF26722F0E8D4A5B80", hash_generated_method = "506059D6435244EE6B5CC245CA922CF8")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        TextUtils.writeToParcel(mLabel, dest, flags);
        dest.writeStringArray(mMimeTypes);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //TextUtils.writeToParcel(mLabel, dest, flags);
        //dest.writeStringArray(mMimeTypes);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.238 -0400", hash_original_field = "7539F1E1C0B92F6C542B982FC121E0DA", hash_generated_field = "0280346FADEE4FC6A00ED7FC060F7D11")

    public static final String MIMETYPE_TEXT_PLAIN = "text/plain";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.238 -0400", hash_original_field = "BEA01025D19A34885815A4A4EA3E4AEB", hash_generated_field = "9EDF462464DC7CDE9C0F955DDDA0B280")

    public static final String MIMETYPE_TEXT_URILIST = "text/uri-list";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.238 -0400", hash_original_field = "450517AD7281BF52AC64FD651C760DC0", hash_generated_field = "9937E31EA61FC826C35F356444BF63A7")

    public static final String MIMETYPE_TEXT_INTENT = "text/vnd.android.intent";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:58.239 -0400", hash_original_field = "EE46FC7A8710E19EB643FEE455FA4E3F", hash_generated_field = "FAFA5E398B2BAE20941CFC963489A38D")

    public static final Parcelable.Creator<ClipDescription> CREATOR =
        new Parcelable.Creator<ClipDescription>() {

            public ClipDescription createFromParcel(Parcel source) {
                return new ClipDescription(source);
            }

            public ClipDescription[] newArray(int size) {
                return new ClipDescription[size];
            }
        };
}

