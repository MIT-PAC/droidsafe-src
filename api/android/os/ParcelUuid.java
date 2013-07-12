package android.os;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.UUID;

public final class ParcelUuid implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.154 -0400", hash_original_field = "6D1083D630EED7814896F0D75349A34B", hash_generated_field = "318090B38C1325AB0A6BDE7565479F55")

    private UUID mUuid;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.154 -0400", hash_original_method = "CF473C61D493B6FE5C1BBCA31D442219", hash_generated_method = "E06C951B4989B3CE22A154EDE10F05EA")
    public  ParcelUuid(UUID uuid) {
        mUuid = uuid;
        
        
    }

    
        public static ParcelUuid fromString(String uuid) {
        return new ParcelUuid(UUID.fromString(uuid));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.155 -0400", hash_original_method = "0CE9C43DAF663B7B5A7713ED255C5D05", hash_generated_method = "7099F424A3520C338D7D372D84DA6CFF")
    public UUID getUuid() {
UUID var86B71BE3C39C4B77800B74F827A65360_979393065 =         mUuid;
        var86B71BE3C39C4B77800B74F827A65360_979393065.addTaint(taint);
        return var86B71BE3C39C4B77800B74F827A65360_979393065;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.155 -0400", hash_original_method = "88F1B202F7B60E8AC7861421AE6F35A5", hash_generated_method = "5CCD11669AF1E4428DF29B4B34F71FE3")
    @Override
    public String toString() {
String var3DBA5581A50FF6A029E224F01A569D9E_1169677943 =         mUuid.toString();
        var3DBA5581A50FF6A029E224F01A569D9E_1169677943.addTaint(taint);
        return var3DBA5581A50FF6A029E224F01A569D9E_1169677943;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.155 -0400", hash_original_method = "3F38019E558A882D8ACF21219C1A6CB1", hash_generated_method = "CF2C1A24E0BA7F70CEA4A5D1DC010C6C")
    @Override
    public int hashCode() {
        int var5B836F0A01C2A9EB134CBF9B4E7DCC4A_189606871 = (mUuid.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1479665395 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1479665395;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.156 -0400", hash_original_method = "03E4868AC4B42986ECAD1235C75A1F23", hash_generated_method = "9CE618984222A2D3824C419F3F362299")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
    if(object == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_490813085 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_647729992 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_647729992;
        } 
    if(this == object)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_921179610 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_48181113 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_48181113;
        } 
    if(!(object instanceof ParcelUuid))        
        {
            boolean var68934A3E9455FA72420237EB05902327_280978230 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_950992206 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_950992206;
        } 
        ParcelUuid that = (ParcelUuid) object;
        boolean var8B62245F43A8AE85610BEB98BA05DA38_1309924316 = ((this.mUuid.equals(that.mUuid)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_661545728 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_661545728;
        
        
           
       
        
           
       
        
           
       
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.156 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "46428A8906BAC639C3B97F4BA407D862")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_993488589 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1500273452 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1500273452;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.157 -0400", hash_original_method = "914E719E6FA80BA5E3F689C4DD681C77", hash_generated_method = "2139B38EDAF805C119EAEC6940A80806")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeLong(mUuid.getMostSignificantBits());
        dest.writeLong(mUuid.getLeastSignificantBits());
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.157 -0400", hash_original_field = "DAF10E97A432AC719FB06B3080752505", hash_generated_field = "BB5540FFC228809144D41EB7EDD6B529")

    public static final Parcelable.Creator<ParcelUuid> CREATOR =
               new Parcelable.Creator<ParcelUuid>() {
        public ParcelUuid createFromParcel(Parcel source) {
            long mostSigBits = source.readLong();
            long leastSigBits = source.readLong();
            UUID uuid = new UUID(mostSigBits, leastSigBits);
            return new ParcelUuid(uuid);
        }

        public ParcelUuid[] newArray(int size) {
            return new ParcelUuid[size];
        }
    };
}

