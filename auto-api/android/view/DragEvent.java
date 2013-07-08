package android.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Parcel;
import android.os.Parcelable;

public class DragEvent implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.985 -0400", hash_original_field = "A3988EEE869C06063B06A0C38A6A1E11", hash_generated_field = "87F72266090A426F9B25050359B17309")

    int mAction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.985 -0400", hash_original_field = "E47D03BC59EE2C8B3B45870BE85294FB", hash_generated_field = "8174733DF249E326666A04F4BE58CCC8")

    float mX;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.985 -0400", hash_original_field = "29DA5B2B864236A2CCB25B548E8F5F0A", hash_generated_field = "5EA984BC6FFFB7EE5487B162E48C8CE7")

    float mY;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.985 -0400", hash_original_field = "C18C91213C987999CDB9110CD9126E6F", hash_generated_field = "BD054FDEC655C28C2D1BA2544910FE2F")

    ClipDescription mClipDescription;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.985 -0400", hash_original_field = "42029AD733F56F7364B27891AD39CCF9", hash_generated_field = "2B150D9B8D4233603A483FCF49E77290")

    ClipData mClipData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.986 -0400", hash_original_field = "79A0AB04CCF2C336AED0A494A632692E", hash_generated_field = "7F4CC997CFEF52EFD170500447C4E6A6")

    Object mLocalState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.986 -0400", hash_original_field = "8927DB6CA9E7C245BB19CB5184DE9194", hash_generated_field = "5909460597AF7E31055BB89A9B4E43C0")

    boolean mDragResult;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.986 -0400", hash_original_field = "2271A9775971F952514B94408144FAA0", hash_generated_field = "71F519A9ECC78DE41D5510BA422E0931")

    private DragEvent mNext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.986 -0400", hash_original_field = "285FE8BBC1049056117639C63D1605B9", hash_generated_field = "4E4D5EFD76E218484C8A2F86B097FF08")

    private RuntimeException mRecycledLocation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.986 -0400", hash_original_field = "1212A62D731F217836716E35FA12386C", hash_generated_field = "2C8375875524783DEB30CD6C7E943390")

    private boolean mRecycled;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.986 -0400", hash_original_method = "5492E1A6EF7C89CB56D8B22EE2854B8B", hash_generated_method = "C325B7A5D23661790703116059A6FDC6")
    private  DragEvent() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.986 -0400", hash_original_method = "7C5024523CDDAF1D0113FCBE9F36B975", hash_generated_method = "938EDBDAF55CF15B95F169EDD98664E3")
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

    
    @DSModeled(DSC.SAFE)
    static DragEvent obtain() {
        return DragEvent.obtain(0, 0f, 0f, null, null, null, false);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static DragEvent obtain(DragEvent source) {
        return obtain(source.mAction, source.mX, source.mY, source.mLocalState,
                source.mClipDescription, source.mClipData, source.mDragResult);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.987 -0400", hash_original_method = "96C17C1FB3A34A2A0AFECF0EC83B48C2", hash_generated_method = "B6103010D2D5FFFF311A69E24BCF80A0")
    public int getAction() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1170797013 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1170797013;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.987 -0400", hash_original_method = "331663EFF3E2EE62701FDAFEDB013F35", hash_generated_method = "8BF00033F5E296F182A728DE401AA5CF")
    public float getX() {
        float var546ADE640B6EDFBC8A086EF31347E768_1284509788 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1284509788;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.988 -0400", hash_original_method = "ABC228174E672AD41349CE6D52652626", hash_generated_method = "5ADE32754D0BF34B25447F7830622354")
    public float getY() {
        float var546ADE640B6EDFBC8A086EF31347E768_1620281625 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1620281625;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.988 -0400", hash_original_method = "933F7F307168902744E3973968DC1B74", hash_generated_method = "2142EBA8AA4CE6D699004E19F7C51965")
    public ClipData getClipData() {
        ClipData varB4EAC82CA7396A68D541C85D26508E83_1070439922 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1070439922 = mClipData;
        varB4EAC82CA7396A68D541C85D26508E83_1070439922.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1070439922;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.989 -0400", hash_original_method = "314798A5FB9D41875D673F25B7EDBA77", hash_generated_method = "A8D64E2D3507DA72C59F74F21D2A7D5E")
    public ClipDescription getClipDescription() {
        ClipDescription varB4EAC82CA7396A68D541C85D26508E83_1052998544 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1052998544 = mClipDescription;
        varB4EAC82CA7396A68D541C85D26508E83_1052998544.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1052998544;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.990 -0400", hash_original_method = "37C7BCFB2F6F270ABDBD12EAE79514EC", hash_generated_method = "1FAFBECC1722F3EC675CF1CC27C3608F")
    public Object getLocalState() {
        Object varB4EAC82CA7396A68D541C85D26508E83_2077961447 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2077961447 = mLocalState;
        varB4EAC82CA7396A68D541C85D26508E83_2077961447.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2077961447;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.990 -0400", hash_original_method = "137903529BA54F55A1080182FA7064FC", hash_generated_method = "61B0F82C082EB21F5E7CEDC1C30A1466")
    public boolean getResult() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1858790265 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1858790265;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.991 -0400", hash_original_method = "BFE96ED2CE5B148D8BC4E31880D4A75D", hash_generated_method = "F6F4B8199363E13A075B977E0DF1DC72")
    public final void recycle() {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(toString() + " recycled twice!", mRecycledLocation);
            } 
            mRecycledLocation = new RuntimeException("Last recycled here");
        } 
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(toString() + " recycled twice!");
            } 
            mRecycled = true;
        } 
        mClipData = null;
        mClipDescription = null;
        mLocalState = null;
        {
            {
                mNext = gRecyclerTop;
                gRecyclerTop = this;
            } 
        } 
        
        
            
                
            
            
        
            
                
            
            
        
        
        
        
        
            
                
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.991 -0400", hash_original_method = "B115D176D9854B47E8C200D036ACDD5B", hash_generated_method = "FE22804608457FC26092E444846F292B")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_506905067 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_506905067 = "DragEvent{" + Integer.toHexString(System.identityHashCode(this))
        + " action=" + mAction + " @ (" + mX + ", " + mY + ") desc=" + mClipDescription
        + " data=" + mClipData + " local=" + mLocalState + " result=" + mDragResult
        + "}";
        varB4EAC82CA7396A68D541C85D26508E83_506905067.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_506905067;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.992 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "94D75A6E5A27CBA96AE43924D05F5C15")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1176041438 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1176041438;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.992 -0400", hash_original_method = "76A8906A7EAF6555F7630460CE48F340", hash_generated_method = "47DA01E6D2C2FE601BBA94AAF0DEE712")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mAction);
        dest.writeFloat(mX);
        dest.writeFloat(mY);
        dest.writeInt(mDragResult ? 1 : 0);
        {
            dest.writeInt(0);
        } 
        {
            dest.writeInt(1);
            mClipData.writeToParcel(dest, flags);
        } 
        {
            dest.writeInt(0);
        } 
        {
            dest.writeInt(1);
            mClipDescription.writeToParcel(dest, flags);
        } 
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
        
        
        
        
            
        
            
            
        
        
            
        
            
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.993 -0400", hash_original_field = "72335DCE9A3EDFEDA119916AF8BD9A52", hash_generated_field = "FA3C17D544830BC1BEE55D29729BDFE3")

    private static final boolean TRACK_RECYCLED_LOCATION = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.993 -0400", hash_original_field = "4E0EEF34DE1E78AC4C7D48E7B28D3753", hash_generated_field = "632CD138CDBCADE9A63F9B23105E1648")

    private static final int MAX_RECYCLED = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.993 -0400", hash_original_field = "79F53341661E7BAB58D441DAC7E61782", hash_generated_field = "4D2E3DEDF37103D77BF3BB46692742C8")

    private static final Object gRecyclerLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.993 -0400", hash_original_field = "1FAF82F0D29F5620113F4616D8100881", hash_generated_field = "30BDE92582307BB3C881F079E40B027E")

    private static int gRecyclerUsed = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.993 -0400", hash_original_field = "DF80F2ECB31681324387DEF5FEFE2FE7", hash_generated_field = "54939BC72968A690F365D294718CA089")

    private static DragEvent gRecyclerTop = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.993 -0400", hash_original_field = "A58BF3C9D1B1D58A42A20E0A5F5623EE", hash_generated_field = "9524B5F8800D40CC69498D08D923BFBF")

    public static final int ACTION_DRAG_STARTED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.993 -0400", hash_original_field = "875DBF6C097D581DE69897016F116E19", hash_generated_field = "635B00DA4FB3397490378FAA504497FE")

    public static final int ACTION_DRAG_LOCATION = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.993 -0400", hash_original_field = "47A7292F7E0F63535470A90726CEC868", hash_generated_field = "517C92CD125E84179A11296F5B7F6A0A")

    public static final int ACTION_DROP = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.993 -0400", hash_original_field = "8521531CFF5F561AE6190E18070025E9", hash_generated_field = "323D0EABB0B88FB8587CDDBD8F8D2FE5")

    public static final int ACTION_DRAG_ENDED = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.993 -0400", hash_original_field = "172F81EA1BF1ABFE82A5D469785D02A2", hash_generated_field = "CC78BC4068CBFD6E7997C5BC4E2819F7")

    public static final int ACTION_DRAG_ENTERED = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.993 -0400", hash_original_field = "3427CA192B014A941ED7B835359FA2EE", hash_generated_field = "5957E8867F6B1B0ECE8E17A233F84AE7")

    public static final int ACTION_DRAG_EXITED = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.993 -0400", hash_original_field = "8462FFBB3C116EE5A525223AEC0039F6", hash_generated_field = "C367CE0E132A317997C32847E1BF50B0")

    public static final Parcelable.Creator<DragEvent> CREATOR =
        new Parcelable.Creator<DragEvent>() {
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

        public DragEvent[] newArray(int size) {
            return new DragEvent[size];
        }
    };
    
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
    
    
    public DragEvent[] newArray(int size) {
            return new DragEvent[size];
        }
    
}

