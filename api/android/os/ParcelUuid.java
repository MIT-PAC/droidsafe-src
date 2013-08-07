package android.os;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.UUID;






public final class ParcelUuid implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.156 -0400", hash_original_field = "6D1083D630EED7814896F0D75349A34B", hash_generated_field = "318090B38C1325AB0A6BDE7565479F55")

    private UUID mUuid;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.156 -0400", hash_original_method = "CF473C61D493B6FE5C1BBCA31D442219", hash_generated_method = "E06C951B4989B3CE22A154EDE10F05EA")
    public  ParcelUuid(UUID uuid) {
        mUuid = uuid;
        // ---------- Original Method ----------
        //mUuid = uuid;
    }

    
    public static ParcelUuid fromString(String uuid) {
        return new ParcelUuid(UUID.fromString(uuid));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.156 -0400", hash_original_method = "0CE9C43DAF663B7B5A7713ED255C5D05", hash_generated_method = "1FF1AAEA777CA73DF07D6E029227CCB9")
    public UUID getUuid() {
UUID var86B71BE3C39C4B77800B74F827A65360_169333613 =         mUuid;
        var86B71BE3C39C4B77800B74F827A65360_169333613.addTaint(taint);
        return var86B71BE3C39C4B77800B74F827A65360_169333613;
        // ---------- Original Method ----------
        //return mUuid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.156 -0400", hash_original_method = "88F1B202F7B60E8AC7861421AE6F35A5", hash_generated_method = "70A730DF6D6291A5A284752FE73D943A")
    @Override
    public String toString() {
String var3DBA5581A50FF6A029E224F01A569D9E_148096710 =         mUuid.toString();
        var3DBA5581A50FF6A029E224F01A569D9E_148096710.addTaint(taint);
        return var3DBA5581A50FF6A029E224F01A569D9E_148096710;
        // ---------- Original Method ----------
        //return mUuid.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.157 -0400", hash_original_method = "3F38019E558A882D8ACF21219C1A6CB1", hash_generated_method = "5D26FC7A4F88A1F8A630714F8A11ABA7")
    @Override
    public int hashCode() {
        int var5B836F0A01C2A9EB134CBF9B4E7DCC4A_461007959 = (mUuid.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_483267212 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_483267212;
        // ---------- Original Method ----------
        //return mUuid.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.157 -0400", hash_original_method = "03E4868AC4B42986ECAD1235C75A1F23", hash_generated_method = "5E9282AC2964C23DDC9891E128F63D35")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        if(object == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1415251235 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_492408829 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_492408829;
        } //End block
        if(this == object)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_983101576 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1339710054 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1339710054;
        } //End block
        if(!(object instanceof ParcelUuid))        
        {
            boolean var68934A3E9455FA72420237EB05902327_78785093 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1584931138 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1584931138;
        } //End block
        ParcelUuid that = (ParcelUuid) object;
        boolean var8B62245F43A8AE85610BEB98BA05DA38_527258014 = ((this.mUuid.equals(that.mUuid)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1582526556 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1582526556;
        // ---------- Original Method ----------
        //if (object == null) {
           //return false;
       //}
        //if (this == object) {
           //return true;
       //}
        //if (!(object instanceof ParcelUuid)) {
           //return false;
       //}
        //ParcelUuid that = (ParcelUuid) object;
        //return (this.mUuid.equals(that.mUuid));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.157 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "F13F04340C7C5DBA3D295AE1FBD163C9")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_266468924 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_152310633 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_152310633;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.157 -0400", hash_original_method = "914E719E6FA80BA5E3F689C4DD681C77", hash_generated_method = "2139B38EDAF805C119EAEC6940A80806")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeLong(mUuid.getMostSignificantBits());
        dest.writeLong(mUuid.getLeastSignificantBits());
        // ---------- Original Method ----------
        //dest.writeLong(mUuid.getMostSignificantBits());
        //dest.writeLong(mUuid.getLeastSignificantBits());
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.158 -0400", hash_original_field = "DAF10E97A432AC719FB06B3080752505", hash_generated_field = "BB5540FFC228809144D41EB7EDD6B529")

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

