package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Parcel;
import android.os.Parcelable;

public class DragEvent implements Parcelable {
    int mAction;
    float mX, mY;
    ClipDescription mClipDescription;
    ClipData mClipData;
    Object mLocalState;
    boolean mDragResult;
    private DragEvent mNext;
    private RuntimeException mRecycledLocation;
    private boolean mRecycled;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.495 -0400", hash_original_method = "5492E1A6EF7C89CB56D8B22EE2854B8B", hash_generated_method = "C325B7A5D23661790703116059A6FDC6")
    @DSModeled(DSC.SAFE)
    private DragEvent() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.496 -0400", hash_original_method = "7C5024523CDDAF1D0113FCBE9F36B975", hash_generated_method = "7D4493B78C1E146906E1EBB2A433A4B8")
    @DSModeled(DSC.SAFE)
    private void init(int action, float x, float y, ClipDescription description, ClipData data,
            Object localState, boolean result) {
        dsTaint.addTaint(result);
        dsTaint.addTaint(localState.dsTaint);
        dsTaint.addTaint(description.dsTaint);
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(action);
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

    
        static DragEvent obtain() {
        return DragEvent.obtain(0, 0f, 0f, null, null, null, false);
    }

    
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

    
        public static DragEvent obtain(DragEvent source) {
        return obtain(source.mAction, source.mX, source.mY, source.mLocalState,
                source.mClipDescription, source.mClipData, source.mDragResult);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.498 -0400", hash_original_method = "96C17C1FB3A34A2A0AFECF0EC83B48C2", hash_generated_method = "8B8BCAC0F89F78A6585BE14B7ED8E311")
    @DSModeled(DSC.SAFE)
    public int getAction() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mAction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.498 -0400", hash_original_method = "331663EFF3E2EE62701FDAFEDB013F35", hash_generated_method = "2A08F05EDA804EFD61163F85018DAD1D")
    @DSModeled(DSC.SAFE)
    public float getX() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.498 -0400", hash_original_method = "ABC228174E672AD41349CE6D52652626", hash_generated_method = "FB1CBFA02A9ABEC493E5D761990EFEFC")
    @DSModeled(DSC.SAFE)
    public float getY() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.498 -0400", hash_original_method = "933F7F307168902744E3973968DC1B74", hash_generated_method = "AF39AC7253C862D3BCC1514D4FEBA076")
    @DSModeled(DSC.SAFE)
    public ClipData getClipData() {
        return (ClipData)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mClipData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.498 -0400", hash_original_method = "314798A5FB9D41875D673F25B7EDBA77", hash_generated_method = "86746805CB68A346DAF92CE02FA83085")
    @DSModeled(DSC.SAFE)
    public ClipDescription getClipDescription() {
        return (ClipDescription)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mClipDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.499 -0400", hash_original_method = "37C7BCFB2F6F270ABDBD12EAE79514EC", hash_generated_method = "30D8FA30BC6E558AD0BCCC84A95892C8")
    @DSModeled(DSC.SAFE)
    public Object getLocalState() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mLocalState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.499 -0400", hash_original_method = "137903529BA54F55A1080182FA7064FC", hash_generated_method = "968365E01BC04944E5F4F2F4DB270532")
    @DSModeled(DSC.SAFE)
    public boolean getResult() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mDragResult;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.499 -0400", hash_original_method = "BFE96ED2CE5B148D8BC4E31880D4A75D", hash_generated_method = "F6F4B8199363E13A075B977E0DF1DC72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void recycle() {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(toString() + " recycled twice!", mRecycledLocation);
            } //End block
            mRecycledLocation = new RuntimeException("Last recycled here");
        } //End block
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(toString() + " recycled twice!");
            } //End block
            mRecycled = true;
        } //End block
        mClipData = null;
        mClipDescription = null;
        mLocalState = null;
        {
            {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.500 -0400", hash_original_method = "B115D176D9854B47E8C200D036ACDD5B", hash_generated_method = "20C8C2B00C2A4869843B5B3A1E296194")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varCD218469D7B787607136183F3AAF849E_320334165 = ("DragEvent{" + Integer.toHexString(System.identityHashCode(this))
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.500 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.500 -0400", hash_original_method = "76A8906A7EAF6555F7630460CE48F340", hash_generated_method = "F62D1A4D19F00EE0353D0F7277CF0F27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
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

    
    private static final boolean TRACK_RECYCLED_LOCATION = false;
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.500 -0400", hash_original_method = "16F96EE110AA9094A0A395FCCEA0D299", hash_generated_method = "6426DF0E79EF711A530E78FF5CEDE0AC")
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
                boolean var331417C59A822E59FB0B216D2F29CB47_2001190869 = (in.readInt() != 0);
                {
                    event.mClipData = ClipData.CREATOR.createFromParcel(in);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var331417C59A822E59FB0B216D2F29CB47_1968332657 = (in.readInt() != 0);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.501 -0400", hash_original_method = "BD0EF1E75E9E50C241DC01C692FCEC3F", hash_generated_method = "78F32D4AC98960BDD5C4E702F24F02A5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public DragEvent[] newArray(int size) {
            dsTaint.addTaint(size);
            DragEvent[] var822E4869A1352AA7F787C565BE6F3611_502019423 = (new DragEvent[size]);
            return (DragEvent[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new DragEvent[size];
        }

        
}; //Transformed anonymous class
}

