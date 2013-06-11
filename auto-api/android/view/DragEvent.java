package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Parcel;
import android.os.Parcelable;

public class DragEvent implements Parcelable {
    private static final boolean TRACK_RECYCLED_LOCATION = false;
    int mAction;
    float mX, mY;
    ClipDescription mClipDescription;
    ClipData mClipData;
    Object mLocalState;
    boolean mDragResult;
    private DragEvent mNext;
    private RuntimeException mRecycledLocation;
    private boolean mRecycled;
    private static final int MAX_RECYCLED = 10;
    private static final Object gRecyclerLock = new Object();
    private static int gRecyclerUsed = 0;
    private static DragEvent gRecyclerTop = null;
    public static final int ACTION_DRAG_STARTED = 1;
    public static final int ACTION_DRAG_LOCATION = 2;
    public static final int ACTION_DROP = 3;
    public static final int ACTION_DRAG_ENDED = 4;
    public static final int ACTION_DRAG_ENTERED = 5;
    public static final int ACTION_DRAG_EXITED = 6;
    public static final Parcelable.Creator<DragEvent> CREATOR = new Parcelable.Creator<DragEvent>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.910 -0400", hash_original_method = "16F96EE110AA9094A0A395FCCEA0D299", hash_generated_method = "45E779F35B4F872C9EFCE25CA1573048")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public DragEvent createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            DragEvent event;
            event = DragEvent.obtain();
            event.mAction = in.readInt();
            event.mX = in.readFloat();
            event.mY = in.readFloat();
            event.mDragResult = (in.readInt() != 0);
            {
                boolean var331417C59A822E59FB0B216D2F29CB47_997059243 = (in.readInt() != 0);
                {
                    event.mClipData = ClipData.CREATOR.createFromParcel(in);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var331417C59A822E59FB0B216D2F29CB47_1893024902 = (in.readInt() != 0);
                {
                    event.mClipDescription = ClipDescription.CREATOR.createFromParcel(in);
                } //End block
            } //End collapsed parenthetic
            return (DragEvent)dsTaint.getTaint();
            // ---------- Original Method ----------
            //DragEvent event = DragEvent.obtain();
            //event.mAction = in.readInt();
            //event.mX = in.readFloat();
            //event.mY = in.readFloat();
            //event.mDragResult = (in.readInt() != 0);
            //if (in.readInt() != 0) {
                //event.mClipData = ClipData.CREATOR.createFromParcel(in);
            //}
            //if (in.readInt() != 0) {
                //event.mClipDescription = ClipDescription.CREATOR.createFromParcel(in);
            //}
            //return event;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.911 -0400", hash_original_method = "BD0EF1E75E9E50C241DC01C692FCEC3F", hash_generated_method = "6D99E2F2DDB167853E2B53727A035473")
        @DSModeled(DSC.SAFE)
        public DragEvent[] newArray(int size) {
            dsTaint.addTaint(size);
            return (DragEvent[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new DragEvent[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.911 -0400", hash_original_method = "5492E1A6EF7C89CB56D8B22EE2854B8B", hash_generated_method = "01447C0F09A40EECE47B396F44CF436A")
    @DSModeled(DSC.SAFE)
    private DragEvent() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.911 -0400", hash_original_method = "7C5024523CDDAF1D0113FCBE9F36B975", hash_generated_method = "BAE1595468F50AFEFA2542367EBDF8F3")
    @DSModeled(DSC.SAFE)
    private void init(int action, float x, float y, ClipDescription description, ClipData data,
            Object localState, boolean result) {
        dsTaint.addTaint(result);
        dsTaint.addTaint(localState.dsTaint);
        dsTaint.addTaint(description.dsTaint);
        dsTaint.addTaint(action);
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        // ---------- Original Method ----------
        //mAction = action;
        //mX = x;
        //mY = y;
        //mClipDescription = description;
        //mClipData = data;
        //mLocalState = localState;
        //mDragResult = result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.911 -0400", hash_original_method = "569150DCDE5FF4A4307956D9929DFF84", hash_generated_method = "F6882FAE21622A725E57F29349956DDE")
    static DragEvent obtain() {
        return DragEvent.obtain(0, 0f, 0f, null, null, null, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.911 -0400", hash_original_method = "675C47EAA01A400128D84F6A99CFF725", hash_generated_method = "849B1D82CEB82E1FD32612B5D545386A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.911 -0400", hash_original_method = "107704681CA8508655DB280CAB346274", hash_generated_method = "D7A77D9670D5ED6414C9A075A7F98A33")
    public static DragEvent obtain(DragEvent source) {
        return obtain(source.mAction, source.mX, source.mY, source.mLocalState,
                source.mClipDescription, source.mClipData, source.mDragResult);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.911 -0400", hash_original_method = "96C17C1FB3A34A2A0AFECF0EC83B48C2", hash_generated_method = "33B36F07E32890DD641EFBE7C88B9F8B")
    @DSModeled(DSC.SAFE)
    public int getAction() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mAction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.911 -0400", hash_original_method = "331663EFF3E2EE62701FDAFEDB013F35", hash_generated_method = "11B11E5294E7C35BF5B807D987C40DB1")
    @DSModeled(DSC.SAFE)
    public float getX() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.911 -0400", hash_original_method = "ABC228174E672AD41349CE6D52652626", hash_generated_method = "3539346C54C7B84EAC37C8DEDB2BDCDE")
    @DSModeled(DSC.SAFE)
    public float getY() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.911 -0400", hash_original_method = "933F7F307168902744E3973968DC1B74", hash_generated_method = "3627AE7C231288766FE1C3A824B37876")
    @DSModeled(DSC.SAFE)
    public ClipData getClipData() {
        return (ClipData)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mClipData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.911 -0400", hash_original_method = "314798A5FB9D41875D673F25B7EDBA77", hash_generated_method = "80104466A71AE713CAE58F4C629F3E64")
    @DSModeled(DSC.SAFE)
    public ClipDescription getClipDescription() {
        return (ClipDescription)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mClipDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.911 -0400", hash_original_method = "37C7BCFB2F6F270ABDBD12EAE79514EC", hash_generated_method = "943FFF1445E7ABE1E00A2B4B393007DF")
    @DSModeled(DSC.SAFE)
    public Object getLocalState() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mLocalState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.911 -0400", hash_original_method = "137903529BA54F55A1080182FA7064FC", hash_generated_method = "2718ABEC94EDB41EB9F301278ECDD3A5")
    @DSModeled(DSC.SAFE)
    public boolean getResult() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mDragResult;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.912 -0400", hash_original_method = "BFE96ED2CE5B148D8BC4E31880D4A75D", hash_generated_method = "27E706E623E58A1F84D45D456CCB63DE")
    @DSModeled(DSC.SAFE)
    public final void recycle() {
        {
            {
                throw new RuntimeException(toString() + " recycled twice!", mRecycledLocation);
            } //End block
            mRecycledLocation = new RuntimeException("Last recycled here");
        } //End block
        {
            {
                throw new RuntimeException(toString() + " recycled twice!");
            } //End block
            mRecycled = true;
        } //End block
        mClipData = null;
        mClipDescription = null;
        mLocalState = null;
        {
            {
                gRecyclerUsed++;
                mNext = gRecyclerTop;
                gRecyclerTop = this;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (TRACK_RECYCLED_LOCATION) {
            //if (mRecycledLocation != null) {
                //throw new RuntimeException(toString() + " recycled twice!", mRecycledLocation);
            //}
            //mRecycledLocation = new RuntimeException("Last recycled here");
        //} else {
            //if (mRecycled) {
                //throw new RuntimeException(toString() + " recycled twice!");
            //}
            //mRecycled = true;
        //}
        //mClipData = null;
        //mClipDescription = null;
        //mLocalState = null;
        //synchronized (gRecyclerLock) {
            //if (gRecyclerUsed < MAX_RECYCLED) {
                //gRecyclerUsed++;
                //mNext = gRecyclerTop;
                //gRecyclerTop = this;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.912 -0400", hash_original_method = "B115D176D9854B47E8C200D036ACDD5B", hash_generated_method = "49452286BEAD49ECAF52C428A8A5414B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varCD218469D7B787607136183F3AAF849E_1727592615 = ("DragEvent{" + Integer.toHexString(System.identityHashCode(this))
        + " action=" + mAction + " @ (" + mX + ", " + mY + ") desc=" + mClipDescription
        + " data=" + mClipData + " local=" + mLocalState + " result=" + mDragResult
        + "}");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "DragEvent{" + Integer.toHexString(System.identityHashCode(this))
        //+ " action=" + mAction + " @ (" + mX + ", " + mY + ") desc=" + mClipDescription
        //+ " data=" + mClipData + " local=" + mLocalState + " result=" + mDragResult
        //+ "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.912 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.912 -0400", hash_original_method = "76A8906A7EAF6555F7630460CE48F340", hash_generated_method = "3D5530D3C6FE9B1F6BFED84F35334CE3")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        dest.writeInt(mAction);
        dest.writeFloat(mX);
        dest.writeFloat(mY);
        dest.writeInt(mDragResult ? 1 : 0);
        {
            dest.writeInt(0);
        } //End block
        {
            dest.writeInt(1);
            mClipData.writeToParcel(dest, flags);
        } //End block
        {
            dest.writeInt(0);
        } //End block
        {
            dest.writeInt(1);
            mClipDescription.writeToParcel(dest, flags);
        } //End block
        // ---------- Original Method ----------
        //dest.writeInt(mAction);
        //dest.writeFloat(mX);
        //dest.writeFloat(mY);
        //dest.writeInt(mDragResult ? 1 : 0);
        //if (mClipData == null) {
            //dest.writeInt(0);
        //} else {
            //dest.writeInt(1);
            //mClipData.writeToParcel(dest, flags);
        //}
        //if (mClipDescription == null) {
            //dest.writeInt(0);
        //} else {
            //dest.writeInt(1);
            //mClipDescription.writeToParcel(dest, flags);
        //}
    }

    
}


