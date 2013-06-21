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
    private String mPath;
    private String mDescription;
    private boolean mRemovable;
    private boolean mEmulated;
    private int mMtpReserveSpace;
    private boolean mAllowMassStorage;
    private int mStorageId;
    private long mMaxFileSize;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.532 -0400", hash_original_method = "64D7A9B637D8ABCF56CD10EE906A4905", hash_generated_method = "A7E9E510E46740246445B0F22D65BE30")
    @DSModeled(DSC.SAFE)
    public StorageVolume(String path, String description, boolean removable,
            boolean emulated, int mtpReserveSpace, boolean allowMassStorage, long maxFileSize) {
        dsTaint.addTaint(description);
        dsTaint.addTaint(allowMassStorage);
        dsTaint.addTaint(removable);
        dsTaint.addTaint(emulated);
        dsTaint.addTaint(path);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.533 -0400", hash_original_method = "C6DC3558E219CD63D264358A9A1233CF", hash_generated_method = "378E64D3DA78A09174B1B8A5A2BAD7A7")
    @DSModeled(DSC.SAFE)
    private StorageVolume(String path, String description, boolean removable,
            boolean emulated, int mtpReserveSpace, int storageId,
            boolean allowMassStorage, long maxFileSize) {
        dsTaint.addTaint(description);
        dsTaint.addTaint(allowMassStorage);
        dsTaint.addTaint(removable);
        dsTaint.addTaint(emulated);
        dsTaint.addTaint(path);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.534 -0400", hash_original_method = "F177C5B02553C0E0327F321BDDCEAFD5", hash_generated_method = "29CB1D5263B4158A2D31F23885A43F10")
    @DSModeled(DSC.SAFE)
    public String getPath() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPath;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.535 -0400", hash_original_method = "177DD147D2F75620FD2B154278EC57FA", hash_generated_method = "BC3429D7F0ECDAE789A87366823AC07A")
    @DSModeled(DSC.SAFE)
    public String getDescription() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.535 -0400", hash_original_method = "C8355C5823499E966C6E9C9BBED7B59B", hash_generated_method = "96E15464EA25326C14294CBE65E30449")
    @DSModeled(DSC.SAFE)
    public boolean isRemovable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mRemovable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.535 -0400", hash_original_method = "3969E4BD26F514DAFEA3D81664C42C95", hash_generated_method = "492CDF52CF6F23C454462FF66BEF12D3")
    @DSModeled(DSC.SAFE)
    public boolean isEmulated() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mEmulated;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.535 -0400", hash_original_method = "D91614A87EF069B6CB0CB580F9424F2A", hash_generated_method = "5402CDAA18DB72FACA9F54C8FE08CD46")
    @DSModeled(DSC.SAFE)
    public int getStorageId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mStorageId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.536 -0400", hash_original_method = "DF85DF3474DF218FD90EC56A476BBB47", hash_generated_method = "A75D0B5BBCFE97F9AE31633D27E6E57A")
    @DSModeled(DSC.SAFE)
    public void setStorageId(int index) {
        dsTaint.addTaint(index);
        mStorageId = ((index + 1) << 16) + 1;
        // ---------- Original Method ----------
        //mStorageId = ((index + 1) << 16) + 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.536 -0400", hash_original_method = "AD5CC5267CED7BD79E23E2B3D995596D", hash_generated_method = "A80E02A711FD53028BE4F64CE6EAD48E")
    @DSModeled(DSC.SAFE)
    public int getMtpReserveSpace() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mMtpReserveSpace;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.536 -0400", hash_original_method = "70EAD3302E25E04AF22ADA1536C85D6E", hash_generated_method = "14A85B9CFBEB0C9AD5A4A2292F483290")
    @DSModeled(DSC.SAFE)
    public boolean allowMassStorage() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAllowMassStorage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.536 -0400", hash_original_method = "F3A7583351778AC1576078A1D9F37684", hash_generated_method = "BDE9800A7F191A4FF7CCD11CF7C25C15")
    @DSModeled(DSC.SAFE)
    public long getMaxFileSize() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return mMaxFileSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.537 -0400", hash_original_method = "3EBFC06A3F5F08EEF4400F1412AD16A4", hash_generated_method = "CAD34D39D8E5AD5C55F412A521539FEE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        {
            StorageVolume volume;
            volume = (StorageVolume)obj;
            boolean var7864F794FC2EA795D75B513E41072C78_1491580304 = ((mPath.equals(volume.mPath)));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (obj instanceof StorageVolume && mPath != null) {
            //StorageVolume volume = (StorageVolume)obj;
            //return (mPath.equals(volume.mPath));
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.537 -0400", hash_original_method = "828243B6D2ADC87A48F7C7C656C5F549", hash_generated_method = "03C49C65B7DB90EC54542BAB36B5DEFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int varF587C360B64C6313E1A58AC2DDD30596_904269150 = (mPath.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPath.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.537 -0400", hash_original_method = "D35752FC760ED96A302E69B1B40DBE8B", hash_generated_method = "2E2BB4204B297E9714D673622EE99CA8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.537 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.538 -0400", hash_original_method = "39BDB7739C8FE16566F7ABF501D9091E", hash_generated_method = "DB122EEDD217F61930499FD2AB30B1AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    public static final String EXTRA_STORAGE_VOLUME = "storage_volume";
    public static final Parcelable.Creator<StorageVolume> CREATOR = new Parcelable.Creator<StorageVolume>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.538 -0400", hash_original_method = "A58EACE4A3F53740E5D628758A64E4CC", hash_generated_method = "E40DA270BF53D7E636BD7899627C68BD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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
            StorageVolume varB451F41178DBF566365E180CE638C770_110369698 = (new StorageVolume(path, description,
                    removable == 1, emulated == 1, mtpReserveSpace,
                    storageId, allowMassStorage == 1, maxFileSize));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.538 -0400", hash_original_method = "501B50A8C726FF3561B4BA925D06CA52", hash_generated_method = "658372DFFBCF7CCA11449D039F4022C8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public StorageVolume[] newArray(int size) {
            dsTaint.addTaint(size);
            StorageVolume[] varCEF69DCA1CB4B7505FE892D6CFFD5CE2_1385053596 = (new StorageVolume[size]);
            return (StorageVolume[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new StorageVolume[size];
        }

        
}; //Transformed anonymous class
}

