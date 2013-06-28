package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.os.IResultReceiver;

public class ResultReceiver implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.113 -0400", hash_original_field = "C9B888E88FFB6944F562FB3344471686", hash_generated_field = "0415A6A03CA0C2158681D2FE07F934C8")

    boolean mLocal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.113 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "A163099B522120C606A3CA562F90E927")

    Handler mHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.113 -0400", hash_original_field = "572851143F58D86B2089A8B56ED682F4", hash_generated_field = "D7B90760A7F6237C1A31E420E3CA0A2C")

    IResultReceiver mReceiver;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.114 -0400", hash_original_method = "F6B889D041061686778698E3127A426F", hash_generated_method = "9EC98A0FD32D2D22D47B3302A864F62A")
    public  ResultReceiver(Handler handler) {
        mLocal = true;
        mHandler = handler;
        // ---------- Original Method ----------
        //mLocal = true;
        //mHandler = handler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.114 -0400", hash_original_method = "3121A8D4339499004112052A7E531E42", hash_generated_method = "239099E3C61F4A2E3E14A5749C655A8D")
      ResultReceiver(Parcel in) {
        mLocal = false;
        mHandler = null;
        mReceiver = IResultReceiver.Stub.asInterface(in.readStrongBinder());
        // ---------- Original Method ----------
        //mLocal = false;
        //mHandler = null;
        //mReceiver = IResultReceiver.Stub.asInterface(in.readStrongBinder());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.114 -0400", hash_original_method = "09F6E48395AF4822069195CE0B4A582F", hash_generated_method = "0B94CE0BE14F0AF4603560530456DA8A")
    public void send(int resultCode, Bundle resultData) {
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
        addTaint(resultCode);
        addTaint(resultData.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.115 -0400", hash_original_method = "BDE6DE984C100A6F17C2FEFAD669078A", hash_generated_method = "228AE6C9966C94D839DBDEFCF2C90EF6")
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(resultCode);
        addTaint(resultData.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.115 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "B49EA032408F97928FA3166A15946224")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1893308297 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1893308297;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.116 -0400", hash_original_method = "E9FDB79317602314EF1A33B246E828FD", hash_generated_method = "C56E1DD0ECA2D593EDDBD50CA765B8F8")
    public void writeToParcel(Parcel out, int flags) {
        {
            {
                mReceiver = new MyResultReceiver();
            } //End block
            out.writeStrongBinder(mReceiver.asBinder());
        } //End block
        addTaint(out.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mReceiver == null) {
                //mReceiver = new MyResultReceiver();
            //}
            //out.writeStrongBinder(mReceiver.asBinder());
        //}
    }

    
    class MyRunnable implements Runnable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.116 -0400", hash_original_field = "E5CED19E692744D577EC9F38B767773F", hash_generated_field = "457E6BFD9A88F809DF3F4A88B9B7B893")

        int mResultCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.116 -0400", hash_original_field = "3EAEFB392DB2F84FAED87A71E79A1093", hash_generated_field = "08871BAB4B6098F90F767BAD821733ED")

        Bundle mResultData;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.116 -0400", hash_original_method = "B34498DE61E9C5C61C7671D4F0FD5B9A", hash_generated_method = "61C9E11FE1C79EE24D194073B7E05D28")
          MyRunnable(int resultCode, Bundle resultData) {
            mResultCode = resultCode;
            mResultData = resultData;
            // ---------- Original Method ----------
            //mResultCode = resultCode;
            //mResultData = resultData;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.117 -0400", hash_original_method = "B2EEF2B3DE60D5C6AF2898B6D426B2C7", hash_generated_method = "CE9FA5919F14757E6813C53A6BF42E89")
        public void run() {
            onReceiveResult(mResultCode, mResultData);
            // ---------- Original Method ----------
            //onReceiveResult(mResultCode, mResultData);
        }

        
    }


    
    class MyResultReceiver extends IResultReceiver.Stub {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.117 -0400", hash_original_method = "00E32356C88F444E6F526AF010826911", hash_generated_method = "00E32356C88F444E6F526AF010826911")
        public MyResultReceiver ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.118 -0400", hash_original_method = "B49F987C1CD0318792118745999D9DB4", hash_generated_method = "711BB9BF5D076CE18314AD3F3B4FDFA3")
        public void send(int resultCode, Bundle resultData) {
            {
                mHandler.post(new MyRunnable(resultCode, resultData));
            } //End block
            {
                onReceiveResult(resultCode, resultData);
            } //End block
            addTaint(resultCode);
            addTaint(resultData.getTaint());
            // ---------- Original Method ----------
            //if (mHandler != null) {
                //mHandler.post(new MyRunnable(resultCode, resultData));
            //} else {
                //onReceiveResult(resultCode, resultData);
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.118 -0400", hash_original_field = "1616AC5A23A35716E8AC81C303077CDC", hash_generated_field = "7C3C665B8D40A2CCD87F8A835E2FE4A9")

    public static final Parcelable.Creator<ResultReceiver> CREATOR
            = new Parcelable.Creator<ResultReceiver>() {
        public ResultReceiver createFromParcel(Parcel in) {
            return new ResultReceiver(in);
        }
        public ResultReceiver[] newArray(int size) {
            return new ResultReceiver[size];
        }
    };
    // orphaned legacy method
    public ResultReceiver createFromParcel(Parcel in) {
            return new ResultReceiver(in);
        }
    
    // orphaned legacy method
    public ResultReceiver[] newArray(int size) {
            return new ResultReceiver[size];
        }
    
}

