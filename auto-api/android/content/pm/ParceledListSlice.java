package android.content.pm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class ParceledListSlice<T extends Parcelable> implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.793 -0400", hash_original_field = "4FCFEE3D082C4C61BD6B374EB2663F5D", hash_generated_field = "FECF2C1F375A3EF42076236F811E3099")

    private Parcel mParcel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.793 -0400", hash_original_field = "83695530A023F264DDB652781BA187D4", hash_generated_field = "BA3C2AEB1D951CD4DD5338E0704AB3BD")

    private int mNumItems;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.793 -0400", hash_original_field = "4A05E03E5F8F12BD83251DE71259F835", hash_generated_field = "EC008E3F2DC15587B7C3DF28445187C5")

    private boolean mIsLastSlice;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.794 -0400", hash_original_method = "24B996F8F50716248E38E24116049A17", hash_generated_method = "1887BA279D0200732AFFAF5AF7BA7C32")
    public  ParceledListSlice() {
        mParcel = Parcel.obtain();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.794 -0400", hash_original_method = "EA156AE64DA15F3296203897A2798D45", hash_generated_method = "F635FE86E5D41FC3A680E8C152909E12")
    private  ParceledListSlice(Parcel p, int numItems, boolean lastSlice) {
        mParcel = p;
        mNumItems = numItems;
        mIsLastSlice = lastSlice;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.795 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "E07F2DEC40D0547A6617A72A45EB6057")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1675090650 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1675090650;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.796 -0400", hash_original_method = "757A8AA414BA94194408A3738A93F76D", hash_generated_method = "5CF121FB4E3C5DA68C5F55CBB0508532")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mNumItems);
        dest.writeInt(mIsLastSlice ? 1 : 0);
        {
            final int parcelSize = mParcel.dataSize();
            dest.writeInt(parcelSize);
            dest.appendFrom(mParcel, 0, parcelSize);
        } 
        mNumItems = 0;
        mParcel.recycle();
        mParcel = null;
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
        
        
            
            
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.797 -0400", hash_original_method = "1E56C806D3B84E35689447C22D535D39", hash_generated_method = "036A6A26AAB69C81937320BE251126B2")
    public boolean append(T item) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("ParceledListSlice has already been recycled");
        } 
        item.writeToParcel(mParcel, PARCELABLE_WRITE_RETURN_VALUE);
        boolean var78C40EDF2EC647D907DA51ADE7761B31_1023108721 = (mParcel.dataSize() > MAX_IPC_SIZE);
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1965429330 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1965429330;
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.799 -0400", hash_original_method = "C11B1153BF8BCDA44C4073AC785F824F", hash_generated_method = "03CAC82CB7B04FB92FB7E2048D307879")
    public T populateList(List<T> list, Creator<T> creator) {
        T varB4EAC82CA7396A68D541C85D26508E83_1981846135 = null; 
        mParcel.setDataPosition(0);
        T item = null;
        {
            int i = 0;
            {
                item = creator.createFromParcel(mParcel);
                list.add(item);
            } 
        } 
        mParcel.recycle();
        mParcel = null;
        varB4EAC82CA7396A68D541C85D26508E83_1981846135 = item;
        addTaint(list.getTaint());
        addTaint(creator.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1981846135.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1981846135;
        
        
        
        
            
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.800 -0400", hash_original_method = "1F10264B91664C7E8F28E8217E753C37", hash_generated_method = "ABBE6BB800E0320F1A7EC7F3DF4139A4")
    public void setLastSlice(boolean lastSlice) {
        mIsLastSlice = lastSlice;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.800 -0400", hash_original_method = "C1EA9F78A57EB4E786518F27886C353B", hash_generated_method = "B5DD3BB74A0F87D002CAC5F697D0D089")
    public boolean isLastSlice() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1552665607 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1552665607;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.801 -0400", hash_original_field = "4C523A408F9351976FD0138FF9DC7B9B", hash_generated_field = "0F7066E666018D9C0306154ED0E07EF5")

    private static final int MAX_IPC_SIZE = 256 * 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:27.801 -0400", hash_original_field = "CD6CCCBD94F811DA8E5361799FEB32AB", hash_generated_field = "56B35A35DF263964948A181AF3196EDB")

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
    
}

