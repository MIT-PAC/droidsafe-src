package android.content.pm;

// Droidsafe Imports
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayList;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

public class ParceledListSlice<T extends Parcelable> implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:55.727 -0500", hash_original_field = "826BF1CA6DA1118F47044124556516CE", hash_generated_field = "0F7066E666018D9C0306154ED0E07EF5")

    private static final int MAX_IPC_SIZE = 256 * 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.322 -0400", hash_original_field = "CD6CCCBD94F811DA8E5361799FEB32AB", hash_generated_field = "56B35A35DF263964948A181AF3196EDB")

    @SuppressWarnings("unchecked")
    public static final Parcelable.Creator<ParceledListSlice> CREATOR =
            new Parcelable.Creator<ParceledListSlice>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:55.755 -0500", hash_original_method = "8E491D44C01D53B45589AFC0F51C5901", hash_generated_method = "F2CB1E3ED7E70E38911746D19D4C2C4E")
        
public ParceledListSlice createFromParcel(Parcel in) {
            final int numItems = in.readInt();
            final boolean lastSlice = in.readInt() == 1;

            if (numItems > 0) {
                final int parcelSize = in.readInt();

                // Advance within this Parcel
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:55.758 -0500", hash_original_method = "E482F5CE9440CF0158551315AEDE6980", hash_generated_method = "5F6580488C67DD7F7E93FFBBFBAF805E")
        
public ParceledListSlice[] newArray(int size) {
            return new ParceledListSlice[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:55.729 -0500", hash_original_field = "A291CB568559F5F870526FB6632A3C7D", hash_generated_field = "FECF2C1F375A3EF42076236F811E3099")

    private Parcel mParcel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:55.731 -0500", hash_original_field = "E2177534F1B793901087708283D5F093", hash_generated_field = "BA3C2AEB1D951CD4DD5338E0704AB3BD")

    private int mNumItems;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:55.733 -0500", hash_original_field = "C98ED83E04B0788F5876ADAD919E6D48", hash_generated_field = "EC008E3F2DC15587B7C3DF28445187C5")

    private boolean mIsLastSlice;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:55.736 -0500", hash_original_method = "24B996F8F50716248E38E24116049A17", hash_generated_method = "117732B140E042977F7EDC522CE6B60A")
    
public ParceledListSlice() {
        mParcel = Parcel.obtain();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:55.739 -0500", hash_original_method = "EA156AE64DA15F3296203897A2798D45", hash_generated_method = "842872600443FA0399957A585BED5FF6")
    
private ParceledListSlice(Parcel p, int numItems, boolean lastSlice) {
        mParcel = p;
        mNumItems = numItems;
        mIsLastSlice = lastSlice;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-07 03:18:43.623 -0400", hash_original_method = "F26677879E4C46FCAE19ABCBFB4E24E6", hash_generated_method = "CE2866EEF927AE369C7C8151A1FC6043")
    
@Override
    public int describeContents() {
        int contents = 0;
        for (int i=0; i<mList.size(); i++) {
            contents |= mList.get(i).describeContents();
        }
        return contents;
    }

    /**
     * Write this to another Parcel. Note that this discards the internal Parcel
     * and should not be used anymore. This is so we can pass this to a Binder
     * where we won't have a chance to call recycle on this.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-07 03:18:43.626 -0400", hash_original_method = "74A4BECDA9C488959F6AA6625D981FD8", hash_generated_method = "D089205EB00DB7A060AC70284C038F5C")
    
@Override
    public void writeToParcel(Parcel dest, int flags) {
        final int N = mList.size();
        final int callFlags = flags;
        dest.writeInt(N);
        if (DEBUG) Log.d(TAG, "Writing " + N + " items");
        if (N > 0) {
            dest.writeParcelableCreator(mList.get(0));
            int i = 0;
            while (i < N && dest.dataSize() < MAX_FIRST_IPC_SIZE) {
                dest.writeInt(1);
                mList.get(i).writeToParcel(dest, callFlags);
                if (DEBUG) Log.d(TAG, "Wrote inline #" + i + ": " + mList.get(i));
                i++;
            }
            if (i < N) {
                dest.writeInt(0);
                Binder retriever = new Binder() {
                    @DSSafe(DSCat.SAFE_LIST)
        @Override
                    protected boolean onTransact(int code, Parcel data, Parcel reply, int flags)
                            throws RemoteException {
                        if (code != FIRST_CALL_TRANSACTION) {
                            return super.onTransact(code, data, reply, flags);
                        }
                        int i = data.readInt();
                        if (DEBUG) Log.d(TAG, "Writing more @" + i + " of " + N);
                        while (i < N && reply.dataSize() < MAX_IPC_SIZE) {
                            reply.writeInt(1);
                            mList.get(i).writeToParcel(reply, callFlags);
                            if (DEBUG) Log.d(TAG, "Wrote extra #" + i + ": " + mList.get(i));
                            i++;
                        }
                        if (i < N) {
                            if (DEBUG) Log.d(TAG, "Breaking @" + i + " of " + N);
                            reply.writeInt(0);
                        }
                        return true;
                    }
                };
                if (DEBUG) Log.d(TAG, "Breaking @" + i + " of " + N + ": retriever=" + retriever);
                dest.writeStrongBinder(retriever);
            }
        }
    }

    /**
     * Appends a parcel to this list slice.
     *
     * @param item Parcelable item to append to this list slice
     * @return true when the list slice is full and should not be appended to
     *         anymore
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:55.746 -0500", hash_original_method = "1E56C806D3B84E35689447C22D535D39", hash_generated_method = "C66D6F971A7BE1AFC963389EBB6ACC76")
    
public boolean append(T item) {
        if (mParcel == null) {
            throw new IllegalStateException("ParceledListSlice has already been recycled");
        }

        item.writeToParcel(mParcel, PARCELABLE_WRITE_RETURN_VALUE);
        mNumItems++;

        return toTaintBoolean(mParcel.dataSize() + MAX_IPC_SIZE);
    }

    /**
     * Populates a list and discards the internal state of the
     * ParceledListSlice in the process. The instance should
     * not be used anymore.
     *
     * @param list list to insert items from this slice.
     * @param creator creator that knows how to unparcel the
     *        target object type.
     * @return the last item inserted into the list or null if none.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:55.748 -0500", hash_original_method = "C11B1153BF8BCDA44C4073AC785F824F", hash_generated_method = "31DE1676A7D3BC3BC9911CB72FB32E4D")
    
public T populateList(List<T> list, Creator<T> creator) {
        mParcel.setDataPosition(0);

        T item = null;
        for (int i = 0; i < mNumItems; i++) {
            item = creator.createFromParcel(mParcel);
            list.add(item);
        }

        mParcel.recycle();
        mParcel = null;

        return item;
    }

    /**
     * Sets whether this is the last list slice in the series.
     *
     * @param lastSlice
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:55.750 -0500", hash_original_method = "1F10264B91664C7E8F28E8217E753C37", hash_generated_method = "D05E2C016F2C0CBFD85842ED2BCD74B4")
    
public void setLastSlice(boolean lastSlice) {
        mIsLastSlice = lastSlice;
    }

    /**
     * Returns whether this is the last slice in a series of slices.
     *
     * @return true if this is the last slice in the series.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:55.752 -0500", hash_original_method = "C1EA9F78A57EB4E786518F27886C353B", hash_generated_method = "362BAB9C335DE9C9885E3C4F342891D4")
    
public boolean isLastSlice() {
        return mIsLastSlice;
    }
    // orphaned legacy method
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
    
    // orphaned legacy method
    public ParceledListSlice[] newArray(int size) {
            return new ParceledListSlice[size];
        }

@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-07 03:18:43.619 -0400", hash_original_field = "BD5B489354E05FBBE774FA103ACAFC26", hash_generated_field = "082CE64FD4689039372A2D1255C37CC5")

    private  List<T> mList;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-07 03:18:43.621 -0400", hash_original_method = "F734F687479909C039B4CE55836EDBA8", hash_generated_method = "AE15C647DA7C1BDF3023D909C73BD407")
    
private ParceledListSlice(Parcel p, ClassLoader loader) {
        final int N = p.readInt();
        mList = new ArrayList<T>(N);
        if (DEBUG) Log.d(TAG, "Retrieving " + N + " items");
        if (N <= 0) {
            return;
        }
        Parcelable.Creator<T> creator = p.readParcelableCreator(loader);
        int i = 0;
        while (i < N) {
            if (p.readInt() == 0) {
                break;
            }
            mList.add(p.readCreator(creator, loader));
            if (DEBUG) Log.d(TAG, "Read inline #" + i + ": " + mList.get(mList.size()-1));
            i++;
        }
        if (i >= N) {
            return;
        }
        final IBinder retriever = p.readStrongBinder();
        while (i < N) {
            if (DEBUG) Log.d(TAG, "Reading more @" + i + " of " + N + ": retriever=" + retriever);
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            data.writeInt(i);
            try {
                retriever.transact(IBinder.FIRST_CALL_TRANSACTION, data, reply, 0);
            } catch (RemoteException e) {
                Log.w(TAG, "Failure retrieving array; only received " + i + " of " + N, e);
                return;
            }
            while (i < N && reply.readInt() != 0) {
                mList.add(reply.readCreator(creator, loader));
                if (DEBUG) Log.d(TAG, "Read extra #" + i + ": " + mList.get(mList.size()-1));
                i++;
            }
            reply.recycle();
            data.recycle();
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-07 03:18:43.618 -0400", hash_original_field = "D557A386B863E26A66A12330F7D63508", hash_generated_field = "5EEEBE5F585908618BB0E77053475C25")

    private static final int MAX_FIRST_IPC_SIZE = MAX_IPC_SIZE / 2;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-07 03:18:43.620 -0400", hash_original_method = "E8E4B6175D074D54864FA1905D194E54", hash_generated_method = "B8DDC7B32CAD86262A00217FD8250656")
    
public ParceledListSlice(List<T> list) {
        mList = list;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-07 03:18:43.622 -0400", hash_original_method = "2C745104CD070C50FA15F4595506F1D7", hash_generated_method = "B48DBDB53AE2568AEA1BFED4123B4238")
    
public List<T> getList() {
        return mList;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-07 03:18:43.615 -0400", hash_original_field = "AE0598547B3757687FA8B49A6E0DD4B2", hash_generated_field = "AEBC786FDA170BC7613EC32BE7E7A774")

    private static String TAG = "ParceledListSlice";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-07 03:18:43.616 -0400", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "E83DF1E2E661A92B1AFDA8C473D190B2")

    private static boolean DEBUG = false;}

