package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Parcel;
import android.os.Parcelable;

public class DragEvent implements Parcelable {

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.776 -0500", hash_original_method = "569150DCDE5FF4A4307956D9929DFF84", hash_generated_method = "F6882FAE21622A725E57F29349956DDE")
    
static DragEvent obtain() {
        return DragEvent.obtain(0, 0f, 0f, null, null, null, false);
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.779 -0500", hash_original_method = "675C47EAA01A400128D84F6A99CFF725", hash_generated_method = "849B1D82CEB82E1FD32612B5D545386A")
    
public static DragEvent obtain(int action, float x, float y, Object localState,
            ClipDescription description, ClipData data, boolean result) {
        final DragEvent ev;
        synchronized (gRecyclerLock) {
            if (gRecyclerTop == null) {
                ev = new DragEvent();
                ev.init(action, x, y, description, data, localState, result);
                return ev;
            }
            ev = gRecyclerTop;
            gRecyclerTop = ev.mNext;
            gRecyclerUsed -= 1;
        }
        ev.mRecycledLocation = null;
        ev.mRecycled = false;
        ev.mNext = null;

        ev.init(action, x, y, description, data, localState, result);

        return ev;
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.781 -0500", hash_original_method = "107704681CA8508655DB280CAB346274", hash_generated_method = "D7A77D9670D5ED6414C9A075A7F98A33")
    
public static DragEvent obtain(DragEvent source) {
        return obtain(source.mAction, source.mX, source.mY, source.mLocalState,
                source.mClipDescription, source.mClipData, source.mDragResult);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.722 -0500", hash_original_field = "CD71AEEB5BD3A875E610FF7C5BA69768", hash_generated_field = "FA3C17D544830BC1BEE55D29729BDFE3")

    private static final boolean TRACK_RECYCLED_LOCATION = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.745 -0500", hash_original_field = "F593DBD4ACC5DC484D76C0656C0FB27F", hash_generated_field = "632CD138CDBCADE9A63F9B23105E1648")

    private static final int MAX_RECYCLED = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.748 -0500", hash_original_field = "383C33CA63B8C16F39C24669AA7A3D08", hash_generated_field = "4D2E3DEDF37103D77BF3BB46692742C8")

    private static final Object gRecyclerLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.750 -0500", hash_original_field = "6EB148CB5F866621DB4F7D03789AE4F6", hash_generated_field = "30BDE92582307BB3C881F079E40B027E")

    private static int gRecyclerUsed = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.753 -0500", hash_original_field = "5D2AA514FFEBBABBF34A852ECF3B0212", hash_generated_field = "54939BC72968A690F365D294718CA089")

    private static DragEvent gRecyclerTop = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.755 -0500", hash_original_field = "42D0D399B1FBC6C0D9C6378F738DABB4", hash_generated_field = "9524B5F8800D40CC69498D08D923BFBF")

    public static final int ACTION_DRAG_STARTED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.758 -0500", hash_original_field = "AC004303C289A9812C5A94CEDA8F00AB", hash_generated_field = "635B00DA4FB3397490378FAA504497FE")

    public static final int ACTION_DRAG_LOCATION = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.760 -0500", hash_original_field = "7AB0060E5A5FF40E36C92D80A5A00687", hash_generated_field = "517C92CD125E84179A11296F5B7F6A0A")

    public static final int ACTION_DROP = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.763 -0500", hash_original_field = "45D61345FF8BEA8444B09578E1D6444F", hash_generated_field = "323D0EABB0B88FB8587CDDBD8F8D2FE5")

    public static final int ACTION_DRAG_ENDED = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.766 -0500", hash_original_field = "7262B364DA066CD0633967C92DE6F204", hash_generated_field = "CC78BC4068CBFD6E7997C5BC4E2819F7")

    public static final int ACTION_DRAG_ENTERED = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.768 -0500", hash_original_field = "E24F6BE5BE9000DEF3A9E449BEB4D1FF", hash_generated_field = "5957E8867F6B1B0ECE8E17A233F84AE7")

     public static final int ACTION_DRAG_EXITED = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.612 -0400", hash_original_field = "8462FFBB3C116EE5A525223AEC0039F6", hash_generated_field = "C367CE0E132A317997C32847E1BF50B0")

    public static final Parcelable.Creator<DragEvent> CREATOR =
        new Parcelable.Creator<DragEvent>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.812 -0500", hash_original_method = "16F96EE110AA9094A0A395FCCEA0D299", hash_generated_method = "5AD0296D6AF7AEE36A3ED2D2B155A456")
        
public DragEvent createFromParcel(Parcel in) {
            DragEvent event = DragEvent.obtain();
            event.mAction = in.readInt();
            event.mX = in.readFloat();
            event.mY = in.readFloat();
            event.mDragResult = (in.readInt() != 0);
            if (in.readInt() != 0) {
                event.mClipData = ClipData.CREATOR.createFromParcel(in);
            }
            if (in.readInt() != 0) {
                event.mClipDescription = ClipDescription.CREATOR.createFromParcel(in);
            }
            return event;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.815 -0500", hash_original_method = "BD0EF1E75E9E50C241DC01C692FCEC3F", hash_generated_method = "F5940CC4A29510C23ADADEAE3D19CB7D")
        
public DragEvent[] newArray(int size) {
            return new DragEvent[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.725 -0500", hash_original_field = "87F72266090A426F9B25050359B17309", hash_generated_field = "87F72266090A426F9B25050359B17309")

    int mAction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.608 -0400", hash_original_field = "E47D03BC59EE2C8B3B45870BE85294FB", hash_generated_field = "8174733DF249E326666A04F4BE58CCC8")

    float mX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.608 -0400", hash_original_field = "29DA5B2B864236A2CCB25B548E8F5F0A", hash_generated_field = "5EA984BC6FFFB7EE5487B162E48C8CE7")

    float mY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.729 -0500", hash_original_field = "BD054FDEC655C28C2D1BA2544910FE2F", hash_generated_field = "BD054FDEC655C28C2D1BA2544910FE2F")

    ClipDescription mClipDescription;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.731 -0500", hash_original_field = "2B150D9B8D4233603A483FCF49E77290", hash_generated_field = "2B150D9B8D4233603A483FCF49E77290")

    ClipData mClipData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.733 -0500", hash_original_field = "7F4CC997CFEF52EFD170500447C4E6A6", hash_generated_field = "7F4CC997CFEF52EFD170500447C4E6A6")

    Object mLocalState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.735 -0500", hash_original_field = "5909460597AF7E31055BB89A9B4E43C0", hash_generated_field = "5909460597AF7E31055BB89A9B4E43C0")

    boolean mDragResult;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.737 -0500", hash_original_field = "B7DB7C2351C1C66A5154246A77C78368", hash_generated_field = "71F519A9ECC78DE41D5510BA422E0931")

    private DragEvent mNext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.739 -0500", hash_original_field = "7CE140D407E955711B40F90DD17F57EA", hash_generated_field = "4E4D5EFD76E218484C8A2F86B097FF08")

    private RuntimeException mRecycledLocation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.742 -0500", hash_original_field = "54377D1FA2AD41427FB83B9E454546B7", hash_generated_field = "2C8375875524783DEB30CD6C7E943390")

    private boolean mRecycled;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.771 -0500", hash_original_method = "5492E1A6EF7C89CB56D8B22EE2854B8B", hash_generated_method = "34D2BE700F5D7E56A2B74D345471D5B9")
    
private DragEvent() {
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.773 -0500", hash_original_method = "7C5024523CDDAF1D0113FCBE9F36B975", hash_generated_method = "19167B6226E365583D2B7843F53CAFE7")
    
private void init(int action, float x, float y, ClipDescription description, ClipData data,
            Object localState, boolean result) {
        mAction = action;
        mX = x;
        mY = y;
        mClipDescription = description;
        mClipData = data;
        mLocalState = localState;
        mDragResult = result;
    }

    /**
     * Inspect the action value of this event.
     * @return One of the following action constants, in the order in which they usually occur
     * during a drag and drop operation:
     * <ul>
     *  <li>{@link #ACTION_DRAG_STARTED}</li>
     *  <li>{@link #ACTION_DRAG_ENTERED}</li>
     *  <li>{@link #ACTION_DRAG_LOCATION}</li>
     *  <li>{@link #ACTION_DROP}</li>
     *  <li>{@link #ACTION_DRAG_EXITED}</li>
     *  <li>{@link #ACTION_DRAG_ENDED}</li>
     * </ul>
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.783 -0500", hash_original_method = "96C17C1FB3A34A2A0AFECF0EC83B48C2", hash_generated_method = "3FD23346F621B19DABA981ADACA3C8BB")
    
public int getAction() {
        return mAction;
    }

    /**
     * Gets the X coordinate of the drag point. The value is only valid if the event action is
     * {@link #ACTION_DRAG_LOCATION} or {@link #ACTION_DROP}.
     * @return The current drag point's Y coordinate
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.786 -0500", hash_original_method = "331663EFF3E2EE62701FDAFEDB013F35", hash_generated_method = "6E92D0D3651A85CBFB76060D665CCF84")
    
public float getX() {
        return mX;
    }

    /**
     * Gets the Y coordinate of the drag point. The value is valid if the
     * event action is {@link #ACTION_DRAG_ENTERED}, {@link #ACTION_DRAG_LOCATION},
     * {@link #ACTION_DROP}, or {@link #ACTION_DRAG_EXITED}.
     * @return The current drag point's Y coordinate
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.788 -0500", hash_original_method = "ABC228174E672AD41349CE6D52652626", hash_generated_method = "DF84925D9DB2351D8A1C69C6893F85C9")
    
public float getY() {
        return mY;
    }

    /**
     * Returns the {@link android.content.ClipData} object sent to the system as part of the call
     * to
     * {@link android.view.View#startDrag(ClipData,View.DragShadowBuilder,Object,int) startDrag()}.
     * This method only returns valid data if the event action is {@link #ACTION_DROP}.
     * @return The ClipData sent to the system by startDrag().
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.790 -0500", hash_original_method = "933F7F307168902744E3973968DC1B74", hash_generated_method = "06C0D9C1185621E3FE0DD17871D02B3B")
    
public ClipData getClipData() {
        return mClipData;
    }

    /**
     * Returns the {@link android.content.ClipDescription} object contained in the
     * {@link android.content.ClipData} object sent to the system as part of the call to
     * {@link android.view.View#startDrag(ClipData,View.DragShadowBuilder,Object,int) startDrag()}.
     * The drag handler or listener for a View can use the metadata in this object to decide if the
     * View can accept the dragged View object's data.
     * <p>
     * This method returns valid data for all event actions.
     * @return The ClipDescription that was part of the ClipData sent to the system by startDrag().
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.793 -0500", hash_original_method = "314798A5FB9D41875D673F25B7EDBA77", hash_generated_method = "B7BCB37D3E0A9F6D191656EC8A72E30C")
    
public ClipDescription getClipDescription() {
        return mClipDescription;
    }

    /**
     * Returns the local state object sent to the system as part of the call to
     * {@link android.view.View#startDrag(ClipData,View.DragShadowBuilder,Object,int) startDrag()}.
     * The object is intended to provide local information about the drag and drop operation. For
     * example, it can indicate whether the drag and drop operation is a copy or a move.
     * <p>
     *  This method returns valid data for all event actions.
     * </p>
     * @return The local state object sent to the system by startDrag().
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.796 -0500", hash_original_method = "37C7BCFB2F6F270ABDBD12EAE79514EC", hash_generated_method = "2C5442DD0A47910756BBEFB3CA8E58E7")
    
public Object getLocalState() {
        return mLocalState;
    }

    /**
     * <p>
     * Returns an indication of the result of the drag and drop operation.
     * This method only returns valid data if the action type is {@link #ACTION_DRAG_ENDED}.
     * The return value depends on what happens after the user releases the drag shadow.
     * </p>
     * <p>
     * If the user releases the drag shadow on a View that can accept a drop, the system sends an
     * {@link #ACTION_DROP} event to the View object's drag event listener. If the listener
     * returns {@code true}, then getResult() will return {@code true}.
     * If the listener returns {@code false}, then getResult() returns {@code false}.
     * </p>
     * <p>
     * Notice that getResult() also returns {@code false} if no {@link #ACTION_DROP} is sent. This
     * happens, for example, when the user releases the drag shadow over an area outside of the
     * application. In this case, the system sends out {@link #ACTION_DRAG_ENDED} for the current
     * operation, but never sends out {@link #ACTION_DROP}.
     * </p>
     * @return {@code true} if a drag event listener returned {@code true} in response to
     * {@link #ACTION_DROP}. If the system did not send {@link #ACTION_DROP} before
     * {@link #ACTION_DRAG_ENDED}, or if the listener returned {@code false} in response to
     * {@link #ACTION_DROP}, then {@code false} is returned.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.798 -0500", hash_original_method = "137903529BA54F55A1080182FA7064FC", hash_generated_method = "97F7442FD18FEB387A847718DE981C8E")
    
public boolean getResult() {
        return mDragResult;
    }

    /**
     * Recycle the DragEvent, to be re-used by a later caller.  After calling
     * this function you must never touch the event again.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.801 -0500", hash_original_method = "BFE96ED2CE5B148D8BC4E31880D4A75D", hash_generated_method = "15ADCC82ED098E1EC67EA6E8E267CAA9")
    
public final void recycle() {
        // Ensure recycle is only called once!
        if (TRACK_RECYCLED_LOCATION) {
            if (mRecycledLocation != null) {
                throw new RuntimeException(toString() + " recycled twice!", mRecycledLocation);
            }
            mRecycledLocation = new RuntimeException("Last recycled here");
        } else {
            if (mRecycled) {
                throw new RuntimeException(toString() + " recycled twice!");
            }
            mRecycled = true;
        }

        mClipData = null;
        mClipDescription = null;
        mLocalState = null;

        synchronized (gRecyclerLock) {
            if (gRecyclerUsed < MAX_RECYCLED) {
                gRecyclerUsed++;
                mNext = gRecyclerTop;
                gRecyclerTop = this;
            }
        }
    }

    /**
     * Returns a string containing a concise, human-readable representation of this DragEvent
     * object.
     * @return A string representation of the DragEvent object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.803 -0500", hash_original_method = "B115D176D9854B47E8C200D036ACDD5B", hash_generated_method = "17C2F2870E5A9D6E9ACE9C99368E106F")
    
@Override
    public String toString() {
        return "DragEvent{" + Integer.toHexString(System.identityHashCode(this))
        + " action=" + mAction + " @ (" + mX + ", " + mY + ") desc=" + mClipDescription
        + " data=" + mClipData + " local=" + mLocalState + " result=" + mDragResult
        + "}";
    }

    /* Parcelable interface */

    /**
     * Returns information about the {@link android.os.Parcel} representation of this DragEvent
     * object.
     * @return Information about the {@link android.os.Parcel} representation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.805 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    /**
     * Creates a {@link android.os.Parcel} object from this DragEvent object.
     * @param dest A {@link android.os.Parcel} object in which to put the DragEvent object.
     * @param flags Flags to store in the Parcel.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:14.808 -0500", hash_original_method = "76A8906A7EAF6555F7630460CE48F340", hash_generated_method = "1EC937095A5650F0EC457B2A4B4DEA3C")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mAction);
        dest.writeFloat(mX);
        dest.writeFloat(mY);
        dest.writeInt(mDragResult ? 1 : 0);
        if (mClipData == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            mClipData.writeToParcel(dest, flags);
        }
        if (mClipDescription == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            mClipDescription.writeToParcel(dest, flags);
        }
    }
    // orphaned legacy method
    public DragEvent createFromParcel(Parcel in) {
            DragEvent event = DragEvent.obtain();
            event.mAction = in.readInt();
            event.mX = in.readFloat();
            event.mY = in.readFloat();
            event.mDragResult = (in.readInt() != 0);
            if (in.readInt() != 0) {
                event.mClipData = ClipData.CREATOR.createFromParcel(in);
            }
            if (in.readInt() != 0) {
                event.mClipDescription = ClipDescription.CREATOR.createFromParcel(in);
            }
            return event;
        }
    
    // orphaned legacy method
    public DragEvent[] newArray(int size) {
            return new DragEvent[size];
        }
    
}

