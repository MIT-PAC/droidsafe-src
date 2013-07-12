package android.content.pm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PatternMatcher;

public final class ProviderInfo extends ComponentInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.184 -0400", hash_original_field = "C55ECB6153A50CAC3F9C58601BD47DDF", hash_generated_field = "3E8DB1403D91FD0BC10BCD6D25011DA7")

    public String authority = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.185 -0400", hash_original_field = "4304A0EA6B03E36462084C33E8FAA6BC", hash_generated_field = "9B89113FCF6DD9BBF615592F5D6A3B73")

    public String readPermission = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.185 -0400", hash_original_field = "EA56F4892B3C06BD43846C93A069FEC6", hash_generated_field = "A4D20C3E8A767EF2CA4C9C700A2F0207")

    public String writePermission = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.185 -0400", hash_original_field = "B097AB28AF3C02F0FC461AC3B4865DA1", hash_generated_field = "CDABD162A8569AAE60DF4B0548E21087")

    public boolean grantUriPermissions = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.185 -0400", hash_original_field = "5419D8D1BFDC79E8F1E6905A3A571025", hash_generated_field = "668190D0BDFB4201C777E7488D9B60FB")

    public PatternMatcher[] uriPermissionPatterns = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.185 -0400", hash_original_field = "936C856C0429D1751956606F3138D493", hash_generated_field = "6CB2C41C003C5C1EF2087EC1A83FE499")

    public PathPermission[] pathPermissions = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.185 -0400", hash_original_field = "727FB013D830EC30ECB8B8CF3B58D9AE", hash_generated_field = "0415CF4582A07E809068F3B939A342D9")

    public boolean multiprocess = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.185 -0400", hash_original_field = "1B4191F3EF91B1374EE6DE8D47700C59", hash_generated_field = "DA766FF90FD83CA9F7F97BA699F1D548")

    public int initOrder = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.185 -0400", hash_original_field = "6702E212C4F45054FF10106817AC1DDD", hash_generated_field = "FCC5D6A5DC69BB5AD4BD4634F8A5A256")

    @Deprecated public boolean isSyncable = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.186 -0400", hash_original_method = "D2CF667D6D9DF94B5D6BB6106BFAE873", hash_generated_method = "B4804D482B030CB842C9B23FD5E0D5C4")
    public  ProviderInfo() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.187 -0400", hash_original_method = "DA84A5BF345E5B845C3AEBDD1FA39C20", hash_generated_method = "3212B77D210092D08BF9E307D9A6512D")
    public  ProviderInfo(ProviderInfo orig) {
        super(orig);
        authority = orig.authority;
        readPermission = orig.readPermission;
        writePermission = orig.writePermission;
        grantUriPermissions = orig.grantUriPermissions;
        uriPermissionPatterns = orig.uriPermissionPatterns;
        pathPermissions = orig.pathPermissions;
        multiprocess = orig.multiprocess;
        initOrder = orig.initOrder;
        isSyncable = orig.isSyncable;
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.189 -0400", hash_original_method = "CB7E407C3FF25BE7AFF90A1406ACF604", hash_generated_method = "539DF8101786C0CB92EA0562732F1716")
    private  ProviderInfo(Parcel in) {
        super(in);
        authority = in.readString();
        readPermission = in.readString();
        writePermission = in.readString();
        grantUriPermissions = in.readInt() != 0;
        uriPermissionPatterns = in.createTypedArray(PatternMatcher.CREATOR);
        pathPermissions = in.createTypedArray(PathPermission.CREATOR);
        multiprocess = in.readInt() != 0;
        initOrder = in.readInt();
        isSyncable = in.readInt() != 0;
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.190 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "49EB62A6B26BA06C2E2FDC4F7CF8AC51")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1561132760 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1418794707 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1418794707;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.190 -0400", hash_original_method = "45D9E31DA8DC0720E2897CA268CD8E20", hash_generated_method = "9F4C4083C3F4074D78644EE2A673883B")
    @Override
    public void writeToParcel(Parcel out, int parcelableFlags) {
        addTaint(parcelableFlags);
        addTaint(out.getTaint());
        super.writeToParcel(out, parcelableFlags);
        out.writeString(authority);
        out.writeString(readPermission);
        out.writeString(writePermission);
        out.writeInt(grantUriPermissions ? 1 : 0);
        out.writeTypedArray(uriPermissionPatterns, parcelableFlags);
        out.writeTypedArray(pathPermissions, parcelableFlags);
        out.writeInt(multiprocess ? 1 : 0);
        out.writeInt(initOrder);
        out.writeInt(isSyncable ? 1 : 0);
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.191 -0400", hash_original_method = "A325E506B6C78D4488CEDF60427F48B5", hash_generated_method = "21FE00BC250FA883454572650AD861DB")
    public String toString() {
String varD6FD82BF3DAE7A6B9B51563B3E18074B_954968619 =         "ContentProviderInfo{name=" + authority + " className=" + name
            + " isSyncable=" + (isSyncable ? "true" : "false") + "}";
        varD6FD82BF3DAE7A6B9B51563B3E18074B_954968619.addTaint(taint);
        return varD6FD82BF3DAE7A6B9B51563B3E18074B_954968619;
        
        
            
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.191 -0400", hash_original_field = "DD4D4FCA6B950B464A88C210AA1AB627", hash_generated_field = "1363713E47A8A9D4D7DB3FBE464E5623")

    public static final Parcelable.Creator<ProviderInfo> CREATOR
            = new Parcelable.Creator<ProviderInfo>() {
        public ProviderInfo createFromParcel(Parcel in) {
            return new ProviderInfo(in);
        }

        public ProviderInfo[] newArray(int size) {
            return new ProviderInfo[size];
        }
    };
    
    public ProviderInfo createFromParcel(Parcel in) {
            return new ProviderInfo(in);
        }
    
    
    public ProviderInfo[] newArray(int size) {
            return new ProviderInfo[size];
        }
    
}

