package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.os.IResultReceiver;

public class ResultReceiver implements Parcelable {
    boolean mLocal;
    Handler mHandler;
    IResultReceiver mReceiver;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.180 -0400", hash_original_method = "F6B889D041061686778698E3127A426F", hash_generated_method = "6F6052D4E9FCF772721E5CED0890AD00")
    @DSModeled(DSC.SAFE)
    public ResultReceiver(Handler handler) {
        dsTaint.addTaint(handler.dsTaint);
        mLocal = true;
        // ---------- Original Method ----------
        //mLocal = true;
        //mHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.182 -0400", hash_original_method = "3121A8D4339499004112052A7E531E42", hash_generated_method = "0BABE4D28586909AA9AAC94515604343")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.182 -0400", hash_original_method = "09F6E48395AF4822069195CE0B4A582F", hash_generated_method = "09616DB726E41BEA6D4C41C6A2C9DF0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.183 -0400", hash_original_method = "BDE6DE984C100A6F17C2FEFAD669078A", hash_generated_method = "76307C5EA4DFF79E935B0DCB79A2B347")
    @DSModeled(DSC.SAFE)
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(resultData.dsTaint);
        dsTaint.addTaint(resultCode);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.183 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.183 -0400", hash_original_method = "E9FDB79317602314EF1A33B246E828FD", hash_generated_method = "2A51B121B649C236F057707CA550BBD8")
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
        int mResultCode;
        Bundle mResultData;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.184 -0400", hash_original_method = "B34498DE61E9C5C61C7671D4F0FD5B9A", hash_generated_method = "E2857C81885BF19D5293F20CFBA84610")
        @DSModeled(DSC.SAFE)
         MyRunnable(int resultCode, Bundle resultData) {
            dsTaint.addTaint(resultData.dsTaint);
            dsTaint.addTaint(resultCode);
            // ---------- Original Method ----------
            //mResultCode = resultCode;
            //mResultData = resultData;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.184 -0400", hash_original_method = "B2EEF2B3DE60D5C6AF2898B6D426B2C7", hash_generated_method = "CE9FA5919F14757E6813C53A6BF42E89")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            onReceiveResult(mResultCode, mResultData);
            // ---------- Original Method ----------
            //onReceiveResult(mResultCode, mResultData);
        }

        
    }


    
    class MyResultReceiver extends IResultReceiver.Stub {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.184 -0400", hash_original_method = "A7B2CA7C370BD2A5EB04FE13F4A5CB47", hash_generated_method = "A7B2CA7C370BD2A5EB04FE13F4A5CB47")
                public MyResultReceiver ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.184 -0400", hash_original_method = "B49F987C1CD0318792118745999D9DB4", hash_generated_method = "2D116872D5A63E7EAC9F80EADFA7415B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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


    
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new Parcelable.Creator<ResultReceiver>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.184 -0400", hash_original_method = "90D8D656578FFDEDED0B312BAABC9891", hash_generated_method = "D92DD75BC45F9501B40AEBD3F68CA93E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ResultReceiver createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            ResultReceiver var8D8BA5751C56309FB851DC4E4E8F5B2C_280810632 = (new ResultReceiver(in));
            return (ResultReceiver)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ResultReceiver(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.185 -0400", hash_original_method = "9A50003BF7D81A82F5D7809D6B7D611A", hash_generated_method = "775379F66222DFBFF5B448C80250E37D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ResultReceiver[] newArray(int size) {
            dsTaint.addTaint(size);
            ResultReceiver[] var5D325FC5C92EDC6970401C2BD65B0032_963526676 = (new ResultReceiver[size]);
            return (ResultReceiver[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ResultReceiver[size];
        }

        
}; //Transformed anonymous class
}

