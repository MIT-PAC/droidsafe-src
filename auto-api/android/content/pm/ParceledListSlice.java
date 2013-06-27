package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class ParceledListSlice<T extends Parcelable> implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:03.098 -0400", hash_original_field = "4FCFEE3D082C4C61BD6B374EB2663F5D", hash_generated_field = "FECF2C1F375A3EF42076236F811E3099")

    private Parcel mParcel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:03.098 -0400", hash_original_field = "83695530A023F264DDB652781BA187D4", hash_generated_field = "BA3C2AEB1D951CD4DD5338E0704AB3BD")

    private int mNumItems;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:03.098 -0400", hash_original_field = "4A05E03E5F8F12BD83251DE71259F835", hash_generated_field = "EC008E3F2DC15587B7C3DF28445187C5")

    private boolean mIsLastSlice;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:03.106 -0400", hash_original_method = "24B996F8F50716248E38E24116049A17", hash_generated_method = "1887BA279D0200732AFFAF5AF7BA7C32")
    public  ParceledListSlice() {
        mParcel = Parcel.obtain();
        // ---------- Original Method ----------
        //mParcel = Parcel.obtain();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:03.107 -0400", hash_original_method = "EA156AE64DA15F3296203897A2798D45", hash_generated_method = "F635FE86E5D41FC3A680E8C152909E12")
    private  ParceledListSlice(Parcel p, int numItems, boolean lastSlice) {
        mParcel = p;
        mNumItems = numItems;
        mIsLastSlice = lastSlice;
        // ---------- Original Method ----------
        //mParcel = p;
        //mNumItems = numItems;
        //mIsLastSlice = lastSlice;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:03.114 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "353E5ADED9DB4FFB9C112CDE63B66602")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1888203762 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1888203762;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:03.116 -0400", hash_original_method = "757A8AA414BA94194408A3738A93F76D", hash_generated_method = "7D4C49B7F4718FFCAFF2F58C1DB3B3A7")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mNumItems);
        dest.writeInt(mIsLastSlice ? 1 : 0);
        {
            int parcelSize;
            parcelSize = mParcel.dataSize();
            dest.writeInt(parcelSize);
            dest.appendFrom(mParcel, 0, parcelSize);
        } //End block
        mNumItems = 0;
        mParcel.recycle();
        mParcel = null;
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeInt(mNumItems);
        //dest.writeInt(mIsLastSlice ? 1 : 0);
        //if (mNumItems > 0) {
            //final int parcelSize = mParcel.dataSize();
            //dest.writeInt(parcelSize);
            //dest.appendFrom(mParcel, 0, parcelSize);
        //}
        //mNumItems = 0;
        //mParcel.recycle();
        //mParcel = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:03.137 -0400", hash_original_method = "1E56C806D3B84E35689447C22D535D39", hash_generated_method = "51765C68BFEE10D4D2EE9925A59804EE")
    public boolean append(T item) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("ParceledListSlice has already been recycled");
        } //End block
        item.writeToParcel(mParcel, PARCELABLE_WRITE_RETURN_VALUE);
        boolean var78C40EDF2EC647D907DA51ADE7761B31_1562340675 = (mParcel.dataSize() > MAX_IPC_SIZE);
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1010750180 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1010750180;
        // ---------- Original Method ----------
        //if (mParcel == null) {
            //throw new IllegalStateException("ParceledListSlice has already been recycled");
        //}
        //item.writeToParcel(mParcel, PARCELABLE_WRITE_RETURN_VALUE);
        //mNumItems++;
        //return mParcel.dataSize() > MAX_IPC_SIZE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:03.140 -0400", hash_original_method = "C11B1153BF8BCDA44C4073AC785F824F", hash_generated_method = "5FA15A71E571A82143BF3D79D6BB817E")
    public T populateList(List<T> list, Creator<T> creator) {
        T varB4EAC82CA7396A68D541C85D26508E83_496630104 = null; //Variable for return #1
        mParcel.setDataPosition(0);
        T item;
        item = null;
        {
            int i;
            i = 0;
            {
                item = creator.createFromParcel(mParcel);
                list.add(item);
            } //End block
        } //End collapsed parenthetic
        mParcel.recycle();
        mParcel = null;
        varB4EAC82CA7396A68D541C85D26508E83_496630104 = item;
        addTaint(list.getTaint());
        addTaint(creator.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_496630104.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_496630104;
        // ---------- Original Method ----------
        //mParcel.setDataPosition(0);
        //T item = null;
        //for (int i = 0; i < mNumItems; i++) {
            //item = creator.createFromParcel(mParcel);
            //list.add(item);
        //}
        //mParcel.recycle();
        //mParcel = null;
        //return item;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:03.151 -0400", hash_original_method = "1F10264B91664C7E8F28E8217E753C37", hash_generated_method = "ABBE6BB800E0320F1A7EC7F3DF4139A4")
    public void setLastSlice(boolean lastSlice) {
        mIsLastSlice = lastSlice;
        // ---------- Original Method ----------
        //mIsLastSlice = lastSlice;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:03.152 -0400", hash_original_method = "C1EA9F78A57EB4E786518F27886C353B", hash_generated_method = "DFDA334F55C62BAC3B289E366A047219")
    public boolean isLastSlice() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1548590058 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1548590058;
        // ---------- Original Method ----------
        //return mIsLastSlice;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:03.152 -0400", hash_original_field = "4C523A408F9351976FD0138FF9DC7B9B", hash_generated_field = "6ED298EF2ADA436368F0AB963583BD09")

    private static int MAX_IPC_SIZE = 256 * 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:03.152 -0400", hash_original_field = "CD6CCCBD94F811DA8E5361799FEB32AB", hash_generated_field = "56B35A35DF263964948A181AF3196EDB")

    @SuppressWarnings("unchecked")
    public static final Parcelable.Creator<ParceledListSlice> CREATOR =
            new Parcelable.Creator<ParceledListSlice>() {
        public ParceledListSlice createFromParcel(Parcel in) {
            final int numItems = in.readInt();
            final boolean lastSlice = in.readInt() == 1;

            if (numItems > 0) {
                final int parcelSize = in.readInt();

                
                int offset = in.dataPosition();
                in.setDataPosition(offset + parcelSize);

                Parcel p = Parcel.obtain();
                p.setDataPosition(0);
                p.appendFrom(in, offset, parcelSize);
                p.setDataPosition(0);

                return new ParceledListSlice(p, numItems, lastSlice);
            } else {
                return new ParceledListSlice();
            }
        }

        public ParceledListSlice[] newArray(int size) {
            return new ParceledListSlice[size];
        }
    };
}

