package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import com.android.internal.os.IResultReceiver;

public class ResultReceiver implements Parcelable {
    final boolean mLocal;
    final Handler mHandler;
    IResultReceiver mReceiver;
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new Parcelable.Creator<ResultReceiver>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.867 -0400", hash_original_method = "90D8D656578FFDEDED0B312BAABC9891", hash_generated_method = "7756034FF43302352924E15060BBBC23")
        @DSModeled(DSC.SAFE)
        public ResultReceiver createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            return (ResultReceiver)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ResultReceiver(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.867 -0400", hash_original_method = "9A50003BF7D81A82F5D7809D6B7D611A", hash_generated_method = "7A106B491B8ABF920017535FA4D69750")
        @DSModeled(DSC.SAFE)
        public ResultReceiver[] newArray(int size) {
            dsTaint.addTaint(size);
            return (ResultReceiver[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ResultReceiver[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.867 -0400", hash_original_method = "F6B889D041061686778698E3127A426F", hash_generated_method = "2F24DE909A14BE384097F3DFDA4DD141")
    @DSModeled(DSC.SAFE)
    public ResultReceiver(Handler handler) {
        dsTaint.addTaint(handler.dsTaint);
        mLocal = true;
        // ---------- Original Method ----------
        //mLocal = true;
        //mHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.867 -0400", hash_original_method = "3121A8D4339499004112052A7E531E42", hash_generated_method = "44E6D541E02CDCDBFB4DC6863E623B48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ResultReceiver(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        mLocal = false;
        mHandler = null;
        mReceiver = IResultReceiver.Stub.asInterface(in.readStrongBinder());
        // ---------- Original Method ----------
        //mLocal = false;
        //mHandler = null;
        //mReceiver = IResultReceiver.Stub.asInterface(in.readStrongBinder());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.868 -0400", hash_original_method = "09F6E48395AF4822069195CE0B4A582F", hash_generated_method = "9E95D28F300AA7A916A4BFEA6C75DCCB")
    @DSModeled(DSC.SAFE)
    public void send(int resultCode, Bundle resultData) {
        dsTaint.addTaint(resultData.dsTaint);
        dsTaint.addTaint(resultCode);
        {
            {
                mHandler.post(new MyRunnable(resultCode, resultData));
            } //End block
            {
                onReceiveResult(resultCode, resultData);
            } //End block
        } //End block
        {
            try 
            {
                mReceiver.send(resultCode, resultData);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        // ---------- Original Method ----------
        //if (mLocal) {
            //if (mHandler != null) {
                //mHandler.post(new MyRunnable(resultCode, resultData));
            //} else {
                //onReceiveResult(resultCode, resultData);
            //}
            //return;
        //}
        //if (mReceiver != null) {
            //try {
                //mReceiver.send(resultCode, resultData);
            //} catch (RemoteException e) {
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.868 -0400", hash_original_method = "BDE6DE984C100A6F17C2FEFAD669078A", hash_generated_method = "B6BD7235AA9F7B9DBA6F08576C48860C")
    @DSModeled(DSC.SAFE)
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(resultData.dsTaint);
        dsTaint.addTaint(resultCode);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.868 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.868 -0400", hash_original_method = "E9FDB79317602314EF1A33B246E828FD", hash_generated_method = "5B110928A89254A24EC7EB8FBCFB5ED6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
        {
            {
                mReceiver = new MyResultReceiver();
            } //End block
            out.writeStrongBinder(mReceiver.asBinder());
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mReceiver == null) {
                //mReceiver = new MyResultReceiver();
            //}
            //out.writeStrongBinder(mReceiver.asBinder());
        //}
    }

    
    class MyRunnable implements Runnable {
        final int mResultCode;
        final Bundle mResultData;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.868 -0400", hash_original_method = "B34498DE61E9C5C61C7671D4F0FD5B9A", hash_generated_method = "573D9529391BF8CE89747046181871C9")
        @DSModeled(DSC.SAFE)
         MyRunnable(int resultCode, Bundle resultData) {
            dsTaint.addTaint(resultData.dsTaint);
            dsTaint.addTaint(resultCode);
            // ---------- Original Method ----------
            //mResultCode = resultCode;
            //mResultData = resultData;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.868 -0400", hash_original_method = "B2EEF2B3DE60D5C6AF2898B6D426B2C7", hash_generated_method = "7726CE83497707B26880B809FBF6C248")
        @DSModeled(DSC.SAFE)
        public void run() {
            onReceiveResult(mResultCode, mResultData);
            // ---------- Original Method ----------
            //onReceiveResult(mResultCode, mResultData);
        }

        
    }


    
    class MyResultReceiver extends IResultReceiver.Stub {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.868 -0400", hash_original_method = "B49F987C1CD0318792118745999D9DB4", hash_generated_method = "BD805F1B724563BF512990CB13ABEDF1")
        @DSModeled(DSC.SAFE)
        public void send(int resultCode, Bundle resultData) {
            dsTaint.addTaint(resultData.dsTaint);
            dsTaint.addTaint(resultCode);
            {
                mHandler.post(new MyRunnable(resultCode, resultData));
            } //End block
            {
                onReceiveResult(resultCode, resultData);
            } //End block
            // ---------- Original Method ----------
            //if (mHandler != null) {
                //mHandler.post(new MyRunnable(resultCode, resultData));
            //} else {
                //onReceiveResult(resultCode, resultData);
            //}
        }

        
    }


    
}


