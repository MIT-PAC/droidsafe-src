package android.content.pm;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class ParceledListSlice<T extends Parcelable> implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.039 -0400", hash_original_field = "4FCFEE3D082C4C61BD6B374EB2663F5D", hash_generated_field = "FECF2C1F375A3EF42076236F811E3099")

    private Parcel mParcel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.039 -0400", hash_original_field = "83695530A023F264DDB652781BA187D4", hash_generated_field = "BA3C2AEB1D951CD4DD5338E0704AB3BD")

    private int mNumItems;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.039 -0400", hash_original_field = "4A05E03E5F8F12BD83251DE71259F835", hash_generated_field = "EC008E3F2DC15587B7C3DF28445187C5")

    private boolean mIsLastSlice;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.039 -0400", hash_original_method = "24B996F8F50716248E38E24116049A17", hash_generated_method = "1887BA279D0200732AFFAF5AF7BA7C32")
    public  ParceledListSlice() {
        mParcel = Parcel.obtain();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.040 -0400", hash_original_method = "EA156AE64DA15F3296203897A2798D45", hash_generated_method = "F635FE86E5D41FC3A680E8C152909E12")
    private  ParceledListSlice(Parcel p, int numItems, boolean lastSlice) {
        mParcel = p;
        mNumItems = numItems;
        mIsLastSlice = lastSlice;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.041 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "2F53AE729D529B26003371F3A617F1F0")
    @Override
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1444418932 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_400710296 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_400710296;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.041 -0400", hash_original_method = "757A8AA414BA94194408A3738A93F76D", hash_generated_method = "62B52FB7CB55FB65150B423B6F7B09BB")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeInt(mNumItems);
        dest.writeInt(mIsLastSlice ? 1 : 0);
    if(mNumItems > 0)        
        {
            final int parcelSize = mParcel.dataSize();
            dest.writeInt(parcelSize);
            dest.appendFrom(mParcel, 0, parcelSize);
        } 
        mNumItems = 0;
        mParcel.recycle();
        mParcel = null;
        
        
        
        
            
            
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.042 -0400", hash_original_method = "1E56C806D3B84E35689447C22D535D39", hash_generated_method = "7A8FB4F78C3B92BA426F34F75D0BCFAE")
    public boolean append(T item) {
        addTaint(item.getTaint());
    if(mParcel == null)        
        {
            IllegalStateException varB6B7D628470E38BA5B0B84B799A15C2D_1948235035 = new IllegalStateException("ParceledListSlice has already been recycled");
            varB6B7D628470E38BA5B0B84B799A15C2D_1948235035.addTaint(taint);
            throw varB6B7D628470E38BA5B0B84B799A15C2D_1948235035;
        } 
        item.writeToParcel(mParcel, PARCELABLE_WRITE_RETURN_VALUE);
        mNumItems++;
        boolean var81D6A4DFD43DF90BD16969936FF03632_1736758519 = (mParcel.dataSize() > MAX_IPC_SIZE);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_955032097 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_955032097;
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.043 -0400", hash_original_method = "C11B1153BF8BCDA44C4073AC785F824F", hash_generated_method = "BF0FA49FC8280C816578B2933FC8213F")
    public T populateList(List<T> list, Creator<T> creator) {
        addTaint(creator.getTaint());
        addTaint(list.getTaint());
        mParcel.setDataPosition(0);
        T item = null;
for(int i = 0;i < mNumItems;i++)
        {
            item = creator.createFromParcel(mParcel);
            list.add(item);
        } 
        mParcel.recycle();
        mParcel = null;
T var393CF4FD24220F0ED4B080A1E7108CD3_1036946057 =         item;
        var393CF4FD24220F0ED4B080A1E7108CD3_1036946057.addTaint(taint);
        return var393CF4FD24220F0ED4B080A1E7108CD3_1036946057;
        
        
        
        
            
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.044 -0400", hash_original_method = "1F10264B91664C7E8F28E8217E753C37", hash_generated_method = "ABBE6BB800E0320F1A7EC7F3DF4139A4")
    public void setLastSlice(boolean lastSlice) {
        mIsLastSlice = lastSlice;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.044 -0400", hash_original_method = "C1EA9F78A57EB4E786518F27886C353B", hash_generated_method = "7C7FAAC0A3245F83AB9A7DBE7CA70BF0")
    public boolean isLastSlice() {
        boolean var4A05E03E5F8F12BD83251DE71259F835_1652188485 = (mIsLastSlice);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_541869695 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_541869695;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.045 -0400", hash_original_field = "4C523A408F9351976FD0138FF9DC7B9B", hash_generated_field = "0F7066E666018D9C0306154ED0E07EF5")

    private static final int MAX_IPC_SIZE = 256 * 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.045 -0400", hash_original_field = "CD6CCCBD94F811DA8E5361799FEB32AB", hash_generated_field = "56B35A35DF263964948A181AF3196EDB")

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

