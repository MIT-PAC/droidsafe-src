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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.992 -0400", hash_original_field = "FB4FCB3508FC66D4E3F113990AC335C6", hash_generated_field = "6FACC3B41470C8330B5F0BB43FA7FD9F")

    private String mPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.992 -0400", hash_original_field = "FF2B9B684DDD70D7BE468C8D9A54343D", hash_generated_field = "D58E2E2E369193E8B6C54168B334B477")

    private String mDescription;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.992 -0400", hash_original_field = "BA2C430BDE7AD99954A160F0B96DA6E4", hash_generated_field = "57B6957FF069933A34A8E50356617F8D")

    private boolean mRemovable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.992 -0400", hash_original_field = "BB81BAE7E9AD52D1C2A9CFC73AB6E39F", hash_generated_field = "FD3FCD365A89EBDB68F13FBF92695712")

    private boolean mEmulated;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.992 -0400", hash_original_field = "44CF13B011CB07C962C5DA973669BEB6", hash_generated_field = "B9166F5568CF90E3C7F2300C3B7DA377")

    private int mMtpReserveSpace;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.992 -0400", hash_original_field = "570ECAEBA3421EAED0D3DCFAEDD80845", hash_generated_field = "E13D097A35FE5501A6D0671FC135020E")

    private boolean mAllowMassStorage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.993 -0400", hash_original_field = "A211BEEE10AFE736EE5E9E3E7140A322", hash_generated_field = "BE33FDB6E306D30BAB61D2858311778E")

    private int mStorageId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.993 -0400", hash_original_field = "902454EC5B152CFEA9735C0AAF77CDE8", hash_generated_field = "3759AF9F2CB67BE0B7EF12E3261B6410")

    private long mMaxFileSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.994 -0400", hash_original_method = "64D7A9B637D8ABCF56CD10EE906A4905", hash_generated_method = "81313F5D3A30294AF7A1432AB6ECE6C7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.016 -0400", hash_original_method = "C6DC3558E219CD63D264358A9A1233CF", hash_generated_method = "DA958F3A8D6B6A18BBD14EFFE081EDC7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.018 -0400", hash_original_method = "F177C5B02553C0E0327F321BDDCEAFD5", hash_generated_method = "49E32619B4B9852A63279304EA496B14")
    public String getPath() {
        String varB4EAC82CA7396A68D541C85D26508E83_1644555759 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1644555759 = mPath;
        varB4EAC82CA7396A68D541C85D26508E83_1644555759.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1644555759;
        // ---------- Original Method ----------
        //return mPath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.019 -0400", hash_original_method = "177DD147D2F75620FD2B154278EC57FA", hash_generated_method = "5854F7995BB80067B937D0A2DF9AEF96")
    public String getDescription() {
        String varB4EAC82CA7396A68D541C85D26508E83_845321936 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_845321936 = mDescription;
        varB4EAC82CA7396A68D541C85D26508E83_845321936.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_845321936;
        // ---------- Original Method ----------
        //return mDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.019 -0400", hash_original_method = "C8355C5823499E966C6E9C9BBED7B59B", hash_generated_method = "7F469D4A6598EB030C45C86971A11BB9")
    public boolean isRemovable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1061132930 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1061132930;
        // ---------- Original Method ----------
        //return mRemovable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.025 -0400", hash_original_method = "3969E4BD26F514DAFEA3D81664C42C95", hash_generated_method = "A848257F92F24B5370CF3524B8C89A65")
    public boolean isEmulated() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1471680104 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1471680104;
        // ---------- Original Method ----------
        //return mEmulated;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.025 -0400", hash_original_method = "D91614A87EF069B6CB0CB580F9424F2A", hash_generated_method = "A07E792D6B104F70422723BD68F39AF1")
    public int getStorageId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_734038989 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_734038989;
        // ---------- Original Method ----------
        //return mStorageId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.041 -0400", hash_original_method = "DF85DF3474DF218FD90EC56A476BBB47", hash_generated_method = "F681C9EB234C13040C7D4D682143B82F")
    public void setStorageId(int index) {
        mStorageId = ((index + 1) << 16) + 1;
        // ---------- Original Method ----------
        //mStorageId = ((index + 1) << 16) + 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.041 -0400", hash_original_method = "AD5CC5267CED7BD79E23E2B3D995596D", hash_generated_method = "3975CA26A7FD5A3A22A4FF09C42A3FCC")
    public int getMtpReserveSpace() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_253649692 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_253649692;
        // ---------- Original Method ----------
        //return mMtpReserveSpace;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.042 -0400", hash_original_method = "70EAD3302E25E04AF22ADA1536C85D6E", hash_generated_method = "AE77415C3E35CC1B805B476469B33774")
    public boolean allowMassStorage() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_455962105 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_455962105;
        // ---------- Original Method ----------
        //return mAllowMassStorage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.042 -0400", hash_original_method = "F3A7583351778AC1576078A1D9F37684", hash_generated_method = "3C3D98294308993D0121AFA5814F83FA")
    public long getMaxFileSize() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1618300490 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1618300490;
        // ---------- Original Method ----------
        //return mMaxFileSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.043 -0400", hash_original_method = "3EBFC06A3F5F08EEF4400F1412AD16A4", hash_generated_method = "E366850E90C16E6A3FE3D112B9D3BED3")
    @Override
    public boolean equals(Object obj) {
        {
            StorageVolume volume;
            volume = (StorageVolume)obj;
            boolean var7864F794FC2EA795D75B513E41072C78_1365538505 = ((mPath.equals(volume.mPath)));
        } //End block
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_417377678 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_417377678;
        // ---------- Original Method ----------
        //if (obj instanceof StorageVolume && mPath != null) {
            //StorageVolume volume = (StorageVolume)obj;
            //return (mPath.equals(volume.mPath));
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.051 -0400", hash_original_method = "828243B6D2ADC87A48F7C7C656C5F549", hash_generated_method = "38BAE1509A670621596CDB27ABF3D4BC")
    @Override
    public int hashCode() {
        int varF587C360B64C6313E1A58AC2DDD30596_1515664025 = (mPath.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_496502789 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_496502789;
        // ---------- Original Method ----------
        //return mPath.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.052 -0400", hash_original_method = "D35752FC760ED96A302E69B1B40DBE8B", hash_generated_method = "A6D53BF81B619DD96354A8B61B79CD24")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2025777020 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2025777020 = "StorageVolume [mAllowMassStorage=" + mAllowMassStorage + ", mDescription="
                + mDescription + ", mEmulated=" + mEmulated + ", mMaxFileSize=" + mMaxFileSize
                + ", mMtpReserveSpace=" + mMtpReserveSpace + ", mPath=" + mPath + ", mRemovable="
                + mRemovable + ", mStorageId=" + mStorageId + "]";
        varB4EAC82CA7396A68D541C85D26508E83_2025777020.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2025777020;
        // ---------- Original Method ----------
        //return "StorageVolume [mAllowMassStorage=" + mAllowMassStorage + ", mDescription="
                //+ mDescription + ", mEmulated=" + mEmulated + ", mMaxFileSize=" + mMaxFileSize
                //+ ", mMtpReserveSpace=" + mMtpReserveSpace + ", mPath=" + mPath + ", mRemovable="
                //+ mRemovable + ", mStorageId=" + mStorageId + "]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.065 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "AF8535B21D42D04C1674AC10373B0A36")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_671473362 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_671473362;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.088 -0400", hash_original_method = "39BDB7739C8FE16566F7ABF501D9091E", hash_generated_method = "62B80328C1FEA6B0D5D8CB76AFF4DA01")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.088 -0400", hash_original_field = "343F8010156A90E7026ADFC57F94CD29", hash_generated_field = "6BBC606274E0450337788AA972FD43E9")

    public static final String EXTRA_STORAGE_VOLUME = "storage_volume";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:29.088 -0400", hash_original_field = "B1E13CC914C57D7EBD0F0178A6F25232", hash_generated_field = "4E9F6CCAC70B16DA90F445ADBD0B4129")

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

