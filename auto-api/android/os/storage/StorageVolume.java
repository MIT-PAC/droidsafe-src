package android.os.storage;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

public class StorageVolume implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.745 -0400", hash_original_field = "FB4FCB3508FC66D4E3F113990AC335C6", hash_generated_field = "6FACC3B41470C8330B5F0BB43FA7FD9F")

    private String mPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.745 -0400", hash_original_field = "FF2B9B684DDD70D7BE468C8D9A54343D", hash_generated_field = "D58E2E2E369193E8B6C54168B334B477")

    private String mDescription;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.745 -0400", hash_original_field = "BA2C430BDE7AD99954A160F0B96DA6E4", hash_generated_field = "57B6957FF069933A34A8E50356617F8D")

    private boolean mRemovable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.745 -0400", hash_original_field = "BB81BAE7E9AD52D1C2A9CFC73AB6E39F", hash_generated_field = "FD3FCD365A89EBDB68F13FBF92695712")

    private boolean mEmulated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.745 -0400", hash_original_field = "44CF13B011CB07C962C5DA973669BEB6", hash_generated_field = "B9166F5568CF90E3C7F2300C3B7DA377")

    private int mMtpReserveSpace;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.745 -0400", hash_original_field = "570ECAEBA3421EAED0D3DCFAEDD80845", hash_generated_field = "E13D097A35FE5501A6D0671FC135020E")

    private boolean mAllowMassStorage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.745 -0400", hash_original_field = "A211BEEE10AFE736EE5E9E3E7140A322", hash_generated_field = "BE33FDB6E306D30BAB61D2858311778E")

    private int mStorageId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.745 -0400", hash_original_field = "902454EC5B152CFEA9735C0AAF77CDE8", hash_generated_field = "3759AF9F2CB67BE0B7EF12E3261B6410")

    private long mMaxFileSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.751 -0400", hash_original_method = "64D7A9B637D8ABCF56CD10EE906A4905", hash_generated_method = "81313F5D3A30294AF7A1432AB6ECE6C7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.753 -0400", hash_original_method = "C6DC3558E219CD63D264358A9A1233CF", hash_generated_method = "DA958F3A8D6B6A18BBD14EFFE081EDC7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.757 -0400", hash_original_method = "F177C5B02553C0E0327F321BDDCEAFD5", hash_generated_method = "AC308FA2B1FA6CEB218F53AA8470EE4E")
    public String getPath() {
        String varB4EAC82CA7396A68D541C85D26508E83_388740519 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_388740519 = mPath;
        varB4EAC82CA7396A68D541C85D26508E83_388740519.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_388740519;
        // ---------- Original Method ----------
        //return mPath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.758 -0400", hash_original_method = "177DD147D2F75620FD2B154278EC57FA", hash_generated_method = "A1FF7A8EF9811C561DA539339E8942AF")
    public String getDescription() {
        String varB4EAC82CA7396A68D541C85D26508E83_1047062827 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1047062827 = mDescription;
        varB4EAC82CA7396A68D541C85D26508E83_1047062827.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1047062827;
        // ---------- Original Method ----------
        //return mDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.758 -0400", hash_original_method = "C8355C5823499E966C6E9C9BBED7B59B", hash_generated_method = "E08656F015161727BC0878A98FCC6E7D")
    public boolean isRemovable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1118476113 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1118476113;
        // ---------- Original Method ----------
        //return mRemovable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.767 -0400", hash_original_method = "3969E4BD26F514DAFEA3D81664C42C95", hash_generated_method = "4E2926366684B6E2CF3103425BCE74F2")
    public boolean isEmulated() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_192265304 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_192265304;
        // ---------- Original Method ----------
        //return mEmulated;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.767 -0400", hash_original_method = "D91614A87EF069B6CB0CB580F9424F2A", hash_generated_method = "C6880E389DC35F12FD5F15F16FE12A78")
    public int getStorageId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_791407355 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_791407355;
        // ---------- Original Method ----------
        //return mStorageId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.774 -0400", hash_original_method = "DF85DF3474DF218FD90EC56A476BBB47", hash_generated_method = "F681C9EB234C13040C7D4D682143B82F")
    public void setStorageId(int index) {
        mStorageId = ((index + 1) << 16) + 1;
        // ---------- Original Method ----------
        //mStorageId = ((index + 1) << 16) + 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.775 -0400", hash_original_method = "AD5CC5267CED7BD79E23E2B3D995596D", hash_generated_method = "BCA54D02FACEC449C4949AE6A2CB593C")
    public int getMtpReserveSpace() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1691209297 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1691209297;
        // ---------- Original Method ----------
        //return mMtpReserveSpace;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.775 -0400", hash_original_method = "70EAD3302E25E04AF22ADA1536C85D6E", hash_generated_method = "E2D42931574E94E28E07EB1F67971E62")
    public boolean allowMassStorage() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1446790265 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1446790265;
        // ---------- Original Method ----------
        //return mAllowMassStorage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.794 -0400", hash_original_method = "F3A7583351778AC1576078A1D9F37684", hash_generated_method = "E20C29B62B9842CA3FC479B4E59CC62D")
    public long getMaxFileSize() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_404612238 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_404612238;
        // ---------- Original Method ----------
        //return mMaxFileSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.795 -0400", hash_original_method = "3EBFC06A3F5F08EEF4400F1412AD16A4", hash_generated_method = "06D802F01456C580DFE345066ED11D5F")
    @Override
    public boolean equals(Object obj) {
        {
            StorageVolume volume;
            volume = (StorageVolume)obj;
            boolean var7864F794FC2EA795D75B513E41072C78_2123633397 = ((mPath.equals(volume.mPath)));
        } //End block
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1995340609 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1995340609;
        // ---------- Original Method ----------
        //if (obj instanceof StorageVolume && mPath != null) {
            //StorageVolume volume = (StorageVolume)obj;
            //return (mPath.equals(volume.mPath));
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.795 -0400", hash_original_method = "828243B6D2ADC87A48F7C7C656C5F549", hash_generated_method = "ED78ACB697A5524C2DABCFF520444D9A")
    @Override
    public int hashCode() {
        int varF587C360B64C6313E1A58AC2DDD30596_875930533 = (mPath.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_198267760 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_198267760;
        // ---------- Original Method ----------
        //return mPath.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.796 -0400", hash_original_method = "D35752FC760ED96A302E69B1B40DBE8B", hash_generated_method = "143A9781B7C7096CECB25FE924AACE8C")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1152633307 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1152633307 = "StorageVolume [mAllowMassStorage=" + mAllowMassStorage + ", mDescription="
                + mDescription + ", mEmulated=" + mEmulated + ", mMaxFileSize=" + mMaxFileSize
                + ", mMtpReserveSpace=" + mMtpReserveSpace + ", mPath=" + mPath + ", mRemovable="
                + mRemovable + ", mStorageId=" + mStorageId + "]";
        varB4EAC82CA7396A68D541C85D26508E83_1152633307.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1152633307;
        // ---------- Original Method ----------
        //return "StorageVolume [mAllowMassStorage=" + mAllowMassStorage + ", mDescription="
                //+ mDescription + ", mEmulated=" + mEmulated + ", mMaxFileSize=" + mMaxFileSize
                //+ ", mMtpReserveSpace=" + mMtpReserveSpace + ", mPath=" + mPath + ", mRemovable="
                //+ mRemovable + ", mStorageId=" + mStorageId + "]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.796 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "B10B1DF2D16830772C939F7E05FF9DEC")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1220137604 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1220137604;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.800 -0400", hash_original_method = "39BDB7739C8FE16566F7ABF501D9091E", hash_generated_method = "62B80328C1FEA6B0D5D8CB76AFF4DA01")
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(mPath);
        parcel.writeString(mDescription);
        parcel.writeInt(mRemovable ? 1 : 0);
        parcel.writeInt(mEmulated ? 1 : 0);
        parcel.writeInt(mStorageId);
        parcel.writeInt(mMtpReserveSpace);
        parcel.writeInt(mAllowMassStorage ? 1 : 0);
        parcel.writeLong(mMaxFileSize);
        addTaint(parcel.getTaint());
        addTaint(flags);
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.800 -0400", hash_original_field = "343F8010156A90E7026ADFC57F94CD29", hash_generated_field = "6BBC606274E0450337788AA972FD43E9")

    public static final String EXTRA_STORAGE_VOLUME = "storage_volume";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.800 -0400", hash_original_field = "B1E13CC914C57D7EBD0F0178A6F25232", hash_generated_field = "4E9F6CCAC70B16DA90F445ADBD0B4129")

    public static final Parcelable.Creator<StorageVolume> CREATOR =
        new Parcelable.Creator<StorageVolume>() {
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

        public StorageVolume[] newArray(int size) {
            return new StorageVolume[size];
        }
    };
}

