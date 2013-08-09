package android.os.storage;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;





public class StorageVolume implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.110 -0400", hash_original_field = "FB4FCB3508FC66D4E3F113990AC335C6", hash_generated_field = "6FACC3B41470C8330B5F0BB43FA7FD9F")

    private String mPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.111 -0400", hash_original_field = "FF2B9B684DDD70D7BE468C8D9A54343D", hash_generated_field = "D58E2E2E369193E8B6C54168B334B477")

    private String mDescription;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.111 -0400", hash_original_field = "BA2C430BDE7AD99954A160F0B96DA6E4", hash_generated_field = "57B6957FF069933A34A8E50356617F8D")

    private boolean mRemovable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.111 -0400", hash_original_field = "BB81BAE7E9AD52D1C2A9CFC73AB6E39F", hash_generated_field = "FD3FCD365A89EBDB68F13FBF92695712")

    private boolean mEmulated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.111 -0400", hash_original_field = "44CF13B011CB07C962C5DA973669BEB6", hash_generated_field = "B9166F5568CF90E3C7F2300C3B7DA377")

    private int mMtpReserveSpace;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.111 -0400", hash_original_field = "570ECAEBA3421EAED0D3DCFAEDD80845", hash_generated_field = "E13D097A35FE5501A6D0671FC135020E")

    private boolean mAllowMassStorage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.111 -0400", hash_original_field = "A211BEEE10AFE736EE5E9E3E7140A322", hash_generated_field = "BE33FDB6E306D30BAB61D2858311778E")

    private int mStorageId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.111 -0400", hash_original_field = "902454EC5B152CFEA9735C0AAF77CDE8", hash_generated_field = "3759AF9F2CB67BE0B7EF12E3261B6410")

    private long mMaxFileSize;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.113 -0400", hash_original_method = "64D7A9B637D8ABCF56CD10EE906A4905", hash_generated_method = "81313F5D3A30294AF7A1432AB6ECE6C7")
    public  StorageVolume(String path, String description, boolean removable,
            boolean emulated, int mtpReserveSpace, boolean allowMassStorage, long maxFileSize) {
        mPath = path;
        mDescription = description;
        mRemovable = removable;
        mEmulated = emulated;
        mMtpReserveSpace = mtpReserveSpace;
        mAllowMassStorage = allowMassStorage;
        mMaxFileSize = maxFileSize;
        // ---------- Original Method ----------
        //mPath = path;
        //mDescription = description;
        //mRemovable = removable;
        //mEmulated = emulated;
        //mMtpReserveSpace = mtpReserveSpace;
        //mAllowMassStorage = allowMassStorage;
        //mMaxFileSize = maxFileSize;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.116 -0400", hash_original_method = "C6DC3558E219CD63D264358A9A1233CF", hash_generated_method = "DA958F3A8D6B6A18BBD14EFFE081EDC7")
    private  StorageVolume(String path, String description, boolean removable,
            boolean emulated, int mtpReserveSpace, int storageId,
            boolean allowMassStorage, long maxFileSize) {
        mPath = path;
        mDescription = description;
        mRemovable = removable;
        mEmulated = emulated;
        mMtpReserveSpace = mtpReserveSpace;
        mAllowMassStorage = allowMassStorage;
        mStorageId = storageId;
        mMaxFileSize = maxFileSize;
        // ---------- Original Method ----------
        //mPath = path;
        //mDescription = description;
        //mRemovable = removable;
        //mEmulated = emulated;
        //mMtpReserveSpace = mtpReserveSpace;
        //mAllowMassStorage = allowMassStorage;
        //mStorageId = storageId;
        //mMaxFileSize = maxFileSize;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.118 -0400", hash_original_method = "F177C5B02553C0E0327F321BDDCEAFD5", hash_generated_method = "5655C139544869AFA247E9BC7F102C35")
    public String getPath() {
String var6AF672BCA4D9DB76D759DE4D6BEB1D5F_912969250 =         mPath;
        var6AF672BCA4D9DB76D759DE4D6BEB1D5F_912969250.addTaint(taint);
        return var6AF672BCA4D9DB76D759DE4D6BEB1D5F_912969250;
        // ---------- Original Method ----------
        //return mPath;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.119 -0400", hash_original_method = "177DD147D2F75620FD2B154278EC57FA", hash_generated_method = "83130B1CB5AA6BE328ABAAAA21528F99")
    public String getDescription() {
String var2094894B2BDB1315AACD05A5CC5702EE_176531736 =         mDescription;
        var2094894B2BDB1315AACD05A5CC5702EE_176531736.addTaint(taint);
        return var2094894B2BDB1315AACD05A5CC5702EE_176531736;
        // ---------- Original Method ----------
        //return mDescription;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.119 -0400", hash_original_method = "C8355C5823499E966C6E9C9BBED7B59B", hash_generated_method = "CAC43AA0A426DADF5821CE6F01614C2A")
    public boolean isRemovable() {
        boolean varBA2C430BDE7AD99954A160F0B96DA6E4_339959619 = (mRemovable);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1571597081 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1571597081;
        // ---------- Original Method ----------
        //return mRemovable;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.119 -0400", hash_original_method = "3969E4BD26F514DAFEA3D81664C42C95", hash_generated_method = "064952A7814272FD91B8119AF87DEBEC")
    public boolean isEmulated() {
        boolean varBB81BAE7E9AD52D1C2A9CFC73AB6E39F_1257566927 = (mEmulated);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_450782542 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_450782542;
        // ---------- Original Method ----------
        //return mEmulated;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.120 -0400", hash_original_method = "D91614A87EF069B6CB0CB580F9424F2A", hash_generated_method = "EB4C0ACBCFD00E756D7F2A2E56849F8A")
    public int getStorageId() {
        int varA211BEEE10AFE736EE5E9E3E7140A322_462752153 = (mStorageId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_528632637 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_528632637;
        // ---------- Original Method ----------
        //return mStorageId;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.120 -0400", hash_original_method = "DF85DF3474DF218FD90EC56A476BBB47", hash_generated_method = "F681C9EB234C13040C7D4D682143B82F")
    public void setStorageId(int index) {
        mStorageId = ((index + 1) << 16) + 1;
        // ---------- Original Method ----------
        //mStorageId = ((index + 1) << 16) + 1;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.120 -0400", hash_original_method = "AD5CC5267CED7BD79E23E2B3D995596D", hash_generated_method = "076C8DC815C51215020B400574A5E4C7")
    public int getMtpReserveSpace() {
        int var44CF13B011CB07C962C5DA973669BEB6_1053614016 = (mMtpReserveSpace);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1533743361 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1533743361;
        // ---------- Original Method ----------
        //return mMtpReserveSpace;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.121 -0400", hash_original_method = "70EAD3302E25E04AF22ADA1536C85D6E", hash_generated_method = "2F5808EB663AC5B0D120F007D28A73DD")
    public boolean allowMassStorage() {
        boolean var570ECAEBA3421EAED0D3DCFAEDD80845_1629813854 = (mAllowMassStorage);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1803613015 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1803613015;
        // ---------- Original Method ----------
        //return mAllowMassStorage;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.121 -0400", hash_original_method = "F3A7583351778AC1576078A1D9F37684", hash_generated_method = "FAC7571732E99DCEEE3D2409CDAF9A0D")
    public long getMaxFileSize() {
        long var902454EC5B152CFEA9735C0AAF77CDE8_1073432943 = (mMaxFileSize);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1079977727 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1079977727;
        // ---------- Original Method ----------
        //return mMaxFileSize;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.121 -0400", hash_original_method = "3EBFC06A3F5F08EEF4400F1412AD16A4", hash_generated_method = "9DA3FCA937939C782FD8A9D75282DECE")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
        if(obj instanceof StorageVolume && mPath != null)        
        {
            StorageVolume volume = (StorageVolume)obj;
            boolean var9B8452F3AD11AF21C68F28464D024491_348128337 = ((mPath.equals(volume.mPath)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_104609772 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_104609772;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1049233351 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1876805355 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1876805355;
        // ---------- Original Method ----------
        //if (obj instanceof StorageVolume && mPath != null) {
            //StorageVolume volume = (StorageVolume)obj;
            //return (mPath.equals(volume.mPath));
        //}
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.122 -0400", hash_original_method = "828243B6D2ADC87A48F7C7C656C5F549", hash_generated_method = "C757542F843C222723D65CE5C4DD21F8")
    @Override
    public int hashCode() {
        int var91505B387843ABE5CFE8E6D2D0D4EF18_752043590 = (mPath.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1554915511 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1554915511;
        // ---------- Original Method ----------
        //return mPath.hashCode();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.122 -0400", hash_original_method = "D35752FC760ED96A302E69B1B40DBE8B", hash_generated_method = "F85AF9877E5551A87FC5038B5547488A")
    @Override
    public String toString() {
String var9443433D85C13A1FE1614AF3CE2A3CEF_1036925601 =         "StorageVolume [mAllowMassStorage=" + mAllowMassStorage + ", mDescription="
                + mDescription + ", mEmulated=" + mEmulated + ", mMaxFileSize=" + mMaxFileSize
                + ", mMtpReserveSpace=" + mMtpReserveSpace + ", mPath=" + mPath + ", mRemovable="
                + mRemovable + ", mStorageId=" + mStorageId + "]";
        var9443433D85C13A1FE1614AF3CE2A3CEF_1036925601.addTaint(taint);
        return var9443433D85C13A1FE1614AF3CE2A3CEF_1036925601;
        // ---------- Original Method ----------
        //return "StorageVolume [mAllowMassStorage=" + mAllowMassStorage + ", mDescription="
                //+ mDescription + ", mEmulated=" + mEmulated + ", mMaxFileSize=" + mMaxFileSize
                //+ ", mMtpReserveSpace=" + mMtpReserveSpace + ", mPath=" + mPath + ", mRemovable="
                //+ mRemovable + ", mStorageId=" + mStorageId + "]";
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.122 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "83FA6FC5475765EE1663F9DBDF419976")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1397873828 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1521674190 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1521674190;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.123 -0400", hash_original_method = "39BDB7739C8FE16566F7ABF501D9091E", hash_generated_method = "7DD63717C81A3DD1DB69551FB9D8E831")
    public void writeToParcel(Parcel parcel, int flags) {
        addTaint(flags);
        addTaint(parcel.getTaint());
        parcel.writeString(mPath);
        parcel.writeString(mDescription);
        parcel.writeInt(mRemovable ? 1 : 0);
        parcel.writeInt(mEmulated ? 1 : 0);
        parcel.writeInt(mStorageId);
        parcel.writeInt(mMtpReserveSpace);
        parcel.writeInt(mAllowMassStorage ? 1 : 0);
        parcel.writeLong(mMaxFileSize);
        // ---------- Original Method ----------
        //parcel.writeString(mPath);
        //parcel.writeString(mDescription);
        //parcel.writeInt(mRemovable ? 1 : 0);
        //parcel.writeInt(mEmulated ? 1 : 0);
        //parcel.writeInt(mStorageId);
        //parcel.writeInt(mMtpReserveSpace);
        //parcel.writeInt(mAllowMassStorage ? 1 : 0);
        //parcel.writeLong(mMaxFileSize);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.123 -0400", hash_original_field = "343F8010156A90E7026ADFC57F94CD29", hash_generated_field = "6BBC606274E0450337788AA972FD43E9")

    public static final String EXTRA_STORAGE_VOLUME = "storage_volume";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.123 -0400", hash_original_field = "B1E13CC914C57D7EBD0F0178A6F25232", hash_generated_field = "4E9F6CCAC70B16DA90F445ADBD0B4129")

    public static final Parcelable.Creator<StorageVolume> CREATOR =
        new Parcelable.Creator<StorageVolume>() {
        @DSModeled(DSC.BAN)
        public StorageVolume createFromParcel(Parcel in) {
            String path = in.readString();
            String description = in.readString();
            int removable = in.readInt();
            int emulated = in.readInt();
            int storageId = in.readInt();
            int mtpReserveSpace = in.readInt();
            int allowMassStorage = in.readInt();
            long maxFileSize = in.readLong();
            return new StorageVolume(path, description,
                    removable == 1, emulated == 1, mtpReserveSpace,
                    storageId, allowMassStorage == 1, maxFileSize);
        }

        @DSModeled(DSC.BAN)
        public StorageVolume[] newArray(int size) {
            return new StorageVolume[size];
        }
    };
    // orphaned legacy method
    public StorageVolume createFromParcel(Parcel in) {
            String path = in.readString();
            String description = in.readString();
            int removable = in.readInt();
            int emulated = in.readInt();
            int storageId = in.readInt();
            int mtpReserveSpace = in.readInt();
            int allowMassStorage = in.readInt();
            long maxFileSize = in.readLong();
            return new StorageVolume(path, description,
                    removable == 1, emulated == 1, mtpReserveSpace,
                    storageId, allowMassStorage == 1, maxFileSize);
        }
    
    // orphaned legacy method
    public StorageVolume[] newArray(int size) {
            return new StorageVolume[size];
        }
    
}

