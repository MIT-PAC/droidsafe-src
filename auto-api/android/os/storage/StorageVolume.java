package android.os.storage;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Parcel;
import android.os.Parcelable;

public class StorageVolume implements Parcelable {
    private final String mPath;
    private final String mDescription;
    private final boolean mRemovable;
    private final boolean mEmulated;
    private final int mMtpReserveSpace;
    private final boolean mAllowMassStorage;
    private int mStorageId;
    private final long mMaxFileSize;
    public static final String EXTRA_STORAGE_VOLUME = "storage_volume";
    public static final Parcelable.Creator<StorageVolume> CREATOR = new Parcelable.Creator<StorageVolume>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.964 -0400", hash_original_method = "A58EACE4A3F53740E5D628758A64E4CC", hash_generated_method = "434D8965FB38D7889DE92198B9674F35")
        @DSModeled(DSC.SAFE)
        public StorageVolume createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            String path;
            path = in.readString();
            String description;
            description = in.readString();
            int removable;
            removable = in.readInt();
            int emulated;
            emulated = in.readInt();
            int storageId;
            storageId = in.readInt();
            int mtpReserveSpace;
            mtpReserveSpace = in.readInt();
            int allowMassStorage;
            allowMassStorage = in.readInt();
            long maxFileSize;
            maxFileSize = in.readLong();
            return (StorageVolume)dsTaint.getTaint();
            // ---------- Original Method ----------
            //String path = in.readString();
            //String description = in.readString();
            //int removable = in.readInt();
            //int emulated = in.readInt();
            //int storageId = in.readInt();
            //int mtpReserveSpace = in.readInt();
            //int allowMassStorage = in.readInt();
            //long maxFileSize = in.readLong();
            //return new StorageVolume(path, description,
                    //removable == 1, emulated == 1, mtpReserveSpace,
                    //storageId, allowMassStorage == 1, maxFileSize);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.964 -0400", hash_original_method = "501B50A8C726FF3561B4BA925D06CA52", hash_generated_method = "1341FE08A9DCADA75FE26F397DFB9CE8")
        @DSModeled(DSC.SAFE)
        public StorageVolume[] newArray(int size) {
            dsTaint.addTaint(size);
            return (StorageVolume[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new StorageVolume[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.965 -0400", hash_original_method = "64D7A9B637D8ABCF56CD10EE906A4905", hash_generated_method = "F12E9283FC41B56EDD5D195FD47BD384")
    @DSModeled(DSC.SAFE)
    public StorageVolume(String path, String description, boolean removable,
            boolean emulated, int mtpReserveSpace, boolean allowMassStorage, long maxFileSize) {
        dsTaint.addTaint(description);
        dsTaint.addTaint(removable);
        dsTaint.addTaint(allowMassStorage);
        dsTaint.addTaint(path);
        dsTaint.addTaint(emulated);
        dsTaint.addTaint(mtpReserveSpace);
        dsTaint.addTaint(maxFileSize);
        // ---------- Original Method ----------
        //mPath = path;
        //mDescription = description;
        //mRemovable = removable;
        //mEmulated = emulated;
        //mMtpReserveSpace = mtpReserveSpace;
        //mAllowMassStorage = allowMassStorage;
        //mMaxFileSize = maxFileSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.965 -0400", hash_original_method = "C6DC3558E219CD63D264358A9A1233CF", hash_generated_method = "0C047971A49E0F0B99094959D3322D24")
    @DSModeled(DSC.SAFE)
    private StorageVolume(String path, String description, boolean removable,
            boolean emulated, int mtpReserveSpace, int storageId,
            boolean allowMassStorage, long maxFileSize) {
        dsTaint.addTaint(description);
        dsTaint.addTaint(removable);
        dsTaint.addTaint(allowMassStorage);
        dsTaint.addTaint(path);
        dsTaint.addTaint(emulated);
        dsTaint.addTaint(mtpReserveSpace);
        dsTaint.addTaint(maxFileSize);
        dsTaint.addTaint(storageId);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.965 -0400", hash_original_method = "F177C5B02553C0E0327F321BDDCEAFD5", hash_generated_method = "071B9412F7BB449BC4D5A63AC6B70725")
    @DSModeled(DSC.SAFE)
    public String getPath() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.965 -0400", hash_original_method = "177DD147D2F75620FD2B154278EC57FA", hash_generated_method = "AD5DE9BBF158FCF5DC5329F0202539C6")
    @DSModeled(DSC.SAFE)
    public String getDescription() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.965 -0400", hash_original_method = "C8355C5823499E966C6E9C9BBED7B59B", hash_generated_method = "EA87FDAC3F03DBAB428C8A2AD02CD900")
    @DSModeled(DSC.SAFE)
    public boolean isRemovable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mRemovable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.965 -0400", hash_original_method = "3969E4BD26F514DAFEA3D81664C42C95", hash_generated_method = "A196E4032D73A64B8F8E3E7530F62E81")
    @DSModeled(DSC.SAFE)
    public boolean isEmulated() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mEmulated;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.965 -0400", hash_original_method = "D91614A87EF069B6CB0CB580F9424F2A", hash_generated_method = "743453BC5EA98C2755E5700C916E3103")
    @DSModeled(DSC.SAFE)
    public int getStorageId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mStorageId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.965 -0400", hash_original_method = "DF85DF3474DF218FD90EC56A476BBB47", hash_generated_method = "BA23B25D94871214F70D9C41C7CFCC8D")
    @DSModeled(DSC.SAFE)
    public void setStorageId(int index) {
        dsTaint.addTaint(index);
        mStorageId = ((index + 1) << 16) + 1;
        // ---------- Original Method ----------
        //mStorageId = ((index + 1) << 16) + 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.966 -0400", hash_original_method = "AD5CC5267CED7BD79E23E2B3D995596D", hash_generated_method = "14A444E1B789C067B35BBAFBF7542306")
    @DSModeled(DSC.SAFE)
    public int getMtpReserveSpace() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMtpReserveSpace;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.966 -0400", hash_original_method = "70EAD3302E25E04AF22ADA1536C85D6E", hash_generated_method = "3C771F3370015F7B5399D4D721483EC2")
    @DSModeled(DSC.SAFE)
    public boolean allowMassStorage() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAllowMassStorage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.966 -0400", hash_original_method = "F3A7583351778AC1576078A1D9F37684", hash_generated_method = "E1DB37734D3FB24B65B0A951E9A752F9")
    @DSModeled(DSC.SAFE)
    public long getMaxFileSize() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mMaxFileSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.966 -0400", hash_original_method = "3EBFC06A3F5F08EEF4400F1412AD16A4", hash_generated_method = "70758A603DCB2C24E5E8E1810043423A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        {
            StorageVolume volume;
            volume = (StorageVolume)obj;
            boolean var7864F794FC2EA795D75B513E41072C78_1274623970 = ((mPath.equals(volume.mPath)));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (obj instanceof StorageVolume && mPath != null) {
            //StorageVolume volume = (StorageVolume)obj;
            //return (mPath.equals(volume.mPath));
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.966 -0400", hash_original_method = "828243B6D2ADC87A48F7C7C656C5F549", hash_generated_method = "D46D1CAAF6867B0F1EFC8599F91351FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int varF587C360B64C6313E1A58AC2DDD30596_1141494220 = (mPath.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPath.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.966 -0400", hash_original_method = "D35752FC760ED96A302E69B1B40DBE8B", hash_generated_method = "4E8FD2A023F208641C2A32E355FDEBC2")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "StorageVolume [mAllowMassStorage=" + mAllowMassStorage + ", mDescription="
                //+ mDescription + ", mEmulated=" + mEmulated + ", mMaxFileSize=" + mMaxFileSize
                //+ ", mMtpReserveSpace=" + mMtpReserveSpace + ", mPath=" + mPath + ", mRemovable="
                //+ mRemovable + ", mStorageId=" + mStorageId + "]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.966 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.966 -0400", hash_original_method = "39BDB7739C8FE16566F7ABF501D9091E", hash_generated_method = "3EDC375B0F005933126F72F37343C793")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel parcel, int flags) {
        dsTaint.addTaint(parcel.dsTaint);
        dsTaint.addTaint(flags);
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

    
}


