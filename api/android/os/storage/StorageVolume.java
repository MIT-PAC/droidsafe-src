package android.os.storage;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;





public class StorageVolume implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:35:17.531 -0500", hash_original_field = "38E83BBE5F5664A7E7AD15D9A4DC648C", hash_generated_field = "2B4345C5FAC03D85D6460319FBA645D9")

    // ACTION_MEDIA_NOFS, ACTION_MEDIA_MOUNTED, ACTION_MEDIA_SHARED, ACTION_MEDIA_UNSHARED,
    // ACTION_MEDIA_BAD_REMOVAL, ACTION_MEDIA_UNMOUNTABLE and ACTION_MEDIA_EJECT broadcasts.
    public static final String EXTRA_STORAGE_VOLUME = "storage_volume";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.123 -0400", hash_original_field = "B1E13CC914C57D7EBD0F0178A6F25232", hash_generated_field = "4E9F6CCAC70B16DA90F445ADBD0B4129")

    public static final Parcelable.Creator<StorageVolume> CREATOR =
        new Parcelable.Creator<StorageVolume>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:38.964 -0500", hash_original_method = "A58EACE4A3F53740E5D628758A64E4CC", hash_generated_method = "9073D982142882D66A8936FA7C8E980E")
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:38.965 -0500", hash_original_method = "501B50A8C726FF3561B4BA925D06CA52", hash_generated_method = "C182E892F0B721437F069A7DDE6539E1")
        public StorageVolume[] newArray(int size) {
            return new StorageVolume[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:38.945 -0500", hash_original_field = "1D4D0FAE668EECF10ED75DDC284FFC16", hash_generated_field = "A0075230E546209E3EDB95F698912FDA")


    private final String mPath;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:38.946 -0500", hash_original_field = "6FC53B81BF2A7EC21138D42F363D7B9A", hash_generated_field = "D58E2E2E369193E8B6C54168B334B477")

    private  String mDescription;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:38.946 -0500", hash_original_field = "696798CD45B23CF8083C2B5D225854FB", hash_generated_field = "57B6957FF069933A34A8E50356617F8D")

    private  boolean mRemovable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:38.947 -0500", hash_original_field = "A5A76986A1546BE94B4091AF8E0D59F7", hash_generated_field = "FD3FCD365A89EBDB68F13FBF92695712")

    private  boolean mEmulated;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:38.948 -0500", hash_original_field = "7041EAC7943E89213ACDCEF809E1CC9E", hash_generated_field = "B9166F5568CF90E3C7F2300C3B7DA377")

    private  int mMtpReserveSpace;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:38.949 -0500", hash_original_field = "5252C25E26DF7EFAB5BAC0730B5A3989", hash_generated_field = "E13D097A35FE5501A6D0671FC135020E")

    private  boolean mAllowMassStorage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:38.950 -0500", hash_original_field = "7015602EB998005E8CF8D68C38A07905", hash_generated_field = "BE33FDB6E306D30BAB61D2858311778E")

    private int mStorageId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:38.951 -0500", hash_original_field = "B4DF076C80EC235681E863FB3B792301", hash_generated_field = "3759AF9F2CB67BE0B7EF12E3261B6410")

    private  long mMaxFileSize;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:38.953 -0500", hash_original_method = "64D7A9B637D8ABCF56CD10EE906A4905", hash_generated_method = "C126D0F51C78B6AC92B9F16DAAC15AFB")
    public StorageVolume(String path, String description, boolean removable,
            boolean emulated, int mtpReserveSpace, boolean allowMassStorage, long maxFileSize) {
        mPath = path;
        mDescription = description;
        mRemovable = removable;
        mEmulated = emulated;
        mMtpReserveSpace = mtpReserveSpace;
        mAllowMassStorage = allowMassStorage;
        mMaxFileSize = maxFileSize;
    }

    // for parcelling only
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:38.954 -0500", hash_original_method = "C6DC3558E219CD63D264358A9A1233CF", hash_generated_method = "63327E782ECC95985A3E12DCA8532007")
    private StorageVolume(String path, String description, boolean removable,
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
    }

    /**
     * Returns the mount path for the volume.
     *
     * @return the mount path
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:38.955 -0500", hash_original_method = "F177C5B02553C0E0327F321BDDCEAFD5", hash_generated_method = "737CD89E9B5A7ABC855CEA2E5A098D56")
    public String getPath() {
        return mPath;
    }

    /**
     * Returns a user visible description of the volume.
     *
     * @return the volume description
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:38.955 -0500", hash_original_method = "177DD147D2F75620FD2B154278EC57FA", hash_generated_method = "C24A704C1B7693A32CE618B690D2C768")
    public String getDescription() {
        return mDescription;
    }

    /**
     * Returns true if the volume is removable.
     *
     * @return is removable
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:38.956 -0500", hash_original_method = "C8355C5823499E966C6E9C9BBED7B59B", hash_generated_method = "9B4EC2BE6527E7B6A8E609E1AB6202B8")
    public boolean isRemovable() {
        return mRemovable;
    }

    /**
     * Returns true if the volume is emulated.
     *
     * @return is removable
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:38.957 -0500", hash_original_method = "3969E4BD26F514DAFEA3D81664C42C95", hash_generated_method = "92F4E292DE72DC250AFC04D5F9BE409A")
    public boolean isEmulated() {
        return mEmulated;
    }

    /**
     * Returns the MTP storage ID for the volume.
     * this is also used for the storage_id column in the media provider.
     *
     * @return MTP storage ID
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:38.958 -0500", hash_original_method = "D91614A87EF069B6CB0CB580F9424F2A", hash_generated_method = "BE799C52A2343EA3BAB3B52148FF7170")
    public int getStorageId() {
        return mStorageId;
    }

    /**
     * Do not call this unless you are MountService
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:38.958 -0500", hash_original_method = "DF85DF3474DF218FD90EC56A476BBB47", hash_generated_method = "750669F8B869F828EF1CAD4735C87533")
    public void setStorageId(int index) {
        // storage ID is 0x00010001 for primary storage,
        // then 0x00020001, 0x00030001, etc. for secondary storages
        mStorageId = ((index + 1) << 16) + 1;
    }

    /**
     * Number of megabytes of space to leave unallocated by MTP.
     * MTP will subtract this value from the free space it reports back
     * to the host via GetStorageInfo, and will not allow new files to
     * be added via MTP if there is less than this amount left free in the storage.
     * If MTP has dedicated storage this value should be zero, but if MTP is
     * sharing storage with the rest of the system, set this to a positive value
     * to ensure that MTP activity does not result in the storage being
     * too close to full.
     *
     * @return MTP reserve space
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:38.959 -0500", hash_original_method = "AD5CC5267CED7BD79E23E2B3D995596D", hash_generated_method = "CF3C1925F85F93939C615ABA8073DC7E")
    public int getMtpReserveSpace() {
        return mMtpReserveSpace;
    }

    /**
     * Returns true if this volume can be shared via USB mass storage.
     *
     * @return whether mass storage is allowed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:38.960 -0500", hash_original_method = "70EAD3302E25E04AF22ADA1536C85D6E", hash_generated_method = "A8674915D5E39BE837C95C2863FD04C6")
    public boolean allowMassStorage() {
        return mAllowMassStorage;
    }

    /**
     * Returns maximum file size for the volume, or zero if it is unbounded.
     *
     * @return maximum file size
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:38.961 -0500", hash_original_method = "F3A7583351778AC1576078A1D9F37684", hash_generated_method = "22342D3197EC7B5656813A600C785D5C")
    public long getMaxFileSize() {
        return mMaxFileSize;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:38.961 -0500", hash_original_method = "3EBFC06A3F5F08EEF4400F1412AD16A4", hash_generated_method = "E50490DFFECEEB3811D693F1B505CB03")
    @Override
public boolean equals(Object obj) {
        if (obj instanceof StorageVolume && mPath != null) {
            StorageVolume volume = (StorageVolume)obj;
            return (mPath.equals(volume.mPath));
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:38.962 -0500", hash_original_method = "828243B6D2ADC87A48F7C7C656C5F549", hash_generated_method = "3D2EBE5E021F36DCEF2A365F63DCB28F")
    @Override
public int hashCode() {
        return mPath.hashCode();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:38.963 -0500", hash_original_method = "D35752FC760ED96A302E69B1B40DBE8B", hash_generated_method = "300755C46EC0D8C1DC1CF627F784DD41")
    @Override
public String toString() {
        return "StorageVolume [mAllowMassStorage=" + mAllowMassStorage + ", mDescription="
                + mDescription + ", mEmulated=" + mEmulated + ", mMaxFileSize=" + mMaxFileSize
                + ", mMtpReserveSpace=" + mMtpReserveSpace + ", mPath=" + mPath + ", mRemovable="
                + mRemovable + ", mStorageId=" + mStorageId + "]";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:38.967 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:38.968 -0500", hash_original_method = "39BDB7739C8FE16566F7ABF501D9091E", hash_generated_method = "464CAA15AF9A0E03CEAF74C57057DE88")
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(mPath);
        parcel.writeString(mDescription);
        parcel.writeInt(mRemovable ? 1 : 0);
        parcel.writeInt(mEmulated ? 1 : 0);
        parcel.writeInt(mStorageId);
        parcel.writeInt(mMtpReserveSpace);
        parcel.writeInt(mAllowMassStorage ? 1 : 0);
        parcel.writeLong(mMaxFileSize);
    }
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

