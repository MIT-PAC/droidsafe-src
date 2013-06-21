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
    private Parcel mParcel;
    private int mNumItems;
    private boolean mIsLastSlice;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.710 -0400", hash_original_method = "24B996F8F50716248E38E24116049A17", hash_generated_method = "1887BA279D0200732AFFAF5AF7BA7C32")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ParceledListSlice() {
        mParcel = Parcel.obtain();
        // ---------- Original Method ----------
        //mParcel = Parcel.obtain();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.710 -0400", hash_original_method = "EA156AE64DA15F3296203897A2798D45", hash_generated_method = "D5BB7855C09C1EB537A26D386DEEE981")
    @DSModeled(DSC.SAFE)
    private ParceledListSlice(Parcel p, int numItems, boolean lastSlice) {
        dsTaint.addTaint(p.dsTaint);
        dsTaint.addTaint(lastSlice);
        dsTaint.addTaint(numItems);
        // ---------- Original Method ----------
        //mParcel = p;
        //mNumItems = numItems;
        //mIsLastSlice = lastSlice;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.710 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0DB50BC0CCE4711867E95DEC1B2117C7")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.711 -0400", hash_original_method = "757A8AA414BA94194408A3738A93F76D", hash_generated_method = "6BB7586032A5B70D8B843BEEE3BEB0D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.711 -0400", hash_original_method = "1E56C806D3B84E35689447C22D535D39", hash_generated_method = "A654E425813B532BB67C573364B35760")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean append(T item) {
        dsTaint.addTaint(item.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("ParceledListSlice has already been recycled");
        } //End block
        item.writeToParcel(mParcel, PARCELABLE_WRITE_RETURN_VALUE);
        boolean var78C40EDF2EC647D907DA51ADE7761B31_1574841092 = (mParcel.dataSize() > MAX_IPC_SIZE);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mParcel == null) {
            //throw new IllegalStateException("ParceledListSlice has already been recycled");
        //}
        //item.writeToParcel(mParcel, PARCELABLE_WRITE_RETURN_VALUE);
        //mNumItems++;
        //return mParcel.dataSize() > MAX_IPC_SIZE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.712 -0400", hash_original_method = "C11B1153BF8BCDA44C4073AC785F824F", hash_generated_method = "36B4FD0F7411DAB65B6B6F25946DD0DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public T populateList(List<T> list, Creator<T> creator) {
        dsTaint.addTaint(list.dsTaint);
        dsTaint.addTaint(creator.dsTaint);
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
        return (T)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.712 -0400", hash_original_method = "1F10264B91664C7E8F28E8217E753C37", hash_generated_method = "80437D3A2137CF3998B03586D87B891D")
    @DSModeled(DSC.SAFE)
    public void setLastSlice(boolean lastSlice) {
        dsTaint.addTaint(lastSlice);
        // ---------- Original Method ----------
        //mIsLastSlice = lastSlice;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.712 -0400", hash_original_method = "C1EA9F78A57EB4E786518F27886C353B", hash_generated_method = "F0F268255887C0DC82A4CD8A4605D4BF")
    @DSModeled(DSC.SAFE)
    public boolean isLastSlice() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsLastSlice;
    }

    
    private static final int MAX_IPC_SIZE = 256 * 1024;
    @SuppressWarnings("unchecked") public static final Parcelable.Creator<ParceledListSlice> CREATOR = new Parcelable.Creator<ParceledListSlice>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.713 -0400", hash_original_method = "8E491D44C01D53B45589AFC0F51C5901", hash_generated_method = "682B5DAFCC93BD10DCB05C1F592EEC59")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ParceledListSlice createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            int numItems;
            numItems = in.readInt();
            boolean lastSlice;
            lastSlice = in.readInt() == 1;
            {
                int parcelSize;
                parcelSize = in.readInt();
                int offset;
                offset = in.dataPosition();
                in.setDataPosition(offset + parcelSize);
                Parcel p;
                p = Parcel.obtain();
                p.setDataPosition(0);
                p.appendFrom(in, offset, parcelSize);
                p.setDataPosition(0);
                ParceledListSlice varDA59ED0267E4D30F8F0FE1F50838C141_1090178135 = (new ParceledListSlice(p, numItems, lastSlice));
            } //End block
            {
                ParceledListSlice varF97EFBAA9FB0C7DA3AE9871CC3929F7D_1377430880 = (new ParceledListSlice());
            } //End block
            return (ParceledListSlice)dsTaint.getTaint();
            // ---------- Original Method ----------
            //final int numItems = in.readInt();
            //final boolean lastSlice = in.readInt() == 1;
            //if (numItems > 0) {
                //final int parcelSize = in.readInt();
                //int offset = in.dataPosition();
                //in.setDataPosition(offset + parcelSize);
                //Parcel p = Parcel.obtain();
                //p.setDataPosition(0);
                //p.appendFrom(in, offset, parcelSize);
                //p.setDataPosition(0);
                //return new ParceledListSlice(p, numItems, lastSlice);
            //} else {
                //return new ParceledListSlice();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.713 -0400", hash_original_method = "E482F5CE9440CF0158551315AEDE6980", hash_generated_method = "9A27D40257955E36085E1402C6C14358")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ParceledListSlice[] newArray(int size) {
            dsTaint.addTaint(size);
            ParceledListSlice[] var7ACE12F56DE99AD76ACF4F7063CD81E6_714176667 = (new ParceledListSlice[size]);
            return (ParceledListSlice[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ParceledListSlice[size];
        }

        
}; //Transformed anonymous class
}

