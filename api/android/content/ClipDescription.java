package android.content;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;





public class ClipDescription implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.587 -0400", hash_original_field = "D9334C2D55F77CE82F97CD28EFAAD24C", hash_generated_field = "3688992A2E5C86A7BA94DE38FB1043D1")

    CharSequence mLabel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.588 -0400", hash_original_field = "5EE137557DDDE05463217DB32F89FE92", hash_generated_field = "97CE940966C9ECB62D16CE8136A149A4")

    String[] mMimeTypes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.589 -0400", hash_original_method = "6E07A97519B37D56809D89D2D092EC92", hash_generated_method = "890D65494935619F9AA429AB6DB7B54C")
    public  ClipDescription(CharSequence label, String[] mimeTypes) {
        if(mimeTypes == null)        
        {
            NullPointerException var3E63AEEB8B2852F256E112217BABEFB3_1363819532 = new NullPointerException("mimeTypes is null");
            var3E63AEEB8B2852F256E112217BABEFB3_1363819532.addTaint(taint);
            throw var3E63AEEB8B2852F256E112217BABEFB3_1363819532;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.590 -0400", hash_original_method = "A0387A443FBD0EC599BEE38B5BCEEEFE", hash_generated_method = "500EE76E612CA9247BDBAF4FBA4E3A0E")
    public  ClipDescription(ClipDescription o) {
        mLabel = o.mLabel;
        mMimeTypes = o.mMimeTypes;
        // ---------- Original Method ----------
        //mLabel = o.mLabel;
        //mMimeTypes = o.mMimeTypes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.592 -0400", hash_original_method = "2082AA3F6A7022812C6D8548A4E1BDA1", hash_generated_method = "DC7613E13E0DBB147B4733FF183442DB")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.594 -0400", hash_original_method = "4A1E1E1996A16BAAC783C4D4608DA412", hash_generated_method = "FE3812C956766D1DA22BA36B564A41D9")
    public CharSequence getLabel() {
CharSequence var21E4126FD2EB7A90E0B7B540C066F29D_445965695 =         mLabel;
        var21E4126FD2EB7A90E0B7B540C066F29D_445965695.addTaint(taint);
        return var21E4126FD2EB7A90E0B7B540C066F29D_445965695;
        // ---------- Original Method ----------
        //return mLabel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.595 -0400", hash_original_method = "C012E24E08CF652349C6D573E660029C", hash_generated_method = "BC6D0CAFD44910D3DDDE1871DB0974A4")
    public boolean hasMimeType(String mimeType) {
        addTaint(mimeType.getTaint());
for(int i=0;i<mMimeTypes.length;i++)
        {
            if(compareMimeTypes(mMimeTypes[i], mimeType))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_769952609 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_993278342 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_993278342;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1366841515 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1197818620 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1197818620;
        // ---------- Original Method ----------
        //for (int i=0; i<mMimeTypes.length; i++) {
            //if (compareMimeTypes(mMimeTypes[i], mimeType)) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.596 -0400", hash_original_method = "184F6EBE579A57B9FFCBCC2BBB07DD57", hash_generated_method = "AED10A9BDC8BB4AE6F57E38636178466")
    public String[] filterMimeTypes(String mimeType) {
        addTaint(mimeType.getTaint());
        ArrayList<String> array = null;
for(int i=0;i<mMimeTypes.length;i++)
        {
            if(compareMimeTypes(mMimeTypes[i], mimeType))            
            {
                if(array == null)                
                {
                    array = new ArrayList<String>();
                } //End block
                array.add(mMimeTypes[i]);
            } //End block
        } //End block
        if(array == null)        
        {
String[] var540C13E9E156B687226421B24F2DF178_1287487023 =             null;
            var540C13E9E156B687226421B24F2DF178_1287487023.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1287487023;
        } //End block
        String[] rawArray = new String[array.size()];
        array.toArray(rawArray);
String[] var822851022E4BEBC62394ECB824CEDA57_1235166796 =         rawArray;
        var822851022E4BEBC62394ECB824CEDA57_1235166796.addTaint(taint);
        return var822851022E4BEBC62394ECB824CEDA57_1235166796;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.596 -0400", hash_original_method = "B31C73D49DA2B2DFF06E53A9680B864B", hash_generated_method = "D0B6D76242416995D3F305D1B2494553")
    public int getMimeTypeCount() {
        int var1751EF599B3E214FB392CD8756CBCEF4_755842724 = (mMimeTypes.length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_83778912 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_83778912;
        // ---------- Original Method ----------
        //return mMimeTypes.length;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.597 -0400", hash_original_method = "764DD8C2717756748E8339CB8965B38B", hash_generated_method = "8CE82F2158B3304C4FD1C922674AB2DB")
    public String getMimeType(int index) {
        addTaint(index);
String varFB11B145E24DE026EB623F066F0127B7_1806481193 =         mMimeTypes[index];
        varFB11B145E24DE026EB623F066F0127B7_1806481193.addTaint(taint);
        return varFB11B145E24DE026EB623F066F0127B7_1806481193;
        // ---------- Original Method ----------
        //return mMimeTypes[index];
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.597 -0400", hash_original_method = "EB798FB270DF414D0A3DC9E08213FD60", hash_generated_method = "938E019F89190E9333FF8D2BB32CBE90")
    public void validate() {
        if(mMimeTypes == null)        
        {
            NullPointerException varFFEE9D2045E4C087D805A1C3ABC5C7A3_1059066086 = new NullPointerException("null mime types");
            varFFEE9D2045E4C087D805A1C3ABC5C7A3_1059066086.addTaint(taint);
            throw varFFEE9D2045E4C087D805A1C3ABC5C7A3_1059066086;
        } //End block
        if(mMimeTypes.length <= 0)        
        {
            IllegalArgumentException var834DD9EAF8F0B3B569DED76945B2C691_1859715987 = new IllegalArgumentException("must have at least 1 mime type");
            var834DD9EAF8F0B3B569DED76945B2C691_1859715987.addTaint(taint);
            throw var834DD9EAF8F0B3B569DED76945B2C691_1859715987;
        } //End block
for(int i=0;i<mMimeTypes.length;i++)
        {
            if(mMimeTypes[i] == null)            
            {
                NullPointerException var4C47452AC5A46B749059FE333899C0FF_2146401065 = new NullPointerException("mime type at " + i + " is null");
                var4C47452AC5A46B749059FE333899C0FF_2146401065.addTaint(taint);
                throw var4C47452AC5A46B749059FE333899C0FF_2146401065;
            } //End block
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.599 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "BC6BCD662F40F3C240F96635856C8D22")
    @Override
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1645146665 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_605843507 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_605843507;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.600 -0400", hash_original_method = "B91E92C4C4B5B9EF26722F0E8D4A5B80", hash_generated_method = "D0B5048C2BD49A5B6DDFB0BCFC932B20")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        TextUtils.writeToParcel(mLabel, dest, flags);
        dest.writeStringArray(mMimeTypes);
        // ---------- Original Method ----------
        //TextUtils.writeToParcel(mLabel, dest, flags);
        //dest.writeStringArray(mMimeTypes);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.600 -0400", hash_original_field = "7539F1E1C0B92F6C542B982FC121E0DA", hash_generated_field = "0280346FADEE4FC6A00ED7FC060F7D11")

    public static final String MIMETYPE_TEXT_PLAIN = "text/plain";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.601 -0400", hash_original_field = "BEA01025D19A34885815A4A4EA3E4AEB", hash_generated_field = "9EDF462464DC7CDE9C0F955DDDA0B280")

    public static final String MIMETYPE_TEXT_URILIST = "text/uri-list";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.601 -0400", hash_original_field = "450517AD7281BF52AC64FD651C760DC0", hash_generated_field = "9937E31EA61FC826C35F356444BF63A7")

    public static final String MIMETYPE_TEXT_INTENT = "text/vnd.android.intent";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:59.601 -0400", hash_original_field = "EE46FC7A8710E19EB643FEE455FA4E3F", hash_generated_field = "FAFA5E398B2BAE20941CFC963489A38D")

    public static final Parcelable.Creator<ClipDescription> CREATOR =
        new Parcelable.Creator<ClipDescription>() {

            public ClipDescription createFromParcel(Parcel source) {
                return new ClipDescription(source);
            }

            public ClipDescription[] newArray(int size) {
                return new ClipDescription[size];
            }
        };
    // orphaned legacy method
    public ClipDescription createFromParcel(Parcel source) {
                return new ClipDescription(source);
            }
    
    // orphaned legacy method
    public ClipDescription[] newArray(int size) {
                return new ClipDescription[size];
            }
    
}

