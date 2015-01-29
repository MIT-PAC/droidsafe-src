package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import com.android.internal.os.IResultReceiver;

public class ResultReceiver implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.530 -0400", hash_original_field = "1616AC5A23A35716E8AC81C303077CDC", hash_generated_field = "7C3C665B8D40A2CCD87F8A835E2FE4A9")

    public static final Parcelable.Creator<ResultReceiver> CREATOR
            = new Parcelable.Creator<ResultReceiver>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.388 -0500", hash_original_method = "90D8D656578FFDEDED0B312BAABC9891", hash_generated_method = "498C30F1A4DD7912BEB39B6F963CC566")
        
public ResultReceiver createFromParcel(Parcel in) {
            return new ResultReceiver(in);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.391 -0500", hash_original_method = "9A50003BF7D81A82F5D7809D6B7D611A", hash_generated_method = "684217CB1724BD34053119CB56A9F700")
        
public ResultReceiver[] newArray(int size) {
            return new ResultReceiver[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.351 -0500", hash_original_field = "0415A6A03CA0C2158681D2FE07F934C8", hash_generated_field = "0415A6A03CA0C2158681D2FE07F934C8")

     boolean mLocal;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.353 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "A163099B522120C606A3CA562F90E927")

     Handler mHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.355 -0500", hash_original_field = "D7B90760A7F6237C1A31E420E3CA0A2C", hash_generated_field = "D7B90760A7F6237C1A31E420E3CA0A2C")
    
    IResultReceiver mReceiver;
    
    /**
     * Create a new ResultReceive to receive results.  Your
     * {@link #onReceiveResult} method will be called from the thread running
     * <var>handler</var> if given, or from an arbitrary thread if null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.374 -0500", hash_original_method = "F6B889D041061686778698E3127A426F", hash_generated_method = "687E9477B129D47D7715CEB8FA2DD56A")
    
public ResultReceiver(Handler handler) {
        mLocal = true;
        mHandler = handler;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.385 -0500", hash_original_method = "3121A8D4339499004112052A7E531E42", hash_generated_method = "3121A8D4339499004112052A7E531E42")
    
ResultReceiver(Parcel in) {
        mLocal = false;
        mHandler = null;
        mReceiver = IResultReceiver.Stub.asInterface(in.readStrongBinder());
    }
    
    /**
     * Deliver a result to this receiver.  Will call {@link #onReceiveResult},
     * always asynchronously if the receiver has supplied a Handler in which
     * to dispatch the result.
     * @param resultCode Arbitrary result code to deliver, as defined by you.
     * @param resultData Any additional data provided by you.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.376 -0500", hash_original_method = "09F6E48395AF4822069195CE0B4A582F", hash_generated_method = "A333E88D55493381E6E2689B194132B6")
    
public void send(int resultCode, Bundle resultData) {
        if (mLocal) {
            if (mHandler != null) {
                mHandler.post(new MyRunnable(resultCode, resultData));
            } else {
                onReceiveResult(resultCode, resultData);
            }
            return;
        }
        
        if (mReceiver != null) {
            try {
                mReceiver.send(resultCode, resultData);
            } catch (RemoteException e) {
            }
        }
    }
    
    /**
     * Override to receive results delivered to this object.
     * 
     * @param resultCode Arbitrary result code delivered by the sender, as
     * defined by the sender.
     * @param resultData Any additional data provided by the sender.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.378 -0500", hash_original_method = "BDE6DE984C100A6F17C2FEFAD669078A", hash_generated_method = "3A7CFAD59FE93F9154FF15BC28A864B1")
    
protected void onReceiveResult(int resultCode, Bundle resultData) {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.380 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }
    
    class MyRunnable implements Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.358 -0500", hash_original_field = "457E6BFD9A88F809DF3F4A88B9B7B893", hash_generated_field = "457E6BFD9A88F809DF3F4A88B9B7B893")

         int mResultCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.360 -0500", hash_original_field = "08871BAB4B6098F90F767BAD821733ED", hash_generated_field = "08871BAB4B6098F90F767BAD821733ED")

         Bundle mResultData;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.363 -0500", hash_original_method = "B34498DE61E9C5C61C7671D4F0FD5B9A", hash_generated_method = "B34498DE61E9C5C61C7671D4F0FD5B9A")
        
MyRunnable(int resultCode, Bundle resultData) {
            mResultCode = resultCode;
            mResultData = resultData;
        }
        
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.366 -0500", hash_original_method = "B2EEF2B3DE60D5C6AF2898B6D426B2C7", hash_generated_method = "6E53CBE876D163AADF4FBFF07A5EA5E1")
        
public void run() {
            onReceiveResult(mResultCode, mResultData);
        }
        
    }
    
    class MyResultReceiver extends IResultReceiver.Stub {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.529 -0400", hash_original_method = "00E32356C88F444E6F526AF010826911", hash_generated_method = "00E32356C88F444E6F526AF010826911")
        public MyResultReceiver ()
        {
            //Synthesized constructor
        }
        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.370 -0500", hash_original_method = "B49F987C1CD0318792118745999D9DB4", hash_generated_method = "EFA6E027AB4269A27354DDE7D386BD63")
        
public void send(int resultCode, Bundle resultData) {
            if (mHandler != null) {
                mHandler.post(new MyRunnable(resultCode, resultData));
            } else {
                onReceiveResult(resultCode, resultData);
            }
        }
        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:39.383 -0500", hash_original_method = "E9FDB79317602314EF1A33B246E828FD", hash_generated_method = "E1AC36E729C5B6E254B828EDEB9DC17E")
    
public void writeToParcel(Parcel out, int flags) {
        synchronized (this) {
            if (mReceiver == null) {
                mReceiver = new MyResultReceiver();
            }
            out.writeStrongBinder(mReceiver.asBinder());
        }
    }
    // orphaned legacy method
    public ResultReceiver createFromParcel(Parcel in) {
            return new ResultReceiver(in);
        }
    
    // orphaned legacy method
    public ResultReceiver[] newArray(int size) {
            return new ResultReceiver[size];
        }
    
}

